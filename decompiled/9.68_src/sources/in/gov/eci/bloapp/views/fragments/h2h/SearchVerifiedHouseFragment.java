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
import in.gov.eci.bloapp.databinding.BloFragmentSearchVerifiedHouseBinding;
import in.gov.eci.bloapp.model.app_model.AllHousesModel;
import in.gov.eci.bloapp.model.app_model.HouseModel;
import in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
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
public class SearchVerifiedHouseFragment extends Fragment {
    private FilterableRecyclerView adapter;
    private AlertDialog alertDialog;
    String applicantNameConsStr;
    private BloFragmentSearchVerifiedHouseBinding binding;
    Retrofit.Builder builder;
    ElectorDetailsDatabaseHelper electorDetailsDatabaseHelper;
    JSONArray jsonArray11;
    private ArrayList<AllHousesModel> mSearchList;
    JSONParser parser;
    private String partNo;
    Retrofit retrofit;
    private ArrayList<AllHousesModel> searchList;
    String sectionNameConsStr;
    private String token = "";
    private JSONArray payloadSearchHouses = null;
    private String blopartNumber = "";
    private String bloStatecode = "";
    private String bloassemcode = "";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public SearchVerifiedHouseFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.jsonArray11 = null;
        this.sectionNameConsStr = "sectionName";
        this.applicantNameConsStr = "applicantName";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentSearchVerifiedHouseBinding.inflate(getLayoutInflater());
        requireActivity().findViewById(R.id.searchverified).setVisibility(8);
        this.searchList = new ArrayList<>();
        this.mSearchList = new ArrayList<>();
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchVerifiedHouseFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchVerifiedHouseFragment.1
            public void handleOnBackPressed() {
                SearchVerifiedHouseFragment.this.openFragment(new H2HFragment(), "HOUSE FRAGMENT");
            }
        });
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.bloassemcode = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.bloStatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.blopartNumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.electorDetailsDatabaseHelper = ElectorDetailsDatabaseHelper.getDB(requireContext());
        if (SharedPref.getInstance(requireContext()).getIsOnline().equals("N")) {
            eroHouseFetchoffline();
        } else {
            eroHouseFetch();
            JSONParser jSONParser = new JSONParser();
            this.parser = jSONParser;
            try {
                this.jsonArray11 = (JSONArray) jSONParser.parse(SharedPref.getInstance(getActivity()).getAllHousesData());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            renderingdata(this.jsonArray11);
        }
        initCLickListener();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        openFragment(new H2HFragment(), "H2HFRAGMENT FRAGMENT");
    }

    private void initCLickListener() {
        this.binding.home.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchVerifiedHouseFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$1(view);
            }
        });
        this.binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchVerifiedHouseFragment.2
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                SearchVerifiedHouseFragment.this.adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$1(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    public void eroHouseFetch() {
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put("stCode", this.bloStatecode);
        map.put("acNo", this.bloassemcode);
        map.put("partNo", this.blopartNumber);
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).eroHouseFetch1(this.token, "blo", this.bloStatecode, "application/json", "ANDROIDMOB", map).enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.SearchVerifiedHouseFragment$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<EronetResponse> {
        public void onFailure(Call<EronetResponse> call, Throwable t) {
        }

        AnonymousClass3() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.body() != null) {
                SearchVerifiedHouseFragment.this.payloadSearchHouses = ((EronetResponse) response.body()).getPayload();
                if (SearchVerifiedHouseFragment.this.payloadSearchHouses.isEmpty()) {
                    return;
                }
                SearchVerifiedHouseFragment searchVerifiedHouseFragment = SearchVerifiedHouseFragment.this;
                searchVerifiedHouseFragment.renderingdata(searchVerifiedHouseFragment.payloadSearchHouses);
                SearchVerifiedHouseFragment.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                SearchVerifiedHouseFragment.this.commomUtility.showMessageWithTitleOK(SearchVerifiedHouseFragment.this.requireContext(), "Alert", "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchVerifiedHouseFragment$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
            } else if (response.code() == 504) {
                SearchVerifiedHouseFragment.this.showDialog1(response.code() + "  " + response.message());
            }
            SearchVerifiedHouseFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SearchVerifiedHouseFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SearchVerifiedHouseFragment.this.getContext()).setLocaleBool(false);
            SearchVerifiedHouseFragment.this.startActivity(new Intent((Context) SearchVerifiedHouseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }
    }

    public void eroHouseFetchoffline() {
        List<HouseModel> allVerifiedSearchElectorDetails1 = this.electorDetailsDatabaseHelper.partElectorDetailsModelDao().getAllVerifiedSearchElectorDetails1(this.partNo);
        for (int i = 0; i < allVerifiedSearchElectorDetails1.size(); i++) {
            Log.d("TAG", "Data SearchElector details ---> " + allVerifiedSearchElectorDetails1.get(i).getSectionName());
        }
        String json = new Gson().toJson(allVerifiedSearchElectorDetails1);
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

    private void initRecyclerViewAdapter() {
        this.mSearchList = this.searchList;
        this.adapter = new FilterableRecyclerView(new FilterableRecyclerView.FilterGenericRecyclerAdapterInterface() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchVerifiedHouseFragment.4
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(BloAllHousesRvItem1Binding.inflate(SearchVerifiedHouseFragment.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                ((BloAllHousesRvItem1Binding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
                ((BloAllHousesRvItem1Binding) holder.binding).HNoTv.setText("H. No. " + ((AllHousesModel) SearchVerifiedHouseFragment.this.mSearchList.get(position)).getHouseNo());
                ((BloAllHousesRvItem1Binding) holder.binding).VerifiedTv.setText("Verified");
                ((BloAllHousesRvItem1Binding) holder.binding).button.setVisibility(8);
                ((BloAllHousesRvItem1Binding) holder.binding).nametv.setText(((AllHousesModel) SearchVerifiedHouseFragment.this.mSearchList.get(position)).getApplicantName());
                ((BloAllHousesRvItem1Binding) holder.binding).secn.setText(((AllHousesModel) SearchVerifiedHouseFragment.this.mSearchList.get(position)).getSectionNumber() + "-" + ((AllHousesModel) SearchVerifiedHouseFragment.this.mSearchList.get(position)).getSectionName());
                if ("Y".equals(((AllHousesModel) SearchVerifiedHouseFragment.this.mSearchList.get(position)).getStatus())) {
                    return;
                }
                ((BloAllHousesRvItem1Binding) holder.binding).VerifiedTickTv.setVisibility(8);
                ((BloAllHousesRvItem1Binding) holder.binding).layout.setBackgroundResource(R.drawable.blo_rectangle1);
                ((BloAllHousesRvItem1Binding) holder.binding).VerifiedTv.setText("");
                ((BloAllHousesRvItem1Binding) holder.binding).button.setVisibility(8);
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public int getItemCount() {
                return SearchVerifiedHouseFragment.this.mSearchList.size();
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
            public Filter getFilter() {
                return new Filter() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchVerifiedHouseFragment.4.1
                    @Override // android.widget.Filter
                    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                        String strValueOf = String.valueOf(charSequence);
                        if (strValueOf.length() == 0) {
                            SearchVerifiedHouseFragment.this.mSearchList = SearchVerifiedHouseFragment.this.searchList;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            for (AllHousesModel allHousesModel : SearchVerifiedHouseFragment.this.mSearchList) {
                                if (allHousesModel.houseno.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                    arrayList.add(allHousesModel);
                                } else if (allHousesModel.applicantName.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                    arrayList.add(allHousesModel);
                                }
                            }
                            SearchVerifiedHouseFragment.this.mSearchList = arrayList;
                        }
                        Filter.FilterResults filterResults = new Filter.FilterResults();
                        filterResults.values = SearchVerifiedHouseFragment.this.mSearchList;
                        return filterResults;
                    }

                    @Override // android.widget.Filter
                    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                        SearchVerifiedHouseFragment.this.adapter.notifyDataSetChanged();
                    }
                };
            }
        });
        this.binding.searchListRv.setLayoutManager(new GridLayoutManager(getContext(), 1, 1, false));
        this.binding.searchListRv.setAdapter(this.adapter);
    }

    public void renderingdata(JSONArray allHouses) {
        this.searchList.clear();
        for (int i = 0; i < allHouses.size(); i++) {
            try {
                JsonObject asJsonObject = this.gson.toJsonTree(allHouses.get(i)).getAsJsonObject();
                String string = asJsonObject.get("houseNo").toString();
                String strReplace = asJsonObject.get("memberCount").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace2 = asJsonObject.get(this.applicantNameConsStr) == null ? "" : asJsonObject.get(this.applicantNameConsStr).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace3 = asJsonObject.get("isVerified").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace4 = asJsonObject.get("secNo").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace5 = asJsonObject.get("secName").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                if (strReplace3.equals("Y")) {
                    this.searchList.add(new AllHousesModel(string, strReplace, strReplace3, strReplace2, strReplace4, strReplace5));
                }
            } catch (Exception e) {
                Logger.d("search_house_frag", e.getMessage());
                Logger.d("error", "Failed to read");
                return;
            }
        }
        initRecyclerViewAdapter();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0084  */
    public void renderingSearchdata(JSONArray allHouses) {
        String strReplace;
        this.searchList.clear();
        for (int i = 0; i < allHouses.size(); i++) {
            try {
                JSONObject jSONObject = new JSONObject(allHouses.get(i).toString());
                String string = jSONObject.get("houseno").toString();
                String strReplace2 = jSONObject.get(this.applicantNameConsStr).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                String strReplace3 = jSONObject.get("sectionNumber").toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                if (jSONObject.has(this.sectionNameConsStr)) {
                    String string2 = jSONObject.get(this.sectionNameConsStr).toString();
                    if (string2.isEmpty() || string2.equals("null")) {
                        strReplace = "";
                    } else {
                        strReplace = jSONObject.get(this.sectionNameConsStr).toString().replaceAll("^\"|\"$", "").replace("null", StringUtils.SPACE);
                    }
                } else {
                    strReplace = "";
                }
                this.searchList.add(new AllHousesModel(string, "1", "Y", strReplace2, strReplace3, strReplace));
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
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.SearchVerifiedHouseFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$2(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$2(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(getContext(), (Class<?>) H2HFragment.class));
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
