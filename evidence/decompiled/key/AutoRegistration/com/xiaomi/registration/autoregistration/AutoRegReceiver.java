package com.xiaomi.registration.autoregistration;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.activity.result.a;
import g2.e;
import i1.j;
import i1.p;
import i1.t;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import k1.d;
import miui.os.Build;
import miui.os.UserHandle;
import miui.telephony.SubscriptionManager;

/* JADX INFO: loaded from: classes.dex */
public class AutoRegReceiver extends BroadcastReceiver {
    public static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f834b = false;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean z2;
        String str;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        Log.d("AutoReg_Receiver", "onReceived action:" + action + ", mBootCompleted: " + a);
        int i3 = d.a;
        if (i3 != 0) {
            if (i3 != 1) {
                boolean zEquals = "disabled".equals(e.g("ro.product.autosms", "enabled"));
                if (zEquals) {
                    str = "ro.product.autosms" + zEquals;
                } else {
                    if (Build.IS_CU_CUSTOMIZATION || Build.IS_CM_CUSTOMIZATION) {
                        str = "it cu, so not reg";
                    } else if (TextUtils.isEmpty(d.c(context))) {
                        Log.d("AutoReg_Utils", "not the correct device to reg1, the device is " + Build.DEVICE);
                    } else {
                        d.a = 1;
                    }
                    z2 = false;
                }
                Log.d("AutoReg_Utils", str);
                d.a = 0;
                z2 = false;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) == 1) {
            if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.provision.action.PROVISION_COMPLETE")) {
                f834b = true;
                Log.d("AutoReg_Receiver", "Action boot completed...");
                PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("register_request_ims_count", 0).apply();
            }
            Log.d("AutoReg_Receiver", "current userId = " + UserHandle.myUserId());
            if (!z2 || UserHandle.myUserId() != 0) {
                Log.d("AutoReg_Receiver", "bait out");
                return;
            }
            if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.LOCKED_BOOT_COMPLETED") || action.equals("android.intent.action.MY_PACKAGE_REPLACED") || action.equals("android.provision.action.PROVISION_COMPLETE")) {
                if (RegistrationService.a == null) {
                    Log.d("AutoReg_Receiver", "Action boot completed...start service...");
                    context.startService(new Intent(context, (Class<?>) RegistrationService.class));
                    a = true;
                    return;
                }
                return;
            }
            if (a && action.equals("android.telephony.action.SECRET_CODE")) {
                Log.d("AutoReg_Receiver", "Action secret code received...");
                p pVar = p.f1744u;
                if (pVar != null) {
                    pVar.c();
                    return;
                }
                return;
            }
            if (action.equals("com.qualcomm.qti.action.AUTO_REGISTRATION")) {
                Log.d("AutoReg_Receiver", "Action result received...");
                p pVar2 = p.f1744u;
                if (pVar2 != null) {
                    i1.e eVar = (i1.e) intent.getSerializableExtra("REG_ENTITY");
                    d.h("persist result, entity is " + eVar);
                    if (eVar != null) {
                        boolean z3 = eVar.f1706d;
                        Context context2 = pVar2.a;
                        AlarmManager alarmManager = pVar2.f1747c;
                        SharedPreferences sharedPreferences = pVar2.f1746b;
                        if (z3) {
                            sharedPreferences.edit().putString("sim_iccid", pVar2.e()).apply();
                            pVar2.f1753i = false;
                            pVar2.k = false;
                            pVar2.f1755l = false;
                            pVar2.f1760q = false;
                            sharedPreferences.edit().putInt("register_dds_slot", SubscriptionManager.getDefault().getDefaultDataSlotId()).apply();
                            sharedPreferences.edit().putString("register_sw_version", d.a(context2)).apply();
                            sharedPreferences.edit().putString("register_regtime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date())).apply();
                            Log.d("AutoReg_RegistrationTracker", "auto registration success");
                            Intent intent2 = new Intent("com.qualcomm.qti.action.AUTO_REGISTRATION_PERIOD_TRIGGER");
                            intent2.setPackage(context2.getPackageName());
                            intent2.addFlags(268435456);
                            PendingIntent broadcast = PendingIntent.getBroadcast(context2, 0, intent2, 603979776);
                            if (broadcast != null) {
                                alarmManager.cancel(broadcast);
                                Log.d("AutoReg_RegistrationTracker", "cancel the pending intent: ACTION_AUTO_REGISTRATION_PERIOD_TRIGGER");
                            }
                            Intent intent3 = new Intent("com.qualcomm.qti.action.AUTO_REGISTRATION_PERIOD_TRIGGER");
                            intent3.setPackage(context2.getPackageName());
                            intent3.addFlags(268435456);
                            PendingIntent broadcast2 = PendingIntent.getBroadcast(context2, 0, intent3, 67108864);
                            Log.d("AutoReg_RegistrationTracker", "reStartPeriodRegTimer");
                            pVar2.f1747c.setRepeating(0, System.currentTimeMillis() + 43200000, 43200000L, broadcast2);
                        } else if (!eVar.a) {
                            int i4 = sharedPreferences.getInt("register_request_count", 0) + 1;
                            sharedPreferences.edit().putInt("register_request_count", i4).apply();
                            if (i4 < 10) {
                                pVar2.a();
                                Log.d("AutoReg_RegistrationTracker", "last auto registration fail, schedule the " + i4 + " retry.");
                                Intent intent4 = new Intent("com.qualcomm.qti.action.AUTO_REGISTRATION_RETRY");
                                intent4.setPackage(context2.getPackageName());
                                intent4.addFlags(268435456);
                                alarmManager.set(0, System.currentTimeMillis() + 3600000, PendingIntent.getBroadcast(context2, 0, intent4, 67108864));
                            }
                        }
                    }
                    pVar2.f1751g = false;
                    return;
                }
                return;
            }
            if (action.equals("com.qualcomm.qti.action.AUTO_REGISTRATION_RETRY")) {
                Log.d("AutoReg_Receiver", "Action reschedule received...");
                p pVar3 = p.f1744u;
                if (pVar3 != null) {
                    pVar3.m(false);
                    return;
                }
                return;
            }
            if (action.equals("com.qualcomm.qti.action.AUTO_REGISTRATION_PERIOD_TRIGGER")) {
                Log.d("AutoReg_Receiver", "Action AUTO_REGISTRATION_PERIOD_TRIGGER received...");
                p pVar4 = p.f1744u;
                if (pVar4 != null) {
                    pVar4.b();
                    return;
                }
                return;
            }
            if (!action.equals("com.qualcomm.qti.action.SMS_AUTO_REGISTRATION")) {
                if (action.equals("android.intent.action.SIM_STATE_CHANGED") && f834b) {
                    String stringExtra = intent.getStringExtra("ss");
                    Log.d("AutoReg_Receiver", "simState change = " + stringExtra + ", phoneId = " + intent.getExtras().getInt("phone", 0));
                    if ("LOADED".equals(stringExtra) || "READY".equals(stringExtra) || "IMSI".equals(stringExtra) || "ABSENT".equals(stringExtra)) {
                        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("register_request_ims_count", 0).apply();
                        return;
                    }
                    return;
                }
                return;
            }
            Log.d("AutoReg_Receiver", "Action sms auto reg result received...");
            int i5 = intent.getExtras().getInt("phone", 0);
            if (d.g(context)) {
                t[] tVarArr = t.f1769i;
                t tVar = tVarArr[i5];
                if (tVar == null) {
                    throw new RuntimeException("Need setup firstly");
                }
                tVar.c();
                t tVar2 = tVarArr[i5];
                if (tVar2 == null) {
                    throw new RuntimeException("Need setup firstly");
                }
                Bundle extras = intent.getExtras();
                Objects.requireNonNull(extras);
                boolean z4 = extras.getBoolean("result", false);
                if (z4) {
                    Context context3 = tVar2.f1767d;
                    SharedPreferences sharedPreferences2 = tVar2.a;
                    int i6 = tVar2.f1766c;
                    d.i(context3, sharedPreferences2, "satellite_imsi", i6);
                    tVar2.d("persistResult mSlotId = " + i6);
                } else {
                    tVar2.a();
                }
                tVar2.d("SmsRegistrationOverSatellite persistResult " + z4);
                return;
            }
            j[] jVarArr = j.f1716v;
            j jVar = jVarArr[i5];
            if (jVar == null) {
                throw new RuntimeException("Need setup firstly");
            }
            jVar.c();
            j jVar2 = jVarArr[i5];
            if (jVar2 == null) {
                throw new RuntimeException("Need setup firstly");
            }
            jVar2.i("persistResult");
            SharedPreferences sharedPreferences3 = jVar2.a;
            String str2 = jVar2.f1731t;
            String string = sharedPreferences3.getString(str2, "");
            jVar2.i("persistResult - saved registration ID from SP: " + string);
            jVar2.i("persistResult - current in-memory registration ID: " + jVar2.f1730s);
            String str3 = jVar2.f1730s;
            if (str3 == null) {
                jVar2.i("persistResult: FATAL - In-memory registration ID is null. I did not initiate this registration. Ignoring.");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                jVar2.i("persistResult: Cleaning up stale/ghost ID from SP: " + string);
                sharedPreferences3.edit().remove(str2).apply();
                return;
            }
            if (!str3.equals(string)) {
                jVar2.i("persistResult: mismatch! Memory ID: " + jVar2.f1730s + " != SP ID: " + string);
                return;
            }
            if (!intent.getExtras().getBoolean("result", false)) {
                jVar2.f1730s = null;
                sharedPreferences3.edit().remove(str2).apply();
                jVar2.i("persistResult: registration failed, cleared registration ID and registering IMSI flag");
                jVar2.a();
                return;
            }
            Context context4 = jVar2.f1767d;
            int i7 = jVar2.f1766c;
            d.i(context4, sharedPreferences3, "lte_imsi", i7);
            sharedPreferences3.edit().putString(a.b("sms_auto_register_regtime", i7), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date())).apply();
            jVar2.i("persistResult mSlotId = " + i7 + ", getRegDate() = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date()));
            sharedPreferences3.edit().putBoolean(jVar2.f1718f, false).apply();
            jVar2.i("persistResult: cleared second slot trigger flag");
            jVar2.f1730s = null;
            sharedPreferences3.edit().remove(str2).apply();
            jVar2.i("persistResult: cleared registration ID and registering IMSI flag");
            PendingIntent broadcast3 = PendingIntent.getBroadcast(context4, 0, new Intent("miui.intent.action.SMS_AUTO_REGISTRATION_PERIOD_TRIGGER"), 603979776);
            if (broadcast3 != null) {
                jVar2.f1721i.cancel(broadcast3);
                jVar2.i("cancel the pending intent: ACTION_SMS_AUTO_REGISTRATION_PERIOD_TRIGGER");
            }
            Intent intent5 = new Intent("miui.intent.action.SMS_AUTO_REGISTRATION_PERIOD_TRIGGER");
            intent5.setPackage(context4.getPackageName());
            intent5.addFlags(268435456);
            PendingIntent broadcast4 = PendingIntent.getBroadcast(context4, 0, intent5, 67108864);
            jVar2.i("resetPeriodRegTimer currentTime = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(System.currentTimeMillis())));
            jVar2.f1721i.setRepeating(0, System.currentTimeMillis() + 43200000, 43200000L, broadcast4);
            jVar2.f1726o = false;
            jVar2.f1728q = false;
        }
    }
}
