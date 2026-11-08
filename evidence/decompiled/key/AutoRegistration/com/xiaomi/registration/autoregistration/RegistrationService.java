package com.xiaomi.registration.autoregistration;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import g2.e;
import i1.o;
import i1.p;
import j1.a;
import j1.c;
import k1.d;
import miui.os.UserHandle;

/* JADX INFO: loaded from: classes.dex */
public class RegistrationService extends Service {
    public static RegistrationService a;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Log.d("AutoReg_RegistrationService", "onBind");
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Log.d("AutoReg_RegistrationService", "onCreate");
        if (UserHandle.myUserId() != 0) {
            Log.d("AutoReg_RegistrationService", "onCreate UserHandle.myUserId() != 0 return");
            return;
        }
        int i3 = d.a;
        if (e.c("ro.radio.noril") && TextUtils.isEmpty(e.g("ro.ril.oem.ctei", ""))) {
            return;
        }
        AutoRegReceiver.a = true;
        boolean z2 = (e.c("ro.radio.noril") && !TextUtils.isEmpty(e.g("ro.ril.oem.ctei", ""))) || d.d();
        Context applicationContext = getApplicationContext();
        if (z2) {
            if (c.f1828h == null) {
                c.f1828h = new c(applicationContext);
            }
        } else if (p.f1744u == null) {
            p.f1744u = new p(applicationContext);
        }
        a = this;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        Log.d("AutoReg_RegistrationService", "onDestroy");
        int i3 = d.a;
        boolean z2 = true;
        if (!(e.c("ro.radio.noril") && !TextUtils.isEmpty(e.g("ro.ril.oem.ctei", ""))) && !d.d()) {
            z2 = false;
        }
        if (z2) {
            c cVar = c.f1828h;
            cVar.getClass();
            Log.i("Ctei_RegistrationTracker", "teardown");
            cVar.c();
            cVar.d();
            a aVar = cVar.f1830c;
            Context context = cVar.f1833f;
            if (aVar != null) {
                context.unregisterReceiver(aVar);
            }
            a aVar2 = cVar.f1831d;
            if (aVar2 != null) {
                context.unregisterReceiver(aVar2);
            }
        } else {
            p pVar = p.f1744u;
            pVar.a();
            o oVar = pVar.f1750f;
            if (oVar != null) {
                pVar.a.unregisterReceiver(oVar);
                pVar.f1750f = null;
            }
        }
        a = null;
    }
}
