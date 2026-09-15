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
public final class BloDeclarationImageDialogLayoutBinding implements ViewBinding {
    public final ImageView declarationCancelButton;
    public final TextView declarationImageName;
    public final TouchImageView declarationSignImage;
    public final FrameLayout imageDialogRoot;
    private final FrameLayout rootView;

    private BloDeclarationImageDialogLayoutBinding(FrameLayout rootView, ImageView declarationCancelButton, TextView declarationImageName, TouchImageView declarationSignImage, FrameLayout imageDialogRoot) {
        this.rootView = rootView;
        this.declarationCancelButton = declarationCancelButton;
        this.declarationImageName = declarationImageName;
        this.declarationSignImage = declarationSignImage;
        this.imageDialogRoot = imageDialogRoot;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloDeclarationImageDialogLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloDeclarationImageDialogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_declaration_image_dialog_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloDeclarationImageDialogLayoutBinding bind(View rootView) {
        int i = R.id.declaration_cancel_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.declaration_cancel_button);
        if (imageView != null) {
            i = R.id.declaration_image_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.declaration_image_name);
            if (textView != null) {
                i = R.id.declaration_sign_image;
                TouchImageView touchImageView = (TouchImageView) ViewBindings.findChildViewById(rootView, R.id.declaration_sign_image);
                if (touchImageView != null) {
                    FrameLayout frameLayout = (FrameLayout) rootView;
                    return new BloDeclarationImageDialogLayoutBinding(frameLayout, imageView, textView, touchImageView, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
