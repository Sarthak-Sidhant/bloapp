package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public final class BloFragmentElectorsCanditateProfileBinding implements ViewBinding {
    public final TextView address;
    public final TextView addressL1;
    public final TextView age;
    public final TextView applicantName;
    public final TextView applicantNameL1;
    public final TextView assemblyConstituency;
    public final ImageView backBtnIv;
    public final LinearLayout basicdetailsHeading;
    public final ConstraintLayout bottomSubmitLayout;
    public final TextView buttonFillForm6B;
    public final TextView candidateName;
    public final CardView cardView;
    public final LinearLayout constraintLayout2;
    public final ImageButton dateOfBirthButton;
    public final TextView districtName;
    public final TextView epicNumber;
    public final TextView gender;
    public final ImageView homeButton;
    public final TextView imageEnlargeTv;
    public final ConstraintLayout mainLayout;
    public final TextView mobileNumber;
    public final TextView partNumber;
    public final ImageView personImage;
    public final ImageButton personalDetailButton;
    public final TextView relationtype;
    public final TextView relativeName;
    public final TextView relativeNameL1;
    public final TextView relativeTv;
    private final ConstraintLayout rootView;
    public final TextView sectionNo;
    public final TextView serialNumber;
    public final TextView state;
    public final LinearLayout subBasicdetails1;
    public final LinearLayout subBasicdetails2;

    private BloFragmentElectorsCanditateProfileBinding(ConstraintLayout rootView, TextView address, TextView addressL1, TextView age, TextView applicantName, TextView applicantNameL1, TextView assemblyConstituency, ImageView backBtnIv, LinearLayout basicdetailsHeading, ConstraintLayout bottomSubmitLayout, TextView buttonFillForm6B, TextView candidateName, CardView cardView, LinearLayout constraintLayout2, ImageButton dateOfBirthButton, TextView districtName, TextView epicNumber, TextView gender, ImageView homeButton, TextView imageEnlargeTv, ConstraintLayout mainLayout, TextView mobileNumber, TextView partNumber, ImageView personImage, ImageButton personalDetailButton, TextView relationtype, TextView relativeName, TextView relativeNameL1, TextView relativeTv, TextView sectionNo, TextView serialNumber, TextView state, LinearLayout subBasicdetails1, LinearLayout subBasicdetails2) {
        this.rootView = rootView;
        this.address = address;
        this.addressL1 = addressL1;
        this.age = age;
        this.applicantName = applicantName;
        this.applicantNameL1 = applicantNameL1;
        this.assemblyConstituency = assemblyConstituency;
        this.backBtnIv = backBtnIv;
        this.basicdetailsHeading = basicdetailsHeading;
        this.bottomSubmitLayout = bottomSubmitLayout;
        this.buttonFillForm6B = buttonFillForm6B;
        this.candidateName = candidateName;
        this.cardView = cardView;
        this.constraintLayout2 = constraintLayout2;
        this.dateOfBirthButton = dateOfBirthButton;
        this.districtName = districtName;
        this.epicNumber = epicNumber;
        this.gender = gender;
        this.homeButton = homeButton;
        this.imageEnlargeTv = imageEnlargeTv;
        this.mainLayout = mainLayout;
        this.mobileNumber = mobileNumber;
        this.partNumber = partNumber;
        this.personImage = personImage;
        this.personalDetailButton = personalDetailButton;
        this.relationtype = relationtype;
        this.relativeName = relativeName;
        this.relativeNameL1 = relativeNameL1;
        this.relativeTv = relativeTv;
        this.sectionNo = sectionNo;
        this.serialNumber = serialNumber;
        this.state = state;
        this.subBasicdetails1 = subBasicdetails1;
        this.subBasicdetails2 = subBasicdetails2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentElectorsCanditateProfileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentElectorsCanditateProfileBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_electors_canditate_profile, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentElectorsCanditateProfileBinding bind(View rootView) {
        int i = R.id.address;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.address);
        if (textView != null) {
            i = R.id.addressL1;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.addressL1);
            if (textView2 != null) {
                i = R.id.age;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.age);
                if (textView3 != null) {
                    i = R.id.applicant_name;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_name);
                    if (textView4 != null) {
                        i = R.id.applicant_nameL1;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.applicant_nameL1);
                        if (textView5 != null) {
                            i = R.id.assemblyConstituency;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.assemblyConstituency);
                            if (textView6 != null) {
                                i = R.id.back_btn_iv;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
                                if (imageView != null) {
                                    i = R.id.basicdetails_heading;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.basicdetails_heading);
                                    if (linearLayout != null) {
                                        i = R.id.bottom_submit_layout;
                                        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_submit_layout);
                                        if (constraintLayoutFindChildViewById != null) {
                                            i = R.id.buttonFillForm6B;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.buttonFillForm6B);
                                            if (textView7 != null) {
                                                i = R.id.candidateName;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.candidateName);
                                                if (textView8 != null) {
                                                    i = R.id.cardView;
                                                    CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.cardView);
                                                    if (cardViewFindChildViewById != null) {
                                                        i = R.id.constraintLayout2;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.constraintLayout2);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.date_of_birth_button;
                                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.date_of_birth_button);
                                                            if (imageButton != null) {
                                                                i = R.id.districtName;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.districtName);
                                                                if (textView9 != null) {
                                                                    i = R.id.epicNumber;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epicNumber);
                                                                    if (textView10 != null) {
                                                                        i = R.id.gender;
                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender);
                                                                        if (textView11 != null) {
                                                                            i = R.id.homeButton;
                                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.homeButton);
                                                                            if (imageView2 != null) {
                                                                                i = R.id.image_enlarge_tv;
                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.image_enlarge_tv);
                                                                                if (textView12 != null) {
                                                                                    i = R.id.mainLayout;
                                                                                    ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.mainLayout);
                                                                                    if (constraintLayoutFindChildViewById2 != null) {
                                                                                        i = R.id.mobileNumber;
                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobileNumber);
                                                                                        if (textView13 != null) {
                                                                                            i = R.id.partNumber;
                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partNumber);
                                                                                            if (textView14 != null) {
                                                                                                i = R.id.person_image;
                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.person_image);
                                                                                                if (imageView3 != null) {
                                                                                                    i = R.id.personal_detail_button;
                                                                                                    ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.personal_detail_button);
                                                                                                    if (imageButton2 != null) {
                                                                                                        i = R.id.relationtype;
                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relationtype);
                                                                                                        if (textView15 != null) {
                                                                                                            i = R.id.relativeName;
                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relativeName);
                                                                                                            if (textView16 != null) {
                                                                                                                i = R.id.relativeNameL1;
                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relativeNameL1);
                                                                                                                if (textView17 != null) {
                                                                                                                    i = R.id.relative_tv;
                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relative_tv);
                                                                                                                    if (textView18 != null) {
                                                                                                                        i = R.id.sectionNo;
                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sectionNo);
                                                                                                                        if (textView19 != null) {
                                                                                                                            i = R.id.serial_number;
                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serial_number);
                                                                                                                            if (textView20 != null) {
                                                                                                                                i = R.id.state;
                                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state);
                                                                                                                                if (textView21 != null) {
                                                                                                                                    i = R.id.sub_basicdetails1;
                                                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails1);
                                                                                                                                    if (linearLayout3 != null) {
                                                                                                                                        i = R.id.sub_basicdetails2;
                                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sub_basicdetails2);
                                                                                                                                        if (linearLayout4 != null) {
                                                                                                                                            return new BloFragmentElectorsCanditateProfileBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6, imageView, linearLayout, constraintLayoutFindChildViewById, textView7, textView8, cardViewFindChildViewById, linearLayout2, imageButton, textView9, textView10, textView11, imageView2, textView12, constraintLayoutFindChildViewById2, textView13, textView14, imageView3, imageButton2, textView15, textView16, textView17, textView18, textView19, textView20, textView21, linearLayout3, linearLayout4);
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
