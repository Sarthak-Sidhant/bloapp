package org.bouncycastle.crypto;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface DerivationFunction {
    int generateBytes(byte[] bArr, int i, int i2) throws DataLengthException, IllegalArgumentException;

    void init(DerivationParameters derivationParameters);
}
