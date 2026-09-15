package com.opencsv;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CSVWriter implements Closeable, Flushable {
    public static final char DEFAULT_ESCAPE_CHARACTER = '\"';
    public static final String DEFAULT_LINE_END = "\n";
    public static final char DEFAULT_QUOTE_CHARACTER = '\"';
    public static final char DEFAULT_SEPARATOR = ',';
    public static final int INITIAL_STRING_SIZE = 1024;
    public static final char NO_ESCAPE_CHARACTER = 0;
    public static final char NO_QUOTE_CHARACTER = 0;
    public static final String RFC4180_LINE_END = "\r\n";
    private char escapechar;
    private String lineEnd;
    private PrintWriter pw;
    private char quotechar;
    private Writer rawWriter;
    private ResultSetHelper resultService;
    private char separator;

    public CSVWriter(Writer writer) {
        this(writer, ',');
    }

    public CSVWriter(Writer writer, char c) {
        this(writer, c, '\"');
    }

    public CSVWriter(Writer writer, char c, char c2) {
        this(writer, c, c2, '\"');
    }

    public CSVWriter(Writer writer, char c, char c2, char c3) {
        this(writer, c, c2, c3, "\n");
    }

    public CSVWriter(Writer writer, char c, char c2, String str) {
        this(writer, c, c2, '\"', str);
    }

    public CSVWriter(Writer writer, char c, char c2, char c3, String str) {
        this.resultService = new ResultSetHelperService();
        this.rawWriter = writer;
        this.pw = new PrintWriter(writer);
        this.separator = c;
        this.quotechar = c2;
        this.escapechar = c3;
        this.lineEnd = str;
    }

    public void writeAll(List<String[]> list, boolean z) {
        Iterator<String[]> it = list.iterator();
        while (it.hasNext()) {
            writeNext(it.next(), z);
        }
    }

    public void writeAll(List<String[]> list) {
        Iterator<String[]> it = list.iterator();
        while (it.hasNext()) {
            writeNext(it.next());
        }
    }

    protected void writeColumnNames(ResultSet resultSet) throws SQLException {
        writeNext(this.resultService.getColumnNames(resultSet));
    }

    public int writeAll(ResultSet resultSet, boolean z) throws SQLException, IOException {
        return writeAll(resultSet, z, false);
    }

    public int writeAll(ResultSet resultSet, boolean z, boolean z2) throws SQLException, IOException {
        int i;
        if (z) {
            writeColumnNames(resultSet);
            i = 1;
        } else {
            i = 0;
        }
        while (resultSet.next()) {
            writeNext(this.resultService.getColumnValues(resultSet, z2));
            i++;
        }
        return i;
    }

    public void writeNext(String[] strArr, boolean z) {
        char c;
        char c2;
        if (strArr == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(strArr.length * 2);
        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                sb.append(this.separator);
            }
            String str = strArr[i];
            if (str != null) {
                Boolean boolValueOf = Boolean.valueOf(stringContainsSpecialCharacters(str));
                if ((z || boolValueOf.booleanValue()) && (c = this.quotechar) != 0) {
                    sb.append(c);
                }
                if (boolValueOf.booleanValue()) {
                    sb.append((CharSequence) processLine(str));
                } else {
                    sb.append(str);
                }
                if ((z || boolValueOf.booleanValue()) && (c2 = this.quotechar) != 0) {
                    sb.append(c2);
                }
            }
        }
        sb.append(this.lineEnd);
        this.pw.write(sb.toString());
    }

    public void writeNext(String[] strArr) {
        writeNext(strArr, true);
    }

    protected boolean stringContainsSpecialCharacters(String str) {
        return (str.indexOf(this.quotechar) == -1 && str.indexOf(this.escapechar) == -1 && str.indexOf(this.separator) == -1 && !str.contains("\n") && !str.contains(StringUtils.CR)) ? false : true;
    }

    protected StringBuilder processLine(String str) {
        StringBuilder sb = new StringBuilder(str.length() * 2);
        for (int i = 0; i < str.length(); i++) {
            processCharacter(sb, str.charAt(i));
        }
        return sb;
    }

    private void processCharacter(StringBuilder sb, char c) {
        if (this.escapechar != 0 && checkCharactersToEscape(c)) {
            sb.append(this.escapechar).append(c);
        } else {
            sb.append(c);
        }
    }

    private boolean checkCharactersToEscape(char c) {
        char c2 = this.quotechar;
        if (c2 == 0) {
            if (c != c2 && c != this.escapechar && c != this.separator) {
                return false;
            }
        } else if (c != c2 && c != this.escapechar) {
            return false;
        }
        return true;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.pw.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        this.pw.close();
        this.rawWriter.close();
    }

    public boolean checkError() {
        return this.pw.checkError();
    }

    public void setResultService(ResultSetHelper resultSetHelper) {
        this.resultService = resultSetHelper;
    }

    public void flushQuietly() {
        try {
            flush();
        } catch (IOException unused) {
        }
    }
}
