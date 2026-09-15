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
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class EfTrackerCountScreenFinalBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final ConstraintLayout efCitizenBlo;
    public final ConstraintLayout efDigitBlo;
    public final ConstraintLayout efDigitBlo1;
    public final ConstraintLayout efDigitTrack;
    public final ConstraintLayout efDistBlo;
    public final ConstraintLayout efDistrTrack;
    public final ConstraintLayout efNotDigitBlo;
    public final ConstraintLayout efNotDistBlo;
    public final ConstraintLayout efUncollectable;
    private final LinearLayout rootView;
    public final ConstraintLayout sirHeader;
    public final ConstraintLayout sirUpdateTime;
    public final TextView textView3;
    public final TextView textView5;
    public final Toolbar toolbar;
    public final ImageView toolbarButton;
    public final TextView tvEfBloVerified;
    public final TextView tvEfCitizenBlo;
    public final TextView tvEfDigitBlo;
    public final TextView tvEfDistBlo;
    public final TextView tvEfNotDigitBlo;
    public final TextView tvEfNotDistBlo;
    public final TextView tvEfUncollectable;
    public final TextView tvSirHeader;
    public final TextView tvUpdateTime;

    private EfTrackerCountScreenFinalBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, ConstraintLayout efCitizenBlo, ConstraintLayout efDigitBlo, ConstraintLayout efDigitBlo1, ConstraintLayout efDigitTrack, ConstraintLayout efDistBlo, ConstraintLayout efDistrTrack, ConstraintLayout efNotDigitBlo, ConstraintLayout efNotDistBlo, ConstraintLayout efUncollectable, ConstraintLayout sirHeader, ConstraintLayout sirUpdateTime, TextView textView3, TextView textView5, Toolbar toolbar, ImageView toolbarButton, TextView tvEfBloVerified, TextView tvEfCitizenBlo, TextView tvEfDigitBlo, TextView tvEfDistBlo, TextView tvEfNotDigitBlo, TextView tvEfNotDistBlo, TextView tvEfUncollectable, TextView tvSirHeader, TextView tvUpdateTime) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.efCitizenBlo = efCitizenBlo;
        this.efDigitBlo = efDigitBlo;
        this.efDigitBlo1 = efDigitBlo1;
        this.efDigitTrack = efDigitTrack;
        this.efDistBlo = efDistBlo;
        this.efDistrTrack = efDistrTrack;
        this.efNotDigitBlo = efNotDigitBlo;
        this.efNotDistBlo = efNotDistBlo;
        this.efUncollectable = efUncollectable;
        this.sirHeader = sirHeader;
        this.sirUpdateTime = sirUpdateTime;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbar = toolbar;
        this.toolbarButton = toolbarButton;
        this.tvEfBloVerified = tvEfBloVerified;
        this.tvEfCitizenBlo = tvEfCitizenBlo;
        this.tvEfDigitBlo = tvEfDigitBlo;
        this.tvEfDistBlo = tvEfDistBlo;
        this.tvEfNotDigitBlo = tvEfNotDigitBlo;
        this.tvEfNotDistBlo = tvEfNotDistBlo;
        this.tvEfUncollectable = tvEfUncollectable;
        this.tvSirHeader = tvSirHeader;
        this.tvUpdateTime = tvUpdateTime;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EfTrackerCountScreenFinalBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EfTrackerCountScreenFinalBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ef_tracker_count_screen_final, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EfTrackerCountScreenFinalBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.efCitizenBlo;
                ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.efCitizenBlo);
                if (constraintLayoutFindChildViewById2 != null) {
                    i = R.id.efDigitBlo;
                    ConstraintLayout constraintLayoutFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.efDigitBlo);
                    if (constraintLayoutFindChildViewById3 != null) {
                        i = R.id.efDigitBlo1;
                        ConstraintLayout constraintLayoutFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.efDigitBlo1);
                        if (constraintLayoutFindChildViewById4 != null) {
                            i = R.id.efDigitTrack;
                            ConstraintLayout constraintLayoutFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.efDigitTrack);
                            if (constraintLayoutFindChildViewById5 != null) {
                                i = R.id.efDistBlo;
                                ConstraintLayout constraintLayoutFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.efDistBlo);
                                if (constraintLayoutFindChildViewById6 != null) {
                                    i = R.id.efDistrTrack;
                                    ConstraintLayout constraintLayoutFindChildViewById7 = ViewBindings.findChildViewById(rootView, R.id.efDistrTrack);
                                    if (constraintLayoutFindChildViewById7 != null) {
                                        i = R.id.efNotDigitBlo;
                                        ConstraintLayout constraintLayoutFindChildViewById8 = ViewBindings.findChildViewById(rootView, R.id.efNotDigitBlo);
                                        if (constraintLayoutFindChildViewById8 != null) {
                                            i = R.id.efNotDistBlo;
                                            ConstraintLayout constraintLayoutFindChildViewById9 = ViewBindings.findChildViewById(rootView, R.id.efNotDistBlo);
                                            if (constraintLayoutFindChildViewById9 != null) {
                                                i = R.id.efUncollectable;
                                                ConstraintLayout constraintLayoutFindChildViewById10 = ViewBindings.findChildViewById(rootView, R.id.efUncollectable);
                                                if (constraintLayoutFindChildViewById10 != null) {
                                                    i = R.id.sirHeader;
                                                    ConstraintLayout constraintLayoutFindChildViewById11 = ViewBindings.findChildViewById(rootView, R.id.sirHeader);
                                                    if (constraintLayoutFindChildViewById11 != null) {
                                                        i = R.id.sirUpdateTime;
                                                        ConstraintLayout constraintLayoutFindChildViewById12 = ViewBindings.findChildViewById(rootView, R.id.sirUpdateTime);
                                                        if (constraintLayoutFindChildViewById12 != null) {
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
                                                                            i = R.id.tvEfBloVerified;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvEfBloVerified);
                                                                            if (textView3 != null) {
                                                                                i = R.id.tvEfCitizenBlo;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvEfCitizenBlo);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.tvEfDigitBlo;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvEfDigitBlo);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.tvEfDistBlo;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvEfDistBlo);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.tvEfNotDigitBlo;
                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvEfNotDigitBlo);
                                                                                            if (textView7 != null) {
                                                                                                i = R.id.tvEfNotDistBlo;
                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvEfNotDistBlo);
                                                                                                if (textView8 != null) {
                                                                                                    i = R.id.tvEfUncollectable;
                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvEfUncollectable);
                                                                                                    if (textView9 != null) {
                                                                                                        i = R.id.tvSirHeader;
                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvSirHeader);
                                                                                                        if (textView10 != null) {
                                                                                                            i = R.id.tvUpdateTime;
                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvUpdateTime);
                                                                                                            if (textView11 != null) {
                                                                                                                return new EfTrackerCountScreenFinalBinding((LinearLayout) rootView, imageView, constraintLayoutFindChildViewById, constraintLayoutFindChildViewById2, constraintLayoutFindChildViewById3, constraintLayoutFindChildViewById4, constraintLayoutFindChildViewById5, constraintLayoutFindChildViewById6, constraintLayoutFindChildViewById7, constraintLayoutFindChildViewById8, constraintLayoutFindChildViewById9, constraintLayoutFindChildViewById10, constraintLayoutFindChildViewById11, constraintLayoutFindChildViewById12, textView, textView2, toolbarFindChildViewById, imageView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
