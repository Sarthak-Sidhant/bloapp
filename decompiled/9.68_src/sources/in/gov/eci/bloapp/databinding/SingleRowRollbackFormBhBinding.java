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
public final class SingleRowRollbackFormBhBinding implements ViewBinding {
    public final TextView acName;
    public final TextView address;
    public final LinearLayout cardViewLL;
    public final TextView electorName;
    public final TextView epic;
    public final TextView markUncollectable;
    public final TextView partNo;
    public final TextView remarks;
    private final LinearLayout rootView;
    public final TextView state;
    public final TextView viewDetails;

    private SingleRowRollbackFormBhBinding(LinearLayout rootView, TextView acName, TextView address, LinearLayout cardViewLL, TextView electorName, TextView epic, TextView markUncollectable, TextView partNo, TextView remarks, TextView state, TextView viewDetails) {
        this.rootView = rootView;
        this.acName = acName;
        this.address = address;
        this.cardViewLL = cardViewLL;
        this.electorName = electorName;
        this.epic = epic;
        this.markUncollectable = markUncollectable;
        this.partNo = partNo;
        this.remarks = remarks;
        this.state = state;
        this.viewDetails = viewDetails;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SingleRowRollbackFormBhBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleRowRollbackFormBhBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_row_rollback_form_bh, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleRowRollbackFormBhBinding bind(View rootView) {
        int i = R.id.acName;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.acName);
        if (textView != null) {
            i = R.id.address;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address);
            if (textView2 != null) {
                i = R.id.cardViewLL;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cardViewLL);
                if (linearLayout != null) {
                    i = R.id.electorName;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName);
                    if (textView3 != null) {
                        i = R.id.epic;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic);
                        if (textView4 != null) {
                            i = R.id.markUncollectable;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.markUncollectable);
                            if (textView5 != null) {
                                i = R.id.partNo;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partNo);
                                if (textView6 != null) {
                                    i = R.id.remarks;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remarks);
                                    if (textView7 != null) {
                                        i = R.id.state;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state);
                                        if (textView8 != null) {
                                            i = R.id.viewDetails;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.viewDetails);
                                            if (textView9 != null) {
                                                return new SingleRowRollbackFormBhBinding((LinearLayout) rootView, textView, textView2, linearLayout, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
