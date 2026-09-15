package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloForm8generatedRvItemBinding implements ViewBinding {
    public final TextView HNoTv;
    public final TextView SerialNoTv;
    public final TextView applicantName;
    public final TextView applicantNameTv;
    public final TextView epicnumber;
    public final ConstraintLayout layout;
    public final TextView nationalTv;
    public final TextView referenceno;
    public final TextView referencenoTv;
    private final ConstraintLayout rootView;
    public final TextView textView16;
    public final View view2;

    private BloForm8generatedRvItemBinding(ConstraintLayout rootView, TextView HNoTv, TextView SerialNoTv, TextView applicantName, TextView applicantNameTv, TextView epicnumber, ConstraintLayout layout, TextView nationalTv, TextView referenceno, TextView referencenoTv, TextView textView16, View view2) {
        this.rootView = rootView;
        this.HNoTv = HNoTv;
        this.SerialNoTv = SerialNoTv;
        this.applicantName = applicantName;
        this.applicantNameTv = applicantNameTv;
        this.epicnumber = epicnumber;
        this.layout = layout;
        this.nationalTv = nationalTv;
        this.referenceno = referenceno;
        this.referencenoTv = referencenoTv;
        this.textView16 = textView16;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloForm8generatedRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloForm8generatedRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_form8generated_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloForm8generatedRvItemBinding bind(View rootView) {
        int i = R.id.H_No_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.H_No_tv);
        if (textView != null) {
            i = R.id.Serial_No_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Serial_No_tv);
            if (textView2 != null) {
                i = R.id.applicantName;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicantName);
                if (textView3 != null) {
                    i = R.id.applicantName_tv;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicantName_tv);
                    if (textView4 != null) {
                        i = R.id.epicnumber;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epicnumber);
                        if (textView5 != null) {
                            i = 2131364291;
                            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, 2131364291);
                            if (constraintLayoutFindChildViewById != null) {
                                i = R.id.national_tv;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.national_tv);
                                if (textView6 != null) {
                                    i = R.id.referenceno;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.referenceno);
                                    if (textView7 != null) {
                                        i = R.id.referenceno_tv;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.referenceno_tv);
                                        if (textView8 != null) {
                                            i = R.id.textView16;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView16);
                                            if (textView9 != null) {
                                                i = R.id.view2;
                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                if (viewFindChildViewById != null) {
                                                    return new BloForm8generatedRvItemBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, textView5, constraintLayoutFindChildViewById, textView6, textView7, textView8, textView9, viewFindChildViewById);
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
