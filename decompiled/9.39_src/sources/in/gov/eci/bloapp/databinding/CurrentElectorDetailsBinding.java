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
public final class CurrentElectorDetailsBinding implements ViewBinding {
    public final TextView agePendingSir;
    public final LinearLayout ccEf;
    public final TextView electorNamePendingSir;
    public final TextView epicPendingSir;
    public final TextView relativeNamePendingSir;
    public final TextView relativeTypePendingSir;
    private final LinearLayout rootView;
    public final TextView serialNoPendingSir;

    private CurrentElectorDetailsBinding(LinearLayout rootView, TextView agePendingSir, LinearLayout ccEf, TextView electorNamePendingSir, TextView epicPendingSir, TextView relativeNamePendingSir, TextView relativeTypePendingSir, TextView serialNoPendingSir) {
        this.rootView = rootView;
        this.agePendingSir = agePendingSir;
        this.ccEf = ccEf;
        this.electorNamePendingSir = electorNamePendingSir;
        this.epicPendingSir = epicPendingSir;
        this.relativeNamePendingSir = relativeNamePendingSir;
        this.relativeTypePendingSir = relativeTypePendingSir;
        this.serialNoPendingSir = serialNoPendingSir;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CurrentElectorDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CurrentElectorDetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.current_elector_details, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CurrentElectorDetailsBinding bind(View rootView) {
        int i = R.id.age_pending_sir;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.age_pending_sir);
        if (textView != null) {
            i = R.id.ccEf;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ccEf);
            if (linearLayout != null) {
                i = R.id.electorName_pending_sir;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName_pending_sir);
                if (textView2 != null) {
                    i = R.id.epic_pending_sir;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_pending_sir);
                    if (textView3 != null) {
                        i = R.id.relativeName_pending_sir;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relativeName_pending_sir);
                        if (textView4 != null) {
                            i = R.id.relativeType_pending_sir;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relativeType_pending_sir);
                            if (textView5 != null) {
                                i = R.id.serialNo_pending_sir;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_pending_sir);
                                if (textView6 != null) {
                                    return new CurrentElectorDetailsBinding((LinearLayout) rootView, textView, linearLayout, textView2, textView3, textView4, textView5, textView6);
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
