package com.mobiletools.systemhelper.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import g1.d;
import g1.h;

/* JADX INFO: loaded from: classes.dex */
public class SIMStateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f2197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SIMStateReceiver f2198b;

    public static void a() {
        SIMStateReceiver sIMStateReceiver = f2198b;
        if (sIMStateReceiver != null) {
            f2197a.unregisterReceiver(sIMStateReceiver);
            h.a("SIMStateReceiver", "SimStateReceiver cancel watch-->");
            f2198b = null;
            d.f2657j = false;
        }
    }

    public void b(Context context) {
        f2197a = context;
        a();
        d.f2657j = true;
        f2198b = this;
        h.a("SIMStateReceiver", "SimStateReceiver startWatch-->");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");
        f2197a.registerReceiver(this, intentFilter);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        if (r2 != 6) goto L24;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r3, android.content.Intent r4) {
        /*
            r2 = this;
            com.mobiletools.systemhelper.control.SIMStateReceiver.f2197a = r3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = "onReceive-->intent action: "
            r2.append(r0)
            java.lang.String r0 = r4.getAction()
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = "SIMStateReceiver"
            g1.h.a(r0, r2)
            boolean r2 = g1.d.f2657j
            if (r2 == 0) goto L24
            r2 = 0
            g1.d.f2657j = r2
            return
        L24:
            java.lang.String r2 = r4.getAction()
            if (r2 == 0) goto L78
            java.lang.String r4 = "android.intent.action.SIM_STATE_CHANGED"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L78
            java.lang.String r2 = "phone"
            java.lang.Object r2 = r3.getSystemService(r2)
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2
            int r2 = r2.getSimState()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "SIM_STATE_CHANGED, state:"
            r4.append(r1)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            g1.h.a(r0, r4)
            if (r2 == 0) goto L5e
            r4 = 1
            if (r2 == r4) goto L61
            r4 = 5
            if (r2 == r4) goto L67
            r4 = 6
            if (r2 == r4) goto L64
            goto L78
        L5e:
            f1.a.s(r3)
        L61:
            f1.a.s(r3)
        L64:
            f1.a.s(r3)
        L67:
            f1.a.n(r3)
            java.lang.String r2 = "wait for sim ready for 6 minutes-->"
            g1.h.a(r0, r2)
            android.content.Context r2 = com.mobiletools.systemhelper.control.SIMStateReceiver.f2197a
            r3 = 180000(0x2bf20, double:8.8932E-319)
            g1.a.d(r2, r3)
            return
        L78:
            f1.o.f()
            f1.o$c r2 = f1.o.e(r3)
            if (r2 == 0) goto L8b
            android.content.Context r2 = com.mobiletools.systemhelper.control.SIMStateReceiver.f2197a
            java.lang.String r4 = "T"
            e1.b.a(r2, r4)
            f1.a.s(r3)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobiletools.systemhelper.control.SIMStateReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
