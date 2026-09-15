package io.reactivex.internal.subscribers;

import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
    public void onNext(T t) {
        if (this.value == null) {
            this.value = t;
            this.upstream.cancel();
            countDown();
        }
    }

    public void onError(Throwable th) {
        if (this.value == null) {
            this.error = th;
        } else {
            RxJavaPlugins.onError(th);
        }
        countDown();
    }
}
