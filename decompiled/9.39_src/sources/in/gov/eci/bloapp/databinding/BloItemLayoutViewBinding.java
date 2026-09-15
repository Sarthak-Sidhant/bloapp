package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloItemLayoutViewBinding implements ViewBinding {
    public final View divider1;
    public final AppCompatImageView downArrow;
    public final TextView newTextForms;
    public final TextView newTextFormsBuilder;
    public final LinearLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView textViewMediaForms;
    public final LinearLayout textViewMediaFormsNew;

    private BloItemLayoutViewBinding(ConstraintLayout rootView, View divider1, AppCompatImageView downArrow, TextView newTextForms, TextView newTextFormsBuilder, LinearLayout rootLayout, TextView textViewMediaForms, LinearLayout textViewMediaFormsNew) {
        this.rootView = rootView;
        this.divider1 = divider1;
        this.downArrow = downArrow;
        this.newTextForms = newTextForms;
        this.newTextFormsBuilder = newTextFormsBuilder;
        this.rootLayout = rootLayout;
        this.textViewMediaForms = textViewMediaForms;
        this.textViewMediaFormsNew = textViewMediaFormsNew;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloItemLayoutViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloItemLayoutViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_item_layout_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloItemLayoutViewBinding bind(View rootView) {
        int i = R.id.divider1;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.divider1);
        if (viewFindChildViewById != null) {
            i = R.id.downArrow;
            AppCompatImageView appCompatImageViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.downArrow);
            if (appCompatImageViewFindChildViewById != null) {
                i = R.id.newTextForms;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.newTextForms);
                if (textView != null) {
                    i = R.id.newTextFormsBuilder;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.newTextFormsBuilder);
                    if (textView2 != null) {
                        i = R.id.rootLayout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rootLayout);
                        if (linearLayout != null) {
                            i = R.id.textView_media_forms;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_media_forms);
                            if (textView3 != null) {
                                i = R.id.textView_media_forms_new;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.textView_media_forms_new);
                                if (linearLayout2 != null) {
                                    return new BloItemLayoutViewBinding((ConstraintLayout) rootView, viewFindChildViewById, appCompatImageViewFindChildViewById, textView, textView2, linearLayout, textView3, linearLayout2);
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
