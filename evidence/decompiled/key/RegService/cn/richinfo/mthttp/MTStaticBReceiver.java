package cn.richinfo.mthttp;

import a1.c;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.richinfo.mthttp.Constant;
import com.richinfo.mthttp.MTSDK;
import j2.a;
import v1.e;

/* JADX INFO: loaded from: classes.dex */
public class MTStaticBReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            a.E(" MTStaticBReceiver", "静态广播广播异常，无Action信息");
        }
        a.C(" MTStaticBReceiver", "静态广播:" + action);
        action.getClass();
        switch (action) {
            case "com.richinfo.mt.alarm_date_reset":
                MTSDK.getInstance().startClient();
                break;
            case "com.richinfo.mt.alarm_heart":
                MTSDK.getInstance().heartClient();
                break;
            case "com.richinfo.mt.alarm_retry":
                c.b(context).e(new e(17, (Object) null), new e(18, (Object) null), intent.getBooleanExtra(Constant.ACTION_EXTRA_MODE, false));
                break;
        }
    }
}
