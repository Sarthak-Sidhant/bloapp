package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentSlideshowBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView textSlideshow;

    private BloFragmentSlideshowBinding(ConstraintLayout rootView, TextView textSlideshow) {
        this.rootView = rootView;
        this.textSlideshow = textSlideshow;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentSlideshowBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentSlideshowBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_slideshow, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentSlideshowBinding bind(View rootView) {
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.text_slideshow);
        if (textView != null) {
            return new BloFragmentSlideshowBinding((ConstraintLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.text_slideshow)));
    }
}
