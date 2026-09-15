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
public final class UncollectedefListSirItemsBhBinding implements ViewBinding {
    public final TextView electorNamePendingSir;
    public final TextView epicPendingSir;
    private final LinearLayout rootView;
    public final TextView serialNoPendingSir;
    public final TextView uncollectabledefDoc;

    private UncollectedefListSirItemsBhBinding(LinearLayout rootView, TextView electorNamePendingSir, TextView epicPendingSir, TextView serialNoPendingSir, TextView uncollectabledefDoc) {
        this.rootView = rootView;
        this.electorNamePendingSir = electorNamePendingSir;
        this.epicPendingSir = epicPendingSir;
        this.serialNoPendingSir = serialNoPendingSir;
        this.uncollectabledefDoc = uncollectabledefDoc;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UncollectedefListSirItemsBhBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static UncollectedefListSirItemsBhBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.uncollectedef_list_sir_items_bh, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static UncollectedefListSirItemsBhBinding bind(View rootView) {
        int i = R.id.electorName_pending_sir;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName_pending_sir);
        if (textView != null) {
            i = R.id.epic_pending_sir;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_pending_sir);
            if (textView2 != null) {
                i = R.id.serialNo_pending_sir;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_pending_sir);
                if (textView3 != null) {
                    i = R.id.uncollectabledef_doc;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uncollectabledef_doc);
                    if (textView4 != null) {
                        return new UncollectedefListSirItemsBhBinding((LinearLayout) rootView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
