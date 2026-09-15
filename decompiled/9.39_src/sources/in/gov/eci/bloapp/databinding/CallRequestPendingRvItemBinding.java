package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class CallRequestPendingRvItemBinding implements ViewBinding {
    public final Button activeButton;
    public final ImageView callRequestElector;
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
    public final Button unavailableButton;
    public final TextView voterNameTv;
    public final TextView voterNameTv2;

    private CallRequestPendingRvItemBinding(ConstraintLayout rootView, Button activeButton, ImageView callRequestElector, TextView dateTv3, MaterialCardView layout, TextView mobNoTv, TextView refNoTv, TextView refNoTv2, TextView reqDate, TextView reqDateTv, TextView requestNoTv, TextView requestTv, Button unavailableButton, TextView voterNameTv, TextView voterNameTv2) {
        this.rootView = rootView;
        this.activeButton = activeButton;
        this.callRequestElector = callRequestElector;
        this.dateTv3 = dateTv3;
        this.layout = layout;
        this.mobNoTv = mobNoTv;
        this.refNoTv = refNoTv;
        this.refNoTv2 = refNoTv2;
        this.reqDate = reqDate;
        this.reqDateTv = reqDateTv;
        this.requestNoTv = requestNoTv;
        this.requestTv = requestTv;
        this.unavailableButton = unavailableButton;
        this.voterNameTv = voterNameTv;
        this.voterNameTv2 = voterNameTv2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CallRequestPendingRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CallRequestPendingRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.call_request_pending_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CallRequestPendingRvItemBinding bind(View rootView) {
        int i = R.id.active_button;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.active_button);
        if (button != null) {
            i = R.id.callRequest_elector;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.callRequest_elector);
            if (imageView != null) {
                i = R.id.date_tv3;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_tv3);
                if (textView != null) {
                    i = 2131364291;
                    MaterialCardView materialCardViewFindChildViewById = ViewBindings.findChildViewById(rootView, 2131364291);
                    if (materialCardViewFindChildViewById != null) {
                        i = R.id.mob_no_tv;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mob_no_tv);
                        if (textView2 != null) {
                            i = R.id.ref_no_tv;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv);
                            if (textView3 != null) {
                                i = R.id.ref_no_tv2;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv2);
                                if (textView4 != null) {
                                    i = R.id.req_date;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.req_date);
                                    if (textView5 != null) {
                                        i = R.id.req_date_tv;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.req_date_tv);
                                        if (textView6 != null) {
                                            i = R.id.request_no_tv;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.request_no_tv);
                                            if (textView7 != null) {
                                                i = R.id.request_tv;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.request_tv);
                                                if (textView8 != null) {
                                                    i = R.id.unavailable_button;
                                                    Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.unavailable_button);
                                                    if (button2 != null) {
                                                        i = R.id.voter_name_tv;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.voter_name_tv);
                                                        if (textView9 != null) {
                                                            i = R.id.voter_name_tv2;
                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.voter_name_tv2);
                                                            if (textView10 != null) {
                                                                return new CallRequestPendingRvItemBinding((ConstraintLayout) rootView, button, imageView, textView, materialCardViewFindChildViewById, textView2, textView3, textView4, textView5, textView6, textView7, textView8, button2, textView9, textView10);
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
