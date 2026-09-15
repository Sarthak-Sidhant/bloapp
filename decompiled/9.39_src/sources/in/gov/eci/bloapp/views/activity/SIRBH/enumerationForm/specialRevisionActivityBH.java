package in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivitySpecialRevisionBhBinding;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.CaptureActivityPortrait;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SIRBH.formdatanew.FormTypesBH;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class specialRevisionActivityBH extends SuperBaseActivity {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private String acNo;
    private String address;
    private String age;
    AlertDialog alertDialog;
    private String asmblyNO;
    private String asmblyName;
    private String atkband;
    String barcode;
    ActivitySpecialRevisionBhBinding binding;
    Bundle bundle;
    private String dob;
    private String epic;
    private String houseNumber;
    private String localityStreet;
    boolean matchFound;
    JSONParser parser;
    private String partId;
    private String partNo;
    private JsonObject payloadData1;
    private String photoURL;
    private Dialog progressDialog;
    private String refreshToken;
    private String relativeName;
    private String rtkband;
    private String section;
    private String serial;
    UserClient service;
    private String state;
    private String tehsil;
    private String token;
    private String townVillage;
    private String userFullName;
    Gson gson = new GsonBuilder().setLenient().create();
    JSONArray jsonArray11 = null;
    String filerefphoto = "";
    String SESSION = "";
    String messageString = "message";
    String noDataString = "";
    String comingTag = "coming in onFailure";
    String alertText = "";
    String objectStorageString = "objectstorage";
    private final String TAG = "SpecialRevisionTAG";
    String networkTag = "Please check network";
    String base64element1 = "";
    CommomUtility commomUtility = new CommomUtility();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPref.getInstance(getApplicationContext()).getToken();
        SharedPref.getInstance(getApplicationContext()).getStateCode();
        ActivitySpecialRevisionBhBinding activitySpecialRevisionBhBindingInflate = ActivitySpecialRevisionBhBinding.inflate(getLayoutInflater());
        this.binding = activitySpecialRevisionBhBindingInflate;
        setContentView(activitySpecialRevisionBhBindingInflate.getRoot());
        if (getIntent().getBooleanExtra("restart", false)) {
            getIntent().removeExtra("restart");
            new Handler().post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.recreate();
                }
            });
        }
        this.service = (UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class);
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.noDataString = getString(R.string.no_data_found);
        this.alertText = getString(R.string.alertMsg);
        this.SESSION = getString(R.string.sessionMsg);
        initClickListener();
        getTotalForms();
        String stringExtra = getIntent().getStringExtra("epic");
        this.epic = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            this.binding.enterEpicLayout.setVisibility(0);
            this.binding.searchEpicSR.setChecked(true);
            this.binding.enterEPICSR.setText(this.epic);
            checkEpicNumber(this.epic);
        }
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.searchEpicSR.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.submitEpic.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.scanNow.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.scannerQR.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.personImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.viewPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.nextTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        this.binding.electorDetailsLayout.setVisibility(8);
        this.binding.nextTv.setVisibility(8);
        this.binding.scanLayout.setVisibility(8);
        this.binding.enterEPICSR.setFocusable(true);
        this.binding.enterEpicLayout.setVisibility(0);
        this.binding.submitEpic.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        callValidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        cameraPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        this.binding.scanLayout.setVisibility(0);
        this.binding.electorDetailsLayout.setVisibility(8);
        this.binding.nextTv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        String str;
        String str2 = this.base64element1;
        if (str2 != null && !str2.isEmpty() && !this.base64element1.equals("null") && (str = this.base64element1) != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            showImageDialog(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), this.filerefphoto);
        } else {
            showImageDialog(BitmapFactory.decodeResource(getResources(), R.drawable.blo_dummy_image), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        try {
            if (isNetworkAvailable(getApplicationContext())) {
                AlertDialog alertDialog = this.alertDialog;
                if (alertDialog != null) {
                    alertDialog.show();
                }
                getFile1(this.filerefphoto);
                this.binding.personImage.setVisibility(0);
                this.binding.imageEnlargeTv.setVisibility(0);
                this.binding.viewPhoto.setVisibility(8);
                return;
            }
            Toast.makeText(getApplicationContext(), this.networkTag, 1).show();
            this.binding.personImage.setVisibility(8);
            this.binding.imageEnlargeTv.setVisibility(8);
            this.binding.viewPhoto.setVisibility(0);
        } catch (Exception unused) {
            Logger.e("SpecialRevisionTAG", this.comingTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        this.binding.personImage.setVisibility(8);
        this.binding.imageEnlargeTv.setVisibility(8);
        this.binding.viewPhoto.setVisibility(0);
        next();
    }

    private void callValidate() {
        if (TextUtils.isEmpty(this.epic)) {
            this.epic = this.binding.enterEPICSR.getText().toString();
        } else if (!this.epic.isEmpty() && this.epic.matches(RegexMatcher.EPIC_REGEX)) {
            checkEpicNumber(this.epic);
        } else {
            showDialog1(this.alertText, "Please enter valid EPIC Number");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void next() {
        Bundle bundle = new Bundle();
        this.bundle = bundle;
        bundle.putString("epicNo", this.epic);
        this.bundle.putString("houseNo", this.houseNumber);
        this.bundle.putString("dob", this.dob);
        this.bundle.putString("partSerialNo", this.serial);
        this.bundle.putString("photoURL", this.filerefphoto);
        Intent intent = new Intent((Context) this, (Class<?>) SpecialRevisionDetailsBH.class);
        intent.putExtras(this.bundle);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$7(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$7(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$8(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initClickListener$8(View view) {
        startActivity(new Intent((Context) this, (Class<?>) FormTypesBH.class));
    }

    public void getFile1(String fileref) {
        Logger.e("SpecialRevisionTAG", "in getFile1..............................");
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFileforSIR(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass1(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass1(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH] */
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
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (specialRevisionActivityBH.this.alertDialog != null) {
                    specialRevisionActivityBH.this.alertDialog.dismiss();
                }
                specialRevisionActivityBH.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(specialRevisionActivityBH.this.base64element1, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                Logger.d("Bitmap special", bitmapDecodeByteArray.toString());
                specialRevisionActivityBH.this.binding.personImage.setImageBitmap(bitmapDecodeByteArray);
                if (specialRevisionActivityBH.this.base64element1.isEmpty() || specialRevisionActivityBH.this.base64element1.equals("null")) {
                    specialRevisionActivityBH.this.binding.personImage.setImageBitmap(BitmapFactory.decodeResource(specialRevisionActivityBH.this.getResources(), R.drawable.blo_dummy_image));
                    if (specialRevisionActivityBH.this.alertDialog != null) {
                        specialRevisionActivityBH.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = specialRevisionActivityBH.this.commomUtility;
                    ?? r6 = specialRevisionActivityBH.this;
                    String str = ((specialRevisionActivityBH) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$1$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                    return;
                } catch (Exception unused) {
                    Logger.e("SpecialRevisionTAG", specialRevisionActivityBH.this.comingTag);
                    return;
                }
            }
            try {
                if (specialRevisionActivityBH.this.alertDialog != null) {
                    specialRevisionActivityBH.this.alertDialog.dismiss();
                }
                Logger.e("SpecialRevisionTAG", new JSONObject(response.errorBody().string()).optString(specialRevisionActivityBH.this.messageString));
            } catch (IOException | JSONException e) {
                if (specialRevisionActivityBH.this.alertDialog != null) {
                    specialRevisionActivityBH.this.alertDialog.dismiss();
                }
                Logger.e("SpecialRevisionTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH] */
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
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            if (specialRevisionActivityBH.this.alertDialog != null) {
                specialRevisionActivityBH.this.alertDialog.dismiss();
            }
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = specialRevisionActivityBH.this.commomUtility;
                ?? r5 = specialRevisionActivityBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                specialRevisionActivityBH.this.token = "Bearer " + str2;
                SharedPref.getInstance(specialRevisionActivityBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(specialRevisionActivityBH.this.getApplicationContext()).setToken("Bearer " + str2);
                specialRevisionActivityBH.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(specialRevisionActivityBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(specialRevisionActivityBH.this.getApplicationContext()).setLocaleBool(false);
            specialRevisionActivityBH.this.startActivity(new Intent(specialRevisionActivityBH.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("SpecialRevisionTAG", specialRevisionActivityBH.this.comingTag + t.getMessage());
            if (specialRevisionActivityBH.this.alertDialog != null) {
                specialRevisionActivityBH.this.alertDialog.dismiss();
            }
            specialRevisionActivityBH specialrevisionactivitybh = specialRevisionActivityBH.this;
            specialrevisionactivitybh.showDialog1(specialrevisionactivitybh.alertText, Constants.somethingWentWrong);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showImageDialog(Bitmap img, String name) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.blo_image_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_cancel_button);
        TouchImageView touchImageView = (TouchImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_person_image);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_image_name);
        touchImageView.setImageBitmap(img);
        textView.setText(name);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    protected void showProgressInVisible() {
        Dialog dialog = this.progressDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.progressDialog.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void cameraPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.CAMERA") == 0) {
            initScanner();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, REQUEST_CODE_CAMERA_PORTRAIT);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initScanner() {
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setCaptureActivity(CaptureActivityPortrait.class);
        intentIntegrator.initiateScan();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult activityResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (activityResult != null) {
            if (activityResult.getContents() == null) {
                Toast.makeText((Context) this, (CharSequence) "Scanning cancelled!", 1).show();
                return;
            }
            String contents = activityResult.getContents();
            try {
                this.barcode = new JSONObject(AESDecryptor.decrypt(contents)).getString("epic_no");
            } catch (Exception unused) {
                this.barcode = contents;
            }
            String strReplace = this.barcode.replace(" ", "");
            this.barcode = strReplace;
            checkEpicNumber(strReplace);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length <= 0 || grantResults[0] != 0) {
            showToast("Camera permission cancelled!");
        } else if (requestCode == REQUEST_CODE_CAMERA_PORTRAIT) {
            initScanner();
        }
    }

    public void checkEpicNumber(String epic) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        HashMap map2 = new HashMap();
        map2.put("epicNumber", epic);
        this.service.getSpecialSurveyEpicCheck(map, map2).enqueue(new AnonymousClass2(epic));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<ResponseBody> {
        final /* synthetic */ String val$epic;

        AnonymousClass2(final String val$epic) {
            this.val$epic = val$epic;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH] */
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
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    String strTrim = ((ResponseBody) response.body()).string().trim();
                    if ("Proceed".equalsIgnoreCase(strTrim)) {
                        specialRevisionActivityBH.this.getAllElectors(this.val$epic);
                    } else {
                        specialRevisionActivityBH specialrevisionactivitybh = specialRevisionActivityBH.this;
                        specialrevisionactivitybh.showDialog1(specialrevisionactivitybh.alertText, strTrim);
                    }
                    return;
                } catch (Exception e) {
                    Logger.d("SpecialRevisionTAG", e.toString());
                    return;
                }
            }
            if (response.code() == 400 || response.code() == 401) {
                CommomUtility commomUtility = specialRevisionActivityBH.this.commomUtility;
                ?? r4 = specialRevisionActivityBH.this;
                commomUtility.showMessageOK(r4, r4.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(specialRevisionActivityBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(specialRevisionActivityBH.this.getApplicationContext()).setLocaleBool(false);
            specialRevisionActivityBH.this.startActivity(new Intent(specialRevisionActivityBH.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<ResponseBody> call, Throwable t) {
            Logger.d("SpecialRevisionTAG", t.getMessage());
        }
    }

    public void getAllElectors(String epicNumber) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        HashMap map2 = new HashMap();
        map2.put("stateCd", this.state);
        map2.put("acNo", this.asmblyNO);
        map2.put("partNo", this.partNo);
        map2.put("epicNo", epicNumber);
        this.service.getAllPartElector(map, map2).enqueue(new AnonymousClass3(epicNumber));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        final /* synthetic */ String val$epicNumber;

        static /* synthetic */ void lambda$onResponse$0() {
        }

        AnonymousClass3(final String val$epicNumber) {
            this.val$epicNumber = val$epicNumber;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH] */
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
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (response.body() != null) {
                    specialRevisionActivityBH.this.payloadData1 = (JsonObject) response.body();
                    if (specialRevisionActivityBH.this.payloadData1 != null) {
                        Iterator it = specialRevisionActivityBH.this.payloadData1.getAsJsonArray("payload").iterator();
                        while (it.hasNext()) {
                            JsonObject asJsonObject = ((JsonElement) it.next()).getAsJsonObject();
                            if (this.val$epicNumber.equalsIgnoreCase(asJsonObject.get("epicNo").getAsString())) {
                                specialRevisionActivityBH.this.matchFound = true;
                                specialRevisionActivityBH.this.epic = asJsonObject.get("epicNo").getAsString();
                                specialRevisionActivityBH.this.partId = asJsonObject.get("partNo").getAsString();
                                specialRevisionActivityBH.this.userFullName = asJsonObject.get("applicantName").getAsString();
                                specialRevisionActivityBH.this.relativeName = asJsonObject.get("relativeName").getAsString();
                                specialRevisionActivityBH.this.age = asJsonObject.get("age").getAsString();
                                specialRevisionActivityBH.this.section = asJsonObject.get("sectionNo").getAsString();
                                specialRevisionActivityBH.this.dob = asJsonObject.get("dob").getAsString();
                                specialRevisionActivityBH.this.filerefphoto = asJsonObject.get("photo").getAsString();
                                specialRevisionActivityBH.this.houseNumber = asJsonObject.get("houseNo").getAsString();
                                specialRevisionActivityBH.this.townVillage = asJsonObject.get("village").getAsString();
                                specialRevisionActivityBH.this.localityStreet = asJsonObject.get("localitySreet").getAsString();
                                specialRevisionActivityBH.this.serial = asJsonObject.get("partSerialNumber").getAsString();
                            }
                        }
                        if (specialRevisionActivityBH.this.houseNumber == null) {
                            specialRevisionActivityBH.this.houseNumber = "";
                        }
                        if (specialRevisionActivityBH.this.localityStreet == null) {
                            specialRevisionActivityBH.this.localityStreet = "";
                        }
                        if (specialRevisionActivityBH.this.townVillage == null) {
                            specialRevisionActivityBH.this.townVillage = "";
                        }
                        if (!specialRevisionActivityBH.this.houseNumber.isEmpty() || !specialRevisionActivityBH.this.localityStreet.isEmpty() || !specialRevisionActivityBH.this.townVillage.isEmpty()) {
                            specialRevisionActivityBH.this.address = specialRevisionActivityBH.this.houseNumber + " " + specialRevisionActivityBH.this.localityStreet + " " + specialRevisionActivityBH.this.townVillage;
                        }
                        specialRevisionActivityBH.this.acNo = specialRevisionActivityBH.this.asmblyNO + "-" + SharedPref.getInstance(specialRevisionActivityBH.this.getApplicationContext()).getAssemblyName();
                        specialRevisionActivityBH.this.binding.electorDetailsLayout.setVisibility(0);
                        specialRevisionActivityBH.this.binding.bottomSubmitLayout.setVisibility(0);
                        specialRevisionActivityBH.this.binding.nextTv.setVisibility(0);
                        specialRevisionActivityBH.this.binding.applicantNameSR.setText(specialRevisionActivityBH.this.userFullName);
                        specialRevisionActivityBH.this.binding.partSR.setText(specialRevisionActivityBH.this.partId);
                        specialRevisionActivityBH.this.binding.sectionNameSR.setText(specialRevisionActivityBH.this.section);
                        specialRevisionActivityBH.this.binding.electorAssemblySR.setText(specialRevisionActivityBH.this.asmblyName);
                        specialRevisionActivityBH.this.binding.addressSR.setText(specialRevisionActivityBH.this.address);
                        specialRevisionActivityBH.this.binding.applicantEpicSR.setText(specialRevisionActivityBH.this.epic);
                        specialRevisionActivityBH.this.binding.ageSR.setText(specialRevisionActivityBH.this.age);
                        specialRevisionActivityBH.this.binding.dobSR.setText(specialRevisionActivityBH.this.dob);
                        specialRevisionActivityBH.this.binding.electorAssemblySR.setText(specialRevisionActivityBH.this.acNo);
                        specialRevisionActivityBH.this.binding.relativeNameSR.setText(specialRevisionActivityBH.this.relativeName);
                        specialRevisionActivityBH.this.binding.serialSR.setText(specialRevisionActivityBH.this.serial);
                        new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$3$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                specialRevisionActivityBH.AnonymousClass3.lambda$onResponse$0();
                            }
                        }, 2000L);
                    }
                    if (specialRevisionActivityBH.this.matchFound) {
                        return;
                    }
                    specialRevisionActivityBH.this.binding.electorDetailsLayout.setVisibility(8);
                    specialRevisionActivityBH.this.binding.nextTv.setVisibility(8);
                    specialRevisionActivityBH specialrevisionactivitybh = specialRevisionActivityBH.this;
                    specialrevisionactivitybh.showDialog1(specialrevisionactivitybh.alertText, specialRevisionActivityBH.this.noDataString);
                    return;
                }
                new JsonObject();
                specialRevisionActivityBH.this.binding.electorDetailsLayout.setVisibility(8);
                specialRevisionActivityBH.this.binding.nextTv.setVisibility(8);
                Logger.d("SpecialRevisionTAG", "In fetchEPICData() -> else part ----> Response Body is null .............................");
                specialRevisionActivityBH specialrevisionactivitybh2 = specialRevisionActivityBH.this;
                specialrevisionactivitybh2.showDialog1(specialrevisionactivitybh2.alertText, specialRevisionActivityBH.this.noDataString);
                return;
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = specialRevisionActivityBH.this.commomUtility;
                ?? r6 = specialRevisionActivityBH.this;
                String str = ((specialRevisionActivityBH) r6).refreshToken;
                final String str2 = this.val$epicNumber;
                commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$3$$ExternalSyntheticLambda2
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$2(str2, i, str3, str4);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH] */
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
        public /* synthetic */ void lambda$onResponse$2(String str, int i, String str2, String str3) {
            System.out.println("zxnbchdbvfhvb12 " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = specialRevisionActivityBH.this.commomUtility;
                ?? r5 = specialRevisionActivityBH.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
            } else {
                specialRevisionActivityBH.this.token = "Bearer " + str2;
                specialRevisionActivityBH.this.refreshToken = str3;
                SharedPref.getInstance(specialRevisionActivityBH.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(specialRevisionActivityBH.this.getApplicationContext()).setToken("Bearer " + str2);
                specialRevisionActivityBH.this.getAllElectors(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(specialRevisionActivityBH.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(specialRevisionActivityBH.this.getApplicationContext()).setLocaleBool(false);
            specialRevisionActivityBH.this.startActivity(new Intent(specialRevisionActivityBH.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(" ", t.getMessage());
            specialRevisionActivityBH specialrevisionactivitybh = specialRevisionActivityBH.this;
            specialrevisionactivitybh.showDialog1(specialrevisionactivitybh.alertText, Constants.somethingWentWrong);
            if (specialRevisionActivityBH.this.alertDialog != null) {
                specialRevisionActivityBH.this.alertDialog.dismiss();
            }
        }
    }

    protected void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(this.epic)) {
            this.binding.scannerQR.setChecked(true);
            this.binding.scanLayout.setVisibility(0);
            this.binding.enterEpicLayout.setVisibility(8);
            this.binding.electorDetailsLayout.setVisibility(8);
            this.binding.bottomSubmitLayout.setVisibility(8);
            this.binding.nextTv.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getTotalForms() {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("applicationname", "BLOAPP");
        map.put("appname", "BLO");
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        int i = Integer.parseInt(SharedPref.getInstance(this).getStateCode().replace("S", ""));
        String strSubstring = SharedPref.getInstance(this).getDistrictCode().substring(3);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList.add(Integer.valueOf(i));
        arrayList2.add(Integer.valueOf(strSubstring));
        arrayList3.add(Integer.valueOf(this.asmblyNO));
        arrayList4.add(Integer.valueOf(this.partNo));
        map2.put("stateIds", arrayList);
        map2.put("groupByColumn", "PART_NO");
        map2.put("districtIds", arrayList2);
        map2.put("acNumbers", arrayList3);
        map2.put("partNumbers", arrayList4);
        this.service.getTotalFormElector(map, map2).enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.views.activity.SIRBH.enumerationForm.specialRevisionActivityBH.4
            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                if (response.code() == 200) {
                    try {
                        if (response.body() != null) {
                            Logger.d("SpecialRevisionTAG", String.valueOf(response.body()));
                            JsonObject asJsonObject = specialRevisionActivityBH.this.gson.toJsonTree(((JSONArray) response.body()).get(0)).getAsJsonObject();
                            specialRevisionActivityBH.this.showDialog1("", String.valueOf(asJsonObject.get("efUploadByBlo").getAsInt()) + " out of " + String.valueOf(asJsonObject.get("totalElector").getAsInt()) + " forms are filled");
                        }
                    } catch (Exception e) {
                        Logger.d("SpecialRevisionTAG", e.toString());
                    }
                }
            }

            public void onFailure(Call<JSONArray> call, Throwable t) {
                Logger.e("SpecialRevisionTAG", t.getMessage());
            }
        });
    }
}
