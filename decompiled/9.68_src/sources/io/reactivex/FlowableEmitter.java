package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface FlowableEmitter<T> extends Emitter<T> {
    boolean isCancelled();

    long requested();

    FlowableEmitter<T> serialize();

    void setCancellable(Cancellable cancellable);

    void setDisposable(Disposable disposable);

    boolean tryOnError(Throwable th);
}
