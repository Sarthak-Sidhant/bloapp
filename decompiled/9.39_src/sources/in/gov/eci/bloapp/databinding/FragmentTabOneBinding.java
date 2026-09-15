package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class FragmentTabOneBinding implements ViewBinding {
    public final CardView cardDisabled;
    public final CardView cardEnabled;
    public final RelativeLayout detailName;
    public final LinearLayout electorNameEditv1;
    public final TextView electorNameEnable;
    public final TextView electorNameEnablev1;
    public final TextView electorNameTitle;
    public final TextView electorNameTitlev1;
    public final TextView headerTitle;
    public final TextView headertitleaedit;
    public final CurrentElectorDetailsBinding includeCurrentDetails;
    public final TextView ivEdit;
    public final TextView lableState;
    public final LinearLayout layoutVerifyDetails;
    public final LinearLayout lvCurrentDetails;
    public final LinearLayout lvVernacularName;
    public final LinearLayout matchingLayout;
    public final Spinner oldAcNo;
    public final Spinner oldPartNo;
    public final EditText oldPslNo;
    public final Spinner oldStateSpinner;
    public final ProgressBar progressBar;
    public final LinearLayout relativeNameV1;
    public final LinearLayout releativeNameEditv1;
    private final LinearLayout rootView;
    public final RecyclerView rvMapping;
    public final LinearLayout searchByAcLl;
    public final ImageView speak;
    public final TextView submitButtonBlo;
    public final TextView tvAcName;
    public final TextView tvDetails;
    public final TextView tvDisclamierSir;
    public final TextView tvDistrictName;
    public final TextView tvElectorName;
    public final TextView tvElectorNameEdit;
    public final TextView tvElectorNameEditv1;
    public final TextView tvElectorNamev1;
    public final TextView tvLeftName;
    public final TextView tvOldAge;
    public final TextView tvOldEpic;
    public final TextView tvPartName;
    public final TextView tvRecordCount;
    public final TextView tvRelativeName;
    public final TextView tvRelativeNamev1;
    public final TextView tvRelativeType;
    public final TextView tvReleativeNameEdit;
    public final TextView tvReleativeNameEditv1;
    public final TextView tvReleativeTypeEdit;
    public final TextView tvRightName;
    public final TextView tvSectionNo;
    public final TextView tvSerialName;
    public final TextView tvStateName;
    public final TextView txtVerifyButton;

    private FragmentTabOneBinding(LinearLayout rootView, CardView cardDisabled, CardView cardEnabled, RelativeLayout detailName, LinearLayout electorNameEditv1, TextView electorNameEnable, TextView electorNameEnablev1, TextView electorNameTitle, TextView electorNameTitlev1, TextView headerTitle, TextView headertitleaedit, CurrentElectorDetailsBinding includeCurrentDetails, TextView ivEdit, TextView lableState, LinearLayout layoutVerifyDetails, LinearLayout lvCurrentDetails, LinearLayout lvVernacularName, LinearLayout matchingLayout, Spinner oldAcNo, Spinner oldPartNo, EditText oldPslNo, Spinner oldStateSpinner, ProgressBar progressBar, LinearLayout relativeNameV1, LinearLayout releativeNameEditv1, RecyclerView rvMapping, LinearLayout searchByAcLl, ImageView speak, TextView submitButtonBlo, TextView tvAcName, TextView tvDetails, TextView tvDisclamierSir, TextView tvDistrictName, TextView tvElectorName, TextView tvElectorNameEdit, TextView tvElectorNameEditv1, TextView tvElectorNamev1, TextView tvLeftName, TextView tvOldAge, TextView tvOldEpic, TextView tvPartName, TextView tvRecordCount, TextView tvRelativeName, TextView tvRelativeNamev1, TextView tvRelativeType, TextView tvReleativeNameEdit, TextView tvReleativeNameEditv1, TextView tvReleativeTypeEdit, TextView tvRightName, TextView tvSectionNo, TextView tvSerialName, TextView tvStateName, TextView txtVerifyButton) {
        this.rootView = rootView;
        this.cardDisabled = cardDisabled;
        this.cardEnabled = cardEnabled;
        this.detailName = detailName;
        this.electorNameEditv1 = electorNameEditv1;
        this.electorNameEnable = electorNameEnable;
        this.electorNameEnablev1 = electorNameEnablev1;
        this.electorNameTitle = electorNameTitle;
        this.electorNameTitlev1 = electorNameTitlev1;
        this.headerTitle = headerTitle;
        this.headertitleaedit = headertitleaedit;
        this.includeCurrentDetails = includeCurrentDetails;
        this.ivEdit = ivEdit;
        this.lableState = lableState;
        this.layoutVerifyDetails = layoutVerifyDetails;
        this.lvCurrentDetails = lvCurrentDetails;
        this.lvVernacularName = lvVernacularName;
        this.matchingLayout = matchingLayout;
        this.oldAcNo = oldAcNo;
        this.oldPartNo = oldPartNo;
        this.oldPslNo = oldPslNo;
        this.oldStateSpinner = oldStateSpinner;
        this.progressBar = progressBar;
        this.relativeNameV1 = relativeNameV1;
        this.releativeNameEditv1 = releativeNameEditv1;
        this.rvMapping = rvMapping;
        this.searchByAcLl = searchByAcLl;
        this.speak = speak;
        this.submitButtonBlo = submitButtonBlo;
        this.tvAcName = tvAcName;
        this.tvDetails = tvDetails;
        this.tvDisclamierSir = tvDisclamierSir;
        this.tvDistrictName = tvDistrictName;
        this.tvElectorName = tvElectorName;
        this.tvElectorNameEdit = tvElectorNameEdit;
        this.tvElectorNameEditv1 = tvElectorNameEditv1;
        this.tvElectorNamev1 = tvElectorNamev1;
        this.tvLeftName = tvLeftName;
        this.tvOldAge = tvOldAge;
        this.tvOldEpic = tvOldEpic;
        this.tvPartName = tvPartName;
        this.tvRecordCount = tvRecordCount;
        this.tvRelativeName = tvRelativeName;
        this.tvRelativeNamev1 = tvRelativeNamev1;
        this.tvRelativeType = tvRelativeType;
        this.tvReleativeNameEdit = tvReleativeNameEdit;
        this.tvReleativeNameEditv1 = tvReleativeNameEditv1;
        this.tvReleativeTypeEdit = tvReleativeTypeEdit;
        this.tvRightName = tvRightName;
        this.tvSectionNo = tvSectionNo;
        this.tvSerialName = tvSerialName;
        this.tvStateName = tvStateName;
        this.txtVerifyButton = txtVerifyButton;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTabOneBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentTabOneBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_tab_one, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTabOneBinding bind(View rootView) {
        int i = R.id.card_disabled;
        CardView cardViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.card_disabled);
        if (cardViewFindChildViewById != null) {
            i = R.id.card_enabled;
            CardView cardViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.card_enabled);
            if (cardViewFindChildViewById2 != null) {
                i = R.id.detail_name;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.detail_name);
                if (relativeLayout != null) {
                    i = R.id.elector_name_editv1;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.elector_name_editv1);
                    if (linearLayout != null) {
                        i = R.id.electorNameEnable;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorNameEnable);
                        if (textView != null) {
                            i = R.id.electorNameEnablev1;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorNameEnablev1);
                            if (textView2 != null) {
                                i = R.id.electorNameTitle;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorNameTitle);
                                if (textView3 != null) {
                                    i = R.id.electorNameTitlev1;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.electorNameTitlev1);
                                    if (textView4 != null) {
                                        i = R.id.header_title;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.header_title);
                                        if (textView5 != null) {
                                            i = R.id.headertitleaedit;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.headertitleaedit);
                                            if (textView6 != null) {
                                                i = R.id.include_current_details;
                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.include_current_details);
                                                if (viewFindChildViewById != null) {
                                                    CurrentElectorDetailsBinding currentElectorDetailsBindingBind = CurrentElectorDetailsBinding.bind(viewFindChildViewById);
                                                    i = R.id.iv_edit;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.iv_edit);
                                                    if (textView7 != null) {
                                                        i = R.id.lable_state;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.lable_state);
                                                        if (textView8 != null) {
                                                            i = R.id.layoutVerifyDetails;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layoutVerifyDetails);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.lv_current_details;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_current_details);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.lv_vernacular_name;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lv_vernacular_name);
                                                                    if (linearLayout4 != null) {
                                                                        i = R.id.matchingLayout;
                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.matchingLayout);
                                                                        if (linearLayout5 != null) {
                                                                            i = R.id.oldAcNo;
                                                                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.oldAcNo);
                                                                            if (spinner != null) {
                                                                                i = R.id.oldPartNo;
                                                                                Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(rootView, R.id.oldPartNo);
                                                                                if (spinner2 != null) {
                                                                                    i = R.id.oldPslNo;
                                                                                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.oldPslNo);
                                                                                    if (editText != null) {
                                                                                        i = R.id.oldStateSpinner;
                                                                                        Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(rootView, R.id.oldStateSpinner);
                                                                                        if (spinner3 != null) {
                                                                                            i = R.id.progressBar;
                                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                                                                            if (progressBar != null) {
                                                                                                i = R.id.relative_name_v1;
                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.relative_name_v1);
                                                                                                if (linearLayout6 != null) {
                                                                                                    i = R.id.releative_name_editv1;
                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.releative_name_editv1);
                                                                                                    if (linearLayout7 != null) {
                                                                                                        i = R.id.rv_mapping;
                                                                                                        RecyclerView recyclerViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.rv_mapping);
                                                                                                        if (recyclerViewFindChildViewById != null) {
                                                                                                            i = R.id.search_by_ac_ll;
                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.search_by_ac_ll);
                                                                                                            if (linearLayout8 != null) {
                                                                                                                i = R.id.speak;
                                                                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speak);
                                                                                                                if (imageView != null) {
                                                                                                                    i = R.id.submitButtonBlo;
                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.submitButtonBlo);
                                                                                                                    if (textView9 != null) {
                                                                                                                        i = R.id.tv_ac_name;
                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_ac_name);
                                                                                                                        if (textView10 != null) {
                                                                                                                            i = R.id.tvDetails;
                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvDetails);
                                                                                                                            if (textView11 != null) {
                                                                                                                                i = R.id.tv_disclamier_sir;
                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_disclamier_sir);
                                                                                                                                if (textView12 != null) {
                                                                                                                                    i = R.id.tv_district_name;
                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_district_name);
                                                                                                                                    if (textView13 != null) {
                                                                                                                                        i = R.id.tv_elector_name;
                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_name);
                                                                                                                                        if (textView14 != null) {
                                                                                                                                            i = R.id.tv_elector_name_edit;
                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_name_edit);
                                                                                                                                            if (textView15 != null) {
                                                                                                                                                i = R.id.tv_elector_name_editv1;
                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_name_editv1);
                                                                                                                                                if (textView16 != null) {
                                                                                                                                                    i = R.id.tv_elector_namev1;
                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_elector_namev1);
                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                        i = R.id.tvLeftName;
                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvLeftName);
                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                            i = R.id.tv_old_age;
                                                                                                                                                            TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_old_age);
                                                                                                                                                            if (textView19 != null) {
                                                                                                                                                                i = R.id.tv_old_epic;
                                                                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_old_epic);
                                                                                                                                                                if (textView20 != null) {
                                                                                                                                                                    i = R.id.tv_part_name;
                                                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_part_name);
                                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                                        i = R.id.tv_record_count;
                                                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_record_count);
                                                                                                                                                                        if (textView22 != null) {
                                                                                                                                                                            i = R.id.tv_relative_name;
                                                                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relative_name);
                                                                                                                                                                            if (textView23 != null) {
                                                                                                                                                                                i = R.id.tv_relative_namev1;
                                                                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relative_namev1);
                                                                                                                                                                                if (textView24 != null) {
                                                                                                                                                                                    i = R.id.tv_relative_type;
                                                                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_relative_type);
                                                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                                                        i = R.id.tv_releative_name_edit;
                                                                                                                                                                                        TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_releative_name_edit);
                                                                                                                                                                                        if (textView26 != null) {
                                                                                                                                                                                            i = R.id.tv_releative_name_editv1;
                                                                                                                                                                                            TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_releative_name_editv1);
                                                                                                                                                                                            if (textView27 != null) {
                                                                                                                                                                                                i = R.id.tv_releative_type_edit;
                                                                                                                                                                                                TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_releative_type_edit);
                                                                                                                                                                                                if (textView28 != null) {
                                                                                                                                                                                                    i = R.id.tvRightName;
                                                                                                                                                                                                    TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvRightName);
                                                                                                                                                                                                    if (textView29 != null) {
                                                                                                                                                                                                        i = R.id.tv_section_no;
                                                                                                                                                                                                        TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_section_no);
                                                                                                                                                                                                        if (textView30 != null) {
                                                                                                                                                                                                            i = R.id.tv_serial_name;
                                                                                                                                                                                                            TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_serial_name);
                                                                                                                                                                                                            if (textView31 != null) {
                                                                                                                                                                                                                i = R.id.tv_state_name;
                                                                                                                                                                                                                TextView textView32 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_state_name);
                                                                                                                                                                                                                if (textView32 != null) {
                                                                                                                                                                                                                    i = R.id.txtVerifyButton;
                                                                                                                                                                                                                    TextView textView33 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtVerifyButton);
                                                                                                                                                                                                                    if (textView33 != null) {
                                                                                                                                                                                                                        return new FragmentTabOneBinding((LinearLayout) rootView, cardViewFindChildViewById, cardViewFindChildViewById2, relativeLayout, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, currentElectorDetailsBindingBind, textView7, textView8, linearLayout2, linearLayout3, linearLayout4, linearLayout5, spinner, spinner2, editText, spinner3, progressBar, linearLayout6, linearLayout7, recyclerViewFindChildViewById, linearLayout8, imageView, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30, textView31, textView32, textView33);
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
