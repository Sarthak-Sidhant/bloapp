package com.yoti.mobile.android.commons.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class HashUtils {
    public static String getMD5HexHash(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            return "";
        }
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes());
        byte[] bArrDigest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
            while (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String getSHA256HexHash(byte[] bArr) throws NoSuchAlgorithmException {
        if (bArr == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArr);
        return String.format("%064x", new BigInteger(1, messageDigest.digest()));
    }
}
