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
public final class BloClusterNumberDseRvItemBinding implements ViewBinding {
    public final TextView ACPartNO;
    public final TextView SerialNoTv;
    public final TextView acPartnoET;
    public final LinearLayout actionTokenLayout;
    public final TextView actiontokenTv;
    public final TextView actiontokenTv1;
    public final TextView addressEt;
    public final TextView addressTv;
    public final TextView epicNo;
    public final TextView epicNoET;
    public final ImageView imageView9;
    public final ConstraintLayout layout;
    private final ConstraintLayout rootView;
    public final TextView statusCapsule;
    public final View view2;

    private BloClusterNumberDseRvItemBinding(ConstraintLayout rootView, TextView ACPartNO, TextView SerialNoTv, TextView acPartnoET, LinearLayout actionTokenLayout, TextView actiontokenTv, TextView actiontokenTv1, TextView addressEt, TextView addressTv, TextView epicNo, TextView epicNoET, ImageView imageView9, ConstraintLayout layout, TextView statusCapsule, View view2) {
        this.rootView = rootView;
        this.ACPartNO = ACPartNO;
        this.SerialNoTv = SerialNoTv;
        this.acPartnoET = acPartnoET;
        this.actionTokenLayout = actionTokenLayout;
        this.actiontokenTv = actiontokenTv;
        this.actiontokenTv1 = actiontokenTv1;
        this.addressEt = addressEt;
        this.addressTv = addressTv;
        this.epicNo = epicNo;
        this.epicNoET = epicNoET;
        this.imageView9 = imageView9;
        this.layout = layout;
        this.statusCapsule = statusCapsule;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloClusterNumberDseRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloClusterNumberDseRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_cluster_number_dse_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloClusterNumberDseRvItemBinding bind(View rootView) {
        int i = R.id.AC_partNO;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.AC_partNO);
        if (textView != null) {
            i = R.id.Serial_No_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Serial_No_tv);
            if (textView2 != null) {
                i = R.id.ac_partno_ET;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ac_partno_ET);
                if (textView3 != null) {
                    i = R.id.actionToken_layout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.actionToken_layout);
                    if (linearLayout != null) {
                        i = R.id.actiontoken_tv;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.actiontoken_tv);
                        if (textView4 != null) {
                            i = R.id.actiontoken_tv1;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.actiontoken_tv1);
                            if (textView5 != null) {
                                i = R.id.address_et;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_et);
                                if (textView6 != null) {
                                    i = R.id.address_tv;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_tv);
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
                                                    i = 2131364291;
                                                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, 2131364291);
                                                    if (constraintLayoutFindChildViewById != null) {
                                                        i = R.id.statusCapsule;
                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.statusCapsule);
                                                        if (textView10 != null) {
                                                            i = R.id.view2;
                                                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                            if (viewFindChildViewById != null) {
                                                                return new BloClusterNumberDseRvItemBinding((ConstraintLayout) rootView, textView, textView2, textView3, linearLayout, textView4, textView5, textView6, textView7, textView8, textView9, imageView, constraintLayoutFindChildViewById, textView10, viewFindChildViewById);
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
