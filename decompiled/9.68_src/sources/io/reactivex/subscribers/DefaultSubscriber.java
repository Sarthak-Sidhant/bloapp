package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {
    Subscription upstream;

    @Override // io.reactivex.FlowableSubscriber
    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.validate(this.upstream, subscription, getClass())) {
            this.upstream = subscription;
            onStart();
        }
    }

    protected final void request(long j) {
        Subscription subscription = this.upstream;
        if (subscription != null) {
            subscription.request(j);
        }
    }

    protected final void cancel() {
        Subscription subscription = this.upstream;
        this.upstream = SubscriptionHelper.CANCELLED;
        subscription.cancel();
    }

    protected void onStart() {
        request(LongCompanionObject.MAX_VALUE);
    }
}
