package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DialogReusableNewDeclartionFormBinding implements ViewBinding {
    public final CardView cardDisabled;
    public final AppCompatAutoCompleteTextView efAcSpinner;
    public final AppCompatAutoCompleteTextView efDistrictSpinner;
    public final AppCompatAutoCompleteTextView efOldPartNo;
    public final AppCompatAutoCompleteTextView efStateSpinner;
    public final LinearLayout electorNameLayout;
    public final TextView electorNameTitle;
    public final TextView electorNameTitlev1;
    public final EditText grandparentName;
    public final LinearLayout grandparentNameLayout;
    public final ImageView ivCancel;
    public final TextView lableState;
    public final LinearLayout layoutVerifyButton;
    public final LinearLayout layoutVerifyDetails;
    public final LinearLayout lvVernacularName;
    public final LinearLayout mainLayout;
    public final NestedScrollView nestedScrollView;
    public final AppCompatAutoCompleteTextView oldAcNo;
    public final AppCompatAutoCompleteTextView oldDistrictSpinner;
    public final AppCompatAutoCompleteTextView oldPartNo;
    public final EditText oldPslNo;
    public final AppCompatAutoCompleteTextView oldStateSpinner;
    public final EditText parentName;
    public final LinearLayout parentNameLayout;
    public final LinearLayout relativeNameV1;
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
    public final LinearLayout searchTabLayout;
    public final EditText selfName;
    public final ImageView speakGrandparent;
    public final ImageView speakParent;
    public final ImageView speakSelf;
    public final ImageView speakSerial;
    public final TextView submitButtonBlo;
    public final TextView titleParentname;
    public final TextView tvAcName;
    public final TextView tvDistrictName;
    public final TextView tvElectorName;
    public final TextView tvElectorNamev1;
    public final TextView tvOldAge;
    public final TextView tvOldEpic;
    public final TextView tvPartName;
    public final TextView tvRecordCount;
    public final TextView tvRelativeName;
    public final TextView tvRelativeNamev1;
    public final TextView tvRelativeType;
    public final TextView tvSectionNo;
    public final TextView tvSerialName;
    public final TextView tvStateName;
    public final TextView txtVerifyButton;
    public final TextView txtVerifyContinueButton;

    private DialogReusableNewDeclartionFormBinding(LinearLayout rootView, CardView cardDisabled, AppCompatAutoCompleteTextView efAcSpinner, AppCompatAutoCompleteTextView efDistrictSpinner, AppCompatAutoCompleteTextView efOldPartNo, AppCompatAutoCompleteTextView efStateSpinner, LinearLayout electorNameLayout, TextView electorNameTitle, TextView electorNameTitlev1, EditText grandparentName, LinearLayout grandparentNameLayout, ImageView ivCancel, TextView lableState, LinearLayout layoutVerifyButton, LinearLayout layoutVerifyDetails, LinearLayout lvVernacularName, LinearLayout mainLayout, NestedScrollView nestedScrollView, AppCompatAutoCompleteTextView oldAcNo, AppCompatAutoCompleteTextView oldDistrictSpinner, AppCompatAutoCompleteTextView oldPartNo, EditText oldPslNo, AppCompatAutoCompleteTextView oldStateSpinner, EditText parentName, LinearLayout parentNameLayout, LinearLayout relativeNameV1, RecyclerView rvMapping, CardView searchAcCV, MaterialButton searchAcPartPslMB, TextView searchButton, LinearLayout searchByAcDetailsLl, CardView searchByLocationCv, LinearLayout searchByLocationDetailsLl, CardView searchCV, MaterialButton searchLocationMB, LinearLayout searchTabLayout, EditText selfName, ImageView speakGrandparent, ImageView speakParent, ImageView speakSelf, ImageView speakSerial, TextView submitButtonBlo, TextView titleParentname, TextView tvAcName, TextView tvDistrictName, TextView tvElectorName, TextView tvElectorNamev1, TextView tvOldAge, TextView tvOldEpic, TextView tvPartName, TextView tvRecordCount, TextView tvRelativeName, TextView tvRelativeNamev1, TextView tvRelativeType, TextView tvSectionNo, TextView tvSerialName, TextView tvStateName, TextView txtVerifyButton, TextView txtVerifyContinueButton) {
        this.rootView = rootView;
        this.cardDisabled = cardDisabled;
        this.efAcSpinner = efAcSpinner;
        this.efDistrictSpinner = efDistrictSpinner;
        this.efOldPartNo = efOldPartNo;
        this.efStateSpinner = efStateSpinner;
        this.electorNameLayout = electorNameLayout;
        this.electorNameTitle = electorNameTitle;
        this.electorNameTitlev1 = electorNameTitlev1;
        this.grandparentName = grandparentName;
        this.grandparentNameLayout = grandparentNameLayout;
        this.ivCancel = ivCancel;
        this.lableState = lableState;
        this.layoutVerifyButton = layoutVerifyButton;
        this.layoutVerifyDetails = layoutVerifyDetails;
        this.lvVernacularName = lvVernacularName;
        this.mainLayout = mainLayout;
        this.nestedScrollView = nestedScrollView;
        this.oldAcNo = oldAcNo;
        this.oldDistrictSpinner = oldDistrictSpinner;
        this.oldPartNo = oldPartNo;
        this.oldPslNo = oldPslNo;
        this.oldStateSpinner = oldStateSpinner;
        this.parentName = parentName;
        this.parentNameLayout = parentNameLayout;
        this.relativeNameV1 = relativeNameV1;
        this.rvMapping = rvMapping;
        this.searchAcCV = searchAcCV;
        this.searchAcPartPslMB = searchAcPartPslMB;
        this.searchButton = searchButton;
        this.searchByAcDetailsLl = searchByAcDetailsLl;
        this.searchByLocationCv = searchByLocationCv;
        this.searchByLocationDetailsLl = searchByLocationDetailsLl;
        this.searchCV = searchCV;
        this.searchLocationMB = searchLocationMB;
        this.searchTabLayout = searchTabLayout;
        this.selfName = selfName;
        this.speakGrandparent = speakGrandparent;
        this.speakParent = speakParent;
        this.speakSelf = speakSelf;
        this.speakSerial = speakSerial;
        this.submitButtonBlo = submitButtonBlo;
        this.titleParentname = titleParentname;
        this.tvAcName = tvAcName;
        this.tvDistrictName = tvDistrictName;
        this.tvElectorName = tvElectorName;
        this.tvElectorNamev1 = tvElectorNamev1;
        this.tvOldAge = tvOldAge;
        this.tvOldEpic = tvOldEpic;
        this.tvPartName = tvPartName;
        this.tvRecordCount = tvRecordCount;
        this.tvRelativeName = tvRelativeName;
        this.tvRelativeNamev1 = tvRelativeNamev1;
        this.tvRelativeType = tvRelativeType;
        this.tvSectionNo = tvSectionNo;
        this.tvSerialName = tvSerialName;
        this.tvStateName = tvStateName;
        this.txtVerifyButton = txtVerifyButton;
        this.txtVerifyContinueButton = txtVerifyContinueButton;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogReusableNewDeclartionFormBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogReusableNewDeclartionFormBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_reusable_new_declartion_form, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogReusableNewDeclartionFormBinding bind(View rootView) {
        int i = R.id.card_disabled;
        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.card_disabled);
        if (cardViewFindChildViewById != null) {
            i = R.id.efAcSpinner;
            AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.efAcSpinner);
            if (appCompatAutoCompleteTextViewFindChildViewById != null) {
                i = R.id.efDistrictSpinner;
                AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.efDistrictSpinner);
                if (appCompatAutoCompleteTextViewFindChildViewById2 != null) {
                    i = R.id.ef_oldPartNo;
                    AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.ef_oldPartNo);
                    if (appCompatAutoCompleteTextViewFindChildViewById3 != null) {
                        i = R.id.efStateSpinner;
                        AppCompatAutoCompleteTextView appCompatAutoCompleteTextViewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.efStateSpinner);
                        if (appCompatAutoCompleteTextViewFindChildViewById4 != null) {
                            i = R.id.electorNameLayout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.electorNameLayout);
                            if (linearLayout != null) {
                                i = R.id.electorNameTitle;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorNameTitle);
                                if (textView != null) {
                                    i = R.id.electorNameTitlev1;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorNameTitlev1);
                                    if (textView2 != null) {
                                        i = R.id.grandparentName;
                                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.grandparentName);
                                        if (editText != null) {
                                            i = R.id.grandparentNameLayout;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.grandparentNameLayout);
                                            if (linearLayout2 != null) {
                                                i = R.id.iv_cancel;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_cancel);
                                                if (imageView != null) {
                                                    i = R.id.lable_state;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.lable_state);
                                                    if (textView3 != null) {
                                                        i = R.id.layoutVerifyButton;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layoutVerifyButton);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.layoutVerifyDetails;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layoutVerifyDetails);
                                                            if (linearLayout4 != null) {
                                                                i = R.id.lv_vernacular_name;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_vernacular_name);
                                                                if (linearLayout5 != null) {
                                                                    i = R.id.mainLayout;
                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainLayout);
                                                                    if (linearLayout6 != null) {
                                                                        i = R.id.nestedScrollView;
                                                                        NestedScrollView nestedScrollViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.nestedScrollView);
                                                                        if (nestedScrollViewFindChildViewById != null) {
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
                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.parentNameLayout);
                                                                                                    if (linearLayout7 != null) {
                                                                                                        i = R.id.relative_name_v1;
                                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.relative_name_v1);
                                                                                                        if (linearLayout8 != null) {
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
                                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.searchButton);
                                                                                                                        if (textView4 != null) {
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
                                                                                                                                                i = R.id.searchTabLayout;
                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.searchTabLayout);
                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                    i = R.id.selfName;
                                                                                                                                                    EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.selfName);
                                                                                                                                                    if (editText4 != null) {
                                                                                                                                                        i = R.id.speak_grandparent;
                                                                                                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speak_grandparent);
                                                                                                                                                        if (imageView2 != null) {
                                                                                                                                                            i = R.id.speak_parent;
                                                                                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speak_parent);
                                                                                                                                                            if (imageView3 != null) {
                                                                                                                                                                i = R.id.speak_self;
                                                                                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speak_self);
                                                                                                                                                                if (imageView4 != null) {
                                                                                                                                                                    i = R.id.speak_serial;
                                                                                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speak_serial);
                                                                                                                                                                    if (imageView5 != null) {
                                                                                                                                                                        i = R.id.submitButtonBlo;
                                                                                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submitButtonBlo);
                                                                                                                                                                        if (textView5 != null) {
                                                                                                                                                                            i = R.id.title_parentname;
                                                                                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title_parentname);
                                                                                                                                                                            if (textView6 != null) {
                                                                                                                                                                                i = R.id.tv_ac_name;
                                                                                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_ac_name);
                                                                                                                                                                                if (textView7 != null) {
                                                                                                                                                                                    i = R.id.tv_district_name;
                                                                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_district_name);
                                                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                                                        i = R.id.tv_elector_name;
                                                                                                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_name);
                                                                                                                                                                                        if (textView9 != null) {
                                                                                                                                                                                            i = R.id.tv_elector_namev1;
                                                                                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_namev1);
                                                                                                                                                                                            if (textView10 != null) {
                                                                                                                                                                                                i = R.id.tv_old_age;
                                                                                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_old_age);
                                                                                                                                                                                                if (textView11 != null) {
                                                                                                                                                                                                    i = R.id.tv_old_epic;
                                                                                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_old_epic);
                                                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                                                        i = R.id.tv_part_name;
                                                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_part_name);
                                                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                                                            i = R.id.tv_record_count;
                                                                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_record_count);
                                                                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                                                                i = R.id.tv_relative_name;
                                                                                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relative_name);
                                                                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                                                                    i = R.id.tv_relative_namev1;
                                                                                                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relative_namev1);
                                                                                                                                                                                                                    if (textView16 != null) {
                                                                                                                                                                                                                        i = R.id.tv_relative_type;
                                                                                                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relative_type);
                                                                                                                                                                                                                        if (textView17 != null) {
                                                                                                                                                                                                                            i = R.id.tv_section_no;
                                                                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_section_no);
                                                                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                                                                i = R.id.tv_serial_name;
                                                                                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_serial_name);
                                                                                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                                                                                    i = R.id.tv_state_name;
                                                                                                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_state_name);
                                                                                                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                                                                                                        i = R.id.txtVerifyButton;
                                                                                                                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtVerifyButton);
                                                                                                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                                                                                                            i = R.id.txtVerifyContinueButton;
                                                                                                                                                                                                                                            TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtVerifyContinueButton);
                                                                                                                                                                                                                                            if (textView22 != null) {
                                                                                                                                                                                                                                                return new DialogReusableNewDeclartionFormBinding((LinearLayout) rootView, cardViewFindChildViewById, appCompatAutoCompleteTextViewFindChildViewById, appCompatAutoCompleteTextViewFindChildViewById2, appCompatAutoCompleteTextViewFindChildViewById3, appCompatAutoCompleteTextViewFindChildViewById4, linearLayout, textView, textView2, editText, linearLayout2, imageView, textView3, linearLayout3, linearLayout4, linearLayout5, linearLayout6, nestedScrollViewFindChildViewById, appCompatAutoCompleteTextViewFindChildViewById5, appCompatAutoCompleteTextViewFindChildViewById6, appCompatAutoCompleteTextViewFindChildViewById7, editText2, appCompatAutoCompleteTextViewFindChildViewById8, editText3, linearLayout7, linearLayout8, recyclerViewFindChildViewById, cardViewFindChildViewById2, materialButtonFindChildViewById, textView4, linearLayout9, cardViewFindChildViewById3, linearLayout10, cardViewFindChildViewById4, materialButtonFindChildViewById2, linearLayout11, editText4, imageView2, imageView3, imageView4, imageView5, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22);
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
