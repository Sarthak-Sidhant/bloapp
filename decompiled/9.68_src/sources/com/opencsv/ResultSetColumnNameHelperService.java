package com.opencsv;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ResultSetColumnNameHelperService extends ResultSetHelperService implements ResultSetHelper {
    private String[] columnHeaders;
    private Map<String, Integer> columnNamePositionMap = new HashMap();
    private String[] columnNames;

    public void setColumnNames(String[] strArr, String[] strArr2) {
        if (strArr2.length != strArr.length) {
            throw new UnsupportedOperationException("The number of column names must be the same as the number of header names.");
        }
        if (hasInvalidValue(strArr)) {
            throw new UnsupportedOperationException("Column names cannot be null, empty, or blank");
        }
        if (hasInvalidValue(strArr2)) {
            throw new UnsupportedOperationException("Column header names cannot be null, empty, or blank");
        }
        this.columnNames = (String[]) Arrays.copyOf(strArr, strArr.length);
        this.columnHeaders = (String[]) Arrays.copyOf(strArr2, strArr2.length);
    }

    private boolean hasInvalidValue(String[] strArr) {
        for (String str : strArr) {
            if (StringUtils.isBlank(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.opencsv.ResultSetHelperService, com.opencsv.ResultSetHelper
    public String[] getColumnNames(ResultSet resultSet) throws SQLException {
        if (this.columnNamePositionMap.isEmpty()) {
            populateColumnData(resultSet);
        }
        String[] strArr = this.columnHeaders;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    private void populateColumnData(ResultSet resultSet) throws SQLException {
        String[] columnNames = super.getColumnNames(resultSet);
        if (this.columnNames == null) {
            this.columnNames = (String[]) Arrays.copyOf(columnNames, columnNames.length);
            this.columnHeaders = (String[]) Arrays.copyOf(columnNames, columnNames.length);
        }
        for (String str : this.columnNames) {
            int iIndexOf = ArrayUtils.indexOf(columnNames, str);
            if (iIndexOf == -1) {
                throw new UnsupportedOperationException("The column named " + str + " does not exist in the result set!");
            }
            this.columnNamePositionMap.put(str, Integer.valueOf(iIndexOf));
        }
    }

    @Override // com.opencsv.ResultSetHelperService, com.opencsv.ResultSetHelper
    public String[] getColumnValues(ResultSet resultSet) throws SQLException, IOException {
        if (this.columnNamePositionMap.isEmpty()) {
            populateColumnData(resultSet);
        }
        return getColumnValueSubset(super.getColumnValues(resultSet, false, "dd-MMM-yyyy", "dd-MMM-yyyy HH:mm:ss"));
    }

    @Override // com.opencsv.ResultSetHelperService, com.opencsv.ResultSetHelper
    public String[] getColumnValues(ResultSet resultSet, boolean z) throws SQLException, IOException {
        if (this.columnNamePositionMap.isEmpty()) {
            populateColumnData(resultSet);
        }
        return getColumnValueSubset(super.getColumnValues(resultSet, z, "dd-MMM-yyyy", "dd-MMM-yyyy HH:mm:ss"));
    }

    @Override // com.opencsv.ResultSetHelperService, com.opencsv.ResultSetHelper
    public String[] getColumnValues(ResultSet resultSet, boolean z, String str, String str2) throws SQLException, IOException {
        if (this.columnNamePositionMap.isEmpty()) {
            populateColumnData(resultSet);
        }
        return getColumnValueSubset(super.getColumnValues(resultSet, z, str, str2));
    }

    private String[] getColumnValueSubset(String[] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : this.columnNames) {
            arrayList.add(strArr[this.columnNamePositionMap.get(str).intValue()]);
        }
        return (String[]) arrayList.toArray(new String[this.columnNames.length]);
    }
}
