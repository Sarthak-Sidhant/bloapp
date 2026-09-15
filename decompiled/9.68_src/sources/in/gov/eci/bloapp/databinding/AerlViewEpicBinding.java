package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class AerlViewEpicBinding implements ViewBinding {
    public final Button btncancel;
    public final Button btnsubmit;
    public final CheckBox cbAlreadyenrolled;
    public final ImageView cross;
    public final LinearLayout lvVerifyDetails;
    private final LinearLayout rootView;
    public final EditText search;
    public final TextView tvElectorAcName;
    public final TextView tvElectorAcNo;
    public final TextView tvElectorAge;
    public final TextView tvElectorGender;
    public final TextView tvElectorName;
    public final TextView tvElectorPartNo;
    public final TextView tvElectorRelationType;
    public final TextView tvElectorRelativeFullname;
    public final TextView tvElectorState;

    private AerlViewEpicBinding(LinearLayout rootView, Button btncancel, Button btnsubmit, CheckBox cbAlreadyenrolled, ImageView cross, LinearLayout lvVerifyDetails, EditText search, TextView tvElectorAcName, TextView tvElectorAcNo, TextView tvElectorAge, TextView tvElectorGender, TextView tvElectorName, TextView tvElectorPartNo, TextView tvElectorRelationType, TextView tvElectorRelativeFullname, TextView tvElectorState) {
        this.rootView = rootView;
        this.btncancel = btncancel;
        this.btnsubmit = btnsubmit;
        this.cbAlreadyenrolled = cbAlreadyenrolled;
        this.cross = cross;
        this.lvVerifyDetails = lvVerifyDetails;
        this.search = search;
        this.tvElectorAcName = tvElectorAcName;
        this.tvElectorAcNo = tvElectorAcNo;
        this.tvElectorAge = tvElectorAge;
        this.tvElectorGender = tvElectorGender;
        this.tvElectorName = tvElectorName;
        this.tvElectorPartNo = tvElectorPartNo;
        this.tvElectorRelationType = tvElectorRelationType;
        this.tvElectorRelativeFullname = tvElectorRelativeFullname;
        this.tvElectorState = tvElectorState;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AerlViewEpicBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AerlViewEpicBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.aerl_view_epic, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AerlViewEpicBinding bind(View rootView) {
        int i = R.id.btncancel;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btncancel);
        if (button != null) {
            i = R.id.btnsubmit;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btnsubmit);
            if (button2 != null) {
                i = R.id.cb_alreadyenrolled;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.cb_alreadyenrolled);
                if (checkBox != null) {
                    i = R.id.cross;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cross);
                    if (imageView != null) {
                        i = R.id.lv_verify_details;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_verify_details);
                        if (linearLayout != null) {
                            i = R.id.search;
                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.search);
                            if (editText != null) {
                                i = R.id.tv_elector_acName;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_acName);
                                if (textView != null) {
                                    i = R.id.tv_elector_acNo;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_acNo);
                                    if (textView2 != null) {
                                        i = R.id.tv_elector_age;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_age);
                                        if (textView3 != null) {
                                            i = R.id.tv_elector_gender;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_gender);
                                            if (textView4 != null) {
                                                i = R.id.tv_elector_name;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_name);
                                                if (textView5 != null) {
                                                    i = R.id.tv_elector_partNo;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_partNo);
                                                    if (textView6 != null) {
                                                        i = R.id.tv_elector_relation_type;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_relation_type);
                                                        if (textView7 != null) {
                                                            i = R.id.tv_elector_relative_fullname;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_relative_fullname);
                                                            if (textView8 != null) {
                                                                i = R.id.tv_elector_state;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_state);
                                                                if (textView9 != null) {
                                                                    return new AerlViewEpicBinding((LinearLayout) rootView, button, button2, checkBox, imageView, linearLayout, editText, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
