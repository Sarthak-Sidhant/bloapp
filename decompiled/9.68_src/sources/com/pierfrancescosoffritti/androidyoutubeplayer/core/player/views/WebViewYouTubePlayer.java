package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.pierfrancescosoffritti.androidyoutubeplayer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerCallbacks;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import java.io.InputStream;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WebViewYouTubePlayer.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\rJ5\u0010!\u001a\u00020\u00182\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\b'J\b\u0010-\u001a\u00020\u0013H\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J\u000e\u0010/\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020*J\u000e\u00100\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020*J\b\u00101\u001a\u00020\u0018H\u0016J\u001a\u00102\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0003J\u0010\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\nH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00180\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00065"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/WebViewYouTubePlayer;", "Landroid/webkit/WebView;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge$YouTubePlayerBridgeCallbacks;", "context", "Landroid/content/Context;", "listener", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/FullscreenListener;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/FullscreenListener;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "youTubePlayerCallbacks", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerCallbacks;", "_youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerImpl;", "youtubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "getYoutubePlayer$core_release", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "youTubePlayerInitListener", "Lkotlin/Function1;", "", "isBackgroundPlaybackEnabled", "", "isBackgroundPlaybackEnabled$core_release", "()Z", "setBackgroundPlaybackEnabled$core_release", "(Z)V", "youTubePlayerBridge", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge;", "initialize", "initListener", "playerOptions", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "videoId", "", "initialize$core_release", "listeners", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "getListeners", "()Ljava/util/Collection;", "getInstance", "onYouTubeIFrameAPIReady", "addListener", "removeListener", "destroy", "initWebView", "onWindowVisibilityChanged", "visibility", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebViewYouTubePlayer extends WebView implements YouTubePlayerBridge.YouTubePlayerBridgeCallbacks {
    private final YouTubePlayerImpl _youTubePlayer;
    private boolean isBackgroundPlaybackEnabled;
    private final FullscreenListener listener;
    private final YouTubePlayerBridge youTubePlayerBridge;
    private final YouTubePlayerCallbacks youTubePlayerCallbacks;
    private Function1<? super YouTubePlayer, Unit> youTubePlayerInitListener;

    public /* synthetic */ WebViewYouTubePlayer(Context context, FullscreenListener fullscreenListener, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, fullscreenListener, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewYouTubePlayer(Context context, FullscreenListener listener, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        YouTubePlayerCallbacks youTubePlayerCallbacks = new YouTubePlayerCallbacks();
        this.youTubePlayerCallbacks = youTubePlayerCallbacks;
        this._youTubePlayer = new YouTubePlayerImpl(this, youTubePlayerCallbacks);
        this.youTubePlayerBridge = new YouTubePlayerBridge(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebViewYouTubePlayer(Context context) {
        this(context, FakeWebViewYouTubeListener.INSTANCE, null, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final YouTubePlayer getYoutubePlayer$core_release() {
        return this._youTubePlayer;
    }

    /* JADX INFO: renamed from: isBackgroundPlaybackEnabled$core_release, reason: from getter */
    public final boolean getIsBackgroundPlaybackEnabled() {
        return this.isBackgroundPlaybackEnabled;
    }

    public final void setBackgroundPlaybackEnabled$core_release(boolean z) {
        this.isBackgroundPlaybackEnabled = z;
    }

    public final void initialize$core_release(Function1<? super YouTubePlayer, Unit> initListener, IFramePlayerOptions playerOptions, String videoId) {
        Intrinsics.checkNotNullParameter(initListener, "initListener");
        this.youTubePlayerInitListener = initListener;
        if (playerOptions == null) {
            IFramePlayerOptions.Companion companion = IFramePlayerOptions.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            playerOptions = companion.getDefault(context);
        }
        initWebView(playerOptions, videoId);
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge.YouTubePlayerBridgeCallbacks
    public Collection<YouTubePlayerListener> getListeners() {
        return this._youTubePlayer.getListeners();
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge.YouTubePlayerBridgeCallbacks
    public YouTubePlayer getInstance() {
        return this._youTubePlayer;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge.YouTubePlayerBridgeCallbacks
    public void onYouTubeIFrameAPIReady() {
        Function1<? super YouTubePlayer, Unit> function1 = this.youTubePlayerInitListener;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("youTubePlayerInitListener");
            function1 = null;
        }
        function1.invoke(this._youTubePlayer);
    }

    public final boolean addListener(YouTubePlayerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this._youTubePlayer.addListener(listener);
    }

    public final boolean removeListener(YouTubePlayerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this._youTubePlayer.removeListener(listener);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this._youTubePlayer.release();
        super.destroy();
    }

    private final void initWebView(IFramePlayerOptions playerOptions, String videoId) {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setCacheMode(-1);
        addJavascriptInterface(this.youTubePlayerBridge, "YouTubePlayerBridge");
        addJavascriptInterface(this.youTubePlayerCallbacks, "YouTubePlayerCallbacks");
        InputStream inputStreamOpenRawResource = getResources().openRawResource(R.raw.ayp_youtube_player);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        loadDataWithBaseURL(playerOptions.getOrigin$core_release(), StringsKt.replace$default(StringsKt.replace$default(WebViewYouTubePlayerKt.readHTMLFromUTF8File(inputStreamOpenRawResource), "<<injectedVideoId>>", videoId != null ? "'" + videoId + '\'' : "undefined", false, 4, (Object) null), "<<injectedPlayerVars>>", playerOptions.toString(), false, 4, (Object) null), "text/html", "utf-8", null);
        setWebChromeClient(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.WebViewYouTubePlayer$initWebView$2, reason: invalid class name */
    /* JADX INFO: compiled from: WebViewYouTubePlayer.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/WebViewYouTubePlayer$initWebView$2", "Landroid/webkit/WebChromeClient;", "onShowCustomView", "", "view", "Landroid/view/View;", "callback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "onHideCustomView", "getDefaultVideoPoster", "Landroid/graphics/Bitmap;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass2 extends WebChromeClient {
        AnonymousClass2() {
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, final WebChromeClient.CustomViewCallback callback) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(callback, "callback");
            super.onShowCustomView(view, callback);
            WebViewYouTubePlayer.this.listener.onEnterFullscreen(view, new Function0() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.WebViewYouTubePlayer$initWebView$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WebViewYouTubePlayer.AnonymousClass2.onShowCustomView$lambda$0(callback);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onShowCustomView$lambda$0(WebChromeClient.CustomViewCallback customViewCallback) {
            customViewCallback.onCustomViewHidden();
            return Unit.INSTANCE;
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            super.onHideCustomView();
            WebViewYouTubePlayer.this.listener.onExitFullscreen();
        }

        @Override // android.webkit.WebChromeClient
        public Bitmap getDefaultVideoPoster() {
            Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
            if (defaultVideoPoster != null) {
                return defaultVideoPoster;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            return bitmapCreateBitmap;
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        if (this.isBackgroundPlaybackEnabled && (visibility == 8 || visibility == 4)) {
            return;
        }
        super.onWindowVisibilityChanged(visibility);
    }
}
