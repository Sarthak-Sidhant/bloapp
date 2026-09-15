package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ChecksumVerifyingInputStream extends InputStream {
    private long bytesRemaining;
    private final Checksum checksum;
    private final long expectedChecksum;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final InputStream f28in;

    public ChecksumVerifyingInputStream(Checksum checksum, InputStream inputStream, long j, long j2) {
        this.checksum = checksum;
        this.f28in = inputStream;
        this.expectedChecksum = j2;
        this.bytesRemaining = j;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bytesRemaining <= 0) {
            return -1;
        }
        int i = this.f28in.read();
        if (i >= 0) {
            this.checksum.update(i);
            this.bytesRemaining--;
        }
        if (this.bytesRemaining != 0 || this.expectedChecksum == this.checksum.getValue()) {
            return i;
        }
        throw new IOException("Checksum verification failed");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f28in.read(bArr, i, i2);
        if (i3 >= 0) {
            this.checksum.update(bArr, i, i3);
            this.bytesRemaining -= (long) i3;
        }
        if (this.bytesRemaining > 0 || this.expectedChecksum == this.checksum.getValue()) {
            return i3;
        }
        throw new IOException("Checksum verification failed");
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return read() >= 0 ? 1L : 0L;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f28in.close();
    }
}
