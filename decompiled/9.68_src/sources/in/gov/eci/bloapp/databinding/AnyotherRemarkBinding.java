package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class AnyotherRemarkBinding implements ViewBinding {
    public final EditText anyotherremark;
    public final LinearLayout remarkll;
    private final LinearLayout rootView;

    private AnyotherRemarkBinding(LinearLayout rootView, EditText anyotherremark, LinearLayout remarkll) {
        this.rootView = rootView;
        this.anyotherremark = anyotherremark;
        this.remarkll = remarkll;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AnyotherRemarkBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AnyotherRemarkBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.anyother_remark, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AnyotherRemarkBinding bind(View rootView) {
        int i = R.id.anyotherremark;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.anyotherremark);
        if (editText != null) {
            i = R.id.remarkll;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.remarkll);
            if (linearLayout != null) {
                return new AnyotherRemarkBinding((LinearLayout) rootView, editText, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
