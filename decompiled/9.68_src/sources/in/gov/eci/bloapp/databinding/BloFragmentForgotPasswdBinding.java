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
import com.google.android.material.textfield.TextInputEditText;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentForgotPasswdBinding implements ViewBinding {
    public final LinearLayout forgetPasswordLayout;
    public final ImageView imageView4;
    public final LinearLayout linearLayout5;
    public final TextView login;
    public final TextInputEditText mobileNumEd;
    public final LinearLayout requestOtpLayout;
    private final ConstraintLayout rootView;
    public final TextView textView19;

    private BloFragmentForgotPasswdBinding(ConstraintLayout rootView, LinearLayout forgetPasswordLayout, ImageView imageView4, LinearLayout linearLayout5, TextView login, TextInputEditText mobileNumEd, LinearLayout requestOtpLayout, TextView textView19) {
        this.rootView = rootView;
        this.forgetPasswordLayout = forgetPasswordLayout;
        this.imageView4 = imageView4;
        this.linearLayout5 = linearLayout5;
        this.login = login;
        this.mobileNumEd = mobileNumEd;
        this.requestOtpLayout = requestOtpLayout;
        this.textView19 = textView19;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentForgotPasswdBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentForgotPasswdBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_forgot_passwd, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentForgotPasswdBinding bind(View rootView) {
        int i = R.id.forget_password_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.forget_password_layout);
        if (linearLayout != null) {
            i = R.id.imageView4;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView4);
            if (imageView != null) {
                i = R.id.linearLayout5;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout5);
                if (linearLayout2 != null) {
                    i = R.id.login;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.login);
                    if (textView != null) {
                        i = R.id.mobile_num_ed;
                        TextInputEditText textInputEditTextFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.mobile_num_ed);
                        if (textInputEditTextFindChildViewById != null) {
                            i = R.id.request_otp_layout;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.request_otp_layout);
                            if (linearLayout3 != null) {
                                i = R.id.textView19;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView19);
                                if (textView2 != null) {
                                    return new BloFragmentForgotPasswdBinding((ConstraintLayout) rootView, linearLayout, imageView, linearLayout2, textView, textInputEditTextFindChildViewById, linearLayout3, textView2);
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
