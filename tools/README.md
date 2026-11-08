# tools

分析脚本，MIT License。

## pcap_tcp.py

纯 Python 的 pcap 解析与 TCP 流重组（无第三方依赖）。

支持：

- pcap 经典格式（magic `a1b2c3d4`）
- Linux SLL2（linktype 276）、SLL（113）、Ethernet（1）
- IPv4 / IPv6（不含扩展头链）
- 按四元组 + seq 重组，输出每条流的字节流与 `complete/missing` 状态
- SYN 占用一个序列号；缺口标记为 incomplete，不静默填零
- IPv4/IPv6 使用标准压缩格式；HTTP body 会校验 Content-Length

用法：

```bash
python3 pcap_tcp.py cap.pcap 223.111.128.82 18080
```

## test_pcap_tcp.py

合成输入回归测试：

```bash
python3 test_pcap_tcp.py
```

20 项检查覆盖 SYN 序列号、缺口标记、截断 HTTP、IPv6、负数/非法/重复长度、Transfer-Encoding 拒绝、零长度/流水线请求、无 SYN 简单乱序、序列号回绕、相同重传、冲突重叠及序列范围上限。

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

注意：未命中本地队列**不能**说明请求已成功发送；可能是队列淘汰、取证时序、抓包截断/重组错误或明文来源不对应。

限制：不解析 IPv6 扩展头；乱序/重传只做 best-effort；不是通用 TCP 重组器。`complete=True` 仅表示已观察序列范围内无缺口、冲突或丢弃，不证明整个连接/抓包完整；四元组复用的多个连接不分代。超过 16 MiB 的序列范围会明确拒绝；不完整/有冲突的流不进入明文匹配。HTTP 仅支持单一非负十进制 Content-Length，不处理 Transfer-Encoding。

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
