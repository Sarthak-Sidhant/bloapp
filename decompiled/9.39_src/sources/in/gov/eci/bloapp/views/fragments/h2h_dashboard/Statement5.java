package in.gov.eci.bloapp.views.fragments.h2h_dashboard;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.databinding.BloFragmentStatement5Binding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.simple.JSONArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class Statement5 extends BaseFragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    int acIDnum;
    String age1819CountAC;
    String age1819CountDistrict;
    String age1819CountPart;
    String age2029CountAC;
    String age2029CountDistrict;
    String age2029CountPart;
    String age3039CountAC;
    String age3039CountDistrict;
    String age3039CountPart;
    String age4049CountAC;
    String age4049CountDistrict;
    String age4049CountPart;
    String age5059CountAC;
    String age5059CountDistrict;
    String age5059CountPart;
    String age6069CountAC;
    String age6069CountDistrict;
    String age6069CountPart;
    String age7079CountAC;
    String age7079CountDistrict;
    String age7079CountPart;
    String age80PlusCountAC;
    String age80PlusCountDistrict;
    String age80PlusCountPart;
    AlertDialog alertDialog;
    String asmblyNO;
    BloFragmentStatement5Binding binding;
    Retrofit.Builder builder;
    DisplayMetrics displayMetrics;
    int districtIDnum;
    String partNo;
    String refreshToken;
    Retrofit retrofit;
    String stateCode;
    int stateIDnum;
    String token;
    private String token22;
    int totalElectorsCountAC;
    int totalElectorsCountDistrict;
    int totalElectorsCountPART;
    int totalPopulationCountAC;
    int totalPopulationCountDistrict;
    String statement5Tag = "statement5";
    String applicationString = "application/json";
    String age11String = "age11";
    String age12String = "age12";
    String age10String = "age10";
    String alertString = "Alert";
    String somethingWrongString = "Something Went Wrong!";
    String onFailureString = "coming in onFailure else  ";
    String onFailure2tString = "coming in onFailure ";
    String sessionExpiredString = "Session Expired. Please Login again..";
    String fCountString = "fCount";
    String mCountString = "mCount";
    String loggerString = "hii i am payload";
    String[] stateID = new String[1];
    String[] districtID = new String[1];
    String[] acID = new String[1];
    String[] partNumbers = new String[1];
    String[] eType = new String[1];
    String stateIdString = "stateId";
    String districtIdString = "districtIds";
    String acNumbersString = "acNumbers";
    String groupByColumnString = "groupByColumn";
    String dvoterString = "dvoter";
    String overSeasString = "overSeas";
    String tillDateDttmString = "tillDateDttm";
    String eTypeString = "eType";
    String dateFormatString = "2100-01-01 23:59:59";
    Gson gson = new GsonBuilder().setLenient().create();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    CommomUtility commomUtility = new CommomUtility();

    public Statement5() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.displayMetrics = new DisplayMetrics();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        String districtCode = SharedPref.getInstance(requireContext()).getDistrictCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        String districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        String assemblyName = SharedPref.getInstance(requireContext()).getAssemblyName();
        String partName = SharedPref.getInstance(requireContext()).getPartName();
        String partNumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        this.token22 = this.token;
        Bundle arguments = getArguments();
        try {
            this.stateIDnum = Math.round(Float.parseFloat((String) Objects.requireNonNull(arguments.getString(this.stateIdString))));
            this.districtIDnum = Math.round(Float.parseFloat((String) Objects.requireNonNull(arguments.getString("districtId"))));
            this.acIDnum = Math.round(Float.parseFloat((String) Objects.requireNonNull(arguments.getString("acId"))));
            Logger.d(this.statement5Tag, "I am stateID" + this.stateIDnum);
            Logger.d(this.statement5Tag, "I am disid" + this.districtIDnum);
            Logger.d(this.statement5Tag, "I am acid" + this.acIDnum);
            this.stateID[0] = String.valueOf(this.stateIDnum);
            this.districtID[0] = String.valueOf(this.districtIDnum);
            this.acID[0] = String.valueOf(this.acIDnum);
            this.partNumbers[0] = String.valueOf(partNumber);
            this.eType[0] = String.valueOf(0);
            Logger.d(this.statement5Tag, "Hii i m state id " + this.stateIDnum);
            Logger.d(this.statement5Tag, "Hii i m district id " + this.districtIDnum);
            Logger.d(this.statement5Tag, "Hii i m ac id " + this.acIDnum);
            HashMap<String, Object> map = new HashMap<>();
            map.put("stateIds", this.stateID);
            map.put(this.districtIdString, this.districtID);
            map.put(this.groupByColumnString, "DISTRICT_NO");
            Logger.d(this.statement5Tag, "Hii i am data" + map);
            HashMap map2 = new HashMap();
            map2.put("stateIds", this.stateID);
            map2.put(this.districtIdString, this.districtID);
            map2.put(this.acNumbersString, this.acID);
            map2.put(this.groupByColumnString, "AC_ID");
            Logger.d(this.statement5Tag, "Hii i am District data" + map);
            Logger.d(this.statement5Tag, "Hii i am ac data" + map2);
            getPopulationDataCountDistrict(this.token22, map);
            getPopulationDataCountAC(this.token22, map2);
            HashMap map3 = new HashMap();
            map3.put(this.stateIdString, Integer.valueOf(this.stateIDnum));
            map3.put(this.districtIdString, this.districtID);
            map3.put(this.acNumbersString, this.acID);
            map3.put("partNumbers", this.partNumbers);
            map3.put(this.groupByColumnString, "PART_NUMBER");
            map3.put(this.dvoterString, 0);
            map3.put(this.overSeasString, 0);
            map3.put(this.tillDateDttmString, this.dateFormatString);
            map3.put(this.eTypeString, this.eType);
            Logger.d(this.statement5Tag, "Hii i am EROLL PART data" + map3);
            getErollDashBoardAllPart(this.token22, map3);
        } catch (Exception e) {
            Logger.d(Constants.HOME, Constants.HOME + e.getMessage());
            showdialog(this.alertString, this.somethingWrongString);
        }
        BloFragmentStatement5Binding bloFragmentStatement5BindingInflate = BloFragmentStatement5Binding.inflate(getLayoutInflater());
        this.binding = bloFragmentStatement5BindingInflate;
        bloFragmentStatement5BindingInflate.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5.1
            public void handleOnBackPressed() {
                Statement5.this.openFragment(new H2HDashboardFragment());
            }
        });
        this.binding.totatalNo2.setText("Part- " + partName + " (" + partNumber + ")");
        this.binding.VPo.setText("District- " + districtName + " (" + districtCode + ")");
        this.binding.totatalNo.setText("AC- " + assemblyName + " (" + this.asmblyNO + ")");
        this.binding.texiewConstitS1.setText("Summary of current Electoral Roll (" + new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()) + ")");
        this.binding.downloadBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$$ExternalSyntheticLambda5
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
        openFragment(new H2HDashboardFragment());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            getContext().getDisplay().getRealMetrics(this.displayMetrics);
        } else {
            requireActivity().getWindowManager().getDefaultDisplay().getMetrics(this.displayMetrics);
        }
        this.binding.getRoot().measure(View.MeasureSpec.makeMeasureSpec(this.displayMetrics.widthPixels, 1073741824), View.MeasureSpec.makeMeasureSpec(this.displayMetrics.heightPixels, 1073741824));
        AsyncTask.execute(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreateView$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3() {
        this.binding.getRoot().layout(0, 0, this.displayMetrics.widthPixels, this.displayMetrics.heightPixels);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.binding.getRoot().getMeasuredWidth(), this.binding.getRoot().getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.binding.getRoot().draw(new Canvas(bitmapCreateBitmap));
        Bitmap.createScaledBitmap(bitmapCreateBitmap, this.binding.getRoot().getMeasuredWidth(), this.binding.getRoot().getMeasuredHeight(), true);
        PdfDocument pdfDocument = new PdfDocument();
        PdfDocument.Page pageStartPage = pdfDocument.startPage(new PdfDocument.PageInfo.Builder(this.binding.getRoot().getMeasuredWidth(), this.binding.getRoot().getMeasuredHeight(), 1).create());
        pageStartPage.getCanvas().drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
        pdfDocument.finishPage(pageStartPage);
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS + "/BLOAPP"), "Statement5");
        if (!file.exists()) {
            file.mkdirs();
        }
        final File file2 = new File(file, "statement5.pdf");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
            try {
                pdfDocument.writeTo(fileOutputStream);
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            Logger.d(Constants.HOME, Constants.HOME + e.getMessage());
        }
        pdfDocument.close();
        final Uri uriForFile = FileProvider.getUriForFile(requireContext(), "in.gov.eci.bloapp.provider", file2);
        requireActivity().runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreateView$2(uriForFile, file2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(Uri uri, File file) {
        Logger.d("fileuri", "" + uri);
        Logger.d("filepath", file.getAbsolutePath());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(67108864);
        intent.setClipData(ClipData.newRawUri("", uri));
        intent.setDataAndType(uri, "application/pdf");
        intent.addFlags(3);
        startActivity(Intent.createChooser(intent, "Share File"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPopulationDataCountDistrict(String token, HashMap<String, Object> map) {
        Logger.d(this.statement5Tag, "in getPopulationGenderCount..............................");
        this.commomUtility.getRetrofitClient(getContext(), token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getPopulationGenderCount(token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.applicationString, "ANDROIDMOB", map).enqueue(new AnonymousClass2(map));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JSONArray> {
        final /* synthetic */ HashMap val$map;

        AnonymousClass2(final HashMap val$map) {
            this.val$map = val$map;
        }

        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            if (response.code() == 200) {
                Logger.d(Statement5.this.statement5Tag, "in getPopulationGenderCount 200..............................");
                try {
                    if (response.body() != null) {
                        Logger.d(Statement5.this.statement5Tag, Statement5.this.loggerString + response.body());
                        JSONArray jSONArray = (JSONArray) response.body();
                        for (int i = 0; i < jSONArray.size(); i++) {
                            JsonObject asJsonObject = Statement5.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                            Statement5 statement5 = Statement5.this;
                            statement5.totalPopulationCountDistrict = asJsonObject.get(statement5.fCountString).getAsInt() + asJsonObject.get(Statement5.this.mCountString).getAsInt();
                            Logger.d(Statement5.this.statement5Tag, "Hii i m totalPopulationCountDistrict" + Statement5.this.totalPopulationCountDistrict);
                        }
                    }
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
                HashMap map = new HashMap();
                map.put(Statement5.this.stateIdString, Integer.valueOf(Statement5.this.stateIDnum));
                map.put(Statement5.this.districtIdString, Statement5.this.districtID);
                map.put(Statement5.this.groupByColumnString, "DISTRICT_ID");
                map.put(Statement5.this.dvoterString, 0);
                map.put(Statement5.this.overSeasString, 0);
                map.put(Statement5.this.tillDateDttmString, Statement5.this.dateFormatString);
                map.put(Statement5.this.eTypeString, Statement5.this.eType);
                Logger.d(Statement5.this.statement5Tag, "Hii i am data" + map);
                Statement5 statement6 = Statement5.this;
                statement6.getErollDashBoardAllDistrict(statement6.token22, map);
                Statement5.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                Logger.d(Statement5.this.statement5Tag, "in getPopulationGenderCount.. 400............................");
                CommomUtility commomUtility = Statement5.this.commomUtility;
                Context contextRequireContext = Statement5.this.requireContext();
                String str = Statement5.this.refreshToken;
                final HashMap map2 = this.val$map;
                commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$2$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$onResponse$1(map2, i2, str2, str3);
                    }
                });
                return;
            }
            Logger.d(Statement5.this.statement5Tag, "in getPopulationGenderCount.  else.............................>>>>" + response.code());
            Logger.d(Statement5.this.statement5Tag, Statement5.this.onFailureString + response.code());
            Statement5 statement7 = Statement5.this;
            statement7.showdialog(statement7.alertString, Statement5.this.somethingWrongString + response.code());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(HashMap map, int i, String str, String str2) {
            Statement5.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                Statement5.this.commomUtility.showMessageOK(Statement5.this.getContext(), "Session Expired. Please Login again..", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Statement5.this.token22 = "Bearer " + str;
            SharedPref.getInstance(Statement5.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(Statement5.this.requireContext()).setToken("Bearer " + str);
            Toast.makeText(Statement5.this.requireContext(), "Token Refreshed", 1).show();
            Statement5 statement5 = Statement5.this;
            statement5.getPopulationDataCountDistrict(statement5.token22, map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Statement5.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Statement5.this.requireContext()).setLocaleBool(false);
            Statement5.this.startActivity(new Intent((Context) Statement5.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JSONArray> call, Throwable t) {
            Logger.d(Statement5.this.statement5Tag, Statement5.this.onFailure2tString + t.getMessage());
            Statement5.this.alertDialog.dismiss();
            Statement5 statement5 = Statement5.this;
            statement5.showdialog(statement5.alertString, Statement5.this.somethingWrongString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPopulationDataCountAC(String token, Map<String, Object> map) {
        Logger.d(this.statement5Tag, "in getPopulationGenderCount..............................");
        this.commomUtility.getRetrofitClient(getContext(), token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getPopulationGenderCount(token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.applicationString, "ANDROIDMOB", map).enqueue(new AnonymousClass3(map));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JSONArray> {
        final /* synthetic */ Map val$map;

        AnonymousClass3(final Map val$map) {
            this.val$map = val$map;
        }

        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            if (response.code() == 200) {
                try {
                    if (response.body() != null) {
                        Logger.d(Statement5.this.statement5Tag, Statement5.this.loggerString + response.body());
                        JSONArray jSONArray = (JSONArray) response.body();
                        for (int i = 0; i < jSONArray.size(); i++) {
                            JsonObject asJsonObject = Statement5.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                            Statement5 statement5 = Statement5.this;
                            statement5.totalPopulationCountAC = asJsonObject.get(statement5.fCountString).getAsInt() + asJsonObject.get(Statement5.this.mCountString).getAsInt();
                            Logger.d(Statement5.this.statement5Tag, "Hii i m totalPopulationCountAC" + Statement5.this.totalPopulationCountAC);
                        }
                    }
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
                Statement5.this.alertDialog.dismiss();
                HashMap map = new HashMap();
                map.put(Statement5.this.stateIdString, Integer.valueOf(Statement5.this.stateIDnum));
                map.put(Statement5.this.districtIdString, Statement5.this.districtID);
                map.put(Statement5.this.acNumbersString, Statement5.this.acID);
                map.put(Statement5.this.groupByColumnString, "ASSEMBLY_CONSTITUENCY_NUMBER");
                map.put(Statement5.this.dvoterString, 0);
                map.put(Statement5.this.overSeasString, 0);
                map.put(Statement5.this.tillDateDttmString, Statement5.this.dateFormatString);
                map.put(Statement5.this.eTypeString, Statement5.this.eType);
                Logger.d(Statement5.this.statement5Tag, "Hii i am asfhsj  >>" + map);
                Statement5 statement6 = Statement5.this;
                statement6.getErollDashBoardAllAC(statement6.token22, map);
                return;
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Statement5.this.commomUtility;
                Context context = Statement5.this.getContext();
                String str = Statement5.this.refreshToken;
                final Map map2 = this.val$map;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$3$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$onResponse$1(map2, i2, str2, str3);
                    }
                });
                return;
            }
            Logger.d(Statement5.this.statement5Tag, Statement5.this.onFailureString + response.code());
            Statement5 statement7 = Statement5.this;
            statement7.showdialog(statement7.alertString, Statement5.this.somethingWrongString + response.code());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(Map map, int i, String str, String str2) {
            Statement5.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                Statement5.this.commomUtility.showMessageOK(Statement5.this.getContext(), "Session Expired. Please Login again..", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Statement5.this.token22 = "Bearer " + str;
            SharedPref.getInstance(Statement5.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(Statement5.this.requireContext()).setToken("Bearer " + str);
            Statement5 statement5 = Statement5.this;
            statement5.getPopulationDataCountAC(statement5.token22, map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Statement5.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Statement5.this.requireContext()).setLocaleBool(false);
            Statement5.this.startActivity(new Intent((Context) Statement5.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JSONArray> call, Throwable t) {
            Logger.d(Statement5.this.statement5Tag, Statement5.this.onFailure2tString + t.getMessage());
            Statement5.this.alertDialog.dismiss();
            Statement5 statement5 = Statement5.this;
            statement5.showdialog(statement5.alertString, Statement5.this.somethingWrongString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getErollDashBoardAllDistrict(String token, Map<String, Object> map) {
        Logger.d(this.statement5Tag, "in getErollDashBoardAllDistrict..............................");
        this.commomUtility.getRetrofitClient(getContext(), token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getErollDashBoardAll(token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.applicationString, "ANDROIDMOB", map).enqueue(new AnonymousClass4(map));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JSONArray> {
        final /* synthetic */ Map val$map;

        AnonymousClass4(final Map val$map) {
            this.val$map = val$map;
        }

        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            if (response.code() == 200) {
                try {
                    if (response.body() != null) {
                        Logger.d(Statement5.this.statement5Tag, Statement5.this.loggerString + response.body());
                        JSONArray jSONArray = (JSONArray) response.body();
                        for (int i = 0; i < jSONArray.size(); i++) {
                            JsonObject asJsonObject = Statement5.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                            Statement5 statement5 = Statement5.this;
                            statement5.totalElectorsCountDistrict = asJsonObject.get(statement5.fCountString).getAsInt() + asJsonObject.get(Statement5.this.mCountString).getAsInt();
                            int asInt = (asJsonObject.get(Statement5.this.fCountString).getAsInt() * Constants.REQUEST_CODE_PERMISSIONS) / asJsonObject.get(Statement5.this.mCountString).getAsInt();
                            Logger.d(Statement5.this.statement5Tag, "Hii i am DistrictGenderRatio>>>>" + asInt);
                            Statement5.this.binding.male2.setText(String.valueOf(asInt));
                            Statement5.this.age1819CountDistrict = String.valueOf(asJsonObject.get("age1").getAsInt());
                            Statement5.this.age2029CountDistrict = String.valueOf(asJsonObject.get("age2").getAsInt());
                            Statement5.this.age3039CountDistrict = String.valueOf(asJsonObject.get("age3").getAsInt());
                            Statement5.this.age4049CountDistrict = String.valueOf(asJsonObject.get("age4").getAsInt());
                            Statement5.this.age5059CountDistrict = String.valueOf(asJsonObject.get("age5").getAsInt());
                            Statement5.this.age6069CountDistrict = String.valueOf(asJsonObject.get("age6").getAsInt());
                            Statement5.this.age7079CountDistrict = String.valueOf(asJsonObject.get("age7").getAsInt());
                            Statement5.this.age80PlusCountDistrict = String.valueOf(asJsonObject.get("age8").getAsInt() + asJsonObject.get("age9").getAsInt() + asJsonObject.get(Statement5.this.age10String).getAsInt() + asJsonObject.get(Statement5.this.age11String).getAsInt() + asJsonObject.get(Statement5.this.age12String).getAsInt());
                            Statement5.this.binding.dis1819.setText(Statement5.this.age1819CountDistrict);
                            Statement5.this.binding.dis2029.setText(Statement5.this.age2029CountDistrict);
                            Statement5.this.binding.dis3039.setText(Statement5.this.age3039CountDistrict);
                            Statement5.this.binding.dis4049.setText(Statement5.this.age4049CountDistrict);
                            Statement5.this.binding.dis5059.setText(Statement5.this.age5059CountDistrict);
                            Statement5.this.binding.dis6069.setText(Statement5.this.age6069CountDistrict);
                            Statement5.this.binding.dis7079.setText(Statement5.this.age7079CountDistrict);
                            Statement5.this.binding.dis80.setText(Statement5.this.age80PlusCountDistrict);
                        }
                        Statement5.this.binding.femal9e.setText(String.valueOf((Statement5.this.totalElectorsCountDistrict * Constants.REQUEST_CODE_PERMISSIONS) / Statement5.this.totalPopulationCountDistrict));
                    }
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
                Statement5.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Statement5.this.commomUtility;
                Context context = Statement5.this.getContext();
                String str = Statement5.this.refreshToken;
                final Map map = this.val$map;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$4$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$onResponse$1(map, i2, str2, str3);
                    }
                });
                return;
            }
            Logger.d(Statement5.this.statement5Tag, Statement5.this.onFailureString + response.code());
            Statement5 statement6 = Statement5.this;
            statement6.showdialog(statement6.alertString, "Something Went Wrong!   getErollDashBoardAllDistrict" + response.code());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(Map map, int i, String str, String str2) {
            Statement5.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                Statement5.this.commomUtility.showMessageOK(Statement5.this.getContext(), "Session Expired. Please Login again..", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$4$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Statement5.this.token22 = "Bearer " + str;
            SharedPref.getInstance(Statement5.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(Statement5.this.requireContext()).setToken("Bearer " + str);
            Statement5 statement5 = Statement5.this;
            statement5.getErollDashBoardAllDistrict(statement5.token22, map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Statement5.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Statement5.this.requireContext()).setLocaleBool(false);
            Statement5.this.startActivity(new Intent((Context) Statement5.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JSONArray> call, Throwable t) {
            Logger.d(Statement5.this.statement5Tag, Statement5.this.onFailure2tString + t.getMessage());
            Statement5.this.alertDialog.dismiss();
            Statement5 statement5 = Statement5.this;
            statement5.showdialog(statement5.alertString, Statement5.this.somethingWrongString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getErollDashBoardAllAC(String token, Map<String, Object> map) {
        Logger.d(this.statement5Tag, "in getErollDashBoardAllAC..............................");
        this.commomUtility.getRetrofitClient(getContext(), token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getErollDashBoardAll(token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.applicationString, "ANDROIDMOB", map).enqueue(new AnonymousClass5(map));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JSONArray> {
        final /* synthetic */ Map val$map;

        AnonymousClass5(final Map val$map) {
            this.val$map = val$map;
        }

        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            if (response.code() == 200) {
                try {
                    if (response.body() != null) {
                        Logger.d(Statement5.this.statement5Tag, Statement5.this.loggerString + response.body());
                        JSONArray jSONArray = (JSONArray) response.body();
                        for (int i = 0; i < jSONArray.size(); i++) {
                            JsonObject asJsonObject = Statement5.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                            Statement5 statement5 = Statement5.this;
                            statement5.totalElectorsCountAC = asJsonObject.get(statement5.fCountString).getAsInt() + asJsonObject.get(Statement5.this.mCountString).getAsInt();
                            int asInt = (asJsonObject.get(Statement5.this.fCountString).getAsInt() * Constants.REQUEST_CODE_PERMISSIONS) / asJsonObject.get(Statement5.this.mCountString).getAsInt();
                            Logger.d(Statement5.this.statement5Tag, "Hii i am acGenderRatio>>>>" + asInt);
                            Statement5.this.binding.male.setText(String.valueOf(asInt));
                            Statement5.this.age1819CountAC = String.valueOf(asJsonObject.get("age1").getAsInt());
                            Statement5.this.age2029CountAC = String.valueOf(asJsonObject.get("age2").getAsInt());
                            Statement5.this.age3039CountAC = String.valueOf(asJsonObject.get("age3").getAsInt());
                            Statement5.this.age4049CountAC = String.valueOf(asJsonObject.get("age4").getAsInt());
                            Statement5.this.age5059CountAC = String.valueOf(asJsonObject.get("age5").getAsInt());
                            Statement5.this.age6069CountAC = String.valueOf(asJsonObject.get("age6").getAsInt());
                            Statement5.this.age7079CountAC = String.valueOf(asJsonObject.get("age7").getAsInt());
                            Statement5.this.age80PlusCountAC = String.valueOf(asJsonObject.get("age8").getAsInt() + asJsonObject.get("age9").getAsInt() + asJsonObject.get(Statement5.this.age10String).getAsInt() + asJsonObject.get(Statement5.this.age11String).getAsInt() + asJsonObject.get(Statement5.this.age12String).getAsInt());
                            Statement5.this.binding.ac1819.setText(Statement5.this.age1819CountAC);
                            Statement5.this.binding.ac2029.setText(Statement5.this.age2029CountAC);
                            Statement5.this.binding.ac3039.setText(Statement5.this.age3039CountAC);
                            Statement5.this.binding.ac4049.setText(Statement5.this.age4049CountAC);
                            Statement5.this.binding.ac5059.setText(Statement5.this.age5059CountAC);
                            Statement5.this.binding.ac6069.setText(Statement5.this.age6069CountAC);
                            Statement5.this.binding.ac7079.setText(Statement5.this.age7079CountAC);
                            Statement5.this.binding.ac80.setText(Statement5.this.age80PlusCountAC);
                        }
                        Statement5.this.binding.female.setText(String.valueOf((Statement5.this.totalElectorsCountAC * Constants.REQUEST_CODE_PERMISSIONS) / Statement5.this.totalPopulationCountAC));
                    }
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
                Statement5.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Statement5.this.commomUtility;
                Context context = Statement5.this.getContext();
                String str = Statement5.this.refreshToken;
                final Map map = this.val$map;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$5$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$onResponse$1(map, i2, str2, str3);
                    }
                });
                return;
            }
            Logger.d(Statement5.this.statement5Tag, Statement5.this.onFailureString + response.code());
            Statement5 statement6 = Statement5.this;
            statement6.showdialog(statement6.alertString, Statement5.this.somethingWrongString + response.code());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(Map map, int i, String str, String str2) {
            Statement5.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                Statement5.this.commomUtility.showMessageOK(Statement5.this.getContext(), "Session Expired. Please Login again..", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$5$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Statement5.this.token22 = "Bearer " + str;
            SharedPref.getInstance(Statement5.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(Statement5.this.requireContext()).setToken("Bearer " + str);
            Statement5 statement5 = Statement5.this;
            statement5.getErollDashBoardAllAC(statement5.token22, map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Statement5.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Statement5.this.requireContext()).setLocaleBool(false);
            Statement5.this.startActivity(new Intent((Context) Statement5.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JSONArray> call, Throwable t) {
            Logger.d(Statement5.this.statement5Tag, Statement5.this.onFailure2tString + t.getMessage());
            Statement5.this.alertDialog.dismiss();
            Statement5 statement5 = Statement5.this;
            statement5.showdialog(statement5.alertString, Statement5.this.somethingWrongString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getErollDashBoardAllPart(String token, Map<String, Object> map) {
        Logger.d(this.statement5Tag, "in getErollDashBoardAllPart..............................");
        this.commomUtility.getRetrofitClient(getContext(), token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getErollDashBoardAll(token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.applicationString, "ANDROIDMOB", map).enqueue(new AnonymousClass6(map));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JSONArray> {
        final /* synthetic */ Map val$map;

        AnonymousClass6(final Map val$map) {
            this.val$map = val$map;
        }

        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            if (response.code() == 200) {
                try {
                    if (response.body() != null) {
                        Logger.d(Statement5.this.statement5Tag, Statement5.this.loggerString + response.body());
                        JSONArray jSONArray = (JSONArray) response.body();
                        for (int i = 0; i < jSONArray.size(); i++) {
                            JsonObject asJsonObject = Statement5.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                            Statement5 statement5 = Statement5.this;
                            statement5.totalElectorsCountPART = asJsonObject.get(statement5.fCountString).getAsInt() + asJsonObject.get(Statement5.this.mCountString).getAsInt();
                            int asInt = (asJsonObject.get(Statement5.this.fCountString).getAsInt() * Constants.REQUEST_CODE_PERMISSIONS) / asJsonObject.get(Statement5.this.mCountString).getAsInt();
                            Logger.d(Statement5.this.statement5Tag, "Hii i am PARTGenderRatio>>>>" + asInt);
                            Statement5.this.binding.male21.setText(String.valueOf(asInt));
                            Statement5.this.age1819CountPart = String.valueOf(asJsonObject.get("age1").getAsInt());
                            Statement5.this.age2029CountPart = String.valueOf(asJsonObject.get("age2").getAsInt());
                            Statement5.this.age3039CountPart = String.valueOf(asJsonObject.get("age3").getAsInt());
                            Statement5.this.age4049CountPart = String.valueOf(asJsonObject.get("age4").getAsInt());
                            Statement5.this.age5059CountPart = String.valueOf(asJsonObject.get("age5").getAsInt());
                            Statement5.this.age6069CountPart = String.valueOf(asJsonObject.get("age6").getAsInt());
                            Statement5.this.age7079CountPart = String.valueOf(asJsonObject.get("age7").getAsInt());
                            Statement5.this.age80PlusCountPart = String.valueOf(asJsonObject.get("age8").getAsInt() + asJsonObject.get("age9").getAsInt() + asJsonObject.get(Statement5.this.age10String).getAsInt() + asJsonObject.get(Statement5.this.age11String).getAsInt() + asJsonObject.get(Statement5.this.age12String).getAsInt());
                            Statement5.this.binding.part1819.setText(Statement5.this.age1819CountPart);
                            Statement5.this.binding.part2029.setText(Statement5.this.age2029CountPart);
                            Statement5.this.binding.part3039.setText(Statement5.this.age3039CountPart);
                            Statement5.this.binding.part4049.setText(Statement5.this.age4049CountPart);
                            Statement5.this.binding.part5059.setText(Statement5.this.age5059CountPart);
                            Statement5.this.binding.part6069.setText(Statement5.this.age6069CountPart);
                            Statement5.this.binding.part7079.setText(Statement5.this.age7079CountPart);
                            Statement5.this.binding.part80.setText(Statement5.this.age80PlusCountPart);
                        }
                    }
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
                Statement5.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Statement5.this.commomUtility;
                Context context = Statement5.this.getContext();
                String str = Statement5.this.refreshToken;
                final Map map = this.val$map;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$6$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$onResponse$1(map, i2, str2, str3);
                    }
                });
                return;
            }
            Logger.d(Statement5.this.statement5Tag, Statement5.this.onFailureString + response.code());
            Statement5 statement6 = Statement5.this;
            statement6.showdialog(statement6.alertString, Statement5.this.somethingWrongString + response.code());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(Map map, int i, String str, String str2) {
            Statement5.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                Statement5.this.commomUtility.showMessageOK(Statement5.this.getContext(), "Session Expired. Please Login again..", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$6$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Statement5.this.token22 = "Bearer " + str;
            SharedPref.getInstance(Statement5.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(Statement5.this.requireContext()).setToken("Bearer " + str);
            Statement5 statement5 = Statement5.this;
            statement5.getErollDashBoardAllPart(statement5.token22, map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Statement5.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Statement5.this.requireContext()).setLocaleBool(false);
            Statement5.this.startActivity(new Intent((Context) Statement5.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JSONArray> call, Throwable t) {
            Logger.d(Statement5.this.statement5Tag, Statement5.this.onFailure2tString + t.getMessage());
            Statement5.this.alertDialog.dismiss();
            Statement5 statement5 = Statement5.this;
            statement5.showdialog(statement5.alertString, Statement5.this.somethingWrongString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog(String title, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement5$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog$5(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog$5(DialogInterface dialogInterface, int i) {
        openFragment(new H2HDashboardFragment());
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
