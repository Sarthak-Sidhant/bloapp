package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class CustomSirFormTypePageCountBinding implements ViewBinding {
    public final ImageView crossButton;
    public final TextView note1;
    public final TextView note2;
    private final LinearLayout rootView;
    public final TextView txtDocumentUploadCount;
    public final TextView txtFullDocumentCount;
    public final TextView txtNoDocumentCount;
    public final TextView txtPartialDocumentCount;
    public final TextView txtTotalElectarCount;

    private CustomSirFormTypePageCountBinding(LinearLayout rootView, ImageView crossButton, TextView note1, TextView note2, TextView txtDocumentUploadCount, TextView txtFullDocumentCount, TextView txtNoDocumentCount, TextView txtPartialDocumentCount, TextView txtTotalElectarCount) {
        this.rootView = rootView;
        this.crossButton = crossButton;
        this.note1 = note1;
        this.note2 = note2;
        this.txtDocumentUploadCount = txtDocumentUploadCount;
        this.txtFullDocumentCount = txtFullDocumentCount;
        this.txtNoDocumentCount = txtNoDocumentCount;
        this.txtPartialDocumentCount = txtPartialDocumentCount;
        this.txtTotalElectarCount = txtTotalElectarCount;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CustomSirFormTypePageCountBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomSirFormTypePageCountBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_sir_form_type_page_count, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomSirFormTypePageCountBinding bind(View rootView) {
        int i = R.id.cross_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cross_button);
        if (imageView != null) {
            i = R.id.note1;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.note1);
            if (textView != null) {
                i = R.id.note2;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.note2);
                if (textView2 != null) {
                    i = R.id.txtDocumentUploadCount;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDocumentUploadCount);
                    if (textView3 != null) {
                        i = R.id.txtFullDocumentCount;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtFullDocumentCount);
                        if (textView4 != null) {
                            i = R.id.txtNoDocumentCount;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtNoDocumentCount);
                            if (textView5 != null) {
                                i = R.id.txtPartialDocumentCount;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtPartialDocumentCount);
                                if (textView6 != null) {
                                    i = R.id.txtTotalElectarCount;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtTotalElectarCount);
                                    if (textView7 != null) {
                                        return new CustomSirFormTypePageCountBinding((LinearLayout) rootView, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
