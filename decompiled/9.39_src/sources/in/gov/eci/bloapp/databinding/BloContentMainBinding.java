package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloContentMainBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private BloContentMainBinding(ConstraintLayout rootView) {
        this.rootView = rootView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloContentMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloContentMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_content_main, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloContentMainBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BloContentMainBinding((ConstraintLayout) rootView);
    }
}
