package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface DisposableContainer {
    boolean add(Disposable disposable);

    boolean delete(Disposable disposable);

    boolean remove(Disposable disposable);
}
