package org.apache.commons.lang3.concurrent;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface CircuitBreaker<T> {
    boolean checkState();

    void close();

    boolean incrementAndCheckState(T t);

    boolean isClosed();

    boolean isOpen();

    void open();
}
