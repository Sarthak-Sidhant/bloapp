package com.opencsv;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CSVIterator implements Iterator<String[]> {
    private String[] nextLine;
    private CSVReader reader;

    public CSVIterator(CSVReader cSVReader) throws IOException {
        this.reader = cSVReader;
        this.nextLine = cSVReader.readNext();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.nextLine != null;
    }

    @Override // java.util.Iterator
    public String[] next() {
        String[] strArr = this.nextLine;
        try {
            this.nextLine = this.reader.readNext();
            return strArr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("This is a read only iterator.");
    }
}
