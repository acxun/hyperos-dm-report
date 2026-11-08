package j1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static c f1828h;
    public final ConnectivityManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f1829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f1830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f1831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AlarmManager f1832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f1833f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1834g;

    public c(Context context) {
        this.f1833f = context;
        this.a = (ConnectivityManager) context.getSystemService("connectivity");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        this.f1832e = alarmManager;
        this.f1832e = alarmManager;
        this.f1829b = PreferenceManager.getDefaultSharedPreferences(context);
        b();
        if (this.f1831d == null) {
            this.f1831d = new a(this, 0);
            IntentFilter intentFilter = new IntentFilter("miui.intent.action.CTEI_AUTO_REGISTRATION");
            intentFilter.addAction("miui.intent.action.CTEI_AUTO_REGISTRATION_RETRY");
            context.registerReceiver(this.f1831d, intentFilter);
        }
        if (this.f1830c == null) {
            this.f1830c = new a(this, 1);
            context.registerReceiver(this.f1830c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        Log.i("Ctei_RegistrationTracker", "ctei registration init");
    }

    public static void a(c cVar) {
        cVar.getClass();
        Log.i("Ctei_RegistrationTracker", "start registration trigger");
        Intent intent = new Intent("miui.intent.action.CTEI_AUTO_REGISTRATION");
        Context context = cVar.f1833f;
        intent.setPackage(context.getPackageName());
        intent.addFlags(268435456);
        try {
            cVar.f1832e.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 86400000, PendingIntent.getBroadcast(context, 0, intent, 67108864));
        } catch (Exception e3) {
            Log.e("Ctei_RegistrationTracker", "startPeriodRegTriggered catch exception");
            e3.printStackTrace();
        }
    }

    public final void b() {
        SharedPreferences sharedPreferences = this.f1829b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("register_request_count", 0).apply();
        }
    }

    public final void c() {
        Intent intent = new Intent("miui.intent.action.CTEI_AUTO_REGISTRATION");
        Context context = this.f1833f;
        intent.setPackage(context.getPackageName());
        intent.addFlags(268435456);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 603979776);
        if (broadcast != null) {
            this.f1832e.cancel(broadcast);
            Log.d("Ctei_RegistrationTracker", "cancel the pending intent: ACTION_CTEI_AUTO_REGISTRATION");
        }
    }

    public final void d() {
        Intent intent = new Intent("miui.intent.action.CTEI_AUTO_REGISTRATION_RETRY");
        Context context = this.f1833f;
        intent.setPackage(context.getPackageName());
        intent.addFlags(268435456);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 603979776);
        if (broadcast != null) {
            this.f1832e.cancel(broadcast);
            Log.d("Ctei_RegistrationTracker", "cancel the pending intent: ACTION_CTEI_AUTO_REGISTRATION_RETRY");
        }
    }
}
