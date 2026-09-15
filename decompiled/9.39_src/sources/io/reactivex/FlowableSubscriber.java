package io.reactivex;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface FlowableSubscriber<T> extends Subscriber<T> {
    void onSubscribe(Subscription subscription);
}
