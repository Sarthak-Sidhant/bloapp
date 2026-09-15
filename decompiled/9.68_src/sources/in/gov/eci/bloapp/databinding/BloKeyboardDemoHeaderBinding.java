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
public final class BloKeyboardDemoHeaderBinding implements ViewBinding {
    public final ImageView ivClose;
    private final LinearLayout rootView;
    public final TextView text;
    public final TextView text1;
    public final TextView text3;

    private BloKeyboardDemoHeaderBinding(LinearLayout rootView, ImageView ivClose, TextView text, TextView text1, TextView text3) {
        this.rootView = rootView;
        this.ivClose = ivClose;
        this.text = text;
        this.text1 = text1;
        this.text3 = text3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloKeyboardDemoHeaderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloKeyboardDemoHeaderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_keyboard_demo_header, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloKeyboardDemoHeaderBinding bind(View rootView) {
        int i = R.id.ivClose;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivClose);
        if (imageView != null) {
            i = 2131366254;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, 2131366254);
            if (textView != null) {
                i = R.id.text1;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.text1);
                if (textView2 != null) {
                    i = R.id.text3;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.text3);
                    if (textView3 != null) {
                        return new BloKeyboardDemoHeaderBinding((LinearLayout) rootView, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
