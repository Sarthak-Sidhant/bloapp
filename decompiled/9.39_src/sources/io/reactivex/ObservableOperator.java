package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface ObservableOperator<Downstream, Upstream> {
    Observer<? super Upstream> apply(Observer<? super Downstream> observer) throws Exception;
}
