package cn.richinfo.dm.service;

import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.richinfo.mthttp.Constant;
import com.richinfo.mthttp.MTSDK;
import dalvik.system.DexClassLoader;
import g.b2;
import java.util.Locale;
import java.util.concurrent.ThreadPoolExecutor;
import t0.c;
import t0.f;
import t0.g;
import u0.d;
import u0.i;
import u0.j;
import u0.k;
import u0.p;
import u0.q;
import u0.r;
import u0.t;
import y0.a;
import z0.b;
import z0.e;

/* JADX INFO: loaded from: classes.dex */
public class DMService extends Service {
    public f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f545b;

    /* JADX WARN: Code duplicated, block: B:145:0x038b  */
    /* JADX WARN: Code duplicated, block: B:203:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:210:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x015c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0189  */
    /* JADX WARN: Code duplicated, block: B:48:0x018b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0191  */
    /* JADX WARN: Code duplicated, block: B:52:0x0197  */
    /* JADX WARN: Code duplicated, block: B:54:0x019a  */
    /* JADX WARN: Code duplicated, block: B:57:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:58:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:60:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:62:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:64:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:67:0x0208  */
    /* JADX WARN: Code duplicated, block: B:68:0x020a  */
    /* JADX WARN: Code duplicated, block: B:70:0x0210  */
    /* JADX WARN: Code duplicated, block: B:72:0x0216  */
    /* JADX WARN: Code duplicated, block: B:74:0x0219  */
    /* JADX WARN: Code duplicated, block: B:77:0x0245  */
    /* JADX WARN: Code duplicated, block: B:78:0x0247  */
    /* JADX WARN: Code duplicated, block: B:82:0x0253  */
    public final void a(final Intent intent) {
        boolean z3;
        t tVar;
        boolean z4;
        String str;
        Context context;
        boolean z5;
        String str2;
        Context context2;
        boolean z6;
        String str3;
        Context context3;
        boolean z7;
        String str4;
        Context context4;
        r rVar;
        c();
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        String action = intent.getAction();
        e.g("控制功能", "DMService:处理业务action=" + action);
        final int i3 = 1;
        final int i4 = 0;
        if ("com.dmyk.android.telephony.action.SIM_STATE_CHANGED".equals(action)) {
            f fVar = this.a;
            fVar.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = fVar.a;
            if (j3 > 0 && jElapsedRealtime - j3 < 60000) {
                e.c("自注册", "自注册重复触发，终止本次上报，60s后重试");
                return;
            }
            fVar.a = jElapsedRealtime;
            e.l("流量采集");
            ((ThreadPoolExecutor) g.B()).execute(new c(fVar, i4));
            e.l("自注册");
            ((ThreadPoolExecutor) g.B()).execute(new c(fVar, i3));
            Context context5 = fVar.f2603e;
            long j4 = context5.getSharedPreferences("config_dm", 0).getLong("key_preinstall_time", 0L);
            e.g("控制功能", "预装应用已于" + e.f(j4) + "上报");
            if (j4 != 0) {
                e.c("控制功能", "已上报过，不再上报");
                return;
            }
            e.l("预装应用");
            synchronized (r.class) {
                if (r.f2670b == null) {
                    r.f2670b = new r(context5);
                }
                rVar = r.f2670b;
            }
            rVar.getClass();
            e.g("预装应用", "预装应用采集流程启动");
            ((ThreadPoolExecutor) g.B()).execute(new c(fVar, 6));
            return;
        }
        if ("cn.richinfo.dmyk.action.REGISITER_RETRY".equals(action)) {
            f fVar2 = this.a;
            fVar2.getClass();
            e.m("自注册", "自注册重试");
            ((ThreadPoolExecutor) g.B()).execute(new c(fVar2, 3));
            return;
        }
        String str5 = "非WIFI网络,不上报";
        String str6 = "上报开关未开启，请检查平台配置";
        if (!"cn.richinfo.dmyk.action.HEARTBEAT".equals(action)) {
            if ("cn.richinfo.dmyk.action.HEARTBEAT_RETRY".equals(action)) {
                this.a.c(true);
                return;
            }
            if ("cn.richinfo.dmyk.action.APPINFO".equals(action)) {
                this.a.a(false);
                return;
            }
            if ("cn.richinfo.dmyk.action.APPINFO_RETRY".equals(action)) {
                this.a.a(true);
                return;
            }
            if ("android.dmyk.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                f fVar3 = this.a;
                Context context6 = fVar3.f2603e;
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                long j5 = fVar3.f2600b;
                if (j5 > 0 && jElapsedRealtime2 - j5 < 5000) {
                    e.o("控制功能", "网络变化广播重复触发，不响应");
                    return;
                }
                fVar3.f2600b = jElapsedRealtime2;
                try {
                    e.l("流量采集");
                    d.c(context6).g();
                } catch (Exception e3) {
                    e.a("流量采集", "采集异常", e3);
                }
                try {
                    i iVarA = i.a(context6);
                    iVarA.getClass();
                    if (i.g()) {
                        ((ThreadPoolExecutor) g.B()).execute(new b2(i3, iVarA));
                    }
                } catch (Exception e4) {
                    e.a("应用采集", "更新异常", e4);
                }
                e.l("国际漫游");
                synchronized (t.class) {
                    if (t.f2672b == null) {
                        t.f2672b = new t(context6, 0);
                    }
                    tVar = t.f2672b;
                }
                Context context7 = tVar.a;
                if (androidx.activity.result.a.i(context7, "config_dm", 0, "key_roaming_report_switch", "Y")) {
                    if (!g.P(context7)) {
                        str6 = "当前非漫游状态，不上报";
                    } else if (context7.getSharedPreferences("config_dm", 0).getBoolean("key_can_roaming_report", false)) {
                        if (!g.S(b.m(context7).t(b.m(context7).p()))) {
                            str6 = "当前非移动卡，不上报";
                        }
                    } else {
                        str6 = "当前SIM卡已上报过，不再上报";
                    }
                    e.i("国际漫游", str6);
                    i3 = 0;
                } else {
                    e.i("国际漫游", str6);
                    i3 = 0;
                }
                if (i3 != 0) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar3, 13));
                }
                g.k(context6);
                return;
            }
            if ("com.dmyk.android.telephony.action.VOLTE_STATE_CHANGE".equals(action)) {
                final f fVar4 = this.a;
                Context context8 = (Context) k.b(fVar4.f2603e).a;
                if (androidx.activity.result.a.i(context8, "config_dm", 0, "KEY_BUSINESS_INFO", "Y")) {
                    if (!g.Q(context8)) {
                    }
                    if (i3 != 0) {
                        ((ThreadPoolExecutor) g.B()).execute(new Runnable() { // from class: t0.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                int i5 = i4;
                                f fVar5 = fVar4;
                                Intent intent2 = intent;
                                switch (i5) {
                                    case 0:
                                        Context context9 = fVar5.f2603e;
                                        try {
                                            k.b(context9).getClass();
                                            k.d(intent2, context9);
                                        } catch (Exception e5) {
                                            z0.e.a("流量采集", "volte变化上报异常", e5);
                                        }
                                        break;
                                    default:
                                        Context context10 = fVar5.f2603e;
                                        try {
                                            u0.c.a(context10).b(intent2);
                                            u0.c.a(context10).h();
                                        } catch (Exception e6) {
                                            androidx.activity.result.a.f(e6, new StringBuilder("拍照上报异常："), "拍照采集");
                                            return;
                                        }
                                        break;
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                str5 = "上报开关未开启，请检查平台配置";
                e.i("控制功能", str5);
                i3 = 0;
                if (i3 != 0) {
                    ((ThreadPoolExecutor) g.B()).execute(new Runnable() { // from class: t0.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i5 = i4;
                            f fVar5 = fVar4;
                            Intent intent2 = intent;
                            switch (i5) {
                                case 0:
                                    Context context9 = fVar5.f2603e;
                                    try {
                                        k.b(context9).getClass();
                                        k.d(intent2, context9);
                                    } catch (Exception e5) {
                                        z0.e.a("流量采集", "volte变化上报异常", e5);
                                    }
                                    break;
                                default:
                                    Context context10 = fVar5.f2603e;
                                    try {
                                        u0.c.a(context10).b(intent2);
                                        u0.c.a(context10).h();
                                    } catch (Exception e6) {
                                        androidx.activity.result.a.f(e6, new StringBuilder("拍照上报异常："), "拍照采集");
                                        return;
                                    }
                                    break;
                            }
                        }
                    });
                    return;
                }
                return;
            }
            if ("android.dmyk.action.BATTERY_CHARGE_STATE_CHANGE".equals(action)) {
                final f fVar5 = this.a;
                fVar5.getClass();
                e.m("充电采集", "记录充电状态变化");
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - fVar5.f2601c < 5000) {
                    e.c("充电采集", "充电采集频繁触发，终止本次采集，5s后重试");
                    return;
                }
                fVar5.f2601c = jCurrentTimeMillis;
                final int intExtra = intent.getIntExtra("com.dmyk.android.telephony.EXTRA_BATTERY_CHARGE_STATE", -1);
                u0.g gVarB = u0.g.b(fVar5.f2603e);
                gVarB.getClass();
                e.g("充电采集", "充电采集校验");
                if (!androidx.activity.result.a.i(gVarB.f2647b, "config_dm", 0, "key_battery_charging_report_switch", "Y")) {
                    e.c("充电采集", "上报开关未开启，请检查平台配置");
                    i3 = 0;
                }
                if (i3 != 0) {
                    ((ThreadPoolExecutor) g.B()).execute(new Runnable() { // from class: t0.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            f fVar6 = fVar5;
                            int i5 = intExtra;
                            u0.g gVarB2 = u0.g.b(fVar6.f2603e);
                            synchronized (gVarB2) {
                                try {
                                    try {
                                        z0.e.g("充电采集", "采集充电信息，充电状态：" + i5);
                                        if (i5 < 0) {
                                            StringBuilder sb = new StringBuilder("参数异常：state=");
                                            sb.append(i5);
                                            sb.append("请检查广播参数是否正常");
                                            z0.e.c("充电采集", sb.toString());
                                        } else {
                                            z0.e.d("充电采集", "start update batteryCharge");
                                            Context context9 = gVarB2.f2647b;
                                            g.m(context9.getSharedPreferences("config_dm", 0).getLong("key_battery_Data_Life_time", a.f2590g), context9, "table_name_battery_charge");
                                            try {
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append(i5);
                                                sb2.append("");
                                                String string = sb2.toString();
                                                String strX = z0.g.x(gVarB2.f2647b);
                                                String strY = z0.g.y(gVarB2.f2647b);
                                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                                p pVarL = p.l(gVarB2.f2647b);
                                                ContentValues contentValues = new ContentValues();
                                                contentValues.put("battery_Status", string);
                                                contentValues.put("battery_temperature", strY);
                                                contentValues.put("_timestamp", Long.valueOf(jCurrentTimeMillis2));
                                                contentValues.put("battery_electricity", strX);
                                                pVarL.n("table_name_battery_charge", contentValues);
                                                z0.e.b("充电采集");
                                            } catch (Exception e5) {
                                                z0.e.e("充电采集", "保存充电信息异常：" + e5.getMessage());
                                            }
                                        }
                                    } catch (Exception e6) {
                                        z0.e.a("充电采集", "清除历史数据异常", e6);
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            }
            if ("android.dmyk.action.BLUETOOTH_CONNECTIVITY_CHANGE".equals(action)) {
                f fVar6 = this.a;
                fVar6.getClass();
                e.m("充电采集", "蓝牙连接状态变化");
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jCurrentTimeMillis2 - fVar6.f2602d < 5000) {
                    e.c("充电采集", "蓝牙采集频繁触发，终止本次采集，5s后重试");
                    return;
                }
                fVar6.f2602d = jCurrentTimeMillis2;
                e.l("蓝牙采集");
                j jVarD = j.d(fVar6.f2603e);
                jVarD.getClass();
                e.g("蓝牙采集", "蓝牙采集校验");
                if (!androidx.activity.result.a.i((Context) jVarD.f2656b, "config_dm", 0, "key_bluetooth_report_switch", "Y")) {
                    e.c("蓝牙采集", "上报开关未开启，请检查平台配置");
                    i3 = 0;
                }
                if (i3 != 0) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar6, 8));
                    return;
                }
                return;
            }
            if (!"android.dmyk.action.ACTION_NETWORK_COLLECT".equals(action)) {
                if ("cn.richinfo.dmyk.action.THIRD_REQUEST".equals(action)) {
                    final f fVar7 = this.a;
                    if (!androidx.activity.result.a.i(fVar7.f2603e, "config_dm", 0, "KEY_SANPSHOT_REPORT_SWITCH", "Y")) {
                        e.o("拍照采集", "上报开关未开启，请检查平台配置");
                        return;
                    }
                    ((ThreadPoolExecutor) g.B()).execute(new Runnable() { // from class: t0.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i5 = i3;
                            f fVar8 = fVar7;
                            Intent intent2 = intent;
                            switch (i5) {
                                case 0:
                                    Context context9 = fVar8.f2603e;
                                    try {
                                        k.b(context9).getClass();
                                        k.d(intent2, context9);
                                    } catch (Exception e5) {
                                        z0.e.a("流量采集", "volte变化上报异常", e5);
                                    }
                                    break;
                                default:
                                    Context context10 = fVar8.f2603e;
                                    try {
                                        u0.c.a(context10).b(intent2);
                                        u0.c.a(context10).h();
                                    } catch (Exception e6) {
                                        androidx.activity.result.a.f(e6, new StringBuilder("拍照上报异常："), "拍照采集");
                                        return;
                                    }
                                    break;
                            }
                        }
                    });
                    return;
                }
                if ("cn.richinfo.dmyk.action.SNAPSHOT_RETRY".equals(action)) {
                    f fVar8 = this.a;
                    fVar8.getClass();
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar8, 4));
                    return;
                }
                return;
            }
            f fVar9 = this.a;
            fVar9.getClass();
            e.l("网络采集");
            Context context9 = fVar9.f2603e;
            q qVarC = q.c(context9);
            qVarC.getClass();
            e.g("网络采集", "网络采集校验");
            if (androidx.activity.result.a.i((Context) qVarC.a, "config_dm", 0, "key_network_report_switch", "Y")) {
                z3 = true;
            } else {
                e.c("网络采集", "上报开关未开启，请检查平台配置");
                z3 = false;
            }
            if (z3) {
                ((ThreadPoolExecutor) g.B()).execute(new c(fVar9, 11));
            }
            e.l("Wifi采集");
            u0.g gVarA = u0.g.a(context9);
            gVarA.getClass();
            e.g("Wifi采集", "Wifi列表采集校验");
            if (!androidx.activity.result.a.i(gVarA.f2647b, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                e.c("Wifi采集", "上报开关未开启，请检查平台配置");
                i3 = 0;
            }
            if (i3 != 0) {
                ((ThreadPoolExecutor) g.B()).execute(new c(fVar9, 2));
                return;
            }
            return;
        }
        f fVar10 = this.a;
        fVar10.c(false);
        e.l("流量采集");
        Context context10 = fVar10.f2603e;
        d dVarC = d.c(context10);
        dVarC.getClass();
        e.g("流量采集", "流量采集上报检查");
        Context context11 = dVarC.a;
        if (!androidx.activity.result.a.i(context11, "config_dm", 0, "KEY_TIME_RELATED_TRAFFIC_SWITCH", null)) {
            str = "上报开关未开启，请检查平台配置";
        } else {
            if (g.Q(context11)) {
                if (d.c(context11).f()) {
                    z4 = true;
                } else {
                    str = "采集时间异常，不上报";
                }
                if (z4) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 12));
                }
                e.l("充电采集");
                u0.g gVarB2 = u0.g.b(context10);
                gVarB2.getClass();
                e.g("充电采集", "充电上报校验");
                context = gVarB2.f2647b;
                if (!androidx.activity.result.a.i(context, "config_dm", 0, "key_battery_charging_report_switch", "Y")) {
                    if (g.Q(context)) {
                        z5 = true;
                    } else {
                        str2 = "非WIFI网络,不上报";
                    }
                    if (z5) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 7));
                    }
                    e.l("蓝牙采集");
                    j jVarD2 = j.d(context10);
                    jVarD2.getClass();
                    e.g("蓝牙采集", "蓝牙上报校验");
                    context2 = (Context) jVarD2.f2656b;
                    if (!androidx.activity.result.a.i(context2, "config_dm", 0, "key_bluetooth_report_switch", "Y")) {
                        if (g.Q(context2)) {
                            z6 = true;
                        } else {
                            str3 = "非WIFI网络,不上报";
                        }
                        if (z6) {
                            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 10));
                        }
                        e.l("网络采集");
                        q qVarC2 = q.c(context10);
                        qVarC2.getClass();
                        e.g("网络采集", "网络采集上报校验");
                        context3 = (Context) qVarC2.a;
                        if (!androidx.activity.result.a.i(context3, "config_dm", 0, "key_network_report_switch", "Y")) {
                            if (g.Q(context3)) {
                                z7 = true;
                            } else {
                                str4 = "非WIFI网络,不上报";
                            }
                            if (z7) {
                                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
                            }
                            e.l("Wifi采集");
                            u0.g gVarA2 = u0.g.a(context10);
                            gVarA2.getClass();
                            e.g("Wifi采集", "Wifi列表上报校验");
                            context4 = gVarA2.f2647b;
                            if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                                if (!g.Q(context4)) {
                                }
                                if (i3 != 0) {
                                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                                }
                            }
                            str5 = "上报开关未开启，请检查平台配置";
                            e.i("Wifi采集", str5);
                            i3 = 0;
                            if (i3 != 0) {
                                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                            }
                        }
                        str4 = "上报开关未开启，请检查平台配置";
                        e.i("网络采集", str4);
                        z7 = false;
                        if (z7) {
                            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
                        }
                        e.l("Wifi采集");
                        u0.g gVarA3 = u0.g.a(context10);
                        gVarA3.getClass();
                        e.g("Wifi采集", "Wifi列表上报校验");
                        context4 = gVarA3.f2647b;
                        if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                            if (!g.Q(context4)) {
                            }
                            if (i3 != 0) {
                                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                            }
                        }
                        str5 = "上报开关未开启，请检查平台配置";
                        e.i("Wifi采集", str5);
                        i3 = 0;
                        if (i3 != 0) {
                            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                        }
                    }
                    str3 = "上报开关未开启，请检查平台配置";
                    e.i("蓝牙采集", str3);
                    z6 = false;
                    if (z6) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 10));
                    }
                    e.l("网络采集");
                    q qVarC3 = q.c(context10);
                    qVarC3.getClass();
                    e.g("网络采集", "网络采集上报校验");
                    context3 = (Context) qVarC3.a;
                    if (!androidx.activity.result.a.i(context3, "config_dm", 0, "key_network_report_switch", "Y")) {
                        if (g.Q(context3)) {
                            str4 = "非WIFI网络,不上报";
                        } else {
                            z7 = true;
                        }
                        if (z7) {
                            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
                        }
                        e.l("Wifi采集");
                        u0.g gVarA4 = u0.g.a(context10);
                        gVarA4.getClass();
                        e.g("Wifi采集", "Wifi列表上报校验");
                        context4 = gVarA4.f2647b;
                        if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                            if (!g.Q(context4)) {
                            }
                            if (i3 != 0) {
                                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                            }
                        }
                        str5 = "上报开关未开启，请检查平台配置";
                        e.i("Wifi采集", str5);
                        i3 = 0;
                        if (i3 != 0) {
                            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                        }
                    }
                    str4 = "上报开关未开启，请检查平台配置";
                    e.i("网络采集", str4);
                    z7 = false;
                    if (z7) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
                    }
                    e.l("Wifi采集");
                    u0.g gVarA5 = u0.g.a(context10);
                    gVarA5.getClass();
                    e.g("Wifi采集", "Wifi列表上报校验");
                    context4 = gVarA5.f2647b;
                    if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                        if (!g.Q(context4)) {
                        }
                        if (i3 != 0) {
                            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                        }
                    }
                    str5 = "上报开关未开启，请检查平台配置";
                    e.i("Wifi采集", str5);
                    i3 = 0;
                    if (i3 != 0) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                    }
                }
                str2 = "上报开关未开启，请检查平台配置";
                e.i("充电采集", str2);
                z5 = false;
                if (z5) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 7));
                }
                e.l("蓝牙采集");
                j jVarD3 = j.d(context10);
                jVarD3.getClass();
                e.g("蓝牙采集", "蓝牙上报校验");
                context2 = (Context) jVarD3.f2656b;
                if (!androidx.activity.result.a.i(context2, "config_dm", 0, "key_bluetooth_report_switch", "Y")) {
                    if (g.Q(context2)) {
                        str3 = "非WIFI网络,不上报";
                    } else {
                        z6 = true;
                    }
                    if (z6) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 10));
                    }
                    e.l("网络采集");
                    q qVarC4 = q.c(context10);
                    qVarC4.getClass();
                    e.g("网络采集", "网络采集上报校验");
                    context3 = (Context) qVarC4.a;
                    if (!androidx.activity.result.a.i(context3, "config_dm", 0, "key_network_report_switch", "Y")) {
                        if (g.Q(context3)) {
                            str4 = "非WIFI网络,不上报";
                        } else {
                            z7 = true;
                        }
                        if (z7) {
                            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
                        }
                        e.l("Wifi采集");
                        u0.g gVarA6 = u0.g.a(context10);
                        gVarA6.getClass();
                        e.g("Wifi采集", "Wifi列表上报校验");
                        context4 = gVarA6.f2647b;
                        if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                            if (!g.Q(context4)) {
                            }
                            if (i3 != 0) {
                                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                            }
                        }
                        str5 = "上报开关未开启，请检查平台配置";
                        e.i("Wifi采集", str5);
                        i3 = 0;
                        if (i3 != 0) {
                            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                        }
                    }
                    str4 = "上报开关未开启，请检查平台配置";
                    e.i("网络采集", str4);
                    z7 = false;
                    if (z7) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
                    }
                    e.l("Wifi采集");
                    u0.g gVarA7 = u0.g.a(context10);
                    gVarA7.getClass();
                    e.g("Wifi采集", "Wifi列表上报校验");
                    context4 = gVarA7.f2647b;
                    if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                        if (!g.Q(context4)) {
                        }
                        if (i3 != 0) {
                            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                        }
                    }
                    str5 = "上报开关未开启，请检查平台配置";
                    e.i("Wifi采集", str5);
                    i3 = 0;
                    if (i3 != 0) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                    }
                }
                str3 = "上报开关未开启，请检查平台配置";
                e.i("蓝牙采集", str3);
                z6 = false;
                if (z6) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 10));
                }
                e.l("网络采集");
                q qVarC5 = q.c(context10);
                qVarC5.getClass();
                e.g("网络采集", "网络采集上报校验");
                context3 = (Context) qVarC5.a;
                if (!androidx.activity.result.a.i(context3, "config_dm", 0, "key_network_report_switch", "Y")) {
                    if (g.Q(context3)) {
                        str4 = "非WIFI网络,不上报";
                    } else {
                        z7 = true;
                    }
                    if (z7) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
                    }
                    e.l("Wifi采集");
                    u0.g gVarA8 = u0.g.a(context10);
                    gVarA8.getClass();
                    e.g("Wifi采集", "Wifi列表上报校验");
                    context4 = gVarA8.f2647b;
                    if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                        if (!g.Q(context4)) {
                        }
                        if (i3 != 0) {
                            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                        }
                    }
                    str5 = "上报开关未开启，请检查平台配置";
                    e.i("Wifi采集", str5);
                    i3 = 0;
                    if (i3 != 0) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                    }
                }
                str4 = "上报开关未开启，请检查平台配置";
                e.i("网络采集", str4);
                z7 = false;
                if (z7) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
                }
                e.l("Wifi采集");
                u0.g gVarA9 = u0.g.a(context10);
                gVarA9.getClass();
                e.g("Wifi采集", "Wifi列表上报校验");
                context4 = gVarA9.f2647b;
                if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                    if (!g.Q(context4)) {
                    }
                    if (i3 != 0) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                    }
                }
                str5 = "上报开关未开启，请检查平台配置";
                e.i("Wifi采集", str5);
                i3 = 0;
                if (i3 != 0) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                }
            }
            str = "非WIFI网络,不上报";
        }
        e.i("流量采集", str);
        z4 = false;
        if (z4) {
            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 12));
        }
        e.l("充电采集");
        u0.g gVarB3 = u0.g.b(context10);
        gVarB3.getClass();
        e.g("充电采集", "充电上报校验");
        context = gVarB3.f2647b;
        if (!androidx.activity.result.a.i(context, "config_dm", 0, "key_battery_charging_report_switch", "Y")) {
            if (g.Q(context)) {
                str2 = "非WIFI网络,不上报";
            } else {
                z5 = true;
            }
            if (z5) {
                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 7));
            }
            e.l("蓝牙采集");
            j jVarD4 = j.d(context10);
            jVarD4.getClass();
            e.g("蓝牙采集", "蓝牙上报校验");
            context2 = (Context) jVarD4.f2656b;
            if (!androidx.activity.result.a.i(context2, "config_dm", 0, "key_bluetooth_report_switch", "Y")) {
                if (g.Q(context2)) {
                    str3 = "非WIFI网络,不上报";
                } else {
                    z6 = true;
                }
                if (z6) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 10));
                }
                e.l("网络采集");
                q qVarC6 = q.c(context10);
                qVarC6.getClass();
                e.g("网络采集", "网络采集上报校验");
                context3 = (Context) qVarC6.a;
                if (!androidx.activity.result.a.i(context3, "config_dm", 0, "key_network_report_switch", "Y")) {
                    if (g.Q(context3)) {
                        str4 = "非WIFI网络,不上报";
                    } else {
                        z7 = true;
                    }
                    if (z7) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
                    }
                    e.l("Wifi采集");
                    u0.g gVarA10 = u0.g.a(context10);
                    gVarA10.getClass();
                    e.g("Wifi采集", "Wifi列表上报校验");
                    context4 = gVarA10.f2647b;
                    if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                        if (!g.Q(context4)) {
                        }
                        if (i3 != 0) {
                            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                        }
                    }
                    str5 = "上报开关未开启，请检查平台配置";
                    e.i("Wifi采集", str5);
                    i3 = 0;
                    if (i3 != 0) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                    }
                }
                str4 = "上报开关未开启，请检查平台配置";
                e.i("网络采集", str4);
                z7 = false;
                if (z7) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
                }
                e.l("Wifi采集");
                u0.g gVarA11 = u0.g.a(context10);
                gVarA11.getClass();
                e.g("Wifi采集", "Wifi列表上报校验");
                context4 = gVarA11.f2647b;
                if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                    if (!g.Q(context4)) {
                    }
                    if (i3 != 0) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                    }
                }
                str5 = "上报开关未开启，请检查平台配置";
                e.i("Wifi采集", str5);
                i3 = 0;
                if (i3 != 0) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                }
            }
            str3 = "上报开关未开启，请检查平台配置";
            e.i("蓝牙采集", str3);
            z6 = false;
            if (z6) {
                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 10));
            }
            e.l("网络采集");
            q qVarC7 = q.c(context10);
            qVarC7.getClass();
            e.g("网络采集", "网络采集上报校验");
            context3 = (Context) qVarC7.a;
            if (!androidx.activity.result.a.i(context3, "config_dm", 0, "key_network_report_switch", "Y")) {
                if (g.Q(context3)) {
                    str4 = "非WIFI网络,不上报";
                } else {
                    z7 = true;
                }
                if (z7) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
                }
                e.l("Wifi采集");
                u0.g gVarA12 = u0.g.a(context10);
                gVarA12.getClass();
                e.g("Wifi采集", "Wifi列表上报校验");
                context4 = gVarA12.f2647b;
                if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                    if (!g.Q(context4)) {
                    }
                    if (i3 != 0) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                    }
                }
                str5 = "上报开关未开启，请检查平台配置";
                e.i("Wifi采集", str5);
                i3 = 0;
                if (i3 != 0) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                }
            }
            str4 = "上报开关未开启，请检查平台配置";
            e.i("网络采集", str4);
            z7 = false;
            if (z7) {
                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
            }
            e.l("Wifi采集");
            u0.g gVarA13 = u0.g.a(context10);
            gVarA13.getClass();
            e.g("Wifi采集", "Wifi列表上报校验");
            context4 = gVarA13.f2647b;
            if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                if (!g.Q(context4)) {
                }
                if (i3 != 0) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                }
            }
            str5 = "上报开关未开启，请检查平台配置";
            e.i("Wifi采集", str5);
            i3 = 0;
            if (i3 != 0) {
                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
            }
        }
        str2 = "上报开关未开启，请检查平台配置";
        e.i("充电采集", str2);
        z5 = false;
        if (z5) {
            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 7));
        }
        e.l("蓝牙采集");
        j jVarD5 = j.d(context10);
        jVarD5.getClass();
        e.g("蓝牙采集", "蓝牙上报校验");
        context2 = (Context) jVarD5.f2656b;
        if (!androidx.activity.result.a.i(context2, "config_dm", 0, "key_bluetooth_report_switch", "Y")) {
            if (g.Q(context2)) {
                str3 = "非WIFI网络,不上报";
            } else {
                z6 = true;
            }
            if (z6) {
                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 10));
            }
            e.l("网络采集");
            q qVarC8 = q.c(context10);
            qVarC8.getClass();
            e.g("网络采集", "网络采集上报校验");
            context3 = (Context) qVarC8.a;
            if (!androidx.activity.result.a.i(context3, "config_dm", 0, "key_network_report_switch", "Y")) {
                if (g.Q(context3)) {
                    str4 = "非WIFI网络,不上报";
                } else {
                    z7 = true;
                }
                if (z7) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
                }
                e.l("Wifi采集");
                u0.g gVarA14 = u0.g.a(context10);
                gVarA14.getClass();
                e.g("Wifi采集", "Wifi列表上报校验");
                context4 = gVarA14.f2647b;
                if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                    if (!g.Q(context4)) {
                    }
                    if (i3 != 0) {
                        ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                    }
                }
                str5 = "上报开关未开启，请检查平台配置";
                e.i("Wifi采集", str5);
                i3 = 0;
                if (i3 != 0) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                }
            }
            str4 = "上报开关未开启，请检查平台配置";
            e.i("网络采集", str4);
            z7 = false;
            if (z7) {
                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
            }
            e.l("Wifi采集");
            u0.g gVarA15 = u0.g.a(context10);
            gVarA15.getClass();
            e.g("Wifi采集", "Wifi列表上报校验");
            context4 = gVarA15.f2647b;
            if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                if (!g.Q(context4)) {
                }
                if (i3 != 0) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                }
            }
            str5 = "上报开关未开启，请检查平台配置";
            e.i("Wifi采集", str5);
            i3 = 0;
            if (i3 != 0) {
                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
            }
        }
        str3 = "上报开关未开启，请检查平台配置";
        e.i("蓝牙采集", str3);
        z6 = false;
        if (z6) {
            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 10));
        }
        e.l("网络采集");
        q qVarC9 = q.c(context10);
        qVarC9.getClass();
        e.g("网络采集", "网络采集上报校验");
        context3 = (Context) qVarC9.a;
        if (!androidx.activity.result.a.i(context3, "config_dm", 0, "key_network_report_switch", "Y")) {
            if (g.Q(context3)) {
                str4 = "非WIFI网络,不上报";
            } else {
                z7 = true;
            }
            if (z7) {
                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
            }
            e.l("Wifi采集");
            u0.g gVarA16 = u0.g.a(context10);
            gVarA16.getClass();
            e.g("Wifi采集", "Wifi列表上报校验");
            context4 = gVarA16.f2647b;
            if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
                if (!g.Q(context4)) {
                }
                if (i3 != 0) {
                    ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
                }
            }
            str5 = "上报开关未开启，请检查平台配置";
            e.i("Wifi采集", str5);
            i3 = 0;
            if (i3 != 0) {
                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
            }
        }
        str4 = "上报开关未开启，请检查平台配置";
        e.i("网络采集", str4);
        z7 = false;
        if (z7) {
            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 5));
        }
        e.l("Wifi采集");
        u0.g gVarA17 = u0.g.a(context10);
        gVarA17.getClass();
        e.g("Wifi采集", "Wifi列表上报校验");
        context4 = gVarA17.f2647b;
        if (!androidx.activity.result.a.i(context4, "config_dm", 0, "key_wifi_list_report_switch", "Y")) {
            if (!g.Q(context4)) {
            }
            if (i3 != 0) {
                ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
            }
        }
        str5 = "上报开关未开启，请检查平台配置";
        e.i("Wifi采集", str5);
        i3 = 0;
        if (i3 != 0) {
            ((ThreadPoolExecutor) g.B()).execute(new c(fVar10, 9));
        }
    }

    public final boolean b() {
        if (!g.l0(getSharedPreferences("config_dm", 0).getString("SLEEP_SWITCH", null))) {
            return false;
        }
        long j3 = getSharedPreferences("config_dm", 0).getLong("KEY_SLEEP_START_TIME", 0L);
        long j4 = getSharedPreferences("config_dm", 0).getLong("KEY_SLEEP_END_TIME", 0L);
        e.g("控制功能", "休眠时间:" + e.f(j3) + "~" + e.f(j4));
        if (j3 <= 0 || j4 <= 0) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        e.g("控制功能", "currentTime: " + e.f(jCurrentTimeMillis));
        return j3 < jCurrentTimeMillis && jCurrentTimeMillis < j4;
    }

    public final void c() {
        e.g("控制功能", "initController");
        u0.e eVarG = u0.e.g(this);
        f fVar = null;
        if ("N".equals(getSharedPreferences("config_dm", 0).getString("DYNAMIC_LOAD_SWITCH", null))) {
            if (eVarG.f() != null) {
                eVarG.f().delete();
            }
            j2.a.K0((Context) eVarG.f2641b, "DM_PATCH_VERSION", Constant.SP_MODEL);
            e.o("控制功能", "动态更新开关未开启");
        } else {
            try {
                if (eVarG.f() == null) {
                    e.g("控制功能", "本地无动态包");
                } else {
                    Class<?> clsLoadClass = new DexClassLoader(eVarG.h(), getCacheDir().getAbsolutePath(), null, DMService.class.getClassLoader()).loadClass("cn.richinfo.dmpatch.business.DMController");
                    String str = (String) clsLoadClass.getMethod("getPatchVersion", new Class[0]).invoke(null, new Object[0]);
                    if (str == null || !str.startsWith(MTSDK.API_VERSION)) {
                        StringBuilder sb = new StringBuilder("动态包版本信息为：");
                        sb.append(str);
                        sb.append("，无法匹配，不加载动态包");
                        e.o("控制功能", sb.toString());
                        if (eVarG.f() != null) {
                            eVarG.f().delete();
                        }
                        j2.a.K0((Context) eVarG.f2641b, "DM_PATCH_VERSION", Constant.SP_MODEL);
                    } else {
                        this.a = (f) clsLoadClass.getMethod("getInstance", Context.class).invoke(null, this);
                        e.g("控制功能", "动态包加载完成");
                        fVar = this.a;
                    }
                }
            } catch (Exception e3) {
                androidx.activity.result.a.f(e3, new StringBuilder("加载动态包异常："), "控制功能");
            }
        }
        this.a = fVar;
        if (fVar == null) {
            this.a = f.b(this);
        } else {
            e.m("控制功能", "动态包已加载");
        }
    }

    public final void d() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[10];
        objArr[0] = Long.valueOf(g.f2606d);
        objArr[1] = g.x(this);
        objArr[2] = Long.valueOf(g.f2605c);
        objArr[3] = g.f2609g;
        objArr[4] = Long.valueOf(g.f2604b);
        objArr[5] = Boolean.valueOf(g.f2607e);
        Boolean bool = Boolean.TRUE;
        objArr[6] = bool;
        objArr[7] = bool;
        objArr[8] = Boolean.FALSE;
        objArr[9] = Boolean.valueOf(g.f2610h == null);
        e.g("控制功能", String.format(locale, "SDK初始化配置为:\ngetMinAppUpdateTime=%s\ngetBaseConfigUrl=%s\ngetSleepTime=%s\ngetDebugLogPath=%s\ngetTimeUnit=%s\nisReportLog=%s\nisReportApp=%s\nisCollectPreinstall=%s\nisKeepSecret=%s\nlistener==null(%s)\n", objArr));
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            try {
                this.f545b = new a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("cn.richinfo.dmyk.action.THIRD_REQUEST_DYNAMIC");
                registerReceiver(this.f545b, intentFilter, "com.dm.permission.THIRD_SEND", null, 2);
            } catch (Exception e3) {
                e.e("控制功能", e3.getMessage());
                return;
            }
        } catch (Exception e4) {
            e.e("控制功能", e4.getMessage());
        }
        int i3 = z0.d.a;
        getFilesDir().getPath();
        c();
        try {
            d();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        e.g("控制功能", "Service 销毁");
        a aVar = this.f545b;
        if (aVar != null) {
            unregisterReceiver(aVar);
            this.f545b = null;
        }
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i4) {
        e.g("控制功能", "日志上报检查");
        boolean z3 = false;
        long j3 = getSharedPreferences("config_dm", 0).getLong("key_log_start_time", 0L);
        long j4 = getSharedPreferences("config_dm", 0).getLong("key_log_end_time", 0L);
        e.d("控制功能", "logCheck:start=" + e.f(j3) + ",end=" + e.f(j4));
        if (j3 != 0 && j4 != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (j3 < jCurrentTimeMillis && jCurrentTimeMillis < j4) {
                z3 = true;
            }
        }
        e.d("DMSDK", "setReportLog() called with: reportLog = " + z3 + "");
        g.f2607e = z3;
        p.a().a = z3 ? g.a : null;
        try {
            if (b()) {
                e.i("控制功能", "SDK need to sleep");
            } else {
                a(intent);
            }
        } catch (Exception e3) {
            e.e("控制功能", e3.getMessage());
        }
        return super.onStartCommand(intent, i3, i4);
    }
}
