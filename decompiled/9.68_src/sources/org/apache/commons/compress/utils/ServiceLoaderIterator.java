package org.apache.commons.compress.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ServiceLoaderIterator<E> implements Iterator<E> {
    private E nextServiceLoader;
    private final Class<E> service;
    private final Iterator<E> serviceLoaderIterator;

    public ServiceLoaderIterator(Class<E> cls) {
        this(cls, ClassLoader.getSystemClassLoader());
    }

    public ServiceLoaderIterator(Class<E> cls, ClassLoader classLoader) {
        this.service = cls;
        this.serviceLoaderIterator = ServiceLoader.load(cls, classLoader).iterator();
        this.nextServiceLoader = null;
    }

    private boolean getNextServiceLoader() {
        while (this.nextServiceLoader == null) {
            try {
                if (!this.serviceLoaderIterator.hasNext()) {
                    return false;
                }
                this.nextServiceLoader = this.serviceLoaderIterator.next();
            } catch (ServiceConfigurationError e) {
                if (!(e.getCause() instanceof SecurityException)) {
                    throw e;
                }
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return getNextServiceLoader();
    }

    @Override // java.util.Iterator
    public E next() {
        if (!getNextServiceLoader()) {
            throw new NoSuchElementException("No more elements for service " + this.service.getName());
        }
        E e = this.nextServiceLoader;
        this.nextServiceLoader = null;
        return e;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("service=" + this.service.getName());
    }
}
