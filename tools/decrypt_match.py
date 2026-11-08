#!/usr/bin/env python3
"""Match captured AES bodies to plaintext rows in the local dmregister table.

The extractor now reports incomplete flows and rejects truncated HTTP bodies.
A "no local match" result is *not* evidence that the server accepted the
request: it can be queue eviction, capture truncation, reassembly error, or a
different plaintext source.
"""

import hashlib
import json
import os
import re
import sqlite3
import subprocess
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import pcap_tcp as P


def requests(buf):
    out = []
    while True:
        h = buf.find(b"POST /register")
        if h < 0:
            break
        he = buf.find(b"\r\n\r\n", h)
        if he < 0:
            break
        head = buf[h:he].decode("latin1")
        lengths = []
        unsupported_encoding = False
        for line in head.split("\r\n"):
            if line.lower().startswith("content-length:"):
                lengths.append(line.split(":", 1)[1].strip())
            if line.lower().startswith("transfer-encoding:"):
                unsupported_encoding = True
        if (unsupported_encoding or len(lengths) != 1
                or re.fullmatch(r"[0-9]+", lengths[0]) is None):
            print("       ! invalid/duplicate Content-Length or unsupported Transfer-Encoding; stop parsing this flow")
            break
        try:
            cl = int(lengths[0])
        except ValueError:
            print("       ! Content-Length exceeds parser limits; stop parsing this flow")
            break
        body = buf[he + 4 : he + 4 + cl]
        if len(body) < cl:
            print(
                f"       ! truncated HTTP body: declared={cl} got={len(body)}; "
                "skip (not treated as a complete request)"
            )
            break
        out.append((head, body))
        buf = buf[he + 4 + cl :]
    return out


def main(pcap, dbfile):
    con = sqlite3.connect(dbfile)
    rows = [(i, s.encode()) for i, s in con.execute("select ID,jsonString from dmregister")]
    seen = set()

    for k, d, buf, ts, complete, missing in P.extract_port(pcap, 18080):
        if d != "c2s":
            continue
        print("=" * 78)
        print(f"[流] {k} complete={complete} missing={missing} len={len(buf)}")
        if not complete:
            print("       ! incomplete/ambiguous flow; skip plaintext matching (gap fillers are not evidence)")
            continue
        for head, body in requests(buf):
            line = head.split("\r\n")[0]
            print(f"[请求] ts={ts:.0f}  {line.split('?')[0]}")
            print(f"       ciphertext = {len(body)} bytes, head={body[:16].hex()}")
            if body in seen:
                print("       (与前面重复)")
            seen.add(body)
            hit = None
            for rid, pt in rows:
                key = hashlib.md5(pt).hexdigest()
                enc = subprocess.run(
                    ["openssl", "enc", "-aes-128-ecb", "-K", key],
                    input=pt,
                    capture_output=True,
                    check=True,
                ).stdout
                if enc == body:
                    hit = (rid, pt, key)
                    break
            if hit:
                rid, pt, key = hit
                dec = subprocess.run(
                    [
                        "openssl",
                        "enc",
                        "-d",
                        "-aes-128-ecb",
                        "-K",
                        key,
                        "-in",
                        "/dev/stdin",
                    ],
                    input=body,
                    capture_output=True,
                    check=True,
                ).stdout
                print(f"       ✔ 命中本地队列 ID={rid}, AES key=MD5(明文)={key}")
                print("       ✔ 解密成功，明文如下：")
                try:
                    print(json.dumps(json.loads(dec), ensure_ascii=False, indent=1))
                except Exception:
                    print(dec.decode("utf-8", "replace"))
            else:
                print(
                    "       ✘ 未在本地队列找到对应明文；不能据此判断该请求已成功。"
                    "可能是队列淘汰、取证时序不同、抓包截断/重组错误或明文来源不对应。"
                )

    for k, d, buf, ts, complete, missing in P.extract_port(pcap, 18080):
        if d != "s2c":
            continue
        m = buf.find(b"HTTP/1.1")
        if m >= 0:
            print("-" * 78)
            print(
                "[响应] "
                + buf[m : m + 120].decode("latin1", "replace").split("\r\n")[0]
                + f"  (complete={complete}, missing={missing})"
            )


if __name__ == "__main__":
    main(sys.argv[1], sys.argv[2])
