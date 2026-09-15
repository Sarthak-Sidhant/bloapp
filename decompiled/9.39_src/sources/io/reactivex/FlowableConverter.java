package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface FlowableConverter<T, R> {
    R apply(Flowable<T> flowable);
}
