package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface FlowablePublishClassic<T> {
    int publishBufferSize();

    Publisher<T> publishSource();
}
