package com.opencsv.bean;

import com.opencsv.CSVReader;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class IterableCSVToBean<T> extends AbstractCSVToBean implements Iterable<T> {
    private CSVReader csvReader;
    private CsvToBeanFilter filter;
    private MappingStrategy<T> strategy;
    private Map<Class<?>, PropertyEditor> editorMap = null;
    private boolean hasHeader = false;

    public IterableCSVToBean(CSVReader cSVReader, MappingStrategy<T> mappingStrategy, CsvToBeanFilter csvToBeanFilter) {
        this.csvReader = cSVReader;
        this.strategy = mappingStrategy;
        this.filter = csvToBeanFilter;
    }

    protected MappingStrategy<T> getStrategy() {
        return this.strategy;
    }

    protected CSVReader getCSVReader() {
        return this.csvReader;
    }

    protected CsvToBeanFilter getFilter() {
        return this.filter;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    public T nextLine() throws IllegalAccessException, InstantiationException, IOException, IntrospectionException, InvocationTargetException {
        String[] next;
        CsvToBeanFilter csvToBeanFilter;
        if (!this.hasHeader) {
            this.strategy.captureHeader(this.csvReader);
            this.hasHeader = true;
        }
        do {
            next = this.csvReader.readNext();
            if (next == null || (csvToBeanFilter = this.filter) == null) {
                break;
            }
        } while (!csvToBeanFilter.allowLine(next));
        if (next == null) {
            return null;
        }
        T tCreateBean = this.strategy.createBean();
        for (int i = 0; i < next.length; i++) {
            PropertyDescriptor propertyDescriptorFindDescriptor = this.strategy.findDescriptor(i);
            if (propertyDescriptorFindDescriptor != null) {
                propertyDescriptorFindDescriptor.getWriteMethod().invoke(tCreateBean, convertValue(checkForTrim(next[i], propertyDescriptorFindDescriptor), propertyDescriptorFindDescriptor));
            }
        }
        return tCreateBean;
    }

    @Override // com.opencsv.bean.AbstractCSVToBean
    protected PropertyEditor getPropertyEditor(PropertyDescriptor propertyDescriptor) throws IllegalAccessException, InstantiationException {
        Class propertyEditorClass = propertyDescriptor.getPropertyEditorClass();
        if (propertyEditorClass != null) {
            return (PropertyEditor) propertyEditorClass.newInstance();
        }
        return getPropertyEditorValue(propertyDescriptor.getPropertyType());
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

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return iterator(this);
    }

    private Iterator<T> iterator(final IterableCSVToBean<T> iterableCSVToBean) {
        return new Iterator<T>() { // from class: com.opencsv.bean.IterableCSVToBean.1
            private T nextBean;

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.nextBean != null) {
                    return true;
                }
                try {
                    this.nextBean = (T) iterableCSVToBean.nextLine();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IntrospectionException e2) {
                    e2.printStackTrace();
                } catch (IOException e3) {
                    e3.printStackTrace();
                } catch (IllegalAccessException e4) {
                    e4.printStackTrace();
                } catch (InvocationTargetException e5) {
                    e5.printStackTrace();
                }
                return this.nextBean != null;
            }

            @Override // java.util.Iterator
            public T next() {
                if (!hasNext()) {
                    return null;
                }
                T t = this.nextBean;
                this.nextBean = null;
                return t;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("This is a read only iterator.");
            }
        };
    }
}
