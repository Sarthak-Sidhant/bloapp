package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFaqRvBinding implements ViewBinding {
    public final RelativeLayout cardView;
    public final View mainDivider;
    public final View mainDivider1;
    private final LinearLayout rootView;
    public final TextView textAns;
    public final TextView textquestion;

    private BloFaqRvBinding(LinearLayout rootView, RelativeLayout cardView, View mainDivider, View mainDivider1, TextView textAns, TextView textquestion) {
        this.rootView = rootView;
        this.cardView = cardView;
        this.mainDivider = mainDivider;
        this.mainDivider1 = mainDivider1;
        this.textAns = textAns;
        this.textquestion = textquestion;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloFaqRvBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFaqRvBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_faq_rv, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFaqRvBinding bind(View rootView) {
        int i = R.id.cardView;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cardView);
        if (relativeLayout != null) {
            i = R.id.main_divider;
            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.main_divider);
            if (viewFindChildViewById != null) {
                i = R.id.main_divider1;
                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.main_divider1);
                if (viewFindChildViewById2 != null) {
                    i = R.id.textAns;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textAns);
                    if (textView != null) {
                        i = R.id.textquestion;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textquestion);
                        if (textView2 != null) {
                            return new BloFaqRvBinding((LinearLayout) rootView, relativeLayout, viewFindChildViewById, viewFindChildViewById2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
