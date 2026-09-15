package com.opencsv.stream.reader;

import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class LineReader {
    private boolean keepCarriageReturns;
    private BufferedReader reader;

    public LineReader(BufferedReader bufferedReader, boolean z) {
        this.reader = bufferedReader;
        this.keepCarriageReturns = z;
    }

    public String readLine() throws IOException {
        return this.keepCarriageReturns ? readUntilNewline() : this.reader.readLine();
    }

    private String readUntilNewline() throws IOException {
        StringBuilder sb = new StringBuilder(1024);
        while (true) {
            int i = this.reader.read();
            if (i <= -1 || i == 10) {
                break;
            }
            sb.append((char) i);
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}
