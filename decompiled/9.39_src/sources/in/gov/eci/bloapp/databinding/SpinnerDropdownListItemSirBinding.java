package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class SpinnerDropdownListItemSirBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView spinnerItemTextSIR;

    private SpinnerDropdownListItemSirBinding(TextView rootView, TextView spinnerItemTextSIR) {
        this.rootView = rootView;
        this.spinnerItemTextSIR = spinnerItemTextSIR;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static SpinnerDropdownListItemSirBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SpinnerDropdownListItemSirBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.spinner_dropdown_list_item_sir, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SpinnerDropdownListItemSirBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) rootView;
        return new SpinnerDropdownListItemSirBinding(textView, textView);
    }
}
