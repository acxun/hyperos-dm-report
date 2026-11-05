package Ra;

import Qa.m;
import Qa.o;
import Qa.p;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.miui.common.utils.N0;
import com.miui.earthquakewarning.model.SaveAreaResult;
import com.miui.gamebooster.aihelper.GameAIHttpResp;
import com.xiaomi.continuity.constant.MiContinuityStatus;
import java.util.ArrayList;
import java.util.List;
import p068eb.l;
import p278tb.n;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends SQLiteOpenHelper implements Ra.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f8517c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f8518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f8519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final p068eb.h f8521g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f8522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f8523b;

    public static final class a {
        public /* synthetic */ a(p278tb.h hVar) {
            this();
        }

        public final k a() {
            return (k) k.f8521g.getValue();
        }

        private a() {
        }
    }

    private static final class b extends Handler {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper) {
            super(looper);
            n.f(looper, "looper");
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            n.f(message, "msg");
            super.dispatchMessage(message);
            int i10 = message.what;
            if (i10 == 101) {
                if (message.obj instanceof Qa.k) {
                    k kVarA = k.f8517c.a();
                    Object obj = message.obj;
                    n.d(obj, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.ScreenshotInfo");
                    kVarA.e1((Qa.k) obj);
                }
                return;
            }
            if (i10 == 102) {
                if (message.obj instanceof Qa.g) {
                    k kVarA2 = k.f8517c.a();
                    Object obj2 = message.obj;
                    n.d(obj2, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.ICallBack<kotlin.collections.MutableList<com.xiaomi.security.xsof.frauddetection.bean.ScreenshotInfo>?>");
                    kVarA2.M1((Qa.g) obj2);
                    return;
                }
                return;
            }
            if (i10 == 301) {
                if (message.obj instanceof Qa.b) {
                    k kVarA3 = k.f8517c.a();
                    Object obj3 = message.obj;
                    n.d(obj3, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.AppInfo");
                    kVarA3.X0((Qa.b) obj3);
                    return;
                }
                return;
            }
            if (i10 == 302) {
                if (message.obj instanceof Qa.g) {
                    k kVarA4 = k.f8517c.a();
                    Object obj4 = message.obj;
                    n.d(obj4, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.ICallBack<kotlin.collections.MutableList<com.xiaomi.security.xsof.frauddetection.bean.AppInfo>?>");
                    kVarA4.G1((Qa.g) obj4);
                    return;
                }
                return;
            }
            if (i10 == 401) {
                if (message.obj instanceof Qa.f) {
                    k kVarA5 = k.f8517c.a();
                    Object obj5 = message.obj;
                    n.d(obj5, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.FraudUrlInfo");
                    kVarA5.i1((Qa.f) obj5);
                    return;
                }
                return;
            }
            if (i10 == 402) {
                k kVarA6 = k.f8517c.a();
                Object obj6 = message.obj;
                n.d(obj6, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.ICallBack<kotlin.collections.MutableList<com.xiaomi.security.xsof.frauddetection.bean.FraudUrlInfo>?>");
                kVarA6.D1((Qa.g) obj6);
                return;
            }
            if (i10 == 501) {
                if (message.obj instanceof Qa.d) {
                    k kVarA7 = k.f8517c.a();
                    Object obj7 = message.obj;
                    n.d(obj7, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.CallForwardingInfo");
                    kVarA7.Z0((Qa.d) obj7);
                    return;
                }
                return;
            }
            if (i10 == 502) {
                if (message.obj instanceof Qa.g) {
                    k kVarA8 = k.f8517c.a();
                    Object obj8 = message.obj;
                    n.d(obj8, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.ICallBack<kotlin.collections.MutableList<com.xiaomi.security.xsof.frauddetection.bean.CallForwardingInfo>?>");
                    kVarA8.x1((Qa.g) obj8);
                    return;
                }
                return;
            }
            if (i10 == 601) {
                if (message.obj instanceof Qa.a) {
                    k kVarA9 = k.f8517c.a();
                    Object obj9 = message.obj;
                    n.d(obj9, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.AirplaneModeInfo");
                    kVarA9.V0((Qa.a) obj9);
                    return;
                }
                return;
            }
            if (i10 == 602) {
                if (message.obj instanceof Qa.g) {
                    k kVarA10 = k.f8517c.a();
                    Object obj10 = message.obj;
                    n.d(obj10, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.ICallBack<kotlin.collections.MutableList<com.xiaomi.security.xsof.frauddetection.bean.AirplaneModeInfo>?>");
                    kVarA10.r1((Qa.g) obj10);
                    return;
                }
                return;
            }
            if (i10 == 901) {
                if (message.obj instanceof Qa.b) {
                    k kVarA11 = k.f8517c.a();
                    Object obj11 = message.obj;
                    n.d(obj11, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.AppInfo");
                    kVarA11.X0((Qa.b) obj11);
                    return;
                }
                return;
            }
            if (i10 == 902) {
                if (message.obj instanceof Qa.g) {
                    k kVarA12 = k.f8517c.a();
                    Object obj12 = message.obj;
                    n.d(obj12, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.ICallBack<kotlin.collections.MutableList<com.xiaomi.security.xsof.frauddetection.bean.AppInfo>?>");
                    kVarA12.G1((Qa.g) obj12);
                    return;
                }
                return;
            }
            switch (i10) {
                case 201:
                    if (message.obj instanceof Qa.j) {
                        k kVarA13 = k.f8517c.a();
                        Object obj13 = message.obj;
                        n.d(obj13, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.ScreenShareInfo");
                        kVarA13.c1((Qa.j) obj13);
                    }
                    break;
                case MiContinuityStatus.CLIENT_CHANNEL_INACTIVE /* 202 */:
                    if (message.obj instanceof Qa.j) {
                        k kVarA14 = k.f8517c.a();
                        Object obj14 = message.obj;
                        n.d(obj14, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.ScreenShareInfo");
                        kVarA14.Z1((Qa.j) obj14);
                    }
                    break;
                case MiContinuityStatus.CLIENT_SOCKET_CLOSE /* 203 */:
                    if (message.obj instanceof Qa.g) {
                        k kVarA15 = k.f8517c.a();
                        Object obj15 = message.obj;
                        n.d(obj15, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.ICallBack<kotlin.collections.MutableList<com.xiaomi.security.xsof.frauddetection.bean.ScreenShareInfo>?>");
                        kVarA15.O1((Qa.g) obj15);
                    }
                    break;
                default:
                    switch (i10) {
                        case 701:
                            if (message.obj instanceof m) {
                                k kVarA16 = k.f8517c.a();
                                Object obj16 = message.obj;
                                n.d(obj16, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.SimCardFraudInfo");
                                kVarA16.g1((m) obj16);
                            }
                            break;
                        case 702:
                            k kVarA17 = k.f8517c.a();
                            Object obj17 = message.obj;
                            n.d(obj17, "null cannot be cast to non-null type kotlin.String");
                            kVarA17.b2((String) obj17);
                            break;
                        case 703:
                            k kVarA18 = k.f8517c.a();
                            Object obj18 = message.obj;
                            n.d(obj18, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.ICallBack<kotlin.collections.MutableList<com.xiaomi.security.xsof.frauddetection.bean.SimCardFraudInfo>?>");
                            kVarA18.S1((Qa.g) obj18, message.arg1);
                            break;
                        default:
                            switch (i10) {
                                case GameAIHttpResp.CODE_PARAM_ERROR /* 801 */:
                                    if (message.obj instanceof Qa.n) {
                                        k kVarA19 = k.f8517c.a();
                                        Object obj19 = message.obj;
                                        n.d(obj19, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.VoipRecordInfo");
                                        kVarA19.k1((Qa.n) obj19);
                                    }
                                    break;
                                case 802:
                                    if (message.obj instanceof Qa.n) {
                                        k kVarA20 = k.f8517c.a();
                                        Object obj20 = message.obj;
                                        n.d(obj20, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.VoipRecordInfo");
                                        kVarA20.d2((Qa.n) obj20, message.arg1);
                                    }
                                    break;
                                case 803:
                                    k kVarA21 = k.f8517c.a();
                                    Object obj21 = message.obj;
                                    n.d(obj21, "null cannot be cast to non-null type com.xiaomi.security.xsof.frauddetection.bean.ICallBack<kotlin.collections.MutableList<com.xiaomi.security.xsof.frauddetection.bean.VoipRecordInfo>?>");
                                    kVarA21.V1((Qa.g) obj21, message.arg1);
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
    }

    static {
        String simpleName = k.class.getSimpleName();
        n.e(simpleName, "getSimpleName(...)");
        f8518d = simpleName;
        String str = "/data/misc/user/" + N0.G() + "/securitycenter/";
        f8519e = str;
        f8520f = str + "fraud_detection_data.db";
        f8521g = p068eb.i.a(l.SYNCHRONIZED, new p264sb.a() { // from class: Ra.b
            @Override // p264sb.a
            public final Object invoke() {
                return k.l1();
            }
        });
    }

    private k() {
        super(com.miui.common.e.c(), f8520f, (SQLiteDatabase.CursorFactory) null, 1);
        HandlerThread handlerThread = new HandlerThread("FraudDetectionDBThread");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        n.e(looper, "getLooper(...)");
        this.f8522a = new b(looper);
        this.f8523b = new Handler(Looper.getMainLooper());
    }

    private final List B1() {
        ArrayList arrayList = new ArrayList();
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return arrayList;
        }
        SQLiteDatabase readableDatabase = f8517c.a().getReadableDatabase();
        n.e(readableDatabase, "getReadableDatabase(...)");
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = readableDatabase.rawQuery(Ra.a.f8499w.h("fraud_url", "access_time"), null);
                while (cursorRawQuery.moveToNext()) {
                    Qa.f fVarP0 = P0(cursorRawQuery);
                    if (fVarP0 != null) {
                        arrayList.add(fVarP0);
                    }
                }
                Wa.b.a(f8518d, "search fraud url list size = " + arrayList.size());
                cursorRawQuery.close();
                return arrayList;
            } catch (Exception e10) {
                Wa.b.b(f8518d, "searchFraudUrlList: " + e10.getMessage());
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1(final Qa.g gVar) {
        final List listB1 = B1();
        Handler handler = this.f8523b;
        if (handler != null) {
            handler.post(new Runnable() { // from class: Ra.d
                @Override // java.lang.Runnable
                public final void run() {
                    k.E1(gVar, listB1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(Qa.g gVar, List list) {
        gVar.onSuccess(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G1(final Qa.g gVar) {
        final List listU1 = u1();
        Handler handler = this.f8523b;
        if (handler != null) {
            handler.post(new Runnable() { // from class: Ra.e
                @Override // java.lang.Runnable
                public final void run() {
                    k.H1(gVar, listU1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(Qa.g gVar, List list) {
        gVar.onSuccess(list);
    }

    private final List I1() {
        ArrayList arrayList = new ArrayList();
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return arrayList;
        }
        SQLiteDatabase readableDatabase = f8517c.a().getReadableDatabase();
        n.e(readableDatabase, "getReadableDatabase(...)");
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM screen_share WHERE screen_share_start_time > " + (System.currentTimeMillis() - 259200000) + " ORDER BY screen_share_start_time DESC", null);
                while (cursorRawQuery.moveToNext()) {
                    Qa.j jVarQ0 = Q0(cursorRawQuery);
                    if (jVarQ0 != null) {
                        arrayList.add(jVarQ0);
                    }
                }
                Wa.b.a(f8518d, "search screenShare size = " + arrayList.size());
                cursorRawQuery.close();
                return arrayList;
            } catch (Exception e10) {
                Wa.b.b(f8518d, "searchScreenShare: " + e10.getMessage());
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    private final ContentValues J0(Qa.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("airplane_mode_on", Integer.valueOf(aVar.f() ? 1 : 0));
        contentValues.put("airplane_mode_change_time", Long.valueOf(aVar.e()));
        return contentValues;
    }

    private final ContentValues K0(Qa.b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pkg_name", bVar.h());
        contentValues.put("app_name", bVar.g());
        contentValues.put("version_code", bVar.l());
        contentValues.put("md5", bVar.f());
        contentValues.put("install_finish_time", Long.valueOf(bVar.k()));
        contentValues.put("app_tag_id", bVar.e());
        contentValues.put("security_tag_id", bVar.i());
        contentValues.put(SaveAreaResult.Columns.source, bVar.j());
        return contentValues;
    }

    private final List K1() {
        ArrayList arrayList = new ArrayList();
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return arrayList;
        }
        SQLiteDatabase readableDatabase = f8517c.a().getReadableDatabase();
        n.e(readableDatabase, "getReadableDatabase(...)");
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = readableDatabase.rawQuery(Ra.a.f8499w.h("screenshot", "screenshort_time"), null);
                while (cursorRawQuery.moveToNext()) {
                    arrayList.add(R0(cursorRawQuery));
                }
                Wa.b.a(f8518d, "search screenshots size = " + arrayList.size());
                cursorRawQuery.close();
                return arrayList;
            } catch (Exception e10) {
                Wa.b.b(f8518d, "searchScreenshots: " + e10.getMessage());
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    private final ContentValues L0(Qa.d dVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(com.xiaomi.onetrack.h.b.a.f37439g, dVar.g());
        contentValues.put("enabled", Integer.valueOf(dVar.f()));
        contentValues.put("timestamp", Long.valueOf(dVar.h()));
        return contentValues;
    }

    private final Qa.a M0(Cursor cursor) {
        try {
            long j10 = cursor.getLong(cursor.getColumnIndex("airplane_mode_change_time"));
            boolean z10 = true;
            if (cursor.getInt(cursor.getColumnIndex("airplane_mode_on")) != 1) {
                z10 = false;
            }
            return new Qa.a(z10, j10);
        } catch (Exception e10) {
            Wa.b.b(f8518d, "cursor2AirplaneModeInfo: " + e10.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1(final Qa.g gVar) {
        final List listK1 = K1();
        Handler handler = this.f8523b;
        if (handler != null) {
            handler.post(new Runnable() { // from class: Ra.h
                @Override // java.lang.Runnable
                public final void run() {
                    k.N1(gVar, listK1);
                }
            });
        }
    }

    private final Qa.b N0(Cursor cursor) {
        try {
            String string = cursor.getString(cursor.getColumnIndex("app_name"));
            String string2 = cursor.getString(cursor.getColumnIndex("pkg_name"));
            int i10 = cursor.getInt(cursor.getColumnIndex("version_code"));
            return new Qa.b(string2, string, Integer.valueOf(i10), cursor.getString(cursor.getColumnIndex("md5")), cursor.getLong(cursor.getColumnIndex("install_finish_time")), Long.valueOf(cursor.getLong(cursor.getColumnIndex("app_tag_id"))), Integer.valueOf(cursor.getInt(cursor.getColumnIndex("security_tag_id"))), cursor.getString(cursor.getColumnIndex(SaveAreaResult.Columns.source)));
        } catch (Exception e10) {
            Wa.b.b(f8518d, "cursor2AppInfo: " + e10.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(Qa.g gVar, List list) {
        gVar.onSuccess(list);
    }

    private final Qa.d O0(Cursor cursor) {
        try {
            return new Qa.d(Integer.valueOf(cursor.getInt(cursor.getColumnIndex(com.xiaomi.onetrack.h.b.a.f37439g))), cursor.getInt(cursor.getColumnIndex("enabled")), cursor.getLong(cursor.getColumnIndex("timestamp")));
        } catch (Exception e10) {
            Wa.b.b(f8518d, "cursor2CallForwardingInfo: " + e10.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1(final Qa.g gVar) {
        final List listI1 = I1();
        Handler handler = this.f8523b;
        if (handler != null) {
            handler.post(new Runnable() { // from class: Ra.f
                @Override // java.lang.Runnable
                public final void run() {
                    k.P1(gVar, listI1);
                }
            });
        }
    }

    private final Qa.f P0(Cursor cursor) {
        try {
            return new Qa.f(cursor.getLong(cursor.getColumnIndex("access_time")), cursor.getInt(cursor.getColumnIndex("url_type")));
        } catch (Exception e10) {
            Wa.b.b(f8518d, "cursor2FraudUrlInfo: " + e10.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(Qa.g gVar, List list) {
        gVar.onSuccess(list);
    }

    private final Qa.j Q0(Cursor cursor) {
        try {
            String string = cursor.getString(cursor.getColumnIndex("screen_share_package_name"));
            long j10 = cursor.getLong(cursor.getColumnIndex("screen_share_start_time"));
            long j11 = cursor.getLong(cursor.getColumnIndex("screen_share_end_time"));
            boolean z10 = cursor.getInt(cursor.getColumnIndex("is_active")) == 1;
            long j12 = cursor.getLong(cursor.getColumnIndex("duration"));
            n.c(string);
            return new Qa.j(string, j10, j11, j12, z10);
        } catch (Exception e10) {
            Wa.b.b(f8518d, "cursor2ScreenShareInfo: " + e10.getMessage());
            return null;
        }
    }

    private final List Q1(int i10) {
        String strD;
        ArrayList arrayList = new ArrayList();
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return arrayList;
        }
        SQLiteDatabase readableDatabase = f8517c.a().getReadableDatabase();
        n.e(readableDatabase, "getReadableDatabase(...)");
        if (i10 == Qa.l.TYPE_ALL_CALL.b()) {
            strD = Ra.a.f8499w.a();
        } else if (i10 == Qa.l.TYPE_FRAUD_CALL.b()) {
            strD = Ra.a.f8499w.b();
        } else if (i10 == Qa.l.TYPE_OVERSEAS_CALL.b()) {
            strD = Ra.a.f8499w.c();
        } else {
            if (i10 != Qa.l.TYPE_VIRTUAL_OPERATOR_CALL.b()) {
                Wa.b.b(f8518d, "searchSimCardFraud: searchType error");
                return arrayList;
            }
            strD = Ra.a.f8499w.d();
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = readableDatabase.rawQuery(strD, null);
                while (cursorRawQuery.moveToNext()) {
                    m mVarS0 = S0(cursorRawQuery);
                    if (mVarS0 != null) {
                        arrayList.add(mVarS0);
                    }
                }
                Wa.b.a(f8518d, "search sim card fraud size = " + arrayList.size());
                cursorRawQuery.close();
                return arrayList;
            } catch (Exception e10) {
                Wa.b.b(f8518d, "searchSimCardFraud: " + e10.getMessage());
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    private final Qa.k R0(Cursor cursor) {
        return new Qa.k(cursor.getLong(cursor.getColumnIndex("screenshort_time")));
    }

    private final m S0(Cursor cursor) {
        try {
            String string = cursor.getString(cursor.getColumnIndex("tel_number_md5"));
            long j10 = cursor.getLong(cursor.getColumnIndex("call_start_time"));
            long j11 = cursor.getLong(cursor.getColumnIndex("call_end_time"));
            String string2 = cursor.getString(cursor.getColumnIndex("tel_location"));
            String string3 = cursor.getString(cursor.getColumnIndex("operator"));
            boolean z10 = cursor.getInt(cursor.getColumnIndex("is_chinese_number")) == 1;
            boolean z11 = cursor.getInt(cursor.getColumnIndex("is_virtual_operator")) == 1;
            boolean z12 = cursor.getInt(cursor.getColumnIndex("is_active")) == 1;
            long j12 = cursor.getLong(cursor.getColumnIndex("duration"));
            boolean z13 = cursor.getInt(cursor.getColumnIndex("is_fraud_call")) == 1;
            n.c(string);
            return new m(string, j10, j11, string2, string3, z10, z11, z12, j12, z13);
        } catch (Exception e10) {
            Wa.b.b(f8518d, "cursor2SimCardFraudInfo: " + e10.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(final Qa.g gVar, int i10) {
        final List listQ1 = Q1(i10);
        Handler handler = this.f8523b;
        if (handler != null) {
            handler.post(new Runnable() { // from class: Ra.i
                @Override // java.lang.Runnable
                public final void run() {
                    k.T1(gVar, listQ1);
                }
            });
        }
    }

    private final Qa.n T0(Cursor cursor) {
        try {
            String string = cursor.getString(cursor.getColumnIndex("voip_record_package_name"));
            n.e(string, "getString(...)");
            long j10 = cursor.getLong(cursor.getColumnIndex("voip_record_start_time"));
            long j11 = cursor.getLong(cursor.getColumnIndex("voip_record_end_time"));
            long j12 = cursor.getLong(cursor.getColumnIndex("duration"));
            boolean z10 = true;
            boolean z11 = cursor.getInt(cursor.getColumnIndex("is_active")) == 1;
            if (cursor.getInt(cursor.getColumnIndex("is_fraud_call")) != 1) {
                z10 = false;
            }
            return new Qa.n(string, j10, j11, j12, z11, z10);
        } catch (Exception e10) {
            Wa.b.b(f8518d, "cursor2VoipRecordInfo::" + e10.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(Qa.g gVar, List list) {
        gVar.onSuccess(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0(Qa.a aVar) {
        try {
            String str = f8518d;
            Wa.b.a(str, "insertAirplaneModeInfoInHandlerThread: " + aVar + " ");
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                return;
            }
            Wa.b.a(str, "insert insertAirplaneModeInfoInHandlerThread result = " + f8517c.a().getWritableDatabase().insert("airplane_mode", null, J0(aVar)));
            n1("airplane_mode", "airplane_mode_change_time");
        } catch (Exception e10) {
            Wa.b.b(f8518d, "insertAirplaneModeInfoInHandlerThread: " + e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V1(final Qa.g gVar, int i10) {
        final List listX1 = X1(i10);
        Handler handler = this.f8523b;
        if (handler != null) {
            handler.post(new Runnable() { // from class: Ra.c
                @Override // java.lang.Runnable
                public final void run() {
                    k.W1(gVar, listX1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(Qa.g gVar, List list) {
        gVar.onSuccess(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(Qa.b bVar) {
        try {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                return;
            }
            long jInsert = f8517c.a().getWritableDatabase().insert("install_app", null, K0(bVar));
            Wa.b.a(f8518d, "insert appInfo result = " + jInsert);
            n1("install_app", "install_finish_time");
        } catch (Exception e10) {
            Wa.b.b(f8518d, "insertAppInfoData: " + e10.getMessage());
        }
    }

    private final List X1(int i10) {
        String strG;
        ArrayList arrayList = new ArrayList();
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return arrayList;
        }
        SQLiteDatabase readableDatabase = f8517c.a().getReadableDatabase();
        n.e(readableDatabase, "getReadableDatabase(...)");
        if (i10 == o.TYPE_ALL_CALL.b()) {
            strG = Ra.a.f8499w.e();
        } else {
            if (i10 != o.TYPE_FRAUD_CALL.b()) {
                Wa.b.b(f8518d, "searchVoipRecordList::searchType is errorType");
                return arrayList;
            }
            strG = Ra.a.f8499w.g();
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = readableDatabase.rawQuery(strG, null);
                while (cursorRawQuery.moveToNext()) {
                    Qa.n nVarT0 = T0(cursorRawQuery);
                    if (nVarT0 != null) {
                        arrayList.add(nVarT0);
                    }
                }
                Wa.b.a(f8518d, "search voip record list size = " + arrayList.size());
                cursorRawQuery.close();
                return arrayList;
            } catch (Exception e10) {
                Wa.b.b(f8518d, "searchVoipRecordList::" + e10.getMessage());
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0(Qa.d dVar) {
        try {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                return;
            }
            long jInsert = f8517c.a().getWritableDatabase().insert("call_forwarding", null, L0(dVar));
            Wa.b.a(f8518d, "insert callForwardingInfo result = " + jInsert);
            n1("call_forwarding", "timestamp");
        } catch (Exception e10) {
            Wa.b.b(f8518d, "insertCallForwardingInfoInHandlerThread: " + e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(Qa.j jVar) {
        String str = f8518d;
        Wa.b.a(str, "updateScreenShareWhenFinishedInHandlerThread: " + jVar + " ");
        if (n.b(Looper.myLooper(), Looper.getMainLooper())) {
            return;
        }
        String[] strArr = {jVar.h(), "1"};
        SQLiteDatabase writableDatabase = f8517c.a().getWritableDatabase();
        n.e(writableDatabase, "getWritableDatabase(...)");
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = writableDatabase.query("screen_share", null, "screen_share_package_name = ? AND is_active = ?", strArr, null, null, "screen_share_start_time DESC");
                if (cursorQuery.moveToNext()) {
                    long j10 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("screen_share_start_time"));
                    if (j10 > jVar.g()) {
                        cursorQuery.close();
                        return;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("screen_share_end_time", Long.valueOf(jVar.g()));
                    contentValues.put("is_active", (Integer) 0);
                    contentValues.put("duration", Long.valueOf(jVar.g() - j10));
                    Wa.b.a(str, "updateScreenShareEndTime::result = " + writableDatabase.update("screen_share", contentValues, "screen_share_package_name = ? AND is_active = ?", strArr));
                }
            } catch (Exception e10) {
                Wa.b.b(f8518d, "updateScreenShareWhenFinishedInHandlerThread: " + e10.getMessage());
                if (cursorQuery == null) {
                    return;
                }
            }
            cursorQuery.close();
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2(String str) {
        String str2 = f8518d;
        Wa.b.a(str2, "updateSimCardFraudStateWhenFinishedInHandlerThread: " + str + " ");
        if (n.b(Looper.myLooper(), Looper.getMainLooper())) {
            return;
        }
        String[] strArr = {str, "1"};
        SQLiteDatabase writableDatabase = f8517c.a().getWritableDatabase();
        n.e(writableDatabase, "getWritableDatabase(...)");
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = writableDatabase.query("fraud_phone", null, "tel_number_md5 = ? AND is_active = ?", strArr, null, null, "call_start_time DESC");
                if (cursorQuery.moveToNext()) {
                    long j10 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("call_start_time"));
                    ContentValues contentValues = new ContentValues();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    contentValues.put("call_end_time", Long.valueOf(jCurrentTimeMillis));
                    contentValues.put("is_active", (Integer) 0);
                    contentValues.put("duration", Long.valueOf(jCurrentTimeMillis - j10));
                    Wa.b.a(str2, "updateSimCardFraudStateWhenFinished::result = " + writableDatabase.update("fraud_phone", contentValues, "tel_number_md5 = ? AND is_active = ?", strArr));
                }
            } catch (Exception e10) {
                Wa.b.b(f8518d, "updateSimCardFraudStateWhenFinishedInHandlerThread: " + e10.getMessage());
                if (cursorQuery == null) {
                    return;
                }
            }
            cursorQuery.close();
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1(Qa.j jVar) {
        try {
            String str = f8518d;
            Wa.b.a(str, "insertScreenShareInHandlerThread: " + jVar + " ");
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                return;
            }
            Wa.b.a(str, "insert screen share = " + f8517c.a().getWritableDatabase().insert("screen_share", null, o1(jVar)));
            n1("screen_share", "screen_share_start_time");
        } catch (Exception e10) {
            Wa.b.b(f8518d, "insertScreenShareData: " + e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(Qa.n nVar, int i10) {
        String str = f8518d;
        Wa.b.a(str, "updateVoipRecordWhenFinishedInHandlerThread: " + nVar + " ");
        if (n.b(Looper.myLooper(), Looper.getMainLooper())) {
            return;
        }
        String[] strArr = {nVar.h(), "1"};
        SQLiteDatabase writableDatabase = f8517c.a().getWritableDatabase();
        n.e(writableDatabase, "getWritableDatabase(...)");
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = writableDatabase.query("voip_record", null, "voip_record_package_name = ? AND is_active = ?", strArr, null, null, "voip_record_start_time DESC");
                if (cursorQuery.moveToNext()) {
                    long j10 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("voip_record_start_time"));
                    if (j10 > nVar.g()) {
                        cursorQuery.close();
                        return;
                    }
                    ContentValues contentValues = new ContentValues();
                    if (i10 == p.TYPE_CHECK_IS_FRAUD_CALL.b()) {
                        contentValues.put("is_fraud_call", Integer.valueOf(nVar.j() ? 1 : 0));
                    } else if (i10 != p.TYPE_END_CALL.b()) {
                        Wa.b.b(str, "updateVoipRecordEndTime::updateType is errorType");
                        cursorQuery.close();
                        return;
                    } else {
                        contentValues.put("voip_record_end_time", Long.valueOf(nVar.g()));
                        contentValues.put("is_active", (Integer) 0);
                        contentValues.put("duration", Long.valueOf(nVar.g() - j10));
                    }
                    Wa.b.a(str, "updateVoipRecordEndTime::updateType = " + i10 + ", result = " + writableDatabase.update("voip_record", contentValues, "voip_record_package_name = ? AND is_active = ?", strArr));
                }
            } catch (Exception e10) {
                Wa.b.b(f8518d, "updateVoipRecordEndTime::" + e10.getMessage());
                if (0 == 0) {
                    return;
                }
            }
            cursorQuery.close();
        } catch (Throwable th) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1(Qa.k kVar) {
        try {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                return;
            }
            long jInsert = f8517c.a().getWritableDatabase().insert("screenshot", null, p1(kVar));
            Wa.b.a(f8518d, "insert screenshot = " + jInsert);
            n1("screenshot", "screenshort_time");
        } catch (Exception e10) {
            Wa.b.b(f8518d, "insertScreenshotData: " + e10.getMessage());
        }
    }

    private final ContentValues e2(Qa.f fVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("access_time", Long.valueOf(fVar.e()));
        contentValues.put("url_type", Integer.valueOf(fVar.f()));
        return contentValues;
    }

    private final ContentValues f2(Qa.n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("voip_record_package_name", nVar.h());
        contentValues.put("voip_record_start_time", Long.valueOf(nVar.i()));
        contentValues.put("voip_record_end_time", Long.valueOf(nVar.g()));
        contentValues.put("is_active", Integer.valueOf(nVar.e() ? 1 : 0));
        contentValues.put("is_fraud_call", Integer.valueOf(nVar.j() ? 1 : 0));
        contentValues.put("duration", Long.valueOf(nVar.f()));
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1(m mVar) {
        try {
            String str = f8518d;
            Wa.b.a(str, "insertSimCardFraudCallInHandlerThread: " + mVar + " ");
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                Log.i(str, "insertSimCardFraudCallInHandlerThread: thread in main, reject");
                return;
            }
            Wa.b.a(str, "insert insertPhoneNumberFraudInHandlerThread = " + f8517c.a().getWritableDatabase().insert("fraud_phone", null, m1(mVar)));
            n1("fraud_phone", "call_start_time");
        } catch (Exception e10) {
            Wa.b.b(f8518d, "insertSimCardFraudCallInHandlerThread: " + e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(Qa.f fVar) {
        try {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                return;
            }
            long jInsert = f8517c.a().getWritableDatabase().insert("fraud_url", null, e2(fVar));
            Wa.b.a(f8518d, "insert urlInfo result = " + jInsert);
            n1("fraud_url", "access_time");
        } catch (Exception e10) {
            Wa.b.b(f8518d, "insertUrlInfoInHandlerThread: " + e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1(Qa.n nVar) {
        try {
            String str = f8518d;
            Wa.b.a(str, "insertVoipRecordInHandlerThread: " + nVar + " ");
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                return;
            }
            Wa.b.a(str, "insert voip record result = " + f8517c.a().getWritableDatabase().insert("voip_record", null, f2(nVar)));
            n1("voip_record", "voip_record_start_time");
        } catch (Exception e10) {
            Wa.b.b(f8518d, "insertVoipRecordInHandlerThread: " + e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k l1() {
        return new k();
    }

    private final ContentValues m1(m mVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tel_number_md5", mVar.k());
        contentValues.put("call_start_time", Long.valueOf(mVar.i()));
        contentValues.put("call_end_time", Long.valueOf(mVar.g()));
        contentValues.put("tel_location", mVar.j());
        contentValues.put("operator", mVar.h());
        contentValues.put("is_chinese_number", Integer.valueOf(mVar.l() ? 1 : 0));
        contentValues.put("is_virtual_operator", Integer.valueOf(mVar.n() ? 1 : 0));
        contentValues.put("is_active", Integer.valueOf(mVar.e() ? 1 : 0));
        contentValues.put("duration", Long.valueOf(mVar.f()));
        contentValues.put("is_fraud_call", Integer.valueOf(mVar.m() ? 1 : 0));
        return contentValues;
    }

    private final ContentValues o1(Qa.j jVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("screen_share_package_name", jVar.h());
        contentValues.put("screen_share_start_time", Long.valueOf(jVar.i()));
        contentValues.put("screen_share_end_time", Long.valueOf(jVar.g()));
        contentValues.put("is_active", Integer.valueOf(jVar.e() ? 1 : 0));
        contentValues.put("duration", Long.valueOf(jVar.f()));
        return contentValues;
    }

    private final ContentValues p1(Qa.k kVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("screenshort_time", Long.valueOf(kVar.e()));
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1(final Qa.g gVar) {
        final List listT1 = t1();
        Handler handler = this.f8523b;
        if (handler != null) {
            handler.post(new Runnable() { // from class: Ra.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.s1(gVar, listT1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(Qa.g gVar, List list) {
        gVar.onSuccess(list);
    }

    private final List t1() {
        ArrayList arrayList = new ArrayList();
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return arrayList;
        }
        SQLiteDatabase readableDatabase = f8517c.a().getReadableDatabase();
        n.e(readableDatabase, "getReadableDatabase(...)");
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = readableDatabase.rawQuery(Ra.a.f8499w.h("airplane_mode", "airplane_mode_change_time"), null);
                while (cursorRawQuery.moveToNext()) {
                    Qa.a aVarM0 = M0(cursorRawQuery);
                    if (aVarM0 != null) {
                        arrayList.add(aVarM0);
                    }
                }
                Wa.b.a(f8518d, "search airplaneMode size = " + arrayList.size());
                cursorRawQuery.close();
                return arrayList;
            } catch (Exception e10) {
                Wa.b.b(f8518d, "searchAirplaneModes: " + e10.getMessage());
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    private final List u1() {
        ArrayList arrayList = new ArrayList();
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return arrayList;
        }
        SQLiteDatabase readableDatabase = f8517c.a().getReadableDatabase();
        n.e(readableDatabase, "getReadableDatabase(...)");
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = readableDatabase.rawQuery(Ra.a.f8499w.h("install_app", "install_finish_time"), null);
                while (cursorRawQuery.moveToNext()) {
                    Qa.b bVarN0 = N0(cursorRawQuery);
                    if (bVarN0 != null) {
                        arrayList.add(bVarN0);
                    }
                }
                Wa.b.a(f8518d, "search app info list size = " + arrayList.size());
                cursorRawQuery.close();
                return arrayList;
            } catch (Exception e10) {
                Wa.b.b(f8518d, "searchAppInfoList: " + e10.getMessage());
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    private final List v1() {
        ArrayList arrayList = new ArrayList();
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return arrayList;
        }
        SQLiteDatabase readableDatabase = f8517c.a().getReadableDatabase();
        n.e(readableDatabase, "getReadableDatabase(...)");
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = readableDatabase.rawQuery(Ra.a.f8499w.f(), null);
                while (cursorRawQuery.moveToNext()) {
                    Qa.d dVarO0 = O0(cursorRawQuery);
                    if (dVarO0 != null) {
                        arrayList.add(dVarO0);
                    }
                }
                Wa.b.a(f8518d, "search callForwarding size = " + arrayList.size());
                cursorRawQuery.close();
                return arrayList;
            } catch (Exception e10) {
                Wa.b.b(f8518d, "searchCallForwarding: " + e10.getMessage());
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1(final Qa.g gVar) {
        final List listV1 = v1();
        Handler handler = this.f8523b;
        if (handler != null) {
            handler.post(new Runnable() { // from class: Ra.g
                @Override // java.lang.Runnable
                public final void run() {
                    k.y1(gVar, listV1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(Qa.g gVar, List list) {
        gVar.onSuccess(list);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007d  */
    public final Qa.n A1() throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor = null;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            Wa.b.a(f8518d, "searchCurrentVoipRecord: thread in main, reject");
            return null;
        }
        SQLiteDatabase readableDatabase = f8517c.a().getReadableDatabase();
        n.e(readableDatabase, "getReadableDatabase(...)");
        try {
            cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM voip_record WHERE is_active = 1 ORDER BY voip_record_start_time DESC LIMIT 1 ", null);
            try {
                try {
                    Qa.n nVarT0 = cursorRawQuery.moveToFirst() ? T0(cursorRawQuery) : null;
                    Wa.b.a(f8518d, "search current voip info = " + nVarT0);
                    cursorRawQuery.close();
                    return nVarT0;
                } catch (Exception e10) {
                    e = e10;
                    Wa.b.b(f8518d, "searchCurrentVoipRecord: " + e.getMessage());
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorRawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void C1(Qa.g gVar) {
        n.f(gVar, "callBack");
        Message messageObtain = Message.obtain();
        messageObtain.what = 402;
        messageObtain.obj = gVar;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void F1(Qa.g gVar) {
        n.f(gVar, "callBack");
        Message messageObtain = Message.obtain();
        messageObtain.what = 302;
        messageObtain.obj = gVar;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void J1(Qa.g gVar) {
        n.f(gVar, "callBack");
        Message messageObtain = Message.obtain();
        messageObtain.what = MiContinuityStatus.CLIENT_SOCKET_CLOSE;
        messageObtain.obj = gVar;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void L1(Qa.g gVar) {
        n.f(gVar, "callBack");
        Message messageObtain = Message.obtain();
        messageObtain.what = 102;
        messageObtain.obj = gVar;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void R1(Qa.g gVar, Qa.l lVar) {
        n.f(gVar, "callBack");
        n.f(lVar, "searchType");
        Message messageObtain = Message.obtain();
        messageObtain.what = 703;
        messageObtain.obj = gVar;
        messageObtain.arg1 = lVar.b();
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void U0(Qa.a aVar) {
        n.f(aVar, "info");
        Message messageObtain = Message.obtain();
        messageObtain.what = 601;
        messageObtain.obj = aVar;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void U1(Qa.g gVar, o oVar) {
        n.f(gVar, "callBack");
        n.f(oVar, "searchType");
        Message messageObtain = Message.obtain();
        messageObtain.what = 803;
        messageObtain.obj = gVar;
        messageObtain.arg1 = oVar.b();
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void W0(Qa.b bVar) {
        n.f(bVar, "appInfo");
        Message messageObtain = Message.obtain();
        messageObtain.what = 301;
        messageObtain.obj = bVar;
        b bVar2 = this.f8522a;
        if (bVar2 != null) {
            bVar2.sendMessage(messageObtain);
        }
    }

    public final void Y0(Qa.d dVar) {
        n.f(dVar, "callForwardingInfo");
        Message messageObtain = Message.obtain();
        messageObtain.what = MiContinuityStatus.SOCKET_CHANNEL_EXCEPTION;
        messageObtain.obj = dVar;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void Y1(Qa.j jVar) {
        n.f(jVar, "info");
        Message messageObtain = Message.obtain();
        messageObtain.what = MiContinuityStatus.CLIENT_CHANNEL_INACTIVE;
        messageObtain.obj = jVar;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void a1(Qa.f fVar) {
        n.f(fVar, "urlInfo");
        Message messageObtain = Message.obtain();
        messageObtain.what = com.xiaomi.onetrack.g.d.f37409b;
        messageObtain.obj = fVar;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void a2(String str) {
        n.f(str, "number");
        Message messageObtain = Message.obtain();
        messageObtain.what = 702;
        messageObtain.obj = str;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void b1(Qa.j jVar) {
        n.f(jVar, "info");
        Message messageObtain = Message.obtain();
        messageObtain.what = 201;
        messageObtain.obj = jVar;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void c2(Qa.n nVar, p pVar) {
        n.f(nVar, "info");
        n.f(pVar, "updateType");
        Message messageObtain = Message.obtain();
        messageObtain.what = 802;
        messageObtain.obj = nVar;
        messageObtain.arg1 = pVar.b();
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void d1(Qa.k kVar) {
        if (kVar == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 101;
        messageObtain.obj = kVar;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void f1(m mVar) {
        n.f(mVar, "info");
        Message messageObtain = Message.obtain();
        messageObtain.what = 701;
        messageObtain.obj = mVar;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void h1(Qa.b bVar) {
        n.f(bVar, "info");
        Message messageObtain = Message.obtain();
        messageObtain.what = 901;
        messageObtain.obj = bVar;
        b bVar2 = this.f8522a;
        if (bVar2 != null) {
            bVar2.sendMessage(messageObtain);
        }
    }

    public final void j1(Qa.n nVar) {
        n.f(nVar, "info");
        Message messageObtain = Message.obtain();
        messageObtain.what = GameAIHttpResp.CODE_PARAM_ERROR;
        messageObtain.obj = nVar;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void n1(String str, String str2) {
        n.f(str, "tableName");
        n.f(str2, "timeColumn");
        try {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - 259200000;
            if (jCurrentTimeMillis < 0) {
                return;
            }
            String[] strArr = {String.valueOf(jCurrentTimeMillis)};
            SQLiteDatabase writableDatabase = f8517c.a().getWritableDatabase();
            n.e(writableDatabase, "getWritableDatabase(...)");
            int iDelete = writableDatabase.delete(str, str2 + " < ?", strArr);
            Wa.b.a(f8518d, "removeOldInfos " + str + " , result = " + iDelete);
        } catch (Exception e10) {
            Wa.b.b(f8518d, "removeOldInfos " + str + " , error: " + e10.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        n.f(sQLiteDatabase, "db");
        Wa.b.c(f8518d, "db onCreate");
        try {
            sQLiteDatabase.execSQL("CREATE TABLE screenshot(_id INTEGER PRIMARY KEY AUTOINCREMENT,screenshort_time INTEGER NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE screen_share(_id INTEGER PRIMARY KEY AUTOINCREMENT,screen_share_package_name TEXT NOT NULL,screen_share_start_time INTEGER NOT NULL,screen_share_end_time INTEGER NOT NULL,is_active INTEGER NOT NULL,duration INTEGER NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE call_forwarding(_id INTEGER PRIMARY KEY AUTOINCREMENT,reason INTEGER NOT NULL,enabled INTEGER NOT NULL,timestamp INTEGER NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE airplane_mode(_id INTEGER PRIMARY KEY AUTOINCREMENT,airplane_mode_on INTEGER NOT NULL,airplane_mode_change_time INTEGER NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE fraud_phone(_id INTEGER PRIMARY KEY AUTOINCREMENT,call_start_time INTEGER NOT NULL,call_end_time INTEGER NOT NULL,is_fraud_call INTEGER NOT NULL,tel_location TEXT NOT NULL,tel_number_md5 TEXT NOT NULL,operator TEXT NOT NULL,is_chinese_number INTEGER NOT NULL,is_virtual_operator INTEGER NOT NULL,is_active INTEGER NOT NULL,duration INTEGER NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE voip_record(_id INTEGER PRIMARY KEY AUTOINCREMENT,voip_record_package_name TEXT NOT NULL,voip_record_start_time INTEGER NOT NULL,voip_record_end_time INTEGER NOT NULL,is_active INTEGER NOT NULL,is_fraud_call INTEGER NOT NULL,duration INTEGER NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE fraud_url(_id INTEGER PRIMARY KEY AUTOINCREMENT,access_time INTEGER NOT NULL,url_type INTEGER NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE install_app(_id INTEGER PRIMARY KEY AUTOINCREMENT,pkg_name TEXT NOT NULL,app_name TEXT NOT NULL,source TEXT NOT NULL,version_code INTEGER NOT NULL,md5 TEXT NOT NULL,install_finish_time INTEGER NOT NULL,app_tag_id INTEGER NOT NULL,security_tag_id INTEGER NOT NULL);");
        } catch (Exception e10) {
            Wa.b.b(f8518d, "onCreate error: " + e10.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        Wa.b.c(f8518d, "onUpgrade: " + i10 + " ---> " + i11);
    }

    public final void q1(Qa.g gVar) {
        n.f(gVar, "callBack");
        Message messageObtain = Message.obtain();
        messageObtain.what = 602;
        messageObtain.obj = gVar;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    public final void w1(Qa.g gVar) {
        n.f(gVar, "callBack");
        Message messageObtain = Message.obtain();
        messageObtain.what = MiContinuityStatus.SYSTEM_SERVICE_EXCEPTION;
        messageObtain.obj = gVar;
        b bVar = this.f8522a;
        if (bVar != null) {
            bVar.sendMessage(messageObtain);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007d  */
    public final m z1() throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor = null;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            Wa.b.a(f8518d, "searchCurrentSimCardRecord: thread in main, reject");
            return null;
        }
        SQLiteDatabase readableDatabase = f8517c.a().getReadableDatabase();
        n.e(readableDatabase, "getReadableDatabase(...)");
        try {
            cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM fraud_phone WHERE is_active = 1 ORDER BY call_start_time DESC LIMIT 1 ", null);
            try {
                try {
                    m mVarS0 = cursorRawQuery.moveToFirst() ? S0(cursorRawQuery) : null;
                    Wa.b.a(f8518d, "search current simCardRecord info = " + mVarS0);
                    cursorRawQuery.close();
                    return mVarS0;
                } catch (Exception e10) {
                    e = e10;
                    Wa.b.b(f8518d, "searchCurrentSimCardRecord: " + e.getMessage());
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorRawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
