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
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityViewFormByAeropage1BhBinding implements ViewBinding {
    public final EditText aadharNumber;
    public final LinearLayout annexPage1Layout;
    public final ImageView backBtnIv;
    public final ImageView backImage;
    public final ImageView backImage1;
    public final ImageView backImageNew;
    public final ConstraintLayout blaTopLayout;
    public final RadioButton bornInIndia;
    public final ImageView cancel;
    public final ImageView cancelEnumerationFormPage1Image;
    public final ImageView cancelEnumerationFormPage2Image;
    public final ImageView cancelPhoto1Annexure;
    public final ImageView cancelPhoto2Annexure;
    public final ImageView cancelSupportingDocumentsPage1Image;
    public final ImageView cancelSupportingDocumentsPage2Image;
    public final TextView categoryName;
    public final LinearLayout categoryNameLL;
    public final EditText dateOfBirth;
    public final ImageView deleteBackImage;
    public final ImageView deleteBackImage1;
    public final ImageView deleteBackImageNew;
    public final ImageView deleteElectorImage;
    public final ImageView deleteFrontImage;
    public final ImageView deleteFrontImage1;
    public final ImageView deleteFrontImageNew;
    public final ImageView electorImage;
    public final LinearLayout electorImageLL;
    public final LinearLayout enumerationFormLayout;
    public final LinearLayout enumerationFormPage1;
    public final ImageView enumerationFormPage1Image;
    public final TextView enumerationFormPage1ImageName;
    public final TextView enumerationFormPage1ImageSize;
    public final LinearLayout enumerationFormPage2;
    public final ImageView enumerationFormPage2Image;
    public final TextView enumerationFormPage2ImageName;
    public final TextView enumerationFormPage2ImageSize;
    public final EditText fatherEpicNumber;
    public final EditText fatherName;
    public final LinearLayout fbImageLL;
    public final LinearLayout fbImageLL1;
    public final LinearLayout fbImageLLNew;
    public final LinearLayout fbUploadLL;
    public final LinearLayout firstLL;
    public final LinearLayout firstLL1;
    public final LinearLayout firstLLNew;
    public final TextView formCreatedBy;
    public final ImageView frontImage;
    public final ImageView frontImage1;
    public final ImageView frontImageNew;
    public final ImageView image;
    public final RadioButton indianCitizen;
    public final RadioButton indianWithPriorVoterID;
    public final LinearLayout linearAadharLayout;
    public final LinearLayout linearDob;
    public final LinearLayout linearFatherEpic;
    public final LinearLayout linearMobileNumber;
    public final LinearLayout linearMotherEpic;
    public final LinearLayout linearSpouse;
    public final LinearLayout main;
    public final EditText mobileNumber;
    public final EditText motherEpicNumber;
    public final EditText motherName;
    public final TextView nextButton;
    public final RadioButton noDocument;
    public final RadioButton notBornInIndia;
    public final LinearLayout oldACSerialPSLNoLL;
    public final EditText oldAcNo;
    public final EditText oldPartNo;
    public final EditText oldPslNo;
    public final TextView orAnnex;
    public final LinearLayout passPhotoLayout;
    public final ImageView photo1;
    public final TextView photo1Name;
    public final TextView photo1Size;
    public final ImageView photo2;
    public final LinearLayout photo2Layout;
    public final TextView photo2Name;
    public final TextView photo2Size;
    public final TextView photoNameTv2;
    public final TextView photoSize;
    public final LinearLayout relative2003LL;
    public final RadioButton relative2003No;
    public final RadioGroup relative2003RG;
    public final RadioButton relative2003Yes;
    public final LinearLayout relativeFullLL;
    private final LinearLayout rootView;
    public final LinearLayout secondLL;
    public final LinearLayout secondLL1;
    public final LinearLayout secondLLNew;
    public final RadioGroup selectDetails;
    public final Spinner spinnerIR;
    public final Spinner spinnerRelation;
    public final EditText spouseEpicNumber;
    public final EditText spouseName;
    public final Button submitButtonDoc;
    public final Button submitButtonRec;
    public final LinearLayout submitLayout;
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
    public final TextView uploadBackPhoto;
    public final TextView uploadElectorImage;
    public final TextView uploadEnumerationFormPage1;
    public final TextView uploadEnumerationFormPage2;
    public final TextView uploadFrontPhoto;
    public final TextView uploadSupportingDocumentsPage1;
    public final TextView uploadSupportingDocumentsPage2;

    private ActivityViewFormByAeropage1BhBinding(LinearLayout rootView, EditText aadharNumber, LinearLayout annexPage1Layout, ImageView backBtnIv, ImageView backImage, ImageView backImage1, ImageView backImageNew, ConstraintLayout blaTopLayout, RadioButton bornInIndia, ImageView cancel, ImageView cancelEnumerationFormPage1Image, ImageView cancelEnumerationFormPage2Image, ImageView cancelPhoto1Annexure, ImageView cancelPhoto2Annexure, ImageView cancelSupportingDocumentsPage1Image, ImageView cancelSupportingDocumentsPage2Image, TextView categoryName, LinearLayout categoryNameLL, EditText dateOfBirth, ImageView deleteBackImage, ImageView deleteBackImage1, ImageView deleteBackImageNew, ImageView deleteElectorImage, ImageView deleteFrontImage, ImageView deleteFrontImage1, ImageView deleteFrontImageNew, ImageView electorImage, LinearLayout electorImageLL, LinearLayout enumerationFormLayout, LinearLayout enumerationFormPage1, ImageView enumerationFormPage1Image, TextView enumerationFormPage1ImageName, TextView enumerationFormPage1ImageSize, LinearLayout enumerationFormPage2, ImageView enumerationFormPage2Image, TextView enumerationFormPage2ImageName, TextView enumerationFormPage2ImageSize, EditText fatherEpicNumber, EditText fatherName, LinearLayout fbImageLL, LinearLayout fbImageLL1, LinearLayout fbImageLLNew, LinearLayout fbUploadLL, LinearLayout firstLL, LinearLayout firstLL1, LinearLayout firstLLNew, TextView formCreatedBy, ImageView frontImage, ImageView frontImage1, ImageView frontImageNew, ImageView image, RadioButton indianCitizen, RadioButton indianWithPriorVoterID, LinearLayout linearAadharLayout, LinearLayout linearDob, LinearLayout linearFatherEpic, LinearLayout linearMobileNumber, LinearLayout linearMotherEpic, LinearLayout linearSpouse, LinearLayout main, EditText mobileNumber, EditText motherEpicNumber, EditText motherName, TextView nextButton, RadioButton noDocument, RadioButton notBornInIndia, LinearLayout oldACSerialPSLNoLL, EditText oldAcNo, EditText oldPartNo, EditText oldPslNo, TextView orAnnex, LinearLayout passPhotoLayout, ImageView photo1, TextView photo1Name, TextView photo1Size, ImageView photo2, LinearLayout photo2Layout, TextView photo2Name, TextView photo2Size, TextView photoNameTv2, TextView photoSize, LinearLayout relative2003LL, RadioButton relative2003No, RadioGroup relative2003RG, RadioButton relative2003Yes, LinearLayout relativeFullLL, LinearLayout secondLL, LinearLayout secondLL1, LinearLayout secondLLNew, RadioGroup selectDetails, Spinner spinnerIR, Spinner spinnerRelation, EditText spouseEpicNumber, EditText spouseName, Button submitButtonDoc, Button submitButtonRec, LinearLayout submitLayout, LinearLayout supportingDocumentsPage1, ImageView supportingDocumentsPage1Image, TextView supportingDocumentsPage1ImageName, TextView supportingDocumentsPage1ImageSize, LinearLayout supportingDocumentsPage2, ImageView supportingDocumentsPage2Image, TextView supportingDocumentsPage2ImageName, TextView supportingDocumentsPage2ImageSize, LinearLayout supprtingDocumentsLayout, TextView textView3, TextView uploadBackPhoto, TextView uploadElectorImage, TextView uploadEnumerationFormPage1, TextView uploadEnumerationFormPage2, TextView uploadFrontPhoto, TextView uploadSupportingDocumentsPage1, TextView uploadSupportingDocumentsPage2) {
        this.rootView = rootView;
        this.aadharNumber = aadharNumber;
        this.annexPage1Layout = annexPage1Layout;
        this.backBtnIv = backBtnIv;
        this.backImage = backImage;
        this.backImage1 = backImage1;
        this.backImageNew = backImageNew;
        this.blaTopLayout = blaTopLayout;
        this.bornInIndia = bornInIndia;
        this.cancel = cancel;
        this.cancelEnumerationFormPage1Image = cancelEnumerationFormPage1Image;
        this.cancelEnumerationFormPage2Image = cancelEnumerationFormPage2Image;
        this.cancelPhoto1Annexure = cancelPhoto1Annexure;
        this.cancelPhoto2Annexure = cancelPhoto2Annexure;
        this.cancelSupportingDocumentsPage1Image = cancelSupportingDocumentsPage1Image;
        this.cancelSupportingDocumentsPage2Image = cancelSupportingDocumentsPage2Image;
        this.categoryName = categoryName;
        this.categoryNameLL = categoryNameLL;
        this.dateOfBirth = dateOfBirth;
        this.deleteBackImage = deleteBackImage;
        this.deleteBackImage1 = deleteBackImage1;
        this.deleteBackImageNew = deleteBackImageNew;
        this.deleteElectorImage = deleteElectorImage;
        this.deleteFrontImage = deleteFrontImage;
        this.deleteFrontImage1 = deleteFrontImage1;
        this.deleteFrontImageNew = deleteFrontImageNew;
        this.electorImage = electorImage;
        this.electorImageLL = electorImageLL;
        this.enumerationFormLayout = enumerationFormLayout;
        this.enumerationFormPage1 = enumerationFormPage1;
        this.enumerationFormPage1Image = enumerationFormPage1Image;
        this.enumerationFormPage1ImageName = enumerationFormPage1ImageName;
        this.enumerationFormPage1ImageSize = enumerationFormPage1ImageSize;
        this.enumerationFormPage2 = enumerationFormPage2;
        this.enumerationFormPage2Image = enumerationFormPage2Image;
        this.enumerationFormPage2ImageName = enumerationFormPage2ImageName;
        this.enumerationFormPage2ImageSize = enumerationFormPage2ImageSize;
        this.fatherEpicNumber = fatherEpicNumber;
        this.fatherName = fatherName;
        this.fbImageLL = fbImageLL;
        this.fbImageLL1 = fbImageLL1;
        this.fbImageLLNew = fbImageLLNew;
        this.fbUploadLL = fbUploadLL;
        this.firstLL = firstLL;
        this.firstLL1 = firstLL1;
        this.firstLLNew = firstLLNew;
        this.formCreatedBy = formCreatedBy;
        this.frontImage = frontImage;
        this.frontImage1 = frontImage1;
        this.frontImageNew = frontImageNew;
        this.image = image;
        this.indianCitizen = indianCitizen;
        this.indianWithPriorVoterID = indianWithPriorVoterID;
        this.linearAadharLayout = linearAadharLayout;
        this.linearDob = linearDob;
        this.linearFatherEpic = linearFatherEpic;
        this.linearMobileNumber = linearMobileNumber;
        this.linearMotherEpic = linearMotherEpic;
        this.linearSpouse = linearSpouse;
        this.main = main;
        this.mobileNumber = mobileNumber;
        this.motherEpicNumber = motherEpicNumber;
        this.motherName = motherName;
        this.nextButton = nextButton;
        this.noDocument = noDocument;
        this.notBornInIndia = notBornInIndia;
        this.oldACSerialPSLNoLL = oldACSerialPSLNoLL;
        this.oldAcNo = oldAcNo;
        this.oldPartNo = oldPartNo;
        this.oldPslNo = oldPslNo;
        this.orAnnex = orAnnex;
        this.passPhotoLayout = passPhotoLayout;
        this.photo1 = photo1;
        this.photo1Name = photo1Name;
        this.photo1Size = photo1Size;
        this.photo2 = photo2;
        this.photo2Layout = photo2Layout;
        this.photo2Name = photo2Name;
        this.photo2Size = photo2Size;
        this.photoNameTv2 = photoNameTv2;
        this.photoSize = photoSize;
        this.relative2003LL = relative2003LL;
        this.relative2003No = relative2003No;
        this.relative2003RG = relative2003RG;
        this.relative2003Yes = relative2003Yes;
        this.relativeFullLL = relativeFullLL;
        this.secondLL = secondLL;
        this.secondLL1 = secondLL1;
        this.secondLLNew = secondLLNew;
        this.selectDetails = selectDetails;
        this.spinnerIR = spinnerIR;
        this.spinnerRelation = spinnerRelation;
        this.spouseEpicNumber = spouseEpicNumber;
        this.spouseName = spouseName;
        this.submitButtonDoc = submitButtonDoc;
        this.submitButtonRec = submitButtonRec;
        this.submitLayout = submitLayout;
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
        this.uploadBackPhoto = uploadBackPhoto;
        this.uploadElectorImage = uploadElectorImage;
        this.uploadEnumerationFormPage1 = uploadEnumerationFormPage1;
        this.uploadEnumerationFormPage2 = uploadEnumerationFormPage2;
        this.uploadFrontPhoto = uploadFrontPhoto;
        this.uploadSupportingDocumentsPage1 = uploadSupportingDocumentsPage1;
        this.uploadSupportingDocumentsPage2 = uploadSupportingDocumentsPage2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityViewFormByAeropage1BhBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityViewFormByAeropage1BhBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_view_form_by_aeropage1_bh, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityViewFormByAeropage1BhBinding bind(View rootView) {
        int i = R.id.aadharNumber;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.aadharNumber);
        if (editText != null) {
            i = R.id.annexPage1Layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.annexPage1Layout);
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
                            i = R.id.backImageNew;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.backImageNew);
                            if (imageView4 != null) {
                                i = R.id.bla_top_layout;
                                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
                                if (constraintLayoutFindChildViewById != null) {
                                    i = R.id.bornInIndia;
                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.bornInIndia);
                                    if (radioButton != null) {
                                        i = R.id.cancel;
                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel);
                                        if (imageView5 != null) {
                                            i = R.id.cancelEnumerationFormPage1Image;
                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelEnumerationFormPage1Image);
                                            if (imageView6 != null) {
                                                i = R.id.cancelEnumerationFormPage2Image;
                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelEnumerationFormPage2Image);
                                                if (imageView7 != null) {
                                                    i = R.id.cancel_photo1_annexure;
                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel_photo1_annexure);
                                                    if (imageView8 != null) {
                                                        i = R.id.cancel_photo2_annexure;
                                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel_photo2_annexure);
                                                        if (imageView9 != null) {
                                                            i = R.id.cancelSupportingDocumentsPage1Image;
                                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelSupportingDocumentsPage1Image);
                                                            if (imageView10 != null) {
                                                                i = R.id.cancelSupportingDocumentsPage2Image;
                                                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelSupportingDocumentsPage2Image);
                                                                if (imageView11 != null) {
                                                                    i = R.id.categoryName;
                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.categoryName);
                                                                    if (textView != null) {
                                                                        i = R.id.categoryNameLL;
                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.categoryNameLL);
                                                                        if (linearLayout2 != null) {
                                                                            i = R.id.dateOfBirth;
                                                                            EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.dateOfBirth);
                                                                            if (editText2 != null) {
                                                                                i = R.id.deleteBackImage;
                                                                                ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteBackImage);
                                                                                if (imageView12 != null) {
                                                                                    i = R.id.deleteBackImage1;
                                                                                    ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteBackImage1);
                                                                                    if (imageView13 != null) {
                                                                                        i = R.id.deleteBackImageNew;
                                                                                        ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteBackImageNew);
                                                                                        if (imageView14 != null) {
                                                                                            i = R.id.deleteElectorImage;
                                                                                            ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteElectorImage);
                                                                                            if (imageView15 != null) {
                                                                                                i = R.id.deleteFrontImage;
                                                                                                ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteFrontImage);
                                                                                                if (imageView16 != null) {
                                                                                                    i = R.id.deleteFrontImage1;
                                                                                                    ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteFrontImage1);
                                                                                                    if (imageView17 != null) {
                                                                                                        i = R.id.deleteFrontImageNew;
                                                                                                        ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteFrontImageNew);
                                                                                                        if (imageView18 != null) {
                                                                                                            i = R.id.electorImage;
                                                                                                            ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.electorImage);
                                                                                                            if (imageView19 != null) {
                                                                                                                i = R.id.electorImageLL;
                                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.electorImageLL);
                                                                                                                if (linearLayout3 != null) {
                                                                                                                    i = R.id.enumerationFormLayout;
                                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.enumerationFormLayout);
                                                                                                                    if (linearLayout4 != null) {
                                                                                                                        i = R.id.enumerationFormPage1;
                                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage1);
                                                                                                                        if (linearLayout5 != null) {
                                                                                                                            i = R.id.enumerationFormPage1Image;
                                                                                                                            ImageView imageView20 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage1Image);
                                                                                                                            if (imageView20 != null) {
                                                                                                                                i = R.id.enumerationFormPage1ImageName;
                                                                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage1ImageName);
                                                                                                                                if (textView2 != null) {
                                                                                                                                    i = R.id.enumerationFormPage1ImageSize;
                                                                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage1ImageSize);
                                                                                                                                    if (textView3 != null) {
                                                                                                                                        i = R.id.enumerationFormPage2;
                                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2);
                                                                                                                                        if (linearLayout6 != null) {
                                                                                                                                            i = R.id.enumerationFormPage2Image;
                                                                                                                                            ImageView imageView21 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2Image);
                                                                                                                                            if (imageView21 != null) {
                                                                                                                                                i = R.id.enumerationFormPage2ImageName;
                                                                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2ImageName);
                                                                                                                                                if (textView4 != null) {
                                                                                                                                                    i = R.id.enumerationFormPage2ImageSize;
                                                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2ImageSize);
                                                                                                                                                    if (textView5 != null) {
                                                                                                                                                        i = R.id.fatherEpicNumber;
                                                                                                                                                        EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.fatherEpicNumber);
                                                                                                                                                        if (editText3 != null) {
                                                                                                                                                            i = R.id.fatherName;
                                                                                                                                                            EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.fatherName);
                                                                                                                                                            if (editText4 != null) {
                                                                                                                                                                i = R.id.fbImageLL;
                                                                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fbImageLL);
                                                                                                                                                                if (linearLayout7 != null) {
                                                                                                                                                                    i = R.id.fbImageLL1;
                                                                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fbImageLL1);
                                                                                                                                                                    if (linearLayout8 != null) {
                                                                                                                                                                        i = R.id.fbImageLLNew;
                                                                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fbImageLLNew);
                                                                                                                                                                        if (linearLayout9 != null) {
                                                                                                                                                                            i = R.id.fbUploadLL;
                                                                                                                                                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fbUploadLL);
                                                                                                                                                                            if (linearLayout10 != null) {
                                                                                                                                                                                i = R.id.firstLL;
                                                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.firstLL);
                                                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                                                    i = R.id.firstLL1;
                                                                                                                                                                                    LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.firstLL1);
                                                                                                                                                                                    if (linearLayout12 != null) {
                                                                                                                                                                                        i = R.id.firstLLNew;
                                                                                                                                                                                        LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.firstLLNew);
                                                                                                                                                                                        if (linearLayout13 != null) {
                                                                                                                                                                                            i = R.id.formCreatedBy;
                                                                                                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.formCreatedBy);
                                                                                                                                                                                            if (textView6 != null) {
                                                                                                                                                                                                i = R.id.frontImage;
                                                                                                                                                                                                ImageView imageView22 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.frontImage);
                                                                                                                                                                                                if (imageView22 != null) {
                                                                                                                                                                                                    i = R.id.frontImage1;
                                                                                                                                                                                                    ImageView imageView23 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.frontImage1);
                                                                                                                                                                                                    if (imageView23 != null) {
                                                                                                                                                                                                        i = R.id.frontImageNew;
                                                                                                                                                                                                        ImageView imageView24 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.frontImageNew);
                                                                                                                                                                                                        if (imageView24 != null) {
                                                                                                                                                                                                            i = 2131364126;
                                                                                                                                                                                                            ImageView imageView25 = (ImageView) ViewBindings.findChildViewById(rootView, 2131364126);
                                                                                                                                                                                                            if (imageView25 != null) {
                                                                                                                                                                                                                i = R.id.indianCitizen;
                                                                                                                                                                                                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.indianCitizen);
                                                                                                                                                                                                                if (radioButton2 != null) {
                                                                                                                                                                                                                    i = R.id.indianWithPriorVoterID;
                                                                                                                                                                                                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.indianWithPriorVoterID);
                                                                                                                                                                                                                    if (radioButton3 != null) {
                                                                                                                                                                                                                        i = R.id.linear_aadhar_layout;
                                                                                                                                                                                                                        LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_aadhar_layout);
                                                                                                                                                                                                                        if (linearLayout14 != null) {
                                                                                                                                                                                                                            i = R.id.linear_dob;
                                                                                                                                                                                                                            LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_dob);
                                                                                                                                                                                                                            if (linearLayout15 != null) {
                                                                                                                                                                                                                                i = R.id.linear_father_epic;
                                                                                                                                                                                                                                LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_father_epic);
                                                                                                                                                                                                                                if (linearLayout16 != null) {
                                                                                                                                                                                                                                    i = R.id.linear_mobile_number;
                                                                                                                                                                                                                                    LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_mobile_number);
                                                                                                                                                                                                                                    if (linearLayout17 != null) {
                                                                                                                                                                                                                                        i = R.id.linear_mother_epic;
                                                                                                                                                                                                                                        LinearLayout linearLayout18 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_mother_epic);
                                                                                                                                                                                                                                        if (linearLayout18 != null) {
                                                                                                                                                                                                                                            i = R.id.linear_spouse;
                                                                                                                                                                                                                                            LinearLayout linearLayout19 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_spouse);
                                                                                                                                                                                                                                            if (linearLayout19 != null) {
                                                                                                                                                                                                                                                LinearLayout linearLayout20 = (LinearLayout) rootView;
                                                                                                                                                                                                                                                i = R.id.mobileNumber;
                                                                                                                                                                                                                                                EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobileNumber);
                                                                                                                                                                                                                                                if (editText5 != null) {
                                                                                                                                                                                                                                                    i = R.id.motherEpicNumber;
                                                                                                                                                                                                                                                    EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.motherEpicNumber);
                                                                                                                                                                                                                                                    if (editText6 != null) {
                                                                                                                                                                                                                                                        i = R.id.motherName;
                                                                                                                                                                                                                                                        EditText editText7 = (EditText) ViewBindings.findChildViewById(rootView, R.id.motherName);
                                                                                                                                                                                                                                                        if (editText7 != null) {
                                                                                                                                                                                                                                                            i = R.id.nextButton;
                                                                                                                                                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nextButton);
                                                                                                                                                                                                                                                            if (textView7 != null) {
                                                                                                                                                                                                                                                                i = R.id.noDocument;
                                                                                                                                                                                                                                                                RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.noDocument);
                                                                                                                                                                                                                                                                if (radioButton4 != null) {
                                                                                                                                                                                                                                                                    i = R.id.notBornInIndia;
                                                                                                                                                                                                                                                                    RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.notBornInIndia);
                                                                                                                                                                                                                                                                    if (radioButton5 != null) {
                                                                                                                                                                                                                                                                        i = R.id.oldACSerialPSLNoLL;
                                                                                                                                                                                                                                                                        LinearLayout linearLayout21 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.oldACSerialPSLNoLL);
                                                                                                                                                                                                                                                                        if (linearLayout21 != null) {
                                                                                                                                                                                                                                                                            i = R.id.oldAcNo;
                                                                                                                                                                                                                                                                            EditText editText8 = (EditText) ViewBindings.findChildViewById(rootView, R.id.oldAcNo);
                                                                                                                                                                                                                                                                            if (editText8 != null) {
                                                                                                                                                                                                                                                                                i = R.id.oldPartNo;
                                                                                                                                                                                                                                                                                EditText editText9 = (EditText) ViewBindings.findChildViewById(rootView, R.id.oldPartNo);
                                                                                                                                                                                                                                                                                if (editText9 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.oldPslNo;
                                                                                                                                                                                                                                                                                    EditText editText10 = (EditText) ViewBindings.findChildViewById(rootView, R.id.oldPslNo);
                                                                                                                                                                                                                                                                                    if (editText10 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.orAnnex;
                                                                                                                                                                                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.orAnnex);
                                                                                                                                                                                                                                                                                        if (textView8 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.pass_photo_layout;
                                                                                                                                                                                                                                                                                            LinearLayout linearLayout22 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pass_photo_layout);
                                                                                                                                                                                                                                                                                            if (linearLayout22 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.photo1;
                                                                                                                                                                                                                                                                                                ImageView imageView26 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.photo1);
                                                                                                                                                                                                                                                                                                if (imageView26 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.photo1_name;
                                                                                                                                                                                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo1_name);
                                                                                                                                                                                                                                                                                                    if (textView9 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.photo1_size;
                                                                                                                                                                                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo1_size);
                                                                                                                                                                                                                                                                                                        if (textView10 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.photo2;
                                                                                                                                                                                                                                                                                                            ImageView imageView27 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.photo2);
                                                                                                                                                                                                                                                                                                            if (imageView27 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.photo2Layout;
                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout23 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.photo2Layout);
                                                                                                                                                                                                                                                                                                                if (linearLayout23 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.photo2_name;
                                                                                                                                                                                                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo2_name);
                                                                                                                                                                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.photo2_size;
                                                                                                                                                                                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo2_size);
                                                                                                                                                                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.photo_name_tv2;
                                                                                                                                                                                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo_name_tv2);
                                                                                                                                                                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.photo_size;
                                                                                                                                                                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo_size);
                                                                                                                                                                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.relative_2003LL;
                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout24 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.relative_2003LL);
                                                                                                                                                                                                                                                                                                                                    if (linearLayout24 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.relative2003No;
                                                                                                                                                                                                                                                                                                                                        RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.relative2003No);
                                                                                                                                                                                                                                                                                                                                        if (radioButton6 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.relative2003RG;
                                                                                                                                                                                                                                                                                                                                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.relative2003RG);
                                                                                                                                                                                                                                                                                                                                            if (radioGroup != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.relative2003Yes;
                                                                                                                                                                                                                                                                                                                                                RadioButton radioButton7 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.relative2003Yes);
                                                                                                                                                                                                                                                                                                                                                if (radioButton7 != null) {
                                                                                                                                                                                                                                                                                                                                                    i = R.id.relativeFullLL;
                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout25 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.relativeFullLL);
                                                                                                                                                                                                                                                                                                                                                    if (linearLayout25 != null) {
                                                                                                                                                                                                                                                                                                                                                        i = R.id.secondLL;
                                                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout26 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.secondLL);
                                                                                                                                                                                                                                                                                                                                                        if (linearLayout26 != null) {
                                                                                                                                                                                                                                                                                                                                                            i = R.id.secondLL1;
                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout27 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.secondLL1);
                                                                                                                                                                                                                                                                                                                                                            if (linearLayout27 != null) {
                                                                                                                                                                                                                                                                                                                                                                i = R.id.secondLLNew;
                                                                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout28 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.secondLLNew);
                                                                                                                                                                                                                                                                                                                                                                if (linearLayout28 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i = R.id.selectDetails;
                                                                                                                                                                                                                                                                                                                                                                    RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.selectDetails);
                                                                                                                                                                                                                                                                                                                                                                    if (radioGroup2 != null) {
                                                                                                                                                                                                                                                                                                                                                                        i = R.id.spinnerIR;
                                                                                                                                                                                                                                                                                                                                                                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.spinnerIR);
                                                                                                                                                                                                                                                                                                                                                                        if (spinner != null) {
                                                                                                                                                                                                                                                                                                                                                                            i = R.id.spinnerRelation;
                                                                                                                                                                                                                                                                                                                                                                            Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(rootView, R.id.spinnerRelation);
                                                                                                                                                                                                                                                                                                                                                                            if (spinner2 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i = R.id.spouseEpicNumber;
                                                                                                                                                                                                                                                                                                                                                                                EditText editText11 = (EditText) ViewBindings.findChildViewById(rootView, R.id.spouseEpicNumber);
                                                                                                                                                                                                                                                                                                                                                                                if (editText11 != null) {
                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.spouseName;
                                                                                                                                                                                                                                                                                                                                                                                    EditText editText12 = (EditText) ViewBindings.findChildViewById(rootView, R.id.spouseName);
                                                                                                                                                                                                                                                                                                                                                                                    if (editText12 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.submitButtonDoc;
                                                                                                                                                                                                                                                                                                                                                                                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submitButtonDoc);
                                                                                                                                                                                                                                                                                                                                                                                        if (button != null) {
                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.submitButtonRec;
                                                                                                                                                                                                                                                                                                                                                                                            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.submitButtonRec);
                                                                                                                                                                                                                                                                                                                                                                                            if (button2 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.submitLayout;
                                                                                                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout29 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.submitLayout);
                                                                                                                                                                                                                                                                                                                                                                                                if (linearLayout29 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.supportingDocumentsPage1;
                                                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout30 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1);
                                                                                                                                                                                                                                                                                                                                                                                                    if (linearLayout30 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.supportingDocumentsPage1Image;
                                                                                                                                                                                                                                                                                                                                                                                                        ImageView imageView28 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1Image);
                                                                                                                                                                                                                                                                                                                                                                                                        if (imageView28 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.supportingDocumentsPage1ImageName;
                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1ImageName);
                                                                                                                                                                                                                                                                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.supportingDocumentsPage1ImageSize;
                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1ImageSize);
                                                                                                                                                                                                                                                                                                                                                                                                                if (textView16 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.supportingDocumentsPage2;
                                                                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout31 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (linearLayout31 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.supportingDocumentsPage2Image;
                                                                                                                                                                                                                                                                                                                                                                                                                        ImageView imageView29 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2Image);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (imageView29 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.supportingDocumentsPage2ImageName;
                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2ImageName);
                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView17 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.supportingDocumentsPage2ImageSize;
                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2ImageSize);
                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView18 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.supprtingDocumentsLayout;
                                                                                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout32 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supprtingDocumentsLayout);
                                                                                                                                                                                                                                                                                                                                                                                                                                    if (linearLayout32 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.textView3;
                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.uploadBackPhoto;
                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadBackPhoto);
                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.uploadElectorImage;
                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadElectorImage);
                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView21 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.uploadEnumerationFormPage1;
                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadEnumerationFormPage1);
                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView22 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.uploadEnumerationFormPage2;
                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadEnumerationFormPage2);
                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView23 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.uploadFrontPhoto;
                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadFrontPhoto);
                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView24 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.uploadSupportingDocumentsPage1;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadSupportingDocumentsPage1);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView25 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.uploadSupportingDocumentsPage2;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadSupportingDocumentsPage2);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView26 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        return new ActivityViewFormByAeropage1BhBinding(linearLayout20, editText, linearLayout, imageView, imageView2, imageView3, imageView4, constraintLayoutFindChildViewById, radioButton, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, textView, linearLayout2, editText2, imageView12, imageView13, imageView14, imageView15, imageView16, imageView17, imageView18, imageView19, linearLayout3, linearLayout4, linearLayout5, imageView20, textView2, textView3, linearLayout6, imageView21, textView4, textView5, editText3, editText4, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, linearLayout12, linearLayout13, textView6, imageView22, imageView23, imageView24, imageView25, radioButton2, radioButton3, linearLayout14, linearLayout15, linearLayout16, linearLayout17, linearLayout18, linearLayout19, linearLayout20, editText5, editText6, editText7, textView7, radioButton4, radioButton5, linearLayout21, editText8, editText9, editText10, textView8, linearLayout22, imageView26, textView9, textView10, imageView27, linearLayout23, textView11, textView12, textView13, textView14, linearLayout24, radioButton6, radioGroup, radioButton7, linearLayout25, linearLayout26, linearLayout27, linearLayout28, radioGroup2, spinner, spinner2, editText11, editText12, button, button2, linearLayout29, linearLayout30, imageView28, textView15, textView16, linearLayout31, imageView29, textView17, textView18, linearLayout32, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26);
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
