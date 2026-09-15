package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class CallRequestCompletedRvItemBinding implements ViewBinding {
    public final TextView actionDate;
    public final TextView actionDateTv;
    public final TextView dateTv3;
    public final MaterialCardView layout;
    public final TextView mobNoTv;
    public final TextView refNoTv;
    public final TextView refNoTv2;
    public final TextView reqDate;
    public final TextView reqDateTv;
    public final TextView requestNoTv;
    public final TextView requestTv;
    private final ConstraintLayout rootView;
    public final TextView status;
    public final TextView statusValue;
    public final TextView voterNameTv;
    public final TextView voterNameTv2;

    private CallRequestCompletedRvItemBinding(ConstraintLayout rootView, TextView actionDate, TextView actionDateTv, TextView dateTv3, MaterialCardView layout, TextView mobNoTv, TextView refNoTv, TextView refNoTv2, TextView reqDate, TextView reqDateTv, TextView requestNoTv, TextView requestTv, TextView status, TextView statusValue, TextView voterNameTv, TextView voterNameTv2) {
        this.rootView = rootView;
        this.actionDate = actionDate;
        this.actionDateTv = actionDateTv;
        this.dateTv3 = dateTv3;
        this.layout = layout;
        this.mobNoTv = mobNoTv;
        this.refNoTv = refNoTv;
        this.refNoTv2 = refNoTv2;
        this.reqDate = reqDate;
        this.reqDateTv = reqDateTv;
        this.requestNoTv = requestNoTv;
        this.requestTv = requestTv;
        this.status = status;
        this.statusValue = statusValue;
        this.voterNameTv = voterNameTv;
        this.voterNameTv2 = voterNameTv2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CallRequestCompletedRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CallRequestCompletedRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.call_request_completed_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CallRequestCompletedRvItemBinding bind(View rootView) {
        int i = R.id.action_date;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.action_date);
        if (textView != null) {
            i = R.id.action_date_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.action_date_tv);
            if (textView2 != null) {
                i = R.id.date_tv3;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_tv3);
                if (textView3 != null) {
                    i = 2131364291;
                    MaterialCardView materialCardViewFindChildViewById = ViewBindings.findChildViewById(rootView, 2131364291);
                    if (materialCardViewFindChildViewById != null) {
                        i = R.id.mob_no_tv;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mob_no_tv);
                        if (textView4 != null) {
                            i = R.id.ref_no_tv;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv);
                            if (textView5 != null) {
                                i = R.id.ref_no_tv2;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv2);
                                if (textView6 != null) {
                                    i = R.id.req_date;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.req_date);
                                    if (textView7 != null) {
                                        i = R.id.req_date_tv;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.req_date_tv);
                                        if (textView8 != null) {
                                            i = R.id.request_no_tv;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.request_no_tv);
                                            if (textView9 != null) {
                                                i = R.id.request_tv;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.request_tv);
                                                if (textView10 != null) {
                                                    i = R.id.status;
                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.status);
                                                    if (textView11 != null) {
                                                        i = R.id.status_value;
                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.status_value);
                                                        if (textView12 != null) {
                                                            i = R.id.voter_name_tv;
                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.voter_name_tv);
                                                            if (textView13 != null) {
                                                                i = R.id.voter_name_tv2;
                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.voter_name_tv2);
                                                                if (textView14 != null) {
                                                                    return new CallRequestCompletedRvItemBinding((ConstraintLayout) rootView, textView, textView2, textView3, materialCardViewFindChildViewById, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
