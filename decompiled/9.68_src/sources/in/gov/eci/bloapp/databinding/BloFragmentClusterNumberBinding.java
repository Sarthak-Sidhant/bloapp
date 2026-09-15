package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentClusterNumberBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final TextView headTitle;
    public final TextView headerText;
    public final ImageView homeBtnIv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final RecyclerView houseDetailsRv;
    private final ConstraintLayout rootView;

    private BloFragmentClusterNumberBinding(ConstraintLayout rootView, ImageView backBtnIv, TextView headTitle, TextView headerText, ImageView homeBtnIv, ConstraintLayout homeFragmentTopConstraintLayout, RecyclerView houseDetailsRv) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.headTitle = headTitle;
        this.headerText = headerText;
        this.homeBtnIv = homeBtnIv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.houseDetailsRv = houseDetailsRv;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentClusterNumberBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentClusterNumberBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_cluster_number, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentClusterNumberBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.head_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.head_title);
            if (textView != null) {
                i = R.id.header_text;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.header_text);
                if (textView2 != null) {
                    i = R.id.home_btn_iv;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                    if (imageView2 != null) {
                        i = R.id.home_fragment_top_constraint_layout;
                        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                        if (constraintLayoutFindChildViewById != null) {
                            i = R.id.house_details_rv;
                            RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.house_details_rv);
                            if (recyclerViewFindChildViewById != null) {
                                return new BloFragmentClusterNumberBinding((ConstraintLayout) rootView, imageView, textView, textView2, imageView2, constraintLayoutFindChildViewById, recyclerViewFindChildViewById);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
