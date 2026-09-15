package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityPendingElectorsBinding implements ViewBinding {
    public final ImageView IvScanCode;
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final Button btScanCode;
    public final LinearLayout main;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final ConstraintLayout scanCode;
    public final EditText search;
    public final TextView textView3;
    public final TextView textView5;
    public final ImageView toolbarButton;
    public final TextView tvDisclamierSir;

    private ActivityPendingElectorsBinding(LinearLayout rootView, ImageView IvScanCode, ImageView backBtnIv, ConstraintLayout blaTopLayout, Button btScanCode, LinearLayout main, RecyclerView recyclerView, ConstraintLayout scanCode, EditText search, TextView textView3, TextView textView5, ImageView toolbarButton, TextView tvDisclamierSir) {
        this.rootView = rootView;
        this.IvScanCode = IvScanCode;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.btScanCode = btScanCode;
        this.main = main;
        this.recyclerView = recyclerView;
        this.scanCode = scanCode;
        this.search = search;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbarButton = toolbarButton;
        this.tvDisclamierSir = tvDisclamierSir;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPendingElectorsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityPendingElectorsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_pending_electors, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPendingElectorsBinding bind(View rootView) {
        int i = R.id.IvScanCode;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.IvScanCode);
        if (imageView != null) {
            i = R.id.back_btn_iv;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
            if (imageView2 != null) {
                i = R.id.bla_top_layout;
                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
                if (constraintLayoutFindChildViewById != null) {
                    i = R.id.btScanCode;
                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btScanCode);
                    if (button != null) {
                        LinearLayout linearLayout = (LinearLayout) rootView;
                        i = R.id.recyclerView;
                        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.recyclerView);
                        if (recyclerViewFindChildViewById != null) {
                            i = R.id.scanCode;
                            ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.scanCode);
                            if (constraintLayoutFindChildViewById2 != null) {
                                i = R.id.search;
                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.search);
                                if (editText != null) {
                                    i = R.id.textView3;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                    if (textView != null) {
                                        i = R.id.textView5;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                        if (textView2 != null) {
                                            i = R.id.toolbar_button;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                            if (imageView3 != null) {
                                                i = R.id.tv_disclamier_sir;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_disclamier_sir);
                                                if (textView3 != null) {
                                                    return new ActivityPendingElectorsBinding(linearLayout, imageView, imageView2, constraintLayoutFindChildViewById, button, linearLayout, recyclerViewFindChildViewById, constraintLayoutFindChildViewById2, editText, textView, textView2, imageView3, textView3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
