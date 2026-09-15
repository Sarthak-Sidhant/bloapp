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
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentH2HDashboardBinding implements ViewBinding {
    public final TextView H2HSurveyStatus;
    public final LinearLayout H2HSurveyStatusLayout;
    public final ImageView backBtnIv;
    public final LinearLayout draftH2H;
    public final TextView draftH2HHeading;
    public final TextView formsDraft;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final NestedScrollView nested;
    public final TextView newVoterTv;
    public final TextView newVoterTv1;
    private final ConstraintLayout rootView;
    public final LinearLayout statement1;
    public final LinearLayout statement5;
    public final LinearLayout statement6;
    public final TextView textView3;

    private BloFragmentH2HDashboardBinding(ConstraintLayout rootView, TextView H2HSurveyStatus, LinearLayout H2HSurveyStatusLayout, ImageView backBtnIv, LinearLayout draftH2H, TextView draftH2HHeading, TextView formsDraft, ConstraintLayout homeFragmentTopConstraintLayout, NestedScrollView nested, TextView newVoterTv, TextView newVoterTv1, LinearLayout statement1, LinearLayout statement5, LinearLayout statement6, TextView textView3) {
        this.rootView = rootView;
        this.H2HSurveyStatus = H2HSurveyStatus;
        this.H2HSurveyStatusLayout = H2HSurveyStatusLayout;
        this.backBtnIv = backBtnIv;
        this.draftH2H = draftH2H;
        this.draftH2HHeading = draftH2HHeading;
        this.formsDraft = formsDraft;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.nested = nested;
        this.newVoterTv = newVoterTv;
        this.newVoterTv1 = newVoterTv1;
        this.statement1 = statement1;
        this.statement5 = statement5;
        this.statement6 = statement6;
        this.textView3 = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentH2HDashboardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentH2HDashboardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_h2_h_dashboard, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentH2HDashboardBinding bind(View rootView) {
        int i = R.id.H2H_Survey_Status;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.H2H_Survey_Status);
        if (textView != null) {
            i = R.id.H2H_Survey_Status_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.H2H_Survey_Status_layout);
            if (linearLayout != null) {
                i = R.id.back_btn_iv;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                if (imageView != null) {
                    i = R.id.draftH2H;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.draftH2H);
                    if (linearLayout2 != null) {
                        i = R.id.draftH2HHeading;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.draftH2HHeading);
                        if (textView2 != null) {
                            i = R.id.forms_draft;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.forms_draft);
                            if (textView3 != null) {
                                i = R.id.home_fragment_top_constraint_layout;
                                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                                if (constraintLayoutFindChildViewById != null) {
                                    i = R.id.nested;
                                    NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.nested);
                                    if (nestedScrollViewFindChildViewById != null) {
                                        i = R.id.new_voter_tv;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.new_voter_tv);
                                        if (textView4 != null) {
                                            i = R.id.new_voter_tv1;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.new_voter_tv1);
                                            if (textView5 != null) {
                                                i = R.id.statement1;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.statement1);
                                                if (linearLayout3 != null) {
                                                    i = R.id.statement5;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.statement5);
                                                    if (linearLayout4 != null) {
                                                        i = R.id.statement6;
                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.statement6);
                                                        if (linearLayout5 != null) {
                                                            i = R.id.textView3;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                            if (textView6 != null) {
                                                                return new BloFragmentH2HDashboardBinding((ConstraintLayout) rootView, textView, linearLayout, imageView, linearLayout2, textView2, textView3, constraintLayoutFindChildViewById, nestedScrollViewFindChildViewById, textView4, textView5, linearLayout3, linearLayout4, linearLayout5, textView6);
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
