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
import android.widget.ImageView;
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
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFormatABottomsheetBinding;
import in.gov.eci.bloapp.databinding.BloFormataPendingRvItemBinding;
import in.gov.eci.bloapp.databinding.BloFragmentPseForm8RequestPendingBinding;
import in.gov.eci.bloapp.model.app_model.clusterDetailsDseModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class PseForm8RequestPendingFragment extends BaseFragment {
    private static final String ALERT = "Alert";
    private static final String APPLICATION_JSON = "application/json";
    private static final String COMING_IN_ON_FAILURE = "coming in onFailure ";
    private static final String DISTRICT_NAME_ENGLISH = "districtNameEnglish";
    private static final String EPIC_NUMBER = "epicNumber";
    private static final String ERROR_RESPONSE = "errorResponse";
    private static final String HOUSE_NUMBER = "houseNumber";
    private static final String HOUSE_NUMBER_FRAG = "house_number_frag";
    private static final String LOCALITY_STREET = "localityStreet";
    private static final String PART_NO = "partNo";
    private static final String PIN_CODE = "pinCode";
    private static final String PIN_CODE_NEW = "poPin";
    private static final String SESSION_TOKEN_EXPIRED_PLEASE_LOGIN = "Session token expired please Login";
    private static final String STATE_NAME_ENGLISH = "stateNameEnglish";
    private static final String TOWN_VILLAGE = "townVillage";
    private static final String TOWN_VILLAGE_NEW = "townName";
    private GenericRecyclerView adapter;
    private String address;
    private JSONArray addressDetails;
    private AlertDialog alertDialog1;
    private List<clusterDetailsDseModel> allhousesList;
    private String asmblyNO;
    BloFragmentPseForm8RequestPendingBinding binding;
    private Bitmap bitmap;
    private String blostatecode;
    Retrofit.Builder builder;
    private byte[] byteArray;
    private Dialog dialog;
    private String encodedImage;
    String filepathimg;
    BloFormatABottomsheetBinding formatABottomsheetBinding;
    private String partNo;
    private String photoref;
    private String refreshToken;
    Retrofit retrofit;
    private String stateCode;
    private final CommomUtility commonUtilClass = new CommomUtility();
    private String token = "";
    private JSONArray payloadAllHouses = null;
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public PseForm8RequestPendingFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.blostatecode = "";
        this.photoref = StringUtils.SPACE;
        this.addressDetails = null;
        this.filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentPseForm8RequestPendingBinding.inflate(getLayoutInflater());
        this.allhousesList = new ArrayList();
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
        psePendingList();
        this.binding.searchDsePending.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$$ExternalSyntheticLambda8
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
        bundle.putString("Flag", "0");
        SearchPseFragment searchPseFragment = new SearchPseFragment();
        searchPseFragment.setArguments(bundle);
        openFragment(searchPseFragment, "searchPseFragment");
    }

    public JSONArray psePendingList() {
        this.alertDialog1.show();
        HashMap map = new HashMap();
        map.put("acNo", this.asmblyNO);
        map.put(PART_NO, this.partNo);
        map.put("status", "pending");
        System.out.println("Form8List Json" + new JSONObject(map));
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).pseForm8List(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "Close", "blo", this.blostatecode, map).enqueue(new AnonymousClass1());
        return this.payloadAllHouses;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<EronetResponse> {
        AnonymousClass1() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                Logger.d("mdh fk", String.valueOf(response.body()));
                if (((EronetResponse) response.body()).getPayload() != null) {
                    PseForm8RequestPendingFragment.this.payloadAllHouses = ((EronetResponse) response.body()).getPayload();
                    if (!PseForm8RequestPendingFragment.this.payloadAllHouses.isEmpty()) {
                        Logger.d("json: ", String.valueOf(PseForm8RequestPendingFragment.this.gson.toJsonTree((LinkedTreeMap) PseForm8RequestPendingFragment.this.payloadAllHouses.get(0)).getAsJsonObject()));
                        Logger.d("payload: ", String.valueOf(PseForm8RequestPendingFragment.this.payloadAllHouses));
                        PseForm8RequestPendingFragment pseForm8RequestPendingFragment = PseForm8RequestPendingFragment.this;
                        pseForm8RequestPendingFragment.renderingdata(pseForm8RequestPendingFragment.payloadAllHouses);
                        PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
                        return;
                    }
                    PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
                    PseForm8RequestPendingFragment.this.binding.nodatalayout.setVisibility(0);
                    PseForm8RequestPendingFragment.this.binding.allAppsRv.setVisibility(8);
                    PseForm8RequestPendingFragment.this.binding.searchDsePending.setVisibility(8);
                    return;
                }
                PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
                PseForm8RequestPendingFragment.this.binding.nodatalayout.setVisibility(0);
                PseForm8RequestPendingFragment.this.binding.allAppsRv.setVisibility(8);
                PseForm8RequestPendingFragment.this.binding.searchDsePending.setVisibility(8);
                return;
            }
            if (response.code() == 401) {
                PseForm8RequestPendingFragment.this.commomUtility.getRefreshToken(PseForm8RequestPendingFragment.this.getContext(), PseForm8RequestPendingFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$1$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(PseForm8RequestPendingFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d("All houses", e.getMessage());
            }
            PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
            PseForm8RequestPendingFragment.this.binding.nodatalayout.setVisibility(0);
            PseForm8RequestPendingFragment.this.binding.allAppsRv.setVisibility(8);
            PseForm8RequestPendingFragment.this.binding.searchDsePending.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                PseForm8RequestPendingFragment.this.commomUtility.showMessageOK(PseForm8RequestPendingFragment.this.requireContext(), PseForm8RequestPendingFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PseForm8RequestPendingFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setToken("Bearer " + str);
            PseForm8RequestPendingFragment.this.psePendingList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setLocaleBool(false);
            PseForm8RequestPendingFragment.this.startActivity(new Intent((Context) PseForm8RequestPendingFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d(PseForm8RequestPendingFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public void renderingdata(JSONArray allHouses) {
        this.allhousesList.clear();
        for (int i = 0; i < allHouses.size(); i++) {
            try {
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) allHouses.get(i);
                String str = (String) linkedTreeMap.get(Constants.FIRST_NAME);
                String str2 = (String) linkedTreeMap.get(Constants.LAST_NAME);
                String str3 = (String) linkedTreeMap.get("epicNo");
                String str4 = (String) linkedTreeMap.get("acNo");
                String str5 = (String) linkedTreeMap.get(PART_NO);
                String str6 = (String) linkedTreeMap.get("relationFirstName");
                String str7 = (String) linkedTreeMap.get("relationLastName");
                String str8 = (String) linkedTreeMap.get("relationType");
                String str9 = (String) linkedTreeMap.get("address");
                String str10 = (String) linkedTreeMap.get("slnoInPart");
                String str11 = (String) linkedTreeMap.get("photo");
                this.allhousesList.add(new clusterDetailsDseModel(str, str2, str3, str4, str5, "", (String) linkedTreeMap.get("gender"), str6, str7, str8, str9, Integer.valueOf(str10), (String) linkedTreeMap.get("pseId"), (String) linkedTreeMap.get("dateOfInclusion"), "", str11, (String) linkedTreeMap.get("clusterId"), "", "", 0));
            } catch (Exception e) {
                Logger.d("All houses", e.getMessage());
                Logger.d("error", "Failed to read");
                return;
            }
        }
        initRecyclerViewAdapter();
        this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.allAppsRv.setAdapter(this.adapter);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$2, reason: invalid class name */
    class AnonymousClass2 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass2() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloFormataPendingRvItemBinding.inflate(PseForm8RequestPendingFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            ((BloFormataPendingRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloFormataPendingRvItemBinding) holder.binding).HNoTv.setText(((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getClusterId());
            ((BloFormataPendingRvItemBinding) holder.binding).applicantName.setText(((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getApplicantFirstname() + StringUtils.SPACE + ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getApplicantLastname());
            ((BloFormataPendingRvItemBinding) holder.binding).epicnumber.setText(((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getEpicnumber());
            ((BloFormataPendingRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#ffffff"));
            final String str = ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getApplicantFirstname() + StringUtils.SPACE + ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getApplicantLastname();
            final String str2 = ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getRelationfirstname() + StringUtils.SPACE + ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getRelationlastname();
            final String relationtype = ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getRelationtype();
            final String gender = ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getGender();
            final String epicnumber = ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getEpicnumber();
            final String pseid = ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getPseid();
            final String partnumber = ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getPartnumber();
            final String ac = ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getAc();
            final int iIntValue = ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getSerialno().intValue();
            final String clusterId = ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getClusterId();
            final String dateofinclusion = ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getDateofinclusion();
            final String photo = ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getPhoto();
            final String strReplaceAll = ((clusterDetailsDseModel) PseForm8RequestPendingFragment.this.allhousesList.get(position)).getAddress().replaceAll(",{2,}", ",");
            ((BloFormataPendingRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(str, epicnumber, pseid, partnumber, gender, str2, relationtype, strReplaceAll, ac, dateofinclusion, photo, clusterId, iIntValue, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, View view) {
            PseForm8RequestPendingFragment.this.bottomSheet(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, BitmapFactory.decodeResource(PseForm8RequestPendingFragment.this.getResources(), R.drawable.blo_dummy_image), str12, i);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return PseForm8RequestPendingFragment.this.allhousesList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass2());
        this.binding.allAppsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.allAppsRv.setAdapter(this.adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bottomSheet(String name, String epicno, final String pseId, String partno, String gender, String rlnName, String rlnType, String address12, String acno, String dateofinclusion, String photo, Bitmap dummyimg, String clusterId, final int serialNo) {
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
            this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getFile("objectstorage", photo, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass3());
        } else {
            this.formatABottomsheetBinding.personImage.setImageBitmap(dummyimg);
        }
        HashMap map = new HashMap();
        map.put(EPIC_NUMBER, epicno);
        map.put("acNo", acno);
        map.put("partNumber", partno);
        map.put("stateCd", this.blostatecode);
        ((UserClient) ApiClient.getClient2(requireContext()).create(UserClient.class)).getaddressDetailsPse(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.blostatecode, APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass4());
        this.formatABottomsheetBinding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$2(view);
            }
        });
        this.formatABottomsheetBinding.chooseFileDeletion.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$3(view);
            }
        });
        this.formatABottomsheetBinding.submitForm8request.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$4(pseId, serialNo, view);
            }
        });
        this.formatABottomsheetBinding.crossDialog.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$5(view);
            }
        });
        this.formatABottomsheetBinding.imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$6(view);
            }
        });
        this.dialog.show();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        AnonymousClass3() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                ((JsonObject) response.body()).get("file");
                PseForm8RequestPendingFragment.this.encodedImage = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(PseForm8RequestPendingFragment.this.encodedImage, 0);
                PseForm8RequestPendingFragment.this.bitmap = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                PseForm8RequestPendingFragment.this.formatABottomsheetBinding.personImage.setImageBitmap(PseForm8RequestPendingFragment.this.bitmap);
                return;
            }
            if (response.code() == 401) {
                PseForm8RequestPendingFragment.this.commomUtility.getRefreshToken(PseForm8RequestPendingFragment.this.getContext(), PseForm8RequestPendingFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$3$$ExternalSyntheticLambda1
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
            PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                PseForm8RequestPendingFragment.this.commomUtility.showMessageOK(PseForm8RequestPendingFragment.this.requireContext(), PseForm8RequestPendingFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PseForm8RequestPendingFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setToken("Bearer " + str);
            PseForm8RequestPendingFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setLocaleBool(false);
            PseForm8RequestPendingFragment.this.startActivity(new Intent((Context) PseForm8RequestPendingFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(PseForm8RequestPendingFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<EronetResponse> {
        AnonymousClass4() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.body() != null) {
                PseForm8RequestPendingFragment.this.addressDetails = ((EronetResponse) response.body()).getPayload();
                String string = "";
                if (!PseForm8RequestPendingFragment.this.addressDetails.isEmpty()) {
                    JsonObject asJsonObject = PseForm8RequestPendingFragment.this.gson.toJsonTree((LinkedTreeMap) PseForm8RequestPendingFragment.this.addressDetails.get(0)).getAsJsonObject();
                    PseForm8RequestPendingFragment pseForm8RequestPendingFragment = PseForm8RequestPendingFragment.this;
                    if (!String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.HOUSE_NUMBER)).equals("") && !String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.HOUSE_NUMBER)).equals("null")) {
                        StringBuilder sbAppend = new StringBuilder().append(String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.HOUSE_NUMBER)).replace(RegexMatcher.JSON_STRING_REGEX, "")).append(", ").append((String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.LOCALITY_STREET)).equals("") || String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.LOCALITY_STREET)).equals("null")) ? "" : String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.LOCALITY_STREET)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ").append((String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.TOWN_VILLAGE_NEW)).equals("") || String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.TOWN_VILLAGE_NEW)).equals("null")) ? "" : String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.TOWN_VILLAGE_NEW)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ").append((String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.DISTRICT_NAME_ENGLISH)).equals("") || String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.DISTRICT_NAME_ENGLISH)).equals("null")) ? "" : String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.DISTRICT_NAME_ENGLISH)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ");
                        if (!String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.STATE_NAME_ENGLISH)).equals("") && !String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.STATE_NAME_ENGLISH)).equals("null")) {
                            StringBuilder sbAppend2 = new StringBuilder().append(String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.STATE_NAME_ENGLISH)).trim().replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.PIN_CODE_NEW)).equals("") && !String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.PIN_CODE_NEW)).equals("null")) {
                                string = ", " + String.valueOf(asJsonObject.get(PseForm8RequestPendingFragment.PIN_CODE_NEW)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                            }
                            string = sbAppend2.append(string).toString();
                        }
                        string = sbAppend.append(string).toString();
                    }
                    pseForm8RequestPendingFragment.address = string;
                    PseForm8RequestPendingFragment.this.formatABottomsheetBinding.addressTv1.setText(PseForm8RequestPendingFragment.this.address);
                    PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
                    return;
                }
                PseForm8RequestPendingFragment.this.formatABottomsheetBinding.addressTv1.setText("");
                return;
            }
            if (response.code() == 401) {
                PseForm8RequestPendingFragment.this.commomUtility.getRefreshToken(PseForm8RequestPendingFragment.this.getContext(), PseForm8RequestPendingFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$4$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(PseForm8RequestPendingFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(PseForm8RequestPendingFragment.HOUSE_NUMBER_FRAG, e.getMessage());
            }
            PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                PseForm8RequestPendingFragment.this.commomUtility.showMessageOK(PseForm8RequestPendingFragment.this.requireContext(), PseForm8RequestPendingFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$4$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PseForm8RequestPendingFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setToken("Bearer " + str);
            PseForm8RequestPendingFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setLocaleBool(false);
            PseForm8RequestPendingFragment.this.startActivity(new Intent((Context) PseForm8RequestPendingFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d(PseForm8RequestPendingFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$2(View view) {
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose Image from Gallery", "Cancel"};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$$ExternalSyntheticLambda0
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
    public /* synthetic */ void lambda$bottomSheet$4(String str, int i, View view) {
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
        bundle.putString("serialNo", String.valueOf(i));
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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            this.alertDialog1.dismiss();
        }
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
                restClient.faceRecognitionApi(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", this.blostatecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + this.saveImageFileName.substring(this.saveImageFileName.lastIndexOf(".")), MediaType.parse("fileType"))).enqueue(new AnonymousClass5());
            } catch (Exception e2) {
                Logger.d("CONTENT", e2.getMessage());
                this.alertDialog1.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        AnonymousClass5() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 401) {
                PseForm8RequestPendingFragment.this.commomUtility.getRefreshToken(PseForm8RequestPendingFragment.this.getContext(), PseForm8RequestPendingFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$5$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                PseForm8RequestPendingFragment.this.commonUtilClass.uploadToServer2(PseForm8RequestPendingFragment.this.getContext(), PseForm8RequestPendingFragment.this.stateCode, PseForm8RequestPendingFragment.this.asmblyNO, PseForm8RequestPendingFragment.this.partNo, PseForm8RequestPendingFragment.this.filepathimg, PseForm8RequestPendingFragment.this.saveImageFileName, PseForm8RequestPendingFragment.this.token, "PSEForm8Image", SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$5$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str) {
                        this.f$0.lambda$onResponse$5(i, str);
                    }
                });
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                PseForm8RequestPendingFragment.this.formatABottomsheetBinding.chooseFileName.setText("");
                PseForm8RequestPendingFragment.this.photoref = "";
                PseForm8RequestPendingFragment.this.formatABottomsheetBinding.preview.setImageDrawable(null);
                PseForm8RequestPendingFragment.this.formatABottomsheetBinding.chooseFileDeletion.setVisibility(8);
                PseForm8RequestPendingFragment.this.formatABottomsheetBinding.preview.setVisibility(8);
                PseForm8RequestPendingFragment.this.formatABottomsheetBinding.chooseFileNameSize.setVisibility(8);
                PseForm8RequestPendingFragment.this.formatABottomsheetBinding.chooseFileName.setVisibility(8);
                PseForm8RequestPendingFragment.this.formatABottomsheetBinding.chooseFile.setEnabled(true);
                PseForm8RequestPendingFragment.this.formatABottomsheetBinding.chooseFile.setTextColor(Color.parseColor("#000000"));
                PseForm8RequestPendingFragment.this.showdialog("Alert", jSONObject.optString("message"));
            } catch (IOException | JSONException e) {
                Logger.d("PseForm8RequestPendingFragment", e.toString());
            }
            PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                PseForm8RequestPendingFragment.this.commomUtility.showMessageOK(PseForm8RequestPendingFragment.this.requireContext(), PseForm8RequestPendingFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$5$$ExternalSyntheticLambda5
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PseForm8RequestPendingFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setToken("Bearer " + str);
            PseForm8RequestPendingFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setLocaleBool(false);
            PseForm8RequestPendingFragment.this.startActivity(new Intent((Context) PseForm8RequestPendingFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$5(int i, String str) {
            if (i == 401) {
                PseForm8RequestPendingFragment.this.commonUtilClass.getRefreshToken(PseForm8RequestPendingFragment.this.getContext(), PseForm8RequestPendingFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$5$$ExternalSyntheticLambda2
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$onResponse$4(i2, str2, str3);
                    }
                });
            } else {
                PseForm8RequestPendingFragment.this.photoref = str;
                PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4(int i, String str, String str2) {
            PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                PseForm8RequestPendingFragment.this.commonUtilClass.showMessageOK(PseForm8RequestPendingFragment.this.requireContext(), PseForm8RequestPendingFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$5$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$2(dialogInterface, i2);
                    }
                });
                return;
            }
            PseForm8RequestPendingFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setToken("Bearer " + str);
            PseForm8RequestPendingFragment.this.commonUtilClass.uploadToServer2(PseForm8RequestPendingFragment.this.getContext(), PseForm8RequestPendingFragment.this.stateCode, PseForm8RequestPendingFragment.this.asmblyNO, PseForm8RequestPendingFragment.this.partNo, PseForm8RequestPendingFragment.this.filepathimg, PseForm8RequestPendingFragment.this.saveImageFileName, PseForm8RequestPendingFragment.this.token, "PSEForm8Image", SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$5$$ExternalSyntheticLambda4
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i2, String str3) {
                    this.f$0.lambda$onResponse$3(i2, str3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseForm8RequestPendingFragment.this.requireContext()).setLocaleBool(false);
            PseForm8RequestPendingFragment.this.startActivity(new Intent((Context) PseForm8RequestPendingFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(int i, String str) {
            PseForm8RequestPendingFragment.this.photoref = str;
            PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Toast.makeText(PseForm8RequestPendingFragment.this.getContext(), t.getMessage(), 1).show();
            PseForm8RequestPendingFragment.this.alertDialog1.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
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
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseForm8RequestPendingFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog3$8(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog3$8(DialogInterface dialogInterface, int i) {
        openFragment(new PseForm8RequestFragment(), "PseChecklistPreviewFragment");
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
