package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class NewCustomImageDialogBinding implements ViewBinding {
    public final Button btnCancel;
    private final RelativeLayout rootView;
    public final TextView tvGallery;
    public final TextView tvHeading;
    public final TextView tvTakePhoto;

    private NewCustomImageDialogBinding(RelativeLayout rootView, Button btnCancel, TextView tvGallery, TextView tvHeading, TextView tvTakePhoto) {
        this.rootView = rootView;
        this.btnCancel = btnCancel;
        this.tvGallery = tvGallery;
        this.tvHeading = tvHeading;
        this.tvTakePhoto = tvTakePhoto;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NewCustomImageDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NewCustomImageDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.new_custom_image_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NewCustomImageDialogBinding bind(View rootView) {
        int i = R.id.btnCancel;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btnCancel);
        if (button != null) {
            i = R.id.tvGallery;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvGallery);
            if (textView != null) {
                i = R.id.tvHeading;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvHeading);
                if (textView2 != null) {
                    i = R.id.tvTakePhoto;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvTakePhoto);
                    if (textView3 != null) {
                        return new NewCustomImageDialogBinding((RelativeLayout) rootView, button, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
