package io.reactivex.internal.fuseable;

import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface HasUpstreamPublisher<T> {
    Publisher<T> source();
}
