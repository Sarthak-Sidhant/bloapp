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
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
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
import com.google.gson.JsonArray;
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
import in.gov.eci.bloapp.databinding.BloClusterNumberRvItemBinding;
import in.gov.eci.bloapp.databinding.BloFragmentClusterNumberBinding;
import in.gov.eci.bloapp.databinding.BloPseDetailsBinding;
import in.gov.eci.bloapp.model.app_model.clusterDetailsModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.PseActivity;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
public class ClusterNumberFragment extends BaseFragment {
    private static final String ALERT = "Alert";
    private static final String APPLICATION_JSON = "application/json";
    private static final String ASSIGNED_BLO_ID = "assignedBloId";
    private static final String BLACK_COLOR = "#99000000";
    private static final String BLO_FIELD_REMARKS = "bloFieldRemarks";
    private static final String BLO_OUTPUT = "bloOutput";
    private static final String BLO_VERIFY_STATUS = "bloVerifyStatus";
    private static final String CANCEL = "Cancel";
    private static final String CAN_T_OBTAIN_FILE_NAME_CURSOR_IS_EMPTY = "Can't obtain file name, cursor is empty";
    private static final String CHOOSE_IMAGE_FROM_GALLERY = "Choose Image from Gallery";
    private static final String CLUSTER_ID = "clusterId";
    private static final String COMING_IN_ON_FAILURE = "coming in onFailure ";
    private static final String CONTENT = "CONTENT";
    private static final String DISTRICT_NAME_ENGLISH = "districtNameEnglish";
    private static final String EPIC_NO = "epicNo";
    private static final String EPIC_NUMBER = "epicNumber";
    private static final String ERROR_RESPONSE = "errorResponse";
    private static final String HOUSE_NUMBER = "houseNumber";
    private static final String HOUSE_NUMBER_FRAG = "house_number_frag";
    private static final String ISFORM_7_GEN = "isform7Gen";
    private static final String ISFORM_8_GEN = "isform8Gen";
    private static final String LOCALITY_STREET = "localityStreet";
    private static final String MESSAGE = "message";
    private static final String MESSAGE12 = "Message";
    private static final String PART_NO = "partNo";
    private static final String PIN_CODE = "pinCode";
    private static final String PIN_CODE_NEW = "poPin";
    private static final String PSE_FRAGMENT = "pseFragment";
    private static final String PSE_ID = "pseId";
    private static final String PSE_SUBMIT = "pse_submit";
    private static final String SESSION_TOKEN_EXPIRED_PLEASE_LOGIN = "Session token expired please Login";
    private static final String STATE_CD = "stateCd";
    private static final String STATE_NAME_ENGLISH = "stateNameEnglish";
    private static final String TAKE_PHOTO = "Take Photo";
    private static final String TOWN_VILLAGE = "townVillage";
    private static final String TOWN_VILLAGE_NEW = "townName";
    ActivityResultLauncher<Intent> activityResultLauncher1;
    private GenericRecyclerView adapter;
    private String address;
    private JSONArray addressDetails;
    private AlertDialog alertDialog;
    private String asmblyNO;
    private final ArrayList<ArrayList<String>> assignedBloId;
    private String atkband;
    BloFragmentClusterNumberBinding binding;
    private Bitmap bitmap;
    private final ArrayList<ArrayList<String>> bloFieldRrk;
    private String bloOutput;
    private final ArrayList<ArrayList<String>> bloOutput1;
    private String bloassemcode;
    private String blopartnumber;
    private String blostatecode;
    private final ArrayList<ArrayList<String>> bloverify;
    Retrofit.Builder builder;
    Bundle bundle;
    Bundle bundle1;
    private byte[] byteArray;
    private String clusterId;
    CommomUtility commonUtilClass;
    ArrayList<String> deletionReasonList;
    private Dialog dialog;
    private String encodedImage;
    String filepathimg;
    private List<clusterDetailsModel> finalDetailsList;
    private String flagValue;
    private final ArrayList<ArrayList<String>> form7is;
    private final ArrayList<ArrayList<String>> form8is;
    private String formatBRemarks;
    private List<clusterDetailsModel> housedetailList;
    Uri imageUri;
    private List<clusterDetailsModel> newDetailsList;
    private String partNo;
    private String passref;
    private String photoref;
    private String preferredUsername;
    BloPseDetailsBinding pseDetailsBinding;
    private String refreshToken;
    private String remarks;
    private List<clusterDetailsModel> removedDetailsList;
    ArrayList<String> responseFormatAList;
    Retrofit retrofit;
    private String rtkband;
    private String selectedReason;
    private String selectedRemark;
    private String stateCode;
    private String token = "";
    private JSONArray payloadHousedetails = null;
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public ClusterNumberFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.blopartnumber = "";
        this.blostatecode = "";
        this.bloassemcode = "";
        this.photoref = " ";
        this.passref = " ";
        this.deletionReasonList = new ArrayList<>();
        this.responseFormatAList = new ArrayList<>();
        this.bloverify = new ArrayList<>();
        this.assignedBloId = new ArrayList<>();
        this.bloOutput1 = new ArrayList<>();
        this.bloFieldRrk = new ArrayList<>();
        this.form7is = new ArrayList<>();
        this.form8is = new ArrayList<>();
        this.commonUtilClass = new CommomUtility();
        this.bundle = new Bundle();
        this.bundle1 = new Bundle();
        this.addressDetails = null;
        this.activityResultLauncher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new AnonymousClass9());
        this.filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentClusterNumberBinding.inflate(inflater);
        this.finalDetailsList = new ArrayList();
        this.newDetailsList = new ArrayList();
        this.removedDetailsList = new ArrayList();
        this.housedetailList = new ArrayList();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.clusterId = arguments.getString(CLUSTER_ID);
            this.flagValue = arguments.getString("Flag");
        }
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment.1
            public void handleOnBackPressed() {
                ClusterNumberFragment.this.openFragment(new PseFragment(), ClusterNumberFragment.PSE_FRAGMENT);
            }
        };
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda15
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
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), onBackPressedCallback);
        this.binding.headTitle.setText(this.clusterId);
        this.bloassemcode = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.blostatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.preferredUsername = SharedPref.getInstance(requireContext()).getPreferredUsername();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.blopartnumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.atkband = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(requireContext()).getRtknBnd();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        pseclusterDetails();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        openFragment(new PseFragment(), PSE_FRAGMENT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    public JSONArray pseclusterDetails() {
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put(STATE_CD, this.blostatecode);
        map.put("acNo", this.bloassemcode);
        map.put(PART_NO, this.blopartnumber);
        map.put(CLUSTER_ID, this.clusterId);
        map.put(ASSIGNED_BLO_ID, this.preferredUsername);
        JSONObject jSONObject = new JSONObject(map);
        Logger.d("pending json NO", String.valueOf(jSONObject));
        System.out.println("pending json NO" + jSONObject);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getclusterDetails(this.token, "blo", this.blostatecode, "ANDROIDMOB", map).enqueue(new AnonymousClass2());
        return this.payloadHousedetails;
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<EronetResponse> {
        AnonymousClass2() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                ClusterNumberFragment.this.payloadHousedetails = ((EronetResponse) response.body()).getPayload();
                if (ClusterNumberFragment.this.payloadHousedetails != null && !ClusterNumberFragment.this.payloadHousedetails.isEmpty()) {
                    Logger.d("json: ", String.valueOf(ClusterNumberFragment.this.gson.toJsonTree((LinkedTreeMap) ClusterNumberFragment.this.payloadHousedetails.get(0)).getAsJsonObject()));
                    Logger.d("payload: ", String.valueOf(ClusterNumberFragment.this.payloadHousedetails));
                    ClusterNumberFragment clusterNumberFragment = ClusterNumberFragment.this;
                    clusterNumberFragment.renderingdata(clusterNumberFragment.payloadHousedetails);
                    ClusterNumberFragment.this.alertDialog.dismiss();
                    return;
                }
                ClusterNumberFragment.this.alertDialog.dismiss();
                ClusterNumberFragment.this.showdialog2("Alert", "No Record Found");
                return;
            }
            if (response.code() == 401) {
                ClusterNumberFragment.this.commomUtility.getRefreshToken(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$2$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(ClusterNumberFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(ClusterNumberFragment.HOUSE_NUMBER_FRAG, e.getMessage());
            }
            ClusterNumberFragment.this.alertDialog.dismiss();
            ClusterNumberFragment.this.showdialog2("Alert", "No Record Found");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            ClusterNumberFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ClusterNumberFragment.this.commomUtility.showMessageOK(ClusterNumberFragment.this.requireContext(), ClusterNumberFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ClusterNumberFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setToken("Bearer " + str);
            ClusterNumberFragment.this.pseclusterDetails();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setLocaleBool(false);
            ClusterNumberFragment.this.startActivity(new Intent((Context) ClusterNumberFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            ClusterNumberFragment.this.alertDialog.dismiss();
            ClusterNumberFragment.this.showdialog4("Alert", "Unable to load data, Please try again.");
            Logger.d(ClusterNumberFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog4(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda16
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog4$2(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog4$2(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(getContext(), (Class<?>) PseActivity.class));
    }

    public void renderingdata(JSONArray housedetails) {
        this.housedetailList.clear();
        this.finalDetailsList.clear();
        this.removedDetailsList.clear();
        this.newDetailsList.clear();
        int i = 0;
        while (i < housedetails.size()) {
            try {
                JsonObject asJsonObject = this.gson.toJsonTree(housedetails.get(i)).getAsJsonObject();
                String strReplace = asJsonObject.get(Constants.FIRST_NAME).toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace2 = asJsonObject.get(Constants.LAST_NAME).toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace3 = asJsonObject.get(EPIC_NO).toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace4 = asJsonObject.get("acNo").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace5 = asJsonObject.get(PART_NO).toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace6 = asJsonObject.get("age").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace7 = asJsonObject.get("gender").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace8 = asJsonObject.get("relationFirstName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace9 = asJsonObject.get("relationLastName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace10 = asJsonObject.get("relationType").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace11 = asJsonObject.get("address").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace12 = asJsonObject.get("slnoInPart").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strReplace13 = asJsonObject.get(PSE_ID).toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                String strValueOf = String.valueOf(asJsonObject.get("photo"));
                String strValueOf2 = String.valueOf(asJsonObject.get("dateOfInclusion"));
                JsonArray asJsonArray = this.gson.toJsonTree(asJsonObject.get("pseRemarkList")).getAsJsonArray();
                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList<String> arrayList2 = new ArrayList<>();
                ArrayList<String> arrayList3 = new ArrayList<>();
                ArrayList<String> arrayList4 = new ArrayList<>();
                int i2 = i;
                ArrayList<String> arrayList5 = new ArrayList<>();
                ArrayList<String> arrayList6 = new ArrayList<>();
                int i3 = 0;
                while (i3 < asJsonArray.size()) {
                    String str = strReplace4;
                    JsonObject asJsonObject2 = this.gson.toJsonTree(asJsonArray.get(i3)).getAsJsonObject();
                    arrayList.add(String.valueOf(asJsonObject2.get(BLO_VERIFY_STATUS)).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    arrayList2.add(String.valueOf(asJsonObject2.get(ASSIGNED_BLO_ID)).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    arrayList3.add(String.valueOf(asJsonObject2.get(BLO_OUTPUT)).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    arrayList4.add(String.valueOf(asJsonObject2.get(BLO_FIELD_REMARKS)).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    arrayList5.add(String.valueOf(asJsonObject2.get(ISFORM_7_GEN)).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    arrayList6.add(String.valueOf(asJsonObject2.get(ISFORM_8_GEN)).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    i3++;
                    strReplace4 = str;
                }
                this.bloverify.add(arrayList);
                this.assignedBloId.add(arrayList2);
                this.bloOutput1.add(arrayList3);
                this.bloFieldRrk.add(arrayList4);
                this.form7is.add(arrayList5);
                this.form8is.add(arrayList6);
                this.finalDetailsList.add(new clusterDetailsModel(strReplace, strReplace2, strReplace3, strReplace4, strReplace5, strReplace6, strReplace7, strReplace8, strReplace9, strReplace10, strReplace11, strReplace12, strReplace13, strValueOf2, "Pending", strValueOf, this.bloverify, this.assignedBloId, this.bloOutput1, this.bloFieldRrk, this.form7is, this.form8is, asJsonArray));
                i = i2 + 1;
            } catch (Exception e) {
                Logger.d(HOUSE_NUMBER_FRAG, e.getMessage());
                Logger.d("error", "Failed to read");
                return;
            }
        }
        for (int i4 = 0; i4 < this.finalDetailsList.size(); i4++) {
            if (this.partNo.equals(this.finalDetailsList.get(i4).getPartnumber())) {
                this.newDetailsList.add(this.finalDetailsList.get(i4));
            }
        }
        for (int i5 = 0; i5 < this.finalDetailsList.size(); i5++) {
            if (!this.partNo.equals(this.finalDetailsList.get(i5).getPartnumber())) {
                this.removedDetailsList.add(this.finalDetailsList.get(i5));
            }
        }
        this.housedetailList.addAll(this.newDetailsList);
        this.housedetailList.addAll(this.removedDetailsList);
        initRecyclerViewAdapter();
        this.binding.houseDetailsRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.binding.houseDetailsRv.setAdapter(this.adapter);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$3, reason: invalid class name */
    class AnonymousClass3 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass3() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloClusterNumberRvItemBinding.inflate(ClusterNumberFragment.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
            String str;
            String str2;
            ((BloClusterNumberRvItemBinding) holder.binding).SerialNoTv.setText("S. No. " + (position + 1));
            ((BloClusterNumberRvItemBinding) holder.binding).applicantET.setText(((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getApplicantFirstname() + " " + ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getApplicantLastname());
            ((BloClusterNumberRvItemBinding) holder.binding).epicNoET.setText(((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getEpicnumber());
            ((BloClusterNumberRvItemBinding) holder.binding).acPartnoET.setText(((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getAc() + "// " + ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getPartnumber());
            if (((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getPhoto().replace(RegexMatcher.JSON_STRING_REGEX, "") == null || ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getPhoto().replace(RegexMatcher.JSON_STRING_REGEX, "").equals("null")) {
                ((BloClusterNumberRvItemBinding) holder.binding).imageView9.setImageBitmap(BitmapFactory.decodeResource(ClusterNumberFragment.this.getResources(), R.drawable.blo_dummy_image));
            } else {
                ClusterNumberFragment.this.commonUtilClass.getRetrofitClient(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.token, ClusterNumberFragment.this.atkband, ClusterNumberFragment.this.rtkband).getFile("objectstorage", ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getPhoto().replace(RegexMatcher.JSON_STRING_REGEX, ""), ClusterNumberFragment.this.token, SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass1(holder));
            }
            final String str3 = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getApplicantFirstname() + " " + ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getApplicantLastname();
            final String epicnumber = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getEpicnumber();
            final String age = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getAge();
            final String gender = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getGender();
            final String str4 = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getRelationfirstname() + " " + ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getRelationlastname();
            String relationtype = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getRelationtype();
            String address = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getAddress();
            final String serialno = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getSerialno();
            final String ac = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getAc();
            final String partnumber = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getPartnumber();
            final String pseid = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getPseid();
            final String dateofinclusion = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getDateofinclusion();
            if (ClusterNumberFragment.this.flagValue.equals("0")) {
                ((BloClusterNumberRvItemBinding) holder.binding).actionTokenLayout.setVisibility(8);
                str2 = relationtype;
                str = address;
            } else {
                int i = 0;
                ((BloClusterNumberRvItemBinding) holder.binding).actionTokenLayout.setVisibility(0);
                JsonArray pseRemarkList = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getPseRemarkList();
                int i2 = 0;
                str = address;
                while (i < pseRemarkList.size()) {
                    String str5 = relationtype;
                    if (ClusterNumberFragment.this.gson.toJsonTree(pseRemarkList.get(i)).getAsJsonObject().get(ClusterNumberFragment.ASSIGNED_BLO_ID).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals(ClusterNumberFragment.this.preferredUsername)) {
                        i2 = i;
                    }
                    i++;
                    relationtype = str5;
                }
                str2 = relationtype;
                String asString = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(position)).getPseRemarkList().get(i2).getAsJsonObject().get(ClusterNumberFragment.BLO_OUTPUT).getAsString();
                if (asString.equals("null")) {
                    ((BloClusterNumberRvItemBinding) holder.binding).actiontokenTv1.setText("");
                } else {
                    ((BloClusterNumberRvItemBinding) holder.binding).actiontokenTv1.setText(asString);
                }
            }
            final Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(ClusterNumberFragment.this.getResources(), R.drawable.blo_dummy_image);
            final String str6 = str2;
            final String str7 = str;
            ((BloClusterNumberRvItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$3$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(position, str3, epicnumber, pseid, partnumber, age, gender, str4, str6, str7, serialno, ac, dateofinclusion, bitmapDecodeResource, view);
                }
            });
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$3$1, reason: invalid class name */
        class AnonymousClass1 implements Callback<JsonObject> {
            final /* synthetic */ RecyclerViewHolder val$holder;

            AnonymousClass1(final RecyclerViewHolder val$holder) {
                this.val$holder = val$holder;
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    ((JsonObject) response.body()).get("file");
                    ClusterNumberFragment.this.encodedImage = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                    if (ClusterNumberFragment.this.encodedImage == null) {
                        ((BloClusterNumberRvItemBinding) this.val$holder.binding).imageView9.setImageBitmap(BitmapFactory.decodeResource(ClusterNumberFragment.this.getResources(), R.drawable.blo_dummy_image));
                        return;
                    } else {
                        byte[] bArrDecode = Base64.decode(ClusterNumberFragment.this.encodedImage, 0);
                        ClusterNumberFragment.this.bitmap = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                        ((BloClusterNumberRvItemBinding) this.val$holder.binding).imageView9.setImageBitmap(ClusterNumberFragment.this.bitmap);
                        return;
                    }
                }
                if (response.code() == 401) {
                    ClusterNumberFragment.this.commonUtilClass.getRefreshToken(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$3$1$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str, String str2) {
                            this.f$0.lambda$onResponse$1(i, str, str2);
                        }
                    });
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString(ClusterNumberFragment.MESSAGE);
                    Logger.d("imageerror", strOptString);
                    if (strOptString.equals("File not found")) {
                        ((BloClusterNumberRvItemBinding) this.val$holder.binding).imageView9.setImageBitmap(BitmapFactory.decodeResource(ClusterNumberFragment.this.getResources(), R.drawable.blo_dummy_image));
                    }
                } catch (Exception e) {
                    Logger.e("", e.getMessage());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                ClusterNumberFragment.this.alertDialog.dismiss();
                System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
                if (i == 401 || i == 400) {
                    ClusterNumberFragment.this.commonUtilClass.showMessageOK(ClusterNumberFragment.this.requireContext(), ClusterNumberFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$3$1$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                        }
                    });
                    return;
                }
                ClusterNumberFragment.this.token = "Bearer " + str;
                SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setRefreshToken(str2);
                SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setToken("Bearer " + str);
                ClusterNumberFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setLocaleBool(false);
                ClusterNumberFragment.this.startActivity(new Intent((Context) ClusterNumberFragment.this.getActivity(), (Class<?>) LoginActivity.class));
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(ClusterNumberFragment.COMING_IN_ON_FAILURE, t.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Bitmap bitmap, View view) {
            if (ClusterNumberFragment.this.flagValue.equals("0")) {
                JsonArray pseRemarkList = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(i)).getPseRemarkList();
                int i2 = 0;
                for (int i3 = 0; i3 < pseRemarkList.size(); i3++) {
                    if (ClusterNumberFragment.this.gson.toJsonTree(pseRemarkList.get(i3)).getAsJsonObject().get(ClusterNumberFragment.ASSIGNED_BLO_ID).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").equals(ClusterNumberFragment.this.preferredUsername)) {
                        i2 = i3;
                    }
                }
                JsonObject asJsonObject = ((clusterDetailsModel) ClusterNumberFragment.this.housedetailList.get(i)).getPseRemarkList().get(i2).getAsJsonObject();
                String asString = asJsonObject.get(ClusterNumberFragment.BLO_VERIFY_STATUS).getAsString();
                String strValueOf = String.valueOf(asJsonObject.get(ClusterNumberFragment.BLO_OUTPUT));
                String strValueOf2 = String.valueOf(asJsonObject.get(ClusterNumberFragment.BLO_FIELD_REMARKS));
                if (asString.equals("Pending")) {
                    ClusterNumberFragment clusterNumberFragment = ClusterNumberFragment.this;
                    clusterNumberFragment.bottomSheet(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, ((clusterDetailsModel) clusterNumberFragment.housedetailList.get(i)).getPhoto().replace(RegexMatcher.JSON_STRING_REGEX, ""), bitmap, strValueOf, strValueOf2);
                    return;
                } else {
                    ClusterNumberFragment.this.showdialog("Alert", "Already Submitted");
                    return;
                }
            }
            Logger.d("remark---------NO action performed", "");
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return ClusterNumberFragment.this.housedetailList.size();
        }
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bottomSheet(String name, final String epicno, final String pseid, String partno, String age, String gender, String rlnName, String rlnType, String address12, final String serialNo, String acno, String dateofinclusion, String photo, Bitmap dummyimg, String tokenValue, String blofeildRemark) {
        int i;
        Date date;
        Dialog dialog = new Dialog(getContext());
        this.dialog = dialog;
        dialog.requestWindowFeature(1);
        BloPseDetailsBinding bloPseDetailsBindingInflate = BloPseDetailsBinding.inflate(getLayoutInflater());
        this.pseDetailsBinding = bloPseDetailsBindingInflate;
        this.dialog.setContentView((View) bloPseDetailsBindingInflate.getRoot());
        this.dialog.getWindow().setLayout(-1, -2);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        this.dialog.getWindow().setGravity(80);
        this.pseDetailsBinding.bottomSubmitLayout.setVisibility(0);
        this.pseDetailsBinding.fillForm7.setVisibility(8);
        this.pseDetailsBinding.fillForm8.setVisibility(8);
        this.pseDetailsBinding.deletionReason.setVisibility(8);
        this.pseDetailsBinding.uploadPhotographTv.setVisibility(8);
        this.pseDetailsBinding.uploadPhoto.setVisibility(8);
        this.pseDetailsBinding.preview.setVisibility(8);
        this.pseDetailsBinding.chooseFileDeletion.setVisibility(8);
        this.pseDetailsBinding.chooseFileName.setVisibility(8);
        this.pseDetailsBinding.chooseFileNameSize.setVisibility(8);
        this.pseDetailsBinding.preview1.setVisibility(8);
        this.pseDetailsBinding.chooseFileDeletion1.setVisibility(8);
        this.pseDetailsBinding.chooseFileName1.setVisibility(8);
        this.pseDetailsBinding.chooseFileNameSize1.setVisibility(8);
        if (this.flagValue.equals("0")) {
            if (this.partNo.equals(partno)) {
                this.pseDetailsBinding.pendingLayout.setVisibility(0);
                this.pseDetailsBinding.bottomSubmitLayout.setVisibility(0);
                this.pseDetailsBinding.DoneLayout.setVisibility(8);
                this.pseDetailsBinding.uploadFormatA.setVisibility(0);
            } else {
                this.pseDetailsBinding.pendingLayout.setVisibility(0);
                this.pseDetailsBinding.bottomSubmitLayout.setVisibility(0);
                this.pseDetailsBinding.DoneLayout.setVisibility(8);
                this.pseDetailsBinding.uploadFormatA.setVisibility(8);
            }
        } else if (this.partNo.equals(partno)) {
            this.pseDetailsBinding.pendingLayout.setVisibility(8);
            this.pseDetailsBinding.bottomSubmitLayout.setVisibility(8);
            this.pseDetailsBinding.DoneLayout.setVisibility(0);
            this.pseDetailsBinding.uploadFormatA.setVisibility(8);
            this.pseDetailsBinding.remarkField.setText("Remark");
        } else {
            this.pseDetailsBinding.pendingLayout.setVisibility(8);
            this.pseDetailsBinding.bottomSubmitLayout.setVisibility(8);
            this.pseDetailsBinding.DoneLayout.setVisibility(0);
            this.pseDetailsBinding.uploadFormatA.setVisibility(8);
            this.pseDetailsBinding.remarkField.setText("Suggestion");
        }
        String str = "";
        if (tokenValue == null || tokenValue.equals("null") || tokenValue.equals("")) {
            this.pseDetailsBinding.actionTakenTv.setText("");
        } else {
            this.pseDetailsBinding.actionTakenTv.setText(tokenValue);
        }
        if (blofeildRemark == null || blofeildRemark.equals("null") || blofeildRemark.equals("")) {
            this.pseDetailsBinding.remarkTv1.setText("");
        } else {
            this.pseDetailsBinding.remarkTv1.setText(blofeildRemark);
        }
        if (name == null || name.equals("null") || name.equals("")) {
            this.pseDetailsBinding.applicantNameTv.setText("");
        } else {
            this.pseDetailsBinding.applicantNameTv.setText(name);
        }
        if (epicno == null || epicno.equals("null") || epicno.equals("")) {
            this.pseDetailsBinding.epicNoEt.setText("");
        } else {
            this.pseDetailsBinding.epicNoEt.setText(epicno);
        }
        if (age == null || age.equals("null") || age.equals("")) {
            this.pseDetailsBinding.ageEt.setText("");
        } else {
            this.pseDetailsBinding.ageEt.setText(age);
        }
        if (gender == null || gender.equals("null") || gender.equals("")) {
            this.pseDetailsBinding.genderTv1.setText("");
        } else {
            this.pseDetailsBinding.genderTv1.setText(gender);
        }
        if (rlnName == null || rlnName.equals("null") || rlnName.equals("")) {
            this.pseDetailsBinding.relativeTv1.setText("");
        } else {
            this.pseDetailsBinding.relativeTv1.setText(rlnName);
        }
        if (rlnType == null || rlnType.equals("null") || rlnType.equals("")) {
            this.pseDetailsBinding.relationtype.setText("");
        } else if (rlnType.equals("F") || rlnType.equals("FTHR")) {
            this.pseDetailsBinding.relationtype.setText("Father");
        } else if (rlnType.equals("M") || rlnType.equals("MTHR")) {
            this.pseDetailsBinding.relationtype.setText("Mother");
        } else if (rlnType.equals("H") || rlnType.equals("HSBN")) {
            this.pseDetailsBinding.relationtype.setText("Husband");
        } else if (rlnType.equals("W") || rlnType.equals("WIFE")) {
            this.pseDetailsBinding.relationtype.setText("Wife");
        } else if (rlnType.equals("L") || rlnType.equals("OTHR")) {
            this.pseDetailsBinding.relationtype.setText("Other");
        } else {
            this.pseDetailsBinding.relationtype.setText("");
        }
        HashMap map = new HashMap();
        map.put(EPIC_NUMBER, epicno);
        map.put("acNo", acno);
        map.put("partNumber", partno);
        map.put(STATE_CD, this.blostatecode);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getaddressDetailsPse(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.blostatecode, APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass4());
        if (serialNo == null || serialNo.equals("null") || serialNo.equals("")) {
            this.pseDetailsBinding.serialNo.setText("");
        } else {
            this.pseDetailsBinding.serialNo.setText(serialNo);
        }
        if (dateofinclusion != null && !dateofinclusion.equals("null") && !dateofinclusion.equals("")) {
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(dateofinclusion.substring(1, 11));
            } catch (ParseException unused) {
                Logger.d("exception", "exception");
                date = null;
            }
            str = new SimpleDateFormat("dd/MM/yyyy").format(date);
        }
        this.pseDetailsBinding.dateInclusionEt.setText(str);
        if (photo == null || photo.equals("null")) {
            i = 0;
            this.pseDetailsBinding.personImage.setImageBitmap(dummyimg);
        } else {
            i = 0;
            this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile("objectstorage", photo, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass5(dummyimg));
        }
        String str2 = "1";
        if (this.asmblyNO.equals(acno)) {
            if (this.partNo.equals(partno)) {
                this.pseDetailsBinding.matchingAc.setVisibility(i);
                this.pseDetailsBinding.notmatchingAc.setVisibility(8);
                this.pseDetailsBinding.uploadFormatA.setVisibility(i);
                str2 = "0";
            } else {
                this.pseDetailsBinding.matchingAc.setVisibility(8);
                this.pseDetailsBinding.notmatchingAc.setVisibility(i);
                this.pseDetailsBinding.uploadFormatA.setVisibility(8);
            }
        } else {
            this.pseDetailsBinding.matchingAc.setVisibility(8);
            this.pseDetailsBinding.notmatchingAc.setVisibility(i);
        }
        this.pseDetailsBinding.matchingAc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda23
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                this.f$0.lambda$bottomSheet$3(radioGroup, i2);
            }
        });
        this.pseDetailsBinding.chooseFile1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$5(view);
            }
        });
        this.pseDetailsBinding.chooseFileDeletion1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$6(view);
            }
        });
        this.pseDetailsBinding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$8(view);
            }
        });
        this.pseDetailsBinding.chooseFileDeletion.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$9(view);
            }
        });
        this.pseDetailsBinding.notmatchingAc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda5
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                this.f$0.lambda$bottomSheet$10(radioGroup, i2);
            }
        });
        this.bundle.putString("37", acno);
        this.bundle.putString("38", pseid);
        this.bundle.putString("40", partno);
        this.bundle.putString("41", this.preferredUsername);
        this.pseDetailsBinding.crossDialog.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$11(view);
            }
        });
        this.pseDetailsBinding.imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$12(view);
            }
        });
        final String str3 = str2;
        this.pseDetailsBinding.submitTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bottomSheet$15(str3, pseid, epicno, serialNo, view);
            }
        });
        this.dialog.show();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<EronetResponse> {
        AnonymousClass4() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.body() != null) {
                ClusterNumberFragment.this.addressDetails = ((EronetResponse) response.body()).getPayload();
                String string = "";
                if (!ClusterNumberFragment.this.addressDetails.isEmpty()) {
                    JsonObject asJsonObject = ClusterNumberFragment.this.gson.toJsonTree((LinkedTreeMap) ClusterNumberFragment.this.addressDetails.get(0)).getAsJsonObject();
                    ClusterNumberFragment clusterNumberFragment = ClusterNumberFragment.this;
                    if (!String.valueOf(asJsonObject.get(ClusterNumberFragment.HOUSE_NUMBER)).equals("") && !String.valueOf(asJsonObject.get(ClusterNumberFragment.HOUSE_NUMBER)).equals("null")) {
                        StringBuilder sbAppend = new StringBuilder().append(String.valueOf(asJsonObject.get(ClusterNumberFragment.HOUSE_NUMBER)).replace(RegexMatcher.JSON_STRING_REGEX, "")).append(", ").append((String.valueOf(asJsonObject.get(ClusterNumberFragment.LOCALITY_STREET)).equals("") || String.valueOf(asJsonObject.get(ClusterNumberFragment.LOCALITY_STREET)).equals("null")) ? "" : String.valueOf(asJsonObject.get(ClusterNumberFragment.LOCALITY_STREET)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ").append((String.valueOf(asJsonObject.get(ClusterNumberFragment.TOWN_VILLAGE_NEW)).equals("") || String.valueOf(asJsonObject.get(ClusterNumberFragment.TOWN_VILLAGE_NEW)).equals("null")) ? "" : String.valueOf(asJsonObject.get(ClusterNumberFragment.TOWN_VILLAGE_NEW)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ").append((String.valueOf(asJsonObject.get(ClusterNumberFragment.DISTRICT_NAME_ENGLISH)).equals("") || String.valueOf(asJsonObject.get(ClusterNumberFragment.DISTRICT_NAME_ENGLISH)).equals("null")) ? "" : String.valueOf(asJsonObject.get(ClusterNumberFragment.DISTRICT_NAME_ENGLISH)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "") + ", ");
                        if (!String.valueOf(asJsonObject.get(ClusterNumberFragment.STATE_NAME_ENGLISH)).equals("") && !String.valueOf(asJsonObject.get(ClusterNumberFragment.STATE_NAME_ENGLISH)).equals("null")) {
                            StringBuilder sbAppend2 = new StringBuilder().append(String.valueOf(asJsonObject.get(ClusterNumberFragment.STATE_NAME_ENGLISH)).trim().replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!String.valueOf(asJsonObject.get(ClusterNumberFragment.PIN_CODE_NEW)).equals("") && !String.valueOf(asJsonObject.get(ClusterNumberFragment.PIN_CODE_NEW)).equals("null")) {
                                string = ", " + String.valueOf(asJsonObject.get(ClusterNumberFragment.PIN_CODE_NEW)).trim().replace(RegexMatcher.JSON_STRING_REGEX, "");
                            }
                            string = sbAppend2.append(string).toString();
                        }
                        string = sbAppend.append(string).toString();
                    }
                    clusterNumberFragment.address = string;
                    ClusterNumberFragment.this.pseDetailsBinding.addressTv1.setText(ClusterNumberFragment.this.address);
                    ClusterNumberFragment.this.alertDialog.dismiss();
                    return;
                }
                ClusterNumberFragment.this.pseDetailsBinding.addressTv1.setText("");
                return;
            }
            if (response.code() == 401) {
                ClusterNumberFragment.this.commomUtility.getRefreshToken(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$4$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(ClusterNumberFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(ClusterNumberFragment.HOUSE_NUMBER_FRAG, e.getMessage());
            }
            ClusterNumberFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            ClusterNumberFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ClusterNumberFragment.this.commomUtility.showMessageOK(ClusterNumberFragment.this.requireContext(), ClusterNumberFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$4$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ClusterNumberFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setToken("Bearer " + str);
            ClusterNumberFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setLocaleBool(false);
            ClusterNumberFragment.this.startActivity(new Intent((Context) ClusterNumberFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d(ClusterNumberFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        final /* synthetic */ Bitmap val$dummyimg;

        AnonymousClass5(final Bitmap val$dummyimg) {
            this.val$dummyimg = val$dummyimg;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            Logger.d("akjdal;", String.valueOf(response.code()));
            if (response.code() == 200) {
                ((JsonObject) response.body()).get("file");
                ClusterNumberFragment.this.encodedImage = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(ClusterNumberFragment.this.encodedImage, 0);
                ClusterNumberFragment.this.bitmap = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                ClusterNumberFragment.this.pseDetailsBinding.personImage.setImageBitmap(ClusterNumberFragment.this.bitmap);
                return;
            }
            if (response.code() == 401) {
                ClusterNumberFragment.this.commonUtilClass.getRefreshToken(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$5$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(ClusterNumberFragment.MESSAGE);
                Logger.d("imageerror", strOptString);
                if (strOptString.equals("File not found")) {
                    ClusterNumberFragment.this.pseDetailsBinding.personImage.setImageBitmap(this.val$dummyimg);
                }
            } catch (Exception e) {
                Logger.e("", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            ClusterNumberFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ClusterNumberFragment.this.commonUtilClass.showMessageOK(ClusterNumberFragment.this.requireContext(), ClusterNumberFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$5$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ClusterNumberFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setToken("Bearer " + str);
            ClusterNumberFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setLocaleBool(false);
            ClusterNumberFragment.this.startActivity(new Intent((Context) ClusterNumberFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(ClusterNumberFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$3(RadioGroup radioGroup, int i) {
        if (i == 2131362420) {
            this.bloOutput = "ASD";
            this.deletionReasonList.clear();
            this.pseDetailsBinding.pendingRemark.setVisibility(0);
            this.pseDetailsBinding.fillForm7.setVisibility(8);
            this.pseDetailsBinding.fillForm8.setVisibility(8);
            this.pseDetailsBinding.uploadPhotographTv.setVisibility(8);
            this.pseDetailsBinding.uploadPhoto.setVisibility(8);
            this.pseDetailsBinding.bottomSubmitLayout.setVisibility(0);
            this.pseDetailsBinding.submitTv.setText("Generate Form 7");
            this.pseDetailsBinding.deletionReason.setVisibility(0);
            this.pseDetailsBinding.preview.setImageDrawable(null);
            this.deletionReasonList.add("Select Reason");
            this.deletionReasonList.add("Death");
            this.deletionReasonList.add("Absent/Permanently shifted");
            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.deletionReasonList);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.pseDetailsBinding.deletionspinner.setAdapter((SpinnerAdapter) arrayAdapter);
            this.pseDetailsBinding.deletionspinner.setSelection(0);
            this.selectedReason = this.pseDetailsBinding.deletionspinner.getSelectedItem().toString();
            this.pseDetailsBinding.deletionspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment.6
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ClusterNumberFragment.this.selectedReason = String.valueOf(parent.getItemAtPosition(position));
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                    Logger.d("onNothingSelected", "");
                }
            });
            return;
        }
        if (i == 2131364947) {
            this.bloOutput = "Original";
            this.pseDetailsBinding.pendingRemark.setVisibility(0);
            this.pseDetailsBinding.fillForm7.setVisibility(8);
            this.pseDetailsBinding.fillForm8.setVisibility(8);
            this.pseDetailsBinding.bottomSubmitLayout.setVisibility(0);
            this.pseDetailsBinding.deletionReason.setVisibility(8);
            this.pseDetailsBinding.uploadPhotographTv.setVisibility(8);
            this.pseDetailsBinding.uploadPhoto.setVisibility(8);
            this.pseDetailsBinding.submitTv.setText("Submit");
            this.pseDetailsBinding.preview.setImageDrawable(null);
            return;
        }
        if (i != 2131365178) {
            return;
        }
        this.bloOutput = "PN";
        this.pseDetailsBinding.pendingRemark.setVisibility(0);
        this.pseDetailsBinding.fillForm7.setVisibility(8);
        this.pseDetailsBinding.fillForm8.setVisibility(8);
        this.pseDetailsBinding.bottomSubmitLayout.setVisibility(0);
        this.pseDetailsBinding.submitTv.setText("Preview Form 8");
        this.pseDetailsBinding.deletionReason.setVisibility(8);
        this.pseDetailsBinding.uploadPhotographTv.setVisibility(0);
        this.pseDetailsBinding.preview.setVisibility(8);
        this.pseDetailsBinding.chooseFileDeletion.setVisibility(8);
        this.pseDetailsBinding.chooseFileName.setVisibility(8);
        this.pseDetailsBinding.chooseFileNameSize.setVisibility(8);
        this.pseDetailsBinding.uploadPhoto.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$5(View view) {
        final CharSequence[] charSequenceArr = {TAKE_PHOTO, CHOOSE_IMAGE_FROM_GALLERY, "Choose PDF from Gallery", CANCEL};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$bottomSheet$4(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$4(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(TAKE_PHOTO)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(102);
        } else if (charSequenceArr[i].equals(CHOOSE_IMAGE_FROM_GALLERY)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(102);
        } else if (charSequenceArr[i].equals("Choose PDF from Gallery")) {
            openfile1();
        } else if (charSequenceArr[i].equals(CANCEL)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$6(View view) {
        this.pseDetailsBinding.chooseFileName1.setText("");
        this.pseDetailsBinding.chooseFileName1.setVisibility(8);
        this.pseDetailsBinding.preview1.setVisibility(8);
        this.pseDetailsBinding.preview1.setImageDrawable(null);
        this.pseDetailsBinding.chooseFileDeletion1.setVisibility(8);
        this.pseDetailsBinding.chooseFileNameSize1.setVisibility(8);
        this.pseDetailsBinding.chooseFile1.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$8(View view) {
        final CharSequence[] charSequenceArr = {TAKE_PHOTO, CHOOSE_IMAGE_FROM_GALLERY, CANCEL};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda13
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$bottomSheet$7(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$7(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(TAKE_PHOTO)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(101);
        } else if (charSequenceArr[i].equals(CHOOSE_IMAGE_FROM_GALLERY)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(101);
        } else if (charSequenceArr[i].equals(CANCEL)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$9(View view) {
        this.pseDetailsBinding.chooseFileName.setText("");
        this.pseDetailsBinding.chooseFileName.setVisibility(8);
        this.pseDetailsBinding.preview.setVisibility(8);
        this.pseDetailsBinding.preview.setImageDrawable(null);
        this.pseDetailsBinding.chooseFileDeletion.setVisibility(8);
        this.pseDetailsBinding.chooseFileNameSize.setVisibility(8);
        this.pseDetailsBinding.chooseFile.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$10(RadioGroup radioGroup, int i) {
        if (i == 2131363506) {
            this.bloOutput = "Duplicate";
        } else {
            if (i != 2131364852) {
                return;
            }
            this.bloOutput = "No Information";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$11(View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$12(View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$15(String str, final String str2, final String str3, final String str4, View view) {
        this.remarks = this.pseDetailsBinding.remarkTv.getText().toString();
        this.formatBRemarks = this.pseDetailsBinding.remarkUploadTv.getText().toString();
        if (str.equals("0")) {
            if (this.pseDetailsBinding.remarkUploadTv.getText().toString().equals("")) {
                showdialog("Alert", "Please Enter Format A Remark");
                return;
            }
            if (!this.pseDetailsBinding.originalRb.isChecked() && !this.pseDetailsBinding.asdRb.isChecked() && !this.pseDetailsBinding.pnRb.isChecked()) {
                showdialog("Alert", "Please select an Action");
                return;
            }
            if (this.bloOutput.equals("ASD") && this.selectedReason.equals("Select Reason")) {
                showdialog("Alert", "Please select Reason for Deletion");
                return;
            }
            if (this.bloOutput.equals("PN") && this.pseDetailsBinding.preview.getDrawable() == null) {
                showdialog("Alert", "Please Attach Document");
                return;
            }
            if (this.pseDetailsBinding.remarkTv.getText().toString().equals("")) {
                showdialog("Alert", "Please Enter Remark");
                return;
            }
            if (this.bloOutput.equals("ASD")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                builder.setMessage("Do You want to Fill Form 7 ?");
                builder.setCancelable(true);
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda19
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$bottomSheet$13(str2, dialogInterface, i);
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda20
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$bottomSheet$14(str3, str2, str4, dialogInterface, i);
                    }
                });
                builder.show();
                return;
            }
            if (this.bloOutput.equals("PN")) {
                Bundle bundle = new Bundle();
                bundle.putString("applicantName", this.pseDetailsBinding.applicantNameTv.getText().toString());
                bundle.putString(EPIC_NUMBER, this.pseDetailsBinding.epicNoEt.getText().toString());
                bundle.putString("age", this.pseDetailsBinding.ageEt.getText().toString());
                bundle.putString("gender", this.pseDetailsBinding.genderTv1.getText().toString());
                bundle.putString("relationName", this.pseDetailsBinding.relativeTv1.getText().toString());
                bundle.putString("relationType", this.pseDetailsBinding.relationtype.getText().toString());
                bundle.putString("address", this.pseDetailsBinding.addressTv1.getText().toString());
                bundle.putString("dateofInclusion", this.pseDetailsBinding.dateInclusionEt.getText().toString());
                bundle.putString("serialNo", this.pseDetailsBinding.serialNo.getText().toString());
                bundle.putString("formatARemark", this.formatBRemarks);
                bundle.putString("remark", this.remarks);
                bundle.putString("photoReferenceNo", this.photoref);
                bundle.putString("photoFormatAReferenceNo", this.passref);
                bundle.putString("pseid", str2);
                bundle.putString(BLO_OUTPUT, this.bloOutput);
                bundle.putString("preferredUsername", this.preferredUsername);
                bundle.putString(CLUSTER_ID, this.clusterId);
                bundle.putString("flagValue", this.flagValue);
                bundle.putString("previewFlag", "1");
                PseChecklistPreviewFragment pseChecklistPreviewFragment = new PseChecklistPreviewFragment();
                pseChecklistPreviewFragment.setArguments(bundle);
                openFragment(pseChecklistPreviewFragment, "PseChecklistPreviewFragment");
                this.dialog.dismiss();
                return;
            }
            pseSubmit(str2, this.remarks, this.bloOutput, "4", this.formatBRemarks);
            return;
        }
        if (!this.pseDetailsBinding.noinformationRb.isChecked() && !this.pseDetailsBinding.dupicateRb.isChecked()) {
            showdialog("Alert", "Please select an Action");
        } else if (this.pseDetailsBinding.remarkTv.getText().toString().equals("")) {
            showdialog("Alert", "Please enter Remark");
        } else {
            pseSubmit(str2, this.remarks, this.bloOutput, "4", this.formatBRemarks);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$13(String str, DialogInterface dialogInterface, int i) {
        pseSubmit(str, this.remarks, this.bloOutput, "0", this.formatBRemarks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bottomSheet$14(String str, String str2, String str3, DialogInterface dialogInterface, int i) {
        String str4;
        this.alertDialog.show();
        if (this.selectedReason.equals("Death")) {
            str4 = "DETH";
        } else if (!this.selectedReason.equals("Absent/Permanently shifted")) {
            str4 = "";
        } else {
            str4 = "ABSH";
        }
        ArrayList<HashMap> arrayList = new ArrayList<>();
        HashMap map = new HashMap();
        map.put(STATE_CD, this.stateCode);
        map.put("acNo", this.asmblyNO);
        map.put(PART_NO, this.partNo);
        map.put(EPIC_NO, str);
        map.put(PSE_ID, str2);
        map.put("partSerialNumber", str3);
        map.put("eroActionStatus", "form7");
        map.put("isPse", 1);
        map.put("module", "PSE");
        map.put("reasonForDeletion", str4);
        arrayList.add(map);
        System.out.println("formatAmap" + new JSONObject(map));
        Logger.d("Form7Array", String.valueOf(arrayList));
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).pseForm7Submit(this.token, "blo", this.blostatecode, APPLICATION_JSON, "ANDROIDMOB", arrayList).enqueue(new AnonymousClass7(str2));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JsonObject> {
        final /* synthetic */ String val$pseid;

        AnonymousClass7(final String val$pseid) {
            this.val$pseid = val$pseid;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.body() != null) {
                Logger.d("mesage32---", String.valueOf(((JsonObject) response.body()).getAsJsonObject()));
                ClusterNumberFragment clusterNumberFragment = ClusterNumberFragment.this;
                clusterNumberFragment.pseSubmit(this.val$pseid, clusterNumberFragment.remarks, ClusterNumberFragment.this.bloOutput, "12", ClusterNumberFragment.this.formatBRemarks);
                ClusterNumberFragment.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                ClusterNumberFragment.this.commonUtilClass.getRefreshToken(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$7$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            ClusterNumberFragment clusterNumberFragment2 = ClusterNumberFragment.this;
            clusterNumberFragment2.pseSubmit(this.val$pseid, clusterNumberFragment2.remarks, ClusterNumberFragment.this.bloOutput, "0", ClusterNumberFragment.this.formatBRemarks);
            try {
                Logger.d("mesage12---", String.valueOf(new JSONObject(response.errorBody().string()).get(ClusterNumberFragment.MESSAGE)));
            } catch (IOException | JSONException e) {
                Logger.d(ClusterNumberFragment.PSE_SUBMIT, e.getMessage());
            }
            ClusterNumberFragment.this.alertDialog.dismiss();
            ClusterNumberFragment.this.showdialogFinal(ClusterNumberFragment.MESSAGE12, "Null");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            ClusterNumberFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ClusterNumberFragment.this.commonUtilClass.showMessageOK(ClusterNumberFragment.this.requireContext(), ClusterNumberFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$7$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ClusterNumberFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setToken("Bearer " + str);
            ClusterNumberFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setLocaleBool(false);
            ClusterNumberFragment.this.startActivity(new Intent((Context) ClusterNumberFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(ClusterNumberFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public void pseSubmit(String pseId, String remark, String bloOutput, String submitFlag, String bloRemark) {
        String str = bloRemark;
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put("acNo", this.asmblyNO);
        map.put(PART_NO, this.partNo);
        map.put("pseIds", pseId);
        map.put(ASSIGNED_BLO_ID, this.preferredUsername);
        map.put(BLO_FIELD_REMARKS, remark);
        map.put(BLO_VERIFY_STATUS, "Submitted by Blo GARUDA");
        map.put("lastUpdatedBy", "BLO");
        map.put(BLO_OUTPUT, bloOutput);
        map.put(ISFORM_8_GEN, Boolean.valueOf(submitFlag.equals("3")));
        map.put(ISFORM_7_GEN, Boolean.valueOf(submitFlag.equals("12")));
        map.put("formRefNo", null);
        map.put("formatB", this.passref.equals(" ") ? null : this.passref);
        if (str == null || str.equals("")) {
            str = null;
        }
        map.put("bloRemarks", str);
        Logger.d("HELLO NO", String.valueOf(new JSONObject(map)));
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).pseclusterSubmit(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.blostatecode, APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass8(submitFlag));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<EronetResponse> {
        final /* synthetic */ String val$submitFlag;

        AnonymousClass8(final String val$submitFlag) {
            this.val$submitFlag = val$submitFlag;
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.body() != null) {
                Logger.d("body response", ((EronetResponse) response.body()).getMessage());
                System.out.println("jkfsbls" + ((EronetResponse) response.body()).toString());
                System.out.println("shfvsihkf" + ((EronetResponse) response.body()).getMessage());
                ClusterNumberFragment.this.alertDialog.dismiss();
                ClusterNumberFragment.this.dialog.dismiss();
                if (this.val$submitFlag.equals("0") || this.val$submitFlag.equals("1") || this.val$submitFlag.equals("2") || this.val$submitFlag.equals("3") || this.val$submitFlag.equals("4") || this.val$submitFlag.equals("12")) {
                    ClusterNumberFragment.this.showdialog("Alert", "Successfully Submitted");
                }
                ClusterNumberFragment.this.bundle1.putString(ClusterNumberFragment.CLUSTER_ID, ClusterNumberFragment.this.clusterId);
                ClusterNumberFragment.this.bundle1.putString("Flag", ClusterNumberFragment.this.flagValue);
                ClusterNumberFragment clusterNumberFragment = new ClusterNumberFragment();
                clusterNumberFragment.setArguments(ClusterNumberFragment.this.bundle1);
                ClusterNumberFragment.this.openFragment(clusterNumberFragment, "cluster_numberFragment");
                return;
            }
            if (response.code() == 401) {
                ClusterNumberFragment.this.commonUtilClass.getRefreshToken(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$8$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d(ClusterNumberFragment.ERROR_RESPONSE, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(ClusterNumberFragment.PSE_SUBMIT, e.getMessage());
            }
            ClusterNumberFragment.this.alertDialog.dismiss();
            ClusterNumberFragment.this.dialog.dismiss();
            ClusterNumberFragment.this.showdialogFinal(ClusterNumberFragment.MESSAGE12, "Null");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            ClusterNumberFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ClusterNumberFragment.this.commonUtilClass.showMessageOK(ClusterNumberFragment.this.requireContext(), ClusterNumberFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$8$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ClusterNumberFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setToken("Bearer " + str);
            ClusterNumberFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setLocaleBool(false);
            ClusterNumberFragment.this.startActivity(new Intent((Context) ClusterNumberFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d(ClusterNumberFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public void openfile1() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/pdf"});
        this.activityResultLauncher1.launch(Intent.createChooser(intent, "Choose File"));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$9, reason: invalid class name */
    class AnonymousClass9 implements ActivityResultCallback<ActivityResult> {
        AnonymousClass9() {
        }

        /* JADX WARN: Code duplicated, block: B:33:0x0095 A[Catch: Exception -> 0x023b, TryCatch #3 {Exception -> 0x023b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0228, B:45:0x0230, B:46:0x023a), top: B:55:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:35:0x00ac A[Catch: Exception -> 0x023b, TRY_LEAVE, TryCatch #3 {Exception -> 0x023b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0228, B:45:0x0230, B:46:0x023a), top: B:55:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:38:0x00bf A[Catch: Exception -> 0x023b, TRY_ENTER, TryCatch #3 {Exception -> 0x023b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0228, B:45:0x0230, B:46:0x023a), top: B:55:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:39:0x012e A[Catch: Exception -> 0x023b, TryCatch #3 {Exception -> 0x023b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0228, B:45:0x0230, B:46:0x023a), top: B:55:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:41:0x0146 A[Catch: Exception -> 0x023b, TryCatch #3 {Exception -> 0x023b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0228, B:45:0x0230, B:46:0x023a), top: B:55:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:42:0x0176 A[Catch: Exception -> 0x023b, TryCatch #3 {Exception -> 0x023b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0228, B:45:0x0230, B:46:0x023a), top: B:55:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:44:0x0228 A[Catch: Exception -> 0x023b, TryCatch #3 {Exception -> 0x023b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0228, B:45:0x0230, B:46:0x023a), top: B:55:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0230 A[Catch: Exception -> 0x023b, TryCatch #3 {Exception -> 0x023b, blocks: (B:31:0x006d, B:33:0x0095, B:35:0x00ac, B:38:0x00bf, B:43:0x01d5, B:39:0x012e, B:41:0x0146, B:42:0x0176, B:44:0x0228, B:45:0x0230, B:46:0x023a), top: B:55:0x006d }] */
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
            ClusterNumberFragment.this.imageUri = result.getData().getData();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                InputStream inputStreamOpenInputStream = ClusterNumberFragment.this.getContext().getContentResolver().openInputStream(ClusterNumberFragment.this.imageUri);
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
                        ClusterNumberFragment.this.byteArray = byteArrayOutputStream.toByteArray();
                        cursorQuery = ClusterNumberFragment.this.getContext().getContentResolver().query(ClusterNumberFragment.this.getSaveImagePath(Base64.encodeToString(ClusterNumberFragment.this.byteArray, 0), ".pdf"), null, null, null, null);
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.close();
                            throw new IllegalArgumentException(ClusterNumberFragment.CAN_T_OBTAIN_FILE_NAME_CURSOR_IS_EMPTY);
                        }
                        cursorQuery.moveToFirst();
                        string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                        if (string.toLowerCase().contains(".pdf")) {
                            if (ClusterNumberFragment.this.filesize < 1024) {
                                double dRound2 = Math.round(ClusterNumberFragment.this.filesize * 100.0d) / 100.0d;
                                ClusterNumberFragment.this.pseDetailsBinding.chooseFileName1.setVisibility(0);
                                ClusterNumberFragment.this.pseDetailsBinding.chooseFileNameSize1.setVisibility(0);
                                ClusterNumberFragment.this.pseDetailsBinding.chooseFileDeletion1.setVisibility(0);
                                ClusterNumberFragment.this.pseDetailsBinding.preview1.setVisibility(0);
                                ClusterNumberFragment.this.pseDetailsBinding.chooseFileName1.setText(string);
                                ClusterNumberFragment.this.pseDetailsBinding.chooseFile1.setTextColor(Color.parseColor(ClusterNumberFragment.BLACK_COLOR));
                                ClusterNumberFragment.this.pseDetailsBinding.chooseFileNameSize1.setText(dRound2 + "KB");
                                ClusterNumberFragment.this.pseDetailsBinding.preview1.setImageResource(R.drawable.blo_pfd_thumbnail);
                            } else {
                                dRound = Math.round(((double) (ClusterNumberFragment.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                                if (dRound > 3.0d) {
                                    ClusterNumberFragment.this.pseDetailsBinding.preview1.setVisibility(8);
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileDeletion1.setVisibility(8);
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileNameSize1.setVisibility(8);
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileName1.setVisibility(8);
                                    ClusterNumberFragment.this.showdialog("Alert", "PDF size exceeded 3MB limit.");
                                } else {
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileName1.setVisibility(0);
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileNameSize1.setVisibility(0);
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileDeletion1.setVisibility(0);
                                    ClusterNumberFragment.this.pseDetailsBinding.preview1.setVisibility(0);
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileName1.setText(string);
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFile1.setTextColor(Color.parseColor(ClusterNumberFragment.BLACK_COLOR));
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileNameSize1.setText(dRound + "MB");
                                    ClusterNumberFragment.this.pseDetailsBinding.preview1.setImageResource(R.drawable.blo_pfd_thumbnail);
                                }
                            }
                            ClusterNumberFragment.this.commonUtilClass.uploadToServer2(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.stateCode, ClusterNumberFragment.this.asmblyNO, ClusterNumberFragment.this.partNo, ClusterNumberFragment.this.filepathimg, ClusterNumberFragment.this.saveImageFileName, ClusterNumberFragment.this.token, "FormatBImage", SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$9$$ExternalSyntheticLambda1
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i2, String str) {
                                    this.f$0.lambda$onActivityResult$3(i2, str);
                                }
                            });
                            return;
                        }
                        ClusterNumberFragment.this.showdialog("", "Please Select the correct format of file");
                    }
                    ClusterNumberFragment.this.byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        cursorQuery = ClusterNumberFragment.this.getContext().getContentResolver().query(ClusterNumberFragment.this.getSaveImagePath(Base64.encodeToString(ClusterNumberFragment.this.byteArray, 0), ".pdf"), null, null, null, null);
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.close();
                            throw new IllegalArgumentException(ClusterNumberFragment.CAN_T_OBTAIN_FILE_NAME_CURSOR_IS_EMPTY);
                        }
                        cursorQuery.moveToFirst();
                        string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                        if (string.toLowerCase().contains(".pdf")) {
                            if (ClusterNumberFragment.this.filesize < 1024) {
                                double dRound3 = Math.round(ClusterNumberFragment.this.filesize * 100.0d) / 100.0d;
                                ClusterNumberFragment.this.pseDetailsBinding.chooseFileName1.setVisibility(0);
                                ClusterNumberFragment.this.pseDetailsBinding.chooseFileNameSize1.setVisibility(0);
                                ClusterNumberFragment.this.pseDetailsBinding.chooseFileDeletion1.setVisibility(0);
                                ClusterNumberFragment.this.pseDetailsBinding.preview1.setVisibility(0);
                                ClusterNumberFragment.this.pseDetailsBinding.chooseFileName1.setText(string);
                                ClusterNumberFragment.this.pseDetailsBinding.chooseFile1.setTextColor(Color.parseColor(ClusterNumberFragment.BLACK_COLOR));
                                ClusterNumberFragment.this.pseDetailsBinding.chooseFileNameSize1.setText(dRound3 + "KB");
                                ClusterNumberFragment.this.pseDetailsBinding.preview1.setImageResource(R.drawable.blo_pfd_thumbnail);
                            } else {
                                dRound = Math.round(((double) (ClusterNumberFragment.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                                if (dRound > 3.0d) {
                                    ClusterNumberFragment.this.pseDetailsBinding.preview1.setVisibility(8);
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileDeletion1.setVisibility(8);
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileNameSize1.setVisibility(8);
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileName1.setVisibility(8);
                                    ClusterNumberFragment.this.showdialog("Alert", "PDF size exceeded 3MB limit.");
                                } else {
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileName1.setVisibility(0);
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileNameSize1.setVisibility(0);
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileDeletion1.setVisibility(0);
                                    ClusterNumberFragment.this.pseDetailsBinding.preview1.setVisibility(0);
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileName1.setText(string);
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFile1.setTextColor(Color.parseColor(ClusterNumberFragment.BLACK_COLOR));
                                    ClusterNumberFragment.this.pseDetailsBinding.chooseFileNameSize1.setText(dRound + "MB");
                                    ClusterNumberFragment.this.pseDetailsBinding.preview1.setImageResource(R.drawable.blo_pfd_thumbnail);
                                }
                            }
                            ClusterNumberFragment.this.commonUtilClass.uploadToServer2(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.stateCode, ClusterNumberFragment.this.asmblyNO, ClusterNumberFragment.this.partNo, ClusterNumberFragment.this.filepathimg, ClusterNumberFragment.this.saveImageFileName, ClusterNumberFragment.this.token, "FormatBImage", SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$9$$ExternalSyntheticLambda1
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i2, String str) {
                                    this.f$0.lambda$onActivityResult$3(i2, str);
                                }
                            });
                            return;
                        }
                        ClusterNumberFragment.this.showdialog("", "Please Select the correct format of file");
                    } catch (Exception e3) {
                        Logger.d(ClusterNumberFragment.CONTENT, e3.getMessage());
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
                ClusterNumberFragment.this.commonUtilClass.getRefreshToken(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$9$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$onActivityResult$2(i2, str2, str3);
                    }
                });
            } else {
                ClusterNumberFragment.this.passref = str;
                Logger.d("passref------", ClusterNumberFragment.this.passref);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$2(int i, String str, String str2) {
            ClusterNumberFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ClusterNumberFragment.this.commonUtilClass.showMessageOK(ClusterNumberFragment.this.requireContext(), ClusterNumberFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$9$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onActivityResult$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ClusterNumberFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setToken("Bearer " + str);
            ClusterNumberFragment.this.commonUtilClass.uploadToServer2(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.stateCode, ClusterNumberFragment.this.asmblyNO, ClusterNumberFragment.this.partNo, ClusterNumberFragment.this.filepathimg, ClusterNumberFragment.this.saveImageFileName, ClusterNumberFragment.this.token, "FormatBImage", SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$9$$ExternalSyntheticLambda3
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i2, String str3) {
                    this.f$0.lambda$onActivityResult$1(i2, str3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setLocaleBool(false);
            ClusterNumberFragment.this.startActivity(new Intent((Context) ClusterNumberFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$1(int i, String str) {
            ClusterNumberFragment.this.passref = str;
            Logger.d("passref------", ClusterNumberFragment.this.passref);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r28v0 */
    /* JADX WARN: Type inference failed for: r28v1 */
    /* JADX WARN: Type inference failed for: r28v2 */
    /* JADX WARN: Type inference failed for: r28v3 */
    /* JADX WARN: Type inference failed for: r28v4, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r28v6 */
    /* JADX WARN: Type inference failed for: r28v7 */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r39v0, types: [in.gov.eci.bloapp.views.fragments.BaseFragment, in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.String] */
    public void onActivityResult(int i, int i2, Intent intent) {
        ?? r28;
        ?? r3;
        ?? contentResolver;
        ?? count;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            this.alertDialog.dismiss();
        }
        String str = "Image size exceeded 2MB limit.";
        if (i == 101 && i2 == -1) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                this.byteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                Logger.e("", e.getMessage());
            }
            try {
                Uri saveImagePath = getSaveImagePath(Base64.encodeToString(this.byteArray, 0), "image");
                contentResolver = getContext().getContentResolver();
                Cursor cursorQuery = contentResolver.query(saveImagePath, null, null, null, null);
                count = cursorQuery.getCount();
                try {
                    if (count <= 0) {
                        cursorQuery.close();
                        throw new IllegalArgumentException(CAN_T_OBTAIN_FILE_NAME_CURSOR_IS_EMPTY);
                    }
                    cursorQuery.moveToFirst();
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                    count = "_display_name";
                    try {
                        if (this.filesize < 1024) {
                            this.pseDetailsBinding.chooseFileName.setVisibility(0);
                            this.pseDetailsBinding.chooseFileNameSize.setVisibility(0);
                            this.pseDetailsBinding.chooseFileDeletion.setVisibility(0);
                            this.pseDetailsBinding.preview.setVisibility(0);
                            this.pseDetailsBinding.chooseFileName.setText(string);
                            this.pseDetailsBinding.chooseFile.setTextColor(Color.parseColor(BLACK_COLOR));
                            this.pseDetailsBinding.chooseFileNameSize.setText(this.filesize + "KB");
                            ImageView imageView = this.pseDetailsBinding.preview;
                            byte[] bArr = this.byteArray;
                            imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                        } else {
                            double dRound = Math.round(((double) ((float) (this.filesize / 1024.0d))) * 100.0d) / 100.0d;
                            if (dRound > 2.0d) {
                                this.pseDetailsBinding.preview.setVisibility(8);
                                this.pseDetailsBinding.chooseFileDeletion.setVisibility(8);
                                this.pseDetailsBinding.chooseFileNameSize.setVisibility(8);
                                this.pseDetailsBinding.chooseFileName.setVisibility(8);
                                showdialog("Alert", "Image size exceeded 2MB limit.");
                            } else {
                                this.pseDetailsBinding.chooseFileName.setVisibility(0);
                                this.pseDetailsBinding.chooseFileNameSize.setVisibility(0);
                                this.pseDetailsBinding.chooseFileDeletion.setVisibility(0);
                                this.pseDetailsBinding.preview.setVisibility(0);
                                this.pseDetailsBinding.chooseFileName.setText(string);
                                this.pseDetailsBinding.chooseFile.setTextColor(Color.parseColor(BLACK_COLOR));
                                this.pseDetailsBinding.chooseFileNameSize.setText(dRound + "MB");
                                ImageView imageView2 = this.pseDetailsBinding.preview;
                                byte[] bArr2 = this.byteArray;
                                imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                            }
                            RestClient restClient = (RestClient) ApiClient.getClient(getContext()).create(RestClient.class);
                            File file = new File(this.filepathimg + this.saveImageFileName);
                            restClient.faceRecognitionApi(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", this.blostatecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + this.saveImageFileName.substring(this.saveImageFileName.lastIndexOf(".")), MediaType.parse("fileType"))).enqueue(new AnonymousClass10());
                            r3 = count;
                            r28 = str;
                        }
                        RestClient restClient2 = (RestClient) ApiClient.getClient(getContext()).create(RestClient.class);
                        File file2 = new File(this.filepathimg + this.saveImageFileName);
                        restClient2.faceRecognitionApi(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", this.blostatecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file2.getName(), RequestBody.create(file2, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + this.saveImageFileName.substring(this.saveImageFileName.lastIndexOf(".")), MediaType.parse("fileType"))).enqueue(new AnonymousClass10());
                        r3 = count;
                        r28 = str;
                    } catch (Exception e2) {
                        e = e2;
                        contentResolver = "Image size exceeded 2MB limit.";
                        Logger.d(CONTENT, e.getMessage());
                        this.alertDialog.dismiss();
                        r3 = count;
                        r28 = contentResolver;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                contentResolver = "Image size exceeded 2MB limit.";
                count = "_display_name";
            }
            Logger.d(CONTENT, e.getMessage());
            this.alertDialog.dismiss();
            r3 = count;
            r28 = contentResolver;
        } else {
            r28 = "Image size exceeded 2MB limit.";
            r3 = "_display_name";
        }
        if (i != 102 || i2 != -1) {
            return;
        }
        try {
            Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData());
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            bitmap2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
            this.byteArray = byteArrayOutputStream2.toByteArray();
        } catch (IOException e5) {
            Logger.e("", e5.getMessage());
        }
        try {
            ?? Query = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(this.byteArray, 0), "image"), null, null, null, null);
            if (Query.getCount() <= 0) {
                Query.close();
                throw new IllegalArgumentException(CAN_T_OBTAIN_FILE_NAME_CURSOR_IS_EMPTY);
            }
            Query.moveToFirst();
            String string2 = Query.getString(Query.getColumnIndexOrThrow(r3));
            if (this.filesize < 1024) {
                this.pseDetailsBinding.chooseFileDeletion1.setVisibility(0);
                this.pseDetailsBinding.chooseFileName1.setVisibility(0);
                this.pseDetailsBinding.chooseFileNameSize1.setVisibility(0);
                this.pseDetailsBinding.preview1.setVisibility(0);
                this.pseDetailsBinding.chooseFile1.setTextColor(Color.parseColor(BLACK_COLOR));
                this.pseDetailsBinding.chooseFileName1.setText(string2);
                this.pseDetailsBinding.chooseFileNameSize1.setText(this.filesize + "KB");
                ImageView imageView3 = this.pseDetailsBinding.preview1;
                byte[] bArr3 = this.byteArray;
                imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
            } else {
                double dRound2 = Math.round(((double) ((float) (this.filesize / 1024.0d))) * 100.0d) / 100.0d;
                if (dRound2 > 2.0d) {
                    this.pseDetailsBinding.preview1.setVisibility(8);
                    this.pseDetailsBinding.chooseFileDeletion1.setVisibility(8);
                    this.pseDetailsBinding.chooseFileNameSize1.setVisibility(8);
                    this.pseDetailsBinding.chooseFileName1.setVisibility(8);
                    showdialog("Alert", r28);
                } else {
                    this.pseDetailsBinding.chooseFileDeletion1.setVisibility(0);
                    this.pseDetailsBinding.chooseFileName1.setVisibility(0);
                    this.pseDetailsBinding.chooseFileNameSize1.setVisibility(0);
                    this.pseDetailsBinding.preview1.setVisibility(0);
                    this.pseDetailsBinding.chooseFile1.setTextColor(Color.parseColor(BLACK_COLOR));
                    this.pseDetailsBinding.chooseFileName1.setText(string2);
                    this.pseDetailsBinding.chooseFileNameSize1.setText(dRound2 + "MB");
                    ImageView imageView4 = this.pseDetailsBinding.preview1;
                    byte[] bArr4 = this.byteArray;
                    imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                }
            }
            this.commonUtilClass.uploadToServer2(getContext(), this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, "FormatBImage", SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda11
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i3, String str2) {
                    this.f$0.lambda$onActivityResult$19(i3, str2);
                }
            });
            this.alertDialog.dismiss();
        } catch (Exception e6) {
            Logger.d(CONTENT, e6.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$10, reason: invalid class name */
    class AnonymousClass10 implements Callback<JsonObject> {
        AnonymousClass10() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 401) {
                ClusterNumberFragment.this.commonUtilClass.getRefreshToken(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$10$$ExternalSyntheticLambda2
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                ClusterNumberFragment.this.commonUtilClass.uploadToServer2(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.blostatecode, ClusterNumberFragment.this.bloassemcode, ClusterNumberFragment.this.blopartnumber, ClusterNumberFragment.this.filepathimg, ClusterNumberFragment.this.saveImageFileName, ClusterNumberFragment.this.token, "PSEForm8Image", SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$10$$ExternalSyntheticLambda3
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str) {
                        this.f$0.lambda$onResponse$5(i, str);
                    }
                });
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                ClusterNumberFragment.this.pseDetailsBinding.chooseFileName.setText("");
                ClusterNumberFragment.this.photoref = "";
                ClusterNumberFragment.this.pseDetailsBinding.preview.setImageDrawable(null);
                ClusterNumberFragment.this.pseDetailsBinding.chooseFileDeletion.setVisibility(8);
                ClusterNumberFragment.this.pseDetailsBinding.preview.setVisibility(8);
                ClusterNumberFragment.this.pseDetailsBinding.chooseFileNameSize.setVisibility(8);
                ClusterNumberFragment.this.pseDetailsBinding.chooseFileName.setVisibility(8);
                ClusterNumberFragment.this.pseDetailsBinding.chooseFile.setEnabled(true);
                ClusterNumberFragment.this.pseDetailsBinding.chooseFile.setTextColor(Color.parseColor("#000000"));
                ClusterNumberFragment.this.showdialog2("Alert", jSONObject.optString(ClusterNumberFragment.MESSAGE));
            } catch (IOException | JSONException e) {
                Logger.d("ClusterNumberFragment", e.toString());
            }
            ClusterNumberFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            ClusterNumberFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ClusterNumberFragment.this.commonUtilClass.showMessageOK(ClusterNumberFragment.this.requireContext(), ClusterNumberFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$10$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ClusterNumberFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setToken("Bearer " + str);
            ClusterNumberFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setLocaleBool(false);
            ClusterNumberFragment.this.startActivity(new Intent((Context) ClusterNumberFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$5(int i, String str) {
            if (i == 401) {
                ClusterNumberFragment.this.commonUtilClass.getRefreshToken(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$10$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$onResponse$4(i2, str2, str3);
                    }
                });
            } else {
                ClusterNumberFragment.this.photoref = str;
                ClusterNumberFragment.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4(int i, String str, String str2) {
            ClusterNumberFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ClusterNumberFragment.this.commonUtilClass.showMessageOK(ClusterNumberFragment.this.requireContext(), ClusterNumberFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$10$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$2(dialogInterface, i2);
                    }
                });
                return;
            }
            ClusterNumberFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setToken("Bearer " + str);
            ClusterNumberFragment.this.commonUtilClass.uploadToServer2(ClusterNumberFragment.this.getContext(), ClusterNumberFragment.this.stateCode, ClusterNumberFragment.this.asmblyNO, ClusterNumberFragment.this.partNo, ClusterNumberFragment.this.filepathimg, ClusterNumberFragment.this.saveImageFileName, ClusterNumberFragment.this.token, "PSEForm8Image", SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$10$$ExternalSyntheticLambda5
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i2, String str3) {
                    this.f$0.lambda$onResponse$3(i2, str3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ClusterNumberFragment.this.requireContext()).setLocaleBool(false);
            ClusterNumberFragment.this.startActivity(new Intent((Context) ClusterNumberFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(int i, String str) {
            ClusterNumberFragment.this.photoref = str;
            ClusterNumberFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Toast.makeText(ClusterNumberFragment.this.getContext(), t.getMessage(), 1).show();
            ClusterNumberFragment.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$19(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(getContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda0
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onActivityResult$18(i2, str2, str3);
                }
            });
        } else {
            this.passref = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$18(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(requireContext(), SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda10
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onActivityResult$16(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.uploadToServer2(getContext(), this.stateCode, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, "FormatBImage", SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda12
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$onActivityResult$17(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$16(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$17(int i, String str) {
        this.passref = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialogFinal(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda21
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog2(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog2$22(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog2$22(DialogInterface dialogInterface, int i) {
        openFragment(new PseFragment(), PSE_FRAGMENT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog3(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.ClusterNumberFragment$$ExternalSyntheticLambda22
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog3$23(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog3$23(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putString(CLUSTER_ID, this.clusterId);
        bundle.putString("Flag", this.flagValue);
        ClusterNumberFragment clusterNumberFragment = new ClusterNumberFragment();
        clusterNumberFragment.setArguments(bundle);
        openFragment(clusterNumberFragment, "cluster_details");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
