package com.mobiletools.systemhelper.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import g1.d;
import g1.h;
import g1.l;

/* JADX INFO: loaded from: classes.dex */
public class RegisterHelperService extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f2201b = null;

    class a extends com.mobiletools.systemhelper.service.a.AbstractBinderC0019a {
        a() {
        }

        @Override // com.mobiletools.systemhelper.service.a
        public void a(int i2) {
            l.D(RegisterHelperService.this.f2201b, i2);
            l.x(RegisterHelperService.this.f2201b, (i2 * 8) / 5);
            long j2 = (i2 * 4) / 5;
            l.A(RegisterHelperService.this.f2201b, j2);
            l.z(RegisterHelperService.this.f2201b, j2);
            l.B(RegisterHelperService.this.f2201b, j2);
            l.F(RegisterHelperService.this.f2201b, (i2 * 6) / 5);
            l.G(RegisterHelperService.this.f2201b, (i2 * 3) / 5);
        }

        @Override // com.mobiletools.systemhelper.service.a
        public boolean b() {
            return l.d(RegisterHelperService.this.f2201b, "preference_enable_log", Boolean.FALSE).booleanValue();
        }

        @Override // com.mobiletools.systemhelper.service.a
        public void c(String str) {
            l.E(RegisterHelperService.this.f2201b, str);
        }

        @Override // com.mobiletools.systemhelper.service.a
        public void d(boolean z2) {
            d.f2648a = z2;
            l.y(RegisterHelperService.this.f2201b, "preference_enable_log", Boolean.valueOf(z2));
        }

        @Override // com.mobiletools.systemhelper.service.a
        public void e() {
            l.b(RegisterHelperService.this.f2201b);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        h.b("RegisterHelperService", "registerhelper Service onBind sucessed!");
        return new a();
    }

    @Override // android.app.Service
    public void onCreate() {
        h.b("RegisterHelperService", "registerhelper Service onCreate-->");
        Context applicationContext = getApplicationContext();
        this.f2201b = applicationContext;
        f1.a.n(applicationContext);
    }

    @Override // android.app.Service
    public void onDestroy() {
        h.b("RegisterHelperService", "registerhelper Service onDestroy--->");
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        super.onUnbind(intent);
        h.b("RegisterHelperService", "registerhelper Service onUnbind sucessed!");
        return true;
    }
}
