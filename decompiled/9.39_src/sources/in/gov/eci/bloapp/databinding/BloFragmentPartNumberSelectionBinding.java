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
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentPartNumberSelectionBinding implements ViewBinding {
    public final ImageView imageView3;
    public final ImageView imageView4;
    public final LinearLayout linearLayout5;
    private final ConstraintLayout rootView;
    public final AppCompatAutoCompleteTextView singleSelect;
    public final LinearLayout submit;
    public final TextView textView19;
    public final TextView textView20;
    public final TextView textView21;
    public final TextView textView22;

    private BloFragmentPartNumberSelectionBinding(ConstraintLayout rootView, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout5, AppCompatAutoCompleteTextView singleSelect, LinearLayout submit, TextView textView19, TextView textView20, TextView textView21, TextView textView22) {
        this.rootView = rootView;
        this.imageView3 = imageView3;
        this.imageView4 = imageView4;
        this.linearLayout5 = linearLayout5;
        this.singleSelect = singleSelect;
        this.submit = submit;
        this.textView19 = textView19;
        this.textView20 = textView20;
        this.textView21 = textView21;
        this.textView22 = textView22;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentPartNumberSelectionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentPartNumberSelectionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_part_number_selection, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentPartNumberSelectionBinding bind(View rootView) {
        int i = R.id.imageView3;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView3);
        if (imageView != null) {
            i = R.id.imageView4;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView4);
            if (imageView2 != null) {
                i = R.id.linearLayout5;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout5);
                if (linearLayout != null) {
                    i = R.id.singleSelect;
                    AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.singleSelect);
                    if (appCompatAutoCompleteTextViewFindChildViewById != null) {
                        i = R.id.submit;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.submit);
                        if (linearLayout2 != null) {
                            i = R.id.textView19;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView19);
                            if (textView != null) {
                                i = R.id.textView20;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView20);
                                if (textView2 != null) {
                                    i = R.id.textView21;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView21);
                                    if (textView3 != null) {
                                        i = R.id.textView22;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView22);
                                        if (textView4 != null) {
                                            return new BloFragmentPartNumberSelectionBinding((ConstraintLayout) rootView, imageView, imageView2, linearLayout, appCompatAutoCompleteTextViewFindChildViewById, linearLayout2, textView, textView2, textView3, textView4);
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
