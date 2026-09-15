package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentObjecteeDetailsBinding implements ViewBinding {
    public final RecyclerView objecteeDetails;
    private final FrameLayout rootView;

    private BloFragmentObjecteeDetailsBinding(FrameLayout rootView, RecyclerView objecteeDetails) {
        this.rootView = rootView;
        this.objecteeDetails = objecteeDetails;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentObjecteeDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentObjecteeDetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_objectee_details, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentObjecteeDetailsBinding bind(View rootView) {
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.objecteeDetails);
        if (recyclerViewFindChildViewById != null) {
            return new BloFragmentObjecteeDetailsBinding((FrameLayout) rootView, recyclerViewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.objecteeDetails)));
    }
}
