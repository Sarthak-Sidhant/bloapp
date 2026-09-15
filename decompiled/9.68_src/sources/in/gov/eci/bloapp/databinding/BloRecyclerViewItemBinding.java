package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloRecyclerViewItemBinding implements ViewBinding {
    public final RelativeLayout button;
    public final TextView date;
    public final TextView delete;
    public final TextView edit;
    public final LinearLayout layout;
    public final TextView name;
    private final ConstraintLayout rootView;
    public final TextView time;

    private BloRecyclerViewItemBinding(ConstraintLayout rootView, RelativeLayout button, TextView date, TextView delete, TextView edit, LinearLayout layout, TextView name, TextView time) {
        this.rootView = rootView;
        this.button = button;
        this.date = date;
        this.delete = delete;
        this.edit = edit;
        this.layout = layout;
        this.name = name;
        this.time = time;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloRecyclerViewItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloRecyclerViewItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_recycler_view_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloRecyclerViewItemBinding bind(View rootView) {
        int i = R.id.button;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.button);
        if (relativeLayout != null) {
            i = R.id.date;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.date);
            if (textView != null) {
                i = R.id.delete;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
                if (textView2 != null) {
                    i = R.id.edit;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.edit);
                    if (textView3 != null) {
                        i = 2131364428;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, 2131364428);
                        if (linearLayout != null) {
                            i = R.id.name;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name);
                            if (textView4 != null) {
                                i = 2131366419;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, 2131366419);
                                if (textView5 != null) {
                                    return new BloRecyclerViewItemBinding((ConstraintLayout) rootView, relativeLayout, textView, textView2, textView3, linearLayout, textView4, textView5);
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
