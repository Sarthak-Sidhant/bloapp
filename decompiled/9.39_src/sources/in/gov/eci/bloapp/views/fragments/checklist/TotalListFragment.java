package in.gov.eci.bloapp.views.fragments.checklist;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.databinding.BloFragmentTotalListBinding;
import in.gov.eci.bloapp.databinding.BloTotalListRvItemBinding;
import in.gov.eci.bloapp.model.app_model.TotalListModel;
import in.gov.eci.bloapp.utils.DateStringConverter;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.MyResponse;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.fragments.Forms8Respponse;
import in.gov.eci.bloapp.views.fragments.checklist.form6.Form6;
import in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class TotalListFragment extends Hilt_TotalListFragment {
    GenericRecyclerView adapter;
    AlertDialog alertDialog;
    String asmblyNO;
    String atkBand;
    BloFragmentTotalListBinding binding;
    String countcor;
    String countcor1;
    String countsor;
    String countsor1;
    Date d1;
    String email;
    String epicId;
    String epicNo;
    int formType;
    List<TotalListModel> last15List;
    List<TotalListModel> lastWeekList;
    String mobNo;
    String name;
    String partNo;
    String refDate;
    String referenceNo;
    String rtkBand;
    String stateCode;
    Date todayDate;
    List<TotalListModel> todayList;
    List<TotalListModel> totalList;
    String totalListFragment = "TOTAL LIST FRAGMENT";
    JsonArray chekListData = null;
    String token = "";
    CommomUtility commonUtilClass = new CommomUtility();
    Bundle bundle = new Bundle();
    Date dateNew = new Date();
    String actionDate = "";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    int totalForm6 = 0;
    int totalForm6A = 0;
    int totalForm6B = 0;
    int totalForm7 = 0;
    int totalForm8 = 0;
    int totalForm7O = 0;
    int totalForm8O = 0;
    String checkNetworkText = "Please check network";
    String totalListText = "Total list";
    String totalFormText = "Total no. of all Form: ";
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
    String EpicId = "epicid";
    String checkListText = "Check List";
    String shiftingOfResidenceText = "shiftingOfResidence";
    String shiftingText = "shifting ";
    String entriesCorrectionInErollText = "entriesCorrectionInEroll";
    String alertText = "Alert";
    String correctionText = "correction ";
    String wrongText = "Wrong data received from backend";
    String dataNotReceivedText = "Data Not Found";
    String noDataFoundText = "No data found";
    String applicantDetailsText = "Applicant Details";
    String checkListDataText = "Check list data in total";
    String formRefNumberText = "formRefNumber";
    String submissionDateText = "submissionDate";
    String errorText = "error";
    String failedToReadText = "Failed to read";
    String unauthorizedText = "unauthorized";
    String unauthorizedText1 = "Bearer token is malformed!";
    String sessionTokenText = "Session token expired please Login";
    String printD1 = "Print D1";
    String applicantNameText = "applicantName";
    String visitCountText = "visitCount";
    int visitCount = 0;
    String isExistingElector = null;
    String uncollectableSir = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentTotalListBinding.inflate(getLayoutInflater());
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.atkBand = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtkBand = SharedPref.getInstance(requireContext()).getRtknBnd();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        String str = this.sdf.format(this.dateNew);
        this.refDate = str;
        try {
            this.todayDate = this.sdf.parse(str);
        } catch (ParseException e) {
            Logger.e(this.totalListFragment, e.getMessage());
        }
        Logger.d("", "Print Current date" + this.todayDate);
        this.totalList = new ArrayList();
        this.todayList = new ArrayList();
        this.lastWeekList = new ArrayList();
        this.last15List = new ArrayList();
        this.binding.totalListSearch.setVisibility(0);
        if (AadhaarAuthenticationFormFragment.isNetworkAvailable(requireContext())) {
            this.alertDialog.show();
            getTotalList();
        } else {
            Toast.makeText(requireContext(), this.checkNetworkText, 1).show();
        }
        initRecyclerViewAdapter();
        initClickListener();
        return this.binding.getRoot();
    }

    private void initClickListener() {
        this.binding.totalListSearch.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
        this.binding.all.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
        this.binding.today.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$2(view);
            }
        });
        this.binding.lastWeek.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$3(view);
            }
        });
        this.binding.last15.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
        openFragment(new SearchListFragment(), "SearchList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        if (AadhaarAuthenticationFormFragment.isNetworkAvailable(requireContext())) {
            this.alertDialog.show();
            getTotalList();
        } else {
            Toast.makeText(requireContext(), this.checkNetworkText, 1).show();
        }
        this.adapter.notifyDataSetChanged();
        Logger.d(this.totalListText, this.totalList.toString());
        this.binding.all.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_selected));
        this.binding.today.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_unselected));
        this.binding.lastWeek.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_unselected));
        this.binding.last15.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_unselected));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$2(View view) {
        if (AadhaarAuthenticationFormFragment.isNetworkAvailable(requireContext())) {
            this.alertDialog.show();
            getTodayList();
        } else {
            Toast.makeText(requireContext(), this.checkNetworkText, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$3(View view) {
        if (AadhaarAuthenticationFormFragment.isNetworkAvailable(requireContext())) {
            this.alertDialog.show();
            getLastWeekList();
        } else {
            Toast.makeText(requireContext(), this.checkNetworkText, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$4(View view) {
        if (AadhaarAuthenticationFormFragment.isNetworkAvailable(requireContext())) {
            this.alertDialog.show();
            getLast15List();
        } else {
            Toast.makeText(requireContext(), this.checkNetworkText, 1).show();
        }
    }

    public void checkdelay(List<TotalListModel> currentList) {
        this.totalList.clear();
        this.totalList.addAll(currentList);
        this.adapter.notifyDataSetChanged();
        Logger.d("Today list", this.todayList.toString());
        this.binding.today.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_selected));
        this.binding.all.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_unselected));
        this.binding.lastWeek.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_unselected));
        this.binding.last15.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_unselected));
    }

    public void checkdelay1(List<TotalListModel> weeklylist) {
        this.totalList.clear();
        this.totalList.addAll(weeklylist);
        this.adapter.notifyDataSetChanged();
        Logger.d("Last week list", this.lastWeekList.toString());
        this.binding.lastWeek.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_selected));
        this.binding.all.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_unselected));
        this.binding.today.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_unselected));
        this.binding.last15.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_unselected));
    }

    public void checkdelay2(List<TotalListModel> lastLlist) {
        this.totalList.clear();
        this.totalList.addAll(lastLlist);
        this.adapter.notifyDataSetChanged();
        Logger.d("Last 15 days list", this.last15List.toString());
        this.binding.last15.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_selected));
        this.binding.all.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_unselected));
        this.binding.today.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_unselected));
        this.binding.lastWeek.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.blo_all_unselected));
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkdelay2$5();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkdelay2$5() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1, reason: invalid class name */
    class AnonymousClass1 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass1() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloTotalListRvItemBinding.inflate(TotalListFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
            String str;
            ((BloTotalListRvItemBinding) holder.binding).serialNoTv.setText("S.No: " + (holder.getAdapterPosition() + 1));
            ((BloTotalListRvItemBinding) holder.binding).nameTv.setText(TotalListFragment.this.totalList.get(position).name);
            ((BloTotalListRvItemBinding) holder.binding).dateTv.setText(TotalListFragment.this.totalList.get(position).date);
            final int i = TotalListFragment.this.totalList.get(position).formType;
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
            ((BloTotalListRvItemBinding) holder.binding).refNoTv2.setText(TotalListFragment.this.totalList.get(position).refNo);
            ((BloTotalListRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$14(position, i, view);
                }
            });
            if (!TextUtils.isEmpty(TotalListFragment.this.totalList.get(position).getIsExistingElector()) && TotalListFragment.this.totalList.get(position).getIsExistingElector().equalsIgnoreCase("Y") && !TextUtils.isEmpty(TotalListFragment.this.totalList.get(position).getUncollectableSir()) && TotalListFragment.this.totalList.get(position).getUncollectableSir().equalsIgnoreCase("Y")) {
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
        public /* synthetic */ void lambda$onBindViewHolder$14(final int i, final int i2, View view) {
            final int formProcessingDetailsId = TotalListFragment.this.totalList.get(i).getFormProcessingDetailsId();
            if (TotalListFragment.this.alertDialog != null) {
                TotalListFragment.this.alertDialog.show();
            }
            TotalListFragment.this.commonUtilClass.getAeroRemarks(TotalListFragment.this.getContext(), formProcessingDetailsId, TotalListFragment.this.stateCode, TotalListFragment.this.atkBand, TotalListFragment.this.rtkBand, TotalListFragment.this.token, "blo", new MyResponse() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda12
                @Override // in.gov.eci.bloapp.views.MyResponse
                public final void onCallback(JsonArray jsonArray, String str) {
                    this.f$0.lambda$onBindViewHolder$13(i, formProcessingDetailsId, i2, jsonArray, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$13(final int i, final int i2, final int i3, final JsonArray jsonArray, final String str) {
            if (TotalListFragment.this.alertDialog != null && TotalListFragment.this.alertDialog.isShowing()) {
                TotalListFragment.this.alertDialog.dismiss();
            }
            if (jsonArray != null) {
                if (jsonArray.size() > 0) {
                    JsonArray asJsonArray = jsonArray.get(0).getAsJsonArray();
                    JsonArray asJsonArray2 = jsonArray.get(1).getAsJsonArray();
                    JsonArray asJsonArray3 = jsonArray.get(2).getAsJsonArray();
                    String strReplace = !asJsonArray.isEmpty() ? String.valueOf(asJsonArray.get(0).getAsJsonObject().get("assignBloAeroRemark")).replace(RegexMatcher.JSON_STRING_REGEX, "") : "null";
                    String strReplace2 = !asJsonArray2.isEmpty() ? String.valueOf(asJsonArray2.get(0).getAsJsonObject().get("reInitiateRemark")).replace(RegexMatcher.JSON_STRING_REGEX, "") : "null";
                    if (!asJsonArray3.isEmpty()) {
                        TotalListFragment.this.actionDate = String.valueOf(asJsonArray3.get(asJsonArray3.size() - 1).getAsJsonObject().get("actionDate")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    }
                    if (strReplace.equals("null") && strReplace2.equals("null")) {
                        TotalListFragment totalListFragment = TotalListFragment.this;
                        totalListFragment.name = totalListFragment.totalList.get(i).name;
                        TotalListFragment totalListFragment2 = TotalListFragment.this;
                        totalListFragment2.referenceNo = totalListFragment2.totalList.get(i).refNo;
                        TotalListFragment totalListFragment3 = TotalListFragment.this;
                        totalListFragment3.formType = totalListFragment3.totalList.get(i).formType;
                        TotalListFragment totalListFragment4 = TotalListFragment.this;
                        totalListFragment4.epicNo = totalListFragment4.totalList.get(i).epicNo;
                        TotalListFragment totalListFragment5 = TotalListFragment.this;
                        totalListFragment5.mobNo = totalListFragment5.totalList.get(i).mobNo;
                        TotalListFragment totalListFragment6 = TotalListFragment.this;
                        totalListFragment6.email = totalListFragment6.totalList.get(i).email;
                        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "null")) {
                            TotalListFragment.this.visitCount = Integer.parseInt(str);
                        } else {
                            TotalListFragment.this.visitCount = 0;
                        }
                        int currentStatusId = TotalListFragment.this.totalList.get(i).getCurrentStatusId();
                        final Bundle bundle = new Bundle();
                        bundle.putString("Flag", "NEW");
                        bundle.putString(TotalListFragment.this.nameText, TotalListFragment.this.name);
                        bundle.putString(TotalListFragment.this.refNoText, TotalListFragment.this.referenceNo);
                        bundle.putInt(TotalListFragment.this.formTypeText, TotalListFragment.this.formType);
                        bundle.putInt(TotalListFragment.this.formProcessingIdText, i2);
                        bundle.putInt(TotalListFragment.this.currentStatusidText, currentStatusId);
                        bundle.putString(TotalListFragment.this.epicNoText, TotalListFragment.this.epicNo);
                        bundle.putInt(TotalListFragment.this.processMasterIdText, i3);
                        bundle.putString(TotalListFragment.this.mobNoText, TotalListFragment.this.mobNo);
                        bundle.putString(TotalListFragment.this.photoText, TotalListFragment.this.email);
                        bundle.putInt(TotalListFragment.this.visitCountText, TotalListFragment.this.visitCount);
                        bundle.putString("actionDate", TotalListFragment.this.actionDate);
                        if (TotalListFragment.this.formType == 3) {
                            ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = new ApplicantDetailsForm7Fragment();
                            applicantDetailsForm7Fragment.setArguments(bundle);
                            TotalListFragment totalListFragment7 = TotalListFragment.this;
                            totalListFragment7.openFragment(applicantDetailsForm7Fragment, totalListFragment7.checkListText);
                            return;
                        }
                        if (TotalListFragment.this.formType == 9 || TotalListFragment.this.formType == 10) {
                            TotalListFragment.this.alertDialog.show();
                            TotalListFragment.this.commonUtilClass.getchecklistdetailsform8(TotalListFragment.this.getContext(), TotalListFragment.this.stateCode, TotalListFragment.this.atkBand, TotalListFragment.this.rtkBand, TotalListFragment.this.referenceNo, TotalListFragment.this.token, new C00371(bundle));
                            return;
                        }
                        if (TotalListFragment.this.formType == 14) {
                            TotalListFragment.this.alertDialog.show();
                            TotalListFragment.this.commonUtilClass.getchecklistdetailsform8O(TotalListFragment.this.getContext(), TotalListFragment.this.stateCode, TotalListFragment.this.atkBand, TotalListFragment.this.rtkBand, TotalListFragment.this.referenceNo, TotalListFragment.this.token);
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda8
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onBindViewHolder$1(bundle);
                                }
                            }, 100L);
                            return;
                        }
                        if (TotalListFragment.this.formType == 2) {
                            ApplicantDetailsFragment applicantDetailsFragment = new ApplicantDetailsFragment();
                            applicantDetailsFragment.setArguments(bundle);
                            TotalListFragment totalListFragment8 = TotalListFragment.this;
                            totalListFragment8.openFragment(applicantDetailsFragment, totalListFragment8.checkListText);
                            return;
                        }
                        if (TotalListFragment.this.formType == 13) {
                            ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = new ApplicantDetailsForm7OverseasFragment();
                            applicantDetailsForm7OverseasFragment.setArguments(bundle);
                            TotalListFragment totalListFragment9 = TotalListFragment.this;
                            totalListFragment9.openFragment(applicantDetailsForm7OverseasFragment, totalListFragment9.checkListText);
                            return;
                        }
                        if (TotalListFragment.this.formType == 1) {
                            Form6 form6 = new Form6();
                            form6.setArguments(bundle);
                            TotalListFragment totalListFragment10 = TotalListFragment.this;
                            totalListFragment10.openFragment(form6, totalListFragment10.checkListText);
                            return;
                        }
                        return;
                    }
                    TotalListFragment totalListFragment11 = TotalListFragment.this;
                    totalListFragment11.showBottomSheetDialog(strReplace, strReplace2, totalListFragment11.totalList, i, str);
                    return;
                }
                TotalListFragment totalListFragment12 = TotalListFragment.this;
                totalListFragment12.name = totalListFragment12.totalList.get(i).name;
                TotalListFragment totalListFragment13 = TotalListFragment.this;
                totalListFragment13.referenceNo = totalListFragment13.totalList.get(i).refNo;
                TotalListFragment totalListFragment14 = TotalListFragment.this;
                totalListFragment14.formType = totalListFragment14.totalList.get(i).formType;
                TotalListFragment totalListFragment15 = TotalListFragment.this;
                totalListFragment15.epicNo = totalListFragment15.totalList.get(i).epicNo;
                TotalListFragment totalListFragment16 = TotalListFragment.this;
                totalListFragment16.mobNo = totalListFragment16.totalList.get(i).mobNo;
                TotalListFragment totalListFragment17 = TotalListFragment.this;
                totalListFragment17.email = totalListFragment17.totalList.get(i).email;
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "null")) {
                    TotalListFragment.this.visitCount = Integer.parseInt(str);
                } else {
                    TotalListFragment.this.visitCount = 0;
                }
                int currentStatusId2 = TotalListFragment.this.totalList.get(i).getCurrentStatusId();
                final Bundle bundle2 = new Bundle();
                bundle2.putString("Flag", "NEW");
                bundle2.putString(TotalListFragment.this.nameText, TotalListFragment.this.name);
                bundle2.putString(TotalListFragment.this.refNoText, TotalListFragment.this.referenceNo);
                bundle2.putInt(TotalListFragment.this.formTypeText, TotalListFragment.this.formType);
                bundle2.putInt(TotalListFragment.this.formProcessingIdText, i2);
                bundle2.putInt(TotalListFragment.this.currentStatusidText, currentStatusId2);
                bundle2.putString(TotalListFragment.this.epicNoText, TotalListFragment.this.epicNo);
                bundle2.putInt(TotalListFragment.this.processMasterIdText, i3);
                bundle2.putString(TotalListFragment.this.mobNoText, TotalListFragment.this.mobNo);
                bundle2.putString(TotalListFragment.this.photoText, TotalListFragment.this.email);
                bundle2.putInt(TotalListFragment.this.visitCountText, TotalListFragment.this.visitCount);
                bundle2.putString("actionDate", TotalListFragment.this.actionDate);
                if (TotalListFragment.this.formType == 3) {
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment2 = new ApplicantDetailsForm7Fragment();
                    applicantDetailsForm7Fragment2.setArguments(bundle2);
                    TotalListFragment totalListFragment18 = TotalListFragment.this;
                    totalListFragment18.openFragment(applicantDetailsForm7Fragment2, totalListFragment18.checkListText);
                    return;
                }
                if (TotalListFragment.this.formType == 13) {
                    ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment2 = new ApplicantDetailsForm7OverseasFragment();
                    applicantDetailsForm7OverseasFragment2.setArguments(bundle2);
                    TotalListFragment totalListFragment19 = TotalListFragment.this;
                    totalListFragment19.openFragment(applicantDetailsForm7OverseasFragment2, totalListFragment19.checkListText);
                    return;
                }
                if (TotalListFragment.this.formType == 9 || TotalListFragment.this.formType == 10) {
                    TotalListFragment.this.alertDialog.show();
                    TotalListFragment.this.commonUtilClass.getchecklistdetailsform8(TotalListFragment.this.getContext(), TotalListFragment.this.stateCode, TotalListFragment.this.atkBand, TotalListFragment.this.rtkBand, TotalListFragment.this.referenceNo, TotalListFragment.this.token, new AnonymousClass2(bundle2));
                    return;
                }
                if (TotalListFragment.this.formType == 14) {
                    TotalListFragment.this.alertDialog.show();
                    TotalListFragment.this.commonUtilClass.getchecklistdetailsform8O(TotalListFragment.this.getContext(), TotalListFragment.this.stateCode, TotalListFragment.this.atkBand, TotalListFragment.this.rtkBand, TotalListFragment.this.referenceNo, TotalListFragment.this.token);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda9
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onBindViewHolder$3(bundle2);
                        }
                    }, 100L);
                    return;
                } else {
                    if (TotalListFragment.this.formType == 2) {
                        ApplicantDetailsFragment applicantDetailsFragment2 = new ApplicantDetailsFragment();
                        applicantDetailsFragment2.setArguments(bundle2);
                        TotalListFragment totalListFragment20 = TotalListFragment.this;
                        totalListFragment20.openFragment(applicantDetailsFragment2, totalListFragment20.checkListText);
                        return;
                    }
                    if (TotalListFragment.this.formType == 1) {
                        Form6 form7 = new Form6();
                        form7.setArguments(bundle2);
                        TotalListFragment totalListFragment21 = TotalListFragment.this;
                        totalListFragment21.openFragment(form7, totalListFragment21.checkListText);
                        return;
                    }
                    return;
                }
            }
            if (str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(TotalListFragment.this.unauthorizedText) || str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(TotalListFragment.this.unauthorizedText1)) {
                TotalListFragment.this.commonUtilClass.getRefreshToken(TotalListFragment.this.requireContext(), SharedPref.getInstance(TotalListFragment.this.requireContext()).getRefreshToken(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda10
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i4, String str2, String str3) {
                        this.f$0.lambda$onBindViewHolder$12(i2, jsonArray, i, str, i3, i4, str2, str3);
                    }
                });
            } else {
                TotalListFragment totalListFragment22 = TotalListFragment.this;
                totalListFragment22.showDialog(totalListFragment22.alertText, str.replace(RegexMatcher.JSON_STRING_REGEX, ""));
            }
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$1, reason: invalid class name and collision with other inner class name */
        class C00371 implements Forms8Respponse {
            final /* synthetic */ Bundle val$bundleList;

            C00371(final Bundle val$bundleList) {
                this.val$bundleList = val$bundleList;
            }

            @Override // in.gov.eci.bloapp.views.fragments.Forms8Respponse
            public void onCallback(int form8code, JsonObject jsonobjectform8) {
                if (jsonobjectform8 != null) {
                    TotalListFragment.this.countsor = String.valueOf(jsonobjectform8.get(TotalListFragment.this.shiftingOfResidenceText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("", TotalListFragment.this.shiftingText + TotalListFragment.this.countsor);
                    TotalListFragment.this.countcor = String.valueOf(jsonobjectform8.get(TotalListFragment.this.entriesCorrectionInErollText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("", TotalListFragment.this.correctionText + TotalListFragment.this.countcor);
                    if (TotalListFragment.this.countsor.equals("N") && TotalListFragment.this.countcor.equals("N")) {
                        TotalListFragment.this.showDialog(TotalListFragment.this.alertText, TotalListFragment.this.wrongText);
                        TotalListFragment.this.alertDialog.dismiss();
                        return;
                    } else {
                        FormsDetailsFragment formsDetailsFragment = new FormsDetailsFragment();
                        formsDetailsFragment.setArguments(this.val$bundleList);
                        TotalListFragment.this.openFragment(formsDetailsFragment, TotalListFragment.this.checkListText);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onCallback$0();
                            }
                        }, 1000L);
                        return;
                    }
                }
                TotalListFragment.this.alertDialog.dismiss();
                TotalListFragment.this.showDialog(TotalListFragment.this.alertText, TotalListFragment.this.dataNotReceivedText);
                TotalListFragment.this.openFragment(new CheckListMain(), TotalListFragment.this.applicantDetailsText);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onCallback$0() {
                TotalListFragment.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(Bundle bundle) {
            if (TotalListFragment.this.commonUtilClass.jsonobjectform8O != null) {
                TotalListFragment totalListFragment = TotalListFragment.this;
                totalListFragment.countsor1 = String.valueOf(totalListFragment.commonUtilClass.jsonobjectform8O.get(TotalListFragment.this.shiftingOfResidenceText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("", TotalListFragment.this.shiftingText + TotalListFragment.this.countsor1);
                TotalListFragment totalListFragment2 = TotalListFragment.this;
                totalListFragment2.countcor1 = String.valueOf(totalListFragment2.commonUtilClass.jsonobjectform8O.get(TotalListFragment.this.entriesCorrectionInErollText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("", TotalListFragment.this.correctionText + TotalListFragment.this.countcor1);
                if (TotalListFragment.this.countsor1.equals("N") && TotalListFragment.this.countcor1.equals("N")) {
                    TotalListFragment totalListFragment3 = TotalListFragment.this;
                    totalListFragment3.showDialog(totalListFragment3.alertText, TotalListFragment.this.wrongText);
                    TotalListFragment.this.alertDialog.dismiss();
                    return;
                } else {
                    FormsDetailsOverseasFragment formsDetailsOverseasFragment = new FormsDetailsOverseasFragment();
                    formsDetailsOverseasFragment.setArguments(bundle);
                    TotalListFragment totalListFragment4 = TotalListFragment.this;
                    totalListFragment4.openFragment(formsDetailsOverseasFragment, totalListFragment4.checkListText);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onBindViewHolder$0();
                        }
                    }, 1000L);
                    return;
                }
            }
            TotalListFragment.this.alertDialog.dismiss();
            TotalListFragment totalListFragment5 = TotalListFragment.this;
            totalListFragment5.showDialog(totalListFragment5.alertText, TotalListFragment.this.dataNotReceivedText);
            TotalListFragment.this.openFragment(new CheckListMain(), TotalListFragment.this.applicantDetailsText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0() {
            TotalListFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$2, reason: invalid class name */
        class AnonymousClass2 implements Forms8Respponse {
            final /* synthetic */ Bundle val$bundleList1;

            AnonymousClass2(final Bundle val$bundleList1) {
                this.val$bundleList1 = val$bundleList1;
            }

            @Override // in.gov.eci.bloapp.views.fragments.Forms8Respponse
            public void onCallback(int form8code, JsonObject jsonobjectform8) {
                if (jsonobjectform8 != null) {
                    TotalListFragment.this.countsor = String.valueOf(jsonobjectform8.get(TotalListFragment.this.shiftingOfResidenceText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("", TotalListFragment.this.shiftingText + TotalListFragment.this.countsor);
                    TotalListFragment.this.countcor = String.valueOf(jsonobjectform8.get(TotalListFragment.this.entriesCorrectionInErollText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("", TotalListFragment.this.correctionText + TotalListFragment.this.countcor);
                    if (TotalListFragment.this.countsor.equals("N") && TotalListFragment.this.countcor.equals("N")) {
                        TotalListFragment.this.showDialog(TotalListFragment.this.alertText, TotalListFragment.this.wrongText);
                        TotalListFragment.this.alertDialog.dismiss();
                        return;
                    } else {
                        FormsDetailsFragment formsDetailsFragment = new FormsDetailsFragment();
                        formsDetailsFragment.setArguments(this.val$bundleList1);
                        TotalListFragment.this.openFragment(formsDetailsFragment, TotalListFragment.this.checkListText);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$2$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onCallback$0();
                            }
                        }, 1000L);
                        return;
                    }
                }
                TotalListFragment.this.alertDialog.dismiss();
                TotalListFragment.this.showDialog(TotalListFragment.this.alertText, TotalListFragment.this.dataNotReceivedText);
                TotalListFragment.this.openFragment(new CheckListMain(), TotalListFragment.this.applicantDetailsText);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onCallback$0() {
                TotalListFragment.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$3(Bundle bundle) {
            if (TotalListFragment.this.commonUtilClass.jsonobjectform8O != null) {
                TotalListFragment totalListFragment = TotalListFragment.this;
                totalListFragment.countsor1 = String.valueOf(totalListFragment.commonUtilClass.jsonobjectform8O.get(TotalListFragment.this.shiftingOfResidenceText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("", TotalListFragment.this.shiftingText + TotalListFragment.this.countsor1);
                TotalListFragment totalListFragment2 = TotalListFragment.this;
                totalListFragment2.countcor1 = String.valueOf(totalListFragment2.commonUtilClass.jsonobjectform8O.get(TotalListFragment.this.entriesCorrectionInErollText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("", TotalListFragment.this.correctionText + TotalListFragment.this.countcor1);
                if (TotalListFragment.this.countsor1.equals("N") && TotalListFragment.this.countcor1.equals("N")) {
                    TotalListFragment totalListFragment3 = TotalListFragment.this;
                    totalListFragment3.showDialog(totalListFragment3.alertText, TotalListFragment.this.wrongText);
                    TotalListFragment.this.alertDialog.dismiss();
                    return;
                } else {
                    FormsDetailsOverseasFragment formsDetailsOverseasFragment = new FormsDetailsOverseasFragment();
                    formsDetailsOverseasFragment.setArguments(bundle);
                    TotalListFragment totalListFragment4 = TotalListFragment.this;
                    totalListFragment4.openFragment(formsDetailsOverseasFragment, totalListFragment4.checkListText);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda11
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onBindViewHolder$2();
                        }
                    }, 1000L);
                    return;
                }
            }
            TotalListFragment.this.alertDialog.dismiss();
            TotalListFragment totalListFragment5 = TotalListFragment.this;
            totalListFragment5.showDialog(totalListFragment5.alertText, TotalListFragment.this.dataNotReceivedText);
            TotalListFragment.this.openFragment(new CheckListMain(), TotalListFragment.this.applicantDetailsText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2() {
            TotalListFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$12(final int i, final JsonArray jsonArray, final int i2, final String str, final int i3, int i4, final String str2, final String str3) {
            System.out.println("zxnbchdbvfhvb " + i4 + " " + str2 + " " + str3);
            if (i4 == 401 || i4 == 400) {
                TotalListFragment.this.commonUtilClass.showMessageOK(TotalListFragment.this.requireContext(), TotalListFragment.this.sessionTokenText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        this.f$0.lambda$onBindViewHolder$4(dialogInterface, i5);
                    }
                });
                return;
            }
            System.out.println("zxnbchdbvfhvb ---> else refresh" + i4 + " " + str2 + " ");
            TotalListFragment.this.token = "Bearer " + str2;
            SharedPref.getInstance(TotalListFragment.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(TotalListFragment.this.requireContext()).setToken("Bearer " + str2);
            TotalListFragment.this.commonUtilClass.getAeroRemarks(TotalListFragment.this.getContext(), i, TotalListFragment.this.stateCode, TotalListFragment.this.atkBand, TotalListFragment.this.rtkBand, TotalListFragment.this.token, "blo", new MyResponse() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda4
                @Override // in.gov.eci.bloapp.views.MyResponse
                public final void onCallback(JsonArray jsonArray2, String str4) {
                    this.f$0.lambda$onBindViewHolder$11(jsonArray, i2, str, i, i3, str2, str3, jsonArray2, str4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$4(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(TotalListFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(TotalListFragment.this.requireContext()).setLocaleBool(false);
            TotalListFragment.this.startActivity(new Intent((Context) TotalListFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$11(JsonArray jsonArray, int i, String str, int i2, int i3, final String str2, String str3, JsonArray jsonArray2, String str4) {
            if (TotalListFragment.this.alertDialog != null && TotalListFragment.this.alertDialog.isShowing()) {
                TotalListFragment.this.alertDialog.dismiss();
            }
            if (jsonArray2 != null) {
                if (jsonArray2.size() > 0) {
                    JsonArray asJsonArray = jsonArray.get(0).getAsJsonArray();
                    JsonArray asJsonArray2 = jsonArray.get(1).getAsJsonArray();
                    JsonArray asJsonArray3 = jsonArray.get(2).getAsJsonArray();
                    String strReplace = !asJsonArray.isEmpty() ? String.valueOf(asJsonArray.get(0).getAsJsonObject().get("assignBloAeroRemark")).replace(RegexMatcher.JSON_STRING_REGEX, "") : "null";
                    String strReplace2 = !asJsonArray2.isEmpty() ? String.valueOf(asJsonArray2.get(0).getAsJsonObject().get("reInitiateRemark")).replace(RegexMatcher.JSON_STRING_REGEX, "") : "null";
                    if (!asJsonArray3.isEmpty()) {
                        TotalListFragment.this.actionDate = String.valueOf(asJsonArray3.get(asJsonArray3.size() - 1).getAsJsonObject().get("actionDate")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    }
                    if (strReplace.equals("null") && strReplace2.equals("null")) {
                        TotalListFragment totalListFragment = TotalListFragment.this;
                        totalListFragment.name = totalListFragment.totalList.get(i).name;
                        TotalListFragment totalListFragment2 = TotalListFragment.this;
                        totalListFragment2.referenceNo = totalListFragment2.totalList.get(i).refNo;
                        TotalListFragment totalListFragment3 = TotalListFragment.this;
                        totalListFragment3.formType = totalListFragment3.totalList.get(i).formType;
                        TotalListFragment totalListFragment4 = TotalListFragment.this;
                        totalListFragment4.epicNo = totalListFragment4.totalList.get(i).epicNo;
                        TotalListFragment totalListFragment5 = TotalListFragment.this;
                        totalListFragment5.mobNo = totalListFragment5.totalList.get(i).mobNo;
                        TotalListFragment totalListFragment6 = TotalListFragment.this;
                        totalListFragment6.email = totalListFragment6.totalList.get(i).email;
                        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "null")) {
                            TotalListFragment.this.visitCount = Integer.parseInt(str);
                        } else {
                            TotalListFragment.this.visitCount = 0;
                        }
                        int currentStatusId = TotalListFragment.this.totalList.get(i).getCurrentStatusId();
                        final Bundle bundle = new Bundle();
                        bundle.putString("Flag", "NEW");
                        bundle.putString(TotalListFragment.this.nameText, TotalListFragment.this.name);
                        bundle.putString(TotalListFragment.this.refNoText, TotalListFragment.this.referenceNo);
                        bundle.putInt(TotalListFragment.this.formTypeText, TotalListFragment.this.formType);
                        bundle.putInt(TotalListFragment.this.formProcessingIdText, i2);
                        bundle.putInt(TotalListFragment.this.currentStatusidText, currentStatusId);
                        bundle.putString(TotalListFragment.this.epicNoText, TotalListFragment.this.epicNo);
                        bundle.putInt(TotalListFragment.this.processMasterIdText, i3);
                        bundle.putString(TotalListFragment.this.mobNoText, TotalListFragment.this.mobNo);
                        bundle.putString(TotalListFragment.this.photoText, TotalListFragment.this.email);
                        bundle.putInt(TotalListFragment.this.visitCountText, TotalListFragment.this.visitCount);
                        bundle.putString("actionDate", TotalListFragment.this.actionDate);
                        if (TotalListFragment.this.formType == 3) {
                            ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = new ApplicantDetailsForm7Fragment();
                            applicantDetailsForm7Fragment.setArguments(bundle);
                            TotalListFragment totalListFragment7 = TotalListFragment.this;
                            totalListFragment7.openFragment(applicantDetailsForm7Fragment, totalListFragment7.checkListText);
                            return;
                        }
                        if (TotalListFragment.this.formType == 13) {
                            ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = new ApplicantDetailsForm7OverseasFragment();
                            applicantDetailsForm7OverseasFragment.setArguments(bundle);
                            TotalListFragment totalListFragment8 = TotalListFragment.this;
                            totalListFragment8.openFragment(applicantDetailsForm7OverseasFragment, totalListFragment8.checkListText);
                            return;
                        }
                        if (TotalListFragment.this.formType == 9 || TotalListFragment.this.formType == 10) {
                            TotalListFragment.this.alertDialog.show();
                            TotalListFragment.this.commonUtilClass.getchecklistdetailsform8(TotalListFragment.this.getContext(), TotalListFragment.this.stateCode, TotalListFragment.this.atkBand, TotalListFragment.this.rtkBand, TotalListFragment.this.referenceNo, TotalListFragment.this.token, new AnonymousClass3(bundle));
                            return;
                        }
                        if (TotalListFragment.this.formType == 14) {
                            TotalListFragment.this.alertDialog.show();
                            TotalListFragment.this.commonUtilClass.getchecklistdetailsform8O(TotalListFragment.this.getContext(), TotalListFragment.this.stateCode, TotalListFragment.this.atkBand, TotalListFragment.this.rtkBand, TotalListFragment.this.referenceNo, TotalListFragment.this.token);
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda13
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onBindViewHolder$6(bundle);
                                }
                            }, 100L);
                            return;
                        } else {
                            if (TotalListFragment.this.formType == 2) {
                                ApplicantDetailsFragment applicantDetailsFragment = new ApplicantDetailsFragment();
                                applicantDetailsFragment.setArguments(bundle);
                                TotalListFragment totalListFragment9 = TotalListFragment.this;
                                totalListFragment9.openFragment(applicantDetailsFragment, totalListFragment9.checkListText);
                                return;
                            }
                            if (TotalListFragment.this.formType == 1) {
                                Form6 form6 = new Form6();
                                form6.setArguments(bundle);
                                TotalListFragment totalListFragment10 = TotalListFragment.this;
                                totalListFragment10.openFragment(form6, totalListFragment10.checkListText);
                                return;
                            }
                            return;
                        }
                    }
                    TotalListFragment totalListFragment11 = TotalListFragment.this;
                    totalListFragment11.showBottomSheetDialog(strReplace, strReplace2, totalListFragment11.totalList, i, str);
                    return;
                }
                TotalListFragment totalListFragment12 = TotalListFragment.this;
                totalListFragment12.name = totalListFragment12.totalList.get(i).name;
                TotalListFragment totalListFragment13 = TotalListFragment.this;
                totalListFragment13.referenceNo = totalListFragment13.totalList.get(i).refNo;
                TotalListFragment totalListFragment14 = TotalListFragment.this;
                totalListFragment14.formType = totalListFragment14.totalList.get(i).formType;
                TotalListFragment totalListFragment15 = TotalListFragment.this;
                totalListFragment15.epicNo = totalListFragment15.totalList.get(i).epicNo;
                TotalListFragment totalListFragment16 = TotalListFragment.this;
                totalListFragment16.mobNo = totalListFragment16.totalList.get(i).mobNo;
                TotalListFragment totalListFragment17 = TotalListFragment.this;
                totalListFragment17.email = totalListFragment17.totalList.get(i).email;
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "null")) {
                    TotalListFragment.this.visitCount = Integer.parseInt(str);
                } else {
                    TotalListFragment.this.visitCount = 0;
                }
                int currentStatusId2 = TotalListFragment.this.totalList.get(i).getCurrentStatusId();
                final Bundle bundle2 = new Bundle();
                bundle2.putString("Flag", "NEW");
                bundle2.putString(TotalListFragment.this.nameText, TotalListFragment.this.name);
                bundle2.putString(TotalListFragment.this.refNoText, TotalListFragment.this.referenceNo);
                bundle2.putInt(TotalListFragment.this.formTypeText, TotalListFragment.this.formType);
                bundle2.putInt(TotalListFragment.this.formProcessingIdText, i2);
                bundle2.putInt(TotalListFragment.this.currentStatusidText, currentStatusId2);
                bundle2.putString(TotalListFragment.this.epicNoText, TotalListFragment.this.epicNo);
                bundle2.putInt(TotalListFragment.this.processMasterIdText, i3);
                bundle2.putString(TotalListFragment.this.mobNoText, TotalListFragment.this.mobNo);
                bundle2.putString(TotalListFragment.this.photoText, TotalListFragment.this.email);
                bundle2.putInt(TotalListFragment.this.visitCountText, TotalListFragment.this.visitCount);
                bundle2.putString("actionDate", TotalListFragment.this.actionDate);
                if (TotalListFragment.this.formType == 3) {
                    ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment2 = new ApplicantDetailsForm7Fragment();
                    applicantDetailsForm7Fragment2.setArguments(bundle2);
                    TotalListFragment totalListFragment18 = TotalListFragment.this;
                    totalListFragment18.openFragment(applicantDetailsForm7Fragment2, totalListFragment18.checkListText);
                    return;
                }
                if (TotalListFragment.this.formType == 13) {
                    ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment2 = new ApplicantDetailsForm7OverseasFragment();
                    applicantDetailsForm7OverseasFragment2.setArguments(bundle2);
                    TotalListFragment totalListFragment19 = TotalListFragment.this;
                    totalListFragment19.openFragment(applicantDetailsForm7OverseasFragment2, totalListFragment19.checkListText);
                    return;
                }
                if (TotalListFragment.this.formType == 9 || TotalListFragment.this.formType == 10) {
                    TotalListFragment.this.alertDialog.show();
                    TotalListFragment.this.commonUtilClass.getchecklistdetailsform8(TotalListFragment.this.getContext(), TotalListFragment.this.stateCode, TotalListFragment.this.atkBand, TotalListFragment.this.rtkBand, TotalListFragment.this.referenceNo, TotalListFragment.this.token, new AnonymousClass4(bundle2));
                    return;
                }
                if (TotalListFragment.this.formType == 14) {
                    TotalListFragment.this.alertDialog.show();
                    TotalListFragment.this.commonUtilClass.getchecklistdetailsform8O(TotalListFragment.this.getContext(), TotalListFragment.this.stateCode, TotalListFragment.this.atkBand, TotalListFragment.this.rtkBand, TotalListFragment.this.referenceNo, TotalListFragment.this.token);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda14
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onBindViewHolder$8(bundle2);
                        }
                    }, 100L);
                    return;
                } else {
                    if (TotalListFragment.this.formType == 2) {
                        ApplicantDetailsFragment applicantDetailsFragment2 = new ApplicantDetailsFragment();
                        applicantDetailsFragment2.setArguments(bundle2);
                        TotalListFragment totalListFragment20 = TotalListFragment.this;
                        totalListFragment20.openFragment(applicantDetailsFragment2, totalListFragment20.checkListText);
                        return;
                    }
                    if (TotalListFragment.this.formType == 1) {
                        Form6 form7 = new Form6();
                        form7.setArguments(bundle2);
                        TotalListFragment totalListFragment21 = TotalListFragment.this;
                        totalListFragment21.openFragment(form7, totalListFragment21.checkListText);
                        return;
                    }
                    return;
                }
            }
            if (str4.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(TotalListFragment.this.unauthorizedText) || str4.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(TotalListFragment.this.unauthorizedText1)) {
                TotalListFragment.this.commonUtilClass.getRefreshToken(TotalListFragment.this.requireContext(), SharedPref.getInstance(TotalListFragment.this.requireContext()).getRefreshToken(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i4, String str5, String str6) {
                        this.f$0.lambda$onBindViewHolder$10(str2, i4, str5, str6);
                    }
                });
            } else {
                TotalListFragment totalListFragment22 = TotalListFragment.this;
                totalListFragment22.showDialog(totalListFragment22.alertText, str3.replace(RegexMatcher.JSON_STRING_REGEX, ""));
            }
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$3, reason: invalid class name */
        class AnonymousClass3 implements Forms8Respponse {
            final /* synthetic */ Bundle val$bundleList;

            AnonymousClass3(final Bundle val$bundleList) {
                this.val$bundleList = val$bundleList;
            }

            @Override // in.gov.eci.bloapp.views.fragments.Forms8Respponse
            public void onCallback(int form8code, JsonObject jsonobjectform8) {
                if (jsonobjectform8 != null) {
                    TotalListFragment.this.countsor = String.valueOf(jsonobjectform8.get(TotalListFragment.this.shiftingOfResidenceText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("", TotalListFragment.this.shiftingText + TotalListFragment.this.countsor);
                    TotalListFragment.this.countcor = String.valueOf(jsonobjectform8.get(TotalListFragment.this.entriesCorrectionInErollText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("", TotalListFragment.this.correctionText + TotalListFragment.this.countcor);
                    if (TotalListFragment.this.countsor.equals("N") && TotalListFragment.this.countcor.equals("N")) {
                        TotalListFragment.this.showDialog(TotalListFragment.this.alertText, TotalListFragment.this.wrongText);
                        TotalListFragment.this.alertDialog.dismiss();
                        return;
                    } else {
                        FormsDetailsFragment formsDetailsFragment = new FormsDetailsFragment();
                        formsDetailsFragment.setArguments(this.val$bundleList);
                        TotalListFragment.this.openFragment(formsDetailsFragment, TotalListFragment.this.checkListText);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$3$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onCallback$0();
                            }
                        }, 1000L);
                        return;
                    }
                }
                TotalListFragment.this.alertDialog.dismiss();
                TotalListFragment.this.showDialog(TotalListFragment.this.alertText, TotalListFragment.this.dataNotReceivedText);
                TotalListFragment.this.openFragment(new CheckListMain(), TotalListFragment.this.applicantDetailsText);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onCallback$0() {
                TotalListFragment.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$6(Bundle bundle) {
            if (TotalListFragment.this.commonUtilClass.jsonobjectform8O != null) {
                TotalListFragment totalListFragment = TotalListFragment.this;
                totalListFragment.countsor1 = String.valueOf(totalListFragment.commonUtilClass.jsonobjectform8O.get(TotalListFragment.this.shiftingOfResidenceText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("", TotalListFragment.this.shiftingText + TotalListFragment.this.countsor1);
                TotalListFragment totalListFragment2 = TotalListFragment.this;
                totalListFragment2.countcor1 = String.valueOf(totalListFragment2.commonUtilClass.jsonobjectform8O.get(TotalListFragment.this.entriesCorrectionInErollText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("", TotalListFragment.this.correctionText + TotalListFragment.this.countcor1);
                if (TotalListFragment.this.countsor1.equals("N") && TotalListFragment.this.countcor1.equals("N")) {
                    TotalListFragment totalListFragment3 = TotalListFragment.this;
                    totalListFragment3.showDialog(totalListFragment3.alertText, TotalListFragment.this.wrongText);
                    TotalListFragment.this.alertDialog.dismiss();
                    return;
                } else {
                    FormsDetailsOverseasFragment formsDetailsOverseasFragment = new FormsDetailsOverseasFragment();
                    formsDetailsOverseasFragment.setArguments(bundle);
                    TotalListFragment totalListFragment4 = TotalListFragment.this;
                    totalListFragment4.openFragment(formsDetailsOverseasFragment, totalListFragment4.checkListText);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onBindViewHolder$5();
                        }
                    }, 1000L);
                    return;
                }
            }
            TotalListFragment.this.alertDialog.dismiss();
            TotalListFragment totalListFragment5 = TotalListFragment.this;
            totalListFragment5.showDialog(totalListFragment5.alertText, TotalListFragment.this.dataNotReceivedText);
            TotalListFragment.this.openFragment(new CheckListMain(), TotalListFragment.this.applicantDetailsText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$5() {
            TotalListFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$4, reason: invalid class name */
        class AnonymousClass4 implements Forms8Respponse {
            final /* synthetic */ Bundle val$bundleList1;

            AnonymousClass4(final Bundle val$bundleList1) {
                this.val$bundleList1 = val$bundleList1;
            }

            @Override // in.gov.eci.bloapp.views.fragments.Forms8Respponse
            public void onCallback(int form8code, JsonObject jsonobjectform8) {
                if (jsonobjectform8 != null) {
                    TotalListFragment.this.countsor = String.valueOf(jsonobjectform8.get(TotalListFragment.this.shiftingOfResidenceText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("", TotalListFragment.this.shiftingText + TotalListFragment.this.countsor);
                    TotalListFragment.this.countcor = String.valueOf(jsonobjectform8.get(TotalListFragment.this.entriesCorrectionInErollText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    Logger.d("", TotalListFragment.this.correctionText + TotalListFragment.this.countcor);
                    if (TotalListFragment.this.countsor.equals("N") && TotalListFragment.this.countcor.equals("N")) {
                        TotalListFragment.this.showDialog(TotalListFragment.this.alertText, TotalListFragment.this.wrongText);
                        TotalListFragment.this.alertDialog.dismiss();
                    } else {
                        FormsDetailsFragment formsDetailsFragment = new FormsDetailsFragment();
                        formsDetailsFragment.setArguments(this.val$bundleList1);
                        TotalListFragment.this.openFragment(formsDetailsFragment, TotalListFragment.this.checkListText);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$4$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onCallback$0();
                            }
                        }, 1000L);
                    }
                    TotalListFragment.this.alertDialog.dismiss();
                    return;
                }
                TotalListFragment.this.alertDialog.dismiss();
                TotalListFragment.this.showDialog(TotalListFragment.this.alertText, TotalListFragment.this.dataNotReceivedText);
                TotalListFragment.this.openFragment(new CheckListMain(), TotalListFragment.this.applicantDetailsText);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onCallback$0() {
                TotalListFragment.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$8(Bundle bundle) {
            if (TotalListFragment.this.commonUtilClass.jsonobjectform8O != null) {
                TotalListFragment totalListFragment = TotalListFragment.this;
                totalListFragment.countsor1 = String.valueOf(totalListFragment.commonUtilClass.jsonobjectform8O.get(TotalListFragment.this.shiftingOfResidenceText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("", TotalListFragment.this.shiftingText + TotalListFragment.this.countsor1);
                TotalListFragment totalListFragment2 = TotalListFragment.this;
                totalListFragment2.countcor1 = String.valueOf(totalListFragment2.commonUtilClass.jsonobjectform8O.get(TotalListFragment.this.entriesCorrectionInErollText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("", TotalListFragment.this.correctionText + TotalListFragment.this.countcor1);
                if (TotalListFragment.this.countsor1.equals("N") && TotalListFragment.this.countcor1.equals("N")) {
                    TotalListFragment totalListFragment3 = TotalListFragment.this;
                    totalListFragment3.showDialog(totalListFragment3.alertText, TotalListFragment.this.wrongText);
                    TotalListFragment.this.alertDialog.dismiss();
                    return;
                } else {
                    FormsDetailsOverseasFragment formsDetailsOverseasFragment = new FormsDetailsOverseasFragment();
                    formsDetailsOverseasFragment.setArguments(bundle);
                    TotalListFragment totalListFragment4 = TotalListFragment.this;
                    totalListFragment4.openFragment(formsDetailsOverseasFragment, totalListFragment4.checkListText);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onBindViewHolder$7();
                        }
                    }, 1000L);
                    return;
                }
            }
            TotalListFragment.this.alertDialog.dismiss();
            TotalListFragment totalListFragment5 = TotalListFragment.this;
            totalListFragment5.showDialog(totalListFragment5.alertText, TotalListFragment.this.dataNotReceivedText);
            TotalListFragment.this.openFragment(new CheckListMain(), TotalListFragment.this.applicantDetailsText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$7() {
            TotalListFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$10(String str, int i, String str2, String str3) {
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                TotalListFragment.this.commonUtilClass.showMessageOK(TotalListFragment.this.requireContext(), TotalListFragment.this.sessionTokenText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$1$$ExternalSyntheticLambda5
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onBindViewHolder$9(dialogInterface, i2);
                    }
                });
                return;
            }
            System.out.println("zxnbchdbvfhvb ---> else refresh" + i + " " + str + " ");
            TotalListFragment.this.token = "Bearer " + str2;
            SharedPref.getInstance(TotalListFragment.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(TotalListFragment.this.requireContext()).setToken("Bearer " + str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$9(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(TotalListFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(TotalListFragment.this.requireContext()).setLocaleBool(false);
            TotalListFragment.this.startActivity(new Intent((Context) TotalListFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return TotalListFragment.this.totalList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass1());
        this.binding.totalListRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.totalListRv.setAdapter(this.adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBottomSheetDialog(String remarks, String remarksEro, final List<TotalListModel> totalList, final int position, final String message) {
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
        textView3.setText(totalList.get(position).refNo);
        int i = totalList.get(position).formType;
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
        button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showBottomSheetDialog$8(totalList, position, message, dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBottomSheetDialog$8(List list, int i, String str, Dialog dialog, View view) {
        this.name = ((TotalListModel) list.get(i)).name;
        this.referenceNo = ((TotalListModel) list.get(i)).refNo;
        this.formType = ((TotalListModel) list.get(i)).formType;
        this.epicNo = ((TotalListModel) list.get(i)).epicNo;
        this.mobNo = ((TotalListModel) list.get(i)).mobNo;
        this.email = ((TotalListModel) list.get(i)).email;
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "null")) {
            this.visitCount = Integer.parseInt(str);
        } else {
            this.visitCount = 0;
        }
        int formProcessingDetailsId = ((TotalListModel) list.get(i)).getFormProcessingDetailsId();
        int currentStatusId = ((TotalListModel) list.get(i)).getCurrentStatusId();
        final Bundle bundle = new Bundle();
        bundle.putString("Flag", "NEW");
        bundle.putString(this.nameText, this.name);
        bundle.putString(this.refNoText, this.referenceNo);
        bundle.putInt(this.formTypeText, this.formType);
        bundle.putInt(this.formProcessingIdText, formProcessingDetailsId);
        bundle.putInt(this.currentStatusidText, currentStatusId);
        bundle.putString(this.epicNoText, this.epicNo);
        bundle.putInt(this.processMasterIdText, ((TotalListModel) list.get(i)).formType);
        bundle.putString(this.mobNoText, this.mobNo);
        bundle.putString(this.photoText, this.email);
        bundle.putInt(this.visitCountText, this.visitCount);
        bundle.putString("actionDate", this.actionDate);
        int i2 = this.formType;
        if (i2 == 3) {
            ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment = new ApplicantDetailsForm7Fragment();
            applicantDetailsForm7Fragment.setArguments(bundle);
            openFragment(applicantDetailsForm7Fragment, this.checkListText);
        } else if (i2 == 13) {
            ApplicantDetailsForm7OverseasFragment applicantDetailsForm7OverseasFragment = new ApplicantDetailsForm7OverseasFragment();
            applicantDetailsForm7OverseasFragment.setArguments(bundle);
            openFragment(applicantDetailsForm7OverseasFragment, this.checkListText);
        } else if (i2 == 9 || i2 == 10) {
            this.alertDialog.show();
            this.commonUtilClass.getchecklistdetailsform8(getContext(), this.stateCode, this.atkBand, this.rtkBand, this.referenceNo, this.token, new AnonymousClass2(bundle));
        } else if (i2 == 14) {
            this.alertDialog.show();
            this.commonUtilClass.getchecklistdetailsform8O(getContext(), this.stateCode, this.atkBand, this.rtkBand, this.referenceNo, this.token);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$showBottomSheetDialog$7(bundle);
                }
            }, 100L);
        } else if (i2 == 2) {
            ApplicantDetailsFragment applicantDetailsFragment = new ApplicantDetailsFragment();
            applicantDetailsFragment.setArguments(bundle);
            openFragment(applicantDetailsFragment, this.checkListText);
        } else if (i2 == 1) {
            Form6 form6 = new Form6();
            form6.setArguments(bundle);
            openFragment(form6, this.checkListText);
        }
        dialog.dismiss();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Forms8Respponse {
        final /* synthetic */ Bundle val$bundle;

        AnonymousClass2(final Bundle val$bundle) {
            this.val$bundle = val$bundle;
        }

        @Override // in.gov.eci.bloapp.views.fragments.Forms8Respponse
        public void onCallback(int form8code, JsonObject jsonobjectform8) {
            if (jsonobjectform8 != null) {
                TotalListFragment totalListFragment = TotalListFragment.this;
                totalListFragment.countsor = String.valueOf(jsonobjectform8.get(totalListFragment.shiftingOfResidenceText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("", TotalListFragment.this.shiftingText + TotalListFragment.this.countsor);
                TotalListFragment totalListFragment2 = TotalListFragment.this;
                totalListFragment2.countcor = String.valueOf(jsonobjectform8.get(totalListFragment2.entriesCorrectionInErollText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("", TotalListFragment.this.correctionText + TotalListFragment.this.countcor);
                if (TotalListFragment.this.countsor.equals("N") && TotalListFragment.this.countcor.equals("N")) {
                    TotalListFragment totalListFragment3 = TotalListFragment.this;
                    totalListFragment3.showDialog(totalListFragment3.alertText, TotalListFragment.this.wrongText);
                    TotalListFragment.this.alertDialog.dismiss();
                    return;
                } else {
                    FormsDetailsFragment formsDetailsFragment = new FormsDetailsFragment();
                    formsDetailsFragment.setArguments(this.val$bundle);
                    TotalListFragment totalListFragment4 = TotalListFragment.this;
                    totalListFragment4.openFragment(formsDetailsFragment, totalListFragment4.checkListText);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onCallback$0();
                        }
                    }, 1000L);
                    return;
                }
            }
            TotalListFragment.this.alertDialog.dismiss();
            TotalListFragment totalListFragment5 = TotalListFragment.this;
            totalListFragment5.showDialog(totalListFragment5.alertText, TotalListFragment.this.dataNotReceivedText);
            TotalListFragment.this.openFragment(new CheckListMain(), TotalListFragment.this.applicantDetailsText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCallback$0() {
            TotalListFragment.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBottomSheetDialog$7(Bundle bundle) {
        if (this.commonUtilClass.jsonobjectform8O != null) {
            this.countsor1 = String.valueOf(this.commonUtilClass.jsonobjectform8O.get(this.shiftingOfResidenceText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
            Logger.d("", this.shiftingText + this.countsor1);
            this.countcor1 = String.valueOf(this.commonUtilClass.jsonobjectform8O.get(this.entriesCorrectionInErollText)).replace(RegexMatcher.JSON_STRING_REGEX, "");
            Logger.d("", this.correctionText + this.countcor1);
            if (this.countsor1.equals("N") && this.countcor1.equals("N")) {
                showDialog(this.alertText, this.wrongText);
                this.alertDialog.dismiss();
                return;
            } else {
                FormsDetailsOverseasFragment formsDetailsOverseasFragment = new FormsDetailsOverseasFragment();
                formsDetailsOverseasFragment.setArguments(bundle);
                openFragment(formsDetailsOverseasFragment, this.checkListText);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda20
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$showBottomSheetDialog$6();
                    }
                }, 1000L);
                return;
            }
        }
        this.alertDialog.dismiss();
        showDialog(this.alertText, this.dataNotReceivedText);
        openFragment(new CheckListMain(), this.applicantDetailsText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBottomSheetDialog$6() {
        this.alertDialog.dismiss();
    }

    private void getTotalList() {
        clearForms();
        this.totalList.clear();
        this.todayList.clear();
        this.lastWeekList.clear();
        this.last15List.clear();
        this.commonUtilClass.getCheckList1(getContext(), this.stateCode, this.atkBand, this.rtkBand, Integer.parseInt(this.asmblyNO), Integer.parseInt(this.partNo), this.token, "blo", new MyResponse() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda7
            @Override // in.gov.eci.bloapp.views.MyResponse
            public final void onCallback(JsonArray jsonArray, String str) {
                this.f$0.lambda$getTotalList$11(jsonArray, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTotalList$11(JsonArray jsonArray, final String str) {
        String ddMmYy;
        if (jsonArray != null) {
            this.chekListData = jsonArray;
            Logger.d("", this.checkListDataText + this.chekListData);
            try {
                if (jsonArray.isEmpty()) {
                    clearForms();
                    this.totalList.clear();
                    this.todayList.clear();
                    this.lastWeekList.clear();
                    this.last15List.clear();
                    this.alertDialog.dismiss();
                    showDialog(this.alertText, this.noDataFoundText);
                    return;
                }
                for (int i = 0; i < this.chekListData.size(); i++) {
                    JsonObject asJsonObject = this.chekListData.get(i).getAsJsonObject();
                    String strReplaceAll = String.valueOf(asJsonObject.get(this.applicantNameText)).replaceAll("^\"|\"$", "").replaceAll(" null | null", " ");
                    String strReplaceAll2 = String.valueOf(asJsonObject.get(this.formRefNumberText)).replaceAll("^\"|\"$", "");
                    String strReplaceAll3 = String.valueOf(asJsonObject.get(this.submissionDateText)).replaceAll("^\"|\"$", "");
                    Logger.d("", "date " + strReplaceAll3);
                    int i2 = Integer.parseInt(String.valueOf(asJsonObject.get(this.processMasterIdText)));
                    int i3 = Integer.parseInt(String.valueOf(asJsonObject.get(this.formProcessingDetailsIdText)));
                    int i4 = Integer.parseInt(String.valueOf(asJsonObject.get(this.currentStatusIdText)));
                    String strReplaceAll4 = String.valueOf(asJsonObject.get("isExistingElector")).replaceAll("^\"|\"$", "");
                    String strReplaceAll5 = String.valueOf(asJsonObject.get("uncollectableSir")).replaceAll("^\"|\"$", "");
                    if (strReplaceAll3.equals("null")) {
                        ddMmYy = "";
                    } else {
                        this.d1 = this.sdf.parse(strReplaceAll3);
                        ddMmYy = DateStringConverter.toDdMmYy(strReplaceAll3);
                    }
                    this.totalList.add(new TotalListModel(strReplaceAll, strReplaceAll2, "", "", "", ddMmYy, "", "", i2, i3, i4, "", "", strReplaceAll4, strReplaceAll5));
                }
                AlertDialog alertDialog = this.alertDialog;
                if (alertDialog != null && alertDialog.isShowing()) {
                    this.alertDialog.dismiss();
                }
                for (int i5 = 0; i5 < this.totalList.size(); i5++) {
                    if (this.totalList.get(i5).formType == 1) {
                        this.totalForm6++;
                    }
                    if (this.totalList.get(i5).formType == 2) {
                        this.totalForm6A++;
                    }
                    if (this.totalList.get(i5).formType == 5) {
                        this.totalForm6B++;
                    }
                    if (this.totalList.get(i5).formType == 3) {
                        this.totalForm7++;
                    }
                    if (this.totalList.get(i5).formType == 9) {
                        this.totalForm8++;
                    }
                    if (this.totalList.get(i5).formType == 10) {
                        this.totalForm8++;
                    }
                    if (this.totalList.get(i5).formType == 13) {
                        this.totalForm7O++;
                    }
                    if (this.totalList.get(i5).formType == 14) {
                        this.totalForm8O++;
                    }
                }
                updateChart(updateForm(this.bundle));
                Logger.d(this.totalListText, String.valueOf(this.totalList.size()));
                this.binding.totalNoForms.setText(this.totalFormText + this.totalList.size());
                initRecyclerViewAdapter();
                return;
            } catch (Exception e) {
                Logger.e(this.totalListFragment, e.getMessage());
                Logger.d(this.errorText, this.failedToReadText);
                return;
            }
        }
        this.alertDialog.dismiss();
        if (!str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText) && !str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText1)) {
            showDialog(this.alertText, str.replace(RegexMatcher.JSON_STRING_REGEX, ""));
        } else {
            this.commonUtilClass.getRefreshToken(requireContext(), SharedPref.getInstance(requireContext()).getRefreshToken(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda18
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i6, String str2, String str3) {
                    this.f$0.lambda$getTotalList$10(str, i6, str2, str3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTotalList$10(String str, int i, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(requireContext(), this.sessionTokenText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda15
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getTotalList$9(dialogInterface, i2);
                }
            });
            return;
        }
        System.out.println("zxnbchdbvfhvb ---> else refresh" + i + " " + str2 + " ");
        this.token = "Bearer " + str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        getTotalList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTotalList$9(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
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

    private void getTodayList() {
        clearForms();
        this.totalList.clear();
        this.todayList.clear();
        this.lastWeekList.clear();
        this.last15List.clear();
        this.commonUtilClass.getCheckList1(getContext(), this.stateCode, this.atkBand, this.rtkBand, Integer.parseInt(this.asmblyNO), Integer.parseInt(this.partNo), this.token, "blo", new MyResponse() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda22
            @Override // in.gov.eci.bloapp.views.MyResponse
            public final void onCallback(JsonArray jsonArray, String str) {
                this.f$0.lambda$getTodayList$15(jsonArray, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTodayList$15(JsonArray jsonArray, final String str) {
        if (jsonArray != null) {
            this.chekListData = jsonArray;
            Logger.d("", this.checkListDataText + this.chekListData);
            try {
                if (jsonArray.isEmpty()) {
                    clearForms();
                    this.totalList.clear();
                    this.todayList.clear();
                    this.lastWeekList.clear();
                    this.last15List.clear();
                    this.alertDialog.dismiss();
                    showDialog(this.alertText, this.noDataFoundText);
                    return;
                }
                for (int i = 0; i < this.chekListData.size(); i++) {
                    JsonObject asJsonObject = this.chekListData.get(i).getAsJsonObject();
                    String strReplaceAll = String.valueOf(asJsonObject.get(this.applicantNameText)).replaceAll("^\"|\"$", "").replaceAll(" null | null", " ");
                    String strReplaceAll2 = String.valueOf(asJsonObject.get(this.formRefNumberText)).replaceAll("^\"|\"$", "");
                    String strReplaceAll3 = String.valueOf(asJsonObject.get(this.submissionDateText)).replaceAll("^\"|\"$", "");
                    String strReplaceAll4 = String.valueOf(asJsonObject.get("isExistingElector")).replaceAll("^\"|\"$", "");
                    String strReplaceAll5 = String.valueOf(asJsonObject.get("uncollectableSir")).replaceAll("^\"|\"$", "");
                    if (!strReplaceAll3.equals("null")) {
                        this.d1 = this.sdf.parse(strReplaceAll3);
                        Logger.d("", this.printD1 + this.d1);
                        int i2 = Integer.parseInt(String.valueOf(asJsonObject.get(this.processMasterIdText)));
                        int i3 = Integer.parseInt(String.valueOf(asJsonObject.get(this.formProcessingDetailsIdText)));
                        int i4 = Integer.parseInt(String.valueOf(asJsonObject.get(this.currentStatusIdText)));
                        if (DateUtils.isToday(this.d1.getTime())) {
                            this.todayList.add(new TotalListModel(strReplaceAll, strReplaceAll2, "", "", "", DateStringConverter.toDdMmYy(strReplaceAll3), "", "", i2, i3, i4, "", "", strReplaceAll4, strReplaceAll5));
                            Logger.d("", "Print Today List " + this.todayList.size());
                        }
                    }
                }
                if (!this.todayList.isEmpty()) {
                    for (int i5 = 0; i5 < this.todayList.size(); i5++) {
                        if (this.todayList.get(i5).formType == 1) {
                            this.totalForm6++;
                        }
                        if (this.todayList.get(i5).formType == 2) {
                            this.totalForm6A++;
                        }
                        if (this.todayList.get(i5).formType == 5) {
                            this.totalForm6B++;
                        }
                        if (this.todayList.get(i5).formType == 3) {
                            this.totalForm7++;
                        }
                        if (this.todayList.get(i5).formType == 9) {
                            this.totalForm8++;
                        }
                        if (this.todayList.get(i5).formType == 10) {
                            this.totalForm8++;
                        }
                        if (this.todayList.get(i5).formType == 13) {
                            this.totalForm7O++;
                        }
                        if (this.todayList.get(i5).formType == 14) {
                            this.totalForm8O++;
                        }
                        this.bundle.putString("form6", String.valueOf(this.totalForm6));
                        this.bundle.putString("form6a", String.valueOf(this.totalForm6A));
                        this.bundle.putString("form7", String.valueOf(this.totalForm7));
                        this.bundle.putString("form8", String.valueOf(this.totalForm8));
                        this.bundle.putString("form7O", String.valueOf(this.totalForm7O));
                        this.bundle.putString("form8O", String.valueOf(this.totalForm8O));
                    }
                }
                checkdelay(this.todayList);
                updateChart(updateForm(this.bundle));
                Logger.d(this.totalListText, this.todayList.toString());
                this.binding.totalNoForms.setText(this.totalFormText + this.todayList.size());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getTodayList$12();
                    }
                }, 1000L);
                return;
            } catch (Exception e) {
                Logger.e(this.totalListFragment, e.getMessage());
                Logger.d(this.errorText, this.failedToReadText);
                return;
            }
        }
        this.alertDialog.dismiss();
        if (!str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText) && !str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText1)) {
            showDialog(this.alertText, str.replace(RegexMatcher.JSON_STRING_REGEX, ""));
        } else {
            this.commonUtilClass.getRefreshToken(requireContext(), SharedPref.getInstance(requireContext()).getRefreshToken(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda5
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i6, String str2, String str3) {
                    this.f$0.lambda$getTodayList$14(str, i6, str2, str3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTodayList$12() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTodayList$14(String str, int i, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(requireContext(), this.sessionTokenText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda21
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getTodayList$13(dialogInterface, i2);
                }
            });
            return;
        }
        System.out.println("zxnbchdbvfhvb ---> else refresh" + i + " " + str2 + " ");
        this.token = "Bearer " + str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        getTodayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTodayList$13(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    private void getLastWeekList() {
        clearForms();
        this.totalList.clear();
        this.todayList.clear();
        this.lastWeekList.clear();
        this.last15List.clear();
        this.commonUtilClass.getCheckList1(getContext(), this.stateCode, this.atkBand, this.rtkBand, Integer.parseInt(this.asmblyNO), Integer.parseInt(this.partNo), this.token, "blo", new MyResponse() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda14
            @Override // in.gov.eci.bloapp.views.MyResponse
            public final void onCallback(JsonArray jsonArray, String str) {
                this.f$0.lambda$getLastWeekList$19(jsonArray, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLastWeekList$19(JsonArray jsonArray, final String str) {
        if (jsonArray != null) {
            this.chekListData = jsonArray;
            Logger.d("", this.checkListDataText + this.chekListData);
            try {
                if (jsonArray.isEmpty()) {
                    clearForms();
                    this.totalList.clear();
                    this.todayList.clear();
                    this.lastWeekList.clear();
                    this.last15List.clear();
                    this.alertDialog.dismiss();
                    showDialog(this.alertText, this.noDataFoundText);
                    return;
                }
                for (int i = 0; i < this.chekListData.size(); i++) {
                    JsonObject asJsonObject = this.chekListData.get(i).getAsJsonObject();
                    String strReplaceAll = String.valueOf(asJsonObject.get(this.applicantNameText)).replaceAll("^\"|\"$", "").replaceAll(" null | null", " ");
                    String strReplaceAll2 = String.valueOf(asJsonObject.get(this.formRefNumberText)).replaceAll("^\"|\"$", "");
                    String strReplaceAll3 = String.valueOf(asJsonObject.get(this.submissionDateText)).replaceAll("^\"|\"$", "");
                    int i2 = Integer.parseInt(String.valueOf(asJsonObject.get(this.currentStatusIdText)));
                    String strReplaceAll4 = String.valueOf(asJsonObject.get("isExistingElector")).replaceAll("^\"|\"$", "");
                    String strReplaceAll5 = String.valueOf(asJsonObject.get("uncollectableSir")).replaceAll("^\"|\"$", "");
                    if (!strReplaceAll3.equals("null")) {
                        this.d1 = this.sdf.parse(strReplaceAll3);
                        Logger.d("", this.printD1 + this.d1);
                        int i3 = Integer.parseInt(String.valueOf(asJsonObject.get(this.processMasterIdText)));
                        int i4 = Integer.parseInt(String.valueOf(asJsonObject.get(this.formProcessingDetailsIdText)));
                        long time = ((this.todayDate.getTime() - this.d1.getTime()) / 86400000) % 365;
                        if (time <= 7 && time >= 1) {
                            this.lastWeekList.add(new TotalListModel(strReplaceAll, strReplaceAll2, "", "", "", DateStringConverter.toDdMmYy(strReplaceAll3), "", "", i3, i4, i2, "", "", strReplaceAll4, strReplaceAll5));
                            Logger.d("", "Print last 15 List " + this.lastWeekList.size());
                        }
                    }
                }
                if (!this.lastWeekList.isEmpty()) {
                    for (int i5 = 0; i5 < this.lastWeekList.size(); i5++) {
                        if (this.lastWeekList.get(i5).formType == 1) {
                            this.totalForm6++;
                        }
                        if (this.lastWeekList.get(i5).formType == 2) {
                            this.totalForm6A++;
                        }
                        if (this.lastWeekList.get(i5).formType == 5) {
                            this.totalForm6B++;
                        }
                        if (this.lastWeekList.get(i5).formType == 3) {
                            this.totalForm7++;
                        }
                        if (this.lastWeekList.get(i5).formType == 9) {
                            this.totalForm8++;
                        }
                        if (this.lastWeekList.get(i5).formType == 10) {
                            this.totalForm8++;
                        }
                        if (this.lastWeekList.get(i5).formType == 13) {
                            this.totalForm7O++;
                        }
                        if (this.lastWeekList.get(i5).formType == 14) {
                            this.totalForm8O++;
                        }
                        this.bundle.putString("form6", String.valueOf(this.totalForm6));
                        this.bundle.putString("form6a", String.valueOf(this.totalForm6A));
                        this.bundle.putString("form7", String.valueOf(this.totalForm7));
                        this.bundle.putString("form8", String.valueOf(this.totalForm8));
                        this.bundle.putString("form7O", String.valueOf(this.totalForm7O));
                        this.bundle.putString("form8O", String.valueOf(this.totalForm8O));
                    }
                }
                checkdelay1(this.lastWeekList);
                updateChart(updateForm(this.bundle));
                Logger.d(this.totalListText, this.lastWeekList.toString());
                this.binding.totalNoForms.setText(this.totalFormText + this.lastWeekList.size());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getLastWeekList$16();
                    }
                }, 1000L);
                return;
            } catch (Exception e) {
                Logger.e(this.totalListFragment, e.getMessage());
                Logger.d(this.errorText, this.failedToReadText);
                return;
            }
        }
        this.alertDialog.dismiss();
        if (!str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText) && !str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText1)) {
            showDialog(this.alertText, str.replace(RegexMatcher.JSON_STRING_REGEX, ""));
        } else {
            this.commonUtilClass.getRefreshToken(requireContext(), SharedPref.getInstance(requireContext()).getRefreshToken(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda9
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i6, String str2, String str3) {
                    this.f$0.lambda$getLastWeekList$18(str, i6, str2, str3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLastWeekList$16() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLastWeekList$18(String str, int i, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(requireContext(), this.sessionTokenText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda16
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getLastWeekList$17(dialogInterface, i2);
                }
            });
            return;
        }
        System.out.println("zxnbchdbvfhvb ---> else refresh" + i + " " + str2 + " ");
        this.token = "Bearer " + str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        getLastWeekList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLastWeekList$17(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    private void getLast15List() {
        clearForms();
        this.totalList.clear();
        this.todayList.clear();
        this.lastWeekList.clear();
        this.last15List.clear();
        this.commonUtilClass.getCheckList1(getContext(), this.stateCode, this.atkBand, this.rtkBand, Integer.parseInt(this.asmblyNO), Integer.parseInt(this.partNo), this.token, "blo", new MyResponse() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda0
            @Override // in.gov.eci.bloapp.views.MyResponse
            public final void onCallback(JsonArray jsonArray, String str) {
                this.f$0.lambda$getLast15List$23(jsonArray, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLast15List$23(JsonArray jsonArray, final String str) {
        if (jsonArray != null) {
            this.chekListData = jsonArray;
            Logger.d("", this.checkListDataText + this.chekListData);
            try {
                if (jsonArray.isEmpty()) {
                    clearForms();
                    this.totalList.clear();
                    this.todayList.clear();
                    this.lastWeekList.clear();
                    this.last15List.clear();
                    this.alertDialog.dismiss();
                    showDialog(this.alertText, this.noDataFoundText);
                    return;
                }
                for (int i = 0; i < this.chekListData.size(); i++) {
                    JsonObject asJsonObject = this.chekListData.get(i).getAsJsonObject();
                    String strReplaceAll = String.valueOf(asJsonObject.get("isExistingElector")).replaceAll("^\"|\"$", "");
                    String strReplaceAll2 = String.valueOf(asJsonObject.get("uncollectableSir")).replaceAll("^\"|\"$", "");
                    String strReplaceAll3 = String.valueOf(asJsonObject.get(this.applicantNameText)).replaceAll("^\"|\"$", "").replaceAll(" null | null", " ");
                    String strReplaceAll4 = String.valueOf(asJsonObject.get(this.formRefNumberText)).replaceAll("^\"|\"$", "");
                    String strReplaceAll5 = String.valueOf(asJsonObject.get(this.submissionDateText)).replaceAll("^\"|\"$", "");
                    if (!strReplaceAll5.equals("null")) {
                        this.d1 = this.sdf.parse(strReplaceAll5);
                        Logger.d("", this.printD1 + this.d1);
                        int i2 = Integer.parseInt(String.valueOf(asJsonObject.get(this.processMasterIdText)));
                        int i3 = Integer.parseInt(String.valueOf(asJsonObject.get(this.formProcessingDetailsIdText)));
                        int i4 = Integer.parseInt(String.valueOf(asJsonObject.get(this.currentStatusIdText)));
                        long time = ((this.todayDate.getTime() - this.d1.getTime()) / 86400000) % 365;
                        if (time <= 15 && time >= 1) {
                            this.last15List.add(new TotalListModel(strReplaceAll3, strReplaceAll4, "", "", "", DateStringConverter.toDdMmYy(strReplaceAll5), "", "", i2, i3, i4, "", "", strReplaceAll, strReplaceAll2));
                            Logger.d("", "Print last 15 List " + this.last15List.size());
                        }
                    }
                }
                if (!this.last15List.isEmpty()) {
                    for (int i5 = 0; i5 < this.last15List.size(); i5++) {
                        if (this.last15List.get(i5).formType == 1) {
                            this.totalForm6++;
                        }
                        if (this.last15List.get(i5).formType == 2) {
                            this.totalForm6A++;
                        }
                        if (this.last15List.get(i5).formType == 5) {
                            this.totalForm6B++;
                        }
                        if (this.last15List.get(i5).formType == 3) {
                            this.totalForm7++;
                        }
                        if (this.last15List.get(i5).formType == 9) {
                            this.totalForm8++;
                        }
                        if (this.last15List.get(i5).formType == 10) {
                            this.totalForm8++;
                        }
                        if (this.last15List.get(i5).formType == 13) {
                            this.totalForm7O++;
                        }
                        if (this.last15List.get(i5).formType == 14) {
                            this.totalForm8O++;
                        }
                        this.bundle.putString("form6", String.valueOf(this.totalForm6));
                        this.bundle.putString("form6a", String.valueOf(this.totalForm6A));
                        this.bundle.putString("form7", String.valueOf(this.totalForm7));
                        this.bundle.putString("form8", String.valueOf(this.totalForm8));
                        this.bundle.putString("form7O", String.valueOf(this.totalForm7O));
                        this.bundle.putString("form8O", String.valueOf(this.totalForm8O));
                    }
                }
                checkdelay2(this.last15List);
                updateChart(updateForm(this.bundle));
                Logger.d(this.totalListText, this.last15List.toString());
                this.binding.totalNoForms.setText(this.totalFormText + this.last15List.size());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getLast15List$20();
                    }
                }, 1000L);
                return;
            } catch (Exception e) {
                Logger.e(this.totalListFragment, e.getMessage());
                Logger.d(this.errorText, this.failedToReadText);
                return;
            }
        }
        this.alertDialog.dismiss();
        if (!str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText) && !str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText1)) {
            showDialog(this.alertText, str.replace(RegexMatcher.JSON_STRING_REGEX, ""));
        } else {
            this.commonUtilClass.getRefreshToken(requireContext(), SharedPref.getInstance(requireContext()).getRefreshToken(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda12
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i6, String str2, String str3) {
                    this.f$0.lambda$getLast15List$22(str, i6, str2, str3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLast15List$20() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLast15List$22(String str, int i, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(requireContext(), this.sessionTokenText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda11
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getLast15List$21(dialogInterface, i2);
                }
            });
            return;
        }
        System.out.println("zxnbchdbvfhvb ---> else refresh" + i + " " + str2 + " ");
        this.token = "Bearer " + str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        getLast15List();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLast15List$21(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    private void clearForms() {
        this.totalForm6 = 0;
        this.totalForm6A = 0;
        this.totalForm6B = 0;
        this.totalForm7 = 0;
        this.totalForm8 = 0;
        this.totalForm7O = 0;
        this.totalForm8O = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.main, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    private void updateChart(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.chart_fragment, fragment);
        fragmentTransactionBeginTransaction.setTransition(4097);
        fragmentTransactionBeginTransaction.commit();
    }

    private Fragment updateForm(Bundle bundle) {
        bundle.putString("form6", String.valueOf(this.totalForm6));
        bundle.putString("form6a", String.valueOf(this.totalForm6A));
        bundle.putString("form7", String.valueOf(this.totalForm7));
        bundle.putString("form8", String.valueOf(this.totalForm8));
        bundle.putString("form7O", String.valueOf(this.totalForm7O));
        bundle.putString("form8O", String.valueOf(this.totalForm8O));
        FormChartFragment formChartFragment = new FormChartFragment();
        formChartFragment.setArguments(bundle);
        return formChartFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String title, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }
}
