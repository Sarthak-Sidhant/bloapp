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

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloImageDialogLayout2Binding implements ViewBinding {
    public final ImageView cancelButton;
    public final FrameLayout imageDialogRoot;
    public final TextView imageName;
    public final ImageView personImage;
    private final FrameLayout rootView;

    private BloImageDialogLayout2Binding(FrameLayout rootView, ImageView cancelButton, FrameLayout imageDialogRoot, TextView imageName, ImageView personImage) {
        this.rootView = rootView;
        this.cancelButton = cancelButton;
        this.imageDialogRoot = imageDialogRoot;
        this.imageName = imageName;
        this.personImage = personImage;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloImageDialogLayout2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloImageDialogLayout2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_image_dialog_layout2, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloImageDialogLayout2Binding bind(View rootView) {
        int i = R.id.cancel_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel_button);
        if (imageView != null) {
            FrameLayout frameLayout = (FrameLayout) rootView;
            i = R.id.image_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.image_name);
            if (textView != null) {
                i = R.id.person_image;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.person_image);
                if (imageView2 != null) {
                    return new BloImageDialogLayout2Binding(frameLayout, imageView, frameLayout, textView, imageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
