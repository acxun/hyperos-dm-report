# HyperOS 预装运营商 DM 组件调查报告

> 对一台 Xiaomi HyperOS 3.0（Android 16）设备的静态与动态分析。
> 记录两套运营商终端管理（DM）客户端、系统遥测组件与本地反诈数据库的行为、协议与安全问题。

- 报告版本：v1.0（2026-11-05）
- 分析方式：静态反编译 + 运行时数据库取证 + 真机抓包 + 解密验证
- 公开报告：[`docs/report_public.md`](docs/report_public.md)
- 已知缺口：[`docs/gaps.md`](docs/gaps.md)
- IOC 清单：[`docs/iocs.md`](docs/iocs.md)

---

## 主要发现

| 组件 | 包名 | 服务器 | 状态 |
|---|---|---|---|
| 联通 DM | `com.mobiletools.systemhelper` | `dm.wo.com.cn:18080`（HTTP） | 活跃，周期上报 |
| 移动 DM | `com.miui.dmregservice` | `a.fxltsbl.com:443`（HTTPS）+ CoAP 5683 | 按需唤醒 |
| 系统遥测 | `com.miui.misightservice` + `/system_ext/bin/misight`(root) | `event-log.cnbj1.mi-fds.com` | 活跃 |
| 本地反诈库 | `com.miui.securitycenter` | 未发现上传 | 本地写入 |
| AI 通话防诈 | `com.miui.guardprovider` | `detection-aigc.engine.miui.com` 等 | 开关关闭 |

关键结论：

1. `SystemHelper` 每 30 分钟采集位置/基站/WiFi，并周期上报设备标识、SIM 标识（部分打码）、经纬度（6 位小数）、行政区、基站参数、WiFi、存储信息与 App 使用清单。
2. 上报链路为 **明文 HTTP + AES-128-ECB**，`key = MD5(明文)`，`sign = RSA(1024 位公钥, MD5)`。因 key 由明文派生，取得本地明文即可还原网络密文。
3. **已实测解密**：B（1,024 B）、R（68,784 B，100 条记录）、A（40,464 B，169 个 App，429 落库样本）。
4. 两套 DM 均存在无权限保护的导出组件，本机任意应用可重定向上报地址或触发上报。
5. 截屏时间、安装记录、通话记录仅写入本地反诈库，未发现上传路径；AI 通话防诈当前关闭。

---

## 仓库结构

```
.
├── README.md
├── LICENSE
├── CHANGELOG.md
├── .gitignore
├── docs/
│   ├── report_public.md       # 公开版报告（已脱敏）
│   ├── gaps.md                # 已知缺口与后续工作
│   └── iocs.md                # 域名 / IP / 包名 / 哈希
├── tools/
│   ├── pcap_tcp.py            # 纯 Python 的 pcap / TCP 流重组
│   ├── decrypt_match.py       # 队列明文匹配 + AES 解密
│   └── README.md
├── evidence/
│   ├── MANIFEST.md            # 证据清单 + SHA-256
│   ├── apk/                   # 4 个 APK（不入库）
│   ├── decompiled/
│   │   ├── key/               # 关键类反编译源码（入库）
│   │   └── full/              # 完整源码树（不入库）
│   ├── certificates/          # pub.cer / pub.pem / openssl 文本
│   ├── databases/             # 仅 schema 与行数
│   ├── pcap/                  # B/R/A 三次关键抓包
│   └── redacted/              # 脱敏样本
└── private/                   # 不入库（.gitignore）
    ├── report_internal.md     # 内部版（含隐私数据）
    └── *.csv / *.json         # 原始导出
```

> `private/` 已被 `.gitignore` 排除，不会进入版本历史。
> 原始 pcap、数据库、APK 与解密 CSV 均不入库。

---

## 复现思路

环境：已 root、已授权 ADB 的 HyperOS 设备。

```bash
# 1) 枚举与静态分析
adb shell pm path com.mobiletools.systemhelper
adb pull /system/priv-app/SystemHelper/SystemHelper.apk
jadx -d out --no-res SystemHelper.apk

# 2) 数据库取证
adb shell su -c 'sqlite3 /data/user/0/com.mobiletools.systemhelper/databases/systemhelper \
  "select ID, length(jsonString) from dmregister"'

# 3) 抓包（注意 tcpdump 有缓冲，需 SIGINT 落盘）
adb shell su -c "tcpdump -i any -n -s0 -w /data/local/tmp/cap.pcap 'tcp port 18080'"
# ...触发...
adb shell su -c "pkill -INT tcpdump"

# 4) 重组 + 解密
python3 tools/pcap_tcp.py cap.pcap <server_ip> 18080
python3 tools/decrypt_match.py cap.pcap systemhelper.db
```

解密原理：

```text
key  = MD5(UTF8(plaintext))
body = AES-128-ECB/PKCS5(plaintext, key)
sign = Base64(RSA/ECB/PKCS1(pub.cer, key))
```

> 仅凭密文无法解密；需要本地明文（队列 / 备份 / root）或服务器 RSA 私钥。

---

## 隐私与伦理

- 本仓库的公开文档已移除设备标识、SIM 标识、位置、WiFi、App 清单等个人信息。
- `private/` 目录仅本地保留，不进入 Git。
- 分析基于本人自用设备，并在取证前取得设备所有者授权。
- 如引用本报告，请遵守当地法律与平台规则，不要用于攻击或骚扰。

---

## 免责声明

- 本报告基于单台设备、单次取证，不代表所有小米机型/系统版本。
- 反编译代码可能因混淆存在偏差，关键结论已通过运行时数据与抓包交叉验证。
- 文中组件均为系统预装、Xiaomi 平台签名；报告关注采集范围、加密方式与用户可控性，不推断其主观意图。

---

## 许可

- 文档：CC BY 4.0
- 代码（`tools/`）：MIT
