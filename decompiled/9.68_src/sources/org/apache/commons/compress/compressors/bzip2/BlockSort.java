package org.apache.commons.compress.compressors.bzip2;

import java.util.BitSet;
import kotlin.KotlinVersion;
import kotlin.UByte;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
class BlockSort {
    private static final int CLEARMASK = -2097153;
    private static final int DEPTH_THRESH = 10;
    private static final int FALLBACK_QSORT_SMALL_THRESH = 10;
    private static final int FALLBACK_QSORT_STACK_SIZE = 100;
    private static final int[] INCS = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
    private static final int QSORT_STACK_SIZE = 1000;
    private static final int SETMASK = 2097152;
    private static final int SMALL_THRESH = 20;
    private static final int STACK_SIZE = 1000;
    private static final int WORK_FACTOR = 30;
    private int[] eclass;
    private boolean firstAttempt;
    private final char[] quadrant;
    private int workDone;
    private int workLimit;
    private final int[] stack_ll = new int[1000];
    private final int[] stack_hh = new int[1000];
    private final int[] stack_dd = new int[1000];
    private final int[] mainSort_runningOrder = new int[CpioConstants.C_IRUSR];
    private final int[] mainSort_copy = new int[CpioConstants.C_IRUSR];
    private final boolean[] mainSort_bigDone = new boolean[CpioConstants.C_IRUSR];
    private final int[] ftab = new int[65537];

    private int fmin(int i, int i2) {
        return i < i2 ? i : i2;
    }

    private static byte med3(byte b, byte b2, byte b3) {
        if (b < b2) {
            if (b2 >= b3) {
                if (b >= b3) {
                    return b;
                }
                return b3;
            }
            return b2;
        }
        if (b2 <= b3) {
            if (b <= b3) {
                return b;
            }
            return b3;
        }
        return b2;
    }

    BlockSort(BZip2CompressorOutputStream.Data data) {
        this.quadrant = data.sfmap;
    }

    void blockSort(BZip2CompressorOutputStream.Data data, int i) {
        this.workLimit = i * 30;
        this.workDone = 0;
        this.firstAttempt = true;
        if (i + 1 < 10000) {
            fallbackSort(data, i);
        } else {
            mainSort(data, i);
            if (this.firstAttempt && this.workDone > this.workLimit) {
                fallbackSort(data, i);
            }
        }
        int[] iArr = data.fmap;
        data.origPtr = -1;
        for (int i2 = 0; i2 <= i; i2++) {
            if (iArr[i2] == 0) {
                data.origPtr = i2;
                return;
            }
        }
    }

    final void fallbackSort(BZip2CompressorOutputStream.Data data, int i) {
        int i2 = i + 1;
        data.block[0] = data.block[i2];
        fallbackSort(data.fmap, data.block, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            int[] iArr = data.fmap;
            iArr[i3] = iArr[i3] - 1;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (data.fmap[i4] == -1) {
                data.fmap[i4] = i;
                return;
            }
        }
    }

    private void fallbackSimpleSort(int[] iArr, int[] iArr2, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 - i > 3) {
            for (int i3 = i2 - 4; i3 >= i; i3--) {
                int i4 = iArr[i3];
                int i5 = iArr2[i4];
                int i6 = i3 + 4;
                while (i6 <= i2) {
                    int i7 = iArr[i6];
                    if (i5 <= iArr2[i7]) {
                        break;
                    }
                    iArr[i6 - 4] = i7;
                    i6 += 4;
                }
                iArr[i6 - 4] = i4;
            }
        }
        for (int i8 = i2 - 1; i8 >= i; i8--) {
            int i9 = iArr[i8];
            int i10 = iArr2[i9];
            int i11 = i8 + 1;
            while (i11 <= i2) {
                int i12 = iArr[i11];
                if (i10 <= iArr2[i12]) {
                    break;
                }
                iArr[i11 - 1] = i12;
                i11++;
            }
            iArr[i11 - 1] = i9;
        }
    }

    private void fswap(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    private void fvswap(int[] iArr, int i, int i2, int i3) {
        while (i3 > 0) {
            fswap(iArr, i, i2);
            i++;
            i2++;
            i3--;
        }
    }

    private void fpush(int i, int i2, int i3) {
        this.stack_ll[i] = i2;
        this.stack_hh[i] = i3;
    }

    private int[] fpop(int i) {
        return new int[]{this.stack_ll[i], this.stack_hh[i]};
    }

    private void fallbackQSort3(int[] iArr, int[] iArr2, int i, int i2) {
        int i3;
        boolean z;
        int[] iArr3 = iArr2;
        char c = 0;
        fpush(0, i, i2);
        long j = 0;
        int i4 = 1;
        long j2 = 0;
        int i5 = 1;
        while (i5 > 0) {
            int i6 = i5 - 1;
            int[] iArrFpop = fpop(i6);
            int i7 = iArrFpop[c];
            int i8 = iArrFpop[i4];
            if (i8 - i7 < 10) {
                fallbackSimpleSort(iArr, iArr3, i7, i8);
                i5 = i6;
            } else {
                j2 = ((j2 * 7621) + 1) % 32768;
                long j3 = j2 % 3;
                if (j3 == j) {
                    i3 = iArr3[iArr[i7]];
                } else if (j3 == 1) {
                    i3 = iArr3[iArr[(i7 + i8) >>> i4]];
                } else {
                    i3 = iArr3[iArr[i8]];
                }
                long j4 = i3;
                int i9 = i8;
                int i10 = i9;
                int i11 = i7;
                int i12 = i11;
                while (true) {
                    if (i12 <= i9) {
                        int i13 = iArr3[iArr[i12]] - ((int) j4);
                        if (i13 == 0) {
                            fswap(iArr, i12, i11);
                            i11++;
                            i12++;
                        } else {
                            if (i13 <= 0) {
                                z = true;
                                i12++;
                            }
                            iArr3 = iArr2;
                        }
                    }
                    while (i12 <= i9) {
                        int i14 = iArr3[iArr[i9]] - ((int) j4);
                        if (i14 == 0) {
                            fswap(iArr, i9, i10);
                            i10--;
                        } else if (i14 < 0) {
                            break;
                        }
                        i9--;
                        iArr3 = iArr2;
                    }
                    if (i12 > i9) {
                        break;
                    }
                    z = true;
                    fswap(iArr, i12, i9);
                    i12++;
                    i9--;
                    iArr3 = iArr2;
                }
                if (i10 < i11) {
                    iArr3 = iArr2;
                    i5 = i6;
                    c = 0;
                    j = 0;
                    i4 = 1;
                } else {
                    int iFmin = fmin(i11 - i7, i12 - i11);
                    fvswap(iArr, i7, i12 - iFmin, iFmin);
                    int i15 = i8 - i10;
                    int i16 = i10 - i9;
                    int iFmin2 = fmin(i15, i16);
                    fvswap(iArr, i9 + 1, (i8 - iFmin2) + 1, iFmin2);
                    int i17 = ((i12 + i7) - i11) - 1;
                    int i18 = (i8 - i16) + 1;
                    if (i17 - i7 > i8 - i18) {
                        fpush(i6, i7, i17);
                        fpush(i5, i18, i8);
                        i5++;
                    } else {
                        fpush(i6, i18, i8);
                        fpush(i5, i7, i17);
                        i5++;
                    }
                    iArr3 = iArr2;
                    i4 = 1;
                    c = 0;
                    j = 0;
                }
            }
        }
    }

    private int[] getEclass() {
        if (this.eclass == null) {
            this.eclass = new int[this.quadrant.length / 2];
        }
        return this.eclass;
    }

    final void fallbackSort(int[] iArr, byte[] bArr, int i) {
        int i2;
        int[] iArr2 = new int[TarConstants.MAGIC_OFFSET];
        int[] eclass = getEclass();
        for (int i3 = 0; i3 < i; i3++) {
            eclass[i3] = 0;
        }
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = bArr[i4] & UByte.MAX_VALUE;
            iArr2[i5] = iArr2[i5] + 1;
        }
        for (int i6 = 1; i6 < 257; i6++) {
            iArr2[i6] = iArr2[i6] + iArr2[i6 - 1];
        }
        for (int i7 = 0; i7 < i; i7++) {
            int i8 = bArr[i7] & UByte.MAX_VALUE;
            int i9 = iArr2[i8] - 1;
            iArr2[i8] = i9;
            iArr[i9] = i7;
        }
        BitSet bitSet = new BitSet(i + 64);
        for (int i10 = 0; i10 < 256; i10++) {
            bitSet.set(iArr2[i10]);
        }
        for (int i11 = 0; i11 < 32; i11++) {
            int i12 = (i11 * 2) + i;
            bitSet.set(i12);
            bitSet.clear(i12 + 1);
        }
        int i13 = 1;
        do {
            int i14 = 0;
            for (int i15 = 0; i15 < i; i15++) {
                if (bitSet.get(i15)) {
                    i14 = i15;
                }
                int i16 = iArr[i15] - i13;
                if (i16 < 0) {
                    i16 += i;
                }
                eclass[i16] = i14;
            }
            int iNextSetBit = -1;
            i2 = 0;
            while (true) {
                int iNextClearBit = bitSet.nextClearBit(iNextSetBit + 1);
                int i17 = iNextClearBit - 1;
                if (i17 >= i || (iNextSetBit = bitSet.nextSetBit(iNextClearBit + 1) - 1) >= i) {
                    break;
                }
                if (iNextSetBit > i17) {
                    i2 += (iNextSetBit - i17) + 1;
                    fallbackQSort3(iArr, eclass, i17, iNextSetBit);
                    int i18 = -1;
                    while (i17 <= iNextSetBit) {
                        int i19 = eclass[iArr[i17]];
                        if (i18 != i19) {
                            bitSet.set(i17);
                            i18 = i19;
                        }
                        i17++;
                    }
                }
            }
            i13 *= 2;
            if (i13 > i) {
                return;
            }
        } while (i2 != 0);
    }

    private boolean mainSimpleSort(BZip2CompressorOutputStream.Data data, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = (i2 - i) + 1;
        if (i10 < 2) {
            return this.firstAttempt && this.workDone > this.workLimit;
        }
        int i11 = 0;
        while (INCS[i11] < i10) {
            i11++;
        }
        int[] iArr = data.fmap;
        char[] cArr = this.quadrant;
        byte[] bArr = data.block;
        int i12 = i4 + 1;
        boolean z = this.firstAttempt;
        int i13 = this.workLimit;
        int i14 = this.workDone;
        loop1: while (true) {
            i11--;
            if (i11 < 0) {
                break;
            }
            int i15 = INCS[i11];
            int i16 = i + i15;
            int i17 = i16 - 1;
            while (i16 <= i2) {
                int i18 = 3;
                while (i16 <= i2) {
                    int i19 = i18 - 1;
                    if (i19 < 0) {
                        break;
                    }
                    int i20 = iArr[i16];
                    int i21 = i20 + i3;
                    int i22 = i16;
                    boolean z2 = false;
                    int i23 = 0;
                    while (true) {
                        if (z2) {
                            iArr[i22] = i23;
                            i9 = i22 - i15;
                            if (i9 <= i17) {
                                i8 = i11;
                                i6 = i15;
                                i5 = i17;
                                i7 = i19;
                                break;
                            }
                            i22 = i9;
                        } else {
                            z2 = true;
                        }
                        int i24 = iArr[i22 - i15];
                        int i25 = i24 + i3;
                        byte b = bArr[i25 + 1];
                        byte b2 = bArr[i21 + 1];
                        if (b != b2) {
                            i8 = i11;
                            i6 = i15;
                            i5 = i17;
                            i7 = i19;
                            if ((b & UByte.MAX_VALUE) <= (b2 & UByte.MAX_VALUE)) {
                                i9 = i22;
                                break;
                                break;
                            }
                            i23 = i24;
                            i11 = i8;
                            i19 = i7;
                            i15 = i6;
                            i17 = i5;
                        } else {
                            byte b3 = bArr[i25 + 2];
                            byte b4 = bArr[i21 + 2];
                            if (b3 != b4) {
                                i8 = i11;
                                i6 = i15;
                                i5 = i17;
                                i7 = i19;
                                if ((b3 & UByte.MAX_VALUE) <= (b4 & UByte.MAX_VALUE)) {
                                    i9 = i22;
                                    break;
                                    break;
                                }
                                i23 = i24;
                                i11 = i8;
                                i19 = i7;
                                i15 = i6;
                                i17 = i5;
                            } else {
                                byte b5 = bArr[i25 + 3];
                                byte b6 = bArr[i21 + 3];
                                if (b5 != b6) {
                                    i8 = i11;
                                    i6 = i15;
                                    i5 = i17;
                                    i7 = i19;
                                    if ((b5 & UByte.MAX_VALUE) <= (b6 & UByte.MAX_VALUE)) {
                                        i9 = i22;
                                        break;
                                        break;
                                    }
                                    i23 = i24;
                                    i11 = i8;
                                    i19 = i7;
                                    i15 = i6;
                                    i17 = i5;
                                } else {
                                    byte b7 = bArr[i25 + 4];
                                    byte b8 = bArr[i21 + 4];
                                    if (b7 != b8) {
                                        i8 = i11;
                                        i6 = i15;
                                        i5 = i17;
                                        i7 = i19;
                                        if ((b7 & UByte.MAX_VALUE) <= (b8 & UByte.MAX_VALUE)) {
                                            i9 = i22;
                                            break;
                                            break;
                                        }
                                        i23 = i24;
                                        i11 = i8;
                                        i19 = i7;
                                        i15 = i6;
                                        i17 = i5;
                                    } else {
                                        byte b9 = bArr[i25 + 5];
                                        byte b10 = bArr[i21 + 5];
                                        if (b9 != b10) {
                                            i8 = i11;
                                            i6 = i15;
                                            i5 = i17;
                                            i7 = i19;
                                            if ((b9 & UByte.MAX_VALUE) <= (b10 & UByte.MAX_VALUE)) {
                                                i9 = i22;
                                                break;
                                                break;
                                            }
                                            i23 = i24;
                                            i11 = i8;
                                            i19 = i7;
                                            i15 = i6;
                                            i17 = i5;
                                        } else {
                                            int i26 = i25 + 6;
                                            byte b11 = bArr[i26];
                                            int i27 = i21 + 6;
                                            i8 = i11;
                                            byte b12 = bArr[i27];
                                            if (b11 != b12) {
                                                i6 = i15;
                                                i5 = i17;
                                                i7 = i19;
                                                if ((b11 & UByte.MAX_VALUE) <= (b12 & UByte.MAX_VALUE)) {
                                                    i9 = i22;
                                                    break;
                                                    break;
                                                }
                                                i23 = i24;
                                                i11 = i8;
                                                i19 = i7;
                                                i15 = i6;
                                                i17 = i5;
                                            } else {
                                                int i28 = i4;
                                                while (true) {
                                                    if (i28 > 0) {
                                                        int i29 = i28 - 4;
                                                        int i30 = i26 + 1;
                                                        byte b13 = bArr[i30];
                                                        int i31 = i27 + 1;
                                                        i6 = i15;
                                                        byte b14 = bArr[i31];
                                                        if (b13 == b14) {
                                                            char c = cArr[i26];
                                                            char c2 = cArr[i27];
                                                            if (c == c2) {
                                                                int i32 = i26 + 2;
                                                                byte b15 = bArr[i32];
                                                                int i33 = i27 + 2;
                                                                i5 = i17;
                                                                byte b16 = bArr[i33];
                                                                if (b15 == b16) {
                                                                    char c3 = cArr[i30];
                                                                    char c4 = cArr[i31];
                                                                    if (c3 == c4) {
                                                                        int i34 = i26 + 3;
                                                                        byte b17 = bArr[i34];
                                                                        int i35 = i27 + 3;
                                                                        i7 = i19;
                                                                        byte b18 = bArr[i35];
                                                                        if (b17 == b18) {
                                                                            char c5 = cArr[i32];
                                                                            char c6 = cArr[i33];
                                                                            if (c5 == c6) {
                                                                                int i36 = i26 + 4;
                                                                                byte b19 = bArr[i36];
                                                                                i27 += 4;
                                                                                byte b20 = bArr[i27];
                                                                                if (b19 == b20) {
                                                                                    char c7 = cArr[i34];
                                                                                    char c8 = cArr[i35];
                                                                                    if (c7 == c8) {
                                                                                        if (i36 >= i12) {
                                                                                            i36 -= i12;
                                                                                        }
                                                                                        i26 = i36;
                                                                                        if (i27 >= i12) {
                                                                                            i27 -= i12;
                                                                                        }
                                                                                        i14++;
                                                                                        i28 = i29;
                                                                                        i19 = i7;
                                                                                        i15 = i6;
                                                                                        i17 = i5;
                                                                                    } else if (c7 > c8) {
                                                                                        i23 = i24;
                                                                                        i11 = i8;
                                                                                        i19 = i7;
                                                                                        i15 = i6;
                                                                                        i17 = i5;
                                                                                    }
                                                                                } else if ((b19 & UByte.MAX_VALUE) > (b20 & UByte.MAX_VALUE)) {
                                                                                    i23 = i24;
                                                                                    i11 = i8;
                                                                                    i19 = i7;
                                                                                    i15 = i6;
                                                                                    i17 = i5;
                                                                                }
                                                                            } else if (c5 > c6) {
                                                                                i23 = i24;
                                                                                i11 = i8;
                                                                                i19 = i7;
                                                                                i15 = i6;
                                                                                i17 = i5;
                                                                            }
                                                                        } else if ((b17 & UByte.MAX_VALUE) > (b18 & UByte.MAX_VALUE)) {
                                                                            i23 = i24;
                                                                            i11 = i8;
                                                                            i19 = i7;
                                                                            i15 = i6;
                                                                            i17 = i5;
                                                                        }
                                                                    } else {
                                                                        i7 = i19;
                                                                        if (c3 > c4) {
                                                                            i23 = i24;
                                                                            i11 = i8;
                                                                            i19 = i7;
                                                                            i15 = i6;
                                                                            i17 = i5;
                                                                        }
                                                                    }
                                                                } else {
                                                                    i7 = i19;
                                                                    if ((b15 & UByte.MAX_VALUE) > (b16 & UByte.MAX_VALUE)) {
                                                                        i23 = i24;
                                                                        i11 = i8;
                                                                        i19 = i7;
                                                                        i15 = i6;
                                                                        i17 = i5;
                                                                    }
                                                                }
                                                            } else {
                                                                i5 = i17;
                                                                i7 = i19;
                                                                if (c > c2) {
                                                                    i23 = i24;
                                                                    i11 = i8;
                                                                    i19 = i7;
                                                                    i15 = i6;
                                                                    i17 = i5;
                                                                }
                                                            }
                                                        } else {
                                                            i5 = i17;
                                                            i7 = i19;
                                                            if ((b13 & UByte.MAX_VALUE) > (b14 & UByte.MAX_VALUE)) {
                                                                i23 = i24;
                                                                i11 = i8;
                                                                i19 = i7;
                                                                i15 = i6;
                                                                i17 = i5;
                                                            }
                                                        }
                                                    } else {
                                                        i6 = i15;
                                                        i5 = i17;
                                                        i7 = i19;
                                                    }
                                                    i9 = i22;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    iArr[i9] = i20;
                    i16++;
                    i11 = i8;
                    i18 = i7;
                    i15 = i6;
                    i17 = i5;
                }
                int i37 = i11;
                int i38 = i15;
                int i39 = i17;
                if (z && i16 <= i2 && i14 > i13) {
                    break loop1;
                }
                i11 = i37;
                i15 = i38;
                i17 = i39;
            }
        }
        this.workDone = i14;
        return z && i14 > i13;
    }

    private static void vswap(int[] iArr, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            int i5 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i5;
            i2++;
            i++;
        }
    }

    private void mainQSort3(BZip2CompressorOutputStream.Data data, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        int i6;
        int[] iArr = this.stack_ll;
        int[] iArr2 = this.stack_hh;
        int[] iArr3 = this.stack_dd;
        int[] iArr4 = data.fmap;
        byte[] bArr = data.block;
        iArr[0] = i;
        iArr2[0] = i2;
        iArr3[0] = i3;
        boolean z2 = true;
        int i7 = 1;
        while (true) {
            int i8 = i7 - 1;
            if (i8 < 0) {
                return;
            }
            int i9 = iArr[i8];
            int i10 = iArr2[i8];
            int i11 = iArr3[i8];
            if (i10 - i9 < 20 || i11 > 10) {
                z = z2;
                if (mainSimpleSort(data, i9, i10, i11, i4)) {
                    return;
                } else {
                    i7 = i8;
                }
            } else {
                int i12 = i11 + 1;
                int iMed3 = med3(bArr[iArr4[i9] + i12], bArr[iArr4[i10] + i12], bArr[iArr4[(i9 + i10) >>> 1] + i12]) & UByte.MAX_VALUE;
                int i13 = i9;
                int i14 = i13;
                int i15 = i10;
                int i16 = i15;
                while (true) {
                    if (i14 <= i15) {
                        int i17 = iArr4[i14];
                        int i18 = (bArr[i17 + i12] & UByte.MAX_VALUE) - iMed3;
                        if (i18 == 0) {
                            iArr4[i14] = iArr4[i13];
                            iArr4[i13] = i17;
                            i13++;
                            i14++;
                        } else if (i18 < 0) {
                            i14++;
                        }
                    }
                    i5 = i16;
                    while (true) {
                        if (i14 > i15) {
                            i6 = i7;
                            break;
                        }
                        int i19 = iArr4[i15];
                        i6 = i7;
                        int i20 = (bArr[i19 + i12] & UByte.MAX_VALUE) - iMed3;
                        if (i20 != 0) {
                            if (i20 <= 0) {
                                break;
                            } else {
                                i15--;
                            }
                        } else {
                            iArr4[i15] = iArr4[i5];
                            iArr4[i5] = i19;
                            i5--;
                            i15--;
                        }
                        i7 = i6;
                    }
                    if (i14 > i15) {
                        break;
                    }
                    int i21 = iArr4[i14];
                    iArr4[i14] = iArr4[i15];
                    iArr4[i15] = i21;
                    i7 = i6;
                    i15--;
                    i14++;
                    i16 = i5;
                }
                if (i5 < i13) {
                    iArr[i8] = i9;
                    iArr2[i8] = i10;
                    iArr3[i8] = i12;
                    i7 = i6;
                    z = true;
                } else {
                    int i22 = i13 - i9;
                    int i23 = i14 - i13;
                    if (i22 >= i23) {
                        i22 = i23;
                    }
                    vswap(iArr4, i9, i14 - i22, i22);
                    int i24 = i10 - i5;
                    int i25 = i5 - i15;
                    if (i24 >= i25) {
                        i24 = i25;
                    }
                    z = true;
                    vswap(iArr4, i14, (i10 - i24) + 1, i24);
                    int i26 = (i14 + i9) - i13;
                    int i27 = i10 - i25;
                    iArr[i8] = i9;
                    iArr2[i8] = i26 - 1;
                    iArr3[i8] = i11;
                    iArr[i6] = i26;
                    iArr2[i6] = i27;
                    iArr3[i6] = i12;
                    int i28 = i6 + 1;
                    iArr[i28] = i27 + 1;
                    iArr2[i28] = i10;
                    iArr3[i28] = i11;
                    i7 = i6 + 2;
                }
            }
            z2 = z;
        }
    }

    final void mainSort(BZip2CompressorOutputStream.Data data, int i) {
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int[] iArr2 = this.mainSort_runningOrder;
        int[] iArr3 = this.mainSort_copy;
        boolean[] zArr = this.mainSort_bigDone;
        int[] iArr4 = this.ftab;
        byte[] bArr = data.block;
        int[] iArr5 = data.fmap;
        char[] cArr = this.quadrant;
        int i7 = this.workLimit;
        boolean z = this.firstAttempt;
        int i8 = 65537;
        while (true) {
            i8--;
            if (i8 < 0) {
                break;
            } else {
                iArr4[i8] = 0;
            }
        }
        for (int i9 = 0; i9 < 20; i9++) {
            bArr[i + i9 + 2] = bArr[(i9 % (i + 1)) + 1];
        }
        int i10 = i + 21;
        while (true) {
            i10--;
            if (i10 < 0) {
                break;
            } else {
                cArr[i10] = 0;
            }
        }
        int i11 = i + 1;
        byte b = bArr[i11];
        bArr[0] = b;
        int i12 = KotlinVersion.MAX_COMPONENT_VALUE;
        int i13 = b & UByte.MAX_VALUE;
        int i14 = 0;
        while (i14 <= i) {
            i14++;
            int i15 = bArr[i14] & UByte.MAX_VALUE;
            int i16 = (i13 << 8) + i15;
            iArr4[i16] = iArr4[i16] + 1;
            i13 = i15;
        }
        for (int i17 = 1; i17 <= 65536; i17++) {
            iArr4[i17] = iArr4[i17] + iArr4[i17 - 1];
        }
        boolean z2 = true;
        int i18 = bArr[1] & UByte.MAX_VALUE;
        int i19 = 0;
        while (i19 < i) {
            int i20 = bArr[i19 + 2] & UByte.MAX_VALUE;
            int i21 = (i18 << 8) + i20;
            int i22 = iArr4[i21] - 1;
            iArr4[i21] = i22;
            iArr5[i22] = i19;
            i19++;
            i18 = i20;
            z2 = true;
        }
        int i23 = ((bArr[i11] & UByte.MAX_VALUE) << 8) + (bArr[z2 ? 1 : 0] & UByte.MAX_VALUE);
        int i24 = iArr4[i23] - 1;
        iArr4[i23] = i24;
        iArr5[i24] = i;
        int i25 = 256;
        while (true) {
            i25--;
            if (i25 < 0) {
                break;
            }
            zArr[i25] = false;
            iArr2[i25] = i25;
        }
        int i26 = 364;
        while (i26 != 1) {
            i26 /= 3;
            int i27 = i26;
            while (i27 <= i12) {
                int i28 = iArr2[i27];
                int i29 = iArr4[(i28 + 1) << 8] - iArr4[i28 << 8];
                int i30 = i26 - 1;
                int i31 = iArr2[i27 - i26];
                int i32 = i27;
                while (true) {
                    i6 = i7;
                    if (iArr4[(i31 + 1) << 8] - iArr4[i31 << 8] <= i29) {
                        break;
                    }
                    iArr2[i32] = i31;
                    int i33 = i32 - i26;
                    if (i33 <= i30) {
                        i32 = i33;
                        break;
                    } else {
                        i31 = iArr2[i33 - i26];
                        i32 = i33;
                        i7 = i6;
                    }
                }
                iArr2[i32] = i28;
                i27++;
                i7 = i6;
                i12 = KotlinVersion.MAX_COMPONENT_VALUE;
            }
        }
        int i34 = i7;
        int i35 = 0;
        while (i35 <= i12) {
            int i36 = iArr2[i35];
            int i37 = 0;
            while (i37 <= i12) {
                int i38 = (i36 << 8) + i37;
                int i39 = iArr4[i38];
                if ((i39 & SETMASK) != SETMASK) {
                    int i40 = i39 & CLEARMASK;
                    int i41 = (iArr4[i38 + 1] & CLEARMASK) - 1;
                    if (i41 > i40) {
                        i5 = SETMASK;
                        i2 = i37;
                        i3 = i34;
                        iArr = iArr2;
                        i4 = i35;
                        mainQSort3(data, i40, i41, 2, i);
                        if (z && this.workDone > i3) {
                            return;
                        }
                    } else {
                        i2 = i37;
                        i3 = i34;
                        i5 = SETMASK;
                        iArr = iArr2;
                        i4 = i35;
                    }
                    iArr4[i38] = i39 | i5;
                } else {
                    i2 = i37;
                    i3 = i34;
                    iArr = iArr2;
                    i4 = i35;
                }
                i37 = i2 + 1;
                i35 = i4;
                iArr2 = iArr;
                i12 = KotlinVersion.MAX_COMPONENT_VALUE;
                i34 = i3;
            }
            int i42 = i34;
            int[] iArr6 = iArr2;
            int i43 = i35;
            int i44 = 0;
            for (int i45 = i12; i44 <= i45; i45 = KotlinVersion.MAX_COMPONENT_VALUE) {
                iArr3[i44] = iArr4[(i44 << 8) + i36] & CLEARMASK;
                i44++;
            }
            int i46 = i36 << 8;
            int i47 = iArr4[i46] & CLEARMASK;
            int i48 = (i36 + 1) << 8;
            int i49 = iArr4[i48] & CLEARMASK;
            while (i47 < i49) {
                int i50 = iArr5[i47];
                int i51 = i49;
                int i52 = bArr[i50] & KotlinVersion.MAX_COMPONENT_VALUE;
                if (!zArr[i52]) {
                    iArr5[iArr3[i52]] = i50 == 0 ? i : i50 - 1;
                    iArr3[i52] = iArr3[i52] + 1;
                }
                i47++;
                i49 = i51;
            }
            int i53 = 256;
            while (true) {
                i53--;
                if (i53 < 0) {
                    break;
                }
                int i54 = (i53 << 8) + i36;
                iArr4[i54] = iArr4[i54] | SETMASK;
            }
            zArr[i36] = true;
            if (i43 < 255) {
                int i55 = iArr4[i46] & CLEARMASK;
                int i56 = (CLEARMASK & iArr4[i48]) - i55;
                int i57 = 0;
                while ((i56 >> i57) > 65534) {
                    i57++;
                }
                int i58 = 0;
                while (i58 < i56) {
                    int i59 = iArr5[i55 + i58];
                    char c = (char) (i58 >> i57);
                    cArr[i59] = c;
                    int i60 = i55;
                    if (i59 < 20) {
                        cArr[i59 + i + 1] = c;
                    }
                    i58++;
                    i55 = i60;
                }
            }
            i35 = i43 + 1;
            iArr2 = iArr6;
            i12 = KotlinVersion.MAX_COMPONENT_VALUE;
            i34 = i42;
        }
    }
}
