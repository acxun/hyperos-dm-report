package Ta;

import Fb.AbstractC0694i;
import Fb.C0687e0;
import Fb.C0708p;
import Fb.InterfaceC0704n;
import Fb.O;
import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import miui.os.Build;
import miui.yellowpage.YellowPageUtils;
import p068eb.w;
import p096gb.AbstractC1948o;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9148a = new a(null);

    public static final class a {

        /* JADX INFO: renamed from: Ta.h$a$a, reason: collision with other inner class name */
        public static final class C0120a implements Qa.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int[] f9149a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int[] f9150b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ InterfaceC0704n f9151c;

            C0120a(int[] iArr, int[] iArr2, InterfaceC0704n interfaceC0704n) {
                this.f9149a = iArr;
                this.f9150b = iArr2;
                this.f9151c = interfaceC0704n;
            }

            @Override // Qa.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(List list) {
                if (list != null) {
                    this.f9151c.resumeWith(p068eb.p.b(a.m(h.f9148a, list, Qa.e.ScreenShareInfo, this.f9149a, this.f9150b, 0L, 16, null)));
                }
            }
        }

        public static final class b implements Qa.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Qa.e f9152a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int[] f9153b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int[] f9154c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ InterfaceC0704n f9155d;

            b(Qa.e eVar, int[] iArr, int[] iArr2, InterfaceC0704n interfaceC0704n) {
                this.f9152a = eVar;
                this.f9153b = iArr;
                this.f9154c = iArr2;
                this.f9155d = interfaceC0704n;
            }

            @Override // Qa.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(List list) {
                if (list != null) {
                    this.f9155d.resumeWith(p068eb.p.b(a.m(h.f9148a, list, this.f9152a, this.f9153b, this.f9154c, 0L, 16, null)));
                }
            }
        }

        public static final class c implements Qa.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int[] f9156a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int[] f9157b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ InterfaceC0704n f9158c;

            c(int[] iArr, int[] iArr2, InterfaceC0704n interfaceC0704n) {
                this.f9156a = iArr;
                this.f9157b = iArr2;
                this.f9158c = interfaceC0704n;
            }

            @Override // Qa.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(List list) {
                if (list != null) {
                    this.f9158c.resumeWith(p068eb.p.b(a.m(h.f9148a, list, Qa.e.VoipRecordInfo, this.f9156a, this.f9157b, 0L, 16, null)));
                }
            }
        }

        public static final class d implements Qa.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int[] f9159a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ InterfaceC0704n f9160b;

            d(int[] iArr, InterfaceC0704n interfaceC0704n) {
                this.f9159a = iArr;
                this.f9160b = interfaceC0704n;
            }

            @Override // Qa.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(List list) {
                if (list != null) {
                    this.f9160b.resumeWith(p068eb.p.b(a.p(h.f9148a, list, Qa.e.FraudUrlInfo, this.f9159a, 0L, 8, null)));
                }
            }
        }

        public static final class e implements Qa.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int[] f9161a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ InterfaceC0704n f9162b;

            e(int[] iArr, InterfaceC0704n interfaceC0704n) {
                this.f9161a = iArr;
                this.f9162b = interfaceC0704n;
            }

            @Override // Qa.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(List list) {
                if (list != null) {
                    int[] iArr = this.f9161a;
                    InterfaceC0704n interfaceC0704n = this.f9162b;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Qa.b bVar = (Qa.b) it.next();
                        Integer numI = bVar.i();
                        int iB = Ta.b.EnumC0119b.FINANCIAL.b();
                        if (numI != null && numI.intValue() == iB) {
                            arrayList.add(bVar);
                        } else {
                            int iB2 = Ta.b.EnumC0119b.LOAN.b();
                            if (numI != null && numI.intValue() == iB2) {
                                arrayList2.add(bVar);
                            } else {
                                int iB3 = Ta.b.EnumC0119b.CONFERENCE.b();
                                if (numI != null && numI.intValue() == iB3) {
                                    arrayList3.add(bVar);
                                } else {
                                    int iB4 = Ta.b.EnumC0119b.RISK.b();
                                    if (numI != null && numI.intValue() == iB4) {
                                        arrayList4.add(bVar);
                                    } else {
                                        int iB5 = Ta.b.EnumC0119b.SUSPICIOUS.b();
                                        if (numI != null && numI.intValue() == iB5) {
                                            arrayList5.add(bVar);
                                        } else {
                                            int iB6 = Ta.b.EnumC0119b.INDISTINGUISHABLE.b();
                                            if (numI != null && numI.intValue() == iB6) {
                                                arrayList6.add(bVar);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    a aVar = h.f9148a;
                    Qa.e eVar = Qa.e.AppInfo;
                    Map mapP = a.p(aVar, arrayList, eVar, iArr, 0L, 8, null);
                    Map mapP2 = a.p(aVar, arrayList2, eVar, iArr, 0L, 8, null);
                    Map mapP3 = a.p(aVar, arrayList3, eVar, iArr, 0L, 8, null);
                    Map mapP4 = a.p(aVar, arrayList4, eVar, iArr, 0L, 8, null);
                    Map mapP5 = a.p(aVar, arrayList5, eVar, iArr, 0L, 8, null);
                    Map mapP6 = a.p(aVar, arrayList6, eVar, iArr, 0L, 8, null);
                    linkedHashMap.put(Integer.valueOf(Ta.b.EnumC0119b.FINANCIAL.b()), mapP);
                    linkedHashMap.put(Integer.valueOf(Ta.b.EnumC0119b.LOAN.b()), mapP2);
                    linkedHashMap.put(Integer.valueOf(Ta.b.EnumC0119b.CONFERENCE.b()), mapP3);
                    linkedHashMap.put(Integer.valueOf(Ta.b.EnumC0119b.RISK.b()), mapP4);
                    linkedHashMap.put(Integer.valueOf(Ta.b.EnumC0119b.SUSPICIOUS.b()), mapP5);
                    linkedHashMap.put(Integer.valueOf(Ta.b.EnumC0119b.INDISTINGUISHABLE.b()), mapP6);
                    interfaceC0704n.resumeWith(p068eb.p.b(linkedHashMap));
                }
            }
        }

        public static final class f implements Qa.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int[] f9163a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ InterfaceC0704n f9164b;

            f(int[] iArr, InterfaceC0704n interfaceC0704n) {
                this.f9163a = iArr;
                this.f9164b = interfaceC0704n;
            }

            @Override // Qa.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(List list) {
                if (list != null) {
                    this.f9164b.resumeWith(p068eb.p.b(a.p(h.f9148a, list, Qa.e.AirplaneModeInfo, this.f9163a, 0L, 8, null)));
                }
            }
        }

        public static final class g implements Qa.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int[] f9165a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ InterfaceC0704n f9166b;

            g(int[] iArr, InterfaceC0704n interfaceC0704n) {
                this.f9165a = iArr;
                this.f9166b = interfaceC0704n;
            }

            @Override // Qa.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(List list) {
                if (list != null) {
                    this.f9166b.resumeWith(p068eb.p.b(a.p(h.f9148a, list, Qa.e.CallForwardingInfo, this.f9165a, 0L, 8, null)));
                }
            }
        }

        /* JADX INFO: renamed from: Ta.h$a$h, reason: collision with other inner class name */
        public static final class C0121h implements Qa.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int[] f9167a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ InterfaceC0704n f9168b;

            C0121h(int[] iArr, InterfaceC0704n interfaceC0704n) {
                this.f9167a = iArr;
                this.f9168b = interfaceC0704n;
            }

            @Override // Qa.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(List list) {
                if (list != null) {
                    this.f9168b.resumeWith(p068eb.p.b(a.p(h.f9148a, list, Qa.e.ScreenShareInfo, this.f9167a, 0L, 8, null)));
                }
            }
        }

        public static final class i implements Qa.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int[] f9169a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ InterfaceC0704n f9170b;

            i(int[] iArr, InterfaceC0704n interfaceC0704n) {
                this.f9169a = iArr;
                this.f9170b = interfaceC0704n;
            }

            @Override // Qa.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(List list) {
                if (list != null) {
                    this.f9170b.resumeWith(p068eb.p.b(a.p(h.f9148a, list, Qa.e.ScreenshotInfo, this.f9169a, 0L, 8, null)));
                }
            }
        }

        public static final class j implements Qa.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int[] f9171a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ InterfaceC0704n f9172b;

            j(int[] iArr, InterfaceC0704n interfaceC0704n) {
                this.f9171a = iArr;
                this.f9172b = interfaceC0704n;
            }

            @Override // Qa.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(List list) {
                if (list != null) {
                    this.f9172b.resumeWith(p068eb.p.b(a.p(h.f9148a, list, Qa.e.SimCardFraudInfo, this.f9171a, 0L, 8, null)));
                }
            }
        }

        public static final class k implements Qa.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int[] f9173a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ InterfaceC0704n f9174b;

            k(int[] iArr, InterfaceC0704n interfaceC0704n) {
                this.f9173a = iArr;
                this.f9174b = interfaceC0704n;
            }

            @Override // Qa.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(List list) {
                if (list != null) {
                    this.f9174b.resumeWith(p068eb.p.b(a.p(h.f9148a, list, Qa.e.VoipRecordInfo, this.f9173a, 0L, 8, null)));
                }
            }
        }

        static final class l extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f9175a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int[] f9176b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int[] f9177c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            l(int[] iArr, int[] iArr2, p138jb.f fVar) {
                super(2, fVar);
                this.f9176b = iArr;
                this.f9177c = iArr2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new l(this.f9176b, this.f9177c, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((l) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f9175a;
                if (i10 == 0) {
                    p068eb.q.b(obj);
                    a aVar = h.f9148a;
                    int[] iArr = this.f9176b;
                    int[] iArr2 = this.f9177c;
                    this.f9175a = 1;
                    obj = aVar.q(iArr, iArr2, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p068eb.q.b(obj);
                }
                Map map = (Map) obj;
                Wa.b.a("PastFraudUtil", "getDurationScreenShareResult: " + map);
                return map;
            }
        }

        static final class m extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f9178a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Qa.l f9179b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Qa.e f9180c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int[] f9181d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ int[] f9182e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            m(Qa.l lVar, Qa.e eVar, int[] iArr, int[] iArr2, p138jb.f fVar) {
                super(2, fVar);
                this.f9179b = lVar;
                this.f9180c = eVar;
                this.f9181d = iArr;
                this.f9182e = iArr2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new m(this.f9179b, this.f9180c, this.f9181d, this.f9182e, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((m) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f9178a;
                if (i10 == 0) {
                    p068eb.q.b(obj);
                    a aVar = h.f9148a;
                    Qa.l lVar = this.f9179b;
                    Qa.e eVar = this.f9180c;
                    int[] iArr = this.f9181d;
                    int[] iArr2 = this.f9182e;
                    this.f9178a = 1;
                    obj = aVar.r(lVar, eVar, iArr, iArr2, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p068eb.q.b(obj);
                }
                Map map = (Map) obj;
                Wa.b.a("PastFraudUtil", "getDurationSimCardCallResult: " + map);
                return map;
            }
        }

        static final class n extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f9183a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Qa.o f9184b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int[] f9185c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int[] f9186d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            n(Qa.o oVar, int[] iArr, int[] iArr2, p138jb.f fVar) {
                super(2, fVar);
                this.f9184b = oVar;
                this.f9185c = iArr;
                this.f9186d = iArr2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new n(this.f9184b, this.f9185c, this.f9186d, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((n) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f9183a;
                if (i10 == 0) {
                    p068eb.q.b(obj);
                    a aVar = h.f9148a;
                    Qa.o oVar = this.f9184b;
                    int[] iArr = this.f9185c;
                    int[] iArr2 = this.f9186d;
                    this.f9183a = 1;
                    obj = aVar.s(oVar, iArr, iArr2, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p068eb.q.b(obj);
                }
                Map map = (Map) obj;
                Wa.b.a("PastFraudUtil", "getDurationVoipResult: " + map);
                return map;
            }
        }

        static final class o extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f9187a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int[] f9188b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            o(int[] iArr, p138jb.f fVar) {
                super(2, fVar);
                this.f9188b = iArr;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new o(this.f9188b, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((o) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f9187a;
                if (i10 == 0) {
                    p068eb.q.b(obj);
                    Wa.b.a("PastFraudUtil", "getPastAirplaneModeResult---> start");
                    a aVar = h.f9148a;
                    int[] iArr = this.f9188b;
                    this.f9187a = 1;
                    obj = aVar.v(iArr, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p068eb.q.b(obj);
                }
                Map map = (Map) obj;
                Wa.b.a("PastFraudUtil", "getPastAirplaneModeResult end : " + map);
                return map;
            }
        }

        static final class p extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f9189a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int[] f9190b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            p(int[] iArr, p138jb.f fVar) {
                super(2, fVar);
                this.f9190b = iArr;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new p(this.f9190b, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((p) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f9189a;
                if (i10 == 0) {
                    p068eb.q.b(obj);
                    Wa.b.a("PastFraudUtil", "getPastCallForwardingResult---> start");
                    a aVar = h.f9148a;
                    int[] iArr = this.f9190b;
                    this.f9189a = 1;
                    obj = aVar.w(iArr, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p068eb.q.b(obj);
                }
                Map map = (Map) obj;
                Wa.b.a("PastFraudUtil", "getPastCallForwardingResult: " + map);
                return map;
            }
        }

        static final class q extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f9191a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int[] f9192b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            q(int[] iArr, p138jb.f fVar) {
                super(2, fVar);
                this.f9192b = iArr;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new q(this.f9192b, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((q) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f9191a;
                if (i10 == 0) {
                    p068eb.q.b(obj);
                    Wa.b.a("PastFraudUtil", "getPastFraudUrlResult---> start");
                    a aVar = h.f9148a;
                    int[] iArr = this.f9192b;
                    this.f9191a = 1;
                    obj = aVar.t(iArr, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p068eb.q.b(obj);
                }
                Map map = (Map) obj;
                Wa.b.a("PastFraudUtil", "getPastFraudUrlResult end : " + map);
                return map;
            }
        }

        static final class r extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f9193a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int[] f9194b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            r(int[] iArr, p138jb.f fVar) {
                super(2, fVar);
                this.f9194b = iArr;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new r(this.f9194b, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((r) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f9193a;
                if (i10 == 0) {
                    p068eb.q.b(obj);
                    Wa.b.a("PastFraudUtil", "getPastInstallAppResult---> start");
                    a aVar = h.f9148a;
                    int[] iArr = this.f9194b;
                    this.f9193a = 1;
                    obj = aVar.u(iArr, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p068eb.q.b(obj);
                }
                Map map = (Map) obj;
                Wa.b.a("PastFraudUtil", "getPastInstallAppResult end : " + map);
                return map;
            }
        }

        static final class s extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f9195a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int[] f9196b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            s(int[] iArr, p138jb.f fVar) {
                super(2, fVar);
                this.f9196b = iArr;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new s(this.f9196b, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((s) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f9195a;
                if (i10 == 0) {
                    p068eb.q.b(obj);
                    a aVar = h.f9148a;
                    int[] iArr = this.f9196b;
                    this.f9195a = 1;
                    obj = aVar.x(iArr, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p068eb.q.b(obj);
                }
                Map map = (Map) obj;
                Wa.b.a("PastFraudUtil", "getPastScreenShareResult: " + map);
                return map;
            }
        }

        static final class t extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f9197a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int[] f9198b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            t(int[] iArr, p138jb.f fVar) {
                super(2, fVar);
                this.f9198b = iArr;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new t(this.f9198b, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((t) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f9197a;
                if (i10 == 0) {
                    p068eb.q.b(obj);
                    a aVar = h.f9148a;
                    int[] iArr = this.f9198b;
                    this.f9197a = 1;
                    obj = aVar.y(iArr, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p068eb.q.b(obj);
                }
                Map map = (Map) obj;
                Wa.b.a("PastFraudUtil", "getPastScreenshotResult: " + map);
                return map;
            }
        }

        static final class u extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f9199a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Qa.l f9200b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int[] f9201c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            u(Qa.l lVar, int[] iArr, p138jb.f fVar) {
                super(2, fVar);
                this.f9200b = lVar;
                this.f9201c = iArr;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new u(this.f9200b, this.f9201c, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((u) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f9199a;
                if (i10 == 0) {
                    p068eb.q.b(obj);
                    Wa.b.a("PastFraudUtil", "getPastSimCardFraudCallResult---> start");
                    a aVar = h.f9148a;
                    Qa.l lVar = this.f9200b;
                    int[] iArr = this.f9201c;
                    this.f9199a = 1;
                    obj = aVar.z(lVar, iArr, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p068eb.q.b(obj);
                }
                Map map = (Map) obj;
                Wa.b.a("PastFraudUtil", "getPastSimCardFraudCallResult end : " + map);
                return map;
            }
        }

        static final class v extends kotlin.coroutines.jvm.internal.j implements p264sb.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f9202a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int[] f9203b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            v(int[] iArr, p138jb.f fVar) {
                super(2, fVar);
                this.f9203b = iArr;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p138jb.f create(Object obj, p138jb.f fVar) {
                return new v(this.f9203b, fVar);
            }

            @Override // p264sb.p
            public final Object invoke(O o10, p138jb.f fVar) {
                return ((v) create(o10, fVar)).invokeSuspend(w.f38919a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objE = p152kb.b.e();
                int i10 = this.f9202a;
                if (i10 == 0) {
                    p068eb.q.b(obj);
                    Wa.b.a("PastFraudUtil", "getPastVoipFraudCallResult---> start");
                    a aVar = h.f9148a;
                    int[] iArr = this.f9203b;
                    this.f9202a = 1;
                    obj = aVar.A(iArr, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p068eb.q.b(obj);
                }
                Map map = (Map) obj;
                Wa.b.a("PastFraudUtil", "getPastVoipFraudCallResult end : " + map);
                return map;
            }
        }

        public /* synthetic */ a(p278tb.h hVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object A(int[] iArr, p138jb.f fVar) {
            C0708p c0708p = new C0708p(p152kb.b.c(fVar), 1);
            c0708p.G();
            Ra.k.f8517c.a().U1(new k(iArr, c0708p), Qa.o.TYPE_FRAUD_CALL);
            Object objA = c0708p.A();
            if (objA == p152kb.b.e()) {
                kotlin.coroutines.jvm.internal.g.c(fVar);
            }
            return objA;
        }

        public static /* synthetic */ Map m(a aVar, List list, Qa.e eVar, int[] iArr, int[] iArr2, long j10, int i10, Object obj) {
            if ((i10 & 16) != 0) {
                j10 = System.currentTimeMillis();
            }
            return aVar.l(list, eVar, iArr, iArr2, j10);
        }

        private final boolean n(long j10, Qa.h hVar, c cVar) {
            long jC = j10 - hVar.c();
            long jA = j10 - hVar.a();
            long jD = cVar.d();
            if (jC > cVar.c() || jD > jC) {
                long jD2 = cVar.d();
                if ((jA > cVar.c() || jD2 > jA) && (jC < cVar.c() || jA > cVar.d())) {
                    return false;
                }
            }
            return true;
        }

        public static /* synthetic */ Map p(a aVar, List list, Qa.e eVar, int[] iArr, long j10, int i10, Object obj) {
            if ((i10 & 8) != 0) {
                j10 = System.currentTimeMillis();
            }
            return aVar.o(list, eVar, iArr, j10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object q(int[] iArr, int[] iArr2, p138jb.f fVar) {
            C0708p c0708p = new C0708p(p152kb.b.c(fVar), 1);
            c0708p.G();
            Ra.k.f8517c.a().J1(new C0120a(iArr, iArr2, c0708p));
            Object objA = c0708p.A();
            if (objA == p152kb.b.e()) {
                kotlin.coroutines.jvm.internal.g.c(fVar);
            }
            return objA;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object r(Qa.l lVar, Qa.e eVar, int[] iArr, int[] iArr2, p138jb.f fVar) {
            C0708p c0708p = new C0708p(p152kb.b.c(fVar), 1);
            c0708p.G();
            Ra.k.f8517c.a().R1(new b(eVar, iArr, iArr2, c0708p), lVar);
            Object objA = c0708p.A();
            if (objA == p152kb.b.e()) {
                kotlin.coroutines.jvm.internal.g.c(fVar);
            }
            return objA;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object s(Qa.o oVar, int[] iArr, int[] iArr2, p138jb.f fVar) {
            C0708p c0708p = new C0708p(p152kb.b.c(fVar), 1);
            c0708p.G();
            Ra.k.f8517c.a().U1(new c(iArr, iArr2, c0708p), oVar);
            Object objA = c0708p.A();
            if (objA == p152kb.b.e()) {
                kotlin.coroutines.jvm.internal.g.c(fVar);
            }
            return objA;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object t(int[] iArr, p138jb.f fVar) {
            C0708p c0708p = new C0708p(p152kb.b.c(fVar), 1);
            c0708p.G();
            Ra.k.f8517c.a().C1(new d(iArr, c0708p));
            Object objA = c0708p.A();
            if (objA == p152kb.b.e()) {
                kotlin.coroutines.jvm.internal.g.c(fVar);
            }
            return objA;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object u(int[] iArr, p138jb.f fVar) {
            C0708p c0708p = new C0708p(p152kb.b.c(fVar), 1);
            c0708p.G();
            Ra.k.f8517c.a().F1(new e(iArr, c0708p));
            Object objA = c0708p.A();
            if (objA == p152kb.b.e()) {
                kotlin.coroutines.jvm.internal.g.c(fVar);
            }
            return objA;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object v(int[] iArr, p138jb.f fVar) {
            C0708p c0708p = new C0708p(p152kb.b.c(fVar), 1);
            c0708p.G();
            Ra.k.f8517c.a().q1(new f(iArr, c0708p));
            Object objA = c0708p.A();
            if (objA == p152kb.b.e()) {
                kotlin.coroutines.jvm.internal.g.c(fVar);
            }
            return objA;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object w(int[] iArr, p138jb.f fVar) {
            C0708p c0708p = new C0708p(p152kb.b.c(fVar), 1);
            c0708p.G();
            Ra.k.f8517c.a().w1(new g(iArr, c0708p));
            Object objA = c0708p.A();
            if (objA == p152kb.b.e()) {
                kotlin.coroutines.jvm.internal.g.c(fVar);
            }
            return objA;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object x(int[] iArr, p138jb.f fVar) {
            C0708p c0708p = new C0708p(p152kb.b.c(fVar), 1);
            c0708p.G();
            Ra.k.f8517c.a().J1(new C0121h(iArr, c0708p));
            Object objA = c0708p.A();
            if (objA == p152kb.b.e()) {
                kotlin.coroutines.jvm.internal.g.c(fVar);
            }
            return objA;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object y(int[] iArr, p138jb.f fVar) {
            C0708p c0708p = new C0708p(p152kb.b.c(fVar), 1);
            c0708p.G();
            Ra.k.f8517c.a().L1(new i(iArr, c0708p));
            Object objA = c0708p.A();
            if (objA == p152kb.b.e()) {
                kotlin.coroutines.jvm.internal.g.c(fVar);
            }
            return objA;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object z(Qa.l lVar, int[] iArr, p138jb.f fVar) {
            C0708p c0708p = new C0708p(p152kb.b.c(fVar), 1);
            c0708p.G();
            Ra.k.f8517c.a().R1(new j(iArr, c0708p), lVar);
            Object objA = c0708p.A();
            if (objA == p152kb.b.e()) {
                kotlin.coroutines.jvm.internal.g.c(fVar);
            }
            return objA;
        }

        public final int B(Qa.e eVar) {
            p278tb.n.f(eVar, "fraudInfoDefaultResultType");
            return G(false, null, eVar);
        }

        public final long C(long j10, long j11) {
            if (j11 <= 0) {
                j11 = System.currentTimeMillis();
            }
            return j11 - j10;
        }

        public final Object D(int[] iArr, int[] iArr2, p138jb.f fVar) {
            return AbstractC0694i.g(C0687e0.b(), new l(iArr, iArr2, null), fVar);
        }

        public final Object E(Qa.l lVar, Qa.e eVar, int[] iArr, int[] iArr2, p138jb.f fVar) {
            return AbstractC0694i.g(C0687e0.b(), new m(lVar, eVar, iArr, iArr2, null), fVar);
        }

        public final Object F(Qa.o oVar, int[] iArr, int[] iArr2, p138jb.f fVar) {
            return AbstractC0694i.g(C0687e0.b(), new n(oVar, iArr, iArr2, null), fVar);
        }

        /* JADX WARN: Code duplicated, block: B:73:0x00a4 A[Catch: Exception -> 0x005f, TryCatch #0 {Exception -> 0x005f, blocks: (B:6:0x000a, B:9:0x0010, B:11:0x0015, B:14:0x001b, B:16:0x001f, B:19:0x0025, B:22:0x002b, B:25:0x0031, B:27:0x0035, B:30:0x003b, B:32:0x003f, B:34:0x0045, B:36:0x004d, B:38:0x0053, B:45:0x0063, B:47:0x0067, B:49:0x006b, B:52:0x0071, B:54:0x0075, B:57:0x007a, B:59:0x007e, B:62:0x0083, B:64:0x0087, B:67:0x008d, B:70:0x009c, B:73:0x00a4, B:75:0x00ac, B:78:0x00b3, B:82:0x00bd, B:85:0x00c9, B:90:0x00d6, B:92:0x00dc, B:94:0x00e4, B:99:0x00ed, B:101:0x00f3, B:103:0x00fb, B:105:0x0101), top: B:113:0x000a }] */
        public final int G(boolean z10, Qa.c cVar, Qa.e eVar) {
            TelephonyManager telephonyManager;
            TelephonyManager telephonyManager2;
            Ta.g.a aVar;
            TelephonyManager telephonyManager3;
            p278tb.n.f(eVar, "type");
            if (z10) {
                return 1;
            }
            try {
                if (Build.IS_INTERNATIONAL_BUILD) {
                    return 3;
                }
                if (!(cVar instanceof Qa.k) && eVar != Qa.e.ScreenshotInfo && !(cVar instanceof Qa.j) && eVar != Qa.e.ScreenShareInfo) {
                    if (!(cVar instanceof Qa.d) && eVar != Qa.e.CallForwardingInfo) {
                        if (!(cVar instanceof Qa.a) && eVar != Qa.e.AirplaneModeInfo) {
                            if (eVar == Qa.e.SimCardFraudInfo) {
                                Context contextC = com.miui.common.e.c();
                                if (contextC == null || (telephonyManager3 = (TelephonyManager) contextC.getSystemService(TelephonyManager.class)) == null || !telephonyManager3.isVoiceCapable()) {
                                    return 3;
                                }
                                return !YellowPageUtils.isYellowPageEnable(com.miui.common.e.c()) ? 2 : 0;
                            }
                            if (eVar != Qa.e.SimCardInfo && eVar != Qa.e.OverseasCallInfo && eVar != Qa.e.VirtualOperatorCallInfo) {
                                if (!(cVar instanceof Qa.n) && eVar != Qa.e.VoipRecordInfo) {
                                    if (!(cVar instanceof Qa.f) && eVar != Qa.e.FraudUrlInfo) {
                                        if ((cVar instanceof Qa.b) || eVar == Qa.e.AppInfo) {
                                            if (cVar != null) {
                                                Integer numI = ((Qa.b) cVar).i();
                                                int iB = Ta.b.EnumC0119b.RISK.b();
                                                if (numI == null || numI.intValue() != iB) {
                                                    aVar = Ta.g.f9147a;
                                                    if (!aVar.d() && !aVar.e()) {
                                                        return 3;
                                                    }
                                                }
                                            } else {
                                                aVar = Ta.g.f9147a;
                                                if (!aVar.d()) {
                                                    return 3;
                                                }
                                            }
                                            return 0;
                                        }
                                        return 2;
                                    }
                                    return Ta.g.f9147a.c() ? 0 : 3;
                                }
                                if (Ta.a.c(com.miui.common.e.c())) {
                                    return !Ta.a.b(com.miui.common.e.c()) ? 2 : 0;
                                }
                                return 3;
                            }
                            Context contextC2 = com.miui.common.e.c();
                            return (contextC2 == null || (telephonyManager2 = (TelephonyManager) contextC2.getSystemService(TelephonyManager.class)) == null || !telephonyManager2.isVoiceCapable()) ? 3 : 0;
                        }
                        return 0;
                    }
                    Context contextC3 = com.miui.common.e.c();
                    return (contextC3 == null || (telephonyManager = (TelephonyManager) contextC3.getSystemService(TelephonyManager.class)) == null || !telephonyManager.isVoiceCapable() || !Ta.g.f9147a.a()) ? 3 : 0;
                }
                return 0;
            } catch (Exception e10) {
                Wa.b.b("PastFraudUtil", "getFraudResultType error: " + e10.getMessage());
            }
        }

        public final Object H(int[] iArr, p138jb.f fVar) {
            return AbstractC0694i.g(C0687e0.b(), new o(iArr, null), fVar);
        }

        public final Object I(int[] iArr, p138jb.f fVar) {
            return AbstractC0694i.g(C0687e0.b(), new p(iArr, null), fVar);
        }

        public final Object J(int[] iArr, p138jb.f fVar) {
            return AbstractC0694i.g(C0687e0.b(), new q(iArr, null), fVar);
        }

        public final Object K(int[] iArr, p138jb.f fVar) {
            return AbstractC0694i.g(C0687e0.b(), new r(iArr, null), fVar);
        }

        public final Object L(int[] iArr, p138jb.f fVar) {
            return AbstractC0694i.g(C0687e0.b(), new s(iArr, null), fVar);
        }

        public final Object M(int[] iArr, p138jb.f fVar) {
            return AbstractC0694i.g(C0687e0.b(), new t(iArr, null), fVar);
        }

        public final Object N(Qa.l lVar, int[] iArr, p138jb.f fVar) {
            return AbstractC0694i.g(C0687e0.b(), new u(lVar, iArr, null), fVar);
        }

        public final Object O(int[] iArr, p138jb.f fVar) {
            return AbstractC0694i.g(C0687e0.b(), new v(iArr, null), fVar);
        }

        public final Map l(List list, Qa.e eVar, int[] iArr, int[] iArr2, long j10) {
            String str;
            LinkedHashMap linkedHashMap;
            LinkedHashMap linkedHashMap2;
            Qa.c cVar;
            int i10;
            Object obj;
            int i11;
            int[] iArr3 = iArr;
            String str2 = "PastFraudUtil";
            p278tb.n.f(eVar, "fraudInfoDefaultResultType");
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            if (iArr3 != null) {
                try {
                    int length = iArr3.length;
                    int i12 = 0;
                    while (i12 < length) {
                        int i13 = iArr3[i12];
                        c cVarA = c.f9213c.a(i13);
                        if (cVarA == null) {
                            a aVar = h.f9148a;
                            Wa.b.c(str2, "Invalid timestamp type: " + i13);
                            str = str2;
                            linkedHashMap = linkedHashMap3;
                            i11 = 1;
                        } else {
                            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                            if (iArr2 != null) {
                                try {
                                    int length2 = iArr2.length;
                                    int i14 = 0;
                                    while (i14 < length2) {
                                        int i15 = iArr2[i14];
                                        b bVarA = b.f9204c.a(i15);
                                        if (bVarA == null) {
                                            a aVar2 = h.f9148a;
                                            Wa.b.c(str2, "Invalid duration: " + i15);
                                            str = str2;
                                            linkedHashMap2 = linkedHashMap3;
                                            i10 = 1;
                                        } else {
                                            if (list != null) {
                                                Iterator it = list.iterator();
                                                while (true) {
                                                    if (!it.hasNext()) {
                                                        str = str2;
                                                        linkedHashMap2 = linkedHashMap3;
                                                        obj = null;
                                                        break;
                                                    }
                                                    Object next = it.next();
                                                    Object obj2 = (Qa.c) next;
                                                    if (obj2 instanceof Qa.h) {
                                                        str = str2;
                                                        linkedHashMap2 = linkedHashMap3;
                                                        boolean zN = h.f9148a.n(j10, (Qa.h) obj2, cVarA);
                                                        long jD = ((Qa.h) obj2).d();
                                                        if (zN) {
                                                            long jD2 = bVarA.d();
                                                            if (jD <= bVarA.c() && jD2 <= jD) {
                                                                obj = next;
                                                                break;
                                                            }
                                                        } else {
                                                            continue;
                                                        }
                                                    } else {
                                                        str = str2;
                                                        linkedHashMap2 = linkedHashMap3;
                                                    }
                                                    str2 = str;
                                                    linkedHashMap3 = linkedHashMap2;
                                                }
                                                cVar = (Qa.c) obj;
                                            } else {
                                                str = str2;
                                                linkedHashMap2 = linkedHashMap3;
                                                cVar = null;
                                            }
                                            linkedHashMap4.put(Integer.valueOf(i15), Integer.valueOf(cVar != null ? 1 : h.f9148a.B(eVar)));
                                            i10 = 1;
                                        }
                                        try {
                                            i14 += i10;
                                            str2 = str;
                                            linkedHashMap3 = linkedHashMap2;
                                        } catch (Exception e10) {
                                            e = e10;
                                            linkedHashMap = linkedHashMap2;
                                            Wa.b.b(str, "checkDurationBehaviorOccurrence error: " + e.getMessage());
                                            return linkedHashMap;
                                        }
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                    str = str2;
                                    linkedHashMap2 = linkedHashMap3;
                                }
                            }
                            str = str2;
                            linkedHashMap = linkedHashMap3;
                            try {
                                linkedHashMap.put(Integer.valueOf(i13), linkedHashMap4);
                                i11 = 1;
                            } catch (Exception e12) {
                                e = e12;
                                Wa.b.b(str, "checkDurationBehaviorOccurrence error: " + e.getMessage());
                                return linkedHashMap;
                            }
                        }
                        i12 += i11;
                        iArr3 = iArr;
                        linkedHashMap3 = linkedHashMap;
                        str2 = str;
                    }
                } catch (Exception e13) {
                    e = e13;
                    str = str2;
                    linkedHashMap = linkedHashMap3;
                }
            }
            return linkedHashMap3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Map o(List list, Qa.e eVar, int[] iArr, long j10) {
            boolean z10;
            boolean zN;
            int iG;
            p278tb.n.f(list, "events");
            p278tb.n.f(eVar, "fraudInfoDefaultResultType");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (iArr != null) {
                try {
                    for (int i10 : iArr) {
                        c cVarA = c.f9213c.a(i10);
                        if (cVarA != null) {
                            int iB = h.f9148a.B(eVar);
                            List list2 = list;
                            if ((list2 instanceof Collection) && list2.isEmpty()) {
                                z10 = false;
                                linkedHashMap.put(Integer.valueOf(i10), Integer.valueOf(iB));
                                Wa.b.a("PastFraudUtil", "checkPastBehaviorOccurrence-->  hasOccurred: " + z10 + ", fraudRiskResult: " + iB);
                            } else {
                                Iterator it = list2.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Qa.c cVar = (Qa.c) it.next();
                                        z10 = true;
                                        if (cVar instanceof Qa.i) {
                                            long jB = j10 - ((Qa.i) cVar).b();
                                            zN = jB <= cVarA.c() && cVarA.d() <= jB;
                                            iG = h.f9148a.G(zN, cVar, eVar);
                                        } else if (cVar instanceof Qa.h) {
                                            a aVar = h.f9148a;
                                            zN = aVar.n(j10, (Qa.h) cVar, cVarA);
                                            iG = aVar.G(zN, cVar, eVar);
                                        }
                                        iB = iG;
                                        if (zN) {
                                            linkedHashMap.put(Integer.valueOf(i10), Integer.valueOf(iB));
                                            Wa.b.a("PastFraudUtil", "checkPastBehaviorOccurrence-->  hasOccurred: " + z10 + ", fraudRiskResult: " + iB);
                                        }
                                    } else {
                                        z10 = false;
                                        linkedHashMap.put(Integer.valueOf(i10), Integer.valueOf(iB));
                                        Wa.b.a("PastFraudUtil", "checkPastBehaviorOccurrence-->  hasOccurred: " + z10 + ", fraudRiskResult: " + iB);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e10) {
                    Wa.b.b("PastFraudUtil", "checkPastBehaviorOccurrence error: " + e10.getMessage());
                }
            }
            return linkedHashMap;
        }

        private a() {
        }
    }

    public enum b {
        LESS_THAN_1_MIN(0, 59999),
        BETWEEN_1_3_MIN(60000, 179999),
        BETWEEN_3_10_MIN(180000, 599999),
        MORE_THAN_10_MIN(600000, Long.MAX_VALUE);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9212b;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ p166lb.a f9210i = p166lb.b.a(a());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f9204c = new a(null);

        public static final class a {
            public /* synthetic */ a(p278tb.h hVar) {
                this();
            }

            public final b a(int i10) {
                return (b) AbstractC1948o.Q(b.b(), i10);
            }

            private a() {
            }
        }

        b(long j10, long j11) {
            this.f9211a = j10;
            this.f9212b = j11;
        }

        public static p166lb.a b() {
            return f9210i;
        }

        public final long c() {
            return this.f9212b;
        }

        public final long d() {
            return this.f9211a;
        }
    }

    public enum c {
        LESS_THAN_1_MIN(0, 59999),
        BETWEEN_1_30_MIN(60000, 1799999),
        BETWEEN_30_60_MIN(1800000, 3599999),
        BETWEEN_1_6_HOUR(3600000, 21599999),
        BETWEEN_6_12_HOUR(21600000, 43199999),
        BETWEEN_12_24_HOUR(43200000, 86399999),
        BETWEEN_24_72_HOUR(86400000, 259199999);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9224b;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final /* synthetic */ p166lb.a f9222l = p166lb.b.a(a());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f9213c = new a(null);

        public static final class a {
            public /* synthetic */ a(p278tb.h hVar) {
                this();
            }

            public final c a(int i10) {
                return (c) AbstractC1948o.Q(c.b(), i10);
            }

            private a() {
            }
        }

        c(long j10, long j11) {
            this.f9223a = j10;
            this.f9224b = j11;
        }

        public static p166lb.a b() {
            return f9222l;
        }

        public final long c() {
            return this.f9224b;
        }

        public final long d() {
            return this.f9223a;
        }
    }
}
