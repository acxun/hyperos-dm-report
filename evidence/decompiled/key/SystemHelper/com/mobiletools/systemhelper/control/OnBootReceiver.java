package com.mobiletools.systemhelper.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import e1.b;
import f1.a;
import f1.o;
import g1.d;
import g1.h;
import g1.l;

/* JADX INFO: loaded from: classes.dex */
public class OnBootReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f2196a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f2196a = context;
        if (!d.f2649b) {
            d.f2648a = l.d(context, "preference_enable_log", Boolean.FALSE).booleanValue();
        }
        h.a("OnBootReceiver", "onReceive-->intent action: " + intent.getAction());
        a.n(context);
        String action = intent.getAction();
        if (action != null && (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.QUICKBOOT_POWERON"))) {
            h.a("OnBootReceiver", " boot delayed for 4 minutes-->");
            g1.a.b(f2196a, 240000L);
            g1.a.c(f2196a, l.m(context));
            g1.a.f(f2196a, l.h(context), l.l(context));
            g1.a.e(f2196a, l.g(context), l.j(context));
            g1.a.a(f2196a, l.f(context), l.c(context));
            return;
        }
        h.a("OnBootReceiver", "SIM_STATE_CHANGED, state:" + ((TelephonyManager) context.getSystemService("phone")).getSimState());
        new SIMStateReceiver().b(f2196a.getApplicationContext());
        new ConnectStateReceiver().b(f2196a.getApplicationContext());
        o.f();
        if (o.e(context) != null) {
            String strN = l.n(context, "firstPowerOn", "");
            if (strN != null && !strN.isEmpty()) {
                b.a(f2196a, "B");
            } else {
                b.a(f2196a, "F");
                l.H(context, "firstPowerOn", "firstPowerOn");
            }
        }
    }
}
