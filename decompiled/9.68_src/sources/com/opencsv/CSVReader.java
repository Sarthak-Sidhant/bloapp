package com.opencsv;

import com.opencsv.stream.reader.LineReader;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CSVReader implements Closeable, Iterable<String[]> {
    public static final boolean DEFAULT_KEEP_CR = false;
    public static final int DEFAULT_SKIP_LINES = 0;
    public static final boolean DEFAULT_VERIFY_READER = true;
    public static final int READ_AHEAD_LIMIT = 2;
    private BufferedReader br;
    private boolean hasNext;
    private boolean keepCR;
    private LineReader lineReader;
    private long linesRead;
    private boolean linesSkiped;
    private CSVParser parser;
    private long recordsRead;
    private int skipLines;
    private boolean verifyReader;

    public CSVReader(Reader reader) {
        this(reader, ',', '\"', '\\');
    }

    public CSVReader(Reader reader, char c) {
        this(reader, c, '\"', '\\');
    }

    public CSVReader(Reader reader, char c, char c2) {
        this(reader, c, c2, '\\', 0, false);
    }

    public CSVReader(Reader reader, char c, char c2, boolean z) {
        this(reader, c, c2, '\\', 0, z);
    }

    public CSVReader(Reader reader, char c, char c2, char c3) {
        this(reader, c, c2, c3, 0, false);
    }

    public CSVReader(Reader reader, char c, char c2, int i) {
        this(reader, c, c2, '\\', i, false);
    }

    public CSVReader(Reader reader, char c, char c2, char c3, int i) {
        this(reader, c, c2, c3, i, false);
    }

    public CSVReader(Reader reader, char c, char c2, char c3, int i, boolean z) {
        this(reader, c, c2, c3, i, z, true);
    }

    public CSVReader(Reader reader, char c, char c2, char c3, int i, boolean z, boolean z2) {
        this(reader, i, new CSVParser(c, c2, c3, z, z2));
    }

    public CSVReader(Reader reader, char c, char c2, char c3, int i, boolean z, boolean z2, boolean z3) {
        this(reader, i, new CSVParser(c, c2, c3, z, z2), z3, true);
    }

    public CSVReader(Reader reader, int i, CSVParser cSVParser) {
        this(reader, i, cSVParser, false, true);
    }

    CSVReader(Reader reader, int i, CSVParser cSVParser, boolean z, boolean z2) {
        this.hasNext = true;
        this.linesRead = 0L;
        this.recordsRead = 0L;
        this.br = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
        this.lineReader = new LineReader(this.br, z);
        this.skipLines = i;
        this.parser = cSVParser;
        this.keepCR = z;
        this.verifyReader = z2;
    }

    public CSVParser getParser() {
        return this.parser;
    }

    public int getSkipLines() {
        return this.skipLines;
    }

    public boolean keepCarriageReturns() {
        return this.keepCR;
    }

    public List<String[]> readAll() throws IOException {
        ArrayList arrayList = new ArrayList();
        while (this.hasNext) {
            String[] next = readNext();
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public String[] readNext() throws IOException {
        String[] strArrCombineResultsFromMultipleReads = null;
        do {
            String nextLine = getNextLine();
            if (!this.hasNext) {
                return validateResult(strArrCombineResultsFromMultipleReads);
            }
            String[] lineMulti = this.parser.parseLineMulti(nextLine);
            if (lineMulti.length > 0) {
                strArrCombineResultsFromMultipleReads = strArrCombineResultsFromMultipleReads == null ? lineMulti : combineResultsFromMultipleReads(strArrCombineResultsFromMultipleReads, lineMulti);
            }
        } while (this.parser.isPending());
        return validateResult(strArrCombineResultsFromMultipleReads);
    }

    protected String[] validateResult(String[] strArr) {
        if (strArr != null) {
            this.recordsRead++;
        }
        return strArr;
    }

    protected String[] combineResultsFromMultipleReads(String[] strArr, String[] strArr2) {
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    protected String getNextLine() throws IOException {
        if (isClosed()) {
            this.hasNext = false;
            return null;
        }
        if (!this.linesSkiped) {
            for (int i = 0; i < this.skipLines; i++) {
                this.lineReader.readLine();
                this.linesRead++;
            }
            this.linesSkiped = true;
        }
        String line = this.lineReader.readLine();
        if (line == null) {
            this.hasNext = false;
        } else {
            this.linesRead++;
        }
        if (this.hasNext) {
            return line;
        }
        return null;
    }

    private boolean isClosed() {
        if (!this.verifyReader) {
            return false;
        }
        try {
            this.br.mark(2);
            int i = this.br.read();
            this.br.reset();
            return i == -1;
        } catch (IOException unused) {
            return true;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.br.close();
    }

    @Override // java.lang.Iterable
    public Iterator<String[]> iterator() {
        try {
            return new CSVIterator(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verifyReader() {
        return this.verifyReader;
    }

    public long getLinesRead() {
        return this.linesRead;
    }

    public long getRecordsRead() {
        return this.recordsRead;
    }
}
