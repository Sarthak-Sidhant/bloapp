package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityPendingElectorsBhBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final TextView headerText;
    public final LinearLayout main;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final SearchView search;

    private ActivityPendingElectorsBhBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, TextView headerText, LinearLayout main, RecyclerView recyclerView, SearchView search) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.headerText = headerText;
        this.main = main;
        this.recyclerView = recyclerView;
        this.search = search;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPendingElectorsBhBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityPendingElectorsBhBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_pending_electors_bh, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPendingElectorsBhBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.header_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.header_text);
                if (textView != null) {
                    LinearLayout linearLayout = (LinearLayout) rootView;
                    i = R.id.recyclerView;
                    RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.recyclerView);
                    if (recyclerViewFindChildViewById != null) {
                        i = R.id.search;
                        SearchView searchViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.search);
                        if (searchViewFindChildViewById != null) {
                            return new ActivityPendingElectorsBhBinding(linearLayout, imageView, constraintLayoutFindChildViewById, textView, linearLayout, recyclerViewFindChildViewById, searchViewFindChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
