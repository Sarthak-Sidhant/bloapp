package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@FunctionalInterface
public interface FailableCallable<R, E extends Throwable> {
    R call() throws Throwable;
}
