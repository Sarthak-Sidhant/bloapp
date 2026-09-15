package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface ObservableSource<T> {
    void subscribe(Observer<? super T> observer);
}
