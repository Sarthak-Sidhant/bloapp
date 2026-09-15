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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class UploadDocExtensionBinding implements ViewBinding {
    public final TextView addDoc1Filename;
    public final ImageView addDoc1Img;
    public final TextView addDoc2Filename;
    public final ImageView addDoc2Img;
    public final LinearLayout annexureD;
    private final ConstraintLayout rootView;

    private UploadDocExtensionBinding(ConstraintLayout rootView, TextView addDoc1Filename, ImageView addDoc1Img, TextView addDoc2Filename, ImageView addDoc2Img, LinearLayout annexureD) {
        this.rootView = rootView;
        this.addDoc1Filename = addDoc1Filename;
        this.addDoc1Img = addDoc1Img;
        this.addDoc2Filename = addDoc2Filename;
        this.addDoc2Img = addDoc2Img;
        this.annexureD = annexureD;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static UploadDocExtensionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static UploadDocExtensionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.upload_doc_extension, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static UploadDocExtensionBinding bind(View rootView) {
        int i = R.id.add_doc1_filename;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_doc1_filename);
        if (textView != null) {
            i = R.id.add_doc1_img;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.add_doc1_img);
            if (imageView != null) {
                i = R.id.add_doc2_filename;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_doc2_filename);
                if (textView2 != null) {
                    i = R.id.add_doc2_img;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.add_doc2_img);
                    if (imageView2 != null) {
                        i = R.id.annexureD;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.annexureD);
                        if (linearLayout != null) {
                            return new UploadDocExtensionBinding((ConstraintLayout) rootView, textView, imageView, textView2, imageView2, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
