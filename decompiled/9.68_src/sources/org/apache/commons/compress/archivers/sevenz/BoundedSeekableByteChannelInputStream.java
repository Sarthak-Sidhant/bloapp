package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import kotlin.UByte;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
class BoundedSeekableByteChannelInputStream extends InputStream {
    private static final int MAX_BUF_LEN = 8192;
    private final ByteBuffer buffer;
    private long bytesRemaining;
    private final SeekableByteChannel channel;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public BoundedSeekableByteChannelInputStream(SeekableByteChannel seekableByteChannel, long j) {
        this.channel = seekableByteChannel;
        this.bytesRemaining = j;
        if (j < 8192 && j > 0) {
            this.buffer = ByteBuffer.allocate((int) j);
        } else {
            this.buffer = ByteBuffer.allocate(8192);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        long j = this.bytesRemaining;
        if (j <= 0) {
            return -1;
        }
        this.bytesRemaining = j - 1;
        int i = read(1);
        return i < 0 ? i : this.buffer.get() & UByte.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        ByteBuffer byteBufferAllocate;
        int i3;
        long j = this.bytesRemaining;
        if (j <= 0) {
            return -1;
        }
        if (i2 > j) {
            i2 = (int) j;
        }
        if (i2 <= this.buffer.capacity()) {
            byteBufferAllocate = this.buffer;
            i3 = read(i2);
        } else {
            byteBufferAllocate = ByteBuffer.allocate(i2);
            i3 = this.channel.read(byteBufferAllocate);
            byteBufferAllocate.flip();
        }
        if (i3 >= 0) {
            byteBufferAllocate.get(bArr, i, i3);
            this.bytesRemaining -= (long) i3;
        }
        return i3;
    }

    private int read(int i) throws IOException {
        this.buffer.rewind().limit(i);
        int i2 = this.channel.read(this.buffer);
        this.buffer.flip();
        return i2;
    }
}
