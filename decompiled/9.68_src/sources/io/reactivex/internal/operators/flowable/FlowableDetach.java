package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public final class FlowableDetach<T> extends AbstractFlowableWithUpstream<T, T> {
    public FlowableDetach(Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new DetachSubscriber(subscriber));
    }

    static final class DetachSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        Subscriber<? super T> downstream;
        Subscription upstream;

        DetachSubscriber(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        public void request(long j) {
            this.upstream.request(j);
        }

        public void cancel() {
            Subscription subscription = this.upstream;
            this.upstream = EmptyComponent.INSTANCE;
            this.downstream = EmptyComponent.asSubscriber();
            subscription.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onError(Throwable th) {
            Subscriber<? super T> subscriber = this.downstream;
            this.upstream = EmptyComponent.INSTANCE;
            this.downstream = EmptyComponent.asSubscriber();
            subscriber.onError(th);
        }

        public void onComplete() {
            Subscriber<? super T> subscriber = this.downstream;
            this.upstream = EmptyComponent.INSTANCE;
            this.downstream = EmptyComponent.asSubscriber();
            subscriber.onComplete();
        }
    }
}
