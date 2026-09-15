package in.gov.eci.bloapp.views.fragments.checklist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView;
import in.gov.eci.bloapp.databinding.BloFragmentSearchListBinding;
import in.gov.eci.bloapp.databinding.BloVerifiedListRvItemBinding;
import in.gov.eci.bloapp.model.app_model.TotalListModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.MyResponse;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class VerifiedSearchListActivity extends Hilt_VerifiedSearchListActivity {
    private FilterableRecyclerView adapter;
    AlertDialog alertDialog;
    private String asmblyNO;
    String atkBand;
    private BloFragmentSearchListBinding binding;
    private ArrayList<TotalListModel> mSearchList;
    private String partNo;
    String rtkBand;
    private String stateCode;
    private ArrayList<TotalListModel> verifiedList;
    CommomUtility commonUtilClass = new CommomUtility();
    public JsonArray verifiedListData = null;
    HashMap<String, Object> verifiedMap = new HashMap<>();
    public String token = "";
    String unauthorizedText = "unauthorized";
    String unauthorizedText1 = "Bearer token is malformed!";
    String sessionTokenText = "Session token expired please Login";
    String alertText = "Alert";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloFragmentSearchListBinding bloFragmentSearchListBindingInflate = BloFragmentSearchListBinding.inflate(getLayoutInflater());
        this.binding = bloFragmentSearchListBindingInflate;
        setContentView((View) bloFragmentSearchListBindingInflate.getRoot());
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.verifiedList = new ArrayList<>();
        this.mSearchList = new ArrayList<>();
        this.token = SharedPref.getInstance(this).getToken();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        this.atkBand = SharedPref.getInstance(this).getAtknBnd();
        this.rtkBand = SharedPref.getInstance(this).getRtknBnd();
        this.asmblyNO = SharedPref.getInstance(this).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(this).getPartNumber();
        this.verifiedMap.put("stateCode", this.stateCode);
        this.verifiedMap.put("acNo", Integer.valueOf(Integer.parseInt(this.asmblyNO)));
        this.verifiedMap.put("partNo", Integer.valueOf(Integer.parseInt(this.partNo)));
        if (isNetworkAvailable(this)) {
            this.alertDialog.show();
            getSearchList();
        } else {
            Toast.makeText((Context) this, (CharSequence) "Please check network", 1).show();
        }
        initCLickListener();
    }

    private void initCLickListener() {
        this.binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedSearchListActivity.1
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                VerifiedSearchListActivity.this.adapter.getFilter().filter(newText);
                return false;
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedSearchListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$0(View view) {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initRecyclerViewAdapter() {
        this.mSearchList = this.verifiedList;
        this.adapter = new FilterableRecyclerView(new FilterableRecyclerView.FilterGenericRecyclerAdapterInterface() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedSearchListActivity.2
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(BloVerifiedListRvItemBinding.inflate(VerifiedSearchListActivity.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                String str;
                ((BloVerifiedListRvItemBinding) holder.binding).dateTv3.setText("Form Type");
                ((BloVerifiedListRvItemBinding) holder.binding).dateTv3.setGravity(5);
                ((BloVerifiedListRvItemBinding) holder.binding).dateTv3.setTextColor(Color.parseColor("#61000000"));
                ((BloVerifiedListRvItemBinding) holder.binding).serialNoTv.setText("S.No: " + (holder.getAdapterPosition() + 1));
                ((BloVerifiedListRvItemBinding) holder.binding).nameTv.setText(((TotalListModel) VerifiedSearchListActivity.this.mSearchList.get(position)).name);
                int i = ((TotalListModel) VerifiedSearchListActivity.this.mSearchList.get(position)).formType;
                if (i == 1) {
                    str = "Form 6";
                } else if (i == 2) {
                    str = "Form 6A";
                } else if (i == 3) {
                    str = "Form 7";
                } else if (i == 9) {
                    str = "Form 8 (Shifting)";
                } else if (i != 10) {
                    str = "";
                } else {
                    str = "Form 8 (Corrections)";
                }
                ((BloVerifiedListRvItemBinding) holder.binding).dateTv.setText(str);
                ((BloVerifiedListRvItemBinding) holder.binding).refNoTv2.setText(((TotalListModel) VerifiedSearchListActivity.this.mSearchList.get(position)).refNo);
                if (!TextUtils.isEmpty(((TotalListModel) VerifiedSearchListActivity.this.mSearchList.get(position)).getIsExistingElector()) && ((TotalListModel) VerifiedSearchListActivity.this.mSearchList.get(position)).getIsExistingElector().equalsIgnoreCase("Y") && !TextUtils.isEmpty(((TotalListModel) VerifiedSearchListActivity.this.mSearchList.get(position)).getUncollectableSir()) && ((TotalListModel) VerifiedSearchListActivity.this.mSearchList.get(position)).getUncollectableSir().equalsIgnoreCase("Y")) {
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
                return VerifiedSearchListActivity.this.mSearchList.size();
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public Filter getFilter() {
                return new Filter() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedSearchListActivity.2.1
                    @Override // android.widget.Filter
                    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                        String strValueOf = String.valueOf(charSequence);
                        if (strValueOf.length() == 0) {
                            VerifiedSearchListActivity.this.mSearchList = VerifiedSearchListActivity.this.verifiedList;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            for (TotalListModel totalListModel : VerifiedSearchListActivity.this.mSearchList) {
                                if (totalListModel.name.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                    arrayList.add(totalListModel);
                                } else if (totalListModel.refNo.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                    arrayList.add(totalListModel);
                                }
                            }
                            VerifiedSearchListActivity.this.mSearchList = arrayList;
                        }
                        Filter.FilterResults filterResults = new Filter.FilterResults();
                        filterResults.values = VerifiedSearchListActivity.this.mSearchList;
                        return filterResults;
                    }

                    @Override // android.widget.Filter
                    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                        VerifiedSearchListActivity.this.adapter.notifyDataSetChanged();
                    }
                };
            }
        });
        this.binding.searchListRv.setLayoutManager(new GridLayoutManager(this, 1, 1, false));
        this.binding.searchListRv.setAdapter(this.adapter);
    }

    private void getSearchList() {
        this.commonUtilClass.getVerifiedList(getApplicationContext(), this.stateCode, this.atkBand, this.rtkBand, this.token, "blo", new MyResponse() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedSearchListActivity$$ExternalSyntheticLambda2
            @Override // in.gov.eci.bloapp.views.MyResponse
            public final void onCallback(JsonArray jsonArray, String str) {
                this.f$0.lambda$getSearchList$4(jsonArray, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getSearchList$4(JsonArray jsonArray, final String str) {
        if (jsonArray != null) {
            this.verifiedListData = jsonArray;
            System.out.println("Check list data in total" + this.verifiedListData);
            try {
                if (jsonArray.isEmpty()) {
                    this.alertDialog.dismiss();
                    showDialog(this.alertText, "No data found");
                    return;
                }
                if (this.verifiedListData.size() > 0) {
                    for (int i = 0; i < this.verifiedListData.size(); i++) {
                        JsonObject asJsonObject = this.verifiedListData.get(i).getAsJsonObject();
                        this.verifiedList.add(new TotalListModel(String.valueOf(asJsonObject.get("applicantName")).replaceAll("^\"|\"$", "").replaceAll(" null | null", " "), String.valueOf(asJsonObject.get("formRefNumber")).replaceAll("^\"|\"$", ""), "", "", "", "", "", "", Integer.parseInt(String.valueOf(asJsonObject.get("processMasterId"))), Integer.parseInt(String.valueOf(asJsonObject.get("formProcessingDetailsId"))), 0, String.valueOf(asJsonObject.get("remarks")), String.valueOf(asJsonObject.get("remarksType")), String.valueOf(asJsonObject.get("isExistingElector")).replaceAll("^\"|\"$", ""), String.valueOf(asJsonObject.get("uncollectableSir")).replaceAll("^\"|\"$", "")));
                    }
                } else {
                    Logger.d("Value of Verified data", this.verifiedList.toString());
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedSearchListActivity$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getSearchList$1();
                    }
                }, 1000L);
                Logger.d("Total list", this.verifiedList.toString());
                initRecyclerViewAdapter();
                return;
            } catch (Exception e) {
                Logger.e("Exception", e.getMessage());
                return;
            }
        }
        this.alertDialog.dismiss();
        if (!str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText) && !str.replace(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase(this.unauthorizedText1)) {
            showDialog(this.alertText, str.replace(RegexMatcher.JSON_STRING_REGEX, ""));
        } else {
            this.commonUtilClass.getRefreshToken(this, SharedPref.getInstance(this).getRefreshToken(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedSearchListActivity$$ExternalSyntheticLambda5
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$getSearchList$3(str, i2, str2, str3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSearchList$1() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getSearchList$3(String str, int i, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(this, this.sessionTokenText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedSearchListActivity$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getSearchList$2(dialogInterface, i2);
                }
            });
            return;
        }
        System.out.println("zxnbchdbvfhvb ---> else refresh" + i + " " + str2 + " ");
        this.token = "Bearer " + str2;
        SharedPref.getInstance(this).setRefreshToken(str);
        SharedPref.getInstance(this).setToken("Bearer " + str2);
        getSearchList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getSearchList$2(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(this).setIsLoggedIn(false);
        SharedPref.getInstance(this).setLocaleBool(false);
        startActivity(new Intent((Context) this, (Class<?>) LoginActivity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog(String title, String msg) {
        new android.app.AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.checklist.VerifiedSearchListActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }
}
