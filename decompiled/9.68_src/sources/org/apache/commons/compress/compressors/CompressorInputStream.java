package org.apache.commons.compress.compressors;

import java.io.InputStream;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public abstract class CompressorInputStream extends InputStream {
    private long bytesRead = 0;

    protected void count(int i) {
        count(i);
    }

    protected void count(long j) {
        if (j != -1) {
            this.bytesRead += j;
        }
    }

    protected void pushedBackBytes(long j) {
        this.bytesRead -= j;
    }

    @Deprecated
    public int getCount() {
        return (int) this.bytesRead;
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public long getUncompressedCount() {
        return getBytesRead();
    }
}
