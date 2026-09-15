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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivityPreviewForm7Binding implements ViewBinding {
    public final TextView addDoc1Filename;
    public final ImageView addDoc1Img;
    public final TextView addDoc2Filename;
    public final ImageView addDoc2Img;
    public final ImageView backBtnIv;
    public final ConstraintLayout bottomPreviousSaveLayout;
    public final CardView cardView;
    public final TextView constituencyEd;
    public final TextView constituencyTv;
    public final TextView constituencynoEd;
    public final ConstraintLayout constraintLayout;
    public final RadioGroup deathCertificateReg;
    public final LinearLayout deathLayout;
    public final LinearLayout deletionObjectionFormLayout;
    public final TextView districtEd2;
    public final TextView districtTv;
    public final TextView districtTv1;
    public final TextView epicEd;
    public final TextView epicEd2;
    public final TextView firstnameEd;
    public final ImageView homeBtnIv;
    public final TextView houseEd;
    public final TextView houseEd2;
    public final TextView issueDateEd;
    public final TextView keepEditingTv;
    public final LinearLayout lvUploadDoc;
    public final RadioGroup mobNumRg;
    public final TextView mobNumTv;
    public final TextView mobnumEd;
    public final TextView nameEd;
    public final RadioButton noRg;
    public final RadioButton optionRb1;
    public final RadioButton optionRb2;
    public final RadioButton optionRb3;
    public final TextView pincodeEd;
    public final TextView placeEd;
    public final TextView postofficeEd;
    public final TextView postofficeEd2;
    public final TextView postofficeTv;
    public final ImageView previewImage;
    public final RadioGroup rejectionOptionsRg;
    public final RadioButton relative;
    private final ConstraintLayout rootView;
    public final RadioButton self;
    public final TextView stateEd2;
    public final TextView stateTv;
    public final TextView stateTv1;
    public final TextView streetEd;
    public final TextView streetEd2;
    public final TextView submitTv;
    public final TextView surnameEd2;
    public final TextView tehsilEd;
    public final TextView tehsilEd2;
    public final TextView tehsilTv;
    public final TextView textView1;
    public final TextView textView10;
    public final TextView textView12;
    public final TextView textView13;
    public final TextView textView15;
    public final TextView textView17;
    public final TextView textView18;
    public final TextView textView19;
    public final TextView textView2;
    public final TextView textView20;
    public final TextView textView21;
    public final TextView textView22;
    public final TextView textView25;
    public final TextView textView3;
    public final TextView textView30;
    public final TextView textView31;
    public final TextView textView32;
    public final TextView textView7;
    public final TextView textView9;
    public final TextView upload;
    public final TextView uploadName;
    public final TextView villageEd;
    public final TextView villageEd2;
    public final TextView villageTv;
    public final RadioButton yesRg;

    private BloActivityPreviewForm7Binding(ConstraintLayout rootView, TextView addDoc1Filename, ImageView addDoc1Img, TextView addDoc2Filename, ImageView addDoc2Img, ImageView backBtnIv, ConstraintLayout bottomPreviousSaveLayout, CardView cardView, TextView constituencyEd, TextView constituencyTv, TextView constituencynoEd, ConstraintLayout constraintLayout, RadioGroup deathCertificateReg, LinearLayout deathLayout, LinearLayout deletionObjectionFormLayout, TextView districtEd2, TextView districtTv, TextView districtTv1, TextView epicEd, TextView epicEd2, TextView firstnameEd, ImageView homeBtnIv, TextView houseEd, TextView houseEd2, TextView issueDateEd, TextView keepEditingTv, LinearLayout lvUploadDoc, RadioGroup mobNumRg, TextView mobNumTv, TextView mobnumEd, TextView nameEd, RadioButton noRg, RadioButton optionRb1, RadioButton optionRb2, RadioButton optionRb3, TextView pincodeEd, TextView placeEd, TextView postofficeEd, TextView postofficeEd2, TextView postofficeTv, ImageView previewImage, RadioGroup rejectionOptionsRg, RadioButton relative, RadioButton self, TextView stateEd2, TextView stateTv, TextView stateTv1, TextView streetEd, TextView streetEd2, TextView submitTv, TextView surnameEd2, TextView tehsilEd, TextView tehsilEd2, TextView tehsilTv, TextView textView1, TextView textView10, TextView textView12, TextView textView13, TextView textView15, TextView textView17, TextView textView18, TextView textView19, TextView textView2, TextView textView20, TextView textView21, TextView textView22, TextView textView25, TextView textView3, TextView textView30, TextView textView31, TextView textView32, TextView textView7, TextView textView9, TextView upload, TextView uploadName, TextView villageEd, TextView villageEd2, TextView villageTv, RadioButton yesRg) {
        this.rootView = rootView;
        this.addDoc1Filename = addDoc1Filename;
        this.addDoc1Img = addDoc1Img;
        this.addDoc2Filename = addDoc2Filename;
        this.addDoc2Img = addDoc2Img;
        this.backBtnIv = backBtnIv;
        this.bottomPreviousSaveLayout = bottomPreviousSaveLayout;
        this.cardView = cardView;
        this.constituencyEd = constituencyEd;
        this.constituencyTv = constituencyTv;
        this.constituencynoEd = constituencynoEd;
        this.constraintLayout = constraintLayout;
        this.deathCertificateReg = deathCertificateReg;
        this.deathLayout = deathLayout;
        this.deletionObjectionFormLayout = deletionObjectionFormLayout;
        this.districtEd2 = districtEd2;
        this.districtTv = districtTv;
        this.districtTv1 = districtTv1;
        this.epicEd = epicEd;
        this.epicEd2 = epicEd2;
        this.firstnameEd = firstnameEd;
        this.homeBtnIv = homeBtnIv;
        this.houseEd = houseEd;
        this.houseEd2 = houseEd2;
        this.issueDateEd = issueDateEd;
        this.keepEditingTv = keepEditingTv;
        this.lvUploadDoc = lvUploadDoc;
        this.mobNumRg = mobNumRg;
        this.mobNumTv = mobNumTv;
        this.mobnumEd = mobnumEd;
        this.nameEd = nameEd;
        this.noRg = noRg;
        this.optionRb1 = optionRb1;
        this.optionRb2 = optionRb2;
        this.optionRb3 = optionRb3;
        this.pincodeEd = pincodeEd;
        this.placeEd = placeEd;
        this.postofficeEd = postofficeEd;
        this.postofficeEd2 = postofficeEd2;
        this.postofficeTv = postofficeTv;
        this.previewImage = previewImage;
        this.rejectionOptionsRg = rejectionOptionsRg;
        this.relative = relative;
        this.self = self;
        this.stateEd2 = stateEd2;
        this.stateTv = stateTv;
        this.stateTv1 = stateTv1;
        this.streetEd = streetEd;
        this.streetEd2 = streetEd2;
        this.submitTv = submitTv;
        this.surnameEd2 = surnameEd2;
        this.tehsilEd = tehsilEd;
        this.tehsilEd2 = tehsilEd2;
        this.tehsilTv = tehsilTv;
        this.textView1 = textView1;
        this.textView10 = textView10;
        this.textView12 = textView12;
        this.textView13 = textView13;
        this.textView15 = textView15;
        this.textView17 = textView17;
        this.textView18 = textView18;
        this.textView19 = textView19;
        this.textView2 = textView2;
        this.textView20 = textView20;
        this.textView21 = textView21;
        this.textView22 = textView22;
        this.textView25 = textView25;
        this.textView3 = textView3;
        this.textView30 = textView30;
        this.textView31 = textView31;
        this.textView32 = textView32;
        this.textView7 = textView7;
        this.textView9 = textView9;
        this.upload = upload;
        this.uploadName = uploadName;
        this.villageEd = villageEd;
        this.villageEd2 = villageEd2;
        this.villageTv = villageTv;
        this.yesRg = yesRg;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityPreviewForm7Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityPreviewForm7Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_preview_form7, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityPreviewForm7Binding bind(View rootView) {
        int i = R.id.add_doc1_filename;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_doc1_filename);
        if (textView != null) {
            i = R.id.add_doc1_img;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.add_doc1_img);
            if (imageView != null) {
                i = R.id.add_doc2_filename;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_doc2_filename);
                if (textView2 != null) {
                    i = R.id.add_doc2_img;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.add_doc2_img);
                    if (imageView2 != null) {
                        i = R.id.back_btn_iv;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                        if (imageView3 != null) {
                            i = R.id.bottom_previous_save_layout;
                            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_previous_save_layout);
                            if (constraintLayoutFindChildViewById != null) {
                                i = R.id.cardView;
                                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView);
                                if (cardViewFindChildViewById != null) {
                                    i = R.id.constituency_ed;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.constituency_ed);
                                    if (textView3 != null) {
                                        i = R.id.constituency_tv;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.constituency_tv);
                                        if (textView4 != null) {
                                            i = R.id.constituencyno_ed;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.constituencyno_ed);
                                            if (textView5 != null) {
                                                i = R.id.constraintLayout;
                                                ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
                                                if (constraintLayoutFindChildViewById2 != null) {
                                                    i = R.id.death_certificate_reg;
                                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.death_certificate_reg);
                                                    if (radioGroup != null) {
                                                        i = R.id.death_layout;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.death_layout);
                                                        if (linearLayout != null) {
                                                            i = R.id.deletion_objection_form_layout;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.deletion_objection_form_layout);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.district_ed2;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_ed2);
                                                                if (textView6 != null) {
                                                                    i = R.id.district_tv;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_tv);
                                                                    if (textView7 != null) {
                                                                        i = R.id.district_tv1;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_tv1);
                                                                        if (textView8 != null) {
                                                                            i = R.id.epic_ed;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_ed);
                                                                            if (textView9 != null) {
                                                                                i = R.id.epic_ed2;
                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_ed2);
                                                                                if (textView10 != null) {
                                                                                    i = R.id.firstname_ed;
                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.firstname_ed);
                                                                                    if (textView11 != null) {
                                                                                        i = R.id.home_btn_iv;
                                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_btn_iv);
                                                                                        if (imageView4 != null) {
                                                                                            i = R.id.house_ed;
                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.house_ed);
                                                                                            if (textView12 != null) {
                                                                                                i = R.id.house_ed2;
                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.house_ed2);
                                                                                                if (textView13 != null) {
                                                                                                    i = R.id.issueDateEd;
                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.issueDateEd);
                                                                                                    if (textView14 != null) {
                                                                                                        i = R.id.keep_editing_tv;
                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.keep_editing_tv);
                                                                                                        if (textView15 != null) {
                                                                                                            i = R.id.lv_upload_doc;
                                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_upload_doc);
                                                                                                            if (linearLayout3 != null) {
                                                                                                                i = R.id.mobNumRg;
                                                                                                                RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.mobNumRg);
                                                                                                                if (radioGroup2 != null) {
                                                                                                                    i = R.id.mob_num_tv;
                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mob_num_tv);
                                                                                                                    if (textView16 != null) {
                                                                                                                        i = R.id.mobnum_ed;
                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobnum_ed);
                                                                                                                        if (textView17 != null) {
                                                                                                                            i = R.id.name_ed;
                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_ed);
                                                                                                                            if (textView18 != null) {
                                                                                                                                i = R.id.no_rg;
                                                                                                                                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.no_rg);
                                                                                                                                if (radioButton != null) {
                                                                                                                                    i = R.id.option_rb1;
                                                                                                                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.option_rb1);
                                                                                                                                    if (radioButton2 != null) {
                                                                                                                                        i = R.id.option_rb2;
                                                                                                                                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.option_rb2);
                                                                                                                                        if (radioButton3 != null) {
                                                                                                                                            i = R.id.option_rb3;
                                                                                                                                            RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.option_rb3);
                                                                                                                                            if (radioButton4 != null) {
                                                                                                                                                i = R.id.pincode_ed;
                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pincode_ed);
                                                                                                                                                if (textView19 != null) {
                                                                                                                                                    i = R.id.place_ed;
                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.place_ed);
                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                        i = R.id.postoffice_ed;
                                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.postoffice_ed);
                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                            i = R.id.postoffice_ed2;
                                                                                                                                                            TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.postoffice_ed2);
                                                                                                                                                            if (textView22 != null) {
                                                                                                                                                                i = R.id.postoffice_tv;
                                                                                                                                                                TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.postoffice_tv);
                                                                                                                                                                if (textView23 != null) {
                                                                                                                                                                    i = R.id.previewImage;
                                                                                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.previewImage);
                                                                                                                                                                    if (imageView5 != null) {
                                                                                                                                                                        i = R.id.rejection_options_rg;
                                                                                                                                                                        RadioGroup radioGroup3 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.rejection_options_rg);
                                                                                                                                                                        if (radioGroup3 != null) {
                                                                                                                                                                            i = R.id.relative;
                                                                                                                                                                            RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.relative);
                                                                                                                                                                            if (radioButton5 != null) {
                                                                                                                                                                                i = R.id.self;
                                                                                                                                                                                RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.self);
                                                                                                                                                                                if (radioButton6 != null) {
                                                                                                                                                                                    i = R.id.state_ed2;
                                                                                                                                                                                    TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_ed2);
                                                                                                                                                                                    if (textView24 != null) {
                                                                                                                                                                                        i = R.id.state_tv;
                                                                                                                                                                                        TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv);
                                                                                                                                                                                        if (textView25 != null) {
                                                                                                                                                                                            i = R.id.state_tv1;
                                                                                                                                                                                            TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv1);
                                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                                i = R.id.street_ed;
                                                                                                                                                                                                TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.street_ed);
                                                                                                                                                                                                if (textView27 != null) {
                                                                                                                                                                                                    i = R.id.street_ed2;
                                                                                                                                                                                                    TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.street_ed2);
                                                                                                                                                                                                    if (textView28 != null) {
                                                                                                                                                                                                        i = R.id.submit_tv;
                                                                                                                                                                                                        TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submit_tv);
                                                                                                                                                                                                        if (textView29 != null) {
                                                                                                                                                                                                            i = R.id.surname_ed2;
                                                                                                                                                                                                            TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.surname_ed2);
                                                                                                                                                                                                            if (textView30 != null) {
                                                                                                                                                                                                                i = R.id.tehsil_ed;
                                                                                                                                                                                                                TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tehsil_ed);
                                                                                                                                                                                                                if (textView31 != null) {
                                                                                                                                                                                                                    i = R.id.tehsil_ed2;
                                                                                                                                                                                                                    TextView textView32 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tehsil_ed2);
                                                                                                                                                                                                                    if (textView32 != null) {
                                                                                                                                                                                                                        i = R.id.tehsil_tv;
                                                                                                                                                                                                                        TextView textView33 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tehsil_tv);
                                                                                                                                                                                                                        if (textView33 != null) {
                                                                                                                                                                                                                            i = R.id.textView1;
                                                                                                                                                                                                                            TextView textView34 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView1);
                                                                                                                                                                                                                            if (textView34 != null) {
                                                                                                                                                                                                                                i = R.id.textView10;
                                                                                                                                                                                                                                TextView textView35 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView10);
                                                                                                                                                                                                                                if (textView35 != null) {
                                                                                                                                                                                                                                    i = R.id.textView12;
                                                                                                                                                                                                                                    TextView textView36 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView12);
                                                                                                                                                                                                                                    if (textView36 != null) {
                                                                                                                                                                                                                                        i = R.id.textView13;
                                                                                                                                                                                                                                        TextView textView37 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView13);
                                                                                                                                                                                                                                        if (textView37 != null) {
                                                                                                                                                                                                                                            i = R.id.textView15;
                                                                                                                                                                                                                                            TextView textView38 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView15);
                                                                                                                                                                                                                                            if (textView38 != null) {
                                                                                                                                                                                                                                                i = R.id.textView17;
                                                                                                                                                                                                                                                TextView textView39 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView17);
                                                                                                                                                                                                                                                if (textView39 != null) {
                                                                                                                                                                                                                                                    i = R.id.textView18;
                                                                                                                                                                                                                                                    TextView textView40 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView18);
                                                                                                                                                                                                                                                    if (textView40 != null) {
                                                                                                                                                                                                                                                        i = R.id.textView19;
                                                                                                                                                                                                                                                        TextView textView41 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView19);
                                                                                                                                                                                                                                                        if (textView41 != null) {
                                                                                                                                                                                                                                                            i = R.id.textView2;
                                                                                                                                                                                                                                                            TextView textView42 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView2);
                                                                                                                                                                                                                                                            if (textView42 != null) {
                                                                                                                                                                                                                                                                i = R.id.textView20;
                                                                                                                                                                                                                                                                TextView textView43 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView20);
                                                                                                                                                                                                                                                                if (textView43 != null) {
                                                                                                                                                                                                                                                                    i = R.id.textView21;
                                                                                                                                                                                                                                                                    TextView textView44 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView21);
                                                                                                                                                                                                                                                                    if (textView44 != null) {
                                                                                                                                                                                                                                                                        i = R.id.textView22;
                                                                                                                                                                                                                                                                        TextView textView45 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView22);
                                                                                                                                                                                                                                                                        if (textView45 != null) {
                                                                                                                                                                                                                                                                            i = R.id.textView25;
                                                                                                                                                                                                                                                                            TextView textView46 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView25);
                                                                                                                                                                                                                                                                            if (textView46 != null) {
                                                                                                                                                                                                                                                                                i = R.id.textView3;
                                                                                                                                                                                                                                                                                TextView textView47 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                                                                                                                                                                if (textView47 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.textView30;
                                                                                                                                                                                                                                                                                    TextView textView48 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView30);
                                                                                                                                                                                                                                                                                    if (textView48 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.textView31;
                                                                                                                                                                                                                                                                                        TextView textView49 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView31);
                                                                                                                                                                                                                                                                                        if (textView49 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.textView32;
                                                                                                                                                                                                                                                                                            TextView textView50 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView32);
                                                                                                                                                                                                                                                                                            if (textView50 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.textView7;
                                                                                                                                                                                                                                                                                                TextView textView51 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView7);
                                                                                                                                                                                                                                                                                                if (textView51 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.textView9;
                                                                                                                                                                                                                                                                                                    TextView textView52 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView9);
                                                                                                                                                                                                                                                                                                    if (textView52 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.upload;
                                                                                                                                                                                                                                                                                                        TextView textView53 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload);
                                                                                                                                                                                                                                                                                                        if (textView53 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.upload_name;
                                                                                                                                                                                                                                                                                                            TextView textView54 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_name);
                                                                                                                                                                                                                                                                                                            if (textView54 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.village_ed;
                                                                                                                                                                                                                                                                                                                TextView textView55 = (TextView) ViewBindings.findChildViewById(rootView, R.id.village_ed);
                                                                                                                                                                                                                                                                                                                if (textView55 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.village_ed2;
                                                                                                                                                                                                                                                                                                                    TextView textView56 = (TextView) ViewBindings.findChildViewById(rootView, R.id.village_ed2);
                                                                                                                                                                                                                                                                                                                    if (textView56 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.village_tv;
                                                                                                                                                                                                                                                                                                                        TextView textView57 = (TextView) ViewBindings.findChildViewById(rootView, R.id.village_tv);
                                                                                                                                                                                                                                                                                                                        if (textView57 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.yes_rg;
                                                                                                                                                                                                                                                                                                                            RadioButton radioButton7 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.yes_rg);
                                                                                                                                                                                                                                                                                                                            if (radioButton7 != null) {
                                                                                                                                                                                                                                                                                                                                return new BloActivityPreviewForm7Binding((ConstraintLayout) rootView, textView, imageView, textView2, imageView2, imageView3, constraintLayoutFindChildViewById, cardViewFindChildViewById, textView3, textView4, textView5, constraintLayoutFindChildViewById2, radioGroup, linearLayout, linearLayout2, textView6, textView7, textView8, textView9, textView10, textView11, imageView4, textView12, textView13, textView14, textView15, linearLayout3, radioGroup2, textView16, textView17, textView18, radioButton, radioButton2, radioButton3, radioButton4, textView19, textView20, textView21, textView22, textView23, imageView5, radioGroup3, radioButton5, radioButton6, textView24, textView25, textView26, textView27, textView28, textView29, textView30, textView31, textView32, textView33, textView34, textView35, textView36, textView37, textView38, textView39, textView40, textView41, textView42, textView43, textView44, textView45, textView46, textView47, textView48, textView49, textView50, textView51, textView52, textView53, textView54, textView55, textView56, textView57, radioButton7);
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
