# `/v3/cloud_config/query` 全局配置响应（脱敏摘要）

- 日期：2026-11-08
- 采集方式：Frida 只读 hook OkHttp 响应体，未修改返回值
- 响应：`errCode=200`，约 44 KB JSON
- 说明：只保留字段名、计数与配置值；完整包名/哈希/公钥列表与设备标识不入库

| 字段 | 实测内容 |
|---|---|
| `forbiddenList` | 16 条包/版本禁装规则 |
| `offlineInstallAppSignList` | 94 个包的 APK 哈希白名单 |
| `trustedSourcePackages` | 1 个受信任安装来源 |
| `unknownSourceAuthAskWhitelist` | 1 个未知来源授权白名单包 |
| `oneClick.authTimeout` | 1500 |
| `oneClick.preValidationSwitch` | 0 |
| `oneClick.authRollbackSwitch` | 0 |
| `oneClick.apkParseTimeout` | 500 |
| `oneClick.partnerDevPublicKeys` | 98 个 partner 公钥（仅计数） |
| `exitPageText` | `已取消安装` / `去应用商店发现更多心动应用与游戏` |
| `commonConfig.enableDefaultSafeMode` | 1 |
| `improveEfficiencyAppList` | 7 个限时推荐包（时间窗已过期） |
| `bit32AppStrategy` | `allowInstall=true`、32 位不兼容提示 |
| `appVisibility` | 2 |
| `limitArchive` | false |

未捕获：per-app `CloudParams` 的完整响应。`riskType=9999`、`registrationStatus=1` 仍来自安装器日志与代码级证据。
