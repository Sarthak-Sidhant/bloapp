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

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloNavHeaderMainBinding implements ViewBinding {
    public final View dividerLineView;
    public final ImageView imageView;
    private final LinearLayout rootView;
    public final TextView textView;
    public final TextView textView2;

    private BloNavHeaderMainBinding(LinearLayout rootView, View dividerLineView, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = rootView;
        this.dividerLineView = dividerLineView;
        this.imageView = imageView;
        this.textView = textView;
        this.textView2 = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloNavHeaderMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloNavHeaderMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_nav_header_main, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloNavHeaderMainBinding bind(View rootView) {
        int i = R.id.dividerLineView;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.dividerLineView);
        if (viewFindChildViewById != null) {
            i = R.id.imageView;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
            if (imageView != null) {
                i = R.id.textView;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView);
                if (textView != null) {
                    i = R.id.textView2;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView2);
                    if (textView2 != null) {
                        return new BloNavHeaderMainBinding((LinearLayout) rootView, viewFindChildViewById, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
