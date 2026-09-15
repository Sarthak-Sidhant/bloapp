package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class SirOfflineListBinding implements ViewBinding {
    public final LinearLayout cardOfflineDetails;
    public final TextView epicOfflineSir;
    public final TextView failureReasonOfflineSir;
    public final TextView formStatusOfflineSir;
    public final LinearLayout lvDelete;
    public final LinearLayout lvReason;
    public final LinearLayout lvStatus;
    private final LinearLayout rootView;
    public final TextView serialNoOfflineSir;
    public final TextView tvDelete;

    private SirOfflineListBinding(LinearLayout rootView, LinearLayout cardOfflineDetails, TextView epicOfflineSir, TextView failureReasonOfflineSir, TextView formStatusOfflineSir, LinearLayout lvDelete, LinearLayout lvReason, LinearLayout lvStatus, TextView serialNoOfflineSir, TextView tvDelete) {
        this.rootView = rootView;
        this.cardOfflineDetails = cardOfflineDetails;
        this.epicOfflineSir = epicOfflineSir;
        this.failureReasonOfflineSir = failureReasonOfflineSir;
        this.formStatusOfflineSir = formStatusOfflineSir;
        this.lvDelete = lvDelete;
        this.lvReason = lvReason;
        this.lvStatus = lvStatus;
        this.serialNoOfflineSir = serialNoOfflineSir;
        this.tvDelete = tvDelete;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SirOfflineListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SirOfflineListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.sir_offline_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SirOfflineListBinding bind(View rootView) {
        int i = R.id.cardOfflineDetails;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cardOfflineDetails);
        if (linearLayout != null) {
            i = R.id.epic_offline_sir;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_offline_sir);
            if (textView != null) {
                i = R.id.failure_reason_offline_sir;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.failure_reason_offline_sir);
                if (textView2 != null) {
                    i = R.id.form_status_offline_sir;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_status_offline_sir);
                    if (textView3 != null) {
                        i = R.id.lv_delete;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_delete);
                        if (linearLayout2 != null) {
                            i = R.id.lv_reason;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_reason);
                            if (linearLayout3 != null) {
                                i = R.id.lv_status;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_status);
                                if (linearLayout4 != null) {
                                    i = R.id.serialNo_offline_sir;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_offline_sir);
                                    if (textView4 != null) {
                                        i = R.id.tv_delete;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_delete);
                                        if (textView5 != null) {
                                            return new SirOfflineListBinding((LinearLayout) rootView, linearLayout, textView, textView2, textView3, linearLayout2, linearLayout3, linearLayout4, textView4, textView5);
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
