package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkObserver.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"com/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/NetworkObserver$doObserveNetwork$callback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "mainThreadHandler", "Landroid/os/Handler;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkObserver$doObserveNetwork$callback$1 extends ConnectivityManager.NetworkCallback {
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    final /* synthetic */ NetworkObserver this$0;

    NetworkObserver$doObserveNetwork$callback$1(NetworkObserver networkObserver) {
        this.this$0 = networkObserver;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        Handler handler = this.mainThreadHandler;
        final NetworkObserver networkObserver = this.this$0;
        handler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.NetworkObserver$doObserveNetwork$callback$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NetworkObserver$doObserveNetwork$callback$1.onAvailable$lambda$1(networkObserver);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAvailable$lambda$1(NetworkObserver networkObserver) {
        Iterator<T> it = networkObserver.getListeners().iterator();
        while (it.hasNext()) {
            ((NetworkObserver.Listener) it.next()).onNetworkAvailable();
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        Handler handler = this.mainThreadHandler;
        final NetworkObserver networkObserver = this.this$0;
        handler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.NetworkObserver$doObserveNetwork$callback$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                NetworkObserver$doObserveNetwork$callback$1.onLost$lambda$3(networkObserver);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLost$lambda$3(NetworkObserver networkObserver) {
        Iterator<T> it = networkObserver.getListeners().iterator();
        while (it.hasNext()) {
            ((NetworkObserver.Listener) it.next()).onNetworkUnavailable();
        }
    }
}
