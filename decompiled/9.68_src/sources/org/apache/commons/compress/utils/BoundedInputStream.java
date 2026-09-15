package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class BoundedInputStream extends InputStream {
    private long bytesRemaining;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final InputStream f26in;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public BoundedInputStream(InputStream inputStream, long j) {
        this.f26in = inputStream;
        this.bytesRemaining = j;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        long j = this.bytesRemaining;
        if (j <= 0) {
            return -1;
        }
        this.bytesRemaining = j - 1;
        return this.f26in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.bytesRemaining;
        if (j == 0) {
            return -1;
        }
        if (i2 > j) {
            i2 = (int) j;
        }
        int i3 = this.f26in.read(bArr, i, i2);
        if (i3 >= 0) {
            this.bytesRemaining -= (long) i3;
        }
        return i3;
    }
}
