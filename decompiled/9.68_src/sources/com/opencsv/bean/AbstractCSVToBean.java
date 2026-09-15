package com.opencsv.bean;

import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public abstract class AbstractCSVToBean {
    protected abstract PropertyEditor getPropertyEditor(PropertyDescriptor propertyDescriptor) throws IllegalAccessException, InstantiationException;

    protected String checkForTrim(String str, PropertyDescriptor propertyDescriptor) {
        return trimmableProperty(propertyDescriptor) ? str.trim() : str;
    }

    private boolean trimmableProperty(PropertyDescriptor propertyDescriptor) {
        return !propertyDescriptor.getPropertyType().getName().contains("String");
    }

    protected Object convertValue(String str, PropertyDescriptor propertyDescriptor) throws IllegalAccessException, InstantiationException {
        PropertyEditor propertyEditor = getPropertyEditor(propertyDescriptor);
        if (propertyEditor == null) {
            return str;
        }
        propertyEditor.setAsText(str);
        return propertyEditor.getValue();
    }
}
