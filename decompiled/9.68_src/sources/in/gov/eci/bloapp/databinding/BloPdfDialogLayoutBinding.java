package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.github.barteksc.pdfviewer.PDFView;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloPdfDialogLayoutBinding implements ViewBinding {
    public final ImageView dialogCancelButton;
    public final TextView dialogPdfName;
    public final CardView pdfCard;
    public final FrameLayout pdfDialogRoot;
    public final PDFView pdfView;
    private final FrameLayout rootView;

    private BloPdfDialogLayoutBinding(FrameLayout rootView, ImageView dialogCancelButton, TextView dialogPdfName, CardView pdfCard, FrameLayout pdfDialogRoot, PDFView pdfView) {
        this.rootView = rootView;
        this.dialogCancelButton = dialogCancelButton;
        this.dialogPdfName = dialogPdfName;
        this.pdfCard = pdfCard;
        this.pdfDialogRoot = pdfDialogRoot;
        this.pdfView = pdfView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloPdfDialogLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloPdfDialogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_pdf_dialog_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloPdfDialogLayoutBinding bind(View rootView) {
        int i = R.id.dialog_cancel_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dialog_cancel_button);
        if (imageView != null) {
            i = R.id.dialog_pdf_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.dialog_pdf_name);
            if (textView != null) {
                i = R.id.pdf_card;
                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.pdf_card);
                if (cardViewFindChildViewById != null) {
                    FrameLayout frameLayout = (FrameLayout) rootView;
                    i = R.id.pdfView;
                    PDFView pDFViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.pdfView);
                    if (pDFViewFindChildViewById != null) {
                        return new BloPdfDialogLayoutBinding(frameLayout, imageView, textView, cardViewFindChildViewById, frameLayout, pDFViewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
