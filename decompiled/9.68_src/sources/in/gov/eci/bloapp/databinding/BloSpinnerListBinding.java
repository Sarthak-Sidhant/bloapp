package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.viewbinding.ViewBinding;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloSpinnerListBinding implements ViewBinding {
    private final CheckedTextView rootView;

    private BloSpinnerListBinding(CheckedTextView rootView) {
        this.rootView = rootView;
    }

    public CheckedTextView getRoot() {
        return this.rootView;
    }

    public static BloSpinnerListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloSpinnerListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_spinner_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloSpinnerListBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BloSpinnerListBinding((CheckedTextView) rootView);
    }
}
