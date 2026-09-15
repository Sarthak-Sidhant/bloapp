package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentTrackStatusButtonBinding implements ViewBinding {
    public final TextView areaTv;
    public final ConstraintLayout constraintLayout2;
    public final TextView dateTv;
    public final TextView firstNameTv;
    public final TextView formType;
    public final TextView lastNameTv;
    public final LinearLayout linearLayout2;
    public final LinearLayout linearLayout3;
    public final LinearLayout linearLayout4;
    public final TextView refNoTv;
    private final MotionLayout rootView;
    public final TextView stateTv;
    public final TextView statusTv;
    public final TextView submissiondateTv;
    public final RecyclerView trackStatusBtnRv;

    private BloFragmentTrackStatusButtonBinding(MotionLayout rootView, TextView areaTv, ConstraintLayout constraintLayout2, TextView dateTv, TextView firstNameTv, TextView formType, TextView lastNameTv, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView refNoTv, TextView stateTv, TextView statusTv, TextView submissiondateTv, RecyclerView trackStatusBtnRv) {
        this.rootView = rootView;
        this.areaTv = areaTv;
        this.constraintLayout2 = constraintLayout2;
        this.dateTv = dateTv;
        this.firstNameTv = firstNameTv;
        this.formType = formType;
        this.lastNameTv = lastNameTv;
        this.linearLayout2 = linearLayout2;
        this.linearLayout3 = linearLayout3;
        this.linearLayout4 = linearLayout4;
        this.refNoTv = refNoTv;
        this.stateTv = stateTv;
        this.statusTv = statusTv;
        this.submissiondateTv = submissiondateTv;
        this.trackStatusBtnRv = trackStatusBtnRv;
    }

    public MotionLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentTrackStatusButtonBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentTrackStatusButtonBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_track_status_button, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentTrackStatusButtonBinding bind(View rootView) {
        int i = R.id.area_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.area_tv);
        if (textView != null) {
            i = R.id.constraintLayout2;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.constraintLayout2);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.date_tv;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_tv);
                if (textView2 != null) {
                    i = R.id.first_name_tv;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_tv);
                    if (textView3 != null) {
                        i = R.id.form_type;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_type);
                        if (textView4 != null) {
                            i = R.id.last_name_tv;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.last_name_tv);
                            if (textView5 != null) {
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
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv);
                                            if (textView6 != null) {
                                                i = R.id.state_tv;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv);
                                                if (textView7 != null) {
                                                    i = R.id.status_tv;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.status_tv);
                                                    if (textView8 != null) {
                                                        i = R.id.submissiondate_tv;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submissiondate_tv);
                                                        if (textView9 != null) {
                                                            i = R.id.track_status_btn_rv;
                                                            RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.track_status_btn_rv);
                                                            if (recyclerViewFindChildViewById != null) {
                                                                return new BloFragmentTrackStatusButtonBinding((MotionLayout) rootView, textView, constraintLayoutFindChildViewById, textView2, textView3, textView4, textView5, linearLayout, linearLayout2, linearLayout3, textView6, textView7, textView8, textView9, recyclerViewFindChildViewById);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
