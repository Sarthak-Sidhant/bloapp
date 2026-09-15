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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentFormBinding implements ViewBinding {
    public final TextView aadhar;
    public final RadioButton aadharRb;
    public final RadioGroup aadharRg;
    public final TextView addDoc1Filename;
    public final ImageView addDoc1Img;
    public final TextView addDoc2Filename;
    public final ImageView addDoc2Img;
    public final TextView addDocFilename;
    public final ImageView addDocImg;
    public final TextView addDocProof;
    public final TextView addfilename;
    public final ImageView addimg;
    public final TextView addproof;
    public final TextView agefilename;
    public final ImageView ageimg;
    public final TextView ageproof;
    public final BloFragmentAnnexureFormBinding annexurePrevFragment;
    public final TextView anyadd;
    public final TextView anyage;
    public final TextView constituency;
    public final TextView countrydec;
    public final TextView date;
    public final TextView datedec;
    public final CheckBox deaf;
    public final BloFragmentPrevDecFormBinding decFormPrevFragment;
    public final TextView disfilename;
    public final ImageView disimg;
    public final TextView district;
    public final TextView districtadd;
    public final TextView districtdec;
    public final TextView dob;
    public final TextView doc1Tv;
    public final TextView doc2Tv;
    public final TextView doc3Tv;
    public final TextView doumentdec;
    public final TextView email;
    public final RadioButton emailRb;
    public final RadioGroup emailRg;
    public final TextView epicfam;
    public final TextView familyname;
    public final TextView filenamepreview;
    public final TextView gender;
    public final TextView houseno;
    public final TextView housenoreg;
    public final ImageView imagepreview;
    public final LinearLayout indiaLayout;
    public final RadioButton indiaRb;
    public final TextView lastnamepreview;
    public final TextView lastnamepreview1;
    public final LinearLayout linear;
    public final CheckBox loco;
    public final LinearLayout lvAddDoc;
    public final RadioGroup mobNumRg;
    public final TextView mobile;
    public final TextView namepreview;
    public final TextView namepreview1;
    public final RadioButton no;
    public final RadioButton noAadharRb;
    public final CheckBox other;
    public final TextView otherEdDetails;
    public final LinearLayout outsideIndiaLayout;
    public final RadioButton outsideRb;
    public final TextView percent;
    public final TextView pincode;
    public final TextView place;
    public final RadioGroup placeOfBirthRG;
    public final TextView postoffice;
    public final TextView postofficereg;
    public final TextView relafamily;
    public final TextView relationtype;
    public final RadioButton relative;
    public final TextView relnamepreview;
    public final TextView relnamepreview1;
    public final TextView relsurnamepreview;
    public final TextView relsurnamepreview1;
    private final LinearLayout rootView;
    public final RadioButton self;
    public final RadioButton selfRb;
    public final TextView state;
    public final TextView statedec;
    public final TextView stateut;
    public final TextView street;
    public final TextView streetreg;
    public final TextView tehsil;
    public final TextView tehsilreg;
    public final TextView town;
    public final TextView townreg;
    public final TextView village;
    public final CheckBox visual;
    public final RadioButton yes;
    public final RadioGroup yesnoradio;

    private BloFragmentFormBinding(LinearLayout rootView, TextView aadhar, RadioButton aadharRb, RadioGroup aadharRg, TextView addDoc1Filename, ImageView addDoc1Img, TextView addDoc2Filename, ImageView addDoc2Img, TextView addDocFilename, ImageView addDocImg, TextView addDocProof, TextView addfilename, ImageView addimg, TextView addproof, TextView agefilename, ImageView ageimg, TextView ageproof, BloFragmentAnnexureFormBinding annexurePrevFragment, TextView anyadd, TextView anyage, TextView constituency, TextView countrydec, TextView date, TextView datedec, CheckBox deaf, BloFragmentPrevDecFormBinding decFormPrevFragment, TextView disfilename, ImageView disimg, TextView district, TextView districtadd, TextView districtdec, TextView dob, TextView doc1Tv, TextView doc2Tv, TextView doc3Tv, TextView doumentdec, TextView email, RadioButton emailRb, RadioGroup emailRg, TextView epicfam, TextView familyname, TextView filenamepreview, TextView gender, TextView houseno, TextView housenoreg, ImageView imagepreview, LinearLayout indiaLayout, RadioButton indiaRb, TextView lastnamepreview, TextView lastnamepreview1, LinearLayout linear, CheckBox loco, LinearLayout lvAddDoc, RadioGroup mobNumRg, TextView mobile, TextView namepreview, TextView namepreview1, RadioButton no, RadioButton noAadharRb, CheckBox other, TextView otherEdDetails, LinearLayout outsideIndiaLayout, RadioButton outsideRb, TextView percent, TextView pincode, TextView place, RadioGroup placeOfBirthRG, TextView postoffice, TextView postofficereg, TextView relafamily, TextView relationtype, RadioButton relative, TextView relnamepreview, TextView relnamepreview1, TextView relsurnamepreview, TextView relsurnamepreview1, RadioButton self, RadioButton selfRb, TextView state, TextView statedec, TextView stateut, TextView street, TextView streetreg, TextView tehsil, TextView tehsilreg, TextView town, TextView townreg, TextView village, CheckBox visual, RadioButton yes, RadioGroup yesnoradio) {
        this.rootView = rootView;
        this.aadhar = aadhar;
        this.aadharRb = aadharRb;
        this.aadharRg = aadharRg;
        this.addDoc1Filename = addDoc1Filename;
        this.addDoc1Img = addDoc1Img;
        this.addDoc2Filename = addDoc2Filename;
        this.addDoc2Img = addDoc2Img;
        this.addDocFilename = addDocFilename;
        this.addDocImg = addDocImg;
        this.addDocProof = addDocProof;
        this.addfilename = addfilename;
        this.addimg = addimg;
        this.addproof = addproof;
        this.agefilename = agefilename;
        this.ageimg = ageimg;
        this.ageproof = ageproof;
        this.annexurePrevFragment = annexurePrevFragment;
        this.anyadd = anyadd;
        this.anyage = anyage;
        this.constituency = constituency;
        this.countrydec = countrydec;
        this.date = date;
        this.datedec = datedec;
        this.deaf = deaf;
        this.decFormPrevFragment = decFormPrevFragment;
        this.disfilename = disfilename;
        this.disimg = disimg;
        this.district = district;
        this.districtadd = districtadd;
        this.districtdec = districtdec;
        this.dob = dob;
        this.doc1Tv = doc1Tv;
        this.doc2Tv = doc2Tv;
        this.doc3Tv = doc3Tv;
        this.doumentdec = doumentdec;
        this.email = email;
        this.emailRb = emailRb;
        this.emailRg = emailRg;
        this.epicfam = epicfam;
        this.familyname = familyname;
        this.filenamepreview = filenamepreview;
        this.gender = gender;
        this.houseno = houseno;
        this.housenoreg = housenoreg;
        this.imagepreview = imagepreview;
        this.indiaLayout = indiaLayout;
        this.indiaRb = indiaRb;
        this.lastnamepreview = lastnamepreview;
        this.lastnamepreview1 = lastnamepreview1;
        this.linear = linear;
        this.loco = loco;
        this.lvAddDoc = lvAddDoc;
        this.mobNumRg = mobNumRg;
        this.mobile = mobile;
        this.namepreview = namepreview;
        this.namepreview1 = namepreview1;
        this.no = no;
        this.noAadharRb = noAadharRb;
        this.other = other;
        this.otherEdDetails = otherEdDetails;
        this.outsideIndiaLayout = outsideIndiaLayout;
        this.outsideRb = outsideRb;
        this.percent = percent;
        this.pincode = pincode;
        this.place = place;
        this.placeOfBirthRG = placeOfBirthRG;
        this.postoffice = postoffice;
        this.postofficereg = postofficereg;
        this.relafamily = relafamily;
        this.relationtype = relationtype;
        this.relative = relative;
        this.relnamepreview = relnamepreview;
        this.relnamepreview1 = relnamepreview1;
        this.relsurnamepreview = relsurnamepreview;
        this.relsurnamepreview1 = relsurnamepreview1;
        this.self = self;
        this.selfRb = selfRb;
        this.state = state;
        this.statedec = statedec;
        this.stateut = stateut;
        this.street = street;
        this.streetreg = streetreg;
        this.tehsil = tehsil;
        this.tehsilreg = tehsilreg;
        this.town = town;
        this.townreg = townreg;
        this.village = village;
        this.visual = visual;
        this.yes = yes;
        this.yesnoradio = yesnoradio;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentFormBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentFormBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_form, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentFormBinding bind(View rootView) {
        int i = R.id.aadhar;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.aadhar);
        if (textView != null) {
            i = R.id.aadhar_rb;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.aadhar_rb);
            if (radioButton != null) {
                i = R.id.aadhar_rg;
                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.aadhar_rg);
                if (radioGroup != null) {
                    i = R.id.add_doc1_filename;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_doc1_filename);
                    if (textView2 != null) {
                        i = R.id.add_doc1_img;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.add_doc1_img);
                        if (imageView != null) {
                            i = R.id.add_doc2_filename;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_doc2_filename);
                            if (textView3 != null) {
                                i = R.id.add_doc2_img;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.add_doc2_img);
                                if (imageView2 != null) {
                                    i = R.id.add_doc_filename;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_doc_filename);
                                    if (textView4 != null) {
                                        i = R.id.add_doc_img;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.add_doc_img);
                                        if (imageView3 != null) {
                                            i = R.id.add_doc_proof;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_doc_proof);
                                            if (textView5 != null) {
                                                i = R.id.addfilename;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.addfilename);
                                                if (textView6 != null) {
                                                    i = R.id.addimg;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.addimg);
                                                    if (imageView4 != null) {
                                                        i = R.id.addproof;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.addproof);
                                                        if (textView7 != null) {
                                                            i = R.id.agefilename;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.agefilename);
                                                            if (textView8 != null) {
                                                                i = R.id.ageimg;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ageimg);
                                                                if (imageView5 != null) {
                                                                    i = R.id.ageproof;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ageproof);
                                                                    if (textView9 != null) {
                                                                        i = R.id.annexure_prev_fragment;
                                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.annexure_prev_fragment);
                                                                        if (viewFindChildViewById != null) {
                                                                            BloFragmentAnnexureFormBinding bloFragmentAnnexureFormBindingBind = BloFragmentAnnexureFormBinding.bind(viewFindChildViewById);
                                                                            i = R.id.anyadd;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.anyadd);
                                                                            if (textView10 != null) {
                                                                                i = R.id.anyage;
                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.anyage);
                                                                                if (textView11 != null) {
                                                                                    i = R.id.constituency;
                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.constituency);
                                                                                    if (textView12 != null) {
                                                                                        i = R.id.countrydec;
                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.countrydec);
                                                                                        if (textView13 != null) {
                                                                                            i = R.id.date;
                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date);
                                                                                            if (textView14 != null) {
                                                                                                i = R.id.datedec;
                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.datedec);
                                                                                                if (textView15 != null) {
                                                                                                    i = R.id.deaf;
                                                                                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.deaf);
                                                                                                    if (checkBox != null) {
                                                                                                        i = R.id.dec_form_prev_fragment;
                                                                                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.dec_form_prev_fragment);
                                                                                                        if (viewFindChildViewById2 != null) {
                                                                                                            BloFragmentPrevDecFormBinding bloFragmentPrevDecFormBindingBind = BloFragmentPrevDecFormBinding.bind(viewFindChildViewById2);
                                                                                                            i = R.id.disfilename;
                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.disfilename);
                                                                                                            if (textView16 != null) {
                                                                                                                i = R.id.disimg;
                                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.disimg);
                                                                                                                if (imageView6 != null) {
                                                                                                                    i = R.id.district;
                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district);
                                                                                                                    if (textView17 != null) {
                                                                                                                        i = R.id.districtadd;
                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.districtadd);
                                                                                                                        if (textView18 != null) {
                                                                                                                            i = R.id.districtdec;
                                                                                                                            TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.districtdec);
                                                                                                                            if (textView19 != null) {
                                                                                                                                i = R.id.dob;
                                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dob);
                                                                                                                                if (textView20 != null) {
                                                                                                                                    i = R.id.doc1_tv;
                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc1_tv);
                                                                                                                                    if (textView21 != null) {
                                                                                                                                        i = R.id.doc2_tv;
                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc2_tv);
                                                                                                                                        if (textView22 != null) {
                                                                                                                                            i = R.id.doc3_tv;
                                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3_tv);
                                                                                                                                            if (textView23 != null) {
                                                                                                                                                i = R.id.doumentdec;
                                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doumentdec);
                                                                                                                                                if (textView24 != null) {
                                                                                                                                                    i = R.id.email;
                                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.email);
                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                        i = R.id.email_rb;
                                                                                                                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.email_rb);
                                                                                                                                                        if (radioButton2 != null) {
                                                                                                                                                            i = R.id.email_rg;
                                                                                                                                                            RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.email_rg);
                                                                                                                                                            if (radioGroup2 != null) {
                                                                                                                                                                i = R.id.epicfam;
                                                                                                                                                                TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epicfam);
                                                                                                                                                                if (textView26 != null) {
                                                                                                                                                                    i = R.id.familyname;
                                                                                                                                                                    TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.familyname);
                                                                                                                                                                    if (textView27 != null) {
                                                                                                                                                                        i = R.id.filenamepreview;
                                                                                                                                                                        TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filenamepreview);
                                                                                                                                                                        if (textView28 != null) {
                                                                                                                                                                            i = R.id.gender;
                                                                                                                                                                            TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender);
                                                                                                                                                                            if (textView29 != null) {
                                                                                                                                                                                i = R.id.houseno;
                                                                                                                                                                                TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.houseno);
                                                                                                                                                                                if (textView30 != null) {
                                                                                                                                                                                    i = R.id.housenoreg;
                                                                                                                                                                                    TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.housenoreg);
                                                                                                                                                                                    if (textView31 != null) {
                                                                                                                                                                                        i = R.id.imagepreview;
                                                                                                                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagepreview);
                                                                                                                                                                                        if (imageView7 != null) {
                                                                                                                                                                                            i = R.id.india_layout;
                                                                                                                                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.india_layout);
                                                                                                                                                                                            if (linearLayout != null) {
                                                                                                                                                                                                i = R.id.india_rb;
                                                                                                                                                                                                RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.india_rb);
                                                                                                                                                                                                if (radioButton3 != null) {
                                                                                                                                                                                                    i = R.id.lastnamepreview;
                                                                                                                                                                                                    TextView textView32 = (TextView) ViewBindings.findChildViewById(rootView, R.id.lastnamepreview);
                                                                                                                                                                                                    if (textView32 != null) {
                                                                                                                                                                                                        i = R.id.lastnamepreview1;
                                                                                                                                                                                                        TextView textView33 = (TextView) ViewBindings.findChildViewById(rootView, R.id.lastnamepreview1);
                                                                                                                                                                                                        if (textView33 != null) {
                                                                                                                                                                                                            i = 2131364478;
                                                                                                                                                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, 2131364478);
                                                                                                                                                                                                            if (linearLayout2 != null) {
                                                                                                                                                                                                                i = R.id.loco;
                                                                                                                                                                                                                CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.loco);
                                                                                                                                                                                                                if (checkBox2 != null) {
                                                                                                                                                                                                                    i = R.id.lv_add_doc;
                                                                                                                                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_add_doc);
                                                                                                                                                                                                                    if (linearLayout3 != null) {
                                                                                                                                                                                                                        i = R.id.mob_num_rg;
                                                                                                                                                                                                                        RadioGroup radioGroup3 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.mob_num_rg);
                                                                                                                                                                                                                        if (radioGroup3 != null) {
                                                                                                                                                                                                                            i = R.id.mobile;
                                                                                                                                                                                                                            TextView textView34 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobile);
                                                                                                                                                                                                                            if (textView34 != null) {
                                                                                                                                                                                                                                i = R.id.namepreview;
                                                                                                                                                                                                                                TextView textView35 = (TextView) ViewBindings.findChildViewById(rootView, R.id.namepreview);
                                                                                                                                                                                                                                if (textView35 != null) {
                                                                                                                                                                                                                                    i = R.id.namepreview1;
                                                                                                                                                                                                                                    TextView textView36 = (TextView) ViewBindings.findChildViewById(rootView, R.id.namepreview1);
                                                                                                                                                                                                                                    if (textView36 != null) {
                                                                                                                                                                                                                                        i = R.id.no;
                                                                                                                                                                                                                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.no);
                                                                                                                                                                                                                                        if (radioButton4 != null) {
                                                                                                                                                                                                                                            i = R.id.no_aadhar_rb;
                                                                                                                                                                                                                                            RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.no_aadhar_rb);
                                                                                                                                                                                                                                            if (radioButton5 != null) {
                                                                                                                                                                                                                                                i = R.id.other;
                                                                                                                                                                                                                                                CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.other);
                                                                                                                                                                                                                                                if (checkBox3 != null) {
                                                                                                                                                                                                                                                    i = R.id.other_ed_details;
                                                                                                                                                                                                                                                    TextView textView37 = (TextView) ViewBindings.findChildViewById(rootView, R.id.other_ed_details);
                                                                                                                                                                                                                                                    if (textView37 != null) {
                                                                                                                                                                                                                                                        i = R.id.outside_india_layout;
                                                                                                                                                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.outside_india_layout);
                                                                                                                                                                                                                                                        if (linearLayout4 != null) {
                                                                                                                                                                                                                                                            i = R.id.outside_rb;
                                                                                                                                                                                                                                                            RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.outside_rb);
                                                                                                                                                                                                                                                            if (radioButton6 != null) {
                                                                                                                                                                                                                                                                i = 2131365296;
                                                                                                                                                                                                                                                                TextView textView38 = (TextView) ViewBindings.findChildViewById(rootView, 2131365296);
                                                                                                                                                                                                                                                                if (textView38 != null) {
                                                                                                                                                                                                                                                                    i = R.id.pincode;
                                                                                                                                                                                                                                                                    TextView textView39 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pincode);
                                                                                                                                                                                                                                                                    if (textView39 != null) {
                                                                                                                                                                                                                                                                        i = R.id.place;
                                                                                                                                                                                                                                                                        TextView textView40 = (TextView) ViewBindings.findChildViewById(rootView, R.id.place);
                                                                                                                                                                                                                                                                        if (textView40 != null) {
                                                                                                                                                                                                                                                                            i = R.id.placeOfBirthRG;
                                                                                                                                                                                                                                                                            RadioGroup radioGroup4 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.placeOfBirthRG);
                                                                                                                                                                                                                                                                            if (radioGroup4 != null) {
                                                                                                                                                                                                                                                                                i = R.id.postoffice;
                                                                                                                                                                                                                                                                                TextView textView41 = (TextView) ViewBindings.findChildViewById(rootView, R.id.postoffice);
                                                                                                                                                                                                                                                                                if (textView41 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.postofficereg;
                                                                                                                                                                                                                                                                                    TextView textView42 = (TextView) ViewBindings.findChildViewById(rootView, R.id.postofficereg);
                                                                                                                                                                                                                                                                                    if (textView42 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.relafamily;
                                                                                                                                                                                                                                                                                        TextView textView43 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relafamily);
                                                                                                                                                                                                                                                                                        if (textView43 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.relationtype;
                                                                                                                                                                                                                                                                                            TextView textView44 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relationtype);
                                                                                                                                                                                                                                                                                            if (textView44 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.relative;
                                                                                                                                                                                                                                                                                                RadioButton radioButton7 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.relative);
                                                                                                                                                                                                                                                                                                if (radioButton7 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.relnamepreview;
                                                                                                                                                                                                                                                                                                    TextView textView45 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relnamepreview);
                                                                                                                                                                                                                                                                                                    if (textView45 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.relnamepreview1;
                                                                                                                                                                                                                                                                                                        TextView textView46 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relnamepreview1);
                                                                                                                                                                                                                                                                                                        if (textView46 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.relsurnamepreview;
                                                                                                                                                                                                                                                                                                            TextView textView47 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relsurnamepreview);
                                                                                                                                                                                                                                                                                                            if (textView47 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.relsurnamepreview1;
                                                                                                                                                                                                                                                                                                                TextView textView48 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relsurnamepreview1);
                                                                                                                                                                                                                                                                                                                if (textView48 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.self;
                                                                                                                                                                                                                                                                                                                    RadioButton radioButton8 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.self);
                                                                                                                                                                                                                                                                                                                    if (radioButton8 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.self_rb;
                                                                                                                                                                                                                                                                                                                        RadioButton radioButton9 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.self_rb);
                                                                                                                                                                                                                                                                                                                        if (radioButton9 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.state;
                                                                                                                                                                                                                                                                                                                            TextView textView49 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state);
                                                                                                                                                                                                                                                                                                                            if (textView49 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.statedec;
                                                                                                                                                                                                                                                                                                                                TextView textView50 = (TextView) ViewBindings.findChildViewById(rootView, R.id.statedec);
                                                                                                                                                                                                                                                                                                                                if (textView50 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.stateut;
                                                                                                                                                                                                                                                                                                                                    TextView textView51 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stateut);
                                                                                                                                                                                                                                                                                                                                    if (textView51 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.street;
                                                                                                                                                                                                                                                                                                                                        TextView textView52 = (TextView) ViewBindings.findChildViewById(rootView, R.id.street);
                                                                                                                                                                                                                                                                                                                                        if (textView52 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.streetreg;
                                                                                                                                                                                                                                                                                                                                            TextView textView53 = (TextView) ViewBindings.findChildViewById(rootView, R.id.streetreg);
                                                                                                                                                                                                                                                                                                                                            if (textView53 != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.tehsil;
                                                                                                                                                                                                                                                                                                                                                TextView textView54 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tehsil);
                                                                                                                                                                                                                                                                                                                                                if (textView54 != null) {
                                                                                                                                                                                                                                                                                                                                                    i = R.id.tehsilreg;
                                                                                                                                                                                                                                                                                                                                                    TextView textView55 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tehsilreg);
                                                                                                                                                                                                                                                                                                                                                    if (textView55 != null) {
                                                                                                                                                                                                                                                                                                                                                        i = R.id.town;
                                                                                                                                                                                                                                                                                                                                                        TextView textView56 = (TextView) ViewBindings.findChildViewById(rootView, R.id.town);
                                                                                                                                                                                                                                                                                                                                                        if (textView56 != null) {
                                                                                                                                                                                                                                                                                                                                                            i = R.id.townreg;
                                                                                                                                                                                                                                                                                                                                                            TextView textView57 = (TextView) ViewBindings.findChildViewById(rootView, R.id.townreg);
                                                                                                                                                                                                                                                                                                                                                            if (textView57 != null) {
                                                                                                                                                                                                                                                                                                                                                                i = R.id.village;
                                                                                                                                                                                                                                                                                                                                                                TextView textView58 = (TextView) ViewBindings.findChildViewById(rootView, R.id.village);
                                                                                                                                                                                                                                                                                                                                                                if (textView58 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i = R.id.visual;
                                                                                                                                                                                                                                                                                                                                                                    CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.visual);
                                                                                                                                                                                                                                                                                                                                                                    if (checkBox4 != null) {
                                                                                                                                                                                                                                                                                                                                                                        i = R.id.yes;
                                                                                                                                                                                                                                                                                                                                                                        RadioButton radioButton10 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.yes);
                                                                                                                                                                                                                                                                                                                                                                        if (radioButton10 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i = R.id.yesnoradio;
                                                                                                                                                                                                                                                                                                                                                                            RadioGroup radioGroup5 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.yesnoradio);
                                                                                                                                                                                                                                                                                                                                                                            if (radioGroup5 != null) {
                                                                                                                                                                                                                                                                                                                                                                                return new BloFragmentFormBinding((LinearLayout) rootView, textView, radioButton, radioGroup, textView2, imageView, textView3, imageView2, textView4, imageView3, textView5, textView6, imageView4, textView7, textView8, imageView5, textView9, bloFragmentAnnexureFormBindingBind, textView10, textView11, textView12, textView13, textView14, textView15, checkBox, bloFragmentPrevDecFormBindingBind, textView16, imageView6, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, radioButton2, radioGroup2, textView26, textView27, textView28, textView29, textView30, textView31, imageView7, linearLayout, radioButton3, textView32, textView33, linearLayout2, checkBox2, linearLayout3, radioGroup3, textView34, textView35, textView36, radioButton4, radioButton5, checkBox3, textView37, linearLayout4, radioButton6, textView38, textView39, textView40, radioGroup4, textView41, textView42, textView43, textView44, radioButton7, textView45, textView46, textView47, textView48, radioButton8, radioButton9, textView49, textView50, textView51, textView52, textView53, textView54, textView55, textView56, textView57, textView58, checkBox4, radioButton10, radioGroup5);
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
