package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentObjecteeRecylerViewForm7Binding implements ViewBinding {
    public final RecyclerView nameRv;
    public final FrameLayout nameRvFrame;
    private final ConstraintLayout rootView;

    private BloFragmentObjecteeRecylerViewForm7Binding(ConstraintLayout rootView, RecyclerView nameRv, FrameLayout nameRvFrame) {
        this.rootView = rootView;
        this.nameRv = nameRv;
        this.nameRvFrame = nameRvFrame;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentObjecteeRecylerViewForm7Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentObjecteeRecylerViewForm7Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_objectee_recyler_view_form7, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentObjecteeRecylerViewForm7Binding bind(View rootView) {
        int i = R.id.name_rv;
        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.name_rv);
        if (recyclerViewFindChildViewById != null) {
            i = R.id.name_rv_frame;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.name_rv_frame);
            if (frameLayout != null) {
                return new BloFragmentObjecteeRecylerViewForm7Binding((ConstraintLayout) rootView, recyclerViewFindChildViewById, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
