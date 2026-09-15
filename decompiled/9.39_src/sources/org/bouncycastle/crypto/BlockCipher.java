package org.bouncycastle.crypto;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface BlockCipher {
    String getAlgorithmName();

    int getBlockSize();

    void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException;

    int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException, DataLengthException;

    void reset();
}
