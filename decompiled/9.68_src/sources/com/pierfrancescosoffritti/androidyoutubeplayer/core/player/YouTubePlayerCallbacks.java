package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YouTubePlayerCallbacks.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerCallbacks;", "", "<init>", "()V", "mainThreadHandler", "Landroid/os/Handler;", "booleanCallbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/BooleanProvider;", "requestId", "Ljava/util/concurrent/atomic/AtomicLong;", "registerBooleanCallback", "callback", "sendBooleanValue", "", "value", "", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class YouTubePlayerCallbacks {
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private final ConcurrentHashMap<Long, BooleanProvider> booleanCallbacks = new ConcurrentHashMap<>();
    private final AtomicLong requestId = new AtomicLong(0);

    public final long registerBooleanCallback(BooleanProvider callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        long jIncrementAndGet = this.requestId.incrementAndGet();
        this.booleanCallbacks.put(Long.valueOf(jIncrementAndGet), callback);
        return jIncrementAndGet;
    }

    @JavascriptInterface
    public final void sendBooleanValue(final long requestId, final boolean value) {
        this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerCallbacks$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerCallbacks.sendBooleanValue$lambda$0(this.f$0, requestId, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendBooleanValue$lambda$0(YouTubePlayerCallbacks youTubePlayerCallbacks, long j, boolean z) {
        BooleanProvider booleanProviderRemove = youTubePlayerCallbacks.booleanCallbacks.remove(Long.valueOf(j));
        if (booleanProviderRemove != null) {
            booleanProviderRemove.accept(z);
        }
    }
}
