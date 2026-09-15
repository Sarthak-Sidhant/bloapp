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
public final class FragmentCallRequestMainBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    private final ConstraintLayout rootView;
    public final TabLayout tabLayout;
    public final TextView textView3;
    public final ViewPager2 viewPager;

    private FragmentCallRequestMainBinding(ConstraintLayout rootView, ImageView backBtnIv, ConstraintLayout homeFragmentTopConstraintLayout, TabLayout tabLayout, TextView textView3, ViewPager2 viewPager) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.tabLayout = tabLayout;
        this.textView3 = textView3;
        this.viewPager = viewPager;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCallRequestMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCallRequestMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_call_request_main, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCallRequestMainBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
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
                            return new FragmentCallRequestMainBinding((ConstraintLayout) rootView, imageView, constraintLayoutFindChildViewById, tabLayoutFindChildViewById, textView, viewPager2FindChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
