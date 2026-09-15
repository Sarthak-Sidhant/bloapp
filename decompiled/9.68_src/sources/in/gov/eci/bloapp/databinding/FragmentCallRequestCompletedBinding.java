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
public final class FragmentCallRequestCompletedBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final RecyclerView verifiedRv;

    private FragmentCallRequestCompletedBinding(FrameLayout rootView, RecyclerView verifiedRv) {
        this.rootView = rootView;
        this.verifiedRv = verifiedRv;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCallRequestCompletedBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCallRequestCompletedBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_call_request_completed, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCallRequestCompletedBinding bind(View rootView) {
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.verified_rv);
        if (recyclerViewFindChildViewById != null) {
            return new FragmentCallRequestCompletedBinding((FrameLayout) rootView, recyclerViewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.verified_rv)));
    }
}
