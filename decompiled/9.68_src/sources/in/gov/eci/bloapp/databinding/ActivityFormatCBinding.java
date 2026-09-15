package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivityFormatCBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final MaterialButton fvrpending;
    public final LinearLayout main;
    public final TextView noteOpen;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final EditText search;
    public final CardView searchCV;
    public final LinearLayout searchTabLayout;
    public final MaterialButton submitform;
    public final TextView textView3;
    public final TextView textView5;
    public final ImageView toolbarButton;

    private ActivityFormatCBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, MaterialButton fvrpending, LinearLayout main, TextView noteOpen, RecyclerView recyclerView, EditText search, CardView searchCV, LinearLayout searchTabLayout, MaterialButton submitform, TextView textView3, TextView textView5, ImageView toolbarButton) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.fvrpending = fvrpending;
        this.main = main;
        this.noteOpen = noteOpen;
        this.recyclerView = recyclerView;
        this.search = search;
        this.searchCV = searchCV;
        this.searchTabLayout = searchTabLayout;
        this.submitform = submitform;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbarButton = toolbarButton;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFormatCBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityFormatCBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_format_c, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFormatCBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.fvrpending;
                MaterialButton materialButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.fvrpending);
                if (materialButtonFindChildViewById != null) {
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
                                i = R.id.searchCV;
                                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.searchCV);
                                if (cardViewFindChildViewById != null) {
                                    i = R.id.searchTabLayout;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.searchTabLayout);
                                    if (linearLayout2 != null) {
                                        i = R.id.submitform;
                                        MaterialButton materialButtonFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.submitform);
                                        if (materialButtonFindChildViewById2 != null) {
                                            i = R.id.textView3;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                            if (textView2 != null) {
                                                i = R.id.textView5;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                                if (textView3 != null) {
                                                    i = R.id.toolbar_button;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                    if (imageView2 != null) {
                                                        return new ActivityFormatCBinding(linearLayout, imageView, constraintLayoutFindChildViewById, materialButtonFindChildViewById, linearLayout, textView, recyclerViewFindChildViewById, editText, cardViewFindChildViewById, linearLayout2, materialButtonFindChildViewById2, textView2, textView3, imageView2);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
