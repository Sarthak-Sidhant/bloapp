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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class CheckDseItemsBinding implements ViewBinding {
    public final TextView ACPartNO;
    public final TextView acnoName;
    public final LinearLayout actionTokenLayout;
    public final TextView addressEt;
    public final TextView addressTv;
    public final LinearLayout detailsLL;
    public final TextView epicNo;
    public final ImageView icon;
    public final ImageView imageView9;
    public final LinearLayout layout;
    public final TextView parnumber;
    private final ConstraintLayout rootView;
    public final View view2;

    private CheckDseItemsBinding(ConstraintLayout rootView, TextView ACPartNO, TextView acnoName, LinearLayout actionTokenLayout, TextView addressEt, TextView addressTv, LinearLayout detailsLL, TextView epicNo, ImageView icon, ImageView imageView9, LinearLayout layout, TextView parnumber, View view2) {
        this.rootView = rootView;
        this.ACPartNO = ACPartNO;
        this.acnoName = acnoName;
        this.actionTokenLayout = actionTokenLayout;
        this.addressEt = addressEt;
        this.addressTv = addressTv;
        this.detailsLL = detailsLL;
        this.epicNo = epicNo;
        this.icon = icon;
        this.imageView9 = imageView9;
        this.layout = layout;
        this.parnumber = parnumber;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CheckDseItemsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CheckDseItemsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.check_dse_items, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CheckDseItemsBinding bind(View rootView) {
        int i = R.id.AC_partNO;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.AC_partNO);
        if (textView != null) {
            i = R.id.acno_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.acno_name);
            if (textView2 != null) {
                i = R.id.actionToken_layout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.actionToken_layout);
                if (linearLayout != null) {
                    i = R.id.address_et;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_et);
                    if (textView3 != null) {
                        i = R.id.address_tv;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_tv);
                        if (textView4 != null) {
                            i = R.id.detailsLL;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.detailsLL);
                            if (linearLayout2 != null) {
                                i = R.id.epic_no;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_no);
                                if (textView5 != null) {
                                    i = 2131364251;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131364251);
                                    if (imageView != null) {
                                        i = R.id.imageView9;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView9);
                                        if (imageView2 != null) {
                                            i = 2131364428;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, 2131364428);
                                            if (linearLayout3 != null) {
                                                i = R.id.parnumber;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.parnumber);
                                                if (textView6 != null) {
                                                    i = R.id.view2;
                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                    if (viewFindChildViewById != null) {
                                                        return new CheckDseItemsBinding((ConstraintLayout) rootView, textView, textView2, linearLayout, textView3, textView4, linearLayout2, textView5, imageView, imageView2, linearLayout3, textView6, viewFindChildViewById);
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
