package defpackage;

import android.content.Context;
import android.media.projection.IMediaProjection;
import android.media.projection.IMediaProjectionManager;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.system.Os;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;

/* JADX INFO: loaded from: classes.dex */
public abstract class u23 {
    public static final VarHandle a;
    public static final MethodHandle b;
    public static final MethodHandle c;
    public static final boolean d;

    static {
        boolean z = Build.VERSION.SDK_INT >= 36;
        d = z;
        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            a = MethodHandles.privateLookupIn(MediaProjectionManager.class, lookup).findVarHandle(MediaProjectionManager.class, "mService", IMediaProjectionManager.class);
            Class cls = Boolean.TYPE;
            Class cls2 = Integer.TYPE;
            b = lookup.findVirtual(IMediaProjectionManager.class, "createProjection", z ? MethodType.methodType(IMediaProjection.class, cls2, String.class, cls2, cls, cls2) : MethodType.methodType(IMediaProjection.class, cls2, String.class, cls2, cls));
            c = lookup.findConstructor(MediaProjection.class, MethodType.methodType(Void.TYPE, Context.class, IMediaProjection.class));
        } catch (Throwable th) {
            throw new ExceptionInInitializerError(th);
        }
    }

    public static MediaProjection a(Context context) {
        Object objInvoke;
        Object obj = (Object) a.get((MediaProjectionManager) context.getSystemService(MediaProjectionManager.class));
        if (d) {
            objInvoke = (Object) b.invoke(obj, Os.getuid(), context.getPackageName(), 0, false, 0);
        } else {
            objInvoke = (Object) b.invoke(obj, Os.getuid(), context.getPackageName(), 0, false);
        }
        return (MediaProjection) c.invoke(context, objInvoke);
    }
}
