package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public final class ActivityElectorSelfMappingBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final LinearLayout main;
    public final TextView noteOpen;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final EditText search;
    public final TextView textView3;
    public final ImageView toolbarButton;

    private ActivityElectorSelfMappingBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, LinearLayout main, TextView noteOpen, RecyclerView recyclerView, EditText search, TextView textView3, ImageView toolbarButton) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.main = main;
        this.noteOpen = noteOpen;
        this.recyclerView = recyclerView;
        this.search = search;
        this.textView3 = textView3;
        this.toolbarButton = toolbarButton;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityElectorSelfMappingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityElectorSelfMappingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_elector_self_mapping, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityElectorSelfMappingBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                LinearLayout linearLayout = (LinearLayout) rootView;
                i = R.id.noteOpen;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.noteOpen);
                if (textView != null) {
                    i = R.id.recyclerView;
                    RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.recyclerView);
                    if (recyclerViewFindChildViewById != null) {
                        i = R.id.search;
                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.search);
                        if (editText != null) {
                            i = R.id.textView3;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                            if (textView2 != null) {
                                i = R.id.toolbar_button;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                if (imageView2 != null) {
                                    return new ActivityElectorSelfMappingBinding(linearLayout, imageView, constraintLayoutFindChildViewById, linearLayout, textView, recyclerViewFindChildViewById, editText, textView2, imageView2);
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
