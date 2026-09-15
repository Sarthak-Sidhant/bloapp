package com.opencsv.bean;

import com.opencsv.CSVWriter;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class BeanToCsv<T> {
    public boolean write(MappingStrategy<T> mappingStrategy, Writer writer, List<?> list) {
        return write(mappingStrategy, new CSVWriter(writer), list);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    public boolean write(MappingStrategy<T> mappingStrategy, CSVWriter cSVWriter, List<?> list) throws IntrospectionException {
        if (list == null || list.isEmpty()) {
            return false;
        }
        try {
            cSVWriter.writeNext(processHeader(mappingStrategy));
            processAndWriteObjects(cSVWriter, list, findGetters(mappingStrategy));
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error writing CSV !", e);
        }
    }

    private void processAndWriteObjects(CSVWriter cSVWriter, List<?> list, List<Method> list2) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            cSVWriter.writeNext(processObject(list2, it.next()));
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    protected String[] processHeader(MappingStrategy<T> mappingStrategy) throws IntrospectionException {
        ArrayList arrayList = new ArrayList();
        PropertyDescriptor propertyDescriptorFindDescriptor = mappingStrategy.findDescriptor(0);
        int i = 0;
        while (propertyDescriptorFindDescriptor != null) {
            arrayList.add(propertyDescriptorFindDescriptor.getName());
            i++;
            propertyDescriptorFindDescriptor = mappingStrategy.findDescriptor(i);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    protected String[] processObject(List<Method> list, Object obj) throws IllegalAccessException, InvocationTargetException, IntrospectionException {
        ArrayList arrayList = new ArrayList();
        Iterator<Method> it = list.iterator();
        while (it.hasNext()) {
            Object objInvoke = it.next().invoke(obj, null);
            if (objInvoke == null) {
                arrayList.add("null");
            } else {
                arrayList.add(objInvoke.toString());
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    private List<Method> findGetters(MappingStrategy<T> mappingStrategy) throws IntrospectionException {
        int i = 0;
        PropertyDescriptor propertyDescriptorFindDescriptor = mappingStrategy.findDescriptor(0);
        ArrayList arrayList = new ArrayList();
        while (propertyDescriptorFindDescriptor != null) {
            arrayList.add(propertyDescriptorFindDescriptor.getReadMethod());
            i++;
            propertyDescriptorFindDescriptor = mappingStrategy.findDescriptor(i);
        }
        return arrayList;
    }
}
