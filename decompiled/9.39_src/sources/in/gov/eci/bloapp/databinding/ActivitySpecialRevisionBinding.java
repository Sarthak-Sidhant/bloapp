package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivitySpecialRevisionBinding implements ViewBinding {
    public final TextView addressSR;
    public final TextView addressTv;
    public final TextView ageSR;
    public final TextView ageTv;
    public final TextView applicantEpicSR;
    public final TextView applicantNameSR;
    public final TextView applicantNameTv;
    public final TextView asmblyTv;
    public final ImageView backBtnIv;
    public final RelativeLayout basicdetailsHeading;
    public final ConstraintLayout blaTopLayout;
    public final ConstraintLayout bottomSubmitLayout;
    public final LinearLayout details1;
    public final LinearLayout detailsHeading1;
    public final LinearLayout detailsHeadingAddress;
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
    public final Button scanBtn;
    public final LinearLayout scanLayout;
    public final MaterialButton scannerQR;
    public final ScrollView scrollLayout;
    public final MaterialButton searchEpicSR;
    public final TextView sectionNameSR;
    public final TextView sectionTv;
    public final TextView serialSR;
    public final TextView serialTv;
    public final LinearLayout subBasicdetails1;
    public final LinearLayout subBasicdetails2;
    public final LinearLayout subBasicdetails3;
    public final MaterialButton submitEpic;
    public final LinearLayout tabContainer;
    public final FrameLayout tabLayout;
    public final TextView textView3;
    public final ImageView toolbarButton;
    public final TextView view1;
    public final TextView view2;
    public final Button viewPhoto;

    private ActivitySpecialRevisionBinding(LinearLayout rootView, TextView addressSR, TextView addressTv, TextView ageSR, TextView ageTv, TextView applicantEpicSR, TextView applicantNameSR, TextView applicantNameTv, TextView asmblyTv, ImageView backBtnIv, RelativeLayout basicdetailsHeading, ConstraintLayout blaTopLayout, ConstraintLayout bottomSubmitLayout, LinearLayout details1, LinearLayout detailsHeading1, LinearLayout detailsHeadingAddress, TextView dobSR, TextView dobTv, TextView electorAssemblySR, LinearLayout electorDetailsLayout, EditText enterEPICSR, LinearLayout enterEpicLayout, TextView epicTv, TextView imageEnlargeTv, LinearLayout main, Button nextTv, TextView partSR, TextView partTv, ImageView personImage, TextView relativeNameSR, TextView relativeNameTv, Button scanBtn, LinearLayout scanLayout, MaterialButton scannerQR, ScrollView scrollLayout, MaterialButton searchEpicSR, TextView sectionNameSR, TextView sectionTv, TextView serialSR, TextView serialTv, LinearLayout subBasicdetails1, LinearLayout subBasicdetails2, LinearLayout subBasicdetails3, MaterialButton submitEpic, LinearLayout tabContainer, FrameLayout tabLayout, TextView textView3, ImageView toolbarButton, TextView view1, TextView view2, Button viewPhoto) {
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
        this.details1 = details1;
        this.detailsHeading1 = detailsHeading1;
        this.detailsHeadingAddress = detailsHeadingAddress;
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
        this.scanBtn = scanBtn;
        this.scanLayout = scanLayout;
        this.scannerQR = scannerQR;
        this.scrollLayout = scrollLayout;
        this.searchEpicSR = searchEpicSR;
        this.sectionNameSR = sectionNameSR;
        this.sectionTv = sectionTv;
        this.serialSR = serialSR;
        this.serialTv = serialTv;
        this.subBasicdetails1 = subBasicdetails1;
        this.subBasicdetails2 = subBasicdetails2;
        this.subBasicdetails3 = subBasicdetails3;
        this.submitEpic = submitEpic;
        this.tabContainer = tabContainer;
        this.tabLayout = tabLayout;
        this.textView3 = textView3;
        this.toolbarButton = toolbarButton;
        this.view1 = view1;
        this.view2 = view2;
        this.viewPhoto = viewPhoto;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySpecialRevisionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySpecialRevisionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_special_revision, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySpecialRevisionBinding bind(View rootView) {
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
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.basicdetails_heading);
                                            if (relativeLayout != null) {
                                                i = R.id.bla_top_layout;
                                                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
                                                if (constraintLayoutFindChildViewById != null) {
                                                    i = R.id.bottom_submit_layout;
                                                    ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.bottom_submit_layout);
                                                    if (constraintLayoutFindChildViewById2 != null) {
                                                        i = R.id.details1;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.details1);
                                                        if (linearLayout != null) {
                                                            i = R.id.details_heading1;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.details_heading1);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.details_heading_address;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.details_heading_address);
                                                                if (linearLayout3 != null) {
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
                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.electorDetailsLayout);
                                                                                if (linearLayout4 != null) {
                                                                                    i = R.id.enterEPICSR;
                                                                                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.enterEPICSR);
                                                                                    if (editText != null) {
                                                                                        i = R.id.enterEpicLayout;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.enterEpicLayout);
                                                                                        if (linearLayout5 != null) {
                                                                                            i = R.id.epic_tv;
                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_tv);
                                                                                            if (textView12 != null) {
                                                                                                i = R.id.image_enlarge_tv;
                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.image_enlarge_tv);
                                                                                                if (textView13 != null) {
                                                                                                    LinearLayout linearLayout6 = (LinearLayout) rootView;
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
                                                                                                                            i = R.id.scanBtn;
                                                                                                                            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.scanBtn);
                                                                                                                            if (button2 != null) {
                                                                                                                                i = R.id.scanLayout;
                                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.scanLayout);
                                                                                                                                if (linearLayout7 != null) {
                                                                                                                                    i = R.id.scannerQR;
                                                                                                                                    MaterialButton materialButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.scannerQR);
                                                                                                                                    if (materialButtonFindChildViewById != null) {
                                                                                                                                        i = R.id.scrollLayout;
                                                                                                                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollLayout);
                                                                                                                                        if (scrollView != null) {
                                                                                                                                            i = R.id.searchEpicSR;
                                                                                                                                            MaterialButton materialButtonFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.searchEpicSR);
                                                                                                                                            if (materialButtonFindChildViewById2 != null) {
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
                                                                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails1);
                                                                                                                                                                if (linearLayout8 != null) {
                                                                                                                                                                    i = R.id.sub_basicdetails2;
                                                                                                                                                                    LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails2);
                                                                                                                                                                    if (linearLayout9 != null) {
                                                                                                                                                                        i = R.id.sub_basicdetails3;
                                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails3);
                                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                                            i = R.id.submit_epic;
                                                                                                                                                                            MaterialButton materialButtonFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.submit_epic);
                                                                                                                                                                            if (materialButtonFindChildViewById3 != null) {
                                                                                                                                                                                i = R.id.tabContainer;
                                                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.tabContainer);
                                                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                                                    i = R.id.tabLayout;
                                                                                                                                                                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.tabLayout);
                                                                                                                                                                                    if (frameLayout != null) {
                                                                                                                                                                                        i = R.id.textView3;
                                                                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                                                                                        if (textView22 != null) {
                                                                                                                                                                                            i = R.id.toolbar_button;
                                                                                                                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                                                                                                                                                            if (imageView3 != null) {
                                                                                                                                                                                                i = R.id.view1;
                                                                                                                                                                                                TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.view1);
                                                                                                                                                                                                if (textView23 != null) {
                                                                                                                                                                                                    i = R.id.view2;
                                                                                                                                                                                                    TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.view2);
                                                                                                                                                                                                    if (textView24 != null) {
                                                                                                                                                                                                        i = R.id.viewPhoto;
                                                                                                                                                                                                        Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.viewPhoto);
                                                                                                                                                                                                        if (button3 != null) {
                                                                                                                                                                                                            return new ActivitySpecialRevisionBinding(linearLayout6, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, imageView, relativeLayout, constraintLayoutFindChildViewById, constraintLayoutFindChildViewById2, linearLayout, linearLayout2, linearLayout3, textView9, textView10, textView11, linearLayout4, editText, linearLayout5, textView12, textView13, linearLayout6, button, textView14, textView15, imageView2, textView16, textView17, button2, linearLayout7, materialButtonFindChildViewById, scrollView, materialButtonFindChildViewById2, textView18, textView19, textView20, textView21, linearLayout8, linearLayout9, linearLayout10, materialButtonFindChildViewById3, linearLayout11, frameLayout, textView22, imageView3, textView23, textView24, button3);
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
