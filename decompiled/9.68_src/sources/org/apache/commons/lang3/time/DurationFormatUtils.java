package org.apache.commons.lang3.time;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.TimeZone;
import java.util.function.Predicate;
import java.util.stream.Stream;
import kotlin.jvm.internal.LongCompanionObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DurationFormatUtils {
    static final String H = "H";
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";
    static final String M = "M";
    static final String S = "S";
    static final String d = "d";
    static final String m = "m";
    static final String s = "s";
    static final String y = "y";

    public static String formatDurationHMS(long j) {
        return formatDuration(j, "HH:mm:ss.SSS");
    }

    public static String formatDurationISO(long j) {
        return formatDuration(j, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDuration(long j, String str) {
        return formatDuration(j, str, true);
    }

    public static String formatDuration(long j, String str, boolean z) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        Validate.inclusiveBetween(0L, LongCompanionObject.MAX_VALUE, j, "durationMillis must not be negative");
        Token[] tokenArrLexx = lexx(str);
        if (Token.containsTokenWithValue(tokenArrLexx, d)) {
            long j8 = j / DateUtils.MILLIS_PER_DAY;
            j2 = j - (DateUtils.MILLIS_PER_DAY * j8);
            j3 = j8;
        } else {
            j2 = j;
            j3 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, H)) {
            long j9 = j2 / DateUtils.MILLIS_PER_HOUR;
            j2 -= DateUtils.MILLIS_PER_HOUR * j9;
            j4 = j9;
        } else {
            j4 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, m)) {
            long j10 = j2 / DateUtils.MILLIS_PER_MINUTE;
            j2 -= DateUtils.MILLIS_PER_MINUTE * j10;
            j5 = j10;
        } else {
            j5 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, s)) {
            long j11 = j2 / 1000;
            j7 = j2 - (1000 * j11);
            j6 = j11;
        } else {
            j6 = 0;
            j7 = j2;
        }
        return format(tokenArrLexx, 0L, 0L, j3, j4, j5, j6, j7, z);
    }

    public static String formatDurationWords(long j, boolean z, boolean z2) {
        String duration = formatDuration(j, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z) {
            duration = StringUtils.SPACE + duration;
            String strReplaceOnce = StringUtils.replaceOnce(duration, " 0 days", "");
            if (strReplaceOnce.length() != duration.length()) {
                String strReplaceOnce2 = StringUtils.replaceOnce(strReplaceOnce, " 0 hours", "");
                duration = strReplaceOnce2.length() != strReplaceOnce.length() ? StringUtils.replaceOnce(strReplaceOnce2, " 0 minutes", "") : strReplaceOnce;
            }
            if (!duration.isEmpty()) {
                duration = duration.substring(1);
            }
        }
        if (z2) {
            String strReplaceOnce3 = StringUtils.replaceOnce(duration, " 0 seconds", "");
            if (strReplaceOnce3.length() != duration.length()) {
                duration = StringUtils.replaceOnce(strReplaceOnce3, " 0 minutes", "");
                if (duration.length() != strReplaceOnce3.length()) {
                    String strReplaceOnce4 = StringUtils.replaceOnce(duration, " 0 hours", "");
                    if (strReplaceOnce4.length() != duration.length()) {
                        duration = StringUtils.replaceOnce(strReplaceOnce4, " 0 days", "");
                    }
                } else {
                    duration = strReplaceOnce3;
                }
            }
        }
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.SPACE + duration, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriodISO(long j, long j2) {
        return formatPeriod(j, j2, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    public static String formatPeriod(long j, long j2, String str) {
        return formatPeriod(j, j2, str, true, TimeZone.getDefault());
    }

    public static String formatPeriod(long j, long j2, String str, boolean z, TimeZone timeZone) {
        int i = 0;
        Validate.isTrue(j <= j2, "startMillis must not be greater than endMillis", new Object[0]);
        Token[] tokenArrLexx = lexx(str);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(j));
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(new Date(j2));
        int i2 = calendar2.get(14) - calendar.get(14);
        int i3 = calendar2.get(13) - calendar.get(13);
        int i4 = calendar2.get(12) - calendar.get(12);
        int i5 = calendar2.get(11) - calendar.get(11);
        int actualMaximum = calendar2.get(5) - calendar.get(5);
        int i6 = calendar2.get(2) - calendar.get(2);
        int i7 = calendar2.get(1) - calendar.get(1);
        while (i2 < 0) {
            i2 += 1000;
            i3--;
        }
        while (i3 < 0) {
            i3 += 60;
            i4--;
        }
        while (i4 < 0) {
            i4 += 60;
            i5--;
        }
        while (i5 < 0) {
            i5 += 24;
            actualMaximum--;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, M)) {
            while (actualMaximum < 0) {
                actualMaximum += calendar.getActualMaximum(5);
                i6--;
                calendar.add(2, 1);
            }
            while (i6 < 0) {
                i6 += 12;
                i7--;
            }
            if (!Token.containsTokenWithValue(tokenArrLexx, y) && i7 != 0) {
                while (i7 != 0) {
                    i6 += i7 * 12;
                    i7 = 0;
                }
            }
        } else {
            if (!Token.containsTokenWithValue(tokenArrLexx, y)) {
                int i8 = calendar2.get(1);
                if (i6 < 0) {
                    i8--;
                }
                while (calendar.get(1) != i8) {
                    int actualMaximum2 = actualMaximum + (calendar.getActualMaximum(6) - calendar.get(6));
                    if ((calendar instanceof GregorianCalendar) && calendar.get(2) == 1 && calendar.get(5) == 29) {
                        actualMaximum2++;
                    }
                    calendar.add(1, 1);
                    actualMaximum = actualMaximum2 + calendar.get(6);
                }
                i7 = 0;
            }
            while (calendar.get(2) != calendar2.get(2)) {
                actualMaximum += calendar.getActualMaximum(5);
                calendar.add(2, 1);
            }
            i6 = 0;
            while (actualMaximum < 0) {
                actualMaximum += calendar.getActualMaximum(5);
                i6--;
                calendar.add(2, 1);
            }
        }
        if (!Token.containsTokenWithValue(tokenArrLexx, d)) {
            i5 += actualMaximum * 24;
            actualMaximum = 0;
        }
        if (!Token.containsTokenWithValue(tokenArrLexx, H)) {
            i4 += i5 * 60;
            i5 = 0;
        }
        if (!Token.containsTokenWithValue(tokenArrLexx, m)) {
            i3 += i4 * 60;
            i4 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, s)) {
            i = i3;
        } else {
            i2 += i3 * 1000;
        }
        return format(tokenArrLexx, i7, i6, actualMaximum, i5, i4, i, i2, z);
    }

    static String format(Token[] tokenArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z) {
        Token[] tokenArr2 = tokenArr;
        long j8 = j7;
        StringBuilder sb = new StringBuilder();
        int length = tokenArr2.length;
        int i = 0;
        boolean z2 = false;
        while (i < length) {
            Token token = tokenArr2[i];
            Object value = token.getValue();
            int count = token.getCount();
            if (value instanceof StringBuilder) {
                sb.append(value.toString());
                j8 = j8;
                length = length;
                i = i;
            } else {
                if (value.equals(y)) {
                    sb.append(paddedValue(j, z, count));
                } else {
                    if (value.equals(M)) {
                        sb.append(paddedValue(j2, z, count));
                    } else if (value.equals(d)) {
                        sb.append(paddedValue(j3, z, count));
                        z2 = false;
                    } else {
                        i = i;
                        if (value.equals(H)) {
                            length = length;
                            sb.append(paddedValue(j4, z, count));
                        } else {
                            length = length;
                            if (value.equals(m)) {
                                sb.append(paddedValue(j5, z, count));
                            } else if (value.equals(s)) {
                                sb.append(paddedValue(j6, z, count));
                                j8 = j7;
                                z2 = true;
                            } else if (value.equals(S)) {
                                if (z2) {
                                    j8 = j7;
                                    sb.append(paddedValue(j8, true, z ? Math.max(3, count) : 3));
                                } else {
                                    j8 = j7;
                                    sb.append(paddedValue(j8, z, count));
                                }
                                z2 = false;
                            } else {
                                j8 = j7;
                            }
                        }
                        j8 = j8;
                        z2 = false;
                    }
                    i++;
                    j8 = j8;
                    length = length;
                    tokenArr2 = tokenArr;
                }
                z2 = false;
            }
            i++;
            j8 = j8;
            length = length;
            tokenArr2 = tokenArr;
        }
        return sb.toString();
    }

    private static String paddedValue(long j, boolean z, int i) {
        String string = Long.toString(j);
        return z ? StringUtils.leftPad(string, i, '0') : string;
    }

    static Token[] lexx(String str) {
        String str2;
        ArrayList arrayList = new ArrayList(str.length());
        boolean z = false;
        StringBuilder sb = null;
        Token token = null;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!z || cCharAt == '\'') {
                if (cCharAt != '\'') {
                    if (cCharAt == 'H') {
                        str2 = H;
                    } else if (cCharAt == 'M') {
                        str2 = M;
                    } else if (cCharAt == 'S') {
                        str2 = S;
                    } else if (cCharAt == 'd') {
                        str2 = d;
                    } else if (cCharAt == 'm') {
                        str2 = m;
                    } else if (cCharAt == 's') {
                        str2 = s;
                    } else if (cCharAt == 'y') {
                        str2 = y;
                    } else {
                        if (sb == null) {
                            sb = new StringBuilder();
                            arrayList.add(new Token(sb));
                        }
                        sb.append(cCharAt);
                        str2 = null;
                    }
                } else if (z) {
                    z = false;
                    sb = null;
                    str2 = null;
                } else {
                    sb = new StringBuilder();
                    arrayList.add(new Token(sb));
                    z = true;
                    str2 = null;
                }
                if (str2 != null) {
                    if (token != null && token.getValue().equals(str2)) {
                        token.increment();
                    } else {
                        Token token2 = new Token(str2);
                        arrayList.add(token2);
                        token = token2;
                    }
                    sb = null;
                }
            } else {
                sb.append(cCharAt);
            }
        }
        if (z) {
            throw new IllegalArgumentException("Unmatched quote in format: " + str);
        }
        return (Token[]) arrayList.toArray(Token.EMPTY_ARRAY);
    }

    static class Token {
        private static final Token[] EMPTY_ARRAY = new Token[0];
        private int count;
        private final Object value;

        static boolean containsTokenWithValue(Token[] tokenArr, final Object obj) {
            return Stream.of((Object[]) tokenArr).anyMatch(new Predicate() { // from class: org.apache.commons.lang3.time.DurationFormatUtils$Token$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj2) {
                    return DurationFormatUtils.Token.lambda$containsTokenWithValue$0(obj, (DurationFormatUtils.Token) obj2);
                }
            });
        }

        static /* synthetic */ boolean lambda$containsTokenWithValue$0(Object obj, Token token) {
            return token.getValue() == obj;
        }

        Token(Object obj) {
            this(obj, 1);
        }

        Token(Object obj, int i) {
            this.value = Objects.requireNonNull(obj, "value");
            this.count = i;
        }

        void increment() {
            this.count++;
        }

        int getCount() {
            return this.count;
        }

        Object getValue() {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                return false;
            }
            Object obj2 = this.value;
            if (obj2 instanceof StringBuilder) {
                return obj2.toString().equals(token.value.toString());
            }
            if (obj2 instanceof Number) {
                return obj2.equals(token.value);
            }
            return obj2 == token.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }
    }
}
