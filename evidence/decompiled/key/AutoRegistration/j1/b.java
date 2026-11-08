package j1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Log;
import i1.m;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import k1.d;
import y1.t;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f1827b = 0;
    public final /* synthetic */ c a;

    static {
        int i3 = t.f2798b;
        z1.c.a("application/json");
    }

    public b(c cVar, Context context) {
        this.a = cVar;
        new m(1, this, context).start();
    }

    public final void a(int i3) {
        c cVar = this.a;
        if (i3 != 1) {
            if (i3 == 2) {
                Log.i("Ctei_RegistrationTracker", "400 error fail, stop report");
            } else {
                if (i3 != 3) {
                    return;
                }
                SharedPreferences sharedPreferences = cVar.f1829b;
                int i4 = sharedPreferences.getInt("register_request_count", 0) + 1;
                sharedPreferences.edit().putInt("register_request_count", i4).apply();
                Log.i("Ctei_RegistrationTracker", "retry count is " + i4);
                if (i4 <= 3) {
                    cVar.getClass();
                    Log.i("Ctei_RegistrationTracker", "retry registration trigger");
                    Intent intent = new Intent("miui.intent.action.CTEI_AUTO_REGISTRATION_RETRY");
                    Context context = cVar.f1833f;
                    intent.setPackage(context.getPackageName());
                    intent.addFlags(268435456);
                    try {
                        cVar.f1832e.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 1800000, PendingIntent.getBroadcast(context, 0, intent, 67108864));
                        return;
                    } catch (Exception e3) {
                        Log.e("Ctei_RegistrationTracker", "retryRegisterTriggered catch exception");
                        e3.printStackTrace();
                        return;
                    }
                }
            }
            cVar.b();
        }
        Log.i("Ctei_RegistrationTracker", "ctei registration success");
        SharedPreferences.Editor editorEdit = cVar.f1829b.edit();
        int i5 = d.a;
        editorEdit.putString("register_regtime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date())).apply();
        c.a(cVar);
        cVar.b();
    }
}
