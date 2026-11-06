# 已知缺口与后续工作

本文件记录当前调查**尚未覆盖**的部分，按优先级排列，便于后续补充。

---

## P0：影响核心结论的缺口

### 1. ~~A 包（App 清单）缺少“可解密的抓包样本”~~ ✅ 已解决（2026-11-05 21:26）

- 结论：通过把 `appInfoInterval2/Interval` 调至 0/1000 并广播 `BOOT_COMPLETED`，连续请求中服务器返回 `200` 与 `429` 混合；429 的同一明文会写入 `dmregister`，与抓包密文逐字节匹配后成功解密（169 个 App）。
- 证据：`A_decrypted_live_ID72.json` / `.csv`（私有目录）。
- 剩余：200 成功的样本仍无法从包解密（协议设计使然），这是预期行为，不是缺口。

### 2. 移动 DM 的 HTTPS 内容未解密

- 现状：只拿到 TLS 元数据（连接时间、字节数、SNI）与本地 DB。
- 影响：无法确认心跳/App 上报的字段级内容与线上格式。
- 补法：在受控测试环境做 MITM（安装用户 CA + 关闭 pinning），或分析客户端 SDK 的序列化逻辑并重建。

### 3. 关闭总闸后是否真的停止 — 🟡 短时验证完成，长观察待做

- 已完成：`operator_service_improve_plan=0` 后，同一触发方式下 SystemHelper 到 `18080` **0 包**；`=1` 对照发出 48 KB（B+A，200 OK）。
- 同时确认：该开关**不影响** DMReg（`=0` 时仍连 `117.134.71.39:443`，21 包）。
- 待做：置 0 后连续抓包 24–48h，统计连接数，排除“延迟重试”路径。

### 4. 禁用组件的系统影响未评估 — 🟡 禁用/重启验证完成，功能影响待测

- 已完成：`pm disable-user --user 0 com.miui.dmregservice` 后，进程不启动、无 443/5683 流量；**重启后仍 disabled、无闹钟、无流量**。
- 待做：逐项验证 VoLTE、5G、VoNR、短信、数据、热点、双卡、运营商 OTA/实名、紧急呼叫。

---

## P1：证据完整性缺口

### 5. 未做长期流量统计

- 现状：仅在数分钟窗口内抓包。
- 补法：`dumpsys netstats` 按 uid 统计 7 天；或旁路镜像 24h。

### 6. MiSight 实际上传内容未捕获

- 现状：`events` 表为空，仅看到配置拉取与上传时间戳。
- 补法：在触发遥测事件（崩溃、性能、充电）时抓包；或 hook OneTrack SDK。

### 7. `com.miui.securitycenter` 其它数据文件未分析

- 现状：只分析了 `fraud_detection_data.db`。
- 待看：`/data/misc/user/0/securitycenter/cta`、`fire_wall_config*.db`、`/data/user/0/com.miui.securitycenter/shared_prefs/*`。

### 8. APK 与证书的哈希清单不完整

- 现状：已计算 4 个 APK 与 `pub.cer` 的 SHA-256（见 `iocs.md`）。
- 补法：补充各 split APK、oat/vdex、证书链、签名方案（v2/v3）详情。

### 9. 未验证导出组件的实际可利用性

- 现状：从 manifest 与代码判断 `RegisterHelperService` 无权限保护。
- 补法：写一个最小 PoC App，实际绑定并调用 `c(String)`，验证能否重定向上报地址（仅在本人设备上）。

### 10. 未做 TLS 证书与 pinning 检查

- 现状：移动 DM 走 HTTPS，未验证证书链、是否 pinning、是否校验证书。
- 补法：MITM 或 `openssl s_client` 对比。

### 10.1 AI 防诈录屏/上传链路未实测

- 现状：代码链路已还原（`p079l1` → `AiGuardService.C(Path)` → `/aiVideo/pcc/detection`），但 `ai_guard_function_switch=0`、`RECORD_AUDIO` 未授权、无活跃 MediaProjection。
- 缺口：`p079l1/a.java` 在反编译结果中无可见调用点，视频路径是否接线无法仅凭静态分析确认。
- 补法：在可回滚前提下打开开关并授予 `RECORD_AUDIO`，发起一次微信/QQ 视频通话，观察 `cache/clip_*`、`dumpsys media_projection`、`detection-aigc.engine.miui.com` 流量。

### 10.2 远程唤醒/触发已评估

- 结论：两套 DM 均无 push/网络监听；触发源只有闹钟、系统广播、本地导出组件、运营商 SMS/STK（间接）。
- 按作者要求，该节未写入公开报告。

---

## P2：覆盖范围缺口

### 11. 仅覆盖单机型 / 单系统版本

- 现状：一台 Redmi Note 14 Pro，HyperOS 3.0.306。
- 补法：在其它机型、其它 HyperOS/MIUI 版本上重复取证，比较组件差异。

### 12. 未覆盖中国电信及其它运营商 DM

- 现状：只发现联通（SystemHelper）与移动（DMRegService）。
- 补法：检查 `com.ct.*`、`com.miui.dmregservice` 的电信分支、`/product/priv-app` 下其它 RegService。

### 13. 未分析系统级日志与诊断通道

- 现状：未看 `com.bsp.logmanager`、`com.debug.loggerui`、`com.miui.misightservice` 的日志落盘。
- 补法：检查 `/data/vendor/log`、`/data/misc/logd`、`dropbox`。

---

## P3：报告与工程化缺口

### 14. 缺少一页 Executive Summary

面向非技术读者的 1 页摘要（现状、风险、建议）。

### 15. 缺少图

- 数据流图（采集 → 本地队列 → 加密 → 上报 → 重试）
- 时间线图（安装、首次上报、抓包、解密）
- 攻击面图（导出组件、权限、网络）

### 16. 缺少证据哈希清单与签收

每个证据文件（pcap / DB / 导出 JSON）应附 SHA-256，便于复核。

### 17. 缺少法律与合规章节

- 《个人信息保护法》告知同意、最小必要；
- 运营商 DM 的合规依据；
- 公开披露的边界与脱敏规范。

### 18. 缺少术语表

DM、LwM2M、CoAP、IMSI/ICCID、TAC/CID、PCI、RSRP/SINR 等。

### 19. 工具未做参数化与测试

- `tools/pcap_tcp.py`：目前按 SLL2 解析，需支持 Ethernet/SLL、IPv6 扩展头、乱序/重传。
- `tools/decrypt_match.py`：需支持大包、并发流、按时间窗口匹配。

### 20. 缺少 CI / 发布流程

- Markdown lint、链接检查、PDF 生成；
- 版本号与 CHANGELOG 规范。
