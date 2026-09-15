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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class NewClusterDetailsDialogBinding implements ViewBinding {
    public final TextView agePendingSir;
    public final LinearLayout ccEf;
    public final TextView electorNamePendingSir;
    public final TextView gender;
    public final ImageView ivCancel;
    public final RecyclerView recyclerViewCluser;
    public final TextView relationNewType;
    public final TextView relativeNamePendingSir;
    private final LinearLayout rootView;
    public final TextView textView24;

    private NewClusterDetailsDialogBinding(LinearLayout rootView, TextView agePendingSir, LinearLayout ccEf, TextView electorNamePendingSir, TextView gender, ImageView ivCancel, RecyclerView recyclerViewCluser, TextView relationNewType, TextView relativeNamePendingSir, TextView textView24) {
        this.rootView = rootView;
        this.agePendingSir = agePendingSir;
        this.ccEf = ccEf;
        this.electorNamePendingSir = electorNamePendingSir;
        this.gender = gender;
        this.ivCancel = ivCancel;
        this.recyclerViewCluser = recyclerViewCluser;
        this.relationNewType = relationNewType;
        this.relativeNamePendingSir = relativeNamePendingSir;
        this.textView24 = textView24;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NewClusterDetailsDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NewClusterDetailsDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.new_cluster_details_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NewClusterDetailsDialogBinding bind(View rootView) {
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
                                i = R.id.relationNewType;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relationNewType);
                                if (textView4 != null) {
                                    i = R.id.relativeName_pending_sir;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relativeName_pending_sir);
                                    if (textView5 != null) {
                                        i = R.id.textView24;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView24);
                                        if (textView6 != null) {
                                            return new NewClusterDetailsDialogBinding((LinearLayout) rootView, textView, linearLayout, textView2, textView3, imageView, recyclerViewFindChildViewById, textView4, textView5, textView6);
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
