package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentBloNotificationBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final TextView count;
    public final View divider1;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final RecyclerView newVoterRecycler;
    private final ConstraintLayout rootView;
    public final TextView textView3;

    private BloFragmentBloNotificationBinding(ConstraintLayout rootView, ImageView backBtnIv, TextView count, View divider1, ConstraintLayout homeFragmentTopConstraintLayout, RecyclerView newVoterRecycler, TextView textView3) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.count = count;
        this.divider1 = divider1;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.newVoterRecycler = newVoterRecycler;
        this.textView3 = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentBloNotificationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentBloNotificationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_blo_notification, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentBloNotificationBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.count;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.count);
            if (textView != null) {
                i = R.id.divider1;
                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.divider1);
                if (viewFindChildViewById != null) {
                    i = R.id.home_fragment_top_constraint_layout;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                    if (constraintLayoutFindChildViewById != null) {
                        i = R.id.new_voter_recycler;
                        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.new_voter_recycler);
                        if (recyclerViewFindChildViewById != null) {
                            i = R.id.textView3;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                            if (textView2 != null) {
                                return new BloFragmentBloNotificationBinding((ConstraintLayout) rootView, imageView, textView, viewFindChildViewById, constraintLayoutFindChildViewById, recyclerViewFindChildViewById, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
