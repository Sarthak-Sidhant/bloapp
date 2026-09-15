package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentVerifiedBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final FloatingActionButton searchverified;
    public final RecyclerView verifiedRv;

    private BloFragmentVerifiedBinding(FrameLayout rootView, FloatingActionButton searchverified, RecyclerView verifiedRv) {
        this.rootView = rootView;
        this.searchverified = searchverified;
        this.verifiedRv = verifiedRv;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentVerifiedBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentVerifiedBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_verified, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentVerifiedBinding bind(View rootView) {
        int i = R.id.searchverified;
        FloatingActionButton floatingActionButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.searchverified);
        if (floatingActionButtonFindChildViewById != null) {
            i = R.id.verified_rv;
            RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.verified_rv);
            if (recyclerViewFindChildViewById != null) {
                return new BloFragmentVerifiedBinding((FrameLayout) rootView, floatingActionButtonFindChildViewById, recyclerViewFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
