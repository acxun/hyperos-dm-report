package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.display.VirtualDisplay;
import android.media.MediaRecorder;
import android.media.projection.MediaProjection;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.xiaomi.onetrack.c.y;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.invoke.VarHandle;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.security.Key;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.FutureTask;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
public final class re3 {
    public static volatile re3 f;
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;

    public re3(Context context) {
        this.a = new ConcurrentHashMap();
        this.b = context;
        oe3 oe3Var = new oe3();
        oe3Var.g = true;
        oe3Var.h = false;
        oe3Var.i = 1;
        oe3Var.j = context;
        this.c = oe3Var;
        this.d = new HashMap();
        SharedPreferences sharedPreferencesC = c(context);
        ((oe3) this.c).a = sharedPreferencesC.getString(y.b, null);
        ((oe3) this.c).b = sharedPreferencesC.getString("appToken", null);
        ((oe3) this.c).c = sharedPreferencesC.getString("regId", null);
        ((oe3) this.c).d = sharedPreferencesC.getString("regSec", null);
        ((oe3) this.c).e = sharedPreferencesC.getString("vName", null);
        ((oe3) this.c).g = sharedPreferencesC.getBoolean("valid", true);
        ((oe3) this.c).h = sharedPreferencesC.getBoolean("paused", false);
        ((oe3) this.c).i = sharedPreferencesC.getInt("envType", 1);
        ((oe3) this.c).f = sharedPreferencesC.getString("regResource", null);
        oe3 oe3Var2 = (oe3) this.c;
        sharedPreferencesC.getString("appRegion", null);
        oe3Var2.getClass();
    }

    public static SharedPreferences c(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    public static re3 d(Context context) {
        if (f == null) {
            synchronized (re3.class) {
                try {
                    if (f == null) {
                        f = new re3(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    public static void f(re3 re3Var, String str) {
        re3Var.getClass();
        if (TextUtils.isEmpty(str)) {
            kg3.e("event is empty when triggering event");
            return;
        }
        try {
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) ((ConcurrentHashMap) re3Var.a).remove(str);
            if (copyOnWriteArraySet == null) {
                return;
            }
            Iterator it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                ph3.h((FutureTask) it.next(), "executeWaitingTask:" + System.nanoTime());
            }
        } catch (Throwable th) {
            kg3.t("error occurred when triggering register event . exception:" + th);
        }
    }

    public static r60 n(nk2 nk2Var, Key key) {
        uk2 uk2Var;
        r60 r60Var = new r60();
        switch (nk2Var.ordinal()) {
            case 1:
            case 2:
            case 3:
                sm3 sm3Var = new sm3();
                qk1 qk1Var = new qk1(nk2Var, key);
                n53.w("SignatureAlgorithm must be a HMAC SHA algorithm.", nk2Var.name().startsWith("HS"));
                n53.w("The MacSigner only supports HMAC signature algorithms.", nk2Var.name().startsWith("HS"));
                if (!(key instanceof SecretKey)) {
                    cw1.e(key.getClass().getName(), "MAC signatures must be computed and verified using a SecretKey.  The specified key of type ", " is not a SecretKey.");
                    return null;
                }
                sm3Var.b = qk1Var;
                VarHandle.storeStoreFence();
                uk2Var = sm3Var;
                break;
                break;
            case 4:
            case 5:
            case 6:
            case 10:
            case 11:
            case 12:
                df2 df2Var = new df2(nk2Var, key);
                boolean z = key instanceof RSAPrivateKey;
                n53.w("RSA Signature validation requires either a RSAPublicKey or RSAPrivateKey instance.", z || (key instanceof RSAPublicKey));
                df2Var.e = z ? new ef2(nk2Var, key) : null;
                VarHandle.storeStoreFence();
                uk2Var = df2Var;
                break;
            case 7:
            case 8:
            case 9:
                je0 je0Var = new je0(nk2Var, key);
                n53.w("SignatureAlgorithm must be an Elliptic Curve algorithm.", nk2Var.name().startsWith("ES"));
                n53.w("Elliptic Curve signature validation requires an ECPublicKey instance.", key instanceof ECPublicKey);
                uk2Var = je0Var;
                break;
            default:
                cw1.e(nk2Var.name(), "The '", "' algorithm cannot be used for signing.");
                return null;
        }
        r60Var.a = uk2Var;
        VarHandle.storeStoreFence();
        return r60Var;
    }

    public void a(f51 f51Var, i60 i60Var, Object obj, int i, String str) throws IOException {
        xi0[] xi0VarArr = (xi0[]) this.b;
        fu2 fu2VarZ = ((hu2[]) this.e)[i].z(f51Var);
        if (fu2VarZ.i0() == e61.v) {
            xi0VarArr[i].a.x(obj, null);
            return;
        }
        hu2 hu2Var = new hu2(i60Var, f51Var);
        hu2Var.O();
        hu2Var.R(str);
        hu2Var.B(fu2VarZ);
        hu2Var.H();
        fu2 fu2VarZ2 = hu2Var.z(f51Var);
        fu2VarZ2.i0();
        xi0VarArr[i].a.i(fu2VarZ2, i60Var, obj);
    }

    public boolean b(f51 f51Var, i60 i60Var, String str, Object obj, String str2, int i) throws IOException {
        hu2[] hu2VarArr = (hu2[]) this.e;
        if (!str.equals(((xi0[]) this.b)[i].c)) {
            return false;
        }
        if (obj == null || hu2VarArr[i] == null) {
            ((String[]) this.d)[i] = str2;
            return true;
        }
        a(f51Var, i60Var, obj, i, str2);
        hu2VarArr[i] = null;
        return true;
    }

    public void e() {
        oe3 oe3Var = (oe3) this.c;
        Context context = oe3Var.j;
        c(context).edit().clear().commit();
        oe3Var.a = null;
        oe3Var.b = null;
        oe3Var.c = null;
        oe3Var.d = null;
        oe3Var.e = null;
        oe3Var.g = false;
        oe3Var.h = false;
        oe3Var.i = 1;
        f(d(context), "UNREGISTER");
    }

    public void g(String str, String str2, String str3) {
        oe3 oe3Var = (oe3) this.c;
        oe3Var.a = str;
        oe3Var.b = str2;
        oe3Var.f = str3;
        SharedPreferences.Editor editorEdit = c(oe3Var.j).edit();
        editorEdit.putString(y.b, oe3Var.a);
        editorEdit.putString("appToken", str2);
        editorEdit.putString("regResource", str3);
        editorEdit.commit();
    }

    public void h(boolean z) {
        ((oe3) this.c).h = z;
        c((Context) this.b).edit().putBoolean("paused", z).commit();
    }

    public void i(String str, String str2, String str3) {
        oe3 oe3Var = (oe3) this.c;
        oe3Var.c = str;
        oe3Var.d = str2;
        Context context = oe3Var.j;
        oe3Var.e = ja2.m(context, context.getPackageName());
        oe3Var.g = true;
        SharedPreferences.Editor editorEdit = c(context).edit();
        editorEdit.putString("regId", str);
        editorEdit.putString("regSec", str2);
        editorEdit.putString("vName", ja2.m(context, context.getPackageName()));
        editorEdit.putBoolean("valid", true);
        editorEdit.putString("appRegion", str3);
        editorEdit.commit();
        f(d(context), "REGISTER");
    }

    public boolean j() {
        if (((oe3) this.c).a()) {
            return true;
        }
        kg3.e("Don't send message before initialization succeeded!");
        return false;
    }

    public ti k() {
        ti tiVar = new ti(2);
        bu0 bu0Var = (bu0) this.a;
        if (bu0Var == null) {
            ik.j("url == null");
            return null;
        }
        tiVar.c = bu0Var;
        tiVar.h = (String) this.e;
        tiVar.d = ((vb2) this.b).b();
        tiVar.e = (ic2) this.c;
        tiVar.f = (kk3) this.d;
        VarHandle.storeStoreFence();
        return tiVar;
    }

    public Object l(f51 f51Var, i60 i60Var, u32 u32Var, dv1 dv1Var) throws IOException {
        String strC;
        Object objD;
        hu2[] hu2VarArr = (hu2[]) this.e;
        xi0[] xi0VarArr = (xi0[]) this.b;
        int length = xi0VarArr.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            String str = ((String[]) this.d)[i];
            xi0 xi0Var = xi0VarArr[i];
            Object objH = null;
            if (str == null) {
                if (hu2VarArr[i] == null) {
                    continue;
                } else {
                    gy2 gy2Var = xi0Var.b;
                    qx2 qx2Var = ((ph) gy2Var).e;
                    Annotation[] annotationArr = fw.a;
                    if ((qx2Var == null ? null : qx2Var.h) == null) {
                        i60Var.y0("Missing external type id property '%s'", xi0Var.c);
                        throw null;
                    }
                    ph phVar = (ph) gy2Var;
                    qx2 qx2Var2 = phVar.e;
                    Class cls = qx2Var2 == null ? null : qx2Var2.h;
                    strC = cls == null ? null : phVar.b.c(null, cls);
                }
            } else if (hu2VarArr[i] == null) {
                strC = str;
                i60Var.y0("Missing property '%s' for external type id '%s'", xi0Var.a.e.b, xi0Var.c);
                throw null;
            }
            strC = str;
            fu2 fu2VarZ = hu2VarArr[i].z(f51Var);
            if (fu2VarZ.i0() != e61.v) {
                hu2 hu2Var = new hu2(i60Var, f51Var);
                hu2Var.O();
                hu2Var.R(strC);
                hu2Var.B(fu2VarZ);
                hu2Var.H();
                fu2 fu2VarZ2 = hu2Var.z(f51Var);
                fu2VarZ2.i0();
                objH = xi0VarArr[i].a.h(i60Var, fu2VarZ2);
            }
            objArr[i] = objH;
            gk2 gk2Var = xi0Var.a;
            if (gk2Var.m() >= 0) {
                u32Var.b(gk2Var, objArr[i]);
                gk2 gk2Var2 = xi0Var.d;
                if (gk2Var2 != null && gk2Var2.m() >= 0) {
                    if (!gk2Var2.f.U(String.class)) {
                        objD = strC;
                        hu2 hu2Var2 = new hu2(i60Var, f51Var);
                        hu2Var2.R(strC);
                        r31 r31VarQ = gk2Var2.q();
                        f51 f51VarA = hu2Var2.A(hu2Var2.c);
                        f51VarA.i0();
                        objD = r31VarQ.d(i60Var, f51VarA);
                    }
                    objD = strC;
                    u32Var.b(gk2Var2, objD);
                }
            }
        }
        Object objD2 = dv1Var.d(i60Var, u32Var);
        for (int i2 = 0; i2 < length; i2++) {
            gk2 gk2Var3 = xi0VarArr[i2].a;
            if (gk2Var3.m() < 0) {
                gk2Var3.x(objD2, objArr[i2]);
            }
        }
        return objD2;
    }

    public void m(f51 f51Var, i60 i60Var, Object obj) throws IOException {
        f51 f51Var2;
        i60 i60Var2;
        Object obj2;
        re3 re3Var;
        xi0[] xi0VarArr = (xi0[]) this.b;
        int length = xi0VarArr.length;
        int i = 0;
        while (i < length) {
            String strC = ((String[]) this.d)[i];
            hu2[] hu2VarArr = (hu2[]) this.e;
            if (strC == null) {
                hu2 hu2Var = hu2VarArr[i];
                if (hu2Var != null) {
                    if (hu2Var.i.b(0).i) {
                        fu2 fu2VarZ = hu2Var.z(f51Var);
                        fu2VarZ.i0();
                        gk2 gk2Var = xi0VarArr[i].a;
                        Object objA = gy2.a(fu2VarZ, gk2Var.f);
                        if (objA != null) {
                            gk2Var.x(obj, objA);
                        } else {
                            gy2 gy2Var = xi0VarArr[i].b;
                            qx2 qx2Var = ((ph) gy2Var).e;
                            Annotation[] annotationArr = fw.a;
                            if ((qx2Var == null ? null : qx2Var.h) == null) {
                                obj.getClass();
                                i60Var.x0("Missing external type id property '%s'", xi0VarArr[i].c);
                                throw null;
                            }
                            ph phVar = (ph) gy2Var;
                            qx2 qx2Var2 = phVar.e;
                            Class cls = qx2Var2 == null ? null : qx2Var2.h;
                            strC = cls == null ? null : phVar.b.c(null, cls);
                        }
                    }
                }
                re3Var = this;
                f51Var2 = f51Var;
                i60Var2 = i60Var;
                obj2 = obj;
                i++;
                this = re3Var;
                f51Var = f51Var2;
                i60Var = i60Var2;
                obj = obj2;
            } else if (hu2VarArr[i] == null) {
                gk2 gk2Var2 = xi0VarArr[i].a;
                Boolean bool = gk2Var2.b.b;
                if ((bool == null || !bool.booleanValue()) && !i60Var.o0(qa0.q)) {
                    return;
                }
                obj.getClass();
                i60Var.x0("Missing property '%s' for external type id '%s'", gk2Var2.e.b, xi0VarArr[i].c);
                throw null;
            }
            f51Var2 = f51Var;
            i60Var2 = i60Var;
            obj2 = obj;
            String str = strC;
            re3Var = this;
            re3Var.a(f51Var2, i60Var2, obj2, i, str);
            i++;
            this = re3Var;
            f51Var = f51Var2;
            i60Var = i60Var2;
            obj = obj2;
        }
    }

    public boolean o() {
        return (TextUtils.isEmpty(((oe3) this.c).a) || TextUtils.isEmpty(((oe3) this.c).b) || TextUtils.isEmpty(((oe3) this.c).c) || TextUtils.isEmpty(((oe3) this.c).d)) ? false : true;
    }

    public boolean p() {
        return ((oe3) this.c).h;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0098  */
    public boolean q(i60 i60Var, f51 f51Var, Object obj, String str) throws IOException {
        xi0[] xi0VarArr = (xi0[]) this.b;
        hu2[] hu2VarArr = (hu2[]) this.e;
        String[] strArr = (String[]) this.d;
        Object obj2 = ((Map) this.c).get(str);
        if (obj2 == null) {
            return false;
        }
        if (obj2 instanceof List) {
            Iterator it = ((List) obj2).iterator();
            Integer num = (Integer) it.next();
            if (str.equals(xi0VarArr[num.intValue()].c)) {
                String strR = f51Var.R();
                f51Var.n0();
                strArr[num.intValue()] = strR;
                while (it.hasNext()) {
                    strArr[((Integer) it.next()).intValue()] = strR;
                }
            } else {
                hu2 hu2Var = new hu2(i60Var, f51Var);
                hu2Var.B(f51Var);
                hu2VarArr[num.intValue()] = hu2Var;
                while (it.hasNext()) {
                    hu2VarArr[((Integer) it.next()).intValue()] = hu2Var;
                }
            }
        } else {
            int iIntValue = ((Integer) obj2).intValue();
            if (str.equals(xi0VarArr[iIntValue].c)) {
                strArr[iIntValue] = f51Var.R();
                f51Var.n0();
                if (obj != null && hu2VarArr[iIntValue] != null) {
                    String str2 = strArr[iIntValue];
                    strArr[iIntValue] = null;
                    a(f51Var, i60Var, obj, iIntValue, str2);
                    hu2VarArr[iIntValue] = null;
                }
            } else {
                hu2 hu2Var2 = new hu2(i60Var, f51Var);
                hu2Var2.B(f51Var);
                hu2VarArr[iIntValue] = hu2Var2;
                if (obj != null && strArr[iIntValue] != null) {
                    String str3 = strArr[iIntValue];
                    strArr[iIntValue] = null;
                    a(f51Var, i60Var, obj, iIntValue, str3);
                    hu2VarArr[iIntValue] = null;
                }
            }
        }
        return true;
    }

    public void r(i60 i60Var, f51 f51Var, Object obj, String str) throws IOException {
        Object obj2 = ((Map) this.c).get(str);
        if (obj2 == null) {
            return;
        }
        String strR = f51Var.R();
        if (!(obj2 instanceof List)) {
            b(f51Var, i60Var, str, obj, strR, ((Integer) obj2).intValue());
            return;
        }
        Iterator it = ((List) obj2).iterator();
        while (it.hasNext()) {
            b(f51Var, i60Var, str, obj, strR, ((Integer) it.next()).intValue());
        }
    }

    public void s(String str, String str2) {
        str2.getClass();
        vb2 vb2Var = (vb2) this.b;
        vb2Var.getClass();
        xr0.y(str);
        xr0.z(str2, str);
        vb2Var.i(str);
        xr0.e(vb2Var, str, str2);
    }

    public void t(String str, ic2 ic2Var) {
        str.getClass();
        if (str.length() <= 0) {
            cw1.f("method.isEmpty() == true");
            return;
        }
        if (ic2Var == null) {
            if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("QUERY") || str.equals("REPORT")) {
                c.f(im2.B("method ", str, " must have a request body."));
                return;
            }
        } else if (!uw0.y(str)) {
            c.f(im2.B("method ", str, " must not have a request body."));
            return;
        }
        this.e = str;
        this.c = ic2Var;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x019d  */
    /* JADX WARN: Code duplicated, block: B:26:0x005b  */
    /* JADX WARN: Multi-variable type inference failed */
    public p60 u(String str) {
        n70 n70Var;
        k91 q60Var;
        String str2;
        j91 j91Var;
        nk2 nk2Var;
        CharSequence charSequenceSubSequence;
        if (!wp2.a(str)) {
            cw1.f("JWT String argument cannot be null or empty.");
            return null;
        }
        if (!wp2.a(str)) {
            cw1.f("JWT String argument cannot be null or empty.");
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        int i = 0;
        int i2 = 0;
        String str3 = null;
        String str4 = null;
        for (char c : str.toCharArray()) {
            if (c == '.') {
                if (sb.length() > 0) {
                    int length = sb.length();
                    int i3 = 0;
                    while (i3 < length && Character.isWhitespace(sb.charAt(i3))) {
                        i3++;
                    }
                    int i4 = length;
                    while (i3 < length && Character.isWhitespace(sb.charAt(i4 - 1))) {
                        i4--;
                    }
                    if (i3 > 0 || i4 < length) {
                        charSequenceSubSequence = sb.subSequence(i3, i4);
                    } else {
                        charSequenceSubSequence = sb;
                    }
                } else {
                    charSequenceSubSequence = sb;
                }
                if (charSequenceSubSequence == null || charSequenceSubSequence.length() <= 0) {
                    charSequenceSubSequence = null;
                }
                String string = charSequenceSubSequence != null ? charSequenceSubSequence.toString() : null;
                if (i2 == 0) {
                    str4 = string;
                } else if (i2 == 1) {
                    str3 = string;
                }
                i2++;
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        if (i2 != 2) {
            throw new tk1(d61.p(i2, "JWT strings must contain exactly 2 period characters. Found: "));
        }
        String string2 = sb.length() > 0 ? sb.toString() : null;
        if (str3 == null) {
            throw new tk1(im2.B("JWT string '", str, "' is missing a body/payload."));
        }
        if (str4 != null) {
            Map mapV = v(new String(et2.b.a(str4), k1.c));
            q60Var = string2 != null ? new q60(mapV) : new m60(mapV);
            ((wp1) this.c).getClass();
            Map map = q60Var.b;
            Object obj = map.get("zip");
            String strValueOf = obj != null ? String.valueOf(obj) : null;
            if (!wp2.a(strValueOf)) {
                Object obj2 = map.get("calg");
                strValueOf = obj2 != null ? String.valueOf(obj2) : null;
            }
            if (!wp2.a(strValueOf)) {
                n70Var = null;
            } else if ("DEF".equalsIgnoreCase(strValueOf)) {
                n70Var = xz.a;
            } else {
                if (!"GZIP".equalsIgnoreCase(strValueOf)) {
                    throw new yz(im2.B("Unsupported compression algorithm '", strValueOf, "'"));
                }
                n70Var = xz.b;
            }
        } else {
            n70Var = null;
            q60Var = null;
        }
        if (n70Var != null) {
            byte[] bArrA = et2.b.a(str3);
            n53.y(bArrA, "compressed bytes cannot be null.");
            try {
                str2 = new String(n70Var.y(bArrA), wp2.a);
            } catch (IOException e) {
                throw new yz("Unable to decompress bytes.", e);
            }
        } else {
            str2 = new String(et2.b.a(str3), k1.c);
        }
        b60 b60Var = (str2.charAt(0) == '{' && str2.charAt(str2.length() - 1) == '}') ? new b60(v(str2)) : null;
        if (string2 != null) {
            q60 q60Var2 = (q60) q60Var;
            if (q60Var == null) {
                nk2Var = null;
            } else {
                Object obj3 = q60Var2.b.get("alg");
                String strValueOf2 = obj3 != null ? String.valueOf(obj3) : null;
                if (wp2.a(strValueOf2)) {
                    nk2[] nk2VarArrValues = nk2.values();
                    int length2 = nk2VarArrValues.length;
                    while (true) {
                        if (i >= length2) {
                            throw new tk1(im2.B("Unsupported signature algorithm '", strValueOf2, "'"));
                        }
                        nk2Var = nk2VarArrValues[i];
                        if (nk2Var.b.equalsIgnoreCase(strValueOf2)) {
                            break;
                        }
                        i++;
                    }
                } else {
                    nk2Var = null;
                }
            }
            if (nk2Var == null || nk2Var == nk2.NONE) {
                throw new tk1("JWT string has a digest/signature, but the header does not reference a valid signature algorithm.");
            }
            ECPublicKey eCPublicKey = (ECPublicKey) this.b;
            n53.y(eCPublicKey, "A signing key must be specified if the specified JWT is digitally signed.");
            try {
                if (!n(nk2Var, eCPublicKey).a.x((str4 + '.' + str3).getBytes(r60.b), et2.b.a(string2))) {
                    throw new tk1("JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.");
                }
            } catch (IllegalArgumentException e2) {
                String str5 = nk2Var.b;
                StringBuilder sbV = im2.v("The parsed JWT indicates it was signed with the ", str5, " signature algorithm, but the specified signing key of type ");
                sbV.append(eCPublicKey.getClass().getName());
                sbV.append(" may not be used to validate ");
                sbV.append(str5);
                sbV.append(" signatures.  Because the specified signing key reflects a specific and expected algorithm, and the JWT does not reflect this algorithm, it is likely that the JWT was not expected and therefore should not be trusted.  Another possibility is that the parser was configured with the incorrect signing key, but this cannot be assumed for security reasons.");
                throw new yz(sbV.toString(), e2);
            }
        }
        if (b60Var != null) {
            ((fo3) this.e).getClass();
            Date date = new Date();
            long time = date.getTime();
            Date date2 = (Date) b60Var.a(Date.class, "exp");
            if (date2 != null && date.after(date2)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                String str6 = simpleDateFormat.format(date2);
                String str7 = simpleDateFormat.format(date);
                long time2 = time - date2.getTime();
                StringBuilder sbU = d61.u("JWT expired at ", str6, ". Current time: ", str7, ", a difference of ");
                sbU.append(time2);
                sbU.append(" milliseconds.  Allowed clock skew: 0 milliseconds.");
                throw new ri0(sbU.toString());
            }
            Date date3 = (Date) b60Var.a(Date.class, "nbf");
            if (date3 != null && date.before(date3)) {
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                String str8 = simpleDateFormat2.format(date3);
                String str9 = simpleDateFormat2.format(date);
                long time3 = date3.getTime() - time;
                StringBuilder sbU2 = d61.u("JWT must not be accepted before ", str8, ". Current time: ", str9, ", a difference of ");
                sbU2.append(time3);
                sbU2.append(" milliseconds.  Allowed clock skew: 0 milliseconds.");
                throw new s12(sbU2.toString());
            }
            b60 b60Var2 = (b60) this.d;
            for (String str10 : b60Var2.b.keySet()) {
                Object objA = b60Var2.b.get(str10);
                Object objA2 = b60Var.b.get(str10);
                if ("iat".equals(str10) || "exp".equals(str10) || "nbf".equals(str10)) {
                    objA = b60Var2.a(Date.class, str10);
                    objA2 = b60Var.a(Date.class, str10);
                } else if ((objA instanceof Date) && objA2 != null && (objA2 instanceof Long)) {
                    objA2 = new Date(((Long) objA2).longValue());
                }
                fz0 yp1Var = objA2 == null ? new yp1(String.format("Expected %s claim to be: %s, but was not present in the JWT claims.", str10, objA)) : !objA.equals(objA2) ? new fx0(String.format("Expected %s claim to be: %s, but was: %s.", str10, objA, objA2)) : null;
                if (yp1Var != null) {
                    yp1Var.b = objA;
                    throw yp1Var;
                }
            }
        }
        if (b60Var != null) {
            str2 = b60Var;
        }
        if (string2 != null) {
            p60 p60Var = new p60();
            p60Var.b = (q60) q60Var;
            p60Var.c = str2;
            p60Var.d = string2;
            VarHandle.storeStoreFence();
            j91Var = p60Var;
        } else {
            rg2 rg2Var = new rg2(3);
            rg2Var.c = q60Var;
            rg2Var.d = str2;
            VarHandle.storeStoreFence();
            j91Var = rg2Var;
        }
        if (!(j91Var instanceof p60)) {
            if (j91Var.b() instanceof b60) {
                throw new yz("Unsigned Claims JWTs are not supported.");
            }
            throw new yz("Unsigned plaintext JWTs are not supported.");
        }
        p60 p60Var2 = (p60) j91Var;
        if (p60Var2.c instanceof b60) {
            return p60Var2;
        }
        throw new yz("Signed plaintext JWSs are not supported.");
    }

    public Map v(String str) {
        try {
            return (Map) ((pv1) this.a).e(str);
        } catch (IOException e) {
            throw new tk1("Unable to read JSON value: ".concat(str), e);
        }
    }

    public re3 w() {
        re3 re3Var = new re3();
        re3Var.a = (qx2) this.a;
        xi0[] xi0VarArr = (xi0[]) this.b;
        re3Var.b = xi0VarArr;
        re3Var.c = (Map) this.c;
        int length = xi0VarArr.length;
        re3Var.d = new String[length];
        re3Var.e = new hu2[length];
        VarHandle.storeStoreFence();
        return re3Var;
    }

    public void x() throws IOException {
        Context context = (Context) this.b;
        MediaProjection mediaProjectionA = u23.a(context);
        mediaProjectionA.registerCallback(new yh2(), null);
        this.a = mediaProjectionA;
        MediaRecorder mediaRecorder = (MediaRecorder) this.c;
        mediaRecorder.setVideoSource(2);
        mediaRecorder.setOutputFormat(2);
        mediaRecorder.setVideoEncoder(2);
        mediaRecorder.setVideoSize(720, 1280);
        mediaRecorder.setVideoFrameRate(24);
        mediaRecorder.setVideoEncodingBitRate(1048576);
        Path pathCreateTempFile = Files.createTempFile(context.getCacheDir().toPath(), "clip_", null, new FileAttribute[0]);
        this.e = pathCreateTempFile;
        mediaRecorder.setOutputFile(pathCreateTempFile.toFile());
        mediaRecorder.prepare();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        MediaProjection mediaProjection = (MediaProjection) this.a;
        this.d = mediaProjection != null ? mediaProjection.createVirtualDisplay("ScreenRecorder", displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.densityDpi, 16, mediaRecorder.getSurface(), null, null) : null;
        mediaRecorder.start();
    }

    public Path y() {
        MediaRecorder mediaRecorder = (MediaRecorder) this.c;
        try {
            mediaRecorder.stop();
            return (Path) this.e;
        } catch (RuntimeException unused) {
            Log.e("ScreenRecorder", "No data has been recorded this time.");
            Path path = (Path) this.e;
            if (path != null) {
                Files.deleteIfExists(path);
            }
            return null;
        } finally {
            mediaRecorder.reset();
            MediaProjection mediaProjection = (MediaProjection) this.a;
            if (mediaProjection != null) {
                mediaProjection.stop();
            }
            this.a = null;
            VirtualDisplay virtualDisplay = (VirtualDisplay) this.d;
            if (virtualDisplay != null) {
                virtualDisplay.release();
            }
            this.d = null;
        }
    }

    public re3() {
        this.d = sf0.c;
        this.e = "GET";
        this.b = new vb2();
    }
}
