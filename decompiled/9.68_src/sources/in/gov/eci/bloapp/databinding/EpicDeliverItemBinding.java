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
public final class EpicDeliverItemBinding implements ViewBinding {
    public final TextView assignEro;
    public final LinearLayout cardViewLL;
    public final TextView epicElectorName;
    public final TextView epicMarkDeliver;
    public final TextView epicNoDeliver;
    public final LinearLayout lvSrNo;
    public final TextView partSerialNo;
    public final TextView refID;
    private final LinearLayout rootView;
    public final TextView tvSrNo;

    private EpicDeliverItemBinding(LinearLayout rootView, TextView assignEro, LinearLayout cardViewLL, TextView epicElectorName, TextView epicMarkDeliver, TextView epicNoDeliver, LinearLayout lvSrNo, TextView partSerialNo, TextView refID, TextView tvSrNo) {
        this.rootView = rootView;
        this.assignEro = assignEro;
        this.cardViewLL = cardViewLL;
        this.epicElectorName = epicElectorName;
        this.epicMarkDeliver = epicMarkDeliver;
        this.epicNoDeliver = epicNoDeliver;
        this.lvSrNo = lvSrNo;
        this.partSerialNo = partSerialNo;
        this.refID = refID;
        this.tvSrNo = tvSrNo;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EpicDeliverItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EpicDeliverItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.epic_deliver_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EpicDeliverItemBinding bind(View rootView) {
        int i = R.id.assign_ero;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.assign_ero);
        if (textView != null) {
            i = R.id.cardViewLL;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cardViewLL);
            if (linearLayout != null) {
                i = R.id.epicElectorName;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epicElectorName);
                if (textView2 != null) {
                    i = R.id.epic_mark_deliver;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_mark_deliver);
                    if (textView3 != null) {
                        i = R.id.epic_no_deliver;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_no_deliver);
                        if (textView4 != null) {
                            i = R.id.lv_srNo;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_srNo);
                            if (linearLayout2 != null) {
                                i = R.id.partSerialNo;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partSerialNo);
                                if (textView5 != null) {
                                    i = R.id.refID;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.refID);
                                    if (textView6 != null) {
                                        i = R.id.tv_srNo;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_srNo);
                                        if (textView7 != null) {
                                            return new EpicDeliverItemBinding((LinearLayout) rootView, textView, linearLayout, textView2, textView3, textView4, linearLayout2, textView5, textView6, textView7);
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
