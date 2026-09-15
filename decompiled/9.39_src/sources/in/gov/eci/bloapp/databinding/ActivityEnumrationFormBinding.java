package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityEnumrationFormBinding implements ViewBinding {
    public final LinearLayout aadharLayout;
    public final EditText aadharNumber;
    public final LinearLayout annexPage1Layout;
    public final ImageView backBtnIv;
    public final RelativeLayout basicdetailsHeading;
    public final ConstraintLayout blaTopLayout;
    public final ImageView cancel;
    public final ImageView cancelPhoto1Annexure;
    public final ImageView cancelPhoto2Annexure;
    public final TextView chooseFileTv;
    public final EditText dateOfBirth;
    public final LinearLayout dobLayout;
    public final CardView electorPhotoLayout;
    public final EditText fatherEpicNumber;
    public final EditText fatherName;
    public final ImageView image;
    public final ImageView ivSearchFather;
    public final ImageView ivSearchMother;
    public final ImageView ivSearchSpouse;
    public final LinearLayout main;
    public final LinearLayout mainLayout;
    public final LinearLayout matchingLayout;
    public final EditText mobileNumber;
    public final EditText motherEpicNumber;
    public final EditText motherName;
    public final LinearLayout passPhoto;
    public final LinearLayout passPhotoLayout;
    public final ImageView photo1;
    public final TextView photo1Annexure;
    public final TextView photo1Name;
    public final TextView photo1Size;
    public final ImageView photo2;
    public final TextView photo2Annexure;
    public final LinearLayout photo2Layout;
    public final TextView photo2Name;
    public final TextView photo2Size;
    public final TextView photoNameTv2;
    public final TextView photoSize;
    public final Spinner progenyRelationSpinner;
    public final ProgressBar progressBar;
    public final CardView relationtypecardview;
    public final CardView relativeCardView;
    private final LinearLayout rootView;
    public final CardView selfCardView;
    public final ImageView speakFatherName;
    public final ImageView speakMotherName;
    public final ImageView speakSpouseName;
    public final TextInputEditText spouseEpicNumber;
    public final EditText spouseName;
    public final Button submitButtonRec;
    public final LinearLayout submitLayout;
    public final TextView textView3;
    public final TextView textView5;
    public final ImageView toolbarButton;
    public final TextView tvAcName;
    public final TextView tvAcNo;
    public final TextView tvEpic;
    public final TextView tvLeftName;
    public final TextView tvName;
    public final TextView tvName1;
    public final TextView tvPartNo;
    public final TextView tvRelation;
    public final TextView tvRightName;
    public final TextView tvRlAcName;
    public final TextView tvRlAcNo;
    public final TextView tvRlEpic;
    public final TextView tvRlName;
    public final TextView tvRlName1;
    public final TextView tvRlPartNo;
    public final TextView tvRlRelation;
    public final TextView tvRlSrNo;
    public final TextView tvRlState;
    public final TextView tvSrNo;
    public final TextView tvState;

    private ActivityEnumrationFormBinding(LinearLayout rootView, LinearLayout aadharLayout, EditText aadharNumber, LinearLayout annexPage1Layout, ImageView backBtnIv, RelativeLayout basicdetailsHeading, ConstraintLayout blaTopLayout, ImageView cancel, ImageView cancelPhoto1Annexure, ImageView cancelPhoto2Annexure, TextView chooseFileTv, EditText dateOfBirth, LinearLayout dobLayout, CardView electorPhotoLayout, EditText fatherEpicNumber, EditText fatherName, ImageView image, ImageView ivSearchFather, ImageView ivSearchMother, ImageView ivSearchSpouse, LinearLayout main, LinearLayout mainLayout, LinearLayout matchingLayout, EditText mobileNumber, EditText motherEpicNumber, EditText motherName, LinearLayout passPhoto, LinearLayout passPhotoLayout, ImageView photo1, TextView photo1Annexure, TextView photo1Name, TextView photo1Size, ImageView photo2, TextView photo2Annexure, LinearLayout photo2Layout, TextView photo2Name, TextView photo2Size, TextView photoNameTv2, TextView photoSize, Spinner progenyRelationSpinner, ProgressBar progressBar, CardView relationtypecardview, CardView relativeCardView, CardView selfCardView, ImageView speakFatherName, ImageView speakMotherName, ImageView speakSpouseName, TextInputEditText spouseEpicNumber, EditText spouseName, Button submitButtonRec, LinearLayout submitLayout, TextView textView3, TextView textView5, ImageView toolbarButton, TextView tvAcName, TextView tvAcNo, TextView tvEpic, TextView tvLeftName, TextView tvName, TextView tvName1, TextView tvPartNo, TextView tvRelation, TextView tvRightName, TextView tvRlAcName, TextView tvRlAcNo, TextView tvRlEpic, TextView tvRlName, TextView tvRlName1, TextView tvRlPartNo, TextView tvRlRelation, TextView tvRlSrNo, TextView tvRlState, TextView tvSrNo, TextView tvState) {
        this.rootView = rootView;
        this.aadharLayout = aadharLayout;
        this.aadharNumber = aadharNumber;
        this.annexPage1Layout = annexPage1Layout;
        this.backBtnIv = backBtnIv;
        this.basicdetailsHeading = basicdetailsHeading;
        this.blaTopLayout = blaTopLayout;
        this.cancel = cancel;
        this.cancelPhoto1Annexure = cancelPhoto1Annexure;
        this.cancelPhoto2Annexure = cancelPhoto2Annexure;
        this.chooseFileTv = chooseFileTv;
        this.dateOfBirth = dateOfBirth;
        this.dobLayout = dobLayout;
        this.electorPhotoLayout = electorPhotoLayout;
        this.fatherEpicNumber = fatherEpicNumber;
        this.fatherName = fatherName;
        this.image = image;
        this.ivSearchFather = ivSearchFather;
        this.ivSearchMother = ivSearchMother;
        this.ivSearchSpouse = ivSearchSpouse;
        this.main = main;
        this.mainLayout = mainLayout;
        this.matchingLayout = matchingLayout;
        this.mobileNumber = mobileNumber;
        this.motherEpicNumber = motherEpicNumber;
        this.motherName = motherName;
        this.passPhoto = passPhoto;
        this.passPhotoLayout = passPhotoLayout;
        this.photo1 = photo1;
        this.photo1Annexure = photo1Annexure;
        this.photo1Name = photo1Name;
        this.photo1Size = photo1Size;
        this.photo2 = photo2;
        this.photo2Annexure = photo2Annexure;
        this.photo2Layout = photo2Layout;
        this.photo2Name = photo2Name;
        this.photo2Size = photo2Size;
        this.photoNameTv2 = photoNameTv2;
        this.photoSize = photoSize;
        this.progenyRelationSpinner = progenyRelationSpinner;
        this.progressBar = progressBar;
        this.relationtypecardview = relationtypecardview;
        this.relativeCardView = relativeCardView;
        this.selfCardView = selfCardView;
        this.speakFatherName = speakFatherName;
        this.speakMotherName = speakMotherName;
        this.speakSpouseName = speakSpouseName;
        this.spouseEpicNumber = spouseEpicNumber;
        this.spouseName = spouseName;
        this.submitButtonRec = submitButtonRec;
        this.submitLayout = submitLayout;
        this.textView3 = textView3;
        this.textView5 = textView5;
        this.toolbarButton = toolbarButton;
        this.tvAcName = tvAcName;
        this.tvAcNo = tvAcNo;
        this.tvEpic = tvEpic;
        this.tvLeftName = tvLeftName;
        this.tvName = tvName;
        this.tvName1 = tvName1;
        this.tvPartNo = tvPartNo;
        this.tvRelation = tvRelation;
        this.tvRightName = tvRightName;
        this.tvRlAcName = tvRlAcName;
        this.tvRlAcNo = tvRlAcNo;
        this.tvRlEpic = tvRlEpic;
        this.tvRlName = tvRlName;
        this.tvRlName1 = tvRlName1;
        this.tvRlPartNo = tvRlPartNo;
        this.tvRlRelation = tvRlRelation;
        this.tvRlSrNo = tvRlSrNo;
        this.tvRlState = tvRlState;
        this.tvSrNo = tvSrNo;
        this.tvState = tvState;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityEnumrationFormBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityEnumrationFormBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_enumration_form, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityEnumrationFormBinding bind(View rootView) {
        int i = R.id.aadharLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.aadharLayout);
        if (linearLayout != null) {
            i = R.id.aadharNumber;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.aadharNumber);
            if (editText != null) {
                i = R.id.annexPage1Layout;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.annexPage1Layout);
                if (linearLayout2 != null) {
                    i = R.id.back_btn_iv;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                    if (imageView != null) {
                        i = R.id.basicdetails_heading;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.basicdetails_heading);
                        if (relativeLayout != null) {
                            i = R.id.bla_top_layout;
                            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
                            if (constraintLayoutFindChildViewById != null) {
                                i = R.id.cancel;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel);
                                if (imageView2 != null) {
                                    i = R.id.cancel_photo1_annexure;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel_photo1_annexure);
                                    if (imageView3 != null) {
                                        i = R.id.cancel_photo2_annexure;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel_photo2_annexure);
                                        if (imageView4 != null) {
                                            i = R.id.choose_file_tv;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_tv);
                                            if (textView != null) {
                                                i = R.id.dateOfBirth;
                                                EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.dateOfBirth);
                                                if (editText2 != null) {
                                                    i = R.id.dobLayout;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.dobLayout);
                                                    if (linearLayout3 != null) {
                                                        i = R.id.elector_photo_layout;
                                                        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.elector_photo_layout);
                                                        if (cardViewFindChildViewById != null) {
                                                            i = R.id.fatherEpicNumber;
                                                            EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.fatherEpicNumber);
                                                            if (editText3 != null) {
                                                                i = R.id.fatherName;
                                                                EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.fatherName);
                                                                if (editText4 != null) {
                                                                    i = 2131364126;
                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, 2131364126);
                                                                    if (imageView5 != null) {
                                                                        i = R.id.iv_search_father;
                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_search_father);
                                                                        if (imageView6 != null) {
                                                                            i = R.id.iv_search_mother;
                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_search_mother);
                                                                            if (imageView7 != null) {
                                                                                i = R.id.iv_search_spouse;
                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_search_spouse);
                                                                                if (imageView8 != null) {
                                                                                    LinearLayout linearLayout4 = (LinearLayout) rootView;
                                                                                    i = R.id.mainLayout;
                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainLayout);
                                                                                    if (linearLayout5 != null) {
                                                                                        i = R.id.matchingLayout;
                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.matchingLayout);
                                                                                        if (linearLayout6 != null) {
                                                                                            i = R.id.mobileNumber;
                                                                                            EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobileNumber);
                                                                                            if (editText5 != null) {
                                                                                                i = R.id.motherEpicNumber;
                                                                                                EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.motherEpicNumber);
                                                                                                if (editText6 != null) {
                                                                                                    i = R.id.motherName;
                                                                                                    EditText editText7 = (EditText) ViewBindings.findChildViewById(rootView, R.id.motherName);
                                                                                                    if (editText7 != null) {
                                                                                                        i = R.id.passPhoto;
                                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.passPhoto);
                                                                                                        if (linearLayout7 != null) {
                                                                                                            i = R.id.pass_photo_layout;
                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pass_photo_layout);
                                                                                                            if (linearLayout8 != null) {
                                                                                                                i = R.id.photo1;
                                                                                                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.photo1);
                                                                                                                if (imageView9 != null) {
                                                                                                                    i = R.id.photo1_annexure;
                                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo1_annexure);
                                                                                                                    if (textView2 != null) {
                                                                                                                        i = R.id.photo1_name;
                                                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo1_name);
                                                                                                                        if (textView3 != null) {
                                                                                                                            i = R.id.photo1_size;
                                                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo1_size);
                                                                                                                            if (textView4 != null) {
                                                                                                                                i = R.id.photo2;
                                                                                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.photo2);
                                                                                                                                if (imageView10 != null) {
                                                                                                                                    i = R.id.photo2_annexure;
                                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo2_annexure);
                                                                                                                                    if (textView5 != null) {
                                                                                                                                        i = R.id.photo2Layout;
                                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.photo2Layout);
                                                                                                                                        if (linearLayout9 != null) {
                                                                                                                                            i = R.id.photo2_name;
                                                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo2_name);
                                                                                                                                            if (textView6 != null) {
                                                                                                                                                i = R.id.photo2_size;
                                                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo2_size);
                                                                                                                                                if (textView7 != null) {
                                                                                                                                                    i = R.id.photo_name_tv2;
                                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo_name_tv2);
                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                        i = R.id.photo_size;
                                                                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo_size);
                                                                                                                                                        if (textView9 != null) {
                                                                                                                                                            i = R.id.progenyRelationSpinner;
                                                                                                                                                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.progenyRelationSpinner);
                                                                                                                                                            if (spinner != null) {
                                                                                                                                                                i = R.id.progressBar;
                                                                                                                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                                                                                                                                                if (progressBar != null) {
                                                                                                                                                                    i = R.id.relationtypecardview;
                                                                                                                                                                    CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.relationtypecardview);
                                                                                                                                                                    if (cardViewFindChildViewById2 != null) {
                                                                                                                                                                        i = R.id.relativeCardView;
                                                                                                                                                                        CardView cardViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.relativeCardView);
                                                                                                                                                                        if (cardViewFindChildViewById3 != null) {
                                                                                                                                                                            i = R.id.selfCardView;
                                                                                                                                                                            CardView cardViewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.selfCardView);
                                                                                                                                                                            if (cardViewFindChildViewById4 != null) {
                                                                                                                                                                                i = R.id.speak_fatherName;
                                                                                                                                                                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speak_fatherName);
                                                                                                                                                                                if (imageView11 != null) {
                                                                                                                                                                                    i = R.id.speak_motherName;
                                                                                                                                                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speak_motherName);
                                                                                                                                                                                    if (imageView12 != null) {
                                                                                                                                                                                        i = R.id.speak_spouseName;
                                                                                                                                                                                        ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speak_spouseName);
                                                                                                                                                                                        if (imageView13 != null) {
                                                                                                                                                                                            i = R.id.spouseEpicNumber;
                                                                                                                                                                                            TextInputEditText textInputEditTextFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.spouseEpicNumber);
                                                                                                                                                                                            if (textInputEditTextFindChildViewById != null) {
                                                                                                                                                                                                i = R.id.spouseName;
                                                                                                                                                                                                EditText editText8 = (EditText) ViewBindings.findChildViewById(rootView, R.id.spouseName);
                                                                                                                                                                                                if (editText8 != null) {
                                                                                                                                                                                                    i = R.id.submitButtonRec;
                                                                                                                                                                                                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submitButtonRec);
                                                                                                                                                                                                    if (button != null) {
                                                                                                                                                                                                        i = R.id.submitLayout;
                                                                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.submitLayout);
                                                                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                                                                            i = R.id.textView3;
                                                                                                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                                                                                            if (textView10 != null) {
                                                                                                                                                                                                                i = R.id.textView5;
                                                                                                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView5);
                                                                                                                                                                                                                if (textView11 != null) {
                                                                                                                                                                                                                    i = R.id.toolbar_button;
                                                                                                                                                                                                                    ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                                                                                                                                                                                    if (imageView14 != null) {
                                                                                                                                                                                                                        i = R.id.tv_acName;
                                                                                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_acName);
                                                                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                                                                            i = R.id.tv_acNo;
                                                                                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_acNo);
                                                                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                                                                i = R.id.tv_epic;
                                                                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_epic);
                                                                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                                                                    i = R.id.tvLeftName;
                                                                                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvLeftName);
                                                                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                                                                        i = R.id.tv_name;
                                                                                                                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_name);
                                                                                                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                                                                                                            i = R.id.tv_name1;
                                                                                                                                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_name1);
                                                                                                                                                                                                                                            if (textView17 != null) {
                                                                                                                                                                                                                                                i = R.id.tv_partNo;
                                                                                                                                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_partNo);
                                                                                                                                                                                                                                                if (textView18 != null) {
                                                                                                                                                                                                                                                    i = R.id.tv_relation;
                                                                                                                                                                                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relation);
                                                                                                                                                                                                                                                    if (textView19 != null) {
                                                                                                                                                                                                                                                        i = R.id.tvRightName;
                                                                                                                                                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvRightName);
                                                                                                                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                                                                                                                            i = R.id.tv_rl_acName;
                                                                                                                                                                                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_rl_acName);
                                                                                                                                                                                                                                                            if (textView21 != null) {
                                                                                                                                                                                                                                                                i = R.id.tv_rl_acNo;
                                                                                                                                                                                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_rl_acNo);
                                                                                                                                                                                                                                                                if (textView22 != null) {
                                                                                                                                                                                                                                                                    i = R.id.tv_rl_epic;
                                                                                                                                                                                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_rl_epic);
                                                                                                                                                                                                                                                                    if (textView23 != null) {
                                                                                                                                                                                                                                                                        i = R.id.tv_rl_name;
                                                                                                                                                                                                                                                                        TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_rl_name);
                                                                                                                                                                                                                                                                        if (textView24 != null) {
                                                                                                                                                                                                                                                                            i = R.id.tv_rl_name1;
                                                                                                                                                                                                                                                                            TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_rl_name1);
                                                                                                                                                                                                                                                                            if (textView25 != null) {
                                                                                                                                                                                                                                                                                i = R.id.tv_rl_partNo;
                                                                                                                                                                                                                                                                                TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_rl_partNo);
                                                                                                                                                                                                                                                                                if (textView26 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.tv_rl_relation;
                                                                                                                                                                                                                                                                                    TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_rl_relation);
                                                                                                                                                                                                                                                                                    if (textView27 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.tv_rl_srNo;
                                                                                                                                                                                                                                                                                        TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_rl_srNo);
                                                                                                                                                                                                                                                                                        if (textView28 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.tv_rl_state;
                                                                                                                                                                                                                                                                                            TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_rl_state);
                                                                                                                                                                                                                                                                                            if (textView29 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.tv_srNo;
                                                                                                                                                                                                                                                                                                TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_srNo);
                                                                                                                                                                                                                                                                                                if (textView30 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.tv_state;
                                                                                                                                                                                                                                                                                                    TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_state);
                                                                                                                                                                                                                                                                                                    if (textView31 != null) {
                                                                                                                                                                                                                                                                                                        return new ActivityEnumrationFormBinding(linearLayout4, linearLayout, editText, linearLayout2, imageView, relativeLayout, constraintLayoutFindChildViewById, imageView2, imageView3, imageView4, textView, editText2, linearLayout3, cardViewFindChildViewById, editText3, editText4, imageView5, imageView6, imageView7, imageView8, linearLayout4, linearLayout5, linearLayout6, editText5, editText6, editText7, linearLayout7, linearLayout8, imageView9, textView2, textView3, textView4, imageView10, textView5, linearLayout9, textView6, textView7, textView8, textView9, spinner, progressBar, cardViewFindChildViewById2, cardViewFindChildViewById3, cardViewFindChildViewById4, imageView11, imageView12, imageView13, textInputEditTextFindChildViewById, editText8, button, linearLayout10, textView10, textView11, imageView14, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30, textView31);
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
