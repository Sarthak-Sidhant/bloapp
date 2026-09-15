package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentLoginBinding implements ViewBinding {
    public final TextView appVersion;
    public final TextView forgotPasswordTv;
    public final ImageView imageView4;
    public final LinearLayout linearLayout;
    public final LinearLayout linearLayout5;
    public final TextInputEditText mobileNumEd;
    public final TextInputEditText passwordEd;
    public final LinearLayout requestOtpLayout;
    private final ConstraintLayout rootView;
    public final NestedScrollView scrollView;
    public final TextView textView19;
    public final TextInputLayout textsingleSelect;

    private BloFragmentLoginBinding(ConstraintLayout rootView, TextView appVersion, TextView forgotPasswordTv, ImageView imageView4, LinearLayout linearLayout, LinearLayout linearLayout5, TextInputEditText mobileNumEd, TextInputEditText passwordEd, LinearLayout requestOtpLayout, NestedScrollView scrollView, TextView textView19, TextInputLayout textsingleSelect) {
        this.rootView = rootView;
        this.appVersion = appVersion;
        this.forgotPasswordTv = forgotPasswordTv;
        this.imageView4 = imageView4;
        this.linearLayout = linearLayout;
        this.linearLayout5 = linearLayout5;
        this.mobileNumEd = mobileNumEd;
        this.passwordEd = passwordEd;
        this.requestOtpLayout = requestOtpLayout;
        this.scrollView = scrollView;
        this.textView19 = textView19;
        this.textsingleSelect = textsingleSelect;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentLoginBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentLoginBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_login, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentLoginBinding bind(View rootView) {
        int i = R.id.app_version;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.app_version);
        if (textView != null) {
            i = R.id.forgot_password_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.forgot_password_tv);
            if (textView2 != null) {
                i = R.id.imageView4;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView4);
                if (imageView != null) {
                    i = R.id.linearLayout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout);
                    if (linearLayout != null) {
                        i = R.id.linearLayout5;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout5);
                        if (linearLayout2 != null) {
                            i = R.id.mobile_num_ed;
                            TextInputEditText textInputEditTextFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.mobile_num_ed);
                            if (textInputEditTextFindChildViewById != null) {
                                i = R.id.password_ed;
                                TextInputEditText textInputEditTextFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.password_ed);
                                if (textInputEditTextFindChildViewById2 != null) {
                                    i = R.id.request_otp_layout;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.request_otp_layout);
                                    if (linearLayout3 != null) {
                                        i = 2131365794;
                                        NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, 2131365794);
                                        if (nestedScrollViewFindChildViewById != null) {
                                            i = R.id.textView19;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView19);
                                            if (textView3 != null) {
                                                i = R.id.textsingleSelect;
                                                TextInputLayout textInputLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.textsingleSelect);
                                                if (textInputLayoutFindChildViewById != null) {
                                                    return new BloFragmentLoginBinding((ConstraintLayout) rootView, textView, textView2, imageView, linearLayout, linearLayout2, textInputEditTextFindChildViewById, textInputEditTextFindChildViewById2, linearLayout3, nestedScrollViewFindChildViewById, textView3, textInputLayoutFindChildViewById);
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
