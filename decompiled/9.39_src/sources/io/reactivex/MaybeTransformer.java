package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface MaybeTransformer<Upstream, Downstream> {
    MaybeSource<Downstream> apply(Maybe<Upstream> maybe);
}
