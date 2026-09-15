package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: YouTubePlayerBridge.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002%&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0007J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0007J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007J\b\u0010\u0015\u001a\u00020\tH\u0007J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000eH\u0007J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000eH\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge;", "", "youTubePlayerOwner", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge$YouTubePlayerBridgeCallbacks;", "<init>", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge$YouTubePlayerBridgeCallbacks;)V", "mainThreadHandler", "Landroid/os/Handler;", "sendYouTubeIFrameAPIReady", "", "sendReady", "sendStateChange", "", "state", "", "sendPlaybackQualityChange", "quality", "sendPlaybackRateChange", "rate", "sendError", "error", "sendApiChange", "sendVideoCurrentTime", "seconds", "sendVideoDuration", "sendVideoLoadedFraction", "fraction", "sendVideoId", "videoId", "parsePlayerState", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "parsePlaybackQuality", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackQuality;", "parsePlaybackRate", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "parsePlayerError", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "Companion", "YouTubePlayerBridgeCallbacks", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class YouTubePlayerBridge {
    private static final String ERROR_HTML_5_PLAYER = "5";
    private static final String ERROR_INVALID_PARAMETER_IN_REQUEST = "2";
    private static final String ERROR_REQUEST_MISSING_HTTP_REFERER = "153";
    private static final String ERROR_VIDEO_NOT_FOUND = "100";
    private static final String ERROR_VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER1 = "101";
    private static final String ERROR_VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER2 = "150";
    private static final String QUALITY_DEFAULT = "default";
    private static final String QUALITY_HD1080 = "hd1080";
    private static final String QUALITY_HD720 = "hd720";
    private static final String QUALITY_HIGH_RES = "highres";
    private static final String QUALITY_LARGE = "large";
    private static final String QUALITY_MEDIUM = "medium";
    private static final String QUALITY_SMALL = "small";
    private static final String RATE_0_25 = "0.25";
    private static final String RATE_0_5 = "0.5";
    private static final String RATE_0_75 = "0.75";
    private static final String RATE_1 = "1";
    private static final String RATE_1_25 = "1.25";
    private static final String RATE_1_5 = "1.5";
    private static final String RATE_1_75 = "1.75";
    private static final String RATE_2 = "2";
    private static final String STATE_BUFFERING = "BUFFERING";
    private static final String STATE_CUED = "CUED";
    private static final String STATE_ENDED = "ENDED";
    private static final String STATE_PAUSED = "PAUSED";
    private static final String STATE_PLAYING = "PLAYING";
    private static final String STATE_UNSTARTED = "UNSTARTED";
    private final Handler mainThreadHandler;
    private final YouTubePlayerBridgeCallbacks youTubePlayerOwner;

    /* JADX INFO: compiled from: YouTubePlayerBridge.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge$YouTubePlayerBridgeCallbacks;", "", "listeners", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "getListeners", "()Ljava/util/Collection;", "getInstance", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "onYouTubeIFrameAPIReady", "", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface YouTubePlayerBridgeCallbacks {
        YouTubePlayer getInstance();

        Collection<YouTubePlayerListener> getListeners();

        void onYouTubeIFrameAPIReady();
    }

    public YouTubePlayerBridge(YouTubePlayerBridgeCallbacks youTubePlayerOwner) {
        Intrinsics.checkNotNullParameter(youTubePlayerOwner, "youTubePlayerOwner");
        this.youTubePlayerOwner = youTubePlayerOwner;
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendYouTubeIFrameAPIReady$lambda$0(YouTubePlayerBridge youTubePlayerBridge) {
        youTubePlayerBridge.youTubePlayerOwner.onYouTubeIFrameAPIReady();
    }

    @JavascriptInterface
    public final boolean sendYouTubeIFrameAPIReady() {
        return this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendYouTubeIFrameAPIReady$lambda$0(this.f$0);
            }
        });
    }

    @JavascriptInterface
    public final boolean sendReady() {
        return this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendReady$lambda$2(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendReady$lambda$2(YouTubePlayerBridge youTubePlayerBridge) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onReady(youTubePlayerBridge.youTubePlayerOwner.getInstance());
        }
    }

    @JavascriptInterface
    public final void sendStateChange(String state) {
        Intrinsics.checkNotNullParameter(state, "state");
        final PlayerConstants.PlayerState playerState = parsePlayerState(state);
        this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendStateChange$lambda$4(this.f$0, playerState);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendStateChange$lambda$4(YouTubePlayerBridge youTubePlayerBridge, PlayerConstants.PlayerState playerState) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onStateChange(youTubePlayerBridge.youTubePlayerOwner.getInstance(), playerState);
        }
    }

    @JavascriptInterface
    public final void sendPlaybackQualityChange(String quality) {
        Intrinsics.checkNotNullParameter(quality, "quality");
        final PlayerConstants.PlaybackQuality playbackQuality = parsePlaybackQuality(quality);
        this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendPlaybackQualityChange$lambda$6(this.f$0, playbackQuality);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendPlaybackQualityChange$lambda$6(YouTubePlayerBridge youTubePlayerBridge, PlayerConstants.PlaybackQuality playbackQuality) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onPlaybackQualityChange(youTubePlayerBridge.youTubePlayerOwner.getInstance(), playbackQuality);
        }
    }

    @JavascriptInterface
    public final void sendPlaybackRateChange(String rate) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        final PlayerConstants.PlaybackRate playbackRate = parsePlaybackRate(rate);
        this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendPlaybackRateChange$lambda$8(this.f$0, playbackRate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendPlaybackRateChange$lambda$8(YouTubePlayerBridge youTubePlayerBridge, PlayerConstants.PlaybackRate playbackRate) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onPlaybackRateChange(youTubePlayerBridge.youTubePlayerOwner.getInstance(), playbackRate);
        }
    }

    @JavascriptInterface
    public final void sendError(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        final PlayerConstants.PlayerError playerError = parsePlayerError(error);
        this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendError$lambda$10(this.f$0, playerError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendError$lambda$10(YouTubePlayerBridge youTubePlayerBridge, PlayerConstants.PlayerError playerError) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onError(youTubePlayerBridge.youTubePlayerOwner.getInstance(), playerError);
        }
    }

    @JavascriptInterface
    public final boolean sendApiChange() {
        return this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendApiChange$lambda$12(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendApiChange$lambda$12(YouTubePlayerBridge youTubePlayerBridge) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onApiChange(youTubePlayerBridge.youTubePlayerOwner.getInstance());
        }
    }

    @JavascriptInterface
    public final void sendVideoCurrentTime(String seconds) {
        Intrinsics.checkNotNullParameter(seconds, "seconds");
        try {
            final float f = Float.parseFloat(seconds);
            this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    YouTubePlayerBridge.sendVideoCurrentTime$lambda$14(this.f$0, f);
                }
            });
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendVideoCurrentTime$lambda$14(YouTubePlayerBridge youTubePlayerBridge, float f) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onCurrentSecond(youTubePlayerBridge.youTubePlayerOwner.getInstance(), f);
        }
    }

    @JavascriptInterface
    public final void sendVideoDuration(String seconds) {
        Intrinsics.checkNotNullParameter(seconds, "seconds");
        try {
            if (TextUtils.isEmpty(seconds)) {
                seconds = "0";
            }
            final float f = Float.parseFloat(seconds);
            this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    YouTubePlayerBridge.sendVideoDuration$lambda$16(this.f$0, f);
                }
            });
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendVideoDuration$lambda$16(YouTubePlayerBridge youTubePlayerBridge, float f) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onVideoDuration(youTubePlayerBridge.youTubePlayerOwner.getInstance(), f);
        }
    }

    @JavascriptInterface
    public final void sendVideoLoadedFraction(String fraction) {
        Intrinsics.checkNotNullParameter(fraction, "fraction");
        try {
            final float f = Float.parseFloat(fraction);
            this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    YouTubePlayerBridge.sendVideoLoadedFraction$lambda$18(this.f$0, f);
                }
            });
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendVideoLoadedFraction$lambda$18(YouTubePlayerBridge youTubePlayerBridge, float f) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onVideoLoadedFraction(youTubePlayerBridge.youTubePlayerOwner.getInstance(), f);
        }
    }

    @JavascriptInterface
    public final boolean sendVideoId(final String videoId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        return this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendVideoId$lambda$20(this.f$0, videoId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendVideoId$lambda$20(YouTubePlayerBridge youTubePlayerBridge, String str) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onVideoId(youTubePlayerBridge.youTubePlayerOwner.getInstance(), str);
        }
    }

    private final PlayerConstants.PlayerState parsePlayerState(String state) {
        if (StringsKt.equals(state, STATE_UNSTARTED, true)) {
            return PlayerConstants.PlayerState.UNSTARTED;
        }
        if (StringsKt.equals(state, STATE_ENDED, true)) {
            return PlayerConstants.PlayerState.ENDED;
        }
        if (StringsKt.equals(state, STATE_PLAYING, true)) {
            return PlayerConstants.PlayerState.PLAYING;
        }
        if (StringsKt.equals(state, STATE_PAUSED, true)) {
            return PlayerConstants.PlayerState.PAUSED;
        }
        if (StringsKt.equals(state, STATE_BUFFERING, true)) {
            return PlayerConstants.PlayerState.BUFFERING;
        }
        return StringsKt.equals(state, STATE_CUED, true) ? PlayerConstants.PlayerState.VIDEO_CUED : PlayerConstants.PlayerState.UNKNOWN;
    }

    private final PlayerConstants.PlaybackQuality parsePlaybackQuality(String quality) {
        if (StringsKt.equals(quality, QUALITY_SMALL, true)) {
            return PlayerConstants.PlaybackQuality.SMALL;
        }
        if (StringsKt.equals(quality, QUALITY_MEDIUM, true)) {
            return PlayerConstants.PlaybackQuality.MEDIUM;
        }
        if (StringsKt.equals(quality, QUALITY_LARGE, true)) {
            return PlayerConstants.PlaybackQuality.LARGE;
        }
        if (StringsKt.equals(quality, QUALITY_HD720, true)) {
            return PlayerConstants.PlaybackQuality.HD720;
        }
        if (StringsKt.equals(quality, QUALITY_HD1080, true)) {
            return PlayerConstants.PlaybackQuality.HD1080;
        }
        if (StringsKt.equals(quality, QUALITY_HIGH_RES, true)) {
            return PlayerConstants.PlaybackQuality.HIGH_RES;
        }
        return StringsKt.equals(quality, QUALITY_DEFAULT, true) ? PlayerConstants.PlaybackQuality.DEFAULT : PlayerConstants.PlaybackQuality.UNKNOWN;
    }

    private final PlayerConstants.PlaybackRate parsePlaybackRate(String rate) {
        if (StringsKt.equals(rate, RATE_0_25, true)) {
            return PlayerConstants.PlaybackRate.RATE_0_25;
        }
        if (StringsKt.equals(rate, RATE_0_5, true)) {
            return PlayerConstants.PlaybackRate.RATE_0_5;
        }
        if (StringsKt.equals(rate, RATE_0_75, true)) {
            return PlayerConstants.PlaybackRate.RATE_0_75;
        }
        if (StringsKt.equals(rate, RATE_1, true)) {
            return PlayerConstants.PlaybackRate.RATE_1;
        }
        if (StringsKt.equals(rate, RATE_1_25, true)) {
            return PlayerConstants.PlaybackRate.RATE_1_25;
        }
        if (StringsKt.equals(rate, "1.5", true)) {
            return PlayerConstants.PlaybackRate.RATE_1_5;
        }
        if (StringsKt.equals(rate, RATE_1_75, true)) {
            return PlayerConstants.PlaybackRate.RATE_1_75;
        }
        return StringsKt.equals(rate, "2", true) ? PlayerConstants.PlaybackRate.RATE_2 : PlayerConstants.PlaybackRate.UNKNOWN;
    }

    private final PlayerConstants.PlayerError parsePlayerError(String error) {
        if (StringsKt.equals(error, "2", true)) {
            return PlayerConstants.PlayerError.INVALID_PARAMETER_IN_REQUEST;
        }
        if (StringsKt.equals(error, ERROR_HTML_5_PLAYER, true)) {
            return PlayerConstants.PlayerError.HTML_5_PLAYER;
        }
        if (StringsKt.equals(error, ERROR_VIDEO_NOT_FOUND, true)) {
            return PlayerConstants.PlayerError.VIDEO_NOT_FOUND;
        }
        if (!StringsKt.equals(error, ERROR_VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER1, true) && !StringsKt.equals(error, ERROR_VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER2, true)) {
            return StringsKt.equals(error, ERROR_REQUEST_MISSING_HTTP_REFERER, true) ? PlayerConstants.PlayerError.REQUEST_MISSING_HTTP_REFERER : PlayerConstants.PlayerError.UNKNOWN;
        }
        return PlayerConstants.PlayerError.VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER;
    }
}
