package org.apache.commons.compress.compressors.snappy;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.KotlinVersion;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SnappyCompressorOutputStream extends CompressorOutputStream {
    private static final int FOUR_BYTE_COPY_TAG = 3;
    private static final int FOUR_SIZE_BYTE_MARKER = 252;
    private static final int MAX_LITERAL_SIZE_WITHOUT_SIZE_BYTES = 60;
    private static final int MAX_LITERAL_SIZE_WITH_ONE_SIZE_BYTE = 256;
    private static final int MAX_LITERAL_SIZE_WITH_THREE_SIZE_BYTES = 16777216;
    private static final int MAX_LITERAL_SIZE_WITH_TWO_SIZE_BYTES = 65536;
    private static final int MAX_MATCH_LENGTH = 64;
    private static final int MAX_MATCH_LENGTH_WITH_ONE_OFFSET_BYTE = 11;
    private static final int MAX_OFFSET_WITH_ONE_OFFSET_BYTE = 1024;
    private static final int MAX_OFFSET_WITH_TWO_OFFSET_BYTES = 32768;
    private static final int MIN_MATCH_LENGTH = 4;
    private static final int MIN_MATCH_LENGTH_WITH_ONE_OFFSET_BYTE = 4;
    private static final int ONE_BYTE_COPY_TAG = 1;
    private static final int ONE_SIZE_BYTE_MARKER = 240;
    private static final int THREE_SIZE_BYTE_MARKER = 248;
    private static final int TWO_BYTE_COPY_TAG = 2;
    private static final int TWO_SIZE_BYTE_MARKER = 244;
    private final LZ77Compressor compressor;
    private final ByteUtils.ByteConsumer consumer;
    private boolean finished;
    private final byte[] oneByte;
    private final OutputStream os;

    public SnappyCompressorOutputStream(OutputStream outputStream, long j) throws IOException {
        this(outputStream, j, 32768);
    }

    public SnappyCompressorOutputStream(OutputStream outputStream, long j, int i) throws IOException {
        this(outputStream, j, createParameterBuilder(i).build());
    }

    public SnappyCompressorOutputStream(OutputStream outputStream, long j, Parameters parameters) throws IOException {
        this.oneByte = new byte[1];
        this.finished = false;
        this.os = outputStream;
        this.consumer = new ByteUtils.OutputStreamByteConsumer(outputStream);
        this.compressor = new LZ77Compressor(parameters, new LZ77Compressor.Callback() { // from class: org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream.1
            @Override // org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Callback
            public void accept(LZ77Compressor.Block block) throws IOException {
                int i = AnonymousClass2.$SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[block.getType().ordinal()];
                if (i == 1) {
                    SnappyCompressorOutputStream.this.writeLiteralBlock((LZ77Compressor.LiteralBlock) block);
                } else {
                    if (i != 2) {
                        return;
                    }
                    SnappyCompressorOutputStream.this.writeBackReference((LZ77Compressor.BackReference) block);
                }
            }
        });
        writeUncompressedSize(j);
    }

    /* JADX INFO: renamed from: org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType;

        static {
            int[] iArr = new int[LZ77Compressor.Block.BlockType.values().length];
            $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType = iArr;
            try {
                iArr[LZ77Compressor.Block.BlockType.LITERAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[LZ77Compressor.Block.BlockType.BACK_REFERENCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[LZ77Compressor.Block.BlockType.EOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i & KotlinVersion.MAX_COMPONENT_VALUE);
        write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.compressor.compress(bArr, i, i2);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            finish();
        } finally {
            this.os.close();
        }
    }

    public void finish() throws IOException {
        if (this.finished) {
            return;
        }
        this.compressor.finish();
        this.finished = true;
    }

    private void writeUncompressedSize(long j) throws IOException {
        boolean z;
        do {
            int i = (int) (127 & j);
            z = j > ((long) i);
            if (z) {
                i |= 128;
            }
            this.os.write(i);
            j >>= 7;
        } while (z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeLiteralBlock(LZ77Compressor.LiteralBlock literalBlock) throws IOException {
        int length = literalBlock.getLength();
        if (length <= 60) {
            writeLiteralBlockNoSizeBytes(literalBlock, length);
            return;
        }
        if (length <= 256) {
            writeLiteralBlockOneSizeByte(literalBlock, length);
            return;
        }
        if (length <= MAX_LITERAL_SIZE_WITH_TWO_SIZE_BYTES) {
            writeLiteralBlockTwoSizeBytes(literalBlock, length);
        } else if (length <= 16777216) {
            writeLiteralBlockThreeSizeBytes(literalBlock, length);
        } else {
            writeLiteralBlockFourSizeBytes(literalBlock, length);
        }
    }

    private void writeLiteralBlockNoSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i) throws IOException {
        writeLiteralBlockWithSize((i - 1) << 2, 0, i, literalBlock);
    }

    private void writeLiteralBlockOneSizeByte(LZ77Compressor.LiteralBlock literalBlock, int i) throws IOException {
        writeLiteralBlockWithSize(ONE_SIZE_BYTE_MARKER, 1, i, literalBlock);
    }

    private void writeLiteralBlockTwoSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i) throws IOException {
        writeLiteralBlockWithSize(TWO_SIZE_BYTE_MARKER, 2, i, literalBlock);
    }

    private void writeLiteralBlockThreeSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i) throws IOException {
        writeLiteralBlockWithSize(THREE_SIZE_BYTE_MARKER, 3, i, literalBlock);
    }

    private void writeLiteralBlockFourSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i) throws IOException {
        writeLiteralBlockWithSize(FOUR_SIZE_BYTE_MARKER, 4, i, literalBlock);
    }

    private void writeLiteralBlockWithSize(int i, int i2, int i3, LZ77Compressor.LiteralBlock literalBlock) throws IOException {
        this.os.write(i);
        writeLittleEndian(i2, i3 - 1);
        this.os.write(literalBlock.getData(), literalBlock.getOffset(), i3);
    }

    private void writeLittleEndian(int i, int i2) throws IOException {
        ByteUtils.toLittleEndian(this.consumer, i2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeBackReference(LZ77Compressor.BackReference backReference) throws IOException {
        int length = backReference.getLength();
        int offset = backReference.getOffset();
        if (length >= 4 && length <= 11 && offset <= 1024) {
            writeBackReferenceWithOneOffsetByte(length, offset);
        } else if (offset < 32768) {
            writeBackReferenceWithTwoOffsetBytes(length, offset);
        } else {
            writeBackReferenceWithFourOffsetBytes(length, offset);
        }
    }

    private void writeBackReferenceWithOneOffsetByte(int i, int i2) throws IOException {
        this.os.write(((i - 4) << 2) | 1 | ((i2 & 1792) >> 3));
        this.os.write(i2 & KotlinVersion.MAX_COMPONENT_VALUE);
    }

    private void writeBackReferenceWithTwoOffsetBytes(int i, int i2) throws IOException {
        writeBackReferenceWithLittleEndianOffset(2, 2, i, i2);
    }

    private void writeBackReferenceWithFourOffsetBytes(int i, int i2) throws IOException {
        writeBackReferenceWithLittleEndianOffset(3, 4, i, i2);
    }

    private void writeBackReferenceWithLittleEndianOffset(int i, int i2, int i3, int i4) throws IOException {
        this.os.write(i | ((i3 - 1) << 2));
        writeLittleEndian(i2, i4);
    }

    public static Parameters.Builder createParameterBuilder(int i) {
        return Parameters.builder(i).withMinBackReferenceLength(4).withMaxBackReferenceLength(64).withMaxOffset(i).withMaxLiteralLength(i);
    }
}
