package org.bouncycastle.crypto;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface Xof extends ExtendedDigest {
    int doFinal(byte[] bArr, int i, int i2);

    int doOutput(byte[] bArr, int i, int i2);
}
