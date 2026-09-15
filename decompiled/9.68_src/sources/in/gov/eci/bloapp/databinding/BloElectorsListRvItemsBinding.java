package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloElectorsListRvItemsBinding implements ViewBinding {
    public final TextView aadhaarStatus;
    public final TextView age;
    public final TextView candidateName;
    public final LinearLayout divider;
    public final TextView epicEd;
    public final TextView epicNumber;
    public final TextView fullNameText;
    public final TextView gender;
    public final ConstraintLayout layout;
    public final TextView mobileNumber;
    public final TextView relationType;
    public final TextView relativeName;
    private final ConstraintLayout rootView;
    public final TextView serielNumber;

    private BloElectorsListRvItemsBinding(ConstraintLayout rootView, TextView aadhaarStatus, TextView age, TextView candidateName, LinearLayout divider, TextView epicEd, TextView epicNumber, TextView fullNameText, TextView gender, ConstraintLayout layout, TextView mobileNumber, TextView relationType, TextView relativeName, TextView serielNumber) {
        this.rootView = rootView;
        this.aadhaarStatus = aadhaarStatus;
        this.age = age;
        this.candidateName = candidateName;
        this.divider = divider;
        this.epicEd = epicEd;
        this.epicNumber = epicNumber;
        this.fullNameText = fullNameText;
        this.gender = gender;
        this.layout = layout;
        this.mobileNumber = mobileNumber;
        this.relationType = relationType;
        this.relativeName = relativeName;
        this.serielNumber = serielNumber;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BloElectorsListRvItemsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloElectorsListRvItemsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_electors_list_rv_items, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloElectorsListRvItemsBinding bind(View rootView) {
        int i = R.id.aadhaarStatus;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.aadhaarStatus);
        if (textView != null) {
            i = R.id.age;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.age);
            if (textView2 != null) {
                i = R.id.candidateName;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.candidateName);
                if (textView3 != null) {
                    i = R.id.divider;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.divider);
                    if (linearLayout != null) {
                        i = R.id.epic_ed;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_ed);
                        if (textView4 != null) {
                            i = R.id.epic_number;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.epic_number);
                            if (textView5 != null) {
                                i = R.id.fullName_text;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fullName_text);
                                if (textView6 != null) {
                                    i = R.id.gender;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender);
                                    if (textView7 != null) {
                                        i = 2131364428;
                                        ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, 2131364428);
                                        if (constraintLayoutFindChildViewById != null) {
                                            i = R.id.mobileNumber;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobileNumber);
                                            if (textView8 != null) {
                                                i = R.id.relationType;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relationType);
                                                if (textView9 != null) {
                                                    i = R.id.relativeName;
                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.relativeName);
                                                    if (textView10 != null) {
                                                        i = R.id.serielNumber;
                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.serielNumber);
                                                        if (textView11 != null) {
                                                            return new BloElectorsListRvItemsBinding((ConstraintLayout) rootView, textView, textView2, textView3, linearLayout, textView4, textView5, textView6, textView7, constraintLayoutFindChildViewById, textView8, textView9, textView10, textView11);
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
