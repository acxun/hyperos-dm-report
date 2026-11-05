# Changelog

## v1.2.5 — 2026-11-05

### Added
- 处置验证（实测）：
  - `operator_service_improve_plan=0` 只停联通 DM（18080 零流量），移动 DM 仍连 443。
  - `pm disable-user com.miui.dmregservice` 后无进程、无 443/5683 流量。
  - **重启验证**：禁用状态保持，无闹钟、无进程、无流量。
- `docs/report_public.md` / `private/report_internal.md` 新增「10.1 处置验证」。
- `docs/executive_summary.md` 补充移动 DM 的处置与重启结论。
- `docs/gaps.md`：P0-3、P0-4 标记为部分完成。

### Changed
- 重新生成 `dist/report_public.pdf` 与 `dist/executive_summary.pdf`。

## v1.2.4 — 2026-11-05

### Fixed
- 公开报告证据结构中的 `pcap/` 改为 `redacted/`，并注明原始 pcap 仅本地保留。
- 重新生成 `dist/report_public.pdf`。

## v1.2.3 — 2026-11-05

### Changed
- 隐私清理：从公开仓库及全部 Git 历史移除 `evidence/pcap/*.pcap`（含设备/路由器 MAC、内网 IP、DNS、时间戳）。
- `.gitignore` 不再为 `evidence/pcap/` 开例外；原始抓包仅保留在本地 `private/pcap/`。
- MANIFEST / SHA256SUMS / README 同步移除 pcap 条目。

## v1.2.2 — 2026-11-05

### Added
- 执行摘要 `docs/executive_summary.md`（2 页）
- PDF：`dist/executive_summary.pdf`、`dist/report_public.pdf`（15 页）
- 构建脚本 `tools/build_pdf.py`（Markdown → HTML → PDF，via LibreOffice）

### Changed
- README 增加摘要与 PDF 入口。

## v1.2.1 — 2026-11-05

### Changed
- 公开版与内部版报告同步补充「证据包」章节。
- 确认两版均包含 A 包（429）真机解密结果与统计。
- 内部版补充 `private/` 导出文件清单与校验方式。

## v1.2 — 2026-11-05

### Added
- 证据补全：4 个 APK、完整反编译树（本地）、关键类源码、证书、数据库 schema、关键 pcap。
- `evidence/MANIFEST.md`：全部证据文件的 SHA-256 清单。
- `.gitignore`：完整反编译树与 APK 不入库，关键证据（pcap/schema/源码）入库。

## v1.1 — 2026-11-05

### Added
- **A 包（App 清单）真机抓包解密成功**：通过 429 落库 + 密文逐字节匹配，解出 169 个 App。
- 证据：`A_decrypted_live_ID72.json` / `.csv`（私有目录，不入库）。
- 公开报告补充 A 包解密说明与统计。

### Changed
- `docs/gaps.md` 中 P0-1（A 包无可解密样本）标记为已解决。

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
