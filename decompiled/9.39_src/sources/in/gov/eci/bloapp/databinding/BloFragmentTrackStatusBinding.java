package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentTrackStatusBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final CardView cardViewLayout;
    public final ConstraintLayout constraintLayout;
    public final FrameLayout frame;
    public final ImageView homeBtnIv;
    public final LinearLayout linearLayout;
    public final EditText referenceIdEd;
    public final LinearLayout requestOtpLayout;
    private final ConstraintLayout rootView;
    public final TextView textView11;
    public final TextView textView3;
    public final TextView trackStatusLayout;

    private BloFragmentTrackStatusBinding(ConstraintLayout rootView, ImageView backBtnIv, CardView cardViewLayout, ConstraintLayout constraintLayout, FrameLayout frame, ImageView homeBtnIv, LinearLayout linearLayout, EditText referenceIdEd, LinearLayout requestOtpLayout, TextView textView11, TextView textView3, TextView trackStatusLayout) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.cardViewLayout = cardViewLayout;
        this.constraintLayout = constraintLayout;
        this.frame = frame;
        this.homeBtnIv = homeBtnIv;
        this.linearLayout = linearLayout;
        this.referenceIdEd = referenceIdEd;
        this.requestOtpLayout = requestOtpLayout;
        this.textView11 = textView11;
        this.textView3 = textView3;
        this.trackStatusLayout = trackStatusLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentTrackStatusBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentTrackStatusBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_track_status, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentTrackStatusBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.cardView_Layout;
            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView_Layout);
            if (cardViewFindChildViewById != null) {
                i = R.id.constraintLayout;
                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
                if (constraintLayoutFindChildViewById != null) {
                    i = R.id.frame;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.frame);
                    if (frameLayout != null) {
                        i = R.id.home_btn_iv;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                        if (imageView2 != null) {
                            i = R.id.linearLayout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout);
                            if (linearLayout != null) {
                                i = R.id.reference_id_ed;
                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.reference_id_ed);
                                if (editText != null) {
                                    i = R.id.request_otp_layout;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.request_otp_layout);
                                    if (linearLayout2 != null) {
                                        i = R.id.textView11;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView11);
                                        if (textView != null) {
                                            i = R.id.textView3;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                            if (textView2 != null) {
                                                i = R.id.track_status_layout;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.track_status_layout);
                                                if (textView3 != null) {
                                                    return new BloFragmentTrackStatusBinding((ConstraintLayout) rootView, imageView, cardViewFindChildViewById, constraintLayoutFindChildViewById, frameLayout, imageView2, linearLayout, editText, linearLayout2, textView, textView2, textView3);
                                                }
                                            }
                                        }
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
