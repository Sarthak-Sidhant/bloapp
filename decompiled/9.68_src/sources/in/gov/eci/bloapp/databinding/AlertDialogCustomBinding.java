package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class AlertDialogCustomBinding implements ViewBinding {
    public final ConstraintLayout cl1;
    private final ConstraintLayout rootView;
    public final TextView tvAddPhoto;
    public final TextView tvCapPhoto;
    public final TextView tvTakePhoto;
    public final View view;
    public final View view2;

    private AlertDialogCustomBinding(ConstraintLayout rootView, ConstraintLayout cl1, TextView tvAddPhoto, TextView tvCapPhoto, TextView tvTakePhoto, View view, View view2) {
        this.rootView = rootView;
        this.cl1 = cl1;
        this.tvAddPhoto = tvAddPhoto;
        this.tvCapPhoto = tvCapPhoto;
        this.tvTakePhoto = tvTakePhoto;
        this.view = view;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AlertDialogCustomBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AlertDialogCustomBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.alert_dialog_custom, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AlertDialogCustomBinding bind(View rootView) {
        int i = R.id.cl1;
        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cl1);
        if (constraintLayoutFindChildViewById != null) {
            i = R.id.tv_add_photo;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_add_photo);
            if (textView != null) {
                i = R.id.tv_cap_photo;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_cap_photo);
                if (textView2 != null) {
                    i = R.id.tv_take_photo;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_take_photo);
                    if (textView3 != null) {
                        i = R.id.view;
                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view);
                        if (viewFindChildViewById != null) {
                            i = R.id.view2;
                            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view2);
                            if (viewFindChildViewById2 != null) {
                                return new AlertDialogCustomBinding((ConstraintLayout) rootView, constraintLayoutFindChildViewById, textView, textView2, textView3, viewFindChildViewById, viewFindChildViewById2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
