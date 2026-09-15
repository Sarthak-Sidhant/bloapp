package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloDsependingRvItemBinding implements ViewBinding {
    public final TextView HNoTv;
    public final TextView SerialNoTv;
    public final TextView applicantName;
    public final ConstraintLayout layout;
    public final TextView nationalTv;
    private final ConstraintLayout rootView;
    public final TextView textView16;
    public final View view2;

    private BloDsependingRvItemBinding(ConstraintLayout rootView, TextView HNoTv, TextView SerialNoTv, TextView applicantName, ConstraintLayout layout, TextView nationalTv, TextView textView16, View view2) {
        this.rootView = rootView;
        this.HNoTv = HNoTv;
        this.SerialNoTv = SerialNoTv;
        this.applicantName = applicantName;
        this.layout = layout;
        this.nationalTv = nationalTv;
        this.textView16 = textView16;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloDsependingRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloDsependingRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_dsepending_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloDsependingRvItemBinding bind(View rootView) {
        int i = R.id.H_No_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.H_No_tv);
        if (textView != null) {
            i = R.id.Serial_No_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Serial_No_tv);
            if (textView2 != null) {
                i = R.id.applicant_name;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_name);
                if (textView3 != null) {
                    i = 2131364428;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, 2131364428);
                    if (constraintLayoutFindChildViewById != null) {
                        i = R.id.national_tv;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.national_tv);
                        if (textView4 != null) {
                            i = R.id.textView16;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView16);
                            if (textView5 != null) {
                                i = R.id.view2;
                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                                if (viewFindChildViewById != null) {
                                    return new BloDsependingRvItemBinding((ConstraintLayout) rootView, textView, textView2, textView3, constraintLayoutFindChildViewById, textView4, textView5, viewFindChildViewById);
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
