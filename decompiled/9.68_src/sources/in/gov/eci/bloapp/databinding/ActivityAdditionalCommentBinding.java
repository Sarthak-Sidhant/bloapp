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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivityAdditionalCommentBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final LinearLayout main;
    public final TextView noteTotal;
    public final RecyclerView recyclerViewAdditional;
    private final LinearLayout rootView;
    public final EditText searchAdditional;
    public final TextView textView3;
    public final TextView textView5;
    public final ImageView toolbarButton;
    public final LinearLayout totalLL;
    public final TextView totalTv;

    private ActivityAdditionalCommentBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, LinearLayout main, TextView noteTotal, RecyclerView recyclerViewAdditional, EditText searchAdditional, TextView textView3, TextView textView5, ImageView toolbarButton, LinearLayout totalLL, TextView totalTv) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.main = main;
        this.noteTotal = noteTotal;
        this.recyclerViewAdditional = recyclerViewAdditional;
        this.searchAdditional = searchAdditional;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbarButton = toolbarButton;
        this.totalLL = totalLL;
        this.totalTv = totalTv;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAdditionalCommentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityAdditionalCommentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_additional_comment, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAdditionalCommentBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                LinearLayout linearLayout = (LinearLayout) rootView;
                i = R.id.noteTotal;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.noteTotal);
                if (textView != null) {
                    i = R.id.recyclerViewAdditional;
                    RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.recyclerViewAdditional);
                    if (recyclerViewFindChildViewById != null) {
                        i = R.id.searchAdditional;
                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.searchAdditional);
                        if (editText != null) {
                            i = R.id.textView3;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                            if (textView2 != null) {
                                i = R.id.textView5;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                if (textView3 != null) {
                                    i = R.id.toolbar_button;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                    if (imageView2 != null) {
                                        i = R.id.totalLL;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.totalLL);
                                        if (linearLayout2 != null) {
                                            i = R.id.totalTv;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalTv);
                                            if (textView4 != null) {
                                                return new ActivityAdditionalCommentBinding(linearLayout, imageView, constraintLayoutFindChildViewById, linearLayout, textView, recyclerViewFindChildViewById, editText, textView2, textView3, imageView2, linearLayout2, textView4);
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
