package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentMyAccountBinding implements ViewBinding {
    public final TextView assembly5;
    public final TextView assembly5Value;
    public final ImageButton btnAnimation;
    public final LinearLayout card1;
    public final LinearLayout cardView4;
    public final TextView district;
    public final TextView districtValue;
    public final TextView edit;
    public final TextView emailId;
    public final TextView epicNumber;
    public final TextView firstName;
    public final ImageView imageView2;
    public final ImageView imageView3;
    public final ImageView imageView8;
    public final TextView mobileNumber;
    public final TextView officeAddress;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView2;
    public final TextView state;
    public final TextView stateValue;
    public final LinearLayout test6;

    private BloFragmentMyAccountBinding(ConstraintLayout rootView, TextView assembly5, TextView assembly5Value, ImageButton btnAnimation, LinearLayout card1, LinearLayout cardView4, TextView district, TextView districtValue, TextView edit, TextView emailId, TextView epicNumber, TextView firstName, ImageView imageView2, ImageView imageView3, ImageView imageView8, TextView mobileNumber, TextView officeAddress, ScrollView scrollView2, TextView state, TextView stateValue, LinearLayout test6) {
        this.rootView = rootView;
        this.assembly5 = assembly5;
        this.assembly5Value = assembly5Value;
        this.btnAnimation = btnAnimation;
        this.card1 = card1;
        this.cardView4 = cardView4;
        this.district = district;
        this.districtValue = districtValue;
        this.edit = edit;
        this.emailId = emailId;
        this.epicNumber = epicNumber;
        this.firstName = firstName;
        this.imageView2 = imageView2;
        this.imageView3 = imageView3;
        this.imageView8 = imageView8;
        this.mobileNumber = mobileNumber;
        this.officeAddress = officeAddress;
        this.scrollView2 = scrollView2;
        this.state = state;
        this.stateValue = stateValue;
        this.test6 = test6;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentMyAccountBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentMyAccountBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_my_account, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentMyAccountBinding bind(View rootView) {
        int i = R.id.assembly5;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.assembly5);
        if (textView != null) {
            i = R.id.assembly5_value;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.assembly5_value);
            if (textView2 != null) {
                i = R.id.btn_animation;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.btn_animation);
                if (imageButton != null) {
                    i = R.id.card1;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.card1);
                    if (linearLayout != null) {
                        i = R.id.cardView4;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cardView4);
                        if (linearLayout2 != null) {
                            i = R.id.district;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district);
                            if (textView3 != null) {
                                i = R.id.district_value;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_value);
                                if (textView4 != null) {
                                    i = R.id.edit;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.edit);
                                    if (textView5 != null) {
                                        i = R.id.email_id;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.email_id);
                                        if (textView6 != null) {
                                            i = R.id.epic_number;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_number);
                                            if (textView7 != null) {
                                                i = R.id.first_name;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name);
                                                if (textView8 != null) {
                                                    i = R.id.imageView2;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView2);
                                                    if (imageView != null) {
                                                        i = R.id.imageView3;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView3);
                                                        if (imageView2 != null) {
                                                            i = R.id.imageView8;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView8);
                                                            if (imageView3 != null) {
                                                                i = R.id.mobile_number;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobile_number);
                                                                if (textView9 != null) {
                                                                    i = R.id.office_address;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.office_address);
                                                                    if (textView10 != null) {
                                                                        i = R.id.scrollView2;
                                                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollView2);
                                                                        if (scrollView != null) {
                                                                            i = R.id.state;
                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state);
                                                                            if (textView11 != null) {
                                                                                i = R.id.state_value;
                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_value);
                                                                                if (textView12 != null) {
                                                                                    i = R.id.test6;
                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.test6);
                                                                                    if (linearLayout3 != null) {
                                                                                        return new BloFragmentMyAccountBinding((ConstraintLayout) rootView, textView, textView2, imageButton, linearLayout, linearLayout2, textView3, textView4, textView5, textView6, textView7, textView8, imageView, imageView2, imageView3, textView9, textView10, scrollView, textView11, textView12, linearLayout3);
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
