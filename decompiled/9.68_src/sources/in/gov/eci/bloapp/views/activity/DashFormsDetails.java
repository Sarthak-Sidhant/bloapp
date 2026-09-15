package in.gov.eci.bloapp.views.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.customadapter.CustomSpinnerAdapter;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.databinding.BloActivityDashFormsDetailsBinding;
import in.gov.eci.bloapp.databinding.BloFragmentDashformsdetailsBinding;
import in.gov.eci.bloapp.model.app_model.DashFormsDetailsModel;
import in.gov.eci.bloapp.utils.DateStringConverter;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DashFormsDetails extends AppCompatActivity {
    private GenericRecyclerView adapter;
    AlertDialog alertDialog;
    String asmblyNO;
    String asmblyName;
    BloActivityDashFormsDetailsBinding binding;
    Retrofit.Builder builder;
    private String daysSelectedOption;
    String declForm6;
    String declForm6a;
    String dropdownFormTypeSelected;
    private String formTypeSelectedOption;
    LayoutInflater inflaterDayBeginProgress;
    String moreThan7Days;
    String partNo;
    JSONArray payloadFormData;
    String referenceNumber;
    String refreshToken;
    Retrofit retrofit;
    SimpleDateFormat sdf;
    String selectFormType;
    String stateCode;
    String token;
    Integer totalFormsCount;
    private List<DashFormsDetailsModel> verifiedList;
    CommomUtility commonUtilClass = new CommomUtility();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();

    public DashFormsDetails() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commonUtilClass.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.moreThan7Days = "N";
        this.declForm6 = "form6";
        this.declForm6a = "form6a";
        this.selectFormType = "Select Form Type";
        this.referenceNumber = "referenceNumber";
        this.dropdownFormTypeSelected = "form6";
        this.totalFormsCount = 0;
        this.payloadFormData = null;
        this.sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityDashFormsDetailsBinding bloActivityDashFormsDetailsBindingInflate = BloActivityDashFormsDetailsBinding.inflate(getLayoutInflater());
        this.binding = bloActivityDashFormsDetailsBindingInflate;
        setContentView(bloActivityDashFormsDetailsBindingInflate.getRoot());
        initClickListener();
        this.verifiedList = new ArrayList();
        this.token = SharedPref.getInstance(this).getToken();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        this.asmblyNO = SharedPref.getInstance(this).getAssemblyNumber();
        this.asmblyName = SharedPref.getInstance(this).getAssemblyName();
        this.partNo = SharedPref.getInstance(this).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        Logger.d("Home Token - ", this.token);
        Logger.d("Home asmblyNO - ", this.asmblyNO);
        Logger.d("Home asmblyName - ", this.asmblyName);
        Logger.d("Home_RefToken - ", this.refreshToken);
        Logger.d("Home stateCode - ", this.stateCode);
        Logger.d("Home partNo - ", this.partNo);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this);
        this.inflaterDayBeginProgress = layoutInflaterFrom;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        ArrayList arrayList = new ArrayList();
        arrayList.add("Select any Option");
        arrayList.add(getString(R.string.blo_Less_than_7_days));
        arrayList.add(getString(R.string.blo_more_than_7_days));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.selectFormType);
        arrayList2.add(getString(R.string.blo_form_6));
        arrayList2.add(getString(R.string.blo_form_6a));
        arrayList2.add(getString(R.string.blo_form_7));
        arrayList2.add(getString(R.string.blo_form_8));
        this.binding.totalCount.setText(getString(R.string.blo_total_count) + " : " + this.totalFormsCount);
        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        customSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.moreLessDaysSpinner.setAdapter((SpinnerAdapter) customSpinnerAdapter);
        this.binding.moreLessDaysSpinner.setSelection(0);
        CustomSpinnerAdapter customSpinnerAdapter2 = new CustomSpinnerAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList2);
        customSpinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.formsTypesSpinner.setAdapter((SpinnerAdapter) customSpinnerAdapter2);
        this.binding.formsTypesSpinner.setSelection(0);
        this.binding.moreLessDaysSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.DashFormsDetails.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DashFormsDetails.this.daysSelectedOption = String.valueOf(parent.getItemAtPosition(position));
                Logger.d("daysSelectedOption1 - ", DashFormsDetails.this.daysSelectedOption);
                Logger.d("daysSelectedOption2 - ", DashFormsDetails.this.daysSelectedOption);
                DashFormsDetails.this.binding.formsTypesSpinner.setSelection(0);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                Logger.d("daysSelectedOption3 - ", "Nothing Selected");
            }
        });
        this.binding.formsTypesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.DashFormsDetails.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DashFormsDetails.this.formTypeSelectedOption = String.valueOf(parent.getItemAtPosition(position));
                Logger.d("formTypeSelectedOption - ", DashFormsDetails.this.formTypeSelectedOption);
                if (DashFormsDetails.this.daysSelectedOption.equals("Select any Option")) {
                    Logger.d("daysSelectedOption - 0", DashFormsDetails.this.daysSelectedOption);
                    return;
                }
                if (DashFormsDetails.this.daysSelectedOption.equals("Less than 7 Days")) {
                    Logger.d("daysSelectedOption - 1", DashFormsDetails.this.daysSelectedOption);
                    DashFormsDetails.this.moreThan7Days = "N";
                    if (DashFormsDetails.this.formTypeSelectedOption.equals(DashFormsDetails.this.selectFormType)) {
                        Logger.d("formTypeSelectedOption - 0", DashFormsDetails.this.formTypeSelectedOption);
                        return;
                    }
                    if (DashFormsDetails.this.formTypeSelectedOption.equals("Form 6")) {
                        Logger.d("formTypeSelectedOption - 1", DashFormsDetails.this.formTypeSelectedOption);
                        DashFormsDetails dashFormsDetails = DashFormsDetails.this;
                        dashFormsDetails.dropdownFormTypeSelected = dashFormsDetails.declForm6;
                        DashFormsDetails.this.initiateAPICall();
                        return;
                    }
                    if (DashFormsDetails.this.formTypeSelectedOption.equals("Form 6A")) {
                        Logger.d("formTypeSelectedOption - 2", DashFormsDetails.this.formTypeSelectedOption);
                        DashFormsDetails dashFormsDetails2 = DashFormsDetails.this;
                        dashFormsDetails2.dropdownFormTypeSelected = dashFormsDetails2.declForm6a;
                        DashFormsDetails.this.initiateAPICall();
                        return;
                    }
                    if (DashFormsDetails.this.formTypeSelectedOption.equals("Form 7")) {
                        Logger.d("formTypeSelectedOption - 4", DashFormsDetails.this.formTypeSelectedOption);
                        DashFormsDetails.this.dropdownFormTypeSelected = "form7";
                        DashFormsDetails.this.initiateAPICall();
                        return;
                    } else {
                        if (DashFormsDetails.this.formTypeSelectedOption.equals("Form 8")) {
                            Logger.d("formTypeSelectedOption - 5", DashFormsDetails.this.formTypeSelectedOption);
                            DashFormsDetails.this.dropdownFormTypeSelected = "form8";
                            DashFormsDetails.this.initiateAPICall();
                            return;
                        }
                        return;
                    }
                }
                if (DashFormsDetails.this.daysSelectedOption.equals("More than 7 Days")) {
                    Logger.d("daysSelectedOption - 2", DashFormsDetails.this.daysSelectedOption);
                    DashFormsDetails.this.moreThan7Days = "Y";
                    if (DashFormsDetails.this.formTypeSelectedOption.equals(DashFormsDetails.this.selectFormType)) {
                        Logger.d("formTypeSelectedOption - 0", DashFormsDetails.this.formTypeSelectedOption);
                        return;
                    }
                    if (DashFormsDetails.this.formTypeSelectedOption.equals("Form 6")) {
                        Logger.d("formTypeSelectedOption - 1", DashFormsDetails.this.formTypeSelectedOption);
                        DashFormsDetails dashFormsDetails3 = DashFormsDetails.this;
                        dashFormsDetails3.dropdownFormTypeSelected = dashFormsDetails3.declForm6;
                        DashFormsDetails.this.initiateAPICall();
                        return;
                    }
                    if (DashFormsDetails.this.formTypeSelectedOption.equals("Form 6A")) {
                        Logger.d("formTypeSelectedOption - 2", DashFormsDetails.this.formTypeSelectedOption);
                        DashFormsDetails dashFormsDetails4 = DashFormsDetails.this;
                        dashFormsDetails4.dropdownFormTypeSelected = dashFormsDetails4.declForm6a;
                        DashFormsDetails.this.initiateAPICall();
                        return;
                    }
                    if (DashFormsDetails.this.formTypeSelectedOption.equals("Form 7")) {
                        Logger.d("formTypeSelectedOption - 4", DashFormsDetails.this.formTypeSelectedOption);
                        DashFormsDetails.this.dropdownFormTypeSelected = "form7";
                        DashFormsDetails.this.initiateAPICall();
                    } else if (DashFormsDetails.this.formTypeSelectedOption.equals("Form 8")) {
                        Logger.d("formTypeSelectedOption - 5", DashFormsDetails.this.formTypeSelectedOption);
                        DashFormsDetails.this.dropdownFormTypeSelected = "form8";
                        DashFormsDetails.this.initiateAPICall();
                    }
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                Logger.d("", "Nothing Selected");
            }
        });
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.DashFormsDetails$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.DashFormsDetails$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) DashboardBLOActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$1(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) MainActivity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initiateAPICall() {
        Logger.d("DashFormDetails", "In initiateAPICall()");
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put("stateCd", this.stateCode);
        map.put("acNo", this.asmblyNO);
        map.put("partNo", this.partNo);
        map.put("formType", this.dropdownFormTypeSelected);
        map.put("moreThan7Days", this.moreThan7Days);
        this.commonUtilClass.getRetrofitClient(this, this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd()).getDashFormDetails(this.token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), "BLOAPP", "blo", this.stateCode, "application/json", "ANDROIDMOB", map).enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.DashFormsDetails$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<EronetResponse> {
        AnonymousClass3() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200 && response.body() != null) {
                try {
                    DashFormsDetails.this.payloadFormData = ((EronetResponse) response.body()).getPayload();
                    if (!DashFormsDetails.this.payloadFormData.isEmpty()) {
                        JsonObject asJsonObject = DashFormsDetails.this.gson.toJsonTree((LinkedTreeMap) DashFormsDetails.this.payloadFormData.get(0)).getAsJsonObject();
                        Logger.d(DashFormsDetails.this.referenceNumber, String.valueOf(asJsonObject.get(DashFormsDetails.this.referenceNumber)));
                        Logger.d("initiateAPICall json: ", String.valueOf(asJsonObject));
                        Logger.d("initiateAPICall payload: ", String.valueOf(DashFormsDetails.this.payloadFormData));
                        DashFormsDetails dashFormsDetails = DashFormsDetails.this;
                        dashFormsDetails.totalFormsCount = Integer.valueOf(dashFormsDetails.payloadFormData.size());
                        DashFormsDetails.this.binding.totalCount.setText(DashFormsDetails.this.getString(R.string.blo_total_count) + " : " + DashFormsDetails.this.totalFormsCount);
                        DashFormsDetails dashFormsDetails2 = DashFormsDetails.this;
                        dashFormsDetails2.renderingData(dashFormsDetails2.payloadFormData);
                    } else {
                        DashFormsDetails.this.verifiedList.clear();
                        DashFormsDetails.this.totalFormsCount = 0;
                        DashFormsDetails.this.binding.totalCount.setText(DashFormsDetails.this.getString(R.string.blo_total_count) + " : " + DashFormsDetails.this.totalFormsCount);
                        DashFormsDetails.this.alertDialog.dismiss();
                        DashFormsDetails.this.renderingData(new JSONArray());
                        DashFormsDetails.this.showdialog1("Error", "No Data Found");
                    }
                    Logger.d("In DashFormDetails() ", " payload - " + DashFormsDetails.this.payloadFormData);
                    return;
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                    DashFormsDetails.this.alertDialog.dismiss();
                    Toast.makeText(DashFormsDetails.this.getApplicationContext(), "API Failure Catch - Data not updated", 0);
                    return;
                }
            }
            if (response.code() == 401) {
                try {
                    Logger.d("jsonObject", String.valueOf(new JSONObject(response.errorBody().string())));
                } catch (IOException | JSONException e2) {
                    Logger.d("", e2.getMessage());
                }
                DashFormsDetails.this.commonUtilClass.getRefreshToken(DashFormsDetails.this.getApplicationContext(), DashFormsDetails.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.DashFormsDetails$3$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            DashFormsDetails.this.verifiedList.clear();
            DashFormsDetails.this.totalFormsCount = 0;
            DashFormsDetails.this.binding.totalCount.setText(DashFormsDetails.this.getString(R.string.blo_total_count) + " : " + DashFormsDetails.this.totalFormsCount);
            DashFormsDetails.this.alertDialog.dismiss();
            DashFormsDetails.this.renderingData(new JSONArray());
            try {
                Logger.d("jsonObject", String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e3) {
                Logger.d("", e3.getMessage());
            }
            Logger.d("", "API Failure else - Data not updated DashFormDetails()");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            DashFormsDetails.this.alertDialog.dismiss();
            Logger.d("initiateAPICall  ", i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                Toast.makeText(DashFormsDetails.this.getApplicationContext(), "API Failure else - Data not updated", 0);
                DashFormsDetails.this.commonUtilClass.showMessageOK(DashFormsDetails.this, "Session Expired. Please Login again..", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.DashFormsDetails$3$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            DashFormsDetails.this.token = "Bearer " + str;
            SharedPref.getInstance(DashFormsDetails.this.getApplicationContext()).setRefreshToken(str2);
            SharedPref.getInstance(DashFormsDetails.this.getApplicationContext()).setToken("Bearer " + str);
            DashFormsDetails.this.initiateAPICall();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(DashFormsDetails.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(DashFormsDetails.this.getApplicationContext()).setLocaleBool(false);
            DashFormsDetails.this.startActivity(new Intent(DashFormsDetails.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Logger.d("coming in onFailure ", t.getMessage());
            DashFormsDetails.this.alertDialog.dismiss();
            Toast.makeText(DashFormsDetails.this.getApplicationContext(), "API Failure - Data not updated", 0).show();
        }
    }

    public void renderingData(JSONArray formsList) {
        this.verifiedList.clear();
        try {
            Logger.d("in reading...........................", String.valueOf(formsList));
            for (int i = 0; i < formsList.size(); i++) {
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) formsList.get(i);
                String str = (String) linkedTreeMap.get("formType");
                String str2 = (String) linkedTreeMap.get(this.referenceNumber);
                String str3 = (String) linkedTreeMap.get("currentStatus");
                String str4 = (String) linkedTreeMap.get("lastModifiedDate");
                String ddMmYy = "";
                if (!str4.equals("null")) {
                    this.sdf.parse(str4);
                    ddMmYy = DateStringConverter.toDdMmYy(str4);
                }
                this.verifiedList.add(new DashFormsDetailsModel(str, str2, str3, ddMmYy));
            }
            initRecyclerViewAdapter();
            this.binding.formDataListRv.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1, 1, false));
            this.binding.formDataListRv.setAdapter(this.adapter);
        } catch (Exception e) {
            Logger.d("formDataListRv", e.getMessage());
            Logger.d("error", "Failed to read");
        }
    }

    private String getDisplayDate(Date submitDate) {
        SimpleDateFormat simpleDateFormat;
        String str = new SimpleDateFormat("d").format(submitDate);
        if (str.endsWith("1") && !str.endsWith("11")) {
            simpleDateFormat = new SimpleDateFormat("d'st' MMM yyyy");
        } else if (str.endsWith("2") && !str.endsWith("12")) {
            simpleDateFormat = new SimpleDateFormat("d'nd' MMM yyyy");
        } else if (str.endsWith("3") && !str.endsWith("13")) {
            simpleDateFormat = new SimpleDateFormat("d'rd' MMM yyyy");
        } else {
            simpleDateFormat = new SimpleDateFormat("d'th' MMM yyyy");
        }
        return simpleDateFormat.format(submitDate);
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new GenericRecyclerView.GenericRecyclerViewInterface() { // from class: in.gov.eci.bloapp.views.activity.DashFormsDetails.4
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(BloFragmentDashformsdetailsBinding.inflate(DashFormsDetails.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                ((BloFragmentDashformsdetailsBinding) holder.binding).serialNoTv.setText("S. No. " + (position + 1));
                ((BloFragmentDashformsdetailsBinding) holder.binding).formTv.setText(((DashFormsDetailsModel) DashFormsDetails.this.verifiedList.get(position)).getFormType());
                ((BloFragmentDashformsdetailsBinding) holder.binding).refNoTv2.setText(((DashFormsDetailsModel) DashFormsDetails.this.verifiedList.get(position)).getReferenceNo());
                ((BloFragmentDashformsdetailsBinding) holder.binding).currentStatusTv.setText(((DashFormsDetailsModel) DashFormsDetails.this.verifiedList.get(position)).getCurrentStatus());
                ((BloFragmentDashformsdetailsBinding) holder.binding).dateTv.setText(((DashFormsDetailsModel) DashFormsDetails.this.verifiedList.get(position)).getLastModifiedDate());
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemCount() {
                return DashFormsDetails.this.verifiedList.size();
            }
        });
        this.binding.formDataListRv.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1, 1, false));
        this.binding.formDataListRv.setAdapter(this.adapter);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.DashFormsDetails$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initRecyclerViewAdapter$2();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initRecyclerViewAdapter$2() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog1(String title, String msg) {
        new android.app.AlertDialog.Builder(getApplicationContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.DashFormsDetails$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
