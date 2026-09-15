package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloApiProgressBarBinding implements ViewBinding {
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;

    private BloApiProgressBarBinding(ConstraintLayout rootView, ProgressBar progressBar) {
        this.rootView = rootView;
        this.progressBar = progressBar;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloApiProgressBarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloApiProgressBarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_api_progress_bar, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloApiProgressBarBinding bind(View rootView) {
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
        if (progressBar != null) {
            return new BloApiProgressBarBinding((ConstraintLayout) rootView, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.progressBar)));
    }
}
