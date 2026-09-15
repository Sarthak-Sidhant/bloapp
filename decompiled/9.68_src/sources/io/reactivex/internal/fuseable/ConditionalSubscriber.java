package io.reactivex.internal.fuseable;

import io.reactivex.FlowableSubscriber;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface ConditionalSubscriber<T> extends FlowableSubscriber<T> {
    boolean tryOnNext(T t);
}
