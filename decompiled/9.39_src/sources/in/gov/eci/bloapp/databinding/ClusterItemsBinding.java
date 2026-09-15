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

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ClusterItemsBinding implements ViewBinding {
    public final TextView ACPartNO;
    public final TextView SerialNoTv;
    public final TextView acnoName;
    public final LinearLayout actionTokenLayout;
    public final TextView addressEt;
    public final TextView addressTv;
    public final TextView epicNo;
    public final ImageView imageView9;
    public final ConstraintLayout layout;
    public final LinearLayout lvWatermark;
    public final TextView parnumber;
    private final ConstraintLayout rootView;
    public final View view2;

    private ClusterItemsBinding(ConstraintLayout rootView, TextView ACPartNO, TextView SerialNoTv, TextView acnoName, LinearLayout actionTokenLayout, TextView addressEt, TextView addressTv, TextView epicNo, ImageView imageView9, ConstraintLayout layout, LinearLayout lvWatermark, TextView parnumber, View view2) {
        this.rootView = rootView;
        this.ACPartNO = ACPartNO;
        this.SerialNoTv = SerialNoTv;
        this.acnoName = acnoName;
        this.actionTokenLayout = actionTokenLayout;
        this.addressEt = addressEt;
        this.addressTv = addressTv;
        this.epicNo = epicNo;
        this.imageView9 = imageView9;
        this.layout = layout;
        this.lvWatermark = lvWatermark;
        this.parnumber = parnumber;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ClusterItemsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ClusterItemsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.cluster_items, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ClusterItemsBinding bind(View rootView) {
        int i = R.id.AC_partNO;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.AC_partNO);
        if (textView != null) {
            i = R.id.Serial_No_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Serial_No_tv);
            if (textView2 != null) {
                i = R.id.acno_name;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.acno_name);
                if (textView3 != null) {
                    i = R.id.actionToken_layout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.actionToken_layout);
                    if (linearLayout != null) {
                        i = R.id.address_et;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_et);
                        if (textView4 != null) {
                            i = R.id.address_tv;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_tv);
                            if (textView5 != null) {
                                i = R.id.epic_no;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_no);
                                if (textView6 != null) {
                                    i = R.id.imageView9;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView9);
                                    if (imageView != null) {
                                        i = 2131364291;
                                        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, 2131364291);
                                        if (constraintLayoutFindChildViewById != null) {
                                            i = R.id.lv_watermark;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_watermark);
                                            if (linearLayout2 != null) {
                                                i = R.id.parnumber;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.parnumber);
                                                if (textView7 != null) {
                                                    i = R.id.view2;
                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                    if (viewFindChildViewById != null) {
                                                        return new ClusterItemsBinding((ConstraintLayout) rootView, textView, textView2, textView3, linearLayout, textView4, textView5, textView6, imageView, constraintLayoutFindChildViewById, linearLayout2, textView7, viewFindChildViewById);
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
