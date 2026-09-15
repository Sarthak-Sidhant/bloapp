package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface FlowableConverter<T, R> {
    R apply(Flowable<T> flowable);
}
