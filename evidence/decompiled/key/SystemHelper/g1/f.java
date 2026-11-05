package g1;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HttpURLConnection f2677a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HttpsURLConnection f2678b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2679c = 0;

    public synchronized int a() {
        return this.f2679c;
    }

    public synchronized boolean b(String str, byte[] bArr, byte[] bArr2) {
        boolean z2;
        HttpURLConnection httpURLConnection;
        h.a("HttpHelper", "sendHttpRequest() path = " + str);
        boolean z3 = true;
        z2 = false;
        if (str.startsWith("http://")) {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                this.f2677a = httpURLConnection2;
                httpURLConnection2.setConnectTimeout(10000);
                this.f2677a.setReadTimeout(15000);
                this.f2677a.setRequestMethod("POST");
                this.f2677a.setDoOutput(true);
                this.f2677a.setDoInput(true);
                this.f2677a.setRequestProperty("Content-Type", "application/encrypted-json");
                this.f2677a.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                OutputStream outputStream = this.f2677a.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                this.f2679c = this.f2677a.getResponseCode();
                h.a("HttpHelper", "server responseCode-->" + String.valueOf(this.f2679c));
                if (this.f2679c == 200) {
                    h.a("HttpHelper", "register success!");
                } else {
                    h.b("HttpHelper", "register fail!");
                    z3 = false;
                }
                httpURLConnection = this.f2677a;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                z2 = z3;
            } catch (Throwable th) {
                HttpURLConnection httpURLConnection3 = this.f2677a;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                throw th;
            }
        } else if (str.startsWith("https://")) {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                this.f2678b = httpsURLConnection;
                httpsURLConnection.setConnectTimeout(10000);
                this.f2678b.setReadTimeout(15000);
                this.f2678b.setRequestMethod("POST");
                this.f2678b.setDoOutput(true);
                this.f2678b.setDoInput(true);
                this.f2678b.setRequestProperty("Content-Type", "application/encrypted-json");
                this.f2678b.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                OutputStream outputStream2 = this.f2678b.getOutputStream();
                outputStream2.write(bArr);
                outputStream2.flush();
                outputStream2.close();
                this.f2679c = this.f2678b.getResponseCode();
                h.a("HttpHelper", "server responseCode-->" + String.valueOf(this.f2679c));
                if (this.f2679c == 200) {
                    h.a("HttpHelper", "register success!");
                } else {
                    h.b("HttpHelper", "register fail!");
                    z3 = false;
                }
                httpURLConnection = this.f2678b;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                z2 = z3;
            } catch (Throwable th2) {
                HttpsURLConnection httpsURLConnection2 = this.f2678b;
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
                throw th2;
            }
        }
        return z2;
    }
}
