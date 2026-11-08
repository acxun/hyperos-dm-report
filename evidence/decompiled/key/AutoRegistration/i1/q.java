package i1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import miui.os.Build;
import miui.telephony.PhoneDebug;
import miui.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f1764e = TelephonyManager.getDefault().getPhoneCount();
    public final SharedPreferences a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final android.telephony.TelephonyManager f1765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f1767d;

    public q(Context context, int i3) {
        this.f1767d = context;
        this.f1766c = i3;
        this.a = PreferenceManager.getDefaultSharedPreferences(context);
        this.f1765b = (android.telephony.TelephonyManager) context.getSystemService("phone");
    }

    public abstract void a();

    public final void b(final String str) {
        Context context = this.f1767d;
        k1.c cVarL = k1.c.l(context);
        int i3 = this.f1766c;
        int iO = cVarL.o(i3);
        if (iO != -1) {
            final w wVar = new w(context, this, iO);
            wVar.f1782f = i3;
            final PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("AUTO_REG_SMS_SEND"), 67108864);
            final PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 0, new Intent("AUTO_REG_SMS_DELIVERED"), 67108864);
            new Thread(new Runnable() { // from class: i1.u

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f1773b = "10659401";

                @Override // java.lang.Runnable
                public final void run() {
                    String str2 = this.f1773b;
                    String str3 = str;
                    PendingIntent pendingIntent = broadcast;
                    PendingIntent pendingIntent2 = broadcast2;
                    w wVar2 = wVar;
                    wVar2.getClass();
                    try {
                        Log.d("AutoReg_SmsSender", "start sent message, thread creation");
                        wVar2.f1781e.sendDataMessage(str2, null, (short) 0, str3.getBytes(), pendingIntent, pendingIntent2);
                    } catch (Exception e3) {
                        Log.e("AutoReg_SmsSender", "Send SMS Error", e3);
                    }
                }
            }).start();
            if (Build.IS_CT_CUSTOMIZATION_TEST || PhoneDebug.VDBG) {
                Log.d("AutoReg_SmsSender", "start sent message".concat(str));
            }
        }
    }
}
