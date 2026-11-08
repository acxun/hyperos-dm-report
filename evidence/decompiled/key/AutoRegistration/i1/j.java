package i1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.ims.ImsManager;
import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import miui.os.Build;
import miui.telephony.PhoneDebug;

/* JADX INFO: loaded from: classes.dex */
public final class j extends q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final j[] f1716v = new j[q.f1764e];

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static i f1717w;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AlarmManager f1721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SubscriptionManager f1722j;
    public i k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1723l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1724m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1725n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1726o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1727p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1728q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1729r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f1730s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f1731t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d f1732u;

    public j(Context context, int i3) {
        super(context, i3);
        int i4 = 0;
        String str = String.format("%s_%d", "second_slot_trigger", Integer.valueOf(i3));
        this.f1718f = str;
        this.f1719g = String.format("%s_%d", "second_slot_imsi", Integer.valueOf(i3));
        String str2 = String.format("%s_%d", "register_request_ims_count", Integer.valueOf(i3));
        this.f1720h = str2;
        this.f1723l = false;
        this.f1724m = false;
        this.f1725n = false;
        this.f1726o = false;
        this.f1727p = false;
        this.f1728q = false;
        this.f1730s = null;
        String str3 = String.format("%s_%d", "last_registration_id", Integer.valueOf(i3));
        this.f1731t = str3;
        i("RegistrationOverIms constructor");
        this.f1722j = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        this.f1721i = alarmManager;
        if (k1.d.f(context, this.a, "lte_imsi", i3)) {
            i("IMSI change detected on init. Clearing stale success/session records.");
            this.a.edit().remove("lte_imsi" + i3).remove(str3).remove(str).putInt(str2, 0).apply();
            i("Stale records cleared for slot " + i3);
        }
        d dVar = new d();
        this.f1732u = dVar;
        dVar.a = this;
        dVar.f1697d = context;
        dVar.f1696c = (ImsManager) context.getSystemService(ImsManager.class);
        dVar.f1701h = i3;
        dVar.b(k1.c.l(dVar.f1697d).o(i3));
        dVar.f1697d.registerReceiver(new a(dVar, i3), new IntentFilter("android.intent.action.SIM_STATE_CHANGED"), 2);
        if (this.k == null) {
            this.k = new i(this, i4);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("miui.intent.action.SMS_AUTO_REGISTRATION_PERIOD_TRIGGER");
            intentFilter.addAction("miui.intent.action.SMS_AUTO_REGISTRATION_RETRY");
            intentFilter.addAction("miui.intent.action.ACTION_DEFAULT_DATA_SLOT_CHANGED");
            intentFilter.addAction("miui.intent.action.ACTION_SMS_AUTO_REGISTRATION_IMSSEAULTCHECK");
            intentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");
            context.registerReceiver(this.k, intentFilter, 2);
        }
        d();
        Intent intent = new Intent("miui.intent.action.SMS_AUTO_REGISTRATION_PERIOD_TRIGGER");
        intent.setPackage(context.getPackageName());
        intent.addFlags(268435456);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 67108864);
        i("startPeriodRegTimer");
        alarmManager.setRepeating(0, System.currentTimeMillis() + 43200000, 43200000L, broadcast);
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 6) {
            return "***";
        }
        return str.substring(0, 3) + "****" + str.substring(str.length() - 3);
    }

    @Override // i1.q
    public final void a() {
        e();
        SharedPreferences sharedPreferences = this.a;
        String str = this.f1720h;
        int i3 = sharedPreferences.getInt(str, 0) + 1;
        sharedPreferences.edit().putInt(str, i3).apply();
        if (i3 >= 4) {
            i("sms auto registration achieved max request.");
            e();
            return;
        }
        i("sms auto registration for the retry " + i3);
        Intent intent = new Intent("miui.intent.action.SMS_AUTO_REGISTRATION_RETRY");
        Context context = this.f1767d;
        intent.setPackage(context.getPackageName());
        intent.addFlags(268435456);
        try {
            this.f1721i.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 600000, PendingIntent.getBroadcast(context, 0, intent, 67108864));
        } catch (Exception e3) {
            i("scheduleNextIfNeed : setExactAndAllowWhileIdle catch exception");
            e3.printStackTrace();
        }
    }

    public final void c() {
        String str;
        Intent intent = new Intent("miui.intent.action.ACTION_SMS_AUTO_REGISTRATION_IMSSEAULTCHECK");
        Context context = this.f1767d;
        intent.setPackage(context.getPackageName());
        intent.addFlags(268435456);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 603979776);
        if (broadcast != null) {
            this.f1721i.cancel(broadcast);
            str = "cancel the pending intent: ACTION_SMS_AUTO_REGISTRATION_SEAULTCHECK";
        } else {
            str = "PendingIntent not found, cannot cancel.";
        }
        i(str);
    }

    public final void d() {
        String str;
        i("checkPeriodRegTimer");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        StringBuilder sb = new StringBuilder("sms_auto_register_regtime");
        int i3 = this.f1766c;
        sb.append(i3);
        String string = this.a.getString(sb.toString(), "");
        i("Latest autoReg time: " + string + ", slotId = " + i3);
        boolean z2 = false;
        if (!string.isEmpty()) {
            try {
                Date date = simpleDateFormat.parse(string);
                Date date2 = new Date(System.currentTimeMillis());
                String str2 = simpleDateFormat.format(date2);
                long time = (date2.getTime() - date.getTime()) / 1000;
                z2 = time > 1296000;
                str = "Time from latest autoReg:" + time + ", thresh:1296000, currentTime: " + str2 + ", trig:" + z2;
            } catch (Exception unused) {
                str = "Latest autoReg time exception";
            }
            i(str);
        }
        if (z2) {
            this.f1726o = true;
            m();
        }
    }

    public final void e() {
        if (this.f1730s != null) {
            i("clearRegistrationId: clearing registration ID: " + this.f1730s);
            this.f1730s = null;
            this.a.edit().remove(this.f1731t).apply();
            i("clearRegistrationId: registration ID cleared, ready for retry");
        }
    }

    public final boolean f(int i3) {
        String str;
        int activeDataSubscriptionId = SubscriptionManager.getActiveDataSubscriptionId();
        SubscriptionInfo activeSubscriptionInfoForSimSlotIndex = this.f1722j.getActiveSubscriptionInfoForSimSlotIndex(i3);
        boolean z2 = true;
        if (activeSubscriptionInfoForSimSlotIndex == null) {
            i("isPrimaryCard: no subscription info for slot " + i3);
            if (TextUtils.isEmpty(this.a.getString("lte_imsi" + i3, ""))) {
                return false;
            }
            str = "isPrimaryCard: slot " + i3 + " has saved IMSI, treating as primary card";
        } else {
            int subscriptionId = activeSubscriptionInfoForSimSlotIndex.getSubscriptionId();
            z2 = activeDataSubscriptionId == subscriptionId;
            str = "isPrimaryCard: slotId=" + i3 + ", dataSubId=" + activeDataSubscriptionId + ", currentSubId=" + subscriptionId + ", isPrimary=" + z2;
        }
        i(str);
        return z2;
    }

    public final boolean g(int i3) {
        return this.f1765b.createForSubscriptionId(k1.c.l(this.f1767d).o(i3)).isNetworkRoaming();
    }

    public final boolean h(int i3) {
        String str;
        String strB = k1.d.b(this.f1767d, i3);
        String string = this.a.getString(this.f1719g, "");
        i("isSecondSlotImsiChanged: secondSlotId=" + i3 + ", current=" + j(strB) + ", saved=" + j(string));
        if (TextUtils.isEmpty(strB) && !TextUtils.isEmpty(string)) {
            str = "isSecondSlotImsiChanged: SIM card removed detected (current empty, saved exists)";
        } else {
            if (TextUtils.isEmpty(strB) || !TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty(strB)) {
                    i("isSecondSlotImsiChanged: both current and saved IMSI are empty, no change detected");
                    return false;
                }
                boolean z2 = !strB.equals(string);
                i(z2 ? "isSecondSlotImsiChanged: SIM card changed detected (IMSI different)" : "isSecondSlotImsiChanged: IMSI not changed");
                return z2;
            }
            str = "isSecondSlotImsiChanged: New SIM card inserted detected (current exists, saved empty)";
        }
        i(str);
        return true;
    }

    public final void i(String str) {
        Log.d("AutoReg_OverIms", "[" + this.f1766c + "]" + str);
    }

    public final void k(int i3) {
        String strB = k1.d.b(this.f1767d, i3);
        i("saveSecondSlotImsi: secondSlotId=" + i3 + ", IMSI=" + j(strB));
        boolean zIsEmpty = TextUtils.isEmpty(strB);
        String str = this.f1719g;
        SharedPreferences sharedPreferences = this.a;
        if (zIsEmpty) {
            sharedPreferences.edit().putString(str, "").apply();
            i("clearSecondSlotImsi: cleared second slot IMSI for key=" + str);
            return;
        }
        sharedPreferences.edit().putString(str, strB).apply();
        i("storeSecondSlotImsi: saved second slot IMSI=" + j(strB) + ", key=" + str);
    }

    public final void l() {
        String str;
        String string;
        i("Start to collect info");
        int i3 = 0;
        int i4 = this.f1766c;
        int i5 = i4 == 1 ? 0 : 1;
        TelephonyManager telephonyManager = this.f1765b;
        if (telephonyManager.getSimState(i5) != 1 && TextUtils.isEmpty(miui.telephony.TelephonyManager.getDefault().getSimOperatorForSlot(i5)) && !this.f1725n) {
            new Handler(Looper.getMainLooper()).postDelayed(new h(this, i3), 2000L);
            return;
        }
        this.f1730s = System.currentTimeMillis() + "_" + i4 + "_" + new Random().nextInt(10000);
        this.a.edit().putString(this.f1731t, this.f1730s).apply();
        StringBuilder sb = new StringBuilder("Generated new registration ID: ");
        sb.append(this.f1730s);
        i(sb.toString());
        Context context = this.f1767d;
        String strC = k1.d.c(context);
        String imeiForSlot = miui.telephony.TelephonyManager.getDefault().getImeiForSlot(i4);
        if (imeiForSlot == null) {
            imeiForSlot = "";
        }
        String imeiForSlot2 = miui.telephony.TelephonyManager.getDefault().getImeiForSlot(1 - i4);
        String str2 = imeiForSlot2 != null ? imeiForSlot2 : "";
        telephonyManager.getMeid();
        String strB = k1.d.b(context, i4);
        String strA = k1.d.a(context);
        if (q.f1764e == 1) {
            string = "01";
        } else {
            String simOperatorForSlot = miui.telephony.TelephonyManager.getDefault().getSimOperatorForSlot(i4 == 1 ? 0 : 1);
            StringBuilder sb2 = new StringBuilder();
            boolean zJ = g2.e.j(simOperatorForSlot);
            boolean zI = g2.e.i(simOperatorForSlot);
            boolean zH = g2.e.h(simOperatorForSlot);
            boolean z2 = "46013".equals(simOperatorForSlot) || "46015".equals(simOperatorForSlot);
            int defaultDataSlotId = miui.telephony.SubscriptionManager.getDefault().getDefaultDataSlotId();
            if (TextUtils.isEmpty(simOperatorForSlot)) {
                sb2.append("0");
            } else if (zH) {
                sb2.append("1");
            } else if (zJ) {
                sb2.append("2");
            } else {
                if (zI) {
                    str = "3";
                } else {
                    str = z2 ? "5" : "4";
                }
                sb2.append(str);
            }
            if (this.f1722j.getActiveSubscriptionInfoForSimSlotIndex(i4) != null) {
                i("activeDataSoltId: " + defaultDataSlotId + ", SlotId: " + i4);
                if (defaultDataSlotId == i4) {
                    sb2.append("1");
                } else {
                    sb2.append("2");
                }
            } else {
                sb2.append("0");
            }
            string = sb2.toString();
        }
        String str3 = String.format("<a><b>%s<c>%s<d>%s<e>%s<f>%s<g>%s</a>", strC, imeiForSlot, str2, strB, strA, string);
        int length = str3.length();
        i("length is " + length);
        byte[] bArr = {(byte) 4, (byte) 3, (byte) length, 0};
        byte[] bytes = str3.getBytes();
        byte[] bArr2 = new byte[bytes.length + 4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        System.arraycopy(bytes, 0, bArr2, 4, bytes.length);
        if (PhoneDebug.VDBG || Build.IS_CT_CUSTOMIZATION_TEST) {
            i("full msg is ".concat(new String(bArr2)));
        }
        b(new String(bArr2));
        i("Starting 10-minute timeout...");
        c();
        Intent intent = new Intent("miui.intent.action.ACTION_SMS_AUTO_REGISTRATION_IMSSEAULTCHECK");
        intent.setPackage(context.getPackageName());
        intent.addFlags(268435456);
        try {
            this.f1721i.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 600000, PendingIntent.getBroadcast(context, 0, intent, 67108864));
        } catch (Exception e3) {
            i("startTimeout: setExactAndAllowWhileIdle catch exception");
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0215  */
    /* JADX WARN: Code duplicated, block: B:103:0x021b  */
    /* JADX WARN: Code duplicated, block: B:106:0x0224  */
    /* JADX WARN: Code duplicated, block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x0113  */
    /* JADX WARN: Code duplicated, block: B:64:0x0119  */
    /* JADX WARN: Code duplicated, block: B:65:0x0121  */
    /* JADX WARN: Code duplicated, block: B:67:0x0125  */
    /* JADX WARN: Code duplicated, block: B:68:0x0128 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x012a  */
    /* JADX WARN: Code duplicated, block: B:71:0x012e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0190  */
    /* JADX WARN: Code duplicated, block: B:76:0x0199 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x019b  */
    /* JADX WARN: Code duplicated, block: B:79:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:81:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:82:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:84:0x01be  */
    /* JADX WARN: Code duplicated, block: B:85:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:87:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:89:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:93:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:95:0x0209  */
    /* JADX WARN: Code duplicated, block: B:96:0x020e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0212  */
    public final void m() {
        String str;
        String str2;
        boolean zH;
        String str3;
        boolean z2;
        int activeDataSubscriptionId;
        SubscriptionInfo activeSubscriptionInfoForSimSlotIndex;
        int subscriptionId;
        Context context;
        i iVar;
        int activeDataSubscriptionId2;
        SubscriptionInfo activeSubscriptionInfoForSimSlotIndex2;
        int subscriptionId2;
        boolean z3;
        boolean z4;
        if (Build.IS_TABLET) {
            i("Tablet project, cancel SMS registration");
            return;
        }
        if (k1.d.g(this.f1767d)) {
            i("SatelliteEnabled, cancel SMS registration");
            return;
        }
        d dVar = this.f1732u;
        if (dVar != null) {
            synchronized (dVar.f1699f) {
                z4 = dVar.f1698e;
            }
            if (!z4) {
                i("tryToRegister: IMS SMS capability is false. Aborting registration.");
                return;
            }
        }
        if (this.f1730s != null) {
            i("tryToRegister: Registration is already in progress (ID: " + this.f1730s + "). Aborting new request.");
            return;
        }
        this.f1723l = g2.e.c("persist.radio.game.status");
        boolean zG = g(this.f1766c);
        if (!k1.d.e(this.f1766c) || zG) {
            i("no ct card or isRoaming, not register");
            if (this.a.getBoolean(this.f1718f, false)) {
                this.a.edit().putBoolean(this.f1718f, false).apply();
                i("cleared second slot trigger flag for non-CT card");
                return;
            }
            return;
        }
        boolean zF = k1.d.f(this.f1767d, this.a, "lte_imsi", this.f1766c);
        boolean z5 = this.a.getBoolean(this.f1718f, false);
        int i3 = 1;
        if (!zF) {
            if (z5) {
                i("tryToRegister: second slot trigger flag is already set");
                zH = true;
            } else if (f(this.f1766c)) {
                int i4 = this.f1766c == 1 ? 0 : 1;
                zH = h(i4);
                i("tryToRegister: current slot is primary card, checking second slot change result=" + zH);
                if (zH) {
                    this.a.edit().putBoolean(this.f1718f, true).apply();
                    k(i4);
                }
            } else {
                str = "tryToRegister: current slot is NOT primary card, only check self IMSI change";
            }
            str3 = "";
            if (zF) {
                str3 = "current slot IMSI changed";
                if (this.f1728q) {
                    this.f1728q = false;
                    i("cleared DDS flag due to IMSI change trigger");
                }
            } else {
                if (!this.f1726o) {
                    if (zH) {
                        str3 = "second slot changed";
                    } else {
                        z2 = false;
                    }
                    i("tryToRegister: mPeriodRegTrigger=" + this.f1726o + ", isImsiChanged=" + zF + ", isSecondSlotChanged=" + zH + ", isSecondSlotTriggered=" + z5 + ", mGameStatus=" + this.f1723l + ", mDdsChanged=" + this.f1728q + ", isRoaming=" + zG + ", isPrimaryCard=" + f(this.f1766c) + ", triggerReason=" + str3);
                    if (this.f1728q) {
                        i("DDS changed, start register");
                        l();
                        return;
                    }
                    if (z2) {
                        i("If the conditions for reporting are not met, the registration will be cancelled.");
                        return;
                    }
                    i("Registration triggered by: ".concat(str3));
                    if (this.f1723l) {
                        int i5 = this.f1766c;
                        activeDataSubscriptionId2 = SubscriptionManager.getActiveDataSubscriptionId();
                        activeSubscriptionInfoForSimSlotIndex2 = this.f1722j.getActiveSubscriptionInfoForSimSlotIndex(i5);
                        if (activeSubscriptionInfoForSimSlotIndex2 != null) {
                            subscriptionId2 = activeSubscriptionInfoForSimSlotIndex2.getSubscriptionId();
                        } else {
                            subscriptionId2 = activeDataSubscriptionId2;
                        }
                        if (activeDataSubscriptionId2 != subscriptionId2) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            i("Game Status is true, wait for game closed");
                            if (this.f1724m) {
                                return;
                            }
                            this.f1724m = true;
                            i("gameModeRegisterReceiver init! ");
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("com.android.phone.intent.action.CHANGE_LEVEL");
                            i iVar2 = new i(this, i3);
                            f1717w = iVar2;
                            this.f1767d.registerReceiver(iVar2, intentFilter, 2);
                            return;
                        }
                    }
                    i("normal start register, trigger reason: ".concat(str3));
                    l();
                    if (this.f1724m) {
                        int i6 = this.f1766c;
                        activeDataSubscriptionId = SubscriptionManager.getActiveDataSubscriptionId();
                        activeSubscriptionInfoForSimSlotIndex = this.f1722j.getActiveSubscriptionInfoForSimSlotIndex(i6);
                        if (activeSubscriptionInfoForSimSlotIndex != null) {
                            subscriptionId = activeSubscriptionInfoForSimSlotIndex.getSubscriptionId();
                        } else {
                            subscriptionId = activeDataSubscriptionId;
                        }
                        if ((activeDataSubscriptionId == subscriptionId ? 0 : 1) != 0) {
                            context = this.f1767d;
                            iVar = f1717w;
                            if (iVar != null) {
                                context.unregisterReceiver(iVar);
                                f1717w = null;
                            }
                            this.f1724m = false;
                        }
                    }
                }
                str3 = "periodic trigger";
            }
            z2 = true;
            i("tryToRegister: mPeriodRegTrigger=" + this.f1726o + ", isImsiChanged=" + zF + ", isSecondSlotChanged=" + zH + ", isSecondSlotTriggered=" + z5 + ", mGameStatus=" + this.f1723l + ", mDdsChanged=" + this.f1728q + ", isRoaming=" + zG + ", isPrimaryCard=" + f(this.f1766c) + ", triggerReason=" + str3);
            if (this.f1728q) {
                i("DDS changed, start register");
                l();
                return;
            }
            if (z2) {
                i("If the conditions for reporting are not met, the registration will be cancelled.");
                return;
            }
            i("Registration triggered by: ".concat(str3));
            if (this.f1723l) {
                int i7 = this.f1766c;
                activeDataSubscriptionId2 = SubscriptionManager.getActiveDataSubscriptionId();
                activeSubscriptionInfoForSimSlotIndex2 = this.f1722j.getActiveSubscriptionInfoForSimSlotIndex(i7);
                if (activeSubscriptionInfoForSimSlotIndex2 != null) {
                    subscriptionId2 = activeSubscriptionInfoForSimSlotIndex2.getSubscriptionId();
                } else {
                    subscriptionId2 = activeDataSubscriptionId2;
                }
                if (activeDataSubscriptionId2 != subscriptionId2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    i("Game Status is true, wait for game closed");
                    if (this.f1724m) {
                        this.f1724m = true;
                        i("gameModeRegisterReceiver init! ");
                        IntentFilter intentFilter2 = new IntentFilter();
                        intentFilter2.addAction("com.android.phone.intent.action.CHANGE_LEVEL");
                        i iVar3 = new i(this, i3);
                        f1717w = iVar3;
                        this.f1767d.registerReceiver(iVar3, intentFilter2, 2);
                        return;
                    }
                    return;
                }
            }
            i("normal start register, trigger reason: ".concat(str3));
            l();
            if (this.f1724m) {
                int i8 = this.f1766c;
                activeDataSubscriptionId = SubscriptionManager.getActiveDataSubscriptionId();
                activeSubscriptionInfoForSimSlotIndex = this.f1722j.getActiveSubscriptionInfoForSimSlotIndex(i8);
                if (activeSubscriptionInfoForSimSlotIndex != null) {
                    subscriptionId = activeSubscriptionInfoForSimSlotIndex.getSubscriptionId();
                } else {
                    subscriptionId = activeDataSubscriptionId;
                }
                if ((activeDataSubscriptionId == subscriptionId ? 0 : 1) != 0) {
                    context = this.f1767d;
                    iVar = f1717w;
                    if (iVar != null) {
                        context.unregisterReceiver(iVar);
                        f1717w = null;
                    }
                    this.f1724m = false;
                }
            }
        }
        i("tryToRegister: current slot IMSI changed, clearing second slot trigger to avoid duplicate registration");
        if (z5) {
            if (this.f1730s == null) {
                this.a.edit().putBoolean(this.f1718f, false).apply();
                str2 = "cleared second slot trigger flag due to current slot IMSI change";
            } else {
                str2 = "There is a pending registration (ID: " + this.f1730s + "), keep second slot trigger flag unchanged";
            }
            i(str2);
        }
        if (f(this.f1766c)) {
            k(this.f1766c == 1 ? 0 : 1);
            str = "updated second slot IMSI record due to current slot change";
        }
        zH = false;
        str3 = "";
        if (zF) {
            str3 = "current slot IMSI changed";
            if (this.f1728q) {
                this.f1728q = false;
                i("cleared DDS flag due to IMSI change trigger");
            }
        } else {
            if (!this.f1726o) {
                if (zH) {
                    str3 = "second slot changed";
                } else {
                    z2 = false;
                }
                i("tryToRegister: mPeriodRegTrigger=" + this.f1726o + ", isImsiChanged=" + zF + ", isSecondSlotChanged=" + zH + ", isSecondSlotTriggered=" + z5 + ", mGameStatus=" + this.f1723l + ", mDdsChanged=" + this.f1728q + ", isRoaming=" + zG + ", isPrimaryCard=" + f(this.f1766c) + ", triggerReason=" + str3);
                if (this.f1728q) {
                    i("DDS changed, start register");
                    l();
                    return;
                }
                if (z2) {
                    i("If the conditions for reporting are not met, the registration will be cancelled.");
                    return;
                }
                i("Registration triggered by: ".concat(str3));
                if (this.f1723l) {
                    int i9 = this.f1766c;
                    activeDataSubscriptionId2 = SubscriptionManager.getActiveDataSubscriptionId();
                    activeSubscriptionInfoForSimSlotIndex2 = this.f1722j.getActiveSubscriptionInfoForSimSlotIndex(i9);
                    if (activeSubscriptionInfoForSimSlotIndex2 != null) {
                        subscriptionId2 = activeSubscriptionInfoForSimSlotIndex2.getSubscriptionId();
                    } else {
                        subscriptionId2 = activeDataSubscriptionId2;
                    }
                    if (activeDataSubscriptionId2 != subscriptionId2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        i("Game Status is true, wait for game closed");
                        if (this.f1724m) {
                            this.f1724m = true;
                            i("gameModeRegisterReceiver init! ");
                            IntentFilter intentFilter3 = new IntentFilter();
                            intentFilter3.addAction("com.android.phone.intent.action.CHANGE_LEVEL");
                            i iVar4 = new i(this, i3);
                            f1717w = iVar4;
                            this.f1767d.registerReceiver(iVar4, intentFilter3, 2);
                            return;
                        }
                        return;
                    }
                }
                i("normal start register, trigger reason: ".concat(str3));
                l();
                if (this.f1724m) {
                    int i10 = this.f1766c;
                    activeDataSubscriptionId = SubscriptionManager.getActiveDataSubscriptionId();
                    activeSubscriptionInfoForSimSlotIndex = this.f1722j.getActiveSubscriptionInfoForSimSlotIndex(i10);
                    if (activeSubscriptionInfoForSimSlotIndex != null) {
                        subscriptionId = activeSubscriptionInfoForSimSlotIndex.getSubscriptionId();
                    } else {
                        subscriptionId = activeDataSubscriptionId;
                    }
                    if ((activeDataSubscriptionId == subscriptionId ? 0 : 1) != 0) {
                        context = this.f1767d;
                        iVar = f1717w;
                        if (iVar != null) {
                            context.unregisterReceiver(iVar);
                            f1717w = null;
                        }
                        this.f1724m = false;
                    }
                }
            }
            str3 = "periodic trigger";
        }
        z2 = true;
        i("tryToRegister: mPeriodRegTrigger=" + this.f1726o + ", isImsiChanged=" + zF + ", isSecondSlotChanged=" + zH + ", isSecondSlotTriggered=" + z5 + ", mGameStatus=" + this.f1723l + ", mDdsChanged=" + this.f1728q + ", isRoaming=" + zG + ", isPrimaryCard=" + f(this.f1766c) + ", triggerReason=" + str3);
        if (this.f1728q) {
            i("DDS changed, start register");
            l();
            return;
        }
        if (z2) {
            i("If the conditions for reporting are not met, the registration will be cancelled.");
            return;
        }
        i("Registration triggered by: ".concat(str3));
        if (this.f1723l) {
            int i11 = this.f1766c;
            activeDataSubscriptionId2 = SubscriptionManager.getActiveDataSubscriptionId();
            activeSubscriptionInfoForSimSlotIndex2 = this.f1722j.getActiveSubscriptionInfoForSimSlotIndex(i11);
            if (activeSubscriptionInfoForSimSlotIndex2 != null) {
                subscriptionId2 = activeSubscriptionInfoForSimSlotIndex2.getSubscriptionId();
            } else {
                subscriptionId2 = activeDataSubscriptionId2;
            }
            if (activeDataSubscriptionId2 != subscriptionId2) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                i("Game Status is true, wait for game closed");
                if (this.f1724m) {
                    this.f1724m = true;
                    i("gameModeRegisterReceiver init! ");
                    IntentFilter intentFilter4 = new IntentFilter();
                    intentFilter4.addAction("com.android.phone.intent.action.CHANGE_LEVEL");
                    i iVar5 = new i(this, i3);
                    f1717w = iVar5;
                    this.f1767d.registerReceiver(iVar5, intentFilter4, 2);
                    return;
                }
                return;
            }
        }
        i("normal start register, trigger reason: ".concat(str3));
        l();
        if (this.f1724m) {
            int i12 = this.f1766c;
            activeDataSubscriptionId = SubscriptionManager.getActiveDataSubscriptionId();
            activeSubscriptionInfoForSimSlotIndex = this.f1722j.getActiveSubscriptionInfoForSimSlotIndex(i12);
            if (activeSubscriptionInfoForSimSlotIndex != null) {
                subscriptionId = activeSubscriptionInfoForSimSlotIndex.getSubscriptionId();
            } else {
                subscriptionId = activeDataSubscriptionId;
            }
            if ((activeDataSubscriptionId == subscriptionId ? 0 : 1) != 0) {
                context = this.f1767d;
                iVar = f1717w;
                if (iVar != null) {
                    context.unregisterReceiver(iVar);
                    f1717w = null;
                }
                this.f1724m = false;
            }
        }
        i(str);
        zH = false;
        str3 = "";
        if (zF) {
            str3 = "current slot IMSI changed";
            if (this.f1728q) {
                this.f1728q = false;
                i("cleared DDS flag due to IMSI change trigger");
            }
        } else {
            if (!this.f1726o) {
                if (zH) {
                    str3 = "second slot changed";
                } else {
                    z2 = false;
                }
                i("tryToRegister: mPeriodRegTrigger=" + this.f1726o + ", isImsiChanged=" + zF + ", isSecondSlotChanged=" + zH + ", isSecondSlotTriggered=" + z5 + ", mGameStatus=" + this.f1723l + ", mDdsChanged=" + this.f1728q + ", isRoaming=" + zG + ", isPrimaryCard=" + f(this.f1766c) + ", triggerReason=" + str3);
                if (this.f1728q) {
                    i("DDS changed, start register");
                    l();
                    return;
                }
                if (z2) {
                    i("If the conditions for reporting are not met, the registration will be cancelled.");
                    return;
                }
                i("Registration triggered by: ".concat(str3));
                if (this.f1723l) {
                    int i13 = this.f1766c;
                    activeDataSubscriptionId2 = SubscriptionManager.getActiveDataSubscriptionId();
                    activeSubscriptionInfoForSimSlotIndex2 = this.f1722j.getActiveSubscriptionInfoForSimSlotIndex(i13);
                    if (activeSubscriptionInfoForSimSlotIndex2 != null) {
                        subscriptionId2 = activeSubscriptionInfoForSimSlotIndex2.getSubscriptionId();
                    } else {
                        subscriptionId2 = activeDataSubscriptionId2;
                    }
                    if (activeDataSubscriptionId2 != subscriptionId2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        i("Game Status is true, wait for game closed");
                        if (this.f1724m) {
                            this.f1724m = true;
                            i("gameModeRegisterReceiver init! ");
                            IntentFilter intentFilter5 = new IntentFilter();
                            intentFilter5.addAction("com.android.phone.intent.action.CHANGE_LEVEL");
                            i iVar6 = new i(this, i3);
                            f1717w = iVar6;
                            this.f1767d.registerReceiver(iVar6, intentFilter5, 2);
                            return;
                        }
                        return;
                    }
                }
                i("normal start register, trigger reason: ".concat(str3));
                l();
                if (this.f1724m) {
                    int i14 = this.f1766c;
                    activeDataSubscriptionId = SubscriptionManager.getActiveDataSubscriptionId();
                    activeSubscriptionInfoForSimSlotIndex = this.f1722j.getActiveSubscriptionInfoForSimSlotIndex(i14);
                    if (activeSubscriptionInfoForSimSlotIndex != null) {
                        subscriptionId = activeSubscriptionInfoForSimSlotIndex.getSubscriptionId();
                    } else {
                        subscriptionId = activeDataSubscriptionId;
                    }
                    if ((activeDataSubscriptionId == subscriptionId ? 0 : 1) != 0) {
                        context = this.f1767d;
                        iVar = f1717w;
                        if (iVar != null) {
                            context.unregisterReceiver(iVar);
                            f1717w = null;
                        }
                        this.f1724m = false;
                    }
                }
            }
            str3 = "periodic trigger";
        }
        z2 = true;
        i("tryToRegister: mPeriodRegTrigger=" + this.f1726o + ", isImsiChanged=" + zF + ", isSecondSlotChanged=" + zH + ", isSecondSlotTriggered=" + z5 + ", mGameStatus=" + this.f1723l + ", mDdsChanged=" + this.f1728q + ", isRoaming=" + zG + ", isPrimaryCard=" + f(this.f1766c) + ", triggerReason=" + str3);
        if (this.f1728q) {
            i("DDS changed, start register");
            l();
            return;
        }
        if (z2) {
            i("If the conditions for reporting are not met, the registration will be cancelled.");
            return;
        }
        i("Registration triggered by: ".concat(str3));
        if (this.f1723l) {
            int i15 = this.f1766c;
            activeDataSubscriptionId2 = SubscriptionManager.getActiveDataSubscriptionId();
            activeSubscriptionInfoForSimSlotIndex2 = this.f1722j.getActiveSubscriptionInfoForSimSlotIndex(i15);
            if (activeSubscriptionInfoForSimSlotIndex2 != null) {
                subscriptionId2 = activeSubscriptionInfoForSimSlotIndex2.getSubscriptionId();
            } else {
                subscriptionId2 = activeDataSubscriptionId2;
            }
            if (activeDataSubscriptionId2 != subscriptionId2) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                i("Game Status is true, wait for game closed");
                if (this.f1724m) {
                    this.f1724m = true;
                    i("gameModeRegisterReceiver init! ");
                    IntentFilter intentFilter6 = new IntentFilter();
                    intentFilter6.addAction("com.android.phone.intent.action.CHANGE_LEVEL");
                    i iVar7 = new i(this, i3);
                    f1717w = iVar7;
                    this.f1767d.registerReceiver(iVar7, intentFilter6, 2);
                    return;
                }
                return;
            }
        }
        i("normal start register, trigger reason: ".concat(str3));
        l();
        if (this.f1724m) {
            int i16 = this.f1766c;
            activeDataSubscriptionId = SubscriptionManager.getActiveDataSubscriptionId();
            activeSubscriptionInfoForSimSlotIndex = this.f1722j.getActiveSubscriptionInfoForSimSlotIndex(i16);
            if (activeSubscriptionInfoForSimSlotIndex != null) {
                subscriptionId = activeSubscriptionInfoForSimSlotIndex.getSubscriptionId();
            } else {
                subscriptionId = activeDataSubscriptionId;
            }
            if ((activeDataSubscriptionId == subscriptionId ? 0 : 1) != 0) {
                context = this.f1767d;
                iVar = f1717w;
                if (iVar != null) {
                    context.unregisterReceiver(iVar);
                    f1717w = null;
                }
                this.f1724m = false;
            }
        }
    }

    public final void n() {
        i("tryToRegisterDelay triggered by IMS capability change.");
        if (this.f1730s != null) {
            i("tryToRegisterDelay: A registration is already in progress (ID: " + this.f1730s + "). Skipping this trigger.");
            return;
        }
        if (this.f1727p) {
            i("tryToRegisterDelay: A delayed registration task is already scheduled. Skipping duplicate trigger.");
            return;
        }
        i("tryToRegisterDelay: Scheduling a registration check after a delay.");
        this.f1727p = true;
        new Handler(Looper.getMainLooper()).postDelayed(new h(this, 1), 60000L);
    }
}
