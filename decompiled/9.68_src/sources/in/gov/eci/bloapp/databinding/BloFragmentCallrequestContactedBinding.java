package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentCallrequestContactedBinding implements ViewBinding {
    public final RecyclerView contactedListRv;
    private final ConstraintLayout rootView;

    private BloFragmentCallrequestContactedBinding(ConstraintLayout rootView, RecyclerView contactedListRv) {
        this.rootView = rootView;
        this.contactedListRv = contactedListRv;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentCallrequestContactedBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentCallrequestContactedBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_callrequest_contacted, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentCallrequestContactedBinding bind(View rootView) {
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.contacted_list_rv);
        if (recyclerViewFindChildViewById != null) {
            return new BloFragmentCallrequestContactedBinding((ConstraintLayout) rootView, recyclerViewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.contacted_list_rv)));
    }
}
