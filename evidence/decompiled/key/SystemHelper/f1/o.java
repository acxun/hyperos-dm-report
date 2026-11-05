package f1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, String> f2556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f2557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<g1.b> f2558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static e1.f.a f2559d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static e1.c.a f2560e = new b();

    class a implements e1.f.a {
        a() {
        }

        @Override // e1.f.a
        public void a(Context context, e1.b bVar, List<g1.b> list) {
            List unused = o.f2558c = list;
            if (o.f2558c != null) {
                JSONArray jSONArray = new JSONArray();
                for (g1.b bVar2 : o.f2558c) {
                    try {
                        if (!bVar2.a().getString("pkgName").startsWith("com.android")) {
                            jSONArray.put(bVar2.a());
                        }
                    } catch (JSONException e2) {
                        throw new RuntimeException(e2);
                    }
                }
                if (bVar != null) {
                    bVar.f2448a0 = jSONArray;
                    g1.h.a("DeviceManager", "appInfolength:" + jSONArray.length());
                }
            }
            ((g1.d.f2650c && g1.d.f2652e) ? new e1.c(context, bVar, o.f2560e) : new e1.g(context, bVar)).start();
        }
    }

    class b implements e1.c.a {
        b() {
        }

        @Override // e1.c.a
        public void a(Context context, e1.b bVar, String str, String str2) {
            if (bVar != null) {
                bVar.S = str;
                bVar.T = str2;
            }
            String str3 = bVar.T;
            if (str3 == null || str3.equals("")) {
                bVar.T = "ex01";
            }
            new e1.g(context, bVar).start();
        }
    }

    public interface c {
        boolean a(Context context);

        void b(Context context, e1.b bVar);
    }

    public static synchronized e1.b d(Context context, String str) {
        Thread gVar;
        g1.h.a("DeviceManager", "enter getCurDeviceInfo--RegType:" + str);
        e1.b bVar = new e1.b();
        bVar.W = str;
        k(context, bVar);
        if (!str.trim().equals("T")) {
            i(context, bVar);
            j(context, bVar);
        } else if (!i(context, bVar) && !j(context, bVar)) {
            g1.h.a("DeviceManager", "SIM not changed，not post！");
            return bVar;
        }
        l(bVar);
        if (!str.trim().equals("A")) {
            if (str.trim().equals("R")) {
                g1.h.a("DeviceManager", "regtype R");
                g1.m mVarB = g1.m.b(context, g1.m.f2684c, g1.m.f2683b.intValue());
                JSONArray jSONArrayD = mVarB.d();
                g1.h.a("DeviceManager", "signalJSONArray.length() : " + jSONArrayD.length());
                if (jSONArrayD.length() > 0) {
                    bVar.f2450b0 = jSONArrayD;
                    mVarB.a();
                    mVarB.close();
                    g1.h.a("DeviceManager", "signalJSONArray>>>>>:" + jSONArrayD.toString());
                    if (g1.d.f2650c && g1.d.f2652e) {
                        gVar = new e1.c(context, bVar, f2560e);
                    } else {
                        g1.h.a("DeviceManager", "GlobalSetting.isUserPermissionOpen is false,type R-appinfo is not post");
                        gVar = new e1.g(context, bVar);
                    }
                } else {
                    g1.h.a("DeviceManager", "deviceinfo.siginfo 为空！ ");
                }
            } else if (str.trim().equals("B") || str.trim().equals("F") || str.trim().equals("S") || str.trim().equals("T")) {
                if (g1.d.f2650c && g1.d.f2652e) {
                    gVar = new e1.c(context, bVar, f2560e);
                } else {
                    g1.h.a("DeviceManager", "GlobalSetting.isUserPermissionOpen is false,B/F/S/Tdeviceinfo is not post");
                    gVar = new e1.g(context, bVar);
                }
            }
            return bVar;
        }
        if (g1.d.f2652e) {
            gVar = new e1.f(context, bVar, f2559d);
        } else {
            g1.h.a("DeviceManager", "GlobalSetting.isUserPermissionOpen is false,type A-appinfo is not post");
            gVar = new e1.g(context, bVar);
        }
        gVar.start();
        return bVar;
    }

    public static c e(Context context) {
        c aVar;
        f1.a.n(context);
        c cVar = f2557b;
        if (cVar != null) {
            return cVar;
        }
        Context context2 = g1.d.f2651d;
        StringBuilder sb = new StringBuilder();
        sb.append("model is ");
        String str = Build.MODEL;
        sb.append(str);
        g1.h.c(context2, sb.toString());
        String str2 = f2556a.get(str);
        if (str2 == null) {
            g1.h.b("DeviceManager", "getReader error!! manufacture==null! model=" + str);
            aVar = new f1.a();
        } else if (str2.equals("Xiaomi")) {
            aVar = new m();
        } else if (str2.equals("OPPO")) {
            aVar = new d();
        } else if (str2.equalsIgnoreCase("vivo")) {
            aVar = new k();
        } else if (str2.equalsIgnoreCase("samsung")) {
            aVar = new h();
        } else if (str2.equalsIgnoreCase("realme")) {
            aVar = new g();
        } else if (str2.equalsIgnoreCase("ZTE")) {
            aVar = new n();
        } else if (str2.equalsIgnoreCase("nubia")) {
            aVar = new f1.c();
        } else if (str2.equalsIgnoreCase("OnePlus")) {
            aVar = new e();
        } else if (str2.equalsIgnoreCase("Liantong")) {
            aVar = new f1.b();
        } else if (str2.equalsIgnoreCase("TDTECH")) {
            aVar = new i();
        } else if (str2.equalsIgnoreCase("PTAC")) {
            aVar = new f();
        } else if (str2.equalsIgnoreCase("WIKO")) {
            aVar = new l();
        } else {
            aVar = str2.equalsIgnoreCase("Tianyi") ? new j() : new f1.a();
        }
        f2557b = aVar;
        return f2557b;
    }

    public static void f() {
        if (f2556a == null) {
            f2556a = new HashMap();
            String strO = g1.l.o("ro.product.manufacturer");
            if (strO == null || strO.isEmpty()) {
                return;
            }
            g1.h.a("DeviceManager", "manufacturer=" + strO);
            if (strO.trim().equalsIgnoreCase("vivo") || strO.trim().equalsIgnoreCase("samsung") || strO.trim().equalsIgnoreCase("realme") || strO.trim().equalsIgnoreCase("Xiaomi") || strO.trim().equalsIgnoreCase("OPPO") || strO.trim().equalsIgnoreCase("Liantong") || strO.trim().equalsIgnoreCase("OnePlus") || strO.trim().equalsIgnoreCase("TDTECH") || strO.trim().equalsIgnoreCase("nubia") || strO.trim().equalsIgnoreCase("PTAC") || strO.trim().equalsIgnoreCase("ZTE") || strO.trim().equalsIgnoreCase("WIKO") || strO.trim().equalsIgnoreCase("Tianyi")) {
                StringBuilder sb = new StringBuilder();
                sb.append("model: ");
                String str = Build.MODEL;
                sb.append(str);
                g1.h.a("DeviceManager", sb.toString());
                f2556a.put(str, strO);
            }
        }
    }

    public static boolean g(Context context) {
        c cVarE;
        if (context == null || (cVarE = e(context)) == null) {
            return false;
        }
        return cVarE.a(context);
    }

    public static Boolean h(Context context) {
        if (context == null) {
            return Boolean.FALSE;
        }
        f();
        return Boolean.valueOf(g(context));
    }

    private static synchronized boolean i(Context context, e1.b bVar) {
        String strN = g1.l.n(context, "iccid1", null);
        if (strN == null || strN.isEmpty()) {
            String str = bVar.f2457h;
            if (str != null && !str.isEmpty()) {
                g1.h.a("DeviceManager", "SIM1 Changed,old iccid:" + strN + ", new iccid:" + bVar.f2457h);
                g1.l.H(context, "iccid1", bVar.f2457h);
                return true;
            }
        } else if (!strN.equals(bVar.f2457h)) {
            g1.h.a("DeviceManager", "SIM1 Changed,old iccid:" + strN + ", new iccid:" + bVar.f2457h);
            g1.l.H(context, "iccid1", bVar.f2457h);
            return true;
        }
        return false;
    }

    private static synchronized boolean j(Context context, e1.b bVar) {
        String strN = g1.l.n(context, "iccid2", null);
        if (strN == null || strN.isEmpty()) {
            String str = bVar.f2470u;
            if (str != null && !str.isEmpty()) {
                g1.h.a("DeviceManager", "SIM2 Changed,old iccid:" + strN + ", new iccid:" + bVar.f2470u);
                g1.l.H(context, "iccid2", bVar.f2470u);
                return true;
            }
        } else if (!strN.equals(bVar.f2470u)) {
            g1.h.a("DeviceManager", "SIM2 Changed,old iccid:" + strN + ", new iccid:" + bVar.f2470u);
            g1.l.H(context, "iccid2", bVar.f2470u);
            return true;
        }
        return false;
    }

    private static synchronized void k(Context context, e1.b bVar) {
        String str;
        try {
            bVar.Y = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        f();
        c cVarE = e(context);
        if (cVarE == null) {
            g1.h.b("DeviceManager", "manuf==null,model=" + Build.MODEL);
            return;
        }
        cVarE.b(context, bVar);
        if (y.a.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            if (g1.l.t(context).booleanValue()) {
                str = !g1.l.w(context).booleanValue() ? "Mobile" : "WiFi";
            } else {
                str = "Disconnected";
            }
            bVar.R = str;
        }
        bVar.Z = g1.l.e();
        g1.h.a("DeviceManager", "getDeviceInfo:" + bVar.b());
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0157 A[Catch: Exception -> 0x02d6, all -> 0x02e3, TryCatch #1 {Exception -> 0x02d6, blocks: (B:32:0x014d, B:34:0x0157, B:36:0x015b, B:38:0x0163, B:40:0x016b, B:42:0x0173, B:44:0x017f, B:46:0x0187, B:48:0x018f, B:49:0x01bf, B:56:0x0204, B:50:0x01c2, B:52:0x01ca, B:53:0x01e4, B:55:0x01ec, B:57:0x0214, B:59:0x0218, B:61:0x021c, B:63:0x0224, B:65:0x022c, B:67:0x0234, B:69:0x0240, B:71:0x0248, B:73:0x0250, B:74:0x0280, B:81:0x02c5, B:75:0x0283, B:77:0x028b, B:78:0x02a5, B:80:0x02ad), top: B:91:0x014d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0187 A[Catch: Exception -> 0x02d6, all -> 0x02e3, TryCatch #1 {Exception -> 0x02d6, blocks: (B:32:0x014d, B:34:0x0157, B:36:0x015b, B:38:0x0163, B:40:0x016b, B:42:0x0173, B:44:0x017f, B:46:0x0187, B:48:0x018f, B:49:0x01bf, B:56:0x0204, B:50:0x01c2, B:52:0x01ca, B:53:0x01e4, B:55:0x01ec, B:57:0x0214, B:59:0x0218, B:61:0x021c, B:63:0x0224, B:65:0x022c, B:67:0x0234, B:69:0x0240, B:71:0x0248, B:73:0x0250, B:74:0x0280, B:81:0x02c5, B:75:0x0283, B:77:0x028b, B:78:0x02a5, B:80:0x02ad), top: B:91:0x014d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x01c2 A[Catch: Exception -> 0x02d6, all -> 0x02e3, TryCatch #1 {Exception -> 0x02d6, blocks: (B:32:0x014d, B:34:0x0157, B:36:0x015b, B:38:0x0163, B:40:0x016b, B:42:0x0173, B:44:0x017f, B:46:0x0187, B:48:0x018f, B:49:0x01bf, B:56:0x0204, B:50:0x01c2, B:52:0x01ca, B:53:0x01e4, B:55:0x01ec, B:57:0x0214, B:59:0x0218, B:61:0x021c, B:63:0x0224, B:65:0x022c, B:67:0x0234, B:69:0x0240, B:71:0x0248, B:73:0x0250, B:74:0x0280, B:81:0x02c5, B:75:0x0283, B:77:0x028b, B:78:0x02a5, B:80:0x02ad), top: B:91:0x014d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x01ca A[Catch: Exception -> 0x02d6, all -> 0x02e3, TryCatch #1 {Exception -> 0x02d6, blocks: (B:32:0x014d, B:34:0x0157, B:36:0x015b, B:38:0x0163, B:40:0x016b, B:42:0x0173, B:44:0x017f, B:46:0x0187, B:48:0x018f, B:49:0x01bf, B:56:0x0204, B:50:0x01c2, B:52:0x01ca, B:53:0x01e4, B:55:0x01ec, B:57:0x0214, B:59:0x0218, B:61:0x021c, B:63:0x0224, B:65:0x022c, B:67:0x0234, B:69:0x0240, B:71:0x0248, B:73:0x0250, B:74:0x0280, B:81:0x02c5, B:75:0x0283, B:77:0x028b, B:78:0x02a5, B:80:0x02ad), top: B:91:0x014d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x01e4 A[Catch: Exception -> 0x02d6, all -> 0x02e3, TryCatch #1 {Exception -> 0x02d6, blocks: (B:32:0x014d, B:34:0x0157, B:36:0x015b, B:38:0x0163, B:40:0x016b, B:42:0x0173, B:44:0x017f, B:46:0x0187, B:48:0x018f, B:49:0x01bf, B:56:0x0204, B:50:0x01c2, B:52:0x01ca, B:53:0x01e4, B:55:0x01ec, B:57:0x0214, B:59:0x0218, B:61:0x021c, B:63:0x0224, B:65:0x022c, B:67:0x0234, B:69:0x0240, B:71:0x0248, B:73:0x0250, B:74:0x0280, B:81:0x02c5, B:75:0x0283, B:77:0x028b, B:78:0x02a5, B:80:0x02ad), top: B:91:0x014d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01ec A[Catch: Exception -> 0x02d6, all -> 0x02e3, TryCatch #1 {Exception -> 0x02d6, blocks: (B:32:0x014d, B:34:0x0157, B:36:0x015b, B:38:0x0163, B:40:0x016b, B:42:0x0173, B:44:0x017f, B:46:0x0187, B:48:0x018f, B:49:0x01bf, B:56:0x0204, B:50:0x01c2, B:52:0x01ca, B:53:0x01e4, B:55:0x01ec, B:57:0x0214, B:59:0x0218, B:61:0x021c, B:63:0x0224, B:65:0x022c, B:67:0x0234, B:69:0x0240, B:71:0x0248, B:73:0x0250, B:74:0x0280, B:81:0x02c5, B:75:0x0283, B:77:0x028b, B:78:0x02a5, B:80:0x02ad), top: B:91:0x014d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0218 A[Catch: Exception -> 0x02d6, all -> 0x02e3, TryCatch #1 {Exception -> 0x02d6, blocks: (B:32:0x014d, B:34:0x0157, B:36:0x015b, B:38:0x0163, B:40:0x016b, B:42:0x0173, B:44:0x017f, B:46:0x0187, B:48:0x018f, B:49:0x01bf, B:56:0x0204, B:50:0x01c2, B:52:0x01ca, B:53:0x01e4, B:55:0x01ec, B:57:0x0214, B:59:0x0218, B:61:0x021c, B:63:0x0224, B:65:0x022c, B:67:0x0234, B:69:0x0240, B:71:0x0248, B:73:0x0250, B:74:0x0280, B:81:0x02c5, B:75:0x0283, B:77:0x028b, B:78:0x02a5, B:80:0x02ad), top: B:91:0x014d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0248 A[Catch: Exception -> 0x02d6, all -> 0x02e3, TryCatch #1 {Exception -> 0x02d6, blocks: (B:32:0x014d, B:34:0x0157, B:36:0x015b, B:38:0x0163, B:40:0x016b, B:42:0x0173, B:44:0x017f, B:46:0x0187, B:48:0x018f, B:49:0x01bf, B:56:0x0204, B:50:0x01c2, B:52:0x01ca, B:53:0x01e4, B:55:0x01ec, B:57:0x0214, B:59:0x0218, B:61:0x021c, B:63:0x0224, B:65:0x022c, B:67:0x0234, B:69:0x0240, B:71:0x0248, B:73:0x0250, B:74:0x0280, B:81:0x02c5, B:75:0x0283, B:77:0x028b, B:78:0x02a5, B:80:0x02ad), top: B:91:0x014d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0283 A[Catch: Exception -> 0x02d6, all -> 0x02e3, TryCatch #1 {Exception -> 0x02d6, blocks: (B:32:0x014d, B:34:0x0157, B:36:0x015b, B:38:0x0163, B:40:0x016b, B:42:0x0173, B:44:0x017f, B:46:0x0187, B:48:0x018f, B:49:0x01bf, B:56:0x0204, B:50:0x01c2, B:52:0x01ca, B:53:0x01e4, B:55:0x01ec, B:57:0x0214, B:59:0x0218, B:61:0x021c, B:63:0x0224, B:65:0x022c, B:67:0x0234, B:69:0x0240, B:71:0x0248, B:73:0x0250, B:74:0x0280, B:81:0x02c5, B:75:0x0283, B:77:0x028b, B:78:0x02a5, B:80:0x02ad), top: B:91:0x014d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x028b A[Catch: Exception -> 0x02d6, all -> 0x02e3, TryCatch #1 {Exception -> 0x02d6, blocks: (B:32:0x014d, B:34:0x0157, B:36:0x015b, B:38:0x0163, B:40:0x016b, B:42:0x0173, B:44:0x017f, B:46:0x0187, B:48:0x018f, B:49:0x01bf, B:56:0x0204, B:50:0x01c2, B:52:0x01ca, B:53:0x01e4, B:55:0x01ec, B:57:0x0214, B:59:0x0218, B:61:0x021c, B:63:0x0224, B:65:0x022c, B:67:0x0234, B:69:0x0240, B:71:0x0248, B:73:0x0250, B:74:0x0280, B:81:0x02c5, B:75:0x0283, B:77:0x028b, B:78:0x02a5, B:80:0x02ad), top: B:91:0x014d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x02a5 A[Catch: Exception -> 0x02d6, all -> 0x02e3, TryCatch #1 {Exception -> 0x02d6, blocks: (B:32:0x014d, B:34:0x0157, B:36:0x015b, B:38:0x0163, B:40:0x016b, B:42:0x0173, B:44:0x017f, B:46:0x0187, B:48:0x018f, B:49:0x01bf, B:56:0x0204, B:50:0x01c2, B:52:0x01ca, B:53:0x01e4, B:55:0x01ec, B:57:0x0214, B:59:0x0218, B:61:0x021c, B:63:0x0224, B:65:0x022c, B:67:0x0234, B:69:0x0240, B:71:0x0248, B:73:0x0250, B:74:0x0280, B:81:0x02c5, B:75:0x0283, B:77:0x028b, B:78:0x02a5, B:80:0x02ad), top: B:91:0x014d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x02ad A[Catch: Exception -> 0x02d6, all -> 0x02e3, TryCatch #1 {Exception -> 0x02d6, blocks: (B:32:0x014d, B:34:0x0157, B:36:0x015b, B:38:0x0163, B:40:0x016b, B:42:0x0173, B:44:0x017f, B:46:0x0187, B:48:0x018f, B:49:0x01bf, B:56:0x0204, B:50:0x01c2, B:52:0x01ca, B:53:0x01e4, B:55:0x01ec, B:57:0x0214, B:59:0x0218, B:61:0x021c, B:63:0x0224, B:65:0x022c, B:67:0x0234, B:69:0x0240, B:71:0x0248, B:73:0x0250, B:74:0x0280, B:81:0x02c5, B:75:0x0283, B:77:0x028b, B:78:0x02a5, B:80:0x02ad), top: B:91:0x014d, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:52:0x01ca, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:55:0x01ec, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:77:0x028b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:80:0x02ad, please report this as an issue */
    private static synchronized void l(e1.b bVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = bVar.f2456g;
        if (str6 == null || bVar.f2469t == null || str6.isEmpty() || bVar.f2469t.isEmpty() || bVar.f2456g.compareTo(bVar.f2469t) <= 0) {
            try {
                str = bVar.f2458i;
                if (str != null && bVar.f2457h != null && !str.equals("") && bVar.f2458i.length() >= 5 && bVar.f2457h.length() >= 6 && !g1.l.v(bVar.f2458i).booleanValue()) {
                    if (bVar.f2458i.length() >= 11 || bVar.f2457h.length() < 11) {
                        if (bVar.f2457h.length() >= 11) {
                            bVar.f2457h = bVar.f2457h.substring(0, 10) + "**********";
                        } else if (bVar.f2458i.length() >= 11) {
                            str4 = bVar.f2458i.substring(0, 10) + "*****";
                        }
                        bVar.f2464o = g1.i.a(bVar.f2464o);
                        bVar.f2463n = g1.i.a(bVar.f2463n);
                    } else {
                        bVar.f2457h = bVar.f2457h.substring(0, 10) + "**********";
                        str4 = bVar.f2458i.substring(0, 10) + "*****";
                    }
                    bVar.f2458i = str4;
                    bVar.f2464o = g1.i.a(bVar.f2464o);
                    bVar.f2463n = g1.i.a(bVar.f2463n);
                }
                str2 = bVar.f2471v;
                if (str2 != null && bVar.f2470u != null && !str2.equals("") && bVar.f2471v.length() >= 5 && bVar.f2470u.length() >= 6 && !g1.l.v(bVar.f2471v).booleanValue()) {
                    if (bVar.f2471v.length() >= 11 || bVar.f2470u.length() < 11) {
                        if (bVar.f2470u.length() >= 11) {
                            bVar.f2470u = bVar.f2470u.substring(0, 10) + "**********";
                        } else if (bVar.f2471v.length() >= 11) {
                            str3 = bVar.f2471v.substring(0, 10) + "*****";
                        }
                        bVar.B = g1.i.a(bVar.B);
                        bVar.A = g1.i.a(bVar.A);
                    } else {
                        bVar.f2470u = bVar.f2470u.substring(0, 10) + "**********";
                        str3 = bVar.f2471v.substring(0, 10) + "*****";
                    }
                    bVar.f2471v = str3;
                    bVar.B = g1.i.a(bVar.B);
                    bVar.A = g1.i.a(bVar.A);
                }
            } catch (Exception e2) {
                g1.h.b("DeviceManager", "exception === sortAndAnonymousSubscriber");
                e2.printStackTrace();
            }
        } else {
            e1.b bVar2 = new e1.b();
            bVar2.f2456g = bVar.f2456g;
            bVar2.f2457h = bVar.f2457h;
            bVar2.f2458i = bVar.f2458i;
            bVar2.f2460k = bVar.f2460k;
            bVar2.f2461l = bVar.f2461l;
            bVar2.f2462m = bVar.f2462m;
            bVar2.f2464o = bVar.f2464o;
            bVar2.f2465p = bVar.f2465p;
            bVar2.f2463n = bVar.f2463n;
            bVar2.f2466q = bVar.f2466q;
            bVar2.f2468s = bVar.f2468s;
            bVar2.f2467r = bVar.f2467r;
            String str7 = bVar.f2469t;
            bVar2.f2469t = str7;
            String str8 = bVar.f2470u;
            bVar2.f2470u = str8;
            String str9 = bVar.f2471v;
            bVar2.f2471v = str9;
            String str10 = bVar.f2473x;
            bVar2.f2473x = str10;
            String str11 = bVar.f2474y;
            bVar2.f2474y = str11;
            String str12 = bVar.f2475z;
            bVar2.f2475z = str12;
            String str13 = bVar.B;
            bVar2.B = str13;
            String str14 = bVar.C;
            bVar2.C = str14;
            String str15 = bVar.A;
            bVar2.A = str15;
            String str16 = bVar.D;
            bVar2.D = str16;
            String str17 = bVar.F;
            bVar2.F = str17;
            String str18 = bVar.E;
            bVar2.E = str18;
            bVar.f2456g = str7;
            bVar.f2457h = str8;
            bVar.f2458i = str9;
            bVar.f2460k = str10;
            bVar.f2461l = str11;
            bVar.f2462m = str12;
            bVar.f2464o = str13;
            bVar.f2465p = str14;
            bVar.f2463n = str15;
            bVar.f2466q = str16;
            bVar.f2468s = str17;
            bVar.f2467r = str18;
            bVar.f2469t = bVar2.f2456g;
            bVar.f2470u = bVar2.f2457h;
            bVar.f2471v = bVar2.f2458i;
            bVar.f2473x = bVar2.f2460k;
            bVar.f2474y = bVar2.f2461l;
            bVar.f2475z = bVar2.f2462m;
            bVar.B = bVar2.f2464o;
            bVar.C = bVar2.f2465p;
            bVar.A = bVar2.f2463n;
            bVar.D = bVar2.f2466q;
            bVar.F = bVar2.f2468s;
            bVar.E = bVar2.f2467r;
            String str19 = bVar.G;
            if (str19 != null) {
                if (!str19.equals("1")) {
                    str5 = bVar.G.equals("2") ? "1" : "2";
                }
                bVar.G = str5;
            }
            try {
                String str20 = bVar.L;
                if (str20 == null || str20.length() != 2) {
                    str = bVar.f2458i;
                    if (str != null) {
                        if (bVar.f2458i.length() >= 11) {
                            if (bVar.f2457h.length() >= 11) {
                                bVar.f2457h = bVar.f2457h.substring(0, 10) + "**********";
                            } else if (bVar.f2458i.length() >= 11) {
                                str4 = bVar.f2458i.substring(0, 10) + "*****";
                                bVar.f2458i = str4;
                            }
                        } else if (bVar.f2457h.length() >= 11) {
                            bVar.f2457h = bVar.f2457h.substring(0, 10) + "**********";
                        } else if (bVar.f2458i.length() >= 11) {
                            str4 = bVar.f2458i.substring(0, 10) + "*****";
                            bVar.f2458i = str4;
                        }
                        bVar.f2464o = g1.i.a(bVar.f2464o);
                        bVar.f2463n = g1.i.a(bVar.f2463n);
                    }
                    str2 = bVar.f2471v;
                    if (str2 != null) {
                        if (bVar.f2471v.length() >= 11) {
                            if (bVar.f2470u.length() >= 11) {
                                bVar.f2470u = bVar.f2470u.substring(0, 10) + "**********";
                            } else if (bVar.f2471v.length() >= 11) {
                                str3 = bVar.f2471v.substring(0, 10) + "*****";
                                bVar.f2471v = str3;
                            }
                        } else if (bVar.f2470u.length() >= 11) {
                            bVar.f2470u = bVar.f2470u.substring(0, 10) + "**********";
                        } else if (bVar.f2471v.length() >= 11) {
                            str3 = bVar.f2471v.substring(0, 10) + "*****";
                            bVar.f2471v = str3;
                        }
                        bVar.B = g1.i.a(bVar.B);
                        bVar.A = g1.i.a(bVar.A);
                    }
                } else {
                    char cCharAt = bVar.L.charAt(0);
                    bVar.L = "" + bVar.L.charAt(1) + cCharAt;
                    StringBuilder sb = new StringBuilder();
                    sb.append("排序后更新eSIM状态: ");
                    sb.append(bVar.L);
                    g1.h.a("EsimStatus", sb.toString());
                    str = bVar.f2458i;
                    if (str != null) {
                        if (bVar.f2458i.length() >= 11) {
                            if (bVar.f2457h.length() >= 11) {
                                bVar.f2457h = bVar.f2457h.substring(0, 10) + "**********";
                            } else if (bVar.f2458i.length() >= 11) {
                                str4 = bVar.f2458i.substring(0, 10) + "*****";
                                bVar.f2458i = str4;
                            }
                        } else if (bVar.f2457h.length() >= 11) {
                            bVar.f2457h = bVar.f2457h.substring(0, 10) + "**********";
                        } else if (bVar.f2458i.length() >= 11) {
                            str4 = bVar.f2458i.substring(0, 10) + "*****";
                            bVar.f2458i = str4;
                        }
                        bVar.f2464o = g1.i.a(bVar.f2464o);
                        bVar.f2463n = g1.i.a(bVar.f2463n);
                    }
                    str2 = bVar.f2471v;
                    if (str2 != null) {
                        if (bVar.f2471v.length() >= 11) {
                            if (bVar.f2470u.length() >= 11) {
                                bVar.f2470u = bVar.f2470u.substring(0, 10) + "**********";
                            } else if (bVar.f2471v.length() >= 11) {
                                str3 = bVar.f2471v.substring(0, 10) + "*****";
                                bVar.f2471v = str3;
                            }
                        } else if (bVar.f2470u.length() >= 11) {
                            bVar.f2470u = bVar.f2470u.substring(0, 10) + "**********";
                        } else if (bVar.f2471v.length() >= 11) {
                            str3 = bVar.f2471v.substring(0, 10) + "*****";
                            bVar.f2471v = str3;
                        }
                        bVar.B = g1.i.a(bVar.B);
                        bVar.A = g1.i.a(bVar.A);
                    }
                }
            } catch (Exception e3) {
                g1.h.a("DeviceManager", "exception : " + e3);
            }
        }
        throw th;
    }
}
