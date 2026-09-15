package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloAllStatusRvItemsBinding implements ViewBinding {
    public final TextView acNoEd;
    public final TextView applicantNameEd;
    public final LinearLayout divider;
    public final TextView epicNumberEd;
    public final TextView formStatusEd;
    public final TextView formStatusHeader;
    public final TextView h2hMarkingEd;
    public final ConstraintLayout layout;
    private final ConstraintLayout rootView;
    public final TextView serialNumberEd;

    private BloAllStatusRvItemsBinding(ConstraintLayout rootView, TextView acNoEd, TextView applicantNameEd, LinearLayout divider, TextView epicNumberEd, TextView formStatusEd, TextView formStatusHeader, TextView h2hMarkingEd, ConstraintLayout layout, TextView serialNumberEd) {
        this.rootView = rootView;
        this.acNoEd = acNoEd;
        this.applicantNameEd = applicantNameEd;
        this.divider = divider;
        this.epicNumberEd = epicNumberEd;
        this.formStatusEd = formStatusEd;
        this.formStatusHeader = formStatusHeader;
        this.h2hMarkingEd = h2hMarkingEd;
        this.layout = layout;
        this.serialNumberEd = serialNumberEd;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloAllStatusRvItemsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloAllStatusRvItemsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_all_status_rv_items, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloAllStatusRvItemsBinding bind(View rootView) {
        int i = R.id.acNoEd;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.acNoEd);
        if (textView != null) {
            i = R.id.applicantNameEd;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicantNameEd);
            if (textView2 != null) {
                i = R.id.divider;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.divider);
                if (linearLayout != null) {
                    i = R.id.epicNumberEd;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epicNumberEd);
                    if (textView3 != null) {
                        i = R.id.formStatusEd;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.formStatusEd);
                        if (textView4 != null) {
                            i = R.id.formStatusHeader;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.formStatusHeader);
                            if (textView5 != null) {
                                i = R.id.h2hMarkingEd;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.h2hMarkingEd);
                                if (textView6 != null) {
                                    i = 2131364291;
                                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, 2131364291);
                                    if (constraintLayoutFindChildViewById != null) {
                                        i = R.id.serialNumberEd;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNumberEd);
                                        if (textView7 != null) {
                                            return new BloAllStatusRvItemsBinding((ConstraintLayout) rootView, textView, textView2, linearLayout, textView3, textView4, textView5, textView6, constraintLayoutFindChildViewById, textView7);
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
