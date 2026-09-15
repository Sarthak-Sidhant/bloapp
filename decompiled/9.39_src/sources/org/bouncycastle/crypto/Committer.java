package org.bouncycastle.crypto;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface Committer {
    Commitment commit(byte[] bArr);

    boolean isRevealed(Commitment commitment, byte[] bArr);
}
