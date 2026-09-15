package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class SingleRowFormDataBinding implements ViewBinding {
    public final TextView acName;
    public final TextView address;
    public final CardView cardLayout;
    public final LinearLayout cardViewLL;
    public final TextView categoryTypeLabel;
    public final TextView electorName;
    public final TextView epic;
    public final LinearLayout llAddress;
    public final LinearLayout lvCategoryType;
    public final TextView partNo;
    private final LinearLayout rootView;
    public final TextView serialNo;
    public final TextView state;
    public final TextView tvLableAddress;
    public final TextView uncollectablePendingSir;
    public final TextView viewDetails;

    private SingleRowFormDataBinding(LinearLayout rootView, TextView acName, TextView address, CardView cardLayout, LinearLayout cardViewLL, TextView categoryTypeLabel, TextView electorName, TextView epic, LinearLayout llAddress, LinearLayout lvCategoryType, TextView partNo, TextView serialNo, TextView state, TextView tvLableAddress, TextView uncollectablePendingSir, TextView viewDetails) {
        this.rootView = rootView;
        this.acName = acName;
        this.address = address;
        this.cardLayout = cardLayout;
        this.cardViewLL = cardViewLL;
        this.categoryTypeLabel = categoryTypeLabel;
        this.electorName = electorName;
        this.epic = epic;
        this.llAddress = llAddress;
        this.lvCategoryType = lvCategoryType;
        this.partNo = partNo;
        this.serialNo = serialNo;
        this.state = state;
        this.tvLableAddress = tvLableAddress;
        this.uncollectablePendingSir = uncollectablePendingSir;
        this.viewDetails = viewDetails;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SingleRowFormDataBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleRowFormDataBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_row_form_data, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleRowFormDataBinding bind(View rootView) {
        int i = R.id.acName;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.acName);
        if (textView != null) {
            i = R.id.address;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address);
            if (textView2 != null) {
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
                                                i = R.id.serialNo;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo);
                                                if (textView7 != null) {
                                                    i = R.id.state;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state);
                                                    if (textView8 != null) {
                                                        i = R.id.tv_lable_address;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_lable_address);
                                                        if (textView9 != null) {
                                                            i = R.id.uncollectable_pending_sir;
                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uncollectable_pending_sir);
                                                            if (textView10 != null) {
                                                                i = R.id.viewDetails;
                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.viewDetails);
                                                                if (textView11 != null) {
                                                                    return new SingleRowFormDataBinding((LinearLayout) rootView, textView, textView2, cardViewFindChildViewById, linearLayout, textView3, textView4, textView5, linearLayout2, linearLayout3, textView6, textView7, textView8, textView9, textView10, textView11);
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
