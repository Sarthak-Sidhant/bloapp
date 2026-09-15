package com.opencsv.bean;

import com.opencsv.CSVReader;
import java.io.IOException;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ColumnPositionMappingStrategy<T> extends HeaderColumnNameMappingStrategy<T> {
    private String[] columnMapping = new String[0];

    @Override // com.opencsv.bean.HeaderColumnNameMappingStrategy, com.opencsv.bean.MappingStrategy
    public void captureHeader(CSVReader cSVReader) throws IOException {
    }

    @Override // com.opencsv.bean.HeaderColumnNameMappingStrategy, com.opencsv.bean.MappingStrategy
    public Integer getColumnIndex(String str) {
        return this.indexLookup.get(str);
    }

    @Override // com.opencsv.bean.HeaderColumnNameMappingStrategy
    public String getColumnName(int i) {
        String[] strArr = this.columnMapping;
        if (i < strArr.length) {
            return strArr[i];
        }
        return null;
    }

    public String[] getColumnMapping() {
        return (String[]) this.columnMapping.clone();
    }

    public void setColumnMapping(String... strArr) {
        this.columnMapping = strArr != null ? (String[]) strArr.clone() : new String[0];
        resetIndexMap();
        createIndexLookup(this.columnMapping);
    }
}
