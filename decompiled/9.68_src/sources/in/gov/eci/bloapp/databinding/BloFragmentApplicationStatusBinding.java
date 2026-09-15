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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentApplicationStatusBinding implements ViewBinding {
    public final RecyclerView applicationStatusRv;
    public final TextView areaTv;
    public final ImageView backBtnIv;
    public final ConstraintLayout constraintLayout2;
    public final TextView firstNameTv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final TextView lastNameTv;
    public final LinearLayout linearLayout2;
    public final LinearLayout linearLayout3;
    public final LinearLayout linearLayout4;
    public final TextView refNoTv;
    private final ConstraintLayout rootView;
    public final TextView stateTv;
    public final TextView statusTv;
    public final TextView textView3;

    private BloFragmentApplicationStatusBinding(ConstraintLayout rootView, RecyclerView applicationStatusRv, TextView areaTv, ImageView backBtnIv, ConstraintLayout constraintLayout2, TextView firstNameTv, ConstraintLayout homeFragmentTopConstraintLayout, TextView lastNameTv, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView refNoTv, TextView stateTv, TextView statusTv, TextView textView3) {
        this.rootView = rootView;
        this.applicationStatusRv = applicationStatusRv;
        this.areaTv = areaTv;
        this.backBtnIv = backBtnIv;
        this.constraintLayout2 = constraintLayout2;
        this.firstNameTv = firstNameTv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.lastNameTv = lastNameTv;
        this.linearLayout2 = linearLayout2;
        this.linearLayout3 = linearLayout3;
        this.linearLayout4 = linearLayout4;
        this.refNoTv = refNoTv;
        this.stateTv = stateTv;
        this.statusTv = statusTv;
        this.textView3 = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentApplicationStatusBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentApplicationStatusBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_application_status, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentApplicationStatusBinding bind(View rootView) {
        int i = R.id.application_status_rv;
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.application_status_rv);
        if (recyclerViewFindChildViewById != null) {
            i = R.id.area_tv;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.area_tv);
            if (textView != null) {
                i = R.id.back_btn_iv;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                if (imageView != null) {
                    i = R.id.constraintLayout2;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.constraintLayout2);
                    if (constraintLayoutFindChildViewById != null) {
                        i = R.id.first_name_tv;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_tv);
                        if (textView2 != null) {
                            i = R.id.home_fragment_top_constraint_layout;
                            ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                            if (constraintLayoutFindChildViewById2 != null) {
                                i = R.id.last_name_tv;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.last_name_tv);
                                if (textView3 != null) {
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
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv);
                                                if (textView4 != null) {
                                                    i = R.id.state_tv;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv);
                                                    if (textView5 != null) {
                                                        i = R.id.status_tv;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.status_tv);
                                                        if (textView6 != null) {
                                                            i = R.id.textView3;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                            if (textView7 != null) {
                                                                return new BloFragmentApplicationStatusBinding((ConstraintLayout) rootView, recyclerViewFindChildViewById, textView, imageView, constraintLayoutFindChildViewById, textView2, constraintLayoutFindChildViewById2, textView3, linearLayout, linearLayout2, linearLayout3, textView4, textView5, textView6, textView7);
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
