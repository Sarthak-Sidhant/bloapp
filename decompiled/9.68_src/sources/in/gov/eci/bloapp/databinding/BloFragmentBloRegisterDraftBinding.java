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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentBloRegisterDraftBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final RecyclerView bloRegisterListRv;
    public final FloatingActionButton filter;
    public final ConstraintLayout headerLayout;
    public final ImageView homeBtnIv;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final TextView title;

    private BloFragmentBloRegisterDraftBinding(ConstraintLayout rootView, ImageView backBtnIv, RecyclerView bloRegisterListRv, FloatingActionButton filter, ConstraintLayout headerLayout, ImageView homeBtnIv, ConstraintLayout root, TextView title) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.bloRegisterListRv = bloRegisterListRv;
        this.filter = filter;
        this.headerLayout = headerLayout;
        this.homeBtnIv = homeBtnIv;
        this.root = root;
        this.title = title;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentBloRegisterDraftBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentBloRegisterDraftBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_blo_register_draft, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentBloRegisterDraftBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.blo_register_list_rv;
            RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.blo_register_list_rv);
            if (recyclerViewFindChildViewById != null) {
                i = R.id.filter;
                FloatingActionButton floatingActionButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.filter);
                if (floatingActionButtonFindChildViewById != null) {
                    i = R.id.headerLayout;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.headerLayout);
                    if (constraintLayoutFindChildViewById != null) {
                        i = R.id.home_btn_iv;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                        if (imageView2 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                            i = 2131366420;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, 2131366420);
                            if (textView != null) {
                                return new BloFragmentBloRegisterDraftBinding(constraintLayout, imageView, recyclerViewFindChildViewById, floatingActionButtonFindChildViewById, constraintLayoutFindChildViewById, imageView2, constraintLayout, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
