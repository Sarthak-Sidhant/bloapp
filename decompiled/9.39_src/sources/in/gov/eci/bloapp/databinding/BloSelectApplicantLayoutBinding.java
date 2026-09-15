package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloSelectApplicantLayoutBinding implements ViewBinding {
    public final TextView AcEt;
    public final TextView AcTv;
    public final TextView ApplicantNameEt;
    public final TextView ApplicantNameTv;
    public final TextView ApplicantSurnameEt;
    public final TextView ApplicantSurnameTv;
    public final ConstraintLayout layout;
    public final TextView partNumberET;
    public final TextView partNumberTv;
    public final RadioButton radioButton;
    public final TextView relativeNameET;
    public final TextView relativeNameTv;
    public final TextView relativeSurnameET;
    public final TextView relativeSurnameTv;
    private final ConstraintLayout rootView;
    public final TextView serialNo;
    public final TextView serialNoEt;
    public final TextView stateET;
    public final TextView stateTv;
    public final View view2;

    private BloSelectApplicantLayoutBinding(ConstraintLayout rootView, TextView AcEt, TextView AcTv, TextView ApplicantNameEt, TextView ApplicantNameTv, TextView ApplicantSurnameEt, TextView ApplicantSurnameTv, ConstraintLayout layout, TextView partNumberET, TextView partNumberTv, RadioButton radioButton, TextView relativeNameET, TextView relativeNameTv, TextView relativeSurnameET, TextView relativeSurnameTv, TextView serialNo, TextView serialNoEt, TextView stateET, TextView stateTv, View view2) {
        this.rootView = rootView;
        this.AcEt = AcEt;
        this.AcTv = AcTv;
        this.ApplicantNameEt = ApplicantNameEt;
        this.ApplicantNameTv = ApplicantNameTv;
        this.ApplicantSurnameEt = ApplicantSurnameEt;
        this.ApplicantSurnameTv = ApplicantSurnameTv;
        this.layout = layout;
        this.partNumberET = partNumberET;
        this.partNumberTv = partNumberTv;
        this.radioButton = radioButton;
        this.relativeNameET = relativeNameET;
        this.relativeNameTv = relativeNameTv;
        this.relativeSurnameET = relativeSurnameET;
        this.relativeSurnameTv = relativeSurnameTv;
        this.serialNo = serialNo;
        this.serialNoEt = serialNoEt;
        this.stateET = stateET;
        this.stateTv = stateTv;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloSelectApplicantLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloSelectApplicantLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_select_applicant_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloSelectApplicantLayoutBinding bind(View rootView) {
        int i = R.id.Ac_et;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.Ac_et);
        if (textView != null) {
            i = R.id.Ac_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Ac_tv);
            if (textView2 != null) {
                i = R.id.Applicant_name_Et;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Applicant_name_Et);
                if (textView3 != null) {
                    i = R.id.Applicant_name_tv;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Applicant_name_tv);
                    if (textView4 != null) {
                        i = R.id.Applicant_surname_et;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Applicant_surname_et);
                        if (textView5 != null) {
                            i = R.id.Applicant_surname_tv;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Applicant_surname_tv);
                            if (textView6 != null) {
                                i = 2131364291;
                                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, 2131364291);
                                if (constraintLayoutFindChildViewById != null) {
                                    i = R.id.partNumber_ET;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partNumber_ET);
                                    if (textView7 != null) {
                                        i = R.id.partNumber_tv;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partNumber_tv);
                                        if (textView8 != null) {
                                            i = R.id.radioButton;
                                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.radioButton);
                                            if (radioButton != null) {
                                                i = R.id.relative_name_ET;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_name_ET);
                                                if (textView9 != null) {
                                                    i = R.id.relative_name_tv;
                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_name_tv);
                                                    if (textView10 != null) {
                                                        i = R.id.relative_surname_ET;
                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_surname_ET);
                                                        if (textView11 != null) {
                                                            i = R.id.relative_surname_Tv;
                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_surname_Tv);
                                                            if (textView12 != null) {
                                                                i = R.id.serial_no;
                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serial_no);
                                                                if (textView13 != null) {
                                                                    i = R.id.serial_no_et;
                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serial_no_et);
                                                                    if (textView14 != null) {
                                                                        i = R.id.state_ET;
                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_ET);
                                                                        if (textView15 != null) {
                                                                            i = R.id.state_tv;
                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv);
                                                                            if (textView16 != null) {
                                                                                i = R.id.view2;
                                                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                                                if (viewFindChildViewById != null) {
                                                                                    return new BloSelectApplicantLayoutBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6, constraintLayoutFindChildViewById, textView7, textView8, radioButton, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, viewFindChildViewById);
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
