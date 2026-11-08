package com.android.packageinstaller;

/* JADX INFO: loaded from: classes.dex */
public class I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f12438a = "https://api.installer.xiaomi.com";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f12443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12445h;

    static {
        String str = E0.c.f586d;
        if ("staging" == str) {
            f12438a = "http://api-installer.pt.xiaomi.com";
        } else if ("preview" == str) {
            f12438a = "http://preview-api.installer.xiaomi.com";
        } else if ("test" == str) {
            f12438a = "http://test-api-installer.pt.xiaomi.com";
        }
        f12439b = f12438a + "/v2/game/interceptcheck";
        f12440c = f12438a + "/v3/game/interceptcheck";
        f12441d = f12438a + "/v2/cloud_config/query";
        f12442e = f12438a + "/avl/upload";
        f12443f = f12438a + "/pkg/risk/type/all";
        f12444g = f12438a + "/passport/identity/url";
        f12445h = "/passport/callback";
    }
}
