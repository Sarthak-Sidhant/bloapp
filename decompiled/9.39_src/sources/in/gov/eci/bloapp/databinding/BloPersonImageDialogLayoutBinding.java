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
public final class BloPersonImageDialogLayoutBinding implements ViewBinding {
    public final FrameLayout imageDialogRoot;
    public final ImageView personCancelButton;
    public final TouchImageView personImage;
    public final TextView personImageName;
    private final FrameLayout rootView;

    private BloPersonImageDialogLayoutBinding(FrameLayout rootView, FrameLayout imageDialogRoot, ImageView personCancelButton, TouchImageView personImage, TextView personImageName) {
        this.rootView = rootView;
        this.imageDialogRoot = imageDialogRoot;
        this.personCancelButton = personCancelButton;
        this.personImage = personImage;
        this.personImageName = personImageName;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloPersonImageDialogLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloPersonImageDialogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_person_image_dialog_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloPersonImageDialogLayoutBinding bind(View rootView) {
        FrameLayout frameLayout = (FrameLayout) rootView;
        int i = R.id.person_cancel_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.person_cancel_button);
        if (imageView != null) {
            i = R.id.person_image;
            TouchImageView touchImageView = (TouchImageView) ViewBindings.findChildViewById(rootView, R.id.person_image);
            if (touchImageView != null) {
                i = R.id.person_image_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.person_image_name);
                if (textView != null) {
                    return new BloPersonImageDialogLayoutBinding(frameLayout, frameLayout, imageView, touchImageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
