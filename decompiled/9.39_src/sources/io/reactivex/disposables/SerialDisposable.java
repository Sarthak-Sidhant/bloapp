package io.reactivex.disposables;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class SerialDisposable implements Disposable {
    final AtomicReference<Disposable> resource;

    public SerialDisposable() {
        this.resource = new AtomicReference<>();
    }

    public SerialDisposable(Disposable disposable) {
        this.resource = new AtomicReference<>(disposable);
    }

    public boolean set(Disposable disposable) {
        return DisposableHelper.set(this.resource, disposable);
    }

    public boolean replace(Disposable disposable) {
        return DisposableHelper.replace(this.resource, disposable);
    }

    public Disposable get() {
        DisposableHelper disposableHelper = (Disposable) this.resource.get();
        return disposableHelper == DisposableHelper.DISPOSED ? Disposables.disposed() : disposableHelper;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.resource);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.resource.get());
    }
}
