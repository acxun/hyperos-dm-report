package com.miui.packageInstaller;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.android.packageinstaller.InstallerApplication;
import com.miui.packageInstaller.model.ApkInfo;
import com.miui.packageInstaller.model.AuthFunction;
import com.miui.packageInstaller.model.CloudParams;
import com.miui.packageInstaller.model.CloudResult;
import com.miui.packageInstaller.model.UiConfig;
import com.miui.packageInstaller.util.XiaoMiSafe;
import com.xiaomi.accountsdk.account.stat.StatConstants;
import com.xiaomi.accountsdk.hasheddeviceidlib.HardwareInfo;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: renamed from: com.miui.packageInstaller.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0647e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15672a = new a(null);

    /* JADX INFO: renamed from: com.miui.packageInstaller.e$a */
    public static final class a {
        private a() {
        }

        public final CloudParams a(String str) {
            H3.m.f(str, StatConstants.Param.STRING_TYPE);
            CloudParams cloudParams = new CloudParams();
            cloudParams.useSystemAppRules = Boolean.TRUE;
            cloudParams.categoryAbbreviation = str;
            if (p053h2.b.f18901a.r()) {
                Boolean bool = Boolean.FALSE;
                cloudParams.showAdsBefore = bool;
                cloudParams.showAdsAfter = bool;
            }
            return cloudParams;
        }

        public /* synthetic */ a(H3.g gVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.miui.packageInstaller.e$b */
    @kotlin.coroutines.jvm.internal.f(c = "com.miui.packageInstaller.AppMarket", f = "AppMarket.kt", l = {104, 107, 111}, m = "syncSearch")
    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15675c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f15676d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f15677e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f15679g;

        b(p163x3.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f15677e = obj;
            this.f15679g |= Integer.MIN_VALUE;
            return C0647e.this.c(null, null, 0, null, null, this);
        }
    }

    private final CloudParams a() {
        CloudParams cloudParams = new CloudParams();
        cloudParams.categoryAbbreviation = "500_error";
        cloudParams.showAdsBefore = Boolean.FALSE;
        return cloudParams;
    }

    private final String b() {
        B0.d dVar = new B0.d(InstallerApplication.m(), "uuid");
        String strD = new B0.d(InstallerApplication.m(), "uuid").d("device_uuid", "");
        if (TextUtils.isEmpty(strD)) {
            strD = UUID.randomUUID().toString();
            dVar.m("device_uuid", strD);
        }
        H3.m.c(strD);
        return strD;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.content.Context] */
    public final Object c(Context context, CallingPackage callingPackage, int i6, ApkInfo apkInfo, HashMap<String, String> map, p163x3.d<? super CloudResult> dVar) throws Throwable {
        b bVar;
        C0647e c0647e;
        Object obj;
        Q5.t tVar;
        Object obj2;
        ?? r6;
        Integer num;
        String path;
        Object obj3;
        Object obj4 = context;
        CallingPackage callingPackage2 = callingPackage;
        ApkInfo apkInfo2 = apkInfo;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i7 = bVar.f15679g;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                bVar.f15679g = i7 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object objH = bVar.f15677e;
        Object objC = p169y3.d.c();
        int i8 = bVar.f15679g;
        try {
            if (i8 == 0) {
                p138t3.o.b(objH);
                if (apkInfo.getSystemApp()) {
                    return new CloudResult.Success(f15672a.a("miui"));
                }
                String strP = callingPackage.p();
                H3.m.e(strP, "getLaunchedPackage(...)");
                map.put("source", strP);
                map.put("rn", String.valueOf(i6));
                String str = callingPackage2.f15408f;
                H3.m.e(str, "name");
                map.put("sourceAppName", str);
                map.put("versionCode", String.valueOf(apkInfo.getVersionCode()));
                map.put("versionName", apkInfo.getVersionName());
                map.put("localVersionCode", String.valueOf(apkInfo.getInstalledVersionCode()));
                map.put("installationMode", apkInfo.isOtherVersionInstalled() ? "2" : "1");
                map.put("packageName", String.valueOf(apkInfo.getPackageName()));
                map.put("appName", String.valueOf(apkInfo.getLabel()));
                map.put("apkMd5", String.valueOf(apkInfo.getApkMd5()));
                map.put("apkSignature", String.valueOf(apkInfo.getApkSignature()));
                map.put("apkSignature2", String.valueOf(apkInfo.getApkSignature2()));
                map.put("apkSignature3", String.valueOf(apkInfo.getApkSignature3()));
                map.put("apkSignatureSha1", String.valueOf(apkInfo.getApkSignatureSha1()));
                map.put("apkSignatureSha256", String.valueOf(apkInfo.getApkSignatureSha256()));
                map.put("apkSignature3Sha1", String.valueOf(apkInfo.getApkSignature3Sha1()));
                map.put("apkSignature3Sha256", String.valueOf(apkInfo.getApkSignature3Sha256()));
                String strQ = com.android.packageinstaller.utils.i.q();
                H3.m.e(strQ, "getUA(...)");
                map.put("ua", strQ);
                map.put("antifraudLabel", apkInfo.getAppAntiLabel());
                map.put("apkSize", String.valueOf(apkInfo.getFileSize()));
                int i9 = Build.VERSION.SDK_INT;
                if (i9 <= 28) {
                    String strG = com.android.packageinstaller.utils.i.g(InstallerApplication.m());
                    H3.m.e(strG, "getImeiMd5(...)");
                    map.put("imeiMd5", strG);
                }
                map.put("adTagId", "1.19.k.1");
                String strB = com.android.packageinstaller.utils.i.b();
                H3.m.e(strB, "getCpuArchitecture(...)");
                map.put("cpuArchitecture", strB);
                map.put("androidSdkVersion", String.valueOf(i9));
                map.put("irec", String.valueOf(B0.c.g(InstallerApplication.m()).p()));
                String str2 = E0.a.f580c;
                H3.m.e(str2, "sClientSessionId");
                map.put("client_session_id", str2);
                if (obj4 instanceof p025d2.a) {
                    map.put("launch_source_package", String.valueOf(((p025d2.a) obj4).z().get("launch_source_package")));
                } else {
                    String strP2 = callingPackage.p();
                    H3.m.e(strP2, "getLaunchedPackage(...)");
                    map.put("launch_source_package", strP2);
                }
                String sourceApkSignature3 = apkInfo.getSourceApkSignature3();
                if (sourceApkSignature3 == null) {
                    sourceApkSignature3 = "";
                }
                map.put("sourceApkSignature3", sourceApkSignature3);
                String sourceVersionCode = apkInfo.getSourceVersionCode();
                if (sourceVersionCode == null) {
                    sourceVersionCode = "";
                }
                map.put("sourceVersionCode", sourceVersionCode);
                String realFileName = apkInfo.getRealFileName();
                if (realFileName == null) {
                    realFileName = "";
                }
                map.put("apkFileName", realFileName);
                int iJ = B4.a.j();
                String str3 = "unknown";
                if (iJ != -1) {
                    if (iJ == 0) {
                        str3 = "low";
                    } else if (iJ == 1) {
                        str3 = "middle";
                    } else if (iJ == 2) {
                        str3 = "high";
                    }
                }
                map.put("device_type", str3);
                map.put("client_uuid", b());
                map.put("isPersonalizedAdEnabled", String.valueOf(p039f2.n.w()));
                map.put("d_bit", com.android.packageinstaller.utils.i.f12907g ? "1" : HardwareInfo.DEFAULT_MAC_ADDRESS);
                map.put("apk_bit", apkInfo.getApkAbi());
                map.put("app_sec_check", p039f2.n.r(InstallerApplication.f12479h) ? "1" : HardwareInfo.DEFAULT_MAC_ADDRESS);
                String strL = p039f2.n.l();
                H3.m.e(strL, "getSecureSettingLocation(...)");
                map.put("se_location", strL);
                map.put("phoneDevice", com.android.packageinstaller.utils.i.F() ? "1" : HardwareInfo.DEFAULT_MAC_ADDRESS);
                p168y2.c0 c0Var = p168y2.c0.f27723a;
                String channelMessage = apkInfo.getChannelMessage();
                if (channelMessage == null) {
                    channelMessage = "";
                }
                map.put("appBundleMessage", c0Var.f(channelMessage));
                map.put("cdMd5", String.valueOf(apkInfo.getCdMd5()));
                map.put("underageMode", String.valueOf(com.android.packageinstaller.utils.r.c(null, 1, null)));
                map.put("enableAdvancedMode", p168y2.N.f27678a.t() ? "1" : HardwareInfo.DEFAULT_MAC_ADDRESS);
                map.put("isSession", String.valueOf(apkInfo.isSessionInstall()));
                if (apkInfo.isSessionInstall()) {
                    map.put("sessionSplitCount", String.valueOf(apkInfo.getSplitCount()));
                }
                map.putAll(E0.a.d());
                if (!p039f2.n.x(context)) {
                    p088m2.b bVar2 = (p088m2.b) p088m2.h.f(p088m2.b.class);
                    bVar.f15673a = this;
                    bVar.f15674b = obj4;
                    bVar.f15675c = callingPackage2;
                    bVar.f15676d = apkInfo2;
                    bVar.f15679g = 3;
                    objH = bVar2.h(map, bVar);
                    if (objH == objC) {
                        return objC;
                    }
                    c0647e = this;
                    obj3 = obj4;
                    tVar = (Q5.t) objH;
                    r6 = obj3;
                } else if (H3.m.a(p039f2.n.m(context), "enhance")) {
                    p088m2.b bVar3 = (p088m2.b) p088m2.h.f(p088m2.b.class);
                    bVar.f15673a = this;
                    bVar.f15674b = obj4;
                    bVar.f15675c = callingPackage2;
                    bVar.f15676d = apkInfo2;
                    bVar.f15679g = 1;
                    objH = bVar3.d(map, bVar);
                    if (objH == objC) {
                        return objC;
                    }
                    c0647e = this;
                    obj = obj4;
                    tVar = (Q5.t) objH;
                    r6 = obj;
                } else {
                    p088m2.b bVar4 = (p088m2.b) p088m2.h.f(p088m2.b.class);
                    bVar.f15673a = this;
                    bVar.f15674b = obj4;
                    bVar.f15675c = callingPackage2;
                    bVar.f15676d = apkInfo2;
                    bVar.f15679g = 2;
                    objH = bVar4.e(map, bVar);
                    if (objH == objC) {
                        return objC;
                    }
                    c0647e = this;
                    obj2 = obj4;
                    tVar = (Q5.t) objH;
                    r6 = obj2;
                }
            } else if (i8 == 1) {
                ApkInfo apkInfo3 = (ApkInfo) bVar.f15676d;
                callingPackage2 = (CallingPackage) bVar.f15675c;
                Context context2 = (Context) bVar.f15674b;
                c0647e = (C0647e) bVar.f15673a;
                p138t3.o.b(objH);
                apkInfo2 = apkInfo3;
                obj = context2;
                tVar = (Q5.t) objH;
                r6 = obj;
            } else if (i8 == 2) {
                ApkInfo apkInfo4 = (ApkInfo) bVar.f15676d;
                callingPackage2 = (CallingPackage) bVar.f15675c;
                Context context3 = (Context) bVar.f15674b;
                c0647e = (C0647e) bVar.f15673a;
                p138t3.o.b(objH);
                apkInfo2 = apkInfo4;
                obj2 = context3;
                tVar = (Q5.t) objH;
                r6 = obj2;
            } else {
                if (i8 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ApkInfo apkInfo5 = (ApkInfo) bVar.f15676d;
                callingPackage2 = (CallingPackage) bVar.f15675c;
                Context context4 = (Context) bVar.f15674b;
                c0647e = (C0647e) bVar.f15673a;
                p138t3.o.b(objH);
                apkInfo2 = apkInfo5;
                obj3 = context4;
                tVar = (Q5.t) objH;
                r6 = obj3;
            }
            if (!tVar.d()) {
                if (tVar.b() == 570) {
                    return new CloudResult.Success(c0647e.a());
                }
                return CloudResult.OtherError.INSTANCE;
            }
            z5.C c6 = (z5.C) tVar.a();
            CloudParams cloudParams = c6 != null ? (CloudParams) new com.google.gson.e().l(c6.A(), CloudParams.class) : null;
            if (cloudParams != null) {
                p081l2.W w6 = p081l2.W.f21012a;
                String strP3 = callingPackage2.p();
                H3.m.e(strP3, "getLaunchedPackage(...)");
                w6.h(strP3, cloudParams);
                AuthFunction authFunction = cloudParams.authFunction;
                if (authFunction != null) {
                    B0.c.g(r6).D(H3.m.a(authFunction.getInstallerOpenSafetyModel(), kotlin.coroutines.jvm.internal.b.a(true)));
                    B0.c.g(r6).x(H3.m.a(authFunction.getInstallerCloseSafetyModel(), kotlin.coroutines.jvm.internal.b.a(true)));
                    B0.c.g(r6).I(H3.m.a(authFunction.getInstallerSingleAuth(), kotlin.coroutines.jvm.internal.b.a(true)));
                }
                UiConfig uiConfig = cloudParams.uiConfig;
                if (uiConfig != null && (num = uiConfig.f15695l) != null) {
                    XiaoMiSafe.Companion companion = XiaoMiSafe.f16218a;
                    Uri fileUri = apkInfo2.getFileUri();
                    if (fileUri == null || (path = fileUri.getPath()) == null) {
                        path = "";
                    }
                    H3.m.c(path);
                    H3.m.c(num);
                    companion.checkPackageSafe(path, num.intValue());
                }
                if (H3.m.a(cloudParams.showSafeModeTip, kotlin.coroutines.jvm.internal.b.a(true))) {
                    cloudParams.showSafeModeTip = kotlin.coroutines.jvm.internal.b.a(!B0.c.g(r6).l());
                }
            }
            return new CloudResult.Success(cloudParams);
        } catch (m2.c.b e6) {
            p168y2.r.c("AppMarket", "No network", e6);
            return CloudResult.NoNetworkError.INSTANCE;
        } catch (Exception e7) {
            String message = e7.getMessage();
            p168y2.r.c("AppMarket", message != null ? message : "", e7);
            e7.printStackTrace();
        }
    }

    public final Object d(Context context, CallingPackage callingPackage, int i6, ApkInfo apkInfo, p163x3.d<? super CloudResult> dVar) {
        return c(context, callingPackage, i6, apkInfo, new HashMap<>(), dVar);
    }
}
