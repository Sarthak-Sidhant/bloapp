package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloDeclarationFormPreviewBinding implements ViewBinding {
    public final CardView bloSigncardview;
    public final CardView cdDfRelativeCardView;
    public final CardView cdDfSelfCardView;
    public final TextView chooseFileName;
    public final TextView chooseFileNameSize;
    public final CardView cvDfGeneralDetails;
    public final CardView cvDfradioCardView;
    public final ConstraintLayout declarationFormLayout;
    public final LinearLayout declarationformSign;
    public final CardView dfCdrelationtypecardview;
    public final TextView dfETfatherEpicNumber;
    public final TextView dfETfatherName;
    public final TextView dfETmotherEpicNumber;
    public final TextView dfETmotherName;
    public final TextView dfETspouseEpicNumber;
    public final TextView dfETspouseName;
    public final RadioGroup dfElectorPresentRG;
    public final LinearLayout dfLlElectorPresent;
    public final RadioButton dfRB2003;
    public final RadioButton dfRB2025;
    public final RadioButton dfRBneitherRb;
    public final RadioButton dfRBprogenyRb;
    public final RadioButton dfRBselfRb;
    public final RadioGroup dfRgsearchRG;
    public final TextView dfTvtvAcName;
    public final TextView dfTvtvAcNo;
    public final TextView dfTvtvEpic;
    public final TextView dfTvtvName;
    public final TextView dfTvtvName1;
    public final TextView dfTvtvPartNo;
    public final TextView dfTvtvRelation;
    public final TextView dfTvtvRlAcName;
    public final TextView dfTvtvRlAcNo;
    public final TextView dfTvtvRlEpic;
    public final TextView dfTvtvRlName;
    public final TextView dfTvtvRlName1;
    public final TextView dfTvtvRlPartNo;
    public final TextView dfTvtvRlRelation;
    public final TextView dfTvtvRlSrNo;
    public final TextView dfTvtvRlState;
    public final TextView dfTvtvSrNo;
    public final TextView dfTvtvState;
    public final TextView dfprogenyRelationSpinner;
    public final LinearLayout llFatherEpicNo;
    public final LinearLayout llMotherEpic;
    public final LinearLayout llSpouseEpicNo;
    public final LinearLayout llSpouseName;
    public final ImageView preview;
    private final ConstraintLayout rootView;
    public final TextView tabTV;

    private BloDeclarationFormPreviewBinding(ConstraintLayout rootView, CardView bloSigncardview, CardView cdDfRelativeCardView, CardView cdDfSelfCardView, TextView chooseFileName, TextView chooseFileNameSize, CardView cvDfGeneralDetails, CardView cvDfradioCardView, ConstraintLayout declarationFormLayout, LinearLayout declarationformSign, CardView dfCdrelationtypecardview, TextView dfETfatherEpicNumber, TextView dfETfatherName, TextView dfETmotherEpicNumber, TextView dfETmotherName, TextView dfETspouseEpicNumber, TextView dfETspouseName, RadioGroup dfElectorPresentRG, LinearLayout dfLlElectorPresent, RadioButton dfRB2003, RadioButton dfRB2025, RadioButton dfRBneitherRb, RadioButton dfRBprogenyRb, RadioButton dfRBselfRb, RadioGroup dfRgsearchRG, TextView dfTvtvAcName, TextView dfTvtvAcNo, TextView dfTvtvEpic, TextView dfTvtvName, TextView dfTvtvName1, TextView dfTvtvPartNo, TextView dfTvtvRelation, TextView dfTvtvRlAcName, TextView dfTvtvRlAcNo, TextView dfTvtvRlEpic, TextView dfTvtvRlName, TextView dfTvtvRlName1, TextView dfTvtvRlPartNo, TextView dfTvtvRlRelation, TextView dfTvtvRlSrNo, TextView dfTvtvRlState, TextView dfTvtvSrNo, TextView dfTvtvState, TextView dfprogenyRelationSpinner, LinearLayout llFatherEpicNo, LinearLayout llMotherEpic, LinearLayout llSpouseEpicNo, LinearLayout llSpouseName, ImageView preview, TextView tabTV) {
        this.rootView = rootView;
        this.bloSigncardview = bloSigncardview;
        this.cdDfRelativeCardView = cdDfRelativeCardView;
        this.cdDfSelfCardView = cdDfSelfCardView;
        this.chooseFileName = chooseFileName;
        this.chooseFileNameSize = chooseFileNameSize;
        this.cvDfGeneralDetails = cvDfGeneralDetails;
        this.cvDfradioCardView = cvDfradioCardView;
        this.declarationFormLayout = declarationFormLayout;
        this.declarationformSign = declarationformSign;
        this.dfCdrelationtypecardview = dfCdrelationtypecardview;
        this.dfETfatherEpicNumber = dfETfatherEpicNumber;
        this.dfETfatherName = dfETfatherName;
        this.dfETmotherEpicNumber = dfETmotherEpicNumber;
        this.dfETmotherName = dfETmotherName;
        this.dfETspouseEpicNumber = dfETspouseEpicNumber;
        this.dfETspouseName = dfETspouseName;
        this.dfElectorPresentRG = dfElectorPresentRG;
        this.dfLlElectorPresent = dfLlElectorPresent;
        this.dfRB2003 = dfRB2003;
        this.dfRB2025 = dfRB2025;
        this.dfRBneitherRb = dfRBneitherRb;
        this.dfRBprogenyRb = dfRBprogenyRb;
        this.dfRBselfRb = dfRBselfRb;
        this.dfRgsearchRG = dfRgsearchRG;
        this.dfTvtvAcName = dfTvtvAcName;
        this.dfTvtvAcNo = dfTvtvAcNo;
        this.dfTvtvEpic = dfTvtvEpic;
        this.dfTvtvName = dfTvtvName;
        this.dfTvtvName1 = dfTvtvName1;
        this.dfTvtvPartNo = dfTvtvPartNo;
        this.dfTvtvRelation = dfTvtvRelation;
        this.dfTvtvRlAcName = dfTvtvRlAcName;
        this.dfTvtvRlAcNo = dfTvtvRlAcNo;
        this.dfTvtvRlEpic = dfTvtvRlEpic;
        this.dfTvtvRlName = dfTvtvRlName;
        this.dfTvtvRlName1 = dfTvtvRlName1;
        this.dfTvtvRlPartNo = dfTvtvRlPartNo;
        this.dfTvtvRlRelation = dfTvtvRlRelation;
        this.dfTvtvRlSrNo = dfTvtvRlSrNo;
        this.dfTvtvRlState = dfTvtvRlState;
        this.dfTvtvSrNo = dfTvtvSrNo;
        this.dfTvtvState = dfTvtvState;
        this.dfprogenyRelationSpinner = dfprogenyRelationSpinner;
        this.llFatherEpicNo = llFatherEpicNo;
        this.llMotherEpic = llMotherEpic;
        this.llSpouseEpicNo = llSpouseEpicNo;
        this.llSpouseName = llSpouseName;
        this.preview = preview;
        this.tabTV = tabTV;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloDeclarationFormPreviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloDeclarationFormPreviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_declaration_form_preview, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloDeclarationFormPreviewBinding bind(View rootView) {
        int i = R.id.bloSigncardview;
        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bloSigncardview);
        if (cardViewFindChildViewById != null) {
            i = R.id.cdDfRelativeCardView;
            CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.cdDfRelativeCardView);
            if (cardViewFindChildViewById2 != null) {
                i = R.id.cdDfSelfCardView;
                CardView cardViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.cdDfSelfCardView);
                if (cardViewFindChildViewById3 != null) {
                    i = R.id.choose_file_name;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_name);
                    if (textView != null) {
                        i = R.id.choose_file_name_size;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_name_size);
                        if (textView2 != null) {
                            i = R.id.cvDfGeneralDetails;
                            CardView cardViewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.cvDfGeneralDetails);
                            if (cardViewFindChildViewById4 != null) {
                                i = R.id.cvDfradioCardView;
                                CardView cardViewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.cvDfradioCardView);
                                if (cardViewFindChildViewById5 != null) {
                                    i = R.id.declarationFormLayout;
                                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.declarationFormLayout);
                                    if (constraintLayoutFindChildViewById != null) {
                                        i = R.id.declarationform_sign;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.declarationform_sign);
                                        if (linearLayout != null) {
                                            i = R.id.dfCdrelationtypecardview;
                                            CardView cardViewFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.dfCdrelationtypecardview);
                                            if (cardViewFindChildViewById6 != null) {
                                                i = R.id.dfETfatherEpicNumber;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfETfatherEpicNumber);
                                                if (textView3 != null) {
                                                    i = R.id.dfETfatherName;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfETfatherName);
                                                    if (textView4 != null) {
                                                        i = R.id.dfETmotherEpicNumber;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfETmotherEpicNumber);
                                                        if (textView5 != null) {
                                                            i = R.id.dfETmotherName;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfETmotherName);
                                                            if (textView6 != null) {
                                                                i = R.id.dfETspouseEpicNumber;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfETspouseEpicNumber);
                                                                if (textView7 != null) {
                                                                    i = R.id.dfETspouseName;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfETspouseName);
                                                                    if (textView8 != null) {
                                                                        i = R.id.dfElectorPresentRG;
                                                                        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.dfElectorPresentRG);
                                                                        if (radioGroup != null) {
                                                                            i = R.id.dfLl_electorPresent;
                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.dfLl_electorPresent);
                                                                            if (linearLayout2 != null) {
                                                                                i = R.id.dfRB2003;
                                                                                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.dfRB2003);
                                                                                if (radioButton != null) {
                                                                                    i = R.id.dfRB2025;
                                                                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.dfRB2025);
                                                                                    if (radioButton2 != null) {
                                                                                        i = R.id.dfRBneitherRb;
                                                                                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.dfRBneitherRb);
                                                                                        if (radioButton3 != null) {
                                                                                            i = R.id.dfRBprogenyRb;
                                                                                            RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.dfRBprogenyRb);
                                                                                            if (radioButton4 != null) {
                                                                                                i = R.id.dfRBselfRb;
                                                                                                RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.dfRBselfRb);
                                                                                                if (radioButton5 != null) {
                                                                                                    i = R.id.dfRgsearchRG;
                                                                                                    RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.dfRgsearchRG);
                                                                                                    if (radioGroup2 != null) {
                                                                                                        i = R.id.dfTvtv_acName;
                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_acName);
                                                                                                        if (textView9 != null) {
                                                                                                            i = R.id.dfTvtv_acNo;
                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_acNo);
                                                                                                            if (textView10 != null) {
                                                                                                                i = R.id.dfTvtv_epic;
                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_epic);
                                                                                                                if (textView11 != null) {
                                                                                                                    i = R.id.dfTvtv_name;
                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_name);
                                                                                                                    if (textView12 != null) {
                                                                                                                        i = R.id.dfTvtv_name1;
                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_name1);
                                                                                                                        if (textView13 != null) {
                                                                                                                            i = R.id.dfTvtv_partNo;
                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_partNo);
                                                                                                                            if (textView14 != null) {
                                                                                                                                i = R.id.dfTvtv_relation;
                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_relation);
                                                                                                                                if (textView15 != null) {
                                                                                                                                    i = R.id.dfTvtv_rl_acName;
                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_rl_acName);
                                                                                                                                    if (textView16 != null) {
                                                                                                                                        i = R.id.dfTvtv_rl_acNo;
                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_rl_acNo);
                                                                                                                                        if (textView17 != null) {
                                                                                                                                            i = R.id.dfTvtv_rl_epic;
                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_rl_epic);
                                                                                                                                            if (textView18 != null) {
                                                                                                                                                i = R.id.dfTvtv_rl_name;
                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_rl_name);
                                                                                                                                                if (textView19 != null) {
                                                                                                                                                    i = R.id.dfTvtv_rl_name1;
                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_rl_name1);
                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                        i = R.id.dfTvtv_rl_partNo;
                                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_rl_partNo);
                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                            i = R.id.dfTvtv_rl_relation;
                                                                                                                                                            TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_rl_relation);
                                                                                                                                                            if (textView22 != null) {
                                                                                                                                                                i = R.id.dfTvtv_rl_srNo;
                                                                                                                                                                TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_rl_srNo);
                                                                                                                                                                if (textView23 != null) {
                                                                                                                                                                    i = R.id.dfTvtv_rl_state;
                                                                                                                                                                    TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_rl_state);
                                                                                                                                                                    if (textView24 != null) {
                                                                                                                                                                        i = R.id.dfTvtv_srNo;
                                                                                                                                                                        TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_srNo);
                                                                                                                                                                        if (textView25 != null) {
                                                                                                                                                                            i = R.id.dfTvtv_state;
                                                                                                                                                                            TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_state);
                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                i = R.id.dfprogenyRelationSpinner;
                                                                                                                                                                                TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfprogenyRelationSpinner);
                                                                                                                                                                                if (textView27 != null) {
                                                                                                                                                                                    i = R.id.llFatherEpicNo;
                                                                                                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llFatherEpicNo);
                                                                                                                                                                                    if (linearLayout3 != null) {
                                                                                                                                                                                        i = R.id.llMotherEpic;
                                                                                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llMotherEpic);
                                                                                                                                                                                        if (linearLayout4 != null) {
                                                                                                                                                                                            i = R.id.llSpouseEpicNo;
                                                                                                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llSpouseEpicNo);
                                                                                                                                                                                            if (linearLayout5 != null) {
                                                                                                                                                                                                i = R.id.llSpouseName;
                                                                                                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llSpouseName);
                                                                                                                                                                                                if (linearLayout6 != null) {
                                                                                                                                                                                                    i = R.id.preview;
                                                                                                                                                                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.preview);
                                                                                                                                                                                                    if (imageView != null) {
                                                                                                                                                                                                        i = R.id.tabTV;
                                                                                                                                                                                                        TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tabTV);
                                                                                                                                                                                                        if (textView28 != null) {
                                                                                                                                                                                                            return new BloDeclarationFormPreviewBinding((ConstraintLayout) rootView, cardViewFindChildViewById, cardViewFindChildViewById2, cardViewFindChildViewById3, textView, textView2, cardViewFindChildViewById4, cardViewFindChildViewById5, constraintLayoutFindChildViewById, linearLayout, cardViewFindChildViewById6, textView3, textView4, textView5, textView6, textView7, textView8, radioGroup, linearLayout2, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioGroup2, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, linearLayout3, linearLayout4, linearLayout5, linearLayout6, imageView, textView28);
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
