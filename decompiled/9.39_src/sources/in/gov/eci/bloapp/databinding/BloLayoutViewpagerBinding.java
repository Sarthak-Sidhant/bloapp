package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloLayoutViewpagerBinding implements ViewBinding {
    public final ImageView imageView;
    public final ImageView imageViewAnother;
    private final FrameLayout rootView;

    private BloLayoutViewpagerBinding(FrameLayout rootView, ImageView imageView, ImageView imageViewAnother) {
        this.rootView = rootView;
        this.imageView = imageView;
        this.imageViewAnother = imageViewAnother;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloLayoutViewpagerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloLayoutViewpagerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_layout_viewpager, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloLayoutViewpagerBinding bind(View rootView) {
        int i = R.id.imageView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
        if (imageView != null) {
            i = R.id.imageViewAnother;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageViewAnother);
            if (imageView2 != null) {
                return new BloLayoutViewpagerBinding((FrameLayout) rootView, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
