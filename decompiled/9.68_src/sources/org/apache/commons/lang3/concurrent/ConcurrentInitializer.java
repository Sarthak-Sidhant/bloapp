package org.apache.commons.lang3.concurrent;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface ConcurrentInitializer<T> {
    T get() throws ConcurrentException;
}
