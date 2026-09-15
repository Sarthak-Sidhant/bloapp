package in.gov.eci.bloapp.views.fragments.pse;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.databinding.BloFragmentPseChecklistPreviewBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class PseChecklistPreviewFragment extends Fragment {
    private static final String ALERT = "Alert";
    private static final String APPLICATION_JSON = "application/json";
    private static final String ASSIGNED_BLO_ID = "assignedBloId";
    private static final String BLO_FIELD_REMARKS = "bloFieldRemarks";
    private static final String BLO_OUTPUT = "bloOutput";
    private static final String BLO_VERIFY_STATUS = "bloVerifyStatus";
    private static final String COMING_IN_ON_FAILURE = "coming in onFailure ";
    private static final String EPIC_NO = "epicNo";
    private static final String ISFORM_7_GEN = "isform7Gen";
    private static final String ISFORM_8_GEN = "isform8Gen";
    private static final String MESSAGE = "message";
    private static final String MESSAGE12 = "Message";
    private static final String PART_NO = "partNo";
    private static final String PSE_ID = "pseId";
    private static final String PSE_SUBMIT = "pse_submit";
    private static final String SESSION_TOKEN_EXPIRED_PLEASE_LOGIN = "Session token expired please Login";
    private static final String STATE_CD = "stateCd";
    private String address;
    private String age;
    private AlertDialog alertDialog;
    private String applicantName;
    String base64element;
    BloFragmentPseChecklistPreviewBinding binding;
    private String bloOutput;
    private String bloassemcode;
    private String blodistrictcode;
    private String blopartnumber;
    private String blostatecode;
    Retrofit.Builder builder;
    private String clusterId;
    CommomUtility commonUtilClass;
    private String dateofInclusion;
    private String epicNumber;
    private String flagValue;
    SimpleDateFormat format;
    private String formatARemark;
    private String gender;
    Gson gson;
    OkHttpClient okHttpClient;
    private String preferredUsername;
    private String previewFlag;
    private String pseid;
    private String refreshToken;
    private String relationName;
    private String relationType;
    private String remark;
    Retrofit retrofit;
    private String serialNo;
    String submitdate;
    private String token;
    private String photoReferenceNo = StringUtils.SPACE;
    private String photoFormatAReferenceNo = StringUtils.SPACE;
    Date subdate = new Date();

    public PseChecklistPreviewFragment() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.format = simpleDateFormat;
        this.submitdate = simpleDateFormat.format(this.subdate);
        this.commonUtilClass = new CommomUtility();
        this.okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2L, TimeUnit.MINUTES).readTimeout(2L, TimeUnit.MINUTES).build();
        this.gson = new GsonBuilder().setLenient().create();
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commonUtilClass.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentPseChecklistPreviewBinding.inflate(inflater);
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.blodistrictcode = SharedPref.getInstance(requireContext()).getDistrictCode();
        String stateName = SharedPref.getInstance(requireContext()).getStateName();
        String districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        this.bloassemcode = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.blostatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.blopartnumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.binding.stateET.setText(stateName);
        this.binding.districtET.setText(districtName);
        this.binding.constNO.setText(this.bloassemcode);
        this.binding.assemblyET.setText(stateName);
        this.binding.cb8.setEnabled(false);
        this.binding.COR.setEnabled(false);
        this.binding.SOR.setEnabled(false);
        this.binding.IOR.setEnabled(false);
        this.binding.ROM.setEnabled(false);
        this.binding.cb8.setChecked(true);
        this.binding.COR.setChecked(true);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.applicantName = arguments.getString("applicantName");
            this.epicNumber = arguments.getString("epicNumber");
            this.age = arguments.getString("age");
            this.gender = arguments.getString("gender");
            this.relationName = arguments.getString("relationName");
            this.relationType = arguments.getString("relationType");
            this.address = arguments.getString("address");
            this.dateofInclusion = arguments.getString("dateofInclusion");
            this.serialNo = arguments.getString("serialNo");
            this.formatARemark = arguments.getString("formatARemark");
            this.remark = arguments.getString("remark");
            this.photoReferenceNo = arguments.getString("photoReferenceNo");
            this.photoFormatAReferenceNo = arguments.getString("photoFormatAReferenceNo");
            this.pseid = arguments.getString("pseid");
            this.bloOutput = arguments.getString(BLO_OUTPUT);
            this.preferredUsername = arguments.getString("preferredUsername");
            this.clusterId = arguments.getString("clusterId");
            this.flagValue = arguments.getString("flagValue");
            this.previewFlag = arguments.getString("previewFlag");
        }
        this.binding.nameApplicantET.setText(this.applicantName);
        this.binding.epicNumberET.setText(this.epicNumber);
        this.binding.ageET.setText(this.age);
        this.binding.genderET.setText(this.gender);
        this.binding.relationNameET.setText(this.relationName);
        this.binding.relationTypeET.setText(this.relationType);
        this.binding.addressET.setText(this.address);
        this.binding.dateOfInclusionET.setText(this.dateofInclusion);
        this.binding.serialNoET.setText(this.serialNo);
        this.binding.responseFormatRemark.setText(this.formatARemark);
        this.binding.decDateET.setText(this.submitdate);
        this.binding.Remark.setText(this.remark);
        if (this.previewFlag.equals("2")) {
            this.binding.responseFormatAPhotoName.setVisibility(8);
            this.binding.responseFormatAPhoto.setVisibility(8);
            this.binding.responseFormatALabel.setVisibility(8);
            this.binding.serialNoET.setVisibility(8);
            this.binding.serialNoLabel.setVisibility(8);
            this.binding.ageET.setVisibility(8);
            this.binding.ageLabel.setVisibility(8);
            this.binding.responseFormatRemarkLabel.setVisibility(8);
            this.binding.responseFormatRemark.setVisibility(8);
            this.binding.RemarkLabel.setVisibility(8);
            this.binding.Remark.setVisibility(8);
        }
        String str = this.photoFormatAReferenceNo;
        if (str == null || str.equals(StringUtils.SPACE) || this.photoFormatAReferenceNo.equals("") || this.photoFormatAReferenceNo.equals("null")) {
            this.binding.responseFormatAPhotoName.setVisibility(8);
            this.binding.responseFormatAPhoto.setVisibility(8);
            this.binding.responseFormatALabel.setVisibility(8);
        } else {
            this.binding.responseFormatAPhotoName.setVisibility(0);
            this.binding.responseFormatAPhoto.setVisibility(0);
            this.binding.responseFormatALabel.setVisibility(0);
            this.binding.responseFormatAPhotoName.setText(this.photoFormatAReferenceNo);
            getFileCOR2(this.photoFormatAReferenceNo);
        }
        this.binding.chooseCorrectPhotoName.setText(this.photoReferenceNo);
        getFileCOR1(this.photoReferenceNo);
        this.binding.fillForm8btn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$4(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        if (getFragmentManager().getBackStackEntryCount() != 0) {
            getFragmentManager().popBackStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(View view) {
        if (this.previewFlag.equals("1")) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(requireContext());
            builder.setMessage("Do You want to Fill Form 8 ?");
            builder.setCancelable(true);
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onCreateView$2(dialogInterface, i);
                }
            });
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$$ExternalSyntheticLambda7
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onCreateView$3(dialogInterface, i);
                }
            });
            builder.show();
            return;
        }
        if (this.previewFlag.equals("2")) {
            this.alertDialog.show();
            ArrayList<HashMap> arrayList = new ArrayList<>();
            HashMap map = new HashMap();
            map.put(STATE_CD, this.blostatecode);
            map.put("acNo", this.bloassemcode);
            map.put(PART_NO, this.blopartnumber);
            map.put(EPIC_NO, this.epicNumber);
            map.put(PSE_ID, this.pseid);
            map.put("isPse", 1);
            map.put("currentRole", "blo");
            map.put("module", "PSE");
            map.put("partSerialNumber", this.serialNo);
            map.put("photograph", this.photoReferenceNo);
            arrayList.add(map);
            Logger.d("Form8Array", String.valueOf(arrayList));
            System.out.println("Form8Array" + arrayList);
            this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).pseForm8Submit(this.token, "blo", this.blostatecode, APPLICATION_JSON, "ANDROIDMOB", arrayList).enqueue(new AnonymousClass2());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(DialogInterface dialogInterface, int i) {
        pseSubmit(this.pseid, this.remark, this.bloOutput, "2", this.formatARemark);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(DialogInterface dialogInterface, int i) {
        this.alertDialog.show();
        ArrayList<HashMap> arrayList = new ArrayList<>();
        HashMap map = new HashMap();
        map.put(STATE_CD, this.blostatecode);
        map.put("acNo", this.bloassemcode);
        map.put(PART_NO, this.blopartnumber);
        map.put(EPIC_NO, this.epicNumber);
        map.put(PSE_ID, this.pseid);
        map.put("isPse", 1);
        map.put("partSerialNumber", this.serialNo);
        map.put("currentRole", "blo");
        map.put("module", "PSE");
        map.put("photograph", this.photoReferenceNo);
        arrayList.add(map);
        Logger.d("Form8Array", String.valueOf(arrayList));
        System.out.println("Form8Array" + arrayList);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).pseForm8Submit(this.token, "blo", this.blostatecode, APPLICATION_JSON, "ANDROIDMOB", arrayList).enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        AnonymousClass1() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.body() != null) {
                PseChecklistPreviewFragment pseChecklistPreviewFragment = PseChecklistPreviewFragment.this;
                pseChecklistPreviewFragment.pseSubmit(pseChecklistPreviewFragment.pseid, PseChecklistPreviewFragment.this.remark, PseChecklistPreviewFragment.this.bloOutput, "3", PseChecklistPreviewFragment.this.formatARemark);
                PseChecklistPreviewFragment.this.alertDialog.dismiss();
            } else {
                if (response.code() == 401) {
                    PseChecklistPreviewFragment.this.commonUtilClass.getRefreshToken(PseChecklistPreviewFragment.this.getContext(), PseChecklistPreviewFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$1$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str, String str2) {
                            this.f$0.lambda$onResponse$1(i, str, str2);
                        }
                    });
                    return;
                }
                Logger.d("erroeResponse", "null");
                PseChecklistPreviewFragment pseChecklistPreviewFragment2 = PseChecklistPreviewFragment.this;
                pseChecklistPreviewFragment2.pseSubmit(pseChecklistPreviewFragment2.pseid, PseChecklistPreviewFragment.this.remark, PseChecklistPreviewFragment.this.bloOutput, "2", PseChecklistPreviewFragment.this.formatARemark);
                try {
                    Logger.d("mesage---", String.valueOf(new JSONObject(response.errorBody().string()).get(PseChecklistPreviewFragment.MESSAGE)));
                } catch (IOException | JSONException e) {
                    Logger.d(PseChecklistPreviewFragment.PSE_SUBMIT, e.getMessage());
                }
                PseChecklistPreviewFragment.this.alertDialog.dismiss();
                PseChecklistPreviewFragment.this.showdialogFinal(PseChecklistPreviewFragment.MESSAGE12, "Null");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            PseChecklistPreviewFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                PseChecklistPreviewFragment.this.commonUtilClass.showMessageOK(PseChecklistPreviewFragment.this.requireContext(), PseChecklistPreviewFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PseChecklistPreviewFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setToken("Bearer " + str);
            PseChecklistPreviewFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setLocaleBool(false);
            PseChecklistPreviewFragment.this.startActivity(new Intent((Context) PseChecklistPreviewFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(PseChecklistPreviewFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        AnonymousClass2() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.body() != null) {
                JsonObject asJsonObject = ((JsonObject) response.body()).getAsJsonObject();
                Logger.d("response Body", String.valueOf(asJsonObject));
                System.out.println("response Body" + asJsonObject);
                PseChecklistPreviewFragment.this.alertDialog.dismiss();
                PseChecklistPreviewFragment.this.showdialog("Alert", "Form 8 Request Generated Successfully");
                PseChecklistPreviewFragment.this.openFragment(new PseForm8RequestFragment(), "PseForm8RequestFragment");
                return;
            }
            if (response.code() == 401) {
                PseChecklistPreviewFragment.this.commonUtilClass.getRefreshToken(PseChecklistPreviewFragment.this.getContext(), PseChecklistPreviewFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$2$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d("mesage---", String.valueOf(new JSONObject(response.errorBody().string()).get(PseChecklistPreviewFragment.MESSAGE)));
            } catch (IOException | JSONException e) {
                Logger.d(PseChecklistPreviewFragment.PSE_SUBMIT, e.getMessage());
            }
            PseChecklistPreviewFragment.this.alertDialog.dismiss();
            PseChecklistPreviewFragment.this.showdialog(PseChecklistPreviewFragment.MESSAGE12, "null");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            PseChecklistPreviewFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                PseChecklistPreviewFragment.this.commonUtilClass.showMessageOK(PseChecklistPreviewFragment.this.requireContext(), PseChecklistPreviewFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PseChecklistPreviewFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setToken("Bearer " + str);
            PseChecklistPreviewFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setLocaleBool(false);
            PseChecklistPreviewFragment.this.startActivity(new Intent((Context) PseChecklistPreviewFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(PseChecklistPreviewFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ String val$fileref;

        AnonymousClass3(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            JSONObject jSONObject;
            if (response.code() == 200) {
                PseChecklistPreviewFragment.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(PseChecklistPreviewFragment.this.base64element, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (PseChecklistPreviewFragment.this.base64element == null || PseChecklistPreviewFragment.this.base64element.equals("null") || PseChecklistPreviewFragment.this.base64element.equals("")) {
                    PseChecklistPreviewFragment.this.binding.previewPhoto.setImageResource(R.drawable.blo_dummy_image);
                    return;
                } else {
                    PseChecklistPreviewFragment.this.binding.previewPhoto.setImageBitmap(bitmapDecodeByteArray);
                    return;
                }
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = PseChecklistPreviewFragment.this.commonUtilClass;
                Context context = PseChecklistPreviewFragment.this.getContext();
                String str = PseChecklistPreviewFragment.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$3$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
            try {
                jSONObject = new JSONObject(response.errorBody().string());
            } catch (IOException | JSONException e) {
                Logger.d("Pse preview", e.getMessage());
                jSONObject = null;
            }
            try {
                Logger.d("errorResponse2", jSONObject.optString(PseChecklistPreviewFragment.MESSAGE));
            } catch (Exception e2) {
                Logger.d("Pse preview", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            PseChecklistPreviewFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                PseChecklistPreviewFragment.this.commonUtilClass.showMessageOK(PseChecklistPreviewFragment.this.requireContext(), PseChecklistPreviewFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PseChecklistPreviewFragment.this.token = "Bearer " + str2;
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setToken("Bearer " + str2);
            PseChecklistPreviewFragment.this.getFileCOR1(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setLocaleBool(false);
            PseChecklistPreviewFragment.this.startActivity(new Intent((Context) PseChecklistPreviewFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(PseChecklistPreviewFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public void getFileCOR1(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getFile("objectstorage", fileref, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass3(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ String val$fileref;

        AnonymousClass4(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            JSONObject jSONObject;
            if (response.code() == 200) {
                PseChecklistPreviewFragment.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(PseChecklistPreviewFragment.this.base64element, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (PseChecklistPreviewFragment.this.base64element == null || PseChecklistPreviewFragment.this.base64element.equals("null") || PseChecklistPreviewFragment.this.base64element.equals("")) {
                    PseChecklistPreviewFragment.this.binding.responseFormatAPhoto.setImageResource(R.drawable.blo_dummy_image);
                    return;
                } else {
                    PseChecklistPreviewFragment.this.binding.responseFormatAPhoto.setImageBitmap(bitmapDecodeByteArray);
                    return;
                }
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = PseChecklistPreviewFragment.this.commonUtilClass;
                Context context = PseChecklistPreviewFragment.this.getContext();
                String str = PseChecklistPreviewFragment.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$4$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
            try {
                jSONObject = new JSONObject(response.errorBody().string());
            } catch (IOException | JSONException e) {
                Logger.d("Pse preview", e.getMessage());
                jSONObject = null;
            }
            try {
                Logger.d("errorResponse2", jSONObject.optString(PseChecklistPreviewFragment.MESSAGE));
            } catch (Exception e2) {
                Logger.d("Pse preview", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            PseChecklistPreviewFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                PseChecklistPreviewFragment.this.commonUtilClass.showMessageOK(PseChecklistPreviewFragment.this.requireContext(), PseChecklistPreviewFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$4$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PseChecklistPreviewFragment.this.token = "Bearer " + str2;
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setToken("Bearer " + str2);
            PseChecklistPreviewFragment.this.getFileCOR2(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setLocaleBool(false);
            PseChecklistPreviewFragment.this.startActivity(new Intent((Context) PseChecklistPreviewFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(PseChecklistPreviewFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    public void getFileCOR2(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getFile("objectstorage", fileref, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass4(fileref));
    }

    public void pseSubmit(String pseId, String remark, String bloOutput, String submitFlag, String bloRemark) {
        String str = bloRemark;
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put("acNo", this.bloassemcode);
        map.put(PART_NO, this.blopartnumber);
        map.put("pseIds", pseId);
        map.put(ASSIGNED_BLO_ID, this.preferredUsername);
        map.put(BLO_FIELD_REMARKS, remark);
        map.put(BLO_VERIFY_STATUS, "Submitted by Blo GARUDA");
        map.put("lastUpdatedBy", "BLO");
        map.put(BLO_OUTPUT, bloOutput);
        map.put(ISFORM_8_GEN, Boolean.valueOf(submitFlag.equals("3")));
        map.put(ISFORM_7_GEN, Boolean.valueOf(submitFlag.equals("12")));
        map.put("formRefNo", null);
        map.put("formatB", this.photoFormatAReferenceNo.equals(StringUtils.SPACE) ? null : this.photoFormatAReferenceNo);
        if (str == null || str.equals("")) {
            str = null;
        }
        map.put("bloRemarks", str);
        JSONObject jSONObject = new JSONObject(map);
        Logger.d("HELLO NO", String.valueOf(jSONObject));
        System.out.println("fjkd" + jSONObject);
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).pseclusterSubmit(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.blostatecode, APPLICATION_JSON, "ANDROIDMOB", map).enqueue(new AnonymousClass5(submitFlag));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<EronetResponse> {
        final /* synthetic */ String val$submitFlag;

        AnonymousClass5(final String val$submitFlag) {
            this.val$submitFlag = val$submitFlag;
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.body() != null) {
                Logger.d("body response", ((EronetResponse) response.body()).getMessage());
                PseChecklistPreviewFragment.this.alertDialog.dismiss();
                if (this.val$submitFlag.equals("0") || this.val$submitFlag.equals("1") || this.val$submitFlag.equals("2") || this.val$submitFlag.equals("3") || this.val$submitFlag.equals("4") || this.val$submitFlag.equals("12")) {
                    PseChecklistPreviewFragment.this.showdialog("Alert", "Successfully Submitted");
                }
                Bundle bundle = new Bundle();
                bundle.putString("clusterId", PseChecklistPreviewFragment.this.clusterId);
                bundle.putString("Flag", PseChecklistPreviewFragment.this.flagValue);
                ClusterNumberFragment clusterNumberFragment = new ClusterNumberFragment();
                clusterNumberFragment.setArguments(bundle);
                PseChecklistPreviewFragment.this.openFragment(clusterNumberFragment, "cluster_numberFragment");
                return;
            }
            if (response.code() == 401) {
                PseChecklistPreviewFragment.this.commonUtilClass.getRefreshToken(PseChecklistPreviewFragment.this.getContext(), PseChecklistPreviewFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$5$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                Logger.d("errorResponse", String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(PseChecklistPreviewFragment.PSE_SUBMIT, e.getMessage());
            }
            PseChecklistPreviewFragment.this.alertDialog.dismiss();
            PseChecklistPreviewFragment.this.showdialogFinal(PseChecklistPreviewFragment.MESSAGE12, "Null");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            PseChecklistPreviewFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                PseChecklistPreviewFragment.this.commonUtilClass.showMessageOK(PseChecklistPreviewFragment.this.requireContext(), PseChecklistPreviewFragment.SESSION_TOKEN_EXPIRED_PLEASE_LOGIN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$5$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            PseChecklistPreviewFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setToken("Bearer " + str);
            PseChecklistPreviewFragment.this.showdialog3("Alert", "Page refreshed due to the token expiry.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(PseChecklistPreviewFragment.this.requireContext()).setLocaleBool(false);
            PseChecklistPreviewFragment.this.startActivity(new Intent((Context) PseChecklistPreviewFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d(PseChecklistPreviewFragment.COMING_IN_ON_FAILURE, t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialogFinal(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog3(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.pse.PseChecklistPreviewFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog3$7(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog3$7(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("applicantName", this.applicantName);
        bundle.putString("epicNumber", this.epicNumber);
        bundle.putString("age", this.age);
        bundle.putString("gender", this.gender);
        bundle.putString("relationName", this.relationName);
        bundle.putString("relationType", this.relationType);
        bundle.putString("address", this.address);
        bundle.putString("dateofInclusion", this.dateofInclusion);
        bundle.putString("serialNo", this.serialNo);
        bundle.putString("formatARemark", this.formatARemark);
        bundle.putString("remark", this.remark);
        bundle.putString("photoReferenceNo", this.photoReferenceNo);
        bundle.putString("photoFormatAReferenceNo", this.photoFormatAReferenceNo);
        bundle.putString("pseid", this.pseid);
        bundle.putString(BLO_OUTPUT, this.bloOutput);
        bundle.putString("preferredUsername", this.preferredUsername);
        bundle.putString("clusterId", this.clusterId);
        bundle.putString("flagValue", this.flagValue);
        bundle.putString("previewFlag", this.previewFlag);
        PseChecklistPreviewFragment pseChecklistPreviewFragment = new PseChecklistPreviewFragment();
        pseChecklistPreviewFragment.setArguments(bundle);
        openFragment(pseChecklistPreviewFragment, "PseChecklistPreviewFragment");
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
