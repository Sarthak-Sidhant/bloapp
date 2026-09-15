package com.opencsv.bean;

import com.opencsv.CSVReader;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class HeaderColumnNameMappingStrategy<T> implements MappingStrategy<T> {
    protected boolean annotationDriven;
    protected boolean determinedIfAnnotationDriven;
    protected String[] header;
    protected Class<T> type;
    protected Map<String, Integer> indexLookup = new HashMap();
    protected Map<String, PropertyDescriptor> descriptorMap = null;
    protected Map<String, BeanField> fieldMap = null;

    @Override // com.opencsv.bean.MappingStrategy
    public void captureHeader(CSVReader cSVReader) throws IOException {
        this.header = cSVReader.readNext();
    }

    protected void createIndexLookup(String[] strArr) {
        if (this.indexLookup.isEmpty()) {
            for (int i = 0; i < strArr.length; i++) {
                this.indexLookup.put(strArr[i], Integer.valueOf(i));
            }
        }
    }

    protected void resetIndexMap() {
        this.indexLookup.clear();
    }

    @Override // com.opencsv.bean.MappingStrategy
    public Integer getColumnIndex(String str) {
        String[] strArr = this.header;
        if (strArr == null) {
            throw new IllegalStateException("The header row hasn't been read yet.");
        }
        createIndexLookup(strArr);
        return this.indexLookup.get(str);
    }

    @Override // com.opencsv.bean.MappingStrategy
    public PropertyDescriptor findDescriptor(int i) throws IntrospectionException {
        String columnName = getColumnName(i);
        if (StringUtils.isNotBlank(columnName)) {
            return findDescriptor(columnName);
        }
        return null;
    }

    @Override // com.opencsv.bean.MappingStrategy
    public BeanField findField(int i) {
        String columnName = getColumnName(i);
        if (StringUtils.isNotBlank(columnName)) {
            return findField(columnName);
        }
        return null;
    }

    public String getColumnName(int i) {
        String[] strArr = this.header;
        if (strArr == null || i >= strArr.length) {
            return null;
        }
        return strArr[i];
    }

    protected PropertyDescriptor findDescriptor(String str) throws IntrospectionException {
        if (this.descriptorMap == null) {
            this.descriptorMap = loadDescriptorMap();
        }
        return this.descriptorMap.get(str.toUpperCase().trim());
    }

    protected BeanField findField(String str) {
        if (this.fieldMap == null) {
            this.fieldMap = loadFieldMap();
        }
        return this.fieldMap.get(str.toUpperCase().trim());
    }

    protected boolean matches(String str, PropertyDescriptor propertyDescriptor) {
        return propertyDescriptor.getName().equals(str.trim());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    protected Map<String, PropertyDescriptor> loadDescriptorMap() throws IntrospectionException {
        HashMap map = new HashMap();
        for (PropertyDescriptor propertyDescriptor : loadDescriptors(getType())) {
            map.put(propertyDescriptor.getName().toUpperCase().trim(), propertyDescriptor);
        }
        return map;
    }

    protected Map<String, BeanField> loadFieldMap() {
        HashMap map = new HashMap();
        for (Field field : loadFields(getType())) {
            map.put(field.getName().toUpperCase().trim(), new BeanField(field, ((CsvBind) field.getAnnotation(CsvBind.class)).required()));
        }
        return map;
    }

    private PropertyDescriptor[] loadDescriptors(Class<T> cls) throws IntrospectionException {
        return Introspector.getBeanInfo(cls).getPropertyDescriptors();
    }

    private List<Field> loadFields(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(CsvBind.class)) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    @Override // com.opencsv.bean.MappingStrategy
    public T createBean() throws IllegalAccessException, InstantiationException {
        return this.type.newInstance();
    }

    public Class<T> getType() {
        return this.type;
    }

    public void setType(Class<T> cls) {
        this.type = cls;
    }

    @Override // com.opencsv.bean.MappingStrategy
    public boolean isAnnotationDriven() {
        if (!this.determinedIfAnnotationDriven) {
            for (Field field : this.type.getDeclaredFields()) {
                if (field.isAnnotationPresent(CsvBind.class)) {
                    this.annotationDriven = true;
                    break;
                }
            }
            this.determinedIfAnnotationDriven = true;
        }
        return this.annotationDriven;
    }
}
