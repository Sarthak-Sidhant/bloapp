package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloTrackStatusRvItemBinding implements ViewBinding {
    public final TextView click;
    public final TextView epic;
    public final ImageView imageView;
    public final ConstraintLayout layout;
    private final ConstraintLayout rootView;
    public final TextView stage;
    public final View view1;

    private BloTrackStatusRvItemBinding(ConstraintLayout rootView, TextView click, TextView epic, ImageView imageView, ConstraintLayout layout, TextView stage, View view1) {
        this.rootView = rootView;
        this.click = click;
        this.epic = epic;
        this.imageView = imageView;
        this.layout = layout;
        this.stage = stage;
        this.view1 = view1;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloTrackStatusRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloTrackStatusRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_track_status_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloTrackStatusRvItemBinding bind(View rootView) {
        int i = R.id.click;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.click);
        if (textView != null) {
            i = R.id.epic;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic);
            if (textView2 != null) {
                i = R.id.imageView;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
                if (imageView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                    i = R.id.stage;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stage);
                    if (textView3 != null) {
                        i = R.id.view1;
                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                        if (viewFindChildViewById != null) {
                            return new BloTrackStatusRvItemBinding(constraintLayout, textView, textView2, imageView, constraintLayout, textView3, viewFindChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
