package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivitySpecialRevisionDetailsBhBinding implements ViewBinding {
    public final EditText aadharNumber;
    public final LinearLayout annexPage1Layout;
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final RadioButton bornInIndia;
    public final ImageView cancel;
    public final ImageView cancelPhoto1Annexure;
    public final ImageView cancelPhoto2Annexure;
    public final TextView chooseFileTv;
    public final EditText dateOfBirth;
    public final EditText fatherEpicNumber;
    public final ImageView image;
    public final RadioButton indianCitizen;
    public final RadioButton indianWithPriorVoterID;
    public final LinearLayout main;
    public final EditText mobileNumber;
    public final EditText motherEpicNumber;
    public final TextView nextButton;
    public final RadioButton noDocument;
    public final RadioButton notBornInIndia;
    public final TextView orAnnex;
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
    private final LinearLayout rootView;
    public final RadioGroup selectDetails;
    public final EditText spouseEpicNumber;
    public final Button submitButtonDoc;
    public final Button submitButtonRec;
    public final LinearLayout submitLayout;
    public final TextView textView3;

    private ActivitySpecialRevisionDetailsBhBinding(LinearLayout rootView, EditText aadharNumber, LinearLayout annexPage1Layout, ImageView backBtnIv, ConstraintLayout blaTopLayout, RadioButton bornInIndia, ImageView cancel, ImageView cancelPhoto1Annexure, ImageView cancelPhoto2Annexure, TextView chooseFileTv, EditText dateOfBirth, EditText fatherEpicNumber, ImageView image, RadioButton indianCitizen, RadioButton indianWithPriorVoterID, LinearLayout main, EditText mobileNumber, EditText motherEpicNumber, TextView nextButton, RadioButton noDocument, RadioButton notBornInIndia, TextView orAnnex, LinearLayout passPhoto, LinearLayout passPhotoLayout, ImageView photo1, TextView photo1Annexure, TextView photo1Name, TextView photo1Size, ImageView photo2, TextView photo2Annexure, LinearLayout photo2Layout, TextView photo2Name, TextView photo2Size, TextView photoNameTv2, TextView photoSize, RadioGroup selectDetails, EditText spouseEpicNumber, Button submitButtonDoc, Button submitButtonRec, LinearLayout submitLayout, TextView textView3) {
        this.rootView = rootView;
        this.aadharNumber = aadharNumber;
        this.annexPage1Layout = annexPage1Layout;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.bornInIndia = bornInIndia;
        this.cancel = cancel;
        this.cancelPhoto1Annexure = cancelPhoto1Annexure;
        this.cancelPhoto2Annexure = cancelPhoto2Annexure;
        this.chooseFileTv = chooseFileTv;
        this.dateOfBirth = dateOfBirth;
        this.fatherEpicNumber = fatherEpicNumber;
        this.image = image;
        this.indianCitizen = indianCitizen;
        this.indianWithPriorVoterID = indianWithPriorVoterID;
        this.main = main;
        this.mobileNumber = mobileNumber;
        this.motherEpicNumber = motherEpicNumber;
        this.nextButton = nextButton;
        this.noDocument = noDocument;
        this.notBornInIndia = notBornInIndia;
        this.orAnnex = orAnnex;
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
        this.selectDetails = selectDetails;
        this.spouseEpicNumber = spouseEpicNumber;
        this.submitButtonDoc = submitButtonDoc;
        this.submitButtonRec = submitButtonRec;
        this.submitLayout = submitLayout;
        this.textView3 = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySpecialRevisionDetailsBhBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySpecialRevisionDetailsBhBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_special_revision_details_bh, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySpecialRevisionDetailsBhBinding bind(View rootView) {
        int i = R.id.aadharNumber;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.aadharNumber);
        if (editText != null) {
            i = R.id.annexPage1Layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.annexPage1Layout);
            if (linearLayout != null) {
                i = R.id.back_btn_iv;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                if (imageView != null) {
                    i = R.id.bla_top_layout;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
                    if (constraintLayoutFindChildViewById != null) {
                        i = R.id.bornInIndia;
                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.bornInIndia);
                        if (radioButton != null) {
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
                                                i = R.id.fatherEpicNumber;
                                                EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.fatherEpicNumber);
                                                if (editText3 != null) {
                                                    i = 2131364258;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, 2131364258);
                                                    if (imageView5 != null) {
                                                        i = R.id.indianCitizen;
                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.indianCitizen);
                                                        if (radioButton2 != null) {
                                                            i = R.id.indianWithPriorVoterID;
                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.indianWithPriorVoterID);
                                                            if (radioButton3 != null) {
                                                                LinearLayout linearLayout2 = (LinearLayout) rootView;
                                                                i = R.id.mobileNumber;
                                                                EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobileNumber);
                                                                if (editText4 != null) {
                                                                    i = R.id.motherEpicNumber;
                                                                    EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.motherEpicNumber);
                                                                    if (editText5 != null) {
                                                                        i = R.id.nextButton;
                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nextButton);
                                                                        if (textView2 != null) {
                                                                            i = R.id.no_document;
                                                                            RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.no_document);
                                                                            if (radioButton4 != null) {
                                                                                i = R.id.notBornInIndia;
                                                                                RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.notBornInIndia);
                                                                                if (radioButton5 != null) {
                                                                                    i = R.id.orAnnex;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.orAnnex);
                                                                                    if (textView3 != null) {
                                                                                        i = R.id.passPhoto;
                                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.passPhoto);
                                                                                        if (linearLayout3 != null) {
                                                                                            i = R.id.pass_photo_layout;
                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pass_photo_layout);
                                                                                            if (linearLayout4 != null) {
                                                                                                i = R.id.photo1;
                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.photo1);
                                                                                                if (imageView6 != null) {
                                                                                                    i = R.id.photo1_annexure;
                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo1_annexure);
                                                                                                    if (textView4 != null) {
                                                                                                        i = R.id.photo1_name;
                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo1_name);
                                                                                                        if (textView5 != null) {
                                                                                                            i = R.id.photo1_size;
                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo1_size);
                                                                                                            if (textView6 != null) {
                                                                                                                i = R.id.photo2;
                                                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.photo2);
                                                                                                                if (imageView7 != null) {
                                                                                                                    i = R.id.photo2_annexure;
                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo2_annexure);
                                                                                                                    if (textView7 != null) {
                                                                                                                        i = R.id.photo2Layout;
                                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.photo2Layout);
                                                                                                                        if (linearLayout5 != null) {
                                                                                                                            i = R.id.photo2_name;
                                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo2_name);
                                                                                                                            if (textView8 != null) {
                                                                                                                                i = R.id.photo2_size;
                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo2_size);
                                                                                                                                if (textView9 != null) {
                                                                                                                                    i = R.id.photo_name_tv2;
                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo_name_tv2);
                                                                                                                                    if (textView10 != null) {
                                                                                                                                        i = R.id.photo_size;
                                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photo_size);
                                                                                                                                        if (textView11 != null) {
                                                                                                                                            i = R.id.selectDetails;
                                                                                                                                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.selectDetails);
                                                                                                                                            if (radioGroup != null) {
                                                                                                                                                i = R.id.spouseEpicNumber;
                                                                                                                                                EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.spouseEpicNumber);
                                                                                                                                                if (editText6 != null) {
                                                                                                                                                    i = R.id.submitButtonDoc;
                                                                                                                                                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submitButtonDoc);
                                                                                                                                                    if (button != null) {
                                                                                                                                                        i = R.id.submitButtonRec;
                                                                                                                                                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.submitButtonRec);
                                                                                                                                                        if (button2 != null) {
                                                                                                                                                            i = R.id.submitLayout;
                                                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.submitLayout);
                                                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                                                i = R.id.textView3;
                                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                                                if (textView12 != null) {
                                                                                                                                                                    return new ActivitySpecialRevisionDetailsBhBinding(linearLayout2, editText, linearLayout, imageView, constraintLayoutFindChildViewById, radioButton, imageView2, imageView3, imageView4, textView, editText2, editText3, imageView5, radioButton2, radioButton3, linearLayout2, editText4, editText5, textView2, radioButton4, radioButton5, textView3, linearLayout3, linearLayout4, imageView6, textView4, textView5, textView6, imageView7, textView7, linearLayout5, textView8, textView9, textView10, textView11, radioGroup, editText6, button, button2, linearLayout6, textView12);
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
