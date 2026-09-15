package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ViewPrognyBinding implements ViewBinding {
    public final Button btncancel;
    private final LinearLayout rootView;
    public final TextView txtHeading;
    public final ListView viewProgenyListView;

    private ViewPrognyBinding(LinearLayout rootView, Button btncancel, TextView txtHeading, ListView viewProgenyListView) {
        this.rootView = rootView;
        this.btncancel = btncancel;
        this.txtHeading = txtHeading;
        this.viewProgenyListView = viewProgenyListView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewPrognyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ViewPrognyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.view_progny, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewPrognyBinding bind(View rootView) {
        int i = R.id.btncancel;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btncancel);
        if (button != null) {
            i = R.id.txtHeading;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtHeading);
            if (textView != null) {
                i = R.id.viewProgenyListView;
                ListView listView = (ListView) ViewBindings.findChildViewById(rootView, R.id.viewProgenyListView);
                if (listView != null) {
                    return new ViewPrognyBinding((LinearLayout) rootView, button, textView, listView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
