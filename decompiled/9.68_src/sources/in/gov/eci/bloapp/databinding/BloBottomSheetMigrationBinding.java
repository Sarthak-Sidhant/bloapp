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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloBottomSheetMigrationBinding implements ViewBinding {
    public final RadioGroup Epictype;
    public final RadioButton SameEpic;
    public final Button btnProceed;
    public final TextView doc1Tv;
    public final TextView doc2Tv;
    public final TextView doc3Tv;
    public final TextView doc4Tv;
    public final EditText epicNumber;
    public final EditText epicNumber1;
    public final TextView formNameTv;
    public final NestedScrollView frameForms;
    public final ImageView imageView;
    public final RadioButton otherEpic;
    public final TextView requiredDccTv;
    private final ConstraintLayout rootView;
    public final LinearLayout sameotherepiclayout;

    private BloBottomSheetMigrationBinding(ConstraintLayout rootView, RadioGroup Epictype, RadioButton SameEpic, Button btnProceed, TextView doc1Tv, TextView doc2Tv, TextView doc3Tv, TextView doc4Tv, EditText epicNumber, EditText epicNumber1, TextView formNameTv, NestedScrollView frameForms, ImageView imageView, RadioButton otherEpic, TextView requiredDccTv, LinearLayout sameotherepiclayout) {
        this.rootView = rootView;
        this.Epictype = Epictype;
        this.SameEpic = SameEpic;
        this.btnProceed = btnProceed;
        this.doc1Tv = doc1Tv;
        this.doc2Tv = doc2Tv;
        this.doc3Tv = doc3Tv;
        this.doc4Tv = doc4Tv;
        this.epicNumber = epicNumber;
        this.epicNumber1 = epicNumber1;
        this.formNameTv = formNameTv;
        this.frameForms = frameForms;
        this.imageView = imageView;
        this.otherEpic = otherEpic;
        this.requiredDccTv = requiredDccTv;
        this.sameotherepiclayout = sameotherepiclayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloBottomSheetMigrationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloBottomSheetMigrationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_bottom_sheet_migration, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloBottomSheetMigrationBinding bind(View rootView) {
        int i = R.id.Epictype;
        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.Epictype);
        if (radioGroup != null) {
            i = R.id.Same_epic;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.Same_epic);
            if (radioButton != null) {
                i = R.id.btn_Proceed;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_Proceed);
                if (button != null) {
                    i = R.id.doc1_tv;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc1_tv);
                    if (textView != null) {
                        i = R.id.doc2_tv;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc2_tv);
                        if (textView2 != null) {
                            i = R.id.doc3_tv;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc3_tv);
                            if (textView3 != null) {
                                i = R.id.doc4_tv;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doc4_tv);
                                if (textView4 != null) {
                                    i = R.id.epic_number;
                                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.epic_number);
                                    if (editText != null) {
                                        i = R.id.epic_number1;
                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.epic_number1);
                                        if (editText2 != null) {
                                            i = R.id.form_name_tv;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form_name_tv);
                                            if (textView5 != null) {
                                                i = R.id.frame_forms;
                                                NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.frame_forms);
                                                if (nestedScrollViewFindChildViewById != null) {
                                                    i = R.id.imageView;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
                                                    if (imageView != null) {
                                                        i = R.id.other_epic;
                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.other_epic);
                                                        if (radioButton2 != null) {
                                                            i = R.id.required_dcc_tv;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.required_dcc_tv);
                                                            if (textView6 != null) {
                                                                i = R.id.sameotherepiclayout;
                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sameotherepiclayout);
                                                                if (linearLayout != null) {
                                                                    return new BloBottomSheetMigrationBinding((ConstraintLayout) rootView, radioGroup, radioButton, button, textView, textView2, textView3, textView4, editText, editText2, textView5, nestedScrollViewFindChildViewById, imageView, radioButton2, textView6, linearLayout);
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
