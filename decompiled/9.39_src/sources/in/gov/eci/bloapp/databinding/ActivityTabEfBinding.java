package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityTabEfBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    private final LinearLayout rootView;
    public final TabLayout tabLayout;
    public final TextView textView3;
    public final TextView textView5;
    public final Toolbar toolbar;
    public final ImageView toolbarButton;
    public final ViewPager2 viewPager;

    private ActivityTabEfBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, TabLayout tabLayout, TextView textView3, TextView textView5, Toolbar toolbar, ImageView toolbarButton, ViewPager2 viewPager) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.tabLayout = tabLayout;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbar = toolbar;
        this.toolbarButton = toolbarButton;
        this.viewPager = viewPager;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTabEfBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityTabEfBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_tab_ef, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityTabEfBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.tabLayout;
                TabLayout tabLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.tabLayout);
                if (tabLayoutFindChildViewById != null) {
                    i = R.id.textView3;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                    if (textView != null) {
                        i = R.id.textView5;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                        if (textView2 != null) {
                            i = R.id.toolbar;
                            Toolbar toolbarFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.toolbar);
                            if (toolbarFindChildViewById != null) {
                                i = R.id.toolbar_button;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                if (imageView2 != null) {
                                    i = R.id.viewPager;
                                    ViewPager2 viewPager2FindChildViewById = ViewBindings.findChildViewById(rootView, R.id.viewPager);
                                    if (viewPager2FindChildViewById != null) {
                                        return new ActivityTabEfBinding((LinearLayout) rootView, imageView, constraintLayoutFindChildViewById, tabLayoutFindChildViewById, textView, textView2, toolbarFindChildViewById, imageView2, viewPager2FindChildViewById);
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
