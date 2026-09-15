package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloPseIdentifiedRvItemBinding implements ViewBinding {
    public final TextView ACPartNO;
    public final TextView SerialNoTv;
    public final TextView acPartnoET;
    public final TextView addressEt;
    public final TextView addressTv;
    public final TextView applicantNameET;
    public final TextView applicantNameTv;
    public final TextView epicNo;
    public final TextView epicNoET;
    public final ImageView imageView9;
    public final ConstraintLayout layout;
    private final ConstraintLayout rootView;
    public final LinearLayout statusLayout;
    public final View view2;

    private BloPseIdentifiedRvItemBinding(ConstraintLayout rootView, TextView ACPartNO, TextView SerialNoTv, TextView acPartnoET, TextView addressEt, TextView addressTv, TextView applicantNameET, TextView applicantNameTv, TextView epicNo, TextView epicNoET, ImageView imageView9, ConstraintLayout layout, LinearLayout statusLayout, View view2) {
        this.rootView = rootView;
        this.ACPartNO = ACPartNO;
        this.SerialNoTv = SerialNoTv;
        this.acPartnoET = acPartnoET;
        this.addressEt = addressEt;
        this.addressTv = addressTv;
        this.applicantNameET = applicantNameET;
        this.applicantNameTv = applicantNameTv;
        this.epicNo = epicNo;
        this.epicNoET = epicNoET;
        this.imageView9 = imageView9;
        this.layout = layout;
        this.statusLayout = statusLayout;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloPseIdentifiedRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloPseIdentifiedRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_pse_identified_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloPseIdentifiedRvItemBinding bind(View rootView) {
        int i = R.id.AC_partNO;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.AC_partNO);
        if (textView != null) {
            i = R.id.Serial_No_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Serial_No_tv);
            if (textView2 != null) {
                i = R.id.ac_partno_ET;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ac_partno_ET);
                if (textView3 != null) {
                    i = R.id.address_et;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_et);
                    if (textView4 != null) {
                        i = R.id.address_tv;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_tv);
                        if (textView5 != null) {
                            i = R.id.applicant_name_ET;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_name_ET);
                            if (textView6 != null) {
                                i = R.id.applicant_name_tv;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_name_tv);
                                if (textView7 != null) {
                                    i = R.id.epic_no;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_no);
                                    if (textView8 != null) {
                                        i = R.id.epic_no_ET;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_no_ET);
                                        if (textView9 != null) {
                                            i = R.id.imageView9;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView9);
                                            if (imageView != null) {
                                                i = 2131364428;
                                                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, 2131364428);
                                                if (constraintLayoutFindChildViewById != null) {
                                                    i = R.id.status_layout;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.status_layout);
                                                    if (linearLayout != null) {
                                                        i = R.id.view2;
                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                        if (viewFindChildViewById != null) {
                                                            return new BloPseIdentifiedRvItemBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, imageView, constraintLayoutFindChildViewById, linearLayout, viewFindChildViewById);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
