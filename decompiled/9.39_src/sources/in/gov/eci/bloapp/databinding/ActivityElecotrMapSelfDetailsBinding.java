package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityElecotrMapSelfDetailsBinding implements ViewBinding {
    public final ImageView backBtnIv;
    public final ConstraintLayout blaTopLayout;
    public final AppCompatAutoCompleteTextView efAcSpinner;
    public final AppCompatAutoCompleteTextView efDistrictSpinner;
    public final AppCompatAutoCompleteTextView efPartSpinner;
    public final AppCompatAutoCompleteTextView efStateSpinner;
    public final LinearLayout electorNameLayout;
    public final NestedScrollView formScroll;
    public final EditText grandparentName;
    public final LinearLayout grandparentNameLayout;
    public final LinearLayout layoutVerifyButton;
    public final LinearLayout layoutVerifyDetails;
    public final LinearLayout main;
    public final Spinner oldAcNo;
    public final Spinner oldPartNo;
    public final EditText oldPslNo;
    public final Spinner oldStateSpinner;
    public final EditText parentName;
    public final LinearLayout parentNameLayout;
    private final LinearLayout rootView;
    public final RecyclerView rvMapping;
    public final LinearLayout searchAcPart;
    public final MaterialButton searchAcPartPslMB;
    public final TextView searchButton;
    public final CardView searchByLocationCv;
    public final LinearLayout searchByLocationDetailsLl;
    public final CardView searchCV;
    public final MaterialButton searchLocationMB;
    public final LinearLayout searchTabLayout;
    public final EditText selfName;
    public final TextView textView3;
    public final TextView titleParentname;
    public final ImageView toolbarButton;
    public final TextView tvRecordCount;
    public final TextView txtVerifyButton;
    public final TextView txtVerifyContinueButton;

    private ActivityElecotrMapSelfDetailsBinding(LinearLayout rootView, ImageView backBtnIv, ConstraintLayout blaTopLayout, AppCompatAutoCompleteTextView efAcSpinner, AppCompatAutoCompleteTextView efDistrictSpinner, AppCompatAutoCompleteTextView efPartSpinner, AppCompatAutoCompleteTextView efStateSpinner, LinearLayout electorNameLayout, NestedScrollView formScroll, EditText grandparentName, LinearLayout grandparentNameLayout, LinearLayout layoutVerifyButton, LinearLayout layoutVerifyDetails, LinearLayout main, Spinner oldAcNo, Spinner oldPartNo, EditText oldPslNo, Spinner oldStateSpinner, EditText parentName, LinearLayout parentNameLayout, RecyclerView rvMapping, LinearLayout searchAcPart, MaterialButton searchAcPartPslMB, TextView searchButton, CardView searchByLocationCv, LinearLayout searchByLocationDetailsLl, CardView searchCV, MaterialButton searchLocationMB, LinearLayout searchTabLayout, EditText selfName, TextView textView3, TextView titleParentname, ImageView toolbarButton, TextView tvRecordCount, TextView txtVerifyButton, TextView txtVerifyContinueButton) {
        this.rootView = rootView;
        this.backBtnIv = backBtnIv;
        this.blaTopLayout = blaTopLayout;
        this.efAcSpinner = efAcSpinner;
        this.efDistrictSpinner = efDistrictSpinner;
        this.efPartSpinner = efPartSpinner;
        this.efStateSpinner = efStateSpinner;
        this.electorNameLayout = electorNameLayout;
        this.formScroll = formScroll;
        this.grandparentName = grandparentName;
        this.grandparentNameLayout = grandparentNameLayout;
        this.layoutVerifyButton = layoutVerifyButton;
        this.layoutVerifyDetails = layoutVerifyDetails;
        this.main = main;
        this.oldAcNo = oldAcNo;
        this.oldPartNo = oldPartNo;
        this.oldPslNo = oldPslNo;
        this.oldStateSpinner = oldStateSpinner;
        this.parentName = parentName;
        this.parentNameLayout = parentNameLayout;
        this.rvMapping = rvMapping;
        this.searchAcPart = searchAcPart;
        this.searchAcPartPslMB = searchAcPartPslMB;
        this.searchButton = searchButton;
        this.searchByLocationCv = searchByLocationCv;
        this.searchByLocationDetailsLl = searchByLocationDetailsLl;
        this.searchCV = searchCV;
        this.searchLocationMB = searchLocationMB;
        this.searchTabLayout = searchTabLayout;
        this.selfName = selfName;
        this.textView3 = textView3;
        this.titleParentname = titleParentname;
        this.toolbarButton = toolbarButton;
        this.tvRecordCount = tvRecordCount;
        this.txtVerifyButton = txtVerifyButton;
        this.txtVerifyContinueButton = txtVerifyContinueButton;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityElecotrMapSelfDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityElecotrMapSelfDetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_elecotr_map_self_details, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityElecotrMapSelfDetailsBinding bind(View rootView) {
        int i = R.id.back_btn_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_btn_iv);
        if (imageView != null) {
            i = R.id.bla_top_layout;
            ConstraintLayout constraintLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bla_top_layout);
            if (constraintLayoutFindChildViewById != null) {
                i = R.id.efAcSpinner;
                AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.efAcSpinner);
                if (appCompatAutoCompleteTextViewFindChildViewById != null) {
                    i = R.id.efDistrictSpinner;
                    AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.efDistrictSpinner);
                    if (appCompatAutoCompleteTextViewFindChildViewById2 != null) {
                        i = R.id.efPartSpinner;
                        AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.efPartSpinner);
                        if (appCompatAutoCompleteTextViewFindChildViewById3 != null) {
                            i = R.id.efStateSpinner;
                            AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.efStateSpinner);
                            if (appCompatAutoCompleteTextViewFindChildViewById4 != null) {
                                i = R.id.electorNameLayout;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.electorNameLayout);
                                if (linearLayout != null) {
                                    i = R.id.formScroll;
                                    NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.formScroll);
                                    if (nestedScrollViewFindChildViewById != null) {
                                        i = R.id.grandparentName;
                                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.grandparentName);
                                        if (editText != null) {
                                            i = R.id.grandparentNameLayout;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.grandparentNameLayout);
                                            if (linearLayout2 != null) {
                                                i = R.id.layoutVerifyButton;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layoutVerifyButton);
                                                if (linearLayout3 != null) {
                                                    i = R.id.layoutVerifyDetails;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layoutVerifyDetails);
                                                    if (linearLayout4 != null) {
                                                        LinearLayout linearLayout5 = (LinearLayout) rootView;
                                                        i = R.id.oldAcNo;
                                                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.oldAcNo);
                                                        if (spinner != null) {
                                                            i = R.id.oldPartNo;
                                                            Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(rootView, R.id.oldPartNo);
                                                            if (spinner2 != null) {
                                                                i = R.id.oldPslNo;
                                                                EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.oldPslNo);
                                                                if (editText2 != null) {
                                                                    i = R.id.oldStateSpinner;
                                                                    Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(rootView, R.id.oldStateSpinner);
                                                                    if (spinner3 != null) {
                                                                        i = R.id.parentName;
                                                                        EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.parentName);
                                                                        if (editText3 != null) {
                                                                            i = R.id.parentNameLayout;
                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.parentNameLayout);
                                                                            if (linearLayout6 != null) {
                                                                                i = R.id.rv_mapping;
                                                                                RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.rv_mapping);
                                                                                if (recyclerViewFindChildViewById != null) {
                                                                                    i = R.id.searchAcPart;
                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.searchAcPart);
                                                                                    if (linearLayout7 != null) {
                                                                                        i = R.id.searchAcPartPslMB;
                                                                                        MaterialButton materialButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.searchAcPartPslMB);
                                                                                        if (materialButtonFindChildViewById != null) {
                                                                                            i = R.id.searchButton;
                                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.searchButton);
                                                                                            if (textView != null) {
                                                                                                i = R.id.search_by_location_cv;
                                                                                                CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.search_by_location_cv);
                                                                                                if (cardViewFindChildViewById != null) {
                                                                                                    i = R.id.search_by_location_details_ll;
                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.search_by_location_details_ll);
                                                                                                    if (linearLayout8 != null) {
                                                                                                        i = R.id.searchCV;
                                                                                                        CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.searchCV);
                                                                                                        if (cardViewFindChildViewById2 != null) {
                                                                                                            i = R.id.searchLocationMB;
                                                                                                            MaterialButton materialButtonFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.searchLocationMB);
                                                                                                            if (materialButtonFindChildViewById2 != null) {
                                                                                                                i = R.id.searchTabLayout;
                                                                                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.searchTabLayout);
                                                                                                                if (linearLayout9 != null) {
                                                                                                                    i = R.id.selfName;
                                                                                                                    EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.selfName);
                                                                                                                    if (editText4 != null) {
                                                                                                                        i = R.id.textView3;
                                                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                                                                                        if (textView2 != null) {
                                                                                                                            i = R.id.title_parentname;
                                                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title_parentname);
                                                                                                                            if (textView3 != null) {
                                                                                                                                i = R.id.toolbar_button;
                                                                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.toolbar_button);
                                                                                                                                if (imageView2 != null) {
                                                                                                                                    i = R.id.tv_record_count;
                                                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_record_count);
                                                                                                                                    if (textView4 != null) {
                                                                                                                                        i = R.id.txtVerifyButton;
                                                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtVerifyButton);
                                                                                                                                        if (textView5 != null) {
                                                                                                                                            i = R.id.txtVerifyContinueButton;
                                                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtVerifyContinueButton);
                                                                                                                                            if (textView6 != null) {
                                                                                                                                                return new ActivityElecotrMapSelfDetailsBinding(linearLayout5, imageView, constraintLayoutFindChildViewById, appCompatAutoCompleteTextViewFindChildViewById, appCompatAutoCompleteTextViewFindChildViewById2, appCompatAutoCompleteTextViewFindChildViewById3, appCompatAutoCompleteTextViewFindChildViewById4, linearLayout, nestedScrollViewFindChildViewById, editText, linearLayout2, linearLayout3, linearLayout4, linearLayout5, spinner, spinner2, editText2, spinner3, editText3, linearLayout6, recyclerViewFindChildViewById, linearLayout7, materialButtonFindChildViewById, textView, cardViewFindChildViewById, linearLayout8, cardViewFindChildViewById2, materialButtonFindChildViewById2, linearLayout9, editText4, textView2, textView3, imageView2, textView4, textView5, textView6);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
