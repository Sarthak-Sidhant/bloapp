package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivityAboutHonbleCommissionBinding implements ViewBinding {
    public final LinearLayout aboutHonbleCommissionMainLayout;
    public final ImageView back;
    public final WebView contactDetailsOfHonWebview;
    private final LinearLayout rootView;
    public final TextView title;
    public final ConstraintLayout titleBar;

    private BloActivityAboutHonbleCommissionBinding(LinearLayout rootView, LinearLayout aboutHonbleCommissionMainLayout, ImageView back, WebView contactDetailsOfHonWebview, TextView title, ConstraintLayout titleBar) {
        this.rootView = rootView;
        this.aboutHonbleCommissionMainLayout = aboutHonbleCommissionMainLayout;
        this.back = back;
        this.contactDetailsOfHonWebview = contactDetailsOfHonWebview;
        this.title = title;
        this.titleBar = titleBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityAboutHonbleCommissionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityAboutHonbleCommissionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_about_honble_commission, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityAboutHonbleCommissionBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = 2131362484;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131362484);
        if (imageView != null) {
            i = R.id.contact_Details_of_hon_webview;
            WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.contact_Details_of_hon_webview);
            if (webView != null) {
                i = 2131366420;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, 2131366420);
                if (textView != null) {
                    i = R.id.titleBar;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.titleBar);
                    if (constraintLayoutFindChildViewById != null) {
                        return new BloActivityAboutHonbleCommissionBinding(linearLayout, linearLayout, imageView, webView, textView, constraintLayoutFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
