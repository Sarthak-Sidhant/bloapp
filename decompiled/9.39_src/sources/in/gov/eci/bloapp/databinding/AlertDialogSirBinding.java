package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class AlertDialogSirBinding implements ViewBinding {
    public final ConstraintLayout cl1;
    public final TextView info;
    public final AppCompatButton no;
    private final LinearLayout rootView;
    public final TextView tvAddPhoto;
    public final AppCompatButton yes;

    private AlertDialogSirBinding(LinearLayout rootView, ConstraintLayout cl1, TextView info, AppCompatButton no, TextView tvAddPhoto, AppCompatButton yes) {
        this.rootView = rootView;
        this.cl1 = cl1;
        this.info = info;
        this.no = no;
        this.tvAddPhoto = tvAddPhoto;
        this.yes = yes;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AlertDialogSirBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AlertDialogSirBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.alert_dialog_sir, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AlertDialogSirBinding bind(View rootView) {
        int i = R.id.cl1;
        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cl1);
        if (constraintLayoutFindChildViewById != null) {
            i = 2131364212;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, 2131364212);
            if (textView != null) {
                i = R.id.no;
                AppCompatButton appCompatButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.no);
                if (appCompatButtonFindChildViewById != null) {
                    i = R.id.tv_add_photo;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_add_photo);
                    if (textView2 != null) {
                        i = R.id.yes;
                        AppCompatButton appCompatButtonFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.yes);
                        if (appCompatButtonFindChildViewById2 != null) {
                            return new AlertDialogSirBinding((LinearLayout) rootView, constraintLayoutFindChildViewById, textView, appCompatButtonFindChildViewById, textView2, appCompatButtonFindChildViewById2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
