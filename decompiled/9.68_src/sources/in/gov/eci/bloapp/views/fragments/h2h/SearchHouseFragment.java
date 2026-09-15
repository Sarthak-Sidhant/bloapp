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
import android.widget.Filter;
import android.widget.SearchView;
import androidx.activity.OnBackPressedCallback;
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
import in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.databinding.BloAllHousesRvItem1Binding;
import in.gov.eci.bloapp.databinding.BloFragmentSearchHouseBinding;
import in.gov.eci.bloapp.model.app_model.AllHousesModel;
import in.gov.eci.bloapp.model.app_model.HouseModel;
import in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.Statement4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
public class SearchHouseFragment extends Fragment {
    private FilterableRecyclerView adapter;
    AlertDialog alertDialog;
    private AlertDialog alertDialog1;
    private BloFragmentSearchHouseBinding binding;
    private String bloStatecode;
    private String bloassemcode;
    private String blopartNumber;
    Retrofit.Builder builder;
    ElectorDetailsDatabaseHelper electorDetailsDatabaseHelper;
    String houseNumberCons;
    JSONArray jsonArray11;
    private ArrayList<AllHousesModel> mSearchList;
    JSONParser parser;
    private String partNo;
    private JSONArray payloadSearchHouses;
    Retrofit retrofit;
    private ArrayList<AllHousesModel> searchList;
    ArrayList<String> sec;
    String sectionNameCons;
    private String token;
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public SearchHouseFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.jsonArray11 = null;
        this.token = "";
        this.payloadSearchHouses = null;
        this.blopartNumber = "";
        this.bloStatecode = "";
        this.bloassemcode = "";
        this.houseNumberCons = "houseno";
        this.sectionNameCons = "sectionName";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentSearchHouseBinding.inflate(getLayoutInflater());
        this.sec = new ArrayList<>();
        this.searchList = new ArrayList<>();
        this.mSearchList = new ArrayList<>();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog1 = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog1.setCancelable(false);
        this.alertDialog1.setView(viewInflate);
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchHouseFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchHouseFragment.1
            public void handleOnBackPressed() {
                Constants.h2hflag2 = 1;
                SearchHouseFragment.this.openFragment(new H2HFragment(), "HOUSE FRAGMENT");
            }
        });
        this.bloassemcode = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.bloStatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.blopartNumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.binding.ndata.setVisibility(0);
        this.electorDetailsDatabaseHelper = ElectorDetailsDatabaseHelper.getDB(requireContext());
        if (SharedPref.getInstance(requireContext()).getIsOnline().equals("N")) {
            this.binding.home.setImageResource(R.drawable.blo_outline_home_24_red);
            eroHouseFetchoffline();
        } else {
            this.binding.home.setImageResource(R.drawable.blo_outline_home_24_green);
            if (Constants.h2hflag2 == 0) {
                eroHouseFetch();
            } else {
                JSONParser jSONParser = new JSONParser();
                this.parser = jSONParser;
                try {
                    JSONArray jSONArray = (JSONArray) jSONParser.parse(SharedPref.getInstance(getActivity()).getSearchedAllHousesData());
                    this.jsonArray11 = jSONArray;
                    renderingdata(jSONArray);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        initCLickListener();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        Constants.h2hflag2 = 1;
        openFragment(new H2HFragment(), "H2HFRAGMENT FRAGMENT");
    }

    private void initCLickListener() {
        this.binding.home.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchHouseFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$1(view);
            }
        });
        this.binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchHouseFragment.2
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                try {
                    SearchHouseFragment.this.adapter.getFilter().filter(newText);
                    SearchHouseFragment.this.binding.ndata.setVisibility(8);
                    SearchHouseFragment.this.binding.searchListRv.setVisibility(0);
                } catch (Exception e) {
                    Logger.d("tag", e.getMessage());
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$1(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    public void eroHouseFetch() {
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put("stCode", this.bloStatecode);
        map.put("acNo", this.bloassemcode);
        map.put("partNo", this.blopartNumber);
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).eroHouseFetch1(this.token, "blo", this.bloStatecode, "application/json", "ANDROIDMOB", map).enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.SearchHouseFragment$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<EronetResponse> {
        AnonymousClass3() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.body() != null) {
                SearchHouseFragment.this.payloadSearchHouses = ((EronetResponse) response.body()).getPayload();
                if (SearchHouseFragment.this.payloadSearchHouses.isEmpty()) {
                    return;
                }
                SharedPref.getInstance(SearchHouseFragment.this.getContext()).setSearchedAllHousesData(SearchHouseFragment.this.payloadSearchHouses.toString());
                SearchHouseFragment searchHouseFragment = SearchHouseFragment.this;
                searchHouseFragment.renderingdata(searchHouseFragment.payloadSearchHouses);
                SearchHouseFragment.this.alertDialog1.dismiss();
                return;
            }
            try {
                SearchHouseFragment.this.showDialog1(response.code() + "  " + new JSONObject(response.errorBody().string()).optString("message"));
            } catch (Exception e) {
                Logger.d("tag11", e.getMessage());
                Logger.d("tag11", "" + response.code());
                if (response.code() == 401) {
                    SearchHouseFragment.this.commomUtility.showMessageWithTitleOK(SearchHouseFragment.this.requireContext(), "Alert", "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchHouseFragment$3$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                } else if (response.message() != null) {
                    SearchHouseFragment.this.showDialog1(response.code() + StringUtils.SPACE + response.message());
                } else {
                    SearchHouseFragment.this.showDialog1("No Data Found");
                }
            }
            SearchHouseFragment.this.alertDialog1.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SearchHouseFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SearchHouseFragment.this.getContext()).setLocaleBool(false);
            SearchHouseFragment.this.startActivity(new Intent((Context) SearchHouseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            SearchHouseFragment.this.alertDialog.dismiss();
            SearchHouseFragment.this.showDialog1(t.getMessage());
        }
    }

    public void eroHouseFetchoffline() {
        List<HouseModel> allSearchElectorDetails1 = this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getAllSearchElectorDetails1(this.partNo);
        for (int i = 0; i < allSearchElectorDetails1.size(); i++) {
            Log.d("TAG", "Data SearchElector details ---> " + allSearchElectorDetails1.get(i).getSectionName());
        }
        String json = new Gson().toJson(allSearchElectorDetails1);
        Log.d("TAG", "Data jsonArray ---> " + json);
        JSONParser jSONParser = new JSONParser();
        this.parser = jSONParser;
        try {
            JSONArray jSONArray = (JSONArray) jSONParser.parse(json);
            this.jsonArray11 = jSONArray;
            renderingSearchdata(jSONArray);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.SearchHouseFragment$4, reason: invalid class name */
    class AnonymousClass4 implements FilterableRecyclerView.FilterGenericRecyclerAdapterInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass4() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloAllHousesRvItem1Binding.inflate(SearchHouseFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
            ((BloAllHousesRvItem1Binding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloAllHousesRvItem1Binding) holder.binding).HNoTv.setText("H. No. " + ((AllHousesModel) SearchHouseFragment.this.mSearchList.get(position)).getHouseNo());
            ((BloAllHousesRvItem1Binding) holder.binding).VerifiedTv.setText("Verified");
            ((BloAllHousesRvItem1Binding) holder.binding).secn.setText(((AllHousesModel) SearchHouseFragment.this.mSearchList.get(position)).getSectionNumber() + "-" + ((AllHousesModel) SearchHouseFragment.this.mSearchList.get(position)).getSectionName());
            ((BloAllHousesRvItem1Binding) holder.binding).VerifiedTickTv.setVisibility(0);
            ((BloAllHousesRvItem1Binding) holder.binding).nametv.setText(((AllHousesModel) SearchHouseFragment.this.mSearchList.get(position)).getApplicantName() + " (" + ((AllHousesModel) SearchHouseFragment.this.mSearchList.get(position)).getNoofpeople() + ")");
            final String str = ((AllHousesModel) SearchHouseFragment.this.mSearchList.get(position)).houseno;
            ((BloAllHousesRvItem1Binding) holder.binding).viewfamily.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchHouseFragment$4$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(str, position, view);
                }
            });
            ((BloAllHousesRvItem1Binding) holder.binding).addprop.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchHouseFragment$4$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(str, position, view);
                }
            });
            ((BloAllHousesRvItem1Binding) holder.binding).button.setVisibility(8);
            if ("Y".equals(((AllHousesModel) SearchHouseFragment.this.mSearchList.get(position)).getStatus())) {
                return;
            }
            ((BloAllHousesRvItem1Binding) holder.binding).VerifiedTickTv.setVisibility(8);
            ((BloAllHousesRvItem1Binding) holder.binding).layout.setBackgroundResource(R.drawable.blo_rectangle1);
            ((BloAllHousesRvItem1Binding) holder.binding).VerifiedTv.setText("");
            ((BloAllHousesRvItem1Binding) holder.binding).button.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, int i, View view) {
            Bundle bundle = new Bundle();
            bundle.putString(SearchHouseFragment.this.houseNumberCons, str);
            bundle.putString("secNo", ((AllHousesModel) SearchHouseFragment.this.mSearchList.get(i)).getSectionNumber());
            bundle.putString("bak", "2");
            Constants.h2hflag2 = 1;
            HouseNumberFragment houseNumberFragment = new HouseNumberFragment();
            houseNumberFragment.setArguments(bundle);
            SearchHouseFragment.this.openFragment(houseNumberFragment, "House Details");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(String str, int i, View view) {
            Constants.h2hflag2 = 1;
            Intent intent = new Intent(view.getContext(), (Class<?>) Statement4.class);
            intent.putExtra(SearchHouseFragment.this.houseNumberCons, str);
            intent.putExtra("sectionNo", ((AllHousesModel) SearchHouseFragment.this.mSearchList.get(i)).getSectionNumber());
            SearchHouseFragment.this.startActivity(intent);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemCount() {
            return SearchHouseFragment.this.mSearchList.size();
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public Filter getFilter() {
            return new Filter() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchHouseFragment.4.1
                @Override // android.widget.Filter
                protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                    String strTrim = String.valueOf(charSequence).trim();
                    if (strTrim.length() == 0) {
                        SearchHouseFragment.this.mSearchList = SearchHouseFragment.this.searchList;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (AllHousesModel allHousesModel : SearchHouseFragment.this.mSearchList) {
                            if (allHousesModel.houseno.toLowerCase(Locale.ROOT).contains(strTrim.toLowerCase(Locale.ROOT).trim())) {
                                arrayList.add(allHousesModel);
                            } else if (allHousesModel.applicantName.toLowerCase(Locale.ROOT).contains(strTrim.toLowerCase(Locale.ROOT).trim())) {
                                arrayList.add(allHousesModel);
                            } else if (allHousesModel.noofpeople.toLowerCase(Locale.ROOT).contains(strTrim.toLowerCase(Locale.ROOT).trim())) {
                                arrayList.add(allHousesModel);
                            }
                        }
                        SearchHouseFragment.this.mSearchList = arrayList;
                        if (SearchHouseFragment.this.mSearchList.isEmpty()) {
                            SearchHouseFragment.this.binding.ndata.setVisibility(0);
                            SearchHouseFragment.this.binding.searchListRv.setVisibility(8);
                            SearchHouseFragment.this.binding.ndata.setText("No data found");
                        } else {
                            SearchHouseFragment.this.binding.searchListRv.setVisibility(0);
                            SearchHouseFragment.this.binding.ndata.setVisibility(8);
                        }
                    }
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    filterResults.values = SearchHouseFragment.this.mSearchList;
                    return filterResults;
                }

                @Override // android.widget.Filter
                protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    SearchHouseFragment.this.adapter.notifyDataSetChanged();
                }
            };
        }
    }

    private void initRecyclerViewAdapter() {
        this.mSearchList = this.searchList;
        this.adapter = new FilterableRecyclerView(new AnonymousClass4());
        this.binding.searchListRv.setLayoutManager(new GridLayoutManager(getContext(), 1, 1, false));
        this.binding.searchListRv.setAdapter(this.adapter);
    }

    public void renderingdata(JSONArray allHouses) {
        this.searchList.clear();
        this.sec.clear();
        for (int i = 0; i < allHouses.size(); i++) {
            try {
                JsonObject asJsonObject = this.gson.toJsonTree(allHouses.get(i)).getAsJsonObject();
                this.searchList.add(new AllHousesModel(asJsonObject.get("houseNo").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE), asJsonObject.get("memberCount").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE), asJsonObject.get("isVerified").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE), asJsonObject.get("applicantName").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE), asJsonObject.get("secNo").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE), asJsonObject.get("secName").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE)));
            } catch (Exception e) {
                Logger.d("search_house_frag", e.getMessage());
                Logger.d("error", "Failed to read");
                return;
            }
        }
        initRecyclerViewAdapter();
        this.binding.searchListRv.setLayoutManager(new GridLayoutManager(getContext(), 1, 1, false));
        this.binding.searchListRv.setAdapter(this.adapter);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0087  */
    public void renderingSearchdata(JSONArray allHouses) {
        String strReplace;
        this.searchList.clear();
        this.sec.clear();
        for (int i = 0; i < allHouses.size(); i++) {
            try {
                JSONObject jSONObject = new JSONObject(allHouses.get(i).toString());
                String string = jSONObject.get(this.houseNumberCons).toString();
                String strReplace2 = jSONObject.get("noofpeople").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace3 = jSONObject.get("sectionNumber").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                if (jSONObject.has(this.sectionNameCons)) {
                    String string2 = jSONObject.get(this.sectionNameCons).toString();
                    if (string2.isEmpty() || string2.equals("null")) {
                        strReplace = "";
                    } else {
                        strReplace = jSONObject.get(this.sectionNameCons).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                    }
                } else {
                    strReplace = "";
                }
                this.searchList.add(new AllHousesModel(string, strReplace2, "N", jSONObject.get("applicantName").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE), strReplace3, strReplace));
            } catch (Exception e) {
                Logger.d("search_house_frag", e.getMessage());
                Logger.d("error", "Failed to read");
                return;
            }
        }
        initRecyclerViewAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog1(String message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchHouseFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$2(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$2(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(getContext(), (Class<?>) MainActivity.class));
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
