package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public final class CompletableFromUnsafeSource extends Completable {
    final CompletableSource source;

    public CompletableFromUnsafeSource(CompletableSource completableSource) {
        this.source = completableSource;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(completableObserver);
    }
}
