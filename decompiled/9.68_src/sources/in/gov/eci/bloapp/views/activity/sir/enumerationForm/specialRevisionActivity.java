package in.gov.eci.bloapp.views.activity.sir.enumerationForm;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.EronetResonse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivitySpecialRevisionBinding;
import in.gov.eci.bloapp.room.dao.ListDataDao;
import in.gov.eci.bloapp.room.database.SIRDatabaseHelper;
import in.gov.eci.bloapp.utils.AESDecryptor;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.NetworkReceiver;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.CaptureActivityPortrait;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class specialRevisionActivity extends SuperBaseActivity {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private String acNO;
    private String address;
    private String age;
    AlertDialog alertDialog;
    private String asmblyNO;
    private String asmblyName;
    private String atkband;
    String barcode;
    ActivitySpecialRevisionBinding binding;
    Bundle bundle;
    private ListDataDao dao;
    private String districtCode;
    private String dob;
    DrawerLayout drawer;
    private String epic;
    private Long epicId;
    private String houseNumber;
    private String localityStreet;
    boolean matchFound;
    private NetworkReceiver networkReceiver;
    JSONParser parser;
    private String part;
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
    SIRDatabaseHelper sirDatabaseHelper;
    private String state;
    private String tehsil;
    private String token;
    private String townVillage;
    private String userFullName;
    Gson gson = new GsonBuilder().setLenient().create();
    String stateId = "";
    String acId = "";
    String districtId = "";
    String stateIdText = "stateId";
    String acIdText = "acId";
    String districtIdText = "districtId";
    String stateCdText = "stateCd";
    String acNoText = "acNo";
    String districtCdText = "districtCd";
    JSONArray jsonArray11 = null;
    String filerefphoto = "";
    String SESSION = "";
    String messageString = "message";
    String noDataString = "";
    String comingTag = "coming in onFailure";
    String alertText = "";
    String objectStorageString = "objectstorage";
    String distNo2003 = "";
    String acNo2003 = "";
    String partNo2003 = "";
    String firstName2003 = "";
    String lastName2003 = "";
    String partSerialNo2003 = "";
    String distName2003 = "";
    String acName2003 = "";
    String partName2003 = "";
    private final String TAG = "SpecialRevisionTAG";
    String networkTag = "Please check network";
    String base64element1 = "";
    String sessionExpiredText = "";
    String sessionExpiredTextForRefresh = "Page refreshed due to the token expiry.";
    String bearerText = "Bearer ";
    String getRefreshTokenText = "getRefreshToken : ";
    CommomUtility commomUtility = new CommomUtility();
    Boolean flag2003 = false;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPref.getInstance(getApplicationContext()).getToken();
        SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.binding = ActivitySpecialRevisionBinding.inflate(getLayoutInflater());
        getString(R.string.blo_version_no, new Object[]{BuildConfig.VERSION_NAME});
        setContentView(this.binding.getRoot());
        setSupportActionBar(findViewById(R.id.toolbar));
        this.sirDatabaseHelper = SIRDatabaseHelper.getDB(getApplicationContext());
        if (getIntent().getBooleanExtra("restart", false)) {
            getIntent().removeExtra("restart");
            new Handler().post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$$ExternalSyntheticLambda2
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
        this.districtCode = SharedPref.getInstance(getApplicationContext()).getDistrictCode();
        this.acNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.part = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.noDataString = getString(R.string.no_data_found);
        this.SESSION = getString(R.string.sessionMsg);
        this.sessionExpiredText = getString(R.string.sessionMsg);
        this.alertText = getString(R.string.alertMsg);
        initClickListener();
        fetchAllId();
        this.binding.scannerQR.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                specialRevisionActivity specialrevisionactivity = specialRevisionActivity.this;
                specialrevisionactivity.selecttab(specialrevisionactivity.binding.scannerQR, specialRevisionActivity.this.binding.searchEpicSR);
                specialRevisionActivity.this.binding.scanLayout.setVisibility(0);
                specialRevisionActivity.this.binding.electorDetailsLayout.setVisibility(8);
                specialRevisionActivity.this.binding.nextTv.setVisibility(8);
                specialRevisionActivity.this.binding.enterEpicLayout.setVisibility(8);
                specialRevisionActivity.this.binding.submitEpic.setVisibility(8);
            }
        });
        this.binding.searchEpicSR.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                specialRevisionActivity specialrevisionactivity = specialRevisionActivity.this;
                specialrevisionactivity.selecttab(specialrevisionactivity.binding.searchEpicSR, specialRevisionActivity.this.binding.scannerQR);
                specialRevisionActivity.this.binding.electorDetailsLayout.setVisibility(8);
                specialRevisionActivity.this.binding.nextTv.setVisibility(8);
                specialRevisionActivity.this.binding.enterEPICSR.setFocusable(true);
                specialRevisionActivity.this.binding.scanLayout.setVisibility(8);
                specialRevisionActivity.this.binding.enterEpicLayout.setVisibility(0);
                specialRevisionActivity.this.binding.submitEpic.setVisibility(0);
            }
        });
        this.binding.scanBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        selecttab(this.binding.scannerQR, this.binding.searchEpicSR);
        String stringExtra = getIntent().getStringExtra("epic");
        this.epic = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            this.binding.enterEpicLayout.setVisibility(0);
            selecttab(this.binding.searchEpicSR, this.binding.scannerQR);
            this.binding.enterEPICSR.setText(this.epic);
            this.binding.searchEpicSR.setVisibility(0);
            this.binding.submitEpic.setVisibility(0);
            checkEpicNumber(this.epic);
        } else {
            this.binding.scanLayout.setVisibility(0);
        }
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.binding.submitEpic.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.personImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.viewPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.nextTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        cameraPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.callValidate();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
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
    public /* synthetic */ void lambda$onCreate$3(View view) {
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
    public /* synthetic */ void lambda$onCreate$4(View view) {
        this.binding.personImage.setVisibility(8);
        this.binding.imageEnlargeTv.setVisibility(8);
        this.binding.viewPhoto.setVisibility(0);
        next();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void selecttab(MaterialButton selected, MaterialButton other) {
        selected.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.new_tab_color));
        selected.setTextColor(ContextCompat.getColor(this, R.color.blo_white));
        other.setBackgroundTintList(ContextCompat.getColorStateList(this, android.R.color.transparent));
        other.setTextColor(ContextCompat.getColor(this, R.color.blo_black));
        other.setStrokeWidth(2);
        other.setStrokeColor(ContextCompat.getColorStateList(this, R.color.blo_light_grey));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callValidate() {
        String string = this.binding.enterEPICSR.getText().toString();
        if (!TextUtils.isEmpty(string) && string.matches(RegexMatcher.EPIC_REGEX)) {
            checkEpicNumber(string);
        } else {
            showDialog1(this.alertText, getString(R.string.please_enter_valid_epic_number));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void next() {
        Bundle bundle = new Bundle();
        this.bundle = bundle;
        bundle.putString("epicNo", this.epic);
        this.bundle.putLong("epicId", this.epicId.longValue());
        this.bundle.putString("houseNo", this.houseNumber);
        this.bundle.putString("dob", this.dob);
        this.bundle.putString("partSerialNo", this.serial);
        this.bundle.putString("photoURL", this.filerefphoto);
        this.bundle.putString("age", this.age);
        if (this.flag2003.booleanValue()) {
            this.bundle.putString("acNo2003", this.acNo2003);
            this.bundle.putString("acName2003", this.acName2003);
            this.bundle.putString("partNo2003", this.partNo2003);
            this.bundle.putString("partName2003", this.partName2003);
            this.bundle.putString("distNo2003", this.distNo2003);
            this.bundle.putString("distName2003", this.distName2003);
            this.bundle.putString("partSerialNo2003", this.partSerialNo2003);
            this.bundle.putString("firstName2003", this.firstName2003);
            this.bundle.putString("lastName2003", this.lastName2003);
            this.bundle.putBoolean("flag2003", this.flag2003.booleanValue());
        }
        Intent intent = new Intent((Context) this, (Class<?>) SpecialRevisionDetails.class);
        intent.putExtras(this.bundle);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$5(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$5(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$6(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initClickListener$6(View view) {
        startActivity(new Intent((Context) this, (Class<?>) FormTypes.class));
    }

    public void getFile1(String fileref) {
        Logger.e("SpecialRevisionTAG", "in getFile1..............................");
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getFile(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass3(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass3(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity] */
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
                if (specialRevisionActivity.this.alertDialog != null) {
                    specialRevisionActivity.this.alertDialog.dismiss();
                }
                specialRevisionActivity.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(specialRevisionActivity.this.base64element1, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                Logger.d("Bitmap special", bitmapDecodeByteArray.toString());
                specialRevisionActivity.this.binding.personImage.setImageBitmap(bitmapDecodeByteArray);
                if (specialRevisionActivity.this.base64element1.isEmpty() || specialRevisionActivity.this.base64element1.equals("null")) {
                    specialRevisionActivity.this.binding.personImage.setImageBitmap(BitmapFactory.decodeResource(specialRevisionActivity.this.getResources(), R.drawable.blo_dummy_image));
                    if (specialRevisionActivity.this.alertDialog != null) {
                        specialRevisionActivity.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = specialRevisionActivity.this.commomUtility;
                    ?? r6 = specialRevisionActivity.this;
                    String str = ((specialRevisionActivity) r6).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r6, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$3$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                    return;
                } catch (Exception unused) {
                    Logger.e("SpecialRevisionTAG", specialRevisionActivity.this.comingTag);
                    return;
                }
            }
            try {
                if (specialRevisionActivity.this.alertDialog != null) {
                    specialRevisionActivity.this.alertDialog.dismiss();
                }
                Logger.e("SpecialRevisionTAG", new JSONObject(response.errorBody().string()).optString(specialRevisionActivity.this.messageString));
            } catch (IOException | JSONException e) {
                if (specialRevisionActivity.this.alertDialog != null) {
                    specialRevisionActivity.this.alertDialog.dismiss();
                }
                Logger.e("SpecialRevisionTAG", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity] */
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
            if (specialRevisionActivity.this.alertDialog != null) {
                specialRevisionActivity.this.alertDialog.dismiss();
            }
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = specialRevisionActivity.this.commomUtility;
                ?? r5 = specialRevisionActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$3$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                specialRevisionActivity.this.token = "Bearer " + str2;
                SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).setToken("Bearer " + str2);
                specialRevisionActivity.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).setLocaleBool(false);
            specialRevisionActivity.this.startActivity(new Intent(specialRevisionActivity.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("SpecialRevisionTAG", specialRevisionActivity.this.comingTag + t.getMessage());
            if (specialRevisionActivity.this.alertDialog != null) {
                specialRevisionActivity.this.alertDialog.dismiss();
            }
            specialRevisionActivity specialrevisionactivity = specialRevisionActivity.this;
            specialrevisionactivity.showDialog1(specialrevisionactivity.alertText, t.getMessage());
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
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$$ExternalSyntheticLambda0
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
            String strReplace = this.barcode.replace(StringUtils.SPACE, "");
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
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
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
        this.service.getSpecialSurveyEpicCheckSIR(map, map2).enqueue(new AnonymousClass4(epic));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<ResponseBody> {
        final /* synthetic */ String val$epic;

        AnonymousClass4(final String val$epic) {
            this.val$epic = val$epic;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity] */
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
                        specialRevisionActivity.this.getAllElectors(this.val$epic);
                    } else {
                        specialRevisionActivity.this.alertDialog.dismiss();
                        specialRevisionActivity specialrevisionactivity = specialRevisionActivity.this;
                        specialrevisionactivity.showDialog1(specialrevisionactivity.alertText, strTrim);
                        specialRevisionActivity.this.binding.electorDetailsLayout.setVisibility(8);
                    }
                    return;
                } catch (Exception e) {
                    specialRevisionActivity.this.alertDialog.dismiss();
                    Logger.d("SpecialRevisionTAG", e.toString());
                    return;
                }
            }
            if (response.code() == 400 || response.code() == 401) {
                specialRevisionActivity.this.alertDialog.dismiss();
                CommomUtility commomUtility = specialRevisionActivity.this.commomUtility;
                ?? r4 = specialRevisionActivity.this;
                commomUtility.showMessageOK(r4, r4.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$4$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).setLocaleBool(false);
            specialRevisionActivity.this.startActivity(new Intent(specialRevisionActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<ResponseBody> call, Throwable t) {
            specialRevisionActivity.this.alertDialog.dismiss();
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
        map2.put("acNo", this.acNO);
        map2.put("partNo", this.part);
        map2.put("epicNo", epicNumber);
        this.service.getAllPartElector(map, map2).enqueue(new AnonymousClass5(epicNumber));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        final /* synthetic */ String val$epicNumber;

        static /* synthetic */ void lambda$onResponse$0() {
        }

        AnonymousClass5(final String val$epicNumber) {
            this.val$epicNumber = val$epicNumber;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity] */
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
                specialRevisionActivity.this.alertDialog.dismiss();
                if (response.body() != null) {
                    specialRevisionActivity.this.payloadData1 = (JsonObject) response.body();
                    if (specialRevisionActivity.this.payloadData1 != null) {
                        Iterator it = specialRevisionActivity.this.payloadData1.getAsJsonArray("payload").iterator();
                        while (it.hasNext()) {
                            JsonObject asJsonObject = ((JsonElement) it.next()).getAsJsonObject();
                            if (this.val$epicNumber.equalsIgnoreCase(asJsonObject.get("epicNo").getAsString())) {
                                specialRevisionActivity.this.matchFound = true;
                                specialRevisionActivity.this.epic = asJsonObject.get("epicNo").getAsString();
                                specialRevisionActivity.this.epicId = Long.valueOf(asJsonObject.get("epicId").getAsLong());
                                specialRevisionActivity.this.partId = asJsonObject.get("partNo").getAsString();
                                specialRevisionActivity.this.userFullName = asJsonObject.get("applicantName").getAsString();
                                specialRevisionActivity.this.relativeName = asJsonObject.get("relativeName").getAsString();
                                specialRevisionActivity.this.age = asJsonObject.get("age").getAsString();
                                specialRevisionActivity.this.section = asJsonObject.get("sectionNo").getAsString();
                                specialRevisionActivity.this.dob = asJsonObject.get("dob").getAsString();
                                specialRevisionActivity.this.filerefphoto = asJsonObject.get("photo").getAsString();
                                specialRevisionActivity.this.houseNumber = asJsonObject.get("houseNo").getAsString();
                                specialRevisionActivity.this.townVillage = asJsonObject.get("village").getAsString();
                                specialRevisionActivity.this.localityStreet = asJsonObject.get("localitySreet").getAsString();
                                specialRevisionActivity.this.serial = asJsonObject.get("partSerialNumber").getAsString();
                            }
                        }
                        if (specialRevisionActivity.this.houseNumber == null) {
                            specialRevisionActivity.this.houseNumber = "";
                        }
                        if (specialRevisionActivity.this.localityStreet == null) {
                            specialRevisionActivity.this.localityStreet = "";
                        }
                        if (specialRevisionActivity.this.townVillage == null) {
                            specialRevisionActivity.this.townVillage = "";
                        }
                        if (!specialRevisionActivity.this.houseNumber.isEmpty() || !specialRevisionActivity.this.localityStreet.isEmpty() || !specialRevisionActivity.this.townVillage.isEmpty()) {
                            specialRevisionActivity.this.address = specialRevisionActivity.this.houseNumber + StringUtils.SPACE + specialRevisionActivity.this.localityStreet + StringUtils.SPACE + specialRevisionActivity.this.townVillage;
                        }
                        specialRevisionActivity.this.asmblyNO = specialRevisionActivity.this.acNO + "-" + SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).getAssemblyName();
                        specialRevisionActivity.this.binding.electorDetailsLayout.setVisibility(0);
                        specialRevisionActivity.this.binding.bottomSubmitLayout.setVisibility(0);
                        specialRevisionActivity.this.binding.nextTv.setVisibility(0);
                        specialRevisionActivity.this.binding.applicantNameSR.setText(specialRevisionActivity.this.userFullName);
                        specialRevisionActivity.this.binding.partSR.setText(specialRevisionActivity.this.partId);
                        specialRevisionActivity.this.binding.sectionNameSR.setText(specialRevisionActivity.this.section);
                        specialRevisionActivity.this.binding.electorAssemblySR.setText(specialRevisionActivity.this.asmblyName);
                        specialRevisionActivity.this.binding.addressSR.setText(specialRevisionActivity.this.address);
                        specialRevisionActivity.this.binding.applicantEpicSR.setText(specialRevisionActivity.this.epic);
                        specialRevisionActivity.this.binding.ageSR.setText(specialRevisionActivity.this.age);
                        specialRevisionActivity.this.binding.dobSR.setText(specialRevisionActivity.this.dob);
                        specialRevisionActivity.this.binding.electorAssemblySR.setText(specialRevisionActivity.this.asmblyNO);
                        specialRevisionActivity.this.binding.relativeNameSR.setText(specialRevisionActivity.this.relativeName);
                        specialRevisionActivity.this.binding.serialSR.setText(specialRevisionActivity.this.serial);
                        specialRevisionActivity specialrevisionactivity = specialRevisionActivity.this;
                        specialrevisionactivity.getDetailsByEpic(specialrevisionactivity.epic);
                        Log.d("SpecialRevisionTAG", "part no:" + specialRevisionActivity.this.partId);
                        new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$5$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                specialRevisionActivity.AnonymousClass5.lambda$onResponse$0();
                            }
                        }, 2000L);
                    }
                    if (specialRevisionActivity.this.matchFound) {
                        return;
                    }
                    specialRevisionActivity.this.binding.electorDetailsLayout.setVisibility(8);
                    specialRevisionActivity.this.binding.nextTv.setVisibility(8);
                    specialRevisionActivity specialrevisionactivity2 = specialRevisionActivity.this;
                    specialrevisionactivity2.showDialog1(specialrevisionactivity2.alertText, specialRevisionActivity.this.noDataString);
                    specialRevisionActivity.this.alertDialog.dismiss();
                    return;
                }
                specialRevisionActivity.this.alertDialog.dismiss();
                new JsonObject();
                specialRevisionActivity.this.binding.electorDetailsLayout.setVisibility(8);
                specialRevisionActivity.this.binding.nextTv.setVisibility(8);
                Logger.d("SpecialRevisionTAG", "In fetchEPICData() -> else part ----> Response Body is null .............................");
                specialRevisionActivity specialrevisionactivity3 = specialRevisionActivity.this;
                specialrevisionactivity3.showDialog1(specialrevisionactivity3.alertText, specialRevisionActivity.this.getString(R.string.no_data_found));
                return;
            }
            if (response.code() == 401) {
                specialRevisionActivity.this.alertDialog.dismiss();
                CommomUtility commomUtility = specialRevisionActivity.this.commomUtility;
                ?? r7 = specialRevisionActivity.this;
                String str = ((specialRevisionActivity) r7).refreshToken;
                final String str2 = this.val$epicNumber;
                commomUtility.getRefreshToken(r7, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$5$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$2(str2, i, str3, str4);
                    }
                });
                return;
            }
            specialRevisionActivity.this.alertDialog.dismiss();
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                Logger.e("SpecialRevisionTAG", strOptString);
                specialRevisionActivity specialrevisionactivity4 = specialRevisionActivity.this;
                specialrevisionactivity4.showDialog1(specialrevisionactivity4.alertText, strOptString);
            } catch (Exception e) {
                Logger.d("SpecialRevisionActivity", e.toString());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity] */
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
            System.out.println("zxnbchdbvfhvb12 " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = specialRevisionActivity.this.commomUtility;
                ?? r5 = specialRevisionActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$5$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
                return;
            }
            specialRevisionActivity.this.token = "Bearer " + str2;
            specialRevisionActivity.this.refreshToken = str3;
            SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).setRefreshToken(str3);
            SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).setToken("Bearer " + str2);
            specialRevisionActivity.this.getAllElectors(str);
            specialRevisionActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).setLocaleBool(false);
            specialRevisionActivity.this.startActivity(new Intent(specialRevisionActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(StringUtils.SPACE, t.getMessage());
            specialRevisionActivity specialrevisionactivity = specialRevisionActivity.this;
            specialrevisionactivity.showDialog1(specialrevisionactivity.alertText, t.getMessage());
            if (specialRevisionActivity.this.alertDialog != null) {
                specialRevisionActivity.this.alertDialog.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void getDetailsByEpic(String epicNumber) {
        HashMap<String, String> map = new HashMap<>();
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("applicationname", "BLOAPP");
        map.put("appname", "BLO");
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        ((UserClient) ApiClient.getClient1(this).create(UserClient.class)).getDetailsByEpicNo(epicNumber, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity.6
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (specialRevisionActivity.this.alertDialog != null) {
                        specialRevisionActivity.this.alertDialog.dismiss();
                    }
                    JsonObject jsonObject = (JsonObject) response.body();
                    Log.d("StatusCodePart", String.valueOf(jsonObject.get("statusCode").getAsInt()));
                    Iterator it = jsonObject.getAsJsonArray("payload").iterator();
                    while (it.hasNext()) {
                        JsonObject asJsonObject = ((JsonElement) it.next()).getAsJsonObject();
                        if (asJsonObject.get("distNo") != null) {
                            specialRevisionActivity.this.distNo2003 = asJsonObject.get("distNo").getAsString();
                        }
                        if (asJsonObject.get("distName") != null) {
                            specialRevisionActivity.this.distName2003 = asJsonObject.get("distName").getAsString();
                        }
                        if (asJsonObject.get("acNo") != null) {
                            specialRevisionActivity.this.acNo2003 = asJsonObject.get("acNo").getAsString();
                        }
                        if (asJsonObject.get("partNo") != null) {
                            specialRevisionActivity.this.partNo2003 = asJsonObject.get("partNo").getAsString();
                        }
                        if (asJsonObject.get(Constants.FIRST_NAME) != null && !String.valueOf(asJsonObject.get(Constants.FIRST_NAME)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase("null")) {
                            specialRevisionActivity.this.firstName2003 = asJsonObject.get(Constants.FIRST_NAME).getAsString();
                        }
                        if (asJsonObject.get(Constants.LAST_NAME) != null && !String.valueOf(asJsonObject.get(Constants.LAST_NAME)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "").equalsIgnoreCase("null")) {
                            specialRevisionActivity.this.lastName2003 = asJsonObject.get(Constants.LAST_NAME).getAsString();
                        }
                        if (asJsonObject.get("partSerialNo") != null) {
                            specialRevisionActivity.this.partSerialNo2003 = asJsonObject.get("partSerialNo").getAsString();
                        }
                        if (asJsonObject.get("acName") != null) {
                            specialRevisionActivity.this.acName2003 = asJsonObject.get("acName").getAsString();
                        }
                        if (asJsonObject.get("partName") != null) {
                            specialRevisionActivity.this.partName2003 = asJsonObject.get("partName").getAsString();
                        }
                        specialRevisionActivity.this.flag2003 = true;
                    }
                    return;
                }
                specialRevisionActivity.this.flag2003 = false;
                if (specialRevisionActivity.this.alertDialog != null) {
                    specialRevisionActivity.this.alertDialog.dismiss();
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.e("SpecialRevisionTAG", t.getMessage());
                if (specialRevisionActivity.this.alertDialog != null) {
                    specialRevisionActivity.this.alertDialog.dismiss();
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onResume() {
        super.onResume();
        this.networkReceiver = new NetworkReceiver(this);
        registerReceiver(this.networkReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        if (TextUtils.isEmpty(this.epic)) {
            selecttab(this.binding.scannerQR, this.binding.searchEpicSR);
            this.binding.enterEpicLayout.setVisibility(8);
            this.binding.electorDetailsLayout.setVisibility(8);
            this.binding.bottomSubmitLayout.setVisibility(8);
            this.binding.nextTv.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void fetchAllId() {
        HashMap map = new HashMap();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        Logger.d("fetchAllId() -> fetchAllIdHeader : ", map.toString());
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getAllId(this.acNO, this.districtCode, map).enqueue(new AnonymousClass7());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<EronetResonse> {
        AnonymousClass7() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity] */
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
        public void onResponse(Call<EronetResonse> call, Response<EronetResonse> response) {
            Logger.d("SpecialRevisionTAG", "fetchAllId() -> code : " + response.code());
            if (response.code() == 200) {
                Logger.d("SpecialRevisionTAG", "------ Fetching Data from fetchAllId API -- Start ----");
                Logger.d("SpecialRevisionTAG", "In fetchAllId() -> status : " + ((EronetResonse) response.body()).getStatus());
                Logger.d("SpecialRevisionTAG", "In fetchAllId() -> statusCode : " + ((EronetResonse) response.body()).getStatusCode());
                JSONArray payload = ((EronetResonse) response.body()).getPayload();
                Logger.d("SpecialRevisionTAG", "In fetchAllId() -> payload : " + payload);
                JsonObject asJsonObject = specialRevisionActivity.this.gson.toJsonTree((LinkedTreeMap) payload.get(0)).getAsJsonObject();
                if (asJsonObject.get(specialRevisionActivity.this.acNoText) != null) {
                    specialRevisionActivity specialrevisionactivity = specialRevisionActivity.this;
                    specialrevisionactivity.asmblyNO = String.valueOf(asJsonObject.get(specialrevisionactivity.acNoText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(specialRevisionActivity.this.stateCdText) != null) {
                    specialRevisionActivity specialrevisionactivity2 = specialRevisionActivity.this;
                    specialrevisionactivity2.state = String.valueOf(asJsonObject.get(specialrevisionactivity2.stateCdText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(specialRevisionActivity.this.districtCdText) != null) {
                    specialRevisionActivity specialrevisionactivity3 = specialRevisionActivity.this;
                    specialrevisionactivity3.districtCode = String.valueOf(asJsonObject.get(specialrevisionactivity3.districtCdText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(specialRevisionActivity.this.stateIdText) != null) {
                    specialRevisionActivity specialrevisionactivity4 = specialRevisionActivity.this;
                    specialrevisionactivity4.stateId = String.valueOf(asJsonObject.get(specialrevisionactivity4.stateIdText).getAsInt()).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(specialRevisionActivity.this.acIdText) != null) {
                    specialRevisionActivity specialrevisionactivity5 = specialRevisionActivity.this;
                    specialrevisionactivity5.acId = String.valueOf(asJsonObject.get(specialrevisionactivity5.acIdText).getAsInt()).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(specialRevisionActivity.this.districtIdText) != null) {
                    specialRevisionActivity specialrevisionactivity6 = specialRevisionActivity.this;
                    specialrevisionactivity6.districtId = String.valueOf(asJsonObject.get(specialrevisionactivity6.districtIdText).getAsInt()).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                Logger.d("SpecialRevisionTAG", "Payload --> acNo : " + specialRevisionActivity.this.asmblyNO);
                Logger.d("SpecialRevisionTAG", "Payload --> stateCd : " + specialRevisionActivity.this.state);
                Logger.d("SpecialRevisionTAG", "Payload --> districtCd : " + specialRevisionActivity.this.districtCode);
                Logger.d("SpecialRevisionTAG", "Payload --> stateId : " + specialRevisionActivity.this.stateId);
                Logger.d("SpecialRevisionTAG", "Payload --> acId : " + specialRevisionActivity.this.acId);
                Logger.d("SpecialRevisionTAG", "Payload --> districtId : " + specialRevisionActivity.this.districtId);
                Logger.d("SpecialRevisionTAG", "------ Fetching Data from fetchAllId API -- End ----");
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$7$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                specialRevisionActivity.this.getTotalForms();
                return;
            }
            if (response.code() == 401 || response.code() == 400) {
                CommomUtility commomUtility = specialRevisionActivity.this.commomUtility;
                ?? r8 = specialRevisionActivity.this;
                commomUtility.getRefreshToken(r8, ((specialRevisionActivity) r8).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$7$$ExternalSyntheticLambda4
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$3(i, str, str2);
                    }
                });
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$7$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$4();
                    }
                }, 2000L);
                return;
            }
            Logger.d("SpecialRevisionTAG", "In fetchAllId() -> else part ----> Response Body is null ");
            try {
                Logger.d("SpecialRevisionTAG", String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d("SpecialRevisionTAG", e.getMessage());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$7$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$5();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            specialRevisionActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity] */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity] */
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
        public /* synthetic */ void lambda$onResponse$3(int i, final String str, final String str2) {
            Logger.d("SpecialRevisionTAG", "RefreshToken" + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = specialRevisionActivity.this.commomUtility;
                ?? r5 = specialRevisionActivity.this;
                commomUtility.showMessageOK(r5, r5.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$7$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
            } else {
                CommomUtility commomUtility2 = specialRevisionActivity.this.commomUtility;
                ?? r0 = specialRevisionActivity.this;
                commomUtility2.showMessageOK(r0, r0.sessionExpiredTextForRefresh, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$7$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$2(str, str2, dialogInterface, i2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).setLocaleBool(false);
            specialRevisionActivity.this.startActivity(new Intent((Context) specialRevisionActivity.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(String str, String str2, DialogInterface dialogInterface, int i) {
            specialRevisionActivity.this.token = specialRevisionActivity.this.bearerText + str;
            specialRevisionActivity.this.refreshToken = str2;
            SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).setRefreshToken(str2);
            SharedPref.getInstance(specialRevisionActivity.this.getApplicationContext()).setToken(specialRevisionActivity.this.bearerText + str);
            specialRevisionActivity.this.fetchAllId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4() {
            specialRevisionActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$5() {
            specialRevisionActivity.this.alertDialog.dismiss();
        }

        public void onFailure(Call<EronetResonse> call, Throwable t) {
            Logger.d("SpecialRevisionTAG", "In fetchAllId() -> ON failure" + t.getMessage());
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity$7$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$6();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$6() {
            specialRevisionActivity.this.alertDialog.dismiss();
        }
    }

    public void getTotalForms() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
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
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList.add(Integer.valueOf(this.stateId));
        arrayList2.add(Integer.valueOf(this.districtId));
        arrayList3.add(Integer.valueOf(this.acNO));
        arrayList4.add(Integer.valueOf(this.part));
        map2.put("stateIds", arrayList);
        map2.put("groupByColumn", "PART_NO");
        map2.put("districtIds", arrayList2);
        map2.put("acNumbers", arrayList3);
        map2.put("partNumbers", arrayList4);
        Logger.d("SpecialRevisionTAG", "totalforms" + map2);
        this.service.getTotalFormElector(map, map2).enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity.8
            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                if (response.code() == 200) {
                    specialRevisionActivity.this.alertDialog.dismiss();
                    try {
                        if (response.body() != null) {
                            Logger.d("SpecialRevisionTAG", String.valueOf(response.body()));
                            JsonObject asJsonObject = specialRevisionActivity.this.gson.toJsonTree(((JSONArray) response.body()).get(0)).getAsJsonObject();
                            specialRevisionActivity.this.showDialog1("", String.valueOf(asJsonObject.get("efUploadByBlo").getAsInt()) + " out of " + String.valueOf(asJsonObject.get("totalElector").getAsInt()) + " forms are filled");
                        }
                    } catch (Exception e) {
                        Logger.d("SpecialRevisionTAG", e.toString());
                    }
                }
            }

            public void onFailure(Call<JSONArray> call, Throwable t) {
                specialRevisionActivity.this.alertDialog.dismiss();
                Logger.e("SpecialRevisionTAG", t.getMessage());
            }
        });
    }

    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.networkReceiver);
    }
}
