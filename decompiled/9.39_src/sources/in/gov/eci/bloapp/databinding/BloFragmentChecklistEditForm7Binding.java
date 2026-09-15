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
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentChecklistEditForm7Binding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout bottomPreviousSaveLayout;
    public final TextView cancelTv;
    public final CardView cardView;
    public final Button chooseFile;
    public final ConstraintLayout chooseFileItems;
    public final ConstraintLayout constraintLayout;
    public final ConstraintLayout constraintLayout2;
    public final RadioGroup deathCertificateReg;
    public final ImageView deletebtn;
    public final EditText districtEd1;
    public final TextView districtTv1;
    public final EditText epicEd;
    public final EditText epicEd2;
    public final EditText firstNameEd;
    public final TextView formTypeTv;
    public final EditText houseEd;
    public final EditText houseEd2;
    public final RadioGroup mobNumRg;
    public final TextView mobNumTv;
    public final EditText mobileNumEd;
    public final EditText nameEd;
    public final RadioButton noRb;
    public final RadioButton optionRb1;
    public final RadioButton optionRb2;
    public final RadioButton optionRb3;
    public final LinearLayout personDetailsFormLayout;
    public final LinearLayout personalDetailsFormLayout;
    public final EditText pincodeEd;
    public final EditText postofficeEd;
    public final EditText postofficeEd2;
    public final TextView postofficeTv;
    public final ImageView preview;
    public final TextView refNoTv;
    public final LinearLayout rejectionOptionsFormLayout;
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
    public final TextView selectName;
    public final TextView selectSize;
    public final RadioButton self;
    public final EditText stateEd1;
    public final TextView stateTv1;
    public final EditText streetEd;
    public final EditText streetEd2;
    public final EditText surNameEd2;
    public final EditText tehsilEd;
    public final EditText tehsilEd2;
    public final TextView tehsilTv;
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
    public final TextView textView26;
    public final TextView textView33;
    public final TextView textView9;
    public final TextView updateTv;
    public final TextView upload;
    public final LinearLayout uploadLayout;
    public final TextView uploadSpecifications;
    public final View viewSpinner1;
    public final View viewSpinner2;
    public final View viewSpinner3;
    public final EditText villageEd;
    public final EditText villageEd2;
    public final TextView villageTv;
    public final RadioButton yesRb;

    private BloFragmentChecklistEditForm7Binding(ConstraintLayout rootView, ImageView backBtnIv, ConstraintLayout bottomPreviousSaveLayout, TextView cancelTv, CardView cardView, Button chooseFile, ConstraintLayout chooseFileItems, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RadioGroup deathCertificateReg, ImageView deletebtn, EditText districtEd1, TextView districtTv1, EditText epicEd, EditText epicEd2, EditText firstNameEd, TextView formTypeTv, EditText houseEd, EditText houseEd2, RadioGroup mobNumRg, TextView mobNumTv, EditText mobileNumEd, EditText nameEd, RadioButton noRb, RadioButton optionRb1, RadioButton optionRb2, RadioButton optionRb3, LinearLayout personDetailsFormLayout, LinearLayout personalDetailsFormLayout, EditText pincodeEd, EditText postofficeEd, EditText postofficeEd2, TextView postofficeTv, ImageView preview, TextView refNoTv, LinearLayout rejectionOptionsFormLayout, RadioGroup rejectionOptionsRg, NoDefaultSpinner rejectionSpinner1, NoDefaultSpinner rejectionSpinner2, NoDefaultSpinner rejectionSpinner3, ConstraintLayout rejectionSpinnerLayout1, ConstraintLayout rejectionSpinnerLayout2, ConstraintLayout rejectionSpinnerLayout3, TextView rejectionSpinnerTv1, TextView rejectionSpinnerTv2, TextView rejectionSpinnerTv3, RadioButton relative, TextView resetTv, TextView selectName, TextView selectSize, RadioButton self, EditText stateEd1, TextView stateTv1, EditText streetEd, EditText streetEd2, EditText surNameEd2, EditText tehsilEd, EditText tehsilEd2, TextView tehsilTv, TextView textView12, TextView textView13, TextView textView15, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView25, TextView textView26, TextView textView33, TextView textView9, TextView updateTv, TextView upload, LinearLayout uploadLayout, TextView uploadSpecifications, View viewSpinner1, View viewSpinner2, View viewSpinner3, EditText villageEd, EditText villageEd2, TextView villageTv, RadioButton yesRb) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.bottomPreviousSaveLayout = bottomPreviousSaveLayout;
        this.cancelTv = cancelTv;
        this.cardView = cardView;
        this.chooseFile = chooseFile;
        this.chooseFileItems = chooseFileItems;
        this.constraintLayout = constraintLayout;
        this.constraintLayout2 = constraintLayout2;
        this.deathCertificateReg = deathCertificateReg;
        this.deletebtn = deletebtn;
        this.districtEd1 = districtEd1;
        this.districtTv1 = districtTv1;
        this.epicEd = epicEd;
        this.epicEd2 = epicEd2;
        this.firstNameEd = firstNameEd;
        this.formTypeTv = formTypeTv;
        this.houseEd = houseEd;
        this.houseEd2 = houseEd2;
        this.mobNumRg = mobNumRg;
        this.mobNumTv = mobNumTv;
        this.mobileNumEd = mobileNumEd;
        this.nameEd = nameEd;
        this.noRb = noRb;
        this.optionRb1 = optionRb1;
        this.optionRb2 = optionRb2;
        this.optionRb3 = optionRb3;
        this.personDetailsFormLayout = personDetailsFormLayout;
        this.personalDetailsFormLayout = personalDetailsFormLayout;
        this.pincodeEd = pincodeEd;
        this.postofficeEd = postofficeEd;
        this.postofficeEd2 = postofficeEd2;
        this.postofficeTv = postofficeTv;
        this.preview = preview;
        this.refNoTv = refNoTv;
        this.rejectionOptionsFormLayout = rejectionOptionsFormLayout;
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
        this.selectName = selectName;
        this.selectSize = selectSize;
        this.self = self;
        this.stateEd1 = stateEd1;
        this.stateTv1 = stateTv1;
        this.streetEd = streetEd;
        this.streetEd2 = streetEd2;
        this.surNameEd2 = surNameEd2;
        this.tehsilEd = tehsilEd;
        this.tehsilEd2 = tehsilEd2;
        this.tehsilTv = tehsilTv;
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
        this.textView26 = textView26;
        this.textView33 = textView33;
        this.textView9 = textView9;
        this.updateTv = updateTv;
        this.upload = upload;
        this.uploadLayout = uploadLayout;
        this.uploadSpecifications = uploadSpecifications;
        this.viewSpinner1 = viewSpinner1;
        this.viewSpinner2 = viewSpinner2;
        this.viewSpinner3 = viewSpinner3;
        this.villageEd = villageEd;
        this.villageEd2 = villageEd2;
        this.villageTv = villageTv;
        this.yesRb = yesRb;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentChecklistEditForm7Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentChecklistEditForm7Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_checklist_edit_form7, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentChecklistEditForm7Binding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bottom_previous_save_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_previous_save_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.cancel_tv;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cancel_tv);
                if (textView != null) {
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
                                    i = R.id.constraintLayout2;
                                    ConstraintLayout constraintLayoutFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.constraintLayout2);
                                    if (constraintLayoutFindChildViewById4 != null) {
                                        i = R.id.death_certificate_reg;
                                        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.death_certificate_reg);
                                        if (radioGroup != null) {
                                            i = R.id.deletebtn;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deletebtn);
                                            if (imageView2 != null) {
                                                i = R.id.district_ed1;
                                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.district_ed1);
                                                if (editText != null) {
                                                    i = R.id.district_tv1;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_tv1);
                                                    if (textView2 != null) {
                                                        i = R.id.epic_ed;
                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.epic_ed);
                                                        if (editText2 != null) {
                                                            i = R.id.epic_ed2;
                                                            EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.epic_ed2);
                                                            if (editText3 != null) {
                                                                i = R.id.first_name_ed;
                                                                EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.first_name_ed);
                                                                if (editText4 != null) {
                                                                    i = R.id.form_type_tv;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_type_tv);
                                                                    if (textView3 != null) {
                                                                        i = R.id.house_ed;
                                                                        EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.house_ed);
                                                                        if (editText5 != null) {
                                                                            i = R.id.house_ed2;
                                                                            EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.house_ed2);
                                                                            if (editText6 != null) {
                                                                                i = R.id.mobNumRg;
                                                                                RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.mobNumRg);
                                                                                if (radioGroup2 != null) {
                                                                                    i = R.id.mob_num_tv;
                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mob_num_tv);
                                                                                    if (textView4 != null) {
                                                                                        i = R.id.mobile_num_ed;
                                                                                        EditText editText7 = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobile_num_ed);
                                                                                        if (editText7 != null) {
                                                                                            i = R.id.name_ed;
                                                                                            EditText editText8 = (EditText) ViewBindings.findChildViewById(rootView, R.id.name_ed);
                                                                                            if (editText8 != null) {
                                                                                                i = R.id.no_rb;
                                                                                                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.no_rb);
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
                                                                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.person_details_form_layout);
                                                                                                                if (linearLayout != null) {
                                                                                                                    i = R.id.personal_details_form_layout;
                                                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.personal_details_form_layout);
                                                                                                                    if (linearLayout2 != null) {
                                                                                                                        i = R.id.pincode_ed;
                                                                                                                        EditText editText9 = (EditText) ViewBindings.findChildViewById(rootView, R.id.pincode_ed);
                                                                                                                        if (editText9 != null) {
                                                                                                                            i = R.id.postoffice_ed;
                                                                                                                            EditText editText10 = (EditText) ViewBindings.findChildViewById(rootView, R.id.postoffice_ed);
                                                                                                                            if (editText10 != null) {
                                                                                                                                i = R.id.postoffice_ed2;
                                                                                                                                EditText editText11 = (EditText) ViewBindings.findChildViewById(rootView, R.id.postoffice_ed2);
                                                                                                                                if (editText11 != null) {
                                                                                                                                    i = R.id.postoffice_tv;
                                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.postoffice_tv);
                                                                                                                                    if (textView5 != null) {
                                                                                                                                        i = R.id.preview;
                                                                                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.preview);
                                                                                                                                        if (imageView3 != null) {
                                                                                                                                            i = R.id.ref_no_tv;
                                                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv);
                                                                                                                                            if (textView6 != null) {
                                                                                                                                                i = R.id.rejection_options_form_layout;
                                                                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rejection_options_form_layout);
                                                                                                                                                if (linearLayout3 != null) {
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
                                                                                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rejection_spinner_tv1);
                                                                                                                                                                                if (textView7 != null) {
                                                                                                                                                                                    i = R.id.rejection_spinner_tv2;
                                                                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rejection_spinner_tv2);
                                                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                                                        i = R.id.rejection_spinner_tv3;
                                                                                                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rejection_spinner_tv3);
                                                                                                                                                                                        if (textView9 != null) {
                                                                                                                                                                                            i = R.id.relative;
                                                                                                                                                                                            RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.relative);
                                                                                                                                                                                            if (radioButton5 != null) {
                                                                                                                                                                                                i = R.id.reset_tv;
                                                                                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.reset_tv);
                                                                                                                                                                                                if (textView10 != null) {
                                                                                                                                                                                                    i = R.id.select_name;
                                                                                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.select_name);
                                                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                                                        i = R.id.select_size;
                                                                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.select_size);
                                                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                                                            i = R.id.self;
                                                                                                                                                                                                            RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.self);
                                                                                                                                                                                                            if (radioButton6 != null) {
                                                                                                                                                                                                                i = R.id.state_ed1;
                                                                                                                                                                                                                EditText editText12 = (EditText) ViewBindings.findChildViewById(rootView, R.id.state_ed1);
                                                                                                                                                                                                                if (editText12 != null) {
                                                                                                                                                                                                                    i = R.id.state_tv1;
                                                                                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv1);
                                                                                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                                                                                        i = R.id.street_ed;
                                                                                                                                                                                                                        EditText editText13 = (EditText) ViewBindings.findChildViewById(rootView, R.id.street_ed);
                                                                                                                                                                                                                        if (editText13 != null) {
                                                                                                                                                                                                                            i = R.id.street_ed2;
                                                                                                                                                                                                                            EditText editText14 = (EditText) ViewBindings.findChildViewById(rootView, R.id.street_ed2);
                                                                                                                                                                                                                            if (editText14 != null) {
                                                                                                                                                                                                                                i = R.id.sur_name_ed2;
                                                                                                                                                                                                                                EditText editText15 = (EditText) ViewBindings.findChildViewById(rootView, R.id.sur_name_ed2);
                                                                                                                                                                                                                                if (editText15 != null) {
                                                                                                                                                                                                                                    i = R.id.tehsil_ed;
                                                                                                                                                                                                                                    EditText editText16 = (EditText) ViewBindings.findChildViewById(rootView, R.id.tehsil_ed);
                                                                                                                                                                                                                                    if (editText16 != null) {
                                                                                                                                                                                                                                        i = R.id.tehsil_ed2;
                                                                                                                                                                                                                                        EditText editText17 = (EditText) ViewBindings.findChildViewById(rootView, R.id.tehsil_ed2);
                                                                                                                                                                                                                                        if (editText17 != null) {
                                                                                                                                                                                                                                            i = R.id.tehsil_tv;
                                                                                                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tehsil_tv);
                                                                                                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                                                                                                i = R.id.textView12;
                                                                                                                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView12);
                                                                                                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                                                                                                    i = R.id.textView13;
                                                                                                                                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView13);
                                                                                                                                                                                                                                                    if (textView16 != null) {
                                                                                                                                                                                                                                                        i = R.id.textView15;
                                                                                                                                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView15);
                                                                                                                                                                                                                                                        if (textView17 != null) {
                                                                                                                                                                                                                                                            i = R.id.textView17;
                                                                                                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView17);
                                                                                                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                                                                                                i = R.id.textView18;
                                                                                                                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView18);
                                                                                                                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                                                                                                                    i = R.id.textView19;
                                                                                                                                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView19);
                                                                                                                                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                                                                                                                                        i = R.id.textView20;
                                                                                                                                                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView20);
                                                                                                                                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                                                                                                                                            i = R.id.textView21;
                                                                                                                                                                                                                                                                            TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView21);
                                                                                                                                                                                                                                                                            if (textView22 != null) {
                                                                                                                                                                                                                                                                                i = R.id.textView22;
                                                                                                                                                                                                                                                                                TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView22);
                                                                                                                                                                                                                                                                                if (textView23 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.textView25;
                                                                                                                                                                                                                                                                                    TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView25);
                                                                                                                                                                                                                                                                                    if (textView24 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.textView26;
                                                                                                                                                                                                                                                                                        TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView26);
                                                                                                                                                                                                                                                                                        if (textView25 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.textView33;
                                                                                                                                                                                                                                                                                            TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView33);
                                                                                                                                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.textView9;
                                                                                                                                                                                                                                                                                                TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView9);
                                                                                                                                                                                                                                                                                                if (textView27 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.update_tv;
                                                                                                                                                                                                                                                                                                    TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.update_tv);
                                                                                                                                                                                                                                                                                                    if (textView28 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.upload;
                                                                                                                                                                                                                                                                                                        TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload);
                                                                                                                                                                                                                                                                                                        if (textView29 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.upload_layout;
                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.upload_layout);
                                                                                                                                                                                                                                                                                                            if (linearLayout4 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.upload_specifications;
                                                                                                                                                                                                                                                                                                                TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_specifications);
                                                                                                                                                                                                                                                                                                                if (textView30 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.view_spinner1;
                                                                                                                                                                                                                                                                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_spinner1);
                                                                                                                                                                                                                                                                                                                    if (viewFindChildViewById != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.view_spinner2;
                                                                                                                                                                                                                                                                                                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view_spinner2);
                                                                                                                                                                                                                                                                                                                        if (viewFindChildViewById2 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.view_spinner3;
                                                                                                                                                                                                                                                                                                                            View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.view_spinner3);
                                                                                                                                                                                                                                                                                                                            if (viewFindChildViewById3 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.village_ed;
                                                                                                                                                                                                                                                                                                                                EditText editText18 = (EditText) ViewBindings.findChildViewById(rootView, R.id.village_ed);
                                                                                                                                                                                                                                                                                                                                if (editText18 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.village_ed2;
                                                                                                                                                                                                                                                                                                                                    EditText editText19 = (EditText) ViewBindings.findChildViewById(rootView, R.id.village_ed2);
                                                                                                                                                                                                                                                                                                                                    if (editText19 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.village_tv;
                                                                                                                                                                                                                                                                                                                                        TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.village_tv);
                                                                                                                                                                                                                                                                                                                                        if (textView31 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.yes_rb;
                                                                                                                                                                                                                                                                                                                                            RadioButton radioButton7 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.yes_rb);
                                                                                                                                                                                                                                                                                                                                            if (radioButton7 != null) {
                                                                                                                                                                                                                                                                                                                                                return new BloFragmentChecklistEditForm7Binding((ConstraintLayout) rootView, imageView, constraintLayoutFindChildViewById, textView, cardViewFindChildViewById, button, constraintLayoutFindChildViewById2, constraintLayoutFindChildViewById3, constraintLayoutFindChildViewById4, radioGroup, imageView2, editText, textView2, editText2, editText3, editText4, textView3, editText5, editText6, radioGroup2, textView4, editText7, editText8, radioButton, radioButton2, radioButton3, radioButton4, linearLayout, linearLayout2, editText9, editText10, editText11, textView5, imageView3, textView6, linearLayout3, radioGroup3, noDefaultSpinner, noDefaultSpinner2, noDefaultSpinner3, constraintLayoutFindChildViewById5, constraintLayoutFindChildViewById6, constraintLayoutFindChildViewById7, textView7, textView8, textView9, radioButton5, textView10, textView11, textView12, radioButton6, editText12, textView13, editText13, editText14, editText15, editText16, editText17, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, linearLayout4, textView30, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, editText18, editText19, textView31, radioButton7);
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
