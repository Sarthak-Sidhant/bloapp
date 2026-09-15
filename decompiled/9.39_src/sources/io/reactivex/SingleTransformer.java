package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface SingleTransformer<Upstream, Downstream> {
    SingleSource<Downstream> apply(Single<Upstream> single);
}
