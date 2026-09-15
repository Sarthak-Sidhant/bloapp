package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@FunctionalInterface
public interface FailableIntBinaryOperator<E extends Throwable> {
    int applyAsInt(int i, int i2) throws Throwable;
}
