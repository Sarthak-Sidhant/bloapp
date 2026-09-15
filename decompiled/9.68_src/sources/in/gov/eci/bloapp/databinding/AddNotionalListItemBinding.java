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
public final class AddNotionalListItemBinding implements ViewBinding {
    public final LinearLayout ccEf;
    public final TextView electorNamePendingSir;
    public final TextView epicPendingSir;
    public final TextView genderPendingSir;
    public final TextView houseNoAddNotional;
    public final TextView notionalHNo;
    public final TextView relationNamePendingSir;
    private final LinearLayout rootView;
    public final TextView serialNoPendingSir;
    public final TextView updateAddNotional;

    private AddNotionalListItemBinding(LinearLayout rootView, LinearLayout ccEf, TextView electorNamePendingSir, TextView epicPendingSir, TextView genderPendingSir, TextView houseNoAddNotional, TextView notionalHNo, TextView relationNamePendingSir, TextView serialNoPendingSir, TextView updateAddNotional) {
        this.rootView = rootView;
        this.ccEf = ccEf;
        this.electorNamePendingSir = electorNamePendingSir;
        this.epicPendingSir = epicPendingSir;
        this.genderPendingSir = genderPendingSir;
        this.houseNoAddNotional = houseNoAddNotional;
        this.notionalHNo = notionalHNo;
        this.relationNamePendingSir = relationNamePendingSir;
        this.serialNoPendingSir = serialNoPendingSir;
        this.updateAddNotional = updateAddNotional;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AddNotionalListItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AddNotionalListItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.add_notional_list_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AddNotionalListItemBinding bind(View rootView) {
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
                        i = R.id.houseNo_addNotional;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.houseNo_addNotional);
                        if (textView4 != null) {
                            i = R.id.notionalHNo;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notionalHNo);
                            if (textView5 != null) {
                                i = R.id.relationName_pending_sir;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relationName_pending_sir);
                                if (textView6 != null) {
                                    i = R.id.serialNo_pending_sir;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_pending_sir);
                                    if (textView7 != null) {
                                        i = R.id.updateAddNotional;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.updateAddNotional);
                                        if (textView8 != null) {
                                            return new AddNotionalListItemBinding((LinearLayout) rootView, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
