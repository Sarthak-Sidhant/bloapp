package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentCallrequestPendingBinding implements ViewBinding {
    public final FrameLayout frameTotal;
    private final LinearLayout rootView;
    public final RecyclerView totalListRv;

    private BloFragmentCallrequestPendingBinding(LinearLayout rootView, FrameLayout frameTotal, RecyclerView totalListRv) {
        this.rootView = rootView;
        this.frameTotal = frameTotal;
        this.totalListRv = totalListRv;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentCallrequestPendingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentCallrequestPendingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_callrequest_pending, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentCallrequestPendingBinding bind(View rootView) {
        int i = R.id.frame_total;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.frame_total);
        if (frameLayout != null) {
            i = R.id.total_list_rv;
            RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.total_list_rv);
            if (recyclerViewFindChildViewById != null) {
                return new BloFragmentCallrequestPendingBinding((LinearLayout) rootView, frameLayout, recyclerViewFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
