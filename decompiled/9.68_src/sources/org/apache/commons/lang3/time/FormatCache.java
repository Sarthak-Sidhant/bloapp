package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import org.apache.commons.lang3.LocaleUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
abstract class FormatCache<F extends Format> {
    static final int NONE = -1;
    private static final ConcurrentMap<ArrayKey, String> cDateTimeInstanceCache = new ConcurrentHashMap(7);
    private final ConcurrentMap<ArrayKey, F> cInstanceCache = new ConcurrentHashMap(7);

    protected abstract F createInstance(String str, TimeZone timeZone, Locale locale);

    FormatCache() {
    }

    public F getInstance() {
        return (F) getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public F getInstance(final String str, TimeZone timeZone, Locale locale) {
        Objects.requireNonNull(str, "pattern");
        final TimeZone timeZone2 = TimeZones.toTimeZone(timeZone);
        final Locale locale2 = LocaleUtils.toLocale(locale);
        return this.cInstanceCache.computeIfAbsent(new ArrayKey(str, timeZone2, locale2), new Function() { // from class: org.apache.commons.lang3.time.FormatCache$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m7059lambda$getInstance$0$orgapachecommonslang3timeFormatCache(str, timeZone2, locale2, (FormatCache.ArrayKey) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getInstance$0$org-apache-commons-lang3-time-FormatCache, reason: not valid java name */
    /* synthetic */ Format m7059lambda$getInstance$0$orgapachecommonslang3timeFormatCache(String str, TimeZone timeZone, Locale locale, ArrayKey arrayKey) {
        return createInstance(str, timeZone, locale);
    }

    private F getDateTimeInstance(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        Locale locale2 = LocaleUtils.toLocale(locale);
        return (F) getInstance(getPatternForStyle(num, num2, locale2), timeZone, locale2);
    }

    F getDateTimeInstance(int i, int i2, TimeZone timeZone, Locale locale) {
        return (F) getDateTimeInstance(Integer.valueOf(i), Integer.valueOf(i2), timeZone, locale);
    }

    F getDateInstance(int i, TimeZone timeZone, Locale locale) {
        return (F) getDateTimeInstance(Integer.valueOf(i), (Integer) null, timeZone, locale);
    }

    F getTimeInstance(int i, TimeZone timeZone, Locale locale) {
        return (F) getDateTimeInstance((Integer) null, Integer.valueOf(i), timeZone, locale);
    }

    static String getPatternForStyle(final Integer num, final Integer num2, Locale locale) {
        final Locale locale2 = LocaleUtils.toLocale(locale);
        return cDateTimeInstanceCache.computeIfAbsent(new ArrayKey(num, num2, locale2), new Function() { // from class: org.apache.commons.lang3.time.FormatCache$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return FormatCache.lambda$getPatternForStyle$1(num, num2, locale2, (FormatCache.ArrayKey) obj);
            }
        });
    }

    static /* synthetic */ String lambda$getPatternForStyle$1(Integer num, Integer num2, Locale locale, ArrayKey arrayKey) {
        DateFormat dateTimeInstance;
        try {
            if (num == null) {
                dateTimeInstance = DateFormat.getTimeInstance(num2.intValue(), locale);
            } else if (num2 == null) {
                dateTimeInstance = DateFormat.getDateInstance(num.intValue(), locale);
            } else {
                dateTimeInstance = DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale);
            }
            return ((SimpleDateFormat) dateTimeInstance).toPattern();
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException("No date time pattern for locale: " + locale);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class ArrayKey {
        private final int hashCode;
        private final Object[] keys;

        private static int computeHashCode(Object[] objArr) {
            return 31 + Arrays.hashCode(objArr);
        }

        ArrayKey(Object... objArr) {
            this.keys = objArr;
            this.hashCode = computeHashCode(objArr);
        }

        public int hashCode() {
            return this.hashCode;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return Arrays.deepEquals(this.keys, ((ArrayKey) obj).keys);
            }
            return false;
        }
    }
}
