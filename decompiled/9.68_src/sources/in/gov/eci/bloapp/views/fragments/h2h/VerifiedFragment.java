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
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentVerifiedHouseBinding;
import in.gov.eci.bloapp.databinding.BloH2hFilterBinding;
import in.gov.eci.bloapp.databinding.BloVerifiedRvItemBinding;
import in.gov.eci.bloapp.model.app_model.HouseModel;
import in.gov.eci.bloapp.model.app_model.VerifiedModel1;
import in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.Statement4;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class VerifiedFragment extends BaseFragment {
    private GenericRecyclerView adapter;
    String asmblyNO;
    BloFragmentVerifiedHouseBinding binding;
    String[] currencies;
    ElectorDetailsDatabaseHelper electorDetailsDatabaseHelper;
    BloH2hFilterBinding h2hFilterBinding;
    JSONParser parser;
    private String partNo;
    private String sectionNumber;
    String stateCode;
    private List<VerifiedModel1> verifiedList;
    private String token = "";
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();
    ArrayList<String> sectionNolist = new ArrayList<>();
    private JSONArray jsonArray11 = null;
    String sectionNumberstr = "Section No.- ";
    String selectsecNo = "Select Section No. & Name";
    String selectAll = "Select All";
    String verifyHousecount = "Verified House count (";
    String sectionNameString = "sectionName";
    String houseNameConsStr = "houseno";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentVerifiedHouseBinding.inflate(getLayoutInflater());
        this.verifiedList = new ArrayList();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        alertDialogCreate.setView(viewInflate);
        this.binding.searchverified.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.VerifiedFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.electorDetailsDatabaseHelper = ElectorDetailsDatabaseHelper.getDB(requireContext());
        this.binding.sectionNumber.setText(this.sectionNumberstr + "All");
        if (SharedPref.getInstance(requireContext()).getIsOnline().equals("N")) {
            List<HouseModel> allVerifiedElectorDetails = this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getAllVerifiedElectorDetails(this.partNo);
            for (int i = 0; i < allVerifiedElectorDetails.size(); i++) {
                Log.d("TAG", "Non Verified Elector details ---> " + allVerifiedElectorDetails.get(i).getHouseNo());
            }
            String json = new Gson().toJson(allVerifiedElectorDetails);
            JSONParser jSONParser = new JSONParser();
            this.parser = jSONParser;
            try {
                JSONArray jSONArray = (JSONArray) jSONParser.parse(json);
                this.jsonArray11 = jSONArray;
                renderingdata(jSONArray);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            JSONParser jSONParser2 = new JSONParser();
            this.parser = jSONParser2;
            try {
                this.jsonArray11 = (JSONArray) jSONParser2.parse(SharedPref.getInstance(getActivity()).getAllHousesData());
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
            renderingdataonline(this.jsonArray11);
        }
        this.binding.filter.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.VerifiedFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        openFragment(new SearchVerifiedHouseFragment());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        Constants.h2hflag = 1;
        if (!SharedPref.getInstance(requireContext()).getSectionData().equals("")) {
            try {
                this.sectionNolist.clear();
                this.sectionNolist.add(this.selectsecNo);
                this.sectionNolist.add(this.selectAll);
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getSectionData());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.size(); i++) {
                    JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                    if (asJsonObject.get(this.sectionNameString) == null) {
                        this.sectionNumber = asJsonObject.get("sectionNo").getAsInt() + " - ";
                    } else {
                        this.sectionNumber = asJsonObject.get("sectionNo").getAsInt() + " - " + asJsonObject.get(this.sectionNameString).getAsString();
                    }
                    Log.d("SectionNo ", this.sectionNumber);
                    arrayList.add(String.valueOf(this.sectionNumber));
                }
                Collections.sort(arrayList, new Comparator() { // from class: in.gov.eci.bloapp.views.fragments.h2h.VerifiedFragment$$ExternalSyntheticLambda5
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return VerifiedFragment.lambda$onCreateView$1((String) obj, (String) obj2);
                    }
                });
                this.sectionNolist.addAll(arrayList);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            getSection(this.stateCode, this.token, this.asmblyNO, this.partNo);
        }
        if (SharedPref.getInstance(requireContext()).getIsOnline().equals("Y")) {
            showFilteronline();
        } else {
            showFilter();
        }
    }

    static /* synthetic */ int lambda$onCreateView$1(String str, String str2) {
        return Integer.parseInt(str.split("-")[0].trim()) - Integer.parseInt(str2.split("-")[0].trim());
    }

    private void showFilteronline() {
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
        this.h2hFilterBinding.sectionNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.VerifiedFragment.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        this.h2hFilterBinding.filterButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.VerifiedFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showFilteronline$3(dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFilteronline$3(Dialog dialog, View view) {
        if (!this.h2hFilterBinding.sectionNo.getSelectedItem().toString().equals(this.selectsecNo)) {
            if (this.h2hFilterBinding.sectionNo.getSelectedItem().toString().equals(this.selectAll)) {
                JSONParser jSONParser = new JSONParser();
                this.parser = jSONParser;
                try {
                    this.jsonArray11 = (JSONArray) jSONParser.parse(SharedPref.getInstance(getActivity()).getAllHousesData());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                renderingdataonline(this.jsonArray11);
            } else {
                this.currencies = this.h2hFilterBinding.sectionNo.getSelectedItem().toString().split(StringUtils.SPACE);
                JSONParser jSONParser2 = new JSONParser();
                this.parser = jSONParser2;
                try {
                    this.jsonArray11 = (JSONArray) jSONParser2.parse(SharedPref.getInstance(getActivity()).getAllHousesData());
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
                filterHouseFetchOnline(this.currencies[0], this.jsonArray11);
            }
            dialog.dismiss();
            return;
        }
        showDialog();
    }

    public void filterHouseFetchOnline(String sectionNumber, JSONArray allverifiedHouses) {
        this.verifiedList.clear();
        for (int i = 0; i < allverifiedHouses.size(); i++) {
            JsonObject asJsonObject = this.gson.toJsonTree(allverifiedHouses.get(i)).getAsJsonObject();
            String strReplace = "";
            String strReplace2 = asJsonObject.get("houseNo").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
            String strReplace3 = asJsonObject.get("memberCount").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
            String strReplace4 = asJsonObject.get("isVerified").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
            String strReplace5 = asJsonObject.get("secNo").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
            if (asJsonObject.has("secName")) {
                String string = asJsonObject.get("secName").toString();
                if (!string.isEmpty() && !string.equals("null")) {
                    strReplace = asJsonObject.get("secName").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                }
            }
            String str = strReplace;
            if (strReplace4.equals("Y") && sectionNumber.equals(strReplace5)) {
                this.verifiedList.add(new VerifiedModel1(strReplace2, strReplace3, strReplace4, str, strReplace5));
            }
        }
        this.binding.sectionNumber.setText(this.sectionNumberstr + "All\n" + this.verifyHousecount + this.verifiedList.size() + ")");
        initRecyclerViewAdapter();
        this.binding.verifiedRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.verifiedRv.setAdapter(this.adapter);
    }

    public void renderingdataonline(JSONArray verifiedHouses) {
        this.verifiedList.clear();
        for (int i = 0; i < verifiedHouses.size(); i++) {
            try {
                JsonObject asJsonObject = this.gson.toJsonTree(verifiedHouses.get(i)).getAsJsonObject();
                String string = asJsonObject.get("houseNo").toString();
                String strReplace = asJsonObject.get("memberCount").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace2 = asJsonObject.get("isVerified").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace3 = asJsonObject.get("secNo").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace4 = asJsonObject.get("secName").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                if (strReplace2.equals("Y")) {
                    this.verifiedList.add(new VerifiedModel1(string, strReplace, strReplace2, strReplace4, strReplace3));
                }
            } catch (Exception e) {
                Logger.d("Verified_frag", e.getMessage());
                Logger.d("error", "Failed to read");
                return;
            }
        }
        this.binding.sectionNumber.setText(this.sectionNumberstr + "All\n" + this.verifyHousecount + this.verifiedList.size() + ")");
        initRecyclerViewAdapter();
        this.binding.verifiedRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.verifiedRv.setAdapter(this.adapter);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.VerifiedFragment$2, reason: invalid class name */
    class AnonymousClass2 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass2() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloVerifiedRvItemBinding.inflate(VerifiedFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
            ((BloVerifiedRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloVerifiedRvItemBinding) holder.binding).HNoTv.setText("H. No. " + ((VerifiedModel1) VerifiedFragment.this.verifiedList.get(position)).getHouseno());
            ((BloVerifiedRvItemBinding) holder.binding).NoOfPeopleValueET.setText(((VerifiedModel1) VerifiedFragment.this.verifiedList.get(position)).getNoofpeople());
            ((BloVerifiedRvItemBinding) holder.binding).secn.setText(((VerifiedModel1) VerifiedFragment.this.verifiedList.get(position)).getSecNo() + "-" + ((VerifiedModel1) VerifiedFragment.this.verifiedList.get(position)).getSecName());
            ((BloVerifiedRvItemBinding) holder.binding).VerifiedTv.setText("Verified");
            if (SharedPref.getInstance(VerifiedFragment.this.requireContext()).getIsOnline().equals("N")) {
                ((BloVerifiedRvItemBinding) holder.binding).addprop.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.VerifiedFragment$2$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onBindViewHolder$0(position, view);
                    }
                });
            } else {
                ((BloVerifiedRvItemBinding) holder.binding).addprop.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i, View view) {
            Constants.h2hflag = 1;
            Intent intent = new Intent(view.getContext(), (Class<?>) Statement4.class);
            intent.putExtra(VerifiedFragment.this.houseNameConsStr, ((VerifiedModel1) VerifiedFragment.this.verifiedList.get(i)).getHouseno());
            intent.putExtra("sectionNo", ((VerifiedModel1) VerifiedFragment.this.verifiedList.get(i)).getSecNo());
            VerifiedFragment.this.startActivity(intent);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return VerifiedFragment.this.verifiedList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass2());
        this.binding.verifiedRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.verifiedRv.setAdapter(this.adapter);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004c  */
    public void renderingdata(JSONArray verifiedHouses) {
        String string;
        this.verifiedList.clear();
        for (int i = 0; i < verifiedHouses.size(); i++) {
            try {
                JSONObject jSONObject = new JSONObject(verifiedHouses.get(i).toString());
                String strReplace = "";
                if (jSONObject.has(this.houseNameConsStr)) {
                    String string2 = jSONObject.get(this.houseNameConsStr).toString();
                    if (string2.isEmpty() || string2.equals("null")) {
                        string = "";
                    } else {
                        string = jSONObject.get(this.houseNameConsStr).toString();
                    }
                } else {
                    string = "";
                }
                String strReplace2 = jSONObject.get("noofpeople").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace3 = jSONObject.get("sectionNumber").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                if (jSONObject.has(this.sectionNameString)) {
                    String string3 = jSONObject.get(this.sectionNameString).toString();
                    if (!string3.isEmpty() && !string3.equals("null")) {
                        strReplace = jSONObject.get(this.sectionNameString).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                    }
                }
                this.verifiedList.add(new VerifiedModel1(string, strReplace2, "Y", strReplace, strReplace3));
            } catch (Exception e) {
                Logger.d("Verified_frag", e.getMessage());
                Logger.d("error", "Failed to read");
                return;
            }
        }
        this.binding.sectionNumber.setText(this.sectionNumberstr + "All\n" + this.verifyHousecount + this.verifiedList.size() + ")");
        initRecyclerViewAdapter();
        this.binding.verifiedRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.verifiedRv.setAdapter(this.adapter);
    }

    private void showFilter() {
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
        this.h2hFilterBinding.sectionNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.VerifiedFragment.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        this.h2hFilterBinding.filterButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.VerifiedFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showFilter$4(dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFilter$4(Dialog dialog, View view) {
        if (!this.h2hFilterBinding.sectionNo.getSelectedItem().toString().equals(this.selectsecNo)) {
            List<HouseModel> allVerifiedElectorDetails = this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getAllVerifiedElectorDetails(this.partNo);
            for (int i = 0; i < allVerifiedElectorDetails.size(); i++) {
                Log.d("TAG", "Data districtName ---> " + allVerifiedElectorDetails.get(i).getSectionName());
            }
            String json = new Gson().toJson(allVerifiedElectorDetails);
            Log.d("TAG", "Data jsonArray ---> " + json);
            JSONParser jSONParser = new JSONParser();
            this.parser = jSONParser;
            try {
                this.jsonArray11 = (JSONArray) jSONParser.parse(json);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (this.h2hFilterBinding.sectionNo.getSelectedItem().toString().equals(this.selectAll)) {
                renderingdata(this.jsonArray11);
                dialog.dismiss();
                return;
            } else {
                String[] strArrSplit = this.h2hFilterBinding.sectionNo.getSelectedItem().toString().split(StringUtils.SPACE);
                this.currencies = strArrSplit;
                filterHouseFetch(strArrSplit[0], this.jsonArray11);
                dialog.dismiss();
                return;
            }
        }
        showDialog();
    }

    private void showDialog() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage("Please select section number.");
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.VerifiedFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public void getSection(String stateCode, String token, String asmblyNo, String partNo) {
        try {
            this.sectionNolist.clear();
            this.sectionNolist.add(this.selectsecNo);
            this.sectionNolist.add(this.selectAll);
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getSection("ANDROIDMOB", token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode, "application/json", asmblyNo, partNo).enqueue(new AnonymousClass4());
        } catch (Exception e) {
            Logger.d("Content", e.getMessage());
            showProgressInVisible();
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.VerifiedFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JSONArray> {
        AnonymousClass4() {
        }

        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            if (response.code() == 200) {
                JSONArray jSONArray = (JSONArray) response.body();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.size(); i++) {
                    JsonObject asJsonObject = VerifiedFragment.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                    if (asJsonObject.get(VerifiedFragment.this.sectionNameString) == null) {
                        VerifiedFragment.this.sectionNumber = asJsonObject.get("sectionNo").getAsInt() + " - ";
                    } else {
                        VerifiedFragment.this.sectionNumber = asJsonObject.get("sectionNo").getAsInt() + " - " + asJsonObject.get(VerifiedFragment.this.sectionNameString).getAsString();
                    }
                    arrayList.add(VerifiedFragment.this.sectionNumber);
                }
                Collections.sort(arrayList, new Comparator() { // from class: in.gov.eci.bloapp.views.fragments.h2h.VerifiedFragment$4$$ExternalSyntheticLambda0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return VerifiedFragment.AnonymousClass4.lambda$onResponse$0((String) obj, (String) obj2);
                    }
                });
                VerifiedFragment.this.sectionNolist.addAll(arrayList);
            } else {
                try {
                    VerifiedFragment.this.commomUtility.showMessageWithTitleOK(VerifiedFragment.this.requireContext(), "Section Error - " + response.code(), new JSONObject(response.errorBody().string()).optString("message"), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.VerifiedFragment$4$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.dismiss();
                        }
                    });
                } catch (IOException | JSONException e) {
                    VerifiedFragment.this.commomUtility.showMessageWithTitleOK(VerifiedFragment.this.requireContext(), "Section Error - " + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.VerifiedFragment$4$$ExternalSyntheticLambda2
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.dismiss();
                        }
                    });
                    Logger.d("", e.getMessage());
                }
            }
            VerifiedFragment.this.showProgressInVisible();
        }

        static /* synthetic */ int lambda$onResponse$0(String str, String str2) {
            return Integer.parseInt(str.split("-")[0].trim()) - Integer.parseInt(str2.split("-")[0].trim());
        }

        public void onFailure(Call<JSONArray> call, Throwable t) {
            VerifiedFragment.this.showProgressInVisible();
        }
    }

    public void filterHouseFetch(String sectionNumber, JSONArray allverifiedHouses) {
        this.verifiedList.clear();
        for (int i = 0; i < allverifiedHouses.size(); i++) {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(allverifiedHouses.get(i).toString());
                    String strReplace = jSONObject.get(this.houseNameConsStr).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                    String strReplace2 = jSONObject.get("noofpeople").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                    String strReplace3 = jSONObject.get("sectionNumber").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                    String strReplace4 = jSONObject.get(this.sectionNameString).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                    if (sectionNumber.equals(strReplace3)) {
                        this.verifiedList.add(new VerifiedModel1(strReplace, strReplace2, "Y", strReplace4, strReplace3));
                    }
                } catch (NullPointerException e) {
                    e = e;
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (NullPointerException | JSONException e3) {
                e = e3;
            }
        }
        this.binding.sectionNumber.setText(this.sectionNumberstr + sectionNumber + "\n" + this.verifyHousecount + this.verifiedList.size() + ")");
        initRecyclerViewAdapter();
        this.binding.verifiedRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.verifiedRv.setAdapter(this.adapter);
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, "Search Verified Houses");
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }
}
