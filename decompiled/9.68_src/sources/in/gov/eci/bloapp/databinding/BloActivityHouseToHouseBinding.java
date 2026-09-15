package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivityHouseToHouseBinding implements ViewBinding {
    public final FrameLayout frame;
    private final ConstraintLayout rootView;

    private BloActivityHouseToHouseBinding(ConstraintLayout rootView, FrameLayout frame) {
        this.rootView = rootView;
        this.frame = frame;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityHouseToHouseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityHouseToHouseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_house_to_house, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityHouseToHouseBinding bind(View rootView) {
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.frame);
        if (frameLayout != null) {
            return new BloActivityHouseToHouseBinding((ConstraintLayout) rootView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.frame)));
    }
}
