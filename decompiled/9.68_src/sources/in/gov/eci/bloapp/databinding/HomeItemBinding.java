package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class HomeItemBinding implements ViewBinding {
    public final MaterialCardView cardView1;
    public final FrameLayout circleGenderContainer;
    public final TextView genderTV;
    public final ImageView ivCard;
    public final View rectangleGender;
    private final LinearLayout rootView;

    private HomeItemBinding(LinearLayout rootView, MaterialCardView cardView1, FrameLayout circleGenderContainer, TextView genderTV, ImageView ivCard, View rectangleGender) {
        this.rootView = rootView;
        this.cardView1 = cardView1;
        this.circleGenderContainer = circleGenderContainer;
        this.genderTV = genderTV;
        this.ivCard = ivCard;
        this.rectangleGender = rectangleGender;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HomeItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HomeItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.home_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HomeItemBinding bind(View rootView) {
        int i = R.id.cardView1;
        MaterialCardView materialCardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView1);
        if (materialCardViewFindChildViewById != null) {
            i = R.id.circleGender_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.circleGender_container);
            if (frameLayout != null) {
                i = R.id.genderTV;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.genderTV);
                if (textView != null) {
                    i = R.id.iv_card;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_card);
                    if (imageView != null) {
                        i = R.id.rectangleGender;
                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.rectangleGender);
                        if (viewFindChildViewById != null) {
                            return new HomeItemBinding((LinearLayout) rootView, materialCardViewFindChildViewById, frameLayout, textView, imageView, viewFindChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
