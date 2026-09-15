package com.zaxxer.sparsebits;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SparseBitSet implements Cloneable, Serializable {
    protected static final int INDEX_SIZE = 31;
    protected static final int LENGTH2 = 32;
    protected static final int LENGTH3 = 32;
    protected static final int LENGTH4 = 64;
    protected static final int LEVEL1 = 15;
    protected static final int LEVEL2 = 5;
    protected static final int LEVEL3 = 5;
    protected static final int LEVEL4 = 6;
    protected static final int MASK2 = 31;
    protected static final int MASK3 = 31;
    protected static final int MAX_LENGTH1 = 32768;
    protected static final int SHIFT1 = 10;
    protected static final int SHIFT2 = 5;
    protected static final int SHIFT3 = 6;
    protected static final int UNIT = 65536;
    static int compactionCountDefault = 2;
    private static final long serialVersionUID = -6663013367427929992L;
    protected transient long[][][] bits;
    protected transient int bitsLength;
    protected transient Cache cache;
    protected transient int compactionCount;
    protected transient EqualsStrategy equalsStrategy;
    protected transient long[] spare;
    protected transient UpdateStrategy updateStrategy;
    static final long[] ZERO_BLOCK = new long[32];
    protected static final transient AndStrategy andStrategy = new AndStrategy();
    protected static final transient AndNotStrategy andNotStrategy = new AndNotStrategy();
    protected static final transient ClearStrategy clearStrategy = new ClearStrategy();
    protected static final transient CopyStrategy copyStrategy = new CopyStrategy();
    protected static final transient FlipStrategy flipStrategy = new FlipStrategy();
    protected static transient IntersectsStrategy intersectsStrategy = new IntersectsStrategy();
    protected static final transient OrStrategy orStrategy = new OrStrategy();
    protected static final transient SetStrategy setStrategy = new SetStrategy();
    protected static final transient XorStrategy xorStrategy = new XorStrategy();

    public enum Statistics {
        Size,
        Length,
        Cardinality,
        Total_words,
        Set_array_length,
        Set_array_max_length,
        Level2_areas,
        Level2_area_length,
        Level3_blocks,
        Level3_block_length,
        Compaction_count_value
    }

    protected SparseBitSet(int i, int i2) throws NegativeArraySizeException {
        if (i < 0) {
            throw new NegativeArraySizeException("(requested capacity=" + i + ") < 0");
        }
        resize(i - 1);
        this.compactionCount = i2;
        constructorHelper();
        statisticsUpdate();
    }

    public SparseBitSet() {
        this(1, compactionCountDefault);
    }

    public SparseBitSet(int i) throws NegativeArraySizeException {
        this(i, compactionCountDefault);
    }

    public void and(int i, boolean z) throws IndexOutOfBoundsException {
        if (i + 1 < 1) {
            throw new IndexOutOfBoundsException("i=" + i);
        }
        if (z) {
            return;
        }
        clear(i);
    }

    public void and(int i, int i2, SparseBitSet sparseBitSet) throws IndexOutOfBoundsException {
        setScanner(i, i2, sparseBitSet, andStrategy);
    }

    public void and(SparseBitSet sparseBitSet) {
        nullify(Math.min(this.bits.length, sparseBitSet.bits.length));
        setScanner(0, Math.min(this.bitsLength, sparseBitSet.bitsLength), sparseBitSet, andStrategy);
    }

    public static SparseBitSet and(SparseBitSet sparseBitSet, SparseBitSet sparseBitSet2) {
        SparseBitSet sparseBitSetM12clone = sparseBitSet.m12clone();
        sparseBitSetM12clone.and(sparseBitSet2);
        return sparseBitSetM12clone;
    }

    public void andNot(int i, boolean z) {
        if (i + 1 < 1) {
            throw new IndexOutOfBoundsException("i=" + i);
        }
        if (z) {
            clear(i);
        }
    }

    public void andNot(int i, int i2, SparseBitSet sparseBitSet) throws IndexOutOfBoundsException {
        setScanner(i, i2, sparseBitSet, andNotStrategy);
    }

    public void andNot(SparseBitSet sparseBitSet) {
        setScanner(0, Math.min(this.bitsLength, sparseBitSet.bitsLength), sparseBitSet, andNotStrategy);
    }

    public static SparseBitSet andNot(SparseBitSet sparseBitSet, SparseBitSet sparseBitSet2) {
        SparseBitSet sparseBitSetM12clone = sparseBitSet.m12clone();
        sparseBitSetM12clone.andNot(sparseBitSet2);
        return sparseBitSetM12clone;
    }

    public int cardinality() {
        statisticsUpdate();
        return this.cache.cardinality;
    }

    public void clear(int i) {
        long[] jArr;
        if (i + 1 < 1) {
            throw new IndexOutOfBoundsException("i=" + i);
        }
        if (i >= this.bitsLength) {
            return;
        }
        int i2 = i >> 6;
        long[][] jArr2 = this.bits[i >> 16];
        if (jArr2 == null || (jArr = jArr2[(i >> 11) & 31]) == null) {
            return;
        }
        int i3 = i2 & 31;
        jArr[i3] = jArr[i3] & (~(1 << i));
        this.cache.hash = 0;
    }

    public void clear(int i, int i2) throws IndexOutOfBoundsException {
        setScanner(i, i2, null, clearStrategy);
    }

    public void clear() {
        nullify(0);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SparseBitSet m12clone() {
        try {
            SparseBitSet sparseBitSet = (SparseBitSet) super.clone();
            sparseBitSet.bits = null;
            sparseBitSet.resize(1);
            sparseBitSet.constructorHelper();
            sparseBitSet.equalsStrategy = null;
            sparseBitSet.setScanner(0, this.bitsLength, this, copyStrategy);
            return sparseBitSet;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.getMessage());
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SparseBitSet)) {
            return false;
        }
        SparseBitSet sparseBitSet = (SparseBitSet) obj;
        if (this == sparseBitSet) {
            return true;
        }
        if (this.equalsStrategy == null) {
            this.equalsStrategy = new EqualsStrategy();
        }
        setScanner(0, Math.max(this.bitsLength, sparseBitSet.bitsLength), sparseBitSet, this.equalsStrategy);
        return this.equalsStrategy.result;
    }

    public void flip(int i) {
        if (i + 1 < 1) {
            throw new IndexOutOfBoundsException("i=" + i);
        }
        int i2 = i >> 6;
        int i3 = i >> 16;
        int i4 = (i >> 11) & 31;
        if (i >= this.bitsLength) {
            resize(i);
        }
        long[][][] jArr = this.bits;
        long[][] jArr2 = jArr[i3];
        if (jArr2 == null) {
            jArr2 = new long[32][];
            jArr[i3] = jArr2;
        }
        long[] jArr3 = jArr2[i4];
        if (jArr3 == null) {
            jArr3 = new long[32];
            jArr2[i4] = jArr3;
        }
        int i5 = i2 & 31;
        jArr3[i5] = jArr3[i5] ^ (1 << i);
        this.cache.hash = 0;
    }

    public void flip(int i, int i2) throws IndexOutOfBoundsException {
        setScanner(i, i2, null, flipStrategy);
    }

    public boolean get(int i) {
        long[][] jArr;
        long[] jArr2;
        if (i + 1 >= 1) {
            return (i >= this.bitsLength || (jArr = this.bits[i >> 16]) == null || (jArr2 = jArr[(i >> 11) & 31]) == null || (jArr2[(i >> 6) & 31] & (1 << i)) == 0) ? false : true;
        }
        throw new IndexOutOfBoundsException("i=" + i);
    }

    public SparseBitSet get(int i, int i2) throws IndexOutOfBoundsException {
        SparseBitSet sparseBitSet = new SparseBitSet(i2, this.compactionCount);
        sparseBitSet.setScanner(i, i2, this, copyStrategy);
        return sparseBitSet;
    }

    public int hashCode() {
        statisticsUpdate();
        return this.cache.hash;
    }

    public boolean intersects(int i, int i2, SparseBitSet sparseBitSet) throws IndexOutOfBoundsException {
        setScanner(i, i2, sparseBitSet, intersectsStrategy);
        return intersectsStrategy.result;
    }

    public boolean intersects(SparseBitSet sparseBitSet) {
        setScanner(0, Math.max(this.bitsLength, sparseBitSet.bitsLength), sparseBitSet, intersectsStrategy);
        return intersectsStrategy.result;
    }

    public boolean isEmpty() {
        statisticsUpdate();
        return this.cache.cardinality == 0;
    }

    public int length() {
        statisticsUpdate();
        return this.cache.length;
    }

    public int nextClearBit(int i) {
        long[][] jArr;
        long[] jArr2;
        if (i < 0) {
            throw new IndexOutOfBoundsException("i=" + i);
        }
        int i2 = i >> 6;
        int i3 = i2 & 31;
        int i4 = (i >> 11) & 31;
        int i5 = i >> 16;
        long j = -1;
        long j2 = (-1) << i;
        long[][][] jArr3 = this.bits;
        int length = jArr3.length;
        if (i5 < length && (jArr = jArr3[i5]) != null && (jArr2 = jArr[i4]) != null) {
            j2 &= ~jArr2[i3];
            if (j2 == 0) {
                int i6 = i2 + 1;
                i5 = i6 >> 10;
                i4 = (i6 >> 5) & 31;
                i3 = i6 & 31;
                loop0: while (i5 != length) {
                    long[][] jArr4 = this.bits[i5];
                    if (jArr4 == null) {
                        break;
                    }
                    while (i4 != 32) {
                        long[] jArr5 = jArr4[i4];
                        if (jArr5 == null) {
                            break loop0;
                        }
                        while (i3 != 32) {
                            j = ~jArr5[i3];
                            if (j != 0) {
                                break loop0;
                            }
                            i3++;
                        }
                        i4++;
                        i3 = 0;
                    }
                    i5++;
                    i3 = 0;
                    i4 = 0;
                }
                j2 = j;
            }
        }
        int iNumberOfTrailingZeros = ((((i5 << 10) + (i4 << 5)) + i3) << 6) + Long.numberOfTrailingZeros(j2);
        if (iNumberOfTrailingZeros == Integer.MAX_VALUE) {
            return -1;
        }
        return iNumberOfTrailingZeros;
    }

    public int nextSetBit(int i) {
        long j;
        long[] jArr;
        if (i < 0) {
            throw new IndexOutOfBoundsException("i=" + i);
        }
        int i2 = i >> 6;
        int i3 = i2 & 31;
        int i4 = (i >> 11) & 31;
        int i5 = i >> 16;
        long[][][] jArr2 = this.bits;
        int length = jArr2.length;
        long j2 = 0;
        if (i5 < length) {
            long[][] jArr3 = jArr2[i5];
            if (jArr3 == null || (jArr = jArr3[i4]) == null) {
                j = 0;
            } else {
                j = jArr[i3] & ((-1) << i);
                if (j == 0) {
                }
                j2 = j;
            }
            int i6 = i2 + 1;
            i5 = i6 >> 10;
            i4 = (i6 >> 5) & 31;
            i3 = i6 & 31;
            loop0: while (i5 != length) {
                long[][] jArr4 = this.bits[i5];
                if (jArr4 != null) {
                    while (i4 != 32) {
                        long[] jArr5 = jArr4[i4];
                        if (jArr5 != null) {
                            while (i3 != 32) {
                                j = jArr5[i3];
                                if (j != 0) {
                                    break loop0;
                                }
                                i3++;
                            }
                        }
                        i4++;
                        i3 = 0;
                    }
                }
                i5++;
                i3 = 0;
                i4 = 0;
            }
            j2 = j;
        }
        if (i5 >= length) {
            return -1;
        }
        return ((((i5 << 10) + (i4 << 5)) + i3) << 6) + Long.numberOfTrailingZeros(j2);
    }

    public int previousClearBit(int i) {
        if (i < 0) {
            if (i == -1) {
                return -1;
            }
            throw new IndexOutOfBoundsException("i=" + i);
        }
        long[][][] jArr = this.bits;
        int i2 = (i >> 6) & 31;
        int i3 = (i >> 11) & 31;
        int i4 = i >> 16;
        int length = jArr.length - 1;
        if (i4 > length) {
            return i;
        }
        int iMin = Math.min(i4, length);
        int i5 = i % 64;
        int i6 = iMin;
        int i7 = i2;
        int i8 = i3;
        while (i6 >= 0) {
            long[][] jArr2 = jArr[i6];
            if (jArr2 == null) {
                int i9 = (((i6 << 10) + (i8 << 5)) + i7) << 6;
                if (iMin != i6) {
                    i5 = 63;
                }
                return i9 + i5;
            }
            while (i8 >= 0) {
                long[] jArr3 = jArr2[i8];
                if (jArr3 == null) {
                    int i10 = (((i6 << 10) + (i8 << 5)) + i7) << 6;
                    if (i3 != i8) {
                        i5 = 63;
                    }
                    return i10 + i5;
                }
                while (i7 >= 0) {
                    long j = jArr3[i7];
                    if (j == 0) {
                        int i11 = (((i6 << 10) + (i8 << 5)) + i7) << 6;
                        if (i2 != i7) {
                            i5 = 63;
                        }
                        return i11 + i5;
                    }
                    for (int i12 = i5; i12 >= 0; i12--) {
                        if ((j & (1 << i12)) == 0) {
                            return ((((i6 << 10) + (i8 << 5)) + i7) << 6) + i12;
                        }
                    }
                    i7--;
                }
                i8--;
                i7 = 31;
            }
            i6--;
            i8 = 31;
            i7 = 31;
        }
        return -1;
    }

    public int previousSetBit(int i) {
        int i2;
        int i3;
        int i4;
        if (i < 0) {
            if (i == -1) {
                return -1;
            }
            throw new IndexOutOfBoundsException("i=" + i);
        }
        long[][][] jArr = this.bits;
        int i5 = i >> 6;
        int i6 = i >> 16;
        boolean z = true;
        int length = jArr.length - 1;
        if (i6 > length) {
            i6 = length;
            i4 = 63;
            i2 = 31;
            i3 = 31;
        } else {
            i2 = (i >> 11) & 31;
            i3 = i5 & 31;
            i4 = i % 64;
        }
        while (i6 >= 0) {
            long[][] jArr2 = jArr[i6];
            if (jArr2 != null) {
                while (i2 >= 0) {
                    long[] jArr3 = jArr2[i2];
                    if (jArr3 != null) {
                        while (i3 >= 0) {
                            long j = jArr3[i3];
                            if (j != 0) {
                                for (int i7 = z ? i4 : 63; i7 >= 0; i7--) {
                                    if ((j & (1 << i7)) != 0) {
                                        return ((((i6 << 10) + (i2 << 5)) + i3) << 6) + i7;
                                    }
                                }
                            }
                            i3--;
                            z = false;
                        }
                    }
                    i2--;
                    i3 = 31;
                    z = false;
                }
            }
            i6--;
            i2 = 31;
            i3 = 31;
            z = false;
        }
        return -1;
    }

    public void or(int i, boolean z) {
        if (i + 1 < 1) {
            throw new IndexOutOfBoundsException("i=" + i);
        }
        if (z) {
            set(i);
        }
    }

    public void or(int i, int i2, SparseBitSet sparseBitSet) throws IndexOutOfBoundsException {
        setScanner(i, i2, sparseBitSet, orStrategy);
    }

    public void or(SparseBitSet sparseBitSet) {
        setScanner(0, sparseBitSet.bitsLength, sparseBitSet, orStrategy);
    }

    public static SparseBitSet or(SparseBitSet sparseBitSet, SparseBitSet sparseBitSet2) {
        SparseBitSet sparseBitSetM12clone = sparseBitSet.m12clone();
        sparseBitSetM12clone.or(sparseBitSet2);
        return sparseBitSetM12clone;
    }

    public void set(int i) {
        if (i + 1 < 1) {
            throw new IndexOutOfBoundsException("i=" + i);
        }
        int i2 = i >> 6;
        int i3 = i >> 16;
        int i4 = (i >> 11) & 31;
        if (i >= this.bitsLength) {
            resize(i);
        }
        long[][][] jArr = this.bits;
        long[][] jArr2 = jArr[i3];
        if (jArr2 == null) {
            jArr2 = new long[32][];
            jArr[i3] = jArr2;
        }
        long[] jArr3 = jArr2[i4];
        if (jArr3 == null) {
            jArr3 = new long[32];
            jArr2[i4] = jArr3;
        }
        int i5 = i2 & 31;
        jArr3[i5] = jArr3[i5] | (1 << i);
        this.cache.hash = 0;
    }

    public void set(int i, boolean z) {
        if (z) {
            set(i);
        } else {
            clear(i);
        }
    }

    public void set(int i, int i2) throws IndexOutOfBoundsException {
        setScanner(i, i2, null, setStrategy);
    }

    public void set(int i, int i2, boolean z) {
        if (z) {
            set(i, i2);
        } else {
            clear(i, i2);
        }
    }

    public int size() {
        statisticsUpdate();
        return this.cache.size;
    }

    public String statistics() {
        return statistics(null);
    }

    public String statistics(String[] strArr) {
        statisticsUpdate();
        int length = Statistics.values().length;
        String[] strArr2 = new String[length];
        strArr2[Statistics.Size.ordinal()] = Integer.toString(size());
        strArr2[Statistics.Length.ordinal()] = Integer.toString(length());
        strArr2[Statistics.Cardinality.ordinal()] = Integer.toString(cardinality());
        strArr2[Statistics.Total_words.ordinal()] = Integer.toString(this.cache.count);
        strArr2[Statistics.Set_array_length.ordinal()] = Integer.toString(this.bits.length);
        strArr2[Statistics.Set_array_max_length.ordinal()] = Integer.toString(32768);
        strArr2[Statistics.Level2_areas.ordinal()] = Integer.toString(this.cache.a2Count);
        strArr2[Statistics.Level2_area_length.ordinal()] = Integer.toString(32);
        strArr2[Statistics.Level3_blocks.ordinal()] = Integer.toString(this.cache.a3Count);
        strArr2[Statistics.Level3_block_length.ordinal()] = Integer.toString(32);
        strArr2[Statistics.Compaction_count_value.ordinal()] = Integer.toString(this.compactionCount);
        int iMax = 0;
        for (Statistics statistics : Statistics.values()) {
            iMax = Math.max(iMax, statistics.name().length());
        }
        StringBuilder sb = new StringBuilder();
        for (Statistics statistics2 : Statistics.values()) {
            sb.append(statistics2.name());
            for (int i = 0; i != iMax - statistics2.name().length(); i++) {
                sb.append(' ');
            }
            sb.append(" = ");
            sb.append(strArr2[statistics2.ordinal()]);
            sb.append('\n');
        }
        for (int i2 = 0; i2 != sb.length(); i2++) {
            if (sb.charAt(i2) == '_') {
                sb.setCharAt(i2, ' ');
            }
        }
        if (strArr != null) {
            System.arraycopy(strArr2, 0, strArr, 0, Math.min(strArr.length, length));
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0041  */
    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append('{');
        int iNextSetBit = nextSetBit(0);
        while (iNextSetBit >= 0) {
            sb.append(iNextSetBit);
            int iNextSetBit2 = nextSetBit(iNextSetBit + 1);
            if (this.compactionCount <= 0) {
                iNextSetBit = iNextSetBit2;
            } else {
                if (iNextSetBit2 < 0) {
                    break;
                }
                int iNextClearBit = nextClearBit(iNextSetBit);
                if (iNextClearBit < 0) {
                    iNextClearBit = Integer.MAX_VALUE;
                }
                if (iNextSetBit + this.compactionCount < iNextClearBit) {
                    sb.append("..").append(iNextClearBit - 1);
                    iNextSetBit = nextSetBit(iNextClearBit);
                } else {
                    iNextSetBit = iNextSetBit2;
                }
            }
            if (iNextSetBit >= 0) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public void toStringCompaction(int i) {
        this.compactionCount = i;
    }

    public void toStringCompaction(boolean z) {
        if (z) {
            compactionCountDefault = this.compactionCount;
        }
    }

    public void xor(int i, boolean z) {
        if (i + 1 < 1) {
            throw new IndexOutOfBoundsException("i=" + i);
        }
        if (z) {
            flip(i);
        }
    }

    public void xor(int i, int i2, SparseBitSet sparseBitSet) throws IndexOutOfBoundsException {
        setScanner(i, i2, sparseBitSet, xorStrategy);
    }

    public void xor(SparseBitSet sparseBitSet) {
        setScanner(0, sparseBitSet.bitsLength, sparseBitSet, xorStrategy);
    }

    public static SparseBitSet xor(SparseBitSet sparseBitSet, SparseBitSet sparseBitSet2) {
        SparseBitSet sparseBitSetM12clone = sparseBitSet.m12clone();
        sparseBitSetM12clone.xor(sparseBitSet2);
        return sparseBitSetM12clone;
    }

    protected static void throwIndexOutOfBoundsException(int i, int i2) throws IndexOutOfBoundsException {
        String str = i < 0 ? "(i=" + i + ") < 0" : "";
        if (i == Integer.MAX_VALUE) {
            str = str + "(i=" + i + ")";
        }
        if (i2 < 0) {
            str = str + (str.isEmpty() ? "" : ", ") + "(j=" + i2 + ") < 0";
        }
        if (i > i2) {
            str = str + (str.isEmpty() ? "" : ", ") + "(i=" + i + ") > (j=" + i2 + ")";
        }
        throw new IndexOutOfBoundsException(str);
    }

    protected final void constructorHelper() {
        this.spare = new long[32];
        this.cache = new Cache();
        this.updateStrategy = new UpdateStrategy();
    }

    protected final void nullify(int i) {
        int length = this.bits.length;
        if (i < length) {
            while (i != length) {
                this.bits[i] = null;
                i++;
            }
            this.cache.hash = 0;
        }
    }

    protected final void resize(int i) {
        int i2 = i >> 16;
        int iHighestOneBit = Integer.highestOneBit(i2);
        if (iHighestOneBit == 0) {
            iHighestOneBit = 1;
        }
        if (i2 >= iHighestOneBit) {
            iHighestOneBit <<= 1;
        }
        if (iHighestOneBit > 32768) {
            iHighestOneBit = 32768;
        }
        long[][][] jArr = this.bits;
        int length = jArr != null ? jArr.length : 0;
        if (iHighestOneBit != length || jArr == null) {
            long[][][] jArr2 = new long[iHighestOneBit][][];
            if (length != 0) {
                System.arraycopy(jArr, 0, jArr2, 0, Math.min(length, iHighestOneBit));
                nullify(0);
            }
            this.bits = jArr2;
            this.bitsLength = iHighestOneBit == 32768 ? Integer.MAX_VALUE : UNIT * iHighestOneBit;
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0154  */
    /* JADX WARN: Code duplicated, block: B:109:0x0157  */
    /* JADX WARN: Code duplicated, block: B:111:0x015b  */
    /* JADX WARN: Code duplicated, block: B:113:0x015f  */
    /* JADX WARN: Code duplicated, block: B:114:0x0162  */
    /* JADX WARN: Code duplicated, block: B:116:0x0166 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:122:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:124:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:125:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:127:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:128:0x020a  */
    /* JADX WARN: Code duplicated, block: B:130:0x0232  */
    /* JADX WARN: Code duplicated, block: B:131:0x0242  */
    /* JADX WARN: Code duplicated, block: B:135:0x024b  */
    /* JADX WARN: Code duplicated, block: B:137:0x0251 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:138:0x0253  */
    /* JADX WARN: Code duplicated, block: B:140:0x0257  */
    /* JADX WARN: Code duplicated, block: B:142:0x025b  */
    /* JADX WARN: Code duplicated, block: B:144:0x025f  */
    /* JADX WARN: Code duplicated, block: B:145:0x0268  */
    /* JADX WARN: Code duplicated, block: B:148:0x026d  */
    /* JADX WARN: Code duplicated, block: B:150:0x027c  */
    /* JADX WARN: Code duplicated, block: B:153:0x0281  */
    /* JADX WARN: Code duplicated, block: B:157:0x0288  */
    /* JADX WARN: Code duplicated, block: B:162:0x02ba A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:165:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:169:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:175:0x02d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00be A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:63:0x00c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:74:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:78:0x0100 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x0102  */
    /* JADX WARN: Code duplicated, block: B:81:0x0106  */
    /* JADX WARN: Code duplicated, block: B:82:0x0109  */
    /* JADX WARN: Code duplicated, block: B:85:0x010f  */
    /* JADX WARN: Code duplicated, block: B:87:0x0113  */
    /* JADX WARN: Code duplicated, block: B:88:0x0116  */
    /* JADX WARN: Code duplicated, block: B:92:0x0120  */
    /* JADX WARN: Code duplicated, block: B:93:0x0123  */
    /* JADX WARN: Code duplicated, block: B:95:0x0127 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:97:0x012b A[ADDED_TO_REGION] */
    protected final void setScanner(int i, int i2, SparseBitSet sparseBitSet, AbstractStrategy abstractStrategy) throws IndexOutOfBoundsException {
        long[][][] jArr;
        long[][] jArr2;
        boolean z;
        long[][] jArr3;
        boolean z2;
        int i3;
        long[][] jArr4;
        boolean z3;
        int i4;
        boolean z4;
        int length;
        long[][][] jArr5;
        int i5;
        boolean z5;
        int i6;
        int i7;
        int i8;
        long[][][] jArr6;
        boolean z6;
        int i9;
        long[] jArr7;
        boolean z7;
        long[] jArr8;
        boolean z8;
        int i10;
        boolean z9;
        int i11;
        int i12;
        long[] jArr9;
        long[] jArr10;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean zWord;
        int i19;
        boolean zWord2;
        boolean zIsZeroBlock;
        boolean z10;
        int i20;
        int i21 = i;
        int i22 = i2;
        if (abstractStrategy.start(sparseBitSet)) {
            this.cache.hash = 0;
        }
        if (i22 < i21 || i21 + 1 < 1) {
            throwIndexOutOfBoundsException(i, i2);
        }
        if (i21 == i22) {
            return;
        }
        int iProperties = abstractStrategy.properties();
        boolean z11 = (iProperties & 1) != 0;
        boolean z12 = (iProperties & 2) != 0;
        boolean z13 = (iProperties & 4) != 0;
        boolean z14 = (iProperties & 8) != 0;
        int i23 = i21 >> 6;
        long j = (-1) << i21;
        int i24 = i22 - 1;
        int i25 = i24 >> 6;
        long j2 = (-1) >>> (-i22);
        long[][][] jArr11 = this.bits;
        int length2 = jArr11.length;
        if (sparseBitSet != null) {
            jArr = sparseBitSet.bits;
        } else {
            jArr = null;
        }
        int length3 = jArr != null ? sparseBitSet.bits.length : 0;
        int i26 = i21 >> 16;
        int i27 = (i21 >> 11) & 31;
        int i28 = i23 & 31;
        int i29 = i24 >> 16;
        int i30 = (i24 >> 11) & 31;
        int i31 = i25 & 31;
        int i32 = (i29 << 5) + i30;
        boolean z15 = i23 == 0 && j == -1;
        boolean z16 = i27 == 0;
        int i33 = i25;
        int i34 = 0;
        int i35 = 0;
        int i36 = i23;
        int i37 = length2;
        int i38 = i26;
        while (i21 < i22) {
            if (i38 < i37) {
                jArr2 = jArr11[i38];
                z = jArr2 != null;
                if (i38 < length3 || jArr == null) {
                    jArr3 = null;
                } else {
                    jArr3 = jArr[i38];
                    z2 = jArr3 != null;
                    if ((!(z && !z2 && z11) && ((z || !z12) && (z2 || !z13))) || !z15 || i38 == i29) {
                        boolean z17 = z15;
                        if (i38 == i29) {
                            i3 = i30 + 1;
                        } else {
                            i3 = 32;
                        }
                        jArr4 = jArr2;
                        z3 = z;
                        i4 = i34;
                        z4 = z16;
                        length = i37;
                        jArr5 = jArr11;
                        i5 = i27;
                        z5 = z17;
                        while (i5 != i3) {
                            if (z3) {
                                jArr7 = jArr4[i5];
                                z7 = jArr7 != null;
                                if (z2) {
                                    jArr8 = jArr3[i5];
                                    z8 = jArr8 != null;
                                    i10 = (i38 << 5) + i5;
                                    if (i32 != i10) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    if (((z7 && !z8 && z11) || ((!z7 && z12) || (!z8 && z13))) && z5 && z9) {
                                        if (z3) {
                                            jArr4[i5] = null;
                                        }
                                        length3 = length3;
                                        i29 = i29;
                                        i3 = i3;
                                        i32 = i32;
                                        jArr = jArr;
                                        z11 = z11;
                                        i5 = i5;
                                        int i39 = i33;
                                        i16 = i36;
                                        i17 = i39;
                                    } else {
                                        i11 = i10 << 5;
                                        if (z9) {
                                            i12 = 32;
                                        } else {
                                            i12 = i31;
                                        }
                                        if (!z7) {
                                            jArr7 = this.spare;
                                        }
                                        if (z8) {
                                            jArr9 = jArr8;
                                        } else {
                                            jArr9 = ZERO_BLOCK;
                                        }
                                        if (z5 || !z9) {
                                            length3 = length3;
                                            jArr10 = jArr7;
                                            i29 = i29;
                                            i3 = i3;
                                            i32 = i32;
                                            jArr = jArr;
                                            i5 = i5;
                                            if (z5) {
                                                int i40 = i33;
                                                i16 = i36;
                                                i17 = i40;
                                                i18 = length;
                                                zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                                            } else {
                                                i13 = length;
                                                i14 = i36;
                                                i15 = i33;
                                                if (i14 == i15) {
                                                    i16 = i14;
                                                    zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                                    i17 = i15;
                                                    i18 = i13;
                                                } else {
                                                    i16 = i14;
                                                    i17 = i15;
                                                    i18 = i13;
                                                    zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                                    i19 = i12;
                                                    if (i19 != 32) {
                                                        zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                                    } else {
                                                        zWord2 = zWord;
                                                    }
                                                }
                                                zIsZeroBlock = zWord2;
                                                z5 = true;
                                            }
                                            jArr7 = jArr10;
                                            if (zIsZeroBlock) {
                                                zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                                            }
                                        } else {
                                            if (z14 && !z8) {
                                                zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                                            } else {
                                                long[] jArr12 = jArr7;
                                                zIsZeroBlock = abstractStrategy.block(i11, 0, 32, jArr12, jArr9);
                                                jArr7 = jArr12;
                                            }
                                            i18 = length;
                                            int i41 = i33;
                                            i16 = i36;
                                            i17 = i41;
                                        }
                                        if (zIsZeroBlock) {
                                            if (z3) {
                                                jArr4[i5] = null;
                                            }
                                            length = i18;
                                        } else {
                                            if (jArr7 == this.spare) {
                                                if (i21 >= this.bitsLength) {
                                                    resize(i21);
                                                    long[][][] jArr13 = this.bits;
                                                    length = jArr13.length;
                                                    jArr5 = jArr13;
                                                } else {
                                                    length = i18;
                                                }
                                                if (jArr4 == null) {
                                                    long[][] jArr14 = new long[32][];
                                                    jArr5[i38] = jArr14;
                                                    jArr4 = jArr14;
                                                    z3 = true;
                                                }
                                                jArr4[i5] = jArr7;
                                                this.spare = new long[32];
                                            } else {
                                                length = i18;
                                            }
                                            i4++;
                                        }
                                        if (z3 || jArr4[i5] == null) {
                                            z10 = true;
                                        } else {
                                            z10 = false;
                                        }
                                        z4 &= z10;
                                    }
                                    i5++;
                                    i32 = i32;
                                    length3 = length3;
                                    i29 = i29;
                                    i3 = i3;
                                    jArr = jArr;
                                    z11 = z11;
                                    i28 = 0;
                                    int i42 = i16;
                                    i33 = i17;
                                    i36 = i42;
                                } else {
                                    jArr8 = null;
                                }
                                i10 = (i38 << 5) + i5;
                                if (i32 != i10) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                if (z7) {
                                }
                                i11 = i10 << 5;
                                if (z9) {
                                    i12 = 32;
                                } else {
                                    i12 = i31;
                                }
                                if (!z7) {
                                    jArr7 = this.spare;
                                }
                                if (z8) {
                                    jArr9 = ZERO_BLOCK;
                                } else {
                                    jArr9 = jArr8;
                                }
                                if (z5) {
                                    length3 = length3;
                                    jArr10 = jArr7;
                                    i29 = i29;
                                    i3 = i3;
                                    i32 = i32;
                                    jArr = jArr;
                                    i5 = i5;
                                    if (z5) {
                                        int i43 = i33;
                                        i16 = i36;
                                        i17 = i43;
                                        i18 = length;
                                        zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                                    } else {
                                        i13 = length;
                                        i14 = i36;
                                        i15 = i33;
                                        if (i14 == i15) {
                                            i16 = i14;
                                            zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                            i17 = i15;
                                            i18 = i13;
                                        } else {
                                            i16 = i14;
                                            i17 = i15;
                                            i18 = i13;
                                            zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                            i19 = i12;
                                            if (i19 != 32) {
                                                zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                            } else {
                                                zWord2 = zWord;
                                            }
                                        }
                                        zIsZeroBlock = zWord2;
                                        z5 = true;
                                    }
                                    jArr7 = jArr10;
                                    if (zIsZeroBlock) {
                                        zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                                    }
                                } else {
                                    length3 = length3;
                                    jArr10 = jArr7;
                                    i29 = i29;
                                    i3 = i3;
                                    i32 = i32;
                                    jArr = jArr;
                                    i5 = i5;
                                    if (z5) {
                                        int i44 = i33;
                                        i16 = i36;
                                        i17 = i44;
                                        i18 = length;
                                        zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                                    } else {
                                        i13 = length;
                                        i14 = i36;
                                        i15 = i33;
                                        if (i14 == i15) {
                                            i16 = i14;
                                            zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                            i17 = i15;
                                            i18 = i13;
                                        } else {
                                            i16 = i14;
                                            i17 = i15;
                                            i18 = i13;
                                            zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                            i19 = i12;
                                            if (i19 != 32) {
                                                zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                            } else {
                                                zWord2 = zWord;
                                            }
                                        }
                                        zIsZeroBlock = zWord2;
                                        z5 = true;
                                    }
                                    jArr7 = jArr10;
                                    if (zIsZeroBlock) {
                                        zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                                    }
                                }
                                if (zIsZeroBlock) {
                                    if (z3) {
                                        jArr4[i5] = null;
                                    }
                                    length = i18;
                                } else {
                                    if (jArr7 == this.spare) {
                                        if (i21 >= this.bitsLength) {
                                            resize(i21);
                                            long[][][] jArr15 = this.bits;
                                            length = jArr15.length;
                                            jArr5 = jArr15;
                                        } else {
                                            length = i18;
                                        }
                                        if (jArr4 == null) {
                                            long[][] jArr16 = new long[32][];
                                            jArr5[i38] = jArr16;
                                            jArr4 = jArr16;
                                            z3 = true;
                                        }
                                        jArr4[i5] = jArr7;
                                        this.spare = new long[32];
                                    } else {
                                        length = i18;
                                    }
                                    i4++;
                                }
                                if (z3) {
                                    z10 = true;
                                } else {
                                    z10 = true;
                                }
                                z4 &= z10;
                                i5++;
                                i32 = i32;
                                length3 = length3;
                                i29 = i29;
                                i3 = i3;
                                jArr = jArr;
                                z11 = z11;
                                i28 = 0;
                                int i45 = i16;
                                i33 = i17;
                                i36 = i45;
                            } else {
                                jArr7 = null;
                            }
                            if (z2) {
                                jArr8 = jArr3[i5];
                                if (jArr8 != null) {
                                }
                                i10 = (i38 << 5) + i5;
                                if (i32 != i10) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                if (z7) {
                                }
                                i11 = i10 << 5;
                                if (z9) {
                                    i12 = 32;
                                } else {
                                    i12 = i31;
                                }
                                if (!z7) {
                                    jArr7 = this.spare;
                                }
                                if (z8) {
                                    jArr9 = ZERO_BLOCK;
                                } else {
                                    jArr9 = jArr8;
                                }
                                if (z5) {
                                    length3 = length3;
                                    jArr10 = jArr7;
                                    i29 = i29;
                                    i3 = i3;
                                    i32 = i32;
                                    jArr = jArr;
                                    i5 = i5;
                                    if (z5) {
                                        int i46 = i33;
                                        i16 = i36;
                                        i17 = i46;
                                        i18 = length;
                                        zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                                    } else {
                                        i13 = length;
                                        i14 = i36;
                                        i15 = i33;
                                        if (i14 == i15) {
                                            i16 = i14;
                                            zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                            i17 = i15;
                                            i18 = i13;
                                        } else {
                                            i16 = i14;
                                            i17 = i15;
                                            i18 = i13;
                                            zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                            i19 = i12;
                                            if (i19 != 32) {
                                                zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                            } else {
                                                zWord2 = zWord;
                                            }
                                        }
                                        zIsZeroBlock = zWord2;
                                        z5 = true;
                                    }
                                    jArr7 = jArr10;
                                    if (zIsZeroBlock) {
                                        zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                                    }
                                } else {
                                    length3 = length3;
                                    jArr10 = jArr7;
                                    i29 = i29;
                                    i3 = i3;
                                    i32 = i32;
                                    jArr = jArr;
                                    i5 = i5;
                                    if (z5) {
                                        int i47 = i33;
                                        i16 = i36;
                                        i17 = i47;
                                        i18 = length;
                                        zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                                    } else {
                                        i13 = length;
                                        i14 = i36;
                                        i15 = i33;
                                        if (i14 == i15) {
                                            i16 = i14;
                                            zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                            i17 = i15;
                                            i18 = i13;
                                        } else {
                                            i16 = i14;
                                            i17 = i15;
                                            i18 = i13;
                                            zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                            i19 = i12;
                                            if (i19 != 32) {
                                                zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                            } else {
                                                zWord2 = zWord;
                                            }
                                        }
                                        zIsZeroBlock = zWord2;
                                        z5 = true;
                                    }
                                    jArr7 = jArr10;
                                    if (zIsZeroBlock) {
                                        zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                                    }
                                }
                                if (zIsZeroBlock) {
                                    if (z3) {
                                        jArr4[i5] = null;
                                    }
                                    length = i18;
                                } else {
                                    if (jArr7 == this.spare) {
                                        if (i21 >= this.bitsLength) {
                                            resize(i21);
                                            long[][][] jArr17 = this.bits;
                                            length = jArr17.length;
                                            jArr5 = jArr17;
                                        } else {
                                            length = i18;
                                        }
                                        if (jArr4 == null) {
                                            long[][] jArr18 = new long[32][];
                                            jArr5[i38] = jArr18;
                                            jArr4 = jArr18;
                                            z3 = true;
                                        }
                                        jArr4[i5] = jArr7;
                                        this.spare = new long[32];
                                    } else {
                                        length = i18;
                                    }
                                    i4++;
                                }
                                if (z3) {
                                    z10 = true;
                                } else {
                                    z10 = true;
                                }
                                z4 &= z10;
                                i5++;
                                i32 = i32;
                                length3 = length3;
                                i29 = i29;
                                i3 = i3;
                                jArr = jArr;
                                z11 = z11;
                                i28 = 0;
                                int i48 = i16;
                                i33 = i17;
                                i36 = i48;
                            } else {
                                jArr8 = null;
                            }
                            i10 = (i38 << 5) + i5;
                            if (i32 != i10) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            if (z7) {
                            }
                            i11 = i10 << 5;
                            if (z9) {
                                i12 = 32;
                            } else {
                                i12 = i31;
                            }
                            if (!z7) {
                                jArr7 = this.spare;
                            }
                            if (z8) {
                                jArr9 = ZERO_BLOCK;
                            } else {
                                jArr9 = jArr8;
                            }
                            if (z5) {
                                length3 = length3;
                                jArr10 = jArr7;
                                i29 = i29;
                                i3 = i3;
                                i32 = i32;
                                jArr = jArr;
                                i5 = i5;
                                if (z5) {
                                    int i49 = i33;
                                    i16 = i36;
                                    i17 = i49;
                                    i18 = length;
                                    zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                                } else {
                                    i13 = length;
                                    i14 = i36;
                                    i15 = i33;
                                    if (i14 == i15) {
                                        i16 = i14;
                                        zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                        i17 = i15;
                                        i18 = i13;
                                    } else {
                                        i16 = i14;
                                        i17 = i15;
                                        i18 = i13;
                                        zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                        i19 = i12;
                                        if (i19 != 32) {
                                            zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                        } else {
                                            zWord2 = zWord;
                                        }
                                    }
                                    zIsZeroBlock = zWord2;
                                    z5 = true;
                                }
                                jArr7 = jArr10;
                                if (zIsZeroBlock) {
                                    zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                                }
                            } else {
                                length3 = length3;
                                jArr10 = jArr7;
                                i29 = i29;
                                i3 = i3;
                                i32 = i32;
                                jArr = jArr;
                                i5 = i5;
                                if (z5) {
                                    int i410 = i33;
                                    i16 = i36;
                                    i17 = i410;
                                    i18 = length;
                                    zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                                } else {
                                    i13 = length;
                                    i14 = i36;
                                    i15 = i33;
                                    if (i14 == i15) {
                                        i16 = i14;
                                        zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                        i17 = i15;
                                        i18 = i13;
                                    } else {
                                        i16 = i14;
                                        i17 = i15;
                                        i18 = i13;
                                        zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                        i19 = i12;
                                        if (i19 != 32) {
                                            zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                        } else {
                                            zWord2 = zWord;
                                        }
                                    }
                                    zIsZeroBlock = zWord2;
                                    z5 = true;
                                }
                                jArr7 = jArr10;
                                if (zIsZeroBlock) {
                                    zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                                }
                            }
                            if (zIsZeroBlock) {
                                if (z3) {
                                    jArr4[i5] = null;
                                }
                                length = i18;
                            } else {
                                if (jArr7 == this.spare) {
                                    if (i21 >= this.bitsLength) {
                                        resize(i21);
                                        long[][][] jArr19 = this.bits;
                                        length = jArr19.length;
                                        jArr5 = jArr19;
                                    } else {
                                        length = i18;
                                    }
                                    if (jArr4 == null) {
                                        long[][] jArr110 = new long[32][];
                                        jArr5[i38] = jArr110;
                                        jArr4 = jArr110;
                                        z3 = true;
                                    }
                                    jArr4[i5] = jArr7;
                                    this.spare = new long[32];
                                } else {
                                    length = i18;
                                }
                                i4++;
                            }
                            if (z3) {
                                z10 = true;
                            } else {
                                z10 = true;
                            }
                            z4 &= z10;
                            i5++;
                            i32 = i32;
                            length3 = length3;
                            i29 = i29;
                            i3 = i3;
                            jArr = jArr;
                            z11 = z11;
                            i28 = 0;
                            int i411 = i16;
                            i33 = i17;
                            i36 = i411;
                        }
                        i6 = length3;
                        i7 = i29;
                        i8 = i32;
                        jArr6 = jArr;
                        z6 = z11;
                        i9 = i33;
                        int i50 = length;
                        if (i5 == 32 || !z4 || i38 >= i50) {
                            i35++;
                        } else {
                            jArr5[i38] = null;
                        }
                        i37 = i50;
                        z15 = z5;
                        jArr11 = jArr5;
                        i34 = i4;
                        z16 = z4;
                    } else {
                        if (i38 < i37) {
                            jArr11[i38] = null;
                        }
                        i6 = length3;
                        i7 = i29;
                        i8 = i32;
                        jArr6 = jArr;
                        z6 = z11;
                        i9 = i33;
                    }
                    i38++;
                    int i51 = i38 << 10;
                    i20 = i38 << 16;
                    if (i20 < 0) {
                        i20 = Integer.MAX_VALUE;
                    }
                    i33 = i9;
                    i32 = i8;
                    length3 = i6;
                    i29 = i7;
                    jArr = jArr6;
                    z11 = z6;
                    i27 = 0;
                    i36 = i51;
                    i21 = i20;
                    i22 = i2;
                }
                if (z) {
                }
                boolean z18 = z15;
                if (i38 == i29) {
                    i3 = i30 + 1;
                } else {
                    i3 = 32;
                }
                jArr4 = jArr2;
                z3 = z;
                i4 = i34;
                z4 = z16;
                length = i37;
                jArr5 = jArr11;
                i5 = i27;
                z5 = z18;
                while (i5 != i3) {
                    if (z3) {
                        jArr7 = jArr4[i5];
                        if (jArr7 != null) {
                        }
                        if (z2) {
                            jArr8 = jArr3[i5];
                            if (jArr8 != null) {
                            }
                            i10 = (i38 << 5) + i5;
                            if (i32 != i10) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            if (z7) {
                            }
                            i11 = i10 << 5;
                            if (z9) {
                                i12 = 32;
                            } else {
                                i12 = i31;
                            }
                            if (!z7) {
                                jArr7 = this.spare;
                            }
                            if (z8) {
                                jArr9 = ZERO_BLOCK;
                            } else {
                                jArr9 = jArr8;
                            }
                            if (z5) {
                                length3 = length3;
                                jArr10 = jArr7;
                                i29 = i29;
                                i3 = i3;
                                i32 = i32;
                                jArr = jArr;
                                i5 = i5;
                                if (z5) {
                                    int i412 = i33;
                                    i16 = i36;
                                    i17 = i412;
                                    i18 = length;
                                    zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                                } else {
                                    i13 = length;
                                    i14 = i36;
                                    i15 = i33;
                                    if (i14 == i15) {
                                        i16 = i14;
                                        zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                        i17 = i15;
                                        i18 = i13;
                                    } else {
                                        i16 = i14;
                                        i17 = i15;
                                        i18 = i13;
                                        zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                        i19 = i12;
                                        if (i19 != 32) {
                                            zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                        } else {
                                            zWord2 = zWord;
                                        }
                                    }
                                    zIsZeroBlock = zWord2;
                                    z5 = true;
                                }
                                jArr7 = jArr10;
                                if (zIsZeroBlock) {
                                    zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                                }
                            } else {
                                length3 = length3;
                                jArr10 = jArr7;
                                i29 = i29;
                                i3 = i3;
                                i32 = i32;
                                jArr = jArr;
                                i5 = i5;
                                if (z5) {
                                    int i413 = i33;
                                    i16 = i36;
                                    i17 = i413;
                                    i18 = length;
                                    zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                                } else {
                                    i13 = length;
                                    i14 = i36;
                                    i15 = i33;
                                    if (i14 == i15) {
                                        i16 = i14;
                                        zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                        i17 = i15;
                                        i18 = i13;
                                    } else {
                                        i16 = i14;
                                        i17 = i15;
                                        i18 = i13;
                                        zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                        i19 = i12;
                                        if (i19 != 32) {
                                            zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                        } else {
                                            zWord2 = zWord;
                                        }
                                    }
                                    zIsZeroBlock = zWord2;
                                    z5 = true;
                                }
                                jArr7 = jArr10;
                                if (zIsZeroBlock) {
                                    zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                                }
                            }
                            if (zIsZeroBlock) {
                                if (z3) {
                                    jArr4[i5] = null;
                                }
                                length = i18;
                            } else {
                                if (jArr7 == this.spare) {
                                    if (i21 >= this.bitsLength) {
                                        resize(i21);
                                        long[][][] jArr111 = this.bits;
                                        length = jArr111.length;
                                        jArr5 = jArr111;
                                    } else {
                                        length = i18;
                                    }
                                    if (jArr4 == null) {
                                        long[][] jArr112 = new long[32][];
                                        jArr5[i38] = jArr112;
                                        jArr4 = jArr112;
                                        z3 = true;
                                    }
                                    jArr4[i5] = jArr7;
                                    this.spare = new long[32];
                                } else {
                                    length = i18;
                                }
                                i4++;
                            }
                            if (z3) {
                                z10 = true;
                            } else {
                                z10 = true;
                            }
                            z4 &= z10;
                            i5++;
                            i32 = i32;
                            length3 = length3;
                            i29 = i29;
                            i3 = i3;
                            jArr = jArr;
                            z11 = z11;
                            i28 = 0;
                            int i414 = i16;
                            i33 = i17;
                            i36 = i414;
                        } else {
                            jArr8 = null;
                        }
                        i10 = (i38 << 5) + i5;
                        if (i32 != i10) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        if (z7) {
                        }
                        i11 = i10 << 5;
                        if (z9) {
                            i12 = 32;
                        } else {
                            i12 = i31;
                        }
                        if (!z7) {
                            jArr7 = this.spare;
                        }
                        if (z8) {
                            jArr9 = ZERO_BLOCK;
                        } else {
                            jArr9 = jArr8;
                        }
                        if (z5) {
                            length3 = length3;
                            jArr10 = jArr7;
                            i29 = i29;
                            i3 = i3;
                            i32 = i32;
                            jArr = jArr;
                            i5 = i5;
                            if (z5) {
                                int i415 = i33;
                                i16 = i36;
                                i17 = i415;
                                i18 = length;
                                zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                            } else {
                                i13 = length;
                                i14 = i36;
                                i15 = i33;
                                if (i14 == i15) {
                                    i16 = i14;
                                    zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                    i17 = i15;
                                    i18 = i13;
                                } else {
                                    i16 = i14;
                                    i17 = i15;
                                    i18 = i13;
                                    zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                    i19 = i12;
                                    if (i19 != 32) {
                                        zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                    } else {
                                        zWord2 = zWord;
                                    }
                                }
                                zIsZeroBlock = zWord2;
                                z5 = true;
                            }
                            jArr7 = jArr10;
                            if (zIsZeroBlock) {
                                zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                            }
                        } else {
                            length3 = length3;
                            jArr10 = jArr7;
                            i29 = i29;
                            i3 = i3;
                            i32 = i32;
                            jArr = jArr;
                            i5 = i5;
                            if (z5) {
                                int i416 = i33;
                                i16 = i36;
                                i17 = i416;
                                i18 = length;
                                zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                            } else {
                                i13 = length;
                                i14 = i36;
                                i15 = i33;
                                if (i14 == i15) {
                                    i16 = i14;
                                    zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                    i17 = i15;
                                    i18 = i13;
                                } else {
                                    i16 = i14;
                                    i17 = i15;
                                    i18 = i13;
                                    zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                    i19 = i12;
                                    if (i19 != 32) {
                                        zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                    } else {
                                        zWord2 = zWord;
                                    }
                                }
                                zIsZeroBlock = zWord2;
                                z5 = true;
                            }
                            jArr7 = jArr10;
                            if (zIsZeroBlock) {
                                zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                            }
                        }
                        if (zIsZeroBlock) {
                            if (z3) {
                                jArr4[i5] = null;
                            }
                            length = i18;
                        } else {
                            if (jArr7 == this.spare) {
                                if (i21 >= this.bitsLength) {
                                    resize(i21);
                                    long[][][] jArr113 = this.bits;
                                    length = jArr113.length;
                                    jArr5 = jArr113;
                                } else {
                                    length = i18;
                                }
                                if (jArr4 == null) {
                                    long[][] jArr114 = new long[32][];
                                    jArr5[i38] = jArr114;
                                    jArr4 = jArr114;
                                    z3 = true;
                                }
                                jArr4[i5] = jArr7;
                                this.spare = new long[32];
                            } else {
                                length = i18;
                            }
                            i4++;
                        }
                        if (z3) {
                            z10 = true;
                        } else {
                            z10 = true;
                        }
                        z4 &= z10;
                        i5++;
                        i32 = i32;
                        length3 = length3;
                        i29 = i29;
                        i3 = i3;
                        jArr = jArr;
                        z11 = z11;
                        i28 = 0;
                        int i417 = i16;
                        i33 = i17;
                        i36 = i417;
                    } else {
                        jArr7 = null;
                    }
                    if (z2) {
                        jArr8 = jArr3[i5];
                        if (jArr8 != null) {
                        }
                        i10 = (i38 << 5) + i5;
                        if (i32 != i10) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        if (z7) {
                        }
                        i11 = i10 << 5;
                        if (z9) {
                            i12 = 32;
                        } else {
                            i12 = i31;
                        }
                        if (!z7) {
                            jArr7 = this.spare;
                        }
                        if (z8) {
                            jArr9 = ZERO_BLOCK;
                        } else {
                            jArr9 = jArr8;
                        }
                        if (z5) {
                            length3 = length3;
                            jArr10 = jArr7;
                            i29 = i29;
                            i3 = i3;
                            i32 = i32;
                            jArr = jArr;
                            i5 = i5;
                            if (z5) {
                                int i418 = i33;
                                i16 = i36;
                                i17 = i418;
                                i18 = length;
                                zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                            } else {
                                i13 = length;
                                i14 = i36;
                                i15 = i33;
                                if (i14 == i15) {
                                    i16 = i14;
                                    zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                    i17 = i15;
                                    i18 = i13;
                                } else {
                                    i16 = i14;
                                    i17 = i15;
                                    i18 = i13;
                                    zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                    i19 = i12;
                                    if (i19 != 32) {
                                        zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                    } else {
                                        zWord2 = zWord;
                                    }
                                }
                                zIsZeroBlock = zWord2;
                                z5 = true;
                            }
                            jArr7 = jArr10;
                            if (zIsZeroBlock) {
                                zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                            }
                        } else {
                            length3 = length3;
                            jArr10 = jArr7;
                            i29 = i29;
                            i3 = i3;
                            i32 = i32;
                            jArr = jArr;
                            i5 = i5;
                            if (z5) {
                                int i419 = i33;
                                i16 = i36;
                                i17 = i419;
                                i18 = length;
                                zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                            } else {
                                i13 = length;
                                i14 = i36;
                                i15 = i33;
                                if (i14 == i15) {
                                    i16 = i14;
                                    zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                    i17 = i15;
                                    i18 = i13;
                                } else {
                                    i16 = i14;
                                    i17 = i15;
                                    i18 = i13;
                                    zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                    i19 = i12;
                                    if (i19 != 32) {
                                        zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                    } else {
                                        zWord2 = zWord;
                                    }
                                }
                                zIsZeroBlock = zWord2;
                                z5 = true;
                            }
                            jArr7 = jArr10;
                            if (zIsZeroBlock) {
                                zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                            }
                        }
                        if (zIsZeroBlock) {
                            if (z3) {
                                jArr4[i5] = null;
                            }
                            length = i18;
                        } else {
                            if (jArr7 == this.spare) {
                                if (i21 >= this.bitsLength) {
                                    resize(i21);
                                    long[][][] jArr115 = this.bits;
                                    length = jArr115.length;
                                    jArr5 = jArr115;
                                } else {
                                    length = i18;
                                }
                                if (jArr4 == null) {
                                    long[][] jArr116 = new long[32][];
                                    jArr5[i38] = jArr116;
                                    jArr4 = jArr116;
                                    z3 = true;
                                }
                                jArr4[i5] = jArr7;
                                this.spare = new long[32];
                            } else {
                                length = i18;
                            }
                            i4++;
                        }
                        if (z3) {
                            z10 = true;
                        } else {
                            z10 = true;
                        }
                        z4 &= z10;
                        i5++;
                        i32 = i32;
                        length3 = length3;
                        i29 = i29;
                        i3 = i3;
                        jArr = jArr;
                        z11 = z11;
                        i28 = 0;
                        int i4110 = i16;
                        i33 = i17;
                        i36 = i4110;
                    } else {
                        jArr8 = null;
                    }
                    i10 = (i38 << 5) + i5;
                    if (i32 != i10) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (z7) {
                    }
                    i11 = i10 << 5;
                    if (z9) {
                        i12 = 32;
                    } else {
                        i12 = i31;
                    }
                    if (!z7) {
                        jArr7 = this.spare;
                    }
                    if (z8) {
                        jArr9 = ZERO_BLOCK;
                    } else {
                        jArr9 = jArr8;
                    }
                    if (z5) {
                        length3 = length3;
                        jArr10 = jArr7;
                        i29 = i29;
                        i3 = i3;
                        i32 = i32;
                        jArr = jArr;
                        i5 = i5;
                        if (z5) {
                            int i4111 = i33;
                            i16 = i36;
                            i17 = i4111;
                            i18 = length;
                            zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                        } else {
                            i13 = length;
                            i14 = i36;
                            i15 = i33;
                            if (i14 == i15) {
                                i16 = i14;
                                zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                i17 = i15;
                                i18 = i13;
                            } else {
                                i16 = i14;
                                i17 = i15;
                                i18 = i13;
                                zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                i19 = i12;
                                if (i19 != 32) {
                                    zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                } else {
                                    zWord2 = zWord;
                                }
                            }
                            zIsZeroBlock = zWord2;
                            z5 = true;
                        }
                        jArr7 = jArr10;
                        if (zIsZeroBlock) {
                            zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                        }
                    } else {
                        length3 = length3;
                        jArr10 = jArr7;
                        i29 = i29;
                        i3 = i3;
                        i32 = i32;
                        jArr = jArr;
                        i5 = i5;
                        if (z5) {
                            int i4112 = i33;
                            i16 = i36;
                            i17 = i4112;
                            i18 = length;
                            zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                        } else {
                            i13 = length;
                            i14 = i36;
                            i15 = i33;
                            if (i14 == i15) {
                                i16 = i14;
                                zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                i17 = i15;
                                i18 = i13;
                            } else {
                                i16 = i14;
                                i17 = i15;
                                i18 = i13;
                                zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                i19 = i12;
                                if (i19 != 32) {
                                    zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                } else {
                                    zWord2 = zWord;
                                }
                            }
                            zIsZeroBlock = zWord2;
                            z5 = true;
                        }
                        jArr7 = jArr10;
                        if (zIsZeroBlock) {
                            zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                        }
                    }
                    if (zIsZeroBlock) {
                        if (z3) {
                            jArr4[i5] = null;
                        }
                        length = i18;
                    } else {
                        if (jArr7 == this.spare) {
                            if (i21 >= this.bitsLength) {
                                resize(i21);
                                long[][][] jArr117 = this.bits;
                                length = jArr117.length;
                                jArr5 = jArr117;
                            } else {
                                length = i18;
                            }
                            if (jArr4 == null) {
                                long[][] jArr118 = new long[32][];
                                jArr5[i38] = jArr118;
                                jArr4 = jArr118;
                                z3 = true;
                            }
                            jArr4[i5] = jArr7;
                            this.spare = new long[32];
                        } else {
                            length = i18;
                        }
                        i4++;
                    }
                    if (z3) {
                        z10 = true;
                    } else {
                        z10 = true;
                    }
                    z4 &= z10;
                    i5++;
                    i32 = i32;
                    length3 = length3;
                    i29 = i29;
                    i3 = i3;
                    jArr = jArr;
                    z11 = z11;
                    i28 = 0;
                    int i4113 = i16;
                    i33 = i17;
                    i36 = i4113;
                }
                i6 = length3;
                i7 = i29;
                i8 = i32;
                jArr6 = jArr;
                z6 = z11;
                i9 = i33;
                int i52 = length;
                if (i5 == 32) {
                    i35++;
                } else {
                    i35++;
                }
                i37 = i52;
                z15 = z5;
                jArr11 = jArr5;
                i34 = i4;
                z16 = z4;
                i38++;
                int i53 = i38 << 10;
                i20 = i38 << 16;
                if (i20 < 0) {
                    i20 = Integer.MAX_VALUE;
                }
                i33 = i9;
                i32 = i8;
                length3 = i6;
                i29 = i7;
                jArr = jArr6;
                z11 = z6;
                i27 = 0;
                i36 = i53;
                i21 = i20;
                i22 = i2;
            } else {
                jArr2 = null;
            }
            if (i38 < length3) {
                jArr3 = null;
            } else {
                jArr3 = null;
            }
            if (z) {
            }
            boolean z19 = z15;
            if (i38 == i29) {
                i3 = i30 + 1;
            } else {
                i3 = 32;
            }
            jArr4 = jArr2;
            z3 = z;
            i4 = i34;
            z4 = z16;
            length = i37;
            jArr5 = jArr11;
            i5 = i27;
            z5 = z19;
            while (i5 != i3) {
                if (z3) {
                    jArr7 = jArr4[i5];
                    if (jArr7 != null) {
                    }
                    if (z2) {
                        jArr8 = jArr3[i5];
                        if (jArr8 != null) {
                        }
                        i10 = (i38 << 5) + i5;
                        if (i32 != i10) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        if (z7) {
                        }
                        i11 = i10 << 5;
                        if (z9) {
                            i12 = 32;
                        } else {
                            i12 = i31;
                        }
                        if (!z7) {
                            jArr7 = this.spare;
                        }
                        if (z8) {
                            jArr9 = ZERO_BLOCK;
                        } else {
                            jArr9 = jArr8;
                        }
                        if (z5) {
                            length3 = length3;
                            jArr10 = jArr7;
                            i29 = i29;
                            i3 = i3;
                            i32 = i32;
                            jArr = jArr;
                            i5 = i5;
                            if (z5) {
                                int i4114 = i33;
                                i16 = i36;
                                i17 = i4114;
                                i18 = length;
                                zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                            } else {
                                i13 = length;
                                i14 = i36;
                                i15 = i33;
                                if (i14 == i15) {
                                    i16 = i14;
                                    zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                    i17 = i15;
                                    i18 = i13;
                                } else {
                                    i16 = i14;
                                    i17 = i15;
                                    i18 = i13;
                                    zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                    i19 = i12;
                                    if (i19 != 32) {
                                        zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                    } else {
                                        zWord2 = zWord;
                                    }
                                }
                                zIsZeroBlock = zWord2;
                                z5 = true;
                            }
                            jArr7 = jArr10;
                            if (zIsZeroBlock) {
                                zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                            }
                        } else {
                            length3 = length3;
                            jArr10 = jArr7;
                            i29 = i29;
                            i3 = i3;
                            i32 = i32;
                            jArr = jArr;
                            i5 = i5;
                            if (z5) {
                                int i4115 = i33;
                                i16 = i36;
                                i17 = i4115;
                                i18 = length;
                                zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                            } else {
                                i13 = length;
                                i14 = i36;
                                i15 = i33;
                                if (i14 == i15) {
                                    i16 = i14;
                                    zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                    i17 = i15;
                                    i18 = i13;
                                } else {
                                    i16 = i14;
                                    i17 = i15;
                                    i18 = i13;
                                    zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                    i19 = i12;
                                    if (i19 != 32) {
                                        zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                    } else {
                                        zWord2 = zWord;
                                    }
                                }
                                zIsZeroBlock = zWord2;
                                z5 = true;
                            }
                            jArr7 = jArr10;
                            if (zIsZeroBlock) {
                                zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                            }
                        }
                        if (zIsZeroBlock) {
                            if (z3) {
                                jArr4[i5] = null;
                            }
                            length = i18;
                        } else {
                            if (jArr7 == this.spare) {
                                if (i21 >= this.bitsLength) {
                                    resize(i21);
                                    long[][][] jArr119 = this.bits;
                                    length = jArr119.length;
                                    jArr5 = jArr119;
                                } else {
                                    length = i18;
                                }
                                if (jArr4 == null) {
                                    long[][] jArr1110 = new long[32][];
                                    jArr5[i38] = jArr1110;
                                    jArr4 = jArr1110;
                                    z3 = true;
                                }
                                jArr4[i5] = jArr7;
                                this.spare = new long[32];
                            } else {
                                length = i18;
                            }
                            i4++;
                        }
                        if (z3) {
                            z10 = true;
                        } else {
                            z10 = true;
                        }
                        z4 &= z10;
                        i5++;
                        i32 = i32;
                        length3 = length3;
                        i29 = i29;
                        i3 = i3;
                        jArr = jArr;
                        z11 = z11;
                        i28 = 0;
                        int i4116 = i16;
                        i33 = i17;
                        i36 = i4116;
                    } else {
                        jArr8 = null;
                    }
                    i10 = (i38 << 5) + i5;
                    if (i32 != i10) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (z7) {
                    }
                    i11 = i10 << 5;
                    if (z9) {
                        i12 = 32;
                    } else {
                        i12 = i31;
                    }
                    if (!z7) {
                        jArr7 = this.spare;
                    }
                    if (z8) {
                        jArr9 = ZERO_BLOCK;
                    } else {
                        jArr9 = jArr8;
                    }
                    if (z5) {
                        length3 = length3;
                        jArr10 = jArr7;
                        i29 = i29;
                        i3 = i3;
                        i32 = i32;
                        jArr = jArr;
                        i5 = i5;
                        if (z5) {
                            int i4117 = i33;
                            i16 = i36;
                            i17 = i4117;
                            i18 = length;
                            zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                        } else {
                            i13 = length;
                            i14 = i36;
                            i15 = i33;
                            if (i14 == i15) {
                                i16 = i14;
                                zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                i17 = i15;
                                i18 = i13;
                            } else {
                                i16 = i14;
                                i17 = i15;
                                i18 = i13;
                                zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                i19 = i12;
                                if (i19 != 32) {
                                    zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                } else {
                                    zWord2 = zWord;
                                }
                            }
                            zIsZeroBlock = zWord2;
                            z5 = true;
                        }
                        jArr7 = jArr10;
                        if (zIsZeroBlock) {
                            zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                        }
                    } else {
                        length3 = length3;
                        jArr10 = jArr7;
                        i29 = i29;
                        i3 = i3;
                        i32 = i32;
                        jArr = jArr;
                        i5 = i5;
                        if (z5) {
                            int i4118 = i33;
                            i16 = i36;
                            i17 = i4118;
                            i18 = length;
                            zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                        } else {
                            i13 = length;
                            i14 = i36;
                            i15 = i33;
                            if (i14 == i15) {
                                i16 = i14;
                                zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                i17 = i15;
                                i18 = i13;
                            } else {
                                i16 = i14;
                                i17 = i15;
                                i18 = i13;
                                zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                i19 = i12;
                                if (i19 != 32) {
                                    zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                } else {
                                    zWord2 = zWord;
                                }
                            }
                            zIsZeroBlock = zWord2;
                            z5 = true;
                        }
                        jArr7 = jArr10;
                        if (zIsZeroBlock) {
                            zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                        }
                    }
                    if (zIsZeroBlock) {
                        if (z3) {
                            jArr4[i5] = null;
                        }
                        length = i18;
                    } else {
                        if (jArr7 == this.spare) {
                            if (i21 >= this.bitsLength) {
                                resize(i21);
                                long[][][] jArr1111 = this.bits;
                                length = jArr1111.length;
                                jArr5 = jArr1111;
                            } else {
                                length = i18;
                            }
                            if (jArr4 == null) {
                                long[][] jArr1112 = new long[32][];
                                jArr5[i38] = jArr1112;
                                jArr4 = jArr1112;
                                z3 = true;
                            }
                            jArr4[i5] = jArr7;
                            this.spare = new long[32];
                        } else {
                            length = i18;
                        }
                        i4++;
                    }
                    if (z3) {
                        z10 = true;
                    } else {
                        z10 = true;
                    }
                    z4 &= z10;
                    i5++;
                    i32 = i32;
                    length3 = length3;
                    i29 = i29;
                    i3 = i3;
                    jArr = jArr;
                    z11 = z11;
                    i28 = 0;
                    int i4119 = i16;
                    i33 = i17;
                    i36 = i4119;
                } else {
                    jArr7 = null;
                }
                if (z2) {
                    jArr8 = jArr3[i5];
                    if (jArr8 != null) {
                    }
                    i10 = (i38 << 5) + i5;
                    if (i32 != i10) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (z7) {
                    }
                    i11 = i10 << 5;
                    if (z9) {
                        i12 = 32;
                    } else {
                        i12 = i31;
                    }
                    if (!z7) {
                        jArr7 = this.spare;
                    }
                    if (z8) {
                        jArr9 = ZERO_BLOCK;
                    } else {
                        jArr9 = jArr8;
                    }
                    if (z5) {
                        length3 = length3;
                        jArr10 = jArr7;
                        i29 = i29;
                        i3 = i3;
                        i32 = i32;
                        jArr = jArr;
                        i5 = i5;
                        if (z5) {
                            int i41110 = i33;
                            i16 = i36;
                            i17 = i41110;
                            i18 = length;
                            zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                        } else {
                            i13 = length;
                            i14 = i36;
                            i15 = i33;
                            if (i14 == i15) {
                                i16 = i14;
                                zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                i17 = i15;
                                i18 = i13;
                            } else {
                                i16 = i14;
                                i17 = i15;
                                i18 = i13;
                                zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                i19 = i12;
                                if (i19 != 32) {
                                    zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                } else {
                                    zWord2 = zWord;
                                }
                            }
                            zIsZeroBlock = zWord2;
                            z5 = true;
                        }
                        jArr7 = jArr10;
                        if (zIsZeroBlock) {
                            zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                        }
                    } else {
                        length3 = length3;
                        jArr10 = jArr7;
                        i29 = i29;
                        i3 = i3;
                        i32 = i32;
                        jArr = jArr;
                        i5 = i5;
                        if (z5) {
                            int i41111 = i33;
                            i16 = i36;
                            i17 = i41111;
                            i18 = length;
                            zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                        } else {
                            i13 = length;
                            i14 = i36;
                            i15 = i33;
                            if (i14 == i15) {
                                i16 = i14;
                                zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                                i17 = i15;
                                i18 = i13;
                            } else {
                                i16 = i14;
                                i17 = i15;
                                i18 = i13;
                                zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                                i19 = i12;
                                if (i19 != 32) {
                                    zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                                } else {
                                    zWord2 = zWord;
                                }
                            }
                            zIsZeroBlock = zWord2;
                            z5 = true;
                        }
                        jArr7 = jArr10;
                        if (zIsZeroBlock) {
                            zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                        }
                    }
                    if (zIsZeroBlock) {
                        if (z3) {
                            jArr4[i5] = null;
                        }
                        length = i18;
                    } else {
                        if (jArr7 == this.spare) {
                            if (i21 >= this.bitsLength) {
                                resize(i21);
                                long[][][] jArr1113 = this.bits;
                                length = jArr1113.length;
                                jArr5 = jArr1113;
                            } else {
                                length = i18;
                            }
                            if (jArr4 == null) {
                                long[][] jArr1114 = new long[32][];
                                jArr5[i38] = jArr1114;
                                jArr4 = jArr1114;
                                z3 = true;
                            }
                            jArr4[i5] = jArr7;
                            this.spare = new long[32];
                        } else {
                            length = i18;
                        }
                        i4++;
                    }
                    if (z3) {
                        z10 = true;
                    } else {
                        z10 = true;
                    }
                    z4 &= z10;
                    i5++;
                    i32 = i32;
                    length3 = length3;
                    i29 = i29;
                    i3 = i3;
                    jArr = jArr;
                    z11 = z11;
                    i28 = 0;
                    int i41112 = i16;
                    i33 = i17;
                    i36 = i41112;
                } else {
                    jArr8 = null;
                }
                i10 = (i38 << 5) + i5;
                if (i32 != i10) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (z7) {
                }
                i11 = i10 << 5;
                if (z9) {
                    i12 = 32;
                } else {
                    i12 = i31;
                }
                if (!z7) {
                    jArr7 = this.spare;
                }
                if (z8) {
                    jArr9 = ZERO_BLOCK;
                } else {
                    jArr9 = jArr8;
                }
                if (z5) {
                    length3 = length3;
                    jArr10 = jArr7;
                    i29 = i29;
                    i3 = i3;
                    i32 = i32;
                    jArr = jArr;
                    i5 = i5;
                    if (z5) {
                        int i41113 = i33;
                        i16 = i36;
                        i17 = i41113;
                        i18 = length;
                        zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                    } else {
                        i13 = length;
                        i14 = i36;
                        i15 = i33;
                        if (i14 == i15) {
                            i16 = i14;
                            zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                            i17 = i15;
                            i18 = i13;
                        } else {
                            i16 = i14;
                            i17 = i15;
                            i18 = i13;
                            zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                            i19 = i12;
                            if (i19 != 32) {
                                zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                            } else {
                                zWord2 = zWord;
                            }
                        }
                        zIsZeroBlock = zWord2;
                        z5 = true;
                    }
                    jArr7 = jArr10;
                    if (zIsZeroBlock) {
                        zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                    }
                } else {
                    length3 = length3;
                    jArr10 = jArr7;
                    i29 = i29;
                    i3 = i3;
                    i32 = i32;
                    jArr = jArr;
                    i5 = i5;
                    if (z5) {
                        int i41114 = i33;
                        i16 = i36;
                        i17 = i41114;
                        i18 = length;
                        zIsZeroBlock = abstractStrategy.block(i11, 0, i12, jArr10, jArr9) & abstractStrategy.word(i11, i12, jArr10, jArr9, j2);
                    } else {
                        i13 = length;
                        i14 = i36;
                        i15 = i33;
                        if (i14 == i15) {
                            i16 = i14;
                            zWord2 = abstractStrategy.word(i11, i28, jArr10, jArr9, j & j2);
                            i17 = i15;
                            i18 = i13;
                        } else {
                            i16 = i14;
                            i17 = i15;
                            i18 = i13;
                            zWord = abstractStrategy.word(i11, i28, jArr10, jArr9, j) & abstractStrategy.block(i11, i28 + 1, i12, jArr10, jArr9);
                            i19 = i12;
                            if (i19 != 32) {
                                zWord2 = zWord & abstractStrategy.word(i11, i19, jArr10, jArr9, j2);
                            } else {
                                zWord2 = zWord;
                            }
                        }
                        zIsZeroBlock = zWord2;
                        z5 = true;
                    }
                    jArr7 = jArr10;
                    if (zIsZeroBlock) {
                        zIsZeroBlock = abstractStrategy.isZeroBlock(jArr7);
                    }
                }
                if (zIsZeroBlock) {
                    if (z3) {
                        jArr4[i5] = null;
                    }
                    length = i18;
                } else {
                    if (jArr7 == this.spare) {
                        if (i21 >= this.bitsLength) {
                            resize(i21);
                            long[][][] jArr1115 = this.bits;
                            length = jArr1115.length;
                            jArr5 = jArr1115;
                        } else {
                            length = i18;
                        }
                        if (jArr4 == null) {
                            long[][] jArr1116 = new long[32][];
                            jArr5[i38] = jArr1116;
                            jArr4 = jArr1116;
                            z3 = true;
                        }
                        jArr4[i5] = jArr7;
                        this.spare = new long[32];
                    } else {
                        length = i18;
                    }
                    i4++;
                }
                if (z3) {
                    z10 = true;
                } else {
                    z10 = true;
                }
                z4 &= z10;
                i5++;
                i32 = i32;
                length3 = length3;
                i29 = i29;
                i3 = i3;
                jArr = jArr;
                z11 = z11;
                i28 = 0;
                int i41115 = i16;
                i33 = i17;
                i36 = i41115;
            }
            i6 = length3;
            i7 = i29;
            i8 = i32;
            jArr6 = jArr;
            z6 = z11;
            i9 = i33;
            int i54 = length;
            if (i5 == 32) {
                i35++;
            } else {
                i35++;
            }
            i37 = i54;
            z15 = z5;
            jArr11 = jArr5;
            i34 = i4;
            z16 = z4;
            i38++;
            int i55 = i38 << 10;
            i20 = i38 << 16;
            if (i20 < 0) {
                i20 = Integer.MAX_VALUE;
            }
            i33 = i9;
            i32 = i8;
            length3 = i6;
            i29 = i7;
            jArr = jArr6;
            z11 = z6;
            i27 = 0;
            i36 = i55;
            i21 = i20;
            i22 = i2;
        }
        abstractStrategy.finish(i35, i34);
    }

    protected final void statisticsUpdate() {
        if (this.cache.hash != 0) {
            return;
        }
        setScanner(0, this.bitsLength, null, this.updateStrategy);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws InternalError, IOException {
        statisticsUpdate();
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.compactionCount);
        objectOutputStream.writeInt(this.cache.length);
        int i = this.cache.count;
        objectOutputStream.writeInt(i);
        long[][][] jArr = this.bits;
        int length = jArr.length;
        for (int i2 = 0; i2 != length; i2++) {
            long[][] jArr2 = jArr[i2];
            if (jArr2 != null) {
                for (int i3 = 0; i3 != 32; i3++) {
                    long[] jArr3 = jArr2[i3];
                    if (jArr3 != null) {
                        int i4 = (i2 << 10) + (i3 << 5);
                        for (int i5 = 0; i5 != 32; i5++) {
                            long j = jArr3[i5];
                            if (j != 0) {
                                objectOutputStream.writeInt(i4 + i5);
                                objectOutputStream.writeLong(j);
                                i--;
                            }
                        }
                    }
                }
            }
        }
        if (i != 0) {
            throw new InternalError("count of entries not consistent");
        }
        objectOutputStream.writeInt(this.cache.hash);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.compactionCount = objectInputStream.readInt();
        resize(objectInputStream.readInt());
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 != i; i2++) {
            int i3 = objectInputStream.readInt();
            int i4 = i3 & 31;
            int i5 = (i3 >> 5) & 31;
            int i6 = i3 >> 10;
            long j = objectInputStream.readLong();
            long[][][] jArr = this.bits;
            long[][] jArr2 = jArr[i6];
            if (jArr2 == null) {
                jArr2 = new long[32][];
                jArr[i6] = jArr2;
            }
            long[] jArr3 = jArr2[i5];
            if (jArr3 == null) {
                jArr3 = new long[32];
                jArr2[i5] = jArr3;
            }
            jArr3[i4] = j;
        }
        constructorHelper();
        statisticsUpdate();
        if (i != this.cache.count) {
            throw new InternalError("count of entries not consistent");
        }
        if (objectInputStream.readInt() != this.cache.hash) {
            throw new IOException("deserialized hashCode mis-match");
        }
    }

    protected class Cache {
        protected transient int a2Count;
        protected transient int a3Count;
        protected transient int cardinality;
        protected transient int count;
        protected transient int hash;
        protected transient int length;
        protected transient int size;

        protected Cache() {
        }
    }

    protected static abstract class AbstractStrategy {
        static final int F_OP_F_EQ_F = 1;
        static final int F_OP_X_EQ_F = 2;
        static final int X_OP_F_EQ_F = 4;
        static final int X_OP_F_EQ_X = 8;

        protected abstract boolean block(int i, int i2, int i3, long[] jArr, long[] jArr2);

        protected void finish(int i, int i2) {
        }

        protected abstract int properties();

        protected abstract boolean start(SparseBitSet sparseBitSet);

        protected abstract boolean word(int i, int i2, long[] jArr, long[] jArr2, long j);

        protected AbstractStrategy() {
        }

        protected final boolean isZeroBlock(long[] jArr) {
            for (long j : jArr) {
                if (j != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    protected static class AndStrategy extends AbstractStrategy {
        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected int properties() {
            return 7;
        }

        protected AndStrategy() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean start(SparseBitSet sparseBitSet) {
            sparseBitSet.getClass();
            return true;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean word(int i, int i2, long[] jArr, long[] jArr2, long j) {
            long j2 = ((~j) | jArr2[i2]) & jArr[i2];
            jArr[i2] = j2;
            return j2 == 0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean block(int i, int i2, int i3, long[] jArr, long[] jArr2) {
            boolean z = true;
            while (i2 != i3) {
                long j = jArr[i2] & jArr2[i2];
                jArr[i2] = j;
                z &= j == 0;
                i2++;
            }
            return z;
        }
    }

    protected static class AndNotStrategy extends AbstractStrategy {
        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected int properties() {
            return 11;
        }

        protected AndNotStrategy() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean start(SparseBitSet sparseBitSet) {
            sparseBitSet.getClass();
            return true;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean word(int i, int i2, long[] jArr, long[] jArr2, long j) {
            long j2 = (~(jArr2[i2] & j)) & jArr[i2];
            jArr[i2] = j2;
            return j2 == 0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean block(int i, int i2, int i3, long[] jArr, long[] jArr2) {
            boolean z = true;
            while (i2 != i3) {
                long j = jArr[i2] & (~jArr2[i2]);
                jArr[i2] = j;
                z &= j == 0;
                i2++;
            }
            return z;
        }
    }

    protected static class ClearStrategy extends AbstractStrategy {
        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected int properties() {
            return 3;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean start(SparseBitSet sparseBitSet) {
            return true;
        }

        protected ClearStrategy() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean word(int i, int i2, long[] jArr, long[] jArr2, long j) {
            long j2 = (~j) & jArr[i2];
            jArr[i2] = j2;
            return j2 == 0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean block(int i, int i2, int i3, long[] jArr, long[] jArr2) {
            if (i2 == 0 && i3 == 32) {
                return true;
            }
            while (i2 != i3) {
                jArr[i2] = 0;
                i2++;
            }
            return true;
        }
    }

    protected static class CopyStrategy extends AbstractStrategy {
        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected int properties() {
            return 5;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean start(SparseBitSet sparseBitSet) {
            return true;
        }

        protected CopyStrategy() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean word(int i, int i2, long[] jArr, long[] jArr2, long j) {
            long j2 = jArr2[i2] & j;
            jArr[i2] = j2;
            return j2 == 0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean block(int i, int i2, int i3, long[] jArr, long[] jArr2) {
            boolean z = true;
            while (i2 != i3) {
                long j = jArr2[i2];
                jArr[i2] = j;
                z &= j == 0;
                i2++;
            }
            return z;
        }
    }

    protected static class EqualsStrategy extends AbstractStrategy {
        boolean result;

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected int properties() {
            return 1;
        }

        protected EqualsStrategy() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean start(SparseBitSet sparseBitSet) {
            sparseBitSet.getClass();
            this.result = true;
            return false;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean word(int i, int i2, long[] jArr, long[] jArr2, long j) {
            long j2 = jArr[i2];
            this.result &= (j2 & j) == (jArr2[i2] & j);
            return j2 == 0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean block(int i, int i2, int i3, long[] jArr, long[] jArr2) {
            boolean z = true;
            while (i2 != i3) {
                long j = jArr[i2];
                boolean z2 = false;
                this.result &= j == jArr2[i2];
                if (j == 0) {
                    z2 = true;
                }
                z &= z2;
                i2++;
            }
            return z;
        }
    }

    protected static class FlipStrategy extends AbstractStrategy {
        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected int properties() {
            return 0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean start(SparseBitSet sparseBitSet) {
            return true;
        }

        protected FlipStrategy() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean word(int i, int i2, long[] jArr, long[] jArr2, long j) {
            long j2 = jArr[i2] ^ j;
            jArr[i2] = j2;
            return j2 == 0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean block(int i, int i2, int i3, long[] jArr, long[] jArr2) {
            boolean z = true;
            while (i2 != i3) {
                long j = ~jArr[i2];
                jArr[i2] = j;
                z &= j == 0;
                i2++;
            }
            return z;
        }
    }

    protected static class IntersectsStrategy extends AbstractStrategy {
        protected boolean result;

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected int properties() {
            return 3;
        }

        protected IntersectsStrategy() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean start(SparseBitSet sparseBitSet) {
            sparseBitSet.getClass();
            this.result = false;
            return false;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean word(int i, int i2, long[] jArr, long[] jArr2, long j) {
            long j2 = jArr[i2];
            this.result |= ((jArr2[i2] & j2) & j) != 0;
            return j2 == 0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean block(int i, int i2, int i3, long[] jArr, long[] jArr2) {
            boolean z = true;
            while (i2 != i3) {
                long j = jArr[i2];
                boolean z2 = false;
                this.result |= (jArr2[i2] & j) != 0;
                if (j == 0) {
                    z2 = true;
                }
                z &= z2;
                i2++;
            }
            return z;
        }
    }

    protected static class OrStrategy extends AbstractStrategy {
        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected int properties() {
            return 9;
        }

        protected OrStrategy() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean start(SparseBitSet sparseBitSet) {
            sparseBitSet.getClass();
            return true;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean word(int i, int i2, long[] jArr, long[] jArr2, long j) {
            long j2 = (jArr2[i2] & j) | jArr[i2];
            jArr[i2] = j2;
            return j2 == 0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean block(int i, int i2, int i3, long[] jArr, long[] jArr2) {
            boolean z = true;
            while (i2 != i3) {
                long j = jArr[i2] | jArr2[i2];
                jArr[i2] = j;
                z &= j == 0;
                i2++;
            }
            return z;
        }
    }

    protected static class SetStrategy extends AbstractStrategy {
        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected int properties() {
            return 0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean start(SparseBitSet sparseBitSet) {
            return true;
        }

        protected SetStrategy() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean word(int i, int i2, long[] jArr, long[] jArr2, long j) {
            jArr[i2] = jArr[i2] | j;
            return false;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean block(int i, int i2, int i3, long[] jArr, long[] jArr2) {
            while (i2 != i3) {
                jArr[i2] = -1;
                i2++;
            }
            return false;
        }
    }

    protected class UpdateStrategy extends AbstractStrategy {
        protected transient int cardinality;
        protected transient int count;
        protected transient long hash;
        protected transient int wMax;
        protected transient int wMin;
        protected transient long wordMax;
        protected transient long wordMin;

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected int properties() {
            return 3;
        }

        protected UpdateStrategy() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean start(SparseBitSet sparseBitSet) {
            this.hash = 1234L;
            this.wMin = -1;
            this.wordMin = 0L;
            this.wMax = 0;
            this.wordMax = 0L;
            this.count = 0;
            this.cardinality = 0;
            return false;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean word(int i, int i2, long[] jArr, long[] jArr2, long j) {
            long j2 = jArr[i2];
            long j3 = j2 & j;
            if (j3 != 0) {
                compute(i + i2, j3);
            }
            return j2 == 0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean block(int i, int i2, int i3, long[] jArr, long[] jArr2) {
            boolean z = true;
            for (int i4 = 0; i4 != i3; i4++) {
                long j = jArr[i4];
                if (j != 0) {
                    compute(i + i4, j);
                    z = false;
                }
            }
            return z;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected void finish(int i, int i2) {
            SparseBitSet.this.cache.a2Count = i;
            SparseBitSet.this.cache.a3Count = i2;
            SparseBitSet.this.cache.count = this.count;
            SparseBitSet.this.cache.cardinality = this.cardinality;
            SparseBitSet.this.cache.length = ((this.wMax + 1) * 64) - Long.numberOfLeadingZeros(this.wordMax);
            SparseBitSet.this.cache.size = (SparseBitSet.this.cache.length - (this.wMin * 64)) - Long.numberOfTrailingZeros(this.wordMin);
            Cache cache = SparseBitSet.this.cache;
            long j = this.hash;
            cache.hash = (int) (j ^ (j >> 32));
        }

        private void compute(int i, long j) {
            this.count++;
            this.hash ^= ((long) (i + 1)) * j;
            if (this.wMin < 0) {
                this.wMin = i;
                this.wordMin = j;
            }
            this.wMax = i;
            this.wordMax = j;
            this.cardinality += Long.bitCount(j);
        }
    }

    protected static class XorStrategy extends AbstractStrategy {
        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected int properties() {
            return 9;
        }

        protected XorStrategy() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean start(SparseBitSet sparseBitSet) {
            sparseBitSet.getClass();
            return true;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean word(int i, int i2, long[] jArr, long[] jArr2, long j) {
            long j2 = (jArr2[i2] & j) ^ jArr[i2];
            jArr[i2] = j2;
            return j2 == 0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.AbstractStrategy
        protected boolean block(int i, int i2, int i3, long[] jArr, long[] jArr2) {
            boolean z = true;
            while (i2 != i3) {
                long j = jArr[i2] ^ jArr2[i2];
                jArr[i2] = j;
                z &= j == 0;
                i2++;
            }
            return z;
        }
    }
}
