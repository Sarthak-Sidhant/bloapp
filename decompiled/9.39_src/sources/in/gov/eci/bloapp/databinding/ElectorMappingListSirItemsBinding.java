package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ElectorMappingListSirItemsBinding implements ViewBinding {
    public final LinearLayout electorMapingLL;
    public final TextView electorNameElectorSir;
    public final TextView epicElectorSir;
    public final ImageView ivVerified;
    public final LinearLayout lvRemark;
    private final LinearLayout rootView;
    public final TextView serialNoElectorSir;
    public final TextView tvRemark;
    public final TextView txtDeleteElector;
    public final TextView txtMapElector;
    public final TextView txtMapProgny;
    public final TextView txtViewAnomaly;
    public final TextView txtViewProgny;

    private ElectorMappingListSirItemsBinding(LinearLayout rootView, LinearLayout electorMapingLL, TextView electorNameElectorSir, TextView epicElectorSir, ImageView ivVerified, LinearLayout lvRemark, TextView serialNoElectorSir, TextView tvRemark, TextView txtDeleteElector, TextView txtMapElector, TextView txtMapProgny, TextView txtViewAnomaly, TextView txtViewProgny) {
        this.rootView = rootView;
        this.electorMapingLL = electorMapingLL;
        this.electorNameElectorSir = electorNameElectorSir;
        this.epicElectorSir = epicElectorSir;
        this.ivVerified = ivVerified;
        this.lvRemark = lvRemark;
        this.serialNoElectorSir = serialNoElectorSir;
        this.tvRemark = tvRemark;
        this.txtDeleteElector = txtDeleteElector;
        this.txtMapElector = txtMapElector;
        this.txtMapProgny = txtMapProgny;
        this.txtViewAnomaly = txtViewAnomaly;
        this.txtViewProgny = txtViewProgny;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ElectorMappingListSirItemsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ElectorMappingListSirItemsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.elector_mapping_list_sir_items, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ElectorMappingListSirItemsBinding bind(View rootView) {
        int i = R.id.electorMapingLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.electorMapingLL);
        if (linearLayout != null) {
            i = R.id.electorName_elector_sir;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName_elector_sir);
            if (textView != null) {
                i = R.id.epic_elector_sir;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_elector_sir);
                if (textView2 != null) {
                    i = R.id.iv_verified;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_verified);
                    if (imageView != null) {
                        i = R.id.lv_remark;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_remark);
                        if (linearLayout2 != null) {
                            i = R.id.serialNo_elector_sir;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_elector_sir);
                            if (textView3 != null) {
                                i = R.id.tv_remark;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_remark);
                                if (textView4 != null) {
                                    i = R.id.txtDeleteElector;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDeleteElector);
                                    if (textView5 != null) {
                                        i = R.id.txt_map_elector;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_map_elector);
                                        if (textView6 != null) {
                                            i = R.id.txt_map_progny;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_map_progny);
                                            if (textView7 != null) {
                                                i = R.id.txt_view_anomaly;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_view_anomaly);
                                                if (textView8 != null) {
                                                    i = R.id.txt_view_progny;
                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_view_progny);
                                                    if (textView9 != null) {
                                                        return new ElectorMappingListSirItemsBinding((LinearLayout) rootView, linearLayout, textView, textView2, imageView, linearLayout2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
