package com.opencsv;

import com.opencsv.enums.CSVReaderNullFieldIndicator;
import java.io.Reader;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CSVReaderBuilder {
    private boolean keepCR;
    private final Reader reader;
    private final CSVParserBuilder parserBuilder = new CSVParserBuilder();
    private int skipLines = 0;
    private CSVParser csvParser = null;
    private boolean verifyReader = true;
    private CSVReaderNullFieldIndicator nullFieldIndicator = CSVReaderNullFieldIndicator.NEITHER;

    public CSVReaderBuilder(Reader reader) {
        if (reader == null) {
            throw new IllegalArgumentException("Reader may not be null");
        }
        this.reader = reader;
    }

    protected Reader getReader() {
        return this.reader;
    }

    protected int getSkipLines() {
        return this.skipLines;
    }

    protected CSVParser getCsvParser() {
        return this.csvParser;
    }

    public CSVReaderBuilder withSkipLines(int i) {
        if (i <= 0) {
            i = 0;
        }
        this.skipLines = i;
        return this;
    }

    public CSVReaderBuilder withCSVParser(CSVParser cSVParser) {
        this.csvParser = cSVParser;
        return this;
    }

    public CSVReader build() {
        CSVParser cSVParserBuild = this.csvParser;
        if (cSVParserBuild == null) {
            cSVParserBuild = this.parserBuilder.withFieldAsNull(this.nullFieldIndicator).build();
        }
        return new CSVReader(this.reader, this.skipLines, cSVParserBuild, this.keepCR, this.verifyReader);
    }

    public CSVReaderBuilder withKeepCarriageReturn(boolean z) {
        this.keepCR = z;
        return this;
    }

    protected boolean keepCarriageReturn() {
        return this.keepCR;
    }

    public CSVReaderBuilder withVerifyReader(boolean z) {
        this.verifyReader = z;
        return this;
    }

    public CSVReaderBuilder withFieldAsNull(CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator) {
        this.nullFieldIndicator = cSVReaderNullFieldIndicator;
        return this;
    }
}
