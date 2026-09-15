package org.bouncycastle.crypto;

import java.math.BigInteger;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface DSA {
    BigInteger[] generateSignature(byte[] bArr);

    void init(boolean z, CipherParameters cipherParameters);

    boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2);
}
