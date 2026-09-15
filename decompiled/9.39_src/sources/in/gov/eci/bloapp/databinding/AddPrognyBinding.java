package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class AddPrognyBinding implements ViewBinding {
    public final Button btnNo;
    public final Button btnYes;
    public final Button btncancel;
    public final Button btnsubmit;
    public final LinearLayout linearButtons;
    public final LinearLayout lvVerifyDetails;
    private final LinearLayout rootView;
    public final EditText search;
    public final Spinner spElectorRelative;
    public final TextView tvElectorAge;
    public final TextView tvElectorGender;
    public final TextView tvElectorName;
    public final TextView tvElectorRelationType;
    public final TextView tvElectorRelativeFullname;
    public final TextView txtHeading;

    private AddPrognyBinding(LinearLayout rootView, Button btnNo, Button btnYes, Button btncancel, Button btnsubmit, LinearLayout linearButtons, LinearLayout lvVerifyDetails, EditText search, Spinner spElectorRelative, TextView tvElectorAge, TextView tvElectorGender, TextView tvElectorName, TextView tvElectorRelationType, TextView tvElectorRelativeFullname, TextView txtHeading) {
        this.rootView = rootView;
        this.btnNo = btnNo;
        this.btnYes = btnYes;
        this.btncancel = btncancel;
        this.btnsubmit = btnsubmit;
        this.linearButtons = linearButtons;
        this.lvVerifyDetails = lvVerifyDetails;
        this.search = search;
        this.spElectorRelative = spElectorRelative;
        this.tvElectorAge = tvElectorAge;
        this.tvElectorGender = tvElectorGender;
        this.tvElectorName = tvElectorName;
        this.tvElectorRelationType = tvElectorRelationType;
        this.tvElectorRelativeFullname = tvElectorRelativeFullname;
        this.txtHeading = txtHeading;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AddPrognyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AddPrognyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.add_progny, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AddPrognyBinding bind(View rootView) {
        int i = R.id.btnNo;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btnNo);
        if (button != null) {
            i = R.id.btnYes;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btnYes);
            if (button2 != null) {
                i = R.id.btncancel;
                Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.btncancel);
                if (button3 != null) {
                    i = R.id.btnsubmit;
                    Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.btnsubmit);
                    if (button4 != null) {
                        i = R.id.linearButtons;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearButtons);
                        if (linearLayout != null) {
                            i = R.id.lv_verify_details;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_verify_details);
                            if (linearLayout2 != null) {
                                i = R.id.search;
                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.search);
                                if (editText != null) {
                                    i = R.id.sp_elector_relative;
                                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.sp_elector_relative);
                                    if (spinner != null) {
                                        i = R.id.tv_elector_age;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_age);
                                        if (textView != null) {
                                            i = R.id.tv_elector_gender;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_gender);
                                            if (textView2 != null) {
                                                i = R.id.tv_elector_name;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_name);
                                                if (textView3 != null) {
                                                    i = R.id.tv_elector_relation_type;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_relation_type);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_elector_relative_fullname;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_relative_fullname);
                                                        if (textView5 != null) {
                                                            i = R.id.txtHeading;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtHeading);
                                                            if (textView6 != null) {
                                                                return new AddPrognyBinding((LinearLayout) rootView, button, button2, button3, button4, linearLayout, linearLayout2, editText, spinner, textView, textView2, textView3, textView4, textView5, textView6);
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
