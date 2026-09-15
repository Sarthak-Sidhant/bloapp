package com.opencsv;

import com.opencsv.enums.CSVReaderNullFieldIndicator;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CSVParserBuilder {
    private char separator = ',';
    private char quoteChar = '\"';
    private char escapeChar = '\\';
    private boolean strictQuotes = false;
    private boolean ignoreLeadingWhiteSpace = true;
    private boolean ignoreQuotations = false;
    private CSVReaderNullFieldIndicator nullFieldIndicator = CSVReaderNullFieldIndicator.NEITHER;

    public CSVParserBuilder withSeparator(char c) {
        this.separator = c;
        return this;
    }

    public CSVParserBuilder withQuoteChar(char c) {
        this.quoteChar = c;
        return this;
    }

    public CSVParserBuilder withEscapeChar(char c) {
        this.escapeChar = c;
        return this;
    }

    public CSVParserBuilder withStrictQuotes(boolean z) {
        this.strictQuotes = z;
        return this;
    }

    public CSVParserBuilder withIgnoreLeadingWhiteSpace(boolean z) {
        this.ignoreLeadingWhiteSpace = z;
        return this;
    }

    public CSVParserBuilder withIgnoreQuotations(boolean z) {
        this.ignoreQuotations = z;
        return this;
    }

    public CSVParser build() {
        return new CSVParser(this.separator, this.quoteChar, this.escapeChar, this.strictQuotes, this.ignoreLeadingWhiteSpace, this.ignoreQuotations, this.nullFieldIndicator);
    }

    public char getSeparator() {
        return this.separator;
    }

    public char getQuoteChar() {
        return this.quoteChar;
    }

    public char getEscapeChar() {
        return this.escapeChar;
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

    public CSVParserBuilder withFieldAsNull(CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator) {
        this.nullFieldIndicator = cSVReaderNullFieldIndicator;
        return this;
    }

    public CSVReaderNullFieldIndicator nullFieldIndicator() {
        return this.nullFieldIndicator;
    }
}
