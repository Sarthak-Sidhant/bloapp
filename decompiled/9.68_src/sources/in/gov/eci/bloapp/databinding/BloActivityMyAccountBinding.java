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
public final class BloActivityMyAccountBinding implements ViewBinding {
    public final FrameLayout main;
    private final ConstraintLayout rootView;

    private BloActivityMyAccountBinding(ConstraintLayout rootView, FrameLayout main) {
        this.rootView = rootView;
        this.main = main;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityMyAccountBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityMyAccountBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_my_account, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityMyAccountBinding bind(View rootView) {
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.main);
        if (frameLayout != null) {
            return new BloActivityMyAccountBinding((ConstraintLayout) rootView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.main)));
    }
}
