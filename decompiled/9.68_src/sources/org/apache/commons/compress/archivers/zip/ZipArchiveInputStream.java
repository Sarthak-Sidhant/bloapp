package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import kotlin.jvm.internal.LongCompanionObject;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ZipArchiveInputStream extends ArchiveInputStream implements InputStreamStatistics {
    private static final int CFH_LEN = 46;
    private static final int LFH_LEN = 30;
    private static final long TWO_EXP_32 = 4294967296L;
    private static final String USE_ZIPFILE_INSTEAD_OF_STREAM_DISCLAIMER = " while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile";
    private boolean allowStoredEntriesWithDataDescriptor;
    private final ByteBuffer buf;
    private boolean closed;
    private CurrentEntry current;
    final String encoding;
    private int entriesRead;
    private boolean hitCentralDirectory;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final InputStream f11in;
    private final Inflater inf;
    private ByteArrayInputStream lastStoredEntry;
    private final byte[] lfhBuf;
    private final byte[] shortBuf;
    private final byte[] skipBuf;
    private final byte[] twoDwordBuf;
    private long uncompressedCount;
    private final boolean useUnicodeExtraFields;
    private final byte[] wordBuf;
    private final ZipEncoding zipEncoding;
    private static final byte[] LFH = ZipLong.LFH_SIG.getBytes();
    private static final byte[] CFH = ZipLong.CFH_SIG.getBytes();
    private static final byte[] DD = ZipLong.DD_SIG.getBytes();
    private static final byte[] APK_SIGNING_BLOCK_MAGIC = {65, 80, TarConstants.LF_GNUTYPE_LONGLINK, 32, TarConstants.LF_GNUTYPE_SPARSE, 105, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 32, 66, 108, 111, 99, 107, 32, TarConstants.LF_BLK, TarConstants.LF_SYMLINK};
    private static final BigInteger LONG_MAX = BigInteger.valueOf(LongCompanionObject.MAX_VALUE);

    public ZipArchiveInputStream(InputStream inputStream) {
        this(inputStream, "UTF8");
    }

    public ZipArchiveInputStream(InputStream inputStream, String str) {
        this(inputStream, str, true);
    }

    public ZipArchiveInputStream(InputStream inputStream, String str, boolean z) {
        this(inputStream, str, z, false);
    }

    public ZipArchiveInputStream(InputStream inputStream, String str, boolean z, boolean z2) {
        this.inf = new Inflater(true);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(512);
        this.buf = byteBufferAllocate;
        this.current = null;
        this.closed = false;
        this.hitCentralDirectory = false;
        this.lastStoredEntry = null;
        this.allowStoredEntriesWithDataDescriptor = false;
        this.uncompressedCount = 0L;
        this.lfhBuf = new byte[30];
        this.skipBuf = new byte[1024];
        this.shortBuf = new byte[2];
        this.wordBuf = new byte[4];
        this.twoDwordBuf = new byte[16];
        this.entriesRead = 0;
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        this.useUnicodeExtraFields = z;
        this.f11in = new PushbackInputStream(inputStream, byteBufferAllocate.capacity());
        this.allowStoredEntriesWithDataDescriptor = z2;
        byteBufferAllocate.limit(0);
    }

    public ZipArchiveEntry getNextZipEntry() throws IOException {
        boolean z;
        ZipLong zipLong;
        ZipLong zipLong2;
        this.uncompressedCount = 0L;
        AnonymousClass1 anonymousClass1 = null;
        if (!this.closed && !this.hitCentralDirectory) {
            if (this.current != null) {
                closeEntry();
                z = false;
            } else {
                z = true;
            }
            long bytesRead = getBytesRead();
            try {
                if (z) {
                    readFirstLocalFileHeader(this.lfhBuf);
                } else {
                    readFully(this.lfhBuf);
                }
                ZipLong zipLong3 = new ZipLong(this.lfhBuf);
                if (!zipLong3.equals(ZipLong.LFH_SIG)) {
                    if (zipLong3.equals(ZipLong.CFH_SIG) || zipLong3.equals(ZipLong.AED_SIG) || isApkSigningBlock(this.lfhBuf)) {
                        this.hitCentralDirectory = true;
                        skipRemainderOfArchive();
                        return null;
                    }
                    throw new ZipException(String.format("Unexpected record signature: 0X%X", Long.valueOf(zipLong3.getValue())));
                }
                this.current = new CurrentEntry(anonymousClass1);
                this.current.entry.setPlatform((ZipShort.getValue(this.lfhBuf, 4) >> 8) & 15);
                GeneralPurposeBit generalPurposeBit = GeneralPurposeBit.parse(this.lfhBuf, 6);
                boolean zUsesUTF8ForNames = generalPurposeBit.usesUTF8ForNames();
                ZipEncoding zipEncoding = zUsesUTF8ForNames ? ZipEncodingHelper.UTF8_ZIP_ENCODING : this.zipEncoding;
                this.current.hasDataDescriptor = generalPurposeBit.usesDataDescriptor();
                this.current.entry.setGeneralPurposeBit(generalPurposeBit);
                this.current.entry.setMethod(ZipShort.getValue(this.lfhBuf, 8));
                this.current.entry.setTime(ZipUtil.dosToJavaTime(ZipLong.getValue(this.lfhBuf, 10)));
                if (this.current.hasDataDescriptor) {
                    zipLong = null;
                    zipLong2 = null;
                } else {
                    this.current.entry.setCrc(ZipLong.getValue(this.lfhBuf, 14));
                    zipLong = new ZipLong(this.lfhBuf, 18);
                    zipLong2 = new ZipLong(this.lfhBuf, 22);
                }
                int value = ZipShort.getValue(this.lfhBuf, 26);
                int value2 = ZipShort.getValue(this.lfhBuf, 28);
                byte[] bArr = new byte[value];
                readFully(bArr);
                this.current.entry.setName(zipEncoding.decode(bArr), bArr);
                if (zUsesUTF8ForNames) {
                    this.current.entry.setNameSource(ZipArchiveEntry.NameSource.NAME_WITH_EFS_FLAG);
                }
                byte[] bArr2 = new byte[value2];
                readFully(bArr2);
                this.current.entry.setExtra(bArr2);
                if (!zUsesUTF8ForNames && this.useUnicodeExtraFields) {
                    ZipUtil.setNameAndCommentFromExtraFields(this.current.entry, bArr, null);
                }
                processZip64Extra(zipLong2, zipLong);
                this.current.entry.setLocalHeaderOffset(bytesRead);
                this.current.entry.setDataOffset(getBytesRead());
                this.current.entry.setStreamContiguous(true);
                ZipMethod methodByCode = ZipMethod.getMethodByCode(this.current.entry.getMethod());
                if (this.current.entry.getCompressedSize() == -1) {
                    if (methodByCode == ZipMethod.ENHANCED_DEFLATED) {
                        this.current.f13in = new Deflate64CompressorInputStream(this.f11in);
                    }
                } else if (ZipUtil.canHandleEntryData(this.current.entry) && methodByCode != ZipMethod.STORED && methodByCode != ZipMethod.DEFLATED) {
                    BoundedInputStream boundedInputStream = new BoundedInputStream(this.f11in, this.current.entry.getCompressedSize());
                    int i = AnonymousClass1.$SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[methodByCode.ordinal()];
                    if (i == 1) {
                        this.current.f13in = new UnshrinkingInputStream(boundedInputStream);
                    } else if (i == 2) {
                        this.current.f13in = new ExplodingInputStream(this.current.entry.getGeneralPurposeBit().getSlidingDictionarySize(), this.current.entry.getGeneralPurposeBit().getNumberOfShannonFanoTrees(), boundedInputStream);
                    } else if (i == 3) {
                        this.current.f13in = new BZip2CompressorInputStream(boundedInputStream);
                    } else if (i == 4) {
                        this.current.f13in = new Deflate64CompressorInputStream(boundedInputStream);
                    }
                }
                this.entriesRead++;
                return this.current.entry;
            } catch (EOFException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.zip.ZipArchiveInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod;

        static {
            int[] iArr = new int[ZipMethod.values().length];
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod = iArr;
            try {
                iArr[ZipMethod.UNSHRINKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.IMPLODING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.BZIP2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.ENHANCED_DEFLATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void readFirstLocalFileHeader(byte[] bArr) throws IOException {
        readFully(bArr);
        ZipLong zipLong = new ZipLong(bArr);
        if (zipLong.equals(ZipLong.DD_SIG)) {
            throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.SPLITTING);
        }
        if (zipLong.equals(ZipLong.SINGLE_SEGMENT_SPLIT_MARKER)) {
            byte[] bArr2 = new byte[4];
            readFully(bArr2);
            System.arraycopy(bArr, 4, bArr, 0, 26);
            System.arraycopy(bArr2, 0, bArr, 26, 4);
        }
    }

    private void processZip64Extra(ZipLong zipLong, ZipLong zipLong2) {
        Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField = (Zip64ExtendedInformationExtraField) this.current.entry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        this.current.usesZip64 = zip64ExtendedInformationExtraField != null;
        if (this.current.hasDataDescriptor) {
            return;
        }
        if (zip64ExtendedInformationExtraField != null && (ZipLong.ZIP64_MAGIC.equals(zipLong2) || ZipLong.ZIP64_MAGIC.equals(zipLong))) {
            this.current.entry.setCompressedSize(zip64ExtendedInformationExtraField.getCompressedSize().getLongValue());
            this.current.entry.setSize(zip64ExtendedInformationExtraField.getSize().getLongValue());
        } else {
            if (zipLong2 == null || zipLong == null) {
                return;
            }
            this.current.entry.setCompressedSize(zipLong2.getValue());
            this.current.entry.setSize(zipLong.getValue());
        }
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public ArchiveEntry getNextEntry() throws IOException {
        return getNextZipEntry();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        if (!(archiveEntry instanceof ZipArchiveEntry)) {
            return false;
        }
        ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) archiveEntry;
        return ZipUtil.canHandleEntryData(zipArchiveEntry) && supportsDataDescriptorFor(zipArchiveEntry) && supportsCompressedSizeFor(zipArchiveEntry);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int deflated;
        if (this.closed) {
            throw new IOException("The stream is closed");
        }
        CurrentEntry currentEntry = this.current;
        if (currentEntry == null) {
            return -1;
        }
        if (i > bArr.length || i2 < 0 || i < 0 || bArr.length - i < i2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        ZipUtil.checkRequestedFeatures(currentEntry.entry);
        if (!supportsDataDescriptorFor(this.current.entry)) {
            throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.DATA_DESCRIPTOR, this.current.entry);
        }
        if (!supportsCompressedSizeFor(this.current.entry)) {
            throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.UNKNOWN_COMPRESSED_SIZE, this.current.entry);
        }
        if (this.current.entry.getMethod() == 0) {
            deflated = readStored(bArr, i, i2);
        } else if (this.current.entry.getMethod() == 8) {
            deflated = readDeflated(bArr, i, i2);
        } else {
            if (this.current.entry.getMethod() != ZipMethod.UNSHRINKING.getCode() && this.current.entry.getMethod() != ZipMethod.IMPLODING.getCode() && this.current.entry.getMethod() != ZipMethod.ENHANCED_DEFLATED.getCode() && this.current.entry.getMethod() != ZipMethod.BZIP2.getCode()) {
                throw new UnsupportedZipFeatureException(ZipMethod.getMethodByCode(this.current.entry.getMethod()), this.current.entry);
            }
            deflated = this.current.f13in.read(bArr, i, i2);
        }
        if (deflated >= 0) {
            this.current.crc.update(bArr, i, deflated);
            this.uncompressedCount += (long) deflated;
        }
        return deflated;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        if (this.current.entry.getMethod() == 0) {
            return this.current.bytesRead;
        }
        if (this.current.entry.getMethod() == 8) {
            return getBytesInflated();
        }
        if (this.current.entry.getMethod() == ZipMethod.UNSHRINKING.getCode()) {
            return ((UnshrinkingInputStream) this.current.f13in).getCompressedCount();
        }
        if (this.current.entry.getMethod() == ZipMethod.IMPLODING.getCode()) {
            return ((ExplodingInputStream) this.current.f13in).getCompressedCount();
        }
        if (this.current.entry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode()) {
            return ((Deflate64CompressorInputStream) this.current.f13in).getCompressedCount();
        }
        if (this.current.entry.getMethod() == ZipMethod.BZIP2.getCode()) {
            return ((BZip2CompressorInputStream) this.current.f13in).getCompressedCount();
        }
        return -1L;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    private int readStored(byte[] bArr, int i, int i2) throws IOException {
        if (this.current.hasDataDescriptor) {
            if (this.lastStoredEntry == null) {
                readStoredEntry();
            }
            return this.lastStoredEntry.read(bArr, i, i2);
        }
        long size = this.current.entry.getSize();
        if (this.current.bytesRead >= size) {
            return -1;
        }
        if (this.buf.position() >= this.buf.limit()) {
            this.buf.position(0);
            int i3 = this.f11in.read(this.buf.array());
            if (i3 == -1) {
                this.buf.limit(0);
                throw new IOException("Truncated ZIP file");
            }
            this.buf.limit(i3);
            count(i3);
            this.current.bytesReadFromStream += (long) i3;
        }
        int iMin = Math.min(this.buf.remaining(), i2);
        if (size - this.current.bytesRead < iMin) {
            iMin = (int) (size - this.current.bytesRead);
        }
        this.buf.get(bArr, i, iMin);
        this.current.bytesRead += (long) iMin;
        return iMin;
    }

    private int readDeflated(byte[] bArr, int i, int i2) throws IOException {
        int fromInflater = readFromInflater(bArr, i, i2);
        if (fromInflater <= 0) {
            if (this.inf.finished()) {
                return -1;
            }
            if (this.inf.needsDictionary()) {
                throw new ZipException("This archive needs a preset dictionary which is not supported by Commons Compress.");
            }
            if (fromInflater == -1) {
                throw new IOException("Truncated ZIP file");
            }
        }
        return fromInflater;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002d  */
    /* JADX WARN: Code duplicated, block: B:22:0x0035 A[EDGE_INSN: B:22:0x0035->B:15:0x0035 BREAK  A[LOOP:0: B:3:0x0001->B:24:?], SYNTHETIC] */
    private int readFromInflater(byte[] bArr, int i, int i2) throws IOException {
        int iInflate = 0;
        do {
            if (this.inf.needsInput()) {
                int iFill = fill();
                if (iFill > 0) {
                    this.current.bytesReadFromStream += (long) this.buf.limit();
                    iInflate = this.inf.inflate(bArr, i, i2);
                    if (iInflate == 0) {
                        break;
                        break;
                    }
                } else if (iFill == -1) {
                    return -1;
                }
            } else {
                try {
                    iInflate = this.inf.inflate(bArr, i, i2);
                    if (iInflate == 0) {
                        break;
                    }
                } catch (DataFormatException e) {
                    throw ((IOException) new ZipException(e.getMessage()).initCause(e));
                }
            }
        } while (this.inf.needsInput());
        return iInflate;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        try {
            this.f11in.close();
        } finally {
            this.inf.end();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        while (j2 < j) {
            long length = j - j2;
            byte[] bArr = this.skipBuf;
            if (bArr.length <= length) {
                length = bArr.length;
            }
            int i = read(bArr, 0, (int) length);
            if (i == -1) {
                return j2;
            }
            j2 += (long) i;
        }
        return j2;
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i < ZipArchiveOutputStream.LFH_SIG.length) {
            return false;
        }
        return checksig(bArr, ZipArchiveOutputStream.LFH_SIG) || checksig(bArr, ZipArchiveOutputStream.EOCD_SIG) || checksig(bArr, ZipArchiveOutputStream.DD_SIG) || checksig(bArr, ZipLong.SINGLE_SEGMENT_SPLIT_MARKER.getBytes());
    }

    private static boolean checksig(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private void closeEntry() throws IOException {
        long bytesInflated;
        if (this.closed) {
            throw new IOException("The stream is closed");
        }
        if (this.current == null) {
            return;
        }
        if (currentEntryHasOutstandingBytes()) {
            drainCurrentEntryData();
        } else {
            skip(LongCompanionObject.MAX_VALUE);
            if (this.current.entry.getMethod() == 8) {
                bytesInflated = getBytesInflated();
            } else {
                bytesInflated = this.current.bytesRead;
            }
            int i = (int) (this.current.bytesReadFromStream - bytesInflated);
            if (i > 0) {
                pushback(this.buf.array(), this.buf.limit() - i, i);
                this.current.bytesReadFromStream -= (long) i;
            }
            if (currentEntryHasOutstandingBytes()) {
                drainCurrentEntryData();
            }
        }
        if (this.lastStoredEntry == null && this.current.hasDataDescriptor) {
            readDataDescriptor();
        }
        this.inf.reset();
        this.buf.clear().flip();
        this.current = null;
        this.lastStoredEntry = null;
    }

    private boolean currentEntryHasOutstandingBytes() {
        return this.current.bytesReadFromStream <= this.current.entry.getCompressedSize() && !this.current.hasDataDescriptor;
    }

    private void drainCurrentEntryData() throws IOException {
        long compressedSize = this.current.entry.getCompressedSize() - this.current.bytesReadFromStream;
        while (compressedSize > 0) {
            long j = this.f11in.read(this.buf.array(), 0, (int) Math.min(this.buf.capacity(), compressedSize));
            if (j < 0) {
                throw new EOFException("Truncated ZIP entry: " + ArchiveUtils.sanitize(this.current.entry.getName()));
            }
            count(j);
            compressedSize -= j;
        }
    }

    private long getBytesInflated() {
        long bytesRead = this.inf.getBytesRead();
        if (this.current.bytesReadFromStream >= TWO_EXP_32) {
            while (true) {
                long j = bytesRead + TWO_EXP_32;
                if (j > this.current.bytesReadFromStream) {
                    break;
                }
                bytesRead = j;
            }
        }
        return bytesRead;
    }

    private int fill() throws IOException {
        if (this.closed) {
            throw new IOException("The stream is closed");
        }
        int i = this.f11in.read(this.buf.array());
        if (i > 0) {
            this.buf.limit(i);
            count(this.buf.limit());
            this.inf.setInput(this.buf.array(), 0, this.buf.limit());
        }
        return i;
    }

    private void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0);
    }

    private void readFully(byte[] bArr, int i) throws IOException {
        int length = bArr.length - i;
        int fully = IOUtils.readFully(this.f11in, bArr, i, length);
        count(fully);
        if (fully < length) {
            throw new EOFException();
        }
    }

    private void readDataDescriptor() throws IOException {
        readFully(this.wordBuf);
        ZipLong zipLong = new ZipLong(this.wordBuf);
        if (ZipLong.DD_SIG.equals(zipLong)) {
            readFully(this.wordBuf);
            zipLong = new ZipLong(this.wordBuf);
        }
        this.current.entry.setCrc(zipLong.getValue());
        readFully(this.twoDwordBuf);
        ZipLong zipLong2 = new ZipLong(this.twoDwordBuf, 8);
        if (zipLong2.equals(ZipLong.CFH_SIG) || zipLong2.equals(ZipLong.LFH_SIG)) {
            pushback(this.twoDwordBuf, 8, 8);
            this.current.entry.setCompressedSize(ZipLong.getValue(this.twoDwordBuf));
            this.current.entry.setSize(ZipLong.getValue(this.twoDwordBuf, 4));
        } else {
            this.current.entry.setCompressedSize(ZipEightByteInteger.getLongValue(this.twoDwordBuf));
            this.current.entry.setSize(ZipEightByteInteger.getLongValue(this.twoDwordBuf, 8));
        }
    }

    private boolean supportsDataDescriptorFor(ZipArchiveEntry zipArchiveEntry) {
        return !zipArchiveEntry.getGeneralPurposeBit().usesDataDescriptor() || (this.allowStoredEntriesWithDataDescriptor && zipArchiveEntry.getMethod() == 0) || zipArchiveEntry.getMethod() == 8 || zipArchiveEntry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode();
    }

    private boolean supportsCompressedSizeFor(ZipArchiveEntry zipArchiveEntry) {
        return zipArchiveEntry.getCompressedSize() != -1 || zipArchiveEntry.getMethod() == 8 || zipArchiveEntry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode() || (zipArchiveEntry.getGeneralPurposeBit().usesDataDescriptor() && this.allowStoredEntriesWithDataDescriptor && zipArchiveEntry.getMethod() == 0);
    }

    private void readStoredEntry() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = this.current.usesZip64 ? 20 : 12;
        boolean zBufferContainsSignature = false;
        int iCacheBytesRead = 0;
        while (!zBufferContainsSignature) {
            int i2 = this.f11in.read(this.buf.array(), iCacheBytesRead, 512 - iCacheBytesRead);
            if (i2 <= 0) {
                throw new IOException("Truncated ZIP file");
            }
            int i3 = i2 + iCacheBytesRead;
            if (i3 < 4) {
                iCacheBytesRead = i3;
            } else {
                zBufferContainsSignature = bufferContainsSignature(byteArrayOutputStream, iCacheBytesRead, i2, i);
                if (!zBufferContainsSignature) {
                    iCacheBytesRead = cacheBytesRead(byteArrayOutputStream, iCacheBytesRead, i2, i);
                }
            }
        }
        if (this.current.entry.getCompressedSize() != this.current.entry.getSize()) {
            throw new ZipException("compressed and uncompressed size don't match while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile");
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length != this.current.entry.getSize()) {
            throw new ZipException("actual and claimed size don't match while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile");
        }
        this.lastStoredEntry = new ByteArrayInputStream(byteArray);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0064  */
    private boolean bufferContainsSignature(ByteArrayOutputStream byteArrayOutputStream, int i, int i2, int i3) throws IOException {
        int i4;
        boolean z = false;
        int i5 = 0;
        while (!z) {
            int i6 = i + i2;
            if (i5 >= i6 - 4) {
                break;
            }
            byte b = this.buf.array()[i5];
            byte[] bArr = LFH;
            if (b == bArr[0] && this.buf.array()[i5 + 1] == bArr[1]) {
                if (i5 >= i3 && this.buf.array()[i5 + 2] == bArr[2] && this.buf.array()[i5 + 3] == bArr[3]) {
                    i4 = i5 - i3;
                    z = true;
                } else {
                    byte b2 = this.buf.array()[i5];
                    byte[] bArr2 = CFH;
                    if (b2 == bArr2[2] && this.buf.array()[i5 + 3] == bArr2[3]) {
                        i4 = i5 - i3;
                    } else {
                        byte b3 = this.buf.array()[i5 + 2];
                        byte[] bArr3 = DD;
                        if (b3 == bArr3[2] && this.buf.array()[i5 + 3] == bArr3[3]) {
                            i4 = i5;
                        } else {
                            i4 = i5;
                        }
                    }
                    z = true;
                }
                if (z) {
                    pushback(this.buf.array(), i4, i6 - i4);
                    byteArrayOutputStream.write(this.buf.array(), 0, i4);
                    readDataDescriptor();
                }
            }
            i5++;
        }
        return z;
    }

    private int cacheBytesRead(ByteArrayOutputStream byteArrayOutputStream, int i, int i2, int i3) {
        int i4 = i + i2;
        int i5 = (i4 - i3) - 3;
        if (i5 <= 0) {
            return i4;
        }
        byteArrayOutputStream.write(this.buf.array(), 0, i5);
        int i6 = i3 + 3;
        System.arraycopy(this.buf.array(), i5, this.buf.array(), 0, i6);
        return i6;
    }

    private void pushback(byte[] bArr, int i, int i2) throws IOException {
        ((PushbackInputStream) this.f11in).unread(bArr, i, i2);
        pushedBackBytes(i2);
    }

    private void skipRemainderOfArchive() throws IOException {
        realSkip((((long) this.entriesRead) * 46) - 30);
        findEocdRecord();
        realSkip(16L);
        readFully(this.shortBuf);
        realSkip(ZipShort.getValue(this.shortBuf));
    }

    private void findEocdRecord() throws IOException {
        int oneByte = -1;
        while (true) {
            boolean zIsFirstByteOfEocdSig = false;
            while (true) {
                if (!zIsFirstByteOfEocdSig) {
                    oneByte = readOneByte();
                    if (oneByte <= -1) {
                        return;
                    }
                }
                if (!isFirstByteOfEocdSig(oneByte)) {
                    break;
                }
                oneByte = readOneByte();
                if (oneByte == ZipArchiveOutputStream.EOCD_SIG[1]) {
                    oneByte = readOneByte();
                    if (oneByte == ZipArchiveOutputStream.EOCD_SIG[2]) {
                        oneByte = readOneByte();
                        if (oneByte == -1 || oneByte == ZipArchiveOutputStream.EOCD_SIG[3]) {
                            return;
                        } else {
                            zIsFirstByteOfEocdSig = isFirstByteOfEocdSig(oneByte);
                        }
                    } else if (oneByte == -1) {
                        return;
                    } else {
                        zIsFirstByteOfEocdSig = isFirstByteOfEocdSig(oneByte);
                    }
                } else if (oneByte == -1) {
                    return;
                } else {
                    zIsFirstByteOfEocdSig = isFirstByteOfEocdSig(oneByte);
                }
            }
        }
    }

    private void realSkip(long j) throws IOException {
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        while (j2 < j) {
            long length = j - j2;
            InputStream inputStream = this.f11in;
            byte[] bArr = this.skipBuf;
            if (bArr.length <= length) {
                length = bArr.length;
            }
            int i = inputStream.read(bArr, 0, (int) length);
            if (i == -1) {
                return;
            }
            count(i);
            j2 += (long) i;
        }
    }

    private int readOneByte() throws IOException {
        int i = this.f11in.read();
        if (i != -1) {
            count(1);
        }
        return i;
    }

    private boolean isFirstByteOfEocdSig(int i) {
        return i == ZipArchiveOutputStream.EOCD_SIG[0];
    }

    private boolean isApkSigningBlock(byte[] bArr) throws IOException {
        BigInteger value = ZipEightByteInteger.getValue(bArr);
        long length = 8 - bArr.length;
        byte[] bArr2 = APK_SIGNING_BLOCK_MAGIC;
        BigInteger bigIntegerAdd = value.add(BigInteger.valueOf(length - ((long) bArr2.length)));
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length2];
        try {
            if (bigIntegerAdd.signum() < 0) {
                int length3 = bArr.length + bigIntegerAdd.intValue();
                if (length3 < 8) {
                    return false;
                }
                int iAbs = Math.abs(bigIntegerAdd.intValue());
                System.arraycopy(bArr, length3, bArr3, 0, Math.min(iAbs, length2));
                if (iAbs < length2) {
                    readFully(bArr3, iAbs);
                }
            } else {
                while (true) {
                    BigInteger bigInteger = LONG_MAX;
                    if (bigIntegerAdd.compareTo(bigInteger) <= 0) {
                        break;
                    }
                    realSkip(LongCompanionObject.MAX_VALUE);
                    bigIntegerAdd = bigIntegerAdd.add(bigInteger.negate());
                }
                realSkip(bigIntegerAdd.longValue());
                readFully(bArr3);
            }
            return Arrays.equals(bArr3, APK_SIGNING_BLOCK_MAGIC);
        } catch (EOFException unused) {
            return false;
        }
    }

    private static final class CurrentEntry {
        private long bytesRead;
        private long bytesReadFromStream;
        private final CRC32 crc;
        private final ZipArchiveEntry entry;
        private boolean hasDataDescriptor;

        /* JADX INFO: renamed from: in, reason: collision with root package name */
        private InputStream f13in;
        private boolean usesZip64;

        private CurrentEntry() {
            this.entry = new ZipArchiveEntry();
            this.crc = new CRC32();
        }

        /* synthetic */ CurrentEntry(AnonymousClass1 anonymousClass1) {
            this();
        }

        static /* synthetic */ long access$708(CurrentEntry currentEntry) {
            long j = currentEntry.bytesReadFromStream;
            currentEntry.bytesReadFromStream = 1 + j;
            return j;
        }
    }

    private class BoundedInputStream extends InputStream {

        /* JADX INFO: renamed from: in, reason: collision with root package name */
        private final InputStream f12in;
        private final long max;
        private long pos = 0;

        public BoundedInputStream(InputStream inputStream, long j) {
            this.max = j;
            this.f12in = inputStream;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            long j = this.max;
            if (j >= 0 && this.pos >= j) {
                return -1;
            }
            int i = this.f12in.read();
            this.pos++;
            ZipArchiveInputStream.this.count(1);
            CurrentEntry.access$708(ZipArchiveInputStream.this.current);
            return i;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            long j = this.max;
            if (j >= 0 && this.pos >= j) {
                return -1;
            }
            int i3 = this.f12in.read(bArr, i, (int) (j >= 0 ? Math.min(i2, j - this.pos) : i2));
            if (i3 == -1) {
                return -1;
            }
            long j2 = i3;
            this.pos += j2;
            ZipArchiveInputStream.this.count(i3);
            ZipArchiveInputStream.this.current.bytesReadFromStream += j2;
            return i3;
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            long j2 = this.max;
            if (j2 >= 0) {
                j = Math.min(j, j2 - this.pos);
            }
            long jSkip = IOUtils.skip(this.f12in, j);
            this.pos += jSkip;
            return jSkip;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            long j = this.max;
            if (j < 0 || this.pos < j) {
                return this.f12in.available();
            }
            return 0;
        }
    }
}
