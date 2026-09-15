package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloAppBarMainBinding implements ViewBinding {
    private final CoordinatorLayout rootView;
    public final Toolbar toolbar;
    public final ImageView toolbarButton;
    public final TextView toolbarTitle;
    public final TextView versionText;

    private BloAppBarMainBinding(CoordinatorLayout rootView, Toolbar toolbar, ImageView toolbarButton, TextView toolbarTitle, TextView versionText) {
        this.rootView = rootView;
        this.toolbar = toolbar;
        this.toolbarButton = toolbarButton;
        this.toolbarTitle = toolbarTitle;
        this.versionText = versionText;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static BloAppBarMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloAppBarMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_app_bar_main, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloAppBarMainBinding bind(View rootView) {
        int i = R.id.toolbar;
        Toolbar toolbarFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.toolbar);
        if (toolbarFindChildViewById != null) {
            i = R.id.toolbar_button;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
            if (imageView != null) {
                i = R.id.toolbar_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbar_title);
                if (textView != null) {
                    i = R.id.version_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.version_text);
                    if (textView2 != null) {
                        return new BloAppBarMainBinding((CoordinatorLayout) rootView, toolbarFindChildViewById, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
