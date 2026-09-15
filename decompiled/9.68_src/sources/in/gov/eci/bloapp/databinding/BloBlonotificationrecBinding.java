package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloBlonotificationrecBinding implements ViewBinding {
    public final View divider1;
    public final TextView newTextForms;
    public final TextView newTextFormsBuilder;
    public final TextView newTextFormsLarge;
    public final LinearLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView textViewMediaForms;
    public final LinearLayout textViewMediaFormsNew;

    private BloBlonotificationrecBinding(ConstraintLayout rootView, View divider1, TextView newTextForms, TextView newTextFormsBuilder, TextView newTextFormsLarge, LinearLayout rootLayout, TextView textViewMediaForms, LinearLayout textViewMediaFormsNew) {
        this.rootView = rootView;
        this.divider1 = divider1;
        this.newTextForms = newTextForms;
        this.newTextFormsBuilder = newTextFormsBuilder;
        this.newTextFormsLarge = newTextFormsLarge;
        this.rootLayout = rootLayout;
        this.textViewMediaForms = textViewMediaForms;
        this.textViewMediaFormsNew = textViewMediaFormsNew;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloBlonotificationrecBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloBlonotificationrecBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_blonotificationrec, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloBlonotificationrecBinding bind(View rootView) {
        int i = R.id.divider1;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.divider1);
        if (viewFindChildViewById != null) {
            i = R.id.newTextForms;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.newTextForms);
            if (textView != null) {
                i = R.id.newTextFormsBuilder;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.newTextFormsBuilder);
                if (textView2 != null) {
                    i = R.id.newTextFormsLarge;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.newTextFormsLarge);
                    if (textView3 != null) {
                        i = R.id.rootLayout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rootLayout);
                        if (linearLayout != null) {
                            i = R.id.textView_media_forms;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_media_forms);
                            if (textView4 != null) {
                                i = R.id.textView_media_forms_new;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.textView_media_forms_new);
                                if (linearLayout2 != null) {
                                    return new BloBlonotificationrecBinding((ConstraintLayout) rootView, viewFindChildViewById, textView, textView2, textView3, linearLayout, textView4, linearLayout2);
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
