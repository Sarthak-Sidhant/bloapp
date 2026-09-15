package org.apache.commons.compress.archivers.zip;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import kotlin.UByte;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ZipFile implements Closeable {
    static final int BYTE_SHIFT = 8;
    private static final int CFD_LOCATOR_OFFSET = 16;
    private static final int CFH_LEN = 42;
    private static final int HASH_SIZE = 509;
    private static final long LFH_OFFSET_FOR_FILENAME_LENGTH = 26;
    private static final int MAX_EOCD_SIZE = 65557;
    static final int MIN_EOCD_SIZE = 22;
    static final int NIBLET_MASK = 15;
    private static final int POS_0 = 0;
    private static final int POS_1 = 1;
    private static final int POS_2 = 2;
    private static final int POS_3 = 3;
    private static final int ZIP64_EOCDL_LENGTH = 20;
    private static final int ZIP64_EOCDL_LOCATOR_OFFSET = 8;
    private static final int ZIP64_EOCD_CFD_LOCATOR_OFFSET = 48;
    private final SeekableByteChannel archive;
    private final String archiveName;
    private final ByteBuffer cfhBbuf;
    private final byte[] cfhBuf;
    private volatile boolean closed;
    private final ByteBuffer dwordBbuf;
    private final byte[] dwordBuf;
    private final String encoding;
    private final List<ZipArchiveEntry> entries;
    private final Map<String, LinkedList<ZipArchiveEntry>> nameMap;
    private final Comparator<ZipArchiveEntry> offsetComparator;
    private final byte[] shortBuf;
    private final boolean useUnicodeExtraFields;
    private final ByteBuffer wordBbuf;
    private final byte[] wordBuf;
    private final ZipEncoding zipEncoding;
    private static final byte[] ONE_ZERO_BYTE = new byte[1];
    private static final long CFH_SIG = ZipLong.getValue(ZipArchiveOutputStream.CFH_SIG);

    public ZipFile(File file) throws IOException {
        this(file, "UTF8");
    }

    public ZipFile(String str) throws IOException {
        this(new File(str), "UTF8");
    }

    public ZipFile(String str, String str2) throws IOException {
        this(new File(str), str2, true);
    }

    public ZipFile(File file, String str) throws IOException {
        this(file, str, true);
    }

    public ZipFile(File file, String str, boolean z) throws IOException {
        this(file, str, z, false);
    }

    public ZipFile(File file, String str, boolean z, boolean z2) throws IOException {
        this(Files.newByteChannel(file.toPath(), EnumSet.of(StandardOpenOption.READ), new FileAttribute[0]), file.getAbsolutePath(), str, z, true, z2);
    }

    public ZipFile(SeekableByteChannel seekableByteChannel) throws IOException {
        this(seekableByteChannel, "unknown archive", "UTF8", true);
    }

    public ZipFile(SeekableByteChannel seekableByteChannel, String str) throws IOException {
        this(seekableByteChannel, "unknown archive", str, true);
    }

    public ZipFile(SeekableByteChannel seekableByteChannel, String str, String str2, boolean z) throws IOException {
        this(seekableByteChannel, str, str2, z, false, false);
    }

    public ZipFile(SeekableByteChannel seekableByteChannel, String str, String str2, boolean z, boolean z2) throws IOException {
        this(seekableByteChannel, str, str2, z, false, z2);
    }

    private ZipFile(SeekableByteChannel seekableByteChannel, String str, String str2, boolean z, boolean z2, boolean z3) throws IOException {
        this.entries = new LinkedList();
        this.nameMap = new HashMap(HASH_SIZE);
        this.closed = true;
        byte[] bArr = new byte[8];
        this.dwordBuf = bArr;
        byte[] bArr2 = new byte[4];
        this.wordBuf = bArr2;
        byte[] bArr3 = new byte[42];
        this.cfhBuf = bArr3;
        this.shortBuf = new byte[2];
        this.dwordBbuf = ByteBuffer.wrap(bArr);
        this.wordBbuf = ByteBuffer.wrap(bArr2);
        this.cfhBbuf = ByteBuffer.wrap(bArr3);
        this.offsetComparator = new Comparator<ZipArchiveEntry>() { // from class: org.apache.commons.compress.archivers.zip.ZipFile.2
            @Override // java.util.Comparator
            public int compare(ZipArchiveEntry zipArchiveEntry, ZipArchiveEntry zipArchiveEntry2) {
                if (zipArchiveEntry == zipArchiveEntry2) {
                    return 0;
                }
                Entry entry = zipArchiveEntry instanceof Entry ? (Entry) zipArchiveEntry : null;
                Entry entry2 = zipArchiveEntry2 instanceof Entry ? (Entry) zipArchiveEntry2 : null;
                if (entry == null) {
                    return 1;
                }
                if (entry2 == null) {
                    return -1;
                }
                long localHeaderOffset = entry.getLocalHeaderOffset() - entry2.getLocalHeaderOffset();
                if (localHeaderOffset == 0) {
                    return 0;
                }
                return localHeaderOffset < 0 ? -1 : 1;
            }
        };
        this.archiveName = str;
        this.encoding = str2;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str2);
        this.useUnicodeExtraFields = z;
        this.archive = seekableByteChannel;
        try {
            Map<ZipArchiveEntry, NameAndComment> mapPopulateFromCentralDirectory = populateFromCentralDirectory();
            if (!z3) {
                resolveLocalFileHeaderData(mapPopulateFromCentralDirectory);
            }
            fillNameMap();
            this.closed = false;
        } catch (Throwable th) {
            this.closed = true;
            if (z2) {
                IOUtils.closeQuietly(this.archive);
            }
            throw th;
        }
    }

    public String getEncoding() {
        return this.encoding;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.archive.close();
    }

    public static void closeQuietly(ZipFile zipFile) {
        IOUtils.closeQuietly(zipFile);
    }

    public Enumeration<ZipArchiveEntry> getEntries() {
        return Collections.enumeration(this.entries);
    }

    public Enumeration<ZipArchiveEntry> getEntriesInPhysicalOrder() {
        List<ZipArchiveEntry> list = this.entries;
        ZipArchiveEntry[] zipArchiveEntryArr = (ZipArchiveEntry[]) list.toArray(new ZipArchiveEntry[list.size()]);
        Arrays.sort(zipArchiveEntryArr, this.offsetComparator);
        return Collections.enumeration(Arrays.asList(zipArchiveEntryArr));
    }

    public ZipArchiveEntry getEntry(String str) {
        LinkedList<ZipArchiveEntry> linkedList = this.nameMap.get(str);
        if (linkedList != null) {
            return linkedList.getFirst();
        }
        return null;
    }

    public Iterable<ZipArchiveEntry> getEntries(String str) {
        LinkedList<ZipArchiveEntry> linkedList = this.nameMap.get(str);
        return linkedList != null ? linkedList : Collections.emptyList();
    }

    public Iterable<ZipArchiveEntry> getEntriesInPhysicalOrder(String str) {
        ZipArchiveEntry[] zipArchiveEntryArr = new ZipArchiveEntry[0];
        if (this.nameMap.containsKey(str)) {
            zipArchiveEntryArr = (ZipArchiveEntry[]) this.nameMap.get(str).toArray(zipArchiveEntryArr);
            Arrays.sort(zipArchiveEntryArr, this.offsetComparator);
        }
        return Arrays.asList(zipArchiveEntryArr);
    }

    public boolean canReadEntryData(ZipArchiveEntry zipArchiveEntry) {
        return ZipUtil.canHandleEntryData(zipArchiveEntry);
    }

    public InputStream getRawInputStream(ZipArchiveEntry zipArchiveEntry) {
        if (!(zipArchiveEntry instanceof Entry)) {
            return null;
        }
        long dataOffset = zipArchiveEntry.getDataOffset();
        if (dataOffset == -1) {
            return null;
        }
        return createBoundedInputStream(dataOffset, zipArchiveEntry.getCompressedSize());
    }

    public void copyRawEntries(ZipArchiveOutputStream zipArchiveOutputStream, ZipArchiveEntryPredicate zipArchiveEntryPredicate) throws IOException {
        Enumeration<ZipArchiveEntry> entriesInPhysicalOrder = getEntriesInPhysicalOrder();
        while (entriesInPhysicalOrder.hasMoreElements()) {
            ZipArchiveEntry zipArchiveEntryNextElement = entriesInPhysicalOrder.nextElement();
            if (zipArchiveEntryPredicate.test(zipArchiveEntryNextElement)) {
                zipArchiveOutputStream.addRawArchiveEntry(zipArchiveEntryNextElement, getRawInputStream(zipArchiveEntryNextElement));
            }
        }
    }

    public InputStream getInputStream(ZipArchiveEntry zipArchiveEntry) throws IOException {
        if (!(zipArchiveEntry instanceof Entry)) {
            return null;
        }
        ZipUtil.checkRequestedFeatures(zipArchiveEntry);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(createBoundedInputStream(getDataOffset(zipArchiveEntry), zipArchiveEntry.getCompressedSize()));
        switch (AnonymousClass3.$SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.getMethodByCode(zipArchiveEntry.getMethod()).ordinal()]) {
            case 1:
                return new StoredStatisticsStream(bufferedInputStream);
            case 2:
                return new UnshrinkingInputStream(bufferedInputStream);
            case 3:
                return new ExplodingInputStream(zipArchiveEntry.getGeneralPurposeBit().getSlidingDictionarySize(), zipArchiveEntry.getGeneralPurposeBit().getNumberOfShannonFanoTrees(), bufferedInputStream);
            case 4:
                final Inflater inflater = new Inflater(true);
                return new InflaterInputStreamWithStatistics(new SequenceInputStream(bufferedInputStream, new ByteArrayInputStream(ONE_ZERO_BYTE)), inflater) { // from class: org.apache.commons.compress.archivers.zip.ZipFile.1
                    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        try {
                            super.close();
                        } finally {
                            inflater.end();
                        }
                    }
                };
            case 5:
                return new BZip2CompressorInputStream(bufferedInputStream);
            case 6:
                return new Deflate64CompressorInputStream(bufferedInputStream);
            default:
                throw new UnsupportedZipFeatureException(ZipMethod.getMethodByCode(zipArchiveEntry.getMethod()), zipArchiveEntry);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.zip.ZipFile$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod;

        static {
            int[] iArr = new int[ZipMethod.values().length];
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod = iArr;
            try {
                iArr[ZipMethod.STORED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.UNSHRINKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.IMPLODING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.DEFLATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.BZIP2.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.ENHANCED_DEFLATED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.AES_ENCRYPTED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_1.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_2.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_3.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_4.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.JPEG.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.LZMA.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.PKWARE_IMPLODING.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.PPMD.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.TOKENIZATION.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.UNKNOWN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.WAVPACK.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.XZ.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    public String getUnixSymlink(ZipArchiveEntry zipArchiveEntry) throws IOException {
        if (zipArchiveEntry == null || !zipArchiveEntry.isUnixSymlink()) {
            return null;
        }
        InputStream inputStream = getInputStream(zipArchiveEntry);
        try {
            String strDecode = this.zipEncoding.decode(IOUtils.toByteArray(inputStream));
            if (inputStream != null) {
                inputStream.close();
            }
            return strDecode;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            if (!this.closed) {
                System.err.println("Cleaning up unclosed ZipFile for archive " + this.archiveName);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    private Map<ZipArchiveEntry, NameAndComment> populateFromCentralDirectory() throws IOException {
        HashMap map = new HashMap();
        positionAtCentralDirectory();
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        long value = ZipLong.getValue(this.wordBuf);
        if (value != CFH_SIG && startsWithLocalFileHeader()) {
            throw new IOException("Central directory is empty, can't expand corrupt archive.");
        }
        while (value == CFH_SIG) {
            readCentralDirectoryEntry(map);
            this.wordBbuf.rewind();
            IOUtils.readFully(this.archive, this.wordBbuf);
            value = ZipLong.getValue(this.wordBuf);
        }
        return map;
    }

    private void readCentralDirectoryEntry(Map<ZipArchiveEntry, NameAndComment> map) throws IOException {
        this.cfhBbuf.rewind();
        IOUtils.readFully(this.archive, this.cfhBbuf);
        Entry entry = new Entry();
        int value = ZipShort.getValue(this.cfhBuf, 0);
        entry.setVersionMadeBy(value);
        entry.setPlatform((value >> 8) & 15);
        entry.setVersionRequired(ZipShort.getValue(this.cfhBuf, 2));
        GeneralPurposeBit generalPurposeBit = GeneralPurposeBit.parse(this.cfhBuf, 4);
        boolean zUsesUTF8ForNames = generalPurposeBit.usesUTF8ForNames();
        ZipEncoding zipEncoding = zUsesUTF8ForNames ? ZipEncodingHelper.UTF8_ZIP_ENCODING : this.zipEncoding;
        if (zUsesUTF8ForNames) {
            entry.setNameSource(ZipArchiveEntry.NameSource.NAME_WITH_EFS_FLAG);
        }
        entry.setGeneralPurposeBit(generalPurposeBit);
        entry.setRawFlag(ZipShort.getValue(this.cfhBuf, 4));
        entry.setMethod(ZipShort.getValue(this.cfhBuf, 6));
        entry.setTime(ZipUtil.dosToJavaTime(ZipLong.getValue(this.cfhBuf, 8)));
        entry.setCrc(ZipLong.getValue(this.cfhBuf, 12));
        entry.setCompressedSize(ZipLong.getValue(this.cfhBuf, 16));
        entry.setSize(ZipLong.getValue(this.cfhBuf, 20));
        int value2 = ZipShort.getValue(this.cfhBuf, 24);
        int value3 = ZipShort.getValue(this.cfhBuf, 26);
        int value4 = ZipShort.getValue(this.cfhBuf, 28);
        int value5 = ZipShort.getValue(this.cfhBuf, 30);
        entry.setInternalAttributes(ZipShort.getValue(this.cfhBuf, 32));
        entry.setExternalAttributes(ZipLong.getValue(this.cfhBuf, 34));
        byte[] bArr = new byte[value2];
        IOUtils.readFully(this.archive, ByteBuffer.wrap(bArr));
        entry.setName(zipEncoding.decode(bArr), bArr);
        entry.setLocalHeaderOffset(ZipLong.getValue(this.cfhBuf, 38));
        this.entries.add(entry);
        byte[] bArr2 = new byte[value3];
        IOUtils.readFully(this.archive, ByteBuffer.wrap(bArr2));
        entry.setCentralDirectoryExtra(bArr2);
        setSizesAndOffsetFromZip64Extra(entry, value5);
        byte[] bArr3 = new byte[value4];
        IOUtils.readFully(this.archive, ByteBuffer.wrap(bArr3));
        entry.setComment(zipEncoding.decode(bArr3));
        if (!zUsesUTF8ForNames && this.useUnicodeExtraFields) {
            map.put(entry, new NameAndComment(bArr, bArr3));
        }
        entry.setStreamContiguous(true);
    }

    private void setSizesAndOffsetFromZip64Extra(ZipArchiveEntry zipArchiveEntry, int i) throws IOException {
        Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField = (Zip64ExtendedInformationExtraField) zipArchiveEntry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (zip64ExtendedInformationExtraField != null) {
            boolean z = zipArchiveEntry.getSize() == 4294967295L;
            boolean z2 = zipArchiveEntry.getCompressedSize() == 4294967295L;
            boolean z3 = zipArchiveEntry.getLocalHeaderOffset() == 4294967295L;
            zip64ExtendedInformationExtraField.reparseCentralDirectoryData(z, z2, z3, i == 65535);
            if (z) {
                zipArchiveEntry.setSize(zip64ExtendedInformationExtraField.getSize().getLongValue());
            } else if (z2) {
                zip64ExtendedInformationExtraField.setSize(new ZipEightByteInteger(zipArchiveEntry.getSize()));
            }
            if (z2) {
                zipArchiveEntry.setCompressedSize(zip64ExtendedInformationExtraField.getCompressedSize().getLongValue());
            } else if (z) {
                zip64ExtendedInformationExtraField.setCompressedSize(new ZipEightByteInteger(zipArchiveEntry.getCompressedSize()));
            }
            if (z3) {
                zipArchiveEntry.setLocalHeaderOffset(zip64ExtendedInformationExtraField.getRelativeHeaderOffset().getLongValue());
            }
        }
    }

    private void positionAtCentralDirectory() throws IOException {
        positionAtEndOfCentralDirectoryRecord();
        boolean zEquals = false;
        boolean z = this.archive.position() > 20;
        if (z) {
            SeekableByteChannel seekableByteChannel = this.archive;
            seekableByteChannel.position(seekableByteChannel.position() - 20);
            this.wordBbuf.rewind();
            IOUtils.readFully(this.archive, this.wordBbuf);
            zEquals = Arrays.equals(ZipArchiveOutputStream.ZIP64_EOCD_LOC_SIG, this.wordBuf);
        }
        if (!zEquals) {
            if (z) {
                skipBytes(16);
            }
            positionAtCentralDirectory32();
            return;
        }
        positionAtCentralDirectory64();
    }

    private void positionAtCentralDirectory64() throws IOException {
        skipBytes(4);
        this.dwordBbuf.rewind();
        IOUtils.readFully(this.archive, this.dwordBbuf);
        this.archive.position(ZipEightByteInteger.getLongValue(this.dwordBuf));
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        if (!Arrays.equals(this.wordBuf, ZipArchiveOutputStream.ZIP64_EOCD_SIG)) {
            throw new ZipException("Archive's ZIP64 end of central directory locator is corrupt.");
        }
        skipBytes(44);
        this.dwordBbuf.rewind();
        IOUtils.readFully(this.archive, this.dwordBbuf);
        this.archive.position(ZipEightByteInteger.getLongValue(this.dwordBuf));
    }

    private void positionAtCentralDirectory32() throws IOException {
        skipBytes(16);
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        this.archive.position(ZipLong.getValue(this.wordBuf));
    }

    private void positionAtEndOfCentralDirectoryRecord() throws IOException {
        if (!tryToLocateSignature(22L, 65557L, ZipArchiveOutputStream.EOCD_SIG)) {
            throw new ZipException("Archive is not a ZIP archive");
        }
    }

    private boolean tryToLocateSignature(long j, long j2, byte[] bArr) throws IOException {
        long size = this.archive.size() - j;
        long jMax = Math.max(0L, this.archive.size() - j2);
        boolean z = false;
        if (size >= 0) {
            while (size >= jMax) {
                this.archive.position(size);
                try {
                    this.wordBbuf.rewind();
                    IOUtils.readFully(this.archive, this.wordBbuf);
                    this.wordBbuf.flip();
                    if (this.wordBbuf.get() == bArr[0] && this.wordBbuf.get() == bArr[1] && this.wordBbuf.get() == bArr[2] && this.wordBbuf.get() == bArr[3]) {
                        z = true;
                        break;
                    }
                    size--;
                } catch (EOFException unused) {
                }
            }
        }
        if (z) {
            this.archive.position(size);
        }
        return z;
    }

    private void skipBytes(int i) throws IOException {
        long jPosition = this.archive.position() + ((long) i);
        if (jPosition > this.archive.size()) {
            throw new EOFException();
        }
        this.archive.position(jPosition);
    }

    private void resolveLocalFileHeaderData(Map<ZipArchiveEntry, NameAndComment> map) throws IOException {
        Iterator<ZipArchiveEntry> it = this.entries.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int[] dataOffset = setDataOffset(entry);
            int i = dataOffset[0];
            int i2 = dataOffset[1];
            skipBytes(i);
            byte[] bArr = new byte[i2];
            IOUtils.readFully(this.archive, ByteBuffer.wrap(bArr));
            entry.setExtra(bArr);
            if (map.containsKey(entry)) {
                NameAndComment nameAndComment = map.get(entry);
                ZipUtil.setNameAndCommentFromExtraFields(entry, nameAndComment.name, nameAndComment.comment);
            }
        }
    }

    private void fillNameMap() {
        for (ZipArchiveEntry zipArchiveEntry : this.entries) {
            String name = zipArchiveEntry.getName();
            LinkedList<ZipArchiveEntry> linkedList = this.nameMap.get(name);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.nameMap.put(name, linkedList);
            }
            linkedList.addLast(zipArchiveEntry);
        }
    }

    private int[] setDataOffset(ZipArchiveEntry zipArchiveEntry) throws IOException {
        long localHeaderOffset = zipArchiveEntry.getLocalHeaderOffset();
        this.archive.position(LFH_OFFSET_FOR_FILENAME_LENGTH + localHeaderOffset);
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        this.wordBbuf.flip();
        this.wordBbuf.get(this.shortBuf);
        int value = ZipShort.getValue(this.shortBuf);
        this.wordBbuf.get(this.shortBuf);
        int value2 = ZipShort.getValue(this.shortBuf);
        zipArchiveEntry.setDataOffset(localHeaderOffset + 30 + ((long) value) + ((long) value2));
        return new int[]{value, value2};
    }

    private long getDataOffset(ZipArchiveEntry zipArchiveEntry) throws IOException {
        long dataOffset = zipArchiveEntry.getDataOffset();
        if (dataOffset != -1) {
            return dataOffset;
        }
        setDataOffset(zipArchiveEntry);
        return zipArchiveEntry.getDataOffset();
    }

    private boolean startsWithLocalFileHeader() throws IOException {
        this.archive.position(0L);
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        return Arrays.equals(this.wordBuf, ZipArchiveOutputStream.LFH_SIG);
    }

    private BoundedInputStream createBoundedInputStream(long j, long j2) {
        return this.archive instanceof FileChannel ? new BoundedFileChannelInputStream(j, j2) : new BoundedInputStream(j, j2);
    }

    private class BoundedInputStream extends InputStream {
        private final long end;
        private long loc;
        private ByteBuffer singleByteBuffer;

        BoundedInputStream(long j, long j2) {
            long j3 = j + j2;
            this.end = j3;
            if (j3 < j) {
                throw new IllegalArgumentException("Invalid length of stream at offset=" + j + ", length=" + j2);
            }
            this.loc = j;
        }

        @Override // java.io.InputStream
        public synchronized int read() throws IOException {
            if (this.loc >= this.end) {
                return -1;
            }
            ByteBuffer byteBuffer = this.singleByteBuffer;
            if (byteBuffer == null) {
                this.singleByteBuffer = ByteBuffer.allocate(1);
            } else {
                byteBuffer.rewind();
            }
            int i = read(this.loc, this.singleByteBuffer);
            if (i < 0) {
                return i;
            }
            this.loc++;
            return this.singleByteBuffer.get() & UByte.MAX_VALUE;
        }

        @Override // java.io.InputStream
        public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
            if (i2 <= 0) {
                return 0;
            }
            long j = i2;
            long j2 = this.end;
            long j3 = this.loc;
            if (j > j2 - j3) {
                if (j3 >= j2) {
                    return -1;
                }
                i2 = (int) (j2 - j3);
            }
            int i3 = read(this.loc, ByteBuffer.wrap(bArr, i, i2));
            if (i3 <= 0) {
                return i3;
            }
            this.loc += (long) i3;
            return i3;
        }

        protected int read(long j, ByteBuffer byteBuffer) throws IOException {
            int i;
            synchronized (ZipFile.this.archive) {
                ZipFile.this.archive.position(j);
                i = ZipFile.this.archive.read(byteBuffer);
            }
            byteBuffer.flip();
            return i;
        }
    }

    private class BoundedFileChannelInputStream extends BoundedInputStream {
        private final FileChannel archive;

        BoundedFileChannelInputStream(long j, long j2) {
            super(j, j2);
            this.archive = (FileChannel) ZipFile.this.archive;
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipFile.BoundedInputStream
        protected int read(long j, ByteBuffer byteBuffer) throws IOException {
            int i = this.archive.read(byteBuffer, j);
            byteBuffer.flip();
            return i;
        }
    }

    private static final class NameAndComment {
        private final byte[] comment;
        private final byte[] name;

        private NameAndComment(byte[] bArr, byte[] bArr2) {
            this.name = bArr;
            this.comment = bArr2;
        }
    }

    private static class Entry extends ZipArchiveEntry {
        Entry() {
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipArchiveEntry, java.util.zip.ZipEntry
        public int hashCode() {
            return (super.hashCode() * 3) + ((int) getLocalHeaderOffset()) + ((int) (getLocalHeaderOffset() >> 32));
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipArchiveEntry
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return getLocalHeaderOffset() == entry.getLocalHeaderOffset() && super.getDataOffset() == entry.getDataOffset();
        }
    }

    private static class StoredStatisticsStream extends CountingInputStream implements InputStreamStatistics {
        StoredStatisticsStream(InputStream inputStream) {
            super(inputStream);
        }

        @Override // org.apache.commons.compress.utils.InputStreamStatistics
        public long getCompressedCount() {
            return super.getBytesRead();
        }

        @Override // org.apache.commons.compress.utils.InputStreamStatistics
        public long getUncompressedCount() {
            return getCompressedCount();
        }
    }
}
