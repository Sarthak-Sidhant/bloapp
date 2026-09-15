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
public final class BloFragmentFaqsBinding implements ViewBinding {
    public final RecyclerView fragmentBooksearchSearchResultsRecyclerView;
    private final ConstraintLayout rootView;

    private BloFragmentFaqsBinding(ConstraintLayout rootView, RecyclerView fragmentBooksearchSearchResultsRecyclerView) {
        this.rootView = rootView;
        this.fragmentBooksearchSearchResultsRecyclerView = fragmentBooksearchSearchResultsRecyclerView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentFaqsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentFaqsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_faqs, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentFaqsBinding bind(View rootView) {
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.fragmentBooksearchSearchResultsRecyclerView);
        if (recyclerViewFindChildViewById != null) {
            return new BloFragmentFaqsBinding((ConstraintLayout) rootView, recyclerViewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.fragmentBooksearchSearchResultsRecyclerView)));
    }
}
