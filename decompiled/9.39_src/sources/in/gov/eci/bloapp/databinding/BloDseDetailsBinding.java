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
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloDseDetailsBinding implements ViewBinding {
    public final TextView ActionTv;
    public final LinearLayout DoneLayout;
    public final TextView addressTv1;
    public final EditText ageEt;
    public final TextView ageTv;
    public final TextView applicantNameTv;
    public final RadioButton asdRb;
    public final ConstraintLayout bottomSubmitLayout;
    public final Button chooseFile1;
    public final ImageButton chooseFileDeletion1;
    public final TextView chooseFileName1;
    public final TextView chooseFileNameSize1;
    public final ImageView crossDialog;
    public final TextView dateInclusionEt;
    public final TextView dateInclusionTv;
    public final LinearLayout deletionReason;
    public final NoDefaultSpinner deletionspinner;
    public final LinearLayout detailsLy;
    public final RadioButton dupicateRb;
    public final EditText epicNoEt;
    public final TextView epicNoTv;
    public final ConstraintLayout fillForm7;
    public final Button fillForm7btn;
    public final ConstraintLayout fillForm8;
    public final Button fillForm8btn;
    public final View form7DeletionSpinner;
    public final TextView genderTv;
    public final TextView genderTv1;
    public final ImageView imageView;
    public final RadioGroup matchingAc;
    public final RadioButton noinformationRb;
    public final RadioGroup notmatchingAc;
    public final RadioButton originalRb;
    public final LinearLayout pendingLayout;
    public final LinearLayout pendingRemark;
    public final ImageView personImage;
    public final CardView personalDetailsCv;
    public final ImageView preview1;
    public final TextView relationtype;
    public final TextView relativeTv;
    public final TextView relativeTv1;
    public final EditText remarkTv;
    public final EditText remarkUploadTv;
    private final ConstraintLayout rootView;
    public final TextView serialNo;
    public final LinearLayout subBasicdetails1;
    public final LinearLayout subBasicdetails2;
    public final Button submitTv;
    public final LinearLayout uploadFormatA;

    private BloDseDetailsBinding(ConstraintLayout rootView, TextView ActionTv, LinearLayout DoneLayout, TextView addressTv1, EditText ageEt, TextView ageTv, TextView applicantNameTv, RadioButton asdRb, ConstraintLayout bottomSubmitLayout, Button chooseFile1, ImageButton chooseFileDeletion1, TextView chooseFileName1, TextView chooseFileNameSize1, ImageView crossDialog, TextView dateInclusionEt, TextView dateInclusionTv, LinearLayout deletionReason, NoDefaultSpinner deletionspinner, LinearLayout detailsLy, RadioButton dupicateRb, EditText epicNoEt, TextView epicNoTv, ConstraintLayout fillForm7, Button fillForm7btn, ConstraintLayout fillForm8, Button fillForm8btn, View form7DeletionSpinner, TextView genderTv, TextView genderTv1, ImageView imageView, RadioGroup matchingAc, RadioButton noinformationRb, RadioGroup notmatchingAc, RadioButton originalRb, LinearLayout pendingLayout, LinearLayout pendingRemark, ImageView personImage, CardView personalDetailsCv, ImageView preview1, TextView relationtype, TextView relativeTv, TextView relativeTv1, EditText remarkTv, EditText remarkUploadTv, TextView serialNo, LinearLayout subBasicdetails1, LinearLayout subBasicdetails2, Button submitTv, LinearLayout uploadFormatA) {
        this.rootView = rootView;
        this.ActionTv = ActionTv;
        this.DoneLayout = DoneLayout;
        this.addressTv1 = addressTv1;
        this.ageEt = ageEt;
        this.ageTv = ageTv;
        this.applicantNameTv = applicantNameTv;
        this.asdRb = asdRb;
        this.bottomSubmitLayout = bottomSubmitLayout;
        this.chooseFile1 = chooseFile1;
        this.chooseFileDeletion1 = chooseFileDeletion1;
        this.chooseFileName1 = chooseFileName1;
        this.chooseFileNameSize1 = chooseFileNameSize1;
        this.crossDialog = crossDialog;
        this.dateInclusionEt = dateInclusionEt;
        this.dateInclusionTv = dateInclusionTv;
        this.deletionReason = deletionReason;
        this.deletionspinner = deletionspinner;
        this.detailsLy = detailsLy;
        this.dupicateRb = dupicateRb;
        this.epicNoEt = epicNoEt;
        this.epicNoTv = epicNoTv;
        this.fillForm7 = fillForm7;
        this.fillForm7btn = fillForm7btn;
        this.fillForm8 = fillForm8;
        this.fillForm8btn = fillForm8btn;
        this.form7DeletionSpinner = form7DeletionSpinner;
        this.genderTv = genderTv;
        this.genderTv1 = genderTv1;
        this.imageView = imageView;
        this.matchingAc = matchingAc;
        this.noinformationRb = noinformationRb;
        this.notmatchingAc = notmatchingAc;
        this.originalRb = originalRb;
        this.pendingLayout = pendingLayout;
        this.pendingRemark = pendingRemark;
        this.personImage = personImage;
        this.personalDetailsCv = personalDetailsCv;
        this.preview1 = preview1;
        this.relationtype = relationtype;
        this.relativeTv = relativeTv;
        this.relativeTv1 = relativeTv1;
        this.remarkTv = remarkTv;
        this.remarkUploadTv = remarkUploadTv;
        this.serialNo = serialNo;
        this.subBasicdetails1 = subBasicdetails1;
        this.subBasicdetails2 = subBasicdetails2;
        this.submitTv = submitTv;
        this.uploadFormatA = uploadFormatA;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloDseDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloDseDetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_dse_details, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloDseDetailsBinding bind(View rootView) {
        int i = R.id.Action_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.Action_tv);
        if (textView != null) {
            i = R.id.Done_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.Done_layout);
            if (linearLayout != null) {
                i = R.id.address_tv1;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_tv1);
                if (textView2 != null) {
                    i = R.id.age_et;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.age_et);
                    if (editText != null) {
                        i = R.id.age_tv;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.age_tv);
                        if (textView3 != null) {
                            i = R.id.applicant_name_tv;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_name_tv);
                            if (textView4 != null) {
                                i = R.id.asd_rb;
                                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.asd_rb);
                                if (radioButton != null) {
                                    i = R.id.bottom_submit_layout;
                                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_submit_layout);
                                    if (constraintLayoutFindChildViewById != null) {
                                        i = R.id.choose_file1;
                                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.choose_file1);
                                        if (button != null) {
                                            i = R.id.choose_file_deletion1;
                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.choose_file_deletion1);
                                            if (imageButton != null) {
                                                i = R.id.choose_file_name1;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_name1);
                                                if (textView5 != null) {
                                                    i = R.id.choose_file_name_size1;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_name_size1);
                                                    if (textView6 != null) {
                                                        i = R.id.cross_dialog;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cross_dialog);
                                                        if (imageView != null) {
                                                            i = R.id.date_inclusion_et;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_inclusion_et);
                                                            if (textView7 != null) {
                                                                i = R.id.date_inclusion_tv;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_inclusion_tv);
                                                                if (textView8 != null) {
                                                                    i = R.id.deletionReason;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.deletionReason);
                                                                    if (linearLayout2 != null) {
                                                                        i = R.id.deletionspinner;
                                                                        NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.deletionspinner);
                                                                        if (noDefaultSpinner != null) {
                                                                            i = R.id.details_ly;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.details_ly);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.dupicate_rb;
                                                                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.dupicate_rb);
                                                                                if (radioButton2 != null) {
                                                                                    i = R.id.epic_no_et;
                                                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.epic_no_et);
                                                                                    if (editText2 != null) {
                                                                                        i = R.id.epic_no_tv;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_no_tv);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.fill_form_7;
                                                                                            ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.fill_form_7);
                                                                                            if (constraintLayoutFindChildViewById2 != null) {
                                                                                                i = R.id.fill_form_7btn;
                                                                                                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.fill_form_7btn);
                                                                                                if (button2 != null) {
                                                                                                    i = R.id.fill_form_8;
                                                                                                    ConstraintLayout constraintLayoutFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.fill_form_8);
                                                                                                    if (constraintLayoutFindChildViewById3 != null) {
                                                                                                        i = R.id.fill_form_8btn;
                                                                                                        Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.fill_form_8btn);
                                                                                                        if (button3 != null) {
                                                                                                            i = R.id.form7_deletion_spinner;
                                                                                                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.form7_deletion_spinner);
                                                                                                            if (viewFindChildViewById != null) {
                                                                                                                i = R.id.gender_tv;
                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender_tv);
                                                                                                                if (textView10 != null) {
                                                                                                                    i = R.id.gender_tv1;
                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender_tv1);
                                                                                                                    if (textView11 != null) {
                                                                                                                        i = R.id.imageView;
                                                                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
                                                                                                                        if (imageView2 != null) {
                                                                                                                            i = R.id.matching_ac;
                                                                                                                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.matching_ac);
                                                                                                                            if (radioGroup != null) {
                                                                                                                                i = R.id.noinformation_rb;
                                                                                                                                RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.noinformation_rb);
                                                                                                                                if (radioButton3 != null) {
                                                                                                                                    i = R.id.notmatching_ac;
                                                                                                                                    RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.notmatching_ac);
                                                                                                                                    if (radioGroup2 != null) {
                                                                                                                                        i = R.id.original_rb;
                                                                                                                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.original_rb);
                                                                                                                                        if (radioButton4 != null) {
                                                                                                                                            i = R.id.pending_layout;
                                                                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pending_layout);
                                                                                                                                            if (linearLayout4 != null) {
                                                                                                                                                i = R.id.pending_remark;
                                                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pending_remark);
                                                                                                                                                if (linearLayout5 != null) {
                                                                                                                                                    i = R.id.person_image;
                                                                                                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.person_image);
                                                                                                                                                    if (imageView3 != null) {
                                                                                                                                                        i = R.id.personal_details_cv;
                                                                                                                                                        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.personal_details_cv);
                                                                                                                                                        if (cardViewFindChildViewById != null) {
                                                                                                                                                            i = R.id.preview1;
                                                                                                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.preview1);
                                                                                                                                                            if (imageView4 != null) {
                                                                                                                                                                i = R.id.relationtype;
                                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relationtype);
                                                                                                                                                                if (textView12 != null) {
                                                                                                                                                                    i = R.id.relative_tv;
                                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_tv);
                                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                                        i = R.id.relative_tv1;
                                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_tv1);
                                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                                            i = R.id.remark_tv;
                                                                                                                                                                            EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.remark_tv);
                                                                                                                                                                            if (editText3 != null) {
                                                                                                                                                                                i = R.id.remarkUpload_tv;
                                                                                                                                                                                EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.remarkUpload_tv);
                                                                                                                                                                                if (editText4 != null) {
                                                                                                                                                                                    i = R.id.serial_no;
                                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serial_no);
                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                        i = R.id.sub_basicdetails1;
                                                                                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails1);
                                                                                                                                                                                        if (linearLayout6 != null) {
                                                                                                                                                                                            i = R.id.sub_basicdetails2;
                                                                                                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails2);
                                                                                                                                                                                            if (linearLayout7 != null) {
                                                                                                                                                                                                i = R.id.submit_tv;
                                                                                                                                                                                                Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.submit_tv);
                                                                                                                                                                                                if (button4 != null) {
                                                                                                                                                                                                    i = R.id.uploadFormatA;
                                                                                                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.uploadFormatA);
                                                                                                                                                                                                    if (linearLayout8 != null) {
                                                                                                                                                                                                        return new BloDseDetailsBinding((ConstraintLayout) rootView, textView, linearLayout, textView2, editText, textView3, textView4, radioButton, constraintLayoutFindChildViewById, button, imageButton, textView5, textView6, imageView, textView7, textView8, linearLayout2, noDefaultSpinner, linearLayout3, radioButton2, editText2, textView9, constraintLayoutFindChildViewById2, button2, constraintLayoutFindChildViewById3, button3, viewFindChildViewById, textView10, textView11, imageView2, radioGroup, radioButton3, radioGroup2, radioButton4, linearLayout4, linearLayout5, imageView3, cardViewFindChildViewById, imageView4, textView12, textView13, textView14, editText3, editText4, textView15, linearLayout6, linearLayout7, button4, linearLayout8);
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
