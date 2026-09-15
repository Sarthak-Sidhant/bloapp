package io.reactivex.internal.subscribers;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface InnerQueuedSubscriberSupport<T> {
    void drain();

    void innerComplete(InnerQueuedSubscriber<T> innerQueuedSubscriber);

    void innerError(InnerQueuedSubscriber<T> innerQueuedSubscriber, Throwable th);

    void innerNext(InnerQueuedSubscriber<T> innerQueuedSubscriber, T t);
}
