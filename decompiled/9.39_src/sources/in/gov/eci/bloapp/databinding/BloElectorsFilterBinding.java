package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloElectorsFilterBinding implements ViewBinding {
    public final CheckBox ageCheckBox;
    public final EditText ageEdit;
    public final RadioButton ageRadioButton;
    public final RadioButton allGenderRadioButton;
    public final ImageView cancelButton;
    public final ImageView femaleFilterImageAdd;
    public final ImageView femaleFilterImageRemove;
    public final RadioButton femaleRadioButton;
    public final Button filterButton;
    public final RadioGroup filterRadioGroup;
    public final EditText genderAgeEdit;
    public final RadioButton genderRadioButton;
    public final LinearLayout genderRadioGroup;
    public final ImageView imageView;
    public final RadioButton maleRadioButton;
    public final RadioButton mobileRadioButton;
    public final TextView nameTv;
    public final RadioButton noMobileRadioButton;
    public final RadioButton notReceivedRadioButton;
    public final RadioButton pwdRadioButton;
    public final CheckBox ralationTypeCheckBox;
    public final RadioButton receivedRadioButton;
    public final NoDefaultSpinner relationTypeSpinner;
    private final ConstraintLayout rootView;
    public final LinearLayout showExtraFemaleFilterLayout;
    public final RadioButton thirdGenderRadioButton;
    public final View viewStateOutsideSpinner1;

    private BloElectorsFilterBinding(ConstraintLayout rootView, CheckBox ageCheckBox, EditText ageEdit, RadioButton ageRadioButton, RadioButton allGenderRadioButton, ImageView cancelButton, ImageView femaleFilterImageAdd, ImageView femaleFilterImageRemove, RadioButton femaleRadioButton, Button filterButton, RadioGroup filterRadioGroup, EditText genderAgeEdit, RadioButton genderRadioButton, LinearLayout genderRadioGroup, ImageView imageView, RadioButton maleRadioButton, RadioButton mobileRadioButton, TextView nameTv, RadioButton noMobileRadioButton, RadioButton notReceivedRadioButton, RadioButton pwdRadioButton, CheckBox ralationTypeCheckBox, RadioButton receivedRadioButton, NoDefaultSpinner relationTypeSpinner, LinearLayout showExtraFemaleFilterLayout, RadioButton thirdGenderRadioButton, View viewStateOutsideSpinner1) {
        this.rootView = rootView;
        this.ageCheckBox = ageCheckBox;
        this.ageEdit = ageEdit;
        this.ageRadioButton = ageRadioButton;
        this.allGenderRadioButton = allGenderRadioButton;
        this.cancelButton = cancelButton;
        this.femaleFilterImageAdd = femaleFilterImageAdd;
        this.femaleFilterImageRemove = femaleFilterImageRemove;
        this.femaleRadioButton = femaleRadioButton;
        this.filterButton = filterButton;
        this.filterRadioGroup = filterRadioGroup;
        this.genderAgeEdit = genderAgeEdit;
        this.genderRadioButton = genderRadioButton;
        this.genderRadioGroup = genderRadioGroup;
        this.imageView = imageView;
        this.maleRadioButton = maleRadioButton;
        this.mobileRadioButton = mobileRadioButton;
        this.nameTv = nameTv;
        this.noMobileRadioButton = noMobileRadioButton;
        this.notReceivedRadioButton = notReceivedRadioButton;
        this.pwdRadioButton = pwdRadioButton;
        this.ralationTypeCheckBox = ralationTypeCheckBox;
        this.receivedRadioButton = receivedRadioButton;
        this.relationTypeSpinner = relationTypeSpinner;
        this.showExtraFemaleFilterLayout = showExtraFemaleFilterLayout;
        this.thirdGenderRadioButton = thirdGenderRadioButton;
        this.viewStateOutsideSpinner1 = viewStateOutsideSpinner1;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloElectorsFilterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloElectorsFilterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_electors_filter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloElectorsFilterBinding bind(View rootView) {
        int i = R.id.ageCheckBox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.ageCheckBox);
        if (checkBox != null) {
            i = R.id.ageEdit;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.ageEdit);
            if (editText != null) {
                i = R.id.ageRadioButton;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.ageRadioButton);
                if (radioButton != null) {
                    i = R.id.allGenderRadioButton;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.allGenderRadioButton);
                    if (radioButton2 != null) {
                        i = R.id.cancelButton;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelButton);
                        if (imageView != null) {
                            i = R.id.femaleFilterImageAdd;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.femaleFilterImageAdd);
                            if (imageView2 != null) {
                                i = R.id.femaleFilterImageRemove;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.femaleFilterImageRemove);
                                if (imageView3 != null) {
                                    i = R.id.femaleRadioButton;
                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.femaleRadioButton);
                                    if (radioButton3 != null) {
                                        i = R.id.filterButton;
                                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.filterButton);
                                        if (button != null) {
                                            i = R.id.filterRadioGroup;
                                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.filterRadioGroup);
                                            if (radioGroup != null) {
                                                i = R.id.genderAgeEdit;
                                                EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.genderAgeEdit);
                                                if (editText2 != null) {
                                                    i = R.id.genderRadioButton;
                                                    RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.genderRadioButton);
                                                    if (radioButton4 != null) {
                                                        i = R.id.genderRadioGroup;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.genderRadioGroup);
                                                        if (linearLayout != null) {
                                                            i = R.id.imageView;
                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
                                                            if (imageView4 != null) {
                                                                i = R.id.maleRadioButton;
                                                                RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.maleRadioButton);
                                                                if (radioButton5 != null) {
                                                                    i = R.id.mobileRadioButton;
                                                                    RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.mobileRadioButton);
                                                                    if (radioButton6 != null) {
                                                                        i = R.id.name_tv;
                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_tv);
                                                                        if (textView != null) {
                                                                            i = R.id.noMobileRadioButton;
                                                                            RadioButton radioButton7 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.noMobileRadioButton);
                                                                            if (radioButton7 != null) {
                                                                                i = R.id.notReceivedRadioButton;
                                                                                RadioButton radioButton8 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.notReceivedRadioButton);
                                                                                if (radioButton8 != null) {
                                                                                    i = R.id.pwdRadioButton;
                                                                                    RadioButton radioButton9 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.pwdRadioButton);
                                                                                    if (radioButton9 != null) {
                                                                                        i = R.id.ralationTypeCheckBox;
                                                                                        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.ralationTypeCheckBox);
                                                                                        if (checkBox2 != null) {
                                                                                            i = R.id.receivedRadioButton;
                                                                                            RadioButton radioButton10 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.receivedRadioButton);
                                                                                            if (radioButton10 != null) {
                                                                                                i = R.id.relationTypeSpinner;
                                                                                                NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.relationTypeSpinner);
                                                                                                if (noDefaultSpinner != null) {
                                                                                                    i = R.id.showExtraFemaleFilterLayout;
                                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.showExtraFemaleFilterLayout);
                                                                                                    if (linearLayout2 != null) {
                                                                                                        i = R.id.thirdGenderRadioButton;
                                                                                                        RadioButton radioButton11 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.thirdGenderRadioButton);
                                                                                                        if (radioButton11 != null) {
                                                                                                            i = R.id.view_state_outside_spinner1;
                                                                                                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_state_outside_spinner1);
                                                                                                            if (viewFindChildViewById != null) {
                                                                                                                return new BloElectorsFilterBinding((ConstraintLayout) rootView, checkBox, editText, radioButton, radioButton2, imageView, imageView2, imageView3, radioButton3, button, radioGroup, editText2, radioButton4, linearLayout, imageView4, radioButton5, radioButton6, textView, radioButton7, radioButton8, radioButton9, checkBox2, radioButton10, noDefaultSpinner, linearLayout2, radioButton11, viewFindChildViewById);
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
