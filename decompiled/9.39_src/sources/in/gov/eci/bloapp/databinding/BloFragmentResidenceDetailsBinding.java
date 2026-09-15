package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloFragmentResidenceDetailsBinding implements ViewBinding {
    public final TextView chooseFile3;
    public final TextView chooseFileSizeTv3;
    public final TextView chooseFileTv3;
    public final ImageView deleteUploadedResidence;
    public final NoDefaultSpinner districtSpinnerResidence;
    public final TextView districtSpinnerTv;
    public final TextView districtTv;
    public final RadioButton dobProofRb;
    public final RadioGroup docRg;
    public final NoDefaultSpinner docTypeSpinner;
    public final ConstraintLayout fragmentLocationEditLayout;
    public final EditText houseNoEd;
    public final ConstraintLayout layoutDepartment;
    public final LinearLayout linearLayout3;
    public final LinearLayout linearLayout6;
    public final LinearLayout linearLayout9;
    public final EditText otherDocEd;
    public final RadioButton otherDocRb;
    public final ImageView photo3;
    public final TextView pincodeEd;
    public final ConstraintLayout postOfficeLayout;
    public final NoDefaultSpinner postOfficeSpinner;
    public final TextView postOfficeTv;
    private final ScrollView rootView;
    public final NoDefaultSpinner stateSpinner;
    public final TextView stateSpinnerTv;
    public final TextView stateTv;
    public final EditText streetEd;
    public final ConstraintLayout tehsilLayout;
    public final NoDefaultSpinner tehsilSpinner;
    public final TextView tehsilTv;
    public final ConstraintLayout townLayout;
    public final NoDefaultSpinner townSpinner;
    public final TextView townTv;
    public final View view;
    public final View view2;
    public final View viewLocSpinner;
    public final View viewOther;
    public final View viewPin;
    public final View viewPostSpinner;
    public final View viewResidence;
    public final View viewSpinner;
    public final View viewTehsilSpinner;
    public final View viewTownSpinner;

    private BloFragmentResidenceDetailsBinding(ScrollView rootView, TextView chooseFile3, TextView chooseFileSizeTv3, TextView chooseFileTv3, ImageView deleteUploadedResidence, NoDefaultSpinner districtSpinnerResidence, TextView districtSpinnerTv, TextView districtTv, RadioButton dobProofRb, RadioGroup docRg, NoDefaultSpinner docTypeSpinner, ConstraintLayout fragmentLocationEditLayout, EditText houseNoEd, ConstraintLayout layoutDepartment, LinearLayout linearLayout3, LinearLayout linearLayout6, LinearLayout linearLayout9, EditText otherDocEd, RadioButton otherDocRb, ImageView photo3, TextView pincodeEd, ConstraintLayout postOfficeLayout, NoDefaultSpinner postOfficeSpinner, TextView postOfficeTv, NoDefaultSpinner stateSpinner, TextView stateSpinnerTv, TextView stateTv, EditText streetEd, ConstraintLayout tehsilLayout, NoDefaultSpinner tehsilSpinner, TextView tehsilTv, ConstraintLayout townLayout, NoDefaultSpinner townSpinner, TextView townTv, View view, View view2, View viewLocSpinner, View viewOther, View viewPin, View viewPostSpinner, View viewResidence, View viewSpinner, View viewTehsilSpinner, View viewTownSpinner) {
        this.rootView = rootView;
        this.chooseFile3 = chooseFile3;
        this.chooseFileSizeTv3 = chooseFileSizeTv3;
        this.chooseFileTv3 = chooseFileTv3;
        this.deleteUploadedResidence = deleteUploadedResidence;
        this.districtSpinnerResidence = districtSpinnerResidence;
        this.districtSpinnerTv = districtSpinnerTv;
        this.districtTv = districtTv;
        this.dobProofRb = dobProofRb;
        this.docRg = docRg;
        this.docTypeSpinner = docTypeSpinner;
        this.fragmentLocationEditLayout = fragmentLocationEditLayout;
        this.houseNoEd = houseNoEd;
        this.layoutDepartment = layoutDepartment;
        this.linearLayout3 = linearLayout3;
        this.linearLayout6 = linearLayout6;
        this.linearLayout9 = linearLayout9;
        this.otherDocEd = otherDocEd;
        this.otherDocRb = otherDocRb;
        this.photo3 = photo3;
        this.pincodeEd = pincodeEd;
        this.postOfficeLayout = postOfficeLayout;
        this.postOfficeSpinner = postOfficeSpinner;
        this.postOfficeTv = postOfficeTv;
        this.stateSpinner = stateSpinner;
        this.stateSpinnerTv = stateSpinnerTv;
        this.stateTv = stateTv;
        this.streetEd = streetEd;
        this.tehsilLayout = tehsilLayout;
        this.tehsilSpinner = tehsilSpinner;
        this.tehsilTv = tehsilTv;
        this.townLayout = townLayout;
        this.townSpinner = townSpinner;
        this.townTv = townTv;
        this.view = view;
        this.view2 = view2;
        this.viewLocSpinner = viewLocSpinner;
        this.viewOther = viewOther;
        this.viewPin = viewPin;
        this.viewPostSpinner = viewPostSpinner;
        this.viewResidence = viewResidence;
        this.viewSpinner = viewSpinner;
        this.viewTehsilSpinner = viewTehsilSpinner;
        this.viewTownSpinner = viewTownSpinner;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BloFragmentResidenceDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentResidenceDetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_residence_details, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentResidenceDetailsBinding bind(View rootView) {
        int i = R.id.choose_file_3;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_3);
        if (textView != null) {
            i = R.id.choose_file_size_tv3;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_size_tv3);
            if (textView2 != null) {
                i = R.id.choose_file_tv3;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_tv3);
                if (textView3 != null) {
                    i = R.id.delete_uploaded_residence;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.delete_uploaded_residence);
                    if (imageView != null) {
                        i = R.id.district_spinner_residence;
                        NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.district_spinner_residence);
                        if (noDefaultSpinner != null) {
                            i = R.id.district_spinner_tv;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_spinner_tv);
                            if (textView4 != null) {
                                i = R.id.district_tv;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_tv);
                                if (textView5 != null) {
                                    i = R.id.dob_proof_rb;
                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.dob_proof_rb);
                                    if (radioButton != null) {
                                        i = R.id.doc_rg;
                                        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.doc_rg);
                                        if (radioGroup != null) {
                                            i = R.id.doc_type_spinner;
                                            NoDefaultSpinner noDefaultSpinner2 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.doc_type_spinner);
                                            if (noDefaultSpinner2 != null) {
                                                i = R.id.fragment_location_edit_layout;
                                                ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.fragment_location_edit_layout);
                                                if (constraintLayoutFindChildViewById != null) {
                                                    i = R.id.house_no_ed;
                                                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.house_no_ed);
                                                    if (editText != null) {
                                                        i = R.id.layoutDepartment;
                                                        ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.layoutDepartment);
                                                        if (constraintLayoutFindChildViewById2 != null) {
                                                            i = R.id.linearLayout3;
                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout3);
                                                            if (linearLayout != null) {
                                                                i = R.id.linearLayout6;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout6);
                                                                if (linearLayout2 != null) {
                                                                    i = R.id.linearLayout9;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout9);
                                                                    if (linearLayout3 != null) {
                                                                        i = R.id.other_doc_ed;
                                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.other_doc_ed);
                                                                        if (editText2 != null) {
                                                                            i = R.id.other_doc_rb;
                                                                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.other_doc_rb);
                                                                            if (radioButton2 != null) {
                                                                                i = R.id.photo3;
                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.photo3);
                                                                                if (imageView2 != null) {
                                                                                    i = R.id.pincode_ed;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pincode_ed);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.post_office_layout;
                                                                                        ConstraintLayout constraintLayoutFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.post_office_layout);
                                                                                        if (constraintLayoutFindChildViewById3 != null) {
                                                                                            i = R.id.post_office_spinner;
                                                                                            NoDefaultSpinner noDefaultSpinner3 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.post_office_spinner);
                                                                                            if (noDefaultSpinner3 != null) {
                                                                                                i = R.id.post_office_tv;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.post_office_tv);
                                                                                                if (textView7 != null) {
                                                                                                    i = R.id.state_spinner;
                                                                                                    NoDefaultSpinner noDefaultSpinner4 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.state_spinner);
                                                                                                    if (noDefaultSpinner4 != null) {
                                                                                                        i = R.id.state_spinner_tv;
                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_spinner_tv);
                                                                                                        if (textView8 != null) {
                                                                                                            i = R.id.state_tv;
                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv);
                                                                                                            if (textView9 != null) {
                                                                                                                i = R.id.street_ed;
                                                                                                                EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.street_ed);
                                                                                                                if (editText3 != null) {
                                                                                                                    i = R.id.tehsil_layout;
                                                                                                                    ConstraintLayout constraintLayoutFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.tehsil_layout);
                                                                                                                    if (constraintLayoutFindChildViewById4 != null) {
                                                                                                                        i = R.id.tehsil_spinner;
                                                                                                                        NoDefaultSpinner noDefaultSpinner5 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.tehsil_spinner);
                                                                                                                        if (noDefaultSpinner5 != null) {
                                                                                                                            i = R.id.tehsil_tv;
                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tehsil_tv);
                                                                                                                            if (textView10 != null) {
                                                                                                                                i = R.id.town_layout;
                                                                                                                                ConstraintLayout constraintLayoutFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.town_layout);
                                                                                                                                if (constraintLayoutFindChildViewById5 != null) {
                                                                                                                                    i = R.id.town_spinner;
                                                                                                                                    NoDefaultSpinner noDefaultSpinner6 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.town_spinner);
                                                                                                                                    if (noDefaultSpinner6 != null) {
                                                                                                                                        i = R.id.town_tv;
                                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.town_tv);
                                                                                                                                        if (textView11 != null) {
                                                                                                                                            i = R.id.view;
                                                                                                                                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view);
                                                                                                                                            if (viewFindChildViewById != null) {
                                                                                                                                                i = R.id.view2;
                                                                                                                                                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                                                                                                                if (viewFindChildViewById2 != null) {
                                                                                                                                                    i = R.id.view_loc_spinner;
                                                                                                                                                    View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.view_loc_spinner);
                                                                                                                                                    if (viewFindChildViewById3 != null) {
                                                                                                                                                        i = R.id.view_other;
                                                                                                                                                        View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.view_other);
                                                                                                                                                        if (viewFindChildViewById4 != null) {
                                                                                                                                                            i = R.id.view_pin;
                                                                                                                                                            View viewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.view_pin);
                                                                                                                                                            if (viewFindChildViewById5 != null) {
                                                                                                                                                                i = R.id.view_post_spinner;
                                                                                                                                                                View viewFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.view_post_spinner);
                                                                                                                                                                if (viewFindChildViewById6 != null) {
                                                                                                                                                                    i = R.id.view_residence;
                                                                                                                                                                    View viewFindChildViewById7 = ViewBindings.findChildViewById(rootView, R.id.view_residence);
                                                                                                                                                                    if (viewFindChildViewById7 != null) {
                                                                                                                                                                        i = R.id.view_spinner;
                                                                                                                                                                        View viewFindChildViewById8 = ViewBindings.findChildViewById(rootView, R.id.view_spinner);
                                                                                                                                                                        if (viewFindChildViewById8 != null) {
                                                                                                                                                                            i = R.id.view_tehsil_spinner;
                                                                                                                                                                            View viewFindChildViewById9 = ViewBindings.findChildViewById(rootView, R.id.view_tehsil_spinner);
                                                                                                                                                                            if (viewFindChildViewById9 != null) {
                                                                                                                                                                                i = R.id.view_town_spinner;
                                                                                                                                                                                View viewFindChildViewById10 = ViewBindings.findChildViewById(rootView, R.id.view_town_spinner);
                                                                                                                                                                                if (viewFindChildViewById10 != null) {
                                                                                                                                                                                    return new BloFragmentResidenceDetailsBinding((ScrollView) rootView, textView, textView2, textView3, imageView, noDefaultSpinner, textView4, textView5, radioButton, radioGroup, noDefaultSpinner2, constraintLayoutFindChildViewById, editText, constraintLayoutFindChildViewById2, linearLayout, linearLayout2, linearLayout3, editText2, radioButton2, imageView2, textView6, constraintLayoutFindChildViewById3, noDefaultSpinner3, textView7, noDefaultSpinner4, textView8, textView9, editText3, constraintLayoutFindChildViewById4, noDefaultSpinner5, textView10, constraintLayoutFindChildViewById5, noDefaultSpinner6, textView11, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, viewFindChildViewById6, viewFindChildViewById7, viewFindChildViewById8, viewFindChildViewById9, viewFindChildViewById10);
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
