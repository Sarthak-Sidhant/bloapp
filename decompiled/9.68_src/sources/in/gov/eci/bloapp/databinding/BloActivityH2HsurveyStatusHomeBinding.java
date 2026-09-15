package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivityH2HsurveyStatusHomeBinding implements ViewBinding {
    public final TextView Form7Status;
    public final LinearLayout Form7StatusLayout;
    public final TextView Form8Status;
    public final LinearLayout Form8StatusLayout;
    public final ImageView back;
    public final ImageView homeBtnIv;
    public final NestedScrollView nested;
    private final ConstraintLayout rootView;
    public final TextView title;
    public final ConstraintLayout titleBar;

    private BloActivityH2HsurveyStatusHomeBinding(ConstraintLayout rootView, TextView Form7Status, LinearLayout Form7StatusLayout, TextView Form8Status, LinearLayout Form8StatusLayout, ImageView back, ImageView homeBtnIv, NestedScrollView nested, TextView title, ConstraintLayout titleBar) {
        this.rootView = rootView;
        this.Form7Status = Form7Status;
        this.Form7StatusLayout = Form7StatusLayout;
        this.Form8Status = Form8Status;
        this.Form8StatusLayout = Form8StatusLayout;
        this.back = back;
        this.homeBtnIv = homeBtnIv;
        this.nested = nested;
        this.title = title;
        this.titleBar = titleBar;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityH2HsurveyStatusHomeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityH2HsurveyStatusHomeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_h2_hsurvey_status_home, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityH2HsurveyStatusHomeBinding bind(View rootView) {
        int i = R.id.Form_7_Status;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.Form_7_Status);
        if (textView != null) {
            i = R.id.Form_7_Status_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.Form_7_Status_layout);
            if (linearLayout != null) {
                i = R.id.Form_8_Status;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Form_8_Status);
                if (textView2 != null) {
                    i = R.id.Form_8_Status_layout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.Form_8_Status_layout);
                    if (linearLayout2 != null) {
                        i = 2131362484;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131362484);
                        if (imageView != null) {
                            i = R.id.home_btn_iv;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                            if (imageView2 != null) {
                                i = R.id.nested;
                                NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.nested);
                                if (nestedScrollViewFindChildViewById != null) {
                                    i = 2131366420;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, 2131366420);
                                    if (textView3 != null) {
                                        i = R.id.titleBar;
                                        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.titleBar);
                                        if (constraintLayoutFindChildViewById != null) {
                                            return new BloActivityH2HsurveyStatusHomeBinding((ConstraintLayout) rootView, textView, linearLayout, textView2, linearLayout2, imageView, imageView2, nestedScrollViewFindChildViewById, textView3, constraintLayoutFindChildViewById);
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
