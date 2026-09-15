package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface SingleConverter<T, R> {
    R apply(Single<T> single);
}
