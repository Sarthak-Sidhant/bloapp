package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface ObservableConverter<T, R> {
    R apply(Observable<T> observable);
}
