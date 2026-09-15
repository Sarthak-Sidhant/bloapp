package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloOverseasBottomSheetLayoutBinding implements ViewBinding {
    public final TextView btnProceed;
    public final TextView doc1Tv;
    public final TextView doc2Tv;
    public final TextView formNameTv;
    public final ImageView imageView;
    public final TextView requiredDccTv;
    private final ConstraintLayout rootView;

    private BloOverseasBottomSheetLayoutBinding(ConstraintLayout rootView, TextView btnProceed, TextView doc1Tv, TextView doc2Tv, TextView formNameTv, ImageView imageView, TextView requiredDccTv) {
        this.rootView = rootView;
        this.btnProceed = btnProceed;
        this.doc1Tv = doc1Tv;
        this.doc2Tv = doc2Tv;
        this.formNameTv = formNameTv;
        this.imageView = imageView;
        this.requiredDccTv = requiredDccTv;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloOverseasBottomSheetLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloOverseasBottomSheetLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_overseas_bottom_sheet_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloOverseasBottomSheetLayoutBinding bind(View rootView) {
        int i = R.id.btn_Proceed;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.btn_Proceed);
        if (textView != null) {
            i = R.id.doc1_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc1_tv);
            if (textView2 != null) {
                i = R.id.doc2_tv;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc2_tv);
                if (textView3 != null) {
                    i = R.id.form_name_tv;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_name_tv);
                    if (textView4 != null) {
                        i = R.id.imageView;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
                        if (imageView != null) {
                            i = R.id.required_dcc_tv;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.required_dcc_tv);
                            if (textView5 != null) {
                                return new BloOverseasBottomSheetLayoutBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, imageView, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
