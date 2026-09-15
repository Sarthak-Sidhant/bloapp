package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloDeclarationFormBinding implements ViewBinding {
    public final CardView bloSigncardview;
    public final CardView cdDfRelativeCardView;
    public final CardView cdDfSelfCardView;
    public final Button chooseFile;
    public final ImageButton chooseFileDeletion;
    public final TextView chooseFileName;
    public final TextView chooseFileNameSize;
    public final CardView cvDfGeneralDetails;
    public final CardView cvDfradioCardView;
    public final LinearLayout declarationFormLayout;
    public final LinearLayout declarationformSign;
    public final EditText dfETfatherEpicNumber;
    public final EditText dfETfatherName;
    public final EditText dfETmotherEpicNumber;
    public final EditText dfETmotherName;
    public final TextInputEditText dfETspouseEpicNumber;
    public final EditText dfETspouseName;
    public final RadioGroup dfElectorPresentRG;
    public final TextView dfIvAddSelf;
    public final ImageView dfIvSearchFather;
    public final ImageView dfIvspeakMotherName;
    public final ImageView dfIvspeakSpouseName;
    public final LinearLayout dfLlElectorPresent;
    public final RadioButton dfRB2003;
    public final RadioButton dfRB2025;
    public final RadioButton dfRBneitherRb;
    public final RadioButton dfRBprogenyRb;
    public final RadioButton dfRBselfRb;
    public final RadioGroup dfRgsearchRG;
    public final TextView dfTvivAddProgeny;
    public final TextView dfTvivDelete;
    public final TextView dfTvivDeleteProgeny;
    public final TextView dfTvivUpdate;
    public final TextView dfTvivUpdateProgeny;
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
    public final ImageView dfivSearchMother;
    public final ImageView dfivSearchSpouse;
    public final ImageView ivspeakFatherName;
    public final LinearLayout llDfAddSelf;
    public final LinearLayout llDfProginy;
    public final ImageView preview;
    public final Spinner progenyRelationSpinner;
    public final CardView relationtypecardview;
    private final LinearLayout rootView;
    public final TextView tabTV;

    private BloDeclarationFormBinding(LinearLayout rootView, CardView bloSigncardview, CardView cdDfRelativeCardView, CardView cdDfSelfCardView, Button chooseFile, ImageButton chooseFileDeletion, TextView chooseFileName, TextView chooseFileNameSize, CardView cvDfGeneralDetails, CardView cvDfradioCardView, LinearLayout declarationFormLayout, LinearLayout declarationformSign, EditText dfETfatherEpicNumber, EditText dfETfatherName, EditText dfETmotherEpicNumber, EditText dfETmotherName, TextInputEditText dfETspouseEpicNumber, EditText dfETspouseName, RadioGroup dfElectorPresentRG, TextView dfIvAddSelf, ImageView dfIvSearchFather, ImageView dfIvspeakMotherName, ImageView dfIvspeakSpouseName, LinearLayout dfLlElectorPresent, RadioButton dfRB2003, RadioButton dfRB2025, RadioButton dfRBneitherRb, RadioButton dfRBprogenyRb, RadioButton dfRBselfRb, RadioGroup dfRgsearchRG, TextView dfTvivAddProgeny, TextView dfTvivDelete, TextView dfTvivDeleteProgeny, TextView dfTvivUpdate, TextView dfTvivUpdateProgeny, TextView dfTvtvAcName, TextView dfTvtvAcNo, TextView dfTvtvEpic, TextView dfTvtvName, TextView dfTvtvName1, TextView dfTvtvPartNo, TextView dfTvtvRelation, TextView dfTvtvRlAcName, TextView dfTvtvRlAcNo, TextView dfTvtvRlEpic, TextView dfTvtvRlName, TextView dfTvtvRlName1, TextView dfTvtvRlPartNo, TextView dfTvtvRlRelation, TextView dfTvtvRlSrNo, TextView dfTvtvRlState, TextView dfTvtvSrNo, TextView dfTvtvState, ImageView dfivSearchMother, ImageView dfivSearchSpouse, ImageView ivspeakFatherName, LinearLayout llDfAddSelf, LinearLayout llDfProginy, ImageView preview, Spinner progenyRelationSpinner, CardView relationtypecardview, TextView tabTV) {
        this.rootView = rootView;
        this.bloSigncardview = bloSigncardview;
        this.cdDfRelativeCardView = cdDfRelativeCardView;
        this.cdDfSelfCardView = cdDfSelfCardView;
        this.chooseFile = chooseFile;
        this.chooseFileDeletion = chooseFileDeletion;
        this.chooseFileName = chooseFileName;
        this.chooseFileNameSize = chooseFileNameSize;
        this.cvDfGeneralDetails = cvDfGeneralDetails;
        this.cvDfradioCardView = cvDfradioCardView;
        this.declarationFormLayout = declarationFormLayout;
        this.declarationformSign = declarationformSign;
        this.dfETfatherEpicNumber = dfETfatherEpicNumber;
        this.dfETfatherName = dfETfatherName;
        this.dfETmotherEpicNumber = dfETmotherEpicNumber;
        this.dfETmotherName = dfETmotherName;
        this.dfETspouseEpicNumber = dfETspouseEpicNumber;
        this.dfETspouseName = dfETspouseName;
        this.dfElectorPresentRG = dfElectorPresentRG;
        this.dfIvAddSelf = dfIvAddSelf;
        this.dfIvSearchFather = dfIvSearchFather;
        this.dfIvspeakMotherName = dfIvspeakMotherName;
        this.dfIvspeakSpouseName = dfIvspeakSpouseName;
        this.dfLlElectorPresent = dfLlElectorPresent;
        this.dfRB2003 = dfRB2003;
        this.dfRB2025 = dfRB2025;
        this.dfRBneitherRb = dfRBneitherRb;
        this.dfRBprogenyRb = dfRBprogenyRb;
        this.dfRBselfRb = dfRBselfRb;
        this.dfRgsearchRG = dfRgsearchRG;
        this.dfTvivAddProgeny = dfTvivAddProgeny;
        this.dfTvivDelete = dfTvivDelete;
        this.dfTvivDeleteProgeny = dfTvivDeleteProgeny;
        this.dfTvivUpdate = dfTvivUpdate;
        this.dfTvivUpdateProgeny = dfTvivUpdateProgeny;
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
        this.dfivSearchMother = dfivSearchMother;
        this.dfivSearchSpouse = dfivSearchSpouse;
        this.ivspeakFatherName = ivspeakFatherName;
        this.llDfAddSelf = llDfAddSelf;
        this.llDfProginy = llDfProginy;
        this.preview = preview;
        this.progenyRelationSpinner = progenyRelationSpinner;
        this.relationtypecardview = relationtypecardview;
        this.tabTV = tabTV;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloDeclarationFormBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloDeclarationFormBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_declaration_form, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloDeclarationFormBinding bind(View rootView) {
        int i = R.id.bloSigncardview;
        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bloSigncardview);
        if (cardViewFindChildViewById != null) {
            i = R.id.cdDfRelativeCardView;
            CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.cdDfRelativeCardView);
            if (cardViewFindChildViewById2 != null) {
                i = R.id.cdDfSelfCardView;
                CardView cardViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.cdDfSelfCardView);
                if (cardViewFindChildViewById3 != null) {
                    i = R.id.choose_file;
                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.choose_file);
                    if (button != null) {
                        i = R.id.choose_file_deletion;
                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.choose_file_deletion);
                        if (imageButton != null) {
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
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.declarationFormLayout);
                                            if (linearLayout != null) {
                                                i = R.id.declarationform_sign;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.declarationform_sign);
                                                if (linearLayout2 != null) {
                                                    i = R.id.dfETfatherEpicNumber;
                                                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.dfETfatherEpicNumber);
                                                    if (editText != null) {
                                                        i = R.id.dfETfatherName;
                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.dfETfatherName);
                                                        if (editText2 != null) {
                                                            i = R.id.dfETmotherEpicNumber;
                                                            EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.dfETmotherEpicNumber);
                                                            if (editText3 != null) {
                                                                i = R.id.dfETmotherName;
                                                                EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.dfETmotherName);
                                                                if (editText4 != null) {
                                                                    i = R.id.dfETspouseEpicNumber;
                                                                    TextInputEditText textInputEditTextFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.dfETspouseEpicNumber);
                                                                    if (textInputEditTextFindChildViewById != null) {
                                                                        i = R.id.dfETspouseName;
                                                                        EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.dfETspouseName);
                                                                        if (editText5 != null) {
                                                                            i = R.id.dfElectorPresentRG;
                                                                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.dfElectorPresentRG);
                                                                            if (radioGroup != null) {
                                                                                i = R.id.dfIv_add_self;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfIv_add_self);
                                                                                if (textView3 != null) {
                                                                                    i = R.id.dfIv_search_father;
                                                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dfIv_search_father);
                                                                                    if (imageView != null) {
                                                                                        i = R.id.dfIvspeak_motherName;
                                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dfIvspeak_motherName);
                                                                                        if (imageView2 != null) {
                                                                                            i = R.id.dfIvspeak_spouseName;
                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dfIvspeak_spouseName);
                                                                                            if (imageView3 != null) {
                                                                                                i = R.id.dfLl_electorPresent;
                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.dfLl_electorPresent);
                                                                                                if (linearLayout3 != null) {
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
                                                                                                                            i = R.id.dfTviv_add_progeny;
                                                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTviv_add_progeny);
                                                                                                                            if (textView4 != null) {
                                                                                                                                i = R.id.dfTviv_delete;
                                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTviv_delete);
                                                                                                                                if (textView5 != null) {
                                                                                                                                    i = R.id.dfTviv_delete_progeny;
                                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTviv_delete_progeny);
                                                                                                                                    if (textView6 != null) {
                                                                                                                                        i = R.id.dfTviv_update;
                                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTviv_update);
                                                                                                                                        if (textView7 != null) {
                                                                                                                                            i = R.id.dfTviv_update_progeny;
                                                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dfTviv_update_progeny);
                                                                                                                                            if (textView8 != null) {
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
                                                                                                                                                                                                                        i = R.id.dfiv_search_mother;
                                                                                                                                                                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dfiv_search_mother);
                                                                                                                                                                                                                        if (imageView4 != null) {
                                                                                                                                                                                                                            i = R.id.dfiv_search_spouse;
                                                                                                                                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dfiv_search_spouse);
                                                                                                                                                                                                                            if (imageView5 != null) {
                                                                                                                                                                                                                                i = R.id.ivspeak_fatherName;
                                                                                                                                                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivspeak_fatherName);
                                                                                                                                                                                                                                if (imageView6 != null) {
                                                                                                                                                                                                                                    i = R.id.llDfAddSelf;
                                                                                                                                                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llDfAddSelf);
                                                                                                                                                                                                                                    if (linearLayout4 != null) {
                                                                                                                                                                                                                                        i = R.id.llDfProginy;
                                                                                                                                                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llDfProginy);
                                                                                                                                                                                                                                        if (linearLayout5 != null) {
                                                                                                                                                                                                                                            i = R.id.preview;
                                                                                                                                                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.preview);
                                                                                                                                                                                                                                            if (imageView7 != null) {
                                                                                                                                                                                                                                                i = R.id.progenyRelationSpinner;
                                                                                                                                                                                                                                                Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.progenyRelationSpinner);
                                                                                                                                                                                                                                                if (spinner != null) {
                                                                                                                                                                                                                                                    i = R.id.relationtypecardview;
                                                                                                                                                                                                                                                    CardView cardViewFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.relationtypecardview);
                                                                                                                                                                                                                                                    if (cardViewFindChildViewById6 != null) {
                                                                                                                                                                                                                                                        i = R.id.tabTV;
                                                                                                                                                                                                                                                        TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tabTV);
                                                                                                                                                                                                                                                        if (textView27 != null) {
                                                                                                                                                                                                                                                            return new BloDeclarationFormBinding((LinearLayout) rootView, cardViewFindChildViewById, cardViewFindChildViewById2, cardViewFindChildViewById3, button, imageButton, textView, textView2, cardViewFindChildViewById4, cardViewFindChildViewById5, linearLayout, linearLayout2, editText, editText2, editText3, editText4, textInputEditTextFindChildViewById, editText5, radioGroup, textView3, imageView, imageView2, imageView3, linearLayout3, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioGroup2, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, imageView4, imageView5, imageView6, linearLayout4, linearLayout5, imageView7, spinner, cardViewFindChildViewById6, textView27);
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
