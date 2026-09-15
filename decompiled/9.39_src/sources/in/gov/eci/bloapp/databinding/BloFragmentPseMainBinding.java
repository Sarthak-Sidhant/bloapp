package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentPseMainBinding implements ViewBinding {
    public final CardView ChecklistSubmission;
    public final CardView GenerateForm8;
    public final ImageView backBtnIv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final CardView pseIdentified;
    private final LinearLayout rootView;
    public final TextView textView3;

    private BloFragmentPseMainBinding(LinearLayout rootView, CardView ChecklistSubmission, CardView GenerateForm8, ImageView backBtnIv, ConstraintLayout homeFragmentTopConstraintLayout, CardView pseIdentified, TextView textView3) {
        this.rootView = rootView;
        this.ChecklistSubmission = ChecklistSubmission;
        this.GenerateForm8 = GenerateForm8;
        this.backBtnIv = backBtnIv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.pseIdentified = pseIdentified;
        this.textView3 = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentPseMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentPseMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_pse_main, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentPseMainBinding bind(View rootView) {
        int i = R.id.ChecklistSubmission;
        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.ChecklistSubmission);
        if (cardViewFindChildViewById != null) {
            i = R.id.GenerateForm8;
            CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.GenerateForm8);
            if (cardViewFindChildViewById2 != null) {
                i = R.id.back_btn_iv;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                if (imageView != null) {
                    i = R.id.home_fragment_top_constraint_layout;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                    if (constraintLayoutFindChildViewById != null) {
                        i = R.id.pseIdentified;
                        CardView cardViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.pseIdentified);
                        if (cardViewFindChildViewById3 != null) {
                            i = R.id.textView3;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                            if (textView != null) {
                                return new BloFragmentPseMainBinding((LinearLayout) rootView, cardViewFindChildViewById, cardViewFindChildViewById2, imageView, constraintLayoutFindChildViewById, cardViewFindChildViewById3, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
