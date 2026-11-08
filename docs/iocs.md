# IOC 清单

> 仅用于检测与取证，不构成对任何组织/个人的指控。

## 域名与 IP

| 域名 | 解析 | 端口/协议 | 归属组件 | 用途 |
|---|---|---|---|---|
| `dm.wo.com.cn` | CNAME `63ce5fd2be92dcdf.icloudv6.com` → `223.111.128.82` | 18080 / HTTP | `com.mobiletools.systemhelper` | 设备/SIM/位置/App 上报 |
| `a.fxltsbl.com` | `117.134.71.39` | 443 / HTTPS | `com.miui.dmregservice` | 主上报 |
| `b.fxltsbl.com` | — | 443 / HTTPS | `com.miui.dmregservice` | 备用 |
| `m.fxltsbl.com` | `117.134.71.81` | 5683 / CoAP (LwM2M) | `com.miui.dmregservice` | 备用管理通道 |
| `auc.fxltsbl.com` | — | 443 / HTTPS | `com.miui.dmregservice` | SIM 实名拍照 |
| `event-log.cnbj1.mi-fds.com` | — | 443 / HTTPS | `com.miui.misightservice` | 遥测事件/配置 |
| `detection-aigc.engine.miui.com` | — | 443 / HTTPS | `com.miui.guardprovider` | AI 通话检测（`clip.mp4`） |
| `fraud-detection.engine.miui.com` | — | 443 / HTTPS | `com.miui.securitycenter` / GuardProvider | NFC 反诈配置、伪造 App 举报 |
| `flash.sec.miui.com` | — | 443 / HTTPS | GuardProvider / SecurityCenter | `/detect/app`、游戏联盟等 |
| `api.installer.xiaomi.com` | — | 443 / HTTPS | `com.miui.packageinstaller` | `/v3/cloud_config/query`、`/v4/game/interceptcheck/safemode`、`/info/layout/v2`、`/avl/upload` |
| `virus-engine.sec.miui.com` | — | 443 / HTTPS | GuardProvider | `/risk/scan`（3.1.4）、`/virus/scan`（2.5.6）、`/virus/localResult/report` |
| `t1.a.market.xiaomi.com` | — | 443 / HTTPS | `com.miui.packageinstaller` | 安装器广告/推荐资源 |
| `t5.a.market.xiaomi.com` | — | 443 / HTTPS | `com.miui.packageinstaller` | 安装器广告/推荐资源 |

WAF 响应特征：`WZWS-RAY`（联通 DM 接入层）。

## 包名与路径

| 包名 | APK 路径 | 版本（取证时） | UID |
|---|---|---|---|
| `com.mobiletools.systemhelper` | `/system/priv-app/SystemHelper/SystemHelper.apk` | 3.0.1-20260313 (34) | 10090 |
| `com.miui.dmregservice` | `/product/priv-app/RegService/RegService.apk` | 15.0.9 | 1001 |
| `com.miui.misightservice` | `/system_ext/app/MiSightService` | 0.9.5 | — |
| `com.miui.securitycenter` | `/system/priv-app/...` | — | 1000 |
| `com.miui.guardprovider` | `/product/app/MIUIGuardProvider/MIUIGuardProvider.apk` | 2.5.6 / 3.1.4 | 10152 |
| `com.miui.packageinstaller` | `/data/app/.../com.miui.packageinstaller-.../base.apk`（系统应用更新） | 5.5.7.0.0-20261012 (55700) | 10126 |
| `com.xiaomi.registration` | `/product/priv-app/AutoRegistration/AutoRegistration.apk` | 15.1.22 (63) | 1001 |

## 关键组件

```text
com.mobiletools.systemhelper/.control.OnBootReceiver
com.mobiletools.systemhelper/.control.GetSignalInfoReceiver
com.mobiletools.systemhelper/.control.SignalInfoRegisterReceiver
com.mobiletools.systemhelper/.control.ScheduleRegisterReceiver
com.mobiletools.systemhelper/.control.AppInfoRegisterReceiver
com.mobiletools.systemhelper/.control.SIMStateReceiver
com.mobiletools.systemhelper/.control.ConnectStateReceiver
com.mobiletools.systemhelper/.service.RegisterHelperService     # exported, no permission
com.mobiletools.systemhelper/.Activity.TestActivity             # exported, no permission

com.miui.dmregservice/cn.richinfo.dm.receiver.DMBroadCastReceiver   # permission com.dm.permission.THIRD_SEND
com.miui.dmregservice/cn.richinfo.dm.service.DMService              # exported, no permission
com.miui.dmregservice/com.richinfo.mthttp.MTStaticBReceiver         # exported, no permission
com.miui.dmregservice/.BootCompleteReceiver                         # exported, no permission

com.miui.packageInstaller.NewInstallerPrepareActivity              # 安装准备/云控
com.miui.packageInstaller.InstallProgressParentActivity             # 安装/取消上报
com.miui.guardprovider.server.VirusScanService                      # 安装前病毒扫描
```

## 文件哈希（SHA-256）

```text
1de8d965e295db27e189aa179cdb45438d7f759cffbb43ce55f840b614ff6c65  SystemHelper.apk
6e3ff72e078a4dca54600f69bbc43ce165503ff23c62d2ef0abdcdca5acbadcc  RegService.apk
7b5a26b38cf3f3c1967cd8e6ed06d3d1ac0ff45371037c16e7982e9925f510c3  MIUIGuardProvider.apk
fdc5c01c8170d2c1ed8dd21087c5647b32ba75422a9a43999e232383a819b5f9  PackageInstaller.apk
f4eda1b7b0f46521c93ddc75f7d833aec7bd48674c561e545f2b84a1edd6284c  securitycenter base.apk
91f6324b07fe67cb753ac2875dd0c59f2b8cb9a43b97d92fb42b11b85f27c303  AutoRegistration.apk
810c0122ba6af7a4b6a5921fdbbbf9197fb2e0b2e82de0c5aa40d28f1b7c6501  pub.cer
```

## 证书

```text
Subject/Issuer : C=CN, ST=BJ, L=BJ, O=UNICOM, OU=UNICOM, CN=UNICOM
Serial         : 528B9360
Validity       : 2019-05-24 → 2119-04-30
Key            : RSA 1024-bit, e=65537
SHA-256 (DER)  : 81:0C:01:22:BA:6A:F7:A4:B6:A5:92:1F:DB:BB:F9:19:
                 7F:B2:E0:B2:E8:2D:E0:C5:AA:40:D2:8F:1B:7C:65:01
Modulus        : C1E4E501D07F1C48307351C93057DE4F6C943B4686B4CDE2
                 BF56181EFF7A0D0614D2886B3D16FC55B1D839127BF046DAE
                 585A8D1AA5C3F294D22B934B62F6FF2114058821B7DD403CF5
                 29047C167F5895D263C822A12E5F5DD793C2ADA0C59CAD98C9D
                 EEC693B99BA788C1695D7595FA5E8CF94EDB07A487AB0B343C05
                 27296B
```

## 加密协议特征

```text
Content-Type: application/encrypted-json
key  = MD5(UTF8(plaintext))
body = AES-128-ECB/PKCS5
sign = Base64(RSA/ECB/PKCS1(pub.cer, key)) in query string
```

## 检测建议

- 网络侧：对 `dm.wo.com.cn:18080`、`a.fxltsbl.com`、`m.fxltsbl.com:5683`、`event-log.cnbj1.mi-fds.com` 做域名/SNI 监控。
- 主机侧：检查上述包名、`/system/priv-app/SystemHelper`、`/product/priv-app/RegService`。
- 安装器侧：监控 `api.installer.xiaomi.com` 的 `/avl/upload`、`/info/layout/v2`、`/v3/cloud_config/query`、`/v4/game/interceptcheck/safemode`，以及 `virus-engine.sec.miui.com` 的 `/risk/scan`（3.1.4）与 `/virus/localResult/report`；风险提示页还会加载 `*.a.market.xiaomi.com` 广告资源。
- 数据侧：检查 `.../databases/systemhelper`（表 `dmregister`）、`.../databases/cmcc_dm.db`、`/data/misc/user/0/securitycenter/fraud_detection_data.db`。
- 证书侧：匹配 `pub.cer` 的 SHA-256 / 序列号 `528B9360`。
