package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class DialogFetchPersonalDetailsBinding implements ViewBinding {
    public final CheckBox cbNotsubmitted;
    public final CardView epicIssued;
    public final CardView epicIssuedCv;
    public final LinearLayout epicIssuedLl;
    public final LinearLayout epicTabLayout;
    public final MaterialButton epictab;
    public final TextView exit;
    public final TextView form6;
    public final TextView form8;
    public final CardView formsInProcessCv;
    public final LinearLayout formsInProcessLl;
    public final ImageView ivCancel;
    public final LinearLayout layoutVerifyButton;
    public final LinearLayout mainLayout;
    public final NestedScrollView nestedScrollView;
    private final LinearLayout rootView;
    public final RecyclerView rvEpicIssued;
    public final RecyclerView rvFormsInProcess;
    public final MaterialButton searchAcPartPslMB;
    public final CardView searchCV;
    public final LinearLayout searchTabLayout;

    private DialogFetchPersonalDetailsBinding(LinearLayout rootView, CheckBox cbNotsubmitted, CardView epicIssued, CardView epicIssuedCv, LinearLayout epicIssuedLl, LinearLayout epicTabLayout, MaterialButton epictab, TextView exit, TextView form6, TextView form8, CardView formsInProcessCv, LinearLayout formsInProcessLl, ImageView ivCancel, LinearLayout layoutVerifyButton, LinearLayout mainLayout, NestedScrollView nestedScrollView, RecyclerView rvEpicIssued, RecyclerView rvFormsInProcess, MaterialButton searchAcPartPslMB, CardView searchCV, LinearLayout searchTabLayout) {
        this.rootView = rootView;
        this.cbNotsubmitted = cbNotsubmitted;
        this.epicIssued = epicIssued;
        this.epicIssuedCv = epicIssuedCv;
        this.epicIssuedLl = epicIssuedLl;
        this.epicTabLayout = epicTabLayout;
        this.epictab = epictab;
        this.exit = exit;
        this.form6 = form6;
        this.form8 = form8;
        this.formsInProcessCv = formsInProcessCv;
        this.formsInProcessLl = formsInProcessLl;
        this.ivCancel = ivCancel;
        this.layoutVerifyButton = layoutVerifyButton;
        this.mainLayout = mainLayout;
        this.nestedScrollView = nestedScrollView;
        this.rvEpicIssued = rvEpicIssued;
        this.rvFormsInProcess = rvFormsInProcess;
        this.searchAcPartPslMB = searchAcPartPslMB;
        this.searchCV = searchCV;
        this.searchTabLayout = searchTabLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogFetchPersonalDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogFetchPersonalDetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_fetch_personal_details, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogFetchPersonalDetailsBinding bind(View rootView) {
        int i = R.id.cb_notsubmitted;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.cb_notsubmitted);
        if (checkBox != null) {
            i = R.id.epic_issued;
            CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.epic_issued);
            if (cardViewFindChildViewById != null) {
                i = R.id.epic_issued_cv;
                CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.epic_issued_cv);
                if (cardViewFindChildViewById2 != null) {
                    i = R.id.epic_issued_ll;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.epic_issued_ll);
                    if (linearLayout != null) {
                        i = R.id.epic_tab_layout;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.epic_tab_layout);
                        if (linearLayout2 != null) {
                            i = R.id.epictab;
                            MaterialButton materialButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.epictab);
                            if (materialButtonFindChildViewById != null) {
                                i = R.id.exit;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.exit);
                                if (textView != null) {
                                    i = R.id.form6;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form6);
                                    if (textView2 != null) {
                                        i = R.id.form8;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.form8);
                                        if (textView3 != null) {
                                            i = R.id.forms_in_process_cv;
                                            CardView cardViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.forms_in_process_cv);
                                            if (cardViewFindChildViewById3 != null) {
                                                i = R.id.forms_in_process_ll;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.forms_in_process_ll);
                                                if (linearLayout3 != null) {
                                                    i = R.id.iv_cancel;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_cancel);
                                                    if (imageView != null) {
                                                        i = R.id.layoutVerifyButton;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layoutVerifyButton);
                                                        if (linearLayout4 != null) {
                                                            i = R.id.mainLayout;
                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainLayout);
                                                            if (linearLayout5 != null) {
                                                                i = R.id.nestedScrollView;
                                                                NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.nestedScrollView);
                                                                if (nestedScrollViewFindChildViewById != null) {
                                                                    i = R.id.rv_epic_issued;
                                                                    RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.rv_epic_issued);
                                                                    if (recyclerViewFindChildViewById != null) {
                                                                        i = R.id.rv_forms_in_process;
                                                                        RecyclerView recyclerViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.rv_forms_in_process);
                                                                        if (recyclerViewFindChildViewById2 != null) {
                                                                            i = R.id.searchAcPartPslMB;
                                                                            MaterialButton materialButtonFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.searchAcPartPslMB);
                                                                            if (materialButtonFindChildViewById2 != null) {
                                                                                i = R.id.searchCV;
                                                                                CardView cardViewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.searchCV);
                                                                                if (cardViewFindChildViewById4 != null) {
                                                                                    i = R.id.searchTabLayout;
                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.searchTabLayout);
                                                                                    if (linearLayout6 != null) {
                                                                                        return new DialogFetchPersonalDetailsBinding((LinearLayout) rootView, checkBox, cardViewFindChildViewById, cardViewFindChildViewById2, linearLayout, linearLayout2, materialButtonFindChildViewById, textView, textView2, textView3, cardViewFindChildViewById3, linearLayout3, imageView, linearLayout4, linearLayout5, nestedScrollViewFindChildViewById, recyclerViewFindChildViewById, recyclerViewFindChildViewById2, materialButtonFindChildViewById2, cardViewFindChildViewById4, linearLayout6);
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
