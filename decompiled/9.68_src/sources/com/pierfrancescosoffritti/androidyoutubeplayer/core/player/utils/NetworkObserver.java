package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkObserver.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0003J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/NetworkObserver;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "listeners", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/NetworkObserver$Listener;", "getListeners", "()Ljava/util/List;", "networkBroadcastReceiver", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/NetworkBroadcastReceiver;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "observeNetwork", "", "destroy", "doObserveNetwork", "doObserveNetworkLegacy", "Listener", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkObserver {
    private final Context context;
    private final List<Listener> listeners;
    private NetworkBroadcastReceiver networkBroadcastReceiver;
    private ConnectivityManager.NetworkCallback networkCallback;

    /* JADX INFO: compiled from: NetworkObserver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/NetworkObserver$Listener;", "", "onNetworkAvailable", "", "onNetworkUnavailable", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Listener {
        void onNetworkAvailable();

        void onNetworkUnavailable();
    }

    public NetworkObserver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.listeners = new ArrayList();
    }

    public final List<Listener> getListeners() {
        return this.listeners;
    }

    public final void observeNetwork() {
        doObserveNetwork(this.context);
    }

    public final void destroy() {
        ConnectivityManager.NetworkCallback networkCallback = this.networkCallback;
        if (networkCallback == null) {
            return;
        }
        Object systemService = this.context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) systemService).unregisterNetworkCallback(networkCallback);
        this.listeners.clear();
        this.networkCallback = null;
        this.networkBroadcastReceiver = null;
    }

    private final void doObserveNetwork(Context context) {
        NetworkObserver$doObserveNetwork$callback$1 networkObserver$doObserveNetwork$callback$1 = new NetworkObserver$doObserveNetwork$callback$1(this);
        this.networkCallback = networkObserver$doObserveNetwork$callback$1;
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) systemService).registerDefaultNetworkCallback(networkObserver$doObserveNetwork$callback$1);
    }

    private final void doObserveNetworkLegacy(Context context) {
        NetworkBroadcastReceiver networkBroadcastReceiver = new NetworkBroadcastReceiver(new Function0() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.NetworkObserver$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NetworkObserver.doObserveNetworkLegacy$lambda$2(this.f$0);
            }
        }, new Function0() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.NetworkObserver$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NetworkObserver.doObserveNetworkLegacy$lambda$4(this.f$0);
            }
        });
        this.networkBroadcastReceiver = networkBroadcastReceiver;
        context.registerReceiver(networkBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doObserveNetworkLegacy$lambda$2(NetworkObserver networkObserver) {
        Iterator<T> it = networkObserver.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onNetworkAvailable();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doObserveNetworkLegacy$lambda$4(NetworkObserver networkObserver) {
        Iterator<T> it = networkObserver.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onNetworkUnavailable();
        }
        return Unit.INSTANCE;
    }
}
