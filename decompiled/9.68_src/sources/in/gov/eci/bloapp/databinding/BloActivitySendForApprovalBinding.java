package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivitySendForApprovalBinding implements ViewBinding {
    public final TextView dateToday;
    public final TextView home;
    public final NestedScrollView mainScrollView;
    private final ConstraintLayout rootView;
    public final TextView sentApprovalHeader;
    public final TextView sentApprovalHeader2;
    public final ImageView successBtn;
    public final ImageView successBtnBackground;

    private BloActivitySendForApprovalBinding(ConstraintLayout rootView, TextView dateToday, TextView home, NestedScrollView mainScrollView, TextView sentApprovalHeader, TextView sentApprovalHeader2, ImageView successBtn, ImageView successBtnBackground) {
        this.rootView = rootView;
        this.dateToday = dateToday;
        this.home = home;
        this.mainScrollView = mainScrollView;
        this.sentApprovalHeader = sentApprovalHeader;
        this.sentApprovalHeader2 = sentApprovalHeader2;
        this.successBtn = successBtn;
        this.successBtnBackground = successBtnBackground;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivitySendForApprovalBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivitySendForApprovalBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_send_for_approval, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivitySendForApprovalBinding bind(View rootView) {
        int i = R.id.dateToday;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.dateToday);
        if (textView != null) {
            i = 2131364192;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, 2131364192);
            if (textView2 != null) {
                i = R.id.mainScrollView;
                NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.mainScrollView);
                if (nestedScrollViewFindChildViewById != null) {
                    i = R.id.sent_approval_header;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sent_approval_header);
                    if (textView3 != null) {
                        i = R.id.sent_approval_header2;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sent_approval_header2);
                        if (textView4 != null) {
                            i = R.id.successBtn;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.successBtn);
                            if (imageView != null) {
                                i = R.id.successBtnBackground;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.successBtnBackground);
                                if (imageView2 != null) {
                                    return new BloActivitySendForApprovalBinding((ConstraintLayout) rootView, textView, textView2, nestedScrollViewFindChildViewById, textView3, textView4, imageView, imageView2);
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
