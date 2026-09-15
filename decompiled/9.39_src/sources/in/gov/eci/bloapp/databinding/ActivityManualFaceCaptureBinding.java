package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.yoti.mobile.android.capture.face.ui.FaceCapture;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityManualFaceCaptureBinding implements ViewBinding {
    public final ImageView cameraFaceFrame;
    public final ImageView cameraFaceMaskBorder;
    public final ImageView captureResult;
    public final FaceCapture faceCaptureView;
    public final Guideline guideline;
    public final Guideline guidelineBottomText;
    public final Button manualCaptureButton;
    private final ConstraintLayout rootView;
    public final TextView userFeedback;

    private ActivityManualFaceCaptureBinding(ConstraintLayout rootView, ImageView cameraFaceFrame, ImageView cameraFaceMaskBorder, ImageView captureResult, FaceCapture faceCaptureView, Guideline guideline, Guideline guidelineBottomText, Button manualCaptureButton, TextView userFeedback) {
        this.rootView = rootView;
        this.cameraFaceFrame = cameraFaceFrame;
        this.cameraFaceMaskBorder = cameraFaceMaskBorder;
        this.captureResult = captureResult;
        this.faceCaptureView = faceCaptureView;
        this.guideline = guideline;
        this.guidelineBottomText = guidelineBottomText;
        this.manualCaptureButton = manualCaptureButton;
        this.userFeedback = userFeedback;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityManualFaceCaptureBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityManualFaceCaptureBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_manual_face_capture, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityManualFaceCaptureBinding bind(View rootView) {
        int i = R.id.camera_face_frame;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.camera_face_frame);
        if (imageView != null) {
            i = R.id.camera_face_mask_border;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.camera_face_mask_border);
            if (imageView2 != null) {
                i = R.id.capture_result;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.capture_result);
                if (imageView3 != null) {
                    i = R.id.face_capture_view;
                    FaceCapture faceCapture = (FaceCapture) ViewBindings.findChildViewById(rootView, R.id.face_capture_view);
                    if (faceCapture != null) {
                        i = R.id.guideline;
                        Guideline guidelineFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.guideline);
                        if (guidelineFindChildViewById != null) {
                            i = R.id.guideline_bottom_text;
                            Guideline guidelineFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.guideline_bottom_text);
                            if (guidelineFindChildViewById2 != null) {
                                i = R.id.manual_capture_button;
                                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.manual_capture_button);
                                if (button != null) {
                                    i = R.id.user_feedback;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.user_feedback);
                                    if (textView != null) {
                                        return new ActivityManualFaceCaptureBinding((ConstraintLayout) rootView, imageView, imageView2, imageView3, faceCapture, guidelineFindChildViewById, guidelineFindChildViewById2, button, textView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
