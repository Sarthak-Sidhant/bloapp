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
public final class BloActivityAboutEciactivityBinding implements ViewBinding {
    public final FrameLayout aboutEci;
    private final ConstraintLayout rootView;

    private BloActivityAboutEciactivityBinding(ConstraintLayout rootView, FrameLayout aboutEci) {
        this.rootView = rootView;
        this.aboutEci = aboutEci;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityAboutEciactivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityAboutEciactivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_about_eciactivity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityAboutEciactivityBinding bind(View rootView) {
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.aboutEci);
        if (frameLayout != null) {
            return new BloActivityAboutEciactivityBinding((ConstraintLayout) rootView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.aboutEci)));
    }
}
