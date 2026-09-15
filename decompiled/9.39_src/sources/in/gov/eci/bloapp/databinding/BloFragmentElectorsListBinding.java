package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentElectorsListBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final LinearLayout constraintLayout2;
    public final FloatingActionButton filter;
    public final ImageView homeButton;
    public final FrameLayout mainLayout;
    private final FrameLayout rootView;
    public final SearchView search;
    public final TextView selectedFilter;
    public final LinearLayout showFilterResultLayout;
    public final ImageButton sync;
    public final TextView textView3;
    public final TextView totalElectors;
    public final RecyclerView verifiedRv;

    private BloFragmentElectorsListBinding(FrameLayout rootView, ImageView backBtnIv, LinearLayout constraintLayout2, FloatingActionButton filter, ImageView homeButton, FrameLayout mainLayout, SearchView search, TextView selectedFilter, LinearLayout showFilterResultLayout, ImageButton sync, TextView textView3, TextView totalElectors, RecyclerView verifiedRv) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.constraintLayout2 = constraintLayout2;
        this.filter = filter;
        this.homeButton = homeButton;
        this.mainLayout = mainLayout;
        this.search = search;
        this.selectedFilter = selectedFilter;
        this.showFilterResultLayout = showFilterResultLayout;
        this.sync = sync;
        this.textView3 = textView3;
        this.totalElectors = totalElectors;
        this.verifiedRv = verifiedRv;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentElectorsListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentElectorsListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_electors_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentElectorsListBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.constraintLayout2;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.constraintLayout2);
            if (linearLayout != null) {
                i = R.id.filter;
                FloatingActionButton floatingActionButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.filter);
                if (floatingActionButtonFindChildViewById != null) {
                    i = R.id.homeButton;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.homeButton);
                    if (imageView2 != null) {
                        FrameLayout frameLayout = (FrameLayout) rootView;
                        i = R.id.search;
                        SearchView searchViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.search);
                        if (searchViewFindChildViewById != null) {
                            i = R.id.selectedFilter;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.selectedFilter);
                            if (textView != null) {
                                i = R.id.showFilterResultLayout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.showFilterResultLayout);
                                if (linearLayout2 != null) {
                                    i = R.id.sync;
                                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.sync);
                                    if (imageButton != null) {
                                        i = R.id.textView3;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                        if (textView2 != null) {
                                            i = R.id.totalElectors;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalElectors);
                                            if (textView3 != null) {
                                                i = R.id.verified_rv;
                                                RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.verified_rv);
                                                if (recyclerViewFindChildViewById != null) {
                                                    return new BloFragmentElectorsListBinding(frameLayout, imageView, linearLayout, floatingActionButtonFindChildViewById, imageView2, frameLayout, searchViewFindChildViewById, textView, linearLayout2, imageButton, textView2, textView3, recyclerViewFindChildViewById);
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
