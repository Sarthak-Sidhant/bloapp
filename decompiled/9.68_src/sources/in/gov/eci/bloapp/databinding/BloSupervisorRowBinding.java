package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloSupervisorRowBinding implements ViewBinding {
    public final TextView acName;
    public final TextView address;
    public final RelativeLayout callIcon;
    public final CardView cardLayout;
    public final LinearLayout cardViewLL;
    public final TextView categoryTypeLabel;
    public final TextView electorName;
    public final TextView epic;
    public final LinearLayout llAddress;
    public final LinearLayout lvCategoryType;
    public final TextView partNo;
    private final LinearLayout rootView;
    public final TextView state;
    public final TextView tvLableAddress;
    public final TextView uncollectablePendingSir;
    public final TextView viewDetails;

    private BloSupervisorRowBinding(LinearLayout rootView, TextView acName, TextView address, RelativeLayout callIcon, CardView cardLayout, LinearLayout cardViewLL, TextView categoryTypeLabel, TextView electorName, TextView epic, LinearLayout llAddress, LinearLayout lvCategoryType, TextView partNo, TextView state, TextView tvLableAddress, TextView uncollectablePendingSir, TextView viewDetails) {
        this.rootView = rootView;
        this.acName = acName;
        this.address = address;
        this.callIcon = callIcon;
        this.cardLayout = cardLayout;
        this.cardViewLL = cardViewLL;
        this.categoryTypeLabel = categoryTypeLabel;
        this.electorName = electorName;
        this.epic = epic;
        this.llAddress = llAddress;
        this.lvCategoryType = lvCategoryType;
        this.partNo = partNo;
        this.state = state;
        this.tvLableAddress = tvLableAddress;
        this.uncollectablePendingSir = uncollectablePendingSir;
        this.viewDetails = viewDetails;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloSupervisorRowBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloSupervisorRowBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_supervisor_row, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloSupervisorRowBinding bind(View rootView) {
        int i = R.id.acName;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.acName);
        if (textView != null) {
            i = R.id.address;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address);
            if (textView2 != null) {
                i = R.id.callIcon;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.callIcon);
                if (relativeLayout != null) {
                    i = R.id.card_layout;
                    CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.card_layout);
                    if (cardViewFindChildViewById != null) {
                        i = R.id.cardViewLL;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cardViewLL);
                        if (linearLayout != null) {
                            i = R.id.category_type_label;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.category_type_label);
                            if (textView3 != null) {
                                i = R.id.electorName;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName);
                                if (textView4 != null) {
                                    i = R.id.epic;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic);
                                    if (textView5 != null) {
                                        i = R.id.llAddress;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llAddress);
                                        if (linearLayout2 != null) {
                                            i = R.id.lv_category_type;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_category_type);
                                            if (linearLayout3 != null) {
                                                i = R.id.partNo;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partNo);
                                                if (textView6 != null) {
                                                    i = R.id.state;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state);
                                                    if (textView7 != null) {
                                                        i = R.id.tv_lable_address;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_lable_address);
                                                        if (textView8 != null) {
                                                            i = R.id.uncollectable_pending_sir;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uncollectable_pending_sir);
                                                            if (textView9 != null) {
                                                                i = R.id.viewDetails;
                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.viewDetails);
                                                                if (textView10 != null) {
                                                                    return new BloSupervisorRowBinding((LinearLayout) rootView, textView, textView2, relativeLayout, cardViewFindChildViewById, linearLayout, textView3, textView4, textView5, linearLayout2, linearLayout3, textView6, textView7, textView8, textView9, textView10);
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
