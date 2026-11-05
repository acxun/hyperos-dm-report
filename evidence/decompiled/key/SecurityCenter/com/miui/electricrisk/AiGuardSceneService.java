package com.miui.electricrisk;

import Fb.AbstractC0698k;
import Fb.AbstractC0716t0;
import Fb.C0687e0;
import Fb.K;
import Fb.O;
import Fb.P;
import Fb.U0;
import Fb.Z;
import Ib.AbstractC0883h;
import Ib.InterfaceC0881f;
import Ib.InterfaceC0882g;
import android.app.ActivityManager;
import android.app.IMiuiProcessObserver;
import android.app.IProcessObserver;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.AudioManager$OnModeChangedListener;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.miui.common.utils.N0;
import com.miui.luckymoney.config.AppConstants;
import com.miui.maml.folme.AnimatedProperty;
import com.miui.networkassistant.vpn.miui.ActivityManagerCompat;
import com.xiaomi.onetrack.api.am;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import miui.cloud.CloudPushConstants;
import miui.yellowpage.YellowPageUtils;
import p096gb.AbstractC1948o;
import p239r0.AbstractC2143j;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(33)
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u0015\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0015H\u0002¢\u0006\u0004\b$\u0010#J\u000f\u0010%\u001a\u00020\u000bH\u0002¢\u0006\u0004\b%\u0010\u0003J#\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001d0(2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0&H\u0002¢\u0006\u0004\b)\u0010*J#\u0010,\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\t0+0(H\u0002¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0(H\u0002¢\u0006\u0004\b.\u0010-J\u0094\u0002\u0010:\u001a\u00020\u000b21\u00105\u001a-\b\u0001\u0012\u0013\u0012\u00110\t¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b03\u0012\u0006\u0012\u0004\u0018\u0001040/21\u00106\u001a-\b\u0001\u0012\u0013\u0012\u00110\t¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b03\u0012\u0006\u0012\u0004\u0018\u0001040/21\u00107\u001a-\b\u0001\u0012\u0013\u0012\u00110\t¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b03\u0012\u0006\u0012\u0004\u0018\u0001040/23\u00108\u001a/\b\u0001\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b03\u0012\u0006\u0012\u0004\u0018\u0001040/25\b\u0002\u00109\u001a/\b\u0001\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b03\u0012\u0006\u0012\u0004\u0018\u0001040/H\u0002¢\u0006\u0004\b:\u0010;J=\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020?0+0(2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\t0<2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0<H\u0002¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\bB\u0010\u0017J\u0017\u0010D\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u001dH\u0002¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0015H\u0002¢\u0006\u0004\bF\u0010#J\u000f\u0010G\u001a\u00020\u000bH\u0002¢\u0006\u0004\bG\u0010\u0003R\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010M\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010:R\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010.R\u0014\u0010`\u001a\u00020\\8\u0002X\u0082D¢\u0006\u0006\n\u0004\b_\u0010.R\u0014\u0010c\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010:¨\u0006f"}, d2 = {"Lcom/miui/electricrisk/AiGuardSceneService;", "Landroid/app/Service;", "<init>", "()V", "Ljava/io/FileDescriptor;", "fd", "Ljava/io/PrintWriter;", "writer", "", "", "args", "Leb/w;", "dump", "(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "onCreate", "phoneNumber", "", AnimatedProperty.PROPERTY_NAME_X, "(Ljava/lang/String;)Z", "z", "onDestroy", "packageName", am.f36872b, "(Ljava/lang/String;)V", "", "u", "()I", "F", "G", AnimatedProperty.PROPERTY_NAME_W, "()Z", "C", "D", "Ljava/util/concurrent/atomic/AtomicReference;", "pkgRef", "LIb/f;", "K", "(Ljava/util/concurrent/atomic/AtomicReference;)LIb/f;", "Leb/o;", "t", "()LIb/f;", "J", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "who", "Ljb/f;", "", "onEstablished", "onTopResumed", "onPaused", "onDisconnected", "onAlerted", "I", "(Lsb/p;Lsb/p;Lsb/p;Lsb/p;Lsb/p;)V", "", "packages", "activities", "Landroid/content/ComponentName;", am.f36871a, "(Ljava/util/List;Ljava/util/List;)LIb/f;", AnimatedProperty.PROPERTY_NAME_Y, "command", "v", "(I)Landroid/content/Intent;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ExifInterface.LONGITUDE_EAST, "LFb/O;", "a", "LFb/O;", "scope", "b", "userId", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "workerStarted", "d", "Ljava/lang/String;", "currentVoipPackageName", "e", "Landroid/content/Intent;", "lastWorkerIntent", "Landroid/app/IProcessObserver;", "f", "Landroid/app/IProcessObserver;", "processObserver", "", CloudPushConstants.WATERMARK_TYPE.GLOBAL, "lastRestartTime", AnimatedProperty.PROPERTY_NAME_H, "restartDebounceMs", "i", "Ljava/lang/Object;", "restartLock", "j", "guardProviderUid", "app_cnPhoneRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiGuardSceneService extends Service {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String currentVoipPackageName;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Intent lastWorkerIntent;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IProcessObserver processObserver;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long lastRestartTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final O scope = P.a(C0687e0.a().A(U0.b(null, 1, null)));

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int userId = N0.G();

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean workerStarted = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long restartDebounceMs = 5000;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Object restartLock = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int guardProviderUid = -1;

    static final class a extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f24908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TelephonyManager f24909c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AiGuardSceneService f24910d;

        /* JADX INFO: renamed from: com.miui.electricrisk.AiGuardSceneService$a$a, reason: collision with other inner class name */
        public static final class C0341a extends PhoneStateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AiGuardSceneService f24911a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Hb.t f24912b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0341a(AiGuardSceneService aiGuardSceneService, Hb.t tVar, Executor executor) {
                super(executor);
                this.f24911a = aiGuardSceneService;
                this.f24912b = tVar;
            }

            @Override // android.telephony.PhoneStateListener
            public void onCallStateChanged(int i10, String str) {
                if (this.f24911a.A()) {
                    return;
                }
                this.f24912b.a(p068eb.t.a(Integer.valueOf(i10), str));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(TelephonyManager telephonyManager, AiGuardSceneService aiGuardSceneService, p138jb.f fVar) {
            super(2, fVar);
            this.f24909c = telephonyManager;
            this.f24910d = aiGuardSceneService;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final p068eb.w m(TelephonyManager telephonyManager, C0341a c0341a) {
            telephonyManager.listen(c0341a, 0);
            return p068eb.w.f38919a;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final p138jb.f create(Object obj, p138jb.f fVar) {
            a aVar = new a(this.f24909c, this.f24910d, fVar);
            aVar.f24908b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = p152kb.b.e();
            int i10 = this.f24907a;
            if (i10 == 0) {
                p068eb.q.b(obj);
                Hb.t tVar = (Hb.t) this.f24908b;
                jb.j.b bVarI = tVar.getCoroutineContext().i(K.f2099b);
                p278tb.n.c(bVarI);
                final C0341a c0341a = new C0341a(this.f24910d, tVar, AbstractC0716t0.a((K) bVarI));
                this.f24909c.listen(c0341a, 32);
                final TelephonyManager telephonyManager = this.f24909c;
                p264sb.a aVar = new p264sb.a() { // from class: com.miui.electricrisk.d
                    @Override // p264sb.a
                    public final Object invoke() {
                        return AiGuardSceneService.a.m(telephonyManager, c0341a);
                    }
                };
                this.f24907a = 1;
                if (Hb.r.a(tVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p068eb.q.b(obj);
            }
            return p068eb.w.f38919a;
        }

        @Override // p264sb.p
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Hb.t tVar, p138jb.f fVar) {
            return ((a) create(tVar, fVar)).invokeSuspend(p068eb.w.f38919a);
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24913a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f24915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ p278tb.z f24916d;

        static final class a implements InterfaceC0882g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AiGuardSceneService f24917a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f24918b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ p278tb.z f24919c;

            /* JADX INFO: renamed from: com.miui.electricrisk.AiGuardSceneService$b$a$a, reason: collision with other inner class name */
            static final class C0342a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                Object f24920a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                int f24921b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                /* synthetic */ Object f24922c;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f24924e;

                C0342a(p138jb.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.f24922c = obj;
                    this.f24924e |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            a(AiGuardSceneService aiGuardSceneService, int i10, p278tb.z zVar) {
                this.f24917a = aiGuardSceneService;
                this.f24918b = i10;
                this.f24919c = zVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // Ib.InterfaceC0882g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(p068eb.o oVar, p138jb.f fVar) {
                C0342a c0342a;
                int iIntValue;
                a aVar;
                int i10;
                if (fVar instanceof C0342a) {
                    c0342a = (C0342a) fVar;
                    int i11 = c0342a.f24924e;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        c0342a.f24924e = i11 - Integer.MIN_VALUE;
                    } else {
                        c0342a = new C0342a(fVar);
                    }
                } else {
                    c0342a = new C0342a(fVar);
                }
                Object obj = c0342a.f24922c;
                Object objE = p152kb.b.e();
                int i12 = c0342a.f24924e;
                if (i12 == 0) {
                    p068eb.q.b(obj);
                    iIntValue = ((Number) oVar.a()).intValue();
                    String str = (String) oVar.b();
                    if (iIntValue == 0) {
                        if (this.f24919c.f48418a == 2) {
                            c0342a.f24920a = this;
                            c0342a.f24921b = iIntValue;
                            c0342a.f24924e = 1;
                            if (Z.a(500L, c0342a) == objE) {
                                return objE;
                            }
                            aVar = this;
                            i10 = iIntValue;
                        }
                        aVar.f24919c.f48418a = iIntValue;
                        return p068eb.w.f38919a;
                    }
                    if (iIntValue == 2 && str != null && this.f24917a.y(str)) {
                        Intent intentPutExtra = this.f24917a.v(1).putExtra("PHONE_SCAM_SCENE", 2).putExtra("CAPABILITIES", this.f24918b);
                        p278tb.n.e(intentPutExtra, "putExtra(...)");
                        this.f24917a.startForegroundService(intentPutExtra);
                        this.f24917a.lastWorkerIntent = intentPutExtra;
                        this.f24917a.workerStarted.set(true);
                        this.f24917a.F();
                        Log.i("AiGuardDaemon", "Phone scam detection is starting.");
                    }
                    aVar = this;
                    aVar.f24919c.f48418a = iIntValue;
                    return p068eb.w.f38919a;
                }
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i10 = c0342a.f24921b;
                aVar = (a) c0342a.f24920a;
                p068eb.q.b(obj);
                aVar.f24917a.D();
                aVar.f24917a.workerStarted.set(false);
                iIntValue = i10;
                aVar.f24919c.f48418a = iIntValue;
                return p068eb.w.f38919a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i10, p278tb.z zVar, p138jb.f fVar) {
            super(2, fVar);
            this.f24915c = i10;
            this.f24916d = zVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final p138jb.f create(Object obj, p138jb.f fVar) {
            return AiGuardSceneService.this.new b(this.f24915c, this.f24916d, fVar);
        }

        @Override // p264sb.p
        public final Object invoke(O o10, p138jb.f fVar) {
            return ((b) create(o10, fVar)).invokeSuspend(p068eb.w.f38919a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = p152kb.b.e();
            int i10 = this.f24913a;
            if (i10 == 0) {
                p068eb.q.b(obj);
                InterfaceC0881f interfaceC0881fT = AiGuardSceneService.this.t();
                a aVar = new a(AiGuardSceneService.this, this.f24915c, this.f24916d);
                this.f24913a = 1;
                if (interfaceC0881fT.collect(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p068eb.q.b(obj);
            }
            return p068eb.w.f38919a;
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24926b;

        c(p138jb.f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final p138jb.f create(Object obj, p138jb.f fVar) {
            c cVar = new c(fVar);
            cVar.f24926b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            p152kb.b.e();
            if (this.f24925a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p068eb.q.b(obj);
            String str = (String) this.f24926b;
            Log.i("AiGuardDaemon", "Established: " + str + ".");
            Ra.k.f8517c.a().j1(new Qa.n(str, System.currentTimeMillis(), 0L, 0L, true, false));
            return p068eb.w.f38919a;
        }

        @Override // p264sb.p
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, p138jb.f fVar) {
            return ((c) create(str, fVar)).invokeSuspend(p068eb.w.f38919a);
        }
    }

    static final class d extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f24929c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AiGuardSceneService f24930d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i10, AiGuardSceneService aiGuardSceneService, p138jb.f fVar) {
            super(2, fVar);
            this.f24929c = i10;
            this.f24930d = aiGuardSceneService;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final p138jb.f create(Object obj, p138jb.f fVar) {
            d dVar = new d(this.f24929c, this.f24930d, fVar);
            dVar.f24928b = obj;
            return dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            int[] iArr;
            p152kb.b.e();
            if (this.f24927a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p068eb.q.b(obj);
            String str = (String) this.f24928b;
            Log.i("AiGuardDaemon", "VoIP scam detection is starting.");
            if (p278tb.n.b(str, AppConstants.Package.PACKAGE_NAME_QQ)) {
                iArr = new int[]{3, 1};
            } else {
                if (!p278tb.n.b(str, AppConstants.Package.PACKAGE_NAME_MM)) {
                    Log.e("AiGuardDaemon", "Activity missing:" + str);
                    return p068eb.w.f38919a;
                }
                iArr = new int[]{4, 2};
            }
            int i10 = iArr[0];
            int i11 = iArr[1];
            if ((this.f24929c & 1) != 0) {
                Intent intentPutExtra = this.f24930d.v(1).putExtra("PHONE_SCAM_SCENE", i10).putExtra("CAPABILITIES", this.f24929c);
                p278tb.n.e(intentPutExtra, "putExtra(...)");
                this.f24930d.startForegroundService(intentPutExtra);
                this.f24930d.lastWorkerIntent = intentPutExtra;
                this.f24930d.workerStarted.set(true);
                this.f24930d.F();
            }
            boolean zIsUsingCamera = AiGuardUtils.isUsingCamera(this.f24930d, str);
            if ((this.f24929c & 2) != 0 && zIsUsingCamera) {
                Intent intentPutExtra2 = this.f24930d.v(2).putExtra("VIDEO_SCAM_SCENE", i11).putExtra("CAPABILITIES", this.f24929c);
                p278tb.n.e(intentPutExtra2, "putExtra(...)");
                this.f24930d.startForegroundService(intentPutExtra2);
                this.f24930d.lastWorkerIntent = intentPutExtra2;
                this.f24930d.workerStarted.set(true);
                this.f24930d.F();
            }
            return p068eb.w.f38919a;
        }

        @Override // p264sb.p
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, p138jb.f fVar) {
            return ((d) create(str, fVar)).invokeSuspend(p068eb.w.f38919a);
        }
    }

    static final class e extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24931a;

        e(p138jb.f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final p138jb.f create(Object obj, p138jb.f fVar) {
            return AiGuardSceneService.this.new e(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = p152kb.b.e();
            int i10 = this.f24931a;
            if (i10 == 0) {
                p068eb.q.b(obj);
                if (AiGuardSceneService.this.workerStarted.get()) {
                    this.f24931a = 1;
                    if (Z.a(500L, this) == objE) {
                        return objE;
                    }
                }
                Log.i("AiGuardDaemon", "Paused.");
                return p068eb.w.f38919a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p068eb.q.b(obj);
            AiGuardSceneService.this.D();
            AiGuardSceneService.this.workerStarted.set(false);
            Log.i("AiGuardDaemon", "Paused.");
            return p068eb.w.f38919a;
        }

        @Override // p264sb.p
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, p138jb.f fVar) {
            return ((e) create(str, fVar)).invokeSuspend(p068eb.w.f38919a);
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24934b;

        f(p138jb.f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final p138jb.f create(Object obj, p138jb.f fVar) {
            f fVar2 = AiGuardSceneService.this.new f(fVar);
            fVar2.f24934b = obj;
            return fVar2;
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0055  */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            String str;
            String str2;
            Object objE = p152kb.b.e();
            int i10 = this.f24933a;
            if (i10 == 0) {
                p068eb.q.b(obj);
                str = (String) this.f24934b;
                if (AiGuardSceneService.this.workerStarted.get()) {
                    this.f24934b = str;
                    this.f24933a = 1;
                    if (Z.a(500L, this) == objE) {
                        return objE;
                    }
                    str2 = str;
                }
                Log.i("AiGuardDaemon", "Stopped.");
                if (str != null) {
                    AiGuardSceneService.this.H(str);
                }
                return p068eb.w.f38919a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) this.f24934b;
            p068eb.q.b(obj);
            AiGuardSceneService.this.D();
            AiGuardSceneService.this.workerStarted.set(false);
            str = str2;
            Log.i("AiGuardDaemon", "Stopped.");
            if (str != null) {
                AiGuardSceneService.this.H(str);
            }
            return p068eb.w.f38919a;
        }

        @Override // p264sb.p
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, p138jb.f fVar) {
            return ((f) create(str, fVar)).invokeSuspend(p068eb.w.f38919a);
        }
    }

    static final class g extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24937b;

        g(p138jb.f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final p138jb.f create(Object obj, p138jb.f fVar) {
            g gVar = new g(fVar);
            gVar.f24937b = obj;
            return gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            p152kb.b.e();
            if (this.f24936a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p068eb.q.b(obj);
            String str = (String) this.f24937b;
            Log.i("AiGuardDaemon", "Alerted. " + str);
            if (str != null) {
                Ra.k.f8517c.a().c2(new Qa.n(str, 0L, System.currentTimeMillis(), 0L, true, true), Qa.p.TYPE_CHECK_IS_FRAUD_CALL);
            }
            return p068eb.w.f38919a;
        }

        @Override // p264sb.p
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, p138jb.f fVar) {
            return ((g) create(str, fVar)).invokeSuspend(p068eb.w.f38919a);
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24938a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicReference f24940c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ p264sb.p f24941d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ p278tb.y f24942e;

        static final class a implements InterfaceC0882g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ p264sb.p f24943a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AtomicReference f24944b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ AiGuardSceneService f24945c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ p278tb.y f24946d;

            /* JADX INFO: renamed from: com.miui.electricrisk.AiGuardSceneService$h$a$a, reason: collision with other inner class name */
            static final class C0343a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                Object f24947a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                /* synthetic */ Object f24948b;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                int f24950d;

                C0343a(p138jb.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.f24948b = obj;
                    this.f24950d |= Integer.MIN_VALUE;
                    return a.this.a(0, this);
                }
            }

            a(p264sb.p pVar, AtomicReference atomicReference, AiGuardSceneService aiGuardSceneService, p278tb.y yVar) {
                this.f24943a = pVar;
                this.f24944b = atomicReference;
                this.f24945c = aiGuardSceneService;
                this.f24946d = yVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            public final Object a(int i10, p138jb.f fVar) {
                C0343a c0343a;
                a aVar;
                if (fVar instanceof C0343a) {
                    c0343a = (C0343a) fVar;
                    int i11 = c0343a.f24950d;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        c0343a.f24950d = i11 - Integer.MIN_VALUE;
                    } else {
                        c0343a = new C0343a(fVar);
                    }
                } else {
                    c0343a = new C0343a(fVar);
                }
                Object obj = c0343a.f24948b;
                Object objE = p152kb.b.e();
                int i12 = c0343a.f24950d;
                if (i12 == 0) {
                    p068eb.q.b(obj);
                    p264sb.p pVar = this.f24943a;
                    Object obj2 = this.f24944b.get();
                    c0343a.f24947a = this;
                    c0343a.f24950d = 1;
                    if (pVar.invoke(obj2, c0343a) == objE) {
                        return objE;
                    }
                    aVar = this;
                } else {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar = (a) c0343a.f24947a;
                    p068eb.q.b(obj);
                }
                aVar.f24944b.set(null);
                aVar.f24945c.currentVoipPackageName = "";
                aVar.f24946d.f48417a = false;
                return p068eb.w.f38919a;
            }

            @Override // Ib.InterfaceC0882g
            public /* bridge */ /* synthetic */ Object emit(Object obj, p138jb.f fVar) {
                return a(((Number) obj).intValue(), fVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(AtomicReference atomicReference, p264sb.p pVar, p278tb.y yVar, p138jb.f fVar) {
            super(2, fVar);
            this.f24940c = atomicReference;
            this.f24941d = pVar;
            this.f24942e = yVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final p138jb.f create(Object obj, p138jb.f fVar) {
            return AiGuardSceneService.this.new h(this.f24940c, this.f24941d, this.f24942e, fVar);
        }

        @Override // p264sb.p
        public final Object invoke(O o10, p138jb.f fVar) {
            return ((h) create(o10, fVar)).invokeSuspend(p068eb.w.f38919a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = p152kb.b.e();
            int i10 = this.f24938a;
            if (i10 == 0) {
                p068eb.q.b(obj);
                InterfaceC0881f interfaceC0881fK = AiGuardSceneService.this.K(this.f24940c);
                a aVar = new a(this.f24941d, this.f24940c, AiGuardSceneService.this, this.f24942e);
                this.f24938a = 1;
                if (interfaceC0881fK.collect(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p068eb.q.b(obj);
            }
            return p068eb.w.f38919a;
        }
    }

    static final class i extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterfaceC0881f f24952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ p278tb.B f24953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ p264sb.p f24954d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtomicReference f24955e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ p278tb.y f24956f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ p264sb.p f24957g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ p264sb.p f24958h;

        static final class a implements InterfaceC0882g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ p278tb.B f24959a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ p264sb.p f24960b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ AtomicReference f24961c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ p278tb.y f24962d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ p264sb.p f24963e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ p264sb.p f24964f;

            /* JADX INFO: renamed from: com.miui.electricrisk.AiGuardSceneService$i$a$a, reason: collision with other inner class name */
            static final class C0344a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                Object f24965a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                Object f24966b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                Object f24967c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f24968d;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                int f24970f;

                C0344a(p138jb.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.f24968d = obj;
                    this.f24970f |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            a(p278tb.B b10, p264sb.p pVar, AtomicReference atomicReference, p278tb.y yVar, p264sb.p pVar2, p264sb.p pVar3) {
                this.f24959a = b10;
                this.f24960b = pVar;
                this.f24961c = atomicReference;
                this.f24962d = yVar;
                this.f24963e = pVar2;
                this.f24964f = pVar3;
            }

            /* JADX WARN: Code duplicated, block: B:32:0x00ca A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:35:0x00d3  */
            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // Ib.InterfaceC0882g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(p068eb.o oVar, p138jb.f fVar) {
                C0344a c0344a;
                ComponentName componentName;
                ComponentName componentName2;
                ComponentName componentName3;
                a aVar;
                a aVar2;
                p264sb.p pVar;
                Object obj;
                if (fVar instanceof C0344a) {
                    c0344a = (C0344a) fVar;
                    int i10 = c0344a.f24970f;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0344a.f24970f = i10 - Integer.MIN_VALUE;
                    } else {
                        c0344a = new C0344a(fVar);
                    }
                } else {
                    c0344a = new C0344a(fVar);
                }
                Object obj2 = c0344a.f24968d;
                Object objE = p152kb.b.e();
                int i11 = c0344a.f24970f;
                if (i11 != 0) {
                    if (i11 == 1) {
                        componentName2 = (ComponentName) c0344a.f24967c;
                        componentName = (ComponentName) c0344a.f24966b;
                        aVar2 = (a) c0344a.f24965a;
                        p068eb.q.b(obj2);
                    } else if (i11 == 2) {
                        componentName2 = (ComponentName) c0344a.f24966b;
                        aVar = (a) c0344a.f24965a;
                        p068eb.q.b(obj2);
                        if (aVar.f24961c.get() != null || !com.miui.electricrisk.k.f25072c.contains(componentName2.getClassName()) || aVar.f24962d.f48417a) {
                            return p068eb.w.f38919a;
                        }
                        p264sb.p pVar2 = aVar.f24964f;
                        Object obj3 = aVar.f24961c.get();
                        p278tb.n.e(obj3, "get(...)");
                        c0344a.f24965a = null;
                        c0344a.f24966b = null;
                        c0344a.f24967c = null;
                        c0344a.f24970f = 3;
                        if (pVar2.invoke(obj3, c0344a) == objE) {
                            return objE;
                        }
                    } else {
                        if (i11 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        p068eb.q.b(obj2);
                    }
                    return p068eb.w.f38919a;
                }
                p068eb.q.b(obj2);
                componentName = (ComponentName) oVar.a();
                componentName2 = (ComponentName) oVar.b();
                this.f24959a.f48389a = componentName2.getClassName();
                if (p278tb.n.b(componentName2, com.miui.electricrisk.k.f25071b)) {
                    p264sb.p pVar3 = this.f24960b;
                    Object obj4 = this.f24961c.get();
                    c0344a.f24965a = this;
                    c0344a.f24966b = componentName;
                    c0344a.f24967c = componentName2;
                    c0344a.f24970f = 1;
                    if (pVar3.invoke(obj4, c0344a) == objE) {
                        return objE;
                    }
                    aVar2 = this;
                } else {
                    componentName3 = componentName;
                    aVar = this;
                }
                if (aVar.f24961c.get() != null && com.miui.electricrisk.k.f25072c.contains(componentName3.getClassName())) {
                    pVar = aVar.f24963e;
                    obj = aVar.f24961c.get();
                    p278tb.n.e(obj, "get(...)");
                    c0344a.f24965a = aVar;
                    c0344a.f24966b = componentName2;
                    c0344a.f24967c = null;
                    c0344a.f24970f = 2;
                    if (pVar.invoke(obj, c0344a) == objE) {
                        return objE;
                    }
                }
                if (aVar.f24961c.get() != null) {
                }
                return p068eb.w.f38919a;
                aVar2.f24962d.f48417a = true;
                componentName3 = componentName;
                aVar = aVar2;
                if (aVar.f24961c.get() != null) {
                    pVar = aVar.f24963e;
                    obj = aVar.f24961c.get();
                    p278tb.n.e(obj, "get(...)");
                    c0344a.f24965a = aVar;
                    c0344a.f24966b = componentName2;
                    c0344a.f24967c = null;
                    c0344a.f24970f = 2;
                    if (pVar.invoke(obj, c0344a) == objE) {
                        return objE;
                    }
                }
                if (aVar.f24961c.get() != null) {
                }
                return p068eb.w.f38919a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(InterfaceC0881f interfaceC0881f, p278tb.B b10, p264sb.p pVar, AtomicReference atomicReference, p278tb.y yVar, p264sb.p pVar2, p264sb.p pVar3, p138jb.f fVar) {
            super(2, fVar);
            this.f24952b = interfaceC0881f;
            this.f24953c = b10;
            this.f24954d = pVar;
            this.f24955e = atomicReference;
            this.f24956f = yVar;
            this.f24957g = pVar2;
            this.f24958h = pVar3;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final p138jb.f create(Object obj, p138jb.f fVar) {
            return new i(this.f24952b, this.f24953c, this.f24954d, this.f24955e, this.f24956f, this.f24957g, this.f24958h, fVar);
        }

        @Override // p264sb.p
        public final Object invoke(O o10, p138jb.f fVar) {
            return ((i) create(o10, fVar)).invokeSuspend(p068eb.w.f38919a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = p152kb.b.e();
            int i10 = this.f24951a;
            if (i10 == 0) {
                p068eb.q.b(obj);
                InterfaceC0881f interfaceC0881f = this.f24952b;
                a aVar = new a(this.f24953c, this.f24954d, this.f24955e, this.f24956f, this.f24957g, this.f24958h);
                this.f24951a = 1;
                if (interfaceC0881f.collect(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p068eb.q.b(obj);
            }
            return p068eb.w.f38919a;
        }
    }

    static final class j extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterfaceC0881f f24972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ p264sb.p f24973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicReference f24974d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ AiGuardSceneService f24975e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ p278tb.B f24976f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ p278tb.y f24977g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ p264sb.p f24978h;

        static final class a implements InterfaceC0882g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ p264sb.p f24979a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AtomicReference f24980b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ AiGuardSceneService f24981c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ p278tb.B f24982d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ p278tb.y f24983e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ p264sb.p f24984f;

            /* JADX INFO: renamed from: com.miui.electricrisk.AiGuardSceneService$j$a$a, reason: collision with other inner class name */
            static final class C0345a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                Object f24985a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                Object f24986b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                /* synthetic */ Object f24987c;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f24989e;

                C0345a(p138jb.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.f24987c = obj;
                    this.f24989e |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            a(p264sb.p pVar, AtomicReference atomicReference, AiGuardSceneService aiGuardSceneService, p278tb.B b10, p278tb.y yVar, p264sb.p pVar2) {
                this.f24979a = pVar;
                this.f24980b = atomicReference;
                this.f24981c = aiGuardSceneService;
                this.f24982d = b10;
                this.f24983e = yVar;
                this.f24984f = pVar2;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // Ib.InterfaceC0882g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, p138jb.f fVar) {
                C0345a c0345a;
                a aVar;
                if (fVar instanceof C0345a) {
                    c0345a = (C0345a) fVar;
                    int i10 = c0345a.f24989e;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0345a.f24989e = i10 - Integer.MIN_VALUE;
                    } else {
                        c0345a = new C0345a(fVar);
                    }
                } else {
                    c0345a = new C0345a(fVar);
                }
                Object obj = c0345a.f24987c;
                Object objE = p152kb.b.e();
                int i11 = c0345a.f24989e;
                if (i11 != 0) {
                    if (i11 == 1) {
                        str = (String) c0345a.f24986b;
                        aVar = (a) c0345a.f24985a;
                        p068eb.q.b(obj);
                    } else {
                        if (i11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        p068eb.q.b(obj);
                    }
                    return p068eb.w.f38919a;
                }
                p068eb.q.b(obj);
                if (com.miui.electricrisk.k.f25070a.contains(str)) {
                    p264sb.p pVar = this.f24979a;
                    c0345a.f24985a = this;
                    c0345a.f24986b = str;
                    c0345a.f24989e = 1;
                    if (pVar.invoke(str, c0345a) == objE) {
                        return objE;
                    }
                    aVar = this;
                }
                return p068eb.w.f38919a;
                aVar.f24980b.set(str);
                aVar.f24981c.currentVoipPackageName = str;
                if (AbstractC1948o.G(com.miui.electricrisk.k.f25072c, aVar.f24982d.f48389a) && !aVar.f24983e.f48417a) {
                    p264sb.p pVar2 = aVar.f24984f;
                    c0345a.f24985a = null;
                    c0345a.f24986b = null;
                    c0345a.f24989e = 2;
                    if (pVar2.invoke(str, c0345a) == objE) {
                        return objE;
                    }
                    return p068eb.w.f38919a;
                }
                return p068eb.w.f38919a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(InterfaceC0881f interfaceC0881f, p264sb.p pVar, AtomicReference atomicReference, AiGuardSceneService aiGuardSceneService, p278tb.B b10, p278tb.y yVar, p264sb.p pVar2, p138jb.f fVar) {
            super(2, fVar);
            this.f24972b = interfaceC0881f;
            this.f24973c = pVar;
            this.f24974d = atomicReference;
            this.f24975e = aiGuardSceneService;
            this.f24976f = b10;
            this.f24977g = yVar;
            this.f24978h = pVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final p138jb.f create(Object obj, p138jb.f fVar) {
            return new j(this.f24972b, this.f24973c, this.f24974d, this.f24975e, this.f24976f, this.f24977g, this.f24978h, fVar);
        }

        @Override // p264sb.p
        public final Object invoke(O o10, p138jb.f fVar) {
            return ((j) create(o10, fVar)).invokeSuspend(p068eb.w.f38919a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = p152kb.b.e();
            int i10 = this.f24971a;
            if (i10 == 0) {
                p068eb.q.b(obj);
                InterfaceC0881f interfaceC0881f = this.f24972b;
                a aVar = new a(this.f24973c, this.f24974d, this.f24975e, this.f24976f, this.f24977g, this.f24978h);
                this.f24971a = 1;
                if (interfaceC0881f.collect(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p068eb.q.b(obj);
            }
            return p068eb.w.f38919a;
        }
    }

    static final class k extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f24991b;

        public static final class a extends BroadcastReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AiGuardSceneService f24993a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Hb.t f24994b;

            a(AiGuardSceneService aiGuardSceneService, Hb.t tVar) {
                this.f24993a = aiGuardSceneService;
                this.f24994b = tVar;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String stringExtra;
                if (this.f24993a.A() || intent == null || (stringExtra = intent.getStringExtra("pkg")) == null) {
                    return;
                }
                Hb.k.b(this.f24994b.a(stringExtra));
            }
        }

        k(p138jb.f fVar) {
            super(2, fVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final p068eb.w m(AiGuardSceneService aiGuardSceneService, a aVar) {
            aiGuardSceneService.unregisterReceiver(aVar);
            return p068eb.w.f38919a;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final p138jb.f create(Object obj, p138jb.f fVar) {
            k kVar = AiGuardSceneService.this.new k(fVar);
            kVar.f24991b = obj;
            return kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = p152kb.b.e();
            int i10 = this.f24990a;
            if (i10 == 0) {
                p068eb.q.b(obj);
                Hb.t tVar = (Hb.t) this.f24991b;
                final a aVar = new a(AiGuardSceneService.this, tVar);
                com.miui.common.utils.D.r(AiGuardSceneService.this, aVar, N0.H(0), new IntentFilter("miui.media.AUDIO_VOIP_RECORD_STATE_CHANGED_ACTION"), "com.miui.permission.AUDIO_VOIP_RECORD_STATE_CHANGED_ACTION", null, 2);
                final AiGuardSceneService aiGuardSceneService = AiGuardSceneService.this;
                p264sb.a aVar2 = new p264sb.a() { // from class: com.miui.electricrisk.f
                    @Override // p264sb.a
                    public final Object invoke() {
                        return AiGuardSceneService.k.m(aiGuardSceneService, aVar);
                    }
                };
                this.f24990a = 1;
                if (Hb.r.a(tVar, aVar2, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p068eb.q.b(obj);
            }
            return p068eb.w.f38919a;
        }

        @Override // p264sb.p
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Hb.t tVar, p138jb.f fVar) {
            return ((k) create(tVar, fVar)).invokeSuspend(p068eb.w.f38919a);
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f24996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AudioManager f24997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AiGuardSceneService f24998d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(AudioManager audioManager, AiGuardSceneService aiGuardSceneService, p138jb.f fVar) {
            super(2, fVar);
            this.f24997c = audioManager;
            this.f24998d = aiGuardSceneService;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(AiGuardSceneService aiGuardSceneService, Hb.t tVar, int i10) {
            if (!aiGuardSceneService.A() && i10 == 0) {
                tVar.a(Integer.valueOf(i10));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final p068eb.w p(AudioManager audioManager, AudioManager$OnModeChangedListener audioManager$OnModeChangedListener) {
            audioManager.removeOnModeChangedListener(audioManager$OnModeChangedListener);
            return p068eb.w.f38919a;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final p138jb.f create(Object obj, p138jb.f fVar) {
            l lVar = new l(this.f24997c, this.f24998d, fVar);
            lVar.f24996b = obj;
            return lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = p152kb.b.e();
            int i10 = this.f24995a;
            if (i10 == 0) {
                p068eb.q.b(obj);
                final Hb.t tVar = (Hb.t) this.f24996b;
                final AiGuardSceneService aiGuardSceneService = this.f24998d;
                final AudioManager$OnModeChangedListener audioManager$OnModeChangedListener = new AudioManager$OnModeChangedListener() { // from class: com.miui.electricrisk.i
                    public final void onModeChanged(int i11) {
                        AiGuardSceneService.l.o(aiGuardSceneService, tVar, i11);
                    }
                };
                AudioManager audioManager = this.f24997c;
                jb.j.b bVarI = tVar.getCoroutineContext().i(K.f2099b);
                p278tb.n.c(bVarI);
                audioManager.addOnModeChangedListener(AbstractC0716t0.a((K) bVarI), audioManager$OnModeChangedListener);
                final AudioManager audioManager2 = this.f24997c;
                p264sb.a aVar = new p264sb.a() { // from class: com.miui.electricrisk.j
                    @Override // p264sb.a
                    public final Object invoke() {
                        return AiGuardSceneService.l.p(audioManager2, audioManager$OnModeChangedListener);
                    }
                };
                this.f24995a = 1;
                if (Hb.r.a(tVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p068eb.q.b(obj);
            }
            return p068eb.w.f38919a;
        }

        @Override // p264sb.p
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Hb.t tVar, p138jb.f fVar) {
            return ((l) create(tVar, fVar)).invokeSuspend(p068eb.w.f38919a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A() {
        return N0.f() != this.userId;
    }

    private final InterfaceC0881f B(List packages, List activities) {
        return AbstractC0883h.r(AbstractC0883h.f(new AiGuardSceneService$monitorActivities$1(packages, activities, this, null)), C0687e0.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean C() {
        try {
            List historicalProcessExitReasons = ((ActivityManager) getSystemService(ActivityManager.class)).getHistoricalProcessExitReasons("com.miui.guardprovider", 0, 1);
            p278tb.n.e(historicalProcessExitReasons, "getHistoricalProcessExitReasons(...)");
            if (historicalProcessExitReasons.isEmpty()) {
                Log.d("AiGuardDaemon", "No exit reasons found, allow restart");
                return true;
            }
            int reason = AbstractC2143j.a(historicalProcessExitReasons.get(0)).getReason();
            boolean z10 = reason != 1;
            Log.d("AiGuardDaemon", "ai process last exit: reason=" + reason + " shouldRestart=" + z10);
            return z10;
        } catch (Exception e10) {
            Log.e("AiGuardDaemon", "shouldRestartByExitReason failed", e10);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        G();
        stopService(new Intent().setComponent(com.miui.electricrisk.k.f25073d));
        Log.i("AiGuardDaemon", "shutdownWorkerServiceNow");
    }

    private final void E() {
        int capabilities = AiGuardUtils.getCapabilities(this);
        if ((capabilities & 1) != 0) {
            p278tb.z zVar = new p278tb.z();
            zVar.f48418a = -1;
            AbstractC0698k.d(this.scope, null, null, new b(capabilities, zVar, null), 3, null);
        }
        I(new c(null), new d(capabilities, this, null), new e(null), new f(null), new g(null));
        Log.i("AiGuardDaemon", "Daemon Started.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        if (this.processObserver != null) {
            return;
        }
        synchronized (this.restartLock) {
            this.lastRestartTime = 0L;
            p068eb.w wVar = p068eb.w.f38919a;
        }
        IMiuiProcessObserver iMiuiProcessObserver = new IMiuiProcessObserver() { // from class: com.miui.electricrisk.AiGuardSceneService$startProcessMonitor$2

            static final class a extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f25007a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ AiGuardSceneService f25008b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(AiGuardSceneService aiGuardSceneService, p138jb.f fVar) {
                    super(2, fVar);
                    this.f25008b = aiGuardSceneService;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    return new a(this.f25008b, fVar);
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((a) create(o10, fVar)).invokeSuspend(p068eb.w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objE = p152kb.b.e();
                    int i10 = this.f25007a;
                    if (i10 == 0) {
                        p068eb.q.b(obj);
                        this.f25007a = 1;
                        if (Z.a(1500L, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        p068eb.q.b(obj);
                    }
                    if (!this.f25008b.workerStarted.get()) {
                        return p068eb.w.f38919a;
                    }
                    if (!this.f25008b.C()) {
                        Log.d("AiGuardDaemon", "ai process exited by itself, skip restart");
                        return p068eb.w.f38919a;
                    }
                    Object obj2 = this.f25008b.restartLock;
                    AiGuardSceneService aiGuardSceneService = this.f25008b;
                    synchronized (obj2) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (jCurrentTimeMillis - aiGuardSceneService.lastRestartTime < aiGuardSceneService.restartDebounceMs) {
                            return p068eb.w.f38919a;
                        }
                        if (!aiGuardSceneService.w()) {
                            Log.w("AiGuardDaemon", "GuardProvider:ai process died, restarting");
                            Intent intent = aiGuardSceneService.lastWorkerIntent;
                            if (intent != null) {
                                try {
                                    aiGuardSceneService.lastRestartTime = jCurrentTimeMillis;
                                    aiGuardSceneService.startForegroundService(intent);
                                    Log.i("AiGuardDaemon", "GuardProvider:ai restarted by process monitor");
                                } catch (Exception e10) {
                                    Log.e("AiGuardDaemon", "Process monitor restart failed", e10);
                                }
                            }
                        }
                        return p068eb.w.f38919a;
                    }
                }
            }

            @Override // android.app.IMiuiProcessObserver, android.app.IProcessObserver
            public void onForegroundActivitiesChanged(int pid, int uid, boolean foregroundActivities) {
            }

            @Override // android.app.IMiuiProcessObserver, android.app.IProcessObserver
            public void onForegroundServicesChanged(int pid, int uid, int serviceTypes) {
            }

            @Override // android.app.IMiuiProcessObserver
            public void onImportanceChanged(int pid, int uid, int importance) {
            }

            @Override // android.app.IMiuiProcessObserver, android.app.IProcessObserver
            public void onProcessDied(int pid, int uid) {
                if (this.f25006a.workerStarted.get()) {
                    int iU = this.f25006a.u();
                    if (iU == -1 || uid == iU) {
                        AbstractC0698k.d(this.f25006a.scope, null, null, new a(this.f25006a, null), 3, null);
                    }
                }
            }

            @Override // android.app.IProcessObserver
            public void onProcessStarted(int pid, int processUid, int packageUid, String packageName, String processName) {
                if (p278tb.n.b(processName, "com.miui.guardprovider:ai")) {
                    Log.i("AiGuardDaemon", "GuardProvider:ai process started (pid=" + pid + ")");
                }
            }

            @Override // android.app.IMiuiProcessObserver
            public void onProcessStateChanged(int pid, int uid, int procState) {
            }
        };
        this.processObserver = iMiuiProcessObserver;
        try {
            ActivityManagerCompat.registerProcessObserver2(iMiuiProcessObserver);
            Log.i("AiGuardDaemon", "Process monitor started");
        } catch (Exception e10) {
            Log.e("AiGuardDaemon", "registerProcessObserver failed", e10);
            this.processObserver = null;
        }
    }

    private final void G() {
        IProcessObserver iProcessObserver = this.processObserver;
        if (iProcessObserver != null) {
            try {
                ActivityManagerCompat.unRegisterProcessObserver(iProcessObserver);
            } catch (Exception unused) {
            }
        }
        this.processObserver = null;
        this.lastWorkerIntent = null;
        Log.i("AiGuardDaemon", "Process monitor stopped");
    }

    private final void I(p264sb.p onEstablished, p264sb.p onTopResumed, p264sb.p onPaused, p264sb.p onDisconnected, p264sb.p onAlerted) {
        InterfaceC0881f interfaceC0881fJ = J();
        InterfaceC0881f interfaceC0881fB = B(com.miui.electricrisk.k.f25070a, com.miui.electricrisk.k.f25072c);
        AtomicReference atomicReference = new AtomicReference();
        p278tb.B b10 = new p278tb.B();
        p278tb.y yVar = new p278tb.y();
        AbstractC0698k.d(this.scope, null, null, new h(atomicReference, onDisconnected, yVar, null), 3, null);
        AbstractC0698k.d(this.scope, null, null, new i(interfaceC0881fB, b10, onAlerted, atomicReference, yVar, onPaused, onTopResumed, null), 3, null);
        AbstractC0698k.d(this.scope, null, null, new j(interfaceC0881fJ, onEstablished, atomicReference, this, b10, yVar, onTopResumed, null), 3, null);
    }

    private final InterfaceC0881f J() {
        return AbstractC0883h.r(AbstractC0883h.f(new k(null)), C0687e0.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC0881f K(AtomicReference pkgRef) {
        return AbstractC0883h.f(new l((AudioManager) getSystemService(AudioManager.class), this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC0881f t() {
        return AbstractC0883h.r(AbstractC0883h.f(new a((TelephonyManager) getSystemService(TelephonyManager.class), this, null)), C0687e0.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int u() {
        if (this.guardProviderUid == -1) {
            try {
                this.guardProviderUid = getPackageManager().getApplicationInfo("com.miui.guardprovider", 0).uid;
            } catch (Exception e10) {
                Log.e("AiGuardDaemon", "getGuardProviderUid failed", e10);
            }
        }
        return this.guardProviderUid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent v(int command) {
        Intent intentPutExtra = new Intent().setComponent(com.miui.electricrisk.k.f25073d).putExtra("COMMAND", command);
        p278tb.n.e(intentPutExtra, "putExtra(...)");
        return intentPutExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean w() {
        try {
            Process processExec = Runtime.getRuntime().exec(new String[]{"pidof", "com.miui.guardprovider:ai"});
            InputStream inputStream = processExec.getInputStream();
            p278tb.n.e(inputStream, "getInputStream(...)");
            String string = Cb.g.C0(p222pb.j.h(new BufferedReader(new InputStreamReader(inputStream, Cb.c.f1147b), 8192))).toString();
            processExec.waitFor();
            return string.length() > 0;
        } catch (Exception e10) {
            Log.e("AiGuardDaemon", "isAiProcessAlive check failed", e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y(String phoneNumber) {
        return (x(phoneNumber) || z(phoneNumber)) ? false : true;
    }

    public final void H(String packageName) {
        p278tb.n.f(packageName, "packageName");
        Ra.k.f8517c.a().c2(new Qa.n(packageName, 0L, System.currentTimeMillis(), 0L, false, false), Qa.p.TYPE_END_CALL);
    }

    @Override // android.app.Service
    protected void dump(FileDescriptor fd2, PrintWriter writer, String[] args) {
        p278tb.n.f(writer, "writer");
        writer.println("Capabilities: " + AiGuardUtils.getCapabilities(this));
        writer.println("Function Switch ON: " + AiGuardUtils.isAiGuardEnabled(this));
        writer.println("CloudSettings: " + AiGuardCloudController.loadCachedCloudData(this));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        p278tb.n.f(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        E();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        G();
        String str = null;
        P.d(this.scope, null, 1, null);
        Log.i("AiGuardDaemon", "Daemon stopped.");
        String str2 = this.currentVoipPackageName;
        if (str2 != null) {
            if (str2 == null) {
                p278tb.n.s("currentVoipPackageName");
                str2 = null;
            }
            if (str2.length() > 0) {
                String str3 = this.currentVoipPackageName;
                if (str3 == null) {
                    p278tb.n.s("currentVoipPackageName");
                } else {
                    str = str3;
                }
                H(str);
            }
        }
    }

    public final boolean x(String phoneNumber) throws IOException {
        p278tb.n.f(phoneNumber, "phoneNumber");
        Cursor cursorQuery = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1"}, "replace(data1,' ','') LIKE ?", new String[]{phoneNumber}, null);
        if (cursorQuery != null) {
            Cursor cursor = cursorQuery;
            try {
                if (cursor.moveToNext()) {
                    p222pb.b.a(cursor, null);
                    return true;
                }
                p068eb.w wVar = p068eb.w.f38919a;
                p222pb.b.a(cursor, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    p222pb.b.a(cursor, th);
                    throw th2;
                }
            }
        }
        Log.i("AiGuardDaemon", "isInContacts: false");
        return false;
    }

    public final boolean z(String phoneNumber) {
        p278tb.n.f(phoneNumber, "phoneNumber");
        boolean z10 = YellowPageUtils.getPhoneInfo(this, phoneNumber, true) != null;
        Log.i("AiGuardDaemon", "isYellowPageRecognized: " + z10);
        return z10;
    }
}
