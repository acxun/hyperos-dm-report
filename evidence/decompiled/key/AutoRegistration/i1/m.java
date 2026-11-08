package i1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.gson.Gson;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import miui.os.Build;
import miui.telephony.TelephonyManager;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import y1.x;

/* JADX INFO: loaded from: classes.dex */
public final class m extends Thread {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1741c;

    public /* synthetic */ m(int i3, Object obj, Object obj2) {
        this.a = i3;
        this.f1741c = obj;
        this.f1740b = obj2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:104:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:145:0x0288  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c3 A[Catch: Exception -> 0x00d2, TRY_ENTER, TryCatch #9 {Exception -> 0x00d2, blocks: (B:17:0x00a6, B:36:0x00c8, B:34:0x00c3), top: B:183:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d8 A[Catch: JSONException -> 0x00f3, TryCatch #0 {JSONException -> 0x00f3, blocks: (B:37:0x00d2, B:39:0x00d8, B:41:0x00e9), top: B:169:0x00d2 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e9 A[Catch: JSONException -> 0x00f3, TRY_LEAVE, TryCatch #0 {JSONException -> 0x00f3, blocks: (B:37:0x00d2, B:39:0x00d8, B:41:0x00e9), top: B:169:0x00d2 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:49:0x00fe A[Catch: JSONException -> 0x010a, TRY_LEAVE, TryCatch #7 {JSONException -> 0x010a, blocks: (B:47:0x00f8, B:49:0x00fe), top: B:179:0x00f8 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x010e  */
    /* JADX WARN: Code duplicated, block: B:61:0x011c A[Catch: Exception -> 0x0126, TRY_LEAVE, TryCatch #8 {Exception -> 0x0126, blocks: (B:59:0x0117, B:61:0x011c), top: B:181:0x0117 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        byte b3;
        WifiInfo connectionInfo;
        WifiInfo connectionInfo2;
        String imeiForSlot;
        ?? r2;
        HttpClient defaultHttpClient;
        String str;
        boolean z2;
        String string;
        String string2;
        int i3 = this.a;
        Object obj = this.f1741c;
        Object obj2 = this.f1740b;
        switch (i3) {
            case 0:
                if (Build.IS_CT_CUSTOMIZATION_TEST) {
                    Log.d("AutoReg_RegistrationTask", "rawData: " + ((String) obj2));
                }
                String str2 = (String) obj2;
                byte[] bArrEncode = Base64.encode(str2.getBytes(), 0);
                z.f fVar = (z.f) obj;
                fVar.getClass();
                ?? content = "Request URI: ";
                try {
                    try {
                        try {
                            defaultHttpClient = new DefaultHttpClient();
                            try {
                                HttpPost httpPost = Build.IS_TABLET ? new HttpPost(new URI("https://zzhc.vnet.cn/pi")) : new HttpPost(new URI("https://zzhc.vnet.cn"));
                                httpPost.setHeader("Content-Type", "application/encrypted-json");
                                httpPost.setEntity(new ByteArrayEntity(bArrEncode));
                                Log.d("AutoReg_RegistrationTask", "Request URI: " + httpPost.getURI().toString());
                                content = defaultHttpClient.execute(httpPost).getEntity().getContent();
                                try {
                                    str = new String(z.f.d(content), "UTF-8");
                                    try {
                                        Log.d("AutoReg_RegistrationTask", "Response: ".concat(str));
                                        content.close();
                                    } catch (Exception e3) {
                                        e = e3;
                                        Log.w("AutoReg_RegistrationTask", "failed to post", e);
                                        if (content != 0) {
                                            content.close();
                                        }
                                        if (defaultHttpClient != null) {
                                        }
                                        if (TextUtils.isEmpty(str)) {
                                            z2 = false;
                                        } else {
                                            string2 = new JSONObject(str).getString("resultCode");
                                            if (TextUtils.isEmpty(string2)) {
                                                z2 = false;
                                            } else {
                                                z2 = false;
                                            }
                                        }
                                        if (!TextUtils.isEmpty(str)) {
                                            string = new JSONObject(str).getString("resultDesc");
                                            break;
                                        } else {
                                            string = null;
                                        }
                                        fVar.c(str2, string, z2);
                                        return;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    str = null;
                                    Log.w("AutoReg_RegistrationTask", "failed to post", e);
                                    if (content != 0) {
                                        content.close();
                                    }
                                    if (defaultHttpClient != null) {
                                        defaultHttpClient.getConnectionManager().shutdown();
                                        Log.d("AutoReg_RegistrationTask", "client shutdown");
                                        break;
                                    }
                                    if (TextUtils.isEmpty(str)) {
                                        string2 = new JSONObject(str).getString("resultCode");
                                        if (TextUtils.isEmpty(string2)) {
                                            z2 = false;
                                        } else {
                                            z2 = false;
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                    if (!TextUtils.isEmpty(str)) {
                                        string = new JSONObject(str).getString("resultDesc");
                                        break;
                                    } else {
                                        string = null;
                                    }
                                    fVar.c(str2, string, z2);
                                    return;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                content = 0;
                            } catch (Throwable th) {
                                th = th;
                                r2 = 0;
                                if (r2 != 0) {
                                    try {
                                        r2.close();
                                        if (defaultHttpClient != null) {
                                            defaultHttpClient.getConnectionManager().shutdown();
                                            Log.d("AutoReg_RegistrationTask", "client shutdown");
                                        }
                                    } catch (Exception unused) {
                                        throw th;
                                    }
                                    break;
                                } else {
                                    if (defaultHttpClient != null) {
                                        defaultHttpClient.getConnectionManager().shutdown();
                                        Log.d("AutoReg_RegistrationTask", "client shutdown");
                                    }
                                    break;
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            r2 = content;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        content = 0;
                        defaultHttpClient = null;
                    } catch (Throwable th3) {
                        th = th3;
                        r2 = 0;
                        defaultHttpClient = null;
                    }
                    defaultHttpClient.getConnectionManager().shutdown();
                    Log.d("AutoReg_RegistrationTask", "client shutdown");
                    break;
                } catch (Exception unused2) {
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        string2 = new JSONObject(str).getString("resultCode");
                        if (TextUtils.isEmpty(string2) || !TextUtils.equals(string2, "0")) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                    } else {
                        z2 = false;
                    }
                } catch (JSONException e7) {
                    Log.w("AutoReg_RegistrationTask", "failed to parse String object", e7);
                }
                try {
                    if (!TextUtils.isEmpty(str)) {
                        string = new JSONObject(str).getString("resultDesc");
                    } else {
                        string = null;
                    }
                    break;
                } catch (JSONException e8) {
                    Log.w("AutoReg_RegistrationTask", "failed to parse String object", e8);
                }
                fVar.c(str2, string, z2);
                return;
            default:
                Context context = (Context) obj2;
                if (l1.a.f2089e == null) {
                    l1.a.f2089e = new l1.a(context);
                }
                l1.a aVar = l1.a.f2089e;
                aVar.getClass();
                HashMap map = new HashMap();
                String[] strArr = l1.a.f2088d;
                int i4 = 0;
                while (true) {
                    String json = "";
                    if (i4 >= 8) {
                        int i5 = k1.d.a;
                        if (!map.isEmpty()) {
                            json = new Gson().toJson(map);
                            Log.i("AutoReg_Utils", "ctei_mapToString = " + json);
                        }
                        j1.b bVar = (j1.b) obj;
                        int i6 = j1.b.f1827b;
                        bVar.getClass();
                        try {
                            String str3 = "http://typdm.tydevice.com?jsonstr=" + URLEncoder.encode(json, StandardCharsets.UTF_8.toString());
                            if (f.f.f1048g == null) {
                                f.f.f1048g = new f.f(27);
                            }
                            y1.v vVarE = f.f.f1048g.e();
                            Log.i("Ctei_RegistrationTask", "fullUrl=" + str3);
                            x xVar = new x();
                            xVar.c(str3);
                            xVar.b("GET", null);
                            g.t tVar = new g.t(xVar);
                            vVarE.getClass();
                            new c2.n(vVarE, tVar, false).e(new f.f(28, bVar));
                            return;
                        } catch (Exception e9) {
                            Log.e("Ctei_RegistrationTask", "post e " + e9);
                            return;
                        }
                    }
                    String str4 = strArr[i4];
                    str4.getClass();
                    switch (str4) {
                        case "UPLINKMAC":
                            b3 = 0;
                            break;
                        case "IP":
                            b3 = 1;
                            break;
                        case "MAC":
                            b3 = 2;
                            break;
                        case "VER":
                            b3 = 3;
                            break;
                        case "CTEI":
                            b3 = 4;
                            break;
                        case "DATE":
                            b3 = 5;
                            break;
                        case "LINK":
                            b3 = 6;
                            break;
                        case "FWVER":
                            b3 = 7;
                            break;
                        default:
                            b3 = -1;
                            break;
                    }
                    WifiManager wifiManager = aVar.f2090b;
                    String[] strArr2 = strArr;
                    switch (b3) {
                        case 0:
                            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                                json = connectionInfo.getBSSID();
                            }
                            Log.i("Ctei_DeviceInfo", "getUplinkMac " + json);
                            map.put("UPLINKMAC", json);
                            break;
                        case 1:
                            ConnectivityManager connectivityManager = aVar.a;
                            if (connectivityManager != null) {
                                LinkProperties linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());
                                if (linkProperties == null) {
                                    json = null;
                                } else {
                                    List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
                                    if (linkAddresses.isEmpty()) {
                                        json = null;
                                    } else {
                                        StringBuilder sb = new StringBuilder();
                                        Iterator<LinkAddress> it = linkAddresses.iterator();
                                        while (it.hasNext()) {
                                            InetAddress address = it.next().getAddress();
                                            if (address instanceof Inet4Address) {
                                                sb.append(address.getHostAddress());
                                            }
                                        }
                                        if (sb.length() == 0) {
                                            json = null;
                                        } else {
                                            json = sb.toString();
                                        }
                                    }
                                }
                            }
                            Log.i("Ctei_DeviceInfo", "getIPAddress " + json);
                            map.put("IP", json);
                            break;
                        case 2:
                            if (wifiManager != null && (connectionInfo2 = wifiManager.getConnectionInfo()) != null) {
                                json = connectionInfo2.getMacAddress();
                            }
                            Log.i("Ctei_DeviceInfo", "getMacAddress " + json);
                            map.put("MAC", json);
                            break;
                        case 3:
                            map.put("VER", "01");
                            break;
                        case 4:
                            int i7 = k1.d.a;
                            if (g2.e.c("ro.radio.noril") && !TextUtils.isEmpty(g2.e.g("ro.ril.oem.ctei", ""))) {
                                imeiForSlot = g2.e.g("ro.ril.oem.ctei", "");
                            } else if (k1.d.d()) {
                                imeiForSlot = TelephonyManager.getDefault().getImeiForSlot(0);
                            }
                            map.put("CTEI", imeiForSlot);
                            break;
                        case 5:
                            map.put("DATE", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date()));
                            break;
                        case 6:
                            Log.i("Ctei_DeviceInfo", "getLinkAddress 2");
                            map.put("LINK", "2");
                            break;
                        case 7:
                            map.put("FWVER", k1.d.a(aVar.f2091c));
                            break;
                    }
                    i4++;
                    strArr = strArr2;
                }
                break;
        }
    }
}
