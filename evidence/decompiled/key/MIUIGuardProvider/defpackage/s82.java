package defpackage;

import android.util.Log;
import com.miui.guardprovider.sdk.android.pojo.AndroidApp;
import com.miui.guardprovider.sdk.android.pojo.BlackGrayInfo;
import com.miui.guardprovider.sdk.android.pojo.ThreatInfo;
import com.xiaomi.onetrack.util.a;
import com.xiaomi.onetrack.util.aa;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.invoke.VarHandle;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class s82 extends lr2 implements qp0 {
    public /* synthetic */ AndroidApp f;
    public /* synthetic */ AndroidApp g;
    public final /* synthetic */ w82 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s82(w82 w82Var, j20 j20Var) {
        super(3, j20Var);
        this.h = w82Var;
    }

    @Override // defpackage.sk
    public final Object o(Object obj) {
        ArrayList arrayList;
        ArrayList arrayList2;
        List<BlackGrayInfo> blackGrayInfo;
        List<ThreatInfo> threatInfo;
        List<BlackGrayInfo> blackGrayInfo2;
        List<ThreatInfo> threatInfo2;
        AndroidApp androidApp = this.f;
        AndroidApp androidApp2 = this.g;
        h30 h30Var = h30.b;
        kk3.y(obj);
        Log.i("RealScanner", "Scan result:(" + androidApp2 + aa.b + androidApp + ")");
        ec2 ec2Var = this.h.g;
        androidApp2.getClass();
        boolean z = androidApp2 instanceof st2;
        if (z || (androidApp2 instanceof wm)) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                String str = uw0.b;
                if (str == null) {
                    throw new IllegalStateException("Not init yet!");
                }
                jSONObject.put("uuid", str);
                jSONObject.put("payload", ec2Var.c.h(androidApp2));
                jSONObject.put("timestamp", jCurrentTimeMillis);
                String string = jSONObject.toString();
                string.getClass();
                iy0 iy0VarN = xr0.N(0, 6);
                fu fuVar = new fu(3);
                fuVar.c = ec2Var;
                VarHandle.storeStoreFence();
                String str2 = jCurrentTimeMillis + "-" + zx.Y(iy0VarN, a.c, null, null, fuVar, 30);
                File file = new File(ec2Var.d, str2.concat(".json.tmp"));
                File file2 = new File(ec2Var.d, str2.concat(".json"));
                Charset charset = mu.a;
                charset.getClass();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    u83.C(fileOutputStream, string, charset);
                    fileOutputStream.close();
                    if (!file.renameTo(file2)) {
                        file.delete();
                        Log.w("ReportStore", "Failed to commit report file: " + file2);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        vh3.m(fileOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Exception e) {
                Log.e("ReportStore", "Failed to persist report", e);
            }
        }
        List<BlackGrayInfo> list = nf0.b;
        androidApp.getClass();
        st2 st2Var = androidApp instanceof st2 ? (st2) androidApp : null;
        ArrayList arrayList3 = new ArrayList((st2Var == null || (threatInfo2 = st2Var.getThreatInfo()) == null) ? list : threatInfo2);
        wm wmVar = androidApp instanceof wm ? (wm) androidApp : null;
        if (wmVar != null && (blackGrayInfo2 = wmVar.getBlackGrayInfo()) != null) {
            list = blackGrayInfo2;
        }
        ArrayList arrayList4 = new ArrayList(list);
        st2 st2Var2 = z ? (st2) androidApp2 : null;
        if (st2Var2 == null || (threatInfo = st2Var2.getThreatInfo()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object obj2 : threatInfo) {
                if (((ThreatInfo) obj2).getIsIntercept()) {
                    arrayList.add(obj2);
                }
            }
        }
        wm wmVar2 = androidApp2 instanceof wm ? (wm) androidApp2 : null;
        if (wmVar2 == null || (blackGrayInfo = wmVar2.getBlackGrayInfo()) == null) {
            arrayList2 = null;
        } else {
            arrayList2 = new ArrayList();
            for (Object obj3 : blackGrayInfo) {
                if (((BlackGrayInfo) obj3).isIntercept$flamingo_android()) {
                    arrayList2.add(obj3);
                }
            }
        }
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        if (arrayList2 != null) {
            arrayList4.addAll(arrayList2);
        }
        AndroidApp androidAppS = oe2.S(androidApp);
        List listQ0 = zx.q0(zx.s0(arrayList3));
        if (listQ0.isEmpty()) {
            listQ0 = null;
        }
        List list2 = listQ0;
        List listQ1 = zx.q0(zx.s0(arrayList4));
        if (listQ1.isEmpty()) {
            listQ1 = null;
        }
        List list3 = listQ1;
        u03 u03Var = androidApp instanceof u03 ? (u03) androidApp : null;
        return oe2.o(androidAppS, list2, list3, (androidApp2 instanceof v22) || (androidApp instanceof v22), u03Var != null ? u03Var.getRiskTypes() : null);
    }

    @Override // defpackage.qp0
    public final Object w(Object obj, Object obj2, Object obj3) {
        s82 s82Var = new s82(this.h, (j20) obj3);
        s82Var.f = (AndroidApp) obj;
        s82Var.g = (AndroidApp) obj2;
        return s82Var.o(c13.a);
    }
}
