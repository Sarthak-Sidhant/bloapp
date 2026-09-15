package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.chaos.view.PinView;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentSignupOtpBinding implements ViewBinding {
    public final TextView backBtnIv;
    public final TextView emailOtpHeader;
    public final ImageView imageView4;
    public final LinearLayout linearLayout5;
    public final TextView otpTimerEmail;
    public final TextView otpTimers;
    public final PinView pinView;
    public final PinView pinViewSignup;
    private final ConstraintLayout rootView;
    public final TextView textView19;
    public final LinearLayout verifySignotpLayout;
    public final LinearLayout verifySignupotpLayout;
    public final View view1;

    private BloFragmentSignupOtpBinding(ConstraintLayout rootView, TextView backBtnIv, TextView emailOtpHeader, ImageView imageView4, LinearLayout linearLayout5, TextView otpTimerEmail, TextView otpTimers, PinView pinView, PinView pinViewSignup, TextView textView19, LinearLayout verifySignotpLayout, LinearLayout verifySignupotpLayout, View view1) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.emailOtpHeader = emailOtpHeader;
        this.imageView4 = imageView4;
        this.linearLayout5 = linearLayout5;
        this.otpTimerEmail = otpTimerEmail;
        this.otpTimers = otpTimers;
        this.pinView = pinView;
        this.pinViewSignup = pinViewSignup;
        this.textView19 = textView19;
        this.verifySignotpLayout = verifySignotpLayout;
        this.verifySignupotpLayout = verifySignupotpLayout;
        this.view1 = view1;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentSignupOtpBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentSignupOtpBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_signup_otp, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentSignupOtpBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (textView != null) {
            i = R.id.email_otp_header;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.email_otp_header);
            if (textView2 != null) {
                i = R.id.imageView4;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView4);
                if (imageView != null) {
                    i = R.id.linearLayout5;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout5);
                    if (linearLayout != null) {
                        i = R.id.otp_timer_email;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.otp_timer_email);
                        if (textView3 != null) {
                            i = R.id.otp_timers;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.otp_timers);
                            if (textView4 != null) {
                                i = R.id.pin_view;
                                PinView pinViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.pin_view);
                                if (pinViewFindChildViewById != null) {
                                    i = R.id.pin_view_signup;
                                    PinView pinViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.pin_view_signup);
                                    if (pinViewFindChildViewById2 != null) {
                                        i = R.id.textView19;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView19);
                                        if (textView5 != null) {
                                            i = R.id.verify_signotp_layout;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.verify_signotp_layout);
                                            if (linearLayout2 != null) {
                                                i = R.id.verify_signupotp_layout;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.verify_signupotp_layout);
                                                if (linearLayout3 != null) {
                                                    i = R.id.view1;
                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                                                    if (viewFindChildViewById != null) {
                                                        return new BloFragmentSignupOtpBinding((ConstraintLayout) rootView, textView, textView2, imageView, linearLayout, textView3, textView4, pinViewFindChildViewById, pinViewFindChildViewById2, textView5, linearLayout2, linearLayout3, viewFindChildViewById);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
