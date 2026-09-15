package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivityFormDataNewBinding implements ViewBinding {
    public final ImageView IvScanCode;
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final Button btScanCode;
    public final LinearLayout colorCodeDetails;
    public final TextView countText;
    public final LinearLayout main;
    public final TextView note3;
    public final TextView note6;
    public final TextView noteOpen;
    public final TextView noteTotal;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final ConstraintLayout scanCode;
    public final EditText search;
    public final Spinner spinner;
    public final TextView textView3;
    public final TextView textView5;
    public final ImageView toolbarButton;
    public final LinearLayout totalLL;
    public final TextView totalTv;

    private ActivityFormDataNewBinding(LinearLayout rootView, ImageView IvScanCode, ImageView backBtnIv, ConstraintLayout blaTopLayout, Button btScanCode, LinearLayout colorCodeDetails, TextView countText, LinearLayout main, TextView note3, TextView note6, TextView noteOpen, TextView noteTotal, RecyclerView recyclerView, ConstraintLayout scanCode, EditText search, Spinner spinner, TextView textView3, TextView textView5, ImageView toolbarButton, LinearLayout totalLL, TextView totalTv) {
        this.rootView = rootView;
        this.IvScanCode = IvScanCode;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.btScanCode = btScanCode;
        this.colorCodeDetails = colorCodeDetails;
        this.countText = countText;
        this.main = main;
        this.note3 = note3;
        this.note6 = note6;
        this.noteOpen = noteOpen;
        this.noteTotal = noteTotal;
        this.recyclerView = recyclerView;
        this.scanCode = scanCode;
        this.search = search;
        this.spinner = spinner;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbarButton = toolbarButton;
        this.totalLL = totalLL;
        this.totalTv = totalTv;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFormDataNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityFormDataNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_form_data_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFormDataNewBinding bind(View rootView) {
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
                        i = R.id.colorCodeDetails;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.colorCodeDetails);
                        if (linearLayout != null) {
                            i = R.id.count_text;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.count_text);
                            if (textView != null) {
                                LinearLayout linearLayout2 = (LinearLayout) rootView;
                                i = R.id.note3;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.note3);
                                if (textView2 != null) {
                                    i = R.id.note6;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.note6);
                                    if (textView3 != null) {
                                        i = R.id.noteOpen;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.noteOpen);
                                        if (textView4 != null) {
                                            i = R.id.noteTotal;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.noteTotal);
                                            if (textView5 != null) {
                                                i = R.id.recyclerView;
                                                RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.recyclerView);
                                                if (recyclerViewFindChildViewById != null) {
                                                    i = R.id.scanCode;
                                                    ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.scanCode);
                                                    if (constraintLayoutFindChildViewById2 != null) {
                                                        i = R.id.search;
                                                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.search);
                                                        if (editText != null) {
                                                            i = R.id.spinner;
                                                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.spinner);
                                                            if (spinner != null) {
                                                                i = R.id.textView3;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                if (textView6 != null) {
                                                                    i = R.id.textView5;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                                                    if (textView7 != null) {
                                                                        i = R.id.toolbar_button;
                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                                        if (imageView3 != null) {
                                                                            i = R.id.totalLL;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.totalLL);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.totalTv;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalTv);
                                                                                if (textView8 != null) {
                                                                                    return new ActivityFormDataNewBinding(linearLayout2, imageView, imageView2, constraintLayoutFindChildViewById, button, linearLayout, textView, linearLayout2, textView2, textView3, textView4, textView5, recyclerViewFindChildViewById, constraintLayoutFindChildViewById2, editText, spinner, textView6, textView7, imageView3, linearLayout3, textView8);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
