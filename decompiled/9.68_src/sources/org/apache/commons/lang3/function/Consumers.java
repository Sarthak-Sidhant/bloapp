package org.apache.commons.lang3.function;

import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class Consumers {
    private static final Consumer NOP;

    static {
        final Function functionIdentity = Function.identity();
        functionIdentity.getClass();
        NOP = new Consumer() { // from class: org.apache.commons.lang3.function.Consumers$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                functionIdentity.apply(obj);
            }
        };
    }

    private Consumers() {
    }

    public static <T> Consumer<T> nop() {
        return NOP;
    }
}
