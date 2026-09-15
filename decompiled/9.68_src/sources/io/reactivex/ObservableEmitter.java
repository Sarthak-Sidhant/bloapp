package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface ObservableEmitter<T> extends Emitter<T> {
    boolean isDisposed();

    ObservableEmitter<T> serialize();

    void setCancellable(Cancellable cancellable);

    void setDisposable(Disposable disposable);

    boolean tryOnError(Throwable th);
}
