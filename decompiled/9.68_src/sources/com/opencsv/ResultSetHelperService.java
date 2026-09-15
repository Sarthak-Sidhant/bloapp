package com.opencsv;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ResultSetHelperService implements ResultSetHelper {
    public static final int CLOBBUFFERSIZE = 2048;
    static final String DEFAULT_DATE_FORMAT = "dd-MMM-yyyy";
    static final String DEFAULT_TIMESTAMP_FORMAT = "dd-MMM-yyyy HH:mm:ss";
    static final int LONGNVARCHAR = -16;
    static final int NCHAR = -15;
    static final int NCLOB = 2011;
    static final int NVARCHAR = -9;
    private String dateFormat = DEFAULT_DATE_FORMAT;
    private String dateTimeFormat = DEFAULT_TIMESTAMP_FORMAT;

    public void setDateFormat(String str) {
        this.dateFormat = str;
    }

    public void setDateTimeFormat(String str) {
        this.dateTimeFormat = str;
    }

    private static String read(Clob clob) throws SQLException, IOException {
        StringBuilder sb = new StringBuilder((int) clob.length());
        Reader characterStream = clob.getCharacterStream();
        char[] cArr = new char[2048];
        while (true) {
            int i = characterStream.read(cArr, 0, 2048);
            if (i != -1) {
                sb.append(cArr, 0, i);
            } else {
                return sb.toString();
            }
        }
    }

    @Override // com.opencsv.ResultSetHelper
    public String[] getColumnNames(ResultSet resultSet) throws SQLException {
        ArrayList arrayList = new ArrayList();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int i = 0;
        while (i < metaData.getColumnCount()) {
            i++;
            arrayList.add(metaData.getColumnLabel(i));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // com.opencsv.ResultSetHelper
    public String[] getColumnValues(ResultSet resultSet) throws SQLException, IOException {
        return getColumnValues(resultSet, false, this.dateFormat, this.dateTimeFormat);
    }

    @Override // com.opencsv.ResultSetHelper
    public String[] getColumnValues(ResultSet resultSet, boolean z) throws SQLException, IOException {
        return getColumnValues(resultSet, z, this.dateFormat, this.dateTimeFormat);
    }

    @Override // com.opencsv.ResultSetHelper
    public String[] getColumnValues(ResultSet resultSet, boolean z, String str, String str2) throws SQLException, IOException {
        ArrayList arrayList = new ArrayList();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int i = 0;
        while (i < metaData.getColumnCount()) {
            i++;
            arrayList.add(getColumnValue(resultSet, metaData.getColumnType(i), i, z, str, str2));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    protected String handleObject(Object obj) {
        return obj == null ? "" : String.valueOf(obj);
    }

    protected String handleBigDecimal(BigDecimal bigDecimal) {
        return bigDecimal == null ? "" : bigDecimal.toString();
    }

    protected String handleDouble(Double d) {
        return d == null ? "" : d.toString();
    }

    protected String handleFloat(Float f) {
        return f == null ? "" : f.toString();
    }

    protected String handleLong(ResultSet resultSet, int i) throws SQLException {
        return resultSet.wasNull() ? "" : Long.toString(resultSet.getLong(i));
    }

    protected String handleInteger(ResultSet resultSet, int i) throws SQLException {
        return resultSet.wasNull() ? "" : Integer.toString(resultSet.getInt(i));
    }

    protected String handleDate(ResultSet resultSet, int i, String str) throws SQLException {
        Date date = resultSet.getDate(i);
        if (date != null) {
            return new SimpleDateFormat(str).format((java.util.Date) date);
        }
        return null;
    }

    protected String handleTime(Time time) {
        if (time == null) {
            return null;
        }
        return time.toString();
    }

    protected String handleTimestamp(Timestamp timestamp, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        if (timestamp == null) {
            return null;
        }
        return simpleDateFormat.format((java.util.Date) timestamp);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x0085  */
    /* JADX WARN: Code duplicated, block: B:41:0x0087  */
    /* JADX WARN: Code duplicated, block: B:43:0x009d  */
    private String getColumnValue(ResultSet resultSet, int i, int i2, boolean z, String str, String str2) throws SQLException, IOException {
        String string;
        if (i != LONGNVARCHAR && i != NCHAR && i != NVARCHAR && i != -1 && i != 12) {
            if (i != 16) {
                if (i != 2000) {
                    if (i != 2005 && i != NCLOB) {
                        if (i != -7) {
                            if (i != -6) {
                                if (i == -5) {
                                    string = handleLong(resultSet, i2);
                                } else {
                                    switch (i) {
                                        case 1:
                                            string = resultSet.getString(i2);
                                            if (z) {
                                                string = string.trim();
                                            }
                                            break;
                                        case 2:
                                        case 3:
                                        case 7:
                                            string = handleBigDecimal(resultSet.getBigDecimal(i2));
                                            break;
                                        case 4:
                                        case 5:
                                            string = handleInteger(resultSet, i2);
                                            break;
                                        case 6:
                                            string = handleFloat(Float.valueOf(resultSet.getFloat(i2)));
                                            break;
                                        case 8:
                                            string = handleDouble(Double.valueOf(resultSet.getDouble(i2)));
                                            break;
                                        default:
                                            switch (i) {
                                                case 91:
                                                    string = handleDate(resultSet, i2, str);
                                                    break;
                                                case 92:
                                                    string = handleTime(resultSet.getTime(i2));
                                                    break;
                                                case 93:
                                                    string = handleTimestamp(resultSet.getTimestamp(i2), str2);
                                                    break;
                                                default:
                                                    string = "";
                                                    break;
                                            }
                                            break;
                                    }
                                }
                            } else {
                                string = handleInteger(resultSet, i2);
                            }
                        } else {
                            string = handleObject(resultSet.getObject(i2));
                        }
                    } else {
                        Clob clob = resultSet.getClob(i2);
                        if (clob == null) {
                            string = "";
                        } else {
                            string = read(clob);
                        }
                    }
                } else {
                    string = handleObject(resultSet.getObject(i2));
                }
            } else {
                string = Boolean.valueOf(resultSet.getBoolean(i2)).toString();
            }
        } else {
            string = resultSet.getString(i2);
            if (z && string != null) {
                string = string.trim();
            }
        }
        return string == null ? "" : string;
    }
}
