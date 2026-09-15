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
public final class BloAllApplicationRvItemBinding implements ViewBinding {
    public final TextView dateTv;
    public final ConstraintLayout layout;
    public final TextView nameTv;
    public final TextView refNoTv;
    public final TextView requestTv;
    private final ConstraintLayout rootView;
    public final TextView statusTv;
    public final View view2;

    private BloAllApplicationRvItemBinding(ConstraintLayout rootView, TextView dateTv, ConstraintLayout layout, TextView nameTv, TextView refNoTv, TextView requestTv, TextView statusTv, View view2) {
        this.rootView = rootView;
        this.dateTv = dateTv;
        this.layout = layout;
        this.nameTv = nameTv;
        this.refNoTv = refNoTv;
        this.requestTv = requestTv;
        this.statusTv = statusTv;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloAllApplicationRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloAllApplicationRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_all_application_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloAllApplicationRvItemBinding bind(View rootView) {
        int i = R.id.date_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_tv);
        if (textView != null) {
            i = 2131364291;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, 2131364291);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.name_tv;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_tv);
                if (textView2 != null) {
                    i = R.id.ref_no_tv;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv);
                    if (textView3 != null) {
                        i = R.id.request_tv;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.request_tv);
                        if (textView4 != null) {
                            i = R.id.status_tv;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.status_tv);
                            if (textView5 != null) {
                                i = R.id.view2;
                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                                if (viewFindChildViewById != null) {
                                    return new BloAllApplicationRvItemBinding((ConstraintLayout) rootView, textView, constraintLayoutFindChildViewById, textView2, textView3, textView4, textView5, viewFindChildViewById);
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
