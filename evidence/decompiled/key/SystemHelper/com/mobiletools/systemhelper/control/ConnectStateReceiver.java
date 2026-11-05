package com.mobiletools.systemhelper.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import g1.d;
import g1.h;
import g1.l;

/* JADX INFO: loaded from: classes.dex */
public class ConnectStateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f2187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConnectStateReceiver f2188b;

    public static void a() {
        ConnectStateReceiver connectStateReceiver = f2188b;
        if (connectStateReceiver != null) {
            f2187a.unregisterReceiver(connectStateReceiver);
            h.a("ConnectStateReceiver", "ConnectStateReceiver cancel watch-->");
            f2188b = null;
            d.f2658k = false;
        }
    }

    public void b(Context context) {
        f2187a = context;
        a();
        d.f2658k = true;
        f2188b = this;
        h.a("ConnectStateReceiver", "ConnectStateReceiver startWatch-->");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        f2187a.registerReceiver(this, intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f2187a = context;
        h.a("ConnectStateReceiver", "onReceive-->intent action: " + intent.getAction());
        if (d.f2658k) {
            d.f2658k = false;
            return;
        }
        String action = intent.getAction();
        if (action == null || !action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            return;
        }
        h.a("ConnectStateReceiver", !l.t(f2187a).booleanValue() ? "NetWork disconnected" : "NetWork connected");
    }
}
