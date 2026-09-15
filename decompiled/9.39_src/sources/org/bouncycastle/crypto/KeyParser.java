package org.bouncycastle.crypto;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface KeyParser {
    AsymmetricKeyParameter readKey(InputStream inputStream) throws IOException;
}
