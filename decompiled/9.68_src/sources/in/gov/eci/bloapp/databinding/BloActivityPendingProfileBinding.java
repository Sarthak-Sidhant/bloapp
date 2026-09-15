package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivityPendingProfileBinding implements ViewBinding {
    public final TextView assembly5;
    public final TextView assembly5Value;
    public final ImageButton backBtnIv;
    public final ImageButton btnAnimation;
    public final LinearLayout card1;
    public final LinearLayout cardView4;
    public final TextView district;
    public final TextView districtValue;
    public final TextView emailId;
    public final TextView firstName;
    public final ImageView homeBtnIv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final ImageView imageView2;
    public final ImageView imageView3;
    public final ImageView imageView8;
    public final TextView mobileNumber;
    public final TextView officeAddress;
    private final FrameLayout rootView;
    public final ScrollView scrollView2;
    public final TextView state;
    public final TextView stateValue;
    public final LinearLayout test6;
    public final TextView textView3;

    private BloActivityPendingProfileBinding(FrameLayout rootView, TextView assembly5, TextView assembly5Value, ImageButton backBtnIv, ImageButton btnAnimation, LinearLayout card1, LinearLayout cardView4, TextView district, TextView districtValue, TextView emailId, TextView firstName, ImageView homeBtnIv, ConstraintLayout homeFragmentTopConstraintLayout, ImageView imageView2, ImageView imageView3, ImageView imageView8, TextView mobileNumber, TextView officeAddress, ScrollView scrollView2, TextView state, TextView stateValue, LinearLayout test6, TextView textView3) {
        this.rootView = rootView;
        this.assembly5 = assembly5;
        this.assembly5Value = assembly5Value;
        this.backBtnIv = backBtnIv;
        this.btnAnimation = btnAnimation;
        this.card1 = card1;
        this.cardView4 = cardView4;
        this.district = district;
        this.districtValue = districtValue;
        this.emailId = emailId;
        this.firstName = firstName;
        this.homeBtnIv = homeBtnIv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.imageView2 = imageView2;
        this.imageView3 = imageView3;
        this.imageView8 = imageView8;
        this.mobileNumber = mobileNumber;
        this.officeAddress = officeAddress;
        this.scrollView2 = scrollView2;
        this.state = state;
        this.stateValue = stateValue;
        this.test6 = test6;
        this.textView3 = textView3;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityPendingProfileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityPendingProfileBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_pending_profile, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityPendingProfileBinding bind(View rootView) {
        int i = R.id.assembly5;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.assembly5);
        if (textView != null) {
            i = R.id.assembly5_value;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.assembly5_value);
            if (textView2 != null) {
                i = R.id.back_btn_iv;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                if (imageButton != null) {
                    i = R.id.btn_animation;
                    ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.btn_animation);
                    if (imageButton2 != null) {
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
                                        i = R.id.email_id;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.email_id);
                                        if (textView5 != null) {
                                            i = R.id.first_name;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name);
                                            if (textView6 != null) {
                                                i = R.id.home_btn_iv;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                                                if (imageView != null) {
                                                    i = R.id.home_fragment_top_constraint_layout;
                                                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                                                    if (constraintLayoutFindChildViewById != null) {
                                                        i = R.id.imageView2;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView2);
                                                        if (imageView2 != null) {
                                                            i = R.id.imageView3;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView3);
                                                            if (imageView3 != null) {
                                                                i = R.id.imageView8;
                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView8);
                                                                if (imageView4 != null) {
                                                                    i = R.id.mobile_number;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobile_number);
                                                                    if (textView7 != null) {
                                                                        i = R.id.office_address;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.office_address);
                                                                        if (textView8 != null) {
                                                                            i = R.id.scrollView2;
                                                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollView2);
                                                                            if (scrollView != null) {
                                                                                i = R.id.state;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state);
                                                                                if (textView9 != null) {
                                                                                    i = R.id.state_value;
                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_value);
                                                                                    if (textView10 != null) {
                                                                                        i = R.id.test6;
                                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.test6);
                                                                                        if (linearLayout3 != null) {
                                                                                            i = R.id.textView3;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                            if (textView11 != null) {
                                                                                                return new BloActivityPendingProfileBinding((FrameLayout) rootView, textView, textView2, imageButton, imageButton2, linearLayout, linearLayout2, textView3, textView4, textView5, textView6, imageView, constraintLayoutFindChildViewById, imageView2, imageView3, imageView4, textView7, textView8, scrollView, textView9, textView10, linearLayout3, textView11);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
