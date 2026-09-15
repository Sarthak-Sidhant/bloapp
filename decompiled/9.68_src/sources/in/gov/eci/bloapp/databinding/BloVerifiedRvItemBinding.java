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
public final class BloVerifiedRvItemBinding implements ViewBinding {
    public final TextView HNoTv;
    public final TextView NoOfPeopleTv;
    public final TextView NoOfPeopleValueET;
    public final TextView SerialNoTv;
    public final TextView VerifiedTickTv;
    public final TextView VerifiedTv;
    public final TextView addprop;
    public final TextView apptv;
    public final RelativeLayout button;
    public final LinearLayout layout;
    public final TextView nationalTv;
    private final ConstraintLayout rootView;
    public final TextView secn;
    public final View view2;

    private BloVerifiedRvItemBinding(ConstraintLayout rootView, TextView HNoTv, TextView NoOfPeopleTv, TextView NoOfPeopleValueET, TextView SerialNoTv, TextView VerifiedTickTv, TextView VerifiedTv, TextView addprop, TextView apptv, RelativeLayout button, LinearLayout layout, TextView nationalTv, TextView secn, View view2) {
        this.rootView = rootView;
        this.HNoTv = HNoTv;
        this.NoOfPeopleTv = NoOfPeopleTv;
        this.NoOfPeopleValueET = NoOfPeopleValueET;
        this.SerialNoTv = SerialNoTv;
        this.VerifiedTickTv = VerifiedTickTv;
        this.VerifiedTv = VerifiedTv;
        this.addprop = addprop;
        this.apptv = apptv;
        this.button = button;
        this.layout = layout;
        this.nationalTv = nationalTv;
        this.secn = secn;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloVerifiedRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloVerifiedRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_verified_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloVerifiedRvItemBinding bind(View rootView) {
        int i = R.id.H_No_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.H_No_tv);
        if (textView != null) {
            i = R.id.No_of_people_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.No_of_people_tv);
            if (textView2 != null) {
                i = R.id.No_of_people_value_ET;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.No_of_people_value_ET);
                if (textView3 != null) {
                    i = R.id.Serial_No_tv;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Serial_No_tv);
                    if (textView4 != null) {
                        i = R.id.Verified_tick_tv;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Verified_tick_tv);
                        if (textView5 != null) {
                            i = R.id.Verified_tv;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Verified_tv);
                            if (textView6 != null) {
                                i = R.id.addprop;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.addprop);
                                if (textView7 != null) {
                                    i = R.id.apptv;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.apptv);
                                    if (textView8 != null) {
                                        i = R.id.button;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.button);
                                        if (relativeLayout != null) {
                                            i = 2131364428;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, 2131364428);
                                            if (linearLayout != null) {
                                                i = R.id.national_tv;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.national_tv);
                                                if (textView9 != null) {
                                                    i = R.id.secn;
                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.secn);
                                                    if (textView10 != null) {
                                                        i = R.id.view2;
                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                        if (viewFindChildViewById != null) {
                                                            return new BloVerifiedRvItemBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, relativeLayout, linearLayout, textView9, textView10, viewFindChildViewById);
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
