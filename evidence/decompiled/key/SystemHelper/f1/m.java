package f1;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class m extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f2555c = Pattern.compile("^[a-zA-Z][0-9]{1,3}$");

    public static String j(Context context) {
        String strW = w();
        String strX = x();
        return TextUtils.isEmpty(strX) ? strW : y(context, strW, strX);
    }

    private boolean t(Context context) {
        Boolean boolValueOf = Boolean.valueOf(Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) == 1);
        g1.h.a("DeviceInfoReaderXiaomi", "isBootWizardCompleted: " + boolValueOf);
        return boolValueOf.booleanValue();
    }

    private static String u(String str, String str2) {
        char lowerCase = Character.toLowerCase(str.charAt(0));
        char lowerCase2 = Character.toLowerCase(str2.charAt(0));
        if (lowerCase != lowerCase2) {
            return lowerCase > lowerCase2 ? str : str2;
        }
        try {
            try {
                return Integer.parseInt(str.substring(1)) >= Integer.parseInt(str2.substring(1)) ? str : str2;
            } catch (Exception e2) {
                g1.h.a("DeviceInfoReaderXiaomi", "ParseInt v2 err: " + e2);
                return str;
            }
        } catch (Exception e3) {
            g1.h.a("DeviceInfoReaderXiaomi", "ParseInt v1 err: " + e3);
            return str2;
        }
    }

    private String v(e1.b bVar) {
        return g1.l.o(bVar.f2449b.equals("2106118C") ? "ro.build.hardware.version" : "ro.miui.cust_hardware");
    }

    private static String w() {
        String strP = g1.l.p("ro.mi.os.version.incremental", "");
        return (TextUtils.isEmpty(strP) || !strP.startsWith("OS") || strP.length() <= 2) ? strP : strP.substring(2);
    }

    private static String x() {
        String strP = g1.l.p("persist.sys.xms.version", "");
        String strP2 = g1.l.p("ro.mi.xms.version.incremental", "");
        boolean z2 = z(strP);
        boolean z3 = z(strP2);
        if (!z2 && !z3) {
            return null;
        }
        if (!z2 || z3) {
            return (z2 || !z3) ? u(strP, strP2) : strP2;
        }
        return strP;
    }

    private static String y(Context context, String str, String str2) {
        String str3 = null;
        if (context != null) {
            try {
                int identifier = context.getResources().getIdentifier("developer_build", "string", context.getPackageName());
                if (identifier != 0) {
                    String string = context.getString(identifier);
                    if (!TextUtils.isEmpty(string) && str.endsWith(string)) {
                        str3 = string;
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (str3 == null && str.endsWith("Beta")) {
            str3 = "Beta";
        }
        if (str3 == null) {
            return str + "." + str2;
        }
        return str.substring(0, str.length() - str3.length()).trim() + "." + str2 + " " + str3;
    }

    private static boolean z(String str) {
        return !TextUtils.isEmpty(str) && f2555c.matcher(str).matches();
    }

    @Override // f1.a, f1.o.c
    public void b(Context context, e1.b bVar) {
        super.b(context, bVar);
        boolean zT = t(context);
        g1.d.f2652e = zT;
        if (zT) {
            g1.h.a("DeviceInfoReaderXiaomi", "GlobalSetting.isUserPermissionOpen" + g1.d.f2652e);
            bVar.f2451c = v(bVar);
            bVar.f2453d = j(context);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 33) {
                o(context, bVar);
                return;
            }
            g1.h.b("DeviceInfoReaderXiaomi", "Unsupported API:" + i2);
        }
    }
}
