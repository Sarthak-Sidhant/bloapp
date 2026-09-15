package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloProgressLayoutBinding implements ViewBinding {
    public final RelativeLayout progressBarLayout;
    private final RelativeLayout rootView;

    private BloProgressLayoutBinding(RelativeLayout rootView, RelativeLayout progressBarLayout) {
        this.rootView = rootView;
        this.progressBarLayout = progressBarLayout;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BloProgressLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloProgressLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_progress_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloProgressLayoutBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        return new BloProgressLayoutBinding(relativeLayout, relativeLayout);
    }
}
