package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface ResettableConnectable {
    void resetIf(Disposable disposable);
}
