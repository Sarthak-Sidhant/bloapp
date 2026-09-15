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
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.yalantis.ucrop.view.CropImageView;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.databinding.BloFragmentStatement1Binding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
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

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class Statement1 extends BaseFragment {
    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    String acId;
    private String age1819Count;
    private String age2029Count;
    private String age3039Count;
    private String age4049Count;
    private String age5059Count;
    private String age6069Count;
    private String age7079Count;
    private String age80PlusCount;
    private AlertDialog alertDialog1;
    BloFragmentStatement1Binding binding;
    String bloPartNumber;
    String bloStatecode;
    String bloassemcode;
    Retrofit.Builder builder;
    DisplayMetrics displayMetrics;
    ArrayList<String> district;
    String error;
    private String female;
    private String genderRatio;
    private String male;
    private String partNo;
    private JSONArray payloadData1;
    private String refreshToken;
    Retrofit retrofit;
    String session;
    String stateID;
    private String thirdGender;
    private String totalCount;
    CommomUtility commonUtilClass = new CommomUtility();
    String token = "";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    public Statement1() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.bloPartNumber = "";
        this.bloStatecode = "";
        this.bloassemcode = "";
        this.district = new ArrayList<>();
        this.stateID = "";
        this.acId = "";
        this.session = "Session Expired. Please Login again.";
        this.error = "Error";
        this.displayMetrics = new DisplayMetrics();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentStatement1Binding.inflate(getLayoutInflater());
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog1 = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog1.setCancelable(false);
        this.alertDialog1.setView(viewInflate);
        this.bloassemcode = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.bloStatecode = SharedPref.getInstance(requireContext()).getStateCode();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        String partName = SharedPref.getInstance(requireContext()).getPartName();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.bloPartNumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        this.binding.textViewCons.setText(this.partNo + " | " + partName);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.stateID = arguments.getString("stateId");
            this.acId = arguments.getString("acId");
            this.district.add(arguments.getString("districtId"));
        }
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement1$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement1$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement1.1
            public void handleOnBackPressed() {
                Statement1.this.openFragment(new H2HDashboardFragment());
            }
        });
        this.binding.downloadBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement1$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$4(view);
            }
        });
        partElectorCount();
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
        AsyncTask.execute(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement1$$ExternalSyntheticLambda5
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
        pageStartPage.getCanvas().drawBitmap(bitmapCreateBitmap, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (Paint) null);
        pdfDocument.finishPage(pageStartPage);
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS + "/BLOAPP"), "Statement1");
        if (!file.exists()) {
            file.mkdirs();
        }
        final File file2 = new File(file, "statement1.pdf");
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
        requireActivity().runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement1$$ExternalSyntheticLambda1
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
    public void showdialog(String title, String msg) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement1$$ExternalSyntheticLambda0
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

    public void partElectorCount() {
        this.alertDialog1.show();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.acId);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.partNo);
        HashMap map = new HashMap();
        map.put("stateId", this.stateID);
        map.put("districtIds", this.district);
        map.put("acNumbers", arrayList);
        map.put("partNumbers", arrayList2);
        map.put("groupByColumn", "PART_NUMBER");
        map.put("dvoter", 0);
        map.put("overSeas", 0);
        map.put("year", "_2023");
        this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).getPartElectorCount(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.bloStatecode, "application/json", "application/json, text/plain, */*", "keep-alive", "ANDROIDMOB", map).enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement1$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JSONArray> {
        AnonymousClass2() {
        }

        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            Statement1.this.showProgressInVisible();
            if (response.code() == 401) {
                Statement1.this.commonUtilClass.getRefreshToken(Statement1.this.requireContext(), Statement1.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement1$2$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                Statement1.this.showProgressInVisible();
                Statement1.this.showProgressInVisible();
                if (response.body() != null) {
                    Statement1.this.payloadData1 = (JSONArray) response.body();
                    if (!Statement1.this.payloadData1.isEmpty()) {
                        JsonObject asJsonObject = Statement1.this.gson.toJsonTree(Statement1.this.payloadData1.get(0)).getAsJsonObject();
                        Statement1.this.male = String.valueOf(asJsonObject.get("mCount"));
                        int iIntValue = Double.valueOf(Double.parseDouble(Statement1.this.male)).intValue();
                        Statement1.this.female = String.valueOf(asJsonObject.get("fCount"));
                        int iIntValue2 = Double.valueOf(Double.parseDouble(Statement1.this.female)).intValue();
                        Statement1.this.thirdGender = String.valueOf(asJsonObject.get("trCount"));
                        int iIntValue3 = Double.valueOf(Double.parseDouble(Statement1.this.thirdGender)).intValue();
                        Statement1.this.totalCount = String.valueOf(asJsonObject.get("erollCount"));
                        int iIntValue4 = Double.valueOf(Double.parseDouble(Statement1.this.totalCount)).intValue();
                        Statement1.this.binding.genderRatio.setText(String.valueOf(iIntValue4));
                        float f = iIntValue4;
                        Statement1.this.binding.male.setText(iIntValue + " (" + Statement1.decfor.format((iIntValue / f) * 100.0f) + "%)");
                        Statement1.this.binding.female.setText(iIntValue2 + " (" + Statement1.decfor.format((iIntValue2 / f) * 100.0f) + "%)");
                        Statement1.this.binding.thirdGender.setText(iIntValue3 + " (" + Statement1.decfor.format((iIntValue3 / f) * 100.0f) + "%)");
                        Statement1.this.genderRatio = String.valueOf((iIntValue2 * 1000) / iIntValue);
                        Statement1.this.binding.thirdgenratio.setText(Statement1.this.genderRatio);
                        Statement1.this.age1819Count = String.valueOf(asJsonObject.get("age1").getAsInt());
                        Statement1.this.age2029Count = String.valueOf(asJsonObject.get("age2").getAsInt());
                        Statement1.this.age3039Count = String.valueOf(asJsonObject.get("age3").getAsInt());
                        Statement1.this.age4049Count = String.valueOf(asJsonObject.get("age4").getAsInt());
                        Statement1.this.age5059Count = String.valueOf(asJsonObject.get("age5").getAsInt());
                        Statement1.this.age6069Count = String.valueOf(asJsonObject.get("age6").getAsInt());
                        Statement1.this.age7079Count = String.valueOf(asJsonObject.get("age7").getAsInt());
                        Statement1.this.age80PlusCount = String.valueOf(asJsonObject.get("age8").getAsInt() + asJsonObject.get("age9").getAsInt() + asJsonObject.get("age10").getAsInt() + asJsonObject.get("age11").getAsInt() + asJsonObject.get("age12").getAsInt());
                        try {
                            if (Statement1.this.age1819Count.equals("null") || Statement1.this.age1819Count == null) {
                                Statement1.this.binding.age18.setText("NA");
                            } else {
                                Statement1.this.binding.age18.setText(Statement1.this.age1819Count);
                            }
                            if (Statement1.this.age2029Count.equals("null") || Statement1.this.age2029Count == null) {
                                Statement1.this.binding.age2029.setText("NA");
                            } else {
                                Statement1.this.binding.age2029.setText(Statement1.this.age2029Count);
                            }
                            if (Statement1.this.age3039Count.equals("null") || Statement1.this.age3039Count == null) {
                                Statement1.this.binding.t39.setText("NA");
                            } else {
                                Statement1.this.binding.t39.setText(Statement1.this.age3039Count);
                            }
                            if (Statement1.this.age4049Count.equals("null") || Statement1.this.age4049Count == null) {
                                Statement1.this.binding.age4049.setText("NA");
                            } else {
                                Statement1.this.binding.age4049.setText(Statement1.this.age4049Count);
                            }
                            if (Statement1.this.age5059Count.equals("null") || Statement1.this.age5059Count == null) {
                                Statement1.this.binding.age59.setText("NA");
                            } else {
                                Statement1.this.binding.age59.setText(Statement1.this.age5059Count);
                            }
                            if (Statement1.this.age6069Count.equals("null") || Statement1.this.age6069Count == null) {
                                Statement1.this.binding.age60.setText("NA");
                            } else {
                                Statement1.this.binding.age60.setText(Statement1.this.age6069Count);
                            }
                            if (Statement1.this.age7079Count.equals("null") || Statement1.this.age7079Count == null) {
                                Statement1.this.binding.age79.setText("NA");
                            } else {
                                Statement1.this.binding.age79.setText(Statement1.this.age7079Count);
                            }
                            if (Statement1.this.age80PlusCount.equals("null") || Statement1.this.age80PlusCount == null) {
                                Statement1.this.binding.age0.setText("NA");
                            } else {
                                Statement1.this.binding.age0.setText(Statement1.this.age80PlusCount);
                            }
                        } catch (Exception e) {
                            Logger.d("", e.getMessage());
                        }
                        Statement1.this.alertDialog1.dismiss();
                    } else {
                        Statement1 statement1 = Statement1.this;
                        statement1.showdialog(statement1.error, "No Data Found.");
                        Statement1.this.alertDialog1.dismiss();
                    }
                    Statement1.this.alertDialog1.dismiss();
                    return;
                }
                Statement1 statement2 = Statement1.this;
                statement2.showdialog(statement2.error, "No Data Found.");
                Statement1.this.alertDialog1.dismiss();
                return;
            }
            try {
                new JSONObject(response.errorBody().string());
                if (response.code() == 401) {
                    Statement1.this.commonUtilClass.getRefreshToken(Statement1.this.requireContext(), Statement1.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement1$2$$ExternalSyntheticLambda2
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str, String str2) {
                            this.f$0.lambda$onResponse$3(i, str, str2);
                        }
                    });
                }
            } catch (IOException | JSONException e2) {
                Logger.d("All houses", e2.getMessage());
                if (response.code() == 401) {
                    Statement1.this.commonUtilClass.getRefreshToken(Statement1.this.requireContext(), Statement1.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement1$2$$ExternalSyntheticLambda3
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str, String str2) {
                            this.f$0.lambda$onResponse$5(i, str, str2);
                        }
                    });
                }
                Statement1.this.alertDialog1.dismiss();
            }
            Statement1.this.alertDialog1.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                Statement1.this.commonUtilClass.showMessageOK(Statement1.this.getContext(), Statement1.this.session, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement1$2$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Statement1.this.token = "Bearer " + str;
            Statement1.this.refreshToken = str2;
            SharedPref.getInstance(Statement1.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(Statement1.this.requireContext()).setToken("Bearer " + str);
            Statement1.this.partElectorCount();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Statement1.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Statement1.this.requireContext()).setLocaleBool(false);
            Statement1.this.startActivity(new Intent((Context) Statement1.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(int i, String str, String str2) {
            System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                Statement1.this.commonUtilClass.showMessageOK(Statement1.this.getContext(), Statement1.this.session, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement1$2$$ExternalSyntheticLambda5
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$2(dialogInterface, i2);
                    }
                });
                return;
            }
            Statement1.this.token = "Bearer " + str;
            Statement1.this.refreshToken = str2;
            SharedPref.getInstance(Statement1.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(Statement1.this.requireContext()).setToken("Bearer " + str);
            Statement1.this.partElectorCount();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Statement1.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Statement1.this.requireContext()).setLocaleBool(false);
            Statement1.this.startActivity(new Intent((Context) Statement1.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$5(int i, String str, String str2) {
            System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                Statement1.this.commonUtilClass.showMessageOK(Statement1.this.getContext(), Statement1.this.session, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h_dashboard.Statement1$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$4(dialogInterface, i2);
                    }
                });
                return;
            }
            Statement1.this.token = "Bearer " + str;
            Statement1.this.refreshToken = str2;
            SharedPref.getInstance(Statement1.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(Statement1.this.requireContext()).setToken("Bearer " + str);
            Statement1.this.partElectorCount();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Statement1.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Statement1.this.requireContext()).setLocaleBool(false);
            Statement1.this.startActivity(new Intent((Context) Statement1.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JSONArray> call, Throwable t) {
            Statement1.this.alertDialog1.dismiss();
        }
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
