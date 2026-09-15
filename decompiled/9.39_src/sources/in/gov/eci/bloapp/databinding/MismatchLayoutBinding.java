package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class MismatchLayoutBinding implements ViewBinding {
    public final RadioGroup detailsCorrectRg;
    public final EditText noremark;
    public final LinearLayout remarkNo;
    private final LinearLayout rootView;
    public final TextView tvMismatchtext;
    public final RadioButton verifiedNo;
    public final RadioButton verifiedYes;

    private MismatchLayoutBinding(LinearLayout rootView, RadioGroup detailsCorrectRg, EditText noremark, LinearLayout remarkNo, TextView tvMismatchtext, RadioButton verifiedNo, RadioButton verifiedYes) {
        this.rootView = rootView;
        this.detailsCorrectRg = detailsCorrectRg;
        this.noremark = noremark;
        this.remarkNo = remarkNo;
        this.tvMismatchtext = tvMismatchtext;
        this.verifiedNo = verifiedNo;
        this.verifiedYes = verifiedYes;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MismatchLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MismatchLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.mismatch_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MismatchLayoutBinding bind(View rootView) {
        int i = R.id.details_correct_rg;
        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.details_correct_rg);
        if (radioGroup != null) {
            i = R.id.noremark;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.noremark);
            if (editText != null) {
                i = R.id.remarkNo;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.remarkNo);
                if (linearLayout != null) {
                    i = R.id.tv_mismatchtext;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_mismatchtext);
                    if (textView != null) {
                        i = R.id.verified_no;
                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.verified_no);
                        if (radioButton != null) {
                            i = R.id.verified_yes;
                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.verified_yes);
                            if (radioButton2 != null) {
                                return new MismatchLayoutBinding((LinearLayout) rootView, radioGroup, editText, linearLayout, textView, radioButton, radioButton2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
