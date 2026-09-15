package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface SingleTransformer<Upstream, Downstream> {
    SingleSource<Downstream> apply(Single<Upstream> single);
}
