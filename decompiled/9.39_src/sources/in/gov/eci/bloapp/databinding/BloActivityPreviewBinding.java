package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloActivityPreviewBinding implements ViewBinding {
    public final ImageView back;
    public final CardView cardView;
    public final ConstraintLayout hideit;
    public final ImageView homeBtnIv;
    public final FrameLayout previewMain;
    public final TextView previousTv;
    private final FrameLayout rootView;
    public final TextView saveNextTv;
    public final LinearLayout tabLayout;
    public final TabLayout tabs;
    public final TextView title;
    public final ConstraintLayout titleBar;
    public final View viewSpinner;
    public final ViewPager2 viewpager;

    private BloActivityPreviewBinding(FrameLayout rootView, ImageView back, CardView cardView, ConstraintLayout hideit, ImageView homeBtnIv, FrameLayout previewMain, TextView previousTv, TextView saveNextTv, LinearLayout tabLayout, TabLayout tabs, TextView title, ConstraintLayout titleBar, View viewSpinner, ViewPager2 viewpager) {
        this.rootView = rootView;
        this.back = back;
        this.cardView = cardView;
        this.hideit = hideit;
        this.homeBtnIv = homeBtnIv;
        this.previewMain = previewMain;
        this.previousTv = previousTv;
        this.saveNextTv = saveNextTv;
        this.tabLayout = tabLayout;
        this.tabs = tabs;
        this.title = title;
        this.titleBar = titleBar;
        this.viewSpinner = viewSpinner;
        this.viewpager = viewpager;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityPreviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityPreviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_preview, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityPreviewBinding bind(View rootView) {
        int i = 2131362452;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131362452);
        if (imageView != null) {
            i = R.id.cardView;
            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView);
            if (cardViewFindChildViewById != null) {
                i = R.id.hideit;
                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.hideit);
                if (constraintLayoutFindChildViewById != null) {
                    i = R.id.home_btn_iv;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                    if (imageView2 != null) {
                        FrameLayout frameLayout = (FrameLayout) rootView;
                        i = R.id.previous_tv;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.previous_tv);
                        if (textView != null) {
                            i = R.id.save_next_tv;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.save_next_tv);
                            if (textView2 != null) {
                                i = R.id.tab_layout;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.tab_layout);
                                if (linearLayout != null) {
                                    i = R.id.tabs;
                                    TabLayout tabLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.tabs);
                                    if (tabLayoutFindChildViewById != null) {
                                        i = 2131366197;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, 2131366197);
                                        if (textView3 != null) {
                                            i = R.id.titleBar;
                                            ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.titleBar);
                                            if (constraintLayoutFindChildViewById2 != null) {
                                                i = R.id.view_spinner;
                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_spinner);
                                                if (viewFindChildViewById != null) {
                                                    i = R.id.viewpager;
                                                    ViewPager2 viewPager2FindChildViewById = ViewBindings.findChildViewById(rootView, R.id.viewpager);
                                                    if (viewPager2FindChildViewById != null) {
                                                        return new BloActivityPreviewBinding(frameLayout, imageView, cardViewFindChildViewById, constraintLayoutFindChildViewById, imageView2, frameLayout, textView, textView2, linearLayout, tabLayoutFindChildViewById, textView3, constraintLayoutFindChildViewById2, viewFindChildViewById, viewPager2FindChildViewById);
                                                    }
                                                }
                                            }
                                        }
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
