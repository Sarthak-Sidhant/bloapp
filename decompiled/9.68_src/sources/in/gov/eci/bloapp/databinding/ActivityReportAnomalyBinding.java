package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivityReportAnomalyBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final LinearLayout main;
    public final EditText reasontv;
    private final LinearLayout rootView;
    public final Button submitAnomaly;
    public final TextView textView3;
    public final TextView textView5;
    public final Toolbar toolbar;
    public final ImageView toolbarButton;
    public final TextView toolbarTitle;

    private ActivityReportAnomalyBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, LinearLayout main, EditText reasontv, Button submitAnomaly, TextView textView3, TextView textView5, Toolbar toolbar, ImageView toolbarButton, TextView toolbarTitle) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.main = main;
        this.reasontv = reasontv;
        this.submitAnomaly = submitAnomaly;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbar = toolbar;
        this.toolbarButton = toolbarButton;
        this.toolbarTitle = toolbarTitle;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityReportAnomalyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityReportAnomalyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_report_anomaly, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityReportAnomalyBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                LinearLayout linearLayout = (LinearLayout) rootView;
                i = R.id.reasontv;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.reasontv);
                if (editText != null) {
                    i = R.id.submitAnomaly;
                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submitAnomaly);
                    if (button != null) {
                        i = R.id.textView3;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                        if (textView != null) {
                            i = R.id.textView5;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                            if (textView2 != null) {
                                i = R.id.toolbar;
                                Toolbar toolbarFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.toolbar);
                                if (toolbarFindChildViewById != null) {
                                    i = R.id.toolbar_button;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                    if (imageView2 != null) {
                                        i = R.id.toolbar_title;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbar_title);
                                        if (textView3 != null) {
                                            return new ActivityReportAnomalyBinding(linearLayout, imageView, constraintLayoutFindChildViewById, linearLayout, editText, button, textView, textView2, toolbarFindChildViewById, imageView2, textView3);
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
