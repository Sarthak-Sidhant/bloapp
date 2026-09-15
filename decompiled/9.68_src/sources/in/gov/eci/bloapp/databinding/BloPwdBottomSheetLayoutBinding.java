package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloPwdBottomSheetLayoutBinding implements ViewBinding {
    public final TextView Status;
    public final LinearLayout layput1;
    public final TextView remark;
    public final EditText remarkValue;
    private final ConstraintLayout rootView;
    public final TextView status;
    public final EditText statusValue;
    public final Button submit;
    public final View viewLine;
    public final View viewLine1;

    private BloPwdBottomSheetLayoutBinding(ConstraintLayout rootView, TextView Status, LinearLayout layput1, TextView remark, EditText remarkValue, TextView status, EditText statusValue, Button submit, View viewLine, View viewLine1) {
        this.rootView = rootView;
        this.Status = Status;
        this.layput1 = layput1;
        this.remark = remark;
        this.remarkValue = remarkValue;
        this.status = status;
        this.statusValue = statusValue;
        this.submit = submit;
        this.viewLine = viewLine;
        this.viewLine1 = viewLine1;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloPwdBottomSheetLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloPwdBottomSheetLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_pwd_bottom_sheet_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloPwdBottomSheetLayoutBinding bind(View rootView) {
        int i = R.id.Status;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.Status);
        if (textView != null) {
            i = R.id.layput1;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layput1);
            if (linearLayout != null) {
                i = R.id.remark;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remark);
                if (textView2 != null) {
                    i = R.id.remark_value;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.remark_value);
                    if (editText != null) {
                        i = R.id.status;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.status);
                        if (textView3 != null) {
                            i = R.id.status_value;
                            EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.status_value);
                            if (editText2 != null) {
                                i = R.id.submit;
                                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submit);
                                if (button != null) {
                                    i = R.id.view_line;
                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_line);
                                    if (viewFindChildViewById != null) {
                                        i = R.id.view_line1;
                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view_line1);
                                        if (viewFindChildViewById2 != null) {
                                            return new BloPwdBottomSheetLayoutBinding((ConstraintLayout) rootView, textView, linearLayout, textView2, editText, textView3, editText2, button, viewFindChildViewById, viewFindChildViewById2);
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
