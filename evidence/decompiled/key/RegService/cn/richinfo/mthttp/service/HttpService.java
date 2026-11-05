package cn.richinfo.mthttp.service;

import a1.c;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import b1.a;
import b2.b;
import com.richinfo.mthttp.Constant;
import com.richinfo.mthttp.MTSDK;
import com.richinfo.mthttp.service.IMTService;
import com.richinfo.mthttp.service.MTService;
import u0.q;
import v1.e;
import z0.g;

/* JADX INFO: loaded from: classes.dex */
public class HttpService implements IMTService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MTService f546b;
    public a a;

    @Override // com.richinfo.mthttp.service.IMTService
    public final void onCreate(MTService mTService) {
        f546b = mTService;
        if (MTSDK.getHeartChanel() == 1) {
            this.a = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Constant.BROADCAST_ALARM_HEART);
            intentFilter.addAction(Constant.BROADCAST_ALARM_RETRY);
            intentFilter.addAction(Constant.BROADCAST_ALARM_DATE_RESET);
            mTService.registerReceiver(this.a, intentFilter, 4);
            j2.a.C("控制器服务", "初始化HTTP动态广播");
        }
    }

    @Override // com.richinfo.mthttp.service.IMTService
    public final void onDestroy() {
        j2.a.C("控制器服务", "控制服务被销毁");
        c.b(f546b).c();
        a aVar = this.a;
        if (aVar != null) {
            f546b.unregisterReceiver(aVar);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x0067  */
    @Override // com.richinfo.mthttp.service.IMTService
    public final void onStartCommand(Intent intent, int i3, int i4) {
        byte b4;
        c cVarB;
        e eVar;
        e eVar2;
        String str;
        if (intent == null) {
            j2.a.E("控制器服务", "intent==null");
            return;
        }
        String action = intent.getAction();
        j2.a.C("控制器服务", "service action --> " + action);
        action.getClass();
        switch (action) {
            case "serverKill":
                b4 = 0;
                break;
            case "serverBusiness":
                b4 = 1;
                break;
            case "serverHeart":
                b4 = 2;
                break;
            case "serverReset":
                b4 = 3;
                break;
            case "serverStart":
                b4 = 4;
                break;
            default:
                b4 = -1;
                break;
        }
        if (b4 != 0) {
            if (b4 == 1) {
                g.f3257d = 0;
                j2.a.B("业务触发Http客户端，重置重试次数为0");
            } else {
                if (b4 == 2) {
                    if (f546b.a()) {
                        g.f3256c = true;
                        c.b(f546b).e(new e(17, (Object) null), new q(this), true);
                        return;
                    }
                    return;
                }
                if (b4 != 3) {
                    if (b4 != 4) {
                        String strConcat = "未知命令->".concat(action);
                        if (!j2.a.f1457b || TextUtils.isEmpty(strConcat)) {
                            return;
                        }
                        j2.a.H0("MTLog", strConcat);
                        Log.e("MTLog", strConcat);
                        b.c('e', "MTLog", strConcat);
                        return;
                    }
                    if (g.f3256c) {
                        str = "当前HTTP正在连接，稍后再点击";
                        j2.a.B(str);
                        return;
                    }
                    g.f3257d = 0;
                    j2.a.B("启动Http客户端");
                    if (f546b.a()) {
                        g.f3256c = true;
                        cVarB = c.b(f546b);
                        eVar = new e(17, (Object) null);
                        eVar2 = new e(18, (Object) null);
                        cVarB.e(eVar, eVar2, false);
                        return;
                    }
                }
            }
            j2.a.B("重启Http客户端");
            if (g.f3256c) {
                str = "当前Http正在连接，稍后再点击";
                j2.a.B(str);
                return;
            }
            c.b(f546b).c();
            if (f546b.a()) {
                g.f3256c = true;
                cVarB = c.b(f546b);
                eVar = new e(17, (Object) null);
                eVar2 = new e(18, (Object) null);
                cVarB.e(eVar, eVar2, false);
                return;
            }
            return;
        }
        j2.a.B("杀掉Http客户端");
        c.b(f546b).c();
        g.f3256c = false;
    }
}
