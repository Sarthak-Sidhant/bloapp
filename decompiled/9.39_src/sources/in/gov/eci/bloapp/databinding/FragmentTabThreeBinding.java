package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class FragmentTabThreeBinding implements ViewBinding {
    public final AppCompatAutoCompleteTextView efAcSpinner;
    public final AppCompatAutoCompleteTextView efDistrictSpinner;
    public final AppCompatAutoCompleteTextView efPartSpinner;
    public final AppCompatAutoCompleteTextView efStateSpinner;
    public final LinearLayout electorNameLayout;
    public final EditText grandparentName;
    public final LinearLayout grandparentNameLayout;
    public final CurrentElectorDetailsBinding includeCurrentDetails;
    public final ItemProgenyMappingListBinding includeElectorDetails;
    public final LinearLayout layoutVerifyButton;
    public final LinearLayout layoutVerifyDetails;
    public final LinearLayout lvCurrentDetails;
    public final LinearLayout lvVerifyDetails;
    public final LinearLayout mainLayout;
    public final RadioButton neitherElector2003RB;
    public final AppCompatAutoCompleteTextView oldAcNo;
    public final AppCompatAutoCompleteTextView oldDistrictSpinner;
    public final AppCompatAutoCompleteTextView oldPartNo;
    public final EditText oldPslNo;
    public final AppCompatAutoCompleteTextView oldStateSpinner;
    public final EditText parentName;
    public final LinearLayout parentNameLayout;
    public final RadioButton progenyElector2003RB;
    public final RadioButton progenyElector2005RB;
    public final CardView radioCardView;
    private final LinearLayout rootView;
    public final RecyclerView rvMapping;
    public final CardView searchAcCV;
    public final MaterialButton searchAcPartPslMB;
    public final TextView searchButton;
    public final LinearLayout searchByAcDetailsLl;
    public final CardView searchByLocationCv;
    public final LinearLayout searchByLocationDetailsLl;
    public final CardView searchCV;
    public final MaterialButton searchLocationMB;
    public final RadioGroup searchRG;
    public final LinearLayout searchTabLayout;
    public final TextView searchTitle;
    public final EditText selfName;
    public final ImageView speak;
    public final ImageView speakGrandparent;
    public final ImageView speakParent;
    public final ImageView speakSelf;
    public final ScrollView svView;
    public final TextView titleParentname;
    public final TextView tvNoteSelf;
    public final TextView tvRecordCount;
    public final TextView txtVerifyButton;
    public final TextView txtVerifyContinueButton;
    public final RadioButton wasElector2003RB;

    private FragmentTabThreeBinding(LinearLayout rootView, AppCompatAutoCompleteTextView efAcSpinner, AppCompatAutoCompleteTextView efDistrictSpinner, AppCompatAutoCompleteTextView efPartSpinner, AppCompatAutoCompleteTextView efStateSpinner, LinearLayout electorNameLayout, EditText grandparentName, LinearLayout grandparentNameLayout, CurrentElectorDetailsBinding includeCurrentDetails, ItemProgenyMappingListBinding includeElectorDetails, LinearLayout layoutVerifyButton, LinearLayout layoutVerifyDetails, LinearLayout lvCurrentDetails, LinearLayout lvVerifyDetails, LinearLayout mainLayout, RadioButton neitherElector2003RB, AppCompatAutoCompleteTextView oldAcNo, AppCompatAutoCompleteTextView oldDistrictSpinner, AppCompatAutoCompleteTextView oldPartNo, EditText oldPslNo, AppCompatAutoCompleteTextView oldStateSpinner, EditText parentName, LinearLayout parentNameLayout, RadioButton progenyElector2003RB, RadioButton progenyElector2005RB, CardView radioCardView, RecyclerView rvMapping, CardView searchAcCV, MaterialButton searchAcPartPslMB, TextView searchButton, LinearLayout searchByAcDetailsLl, CardView searchByLocationCv, LinearLayout searchByLocationDetailsLl, CardView searchCV, MaterialButton searchLocationMB, RadioGroup searchRG, LinearLayout searchTabLayout, TextView searchTitle, EditText selfName, ImageView speak, ImageView speakGrandparent, ImageView speakParent, ImageView speakSelf, ScrollView svView, TextView titleParentname, TextView tvNoteSelf, TextView tvRecordCount, TextView txtVerifyButton, TextView txtVerifyContinueButton, RadioButton wasElector2003RB) {
        this.rootView = rootView;
        this.efAcSpinner = efAcSpinner;
        this.efDistrictSpinner = efDistrictSpinner;
        this.efPartSpinner = efPartSpinner;
        this.efStateSpinner = efStateSpinner;
        this.electorNameLayout = electorNameLayout;
        this.grandparentName = grandparentName;
        this.grandparentNameLayout = grandparentNameLayout;
        this.includeCurrentDetails = includeCurrentDetails;
        this.includeElectorDetails = includeElectorDetails;
        this.layoutVerifyButton = layoutVerifyButton;
        this.layoutVerifyDetails = layoutVerifyDetails;
        this.lvCurrentDetails = lvCurrentDetails;
        this.lvVerifyDetails = lvVerifyDetails;
        this.mainLayout = mainLayout;
        this.neitherElector2003RB = neitherElector2003RB;
        this.oldAcNo = oldAcNo;
        this.oldDistrictSpinner = oldDistrictSpinner;
        this.oldPartNo = oldPartNo;
        this.oldPslNo = oldPslNo;
        this.oldStateSpinner = oldStateSpinner;
        this.parentName = parentName;
        this.parentNameLayout = parentNameLayout;
        this.progenyElector2003RB = progenyElector2003RB;
        this.progenyElector2005RB = progenyElector2005RB;
        this.radioCardView = radioCardView;
        this.rvMapping = rvMapping;
        this.searchAcCV = searchAcCV;
        this.searchAcPartPslMB = searchAcPartPslMB;
        this.searchButton = searchButton;
        this.searchByAcDetailsLl = searchByAcDetailsLl;
        this.searchByLocationCv = searchByLocationCv;
        this.searchByLocationDetailsLl = searchByLocationDetailsLl;
        this.searchCV = searchCV;
        this.searchLocationMB = searchLocationMB;
        this.searchRG = searchRG;
        this.searchTabLayout = searchTabLayout;
        this.searchTitle = searchTitle;
        this.selfName = selfName;
        this.speak = speak;
        this.speakGrandparent = speakGrandparent;
        this.speakParent = speakParent;
        this.speakSelf = speakSelf;
        this.svView = svView;
        this.titleParentname = titleParentname;
        this.tvNoteSelf = tvNoteSelf;
        this.tvRecordCount = tvRecordCount;
        this.txtVerifyButton = txtVerifyButton;
        this.txtVerifyContinueButton = txtVerifyContinueButton;
        this.wasElector2003RB = wasElector2003RB;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTabThreeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentTabThreeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_tab_three, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTabThreeBinding bind(View rootView) {
        int i = R.id.efAcSpinner;
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
                            i = R.id.grandparentName;
                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.grandparentName);
                            if (editText != null) {
                                i = R.id.grandparentNameLayout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.grandparentNameLayout);
                                if (linearLayout2 != null) {
                                    i = R.id.include_current_details;
                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.include_current_details);
                                    if (viewFindChildViewById != null) {
                                        CurrentElectorDetailsBinding currentElectorDetailsBindingBind = CurrentElectorDetailsBinding.bind(viewFindChildViewById);
                                        i = R.id.include_elector_details;
                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.include_elector_details);
                                        if (viewFindChildViewById2 != null) {
                                            ItemProgenyMappingListBinding itemProgenyMappingListBindingBind = ItemProgenyMappingListBinding.bind(viewFindChildViewById2);
                                            i = R.id.layoutVerifyButton;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layoutVerifyButton);
                                            if (linearLayout3 != null) {
                                                i = R.id.layoutVerifyDetails;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layoutVerifyDetails);
                                                if (linearLayout4 != null) {
                                                    i = R.id.lv_current_details;
                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_current_details);
                                                    if (linearLayout5 != null) {
                                                        i = R.id.lv_verify_details;
                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_verify_details);
                                                        if (linearLayout6 != null) {
                                                            i = R.id.mainLayout;
                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainLayout);
                                                            if (linearLayout7 != null) {
                                                                i = R.id.neitherElector2003RB;
                                                                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.neitherElector2003RB);
                                                                if (radioButton != null) {
                                                                    i = R.id.oldAcNo;
                                                                    AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.oldAcNo);
                                                                    if (appCompatAutoCompleteTextViewFindChildViewById5 != null) {
                                                                        i = R.id.oldDistrictSpinner;
                                                                        AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.oldDistrictSpinner);
                                                                        if (appCompatAutoCompleteTextViewFindChildViewById6 != null) {
                                                                            i = R.id.oldPartNo;
                                                                            AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById7 = ViewBindings.findChildViewById(rootView, R.id.oldPartNo);
                                                                            if (appCompatAutoCompleteTextViewFindChildViewById7 != null) {
                                                                                i = R.id.oldPslNo;
                                                                                EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.oldPslNo);
                                                                                if (editText2 != null) {
                                                                                    i = R.id.oldStateSpinner;
                                                                                    AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById8 = ViewBindings.findChildViewById(rootView, R.id.oldStateSpinner);
                                                                                    if (appCompatAutoCompleteTextViewFindChildViewById8 != null) {
                                                                                        i = R.id.parentName;
                                                                                        EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.parentName);
                                                                                        if (editText3 != null) {
                                                                                            i = R.id.parentNameLayout;
                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.parentNameLayout);
                                                                                            if (linearLayout8 != null) {
                                                                                                i = R.id.progenyElector2003RB;
                                                                                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.progenyElector2003RB);
                                                                                                if (radioButton2 != null) {
                                                                                                    i = R.id.progenyElector2005RB;
                                                                                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.progenyElector2005RB);
                                                                                                    if (radioButton3 != null) {
                                                                                                        i = R.id.radioCardView;
                                                                                                        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.radioCardView);
                                                                                                        if (cardViewFindChildViewById != null) {
                                                                                                            i = R.id.rv_mapping;
                                                                                                            RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.rv_mapping);
                                                                                                            if (recyclerViewFindChildViewById != null) {
                                                                                                                i = R.id.search_ac_CV;
                                                                                                                CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.search_ac_CV);
                                                                                                                if (cardViewFindChildViewById2 != null) {
                                                                                                                    i = R.id.searchAcPartPslMB;
                                                                                                                    MaterialButton materialButtonFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.searchAcPartPslMB);
                                                                                                                    if (materialButtonFindChildViewById != null) {
                                                                                                                        i = R.id.searchButton;
                                                                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.searchButton);
                                                                                                                        if (textView != null) {
                                                                                                                            i = R.id.search_by_ac_details_ll;
                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.search_by_ac_details_ll);
                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                i = R.id.search_by_location_cv;
                                                                                                                                CardView cardViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.search_by_location_cv);
                                                                                                                                if (cardViewFindChildViewById3 != null) {
                                                                                                                                    i = R.id.search_by_location_details_ll;
                                                                                                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.search_by_location_details_ll);
                                                                                                                                    if (linearLayout10 != null) {
                                                                                                                                        i = R.id.searchCV;
                                                                                                                                        CardView cardViewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.searchCV);
                                                                                                                                        if (cardViewFindChildViewById4 != null) {
                                                                                                                                            i = R.id.searchLocationMB;
                                                                                                                                            MaterialButton materialButtonFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.searchLocationMB);
                                                                                                                                            if (materialButtonFindChildViewById2 != null) {
                                                                                                                                                i = R.id.searchRG;
                                                                                                                                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.searchRG);
                                                                                                                                                if (radioGroup != null) {
                                                                                                                                                    i = R.id.searchTabLayout;
                                                                                                                                                    LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.searchTabLayout);
                                                                                                                                                    if (linearLayout11 != null) {
                                                                                                                                                        i = R.id.search_title;
                                                                                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.search_title);
                                                                                                                                                        if (textView2 != null) {
                                                                                                                                                            i = R.id.selfName;
                                                                                                                                                            EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.selfName);
                                                                                                                                                            if (editText4 != null) {
                                                                                                                                                                i = R.id.speak;
                                                                                                                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speak);
                                                                                                                                                                if (imageView != null) {
                                                                                                                                                                    i = R.id.speak_grandparent;
                                                                                                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speak_grandparent);
                                                                                                                                                                    if (imageView2 != null) {
                                                                                                                                                                        i = R.id.speak_parent;
                                                                                                                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speak_parent);
                                                                                                                                                                        if (imageView3 != null) {
                                                                                                                                                                            i = R.id.speak_self;
                                                                                                                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speak_self);
                                                                                                                                                                            if (imageView4 != null) {
                                                                                                                                                                                i = R.id.sv_view;
                                                                                                                                                                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(rootView, R.id.sv_view);
                                                                                                                                                                                if (scrollView != null) {
                                                                                                                                                                                    i = R.id.title_parentname;
                                                                                                                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title_parentname);
                                                                                                                                                                                    if (textView3 != null) {
                                                                                                                                                                                        i = R.id.tv_note_self;
                                                                                                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_note_self);
                                                                                                                                                                                        if (textView4 != null) {
                                                                                                                                                                                            i = R.id.tv_record_count;
                                                                                                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_record_count);
                                                                                                                                                                                            if (textView5 != null) {
                                                                                                                                                                                                i = R.id.txtVerifyButton;
                                                                                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtVerifyButton);
                                                                                                                                                                                                if (textView6 != null) {
                                                                                                                                                                                                    i = R.id.txtVerifyContinueButton;
                                                                                                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtVerifyContinueButton);
                                                                                                                                                                                                    if (textView7 != null) {
                                                                                                                                                                                                        i = R.id.wasElector2003RB;
                                                                                                                                                                                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.wasElector2003RB);
                                                                                                                                                                                                        if (radioButton4 != null) {
                                                                                                                                                                                                            return new FragmentTabThreeBinding((LinearLayout) rootView, appCompatAutoCompleteTextViewFindChildViewById, appCompatAutoCompleteTextViewFindChildViewById2, appCompatAutoCompleteTextViewFindChildViewById3, appCompatAutoCompleteTextViewFindChildViewById4, linearLayout, editText, linearLayout2, currentElectorDetailsBindingBind, itemProgenyMappingListBindingBind, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, radioButton, appCompatAutoCompleteTextViewFindChildViewById5, appCompatAutoCompleteTextViewFindChildViewById6, appCompatAutoCompleteTextViewFindChildViewById7, editText2, appCompatAutoCompleteTextViewFindChildViewById8, editText3, linearLayout8, radioButton2, radioButton3, cardViewFindChildViewById, recyclerViewFindChildViewById, cardViewFindChildViewById2, materialButtonFindChildViewById, textView, linearLayout9, cardViewFindChildViewById3, linearLayout10, cardViewFindChildViewById4, materialButtonFindChildViewById2, radioGroup, linearLayout11, textView2, editText4, imageView, imageView2, imageView3, imageView4, scrollView, textView3, textView4, textView5, textView6, textView7, radioButton4);
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
