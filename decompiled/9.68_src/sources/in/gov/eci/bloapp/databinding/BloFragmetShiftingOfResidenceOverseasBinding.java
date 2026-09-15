package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
public final class BloFragmetShiftingOfResidenceOverseasBinding implements ViewBinding {
    public final CardView BtnCardView;
    public final RadioButton COR;
    public final EditText OtherAddProof;
    public final TextView POR;
    public final RadioButton SOR;
    public final TextView SORstatement;
    public final NoDefaultSpinner addProofSpinner;
    public final ImageView backBtnIv;
    public final ConstraintLayout bottomSubmitLayout2;
    public final Button chooseFile;
    public final ImageButton chooseFileDeletion;
    public final TextView chooseFileName;
    public final TextView chooseFileNameSize;
    public final ConstraintLayout constraintLayout2;
    public final EditText districtSorEditTv;
    public final ImageView homeBtnIv;
    public final EditText houseET;
    public final AutoCompleteTextView houseEteng;
    public final LinearLayout otherDocSorLl;
    public final EditText pincodeET;
    public final EditText postofficeSpinner;
    public final AutoCompleteTextView postofficeSpinnereng;
    public final ImageView preview;
    public final RadioGroup radiogroupSubmitApplication;
    public final TextView refNoTv;
    public final TextView resetBtn;
    private final ConstraintLayout rootView;
    public final CardView shiftingDetsilsEdit;
    public final EditText stateSorEditTv;
    public final EditText streetET;
    public final AutoCompleteTextView streetETeng;
    public final TextView submitTv2;
    public final EditText tehsilMandala;
    public final AutoCompleteTextView tehsilMandalaeng;
    public final TextView textView23;
    public final TextView textView26;
    public final TextView textView33;
    public final EditText townVillage;
    public final AutoCompleteTextView townVillageeng;

    private BloFragmetShiftingOfResidenceOverseasBinding(ConstraintLayout rootView, CardView BtnCardView, RadioButton COR, EditText OtherAddProof, TextView POR, RadioButton SOR, TextView SORstatement, NoDefaultSpinner addProofSpinner, ImageView backBtnIv, ConstraintLayout bottomSubmitLayout2, Button chooseFile, ImageButton chooseFileDeletion, TextView chooseFileName, TextView chooseFileNameSize, ConstraintLayout constraintLayout2, EditText districtSorEditTv, ImageView homeBtnIv, EditText houseET, AutoCompleteTextView houseEteng, LinearLayout otherDocSorLl, EditText pincodeET, EditText postofficeSpinner, AutoCompleteTextView postofficeSpinnereng, ImageView preview, RadioGroup radiogroupSubmitApplication, TextView refNoTv, TextView resetBtn, CardView shiftingDetsilsEdit, EditText stateSorEditTv, EditText streetET, AutoCompleteTextView streetETeng, TextView submitTv2, EditText tehsilMandala, AutoCompleteTextView tehsilMandalaeng, TextView textView23, TextView textView26, TextView textView33, EditText townVillage, AutoCompleteTextView townVillageeng) {
        this.rootView = rootView;
        this.BtnCardView = BtnCardView;
        this.COR = COR;
        this.OtherAddProof = OtherAddProof;
        this.POR = POR;
        this.SOR = SOR;
        this.SORstatement = SORstatement;
        this.addProofSpinner = addProofSpinner;
        this.backBtnIv = backBtnIv;
        this.bottomSubmitLayout2 = bottomSubmitLayout2;
        this.chooseFile = chooseFile;
        this.chooseFileDeletion = chooseFileDeletion;
        this.chooseFileName = chooseFileName;
        this.chooseFileNameSize = chooseFileNameSize;
        this.constraintLayout2 = constraintLayout2;
        this.districtSorEditTv = districtSorEditTv;
        this.homeBtnIv = homeBtnIv;
        this.houseET = houseET;
        this.houseEteng = houseEteng;
        this.otherDocSorLl = otherDocSorLl;
        this.pincodeET = pincodeET;
        this.postofficeSpinner = postofficeSpinner;
        this.postofficeSpinnereng = postofficeSpinnereng;
        this.preview = preview;
        this.radiogroupSubmitApplication = radiogroupSubmitApplication;
        this.refNoTv = refNoTv;
        this.resetBtn = resetBtn;
        this.shiftingDetsilsEdit = shiftingDetsilsEdit;
        this.stateSorEditTv = stateSorEditTv;
        this.streetET = streetET;
        this.streetETeng = streetETeng;
        this.submitTv2 = submitTv2;
        this.tehsilMandala = tehsilMandala;
        this.tehsilMandalaeng = tehsilMandalaeng;
        this.textView23 = textView23;
        this.textView26 = textView26;
        this.textView33 = textView33;
        this.townVillage = townVillage;
        this.townVillageeng = townVillageeng;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmetShiftingOfResidenceOverseasBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmetShiftingOfResidenceOverseasBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragmet_shifting_of_residence_overseas, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmetShiftingOfResidenceOverseasBinding bind(View rootView) {
        int i = R.id.BtnCardView;
        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.BtnCardView);
        if (cardViewFindChildViewById != null) {
            i = R.id.COR;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.COR);
            if (radioButton != null) {
                i = R.id.Other_add_proof;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.Other_add_proof);
                if (editText != null) {
                    i = R.id.POR;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.POR);
                    if (textView != null) {
                        i = R.id.SOR;
                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.SOR);
                        if (radioButton2 != null) {
                            i = R.id.SORstatement;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.SORstatement);
                            if (textView2 != null) {
                                i = R.id.add_proof_spinner;
                                NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.add_proof_spinner);
                                if (noDefaultSpinner != null) {
                                    i = R.id.back_btn_iv;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                                    if (imageView != null) {
                                        i = R.id.bottom_submit_layout2;
                                        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_submit_layout2);
                                        if (constraintLayoutFindChildViewById != null) {
                                            i = R.id.choose_file;
                                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.choose_file);
                                            if (button != null) {
                                                i = R.id.choose_file_deletion;
                                                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.choose_file_deletion);
                                                if (imageButton != null) {
                                                    i = R.id.choose_file_name;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_name);
                                                    if (textView3 != null) {
                                                        i = R.id.choose_file_name_size;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_name_size);
                                                        if (textView4 != null) {
                                                            i = R.id.constraintLayout2;
                                                            ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.constraintLayout2);
                                                            if (constraintLayoutFindChildViewById2 != null) {
                                                                i = R.id.district_sor_edit_tv;
                                                                EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.district_sor_edit_tv);
                                                                if (editText2 != null) {
                                                                    i = R.id.home_btn_iv;
                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                                                                    if (imageView2 != null) {
                                                                        i = R.id.house_ET;
                                                                        EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.house_ET);
                                                                        if (editText3 != null) {
                                                                            i = R.id.house_Eteng;
                                                                            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.house_Eteng);
                                                                            if (autoCompleteTextView != null) {
                                                                                i = R.id.other_doc_sor_ll;
                                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.other_doc_sor_ll);
                                                                                if (linearLayout != null) {
                                                                                    i = R.id.pincode_ET;
                                                                                    EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.pincode_ET);
                                                                                    if (editText4 != null) {
                                                                                        i = R.id.postoffice_spinner;
                                                                                        EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.postoffice_spinner);
                                                                                        if (editText5 != null) {
                                                                                            i = R.id.postoffice_spinnereng;
                                                                                            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.postoffice_spinnereng);
                                                                                            if (autoCompleteTextView2 != null) {
                                                                                                i = R.id.preview;
                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.preview);
                                                                                                if (imageView3 != null) {
                                                                                                    i = R.id.radiogroup_submit_application;
                                                                                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.radiogroup_submit_application);
                                                                                                    if (radioGroup != null) {
                                                                                                        i = R.id.ref_no_tv;
                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ref_no_tv);
                                                                                                        if (textView5 != null) {
                                                                                                            i = R.id.reset_btn;
                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.reset_btn);
                                                                                                            if (textView6 != null) {
                                                                                                                i = R.id.shifting_detsils_edit;
                                                                                                                CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.shifting_detsils_edit);
                                                                                                                if (cardViewFindChildViewById2 != null) {
                                                                                                                    i = R.id.state_sor_edit_tv;
                                                                                                                    EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.state_sor_edit_tv);
                                                                                                                    if (editText6 != null) {
                                                                                                                        i = R.id.street_ET;
                                                                                                                        EditText editText7 = (EditText) ViewBindings.findChildViewById(rootView, R.id.street_ET);
                                                                                                                        if (editText7 != null) {
                                                                                                                            i = R.id.street_ETeng;
                                                                                                                            AutoCompleteTextView autoCompleteTextView3 = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.street_ETeng);
                                                                                                                            if (autoCompleteTextView3 != null) {
                                                                                                                                i = R.id.submit_tv2;
                                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submit_tv2);
                                                                                                                                if (textView7 != null) {
                                                                                                                                    i = R.id.tehsil_mandala;
                                                                                                                                    EditText editText8 = (EditText) ViewBindings.findChildViewById(rootView, R.id.tehsil_mandala);
                                                                                                                                    if (editText8 != null) {
                                                                                                                                        i = R.id.tehsil_mandalaeng;
                                                                                                                                        AutoCompleteTextView autoCompleteTextView4 = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.tehsil_mandalaeng);
                                                                                                                                        if (autoCompleteTextView4 != null) {
                                                                                                                                            i = R.id.textView23;
                                                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView23);
                                                                                                                                            if (textView8 != null) {
                                                                                                                                                i = R.id.textView26;
                                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView26);
                                                                                                                                                if (textView9 != null) {
                                                                                                                                                    i = R.id.textView33;
                                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView33);
                                                                                                                                                    if (textView10 != null) {
                                                                                                                                                        i = R.id.town_village;
                                                                                                                                                        EditText editText9 = (EditText) ViewBindings.findChildViewById(rootView, R.id.town_village);
                                                                                                                                                        if (editText9 != null) {
                                                                                                                                                            i = R.id.town_villageeng;
                                                                                                                                                            AutoCompleteTextView autoCompleteTextView5 = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.town_villageeng);
                                                                                                                                                            if (autoCompleteTextView5 != null) {
                                                                                                                                                                return new BloFragmetShiftingOfResidenceOverseasBinding((ConstraintLayout) rootView, cardViewFindChildViewById, radioButton, editText, textView, radioButton2, textView2, noDefaultSpinner, imageView, constraintLayoutFindChildViewById, button, imageButton, textView3, textView4, constraintLayoutFindChildViewById2, editText2, imageView2, editText3, autoCompleteTextView, linearLayout, editText4, editText5, autoCompleteTextView2, imageView3, radioGroup, textView5, textView6, cardViewFindChildViewById2, editText6, editText7, autoCompleteTextView3, textView7, editText8, autoCompleteTextView4, textView8, textView9, textView10, editText9, autoCompleteTextView5);
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
