package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloActivityMapsBinding implements ViewBinding {
    public final LinearLayout linearLayoutForBtn;
    private final RelativeLayout rootView;
    public final AppCompatButton submit;

    private BloActivityMapsBinding(RelativeLayout rootView, LinearLayout linearLayoutForBtn, AppCompatButton submit) {
        this.rootView = rootView;
        this.linearLayoutForBtn = linearLayoutForBtn;
        this.submit = submit;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityMapsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityMapsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_maps, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityMapsBinding bind(View rootView) {
        int i = R.id.linear_layout_for_btn;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_layout_for_btn);
        if (linearLayout != null) {
            i = R.id.submit;
            AppCompatButton appCompatButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.submit);
            if (appCompatButtonFindChildViewById != null) {
                return new BloActivityMapsBinding((RelativeLayout) rootView, linearLayout, appCompatButtonFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
