package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentPseDoneBinding implements ViewBinding {
    public final RecyclerView allAppsRv;
    public final TextView nodata;
    public final LinearLayout nodatalayout;
    private final FrameLayout rootView;

    private BloFragmentPseDoneBinding(FrameLayout rootView, RecyclerView allAppsRv, TextView nodata, LinearLayout nodatalayout) {
        this.rootView = rootView;
        this.allAppsRv = allAppsRv;
        this.nodata = nodata;
        this.nodatalayout = nodatalayout;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentPseDoneBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentPseDoneBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_pse_done, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentPseDoneBinding bind(View rootView) {
        int i = R.id.all_apps_rv;
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.all_apps_rv);
        if (recyclerViewFindChildViewById != null) {
            i = R.id.nodata;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.nodata);
            if (textView != null) {
                i = R.id.nodatalayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.nodatalayout);
                if (linearLayout != null) {
                    return new BloFragmentPseDoneBinding((FrameLayout) rootView, recyclerViewFindChildViewById, textView, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
