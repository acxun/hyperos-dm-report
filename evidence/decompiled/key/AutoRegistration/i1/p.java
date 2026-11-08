package i1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.ServiceState;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.registration.autoregistration.RegistrationJobService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static p f1744u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f1745v = true;
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f1746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AlarmManager f1747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SubscriptionManager f1748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConnectivityManager f1749e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1755l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j[] f1756m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final t[] f1757n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TelephonyManager f1758o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f1759p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1761r;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o f1750f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1751g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1752h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1753i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1754j = false;
    public boolean k = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1760q = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1762s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1763t = 1;

    public p(Context context) {
        this.f1755l = false;
        this.f1756m = null;
        this.f1757n = null;
        this.f1761r = false;
        Log.d("AutoReg_RegistrationTracker", "RegistrationTracker constructor");
        this.a = context;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.f1746b = defaultSharedPreferences;
        this.f1747c = (AlarmManager) context.getSystemService("alarm");
        this.f1748d = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
        this.f1749e = (ConnectivityManager) context.getSystemService("connectivity");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.f1758o = telephonyManager;
        this.f1759p = telephonyManager.getPhoneCount();
        this.f1761r = "true".equals(defaultSharedPreferences.getString("autosms_provision", "false"));
        defaultSharedPreferences.edit().putInt("register_request_count", 0).apply();
        j();
        String string = defaultSharedPreferences.getString("build_fingerprint", null);
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        StringBuilder sb = new StringBuilder("Build fingerprint. old: ");
        sb.append(string);
        sb.append(" new: ");
        String str = Build.FINGERPRINT;
        sb.append(str);
        Log.d("AutoReg_RegistrationTracker", sb.toString());
        if (!str.equals(string)) {
            editorEdit.putString("build_fingerprint", str);
            editorEdit.putString("sim_iccid", "");
            for (int i3 = 0; i3 < this.f1759p; i3++) {
                editorEdit.putString("lte_imsi" + i3, "");
                editorEdit.putString("satellite_imsi" + i3, "");
            }
        }
        editorEdit.apply();
        HandlerThread handlerThread = new HandlerThread("AutoReg_RegistrationTracker");
        handlerThread.start();
        e0.a aVar = new e0.a(this, new Handler(handlerThread.getLooper()), 2);
        this.a.getContentResolver().registerContentObserver(Settings.Global.getUriFor("fiveg_user_enable"), false, aVar);
        this.a.getContentResolver().registerContentObserver(Settings.Global.getUriFor("dual_nr_enabled"), false, aVar);
        if (!k1.d.a(this.a).equals(this.f1746b.getString("register_sw_version", ""))) {
            this.f1755l = true;
        }
        b();
        Intent intent = new Intent("com.qualcomm.qti.action.AUTO_REGISTRATION_PERIOD_TRIGGER");
        Context context2 = this.a;
        intent.setPackage(context2.getPackageName());
        intent.addFlags(268435456);
        PendingIntent broadcast = PendingIntent.getBroadcast(context2, 0, intent, 67108864);
        Log.d("AutoReg_RegistrationTracker", "startPeriodRegTimer");
        this.f1747c.setRepeating(0, System.currentTimeMillis() + 43200000, 43200000L, broadcast);
        n();
        this.f1756m = new j[this.f1759p];
        for (int i4 = 0; i4 < this.f1759p; i4++) {
            j[] jVarArr = this.f1756m;
            Context context3 = this.a;
            j[] jVarArr2 = j.f1716v;
            if (jVarArr2[i4] == null) {
                jVarArr2[i4] = new j(context3, i4);
            }
            jVarArr[i4] = jVarArr2[i4];
        }
        if (g2.e.l()) {
            this.f1757n = new t[this.f1759p];
            for (int i5 = 0; i5 < this.f1759p; i5++) {
                t[] tVarArr = this.f1757n;
                Context context4 = this.a;
                t[] tVarArr2 = t.f1769i;
                if (tVarArr2[i5] == null) {
                    tVarArr2[i5] = new t(context4, i5);
                }
                tVarArr[i5] = tVarArr2[i5];
            }
        }
        this.a.registerReceiver(new r(), new IntentFilter("com.xiaomi.autoreg.receivesms"), 2);
        this.a.registerReceiver(new o(this, 1), new IntentFilter("miui.intent.action.ACTION_DEFAULT_DATA_SLOT_CHANGED"), 2);
    }

    public final void a() {
        Intent intent = new Intent("com.qualcomm.qti.action.AUTO_REGISTRATION_RETRY");
        Context context = this.a;
        intent.setPackage(context.getPackageName());
        intent.addFlags(268435456);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 603979776);
        if (broadcast != null) {
            this.f1747c.cancel(broadcast);
            Log.d("AutoReg_RegistrationTracker", "cancel the pending intent: ACTION_AUTO_REGISTRATION_RETRY");
        }
    }

    public final void b() {
        String str;
        boolean z2;
        Log.d("AutoReg_RegistrationTracker", "checkPeriodRegTimer");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String string = this.f1746b.getString("register_regtime", "");
        Log.d("AutoReg_RegistrationTracker", "Latest autoReg time:" + string);
        if (string.equals("")) {
            z2 = false;
        } else {
            try {
                long time = (new Date(System.currentTimeMillis()).getTime() - simpleDateFormat.parse(string).getTime()) / 1000;
                z2 = time > 1296000;
                str = "Time from latest autoReg: " + time + " thresh: 1296000 trig: " + z2;
            } catch (Exception unused) {
                str = "Latest autoReg time exception";
                z2 = false;
            }
            Log.d("AutoReg_RegistrationTracker", str);
        }
        if (z2) {
            this.f1760q = true;
            f1745v = false;
            this.f1752h = false;
            m(false);
        }
    }

    public final void c() {
        JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
        if (jobScheduler.getPendingJob(0) != null) {
            jobScheduler.cancel(0);
        }
        int iD = d();
        if (iD < 0) {
            iD = SubscriptionManager.getSlotIndex(SubscriptionManager.getDefaultDataSubscriptionId());
            Log.d("AutoReg_RegistrationTracker", "Getting phoneId " + iD + " is primary stack");
        }
        if (i()) {
            l(new e(iD, SubscriptionManager.getSlotIndex(SubscriptionManager.getDefaultDataSubscriptionId()), 0));
        } else {
            Log.d("AutoReg_RegistrationTracker", "isDDSOnCTSlotWithoutWifi: false");
        }
    }

    public final int d() {
        List<SubscriptionInfo> activeSubscriptionInfoList = this.f1748d.getActiveSubscriptionInfoList();
        if (activeSubscriptionInfoList != null) {
            for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                String iccId = subscriptionInfo.getIccId();
                if (iccId != null) {
                    for (String str : "898603,898611,898612".split(",")) {
                        if (iccId.startsWith(str)) {
                            Log.d("AutoReg_RegistrationTracker", "Got CT slot index: " + subscriptionInfo.getSimSlotIndex());
                            return subscriptionInfo.getSimSlotIndex();
                        }
                    }
                }
            }
        }
        Log.d("AutoReg_RegistrationTracker", "No slot with CT card");
        return -1;
    }

    public final String e() {
        TelephonyManager telephonyManager = this.f1758o;
        if (telephonyManager.getActiveModemCount() <= 1) {
            String simSerialNumber = telephonyManager.getSimSerialNumber();
            return simSerialNumber != null ? simSerialNumber : " ";
        }
        String str = null;
        for (int i3 = 0; i3 < this.f1759p; i3++) {
            int iO = k1.c.l(this.a).o(i3);
            String simSerialNumber2 = iO != -1 ? telephonyManager.createForSubscriptionId(iO).getSimSerialNumber() : "";
            if (simSerialNumber2 == null) {
                simSerialNumber2 = " ";
            }
            str = str == null ? simSerialNumber2 : str + "," + simSerialNumber2;
        }
        return str;
    }

    public final boolean f() {
        for (int i3 = 0; i3 < this.f1759p; i3++) {
            if (this.f1758o.createForSubscriptionId(k1.c.l(this.a).o(i3)).isNetworkRoaming()) {
                return true;
            }
        }
        return false;
    }

    public final boolean g() {
        List<SubscriptionInfo> activeSubscriptionInfoList = this.f1748d.getActiveSubscriptionInfoList();
        if (activeSubscriptionInfoList == null) {
            return false;
        }
        Iterator<SubscriptionInfo> it = activeSubscriptionInfoList.iterator();
        while (it.hasNext()) {
            ServiceState serviceState = this.f1758o.createForSubscriptionId(it.next().getSubscriptionId()).getServiceState();
            if (serviceState != null && serviceState.getState() == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        for (int i3 = 0; i3 < this.f1759p; i3++) {
            if (this.f1758o.getSimState(i3) == 5) {
                return true;
            }
        }
        return false;
    }

    public final boolean i() {
        String iccId;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z2 = true;
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && this.f1758o.getActiveModemCount() > 1 && activeNetworkInfo.getType() != 1) {
            SubscriptionInfo activeSubscriptionInfo = this.f1748d.getActiveSubscriptionInfo(SubscriptionManager.getDefaultDataSubscriptionId());
            if (activeSubscriptionInfo != null && (iccId = activeSubscriptionInfo.getIccId()) != null) {
                String[] strArrSplit = "898603,898611,898612".split(",");
                int length = strArrSplit.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z2 = false;
                        break;
                    }
                    if (iccId.startsWith(strArrSplit[i3])) {
                        break;
                    }
                    i3++;
                }
            } else {
                z2 = false;
                break;
            }
            if (!z2) {
                Log.d("AutoReg_RegistrationTracker", "DDS now on non CT slot without wifi, not to register");
            }
        }
        return z2;
    }

    public final void j() {
        if (this.f1750f != null) {
            return;
        }
        this.f1750f = new o(this, 0);
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.intent.action.SERVICE_STATE");
        intentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");
        intentFilter.addAction("android.provision.action.PROVISION_COMPLETE");
        this.a.registerReceiver(this.f1750f, intentFilter, 2);
    }

    public final void k() {
        boolean zIsEmpty;
        Log.d("AutoReg_RegistrationTracker", "onRegistrationRequest");
        Log.d("AutoReg_RegistrationTracker", "mRegistering = " + this.f1751g + " mFiveGSwitchChanged = " + this.k + " isAnySimCardReady = " + h() + " hasRoamingSub = " + f());
        if ((this.f1751g && !this.k) || !h() || f()) {
            Log.d("AutoReg_RegistrationTracker", "Any SIM is not ready or in Roaming state, not to register");
            return;
        }
        boolean z2 = this.f1761r;
        SharedPreferences sharedPreferences = this.f1746b;
        if (!z2) {
            boolean z3 = Settings.Secure.getInt(this.a.getContentResolver(), "device_provisioned", 0) != 0;
            this.f1761r = z3;
            if (!z3) {
                Log.d("AutoReg_RegistrationTracker", "Provision not completed, Ignore");
                return;
            }
            sharedPreferences.edit().putString("autosms_provision", "true").apply();
        }
        Log.d("AutoReg_RegistrationTracker", "onRegistrationRequest mPowerOn = " + f1745v + ", mDelayBarrier = " + this.f1752h);
        if (f1745v) {
            if (this.f1752h) {
                this.f1752h = false;
                new Handler().postDelayed(new n(this, 0), 60000L);
                return;
            }
            return;
        }
        String strE = e();
        String string = sharedPreferences.getString("sim_iccid", null);
        if (!this.f1760q && !this.f1755l && !this.k && !this.f1753i) {
            if (strE.contains(",")) {
                zIsEmpty = true;
                for (String str : TextUtils.split(strE, ",")) {
                    zIsEmpty &= TextUtils.isEmpty(str.trim());
                }
            } else {
                zIsEmpty = TextUtils.isEmpty(strE.trim());
            }
            if (zIsEmpty || strE.equals(string)) {
                Log.d("AutoReg_RegistrationTracker", "Registered subs, Ignore");
                return;
            }
        }
        int iD = d();
        if (!i() || this.f1754j) {
            Log.d("AutoReg_RegistrationTracker", "non CT DDS, no wifi, register delay ongoing");
        } else {
            this.f1751g = true;
            l(new e(iD, SubscriptionManager.getSlotIndex(SubscriptionManager.getDefaultDataSubscriptionId())));
        }
    }

    public final void l(e eVar) {
        Log.d("AutoReg_RegistrationTracker", "scheduleRegistrationJob");
        this.f1758o.getAllCellInfo();
        Context context = this.a;
        JobInfo.Builder builder = new JobInfo.Builder(0, new ComponentName(context, (Class<?>) RegistrationJobService.class));
        builder.setOverrideDeadline(1000L);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        Bundle bundle = new Bundle();
        bundle.putSerializable("REG_ENTITY", eVar);
        builder.setTransientExtras(bundle);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            try {
                jobScheduler.schedule(builder.build());
            } catch (IllegalStateException unused) {
                Log.d("AutoReg_RegistrationTracker", "scheduleRegistrationJob exception");
            }
        }
    }

    public final void m(boolean z2) {
        if (this.f1754j) {
            Log.d("AutoReg_RegistrationTracker", "DelayOngoing...");
            return;
        }
        boolean z3 = this.f1753i;
        SharedPreferences sharedPreferences = this.f1746b;
        if (z3 && miui.telephony.SubscriptionManager.getDefault().getDefaultDataSlotId() == sharedPreferences.getInt("register_dds_slot", 0)) {
            Log.d("AutoReg_RegistrationTracker", "DDS is set back to the latest registered one, cancel register.");
            this.f1753i = false;
        }
        ConnectivityManager connectivityManager = this.f1749e;
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                if (!this.f1753i && !this.f1755l && !this.f1760q && !this.k) {
                    Log.d("AutoReg_RegistrationTracker", "No to register without network");
                    return;
                } else {
                    Log.d("AutoReg_RegistrationTracker", "No network now after dds changed");
                    j();
                    return;
                }
            }
            boolean zEquals = e().equals(sharedPreferences.getString("sim_iccid", null));
            StringBuilder sb = new StringBuilder("sim isChanged = ");
            sb.append(!zEquals);
            Log.d("AutoReg_RegistrationTracker", sb.toString());
            if (!zEquals || this.f1753i || this.f1755l || this.f1760q || this.k) {
                a();
                boolean z4 = activeNetworkInfo.getType() == 1;
                Log.d("AutoReg_RegistrationTracker", "Try to register underWifi = " + z4 + " serviceChanged = " + z2 + " mDdsChanged = " + this.f1753i + " mFiveGSwitchChanged = " + this.k + " mSWVERChanged = " + this.f1755l + " mPeriodRegTrigger = " + this.f1760q + " hasService = " + g());
                if (z2 || !z4 || (z4 && g())) {
                    k();
                }
            }
        }
    }

    public final void n() {
        if (h()) {
            int defaultDataSlotId = miui.telephony.SubscriptionManager.getDefault().getDefaultDataSlotId();
            SharedPreferences sharedPreferences = this.f1746b;
            if (defaultDataSlotId != sharedPreferences.getInt("register_dds_slot", 0)) {
                this.f1753i = true;
                if (this.f1754j) {
                    return;
                }
                this.f1754j = true;
                sharedPreferences.edit().putInt("register_request_count", 0).apply();
                a();
                new Handler().postDelayed(new n(this, 1), 60000L);
                return;
            }
        }
        Log.d("AutoReg_RegistrationTracker", "sim not ready or already register !!!");
    }
}
