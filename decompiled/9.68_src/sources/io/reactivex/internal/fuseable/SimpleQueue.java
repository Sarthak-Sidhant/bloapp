package io.reactivex.internal.fuseable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface SimpleQueue<T> {
    void clear();

    boolean isEmpty();

    boolean offer(T t);

    boolean offer(T t, T t2);

    T poll() throws Exception;
}
