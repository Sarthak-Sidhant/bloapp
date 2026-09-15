package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivitySelectPhotoSimpleBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final MaterialButton btnOk;
    public final CardView cardMale;
    public final CardView cardPhoto2;
    public final LinearLayout ccEf;
    public final TextView electorNamePendingSir;
    public final TextView epicPendingSir;
    public final ImageView ivMale;
    public final ImageView ivPhoto2;
    public final LinearLayout lvStatus;
    public final LinearLayout lvSubmissionDate;
    public final RadioButton notOkPhoto;
    public final RadioButton rbPhoto1;
    public final RadioButton rbPhoto2;
    private final NestedScrollView rootView;
    public final TextView serialNoPendingSir;
    public final TextView status;
    public final TextView surveyText;
    public final TextView textAge;
    public final TextView textView3;
    public final TextView textView5;
    public final ImageView toolbarButton;
    public final TextView tvFormstatus;
    public final TextView tvHeading;
    public final TextView tvSubmissionDate;

    private ActivitySelectPhotoSimpleBinding(NestedScrollView rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, MaterialButton btnOk, CardView cardMale, CardView cardPhoto2, LinearLayout ccEf, TextView electorNamePendingSir, TextView epicPendingSir, ImageView ivMale, ImageView ivPhoto2, LinearLayout lvStatus, LinearLayout lvSubmissionDate, RadioButton notOkPhoto, RadioButton rbPhoto1, RadioButton rbPhoto2, TextView serialNoPendingSir, TextView status, TextView surveyText, TextView textAge, TextView textView3, TextView textView5, ImageView toolbarButton, TextView tvFormstatus, TextView tvHeading, TextView tvSubmissionDate) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.btnOk = btnOk;
        this.cardMale = cardMale;
        this.cardPhoto2 = cardPhoto2;
        this.ccEf = ccEf;
        this.electorNamePendingSir = electorNamePendingSir;
        this.epicPendingSir = epicPendingSir;
        this.ivMale = ivMale;
        this.ivPhoto2 = ivPhoto2;
        this.lvStatus = lvStatus;
        this.lvSubmissionDate = lvSubmissionDate;
        this.notOkPhoto = notOkPhoto;
        this.rbPhoto1 = rbPhoto1;
        this.rbPhoto2 = rbPhoto2;
        this.serialNoPendingSir = serialNoPendingSir;
        this.status = status;
        this.surveyText = surveyText;
        this.textAge = textAge;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbarButton = toolbarButton;
        this.tvFormstatus = tvFormstatus;
        this.tvHeading = tvHeading;
        this.tvSubmissionDate = tvSubmissionDate;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static ActivitySelectPhotoSimpleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySelectPhotoSimpleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_select_photo_simple, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySelectPhotoSimpleBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.btnOk;
                MaterialButton materialButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.btnOk);
                if (materialButtonFindChildViewById != null) {
                    i = R.id.cardMale;
                    CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardMale);
                    if (cardViewFindChildViewById != null) {
                        i = R.id.card_photo2;
                        CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.card_photo2);
                        if (cardViewFindChildViewById2 != null) {
                            i = R.id.ccEf;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ccEf);
                            if (linearLayout != null) {
                                i = R.id.electorName_pending_sir;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName_pending_sir);
                                if (textView != null) {
                                    i = R.id.epic_pending_sir;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_pending_sir);
                                    if (textView2 != null) {
                                        i = R.id.ivMale;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivMale);
                                        if (imageView2 != null) {
                                            i = R.id.ivPhoto2;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPhoto2);
                                            if (imageView3 != null) {
                                                i = R.id.lv_status;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_status);
                                                if (linearLayout2 != null) {
                                                    i = R.id.lv_submission_date;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_submission_date);
                                                    if (linearLayout3 != null) {
                                                        i = R.id.not_ok_photo;
                                                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.not_ok_photo);
                                                        if (radioButton != null) {
                                                            i = R.id.rbPhoto1;
                                                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rbPhoto1);
                                                            if (radioButton2 != null) {
                                                                i = R.id.rbPhoto2;
                                                                RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rbPhoto2);
                                                                if (radioButton3 != null) {
                                                                    i = R.id.serialNo_pending_sir;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_pending_sir);
                                                                    if (textView3 != null) {
                                                                        i = R.id.status;
                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.status);
                                                                        if (textView4 != null) {
                                                                            i = R.id.survey_text;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.survey_text);
                                                                            if (textView5 != null) {
                                                                                i = R.id.text_age;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.text_age);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.textView3;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.textView5;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.toolbar_button;
                                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                                                            if (imageView4 != null) {
                                                                                                i = R.id.tv_formstatus;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_formstatus);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.tvHeading;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvHeading);
                                                                                                    if (textView10 != null) {
                                                                                                        i = R.id.tv_submission_date;
                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_submission_date);
                                                                                                        if (textView11 != null) {
                                                                                                            return new ActivitySelectPhotoSimpleBinding((NestedScrollView) rootView, imageView, constraintLayoutFindChildViewById, materialButtonFindChildViewById, cardViewFindChildViewById, cardViewFindChildViewById2, linearLayout, textView, textView2, imageView2, imageView3, linearLayout2, linearLayout3, radioButton, radioButton2, radioButton3, textView3, textView4, textView5, textView6, textView7, textView8, imageView4, textView9, textView10, textView11);
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
