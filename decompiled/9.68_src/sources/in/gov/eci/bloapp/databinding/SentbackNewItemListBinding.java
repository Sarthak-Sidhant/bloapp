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
public final class SentbackNewItemListBinding implements ViewBinding {
    public final TextView electorNamePendingSir;
    public final TextView epicPendingSir;
    public final TextView fillPendingSir;
    public final TextView remarks;
    private final LinearLayout rootView;
    public final TextView serialNoPendingSir;
    public final TextView uncollectablePendingSir;

    private SentbackNewItemListBinding(LinearLayout rootView, TextView electorNamePendingSir, TextView epicPendingSir, TextView fillPendingSir, TextView remarks, TextView serialNoPendingSir, TextView uncollectablePendingSir) {
        this.rootView = rootView;
        this.electorNamePendingSir = electorNamePendingSir;
        this.epicPendingSir = epicPendingSir;
        this.fillPendingSir = fillPendingSir;
        this.remarks = remarks;
        this.serialNoPendingSir = serialNoPendingSir;
        this.uncollectablePendingSir = uncollectablePendingSir;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SentbackNewItemListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SentbackNewItemListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.sentback_new_item_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SentbackNewItemListBinding bind(View rootView) {
        int i = R.id.electorName_pending_sir;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName_pending_sir);
        if (textView != null) {
            i = R.id.epic_pending_sir;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_pending_sir);
            if (textView2 != null) {
                i = R.id.fill_pending_sir;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fill_pending_sir);
                if (textView3 != null) {
                    i = R.id.remarks;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remarks);
                    if (textView4 != null) {
                        i = R.id.serialNo_pending_sir;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_pending_sir);
                        if (textView5 != null) {
                            i = R.id.uncollectable_pending_sir;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uncollectable_pending_sir);
                            if (textView6 != null) {
                                return new SentbackNewItemListBinding((LinearLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
