package io.reactivex;

import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface FlowableTransformer<Upstream, Downstream> {
    Publisher<Downstream> apply(Flowable<Upstream> flowable);
}
