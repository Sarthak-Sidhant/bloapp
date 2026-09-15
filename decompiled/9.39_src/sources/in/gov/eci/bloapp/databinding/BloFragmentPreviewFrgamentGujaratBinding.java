package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentPreviewFrgamentGujaratBinding implements ViewBinding {
    private final FrameLayout rootView;

    private BloFragmentPreviewFrgamentGujaratBinding(FrameLayout rootView) {
        this.rootView = rootView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentPreviewFrgamentGujaratBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentPreviewFrgamentGujaratBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_preview_frgament_gujarat, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentPreviewFrgamentGujaratBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BloFragmentPreviewFrgamentGujaratBinding((FrameLayout) rootView);
    }
}
