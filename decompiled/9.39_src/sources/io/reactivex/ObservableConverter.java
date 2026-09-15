package io.reactivex;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface ObservableConverter<T, R> {
    R apply(Observable<T> observable);
}
