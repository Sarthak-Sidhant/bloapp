package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ViewNotionalHouseBinding implements ViewBinding {
    public final Button btnUpdate;
    public final Button btncancel;
    public final LinearLayout lvNotionalHouse;
    private final LinearLayout rootView;
    public final TextView tvN;
    public final EditText tvNotionalHNo;
    public final TextView txtHeading;

    private ViewNotionalHouseBinding(LinearLayout rootView, Button btnUpdate, Button btncancel, LinearLayout lvNotionalHouse, TextView tvN, EditText tvNotionalHNo, TextView txtHeading) {
        this.rootView = rootView;
        this.btnUpdate = btnUpdate;
        this.btncancel = btncancel;
        this.lvNotionalHouse = lvNotionalHouse;
        this.tvN = tvN;
        this.tvNotionalHNo = tvNotionalHNo;
        this.txtHeading = txtHeading;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewNotionalHouseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ViewNotionalHouseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.view_notional_house, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewNotionalHouseBinding bind(View rootView) {
        int i = R.id.btnUpdate;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btnUpdate);
        if (button != null) {
            i = R.id.btncancel;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btncancel);
            if (button2 != null) {
                i = R.id.lv_NotionalHouse;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_NotionalHouse);
                if (linearLayout != null) {
                    i = R.id.tvN;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvN);
                    if (textView != null) {
                        i = R.id.tv_notional_hNo;
                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.tv_notional_hNo);
                        if (editText != null) {
                            i = R.id.txtHeading;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtHeading);
                            if (textView2 != null) {
                                return new ViewNotionalHouseBinding((LinearLayout) rootView, button, button2, linearLayout, textView, editText, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
