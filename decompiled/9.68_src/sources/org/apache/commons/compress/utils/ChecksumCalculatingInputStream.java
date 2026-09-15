package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ChecksumCalculatingInputStream extends InputStream {
    private final Checksum checksum;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final InputStream f27in;

    public ChecksumCalculatingInputStream(Checksum checksum, InputStream inputStream) {
        if (checksum == null) {
            throw new NullPointerException("Parameter checksum must not be null");
        }
        if (inputStream == null) {
            throw new NullPointerException("Parameter in must not be null");
        }
        this.checksum = checksum;
        this.f27in = inputStream;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.f27in.read();
        if (i >= 0) {
            this.checksum.update(i);
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f27in.read(bArr, i, i2);
        if (i3 >= 0) {
            this.checksum.update(bArr, i, i3);
        }
        return i3;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return read() >= 0 ? 1L : 0L;
    }

    public long getValue() {
        return this.checksum.getValue();
    }
}
