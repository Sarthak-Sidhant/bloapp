package in.gov.eci.bloapp.views.fragments.checklist;

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
import android.widget.Filter;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView;
import in.gov.eci.bloapp.databinding.BloFragmentVerifiedBinding;
import in.gov.eci.bloapp.databinding.BloVerifiedListRvItemBinding;
import in.gov.eci.bloapp.model.app_model.TotalListModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.MyResponse;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class VerifiedFragment extends Hilt_VerifiedFragment {
    private FilterableRecyclerView adapter;
    AlertDialog alertDialog;
    private String asmblyNO;
    String atkBand;
    private BloFragmentVerifiedBinding binding;
    private String partNo;
    String rtkBand;
    private String stateCode;
    private ArrayList<TotalListModel> verifiedList;
    public JsonArray verifiedListData = null;
    public String token = "";
    HashMap<String, Object> verifiedMap = new HashMap<>();
    CommomUtility commonUtilClass = new CommomUtility();
    String alertText = "Alert";
    String unauthorizedText = "unauthorized";
    String unauthorizedText1 = "Bearer token is malformed!";
    String sessionTokenText = "Session token expired please Login";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentVerifiedBinding.inflate(getLayoutInflater());
        this.verifiedList = new ArrayList<>();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.atkBand = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtkBand = SharedPref.getInstance(requireContext()).getRtknBnd();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.verifiedMap.put("stateCode", this.stateCode);
        this.verifiedMap.put("acNo", Integer.valueOf(Integer.parseInt(this.asmblyNO)));
        this.verifiedMap.put("partNo", Integer.valueOf(Integer.parseInt(this.partNo)));
        initClickListener();
        apiCallVerifiedList();
        return this.binding.getRoot();
    }

    private void initClickListener() {
        this.binding.searchverified.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
        startActivity(new Intent((Context) requireActivity(), (Class<?>) VerifiedSearchListActivity.class));
    }

    private void apiCallVerifiedList() {
        if (AadhaarAuthenticationFormFragment.isNetworkAvailable(requireContext())) {
            getVerifiedList();
        } else {
            Toast.makeText(requireContext(), "Please check network", 1).show();
        }
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new FilterableRecyclerView(new FilterableRecyclerView.FilterGenericRecyclerAdapterInterface() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedFragment.1
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(BloVerifiedListRvItemBinding.inflate(VerifiedFragment.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                String str;
                ((BloVerifiedListRvItemBinding) holder.binding).dateTv3.setText("Form Type");
                ((BloVerifiedListRvItemBinding) holder.binding).dateTv3.setGravity(5);
                ((BloVerifiedListRvItemBinding) holder.binding).dateTv3.setTextColor(Color.parseColor("#61000000"));
                ((BloVerifiedListRvItemBinding) holder.binding).serialNoTv.setText("Sno: " + (holder.getAdapterPosition() + 1));
                ((BloVerifiedListRvItemBinding) holder.binding).nameTv.setText(((TotalListModel) VerifiedFragment.this.verifiedList.get(position)).name);
                int i = ((TotalListModel) VerifiedFragment.this.verifiedList.get(position)).formType;
                if (i == 1) {
                    str = "Form 6";
                } else if (i == 2) {
                    str = "Form 6A";
                } else if (i == 3) {
                    str = "Form 7";
                } else if (i == 9) {
                    str = "Form 8 (Shifting)";
                } else if (i == 10) {
                    str = "Form 8 (Corrections)";
                } else if (i == 13) {
                    str = "Form 7 Overseas";
                } else if (i != 14) {
                    str = "";
                } else {
                    str = "Form 8 Overseas";
                }
                ((BloVerifiedListRvItemBinding) holder.binding).dateTv.setText(str);
                ((BloVerifiedListRvItemBinding) holder.binding).refNoTv2.setText(((TotalListModel) VerifiedFragment.this.verifiedList.get(position)).refNo);
                if (!TextUtils.isEmpty(((TotalListModel) VerifiedFragment.this.verifiedList.get(position)).getIsExistingElector()) && ((TotalListModel) VerifiedFragment.this.verifiedList.get(position)).getIsExistingElector().equalsIgnoreCase("Y") && !TextUtils.isEmpty(((TotalListModel) VerifiedFragment.this.verifiedList.get(position)).getUncollectableSir()) && ((TotalListModel) VerifiedFragment.this.verifiedList.get(position)).getUncollectableSir().equalsIgnoreCase("Y")) {
                    ((BloVerifiedListRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#FDE2F5"));
                    ((BloVerifiedListRvItemBinding) holder.binding).existingElectorTv.setVisibility(0);
                    ((BloVerifiedListRvItemBinding) holder.binding).existingElectorTv2.setVisibility(0);
                } else {
                    ((BloVerifiedListRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#E9E9E9"));
                    ((BloVerifiedListRvItemBinding) holder.binding).existingElectorTv.setVisibility(8);
                    ((BloVerifiedListRvItemBinding) holder.binding).existingElectorTv2.setVisibility(8);
                }
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public int getItemCount() {
                return VerifiedFragment.this.verifiedList.size();
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public Filter getFilter() {
                return new Filter() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedFragment.1.1
                    @Override // android.widget.Filter
                    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                        if (String.valueOf(charSequence).length() == 0) {
                            Logger.e("", "in if");
                        } else {
                            Logger.e("", "in else");
                        }
                        return new Filter.FilterResults();
                    }

                    @Override // android.widget.Filter
                    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                        VerifiedFragment.this.adapter.notifyDataSetChanged();
                    }
                };
            }
        });
        this.binding.verifiedRv.setLayoutManager(new GridLayoutManager(getContext(), 1, 1, false));
        this.binding.verifiedRv.setAdapter(this.adapter);
    }

    public void getVerifiedList() {
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.alertDialog.show();
        this.commonUtilClass.getVerifiedList(getContext(), this.stateCode, this.atkBand, this.rtkBand, this.token, "blo", new MyResponse() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedFragment$$ExternalSyntheticLambda1
            @Override // in.gov.eci.bloapp.views.MyResponse
            public final void onCallback(JsonArray jsonArray, String str) {
                this.f$0.lambda$getVerifiedList$3(jsonArray, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getVerifiedList$3(JsonArray jsonArray, final String str) {
        if (jsonArray != null) {
            this.verifiedList.clear();
            this.verifiedListData = jsonArray;
            Logger.d("", "Check list data in total" + this.verifiedListData);
            try {
                if (jsonArray.isEmpty()) {
                    this.alertDialog.dismiss();
                    showDialog(this.alertText, "No data found");
                    return;
                }
                if (this.verifiedListData.size() > 0) {
                    for (int i = 0; i < this.verifiedListData.size(); i++) {
                        JsonObject asJsonObject = this.verifiedListData.get(i).getAsJsonObject();
                        this.verifiedList.add(new TotalListModel(String.valueOf(asJsonObject.get("applicantName")).replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE), String.valueOf(asJsonObject.get("formRefNumber")).replaceAll("^\"|\"$", ""), "", "", "", "", "", "", Integer.parseInt(String.valueOf(asJsonObject.get("processMasterId"))), Integer.parseInt(String.valueOf(asJsonObject.get("formProcessingDetailsId"))), Integer.parseInt(String.valueOf(asJsonObject.get("currentStatusId"))), String.valueOf(asJsonObject.get("remarks")), String.valueOf(asJsonObject.get("remarksType")), String.valueOf(asJsonObject.get("isExistingElector")).replaceAll("^\"|\"$", ""), String.valueOf(asJsonObject.get("uncollectableSir")).replaceAll("^\"|\"$", "")));
                    }
                } else {
                    Logger.d("Value of Verified data", this.verifiedList.toString());
                }
                AlertDialog alertDialog = this.alertDialog;
                if (alertDialog != null && alertDialog.isShowing()) {
                    this.alertDialog.dismiss();
                }
                Logger.d("Total list", this.verifiedList.toString());
                initRecyclerViewAdapter();
                return;
            } catch (JsonIOException e) {
                Logger.e("ChecklistVerifiedFragment", e.getMessage());
                return;
            }
        }
        this.verifiedList.clear();
        this.alertDialog.dismiss();
        if (!str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText) && !str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText1)) {
            showDialog(this.alertText, str.replace(RegexMatcher.JSON_STRING_REGEX, ""));
        } else {
            this.commonUtilClass.getRefreshToken(requireContext(), SharedPref.getInstance(requireContext()).getRefreshToken(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedFragment$$ExternalSyntheticLambda0
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$getVerifiedList$2(str, i2, str2, str3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getVerifiedList$2(String str, int i, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(requireContext(), this.sessionTokenText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedFragment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getVerifiedList$1(dialogInterface, i2);
                }
            });
            return;
        }
        System.out.println("zxnbchdbvfhvb ---> else refresh" + i + StringUtils.SPACE + str2 + StringUtils.SPACE);
        this.token = "Bearer " + str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        getVerifiedList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getVerifiedList$1(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    private void showDialog(String title, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }
}
