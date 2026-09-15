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
public final class BloFragmentSignupInfoBinding implements ViewBinding {
    public final TextView backBtnIv;
    public final TextInputEditText confirmPasswdEd;
    public final TextInputEditText firstnameEd;
    public final ImageView imageView4;
    public final TextInputEditText lastNameEd;
    public final LinearLayout linearLayout5;
    public final TextInputEditText passwordEd;
    private final ConstraintLayout rootView;
    public final LinearLayout signUp;
    public final TextView textView19;

    private BloFragmentSignupInfoBinding(ConstraintLayout rootView, TextView backBtnIv, TextInputEditText confirmPasswdEd, TextInputEditText firstnameEd, ImageView imageView4, TextInputEditText lastNameEd, LinearLayout linearLayout5, TextInputEditText passwordEd, LinearLayout signUp, TextView textView19) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.confirmPasswdEd = confirmPasswdEd;
        this.firstnameEd = firstnameEd;
        this.imageView4 = imageView4;
        this.lastNameEd = lastNameEd;
        this.linearLayout5 = linearLayout5;
        this.passwordEd = passwordEd;
        this.signUp = signUp;
        this.textView19 = textView19;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentSignupInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentSignupInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_signup_info, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentSignupInfoBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (textView != null) {
            i = R.id.confirm_passwd_ed;
            TextInputEditText textInputEditTextFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.confirm_passwd_ed);
            if (textInputEditTextFindChildViewById != null) {
                i = R.id.firstname_ed;
                TextInputEditText textInputEditTextFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.firstname_ed);
                if (textInputEditTextFindChildViewById2 != null) {
                    i = R.id.imageView4;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView4);
                    if (imageView != null) {
                        i = R.id.last_name_ed;
                        TextInputEditText textInputEditTextFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.last_name_ed);
                        if (textInputEditTextFindChildViewById3 != null) {
                            i = R.id.linearLayout5;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout5);
                            if (linearLayout != null) {
                                i = R.id.password_ed;
                                TextInputEditText textInputEditTextFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.password_ed);
                                if (textInputEditTextFindChildViewById4 != null) {
                                    i = R.id.sign_up;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sign_up);
                                    if (linearLayout2 != null) {
                                        i = R.id.textView19;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView19);
                                        if (textView2 != null) {
                                            return new BloFragmentSignupInfoBinding((ConstraintLayout) rootView, textView, textInputEditTextFindChildViewById, textInputEditTextFindChildViewById2, imageView, textInputEditTextFindChildViewById3, linearLayout, textInputEditTextFindChildViewById4, linearLayout2, textView2);
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
