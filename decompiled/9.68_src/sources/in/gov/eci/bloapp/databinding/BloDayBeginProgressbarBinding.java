package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloDayBeginProgressbarBinding implements ViewBinding {
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;

    private BloDayBeginProgressbarBinding(ConstraintLayout rootView, ProgressBar progressBar) {
        this.rootView = rootView;
        this.progressBar = progressBar;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloDayBeginProgressbarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloDayBeginProgressbarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_day_begin_progressbar, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloDayBeginProgressbarBinding bind(View rootView) {
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
        if (progressBar != null) {
            return new BloDayBeginProgressbarBinding((ConstraintLayout) rootView, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.progressBar)));
    }
}
