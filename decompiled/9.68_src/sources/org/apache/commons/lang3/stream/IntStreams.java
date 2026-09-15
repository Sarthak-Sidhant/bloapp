package org.apache.commons.lang3.stream;

import java.util.stream.IntStream;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class IntStreams {
    public static IntStream range(int i) {
        return IntStream.range(0, i);
    }

    public static IntStream rangeClosed(int i) {
        return IntStream.rangeClosed(0, i);
    }
}
