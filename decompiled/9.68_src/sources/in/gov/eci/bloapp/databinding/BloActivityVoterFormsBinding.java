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
public final class BloActivityVoterFormsBinding implements ViewBinding {
    public final FrameLayout frameVoterForms;
    private final ConstraintLayout rootView;

    private BloActivityVoterFormsBinding(ConstraintLayout rootView, FrameLayout frameVoterForms) {
        this.rootView = rootView;
        this.frameVoterForms = frameVoterForms;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityVoterFormsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityVoterFormsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_voter_forms, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityVoterFormsBinding bind(View rootView) {
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.frame_voter_forms);
        if (frameLayout != null) {
            return new BloActivityVoterFormsBinding((ConstraintLayout) rootView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.frame_voter_forms)));
    }
}
