package in.gov.eci.bloapp.views.fragments;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.yalantis.ucrop.view.CropImageView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.utils.VideoLanguage;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class MandatoryVideoDialogFragment extends DialogFragment {
    private static final String ARG_LANGUAGE = "video_language";
    private static final String ARG_VIDEO_ID = "video_id";
    private static final String LOG_TAG = "MandatoryVideo";
    private static final long PLAYER_LOAD_TIMEOUT_MS = 30000;
    private static final String STATE_TECHNICAL_FAILURE = "state_technical_failure";
    private static final String STATE_VIDEO_COMPLETED = "state_video_completed";
    public static final String TAG = "MandatoryVideoDialog";
    private static final Pattern YOUTUBE_VIDEO_ID_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]{11}$");
    private boolean completionCallbackDelivered;
    private VideoCompletionListener completionListener;
    private Button dismissButton;
    private TextView messageTextView;
    private boolean playerReady;
    private boolean playerReleased;
    private ProgressBar progressBar;
    private TextView statusTextView;
    private boolean technicalFailure;
    private TextView titleTextView;
    private boolean videoCompleted;
    private YouTubePlayer youTubePlayer;
    private YouTubePlayerView youtubePlayerView;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable playerLoadTimeoutRunnable = new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.MandatoryVideoDialogFragment$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$1();
        }
    };

    public interface VideoCompletionListener {
        void onMandatoryVideoClosed(String language, String videoId, boolean videoCompleted, boolean technicalFailure);

        void onMandatoryVideoFinished(String language, String videoId);
    }

    public static MandatoryVideoDialogFragment newInstance(String videoId, String language) {
        MandatoryVideoDialogFragment mandatoryVideoDialogFragment = new MandatoryVideoDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_VIDEO_ID, videoId.trim());
        bundle.putString(ARG_LANGUAGE, language);
        mandatoryVideoDialogFragment.setArguments(bundle);
        return mandatoryVideoDialogFragment;
    }

    public void setVideoCompletionListener(VideoCompletionListener listener) {
        this.completionListener = listener;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(requireContext());
        dialog.requestWindowFeature(1);
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_mandotry_video, (ViewGroup) null, false);
        dialog.setContentView(viewInflate);
        setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        initializeViews(viewInflate);
        restoreState(savedInstanceState);
        String videoId = getVideoId();
        configureDialogText(getVideoLanguage());
        if (this.videoCompleted) {
            showVideoCompletedState();
        } else if (this.technicalFailure) {
            showTechnicalFailureAndEnableDismiss();
        } else if (isValidVideoId(videoId)) {
            configureYouTubePlayer(videoId);
        } else {
            showInvalidVideoIdFailure();
        }
        this.dismissButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.MandatoryVideoDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateDialog$0(view);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$0(View view) {
        closeDialogIfAllowed();
    }

    private void initializeViews(View view) {
        this.youtubePlayerView = (YouTubePlayerView) view.findViewById(R.id.youtubePlayerView);
        this.titleTextView = (TextView) view.findViewById(R.id.tvVideoTitle);
        this.messageTextView = (TextView) view.findViewById(R.id.tvVideoMessage);
        this.statusTextView = (TextView) view.findViewById(R.id.tvVideoStatus);
        this.dismissButton = (Button) view.findViewById(R.id.btnDismiss);
        this.progressBar = (ProgressBar) view.findViewById(R.id.videoProgressBar);
        disableDismissButton();
    }

    private void restoreState(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return;
        }
        this.videoCompleted = savedInstanceState.getBoolean(STATE_VIDEO_COMPLETED, false);
        this.technicalFailure = savedInstanceState.getBoolean(STATE_TECHNICAL_FAILURE, false);
        this.completionCallbackDelivered = this.videoCompleted;
    }

    private void configureDialogText(String language) {
        if (isHindiLanguage(language)) {
            this.titleTextView.setText("कृपया वीडियो देखें");
            this.messageTextView.setText("वीडियो पूरा होने के बाद ही बंद करें बटन सक्रिय होगा।");
            this.statusTextView.setText("वीडियो तैयार किया जा रहा है...");
            this.dismissButton.setText("बंद करें");
            return;
        }
        this.titleTextView.setText("Please watch the video");
        this.messageTextView.setText("The Dismiss button will be enabled only after the video finishes.");
        this.statusTextView.setText("Preparing video...");
        this.dismissButton.setText("Dismiss");
    }

    private void prepareLoadingState() {
        this.technicalFailure = false;
        this.playerReady = false;
        this.playerReleased = false;
        if (areViewsAvailable()) {
            this.youtubePlayerView.setVisibility(0);
            this.youtubePlayerView.setBackgroundColor(-16777216);
            this.progressBar.setVisibility(0);
            disableDismissButton();
            setStatusMessage("Loading video. Please wait...", "वीडियो लोड हो रहा है। कृपया प्रतीक्षा करें...");
        }
    }

    private void configureYouTubePlayer(final String videoId) {
        if (this.youtubePlayerView == null) {
            return;
        }
        prepareLoadingState();
        startPlayerLoadTimeout();
        IFramePlayerOptions iFramePlayerOptionsBuild = new IFramePlayerOptions.Builder(requireContext()).controls(1).fullscreen(0).rel(0).build();
        try {
            this.youtubePlayerView.initialize(new AbstractYouTubePlayerListener() { // from class: in.gov.eci.bloapp.views.fragments.MandatoryVideoDialogFragment.1
                @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
                public void onReady(YouTubePlayer player) {
                    if (MandatoryVideoDialogFragment.this.canProcessPlayerCallback()) {
                        Log.d(MandatoryVideoDialogFragment.LOG_TAG, "YouTube player is ready");
                        MandatoryVideoDialogFragment.this.youTubePlayer = player;
                        MandatoryVideoDialogFragment.this.playerReady = true;
                        MandatoryVideoDialogFragment.this.cancelPlayerLoadTimeout();
                        player.loadVideo(videoId, CropImageView.DEFAULT_ASPECT_RATIO);
                        MandatoryVideoDialogFragment.this.setStatusMessage("Please press Play to start the video.", "कृपया वीडियो शुरू करने के लिए प्ले दबाएं।");
                    }
                }

                @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
                public void onStateChange(YouTubePlayer player, PlayerConstants.PlayerState state) {
                    if (MandatoryVideoDialogFragment.this.canProcessPlayerCallback()) {
                        Log.d(MandatoryVideoDialogFragment.LOG_TAG, "YouTube player state: " + state);
                        MandatoryVideoDialogFragment.this.handlePlayerState(state);
                    }
                }

                @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
                public void onError(YouTubePlayer player, PlayerConstants.PlayerError error) {
                    if (MandatoryVideoDialogFragment.this.playerReleased || MandatoryVideoDialogFragment.this.videoCompleted || MandatoryVideoDialogFragment.this.technicalFailure) {
                        return;
                    }
                    Log.e(MandatoryVideoDialogFragment.LOG_TAG, "YouTube player error: " + error);
                    MandatoryVideoDialogFragment.this.completeTechnicalFailure("YouTube player error: " + error);
                }
            }, true, iFramePlayerOptionsBuild);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Unable to initialize YouTube player", e);
            completeTechnicalFailure("Unable to initialize YouTube player");
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.MandatoryVideoDialogFragment$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$pierfrancescosoffritti$androidyoutubeplayer$core$player$PlayerConstants$PlayerState;

        static {
            int[] iArr = new int[PlayerConstants.PlayerState.values().length];
            $SwitchMap$com$pierfrancescosoffritti$androidyoutubeplayer$core$player$PlayerConstants$PlayerState = iArr;
            try {
                iArr[PlayerConstants.PlayerState.PLAYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pierfrancescosoffritti$androidyoutubeplayer$core$player$PlayerConstants$PlayerState[PlayerConstants.PlayerState.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pierfrancescosoffritti$androidyoutubeplayer$core$player$PlayerConstants$PlayerState[PlayerConstants.PlayerState.BUFFERING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$pierfrancescosoffritti$androidyoutubeplayer$core$player$PlayerConstants$PlayerState[PlayerConstants.PlayerState.ENDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$pierfrancescosoffritti$androidyoutubeplayer$core$player$PlayerConstants$PlayerState[PlayerConstants.PlayerState.VIDEO_CUED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$pierfrancescosoffritti$androidyoutubeplayer$core$player$PlayerConstants$PlayerState[PlayerConstants.PlayerState.UNSTARTED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$pierfrancescosoffritti$androidyoutubeplayer$core$player$PlayerConstants$PlayerState[PlayerConstants.PlayerState.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePlayerState(PlayerConstants.PlayerState state) {
        switch (AnonymousClass2.$SwitchMap$com$pierfrancescosoffritti$androidyoutubeplayer$core$player$PlayerConstants$PlayerState[state.ordinal()]) {
            case 1:
                setStatusMessage("Video is playing.", "वीडियो चल रहा है।");
                this.progressBar.setVisibility(8);
                break;
            case 2:
                setStatusMessage("Video is paused. Please resume playback.", "वीडियो रुका हुआ है। कृपया वीडियो फिर से चलाएं।");
                this.progressBar.setVisibility(8);
                break;
            case 3:
                setStatusMessage("Video is buffering. Please wait...", "वीडियो बफर हो रहा है। कृपया प्रतीक्षा करें...");
                this.progressBar.setVisibility(0);
                break;
            case 4:
                completeVideo();
                this.progressBar.setVisibility(8);
                break;
            case 5:
                setStatusMessage("Please press Play to start the video.", "कृपया वीडियो शुरू करने के लिए प्ले दबाएं।");
                this.progressBar.setVisibility(8);
                break;
            case 6:
                setStatusMessage("Video is ready. Please press Play.", "वीडियो तैयार है। कृपया प्ले दबाएं।");
                this.progressBar.setVisibility(8);
                break;
            default:
                Log.d(LOG_TAG, "Unhandled player state: " + state);
                this.progressBar.setVisibility(8);
                break;
        }
    }

    private void completeVideo() {
        if (this.videoCompleted || this.technicalFailure) {
            return;
        }
        Log.d(LOG_TAG, "YouTube video completed");
        this.videoCompleted = true;
        this.technicalFailure = false;
        cancelPlayerLoadTimeout();
        showVideoCompletedState();
        notifyVideoFinished();
    }

    private void showVideoCompletedState() {
        if (areViewsAvailable()) {
            if (isHindiLanguage(getVideoLanguage())) {
                this.statusTextView.setText("वीडियो पूरा हो गया है। अब आप इसे बंद कर सकते हैं।");
            } else {
                this.statusTextView.setText("Video completed. You may now dismiss this dialog.");
            }
            enableDismissButton();
        }
    }

    private void notifyVideoFinished() {
        if (this.completionCallbackDelivered) {
            return;
        }
        this.completionCallbackDelivered = true;
        VideoCompletionListener videoCompletionListener = this.completionListener;
        if (videoCompletionListener != null) {
            videoCompletionListener.onMandatoryVideoFinished(getVideoLanguage(), getVideoId());
        }
    }

    private void closeDialogIfAllowed() {
        if (this.videoCompleted || this.technicalFailure) {
            cancelAllCallbacks();
            pausePlayer();
            VideoCompletionListener videoCompletionListener = this.completionListener;
            if (videoCompletionListener != null) {
                videoCompletionListener.onMandatoryVideoClosed(getVideoLanguage(), getVideoId(), this.videoCompleted, this.technicalFailure);
            }
            dismissAllowingStateLoss();
        }
    }

    private void pausePlayer() {
        YouTubePlayer youTubePlayer = this.youTubePlayer;
        if (youTubePlayer == null) {
            return;
        }
        try {
            youTubePlayer.pause();
        } catch (Exception e) {
            Log.w(LOG_TAG, "Unable to pause YouTube player", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canProcessPlayerCallback() {
        return (!isAdded() || this.playerReleased || this.videoCompleted || this.technicalFailure) ? false : true;
    }

    private void startPlayerLoadTimeout() {
        cancelPlayerLoadTimeout();
        this.handler.postDelayed(this.playerLoadTimeoutRunnable, PLAYER_LOAD_TIMEOUT_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelPlayerLoadTimeout() {
        this.handler.removeCallbacks(this.playerLoadTimeoutRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        if (!isAdded() || this.playerReady || this.videoCompleted || this.technicalFailure || this.playerReleased) {
            return;
        }
        completeTechnicalFailure("YouTube player did not initialize within 30000 milliseconds");
    }

    private void showInvalidVideoIdFailure() {
        Log.e(LOG_TAG, "Invalid YouTube video ID: " + getVideoId());
        this.technicalFailure = true;
        this.videoCompleted = false;
        showTechnicalFailureAndEnableDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeTechnicalFailure(String errorMessage) {
        if (this.videoCompleted || this.technicalFailure) {
            return;
        }
        Log.e(LOG_TAG, "Technical failure: " + errorMessage);
        this.technicalFailure = true;
        this.videoCompleted = false;
        this.playerReady = false;
        cancelAllCallbacks();
        pausePlayer();
        showTechnicalFailureAndEnableDismiss();
    }

    private void showTechnicalFailureAndEnableDismiss() {
        if (areViewsAvailable()) {
            this.progressBar.setVisibility(8);
            if (isHindiLanguage(getVideoLanguage())) {
                this.statusTextView.setText("इंटरनेट या वीडियो संबंधी समस्या के कारण वीडियो लोड नहीं हो सका। आप अब इस संवाद को बंद कर सकते हैं।");
            } else {
                this.statusTextView.setText("The video could not be loaded because of an internet or video-related issue. You may now dismiss this dialog.");
            }
            enableDismissButton();
        }
    }

    private void enableDismissButton() {
        Button button = this.dismissButton;
        if (button == null) {
            return;
        }
        button.setEnabled(true);
        this.dismissButton.setAlpha(1.0f);
    }

    private void disableDismissButton() {
        Button button = this.dismissButton;
        if (button == null) {
            return;
        }
        button.setEnabled(false);
        this.dismissButton.setAlpha(0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusMessage(String englishMessage, String hindiMessage) {
        TextView textView = this.statusTextView;
        if (textView == null) {
            return;
        }
        if (isHindiLanguage(getVideoLanguage())) {
            englishMessage = hindiMessage;
        }
        textView.setText(englishMessage);
    }

    private String getVideoId() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_VIDEO_ID, "")) == null) {
            return "";
        }
        return string.trim();
    }

    private String getVideoLanguage() {
        String string;
        Bundle arguments = getArguments();
        return (arguments == null || (string = arguments.getString(ARG_LANGUAGE, VideoLanguage.ENGLISH)) == null) ? VideoLanguage.ENGLISH : string;
    }

    private boolean isHindiLanguage(String language) {
        return language != null && VideoLanguage.HINDI.equalsIgnoreCase(language);
    }

    private boolean isValidVideoId(String videoId) {
        return videoId != null && YOUTUBE_VIDEO_ID_PATTERN.matcher(videoId).matches();
    }

    private boolean areViewsAvailable() {
        return (this.youtubePlayerView == null || this.statusTextView == null || this.dismissButton == null) ? false : true;
    }

    private void cancelAllCallbacks() {
        cancelPlayerLoadTimeout();
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.dimAmount = 0.7f;
        window.setAttributes(layoutParams);
        window.addFlags(2);
    }

    public void onStop() {
        pausePlayer();
        super.onStop();
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_VIDEO_COMPLETED, this.videoCompleted);
        outState.putBoolean(STATE_TECHNICAL_FAILURE, this.technicalFailure);
        super.onSaveInstanceState(outState);
    }

    public void onDestroyView() {
        cancelAllCallbacks();
        this.playerReleased = true;
        this.playerReady = false;
        pausePlayer();
        this.youTubePlayer = null;
        this.progressBar = null;
        YouTubePlayerView youTubePlayerView = this.youtubePlayerView;
        if (youTubePlayerView != null) {
            try {
                youTubePlayerView.release();
            } catch (Exception e) {
                Log.w(LOG_TAG, "Unable to release YouTubePlayerView", e);
            }
        }
        this.youtubePlayerView = null;
        this.titleTextView = null;
        this.messageTextView = null;
        this.statusTextView = null;
        this.dismissButton = null;
        super.onDestroyView();
    }

    public void onDetach() {
        cancelAllCallbacks();
        this.completionListener = null;
        super.onDetach();
    }
}
