package g1;

import android.content.Context;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static byte[] a(String str, byte[] bArr) {
        try {
            try {
                try {
                    try {
                        try {
                            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                            cipher.init(1, secretKeySpec);
                            return cipher.doFinal(str.getBytes("utf-8"));
                        } catch (NoSuchPaddingException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    } catch (InvalidKeyException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                    return null;
                } catch (NoSuchAlgorithmException e5) {
                    e5.printStackTrace();
                    return null;
                }
            } catch (BadPaddingException e6) {
                e6.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e7) {
                e7.printStackTrace();
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 0, bArr.length, 0);
    }

    public static byte[] c(Context context, byte[] bArr) {
        j jVar = new j();
        return jVar.a(jVar.b(context.getResources().getAssets().open("pub.cer")), bArr);
    }

    public static byte[] d(String str) {
        try {
            return MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException("Huh, MD5 should be supported?", e3);
        }
    }
}
