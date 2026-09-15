package in.gov.eci.bloapp.views.fragments.callRequest;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView;
import in.gov.eci.bloapp.databinding.CallRequestCompletedRvItemBinding;
import in.gov.eci.bloapp.databinding.FragmentCallRequestCompletedBinding;
import in.gov.eci.bloapp.model.app_model.CallBackTotalList;
import in.gov.eci.bloapp.utils.DateStringConverter;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.MyResponse;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class callRequestCompleted extends Fragment {
    private FilterableRecyclerView adapter;
    AlertDialog alertDialog;
    private String asmblyNO;
    String atkBand;
    private FragmentCallRequestCompletedBinding binding;
    private ArrayList<CallBackTotalList> completedList;
    private String partNo;
    String rtkBand;
    private String stateCode;
    public JsonArray completedListData = null;
    public String token = "";
    HashMap<String, Object> completedMap = new HashMap<>();
    CommomUtility commonUtilClass = new CommomUtility();
    String alertText = "Alert";
    String unauthorizedText = "unauthorized";
    String unauthorizedText1 = "Bearer token is malformed!";
    String sessionTokenText = "Session token expired please Login";
    SimpleDateFormat crdt = new SimpleDateFormat("yyyy-MM-dd");

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentCallRequestCompletedBinding.inflate(getLayoutInflater());
        this.completedList = new ArrayList<>();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.atkBand = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtkBand = SharedPref.getInstance(requireContext()).getRtknBnd();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.completedMap.put("stateCode", this.stateCode);
        this.completedMap.put("acNo", Integer.valueOf(Integer.parseInt(this.asmblyNO)));
        this.completedMap.put("partNo", Integer.valueOf(Integer.parseInt(this.partNo)));
        apiCallVerifiedList();
        return this.binding.getRoot();
    }

    private void apiCallVerifiedList() {
        if (BaseFragment.isNetworkAvailable(requireContext())) {
            getCompletedList();
        } else {
            Toast.makeText(requireContext(), "Please check network", 1).show();
        }
    }

    private void getCompletedList() {
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put("acNo", this.asmblyNO);
        map.put("partNo", this.partNo);
        this.commonUtilClass.fetchCallBackDetails(getContext(), this.stateCode, this.atkBand, this.rtkBand, this.token, map, new MyResponse() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestCompleted$$ExternalSyntheticLambda1
            @Override // in.gov.eci.bloapp.views.MyResponse
            public final void onCallback(JsonArray jsonArray, String str) {
                this.f$0.lambda$getCompletedList$2(jsonArray, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCompletedList$2(JsonArray jsonArray, final String str) {
        String str2 = "[ \t]+$";
        String str3 = " ";
        if (jsonArray != null) {
            this.completedList.clear();
            this.completedListData = jsonArray;
            Logger.d("", "Callback data in total" + this.completedListData);
            try {
                if (jsonArray.isEmpty()) {
                    this.alertDialog.dismiss();
                    showDialog(this.alertText, "No data found");
                    return;
                }
                if (!this.completedListData.isEmpty()) {
                    int i = 0;
                    while (i < this.completedListData.size()) {
                        JsonObject asJsonObject = this.completedListData.get(i).getAsJsonObject();
                        String strReplaceAll = String.valueOf(asJsonObject.get("voterName")).replaceAll("^\"|\"$", "").replaceAll(" null | null", str3);
                        String strReplaceAll2 = String.valueOf(asJsonObject.get("voterAddress")).replaceAll("^\"|\"$", "").replaceAll(" null | null", str3);
                        String strReplaceAll3 = String.valueOf(asJsonObject.get("referenceNumber")).replaceAll("^\"|\"$", "").replaceAll(str2, "");
                        String strReplaceAll4 = String.valueOf(asJsonObject.get("id")).replaceAll("^\"|\"$", "").replaceAll(" null | null", str3);
                        String strReplaceAll5 = String.valueOf(asJsonObject.get("epicNumber")).replaceAll("^\"|\"$", "").replaceAll(" null | null", str3).replace("\\\\", "\\").replaceAll(str2, "");
                        String strReplaceAll6 = String.valueOf(asJsonObject.get("mobileNumber")).replaceAll("^\"|\"$", "").replaceAll(" null | null", str3);
                        String strReplaceAll7 = String.valueOf(asJsonObject.get("isContacted")).replaceAll("^\"|\"$", "").replaceAll(" null | null", str3);
                        String strReplaceAll8 = String.valueOf(asJsonObject.get("callbackStatus")).replaceAll("^\"|\"$", "").replaceAll(" null | null", str3);
                        String strReplaceAll9 = String.valueOf(asJsonObject.get("bloCallAcknowledged")).replaceAll("^\"|\"$", "").replaceAll(" null | null", str3);
                        String strReplaceAll10 = String.valueOf(asJsonObject.get("createdDttm")).replaceAll("^\"|\"$", "").replaceAll(" null | null", str3);
                        String strReplaceAll11 = String.valueOf(asJsonObject.get("modified_dttm")).replaceAll("^\"|\"$", "").replaceAll(" null | null", str3);
                        if (strReplaceAll7.equals("true")) {
                            this.completedList.add(new CallBackTotalList(strReplaceAll4, strReplaceAll5, strReplaceAll3, strReplaceAll, strReplaceAll2, strReplaceAll6, this.asmblyNO, this.partNo, strReplaceAll7, strReplaceAll10, strReplaceAll11, strReplaceAll8, strReplaceAll9));
                        }
                        i++;
                        str2 = str2;
                        str3 = str3;
                    }
                } else {
                    this.alertDialog.dismiss();
                    showDialog(this.alertText, "No data found");
                }
                AlertDialog alertDialog = this.alertDialog;
                if (alertDialog != null && alertDialog.isShowing()) {
                    this.alertDialog.dismiss();
                }
                Logger.d("Total list", this.completedList.toString());
                initRecyclerViewAdapter();
                return;
            } catch (JsonIOException e) {
                Logger.e("CallRequestCompletedFragment", e.getMessage());
                return;
            }
        }
        this.completedList.clear();
        this.alertDialog.dismiss();
        if (!str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText) && !str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText1)) {
            showDialog(this.alertText, str.replace(RegexMatcher.JSON_STRING_REGEX, ""));
        } else {
            this.commonUtilClass.getRefreshToken(requireContext(), SharedPref.getInstance(requireContext()).getRefreshToken(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestCompleted$$ExternalSyntheticLambda2
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str4, String str5) {
                    this.f$0.lambda$getCompletedList$1(str, i2, str4, str5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCompletedList$1(String str, int i, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(requireContext(), this.sessionTokenText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestCompleted$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getCompletedList$0(dialogInterface, i2);
                }
            });
            return;
        }
        System.out.println("zxnbchdbvfhvb ---> else refresh" + i + " " + str2 + " ");
        this.token = "Bearer " + str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        getCompletedList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCompletedList$0(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new FilterableRecyclerView(new FilterableRecyclerView.FilterGenericRecyclerAdapterInterface() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestCompleted.1
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(CallRequestCompletedRvItemBinding.inflate(callRequestCompleted.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                String str;
                String createdDttm;
                String ddMmYy;
                String str2;
                String str3 = "";
                ((CallRequestCompletedRvItemBinding) holder.binding).requestTv.setText(((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).requestNo);
                String str4 = "Not Available";
                if (((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).refNo.isEmpty() || ((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).refNo.equals("null") || ((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).refNo.equalsIgnoreCase("RefNo Not Available")) {
                    str = ((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).epic;
                    ((CallRequestCompletedRvItemBinding) holder.binding).refNoTv.setText("Epic:");
                } else if (((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).epic.isEmpty() || ((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).epic.equals("null") || ((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).epic.equalsIgnoreCase("Epic Not Available")) {
                    str = ((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).refNo;
                    ((CallRequestCompletedRvItemBinding) holder.binding).refNoTv.setText("Ref No:");
                } else {
                    ((CallRequestCompletedRvItemBinding) holder.binding).refNoTv.setText("Other:");
                    str = "Not Available";
                }
                if (((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).refNo.equalsIgnoreCase("RefNo Not Available") && ((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).epic.equalsIgnoreCase("Epic Not Available")) {
                    ((CallRequestCompletedRvItemBinding) holder.binding).refNoTv.setText("Other:");
                } else {
                    str4 = str;
                }
                new Date();
                try {
                    createdDttm = ((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).getCreatedDttm();
                    try {
                        String modified_dttm = ((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).getModified_dttm();
                        callRequestCompleted.this.crdt.parse(createdDttm);
                        callRequestCompleted.this.crdt.parse(modified_dttm);
                        createdDttm = DateStringConverter.toDdMmYy(((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).getCreatedDttm());
                        ddMmYy = DateStringConverter.toDdMmYy(((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).getModified_dttm());
                    } catch (Exception e) {
                        e = e;
                        str3 = createdDttm;
                        Logger.d("dateCallBAckPending", e.toString());
                        createdDttm = str3;
                        ddMmYy = "";
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                ((CallRequestCompletedRvItemBinding) holder.binding).refNoTv2.setText(str4);
                ((CallRequestCompletedRvItemBinding) holder.binding).voterNameTv.setText(((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).getVoterName());
                ((CallRequestCompletedRvItemBinding) holder.binding).reqDateTv.setText(createdDttm);
                ((CallRequestCompletedRvItemBinding) holder.binding).actionDateTv.setText(ddMmYy);
                ((CallRequestCompletedRvItemBinding) holder.binding).mobNoTv.setText(((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).mobNo);
                if (((CallBackTotalList) callRequestCompleted.this.completedList.get(position)).bloCallAcknowledged.equalsIgnoreCase("0")) {
                    str2 = "UnAvailable";
                } else {
                    str2 = "Contacted";
                }
                ((CallRequestCompletedRvItemBinding) holder.binding).statusValue.setText(str2);
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public int getItemCount() {
                return callRequestCompleted.this.completedList.size();
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public Filter getFilter() {
                return new Filter() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestCompleted.1.1
                    @Override // android.widget.Filter
                    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                        if (String.valueOf(charSequence).isEmpty()) {
                            Logger.e("", "in if");
                        } else {
                            Logger.e("", "in else");
                        }
                        return new Filter.FilterResults();
                    }

                    @Override // android.widget.Filter
                    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                        callRequestCompleted.this.adapter.notifyDataSetChanged();
                    }
                };
            }
        });
        this.binding.verifiedRv.setLayoutManager(new GridLayoutManager(getContext(), 1, 1, false));
        this.binding.verifiedRv.setAdapter(this.adapter);
    }

    private void showDialog(String title, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestCompleted$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }
}
