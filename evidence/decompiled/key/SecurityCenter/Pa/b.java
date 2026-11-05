package Pa;

import Fb.AbstractC0688f;
import Fb.AbstractC0698k;
import Fb.C0687e0;
import Fb.O;
import Fb.P;
import Fb.W;
import Qa.m;
import Qa.n;
import Ta.c;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.miui.common.utils.GsonUtils;
import com.xiaomi.security.xsof.base.ScoreConfigBean;
import com.xiaomi.security.xsof.frauddetection.bean.CurrentFraudMetadata;
import com.xiaomi.security.xsof.frauddetection.bean.DurationFraudData;
import com.xiaomi.security.xsof.frauddetection.bean.FraudDetectionScore;
import com.xiaomi.security.xsof.frauddetection.bean.PastFraudData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p068eb.h;
import p068eb.i;
import p068eb.l;
import p068eb.o;
import p068eb.q;
import p068eb.t;
import p068eb.w;
import p096gb.AbstractC1942i;
import p096gb.F;
import p264sb.p;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7563a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f7564b = i.a(l.SYNCHRONIZED, new p264sb.a() { // from class: Pa.a
        @Override // p264sb.a
        public final Object invoke() {
            return b.l();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f7565c = {0, 1, 2, 3, 4, 5, 6};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f7566d = {0, 1, 2, 3};

    public static final class a {

        /* JADX INFO: renamed from: Pa.b$a$a, reason: collision with other inner class name */
        static final class C0085a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f7567a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f7569c;

            C0085a(p138jb.f fVar) {
                super(fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.f7567a = obj;
                this.f7569c |= Integer.MIN_VALUE;
                return a.this.a(this);
            }
        }

        /* JADX INFO: renamed from: Pa.b$a$b, reason: collision with other inner class name */
        static final class C0086b extends kotlin.coroutines.jvm.internal.j implements p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            long f7570a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f7571b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private /* synthetic */ Object f7572c;

            /* JADX INFO: renamed from: Pa.b$a$b$a, reason: collision with other inner class name */
            static final class C0087a extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7573a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7574b;

                C0087a(p138jb.f fVar) {
                    super(2, fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    C0087a c0087a = new C0087a(fVar);
                    c0087a.f7574b = obj;
                    return c0087a;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((C0087a) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    p152kb.b.e();
                    if (this.f7573a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                    try {
                        eb.p.a aVar = p068eb.p.f38907b;
                        objB = p068eb.p.b(Ta.d.f9144a.g());
                    } catch (Throwable th) {
                        eb.p.a aVar2 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取呼叫转移数据失败, case " + thD.getMessage());
                    return null;
                }
            }

            /* JADX INFO: renamed from: Pa.b$a$b$b, reason: collision with other inner class name */
            static final class C0088b extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7575a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7576b;

                C0088b(p138jb.f fVar) {
                    super(2, fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    C0088b c0088b = new C0088b(fVar);
                    c0088b.f7576b = obj;
                    return c0088b;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((C0088b) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    p152kb.b.e();
                    if (this.f7575a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                    try {
                        eb.p.a aVar = p068eb.p.f38907b;
                        objB = p068eb.p.b(kotlin.coroutines.jvm.internal.b.b(Ta.d.f9144a.b()));
                    } catch (Throwable th) {
                        eb.p.a aVar2 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取屏幕共享数据失败, case " + thD.getMessage());
                    return null;
                }
            }

            /* JADX INFO: renamed from: Pa.b$a$b$c */
            static final class c extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7577a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7578b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ m f7579c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(m mVar, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7579c = mVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    c cVar = new c(this.f7579c, fVar);
                    cVar.f7578b = obj;
                    return cVar;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((c) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    p152kb.b.e();
                    if (this.f7577a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                    m mVar = this.f7579c;
                    try {
                        eb.p.a aVar = p068eb.p.f38907b;
                        objB = p068eb.p.b(kotlin.coroutines.jvm.internal.b.b(Ta.d.f9144a.c(false, mVar)));
                    } catch (Throwable th) {
                        eb.p.a aVar2 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取SIM卡通话数据失败, case " + thD.getMessage());
                    return null;
                }
            }

            /* JADX INFO: renamed from: Pa.b$a$b$d */
            static final class d extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7580a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7581b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ m f7582c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                d(m mVar, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7582c = mVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    d dVar = new d(this.f7582c, fVar);
                    dVar.f7581b = obj;
                    return dVar;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((d) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    p152kb.b.e();
                    if (this.f7580a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                    m mVar = this.f7582c;
                    try {
                        eb.p.a aVar = p068eb.p.f38907b;
                        objB = p068eb.p.b(kotlin.coroutines.jvm.internal.b.b(Ta.d.f9144a.c(true, mVar)));
                    } catch (Throwable th) {
                        eb.p.a aVar2 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取SIM卡欺诈通话失败, case " + thD.getMessage());
                    return null;
                }
            }

            /* JADX INFO: renamed from: Pa.b$a$b$e */
            static final class e extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7583a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7584b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ n f7585c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                e(n nVar, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7585c = nVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    e eVar = new e(this.f7585c, fVar);
                    eVar.f7584b = obj;
                    return eVar;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((e) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    p152kb.b.e();
                    if (this.f7583a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                    n nVar = this.f7585c;
                    try {
                        eb.p.a aVar = p068eb.p.f38907b;
                        objB = p068eb.p.b(kotlin.coroutines.jvm.internal.b.b(Ta.d.f9144a.d(nVar)));
                    } catch (Throwable th) {
                        eb.p.a aVar2 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取VoIP通话状态失败, case " + thD.getMessage());
                    return null;
                }
            }

            /* JADX INFO: renamed from: Pa.b$a$b$f */
            static final class f extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7586a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7587b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ n f7588c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                f(n nVar, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7588c = nVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    f fVar2 = new f(this.f7588c, fVar);
                    fVar2.f7587b = obj;
                    return fVar2;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((f) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    p152kb.b.e();
                    if (this.f7586a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                    n nVar = this.f7588c;
                    try {
                        eb.p.a aVar = p068eb.p.f38907b;
                        objB = p068eb.p.b(kotlin.coroutines.jvm.internal.b.b(Ta.d.f9144a.a(nVar)));
                    } catch (Throwable th) {
                        eb.p.a aVar2 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取VoIP欺诈检测失败, case " + thD.getMessage());
                    return null;
                }
            }

            C0086b(p138jb.f fVar) {
                super(2, fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                C0086b c0086b = new C0086b(fVar);
                c0086b.f7572c = obj;
                return c0086b;
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((C0086b) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objB;
                Object objB2;
                Object objA;
                long j10;
                Object objB3;
                Object objE = p152kb.b.e();
                int i10 = this.f7571b;
                try {
                    if (i10 == 0) {
                        q.b(obj);
                        O o10 = (O) this.f7572c;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        W wB = AbstractC0698k.b(o10, null, null, new C0088b(null), 3, null);
                        try {
                            eb.p.a aVar = p068eb.p.f38907b;
                            objB = p068eb.p.b(Ra.k.f8517c.a().A1());
                        } catch (Throwable th) {
                            eb.p.a aVar2 = p068eb.p.f38907b;
                            objB = p068eb.p.b(q.a(th));
                        }
                        Object obj2 = objB;
                        if (p068eb.p.f(obj2)) {
                            obj2 = null;
                        }
                        n nVar = (n) obj2;
                        try {
                            objB2 = p068eb.p.b(Ra.k.f8517c.a().z1());
                        } catch (Throwable th2) {
                            eb.p.a aVar3 = p068eb.p.f38907b;
                            objB2 = p068eb.p.b(q.a(th2));
                        }
                        if (p068eb.p.f(objB2)) {
                            objB2 = null;
                        }
                        o oVarA = t.a(nVar, (m) objB2);
                        n nVar2 = (n) oVarA.a();
                        m mVar = (m) oVarA.b();
                        W[] wArr = {wB, AbstractC0698k.b(o10, null, null, new e(nVar2, null), 3, null), AbstractC0698k.b(o10, null, null, new f(nVar2, null), 3, null), AbstractC0698k.b(o10, null, null, new c(mVar, null), 3, null), AbstractC0698k.b(o10, null, null, new d(mVar, null), 3, null), AbstractC0698k.b(o10, null, null, new C0087a(null), 3, null)};
                        this.f7572c = o10;
                        this.f7570a = jCurrentTimeMillis;
                        this.f7571b = 1;
                        objA = AbstractC0688f.a(wArr, this);
                        if (objA == objE) {
                            return objE;
                        }
                        j10 = jCurrentTimeMillis;
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j10 = this.f7570a;
                        q.b(obj);
                        objA = obj;
                    }
                    List list = (List) objA;
                    Integer num = (Integer) list.get(0);
                    Integer num2 = (Integer) list.get(1);
                    Integer num3 = (Integer) list.get(2);
                    Integer num4 = (Integer) list.get(3);
                    Integer num5 = (Integer) list.get(4);
                    Integer num6 = (Integer) list.get(5);
                    CurrentFraudMetadata currentFraudMetadata = new CurrentFraudMetadata(num != null ? num.intValue() : Ta.h.f9148a.B(Qa.e.ScreenShareInfo), num2 != null ? num2.intValue() : Ta.h.f9148a.B(Qa.e.VoipRecordInfo), num3 != null ? num3.intValue() : Ta.h.f9148a.B(Qa.e.VoipRecordInfo), num4 != null ? num4.intValue() : Ta.h.f9148a.B(Qa.e.SimCardFraudInfo), num5 != null ? num5.intValue() : Ta.h.f9148a.B(Qa.e.SimCardFraudInfo), num6 != null ? num6.intValue() : Ta.h.f9148a.B(Qa.e.CallForwardingInfo));
                    try {
                        eb.p.a aVar4 = p068eb.p.f38907b;
                        objB3 = p068eb.p.b(GsonUtils.b(currentFraudMetadata));
                    } catch (Throwable th3) {
                        eb.p.a aVar5 = p068eb.p.f38907b;
                        objB3 = p068eb.p.b(q.a(th3));
                    }
                    Throwable thD = p068eb.p.d(objB3);
                    if (thD != null) {
                        Wa.b.b("FraudDetectionManager", "JSON序列化失败, case " + thD.getMessage());
                        objB3 = "";
                    }
                    String str = (String) objB3;
                    Wa.b.a("FraudDetectionManager", "getCurrentFraudResult: " + str + " , cost time: " + (System.currentTimeMillis() - j10) + "ms");
                    return str;
                } catch (Exception e10) {
                    Wa.b.b("FraudDetectionManager", "getCurrentFraudResult error: " + e10);
                    return "";
                }
            }
        }

        static final class c extends kotlin.coroutines.jvm.internal.j implements p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f7589a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ p264sb.l f7590b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(p264sb.l lVar, p138jb.f fVar) {
                super(2, fVar);
                this.f7590b = lVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new c(this.f7590b, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((c) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f7589a;
                try {
                    if (i10 == 0) {
                        q.b(obj);
                        a aVar = b.f7563a;
                        this.f7589a = 1;
                        obj = aVar.a(this);
                        if (obj == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        q.b(obj);
                    }
                } catch (Exception e10) {
                    Wa.b.b("FraudDetectionManager", "getCurrentFraudResultAsync error: " + e10);
                }
                return w.f38919a;
            }
        }

        static final class d extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f7591a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f7593c;

            d(p138jb.f fVar) {
                super(fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.f7591a = obj;
                this.f7593c |= Integer.MIN_VALUE;
                return a.this.c(null, null, this);
            }
        }

        static final class e extends kotlin.coroutines.jvm.internal.j implements p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            long f7594a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f7595b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private /* synthetic */ Object f7596c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int[] f7597d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ int[] f7598e;

            /* JADX INFO: renamed from: Pa.b$a$e$a, reason: collision with other inner class name */
            static final class C0089a extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7599a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7600b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7601c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ int[] f7602d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0089a(int[] iArr, int[] iArr2, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7601c = iArr;
                    this.f7602d = iArr2;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    C0089a c0089a = new C0089a(this.f7601c, this.f7602d, fVar);
                    c0089a.f7600b = obj;
                    return c0089a;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((C0089a) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7599a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7601c;
                            int[] iArr2 = this.f7602d;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            this.f7599a = 1;
                            obj = aVar2.D(iArr, iArr2, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取时长屏幕共享数据失败，case " + thD.getMessage());
                    return F.h();
                }
            }

            /* JADX INFO: renamed from: Pa.b$a$e$b, reason: collision with other inner class name */
            static final class C0090b extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7603a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7604b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7605c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ int[] f7606d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0090b(int[] iArr, int[] iArr2, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7605c = iArr;
                    this.f7606d = iArr2;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    C0090b c0090b = new C0090b(this.f7605c, this.f7606d, fVar);
                    c0090b.f7604b = obj;
                    return c0090b;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((C0090b) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7603a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7605c;
                            int[] iArr2 = this.f7606d;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            Qa.l lVar = Qa.l.TYPE_ALL_CALL;
                            Qa.e eVar = Qa.e.SimCardInfo;
                            this.f7603a = 1;
                            obj = aVar2.E(lVar, eVar, iArr, iArr2, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取时长SIM卡通话数据失败，case " + thD.getMessage());
                    return F.h();
                }
            }

            static final class c extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7607a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7608b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7609c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ int[] f7610d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(int[] iArr, int[] iArr2, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7609c = iArr;
                    this.f7610d = iArr2;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    c cVar = new c(this.f7609c, this.f7610d, fVar);
                    cVar.f7608b = obj;
                    return cVar;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((c) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7607a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7609c;
                            int[] iArr2 = this.f7610d;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            Qa.l lVar = Qa.l.TYPE_FRAUD_CALL;
                            Qa.e eVar = Qa.e.SimCardFraudInfo;
                            this.f7607a = 1;
                            obj = aVar2.E(lVar, eVar, iArr, iArr2, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取时长SIM卡欺诈通话数据失败，case " + thD.getMessage());
                    return F.h();
                }
            }

            static final class d extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7611a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7612b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7613c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ int[] f7614d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                d(int[] iArr, int[] iArr2, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7613c = iArr;
                    this.f7614d = iArr2;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    d dVar = new d(this.f7613c, this.f7614d, fVar);
                    dVar.f7612b = obj;
                    return dVar;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((d) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7611a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7613c;
                            int[] iArr2 = this.f7614d;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            Qa.l lVar = Qa.l.TYPE_OVERSEAS_CALL;
                            Qa.e eVar = Qa.e.OverseasCallInfo;
                            this.f7611a = 1;
                            obj = aVar2.E(lVar, eVar, iArr, iArr2, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取时长SIM卡境外通话数据失败，case " + thD.getMessage());
                    return F.h();
                }
            }

            /* JADX INFO: renamed from: Pa.b$a$e$e, reason: collision with other inner class name */
            static final class C0091e extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7615a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7616b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7617c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ int[] f7618d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0091e(int[] iArr, int[] iArr2, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7617c = iArr;
                    this.f7618d = iArr2;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    C0091e c0091e = new C0091e(this.f7617c, this.f7618d, fVar);
                    c0091e.f7616b = obj;
                    return c0091e;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((C0091e) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7615a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7617c;
                            int[] iArr2 = this.f7618d;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            Qa.l lVar = Qa.l.TYPE_VIRTUAL_OPERATOR_CALL;
                            Qa.e eVar = Qa.e.VirtualOperatorCallInfo;
                            this.f7615a = 1;
                            obj = aVar2.E(lVar, eVar, iArr, iArr2, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取时长SIM卡虚拟运营商通话数据失败，case " + thD.getMessage());
                    return F.h();
                }
            }

            static final class f extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7619a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7620b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7621c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ int[] f7622d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                f(int[] iArr, int[] iArr2, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7621c = iArr;
                    this.f7622d = iArr2;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    f fVar2 = new f(this.f7621c, this.f7622d, fVar);
                    fVar2.f7620b = obj;
                    return fVar2;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((f) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7619a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7621c;
                            int[] iArr2 = this.f7622d;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            Qa.o oVar = Qa.o.TYPE_ALL_CALL;
                            this.f7619a = 1;
                            obj = aVar2.F(oVar, iArr, iArr2, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取时长VoIP通话数据失败，case " + thD.getMessage());
                    return F.h();
                }
            }

            static final class g extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7623a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7624b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7625c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ int[] f7626d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                g(int[] iArr, int[] iArr2, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7625c = iArr;
                    this.f7626d = iArr2;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    g gVar = new g(this.f7625c, this.f7626d, fVar);
                    gVar.f7624b = obj;
                    return gVar;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((g) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7623a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7625c;
                            int[] iArr2 = this.f7626d;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            Qa.o oVar = Qa.o.TYPE_FRAUD_CALL;
                            this.f7623a = 1;
                            obj = aVar2.F(oVar, iArr, iArr2, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取时长VoIP欺诈通话数据失败，case " + thD.getMessage());
                    return F.h();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(int[] iArr, int[] iArr2, p138jb.f fVar) {
                super(2, fVar);
                this.f7597d = iArr;
                this.f7598e = iArr2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                e eVar = new e(this.f7597d, this.f7598e, fVar);
                eVar.f7596c = obj;
                return eVar;
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((e) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objA;
                long j10;
                Object objB;
                String strM;
                String strM2;
                Object objE = p152kb.b.e();
                int i10 = this.f7595b;
                try {
                    if (i10 == 0) {
                        q.b(obj);
                        O o10 = (O) this.f7596c;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        W[] wArr = {AbstractC0698k.b(o10, null, null, new C0089a(this.f7597d, this.f7598e, null), 3, null), AbstractC0698k.b(o10, null, null, new f(this.f7597d, this.f7598e, null), 3, null), AbstractC0698k.b(o10, null, null, new g(this.f7597d, this.f7598e, null), 3, null), AbstractC0698k.b(o10, null, null, new C0090b(this.f7597d, this.f7598e, null), 3, null), AbstractC0698k.b(o10, null, null, new c(this.f7597d, this.f7598e, null), 3, null), AbstractC0698k.b(o10, null, null, new d(this.f7597d, this.f7598e, null), 3, null), AbstractC0698k.b(o10, null, null, new C0091e(this.f7597d, this.f7598e, null), 3, null)};
                        this.f7596c = o10;
                        this.f7594a = jCurrentTimeMillis;
                        this.f7595b = 1;
                        objA = AbstractC0688f.a(wArr, this);
                        if (objA == objE) {
                            return objE;
                        }
                        j10 = jCurrentTimeMillis;
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j10 = this.f7594a;
                        q.b(obj);
                        objA = obj;
                    }
                    List list = (List) objA;
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    long j11 = jCurrentTimeMillis2 - j10;
                    Map map = (Map) list.get(0);
                    Map map2 = (Map) list.get(1);
                    Map map3 = (Map) list.get(2);
                    Map map4 = (Map) list.get(3);
                    Map map5 = (Map) list.get(4);
                    Map map6 = (Map) list.get(5);
                    Map map7 = (Map) list.get(6);
                    long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis2;
                    DurationFraudData durationFraudData = new DurationFraudData(map, map2, map3, map4, map5, map6, map7);
                    try {
                        eb.p.a aVar = p068eb.p.f38907b;
                        objB = p068eb.p.b(GsonUtils.b(durationFraudData));
                    } catch (Throwable th) {
                        eb.p.a aVar2 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD != null) {
                        Wa.b.b("FraudDetectionManager", "JSON序列化失败, case " + thD.getMessage());
                        objB = "";
                    }
                    String str = (String) objB;
                    long jCurrentTimeMillis4 = System.currentTimeMillis() - j10;
                    int length = str.length();
                    int[] iArr = this.f7597d;
                    String str2 = "null";
                    if (iArr == null || (strM = AbstractC1942i.M(iArr, null, null, null, 0, null, null, 63, null)) == null) {
                        strM = "null";
                    }
                    int[] iArr2 = this.f7598e;
                    if (iArr2 != null && (strM2 = AbstractC1942i.M(iArr2, null, null, null, 0, null, null, 63, null)) != null) {
                        str2 = strM2;
                    }
                    Wa.b.a("FraudDetectionManager", Cb.g.p("getDurationFraudResult性能统计:\n            |并发等待时间: " + j11 + "ms\n            |数据处理时间: " + jCurrentTimeMillis3 + "ms\n            |总耗时: " + jCurrentTimeMillis4 + "ms\n            |数据大小: " + length + "字符\n            |时间范围: " + strM + "\n            |时长范围: " + str2 + "\n            ", null, 1, null));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getDurationFraudResult: ");
                    sb2.append(str);
                    Wa.b.a("FraudDetectionManager", sb2.toString());
                    return str;
                } catch (Exception e10) {
                    Wa.b.b("FraudDetectionManager", "getDurationFraudResult error: " + e10);
                    return "";
                }
            }
        }

        static final class f extends kotlin.coroutines.jvm.internal.j implements p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f7627a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int[] f7628b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int[] f7629c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ p264sb.l f7630d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(int[] iArr, int[] iArr2, p264sb.l lVar, p138jb.f fVar) {
                super(2, fVar);
                this.f7628b = iArr;
                this.f7629c = iArr2;
                this.f7630d = lVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new f(this.f7628b, this.f7629c, this.f7630d, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((f) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f7627a;
                try {
                    if (i10 == 0) {
                        q.b(obj);
                        a aVar = b.f7563a;
                        int[] iArr = this.f7628b;
                        int[] iArr2 = this.f7629c;
                        this.f7627a = 1;
                        obj = aVar.c(iArr, iArr2, this);
                        if (obj == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        q.b(obj);
                    }
                } catch (Exception e10) {
                    Wa.b.b("FraudDetectionManager", "getDurationFraudResultAsync error: " + e10);
                }
                return w.f38919a;
            }
        }

        static final class g extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f7631a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f7633c;

            g(p138jb.f fVar) {
                super(fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.f7631a = obj;
                this.f7633c |= Integer.MIN_VALUE;
                return a.this.g(null, this);
            }
        }

        static final class h extends kotlin.coroutines.jvm.internal.j implements p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            long f7634a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f7635b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private /* synthetic */ Object f7636c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int[] f7637d;

            /* JADX INFO: renamed from: Pa.b$a$h$a, reason: collision with other inner class name */
            static final class C0092a extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7638a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7639b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7640c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0092a(int[] iArr, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7640c = iArr;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    C0092a c0092a = new C0092a(this.f7640c, fVar);
                    c0092a.f7639b = obj;
                    return c0092a;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((C0092a) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7638a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7640c;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            this.f7638a = 1;
                            obj = aVar2.H(iArr, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取历史飞行模式数据失败, case " + thD.getMessage());
                    return F.h();
                }
            }

            /* JADX INFO: renamed from: Pa.b$a$h$b, reason: collision with other inner class name */
            static final class C0093b extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7641a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7642b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7643c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0093b(int[] iArr, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7643c = iArr;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    C0093b c0093b = new C0093b(this.f7643c, fVar);
                    c0093b.f7642b = obj;
                    return c0093b;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((C0093b) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7641a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7643c;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            this.f7641a = 1;
                            obj = aVar2.K(iArr, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取历史应用安装数据失败, case " + thD.getMessage());
                    return F.h();
                }
            }

            static final class c extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7644a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7645b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7646c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(int[] iArr, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7646c = iArr;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    c cVar = new c(this.f7646c, fVar);
                    cVar.f7645b = obj;
                    return cVar;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((c) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7644a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7646c;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            this.f7644a = 1;
                            obj = aVar2.I(iArr, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取历史呼叫转移数据失败, case " + thD.getMessage());
                    return F.h();
                }
            }

            static final class d extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7647a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7648b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7649c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                d(int[] iArr, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7649c = iArr;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    d dVar = new d(this.f7649c, fVar);
                    dVar.f7648b = obj;
                    return dVar;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((d) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7647a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7649c;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            this.f7647a = 1;
                            obj = aVar2.J(iArr, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取历史欺诈URL数据失败, case " + thD.getMessage());
                    return F.h();
                }
            }

            static final class e extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7650a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7651b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7652c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                e(int[] iArr, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7652c = iArr;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    e eVar = new e(this.f7652c, fVar);
                    eVar.f7651b = obj;
                    return eVar;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((e) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7650a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7652c;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            this.f7650a = 1;
                            obj = aVar2.L(iArr, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取历史屏幕共享数据失败, case " + thD.getMessage());
                    return F.h();
                }
            }

            static final class f extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7653a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7654b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7655c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                f(int[] iArr, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7655c = iArr;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    f fVar2 = new f(this.f7655c, fVar);
                    fVar2.f7654b = obj;
                    return fVar2;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((f) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7653a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7655c;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            this.f7653a = 1;
                            obj = aVar2.M(iArr, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取历史截屏数据失败， case " + thD.getMessage());
                    return F.h();
                }
            }

            static final class g extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7656a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7657b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7658c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                g(int[] iArr, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7658c = iArr;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    g gVar = new g(this.f7658c, fVar);
                    gVar.f7657b = obj;
                    return gVar;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((g) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7656a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7658c;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            Qa.l lVar = Qa.l.TYPE_FRAUD_CALL;
                            this.f7656a = 1;
                            obj = aVar2.N(lVar, iArr, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取历史SIM卡欺诈通话数据失败, case " + thD.getMessage());
                    return F.h();
                }
            }

            /* JADX INFO: renamed from: Pa.b$a$h$h, reason: collision with other inner class name */
            static final class C0094h extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7659a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f7660b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int[] f7661c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0094h(int[] iArr, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7661c = iArr;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    C0094h c0094h = new C0094h(this.f7661c, fVar);
                    c0094h.f7660b = obj;
                    return c0094h;
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((C0094h) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = p152kb.b.e();
                    int i10 = this.f7659a;
                    try {
                        if (i10 == 0) {
                            q.b(obj);
                            int[] iArr = this.f7661c;
                            eb.p.a aVar = p068eb.p.f38907b;
                            Ta.h.a aVar2 = Ta.h.f9148a;
                            this.f7659a = 1;
                            obj = aVar2.O(iArr, this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            q.b(obj);
                        }
                        objB = p068eb.p.b((Map) obj);
                    } catch (Throwable th) {
                        eb.p.a aVar3 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD == null) {
                        return objB;
                    }
                    Wa.b.a("FraudDetectionManager", "获取历史VoIP欺诈通话数据失败, case " + thD.getMessage());
                    return F.h();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            h(int[] iArr, p138jb.f fVar) {
                super(2, fVar);
                this.f7637d = iArr;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                h hVar = new h(this.f7637d, fVar);
                hVar.f7636c = obj;
                return hVar;
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((h) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objA;
                long j10;
                Object objB;
                String strM;
                Object objE = p152kb.b.e();
                int i10 = this.f7635b;
                try {
                    if (i10 == 0) {
                        q.b(obj);
                        O o10 = (O) this.f7636c;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        W[] wArr = {AbstractC0698k.b(o10, null, null, new f(this.f7637d, null), 3, null), AbstractC0698k.b(o10, null, null, new e(this.f7637d, null), 3, null), AbstractC0698k.b(o10, null, null, new c(this.f7637d, null), 3, null), AbstractC0698k.b(o10, null, null, new C0092a(this.f7637d, null), 3, null), AbstractC0698k.b(o10, null, null, new g(this.f7637d, null), 3, null), AbstractC0698k.b(o10, null, null, new C0094h(this.f7637d, null), 3, null), AbstractC0698k.b(o10, null, null, new d(this.f7637d, null), 3, null), AbstractC0698k.b(o10, null, null, new C0093b(this.f7637d, null), 3, null)};
                        this.f7636c = o10;
                        this.f7634a = jCurrentTimeMillis;
                        this.f7635b = 1;
                        objA = AbstractC0688f.a(wArr, this);
                        if (objA == objE) {
                            return objE;
                        }
                        j10 = jCurrentTimeMillis;
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j10 = this.f7634a;
                        q.b(obj);
                        objA = obj;
                    }
                    List list = (List) objA;
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    long j11 = jCurrentTimeMillis2 - j10;
                    Map map = (Map) list.get(0);
                    Map map2 = (Map) list.get(1);
                    Map map3 = (Map) list.get(2);
                    Map map4 = (Map) list.get(3);
                    Map map5 = (Map) list.get(4);
                    Map map6 = (Map) list.get(5);
                    Map map7 = (Map) list.get(6);
                    Object obj2 = list.get(7);
                    p278tb.n.d(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Int, kotlin.collections.Map<kotlin.Int, kotlin.Int>?>");
                    Map map8 = (Map) obj2;
                    Map map9 = (Map) map8.get(kotlin.coroutines.jvm.internal.b.b(Ta.b.EnumC0119b.FINANCIAL.b()));
                    Map map10 = (Map) map8.get(kotlin.coroutines.jvm.internal.b.b(Ta.b.EnumC0119b.LOAN.b()));
                    Map map11 = (Map) map8.get(kotlin.coroutines.jvm.internal.b.b(Ta.b.EnumC0119b.CONFERENCE.b()));
                    Map map12 = (Map) map8.get(kotlin.coroutines.jvm.internal.b.b(Ta.b.EnumC0119b.RISK.b()));
                    Map map13 = (Map) map8.get(kotlin.coroutines.jvm.internal.b.b(Ta.b.EnumC0119b.SUSPICIOUS.b()));
                    Map map14 = (Map) map8.get(kotlin.coroutines.jvm.internal.b.b(Ta.b.EnumC0119b.INDISTINGUISHABLE.b()));
                    long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis2;
                    PastFraudData pastFraudData = new PastFraudData(map, map2, map3, map4, map5, map6, map7, map9, map10, map11, map12, map13, map14);
                    try {
                        eb.p.a aVar = p068eb.p.f38907b;
                        objB = p068eb.p.b(GsonUtils.b(pastFraudData));
                    } catch (Throwable th) {
                        eb.p.a aVar2 = p068eb.p.f38907b;
                        objB = p068eb.p.b(q.a(th));
                    }
                    Throwable thD = p068eb.p.d(objB);
                    if (thD != null) {
                        Wa.b.b("FraudDetectionManager", "JSON序列化失败, case " + thD.getMessage());
                        objB = "";
                    }
                    String str = (String) objB;
                    long jCurrentTimeMillis4 = System.currentTimeMillis() - j10;
                    int length = str.length();
                    int[] iArr = this.f7637d;
                    if (iArr == null || (strM = AbstractC1942i.M(iArr, null, null, null, 0, null, null, 63, null)) == null) {
                        strM = "null";
                    }
                    Wa.b.a("FraudDetectionManager", Cb.g.p("getPastFraudResult性能统计:\n            |并发等待时间: " + j11 + "ms\n            |数据处理时间: " + jCurrentTimeMillis3 + "ms\n            |总耗时: " + jCurrentTimeMillis4 + "ms\n            |数据大小: " + length + "字符\n            |时间范围: " + strM + "\n            ", null, 1, null));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getPastFraudResult: ");
                    sb2.append(str);
                    Wa.b.a("FraudDetectionManager", sb2.toString());
                    return str;
                } catch (Exception e10) {
                    Wa.b.b("FraudDetectionManager", "getPastFraudResult error: " + e10);
                    return "";
                }
            }
        }

        static final class i extends kotlin.coroutines.jvm.internal.j implements p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f7662a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int[] f7663b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ p264sb.l f7664c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            i(int[] iArr, p264sb.l lVar, p138jb.f fVar) {
                super(2, fVar);
                this.f7663b = iArr;
                this.f7664c = lVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new i(this.f7663b, this.f7664c, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((i) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f7662a;
                try {
                    if (i10 == 0) {
                        q.b(obj);
                        a aVar = b.f7563a;
                        int[] iArr = this.f7663b;
                        this.f7662a = 1;
                        obj = aVar.g(iArr, this);
                        if (obj == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        q.b(obj);
                    }
                } catch (Exception e10) {
                    Wa.b.b("FraudDetectionManager", "getPastFraudResultAsync error: " + e10);
                }
                return w.f38919a;
            }
        }

        static final class j extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f7665a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f7667c;

            j(p138jb.f fVar) {
                super(fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.f7665a = obj;
                this.f7667c |= Integer.MIN_VALUE;
                return a.this.i(null, this);
            }
        }

        static final class k extends kotlin.coroutines.jvm.internal.j implements p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f7668a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            long f7669b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f7670c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private /* synthetic */ Object f7671d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ Context f7672e;

            /* JADX INFO: renamed from: Pa.b$a$k$a, reason: collision with other inner class name */
            static final class C0095a extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7673a;

                C0095a(p138jb.f fVar) {
                    super(2, fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    return new C0095a(fVar);
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((C0095a) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objE = p152kb.b.e();
                    int i10 = this.f7673a;
                    if (i10 == 0) {
                        q.b(obj);
                        a aVar = b.f7563a;
                        int[] iArrK = aVar.k();
                        int[] iArrE = aVar.e();
                        this.f7673a = 1;
                        obj = aVar.c(iArrK, iArrE, this);
                        if (obj == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        q.b(obj);
                    }
                    DurationFraudData durationFraudData = (DurationFraudData) GsonUtils.d((String) obj, DurationFraudData.class);
                    Wa.b.a("FraudDetectionManager", "getTrustStatusLocked durationFraudData: " + durationFraudData);
                    return durationFraudData;
                }
            }

            /* JADX INFO: renamed from: Pa.b$a$k$b, reason: collision with other inner class name */
            static final class C0096b extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7674a;

                C0096b(p138jb.f fVar) {
                    super(2, fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    return new C0096b(fVar);
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((C0096b) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    Object objE = p152kb.b.e();
                    int i10 = this.f7674a;
                    if (i10 == 0) {
                        q.b(obj);
                        a aVar = b.f7563a;
                        int[] iArrK = aVar.k();
                        this.f7674a = 1;
                        obj = aVar.g(iArrK, this);
                        if (obj == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        q.b(obj);
                    }
                    PastFraudData pastFraudData = (PastFraudData) GsonUtils.d((String) obj, PastFraudData.class);
                    Wa.b.a("FraudDetectionManager", "getTrustStatusLocked pastFraudData: " + pastFraudData);
                    return pastFraudData;
                }
            }

            static final class c extends kotlin.coroutines.jvm.internal.j implements p {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f7675a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ Context f7676b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(Context context, p138jb.f fVar) {
                    super(2, fVar);
                    this.f7676b = context;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final p138jb.f create(Object obj, p138jb.f fVar) {
                    return new c(this.f7676b, fVar);
                }

                @Override // p264sb.p
                public final Object invoke(O o10, p138jb.f fVar) {
                    return ((c) create(o10, fVar)).invokeSuspend(w.f38919a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    p152kb.b.e();
                    if (this.f7675a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.b(obj);
                    String strI = b.f7563a.f().i(this.f7676b, "score_cloud_config", "score_config");
                    Wa.b.a("FraudDetectionManager", "getTrustStatusLocked config: " + strI);
                    ScoreConfigBean scoreConfigBean = (ScoreConfigBean) GsonUtils.d(strI, ScoreConfigBean.class);
                    Wa.b.a("FraudDetectionManager", "getTrustStatusLocked scoreConfigBean: " + scoreConfigBean);
                    return scoreConfigBean;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            k(Context context, p138jb.f fVar) {
                super(2, fVar);
                this.f7672e = context;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                k kVar = new k(this.f7672e, fVar);
                kVar.f7671d = obj;
                return kVar;
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((k) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            /* JADX WARN: Code duplicated, block: B:31:0x00c6 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:32:0x00c7  */
            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                long jCurrentTimeMillis;
                W wB;
                Object objV;
                W w10;
                ScoreConfigBean scoreConfigBean;
                Object objV2;
                long j10;
                PastFraudData pastFraudData;
                Object objV3;
                PastFraudData pastFraudData2;
                ScoreConfigBean scoreConfigBean2;
                long j11;
                Object objE = p152kb.b.e();
                int i10 = this.f7670c;
                try {
                    if (i10 != 0) {
                        if (i10 == 1) {
                            long j12 = this.f7669b;
                            W w11 = (W) this.f7668a;
                            w10 = (W) this.f7671d;
                            q.b(obj);
                            objV = obj;
                            jCurrentTimeMillis = j12;
                            wB = w11;
                        } else if (i10 == 2) {
                            j10 = this.f7669b;
                            ScoreConfigBean scoreConfigBean3 = (ScoreConfigBean) this.f7668a;
                            wB = (W) this.f7671d;
                            q.b(obj);
                            scoreConfigBean = scoreConfigBean3;
                            objV2 = obj;
                            pastFraudData = (PastFraudData) objV2;
                            this.f7671d = scoreConfigBean;
                            this.f7668a = pastFraudData;
                            this.f7669b = j10;
                            this.f7670c = 3;
                            objV3 = wB.V(this);
                            if (objV3 == objE) {
                                return objE;
                            }
                            pastFraudData2 = pastFraudData;
                            long j13 = j10;
                            scoreConfigBean2 = scoreConfigBean;
                            j11 = j13;
                        } else {
                            if (i10 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            j11 = this.f7669b;
                            pastFraudData2 = (PastFraudData) this.f7668a;
                            scoreConfigBean2 = (ScoreConfigBean) this.f7671d;
                            q.b(obj);
                            objV3 = obj;
                        }
                        float fJ = b.f7563a.f().j(scoreConfigBean2, pastFraudData2, (DurationFraudData) objV3);
                        Wa.b.a("FraudDetectionManager", "getScoreResult score: " + fJ);
                        Wa.b.a("FraudDetectionManager", "getScoreResult cost time: " + (System.currentTimeMillis() - j11));
                        return GsonUtils.b(new FraudDetectionScore(String.valueOf(fJ)));
                    }
                    q.b(obj);
                    O o10 = (O) this.f7671d;
                    jCurrentTimeMillis = System.currentTimeMillis();
                    W wB2 = AbstractC0698k.b(o10, null, null, new c(this.f7672e, null), 3, null);
                    W wB3 = AbstractC0698k.b(o10, null, null, new C0096b(null), 3, null);
                    wB = AbstractC0698k.b(o10, null, null, new C0095a(null), 3, null);
                    this.f7671d = wB3;
                    this.f7668a = wB;
                    this.f7669b = jCurrentTimeMillis;
                    this.f7670c = 1;
                    objV = wB2.V(this);
                    if (objV == objE) {
                        return objE;
                    }
                    w10 = wB3;
                    scoreConfigBean = (ScoreConfigBean) objV;
                    this.f7671d = wB;
                    this.f7668a = scoreConfigBean;
                    this.f7669b = jCurrentTimeMillis;
                    this.f7670c = 2;
                    objV2 = w10.V(this);
                    if (objV2 == objE) {
                        return objE;
                    }
                    j10 = jCurrentTimeMillis;
                    pastFraudData = (PastFraudData) objV2;
                    this.f7671d = scoreConfigBean;
                    this.f7668a = pastFraudData;
                    this.f7669b = j10;
                    this.f7670c = 3;
                    objV3 = wB.V(this);
                    if (objV3 == objE) {
                        return objE;
                    }
                    pastFraudData2 = pastFraudData;
                    long j14 = j10;
                    scoreConfigBean2 = scoreConfigBean;
                    j11 = j14;
                    float fJ2 = b.f7563a.f().j(scoreConfigBean2, pastFraudData2, (DurationFraudData) objV3);
                    Wa.b.a("FraudDetectionManager", "getScoreResult score: " + fJ2);
                    Wa.b.a("FraudDetectionManager", "getScoreResult cost time: " + (System.currentTimeMillis() - j11));
                    return GsonUtils.b(new FraudDetectionScore(String.valueOf(fJ2)));
                } catch (Exception e10) {
                    Wa.b.b("FraudDetectionManager", "getScoreResult error: " + e10);
                    return "";
                }
            }
        }

        static final class l extends kotlin.coroutines.jvm.internal.j implements p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f7677a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Context f7678b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ p264sb.l f7679c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            l(Context context, p264sb.l lVar, p138jb.f fVar) {
                super(2, fVar);
                this.f7678b = context;
                this.f7679c = lVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new l(this.f7678b, this.f7679c, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((l) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f7677a;
                try {
                    if (i10 == 0) {
                        q.b(obj);
                        a aVar = b.f7563a;
                        Context context = this.f7678b;
                        this.f7677a = 1;
                        obj = aVar.i(context, this);
                        if (obj == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        q.b(obj);
                    }
                } catch (Exception e10) {
                    Wa.b.b("FraudDetectionManager", "getScoreResultAsync error: " + e10);
                }
                return w.f38919a;
            }
        }

        public /* synthetic */ a(p278tb.h hVar) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object a(p138jb.f fVar) {
            C0085a c0085a;
            if (fVar instanceof C0085a) {
                c0085a = (C0085a) fVar;
                int i10 = c0085a.f7569c;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    c0085a.f7569c = i10 - Integer.MIN_VALUE;
                } else {
                    c0085a = new C0085a(fVar);
                }
            } else {
                c0085a = new C0085a(fVar);
            }
            Object objE = c0085a.f7567a;
            Object objE2 = p152kb.b.e();
            int i11 = c0085a.f7569c;
            if (i11 == 0) {
                q.b(objE);
                C0086b c0086b = new C0086b(null);
                c0085a.f7569c = 1;
                objE = P.e(c0086b, c0085a);
                if (objE == objE2) {
                    return objE2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(objE);
            }
            p278tb.n.e(objE, "coroutineScope(...)");
            return objE;
        }

        public final void b(p264sb.l lVar) {
            p278tb.n.f(lVar, "callback");
            AbstractC0698k.d(P.a(C0687e0.b()), null, null, new c(lVar, null), 3, null);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object c(int[] iArr, int[] iArr2, p138jb.f fVar) {
            d dVar;
            if (fVar instanceof d) {
                dVar = (d) fVar;
                int i10 = dVar.f7593c;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    dVar.f7593c = i10 - Integer.MIN_VALUE;
                } else {
                    dVar = new d(fVar);
                }
            } else {
                dVar = new d(fVar);
            }
            Object objE = dVar.f7591a;
            Object objE2 = p152kb.b.e();
            int i11 = dVar.f7593c;
            if (i11 == 0) {
                q.b(objE);
                e eVar = new e(iArr, iArr2, null);
                dVar.f7593c = 1;
                objE = P.e(eVar, dVar);
                if (objE == objE2) {
                    return objE2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(objE);
            }
            p278tb.n.e(objE, "coroutineScope(...)");
            return objE;
        }

        public final void d(int[] iArr, int[] iArr2, p264sb.l lVar) {
            p278tb.n.f(lVar, "callback");
            AbstractC0698k.d(P.a(C0687e0.b()), null, null, new f(iArr, iArr2, lVar, null), 3, null);
        }

        public final int[] e() {
            return b.f7566d;
        }

        public final b f() {
            return (b) b.f7564b.getValue();
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object g(int[] iArr, p138jb.f fVar) {
            g gVar;
            if (fVar instanceof g) {
                gVar = (g) fVar;
                int i10 = gVar.f7633c;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    gVar.f7633c = i10 - Integer.MIN_VALUE;
                } else {
                    gVar = new g(fVar);
                }
            } else {
                gVar = new g(fVar);
            }
            Object objE = gVar.f7631a;
            Object objE2 = p152kb.b.e();
            int i11 = gVar.f7633c;
            if (i11 == 0) {
                q.b(objE);
                h hVar = new h(iArr, null);
                gVar.f7633c = 1;
                objE = P.e(hVar, gVar);
                if (objE == objE2) {
                    return objE2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(objE);
            }
            p278tb.n.e(objE, "coroutineScope(...)");
            return objE;
        }

        public final void h(int[] iArr, p264sb.l lVar) {
            p278tb.n.f(lVar, "callback");
            AbstractC0698k.d(P.a(C0687e0.b()), null, null, new i(iArr, lVar, null), 3, null);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object i(Context context, p138jb.f fVar) {
            j jVar;
            if (fVar instanceof j) {
                jVar = (j) fVar;
                int i10 = jVar.f7667c;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    jVar.f7667c = i10 - Integer.MIN_VALUE;
                } else {
                    jVar = new j(fVar);
                }
            } else {
                jVar = new j(fVar);
            }
            Object objE = jVar.f7665a;
            Object objE2 = p152kb.b.e();
            int i11 = jVar.f7667c;
            if (i11 == 0) {
                q.b(objE);
                k kVar = new k(context, null);
                jVar.f7667c = 1;
                objE = P.e(kVar, jVar);
                if (objE == objE2) {
                    return objE2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(objE);
            }
            p278tb.n.e(objE, "coroutineScope(...)");
            return objE;
        }

        public final void j(Context context, p264sb.l lVar) {
            p278tb.n.f(context, "mContext");
            p278tb.n.f(lVar, "callback");
            AbstractC0698k.d(P.a(C0687e0.b()), null, null, new l(context, lVar, null), 3, null);
        }

        public final int[] k() {
            return b.f7565c;
        }

        private a() {
        }
    }

    private b() {
    }

    public static final void e(p264sb.l lVar) {
        f7563a.b(lVar);
    }

    public static final void f(int[] iArr, int[] iArr2, p264sb.l lVar) {
        f7563a.d(iArr, iArr2, lVar);
    }

    public static final void h(int[] iArr, p264sb.l lVar) {
        f7563a.h(iArr, lVar);
    }

    public static final void k(Context context, p264sb.l lVar) {
        f7563a.j(context, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b l() {
        return new b();
    }

    public final byte[] g() {
        return new byte[]{0, 0};
    }

    public final String i(Context context, String str, String str2) {
        p278tb.n.f(context, "context");
        p278tb.n.f(str, "key");
        p278tb.n.f(str2, "module");
        String strA = Ta.a.a(context.getContentResolver(), str, str2, null);
        Log.i("FraudDetectionManager", "cloud config data is empty: " + TextUtils.isEmpty(strA));
        return TextUtils.isEmpty(strA) ? c.a(context, "score_config.json") : strA;
    }

    public final float j(ScoreConfigBean scoreConfigBean, PastFraudData pastFraudData, DurationFraudData durationFraudData) {
        Map<Integer, Map<Integer, Integer>> durationMap;
        Map<Integer, Integer> mapH;
        Map<Integer, Integer> eventMap;
        Integer num;
        double d10 = 0.0d;
        if (scoreConfigBean != null) {
            try {
                for (ScoreConfigBean.TimeWindowsBean timeWindowsBean : scoreConfigBean.getTimeWindows()) {
                    int timeWindow = timeWindowsBean.getTimeWindow();
                    double wight = timeWindowsBean.getWight();
                    Wa.b.a("FraudDetectionManager", ">>>>>>>>>>>  getScoreResult timeWindow: " + timeWindow + ", weight: " + wight);
                    float score = 0.0f;
                    for (ScoreConfigBean.EventListBean eventListBean : scoreConfigBean.getEventList()) {
                        String eventName = eventListBean.getEventName();
                        int eventScore = eventListBean.getEventScore();
                        if (pastFraudData != null) {
                            p278tb.n.c(eventName);
                            eventMap = pastFraudData.getEventMap(eventName);
                        } else {
                            eventMap = null;
                        }
                        Wa.b.a("FraudDetectionManager", "getScoreResult pastEvent: " + eventName + ", windowScore " + score + ", eventScore: " + eventScore + ", eventMap " + eventMap);
                        if (eventMap != null && (num = eventMap.get(Integer.valueOf(timeWindow))) != null && num.intValue() == 1) {
                            score += eventScore;
                            Wa.b.a("FraudDetectionManager", "++++++++++ getScoreResult add windowScore 1: " + score);
                        }
                        pastFraudData = pastFraudData;
                    }
                    Iterator<ScoreConfigBean.EventTimeListBean> it = scoreConfigBean.getEventTimeList().iterator();
                    while (it.hasNext()) {
                        ScoreConfigBean.EventTimeListBean next = it.next();
                        String eventName2 = next.getEventName();
                        if (durationFraudData != null) {
                            p278tb.n.c(eventName2);
                            durationMap = durationFraudData.getDurationMap(eventName2);
                        } else {
                            durationMap = null;
                        }
                        if (durationMap == null || (mapH = durationMap.get(Integer.valueOf(timeWindow))) == null) {
                            mapH = F.h();
                        }
                        StringBuilder sb2 = new StringBuilder();
                        Iterator<ScoreConfigBean.EventTimeListBean> it2 = it;
                        sb2.append("getScoreResult durationEvent: ");
                        sb2.append(eventName2);
                        sb2.append(", durationMap ");
                        sb2.append(durationMap);
                        sb2.append(", timeWindowDurationMap: ");
                        sb2.append(mapH);
                        Wa.b.a("FraudDetectionManager", sb2.toString());
                        Iterator<ScoreConfigBean.EventTimeListBean.EventTimeScoreBean> it3 = next.getEventTimeScore().iterator();
                        while (it3.hasNext()) {
                            ScoreConfigBean.EventTimeListBean.EventTimeScoreBean next2 = it3.next();
                            int time = next2.getTime();
                            int score2 = next2.getScore();
                            StringBuilder sb3 = new StringBuilder();
                            Iterator<ScoreConfigBean.EventTimeListBean.EventTimeScoreBean> it4 = it3;
                            sb3.append("getScoreResult durationEvent:, durationType: ");
                            sb3.append(time);
                            sb3.append(", durationScore: ");
                            sb3.append(score2);
                            sb3.append(" windowScore: ");
                            sb3.append(score);
                            Wa.b.a("FraudDetectionManager", sb3.toString());
                            Integer num2 = mapH.get(Integer.valueOf(next2.getTime()));
                            if (num2 != null && num2.intValue() == 1) {
                                score += next2.getScore();
                                Wa.b.a("FraudDetectionManager", "++++++++ getScoreResult add windowScore 2: " + score);
                            }
                            it3 = it4;
                        }
                        it = it2;
                    }
                    d10 += ((double) score) * wight;
                    Wa.b.a("FraudDetectionManager", "<<<<<<<<<<<  getScoreResult totalScore: " + d10 + ", windowScore " + score + ",windowWeight " + wight + " ");
                }
            } catch (Exception e10) {
                Wa.b.b("FraudDetectionManager", "getScoreResult error: " + e10);
            }
        }
        return (float) d10;
    }
}
