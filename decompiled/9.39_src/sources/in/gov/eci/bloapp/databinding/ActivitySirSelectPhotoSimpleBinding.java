package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivitySirSelectPhotoSimpleBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final RelativeLayout basicdetailsHeading;
    public final ConstraintLayout blaTopLayout;
    public final MaterialButton btnOk;
    public final ImageView cancel;
    public final CardView cardElector;
    public final CardView cardMale;
    public final CardView cardPhoto2;
    public final LinearLayout ccEf;
    public final TextView chooseFileTv;
    public final TextView electorNamePendingSir;
    public final TextView epicPendingSir;
    public final ImageView image;
    public final ImageView ivMale;
    public final ImageView ivPhoto2;
    public final RadioButton notOkPhoto;
    public final LinearLayout passPhoto;
    public final LinearLayout passPhotoLayout;
    public final TextView photoNameTv2;
    public final TextView photoSize;
    public final RadioButton rbPhoto1;
    public final RadioButton rbPhoto2;
    private final ScrollView rootView;
    public final TextView serialNoPendingSir;
    public final TextView surveyText;
    public final TextView textAge;
    public final TextView textView3;
    public final TextView textView5;
    public final ImageView toolbarButton;
    public final TextView tvErolllable;
    public final TextView tvHeading;

    private ActivitySirSelectPhotoSimpleBinding(ScrollView rootView, ImageView backBtnIv, RelativeLayout basicdetailsHeading, ConstraintLayout blaTopLayout, MaterialButton btnOk, ImageView cancel, CardView cardElector, CardView cardMale, CardView cardPhoto2, LinearLayout ccEf, TextView chooseFileTv, TextView electorNamePendingSir, TextView epicPendingSir, ImageView image, ImageView ivMale, ImageView ivPhoto2, RadioButton notOkPhoto, LinearLayout passPhoto, LinearLayout passPhotoLayout, TextView photoNameTv2, TextView photoSize, RadioButton rbPhoto1, RadioButton rbPhoto2, TextView serialNoPendingSir, TextView surveyText, TextView textAge, TextView textView3, TextView textView5, ImageView toolbarButton, TextView tvErolllable, TextView tvHeading) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.basicdetailsHeading = basicdetailsHeading;
        this.blaTopLayout = blaTopLayout;
        this.btnOk = btnOk;
        this.cancel = cancel;
        this.cardElector = cardElector;
        this.cardMale = cardMale;
        this.cardPhoto2 = cardPhoto2;
        this.ccEf = ccEf;
        this.chooseFileTv = chooseFileTv;
        this.electorNamePendingSir = electorNamePendingSir;
        this.epicPendingSir = epicPendingSir;
        this.image = image;
        this.ivMale = ivMale;
        this.ivPhoto2 = ivPhoto2;
        this.notOkPhoto = notOkPhoto;
        this.passPhoto = passPhoto;
        this.passPhotoLayout = passPhotoLayout;
        this.photoNameTv2 = photoNameTv2;
        this.photoSize = photoSize;
        this.rbPhoto1 = rbPhoto1;
        this.rbPhoto2 = rbPhoto2;
        this.serialNoPendingSir = serialNoPendingSir;
        this.surveyText = surveyText;
        this.textAge = textAge;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbarButton = toolbarButton;
        this.tvErolllable = tvErolllable;
        this.tvHeading = tvHeading;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ActivitySirSelectPhotoSimpleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySirSelectPhotoSimpleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_sir_select_photo_simple, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySirSelectPhotoSimpleBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.basicdetails_heading;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.basicdetails_heading);
            if (relativeLayout != null) {
                i = R.id.bla_top_layout;
                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
                if (constraintLayoutFindChildViewById != null) {
                    i = R.id.btnOk;
                    MaterialButton materialButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.btnOk);
                    if (materialButtonFindChildViewById != null) {
                        i = R.id.cancel;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel);
                        if (imageView2 != null) {
                            i = R.id.card_elector;
                            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.card_elector);
                            if (cardViewFindChildViewById != null) {
                                i = R.id.cardMale;
                                CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.cardMale);
                                if (cardViewFindChildViewById2 != null) {
                                    i = R.id.card_photo2;
                                    CardView cardViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.card_photo2);
                                    if (cardViewFindChildViewById3 != null) {
                                        i = R.id.ccEf;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ccEf);
                                        if (linearLayout != null) {
                                            i = R.id.choose_file_tv;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_tv);
                                            if (textView != null) {
                                                i = R.id.electorName_pending_sir;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName_pending_sir);
                                                if (textView2 != null) {
                                                    i = R.id.epic_pending_sir;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_pending_sir);
                                                    if (textView3 != null) {
                                                        i = 2131364126;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, 2131364126);
                                                        if (imageView3 != null) {
                                                            i = R.id.ivMale;
                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivMale);
                                                            if (imageView4 != null) {
                                                                i = R.id.ivPhoto2;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPhoto2);
                                                                if (imageView5 != null) {
                                                                    i = R.id.not_ok_photo;
                                                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.not_ok_photo);
                                                                    if (radioButton != null) {
                                                                        i = R.id.passPhoto;
                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.passPhoto);
                                                                        if (linearLayout2 != null) {
                                                                            i = R.id.pass_photo_layout;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pass_photo_layout);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.photo_name_tv2;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo_name_tv2);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.photo_size;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo_size);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.rbPhoto1;
                                                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rbPhoto1);
                                                                                        if (radioButton2 != null) {
                                                                                            i = R.id.rbPhoto2;
                                                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rbPhoto2);
                                                                                            if (radioButton3 != null) {
                                                                                                i = R.id.serialNo_pending_sir;
                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_pending_sir);
                                                                                                if (textView6 != null) {
                                                                                                    i = R.id.survey_text;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.survey_text);
                                                                                                    if (textView7 != null) {
                                                                                                        i = R.id.text_age;
                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.text_age);
                                                                                                        if (textView8 != null) {
                                                                                                            i = R.id.textView3;
                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                            if (textView9 != null) {
                                                                                                                i = R.id.textView5;
                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                                                                                                if (textView10 != null) {
                                                                                                                    i = R.id.toolbar_button;
                                                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                                                                                    if (imageView6 != null) {
                                                                                                                        i = R.id.tv_erolllable;
                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_erolllable);
                                                                                                                        if (textView11 != null) {
                                                                                                                            i = R.id.tvHeading;
                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvHeading);
                                                                                                                            if (textView12 != null) {
                                                                                                                                return new ActivitySirSelectPhotoSimpleBinding((ScrollView) rootView, imageView, relativeLayout, constraintLayoutFindChildViewById, materialButtonFindChildViewById, imageView2, cardViewFindChildViewById, cardViewFindChildViewById2, cardViewFindChildViewById3, linearLayout, textView, textView2, textView3, imageView3, imageView4, imageView5, radioButton, linearLayout2, linearLayout3, textView4, textView5, radioButton2, radioButton3, textView6, textView7, textView8, textView9, textView10, imageView6, textView11, textView12);
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
