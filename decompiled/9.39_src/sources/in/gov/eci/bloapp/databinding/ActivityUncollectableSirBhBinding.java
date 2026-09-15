package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityUncollectableSirBhBinding implements ViewBinding {
    public final RadioButton absentRb;
    public final RadioButton alreadyEnrolledRb;
    public final LinearLayout alreadyEpicLayout;
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final ImageView cancelEnumerationFormPage1Image;
    public final ImageView cancelEnumerationFormPage2Image;
    public final ImageView cancelSupportingDocumentsPage1Image;
    public final ImageView cancelSupportingDocumentsPage2Image;
    public final RadioButton deadRb;
    public final EditText enterEpicSirTv;
    public final LinearLayout enumerationFormLayout;
    public final LinearLayout enumerationFormPage1;
    public final ImageView enumerationFormPage1Image;
    public final TextView enumerationFormPage1ImageName;
    public final TextView enumerationFormPage1ImageSize;
    public final LinearLayout enumerationFormPage2;
    public final ImageView enumerationFormPage2Image;
    public final TextView enumerationFormPage2ImageName;
    public final TextView enumerationFormPage2ImageSize;
    public final LinearLayout main;
    public final RadioButton permanentRb;
    private final LinearLayout rootView;
    public final Button submitSIR;
    public final LinearLayout supportingDocumentsPage1;
    public final ImageView supportingDocumentsPage1Image;
    public final TextView supportingDocumentsPage1ImageName;
    public final TextView supportingDocumentsPage1ImageSize;
    public final LinearLayout supportingDocumentsPage2;
    public final ImageView supportingDocumentsPage2Image;
    public final TextView supportingDocumentsPage2ImageName;
    public final TextView supportingDocumentsPage2ImageSize;
    public final LinearLayout supprtingDocumentsLayout;
    public final TextView textView3;
    public final RadioGroup uncollectableRG;
    public final TextView uploadEnumerationFormPage1;
    public final TextView uploadEnumerationFormPage2;
    public final TextView uploadSupportingDocumentsPage1;
    public final TextView uploadSupportingDocumentsPage2;

    private ActivityUncollectableSirBhBinding(LinearLayout rootView, RadioButton absentRb, RadioButton alreadyEnrolledRb, LinearLayout alreadyEpicLayout, ImageView backBtnIv, ConstraintLayout blaTopLayout, ImageView cancelEnumerationFormPage1Image, ImageView cancelEnumerationFormPage2Image, ImageView cancelSupportingDocumentsPage1Image, ImageView cancelSupportingDocumentsPage2Image, RadioButton deadRb, EditText enterEpicSirTv, LinearLayout enumerationFormLayout, LinearLayout enumerationFormPage1, ImageView enumerationFormPage1Image, TextView enumerationFormPage1ImageName, TextView enumerationFormPage1ImageSize, LinearLayout enumerationFormPage2, ImageView enumerationFormPage2Image, TextView enumerationFormPage2ImageName, TextView enumerationFormPage2ImageSize, LinearLayout main, RadioButton permanentRb, Button submitSIR, LinearLayout supportingDocumentsPage1, ImageView supportingDocumentsPage1Image, TextView supportingDocumentsPage1ImageName, TextView supportingDocumentsPage1ImageSize, LinearLayout supportingDocumentsPage2, ImageView supportingDocumentsPage2Image, TextView supportingDocumentsPage2ImageName, TextView supportingDocumentsPage2ImageSize, LinearLayout supprtingDocumentsLayout, TextView textView3, RadioGroup uncollectableRG, TextView uploadEnumerationFormPage1, TextView uploadEnumerationFormPage2, TextView uploadSupportingDocumentsPage1, TextView uploadSupportingDocumentsPage2) {
        this.rootView = rootView;
        this.absentRb = absentRb;
        this.alreadyEnrolledRb = alreadyEnrolledRb;
        this.alreadyEpicLayout = alreadyEpicLayout;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.cancelEnumerationFormPage1Image = cancelEnumerationFormPage1Image;
        this.cancelEnumerationFormPage2Image = cancelEnumerationFormPage2Image;
        this.cancelSupportingDocumentsPage1Image = cancelSupportingDocumentsPage1Image;
        this.cancelSupportingDocumentsPage2Image = cancelSupportingDocumentsPage2Image;
        this.deadRb = deadRb;
        this.enterEpicSirTv = enterEpicSirTv;
        this.enumerationFormLayout = enumerationFormLayout;
        this.enumerationFormPage1 = enumerationFormPage1;
        this.enumerationFormPage1Image = enumerationFormPage1Image;
        this.enumerationFormPage1ImageName = enumerationFormPage1ImageName;
        this.enumerationFormPage1ImageSize = enumerationFormPage1ImageSize;
        this.enumerationFormPage2 = enumerationFormPage2;
        this.enumerationFormPage2Image = enumerationFormPage2Image;
        this.enumerationFormPage2ImageName = enumerationFormPage2ImageName;
        this.enumerationFormPage2ImageSize = enumerationFormPage2ImageSize;
        this.main = main;
        this.permanentRb = permanentRb;
        this.submitSIR = submitSIR;
        this.supportingDocumentsPage1 = supportingDocumentsPage1;
        this.supportingDocumentsPage1Image = supportingDocumentsPage1Image;
        this.supportingDocumentsPage1ImageName = supportingDocumentsPage1ImageName;
        this.supportingDocumentsPage1ImageSize = supportingDocumentsPage1ImageSize;
        this.supportingDocumentsPage2 = supportingDocumentsPage2;
        this.supportingDocumentsPage2Image = supportingDocumentsPage2Image;
        this.supportingDocumentsPage2ImageName = supportingDocumentsPage2ImageName;
        this.supportingDocumentsPage2ImageSize = supportingDocumentsPage2ImageSize;
        this.supprtingDocumentsLayout = supprtingDocumentsLayout;
        this.textView3 = textView3;
        this.uncollectableRG = uncollectableRG;
        this.uploadEnumerationFormPage1 = uploadEnumerationFormPage1;
        this.uploadEnumerationFormPage2 = uploadEnumerationFormPage2;
        this.uploadSupportingDocumentsPage1 = uploadSupportingDocumentsPage1;
        this.uploadSupportingDocumentsPage2 = uploadSupportingDocumentsPage2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUncollectableSirBhBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityUncollectableSirBhBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_uncollectable_sir_bh, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityUncollectableSirBhBinding bind(View rootView) {
        int i = R.id.absent_rb;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.absent_rb);
        if (radioButton != null) {
            i = R.id.alreadyEnrolled_rb;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.alreadyEnrolled_rb);
            if (radioButton2 != null) {
                i = R.id.already_epic_layout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.already_epic_layout);
                if (linearLayout != null) {
                    i = R.id.back_btn_iv;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                    if (imageView != null) {
                        i = R.id.bla_top_layout;
                        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
                        if (constraintLayoutFindChildViewById != null) {
                            i = R.id.cancelEnumerationFormPage1Image;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelEnumerationFormPage1Image);
                            if (imageView2 != null) {
                                i = R.id.cancelEnumerationFormPage2Image;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelEnumerationFormPage2Image);
                                if (imageView3 != null) {
                                    i = R.id.cancelSupportingDocumentsPage1Image;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelSupportingDocumentsPage1Image);
                                    if (imageView4 != null) {
                                        i = R.id.cancelSupportingDocumentsPage2Image;
                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelSupportingDocumentsPage2Image);
                                        if (imageView5 != null) {
                                            i = R.id.dead_rb;
                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.dead_rb);
                                            if (radioButton3 != null) {
                                                i = R.id.enter_epic_sir_tv;
                                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.enter_epic_sir_tv);
                                                if (editText != null) {
                                                    i = R.id.enumerationFormLayout;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.enumerationFormLayout);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.enumerationFormPage1;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage1);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.enumerationFormPage1Image;
                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage1Image);
                                                            if (imageView6 != null) {
                                                                i = R.id.enumerationFormPage1ImageName;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage1ImageName);
                                                                if (textView != null) {
                                                                    i = R.id.enumerationFormPage1ImageSize;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage1ImageSize);
                                                                    if (textView2 != null) {
                                                                        i = R.id.enumerationFormPage2;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2);
                                                                        if (linearLayout4 != null) {
                                                                            i = R.id.enumerationFormPage2Image;
                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2Image);
                                                                            if (imageView7 != null) {
                                                                                i = R.id.enumerationFormPage2ImageName;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2ImageName);
                                                                                if (textView3 != null) {
                                                                                    i = R.id.enumerationFormPage2ImageSize;
                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2ImageSize);
                                                                                    if (textView4 != null) {
                                                                                        LinearLayout linearLayout5 = (LinearLayout) rootView;
                                                                                        i = R.id.permanent_rb;
                                                                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.permanent_rb);
                                                                                        if (radioButton4 != null) {
                                                                                            i = R.id.submitSIR;
                                                                                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submitSIR);
                                                                                            if (button != null) {
                                                                                                i = R.id.supportingDocumentsPage1;
                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1);
                                                                                                if (linearLayout6 != null) {
                                                                                                    i = R.id.supportingDocumentsPage1Image;
                                                                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1Image);
                                                                                                    if (imageView8 != null) {
                                                                                                        i = R.id.supportingDocumentsPage1ImageName;
                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1ImageName);
                                                                                                        if (textView5 != null) {
                                                                                                            i = R.id.supportingDocumentsPage1ImageSize;
                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1ImageSize);
                                                                                                            if (textView6 != null) {
                                                                                                                i = R.id.supportingDocumentsPage2;
                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2);
                                                                                                                if (linearLayout7 != null) {
                                                                                                                    i = R.id.supportingDocumentsPage2Image;
                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2Image);
                                                                                                                    if (imageView9 != null) {
                                                                                                                        i = R.id.supportingDocumentsPage2ImageName;
                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2ImageName);
                                                                                                                        if (textView7 != null) {
                                                                                                                            i = R.id.supportingDocumentsPage2ImageSize;
                                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2ImageSize);
                                                                                                                            if (textView8 != null) {
                                                                                                                                i = R.id.supprtingDocumentsLayout;
                                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supprtingDocumentsLayout);
                                                                                                                                if (linearLayout8 != null) {
                                                                                                                                    i = R.id.textView3;
                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                    if (textView9 != null) {
                                                                                                                                        i = R.id.uncollectableRG;
                                                                                                                                        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.uncollectableRG);
                                                                                                                                        if (radioGroup != null) {
                                                                                                                                            i = R.id.uploadEnumerationFormPage1;
                                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadEnumerationFormPage1);
                                                                                                                                            if (textView10 != null) {
                                                                                                                                                i = R.id.uploadEnumerationFormPage2;
                                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadEnumerationFormPage2);
                                                                                                                                                if (textView11 != null) {
                                                                                                                                                    i = R.id.uploadSupportingDocumentsPage1;
                                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadSupportingDocumentsPage1);
                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                        i = R.id.uploadSupportingDocumentsPage2;
                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadSupportingDocumentsPage2);
                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                            return new ActivityUncollectableSirBhBinding(linearLayout5, radioButton, radioButton2, linearLayout, imageView, constraintLayoutFindChildViewById, imageView2, imageView3, imageView4, imageView5, radioButton3, editText, linearLayout2, linearLayout3, imageView6, textView, textView2, linearLayout4, imageView7, textView3, textView4, linearLayout5, radioButton4, button, linearLayout6, imageView8, textView5, textView6, linearLayout7, imageView9, textView7, textView8, linearLayout8, textView9, radioGroup, textView10, textView11, textView12, textView13);
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
