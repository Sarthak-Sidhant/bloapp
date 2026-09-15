package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class SelfProgneyListItemBinding implements ViewBinding {
    public final TextView ageElectorSir;
    public final LinearLayout electorMapingLL;
    public final TextView electorNameElectorSir;
    public final TextView epicElectorSir;
    public final LinearLayout lvRemark;
    private final LinearLayout rootView;
    public final TextView serialNoElectorSir;
    public final TextView tvRemark;
    public final TextView txtDeleteElector;
    public final TextView txtSelfElector;
    public final TextView txtViewAnomaly;

    private SelfProgneyListItemBinding(LinearLayout rootView, TextView ageElectorSir, LinearLayout electorMapingLL, TextView electorNameElectorSir, TextView epicElectorSir, LinearLayout lvRemark, TextView serialNoElectorSir, TextView tvRemark, TextView txtDeleteElector, TextView txtSelfElector, TextView txtViewAnomaly) {
        this.rootView = rootView;
        this.ageElectorSir = ageElectorSir;
        this.electorMapingLL = electorMapingLL;
        this.electorNameElectorSir = electorNameElectorSir;
        this.epicElectorSir = epicElectorSir;
        this.lvRemark = lvRemark;
        this.serialNoElectorSir = serialNoElectorSir;
        this.tvRemark = tvRemark;
        this.txtDeleteElector = txtDeleteElector;
        this.txtSelfElector = txtSelfElector;
        this.txtViewAnomaly = txtViewAnomaly;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SelfProgneyListItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SelfProgneyListItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.self_progney_list_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SelfProgneyListItemBinding bind(View rootView) {
        int i = R.id.age_elector_sir;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.age_elector_sir);
        if (textView != null) {
            i = R.id.electorMapingLL;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.electorMapingLL);
            if (linearLayout != null) {
                i = R.id.electorName_elector_sir;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName_elector_sir);
                if (textView2 != null) {
                    i = R.id.epic_elector_sir;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_elector_sir);
                    if (textView3 != null) {
                        i = R.id.lv_remark;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_remark);
                        if (linearLayout2 != null) {
                            i = R.id.serialNo_elector_sir;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_elector_sir);
                            if (textView4 != null) {
                                i = R.id.tv_remark;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_remark);
                                if (textView5 != null) {
                                    i = R.id.txtDeleteElector;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDeleteElector);
                                    if (textView6 != null) {
                                        i = R.id.txt_self_elector;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_self_elector);
                                        if (textView7 != null) {
                                            i = R.id.txt_view_anomaly;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_view_anomaly);
                                            if (textView8 != null) {
                                                return new SelfProgneyListItemBinding((LinearLayout) rootView, textView, linearLayout, textView2, textView3, linearLayout2, textView4, textView5, textView6, textView7, textView8);
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
