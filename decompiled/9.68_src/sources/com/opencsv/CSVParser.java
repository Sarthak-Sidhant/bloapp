package com.opencsv;

import com.opencsv.enums.CSVReaderNullFieldIndicator;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CSVParser {
    public static final char DEFAULT_ESCAPE_CHARACTER = '\\';
    public static final boolean DEFAULT_IGNORE_LEADING_WHITESPACE = true;
    public static final boolean DEFAULT_IGNORE_QUOTATIONS = false;
    public static final CSVReaderNullFieldIndicator DEFAULT_NULL_FIELD_INDICATOR = CSVReaderNullFieldIndicator.NEITHER;
    public static final char DEFAULT_QUOTE_CHARACTER = '\"';
    public static final char DEFAULT_SEPARATOR = ',';
    public static final boolean DEFAULT_STRICT_QUOTES = false;
    public static final int INITIAL_READ_SIZE = 1024;
    public static final char NULL_CHARACTER = 0;
    public static final int READ_BUFFER_SIZE = 128;
    private final char escape;
    private final boolean ignoreLeadingWhiteSpace;
    private final boolean ignoreQuotations;
    private boolean inField;
    private final CSVReaderNullFieldIndicator nullFieldIndicator;
    private String pending;
    private final char quotechar;
    private final char separator;
    private final boolean strictQuotes;

    private boolean isSameCharacter(char c, char c2) {
        return c != 0 && c == c2;
    }

    public CSVParser() {
        this(',', '\"', '\\');
    }

    public CSVParser(char c) {
        this(c, '\"', '\\');
    }

    public CSVParser(char c, char c2) {
        this(c, c2, '\\');
    }

    public CSVParser(char c, char c2, char c3) {
        this(c, c2, c3, false);
    }

    public CSVParser(char c, char c2, char c3, boolean z) {
        this(c, c2, c3, z, true);
    }

    public CSVParser(char c, char c2, char c3, boolean z, boolean z2) {
        this(c, c2, c3, z, z2, false);
    }

    public CSVParser(char c, char c2, char c3, boolean z, boolean z2, boolean z3) {
        this(c, c2, c3, z, z2, z3, DEFAULT_NULL_FIELD_INDICATOR);
    }

    CSVParser(char c, char c2, char c3, boolean z, boolean z2, boolean z3, CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator) {
        this.inField = false;
        if (anyCharactersAreTheSame(c, c2, c3)) {
            throw new UnsupportedOperationException("The separator, quote, and escape characters must be different!");
        }
        if (c == 0) {
            throw new UnsupportedOperationException("The separator character must be defined!");
        }
        this.separator = c;
        this.quotechar = c2;
        this.escape = c3;
        this.strictQuotes = z;
        this.ignoreLeadingWhiteSpace = z2;
        this.ignoreQuotations = z3;
        this.nullFieldIndicator = cSVReaderNullFieldIndicator;
    }

    public char getSeparator() {
        return this.separator;
    }

    public char getQuotechar() {
        return this.quotechar;
    }

    public char getEscape() {
        return this.escape;
    }

    public boolean isStrictQuotes() {
        return this.strictQuotes;
    }

    public boolean isIgnoreLeadingWhiteSpace() {
        return this.ignoreLeadingWhiteSpace;
    }

    public boolean isIgnoreQuotations() {
        return this.ignoreQuotations;
    }

    private boolean anyCharactersAreTheSame(char c, char c2, char c3) {
        return isSameCharacter(c, c2) || isSameCharacter(c, c3) || isSameCharacter(c2, c3);
    }

    public boolean isPending() {
        return this.pending != null;
    }

    public String[] parseLineMulti(String str) throws IOException {
        return parseLine(str, true);
    }

    public String[] parseLine(String str) throws IOException {
        return parseLine(str, false);
    }

    /* JADX WARN: Code duplicated, block: B:78:0x0106  */
    protected String[] parseLine(String str, boolean z) throws IOException {
        boolean z2;
        int i;
        StringBuilder sb = null;
        if (!z && this.pending != null) {
            this.pending = null;
        }
        boolean z3 = true;
        if (str == null) {
            String str2 = this.pending;
            if (str2 == null) {
                return null;
            }
            this.pending = null;
            return new String[]{str2};
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder(str.length() + 128);
        String str3 = this.pending;
        if (str3 != null) {
            sb2.append(str3);
            this.pending = null;
            z2 = !this.ignoreQuotations;
        } else {
            z2 = false;
        }
        int iAppendNextCharacterAndAdvanceLoop = 0;
        boolean z4 = false;
        while (iAppendNextCharacterAndAdvanceLoop < str.length()) {
            char cCharAt = str.charAt(iAppendNextCharacterAndAdvanceLoop);
            if (cCharAt == this.escape) {
                if (isNextCharacterEscapable(str, inQuotes(z2), iAppendNextCharacterAndAdvanceLoop)) {
                    iAppendNextCharacterAndAdvanceLoop = appendNextCharacterAndAdvanceLoop(str, sb2, iAppendNextCharacterAndAdvanceLoop);
                }
            } else if (cCharAt == this.quotechar) {
                if (isNextCharacterEscapedQuote(str, inQuotes(z2), iAppendNextCharacterAndAdvanceLoop)) {
                    iAppendNextCharacterAndAdvanceLoop = appendNextCharacterAndAdvanceLoop(str, sb2, iAppendNextCharacterAndAdvanceLoop);
                } else {
                    z2 = !z2;
                    if (atStartOfField(sb2)) {
                        z4 = true;
                    }
                    if (!this.strictQuotes && iAppendNextCharacterAndAdvanceLoop > 2 && str.charAt(iAppendNextCharacterAndAdvanceLoop - 1) != this.separator && str.length() > (i = iAppendNextCharacterAndAdvanceLoop + 1) && str.charAt(i) != this.separator) {
                        if (this.ignoreLeadingWhiteSpace && sb2.length() > 0 && isAllWhiteSpace(sb2)) {
                            sb2.setLength(0);
                        } else {
                            sb2.append(cCharAt);
                        }
                    }
                }
                this.inField = !this.inField;
            } else if (cCharAt == this.separator && (!z2 || this.ignoreQuotations)) {
                arrayList.add(convertEmptyToNullIfNeeded(sb2.toString(), z4));
                sb2.setLength(0);
                this.inField = false;
                z4 = false;
            } else if (!this.strictQuotes || (z2 && !this.ignoreQuotations)) {
                sb2.append(cCharAt);
                this.inField = true;
                z4 = true;
            }
            iAppendNextCharacterAndAdvanceLoop++;
        }
        if (z2 && !this.ignoreQuotations) {
            if (z) {
                sb2.append('\n');
                this.pending = sb2.toString();
                if (!this.inField) {
                }
                if (sb != null) {
                    arrayList.add(convertEmptyToNullIfNeeded(sb.toString(), z3));
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            throw new IOException("Un-terminated quoted field at end of CSV line");
        }
        this.inField = false;
        sb = sb2;
        z3 = z4;
        if (sb != null) {
            arrayList.add(convertEmptyToNullIfNeeded(sb.toString(), z3));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private boolean atStartOfField(StringBuilder sb) {
        return sb.length() == 0;
    }

    private String convertEmptyToNullIfNeeded(String str, boolean z) {
        if (str.isEmpty() && shouldConvertEmptyToNull(z)) {
            return null;
        }
        return str;
    }

    /* JADX INFO: renamed from: com.opencsv.CSVParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator;

        static {
            int[] iArr = new int[CSVReaderNullFieldIndicator.values().length];
            $SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator = iArr;
            try {
                iArr[CSVReaderNullFieldIndicator.BOTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator[CSVReaderNullFieldIndicator.EMPTY_SEPARATORS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator[CSVReaderNullFieldIndicator.EMPTY_QUOTES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private boolean shouldConvertEmptyToNull(boolean z) {
        int i = AnonymousClass1.$SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator[this.nullFieldIndicator.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return !z;
        }
        if (i != 3) {
            return false;
        }
        return z;
    }

    private int appendNextCharacterAndAdvanceLoop(String str, StringBuilder sb, int i) {
        int i2 = i + 1;
        sb.append(str.charAt(i2));
        return i2;
    }

    private boolean inQuotes(boolean z) {
        return (z && !this.ignoreQuotations) || this.inField;
    }

    private boolean isNextCharacterEscapedQuote(String str, boolean z, int i) {
        int i2;
        return z && str.length() > (i2 = i + 1) && isCharacterQuoteCharacter(str.charAt(i2));
    }

    private boolean isCharacterQuoteCharacter(char c) {
        return c == this.quotechar;
    }

    private boolean isCharacterEscapeCharacter(char c) {
        return c == this.escape;
    }

    private boolean isCharacterEscapable(char c) {
        return isCharacterQuoteCharacter(c) || isCharacterEscapeCharacter(c);
    }

    protected boolean isNextCharacterEscapable(String str, boolean z, int i) {
        int i2;
        return z && str.length() > (i2 = i + 1) && isCharacterEscapable(str.charAt(i2));
    }

    protected boolean isAllWhiteSpace(CharSequence charSequence) {
        return StringUtils.isWhitespace(charSequence);
    }

    public CSVReaderNullFieldIndicator nullFieldIndicator() {
        return this.nullFieldIndicator;
    }
}
