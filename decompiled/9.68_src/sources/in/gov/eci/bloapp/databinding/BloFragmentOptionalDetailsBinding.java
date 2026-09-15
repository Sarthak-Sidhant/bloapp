package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloFragmentOptionalDetailsBinding implements ViewBinding {
    public final RadioButton DeafDumb;
    public final ConstraintLayout PersonDisabilityLayout;
    public final TextView chooseFile4;
    public final ImageButton chooseFileDeletion9;
    public final TextView chooseFileSizeTv4;
    public final TextView chooseFileTv4;
    public final RadioGroup disabilityRg;
    public final RadioButton locomotiveRb;
    public final EditText otherEd;
    public final RadioButton otherRb;
    public final TextView perTv;
    public final EditText percentageEd;
    public final ImageView photo4;
    private final ScrollView rootView;
    public final TextView textview19;
    public final TextView textview20;
    public final TextView title;
    public final RadioButton visualRb;

    private BloFragmentOptionalDetailsBinding(ScrollView rootView, RadioButton DeafDumb, ConstraintLayout PersonDisabilityLayout, TextView chooseFile4, ImageButton chooseFileDeletion9, TextView chooseFileSizeTv4, TextView chooseFileTv4, RadioGroup disabilityRg, RadioButton locomotiveRb, EditText otherEd, RadioButton otherRb, TextView perTv, EditText percentageEd, ImageView photo4, TextView textview19, TextView textview20, TextView title, RadioButton visualRb) {
        this.rootView = rootView;
        this.DeafDumb = DeafDumb;
        this.PersonDisabilityLayout = PersonDisabilityLayout;
        this.chooseFile4 = chooseFile4;
        this.chooseFileDeletion9 = chooseFileDeletion9;
        this.chooseFileSizeTv4 = chooseFileSizeTv4;
        this.chooseFileTv4 = chooseFileTv4;
        this.disabilityRg = disabilityRg;
        this.locomotiveRb = locomotiveRb;
        this.otherEd = otherEd;
        this.otherRb = otherRb;
        this.perTv = perTv;
        this.percentageEd = percentageEd;
        this.photo4 = photo4;
        this.textview19 = textview19;
        this.textview20 = textview20;
        this.title = title;
        this.visualRb = visualRb;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BloFragmentOptionalDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloFragmentOptionalDetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_fragment_optional_details, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloFragmentOptionalDetailsBinding bind(View rootView) {
        int i = R.id.Deaf_Dumb;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.Deaf_Dumb);
        if (radioButton != null) {
            i = R.id.Person_disability_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.Person_disability_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.choose_file4;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file4);
                if (textView != null) {
                    i = R.id.choose_file_deletion9;
                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.choose_file_deletion9);
                    if (imageButton != null) {
                        i = R.id.choose_file_size_tv4;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_size_tv4);
                        if (textView2 != null) {
                            i = R.id.choose_file_tv4;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file_tv4);
                            if (textView3 != null) {
                                i = R.id.disability_rg;
                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.disability_rg);
                                if (radioGroup != null) {
                                    i = R.id.locomotive_rb;
                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.locomotive_rb);
                                    if (radioButton2 != null) {
                                        i = R.id.other_ed;
                                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.other_ed);
                                        if (editText != null) {
                                            i = R.id.other_rb;
                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.other_rb);
                                            if (radioButton3 != null) {
                                                i = R.id.per_tv;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.per_tv);
                                                if (textView4 != null) {
                                                    i = R.id.percentage_ed;
                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.percentage_ed);
                                                    if (editText2 != null) {
                                                        i = R.id.photo4;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.photo4);
                                                        if (imageView != null) {
                                                            i = R.id.textview19;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textview19);
                                                            if (textView5 != null) {
                                                                i = R.id.textview20;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textview20);
                                                                if (textView6 != null) {
                                                                    i = 2131366420;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, 2131366420);
                                                                    if (textView7 != null) {
                                                                        i = R.id.visual_rb;
                                                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.visual_rb);
                                                                        if (radioButton4 != null) {
                                                                            return new BloFragmentOptionalDetailsBinding((ScrollView) rootView, radioButton, constraintLayoutFindChildViewById, textView, imageButton, textView2, textView3, radioGroup, radioButton2, editText, radioButton3, textView4, editText2, imageView, textView5, textView6, textView7, radioButton4);
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
