package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface MaybeConverter<T, R> {
    R apply(Maybe<T> maybe);
}
