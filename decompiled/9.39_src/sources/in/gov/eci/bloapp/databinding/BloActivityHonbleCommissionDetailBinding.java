package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloActivityHonbleCommissionDetailBinding implements ViewBinding {
    public final ImageView back;
    public final ImageView commissionImage;
    public final LinearLayout honbleCommissionDetailMainLayout;
    public final NestedScrollView mainScrollView;
    private final LinearLayout rootView;
    public final TextView textViewCommissionDescription;
    public final TextView textViewCommissionName;
    public final TextView title;
    public final ConstraintLayout titleBar;

    private BloActivityHonbleCommissionDetailBinding(LinearLayout rootView, ImageView back, ImageView commissionImage, LinearLayout honbleCommissionDetailMainLayout, NestedScrollView mainScrollView, TextView textViewCommissionDescription, TextView textViewCommissionName, TextView title, ConstraintLayout titleBar) {
        this.rootView = rootView;
        this.back = back;
        this.commissionImage = commissionImage;
        this.honbleCommissionDetailMainLayout = honbleCommissionDetailMainLayout;
        this.mainScrollView = mainScrollView;
        this.textViewCommissionDescription = textViewCommissionDescription;
        this.textViewCommissionName = textViewCommissionName;
        this.title = title;
        this.titleBar = titleBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityHonbleCommissionDetailBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityHonbleCommissionDetailBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_honble_commission_detail, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityHonbleCommissionDetailBinding bind(View rootView) {
        int i = 2131362452;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131362452);
        if (imageView != null) {
            i = R.id.commission_image;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.commission_image);
            if (imageView2 != null) {
                LinearLayout linearLayout = (LinearLayout) rootView;
                i = R.id.mainScrollView;
                NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.mainScrollView);
                if (nestedScrollViewFindChildViewById != null) {
                    i = R.id.textView_commission_description;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_commission_description);
                    if (textView != null) {
                        i = R.id.textView_commission_name;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_commission_name);
                        if (textView2 != null) {
                            i = 2131366197;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, 2131366197);
                            if (textView3 != null) {
                                i = R.id.titleBar;
                                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.titleBar);
                                if (constraintLayoutFindChildViewById != null) {
                                    return new BloActivityHonbleCommissionDetailBinding(linearLayout, imageView, imageView2, linearLayout, nestedScrollViewFindChildViewById, textView, textView2, textView3, constraintLayoutFindChildViewById);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
