package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivityDashboardBloactivityBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final CardView cardView1;
    public final CardView cardView2;
    public final FrameLayout containerChart;
    public final LinearLayout homeFragmentTop;
    public final SwipeRefreshLayout homerefreshlayout;
    public final LinearLayout linerLayoutElector;
    private final SwipeRefreshLayout rootView;
    public final TextView textFemale;
    public final TextView textFemaleCount;
    public final TextView textMale;
    public final TextView textMaleCount;
    public final TextView textThirdGen;
    public final TextView textThirdGenCount;
    public final TextView textTotalElectors;
    public final TextView textTotalElectorsCount;
    public final TextView textView3;

    private BloActivityDashboardBloactivityBinding(SwipeRefreshLayout rootView, ImageView backBtnIv, CardView cardView1, CardView cardView2, FrameLayout containerChart, LinearLayout homeFragmentTop, SwipeRefreshLayout homerefreshlayout, LinearLayout linerLayoutElector, TextView textFemale, TextView textFemaleCount, TextView textMale, TextView textMaleCount, TextView textThirdGen, TextView textThirdGenCount, TextView textTotalElectors, TextView textTotalElectorsCount, TextView textView3) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.cardView1 = cardView1;
        this.cardView2 = cardView2;
        this.containerChart = containerChart;
        this.homeFragmentTop = homeFragmentTop;
        this.homerefreshlayout = homerefreshlayout;
        this.linerLayoutElector = linerLayoutElector;
        this.textFemale = textFemale;
        this.textFemaleCount = textFemaleCount;
        this.textMale = textMale;
        this.textMaleCount = textMaleCount;
        this.textThirdGen = textThirdGen;
        this.textThirdGenCount = textThirdGenCount;
        this.textTotalElectors = textTotalElectors;
        this.textTotalElectorsCount = textTotalElectorsCount;
        this.textView3 = textView3;
    }

    public SwipeRefreshLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityDashboardBloactivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityDashboardBloactivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_dashboard_bloactivity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityDashboardBloactivityBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.cardView1;
            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView1);
            if (cardViewFindChildViewById != null) {
                i = R.id.cardView2;
                CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.cardView2);
                if (cardViewFindChildViewById2 != null) {
                    i = R.id.containerChart;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.containerChart);
                    if (frameLayout != null) {
                        i = R.id.home_fragment_top;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.home_fragment_top);
                        if (linearLayout != null) {
                            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) rootView;
                            i = R.id.linerLayoutElector;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linerLayoutElector);
                            if (linearLayout2 != null) {
                                i = R.id.textFemale;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textFemale);
                                if (textView != null) {
                                    i = R.id.textFemaleCount;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textFemaleCount);
                                    if (textView2 != null) {
                                        i = R.id.textMale;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textMale);
                                        if (textView3 != null) {
                                            i = R.id.textMaleCount;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textMaleCount);
                                            if (textView4 != null) {
                                                i = R.id.textThirdGen;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textThirdGen);
                                                if (textView5 != null) {
                                                    i = R.id.textThirdGenCount;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textThirdGenCount);
                                                    if (textView6 != null) {
                                                        i = R.id.textTotalElectors;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textTotalElectors);
                                                        if (textView7 != null) {
                                                            i = R.id.textTotalElectorsCount;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textTotalElectorsCount);
                                                            if (textView8 != null) {
                                                                i = R.id.textView3;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                if (textView9 != null) {
                                                                    return new BloActivityDashboardBloactivityBinding(swipeRefreshLayout, imageView, cardViewFindChildViewById, cardViewFindChildViewById2, frameLayout, linearLayout, swipeRefreshLayout, linearLayout2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
