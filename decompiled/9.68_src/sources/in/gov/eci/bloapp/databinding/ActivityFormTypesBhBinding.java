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
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivityFormTypesBhBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final TextView enumerationForm;
    public final LinearLayout filledBLO;
    public final TextView filledBLOTv;
    public final TextView filledForm;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final LinearLayout main;
    public final TextView noteOpen;
    public final LinearLayout pendingElector;
    public final TextView pendingElectorTv;
    public final LinearLayout rollBack;
    public final TextView rollBackTv;
    private final LinearLayout rootView;
    public final LinearLayout statement1;
    public final LinearLayout statement5;
    public final TextView textView3;
    public final LinearLayout uncollectableEFLL;
    public final TextView uploadUncollectableEfTv;
    public final TextView viewFormByAero;
    public final LinearLayout viewFormByAeroLL;

    private ActivityFormTypesBhBinding(LinearLayout rootView, ImageView backBtnIv, TextView enumerationForm, LinearLayout filledBLO, TextView filledBLOTv, TextView filledForm, ConstraintLayout homeFragmentTopConstraintLayout, LinearLayout main, TextView noteOpen, LinearLayout pendingElector, TextView pendingElectorTv, LinearLayout rollBack, TextView rollBackTv, LinearLayout statement1, LinearLayout statement5, TextView textView3, LinearLayout uncollectableEFLL, TextView uploadUncollectableEfTv, TextView viewFormByAero, LinearLayout viewFormByAeroLL) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.enumerationForm = enumerationForm;
        this.filledBLO = filledBLO;
        this.filledBLOTv = filledBLOTv;
        this.filledForm = filledForm;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.main = main;
        this.noteOpen = noteOpen;
        this.pendingElector = pendingElector;
        this.pendingElectorTv = pendingElectorTv;
        this.rollBack = rollBack;
        this.rollBackTv = rollBackTv;
        this.statement1 = statement1;
        this.statement5 = statement5;
        this.textView3 = textView3;
        this.uncollectableEFLL = uncollectableEFLL;
        this.uploadUncollectableEfTv = uploadUncollectableEfTv;
        this.viewFormByAero = viewFormByAero;
        this.viewFormByAeroLL = viewFormByAeroLL;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFormTypesBhBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityFormTypesBhBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_form_types_bh, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFormTypesBhBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.enumerationForm;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationForm);
            if (textView != null) {
                i = R.id.filledBLO;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.filledBLO);
                if (linearLayout != null) {
                    i = R.id.filledBLO_tv;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filledBLO_tv);
                    if (textView2 != null) {
                        i = R.id.filledForm;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filledForm);
                        if (textView3 != null) {
                            i = R.id.home_fragment_top_constraint_layout;
                            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                            if (constraintLayoutFindChildViewById != null) {
                                LinearLayout linearLayout2 = (LinearLayout) rootView;
                                i = R.id.noteOpen;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.noteOpen);
                                if (textView4 != null) {
                                    i = R.id.pendingElector;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pendingElector);
                                    if (linearLayout3 != null) {
                                        i = R.id.pendingElector_tv;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pendingElector_tv);
                                        if (textView5 != null) {
                                            i = R.id.rollBack;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rollBack);
                                            if (linearLayout4 != null) {
                                                i = R.id.rollBack_tv;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rollBack_tv);
                                                if (textView6 != null) {
                                                    i = R.id.statement1;
                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.statement1);
                                                    if (linearLayout5 != null) {
                                                        i = R.id.statement5;
                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.statement5);
                                                        if (linearLayout6 != null) {
                                                            i = R.id.textView3;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                            if (textView7 != null) {
                                                                i = R.id.uncollectableEF_LL;
                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.uncollectableEF_LL);
                                                                if (linearLayout7 != null) {
                                                                    i = R.id.uploadUncollectableEf_tv;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadUncollectableEf_tv);
                                                                    if (textView8 != null) {
                                                                        i = R.id.viewFormByAero;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.viewFormByAero);
                                                                        if (textView9 != null) {
                                                                            i = R.id.viewFormByAeroLL;
                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.viewFormByAeroLL);
                                                                            if (linearLayout8 != null) {
                                                                                return new ActivityFormTypesBhBinding(linearLayout2, imageView, textView, linearLayout, textView2, textView3, constraintLayoutFindChildViewById, linearLayout2, textView4, linearLayout3, textView5, linearLayout4, textView6, linearLayout5, linearLayout6, textView7, linearLayout7, textView8, textView9, linearLayout8);
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
