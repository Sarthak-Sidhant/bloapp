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

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityRollBackFromAeroBhBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final LinearLayout main;
    public final LinearLayout rollbackEditLayout;
    public final TextView rollbackEditTv;
    public final LinearLayout rollbackNewLayout;
    public final TextView rollbackNewTv;
    private final LinearLayout rootView;
    public final TextView textView3;

    private ActivityRollBackFromAeroBhBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout homeFragmentTopConstraintLayout, LinearLayout main, LinearLayout rollbackEditLayout, TextView rollbackEditTv, LinearLayout rollbackNewLayout, TextView rollbackNewTv, TextView textView3) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.main = main;
        this.rollbackEditLayout = rollbackEditLayout;
        this.rollbackEditTv = rollbackEditTv;
        this.rollbackNewLayout = rollbackNewLayout;
        this.rollbackNewTv = rollbackNewTv;
        this.textView3 = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityRollBackFromAeroBhBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityRollBackFromAeroBhBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_roll_back_from_aero_bh, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRollBackFromAeroBhBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.home_fragment_top_constraint_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
            if (constraintLayoutFindChildViewById != null) {
                LinearLayout linearLayout = (LinearLayout) rootView;
                i = R.id.rollback_edit_layout;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rollback_edit_layout);
                if (linearLayout2 != null) {
                    i = R.id.rollback_edit_tv;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.rollback_edit_tv);
                    if (textView != null) {
                        i = R.id.rollback_new_layout;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rollback_new_layout);
                        if (linearLayout3 != null) {
                            i = R.id.rollback_new_tv;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rollback_new_tv);
                            if (textView2 != null) {
                                i = R.id.textView3;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                if (textView3 != null) {
                                    return new ActivityRollBackFromAeroBhBinding(linearLayout, imageView, constraintLayoutFindChildViewById, linearLayout, linearLayout2, textView, linearLayout3, textView2, textView3);
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
