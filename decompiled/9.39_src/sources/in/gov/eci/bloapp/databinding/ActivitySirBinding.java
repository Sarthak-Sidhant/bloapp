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
public final class ActivitySirBinding implements ViewBinding {
    public final FrameLayout frame;
    public final ConstraintLayout main;
    private final ConstraintLayout rootView;

    private ActivitySirBinding(ConstraintLayout rootView, FrameLayout frame, ConstraintLayout main) {
        this.rootView = rootView;
        this.frame = frame;
        this.main = main;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySirBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySirBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_sir, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySirBinding bind(View rootView) {
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.frame);
        if (frameLayout != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            return new ActivitySirBinding(constraintLayout, frameLayout, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.frame)));
    }
}
