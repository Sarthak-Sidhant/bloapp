package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentNewVoterRegistrationBinding implements ViewBinding {
    public final TextView assemblyRb;
    public final TextView assemblySpinner;
    public final TextView constituencyNo;
    public final TextInputEditText districtSpinnerSelect;
    public final TextView districtTv;
    public final ConstraintLayout fragmentLocationEditLayout;
    public final ConstraintLayout layoutDepartment;
    private final ConstraintLayout rootView;
    public final TextView stateSpinner;
    public final TextView stateTv;
    public final TextView textView;
    public final View viewLocSpinner;
    public final View viewSpinner;

    private BloFragmentNewVoterRegistrationBinding(ConstraintLayout rootView, TextView assemblyRb, TextView assemblySpinner, TextView constituencyNo, TextInputEditText districtSpinnerSelect, TextView districtTv, ConstraintLayout fragmentLocationEditLayout, ConstraintLayout layoutDepartment, TextView stateSpinner, TextView stateTv, TextView textView, View viewLocSpinner, View viewSpinner) {
        this.rootView = rootView;
        this.assemblyRb = assemblyRb;
        this.assemblySpinner = assemblySpinner;
        this.constituencyNo = constituencyNo;
        this.districtSpinnerSelect = districtSpinnerSelect;
        this.districtTv = districtTv;
        this.fragmentLocationEditLayout = fragmentLocationEditLayout;
        this.layoutDepartment = layoutDepartment;
        this.stateSpinner = stateSpinner;
        this.stateTv = stateTv;
        this.textView = textView;
        this.viewLocSpinner = viewLocSpinner;
        this.viewSpinner = viewSpinner;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloFragmentNewVoterRegistrationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentNewVoterRegistrationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_new_voter_registration, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentNewVoterRegistrationBinding bind(View rootView) {
        int i = R.id.assembly_rb;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.assembly_rb);
        if (textView != null) {
            i = R.id.assembly_spinner;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.assembly_spinner);
            if (textView2 != null) {
                i = R.id.constituencyNo;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.constituencyNo);
                if (textView3 != null) {
                    i = R.id.district_spinner_select;
                    TextInputEditText textInputEditTextFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.district_spinner_select);
                    if (textInputEditTextFindChildViewById != null) {
                        i = R.id.district_tv;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_tv);
                        if (textView4 != null) {
                            i = R.id.fragment_location_edit_layout;
                            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.fragment_location_edit_layout);
                            if (constraintLayoutFindChildViewById != null) {
                                i = R.id.layoutDepartment;
                                ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.layoutDepartment);
                                if (constraintLayoutFindChildViewById2 != null) {
                                    i = R.id.state_spinner;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_spinner);
                                    if (textView5 != null) {
                                        i = R.id.state_tv;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv);
                                        if (textView6 != null) {
                                            i = R.id.text_view;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.text_view);
                                            if (textView7 != null) {
                                                i = R.id.view_loc_spinner;
                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_loc_spinner);
                                                if (viewFindChildViewById != null) {
                                                    i = R.id.view_spinner;
                                                    View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view_spinner);
                                                    if (viewFindChildViewById2 != null) {
                                                        return new BloFragmentNewVoterRegistrationBinding((ConstraintLayout) rootView, textView, textView2, textView3, textInputEditTextFindChildViewById, textView4, constraintLayoutFindChildViewById, constraintLayoutFindChildViewById2, textView5, textView6, textView7, viewFindChildViewById, viewFindChildViewById2);
                                                    }
                                                }
                                            }
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
