package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class AnomalyItemBinding implements ViewBinding {
    public final TextView acName;
    public final TextView address;
    public final LinearLayout cardViewLL;
    public final TextView category;
    public final TextView categoryTypeLabel;
    public final TextView electorName;
    public final TextView epic;
    public final LinearLayout llDeceased;
    public final LinearLayout lvAsd;
    public final LinearLayout lvCategory;
    public final LinearLayout lvEightfive;
    public final TextView partNo;
    private final LinearLayout rootView;
    public final TextView serialNo;
    public final TextView state;
    public final TextView tvAsd;
    public final TextView uncollectablePendingSir;
    public final TextView viewDetails;

    private AnomalyItemBinding(LinearLayout rootView, TextView acName, TextView address, LinearLayout cardViewLL, TextView category, TextView categoryTypeLabel, TextView electorName, TextView epic, LinearLayout llDeceased, LinearLayout lvAsd, LinearLayout lvCategory, LinearLayout lvEightfive, TextView partNo, TextView serialNo, TextView state, TextView tvAsd, TextView uncollectablePendingSir, TextView viewDetails) {
        this.rootView = rootView;
        this.acName = acName;
        this.address = address;
        this.cardViewLL = cardViewLL;
        this.category = category;
        this.categoryTypeLabel = categoryTypeLabel;
        this.electorName = electorName;
        this.epic = epic;
        this.llDeceased = llDeceased;
        this.lvAsd = lvAsd;
        this.lvCategory = lvCategory;
        this.lvEightfive = lvEightfive;
        this.partNo = partNo;
        this.serialNo = serialNo;
        this.state = state;
        this.tvAsd = tvAsd;
        this.uncollectablePendingSir = uncollectablePendingSir;
        this.viewDetails = viewDetails;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AnomalyItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AnomalyItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.anomaly_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AnomalyItemBinding bind(View rootView) {
        int i = R.id.acName;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.acName);
        if (textView != null) {
            i = R.id.address;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address);
            if (textView2 != null) {
                i = R.id.cardViewLL;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cardViewLL);
                if (linearLayout != null) {
                    i = R.id.category;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.category);
                    if (textView3 != null) {
                        i = R.id.category_type_label;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.category_type_label);
                        if (textView4 != null) {
                            i = R.id.electorName;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName);
                            if (textView5 != null) {
                                i = R.id.epic;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic);
                                if (textView6 != null) {
                                    i = R.id.ll_deceased;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_deceased);
                                    if (linearLayout2 != null) {
                                        i = R.id.lv_asd;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_asd);
                                        if (linearLayout3 != null) {
                                            i = R.id.lv_category;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_category);
                                            if (linearLayout4 != null) {
                                                i = R.id.lv_eightfive;
                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_eightfive);
                                                if (linearLayout5 != null) {
                                                    i = R.id.partNo;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partNo);
                                                    if (textView7 != null) {
                                                        i = R.id.serialNo;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo);
                                                        if (textView8 != null) {
                                                            i = R.id.state;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state);
                                                            if (textView9 != null) {
                                                                i = R.id.tv_asd;
                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_asd);
                                                                if (textView10 != null) {
                                                                    i = R.id.uncollectable_pending_sir;
                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uncollectable_pending_sir);
                                                                    if (textView11 != null) {
                                                                        i = R.id.viewDetails;
                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.viewDetails);
                                                                        if (textView12 != null) {
                                                                            return new AnomalyItemBinding((LinearLayout) rootView, textView, textView2, linearLayout, textView3, textView4, textView5, textView6, linearLayout2, linearLayout3, linearLayout4, linearLayout5, textView7, textView8, textView9, textView10, textView11, textView12);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
