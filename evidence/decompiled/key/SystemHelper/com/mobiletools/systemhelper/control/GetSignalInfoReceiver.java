package com.mobiletools.systemhelper.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import b1.b;
import b1.c;
import b1.g;
import e1.d;
import f1.o;
import g1.h;
import g1.l;
import g1.m;
import g1.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GetSignalInfoReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f2189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static b f2190e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2191a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    n f2192b = new n();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f2193c;

    class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f2194a;

        a(Context context) {
            this.f2194a = context;
        }

        @Override // b1.b
        public void d(c cVar) {
            String str;
            String str2;
            if (cVar == null || cVar.v() == 167 || cVar.v() == 67 || cVar.v() == 62) {
                h.b("GetSignalInfoReceiver", "定位失败！");
                return;
            }
            h.a("GetSignalInfoReceiver", "定位成功！");
            GetSignalInfoReceiver.this.f2192b.D = String.valueOf(cVar.x());
            GetSignalInfoReceiver.this.f2192b.E = String.valueOf(cVar.u());
            GetSignalInfoReceiver.this.f2192b.F = String.valueOf(cVar.e());
            String strK = cVar.k();
            String strD = cVar.D();
            String strH = cVar.h();
            String strM = cVar.m();
            GetSignalInfoReceiver.this.f2192b.G = "" + strK + strD + strH + strM;
            int i2 = f1.a.i(0);
            if (i2 > 0 && (str2 = GetSignalInfoReceiver.this.f2192b.D) != null && str2 != "") {
                h.a("GetSignalInfoReceiver", "signalInfo.longitude: " + GetSignalInfoReceiver.this.f2192b.D);
                h.a("GetSignalInfoReceiver", "Receiver subIdSlot1: " + i2);
                new d().e(this.f2194a, 0, GetSignalInfoReceiver.this.f2192b);
                JSONObject jSONObjectA = GetSignalInfoReceiver.this.f2192b.a();
                h.a("GetSignalInfoReceiver", "siginfo: " + jSONObjectA);
                if (jSONObjectA != null) {
                    try {
                        n nVar = GetSignalInfoReceiver.this.f2192b;
                        if (nVar.f2693f != null && GetSignalInfoReceiver.e(nVar).booleanValue()) {
                            m mVarB = m.b(GetSignalInfoReceiver.f2189d, m.f2684c, m.f2683b.intValue());
                            mVarB.c(jSONObjectA.toString());
                            mVarB.close();
                        }
                    } catch (Exception e2) {
                        h.b("GetSignalInfoReceiver", "inSigChinaNetwork");
                        e2.printStackTrace();
                    }
                }
            }
            int i3 = f1.a.i(1);
            if (i3 > 0 && (str = GetSignalInfoReceiver.this.f2192b.D) != null && str != "") {
                h.a("GetSignalInfoReceiver", "signalInfo.longitude: " + GetSignalInfoReceiver.this.f2192b.D);
                h.a("GetSignalInfoReceiver", "Receiver subIdSlot2: " + i3);
                new d().e(this.f2194a, 1, GetSignalInfoReceiver.this.f2192b);
                JSONObject jSONObjectA2 = GetSignalInfoReceiver.this.f2192b.a();
                h.a("GetSignalInfoReceiver", "siginfo: " + jSONObjectA2);
                if (jSONObjectA2 != null) {
                    try {
                        n nVar2 = GetSignalInfoReceiver.this.f2192b;
                        if (nVar2.f2693f != null && GetSignalInfoReceiver.e(nVar2).booleanValue()) {
                            m mVarB2 = m.b(GetSignalInfoReceiver.f2189d, m.f2684c, m.f2683b.intValue());
                            mVarB2.c(jSONObjectA2.toString());
                            mVarB2.close();
                        }
                    } catch (Exception e3) {
                        h.b("GetSignalInfoReceiver", "inSigChinaNetwork");
                        e3.printStackTrace();
                    }
                }
            }
            h.a("GetSignalInfoReceiver", "经纬度信息signalInfo.longitude： " + GetSignalInfoReceiver.this.f2192b.D + ", " + GetSignalInfoReceiver.this.f2192b.E + ", " + GetSignalInfoReceiver.this.f2192b.F);
        }
    }

    private boolean b(Context context) {
        boolean z2 = false;
        Boolean boolValueOf = Boolean.valueOf(Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) == 1);
        h.a("GetSignalInfoReceiver", "isBootWizardCompleted: " + boolValueOf);
        if (boolValueOf.booleanValue()) {
            z2 = Settings.Secure.getInt(context.getContentResolver(), "operator_service_improve_plan", 0) == 1;
            h.a("GetSignalInfoReceiver", "checkUserPermission:" + z2);
        }
        return z2;
    }

    private boolean c(Context context) {
        Boolean boolValueOf = Boolean.valueOf(Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) == 1);
        h.a("GetSignalInfoReceiver", "isBootWizardCompleted: " + boolValueOf);
        return boolValueOf.booleanValue();
    }

    public static Boolean e(n nVar) {
        h.a("GetSignalInfoReceiver", "siginfo.mncCH: " + nVar.f2693f);
        String str = nVar.f2693f;
        if (str == null || str.isEmpty()) {
            return Boolean.FALSE;
        }
        return nVar.f2693f.startsWith("460") ? Boolean.TRUE : Boolean.FALSE;
    }

    public void d(b bVar) {
        g.r0(true);
        g gVar = this.f2193c;
        if (gVar != null) {
            gVar.n0(bVar);
            b1.h hVar = new b1.h();
            hVar.k("bd09ll");
            hVar.n(b1.h.b.Hight_Accuracy);
            hVar.p(true);
            hVar.q(0);
            hVar.m(true);
            hVar.l(true);
            this.f2193c.s0(hVar);
            this.f2193c.t0();
            h.a("GetSignalInfoReceiver", "mLocationClient start!");
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f2189d = context;
        String strO = l.o("ro.product.manufacturer");
        g.r0(true);
        f1.a.n(context);
        h.a("GetSignalInfoReceiver", "enter GetSignalInfoReceiver --->");
        try {
            this.f2193c = new g(f2189d);
            g1.a.c(f2189d, l.m(context));
            if (strO != null && !strO.isEmpty()) {
                g1.d.f2652e = strO.equalsIgnoreCase("vivo") ? b(f2189d) : c(f2189d);
            }
            if (g1.d.f2652e) {
                a aVar = new a(context);
                f2190e = aVar;
                d(aVar);
                o.f();
                o.e(context);
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
