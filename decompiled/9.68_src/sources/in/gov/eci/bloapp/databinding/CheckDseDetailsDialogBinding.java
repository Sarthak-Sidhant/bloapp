package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class CheckDseDetailsDialogBinding implements ViewBinding {
    public final TextView agePendingSir;
    public final LinearLayout ccEf;
    public final RadioButton dseUndertakingNo;
    public final RadioGroup dseUndertakingRg;
    public final RadioButton dseUndertakingYes;
    public final TextView electorNamePendingSir;
    public final TextView gender;
    public final ImageView ivCancel;
    public final RecyclerView recyclerViewCluser;
    public final TextView relativeNamePendingSir;
    private final LinearLayout rootView;
    public final TextView textView24;

    private CheckDseDetailsDialogBinding(LinearLayout rootView, TextView agePendingSir, LinearLayout ccEf, RadioButton dseUndertakingNo, RadioGroup dseUndertakingRg, RadioButton dseUndertakingYes, TextView electorNamePendingSir, TextView gender, ImageView ivCancel, RecyclerView recyclerViewCluser, TextView relativeNamePendingSir, TextView textView24) {
        this.rootView = rootView;
        this.agePendingSir = agePendingSir;
        this.ccEf = ccEf;
        this.dseUndertakingNo = dseUndertakingNo;
        this.dseUndertakingRg = dseUndertakingRg;
        this.dseUndertakingYes = dseUndertakingYes;
        this.electorNamePendingSir = electorNamePendingSir;
        this.gender = gender;
        this.ivCancel = ivCancel;
        this.recyclerViewCluser = recyclerViewCluser;
        this.relativeNamePendingSir = relativeNamePendingSir;
        this.textView24 = textView24;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CheckDseDetailsDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CheckDseDetailsDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.check_dse_details_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CheckDseDetailsDialogBinding bind(View rootView) {
        int i = R.id.age_pending_sir;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.age_pending_sir);
        if (textView != null) {
            i = R.id.ccEf;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ccEf);
            if (linearLayout != null) {
                i = R.id.dse_undertaking_no;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.dse_undertaking_no);
                if (radioButton != null) {
                    i = R.id.dse_undertaking_rg;
                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.dse_undertaking_rg);
                    if (radioGroup != null) {
                        i = R.id.dse_undertaking_yes;
                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.dse_undertaking_yes);
                        if (radioButton2 != null) {
                            i = R.id.electorName_pending_sir;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName_pending_sir);
                            if (textView2 != null) {
                                i = R.id.gender;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender);
                                if (textView3 != null) {
                                    i = R.id.iv_cancel;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_cancel);
                                    if (imageView != null) {
                                        i = R.id.recyclerView_cluser;
                                        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.recyclerView_cluser);
                                        if (recyclerViewFindChildViewById != null) {
                                            i = R.id.relativeName_pending_sir;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relativeName_pending_sir);
                                            if (textView4 != null) {
                                                i = R.id.textView24;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView24);
                                                if (textView5 != null) {
                                                    return new CheckDseDetailsDialogBinding((LinearLayout) rootView, textView, linearLayout, radioButton, radioGroup, radioButton2, textView2, textView3, imageView, recyclerViewFindChildViewById, textView4, textView5);
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
