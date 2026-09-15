package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface Emitter<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
