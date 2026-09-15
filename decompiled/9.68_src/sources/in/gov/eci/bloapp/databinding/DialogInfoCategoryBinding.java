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
public final class DialogInfoCategoryBinding implements ViewBinding {
    public final ImageView crossButton;
    public final TextView note1;
    public final TextView note2;
    public final TextView note3;
    public final TextView note4;
    public final TextView note6;
    private final LinearLayout rootView;

    private DialogInfoCategoryBinding(LinearLayout rootView, ImageView crossButton, TextView note1, TextView note2, TextView note3, TextView note4, TextView note6) {
        this.rootView = rootView;
        this.crossButton = crossButton;
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
        this.note4 = note4;
        this.note6 = note6;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogInfoCategoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogInfoCategoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_info_category, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogInfoCategoryBinding bind(View rootView) {
        int i = R.id.cross_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cross_button);
        if (imageView != null) {
            i = R.id.note1;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.note1);
            if (textView != null) {
                i = R.id.note2;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.note2);
                if (textView2 != null) {
                    i = R.id.note3;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.note3);
                    if (textView3 != null) {
                        i = R.id.note4;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.note4);
                        if (textView4 != null) {
                            i = R.id.note6;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.note6);
                            if (textView5 != null) {
                                return new DialogInfoCategoryBinding((LinearLayout) rootView, imageView, textView, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
