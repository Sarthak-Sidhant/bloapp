package com.opencsv.bean;

import com.opencsv.CSVReader;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface MappingStrategy<T> {
    void captureHeader(CSVReader cSVReader) throws IOException;

    T createBean() throws IllegalAccessException, InstantiationException;

    PropertyDescriptor findDescriptor(int i) throws IntrospectionException;

    BeanField findField(int i);

    Integer getColumnIndex(String str);

    boolean isAnnotationDriven();
}
