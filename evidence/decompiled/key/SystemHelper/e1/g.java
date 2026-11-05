package e1;

import android.content.Context;
import f1.o;
import g1.h;
import g1.l;
import java.net.URLEncoder;
import java.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public class g extends Thread {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f2491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f2492c;

    public g(Context context, b bVar) {
        this.f2491b = context;
        this.f2492c = bVar;
    }

    private synchronized boolean a(b bVar) {
        boolean z2 = false;
        if (!g1.d.f2652e) {
            h.a("RegisterThread", "isUserPermissionOpen is false!");
            return false;
        }
        String strB = bVar.b();
        h.a("RegisterThread", "register postString：" + strB);
        try {
            byte[] bArrD = g1.c.d(strB);
            String strEncode = URLEncoder.encode(g1.c.b(g1.c.c(this.f2491b, bArrD)), "utf-8");
            String str = l.k(this.f2491b) + "?ver=5.0&model=" + URLEncoder.encode(bVar.f2449b, "utf-8") + "&manuf=" + URLEncoder.encode(bVar.f2447a, "utf-8") + "&sign=" + strEncode;
            byte[] bArrA = g1.c.a(strB, bArrD);
            h.a("RegisterThread", "RSA加密密文： " + str);
            h.a("RegisterThread", "AES加密密文： " + Base64.getEncoder().encodeToString(bArrA));
            try {
                g1.f fVar = new g1.f();
                boolean zB = fVar.b(str, bArrA, bArrD);
                if (!zB && fVar.a() == 416) {
                    zB = true;
                }
                z2 = zB;
            } catch (Exception e2) {
                h.b("RegisterThread", "sendPOSTRequest exception--->" + e2.toString());
            }
            return z2;
        } catch (Exception e3) {
            h.b("RegisterThread", "doEncrpytPost catch exception " + e3.getMessage());
            return false;
        }
    }

    private void b(boolean z2) {
    }

    private synchronized boolean c(b bVar) {
        if (!g1.d.f2652e) {
            h.a("RegisterThread", "isUserPermissionOpen is false!");
            return false;
        }
        if (bVar == null) {
            h.b("RegisterThread", "deviceInfo is null! ");
            return false;
        }
        if (!l.s(bVar).booleanValue()) {
            h.a("RegisterThread", "mnc is not in china!");
            return false;
        }
        if (l.t(this.f2491b).booleanValue()) {
            h.a("RegisterThread", "network connected!");
            if ((l.w(this.f2491b).booleanValue() && l.s(bVar).booleanValue()) || (!o.h(this.f2491b).booleanValue() && l.u(bVar).booleanValue())) {
                h.a("RegisterThread", "is unicomnetwork || is wifi connected!");
                if (a(bVar)) {
                    new e(this.f2491b).start();
                    return true;
                }
            } else if (!l.s(bVar).booleanValue()) {
                return false;
            }
        } else if (!l.s(bVar).booleanValue()) {
            return false;
        }
        g1.e eVarA = g1.e.a(this.f2491b, g1.e.f2672c, g1.e.f2671b.intValue());
        eVarA.b(bVar.b());
        eVarA.close();
        h.a("RegisterThread", "sava to database!");
        h.a("RegisterThread", "Not post!");
        return false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (g1.d.f2652e) {
            b(c(this.f2492c));
            return;
        }
        h.a("RegisterThread", "GlobalSetting.isUserPermissionOpen is " + g1.d.f2652e);
    }
}
