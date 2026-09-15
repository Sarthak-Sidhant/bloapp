package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface MaybeOnSubscribe<T> {
    void subscribe(MaybeEmitter<T> maybeEmitter) throws Exception;
}
