package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class AnomalyValueBinding implements ViewBinding {
    public final LinearLayout lvParentNameMisMatch;
    private final LinearLayout rootView;
    public final TextView tvParentNameMisMatch;

    private AnomalyValueBinding(LinearLayout rootView, LinearLayout lvParentNameMisMatch, TextView tvParentNameMisMatch) {
        this.rootView = rootView;
        this.lvParentNameMisMatch = lvParentNameMisMatch;
        this.tvParentNameMisMatch = tvParentNameMisMatch;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AnomalyValueBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AnomalyValueBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.anomaly_value, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AnomalyValueBinding bind(View rootView) {
        int i = R.id.lv_parentNameMisMatch;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_parentNameMisMatch);
        if (linearLayout != null) {
            i = R.id.tv_parentNameMisMatch;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_parentNameMisMatch);
            if (textView != null) {
                return new AnomalyValueBinding((LinearLayout) rootView, linearLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
