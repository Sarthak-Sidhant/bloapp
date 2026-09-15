package io.reactivex.parallel;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface ParallelFlowableConverter<T, R> {
    R apply(ParallelFlowable<T> parallelFlowable);
}
