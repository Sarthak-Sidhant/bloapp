package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloActivitySplashBinding implements ViewBinding {
    public final TextView bloModule;
    private final ConstraintLayout rootView;

    private BloActivitySplashBinding(ConstraintLayout rootView, TextView bloModule) {
        this.rootView = rootView;
        this.bloModule = bloModule;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivitySplashBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivitySplashBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_splash, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivitySplashBinding bind(View rootView) {
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.blo_module);
        if (textView != null) {
            return new BloActivitySplashBinding((ConstraintLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.blo_module)));
    }
}
