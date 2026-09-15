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
public final class BloActivityTrackStatusBinding implements ViewBinding {
    public final FrameLayout frameVoterForms;
    private final ConstraintLayout rootView;

    private BloActivityTrackStatusBinding(ConstraintLayout rootView, FrameLayout frameVoterForms) {
        this.rootView = rootView;
        this.frameVoterForms = frameVoterForms;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityTrackStatusBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityTrackStatusBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_track_status, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityTrackStatusBinding bind(View rootView) {
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.frame_voter_forms);
        if (frameLayout != null) {
            return new BloActivityTrackStatusBinding((ConstraintLayout) rootView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.frame_voter_forms)));
    }
}
