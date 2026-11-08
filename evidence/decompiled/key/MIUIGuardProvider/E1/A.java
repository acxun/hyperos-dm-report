package E1;

import Y3.InterfaceC0715f;
import android.content.Context;
import android.util.Log;
import com.miui.guardprovider.sdk.android.db.J1;
import com.miui.guardprovider.sdk.android.pojo.BlackGrayInfo;
import com.miui.guardprovider.sdk.android.pojo.ThreatInfo;
import com.miui.guardprovider.sdk.android.work.ReportWorker;
import com.xiaomi.onetrack.util.aa;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;
import p045g2.AbstractC0962q;
import p078l0.C0993d;
import p078l0.EnumC0990a;
import p078l0.I;
import p135u2.AbstractC1069h;

/* JADX INFO: loaded from: classes.dex */
public final class A implements A1.f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f1010m = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f1011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final E1.e f1012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x f1013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final G1.a f1014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final C0445c f1015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k f1016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final F1.i f1017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final J1 f1018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final I f1019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f1020j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.google.gson.e f1021k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private A1.e f1022l;

    public static final class a {
        public /* synthetic */ a(AbstractC1069h abstractC1069h) {
            this();
        }

        private a() {
        }
    }

    static final class b extends p080l2.d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f1023e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f1024f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f1025g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f1026h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f1027i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f1029k;

        b(p066j2.e eVar) {
            super(eVar);
        }

        @Override // p080l2.a
        public final Object A(Object obj) {
            this.f1027i = obj;
            this.f1029k |= Integer.MIN_VALUE;
            return A.this.b(null, this);
        }
    }

    static final class c extends p080l2.l implements p129t2.q {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1030f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f1031g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f1032h;

        c(p066j2.e eVar) {
            super(3, eVar);
        }

        @Override // p080l2.a
        public final Object A(Object obj) {
            com.miui.guardprovider.sdk.android.pojo.a aVar = (com.miui.guardprovider.sdk.android.pojo.a) this.f1031g;
            com.miui.guardprovider.sdk.android.pojo.a aVar2 = (com.miui.guardprovider.sdk.android.pojo.a) this.f1032h;
            p073k2.b.e();
            if (this.f1030f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p038f2.s.b(obj);
            Log.i("RealScanner", "Scan result:(" + aVar2 + aa.f14258b + aVar + ")");
            A.this.h(aVar2);
            return A.this.i(aVar, aVar2);
        }

        @Override // p129t2.q
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public final Object l(com.miui.guardprovider.sdk.android.pojo.a aVar, com.miui.guardprovider.sdk.android.pojo.a aVar2, p066j2.e eVar) {
            c cVar = A.this.new c(eVar);
            cVar.f1031g = aVar;
            cVar.f1032h = aVar2;
            return cVar.A(p038f2.D.f14789a);
        }
    }

    static final class d implements InterfaceC0715f {
        d() {
        }

        @Override // Y3.InterfaceC0715f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object b(com.miui.guardprovider.sdk.android.pojo.a aVar, p066j2.e eVar) {
            Objects.toString(aVar);
            A.this.h(aVar);
            return p038f2.D.f14789a;
        }
    }

    static final class e extends p080l2.l implements p129t2.q {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f1035f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f1036g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private /* synthetic */ Object f1037h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f1038i;

        e(p066j2.e eVar) {
            super(3, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x008b, code lost:
        
            if (Y3.AbstractC0716g.m(r3, (Y3.InterfaceC0714e) r9, r8) == r2) goto L19;
         */
        @Override // p080l2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object A(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = r8.f1037h
                Y3.f r0 = (Y3.InterfaceC0715f) r0
                java.lang.Object r1 = r8.f1038i
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                java.lang.Object r2 = p073k2.b.e()
                int r3 = r8.f1036g
                r4 = 0
                r5 = 2
                r6 = 1
                if (r3 == 0) goto L2c
                if (r3 == r6) goto L24
                if (r3 != r5) goto L1c
                p038f2.s.b(r9)
                goto L8e
            L1c:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L24:
                java.lang.Object r3 = r8.f1035f
                Y3.f r3 = (Y3.InterfaceC0715f) r3
                p038f2.s.b(r9)
                goto L75
            L2c:
                p038f2.s.b(r9)
                java.lang.String r9 = r1.getMessage()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r7 = "Cloud scan has something wrong:"
                r3.append(r7)
                r3.append(r9)
                java.lang.String r9 = r3.toString()
                java.lang.String r3 = "RealScanner"
                android.util.Log.e(r3, r9, r1)
                E1.A r9 = E1.A.this
                E1.x r9 = E1.A.f(r9)
                E1.A r3 = E1.A.this
                A1.e r3 = E1.A.g(r3)
                if (r3 != 0) goto L5d
                java.lang.String r3 = "pipeline"
                p135u2.m.r(r3)
                r3 = r4
            L5d:
                java.lang.Object r7 = p080l2.k.a(r0)
                r8.f1037h = r7
                java.lang.Object r7 = p080l2.k.a(r1)
                r8.f1038i = r7
                r8.f1035f = r0
                r8.f1036g = r6
                java.lang.Object r9 = r9.a(r3, r8)
                if (r9 != r2) goto L74
                goto L8d
            L74:
                r3 = r0
            L75:
                Y3.e r9 = (Y3.InterfaceC0714e) r9
                java.lang.Object r0 = p080l2.k.a(r0)
                r8.f1037h = r0
                java.lang.Object r0 = p080l2.k.a(r1)
                r8.f1038i = r0
                r8.f1035f = r4
                r8.f1036g = r5
                java.lang.Object r8 = Y3.AbstractC0716g.m(r3, r9, r8)
                if (r8 != r2) goto L8e
            L8d:
                return r2
            L8e:
                f2.D r8 = p038f2.D.f14789a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: E1.A.e.A(java.lang.Object):java.lang.Object");
        }

        @Override // p129t2.q
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public final Object l(InterfaceC0715f interfaceC0715f, Throwable th, p066j2.e eVar) {
            e eVar2 = A.this.new e(eVar);
            eVar2.f1037h = interfaceC0715f;
            eVar2.f1038i = th;
            return eVar2.A(p038f2.D.f14789a);
        }
    }

    public A(f fVar, E1.e eVar, x xVar, G1.a aVar, C0445c c0445c, k kVar, F1.i iVar, J1 j6, I i6, Context context, com.google.gson.e eVar2) {
        p135u2.m.e(fVar, "codeScanner");
        p135u2.m.e(eVar, "cloudScanner");
        p135u2.m.e(xVar, "matcherScanner");
        p135u2.m.e(aVar, "cacheInterceptor");
        p135u2.m.e(c0445c, "behaviorScanner");
        p135u2.m.e(kVar, "fakeAppScanner");
        p135u2.m.e(iVar, "updateApi");
        p135u2.m.e(j6, "versionManager");
        p135u2.m.e(i6, "workManager");
        p135u2.m.e(context, "context");
        p135u2.m.e(eVar2, "gson");
        this.f1011a = fVar;
        this.f1012b = eVar;
        this.f1013c = xVar;
        this.f1014d = aVar;
        this.f1015e = c0445c;
        this.f1016f = kVar;
        this.f1017g = iVar;
        this.f1018h = j6;
        this.f1019i = i6;
        this.f1020j = context;
        this.f1021k = eVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(com.miui.guardprovider.sdk.android.pojo.a aVar) {
        if ((aVar instanceof com.miui.guardprovider.sdk.android.pojo.q) || (aVar instanceof com.miui.guardprovider.sdk.android.pojo.f)) {
            p038f2.q[] qVarArr = {p038f2.w.a("reportData", this.f1021k.u(aVar)), p038f2.w.a("uuid", w.f1317a.a())};
            androidx.work.b.a aVar2 = new androidx.work.b.a();
            for (int i6 = 0; i6 < 2; i6++) {
                p038f2.q qVar = qVarArr[i6];
                aVar2.b((String) qVar.c(), qVar.d());
            }
            this.f1019i.b((p078l0.t) ((l0.t.a) ((l0.t.a) ((l0.t.a) ((l0.t.a) new l0.t.a(ReportWorker.class).j(new C0993d.a().c(true).b(p078l0.r.CONNECTED).a())).i(EnumC0990a.LINEAR, 2L, TimeUnit.HOURS)).a("ReportWorker")).l(aVar2.a())).b());
        }
    }

    @Override // A1.f, A1.c
    public Object a(A1.e eVar, p066j2.e eVar2) {
        this.f1022l = eVar;
        return super.a(eVar, eVar2);
    }

    @Override // A1.f
    public /* bridge */ A1.f c(UnaryOperator unaryOperator) {
        return super.c(unaryOperator);
    }

    public final com.miui.guardprovider.sdk.android.pojo.a i(com.miui.guardprovider.sdk.android.pojo.a aVar, com.miui.guardprovider.sdk.android.pojo.a aVar2) {
        List<ThreatInfo> listK;
        List<BlackGrayInfo> listK2;
        ArrayList arrayList;
        ArrayList arrayList2;
        List<BlackGrayInfo> blackGrayInfo;
        List<ThreatInfo> threatInfo;
        p135u2.m.e(aVar, "matchResult");
        p135u2.m.e(aVar2, com.xiaomi.onetrack.g.a.f14180d);
        com.miui.guardprovider.sdk.android.pojo.q qVar = aVar instanceof com.miui.guardprovider.sdk.android.pojo.q ? (com.miui.guardprovider.sdk.android.pojo.q) aVar : null;
        if (qVar == null || (listK = qVar.getThreatInfo()) == null) {
            listK = AbstractC0962q.k();
        }
        ArrayList arrayList3 = new ArrayList(listK);
        com.miui.guardprovider.sdk.android.pojo.f fVar = aVar instanceof com.miui.guardprovider.sdk.android.pojo.f ? (com.miui.guardprovider.sdk.android.pojo.f) aVar : null;
        if (fVar == null || (listK2 = fVar.getBlackGrayInfo()) == null) {
            listK2 = AbstractC0962q.k();
        }
        ArrayList arrayList4 = new ArrayList(listK2);
        com.miui.guardprovider.sdk.android.pojo.q qVar2 = aVar2 instanceof com.miui.guardprovider.sdk.android.pojo.q ? (com.miui.guardprovider.sdk.android.pojo.q) aVar2 : null;
        if (qVar2 == null || (threatInfo = qVar2.getThreatInfo()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object obj : threatInfo) {
                if (((ThreatInfo) obj).isIntercept$flamingo_android_cnRelease()) {
                    arrayList.add(obj);
                }
            }
        }
        com.miui.guardprovider.sdk.android.pojo.f fVar2 = aVar2 instanceof com.miui.guardprovider.sdk.android.pojo.f ? (com.miui.guardprovider.sdk.android.pojo.f) aVar2 : null;
        if (fVar2 == null || (blackGrayInfo = fVar2.getBlackGrayInfo()) == null) {
            arrayList2 = null;
        } else {
            arrayList2 = new ArrayList();
            for (Object obj2 : blackGrayInfo) {
                if (((BlackGrayInfo) obj2).isIntercept$flamingo_android_cnRelease()) {
                    arrayList2.add(obj2);
                }
            }
        }
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        if (arrayList2 != null) {
            arrayList4.addAll(arrayList2);
        }
        com.miui.guardprovider.sdk.android.pojo.a aVarK = com.miui.guardprovider.sdk.android.pojo.d.k(aVar);
        if (arrayList3.isEmpty()) {
            arrayList3 = null;
        }
        return com.miui.guardprovider.sdk.android.pojo.d.e(aVarK, arrayList3, arrayList4.isEmpty() ? null : arrayList4, aVar2 instanceof com.miui.guardprovider.sdk.android.pojo.k);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:30:0x0102  */
    /* JADX WARN: Code duplicated, block: B:33:0x010c  */
    /* JADX WARN: Code duplicated, block: B:36:0x012f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0135  */
    /* JADX WARN: Code duplicated, block: B:42:0x0150  */
    /* JADX WARN: Code duplicated, block: B:47:0x0179  */
    /* JADX WARN: Code duplicated, block: B:50:0x0186  */
    /* JADX WARN: Code duplicated, block: B:52:0x018c  */
    /* JADX WARN: Code duplicated, block: B:56:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:60:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0171, code lost:
    
        if (((Y3.InterfaceC0714e) r13).a(r7, r0) == r1) goto L59;
     */
    @Override // A1.f
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(Y3.InterfaceC0714e r12, p066j2.e r13) {
        /*
            Method dump skipped, instruction units count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: E1.A.b(Y3.e, j2.e):java.lang.Object");
    }
}
