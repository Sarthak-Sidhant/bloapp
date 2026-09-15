package org.apache.commons.compress.archivers.sevenz;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.zip.CRC32;
import kotlin.UByte;
import kotlin.jvm.internal.LongCompanionObject;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.CRC32VerifyingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SevenZFile implements Closeable {
    private static final String DEFAULT_FILE_NAME = "unknown archive";
    static final int SIGNATURE_HEADER_SIZE = 32;
    private final Archive archive;
    private SeekableByteChannel channel;
    private long compressedBytesReadFromCurrentEntry;
    private int currentEntryIndex;
    private int currentFolderIndex;
    private InputStream currentFolderInputStream;
    private final ArrayList<InputStream> deferredBlockStreams;
    private final String fileName;
    private final SevenZFileOptions options;
    private byte[] password;
    private long uncompressedBytesReadFromCurrentEntry;
    static final byte[] sevenZSignature = {TarConstants.LF_CONTIG, 122, -68, -81, 39, 28};
    private static final CharsetEncoder PASSWORD_ENCODER = StandardCharsets.UTF_16LE.newEncoder();

    public SevenZFile(File file, char[] cArr) throws IOException {
        this(file, cArr, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(File file, char[] cArr, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(Files.newByteChannel(file.toPath(), EnumSet.of(StandardOpenOption.READ), new FileAttribute[0]), file.getAbsolutePath(), utf16Decode(cArr), true, sevenZFileOptions);
    }

    public SevenZFile(File file, byte[] bArr) throws IOException {
        this(Files.newByteChannel(file.toPath(), EnumSet.of(StandardOpenOption.READ), new FileAttribute[0]), file.getAbsolutePath(), bArr, true, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel) throws IOException {
        this(seekableByteChannel, SevenZFileOptions.DEFAULT);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SevenZFile(SeekableByteChannel seekableByteChannel, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(seekableByteChannel, DEFAULT_FILE_NAME, null, sevenZFileOptions);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, char[] cArr) throws IOException {
        this(seekableByteChannel, cArr, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, char[] cArr, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(seekableByteChannel, DEFAULT_FILE_NAME, cArr, sevenZFileOptions);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, char[] cArr) throws IOException {
        this(seekableByteChannel, str, cArr, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, char[] cArr, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(seekableByteChannel, str, utf16Decode(cArr), false, sevenZFileOptions);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str) throws IOException {
        this(seekableByteChannel, str, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(seekableByteChannel, str, null, false, sevenZFileOptions);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, byte[] bArr) throws IOException {
        this(seekableByteChannel, DEFAULT_FILE_NAME, bArr);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, byte[] bArr) throws IOException {
        this(seekableByteChannel, str, bArr, false, SevenZFileOptions.DEFAULT);
    }

    private SevenZFile(SeekableByteChannel seekableByteChannel, String str, byte[] bArr, boolean z, SevenZFileOptions sevenZFileOptions) throws IOException {
        this.currentEntryIndex = -1;
        this.currentFolderIndex = -1;
        this.currentFolderInputStream = null;
        this.deferredBlockStreams = new ArrayList<>();
        this.channel = seekableByteChannel;
        this.fileName = str;
        this.options = sevenZFileOptions;
        try {
            this.archive = readHeaders(bArr);
            if (bArr != null) {
                this.password = Arrays.copyOf(bArr, bArr.length);
            } else {
                this.password = null;
            }
        } catch (Throwable th) {
            if (z) {
                this.channel.close();
            }
            throw th;
        }
    }

    public SevenZFile(File file) throws IOException {
        this(file, SevenZFileOptions.DEFAULT);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SevenZFile(File file, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(file, (char[]) null, sevenZFileOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        SeekableByteChannel seekableByteChannel = this.channel;
        if (seekableByteChannel != null) {
            try {
                seekableByteChannel.close();
            } finally {
                this.channel = null;
                byte[] bArr = this.password;
                if (bArr != null) {
                    Arrays.fill(bArr, (byte) 0);
                }
                this.password = null;
            }
        }
    }

    public SevenZArchiveEntry getNextEntry() throws IOException {
        if (this.currentEntryIndex >= this.archive.files.length - 1) {
            return null;
        }
        this.currentEntryIndex++;
        SevenZArchiveEntry sevenZArchiveEntry = this.archive.files[this.currentEntryIndex];
        if (sevenZArchiveEntry.getName() == null && this.options.getUseDefaultNameForUnnamedEntries()) {
            sevenZArchiveEntry.setName(getDefaultName());
        }
        buildDecodingStream();
        this.compressedBytesReadFromCurrentEntry = 0L;
        this.uncompressedBytesReadFromCurrentEntry = 0L;
        return sevenZArchiveEntry;
    }

    public Iterable<SevenZArchiveEntry> getEntries() {
        return Arrays.asList(this.archive.files);
    }

    private Archive readHeaders(byte[] bArr) throws IOException {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(12).order(ByteOrder.LITTLE_ENDIAN);
        readFully(byteBufferOrder);
        byte[] bArr2 = new byte[6];
        byteBufferOrder.get(bArr2);
        if (!Arrays.equals(bArr2, sevenZSignature)) {
            throw new IOException("Bad 7z signature");
        }
        byte b = byteBufferOrder.get();
        byte b2 = byteBufferOrder.get();
        if (b != 0) {
            throw new IOException(String.format("Unsupported 7z version (%d,%d)", Byte.valueOf(b), Byte.valueOf(b2)));
        }
        StartHeader startHeader = readStartHeader(((long) byteBufferOrder.getInt()) & 4294967295L);
        assertFitsIntoInt("nextHeaderSize", startHeader.nextHeaderSize);
        int i = (int) startHeader.nextHeaderSize;
        this.channel.position(startHeader.nextHeaderOffset + 32);
        ByteBuffer byteBufferOrder2 = ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
        readFully(byteBufferOrder2);
        CRC32 crc32 = new CRC32();
        crc32.update(byteBufferOrder2.array());
        if (startHeader.nextHeaderCrc != crc32.getValue()) {
            throw new IOException("NextHeader CRC mismatch");
        }
        Archive archive = new Archive();
        int unsignedByte = getUnsignedByte(byteBufferOrder2);
        if (unsignedByte == 23) {
            byteBufferOrder2 = readEncodedHeader(byteBufferOrder2, archive, bArr);
            archive = new Archive();
            unsignedByte = getUnsignedByte(byteBufferOrder2);
        }
        if (unsignedByte == 1) {
            readHeader(byteBufferOrder2, archive);
            return archive;
        }
        throw new IOException("Broken or unsupported archive: no Header");
    }

    private StartHeader readStartHeader(long j) throws IOException {
        StartHeader startHeader = new StartHeader();
        DataInputStream dataInputStream = new DataInputStream(new CRC32VerifyingInputStream(new BoundedSeekableByteChannelInputStream(this.channel, 20L), 20L, j));
        try {
            startHeader.nextHeaderOffset = Long.reverseBytes(dataInputStream.readLong());
            startHeader.nextHeaderSize = Long.reverseBytes(dataInputStream.readLong());
            startHeader.nextHeaderCrc = ((long) Integer.reverseBytes(dataInputStream.readInt())) & 4294967295L;
            dataInputStream.close();
            return startHeader;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    dataInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private void readHeader(ByteBuffer byteBuffer, Archive archive) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 2) {
            readArchiveProperties(byteBuffer);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 3) {
            throw new IOException("Additional streams unsupported");
        }
        if (unsignedByte == 4) {
            readStreamsInfo(byteBuffer, archive);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 5) {
            readFilesInfo(byteBuffer, archive);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte != 0) {
            throw new IOException("Badly terminated header, found " + unsignedByte);
        }
    }

    private void readArchiveProperties(ByteBuffer byteBuffer) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        while (unsignedByte != 0) {
            long uint64 = readUint64(byteBuffer);
            assertFitsIntoInt("propertySize", uint64);
            byteBuffer.get(new byte[(int) uint64]);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
    }

    private ByteBuffer readEncodedHeader(ByteBuffer byteBuffer, Archive archive, byte[] bArr) throws IOException {
        readStreamsInfo(byteBuffer, archive);
        Folder folder = archive.folders[0];
        this.channel.position(archive.packPos + 32);
        BoundedSeekableByteChannelInputStream boundedSeekableByteChannelInputStream = new BoundedSeekableByteChannelInputStream(this.channel, archive.packSizes[0]);
        InputStream cRC32VerifyingInputStream = boundedSeekableByteChannelInputStream;
        for (Coder coder : folder.getOrderedCoders()) {
            if (coder.numInStreams != 1 || coder.numOutStreams != 1) {
                throw new IOException("Multi input/output stream coders are not yet supported");
            }
            cRC32VerifyingInputStream = Coders.addDecoder(this.fileName, cRC32VerifyingInputStream, folder.getUnpackSizeForCoder(coder), coder, bArr, this.options.getMaxMemoryLimitInKb());
        }
        if (folder.hasCrc) {
            cRC32VerifyingInputStream = new CRC32VerifyingInputStream(cRC32VerifyingInputStream, folder.getUnpackSize(), folder.crc);
        }
        assertFitsIntoInt("unpackSize", folder.getUnpackSize());
        byte[] bArr2 = new byte[(int) folder.getUnpackSize()];
        DataInputStream dataInputStream = new DataInputStream(cRC32VerifyingInputStream);
        try {
            dataInputStream.readFully(bArr2);
            dataInputStream.close();
            return ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    dataInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private void readStreamsInfo(ByteBuffer byteBuffer, Archive archive) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 6) {
            readPackInfo(byteBuffer, archive);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 7) {
            readUnpackInfo(byteBuffer, archive);
            unsignedByte = getUnsignedByte(byteBuffer);
        } else {
            archive.folders = new Folder[0];
        }
        if (unsignedByte == 8) {
            readSubStreamsInfo(byteBuffer, archive);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte != 0) {
            throw new IOException("Badly terminated StreamsInfo");
        }
    }

    private void readPackInfo(ByteBuffer byteBuffer, Archive archive) throws IOException {
        archive.packPos = readUint64(byteBuffer);
        long uint64 = readUint64(byteBuffer);
        assertFitsIntoInt("numPackStreams", uint64);
        int i = (int) uint64;
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 9) {
            archive.packSizes = new long[i];
            for (int i2 = 0; i2 < archive.packSizes.length; i2++) {
                archive.packSizes[i2] = readUint64(byteBuffer);
            }
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 10) {
            archive.packCrcsDefined = readAllOrBits(byteBuffer, i);
            archive.packCrcs = new long[i];
            for (int i3 = 0; i3 < i; i3++) {
                if (archive.packCrcsDefined.get(i3)) {
                    archive.packCrcs[i3] = ((long) byteBuffer.getInt()) & 4294967295L;
                }
            }
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte != 0) {
            throw new IOException("Badly terminated PackInfo (" + unsignedByte + ")");
        }
    }

    private void readUnpackInfo(ByteBuffer byteBuffer, Archive archive) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte != 11) {
            throw new IOException("Expected kFolder, got " + unsignedByte);
        }
        long uint64 = readUint64(byteBuffer);
        assertFitsIntoInt("numFolders", uint64);
        int i = (int) uint64;
        Folder[] folderArr = new Folder[i];
        archive.folders = folderArr;
        if (getUnsignedByte(byteBuffer) != 0) {
            throw new IOException("External unsupported");
        }
        for (int i2 = 0; i2 < i; i2++) {
            folderArr[i2] = readFolder(byteBuffer);
        }
        int unsignedByte2 = getUnsignedByte(byteBuffer);
        if (unsignedByte2 != 12) {
            throw new IOException("Expected kCodersUnpackSize, got " + unsignedByte2);
        }
        for (int i3 = 0; i3 < i; i3++) {
            Folder folder = folderArr[i3];
            assertFitsIntoInt("totalOutputStreams", folder.totalOutputStreams);
            folder.unpackSizes = new long[(int) folder.totalOutputStreams];
            for (int i4 = 0; i4 < folder.totalOutputStreams; i4++) {
                folder.unpackSizes[i4] = readUint64(byteBuffer);
            }
        }
        int unsignedByte3 = getUnsignedByte(byteBuffer);
        if (unsignedByte3 == 10) {
            BitSet allOrBits = readAllOrBits(byteBuffer, i);
            for (int i5 = 0; i5 < i; i5++) {
                if (allOrBits.get(i5)) {
                    folderArr[i5].hasCrc = true;
                    folderArr[i5].crc = ((long) byteBuffer.getInt()) & 4294967295L;
                } else {
                    folderArr[i5].hasCrc = false;
                }
            }
            unsignedByte3 = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte3 != 0) {
            throw new IOException("Badly terminated UnpackInfo");
        }
    }

    private void readSubStreamsInfo(ByteBuffer byteBuffer, Archive archive) throws IOException {
        boolean z;
        Folder[] folderArr = archive.folders;
        int length = folderArr.length;
        int i = 0;
        while (true) {
            z = true;
            if (i >= length) {
                break;
            }
            folderArr[i].numUnpackSubStreams = 1;
            i++;
        }
        int length2 = archive.folders.length;
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 13) {
            int i2 = 0;
            for (Folder folder : archive.folders) {
                long uint64 = readUint64(byteBuffer);
                assertFitsIntoInt("numStreams", uint64);
                folder.numUnpackSubStreams = (int) uint64;
                i2 = (int) (((long) i2) + uint64);
            }
            unsignedByte = getUnsignedByte(byteBuffer);
            length2 = i2;
        }
        SubStreamsInfo subStreamsInfo = new SubStreamsInfo();
        subStreamsInfo.unpackSizes = new long[length2];
        subStreamsInfo.hasCrc = new BitSet(length2);
        subStreamsInfo.crcs = new long[length2];
        int i3 = 0;
        for (Folder folder2 : archive.folders) {
            if (folder2.numUnpackSubStreams != 0) {
                long j = 0;
                if (unsignedByte == 9) {
                    int i4 = 0;
                    while (i4 < folder2.numUnpackSubStreams - 1) {
                        long uint65 = readUint64(byteBuffer);
                        subStreamsInfo.unpackSizes[i3] = uint65;
                        j += uint65;
                        i4++;
                        i3++;
                    }
                }
                subStreamsInfo.unpackSizes[i3] = folder2.getUnpackSize() - j;
                i3++;
            }
        }
        if (unsignedByte == 9) {
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        int i5 = 0;
        for (Folder folder3 : archive.folders) {
            if (folder3.numUnpackSubStreams != 1 || !folder3.hasCrc) {
                i5 += folder3.numUnpackSubStreams;
            }
        }
        if (unsignedByte == 10) {
            BitSet allOrBits = readAllOrBits(byteBuffer, i5);
            long[] jArr = new long[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                if (allOrBits.get(i6)) {
                    jArr[i6] = ((long) byteBuffer.getInt()) & 4294967295L;
                }
            }
            Folder[] folderArr2 = archive.folders;
            int length3 = folderArr2.length;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < length3) {
                Folder folder4 = folderArr2[i7];
                if (folder4.numUnpackSubStreams == z && folder4.hasCrc) {
                    subStreamsInfo.hasCrc.set(i8, z);
                    subStreamsInfo.crcs[i8] = folder4.crc;
                    i8++;
                } else {
                    for (int i10 = 0; i10 < folder4.numUnpackSubStreams; i10++) {
                        subStreamsInfo.hasCrc.set(i8, allOrBits.get(i9));
                        subStreamsInfo.crcs[i8] = jArr[i9];
                        i8++;
                        i9++;
                    }
                }
                i7++;
                z = true;
            }
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte != 0) {
            throw new IOException("Badly terminated SubStreamsInfo");
        }
        archive.subStreamsInfo = subStreamsInfo;
    }

    private Folder readFolder(ByteBuffer byteBuffer) throws IOException {
        int i;
        Folder folder = new Folder();
        long uint64 = readUint64(byteBuffer);
        assertFitsIntoInt("numCoders", uint64);
        int i2 = (int) uint64;
        Coder[] coderArr = new Coder[i2];
        long j = 0;
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            coderArr[i3] = new Coder();
            int unsignedByte = getUnsignedByte(byteBuffer);
            int i4 = unsignedByte & 15;
            boolean z = (unsignedByte & 16) == 0;
            boolean z2 = (unsignedByte & 32) != 0;
            boolean z3 = (unsignedByte & 128) != 0;
            coderArr[i3].decompressionMethodId = new byte[i4];
            byteBuffer.get(coderArr[i3].decompressionMethodId);
            if (z) {
                coderArr[i3].numInStreams = 1L;
                coderArr[i3].numOutStreams = 1L;
            } else {
                coderArr[i3].numInStreams = readUint64(byteBuffer);
                coderArr[i3].numOutStreams = readUint64(byteBuffer);
            }
            j += coderArr[i3].numInStreams;
            j2 += coderArr[i3].numOutStreams;
            if (z2) {
                long uint65 = readUint64(byteBuffer);
                assertFitsIntoInt("propertiesSize", uint65);
                coderArr[i3].properties = new byte[(int) uint65];
                byteBuffer.get(coderArr[i3].properties);
            }
            if (z3) {
                throw new IOException("Alternative methods are unsupported, please report. The reference implementation doesn't support them either.");
            }
        }
        folder.coders = coderArr;
        assertFitsIntoInt("totalInStreams", j);
        folder.totalInputStreams = j;
        assertFitsIntoInt("totalOutStreams", j2);
        folder.totalOutputStreams = j2;
        if (j2 == 0) {
            throw new IOException("Total output streams can't be 0");
        }
        long j3 = j2 - 1;
        assertFitsIntoInt("numBindPairs", j3);
        int i5 = (int) j3;
        BindPair[] bindPairArr = new BindPair[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            BindPair bindPair = new BindPair();
            bindPairArr[i6] = bindPair;
            bindPair.inIndex = readUint64(byteBuffer);
            bindPairArr[i6].outIndex = readUint64(byteBuffer);
        }
        folder.bindPairs = bindPairArr;
        if (j < j3) {
            throw new IOException("Total input streams can't be less than the number of bind pairs");
        }
        long j4 = j - j3;
        assertFitsIntoInt("numPackedStreams", j4);
        int i7 = (int) j4;
        long[] jArr = new long[i7];
        if (j4 == 1) {
            int i8 = 0;
            while (true) {
                i = (int) j;
                if (i8 >= i || folder.findBindPairForInStream(i8) < 0) {
                    break;
                }
                i8++;
            }
            if (i8 == i) {
                throw new IOException("Couldn't find stream's bind pair index");
            }
            jArr[0] = i8;
        } else {
            for (int i9 = 0; i9 < i7; i9++) {
                jArr[i9] = readUint64(byteBuffer);
            }
        }
        folder.packedStreams = jArr;
        return folder;
    }

    private BitSet readAllOrBits(ByteBuffer byteBuffer, int i) throws IOException {
        if (getUnsignedByte(byteBuffer) != 0) {
            BitSet bitSet = new BitSet(i);
            for (int i2 = 0; i2 < i; i2++) {
                bitSet.set(i2, true);
            }
            return bitSet;
        }
        return readBits(byteBuffer, i);
    }

    private BitSet readBits(ByteBuffer byteBuffer, int i) throws IOException {
        BitSet bitSet = new BitSet(i);
        int i2 = 0;
        int unsignedByte = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (i2 == 0) {
                unsignedByte = getUnsignedByte(byteBuffer);
                i2 = 128;
            }
            bitSet.set(i3, (unsignedByte & i2) != 0);
            i2 >>>= 1;
        }
        return bitSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11, types: [int] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15, types: [int] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19, types: [int] */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23, types: [int] */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v8, types: [int] */
    /* JADX WARN: Type inference failed for: r12v10, types: [int] */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v8, types: [int] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.util.BitSet] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.BitSet] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.util.BitSet] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.util.BitSet] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.util.BitSet] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2, types: [int] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [int] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.util.BitSet] */
    private void readFilesInfo(ByteBuffer byteBuffer, Archive archive) throws IOException {
        ?? r12;
        ?? r11;
        long uint64 = readUint64(byteBuffer);
        assertFitsIntoInt("numFiles", uint64);
        int i = (int) uint64;
        SevenZArchiveEntry[] sevenZArchiveEntryArr = new SevenZArchiveEntry[i];
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            sevenZArchiveEntryArr[i2] = new SevenZArchiveEntry();
        }
        ?? bits = 0;
        BitSet bits2 = null;
        BitSet bits3 = null;
        while (true) {
            int unsignedByte = getUnsignedByte(byteBuffer);
            if (unsignedByte != 0) {
                long uint65 = readUint64(byteBuffer);
                switch (unsignedByte) {
                    case 14:
                        bits = readBits(byteBuffer, i);
                        break;
                    case 15:
                        if (bits == 0) {
                            throw new IOException("Header format error: kEmptyStream must appear before kEmptyFile");
                        }
                        bits2 = readBits(byteBuffer, bits.cardinality());
                        break;
                        break;
                    case 16:
                        if (bits == 0) {
                            throw new IOException("Header format error: kEmptyStream must appear before kAnti");
                        }
                        bits3 = readBits(byteBuffer, bits.cardinality());
                        break;
                        break;
                    case 17:
                        if (getUnsignedByte(byteBuffer) != 0) {
                            throw new IOException("Not implemented");
                        }
                        long j = uint65 - 1;
                        if ((1 & j) != 0) {
                            throw new IOException("File names length invalid");
                        }
                        assertFitsIntoInt("file names length", j);
                        int i3 = (int) j;
                        byte[] bArr = new byte[i3];
                        byteBuffer.get(bArr);
                        boolean z2 = z;
                        boolean z3 = z2;
                        int i4 = z3 ? 1 : 0;
                        while (r11 < i3) {
                            if (bArr[r11] == 0 && bArr[r11 + 1] == 0) {
                                r11 = z2;
                                r12 = z3;
                                int i5 = (i4 == true ? 1 : 0) + 1;
                                sevenZArchiveEntryArr[i4 == true ? 1 : 0].setName(new String(bArr, (int) r12, r11 - r12, "UTF-16LE"));
                                r12 = r11 + 2;
                                i4 = i5;
                            } else {
                                r11 = z2;
                                r12 = z3;
                            }
                            r11 += 2;
                            r12 = r12;
                        }
                        if (r12 != i3) {
                            r11 = z2;
                            r12 = z3;
                        } else if (i4 == i) {
                            break;
                        }
                        throw new IOException("Error parsing file names");
                    case 18:
                        ?? allOrBits = readAllOrBits(byteBuffer, i);
                        if (getUnsignedByte(byteBuffer) != 0) {
                            throw new IOException("Unimplemented");
                        }
                        for (?? r10 = z; r10 < i; r10++) {
                            sevenZArchiveEntryArr[r10].setHasCreationDate(allOrBits.get(r10));
                            if (sevenZArchiveEntryArr[r10].getHasCreationDate()) {
                                sevenZArchiveEntryArr[r10].setCreationDate(byteBuffer.getLong());
                            }
                        }
                        break;
                        break;
                    case 19:
                        ?? allOrBits2 = readAllOrBits(byteBuffer, i);
                        if (getUnsignedByte(byteBuffer) != 0) {
                            throw new IOException("Unimplemented");
                        }
                        for (?? r13 = z; r13 < i; r13++) {
                            sevenZArchiveEntryArr[r13].setHasAccessDate(allOrBits2.get(r13));
                            if (sevenZArchiveEntryArr[r13].getHasAccessDate()) {
                                sevenZArchiveEntryArr[r13].setAccessDate(byteBuffer.getLong());
                            }
                        }
                        break;
                        break;
                    case 20:
                        ?? allOrBits3 = readAllOrBits(byteBuffer, i);
                        if (getUnsignedByte(byteBuffer) != 0) {
                            throw new IOException("Unimplemented");
                        }
                        for (?? r14 = z; r14 < i; r14++) {
                            sevenZArchiveEntryArr[r14].setHasLastModifiedDate(allOrBits3.get(r14));
                            if (sevenZArchiveEntryArr[r14].getHasLastModifiedDate()) {
                                sevenZArchiveEntryArr[r14].setLastModifiedDate(byteBuffer.getLong());
                            }
                        }
                        break;
                        break;
                    case 21:
                        ?? allOrBits4 = readAllOrBits(byteBuffer, i);
                        if (getUnsignedByte(byteBuffer) != 0) {
                            throw new IOException("Unimplemented");
                        }
                        for (?? r15 = z; r15 < i; r15++) {
                            sevenZArchiveEntryArr[r15].setHasWindowsAttributes(allOrBits4.get(r15));
                            if (sevenZArchiveEntryArr[r15].getHasWindowsAttributes()) {
                                sevenZArchiveEntryArr[r15].setWindowsAttributes(byteBuffer.getInt());
                            }
                        }
                        break;
                        break;
                    case 22:
                    case 23:
                    default:
                        if (skipBytesFully(byteBuffer, uint65) < uint65) {
                            throw new IOException("Incomplete property of type " + unsignedByte);
                        }
                        break;
                        break;
                    case 24:
                        throw new IOException("kStartPos is unsupported, please report");
                    case 25:
                        if (skipBytesFully(byteBuffer, uint65) < uint65) {
                            throw new IOException("Incomplete kDummy property");
                        }
                        break;
                        break;
                }
                z = false;
                bits = bits;
            } else {
                boolean z4 = z;
                boolean z5 = z4;
                int i6 = z5 ? 1 : 0;
                ?? r1 = z4;
                ?? r9 = z5;
                while (r1 < i) {
                    sevenZArchiveEntryArr[r1].setHasStream((bits == 0 || !bits.get(r1)) ? true : z);
                    if (sevenZArchiveEntryArr[r1].hasStream()) {
                        sevenZArchiveEntryArr[r1].setDirectory(z);
                        sevenZArchiveEntryArr[r1].setAntiItem(z);
                        sevenZArchiveEntryArr[r1].setHasCrc(archive.subStreamsInfo.hasCrc.get(r9));
                        sevenZArchiveEntryArr[r1].setCrcValue(archive.subStreamsInfo.crcs[r9]);
                        sevenZArchiveEntryArr[r1].setSize(archive.subStreamsInfo.unpackSizes[r9]);
                        r9++;
                    } else {
                        sevenZArchiveEntryArr[r1].setDirectory((bits2 == null || !bits2.get(i6)) ? true : z);
                        sevenZArchiveEntryArr[r1].setAntiItem((bits3 == null || !bits3.get(i6)) ? z : true);
                        sevenZArchiveEntryArr[r1].setHasCrc(z);
                        sevenZArchiveEntryArr[r1].setSize(0L);
                        i6++;
                    }
                    r1++;
                    r9 = r9;
                }
                archive.files = sevenZArchiveEntryArr;
                calculateStreamMap(archive);
                return;
            }
        }
    }

    private void calculateStreamMap(Archive archive) throws IOException {
        StreamMap streamMap = new StreamMap();
        int length = archive.folders != null ? archive.folders.length : 0;
        streamMap.folderFirstPackStreamIndex = new int[length];
        int length2 = 0;
        for (int i = 0; i < length; i++) {
            streamMap.folderFirstPackStreamIndex[i] = length2;
            length2 += archive.folders[i].packedStreams.length;
        }
        int length3 = archive.packSizes != null ? archive.packSizes.length : 0;
        streamMap.packStreamOffsets = new long[length3];
        long j = 0;
        for (int i2 = 0; i2 < length3; i2++) {
            streamMap.packStreamOffsets[i2] = j;
            j += archive.packSizes[i2];
        }
        streamMap.folderFirstFileIndex = new int[length];
        streamMap.fileFolderIndex = new int[archive.files.length];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < archive.files.length; i5++) {
            if (!archive.files[i5].hasStream() && i3 == 0) {
                streamMap.fileFolderIndex[i5] = -1;
            } else {
                if (i3 == 0) {
                    while (i4 < archive.folders.length) {
                        streamMap.folderFirstFileIndex[i4] = i5;
                        if (archive.folders[i4].numUnpackSubStreams > 0) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (i4 >= archive.folders.length) {
                        throw new IOException("Too few folders in archive");
                    }
                }
                streamMap.fileFolderIndex[i5] = i4;
                if (archive.files[i5].hasStream() && (i3 = i3 + 1) >= archive.folders[i4].numUnpackSubStreams) {
                    i4++;
                    i3 = 0;
                }
            }
        }
        archive.streamMap = streamMap;
    }

    private void buildDecodingStream() throws IOException {
        int i = this.archive.streamMap.fileFolderIndex[this.currentEntryIndex];
        if (i < 0) {
            this.deferredBlockStreams.clear();
            return;
        }
        SevenZArchiveEntry sevenZArchiveEntry = this.archive.files[this.currentEntryIndex];
        if (this.currentFolderIndex == i) {
            sevenZArchiveEntry.setContentMethods(this.archive.files[this.currentEntryIndex - 1].getContentMethods());
        } else {
            this.currentFolderIndex = i;
            this.deferredBlockStreams.clear();
            InputStream inputStream = this.currentFolderInputStream;
            if (inputStream != null) {
                inputStream.close();
                this.currentFolderInputStream = null;
            }
            Folder folder = this.archive.folders[i];
            int i2 = this.archive.streamMap.folderFirstPackStreamIndex[i];
            this.currentFolderInputStream = buildDecoderStack(folder, this.archive.streamMap.packStreamOffsets[i2] + this.archive.packPos + 32, i2, sevenZArchiveEntry);
        }
        InputStream boundedInputStream = new BoundedInputStream(this.currentFolderInputStream, sevenZArchiveEntry.getSize());
        if (sevenZArchiveEntry.getHasCrc()) {
            boundedInputStream = new CRC32VerifyingInputStream(boundedInputStream, sevenZArchiveEntry.getSize(), sevenZArchiveEntry.getCrcValue());
        }
        this.deferredBlockStreams.add(boundedInputStream);
    }

    private InputStream buildDecoderStack(Folder folder, long j, int i, SevenZArchiveEntry sevenZArchiveEntry) throws IOException {
        this.channel.position(j);
        FilterInputStream filterInputStream = new FilterInputStream(new BufferedInputStream(new BoundedSeekableByteChannelInputStream(this.channel, this.archive.packSizes[i]))) { // from class: org.apache.commons.compress.archivers.sevenz.SevenZFile.1
            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                int i2 = this.in.read();
                if (i2 >= 0) {
                    count(1);
                }
                return i2;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr) throws IOException {
                return read(bArr, 0, bArr.length);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) throws IOException {
                int i4 = this.in.read(bArr, i2, i3);
                if (i4 >= 0) {
                    count(i4);
                }
                return i4;
            }

            private void count(int i2) {
                SevenZFile.this.compressedBytesReadFromCurrentEntry += (long) i2;
            }
        };
        LinkedList linkedList = new LinkedList();
        InputStream inputStreamAddDecoder = filterInputStream;
        for (Coder coder : folder.getOrderedCoders()) {
            if (coder.numInStreams != 1 || coder.numOutStreams != 1) {
                throw new IOException("Multi input/output stream coders are not yet supported");
            }
            SevenZMethod sevenZMethodById = SevenZMethod.byId(coder.decompressionMethodId);
            inputStreamAddDecoder = Coders.addDecoder(this.fileName, inputStreamAddDecoder, folder.getUnpackSizeForCoder(coder), coder, this.password, this.options.getMaxMemoryLimitInKb());
            linkedList.addFirst(new SevenZMethodConfiguration(sevenZMethodById, Coders.findByMethod(sevenZMethodById).getOptionsFromCoder(coder, inputStreamAddDecoder)));
        }
        sevenZArchiveEntry.setContentMethods(linkedList);
        return folder.hasCrc ? new CRC32VerifyingInputStream(inputStreamAddDecoder, folder.getUnpackSize(), folder.crc) : inputStreamAddDecoder;
    }

    public int read() throws IOException {
        int i = getCurrentStream().read();
        if (i >= 0) {
            this.uncompressedBytesReadFromCurrentEntry++;
        }
        return i;
    }

    private InputStream getCurrentStream() throws IOException {
        if (this.archive.files[this.currentEntryIndex].getSize() == 0) {
            return new ByteArrayInputStream(new byte[0]);
        }
        if (this.deferredBlockStreams.isEmpty()) {
            throw new IllegalStateException("No current 7z entry (call getNextEntry() first).");
        }
        while (this.deferredBlockStreams.size() > 1) {
            InputStream inputStreamRemove = this.deferredBlockStreams.remove(0);
            try {
                IOUtils.skip(inputStreamRemove, LongCompanionObject.MAX_VALUE);
                if (inputStreamRemove != null) {
                    inputStreamRemove.close();
                }
                this.compressedBytesReadFromCurrentEntry = 0L;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (inputStreamRemove != null) {
                        try {
                            inputStreamRemove.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        return this.deferredBlockStreams.get(0);
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = getCurrentStream().read(bArr, i, i2);
        if (i3 > 0) {
            this.uncompressedBytesReadFromCurrentEntry += (long) i3;
        }
        return i3;
    }

    public InputStreamStatistics getStatisticsForCurrentEntry() {
        return new InputStreamStatistics() { // from class: org.apache.commons.compress.archivers.sevenz.SevenZFile.2
            @Override // org.apache.commons.compress.utils.InputStreamStatistics
            public long getCompressedCount() {
                return SevenZFile.this.compressedBytesReadFromCurrentEntry;
            }

            @Override // org.apache.commons.compress.utils.InputStreamStatistics
            public long getUncompressedCount() {
                return SevenZFile.this.uncompressedBytesReadFromCurrentEntry;
            }
        };
    }

    private static long readUint64(ByteBuffer byteBuffer) throws IOException {
        long unsignedByte = getUnsignedByte(byteBuffer);
        int i = 128;
        long unsignedByte2 = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            if ((((long) i) & unsignedByte) == 0) {
                return ((unsignedByte & ((long) (i - 1))) << (i2 * 8)) | unsignedByte2;
            }
            unsignedByte2 |= ((long) getUnsignedByte(byteBuffer)) << (i2 * 8);
            i >>>= 1;
        }
        return unsignedByte2;
    }

    private static int getUnsignedByte(ByteBuffer byteBuffer) {
        return byteBuffer.get() & UByte.MAX_VALUE;
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i < sevenZSignature.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = sevenZSignature;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private static long skipBytesFully(ByteBuffer byteBuffer, long j) throws IOException {
        if (j < 1) {
            return 0L;
        }
        int iPosition = byteBuffer.position();
        long jRemaining = byteBuffer.remaining();
        if (jRemaining < j) {
            j = jRemaining;
        }
        byteBuffer.position(iPosition + ((int) j));
        return j;
    }

    private void readFully(ByteBuffer byteBuffer) throws IOException {
        byteBuffer.rewind();
        IOUtils.readFully(this.channel, byteBuffer);
        byteBuffer.flip();
    }

    public String toString() {
        return this.archive.toString();
    }

    public String getDefaultName() {
        if (DEFAULT_FILE_NAME.equals(this.fileName) || this.fileName == null) {
            return null;
        }
        String name = new File(this.fileName).getName();
        int iLastIndexOf = name.lastIndexOf(".");
        if (iLastIndexOf > 0) {
            return name.substring(0, iLastIndexOf);
        }
        return name + "~";
    }

    private static byte[] utf16Decode(char[] cArr) throws IOException {
        if (cArr == null) {
            return null;
        }
        ByteBuffer byteBufferEncode = PASSWORD_ENCODER.encode(CharBuffer.wrap(cArr));
        if (byteBufferEncode.hasArray()) {
            return byteBufferEncode.array();
        }
        byte[] bArr = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    private static void assertFitsIntoInt(String str, long j) throws IOException {
        if (j > 2147483647L) {
            throw new IOException("Cannot handle " + str + j);
        }
    }
}
