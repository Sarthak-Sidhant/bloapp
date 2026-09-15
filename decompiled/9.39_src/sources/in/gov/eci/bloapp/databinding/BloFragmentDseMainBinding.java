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
public final class BloFragmentDseMainBinding implements ViewBinding {
    public final CardView ChecklistSubmission;
    public final CardView DseIdentified;
    public final CardView RequestFormat;
    public final ImageView backBtnIv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    private final LinearLayout rootView;
    public final TextView textView3;

    private BloFragmentDseMainBinding(LinearLayout rootView, CardView ChecklistSubmission, CardView DseIdentified, CardView RequestFormat, ImageView backBtnIv, ConstraintLayout homeFragmentTopConstraintLayout, TextView textView3) {
        this.rootView = rootView;
        this.ChecklistSubmission = ChecklistSubmission;
        this.DseIdentified = DseIdentified;
        this.RequestFormat = RequestFormat;
        this.backBtnIv = backBtnIv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.textView3 = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentDseMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentDseMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_dse_main, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentDseMainBinding bind(View rootView) {
        int i = R.id.ChecklistSubmission;
        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.ChecklistSubmission);
        if (cardViewFindChildViewById != null) {
            i = R.id.DseIdentified;
            CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.DseIdentified);
            if (cardViewFindChildViewById2 != null) {
                i = R.id.RequestFormat;
                CardView cardViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.RequestFormat);
                if (cardViewFindChildViewById3 != null) {
                    i = R.id.back_btn_iv;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                    if (imageView != null) {
                        i = R.id.home_fragment_top_constraint_layout;
                        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                        if (constraintLayoutFindChildViewById != null) {
                            i = R.id.textView3;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                            if (textView != null) {
                                return new BloFragmentDseMainBinding((LinearLayout) rootView, cardViewFindChildViewById, cardViewFindChildViewById2, cardViewFindChildViewById3, imageView, constraintLayoutFindChildViewById, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
