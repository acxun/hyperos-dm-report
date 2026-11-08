package com.miui.guardprovider.sdk.android.work;

import A1.i;
import F1.t;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import androidx.work.c;
import com.google.gson.e;
import com.miui.guardprovider.sdk.android.pojo.BlackGrayInfo;
import com.miui.guardprovider.sdk.android.pojo.ThreatInfo;
import com.miui.guardprovider.sdk.android.pojo.f;
import com.miui.guardprovider.sdk.android.pojo.networkdomain.ResultReportData;
import com.miui.guardprovider.sdk.android.pojo.q;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import p038f2.D;
import p038f2.s;
import p045g2.AbstractC0962q;
import p080l2.d;
import p080l2.k;
import p135u2.m;
import tmsdk.common.tcc.SmsCheckerContentTypes;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/miui/guardprovider/sdk/android/work/ReportWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "params", "LF1/t;", "uploadApi", "Lcom/google/gson/e;", "gson", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;LF1/t;Lcom/google/gson/e;)V", com.xiaomi.onetrack.util.a.f14247c, "uuid", "Lcom/miui/guardprovider/sdk/android/pojo/a;", com.xiaomi.onetrack.g.a.f14180d, "Lf2/D;", "k", "(Ljava/lang/String;Lcom/miui/guardprovider/sdk/android/pojo/a;Lj2/e;)Ljava/lang/Object;", "Landroidx/work/c$a;", "i", "(Lj2/e;)Ljava/lang/Object;", "g", "LF1/t;", "h", "Lcom/google/gson/e;", "a", "flamingo-android_cnRelease"}, k = 1, mv = {2, 2, 0}, xi = SmsCheckerContentTypes.TYPE_TEL_NET_TEL)
public final class ReportWorker extends CoroutineWorker {

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final t uploadApi;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final e gson;

    static final class b extends d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f13307e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f13308f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f13309g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f13311i;

        b(p066j2.e eVar) {
            super(eVar);
        }

        @Override // p080l2.a
        public final Object A(Object obj) {
            this.f13309g = obj;
            this.f13311i |= Integer.MIN_VALUE;
            return ReportWorker.this.i(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportWorker(Context context, WorkerParameters workerParameters, t tVar, e eVar) {
        super(context, workerParameters);
        m.e(context, "appContext");
        m.e(workerParameters, "params");
        m.e(tVar, "uploadApi");
        m.e(eVar, "gson");
        this.uploadApi = tVar;
        this.gson = eVar;
    }

    private final Object k(String str, com.miui.guardprovider.sdk.android.pojo.a aVar, p066j2.e eVar) {
        ArrayList arrayList;
        boolean z6;
        String strE;
        boolean z7 = false;
        boolean z8 = Files.size(aVar.getPath()) < 62914560;
        if (aVar instanceof q) {
            List<ThreatInfo> threatInfo = ((q) aVar).getThreatInfo();
            arrayList = new ArrayList(AbstractC0962q.v(threatInfo, 10));
            for (ThreatInfo threatInfo2 : threatInfo) {
                String threatLevel = threatInfo2.getThreatLevel();
                String threatName = threatInfo2.getThreatName();
                String codeFeature$flamingo_android_cnRelease = threatInfo2.getCodeFeature$flamingo_android_cnRelease();
                if (codeFeature$flamingo_android_cnRelease == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                int version$flamingo_android_cnRelease = threatInfo2.getVersion$flamingo_android_cnRelease();
                String packageName = aVar.getPackageName();
                String string = aVar.getAppName().toString();
                int versionCode = aVar.getVersionCode();
                String signaturesMd5 = aVar.getSignaturesMd5();
                String signaturesSha256 = aVar.getSignaturesSha256();
                String mfSha256 = aVar.getMfSha256();
                if (mfSha256 == null) {
                    mfSha256 = com.xiaomi.onetrack.util.a.f14247c;
                }
                boolean z9 = z8;
                String strE2 = z8 ? i.e(aVar.getPath(), "MD5", z7, 4, null) : com.xiaomi.onetrack.util.a.f14247c;
                String strE3 = z9 ? i.e(aVar.getPath(), "SHA-256", z7, 4, null) : com.xiaomi.onetrack.util.a.f14247c;
                String str2 = Build.VERSION.INCREMENTAL;
                m.d(str2, "INCREMENTAL");
                int i6 = Build.VERSION.SDK_INT;
                String str3 = Build.DEVICE;
                m.d(str3, "DEVICE");
                arrayList.add(new ResultReportData(threatLevel, threatName, codeFeature$flamingo_android_cnRelease, version$flamingo_android_cnRelease, packageName, string, versionCode, signaturesMd5, signaturesSha256, mfSha256, strE2, strE3, str2, i6, str3, str, threatInfo2.getHitFiles$flamingo_android_cnRelease()));
                z8 = z9;
                z7 = false;
            }
        } else {
            boolean z10 = z8;
            if (!(aVar instanceof f)) {
                return D.f14789a;
            }
            List<BlackGrayInfo> blackGrayInfo = ((f) aVar).getBlackGrayInfo();
            arrayList = new ArrayList(AbstractC0962q.v(blackGrayInfo, 10));
            for (BlackGrayInfo blackGrayInfo2 : blackGrayInfo) {
                String ruleName$flamingo_android_cnRelease = blackGrayInfo2.getRuleName$flamingo_android_cnRelease();
                if (ruleName$flamingo_android_cnRelease == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                int version$flamingo_android_cnRelease2 = blackGrayInfo2.getVersion$flamingo_android_cnRelease();
                String packageName2 = aVar.getPackageName();
                String string2 = aVar.getAppName().toString();
                int versionCode2 = aVar.getVersionCode();
                String signaturesMd6 = aVar.getSignaturesMd5();
                String signaturesSha257 = aVar.getSignaturesSha256();
                String mfSha257 = aVar.getMfSha256();
                String str4 = mfSha257 == null ? com.xiaomi.onetrack.util.a.f14247c : mfSha257;
                if (z10) {
                    z6 = false;
                    strE = i.e(aVar.getPath(), "MD5", false, 4, null);
                } else {
                    z6 = false;
                    strE = com.xiaomi.onetrack.util.a.f14247c;
                }
                String strE4 = z10 ? i.e(aVar.getPath(), "SHA-256", z6, 4, null) : com.xiaomi.onetrack.util.a.f14247c;
                String str5 = Build.VERSION.INCREMENTAL;
                m.d(str5, "INCREMENTAL");
                int i7 = Build.VERSION.SDK_INT;
                String str6 = Build.DEVICE;
                m.d(str6, "DEVICE");
                arrayList.add(new ResultReportData("BlackGrays", com.xiaomi.onetrack.util.a.f14247c, ruleName$flamingo_android_cnRelease, version$flamingo_android_cnRelease2, packageName2, string2, versionCode2, signaturesMd6, signaturesSha257, str4, strE, strE4, str5, i7, str6, str, blackGrayInfo2.getHitFiles$flamingo_android_cnRelease()));
            }
        }
        Object objA = this.uploadApi.a(System.currentTimeMillis(), arrayList, eVar);
        return objA == p073k2.b.e() ? objA : D.f14789a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    public Object i(p066j2.e eVar) {
        b bVar;
        if (eVar instanceof b) {
            bVar = (b) eVar;
            int i6 = bVar.f13311i;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                bVar.f13311i = i6 - Integer.MIN_VALUE;
            } else {
                bVar = new b(eVar);
            }
        } else {
            bVar = new b(eVar);
        }
        Object obj = bVar.f13309g;
        Object objE = p073k2.b.e();
        int i7 = bVar.f13311i;
        try {
            if (i7 == 0) {
                s.b(obj);
                String strD = c().d("uuid");
                m.c(strD, "null cannot be cast to non-null type kotlin.String");
                com.miui.guardprovider.sdk.android.pojo.a aVar = (com.miui.guardprovider.sdk.android.pojo.a) this.gson.l(c().d("reportData"), com.miui.guardprovider.sdk.android.pojo.a.class);
                m.b(aVar);
                bVar.f13307e = k.a(strD);
                bVar.f13308f = k.a(aVar);
                bVar.f13311i = 1;
                if (k(strD, aVar, bVar) == objE) {
                    return objE;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                s.b(obj);
            }
            c.a aVarC = c.a.c();
            m.d(aVarC, "success(...)");
            return aVarC;
        } catch (I5.m e6) {
            Log.e("ReportWorker", "Result upload failed", e6);
            c.a aVarB = c.a.b();
            m.d(aVarB, "retry(...)");
            return aVarB;
        } catch (IOException e7) {
            Log.e("ReportWorker", "Result upload failed", e7);
            c.a aVarA = c.a.a();
            m.d(aVarA, "failure(...)");
            return aVarA;
        }
    }
}
