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
public final class UncollectedDocumentItemBinding implements ViewBinding {
    public final TextView electorNamePendingSir;
    public final TextView epicPendingSir;
    public final TextView fillPendingSir;
    public final LinearLayout pendingLL;
    private final LinearLayout rootView;
    public final TextView serialNoPendingSir;
    public final TextView uncollectablePendingSir;

    private UncollectedDocumentItemBinding(LinearLayout rootView, TextView electorNamePendingSir, TextView epicPendingSir, TextView fillPendingSir, LinearLayout pendingLL, TextView serialNoPendingSir, TextView uncollectablePendingSir) {
        this.rootView = rootView;
        this.electorNamePendingSir = electorNamePendingSir;
        this.epicPendingSir = epicPendingSir;
        this.fillPendingSir = fillPendingSir;
        this.pendingLL = pendingLL;
        this.serialNoPendingSir = serialNoPendingSir;
        this.uncollectablePendingSir = uncollectablePendingSir;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UncollectedDocumentItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static UncollectedDocumentItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.uncollected_document_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static UncollectedDocumentItemBinding bind(View rootView) {
        int i = R.id.electorName_pending_sir;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName_pending_sir);
        if (textView != null) {
            i = R.id.epic_pending_sir;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_pending_sir);
            if (textView2 != null) {
                i = R.id.fill_pending_sir;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fill_pending_sir);
                if (textView3 != null) {
                    i = R.id.pendingLL;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pendingLL);
                    if (linearLayout != null) {
                        i = R.id.serialNo_pending_sir;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_pending_sir);
                        if (textView4 != null) {
                            i = R.id.uncollectable_pending_sir;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uncollectable_pending_sir);
                            if (textView5 != null) {
                                return new UncollectedDocumentItemBinding((LinearLayout) rootView, textView, textView2, textView3, linearLayout, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
