package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentSelectApplicantBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final CardView cardView;
    public final ConstraintLayout constraintLayout;
    public final ImageView homeBtnIv;
    private final ConstraintLayout rootView;
    public final TextView saveNextTv;
    public final RecyclerView selectApplicantrv;
    public final TextView textView3;

    private BloFragmentSelectApplicantBinding(ConstraintLayout rootView, ImageView backBtnIv, CardView cardView, ConstraintLayout constraintLayout, ImageView homeBtnIv, TextView saveNextTv, RecyclerView selectApplicantrv, TextView textView3) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.cardView = cardView;
        this.constraintLayout = constraintLayout;
        this.homeBtnIv = homeBtnIv;
        this.saveNextTv = saveNextTv;
        this.selectApplicantrv = selectApplicantrv;
        this.textView3 = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentSelectApplicantBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentSelectApplicantBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_select_applicant, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentSelectApplicantBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.cardView;
            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView);
            if (cardViewFindChildViewById != null) {
                i = R.id.constraintLayout;
                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
                if (constraintLayoutFindChildViewById != null) {
                    i = R.id.home_btn_iv;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                    if (imageView2 != null) {
                        i = R.id.save_next_tv;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.save_next_tv);
                        if (textView != null) {
                            i = R.id.selectApplicantrv;
                            RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.selectApplicantrv);
                            if (recyclerViewFindChildViewById != null) {
                                i = R.id.textView3;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                if (textView2 != null) {
                                    return new BloFragmentSelectApplicantBinding((ConstraintLayout) rootView, imageView, cardViewFindChildViewById, constraintLayoutFindChildViewById, imageView2, textView, recyclerViewFindChildViewById, textView2);
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
