package com.xiaomi.security.xsof.frauddetection.service;

import Qa.a;
import Qa.j;
import Qa.m;
import Ra.k;
import android.app.AppOpsManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.miui.common.utils.D;
import com.miui.common.utils.H;
import com.miui.common.utils.N0;
import com.miui.common.utils.w0;
import com.miui.maml.folme.AnimatedProperty;
import com.miui.networkassistant.config.Constants;
import com.xiaomi.security.xsof.frauddetection.service.MiFraudDetectionService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import miui.cloud.CloudPushConstants;
import miui.os.Build;
import p068eb.p;
import p068eb.q;
import p068eb.w;
import p149k8.E;
import p278tb.h;
import p278tb.n;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001c\u0010\u0003J\u0019\u0010\u001f\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\rH\u0016¢\u0006\u0004\b$\u0010\u0003R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\t0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00106\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u0004\u0018\u0001018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00103R\u0014\u00109\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u00103R\u0014\u0010;\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00103R\"\u0010@\u001a\u0010\u0012\f\u0012\n =*\u0004\u0018\u00010\t0\t0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0<8\u0006¢\u0006\f\n\u0004\b\u0018\u0010?\u001a\u0004\bA\u0010B¨\u0006D"}, d2 = {"Lcom/xiaomi/security/xsof/frauddetection/service/MiFraudDetectionService;", "Landroid/app/Service;", "<init>", "()V", "", "uid", "", "n", "(I)Z", "", "permission", "v", "(Ljava/lang/String;)I", "Leb/w;", "t", "m", "r", CloudPushConstants.WATERMARK_TYPE.SUBSCRIPTION, "o", "p", "q", AnimatedProperty.PROPERTY_NAME_W, "Landroid/content/Intent;", "intent", "j", "(Landroid/content/Intent;)V", "k", AnimatedProperty.PROPERTY_NAME_X, "onCreate", "Landroid/content/Context;", "context", CloudPushConstants.WATERMARK_TYPE.GLOBAL, "(Landroid/content/Context;)V", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "onDestroy", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "mUiHandler", "Landroid/os/HandlerThread;", "b", "Landroid/os/HandlerThread;", "mHandlerThread", "", "c", "Ljava/util/List;", "mIgnoreXsofScreenShareAppList", "Landroid/content/BroadcastReceiver;", "d", "Landroid/content/BroadcastReceiver;", "mScreenshotReceiver", "e", "mSimStateReceiver", "f", "mScNetworkStatusReceiver", "mAirplaneModeChangeReceiver", AnimatedProperty.PROPERTY_NAME_H, "mPhoneStateChangeReceiver", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "i", "Ljava/util/concurrent/atomic/AtomicReference;", "mCallState", "getInComingCallNumber", "()Ljava/util/concurrent/atomic/AtomicReference;", "inComingCallNumber", "core-service_cnRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMiFraudDetectionService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MiFraudDetectionService.kt\ncom/xiaomi/security/xsof/frauddetection/service/MiFraudDetectionService\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,461:1\n13402#2,2:462\n*S KotlinDebug\n*F\n+ 1 MiFraudDetectionService.kt\ncom/xiaomi/security/xsof/frauddetection/service/MiFraudDetectionService\n*L\n69#1:462,2\n*E\n"})
public final class MiFraudDetectionService extends Service {

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Handler mUiHandler;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private HandlerThread mHandlerThread;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List mIgnoreXsofScreenShareAppList = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final BroadcastReceiver mScreenshotReceiver;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final BroadcastReceiver mSimStateReceiver;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final BroadcastReceiver mScNetworkStatusReceiver;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final BroadcastReceiver mAirplaneModeChangeReceiver;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final BroadcastReceiver mPhoneStateChangeReceiver;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final AtomicReference mCallState;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final AtomicReference inComingCallNumber;

    /* JADX INFO: renamed from: com.xiaomi.security.xsof.frauddetection.service.MiFraudDetectionService$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(h hVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Qa.d b(Integer num, Boolean bool, long j10) {
            Qa.d dVar = new Qa.d(num, n.b(bool, Boolean.TRUE) ? 1 : 0, j10);
            dVar.i(j10);
            return dVar;
        }

        private Companion() {
        }
    }

    public static final class b extends BroadcastReceiver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(MiFraudDetectionService miFraudDetectionService) {
            if (Settings.Global.getInt(miFraudDetectionService.getContentResolver(), "airplane_mode_on", 0) == 1) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                a aVar = new a(true, jCurrentTimeMillis);
                aVar.g(jCurrentTimeMillis);
                k.f8517c.a().U0(aVar);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            n.f(intent, "intent");
            try {
                if (n.b("android.intent.action.AIRPLANE_MODE", intent.getAction())) {
                    Wa.b.a("MiFraudDetectionService", "receive AirplaneModeChange");
                    E eF = E.f();
                    final MiFraudDetectionService miFraudDetectionService = MiFraudDetectionService.this;
                    eF.c(new Runnable() { // from class: Sa.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            MiFraudDetectionService.b.b(miFraudDetectionService);
                        }
                    });
                }
            } catch (Exception e10) {
                Wa.b.b("MiFraudDetectionService", "mAirplaneModeChangeReceiver onReceive Exception: " + e10);
            }
        }
    }

    public static final class c extends BroadcastReceiver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(MiFraudDetectionService miFraudDetectionService, Intent intent) {
            miFraudDetectionService.j(intent);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            n.f(context, "context");
            n.f(intent, "intent");
            try {
                Wa.b.a("MiFraudDetectionService", "receive phoneStateChange");
                if (!Build.IS_INTERNATIONAL_BUILD && ((TelephonyManager) context.getSystemService(TelephonyManager.class)).isVoiceCapable() && n.b("android.intent.action.PHONE_STATE", intent.getAction())) {
                    E eF = E.f();
                    final MiFraudDetectionService miFraudDetectionService = MiFraudDetectionService.this;
                    eF.c(new Runnable() { // from class: Sa.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            MiFraudDetectionService.c.b(miFraudDetectionService, intent);
                        }
                    });
                }
            } catch (Exception e10) {
                Wa.b.b("MiFraudDetectionService", "mPhoneStateChangeReceiver onReceive Exception: " + e10);
            }
        }
    }

    public static final class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            n.f(context, "context");
            n.f(intent, "intent");
            try {
                boolean booleanExtra = intent.getBooleanExtra("extra_network_status", false);
                Wa.b.a("MiFraudDetectionService", "mScNetworkStatusReceiver : " + booleanExtra);
                if (booleanExtra) {
                    MiFraudDetectionService.this.g(com.miui.common.e.c());
                }
            } catch (Exception e10) {
                Wa.b.b("MiFraudDetectionService", "mScNetworkStatusReceiver error: " + e10.getMessage());
            }
        }
    }

    public static final class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            n.f(intent, "intent");
            if (n.b("miui.intent.TAKE_SCREENSHOT", intent.getAction())) {
                MiFraudDetectionService.this.k(intent);
            }
        }
    }

    public static final class f extends BroadcastReceiver {
        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            n.f(context, "context");
            n.f(intent, "intent");
            try {
                String stringExtra = intent.hasExtra("ss") ? intent.getStringExtra("ss") : "";
                Wa.b.a("MiFraudDetectionService", "mSimStateReceiver : " + stringExtra);
                if (n.b("LOADED", stringExtra)) {
                    MiFraudDetectionService.this.g(com.miui.common.e.c());
                } else {
                    if (!n.b("ABSENT", stringExtra) || intent.getExtras() == null) {
                        return;
                    }
                    Ta.d.f9144a.m(context, 0);
                }
            } catch (Exception e10) {
                Wa.b.b("MiFraudDetectionService", "mSimStateReceiver error: " + e10.getMessage());
            }
        }
    }

    public MiFraudDetectionService() {
        try {
            p.a aVar = p.f38907b;
            String[] stringArray = com.miui.common.e.c().getResources().getStringArray(p026bb.a.f17805a);
            n.e(stringArray, "getStringArray(...)");
            for (String str : stringArray) {
                List list = this.mIgnoreXsofScreenShareAppList;
                n.c(str);
                list.add(str);
            }
            p.b(w.f38919a);
        } catch (Throwable th) {
            p.a aVar2 = p.f38907b;
            p.b(q.a(th));
        }
        this.mScreenshotReceiver = new e();
        this.mSimStateReceiver = new f();
        this.mScNetworkStatusReceiver = new d();
        this.mAirplaneModeChangeReceiver = new b();
        this.mPhoneStateChangeReceiver = new c();
        this.mCallState = new AtomicReference("");
        this.inComingCallNumber = new AtomicReference();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object h(Context context, Object obj, Method method, Object[] objArr) throws Throwable {
        int i10 = 0;
        if (!n.b(method != null ? method.getName() : null, "onCallForwardingInfoAvailable")) {
            if (n.b(method != null ? method.getName() : null, "onError")) {
                Wa.b.b("MiFraudDetectionService", "onError: ");
                if (objArr != null && objArr.length > 0) {
                    Wa.b.b("MiFraudDetectionService", "onError: " + objArr[0]);
                }
            }
            return null;
        }
        Wa.b.c("MiFraudDetectionService", "onCallForwardingInfoAvailable: ");
        if (objArr != null && objArr.length > 0) {
            Object obj2 = objArr[0];
            Wa.b.a("MiFraudDetectionService", "onCallForwardingInfoAvailable: " + obj2 + ", infoClass=" + obj2.getClass());
            try {
                Integer num = (Integer) p206o9.e.b(obj2, Integer.TYPE, "getReason", null, new Object[0]);
                Boolean bool = (Boolean) p206o9.e.b(obj2, Boolean.TYPE, "isEnabled", null, new Object[0]);
                final Qa.d dVarB = INSTANCE.b(num, bool, System.currentTimeMillis());
                Ta.d.a aVar = Ta.d.f9144a;
                Qa.d dVarE = aVar.e();
                Wa.b.a("MiFraudDetectionService", "onReceive , info=" + dVarB + ", latestCallForwardingInfo=" + dVarE);
                if (n.b(bool, Boolean.TRUE) && num != null && num.intValue() == 0) {
                    i10 = 1;
                }
                aVar.m(context, i10);
                if (dVarE == null || !dVarE.e(dVarB)) {
                    Wa.b.a("MiFraudDetectionService", "checkCallForwarding: equals = false");
                    E.f().c(new Runnable() { // from class: Sa.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            MiFraudDetectionService.i(dVarB);
                        }
                    });
                } else {
                    Wa.b.a("MiFraudDetectionService", "checkCallForwarding: equals = true");
                }
            } catch (Exception e10) {
                Wa.b.b("MiFraudDetectionService", "Exception: " + e10);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Qa.d dVar) {
        k.f8517c.a().Y0(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("state");
            String stringExtra2 = intent.getStringExtra("incoming_number");
            if (n.b(this.mCallState.get(), stringExtra)) {
                return;
            }
            if (stringExtra2 == null) {
                Wa.b.b("MiFraudDetectionService", "handlePhoneStateChange number is null");
                return;
            }
            this.mCallState.set(stringExtra);
            if (n.b(TelephonyManager.EXTRA_STATE_RINGING, stringExtra)) {
                if (TextUtils.isEmpty(stringExtra2)) {
                    return;
                }
                this.inComingCallNumber.set(null);
                return;
            }
            if (!n.b(TelephonyManager.EXTRA_STATE_OFFHOOK, stringExtra)) {
                if (n.b(TelephonyManager.EXTRA_STATE_IDLE, stringExtra)) {
                    k kVarA = k.f8517c.a();
                    String strD = Wa.a.d((String) this.inComingCallNumber.get());
                    n.e(strD, "getMD5String(...)");
                    kVarA.a2(strD);
                    this.inComingCallNumber.set(null);
                    return;
                }
                return;
            }
            this.inComingCallNumber.set(stringExtra2);
            String str = (String) this.inComingCallNumber.get();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Ta.d.a aVar = Ta.d.f9144a;
            n.c(str);
            boolean zK = aVar.k(this, str);
            Wa.b.a("MiFraudDetectionService", "handlePhoneStateChange isSimCardFraudCall: " + zK);
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strD2 = Wa.a.d(str);
            n.e(strD2, "getMD5String(...)");
            k.f8517c.a().f1(new m(strD2, jCurrentTimeMillis, 0L, aVar.h(this, str), aVar.i(this, str), aVar.j(str), aVar.l(this, str), true, 0L, zK));
        } catch (Exception e10) {
            Wa.b.b("MiFraudDetectionService", "handlePhoneStateChange error: " + e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Intent intent) {
        Wa.b.a("MiFraudDetectionService", "handleScreenShot:");
        try {
            boolean booleanExtra = intent.getBooleanExtra("IsFinished", false);
            Wa.b.a("MiFraudDetectionService", "handleScreenShot: mIsScreenShotFinish = " + booleanExtra);
            if (booleanExtra) {
                E.f().c(new Runnable() { // from class: Sa.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiFraudDetectionService.l();
                    }
                });
            }
        } catch (Exception e10) {
            Wa.b.b("MiFraudDetectionService", "handleScreenShot error: " + e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Qa.k kVar = new Qa.k(jCurrentTimeMillis);
        kVar.f(jCurrentTimeMillis);
        k.f8517c.a().d1(kVar);
    }

    private final void m() {
        this.mUiHandler = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("fraud_detection_handler_thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
    }

    private final boolean n(int uid) {
        return N0.G() == N0.o(uid) || (N0.o(uid) == 999 && N0.w());
    }

    private final void o() {
        D.o(this, this.mAirplaneModeChangeReceiver, new IntentFilter("android.intent.action.AIRPLANE_MODE"), 2);
    }

    private final void p() {
        D.o(this, this.mPhoneStateChangeReceiver, new IntentFilter("android.intent.action.PHONE_STATE"), 2);
    }

    private final void q() {
        if (this.mScNetworkStatusReceiver == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_update_sc_network_allow");
        D.o(this, this.mScNetworkStatusReceiver, intentFilter, 4);
    }

    private final void r() {
        D.p(this, this.mScreenshotReceiver, new IntentFilter("miui.intent.TAKE_SCREENSHOT"), "miui.permission.USE_INTERNAL_GENERAL_API", this.mUiHandler, 2);
    }

    private final void s() {
        D.o(this, this.mSimStateReceiver, new IntentFilter(Constants.System.ACTION_SIM_STATE_CHANGED), 2);
    }

    private final void t() {
        try {
            p.a aVar = p.f38907b;
            Object systemService = getApplicationContext().getSystemService("appops");
            n.d(systemService, "null cannot be cast to non-null type android.app.AppOpsManager");
            AppOpsManager appOpsManager = (AppOpsManager) systemService;
            String[] strArr = {"MIUI:10042"};
            if (android.os.Build.VERSION.SDK_INT >= 30) {
                appOpsManager.startWatchingActive(strArr, Executors.newSingleThreadExecutor(), new AppOpsManager.OnOpActiveChangedListener() { // from class: Sa.b
                    @Override // android.app.AppOpsManager.OnOpActiveChangedListener
                    public final void onOpActiveChanged(String str, int i10, String str2, boolean z10) {
                        MiFraudDetectionService.u(this.f8735a, str, i10, str2, z10);
                    }
                });
            }
            p.b(w.f38919a);
        } catch (Throwable th) {
            p.a aVar2 = p.f38907b;
            p.b(q.a(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(MiFraudDetectionService miFraudDetectionService, String str, int i10, String str2, boolean z10) {
        n.f(str, "op");
        n.f(str2, "packageName");
        Wa.b.c("MiFraudDetectionService", "startWatchingPrivacyUse op: " + str + ", uid: " + i10 + ", packageName: " + str2 + ", active: " + z10);
        if (miFraudDetectionService.n(i10) && miFraudDetectionService.v(str) == 10042 && !miFraudDetectionService.mIgnoreXsofScreenShareAppList.contains(str2)) {
            if (z10) {
                k.f8517c.a().b1(new j(str2, System.currentTimeMillis(), 0L, 0L, true));
            } else {
                k.f8517c.a().Y1(new j(str2, 0L, System.currentTimeMillis(), 0L, false));
            }
        }
    }

    private final int v(String permission) {
        Object objB;
        try {
            p.a aVar = p.f38907b;
            Object objH = p206o9.e.h(AppOpsManager.class, "strOpToOp", new Class[]{String.class}, permission);
            n.d(objH, "null cannot be cast to non-null type kotlin.Int");
            Integer num = (Integer) objH;
            num.intValue();
            objB = p.b(num);
        } catch (Throwable th) {
            p.a aVar2 = p.f38907b;
            objB = p.b(q.a(th));
        }
        if (p.f(objB)) {
            objB = -1;
        }
        return ((Number) objB).intValue();
    }

    private final void w() {
        try {
            BroadcastReceiver broadcastReceiver = this.mScNetworkStatusReceiver;
            if (broadcastReceiver == null) {
                return;
            }
            unregisterReceiver(broadcastReceiver);
        } catch (Exception e10) {
            Wa.b.b("MiFraudDetectionService", "unRegisterScNetworkStatusReceiver error: " + e10.getMessage());
        }
    }

    private final void x() {
        try {
            unregisterReceiver(this.mScreenshotReceiver);
            unregisterReceiver(this.mSimStateReceiver);
            unregisterReceiver(this.mAirplaneModeChangeReceiver);
            unregisterReceiver(this.mPhoneStateChangeReceiver);
            Ta.e.f9145a.d(this);
            w();
        } catch (Exception e10) {
            Wa.b.b("MiFraudDetectionService", "unregisterReceiver error: " + e10);
        }
    }

    public final void g(final Context context) {
        if (!w0.b()) {
            Wa.b.a("MiFraudDetectionService", "checkCallForwarding return, case cta is fail");
            return;
        }
        SubscriptionManager subscriptionManager = (SubscriptionManager) getSystemService(SubscriptionManager.class);
        if (subscriptionManager != null) {
            List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
            Wa.b.a("MiFraudDetectionService", "checkCallForwarding: subscriptionManager.activeSubscriptionInfoList " + (activeSubscriptionInfoList != null ? Integer.valueOf(activeSubscriptionInfoList.size()) : null));
            List<SubscriptionInfo> activeSubscriptionInfoList2 = subscriptionManager.getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList2 == null || !(!activeSubscriptionInfoList2.isEmpty()) || context == null) {
                return;
            }
            try {
                Class<?> cls = Class.forName("android.telephony.TelephonyManager$CallForwardingInfoCallback");
                TelephonyManager.class.getDeclaredMethod("getCallForwarding", Integer.TYPE, Executor.class, cls).invoke(context.getSystemService(TelephonyManager.class), 0, Executors.newSingleThreadExecutor(), Proxy.newProxyInstance(getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: Sa.c
                    @Override // java.lang.reflect.InvocationHandler
                    public final Object invoke(Object obj, Method method, Object[] objArr) {
                        return MiFraudDetectionService.h(context, obj, method, objArr);
                    }
                }));
            } catch (Exception e10) {
                Wa.b.b("MiFraudDetectionService", "getCallForwarding error: " + e10);
                w wVar = w.f38919a;
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        m();
        r();
        s();
        o();
        p();
        Ta.e.f9145a.c(this);
        q();
        g(com.miui.common.e.c());
        if (H.k()) {
            t();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        HandlerThread handlerThread;
        super.onDestroy();
        x();
        HandlerThread handlerThread2 = this.mHandlerThread;
        if (handlerThread2 != null && handlerThread2.isAlive() && (handlerThread = this.mHandlerThread) != null) {
            handlerThread.quitSafely();
        }
        Wa.b.c("MiFraudDetectionService", "onDestroy: ...");
    }
}
