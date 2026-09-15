package com.opencsv.bean;

import com.opencsv.CSVReader;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class IterableCSVToBeanBuilder<T> {
    public static final String NO_MAPPING_STRATEGY_DEFINED = "Unable to instantiate IterableCSVToBeanBuilder because there is no MappingStrategy defined.";
    public static final String NO_READER_DEFINED = "Unable to instantiate IterableCSVToBeanBuilder because there is no CSVReader defined.";
    private CSVReader csvReader;
    private CsvToBeanFilter filter;
    private MappingStrategy<T> mapper;

    public IterableCSVToBean<T> build() {
        if (this.mapper == null) {
            throw new RuntimeException(NO_MAPPING_STRATEGY_DEFINED);
        }
        if (this.csvReader == null) {
            throw new RuntimeException(NO_READER_DEFINED);
        }
        return new IterableCSVToBean<>(this.csvReader, this.mapper, this.filter);
    }

    public IterableCSVToBeanBuilder<T> withMapper(MappingStrategy<T> mappingStrategy) {
        this.mapper = mappingStrategy;
        return this;
    }

    public IterableCSVToBeanBuilder<T> withReader(CSVReader cSVReader) {
        this.csvReader = cSVReader;
        return this;
    }

    protected MappingStrategy getStrategy() {
        return this.mapper;
    }

    protected CSVReader getCsvReader() {
        return this.csvReader;
    }

    protected Object getFilter() {
        return this.filter;
    }

    public IterableCSVToBeanBuilder<T> withFilter(CsvToBeanFilter csvToBeanFilter) {
        this.filter = csvToBeanFilter;
        return this;
    }
}
