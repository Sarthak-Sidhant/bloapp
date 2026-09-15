package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class Form8PersonalDetailsBinding implements ViewBinding {
    public final TextView applicantNameTv1;
    public final TextView checkDseButton;
    public final RadioGroup dobRg;
    public final LinearLayout eRelative;
    public final LinearLayout eSelf;
    public final TextView epicNumberTv1;
    public final TextView genderTv1;
    public final LinearLayout mRelative;
    public final LinearLayout mSelf;
    public final TextView mobilenotv;
    public final RadioButton otherDobRb;
    public final TextView pEmailTv;
    public final CardView personalDetailsCv;
    public final Button personalDetailsEdit;
    public final BloFragmentForm8PoolingQueBinding poolingQuestionIncludeLay;
    public final TextView relativeTv1;
    public final TextView relativemobilenotv;
    private final ConstraintLayout rootView;
    public final RadioButton sameDobRb;
    public final TextView selfpEmailTv;
    public final LinearLayout subBasicdetails1;
    public final LinearLayout subBasicdetails2;
    public final TextView tvPersonalEditTextview;

    private Form8PersonalDetailsBinding(ConstraintLayout rootView, TextView applicantNameTv1, TextView checkDseButton, RadioGroup dobRg, LinearLayout eRelative, LinearLayout eSelf, TextView epicNumberTv1, TextView genderTv1, LinearLayout mRelative, LinearLayout mSelf, TextView mobilenotv, RadioButton otherDobRb, TextView pEmailTv, CardView personalDetailsCv, Button personalDetailsEdit, BloFragmentForm8PoolingQueBinding poolingQuestionIncludeLay, TextView relativeTv1, TextView relativemobilenotv, RadioButton sameDobRb, TextView selfpEmailTv, LinearLayout subBasicdetails1, LinearLayout subBasicdetails2, TextView tvPersonalEditTextview) {
        this.rootView = rootView;
        this.applicantNameTv1 = applicantNameTv1;
        this.checkDseButton = checkDseButton;
        this.dobRg = dobRg;
        this.eRelative = eRelative;
        this.eSelf = eSelf;
        this.epicNumberTv1 = epicNumberTv1;
        this.genderTv1 = genderTv1;
        this.mRelative = mRelative;
        this.mSelf = mSelf;
        this.mobilenotv = mobilenotv;
        this.otherDobRb = otherDobRb;
        this.pEmailTv = pEmailTv;
        this.personalDetailsCv = personalDetailsCv;
        this.personalDetailsEdit = personalDetailsEdit;
        this.poolingQuestionIncludeLay = poolingQuestionIncludeLay;
        this.relativeTv1 = relativeTv1;
        this.relativemobilenotv = relativemobilenotv;
        this.sameDobRb = sameDobRb;
        this.selfpEmailTv = selfpEmailTv;
        this.subBasicdetails1 = subBasicdetails1;
        this.subBasicdetails2 = subBasicdetails2;
        this.tvPersonalEditTextview = tvPersonalEditTextview;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Form8PersonalDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static Form8PersonalDetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.form8_personal_details, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static Form8PersonalDetailsBinding bind(View rootView) {
        int i = R.id.applicant_name_tv1;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_name_tv1);
        if (textView != null) {
            i = R.id.check_dse_Button;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.check_dse_Button);
            if (textView2 != null) {
                i = R.id.dob_rg;
                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.dob_rg);
                if (radioGroup != null) {
                    i = R.id.eRelative;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.eRelative);
                    if (linearLayout != null) {
                        i = R.id.eSelf;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.eSelf);
                        if (linearLayout2 != null) {
                            i = R.id.epic_number_tv1;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_number_tv1);
                            if (textView3 != null) {
                                i = R.id.gender_tv1;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender_tv1);
                                if (textView4 != null) {
                                    i = R.id.mRelative;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mRelative);
                                    if (linearLayout3 != null) {
                                        i = R.id.mSelf;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mSelf);
                                        if (linearLayout4 != null) {
                                            i = R.id.mobilenotv;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobilenotv);
                                            if (textView5 != null) {
                                                i = R.id.other_dob_rb;
                                                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.other_dob_rb);
                                                if (radioButton != null) {
                                                    i = R.id.pEmail_tv;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pEmail_tv);
                                                    if (textView6 != null) {
                                                        i = R.id.personal_details_cv;
                                                        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.personal_details_cv);
                                                        if (cardViewFindChildViewById != null) {
                                                            i = R.id.personal_details_edit;
                                                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.personal_details_edit);
                                                            if (button != null) {
                                                                i = R.id.pooling_question_include_lay;
                                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.pooling_question_include_lay);
                                                                if (viewFindChildViewById != null) {
                                                                    BloFragmentForm8PoolingQueBinding bloFragmentForm8PoolingQueBindingBind = BloFragmentForm8PoolingQueBinding.bind(viewFindChildViewById);
                                                                    i = R.id.relative_tv1;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_tv1);
                                                                    if (textView7 != null) {
                                                                        i = R.id.relativemobilenotv;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relativemobilenotv);
                                                                        if (textView8 != null) {
                                                                            i = R.id.same_dob_rb;
                                                                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.same_dob_rb);
                                                                            if (radioButton2 != null) {
                                                                                i = R.id.selfpEmail_tv;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.selfpEmail_tv);
                                                                                if (textView9 != null) {
                                                                                    i = R.id.sub_basicdetails1;
                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails1);
                                                                                    if (linearLayout5 != null) {
                                                                                        i = R.id.sub_basicdetails2;
                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails2);
                                                                                        if (linearLayout6 != null) {
                                                                                            i = R.id.tv_personal_edit_textview;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_personal_edit_textview);
                                                                                            if (textView10 != null) {
                                                                                                return new Form8PersonalDetailsBinding((ConstraintLayout) rootView, textView, textView2, radioGroup, linearLayout, linearLayout2, textView3, textView4, linearLayout3, linearLayout4, textView5, radioButton, textView6, cardViewFindChildViewById, button, bloFragmentForm8PoolingQueBindingBind, textView7, textView8, radioButton2, textView9, linearLayout5, linearLayout6, textView10);
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
