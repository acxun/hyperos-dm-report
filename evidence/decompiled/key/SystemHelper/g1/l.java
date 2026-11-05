package g1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f2682a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public static void A(Context context, long j2) {
        h.a("RegisterUtils", "setInitScheduleInterval--->");
        C(context, "scheduleInterval2", j2);
    }

    public static void B(Context context, long j2) {
        h.a("RegisterUtils", "setInitScheduleInterval--->");
        C(context, "signalInfoInterval2", j2);
    }

    public static void C(Context context, String str, long j2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com_mobiletools_systemhelper_preference", 4).edit();
        editorEdit.putLong(str, j2);
        editorEdit.commit();
    }

    public static void D(Context context, long j2) {
        h.a("RegisterUtils", "setScheduleInterval--->");
        C(context, "scheduleInterval", j2);
    }

    public static void E(Context context, String str) {
        H(context, "serverAddress", str);
    }

    public static void F(Context context, long j2) {
        h.a("RegisterUtils", "setSignalInfoInterval--->");
        C(context, "signalInfoInterval", j2);
    }

    public static void G(Context context, long j2) {
        C(context, "GetsignalInfoInterval", j2);
    }

    public static void H(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com_mobiletools_systemhelper_preference", 4).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public static boolean a(Context context) {
        boolean z2 = false;
        Boolean boolValueOf = Boolean.valueOf(Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) == 1);
        h.a("RegisterUtils", "isBootWizardCompleted: " + boolValueOf);
        if (boolValueOf.booleanValue()) {
            z2 = Settings.Secure.getInt(context.getContentResolver(), "operator_service_improve_plan", 0) == 1;
            h.a("RegisterUtils", "checkUserPermission:" + z2);
        }
        return z2;
    }

    @SuppressLint({"SdCardPath"})
    public static void b(Context context) {
        File file = new File("/data/data/com.mobiletools.systemhelper/shared_prefs/com_mobiletools_systemhelper_preference.xml");
        if (file.exists()) {
            file.delete();
        }
    }

    public static long c(Context context) {
        h.a("RegisterUtils", "getAppInfoInterval--->");
        return i(context, "appInfoInterval", d.f2667t);
    }

    public static Boolean d(Context context, String str, Boolean bool) {
        return Boolean.valueOf(context.getSharedPreferences("com_mobiletools_systemhelper_preference", 4).getBoolean(str, bool.booleanValue()));
    }

    public static String e() {
        return f2682a.format(new Date());
    }

    public static long f(Context context) {
        h.a("RegisterUtils", "getInitAppInfoInterval--->");
        return i(context, "appInfoInterval2", d.f2660m);
    }

    public static long g(Context context) {
        h.a("RegisterUtils", "getInitScheduleInterval--->");
        return i(context, "scheduleInterval2", d.f2661n);
    }

    public static long h(Context context) {
        h.a("RegisterUtils", "getInitScheduleInterval--->");
        h.a("RegisterUtils", "GlobalSetting.DEFAULT_RANDOM_SIG : " + d.f2662o);
        return i(context, "signalInfoInterval2", d.f2662o);
    }

    public static long i(Context context, String str, long j2) {
        return context.getSharedPreferences("com_mobiletools_systemhelper_preference", 4).getLong(str, j2);
    }

    public static long j(Context context) {
        h.a("RegisterUtils", "getScheduleInterval--->");
        return i(context, "scheduleInterval", d.f2666s);
    }

    public static String k(Context context) {
        return d.f2649b ? d.f2659l : n(context, "serverAddress", d.f2659l);
    }

    public static long l(Context context) {
        h.a("RegisterUtils", "getSignalInfoInterval--->");
        return i(context, "signalInfoInterval", d.f2668u);
    }

    public static long m(Context context) {
        return i(context, "GetsignalInfoInterval", d.f2669v);
    }

    public static String n(Context context, String str, String str2) {
        return context.getSharedPreferences("com_mobiletools_systemhelper_preference", 4).getString(str, str2);
    }

    public static String o(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String p(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    public static String q(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), str, str2);
        } catch (Exception e2) {
            h.b("RegisterUtils", "getSystemProperties->" + e2.getMessage());
            return str2;
        }
    }

    public static String r(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static Boolean s(e1.b bVar) {
        try {
            h.a("RegisterUtils", "deviceinfo.mnc1: " + bVar.f2460k + "mnc2:" + bVar.f2473x);
            String str = bVar.f2460k;
            if (str != null && !str.isEmpty() && !bVar.f2460k.equals("ex00") && !bVar.f2460k.equals("ex01") && !bVar.f2460k.startsWith("460")) {
                h.a("RegisterUtils", "MNC1 is not startwith 460!");
                return Boolean.FALSE;
            }
            String str2 = bVar.f2473x;
            if (str2 != null && !str2.isEmpty() && !bVar.f2473x.equals("ex00") && !bVar.f2473x.equals("ex01") && !bVar.f2473x.startsWith("460")) {
                h.a("RegisterUtils", "MNC2 is not startwith 460!");
                return Boolean.FALSE;
            }
            String str3 = bVar.G;
            if (str3 != null && !str3.isEmpty()) {
                if (bVar.G.equals("1")) {
                    String str4 = bVar.f2461l;
                    if (str4 != null && !str4.isEmpty() && !bVar.f2461l.startsWith("460")) {
                        h.a("RegisterUtils", "register mnc1 is not startwith 460!");
                        return Boolean.FALSE;
                    }
                } else {
                    if (!bVar.G.equals("2")) {
                        h.b("RegisterUtils", "isUnicomNetwork->DataSlot：" + bVar.G);
                        return Boolean.FALSE;
                    }
                    String str5 = bVar.f2474y;
                    if (str5 != null && !str5.isEmpty() && !bVar.f2474y.startsWith("460")) {
                        h.a("RegisterUtils", "register mnc2 is not startwith 460!");
                        return Boolean.FALSE;
                    }
                }
            }
            h.a("RegisterUtils", "success —— in china network!");
            return Boolean.TRUE;
        } catch (Exception e2) {
            h.b("RegisterUtils", "Exception===isChinaNetwork");
            e2.printStackTrace();
            h.a("RegisterUtils", "success —— in china network!");
            return Boolean.TRUE;
        }
    }

    public static Boolean t(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        h.a("RegisterUtils", "network connected------------->:" + activeNetworkInfo);
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? Boolean.FALSE : Boolean.TRUE;
    }

    public static Boolean u(e1.b bVar) {
        try {
            String str = bVar.G;
            if (str != null && !str.isEmpty()) {
                if (bVar.G.equals("1")) {
                    String str2 = bVar.f2460k;
                    if (str2 != null && !str2.isEmpty() && (bVar.f2460k.equals("46001") || bVar.f2460k.equals("46006") || bVar.f2460k.equals("46009") || bVar.f2460k.equals("46010"))) {
                        h.a("RegisterUtils", "is unicom network!");
                        return Boolean.TRUE;
                    }
                } else {
                    if (!bVar.G.equals("2")) {
                        h.b("RegisterUtils", "isUnicomNetwork->DataSlot：" + bVar.G);
                        return Boolean.FALSE;
                    }
                    String str3 = bVar.f2473x;
                    if (str3 != null && !str3.isEmpty() && (bVar.f2473x.equals("46001") || bVar.f2473x.equals("46006") || bVar.f2473x.equals("46009") || bVar.f2473x.equals("46010"))) {
                        h.a("RegisterUtils", "is unicom network!");
                        return Boolean.TRUE;
                    }
                }
            }
        } catch (Exception e2) {
            h.b("RegisterUtils", "Exception====isUnicomNetwork");
            e2.printStackTrace();
        }
        h.a("RegisterUtils", "isunicomNetwork return false!");
        return Boolean.FALSE;
    }

    public static Boolean v(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty() && (str.indexOf("46001") == 0 || str.indexOf("46006") == 0 || str.indexOf("46009") == 0 || str.indexOf("46010") == 0)) {
                    return Boolean.TRUE;
                }
            } catch (Exception e2) {
                h.b("RegisterUtils", "Exception===");
                e2.printStackTrace();
            }
        }
        return Boolean.FALSE;
    }

    public static Boolean w(Context context) {
        boolean z2 = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED;
        h.a("RegisterUtils", "isWifiConnected:" + z2);
        return Boolean.valueOf(z2);
    }

    public static void x(Context context, long j2) {
        h.a("RegisterUtils", "setAppInfoInterval--->");
        C(context, "appInfoInterval", j2);
    }

    public static void y(Context context, String str, Boolean bool) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com_mobiletools_systemhelper_preference", 4).edit();
        editorEdit.putBoolean(str, bool.booleanValue());
        editorEdit.commit();
    }

    public static void z(Context context, long j2) {
        h.a("RegisterUtils", "setInitAppInfoInterval--->");
        C(context, "appInfoInterval2", j2);
    }
}
