package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface SingleConverter<T, R> {
    R apply(Single<T> single);
}
