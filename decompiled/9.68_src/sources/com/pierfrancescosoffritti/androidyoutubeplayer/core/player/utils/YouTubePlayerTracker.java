package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: YouTubePlayerTracker.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/YouTubePlayerTracker;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "<init>", "()V", "value", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "state", "getState", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "", "currentSecond", "getCurrentSecond", "()F", "videoDuration", "getVideoDuration", "", "videoId", "getVideoId", "()Ljava/lang/String;", "onStateChange", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "onCurrentSecond", "second", "onVideoDuration", XmlErrorCodes.DURATION, "onVideoId", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class YouTubePlayerTracker extends AbstractYouTubePlayerListener {
    private float currentSecond;
    private PlayerConstants.PlayerState state = PlayerConstants.PlayerState.UNKNOWN;
    private float videoDuration;
    private String videoId;

    public final PlayerConstants.PlayerState getState() {
        return this.state;
    }

    public final float getCurrentSecond() {
        return this.currentSecond;
    }

    public final float getVideoDuration() {
        return this.videoDuration;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onCurrentSecond(YouTubePlayer youTubePlayer, float second) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        this.currentSecond = second;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoDuration(YouTubePlayer youTubePlayer, float duration) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        this.videoDuration = duration;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
    public void onVideoId(YouTubePlayer youTubePlayer, String videoId) {
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        this.videoId = videoId;
    }
}
