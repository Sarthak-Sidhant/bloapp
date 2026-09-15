package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.TouchImageView;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloAddressProofImageDialogLayoutBinding implements ViewBinding {
    public final ImageView addressCancelButton;
    public final TouchImageView addressProofImage;
    public final TextView addressProofImageName;
    public final FrameLayout imageDialogRoot;
    private final FrameLayout rootView;

    private BloAddressProofImageDialogLayoutBinding(FrameLayout rootView, ImageView addressCancelButton, TouchImageView addressProofImage, TextView addressProofImageName, FrameLayout imageDialogRoot) {
        this.rootView = rootView;
        this.addressCancelButton = addressCancelButton;
        this.addressProofImage = addressProofImage;
        this.addressProofImageName = addressProofImageName;
        this.imageDialogRoot = imageDialogRoot;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloAddressProofImageDialogLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloAddressProofImageDialogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_address_proof_image_dialog_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloAddressProofImageDialogLayoutBinding bind(View rootView) {
        int i = R.id.address_cancel_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.address_cancel_button);
        if (imageView != null) {
            i = R.id.address_proof_image;
            TouchImageView touchImageView = (TouchImageView) ViewBindings.findChildViewById(rootView, R.id.address_proof_image);
            if (touchImageView != null) {
                i = R.id.address_proof_image_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_proof_image_name);
                if (textView != null) {
                    FrameLayout frameLayout = (FrameLayout) rootView;
                    return new BloAddressProofImageDialogLayoutBinding(frameLayout, imageView, touchImageView, textView, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
