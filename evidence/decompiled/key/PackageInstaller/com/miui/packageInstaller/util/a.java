package com.miui.packageInstaller.util;

import F2.e;
import H3.m;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.android.packageinstaller.I;
import com.android.packageinstaller.utils.C0635g;
import com.android.packageinstaller.utils.t;
import com.miui.packageInstaller.CallingPackage;
import com.miui.packageInstaller.model.ApkInfo;
import com.miui.packageInstaller.model.CInfo;
import com.miui.packageInstaller.model.CloudParams;
import com.miui.packageInstaller.util.a;
import com.xiaomi.accountsdk.hasheddeviceidlib.HardwareInfo;
import com.xiaomi.accountsdk.utils.AESCoder;
import com.xiaomi.onetrack.util.z;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p074k2.h;
import p168y2.V;
import p168y2.r;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16219a = new a();

    private a() {
    }

    private final byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(c(bArr2), "AES");
            Cipher cipher = Cipher.getInstance(AESCoder.AES_ALGORITHM);
            cipher.init(1, secretKeySpec, new IvParameterSpec(XiaoMiSafe.f16218a.getKeyViBytes()));
            return cipher.doFinal(bArr);
        } catch (Exception e6) {
            r.a("APKFILE", "encrypt failed!" + e6.getMessage());
            return null;
        }
    }

    private final byte[] c(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (bArr != null) {
                messageDigest.update(bArr);
            }
            byte[] bArrDigest = messageDigest.digest();
            m.c(bArrDigest);
            return bArrDigest;
        } catch (NoSuchAlgorithmException e6) {
            throw new RuntimeException(e6);
        }
    }

    private final String d(ApkInfo apkInfo) {
        PackageInfo packageInfo;
        StringBuffer stringBuffer = new StringBuffer();
        if (((apkInfo == null || (packageInfo = apkInfo.getPackageInfo()) == null) ? null : packageInfo.requestedPermissions) != null) {
            PackageInfo packageInfo2 = apkInfo.getPackageInfo();
            String[] strArr = packageInfo2 != null ? packageInfo2.requestedPermissions : null;
            m.c(strArr);
            for (String str : strArr) {
                stringBuffer.append(str);
                stringBuffer.append(z.f17604b);
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
            }
        }
        String string = stringBuffer.toString();
        m.e(string, "toString(...)");
        return string;
    }

    private final byte[] e(long j6, long j7, String str) {
        if (str != null && str.length() != 0) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
                long length = randomAccessFile.length() - j6;
                if (length < 0) {
                    return null;
                }
                byte[] bArr = length >= j7 ? new byte[(int) j7] : new byte[(int) length];
                randomAccessFile.seek(j6);
                randomAccessFile.read(bArr);
                randomAccessFile.close();
                return bArr;
            } catch (Exception e6) {
                r.a("APKFILE", "readPartOfFile failed!" + e6.getMessage());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(CallingPackage callingPackage, ApkInfo apkInfo, boolean z6, h hVar) throws Throwable {
        CInfo cInfo;
        Boolean tFlag;
        CloudParams cloudParamsI;
        CInfo cInfo2;
        byte[] bArrE;
        CInfo cInfo3;
        m.f(callingPackage, "$callingPackage");
        m.f(apkInfo, "$apkInfo");
        HashMap map = new HashMap();
        String strP = callingPackage.p();
        Long cOffset = null;
        if (strP == null) {
            strP = null;
        }
        map.put("appSourcepackageName", strP);
        String str = callingPackage.f15408f;
        if (str == null) {
            str = null;
        }
        map.put("appSourceValue", str);
        map.put("packageName", String.valueOf(apkInfo.getPackageName()));
        map.put("touchInstallCnt", "1");
        map.put("installCnt", z6 ? "1" : HardwareInfo.DEFAULT_MAC_ADDRESS);
        map.put("installTime", String.valueOf(System.currentTimeMillis()));
        map.put("name", String.valueOf(apkInfo.getLabel()));
        map.put("versionCode", String.valueOf(apkInfo.getVersionCode()));
        map.put("versionName", apkInfo.getVersionName());
        map.put("fingerprint", String.valueOf(apkInfo.getApkSignature()));
        map.put("apkHash", String.valueOf(apkInfo.getApkMd5()));
        map.put("apkSize", String.valueOf(apkInfo.getFileSize()));
        a aVar = f16219a;
        map.put("permission", aVar.d(apkInfo));
        String str2 = callingPackage.f15411i;
        if (str2 != null) {
            map.put("apkPath", str2);
        }
        map.put("cdMd5", String.valueOf(apkInfo.getCdMd5()));
        if (hVar != null && (cloudParamsI = hVar.I()) != null && (cInfo2 = cloudParamsI.cInfo) != null && m.a(cInfo2.getCFlag(), Boolean.TRUE)) {
            Long cSize = cInfo2.getCSize();
            if (cSize != null && cSize.longValue() == 0) {
                bArrE = null;
            } else {
                Long cOffset2 = cInfo2.getCOffset();
                if (cOffset2 != null) {
                    long jLongValue = cOffset2.longValue();
                    Long cSize2 = cInfo2.getCSize();
                    if (cSize2 != null) {
                        long jLongValue2 = cSize2.longValue();
                        Uri fileUri = apkInfo.getFileUri();
                        bArrE = aVar.e(jLongValue, jLongValue2, fileUri != null ? fileUri.getPath() : null);
                    }
                }
            }
            if (bArrE != null) {
                byte[] bArrB = aVar.b(bArrE, XiaoMiSafe.f16218a.getKeyBytes());
                CloudParams cloudParams = apkInfo.getCloudParams();
                if (cloudParams != null && (cInfo3 = cloudParams.cInfo) != null) {
                    cOffset = cInfo3.getCOffset();
                }
                map.put("cOffset", String.valueOf(cOffset));
                map.put("cSize", String.valueOf(bArrE.length));
                map.put("cToken", Base64.getEncoder().encodeToString(bArrB));
                map.put("cMd5", C0635g.d(bArrE));
            }
        }
        String tInfo = apkInfo.getTInfo();
        if (tInfo == null || tInfo.length() == 0) {
            new e().c().g();
        } else {
            map.put("tInfo", String.valueOf(apkInfo.getTInfo()));
        }
        CloudParams cloudParams2 = apkInfo.getCloudParams();
        if (cloudParams2 != null && (cInfo = cloudParams2.cInfo) != null && (tFlag = cInfo.getTFlag()) != null) {
            map.put("tFlag", String.valueOf(tFlag.booleanValue()));
        }
        r.a("InstallDataReporter", "report result: " + t.m(map, I.f12442e));
    }

    public final void f(final CallingPackage callingPackage, final ApkInfo apkInfo, final boolean z6, final h hVar) {
        m.f(callingPackage, "callingPackage");
        m.f(apkInfo, "apkInfo");
        V.b().h(new Runnable() { // from class: y2.m
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                a.g(callingPackage, apkInfo, z6, hVar);
            }
        });
    }
}
