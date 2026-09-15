package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentForm8PoolingQueBinding implements ViewBinding {
    public final RadioButton noRb;
    public final RadioGroup partDetailRg;
    public final LinearLayout poolingQuestion;
    private final ConstraintLayout rootView;
    public final RadioButton yesRb;

    private BloFragmentForm8PoolingQueBinding(ConstraintLayout rootView, RadioButton noRb, RadioGroup partDetailRg, LinearLayout poolingQuestion, RadioButton yesRb) {
        this.rootView = rootView;
        this.noRb = noRb;
        this.partDetailRg = partDetailRg;
        this.poolingQuestion = poolingQuestion;
        this.yesRb = yesRb;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentForm8PoolingQueBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentForm8PoolingQueBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_form8_pooling_que, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentForm8PoolingQueBinding bind(View rootView) {
        int i = R.id.no_rb;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.no_rb);
        if (radioButton != null) {
            i = R.id.part_detail_rg;
            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.part_detail_rg);
            if (radioGroup != null) {
                i = R.id.pooling_question;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pooling_question);
                if (linearLayout != null) {
                    i = R.id.yes_rb;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.yes_rb);
                    if (radioButton2 != null) {
                        return new BloFragmentForm8PoolingQueBinding((ConstraintLayout) rootView, radioButton, radioGroup, linearLayout, radioButton2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
