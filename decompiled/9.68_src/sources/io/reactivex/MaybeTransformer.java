package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface MaybeTransformer<Upstream, Downstream> {
    MaybeSource<Downstream> apply(Maybe<Upstream> maybe);
}
