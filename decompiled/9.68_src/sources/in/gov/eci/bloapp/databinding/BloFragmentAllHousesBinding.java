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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentAllHousesBinding implements ViewBinding {
    public final RecyclerView allAppsRv;
    public final FloatingActionButton filter;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final FloatingActionButton searchallhouse;
    public final TextView sectionNumber;

    private BloFragmentAllHousesBinding(ConstraintLayout rootView, RecyclerView allAppsRv, FloatingActionButton filter, ConstraintLayout root, FloatingActionButton searchallhouse, TextView sectionNumber) {
        this.rootView = rootView;
        this.allAppsRv = allAppsRv;
        this.filter = filter;
        this.root = root;
        this.searchallhouse = searchallhouse;
        this.sectionNumber = sectionNumber;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentAllHousesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentAllHousesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_all_houses, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentAllHousesBinding bind(View rootView) {
        int i = R.id.all_apps_rv;
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.all_apps_rv);
        if (recyclerViewFindChildViewById != null) {
            i = R.id.filter;
            FloatingActionButton floatingActionButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.filter);
            if (floatingActionButtonFindChildViewById != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.searchallhouse;
                FloatingActionButton floatingActionButtonFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.searchallhouse);
                if (floatingActionButtonFindChildViewById2 != null) {
                    i = R.id.sectionNumber;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.sectionNumber);
                    if (textView != null) {
                        return new BloFragmentAllHousesBinding(constraintLayout, recyclerViewFindChildViewById, floatingActionButtonFindChildViewById, constraintLayout, floatingActionButtonFindChildViewById2, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
