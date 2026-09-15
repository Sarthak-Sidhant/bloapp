package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: AbstractYouTubePlayerListener.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¨\u0006\u001f"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "<init>", "()V", "onReady", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "onStateChange", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "onPlaybackQualityChange", "playbackQuality", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackQuality;", "onPlaybackRateChange", "playbackRate", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "onError", "error", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "onApiChange", "onCurrentSecond", "second", "", "onVideoDuration", XmlErrorCodes.DURATION, "onVideoLoadedFraction", "loadedFraction", "onVideoId", "videoId", "", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractYouTubePlayerListener implements YouTubePlayerListener {
    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onApiChange(YouTubePlayer youTubePlayer) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onCurrentSecond(YouTubePlayer youTubePlayer, float second) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onError(YouTubePlayer youTubePlayer, PlayerConstants.PlayerError error) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(error, "error");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onPlaybackQualityChange(YouTubePlayer youTubePlayer, PlayerConstants.PlaybackQuality playbackQuality) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(playbackQuality, "playbackQuality");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onPlaybackRateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlaybackRate playbackRate) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(playbackRate, "playbackRate");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onReady(YouTubePlayer youTubePlayer) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(state, "state");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoDuration(YouTubePlayer youTubePlayer, float duration) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoId(YouTubePlayer youTubePlayer, String videoId) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoLoadedFraction(YouTubePlayer youTubePlayer, float loadedFraction) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
    }
}
