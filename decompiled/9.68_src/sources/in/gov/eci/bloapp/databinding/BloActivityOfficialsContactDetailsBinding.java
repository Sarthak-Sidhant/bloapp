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
public final class BloActivityOfficialsContactDetailsBinding implements ViewBinding {
    public final ImageView back;
    public final LinearLayout officialsContactDetailsMainLayout;
    public final WebView officialsContactDetailsWebview;
    private final LinearLayout rootView;
    public final TextView title;
    public final ConstraintLayout titleBar;

    private BloActivityOfficialsContactDetailsBinding(LinearLayout rootView, ImageView back, LinearLayout officialsContactDetailsMainLayout, WebView officialsContactDetailsWebview, TextView title, ConstraintLayout titleBar) {
        this.rootView = rootView;
        this.back = back;
        this.officialsContactDetailsMainLayout = officialsContactDetailsMainLayout;
        this.officialsContactDetailsWebview = officialsContactDetailsWebview;
        this.title = title;
        this.titleBar = titleBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityOfficialsContactDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityOfficialsContactDetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_officials_contact_details, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityOfficialsContactDetailsBinding bind(View rootView) {
        int i = 2131362484;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131362484);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) rootView;
            i = R.id.officials_Contact_Details_webview;
            WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.officials_Contact_Details_webview);
            if (webView != null) {
                i = 2131366420;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, 2131366420);
                if (textView != null) {
                    i = R.id.titleBar;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.titleBar);
                    if (constraintLayoutFindChildViewById != null) {
                        return new BloActivityOfficialsContactDetailsBinding(linearLayout, imageView, linearLayout, webView, textView, constraintLayoutFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
