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

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentMyProfileApprovalBinding implements ViewBinding {
    public final TextView dateToday;
    public final TextView home;
    public final NestedScrollView mainScrollView;
    public final TextView myProfileEdited;
    private final ConstraintLayout rootView;
    public final TextView sentApprovalHeader;
    public final ImageView successBtn;
    public final ImageView successBtnBackground;

    private BloFragmentMyProfileApprovalBinding(ConstraintLayout rootView, TextView dateToday, TextView home, NestedScrollView mainScrollView, TextView myProfileEdited, TextView sentApprovalHeader, ImageView successBtn, ImageView successBtnBackground) {
        this.rootView = rootView;
        this.dateToday = dateToday;
        this.home = home;
        this.mainScrollView = mainScrollView;
        this.myProfileEdited = myProfileEdited;
        this.sentApprovalHeader = sentApprovalHeader;
        this.successBtn = successBtn;
        this.successBtnBackground = successBtnBackground;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentMyProfileApprovalBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentMyProfileApprovalBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_my_profile_approval, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentMyProfileApprovalBinding bind(View rootView) {
        int i = R.id.dateToday;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.dateToday);
        if (textView != null) {
            i = 2131364061;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, 2131364061);
            if (textView2 != null) {
                i = R.id.mainScrollView;
                NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.mainScrollView);
                if (nestedScrollViewFindChildViewById != null) {
                    i = R.id.myProfileEdited;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.myProfileEdited);
                    if (textView3 != null) {
                        i = R.id.sent_approval_header;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sent_approval_header);
                        if (textView4 != null) {
                            i = R.id.successBtn;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.successBtn);
                            if (imageView != null) {
                                i = R.id.successBtnBackground;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.successBtnBackground);
                                if (imageView2 != null) {
                                    return new BloFragmentMyProfileApprovalBinding((ConstraintLayout) rootView, textView, textView2, nestedScrollViewFindChildViewById, textView3, textView4, imageView, imageView2);
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
