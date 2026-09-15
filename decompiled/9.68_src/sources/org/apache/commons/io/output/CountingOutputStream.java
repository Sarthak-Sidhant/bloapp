package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CountingOutputStream extends ProxyOutputStream {
    private long count;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.count += (long) bArr.length;
        super.write(bArr);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.count += (long) i2;
        super.write(bArr, i, i2);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.count++;
        super.write(i);
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
