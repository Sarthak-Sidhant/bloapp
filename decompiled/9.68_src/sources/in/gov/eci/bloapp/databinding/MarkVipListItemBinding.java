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
public final class MarkVipListItemBinding implements ViewBinding {
    public final LinearLayout ccEf;
    public final TextView electorNamePendingSir;
    public final TextView epicPendingSir;
    public final TextView genderPendingSir;
    public final TextView markVip;
    public final TextView relationNamePendingSir;
    private final LinearLayout rootView;
    public final TextView serialNoPendingSir;

    private MarkVipListItemBinding(LinearLayout rootView, LinearLayout ccEf, TextView electorNamePendingSir, TextView epicPendingSir, TextView genderPendingSir, TextView markVip, TextView relationNamePendingSir, TextView serialNoPendingSir) {
        this.rootView = rootView;
        this.ccEf = ccEf;
        this.electorNamePendingSir = electorNamePendingSir;
        this.epicPendingSir = epicPendingSir;
        this.genderPendingSir = genderPendingSir;
        this.markVip = markVip;
        this.relationNamePendingSir = relationNamePendingSir;
        this.serialNoPendingSir = serialNoPendingSir;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MarkVipListItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MarkVipListItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.mark_vip_list_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MarkVipListItemBinding bind(View rootView) {
        int i = R.id.ccEf;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ccEf);
        if (linearLayout != null) {
            i = R.id.electorName_pending_sir;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName_pending_sir);
            if (textView != null) {
                i = R.id.epic_pending_sir;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_pending_sir);
                if (textView2 != null) {
                    i = R.id.gender_pending_sir;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender_pending_sir);
                    if (textView3 != null) {
                        i = R.id.mark_vip;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mark_vip);
                        if (textView4 != null) {
                            i = R.id.relationName_pending_sir;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relationName_pending_sir);
                            if (textView5 != null) {
                                i = R.id.serialNo_pending_sir;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_pending_sir);
                                if (textView6 != null) {
                                    return new MarkVipListItemBinding((LinearLayout) rootView, linearLayout, textView, textView2, textView3, textView4, textView5, textView6);
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
