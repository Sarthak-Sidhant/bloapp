package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloNameRvItemBinding implements ViewBinding {
    public final TextView AcTv;
    public final TextView ApplicantNameTv;
    public final TextView ApplicantSurnameTv;
    public final TextView ac;
    public final TextView applicantName;
    public final RadioButton applicantNameRb;
    public final RadioButton applicantNameRb2;
    public final TextView applicantNameTv;
    public final TextView applicantSurname;
    public final TextView epicNumberTv;
    public final TextView epicNumberTv1;
    public final ConstraintLayout epiclayout;
    public final TextView gender;
    public final TextView genderTv;
    public final ConstraintLayout layout;
    public final ConstraintLayout nameLayout;
    public final TextView partNumber;
    public final TextView partNumberTv;
    public final LinearLayout partSerialLayout;
    public final TextView partTv;
    public final TextView partTv1;
    public final ImageView personImage;
    public final TextView relativeName;
    public final TextView relativeNameTv;
    public final TextView relativeSurname;
    public final TextView relativeSurnameTv;
    private final ConstraintLayout rootView;
    public final TextView serialNoTv;
    public final TextView serialNumber;
    public final TextView serialNumberTv;
    public final TextView serialTv;
    public final TextView serialTv1;
    public final TextView state;
    public final TextView stateTv;
    public final LinearLayout subBasicdetails1;
    public final LinearLayout subBasicdetails2;
    public final View view2;

    private BloNameRvItemBinding(ConstraintLayout rootView, TextView AcTv, TextView ApplicantNameTv, TextView ApplicantSurnameTv, TextView ac, TextView applicantName, RadioButton applicantNameRb, RadioButton applicantNameRb2, TextView applicantNameTv, TextView applicantSurname, TextView epicNumberTv, TextView epicNumberTv1, ConstraintLayout epiclayout, TextView gender, TextView genderTv, ConstraintLayout layout, ConstraintLayout nameLayout, TextView partNumber, TextView partNumberTv, LinearLayout partSerialLayout, TextView partTv, TextView partTv1, ImageView personImage, TextView relativeName, TextView relativeNameTv, TextView relativeSurname, TextView relativeSurnameTv, TextView serialNoTv, TextView serialNumber, TextView serialNumberTv, TextView serialTv, TextView serialTv1, TextView state, TextView stateTv, LinearLayout subBasicdetails1, LinearLayout subBasicdetails2, View view2) {
        this.rootView = rootView;
        this.AcTv = AcTv;
        this.ApplicantNameTv = ApplicantNameTv;
        this.ApplicantSurnameTv = ApplicantSurnameTv;
        this.ac = ac;
        this.applicantName = applicantName;
        this.applicantNameRb = applicantNameRb;
        this.applicantNameRb2 = applicantNameRb2;
        this.applicantNameTv = applicantNameTv;
        this.applicantSurname = applicantSurname;
        this.epicNumberTv = epicNumberTv;
        this.epicNumberTv1 = epicNumberTv1;
        this.epiclayout = epiclayout;
        this.gender = gender;
        this.genderTv = genderTv;
        this.layout = layout;
        this.nameLayout = nameLayout;
        this.partNumber = partNumber;
        this.partNumberTv = partNumberTv;
        this.partSerialLayout = partSerialLayout;
        this.partTv = partTv;
        this.partTv1 = partTv1;
        this.personImage = personImage;
        this.relativeName = relativeName;
        this.relativeNameTv = relativeNameTv;
        this.relativeSurname = relativeSurname;
        this.relativeSurnameTv = relativeSurnameTv;
        this.serialNoTv = serialNoTv;
        this.serialNumber = serialNumber;
        this.serialNumberTv = serialNumberTv;
        this.serialTv = serialTv;
        this.serialTv1 = serialTv1;
        this.state = state;
        this.stateTv = stateTv;
        this.subBasicdetails1 = subBasicdetails1;
        this.subBasicdetails2 = subBasicdetails2;
        this.view2 = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloNameRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloNameRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_name_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloNameRvItemBinding bind(View rootView) {
        int i = R.id.Ac_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.Ac_tv);
        if (textView != null) {
            i = R.id.Applicant_name_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Applicant_name_tv);
            if (textView2 != null) {
                i = R.id.Applicant_surname_tv;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Applicant_surname_tv);
                if (textView3 != null) {
                    i = R.id.ac;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ac);
                    if (textView4 != null) {
                        i = R.id.applicant_name;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_name);
                        if (textView5 != null) {
                            i = R.id.applicant_name_rb;
                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.applicant_name_rb);
                            if (radioButton != null) {
                                i = R.id.applicant_name_rb2;
                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.applicant_name_rb2);
                                if (radioButton2 != null) {
                                    i = R.id.applicant_name_tv;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_name_tv);
                                    if (textView6 != null) {
                                        i = R.id.applicant_surname;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_surname);
                                        if (textView7 != null) {
                                            i = R.id.epic_number_tv;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_number_tv);
                                            if (textView8 != null) {
                                                i = R.id.epic_number_tv1;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_number_tv1);
                                                if (textView9 != null) {
                                                    i = R.id.epiclayout;
                                                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.epiclayout);
                                                    if (constraintLayoutFindChildViewById != null) {
                                                        i = R.id.gender;
                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender);
                                                        if (textView10 != null) {
                                                            i = R.id.gender_tv;
                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender_tv);
                                                            if (textView11 != null) {
                                                                i = 2131364291;
                                                                ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, 2131364291);
                                                                if (constraintLayoutFindChildViewById2 != null) {
                                                                    i = R.id.nameLayout;
                                                                    ConstraintLayout constraintLayoutFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.nameLayout);
                                                                    if (constraintLayoutFindChildViewById3 != null) {
                                                                        i = R.id.partNumber;
                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partNumber);
                                                                        if (textView12 != null) {
                                                                            i = R.id.partNumber_tv;
                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partNumber_tv);
                                                                            if (textView13 != null) {
                                                                                i = R.id.part_serial_layout;
                                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.part_serial_layout);
                                                                                if (linearLayout != null) {
                                                                                    i = R.id.part_tv;
                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.part_tv);
                                                                                    if (textView14 != null) {
                                                                                        i = R.id.part_tv1;
                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.part_tv1);
                                                                                        if (textView15 != null) {
                                                                                            i = R.id.person_image;
                                                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.person_image);
                                                                                            if (imageView != null) {
                                                                                                i = R.id.relative_name;
                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_name);
                                                                                                if (textView16 != null) {
                                                                                                    i = R.id.relative_name_tv;
                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_name_tv);
                                                                                                    if (textView17 != null) {
                                                                                                        i = R.id.relative_surname;
                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_surname);
                                                                                                        if (textView18 != null) {
                                                                                                            i = R.id.relative_surname_Tv;
                                                                                                            TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_surname_Tv);
                                                                                                            if (textView19 != null) {
                                                                                                                i = R.id.serial_no_tv;
                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serial_no_tv);
                                                                                                                if (textView20 != null) {
                                                                                                                    i = R.id.serialNumber;
                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNumber);
                                                                                                                    if (textView21 != null) {
                                                                                                                        i = R.id.serialNumber_tv;
                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialNumber_tv);
                                                                                                                        if (textView22 != null) {
                                                                                                                            i = R.id.serial_tv;
                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serial_tv);
                                                                                                                            if (textView23 != null) {
                                                                                                                                i = R.id.serial_tv1;
                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serial_tv1);
                                                                                                                                if (textView24 != null) {
                                                                                                                                    i = R.id.state;
                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state);
                                                                                                                                    if (textView25 != null) {
                                                                                                                                        i = R.id.state_tv;
                                                                                                                                        TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv);
                                                                                                                                        if (textView26 != null) {
                                                                                                                                            i = R.id.sub_basicdetails1;
                                                                                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails1);
                                                                                                                                            if (linearLayout2 != null) {
                                                                                                                                                i = R.id.sub_basicdetails2;
                                                                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails2);
                                                                                                                                                if (linearLayout3 != null) {
                                                                                                                                                    i = R.id.view2;
                                                                                                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                                                                                                                    if (viewFindChildViewById != null) {
                                                                                                                                                        return new BloNameRvItemBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, textView5, radioButton, radioButton2, textView6, textView7, textView8, textView9, constraintLayoutFindChildViewById, textView10, textView11, constraintLayoutFindChildViewById2, constraintLayoutFindChildViewById3, textView12, textView13, linearLayout, textView14, textView15, imageView, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, linearLayout2, linearLayout3, viewFindChildViewById);
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
