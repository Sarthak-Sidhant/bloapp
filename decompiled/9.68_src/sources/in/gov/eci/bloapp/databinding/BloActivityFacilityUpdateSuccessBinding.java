package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivityFacilityUpdateSuccessBinding implements ViewBinding {
    public final AppCompatButton homeButton;
    public final ImageView imageButton;
    public final LinearLayout linearLayoutForBtns;
    public final NestedScrollView mainScrollView;
    private final ConstraintLayout rootView;
    public final ImageView successBtn;
    public final ImageView successBtnBackground;
    public final TextView textViewSuccessHeader;
    public final TextView title;
    public final ConstraintLayout titleBar;

    private BloActivityFacilityUpdateSuccessBinding(ConstraintLayout rootView, AppCompatButton homeButton, ImageView imageButton, LinearLayout linearLayoutForBtns, NestedScrollView mainScrollView, ImageView successBtn, ImageView successBtnBackground, TextView textViewSuccessHeader, TextView title, ConstraintLayout titleBar) {
        this.rootView = rootView;
        this.homeButton = homeButton;
        this.imageButton = imageButton;
        this.linearLayoutForBtns = linearLayoutForBtns;
        this.mainScrollView = mainScrollView;
        this.successBtn = successBtn;
        this.successBtnBackground = successBtnBackground;
        this.textViewSuccessHeader = textViewSuccessHeader;
        this.title = title;
        this.titleBar = titleBar;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityFacilityUpdateSuccessBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityFacilityUpdateSuccessBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_facility_update_success, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityFacilityUpdateSuccessBinding bind(View rootView) {
        int i = R.id.homeButton;
        AppCompatButton appCompatButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.homeButton);
        if (appCompatButtonFindChildViewById != null) {
            i = R.id.imageButton;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageButton);
            if (imageView != null) {
                i = R.id.linear_layout_for_btns;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_layout_for_btns);
                if (linearLayout != null) {
                    i = R.id.mainScrollView;
                    NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.mainScrollView);
                    if (nestedScrollViewFindChildViewById != null) {
                        i = R.id.successBtn;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.successBtn);
                        if (imageView2 != null) {
                            i = R.id.successBtnBackground;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.successBtnBackground);
                            if (imageView3 != null) {
                                i = R.id.textViewSuccessHeader;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textViewSuccessHeader);
                                if (textView != null) {
                                    i = 2131366420;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, 2131366420);
                                    if (textView2 != null) {
                                        i = R.id.titleBar;
                                        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.titleBar);
                                        if (constraintLayoutFindChildViewById != null) {
                                            return new BloActivityFacilityUpdateSuccessBinding((ConstraintLayout) rootView, appCompatButtonFindChildViewById, imageView, linearLayout, nestedScrollViewFindChildViewById, imageView2, imageView3, textView, textView2, constraintLayoutFindChildViewById);
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
