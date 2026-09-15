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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentFormatABinding implements ViewBinding {
    public final RecyclerView allAppsRv;
    public final ImageView backBtnIv;
    public final ImageView homeBtnIv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final TextView nodata;
    public final LinearLayout nodatalayout;
    private final ConstraintLayout rootView;
    public final FloatingActionButton searchDsePending;
    public final TextView textView3;

    private BloFragmentFormatABinding(ConstraintLayout rootView, RecyclerView allAppsRv, ImageView backBtnIv, ImageView homeBtnIv, ConstraintLayout homeFragmentTopConstraintLayout, TextView nodata, LinearLayout nodatalayout, FloatingActionButton searchDsePending, TextView textView3) {
        this.rootView = rootView;
        this.allAppsRv = allAppsRv;
        this.backBtnIv = backBtnIv;
        this.homeBtnIv = homeBtnIv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.nodata = nodata;
        this.nodatalayout = nodatalayout;
        this.searchDsePending = searchDsePending;
        this.textView3 = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentFormatABinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentFormatABinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_format_a, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentFormatABinding bind(View rootView) {
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
                        i = R.id.nodata;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.nodata);
                        if (textView != null) {
                            i = R.id.nodatalayout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.nodatalayout);
                            if (linearLayout != null) {
                                i = R.id.searchDsePending;
                                FloatingActionButton floatingActionButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.searchDsePending);
                                if (floatingActionButtonFindChildViewById != null) {
                                    i = R.id.textView3;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                    if (textView2 != null) {
                                        return new BloFragmentFormatABinding((ConstraintLayout) rootView, recyclerViewFindChildViewById, imageView, imageView2, constraintLayoutFindChildViewById, textView, linearLayout, floatingActionButtonFindChildViewById, textView2);
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
