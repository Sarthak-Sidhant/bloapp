package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloSpinnerDropdownNewBinding implements ViewBinding {
    private final TextView rootView;

    private BloSpinnerDropdownNewBinding(TextView rootView) {
        this.rootView = rootView;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static BloSpinnerDropdownNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloSpinnerDropdownNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_spinner_dropdown_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloSpinnerDropdownNewBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BloSpinnerDropdownNewBinding((TextView) rootView);
    }
}
