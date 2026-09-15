package io.reactivex.internal.subscribers;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    public void onNext(T t) {
        this.value = t;
    }

    public void onError(Throwable th) {
        this.value = null;
        this.error = th;
        countDown();
    }
}
