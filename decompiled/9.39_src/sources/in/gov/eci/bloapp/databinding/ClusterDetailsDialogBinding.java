package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ClusterDetailsDialogBinding implements ViewBinding {
    public final TextView agePendingSir;
    public final LinearLayout ccEf;
    public final TextView electorNamePendingSir;
    public final TextView gender;
    public final ImageView ivCancel;
    public final RecyclerView recyclerViewCluser;
    public final TextView relativeNamePendingSir;
    private final LinearLayout rootView;
    public final TextView textView24;

    private ClusterDetailsDialogBinding(LinearLayout rootView, TextView agePendingSir, LinearLayout ccEf, TextView electorNamePendingSir, TextView gender, ImageView ivCancel, RecyclerView recyclerViewCluser, TextView relativeNamePendingSir, TextView textView24) {
        this.rootView = rootView;
        this.agePendingSir = agePendingSir;
        this.ccEf = ccEf;
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

    public static ClusterDetailsDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ClusterDetailsDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.cluster_details_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ClusterDetailsDialogBinding bind(View rootView) {
        int i = R.id.age_pending_sir;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.age_pending_sir);
        if (textView != null) {
            i = R.id.ccEf;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ccEf);
            if (linearLayout != null) {
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
                                        return new ClusterDetailsDialogBinding((LinearLayout) rootView, textView, linearLayout, textView2, textView3, imageView, recyclerViewFindChildViewById, textView4, textView5);
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
