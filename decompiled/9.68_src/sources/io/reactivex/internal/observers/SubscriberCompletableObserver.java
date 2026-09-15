package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public final class SubscriberCompletableObserver<T> implements CompletableObserver, Subscription {
    final Subscriber<? super T> subscriber;
    Disposable upstream;

    public void request(long j) {
    }

    public SubscriberCompletableObserver(Subscriber<? super T> subscriber) {
        this.subscriber = subscriber;
    }

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        this.subscriber.onComplete();
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        this.subscriber.onError(th);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.subscriber.onSubscribe(this);
        }
    }

    public void cancel() {
        this.upstream.dispose();
    }
}
