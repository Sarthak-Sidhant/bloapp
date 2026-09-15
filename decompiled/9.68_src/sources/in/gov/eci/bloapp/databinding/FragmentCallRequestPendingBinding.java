package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class FragmentCallRequestPendingBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RecyclerView totalListRv;

    private FragmentCallRequestPendingBinding(LinearLayout rootView, RecyclerView totalListRv) {
        this.rootView = rootView;
        this.totalListRv = totalListRv;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCallRequestPendingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCallRequestPendingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_call_request_pending, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCallRequestPendingBinding bind(View rootView) {
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.total_list_rv);
        if (recyclerViewFindChildViewById != null) {
            return new FragmentCallRequestPendingBinding((LinearLayout) rootView, recyclerViewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.total_list_rv)));
    }
}
