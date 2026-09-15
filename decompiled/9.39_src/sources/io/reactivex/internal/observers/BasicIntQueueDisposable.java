package io.reactivex.internal.observers;

import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements QueueDisposable<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
