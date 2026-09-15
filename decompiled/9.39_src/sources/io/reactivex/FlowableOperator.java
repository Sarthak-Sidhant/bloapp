package io.reactivex;

import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface FlowableOperator<Downstream, Upstream> {
    Subscriber<? super Upstream> apply(Subscriber<? super Downstream> subscriber) throws Exception;
}
