package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentSubmittedApplicationStatusBinding implements ViewBinding {
    public final TextView areaTv;
    public final ImageView backBtnIv;
    public final ConstraintLayout constraintLayout2;
    public final TextView dateTv;
    public final TextView firstNameTv;
    public final TextView formType;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final TextView lastNameTv;
    public final LinearLayout linearLayout2;
    public final LinearLayout linearLayout3;
    public final LinearLayout linearLayout4;
    public final TextView refNoTv;
    private final ConstraintLayout rootView;
    public final TextView stateTv;
    public final TextView statusTv;
    public final TextView submissiondateTv;
    public final TextView textView3;
    public final RecyclerView trackStatusBtnRv;

    private BloFragmentSubmittedApplicationStatusBinding(ConstraintLayout rootView, TextView areaTv, ImageView backBtnIv, ConstraintLayout constraintLayout2, TextView dateTv, TextView firstNameTv, TextView formType, ConstraintLayout homeFragmentTopConstraintLayout, TextView lastNameTv, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView refNoTv, TextView stateTv, TextView statusTv, TextView submissiondateTv, TextView textView3, RecyclerView trackStatusBtnRv) {
        this.rootView = rootView;
        this.areaTv = areaTv;
        this.backBtnIv = backBtnIv;
        this.constraintLayout2 = constraintLayout2;
        this.dateTv = dateTv;
        this.firstNameTv = firstNameTv;
        this.formType = formType;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.lastNameTv = lastNameTv;
        this.linearLayout2 = linearLayout2;
        this.linearLayout3 = linearLayout3;
        this.linearLayout4 = linearLayout4;
        this.refNoTv = refNoTv;
        this.stateTv = stateTv;
        this.statusTv = statusTv;
        this.submissiondateTv = submissiondateTv;
        this.textView3 = textView3;
        this.trackStatusBtnRv = trackStatusBtnRv;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentSubmittedApplicationStatusBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentSubmittedApplicationStatusBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_submitted_application_status, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentSubmittedApplicationStatusBinding bind(View rootView) {
        int i = R.id.area_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.area_tv);
        if (textView != null) {
            i = R.id.back_btn_iv;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
            if (imageView != null) {
                i = R.id.constraintLayout2;
                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.constraintLayout2);
                if (constraintLayoutFindChildViewById != null) {
                    i = R.id.date_tv;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_tv);
                    if (textView2 != null) {
                        i = R.id.first_name_tv;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_tv);
                        if (textView3 != null) {
                            i = R.id.form_type;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_type);
                            if (textView4 != null) {
                                i = R.id.home_fragment_top_constraint_layout;
                                ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                                if (constraintLayoutFindChildViewById2 != null) {
                                    i = R.id.last_name_tv;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.last_name_tv);
                                    if (textView5 != null) {
                                        i = R.id.linearLayout2;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout2);
                                        if (linearLayout != null) {
                                            i = R.id.linear_layout3;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_layout3);
                                            if (linearLayout2 != null) {
                                                i = R.id.linearLayout4;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout4);
                                                if (linearLayout3 != null) {
                                                    i = R.id.ref_no_tv;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv);
                                                    if (textView6 != null) {
                                                        i = R.id.state_tv;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv);
                                                        if (textView7 != null) {
                                                            i = R.id.status_tv;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.status_tv);
                                                            if (textView8 != null) {
                                                                i = R.id.submissiondate_tv;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submissiondate_tv);
                                                                if (textView9 != null) {
                                                                    i = R.id.textView3;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                    if (textView10 != null) {
                                                                        i = R.id.track_status_btn_rv;
                                                                        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.track_status_btn_rv);
                                                                        if (recyclerViewFindChildViewById != null) {
                                                                            return new BloFragmentSubmittedApplicationStatusBinding((ConstraintLayout) rootView, textView, imageView, constraintLayoutFindChildViewById, textView2, textView3, textView4, constraintLayoutFindChildViewById2, textView5, linearLayout, linearLayout2, linearLayout3, textView6, textView7, textView8, textView9, textView10, recyclerViewFindChildViewById);
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
