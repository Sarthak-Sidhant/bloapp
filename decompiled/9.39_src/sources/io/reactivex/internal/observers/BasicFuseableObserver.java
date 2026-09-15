package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {
    protected boolean done;
    protected final Observer<? super R> downstream;
    protected QueueDisposable<T> qd;
    protected int sourceMode;
    protected Disposable upstream;

    protected void afterDownstream() {
    }

    protected boolean beforeDownstream() {
        return true;
    }

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.downstream = observer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            if (disposable instanceof QueueDisposable) {
                this.qd = (QueueDisposable) disposable;
            }
            if (beforeDownstream()) {
                this.downstream.onSubscribe(this);
                afterDownstream();
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
        } else {
            this.done = true;
            this.downstream.onError(th);
        }
    }

    protected final void fail(Throwable th) {
        Exceptions.throwIfFatal(th);
        this.upstream.dispose();
        onError(th);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.downstream.onComplete();
    }

    protected final int transitiveBoundaryFusion(int i) {
        QueueDisposable<T> queueDisposable = this.qd;
        if (queueDisposable == null || (i & 4) != 0) {
            return 0;
        }
        int iRequestFusion = queueDisposable.requestFusion(i);
        if (iRequestFusion != 0) {
            this.sourceMode = iRequestFusion;
        }
        return iRequestFusion;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public boolean isEmpty() {
        return this.qd.isEmpty();
    }

    public void clear() {
        this.qd.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
