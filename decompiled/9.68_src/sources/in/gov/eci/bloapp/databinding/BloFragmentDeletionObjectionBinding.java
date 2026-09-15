package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
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
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentDeletionObjectionBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout bottomPreviousSaveLayout;
    public final CardView cardView;
    public final Button chooseFile;
    public final ConstraintLayout chooseFileItems;
    public final EditText constituencyEd;
    public final TextView constituencyTv;
    public final EditText constituencynoEd;
    public final ConstraintLayout constraintLayout;
    public final RadioGroup deathCertificateReg;
    public final LinearLayout deathLayout;
    public final LinearLayout declarationFormLayout;
    public final LinearLayout declarationLayout;
    public final ImageView deletebtn;
    public final LinearLayout deletionObjectionFormLayout;
    public final EditText districtEd;
    public final TextView districtEd1;
    public final TextView districtTv;
    public final TextView districtTv1;
    public final TextView epicEd;
    public final TextView epicEd2;
    public final TextView firstNameEd;
    public final ImageView homeBtnIv;
    public final ConstraintLayout homeFragmentTopConstraintLayout;
    public final HorizontalScrollView horizontal;
    public final EditText houseEd;
    public final AutoCompleteTextView houseEd2;
    public final TextView issueDateEd;
    public final RadioGroup mobNumRg;
    public final TextView mobNumTv;
    public final EditText mobileNum91;
    public final EditText mobileNumEd;
    public final TextView nameEd;
    public final RadioButton noRg;
    public final RadioButton optionRb1;
    public final RadioButton optionRb2;
    public final RadioButton optionRb3;
    public final LinearLayout personDetailsFormLayout;
    public final LinearLayout personDetailsLayout;
    public final LinearLayout personalDetailLayout;
    public final LinearLayout personalDetailsFormLayout;
    public final EditText pincodeEd;
    public final EditText placeEd;
    public final EditText postofficeEd;
    public final AutoCompleteTextView postofficeEd2;
    public final TextView postofficeTv;
    public final ImageView preview;
    public final TextView previousTv;
    public final LinearLayout rejectionOptionsFormLayout;
    public final LinearLayout rejectionOptionsLayout;
    public final RadioGroup rejectionOptionsRg;
    public final NoDefaultSpinner rejectionSpinner1;
    public final NoDefaultSpinner rejectionSpinner2;
    public final NoDefaultSpinner rejectionSpinner3;
    public final ConstraintLayout rejectionSpinnerLayout1;
    public final ConstraintLayout rejectionSpinnerLayout2;
    public final ConstraintLayout rejectionSpinnerLayout3;
    public final TextView rejectionSpinnerTv1;
    public final TextView rejectionSpinnerTv2;
    public final TextView rejectionSpinnerTv3;
    public final RadioButton relative;
    public final TextView resetTv;
    private final ConstraintLayout rootView;
    public final TextView saveNextTv;
    public final TextView selectName;
    public final TextView selectSize;
    public final LinearLayout selectStateLayout;
    public final RadioButton self;
    public final EditText stateEd;
    public final TextView stateEd1;
    public final TextView stateTv;
    public final TextView stateTv1;
    public final EditText streetEd;
    public final AutoCompleteTextView streetEd2;
    public final TextView surNameEd2;
    public final EditText tehsilEd;
    public final AutoCompleteTextView tehsilEd2;
    public final TextView tehsilTv;
    public final TextView textView10;
    public final TextView textView12;
    public final TextView textView13;
    public final TextView textView15;
    public final TextView textView17;
    public final TextView textView18;
    public final TextView textView19;
    public final TextView textView20;
    public final TextView textView21;
    public final TextView textView22;
    public final TextView textView25;
    public final TextView textView3;
    public final TextView textView30;
    public final TextView textView31;
    public final TextView textView32;
    public final TextView textView7;
    public final TextView textView9;
    public final TextView upload;
    public final UploadFormAddDocBinding uploadDocIncludedLayout;
    public final LinearLayout uploadLayout;
    public final TextView uploadSpecifications;
    public final View view4;
    public final View viewSpinner1;
    public final View viewSpinner2;
    public final View viewSpinner3;
    public final EditText villageEd;
    public final AutoCompleteTextView villageEd2;
    public final TextView villageTv;
    public final RadioButton yesRg;

    private BloFragmentDeletionObjectionBinding(ConstraintLayout rootView, ImageView backBtnIv, ConstraintLayout bottomPreviousSaveLayout, CardView cardView, Button chooseFile, ConstraintLayout chooseFileItems, EditText constituencyEd, TextView constituencyTv, EditText constituencynoEd, ConstraintLayout constraintLayout, RadioGroup deathCertificateReg, LinearLayout deathLayout, LinearLayout declarationFormLayout, LinearLayout declarationLayout, ImageView deletebtn, LinearLayout deletionObjectionFormLayout, EditText districtEd, TextView districtEd1, TextView districtTv, TextView districtTv1, TextView epicEd, TextView epicEd2, TextView firstNameEd, ImageView homeBtnIv, ConstraintLayout homeFragmentTopConstraintLayout, HorizontalScrollView horizontal, EditText houseEd, AutoCompleteTextView houseEd2, TextView issueDateEd, RadioGroup mobNumRg, TextView mobNumTv, EditText mobileNum91, EditText mobileNumEd, TextView nameEd, RadioButton noRg, RadioButton optionRb1, RadioButton optionRb2, RadioButton optionRb3, LinearLayout personDetailsFormLayout, LinearLayout personDetailsLayout, LinearLayout personalDetailLayout, LinearLayout personalDetailsFormLayout, EditText pincodeEd, EditText placeEd, EditText postofficeEd, AutoCompleteTextView postofficeEd2, TextView postofficeTv, ImageView preview, TextView previousTv, LinearLayout rejectionOptionsFormLayout, LinearLayout rejectionOptionsLayout, RadioGroup rejectionOptionsRg, NoDefaultSpinner rejectionSpinner1, NoDefaultSpinner rejectionSpinner2, NoDefaultSpinner rejectionSpinner3, ConstraintLayout rejectionSpinnerLayout1, ConstraintLayout rejectionSpinnerLayout2, ConstraintLayout rejectionSpinnerLayout3, TextView rejectionSpinnerTv1, TextView rejectionSpinnerTv2, TextView rejectionSpinnerTv3, RadioButton relative, TextView resetTv, TextView saveNextTv, TextView selectName, TextView selectSize, LinearLayout selectStateLayout, RadioButton self, EditText stateEd, TextView stateEd1, TextView stateTv, TextView stateTv1, EditText streetEd, AutoCompleteTextView streetEd2, TextView surNameEd2, EditText tehsilEd, AutoCompleteTextView tehsilEd2, TextView tehsilTv, TextView textView10, TextView textView12, TextView textView13, TextView textView15, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView25, TextView textView3, TextView textView30, TextView textView31, TextView textView32, TextView textView7, TextView textView9, TextView upload, UploadFormAddDocBinding uploadDocIncludedLayout, LinearLayout uploadLayout, TextView uploadSpecifications, View view4, View viewSpinner1, View viewSpinner2, View viewSpinner3, EditText villageEd, AutoCompleteTextView villageEd2, TextView villageTv, RadioButton yesRg) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.bottomPreviousSaveLayout = bottomPreviousSaveLayout;
        this.cardView = cardView;
        this.chooseFile = chooseFile;
        this.chooseFileItems = chooseFileItems;
        this.constituencyEd = constituencyEd;
        this.constituencyTv = constituencyTv;
        this.constituencynoEd = constituencynoEd;
        this.constraintLayout = constraintLayout;
        this.deathCertificateReg = deathCertificateReg;
        this.deathLayout = deathLayout;
        this.declarationFormLayout = declarationFormLayout;
        this.declarationLayout = declarationLayout;
        this.deletebtn = deletebtn;
        this.deletionObjectionFormLayout = deletionObjectionFormLayout;
        this.districtEd = districtEd;
        this.districtEd1 = districtEd1;
        this.districtTv = districtTv;
        this.districtTv1 = districtTv1;
        this.epicEd = epicEd;
        this.epicEd2 = epicEd2;
        this.firstNameEd = firstNameEd;
        this.homeBtnIv = homeBtnIv;
        this.homeFragmentTopConstraintLayout = homeFragmentTopConstraintLayout;
        this.horizontal = horizontal;
        this.houseEd = houseEd;
        this.houseEd2 = houseEd2;
        this.issueDateEd = issueDateEd;
        this.mobNumRg = mobNumRg;
        this.mobNumTv = mobNumTv;
        this.mobileNum91 = mobileNum91;
        this.mobileNumEd = mobileNumEd;
        this.nameEd = nameEd;
        this.noRg = noRg;
        this.optionRb1 = optionRb1;
        this.optionRb2 = optionRb2;
        this.optionRb3 = optionRb3;
        this.personDetailsFormLayout = personDetailsFormLayout;
        this.personDetailsLayout = personDetailsLayout;
        this.personalDetailLayout = personalDetailLayout;
        this.personalDetailsFormLayout = personalDetailsFormLayout;
        this.pincodeEd = pincodeEd;
        this.placeEd = placeEd;
        this.postofficeEd = postofficeEd;
        this.postofficeEd2 = postofficeEd2;
        this.postofficeTv = postofficeTv;
        this.preview = preview;
        this.previousTv = previousTv;
        this.rejectionOptionsFormLayout = rejectionOptionsFormLayout;
        this.rejectionOptionsLayout = rejectionOptionsLayout;
        this.rejectionOptionsRg = rejectionOptionsRg;
        this.rejectionSpinner1 = rejectionSpinner1;
        this.rejectionSpinner2 = rejectionSpinner2;
        this.rejectionSpinner3 = rejectionSpinner3;
        this.rejectionSpinnerLayout1 = rejectionSpinnerLayout1;
        this.rejectionSpinnerLayout2 = rejectionSpinnerLayout2;
        this.rejectionSpinnerLayout3 = rejectionSpinnerLayout3;
        this.rejectionSpinnerTv1 = rejectionSpinnerTv1;
        this.rejectionSpinnerTv2 = rejectionSpinnerTv2;
        this.rejectionSpinnerTv3 = rejectionSpinnerTv3;
        this.relative = relative;
        this.resetTv = resetTv;
        this.saveNextTv = saveNextTv;
        this.selectName = selectName;
        this.selectSize = selectSize;
        this.selectStateLayout = selectStateLayout;
        this.self = self;
        this.stateEd = stateEd;
        this.stateEd1 = stateEd1;
        this.stateTv = stateTv;
        this.stateTv1 = stateTv1;
        this.streetEd = streetEd;
        this.streetEd2 = streetEd2;
        this.surNameEd2 = surNameEd2;
        this.tehsilEd = tehsilEd;
        this.tehsilEd2 = tehsilEd2;
        this.tehsilTv = tehsilTv;
        this.textView10 = textView10;
        this.textView12 = textView12;
        this.textView13 = textView13;
        this.textView15 = textView15;
        this.textView17 = textView17;
        this.textView18 = textView18;
        this.textView19 = textView19;
        this.textView20 = textView20;
        this.textView21 = textView21;
        this.textView22 = textView22;
        this.textView25 = textView25;
        this.textView3 = textView3;
        this.textView30 = textView30;
        this.textView31 = textView31;
        this.textView32 = textView32;
        this.textView7 = textView7;
        this.textView9 = textView9;
        this.upload = upload;
        this.uploadDocIncludedLayout = uploadDocIncludedLayout;
        this.uploadLayout = uploadLayout;
        this.uploadSpecifications = uploadSpecifications;
        this.view4 = view4;
        this.viewSpinner1 = viewSpinner1;
        this.viewSpinner2 = viewSpinner2;
        this.viewSpinner3 = viewSpinner3;
        this.villageEd = villageEd;
        this.villageEd2 = villageEd2;
        this.villageTv = villageTv;
        this.yesRg = yesRg;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentDeletionObjectionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentDeletionObjectionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_deletion_objection, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentDeletionObjectionBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bottom_previous_save_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_previous_save_layout);
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
                            i = R.id.constituency_ed;
                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.constituency_ed);
                            if (editText != null) {
                                i = R.id.constituency_tv;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.constituency_tv);
                                if (textView != null) {
                                    i = R.id.constituencyno_ed;
                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.constituencyno_ed);
                                    if (editText2 != null) {
                                        i = R.id.constraintLayout;
                                        ConstraintLayout constraintLayoutFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
                                        if (constraintLayoutFindChildViewById3 != null) {
                                            i = R.id.death_certificate_reg;
                                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.death_certificate_reg);
                                            if (radioGroup != null) {
                                                i = R.id.death_layout;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.death_layout);
                                                if (linearLayout != null) {
                                                    i = R.id.declaration_form_layout;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.declaration_form_layout);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.declaration_layout;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.declaration_layout);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.deletebtn;
                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deletebtn);
                                                            if (imageView2 != null) {
                                                                i = R.id.deletion_objection_form_layout;
                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.deletion_objection_form_layout);
                                                                if (linearLayout4 != null) {
                                                                    i = R.id.district_ed;
                                                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.district_ed);
                                                                    if (editText3 != null) {
                                                                        i = R.id.district_ed1;
                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_ed1);
                                                                        if (textView2 != null) {
                                                                            i = R.id.district_tv;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_tv);
                                                                            if (textView3 != null) {
                                                                                i = R.id.district_tv1;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_tv1);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.epic_ed;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_ed);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.epic_ed2;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_ed2);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.first_name_ed;
                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_ed);
                                                                                            if (textView7 != null) {
                                                                                                i = R.id.home_btn_iv;
                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                                                                                                if (imageView3 != null) {
                                                                                                    i = R.id.home_fragment_top_constraint_layout;
                                                                                                    ConstraintLayout constraintLayoutFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.home_fragment_top_constraint_layout);
                                                                                                    if (constraintLayoutFindChildViewById4 != null) {
                                                                                                        i = R.id.horizontal;
                                                                                                        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(rootView, R.id.horizontal);
                                                                                                        if (horizontalScrollView != null) {
                                                                                                            i = R.id.house_ed;
                                                                                                            EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.house_ed);
                                                                                                            if (editText4 != null) {
                                                                                                                i = R.id.house_ed2;
                                                                                                                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.house_ed2);
                                                                                                                if (autoCompleteTextView != null) {
                                                                                                                    i = R.id.issueDateEd;
                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.issueDateEd);
                                                                                                                    if (textView8 != null) {
                                                                                                                        i = R.id.mobNumRg;
                                                                                                                        RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.mobNumRg);
                                                                                                                        if (radioGroup2 != null) {
                                                                                                                            i = R.id.mob_num_tv;
                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mob_num_tv);
                                                                                                                            if (textView9 != null) {
                                                                                                                                i = R.id.mobile_num_91;
                                                                                                                                EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobile_num_91);
                                                                                                                                if (editText5 != null) {
                                                                                                                                    i = R.id.mobile_num_ed;
                                                                                                                                    EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobile_num_ed);
                                                                                                                                    if (editText6 != null) {
                                                                                                                                        i = R.id.name_ed;
                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_ed);
                                                                                                                                        if (textView10 != null) {
                                                                                                                                            i = R.id.no_rg;
                                                                                                                                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.no_rg);
                                                                                                                                            if (radioButton != null) {
                                                                                                                                                i = R.id.option_rb1;
                                                                                                                                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.option_rb1);
                                                                                                                                                if (radioButton2 != null) {
                                                                                                                                                    i = R.id.option_rb2;
                                                                                                                                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.option_rb2);
                                                                                                                                                    if (radioButton3 != null) {
                                                                                                                                                        i = R.id.option_rb3;
                                                                                                                                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.option_rb3);
                                                                                                                                                        if (radioButton4 != null) {
                                                                                                                                                            i = R.id.person_details_form_layout;
                                                                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.person_details_form_layout);
                                                                                                                                                            if (linearLayout5 != null) {
                                                                                                                                                                i = R.id.person_details_layout;
                                                                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.person_details_layout);
                                                                                                                                                                if (linearLayout6 != null) {
                                                                                                                                                                    i = R.id.personal_detail_layout;
                                                                                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.personal_detail_layout);
                                                                                                                                                                    if (linearLayout7 != null) {
                                                                                                                                                                        i = R.id.personal_details_form_layout;
                                                                                                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.personal_details_form_layout);
                                                                                                                                                                        if (linearLayout8 != null) {
                                                                                                                                                                            i = R.id.pincode_ed;
                                                                                                                                                                            EditText editText7 = (EditText) ViewBindings.findChildViewById(rootView, R.id.pincode_ed);
                                                                                                                                                                            if (editText7 != null) {
                                                                                                                                                                                i = R.id.place_ed;
                                                                                                                                                                                EditText editText8 = (EditText) ViewBindings.findChildViewById(rootView, R.id.place_ed);
                                                                                                                                                                                if (editText8 != null) {
                                                                                                                                                                                    i = R.id.postoffice_ed;
                                                                                                                                                                                    EditText editText9 = (EditText) ViewBindings.findChildViewById(rootView, R.id.postoffice_ed);
                                                                                                                                                                                    if (editText9 != null) {
                                                                                                                                                                                        i = R.id.postoffice_ed2;
                                                                                                                                                                                        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.postoffice_ed2);
                                                                                                                                                                                        if (autoCompleteTextView2 != null) {
                                                                                                                                                                                            i = R.id.postoffice_tv;
                                                                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.postoffice_tv);
                                                                                                                                                                                            if (textView11 != null) {
                                                                                                                                                                                                i = R.id.preview;
                                                                                                                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.preview);
                                                                                                                                                                                                if (imageView4 != null) {
                                                                                                                                                                                                    i = R.id.previous_tv;
                                                                                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.previous_tv);
                                                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                                                        i = R.id.rejection_options_form_layout;
                                                                                                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rejection_options_form_layout);
                                                                                                                                                                                                        if (linearLayout9 != null) {
                                                                                                                                                                                                            i = R.id.rejection_options_layout;
                                                                                                                                                                                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rejection_options_layout);
                                                                                                                                                                                                            if (linearLayout10 != null) {
                                                                                                                                                                                                                i = R.id.rejection_options_rg;
                                                                                                                                                                                                                RadioGroup radioGroup3 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.rejection_options_rg);
                                                                                                                                                                                                                if (radioGroup3 != null) {
                                                                                                                                                                                                                    i = R.id.rejection_spinner1;
                                                                                                                                                                                                                    NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.rejection_spinner1);
                                                                                                                                                                                                                    if (noDefaultSpinner != null) {
                                                                                                                                                                                                                        i = R.id.rejection_spinner2;
                                                                                                                                                                                                                        NoDefaultSpinner noDefaultSpinner2 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.rejection_spinner2);
                                                                                                                                                                                                                        if (noDefaultSpinner2 != null) {
                                                                                                                                                                                                                            i = R.id.rejection_spinner3;
                                                                                                                                                                                                                            NoDefaultSpinner noDefaultSpinner3 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.rejection_spinner3);
                                                                                                                                                                                                                            if (noDefaultSpinner3 != null) {
                                                                                                                                                                                                                                i = R.id.rejection_spinner_layout1;
                                                                                                                                                                                                                                ConstraintLayout constraintLayoutFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.rejection_spinner_layout1);
                                                                                                                                                                                                                                if (constraintLayoutFindChildViewById5 != null) {
                                                                                                                                                                                                                                    i = R.id.rejection_spinner_layout2;
                                                                                                                                                                                                                                    ConstraintLayout constraintLayoutFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.rejection_spinner_layout2);
                                                                                                                                                                                                                                    if (constraintLayoutFindChildViewById6 != null) {
                                                                                                                                                                                                                                        i = R.id.rejection_spinner_layout3;
                                                                                                                                                                                                                                        ConstraintLayout constraintLayoutFindChildViewById7 = ViewBindings.findChildViewById(rootView, R.id.rejection_spinner_layout3);
                                                                                                                                                                                                                                        if (constraintLayoutFindChildViewById7 != null) {
                                                                                                                                                                                                                                            i = R.id.rejection_spinner_tv1;
                                                                                                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rejection_spinner_tv1);
                                                                                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                                                                                i = R.id.rejection_spinner_tv2;
                                                                                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rejection_spinner_tv2);
                                                                                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                                                                                    i = R.id.rejection_spinner_tv3;
                                                                                                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rejection_spinner_tv3);
                                                                                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                                                                                        i = R.id.relative;
                                                                                                                                                                                                                                                        RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.relative);
                                                                                                                                                                                                                                                        if (radioButton5 != null) {
                                                                                                                                                                                                                                                            i = R.id.reset_tv;
                                                                                                                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.reset_tv);
                                                                                                                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                                                                                                                i = R.id.save_next_tv;
                                                                                                                                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.save_next_tv);
                                                                                                                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                                                                                                                    i = R.id.select_name;
                                                                                                                                                                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.select_name);
                                                                                                                                                                                                                                                                    if (textView18 != null) {
                                                                                                                                                                                                                                                                        i = R.id.select_size;
                                                                                                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.select_size);
                                                                                                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                                                                                                            i = R.id.select_state_layout;
                                                                                                                                                                                                                                                                            LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.select_state_layout);
                                                                                                                                                                                                                                                                            if (linearLayout11 != null) {
                                                                                                                                                                                                                                                                                i = R.id.self;
                                                                                                                                                                                                                                                                                RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.self);
                                                                                                                                                                                                                                                                                if (radioButton6 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.state_ed;
                                                                                                                                                                                                                                                                                    EditText editText10 = (EditText) ViewBindings.findChildViewById(rootView, R.id.state_ed);
                                                                                                                                                                                                                                                                                    if (editText10 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.state_ed1;
                                                                                                                                                                                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_ed1);
                                                                                                                                                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.state_tv;
                                                                                                                                                                                                                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv);
                                                                                                                                                                                                                                                                                            if (textView21 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.state_tv1;
                                                                                                                                                                                                                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv1);
                                                                                                                                                                                                                                                                                                if (textView22 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.street_ed;
                                                                                                                                                                                                                                                                                                    EditText editText11 = (EditText) ViewBindings.findChildViewById(rootView, R.id.street_ed);
                                                                                                                                                                                                                                                                                                    if (editText11 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.street_ed2;
                                                                                                                                                                                                                                                                                                        AutoCompleteTextView autoCompleteTextView3 = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.street_ed2);
                                                                                                                                                                                                                                                                                                        if (autoCompleteTextView3 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.sur_name_ed2;
                                                                                                                                                                                                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sur_name_ed2);
                                                                                                                                                                                                                                                                                                            if (textView23 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.tehsil_ed;
                                                                                                                                                                                                                                                                                                                EditText editText12 = (EditText) ViewBindings.findChildViewById(rootView, R.id.tehsil_ed);
                                                                                                                                                                                                                                                                                                                if (editText12 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.tehsil_ed2;
                                                                                                                                                                                                                                                                                                                    AutoCompleteTextView autoCompleteTextView4 = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.tehsil_ed2);
                                                                                                                                                                                                                                                                                                                    if (autoCompleteTextView4 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.tehsil_tv;
                                                                                                                                                                                                                                                                                                                        TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tehsil_tv);
                                                                                                                                                                                                                                                                                                                        if (textView24 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.textView10;
                                                                                                                                                                                                                                                                                                                            TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView10);
                                                                                                                                                                                                                                                                                                                            if (textView25 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.textView12;
                                                                                                                                                                                                                                                                                                                                TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView12);
                                                                                                                                                                                                                                                                                                                                if (textView26 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.textView13;
                                                                                                                                                                                                                                                                                                                                    TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView13);
                                                                                                                                                                                                                                                                                                                                    if (textView27 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.textView15;
                                                                                                                                                                                                                                                                                                                                        TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView15);
                                                                                                                                                                                                                                                                                                                                        if (textView28 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.textView17;
                                                                                                                                                                                                                                                                                                                                            TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView17);
                                                                                                                                                                                                                                                                                                                                            if (textView29 != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.textView18;
                                                                                                                                                                                                                                                                                                                                                TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView18);
                                                                                                                                                                                                                                                                                                                                                if (textView30 != null) {
                                                                                                                                                                                                                                                                                                                                                    i = R.id.textView19;
                                                                                                                                                                                                                                                                                                                                                    TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView19);
                                                                                                                                                                                                                                                                                                                                                    if (textView31 != null) {
                                                                                                                                                                                                                                                                                                                                                        i = R.id.textView20;
                                                                                                                                                                                                                                                                                                                                                        TextView textView32 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView20);
                                                                                                                                                                                                                                                                                                                                                        if (textView32 != null) {
                                                                                                                                                                                                                                                                                                                                                            i = R.id.textView21;
                                                                                                                                                                                                                                                                                                                                                            TextView textView33 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView21);
                                                                                                                                                                                                                                                                                                                                                            if (textView33 != null) {
                                                                                                                                                                                                                                                                                                                                                                i = R.id.textView22;
                                                                                                                                                                                                                                                                                                                                                                TextView textView34 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView22);
                                                                                                                                                                                                                                                                                                                                                                if (textView34 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i = R.id.textView25;
                                                                                                                                                                                                                                                                                                                                                                    TextView textView35 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView25);
                                                                                                                                                                                                                                                                                                                                                                    if (textView35 != null) {
                                                                                                                                                                                                                                                                                                                                                                        i = R.id.textView3;
                                                                                                                                                                                                                                                                                                                                                                        TextView textView36 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                                                                                                                                                                                                                                                        if (textView36 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i = R.id.textView30;
                                                                                                                                                                                                                                                                                                                                                                            TextView textView37 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView30);
                                                                                                                                                                                                                                                                                                                                                                            if (textView37 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i = R.id.textView31;
                                                                                                                                                                                                                                                                                                                                                                                TextView textView38 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView31);
                                                                                                                                                                                                                                                                                                                                                                                if (textView38 != null) {
                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.textView32;
                                                                                                                                                                                                                                                                                                                                                                                    TextView textView39 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView32);
                                                                                                                                                                                                                                                                                                                                                                                    if (textView39 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.textView7;
                                                                                                                                                                                                                                                                                                                                                                                        TextView textView40 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView7);
                                                                                                                                                                                                                                                                                                                                                                                        if (textView40 != null) {
                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.textView9;
                                                                                                                                                                                                                                                                                                                                                                                            TextView textView41 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView9);
                                                                                                                                                                                                                                                                                                                                                                                            if (textView41 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.upload;
                                                                                                                                                                                                                                                                                                                                                                                                TextView textView42 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload);
                                                                                                                                                                                                                                                                                                                                                                                                if (textView42 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.uploadDocIncludedLayout;
                                                                                                                                                                                                                                                                                                                                                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.uploadDocIncludedLayout);
                                                                                                                                                                                                                                                                                                                                                                                                    if (viewFindChildViewById != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        UploadFormAddDocBinding uploadFormAddDocBindingBind = UploadFormAddDocBinding.bind(viewFindChildViewById);
                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.upload_layout;
                                                                                                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.upload_layout);
                                                                                                                                                                                                                                                                                                                                                                                                        if (linearLayout12 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.upload_specifications;
                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView43 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_specifications);
                                                                                                                                                                                                                                                                                                                                                                                                            if (textView43 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.view4;
                                                                                                                                                                                                                                                                                                                                                                                                                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view4);
                                                                                                                                                                                                                                                                                                                                                                                                                if (viewFindChildViewById2 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.view_spinner1;
                                                                                                                                                                                                                                                                                                                                                                                                                    View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.view_spinner1);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (viewFindChildViewById3 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.view_spinner2;
                                                                                                                                                                                                                                                                                                                                                                                                                        View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.view_spinner2);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (viewFindChildViewById4 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.view_spinner3;
                                                                                                                                                                                                                                                                                                                                                                                                                            View viewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.view_spinner3);
                                                                                                                                                                                                                                                                                                                                                                                                                            if (viewFindChildViewById5 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.village_ed;
                                                                                                                                                                                                                                                                                                                                                                                                                                EditText editText13 = (EditText) ViewBindings.findChildViewById(rootView, R.id.village_ed);
                                                                                                                                                                                                                                                                                                                                                                                                                                if (editText13 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.village_ed2;
                                                                                                                                                                                                                                                                                                                                                                                                                                    AutoCompleteTextView autoCompleteTextView5 = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.village_ed2);
                                                                                                                                                                                                                                                                                                                                                                                                                                    if (autoCompleteTextView5 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.village_tv;
                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView44 = (TextView) ViewBindings.findChildViewById(rootView, R.id.village_tv);
                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView44 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.yes_rg;
                                                                                                                                                                                                                                                                                                                                                                                                                                            RadioButton radioButton7 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.yes_rg);
                                                                                                                                                                                                                                                                                                                                                                                                                                            if (radioButton7 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                return new BloFragmentDeletionObjectionBinding((ConstraintLayout) rootView, imageView, constraintLayoutFindChildViewById, cardViewFindChildViewById, button, constraintLayoutFindChildViewById2, editText, textView, editText2, constraintLayoutFindChildViewById3, radioGroup, linearLayout, linearLayout2, linearLayout3, imageView2, linearLayout4, editText3, textView2, textView3, textView4, textView5, textView6, textView7, imageView3, constraintLayoutFindChildViewById4, horizontalScrollView, editText4, autoCompleteTextView, textView8, radioGroup2, textView9, editText5, editText6, textView10, radioButton, radioButton2, radioButton3, radioButton4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, editText7, editText8, editText9, autoCompleteTextView2, textView11, imageView4, textView12, linearLayout9, linearLayout10, radioGroup3, noDefaultSpinner, noDefaultSpinner2, noDefaultSpinner3, constraintLayoutFindChildViewById5, constraintLayoutFindChildViewById6, constraintLayoutFindChildViewById7, textView13, textView14, textView15, radioButton5, textView16, textView17, textView18, textView19, linearLayout11, radioButton6, editText10, textView20, textView21, textView22, editText11, autoCompleteTextView3, textView23, editText12, autoCompleteTextView4, textView24, textView25, textView26, textView27, textView28, textView29, textView30, textView31, textView32, textView33, textView34, textView35, textView36, textView37, textView38, textView39, textView40, textView41, textView42, uploadFormAddDocBindingBind, linearLayout12, textView43, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, editText13, autoCompleteTextView5, textView44, radioButton7);
                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
