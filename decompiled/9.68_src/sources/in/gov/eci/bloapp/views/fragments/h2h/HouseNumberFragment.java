package in.gov.eci.bloapp.views.fragments.h2h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.databinding.BloFragmentHouseNumberBinding;
import in.gov.eci.bloapp.databinding.BloHouseNumberRvItemBinding;
import in.gov.eci.bloapp.model.ElectroleDeatils.H2HElectorDetailModel;
import in.gov.eci.bloapp.model.app_model.HouseDetailModel;
import in.gov.eci.bloapp.model.app_model.ViewFamilyMemberListModel;
import in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class HouseNumberFragment extends Hilt_HouseNumberFragment {
    private GenericRecyclerView adapter;
    private AlertDialog alertDialog;
    BloFragmentHouseNumberBinding binding;
    Retrofit.Builder builder;
    int count;
    ElectorDetailsDatabaseHelper electorDetailsDatabaseHelper;
    ArrayList<String> epicarray;
    private List<HouseDetailModel> housedetailList;
    boolean isAllHouseVerified;
    JSONArray jsonArray11;
    private int myidentifierforbackbutton;
    JSONParser parser;
    Retrofit retrofit;
    private String houseNo = "";
    private String secNo = "";
    private String token = "";
    JSONArray payloadHousedetails = null;
    JSONArray housemembers = null;
    String h2hfrag = "H2HFRAGMENT FRAGMENT";
    String noDataFound = "No Data Found";
    private String blopartNumber = "";
    private String bloStatecode = "";
    private String bloassemcode = "";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public HouseNumberFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.count = 0;
        this.jsonArray11 = null;
        this.isAllHouseVerified = false;
        this.myidentifierforbackbutton = 0;
        this.epicarray = new ArrayList<>();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentHouseNumberBinding.inflate(getLayoutInflater());
        this.housedetailList = new ArrayList();
        boolean z = true;
        new OnBackPressedCallback(z) { // from class: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment.1
            public void handleOnBackPressed() {
                if (HouseNumberFragment.this.myidentifierforbackbutton == 1) {
                    HouseNumberFragment.this.openFragment(new SearchHouseFragment(), "SEARCH HOUSE FRAGMENT");
                }
                HouseNumberFragment.this.openFragment(new H2HFragment(), HouseNumberFragment.this.h2hfrag);
            }
        };
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.houseNo = arguments.getString("houseno");
            this.secNo = arguments.getString("secNo");
            this.myidentifierforbackbutton = 1;
            if (arguments.getString("bak").equals("1")) {
                this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateView$0(view);
                    }
                });
            }
            requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(z) { // from class: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment.2
                public void handleOnBackPressed() {
                    HouseNumberFragment.this.openFragment(new H2HFragment(), HouseNumberFragment.this.h2hfrag);
                }
            });
            if (arguments.getString("bak").equals("2")) {
                this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateView$1(view);
                    }
                });
                requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(z) { // from class: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment.3
                    public void handleOnBackPressed() {
                        HouseNumberFragment.this.openFragment(new SearchHouseFragment(), "SEARCH HOUSE FRAGMENT");
                    }
                });
            }
        }
        this.binding.headTitle.setText("H. No. " + this.houseNo + "  Section No. - " + this.secNo);
        this.bloassemcode = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.bloStatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.blopartNumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.binding.home.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        this.electorDetailsDatabaseHelper = ElectorDetailsDatabaseHelper.getDB(requireContext());
        if (SharedPref.getInstance(requireContext()).getIsOnline().equals("N")) {
            this.binding.home.setImageResource(R.drawable.blo_outline_home_24_red);
            ArrayList arrayList = (ArrayList) this.electorDetailsDatabaseHelper.h2HElectorDetailModelDao().getH2HAllElectorDetails(SharedPref.getInstance(requireContext()).getPartNumber());
            if (!arrayList.isEmpty()) {
                this.epicarray.clear();
                for (int i = 0; i < arrayList.size(); i++) {
                    Log.d("mm", "epicNo ----> " + ((H2HElectorDetailModel) arrayList.get(i)).getEpicNo());
                    ((H2HElectorDetailModel) arrayList.get(i)).getEpicNo();
                    this.epicarray.add(((H2HElectorDetailModel) arrayList.get(i)).getEpicNo());
                }
            }
            this.housemembers = eroHouseMembers1();
        } else {
            this.binding.home.setImageResource(R.drawable.blo_outline_home_24_green);
            eroHouseMembersonline();
        }
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        openFragment(new H2HFragment(), this.h2hfrag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        openFragment(new SearchHouseFragment(), "SEARCHHOUSE FRAGMENT");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    public void renderingdata1(JSONArray allHouses) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < allHouses.size(); i++) {
            try {
                JsonObject asJsonObject = this.gson.toJsonTree(allHouses.get(i)).getAsJsonObject();
                if (asJsonObject.get("houseNo").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE).equals(this.houseNo)) {
                    asJsonObject.addProperty("isVerified", "Y");
                    jSONArray.add(asJsonObject);
                } else {
                    jSONArray.add(asJsonObject);
                }
            } catch (Exception e) {
                initRecyclerViewAdapter();
                Logger.d("All houses", e.getMessage());
                return;
            }
        }
        SharedPref.getInstance(getContext()).setAllHousesData(jSONArray.toString());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment$4, reason: invalid class name */
    class AnonymousClass4 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass4() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloHouseNumberRvItemBinding.inflate(HouseNumberFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
            ((BloHouseNumberRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloHouseNumberRvItemBinding) holder.binding).applicantET.setText(((HouseDetailModel) HouseNumberFragment.this.housedetailList.get(position)).getApplicantname());
            ((BloHouseNumberRvItemBinding) holder.binding).EpicEt.setText(((HouseDetailModel) HouseNumberFragment.this.housedetailList.get(position)).getEpicnumber());
            ((BloHouseNumberRvItemBinding) holder.binding).AgeET.setText(((HouseDetailModel) HouseNumberFragment.this.housedetailList.get(position)).getAge());
            ((BloHouseNumberRvItemBinding) holder.binding).RelativeNameET.setText(((HouseDetailModel) HouseNumberFragment.this.housedetailList.get(position)).getRelativename());
            ((BloHouseNumberRvItemBinding) holder.binding).VerifiedTickTv.setText("Verified");
            ((BloHouseNumberRvItemBinding) holder.binding).SectionEt.setText(((HouseDetailModel) HouseNumberFragment.this.housedetailList.get(position)).getSectionNo() + StringUtils.SPACE + ((HouseDetailModel) HouseNumberFragment.this.housedetailList.get(position)).getSectionName());
            final String epicnumber = ((HouseDetailModel) HouseNumberFragment.this.housedetailList.get(position)).getEpicnumber();
            HouseNumberFragment.this.binding.addFamilymem.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment$4$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(position, view);
                }
            });
            if ("Yes".equals(((HouseDetailModel) HouseNumberFragment.this.housedetailList.get(position)).getStatus())) {
                HouseNumberFragment.this.count++;
            }
            if (!"Yes".equals(((HouseDetailModel) HouseNumberFragment.this.housedetailList.get(position)).getStatus())) {
                ((BloHouseNumberRvItemBinding) holder.binding).VerifiedTickTv.setVisibility(8);
                ((BloHouseNumberRvItemBinding) holder.binding).VerifiedTv.setText("");
            }
            if (SharedPref.getInstance(HouseNumberFragment.this.requireContext()).getIsOnline().equals("N")) {
                ((BloHouseNumberRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment$4$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onBindViewHolder$1(position, epicnumber, view);
                    }
                });
            } else {
                ((BloHouseNumberRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment$4$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onBindViewHolder$2(position, epicnumber, view);
                    }
                });
            }
            if (HouseNumberFragment.this.count == HouseNumberFragment.this.housedetailList.size()) {
                HouseNumberFragment.this.isAllHouseVerified = true;
                HouseNumberFragment.this.showdialogNew("House no. -" + HouseNumberFragment.this.houseNo);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i, View view) {
            Bundle bundle = new Bundle();
            bundle.putString("housenomain", HouseNumberFragment.this.houseNo);
            bundle.putString("sectionNo", ((HouseDetailModel) HouseNumberFragment.this.housedetailList.get(i)).getSectionNo() + StringUtils.SPACE + ((HouseDetailModel) HouseNumberFragment.this.housedetailList.get(i)).getSectionName());
            Statement3 statement3 = new Statement3();
            statement3.setArguments(bundle);
            HouseNumberFragment.this.openFragment(statement3, "Statement 3");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(int i, String str, View view) {
            if ("Yes".equals(((HouseDetailModel) HouseNumberFragment.this.housedetailList.get(i)).getStatus())) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("housenomain", HouseNumberFragment.this.houseNo);
            bundle.putString("epicnumber", str);
            H2HDETAILS h2hdetails = new H2HDETAILS();
            h2hdetails.setArguments(bundle);
            if (HouseNumberFragment.this.epicarray.contains(((HouseDetailModel) HouseNumberFragment.this.housedetailList.get(i)).getEpicnumber())) {
                HouseNumberFragment.this.showDialog2();
            } else {
                HouseNumberFragment.this.openFragment(h2hdetails, "H2hDetails ");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(int i, String str, View view) {
            if ("Yes".equals(((HouseDetailModel) HouseNumberFragment.this.housedetailList.get(i)).getStatus())) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("housenomain", HouseNumberFragment.this.houseNo);
            bundle.putString("epicnumber", str);
            H2HDETAILS h2hdetails = new H2HDETAILS();
            h2hdetails.setArguments(bundle);
            HouseNumberFragment.this.openFragment(h2hdetails, "H2hDetails ");
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return HouseNumberFragment.this.housedetailList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        this.count = 0;
        this.adapter = new GenericRecyclerView(new AnonymousClass4());
        this.binding.houseDetailsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.houseDetailsRv.setAdapter(this.adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialogNew(String title) {
        new AlertDialog.Builder(requireContext()).setTitle(title).setMessage("All House member verified").setCancelable(false).setPositiveButton("H2H Dashboard", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogNew$3(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogNew$3(DialogInterface dialogInterface, int i) {
        JSONParser jSONParser = new JSONParser();
        this.parser = jSONParser;
        try {
            JSONArray jSONArray = (JSONArray) jSONParser.parse(SharedPref.getInstance(getActivity()).getAllHousesData());
            this.jsonArray11 = jSONArray;
            renderingdata1(jSONArray);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        openFragment(new H2HFragment(), this.h2hfrag);
        dialogInterface.cancel();
    }

    public JSONArray eroHouseMembers1() {
        List<ViewFamilyMemberListModel> nonVerifiedElectorDetails = this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getNonVerifiedElectorDetails(this.houseNo, this.secNo);
        for (int i = 0; i < nonVerifiedElectorDetails.size(); i++) {
            Log.d("TAG", "Non Verified Elector details ---> " + nonVerifiedElectorDetails.get(i).getHouseNo());
        }
        String json = new Gson().toJson(nonVerifiedElectorDetails);
        Log.d("TAG", "Data jsonArray ---> " + json);
        JSONParser jSONParser = new JSONParser();
        this.parser = jSONParser;
        try {
            JSONArray jSONArray = (JSONArray) jSONParser.parse(json);
            this.jsonArray11 = jSONArray;
            renderingdata(jSONArray);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this.payloadHousedetails;
    }

    public void eroHouseMembersonline() {
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put("stCode", this.bloStatecode);
        map.put("acNo", this.bloassemcode);
        map.put("partNo", this.blopartNumber);
        map.put("houseNoAdd", this.houseNo);
        map.put("sectionNo", this.secNo);
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).eroHouseDetails(this.token, "blo", this.bloStatecode, "application/json", "ANDROIDMOB", map).enqueue(new AnonymousClass5());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<EronetResponse> {
        AnonymousClass5() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.body() != null) {
                HouseNumberFragment.this.payloadHousedetails = ((EronetResponse) response.body()).getPayload();
                if (!HouseNumberFragment.this.payloadHousedetails.isEmpty()) {
                    HouseNumberFragment houseNumberFragment = HouseNumberFragment.this;
                    houseNumberFragment.renderingdataonline(houseNumberFragment.payloadHousedetails);
                    HouseNumberFragment.this.alertDialog.dismiss();
                    return;
                } else {
                    HouseNumberFragment houseNumberFragment2 = HouseNumberFragment.this;
                    houseNumberFragment2.showDialog1(houseNumberFragment2.noDataFound);
                    HouseNumberFragment.this.alertDialog.dismiss();
                    return;
                }
            }
            HouseNumberFragment.this.alertDialog.dismiss();
            try {
                HouseNumberFragment.this.showDialog1(response.code() + "  " + new JSONObject(response.errorBody().string()).optString("message"));
            } catch (Exception e) {
                Logger.d("tag11", e.getMessage());
                Logger.d("tag11", "" + response.code());
                if (response.code() == 401) {
                    HouseNumberFragment.this.commomUtility.showMessageWithTitleOK(HouseNumberFragment.this.requireContext(), "Alert", "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment$5$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                } else if (response.message() != null) {
                    HouseNumberFragment.this.showDialog1(response.code() + StringUtils.SPACE + response.message());
                } else {
                    HouseNumberFragment houseNumberFragment3 = HouseNumberFragment.this;
                    houseNumberFragment3.showDialog1(houseNumberFragment3.noDataFound);
                }
            }
            HouseNumberFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(HouseNumberFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(HouseNumberFragment.this.getContext()).setLocaleBool(false);
            HouseNumberFragment.this.startActivity(new Intent((Context) HouseNumberFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            HouseNumberFragment.this.alertDialog.dismiss();
            HouseNumberFragment.this.showDialog1(t.getMessage());
        }
    }

    public void renderingdataonline(JSONArray housedetails) {
        this.housedetailList.clear();
        for (int i = 0; i < housedetails.size(); i++) {
            try {
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) housedetails.get(i);
                String str = (String) linkedTreeMap.get("applicantName");
                String str2 = (String) linkedTreeMap.get("age");
                String str3 = (String) linkedTreeMap.get("epicNo");
                String str4 = (String) linkedTreeMap.get("relativeName");
                String str5 = (String) linkedTreeMap.get("isVerified");
                String str6 = (String) linkedTreeMap.get("sectionNo");
                String str7 = (String) linkedTreeMap.get("sectionName");
                if (this.secNo.equals(str6)) {
                    this.housedetailList.add(new HouseDetailModel(str, str3, str2, str4, str5, str6, str7));
                }
            } catch (Exception e) {
                Logger.d("house_number_frag", e.getMessage());
                return;
            }
        }
        if (this.housedetailList.isEmpty()) {
            showDialog();
        } else {
            initRecyclerViewAdapter();
        }
        this.binding.houseDetailsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.houseDetailsRv.setAdapter(this.adapter);
    }

    private void showDialog() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(this.noDataFound);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog$4(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog$4(DialogInterface dialogInterface, int i) {
        openFragment(new H2HFragment(), this.h2hfrag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog2() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Alert");
        builder.setMessage("This epic data is already exist in draft entries.");
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public void renderingdata(JSONArray housedetails) {
        this.housedetailList.clear();
        for (int i = 0; i < housedetails.size(); i++) {
            try {
                JSONObject jSONObject = new JSONObject(housedetails.get(i).toString());
                String strReplace = jSONObject.get("APPLICANT_NAME").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace2 = jSONObject.get("AGE").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace3 = jSONObject.get("EPIC_NO").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace4 = jSONObject.get("RELATIVE_NAME").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace5 = jSONObject.get("SECTION_NO").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace6 = jSONObject.get("SECTION_NAME").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                if (this.secNo.equals(strReplace5)) {
                    this.housedetailList.add(new HouseDetailModel(strReplace, strReplace3, strReplace2, strReplace4, "N", strReplace5, strReplace6));
                }
            } catch (Exception e) {
                Logger.d("house_number_frag", e.getMessage());
                return;
            }
        }
        if (this.housedetailList.isEmpty()) {
            showDialog();
        } else {
            initRecyclerViewAdapter();
        }
        this.binding.houseDetailsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.houseDetailsRv.setAdapter(this.adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog1(String message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$6(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$6(DialogInterface dialogInterface, int i) {
        openFragment(new H2HFragment(), this.h2hfrag);
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
