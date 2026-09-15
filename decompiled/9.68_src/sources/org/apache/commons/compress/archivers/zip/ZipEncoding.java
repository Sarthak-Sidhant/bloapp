package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface ZipEncoding {
    boolean canEncode(String str);

    String decode(byte[] bArr) throws IOException;

    ByteBuffer encode(String str) throws IOException;
}
