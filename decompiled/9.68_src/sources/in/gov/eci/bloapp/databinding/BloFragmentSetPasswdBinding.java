package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentSetPasswdBinding implements ViewBinding {
    public final TextView AtoZ;
    public final TextView backBtnIv;
    public final TextView charcountTv;
    public final TextView confirmPassLayout;
    public final TextInputEditText confirmPasswdEd;
    public final ImageView correctButton;
    public final LinearLayout forgetPasswordLayout;
    public final ImageView imageView4;
    public final LinearLayout linearLayout5;
    public final LinearLayout linearLayoutConformation;
    public final AppCompatButton login;
    public final LinearLayout loginLinearLayout;
    public final TextView numtocountTv;
    public final TextInputEditText passwordEd;
    private final ConstraintLayout rootView;
    public final ImageView shapeCorrectSign1;
    public final ImageView shapeCorrectSign2;
    public final ImageView shapeCorrectSign3;
    public final ImageView shapeCorrectSign4;
    public final TextView specialcharsTv;
    public final TextView textView19;
    public final TextView textView2;
    public final TextInputLayout textconfirmPassword;
    public final TextInputLayout textsingleSelect;

    private BloFragmentSetPasswdBinding(ConstraintLayout rootView, TextView AtoZ, TextView backBtnIv, TextView charcountTv, TextView confirmPassLayout, TextInputEditText confirmPasswdEd, ImageView correctButton, LinearLayout forgetPasswordLayout, ImageView imageView4, LinearLayout linearLayout5, LinearLayout linearLayoutConformation, AppCompatButton login, LinearLayout loginLinearLayout, TextView numtocountTv, TextInputEditText passwordEd, ImageView shapeCorrectSign1, ImageView shapeCorrectSign2, ImageView shapeCorrectSign3, ImageView shapeCorrectSign4, TextView specialcharsTv, TextView textView19, TextView textView2, TextInputLayout textconfirmPassword, TextInputLayout textsingleSelect) {
        this.rootView = rootView;
        this.AtoZ = AtoZ;
        this.backBtnIv = backBtnIv;
        this.charcountTv = charcountTv;
        this.confirmPassLayout = confirmPassLayout;
        this.confirmPasswdEd = confirmPasswdEd;
        this.correctButton = correctButton;
        this.forgetPasswordLayout = forgetPasswordLayout;
        this.imageView4 = imageView4;
        this.linearLayout5 = linearLayout5;
        this.linearLayoutConformation = linearLayoutConformation;
        this.login = login;
        this.loginLinearLayout = loginLinearLayout;
        this.numtocountTv = numtocountTv;
        this.passwordEd = passwordEd;
        this.shapeCorrectSign1 = shapeCorrectSign1;
        this.shapeCorrectSign2 = shapeCorrectSign2;
        this.shapeCorrectSign3 = shapeCorrectSign3;
        this.shapeCorrectSign4 = shapeCorrectSign4;
        this.specialcharsTv = specialcharsTv;
        this.textView19 = textView19;
        this.textView2 = textView2;
        this.textconfirmPassword = textconfirmPassword;
        this.textsingleSelect = textsingleSelect;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentSetPasswdBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentSetPasswdBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_set_passwd, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentSetPasswdBinding bind(View rootView) {
        int i = R.id.AtoZ;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.AtoZ);
        if (textView != null) {
            i = R.id.back_btn_iv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
            if (textView2 != null) {
                i = R.id.charcount_tv;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.charcount_tv);
                if (textView3 != null) {
                    i = R.id.confirm_pass_layout;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.confirm_pass_layout);
                    if (textView4 != null) {
                        i = R.id.confirm_passwd_ed;
                        TextInputEditText textInputEditTextFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.confirm_passwd_ed);
                        if (textInputEditTextFindChildViewById != null) {
                            i = R.id.correct_button;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.correct_button);
                            if (imageView != null) {
                                i = R.id.forget_password_layout;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.forget_password_layout);
                                if (linearLayout != null) {
                                    i = R.id.imageView4;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView4);
                                    if (imageView2 != null) {
                                        i = R.id.linearLayout5;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout5);
                                        if (linearLayout2 != null) {
                                            i = R.id.linearLayout_conformation;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout_conformation);
                                            if (linearLayout3 != null) {
                                                i = R.id.login;
                                                AppCompatButton appCompatButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.login);
                                                if (appCompatButtonFindChildViewById != null) {
                                                    i = R.id.login_linearLayout;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.login_linearLayout);
                                                    if (linearLayout4 != null) {
                                                        i = R.id.numtocount_tv;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.numtocount_tv);
                                                        if (textView5 != null) {
                                                            i = R.id.password_ed;
                                                            TextInputEditText textInputEditTextFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.password_ed);
                                                            if (textInputEditTextFindChildViewById2 != null) {
                                                                i = R.id.shape_correct_sign1;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shape_correct_sign1);
                                                                if (imageView3 != null) {
                                                                    i = R.id.shape_correct_sign2;
                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shape_correct_sign2);
                                                                    if (imageView4 != null) {
                                                                        i = R.id.shape_correct_sign3;
                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shape_correct_sign3);
                                                                        if (imageView5 != null) {
                                                                            i = R.id.shape_correct_sign4;
                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shape_correct_sign4);
                                                                            if (imageView6 != null) {
                                                                                i = R.id.specialchars_tv;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.specialchars_tv);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.textView19;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView19);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.textView2;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView2);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.textconfirmPassword;
                                                                                            TextInputLayout textInputLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.textconfirmPassword);
                                                                                            if (textInputLayoutFindChildViewById != null) {
                                                                                                i = R.id.textsingleSelect;
                                                                                                TextInputLayout textInputLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.textsingleSelect);
                                                                                                if (textInputLayoutFindChildViewById2 != null) {
                                                                                                    return new BloFragmentSetPasswdBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, textInputEditTextFindChildViewById, imageView, linearLayout, imageView2, linearLayout2, linearLayout3, appCompatButtonFindChildViewById, linearLayout4, textView5, textInputEditTextFindChildViewById2, imageView3, imageView4, imageView5, imageView6, textView6, textView7, textView8, textInputLayoutFindChildViewById, textInputLayoutFindChildViewById2);
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
