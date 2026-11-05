package cn.richinfo.dm.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.emoji2.text.k;
import t0.g;

/* JADX INFO: loaded from: classes.dex */
public class DMBroadCastReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        g.B().execute(new k(this, intent, context, 2));
    }
}
