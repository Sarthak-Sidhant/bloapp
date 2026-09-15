package org.apache.commons.lang3.function;

import java.util.function.Supplier;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class Suppliers {
    public static <T> T get(Supplier<T> supplier) {
        if (supplier == null) {
            return null;
        }
        return supplier.get();
    }
}
