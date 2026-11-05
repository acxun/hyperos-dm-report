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
public class ScheduleRegisterReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f2199a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f2199a = context;
        h.a("ScheduleRegisterReceiver", "onReceive-->intent action: " + intent.getAction());
        a.n(context);
        g1.a.e(f2199a, l.g(context), l.j(context));
        o.f();
        if (o.e(context) != null) {
            b.a(f2199a, "S");
        }
    }
}
