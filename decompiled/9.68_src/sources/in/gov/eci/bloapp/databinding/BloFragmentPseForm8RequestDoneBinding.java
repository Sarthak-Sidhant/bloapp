package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentPseForm8RequestDoneBinding implements ViewBinding {
    public final RecyclerView allAppsRv;
    public final TextView nodata;
    public final LinearLayout nodatalayout;
    private final ConstraintLayout rootView;
    public final FloatingActionButton searchDsePending;

    private BloFragmentPseForm8RequestDoneBinding(ConstraintLayout rootView, RecyclerView allAppsRv, TextView nodata, LinearLayout nodatalayout, FloatingActionButton searchDsePending) {
        this.rootView = rootView;
        this.allAppsRv = allAppsRv;
        this.nodata = nodata;
        this.nodatalayout = nodatalayout;
        this.searchDsePending = searchDsePending;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentPseForm8RequestDoneBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentPseForm8RequestDoneBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_pse_form8_request_done, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentPseForm8RequestDoneBinding bind(View rootView) {
        int i = R.id.all_apps_rv;
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.all_apps_rv);
        if (recyclerViewFindChildViewById != null) {
            i = R.id.nodata;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.nodata);
            if (textView != null) {
                i = R.id.nodatalayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.nodatalayout);
                if (linearLayout != null) {
                    i = R.id.searchDsePending;
                    FloatingActionButton floatingActionButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.searchDsePending);
                    if (floatingActionButtonFindChildViewById != null) {
                        return new BloFragmentPseForm8RequestDoneBinding((ConstraintLayout) rootView, recyclerViewFindChildViewById, textView, linearLayout, floatingActionButtonFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
