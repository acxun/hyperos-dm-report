// Clash 覆写脚本(Clash Verge / Verge Rev / FlClash 等支持 JS 覆写的客户端)
// 支持拦截联通 DM、移动 DM 、电信自动注册、系统遥测、系统包管理器并放行FCM推送
function main(config) {
  // FCM 放行策略:'DIRECT' 直连(国内有 GMS 且能直连时推荐),
  // 如果直连不通,可改为你的代理组名称,例如 '🚀 节点选择'
  const FCM_POLICY = 'DIRECT';

  // 1. 广告/追踪拦截规则
  const rejectRules = [
    'DOMAIN-SUFFIX,dm.wo.com.cn,REJECT',
    'DOMAIN-SUFFIX,a.fxltsbl.com,REJECT',
    'DOMAIN-SUFFIX,b.fxltsbl.com,REJECT',
    'DOMAIN-SUFFIX,m.fxltsbl.com,REJECT',
    'DOMAIN-SUFFIX,auc.fxltsbl.com,REJECT',
    'DOMAIN-SUFFIX,event-log.cnbj1.mi-fds.com,REJECT',
    'DOMAIN-SUFFIX,zzhc.vnet.cn,REJECT',
    'DOMAIN-SUFFIX,typdm.tydevice.com,REJECT',
    'DOMAIN-SUFFIX,api.installer.xiaomi.com,REJECT',
    'DOMAIN-SUFFIX,virus-engine.sec.miui.com,REJECT',
    'DOMAIN-SUFFIX,t1.a.market.xiaomi.com,REJECT',
    'DOMAIN-SUFFIX,t5.a.market.xiaomi.com,REJECT',
  ];

  // 2. FCM 推送放行规则
  const fcmRules = [
    DOMAIN,mtalk.google.com,${FCM_POLICY},
    DOMAIN,alt1-mtalk.google.com,${FCM_POLICY},
    DOMAIN,alt2-mtalk.google.com,${FCM_POLICY},
    DOMAIN,alt3-mtalk.google.com,${FCM_POLICY},
    DOMAIN,alt4-mtalk.google.com,${FCM_POLICY},
    DOMAIN,alt5-mtalk.google.com,${FCM_POLICY},
    DOMAIN,alt6-mtalk.google.com,${FCM_POLICY},
    DOMAIN,alt7-mtalk.google.com,${FCM_POLICY},
    DOMAIN,alt8-mtalk.google.com,${FCM_POLICY},
    DOMAIN,android.apis.google.com,${FCM_POLICY},
    DOMAIN,device-provisioning.googleapis.com,${FCM_POLICY},
    DOMAIN,fcm.googleapis.com,${FCM_POLICY},
    DOMAIN,fcmregistrations.googleapis.com,${FCM_POLICY},
    DOMAIN,firebaseinstallations.googleapis.com,${FCM_POLICY},
    DOMAIN,firebase-settings.crashlytics.com,${FCM_POLICY},
    DOMAIN-SUFFIX,firebaseio.com,${FCM_POLICY},
    // FCM 长连接端口
    DST-PORT,5228-5230,${FCM_POLICY},
  ];

  // 3. 插入到规则最前面,并去重
  const original = Array.isArray(config.rules) ? config.rules : [];
  const prepend = [...rejectRules, ...fcmRules];
  config.rules = [...new Set([...prepend, ...original])];

  return config;
}
