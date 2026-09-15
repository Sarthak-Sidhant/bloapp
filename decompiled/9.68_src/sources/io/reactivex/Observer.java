package io.reactivex;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface Observer<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(Disposable disposable);
}
