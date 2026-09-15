package in.gov.eci.bloapp.views.fragments.login;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentLoginBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.HybridEncryptor;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.Utils;
import in.gov.eci.bloapp.viewmodel.MainActivityViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import javax.inject.Inject;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class LoginFragment extends Hilt_LoginFragment {
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final String TAG = "BloFragmentLoginBinding";
    AlertDialog alertDialog;
    private BloFragmentLoginBinding binding;
    FusedLocationProviderClient fusedLocationProviderClient;
    private LocationRequest locationRequest;
    String mobileNo;
    String otp;
    String password;
    String userName;

    @Inject
    Utils utils;
    MainActivityViewModel viewModel;
    String pubKeyBase64 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArb7++BxL/YN8OIln+6FL9Gnw5DNmQ/VFZXss+J+TuQyJc891JbqbijxYQNEin2c2u+CnpXpoGQ/1gUSzDMJeNS3sNSlIUykp2dt7xIm/cmV4sZ/c769vCxVRosMfRaZJnBAah+m1X26lEhnOo0wpAB9Txr8RIyBe6h7PiQWykeJeh6UacOBBX28kgkq7+vJhW8HgB38lt32XRocznRYwS9LqR7ZweFmQhTr1+EGrqiEKCOCxMYgHR2SQckb96hZ9kWzfzeun4bUO5oXKJciLkiS1IgKieADEvYLgu129ZIpn1H+8H+8ikNNVETqEDDMtqcQcQmWppJvcWHaXAs+f8QIDAQAB";
    String nothingToDo = "Nothing to do";
    String requestPermission = "Request Permission";
    String packageBundle = "package";
    CommomUtility commomUtility = new CommomUtility();

    static /* synthetic */ void lambda$getCurrentLocation$4(Task task) {
    }

    @Deprecated
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentLoginBinding.inflate(getLayoutInflater());
        this.viewModel = (MainActivityViewModel) new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment.1
            public void handleOnBackPressed() {
                LoginFragment.this.requireActivity().finishAffinity();
            }
        });
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.CAMERA"};
        if (isNetworkAvailable(requireContext())) {
            if (!hasPermissions(requireContext(), strArr)) {
                ActivityCompat.requestPermissions(requireActivity(), strArr, 1);
            }
        } else {
            new android.app.AlertDialog.Builder(requireActivity()).setTitle("Alert").setMessage("Please check network").setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$$ExternalSyntheticLambda8
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    System.exit(0);
                }
            }).create().show();
        }
        this.binding.mobileNumEd.setLongClickable(false);
        this.binding.mobileNumEd.setTextIsSelectable(false);
        this.binding.passwordEd.setLongClickable(false);
        this.binding.passwordEd.setTextIsSelectable(false);
        this.binding.passwordEd.setText("Eci@1234");
        this.binding.passwordEd.setEnabled(false);
        this.binding.forgotPasswordTv.setVisibility(8);
        this.binding.appVersion.setText(getString(R.string.blo_version_no, new Object[]{BuildConfig.VERSION_NAME}));
        if (SharedPref.getInstance(requireContext()).getIsLoggedIn().booleanValue()) {
            startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
        }
        Logger.d("Login_Status", "Login Type1 ---- > " + SharedPref.getInstance(requireContext()).getLastLogin());
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(5000L);
        this.locationRequest.setFastestInterval(2000L);
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity());
        inputChanged();
        initCLickListener();
        return this.binding.getRoot();
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context == null || permissions == null) {
            return true;
        }
        for (String str : permissions) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    private void initCLickListener() {
        this.binding.requestOtpLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$2(view);
            }
        });
        this.binding.forgotPasswordTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$2(View view) {
        if (checkLocationPermission()) {
            if (ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
                if (isGPSEnabled()) {
                    if (validation()) {
                        getCurrentLocation();
                        if (isNetworkAvailable(requireContext())) {
                            this.alertDialog.show();
                            passwordFlow();
                            return;
                        } else {
                            Toast.makeText(requireContext(), "Please check network", 1).show();
                            return;
                        }
                    }
                    return;
                }
                turnOnGPS();
                startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
                return;
            }
            startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
            return;
        }
        new android.app.AlertDialog.Builder(requireActivity()).setTitle(this.requestPermission).setMessage("Kindly Allow Location Permission").setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$initCLickListener$1(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$1(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(this.packageBundle, requireActivity().getPackageName(), null));
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$3(View view) {
        openFragment(new FragmentForgotPassword());
    }

    public void getCurrentLocation() {
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(requireContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0 || ContextCompat.checkSelfPermission(requireContext(), "android.permission.ACCESS_NETWORK_STATE") == 0) {
            return;
        }
        this.fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$$ExternalSyntheticLambda0
            public final void onComplete(Task task) {
                LoginFragment.lambda$getCurrentLocation$4(task);
            }
        });
    }

    private void turnOnGPS() {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient(requireContext()).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$$ExternalSyntheticLambda1
            public final void onComplete(Task task) {
                this.f$0.lambda$turnOnGPS$5(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$turnOnGPS$5(Task task) {
        try {
            Log.d(TAG, "LocationSettingsResponse ---> " + ((LocationSettingsResponse) task.getResult(ApiException.class)));
            Toast.makeText((Context) requireActivity(), (CharSequence) "GPS is already turned on", 0).show();
        } catch (ApiException e) {
            int statusCode = e.getStatusCode();
            if (statusCode != 6) {
                if (statusCode == 8502) {
                    Log.d(TAG, "Device does not have location");
                }
            } else {
                try {
                    e.startResolutionForResult(requireActivity(), 2);
                } catch (IntentSender.SendIntentException e2) {
                    Logger.d(TAG, "turnOnGPS exception --> " + e2.getMessage());
                }
            }
        }
    }

    private void passwordFlow() {
        this.userName = ((Editable) Objects.requireNonNull(this.binding.mobileNumEd.getText())).toString();
        this.password = ((Editable) Objects.requireNonNull(this.binding.passwordEd.getText())).toString();
        HashMap map = new HashMap();
        map.put("applicationName", "GARUDA");
        map.put("password", this.password);
        map.put("roleCode", "*");
        map.put("username", this.userName);
        try {
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).eroPasswordFlow("ANDROIDMOB", HybridEncryptor.hybridEncrypt(new JSONObject(map).toString(), this.pubKeyBase64)).enqueue(new AnonymousClass2());
        } catch (Exception e) {
            this.alertDialog.dismiss();
            Log.d(TAG, e.toString());
            Toast.makeText(requireContext(), "Something went wrong", 1);
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.LoginFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<EronetResponse> {
        AnonymousClass2() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                LoginFragment.this.otpSendToUser();
            } else {
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                    Logger.d(LoginFragment.TAG, "eroPasswordFlow errorResponse --> " + strOptString);
                    LoginFragment.this.commomUtility.showMessageWithTitleOK(LoginFragment.this.requireContext(), "Login - " + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$2$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                } catch (IOException | JSONException e) {
                    LoginFragment.this.commomUtility.showMessageWithTitleOK(LoginFragment.this.requireContext(), "Login - " + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$2$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    Logger.d(LoginFragment.TAG, "eroPasswordFlow exception --> " + e.getMessage());
                }
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$2$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$2();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            LoginFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Log.d(LoginFragment.TAG, LoginFragment.this.nothingToDo);
            LoginFragment.this.alertDialog.dismiss();
            if (t instanceof SSLHandshakeException) {
                Toast.makeText(LoginFragment.this.requireContext(), "SSL Handshake Exception: ", 1).show();
                return;
            }
            if (t instanceof IOException) {
                Toast.makeText(LoginFragment.this.requireContext(), "Network Error ", 1);
            } else if (t instanceof SSLProtocolException) {
                Toast.makeText(LoginFragment.this.requireContext(), "TLS version ", 1);
            } else {
                Toast.makeText(LoginFragment.this.requireContext(), "Unexpected Error: ", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void otpSendToUser() {
        this.otp = "000000";
        HashMap map = new HashMap();
        map.put("applicationName", "GARUDA");
        map.put("roleCode", "*");
        map.put("username", this.userName);
        try {
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).eroSendOtp("ANDROIDMOB", HybridEncryptor.hybridEncrypt(new JSONObject(map).toString(), this.pubKeyBase64)).enqueue(new AnonymousClass3());
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.LoginFragment$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<EronetResponse> {
        AnonymousClass3() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                SharedPref.getInstance(LoginFragment.this.requireContext()).setUserName(LoginFragment.this.userName);
                SharedPref.getInstance(LoginFragment.this.requireContext()).setPassword(LoginFragment.this.password);
                LoginFragment loginFragment = LoginFragment.this;
                loginFragment.mobileNo = ((Editable) Objects.requireNonNull(loginFragment.binding.mobileNumEd.getText())).toString();
                Logger.d("mobileNo", LoginFragment.this.mobileNo);
                Bundle bundle = new Bundle();
                bundle.putString("mobileNo", LoginFragment.this.mobileNo);
                bundle.putString("userName", LoginFragment.this.userName);
                bundle.putString("password", LoginFragment.this.password);
                bundle.putString("otp", LoginFragment.this.otp);
                OTPFragment oTPFragment = new OTPFragment();
                oTPFragment.setArguments(bundle);
                LoginFragment.this.openFragment(oTPFragment);
                Toast.makeText(LoginFragment.this.requireContext(), ((EronetResponse) response.body()).getMessage(), 1).show();
            } else {
                try {
                    LoginFragment.this.commomUtility.showMessageWithTitleOK(LoginFragment.this.requireContext(), "Login - " + response.code(), new JSONObject(response.errorBody().string()).optString("message"), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$3$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                } catch (IOException | JSONException e) {
                    LoginFragment.this.commomUtility.showMessageWithTitleOK(LoginFragment.this.requireContext(), "Login  - " + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$3$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    Logger.d(LoginFragment.TAG, "getEronetLogin exception --> " + e.getMessage());
                }
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$3$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$2();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            LoginFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Toast.makeText(LoginFragment.this.requireContext(), "Error", 1).show();
        }
    }

    private boolean isGPSEnabled() {
        return ((LocationManager) ((FragmentActivity) Objects.requireNonNull(requireActivity())).getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        if (!ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.ACCESS_FINE_LOCATION")) {
            return false;
        }
        new android.app.AlertDialog.Builder(requireActivity()).setTitle(this.requestPermission).setMessage("Kindly Allow Location Permission").setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkLocationPermission$6(dialogInterface, i);
            }
        }).create().show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkLocationPermission$6(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(this.packageBundle, requireActivity().getPackageName(), null));
        startActivity(intent);
    }

    private boolean validation() {
        String string = this.binding.mobileNumEd.getText().toString();
        String string2 = ((Editable) Objects.requireNonNull(this.binding.mobileNumEd.getText())).toString();
        String string3 = ((Editable) Objects.requireNonNull(this.binding.passwordEd.getText())).toString();
        if (ContextCompat.checkSelfPermission(requireActivity(), "android.permission.CAMERA") != 0) {
            new android.app.AlertDialog.Builder(requireActivity()).setTitle(this.requestPermission).setMessage("Kindly Allow Camera Permission").setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$$ExternalSyntheticLambda9
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$validation$7(dialogInterface, i);
                }
            }).create().show();
            return false;
        }
        if (string.isEmpty()) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), "Incorrect Details", "Please enter mobile number/Blo Supervisor detail");
            return false;
        }
        if (Character.isDigit(string.charAt(0)) && (string3.isEmpty() || string2.length() != 10)) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), "Incorrect Details", "The mobile number or password is incorrect, Try again");
            return false;
        }
        if (Character.isDigit(string.charAt(0)) && !isValidNumber(string2)) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), "Incorrect Details", "The mobile number is incorrect, Try again");
            return false;
        }
        if (Character.isDigit(string.charAt(0))) {
            return true;
        }
        if (!string3.isEmpty() && string2.length() >= 9) {
            return true;
        }
        this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), "Incorrect Details", "Please enter valid BLO Supervisor detail, Try again");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$validation$7(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(this.packageBundle, requireActivity().getPackageName(), null));
        startActivity(intent);
    }

    private boolean isValidNumber(String mobileNum) {
        return Patterns.PHONE.matcher(mobileNum).matches();
    }

    private void inputChanged() {
        this.binding.passwordEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (LoginFragment.this.binding.passwordEd.length() > 0) {
                    LoginFragment.this.binding.textsingleSelect.setEndIconMode(1);
                } else {
                    LoginFragment.this.binding.textsingleSelect.setEndIconMode(0);
                }
            }
        });
        this.binding.mobileNumEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment.5
            boolean isUpdating = false;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    LoginFragment.this.binding.mobileNumEd.setInputType(1);
                    LoginFragment.this.binding.mobileNumEd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    return;
                }
                if (Character.isDigit(s.charAt(0))) {
                    LoginFragment.this.binding.mobileNumEd.setInputType(2);
                    LoginFragment.this.binding.mobileNumEd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
                } else {
                    LoginFragment.this.binding.mobileNumEd.setInputType(1);
                    LoginFragment.this.binding.mobileNumEd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                }
                LoginFragment.this.binding.mobileNumEd.setSelection(LoginFragment.this.binding.mobileNumEd.getText().length());
            }
        });
        final InputFilter inputFilter = new InputFilter() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$$ExternalSyntheticLambda3
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return LoginFragment.lambda$inputChanged$8(charSequence, i, i2, spanned, i3, i4);
            }
        };
        final InputFilter inputFilter2 = new InputFilter() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment$$ExternalSyntheticLambda4
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return LoginFragment.lambda$inputChanged$9(charSequence, i, i2, spanned, i3, i4);
            }
        };
        this.binding.mobileNumEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.login.LoginFragment.6
            boolean isUpdating = false;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (this.isUpdating || s.length() == 0) {
                    return;
                }
                this.isUpdating = true;
                if (Character.isDigit(s.charAt(0))) {
                    LoginFragment.this.binding.mobileNumEd.setInputType(2);
                    LoginFragment.this.binding.mobileNumEd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10), inputFilter});
                } else {
                    LoginFragment.this.binding.mobileNumEd.setInputType(1);
                    LoginFragment.this.binding.mobileNumEd.setFilters(new InputFilter[]{inputFilter2});
                }
                LoginFragment.this.binding.mobileNumEd.setSelection(LoginFragment.this.binding.mobileNumEd.getText().length());
                this.isUpdating = false;
            }
        });
    }

    static /* synthetic */ CharSequence lambda$inputChanged$8(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (charSequence.toString().matches("[0-9]*")) {
            return null;
        }
        return "";
    }

    static /* synthetic */ CharSequence lambda$inputChanged$9(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (charSequence.toString().matches("[a-zA-Z0-9]*")) {
            return null;
        }
        return "";
    }

    void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, TAG);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4100);
        fragmentTransactionBeginTransaction.commit();
    }
}
