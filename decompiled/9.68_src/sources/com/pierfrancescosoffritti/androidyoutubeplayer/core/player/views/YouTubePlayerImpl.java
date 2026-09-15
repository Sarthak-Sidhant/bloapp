package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.BooleanProvider;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstantsKt;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerCallbacks;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewYouTubePlayer.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u001cH\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0014H\u0016J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u000eH\u0016J\u0010\u00100\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u000eH\u0016J\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e02J\u0006\u00103\u001a\u00020\u0010J-\u00104\u001a\u00020\u0010*\u00020\u00032\u0006\u00105\u001a\u00020\u00122\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b07\"\u00020\u000bH\u0002¢\u0006\u0002\u00108R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerImpl;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "webView", "Landroid/webkit/WebView;", "callbacks", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerCallbacks;", "<init>", "(Landroid/webkit/WebView;Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerCallbacks;)V", "mainThread", "Landroid/os/Handler;", "lock", "", "listeners", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "loadVideo", "", "videoId", "", "startSeconds", "", "cueVideo", "play", "pause", "nextVideo", "previousVideo", "playVideoAt", "index", "", "setLoop", "loop", "", "setShuffle", "shuffle", "mute", "unMute", "isMutedAsync", "callback", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/BooleanProvider;", "setVolume", "volumePercent", "seekTo", "time", "setPlaybackRate", "playbackRate", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "addListener", "listener", "removeListener", "getListeners", "", "release", "invoke", "function", "args", "", "(Landroid/webkit/WebView;Ljava/lang/String;[Ljava/lang/Object;)V", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class YouTubePlayerImpl implements YouTubePlayer {
    private final YouTubePlayerCallbacks callbacks;
    private final Set<YouTubePlayerListener> listeners;
    private final Object lock;
    private final Handler mainThread;
    private final WebView webView;

    public YouTubePlayerImpl(WebView webView, YouTubePlayerCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.webView = webView;
        this.callbacks = callbacks;
        this.mainThread = new Handler(Looper.getMainLooper());
        this.lock = new Object();
        this.listeners = new LinkedHashSet();
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void loadVideo(String videoId, float startSeconds) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        invoke(this.webView, "loadVideo", videoId, Float.valueOf(startSeconds));
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void cueVideo(String videoId, float startSeconds) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        invoke(this.webView, "cueVideo", videoId, Float.valueOf(startSeconds));
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void play() {
        invoke(this.webView, "playVideo", new Object[0]);
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void pause() {
        invoke(this.webView, "pauseVideo", new Object[0]);
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void nextVideo() {
        invoke(this.webView, "nextVideo", new Object[0]);
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void previousVideo() {
        invoke(this.webView, "previousVideo", new Object[0]);
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void playVideoAt(int index) {
        invoke(this.webView, "playVideoAt", Integer.valueOf(index));
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void setLoop(boolean loop) {
        invoke(this.webView, "setLoop", Boolean.valueOf(loop));
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void setShuffle(boolean shuffle) {
        invoke(this.webView, "setShuffle", Boolean.valueOf(shuffle));
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void mute() {
        invoke(this.webView, "mute", new Object[0]);
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void unMute() {
        invoke(this.webView, "unMute", new Object[0]);
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void isMutedAsync(BooleanProvider callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        invoke(this.webView, "getMuteValue", Long.valueOf(this.callbacks.registerBooleanCallback(callback)));
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void setVolume(int volumePercent) {
        if (volumePercent < 0 || volumePercent >= 101) {
            throw new IllegalArgumentException("Volume must be between 0 and 100".toString());
        }
        invoke(this.webView, "setVolume", Integer.valueOf(volumePercent));
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void seekTo(float time) {
        invoke(this.webView, "seekTo", Float.valueOf(time));
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public void setPlaybackRate(PlayerConstants.PlaybackRate playbackRate) {
        Intrinsics.checkNotNullParameter(playbackRate, "playbackRate");
        invoke(this.webView, "setPlaybackRate", Float.valueOf(PlayerConstantsKt.toFloat(playbackRate)));
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public boolean addListener(YouTubePlayerListener listener) {
        boolean zAdd;
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.lock) {
            zAdd = this.listeners.add(listener);
        }
        return zAdd;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
    public boolean removeListener(YouTubePlayerListener listener) {
        boolean zRemove;
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.lock) {
            zRemove = this.listeners.remove(listener);
        }
        return zRemove;
    }

    public final Collection<YouTubePlayerListener> getListeners() {
        List list;
        synchronized (this.lock) {
            list = CollectionsKt.toList(this.listeners);
        }
        return list;
    }

    public final void release() {
        synchronized (this.lock) {
            this.listeners.clear();
            Unit unit = Unit.INSTANCE;
        }
        this.mainThread.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$6(WebView webView, String str, List list) {
        webView.loadUrl("javascript:" + str + '(' + CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null) + ')');
    }

    private final void invoke(final WebView webView, final String str, Object... objArr) {
        String string;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj instanceof String) {
                string = "'" + ((String) obj) + '\'';
            } else {
                string = obj.toString();
            }
            arrayList.add(string);
        }
        final ArrayList arrayList2 = arrayList;
        this.mainThread.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerImpl.invoke$lambda$6(webView, str, arrayList2);
            }
        });
    }
}
