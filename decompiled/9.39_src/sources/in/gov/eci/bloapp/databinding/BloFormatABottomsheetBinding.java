package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFormatABottomsheetBinding implements ViewBinding {
    public final TextView addressTv1;
    public final EditText ageEt;
    public final TextView ageTv;
    public final TextView applicantNameTv;
    public final ConstraintLayout bottomSubmitForm8generated;
    public final ConstraintLayout bottomSubmitForm8generation;
    public final ConstraintLayout bottomSubmitLayout;
    public final ConstraintLayout bottomSubmitLayout2;
    public final Button chooseFile;
    public final ImageButton chooseFileDeletion;
    public final TextView chooseFileName;
    public final TextView chooseFileNameSize;
    public final TextView clusterid;
    public final TextView clusteridTv;
    public final ImageView crossDialog;
    public final TextView dateInclusionEt;
    public final TextView dateInclusionTv;
    public final LinearLayout detailsLy;
    public final EditText epicNoEt;
    public final TextView epicNoTv;
    public final TextView genderTv;
    public final TextView genderTv1;
    public final LinearLayout imageLayout;
    public final ImageView imageView;
    public final ImageView personImage;
    public final CardView personalDetailsCv;
    public final ImageView preview;
    public final TextView relationtype;
    public final TextView relativeTv;
    public final TextView relativeTv1;
    public final TextView remarkLabel;
    public final EditText remarkUploadTv;
    private final ConstraintLayout rootView;
    public final TextView serialNo;
    public final LinearLayout subBasicdetails1;
    public final LinearLayout subBasicdetails2;
    public final TextView submitDisplay;
    public final Button submitForm8request;
    public final Button submitTv;
    public final TextView uploadFormatATv;
    public final View view2;

    private BloFormatABottomsheetBinding(ConstraintLayout rootView, TextView addressTv1, EditText ageEt, TextView ageTv, TextView applicantNameTv, ConstraintLayout bottomSubmitForm8generated, ConstraintLayout bottomSubmitForm8generation, ConstraintLayout bottomSubmitLayout, ConstraintLayout bottomSubmitLayout2, Button chooseFile, ImageButton chooseFileDeletion, TextView chooseFileName, TextView chooseFileNameSize, TextView clusterid, TextView clusteridTv, ImageView crossDialog, TextView dateInclusionEt, TextView dateInclusionTv, LinearLayout detailsLy, EditText epicNoEt, TextView epicNoTv, TextView genderTv, TextView genderTv1, LinearLayout imageLayout, ImageView imageView, ImageView personImage, CardView personalDetailsCv, ImageView preview, TextView relationtype, TextView relativeTv, TextView relativeTv1, TextView remarkLabel, EditText remarkUploadTv, TextView serialNo, LinearLayout subBasicdetails1, LinearLayout subBasicdetails2, TextView submitDisplay, Button submitForm8request, Button submitTv, TextView uploadFormatATv, View view2) {
        this.rootView = rootView;
        this.addressTv1 = addressTv1;
        this.ageEt = ageEt;
        this.ageTv = ageTv;
        this.applicantNameTv = applicantNameTv;
        this.bottomSubmitForm8generated = bottomSubmitForm8generated;
        this.bottomSubmitForm8generation = bottomSubmitForm8generation;
        this.bottomSubmitLayout = bottomSubmitLayout;
        this.bottomSubmitLayout2 = bottomSubmitLayout2;
        this.chooseFile = chooseFile;
        this.chooseFileDeletion = chooseFileDeletion;
        this.chooseFileName = chooseFileName;
        this.chooseFileNameSize = chooseFileNameSize;
        this.clusterid = clusterid;
        this.clusteridTv = clusteridTv;
        this.crossDialog = crossDialog;
        this.dateInclusionEt = dateInclusionEt;
        this.dateInclusionTv = dateInclusionTv;
        this.detailsLy = detailsLy;
        this.epicNoEt = epicNoEt;
        this.epicNoTv = epicNoTv;
        this.genderTv = genderTv;
        this.genderTv1 = genderTv1;
        this.imageLayout = imageLayout;
        this.imageView = imageView;
        this.personImage = personImage;
        this.personalDetailsCv = personalDetailsCv;
        this.preview = preview;
        this.relationtype = relationtype;
        this.relativeTv = relativeTv;
        this.relativeTv1 = relativeTv1;
        this.remarkLabel = remarkLabel;
        this.remarkUploadTv = remarkUploadTv;
        this.serialNo = serialNo;
        this.subBasicdetails1 = subBasicdetails1;
        this.subBasicdetails2 = subBasicdetails2;
        this.submitDisplay = submitDisplay;
        this.submitForm8request = submitForm8request;
        this.submitTv = submitTv;
        this.uploadFormatATv = uploadFormatATv;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFormatABottomsheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFormatABottomsheetBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_format_a_bottomsheet, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFormatABottomsheetBinding bind(View rootView) {
        int i = R.id.address_tv1;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_tv1);
        if (textView != null) {
            i = R.id.age_et;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.age_et);
            if (editText != null) {
                i = R.id.age_tv;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.age_tv);
                if (textView2 != null) {
                    i = R.id.applicant_name_tv;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_name_tv);
                    if (textView3 != null) {
                        i = R.id.bottom_submit_form8generated;
                        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_submit_form8generated);
                        if (constraintLayoutFindChildViewById != null) {
                            i = R.id.bottom_submit_form8generation;
                            ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.bottom_submit_form8generation);
                            if (constraintLayoutFindChildViewById2 != null) {
                                i = R.id.bottom_submit_layout;
                                ConstraintLayout constraintLayoutFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.bottom_submit_layout);
                                if (constraintLayoutFindChildViewById3 != null) {
                                    i = R.id.bottom_submit_layout2;
                                    ConstraintLayout constraintLayoutFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.bottom_submit_layout2);
                                    if (constraintLayoutFindChildViewById4 != null) {
                                        i = R.id.choose_file;
                                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.choose_file);
                                        if (button != null) {
                                            i = R.id.choose_file_deletion;
                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.choose_file_deletion);
                                            if (imageButton != null) {
                                                i = R.id.choose_file_name;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_name);
                                                if (textView4 != null) {
                                                    i = R.id.choose_file_name_size;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_name_size);
                                                    if (textView5 != null) {
                                                        i = R.id.clusterid;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.clusterid);
                                                        if (textView6 != null) {
                                                            i = R.id.clusterid_tv;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.clusterid_tv);
                                                            if (textView7 != null) {
                                                                i = R.id.cross_dialog;
                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cross_dialog);
                                                                if (imageView != null) {
                                                                    i = R.id.date_inclusion_et;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_inclusion_et);
                                                                    if (textView8 != null) {
                                                                        i = R.id.date_inclusion_tv;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_inclusion_tv);
                                                                        if (textView9 != null) {
                                                                            i = R.id.details_ly;
                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.details_ly);
                                                                            if (linearLayout != null) {
                                                                                i = R.id.epic_no_et;
                                                                                EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.epic_no_et);
                                                                                if (editText2 != null) {
                                                                                    i = R.id.epic_no_tv;
                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_no_tv);
                                                                                    if (textView10 != null) {
                                                                                        i = R.id.gender_tv;
                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender_tv);
                                                                                        if (textView11 != null) {
                                                                                            i = R.id.gender_tv1;
                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender_tv1);
                                                                                            if (textView12 != null) {
                                                                                                i = R.id.image_layout;
                                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.image_layout);
                                                                                                if (linearLayout2 != null) {
                                                                                                    i = R.id.imageView;
                                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
                                                                                                    if (imageView2 != null) {
                                                                                                        i = R.id.person_image;
                                                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.person_image);
                                                                                                        if (imageView3 != null) {
                                                                                                            i = R.id.personal_details_cv;
                                                                                                            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.personal_details_cv);
                                                                                                            if (cardViewFindChildViewById != null) {
                                                                                                                i = R.id.preview;
                                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.preview);
                                                                                                                if (imageView4 != null) {
                                                                                                                    i = R.id.relationtype;
                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relationtype);
                                                                                                                    if (textView13 != null) {
                                                                                                                        i = R.id.relative_tv;
                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_tv);
                                                                                                                        if (textView14 != null) {
                                                                                                                            i = R.id.relative_tv1;
                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_tv1);
                                                                                                                            if (textView15 != null) {
                                                                                                                                i = R.id.remark_label;
                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remark_label);
                                                                                                                                if (textView16 != null) {
                                                                                                                                    i = R.id.remarkUpload_tv;
                                                                                                                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.remarkUpload_tv);
                                                                                                                                    if (editText3 != null) {
                                                                                                                                        i = R.id.serial_no;
                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serial_no);
                                                                                                                                        if (textView17 != null) {
                                                                                                                                            i = R.id.sub_basicdetails1;
                                                                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails1);
                                                                                                                                            if (linearLayout3 != null) {
                                                                                                                                                i = R.id.sub_basicdetails2;
                                                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails2);
                                                                                                                                                if (linearLayout4 != null) {
                                                                                                                                                    i = R.id.submit_display;
                                                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submit_display);
                                                                                                                                                    if (textView18 != null) {
                                                                                                                                                        i = R.id.submit_form8request;
                                                                                                                                                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.submit_form8request);
                                                                                                                                                        if (button2 != null) {
                                                                                                                                                            i = R.id.submit_tv;
                                                                                                                                                            Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.submit_tv);
                                                                                                                                                            if (button3 != null) {
                                                                                                                                                                i = R.id.upload_format_A_tv;
                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upload_format_A_tv);
                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                    i = R.id.view2;
                                                                                                                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                                                                                                                                    if (viewFindChildViewById != null) {
                                                                                                                                                                        return new BloFormatABottomsheetBinding((ConstraintLayout) rootView, textView, editText, textView2, textView3, constraintLayoutFindChildViewById, constraintLayoutFindChildViewById2, constraintLayoutFindChildViewById3, constraintLayoutFindChildViewById4, button, imageButton, textView4, textView5, textView6, textView7, imageView, textView8, textView9, linearLayout, editText2, textView10, textView11, textView12, linearLayout2, imageView2, imageView3, cardViewFindChildViewById, imageView4, textView13, textView14, textView15, textView16, editText3, textView17, linearLayout3, linearLayout4, textView18, button2, button3, textView19, viewFindChildViewById);
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
