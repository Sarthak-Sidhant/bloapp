package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.view.View;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewYouTubePlayer.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/FakeWebViewYouTubeListener;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/FullscreenListener;", "<init>", "()V", "onEnterFullscreen", "", "fullscreenView", "Landroid/view/View;", "exitFullscreen", "Lkotlin/Function0;", "onExitFullscreen", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FakeWebViewYouTubeListener implements FullscreenListener {
    public static final FakeWebViewYouTubeListener INSTANCE = new FakeWebViewYouTubeListener();

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
    public void onEnterFullscreen(View fullscreenView, Function0<Unit> exitFullscreen) {
        Intrinsics.checkNotNullParameter(fullscreenView, "fullscreenView");
        Intrinsics.checkNotNullParameter(exitFullscreen, "exitFullscreen");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
    public void onExitFullscreen() {
    }

    private FakeWebViewYouTubeListener() {
    }
}
