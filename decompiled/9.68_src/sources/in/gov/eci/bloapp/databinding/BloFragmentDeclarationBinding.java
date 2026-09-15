package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentDeclarationBinding implements ViewBinding {
    public final ImageView calendarIv;
    public final TextView dateEd;
    public final NoDefaultSpinner districtSpinner;
    public final TextView districtSpinnerTv;
    public final TextView districtTv;
    public final TextView dobEd;
    public final EditText docNameEd;
    public final ConstraintLayout fragmentLocationEditLayout;
    public final ConstraintLayout fragmentStateEditLayout;
    public final EditText placeEd;
    private final ScrollView rootView;
    public final NoDefaultSpinner stateSpinner;
    public final TextView stateSpinnerTv;
    public final TextView stateTv;
    public final ConstraintLayout townLayout;
    public final NoDefaultSpinner townSpinner2;
    public final TextView townTv;
    public final TextView tv;
    public final View view;
    public final View view2;
    public final View view3;
    public final View view4;
    public final View viewDistrictSpinner;
    public final View viewStateSpinner;
    public final View viewTownSpinner;

    private BloFragmentDeclarationBinding(ScrollView rootView, ImageView calendarIv, TextView dateEd, NoDefaultSpinner districtSpinner, TextView districtSpinnerTv, TextView districtTv, TextView dobEd, EditText docNameEd, ConstraintLayout fragmentLocationEditLayout, ConstraintLayout fragmentStateEditLayout, EditText placeEd, NoDefaultSpinner stateSpinner, TextView stateSpinnerTv, TextView stateTv, ConstraintLayout townLayout, NoDefaultSpinner townSpinner2, TextView townTv, TextView tv, View view, View view2, View view3, View view4, View viewDistrictSpinner, View viewStateSpinner, View viewTownSpinner) {
        this.rootView = rootView;
        this.calendarIv = calendarIv;
        this.dateEd = dateEd;
        this.districtSpinner = districtSpinner;
        this.districtSpinnerTv = districtSpinnerTv;
        this.districtTv = districtTv;
        this.dobEd = dobEd;
        this.docNameEd = docNameEd;
        this.fragmentLocationEditLayout = fragmentLocationEditLayout;
        this.fragmentStateEditLayout = fragmentStateEditLayout;
        this.placeEd = placeEd;
        this.stateSpinner = stateSpinner;
        this.stateSpinnerTv = stateSpinnerTv;
        this.stateTv = stateTv;
        this.townLayout = townLayout;
        this.townSpinner2 = townSpinner2;
        this.townTv = townTv;
        this.tv = tv;
        this.view = view;
        this.view2 = view2;
        this.view3 = view3;
        this.view4 = view4;
        this.viewDistrictSpinner = viewDistrictSpinner;
        this.viewStateSpinner = viewStateSpinner;
        this.viewTownSpinner = viewTownSpinner;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BloFragmentDeclarationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentDeclarationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_declaration, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentDeclarationBinding bind(View rootView) {
        int i = R.id.calendar_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.calendar_iv);
        if (imageView != null) {
            i = R.id.date_ed;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_ed);
            if (textView != null) {
                i = R.id.district_spinner;
                NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.district_spinner);
                if (noDefaultSpinner != null) {
                    i = R.id.district_spinner_tv;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_spinner_tv);
                    if (textView2 != null) {
                        i = R.id.district_tv;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.district_tv);
                        if (textView3 != null) {
                            i = R.id.dob_ed;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dob_ed);
                            if (textView4 != null) {
                                i = R.id.doc_name_ed;
                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.doc_name_ed);
                                if (editText != null) {
                                    i = R.id.fragment_location_edit_layout;
                                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.fragment_location_edit_layout);
                                    if (constraintLayoutFindChildViewById != null) {
                                        i = R.id.fragment_state_edit_layout;
                                        ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.fragment_state_edit_layout);
                                        if (constraintLayoutFindChildViewById2 != null) {
                                            i = R.id.place_ed;
                                            EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.place_ed);
                                            if (editText2 != null) {
                                                i = R.id.state_spinner;
                                                NoDefaultSpinner noDefaultSpinner2 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.state_spinner);
                                                if (noDefaultSpinner2 != null) {
                                                    i = R.id.state_spinner_tv;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_spinner_tv);
                                                    if (textView5 != null) {
                                                        i = R.id.state_tv;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state_tv);
                                                        if (textView6 != null) {
                                                            i = R.id.town_layout;
                                                            ConstraintLayout constraintLayoutFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.town_layout);
                                                            if (constraintLayoutFindChildViewById3 != null) {
                                                                i = R.id.town_spinner2;
                                                                NoDefaultSpinner noDefaultSpinner3 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.town_spinner2);
                                                                if (noDefaultSpinner3 != null) {
                                                                    i = R.id.town_tv;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.town_tv);
                                                                    if (textView7 != null) {
                                                                        i = R.id.tv;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv);
                                                                        if (textView8 != null) {
                                                                            i = R.id.view;
                                                                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view);
                                                                            if (viewFindChildViewById != null) {
                                                                                i = R.id.view2;
                                                                                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                                                if (viewFindChildViewById2 != null) {
                                                                                    i = R.id.view3;
                                                                                    View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.view3);
                                                                                    if (viewFindChildViewById3 != null) {
                                                                                        i = R.id.view4;
                                                                                        View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.view4);
                                                                                        if (viewFindChildViewById4 != null) {
                                                                                            i = R.id.view_district_spinner;
                                                                                            View viewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.view_district_spinner);
                                                                                            if (viewFindChildViewById5 != null) {
                                                                                                i = R.id.view_state_spinner;
                                                                                                View viewFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.view_state_spinner);
                                                                                                if (viewFindChildViewById6 != null) {
                                                                                                    i = R.id.view_town_spinner;
                                                                                                    View viewFindChildViewById7 = ViewBindings.findChildViewById(rootView, R.id.view_town_spinner);
                                                                                                    if (viewFindChildViewById7 != null) {
                                                                                                        return new BloFragmentDeclarationBinding((ScrollView) rootView, imageView, textView, noDefaultSpinner, textView2, textView3, textView4, editText, constraintLayoutFindChildViewById, constraintLayoutFindChildViewById2, editText2, noDefaultSpinner2, textView5, textView6, constraintLayoutFindChildViewById3, noDefaultSpinner3, textView7, textView8, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, viewFindChildViewById6, viewFindChildViewById7);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
