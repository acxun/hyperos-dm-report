package defpackage;

import android.util.Log;
import java.lang.invoke.VarHandle;

/* JADX INFO: loaded from: classes.dex */
public final class fx implements rh2 {
    public bx a;
    public x03 b;
    public int c;
    public boolean d;
    public dx e;

    @Override // defpackage.rh2, defpackage.ty0
    public final Object a(l02 l02Var, k20 k20Var) {
        Object obj = ((gh2) l02Var.a().b).c.get("scan_params");
        obj.getClass();
        int iIntValue = ((Integer) obj).intValue();
        this.c = iIntValue;
        kl0 kl0Var = kl0.g;
        this.d = gd3.u(iIntValue, Integer.MIN_VALUE);
        dx dxVar = this.e;
        int i = this.c;
        dxVar.getClass();
        dxVar.a = (i & 3) != 0;
        dxVar.b = (i & 4) != 0;
        dxVar.c = gd3.u(i, 16);
        if (!dxVar.a && !dxVar.b) {
            Log.w("CloudScanner", "Scan mode is not specified yet.The original input will be returned.");
        }
        return b(l02Var.b(), k20Var);
    }

    @Override // defpackage.rh2
    public final Object b(Object obj, k20 k20Var) {
        ex exVar = new ex(this, (cm0) obj, null);
        hm0 hm0Var = new hm0(1);
        hm0Var.c = exVar;
        VarHandle.storeStoreFence();
        return hm0Var;
    }
}
