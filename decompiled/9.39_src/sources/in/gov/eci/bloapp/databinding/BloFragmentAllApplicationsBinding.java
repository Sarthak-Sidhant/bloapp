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
public final class BloFragmentAllApplicationsBinding implements ViewBinding {
    public final RecyclerView allAppsRv;
    private final ConstraintLayout rootView;

    private BloFragmentAllApplicationsBinding(ConstraintLayout rootView, RecyclerView allAppsRv) {
        this.rootView = rootView;
        this.allAppsRv = allAppsRv;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentAllApplicationsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentAllApplicationsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_all_applications, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentAllApplicationsBinding bind(View rootView) {
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.all_apps_rv);
        if (recyclerViewFindChildViewById != null) {
            return new BloFragmentAllApplicationsBinding((ConstraintLayout) rootView, recyclerViewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.all_apps_rv)));
    }
}
