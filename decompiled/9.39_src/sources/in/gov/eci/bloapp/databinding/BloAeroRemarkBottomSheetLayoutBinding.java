package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloAeroRemarkBottomSheetLayoutBinding implements ViewBinding {
    public final LinearLayout aeroRemarksLayout;
    public final Button btnProceed;
    public final TextView eroRemarkText;
    public final LinearLayout eroRemarksLayout;
    public final ImageView imageView;
    public final LinearLayout linearLayout11;
    public final TextView referenceNumberText;
    public final TextView remarkText;
    private final ConstraintLayout rootView;

    private BloAeroRemarkBottomSheetLayoutBinding(ConstraintLayout rootView, LinearLayout aeroRemarksLayout, Button btnProceed, TextView eroRemarkText, LinearLayout eroRemarksLayout, ImageView imageView, LinearLayout linearLayout11, TextView referenceNumberText, TextView remarkText) {
        this.rootView = rootView;
        this.aeroRemarksLayout = aeroRemarksLayout;
        this.btnProceed = btnProceed;
        this.eroRemarkText = eroRemarkText;
        this.eroRemarksLayout = eroRemarksLayout;
        this.imageView = imageView;
        this.linearLayout11 = linearLayout11;
        this.referenceNumberText = referenceNumberText;
        this.remarkText = remarkText;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloAeroRemarkBottomSheetLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloAeroRemarkBottomSheetLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_aero_remark_bottom_sheet_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloAeroRemarkBottomSheetLayoutBinding bind(View rootView) {
        int i = R.id.aeroRemarksLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.aeroRemarksLayout);
        if (linearLayout != null) {
            i = R.id.btn_Proceed;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_Proceed);
            if (button != null) {
                i = R.id.ero_remarkText;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.ero_remarkText);
                if (textView != null) {
                    i = R.id.eroRemarksLayout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.eroRemarksLayout);
                    if (linearLayout2 != null) {
                        i = R.id.imageView;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
                        if (imageView != null) {
                            i = R.id.linearLayout11;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout11);
                            if (linearLayout3 != null) {
                                i = R.id.referenceNumberText;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.referenceNumberText);
                                if (textView2 != null) {
                                    i = R.id.remarkText;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remarkText);
                                    if (textView3 != null) {
                                        return new BloAeroRemarkBottomSheetLayoutBinding((ConstraintLayout) rootView, linearLayout, button, textView, linearLayout2, imageView, linearLayout3, textView2, textView3);
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
