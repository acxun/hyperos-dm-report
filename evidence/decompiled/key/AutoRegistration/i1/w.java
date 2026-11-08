package i1;

import android.content.Context;
import android.content.IntentFilter;
import android.telephony.SmsManager;

/* JADX INFO: loaded from: classes.dex */
public final class w {
    public final q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f1778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f1779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f1780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SmsManager f1781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1782f;

    public w(Context context, q qVar, int i3) {
        this.a = null;
        this.f1780d = context;
        this.f1781e = ((SmsManager) context.getSystemService(SmsManager.class)).createForSubscriptionId(i3);
        this.a = qVar;
        v vVar = new v(this, (Object) null);
        this.f1778b = vVar;
        context.registerReceiver(vVar, new IntentFilter("AUTO_REG_SMS_SEND"), 2);
        v vVar2 = new v(this);
        this.f1779c = vVar2;
        context.registerReceiver(vVar2, new IntentFilter("AUTO_REG_SMS_DELIVERED"), 2);
    }
}
