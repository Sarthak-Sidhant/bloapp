package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class GrandparentIncludeBinding implements ViewBinding {
    public final ImageView backImage1;
    public final ImageView cancelSupportingDocumentsPage1Image;
    public final ImageView cancelSupportingDocumentsPage2Image;
    public final ImageView cancelgrandParentSpinner1Page1Image;
    public final ImageView cancelgrandParentSpinner1Page2Image;
    public final ImageView deleteBackImage1;
    public final ImageView deleteFrontImage1;
    public final ImageView doc3cancelgrandParentSpinner1Page1Image;
    public final ImageView doc3cancelgrandParentSpinner1Page2Image;
    public final Spinner doc3documentSpinner2GrandParent;
    public final LinearLayout doc3grandParentSpinner1Page1;
    public final ImageView doc3grandParentSpinner1Page1Image;
    public final TextView doc3grandParentSpinner1Page1ImageName;
    public final TextView doc3grandParentSpinner1Page1ImageSize;
    public final LinearLayout doc3grandParentSpinner1Page2;
    public final ImageView doc3grandParentSpinner1Page2Image;
    public final TextView doc3grandParentSpinner1Page2ImageName;
    public final TextView doc3grandParentSpinner1Page2ImageSize;
    public final LinearLayout doc3grandParentSpinnerDocumentayout;
    public final LinearLayout doc3lvGrandParentSpinner;
    public final LinearLayout doc3lvPage1GpspinnerDocumentChoose;
    public final LinearLayout doc3lvPage2GpSpinner1Choose;
    public final TextView doc3uploadGPSpinner1Page2;
    public final TextView doc3uploadGpSpinner1Page1;
    public final TextView doc3uploadGpSpinner1Page2;
    public final TextView doc3uploadPage1GpSpinner1;
    public final ImageView doc4cancelgrandParentSpinner1Page1Image;
    public final ImageView doc4cancelgrandParentSpinner1Page2Image;
    public final Spinner doc4documentSpinner2GrandParent;
    public final LinearLayout doc4grandParentSpinner1Page1;
    public final ImageView doc4grandParentSpinner1Page1Image;
    public final TextView doc4grandParentSpinner1Page1ImageName;
    public final TextView doc4grandParentSpinner1Page1ImageSize;
    public final LinearLayout doc4grandParentSpinner1Page2;
    public final ImageView doc4grandParentSpinner1Page2Image;
    public final TextView doc4grandParentSpinner1Page2ImageName;
    public final TextView doc4grandParentSpinner1Page2ImageSize;
    public final LinearLayout doc4grandParentSpinnerDocumentayout;
    public final LinearLayout doc4lvGrandParentSpinner;
    public final LinearLayout doc4lvPage1GpspinnerDocumentChoose;
    public final LinearLayout doc4lvPage2GpSpinner1Choose;
    public final TextView doc4uploadGPSpinner1Page2;
    public final TextView doc4uploadGpSpinner1Page1;
    public final TextView doc4uploadGpSpinner1Page2;
    public final TextView doc4uploadPage1GpSpinner1;
    public final Spinner documentSpinner2GrandParent;
    public final Spinner documentSpinnerGrandParent;
    public final LinearLayout fbImageLL1;
    public final LinearLayout firstLL1;
    public final ImageView frontImage1;
    public final LinearLayout grandParentSpinner1Page1;
    public final ImageView grandParentSpinner1Page1Image;
    public final TextView grandParentSpinner1Page1ImageName;
    public final TextView grandParentSpinner1Page1ImageSize;
    public final LinearLayout grandParentSpinner1Page2;
    public final ImageView grandParentSpinner1Page2Image;
    public final TextView grandParentSpinner1Page2ImageName;
    public final TextView grandParentSpinner1Page2ImageSize;
    public final LinearLayout grandParentSpinnerDocumentayout;
    public final TextView grandparentLablel;
    public final LinearLayout lvAadharGrandParentSpinner;
    public final CardView lvGrandparent;
    public final LinearLayout lvPage1GpspinnerDocumentChoose;
    public final LinearLayout lvPage2GpSpinner1Choose;
    public final LinearLayout lvSupportChoose1;
    public final LinearLayout lvSupportChoose2;
    private final LinearLayout rootView;
    public final LinearLayout secondLL1;
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
    public final TextView uploadGPSpinner1Page2;
    public final TextView uploadGpSpinner1Page1;
    public final TextView uploadGpSpinner1Page2;
    public final TextView uploadPage1GpSpinner1;
    public final TextView uploadSupportingDocumentsPage1;
    public final TextView uploadSupportingDocumentsPage2;

    private GrandparentIncludeBinding(LinearLayout rootView, ImageView backImage1, ImageView cancelSupportingDocumentsPage1Image, ImageView cancelSupportingDocumentsPage2Image, ImageView cancelgrandParentSpinner1Page1Image, ImageView cancelgrandParentSpinner1Page2Image, ImageView deleteBackImage1, ImageView deleteFrontImage1, ImageView doc3cancelgrandParentSpinner1Page1Image, ImageView doc3cancelgrandParentSpinner1Page2Image, Spinner doc3documentSpinner2GrandParent, LinearLayout doc3grandParentSpinner1Page1, ImageView doc3grandParentSpinner1Page1Image, TextView doc3grandParentSpinner1Page1ImageName, TextView doc3grandParentSpinner1Page1ImageSize, LinearLayout doc3grandParentSpinner1Page2, ImageView doc3grandParentSpinner1Page2Image, TextView doc3grandParentSpinner1Page2ImageName, TextView doc3grandParentSpinner1Page2ImageSize, LinearLayout doc3grandParentSpinnerDocumentayout, LinearLayout doc3lvGrandParentSpinner, LinearLayout doc3lvPage1GpspinnerDocumentChoose, LinearLayout doc3lvPage2GpSpinner1Choose, TextView doc3uploadGPSpinner1Page2, TextView doc3uploadGpSpinner1Page1, TextView doc3uploadGpSpinner1Page2, TextView doc3uploadPage1GpSpinner1, ImageView doc4cancelgrandParentSpinner1Page1Image, ImageView doc4cancelgrandParentSpinner1Page2Image, Spinner doc4documentSpinner2GrandParent, LinearLayout doc4grandParentSpinner1Page1, ImageView doc4grandParentSpinner1Page1Image, TextView doc4grandParentSpinner1Page1ImageName, TextView doc4grandParentSpinner1Page1ImageSize, LinearLayout doc4grandParentSpinner1Page2, ImageView doc4grandParentSpinner1Page2Image, TextView doc4grandParentSpinner1Page2ImageName, TextView doc4grandParentSpinner1Page2ImageSize, LinearLayout doc4grandParentSpinnerDocumentayout, LinearLayout doc4lvGrandParentSpinner, LinearLayout doc4lvPage1GpspinnerDocumentChoose, LinearLayout doc4lvPage2GpSpinner1Choose, TextView doc4uploadGPSpinner1Page2, TextView doc4uploadGpSpinner1Page1, TextView doc4uploadGpSpinner1Page2, TextView doc4uploadPage1GpSpinner1, Spinner documentSpinner2GrandParent, Spinner documentSpinnerGrandParent, LinearLayout fbImageLL1, LinearLayout firstLL1, ImageView frontImage1, LinearLayout grandParentSpinner1Page1, ImageView grandParentSpinner1Page1Image, TextView grandParentSpinner1Page1ImageName, TextView grandParentSpinner1Page1ImageSize, LinearLayout grandParentSpinner1Page2, ImageView grandParentSpinner1Page2Image, TextView grandParentSpinner1Page2ImageName, TextView grandParentSpinner1Page2ImageSize, LinearLayout grandParentSpinnerDocumentayout, TextView grandparentLablel, LinearLayout lvAadharGrandParentSpinner, CardView lvGrandparent, LinearLayout lvPage1GpspinnerDocumentChoose, LinearLayout lvPage2GpSpinner1Choose, LinearLayout lvSupportChoose1, LinearLayout lvSupportChoose2, LinearLayout secondLL1, RelativeLayout supportedDocumentHeading, LinearLayout supportingDocumentsPage1, ImageView supportingDocumentsPage1Image, TextView supportingDocumentsPage1ImageName, TextView supportingDocumentsPage1ImageSize, LinearLayout supportingDocumentsPage2, ImageView supportingDocumentsPage2Image, TextView supportingDocumentsPage2ImageName, TextView supportingDocumentsPage2ImageSize, LinearLayout supprtingDocumentsLayout, TextView uploadGPSpinner1Page2, TextView uploadGpSpinner1Page1, TextView uploadGpSpinner1Page2, TextView uploadPage1GpSpinner1, TextView uploadSupportingDocumentsPage1, TextView uploadSupportingDocumentsPage2) {
        this.rootView = rootView;
        this.backImage1 = backImage1;
        this.cancelSupportingDocumentsPage1Image = cancelSupportingDocumentsPage1Image;
        this.cancelSupportingDocumentsPage2Image = cancelSupportingDocumentsPage2Image;
        this.cancelgrandParentSpinner1Page1Image = cancelgrandParentSpinner1Page1Image;
        this.cancelgrandParentSpinner1Page2Image = cancelgrandParentSpinner1Page2Image;
        this.deleteBackImage1 = deleteBackImage1;
        this.deleteFrontImage1 = deleteFrontImage1;
        this.doc3cancelgrandParentSpinner1Page1Image = doc3cancelgrandParentSpinner1Page1Image;
        this.doc3cancelgrandParentSpinner1Page2Image = doc3cancelgrandParentSpinner1Page2Image;
        this.doc3documentSpinner2GrandParent = doc3documentSpinner2GrandParent;
        this.doc3grandParentSpinner1Page1 = doc3grandParentSpinner1Page1;
        this.doc3grandParentSpinner1Page1Image = doc3grandParentSpinner1Page1Image;
        this.doc3grandParentSpinner1Page1ImageName = doc3grandParentSpinner1Page1ImageName;
        this.doc3grandParentSpinner1Page1ImageSize = doc3grandParentSpinner1Page1ImageSize;
        this.doc3grandParentSpinner1Page2 = doc3grandParentSpinner1Page2;
        this.doc3grandParentSpinner1Page2Image = doc3grandParentSpinner1Page2Image;
        this.doc3grandParentSpinner1Page2ImageName = doc3grandParentSpinner1Page2ImageName;
        this.doc3grandParentSpinner1Page2ImageSize = doc3grandParentSpinner1Page2ImageSize;
        this.doc3grandParentSpinnerDocumentayout = doc3grandParentSpinnerDocumentayout;
        this.doc3lvGrandParentSpinner = doc3lvGrandParentSpinner;
        this.doc3lvPage1GpspinnerDocumentChoose = doc3lvPage1GpspinnerDocumentChoose;
        this.doc3lvPage2GpSpinner1Choose = doc3lvPage2GpSpinner1Choose;
        this.doc3uploadGPSpinner1Page2 = doc3uploadGPSpinner1Page2;
        this.doc3uploadGpSpinner1Page1 = doc3uploadGpSpinner1Page1;
        this.doc3uploadGpSpinner1Page2 = doc3uploadGpSpinner1Page2;
        this.doc3uploadPage1GpSpinner1 = doc3uploadPage1GpSpinner1;
        this.doc4cancelgrandParentSpinner1Page1Image = doc4cancelgrandParentSpinner1Page1Image;
        this.doc4cancelgrandParentSpinner1Page2Image = doc4cancelgrandParentSpinner1Page2Image;
        this.doc4documentSpinner2GrandParent = doc4documentSpinner2GrandParent;
        this.doc4grandParentSpinner1Page1 = doc4grandParentSpinner1Page1;
        this.doc4grandParentSpinner1Page1Image = doc4grandParentSpinner1Page1Image;
        this.doc4grandParentSpinner1Page1ImageName = doc4grandParentSpinner1Page1ImageName;
        this.doc4grandParentSpinner1Page1ImageSize = doc4grandParentSpinner1Page1ImageSize;
        this.doc4grandParentSpinner1Page2 = doc4grandParentSpinner1Page2;
        this.doc4grandParentSpinner1Page2Image = doc4grandParentSpinner1Page2Image;
        this.doc4grandParentSpinner1Page2ImageName = doc4grandParentSpinner1Page2ImageName;
        this.doc4grandParentSpinner1Page2ImageSize = doc4grandParentSpinner1Page2ImageSize;
        this.doc4grandParentSpinnerDocumentayout = doc4grandParentSpinnerDocumentayout;
        this.doc4lvGrandParentSpinner = doc4lvGrandParentSpinner;
        this.doc4lvPage1GpspinnerDocumentChoose = doc4lvPage1GpspinnerDocumentChoose;
        this.doc4lvPage2GpSpinner1Choose = doc4lvPage2GpSpinner1Choose;
        this.doc4uploadGPSpinner1Page2 = doc4uploadGPSpinner1Page2;
        this.doc4uploadGpSpinner1Page1 = doc4uploadGpSpinner1Page1;
        this.doc4uploadGpSpinner1Page2 = doc4uploadGpSpinner1Page2;
        this.doc4uploadPage1GpSpinner1 = doc4uploadPage1GpSpinner1;
        this.documentSpinner2GrandParent = documentSpinner2GrandParent;
        this.documentSpinnerGrandParent = documentSpinnerGrandParent;
        this.fbImageLL1 = fbImageLL1;
        this.firstLL1 = firstLL1;
        this.frontImage1 = frontImage1;
        this.grandParentSpinner1Page1 = grandParentSpinner1Page1;
        this.grandParentSpinner1Page1Image = grandParentSpinner1Page1Image;
        this.grandParentSpinner1Page1ImageName = grandParentSpinner1Page1ImageName;
        this.grandParentSpinner1Page1ImageSize = grandParentSpinner1Page1ImageSize;
        this.grandParentSpinner1Page2 = grandParentSpinner1Page2;
        this.grandParentSpinner1Page2Image = grandParentSpinner1Page2Image;
        this.grandParentSpinner1Page2ImageName = grandParentSpinner1Page2ImageName;
        this.grandParentSpinner1Page2ImageSize = grandParentSpinner1Page2ImageSize;
        this.grandParentSpinnerDocumentayout = grandParentSpinnerDocumentayout;
        this.grandparentLablel = grandparentLablel;
        this.lvAadharGrandParentSpinner = lvAadharGrandParentSpinner;
        this.lvGrandparent = lvGrandparent;
        this.lvPage1GpspinnerDocumentChoose = lvPage1GpspinnerDocumentChoose;
        this.lvPage2GpSpinner1Choose = lvPage2GpSpinner1Choose;
        this.lvSupportChoose1 = lvSupportChoose1;
        this.lvSupportChoose2 = lvSupportChoose2;
        this.secondLL1 = secondLL1;
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
        this.uploadGPSpinner1Page2 = uploadGPSpinner1Page2;
        this.uploadGpSpinner1Page1 = uploadGpSpinner1Page1;
        this.uploadGpSpinner1Page2 = uploadGpSpinner1Page2;
        this.uploadPage1GpSpinner1 = uploadPage1GpSpinner1;
        this.uploadSupportingDocumentsPage1 = uploadSupportingDocumentsPage1;
        this.uploadSupportingDocumentsPage2 = uploadSupportingDocumentsPage2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static GrandparentIncludeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static GrandparentIncludeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.grandparent_include, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static GrandparentIncludeBinding bind(View rootView) {
        int i = R.id.backImage1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.backImage1);
        if (imageView != null) {
            i = R.id.cancelSupportingDocumentsPage1Image;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelSupportingDocumentsPage1Image);
            if (imageView2 != null) {
                i = R.id.cancelSupportingDocumentsPage2Image;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelSupportingDocumentsPage2Image);
                if (imageView3 != null) {
                    i = R.id.cancelgrandParentSpinner1Page1Image;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelgrandParentSpinner1Page1Image);
                    if (imageView4 != null) {
                        i = R.id.cancelgrandParentSpinner1Page2Image;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelgrandParentSpinner1Page2Image);
                        if (imageView5 != null) {
                            i = R.id.deleteBackImage1;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteBackImage1);
                            if (imageView6 != null) {
                                i = R.id.deleteFrontImage1;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteFrontImage1);
                                if (imageView7 != null) {
                                    i = R.id.doc3cancelgrandParentSpinner1Page1Image;
                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc3cancelgrandParentSpinner1Page1Image);
                                    if (imageView8 != null) {
                                        i = R.id.doc3cancelgrandParentSpinner1Page2Image;
                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc3cancelgrandParentSpinner1Page2Image);
                                        if (imageView9 != null) {
                                            i = R.id.doc3documentSpinner2GrandParent;
                                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.doc3documentSpinner2GrandParent);
                                            if (spinner != null) {
                                                i = R.id.doc3grandParentSpinner1Page1;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc3grandParentSpinner1Page1);
                                                if (linearLayout != null) {
                                                    i = R.id.doc3grandParentSpinner1Page1Image;
                                                    ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc3grandParentSpinner1Page1Image);
                                                    if (imageView10 != null) {
                                                        i = R.id.doc3grandParentSpinner1Page1ImageName;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3grandParentSpinner1Page1ImageName);
                                                        if (textView != null) {
                                                            i = R.id.doc3grandParentSpinner1Page1ImageSize;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3grandParentSpinner1Page1ImageSize);
                                                            if (textView2 != null) {
                                                                i = R.id.doc3grandParentSpinner1Page2;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc3grandParentSpinner1Page2);
                                                                if (linearLayout2 != null) {
                                                                    i = R.id.doc3grandParentSpinner1Page2Image;
                                                                    ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc3grandParentSpinner1Page2Image);
                                                                    if (imageView11 != null) {
                                                                        i = R.id.doc3grandParentSpinner1Page2ImageName;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3grandParentSpinner1Page2ImageName);
                                                                        if (textView3 != null) {
                                                                            i = R.id.doc3grandParentSpinner1Page2ImageSize;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3grandParentSpinner1Page2ImageSize);
                                                                            if (textView4 != null) {
                                                                                i = R.id.doc3grandParentSpinnerDocumentayout;
                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc3grandParentSpinnerDocumentayout);
                                                                                if (linearLayout3 != null) {
                                                                                    i = R.id.doc3lvGrandParentSpinner;
                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc3lvGrandParentSpinner);
                                                                                    if (linearLayout4 != null) {
                                                                                        i = R.id.doc3lv_page1_GpspinnerDocument_choose;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc3lv_page1_GpspinnerDocument_choose);
                                                                                        if (linearLayout5 != null) {
                                                                                            i = R.id.doc3lv_page2_gp_spinner1_choose;
                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc3lv_page2_gp_spinner1_choose);
                                                                                            if (linearLayout6 != null) {
                                                                                                i = R.id.doc3uploadGPSpinner1Page2;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3uploadGPSpinner1Page2);
                                                                                                if (textView5 != null) {
                                                                                                    i = R.id.doc3uploadGpSpinner1Page1;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3uploadGpSpinner1Page1);
                                                                                                    if (textView6 != null) {
                                                                                                        i = R.id.doc3upload_gp_spinner1_page_2;
                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3upload_gp_spinner1_page_2);
                                                                                                        if (textView7 != null) {
                                                                                                            i = R.id.doc3upload_page1_gp_spinner1;
                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3upload_page1_gp_spinner1);
                                                                                                            if (textView8 != null) {
                                                                                                                i = R.id.doc4cancelgrandParentSpinner1Page1Image;
                                                                                                                ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc4cancelgrandParentSpinner1Page1Image);
                                                                                                                if (imageView12 != null) {
                                                                                                                    i = R.id.doc4cancelgrandParentSpinner1Page2Image;
                                                                                                                    ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc4cancelgrandParentSpinner1Page2Image);
                                                                                                                    if (imageView13 != null) {
                                                                                                                        i = R.id.doc4documentSpinner2GrandParent;
                                                                                                                        Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(rootView, R.id.doc4documentSpinner2GrandParent);
                                                                                                                        if (spinner2 != null) {
                                                                                                                            i = R.id.doc4grandParentSpinner1Page1;
                                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc4grandParentSpinner1Page1);
                                                                                                                            if (linearLayout7 != null) {
                                                                                                                                i = R.id.doc4grandParentSpinner1Page1Image;
                                                                                                                                ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc4grandParentSpinner1Page1Image);
                                                                                                                                if (imageView14 != null) {
                                                                                                                                    i = R.id.doc4grandParentSpinner1Page1ImageName;
                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4grandParentSpinner1Page1ImageName);
                                                                                                                                    if (textView9 != null) {
                                                                                                                                        i = R.id.doc4grandParentSpinner1Page1ImageSize;
                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4grandParentSpinner1Page1ImageSize);
                                                                                                                                        if (textView10 != null) {
                                                                                                                                            i = R.id.doc4grandParentSpinner1Page2;
                                                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc4grandParentSpinner1Page2);
                                                                                                                                            if (linearLayout8 != null) {
                                                                                                                                                i = R.id.doc4grandParentSpinner1Page2Image;
                                                                                                                                                ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doc4grandParentSpinner1Page2Image);
                                                                                                                                                if (imageView15 != null) {
                                                                                                                                                    i = R.id.doc4grandParentSpinner1Page2ImageName;
                                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4grandParentSpinner1Page2ImageName);
                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                        i = R.id.doc4grandParentSpinner1Page2ImageSize;
                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4grandParentSpinner1Page2ImageSize);
                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                            i = R.id.doc4grandParentSpinnerDocumentayout;
                                                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc4grandParentSpinnerDocumentayout);
                                                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                                                i = R.id.doc4lvGrandParentSpinner;
                                                                                                                                                                LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc4lvGrandParentSpinner);
                                                                                                                                                                if (linearLayout10 != null) {
                                                                                                                                                                    i = R.id.doc4lv_page1_GpspinnerDocument_choose;
                                                                                                                                                                    LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc4lv_page1_GpspinnerDocument_choose);
                                                                                                                                                                    if (linearLayout11 != null) {
                                                                                                                                                                        i = R.id.doc4lv_page2_gp_spinner1_choose;
                                                                                                                                                                        LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doc4lv_page2_gp_spinner1_choose);
                                                                                                                                                                        if (linearLayout12 != null) {
                                                                                                                                                                            i = R.id.doc4uploadGPSpinner1Page2;
                                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4uploadGPSpinner1Page2);
                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                i = R.id.doc4uploadGpSpinner1Page1;
                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4uploadGpSpinner1Page1);
                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                    i = R.id.doc4upload_gp_spinner1_page_2;
                                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4upload_gp_spinner1_page_2);
                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                        i = R.id.doc4upload_page1_gp_spinner1;
                                                                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4upload_page1_gp_spinner1);
                                                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                                                            i = R.id.documentSpinner2GrandParent;
                                                                                                                                                                                            Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(rootView, R.id.documentSpinner2GrandParent);
                                                                                                                                                                                            if (spinner3 != null) {
                                                                                                                                                                                                i = R.id.documentSpinnerGrandParent;
                                                                                                                                                                                                Spinner spinner4 = (Spinner) ViewBindings.findChildViewById(rootView, R.id.documentSpinnerGrandParent);
                                                                                                                                                                                                if (spinner4 != null) {
                                                                                                                                                                                                    i = R.id.fbImageLL1;
                                                                                                                                                                                                    LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fbImageLL1);
                                                                                                                                                                                                    if (linearLayout13 != null) {
                                                                                                                                                                                                        i = R.id.firstLL1;
                                                                                                                                                                                                        LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.firstLL1);
                                                                                                                                                                                                        if (linearLayout14 != null) {
                                                                                                                                                                                                            i = R.id.frontImage1;
                                                                                                                                                                                                            ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.frontImage1);
                                                                                                                                                                                                            if (imageView16 != null) {
                                                                                                                                                                                                                i = R.id.grandParentSpinner1Page1;
                                                                                                                                                                                                                LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.grandParentSpinner1Page1);
                                                                                                                                                                                                                if (linearLayout15 != null) {
                                                                                                                                                                                                                    i = R.id.grandParentSpinner1Page1Image;
                                                                                                                                                                                                                    ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.grandParentSpinner1Page1Image);
                                                                                                                                                                                                                    if (imageView17 != null) {
                                                                                                                                                                                                                        i = R.id.grandParentSpinner1Page1ImageName;
                                                                                                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.grandParentSpinner1Page1ImageName);
                                                                                                                                                                                                                        if (textView17 != null) {
                                                                                                                                                                                                                            i = R.id.grandParentSpinner1Page1ImageSize;
                                                                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.grandParentSpinner1Page1ImageSize);
                                                                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                                                                i = R.id.grandParentSpinner1Page2;
                                                                                                                                                                                                                                LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.grandParentSpinner1Page2);
                                                                                                                                                                                                                                if (linearLayout16 != null) {
                                                                                                                                                                                                                                    i = R.id.grandParentSpinner1Page2Image;
                                                                                                                                                                                                                                    ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.grandParentSpinner1Page2Image);
                                                                                                                                                                                                                                    if (imageView18 != null) {
                                                                                                                                                                                                                                        i = R.id.grandParentSpinner1Page2ImageName;
                                                                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.grandParentSpinner1Page2ImageName);
                                                                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                                                                            i = R.id.grandParentSpinner1Page2ImageSize;
                                                                                                                                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.grandParentSpinner1Page2ImageSize);
                                                                                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                                                                                i = R.id.grandParentSpinnerDocumentayout;
                                                                                                                                                                                                                                                LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.grandParentSpinnerDocumentayout);
                                                                                                                                                                                                                                                if (linearLayout17 != null) {
                                                                                                                                                                                                                                                    i = R.id.grandparent_lablel;
                                                                                                                                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.grandparent_lablel);
                                                                                                                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                                                                                                                        i = R.id.lvAadharGrandParentSpinner;
                                                                                                                                                                                                                                                        LinearLayout linearLayout18 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lvAadharGrandParentSpinner);
                                                                                                                                                                                                                                                        if (linearLayout18 != null) {
                                                                                                                                                                                                                                                            i = R.id.lv_grandparent;
                                                                                                                                                                                                                                                            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.lv_grandparent);
                                                                                                                                                                                                                                                            if (cardViewFindChildViewById != null) {
                                                                                                                                                                                                                                                                i = R.id.lv_page1_GpspinnerDocument_choose;
                                                                                                                                                                                                                                                                LinearLayout linearLayout19 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_page1_GpspinnerDocument_choose);
                                                                                                                                                                                                                                                                if (linearLayout19 != null) {
                                                                                                                                                                                                                                                                    i = R.id.lv_page2_gp_spinner1_choose;
                                                                                                                                                                                                                                                                    LinearLayout linearLayout20 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_page2_gp_spinner1_choose);
                                                                                                                                                                                                                                                                    if (linearLayout20 != null) {
                                                                                                                                                                                                                                                                        i = R.id.lv_support_choose1;
                                                                                                                                                                                                                                                                        LinearLayout linearLayout21 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_support_choose1);
                                                                                                                                                                                                                                                                        if (linearLayout21 != null) {
                                                                                                                                                                                                                                                                            i = R.id.lv_support_choose2;
                                                                                                                                                                                                                                                                            LinearLayout linearLayout22 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_support_choose2);
                                                                                                                                                                                                                                                                            if (linearLayout22 != null) {
                                                                                                                                                                                                                                                                                i = R.id.secondLL1;
                                                                                                                                                                                                                                                                                LinearLayout linearLayout23 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.secondLL1);
                                                                                                                                                                                                                                                                                if (linearLayout23 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.supported_document_heading;
                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.supported_document_heading);
                                                                                                                                                                                                                                                                                    if (relativeLayout != null) {
                                                                                                                                                                                                                                                                                        i = R.id.supportingDocumentsPage1;
                                                                                                                                                                                                                                                                                        LinearLayout linearLayout24 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1);
                                                                                                                                                                                                                                                                                        if (linearLayout24 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.supportingDocumentsPage1Image;
                                                                                                                                                                                                                                                                                            ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1Image);
                                                                                                                                                                                                                                                                                            if (imageView19 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.supportingDocumentsPage1ImageName;
                                                                                                                                                                                                                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1ImageName);
                                                                                                                                                                                                                                                                                                if (textView22 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.supportingDocumentsPage1ImageSize;
                                                                                                                                                                                                                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage1ImageSize);
                                                                                                                                                                                                                                                                                                    if (textView23 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.supportingDocumentsPage2;
                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout25 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2);
                                                                                                                                                                                                                                                                                                        if (linearLayout25 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.supportingDocumentsPage2Image;
                                                                                                                                                                                                                                                                                                            ImageView imageView20 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2Image);
                                                                                                                                                                                                                                                                                                            if (imageView20 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.supportingDocumentsPage2ImageName;
                                                                                                                                                                                                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2ImageName);
                                                                                                                                                                                                                                                                                                                if (textView24 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.supportingDocumentsPage2ImageSize;
                                                                                                                                                                                                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.supportingDocumentsPage2ImageSize);
                                                                                                                                                                                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.supprtingDocumentsLayout;
                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout26 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.supprtingDocumentsLayout);
                                                                                                                                                                                                                                                                                                                        if (linearLayout26 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.uploadGPSpinner1Page2;
                                                                                                                                                                                                                                                                                                                            TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadGPSpinner1Page2);
                                                                                                                                                                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.uploadGpSpinner1Page1;
                                                                                                                                                                                                                                                                                                                                TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadGpSpinner1Page1);
                                                                                                                                                                                                                                                                                                                                if (textView27 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.upload_gp_spinner1_page_2;
                                                                                                                                                                                                                                                                                                                                    TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_gp_spinner1_page_2);
                                                                                                                                                                                                                                                                                                                                    if (textView28 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.upload_page1_gp_spinner1;
                                                                                                                                                                                                                                                                                                                                        TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_page1_gp_spinner1);
                                                                                                                                                                                                                                                                                                                                        if (textView29 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.uploadSupportingDocumentsPage1;
                                                                                                                                                                                                                                                                                                                                            TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadSupportingDocumentsPage1);
                                                                                                                                                                                                                                                                                                                                            if (textView30 != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.uploadSupportingDocumentsPage2;
                                                                                                                                                                                                                                                                                                                                                TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadSupportingDocumentsPage2);
                                                                                                                                                                                                                                                                                                                                                if (textView31 != null) {
                                                                                                                                                                                                                                                                                                                                                    return new GrandparentIncludeBinding((LinearLayout) rootView, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, spinner, linearLayout, imageView10, textView, textView2, linearLayout2, imageView11, textView3, textView4, linearLayout3, linearLayout4, linearLayout5, linearLayout6, textView5, textView6, textView7, textView8, imageView12, imageView13, spinner2, linearLayout7, imageView14, textView9, textView10, linearLayout8, imageView15, textView11, textView12, linearLayout9, linearLayout10, linearLayout11, linearLayout12, textView13, textView14, textView15, textView16, spinner3, spinner4, linearLayout13, linearLayout14, imageView16, linearLayout15, imageView17, textView17, textView18, linearLayout16, imageView18, textView19, textView20, linearLayout17, textView21, linearLayout18, cardViewFindChildViewById, linearLayout19, linearLayout20, linearLayout21, linearLayout22, linearLayout23, relativeLayout, linearLayout24, imageView19, textView22, textView23, linearLayout25, imageView20, textView24, textView25, linearLayout26, textView26, textView27, textView28, textView29, textView30, textView31);
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
