package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentTrackStatusMain2Binding implements ViewBinding {
    public final ImageView backBtnIv;
    public final View divider1;
    public final ImageView homeBtnIv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    private final ConstraintLayout rootView;
    public final TabLayout tabLayout;
    public final TextView textView3;
    public final ViewPager2 viewPager;

    private BloFragmentTrackStatusMain2Binding(ConstraintLayout rootView, ImageView backBtnIv, View divider1, ImageView homeBtnIv, ConstraintLayout homeFragmentTopConstraintLayout, TabLayout tabLayout, TextView textView3, ViewPager2 viewPager) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.divider1 = divider1;
        this.homeBtnIv = homeBtnIv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.tabLayout = tabLayout;
        this.textView3 = textView3;
        this.viewPager = viewPager;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentTrackStatusMain2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentTrackStatusMain2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_track_status_main2, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentTrackStatusMain2Binding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.divider1;
            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.divider1);
            if (viewFindChildViewById != null) {
                i = R.id.home_btn_iv;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                if (imageView2 != null) {
                    i = R.id.home_fragment_top_constraint_layout;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                    if (constraintLayoutFindChildViewById != null) {
                        i = R.id.tab_layout;
                        TabLayout tabLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.tab_layout);
                        if (tabLayoutFindChildViewById != null) {
                            i = R.id.textView3;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                            if (textView != null) {
                                i = R.id.view_pager;
                                ViewPager2 viewPager2FindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_pager);
                                if (viewPager2FindChildViewById != null) {
                                    return new BloFragmentTrackStatusMain2Binding((ConstraintLayout) rootView, imageView, viewFindChildViewById, imageView2, constraintLayoutFindChildViewById, tabLayoutFindChildViewById, textView, viewPager2FindChildViewById);
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
