package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentFamilyDetailsBinding implements ViewBinding {
    public final AppCompatEditText epicNoEd;
    public final ConstraintLayout fragmentLocationEditLayout;
    public final TextView headingTv5;
    public final EditText nameEd;
    public final NoDefaultSpinner relationshipSpinner;
    public final TextView relationshipTv;
    private final ScrollView rootView;
    public final View view;
    public final View view2;
    public final View view3;

    private BloFragmentFamilyDetailsBinding(ScrollView rootView, AppCompatEditText epicNoEd, ConstraintLayout fragmentLocationEditLayout, TextView headingTv5, EditText nameEd, NoDefaultSpinner relationshipSpinner, TextView relationshipTv, View view, View view2, View view3) {
        this.rootView = rootView;
        this.epicNoEd = epicNoEd;
        this.fragmentLocationEditLayout = fragmentLocationEditLayout;
        this.headingTv5 = headingTv5;
        this.nameEd = nameEd;
        this.relationshipSpinner = relationshipSpinner;
        this.relationshipTv = relationshipTv;
        this.view = view;
        this.view2 = view2;
        this.view3 = view3;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BloFragmentFamilyDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentFamilyDetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_family_details, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentFamilyDetailsBinding bind(View rootView) {
        int i = R.id.epic_no_ed;
        AppCompatEditText appCompatEditTextFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.epic_no_ed);
        if (appCompatEditTextFindChildViewById != null) {
            i = R.id.fragment_location_edit_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.fragment_location_edit_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.heading_tv5;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.heading_tv5);
                if (textView != null) {
                    i = R.id.name_ed;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.name_ed);
                    if (editText != null) {
                        i = R.id.relationship_spinner;
                        NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.relationship_spinner);
                        if (noDefaultSpinner != null) {
                            i = R.id.relationship_tv;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relationship_tv);
                            if (textView2 != null) {
                                i = R.id.view;
                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view);
                                if (viewFindChildViewById != null) {
                                    i = R.id.view2;
                                    View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view2);
                                    if (viewFindChildViewById2 != null) {
                                        i = R.id.view3;
                                        View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.view3);
                                        if (viewFindChildViewById3 != null) {
                                            return new BloFragmentFamilyDetailsBinding((ScrollView) rootView, appCompatEditTextFindChildViewById, constraintLayoutFindChildViewById, textView, editText, noDefaultSpinner, textView2, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3);
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
