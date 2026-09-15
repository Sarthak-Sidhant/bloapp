package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
class ExplodingInputStream extends InputStream implements InputStreamStatistics {
    private BitStream bits;
    private final int dictionarySize;
    private BinaryTree distanceTree;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final InputStream f10in;
    private BinaryTree lengthTree;
    private BinaryTree literalTree;
    private final int minimumMatchLength;
    private final int numberOfTrees;
    private final CircularBuffer buffer = new CircularBuffer(32768);
    private long uncompressedCount = 0;
    private long treeSizes = 0;

    public ExplodingInputStream(int i, int i2, InputStream inputStream) {
        if (i != 4096 && i != 8192) {
            throw new IllegalArgumentException("The dictionary size must be 4096 or 8192");
        }
        if (i2 != 2 && i2 != 3) {
            throw new IllegalArgumentException("The number of trees must be 2 or 3");
        }
        this.dictionarySize = i;
        this.numberOfTrees = i2;
        this.minimumMatchLength = i2;
        this.f10in = inputStream;
    }

    private void init() throws IOException {
        if (this.bits == null) {
            CountingInputStream countingInputStream = new CountingInputStream(this.f10in) { // from class: org.apache.commons.compress.archivers.zip.ExplodingInputStream.1
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
            try {
                if (this.numberOfTrees == 3) {
                    this.literalTree = BinaryTree.decode(countingInputStream, CpioConstants.C_IRUSR);
                }
                this.lengthTree = BinaryTree.decode(countingInputStream, 64);
                this.distanceTree = BinaryTree.decode(countingInputStream, 64);
                this.treeSizes += countingInputStream.getBytesRead();
                countingInputStream.close();
                this.bits = new BitStream(this.f10in);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        countingInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.buffer.available()) {
            fillBuffer();
        }
        int i = this.buffer.get();
        if (i > -1) {
            this.uncompressedCount++;
        }
        return i;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.bits.getBytesRead() + this.treeSizes;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f10in.close();
    }

    private void fillBuffer() throws IOException {
        int iNextByte;
        init();
        int iNextBit = this.bits.nextBit();
        if (iNextBit == -1) {
            return;
        }
        if (iNextBit == 1) {
            BinaryTree binaryTree = this.literalTree;
            if (binaryTree != null) {
                iNextByte = binaryTree.read(this.bits);
            } else {
                iNextByte = this.bits.nextByte();
            }
            if (iNextByte == -1) {
                return;
            }
            this.buffer.put(iNextByte);
            return;
        }
        int i = this.dictionarySize == 4096 ? 6 : 7;
        int iNextBits = (int) this.bits.nextBits(i);
        int i2 = this.distanceTree.read(this.bits);
        if (i2 != -1 || iNextBits > 0) {
            int i3 = (i2 << i) | iNextBits;
            int i4 = this.lengthTree.read(this.bits);
            if (i4 == 63) {
                long jNextBits = this.bits.nextBits(8);
                if (jNextBits == -1) {
                    return;
                } else {
                    i4 = (int) (((long) i4) + jNextBits);
                }
            }
            this.buffer.copy(i3 + 1, i4 + this.minimumMatchLength);
        }
    }
}
