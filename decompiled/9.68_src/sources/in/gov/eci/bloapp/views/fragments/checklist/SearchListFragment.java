package in.gov.eci.bloapp.views.fragments.checklist;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView;
import in.gov.eci.bloapp.databinding.BloFragmentSearchListBinding;
import in.gov.eci.bloapp.databinding.BloTotalListRvItemBinding;
import in.gov.eci.bloapp.model.app_model.TotalListModel;
import in.gov.eci.bloapp.utils.DateStringConverter;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.MyResponse;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.fragments.checklist.form6.Form6;
import in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class SearchListFragment extends Hilt_SearchListFragment {
    private FilterableRecyclerView adapter;
    AlertDialog alertDialog;
    private String asmblyNO;
    String atkBand;
    private BloFragmentSearchListBinding binding;
    private Date d1;
    private String email;
    private String epicNo;
    int formType;
    private ArrayList<TotalListModel> mSearchList;
    private String mobNo;
    private String name;
    private String partNo;
    private String referenceNo;
    String rtkBand;
    private ArrayList<TotalListModel> searchList;
    private String stateCode;
    public JsonArray checkListData = null;
    public String token = "";
    CommomUtility commonUtilClass = new CommomUtility();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String alertText = "Alert";
    String refNoText = "refNo";
    String nameText = "name";
    String formTypeText = "formType";
    String formProcessingIdText = "formProcessingId";
    String currentStatusidText = "currentStatusid";
    String currentStatusIdText = "currentStatusId";
    String epicNoText = "epicNo";
    String processMasterIdText = "processMasterId";
    String formProcessingDetailsIdText = "formProcessingDetailsId";
    String mobNoText = "mobNo";
    String photoText = "photo";
    String failedToReadText = "Failed to read";
    String unauthorizedText = "unauthorized";
    String unauthorizedText1 = "Bearer token is malformed!";
    String sessionTokenText = "Session token expired please Login";
    private String actionDate = "";
    String visitCountText = "visitCount";
    int visitCount = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentSearchListBinding.inflate(getLayoutInflater());
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        View viewFindViewById = requireActivity().findViewById(R.id.total_list_search);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        this.searchList = new ArrayList<>();
        this.mSearchList = new ArrayList<>();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.atkBand = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtkBand = SharedPref.getInstance(requireContext()).getRtknBnd();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        if (AadhaarAuthenticationFormFragment.isNetworkAvailable(requireContext())) {
            this.alertDialog.show();
            getSearchList();
        } else {
            Toast.makeText(requireContext(), "Please check network", 1).show();
        }
        initCLickListener();
        return this.binding.getRoot();
    }

    private void initCLickListener() {
        this.binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.SearchListFragment.1
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                SearchListFragment.this.adapter.getFilter().filter(newText);
                return false;
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.SearchListFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$0(View view) {
        requireActivity().getSupportFragmentManager().popBackStackImmediate();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.SearchListFragment$2, reason: invalid class name */
    class AnonymousClass2 implements FilterableRecyclerView.FilterGenericRecyclerAdapterInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass2() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloTotalListRvItemBinding.inflate(SearchListFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
            String str;
            ((BloTotalListRvItemBinding) holder.binding).serialNoTv.setText("S.No: " + (holder.getAdapterPosition() + 1));
            ((BloTotalListRvItemBinding) holder.binding).nameTv.setText(((TotalListModel) SearchListFragment.this.mSearchList.get(position)).name);
            ((BloTotalListRvItemBinding) holder.binding).dateTv.setText(((TotalListModel) SearchListFragment.this.mSearchList.get(position)).date);
            final int i = ((TotalListModel) SearchListFragment.this.mSearchList.get(position)).formType;
            if (i == 1) {
                str = "Form6";
            } else if (i == 2) {
                str = "Form6A";
            } else if (i == 3) {
                str = "Form7";
            } else if (i == 9 || i == 10) {
                str = "Form8";
            } else if (i == 13) {
                str = "Form7 Overseas";
            } else if (i != 14) {
                str = "";
            } else {
                str = "Form8 Overseas";
            }
            ((BloTotalListRvItemBinding) holder.binding).formTv.setText(str);
            ((BloTotalListRvItemBinding) holder.binding).refNoTv2.setText(((TotalListModel) SearchListFragment.this.mSearchList.get(position)).refNo);
            ((BloTotalListRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.SearchListFragment$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(position, i, view);
                }
            });
            if (!TextUtils.isEmpty(((TotalListModel) SearchListFragment.this.mSearchList.get(position)).getIsExistingElector()) && ((TotalListModel) SearchListFragment.this.mSearchList.get(position)).getIsExistingElector().equalsIgnoreCase("Y") && !TextUtils.isEmpty(((TotalListModel) SearchListFragment.this.mSearchList.get(position)).getUncollectableSir()) && ((TotalListModel) SearchListFragment.this.mSearchList.get(position)).getUncollectableSir().equalsIgnoreCase("Y")) {
                ((BloTotalListRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#FDE2F5"));
                ((BloTotalListRvItemBinding) holder.binding).existingElectorTv.setVisibility(0);
                ((BloTotalListRvItemBinding) holder.binding).existingElectorTv2.setVisibility(0);
            } else {
                ((BloTotalListRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#E9E9E9"));
                ((BloTotalListRvItemBinding) holder.binding).existingElectorTv.setVisibility(8);
                ((BloTotalListRvItemBinding) holder.binding).existingElectorTv2.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(final int i, final int i2, View view) {
            final int formProcessingDetailsId = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).getFormProcessingDetailsId();
            if (SearchListFragment.this.alertDialog != null) {
                SearchListFragment.this.alertDialog.show();
            }
            SearchListFragment.this.commonUtilClass.getAeroRemarks(SearchListFragment.this.getContext(), formProcessingDetailsId, SearchListFragment.this.stateCode, SearchListFragment.this.atkBand, SearchListFragment.this.rtkBand, SearchListFragment.this.token, "blo", new MyResponse() { // from class: in.gov.eci.bloapp.views.fragments.checklist.SearchListFragment.2.1
                @Override // in.gov.eci.bloapp.views.MyResponse
                public void onCallback(JsonArray value, String message) {
                    if (SearchListFragment.this.alertDialog != null && SearchListFragment.this.alertDialog.isShowing()) {
                        SearchListFragment.this.alertDialog.dismiss();
                    }
                    if (value == null) {
                        SearchListFragment.this.showDialog(SearchListFragment.this.alertText, message.replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        return;
                    }
                    if (value.size() > 0) {
                        JsonArray asJsonArray = value.get(0).getAsJsonArray();
                        JsonArray asJsonArray2 = value.get(1).getAsJsonArray();
                        JsonArray asJsonArray3 = value.get(2).getAsJsonArray();
                        String strReplace = !asJsonArray.isEmpty() ? String.valueOf(asJsonArray.get(0).getAsJsonObject().get("assignBloAeroRemark")).replace(RegexMatcher.JSON_STRING_REGEX, "") : "null";
                        String strReplace2 = !asJsonArray2.isEmpty() ? String.valueOf(asJsonArray2.get(0).getAsJsonObject().get("reInitiateRemark")).replace(RegexMatcher.JSON_STRING_REGEX, "") : "null";
                        if (!asJsonArray3.isEmpty()) {
                            SearchListFragment.this.actionDate = String.valueOf(asJsonArray3.get(asJsonArray3.size() - 1).getAsJsonObject().get("actionDate")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        if (strReplace.equals("null") && strReplace2.equals("null")) {
                            SearchListFragment.this.name = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).name;
                            SearchListFragment.this.referenceNo = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).refNo;
                            SearchListFragment.this.formType = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).formType;
                            SearchListFragment.this.epicNo = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).epicNo;
                            SearchListFragment.this.mobNo = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).mobNo;
                            SearchListFragment.this.email = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).email;
                            if (!TextUtils.isEmpty(message) && !TextUtils.equals(message, "null")) {
                                SearchListFragment.this.visitCount = Integer.parseInt(message);
                            } else {
                                SearchListFragment.this.visitCount = 0;
                            }
                            int currentStatusId = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).getCurrentStatusId();
                            Bundle bundle = new Bundle();
                            bundle.putString("Flag", "NEW");
                            bundle.putString(SearchListFragment.this.nameText, SearchListFragment.this.name);
                            bundle.putString(SearchListFragment.this.refNoText, SearchListFragment.this.referenceNo);
                            bundle.putInt(SearchListFragment.this.formTypeText, SearchListFragment.this.formType);
                            bundle.putInt(SearchListFragment.this.formProcessingIdText, formProcessingDetailsId);
                            bundle.putInt(SearchListFragment.this.processMasterIdText, i2);
                            bundle.putInt(SearchListFragment.this.currentStatusidText, currentStatusId);
                            bundle.putString(SearchListFragment.this.epicNoText, SearchListFragment.this.epicNo);
                            bundle.putString(SearchListFragment.this.mobNoText, SearchListFragment.this.mobNo);
                            bundle.putString(SearchListFragment.this.photoText, SearchListFragment.this.email);
                            bundle.putInt(SearchListFragment.this.visitCountText, SearchListFragment.this.visitCount);
                            bundle.putString("actionDate", SearchListFragment.this.actionDate);
                            if (SearchListFragment.this.formType == 3) {
                                ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = new ApplicantDetailsForm7Fragment();
                                applicantDetailsForm7Fragment.setArguments(bundle);
                                SearchListFragment.this.openFragment(applicantDetailsForm7Fragment);
                                return;
                            }
                            if (SearchListFragment.this.formType == 9 || SearchListFragment.this.formType == 10) {
                                FormsDetailsFragment formsDetailsFragment = new FormsDetailsFragment();
                                formsDetailsFragment.setArguments(bundle);
                                SearchListFragment.this.openFragment(formsDetailsFragment);
                                return;
                            }
                            if (SearchListFragment.this.formType == 2) {
                                ApplicantDetailsFragment applicantDetailsFragment = new ApplicantDetailsFragment();
                                applicantDetailsFragment.setArguments(bundle);
                                SearchListFragment.this.openFragment(applicantDetailsFragment);
                                return;
                            }
                            if (SearchListFragment.this.formType == 1) {
                                Form6 form6 = new Form6();
                                form6.setArguments(bundle);
                                SearchListFragment.this.openFragment(form6);
                                return;
                            } else if (SearchListFragment.this.formType == 13) {
                                ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = new ApplicantDetailsForm7OverseasFragment();
                                applicantDetailsForm7OverseasFragment.setArguments(bundle);
                                SearchListFragment.this.openFragment(applicantDetailsForm7OverseasFragment);
                                return;
                            } else {
                                if (SearchListFragment.this.formType == 14) {
                                    FormsDetailsOverseasFragment formsDetailsOverseasFragment = new FormsDetailsOverseasFragment();
                                    formsDetailsOverseasFragment.setArguments(bundle);
                                    SearchListFragment.this.openFragment(formsDetailsOverseasFragment);
                                    return;
                                }
                                return;
                            }
                        }
                        SearchListFragment.this.showBottomSheetDialog(strReplace, strReplace2, SearchListFragment.this.mSearchList, i, message);
                        return;
                    }
                    SearchListFragment.this.name = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).name;
                    SearchListFragment.this.referenceNo = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).refNo;
                    SearchListFragment.this.formType = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).formType;
                    SearchListFragment.this.epicNo = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).epicNo;
                    SearchListFragment.this.mobNo = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).mobNo;
                    SearchListFragment.this.email = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).email;
                    if (!TextUtils.isEmpty(message) && !TextUtils.equals(message, "null")) {
                        SearchListFragment.this.visitCount = Integer.parseInt(message);
                    } else {
                        SearchListFragment.this.visitCount = 0;
                    }
                    int currentStatusId2 = ((TotalListModel) SearchListFragment.this.mSearchList.get(i)).getCurrentStatusId();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("Flag", "NEW");
                    bundle2.putString(SearchListFragment.this.nameText, SearchListFragment.this.name);
                    bundle2.putString(SearchListFragment.this.refNoText, SearchListFragment.this.referenceNo);
                    bundle2.putInt(SearchListFragment.this.formTypeText, SearchListFragment.this.formType);
                    bundle2.putInt(SearchListFragment.this.formProcessingIdText, formProcessingDetailsId);
                    bundle2.putInt(SearchListFragment.this.processMasterIdText, i2);
                    bundle2.putInt(SearchListFragment.this.currentStatusidText, currentStatusId2);
                    bundle2.putString(SearchListFragment.this.epicNoText, SearchListFragment.this.epicNo);
                    bundle2.putString(SearchListFragment.this.mobNoText, SearchListFragment.this.mobNo);
                    bundle2.putString(SearchListFragment.this.photoText, SearchListFragment.this.email);
                    bundle2.putInt(SearchListFragment.this.visitCountText, SearchListFragment.this.visitCount);
                    bundle2.putString("actionDate", SearchListFragment.this.actionDate);
                    if (SearchListFragment.this.formType == 3) {
                        ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment2 = new ApplicantDetailsForm7Fragment();
                        applicantDetailsForm7Fragment2.setArguments(bundle2);
                        SearchListFragment.this.openFragment(applicantDetailsForm7Fragment2);
                        return;
                    }
                    if (SearchListFragment.this.formType == 9 || SearchListFragment.this.formType == 10) {
                        FormsDetailsFragment formsDetailsFragment2 = new FormsDetailsFragment();
                        formsDetailsFragment2.setArguments(bundle2);
                        SearchListFragment.this.openFragment(formsDetailsFragment2);
                        return;
                    }
                    if (SearchListFragment.this.formType == 2) {
                        ApplicantDetailsFragment applicantDetailsFragment2 = new ApplicantDetailsFragment();
                        applicantDetailsFragment2.setArguments(bundle2);
                        SearchListFragment.this.openFragment(applicantDetailsFragment2);
                        return;
                    }
                    if (SearchListFragment.this.formType == 1) {
                        Form6 form7 = new Form6();
                        form7.setArguments(bundle2);
                        SearchListFragment.this.openFragment(form7);
                    } else if (SearchListFragment.this.formType == 13) {
                        ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment2 = new ApplicantDetailsForm7OverseasFragment();
                        applicantDetailsForm7OverseasFragment2.setArguments(bundle2);
                        SearchListFragment.this.openFragment(applicantDetailsForm7OverseasFragment2);
                    } else if (SearchListFragment.this.formType == 14) {
                        FormsDetailsOverseasFragment formsDetailsOverseasFragment2 = new FormsDetailsOverseasFragment();
                        formsDetailsOverseasFragment2.setArguments(bundle2);
                        SearchListFragment.this.openFragment(formsDetailsOverseasFragment2);
                    }
                }
            });
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemCount() {
            return SearchListFragment.this.mSearchList.size();
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public Filter getFilter() {
            return new Filter() { // from class: in.gov.eci.bloapp.views.fragments.checklist.SearchListFragment.2.2
                @Override // android.widget.Filter
                protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                    String strValueOf = String.valueOf(charSequence);
                    if (strValueOf.length() == 0) {
                        SearchListFragment.this.mSearchList = SearchListFragment.this.searchList;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (TotalListModel totalListModel : SearchListFragment.this.mSearchList) {
                            if (totalListModel.name.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                arrayList.add(totalListModel);
                            } else if (totalListModel.refNo.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                arrayList.add(totalListModel);
                            } else if (totalListModel.date.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                arrayList.add(totalListModel);
                            }
                        }
                        SearchListFragment.this.mSearchList = arrayList;
                    }
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    filterResults.values = SearchListFragment.this.mSearchList;
                    return filterResults;
                }

                @Override // android.widget.Filter
                protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    SearchListFragment.this.adapter.notifyDataSetChanged();
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRecyclerViewAdapter() {
        this.mSearchList = this.searchList;
        this.adapter = new FilterableRecyclerView(new AnonymousClass2());
        this.binding.searchListRv.setLayoutManager(new GridLayoutManager(getContext(), 1, 1, false));
        this.binding.searchListRv.setAdapter(this.adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBottomSheetDialog(String remarks, String remarksEro, final ArrayList<TotalListModel> mSearchList, final int position, final String message) {
        String str;
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.blo_aero_remark_bottom_sheet_layout);
        Button button = (Button) dialog.findViewById(R.id.btn_Proceed);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.aeroRemarksLayout);
        LinearLayout linearLayout2 = (LinearLayout) dialog.findViewById(R.id.eroRemarksLayout);
        TextView textView = (TextView) dialog.findViewById(R.id.remarkText);
        TextView textView2 = (TextView) dialog.findViewById(R.id.ero_remarkText);
        TextView textView3 = (TextView) dialog.findViewById(R.id.referenceNumberText);
        textView.setText(remarks);
        textView2.setText(remarksEro);
        textView3.setText(mSearchList.get(position).refNo);
        final int i = mSearchList.get(position).formType;
        if (remarks.equals("null")) {
            linearLayout.setVisibility(8);
        }
        if (remarksEro.equals("null")) {
            linearLayout2.setVisibility(8);
        }
        if (i == 1) {
            str = "View Form 6";
        } else if (i == 2) {
            str = "View Form 6A";
        } else if (i == 3) {
            str = "View Form 7";
        } else if (i == 9 || i == 10) {
            str = "View Form 8";
        } else if (i == 13) {
            str = "View Form 7 Overseas";
        } else if (i != 14) {
            str = "";
        } else {
            str = "View Form 8 Overseas";
        }
        button.setText(str);
        dialog.show();
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.SearchListFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showBottomSheetDialog$1(mSearchList, position, message, i, dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBottomSheetDialog$1(ArrayList arrayList, int i, String str, int i2, Dialog dialog, View view) {
        this.name = ((TotalListModel) arrayList.get(i)).name;
        this.referenceNo = ((TotalListModel) arrayList.get(i)).refNo;
        this.formType = ((TotalListModel) arrayList.get(i)).formType;
        this.epicNo = ((TotalListModel) arrayList.get(i)).epicNo;
        this.mobNo = ((TotalListModel) arrayList.get(i)).mobNo;
        this.email = ((TotalListModel) arrayList.get(i)).email;
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "null")) {
            this.visitCount = Integer.parseInt(str);
        } else {
            this.visitCount = 0;
        }
        int formProcessingDetailsId = ((TotalListModel) arrayList.get(i)).getFormProcessingDetailsId();
        int currentStatusId = ((TotalListModel) arrayList.get(i)).getCurrentStatusId();
        Bundle bundle = new Bundle();
        bundle.putString("Flag", "NEW");
        bundle.putString(this.nameText, this.name);
        bundle.putString(this.refNoText, this.referenceNo);
        bundle.putInt(this.formTypeText, this.formType);
        bundle.putInt(this.formProcessingIdText, formProcessingDetailsId);
        bundle.putInt(this.processMasterIdText, i2);
        bundle.putInt(this.currentStatusidText, currentStatusId);
        bundle.putString(this.epicNoText, this.epicNo);
        bundle.putString(this.mobNoText, this.mobNo);
        bundle.putString(this.photoText, this.email);
        bundle.putInt(this.visitCountText, this.visitCount);
        bundle.putString("actionDate", this.actionDate);
        int i3 = this.formType;
        if (i3 == 3) {
            ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = new ApplicantDetailsForm7Fragment();
            applicantDetailsForm7Fragment.setArguments(bundle);
            openFragment(applicantDetailsForm7Fragment);
        } else if (i3 == 9 || i3 == 10) {
            FormsDetailsFragment formsDetailsFragment = new FormsDetailsFragment();
            formsDetailsFragment.setArguments(bundle);
            openFragment(formsDetailsFragment);
        } else if (i3 == 2) {
            ApplicantDetailsFragment applicantDetailsFragment = new ApplicantDetailsFragment();
            applicantDetailsFragment.setArguments(bundle);
            openFragment(applicantDetailsFragment);
        } else if (i3 == 1) {
            Form6 form6 = new Form6();
            form6.setArguments(bundle);
            openFragment(form6);
        } else if (i3 == 13) {
            ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = new ApplicantDetailsForm7OverseasFragment();
            applicantDetailsForm7OverseasFragment.setArguments(bundle);
            openFragment(applicantDetailsForm7OverseasFragment);
        } else if (i3 == 14) {
            FormsDetailsOverseasFragment formsDetailsOverseasFragment = new FormsDetailsOverseasFragment();
            formsDetailsOverseasFragment.setArguments(bundle);
            openFragment(formsDetailsOverseasFragment);
        }
        dialog.dismiss();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.SearchListFragment$3, reason: invalid class name */
    class AnonymousClass3 implements MyResponse {
        AnonymousClass3() {
        }

        @Override // in.gov.eci.bloapp.views.MyResponse
        public void onCallback(JsonArray value, final String message) {
            if (value != null) {
                SearchListFragment.this.checkListData = value;
                System.out.println("Check list data in total" + SearchListFragment.this.checkListData);
                try {
                    if (value.isEmpty()) {
                        SearchListFragment.this.alertDialog.dismiss();
                        SearchListFragment searchListFragment = SearchListFragment.this;
                        searchListFragment.showDialog(searchListFragment.alertText, "No data found");
                        return;
                    }
                    for (int i = 0; i < SearchListFragment.this.checkListData.size(); i++) {
                        JsonObject asJsonObject = SearchListFragment.this.checkListData.get(i).getAsJsonObject();
                        String strReplaceAll = String.valueOf(asJsonObject.get("applicantName")).replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                        String strReplaceAll2 = String.valueOf(asJsonObject.get("formRefNumber")).replaceAll("^\"|\"$", "");
                        String strReplaceAll3 = String.valueOf(asJsonObject.get("submissionDate")).replaceAll("^\"|\"$", "");
                        String strReplaceAll4 = String.valueOf(asJsonObject.get("isExistingElector")).replaceAll("^\"|\"$", "");
                        String strReplaceAll5 = String.valueOf(asJsonObject.get("uncollectableSir")).replaceAll("^\"|\"$", "");
                        if (!strReplaceAll3.equals("null")) {
                            SearchListFragment searchListFragment2 = SearchListFragment.this;
                            searchListFragment2.d1 = searchListFragment2.sdf.parse(strReplaceAll3);
                            System.out.println("Print D1" + SearchListFragment.this.d1);
                            SearchListFragment.this.searchList.add(new TotalListModel(strReplaceAll, strReplaceAll2, "", "", "", DateStringConverter.toDdMmYy(strReplaceAll3), "", "", Integer.parseInt(String.valueOf(asJsonObject.get("processMasterId"))), Integer.parseInt(String.valueOf(asJsonObject.get("formProcessingDetailsId"))), Integer.parseInt(String.valueOf(asJsonObject.get(SearchListFragment.this.currentStatusIdText))), "", "", strReplaceAll4, strReplaceAll5));
                        }
                    }
                    if (SearchListFragment.this.alertDialog != null && SearchListFragment.this.alertDialog.isShowing()) {
                        SearchListFragment.this.alertDialog.dismiss();
                    }
                    Logger.d("Total list", SearchListFragment.this.searchList.toString());
                    SearchListFragment.this.initRecyclerViewAdapter();
                    return;
                } catch (Exception e) {
                    Logger.e("SearchList", e.getMessage());
                    Logger.d("error", "Failed to read");
                    return;
                }
            }
            SearchListFragment.this.alertDialog.dismiss();
            if (message.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(SearchListFragment.this.unauthorizedText) || message.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(SearchListFragment.this.unauthorizedText1)) {
                SearchListFragment.this.commonUtilClass.getRefreshToken(SearchListFragment.this.requireContext(), SharedPref.getInstance(SearchListFragment.this.requireContext()).getRefreshToken(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.SearchListFragment$3$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str, String str2) {
                        this.f$0.lambda$onCallback$1(message, i2, str, str2);
                    }
                });
            } else {
                SearchListFragment searchListFragment3 = SearchListFragment.this;
                searchListFragment3.showDialog(searchListFragment3.alertText, message.replace(RegexMatcher.JSON_STRING_REGEX, ""));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCallback$1(String str, int i, String str2, String str3) {
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                SearchListFragment.this.commonUtilClass.showMessageOK(SearchListFragment.this.requireContext(), SearchListFragment.this.sessionTokenText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.SearchListFragment$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onCallback$0(dialogInterface, i2);
                    }
                });
                return;
            }
            System.out.println("zxnbchdbvfhvb ---> else refresh" + i + StringUtils.SPACE + str2 + StringUtils.SPACE);
            SearchListFragment.this.token = "Bearer " + str2;
            SharedPref.getInstance(SearchListFragment.this.requireContext()).setRefreshToken(str);
            SharedPref.getInstance(SearchListFragment.this.requireContext()).setToken("Bearer " + str2);
            SearchListFragment.this.getSearchList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCallback$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SearchListFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SearchListFragment.this.requireContext()).setLocaleBool(false);
            SearchListFragment.this.startActivity(new Intent((Context) SearchListFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSearchList() {
        this.commonUtilClass.getCheckList1(getContext(), this.stateCode, this.atkBand, this.rtkBand, Integer.parseInt(this.asmblyNO), Integer.parseInt(this.partNo), this.token, "blo", new AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String title, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.SearchListFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.main, fragment, "Check List");
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    private String getDisplayDate(Date submitDate) {
        SimpleDateFormat simpleDateFormat;
        String str = new SimpleDateFormat("d").format(submitDate);
        if (str.endsWith("1") && !str.endsWith("11")) {
            simpleDateFormat = new SimpleDateFormat("d'st' MMM yyyy");
        } else if (str.endsWith("2") && !str.endsWith("12")) {
            simpleDateFormat = new SimpleDateFormat("d'nd' MMM yyyy");
        } else if (str.endsWith("3") && !str.endsWith("13")) {
            simpleDateFormat = new SimpleDateFormat("d'rd' MMM yyyy");
        } else {
            simpleDateFormat = new SimpleDateFormat("d'th' MMM yyyy");
        }
        return simpleDateFormat.format(submitDate);
    }
}
