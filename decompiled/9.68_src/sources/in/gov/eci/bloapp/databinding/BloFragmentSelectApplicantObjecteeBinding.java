package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentSelectApplicantObjecteeBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final CardView cardView;
    public final ImageView homeBtnIv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    private final ConstraintLayout rootView;
    public final TextView saveNextTv;
    public final TabLayout tabLayout;
    public final TextView textView3;
    public final ViewPager2 viewPager;

    private BloFragmentSelectApplicantObjecteeBinding(ConstraintLayout rootView, ImageView backBtnIv, CardView cardView, ImageView homeBtnIv, ConstraintLayout homeFragmentTopConstraintLayout, TextView saveNextTv, TabLayout tabLayout, TextView textView3, ViewPager2 viewPager) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.cardView = cardView;
        this.homeBtnIv = homeBtnIv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.saveNextTv = saveNextTv;
        this.tabLayout = tabLayout;
        this.textView3 = textView3;
        this.viewPager = viewPager;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentSelectApplicantObjecteeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentSelectApplicantObjecteeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_select_applicant_objectee, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentSelectApplicantObjecteeBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.cardView;
            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView);
            if (cardViewFindChildViewById != null) {
                i = R.id.home_btn_iv;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                if (imageView2 != null) {
                    i = R.id.home_fragment_top_constraint_layout;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                    if (constraintLayoutFindChildViewById != null) {
                        i = R.id.save_next_tv;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.save_next_tv);
                        if (textView != null) {
                            i = R.id.tab_layout;
                            TabLayout tabLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.tab_layout);
                            if (tabLayoutFindChildViewById != null) {
                                i = R.id.textView3;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                if (textView2 != null) {
                                    i = R.id.view_pager;
                                    ViewPager2 viewPager2FindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_pager);
                                    if (viewPager2FindChildViewById != null) {
                                        return new BloFragmentSelectApplicantObjecteeBinding((ConstraintLayout) rootView, imageView, cardViewFindChildViewById, imageView2, constraintLayoutFindChildViewById, textView, tabLayoutFindChildViewById, textView2, viewPager2FindChildViewById);
                                    }
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
