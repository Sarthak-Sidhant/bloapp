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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentOtpBinding implements ViewBinding {
    public final TextView backBtnIv;
    public final ImageView imageView4;
    public final LinearLayout linearLayout5;
    public final TextView mobileno;
    public final TextView otpTimer;
    public final PinView pinView;
    private final ConstraintLayout rootView;
    public final TextView textView19;
    public final TextView verifyOtpLayout;

    private BloFragmentOtpBinding(ConstraintLayout rootView, TextView backBtnIv, ImageView imageView4, LinearLayout linearLayout5, TextView mobileno, TextView otpTimer, PinView pinView, TextView textView19, TextView verifyOtpLayout) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.imageView4 = imageView4;
        this.linearLayout5 = linearLayout5;
        this.mobileno = mobileno;
        this.otpTimer = otpTimer;
        this.pinView = pinView;
        this.textView19 = textView19;
        this.verifyOtpLayout = verifyOtpLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentOtpBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentOtpBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_otp, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentOtpBinding bind(View rootView) {
        int i = R.id.backBtnIv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.backBtnIv);
        if (textView != null) {
            i = R.id.imageView4;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView4);
            if (imageView != null) {
                i = R.id.linearLayout5;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout5);
                if (linearLayout != null) {
                    i = R.id.mobileno;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobileno);
                    if (textView2 != null) {
                        i = R.id.otp_timer;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.otp_timer);
                        if (textView3 != null) {
                            i = R.id.pin_view;
                            PinView pinViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.pin_view);
                            if (pinViewFindChildViewById != null) {
                                i = R.id.textView19;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView19);
                                if (textView4 != null) {
                                    i = R.id.verify_otp_layout;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.verify_otp_layout);
                                    if (textView5 != null) {
                                        return new BloFragmentOtpBinding((ConstraintLayout) rootView, textView, imageView, linearLayout, textView2, textView3, pinViewFindChildViewById, textView4, textView5);
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
