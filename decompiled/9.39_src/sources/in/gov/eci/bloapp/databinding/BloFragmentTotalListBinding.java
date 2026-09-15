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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentTotalListBinding implements ViewBinding {
    public final TextView all;
    public final FrameLayout chartFragment;
    public final FrameLayout frameTotal;
    public final TextView last15;
    public final TextView lastWeek;
    private final LinearLayout rootView;
    public final TextView today;
    public final RecyclerView totalListRv;
    public final FloatingActionButton totalListSearch;
    public final TextView totalNoForms;

    private BloFragmentTotalListBinding(LinearLayout rootView, TextView all, FrameLayout chartFragment, FrameLayout frameTotal, TextView last15, TextView lastWeek, TextView today, RecyclerView totalListRv, FloatingActionButton totalListSearch, TextView totalNoForms) {
        this.rootView = rootView;
        this.all = all;
        this.chartFragment = chartFragment;
        this.frameTotal = frameTotal;
        this.last15 = last15;
        this.lastWeek = lastWeek;
        this.today = today;
        this.totalListRv = totalListRv;
        this.totalListSearch = totalListSearch;
        this.totalNoForms = totalNoForms;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentTotalListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentTotalListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_total_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentTotalListBinding bind(View rootView) {
        int i = R.id.all;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.all);
        if (textView != null) {
            i = R.id.chart_fragment;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.chart_fragment);
            if (frameLayout != null) {
                i = R.id.frame_total;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.frame_total);
                if (frameLayout2 != null) {
                    i = R.id.last_15;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.last_15);
                    if (textView2 != null) {
                        i = R.id.last_week;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.last_week);
                        if (textView3 != null) {
                            i = R.id.today;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.today);
                            if (textView4 != null) {
                                i = R.id.total_list_rv;
                                RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.total_list_rv);
                                if (recyclerViewFindChildViewById != null) {
                                    i = R.id.total_list_search;
                                    FloatingActionButton floatingActionButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.total_list_search);
                                    if (floatingActionButtonFindChildViewById != null) {
                                        i = R.id.total_no_forms;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.total_no_forms);
                                        if (textView5 != null) {
                                            return new BloFragmentTotalListBinding((LinearLayout) rootView, textView, frameLayout, frameLayout2, textView2, textView3, textView4, recyclerViewFindChildViewById, floatingActionButtonFindChildViewById, textView5);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
