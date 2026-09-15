package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloDeletebottomfileBinding implements ViewBinding {
    public final TextView cancel;
    private final ConstraintLayout rootView;
    public final TextView yes;

    private BloDeletebottomfileBinding(ConstraintLayout rootView, TextView cancel, TextView yes) {
        this.rootView = rootView;
        this.cancel = cancel;
        this.yes = yes;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloDeletebottomfileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloDeletebottomfileBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_deletebottomfile, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloDeletebottomfileBinding bind(View rootView) {
        int i = R.id.cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cancel);
        if (textView != null) {
            i = R.id.yes;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.yes);
            if (textView2 != null) {
                return new BloDeletebottomfileBinding((ConstraintLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
