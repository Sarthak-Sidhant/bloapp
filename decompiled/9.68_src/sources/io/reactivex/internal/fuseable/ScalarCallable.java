package io.reactivex.internal.fuseable;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface ScalarCallable<T> extends Callable<T> {
    @Override // java.util.concurrent.Callable
    T call();
}
