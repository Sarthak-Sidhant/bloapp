package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class TarArchiveInputStream extends ArchiveInputStream {
    private static final int SMALL_BUFFER_SIZE = 256;
    private final int blockSize;
    private TarArchiveEntry currEntry;
    final String encoding;
    private long entryOffset;
    private long entrySize;
    private Map<String, String> globalPaxHeaders;
    private boolean hasHitEOF;
    private final InputStream is;
    private final boolean lenient;
    private final int recordSize;
    private final byte[] smallBuf;
    private final ZipEncoding zipEncoding;

    @Override // java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public TarArchiveInputStream(InputStream inputStream) {
        this(inputStream, TarConstants.DEFAULT_BLKSIZE, 512);
    }

    public TarArchiveInputStream(InputStream inputStream, boolean z) {
        this(inputStream, TarConstants.DEFAULT_BLKSIZE, 512, null, z);
    }

    public TarArchiveInputStream(InputStream inputStream, String str) {
        this(inputStream, TarConstants.DEFAULT_BLKSIZE, 512, str);
    }

    public TarArchiveInputStream(InputStream inputStream, int i) {
        this(inputStream, i, 512);
    }

    public TarArchiveInputStream(InputStream inputStream, int i, String str) {
        this(inputStream, i, 512, str);
    }

    public TarArchiveInputStream(InputStream inputStream, int i, int i2) {
        this(inputStream, i, i2, null);
    }

    public TarArchiveInputStream(InputStream inputStream, int i, int i2, String str) {
        this(inputStream, i, i2, str, false);
    }

    public TarArchiveInputStream(InputStream inputStream, int i, int i2, String str, boolean z) {
        this.smallBuf = new byte[256];
        this.globalPaxHeaders = new HashMap();
        this.is = inputStream;
        this.hasHitEOF = false;
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        this.recordSize = i2;
        this.blockSize = i;
        this.lenient = z;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.is.close();
    }

    public int getRecordSize() {
        return this.recordSize;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (isDirectory()) {
            return 0;
        }
        long j = this.entrySize;
        long j2 = this.entryOffset;
        if (j - j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) (j - j2);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (j <= 0 || isDirectory()) {
            return 0L;
        }
        long jSkip = IOUtils.skip(this.is, Math.min(j, this.entrySize - this.entryOffset));
        count(jSkip);
        this.entryOffset += jSkip;
        return jSkip;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
    }

    public TarArchiveEntry getNextTarEntry() throws IOException {
        if (isAtEOF()) {
            return null;
        }
        if (this.currEntry != null) {
            IOUtils.skip(this, LongCompanionObject.MAX_VALUE);
            skipRecordPadding();
        }
        byte[] record = getRecord();
        if (record == null) {
            this.currEntry = null;
            return null;
        }
        try {
            TarArchiveEntry tarArchiveEntry = new TarArchiveEntry(record, this.zipEncoding, this.lenient);
            this.currEntry = tarArchiveEntry;
            this.entryOffset = 0L;
            this.entrySize = tarArchiveEntry.getSize();
            if (this.currEntry.isGNULongLinkEntry()) {
                byte[] longNameData = getLongNameData();
                if (longNameData == null) {
                    return null;
                }
                this.currEntry.setLinkName(this.zipEncoding.decode(longNameData));
            }
            if (this.currEntry.isGNULongNameEntry()) {
                byte[] longNameData2 = getLongNameData();
                if (longNameData2 == null) {
                    return null;
                }
                this.currEntry.setName(this.zipEncoding.decode(longNameData2));
            }
            if (this.currEntry.isGlobalPaxHeader()) {
                readGlobalPaxHeaders();
            }
            if (this.currEntry.isPaxHeader()) {
                paxHeaders();
            } else if (!this.globalPaxHeaders.isEmpty()) {
                applyPaxHeadersToCurrentEntry(this.globalPaxHeaders);
            }
            if (this.currEntry.isOldGNUSparse()) {
                readOldGNUSparse();
            }
            this.entrySize = this.currEntry.getSize();
            return this.currEntry;
        } catch (IllegalArgumentException e) {
            throw new IOException("Error detected parsing the header", e);
        }
    }

    private void skipRecordPadding() throws IOException {
        if (isDirectory()) {
            return;
        }
        long j = this.entrySize;
        if (j > 0) {
            int i = this.recordSize;
            if (j % ((long) i) != 0) {
                count(IOUtils.skip(this.is, (((j / ((long) i)) + 1) * ((long) i)) - j));
            }
        }
    }

    protected byte[] getLongNameData() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = read(this.smallBuf);
            if (i < 0) {
                break;
            }
            byteArrayOutputStream.write(this.smallBuf, 0, i);
        }
        getNextEntry();
        if (this.currEntry == null) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > 0 && byteArray[length - 1] == 0) {
            length--;
        }
        if (length == byteArray.length) {
            return byteArray;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 0, bArr, 0, length);
        return bArr;
    }

    private byte[] getRecord() throws IOException {
        byte[] record = readRecord();
        setAtEOF(isEOFRecord(record));
        if (!isAtEOF() || record == null) {
            return record;
        }
        tryToConsumeSecondEOFRecord();
        consumeRemainderOfLastBlock();
        return null;
    }

    protected boolean isEOFRecord(byte[] bArr) {
        return bArr == null || ArchiveUtils.isArrayZero(bArr, this.recordSize);
    }

    protected byte[] readRecord() throws IOException {
        byte[] bArr = new byte[this.recordSize];
        int fully = IOUtils.readFully(this.is, bArr);
        count(fully);
        if (fully != this.recordSize) {
            return null;
        }
        return bArr;
    }

    private void readGlobalPaxHeaders() throws IOException {
        this.globalPaxHeaders = parsePaxHeaders(this);
        getNextEntry();
    }

    private void paxHeaders() throws IOException {
        Map<String, String> paxHeaders = parsePaxHeaders(this);
        getNextEntry();
        applyPaxHeadersToCurrentEntry(paxHeaders);
    }

    Map<String, String> parsePaxHeaders(InputStream inputStream) throws IOException {
        int i;
        int i2;
        HashMap map = new HashMap(this.globalPaxHeaders);
        do {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i = inputStream.read();
                if (i == -1) {
                    break;
                }
                i3++;
                if (i == 10) {
                    break;
                }
                if (i == 32) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        i2 = inputStream.read();
                        if (i2 == -1) {
                            break;
                        }
                        i3++;
                        if (i2 == 61) {
                            String string = byteArrayOutputStream.toString("UTF-8");
                            int i5 = i4 - i3;
                            if (i5 == 1) {
                                map.remove(string);
                                break;
                            }
                            byte[] bArr = new byte[i5];
                            int fully = IOUtils.readFully(inputStream, bArr);
                            if (fully != i5) {
                                throw new IOException("Failed to read Paxheader. Expected " + i5 + " bytes, read " + fully);
                            }
                            map.put(string, new String(bArr, 0, i5 - 1, "UTF-8"));
                            break;
                        }
                        byteArrayOutputStream.write((byte) i2);
                    }
                    i = i2;
                    break;
                }
                i4 = (i4 * 10) + (i - 48);
            }
        } while (i != -1);
        return map;
    }

    private void applyPaxHeadersToCurrentEntry(Map<String, String> map) {
        this.currEntry.updateEntryFromPaxHeaders(map);
    }

    private void readOldGNUSparse() throws IOException {
        byte[] record;
        if (this.currEntry.isExtended()) {
            do {
                record = getRecord();
                if (record == null) {
                    this.currEntry = null;
                    return;
                }
            } while (new TarArchiveSparseEntry(record).isExtended());
        }
    }

    private boolean isDirectory() {
        TarArchiveEntry tarArchiveEntry = this.currEntry;
        return tarArchiveEntry != null && tarArchiveEntry.isDirectory();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public ArchiveEntry getNextEntry() throws IOException {
        return getNextTarEntry();
    }

    private void tryToConsumeSecondEOFRecord() throws IOException {
        boolean zMarkSupported = this.is.markSupported();
        if (zMarkSupported) {
            this.is.mark(this.recordSize);
        }
        try {
            if ((!isEOFRecord(readRecord())) && zMarkSupported) {
                pushedBackBytes(this.recordSize);
                this.is.reset();
            }
        } catch (Throwable th) {
            if (zMarkSupported) {
                pushedBackBytes(this.recordSize);
                this.is.reset();
            }
            throw th;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (isAtEOF() || isDirectory() || this.entryOffset >= this.entrySize) {
            return -1;
        }
        if (this.currEntry == null) {
            throw new IllegalStateException("No current tar entry");
        }
        int iMin = Math.min(i2, available());
        int i3 = this.is.read(bArr, i, iMin);
        if (i3 != -1) {
            count(i3);
            this.entryOffset += (long) i3;
        } else {
            if (iMin > 0) {
                throw new IOException("Truncated TAR archive");
            }
            setAtEOF(true);
        }
        return i3;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        if (archiveEntry instanceof TarArchiveEntry) {
            return !((TarArchiveEntry) archiveEntry).isSparse();
        }
        return false;
    }

    public TarArchiveEntry getCurrentEntry() {
        return this.currEntry;
    }

    protected final void setCurrentEntry(TarArchiveEntry tarArchiveEntry) {
        this.currEntry = tarArchiveEntry;
    }

    protected final boolean isAtEOF() {
        return this.hasHitEOF;
    }

    protected final void setAtEOF(boolean z) {
        this.hasHitEOF = z;
    }

    private void consumeRemainderOfLastBlock() throws IOException {
        long bytesRead = getBytesRead();
        int i = this.blockSize;
        long j = bytesRead % ((long) i);
        if (j > 0) {
            count(IOUtils.skip(this.is, ((long) i) - j));
        }
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i < 265) {
            return false;
        }
        if (ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, TarConstants.MAGIC_OFFSET, 6) && ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_POSIX, bArr, TarConstants.VERSION_OFFSET, 2)) {
            return true;
        }
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_GNU, bArr, TarConstants.MAGIC_OFFSET, 6) && (ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_GNU_SPACE, bArr, TarConstants.VERSION_OFFSET, 2) || ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_GNU_ZERO, bArr, TarConstants.VERSION_OFFSET, 2))) {
            return true;
        }
        return ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, TarConstants.MAGIC_OFFSET, 6) && ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_ANT, bArr, TarConstants.VERSION_OFFSET, 2);
    }
}
