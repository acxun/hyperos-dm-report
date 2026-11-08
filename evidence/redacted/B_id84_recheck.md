# B 抓包 ID84 复核（脱敏）

- 复核日期：2026-11-08 23:43
- 触发方式：显式广播到导出的 `com.mobiletools.systemhelper.control.OnBootReceiver`（自定义 action，非 `BOOT_COMPLETED`）
- B 抓包：`private/pcap/B_recheck_20261108.pcap`，1 个 c2s body，1,024 字节
- 服务器响应：HTTP 429 Too Many Requests
- 本地队列：`dmregister` 新增 **ID84**，明文 1,018 字节，`RegType=B`，无 `AppInfo`
- 方法：`key = MD5(UTF8(plaintext))`，AES-128-ECB/PKCS5，逐字节比较
- 结果：**ID84 与 B 抓包逐字节匹配**
- 本文件不包含 IMEI/ICCID/IMSI、BSSID/SSID、IP、位置或任何明文值。
