package io.reactivex.parallel;

import io.reactivex.functions.BiFunction;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public enum ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // io.reactivex.functions.BiFunction
    public ParallelFailureHandling apply(Long l, Throwable th) {
        return this;
    }
}
