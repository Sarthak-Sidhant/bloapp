package org.apache.commons.lang3.concurrent;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface Computable<I, O> {
    O compute(I i) throws InterruptedException;
}
