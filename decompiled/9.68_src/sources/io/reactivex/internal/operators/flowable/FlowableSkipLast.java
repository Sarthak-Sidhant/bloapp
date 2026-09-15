package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public final class FlowableSkipLast<T> extends AbstractFlowableWithUpstream<T, T> {
    final int skip;

    public FlowableSkipLast(Flowable<T> flowable, int i) {
        super(flowable);
        this.skip = i;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new SkipLastSubscriber(subscriber, this.skip));
    }

    static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3807491841935125653L;
        final Subscriber<? super T> downstream;
        final int skip;
        Subscription upstream;

        SkipLastSubscriber(Subscriber<? super T> subscriber, int i) {
            super(i);
            this.downstream = subscriber;
            this.skip = i;
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (this.skip == size()) {
                this.downstream.onNext(poll());
            } else {
                this.upstream.request(1L);
            }
            offer(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void request(long j) {
            this.upstream.request(j);
        }

        public void cancel() {
            this.upstream.cancel();
        }
    }
}
