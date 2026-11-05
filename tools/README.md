# tools

分析脚本，MIT License。

## pcap_tcp.py

纯 Python 的 pcap 解析与 TCP 流重组（无第三方依赖）。

支持：

- pcap 经典格式（magic `a1b2c3d4`）
- Linux SLL2（linktype 276）、SLL（113）、Ethernet（1）
- IPv4 / IPv6（不含扩展头链）
- 按四元组 + seq 重组，输出每条流的字节流

用法：

```bash
python3 pcap_tcp.py cap.pcap 223.111.128.82 18080
```

## decrypt_match.py

从抓包中提取 `POST /register` 的 body，用本地队列明文反推 AES key 并解密。

原理：

```text
key  = MD5(UTF8(plaintext))
body = AES-128-ECB/PKCS5(plaintext, key)
```

用法：

```bash
python3 decrypt_match.py cap.pcap systemhelper.db
```

输出：

- 每个请求的密文长度与前 16 字节
- 命中队列 ID、AES key
- 解密后的 JSON
- 服务器响应码

依赖：`openssl` 命令行（用于 AES 加解密）。

## 限制

- 仅支持未分片的 TCP 流；IP 分片、IPv6 扩展头未处理。
- 仅按 `Content-Length` 解析单个/流水线 HTTP 请求。
- 需要本地明文才能解密（协议设计如此）。
