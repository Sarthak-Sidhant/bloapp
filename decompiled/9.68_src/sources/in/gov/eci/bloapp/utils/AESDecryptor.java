package in.gov.eci.bloapp.utils;

import android.util.Base64;
import in.gov.eci.bloapp.BuildConfig;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AESDecryptor {
    private static final String[] KEY_PARTS = {"3FSw", "X_4k", "I.qT", "$uq2"};
    private static final String[] IV_PARTS = {"(8sD", "H76$", "3_po", "suq2"};

    private static String getKey() {
        StringBuilder sb = new StringBuilder();
        String[] strArr = KEY_PARTS;
        sb.append(strArr[1]);
        sb.append(strArr[3]);
        sb.append(strArr[0]);
        sb.append(strArr[2]);
        return sb.toString();
    }

    private static String getIV() {
        StringBuilder sb = new StringBuilder();
        String[] strArr = IV_PARTS;
        sb.append(strArr[1]);
        sb.append(strArr[3]);
        sb.append(strArr[2]);
        sb.append(strArr[0]);
        return sb.toString();
    }

    public static String decrypt(String encryptedData) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(getIV().getBytes(StandardCharsets.UTF_8));
        SecretKeySpec secretKeySpec = new SecretKeySpec(getKey().getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance(BuildConfig.CIPHER_TRANSFORMATION);
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return new String(cipher.doFinal(Base64.decode(encryptedData, 0)), StandardCharsets.UTF_8);
    }
}
