package in.gov.eci.bloapp.utils;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class HybridEncryptor {
    public static Map<String, String> hybridEncrypt(String plainText, String base64PublicKey) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(base64PublicKey, 0)));
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(CpioConstants.C_IRUSR);
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        byte[] bArr = new byte[12];
        new SecureRandom().nextBytes(bArr);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKeyGenerateKey, new GCMParameterSpec(128, bArr));
        byte[] bArrDoFinal = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        Cipher cipher2 = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher2.init(1, publicKeyGeneratePublic);
        byte[] bArrDoFinal2 = cipher2.doFinal(secretKeyGenerateKey.getEncoded());
        HashMap map = new HashMap();
        map.put("encryptedPayload", Base64.encodeToString(bArrDoFinal, 2));
        map.put("encryptedKey", Base64.encodeToString(bArrDoFinal2, 2));
        map.put("iv", Base64.encodeToString(bArr, 2));
        return map;
    }
}
