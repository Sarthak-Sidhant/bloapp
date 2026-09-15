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
public final class DialogSelectphotoAlertBinding implements ViewBinding {
    public final TextView fillYes;
    public final ImageView ivCancel;
    private final LinearLayout rootView;
    public final TextView tvNoAction;
    public final TextView tvWrongCate;

    private DialogSelectphotoAlertBinding(LinearLayout rootView, TextView fillYes, ImageView ivCancel, TextView tvNoAction, TextView tvWrongCate) {
        this.rootView = rootView;
        this.fillYes = fillYes;
        this.ivCancel = ivCancel;
        this.tvNoAction = tvNoAction;
        this.tvWrongCate = tvWrongCate;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogSelectphotoAlertBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogSelectphotoAlertBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_selectphoto_alert, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogSelectphotoAlertBinding bind(View rootView) {
        int i = R.id.fill_yes;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.fill_yes);
        if (textView != null) {
            i = R.id.iv_cancel;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_cancel);
            if (imageView != null) {
                i = R.id.tv_noAction;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_noAction);
                if (textView2 != null) {
                    i = R.id.tv_wrongCate;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_wrongCate);
                    if (textView3 != null) {
                        return new DialogSelectphotoAlertBinding((LinearLayout) rootView, textView, imageView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
