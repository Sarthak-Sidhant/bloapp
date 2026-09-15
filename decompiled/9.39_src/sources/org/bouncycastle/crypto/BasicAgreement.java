package org.bouncycastle.crypto;

import java.math.BigInteger;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface BasicAgreement {
    BigInteger calculateAgreement(CipherParameters cipherParameters);

    int getFieldSize();

    void init(CipherParameters cipherParameters);
}
