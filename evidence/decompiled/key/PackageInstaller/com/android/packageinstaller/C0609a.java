package com.android.packageinstaller;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import miui.cloud.CloudPushConstants;

/* JADX INFO: renamed from: com.android.packageinstaller.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0609a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0609a f12582a = new C0609a();

    /* JADX INFO: renamed from: com.android.packageinstaller.a$a, reason: collision with other inner class name */
    public static final class C0202a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f12584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f12585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f12586d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f12587e;

        public C0202a(String str, String str2, long j6, long j7, int i6) {
            H3.m.f(str, "packageName");
            H3.m.f(str2, "appName");
            this.f12583a = str;
            this.f12584b = str2;
            this.f12585c = j6;
            this.f12586d = j7;
            this.f12587e = i6;
        }

        public final ContentValues a() {
            ContentValues contentValues = new ContentValues(5);
            contentValues.put("pkg_name", this.f12583a);
            contentValues.put("app_name", this.f12584b);
            contentValues.put("install_finish_time", Long.valueOf(this.f12585c));
            contentValues.put("app_tag_id", Long.valueOf(this.f12586d));
            contentValues.put("version_code", Integer.valueOf(this.f12587e));
            return contentValues;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0202a)) {
                return false;
            }
            C0202a c0202a = (C0202a) obj;
            return H3.m.a(this.f12583a, c0202a.f12583a) && H3.m.a(this.f12584b, c0202a.f12584b) && this.f12585c == c0202a.f12585c && this.f12586d == c0202a.f12586d && this.f12587e == c0202a.f12587e;
        }

        public int hashCode() {
            return (((((((this.f12583a.hashCode() * 31) + this.f12584b.hashCode()) * 31) + Long.hashCode(this.f12585c)) * 31) + Long.hashCode(this.f12586d)) * 31) + Integer.hashCode(this.f12587e);
        }

        public String toString() {
            return "Payload(packageName=" + this.f12583a + ", appName=" + this.f12584b + ", installFinishTime=" + this.f12585c + ", thirdLevelCategoryId=" + this.f12586d + ", versionCode=" + this.f12587e + ")";
        }
    }

    private C0609a() {
    }

    public final void a(Context context, C0202a c0202a) {
        H3.m.f(context, "ctx");
        H3.m.f(c0202a, CloudPushConstants.XML_PAYLOAD);
        ContentValues contentValuesA = c0202a.a();
        p047g3.c.g("AntiFraudInstallInfoTransferManager", "Insert antiFraud info to security: " + contentValuesA);
        try {
            context.getContentResolver().insert(Uri.parse("content://com.xiaomi.security.xsof.FraudDetectionProvider/install_app"), contentValuesA);
        } catch (Exception e6) {
            p047g3.c.e("AntiFraudInstallInfoTransferManager", "insert info failed: " + e6.getMessage());
        }
    }

    public final boolean b(Context context) {
        H3.m.f(context, "ctx");
        try {
            return context.getPackageManager().resolveContentProvider("com.xiaomi.security.xsof.FraudDetectionProvider", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
