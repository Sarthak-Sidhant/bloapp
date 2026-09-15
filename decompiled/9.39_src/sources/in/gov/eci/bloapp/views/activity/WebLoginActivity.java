package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityWebLoginBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.newsir.model.AsdActionrRoot;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class WebLoginActivity extends SuperBaseActivity {
    private static final int REQUEST_CODE_CAMERA_PORTRAIT = 1221;
    private String acNo;
    AlertDialog alertDialog;
    private String atkband;
    ActivityWebLoginBinding binding;
    String lat;
    private double latitude;
    private LocationRequest locationRequest;
    String longi;
    private double longitude;
    private String partNo;
    private String refreshToken;
    private String rtkband;
    UserClient service;
    private String state;
    private String token;
    Utils utils;
    CommomUtility commomUtility = new CommomUtility();
    String SESSION = "";
    private final String TAG = "WebLogin";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityWebLoginBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.service = (UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class);
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.acNo = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.utils = new Utils();
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(1000L);
        this.locationRequest.setFastestInterval(1000L);
        this.binding.btScanCode.setEnabled(false);
        this.binding.btScanCode.setBackgroundColor(getResources().getColor(R.color.blo_light_grey));
        initClickListener();
        getCurrentLocation();
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        this.binding.heading2.setText(Html.fromHtml(getString(R.string.webLogin_heading2)));
        this.binding.heading2.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.WebLoginActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$0(view);
            }
        });
        this.binding.btScanCode.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.WebLoginActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WebLoginActivity.this.cameraPermission();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$0(View view) {
        finish();
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
            if (!TextUtils.isEmpty(contents)) {
                apiCallWithQrSessionId(contents);
                return;
            } else {
                showDialog1("Alert", "Invalid QR code");
                return;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length <= 0 || grantResults[0] != 0) {
            showToast("Camera permission cancelled!");
        } else if (requestCode == REQUEST_CODE_CAMERA_PORTRAIT) {
            initScanner();
        } else if (requestCode == 1) {
            getCurrentLocation();
        }
    }

    private void apiCallWithQrSessionId(String scannedData) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("sessionId", scannedData);
        map2.put("latitude", this.lat);
        map2.put("longitude", this.longi);
        Call<AsdActionrRoot> callUpdateQRSessionId = this.service.updateQRSessionId(map, map2);
        this.alertDialog.show();
        callUpdateQRSessionId.enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.WebLoginActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<AsdActionrRoot> {
        AnonymousClass2() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v7, types: [android.content.Context, in.gov.eci.bloapp.views.activity.WebLoginActivity] */
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
        public void onResponse(Call<AsdActionrRoot> call, Response<AsdActionrRoot> response) {
            if (response.isSuccessful() && response.body() != null) {
                try {
                    WebLoginActivity.this.alertDialog.dismiss();
                    WebLoginActivity.this.showDialog2("Alert", ((AsdActionrRoot) response.body()).getMessage() != null ? ((AsdActionrRoot) response.body()).getMessage() : "");
                    return;
                } catch (Exception unused) {
                    WebLoginActivity.this.alertDialog.dismiss();
                    return;
                }
            }
            if (response.code() == 401) {
                if (WebLoginActivity.this.alertDialog != null) {
                    WebLoginActivity.this.alertDialog.dismiss();
                }
                CommomUtility commomUtility = WebLoginActivity.this.commomUtility;
                ?? r5 = WebLoginActivity.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.WebLoginActivity$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i);
                    }
                });
                return;
            }
            try {
                if (WebLoginActivity.this.alertDialog != null) {
                    WebLoginActivity.this.alertDialog.dismiss();
                }
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                WebLoginActivity.this.showDialog1("Alert", strOptString);
                Logger.e("WebLogin", strOptString);
            } catch (IOException | JSONException e) {
                if (WebLoginActivity.this.alertDialog != null) {
                    WebLoginActivity.this.alertDialog.dismiss();
                }
                Logger.e("WebLogin", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(WebLoginActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(WebLoginActivity.this.getApplicationContext()).setLocaleBool(false);
            WebLoginActivity.this.startActivity(new Intent(WebLoginActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<AsdActionrRoot> call, Throwable t) {
            if (WebLoginActivity.this.alertDialog != null) {
                WebLoginActivity.this.alertDialog.dismiss();
            }
            Logger.e("pendingElectors", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.WebLoginActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$1(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$1(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog2(String alertText, String message) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.WebLoginActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$2(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$2(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (isGPSEnabled()) {
                LocationServices.getFusedLocationProviderClient(this).requestLocationUpdates(this.locationRequest, new LocationCallback() { // from class: in.gov.eci.bloapp.views.activity.WebLoginActivity.3
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(WebLoginActivity.this).removeLocationUpdates(this);
                        if (locationResult == null || locationResult.getLocations().isEmpty()) {
                            return;
                        }
                        int size = locationResult.getLocations().size() - 1;
                        WebLoginActivity.this.latitude = ((Location) locationResult.getLocations().get(size)).getLatitude();
                        WebLoginActivity.this.longitude = ((Location) locationResult.getLocations().get(size)).getLongitude();
                        WebLoginActivity.this.lat = String.valueOf(((Location) locationResult.getLocations().get(size)).getLatitude());
                        WebLoginActivity.this.longi = String.valueOf(((Location) locationResult.getLocations().get(size)).getLongitude());
                        Logger.d("latitude and longitudezz", WebLoginActivity.this.lat + "  " + WebLoginActivity.this.longi);
                        if (TextUtils.isEmpty(WebLoginActivity.this.lat) || TextUtils.isEmpty(WebLoginActivity.this.longi)) {
                            return;
                        }
                        WebLoginActivity.this.binding.btScanCode.setEnabled(true);
                        WebLoginActivity.this.binding.btScanCode.setBackgroundColor(WebLoginActivity.this.getResources().getColor(R.color.button_color_sir));
                    }
                }, Looper.getMainLooper());
                return;
            } else {
                turnOnGPS();
                return;
            }
        }
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    private void turnOnGPS() {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient(getApplicationContext()).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.activity.WebLoginActivity$$ExternalSyntheticLambda2
            public final void onComplete(Task task) {
                this.f$0.lambda$turnOnGPS$3(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$turnOnGPS$3(Task task) {
        try {
            Toast.makeText((Context) this, (CharSequence) "GPS is already tured on", 0).show();
        } catch (ApiException e) {
            if (e.getStatusCode() != 6) {
                return;
            }
            try {
                e.startResolutionForResult(this, 2);
            } catch (IntentSender.SendIntentException e2) {
                Logger.d("", e2.getMessage());
            }
        }
    }

    private boolean isGPSEnabled() {
        return ((LocationManager) getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }
}
