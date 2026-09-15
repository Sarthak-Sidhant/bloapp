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

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloAgeImageDialogLayoutBinding implements ViewBinding {
    public final ImageView ageCancelButton;
    public final TouchImageView ageImage;
    public final TextView ageImageName;
    public final FrameLayout imageDialogRoot;
    private final FrameLayout rootView;

    private BloAgeImageDialogLayoutBinding(FrameLayout rootView, ImageView ageCancelButton, TouchImageView ageImage, TextView ageImageName, FrameLayout imageDialogRoot) {
        this.rootView = rootView;
        this.ageCancelButton = ageCancelButton;
        this.ageImage = ageImage;
        this.ageImageName = ageImageName;
        this.imageDialogRoot = imageDialogRoot;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloAgeImageDialogLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloAgeImageDialogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_age_image_dialog_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloAgeImageDialogLayoutBinding bind(View rootView) {
        int i = R.id.age_cancel_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.age_cancel_button);
        if (imageView != null) {
            i = R.id.age_image;
            TouchImageView touchImageView = (TouchImageView) ViewBindings.findChildViewById(rootView, R.id.age_image);
            if (touchImageView != null) {
                i = R.id.age_image_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.age_image_name);
                if (textView != null) {
                    FrameLayout frameLayout = (FrameLayout) rootView;
                    return new BloAgeImageDialogLayoutBinding(frameLayout, imageView, touchImageView, textView, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
