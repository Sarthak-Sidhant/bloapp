package io.reactivex;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface MaybeObserver<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(Disposable disposable);

    void onSuccess(T t);
}
