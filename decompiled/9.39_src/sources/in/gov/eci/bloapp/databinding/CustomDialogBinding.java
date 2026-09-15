package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class CustomDialogBinding implements ViewBinding {
    public final TextView cancel;
    public final TextView gallery;
    public final LinearLayout layoutCapturePhoto;
    public final LinearLayout layoutGallery;
    public final LinearLayout layoutPdf;
    public final TextView pdf;
    private final CardView rootView;
    public final TextView txtIconName;

    private CustomDialogBinding(CardView rootView, TextView cancel, TextView gallery, LinearLayout layoutCapturePhoto, LinearLayout layoutGallery, LinearLayout layoutPdf, TextView pdf, TextView txtIconName) {
        this.rootView = rootView;
        this.cancel = cancel;
        this.gallery = gallery;
        this.layoutCapturePhoto = layoutCapturePhoto;
        this.layoutGallery = layoutGallery;
        this.layoutPdf = layoutPdf;
        this.pdf = pdf;
        this.txtIconName = txtIconName;
    }

    public CardView getRoot() {
        return this.rootView;
    }

    public static CustomDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(2131558787, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomDialogBinding bind(View rootView) {
        int i = R.id.cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cancel);
        if (textView != null) {
            i = R.id.gallery;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gallery);
            if (textView2 != null) {
                i = R.id.layoutCapturePhoto;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layoutCapturePhoto);
                if (linearLayout != null) {
                    i = R.id.layoutGallery;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layoutGallery);
                    if (linearLayout2 != null) {
                        i = R.id.layoutPdf;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layoutPdf);
                        if (linearLayout3 != null) {
                            i = R.id.pdf;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdf);
                            if (textView3 != null) {
                                i = R.id.txtIconName;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtIconName);
                                if (textView4 != null) {
                                    return new CustomDialogBinding((CardView) rootView, textView, textView2, linearLayout, linearLayout2, linearLayout3, textView3, textView4);
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
