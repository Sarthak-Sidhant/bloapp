package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentTrackRejectedBinding implements ViewBinding {
    public final RecyclerView allElectorRv;
    public final View divider1;
    private final FrameLayout rootView;

    private BloFragmentTrackRejectedBinding(FrameLayout rootView, RecyclerView allElectorRv, View divider1) {
        this.rootView = rootView;
        this.allElectorRv = allElectorRv;
        this.divider1 = divider1;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentTrackRejectedBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentTrackRejectedBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_track_rejected, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentTrackRejectedBinding bind(View rootView) {
        int i = R.id.all_elector_rv;
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.all_elector_rv);
        if (recyclerViewFindChildViewById != null) {
            i = R.id.divider1;
            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.divider1);
            if (viewFindChildViewById != null) {
                return new BloFragmentTrackRejectedBinding((FrameLayout) rootView, recyclerViewFindChildViewById, viewFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
