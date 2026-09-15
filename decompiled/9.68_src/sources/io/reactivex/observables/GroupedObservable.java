package io.reactivex.observables;

import io.reactivex.Observable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public abstract class GroupedObservable<K, T> extends Observable<T> {
    final K key;

    protected GroupedObservable(K k) {
        this.key = k;
    }

    public K getKey() {
        return this.key;
    }
}
