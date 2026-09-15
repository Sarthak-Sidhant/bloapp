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
public final class BloActivityElectorsListBinding implements ViewBinding {
    public final FrameLayout electorsListFrame;
    private final ConstraintLayout rootView;

    private BloActivityElectorsListBinding(ConstraintLayout rootView, FrameLayout electorsListFrame) {
        this.rootView = rootView;
        this.electorsListFrame = electorsListFrame;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityElectorsListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityElectorsListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_electors_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityElectorsListBinding bind(View rootView) {
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.electorsListFrame);
        if (frameLayout != null) {
            return new BloActivityElectorsListBinding((ConstraintLayout) rootView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.electorsListFrame)));
    }
}
