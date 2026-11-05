#!/usr/bin/env python3
import sys, sqlite3, hashlib, subprocess, json, os

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import pcap_tcp as P
from collections import defaultdict

def extract_port(fn, port):
    link, pkts = P.parse_pcap(fn)
    flows = defaultdict(lambda: {'c2s': [], 's2c': []})
    for ts, data in pkts:
        proto, p = P.l3(link, data)
        ver, prot, src, dst, seg = P.parse_ip(proto, p)
        if prot != 6 or len(seg) < 20:
            continue
        sp, dp, seq, ack, flags, payload = P.tcp(seg)
        if dp == port:
            flows[(src, sp, dst, dp)]['c2s'].append((seq, payload, ts))
        elif sp == port:
            flows[(src, sp, dst, dp)]['s2c'].append((seq, payload, ts))
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

def requests(buf):
    out = []
    while True:
        h = buf.find(b'POST /register')
        if h < 0:
            break
        he = buf.find(b'\r\n\r\n', h)
        if he < 0:
            break
        head = buf[h:he].decode('latin1')
        cl = 0
        for line in head.split('\r\n'):
            if line.lower().startswith('content-length:'):
                cl = int(line.split(':')[1])
        body = buf[he+4:he+4+cl]
        out.append((head, body))
        buf = buf[he+4+cl:]
    return out

def main(pcap, dbfile):
    con = sqlite3.connect(dbfile)
    rows = [(i, s.encode()) for i, s in con.execute("select ID,jsonString from dmregister")]
    seen = set()
    for k, d, buf, ts in extract_port(pcap, 18080):
        if d != 'c2s':
            continue
        for head, body in requests(buf):
            line = head.split('\r\n')[0]
            print('=' * 78)
            print(f"[请求] ts={ts:.0f}  {line.split('?')[0]}")
            print(f"       ciphertext = {len(body)} bytes, head={body[:16].hex()}")
            if body in seen:
                print("       (与前面重复)")
            seen.add(body)
            hit = None
            for rid, pt in rows:
                key = hashlib.md5(pt).hexdigest()
                enc = subprocess.run(['openssl', 'enc', '-aes-128-ecb', '-K', key],
                                     input=pt, capture_output=True).stdout
                if enc == body:
                    hit = (rid, pt, key)
                    break
            if hit:
                rid, pt, key = hit
                dec = subprocess.run(['openssl', 'enc', '-d', '-aes-128-ecb', '-K', key, '-in', '/dev/stdin'],
                                     input=body, capture_output=True).stdout
                print(f"       ✔ 命中本地队列 ID={rid}, AES key=MD5(明文)={key}")
                print("       ✔ 解密成功，明文如下：")
                try:
                    print(json.dumps(json.loads(dec), ensure_ascii=False, indent=1))
                except Exception:
                    print(dec.decode('utf-8', 'replace'))
            else:
                print("       �’ 未在本地队列找到对应明文（说明这是一条已成功发出的新数据）")
        # response
    for k, d, buf, ts in extract_port(pcap, 18080):
        if d == 's2c':
            m = buf.find(b'HTTP/1.1')
            if m >= 0:
                print('-' * 78)
                print("[响应] " + buf[m:m+120].decode('latin1', 'replace').split('\r\n')[0])

if __name__ == '__main__':
    main(sys.argv[1], sys.argv[2])
