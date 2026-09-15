package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface SingleOperator<Downstream, Upstream> {
    SingleObserver<? super Upstream> apply(SingleObserver<? super Downstream> singleObserver) throws Exception;
}
