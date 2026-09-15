package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface MaybeOnSubscribe<T> {
    void subscribe(MaybeEmitter<T> maybeEmitter) throws Exception;
}
