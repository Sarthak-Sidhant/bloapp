package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentVerifiedHouseBinding implements ViewBinding {
    public final FloatingActionButton filter;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final FloatingActionButton searchverified;
    public final TextView sectionNumber;
    public final RecyclerView verifiedRv;

    private BloFragmentVerifiedHouseBinding(ConstraintLayout rootView, FloatingActionButton filter, ConstraintLayout root, FloatingActionButton searchverified, TextView sectionNumber, RecyclerView verifiedRv) {
        this.rootView = rootView;
        this.filter = filter;
        this.root = root;
        this.searchverified = searchverified;
        this.sectionNumber = sectionNumber;
        this.verifiedRv = verifiedRv;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentVerifiedHouseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentVerifiedHouseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_verified_house, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentVerifiedHouseBinding bind(View rootView) {
        int i = R.id.filter;
        FloatingActionButton floatingActionButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.filter);
        if (floatingActionButtonFindChildViewById != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.searchverified;
            FloatingActionButton floatingActionButtonFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.searchverified);
            if (floatingActionButtonFindChildViewById2 != null) {
                i = R.id.sectionNumber;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.sectionNumber);
                if (textView != null) {
                    i = R.id.verified_rv;
                    RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.verified_rv);
                    if (recyclerViewFindChildViewById != null) {
                        return new BloFragmentVerifiedHouseBinding(constraintLayout, floatingActionButtonFindChildViewById, constraintLayout, floatingActionButtonFindChildViewById2, textView, recyclerViewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
