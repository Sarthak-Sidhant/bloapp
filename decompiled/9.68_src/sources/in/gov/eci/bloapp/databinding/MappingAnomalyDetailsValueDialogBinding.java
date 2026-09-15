package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class MappingAnomalyDetailsValueDialogBinding implements ViewBinding {
    public final ImageView ivCancel;
    public final EditText noremark;
    public final LinearLayout pendingLL;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final TextView txtSubmit;

    private MappingAnomalyDetailsValueDialogBinding(LinearLayout rootView, ImageView ivCancel, EditText noremark, LinearLayout pendingLL, RecyclerView recyclerView, TextView txtSubmit) {
        this.rootView = rootView;
        this.ivCancel = ivCancel;
        this.noremark = noremark;
        this.pendingLL = pendingLL;
        this.recyclerView = recyclerView;
        this.txtSubmit = txtSubmit;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MappingAnomalyDetailsValueDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MappingAnomalyDetailsValueDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.mapping_anomaly_details_value_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MappingAnomalyDetailsValueDialogBinding bind(View rootView) {
        int i = R.id.iv_cancel;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_cancel);
        if (imageView != null) {
            i = R.id.noremark;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.noremark);
            if (editText != null) {
                i = R.id.pendingLL;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pendingLL);
                if (linearLayout != null) {
                    i = R.id.recyclerView;
                    RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.recyclerView);
                    if (recyclerViewFindChildViewById != null) {
                        i = R.id.txt_submit;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_submit);
                        if (textView != null) {
                            return new MappingAnomalyDetailsValueDialogBinding((LinearLayout) rootView, imageView, editText, linearLayout, recyclerViewFindChildViewById, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
