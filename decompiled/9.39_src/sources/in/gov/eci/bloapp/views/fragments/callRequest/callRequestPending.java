package in.gov.eci.bloapp.views.fragments.callRequest;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
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
import in.gov.eci.bloapp.databinding.CallRequestPendingRvItemBinding;
import in.gov.eci.bloapp.databinding.FragmentCallRequestPendingBinding;
import in.gov.eci.bloapp.model.app_model.CallBackTotalList;
import in.gov.eci.bloapp.utils.DateStringConverter;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.MyResponse;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class callRequestPending extends Fragment {
    String acknowlege;
    FilterableRecyclerView adapter;
    AlertDialog alertDialog;
    String asmblyNO;
    String atkBand;
    FragmentCallRequestPendingBinding binding;
    String electorEpic;
    String electorMobNo;
    String id;
    String partNo;
    private ArrayList<CallBackTotalList> pendingList;
    String refDate;
    String refNo;
    String refreshToken;
    String rtkBand;
    String stateCode;
    Date todayDate;
    String voterName;
    String token = "";
    CommomUtility commonUtilClass = new CommomUtility();
    public JsonArray pendingListData = null;
    String errorString = "Error";
    String messageString = "message";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Date dateNew = new Date();
    String alertText = "Alert";
    String unauthorizedText = "unauthorized";
    String unauthorizedText1 = "Bearer token is malformed!";
    String sessionTokenText = "Session token expired please Login";
    SimpleDateFormat crdt = new SimpleDateFormat("yyyy-MM-dd");

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentCallRequestPendingBinding.inflate(getLayoutInflater());
        this.pendingList = new ArrayList<>();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        String str = this.sdf.format(this.dateNew);
        this.refDate = str;
        try {
            this.todayDate = this.sdf.parse(str);
        } catch (ParseException e) {
            Logger.e("callRequestPending", e.getMessage());
        }
        Logger.d("", "Print Current date" + this.todayDate);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.atkBand = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtkBand = SharedPref.getInstance(requireContext()).getRtknBnd();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        apiCallpendingList();
        return this.binding.getRoot();
    }

    private void apiCallpendingList() {
        if (BaseFragment.isNetworkAvailable(requireContext())) {
            getTotalPendingList();
        } else {
            Toast.makeText(requireContext(), "Please check network", 1).show();
        }
    }

    private void initRecyclerViewAdapter() {
        Logger.d("callRequestPending", "Inside recycler view");
        this.adapter = new FilterableRecyclerView(new FilterableRecyclerView.FilterGenericRecyclerAdapterInterface() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending.1
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                Logger.d("callRequestPending", "Inside onCreateViewHolder");
                return new RecyclerViewHolder(CallRequestPendingRvItemBinding.inflate(callRequestPending.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
                String str;
                String ddMmYy;
                String createdDttm = "";
                callRequestPending.this.electorMobNo = "";
                callRequestPending.this.id = "";
                callRequestPending.this.voterName = "";
                callRequestPending.this.refNo = "";
                callRequestPending.this.electorEpic = "";
                if (callRequestPending.this.pendingList.isEmpty()) {
                    callRequestPending callrequestpending = callRequestPending.this;
                    callrequestpending.showDialog(callrequestpending.alertText, "No data found");
                    callRequestPending.this.startActivity(new Intent(callRequestPending.this.getContext(), (Class<?>) MainActivity.class));
                }
                ((CallRequestPendingRvItemBinding) holder.binding).requestTv.setText(((CallBackTotalList) callRequestPending.this.pendingList.get(position)).requestNo);
                String str2 = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).refNo;
                String str3 = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).epic;
                String str4 = "Not Available";
                if (str2.isEmpty() || str2.equals("null") || str2.equalsIgnoreCase("RefNo Not Available")) {
                    ((CallRequestPendingRvItemBinding) holder.binding).refNoTv.setText("Epic:");
                    str = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).epic;
                } else if (str3.isEmpty() || str3.equals("null") || str3.equalsIgnoreCase("Epic Not Available")) {
                    str = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).refNo;
                    ((CallRequestPendingRvItemBinding) holder.binding).refNoTv.setText("Ref No:");
                } else {
                    str = "Not Available";
                }
                if (str2.equalsIgnoreCase("RefNo Not Available") && str3.equalsIgnoreCase("Epic Not Available")) {
                    ((CallRequestPendingRvItemBinding) holder.binding).refNoTv.setText("Other:");
                } else {
                    str4 = str;
                }
                new Date();
                try {
                    createdDttm = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).getCreatedDttm();
                    ddMmYy = DateStringConverter.toDdMmYy(((CallBackTotalList) callRequestPending.this.pendingList.get(position)).getCreatedDttm());
                } catch (Exception e) {
                    Logger.d("dateCallBAckPending", e.toString());
                    ddMmYy = createdDttm;
                }
                ((CallRequestPendingRvItemBinding) holder.binding).refNoTv2.setText(str4);
                ((CallRequestPendingRvItemBinding) holder.binding).reqDateTv.setText(ddMmYy);
                ((CallRequestPendingRvItemBinding) holder.binding).mobNoTv.setText(((CallBackTotalList) callRequestPending.this.pendingList.get(position)).mobNo);
                ((CallRequestPendingRvItemBinding) holder.binding).voterNameTv.setText(((CallBackTotalList) callRequestPending.this.pendingList.get(position)).getVoterName());
                if (((CallBackTotalList) callRequestPending.this.pendingList.get(position)).callbackStatus.equals("OTS")) {
                    ((CallRequestPendingRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#fef9e7"));
                    ((CallRequestPendingRvItemBinding) holder.binding).layout.setStrokeColor(Color.parseColor("#f39c12"));
                }
                ((CallRequestPendingRvItemBinding) holder.binding).callRequestElector.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        callRequestPending.this.electorMobNo = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).mobNo;
                        try {
                            callRequestPending.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + callRequestPending.this.electorMobNo)));
                        } catch (SecurityException unused) {
                            Toast.makeText((Context) callRequestPending.this.getActivity(), (CharSequence) "An error occurred", 1).show();
                        }
                    }
                });
                ((CallRequestPendingRvItemBinding) holder.binding).activeButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        callRequestPending.this.acknowlege = "1";
                        callRequestPending.this.electorMobNo = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).mobNo;
                        callRequestPending.this.voterName = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).voterName;
                        callRequestPending.this.refNo = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).refNo;
                        callRequestPending.this.id = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).requestNo;
                        if (((CallBackTotalList) callRequestPending.this.pendingList.get(position)).epic != null) {
                            callRequestPending.this.electorEpic = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).epic;
                        }
                        callRequestPending.this.showDialog1("Attention", "Are you sure you have contacted elector?");
                    }
                });
                ((CallRequestPendingRvItemBinding) holder.binding).unavailableButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending.1.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        callRequestPending.this.acknowlege = "0";
                        callRequestPending.this.electorMobNo = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).mobNo;
                        callRequestPending.this.voterName = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).voterName;
                        callRequestPending.this.refNo = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).refNo;
                        callRequestPending.this.id = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).requestNo;
                        if (((CallBackTotalList) callRequestPending.this.pendingList.get(position)).epic != null) {
                            callRequestPending.this.electorEpic = ((CallBackTotalList) callRequestPending.this.pendingList.get(position)).epic;
                        }
                        callRequestPending.this.showDialog1("Attention", "Are you sure elector is unavailable?");
                    }
                });
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public int getItemCount() {
                return callRequestPending.this.pendingList.size();
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public Filter getFilter() {
                return new Filter() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending.1.4
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
                        callRequestPending.this.adapter.notifyDataSetChanged();
                    }
                };
            }
        });
        this.binding.totalListRv.setLayoutManager(new GridLayoutManager(getContext(), 1, 1, false));
        this.binding.totalListRv.setAdapter(this.adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTotalPendingList() {
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
        this.commonUtilClass.fetchCallBackDetails(getContext(), this.stateCode, this.atkBand, this.rtkBand, this.token, map, new MyResponse() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending$$ExternalSyntheticLambda6
            @Override // in.gov.eci.bloapp.views.MyResponse
            public final void onCallback(JsonArray jsonArray, String str) {
                this.f$0.lambda$getTotalPendingList$2(jsonArray, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTotalPendingList$2(JsonArray jsonArray, final String str) {
        String str2 = "[ \t]+$";
        String str3 = " ";
        if (jsonArray != null) {
            ArrayList<CallBackTotalList> arrayList = this.pendingList;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.pendingListData = jsonArray;
            Logger.d("", "Callback data in total" + this.pendingListData);
            try {
                if (jsonArray.isEmpty()) {
                    this.alertDialog.dismiss();
                    showDialog(this.alertText, "No data found");
                    return;
                }
                if (!this.pendingListData.isEmpty()) {
                    int i = 0;
                    while (i < this.pendingListData.size()) {
                        JsonObject asJsonObject = this.pendingListData.get(i).getAsJsonObject();
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
                        if (strReplaceAll7.equals("false")) {
                            this.pendingList.add(new CallBackTotalList(strReplaceAll4, strReplaceAll5, strReplaceAll3, strReplaceAll, strReplaceAll2, strReplaceAll6, this.asmblyNO, this.partNo, strReplaceAll7, strReplaceAll10, "", strReplaceAll8, strReplaceAll9));
                        }
                        i++;
                        str2 = str2;
                        str3 = str3;
                    }
                } else {
                    Logger.d("Value of pending data", this.pendingList.toString());
                    this.alertDialog.dismiss();
                    showDialog(this.alertText, "No data found");
                }
                AlertDialog alertDialog = this.alertDialog;
                if (alertDialog != null && alertDialog.isShowing()) {
                    this.alertDialog.dismiss();
                }
                Logger.d("Total list", this.pendingList.toString());
                initRecyclerViewAdapter();
                return;
            } catch (JsonIOException e) {
                Logger.e("callRequestPendingFragment", e.getMessage());
                return;
            }
        }
        this.pendingList.clear();
        this.alertDialog.dismiss();
        if (!str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText) && !str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText1)) {
            showDialog(this.alertText, str.replace(RegexMatcher.JSON_STRING_REGEX, ""));
        } else {
            this.commonUtilClass.getRefreshToken(requireContext(), SharedPref.getInstance(requireContext()).getRefreshToken(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending$$ExternalSyntheticLambda2
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str4, String str5) {
                    this.f$0.lambda$getTotalPendingList$1(str, i2, str4, str5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTotalPendingList$1(String str, int i, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(requireContext(), this.sessionTokenText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getTotalPendingList$0(dialogInterface, i2);
                }
            });
            return;
        }
        System.out.println("zxnbchdbvfhvb ---> else refresh" + i + " " + str2 + " ");
        this.token = "Bearer " + str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        getTotalPendingList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTotalPendingList$0(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String title, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog1(String title, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$4(dialogInterface, i);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$4(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        updateCallRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCallRequest() {
        HashMap map = new HashMap();
        map.put("id", this.id);
        map.put("epicNumber", this.electorEpic);
        map.put("isContacted", "true");
        map.put("userFname", SharedPref.getInstance(requireContext()).getBloFname());
        map.put("userLname", SharedPref.getInstance(requireContext()).getBloLname());
        map.put("mobileNumber", SharedPref.getInstance(requireContext()).getBloPhone());
        map.put("partName", this.partNo);
        map.put("modified_dttm", this.todayDate);
        map.put("voterName", this.voterName);
        map.put("voterMobileNumber", this.electorMobNo);
        map.put("referenceNumber", this.refNo);
        map.put("bloCallAcknowledged", this.acknowlege);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkBand, this.rtkBand).updateBloCallback(this.stateCode, map).enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        AnonymousClass2() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.body() != null) {
                callRequestPending.this.alertDialog.dismiss();
                callRequestPending.this.showdialogFinal("Success", "Elector request acknowledged");
                callRequestPending.this.getTotalPendingList();
                return;
            }
            if (response.code() == 401) {
                callRequestPending.this.commonUtilClass.getRefreshToken(callRequestPending.this.requireContext(), callRequestPending.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending$2$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            callRequestPending.this.alertDialog.dismiss();
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(callRequestPending.this.messageString);
                Logger.e("callRequestPending", strOptString);
                callRequestPending callrequestpending = callRequestPending.this;
                callrequestpending.showdialog1(callrequestpending.alertText, strOptString);
            } catch (Exception e) {
                Logger.e("Json1", e.getMessage());
                if (response.message() != null) {
                    callRequestPending callrequestpending2 = callRequestPending.this;
                    callrequestpending2.showdialogFinal(callrequestpending2.alertText, response.message());
                } else {
                    callRequestPending callrequestpending3 = callRequestPending.this;
                    callrequestpending3.showdialogFinal(callrequestpending3.alertText, "No Data Found");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            callRequestPending.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                callRequestPending.this.commonUtilClass.showMessageOK(callRequestPending.this.getContext(), callRequestPending.this.sessionTokenText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            callRequestPending.this.token = "Bearer " + str;
            SharedPref.getInstance(callRequestPending.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(callRequestPending.this.requireContext()).setToken("Bearer " + str);
            callRequestPending.this.updateCallRequest();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(callRequestPending.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(callRequestPending.this.requireContext()).setLocaleBool(false);
            callRequestPending.this.startActivity(new Intent((Context) callRequestPending.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            callRequestPending.this.alertDialog.dismiss();
            Logger.e("on Failure............", t.getMessage());
            callRequestPending callrequestpending = callRequestPending.this;
            callrequestpending.showDialog(callrequestpending.errorString, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialogFinal(String title, String msg) {
        try {
            if (isAdded()) {
                new AlertDialog.Builder(requireContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending$$ExternalSyntheticLambda7
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$showdialogFinal$6(dialogInterface, i);
                    }
                }).create().show();
            }
        } catch (Exception unused) {
            Logger.e("callRequestPending", "Failure while updating");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogFinal$6(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        requireActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog1(String title, String msg) {
        try {
            if (isAdded()) {
                new AlertDialog.Builder(requireContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.callRequest.callRequestPending$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).create().show();
            }
        } catch (Exception unused) {
            Logger.e("callRequestPending", "comingTag");
        }
    }
}
