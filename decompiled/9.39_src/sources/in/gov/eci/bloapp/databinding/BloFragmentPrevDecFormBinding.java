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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentPrevDecFormBinding implements ViewBinding {
    public final RadioGroup chooseRG;
    public final TextView decFormBloSign;
    public final LinearLayout decFormSignHeader;
    public final ImageView decFormSignImage;
    public final TextView decFormSignName;
    public final LinearLayout decformCommonHeader;
    public final TextView ivDelete;
    public final TextView ivDeleteProgeny;
    public final TextView ivUpdate;
    public final TextView ivUpdateProgeny;
    public final LinearLayout llAnxureDeclaration;
    public final LinearLayout llFatherEpicName;
    public final LinearLayout llFatherEpicNo;
    public final LinearLayout llMotherEpic;
    public final LinearLayout llMotherName;
    public final LinearLayout llSpouseEpicNo;
    public final LinearLayout llSpouseName;
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
    public final TextView progenyRelationSpinner;
    public final CardView radiochooseCardView;
    public final RadioButton rb2003;
    public final RadioButton rb2025;
    private final LinearLayout rootView;
    public final CardView selfCardView;
    public final RadioButton selfRb;
    public final TextView tabTV;
    public final TextView tvAcName;
    public final TextView tvAcNo;
    public final TextView tvEpic;
    public final TextView tvName;
    public final TextView tvName1;
    public final TextView tvPartNo;
    public final TextView tvRelation;
    public final TextView tvSrNo;
    public final TextView tvState;

    private BloFragmentPrevDecFormBinding(LinearLayout rootView, RadioGroup chooseRG, TextView decFormBloSign, LinearLayout decFormSignHeader, ImageView decFormSignImage, TextView decFormSignName, LinearLayout decformCommonHeader, TextView ivDelete, TextView ivDeleteProgeny, TextView ivUpdate, TextView ivUpdateProgeny, LinearLayout llAnxureDeclaration, LinearLayout llFatherEpicName, LinearLayout llFatherEpicNo, LinearLayout llMotherEpic, LinearLayout llMotherName, LinearLayout llSpouseEpicNo, LinearLayout llSpouseName, LinearLayout lvChooseradioButtons, RadioButton neitherRb, CardView prevBloSignCardView, TextView prevfatherEpicNumber, TextView prevfatherName, TextView prevmotherEpicNumber, TextView prevmotherName, RadioButton prevprogenyRb, CardView prevrelativeCardView, RadioGroup prevsearchRG, TextView prevspouseEpicNumber, TextView prevsspouseName, TextView prevtvRlAcName, TextView prevtvRlAcNo, TextView prevtvRlEpic, TextView prevtvRlName, TextView prevtvRlName1, TextView prevtvRlPartNo, TextView prevtvRlRelation, TextView prevtvRlSrNo, TextView prevtvRlState, TextView progenyRelationSpinner, CardView radiochooseCardView, RadioButton rb2003, RadioButton rb2025, CardView selfCardView, RadioButton selfRb, TextView tabTV, TextView tvAcName, TextView tvAcNo, TextView tvEpic, TextView tvName, TextView tvName1, TextView tvPartNo, TextView tvRelation, TextView tvSrNo, TextView tvState) {
        this.rootView = rootView;
        this.chooseRG = chooseRG;
        this.decFormBloSign = decFormBloSign;
        this.decFormSignHeader = decFormSignHeader;
        this.decFormSignImage = decFormSignImage;
        this.decFormSignName = decFormSignName;
        this.decformCommonHeader = decformCommonHeader;
        this.ivDelete = ivDelete;
        this.ivDeleteProgeny = ivDeleteProgeny;
        this.ivUpdate = ivUpdate;
        this.ivUpdateProgeny = ivUpdateProgeny;
        this.llAnxureDeclaration = llAnxureDeclaration;
        this.llFatherEpicName = llFatherEpicName;
        this.llFatherEpicNo = llFatherEpicNo;
        this.llMotherEpic = llMotherEpic;
        this.llMotherName = llMotherName;
        this.llSpouseEpicNo = llSpouseEpicNo;
        this.llSpouseName = llSpouseName;
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
        this.selfCardView = selfCardView;
        this.selfRb = selfRb;
        this.tabTV = tabTV;
        this.tvAcName = tvAcName;
        this.tvAcNo = tvAcNo;
        this.tvEpic = tvEpic;
        this.tvName = tvName;
        this.tvName1 = tvName1;
        this.tvPartNo = tvPartNo;
        this.tvRelation = tvRelation;
        this.tvSrNo = tvSrNo;
        this.tvState = tvState;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentPrevDecFormBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentPrevDecFormBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_prev_dec_form, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentPrevDecFormBinding bind(View rootView) {
        int i = R.id.chooseRG;
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
                                i = R.id.iv_delete;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.iv_delete);
                                if (textView3 != null) {
                                    i = R.id.iv_delete_progeny;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.iv_delete_progeny);
                                    if (textView4 != null) {
                                        i = R.id.iv_update;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.iv_update);
                                        if (textView5 != null) {
                                            i = R.id.iv_update_progeny;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.iv_update_progeny);
                                            if (textView6 != null) {
                                                i = R.id.ll_anxure_declaration;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_anxure_declaration);
                                                if (linearLayout3 != null) {
                                                    i = R.id.llFatherEpicName;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llFatherEpicName);
                                                    if (linearLayout4 != null) {
                                                        i = R.id.llFatherEpicNo;
                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llFatherEpicNo);
                                                        if (linearLayout5 != null) {
                                                            i = R.id.llMotherEpic;
                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llMotherEpic);
                                                            if (linearLayout6 != null) {
                                                                i = R.id.llMotherName;
                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llMotherName);
                                                                if (linearLayout7 != null) {
                                                                    i = R.id.llSpouseEpicNo;
                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llSpouseEpicNo);
                                                                    if (linearLayout8 != null) {
                                                                        i = R.id.llSpouseName;
                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llSpouseName);
                                                                        if (linearLayout9 != null) {
                                                                            i = R.id.lv_chooseradioButtons;
                                                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_chooseradioButtons);
                                                                            if (linearLayout10 != null) {
                                                                                i = R.id.neitherRb;
                                                                                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.neitherRb);
                                                                                if (radioButton != null) {
                                                                                    i = R.id.prevBloSignCardView;
                                                                                    CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.prevBloSignCardView);
                                                                                    if (cardViewFindChildViewById != null) {
                                                                                        i = R.id.prevfatherEpicNumber;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevfatherEpicNumber);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.prevfatherName;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevfatherName);
                                                                                            if (textView8 != null) {
                                                                                                i = R.id.prevmotherEpicNumber;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevmotherEpicNumber);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.prevmotherName;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevmotherName);
                                                                                                    if (textView10 != null) {
                                                                                                        i = R.id.prevprogenyRb;
                                                                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.prevprogenyRb);
                                                                                                        if (radioButton2 != null) {
                                                                                                            i = R.id.prevrelativeCardView;
                                                                                                            CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.prevrelativeCardView);
                                                                                                            if (cardViewFindChildViewById2 != null) {
                                                                                                                i = R.id.prevsearchRG;
                                                                                                                RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.prevsearchRG);
                                                                                                                if (radioGroup2 != null) {
                                                                                                                    i = R.id.prevspouseEpicNumber;
                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevspouseEpicNumber);
                                                                                                                    if (textView11 != null) {
                                                                                                                        i = R.id.prevsspouseName;
                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevsspouseName);
                                                                                                                        if (textView12 != null) {
                                                                                                                            i = R.id.prevtv_rl_acName;
                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_acName);
                                                                                                                            if (textView13 != null) {
                                                                                                                                i = R.id.prevtv_rl_acNo;
                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_acNo);
                                                                                                                                if (textView14 != null) {
                                                                                                                                    i = R.id.prevtv_rl_epic;
                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_epic);
                                                                                                                                    if (textView15 != null) {
                                                                                                                                        i = R.id.prevtv_rl_name;
                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_name);
                                                                                                                                        if (textView16 != null) {
                                                                                                                                            i = R.id.prevtv_rl_name1;
                                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_name1);
                                                                                                                                            if (textView17 != null) {
                                                                                                                                                i = R.id.prevtv_rl_partNo;
                                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_partNo);
                                                                                                                                                if (textView18 != null) {
                                                                                                                                                    i = R.id.prevtv_rl_relation;
                                                                                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_relation);
                                                                                                                                                    if (textView19 != null) {
                                                                                                                                                        i = R.id.prevtv_rl_srNo;
                                                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_srNo);
                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                            i = R.id.prevtv_rl_state;
                                                                                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.prevtv_rl_state);
                                                                                                                                                            if (textView21 != null) {
                                                                                                                                                                i = R.id.progenyRelationSpinner;
                                                                                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.progenyRelationSpinner);
                                                                                                                                                                if (textView22 != null) {
                                                                                                                                                                    i = R.id.radiochooseCardView;
                                                                                                                                                                    CardView cardViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.radiochooseCardView);
                                                                                                                                                                    if (cardViewFindChildViewById3 != null) {
                                                                                                                                                                        i = R.id.rb2003;
                                                                                                                                                                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rb2003);
                                                                                                                                                                        if (radioButton3 != null) {
                                                                                                                                                                            i = R.id.rb2025;
                                                                                                                                                                            RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rb2025);
                                                                                                                                                                            if (radioButton4 != null) {
                                                                                                                                                                                i = R.id.selfCardView;
                                                                                                                                                                                CardView cardViewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.selfCardView);
                                                                                                                                                                                if (cardViewFindChildViewById4 != null) {
                                                                                                                                                                                    i = R.id.selfRb;
                                                                                                                                                                                    RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.selfRb);
                                                                                                                                                                                    if (radioButton5 != null) {
                                                                                                                                                                                        i = R.id.tabTV;
                                                                                                                                                                                        TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tabTV);
                                                                                                                                                                                        if (textView23 != null) {
                                                                                                                                                                                            i = R.id.tv_acName;
                                                                                                                                                                                            TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_acName);
                                                                                                                                                                                            if (textView24 != null) {
                                                                                                                                                                                                i = R.id.tv_acNo;
                                                                                                                                                                                                TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_acNo);
                                                                                                                                                                                                if (textView25 != null) {
                                                                                                                                                                                                    i = R.id.tv_epic;
                                                                                                                                                                                                    TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_epic);
                                                                                                                                                                                                    if (textView26 != null) {
                                                                                                                                                                                                        i = R.id.tv_name;
                                                                                                                                                                                                        TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_name);
                                                                                                                                                                                                        if (textView27 != null) {
                                                                                                                                                                                                            i = R.id.tv_name1;
                                                                                                                                                                                                            TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_name1);
                                                                                                                                                                                                            if (textView28 != null) {
                                                                                                                                                                                                                i = R.id.tv_partNo;
                                                                                                                                                                                                                TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_partNo);
                                                                                                                                                                                                                if (textView29 != null) {
                                                                                                                                                                                                                    i = R.id.tv_relation;
                                                                                                                                                                                                                    TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relation);
                                                                                                                                                                                                                    if (textView30 != null) {
                                                                                                                                                                                                                        i = R.id.tv_srNo;
                                                                                                                                                                                                                        TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_srNo);
                                                                                                                                                                                                                        if (textView31 != null) {
                                                                                                                                                                                                                            i = R.id.tv_state;
                                                                                                                                                                                                                            TextView textView32 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_state);
                                                                                                                                                                                                                            if (textView32 != null) {
                                                                                                                                                                                                                                return new BloFragmentPrevDecFormBinding((LinearLayout) rootView, radioGroup, textView, linearLayout, imageView, textView2, linearLayout2, textView3, textView4, textView5, textView6, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, radioButton, cardViewFindChildViewById, textView7, textView8, textView9, textView10, radioButton2, cardViewFindChildViewById2, radioGroup2, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, cardViewFindChildViewById3, radioButton3, radioButton4, cardViewFindChildViewById4, radioButton5, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30, textView31, textView32);
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
