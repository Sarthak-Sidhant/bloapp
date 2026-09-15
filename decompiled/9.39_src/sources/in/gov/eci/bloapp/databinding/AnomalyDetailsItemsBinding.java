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
public final class AnomalyDetailsItemsBinding implements ViewBinding {
    public final TextView fillPendingSir;
    public final LinearLayout lvMappedMultiGender;
    public final LinearLayout lvParentNameMismatch;
    public final LinearLayout lvRelativeAgeIssue;
    public final LinearLayout lvWrongCate;
    public final LinearLayout pendingLL;
    private final LinearLayout rootView;
    public final TextView tvMappedMultiGender;
    public final TextView tvParentNameMismatch;
    public final TextView tvRelativeAgeIssue;
    public final TextView tvWrongCate;
    public final TextView uncollectablePendingSir;

    private AnomalyDetailsItemsBinding(LinearLayout rootView, TextView fillPendingSir, LinearLayout lvMappedMultiGender, LinearLayout lvParentNameMismatch, LinearLayout lvRelativeAgeIssue, LinearLayout lvWrongCate, LinearLayout pendingLL, TextView tvMappedMultiGender, TextView tvParentNameMismatch, TextView tvRelativeAgeIssue, TextView tvWrongCate, TextView uncollectablePendingSir) {
        this.rootView = rootView;
        this.fillPendingSir = fillPendingSir;
        this.lvMappedMultiGender = lvMappedMultiGender;
        this.lvParentNameMismatch = lvParentNameMismatch;
        this.lvRelativeAgeIssue = lvRelativeAgeIssue;
        this.lvWrongCate = lvWrongCate;
        this.pendingLL = pendingLL;
        this.tvMappedMultiGender = tvMappedMultiGender;
        this.tvParentNameMismatch = tvParentNameMismatch;
        this.tvRelativeAgeIssue = tvRelativeAgeIssue;
        this.tvWrongCate = tvWrongCate;
        this.uncollectablePendingSir = uncollectablePendingSir;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AnomalyDetailsItemsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AnomalyDetailsItemsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.anomaly_details_items, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AnomalyDetailsItemsBinding bind(View rootView) {
        int i = R.id.fill_pending_sir;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.fill_pending_sir);
        if (textView != null) {
            i = R.id.lv_mappedMultiGender;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_mappedMultiGender);
            if (linearLayout != null) {
                i = R.id.lv_parentNameMismatch;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_parentNameMismatch);
                if (linearLayout2 != null) {
                    i = R.id.lv_relativeAgeIssue;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_relativeAgeIssue);
                    if (linearLayout3 != null) {
                        i = R.id.lv_wrongCate;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_wrongCate);
                        if (linearLayout4 != null) {
                            i = R.id.pendingLL;
                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pendingLL);
                            if (linearLayout5 != null) {
                                i = R.id.tv_mappedMultiGender;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_mappedMultiGender);
                                if (textView2 != null) {
                                    i = R.id.tv_parentNameMismatch;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_parentNameMismatch);
                                    if (textView3 != null) {
                                        i = R.id.tv_relativeAgeIssue;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relativeAgeIssue);
                                        if (textView4 != null) {
                                            i = R.id.tv_wrongCate;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_wrongCate);
                                            if (textView5 != null) {
                                                i = R.id.uncollectable_pending_sir;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uncollectable_pending_sir);
                                                if (textView6 != null) {
                                                    return new AnomalyDetailsItemsBinding((LinearLayout) rootView, textView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, textView2, textView3, textView4, textView5, textView6);
                                                }
                                            }
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
