package kotlin.time;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: longSaturatedMath.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\b\u001a\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a%\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\b¨\u0006\u001d"}, d2 = {"saturatingAdd", "", "value", "unit", "Lkotlin/time/DurationUnit;", XmlErrorCodes.DURATION, "Lkotlin/time/Duration;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "checkInfiniteSumDefined", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "infinityOfSign", "(J)J", "saturatingDiff", "valueNs", IFramePlayerOptions.Builder.ORIGIN, "(JJLkotlin/time/DurationUnit;)J", "saturatingOriginsDiff", "origin1", "origin2", "saturatingFiniteDiff", "value1", "value2", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LongSaturatedMathKt {
    public static final boolean isSaturated(long j) {
        return ((j - 1) | 1) == LongCompanionObject.MAX_VALUE;
    }

    /* JADX INFO: renamed from: saturatingAdd-NuflL3o, reason: not valid java name */
    public static final long m6709saturatingAddNuflL3o(long j, DurationUnit unit, long j2) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long jM6649toLongimpl = Duration.m6649toLongimpl(j2, unit);
        if (((j - 1) | 1) == LongCompanionObject.MAX_VALUE) {
            return m6708checkInfiniteSumDefinedPjuGub4(j, j2, jM6649toLongimpl);
        }
        if ((1 | (jM6649toLongimpl - 1)) == LongCompanionObject.MAX_VALUE) {
            return m6710saturatingAddInHalvesNuflL3o(j, unit, j2);
        }
        long j3 = j + jM6649toLongimpl;
        if (((j ^ j3) & (jM6649toLongimpl ^ j3)) >= 0) {
            return j3;
        }
        if (j < 0) {
            return Long.MIN_VALUE;
        }
        return LongCompanionObject.MAX_VALUE;
    }

    /* JADX INFO: renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m6708checkInfiniteSumDefinedPjuGub4(long j, long j2, long j3) {
        if (!Duration.m6635isInfiniteimpl(j2) || (j ^ j3) >= 0) {
            return j;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    /* JADX INFO: renamed from: saturatingAddInHalves-NuflL3o, reason: not valid java name */
    private static final long m6710saturatingAddInHalvesNuflL3o(long j, DurationUnit durationUnit, long j2) {
        long jM6613divUwyO8pc = Duration.m6613divUwyO8pc(j2, 2);
        long jM6649toLongimpl = Duration.m6649toLongimpl(jM6613divUwyO8pc, durationUnit);
        return (1 | (jM6649toLongimpl - 1)) == LongCompanionObject.MAX_VALUE ? jM6649toLongimpl : m6709saturatingAddNuflL3o(m6709saturatingAddNuflL3o(j, durationUnit, jM6613divUwyO8pc), durationUnit, Duration.m6638minusLRDsOJo(j2, jM6613divUwyO8pc));
    }

    private static final long infinityOfSign(long j) {
        return j < 0 ? Duration.INSTANCE.m6700getNEG_INFINITEUwyO8pc$kotlin_stdlib() : Duration.INSTANCE.m6699getINFINITEUwyO8pc();
    }

    public static final long saturatingDiff(long j, long j2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if ((1 | (j2 - 1)) == LongCompanionObject.MAX_VALUE) {
            return Duration.m6654unaryMinusUwyO8pc(infinityOfSign(j2));
        }
        return saturatingFiniteDiff(j, j2, unit);
    }

    public static final long saturatingOriginsDiff(long j, long j2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (((j2 - 1) | 1) == LongCompanionObject.MAX_VALUE) {
            if (j == j2) {
                return Duration.INSTANCE.m6701getZEROUwyO8pc();
            }
            return Duration.m6654unaryMinusUwyO8pc(infinityOfSign(j2));
        }
        if ((1 | (j - 1)) == LongCompanionObject.MAX_VALUE) {
            return infinityOfSign(j);
        }
        return saturatingFiniteDiff(j, j2, unit);
    }

    private static final long saturatingFiniteDiff(long j, long j2, DurationUnit durationUnit) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) < 0) {
            if (durationUnit.compareTo(DurationUnit.MILLISECONDS) < 0) {
                long jConvertDurationUnit = DurationUnitKt.convertDurationUnit(1L, DurationUnit.MILLISECONDS, durationUnit);
                long j4 = (j / jConvertDurationUnit) - (j2 / jConvertDurationUnit);
                long j5 = (j % jConvertDurationUnit) - (j2 % jConvertDurationUnit);
                Duration.Companion companion = Duration.INSTANCE;
                return Duration.m6639plusLRDsOJo(DurationKt.toDuration(j4, DurationUnit.MILLISECONDS), DurationKt.toDuration(j5, durationUnit));
            }
            return Duration.m6654unaryMinusUwyO8pc(infinityOfSign(j3));
        }
        return DurationKt.toDuration(j3, durationUnit);
    }
}
