package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FutureTasks {
    private FutureTasks() {
    }

    public static <V> FutureTask<V> run(Callable<V> callable) {
        FutureTask<V> futureTask = new FutureTask<>(callable);
        futureTask.run();
        return futureTask;
    }
}
