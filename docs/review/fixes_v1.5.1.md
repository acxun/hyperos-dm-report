# v1.5.1 剩余问题修复与验证

日期：2026-11-08。范围：修复 v1.5.0 复审中的五组剩余问题。不覆盖尚未授权/完成的真机实验，不修改原始抓包、数据库、APK；不覆盖原有反编译占位文件，另存新增证据。

## 修复结果

| 问题 | 处理 |
|---|---|
| 负数 Content-Length 导致循环不前进 | 仅接受单一非负十进制长度，拒绝负数、带符号、非法/重复长度及 Transfer-Encoding；零长度仍正确前进，新增负数及流水线回归测试 |
| 无 SYN 乱序丢数据却标 complete | 改用有符号半范围序列偏移，选取已观察范围的最早基准，支持简单乱序及回绕；冲突重叠或基准前数据被丢弃时标记不完整，超过 16 MiB 范围明确拒绝 |
| 不完整流仍参与明文匹配 | 跳过有缺口/冲突的流，不把填补字节当成原始证据；OpenSSL 调用检查退出码 |
| 3.1.4 循环证据只有占位体 | 新增 `evidence/decompiled/key/MIUIGuardProvider/defpackage/x7_o.debug.txt`，含 APK 哈希、命令、52 行逐行比对的指令级伪代码节选；保留默认 `x7.java`。明确 JADX exit=3、结构化反编译失败，未实测运行时行为 |
| AutoRegistration Manifest 缺失 | 从已留存 APK 用 JADX 1.5.6 解码，新增关键目录下 `AndroidManifest.xml`，与解码输出逐字节相同。明确 JobService 的权限保护与另两个导出组件不同 |
| 正文/摘要仍有强断言 | README、正文、摘要、缺口清单统一为“本次窗口内未观察到/事后目录为空”；不从空目录推出从未入队，不从两次 shell 安装推出所有后台/延迟链路无上报 |
| 恢复固定写 1、备份放 Download | 先记录开关与包启用状态，只按原值恢复；原键不存在时删除键恢复，缺失记录不猜测；去掉共享存储明文数据库备份命令，要求停止写入后在受保护位置制作一致性快照 |
| 发布一致性 | 版本统一 v1.5.1；关键目录 86 文件（83 Java、2 转储/伪代码、1 Manifest）；MANIFEST/SHA256SUMS 加入两项证据，重建两份 PDF |

## 验证结果

```text
python3 -B tools/test_pcap_tcp.py
20/20 checks passed

sha256sum -c evidence/SHA256SUMS
110/110 entries passed

AutoRegistration Manifest
exact byte match to fresh JADX decode

x7 debug excerpt
52 instruction lines matched fresh JADX debug output

R original pcap + local plaintext, updated tools
complete=True, missing=0
AES ciphertext exact match=68784 bytes, SigInfo=100

pdftotext -layout
dist/report_public.pdf: v1.5.1, 36 pages
dist/executive_summary.pdf: v1.5.1, 3 pages

git diff --check
passed
```

R 复核只输出匹配结果与计数，不公开标识、位置或应用清单。PDF 验证是文本/版本检查，并非逐页视觉验收。原有两个未跟踪安装器脚本未改动。

## 继续保留的缺口

- 当前 A 抓包缺匹配明文，旧 ID59 的 169 项不能替代当前闭环；B 只有历史解密记录。
- 导出组件的普通第三方应用 PoC 未完成；新增 Manifest 是静态证据，不升级为实际利用成功。
- 移动 DM 的 HTTPS 字段未解密；GuardProvider 云查字段仍为代码级，不把 DNS/SNI 当成 TLS 明文。
- AI 视频录屏上传链路仍未真机运行验证；转储不等于运行时观测。
- 服务端重放/去重/幂等、云端威胁命中、APK 片段/TLSH、其他安装路径未完成新增实测。
- `complete` 只表示选定已观察序列范围内的覆盖和一致性，不证明整个连接/抓包完整；连接四元组复用、IP 分片、IPv6 扩展头及复杂重传仍不全面支持。原有证据的完整性结论须由逐字节匹配等交叉验证支撑。

历史审查记录保持原样；本文件记录后续修复，不把历史问题描述删除或改写成当时已解决。
