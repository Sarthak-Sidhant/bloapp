package org.apache.commons.compress.compressors.deflate64;

import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class Deflate64CompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private long compressedBytesRead;
    private HuffmanDecoder decoder;
    private final byte[] oneByte;
    private InputStream originalStream;

    public Deflate64CompressorInputStream(InputStream inputStream) {
        this(new HuffmanDecoder(inputStream));
        this.originalStream = inputStream;
    }

    Deflate64CompressorInputStream(HuffmanDecoder huffmanDecoder) {
        this.oneByte = new byte[1];
        this.decoder = huffmanDecoder;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i;
        do {
            i = read(this.oneByte);
            if (i == -1) {
                return -1;
            }
        } while (i == 0);
        if (i == 1) {
            return this.oneByte[0] & UByte.MAX_VALUE;
        }
        throw new IllegalStateException("Invalid return value from read: " + i);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        HuffmanDecoder huffmanDecoder = this.decoder;
        if (huffmanDecoder == null) {
            return -1;
        }
        int iDecode = huffmanDecoder.decode(bArr, i, i2);
        this.compressedBytesRead = this.decoder.getBytesRead();
        count(iDecode);
        if (iDecode == -1) {
            closeDecoder();
        }
        return iDecode;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        HuffmanDecoder huffmanDecoder = this.decoder;
        if (huffmanDecoder != null) {
            return huffmanDecoder.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            closeDecoder();
            if (this.originalStream != null) {
            }
        } finally {
            if (this.originalStream != null) {
                this.originalStream.close();
                this.originalStream = null;
            }
        }
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.compressedBytesRead;
    }

    private void closeDecoder() {
        IOUtils.closeQuietly(this.decoder);
        this.decoder = null;
    }
}
