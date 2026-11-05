#!/usr/bin/env python3
import struct, sys, hashlib
from collections import defaultdict

def parse_pcap(fn):
    d = open(fn, 'rb').read()
    magic = struct.unpack('<I', d[:4])[0]
    assert magic == 0xa1b2c3d4, hex(magic)
    off = 24
    link = struct.unpack('<I', d[20:24])[0]
    pkts = []
    while off + 16 <= len(d):
        ts, us, incl, orig = struct.unpack('<IIII', d[off:off+16])
        off += 16
        data = d[off:off+incl]
        off += incl
        pkts.append((ts + us/1e6, data))
    return link, pkts

def l3(link, data):
    if link == 276:  # LINUX_SLL2
        proto = struct.unpack('>H', data[0:2])[0]
        return proto, data[20:]
    if link == 113:  # LINUX_SLL
        proto = struct.unpack('>H', data[14:16])[0]
        return proto, data[16:]
    if link == 1:    # Ethernet
        et = struct.unpack('>H', data[12:14])[0]
        return et, data[14:]
    return None, data

def parse_ip(proto, p):
    if proto == 0x0800:
        if len(p) < 20:
            return None, None, None, None, b''
        ihl = (p[0] & 0xf) * 4
        prot = p[9]
        src = '.'.join(map(str, p[12:16])); dst = '.'.join(map(str, p[16:20]))
        return 4, prot, src, dst, p[ihl:]
    if proto == 0x86dd:
        if len(p) < 40:
            return None, None, None, None, b''
        nxt = p[6]
        src = ':'.join('%02x' % b for b in p[8:24]); dst = ':'.join('%02x' % b for b in p[24:40])
        return 6, nxt, src, dst, p[40:]
    return None, None, None, None, b''

def tcp(p):
    sp, dp, seq, ack = struct.unpack('>HHII', p[:12])
    doff = (p[12] >> 4) * 4
    flags = p[13]
    return sp, dp, seq, ack, flags, p[doff:]

def extract(fn, peer_ip, peer_port):
    link, pkts = parse_pcap(fn)
    flows = defaultdict(lambda: {'c2s': [], 's2c': []})
    for ts, data in pkts:
        proto, p = l3(link, data)
        ver, prot, src, dst, seg = parse_ip(proto, p)
        if prot != 6:
            continue
        sp, dp, seq, ack, flags, payload = tcp(seg)
        if dst == peer_ip and dp == peer_port:
            flows[(src, sp)]['c2s'].append((seq, payload, ts))
        elif src == peer_ip and sp == peer_port:
            flows[(dst, dp)]['s2c'].append((seq, payload, ts))
    out = []
    for k, f in flows.items():
        for direction in ('c2s', 's2c'):
            segs = f[direction]
            if not segs:
                continue
            segs.sort(key=lambda x: x[2])
            base = segs[0][0]
            buf = bytearray()
            for seq, payload, ts in segs:
                if not payload:
                    continue
                rel = (seq - base) & 0xffffffff
                if rel > 2_000_000:
                    rel -= 0x100000000
                if rel > len(buf):
                    buf.extend(b'\0' * (rel - len(buf)))
                buf[rel:rel+len(payload)] = payload
            out.append((k, direction, bytes(buf), segs[0][2]))
    return out

if __name__ == '__main__':
    fn = sys.argv[1]
    ip = sys.argv[2]
    port = int(sys.argv[3])
    for k, direction, buf, ts in extract(fn, ip, port):
        print('=' * 70)
        print(f'flow {k} {direction} ts={ts:.3f} len={len(buf)}')
        print(buf[:2000].decode('utf-8', 'replace'))
