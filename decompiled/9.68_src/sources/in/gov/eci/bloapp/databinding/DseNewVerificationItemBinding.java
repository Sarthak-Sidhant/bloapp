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
public final class DseNewVerificationItemBinding implements ViewBinding {
    public final TextView acName;
    public final TextView address;
    public final LinearLayout cardViewLL;
    public final TextView categoryTypeLabel;
    public final TextView dseForm7Already;
    public final TextView electorName;
    public final TextView epic;
    public final TextView fillFormDseVerified;
    public final LinearLayout llDeceased;
    public final LinearLayout lvAsd;
    public final LinearLayout lvCluster;
    public final LinearLayout lvEightfive;
    public final TextView noAction;
    public final TextView partNo;
    private final LinearLayout rootView;
    public final TextView serialNo;
    public final TextView state;
    public final TextView tvAsd;
    public final TextView tvClusterid;
    public final TextView viewDetailsElector;

    private DseNewVerificationItemBinding(LinearLayout rootView, TextView acName, TextView address, LinearLayout cardViewLL, TextView categoryTypeLabel, TextView dseForm7Already, TextView electorName, TextView epic, TextView fillFormDseVerified, LinearLayout llDeceased, LinearLayout lvAsd, LinearLayout lvCluster, LinearLayout lvEightfive, TextView noAction, TextView partNo, TextView serialNo, TextView state, TextView tvAsd, TextView tvClusterid, TextView viewDetailsElector) {
        this.rootView = rootView;
        this.acName = acName;
        this.address = address;
        this.cardViewLL = cardViewLL;
        this.categoryTypeLabel = categoryTypeLabel;
        this.dseForm7Already = dseForm7Already;
        this.electorName = electorName;
        this.epic = epic;
        this.fillFormDseVerified = fillFormDseVerified;
        this.llDeceased = llDeceased;
        this.lvAsd = lvAsd;
        this.lvCluster = lvCluster;
        this.lvEightfive = lvEightfive;
        this.noAction = noAction;
        this.partNo = partNo;
        this.serialNo = serialNo;
        this.state = state;
        this.tvAsd = tvAsd;
        this.tvClusterid = tvClusterid;
        this.viewDetailsElector = viewDetailsElector;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DseNewVerificationItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DseNewVerificationItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dse_new_verification_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DseNewVerificationItemBinding bind(View rootView) {
        int i = R.id.acName;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.acName);
        if (textView != null) {
            i = R.id.address;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address);
            if (textView2 != null) {
                i = R.id.cardViewLL;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cardViewLL);
                if (linearLayout != null) {
                    i = R.id.category_type_label;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.category_type_label);
                    if (textView3 != null) {
                        i = R.id.dseForm7Already;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dseForm7Already);
                        if (textView4 != null) {
                            i = R.id.electorName;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName);
                            if (textView5 != null) {
                                i = R.id.epic;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic);
                                if (textView6 != null) {
                                    i = R.id.fill_form_dseVerified;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fill_form_dseVerified);
                                    if (textView7 != null) {
                                        i = R.id.ll_deceased;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_deceased);
                                        if (linearLayout2 != null) {
                                            i = R.id.lv_asd;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_asd);
                                            if (linearLayout3 != null) {
                                                i = R.id.lv_cluster;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_cluster);
                                                if (linearLayout4 != null) {
                                                    i = R.id.lv_eightfive;
                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_eightfive);
                                                    if (linearLayout5 != null) {
                                                        i = R.id.noAction;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.noAction);
                                                        if (textView8 != null) {
                                                            i = R.id.partNo;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partNo);
                                                            if (textView9 != null) {
                                                                i = R.id.serialNo;
                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo);
                                                                if (textView10 != null) {
                                                                    i = R.id.state;
                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state);
                                                                    if (textView11 != null) {
                                                                        i = R.id.tv_asd;
                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_asd);
                                                                        if (textView12 != null) {
                                                                            i = R.id.tv_clusterid;
                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_clusterid);
                                                                            if (textView13 != null) {
                                                                                i = R.id.view_details_elector;
                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.view_details_elector);
                                                                                if (textView14 != null) {
                                                                                    return new DseNewVerificationItemBinding((LinearLayout) rootView, textView, textView2, linearLayout, textView3, textView4, textView5, textView6, textView7, linearLayout2, linearLayout3, linearLayout4, linearLayout5, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
