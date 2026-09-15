package org.apache.commons.compress.compressors.lzma;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.tukaani.xz.LZMAInputStream;
import org.tukaani.xz.MemoryLimitException;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class LZMACompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private final CountingInputStream countingStream;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final InputStream f21in;

    public LZMACompressorInputStream(InputStream inputStream) throws IOException {
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        this.countingStream = countingInputStream;
        this.f21in = new LZMAInputStream(countingInputStream, -1);
    }

    public LZMACompressorInputStream(InputStream inputStream, int i) throws IOException {
        try {
            CountingInputStream countingInputStream = new CountingInputStream(inputStream);
            this.countingStream = countingInputStream;
            this.f21in = new LZMAInputStream(countingInputStream, i);
        } catch (MemoryLimitException e) {
            throw new org.apache.commons.compress.MemoryLimitException(e.getMemoryNeeded(), e.getMemoryLimit(), e);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.f21in.read();
        count(i == -1 ? 0 : 1);
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f21in.read(bArr, i, i2);
        count(i3);
        return i3;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return IOUtils.skip(this.f21in, j);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f21in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f21in.close();
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }

    public static boolean matches(byte[] bArr, int i) {
        return bArr != null && i >= 3 && bArr[0] == 93 && bArr[1] == 0 && bArr[2] == 0;
    }
}
