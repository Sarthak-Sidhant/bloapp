package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentElegibleElectorListBinding implements ViewBinding {
    public final RecyclerView allAppsRv;
    public final ImageView backBtnIv;
    public final ImageView homeBtnIv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final LinearLayout homerefreshlayout;
    private final LinearLayout rootView;
    public final TextView textView3;

    private BloFragmentElegibleElectorListBinding(LinearLayout rootView, RecyclerView allAppsRv, ImageView backBtnIv, ImageView homeBtnIv, ConstraintLayout homeFragmentTopConstraintLayout, LinearLayout homerefreshlayout, TextView textView3) {
        this.rootView = rootView;
        this.allAppsRv = allAppsRv;
        this.backBtnIv = backBtnIv;
        this.homeBtnIv = homeBtnIv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.homerefreshlayout = homerefreshlayout;
        this.textView3 = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentElegibleElectorListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentElegibleElectorListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_elegible_elector_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentElegibleElectorListBinding bind(View rootView) {
        int i = R.id.all_apps_rv;
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.all_apps_rv);
        if (recyclerViewFindChildViewById != null) {
            i = R.id.back_btn_iv;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
            if (imageView != null) {
                i = R.id.home_btn_iv;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                if (imageView2 != null) {
                    i = R.id.home_fragment_top_constraint_layout;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                    if (constraintLayoutFindChildViewById != null) {
                        LinearLayout linearLayout = (LinearLayout) rootView;
                        i = R.id.textView3;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                        if (textView != null) {
                            return new BloFragmentElegibleElectorListBinding(linearLayout, recyclerViewFindChildViewById, imageView, imageView2, constraintLayoutFindChildViewById, linearLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
