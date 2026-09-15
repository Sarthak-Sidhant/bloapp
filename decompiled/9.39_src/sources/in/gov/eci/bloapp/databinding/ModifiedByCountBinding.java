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
public final class ModifiedByCountBinding implements ViewBinding {
    public final TextView note1;
    public final TextView note2;
    public final TextView note3;
    public final TextView noteTotal;
    private final LinearLayout rootView;

    private ModifiedByCountBinding(LinearLayout rootView, TextView note1, TextView note2, TextView note3, TextView noteTotal) {
        this.rootView = rootView;
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
        this.noteTotal = noteTotal;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ModifiedByCountBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ModifiedByCountBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.modified_by_count, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ModifiedByCountBinding bind(View rootView) {
        int i = R.id.note1;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.note1);
        if (textView != null) {
            i = R.id.note2;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.note2);
            if (textView2 != null) {
                i = R.id.note3;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.note3);
                if (textView3 != null) {
                    i = R.id.noteTotal;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.noteTotal);
                    if (textView4 != null) {
                        return new ModifiedByCountBinding((LinearLayout) rootView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
