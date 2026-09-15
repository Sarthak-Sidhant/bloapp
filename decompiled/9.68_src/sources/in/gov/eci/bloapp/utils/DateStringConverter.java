package in.gov.eci.bloapp.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DateStringConverter {
    private static final List<DateTimeFormatter> FORMATTERS;
    private static final DateTimeFormatter OUT_FMT = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.getDefault());
    private static final DateTimeFormatter YMD_HMS_OPTIONAL_FRACTION;

    private DateStringConverter() {
    }

    static {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("uuuu-MM-dd HH:mm:ss").optionalStart().appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true).optionalEnd().toFormatter(Locale.US);
        YMD_HMS_OPTIONAL_FRACTION = formatter;
        FORMATTERS = Arrays.asList(DateTimeFormatter.ofPattern("dd/MM/uuuu", Locale.US), DateTimeFormatter.ofPattern("d/M/uuuu", Locale.US), DateTimeFormatter.ofPattern("dd/MM/uu", Locale.US), DateTimeFormatter.ofPattern("d/M/uu", Locale.US), DateTimeFormatter.ofPattern("dd-MM-uuuu", Locale.US), DateTimeFormatter.ofPattern("d-M-uuuu", Locale.US), DateTimeFormatter.ofPattern("dd-MM-uu", Locale.US), DateTimeFormatter.ofPattern("d-M-uu", Locale.US), DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.US), DateTimeFormatter.ofPattern("uuuu.M.d", Locale.US), DateTimeFormatter.ofPattern("dd MMM uuuu", Locale.US), DateTimeFormatter.ofPattern("d MMM uuuu", Locale.US), DateTimeFormatter.ofPattern("dd-MMM-uuuu", Locale.US), DateTimeFormatter.ofPattern("d-MMM-uuuu", Locale.US), DateTimeFormatter.ofPattern("dd MMMM uuuu", Locale.US), DateTimeFormatter.ofPattern("d MMMM uuuu", Locale.US), DateTimeFormatter.ofPattern("MMM d, uuuu", Locale.US), DateTimeFormatter.ofPattern("MMMM d, uuuu", Locale.US), DateTimeFormatter.ofPattern("EEE, dd MMM uuuu", Locale.US), DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss", Locale.US), DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm", Locale.US), DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm:ss", Locale.US), DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm", Locale.US), DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss", Locale.US), DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm", Locale.US), formatter, DateTimeFormatter.ISO_INSTANT, DateTimeFormatter.ISO_OFFSET_DATE_TIME, DateTimeFormatter.ISO_ZONED_DATE_TIME, DateTimeFormatter.RFC_1123_DATE_TIME);
    }

    private static TemporalAccessor tryParse(String input) {
        if (input == null) {
            return null;
        }
        String strTrim = input.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        Iterator<DateTimeFormatter> it = FORMATTERS.iterator();
        while (it.hasNext()) {
            try {
                return it.next().parseBest(strTrim, new TemporalQuery() { // from class: in.gov.eci.bloapp.utils.DateStringConverter$$ExternalSyntheticLambda0
                    @Override // java.time.temporal.TemporalQuery
                    public final Object queryFrom(TemporalAccessor temporalAccessor) {
                        return ZonedDateTime.from(temporalAccessor);
                    }
                }, new TemporalQuery() { // from class: in.gov.eci.bloapp.utils.DateStringConverter$$ExternalSyntheticLambda1
                    @Override // java.time.temporal.TemporalQuery
                    public final Object queryFrom(TemporalAccessor temporalAccessor) {
                        return OffsetDateTime.from(temporalAccessor);
                    }
                }, new TemporalQuery() { // from class: in.gov.eci.bloapp.utils.DateStringConverter$$ExternalSyntheticLambda2
                    @Override // java.time.temporal.TemporalQuery
                    public final Object queryFrom(TemporalAccessor temporalAccessor) {
                        return LocalDateTime.from(temporalAccessor);
                    }
                }, new TemporalQuery() { // from class: in.gov.eci.bloapp.utils.DateStringConverter$$ExternalSyntheticLambda3
                    @Override // java.time.temporal.TemporalQuery
                    public final Object queryFrom(TemporalAccessor temporalAccessor) {
                        return LocalDate.from(temporalAccessor);
                    }
                }, new TemporalQuery() { // from class: in.gov.eci.bloapp.utils.DateStringConverter$$ExternalSyntheticLambda4
                    @Override // java.time.temporal.TemporalQuery
                    public final Object queryFrom(TemporalAccessor temporalAccessor) {
                        return Instant.from(temporalAccessor);
                    }
                });
            } catch (DateTimeParseException unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.time.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.time.ZonedDateTime] */
    public static String toDdMmYy(String anyDateString) {
        LocalDate localDateFrom;
        TemporalAccessor temporalAccessorTryParse = tryParse(anyDateString);
        if (temporalAccessorTryParse == null) {
            throw new IllegalArgumentException("Unrecognized date format: " + anyDateString);
        }
        ZoneId zoneIdSystemDefault = ZoneId.systemDefault();
        if (temporalAccessorTryParse instanceof LocalDate) {
            localDateFrom = (LocalDate) temporalAccessorTryParse;
        } else if (temporalAccessorTryParse instanceof LocalDateTime) {
            localDateFrom = ((LocalDateTime) temporalAccessorTryParse).atZone(zoneIdSystemDefault).toLocalDate();
        } else if (temporalAccessorTryParse instanceof ZonedDateTime) {
            localDateFrom = ((ZonedDateTime) temporalAccessorTryParse).withZoneSameInstant(zoneIdSystemDefault).toLocalDate();
        } else if (temporalAccessorTryParse instanceof OffsetDateTime) {
            localDateFrom = ((OffsetDateTime) temporalAccessorTryParse).atZoneSameInstant(zoneIdSystemDefault).toLocalDate();
        } else if (temporalAccessorTryParse instanceof Instant) {
            localDateFrom = ((Instant) temporalAccessorTryParse).atZone(zoneIdSystemDefault).toLocalDate();
        } else {
            localDateFrom = LocalDate.from(temporalAccessorTryParse);
        }
        return OUT_FMT.format(localDateFrom);
    }
}
