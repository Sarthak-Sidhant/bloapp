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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivityUncollectableSirBinding implements ViewBinding {
    public final RadioButton absentRb;
    public final RadioButton alreadyEnrolledRb;
    public final LinearLayout alreadyEpicLayout;
    public final ImageView backBtnIv;
    public final ImageView backImage;
    public final ImageView backImage1;
    public final ConstraintLayout blaTopLayout;
    public final ImageView cancelEnumerationFormPage1Image;
    public final ImageView cancelEnumerationFormPage2Image;
    public final ImageView cancelSupportingDocumentsPage1Image;
    public final ImageView cancelSupportingDocumentsPage2Image;
    public final RadioButton deadRb;
    public final ImageView deleteBackImage;
    public final ImageView deleteBackImage1;
    public final ImageView deleteFrontImage;
    public final ImageView deleteFrontImage1;
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
    public final LinearLayout fbImageLL;
    public final LinearLayout fbImageLL1;
    public final LinearLayout firstLL;
    public final LinearLayout firstLL1;
    public final ImageView frontImage;
    public final ImageView frontImage1;
    public final LinearLayout lvPage1EnumrationChoose;
    public final LinearLayout lvPage2EnumrationChoose;
    public final LinearLayout lvSupportChoose1;
    public final LinearLayout lvSupportChoose2;
    public final LinearLayout main;
    public final RadioButton permanentRb;
    public final RelativeLayout reasonHeading;
    public final RadioButton refusedRb;
    public final EditText resontv;
    private final LinearLayout rootView;
    public final LinearLayout secondLL;
    public final LinearLayout secondLL1;
    public final ImageView speakReason;
    public final Button submitSIR;
    public final RelativeLayout supportedDocumentHeading;
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
    public final TextView textView5;
    public final Toolbar toolbar;
    public final ImageView toolbarButton;
    public final TextView toolbarTitle;
    public final RadioGroup uncollectableRG;
    public final TextView uploadEnumerationFormPage1;
    public final TextView uploadEnumerationFormPage2;
    public final TextView uploadEnumratioinPage2;
    public final RelativeLayout uploadEnumrationHeading;
    public final TextView uploadPage1Enumration;
    public final TextView uploadSupportingDocumentsPage1;
    public final TextView uploadSupportingDocumentsPage2;

    private ActivityUncollectableSirBinding(LinearLayout rootView, RadioButton absentRb, RadioButton alreadyEnrolledRb, LinearLayout alreadyEpicLayout, ImageView backBtnIv, ImageView backImage, ImageView backImage1, ConstraintLayout blaTopLayout, ImageView cancelEnumerationFormPage1Image, ImageView cancelEnumerationFormPage2Image, ImageView cancelSupportingDocumentsPage1Image, ImageView cancelSupportingDocumentsPage2Image, RadioButton deadRb, ImageView deleteBackImage, ImageView deleteBackImage1, ImageView deleteFrontImage, ImageView deleteFrontImage1, EditText enterEpicSirTv, LinearLayout enumerationFormLayout, LinearLayout enumerationFormPage1, ImageView enumerationFormPage1Image, TextView enumerationFormPage1ImageName, TextView enumerationFormPage1ImageSize, LinearLayout enumerationFormPage2, ImageView enumerationFormPage2Image, TextView enumerationFormPage2ImageName, TextView enumerationFormPage2ImageSize, LinearLayout fbImageLL, LinearLayout fbImageLL1, LinearLayout firstLL, LinearLayout firstLL1, ImageView frontImage, ImageView frontImage1, LinearLayout lvPage1EnumrationChoose, LinearLayout lvPage2EnumrationChoose, LinearLayout lvSupportChoose1, LinearLayout lvSupportChoose2, LinearLayout main, RadioButton permanentRb, RelativeLayout reasonHeading, RadioButton refusedRb, EditText resontv, LinearLayout secondLL, LinearLayout secondLL1, ImageView speakReason, Button submitSIR, RelativeLayout supportedDocumentHeading, LinearLayout supportingDocumentsPage1, ImageView supportingDocumentsPage1Image, TextView supportingDocumentsPage1ImageName, TextView supportingDocumentsPage1ImageSize, LinearLayout supportingDocumentsPage2, ImageView supportingDocumentsPage2Image, TextView supportingDocumentsPage2ImageName, TextView supportingDocumentsPage2ImageSize, LinearLayout supprtingDocumentsLayout, TextView textView3, TextView textView5, Toolbar toolbar, ImageView toolbarButton, TextView toolbarTitle, RadioGroup uncollectableRG, TextView uploadEnumerationFormPage1, TextView uploadEnumerationFormPage2, TextView uploadEnumratioinPage2, RelativeLayout uploadEnumrationHeading, TextView uploadPage1Enumration, TextView uploadSupportingDocumentsPage1, TextView uploadSupportingDocumentsPage2) {
        this.rootView = rootView;
        this.absentRb = absentRb;
        this.alreadyEnrolledRb = alreadyEnrolledRb;
        this.alreadyEpicLayout = alreadyEpicLayout;
        this.backBtnIv = backBtnIv;
        this.backImage = backImage;
        this.backImage1 = backImage1;
        this.blaTopLayout = blaTopLayout;
        this.cancelEnumerationFormPage1Image = cancelEnumerationFormPage1Image;
        this.cancelEnumerationFormPage2Image = cancelEnumerationFormPage2Image;
        this.cancelSupportingDocumentsPage1Image = cancelSupportingDocumentsPage1Image;
        this.cancelSupportingDocumentsPage2Image = cancelSupportingDocumentsPage2Image;
        this.deadRb = deadRb;
        this.deleteBackImage = deleteBackImage;
        this.deleteBackImage1 = deleteBackImage1;
        this.deleteFrontImage = deleteFrontImage;
        this.deleteFrontImage1 = deleteFrontImage1;
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
        this.fbImageLL = fbImageLL;
        this.fbImageLL1 = fbImageLL1;
        this.firstLL = firstLL;
        this.firstLL1 = firstLL1;
        this.frontImage = frontImage;
        this.frontImage1 = frontImage1;
        this.lvPage1EnumrationChoose = lvPage1EnumrationChoose;
        this.lvPage2EnumrationChoose = lvPage2EnumrationChoose;
        this.lvSupportChoose1 = lvSupportChoose1;
        this.lvSupportChoose2 = lvSupportChoose2;
        this.main = main;
        this.permanentRb = permanentRb;
        this.reasonHeading = reasonHeading;
        this.refusedRb = refusedRb;
        this.resontv = resontv;
        this.secondLL = secondLL;
        this.secondLL1 = secondLL1;
        this.speakReason = speakReason;
        this.submitSIR = submitSIR;
        this.supportedDocumentHeading = supportedDocumentHeading;
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
        this.textView5 = textView5;
        this.toolbar = toolbar;
        this.toolbarButton = toolbarButton;
        this.toolbarTitle = toolbarTitle;
        this.uncollectableRG = uncollectableRG;
        this.uploadEnumerationFormPage1 = uploadEnumerationFormPage1;
        this.uploadEnumerationFormPage2 = uploadEnumerationFormPage2;
        this.uploadEnumratioinPage2 = uploadEnumratioinPage2;
        this.uploadEnumrationHeading = uploadEnumrationHeading;
        this.uploadPage1Enumration = uploadPage1Enumration;
        this.uploadSupportingDocumentsPage1 = uploadSupportingDocumentsPage1;
        this.uploadSupportingDocumentsPage2 = uploadSupportingDocumentsPage2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUncollectableSirBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityUncollectableSirBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_uncollectable_sir, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityUncollectableSirBinding bind(View rootView) {
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
                        i = R.id.backImage;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.backImage);
                        if (imageView2 != null) {
                            i = R.id.backImage1;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.backImage1);
                            if (imageView3 != null) {
                                i = R.id.bla_top_layout;
                                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
                                if (constraintLayoutFindChildViewById != null) {
                                    i = R.id.cancelEnumerationFormPage1Image;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelEnumerationFormPage1Image);
                                    if (imageView4 != null) {
                                        i = R.id.cancelEnumerationFormPage2Image;
                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelEnumerationFormPage2Image);
                                        if (imageView5 != null) {
                                            i = R.id.cancelSupportingDocumentsPage1Image;
                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelSupportingDocumentsPage1Image);
                                            if (imageView6 != null) {
                                                i = R.id.cancelSupportingDocumentsPage2Image;
                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelSupportingDocumentsPage2Image);
                                                if (imageView7 != null) {
                                                    i = R.id.dead_rb;
                                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.dead_rb);
                                                    if (radioButton3 != null) {
                                                        i = R.id.deleteBackImage;
                                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteBackImage);
                                                        if (imageView8 != null) {
                                                            i = R.id.deleteBackImage1;
                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteBackImage1);
                                                            if (imageView9 != null) {
                                                                i = R.id.deleteFrontImage;
                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteFrontImage);
                                                                if (imageView10 != null) {
                                                                    i = R.id.deleteFrontImage1;
                                                                    ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteFrontImage1);
                                                                    if (imageView11 != null) {
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
                                                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage1Image);
                                                                                    if (imageView12 != null) {
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
                                                                                                    ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2Image);
                                                                                                    if (imageView13 != null) {
                                                                                                        i = R.id.enumerationFormPage2ImageName;
                                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2ImageName);
                                                                                                        if (textView3 != null) {
                                                                                                            i = R.id.enumerationFormPage2ImageSize;
                                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2ImageSize);
                                                                                                            if (textView4 != null) {
                                                                                                                i = R.id.fbImageLL;
                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fbImageLL);
                                                                                                                if (linearLayout5 != null) {
                                                                                                                    i = R.id.fbImageLL1;
                                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fbImageLL1);
                                                                                                                    if (linearLayout6 != null) {
                                                                                                                        i = R.id.firstLL;
                                                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.firstLL);
                                                                                                                        if (linearLayout7 != null) {
                                                                                                                            i = R.id.firstLL1;
                                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.firstLL1);
                                                                                                                            if (linearLayout8 != null) {
                                                                                                                                i = R.id.frontImage;
                                                                                                                                ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.frontImage);
                                                                                                                                if (imageView14 != null) {
                                                                                                                                    i = R.id.frontImage1;
                                                                                                                                    ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.frontImage1);
                                                                                                                                    if (imageView15 != null) {
                                                                                                                                        i = R.id.lv_page1_enumration_choose;
                                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_page1_enumration_choose);
                                                                                                                                        if (linearLayout9 != null) {
                                                                                                                                            i = R.id.lv_page2_enumration_choose;
                                                                                                                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_page2_enumration_choose);
                                                                                                                                            if (linearLayout10 != null) {
                                                                                                                                                i = R.id.lv_support_choose1;
                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_support_choose1);
                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                    i = R.id.lv_support_choose2;
                                                                                                                                                    LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_support_choose2);
                                                                                                                                                    if (linearLayout12 != null) {
                                                                                                                                                        LinearLayout linearLayout13 = (LinearLayout) rootView;
                                                                                                                                                        i = R.id.permanent_rb;
                                                                                                                                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.permanent_rb);
                                                                                                                                                        if (radioButton4 != null) {
                                                                                                                                                            i = R.id.reason_heading;
                                                                                                                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.reason_heading);
                                                                                                                                                            if (relativeLayout != null) {
                                                                                                                                                                i = R.id.refused_rb;
                                                                                                                                                                RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.refused_rb);
                                                                                                                                                                if (radioButton5 != null) {
                                                                                                                                                                    i = R.id.resontv;
                                                                                                                                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.resontv);
                                                                                                                                                                    if (editText2 != null) {
                                                                                                                                                                        i = R.id.secondLL;
                                                                                                                                                                        LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.secondLL);
                                                                                                                                                                        if (linearLayout14 != null) {
                                                                                                                                                                            i = R.id.secondLL1;
                                                                                                                                                                            LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.secondLL1);
                                                                                                                                                                            if (linearLayout15 != null) {
                                                                                                                                                                                i = R.id.speak_reason;
                                                                                                                                                                                ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speak_reason);
                                                                                                                                                                                if (imageView16 != null) {
                                                                                                                                                                                    i = R.id.submitSIR;
                                                                                                                                                                                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submitSIR);
                                                                                                                                                                                    if (button != null) {
                                                                                                                                                                                        i = R.id.supported_document_heading;
                                                                                                                                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.supported_document_heading);
                                                                                                                                                                                        if (relativeLayout2 != null) {
                                                                                                                                                                                            i = R.id.supportingDocumentsPage1;
                                                                                                                                                                                            LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1);
                                                                                                                                                                                            if (linearLayout16 != null) {
                                                                                                                                                                                                i = R.id.supportingDocumentsPage1Image;
                                                                                                                                                                                                ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1Image);
                                                                                                                                                                                                if (imageView17 != null) {
                                                                                                                                                                                                    i = R.id.supportingDocumentsPage1ImageName;
                                                                                                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1ImageName);
                                                                                                                                                                                                    if (textView5 != null) {
                                                                                                                                                                                                        i = R.id.supportingDocumentsPage1ImageSize;
                                                                                                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1ImageSize);
                                                                                                                                                                                                        if (textView6 != null) {
                                                                                                                                                                                                            i = R.id.supportingDocumentsPage2;
                                                                                                                                                                                                            LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2);
                                                                                                                                                                                                            if (linearLayout17 != null) {
                                                                                                                                                                                                                i = R.id.supportingDocumentsPage2Image;
                                                                                                                                                                                                                ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2Image);
                                                                                                                                                                                                                if (imageView18 != null) {
                                                                                                                                                                                                                    i = R.id.supportingDocumentsPage2ImageName;
                                                                                                                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2ImageName);
                                                                                                                                                                                                                    if (textView7 != null) {
                                                                                                                                                                                                                        i = R.id.supportingDocumentsPage2ImageSize;
                                                                                                                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2ImageSize);
                                                                                                                                                                                                                        if (textView8 != null) {
                                                                                                                                                                                                                            i = R.id.supprtingDocumentsLayout;
                                                                                                                                                                                                                            LinearLayout linearLayout18 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supprtingDocumentsLayout);
                                                                                                                                                                                                                            if (linearLayout18 != null) {
                                                                                                                                                                                                                                i = R.id.textView3;
                                                                                                                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                                                                                                                if (textView9 != null) {
                                                                                                                                                                                                                                    i = R.id.textView5;
                                                                                                                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                                                                                                                                                                                                                    if (textView10 != null) {
                                                                                                                                                                                                                                        i = R.id.toolbar;
                                                                                                                                                                                                                                        Toolbar toolbarFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.toolbar);
                                                                                                                                                                                                                                        if (toolbarFindChildViewById != null) {
                                                                                                                                                                                                                                            i = R.id.toolbar_button;
                                                                                                                                                                                                                                            ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                                                                                                                                                                                                            if (imageView19 != null) {
                                                                                                                                                                                                                                                i = R.id.toolbar_title;
                                                                                                                                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbar_title);
                                                                                                                                                                                                                                                if (textView11 != null) {
                                                                                                                                                                                                                                                    i = R.id.uncollectableRG;
                                                                                                                                                                                                                                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.uncollectableRG);
                                                                                                                                                                                                                                                    if (radioGroup != null) {
                                                                                                                                                                                                                                                        i = R.id.uploadEnumerationFormPage1;
                                                                                                                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadEnumerationFormPage1);
                                                                                                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                                                                                                            i = R.id.uploadEnumerationFormPage2;
                                                                                                                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadEnumerationFormPage2);
                                                                                                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                                                                                                i = R.id.upload_enumratioin_page_2;
                                                                                                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_enumratioin_page_2);
                                                                                                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                                                                                                    i = R.id.upload_enumration_heading;
                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.upload_enumration_heading);
                                                                                                                                                                                                                                                                    if (relativeLayout3 != null) {
                                                                                                                                                                                                                                                                        i = R.id.upload_page1_enumration;
                                                                                                                                                                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_page1_enumration);
                                                                                                                                                                                                                                                                        if (textView15 != null) {
                                                                                                                                                                                                                                                                            i = R.id.uploadSupportingDocumentsPage1;
                                                                                                                                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadSupportingDocumentsPage1);
                                                                                                                                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                                                                                                                                i = R.id.uploadSupportingDocumentsPage2;
                                                                                                                                                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadSupportingDocumentsPage2);
                                                                                                                                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                                                                                                                                    return new ActivityUncollectableSirBinding(linearLayout13, radioButton, radioButton2, linearLayout, imageView, imageView2, imageView3, constraintLayoutFindChildViewById, imageView4, imageView5, imageView6, imageView7, radioButton3, imageView8, imageView9, imageView10, imageView11, editText, linearLayout2, linearLayout3, imageView12, textView, textView2, linearLayout4, imageView13, textView3, textView4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, imageView14, imageView15, linearLayout9, linearLayout10, linearLayout11, linearLayout12, linearLayout13, radioButton4, relativeLayout, radioButton5, editText2, linearLayout14, linearLayout15, imageView16, button, relativeLayout2, linearLayout16, imageView17, textView5, textView6, linearLayout17, imageView18, textView7, textView8, linearLayout18, textView9, textView10, toolbarFindChildViewById, imageView19, textView11, radioGroup, textView12, textView13, textView14, relativeLayout3, textView15, textView16, textView17);
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
