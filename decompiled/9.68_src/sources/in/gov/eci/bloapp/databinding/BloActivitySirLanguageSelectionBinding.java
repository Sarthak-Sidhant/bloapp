package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivitySirLanguageSelectionBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final LinearLayout layout;
    public final LinearLayout main;
    private final LinearLayout rootView;
    public final AppCompatAutoCompleteTextView singleSelect;
    public final LinearLayout submit;
    public final TextView textView3;
    public final TextView textView5;
    public final TextInputLayout textlayout;
    public final ImageView toolbarButton;

    private BloActivitySirLanguageSelectionBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, LinearLayout layout, LinearLayout main, AppCompatAutoCompleteTextView singleSelect, LinearLayout submit, TextView textView3, TextView textView5, TextInputLayout textlayout, ImageView toolbarButton) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.layout = layout;
        this.main = main;
        this.singleSelect = singleSelect;
        this.submit = submit;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.textlayout = textlayout;
        this.toolbarButton = toolbarButton;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloActivitySirLanguageSelectionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivitySirLanguageSelectionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_sir_language_selection, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivitySirLanguageSelectionBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = 2131364428;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, 2131364428);
                if (linearLayout != null) {
                    LinearLayout linearLayout2 = (LinearLayout) rootView;
                    i = R.id.singleSelect;
                    AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.singleSelect);
                    if (appCompatAutoCompleteTextViewFindChildViewById != null) {
                        i = R.id.submit;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.submit);
                        if (linearLayout3 != null) {
                            i = R.id.textView3;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                            if (textView != null) {
                                i = R.id.textView5;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                if (textView2 != null) {
                                    i = R.id.textlayout;
                                    TextInputLayout textInputLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.textlayout);
                                    if (textInputLayoutFindChildViewById != null) {
                                        i = R.id.toolbar_button;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                        if (imageView2 != null) {
                                            return new BloActivitySirLanguageSelectionBinding(linearLayout2, imageView, constraintLayoutFindChildViewById, linearLayout, linearLayout2, appCompatAutoCompleteTextViewFindChildViewById, linearLayout3, textView, textView2, textInputLayoutFindChildViewById, imageView2);
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
