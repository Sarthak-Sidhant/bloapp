package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivitySirofflineBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final LinearLayout main;
    public final TextView noteOpen;
    public final TextView pendingCount;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final TextView submissionIcon;
    public final TextView textView3;
    public final Toolbar toolbar;
    public final ImageView toolbarButton;
    public final TextView txtNote;

    private ActivitySirofflineBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, LinearLayout main, TextView noteOpen, TextView pendingCount, RecyclerView recyclerView, TextView submissionIcon, TextView textView3, Toolbar toolbar, ImageView toolbarButton, TextView txtNote) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.main = main;
        this.noteOpen = noteOpen;
        this.pendingCount = pendingCount;
        this.recyclerView = recyclerView;
        this.submissionIcon = submissionIcon;
        this.textView3 = textView3;
        this.toolbar = toolbar;
        this.toolbarButton = toolbarButton;
        this.txtNote = txtNote;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySirofflineBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySirofflineBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_siroffline, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySirofflineBinding bind(View rootView) {
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
                    i = R.id.pendingCount;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pendingCount);
                    if (textView2 != null) {
                        i = R.id.recyclerView;
                        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.recyclerView);
                        if (recyclerViewFindChildViewById != null) {
                            i = R.id.submissionIcon;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submissionIcon);
                            if (textView3 != null) {
                                i = R.id.textView3;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                if (textView4 != null) {
                                    i = R.id.toolbar;
                                    Toolbar toolbarFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.toolbar);
                                    if (toolbarFindChildViewById != null) {
                                        i = R.id.toolbar_button;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                        if (imageView2 != null) {
                                            i = R.id.txtNote;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtNote);
                                            if (textView5 != null) {
                                                return new ActivitySirofflineBinding(linearLayout, imageView, constraintLayoutFindChildViewById, linearLayout, textView, textView2, recyclerViewFindChildViewById, textView3, textView4, toolbarFindChildViewById, imageView2, textView5);
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
