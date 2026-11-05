# Changelog

## v1.0 — 2026-11-05

### Added
- 公开版报告 `docs/report_public.md`（脱敏）
- 内部版报告 `private/report_internal.md`（不入库）
- 已知缺口 `docs/gaps.md`
- IOC 清单 `docs/iocs.md`
- 工具：`tools/pcap_tcp.py`、`tools/decrypt_match.py`
- 脱敏样本：`evidence/redacted/*.json`

### Findings
- 确认 `com.mobiletools.systemhelper` 通过 HTTP 18080 上报，AES-128-ECB + `key=MD5(明文)`。
- 确认 `com.miui.dmregservice` 通过 HTTPS 443 上报，采集 447 App / 393 预装清单。
- 确认 `MiSight` root 守护进程与 OneCloud 端点。
- 确认反诈库仅本地写入，AI 通话防诈关闭。
- 实测解密：B（1,024 B）、R（68,784 B，100 条记录）成功；A（40,464 B）为 200 OK，本地无明文。
- 发现两套 DM 的无权限导出组件。

### Changed
- 无

### Known issues
- 见 `docs/gaps.md`
