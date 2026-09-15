package com.opencsv.bean;

import com.opencsv.CSVReader;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CsvToBean<T> extends AbstractCSVToBean {
    private Map<Class<?>, PropertyEditor> editorMap = null;

    public List<T> parse(MappingStrategy<T> mappingStrategy, Reader reader) {
        return parse(mappingStrategy, new CSVReader(reader));
    }

    public List<T> parse(MappingStrategy<T> mappingStrategy, Reader reader, CsvToBeanFilter csvToBeanFilter) {
        return parse(mappingStrategy, new CSVReader(reader), csvToBeanFilter);
    }

    public List<T> parse(MappingStrategy<T> mappingStrategy, CSVReader cSVReader) {
        return parse(mappingStrategy, cSVReader, (CsvToBeanFilter) null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    public List<T> parse(MappingStrategy<T> mappingStrategy, CSVReader cSVReader, CsvToBeanFilter csvToBeanFilter) throws IntrospectionException {
        try {
            mappingStrategy.captureHeader(cSVReader);
            long j = 0;
            String[] next = null;
            try {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    next = cSVReader.readNext();
                    if (next == null) {
                        return arrayList;
                    }
                    j++;
                    processLine(mappingStrategy, csvToBeanFilter, next, arrayList);
                }
            } catch (Exception e) {
                throw new RuntimeException("Error parsing CSV line: " + j + " values: " + Arrays.toString(next), e);
            }
        } catch (Exception e2) {
            throw new RuntimeException("Error capturing CSV header!", e2);
        }
    }

    private void processLine(MappingStrategy<T> mappingStrategy, CsvToBeanFilter csvToBeanFilter, String[] strArr, List<T> list) throws IllegalAccessException, InstantiationException, InvocationTargetException, IntrospectionException {
        if (csvToBeanFilter == null || csvToBeanFilter.allowLine(strArr)) {
            list.add(processLine(mappingStrategy, strArr));
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    protected T processLine(MappingStrategy<T> mappingStrategy, String[] strArr) throws IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException {
        T tCreateBean = mappingStrategy.createBean();
        for (int i = 0; i < strArr.length; i++) {
            if (mappingStrategy.isAnnotationDriven()) {
                processField(mappingStrategy, strArr, tCreateBean, i);
            } else {
                processProperty(mappingStrategy, strArr, tCreateBean, i);
            }
        }
        return tCreateBean;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    private void processProperty(MappingStrategy<T> mappingStrategy, String[] strArr, T t, int i) throws IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException {
        PropertyDescriptor propertyDescriptorFindDescriptor = mappingStrategy.findDescriptor(i);
        if (propertyDescriptorFindDescriptor != null) {
            propertyDescriptorFindDescriptor.getWriteMethod().invoke(t, convertValue(checkForTrim(strArr[i], propertyDescriptorFindDescriptor), propertyDescriptorFindDescriptor));
        }
    }

    private void processField(MappingStrategy<T> mappingStrategy, String[] strArr, T t, int i) throws IllegalAccessException {
        BeanField beanFieldFindField = mappingStrategy.findField(i);
        if (beanFieldFindField != null) {
            beanFieldFindField.setFieldValue(t, strArr[i]);
        }
    }

    private PropertyEditor getPropertyEditorValue(Class<?> cls) {
        if (this.editorMap == null) {
            this.editorMap = new HashMap();
        }
        PropertyEditor propertyEditor = this.editorMap.get(cls);
        if (propertyEditor != null) {
            return propertyEditor;
        }
        PropertyEditor propertyEditorFindEditor = PropertyEditorManager.findEditor(cls);
        addEditorToMap(cls, propertyEditorFindEditor);
        return propertyEditorFindEditor;
    }

    private void addEditorToMap(Class<?> cls, PropertyEditor propertyEditor) {
        if (propertyEditor != null) {
            this.editorMap.put(cls, propertyEditor);
        }
    }

    @Override // com.opencsv.bean.AbstractCSVToBean
    protected PropertyEditor getPropertyEditor(PropertyDescriptor propertyDescriptor) throws IllegalAccessException, InstantiationException {
        Class propertyEditorClass = propertyDescriptor.getPropertyEditorClass();
        if (propertyEditorClass != null) {
            return (PropertyEditor) propertyEditorClass.newInstance();
        }
        return getPropertyEditorValue(propertyDescriptor.getPropertyType());
    }
}
