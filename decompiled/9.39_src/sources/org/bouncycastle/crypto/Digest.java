package org.bouncycastle.crypto;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface Digest {
    int doFinal(byte[] bArr, int i);

    String getAlgorithmName();

    int getDigestSize();

    void reset();

    void update(byte b);

    void update(byte[] bArr, int i, int i2);
}
