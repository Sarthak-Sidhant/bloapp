package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentLanguageSelectionBinding implements ViewBinding {
    public final TextView backBtnV;
    public final RadioButton education;
    public final RadioButton employment;
    public final ImageView imageView4;
    public final TextView language;
    public final LinearLayout layout;
    public final LinearLayout linearLayout5;
    public final RadioGroup radioparent;
    private final FrameLayout rootView;
    public final AppCompatAutoCompleteTextView singleSelect;
    public final LinearLayout submit;
    public final TextView textView19;
    public final TextInputLayout textlayout;

    private BloFragmentLanguageSelectionBinding(FrameLayout rootView, TextView backBtnV, RadioButton education, RadioButton employment, ImageView imageView4, TextView language, LinearLayout layout, LinearLayout linearLayout5, RadioGroup radioparent, AppCompatAutoCompleteTextView singleSelect, LinearLayout submit, TextView textView19, TextInputLayout textlayout) {
        this.rootView = rootView;
        this.backBtnV = backBtnV;
        this.education = education;
        this.employment = employment;
        this.imageView4 = imageView4;
        this.language = language;
        this.layout = layout;
        this.linearLayout5 = linearLayout5;
        this.radioparent = radioparent;
        this.singleSelect = singleSelect;
        this.submit = submit;
        this.textView19 = textView19;
        this.textlayout = textlayout;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentLanguageSelectionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentLanguageSelectionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_language_selection, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentLanguageSelectionBinding bind(View rootView) {
        int i = R.id.back_btn_v;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.back_btn_v);
        if (textView != null) {
            i = R.id.education;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.education);
            if (radioButton != null) {
                i = R.id.employment;
                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.employment);
                if (radioButton2 != null) {
                    i = R.id.imageView4;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView4);
                    if (imageView != null) {
                        i = R.id.language;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.language);
                        if (textView2 != null) {
                            i = 2131364291;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, 2131364291);
                            if (linearLayout != null) {
                                i = R.id.linearLayout5;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout5);
                                if (linearLayout2 != null) {
                                    i = R.id.radioparent;
                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.radioparent);
                                    if (radioGroup != null) {
                                        i = R.id.singleSelect;
                                        AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.singleSelect);
                                        if (appCompatAutoCompleteTextViewFindChildViewById != null) {
                                            i = R.id.submit;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.submit);
                                            if (linearLayout3 != null) {
                                                i = R.id.textView19;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView19);
                                                if (textView3 != null) {
                                                    i = R.id.textlayout;
                                                    TextInputLayout textInputLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.textlayout);
                                                    if (textInputLayoutFindChildViewById != null) {
                                                        return new BloFragmentLanguageSelectionBinding((FrameLayout) rootView, textView, radioButton, radioButton2, imageView, textView2, linearLayout, linearLayout2, radioGroup, appCompatAutoCompleteTextViewFindChildViewById, linearLayout3, textView3, textInputLayoutFindChildViewById);
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
