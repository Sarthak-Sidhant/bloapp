package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public interface SchedulerMultiWorkerSupport {

    public interface WorkerCallback {
        void onWorker(int i, Scheduler.Worker worker);
    }

    void createWorkers(int i, WorkerCallback workerCallback);
}
