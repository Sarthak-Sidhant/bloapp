package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface ObservableOperator<Downstream, Upstream> {
    Observer<? super Upstream> apply(Observer<? super Downstream> observer) throws Exception;
}
