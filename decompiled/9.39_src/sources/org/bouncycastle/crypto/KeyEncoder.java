package org.bouncycastle.crypto;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface KeyEncoder {
    byte[] getEncoded(AsymmetricKeyParameter asymmetricKeyParameter);
}
