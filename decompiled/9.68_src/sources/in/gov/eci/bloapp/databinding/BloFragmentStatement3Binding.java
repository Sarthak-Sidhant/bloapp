package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentStatement3Binding implements ViewBinding {
    public final TextView Previewtv;
    public final EditText aadharEd;
    public final LinearLayout aadharlayout;
    public final TextView assembly;
    public final EditText assemblyEd;
    public final ImageView back;
    public final CardView cardView;
    public final RadioGroup catRg;
    public final LinearLayout categor;
    public final TextView categoryTv;
    public final ConstraintLayout constraintLayout;
    public final CheckBox deaf;
    public final TextView districtTv;
    public final TextView districtTv1;
    public final EditText dobEd;
    public final EditText eligiblelector;
    public final EditText emailEd;
    public final LinearLayout familyspinner;
    public final EditText firstNameEd;
    public final TextView firstNameHead;
    public final TextInputLayout firstNameText;
    public final TextView firstNameTv3;
    public final TextView firstNameTv56;
    public final AutoCompleteTextView firstnameOfficial;
    public final LinearLayout fragmentLocationEditLayout;
    public final ConstraintLayout fragmentLocationEditLayout1;
    public final LinearLayout fragmentSec;
    public final ConstraintLayout genderLayout;
    public final NoDefaultSpinner genderPersonalSpinner;
    public final ImageView home;
    public final EditText houseno;
    public final ConstraintLayout layoutDepartment;
    public final ConstraintLayout layoutDepartment1;
    public final CheckBox loco;
    public final TextView mainheadingTv;
    public final EditText mobileNumEd;
    public final TextView namePhotographTv;
    public final NestedScrollView nested;
    public final RadioButton no;
    public final CheckBox other;
    public final EditText otherEdDetails;
    public final LinearLayout otherlayou;
    public final LinearLayout otherlayout;
    public final LinearLayout otherlayout1;
    public final LinearLayout otherlayout2;
    public final EditText percentageEd;
    public final NoDefaultSpinner relationSpinner;
    public final ConstraintLayout relationTypeLayout;
    public final EditText relativeName;
    public final AutoCompleteTextView relativeNameOfficial;
    public final EditText relativeSurname;
    public final AutoCompleteTextView relativeSurnameOfficial;
    public final TextInputLayout relativenameText;
    public final TextView resetTv;
    public final EditText residenceEd;
    private final ConstraintLayout rootView;
    public final NoDefaultSpinner sectionNo;
    public final LinearLayout selectState;
    public final EditText sno;
    public final EditText stateSpinner;
    public final TextView stateTv;
    public final TextView stateTv1;
    public final EditText surNameEd;
    public final TextView surnameNameHead;
    public final AutoCompleteTextView surnameOfficial;
    public final View viewGenderSpinner;
    public final View viewRelationSpinner;
    public final View viewStateOutsideSpinner1;
    public final CheckBox visual;
    public final RadioButton yes;

    private BloFragmentStatement3Binding(ConstraintLayout rootView, TextView Previewtv, EditText aadharEd, LinearLayout aadharlayout, TextView assembly, EditText assemblyEd, ImageView back, CardView cardView, RadioGroup catRg, LinearLayout categor, TextView categoryTv, ConstraintLayout constraintLayout, CheckBox deaf, TextView districtTv, TextView districtTv1, EditText dobEd, EditText eligiblelector, EditText emailEd, LinearLayout familyspinner, EditText firstNameEd, TextView firstNameHead, TextInputLayout firstNameText, TextView firstNameTv3, TextView firstNameTv56, AutoCompleteTextView firstnameOfficial, LinearLayout fragmentLocationEditLayout, ConstraintLayout fragmentLocationEditLayout1, LinearLayout fragmentSec, ConstraintLayout genderLayout, NoDefaultSpinner genderPersonalSpinner, ImageView home, EditText houseno, ConstraintLayout layoutDepartment, ConstraintLayout layoutDepartment1, CheckBox loco, TextView mainheadingTv, EditText mobileNumEd, TextView namePhotographTv, NestedScrollView nested, RadioButton no, CheckBox other, EditText otherEdDetails, LinearLayout otherlayou, LinearLayout otherlayout, LinearLayout otherlayout1, LinearLayout otherlayout2, EditText percentageEd, NoDefaultSpinner relationSpinner, ConstraintLayout relationTypeLayout, EditText relativeName, AutoCompleteTextView relativeNameOfficial, EditText relativeSurname, AutoCompleteTextView relativeSurnameOfficial, TextInputLayout relativenameText, TextView resetTv, EditText residenceEd, NoDefaultSpinner sectionNo, LinearLayout selectState, EditText sno, EditText stateSpinner, TextView stateTv, TextView stateTv1, EditText surNameEd, TextView surnameNameHead, AutoCompleteTextView surnameOfficial, View viewGenderSpinner, View viewRelationSpinner, View viewStateOutsideSpinner1, CheckBox visual, RadioButton yes) {
        this.rootView = rootView;
        this.Previewtv = Previewtv;
        this.aadharEd = aadharEd;
        this.aadharlayout = aadharlayout;
        this.assembly = assembly;
        this.assemblyEd = assemblyEd;
        this.back = back;
        this.cardView = cardView;
        this.catRg = catRg;
        this.categor = categor;
        this.categoryTv = categoryTv;
        this.constraintLayout = constraintLayout;
        this.deaf = deaf;
        this.districtTv = districtTv;
        this.districtTv1 = districtTv1;
        this.dobEd = dobEd;
        this.eligiblelector = eligiblelector;
        this.emailEd = emailEd;
        this.familyspinner = familyspinner;
        this.firstNameEd = firstNameEd;
        this.firstNameHead = firstNameHead;
        this.firstNameText = firstNameText;
        this.firstNameTv3 = firstNameTv3;
        this.firstNameTv56 = firstNameTv56;
        this.firstnameOfficial = firstnameOfficial;
        this.fragmentLocationEditLayout = fragmentLocationEditLayout;
        this.fragmentLocationEditLayout1 = fragmentLocationEditLayout1;
        this.fragmentSec = fragmentSec;
        this.genderLayout = genderLayout;
        this.genderPersonalSpinner = genderPersonalSpinner;
        this.home = home;
        this.houseno = houseno;
        this.layoutDepartment = layoutDepartment;
        this.layoutDepartment1 = layoutDepartment1;
        this.loco = loco;
        this.mainheadingTv = mainheadingTv;
        this.mobileNumEd = mobileNumEd;
        this.namePhotographTv = namePhotographTv;
        this.nested = nested;
        this.no = no;
        this.other = other;
        this.otherEdDetails = otherEdDetails;
        this.otherlayou = otherlayou;
        this.otherlayout = otherlayout;
        this.otherlayout1 = otherlayout1;
        this.otherlayout2 = otherlayout2;
        this.percentageEd = percentageEd;
        this.relationSpinner = relationSpinner;
        this.relationTypeLayout = relationTypeLayout;
        this.relativeName = relativeName;
        this.relativeNameOfficial = relativeNameOfficial;
        this.relativeSurname = relativeSurname;
        this.relativeSurnameOfficial = relativeSurnameOfficial;
        this.relativenameText = relativenameText;
        this.resetTv = resetTv;
        this.residenceEd = residenceEd;
        this.sectionNo = sectionNo;
        this.selectState = selectState;
        this.sno = sno;
        this.stateSpinner = stateSpinner;
        this.stateTv = stateTv;
        this.stateTv1 = stateTv1;
        this.surNameEd = surNameEd;
        this.surnameNameHead = surnameNameHead;
        this.surnameOfficial = surnameOfficial;
        this.viewGenderSpinner = viewGenderSpinner;
        this.viewRelationSpinner = viewRelationSpinner;
        this.viewStateOutsideSpinner1 = viewStateOutsideSpinner1;
        this.visual = visual;
        this.yes = yes;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentStatement3Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentStatement3Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_statement3, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentStatement3Binding bind(View rootView) {
        int i = R.id.Previewtv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.Previewtv);
        if (textView != null) {
            i = R.id.aadhar_ed;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.aadhar_ed);
            if (editText != null) {
                i = R.id.aadharlayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.aadharlayout);
                if (linearLayout != null) {
                    i = R.id.assembly;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.assembly);
                    if (textView2 != null) {
                        i = R.id.assembly_ed;
                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.assembly_ed);
                        if (editText2 != null) {
                            i = 2131362484;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, 2131362484);
                            if (imageView != null) {
                                i = R.id.cardView;
                                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView);
                                if (cardViewFindChildViewById != null) {
                                    i = R.id.cat_rg;
                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.cat_rg);
                                    if (radioGroup != null) {
                                        i = R.id.categor;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.categor);
                                        if (linearLayout2 != null) {
                                            i = R.id.category_tv;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.category_tv);
                                            if (textView3 != null) {
                                                i = R.id.constraintLayout;
                                                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
                                                if (constraintLayoutFindChildViewById != null) {
                                                    i = R.id.deaf;
                                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.deaf);
                                                    if (checkBox != null) {
                                                        i = R.id.district_tv;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_tv);
                                                        if (textView4 != null) {
                                                            i = R.id.district_tv1;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_tv1);
                                                            if (textView5 != null) {
                                                                i = R.id.dob_ed;
                                                                EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.dob_ed);
                                                                if (editText3 != null) {
                                                                    i = R.id.eligiblelector;
                                                                    EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.eligiblelector);
                                                                    if (editText4 != null) {
                                                                        i = R.id.email_ed;
                                                                        EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.email_ed);
                                                                        if (editText5 != null) {
                                                                            i = R.id.familyspinner;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.familyspinner);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.first_name_ed;
                                                                                EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.first_name_ed);
                                                                                if (editText6 != null) {
                                                                                    i = R.id.first_name_head;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_head);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.firstNameText;
                                                                                        TextInputLayout textInputLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.firstNameText);
                                                                                        if (textInputLayoutFindChildViewById != null) {
                                                                                            i = R.id.first_name_tv3;
                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_tv3);
                                                                                            if (textView7 != null) {
                                                                                                i = R.id.first_name_tv56;
                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_tv56);
                                                                                                if (textView8 != null) {
                                                                                                    i = R.id.firstname_official;
                                                                                                    AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.firstname_official);
                                                                                                    if (autoCompleteTextView != null) {
                                                                                                        i = R.id.fragment_location_edit_layout;
                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fragment_location_edit_layout);
                                                                                                        if (linearLayout4 != null) {
                                                                                                            i = R.id.fragment_location_edit_layout1;
                                                                                                            ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.fragment_location_edit_layout1);
                                                                                                            if (constraintLayoutFindChildViewById2 != null) {
                                                                                                                i = R.id.fragment_sec;
                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fragment_sec);
                                                                                                                if (linearLayout5 != null) {
                                                                                                                    i = R.id.gender_layout;
                                                                                                                    ConstraintLayout constraintLayoutFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.gender_layout);
                                                                                                                    if (constraintLayoutFindChildViewById3 != null) {
                                                                                                                        i = R.id.gender_personal_spinner;
                                                                                                                        NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.gender_personal_spinner);
                                                                                                                        if (noDefaultSpinner != null) {
                                                                                                                            i = 2131364192;
                                                                                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, 2131364192);
                                                                                                                            if (imageView2 != null) {
                                                                                                                                i = R.id.houseno;
                                                                                                                                EditText editText7 = (EditText) ViewBindings.findChildViewById(rootView, R.id.houseno);
                                                                                                                                if (editText7 != null) {
                                                                                                                                    i = R.id.layoutDepartment;
                                                                                                                                    ConstraintLayout constraintLayoutFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.layoutDepartment);
                                                                                                                                    if (constraintLayoutFindChildViewById4 != null) {
                                                                                                                                        i = R.id.layoutDepartment1;
                                                                                                                                        ConstraintLayout constraintLayoutFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.layoutDepartment1);
                                                                                                                                        if (constraintLayoutFindChildViewById5 != null) {
                                                                                                                                            i = R.id.loco;
                                                                                                                                            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.loco);
                                                                                                                                            if (checkBox2 != null) {
                                                                                                                                                i = R.id.mainheading_tv;
                                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mainheading_tv);
                                                                                                                                                if (textView9 != null) {
                                                                                                                                                    i = R.id.mobile_num_ed;
                                                                                                                                                    EditText editText8 = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobile_num_ed);
                                                                                                                                                    if (editText8 != null) {
                                                                                                                                                        i = R.id.name_photograph_tv;
                                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_photograph_tv);
                                                                                                                                                        if (textView10 != null) {
                                                                                                                                                            i = R.id.nested;
                                                                                                                                                            NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.nested);
                                                                                                                                                            if (nestedScrollViewFindChildViewById != null) {
                                                                                                                                                                i = R.id.no;
                                                                                                                                                                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.no);
                                                                                                                                                                if (radioButton != null) {
                                                                                                                                                                    i = R.id.other;
                                                                                                                                                                    CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.other);
                                                                                                                                                                    if (checkBox3 != null) {
                                                                                                                                                                        i = R.id.other_ed_details;
                                                                                                                                                                        EditText editText9 = (EditText) ViewBindings.findChildViewById(rootView, R.id.other_ed_details);
                                                                                                                                                                        if (editText9 != null) {
                                                                                                                                                                            i = R.id.otherlayou;
                                                                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.otherlayou);
                                                                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                                                                i = R.id.otherlayout;
                                                                                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.otherlayout);
                                                                                                                                                                                if (linearLayout7 != null) {
                                                                                                                                                                                    i = R.id.otherlayout1;
                                                                                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.otherlayout1);
                                                                                                                                                                                    if (linearLayout8 != null) {
                                                                                                                                                                                        i = R.id.otherlayout2;
                                                                                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.otherlayout2);
                                                                                                                                                                                        if (linearLayout9 != null) {
                                                                                                                                                                                            i = R.id.percentage_ed;
                                                                                                                                                                                            EditText editText10 = (EditText) ViewBindings.findChildViewById(rootView, R.id.percentage_ed);
                                                                                                                                                                                            if (editText10 != null) {
                                                                                                                                                                                                i = R.id.relation_spinner;
                                                                                                                                                                                                NoDefaultSpinner noDefaultSpinner2 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.relation_spinner);
                                                                                                                                                                                                if (noDefaultSpinner2 != null) {
                                                                                                                                                                                                    i = R.id.relation_type_layout;
                                                                                                                                                                                                    ConstraintLayout constraintLayoutFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.relation_type_layout);
                                                                                                                                                                                                    if (constraintLayoutFindChildViewById6 != null) {
                                                                                                                                                                                                        i = R.id.relative_name;
                                                                                                                                                                                                        EditText editText11 = (EditText) ViewBindings.findChildViewById(rootView, R.id.relative_name);
                                                                                                                                                                                                        if (editText11 != null) {
                                                                                                                                                                                                            i = R.id.relative_name_official;
                                                                                                                                                                                                            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.relative_name_official);
                                                                                                                                                                                                            if (autoCompleteTextView2 != null) {
                                                                                                                                                                                                                i = R.id.relative_surname;
                                                                                                                                                                                                                EditText editText12 = (EditText) ViewBindings.findChildViewById(rootView, R.id.relative_surname);
                                                                                                                                                                                                                if (editText12 != null) {
                                                                                                                                                                                                                    i = R.id.relative_surname_official;
                                                                                                                                                                                                                    AutoCompleteTextView autoCompleteTextView3 = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.relative_surname_official);
                                                                                                                                                                                                                    if (autoCompleteTextView3 != null) {
                                                                                                                                                                                                                        i = R.id.relativenameText;
                                                                                                                                                                                                                        TextInputLayout textInputLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.relativenameText);
                                                                                                                                                                                                                        if (textInputLayoutFindChildViewById2 != null) {
                                                                                                                                                                                                                            i = R.id.reset_tv;
                                                                                                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.reset_tv);
                                                                                                                                                                                                                            if (textView11 != null) {
                                                                                                                                                                                                                                i = R.id.residence_ed;
                                                                                                                                                                                                                                EditText editText13 = (EditText) ViewBindings.findChildViewById(rootView, R.id.residence_ed);
                                                                                                                                                                                                                                if (editText13 != null) {
                                                                                                                                                                                                                                    i = R.id.sectionNo;
                                                                                                                                                                                                                                    NoDefaultSpinner noDefaultSpinner3 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.sectionNo);
                                                                                                                                                                                                                                    if (noDefaultSpinner3 != null) {
                                                                                                                                                                                                                                        i = R.id.select_state;
                                                                                                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.select_state);
                                                                                                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                                                                                                            i = R.id.sno;
                                                                                                                                                                                                                                            EditText editText14 = (EditText) ViewBindings.findChildViewById(rootView, R.id.sno);
                                                                                                                                                                                                                                            if (editText14 != null) {
                                                                                                                                                                                                                                                i = R.id.state_spinner;
                                                                                                                                                                                                                                                EditText editText15 = (EditText) ViewBindings.findChildViewById(rootView, R.id.state_spinner);
                                                                                                                                                                                                                                                if (editText15 != null) {
                                                                                                                                                                                                                                                    i = R.id.state_tv;
                                                                                                                                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv);
                                                                                                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                                                                                                        i = R.id.state_tv1;
                                                                                                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv1);
                                                                                                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                                                                                                            i = R.id.sur_name_ed;
                                                                                                                                                                                                                                                            EditText editText16 = (EditText) ViewBindings.findChildViewById(rootView, R.id.sur_name_ed);
                                                                                                                                                                                                                                                            if (editText16 != null) {
                                                                                                                                                                                                                                                                i = R.id.surname_name_head;
                                                                                                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.surname_name_head);
                                                                                                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                                                                                                    i = R.id.surname_official;
                                                                                                                                                                                                                                                                    AutoCompleteTextView autoCompleteTextView4 = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.surname_official);
                                                                                                                                                                                                                                                                    if (autoCompleteTextView4 != null) {
                                                                                                                                                                                                                                                                        i = R.id.view_gender_spinner;
                                                                                                                                                                                                                                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_gender_spinner);
                                                                                                                                                                                                                                                                        if (viewFindChildViewById != null) {
                                                                                                                                                                                                                                                                            i = R.id.view_relation_spinner;
                                                                                                                                                                                                                                                                            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view_relation_spinner);
                                                                                                                                                                                                                                                                            if (viewFindChildViewById2 != null) {
                                                                                                                                                                                                                                                                                i = R.id.view_state_outside_spinner1;
                                                                                                                                                                                                                                                                                View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.view_state_outside_spinner1);
                                                                                                                                                                                                                                                                                if (viewFindChildViewById3 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.visual;
                                                                                                                                                                                                                                                                                    CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.visual);
                                                                                                                                                                                                                                                                                    if (checkBox4 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.yes;
                                                                                                                                                                                                                                                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.yes);
                                                                                                                                                                                                                                                                                        if (radioButton2 != null) {
                                                                                                                                                                                                                                                                                            return new BloFragmentStatement3Binding((ConstraintLayout) rootView, textView, editText, linearLayout, textView2, editText2, imageView, cardViewFindChildViewById, radioGroup, linearLayout2, textView3, constraintLayoutFindChildViewById, checkBox, textView4, textView5, editText3, editText4, editText5, linearLayout3, editText6, textView6, textInputLayoutFindChildViewById, textView7, textView8, autoCompleteTextView, linearLayout4, constraintLayoutFindChildViewById2, linearLayout5, constraintLayoutFindChildViewById3, noDefaultSpinner, imageView2, editText7, constraintLayoutFindChildViewById4, constraintLayoutFindChildViewById5, checkBox2, textView9, editText8, textView10, nestedScrollViewFindChildViewById, radioButton, checkBox3, editText9, linearLayout6, linearLayout7, linearLayout8, linearLayout9, editText10, noDefaultSpinner2, constraintLayoutFindChildViewById6, editText11, autoCompleteTextView2, editText12, autoCompleteTextView3, textInputLayoutFindChildViewById2, textView11, editText13, noDefaultSpinner3, linearLayout10, editText14, editText15, textView12, textView13, editText16, textView14, autoCompleteTextView4, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, checkBox4, radioButton2);
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
