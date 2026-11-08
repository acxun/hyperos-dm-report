package com.miui.packageInstaller;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.UserInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.core.content.FileProvider;
import com.android.packageinstaller.InstallerApplication;
import com.miui.guardprovider.ScanResult;
import com.miui.guardprovider.sdk.CoroutineVirusScanManager;
import com.miui.guardprovider.sdk.ScanEvent;
import com.miui.guardprovider.sdk.ScanRequestArgs;
import com.miui.packageInstaller.model.ApkInfo;
import com.miui.packageInstaller.model.ExtraGuardVirusInfoEntity;
import com.miui.packageInstaller.model.Virus;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import p145u3.C0766o;

/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f15652d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f15654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15655c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(H3.g gVar) {
            this();
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.miui.packageInstaller.NewVirusScanner", f = "NewVirusScanner.kt", l = {58, 61, 71}, m = "doVirusCheck")
    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f15658c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f15660e;

        b(p163x3.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f15658c = obj;
            this.f15660e |= Integer.MIN_VALUE;
            return c0.this.e(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.miui.packageInstaller.NewVirusScanner", f = "NewVirusScanner.kt", l = {239, 86}, m = "doVirusCheckNew")
    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f15664d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f15666f;

        c(p163x3.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f15664d = obj;
            this.f15666f |= Integer.MIN_VALUE;
            return c0.this.g(null, null, this);
        }
    }

    static final class d<T> implements V3.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ H3.A<Virus> f15668b;

        d(H3.A<Virus> a6) {
            this.f15668b = a6;
        }

        @Override // V3.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object a(ScanEvent scanEvent, p163x3.d<? super Unit> dVar) {
            if (scanEvent instanceof ScanEvent.ItemDone) {
                if (c0.this.l()) {
                    return Unit.f20921a;
                }
                List<ScanResult> result = ((ScanEvent.ItemDone) scanEvent).getResult();
                if (result != null && !result.isEmpty()) {
                    try {
                        this.f15668b.f958a = (T) c0.this.d(result);
                    } catch (Exception e6) {
                        new p032e2.d("virus_check_get_info_convert_error", "virus_check", new p025d2.b("install_before")).g("request_result", e6.toString()).d();
                        p047g3.c.f("NewVirusScanner", "doVirusCheckNew: convert result error", e6);
                    }
                }
            } else if (scanEvent instanceof ScanEvent.Finished) {
                p047g3.c.g("NewVirusScanner", "doVirusCheckNew: finished, code=" + ((ScanEvent.Finished) scanEvent).getCode() + ", hasResult=" + (this.f15668b.f958a != null));
            }
            return Unit.f20921a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Virus d(List<ScanResult> list) {
        Object next;
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while ((((ScanResult) next).flags() & 1) == 0);
        ScanResult scanResult = (ScanResult) next;
        ScanResult scanResult2 = scanResult == null ? list.get(0) : scanResult;
        Virus virus = new Virus(null, null, false, 7, null);
        virus.setName(scanResult2.threatName());
        virus.setVirusInfo(scanResult2.threatDesc());
        virus.setProhibitInstalling(scanResult != null);
        p047g3.c.r("NewVirusScanner", "doVirusCheckNew: threat detected - level=" + scanResult2.threatLevel() + ", name=" + scanResult2.threatName() + ", engine=" + scanResult2.checkoutEngine() + ", forbidden=" + (scanResult != null));
        return virus;
    }

    private final Object f(String str, ApkInfo apkInfo, Context context, p163x3.d<? super Virus> dVar) throws Throwable {
        String path;
        boolean z6 = false;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.miui.guardprovider", UserInfo.FLAG_QUIET_MODE);
            H3.m.e(applicationInfo, "getApplicationInfo(...)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null && bundle.getInt("guardprovider.scan_properties", 0) >= 2) {
                z6 = true;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            new p032e2.d("get_guardprovider_error", "virus_check", new p025d2.b("install_before")).g("request_result", e6.toString()).d();
        }
        boolean z7 = z6;
        Uri fileUri = apkInfo.getFileUri();
        File file = (fileUri == null || (path = fileUri.getPath()) == null) ? null : new File(path);
        if (!com.android.packageinstaller.utils.B.c(context.getPackageManager().getPackageInstaller()) || TextUtils.isEmpty(com.android.packageinstaller.utils.B.a(context.getPackageManager().getPackageInstaller()))) {
            fileUri = file != null ? FileProvider.getUriForFile(context, "com.miui.packageinstaller.provider", file) : null;
            InstallerApplication.m().grantUriPermission("com.miui.guardprovider", fileUri, 1);
        }
        ExtraGuardVirusInfoEntity extraGuardVirusInfoEntityC = c(context, fileUri, true, z7, str);
        if (extraGuardVirusInfoEntityC == null || this.f15655c || !extraGuardVirusInfoEntityC.isVirus()) {
            return null;
        }
        Virus virus = new Virus(null, null, false, 7, null);
        try {
            virus.setName(extraGuardVirusInfoEntityC.getVirusName());
            virus.setVirusInfo(extraGuardVirusInfoEntityC.getVirusInfo());
            virus.setProhibitInstalling(extraGuardVirusInfoEntityC.isProhibitInstalling());
            return virus;
        } catch (Exception e7) {
            new p032e2.d("virus_check_get_info_convert_error", "virus_check", new p025d2.b("install_before")).g("request_result", e7.toString()).d();
            p047g3.c.f("NewVirusScanner", "Exception when check virus: ", e7);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x00a8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object g(CoroutineVirusScanManager coroutineVirusScanManager, String str, p163x3.d<? super Virus> dVar) throws Throwable {
        c cVar;
        H3.A a6;
        c0 c0Var;
        String str2;
        H3.A a7;
        CoroutineVirusScanManager.Connection connection;
        Throwable th;
        AutoCloseable autoCloseable;
        V3.d<ScanEvent> dVarStartScan;
        d dVar2;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i6 = cVar.f15666f;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                cVar.f15666f = i6 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        Object obj = cVar.f15664d;
        Object objC = p169y3.d.c();
        int i7 = cVar.f15666f;
        if (i7 == 0) {
            p138t3.o.b(obj);
            H3.A a8 = new H3.A();
            try {
                cVar.f15661a = this;
                cVar.f15662b = str;
                cVar.f15663c = a8;
                cVar.f15666f = 1;
                Object objPrepare = coroutineVirusScanManager.prepare(cVar);
                if (objPrepare == objC) {
                    return objC;
                }
                c0Var = this;
                obj = objPrepare;
                str2 = str;
                a7 = a8;
                connection = (CoroutineVirusScanManager.Connection) obj;
                dVarStartScan = connection.startScan(C0766o.e(str2), new ScanRequestArgs.Builder(1).setRejectWhenBusy(true).setRequestTimeoutSeconds(10).build());
                dVar2 = c0Var.new d(a7);
                cVar.f15661a = a7;
                cVar.f15662b = connection;
                cVar.f15663c = null;
                cVar.f15666f = 2;
                if (dVarStartScan.b(dVar2, cVar) == objC) {
                    return objC;
                }
                autoCloseable = connection;
                Unit unit = Unit.f20921a;
                E3.a.a(autoCloseable, null);
            } catch (UnsupportedOperationException e6) {
                e = e6;
                a6 = a8;
                p047g3.c.s("NewVirusScanner", "doVirusCheckNew: service busy or overloaded, treating as pass", e);
                a7 = a6;
            } catch (Exception e7) {
                e = e7;
                a6 = a8;
                new p032e2.d("virus_check_get_info_error", "virus_check", new p025d2.b("install_before")).g("request_result", e.toString()).d();
                p047g3.c.f("NewVirusScanner", "doVirusCheckNew: scan error", e);
                a7 = a6;
            }
        } else if (i7 == 1) {
            a6 = (H3.A) cVar.f15663c;
            String str3 = (String) cVar.f15662b;
            c0Var = (c0) cVar.f15661a;
            try {
                p138t3.o.b(obj);
                a7 = a6;
                str2 = str3;
                try {
                    connection = (CoroutineVirusScanManager.Connection) obj;
                    try {
                        dVarStartScan = connection.startScan(C0766o.e(str2), new ScanRequestArgs.Builder(1).setRejectWhenBusy(true).setRequestTimeoutSeconds(10).build());
                        dVar2 = c0Var.new d(a7);
                        cVar.f15661a = a7;
                        cVar.f15662b = connection;
                        cVar.f15663c = null;
                        cVar.f15666f = 2;
                        if (dVarStartScan.b(dVar2, cVar) == objC) {
                            return objC;
                        }
                        autoCloseable = connection;
                        Unit unit2 = Unit.f20921a;
                        E3.a.a(autoCloseable, null);
                    } catch (Throwable th2) {
                        th = th2;
                        autoCloseable = connection;
                        throw th;
                    }
                } catch (UnsupportedOperationException e8) {
                    H3.A a9 = a7;
                    e = e8;
                    a6 = a9;
                    p047g3.c.s("NewVirusScanner", "doVirusCheckNew: service busy or overloaded, treating as pass", e);
                    a7 = a6;
                    return a7.f958a;
                } catch (Exception e9) {
                    H3.A a10 = a7;
                    e = e9;
                    a6 = a10;
                    new p032e2.d("virus_check_get_info_error", "virus_check", new p025d2.b("install_before")).g("request_result", e.toString()).d();
                    p047g3.c.f("NewVirusScanner", "doVirusCheckNew: scan error", e);
                    a7 = a6;
                    return a7.f958a;
                }
            } catch (UnsupportedOperationException e10) {
                e = e10;
                p047g3.c.s("NewVirusScanner", "doVirusCheckNew: service busy or overloaded, treating as pass", e);
                a7 = a6;
            } catch (Exception e11) {
                e = e11;
                new p032e2.d("virus_check_get_info_error", "virus_check", new p025d2.b("install_before")).g("request_result", e.toString()).d();
                p047g3.c.f("NewVirusScanner", "doVirusCheckNew: scan error", e);
                a7 = a6;
            }
        } else {
            if (i7 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            autoCloseable = (AutoCloseable) cVar.f15662b;
            a7 = (H3.A) cVar.f15661a;
            try {
                p138t3.o.b(obj);
                Unit unit3 = Unit.f20921a;
                E3.a.a(autoCloseable, null);
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    E3.a.a(autoCloseable, th);
                    throw th4;
                }
            }
        }
        return a7.f958a;
    }

    public final ExtraGuardVirusInfoEntity c(Context context, Uri uri, boolean z6, boolean z7, String str) throws Throwable {
        Cursor cursorQuery;
        H3.m.f(context, "context");
        H3.m.f(str, "callingPackage");
        Cursor cursor = null;
        if (uri == null) {
            new p032e2.d("virus_check_uri_null", "virus_check", new p025d2.b("install_before")).d();
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Uri uri2 = Uri.parse(z7 ? "content://guard/install_scan" : "content://guard/sync_scan");
            if (uri2 == null) {
                p164x4.e.a(null);
                return null;
            }
            ExtraGuardVirusInfoEntity extraGuardVirusInfoEntity = new ExtraGuardVirusInfoEntity(0, null, null, null, 15, null);
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("installPackage", str);
            cursorQuery = contentResolver.query(uri2, null, null, z7 ? new String[]{uri.toString(), String.valueOf(z6), new com.google.gson.e().u(arrayMap)} : new String[]{uri.toString(), String.valueOf(z6)}, null);
            if (cursorQuery != null) {
                try {
                    try {
                        if (cursorQuery.moveToNext()) {
                            Integer numI = i(cursorQuery, "Type");
                            extraGuardVirusInfoEntity.setType(numI != null ? numI.intValue() : 1);
                            extraGuardVirusInfoEntity.setDescription(k(cursorQuery, "Description"));
                            extraGuardVirusInfoEntity.setVirusName(k(cursorQuery, "VirusName"));
                            extraGuardVirusInfoEntity.setForbidden(i(cursorQuery, "Forbidden"));
                        }
                    } catch (Exception e6) {
                        e = e6;
                        e.printStackTrace();
                        new p032e2.d("virus_check_get_info_error", "virus_check", new p025d2.b("install_before")).g("request_result", e.toString()).d();
                        p164x4.e.a(cursorQuery);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    p164x4.e.a(cursor);
                    throw th;
                }
            }
            p164x4.e.a(cursorQuery);
            return extraGuardVirusInfoEntity;
        } catch (Exception e7) {
            e = e7;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            p164x4.e.a(cursor);
            throw th;
        }
        e.printStackTrace();
        new p032e2.d("virus_check_get_info_error", "virus_check", new p025d2.b("install_before")).g("request_result", e.toString()).d();
        p164x4.e.a(cursorQuery);
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    public final Object e(String str, ApkInfo apkInfo, p163x3.d<? super Virus> dVar) {
        b bVar;
        Virus virus;
        c0 c0Var;
        c0 c0Var2;
        c0 c0Var3;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i6 = bVar.f15660e;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                bVar.f15660e = i6 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object objF = bVar.f15658c;
        Object objC = p169y3.d.c();
        int i7 = bVar.f15660e;
        try {
            if (i7 == 0) {
                p138t3.o.b(objF);
                this.f15653a = SystemClock.uptimeMillis();
                try {
                    InstallerApplication installerApplicationM = InstallerApplication.m();
                    Uri fileUri = apkInfo.getFileUri();
                    String path = fileUri != null ? fileUri.getPath() : null;
                    H3.m.c(installerApplicationM);
                    CoroutineVirusScanManager coroutineVirusScanManager = new CoroutineVirusScanManager(installerApplicationM);
                    if (path == null || !coroutineVirusScanManager.checkSupported()) {
                        p047g3.c.g("NewVirusScanner", "new SDK not supported, fallback to legacy");
                        bVar.f15656a = this;
                        bVar.f15657b = apkInfo;
                        bVar.f15660e = 2;
                        objF = f(str, apkInfo, installerApplicationM, bVar);
                        if (objF == objC) {
                            return objC;
                        }
                        c0Var2 = this;
                        virus = (Virus) objF;
                        c0Var = c0Var2;
                    } else {
                        p047g3.c.g("NewVirusScanner", "using new VirusScanManager SDK");
                        bVar.f15656a = this;
                        bVar.f15657b = apkInfo;
                        bVar.f15660e = 1;
                        objF = g(coroutineVirusScanManager, path, bVar);
                        if (objF == objC) {
                            return objC;
                        }
                        c0Var3 = this;
                        virus = (Virus) objF;
                        c0Var = c0Var3;
                    }
                } catch (Exception e6) {
                    e = e6;
                    str = this;
                    new p032e2.d("virus_check_get_error", "virus_check", new p025d2.b("install_before")).g("request_result", e.toString()).d();
                    p047g3.c.f("NewVirusScanner", "Exception when check virus: ", e);
                    virus = null;
                    c0Var = str;
                }
            } else if (i7 == 1) {
                apkInfo = (ApkInfo) bVar.f15657b;
                c0 c0Var4 = (c0) bVar.f15656a;
                p138t3.o.b(objF);
                c0Var3 = c0Var4;
                virus = (Virus) objF;
                c0Var = c0Var3;
            } else {
                if (i7 != 2) {
                    if (i7 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Virus virus2 = (Virus) bVar.f15656a;
                    p138t3.o.b(objF);
                    return virus2;
                }
                apkInfo = (ApkInfo) bVar.f15657b;
                c0 c0Var5 = (c0) bVar.f15656a;
                p138t3.o.b(objF);
                c0Var2 = c0Var5;
                virus = (Virus) objF;
                c0Var = c0Var2;
            }
        } catch (Exception e7) {
            e = e7;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - c0Var.f15653a;
        c0Var.f15654b = jUptimeMillis;
        p047g3.c.g("NewVirusScanner", "virus check cost " + jUptimeMillis + ", isVirusScanTimeOut: " + c0Var.f15655c);
        long j6 = (c0Var.f15654b > 3000 || apkInfo.getSystemApp()) ? 0L : ((long) 3000) - c0Var.f15654b;
        bVar.f15656a = virus;
        bVar.f15657b = null;
        bVar.f15660e = 3;
        return S3.P.a(j6, bVar) == objC ? objC : virus;
    }

    public final long h() {
        return this.f15654b;
    }

    public final Integer i(Cursor cursor, String str) {
        H3.m.f(cursor, "<this>");
        H3.m.f(str, "columnName");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex == -1 || cursor.isNull(columnIndex)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(columnIndex));
    }

    public final long j() {
        return this.f15653a;
    }

    public final String k(Cursor cursor, String str) {
        H3.m.f(cursor, "<this>");
        H3.m.f(str, "columnName");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex == -1 || cursor.isNull(columnIndex)) {
            return null;
        }
        return cursor.getString(columnIndex);
    }

    public final boolean l() {
        return this.f15655c;
    }

    public final void m(boolean z6) {
        this.f15655c = z6;
    }
}
