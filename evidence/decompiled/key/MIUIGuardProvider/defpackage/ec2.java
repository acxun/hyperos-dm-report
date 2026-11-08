package defpackage;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.miui.guardprovider.sdk.android.pojo.AndroidApp;
import com.miui.guardprovider.sdk.android.pojo.BlackGrayInfo;
import com.miui.guardprovider.sdk.android.pojo.ThreatInfo;
import com.miui.guardprovider.sdk.android.pojo.networkdomain.ResultReportData;
import com.xiaomi.onetrack.util.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.VarHandle;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ec2 {
    public Context a;
    public rd2 b;
    public ir0 c;
    public File d;
    public String e;
    public fr1 f;
    public SecureRandom g;
    public oz0 h;

    public final ArrayList a(String str, AndroidApp androidApp, long j) throws NoSuchAlgorithmException, IOException {
        qy1 qy1Var;
        if (Files.size(androidApp.getPath()) < 62914560) {
            Path path = androidApp.getPath();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            MessageDigest messageDigest2 = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[65536];
            InputStream inputStreamNewInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
            inputStreamNewInputStream.getClass();
            while (true) {
                try {
                    int i = inputStreamNewInputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i);
                    messageDigest2.update(bArr, 0, i);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        vh3.m(inputStreamNewInputStream, th);
                        throw th2;
                    }
                }
            }
            inputStreamNewInputStream.close();
            messageDigest.getClass();
            byte[] bArrDigest = messageDigest.digest();
            bArrDigest.getClass();
            int i2 = 6;
            String strN = kh.N(bArrDigest, new zj(i2));
            messageDigest2.getClass();
            byte[] bArrDigest2 = messageDigest2.digest();
            bArrDigest2.getClass();
            qy1Var = new qy1(strN, kh.N(bArrDigest2, new zj(i2)));
        } else {
            qy1Var = new qy1(a.c, a.c);
        }
        String str2 = (String) qy1Var.b;
        String str3 = (String) qy1Var.c;
        if (!(androidApp instanceof st2)) {
            if (!(androidApp instanceof wm)) {
                return null;
            }
            List<BlackGrayInfo> blackGrayInfo = ((wm) androidApp).getBlackGrayInfo();
            ArrayList arrayList = new ArrayList(cy.G(blackGrayInfo));
            for (BlackGrayInfo blackGrayInfo2 : blackGrayInfo) {
                String ruleName$flamingo_android = blackGrayInfo2.getRuleName$flamingo_android();
                if (ruleName$flamingo_android == null) {
                    cw1.f("Required value was null.");
                    return null;
                }
                int version$flamingo_android = blackGrayInfo2.getVersion$flamingo_android();
                String packageName = androidApp.getPackageName();
                String string = androidApp.getAppName().toString();
                int versionCode = androidApp.getVersionCode();
                String signaturesMd5 = androidApp.getSignaturesMd5();
                String signaturesSha256 = androidApp.getSignaturesSha256();
                String mfSha256 = androidApp.getMfSha256();
                String str4 = mfSha256 == null ? a.c : mfSha256;
                String str5 = Build.VERSION.INCREMENTAL;
                str5.getClass();
                int i3 = Build.VERSION.SDK_INT;
                String str6 = Build.DEVICE;
                str6.getClass();
                arrayList.add(new ResultReportData("BlackGrays", a.c, ruleName$flamingo_android, version$flamingo_android, packageName, string, versionCode, signaturesMd5, signaturesSha256, str4, str2, str3, str5, i3, str6, str, blackGrayInfo2.getHitFiles$flamingo_android(), this.e, Long.valueOf(j)));
            }
            return arrayList;
        }
        List<ThreatInfo> threatInfo = ((st2) androidApp).getThreatInfo();
        ArrayList arrayList2 = new ArrayList(cy.G(threatInfo));
        for (ThreatInfo threatInfo2 : threatInfo) {
            ArrayList arrayList3 = arrayList2;
            String threatLevel = threatInfo2.getThreatLevel();
            String threatName = threatInfo2.getThreatName();
            String codeFeature = threatInfo2.getCodeFeature();
            if (codeFeature == null) {
                cw1.f("Required value was null.");
                return null;
            }
            int version = threatInfo2.getVersion();
            String packageName2 = androidApp.getPackageName();
            String string2 = androidApp.getAppName().toString();
            int versionCode2 = androidApp.getVersionCode();
            String signaturesMd6 = androidApp.getSignaturesMd5();
            String signaturesSha257 = androidApp.getSignaturesSha256();
            String mfSha257 = androidApp.getMfSha256();
            if (mfSha257 == null) {
                mfSha257 = a.c;
            }
            String str7 = Build.VERSION.INCREMENTAL;
            str7.getClass();
            String str8 = mfSha257;
            int i4 = Build.VERSION.SDK_INT;
            String str9 = Build.DEVICE;
            str9.getClass();
            arrayList3.add(new ResultReportData(threatLevel, threatName, codeFeature, version, packageName2, string2, versionCode2, signaturesMd6, signaturesSha257, str8, str2, str3, str7, i4, str9, str, threatInfo2.getHitFiles(), this.e, Long.valueOf(j)));
            arrayList2 = arrayList3;
        }
        return arrayList2;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e3 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:13:0x002f, B:56:0x00f9, B:61:0x0106, B:62:0x010b, B:63:0x010c, B:51:0x00dd, B:53:0x00e3, B:48:0x00c6, B:50:0x00d4), top: B:69:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f6, code lost:
    
        if (r13 == r1) goto L55;
     */
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00f6 -> B:56:0x00f9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(defpackage.k20 r13) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ec2.b(k20):java.lang.Object");
    }

    public final List c() {
        File[] fileArrListFiles = this.d.listFiles();
        if (fileArrListFiles == null) {
            return nf0.b;
        }
        ik0 ik0Var = new ik0(kh.v(fileArrListFiles), true, new y20(3));
        ev evVar = new ev(3);
        lj2 lj2Var = new lj2();
        lj2Var.a = ik0Var;
        lj2Var.b = evVar;
        VarHandle.storeStoreFence();
        return gj2.V(gj2.U(lj2Var, new ab0(1, this, ec2.class, "parseOrDrop", "parseOrDrop(Ljava/io/File;)Lcom/miui/guardprovider/sdk/android/report/ReportStore$PendingReport;", 0, 0, 4)));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Enum d(bc2 bc2Var, k20 k20Var) {
        dc2 dc2Var;
        if (k20Var instanceof dc2) {
            dc2Var = (dc2) k20Var;
            int i = dc2Var.h;
            if ((i & Integer.MIN_VALUE) != 0) {
                dc2Var.h = i - Integer.MIN_VALUE;
            } else {
                dc2Var = new dc2(this, k20Var);
            }
        } else {
            dc2Var = new dc2(this, k20Var);
        }
        Object obj = dc2Var.f;
        h30 h30Var = h30.b;
        int i2 = dc2Var.h;
        try {
            if (i2 == 0) {
                kk3.y(obj);
                try {
                    AndroidApp androidApp = (AndroidApp) this.c.c(bc2Var.b, qz2.get(AndroidApp.class));
                    if (androidApp == null) {
                        return ac2.c;
                    }
                    try {
                        ArrayList arrayListA = a(bc2Var.a, androidApp, bc2Var.c);
                        if (arrayListA == null) {
                            return ac2.c;
                        }
                        rd2 rd2Var = this.b;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        dc2Var.e = bc2Var;
                        dc2Var.h = 1;
                        if (rd2Var.a(jCurrentTimeMillis, arrayListA, dc2Var) == h30Var) {
                            return h30Var;
                        }
                    } catch (NoSuchFileException unused) {
                        Log.w("ReportStore", "Report " + bc2Var.d.getName() + ": apk file gone, drop");
                        return ac2.c;
                    } catch (IOException e) {
                        Log.i("ReportStore", "Report " + bc2Var.d.getName() + ": IO while building body, retry", e);
                        return ac2.d;
                    } catch (Throwable th) {
                        Log.e("ReportStore", "Report " + bc2Var.d.getName() + ": unexpected build error, drop", th);
                        return ac2.c;
                    }
                } catch (Throwable th2) {
                    Log.e("ReportStore", "Report " + bc2Var.d.getName() + ": payload unparseable, drop", th2);
                    return ac2.c;
                }
            } else {
                if (i2 != 1) {
                    ik.j("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bc2Var = dc2Var.e;
                kk3.y(obj);
            }
            return ac2.b;
        } catch (IOException e2) {
            Log.i("ReportStore", im2.o("Report ", bc2Var.d.getName(), ": network IO, retry (", e2.getMessage(), ")"));
            return ac2.d;
        } catch (vt0 e3) {
            int i3 = e3.b;
            if (400 > i3 || i3 >= 500) {
                Log.i("ReportStore", "Report " + bc2Var.d.getName() + ": HTTP " + i3 + ", retry");
                return ac2.d;
            }
            Log.w("ReportStore", "Report " + bc2Var.d.getName() + ": HTTP " + i3 + ", drop");
            return ac2.c;
        } catch (Throwable th3) {
            Log.e("ReportStore", "Report " + bc2Var.d.getName() + ": unexpected upload error, drop", th3);
            return ac2.c;
        }
    }
}
