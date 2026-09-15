package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentChecklistVerifiedBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final RecyclerView verifiedListRv;

    private BloFragmentChecklistVerifiedBinding(ConstraintLayout rootView, RecyclerView verifiedListRv) {
        this.rootView = rootView;
        this.verifiedListRv = verifiedListRv;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentChecklistVerifiedBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentChecklistVerifiedBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_checklist_verified, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentChecklistVerifiedBinding bind(View rootView) {
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.verified_list_rv);
        if (recyclerViewFindChildViewById != null) {
            return new BloFragmentChecklistVerifiedBinding((ConstraintLayout) rootView, recyclerViewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.verified_list_rv)));
    }
}
