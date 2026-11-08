package k1;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.registration.R;
import g2.e;
import java.util.regex.Pattern;
import miui.os.Build;
import miui.telephony.PhoneDebug;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static int a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f1851b = Pattern.compile("^[a-zA-Z][0-9]{1,3}$");

    /* JADX WARN: Code duplicated, block: B:43:0x00b7  */
    public static String a(Context context) {
        StringBuilder sb;
        String strG = e.g("ro.mi.os.version.incremental", "");
        if (!TextUtils.isEmpty(strG) && strG.startsWith("OS") && strG.length() > 2) {
            strG = strG.substring(2);
        }
        String strG2 = e.g("persist.sys.xms.version", "");
        String strG3 = e.g("ro.mi.xms.version.incremental", "");
        boolean zIsEmpty = TextUtils.isEmpty(strG2);
        Pattern pattern = f1851b;
        boolean z2 = !zIsEmpty && pattern.matcher(strG2).matches();
        boolean z3 = !TextUtils.isEmpty(strG3) && pattern.matcher(strG3).matches();
        String str = null;
        if (!z2 && !z3) {
            strG2 = null;
        } else if (!z2 || z3) {
            if (z2 || !z3) {
                char lowerCase = Character.toLowerCase(strG2.charAt(0));
                char lowerCase2 = Character.toLowerCase(strG3.charAt(0));
                if (lowerCase == lowerCase2) {
                    try {
                        try {
                            if (Integer.parseInt(strG2.substring(1)) < Integer.parseInt(strG3.substring(1))) {
                                strG2 = strG3;
                            }
                        } catch (Exception e3) {
                            Log.d("AutoReg_Utils", "ParseInt v2 err: " + e3);
                        }
                    } catch (Exception e4) {
                        Log.d("AutoReg_Utils", "ParseInt v1 err: " + e4);
                    }
                } else if (lowerCase <= lowerCase2) {
                    strG2 = strG3;
                }
            } else {
                strG2 = strG3;
            }
        }
        if (TextUtils.isEmpty(strG2)) {
            return strG;
        }
        if (context != null) {
            try {
                int identifier = context.getResources().getIdentifier("developer_build", "string", context.getPackageName());
                if (identifier != 0) {
                    String string = context.getString(identifier);
                    if (!TextUtils.isEmpty(string) && strG.endsWith(string)) {
                        str = string;
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (str == null && strG.endsWith("Beta")) {
            str = "Beta";
        }
        if (str != null) {
            String strTrim = strG.substring(0, strG.length() - str.length()).trim();
            sb = new StringBuilder();
            sb.append(strTrim);
            sb.append(".");
            sb.append(strG2);
            sb.append(" ");
            sb.append(str);
        } else {
            sb = new StringBuilder();
            sb.append(strG);
            sb.append(".");
            sb.append(strG2);
        }
        return sb.toString();
    }

    public static String b(Context context, int i3) {
        String subscriberId;
        int iO = c.l(context).o(i3);
        return (iO == -1 || (subscriberId = ((TelephonyManager) context.getSystemService("phone")).createForSubscriptionId(iO).getSubscriberId()) == null) ? "" : subscriberId;
    }

    public static String c(Context context) {
        String string = context.getResources().getString(R.string.config_autoreg_model_string);
        if (!TextUtils.isEmpty(e.g("ro.product.marketname", "")) && !TextUtils.isEmpty(e.g("ro.product.model", ""))) {
            string = "XMP-" + e.g("ro.product.model", "");
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strG = e.g("ro.product.device", "");
        if ("cmi".equals(strG)) {
            return "XMP-M2001J1C";
        }
        return "umi".equals(strG) ? "XMP-M2001J2C" : string;
    }

    public static boolean d() {
        String str = Build.DEVICE;
        return ("ruan".equals(str) || "koto".equals(str) || "organ".equals(str)) && !Build.IS_CT_CUSTOMIZATION;
    }

    public static boolean e(int i3) {
        StringBuilder sb;
        String str;
        SubscriptionManager subscriptionManager;
        SubscriptionInfo activeSubscriptionInfoForSimSlotIndex;
        String simSerialNumberForSlot = null;
        try {
            Context context = (Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            if (context != null && (subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service")) != null && (activeSubscriptionInfoForSimSlotIndex = subscriptionManager.getActiveSubscriptionInfoForSimSlotIndex(i3)) != null) {
                simSerialNumberForSlot = activeSubscriptionInfoForSimSlotIndex.getIccId();
            }
        } catch (Exception e3) {
            Log.w("AutoReg_Utils", "isCtSim: failed to get context via reflection: " + e3.getMessage());
        }
        if (TextUtils.isEmpty(simSerialNumberForSlot)) {
            try {
                simSerialNumberForSlot = miui.telephony.TelephonyManager.getDefault().getSimSerialNumberForSlot(i3);
            } catch (Exception e4) {
                Log.w("AutoReg_Utils", "isCtSim: failed to get iccid from miui tm: " + e4.getMessage());
            }
        }
        if (!TextUtils.isEmpty(simSerialNumberForSlot)) {
            for (String str2 : "898603,898611,898612".split(",")) {
                if (simSerialNumberForSlot.startsWith(str2)) {
                    return true;
                }
            }
        }
        if (TextUtils.isEmpty(simSerialNumberForSlot)) {
            sb = new StringBuilder("slotId = ");
            sb.append(i3);
            str = ", iccId is null (Satellite Mode?)";
        } else {
            sb = new StringBuilder("slotId = ");
            sb.append(i3);
            str = ", is not a ct sim";
        }
        sb.append(str);
        Log.w("AutoReg_Utils", sb.toString());
        return false;
    }

    public static boolean f(Context context, SharedPreferences sharedPreferences, String str, int i3) {
        String strB = b(context, i3);
        String string = sharedPreferences.getString(str + i3, null);
        if (PhoneDebug.VDBG || Build.IS_CT_CUSTOMIZATION_TEST) {
            h("imsi = " + strB + ", storedImsi = " + string);
        }
        return (TextUtils.isEmpty(strB) || strB.equals(string)) ? false : true;
    }

    public static boolean g(Context context) {
        boolean z2 = Settings.System.getInt(context.getContentResolver(), "satellite_state", 0) != 0;
        h("issatelliteenable = " + z2);
        return z2;
    }

    public static void h(String str) {
        if (PhoneDebug.VDBG || Build.IS_CT_CUSTOMIZATION_TEST) {
            Log.d("AutoReg_Utils", str);
        }
    }

    public static void i(Context context, SharedPreferences sharedPreferences, String str, int i3) {
        String strB = b(context, i3);
        sharedPreferences.edit().putString(str + i3, strB).apply();
    }
}
