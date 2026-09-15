package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentPersonalDetailsBinding implements ViewBinding {
    public final EditText aadharEd;
    public final RadioButton aadharRb;
    public final RadioGroup aadharRg;
    public final ImageView calendarIv;
    public final TextView chooseDocTv;
    public final TextView chooseFileTv;
    public final TextView chooseFileTv2;
    public final TextView choosePhoto;
    public final ImageView deleteUploadedIv;
    public final ImageView deleteUploadedIv2;
    public final NoDefaultSpinner dobDocSpinner;
    public final RadioButton dobProofRb1;
    public final TextView dobTv;
    public final RadioGroup docProofRg;
    public final TextView docSizeTv;
    public final EditText emailEd;
    public final RadioButton emailRb;
    public final RadioGroup emailRg;
    public final RadioGroup familyRadioGroup;
    public final RadioButton fatherRadioBtn;
    public final RadioButton femaleRb;
    public final EditText firstNameEd;
    public final TextView firstNameHead;
    public final TextView firstNameTransTv;
    public final TextView firstNameTv3;
    public final RadioGroup genderRg;
    public final RadioButton husbandRadioBtn;
    public final ImageView imageView5;
    public final ImageView imageView6;
    public final ImageView imageView7;
    public final ImageView imageView8;
    public final RadioButton legalGuardianRb;
    public final LinearLayout linearLayout6;
    public final LinearLayout linearLayout7;
    public final LinearLayout linearLayout9;
    public final RadioButton maleRb;
    public final EditText middleNameEd;
    public final TextView middleNameHead;
    public final TextView middleNameTransTv;
    public final RadioGroup mobNumRg;
    public final EditText mobileNumEd;
    public final RadioButton motherRadioBtn;
    public final TextView namePhotographTv;
    public final EditText nameSurnameEd;
    public final TextView nameSurnameTransEd;
    public final LinearLayout nestedScrollView;
    public final RadioButton noAadharRb;
    public final EditText otherDocEd;
    public final RadioButton otherDocRb1;
    public final ImageView photo1;
    public final ImageView photo2;
    public final TextView photoSizeTv;
    public final RadioButton relative;
    private final ScrollView rootView;
    public final RadioButton self;
    public final RadioButton selfRb;
    public final EditText surnameEd;
    public final TextView surnameNameHead;
    public final TextView surnameTransTv;
    public final TextView textView14;
    public final RadioButton thirdGender;
    public final View view1;
    public final View view10;
    public final View view11;
    public final View view2;
    public final View view3;
    public final View view4;
    public final View view5;
    public final View view8;
    public final View view9;
    public final RadioButton wifeRadioBtn;

    private BloFragmentPersonalDetailsBinding(ScrollView rootView, EditText aadharEd, RadioButton aadharRb, RadioGroup aadharRg, ImageView calendarIv, TextView chooseDocTv, TextView chooseFileTv, TextView chooseFileTv2, TextView choosePhoto, ImageView deleteUploadedIv, ImageView deleteUploadedIv2, NoDefaultSpinner dobDocSpinner, RadioButton dobProofRb1, TextView dobTv, RadioGroup docProofRg, TextView docSizeTv, EditText emailEd, RadioButton emailRb, RadioGroup emailRg, RadioGroup familyRadioGroup, RadioButton fatherRadioBtn, RadioButton femaleRb, EditText firstNameEd, TextView firstNameHead, TextView firstNameTransTv, TextView firstNameTv3, RadioGroup genderRg, RadioButton husbandRadioBtn, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, RadioButton legalGuardianRb, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout9, RadioButton maleRb, EditText middleNameEd, TextView middleNameHead, TextView middleNameTransTv, RadioGroup mobNumRg, EditText mobileNumEd, RadioButton motherRadioBtn, TextView namePhotographTv, EditText nameSurnameEd, TextView nameSurnameTransEd, LinearLayout nestedScrollView, RadioButton noAadharRb, EditText otherDocEd, RadioButton otherDocRb1, ImageView photo1, ImageView photo2, TextView photoSizeTv, RadioButton relative, RadioButton self, RadioButton selfRb, EditText surnameEd, TextView surnameNameHead, TextView surnameTransTv, TextView textView14, RadioButton thirdGender, View view1, View view10, View view11, View view2, View view3, View view4, View view5, View view8, View view9, RadioButton wifeRadioBtn) {
        this.rootView = rootView;
        this.aadharEd = aadharEd;
        this.aadharRb = aadharRb;
        this.aadharRg = aadharRg;
        this.calendarIv = calendarIv;
        this.chooseDocTv = chooseDocTv;
        this.chooseFileTv = chooseFileTv;
        this.chooseFileTv2 = chooseFileTv2;
        this.choosePhoto = choosePhoto;
        this.deleteUploadedIv = deleteUploadedIv;
        this.deleteUploadedIv2 = deleteUploadedIv2;
        this.dobDocSpinner = dobDocSpinner;
        this.dobProofRb1 = dobProofRb1;
        this.dobTv = dobTv;
        this.docProofRg = docProofRg;
        this.docSizeTv = docSizeTv;
        this.emailEd = emailEd;
        this.emailRb = emailRb;
        this.emailRg = emailRg;
        this.familyRadioGroup = familyRadioGroup;
        this.fatherRadioBtn = fatherRadioBtn;
        this.femaleRb = femaleRb;
        this.firstNameEd = firstNameEd;
        this.firstNameHead = firstNameHead;
        this.firstNameTransTv = firstNameTransTv;
        this.firstNameTv3 = firstNameTv3;
        this.genderRg = genderRg;
        this.husbandRadioBtn = husbandRadioBtn;
        this.imageView5 = imageView5;
        this.imageView6 = imageView6;
        this.imageView7 = imageView7;
        this.imageView8 = imageView8;
        this.legalGuardianRb = legalGuardianRb;
        this.linearLayout6 = linearLayout6;
        this.linearLayout7 = linearLayout7;
        this.linearLayout9 = linearLayout9;
        this.maleRb = maleRb;
        this.middleNameEd = middleNameEd;
        this.middleNameHead = middleNameHead;
        this.middleNameTransTv = middleNameTransTv;
        this.mobNumRg = mobNumRg;
        this.mobileNumEd = mobileNumEd;
        this.motherRadioBtn = motherRadioBtn;
        this.namePhotographTv = namePhotographTv;
        this.nameSurnameEd = nameSurnameEd;
        this.nameSurnameTransEd = nameSurnameTransEd;
        this.nestedScrollView = nestedScrollView;
        this.noAadharRb = noAadharRb;
        this.otherDocEd = otherDocEd;
        this.otherDocRb1 = otherDocRb1;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photoSizeTv = photoSizeTv;
        this.relative = relative;
        this.self = self;
        this.selfRb = selfRb;
        this.surnameEd = surnameEd;
        this.surnameNameHead = surnameNameHead;
        this.surnameTransTv = surnameTransTv;
        this.textView14 = textView14;
        this.thirdGender = thirdGender;
        this.view1 = view1;
        this.view10 = view10;
        this.view11 = view11;
        this.view2 = view2;
        this.view3 = view3;
        this.view4 = view4;
        this.view5 = view5;
        this.view8 = view8;
        this.view9 = view9;
        this.wifeRadioBtn = wifeRadioBtn;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BloFragmentPersonalDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentPersonalDetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_personal_details, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentPersonalDetailsBinding bind(View rootView) {
        int i = R.id.aadhar_ed;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.aadhar_ed);
        if (editText != null) {
            i = R.id.aadhar_rb;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.aadhar_rb);
            if (radioButton != null) {
                i = R.id.aadhar_rg;
                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.aadhar_rg);
                if (radioGroup != null) {
                    i = R.id.calendar_iv;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.calendar_iv);
                    if (imageView != null) {
                        i = R.id.choose_doc_tv;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_doc_tv);
                        if (textView != null) {
                            i = R.id.choose_file_tv;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_tv);
                            if (textView2 != null) {
                                i = R.id.choose_file_tv2;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_tv2);
                                if (textView3 != null) {
                                    i = R.id.choose_photo;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_photo);
                                    if (textView4 != null) {
                                        i = R.id.delete_uploaded_iv;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.delete_uploaded_iv);
                                        if (imageView2 != null) {
                                            i = R.id.delete_uploaded_iv2;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.delete_uploaded_iv2);
                                            if (imageView3 != null) {
                                                i = R.id.dob_doc_spinner;
                                                NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.dob_doc_spinner);
                                                if (noDefaultSpinner != null) {
                                                    i = R.id.dob_proof_rb1;
                                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.dob_proof_rb1);
                                                    if (radioButton2 != null) {
                                                        i = R.id.dob_tv;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dob_tv);
                                                        if (textView5 != null) {
                                                            i = R.id.doc_proof_rg;
                                                            RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.doc_proof_rg);
                                                            if (radioGroup2 != null) {
                                                                i = R.id.doc_size_tv;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc_size_tv);
                                                                if (textView6 != null) {
                                                                    i = R.id.email_ed;
                                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.email_ed);
                                                                    if (editText2 != null) {
                                                                        i = R.id.email_rb;
                                                                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.email_rb);
                                                                        if (radioButton3 != null) {
                                                                            i = R.id.email_rg;
                                                                            RadioGroup radioGroup3 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.email_rg);
                                                                            if (radioGroup3 != null) {
                                                                                i = R.id.family_radio_group;
                                                                                RadioGroup radioGroup4 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.family_radio_group);
                                                                                if (radioGroup4 != null) {
                                                                                    i = R.id.father_radio_btn;
                                                                                    RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.father_radio_btn);
                                                                                    if (radioButton4 != null) {
                                                                                        i = R.id.female_rb;
                                                                                        RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.female_rb);
                                                                                        if (radioButton5 != null) {
                                                                                            i = R.id.first_name_ed;
                                                                                            EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.first_name_ed);
                                                                                            if (editText3 != null) {
                                                                                                i = R.id.first_name_head;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_head);
                                                                                                if (textView7 != null) {
                                                                                                    i = R.id.first_name_trans_tv;
                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_trans_tv);
                                                                                                    if (textView8 != null) {
                                                                                                        i = R.id.first_name_tv3;
                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_tv3);
                                                                                                        if (textView9 != null) {
                                                                                                            i = R.id.gender_rg;
                                                                                                            RadioGroup radioGroup5 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.gender_rg);
                                                                                                            if (radioGroup5 != null) {
                                                                                                                i = R.id.husband_radio_btn;
                                                                                                                RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.husband_radio_btn);
                                                                                                                if (radioButton6 != null) {
                                                                                                                    i = R.id.imageView5;
                                                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView5);
                                                                                                                    if (imageView4 != null) {
                                                                                                                        i = R.id.imageView6;
                                                                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView6);
                                                                                                                        if (imageView5 != null) {
                                                                                                                            i = R.id.imageView7;
                                                                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView7);
                                                                                                                            if (imageView6 != null) {
                                                                                                                                i = R.id.imageView8;
                                                                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView8);
                                                                                                                                if (imageView7 != null) {
                                                                                                                                    i = R.id.legal_guardian_rb;
                                                                                                                                    RadioButton radioButton7 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.legal_guardian_rb);
                                                                                                                                    if (radioButton7 != null) {
                                                                                                                                        i = R.id.linearLayout6;
                                                                                                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout6);
                                                                                                                                        if (linearLayout != null) {
                                                                                                                                            i = R.id.linearLayout7;
                                                                                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout7);
                                                                                                                                            if (linearLayout2 != null) {
                                                                                                                                                i = R.id.linearLayout9;
                                                                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout9);
                                                                                                                                                if (linearLayout3 != null) {
                                                                                                                                                    i = R.id.male_rb;
                                                                                                                                                    RadioButton radioButton8 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.male_rb);
                                                                                                                                                    if (radioButton8 != null) {
                                                                                                                                                        i = R.id.middle_name_ed;
                                                                                                                                                        EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.middle_name_ed);
                                                                                                                                                        if (editText4 != null) {
                                                                                                                                                            i = R.id.middle_name_head;
                                                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.middle_name_head);
                                                                                                                                                            if (textView10 != null) {
                                                                                                                                                                i = R.id.middle_name_trans_tv;
                                                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.middle_name_trans_tv);
                                                                                                                                                                if (textView11 != null) {
                                                                                                                                                                    i = R.id.mob_num_rg;
                                                                                                                                                                    RadioGroup radioGroup6 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.mob_num_rg);
                                                                                                                                                                    if (radioGroup6 != null) {
                                                                                                                                                                        i = R.id.mobile_num_ed;
                                                                                                                                                                        EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobile_num_ed);
                                                                                                                                                                        if (editText5 != null) {
                                                                                                                                                                            i = R.id.mother_radio_btn;
                                                                                                                                                                            RadioButton radioButton9 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.mother_radio_btn);
                                                                                                                                                                            if (radioButton9 != null) {
                                                                                                                                                                                i = R.id.name_photograph_tv;
                                                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_photograph_tv);
                                                                                                                                                                                if (textView12 != null) {
                                                                                                                                                                                    i = R.id.name_surname_ed;
                                                                                                                                                                                    EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.name_surname_ed);
                                                                                                                                                                                    if (editText6 != null) {
                                                                                                                                                                                        i = R.id.name_surname_trans_ed;
                                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_surname_trans_ed);
                                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                                            i = R.id.nestedScrollView;
                                                                                                                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.nestedScrollView);
                                                                                                                                                                                            if (linearLayout4 != null) {
                                                                                                                                                                                                i = R.id.no_aadhar_rb;
                                                                                                                                                                                                RadioButton radioButton10 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.no_aadhar_rb);
                                                                                                                                                                                                if (radioButton10 != null) {
                                                                                                                                                                                                    i = R.id.other_doc_ed;
                                                                                                                                                                                                    EditText editText7 = (EditText) ViewBindings.findChildViewById(rootView, R.id.other_doc_ed);
                                                                                                                                                                                                    if (editText7 != null) {
                                                                                                                                                                                                        i = R.id.other_doc_rb1;
                                                                                                                                                                                                        RadioButton radioButton11 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.other_doc_rb1);
                                                                                                                                                                                                        if (radioButton11 != null) {
                                                                                                                                                                                                            i = R.id.photo1;
                                                                                                                                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.photo1);
                                                                                                                                                                                                            if (imageView8 != null) {
                                                                                                                                                                                                                i = R.id.photo2;
                                                                                                                                                                                                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.photo2);
                                                                                                                                                                                                                if (imageView9 != null) {
                                                                                                                                                                                                                    i = R.id.photo_size_tv;
                                                                                                                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo_size_tv);
                                                                                                                                                                                                                    if (textView14 != null) {
                                                                                                                                                                                                                        i = R.id.relative;
                                                                                                                                                                                                                        RadioButton radioButton12 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.relative);
                                                                                                                                                                                                                        if (radioButton12 != null) {
                                                                                                                                                                                                                            i = R.id.self;
                                                                                                                                                                                                                            RadioButton radioButton13 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.self);
                                                                                                                                                                                                                            if (radioButton13 != null) {
                                                                                                                                                                                                                                i = R.id.self_rb;
                                                                                                                                                                                                                                RadioButton radioButton14 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.self_rb);
                                                                                                                                                                                                                                if (radioButton14 != null) {
                                                                                                                                                                                                                                    i = R.id.surname_ed;
                                                                                                                                                                                                                                    EditText editText8 = (EditText) ViewBindings.findChildViewById(rootView, R.id.surname_ed);
                                                                                                                                                                                                                                    if (editText8 != null) {
                                                                                                                                                                                                                                        i = R.id.surname_name_head;
                                                                                                                                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.surname_name_head);
                                                                                                                                                                                                                                        if (textView15 != null) {
                                                                                                                                                                                                                                            i = R.id.surname_trans_tv;
                                                                                                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.surname_trans_tv);
                                                                                                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                                                                                                i = R.id.textView14;
                                                                                                                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView14);
                                                                                                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                                                                                                    i = R.id.third_gender;
                                                                                                                                                                                                                                                    RadioButton radioButton15 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.third_gender);
                                                                                                                                                                                                                                                    if (radioButton15 != null) {
                                                                                                                                                                                                                                                        i = R.id.view1;
                                                                                                                                                                                                                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                                                                                                                                                                                                                                                        if (viewFindChildViewById != null) {
                                                                                                                                                                                                                                                            i = R.id.view10;
                                                                                                                                                                                                                                                            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view10);
                                                                                                                                                                                                                                                            if (viewFindChildViewById2 != null) {
                                                                                                                                                                                                                                                                i = R.id.view11;
                                                                                                                                                                                                                                                                View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.view11);
                                                                                                                                                                                                                                                                if (viewFindChildViewById3 != null) {
                                                                                                                                                                                                                                                                    i = R.id.view2;
                                                                                                                                                                                                                                                                    View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                                                                                                                                                                                                                                    if (viewFindChildViewById4 != null) {
                                                                                                                                                                                                                                                                        i = R.id.view3;
                                                                                                                                                                                                                                                                        View viewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.view3);
                                                                                                                                                                                                                                                                        if (viewFindChildViewById5 != null) {
                                                                                                                                                                                                                                                                            i = R.id.view4;
                                                                                                                                                                                                                                                                            View viewFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.view4);
                                                                                                                                                                                                                                                                            if (viewFindChildViewById6 != null) {
                                                                                                                                                                                                                                                                                i = R.id.view5;
                                                                                                                                                                                                                                                                                View viewFindChildViewById7 = ViewBindings.findChildViewById(rootView, R.id.view5);
                                                                                                                                                                                                                                                                                if (viewFindChildViewById7 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.view8;
                                                                                                                                                                                                                                                                                    View viewFindChildViewById8 = ViewBindings.findChildViewById(rootView, R.id.view8);
                                                                                                                                                                                                                                                                                    if (viewFindChildViewById8 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.view9;
                                                                                                                                                                                                                                                                                        View viewFindChildViewById9 = ViewBindings.findChildViewById(rootView, R.id.view9);
                                                                                                                                                                                                                                                                                        if (viewFindChildViewById9 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.wife_radio_btn;
                                                                                                                                                                                                                                                                                            RadioButton radioButton16 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.wife_radio_btn);
                                                                                                                                                                                                                                                                                            if (radioButton16 != null) {
                                                                                                                                                                                                                                                                                                return new BloFragmentPersonalDetailsBinding((ScrollView) rootView, editText, radioButton, radioGroup, imageView, textView, textView2, textView3, textView4, imageView2, imageView3, noDefaultSpinner, radioButton2, textView5, radioGroup2, textView6, editText2, radioButton3, radioGroup3, radioGroup4, radioButton4, radioButton5, editText3, textView7, textView8, textView9, radioGroup5, radioButton6, imageView4, imageView5, imageView6, imageView7, radioButton7, linearLayout, linearLayout2, linearLayout3, radioButton8, editText4, textView10, textView11, radioGroup6, editText5, radioButton9, textView12, editText6, textView13, linearLayout4, radioButton10, editText7, radioButton11, imageView8, imageView9, textView14, radioButton12, radioButton13, radioButton14, editText8, textView15, textView16, textView17, radioButton15, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, viewFindChildViewById6, viewFindChildViewById7, viewFindChildViewById8, viewFindChildViewById9, radioButton16);
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
