package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloCustomSpinnerBinding implements ViewBinding {
    public final ImageView imageView;
    private final LinearLayout rootView;
    public final TextView textView;

    private BloCustomSpinnerBinding(LinearLayout rootView, ImageView imageView, TextView textView) {
        this.rootView = rootView;
        this.imageView = imageView;
        this.textView = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloCustomSpinnerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloCustomSpinnerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_custom_spinner, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloCustomSpinnerBinding bind(View rootView) {
        int i = R.id.imageView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
        if (imageView != null) {
            i = R.id.textView;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView);
            if (textView != null) {
                return new BloCustomSpinnerBinding((LinearLayout) rootView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
