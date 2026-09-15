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
public final class BloPersonPdfDialogLayoutBinding implements ViewBinding {
    public final FrameLayout pdfDialogRoot;
    public final ImageView personDialogCancelButton;
    public final TextView personDialogPdfName;
    public final CardView personPdfCard;
    public final PDFView personPdfView;
    private final FrameLayout rootView;

    private BloPersonPdfDialogLayoutBinding(FrameLayout rootView, FrameLayout pdfDialogRoot, ImageView personDialogCancelButton, TextView personDialogPdfName, CardView personPdfCard, PDFView personPdfView) {
        this.rootView = rootView;
        this.pdfDialogRoot = pdfDialogRoot;
        this.personDialogCancelButton = personDialogCancelButton;
        this.personDialogPdfName = personDialogPdfName;
        this.personPdfCard = personPdfCard;
        this.personPdfView = personPdfView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloPersonPdfDialogLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloPersonPdfDialogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_person_pdf_dialog_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloPersonPdfDialogLayoutBinding bind(View rootView) {
        FrameLayout frameLayout = (FrameLayout) rootView;
        int i = R.id.person_dialog_cancel_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.person_dialog_cancel_button);
        if (imageView != null) {
            i = R.id.person_dialog_pdf_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.person_dialog_pdf_name);
            if (textView != null) {
                i = R.id.person_pdf_card;
                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.person_pdf_card);
                if (cardViewFindChildViewById != null) {
                    i = R.id.person_pdfView;
                    PDFView pDFViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.person_pdfView);
                    if (pDFViewFindChildViewById != null) {
                        return new BloPersonPdfDialogLayoutBinding(frameLayout, frameLayout, imageView, textView, cardViewFindChildViewById, pDFViewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
