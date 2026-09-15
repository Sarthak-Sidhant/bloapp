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

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityElectorMappingBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final LinearLayout main;
    public final TextView noteOpen;
    public final TextView recordCount;
    public final RecyclerView recyclerView;
    public final RecyclerView recyclerViewUnmapped;
    private final LinearLayout rootView;
    public final EditText search;
    public final CardView searchCV;
    public final LinearLayout searchTabLayout;
    public final MaterialButton searchUnmapped;
    public final MaterialButton searchmapped;
    public final TextView textView3;
    public final ImageView toolbarButton;

    private ActivityElectorMappingBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, LinearLayout main, TextView noteOpen, TextView recordCount, RecyclerView recyclerView, RecyclerView recyclerViewUnmapped, EditText search, CardView searchCV, LinearLayout searchTabLayout, MaterialButton searchUnmapped, MaterialButton searchmapped, TextView textView3, ImageView toolbarButton) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.main = main;
        this.noteOpen = noteOpen;
        this.recordCount = recordCount;
        this.recyclerView = recyclerView;
        this.recyclerViewUnmapped = recyclerViewUnmapped;
        this.search = search;
        this.searchCV = searchCV;
        this.searchTabLayout = searchTabLayout;
        this.searchUnmapped = searchUnmapped;
        this.searchmapped = searchmapped;
        this.textView3 = textView3;
        this.toolbarButton = toolbarButton;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityElectorMappingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityElectorMappingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_elector_mapping, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityElectorMappingBinding bind(View rootView) {
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
                    i = R.id.recordCount;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.recordCount);
                    if (textView2 != null) {
                        i = R.id.recyclerView;
                        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.recyclerView);
                        if (recyclerViewFindChildViewById != null) {
                            i = R.id.recyclerView_unmapped;
                            RecyclerView recyclerViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.recyclerView_unmapped);
                            if (recyclerViewFindChildViewById2 != null) {
                                i = R.id.search;
                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.search);
                                if (editText != null) {
                                    i = R.id.searchCV;
                                    CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.searchCV);
                                    if (cardViewFindChildViewById != null) {
                                        i = R.id.searchTabLayout;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.searchTabLayout);
                                        if (linearLayout2 != null) {
                                            i = R.id.searchUnmapped;
                                            MaterialButton materialButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.searchUnmapped);
                                            if (materialButtonFindChildViewById != null) {
                                                i = R.id.searchmapped;
                                                MaterialButton materialButtonFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.searchmapped);
                                                if (materialButtonFindChildViewById2 != null) {
                                                    i = R.id.textView3;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                    if (textView3 != null) {
                                                        i = R.id.toolbar_button;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                        if (imageView2 != null) {
                                                            return new ActivityElectorMappingBinding(linearLayout, imageView, constraintLayoutFindChildViewById, linearLayout, textView, textView2, recyclerViewFindChildViewById, recyclerViewFindChildViewById2, editText, cardViewFindChildViewById, linearLayout2, materialButtonFindChildViewById, materialButtonFindChildViewById2, textView3, imageView2);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
