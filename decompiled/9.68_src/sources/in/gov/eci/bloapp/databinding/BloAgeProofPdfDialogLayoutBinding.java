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
public final class BloAgeProofPdfDialogLayoutBinding implements ViewBinding {
    public final ImageView ageProofDialogCancelButton;
    public final TextView ageProofDialogPdfName;
    public final CardView ageProofPdfCard;
    public final PDFView ageProofPdfView;
    public final FrameLayout pdfDialogRoot;
    private final FrameLayout rootView;

    private BloAgeProofPdfDialogLayoutBinding(FrameLayout rootView, ImageView ageProofDialogCancelButton, TextView ageProofDialogPdfName, CardView ageProofPdfCard, PDFView ageProofPdfView, FrameLayout pdfDialogRoot) {
        this.rootView = rootView;
        this.ageProofDialogCancelButton = ageProofDialogCancelButton;
        this.ageProofDialogPdfName = ageProofDialogPdfName;
        this.ageProofPdfCard = ageProofPdfCard;
        this.ageProofPdfView = ageProofPdfView;
        this.pdfDialogRoot = pdfDialogRoot;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloAgeProofPdfDialogLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloAgeProofPdfDialogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_age_proof_pdf_dialog_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloAgeProofPdfDialogLayoutBinding bind(View rootView) {
        int i = R.id.age_proof_dialog_cancel_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.age_proof_dialog_cancel_button);
        if (imageView != null) {
            i = R.id.age_proof_dialog_pdf_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.age_proof_dialog_pdf_name);
            if (textView != null) {
                i = R.id.age_proof_pdf_card;
                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.age_proof_pdf_card);
                if (cardViewFindChildViewById != null) {
                    i = R.id.age_proof_pdfView;
                    PDFView pDFViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.age_proof_pdfView);
                    if (pDFViewFindChildViewById != null) {
                        FrameLayout frameLayout = (FrameLayout) rootView;
                        return new BloAgeProofPdfDialogLayoutBinding(frameLayout, imageView, textView, cardViewFindChildViewById, pDFViewFindChildViewById, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
