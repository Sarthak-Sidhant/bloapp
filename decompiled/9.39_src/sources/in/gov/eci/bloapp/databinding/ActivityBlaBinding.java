package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.customviews.NoDefaultSpinner;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityBlaBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final EditText bla1name;
    public final EditText bla2epic;
    public final EditText bla2name;
    public final TextView bla2part;
    public final EditText blaEmail;
    public final Button blaSubmit;
    public final ConstraintLayout blaTopLayout;
    public final TextView chooseFile;
    public final LinearLayout deathCerti;
    public final ImageView delete;
    public final LinearLayout layoutBla2;
    public final LinearLayout main;
    public final EditText mobile;
    public final NoDefaultSpinner partyNameSpinner;
    public final NoDefaultSpinner partyTypeSpinner;
    public final ImageView photo;
    public final TextView photoname;
    private final LinearLayout rootView;
    public final ScrollView scrollLayout;
    public final EditText shortAbbrev;
    public final TextView size;
    public final TextView textView3;
    public final Button validate;

    private ActivityBlaBinding(LinearLayout rootView, ImageView backBtnIv, EditText bla1name, EditText bla2epic, EditText bla2name, TextView bla2part, EditText blaEmail, Button blaSubmit, ConstraintLayout blaTopLayout, TextView chooseFile, LinearLayout deathCerti, ImageView delete, LinearLayout layoutBla2, LinearLayout main, EditText mobile, NoDefaultSpinner partyNameSpinner, NoDefaultSpinner partyTypeSpinner, ImageView photo, TextView photoname, ScrollView scrollLayout, EditText shortAbbrev, TextView size, TextView textView3, Button validate) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.bla1name = bla1name;
        this.bla2epic = bla2epic;
        this.bla2name = bla2name;
        this.bla2part = bla2part;
        this.blaEmail = blaEmail;
        this.blaSubmit = blaSubmit;
        this.blaTopLayout = blaTopLayout;
        this.chooseFile = chooseFile;
        this.deathCerti = deathCerti;
        this.delete = delete;
        this.layoutBla2 = layoutBla2;
        this.main = main;
        this.mobile = mobile;
        this.partyNameSpinner = partyNameSpinner;
        this.partyTypeSpinner = partyTypeSpinner;
        this.photo = photo;
        this.photoname = photoname;
        this.scrollLayout = scrollLayout;
        this.shortAbbrev = shortAbbrev;
        this.size = size;
        this.textView3 = textView3;
        this.validate = validate;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBlaBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityBlaBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_bla, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBlaBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla1name;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.bla1name);
            if (editText != null) {
                i = R.id.bla2epic;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.bla2epic);
                if (editText2 != null) {
                    i = R.id.bla2name;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.bla2name);
                    if (editText3 != null) {
                        i = R.id.bla2part;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.bla2part);
                        if (textView != null) {
                            i = R.id.bla_email;
                            EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.bla_email);
                            if (editText4 != null) {
                                i = R.id.bla_submit;
                                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.bla_submit);
                                if (button != null) {
                                    i = R.id.bla_top_layout;
                                    ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
                                    if (constraintLayoutFindChildViewById != null) {
                                        i = R.id.choose_file;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.choose_file);
                                        if (textView2 != null) {
                                            i = R.id.death_certi;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.death_certi);
                                            if (linearLayout != null) {
                                                i = R.id.delete;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.delete);
                                                if (imageView2 != null) {
                                                    i = R.id.layout_bla2;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout_bla2);
                                                    if (linearLayout2 != null) {
                                                        LinearLayout linearLayout3 = (LinearLayout) rootView;
                                                        i = R.id.mobile;
                                                        EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobile);
                                                        if (editText5 != null) {
                                                            i = R.id.party_name_spinner;
                                                            NoDefaultSpinner noDefaultSpinner = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.party_name_spinner);
                                                            if (noDefaultSpinner != null) {
                                                                i = R.id.party_type_spinner;
                                                                NoDefaultSpinner noDefaultSpinner2 = (NoDefaultSpinner) ViewBindings.findChildViewById(rootView, R.id.party_type_spinner);
                                                                if (noDefaultSpinner2 != null) {
                                                                    i = R.id.photo;
                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.photo);
                                                                    if (imageView3 != null) {
                                                                        i = R.id.photoname;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.photoname);
                                                                        if (textView3 != null) {
                                                                            i = R.id.scrollLayout;
                                                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollLayout);
                                                                            if (scrollView != null) {
                                                                                i = R.id.short_Abbrev;
                                                                                EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.short_Abbrev);
                                                                                if (editText6 != null) {
                                                                                    i = R.id.size;
                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.size);
                                                                                    if (textView4 != null) {
                                                                                        i = R.id.textView3;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                        if (textView5 != null) {
                                                                                            i = R.id.validate;
                                                                                            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.validate);
                                                                                            if (button2 != null) {
                                                                                                return new ActivityBlaBinding(linearLayout3, imageView, editText, editText2, editText3, textView, editText4, button, constraintLayoutFindChildViewById, textView2, linearLayout, imageView2, linearLayout2, linearLayout3, editText5, noDefaultSpinner, noDefaultSpinner2, imageView3, textView3, scrollView, editText6, textView4, textView5, button2);
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
