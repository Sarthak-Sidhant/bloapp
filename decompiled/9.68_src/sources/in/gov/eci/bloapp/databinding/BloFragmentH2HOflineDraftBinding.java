package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentH2HOflineDraftBinding implements ViewBinding {
    public final TextView ReviewACName;
    public final LinearLayout ReviewDetails;
    public final LinearLayout ReviewElectorHeading;
    public final RadioGroup ReviewMetInfo;
    public final LinearLayout ReviewMetLinearLayout;
    public final RadioButton ReviewMetRG1;
    public final RadioButton ReviewMetRG2;
    public final TextView ReviewMisDoc;
    public final LinearLayout ReviewMisDoc1;
    public final TextView ReviewMobnumElector;
    public final TextView ReviewPWDOtherDisablity;
    public final TextView ReviewPWDPercentage;
    public final TextView ReviewRemark;
    public final TextView ReviewSection;
    public final RadioGroup ReviewaddressRg;
    public final TextView ReviewageTv;
    public final TextView ReviewapplicantNameRegionalTv1;
    public final TextView ReviewapplicantNameTv;
    public final TextView ReviewapplicantNameTv1;
    public final LinearLayout ReviewbasicdetailsHeading;
    public final TextView ReviewdistrictName;
    public final TextView ReviewdobEd;
    public final RadioGroup ReviewdobRg;
    public final TextView ReviewdobTv;
    public final TextView ReviewemailTv;
    public final TextView ReviewepicNumberTv;
    public final TextView ReviewepicNumberTv1;
    public final TextView ReviewgenderTv;
    public final TextView ReviewgenderTv1;
    public final RadioGroup ReviewinformationRg1;
    public final RadioGroup ReviewinformationRg2;
    public final RadioGroup Reviewinformationrg999;
    public final RadioGroup Reviewinformationrg9999;
    public final RadioButton ReviewisAddressRecordSameRb;
    public final RadioButton ReviewisDobRecordSameRb;
    public final RadioButton ReviewisElectorRecordSameRb;
    public final TextView ReviewmobnumTv;
    public final RadioButton ReviewnotAddressRecordSameRb;
    public final RadioButton ReviewnotDobRecordSameRb;
    public final RadioButton ReviewnotElectorRecordSameRb;
    public final TextView ReviewpartNumber;
    public final LinearLayout ReviewpartNumberHeading;
    public final LinearLayout ReviewpartNumberHeading1;
    public final RadioGroup ReviewphotographRG;
    public final RadioButton ReviewphotographRG1;
    public final RadioButton ReviewphotographRG2;
    public final RadioButton ReviewphotographRGAbsent;
    public final TextView ReviewrelativeRegionalTv1;
    public final TextView ReviewrelativeTv;
    public final TextView ReviewrelativeTv1;
    public final TextView ReviewrelativeTypeTv;
    public final RadioGroup Reviewrg1stpage;
    public final LinearLayout Reviewstatement2Heading2;
    public final TextView ReviewstreetTv;
    public final LinearLayout ReviewsubBasicdetails1;
    public final EditText ReviewverificationDateEd;
    public final ImageView backBtnIv;
    public final ConstraintLayout bottomSubmitLayout;
    public final CardView cardView;
    public final Button chooseFile;
    public final ConstraintLayout chooseFileItems;
    public final ConstraintLayout constraintLayout;
    public final ImageView deletebtn;
    public final ImageView homeBtnIv;
    public final TextView imageEnlargeTv;
    public final TextView mainheadingTv;
    public final ImageView personImage;
    public final ImageView preview;
    public final RadioButton reviewAadhaarRG1;
    public final RadioButton reviewAadhaarRG2;
    public final RadioButton reviewAboveDetailsRG1;
    public final RadioButton reviewAboveDetailsRG2;
    public final CheckBox reviewChkDeafDumb;
    public final CheckBox reviewChkLocomotive;
    public final CheckBox reviewChkOther;
    public final CheckBox reviewChkVisual;
    public final RadioButton reviewHouseVisitRG1;
    public final RadioButton reviewHouseVisitRG2;
    public final RadioButton reviewHouseVisitRG3;
    public final RadioButton reviewHouseVisitRGCorrect;
    public final LinearLayout reviewPWDLinearLayout;
    public final RadioButton reviewPwdRG1;
    public final RadioButton reviewPwdRG2;
    private final ConstraintLayout rootView;
    public final TextView selectName;
    public final TextView selectSize;
    public final LinearLayout subBasicdetails2;
    public final Button submitTv;
    public final Button viewPhoto;

    private BloFragmentH2HOflineDraftBinding(ConstraintLayout rootView, TextView ReviewACName, LinearLayout ReviewDetails, LinearLayout ReviewElectorHeading, RadioGroup ReviewMetInfo, LinearLayout ReviewMetLinearLayout, RadioButton ReviewMetRG1, RadioButton ReviewMetRG2, TextView ReviewMisDoc, LinearLayout ReviewMisDoc1, TextView ReviewMobnumElector, TextView ReviewPWDOtherDisablity, TextView ReviewPWDPercentage, TextView ReviewRemark, TextView ReviewSection, RadioGroup ReviewaddressRg, TextView ReviewageTv, TextView ReviewapplicantNameRegionalTv1, TextView ReviewapplicantNameTv, TextView ReviewapplicantNameTv1, LinearLayout ReviewbasicdetailsHeading, TextView ReviewdistrictName, TextView ReviewdobEd, RadioGroup ReviewdobRg, TextView ReviewdobTv, TextView ReviewemailTv, TextView ReviewepicNumberTv, TextView ReviewepicNumberTv1, TextView ReviewgenderTv, TextView ReviewgenderTv1, RadioGroup ReviewinformationRg1, RadioGroup ReviewinformationRg2, RadioGroup Reviewinformationrg999, RadioGroup Reviewinformationrg9999, RadioButton ReviewisAddressRecordSameRb, RadioButton ReviewisDobRecordSameRb, RadioButton ReviewisElectorRecordSameRb, TextView ReviewmobnumTv, RadioButton ReviewnotAddressRecordSameRb, RadioButton ReviewnotDobRecordSameRb, RadioButton ReviewnotElectorRecordSameRb, TextView ReviewpartNumber, LinearLayout ReviewpartNumberHeading, LinearLayout ReviewpartNumberHeading1, RadioGroup ReviewphotographRG, RadioButton ReviewphotographRG1, RadioButton ReviewphotographRG2, RadioButton ReviewphotographRGAbsent, TextView ReviewrelativeRegionalTv1, TextView ReviewrelativeTv, TextView ReviewrelativeTv1, TextView ReviewrelativeTypeTv, RadioGroup Reviewrg1stpage, LinearLayout Reviewstatement2Heading2, TextView ReviewstreetTv, LinearLayout ReviewsubBasicdetails1, EditText ReviewverificationDateEd, ImageView backBtnIv, ConstraintLayout bottomSubmitLayout, CardView cardView, Button chooseFile, ConstraintLayout chooseFileItems, ConstraintLayout constraintLayout, ImageView deletebtn, ImageView homeBtnIv, TextView imageEnlargeTv, TextView mainheadingTv, ImageView personImage, ImageView preview, RadioButton reviewAadhaarRG1, RadioButton reviewAadhaarRG2, RadioButton reviewAboveDetailsRG1, RadioButton reviewAboveDetailsRG2, CheckBox reviewChkDeafDumb, CheckBox reviewChkLocomotive, CheckBox reviewChkOther, CheckBox reviewChkVisual, RadioButton reviewHouseVisitRG1, RadioButton reviewHouseVisitRG2, RadioButton reviewHouseVisitRG3, RadioButton reviewHouseVisitRGCorrect, LinearLayout reviewPWDLinearLayout, RadioButton reviewPwdRG1, RadioButton reviewPwdRG2, TextView selectName, TextView selectSize, LinearLayout subBasicdetails2, Button submitTv, Button viewPhoto) {
        this.rootView = rootView;
        this.ReviewACName = ReviewACName;
        this.ReviewDetails = ReviewDetails;
        this.ReviewElectorHeading = ReviewElectorHeading;
        this.ReviewMetInfo = ReviewMetInfo;
        this.ReviewMetLinearLayout = ReviewMetLinearLayout;
        this.ReviewMetRG1 = ReviewMetRG1;
        this.ReviewMetRG2 = ReviewMetRG2;
        this.ReviewMisDoc = ReviewMisDoc;
        this.ReviewMisDoc1 = ReviewMisDoc1;
        this.ReviewMobnumElector = ReviewMobnumElector;
        this.ReviewPWDOtherDisablity = ReviewPWDOtherDisablity;
        this.ReviewPWDPercentage = ReviewPWDPercentage;
        this.ReviewRemark = ReviewRemark;
        this.ReviewSection = ReviewSection;
        this.ReviewaddressRg = ReviewaddressRg;
        this.ReviewageTv = ReviewageTv;
        this.ReviewapplicantNameRegionalTv1 = ReviewapplicantNameRegionalTv1;
        this.ReviewapplicantNameTv = ReviewapplicantNameTv;
        this.ReviewapplicantNameTv1 = ReviewapplicantNameTv1;
        this.ReviewbasicdetailsHeading = ReviewbasicdetailsHeading;
        this.ReviewdistrictName = ReviewdistrictName;
        this.ReviewdobEd = ReviewdobEd;
        this.ReviewdobRg = ReviewdobRg;
        this.ReviewdobTv = ReviewdobTv;
        this.ReviewemailTv = ReviewemailTv;
        this.ReviewepicNumberTv = ReviewepicNumberTv;
        this.ReviewepicNumberTv1 = ReviewepicNumberTv1;
        this.ReviewgenderTv = ReviewgenderTv;
        this.ReviewgenderTv1 = ReviewgenderTv1;
        this.ReviewinformationRg1 = ReviewinformationRg1;
        this.ReviewinformationRg2 = ReviewinformationRg2;
        this.Reviewinformationrg999 = Reviewinformationrg999;
        this.Reviewinformationrg9999 = Reviewinformationrg9999;
        this.ReviewisAddressRecordSameRb = ReviewisAddressRecordSameRb;
        this.ReviewisDobRecordSameRb = ReviewisDobRecordSameRb;
        this.ReviewisElectorRecordSameRb = ReviewisElectorRecordSameRb;
        this.ReviewmobnumTv = ReviewmobnumTv;
        this.ReviewnotAddressRecordSameRb = ReviewnotAddressRecordSameRb;
        this.ReviewnotDobRecordSameRb = ReviewnotDobRecordSameRb;
        this.ReviewnotElectorRecordSameRb = ReviewnotElectorRecordSameRb;
        this.ReviewpartNumber = ReviewpartNumber;
        this.ReviewpartNumberHeading = ReviewpartNumberHeading;
        this.ReviewpartNumberHeading1 = ReviewpartNumberHeading1;
        this.ReviewphotographRG = ReviewphotographRG;
        this.ReviewphotographRG1 = ReviewphotographRG1;
        this.ReviewphotographRG2 = ReviewphotographRG2;
        this.ReviewphotographRGAbsent = ReviewphotographRGAbsent;
        this.ReviewrelativeRegionalTv1 = ReviewrelativeRegionalTv1;
        this.ReviewrelativeTv = ReviewrelativeTv;
        this.ReviewrelativeTv1 = ReviewrelativeTv1;
        this.ReviewrelativeTypeTv = ReviewrelativeTypeTv;
        this.Reviewrg1stpage = Reviewrg1stpage;
        this.Reviewstatement2Heading2 = Reviewstatement2Heading2;
        this.ReviewstreetTv = ReviewstreetTv;
        this.ReviewsubBasicdetails1 = ReviewsubBasicdetails1;
        this.ReviewverificationDateEd = ReviewverificationDateEd;
        this.backBtnIv = backBtnIv;
        this.bottomSubmitLayout = bottomSubmitLayout;
        this.cardView = cardView;
        this.chooseFile = chooseFile;
        this.chooseFileItems = chooseFileItems;
        this.constraintLayout = constraintLayout;
        this.deletebtn = deletebtn;
        this.homeBtnIv = homeBtnIv;
        this.imageEnlargeTv = imageEnlargeTv;
        this.mainheadingTv = mainheadingTv;
        this.personImage = personImage;
        this.preview = preview;
        this.reviewAadhaarRG1 = reviewAadhaarRG1;
        this.reviewAadhaarRG2 = reviewAadhaarRG2;
        this.reviewAboveDetailsRG1 = reviewAboveDetailsRG1;
        this.reviewAboveDetailsRG2 = reviewAboveDetailsRG2;
        this.reviewChkDeafDumb = reviewChkDeafDumb;
        this.reviewChkLocomotive = reviewChkLocomotive;
        this.reviewChkOther = reviewChkOther;
        this.reviewChkVisual = reviewChkVisual;
        this.reviewHouseVisitRG1 = reviewHouseVisitRG1;
        this.reviewHouseVisitRG2 = reviewHouseVisitRG2;
        this.reviewHouseVisitRG3 = reviewHouseVisitRG3;
        this.reviewHouseVisitRGCorrect = reviewHouseVisitRGCorrect;
        this.reviewPWDLinearLayout = reviewPWDLinearLayout;
        this.reviewPwdRG1 = reviewPwdRG1;
        this.reviewPwdRG2 = reviewPwdRG2;
        this.selectName = selectName;
        this.selectSize = selectSize;
        this.subBasicdetails2 = subBasicdetails2;
        this.submitTv = submitTv;
        this.viewPhoto = viewPhoto;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentH2HOflineDraftBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentH2HOflineDraftBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_h2_h_ofline_draft, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentH2HOflineDraftBinding bind(View rootView) {
        int i = R.id.ReviewACName;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.ReviewACName);
        if (textView != null) {
            i = R.id.ReviewDetails;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ReviewDetails);
            if (linearLayout != null) {
                i = R.id.ReviewElectorHeading;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ReviewElectorHeading);
                if (linearLayout2 != null) {
                    i = R.id.ReviewMetInfo;
                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.ReviewMetInfo);
                    if (radioGroup != null) {
                        i = R.id.ReviewMetLinearLayout;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ReviewMetLinearLayout);
                        if (linearLayout3 != null) {
                            i = R.id.ReviewMetRG1;
                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.ReviewMetRG1);
                            if (radioButton != null) {
                                i = R.id.ReviewMetRG2;
                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.ReviewMetRG2);
                                if (radioButton2 != null) {
                                    i = R.id.ReviewMisDoc;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ReviewMisDoc);
                                    if (textView2 != null) {
                                        i = R.id.ReviewMisDoc1;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ReviewMisDoc1);
                                        if (linearLayout4 != null) {
                                            i = R.id.ReviewMobnum_elector;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ReviewMobnum_elector);
                                            if (textView3 != null) {
                                                i = R.id.ReviewPWDOtherDisablity;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ReviewPWDOtherDisablity);
                                                if (textView4 != null) {
                                                    i = R.id.ReviewPWDPercentage;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ReviewPWDPercentage);
                                                    if (textView5 != null) {
                                                        i = R.id.ReviewRemark;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ReviewRemark);
                                                        if (textView6 != null) {
                                                            i = R.id.ReviewSection;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ReviewSection);
                                                            if (textView7 != null) {
                                                                i = R.id.Reviewaddress_rg;
                                                                RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.Reviewaddress_rg);
                                                                if (radioGroup2 != null) {
                                                                    i = R.id.Reviewage_tv;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewage_tv);
                                                                    if (textView8 != null) {
                                                                        i = R.id.Reviewapplicant_name_regional_tv1;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewapplicant_name_regional_tv1);
                                                                        if (textView9 != null) {
                                                                            i = R.id.Reviewapplicant_name_tv;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewapplicant_name_tv);
                                                                            if (textView10 != null) {
                                                                                i = R.id.Reviewapplicant_name_tv1;
                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewapplicant_name_tv1);
                                                                                if (textView11 != null) {
                                                                                    i = R.id.Reviewbasicdetails_heading;
                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.Reviewbasicdetails_heading);
                                                                                    if (linearLayout5 != null) {
                                                                                        i = R.id.ReviewdistrictName;
                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ReviewdistrictName);
                                                                                        if (textView12 != null) {
                                                                                            i = R.id.Reviewdob_ed;
                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewdob_ed);
                                                                                            if (textView13 != null) {
                                                                                                i = R.id.Reviewdob_rg;
                                                                                                RadioGroup radioGroup3 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.Reviewdob_rg);
                                                                                                if (radioGroup3 != null) {
                                                                                                    i = R.id.Reviewdob_tv;
                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewdob_tv);
                                                                                                    if (textView14 != null) {
                                                                                                        i = R.id.Reviewemail_tv;
                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewemail_tv);
                                                                                                        if (textView15 != null) {
                                                                                                            i = R.id.Reviewepic_number_tv;
                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewepic_number_tv);
                                                                                                            if (textView16 != null) {
                                                                                                                i = R.id.Reviewepic_number_tv1;
                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewepic_number_tv1);
                                                                                                                if (textView17 != null) {
                                                                                                                    i = R.id.Reviewgender_tv;
                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewgender_tv);
                                                                                                                    if (textView18 != null) {
                                                                                                                        i = R.id.Reviewgender_tv1;
                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewgender_tv1);
                                                                                                                        if (textView19 != null) {
                                                                                                                            i = R.id.Reviewinformation_rg1;
                                                                                                                            RadioGroup radioGroup4 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.Reviewinformation_rg1);
                                                                                                                            if (radioGroup4 != null) {
                                                                                                                                i = R.id.Reviewinformation_rg2;
                                                                                                                                RadioGroup radioGroup5 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.Reviewinformation_rg2);
                                                                                                                                if (radioGroup5 != null) {
                                                                                                                                    i = R.id.Reviewinformationrg999;
                                                                                                                                    RadioGroup radioGroup6 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.Reviewinformationrg999);
                                                                                                                                    if (radioGroup6 != null) {
                                                                                                                                        i = R.id.Reviewinformationrg9999;
                                                                                                                                        RadioGroup radioGroup7 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.Reviewinformationrg9999);
                                                                                                                                        if (radioGroup7 != null) {
                                                                                                                                            i = R.id.ReviewisAddressRecordSameRb;
                                                                                                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.ReviewisAddressRecordSameRb);
                                                                                                                                            if (radioButton3 != null) {
                                                                                                                                                i = R.id.ReviewisDobRecordSameRb;
                                                                                                                                                RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.ReviewisDobRecordSameRb);
                                                                                                                                                if (radioButton4 != null) {
                                                                                                                                                    i = R.id.ReviewisElectorRecordSameRb;
                                                                                                                                                    RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.ReviewisElectorRecordSameRb);
                                                                                                                                                    if (radioButton5 != null) {
                                                                                                                                                        i = R.id.Reviewmobnum_tv;
                                                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewmobnum_tv);
                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                            i = R.id.ReviewnotAddressRecordSameRb;
                                                                                                                                                            RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.ReviewnotAddressRecordSameRb);
                                                                                                                                                            if (radioButton6 != null) {
                                                                                                                                                                i = R.id.ReviewnotDobRecordSameRb;
                                                                                                                                                                RadioButton radioButton7 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.ReviewnotDobRecordSameRb);
                                                                                                                                                                if (radioButton7 != null) {
                                                                                                                                                                    i = R.id.ReviewnotElectorRecordSameRb;
                                                                                                                                                                    RadioButton radioButton8 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.ReviewnotElectorRecordSameRb);
                                                                                                                                                                    if (radioButton8 != null) {
                                                                                                                                                                        i = R.id.ReviewpartNumber;
                                                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ReviewpartNumber);
                                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                                            i = R.id.ReviewpartNumberHeading;
                                                                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ReviewpartNumberHeading);
                                                                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                                                                i = R.id.ReviewpartNumberHeading1;
                                                                                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ReviewpartNumberHeading1);
                                                                                                                                                                                if (linearLayout7 != null) {
                                                                                                                                                                                    i = R.id.ReviewphotographRG;
                                                                                                                                                                                    RadioGroup radioGroup8 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.ReviewphotographRG);
                                                                                                                                                                                    if (radioGroup8 != null) {
                                                                                                                                                                                        i = R.id.ReviewphotographRG1;
                                                                                                                                                                                        RadioButton radioButton9 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.ReviewphotographRG1);
                                                                                                                                                                                        if (radioButton9 != null) {
                                                                                                                                                                                            i = R.id.ReviewphotographRG2;
                                                                                                                                                                                            RadioButton radioButton10 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.ReviewphotographRG2);
                                                                                                                                                                                            if (radioButton10 != null) {
                                                                                                                                                                                                i = R.id.ReviewphotographRGAbsent;
                                                                                                                                                                                                RadioButton radioButton11 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.ReviewphotographRGAbsent);
                                                                                                                                                                                                if (radioButton11 != null) {
                                                                                                                                                                                                    i = R.id.Reviewrelative_regional_tv1;
                                                                                                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewrelative_regional_tv1);
                                                                                                                                                                                                    if (textView22 != null) {
                                                                                                                                                                                                        i = R.id.Reviewrelative_tv;
                                                                                                                                                                                                        TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewrelative_tv);
                                                                                                                                                                                                        if (textView23 != null) {
                                                                                                                                                                                                            i = R.id.Reviewrelative_tv1;
                                                                                                                                                                                                            TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewrelative_tv1);
                                                                                                                                                                                                            if (textView24 != null) {
                                                                                                                                                                                                                i = R.id.Reviewrelative_type_tv;
                                                                                                                                                                                                                TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewrelative_type_tv);
                                                                                                                                                                                                                if (textView25 != null) {
                                                                                                                                                                                                                    i = R.id.Reviewrg_1stpage;
                                                                                                                                                                                                                    RadioGroup radioGroup9 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.Reviewrg_1stpage);
                                                                                                                                                                                                                    if (radioGroup9 != null) {
                                                                                                                                                                                                                        i = R.id.Reviewstatement2_heading2;
                                                                                                                                                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.Reviewstatement2_heading2);
                                                                                                                                                                                                                        if (linearLayout8 != null) {
                                                                                                                                                                                                                            i = R.id.Reviewstreet_tv;
                                                                                                                                                                                                                            TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Reviewstreet_tv);
                                                                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                                                                i = R.id.Reviewsub_basicdetails1;
                                                                                                                                                                                                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.Reviewsub_basicdetails1);
                                                                                                                                                                                                                                if (linearLayout9 != null) {
                                                                                                                                                                                                                                    i = R.id.Reviewverification_date_ed;
                                                                                                                                                                                                                                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.Reviewverification_date_ed);
                                                                                                                                                                                                                                    if (editText != null) {
                                                                                                                                                                                                                                        i = R.id.back_btn_iv;
                                                                                                                                                                                                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                                                                                                                                                                                                                                        if (imageView != null) {
                                                                                                                                                                                                                                            i = R.id.bottom_submit_layout;
                                                                                                                                                                                                                                            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_submit_layout);
                                                                                                                                                                                                                                            if (constraintLayoutFindChildViewById != null) {
                                                                                                                                                                                                                                                i = R.id.cardView;
                                                                                                                                                                                                                                                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView);
                                                                                                                                                                                                                                                if (cardViewFindChildViewById != null) {
                                                                                                                                                                                                                                                    i = R.id.choose_file;
                                                                                                                                                                                                                                                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.choose_file);
                                                                                                                                                                                                                                                    if (button != null) {
                                                                                                                                                                                                                                                        i = R.id.choose_file_items;
                                                                                                                                                                                                                                                        ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.choose_file_items);
                                                                                                                                                                                                                                                        if (constraintLayoutFindChildViewById2 != null) {
                                                                                                                                                                                                                                                            i = R.id.constraintLayout;
                                                                                                                                                                                                                                                            ConstraintLayout constraintLayoutFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
                                                                                                                                                                                                                                                            if (constraintLayoutFindChildViewById3 != null) {
                                                                                                                                                                                                                                                                i = R.id.deletebtn;
                                                                                                                                                                                                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deletebtn);
                                                                                                                                                                                                                                                                if (imageView2 != null) {
                                                                                                                                                                                                                                                                    i = R.id.home_btn_iv;
                                                                                                                                                                                                                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                                                                                                                                                                                                                                                                    if (imageView3 != null) {
                                                                                                                                                                                                                                                                        i = R.id.image_enlarge_tv;
                                                                                                                                                                                                                                                                        TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.image_enlarge_tv);
                                                                                                                                                                                                                                                                        if (textView27 != null) {
                                                                                                                                                                                                                                                                            i = R.id.mainheading_tv;
                                                                                                                                                                                                                                                                            TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mainheading_tv);
                                                                                                                                                                                                                                                                            if (textView28 != null) {
                                                                                                                                                                                                                                                                                i = R.id.person_image;
                                                                                                                                                                                                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.person_image);
                                                                                                                                                                                                                                                                                if (imageView4 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.preview;
                                                                                                                                                                                                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.preview);
                                                                                                                                                                                                                                                                                    if (imageView5 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.reviewAadhaarRG1;
                                                                                                                                                                                                                                                                                        RadioButton radioButton12 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.reviewAadhaarRG1);
                                                                                                                                                                                                                                                                                        if (radioButton12 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.reviewAadhaarRG2;
                                                                                                                                                                                                                                                                                            RadioButton radioButton13 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.reviewAadhaarRG2);
                                                                                                                                                                                                                                                                                            if (radioButton13 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.reviewAboveDetailsRG1;
                                                                                                                                                                                                                                                                                                RadioButton radioButton14 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.reviewAboveDetailsRG1);
                                                                                                                                                                                                                                                                                                if (radioButton14 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.reviewAboveDetailsRG2;
                                                                                                                                                                                                                                                                                                    RadioButton radioButton15 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.reviewAboveDetailsRG2);
                                                                                                                                                                                                                                                                                                    if (radioButton15 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.reviewChkDeafDumb;
                                                                                                                                                                                                                                                                                                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.reviewChkDeafDumb);
                                                                                                                                                                                                                                                                                                        if (checkBox != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.reviewChkLocomotive;
                                                                                                                                                                                                                                                                                                            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.reviewChkLocomotive);
                                                                                                                                                                                                                                                                                                            if (checkBox2 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.reviewChkOther;
                                                                                                                                                                                                                                                                                                                CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.reviewChkOther);
                                                                                                                                                                                                                                                                                                                if (checkBox3 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.reviewChkVisual;
                                                                                                                                                                                                                                                                                                                    CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.reviewChkVisual);
                                                                                                                                                                                                                                                                                                                    if (checkBox4 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.reviewHouseVisitRG1;
                                                                                                                                                                                                                                                                                                                        RadioButton radioButton16 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.reviewHouseVisitRG1);
                                                                                                                                                                                                                                                                                                                        if (radioButton16 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.reviewHouseVisitRG2;
                                                                                                                                                                                                                                                                                                                            RadioButton radioButton17 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.reviewHouseVisitRG2);
                                                                                                                                                                                                                                                                                                                            if (radioButton17 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.reviewHouseVisitRG3;
                                                                                                                                                                                                                                                                                                                                RadioButton radioButton18 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.reviewHouseVisitRG3);
                                                                                                                                                                                                                                                                                                                                if (radioButton18 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.reviewHouseVisitRGCorrect;
                                                                                                                                                                                                                                                                                                                                    RadioButton radioButton19 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.reviewHouseVisitRGCorrect);
                                                                                                                                                                                                                                                                                                                                    if (radioButton19 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.reviewPWDLinearLayout;
                                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.reviewPWDLinearLayout);
                                                                                                                                                                                                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.reviewPwdRG1;
                                                                                                                                                                                                                                                                                                                                            RadioButton radioButton20 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.reviewPwdRG1);
                                                                                                                                                                                                                                                                                                                                            if (radioButton20 != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.reviewPwdRG2;
                                                                                                                                                                                                                                                                                                                                                RadioButton radioButton21 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.reviewPwdRG2);
                                                                                                                                                                                                                                                                                                                                                if (radioButton21 != null) {
                                                                                                                                                                                                                                                                                                                                                    i = R.id.select_name;
                                                                                                                                                                                                                                                                                                                                                    TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.select_name);
                                                                                                                                                                                                                                                                                                                                                    if (textView29 != null) {
                                                                                                                                                                                                                                                                                                                                                        i = R.id.select_size;
                                                                                                                                                                                                                                                                                                                                                        TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.select_size);
                                                                                                                                                                                                                                                                                                                                                        if (textView30 != null) {
                                                                                                                                                                                                                                                                                                                                                            i = R.id.sub_basicdetails2;
                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails2);
                                                                                                                                                                                                                                                                                                                                                            if (linearLayout11 != null) {
                                                                                                                                                                                                                                                                                                                                                                i = R.id.submit_tv;
                                                                                                                                                                                                                                                                                                                                                                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.submit_tv);
                                                                                                                                                                                                                                                                                                                                                                if (button2 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i = R.id.viewPhoto;
                                                                                                                                                                                                                                                                                                                                                                    Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.viewPhoto);
                                                                                                                                                                                                                                                                                                                                                                    if (button3 != null) {
                                                                                                                                                                                                                                                                                                                                                                        return new BloFragmentH2HOflineDraftBinding((ConstraintLayout) rootView, textView, linearLayout, linearLayout2, radioGroup, linearLayout3, radioButton, radioButton2, textView2, linearLayout4, textView3, textView4, textView5, textView6, textView7, radioGroup2, textView8, textView9, textView10, textView11, linearLayout5, textView12, textView13, radioGroup3, textView14, textView15, textView16, textView17, textView18, textView19, radioGroup4, radioGroup5, radioGroup6, radioGroup7, radioButton3, radioButton4, radioButton5, textView20, radioButton6, radioButton7, radioButton8, textView21, linearLayout6, linearLayout7, radioGroup8, radioButton9, radioButton10, radioButton11, textView22, textView23, textView24, textView25, radioGroup9, linearLayout8, textView26, linearLayout9, editText, imageView, constraintLayoutFindChildViewById, cardViewFindChildViewById, button, constraintLayoutFindChildViewById2, constraintLayoutFindChildViewById3, imageView2, imageView3, textView27, textView28, imageView4, imageView5, radioButton12, radioButton13, radioButton14, radioButton15, checkBox, checkBox2, checkBox3, checkBox4, radioButton16, radioButton17, radioButton18, radioButton19, linearLayout10, radioButton20, radioButton21, textView29, textView30, linearLayout11, button2, button3);
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
