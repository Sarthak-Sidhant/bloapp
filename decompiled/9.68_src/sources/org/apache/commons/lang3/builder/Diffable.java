package org.apache.commons.lang3.builder;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@FunctionalInterface
public interface Diffable<T> {
    DiffResult<T> diff(T t);
}
