package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloHouseImageDialogLayoutBinding implements ViewBinding {
    public final ImageView dialogCancelButton;
    public final TextView dialogImageName;
    public final ImageView dialogPersonImage;
    public final CardView imageCard;
    public final FrameLayout imageDialogRoot;
    private final FrameLayout rootView;

    private BloHouseImageDialogLayoutBinding(FrameLayout rootView, ImageView dialogCancelButton, TextView dialogImageName, ImageView dialogPersonImage, CardView imageCard, FrameLayout imageDialogRoot) {
        this.rootView = rootView;
        this.dialogCancelButton = dialogCancelButton;
        this.dialogImageName = dialogImageName;
        this.dialogPersonImage = dialogPersonImage;
        this.imageCard = imageCard;
        this.imageDialogRoot = imageDialogRoot;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloHouseImageDialogLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloHouseImageDialogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_house_image_dialog_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloHouseImageDialogLayoutBinding bind(View rootView) {
        int i = R.id.dialog_cancel_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dialog_cancel_button);
        if (imageView != null) {
            i = R.id.dialog_image_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.dialog_image_name);
            if (textView != null) {
                i = R.id.dialog_person_image;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dialog_person_image);
                if (imageView2 != null) {
                    i = R.id.image_card;
                    CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.image_card);
                    if (cardViewFindChildViewById != null) {
                        FrameLayout frameLayout = (FrameLayout) rootView;
                        return new BloHouseImageDialogLayoutBinding(frameLayout, imageView, textView, imageView2, cardViewFindChildViewById, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
