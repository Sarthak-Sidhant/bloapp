package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentAnnexureFormBinding implements ViewBinding {
    public final TextView addfilename2;
    public final TextView addfilename3;
    public final TextView addfilenameMother;
    public final ImageView addimg1;
    public final ImageView addimg2;
    public final ImageView addimg3;
    public final ImageView addimgMotherIndian;
    public final LinearLayout annexCommonHeader;
    public final LinearLayout annexIndianCommonBody;
    public final LinearLayout annexNonIndianCommonBody;
    public final LinearLayout annexSignHeader;
    public final TextView betweenfilename;
    public final ImageView betweenimage;
    public final TextView bloHeader;
    public final TextView bloSign;
    public final TextView citiCatDocSpinner;
    public final TextView citizenshipCatfilename;
    public final TextView districtadd3;
    public final LinearLayout fatherLayout;
    public final LinearLayout forIndianParentLayout;
    public final LinearLayout forIndianParentLayoutBetween;
    public final LinearLayout forIndianParentLayoutFather;
    public final LinearLayout forIndianParentMotherLayout;
    public final LinearLayout forIndianParentMotherLayout1;
    public final LinearLayout forNonIndianParentLayout;
    public final RadioButton formAnnxBornIndia;
    public final RadioButton formAnnxIndiaCitize;
    public final RadioButton formAnnxNotBorn;
    public final TextView indianFatherSpinner;
    public final TextView indianMotherSpinner;
    public final TextView indianParentMotherTv;
    public final TextView indianParentTv;
    public final TextView indianParentTv2;
    public final TextView indianParentTvMother;
    public final RadioGroup indianparentRG;
    public final RadioGroup indianparentRGBetween;
    public final LinearLayout llAnxureDeclaration;
    public final TextView nonIndianParentTv;
    public final TextView nonIndianParentTv2;
    public final RadioButton parentFatherRb;
    public final RadioButton parentFatherRbBetween;
    public final RadioButton parentMotherRb;
    public final RadioButton parentMotherRbBetween;
    public final RadioButton parentNoRb;
    public final RadioGroup parentRG;
    public final TextView parentSpinnerBetween;
    public final RadioButton parentYesRb;
    public final RadioGroup radioGroupAnnexure;
    private final LinearLayout rootView;
    public final LinearLayout selectBothParentLayout;
    public final LinearLayout selectParentLayout;
    public final LinearLayout selectParentLayoutBetween;
    public final ImageView signImage;
    public final TextView signName;

    private BloFragmentAnnexureFormBinding(LinearLayout rootView, TextView addfilename2, TextView addfilename3, TextView addfilenameMother, ImageView addimg1, ImageView addimg2, ImageView addimg3, ImageView addimgMotherIndian, LinearLayout annexCommonHeader, LinearLayout annexIndianCommonBody, LinearLayout annexNonIndianCommonBody, LinearLayout annexSignHeader, TextView betweenfilename, ImageView betweenimage, TextView bloHeader, TextView bloSign, TextView citiCatDocSpinner, TextView citizenshipCatfilename, TextView districtadd3, LinearLayout fatherLayout, LinearLayout forIndianParentLayout, LinearLayout forIndianParentLayoutBetween, LinearLayout forIndianParentLayoutFather, LinearLayout forIndianParentMotherLayout, LinearLayout forIndianParentMotherLayout1, LinearLayout forNonIndianParentLayout, RadioButton formAnnxBornIndia, RadioButton formAnnxIndiaCitize, RadioButton formAnnxNotBorn, TextView indianFatherSpinner, TextView indianMotherSpinner, TextView indianParentMotherTv, TextView indianParentTv, TextView indianParentTv2, TextView indianParentTvMother, RadioGroup indianparentRG, RadioGroup indianparentRGBetween, LinearLayout llAnxureDeclaration, TextView nonIndianParentTv, TextView nonIndianParentTv2, RadioButton parentFatherRb, RadioButton parentFatherRbBetween, RadioButton parentMotherRb, RadioButton parentMotherRbBetween, RadioButton parentNoRb, RadioGroup parentRG, TextView parentSpinnerBetween, RadioButton parentYesRb, RadioGroup radioGroupAnnexure, LinearLayout selectBothParentLayout, LinearLayout selectParentLayout, LinearLayout selectParentLayoutBetween, ImageView signImage, TextView signName) {
        this.rootView = rootView;
        this.addfilename2 = addfilename2;
        this.addfilename3 = addfilename3;
        this.addfilenameMother = addfilenameMother;
        this.addimg1 = addimg1;
        this.addimg2 = addimg2;
        this.addimg3 = addimg3;
        this.addimgMotherIndian = addimgMotherIndian;
        this.annexCommonHeader = annexCommonHeader;
        this.annexIndianCommonBody = annexIndianCommonBody;
        this.annexNonIndianCommonBody = annexNonIndianCommonBody;
        this.annexSignHeader = annexSignHeader;
        this.betweenfilename = betweenfilename;
        this.betweenimage = betweenimage;
        this.bloHeader = bloHeader;
        this.bloSign = bloSign;
        this.citiCatDocSpinner = citiCatDocSpinner;
        this.citizenshipCatfilename = citizenshipCatfilename;
        this.districtadd3 = districtadd3;
        this.fatherLayout = fatherLayout;
        this.forIndianParentLayout = forIndianParentLayout;
        this.forIndianParentLayoutBetween = forIndianParentLayoutBetween;
        this.forIndianParentLayoutFather = forIndianParentLayoutFather;
        this.forIndianParentMotherLayout = forIndianParentMotherLayout;
        this.forIndianParentMotherLayout1 = forIndianParentMotherLayout1;
        this.forNonIndianParentLayout = forNonIndianParentLayout;
        this.formAnnxBornIndia = formAnnxBornIndia;
        this.formAnnxIndiaCitize = formAnnxIndiaCitize;
        this.formAnnxNotBorn = formAnnxNotBorn;
        this.indianFatherSpinner = indianFatherSpinner;
        this.indianMotherSpinner = indianMotherSpinner;
        this.indianParentMotherTv = indianParentMotherTv;
        this.indianParentTv = indianParentTv;
        this.indianParentTv2 = indianParentTv2;
        this.indianParentTvMother = indianParentTvMother;
        this.indianparentRG = indianparentRG;
        this.indianparentRGBetween = indianparentRGBetween;
        this.llAnxureDeclaration = llAnxureDeclaration;
        this.nonIndianParentTv = nonIndianParentTv;
        this.nonIndianParentTv2 = nonIndianParentTv2;
        this.parentFatherRb = parentFatherRb;
        this.parentFatherRbBetween = parentFatherRbBetween;
        this.parentMotherRb = parentMotherRb;
        this.parentMotherRbBetween = parentMotherRbBetween;
        this.parentNoRb = parentNoRb;
        this.parentRG = parentRG;
        this.parentSpinnerBetween = parentSpinnerBetween;
        this.parentYesRb = parentYesRb;
        this.radioGroupAnnexure = radioGroupAnnexure;
        this.selectBothParentLayout = selectBothParentLayout;
        this.selectParentLayout = selectParentLayout;
        this.selectParentLayoutBetween = selectParentLayoutBetween;
        this.signImage = signImage;
        this.signName = signName;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentAnnexureFormBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentAnnexureFormBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_annexure_form, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentAnnexureFormBinding bind(View rootView) {
        int i = R.id.addfilename2;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.addfilename2);
        if (textView != null) {
            i = R.id.addfilename3;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.addfilename3);
            if (textView2 != null) {
                i = R.id.addfilename_mother;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.addfilename_mother);
                if (textView3 != null) {
                    i = R.id.addimg1;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.addimg1);
                    if (imageView != null) {
                        i = R.id.addimg2;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.addimg2);
                        if (imageView2 != null) {
                            i = R.id.addimg3;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.addimg3);
                            if (imageView3 != null) {
                                i = R.id.addimg_mother_indian;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.addimg_mother_indian);
                                if (imageView4 != null) {
                                    i = R.id.annex_common_header;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.annex_common_header);
                                    if (linearLayout != null) {
                                        i = R.id.annex_indian_common_body;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.annex_indian_common_body);
                                        if (linearLayout2 != null) {
                                            i = R.id.annex_non_indian_common_body;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.annex_non_indian_common_body);
                                            if (linearLayout3 != null) {
                                                i = R.id.annex_sign_header;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.annex_sign_header);
                                                if (linearLayout4 != null) {
                                                    i = R.id.betweenfilename;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.betweenfilename);
                                                    if (textView4 != null) {
                                                        i = R.id.betweenimage;
                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.betweenimage);
                                                        if (imageView5 != null) {
                                                            i = R.id.blo_header;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.blo_header);
                                                            if (textView5 != null) {
                                                                i = R.id.blo_sign;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.blo_sign);
                                                                if (textView6 != null) {
                                                                    i = R.id.citiCatDocSpinner;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.citiCatDocSpinner);
                                                                    if (textView7 != null) {
                                                                        i = R.id.citizenshipCatfilename;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.citizenshipCatfilename);
                                                                        if (textView8 != null) {
                                                                            i = R.id.districtadd3;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.districtadd3);
                                                                            if (textView9 != null) {
                                                                                i = R.id.father_layout;
                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.father_layout);
                                                                                if (linearLayout5 != null) {
                                                                                    i = R.id.for_indian_parent_layout;
                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.for_indian_parent_layout);
                                                                                    if (linearLayout6 != null) {
                                                                                        i = R.id.for_indian_parent_layout_between;
                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.for_indian_parent_layout_between);
                                                                                        if (linearLayout7 != null) {
                                                                                            i = R.id.for_indian_parent_layout_father;
                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.for_indian_parent_layout_father);
                                                                                            if (linearLayout8 != null) {
                                                                                                i = R.id.for_indian_parent_mother_layout;
                                                                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.for_indian_parent_mother_layout);
                                                                                                if (linearLayout9 != null) {
                                                                                                    i = R.id.for_indian_parent_mother_layout1;
                                                                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.for_indian_parent_mother_layout1);
                                                                                                    if (linearLayout10 != null) {
                                                                                                        i = R.id.for_non_indian_parent_layout;
                                                                                                        LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.for_non_indian_parent_layout);
                                                                                                        if (linearLayout11 != null) {
                                                                                                            i = R.id.form_annx_born_india;
                                                                                                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.form_annx_born_india);
                                                                                                            if (radioButton != null) {
                                                                                                                i = R.id.form_annx_india_citize;
                                                                                                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.form_annx_india_citize);
                                                                                                                if (radioButton2 != null) {
                                                                                                                    i = R.id.form_annx_not_born;
                                                                                                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.form_annx_not_born);
                                                                                                                    if (radioButton3 != null) {
                                                                                                                        i = R.id.indian_father_spinner;
                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.indian_father_spinner);
                                                                                                                        if (textView10 != null) {
                                                                                                                            i = R.id.indian_mother_spinner;
                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.indian_mother_spinner);
                                                                                                                            if (textView11 != null) {
                                                                                                                                i = R.id.indian_parent_mother_tv;
                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.indian_parent_mother_tv);
                                                                                                                                if (textView12 != null) {
                                                                                                                                    i = R.id.indian_parent_tv;
                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.indian_parent_tv);
                                                                                                                                    if (textView13 != null) {
                                                                                                                                        i = R.id.indian_parent_tv2;
                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.indian_parent_tv2);
                                                                                                                                        if (textView14 != null) {
                                                                                                                                            i = R.id.indian_parent_tv_mother;
                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.indian_parent_tv_mother);
                                                                                                                                            if (textView15 != null) {
                                                                                                                                                i = R.id.indianparentRG;
                                                                                                                                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.indianparentRG);
                                                                                                                                                if (radioGroup != null) {
                                                                                                                                                    i = R.id.indianparentRG_between;
                                                                                                                                                    RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.indianparentRG_between);
                                                                                                                                                    if (radioGroup2 != null) {
                                                                                                                                                        i = R.id.ll_anxure_declaration;
                                                                                                                                                        LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_anxure_declaration);
                                                                                                                                                        if (linearLayout12 != null) {
                                                                                                                                                            i = R.id.non_indian_parent_tv;
                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.non_indian_parent_tv);
                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                i = R.id.non_indian_parent_tv2;
                                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.non_indian_parent_tv2);
                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                    i = R.id.parent_father_rb;
                                                                                                                                                                    RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.parent_father_rb);
                                                                                                                                                                    if (radioButton4 != null) {
                                                                                                                                                                        i = R.id.parent_father_rb_between;
                                                                                                                                                                        RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.parent_father_rb_between);
                                                                                                                                                                        if (radioButton5 != null) {
                                                                                                                                                                            i = R.id.parent_Mother_rb;
                                                                                                                                                                            RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.parent_Mother_rb);
                                                                                                                                                                            if (radioButton6 != null) {
                                                                                                                                                                                i = R.id.parent_Mother_rb_between;
                                                                                                                                                                                RadioButton radioButton7 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.parent_Mother_rb_between);
                                                                                                                                                                                if (radioButton7 != null) {
                                                                                                                                                                                    i = R.id.parent_no_rb;
                                                                                                                                                                                    RadioButton radioButton8 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.parent_no_rb);
                                                                                                                                                                                    if (radioButton8 != null) {
                                                                                                                                                                                        i = R.id.parentRG;
                                                                                                                                                                                        RadioGroup radioGroup3 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.parentRG);
                                                                                                                                                                                        if (radioGroup3 != null) {
                                                                                                                                                                                            i = R.id.parent_spinner_between;
                                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.parent_spinner_between);
                                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                                i = R.id.parent_yes_rb;
                                                                                                                                                                                                RadioButton radioButton9 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.parent_yes_rb);
                                                                                                                                                                                                if (radioButton9 != null) {
                                                                                                                                                                                                    i = R.id.radioGroupAnnexure;
                                                                                                                                                                                                    RadioGroup radioGroup4 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.radioGroupAnnexure);
                                                                                                                                                                                                    if (radioGroup4 != null) {
                                                                                                                                                                                                        i = R.id.select_both_parent_layout;
                                                                                                                                                                                                        LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.select_both_parent_layout);
                                                                                                                                                                                                        if (linearLayout13 != null) {
                                                                                                                                                                                                            i = R.id.select_parent_layout;
                                                                                                                                                                                                            LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.select_parent_layout);
                                                                                                                                                                                                            if (linearLayout14 != null) {
                                                                                                                                                                                                                i = R.id.select_parent_layout_between;
                                                                                                                                                                                                                LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.select_parent_layout_between);
                                                                                                                                                                                                                if (linearLayout15 != null) {
                                                                                                                                                                                                                    i = R.id.sign_image;
                                                                                                                                                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.sign_image);
                                                                                                                                                                                                                    if (imageView6 != null) {
                                                                                                                                                                                                                        i = R.id.sign_name;
                                                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sign_name);
                                                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                                                            return new BloFragmentAnnexureFormBinding((LinearLayout) rootView, textView, textView2, textView3, imageView, imageView2, imageView3, imageView4, linearLayout, linearLayout2, linearLayout3, linearLayout4, textView4, imageView5, textView5, textView6, textView7, textView8, textView9, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, radioButton, radioButton2, radioButton3, textView10, textView11, textView12, textView13, textView14, textView15, radioGroup, radioGroup2, linearLayout12, textView16, textView17, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioGroup3, textView18, radioButton9, radioGroup4, linearLayout13, linearLayout14, linearLayout15, imageView6, textView19);
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
