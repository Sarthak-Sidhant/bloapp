package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentForm6ChecklistDeclarationBinding implements ViewBinding {
    public final CardView cdDfSelfCardView;
    public final RadioGroup chooseRG;
    public final TextView decFormBloSign;
    public final LinearLayout decFormSignHeader;
    public final ImageView decFormSignImage;
    public final TextView decFormSignName;
    public final LinearLayout decformCommonHeader;
    public final ImageButton declarationEditDetailButton;
    public final TextView declarationTv;
    public final TextView dfIvAddSelf;
    public final RadioButton dfRBselfRb;
    public final TextView dfTvtvAcName;
    public final TextView dfTvtvAcNo;
    public final TextView dfTvtvEpic;
    public final TextView dfTvtvName;
    public final TextView dfTvtvName1;
    public final TextView dfTvtvPartNo;
    public final TextView dfTvtvRelation;
    public final TextView dfTvtvSrNo;
    public final TextView dfTvtvState;
    public final LinearLayout isExistingLl;
    public final TextView ivDeleteProgeny;
    public final TextView ivUpdateProgeny;
    public final LinearLayout llAnxureDeclaration;
    public final LinearLayout llDfAddSelf;
    public final LinearLayout lvCategoryRadio;
    public final LinearLayout lvChooseradioButtons;
    public final RadioButton neitherRb;
    public final CardView prevBloSignCardView;
    public final TextView prevfatherEpicNumber;
    public final TextView prevfatherName;
    public final TextView prevmotherEpicNumber;
    public final TextView prevmotherName;
    public final RadioButton prevprogenyRb;
    public final CardView prevrelativeCardView;
    public final RadioGroup prevsearchRG;
    public final TextView prevspouseEpicNumber;
    public final TextView prevsspouseName;
    public final TextView prevtvRlAcName;
    public final TextView prevtvRlAcNo;
    public final TextView prevtvRlEpic;
    public final TextView prevtvRlName;
    public final TextView prevtvRlName1;
    public final TextView prevtvRlPartNo;
    public final TextView prevtvRlRelation;
    public final TextView prevtvRlSrNo;
    public final TextView prevtvRlState;
    public final Spinner progenyRelationSpinner;
    public final CardView radiochooseCardView;
    public final RadioButton rb2003;
    public final RadioButton rb2025;
    public final RelativeLayout relationtypecardview;
    private final LinearLayout rootView;
    public final TextView tabTV;
    public final TextView tvDeclarationEditTextview;
    public final TextView tvIsexisting;
    public final TextView tvPrevEpic;

    private BloFragmentForm6ChecklistDeclarationBinding(LinearLayout rootView, CardView cdDfSelfCardView, RadioGroup chooseRG, TextView decFormBloSign, LinearLayout decFormSignHeader, ImageView decFormSignImage, TextView decFormSignName, LinearLayout decformCommonHeader, ImageButton declarationEditDetailButton, TextView declarationTv, TextView dfIvAddSelf, RadioButton dfRBselfRb, TextView dfTvtvAcName, TextView dfTvtvAcNo, TextView dfTvtvEpic, TextView dfTvtvName, TextView dfTvtvName1, TextView dfTvtvPartNo, TextView dfTvtvRelation, TextView dfTvtvSrNo, TextView dfTvtvState, LinearLayout isExistingLl, TextView ivDeleteProgeny, TextView ivUpdateProgeny, LinearLayout llAnxureDeclaration, LinearLayout llDfAddSelf, LinearLayout lvCategoryRadio, LinearLayout lvChooseradioButtons, RadioButton neitherRb, CardView prevBloSignCardView, TextView prevfatherEpicNumber, TextView prevfatherName, TextView prevmotherEpicNumber, TextView prevmotherName, RadioButton prevprogenyRb, CardView prevrelativeCardView, RadioGroup prevsearchRG, TextView prevspouseEpicNumber, TextView prevsspouseName, TextView prevtvRlAcName, TextView prevtvRlAcNo, TextView prevtvRlEpic, TextView prevtvRlName, TextView prevtvRlName1, TextView prevtvRlPartNo, TextView prevtvRlRelation, TextView prevtvRlSrNo, TextView prevtvRlState, Spinner progenyRelationSpinner, CardView radiochooseCardView, RadioButton rb2003, RadioButton rb2025, RelativeLayout relationtypecardview, TextView tabTV, TextView tvDeclarationEditTextview, TextView tvIsexisting, TextView tvPrevEpic) {
        this.rootView = rootView;
        this.cdDfSelfCardView = cdDfSelfCardView;
        this.chooseRG = chooseRG;
        this.decFormBloSign = decFormBloSign;
        this.decFormSignHeader = decFormSignHeader;
        this.decFormSignImage = decFormSignImage;
        this.decFormSignName = decFormSignName;
        this.decformCommonHeader = decformCommonHeader;
        this.declarationEditDetailButton = declarationEditDetailButton;
        this.declarationTv = declarationTv;
        this.dfIvAddSelf = dfIvAddSelf;
        this.dfRBselfRb = dfRBselfRb;
        this.dfTvtvAcName = dfTvtvAcName;
        this.dfTvtvAcNo = dfTvtvAcNo;
        this.dfTvtvEpic = dfTvtvEpic;
        this.dfTvtvName = dfTvtvName;
        this.dfTvtvName1 = dfTvtvName1;
        this.dfTvtvPartNo = dfTvtvPartNo;
        this.dfTvtvRelation = dfTvtvRelation;
        this.dfTvtvSrNo = dfTvtvSrNo;
        this.dfTvtvState = dfTvtvState;
        this.isExistingLl = isExistingLl;
        this.ivDeleteProgeny = ivDeleteProgeny;
        this.ivUpdateProgeny = ivUpdateProgeny;
        this.llAnxureDeclaration = llAnxureDeclaration;
        this.llDfAddSelf = llDfAddSelf;
        this.lvCategoryRadio = lvCategoryRadio;
        this.lvChooseradioButtons = lvChooseradioButtons;
        this.neitherRb = neitherRb;
        this.prevBloSignCardView = prevBloSignCardView;
        this.prevfatherEpicNumber = prevfatherEpicNumber;
        this.prevfatherName = prevfatherName;
        this.prevmotherEpicNumber = prevmotherEpicNumber;
        this.prevmotherName = prevmotherName;
        this.prevprogenyRb = prevprogenyRb;
        this.prevrelativeCardView = prevrelativeCardView;
        this.prevsearchRG = prevsearchRG;
        this.prevspouseEpicNumber = prevspouseEpicNumber;
        this.prevsspouseName = prevsspouseName;
        this.prevtvRlAcName = prevtvRlAcName;
        this.prevtvRlAcNo = prevtvRlAcNo;
        this.prevtvRlEpic = prevtvRlEpic;
        this.prevtvRlName = prevtvRlName;
        this.prevtvRlName1 = prevtvRlName1;
        this.prevtvRlPartNo = prevtvRlPartNo;
        this.prevtvRlRelation = prevtvRlRelation;
        this.prevtvRlSrNo = prevtvRlSrNo;
        this.prevtvRlState = prevtvRlState;
        this.progenyRelationSpinner = progenyRelationSpinner;
        this.radiochooseCardView = radiochooseCardView;
        this.rb2003 = rb2003;
        this.rb2025 = rb2025;
        this.relationtypecardview = relationtypecardview;
        this.tabTV = tabTV;
        this.tvDeclarationEditTextview = tvDeclarationEditTextview;
        this.tvIsexisting = tvIsexisting;
        this.tvPrevEpic = tvPrevEpic;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentForm6ChecklistDeclarationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentForm6ChecklistDeclarationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_form6_checklist_declaration, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentForm6ChecklistDeclarationBinding bind(View rootView) {
        int i = R.id.cdDfSelfCardView;
        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cdDfSelfCardView);
        if (cardViewFindChildViewById != null) {
            i = R.id.chooseRG;
            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.chooseRG);
            if (radioGroup != null) {
                i = R.id.decForm_blo_sign;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.decForm_blo_sign);
                if (textView != null) {
                    i = R.id.decForm_sign_header;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.decForm_sign_header);
                    if (linearLayout != null) {
                        i = R.id.decForm_sign_image;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.decForm_sign_image);
                        if (imageView != null) {
                            i = R.id.decForm_sign_name;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.decForm_sign_name);
                            if (textView2 != null) {
                                i = R.id.decform_common_header;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.decform_common_header);
                                if (linearLayout2 != null) {
                                    i = R.id.declaration_edit_detail_button;
                                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.declaration_edit_detail_button);
                                    if (imageButton != null) {
                                        i = R.id.declaration_tv;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.declaration_tv);
                                        if (textView3 != null) {
                                            i = R.id.dfIv_add_self;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfIv_add_self);
                                            if (textView4 != null) {
                                                i = R.id.dfRBselfRb;
                                                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.dfRBselfRb);
                                                if (radioButton != null) {
                                                    i = R.id.dfTvtv_acName;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_acName);
                                                    if (textView5 != null) {
                                                        i = R.id.dfTvtv_acNo;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_acNo);
                                                        if (textView6 != null) {
                                                            i = R.id.dfTvtv_epic;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_epic);
                                                            if (textView7 != null) {
                                                                i = R.id.dfTvtv_name;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_name);
                                                                if (textView8 != null) {
                                                                    i = R.id.dfTvtv_name1;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_name1);
                                                                    if (textView9 != null) {
                                                                        i = R.id.dfTvtv_partNo;
                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_partNo);
                                                                        if (textView10 != null) {
                                                                            i = R.id.dfTvtv_relation;
                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_relation);
                                                                            if (textView11 != null) {
                                                                                i = R.id.dfTvtv_srNo;
                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_srNo);
                                                                                if (textView12 != null) {
                                                                                    i = R.id.dfTvtv_state;
                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTvtv_state);
                                                                                    if (textView13 != null) {
                                                                                        i = R.id.isExisting_ll;
                                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.isExisting_ll);
                                                                                        if (linearLayout3 != null) {
                                                                                            i = R.id.iv_delete_progeny;
                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.iv_delete_progeny);
                                                                                            if (textView14 != null) {
                                                                                                i = R.id.iv_update_progeny;
                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.iv_update_progeny);
                                                                                                if (textView15 != null) {
                                                                                                    i = R.id.ll_anxure_declaration;
                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_anxure_declaration);
                                                                                                    if (linearLayout4 != null) {
                                                                                                        i = R.id.llDfAddSelf;
                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llDfAddSelf);
                                                                                                        if (linearLayout5 != null) {
                                                                                                            i = R.id.lv_category_radio;
                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_category_radio);
                                                                                                            if (linearLayout6 != null) {
                                                                                                                i = R.id.lv_chooseradioButtons;
                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_chooseradioButtons);
                                                                                                                if (linearLayout7 != null) {
                                                                                                                    i = R.id.neitherRb;
                                                                                                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.neitherRb);
                                                                                                                    if (radioButton2 != null) {
                                                                                                                        i = R.id.prevBloSignCardView;
                                                                                                                        CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.prevBloSignCardView);
                                                                                                                        if (cardViewFindChildViewById2 != null) {
                                                                                                                            i = R.id.prevfatherEpicNumber;
                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevfatherEpicNumber);
                                                                                                                            if (textView16 != null) {
                                                                                                                                i = R.id.prevfatherName;
                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevfatherName);
                                                                                                                                if (textView17 != null) {
                                                                                                                                    i = R.id.prevmotherEpicNumber;
                                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevmotherEpicNumber);
                                                                                                                                    if (textView18 != null) {
                                                                                                                                        i = R.id.prevmotherName;
                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevmotherName);
                                                                                                                                        if (textView19 != null) {
                                                                                                                                            i = R.id.prevprogenyRb;
                                                                                                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.prevprogenyRb);
                                                                                                                                            if (radioButton3 != null) {
                                                                                                                                                i = R.id.prevrelativeCardView;
                                                                                                                                                CardView cardViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.prevrelativeCardView);
                                                                                                                                                if (cardViewFindChildViewById3 != null) {
                                                                                                                                                    i = R.id.prevsearchRG;
                                                                                                                                                    RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.prevsearchRG);
                                                                                                                                                    if (radioGroup2 != null) {
                                                                                                                                                        i = R.id.prevspouseEpicNumber;
                                                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevspouseEpicNumber);
                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                            i = R.id.prevsspouseName;
                                                                                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevsspouseName);
                                                                                                                                                            if (textView21 != null) {
                                                                                                                                                                i = R.id.prevtv_rl_acName;
                                                                                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_acName);
                                                                                                                                                                if (textView22 != null) {
                                                                                                                                                                    i = R.id.prevtv_rl_acNo;
                                                                                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_acNo);
                                                                                                                                                                    if (textView23 != null) {
                                                                                                                                                                        i = R.id.prevtv_rl_epic;
                                                                                                                                                                        TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_epic);
                                                                                                                                                                        if (textView24 != null) {
                                                                                                                                                                            i = R.id.prevtv_rl_name;
                                                                                                                                                                            TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_name);
                                                                                                                                                                            if (textView25 != null) {
                                                                                                                                                                                i = R.id.prevtv_rl_name1;
                                                                                                                                                                                TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_name1);
                                                                                                                                                                                if (textView26 != null) {
                                                                                                                                                                                    i = R.id.prevtv_rl_partNo;
                                                                                                                                                                                    TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_partNo);
                                                                                                                                                                                    if (textView27 != null) {
                                                                                                                                                                                        i = R.id.prevtv_rl_relation;
                                                                                                                                                                                        TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_relation);
                                                                                                                                                                                        if (textView28 != null) {
                                                                                                                                                                                            i = R.id.prevtv_rl_srNo;
                                                                                                                                                                                            TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_srNo);
                                                                                                                                                                                            if (textView29 != null) {
                                                                                                                                                                                                i = R.id.prevtv_rl_state;
                                                                                                                                                                                                TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_state);
                                                                                                                                                                                                if (textView30 != null) {
                                                                                                                                                                                                    i = R.id.progenyRelationSpinner;
                                                                                                                                                                                                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.progenyRelationSpinner);
                                                                                                                                                                                                    if (spinner != null) {
                                                                                                                                                                                                        i = R.id.radiochooseCardView;
                                                                                                                                                                                                        CardView cardViewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.radiochooseCardView);
                                                                                                                                                                                                        if (cardViewFindChildViewById4 != null) {
                                                                                                                                                                                                            i = R.id.rb2003;
                                                                                                                                                                                                            RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rb2003);
                                                                                                                                                                                                            if (radioButton4 != null) {
                                                                                                                                                                                                                i = R.id.rb2025;
                                                                                                                                                                                                                RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rb2025);
                                                                                                                                                                                                                if (radioButton5 != null) {
                                                                                                                                                                                                                    i = R.id.relationtypecardview;
                                                                                                                                                                                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relationtypecardview);
                                                                                                                                                                                                                    if (relativeLayout != null) {
                                                                                                                                                                                                                        i = R.id.tabTV;
                                                                                                                                                                                                                        TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tabTV);
                                                                                                                                                                                                                        if (textView31 != null) {
                                                                                                                                                                                                                            i = R.id.tv_declaration_edit_textview;
                                                                                                                                                                                                                            TextView textView32 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_declaration_edit_textview);
                                                                                                                                                                                                                            if (textView32 != null) {
                                                                                                                                                                                                                                i = R.id.tv_isexisting;
                                                                                                                                                                                                                                TextView textView33 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_isexisting);
                                                                                                                                                                                                                                if (textView33 != null) {
                                                                                                                                                                                                                                    i = R.id.tv_prevEpic;
                                                                                                                                                                                                                                    TextView textView34 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_prevEpic);
                                                                                                                                                                                                                                    if (textView34 != null) {
                                                                                                                                                                                                                                        return new BloFragmentForm6ChecklistDeclarationBinding((LinearLayout) rootView, cardViewFindChildViewById, radioGroup, textView, linearLayout, imageView, textView2, linearLayout2, imageButton, textView3, textView4, radioButton, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, linearLayout3, textView14, textView15, linearLayout4, linearLayout5, linearLayout6, linearLayout7, radioButton2, cardViewFindChildViewById2, textView16, textView17, textView18, textView19, radioButton3, cardViewFindChildViewById3, radioGroup2, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30, spinner, cardViewFindChildViewById4, radioButton4, radioButton5, relativeLayout, textView31, textView32, textView33, textView34);
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
