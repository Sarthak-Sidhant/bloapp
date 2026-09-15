package org.bouncycastle.crypto;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface SkippingCipher {
    long getPosition();

    long seekTo(long j);

    long skip(long j);
}
