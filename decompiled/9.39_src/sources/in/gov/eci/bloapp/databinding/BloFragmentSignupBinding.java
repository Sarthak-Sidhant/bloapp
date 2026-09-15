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

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentSignupBinding implements ViewBinding {
    public final TextInputEditText emailEd;
    public final ImageView imageView4;
    public final LinearLayout linearLayout5;
    public final TextView login;
    public final TextInputEditText mobileNumEd;
    public final LinearLayout requestOtpLayout;
    private final ConstraintLayout rootView;
    public final TextView textView19;

    private BloFragmentSignupBinding(ConstraintLayout rootView, TextInputEditText emailEd, ImageView imageView4, LinearLayout linearLayout5, TextView login, TextInputEditText mobileNumEd, LinearLayout requestOtpLayout, TextView textView19) {
        this.rootView = rootView;
        this.emailEd = emailEd;
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

    public static BloFragmentSignupBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentSignupBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_signup, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentSignupBinding bind(View rootView) {
        int i = R.id.email_ed;
        TextInputEditText textInputEditTextFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.email_ed);
        if (textInputEditTextFindChildViewById != null) {
            i = R.id.imageView4;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView4);
            if (imageView != null) {
                i = R.id.linearLayout5;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout5);
                if (linearLayout != null) {
                    i = R.id.login;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.login);
                    if (textView != null) {
                        i = R.id.mobile_num_ed;
                        TextInputEditText textInputEditTextFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.mobile_num_ed);
                        if (textInputEditTextFindChildViewById2 != null) {
                            i = R.id.request_otp_layout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.request_otp_layout);
                            if (linearLayout2 != null) {
                                i = R.id.textView19;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView19);
                                if (textView2 != null) {
                                    return new BloFragmentSignupBinding((ConstraintLayout) rootView, textInputEditTextFindChildViewById, imageView, linearLayout, textView, textInputEditTextFindChildViewById2, linearLayout2, textView2);
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
