package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloActivityCheckListBinding implements ViewBinding {
    public final ConstraintLayout drawerLayout;
    public final FrameLayout frameCheckList;
    public final FrameLayout main;
    private final ConstraintLayout rootView;

    private BloActivityCheckListBinding(ConstraintLayout rootView, ConstraintLayout drawerLayout, FrameLayout frameCheckList, FrameLayout main) {
        this.rootView = rootView;
        this.drawerLayout = drawerLayout;
        this.frameCheckList = frameCheckList;
        this.main = main;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityCheckListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityCheckListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_check_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityCheckListBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.frame_check_list;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.frame_check_list);
        if (frameLayout != null) {
            i = R.id.main;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.main);
            if (frameLayout2 != null) {
                return new BloActivityCheckListBinding(constraintLayout, constraintLayout, frameLayout, frameLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
