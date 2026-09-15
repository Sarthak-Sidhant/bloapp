package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentPseChecklistPreviewBinding implements ViewBinding {
    public final TextView AcccessibilityTitle;
    public final ConstraintLayout AccessbilityLayout;
    public final LinearLayout COELayout;
    public final RadioButton COR;
    public final LinearLayout CorrectPhotoLayout;
    public final ConstraintLayout DeclarationMigrationLayout;
    public final TextView DeclareTitle;
    public final RadioButton IOR;
    public final LinearLayout PersonalLayout;
    public final RadioButton ROM;
    public final TextView Remark;
    public final TextView RemarkLabel;
    public final RadioButton SOR;
    public final TextView addressET;
    public final TextView ageET;
    public final TextView ageLabel;
    public final TextView assembly;
    public final TextView assemblyET;
    public final ImageView backBtnIv;
    public final CardView cardView;
    public final CheckBox cb8;
    public final TextView chooseCorrectPhotoName;
    public final TextView constNO;
    public final LinearLayout constiyuencygrp;
    public final TextView dateOfInclusionET;
    public final TextView decDateET;
    public final TextView decDateTv;
    public final ConstraintLayout detailsLayout;
    public final TextView district1Tv;
    public final TextView districtET;
    public final TextView epicNumberET;
    public final Button fillForm8btn;
    public final ConstraintLayout formDeclarationLayout;
    public final ConstraintLayout fragmentLocationEditLayout;
    public final TextView genderET;
    public final ImageView homeBtnIv;
    public final LinearLayout layout;
    public final ConstraintLayout layoutDepartment;
    public final ConstraintLayout linearLayout19;
    public final ConstraintLayout linearLayout23;
    public final TextView nameApplicantET;
    public final TextView nameOfEle;
    public final NestedScrollView nestedView;
    public final CardView previewHeader;
    public final ImageView previewPhoto;
    public final RadioGroup radiogroupSubmitApplication;
    public final TextView relationNameET;
    public final TextView relationTypeET;
    public final TextView responseFormatALabel;
    public final ImageView responseFormatAPhoto;
    public final TextView responseFormatAPhotoName;
    public final TextView responseFormatRemark;
    public final TextView responseFormatRemarkLabel;
    private final ConstraintLayout rootView;
    public final ConstraintLayout selectStateMigrationLayout;
    public final TextView serialNoET;
    public final TextView serialNoLabel;
    public final TextView state1Tv;
    public final TextView stateET;
    public final TextView submitApplicationchoices;
    public final TextView textView;
    public final TextView textView3;
    public final TextView textview22;

    private BloFragmentPseChecklistPreviewBinding(ConstraintLayout rootView, TextView AcccessibilityTitle, ConstraintLayout AccessbilityLayout, LinearLayout COELayout, RadioButton COR, LinearLayout CorrectPhotoLayout, ConstraintLayout DeclarationMigrationLayout, TextView DeclareTitle, RadioButton IOR, LinearLayout PersonalLayout, RadioButton ROM, TextView Remark, TextView RemarkLabel, RadioButton SOR, TextView addressET, TextView ageET, TextView ageLabel, TextView assembly, TextView assemblyET, ImageView backBtnIv, CardView cardView, CheckBox cb8, TextView chooseCorrectPhotoName, TextView constNO, LinearLayout constiyuencygrp, TextView dateOfInclusionET, TextView decDateET, TextView decDateTv, ConstraintLayout detailsLayout, TextView district1Tv, TextView districtET, TextView epicNumberET, Button fillForm8btn, ConstraintLayout formDeclarationLayout, ConstraintLayout fragmentLocationEditLayout, TextView genderET, ImageView homeBtnIv, LinearLayout layout, ConstraintLayout layoutDepartment, ConstraintLayout linearLayout19, ConstraintLayout linearLayout23, TextView nameApplicantET, TextView nameOfEle, NestedScrollView nestedView, CardView previewHeader, ImageView previewPhoto, RadioGroup radiogroupSubmitApplication, TextView relationNameET, TextView relationTypeET, TextView responseFormatALabel, ImageView responseFormatAPhoto, TextView responseFormatAPhotoName, TextView responseFormatRemark, TextView responseFormatRemarkLabel, ConstraintLayout selectStateMigrationLayout, TextView serialNoET, TextView serialNoLabel, TextView state1Tv, TextView stateET, TextView submitApplicationchoices, TextView textView, TextView textView3, TextView textview22) {
        this.rootView = rootView;
        this.AcccessibilityTitle = AcccessibilityTitle;
        this.AccessbilityLayout = AccessbilityLayout;
        this.COELayout = COELayout;
        this.COR = COR;
        this.CorrectPhotoLayout = CorrectPhotoLayout;
        this.DeclarationMigrationLayout = DeclarationMigrationLayout;
        this.DeclareTitle = DeclareTitle;
        this.IOR = IOR;
        this.PersonalLayout = PersonalLayout;
        this.ROM = ROM;
        this.Remark = Remark;
        this.RemarkLabel = RemarkLabel;
        this.SOR = SOR;
        this.addressET = addressET;
        this.ageET = ageET;
        this.ageLabel = ageLabel;
        this.assembly = assembly;
        this.assemblyET = assemblyET;
        this.backBtnIv = backBtnIv;
        this.cardView = cardView;
        this.cb8 = cb8;
        this.chooseCorrectPhotoName = chooseCorrectPhotoName;
        this.constNO = constNO;
        this.constiyuencygrp = constiyuencygrp;
        this.dateOfInclusionET = dateOfInclusionET;
        this.decDateET = decDateET;
        this.decDateTv = decDateTv;
        this.detailsLayout = detailsLayout;
        this.district1Tv = district1Tv;
        this.districtET = districtET;
        this.epicNumberET = epicNumberET;
        this.fillForm8btn = fillForm8btn;
        this.formDeclarationLayout = formDeclarationLayout;
        this.fragmentLocationEditLayout = fragmentLocationEditLayout;
        this.genderET = genderET;
        this.homeBtnIv = homeBtnIv;
        this.layout = layout;
        this.layoutDepartment = layoutDepartment;
        this.linearLayout19 = linearLayout19;
        this.linearLayout23 = linearLayout23;
        this.nameApplicantET = nameApplicantET;
        this.nameOfEle = nameOfEle;
        this.nestedView = nestedView;
        this.previewHeader = previewHeader;
        this.previewPhoto = previewPhoto;
        this.radiogroupSubmitApplication = radiogroupSubmitApplication;
        this.relationNameET = relationNameET;
        this.relationTypeET = relationTypeET;
        this.responseFormatALabel = responseFormatALabel;
        this.responseFormatAPhoto = responseFormatAPhoto;
        this.responseFormatAPhotoName = responseFormatAPhotoName;
        this.responseFormatRemark = responseFormatRemark;
        this.responseFormatRemarkLabel = responseFormatRemarkLabel;
        this.selectStateMigrationLayout = selectStateMigrationLayout;
        this.serialNoET = serialNoET;
        this.serialNoLabel = serialNoLabel;
        this.state1Tv = state1Tv;
        this.stateET = stateET;
        this.submitApplicationchoices = submitApplicationchoices;
        this.textView = textView;
        this.textView3 = textView3;
        this.textview22 = textview22;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentPseChecklistPreviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentPseChecklistPreviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_pse_checklist_preview, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentPseChecklistPreviewBinding bind(View rootView) {
        int i = R.id.AcccessibilityTitle;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.AcccessibilityTitle);
        if (textView != null) {
            i = R.id.Accessbility_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.Accessbility_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.COE_layout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.COE_layout);
                if (linearLayout != null) {
                    i = R.id.COR;
                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.COR);
                    if (radioButton != null) {
                        i = R.id.Correct_Photo_layout;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.Correct_Photo_layout);
                        if (linearLayout2 != null) {
                            i = R.id.Declaration_migration_layout;
                            ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.Declaration_migration_layout);
                            if (constraintLayoutFindChildViewById2 != null) {
                                i = R.id.DeclareTitle;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.DeclareTitle);
                                if (textView2 != null) {
                                    i = R.id.IOR;
                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.IOR);
                                    if (radioButton2 != null) {
                                        i = R.id.Personal_layout;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.Personal_layout);
                                        if (linearLayout3 != null) {
                                            i = R.id.ROM;
                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.ROM);
                                            if (radioButton3 != null) {
                                                i = R.id.Remark;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Remark);
                                                if (textView3 != null) {
                                                    i = R.id.Remark_label;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Remark_label);
                                                    if (textView4 != null) {
                                                        i = R.id.SOR;
                                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.SOR);
                                                        if (radioButton4 != null) {
                                                            i = R.id.address_ET;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_ET);
                                                            if (textView5 != null) {
                                                                i = R.id.age_ET;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.age_ET);
                                                                if (textView6 != null) {
                                                                    i = R.id.age_label;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.age_label);
                                                                    if (textView7 != null) {
                                                                        i = R.id.assembly;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.assembly);
                                                                        if (textView8 != null) {
                                                                            i = R.id.assembly_ET;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.assembly_ET);
                                                                            if (textView9 != null) {
                                                                                i = R.id.back_btn_iv;
                                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                                                                                if (imageView != null) {
                                                                                    i = R.id.cardView;
                                                                                    CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView);
                                                                                    if (cardViewFindChildViewById != null) {
                                                                                        i = R.id.cb8;
                                                                                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.cb8);
                                                                                        if (checkBox != null) {
                                                                                            i = R.id.choose_correct_photo_name;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_correct_photo_name);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.constNO;
                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.constNO);
                                                                                                if (textView11 != null) {
                                                                                                    i = R.id.constiyuencygrp;
                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.constiyuencygrp);
                                                                                                    if (linearLayout4 != null) {
                                                                                                        i = R.id.date_of_Inclusion_ET;
                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_of_Inclusion_ET);
                                                                                                        if (textView12 != null) {
                                                                                                            i = R.id.dec_date_ET;
                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dec_date_ET);
                                                                                                            if (textView13 != null) {
                                                                                                                i = R.id.dec_date_tv;
                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dec_date_tv);
                                                                                                                if (textView14 != null) {
                                                                                                                    i = R.id.details_layout;
                                                                                                                    ConstraintLayout constraintLayoutFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.details_layout);
                                                                                                                    if (constraintLayoutFindChildViewById3 != null) {
                                                                                                                        i = R.id.district1_tv;
                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district1_tv);
                                                                                                                        if (textView15 != null) {
                                                                                                                            i = R.id.district_ET;
                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_ET);
                                                                                                                            if (textView16 != null) {
                                                                                                                                i = R.id.epic_number_ET;
                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_number_ET);
                                                                                                                                if (textView17 != null) {
                                                                                                                                    i = R.id.fill_form_8btn;
                                                                                                                                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.fill_form_8btn);
                                                                                                                                    if (button != null) {
                                                                                                                                        i = R.id.form_declaration_layout;
                                                                                                                                        ConstraintLayout constraintLayoutFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.form_declaration_layout);
                                                                                                                                        if (constraintLayoutFindChildViewById4 != null) {
                                                                                                                                            i = R.id.fragment_location_edit_layout;
                                                                                                                                            ConstraintLayout constraintLayoutFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.fragment_location_edit_layout);
                                                                                                                                            if (constraintLayoutFindChildViewById5 != null) {
                                                                                                                                                i = R.id.gender_ET;
                                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender_ET);
                                                                                                                                                if (textView18 != null) {
                                                                                                                                                    i = R.id.home_btn_iv;
                                                                                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                                                                                                                                                    if (imageView2 != null) {
                                                                                                                                                        i = 2131364428;
                                                                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, 2131364428);
                                                                                                                                                        if (linearLayout5 != null) {
                                                                                                                                                            i = R.id.layoutDepartment;
                                                                                                                                                            ConstraintLayout constraintLayoutFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.layoutDepartment);
                                                                                                                                                            if (constraintLayoutFindChildViewById6 != null) {
                                                                                                                                                                i = R.id.linearLayout19;
                                                                                                                                                                ConstraintLayout constraintLayoutFindChildViewById7 = ViewBindings.findChildViewById(rootView, R.id.linearLayout19);
                                                                                                                                                                if (constraintLayoutFindChildViewById7 != null) {
                                                                                                                                                                    i = R.id.linearLayout23;
                                                                                                                                                                    ConstraintLayout constraintLayoutFindChildViewById8 = ViewBindings.findChildViewById(rootView, R.id.linearLayout23);
                                                                                                                                                                    if (constraintLayoutFindChildViewById8 != null) {
                                                                                                                                                                        i = R.id.name_applicant_ET;
                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_applicant_ET);
                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                            i = R.id.name_of_ele;
                                                                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_of_ele);
                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                i = R.id.nestedView;
                                                                                                                                                                                NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.nestedView);
                                                                                                                                                                                if (nestedScrollViewFindChildViewById != null) {
                                                                                                                                                                                    i = R.id.preview_header;
                                                                                                                                                                                    CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.preview_header);
                                                                                                                                                                                    if (cardViewFindChildViewById2 != null) {
                                                                                                                                                                                        i = R.id.preview_photo;
                                                                                                                                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.preview_photo);
                                                                                                                                                                                        if (imageView3 != null) {
                                                                                                                                                                                            i = R.id.radiogroup_submit_application;
                                                                                                                                                                                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.radiogroup_submit_application);
                                                                                                                                                                                            if (radioGroup != null) {
                                                                                                                                                                                                i = R.id.relation_Name_ET;
                                                                                                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relation_Name_ET);
                                                                                                                                                                                                if (textView21 != null) {
                                                                                                                                                                                                    i = R.id.relation_Type_ET;
                                                                                                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relation_Type_ET);
                                                                                                                                                                                                    if (textView22 != null) {
                                                                                                                                                                                                        i = R.id.response_Format_A_label;
                                                                                                                                                                                                        TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.response_Format_A_label);
                                                                                                                                                                                                        if (textView23 != null) {
                                                                                                                                                                                                            i = R.id.response_Format_A_Photo;
                                                                                                                                                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.response_Format_A_Photo);
                                                                                                                                                                                                            if (imageView4 != null) {
                                                                                                                                                                                                                i = R.id.response_Format_A_Photo_Name;
                                                                                                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.response_Format_A_Photo_Name);
                                                                                                                                                                                                                if (textView24 != null) {
                                                                                                                                                                                                                    i = R.id.response_Format_Remark;
                                                                                                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.response_Format_Remark);
                                                                                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                                                                                        i = R.id.response_Format_Remark_label;
                                                                                                                                                                                                                        TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.response_Format_Remark_label);
                                                                                                                                                                                                                        if (textView26 != null) {
                                                                                                                                                                                                                            i = R.id.select_state_migration_layout;
                                                                                                                                                                                                                            ConstraintLayout constraintLayoutFindChildViewById9 = ViewBindings.findChildViewById(rootView, R.id.select_state_migration_layout);
                                                                                                                                                                                                                            if (constraintLayoutFindChildViewById9 != null) {
                                                                                                                                                                                                                                i = R.id.serial_no_ET;
                                                                                                                                                                                                                                TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serial_no_ET);
                                                                                                                                                                                                                                if (textView27 != null) {
                                                                                                                                                                                                                                    i = R.id.serial_no_label;
                                                                                                                                                                                                                                    TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serial_no_label);
                                                                                                                                                                                                                                    if (textView28 != null) {
                                                                                                                                                                                                                                        i = R.id.state1_tv;
                                                                                                                                                                                                                                        TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state1_tv);
                                                                                                                                                                                                                                        if (textView29 != null) {
                                                                                                                                                                                                                                            i = R.id.state_ET;
                                                                                                                                                                                                                                            TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_ET);
                                                                                                                                                                                                                                            if (textView30 != null) {
                                                                                                                                                                                                                                                i = R.id.submitApplicationchoices;
                                                                                                                                                                                                                                                TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submitApplicationchoices);
                                                                                                                                                                                                                                                if (textView31 != null) {
                                                                                                                                                                                                                                                    i = R.id.text_view;
                                                                                                                                                                                                                                                    TextView textView32 = (TextView) ViewBindings.findChildViewById(rootView, R.id.text_view);
                                                                                                                                                                                                                                                    if (textView32 != null) {
                                                                                                                                                                                                                                                        i = R.id.textView3;
                                                                                                                                                                                                                                                        TextView textView33 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                                                                                                                                        if (textView33 != null) {
                                                                                                                                                                                                                                                            i = R.id.textview22;
                                                                                                                                                                                                                                                            TextView textView34 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textview22);
                                                                                                                                                                                                                                                            if (textView34 != null) {
                                                                                                                                                                                                                                                                return new BloFragmentPseChecklistPreviewBinding((ConstraintLayout) rootView, textView, constraintLayoutFindChildViewById, linearLayout, radioButton, linearLayout2, constraintLayoutFindChildViewById2, textView2, radioButton2, linearLayout3, radioButton3, textView3, textView4, radioButton4, textView5, textView6, textView7, textView8, textView9, imageView, cardViewFindChildViewById, checkBox, textView10, textView11, linearLayout4, textView12, textView13, textView14, constraintLayoutFindChildViewById3, textView15, textView16, textView17, button, constraintLayoutFindChildViewById4, constraintLayoutFindChildViewById5, textView18, imageView2, linearLayout5, constraintLayoutFindChildViewById6, constraintLayoutFindChildViewById7, constraintLayoutFindChildViewById8, textView19, textView20, nestedScrollViewFindChildViewById, cardViewFindChildViewById2, imageView3, radioGroup, textView21, textView22, textView23, imageView4, textView24, textView25, textView26, constraintLayoutFindChildViewById9, textView27, textView28, textView29, textView30, textView31, textView32, textView33, textView34);
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
