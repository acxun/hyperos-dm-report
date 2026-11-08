# A 抓包 ID72/ID73 复核（脱敏）

- 复核日期：2026-11-08
- A 抓包：`private/pcap/A_20261105_212643.pcap`，4 个 c2s body，均为 40,464 字节
- 本地队列：`/data/user/0/com.mobiletools.systemhelper/databases/systemhelper` 的 `dmregister`
- 方法：`key = MD5(UTF8(plaintext))`，AES-128-ECB/PKCS5，逐字节比较
- 结果：
  - **ID72 命中 1 个 body，169 个 AppInfo**
  - **ID73 命中 1 个 body，169 个 AppInfo**
  - 其余 2 个 body 未在当前队列匹配，可能为 200 成功样本（成功不落队列）
- B 抓包：已于 2026-11-08 23:43 重抓并匹配当前队列 ID84（1,024 字节 body，HTTP 429，RegType=B）；见 `B_id84_recheck.md`
- 本文件不包含 App 名称、包名、IMEI/ICCID/IMSI、SSID/BSSID、经纬度或任何明文值。
