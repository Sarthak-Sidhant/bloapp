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
public final class BloFragmentSearchHouseBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final CardView cardView2;
    public final ImageView home;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final TextView ndata;
    private final ConstraintLayout rootView;
    public final RecyclerView searchListRv;
    public final SearchView searchView;
    public final TextView textView3;
    public final TextView version;

    private BloFragmentSearchHouseBinding(ConstraintLayout rootView, ImageView backBtnIv, CardView cardView2, ImageView home, ConstraintLayout homeFragmentTopConstraintLayout, TextView ndata, RecyclerView searchListRv, SearchView searchView, TextView textView3, TextView version) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.cardView2 = cardView2;
        this.home = home;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.ndata = ndata;
        this.searchListRv = searchListRv;
        this.searchView = searchView;
        this.textView3 = textView3;
        this.version = version;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentSearchHouseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentSearchHouseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_search_house, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentSearchHouseBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.cardView2;
            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView2);
            if (cardViewFindChildViewById != null) {
                i = 2131364061;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, 2131364061);
                if (imageView2 != null) {
                    i = R.id.home_fragment_top_constraint_layout;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                    if (constraintLayoutFindChildViewById != null) {
                        i = R.id.ndata;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.ndata);
                        if (textView != null) {
                            i = R.id.search_list_rv;
                            RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.search_list_rv);
                            if (recyclerViewFindChildViewById != null) {
                                i = R.id.searchView;
                                SearchView searchView = (SearchView) ViewBindings.findChildViewById(rootView, R.id.searchView);
                                if (searchView != null) {
                                    i = R.id.textView3;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                    if (textView2 != null) {
                                        i = R.id.version;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.version);
                                        if (textView3 != null) {
                                            return new BloFragmentSearchHouseBinding((ConstraintLayout) rootView, imageView, cardViewFindChildViewById, imageView2, constraintLayoutFindChildViewById, textView, recyclerViewFindChildViewById, searchView, textView2, textView3);
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
