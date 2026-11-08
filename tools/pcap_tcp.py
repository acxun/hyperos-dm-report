#!/usr/bin/env python3
"""Minimal TCP stream extractor for the report's pcap samples.

The tool is intentionally small.  It now keeps explicit completeness state:
- SYN consumes one sequence number; payload after SYN starts at seq+1.
- Missing bytes are reported as incomplete instead of silently looking valid.
- IPv4/IPv6 addresses are rendered with the standard library's compressed form.

It is *not* a general-purpose TCP reassembler: out-of-order/retransmission
handling is best-effort, IPv6 extension headers are not parsed, and capture
truncation is reported only as far as the captured bytes allow.
"""

import ipaddress
import struct
import sys
from collections import defaultdict


def parse_pcap(fn):
    d = open(fn, "rb").read()
    magic = struct.unpack("<I", d[:4])[0]
    if magic != 0xA1B2C3D4:
        raise ValueError(f"unsupported pcap magic: {magic:#x}")
    off = 24
    link = struct.unpack("<I", d[20:24])[0]
    pkts = []
    while off + 16 <= len(d):
        ts, us, incl, orig = struct.unpack("<IIII", d[off : off + 16])
        off += 16
        data = d[off : off + incl]
        off += incl
        pkts.append((ts + us / 1e6, data))
    return link, pkts


def l3(link, data):
    if link == 276:  # LINUX_SLL2
        proto = struct.unpack(">H", data[0:2])[0]
        return proto, data[20:]
    if link == 113:  # LINUX_SLL
        proto = struct.unpack(">H", data[14:16])[0]
        return proto, data[16:]
    if link == 1:  # Ethernet
        et = struct.unpack(">H", data[12:14])[0]
        return et, data[14:]
    return None, data


def parse_ip(proto, p):
    if proto == 0x0800:
        if len(p) < 20:
            return None, None, None, None, b""
        ihl = (p[0] & 0xF) * 4
        prot = p[9]
        src = str(ipaddress.IPv4Address(p[12:16]))
        dst = str(ipaddress.IPv4Address(p[16:20]))
        return 4, prot, src, dst, p[ihl:]
    if proto == 0x86DD:
        if len(p) < 40:
            return None, None, None, None, b""
        nxt = p[6]
        src = str(ipaddress.IPv6Address(p[8:24]))
        dst = str(ipaddress.IPv6Address(p[24:40]))
        return 6, nxt, src, dst, p[40:]
    return None, None, None, None, b""


def tcp(p):
    sp, dp, seq, ack = struct.unpack(">HHII", p[:12])
    doff = (p[12] >> 4) * 4
    flags = p[13]
    return sp, dp, seq, ack, flags, p[doff:]


def reassemble(segments):
    """Reassemble one direction.

    segments: list of (seq, payload, ts, flags)
    returns: (buf, complete, missing_bytes)

    complete describes coverage and consistent overlaps within the observed
    sequence range only, not completeness of the connection or capture.
    Sequence offsets use TCP's signed half-range ordering. Ranges over 16 MiB
    are rejected rather than allocating unbounded memory for malformed input.
    """
    payload_segments = [s for s in segments if s[1]]
    if not payload_segments:
        return b"", True, 0

    syn = next((s for s in segments if s[3] & 0x02), None)
    if syn is not None:
        base = (syn[0] + 1) & 0xFFFFFFFF
    else:
        base = payload_segments[0][0]

    def relative(seq):
        return ((seq - base + 0x80000000) & 0xFFFFFFFF) - 0x80000000

    pieces = []
    for seq, payload, ts, flags in payload_segments:
        seq_eff = (seq + (1 if flags & 0x02 else 0)) & 0xFFFFFFFF
        pieces.append((relative(seq_eff), payload))

    # Without a SYN, the first arriving payload need not be earliest in sequence.
    shift = min(rel for rel, _ in pieces) if syn is None else 0
    pieces = [(rel - shift, payload) for rel, payload in pieces]
    discarded = any(rel < 0 for rel, _ in pieces)
    pieces = [(max(0, rel), payload[max(0, -rel):]) for rel, payload in pieces
              if rel + len(payload) > 0]

    if not pieces:
        return b"", not discarded, 0

    end = max(rel + len(payload) for rel, payload in pieces)
    if end > 16 * 1024 * 1024:
        raise ValueError("TCP observed sequence range exceeds 16 MiB limit")
    buf = bytearray(end)
    covered = bytearray(end)
    conflict = False
    for rel, payload in pieces:
        n = len(payload)
        for offset, value in enumerate(payload, rel):
            if covered[offset] and buf[offset] != value:
                conflict = True
        buf[rel : rel + n] = payload
        covered[rel : rel + n] = b"\x01" * n

    missing = covered.count(0)
    return bytes(buf), missing == 0 and not conflict and not discarded, missing


def extract(fn, peer_ip, peer_port):
    link, pkts = parse_pcap(fn)
    flows = defaultdict(list)
    for ts, data in pkts:
        proto, p = l3(link, data)
        ver, prot, src, dst, seg = parse_ip(proto, p)
        if prot != 6 or len(seg) < 20:
            continue
        sp, dp, seq, ack, flags, payload = tcp(seg)
        if dst == peer_ip and dp == peer_port:
            flows[(src, sp, "c2s")].append((seq, payload, ts, flags))
        elif src == peer_ip and sp == peer_port:
            flows[(dst, dp, "s2c")].append((seq, payload, ts, flags))

    out = []
    for (peer, port, direction), segs in flows.items():
        segs.sort(key=lambda x: x[2])
        buf, complete, missing = reassemble(segs)
        out.append(((peer, port), direction, buf, segs[0][2], complete, missing))
    return out


def extract_port(fn, port):
    """Extract every flow whose source or destination port is `port`."""
    link, pkts = parse_pcap(fn)
    flows = defaultdict(list)
    for ts, data in pkts:
        proto, p = l3(link, data)
        ver, prot, src, dst, seg = parse_ip(proto, p)
        if prot != 6 or len(seg) < 20:
            continue
        sp, dp, seq, ack, flags, payload = tcp(seg)
        if dp == port:
            key = (src, sp, dst, dp, "c2s")
            flows[key].append((seq, payload, ts, flags))
        elif sp == port:
            key = (src, sp, dst, dp, "s2c")
            flows[key].append((seq, payload, ts, flags))

    out = []
    for (src, sp, dst, dp, direction), segs in flows.items():
        segs.sort(key=lambda x: x[2])
        buf, complete, missing = reassemble(segs)
        out.append(
            ((src, sp, dst, dp), direction, buf, segs[0][2], complete, missing)
        )
    return out


if __name__ == "__main__":
    fn = sys.argv[1]
    ip = sys.argv[2]
    port = int(sys.argv[3])
    for k, direction, buf, ts, complete, missing in extract(fn, ip, port):
        print("=" * 70)
        print(
            f"flow {k} {direction} ts={ts:.3f} len={len(buf)} "
            f"complete={complete} missing={missing}"
        )
        print(buf[:2000].decode("utf-8", "replace"))
