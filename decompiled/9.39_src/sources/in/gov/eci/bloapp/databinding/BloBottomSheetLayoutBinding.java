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

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloBottomSheetLayoutBinding implements ViewBinding {
    public final TextView btnProceed;
    public final View divider1;
    public final TextView doc1Tv;
    public final TextView doc2Tv;
    public final TextView doc3Tv;
    public final LinearLayout familyspinner;
    public final TextView formNameTv;
    public final ImageView imageView;
    public final TextView requiredDccTv;
    private final ConstraintLayout rootView;
    public final NoDefaultSpinner sectionNo;
    public final View viewStateOutsideSpinner1;

    private BloBottomSheetLayoutBinding(ConstraintLayout rootView, TextView btnProceed, View divider1, TextView doc1Tv, TextView doc2Tv, TextView doc3Tv, LinearLayout familyspinner, TextView formNameTv, ImageView imageView, TextView requiredDccTv, NoDefaultSpinner sectionNo, View viewStateOutsideSpinner1) {
        this.rootView = rootView;
        this.btnProceed = btnProceed;
        this.divider1 = divider1;
        this.doc1Tv = doc1Tv;
        this.doc2Tv = doc2Tv;
        this.doc3Tv = doc3Tv;
        this.familyspinner = familyspinner;
        this.formNameTv = formNameTv;
        this.imageView = imageView;
        this.requiredDccTv = requiredDccTv;
        this.sectionNo = sectionNo;
        this.viewStateOutsideSpinner1 = viewStateOutsideSpinner1;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloBottomSheetLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloBottomSheetLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_bottom_sheet_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloBottomSheetLayoutBinding bind(View rootView) {
        int i = R.id.btn_Proceed;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.btn_Proceed);
        if (textView != null) {
            i = R.id.divider1;
            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.divider1);
            if (viewFindChildViewById != null) {
                i = R.id.doc1_tv;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc1_tv);
                if (textView2 != null) {
                    i = R.id.doc2_tv;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc2_tv);
                    if (textView3 != null) {
                        i = R.id.doc3_tv;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3_tv);
                        if (textView4 != null) {
                            i = R.id.familyspinner;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.familyspinner);
                            if (linearLayout != null) {
                                i = R.id.form_name_tv;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_name_tv);
                                if (textView5 != null) {
                                    i = R.id.imageView;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
                                    if (imageView != null) {
                                        i = R.id.required_dcc_tv;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.required_dcc_tv);
                                        if (textView6 != null) {
                                            i = R.id.sectionNo;
                                            NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.sectionNo);
                                            if (noDefaultSpinner != null) {
                                                i = R.id.view_state_outside_spinner1;
                                                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view_state_outside_spinner1);
                                                if (viewFindChildViewById2 != null) {
                                                    return new BloBottomSheetLayoutBinding((ConstraintLayout) rootView, textView, viewFindChildViewById, textView2, textView3, textView4, linearLayout, textView5, imageView, textView6, noDefaultSpinner, viewFindChildViewById2);
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
