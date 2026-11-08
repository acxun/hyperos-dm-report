package i1;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.xiaomi.registration.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import miui.os.Build;
import miui.telephony.TelephonyManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l extends Handler {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f1737c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f1738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ z.f f1739e;

    public l(z.f fVar, Context context, int i3, int i4) {
        int i5;
        this.f1739e = fVar;
        this.a = 0;
        this.f1736b = 0;
        this.f1738d = context;
        this.a = i3;
        this.f1736b = i4;
        Log.d("AutoReg_Pairs", "ctSlotId id = " + i3 + " primary sim = " + i4);
        Resources resources = context.getResources();
        int i6 = k1.d.a;
        String[] stringArray = context.getResources().getStringArray(R.array.config_support_modem_pad);
        String str = Build.DEVICE;
        if (stringArray == null) {
            i5 = -1;
            break;
        }
        if (str != null) {
            int i7 = 0;
            while (true) {
                if (i7 >= stringArray.length) {
                    i5 = -1;
                    break;
                } else {
                    if (str.equals(stringArray[i7])) {
                        i5 = i7;
                        break;
                    }
                    i7++;
                }
            }
        } else {
            i5 = 0;
            while (true) {
                if (i5 >= stringArray.length) {
                    i5 = -1;
                    break;
                } else if (stringArray[i5] == null) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        XmlResourceParser xml = resources.getXml((!Build.IS_TABLET || (i5 != -1)) ? g2.e.l() ? R.xml.post_params_satellite : R.xml.post_params : R.xml.post_params_pad);
        try {
            g2.e.b(xml);
            while (true) {
                g2.e.o(xml);
                if (xml.getEventType() == 1) {
                    break;
                }
                k kVar = new k();
                kVar.a = xml.getAttributeValue(null, "key");
                kVar.f1733b = xml.getAttributeValue(null, "post_key");
                if (TelephonyManager.getDefault().isFiveGCapable() || !"NETWORKTYPE".equals(kVar.a)) {
                    this.f1737c.put(kVar.a, kVar);
                }
            }
        } catch (Exception e3) {
            Log.w("AutoReg_Pairs", "failed to load post_params", e3);
        } finally {
            xml.close();
        }
    }

    public final Bundle a(String str) {
        int i3;
        Bundle bundle = new Bundle();
        HashMap map = this.f1737c;
        Iterator it = map.keySet().iterator();
        loop0: while (true) {
            i3 = 0;
            do {
                if (!it.hasNext()) {
                    break loop0;
                }
                String str2 = (String) it.next();
                i3++;
                if (str != null && str.equals(str2)) {
                    break loop0;
                }
            } while (i3 != map.size());
        }
        Message messageObtainMessage = obtainMessage(i3, this.a, this.f1736b);
        messageObtainMessage.replyTo = new Messenger(this);
        bundle.putParcelable("callback", messageObtainMessage);
        return bundle;
    }

    @Override // android.os.Handler
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void handleMessage(Message message) {
        String str;
        int i3 = message.what;
        HashMap map = this.f1737c;
        Iterator it = map.keySet().iterator();
        int i4 = 0;
        do {
            if (!it.hasNext()) {
                str = null;
                break;
            } else {
                str = (String) it.next();
                i4++;
            }
        } while (i3 != i4);
        if (str == null) {
            return;
        }
        k kVar = (k) map.get(str);
        if (message.obj instanceof Bundle) {
            Objects.requireNonNull(kVar);
            kVar.f1734c = ((Bundle) message.obj).getString("result");
        }
        Objects.requireNonNull(kVar);
        kVar.f1735d = true;
        c();
    }

    public final void c() {
        JSONObject jSONObject = new JSONObject();
        HashMap map = this.f1737c;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            k kVar = (k) map.get((String) it.next());
            if (!kVar.f1735d) {
                return;
            }
            try {
                String str = kVar.f1733b;
                String str2 = kVar.f1734c;
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put(str, str2);
            } catch (JSONException e3) {
                Log.w("AutoReg_Pairs", "failed to get params", e3);
            }
        }
        k1.d.h("Params: " + jSONObject);
        String string = jSONObject.toString();
        z.f fVar = this.f1739e;
        fVar.getClass();
        new m(0, fVar, string).start();
    }
}
