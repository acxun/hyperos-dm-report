#!/usr/bin/env python3
"""Regression checks for the pcap/decrypt helpers.

Run: python3 tools/test_pcap_tcp.py
"""

import ipaddress
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import decrypt_match as D
import pcap_tcp as P

CHECKS = 0


def check(name, condition, detail=""):
    global CHECKS
    if not condition:
        raise SystemExit(f"FAIL: {name} {detail}")
    print(f"ok: {name}")
    CHECKS += 1


def main():
    # 1. SYN consumes one sequence number; payload must not gain a leading NUL.
    buf, complete, missing = P.reassemble(
        [(100, b"", 0.0, 0x02), (101, b"ABC", 0.1, 0x18)]
    )
    check("SYN sequence handling", buf == b"ABC" and complete and missing == 0, repr(buf))

    # 2. A gap is reported, not silently filled as if complete.
    buf, complete, missing = P.reassemble(
        [(101, b"ABC", 0.0, 0x18), (107, b"XYZ", 0.1, 0x18)]
    )
    check(
        "missing bytes flagged",
        buf == b"ABC\x00\x00\x00XYZ" and (not complete) and missing == 3,
        f"{buf!r} complete={complete} missing={missing}",
    )

    # 3. Truncated HTTP body is not accepted as a complete request.
    head = b"POST /register HTTP/1.1\r\nContent-Length: 16\r\n\r\n"
    check("truncated HTTP rejected", D.requests(head + b"ABC") == [])

    # 4. IPv6 is rendered in standard compressed form.
    pkt = bytearray(40)
    pkt[0] = 0x60
    pkt[4:6] = (0).to_bytes(2, "big")
    pkt[6] = 6
    pkt[7] = 64
    pkt[8:24] = ipaddress.IPv6Address("2001:db8::1").packed
    pkt[24:40] = ipaddress.IPv6Address("2001:db8::2").packed
    ver, prot, src, dst, seg = P.parse_ip(0x86DD, bytes(pkt))
    check(
        "IPv6 formatting",
        ver == 6 and prot == 6 and src == "2001:db8::1" and dst == "2001:db8::2",
        f"{src} -> {dst}",
    )

    for value in (b"-1", b"-48", b"+1", b"1_0", b"", b"xyz"):
        request = b"POST /register HTTP/1.1\r\nContent-Length: " + value + b"\r\n\r\nABC"
        check(f"invalid length rejected {value!r}", D.requests(request) == [])

    check("duplicate lengths rejected", D.requests(
        b"POST /register HTTP/1.1\r\nContent-Length: 1\r\nContent-Length: 2\r\n\r\nAB"
    ) == [])
    check("transfer encoding rejected", D.requests(
        b"POST /register HTTP/1.1\r\nContent-Length: 1\r\nTransfer-Encoding: chunked\r\n\r\nA"
    ) == [])
    request = b"POST /register HTTP/1.1\r\nContent-Length: 3\r\n\r\nABC"
    check("pipelined requests", [body for _, body in D.requests(request * 2)] == [b"ABC", b"ABC"])
    check("zero length advances", len(D.requests(
        b"POST /register HTTP/1.1\r\nContent-Length: 0\r\n\r\n" + request
    )) == 2)

    check("no-SYN out-of-order retained", P.reassemble(
        [(104, b"DEF", 0, 0x18), (101, b"ABC", 1, 0x18)]
    ) == (b"ABCDEF", True, 0))
    check("sequence wraparound", P.reassemble(
        [(1, b"DEF", 0, 0x18), (0xFFFFFFFE, b"ABC", 1, 0x18)]
    ) == (b"ABCDEF", True, 0))
    check("identical retransmission", P.reassemble(
        [(101, b"ABC", 0, 0x18), (101, b"ABC", 1, 0x18)]
    ) == (b"ABC", True, 0))
    check("conflicting overlap marked ambiguous", not P.reassemble(
        [(101, b"ABC", 0, 0x18), (101, b"XYZ", 1, 0x18)]
    )[1])
    check("data before SYN baseline not silently complete", not P.reassemble(
        [(100, b"", 0, 0x02), (99, b"ABCD", 1, 0x18)]
    )[1])
    try:
        P.reassemble([(1, b"A", 0, 0x18), (20_000_000, b"B", 1, 0x18)])
    except ValueError:
        check("oversized sequence range rejected", True)
    else:
        check("oversized sequence range rejected", False)

    print(f"{CHECKS}/{CHECKS} checks passed")


if __name__ == "__main__":
    main()
