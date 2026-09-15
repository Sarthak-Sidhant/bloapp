package in.gov.eci.bloapp.views.fragments.pse;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.databinding.BloForm8generatedRvItemBinding;
import in.gov.eci.bloapp.databinding.BloFormatABottomsheetBinding;
import in.gov.eci.bloapp.databinding.BloFragmentPseForm8RequestDoneBinding;
import in.gov.eci.bloapp.model.app_model.clusterDetailsDseModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
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
public class PseForm8RequestDoneFragment extends Fragment {
    private static final String APPLICATION_JSON = "application/json";
    private static final String COMING_IN_ON_FAILURE = "coming in onFailure ";
    private static final String DISTRICT_NAME_ENGLISH = "districtNameEnglish";
    private static final String EPIC_NUMBER = "epicNumber";
    private static final String ERROR_RESPONSE = "errorResponse";
    private static final String HOUSE_NUMBER = "houseNumber";
    private static final String HOUSE_NUMBER_FRAG = "house_number_frag";
    private static final String LOCALITY_STREET = "localityStreet";
    private static final String PIN_CODE = "pinCode";
    private static final String PIN_CODE_NEW = "poPin";
    private static final String STATE_NAME_ENGLISH = "stateNameEnglish";
    private static final String TOWN_VILLAGE = "townVillage";
    private static final String TOWN_VILLAGE_NEW = "townName";
    private GenericRecyclerView adapter;
    private String address;
    private JSONArray addressDetails;
    private AlertDialog alertDialog1;
    private List<clusterDetailsDseModel> allhousesList;
    private String asmblyNO;
    BloFragmentPseForm8RequestDoneBinding binding;
    private Bitmap bitmap;
    private String blostatecode;
    Retrofit.Builder builder;
    private String encodedImage;
    BloFormatABottomsheetBinding formatABottomsheetBinding;
    private String partNo;
    private String refreshToken;
    Retrofit retrofit;
    private String token = "";
    private JSONArray payloadAllHouses = null;
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public PseForm8RequestDoneFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.blostatecode = "";
        this.addressDetails = null;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentPseForm8RequestDoneBinding.inflate(getLayoutInflater());
        this.allhousesList = new ArrayList();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog1 = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog1.setCancelable(false);
        this.alertDialog1.setView(viewInflate);
        this.blostatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        pseDoneList();
        this.binding.searchDsePending.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("Flag", "1");
        SearchPseFragment searchPseFragment = new SearchPseFragment();
        searchPseFragment.setArguments(bundle);
        openFragment(searchPseFragment, "SearchDseFragment");
    }

    public JSONArray pseDoneList() {
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put("acNo", this.asmblyNO);
        map.put("partNo", this.partNo);
        map.put("status", "submitted");
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).pseForm8List(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "Close", "blo", this.blostatecode, map).enqueue(new AnonymousClass1());
        return this.payloadAllHouses;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<EronetResponse> {
        AnonymousClass1() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                Logger.d("mdh fk", String.valueOf(response.body()));
                if (((EronetResponse) response.body()).getPayload() != null) {
                    PseForm8RequestDoneFragment.this.payloadAllHouses = ((EronetResponse) response.body()).getPayload();
                    if (!PseForm8RequestDoneFragment.this.payloadAllHouses.isEmpty()) {
                        Logger.d("json: ", String.valueOf(PseForm8RequestDoneFragment.this.gson.toJsonTree((LinkedTreeMap) PseForm8RequestDoneFragment.this.payloadAllHouses.get(0)).getAsJsonObject()));
                        Logger.d("payload: ", String.valueOf(PseForm8RequestDoneFragment.this.payloadAllHouses));
                        PseForm8RequestDoneFragment pseForm8RequestDoneFragment = PseForm8RequestDoneFragment.this;
                        pseForm8RequestDoneFragment.renderingdataDone(pseForm8RequestDoneFragment.payloadAllHouses);
                        PseForm8RequestDoneFragment.this.alertDialog1.dismiss();
                        return;
                    }
                    PseForm8RequestDoneFragment.this.alertDialog1.dismiss();
                    PseForm8RequestDoneFragment.this.binding.nodatalayout.setVisibility(0);
                    PseForm8RequestDoneFragment.this.binding.allAppsRv.setVisibility(8);
                    PseForm8RequestDoneFragment.this.binding.searchDsePending.setVisibility(8);
                    return;
                }
                PseForm8RequestDoneFragment.this.alertDialog1.dismiss();
                PseForm8RequestDoneFragment.this.binding.nodatalayout.setVisibility(0);
                PseForm8RequestDoneFragment.this.binding.allAppsRv.setVisibility(8);
                PseForm8RequestDoneFragment.this.binding.searchDsePending.setVisibility(8);
                return;
            }
            if (response.code() == 401) {
                PseForm8RequestDoneFragment.this.commomUtility.getRefreshToken(PseForm8RequestDoneFragment.this.getContext(), PseForm8RequestDoneFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$1$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(PseForm8RequestDoneFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d("All houses", e.getMessage());
            }
            PseForm8RequestDoneFragment.this.alertDialog1.dismiss();
            PseForm8RequestDoneFragment.this.binding.nodatalayout.setVisibility(0);
            PseForm8RequestDoneFragment.this.binding.allAppsRv.setVisibility(8);
            PseForm8RequestDoneFragment.this.binding.searchDsePending.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            PseForm8RequestDoneFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                PseForm8RequestDoneFragment.this.commomUtility.showMessageOK(PseForm8RequestDoneFragment.this.requireContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PseForm8RequestDoneFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(PseForm8RequestDoneFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(PseForm8RequestDoneFragment.this.requireContext()).setToken("Bearer " + str);
            PseForm8RequestDoneFragment.this.pseDoneList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseForm8RequestDoneFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseForm8RequestDoneFragment.this.requireContext()).setLocaleBool(false);
            PseForm8RequestDoneFragment.this.startActivity(new Intent((Context) PseForm8RequestDoneFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d(PseForm8RequestDoneFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public void renderingdataDone(JSONArray allHouses) {
        this.allhousesList.clear();
        for (int i = 0; i < allHouses.size(); i++) {
            try {
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) allHouses.get(i);
                String str = (String) linkedTreeMap.get(Constants.FIRST_NAME);
                String str2 = (String) linkedTreeMap.get(Constants.LAST_NAME);
                String str3 = (String) linkedTreeMap.get("epicNo");
                String str4 = (String) linkedTreeMap.get("acNo");
                String str5 = (String) linkedTreeMap.get("partNo");
                String str6 = (String) linkedTreeMap.get("relationFirstName");
                String str7 = (String) linkedTreeMap.get("relationLastName");
                String str8 = (String) linkedTreeMap.get("relationType");
                String str9 = (String) linkedTreeMap.get("address");
                String str10 = (String) linkedTreeMap.get("slnoInPart");
                String str11 = (String) linkedTreeMap.get("photo");
                this.allhousesList.add(new clusterDetailsDseModel(str, str2, str3, str4, str5, "", (String) linkedTreeMap.get("gender"), str6, str7, str8, str9, Integer.valueOf(str10), (String) linkedTreeMap.get("pseId"), (String) linkedTreeMap.get("dateOfInclusion"), (String) linkedTreeMap.get("form8RefId"), str11, (String) linkedTreeMap.get("clusterId"), "", "", 0));
            } catch (Exception e) {
                Logger.d("All houses", e.getMessage());
                Logger.d("error", "Failed to read");
                return;
            }
        }
        initRecyclerViewAdapter1();
        this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.allAppsRv.setAdapter(this.adapter);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$2, reason: invalid class name */
    class AnonymousClass2 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass2() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloForm8generatedRvItemBinding.inflate(PseForm8RequestDoneFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            ((BloForm8generatedRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloForm8generatedRvItemBinding) holder.binding).HNoTv.setText(((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getClusterId());
            ((BloForm8generatedRvItemBinding) holder.binding).applicantName.setText(((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getApplicantFirstname() + " " + ((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getApplicantLastname());
            ((BloForm8generatedRvItemBinding) holder.binding).epicnumber.setText(((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getEpicnumber());
            ((BloForm8generatedRvItemBinding) holder.binding).referencenoTv.setText(((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getBloVerifStatus());
            ((BloForm8generatedRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#ffffff"));
            final String str = ((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getApplicantFirstname() + " " + ((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getApplicantLastname();
            final String str2 = ((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getRelationfirstname() + " " + ((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getRelationlastname();
            final String relationtype = ((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getRelationtype();
            final String gender = ((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getGender();
            final String epicnumber = ((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getEpicnumber();
            final String partnumber = ((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getPartnumber();
            final String ac = ((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getAc();
            final String clusterId = ((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getClusterId();
            final String dateofinclusion = ((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getDateofinclusion();
            final String photo = ((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getPhoto();
            final String strReplaceAll = ((clusterDetailsDseModel) PseForm8RequestDoneFragment.this.allhousesList.get(position)).getAddress().replaceAll(",{2,}", ",");
            ((BloForm8generatedRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(str, epicnumber, partnumber, gender, str2, relationtype, strReplaceAll, ac, dateofinclusion, photo, clusterId, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, View view) {
            PseForm8RequestDoneFragment.this.bottomSheet2(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, BitmapFactory.decodeResource(PseForm8RequestDoneFragment.this.getResources(), R.drawable.blo_dummy_image), str11);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return PseForm8RequestDoneFragment.this.allhousesList.size();
        }
    }

    private void initRecyclerViewAdapter1() {
        this.adapter = new GenericRecyclerView(new AnonymousClass2());
        this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.allAppsRv.setAdapter(this.adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bottomSheet2(String name, String epicno, String partno, String gender, String rlnName, String rlnType, String address12, String acno, String dateofinclusion, String photo, Bitmap dummyimg, String clusterId) {
        String str;
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        BloFormatABottomsheetBinding bloFormatABottomsheetBindingInflate = BloFormatABottomsheetBinding.inflate(getLayoutInflater());
        this.formatABottomsheetBinding = bloFormatABottomsheetBindingInflate;
        dialog.setContentView((View) bloFormatABottomsheetBindingInflate.getRoot());
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
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
            this.formatABottomsheetBinding.genderTv1.setText("Other");
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
            this.formatABottomsheetBinding.relationtype.setText("Other");
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
            this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getFile("objectstorage", photo, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass3());
        } else {
            this.formatABottomsheetBinding.personImage.setImageBitmap(dummyimg);
        }
        HashMap map = new HashMap();
        map.put(EPIC_NUMBER, epicno);
        map.put("acNo", acno);
        map.put("partNumber", partno);
        map.put("stateCd", this.blostatecode);
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getaddressDetailsPse(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.blostatecode, APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass4());
        this.formatABottomsheetBinding.crossDialog.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        this.formatABottomsheetBinding.imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        AnonymousClass3() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                ((JsonObject) response.body()).get("file");
                PseForm8RequestDoneFragment.this.encodedImage = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(PseForm8RequestDoneFragment.this.encodedImage, 0);
                PseForm8RequestDoneFragment.this.bitmap = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                PseForm8RequestDoneFragment.this.formatABottomsheetBinding.personImage.setImageBitmap(PseForm8RequestDoneFragment.this.bitmap);
                return;
            }
            if (response.code() == 401) {
                PseForm8RequestDoneFragment.this.commomUtility.getRefreshToken(PseForm8RequestDoneFragment.this.getContext(), PseForm8RequestDoneFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$3$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d("imageerror", new JSONObject(response.errorBody().string()).optString("message"));
            } catch (Exception e) {
                Logger.e("", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            PseForm8RequestDoneFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                PseForm8RequestDoneFragment.this.commomUtility.showMessageOK(PseForm8RequestDoneFragment.this.requireContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$3$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PseForm8RequestDoneFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(PseForm8RequestDoneFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(PseForm8RequestDoneFragment.this.requireContext()).setToken("Bearer " + str);
            PseForm8RequestDoneFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseForm8RequestDoneFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseForm8RequestDoneFragment.this.requireContext()).setLocaleBool(false);
            PseForm8RequestDoneFragment.this.startActivity(new Intent((Context) PseForm8RequestDoneFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(PseForm8RequestDoneFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<EronetResponse> {
        AnonymousClass4() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.body() != null) {
                PseForm8RequestDoneFragment.this.addressDetails = ((EronetResponse) response.body()).getPayload();
                String string = "";
                if (!PseForm8RequestDoneFragment.this.addressDetails.isEmpty()) {
                    JsonObject asJsonObject = PseForm8RequestDoneFragment.this.gson.toJsonTree((LinkedTreeMap) PseForm8RequestDoneFragment.this.addressDetails.get(0)).getAsJsonObject();
                    PseForm8RequestDoneFragment pseForm8RequestDoneFragment = PseForm8RequestDoneFragment.this;
                    if (!String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.HOUSE_NUMBER)).equals("") && !String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.HOUSE_NUMBER)).equals("null")) {
                        StringBuilder sbAppend = new StringBuilder().append(String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.HOUSE_NUMBER)).replace(RegexMatcher.JSON_STRING_REGEX, "")).append(", ").append((String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.LOCALITY_STREET)).equals("") || String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.LOCALITY_STREET)).equals("null")) ? "" : String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.LOCALITY_STREET)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ").append((String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.TOWN_VILLAGE_NEW)).equals("") || String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.TOWN_VILLAGE_NEW)).equals("null")) ? "" : String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.TOWN_VILLAGE_NEW)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ").append((String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.DISTRICT_NAME_ENGLISH)).equals("") || String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.DISTRICT_NAME_ENGLISH)).equals("null")) ? "" : String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.DISTRICT_NAME_ENGLISH)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ");
                        if (!String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.STATE_NAME_ENGLISH)).equals("") && !String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.STATE_NAME_ENGLISH)).equals("null")) {
                            StringBuilder sbAppend2 = new StringBuilder().append(String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.STATE_NAME_ENGLISH)).trim().replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.PIN_CODE_NEW)).equals("") && !String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.PIN_CODE_NEW)).equals("null")) {
                                string = ", " + String.valueOf(asJsonObject.get(PseForm8RequestDoneFragment.PIN_CODE_NEW)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                            }
                            string = sbAppend2.append(string).toString();
                        }
                        string = sbAppend.append(string).toString();
                    }
                    pseForm8RequestDoneFragment.address = string;
                    PseForm8RequestDoneFragment.this.formatABottomsheetBinding.addressTv1.setText(PseForm8RequestDoneFragment.this.address);
                    PseForm8RequestDoneFragment.this.alertDialog1.dismiss();
                    return;
                }
                PseForm8RequestDoneFragment.this.formatABottomsheetBinding.addressTv1.setText("");
                return;
            }
            if (response.code() == 401) {
                PseForm8RequestDoneFragment.this.commomUtility.getRefreshToken(PseForm8RequestDoneFragment.this.getContext(), PseForm8RequestDoneFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$4$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(PseForm8RequestDoneFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(PseForm8RequestDoneFragment.HOUSE_NUMBER_FRAG, e.getMessage());
            }
            PseForm8RequestDoneFragment.this.alertDialog1.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            PseForm8RequestDoneFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                PseForm8RequestDoneFragment.this.commomUtility.showMessageOK(PseForm8RequestDoneFragment.this.requireContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$4$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PseForm8RequestDoneFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(PseForm8RequestDoneFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(PseForm8RequestDoneFragment.this.requireContext()).setToken("Bearer " + str);
            PseForm8RequestDoneFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseForm8RequestDoneFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseForm8RequestDoneFragment.this.requireContext()).setLocaleBool(false);
            PseForm8RequestDoneFragment.this.startActivity(new Intent((Context) PseForm8RequestDoneFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d(PseForm8RequestDoneFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    private void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog3(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestDoneFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog3$3(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog3$3(DialogInterface dialogInterface, int i) {
        openFragment(new PseForm8RequestFragment(), "PseChecklistPreviewFragment");
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
