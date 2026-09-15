package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentNameRecyclerViewBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout bottomNextLayout;
    public final CardView cardView;
    public final ConstraintLayout constraintLayout;
    public final ImageView homeBtnIv;
    public final RecyclerView nameRv;
    public final FrameLayout nameRvFrame;
    public final TextView nextTv;
    private final ConstraintLayout rootView;
    public final TextView textView3;

    private BloFragmentNameRecyclerViewBinding(ConstraintLayout rootView, ImageView backBtnIv, ConstraintLayout bottomNextLayout, CardView cardView, ConstraintLayout constraintLayout, ImageView homeBtnIv, RecyclerView nameRv, FrameLayout nameRvFrame, TextView nextTv, TextView textView3) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.bottomNextLayout = bottomNextLayout;
        this.cardView = cardView;
        this.constraintLayout = constraintLayout;
        this.homeBtnIv = homeBtnIv;
        this.nameRv = nameRv;
        this.nameRvFrame = nameRvFrame;
        this.nextTv = nextTv;
        this.textView3 = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentNameRecyclerViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentNameRecyclerViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_name_recycler_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentNameRecyclerViewBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bottom_next_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_next_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.cardView;
                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView);
                if (cardViewFindChildViewById != null) {
                    i = R.id.constraintLayout;
                    ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
                    if (constraintLayoutFindChildViewById2 != null) {
                        i = R.id.home_btn_iv;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                        if (imageView2 != null) {
                            i = R.id.name_rv;
                            RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.name_rv);
                            if (recyclerViewFindChildViewById != null) {
                                i = R.id.name_rv_frame;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.name_rv_frame);
                                if (frameLayout != null) {
                                    i = R.id.next_tv;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.next_tv);
                                    if (textView != null) {
                                        i = R.id.textView3;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                        if (textView2 != null) {
                                            return new BloFragmentNameRecyclerViewBinding((ConstraintLayout) rootView, imageView, constraintLayoutFindChildViewById, cardViewFindChildViewById, constraintLayoutFindChildViewById2, imageView2, recyclerViewFindChildViewById, frameLayout, textView, textView2);
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
