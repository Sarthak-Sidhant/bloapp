package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloActivityDseBinding implements ViewBinding {
    public final FrameLayout frame;
    private final ConstraintLayout rootView;

    private BloActivityDseBinding(ConstraintLayout rootView, FrameLayout frame) {
        this.rootView = rootView;
        this.frame = frame;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityDseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityDseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_dse, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityDseBinding bind(View rootView) {
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.frame);
        if (frameLayout != null) {
            return new BloActivityDseBinding((ConstraintLayout) rootView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.frame)));
    }
}
