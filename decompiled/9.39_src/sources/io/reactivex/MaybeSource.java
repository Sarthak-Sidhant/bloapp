package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface MaybeSource<T> {
    void subscribe(MaybeObserver<? super T> maybeObserver);
}
