package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentPreviewBinding implements ViewBinding {
    public final TextView aadharEd;
    public final LinearLayout aadharlayout;
    public final TextView assembly;
    public final ImageView backBtnIv;
    public final CardView cardView;
    public final RadioGroup catRg;
    public final TextView categoryTv;
    public final ConstraintLayout constraintLayout;
    public final CheckBox deaf;
    public final TextView districtTv;
    public final TextView districtTv1;
    public final TextView dobEd;
    public final TextView eleigibleElector;
    public final TextView emailEd;
    public final TextView firstNameEd;
    public final TextView firstNameHead;
    public final TextView firstNameTv3;
    public final TextView firstNameTv56;
    public final TextView firstNamehEd;
    public final LinearLayout fragmentLocationEditLayout;
    public final ConstraintLayout fragmentLocationEditLayout1;
    public final LinearLayout fragmentSec;
    public final ConstraintLayout genderLayout;
    public final NoDefaultSpinner genderPersonalSpinner;
    public final TextView houseno;
    public final TextView keepeditingtv;
    public final ConstraintLayout layoutDepartment;
    public final ConstraintLayout layoutDepartment1;
    public final CheckBox loco;
    public final TextView mainheadingTv;
    public final TextView mobileEd;
    public final TextView namePhotographTv;
    public final NestedScrollView nested;
    public final RadioButton no;
    public final CheckBox other;
    public final TextView otherEdDetails;
    public final LinearLayout otherlayou;
    public final LinearLayout otherlayout;
    public final LinearLayout otherlayout1;
    public final LinearLayout otherlayout2;
    public final TextView partNumber;
    public final TextView percentageEd;
    public final TextView relationSpinner;
    public final ConstraintLayout relationTypeLayout;
    public final TextView relativeName;
    public final TextView relativeNameOfficial;
    public final TextView relativeSurname;
    public final TextView relativeSurnameOfficial;
    public final TextView residenceEd;
    private final ConstraintLayout rootView;
    public final TextView sectionEd;
    public final LinearLayout selectState;
    public final TextView sno;
    public final TextView stateSpinner;
    public final TextView stateTv;
    public final TextView stateTv1;
    public final TextView submittv;
    public final TextView surNameEd;
    public final TextView surNametv;
    public final TextView surnameNameHead;
    public final View viewGenderSpinner;
    public final View viewRelationSpinner;
    public final CheckBox visual;
    public final RadioButton yes;

    private BloFragmentPreviewBinding(ConstraintLayout rootView, TextView aadharEd, LinearLayout aadharlayout, TextView assembly, ImageView backBtnIv, CardView cardView, RadioGroup catRg, TextView categoryTv, ConstraintLayout constraintLayout, CheckBox deaf, TextView districtTv, TextView districtTv1, TextView dobEd, TextView eleigibleElector, TextView emailEd, TextView firstNameEd, TextView firstNameHead, TextView firstNameTv3, TextView firstNameTv56, TextView firstNamehEd, LinearLayout fragmentLocationEditLayout, ConstraintLayout fragmentLocationEditLayout1, LinearLayout fragmentSec, ConstraintLayout genderLayout, NoDefaultSpinner genderPersonalSpinner, TextView houseno, TextView keepeditingtv, ConstraintLayout layoutDepartment, ConstraintLayout layoutDepartment1, CheckBox loco, TextView mainheadingTv, TextView mobileEd, TextView namePhotographTv, NestedScrollView nested, RadioButton no, CheckBox other, TextView otherEdDetails, LinearLayout otherlayou, LinearLayout otherlayout, LinearLayout otherlayout1, LinearLayout otherlayout2, TextView partNumber, TextView percentageEd, TextView relationSpinner, ConstraintLayout relationTypeLayout, TextView relativeName, TextView relativeNameOfficial, TextView relativeSurname, TextView relativeSurnameOfficial, TextView residenceEd, TextView sectionEd, LinearLayout selectState, TextView sno, TextView stateSpinner, TextView stateTv, TextView stateTv1, TextView submittv, TextView surNameEd, TextView surNametv, TextView surnameNameHead, View viewGenderSpinner, View viewRelationSpinner, CheckBox visual, RadioButton yes) {
        this.rootView = rootView;
        this.aadharEd = aadharEd;
        this.aadharlayout = aadharlayout;
        this.assembly = assembly;
        this.backBtnIv = backBtnIv;
        this.cardView = cardView;
        this.catRg = catRg;
        this.categoryTv = categoryTv;
        this.constraintLayout = constraintLayout;
        this.deaf = deaf;
        this.districtTv = districtTv;
        this.districtTv1 = districtTv1;
        this.dobEd = dobEd;
        this.eleigibleElector = eleigibleElector;
        this.emailEd = emailEd;
        this.firstNameEd = firstNameEd;
        this.firstNameHead = firstNameHead;
        this.firstNameTv3 = firstNameTv3;
        this.firstNameTv56 = firstNameTv56;
        this.firstNamehEd = firstNamehEd;
        this.fragmentLocationEditLayout = fragmentLocationEditLayout;
        this.fragmentLocationEditLayout1 = fragmentLocationEditLayout1;
        this.fragmentSec = fragmentSec;
        this.genderLayout = genderLayout;
        this.genderPersonalSpinner = genderPersonalSpinner;
        this.houseno = houseno;
        this.keepeditingtv = keepeditingtv;
        this.layoutDepartment = layoutDepartment;
        this.layoutDepartment1 = layoutDepartment1;
        this.loco = loco;
        this.mainheadingTv = mainheadingTv;
        this.mobileEd = mobileEd;
        this.namePhotographTv = namePhotographTv;
        this.nested = nested;
        this.no = no;
        this.other = other;
        this.otherEdDetails = otherEdDetails;
        this.otherlayou = otherlayou;
        this.otherlayout = otherlayout;
        this.otherlayout1 = otherlayout1;
        this.otherlayout2 = otherlayout2;
        this.partNumber = partNumber;
        this.percentageEd = percentageEd;
        this.relationSpinner = relationSpinner;
        this.relationTypeLayout = relationTypeLayout;
        this.relativeName = relativeName;
        this.relativeNameOfficial = relativeNameOfficial;
        this.relativeSurname = relativeSurname;
        this.relativeSurnameOfficial = relativeSurnameOfficial;
        this.residenceEd = residenceEd;
        this.sectionEd = sectionEd;
        this.selectState = selectState;
        this.sno = sno;
        this.stateSpinner = stateSpinner;
        this.stateTv = stateTv;
        this.stateTv1 = stateTv1;
        this.submittv = submittv;
        this.surNameEd = surNameEd;
        this.surNametv = surNametv;
        this.surnameNameHead = surnameNameHead;
        this.viewGenderSpinner = viewGenderSpinner;
        this.viewRelationSpinner = viewRelationSpinner;
        this.visual = visual;
        this.yes = yes;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentPreviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentPreviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_preview, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentPreviewBinding bind(View rootView) {
        int i = R.id.aadhar_ed;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.aadhar_ed);
        if (textView != null) {
            i = R.id.aadharlayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.aadharlayout);
            if (linearLayout != null) {
                i = R.id.assembly;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.assembly);
                if (textView2 != null) {
                    i = R.id.back_btn_iv;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                    if (imageView != null) {
                        i = R.id.cardView;
                        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView);
                        if (cardViewFindChildViewById != null) {
                            i = R.id.cat_rg;
                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.cat_rg);
                            if (radioGroup != null) {
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
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dob_ed);
                                                    if (textView6 != null) {
                                                        i = R.id.eleigibleElector;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.eleigibleElector);
                                                        if (textView7 != null) {
                                                            i = R.id.email_ed;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.email_ed);
                                                            if (textView8 != null) {
                                                                i = R.id.first_name_ed;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_ed);
                                                                if (textView9 != null) {
                                                                    i = R.id.first_name_head;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_head);
                                                                    if (textView10 != null) {
                                                                        i = R.id.first_name_tv3;
                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_tv3);
                                                                        if (textView11 != null) {
                                                                            i = R.id.first_name_tv56;
                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_name_tv56);
                                                                            if (textView12 != null) {
                                                                                i = R.id.first_nameh_ed;
                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_nameh_ed);
                                                                                if (textView13 != null) {
                                                                                    i = R.id.fragment_location_edit_layout;
                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fragment_location_edit_layout);
                                                                                    if (linearLayout2 != null) {
                                                                                        i = R.id.fragment_location_edit_layout1;
                                                                                        ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.fragment_location_edit_layout1);
                                                                                        if (constraintLayoutFindChildViewById2 != null) {
                                                                                            i = R.id.fragment_sec;
                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fragment_sec);
                                                                                            if (linearLayout3 != null) {
                                                                                                i = R.id.gender_layout;
                                                                                                ConstraintLayout constraintLayoutFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.gender_layout);
                                                                                                if (constraintLayoutFindChildViewById3 != null) {
                                                                                                    i = R.id.gender_personal_spinner;
                                                                                                    NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.gender_personal_spinner);
                                                                                                    if (noDefaultSpinner != null) {
                                                                                                        i = R.id.houseno;
                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.houseno);
                                                                                                        if (textView14 != null) {
                                                                                                            i = R.id.keepeditingtv;
                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.keepeditingtv);
                                                                                                            if (textView15 != null) {
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
                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mainheading_tv);
                                                                                                                            if (textView16 != null) {
                                                                                                                                i = R.id.mobile_ed;
                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobile_ed);
                                                                                                                                if (textView17 != null) {
                                                                                                                                    i = R.id.name_photograph_tv;
                                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_photograph_tv);
                                                                                                                                    if (textView18 != null) {
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
                                                                                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.other_ed_details);
                                                                                                                                                    if (textView19 != null) {
                                                                                                                                                        i = R.id.otherlayou;
                                                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.otherlayou);
                                                                                                                                                        if (linearLayout4 != null) {
                                                                                                                                                            i = R.id.otherlayout;
                                                                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.otherlayout);
                                                                                                                                                            if (linearLayout5 != null) {
                                                                                                                                                                i = R.id.otherlayout1;
                                                                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.otherlayout1);
                                                                                                                                                                if (linearLayout6 != null) {
                                                                                                                                                                    i = R.id.otherlayout2;
                                                                                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.otherlayout2);
                                                                                                                                                                    if (linearLayout7 != null) {
                                                                                                                                                                        i = R.id.partNumber;
                                                                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partNumber);
                                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                                            i = R.id.percentage_ed;
                                                                                                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.percentage_ed);
                                                                                                                                                                            if (textView21 != null) {
                                                                                                                                                                                i = R.id.relation_spinner;
                                                                                                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relation_spinner);
                                                                                                                                                                                if (textView22 != null) {
                                                                                                                                                                                    i = R.id.relation_type_layout;
                                                                                                                                                                                    ConstraintLayout constraintLayoutFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.relation_type_layout);
                                                                                                                                                                                    if (constraintLayoutFindChildViewById6 != null) {
                                                                                                                                                                                        i = R.id.relative_name;
                                                                                                                                                                                        TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_name);
                                                                                                                                                                                        if (textView23 != null) {
                                                                                                                                                                                            i = R.id.relative_name_official;
                                                                                                                                                                                            TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_name_official);
                                                                                                                                                                                            if (textView24 != null) {
                                                                                                                                                                                                i = R.id.relative_surname;
                                                                                                                                                                                                TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_surname);
                                                                                                                                                                                                if (textView25 != null) {
                                                                                                                                                                                                    i = R.id.relative_surname_official;
                                                                                                                                                                                                    TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_surname_official);
                                                                                                                                                                                                    if (textView26 != null) {
                                                                                                                                                                                                        i = R.id.residence_ed;
                                                                                                                                                                                                        TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.residence_ed);
                                                                                                                                                                                                        if (textView27 != null) {
                                                                                                                                                                                                            i = R.id.section_ed;
                                                                                                                                                                                                            TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.section_ed);
                                                                                                                                                                                                            if (textView28 != null) {
                                                                                                                                                                                                                i = R.id.select_state;
                                                                                                                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.select_state);
                                                                                                                                                                                                                if (linearLayout8 != null) {
                                                                                                                                                                                                                    i = R.id.sno;
                                                                                                                                                                                                                    TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sno);
                                                                                                                                                                                                                    if (textView29 != null) {
                                                                                                                                                                                                                        i = R.id.state_spinner;
                                                                                                                                                                                                                        TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_spinner);
                                                                                                                                                                                                                        if (textView30 != null) {
                                                                                                                                                                                                                            i = R.id.state_tv;
                                                                                                                                                                                                                            TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv);
                                                                                                                                                                                                                            if (textView31 != null) {
                                                                                                                                                                                                                                i = R.id.state_tv1;
                                                                                                                                                                                                                                TextView textView32 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv1);
                                                                                                                                                                                                                                if (textView32 != null) {
                                                                                                                                                                                                                                    i = R.id.submittv;
                                                                                                                                                                                                                                    TextView textView33 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submittv);
                                                                                                                                                                                                                                    if (textView33 != null) {
                                                                                                                                                                                                                                        i = R.id.sur_name_ed;
                                                                                                                                                                                                                                        TextView textView34 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sur_name_ed);
                                                                                                                                                                                                                                        if (textView34 != null) {
                                                                                                                                                                                                                                            i = R.id.sur_nametv;
                                                                                                                                                                                                                                            TextView textView35 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sur_nametv);
                                                                                                                                                                                                                                            if (textView35 != null) {
                                                                                                                                                                                                                                                i = R.id.surname_name_head;
                                                                                                                                                                                                                                                TextView textView36 = (TextView) ViewBindings.findChildViewById(rootView, R.id.surname_name_head);
                                                                                                                                                                                                                                                if (textView36 != null) {
                                                                                                                                                                                                                                                    i = R.id.view_gender_spinner;
                                                                                                                                                                                                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_gender_spinner);
                                                                                                                                                                                                                                                    if (viewFindChildViewById != null) {
                                                                                                                                                                                                                                                        i = R.id.view_relation_spinner;
                                                                                                                                                                                                                                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view_relation_spinner);
                                                                                                                                                                                                                                                        if (viewFindChildViewById2 != null) {
                                                                                                                                                                                                                                                            i = R.id.visual;
                                                                                                                                                                                                                                                            CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.visual);
                                                                                                                                                                                                                                                            if (checkBox4 != null) {
                                                                                                                                                                                                                                                                i = R.id.yes;
                                                                                                                                                                                                                                                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.yes);
                                                                                                                                                                                                                                                                if (radioButton2 != null) {
                                                                                                                                                                                                                                                                    return new BloFragmentPreviewBinding((ConstraintLayout) rootView, textView, linearLayout, textView2, imageView, cardViewFindChildViewById, radioGroup, textView3, constraintLayoutFindChildViewById, checkBox, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, linearLayout2, constraintLayoutFindChildViewById2, linearLayout3, constraintLayoutFindChildViewById3, noDefaultSpinner, textView14, textView15, constraintLayoutFindChildViewById4, constraintLayoutFindChildViewById5, checkBox2, textView16, textView17, textView18, nestedScrollViewFindChildViewById, radioButton, checkBox3, textView19, linearLayout4, linearLayout5, linearLayout6, linearLayout7, textView20, textView21, textView22, constraintLayoutFindChildViewById6, textView23, textView24, textView25, textView26, textView27, textView28, linearLayout8, textView29, textView30, textView31, textView32, textView33, textView34, textView35, textView36, viewFindChildViewById, viewFindChildViewById2, checkBox4, radioButton2);
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
