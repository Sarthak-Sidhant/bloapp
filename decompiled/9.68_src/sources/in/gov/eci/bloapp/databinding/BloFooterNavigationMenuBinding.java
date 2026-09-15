package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFooterNavigationMenuBinding implements ViewBinding {
    public final TextView appVersion;
    private final LinearLayout rootView;

    private BloFooterNavigationMenuBinding(LinearLayout rootView, TextView appVersion) {
        this.rootView = rootView;
        this.appVersion = appVersion;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloFooterNavigationMenuBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFooterNavigationMenuBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_footer_navigation_menu, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFooterNavigationMenuBinding bind(View rootView) {
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.app_version);
        if (textView != null) {
            return new BloFooterNavigationMenuBinding((LinearLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.app_version)));
    }
}
