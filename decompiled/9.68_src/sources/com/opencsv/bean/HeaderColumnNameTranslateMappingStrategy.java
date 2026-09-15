package com.opencsv.bean;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class HeaderColumnNameTranslateMappingStrategy<T> extends HeaderColumnNameMappingStrategy<T> {
    private Map<String, String> columnMapping = new HashMap();

    @Override // com.opencsv.bean.HeaderColumnNameMappingStrategy
    public String getColumnName(int i) {
        if (i < this.header.length) {
            return this.columnMapping.get(this.header[i].toUpperCase());
        }
        return null;
    }

    public Map<String, String> getColumnMapping() {
        return this.columnMapping;
    }

    public void setColumnMapping(Map<String, String> map) {
        this.columnMapping.clear();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.columnMapping.put(entry.getKey().toUpperCase(), entry.getValue());
        }
    }
}
