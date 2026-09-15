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
public final class ViewPrognyListItemBinding implements ViewBinding {
    public final ImageView ivDelete;
    private final LinearLayout rootView;
    public final TextView tvProgenyEpic;

    private ViewPrognyListItemBinding(LinearLayout rootView, ImageView ivDelete, TextView tvProgenyEpic) {
        this.rootView = rootView;
        this.ivDelete = ivDelete;
        this.tvProgenyEpic = tvProgenyEpic;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewPrognyListItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ViewPrognyListItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.view_progny_list_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewPrognyListItemBinding bind(View rootView) {
        int i = R.id.ivDelete;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivDelete);
        if (imageView != null) {
            i = R.id.tvProgenyEpic;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvProgenyEpic);
            if (textView != null) {
                return new ViewPrognyListItemBinding((LinearLayout) rootView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
