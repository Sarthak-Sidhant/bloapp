package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CountingInputStream extends ProxyInputStream {
    private long count;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i = super.read(bArr);
        this.count += i >= 0 ? i : 0L;
        return i;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = super.read(bArr, i, i2);
        this.count += i3 >= 0 ? i3 : 0L;
        return i3;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = super.read();
        this.count += i >= 0 ? 1L : 0L;
        return i;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = super.skip(j);
        this.count += jSkip;
        return jSkip;
    }

    public synchronized int getCount() {
        long byteCount;
        byteCount = getByteCount();
        if (byteCount > 2147483647L) {
            throw new ArithmeticException(new StringBuffer("The byte count ").append(byteCount).append(" is too large to be converted to an int").toString());
        }
        return (int) byteCount;
    }

    public synchronized int resetCount() {
        long jResetByteCount;
        jResetByteCount = resetByteCount();
        if (jResetByteCount > 2147483647L) {
            throw new ArithmeticException(new StringBuffer("The byte count ").append(jResetByteCount).append(" is too large to be converted to an int").toString());
        }
        return (int) jResetByteCount;
    }

    public synchronized long getByteCount() {
        return this.count;
    }

    public synchronized long resetByteCount() {
        long j;
        j = this.count;
        this.count = 0L;
        return j;
    }
}
