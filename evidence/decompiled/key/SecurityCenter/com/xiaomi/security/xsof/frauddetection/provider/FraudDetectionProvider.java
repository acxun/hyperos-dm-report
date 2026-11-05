package com.xiaomi.security.xsof.frauddetection.provider;

import Qa.d;
import Qa.f;
import Ra.k;
import Ta.g;
import Wa.b;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.miui.common.e;
import com.miui.warningcenter.caraccident.utils.AnalyticUtils;
import com.xiaomi.onetrack.h.b.a;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import p278tb.n;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJQ\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ3\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ=\u0010 \u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0011\u0018\u00010\u0010H\u0016¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/xiaomi/security/xsof/frauddetection/provider/FraudDetectionProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "Landroid/content/ContentValues;", AnalyticUtils.PARAMS_KEY_VALUES, "Leb/w;", "c", "(Landroid/content/ContentValues;)V", "b", "a", "", "onCreate", "()Z", "Landroid/net/Uri;", "uri", "", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "core-service_cnRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FraudDetectionProvider extends ContentProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final UriMatcher f38260b;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f38260b = uriMatcher;
        uriMatcher.addURI("com.xiaomi.security.xsof.FraudDetectionProvider", "install_app", 101);
        uriMatcher.addURI("com.xiaomi.security.xsof.FraudDetectionProvider", "call_forwarding", 102);
        uriMatcher.addURI("com.xiaomi.security.xsof.FraudDetectionProvider", "fraud_url", 103);
    }

    private final void a(ContentValues values) {
        try {
            b.a("FraudDetectionProvider", "insert call forwarding start");
            if (!n.b("com.android.phone", getCallingPackage())) {
                b.b("FraudDetectionProvider", "callingPackage is " + getCallingPackage() + ", return");
                return;
            }
            if (!g.f9147a.f(getCallingPackage())) {
                b.b("FraudDetectionProvider", "insertCallForwardingInfo callingPackage is " + getCallingPackage() + ", not signed with platform key, return");
                return;
            }
            Integer asInteger = values.getAsInteger(a.f37439g);
            int iIntValue = asInteger != null ? asInteger.intValue() : -1;
            Integer asInteger2 = values.getAsInteger("enabled");
            int iIntValue2 = asInteger2 != null ? asInteger2.intValue() : -1;
            Long asLong = values.getAsLong("timestamp");
            long jLongValue = asLong != null ? asLong.longValue() : System.currentTimeMillis();
            d dVar = new d(Integer.valueOf(iIntValue), iIntValue2, jLongValue);
            int i10 = 1;
            if (iIntValue2 != 1 || iIntValue != 0) {
                i10 = 0;
            }
            Ta.d.f9144a.m(e.c(), i10);
            k.f8517c.a().Y0(dVar);
            b.a("FraudDetectionProvider", "callForwarding: reason = " + iIntValue + ", enable = " + iIntValue2 + ", timeStamp = " + jLongValue);
            b.a("FraudDetectionProvider", "insert callForwardingInfo finish");
        } catch (Exception e10) {
            b.b("FraudDetectionProvider", "insert callForwardingInfo error: " + e10.getMessage());
        }
    }

    private final void b(ContentValues values) {
        try {
            b.a("FraudDetectionProvider", "insert fraud url start");
            if (!n.b("com.android.browser", getCallingPackage())) {
                b.b("FraudDetectionProvider", "insertFraudUrl callingPackage is " + getCallingPackage() + ", return");
                return;
            }
            if (g.f9147a.f(getCallingPackage())) {
                Long asLong = values.getAsLong("access_time");
                long jLongValue = asLong != null ? asLong.longValue() : System.currentTimeMillis();
                Integer asInteger = values.getAsInteger("url_type");
                k.f8517c.a().a1(new f(jLongValue, asInteger != null ? asInteger.intValue() : 0));
                b.a("FraudDetectionProvider", "insert fraud url finish");
                return;
            }
            b.b("FraudDetectionProvider", "insertFraudUrl callingPackage is " + getCallingPackage() + ", not signed with platform key, return");
        } catch (Exception e10) {
            b.b("FraudDetectionProvider", "insert fraud url error: " + e10.getMessage());
        }
    }

    private final void c(ContentValues values) {
        b.a("FraudDetectionProvider", "insert app info start");
        try {
            if (!n.b("com.xiaomi.market", getCallingPackage()) && !n.b("com.miui.packageinstaller", getCallingPackage())) {
                b.b("FraudDetectionProvider", "insertInstallAppInfo callingPackage is " + getCallingPackage() + ", return");
                return;
            }
            if (!g.f9147a.f(getCallingPackage())) {
                b.b("FraudDetectionProvider", "insertInstallAppInfo callingPackage is " + getCallingPackage() + ", not signed with platform key, return");
                return;
            }
            String asString = values.getAsString("app_name");
            String str = "";
            String str2 = asString == null ? "" : asString;
            String asString2 = values.getAsString("pkg_name");
            String str3 = asString2 == null ? "" : asString2;
            Integer asInteger = values.getAsInteger("version_code");
            int iIntValue = asInteger != null ? asInteger.intValue() : 0;
            Long asLong = values.getAsLong("install_finish_time");
            Long asLong2 = values.getAsLong("app_tag_id");
            long jLongValue = asLong2 != null ? asLong2.longValue() : 0L;
            int iA = Ta.b.f9129a.a(jLongValue);
            if (jLongValue == -1) {
                boolean zE = Ta.e.f9145a.e(5L, TimeUnit.MINUTES);
                b.a("FraudDetectionProvider", "closedByUser5minAgo: " + zE);
                iA = zE ? Ta.b.EnumC0119b.SUSPICIOUS.b() : 0;
            }
            String callingPackage = getCallingPackage();
            Integer numValueOf = Integer.valueOf(iIntValue);
            n.c(asLong);
            long jLongValue2 = asLong.longValue();
            Long lValueOf = Long.valueOf(jLongValue);
            Integer numValueOf2 = Integer.valueOf(iA);
            if (callingPackage != null) {
                str = callingPackage;
            }
            k.f8517c.a().W0(new Qa.b(str3, str2, numValueOf, "", jLongValue2, lValueOf, numValueOf2, str));
            b.a("FraudDetectionProvider", "insert app info finish");
        } catch (Exception e10) {
            b.b("FraudDetectionProvider", "insert app info error: " + e10.getMessage());
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        n.f(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        n.f(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        n.f(uri, "uri");
        b.a("FraudDetectionProvider", "insert " + uri);
        switch (f38260b.match(uri)) {
            case 101:
                if (values == null) {
                    return null;
                }
                c(values);
                return uri;
            case 102:
                if (values == null) {
                    return null;
                }
                a(values);
                return uri;
            case 103:
                if (values == null) {
                    return null;
                }
                b(values);
                return uri;
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        n.f(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        n.f(uri, "uri");
        return 0;
    }
}
