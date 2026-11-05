package com.mobiletools.systemhelper.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import e1.b;
import f1.a;
import f1.o;
import g1.h;
import g1.l;

/* JADX INFO: loaded from: classes.dex */
public class SignalInfoRegisterReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f2200a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f2200a = context;
        h.a("SignalInfoRegisterReceiver", "onReceive-->intent action: " + intent.getAction());
        a.n(context);
        g1.a.f(f2200a, l.h(context), l.l(context));
        o.f();
        if (o.e(context) != null) {
            b.a(f2200a, "R");
        }
    }
}
