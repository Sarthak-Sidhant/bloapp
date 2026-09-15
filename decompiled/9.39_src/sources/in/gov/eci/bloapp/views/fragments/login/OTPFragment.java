package in.gov.eci.bloapp.views.fragments.login;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentOtpBinding;
import in.gov.eci.bloapp.utils.HybridEncryptor;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class OTPFragment extends Hilt_OTPFragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "BloFragmentOtpBinding";
    static String asmblyNO = "";
    static String email = "NA";
    static String familyName = "";
    static String givenName = "";
    static String name = "";
    static String phoneNumber = "";
    static String preferredUsername = "NA";
    private static String sessionState = "";
    static String stateCode = "";
    static String totalPartNumber = "";
    AlertDialog alertDialog;
    BloFragmentOtpBinding binding;
    String fcmToken;
    private String firstTimeLogin;
    String mobileNo;
    String otp;
    String password;
    String userName;
    CountDownTimer waitTimer;
    String pubKeyBase64 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArb7++BxL/YN8OIln+6FL9Gnw5DNmQ/VFZXss+J+TuQyJc891JbqbijxYQNEin2c2u+CnpXpoGQ/1gUSzDMJeNS3sNSlIUykp2dt7xIm/cmV4sZ/c769vCxVRosMfRaZJnBAah+m1X26lEhnOo0wpAB9Txr8RIyBe6h7PiQWykeJeh6UacOBBX28kgkq7+vJhW8HgB38lt32XRocznRYwS9LqR7ZweFmQhTr1+EGrqiEKCOCxMYgHR2SQckb96hZ9kWzfzeun4bUO5oXKJciLkiS1IgKieADEvYLgu129ZIpn1H+8H+8ikNNVETqEDDMtqcQcQmWppJvcWHaXAs+f8QIDAQAB";
    String applicationName = "applicationName";
    String garuda = "Garuda";
    String userNameText = "username";
    String roleCode = "roleCode";
    String message = "message";
    String error = "Error";
    ArrayList<String> duplicateOtpNumberCheckList = new ArrayList<>();
    String token = "";
    String nothingToDo = "Nothing to do";
    String checkTokenValue = "";
    String errorResponse = "";
    String device_id = "";
    final CommomUtility commomUtility = new CommomUtility();
    String refreshtoken = "";
    String firstTimeTokenGenerated = "";
    String passwordBundle = "password";
    int attemptsLeft = 4;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentOtpBinding.inflate(getLayoutInflater());
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment.1
            public void handleOnBackPressed() {
                OTPFragment.this.openFragment(new LoginFragment());
            }
        });
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.duplicateOtpNumberCheckList.clear();
        this.binding.pinView.setLongClickable(false);
        this.binding.pinView.setTextIsSelectable(false);
        pinView();
        initCLickListener();
        otpTimer();
        Bundle arguments = getArguments();
        this.mobileNo = arguments.getString("mobileNo");
        this.userName = arguments.getString("userName");
        this.password = arguments.getString(this.passwordBundle);
        this.otp = arguments.getString("otp");
        Logger.d(TAG, "userName ---> " + this.userName);
        Logger.d(TAG, "password ---> " + this.password);
        Logger.d(TAG, "signup_otp emailid ---> " + this.mobileNo);
        this.binding.mobileno.setText("+91 " + this.mobileNo);
        fetchFcmToken();
        return this.binding.getRoot();
    }

    private void initCLickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$0(view);
            }
        });
        this.binding.verifyOtpLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$3(view);
            }
        });
        this.binding.otpTimer.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$0(View view) {
        openFragment(new LoginFragment());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$3(View view) {
        this.alertDialog.show();
        if (validation()) {
            int i = 0;
            for (int i2 = 0; i2 < this.duplicateOtpNumberCheckList.size(); i2++) {
                if (Objects.equals(this.duplicateOtpNumberCheckList.get(i2), ((Editable) Objects.requireNonNull(this.binding.pinView.getText())).toString())) {
                    i++;
                }
            }
            if (i == 0) {
                tokenReceivedFlow();
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$initCLickListener$1();
                    }
                }, 2000L);
                this.commomUtility.showMessageWithTitleOK(requireContext(), "OTP Error - ", "Don't enter same wrong otp again", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        dialogInterface.dismiss();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$1() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$4(View view) {
        if (this.binding.otpTimer.getText().toString().equals("Resend OTP!")) {
            Log.d(TAG, "InsideResendOTP!");
            passwordFlow();
            otpTimer();
        }
    }

    private void pinView() {
        this.binding.pinView.requestFocus();
        this.binding.pinView.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(OTPFragment.TAG, OTPFragment.this.nothingToDo);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                View currentFocus;
                if (OTPFragment.this.binding.pinView.length() != 6 || (currentFocus = OTPFragment.this.requireActivity().getCurrentFocus()) == null) {
                    return;
                }
                ((InputMethodManager) OTPFragment.this.requireActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Log.d(OTPFragment.TAG, OTPFragment.this.nothingToDo);
            }
        });
    }

    private boolean validation() {
        if (this.binding.pinView.length() == 6) {
            return true;
        }
        this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), "Enter OTP", "Please enter OTP");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r6v0, types: [in.gov.eci.bloapp.views.fragments.login.OTPFragment$3] */
    public void otpTimer() {
        this.waitTimer = new CountDownTimer(180000L, 1000L) { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment.3
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                OTPFragment.this.binding.otpTimer.setText("Resend OTP in " + String.format("%d:%d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                OTPFragment.this.attemptsLeft = 4;
                OTPFragment.this.binding.otpTimer.setText("Resend OTP!");
                OTPFragment.this.binding.pinView.setText("");
                OTPFragment.this.binding.pinView.setEnabled(false);
                OTPFragment.this.binding.verifyOtpLayout.setEnabled(false);
                OTPFragment.this.binding.verifyOtpLayout.setBackgroundResource(R.drawable.blo_btn2);
                OTPFragment.this.duplicateOtpNumberCheckList.clear();
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void otpSendToUser() {
        this.otp = ((Editable) Objects.requireNonNull(this.binding.pinView.getText())).toString();
        HashMap map = new HashMap();
        map.put(this.applicationName, "GARUDA");
        map.put(this.roleCode, "*");
        map.put(this.userNameText, this.userName);
        try {
            Map<String, String> mapHybridEncrypt = HybridEncryptor.hybridEncrypt(new JSONObject(map).toString(), this.pubKeyBase64);
            Log.d(TAG, "otp-flow-send Api otp-flow-send Body ---> " + map);
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).eroSendOtp("ANDROIDMOB", mapHybridEncrypt).enqueue(new AnonymousClass4());
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.OTPFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<EronetResponse> {
        AnonymousClass4() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.body() != null) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$4$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                Toast.makeText(OTPFragment.this.requireContext(), ((EronetResponse) response.body()).getMessage(), 1).show();
                OTPFragment.this.binding.pinView.setEnabled(true);
                OTPFragment.this.binding.verifyOtpLayout.setEnabled(true);
                OTPFragment.this.binding.verifyOtpLayout.setBackgroundResource(R.drawable.blo_btn);
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$4$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$1();
                }
            }, 2000L);
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                OTPFragment oTPFragment = OTPFragment.this;
                oTPFragment.errorResponse = jSONObject.optString(oTPFragment.message);
                Log.d(OTPFragment.TAG, "OTP Api Error otp-flow-send ---> " + OTPFragment.this.errorResponse);
                OTPFragment.this.commomUtility.displayAlertWithTitleAndMessage(OTPFragment.this.requireContext(), "OTP Api Error otp-flow-send " + response.code(), OTPFragment.this.errorResponse);
                Toast.makeText(OTPFragment.this.requireContext(), OTPFragment.this.errorResponse, 1).show();
            } catch (IOException | JSONException e) {
                OTPFragment.this.commomUtility.showMessageWithTitleOK(OTPFragment.this.requireContext(), "OTP Exception Error otp-flow-send ", e.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$4$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                Logger.d(OTPFragment.TAG, "OTP Exception Error otp-flow-send ---> " + e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            OTPFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            OTPFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$3() {
            OTPFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$3();
                }
            }, 2000L);
            Toast.makeText(OTPFragment.this.requireContext(), OTPFragment.this.error, 1).show();
        }
    }

    private static String getJson(String strEncoded) throws UnsupportedEncodingException {
        return new String(Base64.decode(strEncoded, 8), StandardCharsets.UTF_8);
    }

    public static void decoded(String JWTEncoded) throws Exception {
        try {
            String[] strArrSplit = JWTEncoded.split("\\.");
            Logger.d(TAG, "JWT_DECODED Header: " + getJson(strArrSplit[0]));
            Logger.d(TAG, "JWT_DECODED Body: " + getJson(strArrSplit[1]));
            JSONObject jSONObject = new JSONObject(getJson(strArrSplit[1]));
            preferredUsername = jSONObject.getString("preferred_username").replaceAll("[^A-Za-z0-9-]", "");
            sessionState = jSONObject.getString("session_state").replaceAll("[^A-Za-z0-9-]", "");
            stateCode = jSONObject.getString("authorizedStates").replaceAll(RegexMatcher.TOKEN_REGEX, "");
            name = jSONObject.getString("name").replaceAll(RegexMatcher.TOKEN_REGEX, "");
            asmblyNO = jSONObject.getString("authorizedAcs").replaceAll(RegexMatcher.TOKEN_REGEX, "");
            givenName = jSONObject.getString("given_name").replaceAll(RegexMatcher.TOKEN_REGEX, "");
            totalPartNumber = jSONObject.getString("authorizedParts").replaceAll(RegexMatcher.TOKEN_REGEX, "");
            familyName = jSONObject.getString("family_name").replaceAll(RegexMatcher.TOKEN_REGEX, "");
            phoneNumber = jSONObject.getString("phone_number").replaceAll(RegexMatcher.TOKEN_REGEX, "");
            Log.d(TAG, "Part Number " + totalPartNumber);
            Log.d(TAG, "preferredUsername " + preferredUsername + " stateCode " + stateCode + " name " + name + " phoneNumber " + phoneNumber + " asmblyNO " + asmblyNO + " givenName " + givenName + " partNumber " + totalPartNumber + " familyName " + familyName + " email " + email + " sessionState " + sessionState);
        } catch (UnsupportedEncodingException e) {
            Log.d(TAG, "UnsupportedEncodingException " + e.getMessage());
        }
    }

    private void tokenReceivedFlow() {
        this.otp = ((Editable) Objects.requireNonNull(this.binding.pinView.getText())).toString();
        HashMap map = new HashMap();
        map.put(this.applicationName, "GARUDA");
        map.put("otp", this.otp);
        map.put(this.passwordBundle, this.password);
        map.put(this.roleCode, "*");
        map.put(this.userNameText, this.userName);
        Log.d(TAG, "otp-flow-verify Api Body ---> " + map);
        try {
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).eroTokenReceived("ANDROIDMOB", HybridEncryptor.hybridEncrypt(new JSONObject(map).toString(), this.pubKeyBase64)).enqueue(new AnonymousClass5());
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.OTPFragment$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<EronetResponse> {
        AnonymousClass5() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() != 200) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$5$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$1();
                    }
                }, 2000L);
                if (OTPFragment.this.attemptsLeft <= 1) {
                    OTPFragment.this.waitTimer.cancel();
                    OTPFragment.this.waitTimer = null;
                    OTPFragment.this.binding.verifyOtpLayout.setEnabled(false);
                    OTPFragment.this.binding.verifyOtpLayout.setBackgroundResource(R.drawable.blo_btn2);
                    OTPFragment.this.commomUtility.showMessageWithTitleOK(OTPFragment.this.requireContext(), "Alert", "No attempts left, Please try new OTP", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$5$$ExternalSyntheticLambda6
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    OTPFragment.this.otpTimer();
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    OTPFragment oTPFragment = OTPFragment.this;
                    oTPFragment.errorResponse = jSONObject.optString(oTPFragment.message);
                    if (OTPFragment.this.errorResponse.equalsIgnoreCase("OTP doesnt match! Please try again.")) {
                        OTPFragment.this.attemptsLeft--;
                    }
                    Logger.d(OTPFragment.TAG, "OTP Api Error otp-flow-verify ---> " + OTPFragment.this.errorResponse);
                    if (OTPFragment.this.errorResponse.equals("OTP doesnt match! Please try again.")) {
                        OTPFragment.this.duplicateOtpNumberCheckList.add(((Editable) Objects.requireNonNull(OTPFragment.this.binding.pinView.getText())).toString());
                    } else if (OTPFragment.this.errorResponse.equals("OTP expired! Please try again.")) {
                        OTPFragment.this.duplicateOtpNumberCheckList.clear();
                    }
                    OTPFragment.this.commomUtility.showMessageWithTitleOK(OTPFragment.this.requireContext(), "OTP Api Error otp-flow-verify " + response.code(), OTPFragment.this.errorResponse + "\n\nNumber of Attempts Left " + OTPFragment.this.attemptsLeft, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$5$$ExternalSyntheticLambda4
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                } catch (IOException | JSONException e) {
                    Logger.d(OTPFragment.TAG, "OTP Exception Error otp-flow-verify ---> " + e.getMessage());
                    OTPFragment.this.commomUtility.showMessageWithTitleOK(OTPFragment.this.requireContext(), "OTP Exception Error otp-flow-verify ", e.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$5$$ExternalSyntheticLambda5
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            }
            OTPFragment.this.checkTokenValue = ((EronetResponse) response.body()).getAccess_token();
            OTPFragment.this.refreshtoken = ((EronetResponse) response.body()).getRefresh_token();
            OTPFragment.this.token = "Bearer " + ((EronetResponse) response.body()).getAccess_token();
            OTPFragment.this.firstTimeTokenGenerated = "Bearer " + ((EronetResponse) response.body()).getAccess_token();
            OTPFragment.this.firstTimeLogin = ((EronetResponse) response.body()).getFirstTimeLogin();
            Logger.d(OTPFragment.TAG, "firstTimeTokenGenerated ---> " + OTPFragment.this.firstTimeTokenGenerated);
            Logger.d(OTPFragment.TAG, "OTPFragment ---> " + OTPFragment.this.refreshtoken);
            if (OTPFragment.this.firstTimeLogin.equalsIgnoreCase("Y") || OTPFragment.this.firstTimeLogin.equalsIgnoreCase("M")) {
                SharedPref.getInstance(OTPFragment.this.requireContext()).setLastLogin("N");
            } else {
                SharedPref.getInstance(OTPFragment.this.requireContext()).setLastLogin("Y");
            }
            try {
                OTPFragment.decoded(OTPFragment.this.checkTokenValue);
            } catch (Exception e2) {
                Logger.d(OTPFragment.TAG, "tokenReceivedFlow exception --> " + e2.getMessage());
            }
            SharedPref.getInstance(OTPFragment.this.requireContext()).setPreferredUsername(OTPFragment.preferredUsername);
            SharedPref.getInstance(OTPFragment.this.requireContext()).setSessionState(OTPFragment.sessionState);
            SharedPref.getInstance(OTPFragment.this.requireContext()).setUserName(OTPFragment.this.userName);
            SharedPref.getInstance(OTPFragment.this.requireContext()).setPassword(OTPFragment.this.password);
            SharedPref.getInstance(OTPFragment.this.requireContext()).setStateCode(OTPFragment.stateCode);
            SharedPref.getInstance(OTPFragment.this.requireContext()).setName(OTPFragment.name);
            SharedPref.getInstance(OTPFragment.this.requireContext()).setPhoneNumber(OTPFragment.phoneNumber);
            SharedPref.getInstance(OTPFragment.this.requireContext()).setAssemblyNumber(OTPFragment.asmblyNO);
            SharedPref.getInstance(OTPFragment.this.requireContext()).setGivenName(OTPFragment.givenName);
            SharedPref.getInstance(OTPFragment.this.requireContext()).setTotalPartNumber(OTPFragment.totalPartNumber);
            SharedPref.getInstance(OTPFragment.this.requireContext()).setFamilyName(OTPFragment.familyName);
            SharedPref.getInstance(OTPFragment.this.requireContext()).setEmail(OTPFragment.email);
            SharedPref.getInstance(OTPFragment.this.requireContext()).setToken(OTPFragment.this.firstTimeTokenGenerated);
            SharedPref.getInstance(OTPFragment.this.requireContext()).setRefreshToken(OTPFragment.this.refreshtoken);
            SharedPref.getInstance(OTPFragment.this.requireContext()).setAtknBnd(((EronetResponse) response.body()).getAtknBnd());
            SharedPref.getInstance(OTPFragment.this.requireContext()).setRtknBnd(((EronetResponse) response.body()).getRtknBnd());
            SharedPref.getInstance(OTPFragment.this.requireContext()).setLastLogin("Y");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$5$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$0();
                }
            }, 100L);
            if (!SharedPref.getInstance(OTPFragment.this.requireContext()).getLastLogin().equals("N")) {
                OTPFragment.this.sendFcmTokenToServer();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("userName", OTPFragment.this.userName);
            bundle.putString(OTPFragment.this.passwordBundle, OTPFragment.this.password);
            FragmentSetPassword fragmentSetPassword = new FragmentSetPassword();
            fragmentSetPassword.setArguments(bundle);
            OTPFragment.this.openFragment(fragmentSetPassword);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            OTPFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            OTPFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$5() {
            OTPFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$5$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$5();
                }
            }, 2000L);
            AlertDialog.Builder builder = new AlertDialog.Builder(OTPFragment.this.requireContext());
            builder.setTitle("OTP");
            builder.setMessage("Request timeout, Please re-send the OTP");
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$5$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFcmTokenToServer() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        map.put("currentRole", "blo");
        map.put("Content-Type", "application/json");
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put(this.applicationName, "GARUDA");
        map2.put("platformType", "ANDROIDMOB");
        map2.put("roleCd", "blo");
        map2.put("loginName", this.userName);
        map2.put("userId", preferredUsername);
        map2.put("stateCd", stateCode);
        map2.put("acNo", asmblyNO);
        map2.put("pushToken", this.fcmToken);
        map2.put("deviceId", getDeviceIdd());
        try {
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).registerFCMToken(map, map2).enqueue(new Callback<EronetResponse>() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment.6
                public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
                    OTPFragment.this.openFragment(new FragmentPartNumberSelection());
                }

                public void onFailure(Call<EronetResponse> call, Throwable t) {
                    OTPFragment.this.openFragment(new FragmentPartNumberSelection());
                }
            });
        } catch (Exception e) {
            openFragment(new FragmentPartNumberSelection());
            Log.d(TAG, e.toString());
        }
    }

    private void passwordFlow() {
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put(this.applicationName, "GARUDA");
        map.put(this.passwordBundle, this.password);
        map.put(this.roleCode, "*");
        map.put(this.userNameText, this.userName);
        Log.d(TAG, "password-flow Api Body ---> " + map);
        try {
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).eroPasswordFlow("ANDROIDMOB", HybridEncryptor.hybridEncrypt(new JSONObject(map).toString(), this.pubKeyBase64)).enqueue(new AnonymousClass7());
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.OTPFragment$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<EronetResponse> {
        AnonymousClass7() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                OTPFragment.this.otpSendToUser();
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$7$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$0();
                }
            }, 2000L);
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                OTPFragment oTPFragment = OTPFragment.this;
                oTPFragment.errorResponse = jSONObject.optString(oTPFragment.message);
                Log.d(OTPFragment.TAG, "OTP Api Error password-flow ---> " + OTPFragment.this.errorResponse);
                OTPFragment.this.commomUtility.displayAlertWithTitleAndMessage(OTPFragment.this.requireContext(), "OTP Api Error password-flow " + response.code(), OTPFragment.this.errorResponse);
            } catch (IOException | JSONException e) {
                OTPFragment.this.commomUtility.showMessageWithTitleOK(OTPFragment.this.requireContext(), "OTP Exception Error password-flow ", e.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$7$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                Logger.d(OTPFragment.TAG, "eroPasswordFlow exception --> " + e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            OTPFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$2() {
            OTPFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$7$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$2();
                }
            }, 2000L);
            Toast.makeText(OTPFragment.this.requireContext(), OTPFragment.this.error, 1).show();
            OTPFragment.this.commomUtility.displayAlertWithTitleAndMessage(OTPFragment.this.requireContext(), OTPFragment.this.error, "Error occurred, Try again");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, "Login Fragment");
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4100);
        fragmentTransactionBeginTransaction.commit();
    }

    private void fetchFcmToken() {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.login.OTPFragment$$ExternalSyntheticLambda5
            public final void onComplete(Task task) {
                this.f$0.lambda$fetchFcmToken$5(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchFcmToken$5(Task task) {
        if (!task.isSuccessful()) {
            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
        } else {
            this.fcmToken = (String) task.getResult();
            Log.d(TAG, "FCM token: " + this.fcmToken);
        }
    }

    public String getDeviceIdd() {
        return Settings.Secure.getString(requireContext().getContentResolver(), "android_id");
    }
}
