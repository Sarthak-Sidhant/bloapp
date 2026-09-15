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
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class BloBottomSheetMigrationSecondBinding implements ViewBinding {
    public final EditText AcNOET;
    public final RadioButton COR;
    public final RadioButton IOR;
    public final ConstraintLayout PartNumberLayout;
    public final RadioButton ROM;
    public final RadioButton SOR;
    public final ConstraintLayout SerialNumberLayout;
    public final ConstraintLayout acNOLayout;
    public final TextView acNo;
    public final Button btnProceed;
    public final RadioGroup constType;
    public final ConstraintLayout constituencytypeLayout;
    public final ConstraintLayout detailsLayout;
    public final LinearLayout familyspinner;
    public final TextView formNameTv;
    public final NestedScrollView frameForms;
    public final ImageView imageView;
    public final RadioButton outsideassembly;
    public final TextView partNumber;
    public final EditText partNumberET;
    public final ConstraintLayout partserialID;
    public final RadioGroup radiogroupSubmitApplication;
    private final ConstraintLayout rootView;
    public final NoDefaultSpinner sectionNo;
    public final LinearLayout sectionNoShift;
    public final TextView selectassembly;
    public final TextView serialNumber;
    public final EditText serialnumberET;
    public final TextView submitApplicationchoices;
    public final View viewAcno;
    public final View viewPartnumber;
    public final View viewSerialnumber;
    public final View viewStateOutsideSpinner1;
    public final RadioButton withinassembly;

    private BloBottomSheetMigrationSecondBinding(ConstraintLayout rootView, EditText AcNOET, RadioButton COR, RadioButton IOR, ConstraintLayout PartNumberLayout, RadioButton ROM, RadioButton SOR, ConstraintLayout SerialNumberLayout, ConstraintLayout acNOLayout, TextView acNo, Button btnProceed, RadioGroup constType, ConstraintLayout constituencytypeLayout, ConstraintLayout detailsLayout, LinearLayout familyspinner, TextView formNameTv, NestedScrollView frameForms, ImageView imageView, RadioButton outsideassembly, TextView partNumber, EditText partNumberET, ConstraintLayout partserialID, RadioGroup radiogroupSubmitApplication, NoDefaultSpinner sectionNo, LinearLayout sectionNoShift, TextView selectassembly, TextView serialNumber, EditText serialnumberET, TextView submitApplicationchoices, View viewAcno, View viewPartnumber, View viewSerialnumber, View viewStateOutsideSpinner1, RadioButton withinassembly) {
        this.rootView = rootView;
        this.AcNOET = AcNOET;
        this.COR = COR;
        this.IOR = IOR;
        this.PartNumberLayout = PartNumberLayout;
        this.ROM = ROM;
        this.SOR = SOR;
        this.SerialNumberLayout = SerialNumberLayout;
        this.acNOLayout = acNOLayout;
        this.acNo = acNo;
        this.btnProceed = btnProceed;
        this.constType = constType;
        this.constituencytypeLayout = constituencytypeLayout;
        this.detailsLayout = detailsLayout;
        this.familyspinner = familyspinner;
        this.formNameTv = formNameTv;
        this.frameForms = frameForms;
        this.imageView = imageView;
        this.outsideassembly = outsideassembly;
        this.partNumber = partNumber;
        this.partNumberET = partNumberET;
        this.partserialID = partserialID;
        this.radiogroupSubmitApplication = radiogroupSubmitApplication;
        this.sectionNo = sectionNo;
        this.sectionNoShift = sectionNoShift;
        this.selectassembly = selectassembly;
        this.serialNumber = serialNumber;
        this.serialnumberET = serialnumberET;
        this.submitApplicationchoices = submitApplicationchoices;
        this.viewAcno = viewAcno;
        this.viewPartnumber = viewPartnumber;
        this.viewSerialnumber = viewSerialnumber;
        this.viewStateOutsideSpinner1 = viewStateOutsideSpinner1;
        this.withinassembly = withinassembly;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloBottomSheetMigrationSecondBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloBottomSheetMigrationSecondBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_bottom_sheet_migration_second, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloBottomSheetMigrationSecondBinding bind(View rootView) {
        int i = R.id.AcNO_ET;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.AcNO_ET);
        if (editText != null) {
            i = R.id.COR;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.COR);
            if (radioButton != null) {
                i = R.id.IOR;
                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.IOR);
                if (radioButton2 != null) {
                    i = R.id.PartNumberLayout;
                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.PartNumberLayout);
                    if (constraintLayoutFindChildViewById != null) {
                        i = R.id.ROM;
                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.ROM);
                        if (radioButton3 != null) {
                            i = R.id.SOR;
                            RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.SOR);
                            if (radioButton4 != null) {
                                i = R.id.SerialNumberLayout;
                                ConstraintLayout constraintLayoutFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.SerialNumberLayout);
                                if (constraintLayoutFindChildViewById2 != null) {
                                    i = R.id.acNOLayout;
                                    ConstraintLayout constraintLayoutFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.acNOLayout);
                                    if (constraintLayoutFindChildViewById3 != null) {
                                        i = R.id.ac_no;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.ac_no);
                                        if (textView != null) {
                                            i = R.id.btn_Proceed;
                                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_Proceed);
                                            if (button != null) {
                                                i = R.id.const_type;
                                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.const_type);
                                                if (radioGroup != null) {
                                                    i = R.id.constituencytype_layout;
                                                    ConstraintLayout constraintLayoutFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.constituencytype_layout);
                                                    if (constraintLayoutFindChildViewById4 != null) {
                                                        i = R.id.details_layout;
                                                        ConstraintLayout constraintLayoutFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.details_layout);
                                                        if (constraintLayoutFindChildViewById5 != null) {
                                                            i = R.id.familyspinner;
                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.familyspinner);
                                                            if (linearLayout != null) {
                                                                i = R.id.form_name_tv;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_name_tv);
                                                                if (textView2 != null) {
                                                                    i = R.id.frame_forms;
                                                                    NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.frame_forms);
                                                                    if (nestedScrollViewFindChildViewById != null) {
                                                                        i = R.id.imageView;
                                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
                                                                        if (imageView != null) {
                                                                            i = R.id.outsideassembly;
                                                                            RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.outsideassembly);
                                                                            if (radioButton5 != null) {
                                                                                i = R.id.part_number;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.part_number);
                                                                                if (textView3 != null) {
                                                                                    i = R.id.part_number_ET;
                                                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.part_number_ET);
                                                                                    if (editText2 != null) {
                                                                                        i = R.id.partserialID;
                                                                                        ConstraintLayout constraintLayoutFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.partserialID);
                                                                                        if (constraintLayoutFindChildViewById6 != null) {
                                                                                            i = R.id.radiogroup_submit_application;
                                                                                            RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.radiogroup_submit_application);
                                                                                            if (radioGroup2 != null) {
                                                                                                i = R.id.sectionNo;
                                                                                                NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.sectionNo);
                                                                                                if (noDefaultSpinner != null) {
                                                                                                    i = R.id.sectionNoShift;
                                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sectionNoShift);
                                                                                                    if (linearLayout2 != null) {
                                                                                                        i = R.id.selectassembly;
                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.selectassembly);
                                                                                                        if (textView4 != null) {
                                                                                                            i = R.id.serial_number;
                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serial_number);
                                                                                                            if (textView5 != null) {
                                                                                                                i = R.id.serialnumber_ET;
                                                                                                                EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.serialnumber_ET);
                                                                                                                if (editText3 != null) {
                                                                                                                    i = R.id.submitApplicationchoices;
                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submitApplicationchoices);
                                                                                                                    if (textView6 != null) {
                                                                                                                        i = R.id.view_acno;
                                                                                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_acno);
                                                                                                                        if (viewFindChildViewById != null) {
                                                                                                                            i = R.id.view_partnumber;
                                                                                                                            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view_partnumber);
                                                                                                                            if (viewFindChildViewById2 != null) {
                                                                                                                                i = R.id.view_serialnumber;
                                                                                                                                View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.view_serialnumber);
                                                                                                                                if (viewFindChildViewById3 != null) {
                                                                                                                                    i = R.id.view_state_outside_spinner1;
                                                                                                                                    View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.view_state_outside_spinner1);
                                                                                                                                    if (viewFindChildViewById4 != null) {
                                                                                                                                        i = R.id.withinassembly;
                                                                                                                                        RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.withinassembly);
                                                                                                                                        if (radioButton6 != null) {
                                                                                                                                            return new BloBottomSheetMigrationSecondBinding((ConstraintLayout) rootView, editText, radioButton, radioButton2, constraintLayoutFindChildViewById, radioButton3, radioButton4, constraintLayoutFindChildViewById2, constraintLayoutFindChildViewById3, textView, button, radioGroup, constraintLayoutFindChildViewById4, constraintLayoutFindChildViewById5, linearLayout, textView2, nestedScrollViewFindChildViewById, imageView, radioButton5, textView3, editText2, constraintLayoutFindChildViewById6, radioGroup2, noDefaultSpinner, linearLayout2, textView4, textView5, editText3, textView6, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, radioButton6);
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
