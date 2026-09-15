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
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloH2hFilterBinding implements ViewBinding {
    public final LinearLayout familyspinner;
    public final TextView filterButton;
    public final TextView formNameTv;
    public final TextView formNameTv1;
    public final ImageView imageView;
    public final TextView requiredDccTv;
    private final ConstraintLayout rootView;
    public final NoDefaultSpinner sectionNo;
    public final View viewStateOutsideSpinner1;

    private BloH2hFilterBinding(ConstraintLayout rootView, LinearLayout familyspinner, TextView filterButton, TextView formNameTv, TextView formNameTv1, ImageView imageView, TextView requiredDccTv, NoDefaultSpinner sectionNo, View viewStateOutsideSpinner1) {
        this.rootView = rootView;
        this.familyspinner = familyspinner;
        this.filterButton = filterButton;
        this.formNameTv = formNameTv;
        this.formNameTv1 = formNameTv1;
        this.imageView = imageView;
        this.requiredDccTv = requiredDccTv;
        this.sectionNo = sectionNo;
        this.viewStateOutsideSpinner1 = viewStateOutsideSpinner1;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloH2hFilterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloH2hFilterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_h2h_filter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloH2hFilterBinding bind(View rootView) {
        int i = R.id.familyspinner;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.familyspinner);
        if (linearLayout != null) {
            i = R.id.filterButton;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.filterButton);
            if (textView != null) {
                i = R.id.form_name_tv;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_name_tv);
                if (textView2 != null) {
                    i = R.id.form_name_tv1;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_name_tv1);
                    if (textView3 != null) {
                        i = R.id.imageView;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
                        if (imageView != null) {
                            i = R.id.required_dcc_tv;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.required_dcc_tv);
                            if (textView4 != null) {
                                i = R.id.sectionNo;
                                NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.sectionNo);
                                if (noDefaultSpinner != null) {
                                    i = R.id.view_state_outside_spinner1;
                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_state_outside_spinner1);
                                    if (viewFindChildViewById != null) {
                                        return new BloH2hFilterBinding((ConstraintLayout) rootView, linearLayout, textView, textView2, textView3, imageView, textView4, noDefaultSpinner, viewFindChildViewById);
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
