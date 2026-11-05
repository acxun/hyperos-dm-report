package g1;

import java.io.InputStream;
import java.security.Key;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static char[] f2681a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public byte[] a(Key key, byte[] bArr) {
        if (key == null) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, key);
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            h.b("RSAHelper", e2.getMessage());
            return null;
        }
    }

    public Key b(InputStream inputStream) {
        try {
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(inputStream)).getPublicKey();
        } catch (CertificateException e2) {
            e2.printStackTrace();
            h.b("RSAHelper", e2.getMessage());
            return null;
        }
    }
}
