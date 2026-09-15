package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloActivityDeletionObjectionTabLayoutBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout bottomPreviousSaveLayout;
    public final CardView cardView;
    public final ConstraintLayout constraintLayout;
    public final FrameLayout frameVoterForms;
    public final ImageView homeBtnIv;
    public final ConstraintLayout mainLayout;
    public final TextView nextBtn;
    private final ConstraintLayout rootView;
    public final TabLayout tabLayout;
    public final TextView textView3;
    public final View view;
    public final ViewPager2 viewpager;

    private BloActivityDeletionObjectionTabLayoutBinding(ConstraintLayout rootView, ImageView backBtnIv, ConstraintLayout bottomPreviousSaveLayout, CardView cardView, ConstraintLayout constraintLayout, FrameLayout frameVoterForms, ImageView homeBtnIv, ConstraintLayout mainLayout, TextView nextBtn, TabLayout tabLayout, TextView textView3, View view, ViewPager2 viewpager) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.bottomPreviousSaveLayout = bottomPreviousSaveLayout;
        this.cardView = cardView;
        this.constraintLayout = constraintLayout;
        this.frameVoterForms = frameVoterForms;
        this.homeBtnIv = homeBtnIv;
        this.mainLayout = mainLayout;
        this.nextBtn = nextBtn;
        this.tabLayout = tabLayout;
        this.textView3 = textView3;
        this.view = view;
        this.viewpager = viewpager;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityDeletionObjectionTabLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityDeletionObjectionTabLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_deletion_objection_tab_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityDeletionObjectionTabLayoutBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bottom_previous_save_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_previous_save_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.cardView;
                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView);
                if (cardViewFindChildViewById != null) {
                    i = R.id.constraintLayout;
                    ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
                    if (constraintLayoutFindChildViewById2 != null) {
                        i = R.id.frame_voter_forms;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.frame_voter_forms);
                        if (frameLayout != null) {
                            i = R.id.home_btn_iv;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                            if (imageView2 != null) {
                                i = R.id.mainLayout;
                                ConstraintLayout constraintLayoutFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.mainLayout);
                                if (constraintLayoutFindChildViewById3 != null) {
                                    i = R.id.next_btn;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.next_btn);
                                    if (textView != null) {
                                        i = R.id.tab_layout;
                                        TabLayout tabLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.tab_layout);
                                        if (tabLayoutFindChildViewById != null) {
                                            i = R.id.textView3;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                            if (textView2 != null) {
                                                i = R.id.view;
                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view);
                                                if (viewFindChildViewById != null) {
                                                    i = R.id.viewpager;
                                                    ViewPager2 viewPager2FindChildViewById = ViewBindings.findChildViewById(rootView, R.id.viewpager);
                                                    if (viewPager2FindChildViewById != null) {
                                                        return new BloActivityDeletionObjectionTabLayoutBinding((ConstraintLayout) rootView, imageView, constraintLayoutFindChildViewById, cardViewFindChildViewById, constraintLayoutFindChildViewById2, frameLayout, imageView2, constraintLayoutFindChildViewById3, textView, tabLayoutFindChildViewById, textView2, viewFindChildViewById, viewPager2FindChildViewById);
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
