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
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class ActivitySpecialRevisionBhBinding implements ViewBinding {
    public final TextView addressSR;
    public final TextView addressTv;
    public final TextView ageSR;
    public final TextView ageTv;
    public final TextView applicantEpicSR;
    public final TextView applicantNameSR;
    public final TextView applicantNameTv;
    public final TextView asmblyTv;
    public final ImageView backBtnIv;
    public final LinearLayout basicdetailsHeading;
    public final ConstraintLayout blaTopLayout;
    public final ConstraintLayout bottomSubmitLayout;
    public final TextView dobSR;
    public final TextView dobTv;
    public final TextView electorAssemblySR;
    public final LinearLayout electorDetailsLayout;
    public final EditText enterEPICSR;
    public final LinearLayout enterEpicLayout;
    public final TextView epicTv;
    public final TextView imageEnlargeTv;
    public final LinearLayout main;
    public final Button nextTv;
    public final TextView partSR;
    public final TextView partTv;
    public final ImageView personImage;
    public final TextView relativeNameSR;
    public final TextView relativeNameTv;
    private final LinearLayout rootView;
    public final LinearLayout scanLayout;
    public final Button scanNow;
    public final RadioButton scannerQR;
    public final ScrollView scrollLayout;
    public final RadioGroup searchElectorsRadioGroup;
    public final RadioButton searchEpicSR;
    public final TextView sectionNameSR;
    public final TextView sectionTv;
    public final TextView serialSR;
    public final TextView serialTv;
    public final LinearLayout subBasicdetails1;
    public final LinearLayout subBasicdetails2;
    public final Button submitEpic;
    public final TextView textView3;
    public final Button viewPhoto;

    private ActivitySpecialRevisionBhBinding(LinearLayout rootView, TextView addressSR, TextView addressTv, TextView ageSR, TextView ageTv, TextView applicantEpicSR, TextView applicantNameSR, TextView applicantNameTv, TextView asmblyTv, ImageView backBtnIv, LinearLayout basicdetailsHeading, ConstraintLayout blaTopLayout, ConstraintLayout bottomSubmitLayout, TextView dobSR, TextView dobTv, TextView electorAssemblySR, LinearLayout electorDetailsLayout, EditText enterEPICSR, LinearLayout enterEpicLayout, TextView epicTv, TextView imageEnlargeTv, LinearLayout main, Button nextTv, TextView partSR, TextView partTv, ImageView personImage, TextView relativeNameSR, TextView relativeNameTv, LinearLayout scanLayout, Button scanNow, RadioButton scannerQR, ScrollView scrollLayout, RadioGroup searchElectorsRadioGroup, RadioButton searchEpicSR, TextView sectionNameSR, TextView sectionTv, TextView serialSR, TextView serialTv, LinearLayout subBasicdetails1, LinearLayout subBasicdetails2, Button submitEpic, TextView textView3, Button viewPhoto) {
        this.rootView = rootView;
        this.addressSR = addressSR;
        this.addressTv = addressTv;
        this.ageSR = ageSR;
        this.ageTv = ageTv;
        this.applicantEpicSR = applicantEpicSR;
        this.applicantNameSR = applicantNameSR;
        this.applicantNameTv = applicantNameTv;
        this.asmblyTv = asmblyTv;
        this.backBtnIv = backBtnIv;
        this.basicdetailsHeading = basicdetailsHeading;
        this.blaTopLayout = blaTopLayout;
        this.bottomSubmitLayout = bottomSubmitLayout;
        this.dobSR = dobSR;
        this.dobTv = dobTv;
        this.electorAssemblySR = electorAssemblySR;
        this.electorDetailsLayout = electorDetailsLayout;
        this.enterEPICSR = enterEPICSR;
        this.enterEpicLayout = enterEpicLayout;
        this.epicTv = epicTv;
        this.imageEnlargeTv = imageEnlargeTv;
        this.main = main;
        this.nextTv = nextTv;
        this.partSR = partSR;
        this.partTv = partTv;
        this.personImage = personImage;
        this.relativeNameSR = relativeNameSR;
        this.relativeNameTv = relativeNameTv;
        this.scanLayout = scanLayout;
        this.scanNow = scanNow;
        this.scannerQR = scannerQR;
        this.scrollLayout = scrollLayout;
        this.searchElectorsRadioGroup = searchElectorsRadioGroup;
        this.searchEpicSR = searchEpicSR;
        this.sectionNameSR = sectionNameSR;
        this.sectionTv = sectionTv;
        this.serialSR = serialSR;
        this.serialTv = serialTv;
        this.subBasicdetails1 = subBasicdetails1;
        this.subBasicdetails2 = subBasicdetails2;
        this.submitEpic = submitEpic;
        this.textView3 = textView3;
        this.viewPhoto = viewPhoto;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySpecialRevisionBhBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySpecialRevisionBhBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_special_revision_bh, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySpecialRevisionBhBinding bind(View rootView) {
        int i = R.id.addressSR;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.addressSR);
        if (textView != null) {
            i = R.id.address_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_tv);
            if (textView2 != null) {
                i = R.id.ageSR;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ageSR);
                if (textView3 != null) {
                    i = R.id.age_tv;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.age_tv);
                    if (textView4 != null) {
                        i = R.id.applicantEpicSR;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicantEpicSR);
                        if (textView5 != null) {
                            i = R.id.applicantNameSR;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicantNameSR);
                            if (textView6 != null) {
                                i = R.id.applicant_name_tv;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_name_tv);
                                if (textView7 != null) {
                                    i = R.id.asmbly_tv;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.asmbly_tv);
                                    if (textView8 != null) {
                                        i = R.id.back_btn_iv;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                                        if (imageView != null) {
                                            i = R.id.basicdetails_heading;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.basicdetails_heading);
                                            if (linearLayout != null) {
                                                i = R.id.bla_top_layout;
                                                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
                                                if (constraintLayoutFindChildViewById != null) {
                                                    i = R.id.bottom_submit_layout;
                                                    ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.bottom_submit_layout);
                                                    if (constraintLayoutFindChildViewById2 != null) {
                                                        i = R.id.dobSR;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dobSR);
                                                        if (textView9 != null) {
                                                            i = R.id.dob_tv;
                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dob_tv);
                                                            if (textView10 != null) {
                                                                i = R.id.electorAssemblySR;
                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorAssemblySR);
                                                                if (textView11 != null) {
                                                                    i = R.id.electorDetailsLayout;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.electorDetailsLayout);
                                                                    if (linearLayout2 != null) {
                                                                        i = R.id.enterEPICSR;
                                                                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.enterEPICSR);
                                                                        if (editText != null) {
                                                                            i = R.id.enterEpicLayout;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.enterEpicLayout);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.epic_tv;
                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_tv);
                                                                                if (textView12 != null) {
                                                                                    i = R.id.image_enlarge_tv;
                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.image_enlarge_tv);
                                                                                    if (textView13 != null) {
                                                                                        LinearLayout linearLayout4 = (LinearLayout) rootView;
                                                                                        i = R.id.next_tv;
                                                                                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.next_tv);
                                                                                        if (button != null) {
                                                                                            i = R.id.partSR;
                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partSR);
                                                                                            if (textView14 != null) {
                                                                                                i = R.id.part_tv;
                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.part_tv);
                                                                                                if (textView15 != null) {
                                                                                                    i = R.id.person_image;
                                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.person_image);
                                                                                                    if (imageView2 != null) {
                                                                                                        i = R.id.relativeNameSR;
                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relativeNameSR);
                                                                                                        if (textView16 != null) {
                                                                                                            i = R.id.relativeName_tv;
                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relativeName_tv);
                                                                                                            if (textView17 != null) {
                                                                                                                i = R.id.scanLayout;
                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.scanLayout);
                                                                                                                if (linearLayout5 != null) {
                                                                                                                    i = R.id.scan_now;
                                                                                                                    Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.scan_now);
                                                                                                                    if (button2 != null) {
                                                                                                                        i = R.id.scannerQR;
                                                                                                                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.scannerQR);
                                                                                                                        if (radioButton != null) {
                                                                                                                            i = R.id.scrollLayout;
                                                                                                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollLayout);
                                                                                                                            if (scrollView != null) {
                                                                                                                                i = R.id.search_electors_radioGroup;
                                                                                                                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.search_electors_radioGroup);
                                                                                                                                if (radioGroup != null) {
                                                                                                                                    i = R.id.searchEpicSR;
                                                                                                                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.searchEpicSR);
                                                                                                                                    if (radioButton2 != null) {
                                                                                                                                        i = R.id.sectionNameSR;
                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sectionNameSR);
                                                                                                                                        if (textView18 != null) {
                                                                                                                                            i = R.id.section_tv;
                                                                                                                                            TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.section_tv);
                                                                                                                                            if (textView19 != null) {
                                                                                                                                                i = R.id.serialSR;
                                                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serialSR);
                                                                                                                                                if (textView20 != null) {
                                                                                                                                                    i = R.id.serial_tv;
                                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serial_tv);
                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                        i = R.id.sub_basicdetails1;
                                                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails1);
                                                                                                                                                        if (linearLayout6 != null) {
                                                                                                                                                            i = R.id.sub_basicdetails2;
                                                                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails2);
                                                                                                                                                            if (linearLayout7 != null) {
                                                                                                                                                                i = R.id.submit_epic;
                                                                                                                                                                Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.submit_epic);
                                                                                                                                                                if (button3 != null) {
                                                                                                                                                                    i = R.id.textView3;
                                                                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                                                    if (textView22 != null) {
                                                                                                                                                                        i = R.id.viewPhoto;
                                                                                                                                                                        Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.viewPhoto);
                                                                                                                                                                        if (button4 != null) {
                                                                                                                                                                            return new ActivitySpecialRevisionBhBinding(linearLayout4, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, imageView, linearLayout, constraintLayoutFindChildViewById, constraintLayoutFindChildViewById2, textView9, textView10, textView11, linearLayout2, editText, linearLayout3, textView12, textView13, linearLayout4, button, textView14, textView15, imageView2, textView16, textView17, linearLayout5, button2, radioButton, scrollView, radioGroup, radioButton2, textView18, textView19, textView20, textView21, linearLayout6, linearLayout7, button3, textView22, button4);
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
