package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    ObservableSource<Downstream> apply(Observable<Upstream> observable);
}
