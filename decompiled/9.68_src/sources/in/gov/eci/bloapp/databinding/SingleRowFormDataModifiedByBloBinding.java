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
public final class SingleRowFormDataModifiedByBloBinding implements ViewBinding {
    public final TextView acName;
    public final TextView address;
    public final LinearLayout cardViewLL;
    public final TextView documentSubmitted;
    public final TextView electorName;
    public final TextView epic;
    public final TextView partNo;
    private final LinearLayout rootView;
    public final TextView state;
    public final TextView viewDetails;

    private SingleRowFormDataModifiedByBloBinding(LinearLayout rootView, TextView acName, TextView address, LinearLayout cardViewLL, TextView documentSubmitted, TextView electorName, TextView epic, TextView partNo, TextView state, TextView viewDetails) {
        this.rootView = rootView;
        this.acName = acName;
        this.address = address;
        this.cardViewLL = cardViewLL;
        this.documentSubmitted = documentSubmitted;
        this.electorName = electorName;
        this.epic = epic;
        this.partNo = partNo;
        this.state = state;
        this.viewDetails = viewDetails;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SingleRowFormDataModifiedByBloBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleRowFormDataModifiedByBloBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_row_form_data_modified_by_blo, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleRowFormDataModifiedByBloBinding bind(View rootView) {
        int i = R.id.acName;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.acName);
        if (textView != null) {
            i = R.id.address;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address);
            if (textView2 != null) {
                i = R.id.cardViewLL;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cardViewLL);
                if (linearLayout != null) {
                    i = R.id.documentSubmitted;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.documentSubmitted);
                    if (textView3 != null) {
                        i = R.id.electorName;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName);
                        if (textView4 != null) {
                            i = R.id.epic;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic);
                            if (textView5 != null) {
                                i = R.id.partNo;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partNo);
                                if (textView6 != null) {
                                    i = R.id.state;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state);
                                    if (textView7 != null) {
                                        i = R.id.viewDetails;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.viewDetails);
                                        if (textView8 != null) {
                                            return new SingleRowFormDataModifiedByBloBinding((LinearLayout) rootView, textView, textView2, linearLayout, textView3, textView4, textView5, textView6, textView7, textView8);
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
