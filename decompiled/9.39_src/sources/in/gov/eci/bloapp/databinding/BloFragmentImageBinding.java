package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentImageBinding implements ViewBinding {
    public final Button button;
    public final CardView cardView2;
    public final RadioButton checkBox;
    public final RadioButton checkBox2;
    public final RadioButton checkBox3;
    public final RadioButton checkBox4;
    public final LinearLayout checkboxes;
    public final LinearLayout facilities;
    public final ImageView image;
    public final ImageButton imageButton;
    public final RadioGroup radiohead;
    private final ConstraintLayout rootView;
    public final TextView textVieew;
    public final TextView textView;

    private BloFragmentImageBinding(ConstraintLayout rootView, Button button, CardView cardView2, RadioButton checkBox, RadioButton checkBox2, RadioButton checkBox3, RadioButton checkBox4, LinearLayout checkboxes, LinearLayout facilities, ImageView image, ImageButton imageButton, RadioGroup radiohead, TextView textVieew, TextView textView) {
        this.rootView = rootView;
        this.button = button;
        this.cardView2 = cardView2;
        this.checkBox = checkBox;
        this.checkBox2 = checkBox2;
        this.checkBox3 = checkBox3;
        this.checkBox4 = checkBox4;
        this.checkboxes = checkboxes;
        this.facilities = facilities;
        this.image = image;
        this.imageButton = imageButton;
        this.radiohead = radiohead;
        this.textVieew = textVieew;
        this.textView = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentImageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentImageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_image, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentImageBinding bind(View rootView) {
        int i = R.id.button;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.button);
        if (button != null) {
            i = R.id.cardView2;
            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView2);
            if (cardViewFindChildViewById != null) {
                i = R.id.checkBox;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.checkBox);
                if (radioButton != null) {
                    i = R.id.checkBox2;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.checkBox2);
                    if (radioButton2 != null) {
                        i = R.id.checkBox3;
                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.checkBox3);
                        if (radioButton3 != null) {
                            i = R.id.checkBox4;
                            RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.checkBox4);
                            if (radioButton4 != null) {
                                i = R.id.checkboxes;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.checkboxes);
                                if (linearLayout != null) {
                                    i = R.id.facilities;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.facilities);
                                    if (linearLayout2 != null) {
                                        i = 2131364126;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131364126);
                                        if (imageView != null) {
                                            i = R.id.imageButton;
                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.imageButton);
                                            if (imageButton != null) {
                                                i = R.id.radiohead;
                                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.radiohead);
                                                if (radioGroup != null) {
                                                    i = R.id.textVieew;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.textVieew);
                                                    if (textView != null) {
                                                        i = R.id.textView;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView);
                                                        if (textView2 != null) {
                                                            return new BloFragmentImageBinding((ConstraintLayout) rootView, button, cardViewFindChildViewById, radioButton, radioButton2, radioButton3, radioButton4, linearLayout, linearLayout2, imageView, imageButton, radioGroup, textView, textView2);
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
