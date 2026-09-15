package org.apache.commons.compress.utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class IOUtils {
    private static final int COPY_BUF_SIZE = 8024;
    private static final byte[] SKIP_BUF = new byte[4096];
    private static final int SKIP_BUF_SIZE = 4096;

    private IOUtils() {
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copy(inputStream, outputStream, COPY_BUF_SIZE);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        if (i < 1) {
            throw new IllegalArgumentException("buffersize must be bigger than 0");
        }
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (-1 == i2) {
                return j;
            }
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
        }
    }

    public static long skip(InputStream inputStream, long j) throws IOException {
        int fully;
        long j2 = j;
        while (j2 > 0) {
            long jSkip = inputStream.skip(j2);
            if (jSkip == 0) {
                break;
            }
            j2 -= jSkip;
        }
        while (j2 > 0 && (fully = readFully(inputStream, SKIP_BUF, 0, (int) Math.min(j2, 4096L))) >= 1) {
            j2 -= (long) fully;
        }
        return j - j2;
    }

    public static int readFully(InputStream inputStream, byte[] bArr) throws IOException {
        return readFully(inputStream, bArr, 0, bArr.length);
    }

    public static int readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i2 < 0 || i < 0 || i2 + i > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = 0;
        while (i3 != i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static void readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        int iRemaining = byteBuffer.remaining();
        int i = 0;
        while (i < iRemaining) {
            int i2 = readableByteChannel.read(byteBuffer);
            if (i2 <= 0) {
                break;
            } else {
                i += i2;
            }
        }
        if (i < iRemaining) {
            throw new EOFException();
        }
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
