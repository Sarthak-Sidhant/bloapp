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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloDialogImageBinding implements ViewBinding {
    public final ImageView cancelButton;
    public final TextView imageDel;
    public final FrameLayout imageDialogRoot;
    public final TextView imageName;
    public final ImageView leftButton;
    public final ImageView personImage;
    public final ImageView rightButton;
    private final FrameLayout rootView;

    private BloDialogImageBinding(FrameLayout rootView, ImageView cancelButton, TextView imageDel, FrameLayout imageDialogRoot, TextView imageName, ImageView leftButton, ImageView personImage, ImageView rightButton) {
        this.rootView = rootView;
        this.cancelButton = cancelButton;
        this.imageDel = imageDel;
        this.imageDialogRoot = imageDialogRoot;
        this.imageName = imageName;
        this.leftButton = leftButton;
        this.personImage = personImage;
        this.rightButton = rightButton;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloDialogImageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloDialogImageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_dialog_image, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloDialogImageBinding bind(View rootView) {
        int i = R.id.cancel_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel_button);
        if (imageView != null) {
            i = R.id.image_del;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.image_del);
            if (textView != null) {
                FrameLayout frameLayout = (FrameLayout) rootView;
                i = R.id.image_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.image_name);
                if (textView2 != null) {
                    i = R.id.left_button;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.left_button);
                    if (imageView2 != null) {
                        i = R.id.person_image;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.person_image);
                        if (imageView3 != null) {
                            i = R.id.right_button;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.right_button);
                            if (imageView4 != null) {
                                return new BloDialogImageBinding(frameLayout, imageView, textView, frameLayout, textView2, imageView2, imageView3, imageView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
