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
public final class AboutHonbleCommissionRvItemsBinding implements ViewBinding {
    public final ImageView commissionImage;
    public final LinearLayout commissionRvRoot;
    private final LinearLayout rootView;
    public final TextView textViewDesignation;
    public final TextView textViewName;
    public final TextView textViewReadMore;

    private AboutHonbleCommissionRvItemsBinding(LinearLayout rootView, ImageView commissionImage, LinearLayout commissionRvRoot, TextView textViewDesignation, TextView textViewName, TextView textViewReadMore) {
        this.rootView = rootView;
        this.commissionImage = commissionImage;
        this.commissionRvRoot = commissionRvRoot;
        this.textViewDesignation = textViewDesignation;
        this.textViewName = textViewName;
        this.textViewReadMore = textViewReadMore;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AboutHonbleCommissionRvItemsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AboutHonbleCommissionRvItemsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.about_honble_commission_rv_items, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AboutHonbleCommissionRvItemsBinding bind(View rootView) {
        int i = R.id.commission_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.commission_image);
        if (imageView != null) {
            i = R.id.commission_rv_root;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.commission_rv_root);
            if (linearLayout != null) {
                i = R.id.textView_designation;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_designation);
                if (textView != null) {
                    i = R.id.textView_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_name);
                    if (textView2 != null) {
                        i = R.id.textView_read_more;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_read_more);
                        if (textView3 != null) {
                            return new AboutHonbleCommissionRvItemsBinding((LinearLayout) rootView, imageView, linearLayout, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
