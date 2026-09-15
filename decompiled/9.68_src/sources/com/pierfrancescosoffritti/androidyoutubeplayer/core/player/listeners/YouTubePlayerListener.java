package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import kotlin.Metadata;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: YouTubePlayerListener.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0014H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0014H&J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u001d"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "", "onReady", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "onStateChange", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "onPlaybackQualityChange", "playbackQuality", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackQuality;", "onPlaybackRateChange", "playbackRate", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "onError", "error", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "onCurrentSecond", "second", "", "onVideoDuration", XmlErrorCodes.DURATION, "onVideoLoadedFraction", "loadedFraction", "onVideoId", "videoId", "", "onApiChange", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface YouTubePlayerListener {
    void onApiChange(YouTubePlayer youTubePlayer);

    void onCurrentSecond(YouTubePlayer youTubePlayer, float second);

    void onError(YouTubePlayer youTubePlayer, PlayerConstants.PlayerError error);

    void onPlaybackQualityChange(YouTubePlayer youTubePlayer, PlayerConstants.PlaybackQuality playbackQuality);

    void onPlaybackRateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlaybackRate playbackRate);

    void onReady(YouTubePlayer youTubePlayer);

    void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state);

    void onVideoDuration(YouTubePlayer youTubePlayer, float duration);

    void onVideoId(YouTubePlayer youTubePlayer, String videoId);

    void onVideoLoadedFraction(YouTubePlayer youTubePlayer, float loadedFraction);
}
