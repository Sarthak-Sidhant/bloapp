package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentFAQBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RecyclerView text;

    private BloFragmentFAQBinding(LinearLayout rootView, RecyclerView text) {
        this.rootView = rootView;
        this.text = text;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentFAQBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentFAQBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_f_a_q, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentFAQBinding bind(View rootView) {
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, 2131366035);
        if (recyclerViewFindChildViewById != null) {
            return new BloFragmentFAQBinding((LinearLayout) rootView, recyclerViewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(2131366035)));
    }
}
