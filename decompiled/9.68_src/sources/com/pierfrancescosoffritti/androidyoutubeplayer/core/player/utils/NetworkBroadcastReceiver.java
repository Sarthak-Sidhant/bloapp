package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkObserver.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/NetworkBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "onNetworkAvailable", "Lkotlin/Function0;", "", "onNetworkUnavailable", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class NetworkBroadcastReceiver extends BroadcastReceiver {
    private final Function0<Unit> onNetworkAvailable;
    private final Function0<Unit> onNetworkUnavailable;

    public NetworkBroadcastReceiver(Function0<Unit> onNetworkAvailable, Function0<Unit> onNetworkUnavailable) {
        Intrinsics.checkNotNullParameter(onNetworkAvailable, "onNetworkAvailable");
        Intrinsics.checkNotNullParameter(onNetworkUnavailable, "onNetworkUnavailable");
        this.onNetworkAvailable = onNetworkAvailable;
        this.onNetworkUnavailable = onNetworkUnavailable;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (NetworkObserverKt.isConnectedToInternet(context)) {
            this.onNetworkAvailable.invoke();
        } else {
            this.onNetworkUnavailable.invoke();
        }
    }
}
