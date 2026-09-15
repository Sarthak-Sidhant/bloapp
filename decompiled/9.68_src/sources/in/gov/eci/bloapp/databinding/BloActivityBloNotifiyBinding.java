package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivityBloNotifiyBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final RelativeLayout blaTopLayout;
    public final LinearLayout main;
    public final RecyclerView recyclerViewNoti;
    private final LinearLayout rootView;
    public final TextView textView3;
    public final TextView textView5;
    public final ImageView toolbarButton;

    private BloActivityBloNotifiyBinding(LinearLayout rootView, ImageView backBtnIv, RelativeLayout blaTopLayout, LinearLayout main, RecyclerView recyclerViewNoti, TextView textView3, TextView textView5, ImageView toolbarButton) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.main = main;
        this.recyclerViewNoti = recyclerViewNoti;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbarButton = toolbarButton;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityBloNotifiyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityBloNotifiyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_blo_notifiy, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityBloNotifiyBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (relativeLayout != null) {
                LinearLayout linearLayout = (LinearLayout) rootView;
                i = R.id.recyclerViewNoti;
                RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.recyclerViewNoti);
                if (recyclerViewFindChildViewById != null) {
                    i = R.id.textView3;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                    if (textView != null) {
                        i = R.id.textView5;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                        if (textView2 != null) {
                            i = R.id.toolbar_button;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                            if (imageView2 != null) {
                                return new BloActivityBloNotifiyBinding(linearLayout, imageView, relativeLayout, linearLayout, recyclerViewFindChildViewById, textView, textView2, imageView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
