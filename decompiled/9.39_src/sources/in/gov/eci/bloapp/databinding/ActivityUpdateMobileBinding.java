package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityUpdateMobileBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final MaterialButton btnOk;
    public final LinearLayout ccEf;
    public final CardView cdMobilenumber;
    public final TextView electorNamePendingSir;
    public final TextView epicPendingSir;
    public final EditText etmobilenumber;
    public final LinearLayout llAge;
    public final RadioButton rbMobilenumber;
    public final RadioButton rbUpdateMobilenumber;
    private final ScrollView rootView;
    public final TextView serialNoPendingSir;
    public final TextView textAge;
    public final TextView textView3;
    public final TextView textView5;
    public final ImageView toolbarButton;
    public final TextView tvHeading;
    public final TextView tvMobilenumber;
    public final TextView tvMobilenumbervalue;

    private ActivityUpdateMobileBinding(ScrollView rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, MaterialButton btnOk, LinearLayout ccEf, CardView cdMobilenumber, TextView electorNamePendingSir, TextView epicPendingSir, EditText etmobilenumber, LinearLayout llAge, RadioButton rbMobilenumber, RadioButton rbUpdateMobilenumber, TextView serialNoPendingSir, TextView textAge, TextView textView3, TextView textView5, ImageView toolbarButton, TextView tvHeading, TextView tvMobilenumber, TextView tvMobilenumbervalue) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.btnOk = btnOk;
        this.ccEf = ccEf;
        this.cdMobilenumber = cdMobilenumber;
        this.electorNamePendingSir = electorNamePendingSir;
        this.epicPendingSir = epicPendingSir;
        this.etmobilenumber = etmobilenumber;
        this.llAge = llAge;
        this.rbMobilenumber = rbMobilenumber;
        this.rbUpdateMobilenumber = rbUpdateMobilenumber;
        this.serialNoPendingSir = serialNoPendingSir;
        this.textAge = textAge;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbarButton = toolbarButton;
        this.tvHeading = tvHeading;
        this.tvMobilenumber = tvMobilenumber;
        this.tvMobilenumbervalue = tvMobilenumbervalue;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ActivityUpdateMobileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityUpdateMobileBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_update_mobile, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityUpdateMobileBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.btnOk;
                MaterialButton materialButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.btnOk);
                if (materialButtonFindChildViewById != null) {
                    i = R.id.ccEf;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ccEf);
                    if (linearLayout != null) {
                        i = R.id.cd_mobilenumber;
                        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cd_mobilenumber);
                        if (cardViewFindChildViewById != null) {
                            i = R.id.electorName_pending_sir;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName_pending_sir);
                            if (textView != null) {
                                i = R.id.epic_pending_sir;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_pending_sir);
                                if (textView2 != null) {
                                    i = R.id.etmobilenumber;
                                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.etmobilenumber);
                                    if (editText != null) {
                                        i = R.id.ll_age;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_age);
                                        if (linearLayout2 != null) {
                                            i = R.id.rbMobilenumber;
                                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rbMobilenumber);
                                            if (radioButton != null) {
                                                i = R.id.rbUpdateMobilenumber;
                                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rbUpdateMobilenumber);
                                                if (radioButton2 != null) {
                                                    i = R.id.serialNo_pending_sir;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_pending_sir);
                                                    if (textView3 != null) {
                                                        i = R.id.text_age;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.text_age);
                                                        if (textView4 != null) {
                                                            i = R.id.textView3;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                            if (textView5 != null) {
                                                                i = R.id.textView5;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                                                if (textView6 != null) {
                                                                    i = R.id.toolbar_button;
                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                                    if (imageView2 != null) {
                                                                        i = R.id.tvHeading;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvHeading);
                                                                        if (textView7 != null) {
                                                                            i = R.id.tvMobilenumber;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvMobilenumber);
                                                                            if (textView8 != null) {
                                                                                i = R.id.tvMobilenumbervalue;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvMobilenumbervalue);
                                                                                if (textView9 != null) {
                                                                                    return new ActivityUpdateMobileBinding((ScrollView) rootView, imageView, constraintLayoutFindChildViewById, materialButtonFindChildViewById, linearLayout, cardViewFindChildViewById, textView, textView2, editText, linearLayout2, radioButton, radioButton2, textView3, textView4, textView5, textView6, imageView2, textView7, textView8, textView9);
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
