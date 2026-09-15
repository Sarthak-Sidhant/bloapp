package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface SingleOperator<Downstream, Upstream> {
    SingleObserver<? super Upstream> apply(SingleObserver<? super Downstream> singleObserver) throws Exception;
}
