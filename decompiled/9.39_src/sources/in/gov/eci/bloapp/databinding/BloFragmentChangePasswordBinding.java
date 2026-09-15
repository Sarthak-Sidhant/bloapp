package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentChangePasswordBinding implements ViewBinding {
    public final TextView AtoZ;
    public final LinearLayout basicdetailsHeading;
    public final TextView charcountTv;
    public final TextInputEditText confirmPasswdEd;
    public final ImageView correctButton;
    public final EditText entotp;
    public final LinearLayout linearLayoutForBtns;
    public final LinearLayout linearLayoutSendBtns;
    public final TextView mobileNumEd;
    public final TextView numtocountTv;
    public final LinearLayout otpresend;
    public final TextInputEditText passwordEd;
    public final LinearLayout resend;
    public final TextView resendotpButton;
    private final ConstraintLayout rootView;
    public final AppCompatButton sendotpButton;
    public final ImageView shapeCorrectSign1;
    public final ImageView shapeCorrectSign2;
    public final ImageView shapeCorrectSign3;
    public final ImageView shapeCorrectSign4;
    public final TextView specialcharsTv;
    public final TextView textView2;
    public final TextView textView3;
    public final TextView textView4;
    public final TextView textView5;
    public final TextView textView6;
    public final TextView textView7;
    public final TextInputLayout textconfirmPassword;
    public final TextInputLayout textsingleSelect;
    public final TextView updateButton;
    public final AppCompatButton verifyotp;
    public final LinearLayout verifysendotp;

    private BloFragmentChangePasswordBinding(ConstraintLayout rootView, TextView AtoZ, LinearLayout basicdetailsHeading, TextView charcountTv, TextInputEditText confirmPasswdEd, ImageView correctButton, EditText entotp, LinearLayout linearLayoutForBtns, LinearLayout linearLayoutSendBtns, TextView mobileNumEd, TextView numtocountTv, LinearLayout otpresend, TextInputEditText passwordEd, LinearLayout resend, TextView resendotpButton, AppCompatButton sendotpButton, ImageView shapeCorrectSign1, ImageView shapeCorrectSign2, ImageView shapeCorrectSign3, ImageView shapeCorrectSign4, TextView specialcharsTv, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextInputLayout textconfirmPassword, TextInputLayout textsingleSelect, TextView updateButton, AppCompatButton verifyotp, LinearLayout verifysendotp) {
        this.rootView = rootView;
        this.AtoZ = AtoZ;
        this.basicdetailsHeading = basicdetailsHeading;
        this.charcountTv = charcountTv;
        this.confirmPasswdEd = confirmPasswdEd;
        this.correctButton = correctButton;
        this.entotp = entotp;
        this.linearLayoutForBtns = linearLayoutForBtns;
        this.linearLayoutSendBtns = linearLayoutSendBtns;
        this.mobileNumEd = mobileNumEd;
        this.numtocountTv = numtocountTv;
        this.otpresend = otpresend;
        this.passwordEd = passwordEd;
        this.resend = resend;
        this.resendotpButton = resendotpButton;
        this.sendotpButton = sendotpButton;
        this.shapeCorrectSign1 = shapeCorrectSign1;
        this.shapeCorrectSign2 = shapeCorrectSign2;
        this.shapeCorrectSign3 = shapeCorrectSign3;
        this.shapeCorrectSign4 = shapeCorrectSign4;
        this.specialcharsTv = specialcharsTv;
        this.textView2 = textView2;
        this.textView3 = textView3;
        this.textView4 = textView4;
        this.textView5 = textView5;
        this.textView6 = textView6;
        this.textView7 = textView7;
        this.textconfirmPassword = textconfirmPassword;
        this.textsingleSelect = textsingleSelect;
        this.updateButton = updateButton;
        this.verifyotp = verifyotp;
        this.verifysendotp = verifysendotp;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentChangePasswordBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentChangePasswordBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_change_password, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentChangePasswordBinding bind(View rootView) {
        int i = R.id.AtoZ;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.AtoZ);
        if (textView != null) {
            i = R.id.basicdetails_heading;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.basicdetails_heading);
            if (linearLayout != null) {
                i = R.id.charcount_tv;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.charcount_tv);
                if (textView2 != null) {
                    i = R.id.confirm_passwd_ed;
                    TextInputEditText textInputEditTextFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.confirm_passwd_ed);
                    if (textInputEditTextFindChildViewById != null) {
                        i = R.id.correct_button;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.correct_button);
                        if (imageView != null) {
                            i = R.id.entotp;
                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.entotp);
                            if (editText != null) {
                                i = R.id.linear_layout_for_btns;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_layout_for_btns);
                                if (linearLayout2 != null) {
                                    i = R.id.linear_layout_send_btns;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_layout_send_btns);
                                    if (linearLayout3 != null) {
                                        i = R.id.mobile_num_ed;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobile_num_ed);
                                        if (textView3 != null) {
                                            i = R.id.numtocount_tv;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.numtocount_tv);
                                            if (textView4 != null) {
                                                i = R.id.otpresend;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.otpresend);
                                                if (linearLayout4 != null) {
                                                    i = R.id.password_ed;
                                                    TextInputEditText textInputEditTextFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.password_ed);
                                                    if (textInputEditTextFindChildViewById2 != null) {
                                                        i = R.id.resend;
                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.resend);
                                                        if (linearLayout5 != null) {
                                                            i = R.id.resendotpButton;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resendotpButton);
                                                            if (textView5 != null) {
                                                                i = R.id.sendotpButton;
                                                                AppCompatButton appCompatButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.sendotpButton);
                                                                if (appCompatButtonFindChildViewById != null) {
                                                                    i = R.id.shape_correct_sign1;
                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shape_correct_sign1);
                                                                    if (imageView2 != null) {
                                                                        i = R.id.shape_correct_sign2;
                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shape_correct_sign2);
                                                                        if (imageView3 != null) {
                                                                            i = R.id.shape_correct_sign3;
                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shape_correct_sign3);
                                                                            if (imageView4 != null) {
                                                                                i = R.id.shape_correct_sign4;
                                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shape_correct_sign4);
                                                                                if (imageView5 != null) {
                                                                                    i = R.id.specialchars_tv;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.specialchars_tv);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.textView2;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView2);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.textView3;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                            if (textView8 != null) {
                                                                                                i = R.id.textView4;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView4);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.textView5;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                                                                                    if (textView10 != null) {
                                                                                                        i = R.id.textView6;
                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView6);
                                                                                                        if (textView11 != null) {
                                                                                                            i = R.id.textView7;
                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView7);
                                                                                                            if (textView12 != null) {
                                                                                                                i = R.id.textconfirmPassword;
                                                                                                                TextInputLayout textInputLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.textconfirmPassword);
                                                                                                                if (textInputLayoutFindChildViewById != null) {
                                                                                                                    i = R.id.textsingleSelect;
                                                                                                                    TextInputLayout textInputLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.textsingleSelect);
                                                                                                                    if (textInputLayoutFindChildViewById2 != null) {
                                                                                                                        i = R.id.updateButton;
                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.updateButton);
                                                                                                                        if (textView13 != null) {
                                                                                                                            i = R.id.verifyotp;
                                                                                                                            AppCompatButton appCompatButtonFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.verifyotp);
                                                                                                                            if (appCompatButtonFindChildViewById2 != null) {
                                                                                                                                i = R.id.verifysendotp;
                                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.verifysendotp);
                                                                                                                                if (linearLayout6 != null) {
                                                                                                                                    return new BloFragmentChangePasswordBinding((ConstraintLayout) rootView, textView, linearLayout, textView2, textInputEditTextFindChildViewById, imageView, editText, linearLayout2, linearLayout3, textView3, textView4, linearLayout4, textInputEditTextFindChildViewById2, linearLayout5, textView5, appCompatButtonFindChildViewById, imageView2, imageView3, imageView4, imageView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textInputLayoutFindChildViewById, textInputLayoutFindChildViewById2, textView13, appCompatButtonFindChildViewById2, linearLayout6);
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
