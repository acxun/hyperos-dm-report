package e1;

import android.content.Context;
import g1.h;
import g1.l;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends Thread {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f2482b;

    public e(Context context) {
        this.f2482b = context;
    }

    private synchronized boolean a(JSONObject jSONObject) {
        String string;
        boolean z2 = false;
        if (!g1.d.f2652e) {
            return false;
        }
        String string2 = null;
        try {
            string = jSONObject.getString("Model");
            try {
                string2 = jSONObject.getString("Manuf");
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (JSONException e3) {
            e = e3;
            string = null;
        }
        String string3 = jSONObject.toString();
        h.a("HistoryPostThread", "model:" + string + " ,manuf:" + string2 + " ,postString：" + string3);
        try {
            byte[] bArrD = g1.c.d(string3);
            String strEncode = URLEncoder.encode(g1.c.b(g1.c.c(this.f2482b, bArrD)), "utf-8");
            String str = l.k(this.f2482b) + "?ver=5.0&model=" + URLEncoder.encode(string, "utf-8") + "&manuf=" + URLEncoder.encode(string2, "utf-8") + "&sign=" + strEncode;
            byte[] bArrA = g1.c.a(string3, bArrD);
            try {
                g1.f fVar = new g1.f();
                boolean zB = fVar.b(str, bArrA, bArrD);
                if (!zB && fVar.a() == 416) {
                    zB = true;
                }
                z2 = zB;
            } catch (Exception e4) {
                h.b("HistoryPostThread", "sendPOSTRequest exception--->" + e4.toString());
            }
            return z2;
        } catch (Exception e5) {
            h.b("HistoryPostThread", "doEncrpytPost catch exception " + e5.getMessage());
            return false;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (g1.d.f2652e) {
            g1.e eVarA = g1.e.a(this.f2482b, g1.e.f2672c, g1.e.f2671b.intValue());
            try {
                JSONObject jSONObjectC = eVarA.c();
                if (jSONObjectC != null) {
                    h.a("HistoryPostThread", "post history result:" + a(jSONObjectC));
                }
                eVarA.close();
            } catch (Exception e2) {
                e2.printStackTrace();
                h.b("HistoryPostThread", "Exception : " + e2);
            }
        }
    }
}
