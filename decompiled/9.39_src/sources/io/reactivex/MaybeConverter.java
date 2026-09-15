package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface MaybeConverter<T, R> {
    R apply(Maybe<T> maybe);
}
