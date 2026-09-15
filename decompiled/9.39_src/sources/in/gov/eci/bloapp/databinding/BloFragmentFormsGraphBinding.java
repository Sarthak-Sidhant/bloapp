package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.github.mikephil.charting.charts.BarChart;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentFormsGraphBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final BarChart stackedBarChart;
    public final TextView textView;

    private BloFragmentFormsGraphBinding(ConstraintLayout rootView, BarChart stackedBarChart, TextView textView) {
        this.rootView = rootView;
        this.stackedBarChart = stackedBarChart;
        this.textView = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentFormsGraphBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentFormsGraphBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_forms_graph, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentFormsGraphBinding bind(View rootView) {
        int i = R.id.stacked_BarChart;
        BarChart barChartFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.stacked_BarChart);
        if (barChartFindChildViewById != null) {
            i = R.id.textView;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView);
            if (textView != null) {
                return new BloFragmentFormsGraphBinding((ConstraintLayout) rootView, barChartFindChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
