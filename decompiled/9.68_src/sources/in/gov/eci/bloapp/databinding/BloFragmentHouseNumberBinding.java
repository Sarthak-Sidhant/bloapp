package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentHouseNumberBinding implements ViewBinding {
    public final ImageButton addFamilymem;
    public final ImageView backBtnIv;
    public final TextView headTitle;
    public final ImageView home;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final RecyclerView houseDetailsRv;
    private final ConstraintLayout rootView;
    public final TextView version;

    private BloFragmentHouseNumberBinding(ConstraintLayout rootView, ImageButton addFamilymem, ImageView backBtnIv, TextView headTitle, ImageView home, ConstraintLayout homeFragmentTopConstraintLayout, RecyclerView houseDetailsRv, TextView version) {
        this.rootView = rootView;
        this.addFamilymem = addFamilymem;
        this.backBtnIv = backBtnIv;
        this.headTitle = headTitle;
        this.home = home;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.houseDetailsRv = houseDetailsRv;
        this.version = version;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentHouseNumberBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentHouseNumberBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_house_number_, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentHouseNumberBinding bind(View rootView) {
        int i = R.id.addFamilymem;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.addFamilymem);
        if (imageButton != null) {
            i = R.id.back_btn_iv;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
            if (imageView != null) {
                i = R.id.head_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.head_title);
                if (textView != null) {
                    i = 2131364192;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, 2131364192);
                    if (imageView2 != null) {
                        i = R.id.home_fragment_top_constraint_layout;
                        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                        if (constraintLayoutFindChildViewById != null) {
                            i = R.id.house_details_rv;
                            RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.house_details_rv);
                            if (recyclerViewFindChildViewById != null) {
                                i = R.id.version;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.version);
                                if (textView2 != null) {
                                    return new BloFragmentHouseNumberBinding((ConstraintLayout) rootView, imageButton, imageView, textView, imageView2, constraintLayoutFindChildViewById, recyclerViewFindChildViewById, textView2);
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
