package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface SingleSource<T> {
    void subscribe(SingleObserver<? super T> singleObserver);
}
