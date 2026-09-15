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
public final class PendingListSirItemsBinding implements ViewBinding {
    public final TextView call;
    public final TextView electorNamePendingSir;
    public final LinearLayout epicMatchedPending;
    public final TextView epicMatchedTv;
    public final TextView epicPendingSir;
    public final TextView fillPendingSir;
    public final LinearLayout pendingLL;
    private final LinearLayout rootView;
    public final TextView serialNoPendingSir;
    public final TextView uncollectablePendingSir;

    private PendingListSirItemsBinding(LinearLayout rootView, TextView call, TextView electorNamePendingSir, LinearLayout epicMatchedPending, TextView epicMatchedTv, TextView epicPendingSir, TextView fillPendingSir, LinearLayout pendingLL, TextView serialNoPendingSir, TextView uncollectablePendingSir) {
        this.rootView = rootView;
        this.call = call;
        this.electorNamePendingSir = electorNamePendingSir;
        this.epicMatchedPending = epicMatchedPending;
        this.epicMatchedTv = epicMatchedTv;
        this.epicPendingSir = epicPendingSir;
        this.fillPendingSir = fillPendingSir;
        this.pendingLL = pendingLL;
        this.serialNoPendingSir = serialNoPendingSir;
        this.uncollectablePendingSir = uncollectablePendingSir;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PendingListSirItemsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PendingListSirItemsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.pending_list_sir_items, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PendingListSirItemsBinding bind(View rootView) {
        int i = R.id.call;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.call);
        if (textView != null) {
            i = R.id.electorName_pending_sir;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName_pending_sir);
            if (textView2 != null) {
                i = R.id.epicMatchedPending;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.epicMatchedPending);
                if (linearLayout != null) {
                    i = R.id.epicMatchedTv;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epicMatchedTv);
                    if (textView3 != null) {
                        i = R.id.epic_pending_sir;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_pending_sir);
                        if (textView4 != null) {
                            i = R.id.fill_pending_sir;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fill_pending_sir);
                            if (textView5 != null) {
                                i = R.id.pendingLL;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pendingLL);
                                if (linearLayout2 != null) {
                                    i = R.id.serialNo_pending_sir;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_pending_sir);
                                    if (textView6 != null) {
                                        i = R.id.uncollectable_pending_sir;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uncollectable_pending_sir);
                                        if (textView7 != null) {
                                            return new PendingListSirItemsBinding((LinearLayout) rootView, textView, textView2, linearLayout, textView3, textView4, textView5, linearLayout2, textView6, textView7);
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
