package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloBottomsheetaadharBinding implements ViewBinding {
    public final Button btnForm6b;
    public final EditText epicNumber;
    public final ImageView imageView;
    public final LinearLayout linearLayout11;
    public final TextView requestFor;
    public final TextView requiredDocs;
    private final ConstraintLayout rootView;
    public final TextView textViewBullet1;

    private BloBottomsheetaadharBinding(ConstraintLayout rootView, Button btnForm6b, EditText epicNumber, ImageView imageView, LinearLayout linearLayout11, TextView requestFor, TextView requiredDocs, TextView textViewBullet1) {
        this.rootView = rootView;
        this.btnForm6b = btnForm6b;
        this.epicNumber = epicNumber;
        this.imageView = imageView;
        this.linearLayout11 = linearLayout11;
        this.requestFor = requestFor;
        this.requiredDocs = requiredDocs;
        this.textViewBullet1 = textViewBullet1;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloBottomsheetaadharBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloBottomsheetaadharBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_bottomsheetaadhar, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloBottomsheetaadharBinding bind(View rootView) {
        int i = R.id.btn_form_6b;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_form_6b);
        if (button != null) {
            i = R.id.epic_number;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.epic_number);
            if (editText != null) {
                i = R.id.imageView;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
                if (imageView != null) {
                    i = R.id.linearLayout11;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout11);
                    if (linearLayout != null) {
                        i = R.id.request_for;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.request_for);
                        if (textView != null) {
                            i = R.id.required_docs;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.required_docs);
                            if (textView2 != null) {
                                i = R.id.textView_bullet1;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView_bullet1);
                                if (textView3 != null) {
                                    return new BloBottomsheetaadharBinding((ConstraintLayout) rootView, button, editText, imageView, linearLayout, textView, textView2, textView3);
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
