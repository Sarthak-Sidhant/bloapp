package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloSurveylistRvBinding implements ViewBinding {
    public final TextView NTv;
    public final TextView NoOfPeopleTv;
    public final TextView SerialNoTv;
    public final TextView VerifiedTickTv;
    public final TextView VerifiedTv;
    public final TextView ageTv;
    public final TextView applicantTv;
    public final TextView apptv;
    public final TextView housetv;
    public final LinearLayout layout;
    public final TextView namTv;
    public final TextView nationalTv;
    private final ConstraintLayout rootView;
    public final TextView secn;
    public final View view2;

    private BloSurveylistRvBinding(ConstraintLayout rootView, TextView NTv, TextView NoOfPeopleTv, TextView SerialNoTv, TextView VerifiedTickTv, TextView VerifiedTv, TextView ageTv, TextView applicantTv, TextView apptv, TextView housetv, LinearLayout layout, TextView namTv, TextView nationalTv, TextView secn, View view2) {
        this.rootView = rootView;
        this.NTv = NTv;
        this.NoOfPeopleTv = NoOfPeopleTv;
        this.SerialNoTv = SerialNoTv;
        this.VerifiedTickTv = VerifiedTickTv;
        this.VerifiedTv = VerifiedTv;
        this.ageTv = ageTv;
        this.applicantTv = applicantTv;
        this.apptv = apptv;
        this.housetv = housetv;
        this.layout = layout;
        this.namTv = namTv;
        this.nationalTv = nationalTv;
        this.secn = secn;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloSurveylistRvBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloSurveylistRvBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_surveylist_rv, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloSurveylistRvBinding bind(View rootView) {
        int i = R.id.N_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.N_tv);
        if (textView != null) {
            i = R.id.No_of_people_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.No_of_people_tv);
            if (textView2 != null) {
                i = R.id.Serial_No_tv;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Serial_No_tv);
                if (textView3 != null) {
                    i = R.id.Verified_tick_tv;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Verified_tick_tv);
                    if (textView4 != null) {
                        i = R.id.Verified_tv;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Verified_tv);
                        if (textView5 != null) {
                            i = R.id.age_tv;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.age_tv);
                            if (textView6 != null) {
                                i = R.id.applicant_tv;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_tv);
                                if (textView7 != null) {
                                    i = R.id.apptv;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.apptv);
                                    if (textView8 != null) {
                                        i = R.id.housetv;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.housetv);
                                        if (textView9 != null) {
                                            i = 2131364291;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, 2131364291);
                                            if (linearLayout != null) {
                                                i = R.id.nam_tv;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nam_tv);
                                                if (textView10 != null) {
                                                    i = R.id.national_tv;
                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.national_tv);
                                                    if (textView11 != null) {
                                                        i = R.id.secn;
                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.secn);
                                                        if (textView12 != null) {
                                                            i = R.id.view2;
                                                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                            if (viewFindChildViewById != null) {
                                                                return new BloSurveylistRvBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, linearLayout, textView10, textView11, textView12, viewFindChildViewById);
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
