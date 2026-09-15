package in.gov.eci.bloapp.utils;

import android.util.Base64;
import in.gov.eci.bloapp.BuildConfig;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class AESDecryptor {
    private static final String IV_S = "H76$suq23_po(8sD";
    private static final String KEY_S = "X_4k$uq23FSwI.qT";

    public static String decrypt(String encryptedData) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV_S.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY_S.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance(BuildConfig.CIPHER_TRANSFORMATION);
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return new String(cipher.doFinal(Base64.decode(encryptedData, 0)));
    }
}
