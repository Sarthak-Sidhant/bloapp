package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloCustomAlertDialogBinding implements ViewBinding {
    public final TextView alertTv;
    public final TextView okTv;
    private final ConstraintLayout rootView;

    private BloCustomAlertDialogBinding(ConstraintLayout rootView, TextView alertTv, TextView okTv) {
        this.rootView = rootView;
        this.alertTv = alertTv;
        this.okTv = okTv;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloCustomAlertDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloCustomAlertDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_custom_alert_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloCustomAlertDialogBinding bind(View rootView) {
        int i = R.id.alert_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.alert_tv);
        if (textView != null) {
            i = R.id.ok_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ok_tv);
            if (textView2 != null) {
                return new BloCustomAlertDialogBinding((ConstraintLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
