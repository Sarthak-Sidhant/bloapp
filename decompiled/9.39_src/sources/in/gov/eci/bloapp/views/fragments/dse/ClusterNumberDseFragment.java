package in.gov.eci.bloapp.views.fragments.dse;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.databinding.BloClusterNumberDseRvItemBinding;
import in.gov.eci.bloapp.databinding.BloDseDetailsBinding;
import in.gov.eci.bloapp.databinding.BloFragmentClusterNumberDseBinding;
import in.gov.eci.bloapp.model.Form7ReasonSpinnerItem;
import in.gov.eci.bloapp.model.app_model.clusterDetailsDseModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.DseActivity;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ClusterNumberDseFragment extends BaseFragment {
    private static final String ACTION1 = "action";
    private static final String ALERT = "Alert";
    private static final String APPLICATION_JSON = "application/json";
    private static final String BLACK_COLOR = "#99000000";
    private static final String CLUSTER_ID = "clusterId";
    private static final String COMING_IN_ON_FAILURE = "coming in onFailure ";
    private static final String CONTENT = "CONTENT";
    private static final String DISTRICT_NAME_ENGLISH = "districtNameEnglish";
    private static final String DSE_CLUSTER_ID = "dseClusterId";
    private static final String DSE_ID = "dseId";
    private static final String DSE_TYPE = "dseType";
    private static final String EPIC_NO = "epicNo";
    private static final String EPIC_NUMBER = "epicNumber";
    private static final String ERROR_RESPONSE = "errorResponse";
    private static final String FORM_7_NOT_SUBMITTED_SUCCESSFULLY = "Form 7 not Submitted Successfully";
    private static final String GENDER1 = "gender";
    private static final String HOUSE_NUMBER = "houseNumber";
    private static final String HOUSE_NUMBER_FRAG = "house_number_frag";
    private static final String IS_LIFE_CYCLE_REQUEST = "isLifeCycleRequest";
    private static final String LOCALITY_STREET = "localityStreet";
    private static final String MESSAGE = "message";
    private static final String OTHER = "Other";
    private static final String PART_NO = "partNo";
    private static final String PIN_CODE = "pinCode";
    private static final String PIN_CODE_NEW = "poPin";
    private static final String RELATION_TYPE = "relationType";
    private static final String REMARK = "remark";
    private static final String SESSION_TOKEN_EXPIRED_PLEASE_LOGIN = "Session token expired please Login";
    private static final String STATE_CD = "stateCd";
    private static final String STATE_NAME_ENGLISH = "stateNameEnglish";
    private static final String TOWN_VILLAGE = "townVillage";
    private static final String TOWN_VILLAGE_NEW = "townName";
    private String acno;
    private String action;
    ActivityResultLauncher<Intent> activityResultLauncher1;
    private GenericRecyclerView adapter;
    private String address;
    private String age;
    private AlertDialog alertDialog;
    private String applicantName;
    private String asmblyNO;
    private String atkband;
    BloFragmentClusterNumberDseBinding binding;
    private Bitmap bitmap;
    private String bloOutput;
    private String blostatecode;
    Retrofit.Builder builder;
    private byte[] byteArray;
    private String clusterId;
    CommomUtility commonUtilClass;
    ArrayList<String> deletionReasonList;
    private Dialog dialog;
    BloDseDetailsBinding dseDetailsBinding;
    private String dseType;
    private String encodedImage;
    private String epicNo;
    String filepathimg;
    private List<clusterDetailsDseModel> finalDetailsList;
    private String flagValue;
    private String formatBRemark;
    private String gender;
    private List<clusterDetailsDseModel> housedetailList;
    Uri imageUri;
    private List<clusterDetailsDseModel> newDetailsList;
    private String partNo;
    private String refreshToken;
    private String relationName;
    private String relationType;
    private String remarks;
    private List<clusterDetailsDseModel> removedDetailsList;
    ArrayList<String> responseFormatAList;
    Retrofit retrofit;
    private String rtkband;
    private String selectedReason;
    private String selectedRemark;
    String selectefForm7Reason;
    List<Form7ReasonSpinnerItem> spinnerItemList;
    private String stateCode;
    private String token = "";
    private JSONArray payloadHousedetails = null;
    private JSONArray addressDetails = null;
    private String passref = " ";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().retryOnConnectionFailure(true).connectTimeout(3, TimeUnit.MINUTES).readTimeout(3, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    private void submitForm7(String epic, String dseId, int serialNo, String clusterId, String name) {
    }

    public ClusterNumberDseFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.blostatecode = "";
        this.responseFormatAList = new ArrayList<>();
        this.commonUtilClass = new CommomUtility();
        this.deletionReasonList = new ArrayList<>();
        this.activityResultLauncher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new AnonymousClass9());
        this.filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentClusterNumberDseBinding.inflate(inflater);
        this.finalDetailsList = new ArrayList();
        this.newDetailsList = new ArrayList();
        this.removedDetailsList = new ArrayList();
        this.housedetailList = new ArrayList();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.clusterId = arguments.getString(CLUSTER_ID);
            this.applicantName = arguments.getString("applicantName");
            this.relationName = arguments.getString("relationName");
            this.relationType = arguments.getString(RELATION_TYPE);
            this.gender = arguments.getString(GENDER1);
            this.age = arguments.getString("age");
            this.dseType = String.valueOf(arguments.getInt(DSE_TYPE));
            this.flagValue = arguments.getString("Flag");
        }
        System.out.println("cluster Idkhbsd" + this.clusterId);
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.headTitle.setText(this.clusterId);
        this.binding.electorName.setText(this.applicantName);
        if (this.gender.equals("M")) {
            this.binding.gender.setText("Male");
        } else if (this.gender.equals("F")) {
            this.binding.gender.setText("Female");
        } else if (this.gender.equals("T")) {
            this.binding.gender.setText(OTHER);
        }
        this.binding.age12.setText(this.age);
        this.binding.relativeName.setText(this.relationName);
        if (this.relationType.equals("F") || this.relationType.equals("FTHR")) {
            this.binding.relativeType.setText("Father");
        } else if (this.relationType.equals("M") || this.relationType.equals("MTHR")) {
            this.binding.relativeType.setText("Mother");
        } else if (this.relationType.equals("H") || this.relationType.equals("HSBN")) {
            this.binding.relativeType.setText("Husband");
        } else if (this.relationType.equals("W") || this.relationType.equals("WIFE")) {
            this.binding.relativeType.setText("Wife");
        } else if (this.relationType.equals("L") || this.relationType.equals("OTHR")) {
            this.binding.relativeType.setText(OTHER);
        } else {
            this.binding.relativeType.setText("");
        }
        this.blostatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        this.atkband = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(requireContext()).getRtknBnd();
        if (this.flagValue.equals("0") || this.flagValue.equals("2")) {
            pseclusterDetails();
        } else {
            dseDoneclusterDetails();
        }
        ArrayList arrayList = new ArrayList();
        this.spinnerItemList = arrayList;
        arrayList.add(new Form7ReasonSpinnerItem("", "Select Reason"));
        this.spinnerItemList.add(new Form7ReasonSpinnerItem("DETH", "Death"));
        this.spinnerItemList.add(new Form7ReasonSpinnerItem("UAGE", "Under Age"));
        this.spinnerItemList.add(new Form7ReasonSpinnerItem("ABSH", "Absent/Permanently shifted"));
        this.spinnerItemList.add(new Form7ReasonSpinnerItem("AERL", "Already Enrolled"));
        this.spinnerItemList.add(new Form7ReasonSpinnerItem("NIND", "Not Indian Citizen"));
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        if (getFragmentManager().getBackStackEntryCount() != 0) {
            getFragmentManager().popBackStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    public void pseclusterDetails() {
        System.out.println("coming here");
        Logger.d("in cluster details fetch..............................", "");
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put(STATE_CD, this.blostatecode);
        map.put(DSE_CLUSTER_ID, this.clusterId);
        map.put(DSE_TYPE, this.dseType);
        System.out.println("pending json NO" + new JSONObject(map));
        System.out.println("atkn" + this.atkband);
        System.out.println("rtkn" + this.rtkband);
        System.out.println(DSE_TYPE + this.dseType);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getclusterDetailsDse(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", this.blostatecode, "ANDROIDMOB", map).enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<EronetResponse> {
        AnonymousClass1() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            Logger.d("ksjhf", String.valueOf(response.body()));
            System.out.println("response code" + response.code());
            if (response.code() == 200) {
                ClusterNumberDseFragment.this.payloadHousedetails = ((EronetResponse) response.body()).getPayload();
                if (ClusterNumberDseFragment.this.payloadHousedetails.isEmpty()) {
                    return;
                }
                Logger.d("json: ", String.valueOf(ClusterNumberDseFragment.this.gson.toJsonTree((LinkedTreeMap) ClusterNumberDseFragment.this.payloadHousedetails.get(0)).getAsJsonObject()));
                Logger.d("payload: ", String.valueOf(ClusterNumberDseFragment.this.payloadHousedetails));
                ClusterNumberDseFragment clusterNumberDseFragment = ClusterNumberDseFragment.this;
                clusterNumberDseFragment.renderingdata(clusterNumberDseFragment.payloadHousedetails);
                ClusterNumberDseFragment.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                ClusterNumberDseFragment.this.commomUtility.getRefreshToken(ClusterNumberDseFragment.this.getContext(), ClusterNumberDseFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$1$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(ClusterNumberDseFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(ClusterNumberDseFragment.HOUSE_NUMBER_FRAG, e.getMessage());
            }
            ClusterNumberDseFragment.this.alertDialog.dismiss();
            ClusterNumberDseFragment.this.showdialog2("Alert", "NO Record Found");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            ClusterNumberDseFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ClusterNumberDseFragment.this.commomUtility.showMessageOK(ClusterNumberDseFragment.this.requireContext(), ClusterNumberDseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ClusterNumberDseFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setToken("Bearer " + str);
            ClusterNumberDseFragment.this.pseclusterDetails();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setLocaleBool(false);
            ClusterNumberDseFragment.this.startActivity(new Intent((Context) ClusterNumberDseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            ClusterNumberDseFragment.this.alertDialog.dismiss();
            ClusterNumberDseFragment.this.showdialog4("Alert", "Unable to load data, Please try again.");
            Logger.d(ClusterNumberDseFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public void dseDoneclusterDetails() {
        Logger.d("in Done cluster details fetch..............................", "");
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put(STATE_CD, this.blostatecode);
        map.put(DSE_CLUSTER_ID, this.clusterId);
        map.put("bloAcNo", this.asmblyNO);
        map.put("bloPartNo", this.partNo);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getDoneclusterDetails(this.token, this.atkband, this.rtkband, "BLOAPP", "Close", "blo", this.blostatecode, map).enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<EronetResponse> {
        AnonymousClass2() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            Logger.d("ksjhfDONE--------------------", String.valueOf(response.body()));
            if (response.code() == 200) {
                ClusterNumberDseFragment.this.payloadHousedetails = ((EronetResponse) response.body()).getPayload();
                if (ClusterNumberDseFragment.this.payloadHousedetails.isEmpty()) {
                    return;
                }
                Logger.d("json: ", String.valueOf(ClusterNumberDseFragment.this.gson.toJsonTree((LinkedTreeMap) ClusterNumberDseFragment.this.payloadHousedetails.get(0)).getAsJsonObject()));
                Logger.d("payload: ", String.valueOf(ClusterNumberDseFragment.this.payloadHousedetails));
                ClusterNumberDseFragment clusterNumberDseFragment = ClusterNumberDseFragment.this;
                clusterNumberDseFragment.renderingdataDone(clusterNumberDseFragment.payloadHousedetails);
                ClusterNumberDseFragment.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                ClusterNumberDseFragment.this.commomUtility.getRefreshToken(ClusterNumberDseFragment.this.getContext(), ClusterNumberDseFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$2$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(ClusterNumberDseFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(ClusterNumberDseFragment.HOUSE_NUMBER_FRAG, e.getMessage());
            }
            ClusterNumberDseFragment.this.alertDialog.dismiss();
            ClusterNumberDseFragment.this.showdialog2("Alert", "NO Record Found");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            ClusterNumberDseFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ClusterNumberDseFragment.this.commomUtility.showMessageOK(ClusterNumberDseFragment.this.requireContext(), ClusterNumberDseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ClusterNumberDseFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setToken("Bearer " + str);
            ClusterNumberDseFragment.this.dseDoneclusterDetails();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setLocaleBool(false);
            ClusterNumberDseFragment.this.startActivity(new Intent((Context) ClusterNumberDseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            ClusterNumberDseFragment.this.alertDialog.dismiss();
            ClusterNumberDseFragment.this.showdialog4("Alert", "Unable to load data, Please try again.");
            Logger.d(ClusterNumberDseFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public void renderingdataDone(JSONArray housedetails) {
        String str;
        String strValueOf;
        this.housedetailList.clear();
        this.finalDetailsList.clear();
        this.removedDetailsList.clear();
        this.newDetailsList.clear();
        for (int i = 0; i < housedetails.size(); i++) {
            LinkedTreeMap linkedTreeMap = (LinkedTreeMap) housedetails.get(i);
            String str2 = (String) linkedTreeMap.get(Constants.FIRST_NAME);
            String str3 = (String) linkedTreeMap.get(Constants.LAST_NAME);
            String str4 = (str2 == null || str2.equals("null")) ? "" : str2;
            String str5 = (str3 == null || str3.equals("null")) ? "" : str3;
            this.epicNo = (String) linkedTreeMap.get(EPIC_NO);
            this.acno = String.valueOf(linkedTreeMap.get("acNo"));
            String strValueOf2 = String.valueOf(linkedTreeMap.get(PART_NO));
            addressDetails(this.epicNo, this.acno, strValueOf2);
            String strValueOf3 = String.valueOf(linkedTreeMap.get("age"));
            String str6 = (String) linkedTreeMap.get(GENDER1);
            String str7 = (String) linkedTreeMap.get("relationFirstName");
            String str8 = (String) linkedTreeMap.get("relationLastName");
            String str9 = (str7 == null || str7.equals("null")) ? "" : str7;
            String str10 = (str8 == null || str8.equals("null")) ? "" : str8;
            String str11 = (String) linkedTreeMap.get(RELATION_TYPE);
            String strValueOf4 = String.valueOf(linkedTreeMap.get(DSE_ID));
            String strValueOf5 = String.valueOf(linkedTreeMap.get(DSE_CLUSTER_ID));
            String str12 = (String) linkedTreeMap.get("photo");
            String str13 = (String) linkedTreeMap.get("createdDttm");
            String strValueOf6 = String.valueOf(linkedTreeMap.get("dseStatus"));
            if (this.flagValue.equals("1")) {
                String str14 = (String) linkedTreeMap.get(REMARK);
                strValueOf = String.valueOf(linkedTreeMap.get(ACTION1));
                str = str14;
            } else {
                str = "";
                strValueOf = str;
            }
            Double d = (Double) linkedTreeMap.get("bloStatusId");
            this.finalDetailsList.add(new clusterDetailsDseModel(str4, str5, this.epicNo, this.acno, strValueOf2, strValueOf3, str6, str9, str10, str11, null, 0, strValueOf4, str13, strValueOf6, str12, strValueOf5, str, strValueOf, Integer.valueOf(d != null ? d.intValue() : 0)));
        }
        for (int i2 = 0; i2 < this.finalDetailsList.size(); i2++) {
            if (this.partNo.equals(this.finalDetailsList.get(i2).getPartnumber())) {
                this.newDetailsList.add(this.finalDetailsList.get(i2));
            }
        }
        for (int i3 = 0; i3 < this.finalDetailsList.size(); i3++) {
            if (!this.partNo.equals(this.finalDetailsList.get(i3).getPartnumber())) {
                this.removedDetailsList.add(this.finalDetailsList.get(i3));
            }
        }
        this.housedetailList.addAll(this.newDetailsList);
        this.housedetailList.addAll(this.removedDetailsList);
        initRecyclerViewAdapter();
        this.binding.houseDetailsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.houseDetailsRv.setAdapter(this.adapter);
    }

    public void renderingdata(JSONArray housedetails) {
        String strValueOf;
        this.housedetailList.clear();
        this.finalDetailsList.clear();
        this.removedDetailsList.clear();
        this.newDetailsList.clear();
        for (int i = 0; i < housedetails.size(); i++) {
            LinkedTreeMap linkedTreeMap = (LinkedTreeMap) housedetails.get(i);
            String str = (String) linkedTreeMap.get(Constants.FIRST_NAME);
            String str2 = (String) linkedTreeMap.get(Constants.LAST_NAME);
            String strValueOf2 = "";
            String str3 = (str == null || str.equals("null")) ? "" : str;
            String str4 = (str2 == null || str2.equals("null")) ? "" : str2;
            this.epicNo = (String) linkedTreeMap.get(EPIC_NO);
            this.acno = String.valueOf(((Double) linkedTreeMap.get("acNo")).intValue());
            String strValueOf3 = String.valueOf(((Double) linkedTreeMap.get(PART_NO)).intValue());
            String strValueOf4 = String.valueOf(((Double) linkedTreeMap.get("age")).intValue());
            String str5 = (String) linkedTreeMap.get(GENDER1);
            String str6 = (String) linkedTreeMap.get("relationFirstName");
            String str7 = (String) linkedTreeMap.get("relationLastName");
            String str8 = (str6 == null || str6.equals("null")) ? "" : str6;
            String str9 = (str7 == null || str7.equals("null")) ? "" : str7;
            String str10 = (String) linkedTreeMap.get(RELATION_TYPE);
            int iIntValue = ((Double) linkedTreeMap.get("slNoInPart")).intValue();
            String strValueOf5 = String.valueOf(((Double) linkedTreeMap.get(DSE_ID)).intValue());
            String strValueOf6 = String.valueOf(((Double) linkedTreeMap.get(DSE_CLUSTER_ID)).intValue());
            String str11 = (String) linkedTreeMap.get("photo");
            String str12 = (String) linkedTreeMap.get("createdDttm");
            Double d = (Double) linkedTreeMap.get("bloStatusId");
            if (d == null) {
                strValueOf = "10";
            } else {
                strValueOf = String.valueOf(d.intValue());
            }
            String str13 = strValueOf;
            String strValueOf7 = String.valueOf(((Double) linkedTreeMap.get("epicId")).intValue());
            if (this.flagValue.equals("1")) {
                strValueOf7 = (String) linkedTreeMap.get(REMARK);
                strValueOf2 = String.valueOf(linkedTreeMap.get(ACTION1));
            }
            this.finalDetailsList.add(new clusterDetailsDseModel(str3, str4, this.epicNo, this.acno, strValueOf3, strValueOf4, str5, str8, str9, str10, null, Integer.valueOf(iIntValue), strValueOf5, str12, str13, str11, strValueOf6, strValueOf7, strValueOf2, Integer.valueOf(((Double) linkedTreeMap.get("bloStatusId")).intValue())));
        }
        for (int i2 = 0; i2 < this.finalDetailsList.size(); i2++) {
            if (this.partNo.equals(this.finalDetailsList.get(i2).getPartnumber())) {
                this.newDetailsList.add(this.finalDetailsList.get(i2));
            }
        }
        for (int i3 = 0; i3 < this.finalDetailsList.size(); i3++) {
            if (!this.partNo.equals(this.finalDetailsList.get(i3).getPartnumber())) {
                this.removedDetailsList.add(this.finalDetailsList.get(i3));
            }
        }
        this.housedetailList.addAll(this.newDetailsList);
        this.housedetailList.addAll(this.removedDetailsList);
        initRecyclerViewAdapter();
        this.binding.houseDetailsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.houseDetailsRv.setAdapter(this.adapter);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$3, reason: invalid class name */
    class AnonymousClass3 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass3() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloClusterNumberDseRvItemBinding.inflate(ClusterNumberDseFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
            String str;
            ((BloClusterNumberDseRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloClusterNumberDseRvItemBinding) holder.binding).epicNoET.setText(((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getEpicnumber());
            ((BloClusterNumberDseRvItemBinding) holder.binding).acPartnoET.setText(((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getAc() + " // " + ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getPartnumber());
            HashMap map = new HashMap();
            map.put(ClusterNumberDseFragment.EPIC_NUMBER, ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getEpicnumber());
            map.put("acNo", ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getAc());
            map.put("partNumber", ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getPartnumber());
            map.put(ClusterNumberDseFragment.STATE_CD, ClusterNumberDseFragment.this.blostatecode);
            ClusterNumberDseFragment.this.commonUtilClass.getRetrofitClient(ClusterNumberDseFragment.this.getContext(), ClusterNumberDseFragment.this.token, ClusterNumberDseFragment.this.atkband, ClusterNumberDseFragment.this.rtkband).getaddressDetails(ClusterNumberDseFragment.this.token, ClusterNumberDseFragment.this.atkband, ClusterNumberDseFragment.this.rtkband, "BLOAPP", "blo", ClusterNumberDseFragment.this.blostatecode, ClusterNumberDseFragment.APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass1(holder));
            if (((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getPhoto() != null) {
                Logger.d("photo---------------", ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getPhoto());
                ClusterNumberDseFragment.this.commonUtilClass.getRetrofitClient(ClusterNumberDseFragment.this.getContext(), ClusterNumberDseFragment.this.token, ClusterNumberDseFragment.this.atkband, ClusterNumberDseFragment.this.rtkband).getFile("objectstorage", ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getPhoto(), ClusterNumberDseFragment.this.token, ClusterNumberDseFragment.this.atkband, ClusterNumberDseFragment.this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment.3.2
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.code() == 200) {
                            ((JsonObject) response.body()).get("file");
                            ClusterNumberDseFragment.this.encodedImage = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                            if (ClusterNumberDseFragment.this.encodedImage == null) {
                                ((BloClusterNumberDseRvItemBinding) holder.binding).imageView9.setImageBitmap(BitmapFactory.decodeResource(ClusterNumberDseFragment.this.getResources(), R.drawable.blo_dummy_image));
                                return;
                            } else {
                                byte[] bArrDecode = Base64.decode(ClusterNumberDseFragment.this.encodedImage, 0);
                                ClusterNumberDseFragment.this.bitmap = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                                ((BloClusterNumberDseRvItemBinding) holder.binding).imageView9.setImageBitmap(ClusterNumberDseFragment.this.bitmap);
                                return;
                            }
                        }
                        try {
                            Logger.d("imageerror", new JSONObject(response.errorBody().string()).optString(ClusterNumberDseFragment.MESSAGE));
                        } catch (Exception e) {
                            Logger.e("", e.getMessage());
                        }
                    }

                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Logger.d(ClusterNumberDseFragment.COMING_IN_ON_FAILURE, t.getMessage());
                    }
                });
            } else {
                ((BloClusterNumberDseRvItemBinding) holder.binding).imageView9.setImageBitmap(BitmapFactory.decodeResource(ClusterNumberDseFragment.this.getResources(), R.drawable.blo_dummy_image));
            }
            if (ClusterNumberDseFragment.this.partNo.equals(((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getPartnumber()) && ClusterNumberDseFragment.this.asmblyNO.equals(((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getAc())) {
                ((BloClusterNumberDseRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#C9F2FF"));
            } else {
                ((BloClusterNumberDseRvItemBinding) holder.binding).layout.setBackgroundColor(Color.parseColor("#ffffff"));
            }
            final String str2 = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getApplicantFirstname() + " " + ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getApplicantLastname();
            final String epicnumber = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getEpicnumber();
            final String age = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getAge();
            final String gender = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getGender();
            final String str3 = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getRelationfirstname() + " " + ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getRelationlastname();
            final String relationtype = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getRelationtype();
            String ac = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getAc();
            final String partnumber = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getPartnumber();
            final String pseid = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getPseid();
            final int iIntValue = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getSerialno().intValue();
            final String dateofinclusion = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getDateofinclusion();
            final String bloVerifStatus = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getBloVerifStatus();
            final String clusterId = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getClusterId();
            final String bloVerifStatus2 = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getBloVerifStatus();
            final String remark = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getRemark();
            final String actionKey = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getActionKey();
            final String photo = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getPhoto();
            int bloStatusId = ((clusterDetailsDseModel) ClusterNumberDseFragment.this.housedetailList.get(position)).getBloStatusId();
            if (ClusterNumberDseFragment.this.flagValue.equals("0") || ClusterNumberDseFragment.this.flagValue.equals("2")) {
                str = ac;
                ((BloClusterNumberDseRvItemBinding) holder.binding).actionTokenLayout.setVisibility(8);
            } else {
                str = ac;
                ((BloClusterNumberDseRvItemBinding) holder.binding).actionTokenLayout.setVisibility(0);
                if (actionKey.equals("3")) {
                    ((BloClusterNumberDseRvItemBinding) holder.binding).actiontokenTv1.setText("Original");
                } else if (actionKey.equals("4")) {
                    ((BloClusterNumberDseRvItemBinding) holder.binding).actiontokenTv1.setText("ASD (Absent/Shifted/Dead)");
                } else if (actionKey.equals("5")) {
                    ((BloClusterNumberDseRvItemBinding) holder.binding).actiontokenTv1.setText("PN (Photograph Not-matching)");
                } else if (actionKey.equals("1")) {
                    ((BloClusterNumberDseRvItemBinding) holder.binding).actiontokenTv1.setText("No Information");
                } else if (actionKey.equals("2")) {
                    ((BloClusterNumberDseRvItemBinding) holder.binding).actiontokenTv1.setText("Duplicate");
                }
            }
            if (bloStatusId == 1) {
                ((BloClusterNumberDseRvItemBinding) holder.binding).statusCapsule.setVisibility(0);
                ((BloClusterNumberDseRvItemBinding) holder.binding).statusCapsule.setBackgroundColor(ClusterNumberDseFragment.this.getResources().getColor(R.color.blo_callRequest_activeDue));
                ((BloClusterNumberDseRvItemBinding) holder.binding).statusCapsule.setText("Pending");
            } else if (bloStatusId == 2) {
                ((BloClusterNumberDseRvItemBinding) holder.binding).statusCapsule.setVisibility(0);
                ((BloClusterNumberDseRvItemBinding) holder.binding).statusCapsule.setText("Action Taken");
                ((BloClusterNumberDseRvItemBinding) holder.binding).statusCapsule.setBackgroundColor(ClusterNumberDseFragment.this.getResources().getColor(R.color.blo_callRequest_active));
            } else {
                ((BloClusterNumberDseRvItemBinding) holder.binding).statusCapsule.setVisibility(8);
            }
            final Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(ClusterNumberDseFragment.this.getResources(), R.drawable.blo_dummy_image);
            final String str4 = str;
            ((BloClusterNumberDseRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$3$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(bloVerifStatus2, str2, epicnumber, pseid, partnumber, age, gender, str3, relationtype, str4, dateofinclusion, photo, bitmapDecodeResource, clusterId, remark, actionKey, iIntValue, bloVerifStatus, view);
                }
            });
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$3$1, reason: invalid class name */
        class AnonymousClass1 implements Callback<EronetResponse> {
            final /* synthetic */ RecyclerViewHolder val$holder;

            AnonymousClass1(final RecyclerViewHolder val$holder) {
                this.val$holder = val$holder;
            }

            public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
                if (response.code() == 200) {
                    ClusterNumberDseFragment.this.addressDetails = ((EronetResponse) response.body()).getPayload();
                    String string = "";
                    if (!ClusterNumberDseFragment.this.addressDetails.isEmpty()) {
                        JsonObject asJsonObject = ClusterNumberDseFragment.this.gson.toJsonTree((LinkedTreeMap) ClusterNumberDseFragment.this.addressDetails.get(0)).getAsJsonObject();
                        ClusterNumberDseFragment clusterNumberDseFragment = ClusterNumberDseFragment.this;
                        if (!String.valueOf(asJsonObject.get(ClusterNumberDseFragment.HOUSE_NUMBER)).equals("") && !String.valueOf(asJsonObject.get(ClusterNumberDseFragment.HOUSE_NUMBER)).equals("null")) {
                            StringBuilder sbAppend = new StringBuilder().append(String.valueOf(asJsonObject.get(ClusterNumberDseFragment.HOUSE_NUMBER)).replace(RegexMatcher.JSON_STRING_REGEX, "")).append(", ").append((String.valueOf(asJsonObject.get(ClusterNumberDseFragment.LOCALITY_STREET)).equals("") || String.valueOf(asJsonObject.get(ClusterNumberDseFragment.LOCALITY_STREET)).equals("null")) ? "" : String.valueOf(asJsonObject.get(ClusterNumberDseFragment.LOCALITY_STREET)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ").append((String.valueOf(asJsonObject.get(ClusterNumberDseFragment.TOWN_VILLAGE_NEW)).equals("") || String.valueOf(asJsonObject.get(ClusterNumberDseFragment.TOWN_VILLAGE_NEW)).equals("null")) ? "" : String.valueOf(asJsonObject.get(ClusterNumberDseFragment.TOWN_VILLAGE_NEW)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ").append((String.valueOf(asJsonObject.get(ClusterNumberDseFragment.DISTRICT_NAME_ENGLISH)).equals("") || String.valueOf(asJsonObject.get(ClusterNumberDseFragment.DISTRICT_NAME_ENGLISH)).equals("null")) ? "" : String.valueOf(asJsonObject.get(ClusterNumberDseFragment.DISTRICT_NAME_ENGLISH)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ");
                            if (!String.valueOf(asJsonObject.get(ClusterNumberDseFragment.STATE_NAME_ENGLISH)).equals("") && !String.valueOf(asJsonObject.get(ClusterNumberDseFragment.STATE_NAME_ENGLISH)).equals("null")) {
                                StringBuilder sbAppend2 = new StringBuilder().append(String.valueOf(asJsonObject.get(ClusterNumberDseFragment.STATE_NAME_ENGLISH)).trim().replace(RegexMatcher.JSON_STRING_REGEX, ""));
                                if (!String.valueOf(asJsonObject.get(ClusterNumberDseFragment.PIN_CODE_NEW)).equals("") && !String.valueOf(asJsonObject.get(ClusterNumberDseFragment.PIN_CODE_NEW)).equals("null")) {
                                    string = ", " + String.valueOf(asJsonObject.get(ClusterNumberDseFragment.PIN_CODE_NEW)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                                }
                                string = sbAppend2.append(string).toString();
                            }
                            string = sbAppend.append(string).toString();
                        }
                        clusterNumberDseFragment.address = string;
                        ((BloClusterNumberDseRvItemBinding) this.val$holder.binding).addressEt.setText(ClusterNumberDseFragment.this.address.replaceAll("[,]+", ","));
                        ClusterNumberDseFragment.this.alertDialog.dismiss();
                        return;
                    }
                    ((BloClusterNumberDseRvItemBinding) this.val$holder.binding).addressEt.setText("");
                    return;
                }
                if (response.code() == 401) {
                    ClusterNumberDseFragment.this.commomUtility.getRefreshToken(ClusterNumberDseFragment.this.getContext(), ClusterNumberDseFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$3$1$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str, String str2) {
                            this.f$0.lambda$onResponse$1(i, str, str2);
                        }
                    });
                    return;
                }
                try {
                    Logger.d(ClusterNumberDseFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
                } catch (IOException | JSONException e) {
                    Logger.d(ClusterNumberDseFragment.HOUSE_NUMBER_FRAG, e.getMessage());
                }
                ClusterNumberDseFragment.this.alertDialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                ClusterNumberDseFragment.this.alertDialog.dismiss();
                System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                if (i == 401 || i == 400) {
                    ClusterNumberDseFragment.this.commomUtility.showMessageOK(ClusterNumberDseFragment.this.requireContext(), ClusterNumberDseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$3$1$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                        }
                    });
                    return;
                }
                ClusterNumberDseFragment.this.token = "Bearer " + str;
                SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setRefreshToken(str2);
                SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setToken("Bearer " + str);
                ClusterNumberDseFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setLocaleBool(false);
                ClusterNumberDseFragment.this.startActivity(new Intent((Context) ClusterNumberDseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
            }

            public void onFailure(Call<EronetResponse> call, Throwable t) {
                Logger.d(ClusterNumberDseFragment.COMING_IN_ON_FAILURE, t.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Bitmap bitmap, String str13, String str14, String str15, int i, String str16, View view) {
            if (ClusterNumberDseFragment.this.flagValue.equals("2")) {
                Logger.d(ClusterNumberDseFragment.CONTENT, "Coming from Dse Identified");
                return;
            }
            if (ClusterNumberDseFragment.this.flagValue.equals("0")) {
                if (str.equals("1")) {
                    ClusterNumberDseFragment.this.bottomSheet(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, bitmap, str13, str14, str15, i);
                    return;
                } else {
                    ClusterNumberDseFragment.this.showdialog("Alert", "Already Submitted");
                    return;
                }
            }
            Logger.d("NO action performed", str16);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return ClusterNumberDseFragment.this.housedetailList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bottomSheet(String name, final String epicno, final String dseID, final String partno, String age, String gender, String rlnName, String rlnType, final String acno, String dateofinclusion, String photo, Bitmap dummyimg, final String clusterId, final String remark, String actionkey, int serialNo) {
        String str;
        final String str2;
        Date date;
        Dialog dialog = new Dialog(getContext());
        this.dialog = dialog;
        dialog.requestWindowFeature(1);
        BloDseDetailsBinding bloDseDetailsBindingInflate = BloDseDetailsBinding.inflate(getLayoutInflater());
        this.dseDetailsBinding = bloDseDetailsBindingInflate;
        this.dialog.setContentView((View) bloDseDetailsBindingInflate.getRoot());
        this.dialog.getWindow().setLayout(-1, -2);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        this.dialog.getWindow().setGravity(80);
        this.dseDetailsBinding.bottomSubmitLayout.setVisibility(0);
        this.dseDetailsBinding.fillForm7.setVisibility(8);
        this.dseDetailsBinding.fillForm8.setVisibility(8);
        this.dseDetailsBinding.deletionReason.setVisibility(8);
        this.dseDetailsBinding.preview1.setVisibility(8);
        this.dseDetailsBinding.chooseFileDeletion1.setVisibility(8);
        this.dseDetailsBinding.chooseFileName1.setVisibility(8);
        this.dseDetailsBinding.chooseFileNameSize1.setVisibility(8);
        if (this.flagValue.equals("0")) {
            this.dseDetailsBinding.pendingLayout.setVisibility(0);
            this.dseDetailsBinding.bottomSubmitLayout.setVisibility(0);
            this.dseDetailsBinding.DoneLayout.setVisibility(8);
            this.dseDetailsBinding.uploadFormatA.setVisibility(0);
        } else {
            this.dseDetailsBinding.pendingLayout.setVisibility(0);
            this.dseDetailsBinding.bottomSubmitLayout.setVisibility(8);
            this.dseDetailsBinding.fillForm7.setVisibility(8);
            this.dseDetailsBinding.fillForm8.setVisibility(8);
            this.dseDetailsBinding.DoneLayout.setVisibility(0);
            this.dseDetailsBinding.uploadFormatA.setVisibility(8);
        }
        String str3 = "";
        if (name == null || name.equals("null") || name.equals("")) {
            this.dseDetailsBinding.applicantNameTv.setText("");
        } else {
            this.dseDetailsBinding.applicantNameTv.setText(name);
        }
        if (epicno == null || epicno.equals("null") || epicno.equals("")) {
            this.dseDetailsBinding.epicNoEt.setText("");
        } else {
            this.dseDetailsBinding.epicNoEt.setText(epicno);
        }
        if (age == null || age.equals("null") || age.equals("")) {
            this.dseDetailsBinding.ageEt.setText("");
        } else {
            this.dseDetailsBinding.ageEt.setText(age);
        }
        if (gender == null || gender.equals("null") || gender.equals("")) {
            this.dseDetailsBinding.genderTv1.setText("");
        } else if (gender.equals("M")) {
            this.dseDetailsBinding.genderTv1.setText("Male");
        } else if (gender.equals("F")) {
            this.dseDetailsBinding.genderTv1.setText("Female");
        } else if (gender.equals("T")) {
            this.dseDetailsBinding.genderTv1.setText(OTHER);
        }
        String str4 = "1";
        if (this.flagValue.equals("1")) {
            if (actionkey.equals("3")) {
                this.dseDetailsBinding.originalRb.setChecked(true);
            } else if (actionkey.equals("4")) {
                this.dseDetailsBinding.asdRb.setChecked(true);
            } else if (actionkey.equals("1")) {
                this.dseDetailsBinding.noinformationRb.setChecked(true);
            } else if (actionkey.equals("2")) {
                this.dseDetailsBinding.dupicateRb.setChecked(true);
            }
            int i = 0;
            while (i < this.dseDetailsBinding.matchingAc.getChildCount()) {
                this.dseDetailsBinding.matchingAc.getChildAt(i).setEnabled(false);
                i++;
                str4 = str4;
            }
            str = str4;
            for (int i2 = 0; i2 < this.dseDetailsBinding.notmatchingAc.getChildCount(); i2++) {
                this.dseDetailsBinding.notmatchingAc.getChildAt(i2).setEnabled(false);
            }
            this.dseDetailsBinding.submitTv.setVisibility(8);
            this.dseDetailsBinding.remarkTv.setText(remark);
            this.dseDetailsBinding.remarkTv.setEnabled(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 16);
            this.dseDetailsBinding.remarkTv.setLayoutParams(layoutParams);
        } else {
            str = "1";
        }
        if (rlnName == null || rlnName.equals("null") || rlnName.equals("")) {
            this.dseDetailsBinding.relativeTv1.setText("");
        } else {
            this.dseDetailsBinding.relativeTv1.setText(rlnName);
        }
        if (rlnType == null || rlnType.equals("null") || rlnType.equals("")) {
            this.dseDetailsBinding.relationtype.setText("");
        } else if (rlnType.equals("F") || rlnType.equals("FTHR")) {
            this.dseDetailsBinding.relationtype.setText("Father");
        } else if (rlnType.equals("M") || rlnType.equals("MTHR")) {
            this.dseDetailsBinding.relationtype.setText("Mother");
        } else if (rlnType.equals("H") || rlnType.equals("HSBN")) {
            this.dseDetailsBinding.relationtype.setText("Husband");
        } else if (rlnType.equals("W") || rlnType.equals("WIFE")) {
            this.dseDetailsBinding.relationtype.setText("Wife");
        } else if (rlnType.equals("L") || rlnType.equals("OTHR")) {
            this.dseDetailsBinding.relationtype.setText(OTHER);
        } else {
            this.dseDetailsBinding.relationtype.setText("");
        }
        HashMap map = new HashMap();
        map.put(EPIC_NUMBER, epicno);
        map.put("acNo", acno);
        map.put("partNumber", partno);
        map.put(STATE_CD, this.blostatecode);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getaddressDetails(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", this.blostatecode, APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass4());
        this.dseDetailsBinding.serialNo.setText(acno + " // " + partno);
        if (dateofinclusion != null && !dateofinclusion.equals("null") && !dateofinclusion.equals("")) {
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(dateofinclusion.substring(0, 10));
            } catch (ParseException unused) {
                Logger.d("expection", "exception");
                date = null;
            }
            str3 = new SimpleDateFormat("dd/MM/yyyy").format(date);
        }
        this.dseDetailsBinding.dateInclusionEt.setText(str3);
        if (photo != null) {
            this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile("objectstorage", photo, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment.5
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if (response.code() == 200) {
                        ((JsonObject) response.body()).get("file");
                        ClusterNumberDseFragment.this.encodedImage = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                        byte[] bArrDecode = Base64.decode(ClusterNumberDseFragment.this.encodedImage, 0);
                        ClusterNumberDseFragment.this.bitmap = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                        ClusterNumberDseFragment.this.dseDetailsBinding.personImage.setImageBitmap(ClusterNumberDseFragment.this.bitmap);
                        return;
                    }
                    try {
                        Logger.d("imageerror", new JSONObject(response.errorBody().string()).optString(ClusterNumberDseFragment.MESSAGE));
                    } catch (Exception e) {
                        Logger.e("", e.getMessage());
                    }
                }

                public void onFailure(Call<JsonObject> call, Throwable t) {
                    Logger.d(ClusterNumberDseFragment.COMING_IN_ON_FAILURE, t.getMessage());
                }
            });
        } else {
            this.dseDetailsBinding.personImage.setImageBitmap(dummyimg);
        }
        if (this.partNo.equals(partno) && this.asmblyNO.equals(acno)) {
            this.dseDetailsBinding.matchingAc.setVisibility(0);
            this.dseDetailsBinding.notmatchingAc.setVisibility(8);
            this.dseDetailsBinding.uploadFormatA.setVisibility(0);
            this.dseDetailsBinding.detailsLy.setBackgroundColor(Color.parseColor("#C9F2FF"));
            str2 = "0";
        } else {
            this.dseDetailsBinding.matchingAc.setVisibility(8);
            this.dseDetailsBinding.notmatchingAc.setVisibility(0);
            this.dseDetailsBinding.uploadFormatA.setVisibility(8);
            this.dseDetailsBinding.detailsLy.setBackgroundColor(Color.parseColor("#ffffff"));
            str2 = str;
        }
        this.dseDetailsBinding.chooseFile1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$3(view);
            }
        });
        this.dseDetailsBinding.chooseFileDeletion1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$4(view);
            }
        });
        this.dseDetailsBinding.matchingAc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i3) {
                this.f$0.lambda$bottomSheet$5(radioGroup, i3);
            }
        });
        this.dseDetailsBinding.notmatchingAc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i3) {
                this.f$0.lambda$bottomSheet$6(radioGroup, i3);
            }
        });
        this.dseDetailsBinding.crossDialog.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$7(view);
            }
        });
        this.dseDetailsBinding.imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$8(view);
            }
        });
        this.dseDetailsBinding.submitTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$11(str2, acno, partno, dseID, clusterId, epicno, remark, view);
            }
        });
        this.dialog.show();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<EronetResponse> {
        AnonymousClass4() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.body() != null) {
                ClusterNumberDseFragment.this.addressDetails = ((EronetResponse) response.body()).getPayload();
                String string = "";
                if (!ClusterNumberDseFragment.this.addressDetails.isEmpty()) {
                    JsonObject asJsonObject = ClusterNumberDseFragment.this.gson.toJsonTree((LinkedTreeMap) ClusterNumberDseFragment.this.addressDetails.get(0)).getAsJsonObject();
                    ClusterNumberDseFragment clusterNumberDseFragment = ClusterNumberDseFragment.this;
                    if (!String.valueOf(asJsonObject.get(ClusterNumberDseFragment.HOUSE_NUMBER)).equals("") && !String.valueOf(asJsonObject.get(ClusterNumberDseFragment.HOUSE_NUMBER)).equals("null")) {
                        StringBuilder sbAppend = new StringBuilder().append(String.valueOf(asJsonObject.get(ClusterNumberDseFragment.HOUSE_NUMBER)).replace(RegexMatcher.JSON_STRING_REGEX, "")).append(", ").append((String.valueOf(asJsonObject.get(ClusterNumberDseFragment.LOCALITY_STREET)).equals("") || String.valueOf(asJsonObject.get(ClusterNumberDseFragment.LOCALITY_STREET)).equals("null")) ? "" : String.valueOf(asJsonObject.get(ClusterNumberDseFragment.LOCALITY_STREET)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ").append((String.valueOf(asJsonObject.get(ClusterNumberDseFragment.TOWN_VILLAGE_NEW)).equals("") || String.valueOf(asJsonObject.get(ClusterNumberDseFragment.TOWN_VILLAGE_NEW)).equals("null")) ? "" : String.valueOf(asJsonObject.get(ClusterNumberDseFragment.TOWN_VILLAGE_NEW)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ").append((String.valueOf(asJsonObject.get(ClusterNumberDseFragment.DISTRICT_NAME_ENGLISH)).equals("") || String.valueOf(asJsonObject.get(ClusterNumberDseFragment.DISTRICT_NAME_ENGLISH)).equals("null")) ? "" : String.valueOf(asJsonObject.get(ClusterNumberDseFragment.DISTRICT_NAME_ENGLISH)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ");
                        if (!String.valueOf(asJsonObject.get(ClusterNumberDseFragment.STATE_NAME_ENGLISH)).equals("") && !String.valueOf(asJsonObject.get(ClusterNumberDseFragment.STATE_NAME_ENGLISH)).equals("null")) {
                            StringBuilder sbAppend2 = new StringBuilder().append(String.valueOf(asJsonObject.get(ClusterNumberDseFragment.STATE_NAME_ENGLISH)).trim().replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!String.valueOf(asJsonObject.get(ClusterNumberDseFragment.PIN_CODE_NEW)).equals("") && !String.valueOf(asJsonObject.get(ClusterNumberDseFragment.PIN_CODE_NEW)).equals("null")) {
                                string = ", " + String.valueOf(asJsonObject.get(ClusterNumberDseFragment.PIN_CODE_NEW)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                            }
                            string = sbAppend2.append(string).toString();
                        }
                        string = sbAppend.append(string).toString();
                    }
                    clusterNumberDseFragment.address = string;
                    ClusterNumberDseFragment.this.dseDetailsBinding.addressTv1.setText(ClusterNumberDseFragment.this.address);
                    ClusterNumberDseFragment.this.alertDialog.dismiss();
                    return;
                }
                ClusterNumberDseFragment.this.dseDetailsBinding.addressTv1.setText("");
                return;
            }
            if (response.code() == 401) {
                ClusterNumberDseFragment.this.commomUtility.getRefreshToken(ClusterNumberDseFragment.this.getContext(), ClusterNumberDseFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$4$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(ClusterNumberDseFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(ClusterNumberDseFragment.HOUSE_NUMBER_FRAG, e.getMessage());
            }
            ClusterNumberDseFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            ClusterNumberDseFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ClusterNumberDseFragment.this.commomUtility.showMessageOK(ClusterNumberDseFragment.this.requireContext(), ClusterNumberDseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$4$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ClusterNumberDseFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setToken("Bearer " + str);
            ClusterNumberDseFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setLocaleBool(false);
            ClusterNumberDseFragment.this.startActivity(new Intent((Context) ClusterNumberDseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d(ClusterNumberDseFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$3(View view) {
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose Image from Gallery", "Choose PDF from Gallery", "Cancel"};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$bottomSheet$2(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$2(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals("Take Photo")) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(102);
        } else if (charSequenceArr[i].equals("Choose Image from Gallery")) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(102);
        } else if (charSequenceArr[i].equals("Choose PDF from Gallery")) {
            openfile1();
        } else if (charSequenceArr[i].equals("Cancel")) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$4(View view) {
        this.passref = " ";
        this.dseDetailsBinding.chooseFileName1.setText("");
        this.dseDetailsBinding.chooseFileName1.setVisibility(8);
        this.dseDetailsBinding.preview1.setVisibility(8);
        this.dseDetailsBinding.preview1.setImageDrawable(null);
        this.dseDetailsBinding.chooseFileDeletion1.setVisibility(8);
        this.dseDetailsBinding.chooseFileNameSize1.setVisibility(8);
        this.dseDetailsBinding.chooseFile1.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$5(RadioGroup radioGroup, int i) {
        if (i != 2131362420) {
            if (i != 2131364947) {
                return;
            }
            this.bloOutput = "3";
            this.dseDetailsBinding.pendingRemark.setVisibility(0);
            this.dseDetailsBinding.fillForm7.setVisibility(8);
            this.dseDetailsBinding.fillForm8.setVisibility(8);
            this.dseDetailsBinding.bottomSubmitLayout.setVisibility(0);
            this.dseDetailsBinding.deletionReason.setVisibility(8);
            return;
        }
        this.bloOutput = "4";
        this.deletionReasonList.clear();
        this.dseDetailsBinding.pendingRemark.setVisibility(0);
        this.dseDetailsBinding.fillForm7.setVisibility(8);
        this.dseDetailsBinding.fillForm8.setVisibility(8);
        this.dseDetailsBinding.bottomSubmitLayout.setVisibility(0);
        this.dseDetailsBinding.deletionReason.setVisibility(8);
        this.deletionReasonList.add("Select Reason");
        this.deletionReasonList.add("Death");
        this.deletionReasonList.add("Absent/Permanently shifted");
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.deletionReasonList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.dseDetailsBinding.deletionspinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.dseDetailsBinding.deletionspinner.setSelection(0);
        this.selectedReason = this.dseDetailsBinding.deletionspinner.getSelectedItem().toString();
        this.dseDetailsBinding.deletionspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment.6
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ClusterNumberDseFragment.this.selectedReason = String.valueOf(parent.getItemAtPosition(position));
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
                Logger.d(ClusterNumberDseFragment.CONTENT, "onNothingSelected");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$6(RadioGroup radioGroup, int i) {
        if (i == 2131363506) {
            this.bloOutput = "2";
        } else {
            if (i != 2131364852) {
                return;
            }
            this.bloOutput = "1";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$7(View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$8(View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$11(String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, View view) {
        this.remarks = this.dseDetailsBinding.remarkTv.getText().toString();
        this.formatBRemark = this.dseDetailsBinding.remarkUploadTv.getText().toString();
        this.action = this.bloOutput;
        if (str.equals("0")) {
            if (this.dseDetailsBinding.remarkUploadTv.getText().toString().equals("")) {
                showdialog("Alert", "Please Enter Response of Format A Remark");
                return;
            }
            if (!this.dseDetailsBinding.originalRb.isChecked() && !this.dseDetailsBinding.asdRb.isChecked()) {
                showdialog("Alert", "Please select an Action");
                return;
            }
            if (this.dseDetailsBinding.remarkTv.getText().toString().equals("")) {
                showdialog("Alert", "Please Enter Remark");
                return;
            }
            if (this.action.equals("4")) {
                pseSubmit(str2, str3, str4, this.stateCode, this.remarks, str5, this.action, "0", this.formatBRemark, str6, str7);
                return;
            }
            if (this.action.equals("5")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                builder.setMessage("Do You want to Fill Form 8 ?");
                builder.setCancelable(true);
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda15
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$bottomSheet$9(str2, str3, str4, str5, str6, str7, dialogInterface, i);
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda16
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$bottomSheet$10(str2, str3, str4, str5, str6, str7, dialogInterface, i);
                    }
                });
                builder.show();
                return;
            }
            pseSubmit(str2, str3, str4, this.stateCode, this.remarks, str5, this.action, "4", this.formatBRemark, str6, str7);
            return;
        }
        if (!this.dseDetailsBinding.noinformationRb.isChecked() && !this.dseDetailsBinding.dupicateRb.isChecked()) {
            showdialog("Alert", "Please select an Action");
        } else if (this.dseDetailsBinding.remarkTv.getText().toString().equals("")) {
            showdialog("Alert", "Please enter Remark");
        } else {
            pseSubmit(str2, str3, str4, this.stateCode, this.remarks, str5, this.action, "4", this.formatBRemark, str6, str7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$9(String str, String str2, String str3, String str4, String str5, String str6, DialogInterface dialogInterface, int i) {
        pseSubmit(str, str2, str3, this.stateCode, this.remarks, str4, this.action, "2", this.formatBRemark, str5, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$10(String str, String str2, String str3, String str4, String str5, String str6, DialogInterface dialogInterface, int i) {
        pseSubmit(str, str2, str3, this.stateCode, this.remarks, str4, this.action, "3", this.formatBRemark, str5, str6);
    }

    public void pseSubmit(String acno, String partno, String dseId, String stateCode, String remark, String clusterId, String action, String submitFlag, String bloRemark, String epicno, String epicId) {
        Logger.d("in dse submission ..............................", "");
        this.alertDialog.show();
        ArrayList arrayList = new ArrayList();
        arrayList.add(epicno);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Integer.valueOf(Integer.parseInt(epicId)));
        if (this.asmblyNO.equals(acno)) {
            HashMap map = new HashMap();
            map.put(STATE_CD, stateCode);
            map.put("acNo", this.asmblyNO);
            map.put(DSE_CLUSTER_ID, clusterId);
            map.put("epicNumbers", arrayList);
            map.put("epicIds", arrayList2);
            String str = this.passref;
            if (str == null || str.equals("null") || this.passref.equals("") || this.passref.equals(" ")) {
                map.put("dseStatus", 16);
                map.put("actionTaken", "BLO Verified without Format A Response");
            } else {
                map.put("dseStatus", 13);
                map.put("formatAResponseDoc", this.passref);
                map.put("actionTaken", "Format A Response Upload");
            }
            JSONObject jSONObject = new JSONObject(map);
            Logger.d("formatAmap", String.valueOf(jSONObject));
            System.out.println("formatAmap" + jSONObject);
            this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).dseSaveResponse(this.token, "blo", APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass7(acno, partno, dseId, stateCode, clusterId, action, submitFlag));
            return;
        }
        submit(acno, partno, dseId, stateCode, this.remarks, clusterId, action, submitFlag, this.formatBRemark);
        this.alertDialog.dismiss();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonObject> {
        final /* synthetic */ String val$acno;
        final /* synthetic */ String val$action;
        final /* synthetic */ String val$clusterId;
        final /* synthetic */ String val$dseId;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$stateCode;
        final /* synthetic */ String val$submitFlag;

        AnonymousClass7(final String val$acno, final String val$partno, final String val$dseId, final String val$stateCode, final String val$clusterId, final String val$action, final String val$submitFlag) {
            this.val$acno = val$acno;
            this.val$partno = val$partno;
            this.val$dseId = val$dseId;
            this.val$stateCode = val$stateCode;
            this.val$clusterId = val$clusterId;
            this.val$action = val$action;
            this.val$submitFlag = val$submitFlag;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.body() != null) {
                Logger.d("response", String.valueOf(((JsonObject) response.body()).getAsJsonObject()));
                ClusterNumberDseFragment clusterNumberDseFragment = ClusterNumberDseFragment.this;
                clusterNumberDseFragment.submit(this.val$acno, this.val$partno, this.val$dseId, this.val$stateCode, clusterNumberDseFragment.remarks, this.val$clusterId, this.val$action, this.val$submitFlag, ClusterNumberDseFragment.this.formatBRemark);
                ClusterNumberDseFragment.this.alertDialog.dismiss();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Logger.d("mesage---", String.valueOf(jSONObject.get(ClusterNumberDseFragment.MESSAGE)));
                ClusterNumberDseFragment.this.showdialog(ClusterNumberDseFragment.MESSAGE, String.valueOf(jSONObject.get(ClusterNumberDseFragment.MESSAGE)));
                ClusterNumberDseFragment.this.alertDialog.dismiss();
            } catch (IOException | JSONException e) {
                Logger.d("pse_submit", e.getMessage());
                if (response.code() == 401) {
                    ClusterNumberDseFragment.this.alertDialog.dismiss();
                    ClusterNumberDseFragment.this.commomUtility.showMessageWithTitleOK(ClusterNumberDseFragment.this.requireContext(), "Alert", ClusterNumberDseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$7$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i);
                        }
                    });
                }
                ClusterNumberDseFragment.this.showdialog(ClusterNumberDseFragment.MESSAGE, "Null");
                ClusterNumberDseFragment.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterNumberDseFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterNumberDseFragment.this.getContext()).setLocaleBool(false);
            ClusterNumberDseFragment.this.startActivity(new Intent((Context) ClusterNumberDseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(ClusterNumberDseFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public void submit(String acno, String partno, String dseId, String stateCode, String remark, String clusterId, String action, String submitFlag, String bloRemark) {
        HashMap map = new HashMap();
        this.alertDialog.show();
        map.put(CLUSTER_ID, Integer.valueOf(Integer.parseInt(clusterId)));
        map.put(DSE_ID, Integer.valueOf(Integer.parseInt(dseId)));
        map.put(ACTION1, Integer.valueOf(Integer.parseInt(action)));
        map.put(REMARK, remark);
        map.put(STATE_CD, stateCode);
        map.put("acNo", Integer.valueOf(Integer.parseInt(acno)));
        map.put(PART_NO, Integer.valueOf(Integer.parseInt(partno)));
        map.put("bloAcNo", Integer.valueOf(Integer.parseInt(this.asmblyNO)));
        map.put("bloPartNo", Integer.valueOf(Integer.parseInt(this.partNo)));
        map.put("formatB", this.passref.equals(" ") ? null : this.passref);
        String str = this.passref;
        if (str == null || str.equals("null") || this.passref.equals("") || this.passref.equals(" ")) {
            map.put("dseStatus", 16);
        } else {
            map.put("dseStatus", 13);
        }
        if (bloRemark == null || bloRemark.equals("")) {
            bloRemark = null;
        }
        map.put("bloRemarks", bloRemark);
        Logger.d("HELLO NO ", String.valueOf(new JSONObject(map)));
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).dseclusterSubmit(this.token, "blo", this.blostatecode, map).enqueue(new AnonymousClass8(submitFlag));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<JsonObject> {
        final /* synthetic */ String val$submitFlag;

        AnonymousClass8(final String val$submitFlag) {
            this.val$submitFlag = val$submitFlag;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.body() != null) {
                ClusterNumberDseFragment.this.alertDialog.dismiss();
                ClusterNumberDseFragment.this.dialog.dismiss();
                ClusterNumberDseFragment.this.passref = "";
                if (this.val$submitFlag.equals("0") || this.val$submitFlag.equals("1") || this.val$submitFlag.equals("2") || this.val$submitFlag.equals("3") || this.val$submitFlag.equals("4")) {
                    ClusterNumberDseFragment.this.showdialog("Alert", "Dse remark successfully submitted.");
                }
                if (ClusterNumberDseFragment.this.flagValue.equals("0")) {
                    ClusterNumberDseFragment.this.pseclusterDetails();
                    return;
                } else {
                    ClusterNumberDseFragment.this.dseDoneclusterDetails();
                    return;
                }
            }
            if (response.code() == 401) {
                ClusterNumberDseFragment.this.commomUtility.getRefreshToken(ClusterNumberDseFragment.this.getContext(), ClusterNumberDseFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$8$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(ClusterNumberDseFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d("pse_submit", e.getMessage());
            }
            ClusterNumberDseFragment.this.alertDialog.dismiss();
            ClusterNumberDseFragment.this.dialog.dismiss();
            ClusterNumberDseFragment.this.showdialogFinal("Message", "Null");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            ClusterNumberDseFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ClusterNumberDseFragment.this.commomUtility.showMessageOK(ClusterNumberDseFragment.this.requireContext(), ClusterNumberDseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$8$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ClusterNumberDseFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setToken("Bearer " + str);
            ClusterNumberDseFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setLocaleBool(false);
            ClusterNumberDseFragment.this.startActivity(new Intent((Context) ClusterNumberDseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(ClusterNumberDseFragment.COMING_IN_ON_FAILURE, t.getMessage());
            ClusterNumberDseFragment.this.alertDialog.dismiss();
            ClusterNumberDseFragment.this.dialog.dismiss();
        }
    }

    public void openfile1() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/pdf"});
        this.activityResultLauncher1.launch(Intent.createChooser(intent, "Choose File"));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$9, reason: invalid class name */
    class AnonymousClass9 implements ActivityResultCallback<ActivityResult> {
        AnonymousClass9() {
        }

        /* JADX WARN: Code duplicated, block: B:33:0x0095 A[Catch: Exception -> 0x022b, TryCatch #3 {Exception -> 0x022b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0218, B:45:0x0220, B:46:0x022a), top: B:55:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:35:0x00ac A[Catch: Exception -> 0x022b, TRY_LEAVE, TryCatch #3 {Exception -> 0x022b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0218, B:45:0x0220, B:46:0x022a), top: B:55:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:38:0x00bf A[Catch: Exception -> 0x022b, TRY_ENTER, TryCatch #3 {Exception -> 0x022b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0218, B:45:0x0220, B:46:0x022a), top: B:55:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:39:0x012e A[Catch: Exception -> 0x022b, TryCatch #3 {Exception -> 0x022b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0218, B:45:0x0220, B:46:0x022a), top: B:55:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:41:0x0146 A[Catch: Exception -> 0x022b, TryCatch #3 {Exception -> 0x022b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0218, B:45:0x0220, B:46:0x022a), top: B:55:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:42:0x0176 A[Catch: Exception -> 0x022b, TryCatch #3 {Exception -> 0x022b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0218, B:45:0x0220, B:46:0x022a), top: B:55:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:44:0x0218 A[Catch: Exception -> 0x022b, TryCatch #3 {Exception -> 0x022b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0218, B:45:0x0220, B:46:0x022a), top: B:55:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0220 A[Catch: Exception -> 0x022b, TryCatch #3 {Exception -> 0x022b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0218, B:45:0x0220, B:46:0x022a), top: B:55:0x006d }] */
        public void onActivityResult(ActivityResult result) throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            IOException e;
            Cursor cursorQuery;
            String string;
            double dRound;
            Throwable th;
            if (result.getResultCode() != -1) {
                return;
            }
            ClusterNumberDseFragment.this.imageUri = result.getData().getData();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                InputStream inputStreamOpenInputStream = ClusterNumberDseFragment.this.getContext().getContentResolver().openInputStream(ClusterNumberDseFragment.this.imageUri);
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int i = inputStreamOpenInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                } else {
                                    byteArrayOutputStream.write(bArr, 0, i);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (inputStreamOpenInputStream != null) {
                                    try {
                                        inputStreamOpenInputStream.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                }
                                throw th;
                            }
                        }
                        if (inputStreamOpenInputStream != null) {
                            inputStreamOpenInputStream.close();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        Logger.e("", e.getMessage());
                        ClusterNumberDseFragment.this.byteArray = byteArrayOutputStream.toByteArray();
                        cursorQuery = ClusterNumberDseFragment.this.getContext().getContentResolver().query(ClusterNumberDseFragment.this.getSaveImagePath(Base64.encodeToString(ClusterNumberDseFragment.this.byteArray, 0), ".pdf"), null, null, null, null);
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.close();
                            throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                        }
                        cursorQuery.moveToFirst();
                        string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                        if (string.toLowerCase().contains(".pdf")) {
                            if (ClusterNumberDseFragment.this.filesize < 1024) {
                                double dRound2 = Math.round(ClusterNumberDseFragment.this.filesize * 100.0d) / 100.0d;
                                ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileName1.setVisibility(0);
                                ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileNameSize1.setVisibility(0);
                                ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileDeletion1.setVisibility(0);
                                ClusterNumberDseFragment.this.dseDetailsBinding.preview1.setVisibility(0);
                                ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileName1.setText(string);
                                ClusterNumberDseFragment.this.dseDetailsBinding.chooseFile1.setTextColor(Color.parseColor(ClusterNumberDseFragment.BLACK_COLOR));
                                ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileNameSize1.setText(dRound2 + "KB");
                                ClusterNumberDseFragment.this.dseDetailsBinding.preview1.setImageResource(R.drawable.blo_pfd_thumbnail);
                            } else {
                                dRound = Math.round(((double) (ClusterNumberDseFragment.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                                if (dRound > 3.0d) {
                                    ClusterNumberDseFragment.this.dseDetailsBinding.preview1.setVisibility(8);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileDeletion1.setVisibility(8);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileNameSize1.setVisibility(8);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileName1.setVisibility(8);
                                    ClusterNumberDseFragment.this.showdialog("Alert", "PDF size exceeded 3MB limit.");
                                } else {
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileName1.setVisibility(0);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileNameSize1.setVisibility(0);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileDeletion1.setVisibility(0);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.preview1.setVisibility(0);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileName1.setText(string);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFile1.setTextColor(Color.parseColor(ClusterNumberDseFragment.BLACK_COLOR));
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileNameSize1.setText(dRound + "MB");
                                    ClusterNumberDseFragment.this.dseDetailsBinding.preview1.setImageResource(R.drawable.blo_pfd_thumbnail);
                                }
                            }
                            ClusterNumberDseFragment.this.commonUtilClass.uploadToServer2(ClusterNumberDseFragment.this.getContext(), ClusterNumberDseFragment.this.stateCode, ClusterNumberDseFragment.this.asmblyNO, ClusterNumberDseFragment.this.partNo, ClusterNumberDseFragment.this.filepathimg, ClusterNumberDseFragment.this.saveImageFileName, ClusterNumberDseFragment.this.token, "FormatAImage", ClusterNumberDseFragment.this.atkband, ClusterNumberDseFragment.this.rtkband, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$9$$ExternalSyntheticLambda2
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i2, String str) {
                                    this.f$0.lambda$onActivityResult$3(i2, str);
                                }
                            });
                            return;
                        }
                        ClusterNumberDseFragment.this.showdialog("", "Please Select the correct format of file");
                    }
                    ClusterNumberDseFragment.this.byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        cursorQuery = ClusterNumberDseFragment.this.getContext().getContentResolver().query(ClusterNumberDseFragment.this.getSaveImagePath(Base64.encodeToString(ClusterNumberDseFragment.this.byteArray, 0), ".pdf"), null, null, null, null);
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.close();
                            throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
                        }
                        cursorQuery.moveToFirst();
                        string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                        if (string.toLowerCase().contains(".pdf")) {
                            if (ClusterNumberDseFragment.this.filesize < 1024) {
                                double dRound3 = Math.round(ClusterNumberDseFragment.this.filesize * 100.0d) / 100.0d;
                                ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileName1.setVisibility(0);
                                ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileNameSize1.setVisibility(0);
                                ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileDeletion1.setVisibility(0);
                                ClusterNumberDseFragment.this.dseDetailsBinding.preview1.setVisibility(0);
                                ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileName1.setText(string);
                                ClusterNumberDseFragment.this.dseDetailsBinding.chooseFile1.setTextColor(Color.parseColor(ClusterNumberDseFragment.BLACK_COLOR));
                                ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileNameSize1.setText(dRound3 + "KB");
                                ClusterNumberDseFragment.this.dseDetailsBinding.preview1.setImageResource(R.drawable.blo_pfd_thumbnail);
                            } else {
                                dRound = Math.round(((double) (ClusterNumberDseFragment.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                                if (dRound > 3.0d) {
                                    ClusterNumberDseFragment.this.dseDetailsBinding.preview1.setVisibility(8);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileDeletion1.setVisibility(8);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileNameSize1.setVisibility(8);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileName1.setVisibility(8);
                                    ClusterNumberDseFragment.this.showdialog("Alert", "PDF size exceeded 3MB limit.");
                                } else {
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileName1.setVisibility(0);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileNameSize1.setVisibility(0);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileDeletion1.setVisibility(0);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.preview1.setVisibility(0);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileName1.setText(string);
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFile1.setTextColor(Color.parseColor(ClusterNumberDseFragment.BLACK_COLOR));
                                    ClusterNumberDseFragment.this.dseDetailsBinding.chooseFileNameSize1.setText(dRound + "MB");
                                    ClusterNumberDseFragment.this.dseDetailsBinding.preview1.setImageResource(R.drawable.blo_pfd_thumbnail);
                                }
                            }
                            ClusterNumberDseFragment.this.commonUtilClass.uploadToServer2(ClusterNumberDseFragment.this.getContext(), ClusterNumberDseFragment.this.stateCode, ClusterNumberDseFragment.this.asmblyNO, ClusterNumberDseFragment.this.partNo, ClusterNumberDseFragment.this.filepathimg, ClusterNumberDseFragment.this.saveImageFileName, ClusterNumberDseFragment.this.token, "FormatAImage", ClusterNumberDseFragment.this.atkband, ClusterNumberDseFragment.this.rtkband, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$9$$ExternalSyntheticLambda2
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i2, String str) {
                                    this.f$0.lambda$onActivityResult$3(i2, str);
                                }
                            });
                            return;
                        }
                        ClusterNumberDseFragment.this.showdialog("", "Please Select the correct format of file");
                    } catch (Exception e3) {
                        Logger.d(ClusterNumberDseFragment.CONTENT, e3.getMessage());
                    }
                } catch (Throwable th4) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th4;
                }
            } catch (IOException e4) {
                byteArrayOutputStream = byteArrayOutputStream2;
                e = e4;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$3(int i, String str) {
            if (i == 401) {
                ClusterNumberDseFragment.this.commonUtilClass.getRefreshToken(ClusterNumberDseFragment.this.getContext(), ClusterNumberDseFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$9$$ExternalSyntheticLambda3
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$onActivityResult$2(i2, str2, str3);
                    }
                });
            } else {
                ClusterNumberDseFragment.this.passref = str;
                Logger.d("passref------", ClusterNumberDseFragment.this.passref);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$2(int i, String str, String str2) {
            ClusterNumberDseFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ClusterNumberDseFragment.this.commonUtilClass.showMessageOK(ClusterNumberDseFragment.this.requireContext(), ClusterNumberDseFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$9$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onActivityResult$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ClusterNumberDseFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setToken("Bearer " + str);
            ClusterNumberDseFragment.this.commonUtilClass.uploadToServer2(ClusterNumberDseFragment.this.getContext(), ClusterNumberDseFragment.this.stateCode, ClusterNumberDseFragment.this.asmblyNO, ClusterNumberDseFragment.this.partNo, ClusterNumberDseFragment.this.filepathimg, ClusterNumberDseFragment.this.saveImageFileName, ClusterNumberDseFragment.this.token, "FormatAImage", ClusterNumberDseFragment.this.atkband, ClusterNumberDseFragment.this.rtkband, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$9$$ExternalSyntheticLambda1
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i2, String str3) {
                    this.f$0.lambda$onActivityResult$1(i2, str3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterNumberDseFragment.this.requireContext()).setLocaleBool(false);
            ClusterNumberDseFragment.this.startActivity(new Intent((Context) ClusterNumberDseFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$1(int i, String str) {
            ClusterNumberDseFragment.this.passref = str;
            Logger.d("passref------", ClusterNumberDseFragment.this.passref);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            this.alertDialog.dismiss();
        }
        if (requestCode != 102 || resultCode != -1) {
            return;
        }
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
                this.dseDetailsBinding.chooseFileDeletion1.setVisibility(0);
                this.dseDetailsBinding.chooseFileName1.setVisibility(0);
                this.dseDetailsBinding.chooseFileNameSize1.setVisibility(0);
                this.dseDetailsBinding.preview1.setVisibility(0);
                this.dseDetailsBinding.chooseFile1.setTextColor(Color.parseColor(BLACK_COLOR));
                this.dseDetailsBinding.chooseFileName1.setText(string);
                this.dseDetailsBinding.chooseFileNameSize1.setText(this.filesize + "KB");
                ImageView imageView = this.dseDetailsBinding.preview1;
                byte[] bArr = this.byteArray;
                imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            } else {
                double dRound = Math.round(((double) ((float) (this.filesize / 1024.0d))) * 100.0d) / 100.0d;
                if (dRound > 2.0d) {
                    this.dseDetailsBinding.preview1.setVisibility(8);
                    this.dseDetailsBinding.chooseFileDeletion1.setVisibility(8);
                    this.dseDetailsBinding.chooseFileNameSize1.setVisibility(8);
                    this.dseDetailsBinding.chooseFileName1.setVisibility(8);
                    showdialog("Alert", "Image size exceeded 2MB limit.");
                } else {
                    this.dseDetailsBinding.chooseFileDeletion1.setVisibility(0);
                    this.dseDetailsBinding.chooseFileName1.setVisibility(0);
                    this.dseDetailsBinding.chooseFileNameSize1.setVisibility(0);
                    this.dseDetailsBinding.preview1.setVisibility(0);
                    this.dseDetailsBinding.chooseFile1.setTextColor(Color.parseColor(BLACK_COLOR));
                    this.dseDetailsBinding.chooseFileName1.setText(string);
                    this.dseDetailsBinding.chooseFileNameSize1.setText(dRound + "MB");
                    ImageView imageView2 = this.dseDetailsBinding.preview1;
                    byte[] bArr2 = this.byteArray;
                    imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                }
            }
            this.commonUtilClass.uploadToServer2(getContext(), this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, "FormatAImage", this.atkband, this.rtkband, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda9
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i, String str) {
                    this.f$0.lambda$onActivityResult$15(i, str);
                }
            });
            this.alertDialog.dismiss();
        } catch (Exception e2) {
            Logger.d(CONTENT, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$15(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(getContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda6
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onActivityResult$14(i2, str2, str3);
                }
            });
        } else {
            this.passref = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$14(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(requireContext(), SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda13
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onActivityResult$12(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.uploadToServer2(getContext(), this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, "FormatAImage", this.atkband, this.rtkband, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda14
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$onActivityResult$13(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$12(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$13(int i, String str) {
        this.passref = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialogFinal(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog2(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog2$18(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog2$18(DialogInterface dialogInterface, int i) {
        openFragment(new DseFragment(), "dseFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog4(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog4$19(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog4$19(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(getContext(), (Class<?>) DseActivity.class));
    }

    private void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    public void addressDetails(String epicNo, String acNo, String partNo) {
        Logger.d(CONTENT, "in address details fetch..............................");
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put(EPIC_NUMBER, epicNo);
        map.put("acNo", acNo);
        map.put("partNumber", partNo);
        map.put(STATE_CD, this.blostatecode);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getaddressDetails(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", this.blostatecode, APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new Callback<EronetResponse>() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment.10
            public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
                if (response.code() == 200) {
                    ClusterNumberDseFragment.this.addressDetails = ((EronetResponse) response.body()).getPayload();
                    if (!ClusterNumberDseFragment.this.addressDetails.isEmpty()) {
                        JsonObject asJsonObject = ClusterNumberDseFragment.this.gson.toJsonTree((LinkedTreeMap) ClusterNumberDseFragment.this.addressDetails.get(0)).getAsJsonObject();
                        ClusterNumberDseFragment.this.address = asJsonObject.get(ClusterNumberDseFragment.HOUSE_NUMBER) + ", " + asJsonObject.get(ClusterNumberDseFragment.LOCALITY_STREET) + ", " + asJsonObject.get(ClusterNumberDseFragment.TOWN_VILLAGE_NEW) + ", " + asJsonObject.get(ClusterNumberDseFragment.DISTRICT_NAME_ENGLISH) + ", " + asJsonObject.get(ClusterNumberDseFragment.STATE_NAME_ENGLISH) + ", " + asJsonObject.get(ClusterNumberDseFragment.PIN_CODE_NEW);
                        ClusterNumberDseFragment.this.alertDialog.dismiss();
                        return;
                    }
                    ClusterNumberDseFragment.this.address = null;
                    return;
                }
                ClusterNumberDseFragment.this.address = "";
                try {
                    Logger.d(ClusterNumberDseFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
                } catch (IOException | JSONException e) {
                    Logger.d(ClusterNumberDseFragment.HOUSE_NUMBER_FRAG, e.getMessage());
                }
                ClusterNumberDseFragment.this.alertDialog.dismiss();
            }

            public void onFailure(Call<EronetResponse> call, Throwable t) {
                Logger.d(ClusterNumberDseFragment.COMING_IN_ON_FAILURE, t.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog3(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.dse.ClusterNumberDseFragment$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog3$20(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog3$20(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putString(CLUSTER_ID, this.clusterId);
        bundle.putString("applicantName", this.applicantName);
        bundle.putString("relationName", this.relationName);
        bundle.putString(RELATION_TYPE, this.relationType);
        bundle.putString(GENDER1, this.gender);
        bundle.putString("age", this.age);
        bundle.putString("Flag", this.flagValue);
        ClusterNumberDseFragment clusterNumberDseFragment = new ClusterNumberDseFragment();
        clusterNumberDseFragment.setArguments(bundle);
        openFragment(clusterNumberDseFragment, "cluster_details");
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    private boolean isBiharState() {
        return this.stateCode.equalsIgnoreCase("S04");
    }
}
