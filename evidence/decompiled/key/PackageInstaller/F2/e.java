package F2;

import G3.o;
import H3.m;
import H3.n;
import P3.v;
import S3.C;
import S3.C0406f;
import S3.C0408g;
import S3.C0419l0;
import S3.F;
import S3.M;
import S3.W;
import android.net.Uri;
import com.miui.packageInstaller.model.ApkInfo;
import com.miui.packageInstaller.model.CInfo;
import com.miui.packageInstaller.model.CloudParams;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p138t3.i;
import p138t3.k;
import p168y2.r;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f743c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p138t3.g f744a = i.b(k.SYNCHRONIZED, b.f746a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f745b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(H3.g gVar) {
            this();
        }
    }

    static final class b extends n implements Function0<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f746a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e invoke() {
            return new e();
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.miui.packageInstaller.util.tlsh.TlshManager$loadTlsh$1", f = "TlshManager.kt", l = {24}, m = "invokeSuspend")
    static final class c extends kotlin.coroutines.jvm.internal.k implements o<F, p163x3.d<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CloudParams f748b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ApkInfo f749c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f750d;

        @kotlin.coroutines.jvm.internal.f(c = "com.miui.packageInstaller.util.tlsh.TlshManager$loadTlsh$1$tlsh$1", f = "TlshManager.kt", l = {25}, m = "invokeSuspend")
        static final class a extends kotlin.coroutines.jvm.internal.k implements o<F, p163x3.d<? super String>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f751a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ e f752b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ApkInfo f753c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(e eVar, ApkInfo apkInfo, p163x3.d<? super a> dVar) {
                super(2, dVar);
                this.f752b = eVar;
                this.f753c = apkInfo;
            }

            @Override // G3.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(F f6, p163x3.d<? super String> dVar) {
                return ((a) create(f6, dVar)).invokeSuspend(Unit.f20921a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p163x3.d<Unit> create(Object obj, p163x3.d<?> dVar) {
                return new a(this.f752b, this.f753c, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objC = p169y3.d.c();
                int i6 = this.f751a;
                if (i6 == 0) {
                    p138t3.o.b(obj);
                    e eVar = this.f752b;
                    ApkInfo apkInfo = this.f753c;
                    this.f751a = 1;
                    obj = eVar.f(apkInfo, this);
                    if (obj == objC) {
                        return objC;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p138t3.o.b(obj);
                }
                return obj;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CloudParams cloudParams, ApkInfo apkInfo, e eVar, p163x3.d<? super c> dVar) {
            super(2, dVar);
            this.f748b = cloudParams;
            this.f749c = apkInfo;
            this.f750d = eVar;
        }

        @Override // G3.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(F f6, p163x3.d<? super Unit> dVar) {
            return ((c) create(f6, dVar)).invokeSuspend(Unit.f20921a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final p163x3.d<Unit> create(Object obj, p163x3.d<?> dVar) {
            return new c(this.f748b, this.f749c, this.f750d, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            CInfo cInfo;
            Object objC = p169y3.d.c();
            int i6 = this.f747a;
            try {
                if (i6 == 0) {
                    p138t3.o.b(obj);
                    CloudParams cloudParams = this.f748b;
                    if ((cloudParams == null || (cInfo = cloudParams.cInfo) == null) ? false : m.a(cInfo.getTFlag(), kotlin.coroutines.jvm.internal.b.a(true))) {
                        C cB = W.b();
                        a aVar = new a(this.f750d, this.f749c, null);
                        this.f747a = 1;
                        obj = C0406f.e(cB, aVar, this);
                        if (obj == objC) {
                            return objC;
                        }
                    }
                    return Unit.f20921a;
                }
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p138t3.o.b(obj);
                String str = (String) obj;
                if (!(str == null || str.length() == 0)) {
                    ApkInfo apkInfo = this.f749c;
                    if (apkInfo != null) {
                        apkInfo.setTInfo(v.C(str, "T1", "", false, 4, null));
                    }
                    ApkInfo apkInfo2 = this.f749c;
                    r.a("TlshManager", "tlsh: " + (apkInfo2 != null ? apkInfo2.getTInfo() : null));
                }
            } catch (Exception e6) {
                r.a("TlshManager", e6.getMessage());
            }
            return Unit.f20921a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.miui.packageInstaller.util.tlsh.TlshManager$parserTlsh$2", f = "TlshManager.kt", l = {43}, m = "invokeSuspend")
    static final class d extends kotlin.coroutines.jvm.internal.k implements o<F, p163x3.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f755b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ApkInfo f757d;

        @kotlin.coroutines.jvm.internal.f(c = "com.miui.packageInstaller.util.tlsh.TlshManager$parserTlsh$2$parserJob$1", f = "TlshManager.kt", l = {}, m = "invokeSuspend")
        static final class a extends kotlin.coroutines.jvm.internal.k implements o<F, p163x3.d<? super String>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f758a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ e f759b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ApkInfo f760c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(e eVar, ApkInfo apkInfo, p163x3.d<? super a> dVar) {
                super(2, dVar);
                this.f759b = eVar;
                this.f760c = apkInfo;
            }

            @Override // G3.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(F f6, p163x3.d<? super String> dVar) {
                return ((a) create(f6, dVar)).invokeSuspend(Unit.f20921a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final p163x3.d<Unit> create(Object obj, p163x3.d<?> dVar) {
                return new a(this.f759b, this.f760c, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                p169y3.d.c();
                if (this.f758a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p138t3.o.b(obj);
                return this.f759b.d(this.f760c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ApkInfo apkInfo, p163x3.d<? super d> dVar) {
            super(2, dVar);
            this.f757d = apkInfo;
        }

        @Override // G3.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(F f6, p163x3.d<? super String> dVar) {
            return ((d) create(f6, dVar)).invokeSuspend(Unit.f20921a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final p163x3.d<Unit> create(Object obj, p163x3.d<?> dVar) {
            d dVar2 = e.this.new d(this.f757d, dVar);
            dVar2.f755b = obj;
            return dVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = p169y3.d.c();
            int i6 = this.f754a;
            if (i6 == 0) {
                p138t3.o.b(obj);
                M mB = C0408g.b((F) this.f755b, W.b(), null, new a(e.this, this.f757d, null), 2, null);
                this.f754a = 1;
                obj = mB.i0(this);
                if (obj == objC) {
                    return objC;
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p138t3.o.b(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized String d(ApkInfo apkInfo) {
        String path;
        if ((apkInfo != null ? apkInfo.getFileUri() : null) == null) {
            return null;
        }
        try {
            Uri fileUri = apkInfo.getFileUri();
            File file = (fileUri == null || (path = fileUri.getPath()) == null) ? null : new File(path);
            F2.d dVar = new F2.d(null, null, null, 7, null);
            byte[] bArr = new byte[1024];
            this.f745b = true;
            InputStream inputStreamNewInputStream = Files.newInputStream(file != null ? file.toPath() : null, StandardOpenOption.READ);
            try {
                for (int i6 = inputStreamNewInputStream.read(bArr, 0, 1024); i6 >= 0 && this.f745b; i6 = inputStreamNewInputStream.read(bArr, 0, 1024)) {
                    dVar.f(bArr, 0, i6);
                }
                if (!this.f745b) {
                    D3.b.a(inputStreamNewInputStream, null);
                    return null;
                }
                String strA = dVar.b().a();
                D3.b.a(inputStreamNewInputStream, null);
                return strA;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    D3.b.a(inputStreamNewInputStream, th);
                    throw th2;
                }
            }
        } catch (Exception e6) {
            r.a("TlshManager", e6.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(ApkInfo apkInfo, p163x3.d<? super String> dVar) {
        return C0406f.e(W.b(), new d(apkInfo, null), dVar);
    }

    public final e c() {
        return (e) this.f744a.getValue();
    }

    public final void e(ApkInfo apkInfo, CloudParams cloudParams) {
        C0408g.d(C0419l0.f5097a, W.b(), null, new c(cloudParams, apkInfo, this, null), 2, null);
    }

    public final void g() {
        this.f745b = false;
    }
}
