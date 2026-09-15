package in.gov.eci.bloapp.views.fragments.pse;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallback;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.databinding.BloDsependingRvItemBinding;
import in.gov.eci.bloapp.databinding.BloForm8generatedRvItemBinding;
import in.gov.eci.bloapp.databinding.BloFormatABottomsheetBinding;
import in.gov.eci.bloapp.databinding.BloFormataPendingRvItemBinding;
import in.gov.eci.bloapp.databinding.BloFragmentSearchPseBinding;
import in.gov.eci.bloapp.model.app_model.clusterDetailsDseModel;
import in.gov.eci.bloapp.model.app_model.dsePendingModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.DseActivity;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import in.gov.eci.bloapp.views.fragments.pse.pseidentified.ClusterDetailsPseIdentifiedFragment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SearchPseFragment extends BaseFragment {
    private static final String ALERT = "Alert";
    private static final String ALL_HOUSES = "All houses";
    private static final String APPLICATION_JSON = "application/json";
    private static final String CLOSE = "Close";
    private static final String CLUSTER_BIFURCATION = "clusterBifurcation";
    private static final String CLUSTER_ID = "clusterId";
    private static final String COMING_IN_ON_FAILURE = "coming in onFailure ";
    private static final String DISTRICT_NAME_ENGLISH = "districtNameEnglish";
    private static final String EPIC_NO = "epicNo";
    private static final String EPIC_NUMBER = "epicNumber";
    private static final String ERROR_RESPONSE = "errorResponse";
    private static final String HOUSE_NUMBER = "houseNumber";
    private static final String HOUSE_NUMBER_FRAG = "house_number_frag";
    private static final String LOCALITY_STREET = "localityStreet";
    private static final String MESSAGE = "message";
    private static final String OTHER = "Other";
    private static final String PART_NO = "partNo";
    private static final String PIN_CODE = "pinCode";
    private static final String PIN_CODE_NEW = "poPin";
    private static final String PSE_ID = "pseId";
    private static final String SESSION_TOKEN_EXPIRED_PLEASE_LOGIN = "Session token expired please Login";
    private static final String STATE_NAME_ENGLISH = "stateNameEnglish";
    private static final String S_NO = "S. No. ";
    private static final String TOWN_VILLAGE = "townVillage";
    private static final String TOWN_VILLAGE_NEW = "townName";
    private static final String WHITE_COLOR = "#ffffff";
    private FilterableRecyclerView adapter;
    private String address;
    private JSONArray addressDetails;
    private AlertDialog alertDialog1;
    private String asmblyNO;
    BloFragmentSearchPseBinding binding;
    private Bitmap bitmap;
    private String blostatecode;
    Retrofit.Builder builder;
    private byte[] byteArray;
    private final CommomUtility commonUtilClass;
    private Dialog dialog;
    private String encodedImage;
    String filepathimg;
    private String flagValue;
    BloFormatABottomsheetBinding formatABottomsheetBinding;
    private ArrayList<clusterDetailsDseModel> mSearchList;
    private ArrayList<dsePendingModel> mSearchListIdentified;
    private String partNo;
    private JSONArray payloadSearchHouses;
    private String photoref;
    private String refreshToken;
    Retrofit retrofit;
    private ArrayList<clusterDetailsDseModel> searchList;
    private ArrayList<dsePendingModel> searchListIdentified;
    private String stateCode;
    private String token = "";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public SearchPseFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.payloadSearchHouses = null;
        this.blostatecode = "";
        this.photoref = " ";
        this.commonUtilClass = new CommomUtility();
        this.addressDetails = null;
        this.filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentSearchPseBinding.inflate(getLayoutInflater());
        this.searchList = new ArrayList<>();
        this.mSearchList = new ArrayList<>();
        this.searchListIdentified = new ArrayList<>();
        this.mSearchListIdentified = new ArrayList<>();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog1 = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog1.setCancelable(false);
        this.alertDialog1.setView(viewInflate);
        this.blostatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.flagValue = arguments.getString("Flag");
        }
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        if (this.flagValue.equals("0")) {
            psePendingList();
        } else if (this.flagValue.equals("1")) {
            pseDoneList();
        } else if (this.flagValue.equals("2") || this.flagValue.equals("3") || this.flagValue.equals("4")) {
            this.binding.textView3.setText("PSE Identified");
            pseWIthinPart();
        }
        initCLickListener();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        if (getFragmentManager().getBackStackEntryCount() != 0) {
            getFragmentManager().popBackStack();
        }
    }

    private void initCLickListener() {
        this.binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment.1
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                SearchPseFragment.this.adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    public JSONArray psePendingList() {
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put("acNo", this.asmblyNO);
        map.put(PART_NO, this.partNo);
        map.put("status", "pending");
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).pseForm8List(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", CLOSE, "blo", this.blostatecode, map).enqueue(new AnonymousClass2());
        return this.payloadSearchHouses;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<EronetResponse> {
        AnonymousClass2() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                if (((EronetResponse) response.body()).getPayload() != null) {
                    SearchPseFragment.this.payloadSearchHouses = ((EronetResponse) response.body()).getPayload();
                    if (!SearchPseFragment.this.payloadSearchHouses.isEmpty()) {
                        Logger.d("json12: ", String.valueOf(SearchPseFragment.this.gson.toJsonTree((LinkedTreeMap) SearchPseFragment.this.payloadSearchHouses.get(0)).getAsJsonObject()));
                        Logger.d("payload12: ", String.valueOf(SearchPseFragment.this.payloadSearchHouses));
                        SearchPseFragment searchPseFragment = SearchPseFragment.this;
                        searchPseFragment.renderingdata(searchPseFragment.payloadSearchHouses);
                        SearchPseFragment.this.alertDialog1.dismiss();
                        return;
                    }
                    SearchPseFragment.this.alertDialog1.dismiss();
                    return;
                }
                SearchPseFragment.this.alertDialog1.dismiss();
                return;
            }
            if (response.code() == 401) {
                SearchPseFragment.this.commomUtility.getRefreshToken(SearchPseFragment.this.getContext(), SearchPseFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$2$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(SearchPseFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(SearchPseFragment.ALL_HOUSES, e.getMessage());
            }
            SearchPseFragment.this.alertDialog1.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            SearchPseFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                SearchPseFragment.this.commomUtility.showMessageOK(SearchPseFragment.this.requireContext(), SearchPseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SearchPseFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setToken("Bearer " + str);
            SearchPseFragment.this.psePendingList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setLocaleBool(false);
            SearchPseFragment.this.startActivity(new Intent((Context) SearchPseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d(SearchPseFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public void renderingdata(JSONArray allHouses) {
        this.searchList.clear();
        for (int i = 0; i < allHouses.size(); i++) {
            try {
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) allHouses.get(i);
                String str = (String) linkedTreeMap.get(Constants.FIRST_NAME);
                String str2 = (String) linkedTreeMap.get(Constants.LAST_NAME);
                String str3 = (str == null || str.equals("null")) ? "" : str;
                String str4 = (str2 == null || str2.equals("null")) ? "" : str2;
                String str5 = (String) linkedTreeMap.get(EPIC_NO);
                String str6 = (String) linkedTreeMap.get("acNo");
                String str7 = (String) linkedTreeMap.get(PART_NO);
                String str8 = (String) linkedTreeMap.get("relationFirstName");
                String str9 = (String) linkedTreeMap.get("relationLastName");
                String str10 = (str8 == null || str8.equals("null")) ? "" : str8;
                String str11 = (str9 == null || str9.equals("null")) ? "" : str9;
                String str12 = (String) linkedTreeMap.get("relationType");
                String str13 = (String) linkedTreeMap.get("address");
                String str14 = (String) linkedTreeMap.get("slnoInPart");
                this.searchList.add(new clusterDetailsDseModel(str3, str4, str5, str6, str7, "", (String) linkedTreeMap.get("gender"), str10, str11, str12, str13, Integer.valueOf(str14), (String) linkedTreeMap.get(PSE_ID), (String) linkedTreeMap.get("dateOfInclusion"), "", (String) linkedTreeMap.get("photo"), (String) linkedTreeMap.get(CLUSTER_ID), "", "", 0));
            } catch (Exception e) {
                Logger.d(ALL_HOUSES, e.getMessage());
                return;
            }
        }
        initRecyclerViewAdapter();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$3, reason: invalid class name */
    class AnonymousClass3 implements FilterableRecyclerView.FilterGenericRecyclerAdapterInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass3() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloFormataPendingRvItemBinding.inflate(SearchPseFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            ((BloFormataPendingRvItemBinding) holder.binding).SerialNoTv.setText(SearchPseFragment.S_NO + (position + 1));
            ((BloFormataPendingRvItemBinding) holder.binding).HNoTv.setText(((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getClusterId());
            ((BloFormataPendingRvItemBinding) holder.binding).applicantName.setText(((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getApplicantFirstname() + " " + ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getApplicantLastname());
            ((BloFormataPendingRvItemBinding) holder.binding).epicnumber.setText(((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getEpicnumber());
            ((BloFormataPendingRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor(SearchPseFragment.WHITE_COLOR));
            final String str = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getApplicantFirstname() + " " + ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getApplicantLastname();
            final String str2 = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getRelationfirstname() + " " + ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getRelationlastname();
            final String relationtype = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getRelationtype();
            final String gender = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getGender();
            final String epicnumber = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getEpicnumber();
            final String pseid = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getPseid();
            final String partnumber = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getPartnumber();
            final String ac = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getAc();
            final String clusterId = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getClusterId();
            final String dateofinclusion = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getDateofinclusion();
            final String photo = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getPhoto();
            final String strReplace = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getAddress().replace(",{2,}", ",");
            ((BloFormataPendingRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$3$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(str, epicnumber, pseid, partnumber, gender, str2, relationtype, strReplace, ac, dateofinclusion, photo, clusterId, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, View view) {
            SearchPseFragment.this.bottomSheet(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, BitmapFactory.decodeResource(SearchPseFragment.this.getResources(), R.drawable.blo_dummy_image), str12);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemCount() {
            return SearchPseFragment.this.mSearchList.size();
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public Filter getFilter() {
            return new Filter() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment.3.1
                @Override // android.widget.Filter
                protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                    String strValueOf = String.valueOf(charSequence);
                    if (strValueOf.length() == 0) {
                        SearchPseFragment.this.mSearchList = SearchPseFragment.this.searchList;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (clusterDetailsDseModel clusterdetailsdsemodel : SearchPseFragment.this.mSearchList) {
                            if (clusterdetailsdsemodel.applicantFirstname.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT)) || clusterdetailsdsemodel.applicantLastname.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT)) || clusterdetailsdsemodel.epicnumber.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                arrayList.add(clusterdetailsdsemodel);
                            }
                        }
                        SearchPseFragment.this.mSearchList = arrayList;
                    }
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    filterResults.values = SearchPseFragment.this.mSearchList;
                    return filterResults;
                }

                @Override // android.widget.Filter
                protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    SearchPseFragment.this.adapter.notifyDataSetChanged();
                }
            };
        }
    }

    private void initRecyclerViewAdapter() {
        this.mSearchList = this.searchList;
        this.adapter = new FilterableRecyclerView(new AnonymousClass3());
        this.binding.searchListDseRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.searchListDseRv.setAdapter(this.adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bottomSheet(String name, String epicno, final String pseId, String partno, String gender, String rlnName, String rlnType, String address12, String acno, String dateofinclusion, String photo, Bitmap dummyimg, String clusterId) {
        String str;
        Dialog dialog = new Dialog(getContext());
        this.dialog = dialog;
        dialog.requestWindowFeature(1);
        BloFormatABottomsheetBinding bloFormatABottomsheetBindingInflate = BloFormatABottomsheetBinding.inflate(getLayoutInflater());
        this.formatABottomsheetBinding = bloFormatABottomsheetBindingInflate;
        this.dialog.setContentView((View) bloFormatABottomsheetBindingInflate.getRoot());
        this.dialog.getWindow().setLayout(-1, -2);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        this.dialog.getWindow().setGravity(80);
        this.formatABottomsheetBinding.bottomSubmitLayout.setVisibility(8);
        this.formatABottomsheetBinding.bottomSubmitLayout2.setVisibility(8);
        this.formatABottomsheetBinding.bottomSubmitForm8generation.setVisibility(0);
        this.formatABottomsheetBinding.bottomSubmitForm8generated.setVisibility(8);
        this.formatABottomsheetBinding.ageTv.setVisibility(8);
        this.formatABottomsheetBinding.ageEt.setVisibility(8);
        this.formatABottomsheetBinding.preview.setVisibility(8);
        this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(8);
        this.formatABottomsheetBinding.chooseFileName.setVisibility(8);
        this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(8);
        this.formatABottomsheetBinding.uploadFormatATv.setText("Upload Photograph");
        this.formatABottomsheetBinding.remarkLabel.setVisibility(8);
        this.formatABottomsheetBinding.remarkUploadTv.setVisibility(8);
        if (name == null || name.equals("null") || name.equals("")) {
            this.formatABottomsheetBinding.applicantNameTv.setText("");
        } else {
            this.formatABottomsheetBinding.applicantNameTv.setText(name);
        }
        if (clusterId == null || clusterId.equals("null") || clusterId.equals("")) {
            this.formatABottomsheetBinding.clusterid.setText("");
        } else {
            this.formatABottomsheetBinding.clusterid.setText(clusterId);
        }
        if (epicno == null || epicno.equals("null") || epicno.equals("")) {
            this.formatABottomsheetBinding.epicNoEt.setText("");
        } else {
            this.formatABottomsheetBinding.epicNoEt.setText(epicno);
        }
        if (gender == null || gender.equals("null") || gender.equals("")) {
            this.formatABottomsheetBinding.genderTv1.setText("");
        } else if (gender.equals("M")) {
            this.formatABottomsheetBinding.genderTv1.setText("Male");
        } else if (gender.equals("F")) {
            this.formatABottomsheetBinding.genderTv1.setText("Female");
        } else if (gender.equals("T")) {
            this.formatABottomsheetBinding.genderTv1.setText(OTHER);
        }
        if (rlnName == null || rlnName.equals("null") || rlnName.equals("")) {
            this.formatABottomsheetBinding.relativeTv1.setText("");
        } else {
            this.formatABottomsheetBinding.relativeTv1.setText(rlnName);
        }
        if (rlnType == null || rlnType.equals("null") || rlnType.equals("")) {
            this.formatABottomsheetBinding.relationtype.setText("");
        } else if (rlnType.equals("F") || rlnType.equals("FTHR")) {
            this.formatABottomsheetBinding.relationtype.setText("Father");
        } else if (rlnType.equals("M") || rlnType.equals("MTHR")) {
            this.formatABottomsheetBinding.relationtype.setText("Mother");
        } else if (rlnType.equals("H") || rlnType.equals("HSBN")) {
            this.formatABottomsheetBinding.relationtype.setText("Husband");
        } else if (rlnType.equals("W") || rlnType.equals("WIFE")) {
            this.formatABottomsheetBinding.relationtype.setText("Wife");
        } else if (rlnType.equals("L") || rlnType.equals("OTHR")) {
            this.formatABottomsheetBinding.relationtype.setText(OTHER);
        } else {
            this.formatABottomsheetBinding.relationtype.setText("");
        }
        this.formatABottomsheetBinding.serialNo.setText(acno + " // " + partno);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        if (dateofinclusion == null || dateofinclusion.equals("null") || dateofinclusion.equals("")) {
            this.formatABottomsheetBinding.dateInclusionEt.setText("");
        } else {
            try {
                str = simpleDateFormat2.format(simpleDateFormat.parse(dateofinclusion.substring(0, 9)));
            } catch (ParseException e) {
                Logger.e("", e.getMessage());
                str = null;
            }
            this.formatABottomsheetBinding.dateInclusionEt.setText(str);
        }
        if (photo != null) {
            this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getFile("objectstorage", photo, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass4());
        } else {
            this.formatABottomsheetBinding.personImage.setImageBitmap(dummyimg);
        }
        HashMap map = new HashMap();
        map.put(EPIC_NUMBER, epicno);
        map.put("acNo", acno);
        map.put("partNumber", partno);
        map.put("stateCd", this.blostatecode);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getaddressDetailsPse(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.blostatecode, APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass5());
        this.formatABottomsheetBinding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$2(view);
            }
        });
        this.formatABottomsheetBinding.chooseFileDeletion.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$3(view);
            }
        });
        this.formatABottomsheetBinding.submitForm8request.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$4(pseId, view);
            }
        });
        this.formatABottomsheetBinding.crossDialog.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$5(view);
            }
        });
        this.formatABottomsheetBinding.imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$6(view);
            }
        });
        this.dialog.show();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        AnonymousClass4() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                ((JsonObject) response.body()).get("file");
                SearchPseFragment.this.encodedImage = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(SearchPseFragment.this.encodedImage, 0);
                SearchPseFragment.this.bitmap = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                SearchPseFragment.this.formatABottomsheetBinding.personImage.setImageBitmap(SearchPseFragment.this.bitmap);
                return;
            }
            try {
                Logger.d("imageerror", new JSONObject(response.errorBody().string()).optString(SearchPseFragment.MESSAGE));
            } catch (Exception e) {
                Logger.e("", e.getMessage());
                if (response.code() == 401) {
                    SearchPseFragment.this.commomUtility.showMessageWithTitleOK(SearchPseFragment.this.requireContext(), "Alert", SearchPseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$4$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SearchPseFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SearchPseFragment.this.getContext()).setLocaleBool(false);
            SearchPseFragment.this.startActivity(new Intent((Context) SearchPseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(SearchPseFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<EronetResponse> {
        AnonymousClass5() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.body() != null) {
                SearchPseFragment.this.addressDetails = ((EronetResponse) response.body()).getPayload();
                String string = "";
                if (!SearchPseFragment.this.addressDetails.isEmpty()) {
                    JsonObject asJsonObject = SearchPseFragment.this.gson.toJsonTree((LinkedTreeMap) SearchPseFragment.this.addressDetails.get(0)).getAsJsonObject();
                    SearchPseFragment searchPseFragment = SearchPseFragment.this;
                    if (!String.valueOf(asJsonObject.get(SearchPseFragment.HOUSE_NUMBER)).equals("") && !String.valueOf(asJsonObject.get(SearchPseFragment.HOUSE_NUMBER)).equals("null")) {
                        StringBuilder sbAppend = new StringBuilder().append(String.valueOf(asJsonObject.get(SearchPseFragment.HOUSE_NUMBER)).replace(RegexMatcher.JSON_STRING_REGEX, "")).append(", ").append((String.valueOf(asJsonObject.get(SearchPseFragment.LOCALITY_STREET)).equals("") || String.valueOf(asJsonObject.get(SearchPseFragment.LOCALITY_STREET)).equals("null")) ? "" : String.valueOf(asJsonObject.get(SearchPseFragment.LOCALITY_STREET)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ").append((String.valueOf(asJsonObject.get(SearchPseFragment.TOWN_VILLAGE_NEW)).equals("") || String.valueOf(asJsonObject.get(SearchPseFragment.TOWN_VILLAGE_NEW)).equals("null")) ? "" : String.valueOf(asJsonObject.get(SearchPseFragment.TOWN_VILLAGE_NEW)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ").append((String.valueOf(asJsonObject.get(SearchPseFragment.DISTRICT_NAME_ENGLISH)).equals("") || String.valueOf(asJsonObject.get(SearchPseFragment.DISTRICT_NAME_ENGLISH)).equals("null")) ? "" : String.valueOf(asJsonObject.get(SearchPseFragment.DISTRICT_NAME_ENGLISH)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ");
                        if (!String.valueOf(asJsonObject.get(SearchPseFragment.STATE_NAME_ENGLISH)).equals("") && !String.valueOf(asJsonObject.get(SearchPseFragment.STATE_NAME_ENGLISH)).equals("null")) {
                            StringBuilder sbAppend2 = new StringBuilder().append(String.valueOf(asJsonObject.get(SearchPseFragment.STATE_NAME_ENGLISH)).trim().replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!String.valueOf(asJsonObject.get(SearchPseFragment.PIN_CODE_NEW)).equals("") && !String.valueOf(asJsonObject.get(SearchPseFragment.PIN_CODE_NEW)).equals("null")) {
                                string = ", " + String.valueOf(asJsonObject.get(SearchPseFragment.PIN_CODE_NEW)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                            }
                            string = sbAppend2.append(string).toString();
                        }
                        string = sbAppend.append(string).toString();
                    }
                    searchPseFragment.address = string;
                    SearchPseFragment.this.formatABottomsheetBinding.addressTv1.setText(SearchPseFragment.this.address);
                    SearchPseFragment.this.alertDialog1.dismiss();
                    return;
                }
                SearchPseFragment.this.formatABottomsheetBinding.addressTv1.setText("");
                return;
            }
            if (response.code() == 401) {
                SearchPseFragment.this.commomUtility.getRefreshToken(SearchPseFragment.this.getContext(), SearchPseFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$5$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(SearchPseFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(SearchPseFragment.HOUSE_NUMBER_FRAG, e.getMessage());
            }
            SearchPseFragment.this.alertDialog1.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            SearchPseFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                SearchPseFragment.this.commomUtility.showMessageOK(SearchPseFragment.this.requireContext(), SearchPseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$5$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SearchPseFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setToken("Bearer " + str);
            SearchPseFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setLocaleBool(false);
            SearchPseFragment.this.startActivity(new Intent((Context) SearchPseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d(SearchPseFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$2(View view) {
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose Image from Gallery", "Cancel"};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$bottomSheet$1(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$1(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals("Take Photo")) {
            this.alertDialog1.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(101);
        } else if (charSequenceArr[i].equals("Choose Image from Gallery")) {
            this.alertDialog1.show();
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(101);
        } else if (charSequenceArr[i].equals("Cancel")) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$3(View view) {
        this.formatABottomsheetBinding.chooseFileName.setText("");
        this.formatABottomsheetBinding.chooseFileName.setVisibility(8);
        this.formatABottomsheetBinding.preview.setVisibility(8);
        this.formatABottomsheetBinding.preview.setImageDrawable(null);
        this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(8);
        this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(8);
        this.formatABottomsheetBinding.chooseFile.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$4(String str, View view) {
        if (this.formatABottomsheetBinding.preview.getDrawable() == null) {
            showdialog("Alert", "Please Attach Document");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("applicantName", this.formatABottomsheetBinding.applicantNameTv.getText().toString());
        bundle.putString(EPIC_NUMBER, this.formatABottomsheetBinding.epicNoEt.getText().toString());
        bundle.putString("gender", this.formatABottomsheetBinding.genderTv1.getText().toString());
        bundle.putString("relationName", this.formatABottomsheetBinding.relativeTv1.getText().toString());
        bundle.putString("relationType", this.formatABottomsheetBinding.relationtype.getText().toString());
        bundle.putString("address", this.formatABottomsheetBinding.addressTv1.getText().toString());
        bundle.putString("dateofInclusion", this.formatABottomsheetBinding.dateInclusionEt.getText().toString());
        bundle.putString("photoReferenceNo", this.photoref);
        bundle.putString("pseid", str);
        bundle.putString("previewFlag", "2");
        PseChecklistPreviewFragment pseChecklistPreviewFragment = new PseChecklistPreviewFragment();
        pseChecklistPreviewFragment.setArguments(bundle);
        openFragment(pseChecklistPreviewFragment, "PseChecklistPreviewFragment");
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$5(View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$6(View view) {
        this.dialog.dismiss();
    }

    public JSONArray pseDoneList() {
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put("acNo", this.asmblyNO);
        map.put(PART_NO, this.partNo);
        map.put("status", "submitted");
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).pseForm8List(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", CLOSE, "blo", this.blostatecode, map).enqueue(new AnonymousClass6());
        return this.payloadSearchHouses;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<EronetResponse> {
        AnonymousClass6() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                if (((EronetResponse) response.body()).getPayload() != null) {
                    SearchPseFragment.this.payloadSearchHouses = ((EronetResponse) response.body()).getPayload();
                    if (!SearchPseFragment.this.payloadSearchHouses.isEmpty()) {
                        Logger.d("json34: ", String.valueOf(SearchPseFragment.this.gson.toJsonTree((LinkedTreeMap) SearchPseFragment.this.payloadSearchHouses.get(0)).getAsJsonObject()));
                        Logger.d("payload34: ", String.valueOf(SearchPseFragment.this.payloadSearchHouses));
                        SearchPseFragment searchPseFragment = SearchPseFragment.this;
                        searchPseFragment.renderingdataDone(searchPseFragment.payloadSearchHouses);
                        SearchPseFragment.this.alertDialog1.dismiss();
                        return;
                    }
                    SearchPseFragment.this.alertDialog1.dismiss();
                    return;
                }
                SearchPseFragment.this.alertDialog1.dismiss();
                return;
            }
            if (response.code() == 401) {
                SearchPseFragment.this.commomUtility.getRefreshToken(SearchPseFragment.this.getContext(), SearchPseFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$6$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(SearchPseFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(SearchPseFragment.ALL_HOUSES, e.getMessage());
            }
            SearchPseFragment.this.alertDialog1.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            SearchPseFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                SearchPseFragment.this.commomUtility.showMessageOK(SearchPseFragment.this.requireContext(), SearchPseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$6$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SearchPseFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setToken("Bearer " + str);
            SearchPseFragment.this.pseDoneList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setLocaleBool(false);
            SearchPseFragment.this.startActivity(new Intent((Context) SearchPseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d(SearchPseFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public void renderingdataDone(JSONArray allhouses) {
        this.searchList.clear();
        for (int i = 0; i < allhouses.size(); i++) {
            try {
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) allhouses.get(i);
                String str = (String) linkedTreeMap.get(Constants.FIRST_NAME);
                String str2 = (String) linkedTreeMap.get(Constants.LAST_NAME);
                String str3 = (String) linkedTreeMap.get(EPIC_NO);
                String str4 = (String) linkedTreeMap.get("acNo");
                String str5 = (String) linkedTreeMap.get(PART_NO);
                String str6 = (String) linkedTreeMap.get("relationFirstName");
                String str7 = (String) linkedTreeMap.get("relationLastName");
                String str8 = (String) linkedTreeMap.get("relationType");
                String str9 = (String) linkedTreeMap.get("address");
                String str10 = (String) linkedTreeMap.get("slnoInPart");
                String str11 = (String) linkedTreeMap.get("photo");
                this.searchList.add(new clusterDetailsDseModel(str, str2, str3, str4, str5, "", (String) linkedTreeMap.get("gender"), str6, str7, str8, str9, Integer.valueOf(str10), (String) linkedTreeMap.get(PSE_ID), (String) linkedTreeMap.get("dateOfInclusion"), (String) linkedTreeMap.get("form8RefId"), str11, (String) linkedTreeMap.get(CLUSTER_ID), "", "", 0));
            } catch (Exception e) {
                Logger.d(ALL_HOUSES, e.getMessage());
                return;
            }
        }
        initRecyclerViewAdapter1();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$7, reason: invalid class name */
    class AnonymousClass7 implements FilterableRecyclerView.FilterGenericRecyclerAdapterInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass7() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloForm8generatedRvItemBinding.inflate(SearchPseFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            ((BloForm8generatedRvItemBinding) holder.binding).SerialNoTv.setText(SearchPseFragment.S_NO + (position + 1));
            ((BloForm8generatedRvItemBinding) holder.binding).HNoTv.setText(((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getClusterId());
            ((BloForm8generatedRvItemBinding) holder.binding).applicantName.setText(((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getApplicantFirstname() + " " + ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getApplicantLastname());
            ((BloForm8generatedRvItemBinding) holder.binding).epicnumber.setText(((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getEpicnumber());
            ((BloForm8generatedRvItemBinding) holder.binding).referencenoTv.setText(((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getBloVerifStatus());
            ((BloForm8generatedRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor(SearchPseFragment.WHITE_COLOR));
            final String str = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getApplicantFirstname() + " " + ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getApplicantLastname();
            final String str2 = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getRelationfirstname() + " " + ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getRelationlastname();
            final String relationtype = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getRelationtype();
            final String gender = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getGender();
            final String epicnumber = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getEpicnumber();
            final String partnumber = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getPartnumber();
            final String ac = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getAc();
            final String clusterId = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getClusterId();
            final String dateofinclusion = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getDateofinclusion();
            final String photo = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getPhoto();
            final String strReplace = ((clusterDetailsDseModel) SearchPseFragment.this.mSearchList.get(position)).getAddress().replace(",{2,}", ",");
            ((BloForm8generatedRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$7$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(str, epicnumber, partnumber, gender, str2, relationtype, strReplace, ac, dateofinclusion, photo, clusterId, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, View view) {
            SearchPseFragment.this.bottomSheet2(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, BitmapFactory.decodeResource(SearchPseFragment.this.getResources(), R.drawable.blo_dummy_image), str11);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemCount() {
            return SearchPseFragment.this.mSearchList.size();
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public Filter getFilter() {
            return new Filter() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment.7.1
                @Override // android.widget.Filter
                protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                    String strValueOf = String.valueOf(charSequence);
                    if (strValueOf.length() == 0) {
                        SearchPseFragment.this.mSearchList = SearchPseFragment.this.searchList;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (clusterDetailsDseModel clusterdetailsdsemodel : SearchPseFragment.this.mSearchList) {
                            if (clusterdetailsdsemodel.applicantFirstname.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT)) || clusterdetailsdsemodel.applicantLastname.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT)) || clusterdetailsdsemodel.epicnumber.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT)) || clusterdetailsdsemodel.bloVerifStatus.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                arrayList.add(clusterdetailsdsemodel);
                            }
                        }
                        SearchPseFragment.this.mSearchList = arrayList;
                    }
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    filterResults.values = SearchPseFragment.this.mSearchList;
                    return filterResults;
                }

                @Override // android.widget.Filter
                protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    SearchPseFragment.this.adapter.notifyDataSetChanged();
                }
            };
        }
    }

    private void initRecyclerViewAdapter1() {
        this.mSearchList = this.searchList;
        this.adapter = new FilterableRecyclerView(new AnonymousClass7());
        this.binding.searchListDseRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.searchListDseRv.setAdapter(this.adapter);
    }

    public JSONArray pseWIthinPart() {
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put("stateCd", this.blostatecode);
        map.put(PART_NO, this.partNo);
        if (this.flagValue.equals("2")) {
            map.put(CLUSTER_BIFURCATION, "WP");
        } else if (this.flagValue.equals("3")) {
            map.put(CLUSTER_BIFURCATION, "WAC");
        } else {
            map.put(CLUSTER_BIFURCATION, "WST");
        }
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).pseIdentified(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", CLOSE, "blo", this.blostatecode, APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass8());
        return this.payloadSearchHouses;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<EronetResponse> {
        AnonymousClass8() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                if (((EronetResponse) response.body()).getPayload() != null) {
                    SearchPseFragment.this.payloadSearchHouses = ((EronetResponse) response.body()).getPayload();
                    if (!SearchPseFragment.this.payloadSearchHouses.isEmpty()) {
                        Logger.d("json: ", String.valueOf(SearchPseFragment.this.gson.toJsonTree((LinkedTreeMap) SearchPseFragment.this.payloadSearchHouses.get(0)).getAsJsonObject()));
                        Logger.d("payload: ", String.valueOf(SearchPseFragment.this.payloadSearchHouses));
                        SearchPseFragment searchPseFragment = SearchPseFragment.this;
                        searchPseFragment.renderingdPseData(searchPseFragment.payloadSearchHouses);
                        SearchPseFragment.this.alertDialog1.dismiss();
                        return;
                    }
                    SearchPseFragment.this.alertDialog1.dismiss();
                    return;
                }
                SearchPseFragment.this.alertDialog1.dismiss();
                return;
            }
            if (response.code() == 401) {
                SearchPseFragment.this.commomUtility.getRefreshToken(SearchPseFragment.this.getContext(), SearchPseFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$8$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(SearchPseFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(SearchPseFragment.ALL_HOUSES, e.getMessage());
            }
            SearchPseFragment.this.alertDialog1.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            SearchPseFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                SearchPseFragment.this.commomUtility.showMessageOK(SearchPseFragment.this.requireContext(), SearchPseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$8$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            SearchPseFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setToken("Bearer " + str);
            SearchPseFragment.this.pseWIthinPart();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setLocaleBool(false);
            SearchPseFragment.this.startActivity(new Intent((Context) SearchPseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            SearchPseFragment.this.alertDialog1.dismiss();
            SearchPseFragment.this.showdialog4("Alert", "Unable to load data, Please try again.");
            Logger.d(SearchPseFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog4(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog4$7(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog4$7(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(getContext(), (Class<?>) DseActivity.class));
    }

    public void renderingdPseData(JSONArray allHouses12) {
        this.searchListIdentified.clear();
        for (int i = 0; i < allHouses12.size(); i++) {
            try {
                this.searchListIdentified.add(new dsePendingModel(String.valueOf(this.gson.toJsonTree(allHouses12.get(i)).getAsJsonObject().get(CLUSTER_ID)).replace(RegexMatcher.JSON_STRING_REGEX, ""), null, null, null, null, null, 0));
            } catch (Exception e) {
                Logger.d(ALL_HOUSES, e.getMessage());
                return;
            }
        }
        initRecyclerViewAdapterPse();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$9, reason: invalid class name */
    class AnonymousClass9 implements FilterableRecyclerView.FilterGenericRecyclerAdapterInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass9() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloDsependingRvItemBinding.inflate(SearchPseFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            ((BloDsependingRvItemBinding) holder.binding).textView16.setVisibility(8);
            ((BloDsependingRvItemBinding) holder.binding).applicantName.setVisibility(8);
            ((BloDsependingRvItemBinding) holder.binding).SerialNoTv.setText(SearchPseFragment.S_NO + (position + 1));
            ((BloDsependingRvItemBinding) holder.binding).HNoTv.setText(((dsePendingModel) SearchPseFragment.this.mSearchListIdentified.get(position)).getClusterId());
            ((BloDsependingRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor(SearchPseFragment.WHITE_COLOR));
            final String str = ((dsePendingModel) SearchPseFragment.this.mSearchListIdentified.get(position)).clusterId;
            ((BloDsependingRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$9$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(str, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, View view) {
            Bundle bundle = new Bundle();
            bundle.putString(SearchPseFragment.CLUSTER_ID, str);
            ClusterDetailsPseIdentifiedFragment clusterDetailsPseIdentifiedFragment = new ClusterDetailsPseIdentifiedFragment();
            clusterDetailsPseIdentifiedFragment.setArguments(bundle);
            SearchPseFragment.this.openFragment(clusterDetailsPseIdentifiedFragment, "clusterDetailsPseIdentifiedFragment");
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemCount() {
            return SearchPseFragment.this.mSearchListIdentified.size();
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public Filter getFilter() {
            return new Filter() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment.9.1
                @Override // android.widget.Filter
                protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                    String strValueOf = String.valueOf(charSequence);
                    if (strValueOf.length() == 0) {
                        SearchPseFragment.this.mSearchListIdentified = SearchPseFragment.this.searchListIdentified;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (dsePendingModel dsependingmodel : SearchPseFragment.this.mSearchListIdentified) {
                            if (dsependingmodel.clusterId.toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                arrayList.add(dsependingmodel);
                            }
                        }
                        SearchPseFragment.this.mSearchListIdentified = arrayList;
                    }
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    filterResults.values = SearchPseFragment.this.mSearchListIdentified;
                    return filterResults;
                }

                @Override // android.widget.Filter
                protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    SearchPseFragment.this.adapter.notifyDataSetChanged();
                }
            };
        }
    }

    private void initRecyclerViewAdapterPse() {
        this.mSearchListIdentified = this.searchListIdentified;
        this.adapter = new FilterableRecyclerView(new AnonymousClass9());
        this.binding.searchListDseRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.searchListDseRv.setAdapter(this.adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bottomSheet2(String name, String epicno, String partno, String gender, String rlnName, String rlnType, String address, String acno, String dateofinclusion, String photo, Bitmap dummyimg, String clusterId) {
        String str;
        Dialog dialog = new Dialog(getContext());
        this.dialog = dialog;
        dialog.requestWindowFeature(1);
        BloFormatABottomsheetBinding bloFormatABottomsheetBindingInflate = BloFormatABottomsheetBinding.inflate(getLayoutInflater());
        this.formatABottomsheetBinding = bloFormatABottomsheetBindingInflate;
        this.dialog.setContentView((View) bloFormatABottomsheetBindingInflate.getRoot());
        this.dialog.getWindow().setLayout(-1, -2);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        this.dialog.getWindow().setGravity(80);
        this.formatABottomsheetBinding.bottomSubmitLayout.setVisibility(8);
        this.formatABottomsheetBinding.bottomSubmitLayout2.setVisibility(8);
        this.formatABottomsheetBinding.bottomSubmitForm8generation.setVisibility(8);
        this.formatABottomsheetBinding.bottomSubmitForm8generated.setVisibility(0);
        this.formatABottomsheetBinding.ageTv.setVisibility(8);
        this.formatABottomsheetBinding.ageEt.setVisibility(8);
        this.formatABottomsheetBinding.imageLayout.setVisibility(8);
        this.formatABottomsheetBinding.uploadFormatATv.setVisibility(8);
        this.formatABottomsheetBinding.remarkLabel.setVisibility(8);
        this.formatABottomsheetBinding.remarkUploadTv.setVisibility(8);
        if (name == null || name.equals("null") || name.equals("")) {
            this.formatABottomsheetBinding.applicantNameTv.setText("");
        } else {
            this.formatABottomsheetBinding.applicantNameTv.setText(name);
        }
        if (clusterId == null || clusterId.equals("null") || clusterId.equals("")) {
            this.formatABottomsheetBinding.clusterid.setText("");
        } else {
            this.formatABottomsheetBinding.clusterid.setText(clusterId);
        }
        if (epicno == null || epicno.equals("null") || epicno.equals("")) {
            this.formatABottomsheetBinding.epicNoEt.setText("");
        } else {
            this.formatABottomsheetBinding.epicNoEt.setText(epicno);
        }
        if (gender == null || gender.equals("null") || gender.equals("")) {
            this.formatABottomsheetBinding.genderTv1.setText("");
        } else if (gender.equals("M")) {
            this.formatABottomsheetBinding.genderTv1.setText("Male");
        } else if (gender.equals("F")) {
            this.formatABottomsheetBinding.genderTv1.setText("Female");
        } else if (gender.equals("T")) {
            this.formatABottomsheetBinding.genderTv1.setText(OTHER);
        }
        if (rlnName == null || rlnName.equals("null") || rlnName.equals("")) {
            this.formatABottomsheetBinding.relativeTv1.setText("");
        } else {
            this.formatABottomsheetBinding.relativeTv1.setText(rlnName);
        }
        if (rlnType == null || rlnType.equals("null") || rlnType.equals("")) {
            this.formatABottomsheetBinding.relationtype.setText("");
        } else if (rlnType.equals("F") || rlnType.equals("FTHR")) {
            this.formatABottomsheetBinding.relationtype.setText("Father");
        } else if (rlnType.equals("M") || rlnType.equals("MTHR")) {
            this.formatABottomsheetBinding.relationtype.setText("Mother");
        } else if (rlnType.equals("H") || rlnType.equals("HSBN")) {
            this.formatABottomsheetBinding.relationtype.setText("Husband");
        } else if (rlnType.equals("W") || rlnType.equals("WIFE")) {
            this.formatABottomsheetBinding.relationtype.setText("Wife");
        } else if (rlnType.equals("L") || rlnType.equals("OTHR")) {
            this.formatABottomsheetBinding.relationtype.setText(OTHER);
        } else {
            this.formatABottomsheetBinding.relationtype.setText("");
        }
        this.formatABottomsheetBinding.serialNo.setText(acno + " // " + partno);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        if (dateofinclusion == null || dateofinclusion.equals("null") || dateofinclusion.equals("")) {
            this.formatABottomsheetBinding.dateInclusionEt.setText("");
        } else {
            try {
                str = simpleDateFormat2.format(simpleDateFormat.parse(dateofinclusion.substring(0, 9)));
            } catch (ParseException e) {
                Logger.e("", e.getMessage());
                str = null;
            }
            this.formatABottomsheetBinding.dateInclusionEt.setText(str);
        }
        if (photo != null) {
            this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getFile("objectstorage", photo, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass10());
        } else {
            this.formatABottomsheetBinding.personImage.setImageBitmap(dummyimg);
        }
        if (address == null || address.equals("null") || address.equals("")) {
            this.formatABottomsheetBinding.addressTv1.setText("");
        } else {
            this.formatABottomsheetBinding.addressTv1.setText(address);
        }
        this.formatABottomsheetBinding.crossDialog.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet2$8(view);
            }
        });
        this.formatABottomsheetBinding.imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet2$9(view);
            }
        });
        this.dialog.show();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$10, reason: invalid class name */
    class AnonymousClass10 implements Callback<JsonObject> {
        AnonymousClass10() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                ((JsonObject) response.body()).get("file");
                SearchPseFragment.this.encodedImage = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(SearchPseFragment.this.encodedImage, 0);
                SearchPseFragment.this.bitmap = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                SearchPseFragment.this.formatABottomsheetBinding.personImage.setImageBitmap(SearchPseFragment.this.bitmap);
                return;
            }
            try {
                Logger.d("imageerror", new JSONObject(response.errorBody().string()).optString(SearchPseFragment.MESSAGE));
            } catch (Exception e) {
                Logger.e("", e.getMessage());
                if (response.code() == 401) {
                    SearchPseFragment.this.commomUtility.showMessageWithTitleOK(SearchPseFragment.this.requireContext(), "Alert", SearchPseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$10$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SearchPseFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SearchPseFragment.this.getContext()).setLocaleBool(false);
            SearchPseFragment.this.startActivity(new Intent((Context) SearchPseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(SearchPseFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet2$8(View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet2$9(View view) {
        this.dialog.dismiss();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == -1) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                this.byteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                Logger.e("", e.getMessage());
            }
            try {
                Cursor cursorQuery = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(this.byteArray, 0), "image"), null, null, null, null);
                if (cursorQuery.getCount() <= 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                }
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                if (this.filesize < 1024) {
                    this.formatABottomsheetBinding.chooseFileName.setVisibility(0);
                    this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(0);
                    this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(0);
                    this.formatABottomsheetBinding.preview.setVisibility(0);
                    this.formatABottomsheetBinding.chooseFileName.setText(string);
                    this.formatABottomsheetBinding.chooseFile.setTextColor(Color.parseColor("#99000000"));
                    this.formatABottomsheetBinding.chooseFileNameSize.setText(this.filesize + "KB");
                    ImageView imageView = this.formatABottomsheetBinding.preview;
                    byte[] bArr = this.byteArray;
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                } else {
                    double dRound = Math.round(((double) ((float) (this.filesize / 1024.0d))) * 100.0d) / 100.0d;
                    if (dRound > 2.0d) {
                        this.formatABottomsheetBinding.preview.setVisibility(8);
                        this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(8);
                        this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(8);
                        this.formatABottomsheetBinding.chooseFileName.setVisibility(8);
                        showdialog("Alert", "Image size exceeded 2MB limit.");
                    } else {
                        this.formatABottomsheetBinding.chooseFileName.setVisibility(0);
                        this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(0);
                        this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(0);
                        this.formatABottomsheetBinding.preview.setVisibility(0);
                        this.formatABottomsheetBinding.chooseFileName.setText(string);
                        this.formatABottomsheetBinding.chooseFile.setTextColor(Color.parseColor("#99000000"));
                        this.formatABottomsheetBinding.chooseFileNameSize.setText(dRound + "MB");
                        ImageView imageView2 = this.formatABottomsheetBinding.preview;
                        byte[] bArr2 = this.byteArray;
                        imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                    }
                }
                RestClient restClient = (RestClient) ApiClient.getClient(getContext()).create(RestClient.class);
                File file = new File(this.filepathimg + this.saveImageFileName);
                restClient.faceRecognitionApi(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", this.blostatecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + this.saveImageFileName.substring(this.saveImageFileName.lastIndexOf(".")), MediaType.parse("fileType"))).enqueue(new AnonymousClass11());
                this.alertDialog1.dismiss();
            } catch (Exception e2) {
                Logger.d("CONTENT", e2.getMessage());
            }
        } else {
            this.alertDialog1.dismiss();
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$11, reason: invalid class name */
    class AnonymousClass11 implements Callback<JsonObject> {
        AnonymousClass11() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 401) {
                SearchPseFragment.this.commonUtilClass.showMessageOK(SearchPseFragment.this.getContext(), SearchPseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$11$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                SearchPseFragment.this.commonUtilClass.uploadToServer2(SearchPseFragment.this.getContext(), SearchPseFragment.this.stateCode, SearchPseFragment.this.asmblyNO, SearchPseFragment.this.partNo, SearchPseFragment.this.filepathimg, SearchPseFragment.this.saveImageFileName, SearchPseFragment.this.token, "PSEForm8Image", SharedPref.getInstance(SearchPseFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(SearchPseFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$11$$ExternalSyntheticLambda2
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str) {
                        this.f$0.lambda$onResponse$2(i, str);
                    }
                });
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                SearchPseFragment.this.formatABottomsheetBinding.chooseFileName.setText("");
                SearchPseFragment.this.photoref = "";
                SearchPseFragment.this.formatABottomsheetBinding.preview.setImageDrawable(null);
                SearchPseFragment.this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(8);
                SearchPseFragment.this.formatABottomsheetBinding.preview.setVisibility(8);
                SearchPseFragment.this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(8);
                SearchPseFragment.this.formatABottomsheetBinding.chooseFileName.setVisibility(8);
                SearchPseFragment.this.formatABottomsheetBinding.chooseFile.setEnabled(true);
                SearchPseFragment.this.formatABottomsheetBinding.chooseFile.setTextColor(Color.parseColor("#000000"));
                SearchPseFragment.this.showdialog("Alert", jSONObject.optString(SearchPseFragment.MESSAGE));
            } catch (IOException | JSONException e) {
                Logger.d("SearchPseFragment", e.toString());
            }
            SearchPseFragment.this.alertDialog1.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SearchPseFragment.this.requireContext()).setLocaleBool(false);
            SearchPseFragment.this.startActivity(new Intent((Context) SearchPseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(int i, String str) {
            if (i == 401) {
                SearchPseFragment.this.alertDialog1.dismiss();
                SearchPseFragment.this.commonUtilClass.showMessageWithTitleOK(SearchPseFragment.this.requireContext(), "Alert", SearchPseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$11$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
            } else {
                SearchPseFragment.this.photoref = str;
                SearchPseFragment.this.alertDialog1.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(SearchPseFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(SearchPseFragment.this.getContext()).setLocaleBool(false);
            SearchPseFragment.this.startActivity(new Intent((Context) SearchPseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Toast.makeText(SearchPseFragment.this.getContext(), t.getMessage(), 1).show();
            SearchPseFragment.this.alertDialog1.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog3(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.SearchPseFragment$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog3$11(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog3$11(DialogInterface dialogInterface, int i) {
        openFragment(new PseForm8RequestFragment(), "PseChecklistPreviewFragment");
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
