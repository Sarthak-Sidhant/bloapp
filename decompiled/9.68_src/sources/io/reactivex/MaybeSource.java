package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface MaybeSource<T> {
    void subscribe(MaybeObserver<? super T> maybeObserver);
}
