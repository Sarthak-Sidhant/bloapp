package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityWebLoginBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final Button btScanCode;
    public final ImageView btndesktop;
    public final TextView heading2;
    public final RelativeLayout main;
    public final FrameLayout parentLayout;
    private final RelativeLayout rootView;
    public final LinearLayout scanCode;
    public final TextView textView3;
    public final TextView textView5;
    public final ImageView toolbarButton;

    private ActivityWebLoginBinding(RelativeLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, Button btScanCode, ImageView btndesktop, TextView heading2, RelativeLayout main, FrameLayout parentLayout, LinearLayout scanCode, TextView textView3, TextView textView5, ImageView toolbarButton) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.btScanCode = btScanCode;
        this.btndesktop = btndesktop;
        this.heading2 = heading2;
        this.main = main;
        this.parentLayout = parentLayout;
        this.scanCode = scanCode;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbarButton = toolbarButton;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityWebLoginBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityWebLoginBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_web_login, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWebLoginBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.btScanCode;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btScanCode);
                if (button != null) {
                    i = R.id.btndesktop;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.btndesktop);
                    if (imageView2 != null) {
                        i = R.id.heading2;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.heading2);
                        if (textView != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) rootView;
                            i = R.id.parentLayout;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.parentLayout);
                            if (frameLayout != null) {
                                i = R.id.scanCode;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.scanCode);
                                if (linearLayout != null) {
                                    i = R.id.textView3;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                    if (textView2 != null) {
                                        i = R.id.textView5;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                        if (textView3 != null) {
                                            i = R.id.toolbar_button;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                            if (imageView3 != null) {
                                                return new ActivityWebLoginBinding(relativeLayout, imageView, constraintLayoutFindChildViewById, button, imageView2, textView, relativeLayout, frameLayout, linearLayout, textView2, textView3, imageView3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
