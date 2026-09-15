package io.reactivex;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface FlowableSubscriber<T> extends Subscriber<T> {
    void onSubscribe(Subscription subscription);
}
