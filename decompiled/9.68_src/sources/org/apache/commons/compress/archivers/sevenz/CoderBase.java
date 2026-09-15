package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
abstract class CoderBase {
    private static final byte[] NONE = new byte[0];
    private final Class<?>[] acceptableOptions;

    abstract InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException;

    Object getOptionsFromCoder(Coder coder, InputStream inputStream) throws IOException {
        return null;
    }

    protected CoderBase(Class<?>... clsArr) {
        this.acceptableOptions = clsArr;
    }

    boolean canAcceptOptions(Object obj) {
        for (Class<?> cls : this.acceptableOptions) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    byte[] getOptionsAsProperties(Object obj) throws IOException {
        return NONE;
    }

    OutputStream encode(OutputStream outputStream, Object obj) throws IOException {
        throw new UnsupportedOperationException("Method doesn't support writing");
    }

    protected static int numberOptionOrDefault(Object obj, int i) {
        return obj instanceof Number ? ((Number) obj).intValue() : i;
    }
}
