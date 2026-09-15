package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface MaybeOperator<Downstream, Upstream> {
    MaybeObserver<? super Upstream> apply(MaybeObserver<? super Downstream> maybeObserver) throws Exception;
}
