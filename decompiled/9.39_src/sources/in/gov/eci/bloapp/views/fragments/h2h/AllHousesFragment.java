package in.gov.eci.bloapp.views.fragments.h2h;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloAllHousesRvItemBinding;
import in.gov.eci.bloapp.databinding.BloFragmentAllHousesBinding;
import in.gov.eci.bloapp.databinding.BloH2hFilterBinding;
import in.gov.eci.bloapp.model.app_model.AllHousesModel;
import in.gov.eci.bloapp.model.app_model.HouseModel;
import in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.Statement4;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.ToIntFunction;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class AllHousesFragment extends BaseFragment {
    private GenericRecyclerView adapter;
    AlertDialog alertDialog;
    private AlertDialog alertDialog1;
    private ArrayList<AllHousesModel> allhousesList;
    String asmblyNO;
    BloFragmentAllHousesBinding binding;
    Retrofit.Builder builder;
    String[] currencies;
    ElectorDetailsDatabaseHelper electorDetailsDatabaseHelper;
    BloH2hFilterBinding h2hFilterBinding;
    String houseCountCtr;
    String houseNoCons;
    JSONArray jsonArray11;
    HashMap<String, String> map5;
    JSONParser parser;
    private String partNo;
    Retrofit retrofit;
    ArrayList<String> sec;
    String sectionNameConsStr;
    String sectionNo;
    ArrayList<String> sectionNolist;
    String sectionNumStr;
    private String sectionNumber;
    String sectionNumberStrCon;
    String stateCode;
    private String token = "";
    private JSONArray payloadAllHouses = null;
    private String bloPart = "";
    private String bloState = "";
    private String bloAsm = "";
    String selectSectionNo = "Select Section No. & Name";
    String selectALL = "Select All";
    String sectionNumberStr = "Section No. - ";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public AllHousesFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.sectionNolist = new ArrayList<>();
        this.jsonArray11 = null;
        this.houseCountCtr = "House count (";
        this.houseNoCons = "houseno";
        this.sectionNumberStrCon = "secNo";
        this.sectionNameConsStr = "sectionName";
        this.sectionNumStr = "sectionNo";
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentAllHousesBinding.inflate(getLayoutInflater());
        this.allhousesList = new ArrayList<>();
        this.sec = new ArrayList<>();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog1 = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog1.setCancelable(false);
        this.alertDialog1.setView(viewInflate);
        this.bloAsm = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.bloState = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.bloPart = SharedPref.getInstance(requireContext()).getPartNumber();
        this.electorDetailsDatabaseHelper = ElectorDetailsDatabaseHelper.getDB(requireContext());
        this.map5 = new HashMap<>();
        this.binding.sectionNumber.setText("Section No.- All");
        Log.d("token---->", this.token);
        this.binding.searchallhouse.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        SharedPref.getInstance(requireContext()).getIsOnline();
        if (SharedPref.getInstance(requireContext()).getIsOnline().equals("N")) {
            eroHouseFetchoffline();
        } else if (Constants.h2hflag == 0) {
            eroHouseFetch();
        } else {
            JSONParser jSONParser = new JSONParser();
            this.parser = jSONParser;
            try {
                this.jsonArray11 = (JSONArray) jSONParser.parse(SharedPref.getInstance(getActivity()).getAllHousesData());
                if (Constants.sectionFil == 0) {
                    renderingdata(this.jsonArray11);
                } else {
                    filterHouseFetchonline(Integer.toString(Constants.sectionFil), this.jsonArray11);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        this.binding.filter.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        SearchHouseFragment searchHouseFragment = new SearchHouseFragment();
        Constants.h2hflag = 1;
        openFragment(searchHouseFragment, "Search All Houses");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        if (!SharedPref.getInstance(requireContext()).getSectionData().equals("")) {
            try {
                this.sectionNolist.clear();
                this.sectionNolist.add(this.selectSectionNo);
                this.sectionNolist.add(this.selectALL);
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getSectionData());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.size(); i++) {
                    JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                    if (asJsonObject.get(this.sectionNameConsStr) == null) {
                        this.sectionNumber = asJsonObject.get(this.sectionNumStr).getAsInt() + " - ";
                    } else {
                        this.sectionNumber = asJsonObject.get(this.sectionNumStr).getAsInt() + " - " + asJsonObject.get(this.sectionNameConsStr).getAsString();
                    }
                    arrayList.add(this.sectionNumber);
                }
                Collections.sort(arrayList, new Comparator() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$$ExternalSyntheticLambda5
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return AllHousesFragment.lambda$onCreateView$1((String) obj, (String) obj2);
                    }
                });
                this.sectionNolist.addAll(arrayList);
                if (SharedPref.getInstance(requireContext()).getIsOnline().equals("N")) {
                    showFilteroffline();
                    return;
                } else {
                    showFilter();
                    return;
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return;
            }
        }
        if (isNetworkAvailable(requireContext())) {
            getSection(this.stateCode, this.token, this.asmblyNO, this.partNo);
        } else {
            Toast.makeText(requireContext(), "Please check network", 1).show();
        }
    }

    static /* synthetic */ int lambda$onCreateView$1(String str, String str2) {
        return Integer.parseInt(str.split("-")[0].trim()) - Integer.parseInt(str2.split("-")[0].trim());
    }

    public void eroHouseFetchoffline() {
        List<HouseModel> allElectorDetails1 = this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getAllElectorDetails1(this.partNo);
        for (int i = 0; i < allElectorDetails1.size(); i++) {
            Log.d("TAG", "Data districtName ---> " + allElectorDetails1.get(i).getSectionName());
        }
        String json = new Gson().toJson(allElectorDetails1);
        Log.d("TAG", "Data jsonArray ---> " + json);
        JSONParser jSONParser = new JSONParser();
        this.parser = jSONParser;
        try {
            this.jsonArray11 = (JSONArray) jSONParser.parse(json);
            if (Constants.sectionFil == 0) {
                renderingdataoffline(this.jsonArray11);
            } else {
                filterHouseFetch(Integer.toString(Constants.sectionFil), this.jsonArray11);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void eroHouseFetch() {
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put("stCode", this.bloState);
        map.put("acNo", this.bloAsm);
        map.put("partNo", this.bloPart);
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).eroHouseFetch(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.bloState, "application/json", "ANDROIDMOB", map).enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<EronetResponse> {
        AnonymousClass1() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.body() != null) {
                AllHousesFragment.this.payloadAllHouses = ((EronetResponse) response.body()).getPayload();
                if (AllHousesFragment.this.payloadAllHouses.isEmpty()) {
                    AllHousesFragment.this.binding.sectionNumber.setText("Section No.- All\n" + AllHousesFragment.this.houseCountCtr + AllHousesFragment.this.payloadAllHouses.size() + ")");
                    AllHousesFragment.this.allhousesList.clear();
                    AllHousesFragment.this.alertDialog1.dismiss();
                    AllHousesFragment.this.renderingdata(new JSONArray());
                    AllHousesFragment.this.showDialog1("No Data Found");
                    return;
                }
                SharedPref.getInstance(AllHousesFragment.this.getContext()).setAllHousesData(AllHousesFragment.this.payloadAllHouses.toString());
                AllHousesFragment allHousesFragment = AllHousesFragment.this;
                allHousesFragment.renderingdata(allHousesFragment.payloadAllHouses);
                AllHousesFragment.this.alertDialog1.dismiss();
                return;
            }
            if (response.code() == 401) {
                AllHousesFragment.this.commomUtility.getRefreshToken(AllHousesFragment.this.requireContext(), SharedPref.getInstance(AllHousesFragment.this.requireContext()).getRefreshToken(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$1$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            AllHousesFragment.this.allhousesList.clear();
            AllHousesFragment.this.renderingdata(new JSONArray());
            AllHousesFragment.this.alertDialog1.dismiss();
            try {
                AllHousesFragment.this.showDialog1(response.code() + "  " + new JSONObject(response.errorBody().string()).optString("message"));
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                AllHousesFragment.this.commomUtility.showMessageWithTitleOK(AllHousesFragment.this.requireContext(), "Alert", "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            System.out.println("zxnbchdbvfhvb ---> else refresh" + i + " " + str + " ");
            AllHousesFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(AllHousesFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(AllHousesFragment.this.requireContext()).setToken("Bearer " + str);
            AllHousesFragment.this.eroHouseFetch();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(AllHousesFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(AllHousesFragment.this.getContext()).setLocaleBool(false);
            AllHousesFragment.this.startActivity(new Intent((Context) AllHousesFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            if (AllHousesFragment.this.alertDialog != null) {
                AllHousesFragment.this.alertDialog.dismiss();
            }
            AllHousesFragment.this.showDialog1(t.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$2, reason: invalid class name */
    class AnonymousClass2 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass2() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloAllHousesRvItemBinding.inflate(AllHousesFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
            ((BloAllHousesRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            if (!"Y".equals(((AllHousesModel) AllHousesFragment.this.allhousesList.get(position)).getStatus())) {
                ((BloAllHousesRvItemBinding) holder.binding).VerifiedTickTv.setVisibility(8);
                ((BloAllHousesRvItemBinding) holder.binding).HNoTv.setText("H. No. " + ((AllHousesModel) AllHousesFragment.this.allhousesList.get(position)).getHouseNo());
                ((BloAllHousesRvItemBinding) holder.binding).secn.setText(((AllHousesModel) AllHousesFragment.this.allhousesList.get(position)).getSectionNumber() + "-" + ((AllHousesModel) AllHousesFragment.this.allhousesList.get(position)).getSectionName());
                ((BloAllHousesRvItemBinding) holder.binding).layout.setBackgroundResource(R.drawable.blo_rectangle1);
                ((BloAllHousesRvItemBinding) holder.binding).VerifiedTv.setText("");
                ((BloAllHousesRvItemBinding) holder.binding).button.setVisibility(0);
                ((BloAllHousesRvItemBinding) holder.binding).NoOfPeopleValueET.setText(((AllHousesModel) AllHousesFragment.this.allhousesList.get(position)).getNoofpeople());
                ((BloAllHousesRvItemBinding) holder.binding).NoOfPeopleTv.setText("Number of electors in House \n (non verified)");
            }
            final String str = ((AllHousesModel) AllHousesFragment.this.allhousesList.get(position)).houseno;
            ((BloAllHousesRvItemBinding) holder.binding).viewfamily.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(str, position, view);
                }
            });
            ((BloAllHousesRvItemBinding) holder.binding).addprop.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$2$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(str, position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, int i, View view) {
            Constants.h2hflag = 1;
            Bundle bundle = new Bundle();
            bundle.putString(AllHousesFragment.this.houseNoCons, str);
            bundle.putString(AllHousesFragment.this.sectionNumberStrCon, ((AllHousesModel) AllHousesFragment.this.allhousesList.get(i)).getSectionNumber());
            bundle.putString("bak", "1");
            HouseNumberFragment houseNumberFragment = new HouseNumberFragment();
            houseNumberFragment.setArguments(bundle);
            AllHousesFragment.this.openFragment(houseNumberFragment, "House Details");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(String str, int i, View view) {
            Constants.h2hflag = 1;
            Intent intent = new Intent(view.getContext(), (Class<?>) Statement4.class);
            intent.putExtra(AllHousesFragment.this.houseNoCons, str);
            intent.putExtra(AllHousesFragment.this.sectionNumStr, ((AllHousesModel) AllHousesFragment.this.allhousesList.get(i)).getSectionNumber());
            AllHousesFragment.this.startActivity(intent);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return AllHousesFragment.this.allhousesList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass2());
        this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.allAppsRv.setAdapter(this.adapter);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0088  */
    public void renderingdataoffline(JSONArray allHouses) {
        String strReplace;
        this.allhousesList.clear();
        for (int i = 0; i < allHouses.size(); i++) {
            try {
                JSONObject jSONObject = new JSONObject(allHouses.get(i).toString());
                String string = jSONObject.get(this.houseNoCons).toString();
                String strReplace2 = jSONObject.get("noofpeople").toString().replaceAll("^\"|\"$", "").replace("null", " ");
                String strReplace3 = jSONObject.get("sectionNumber").toString().replaceAll("^\"|\"$", "").replace("null", " ");
                if (jSONObject.has(this.sectionNameConsStr)) {
                    String string2 = jSONObject.get(this.sectionNameConsStr).toString();
                    if (string2.isEmpty() || string2.equals("null")) {
                        strReplace = "";
                    } else {
                        strReplace = jSONObject.get(this.sectionNameConsStr).toString().replaceAll("^\"|\"$", "").replace("null", " ");
                    }
                } else {
                    strReplace = "";
                }
                this.allhousesList.add(new AllHousesModel(string, strReplace2, "N", "", strReplace3, strReplace));
            } catch (Exception e) {
                initRecyclerViewAdapter();
                Logger.d("All houses", e.getMessage());
                Logger.d("error", "Failed to read");
                return;
            }
        }
        this.binding.sectionNumber.setText(this.sectionNumberStr + "All\n" + this.houseCountCtr + this.allhousesList.size() + ")");
        initRecyclerViewAdapter();
        this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.allAppsRv.setAdapter(this.adapter);
    }

    public void renderingdata(JSONArray allHouses) {
        this.allhousesList.clear();
        for (int i = 0; i < allHouses.size(); i++) {
            try {
                JsonObject asJsonObject = this.gson.toJsonTree(allHouses.get(i)).getAsJsonObject();
                String strReplace = asJsonObject.get("houseNo").toString().replaceAll("^\"|\"$", "").replace("null", " ");
                String strReplace2 = asJsonObject.get("memberCount").toString().replaceAll("^\"|\"$", "").replace("null", " ");
                String strReplace3 = asJsonObject.get("isVerified").toString().replaceAll("^\"|\"$", "").replace("null", " ");
                String strReplace4 = asJsonObject.get(this.sectionNumberStrCon).toString().replaceAll("^\"|\"$", "").replace("null", " ");
                String strReplace5 = asJsonObject.get("secName").toString().replaceAll("^\"|\"$", "").replace("null", " ");
                this.sec.add(asJsonObject.get(this.sectionNumberStrCon).toString().replaceAll("^\"|\"$", "").replace("null", " "));
                if (strReplace3.equals("N")) {
                    this.allhousesList.add(new AllHousesModel(strReplace, strReplace2, strReplace3, "", strReplace4, strReplace5));
                }
            } catch (Exception e) {
                Logger.d("All houses", e.getMessage());
                Logger.d("error", "Failed to read");
                return;
            }
        }
        this.binding.sectionNumber.setText(this.sectionNumberStr + "All\n" + this.houseCountCtr + this.allhousesList.size() + ")");
        initRecyclerViewAdapter();
        this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.allAppsRv.setAdapter(this.adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFilteroffline() {
        this.h2hFilterBinding = BloH2hFilterBinding.inflate(getLayoutInflater());
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        dialog.setContentView((View) this.h2hFilterBinding.getRoot());
        dialog.show();
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.sectionNolist);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.h2hFilterBinding.sectionNo.setAdapter((SpinnerAdapter) arrayAdapter);
        this.h2hFilterBinding.sectionNo.setSelection(0);
        this.h2hFilterBinding.sectionNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        this.h2hFilterBinding.filterButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showFilteroffline$3(dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFilteroffline$3(Dialog dialog, View view) {
        if (!this.h2hFilterBinding.sectionNo.getSelectedItem().toString().equals(this.selectSectionNo)) {
            List<HouseModel> allElectorDetails1 = this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getAllElectorDetails1(this.partNo);
            for (int i = 0; i < allElectorDetails1.size(); i++) {
                Log.d("TAG", "Data districtName ---> " + allElectorDetails1.get(i).getSectionName());
            }
            String json = new Gson().toJson(allElectorDetails1);
            Log.d("TAG", "Data jsonArray ---> " + json);
            JSONParser jSONParser = new JSONParser();
            this.parser = jSONParser;
            try {
                this.jsonArray11 = (JSONArray) jSONParser.parse(json);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (this.h2hFilterBinding.sectionNo.getSelectedItem().toString().equals(this.selectALL)) {
                Constants.sectionFil = 0;
                renderingdataoffline(this.jsonArray11);
            } else {
                String[] strArrSplit = this.h2hFilterBinding.sectionNo.getSelectedItem().toString().split(" ");
                this.currencies = strArrSplit;
                Constants.sectionFil = Integer.parseInt(strArrSplit[0]);
                filterHouseFetch(this.currencies[0], this.jsonArray11);
            }
            dialog.dismiss();
            return;
        }
        showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFilter() {
        this.h2hFilterBinding = BloH2hFilterBinding.inflate(getLayoutInflater());
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        dialog.setContentView((View) this.h2hFilterBinding.getRoot());
        dialog.show();
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.sectionNolist);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.h2hFilterBinding.sectionNo.setAdapter((SpinnerAdapter) arrayAdapter);
        this.h2hFilterBinding.sectionNo.setSelection(0);
        this.h2hFilterBinding.sectionNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment.4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        this.h2hFilterBinding.filterButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showFilter$4(dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFilter$4(Dialog dialog, View view) {
        if (!this.h2hFilterBinding.sectionNo.getSelectedItem().toString().equals(this.selectSectionNo)) {
            if (this.h2hFilterBinding.sectionNo.getSelectedItem().toString().equals(this.selectALL)) {
                this.parser = new JSONParser();
                Constants.sectionFil = 0;
                try {
                    this.jsonArray11 = (JSONArray) this.parser.parse(SharedPref.getInstance(getActivity()).getAllHousesData());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                renderingdata(this.jsonArray11);
            } else {
                String[] strArrSplit = this.h2hFilterBinding.sectionNo.getSelectedItem().toString().split(" ");
                this.currencies = strArrSplit;
                Constants.sectionFil = Integer.parseInt(strArrSplit[0]);
                JSONParser jSONParser = new JSONParser();
                this.parser = jSONParser;
                try {
                    this.jsonArray11 = (JSONArray) jSONParser.parse(SharedPref.getInstance(getActivity()).getAllHousesData());
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
                filterHouseFetchonline(this.currencies[0], this.jsonArray11);
            }
            dialog.dismiss();
            return;
        }
        showDialog();
    }

    public void filterHouseFetchonline(String sectionNumber, JSONArray allHouses) {
        this.allhousesList.clear();
        this.parser = new JSONParser();
        for (int i = 0; i < allHouses.size(); i++) {
            JsonObject asJsonObject = this.gson.toJsonTree(allHouses.get(i)).getAsJsonObject();
            String strReplace = asJsonObject.get("houseNo").toString().replaceAll("^\"|\"$", "").replace("null", " ");
            String strReplace2 = asJsonObject.get("memberCount").toString().replaceAll("^\"|\"$", "").replace("null", " ");
            String strReplace3 = asJsonObject.get("isVerified").toString().replaceAll("^\"|\"$", "").replace("null", " ");
            String strReplace4 = asJsonObject.get(this.sectionNumberStrCon).toString().replaceAll("^\"|\"$", "").replace("null", " ");
            String strReplace5 = asJsonObject.get("secName").toString().replaceAll("^\"|\"$", "").replace("null", " ");
            if (sectionNumber.equals(asJsonObject.get(this.sectionNumberStrCon).toString().replaceAll("^\"|\"$", "").replace("null", " ")) && strReplace3.equals("N")) {
                this.allhousesList.add(new AllHousesModel(strReplace, strReplace2, strReplace3, "", strReplace4, strReplace5));
            }
            this.binding.sectionNumber.setText(this.sectionNumberStr + sectionNumber + "\n" + this.houseCountCtr + this.allhousesList.size() + ")");
            initRecyclerViewAdapter();
            this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
            this.binding.allAppsRv.setAdapter(this.adapter);
        }
    }

    public void getSection(String stateCode, String token, String asmblyNo, String partNo) {
        try {
            this.sectionNolist.clear();
            this.sectionNolist.add(this.selectSectionNo);
            this.sectionNolist.add(this.selectALL);
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getSection("ANDROIDMOB", token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode, "application/json", asmblyNo, partNo).enqueue(new AnonymousClass5());
        } catch (Exception e) {
            Logger.d("Content", e.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JSONArray> {
        AnonymousClass5() {
        }

        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            if (response.code() == 200) {
                JSONArray jSONArray = (JSONArray) response.body();
                ArrayList arrayList = new ArrayList();
                SharedPref.getInstance(AllHousesFragment.this.getContext()).setSectionData(jSONArray.toString());
                for (int i = 0; i < jSONArray.size(); i++) {
                    JsonObject asJsonObject = AllHousesFragment.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                    if (asJsonObject.get(AllHousesFragment.this.sectionNameConsStr) == null) {
                        AllHousesFragment.this.sectionNumber = asJsonObject.get(AllHousesFragment.this.sectionNumStr).getAsInt() + " - ";
                        AllHousesFragment.this.map5.put(Integer.toString((int) asJsonObject.get(AllHousesFragment.this.sectionNumStr).getAsFloat()), "");
                    } else {
                        AllHousesFragment.this.map5.put(Integer.toString((int) asJsonObject.get(AllHousesFragment.this.sectionNumStr).getAsFloat()), asJsonObject.get(AllHousesFragment.this.sectionNameConsStr).getAsString());
                        AllHousesFragment.this.sectionNumber = asJsonObject.get(AllHousesFragment.this.sectionNumStr).getAsInt() + " - " + asJsonObject.get(AllHousesFragment.this.sectionNameConsStr).getAsString();
                    }
                    AllHousesFragment allHousesFragment = AllHousesFragment.this;
                    allHousesFragment.sectionNo = String.valueOf(asJsonObject.get(allHousesFragment.sectionNumStr).getAsInt());
                    arrayList.add(String.valueOf(AllHousesFragment.this.sectionNumber));
                }
                Collections.sort(arrayList, Comparator.comparingInt(new ToIntFunction() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$5$$ExternalSyntheticLambda0
                    @Override // java.util.function.ToIntFunction
                    public final int applyAsInt(Object obj) {
                        return Integer.parseInt(((String) obj).split("-")[0].trim());
                    }
                }));
                AllHousesFragment.this.sectionNolist.addAll(arrayList);
                if (SharedPref.getInstance(AllHousesFragment.this.requireContext()).getIsOnline().equals("N")) {
                    AllHousesFragment.this.showFilteroffline();
                } else {
                    AllHousesFragment.this.showFilter();
                }
                AllHousesFragment.this.showProgressInVisible();
                return;
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                SharedPref.getInstance(AllHousesFragment.this.getContext()).setSectionData("");
                AllHousesFragment.this.commomUtility.showMessageWithTitleOK(AllHousesFragment.this.requireContext(), "Section Error - " + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$5$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
            } catch (IOException | JSONException e) {
                SharedPref.getInstance(AllHousesFragment.this.getContext()).setSectionData("");
                AllHousesFragment.this.commomUtility.showMessageWithTitleOK(AllHousesFragment.this.requireContext(), "Section Error - " + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$5$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                Logger.d("", e.getMessage());
            }
            AllHousesFragment.this.showProgressInVisible();
        }

        public void onFailure(Call<JSONArray> call, Throwable t) {
            SharedPref.getInstance(AllHousesFragment.this.getContext()).setSectionData("");
            AllHousesFragment.this.alertDialog.dismiss();
            AllHousesFragment.this.showDialog1(t.getMessage());
            AllHousesFragment.this.showProgressInVisible();
        }
    }

    private void showDialog() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage("Please select section number.");
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog1(String message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.AllHousesFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$6(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$6(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(getContext(), (Class<?>) MainActivity.class));
    }

    public void filterHouseFetch(String sectionNumber, JSONArray allHouses) {
        this.allhousesList.clear();
        this.parser = new JSONParser();
        for (int i = 0; i < allHouses.size(); i++) {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(allHouses.get(i).toString());
                    String strReplace = jSONObject.get(this.houseNoCons).toString().replaceAll("^\"|\"$", "").replace("null", " ");
                    String strReplace2 = jSONObject.get("noofpeople").toString().replaceAll("^\"|\"$", "").replace("null", " ");
                    String strReplace3 = jSONObject.get("sectionNumber").toString().replaceAll("^\"|\"$", "").replace("null", " ");
                    String strReplace4 = jSONObject.get(this.sectionNameConsStr).toString().replaceAll("^\"|\"$", "").replace("null", " ");
                    if (sectionNumber.equals(strReplace3)) {
                        this.allhousesList.add(new AllHousesModel(strReplace, strReplace2, "N", "", strReplace3, strReplace4));
                    }
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (JSONException e2) {
                e = e2;
            }
            this.binding.sectionNumber.setText(this.sectionNumberStr + sectionNumber + "\n" + this.houseCountCtr + this.allhousesList.size() + ")");
            initRecyclerViewAdapter();
            this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
            this.binding.allAppsRv.setAdapter(this.adapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }
}
