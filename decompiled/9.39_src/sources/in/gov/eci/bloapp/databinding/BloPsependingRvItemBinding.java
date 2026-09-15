package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloPsependingRvItemBinding implements ViewBinding {
    public final TextView HNoTv;
    public final TextView SerialNoTv;
    public final ConstraintLayout layout;
    public final TextView nationalTv;
    private final ConstraintLayout rootView;
    public final View view2;

    private BloPsependingRvItemBinding(ConstraintLayout rootView, TextView HNoTv, TextView SerialNoTv, ConstraintLayout layout, TextView nationalTv, View view2) {
        this.rootView = rootView;
        this.HNoTv = HNoTv;
        this.SerialNoTv = SerialNoTv;
        this.layout = layout;
        this.nationalTv = nationalTv;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloPsependingRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloPsependingRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_psepending_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloPsependingRvItemBinding bind(View rootView) {
        int i = R.id.H_No_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.H_No_tv);
        if (textView != null) {
            i = R.id.Serial_No_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Serial_No_tv);
            if (textView2 != null) {
                i = 2131364291;
                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, 2131364291);
                if (constraintLayoutFindChildViewById != null) {
                    i = R.id.national_tv;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.national_tv);
                    if (textView3 != null) {
                        i = R.id.view2;
                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                        if (viewFindChildViewById != null) {
                            return new BloPsependingRvItemBinding((ConstraintLayout) rootView, textView, textView2, constraintLayoutFindChildViewById, textView3, viewFindChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
