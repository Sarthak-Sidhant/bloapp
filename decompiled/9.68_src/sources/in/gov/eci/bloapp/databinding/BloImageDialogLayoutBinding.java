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
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.TouchImageView;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloImageDialogLayoutBinding implements ViewBinding {
    public final ImageView dialogCancelButton;
    public final TextView dialogImageName;
    public final TouchImageView dialogPersonImage;
    public final CardView imageCard;
    public final FrameLayout imageDialogRoot;
    private final FrameLayout rootView;

    private BloImageDialogLayoutBinding(FrameLayout rootView, ImageView dialogCancelButton, TextView dialogImageName, TouchImageView dialogPersonImage, CardView imageCard, FrameLayout imageDialogRoot) {
        this.rootView = rootView;
        this.dialogCancelButton = dialogCancelButton;
        this.dialogImageName = dialogImageName;
        this.dialogPersonImage = dialogPersonImage;
        this.imageCard = imageCard;
        this.imageDialogRoot = imageDialogRoot;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloImageDialogLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloImageDialogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_image_dialog_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloImageDialogLayoutBinding bind(View rootView) {
        int i = R.id.dialog_cancel_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dialog_cancel_button);
        if (imageView != null) {
            i = R.id.dialog_image_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.dialog_image_name);
            if (textView != null) {
                i = R.id.dialog_person_image;
                TouchImageView touchImageView = (TouchImageView) ViewBindings.findChildViewById(rootView, R.id.dialog_person_image);
                if (touchImageView != null) {
                    i = R.id.image_card;
                    CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.image_card);
                    if (cardViewFindChildViewById != null) {
                        FrameLayout frameLayout = (FrameLayout) rootView;
                        return new BloImageDialogLayoutBinding(frameLayout, imageView, textView, touchImageView, cardViewFindChildViewById, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
