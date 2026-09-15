package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloImagesBinding implements ViewBinding {
    public final ImageView imageButton2;
    private final LinearLayout rootView;

    private BloImagesBinding(LinearLayout rootView, ImageView imageButton2) {
        this.rootView = rootView;
        this.imageButton2 = imageButton2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloImagesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloImagesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_images, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloImagesBinding bind(View rootView) {
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageButton2);
        if (imageView != null) {
            return new BloImagesBinding((LinearLayout) rootView, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.imageButton2)));
    }
}
