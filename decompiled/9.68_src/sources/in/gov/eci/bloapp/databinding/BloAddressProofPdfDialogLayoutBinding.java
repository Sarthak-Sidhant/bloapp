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
public final class BloAddressProofPdfDialogLayoutBinding implements ViewBinding {
    public final ImageView addressProofDialogCancelButton;
    public final TextView addressProofDialogPdfName;
    public final CardView addressProofPdfCard;
    public final PDFView addressProofPdfView;
    public final FrameLayout pdfDialogRoot;
    private final FrameLayout rootView;

    private BloAddressProofPdfDialogLayoutBinding(FrameLayout rootView, ImageView addressProofDialogCancelButton, TextView addressProofDialogPdfName, CardView addressProofPdfCard, PDFView addressProofPdfView, FrameLayout pdfDialogRoot) {
        this.rootView = rootView;
        this.addressProofDialogCancelButton = addressProofDialogCancelButton;
        this.addressProofDialogPdfName = addressProofDialogPdfName;
        this.addressProofPdfCard = addressProofPdfCard;
        this.addressProofPdfView = addressProofPdfView;
        this.pdfDialogRoot = pdfDialogRoot;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloAddressProofPdfDialogLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloAddressProofPdfDialogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_address_proof_pdf_dialog_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloAddressProofPdfDialogLayoutBinding bind(View rootView) {
        int i = R.id.address_proof_dialog_cancel_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.address_proof_dialog_cancel_button);
        if (imageView != null) {
            i = R.id.address_proof_dialog_pdf_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_proof_dialog_pdf_name);
            if (textView != null) {
                i = R.id.address_proof_pdf_card;
                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.address_proof_pdf_card);
                if (cardViewFindChildViewById != null) {
                    i = R.id.address_proof_pdfView;
                    PDFView pDFViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.address_proof_pdfView);
                    if (pDFViewFindChildViewById != null) {
                        FrameLayout frameLayout = (FrameLayout) rootView;
                        return new BloAddressProofPdfDialogLayoutBinding(frameLayout, imageView, textView, cardViewFindChildViewById, pDFViewFindChildViewById, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
