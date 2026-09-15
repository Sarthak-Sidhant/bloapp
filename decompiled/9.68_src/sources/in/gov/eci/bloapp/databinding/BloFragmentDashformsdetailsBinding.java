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
public final class BloFragmentDashformsdetailsBinding implements ViewBinding {
    public final TextView currentStatusTv;
    public final TextView currentStatusTv1;
    public final TextView dateTv;
    public final TextView dateTv2;
    public final TextView dateTv3;
    public final TextView formTv;
    public final ConstraintLayout layout;
    public final TextView refNoTv;
    public final TextView refNoTv2;
    private final ConstraintLayout rootView;
    public final TextView serialNoTv;
    public final View view2;

    private BloFragmentDashformsdetailsBinding(ConstraintLayout rootView, TextView currentStatusTv, TextView currentStatusTv1, TextView dateTv, TextView dateTv2, TextView dateTv3, TextView formTv, ConstraintLayout layout, TextView refNoTv, TextView refNoTv2, TextView serialNoTv, View view2) {
        this.rootView = rootView;
        this.currentStatusTv = currentStatusTv;
        this.currentStatusTv1 = currentStatusTv1;
        this.dateTv = dateTv;
        this.dateTv2 = dateTv2;
        this.dateTv3 = dateTv3;
        this.formTv = formTv;
        this.layout = layout;
        this.refNoTv = refNoTv;
        this.refNoTv2 = refNoTv2;
        this.serialNoTv = serialNoTv;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentDashformsdetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentDashformsdetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_dashformsdetails, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentDashformsdetailsBinding bind(View rootView) {
        int i = R.id.current_status_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.current_status_tv);
        if (textView != null) {
            i = R.id.current_status_tv1;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.current_status_tv1);
            if (textView2 != null) {
                i = R.id.date_tv;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_tv);
                if (textView3 != null) {
                    i = R.id.date_tv2;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_tv2);
                    if (textView4 != null) {
                        i = R.id.date_tv3;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_tv3);
                        if (textView5 != null) {
                            i = R.id.form_tv;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_tv);
                            if (textView6 != null) {
                                i = 2131364428;
                                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, 2131364428);
                                if (constraintLayoutFindChildViewById != null) {
                                    i = R.id.ref_no_tv;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv);
                                    if (textView7 != null) {
                                        i = R.id.ref_no_tv2;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv2);
                                        if (textView8 != null) {
                                            i = R.id.serial_no_tv;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serial_no_tv);
                                            if (textView9 != null) {
                                                i = R.id.view2;
                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                if (viewFindChildViewById != null) {
                                                    return new BloFragmentDashformsdetailsBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6, constraintLayoutFindChildViewById, textView7, textView8, textView9, viewFindChildViewById);
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
