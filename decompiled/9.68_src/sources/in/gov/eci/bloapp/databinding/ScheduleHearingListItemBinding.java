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
public final class ScheduleHearingListItemBinding implements ViewBinding {
    public final LinearLayout ccEf;
    public final TextView electorNamePendingSir;
    public final TextView epicPendingSir;
    private final LinearLayout rootView;
    public final TextView serialNoPendingSir;
    public final TextView uploadReceipt;

    private ScheduleHearingListItemBinding(LinearLayout rootView, LinearLayout ccEf, TextView electorNamePendingSir, TextView epicPendingSir, TextView serialNoPendingSir, TextView uploadReceipt) {
        this.rootView = rootView;
        this.ccEf = ccEf;
        this.electorNamePendingSir = electorNamePendingSir;
        this.epicPendingSir = epicPendingSir;
        this.serialNoPendingSir = serialNoPendingSir;
        this.uploadReceipt = uploadReceipt;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ScheduleHearingListItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ScheduleHearingListItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.schedule_hearing_list_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ScheduleHearingListItemBinding bind(View rootView) {
        int i = R.id.ccEf;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ccEf);
        if (linearLayout != null) {
            i = R.id.electorName_pending_sir;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName_pending_sir);
            if (textView != null) {
                i = R.id.epic_pending_sir;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_pending_sir);
                if (textView2 != null) {
                    i = R.id.serialNo_pending_sir;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_pending_sir);
                    if (textView3 != null) {
                        i = R.id.upload_receipt;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_receipt);
                        if (textView4 != null) {
                            return new ScheduleHearingListItemBinding((LinearLayout) rootView, linearLayout, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
