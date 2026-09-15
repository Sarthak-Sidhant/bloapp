package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityUploadDocumentBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ImageView backImage;
    public final ImageView backImage1;
    public final ConstraintLayout blaTopLayout;
    public final ImageView cancelEnumerationFormPage1Image;
    public final ImageView cancelEnumerationFormPage2Image;
    public final ImageView cancelSupportingDocumentsPage1Image;
    public final ImageView cancelSupportingDocumentsPage2Image;
    public final LinearLayout ccEf;
    public final ImageView deleteBackImage;
    public final ImageView deleteBackImage1;
    public final ImageView deleteFrontImage;
    public final ImageView deleteFrontImage1;
    public final LinearLayout doc3DocumentsLayout;
    public final LinearLayout doc3DocumentsPage1;
    public final ImageView doc3DocumentsPage1Image;
    public final TextView doc3DocumentsPage1ImageName;
    public final TextView doc3DocumentsPage1ImageSize;
    public final LinearLayout doc3ImageLL1;
    public final ImageView doc3backImage1;
    public final ImageView doc3cancelSupportingDocumentsPage1Image;
    public final ImageView doc3cancelSupportingDocumentsPage2Image;
    public final ImageView doc3deleteBackImage1;
    public final ImageView doc3deleteFrontImage1;
    public final LinearLayout doc3firstLL1;
    public final ImageView doc3frontImage1;
    public final LinearLayout doc3lvSupportChoose1;
    public final LinearLayout doc3lvSupportChoose2;
    public final LinearLayout doc3secondLL1;
    public final LinearLayout doc3supportingDocumentsPage2;
    public final ImageView doc3supportingDocumentsPage2Image;
    public final TextView doc3supportingDocumentsPage2ImageName;
    public final TextView doc3supportingDocumentsPage2ImageSize;
    public final TextView doc3uploadSupportingDocumentsPage1;
    public final TextView doc3uploadSupportingDocumentsPage2;
    public final LinearLayout doc4DocumentsLayout;
    public final LinearLayout doc4DocumentsPage1;
    public final ImageView doc4DocumentsPage1Image;
    public final TextView doc4DocumentsPage1ImageName;
    public final TextView doc4DocumentsPage1ImageSize;
    public final LinearLayout doc4ImageLL1;
    public final ImageView doc4backImage1;
    public final ImageView doc4cancelSupportingDocumentsPage1Image;
    public final ImageView doc4cancelSupportingDocumentsPage2Image;
    public final ImageView doc4deleteBackImage1;
    public final ImageView doc4deleteFrontImage1;
    public final LinearLayout doc4firstLL1;
    public final ImageView doc4frontImage1;
    public final LinearLayout doc4lvSupportChoose1;
    public final LinearLayout doc4lvSupportChoose2;
    public final LinearLayout doc4secondLL1;
    public final LinearLayout doc4supportingDocumentsPage2;
    public final ImageView doc4supportingDocumentsPage2Image;
    public final TextView doc4supportingDocumentsPage2ImageName;
    public final TextView doc4supportingDocumentsPage2ImageSize;
    public final TextView doc4uploadSupportingDocumentsPage1;
    public final TextView doc4uploadSupportingDocumentsPage2;
    public final Spinner document2Spinner;
    public final RelativeLayout document3Heading;
    public final Spinner document3Spinner;
    public final RelativeLayout document4Heading;
    public final Spinner document4Spinner;
    public final Spinner documentSpinnerOne;
    public final TextView electorNamePendingSir;
    public final LinearLayout enumerationFormLayout;
    public final LinearLayout enumerationFormPage1;
    public final ImageView enumerationFormPage1Image;
    public final TextView enumerationFormPage1ImageName;
    public final TextView enumerationFormPage1ImageSize;
    public final LinearLayout enumerationFormPage2;
    public final ImageView enumerationFormPage2Image;
    public final TextView enumerationFormPage2ImageName;
    public final TextView enumerationFormPage2ImageSize;
    public final TextView epicPendingSir;
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
    private final ScrollView rootView;
    public final LinearLayout secondLL;
    public final LinearLayout secondLL1;
    public final TextView serialNoPendingSir;
    public final Button submitDocument;
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
    public final ImageView toolbarButton;
    public final TextView uploadEnumerationFormPage1;
    public final TextView uploadEnumerationFormPage2;
    public final TextView uploadEnumratioinPage2;
    public final RelativeLayout uploadEnumrationHeading;
    public final TextView uploadPage1Enumration;
    public final TextView uploadSupportingDocumentsPage1;
    public final TextView uploadSupportingDocumentsPage2;

    private ActivityUploadDocumentBinding(ScrollView rootView, ImageView backBtnIv, ImageView backImage, ImageView backImage1, ConstraintLayout blaTopLayout, ImageView cancelEnumerationFormPage1Image, ImageView cancelEnumerationFormPage2Image, ImageView cancelSupportingDocumentsPage1Image, ImageView cancelSupportingDocumentsPage2Image, LinearLayout ccEf, ImageView deleteBackImage, ImageView deleteBackImage1, ImageView deleteFrontImage, ImageView deleteFrontImage1, LinearLayout doc3DocumentsLayout, LinearLayout doc3DocumentsPage1, ImageView doc3DocumentsPage1Image, TextView doc3DocumentsPage1ImageName, TextView doc3DocumentsPage1ImageSize, LinearLayout doc3ImageLL1, ImageView doc3backImage1, ImageView doc3cancelSupportingDocumentsPage1Image, ImageView doc3cancelSupportingDocumentsPage2Image, ImageView doc3deleteBackImage1, ImageView doc3deleteFrontImage1, LinearLayout doc3firstLL1, ImageView doc3frontImage1, LinearLayout doc3lvSupportChoose1, LinearLayout doc3lvSupportChoose2, LinearLayout doc3secondLL1, LinearLayout doc3supportingDocumentsPage2, ImageView doc3supportingDocumentsPage2Image, TextView doc3supportingDocumentsPage2ImageName, TextView doc3supportingDocumentsPage2ImageSize, TextView doc3uploadSupportingDocumentsPage1, TextView doc3uploadSupportingDocumentsPage2, LinearLayout doc4DocumentsLayout, LinearLayout doc4DocumentsPage1, ImageView doc4DocumentsPage1Image, TextView doc4DocumentsPage1ImageName, TextView doc4DocumentsPage1ImageSize, LinearLayout doc4ImageLL1, ImageView doc4backImage1, ImageView doc4cancelSupportingDocumentsPage1Image, ImageView doc4cancelSupportingDocumentsPage2Image, ImageView doc4deleteBackImage1, ImageView doc4deleteFrontImage1, LinearLayout doc4firstLL1, ImageView doc4frontImage1, LinearLayout doc4lvSupportChoose1, LinearLayout doc4lvSupportChoose2, LinearLayout doc4secondLL1, LinearLayout doc4supportingDocumentsPage2, ImageView doc4supportingDocumentsPage2Image, TextView doc4supportingDocumentsPage2ImageName, TextView doc4supportingDocumentsPage2ImageSize, TextView doc4uploadSupportingDocumentsPage1, TextView doc4uploadSupportingDocumentsPage2, Spinner document2Spinner, RelativeLayout document3Heading, Spinner document3Spinner, RelativeLayout document4Heading, Spinner document4Spinner, Spinner documentSpinnerOne, TextView electorNamePendingSir, LinearLayout enumerationFormLayout, LinearLayout enumerationFormPage1, ImageView enumerationFormPage1Image, TextView enumerationFormPage1ImageName, TextView enumerationFormPage1ImageSize, LinearLayout enumerationFormPage2, ImageView enumerationFormPage2Image, TextView enumerationFormPage2ImageName, TextView enumerationFormPage2ImageSize, TextView epicPendingSir, LinearLayout fbImageLL, LinearLayout fbImageLL1, LinearLayout firstLL, LinearLayout firstLL1, ImageView frontImage, ImageView frontImage1, LinearLayout lvPage1EnumrationChoose, LinearLayout lvPage2EnumrationChoose, LinearLayout lvSupportChoose1, LinearLayout lvSupportChoose2, LinearLayout secondLL, LinearLayout secondLL1, TextView serialNoPendingSir, Button submitDocument, RelativeLayout supportedDocumentHeading, LinearLayout supportingDocumentsPage1, ImageView supportingDocumentsPage1Image, TextView supportingDocumentsPage1ImageName, TextView supportingDocumentsPage1ImageSize, LinearLayout supportingDocumentsPage2, ImageView supportingDocumentsPage2Image, TextView supportingDocumentsPage2ImageName, TextView supportingDocumentsPage2ImageSize, LinearLayout supprtingDocumentsLayout, TextView textView3, TextView textView5, ImageView toolbarButton, TextView uploadEnumerationFormPage1, TextView uploadEnumerationFormPage2, TextView uploadEnumratioinPage2, RelativeLayout uploadEnumrationHeading, TextView uploadPage1Enumration, TextView uploadSupportingDocumentsPage1, TextView uploadSupportingDocumentsPage2) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.backImage = backImage;
        this.backImage1 = backImage1;
        this.blaTopLayout = blaTopLayout;
        this.cancelEnumerationFormPage1Image = cancelEnumerationFormPage1Image;
        this.cancelEnumerationFormPage2Image = cancelEnumerationFormPage2Image;
        this.cancelSupportingDocumentsPage1Image = cancelSupportingDocumentsPage1Image;
        this.cancelSupportingDocumentsPage2Image = cancelSupportingDocumentsPage2Image;
        this.ccEf = ccEf;
        this.deleteBackImage = deleteBackImage;
        this.deleteBackImage1 = deleteBackImage1;
        this.deleteFrontImage = deleteFrontImage;
        this.deleteFrontImage1 = deleteFrontImage1;
        this.doc3DocumentsLayout = doc3DocumentsLayout;
        this.doc3DocumentsPage1 = doc3DocumentsPage1;
        this.doc3DocumentsPage1Image = doc3DocumentsPage1Image;
        this.doc3DocumentsPage1ImageName = doc3DocumentsPage1ImageName;
        this.doc3DocumentsPage1ImageSize = doc3DocumentsPage1ImageSize;
        this.doc3ImageLL1 = doc3ImageLL1;
        this.doc3backImage1 = doc3backImage1;
        this.doc3cancelSupportingDocumentsPage1Image = doc3cancelSupportingDocumentsPage1Image;
        this.doc3cancelSupportingDocumentsPage2Image = doc3cancelSupportingDocumentsPage2Image;
        this.doc3deleteBackImage1 = doc3deleteBackImage1;
        this.doc3deleteFrontImage1 = doc3deleteFrontImage1;
        this.doc3firstLL1 = doc3firstLL1;
        this.doc3frontImage1 = doc3frontImage1;
        this.doc3lvSupportChoose1 = doc3lvSupportChoose1;
        this.doc3lvSupportChoose2 = doc3lvSupportChoose2;
        this.doc3secondLL1 = doc3secondLL1;
        this.doc3supportingDocumentsPage2 = doc3supportingDocumentsPage2;
        this.doc3supportingDocumentsPage2Image = doc3supportingDocumentsPage2Image;
        this.doc3supportingDocumentsPage2ImageName = doc3supportingDocumentsPage2ImageName;
        this.doc3supportingDocumentsPage2ImageSize = doc3supportingDocumentsPage2ImageSize;
        this.doc3uploadSupportingDocumentsPage1 = doc3uploadSupportingDocumentsPage1;
        this.doc3uploadSupportingDocumentsPage2 = doc3uploadSupportingDocumentsPage2;
        this.doc4DocumentsLayout = doc4DocumentsLayout;
        this.doc4DocumentsPage1 = doc4DocumentsPage1;
        this.doc4DocumentsPage1Image = doc4DocumentsPage1Image;
        this.doc4DocumentsPage1ImageName = doc4DocumentsPage1ImageName;
        this.doc4DocumentsPage1ImageSize = doc4DocumentsPage1ImageSize;
        this.doc4ImageLL1 = doc4ImageLL1;
        this.doc4backImage1 = doc4backImage1;
        this.doc4cancelSupportingDocumentsPage1Image = doc4cancelSupportingDocumentsPage1Image;
        this.doc4cancelSupportingDocumentsPage2Image = doc4cancelSupportingDocumentsPage2Image;
        this.doc4deleteBackImage1 = doc4deleteBackImage1;
        this.doc4deleteFrontImage1 = doc4deleteFrontImage1;
        this.doc4firstLL1 = doc4firstLL1;
        this.doc4frontImage1 = doc4frontImage1;
        this.doc4lvSupportChoose1 = doc4lvSupportChoose1;
        this.doc4lvSupportChoose2 = doc4lvSupportChoose2;
        this.doc4secondLL1 = doc4secondLL1;
        this.doc4supportingDocumentsPage2 = doc4supportingDocumentsPage2;
        this.doc4supportingDocumentsPage2Image = doc4supportingDocumentsPage2Image;
        this.doc4supportingDocumentsPage2ImageName = doc4supportingDocumentsPage2ImageName;
        this.doc4supportingDocumentsPage2ImageSize = doc4supportingDocumentsPage2ImageSize;
        this.doc4uploadSupportingDocumentsPage1 = doc4uploadSupportingDocumentsPage1;
        this.doc4uploadSupportingDocumentsPage2 = doc4uploadSupportingDocumentsPage2;
        this.document2Spinner = document2Spinner;
        this.document3Heading = document3Heading;
        this.document3Spinner = document3Spinner;
        this.document4Heading = document4Heading;
        this.document4Spinner = document4Spinner;
        this.documentSpinnerOne = documentSpinnerOne;
        this.electorNamePendingSir = electorNamePendingSir;
        this.enumerationFormLayout = enumerationFormLayout;
        this.enumerationFormPage1 = enumerationFormPage1;
        this.enumerationFormPage1Image = enumerationFormPage1Image;
        this.enumerationFormPage1ImageName = enumerationFormPage1ImageName;
        this.enumerationFormPage1ImageSize = enumerationFormPage1ImageSize;
        this.enumerationFormPage2 = enumerationFormPage2;
        this.enumerationFormPage2Image = enumerationFormPage2Image;
        this.enumerationFormPage2ImageName = enumerationFormPage2ImageName;
        this.enumerationFormPage2ImageSize = enumerationFormPage2ImageSize;
        this.epicPendingSir = epicPendingSir;
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
        this.secondLL = secondLL;
        this.secondLL1 = secondLL1;
        this.serialNoPendingSir = serialNoPendingSir;
        this.submitDocument = submitDocument;
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
        this.toolbarButton = toolbarButton;
        this.uploadEnumerationFormPage1 = uploadEnumerationFormPage1;
        this.uploadEnumerationFormPage2 = uploadEnumerationFormPage2;
        this.uploadEnumratioinPage2 = uploadEnumratioinPage2;
        this.uploadEnumrationHeading = uploadEnumrationHeading;
        this.uploadPage1Enumration = uploadPage1Enumration;
        this.uploadSupportingDocumentsPage1 = uploadSupportingDocumentsPage1;
        this.uploadSupportingDocumentsPage2 = uploadSupportingDocumentsPage2;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ActivityUploadDocumentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityUploadDocumentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_upload_document, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityUploadDocumentBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
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
                                        i = R.id.ccEf;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ccEf);
                                        if (linearLayout != null) {
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
                                                            i = R.id.doc3DocumentsLayout;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc3DocumentsLayout);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.doc3DocumentsPage1;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc3DocumentsPage1);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.doc3DocumentsPage1Image;
                                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc3DocumentsPage1Image);
                                                                    if (imageView12 != null) {
                                                                        i = R.id.doc3DocumentsPage1ImageName;
                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3DocumentsPage1ImageName);
                                                                        if (textView != null) {
                                                                            i = R.id.doc3DocumentsPage1ImageSize;
                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3DocumentsPage1ImageSize);
                                                                            if (textView2 != null) {
                                                                                i = R.id.doc3ImageLL1;
                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc3ImageLL1);
                                                                                if (linearLayout4 != null) {
                                                                                    i = R.id.doc3backImage1;
                                                                                    ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc3backImage1);
                                                                                    if (imageView13 != null) {
                                                                                        i = R.id.doc3cancelSupportingDocumentsPage1Image;
                                                                                        ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc3cancelSupportingDocumentsPage1Image);
                                                                                        if (imageView14 != null) {
                                                                                            i = R.id.doc3cancelSupportingDocumentsPage2Image;
                                                                                            ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc3cancelSupportingDocumentsPage2Image);
                                                                                            if (imageView15 != null) {
                                                                                                i = R.id.doc3deleteBackImage1;
                                                                                                ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc3deleteBackImage1);
                                                                                                if (imageView16 != null) {
                                                                                                    i = R.id.doc3deleteFrontImage1;
                                                                                                    ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc3deleteFrontImage1);
                                                                                                    if (imageView17 != null) {
                                                                                                        i = R.id.doc3firstLL1;
                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc3firstLL1);
                                                                                                        if (linearLayout5 != null) {
                                                                                                            i = R.id.doc3frontImage1;
                                                                                                            ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc3frontImage1);
                                                                                                            if (imageView18 != null) {
                                                                                                                i = R.id.doc3lv_support_choose1;
                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc3lv_support_choose1);
                                                                                                                if (linearLayout6 != null) {
                                                                                                                    i = R.id.doc3lv_support_choose2;
                                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc3lv_support_choose2);
                                                                                                                    if (linearLayout7 != null) {
                                                                                                                        i = R.id.doc3secondLL1;
                                                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc3secondLL1);
                                                                                                                        if (linearLayout8 != null) {
                                                                                                                            i = R.id.doc3supportingDocumentsPage2;
                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc3supportingDocumentsPage2);
                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                i = R.id.doc3supportingDocumentsPage2Image;
                                                                                                                                ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc3supportingDocumentsPage2Image);
                                                                                                                                if (imageView19 != null) {
                                                                                                                                    i = R.id.doc3supportingDocumentsPage2ImageName;
                                                                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3supportingDocumentsPage2ImageName);
                                                                                                                                    if (textView3 != null) {
                                                                                                                                        i = R.id.doc3supportingDocumentsPage2ImageSize;
                                                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3supportingDocumentsPage2ImageSize);
                                                                                                                                        if (textView4 != null) {
                                                                                                                                            i = R.id.doc3uploadSupportingDocumentsPage1;
                                                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3uploadSupportingDocumentsPage1);
                                                                                                                                            if (textView5 != null) {
                                                                                                                                                i = R.id.doc3uploadSupportingDocumentsPage2;
                                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3uploadSupportingDocumentsPage2);
                                                                                                                                                if (textView6 != null) {
                                                                                                                                                    i = R.id.doc4DocumentsLayout;
                                                                                                                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc4DocumentsLayout);
                                                                                                                                                    if (linearLayout10 != null) {
                                                                                                                                                        i = R.id.doc4DocumentsPage1;
                                                                                                                                                        LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc4DocumentsPage1);
                                                                                                                                                        if (linearLayout11 != null) {
                                                                                                                                                            i = R.id.doc4DocumentsPage1Image;
                                                                                                                                                            ImageView imageView20 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc4DocumentsPage1Image);
                                                                                                                                                            if (imageView20 != null) {
                                                                                                                                                                i = R.id.doc4DocumentsPage1ImageName;
                                                                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4DocumentsPage1ImageName);
                                                                                                                                                                if (textView7 != null) {
                                                                                                                                                                    i = R.id.doc4DocumentsPage1ImageSize;
                                                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4DocumentsPage1ImageSize);
                                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                                        i = R.id.doc4ImageLL1;
                                                                                                                                                                        LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc4ImageLL1);
                                                                                                                                                                        if (linearLayout12 != null) {
                                                                                                                                                                            i = R.id.doc4backImage1;
                                                                                                                                                                            ImageView imageView21 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc4backImage1);
                                                                                                                                                                            if (imageView21 != null) {
                                                                                                                                                                                i = R.id.doc4cancelSupportingDocumentsPage1Image;
                                                                                                                                                                                ImageView imageView22 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc4cancelSupportingDocumentsPage1Image);
                                                                                                                                                                                if (imageView22 != null) {
                                                                                                                                                                                    i = R.id.doc4cancelSupportingDocumentsPage2Image;
                                                                                                                                                                                    ImageView imageView23 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc4cancelSupportingDocumentsPage2Image);
                                                                                                                                                                                    if (imageView23 != null) {
                                                                                                                                                                                        i = R.id.doc4deleteBackImage1;
                                                                                                                                                                                        ImageView imageView24 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc4deleteBackImage1);
                                                                                                                                                                                        if (imageView24 != null) {
                                                                                                                                                                                            i = R.id.doc4deleteFrontImage1;
                                                                                                                                                                                            ImageView imageView25 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc4deleteFrontImage1);
                                                                                                                                                                                            if (imageView25 != null) {
                                                                                                                                                                                                i = R.id.doc4firstLL1;
                                                                                                                                                                                                LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc4firstLL1);
                                                                                                                                                                                                if (linearLayout13 != null) {
                                                                                                                                                                                                    i = R.id.doc4frontImage1;
                                                                                                                                                                                                    ImageView imageView26 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc4frontImage1);
                                                                                                                                                                                                    if (imageView26 != null) {
                                                                                                                                                                                                        i = R.id.doc4lv_support_choose1;
                                                                                                                                                                                                        LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc4lv_support_choose1);
                                                                                                                                                                                                        if (linearLayout14 != null) {
                                                                                                                                                                                                            i = R.id.doc4lv_support_choose2;
                                                                                                                                                                                                            LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc4lv_support_choose2);
                                                                                                                                                                                                            if (linearLayout15 != null) {
                                                                                                                                                                                                                i = R.id.doc4secondLL1;
                                                                                                                                                                                                                LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc4secondLL1);
                                                                                                                                                                                                                if (linearLayout16 != null) {
                                                                                                                                                                                                                    i = R.id.doc4supportingDocumentsPage2;
                                                                                                                                                                                                                    LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc4supportingDocumentsPage2);
                                                                                                                                                                                                                    if (linearLayout17 != null) {
                                                                                                                                                                                                                        i = R.id.doc4supportingDocumentsPage2Image;
                                                                                                                                                                                                                        ImageView imageView27 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc4supportingDocumentsPage2Image);
                                                                                                                                                                                                                        if (imageView27 != null) {
                                                                                                                                                                                                                            i = R.id.doc4supportingDocumentsPage2ImageName;
                                                                                                                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4supportingDocumentsPage2ImageName);
                                                                                                                                                                                                                            if (textView9 != null) {
                                                                                                                                                                                                                                i = R.id.doc4supportingDocumentsPage2ImageSize;
                                                                                                                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4supportingDocumentsPage2ImageSize);
                                                                                                                                                                                                                                if (textView10 != null) {
                                                                                                                                                                                                                                    i = R.id.doc4uploadSupportingDocumentsPage1;
                                                                                                                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4uploadSupportingDocumentsPage1);
                                                                                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                                                                                        i = R.id.doc4uploadSupportingDocumentsPage2;
                                                                                                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4uploadSupportingDocumentsPage2);
                                                                                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                                                                                            i = R.id.document2_spinner;
                                                                                                                                                                                                                                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.document2_spinner);
                                                                                                                                                                                                                                            if (spinner != null) {
                                                                                                                                                                                                                                                i = R.id.document3_heading;
                                                                                                                                                                                                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.document3_heading);
                                                                                                                                                                                                                                                if (relativeLayout != null) {
                                                                                                                                                                                                                                                    i = R.id.document3_spinner;
                                                                                                                                                                                                                                                    Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(rootView, R.id.document3_spinner);
                                                                                                                                                                                                                                                    if (spinner2 != null) {
                                                                                                                                                                                                                                                        i = R.id.document4_heading;
                                                                                                                                                                                                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.document4_heading);
                                                                                                                                                                                                                                                        if (relativeLayout2 != null) {
                                                                                                                                                                                                                                                            i = R.id.document4_spinner;
                                                                                                                                                                                                                                                            Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(rootView, R.id.document4_spinner);
                                                                                                                                                                                                                                                            if (spinner3 != null) {
                                                                                                                                                                                                                                                                i = R.id.documentSpinnerOne;
                                                                                                                                                                                                                                                                Spinner spinner4 = (Spinner) ViewBindings.findChildViewById(rootView, R.id.documentSpinnerOne);
                                                                                                                                                                                                                                                                if (spinner4 != null) {
                                                                                                                                                                                                                                                                    i = R.id.electorName_pending_sir;
                                                                                                                                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorName_pending_sir);
                                                                                                                                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                                                                                                                                        i = R.id.enumerationFormLayout;
                                                                                                                                                                                                                                                                        LinearLayout linearLayout18 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.enumerationFormLayout);
                                                                                                                                                                                                                                                                        if (linearLayout18 != null) {
                                                                                                                                                                                                                                                                            i = R.id.enumerationFormPage1;
                                                                                                                                                                                                                                                                            LinearLayout linearLayout19 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage1);
                                                                                                                                                                                                                                                                            if (linearLayout19 != null) {
                                                                                                                                                                                                                                                                                i = R.id.enumerationFormPage1Image;
                                                                                                                                                                                                                                                                                ImageView imageView28 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage1Image);
                                                                                                                                                                                                                                                                                if (imageView28 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.enumerationFormPage1ImageName;
                                                                                                                                                                                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage1ImageName);
                                                                                                                                                                                                                                                                                    if (textView14 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.enumerationFormPage1ImageSize;
                                                                                                                                                                                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage1ImageSize);
                                                                                                                                                                                                                                                                                        if (textView15 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.enumerationFormPage2;
                                                                                                                                                                                                                                                                                            LinearLayout linearLayout20 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2);
                                                                                                                                                                                                                                                                                            if (linearLayout20 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.enumerationFormPage2Image;
                                                                                                                                                                                                                                                                                                ImageView imageView29 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2Image);
                                                                                                                                                                                                                                                                                                if (imageView29 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.enumerationFormPage2ImageName;
                                                                                                                                                                                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2ImageName);
                                                                                                                                                                                                                                                                                                    if (textView16 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.enumerationFormPage2ImageSize;
                                                                                                                                                                                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enumerationFormPage2ImageSize);
                                                                                                                                                                                                                                                                                                        if (textView17 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.epic_pending_sir;
                                                                                                                                                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_pending_sir);
                                                                                                                                                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.fbImageLL;
                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout21 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fbImageLL);
                                                                                                                                                                                                                                                                                                                if (linearLayout21 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.fbImageLL1;
                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout22 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fbImageLL1);
                                                                                                                                                                                                                                                                                                                    if (linearLayout22 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.firstLL;
                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout23 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.firstLL);
                                                                                                                                                                                                                                                                                                                        if (linearLayout23 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.firstLL1;
                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout24 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.firstLL1);
                                                                                                                                                                                                                                                                                                                            if (linearLayout24 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.frontImage;
                                                                                                                                                                                                                                                                                                                                ImageView imageView30 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.frontImage);
                                                                                                                                                                                                                                                                                                                                if (imageView30 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.frontImage1;
                                                                                                                                                                                                                                                                                                                                    ImageView imageView31 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.frontImage1);
                                                                                                                                                                                                                                                                                                                                    if (imageView31 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.lv_page1_enumration_choose;
                                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout25 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_page1_enumration_choose);
                                                                                                                                                                                                                                                                                                                                        if (linearLayout25 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.lv_page2_enumration_choose;
                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout26 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_page2_enumration_choose);
                                                                                                                                                                                                                                                                                                                                            if (linearLayout26 != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.lv_support_choose1;
                                                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout27 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_support_choose1);
                                                                                                                                                                                                                                                                                                                                                if (linearLayout27 != null) {
                                                                                                                                                                                                                                                                                                                                                    i = R.id.lv_support_choose2;
                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout28 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_support_choose2);
                                                                                                                                                                                                                                                                                                                                                    if (linearLayout28 != null) {
                                                                                                                                                                                                                                                                                                                                                        i = R.id.secondLL;
                                                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout29 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.secondLL);
                                                                                                                                                                                                                                                                                                                                                        if (linearLayout29 != null) {
                                                                                                                                                                                                                                                                                                                                                            i = R.id.secondLL1;
                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout30 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.secondLL1);
                                                                                                                                                                                                                                                                                                                                                            if (linearLayout30 != null) {
                                                                                                                                                                                                                                                                                                                                                                i = R.id.serialNo_pending_sir;
                                                                                                                                                                                                                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNo_pending_sir);
                                                                                                                                                                                                                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i = R.id.submitDocument;
                                                                                                                                                                                                                                                                                                                                                                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submitDocument);
                                                                                                                                                                                                                                                                                                                                                                    if (button != null) {
                                                                                                                                                                                                                                                                                                                                                                        i = R.id.supported_document_heading;
                                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.supported_document_heading);
                                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout3 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i = R.id.supportingDocumentsPage1;
                                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout31 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1);
                                                                                                                                                                                                                                                                                                                                                                            if (linearLayout31 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i = R.id.supportingDocumentsPage1Image;
                                                                                                                                                                                                                                                                                                                                                                                ImageView imageView32 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1Image);
                                                                                                                                                                                                                                                                                                                                                                                if (imageView32 != null) {
                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.supportingDocumentsPage1ImageName;
                                                                                                                                                                                                                                                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1ImageName);
                                                                                                                                                                                                                                                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.supportingDocumentsPage1ImageSize;
                                                                                                                                                                                                                                                                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1ImageSize);
                                                                                                                                                                                                                                                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.supportingDocumentsPage2;
                                                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout32 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2);
                                                                                                                                                                                                                                                                                                                                                                                            if (linearLayout32 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.supportingDocumentsPage2Image;
                                                                                                                                                                                                                                                                                                                                                                                                ImageView imageView33 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2Image);
                                                                                                                                                                                                                                                                                                                                                                                                if (imageView33 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.supportingDocumentsPage2ImageName;
                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2ImageName);
                                                                                                                                                                                                                                                                                                                                                                                                    if (textView22 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.supportingDocumentsPage2ImageSize;
                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2ImageSize);
                                                                                                                                                                                                                                                                                                                                                                                                        if (textView23 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.supprtingDocumentsLayout;
                                                                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout33 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supprtingDocumentsLayout);
                                                                                                                                                                                                                                                                                                                                                                                                            if (linearLayout33 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.textView3;
                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                                                                                                                                                                                                                                                                                                if (textView24 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.textView5;
                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.toolbar_button;
                                                                                                                                                                                                                                                                                                                                                                                                                        ImageView imageView34 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (imageView34 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.uploadEnumerationFormPage1;
                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadEnumerationFormPage1);
                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.uploadEnumerationFormPage2;
                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadEnumerationFormPage2);
                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView27 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.upload_enumratioin_page_2;
                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_enumratioin_page_2);
                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView28 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.upload_enumration_heading;
                                                                                                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.upload_enumration_heading);
                                                                                                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout4 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.upload_page1_enumration;
                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_page1_enumration);
                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView29 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.uploadSupportingDocumentsPage1;
                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadSupportingDocumentsPage1);
                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView30 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.uploadSupportingDocumentsPage2;
                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadSupportingDocumentsPage2);
                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView31 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                        return new ActivityUploadDocumentBinding((ScrollView) rootView, imageView, imageView2, imageView3, constraintLayoutFindChildViewById, imageView4, imageView5, imageView6, imageView7, linearLayout, imageView8, imageView9, imageView10, imageView11, linearLayout2, linearLayout3, imageView12, textView, textView2, linearLayout4, imageView13, imageView14, imageView15, imageView16, imageView17, linearLayout5, imageView18, linearLayout6, linearLayout7, linearLayout8, linearLayout9, imageView19, textView3, textView4, textView5, textView6, linearLayout10, linearLayout11, imageView20, textView7, textView8, linearLayout12, imageView21, imageView22, imageView23, imageView24, imageView25, linearLayout13, imageView26, linearLayout14, linearLayout15, linearLayout16, linearLayout17, imageView27, textView9, textView10, textView11, textView12, spinner, relativeLayout, spinner2, relativeLayout2, spinner3, spinner4, textView13, linearLayout18, linearLayout19, imageView28, textView14, textView15, linearLayout20, imageView29, textView16, textView17, textView18, linearLayout21, linearLayout22, linearLayout23, linearLayout24, imageView30, imageView31, linearLayout25, linearLayout26, linearLayout27, linearLayout28, linearLayout29, linearLayout30, textView19, button, relativeLayout3, linearLayout31, imageView32, textView20, textView21, linearLayout32, imageView33, textView22, textView23, linearLayout33, textView24, textView25, imageView34, textView26, textView27, textView28, relativeLayout4, textView29, textView30, textView31);
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
