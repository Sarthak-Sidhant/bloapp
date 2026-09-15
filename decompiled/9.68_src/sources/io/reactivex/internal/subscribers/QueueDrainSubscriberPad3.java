package io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: QueueDrainSubscriber.java */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
class QueueDrainSubscriberPad3 extends QueueDrainSubscriberPad2 {
    final AtomicLong requested = new AtomicLong();

    QueueDrainSubscriberPad3() {
    }
}
