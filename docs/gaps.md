# 已知缺口与后续工作

本文件记录当前调查**尚未覆盖**的部分，按优先级排列，便于后续补充。

---

## P0：影响核心结论的缺口

### 1. A 包：部分解决（R 已闭环；A 当前抓包未闭环）

- 已复核：R 包 68,784 字节与本地明文逐字节 AES 匹配，100 条记录。
- A 包：旧 `A_decrypted_ID59.json` 有 169 个 App；当前 A 抓包（ID72）未找到匹配明文，`A_decrypted_live_ID72.json/.csv` 当前不存在，不能替代 ID72 闭环。
- 200 成功的 A 样本本次未取得匹配明文，未完成恢复；不能据此证明协议不可恢复。
- 补法：重新触发 A 上报并保留本地队列/抓包，完成当前样本的逐字节匹配；或在报告中继续标注“旧样本/字段结构”而非“已实测解密当前 A”。

### 2. 移动 DM 的 HTTPS 内容未解密

- 现状：只拿到 TLS 元数据（连接时间、字节数、SNI）与本地 DB。公开计数显示 `app_info_*` 447 行，network/traffic/WiFi/Bluetooth/battery 表 0 行。
- 影响：无法确认心跳/App 上报的字段级内容与线上格式；表结构不能证明这些字段本次已采集或已发送。
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

- 现状：已计算 6 个 APK 与 `pub.cer` 的 SHA-256（见 `iocs.md`）。
- 补法：补充各 split APK、oat/vdex、证书链、签名方案（v2/v3）详情。

### 9. 未验证导出组件的实际可利用性

- 现状：静态判断 `RegisterHelperService` 导出且未见调用方校验；普通应用实际绑定/调用 PoC 尚未完成。
- 补法：写一个最小 PoC App，实际绑定并调用 `c(String)`，验证能否重定向上报地址（仅在本人设备上）。

### 10. 未做 TLS 证书与 pinning 检查

- 现状：移动 DM 走 HTTPS，未验证证书链、是否 pinning、是否校验证书。
- 补法：MITM 或 `openssl s_client` 对比。

### 10.1 AI 防诈录屏/上传链路未实测

- 现状：代码链路已还原（`AiGuardService$p.A` → 录 3 秒 → `C(Path)` → `/aiVideo/pcc/detection`），但 `ai_guard_function_switch=0`、无活跃 MediaProjection。
- 已确认（v1.3.2）：3 秒/2 秒循环在 `AiGuardService$p.A`；调用点已接线。JADX 默认模式因 `JadxOverflowException` 跳过该方法，`--show-bad-code` 可还原。
- 缺口：运行时行为未实测（实际是否每轮上传、云端响应耗时、命中弹窗、服务生命周期）。
- 补法：在可回滚前提下打开开关，发起一次微信/QQ 视频通话，观察 `cache/clip_*`、`dumpsys media_projection`、`detection-aigc.engine.miui.com` 流量。

### 10.2 远程唤醒/触发已评估

- 结论：静态检查未发现两套 DM 的 push/网络监听入口；已知触发源为闹钟、系统广播、本地导出组件、运营商 SMS/STK（间接）。
- 公开报告/执行摘要已写入，但限定为“静态检查未发现；普通应用实际可达性待 PoC”，未写成全局实测否定。

### 10.3 包管理器上报未做云端威胁命中验证

- 现状：安装器打开、安装、取消时的相关请求有端点日志，网络抓包确认域名/TLS；GuardProvider 云查有服务日志和 DNS/SNI，`/risk/scan` 字段列表来自代码。风险样本 Avl 命中，取消上传 `installCnt=0`，单次授权后安装成功并上传 `installCnt=1`。检查时 `ReportStore` 目录为空，窗口内未观察到 `/virus/localResult/report`，不能排除曾生成后上传/删除；本次两条 shell 安装测试窗口内未出现同一 UI `/avl/upload`，不排除其他/延迟链路。全局配置已捕获（16 条禁装规则、94 条离线白名单、`oneClick` 参数）。
- 未覆盖：per-app `CloudParams` 的完整响应；云端威胁命中（非本地 Avl）后的 `/virus/localResult/report`；`cToken/tInfo` 未触发；`adb install` / `pm install` 已测，绕过 UI 上报；其他 session/企业安装路径未覆盖；单次安装授权与安装成功已实测；小米账号密码/人脸等其他验证方式未覆盖。
- 补法：在隔离环境用云端已知命中的样本（或可控响应）验证威胁报告；MITM 或 Frida 观察 `cInfo.cFlag/tFlag` 响应；单次安装授权与安装成功已实测，`pm install` 已测绕过 UI；剩余是其他 session/企业安装路径、其他身份验证方式。

---

## P2：覆盖范围缺口

### 11. 仅覆盖单机型 / 单系统版本

- 现状：一台 Xiaomi HyperOS 3.0 设备（具体型号不公开）。
- 补法：在其它机型、其它 HyperOS/MIUI 版本上重复取证，比较组件差异。

### 12. 电信自动注册已覆盖，其他分支/机型未覆盖

- 现状：已分析 `com.xiaomi.registration`（AutoRegistration）的路径 A/B/C；其他电信分支、双卡/漫游/机型差异未覆盖。
- 补法：检查 `com.ct.*`、`com.miui.dmregservice` 的电信分支、`/product/priv-app` 下其它 RegService。

### 13. 未分析系统级日志与诊断通道

- 现状：未看 `com.bsp.logmanager`、`com.debug.loggerui`、`com.miui.misightservice` 的日志落盘。
- 补法：检查 `/data/vendor/log`、`/data/misc/logd`、`dropbox`。

---

## P3：报告与工程化缺口

### 14. Executive Summary 已有，一页版待定

- 现状：已有 `docs/executive_summary.md` 与 3 页 PDF。
- 待办：如需面向非技术读者的严格 1 页版，另行压缩；当前不再标记为“缺少”。

### 15. 缺少图

- 数据流图（采集 → 本地队列 → 加密 → 上报 → 重试）
- 时间线图（安装、首次上报、抓包、解密）
- 攻击面图（导出组件、权限、网络）

### 16. 公开证据哈希清单已有，私有证据签收待评估

- 现状：`evidence/MANIFEST.md` + `evidence/SHA256SUMS` 已覆盖公开文件，`sha256sum -c` 通过。
- 待办：私有 pcap/DB/导出 JSON 的哈希与签收是否完整，另行评估；不在公开仓库承诺。

### 17. 缺少法律与合规章节

- 《个人信息保护法》告知同意、最小必要；
- 运营商 DM 的合规依据；
- 公开披露的边界与脱敏规范。

### 18. 缺少术语表

DM、LwM2M、CoAP、IMSI/ICCID、TAC/CID、PCI、RSRP/SINR 等。

### 19. 工具已补回归测试，仍有限制

- 已修：SYN 序列号、缺口标记、IPv6 格式、无 SYN 简单乱序/序列号回绕；HTTP 拒绝负数、非法/重复长度与不支持的 Transfer-Encoding；重传冲突标为不完整，不对含缺口/冲突的流做明文匹配。合成输入回归测试 20/20 通过。
- 仍限：IPv6 扩展头、乱序/重传的复杂组合、大包/并发流、按时间窗口匹配未全面覆盖；工具只用于已验证完整的特定样本。

### 20. 缺少 CI / 发布流程

- Markdown lint、链接检查、PDF 生成；
- 版本号与 CHANGELOG 规范。
