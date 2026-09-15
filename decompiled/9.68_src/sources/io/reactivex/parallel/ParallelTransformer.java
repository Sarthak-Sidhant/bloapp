package io.reactivex.parallel;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface ParallelTransformer<Upstream, Downstream> {
    ParallelFlowable<Downstream> apply(ParallelFlowable<Upstream> parallelFlowable);
}
