package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentSearchListBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final CardView cardView2;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView searchListRv;
    public final SearchView searchView;
    public final TextView textView3;

    private BloFragmentSearchListBinding(ConstraintLayout rootView, ImageView backBtnIv, CardView cardView2, ConstraintLayout homeFragmentTopConstraintLayout, RecyclerView searchListRv, SearchView searchView, TextView textView3) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.cardView2 = cardView2;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.searchListRv = searchListRv;
        this.searchView = searchView;
        this.textView3 = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentSearchListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentSearchListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_search_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentSearchListBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.cardView2;
            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView2);
            if (cardViewFindChildViewById != null) {
                i = R.id.home_fragment_top_constraint_layout;
                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                if (constraintLayoutFindChildViewById != null) {
                    i = R.id.search_list_rv;
                    RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.search_list_rv);
                    if (recyclerViewFindChildViewById != null) {
                        i = R.id.searchView;
                        SearchView searchView = (SearchView) ViewBindings.findChildViewById(rootView, R.id.searchView);
                        if (searchView != null) {
                            i = R.id.textView3;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                            if (textView != null) {
                                return new BloFragmentSearchListBinding((ConstraintLayout) rootView, imageView, cardViewFindChildViewById, constraintLayoutFindChildViewById, recyclerViewFindChildViewById, searchView, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
