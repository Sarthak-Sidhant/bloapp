package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloSubmittedListRvItemBinding implements ViewBinding {
    public final ConstraintLayout constraintLayout2;
    public final TextView firstNameTv;
    public final TextView formTypeTv;
    public final LinearLayout linearLayout2;
    public final LinearLayout linearLayout3;
    public final LinearLayout linearLayout4;
    public final TextView refNoTv;
    private final RelativeLayout rootView;
    public final TextView statusTv;

    private BloSubmittedListRvItemBinding(RelativeLayout rootView, ConstraintLayout constraintLayout2, TextView firstNameTv, TextView formTypeTv, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView refNoTv, TextView statusTv) {
        this.rootView = rootView;
        this.constraintLayout2 = constraintLayout2;
        this.firstNameTv = firstNameTv;
        this.formTypeTv = formTypeTv;
        this.linearLayout2 = linearLayout2;
        this.linearLayout3 = linearLayout3;
        this.linearLayout4 = linearLayout4;
        this.refNoTv = refNoTv;
        this.statusTv = statusTv;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BloSubmittedListRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloSubmittedListRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_submitted_list_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloSubmittedListRvItemBinding bind(View rootView) {
        int i = R.id.constraintLayout2;
        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.constraintLayout2);
        if (constraintLayoutFindChildViewById != null) {
            i = R.id.first_name_tv;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_tv);
            if (textView != null) {
                i = R.id.form_type_tv;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_type_tv);
                if (textView2 != null) {
                    i = R.id.linearLayout2;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout2);
                    if (linearLayout != null) {
                        i = R.id.linear_layout3;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_layout3);
                        if (linearLayout2 != null) {
                            i = R.id.linearLayout4;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout4);
                            if (linearLayout3 != null) {
                                i = R.id.ref_no_tv;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv);
                                if (textView3 != null) {
                                    i = R.id.status_tv;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.status_tv);
                                    if (textView4 != null) {
                                        return new BloSubmittedListRvItemBinding((RelativeLayout) rootView, constraintLayoutFindChildViewById, textView, textView2, linearLayout, linearLayout2, linearLayout3, textView3, textView4);
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
