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
public final class BloVerifiedListRvItemBinding implements ViewBinding {
    public final TextView dateTv;
    public final TextView dateTv2;
    public final TextView dateTv3;
    public final TextView existingElectorTv;
    public final TextView existingElectorTv2;
    public final TextView formTv;
    public final ConstraintLayout layout;
    public final TextView nameTv;
    public final TextView nameTv2;
    public final TextView refNoTv;
    public final TextView refNoTv2;
    private final ConstraintLayout rootView;
    public final TextView serialNoTv;
    public final View view2;

    private BloVerifiedListRvItemBinding(ConstraintLayout rootView, TextView dateTv, TextView dateTv2, TextView dateTv3, TextView existingElectorTv, TextView existingElectorTv2, TextView formTv, ConstraintLayout layout, TextView nameTv, TextView nameTv2, TextView refNoTv, TextView refNoTv2, TextView serialNoTv, View view2) {
        this.rootView = rootView;
        this.dateTv = dateTv;
        this.dateTv2 = dateTv2;
        this.dateTv3 = dateTv3;
        this.existingElectorTv = existingElectorTv;
        this.existingElectorTv2 = existingElectorTv2;
        this.formTv = formTv;
        this.layout = layout;
        this.nameTv = nameTv;
        this.nameTv2 = nameTv2;
        this.refNoTv = refNoTv;
        this.refNoTv2 = refNoTv2;
        this.serialNoTv = serialNoTv;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloVerifiedListRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloVerifiedListRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_verified_list_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloVerifiedListRvItemBinding bind(View rootView) {
        int i = R.id.date_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_tv);
        if (textView != null) {
            i = R.id.date_tv2;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_tv2);
            if (textView2 != null) {
                i = R.id.date_tv3;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_tv3);
                if (textView3 != null) {
                    i = R.id.existing_elector_tv;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.existing_elector_tv);
                    if (textView4 != null) {
                        i = R.id.existing_elector_tv2;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.existing_elector_tv2);
                        if (textView5 != null) {
                            i = R.id.form_tv;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_tv);
                            if (textView6 != null) {
                                i = 2131364291;
                                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, 2131364291);
                                if (constraintLayoutFindChildViewById != null) {
                                    i = R.id.name_tv;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_tv);
                                    if (textView7 != null) {
                                        i = R.id.name_tv2;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_tv2);
                                        if (textView8 != null) {
                                            i = R.id.ref_no_tv;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv);
                                            if (textView9 != null) {
                                                i = R.id.ref_no_tv2;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv2);
                                                if (textView10 != null) {
                                                    i = R.id.serial_no_tv;
                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serial_no_tv);
                                                    if (textView11 != null) {
                                                        i = R.id.view2;
                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                        if (viewFindChildViewById != null) {
                                                            return new BloVerifiedListRvItemBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6, constraintLayoutFindChildViewById, textView7, textView8, textView9, textView10, textView11, viewFindChildViewById);
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
