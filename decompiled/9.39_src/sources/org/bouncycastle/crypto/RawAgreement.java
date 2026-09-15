package org.bouncycastle.crypto;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface RawAgreement {
    void calculateAgreement(CipherParameters cipherParameters, byte[] bArr, int i);

    int getAgreementSize();

    void init(CipherParameters cipherParameters);
}
