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

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloDisabilityProofPdfDialogLayoutBinding implements ViewBinding {
    public final ImageView disabilityProofDialogCancelButton;
    public final TextView disabilityProofDialogPdfName;
    public final CardView disabilityProofPdfCard;
    public final PDFView disabilityProofPdfView;
    public final FrameLayout pdfDialogRoot;
    private final FrameLayout rootView;

    private BloDisabilityProofPdfDialogLayoutBinding(FrameLayout rootView, ImageView disabilityProofDialogCancelButton, TextView disabilityProofDialogPdfName, CardView disabilityProofPdfCard, PDFView disabilityProofPdfView, FrameLayout pdfDialogRoot) {
        this.rootView = rootView;
        this.disabilityProofDialogCancelButton = disabilityProofDialogCancelButton;
        this.disabilityProofDialogPdfName = disabilityProofDialogPdfName;
        this.disabilityProofPdfCard = disabilityProofPdfCard;
        this.disabilityProofPdfView = disabilityProofPdfView;
        this.pdfDialogRoot = pdfDialogRoot;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloDisabilityProofPdfDialogLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloDisabilityProofPdfDialogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_disability_proof_pdf_dialog_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloDisabilityProofPdfDialogLayoutBinding bind(View rootView) {
        int i = R.id.disability_proof_dialog_cancel_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.disability_proof_dialog_cancel_button);
        if (imageView != null) {
            i = R.id.disability_proof_dialog_pdf_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.disability_proof_dialog_pdf_name);
            if (textView != null) {
                i = R.id.disability_proof_pdf_card;
                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.disability_proof_pdf_card);
                if (cardViewFindChildViewById != null) {
                    i = R.id.disability_proof_pdfView;
                    PDFView pDFViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.disability_proof_pdfView);
                    if (pDFViewFindChildViewById != null) {
                        FrameLayout frameLayout = (FrameLayout) rootView;
                        return new BloDisabilityProofPdfDialogLayoutBinding(frameLayout, imageView, textView, cardViewFindChildViewById, pDFViewFindChildViewById, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
