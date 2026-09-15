package in.gov.eci.bloapp.views.fragments.login;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentForgotpasswordPinBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.Utils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FragmentForgotPasswordPin extends Fragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "FragmentForgotPasswordPin";
    AlertDialog alertDialog;
    private BloFragmentForgotpasswordPinBinding binding;
    String firstPartMobileNumber;
    String mobileNo;
    String otp;
    String secondPartMobileNumber;
    String userName;

    @Inject
    Utils utils;
    String nothingToDo = "Nothing to do";
    String stateCd = "";
    String stateCdBundle = "stateCd";
    String errorResponse = "";
    private final CommomUtility commomUtility = new CommomUtility();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentForgotpasswordPinBinding.inflate(getLayoutInflater());
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        pinView();
        initCLickListener();
        otpTimer();
        Bundle arguments = getArguments();
        this.userName = arguments.getString("mobileNumber");
        this.stateCd = arguments.getString(this.stateCdBundle);
        this.binding.mobileno.setText("+91 " + this.mobileNo);
        this.binding.pinView.setLongClickable(false);
        this.binding.pinView.setTextIsSelectable(false);
        this.firstPartMobileNumber = this.userName.substring(0, 2);
        this.secondPartMobileNumber = this.userName.substring(7, 9);
        Logger.d("signup_otp emailid", this.userName);
        SharedPref.getInstance(requireContext()).setLastLogin("F");
        this.binding.mobileno.setText("+91 " + this.firstPartMobileNumber + "XXXXXX" + this.secondPartMobileNumber);
        return this.binding.getRoot();
    }

    private void initCLickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPasswordPin$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$0(view);
            }
        });
        this.binding.verifyOtpLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPasswordPin$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$1(view);
            }
        });
        this.binding.otpTimer.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPasswordPin$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$0(View view) {
        requireActivity().getSupportFragmentManager().popBackStackImmediate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$1(View view) {
        if (validation()) {
            verifyOtp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$2(View view) {
        if (this.binding.otpTimer.getText().toString().equals("Resend OTP!")) {
            otpSendToUser();
        }
    }

    private void verifyOtp() {
        this.otp = ((Editable) Objects.requireNonNull(this.binding.pinView.getText())).toString();
        HashMap map = new HashMap();
        map.put("otp", this.otp);
        map.put("userName", this.userName);
        map.put("userCreation", true);
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).forgetChangePasswordVerifyOtp(map).enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPasswordPin$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<EronetResponse> {
        AnonymousClass1() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                Bundle bundle = new Bundle();
                bundle.putString("mobileNo", FragmentForgotPasswordPin.this.userName);
                bundle.putString(FragmentForgotPasswordPin.this.stateCdBundle, FragmentForgotPasswordPin.this.stateCd);
                FragmentSetPassword fragmentSetPassword = new FragmentSetPassword();
                fragmentSetPassword.setArguments(bundle);
                FragmentForgotPasswordPin.this.openFragment(fragmentSetPassword);
                return;
            }
            try {
                FragmentForgotPasswordPin.this.errorResponse = new JSONObject(response.errorBody().string()).optString("message");
                Logger.d(FragmentForgotPasswordPin.TAG, "EroPasswordFlow errorResponse --> " + FragmentForgotPasswordPin.this.errorResponse);
                FragmentForgotPasswordPin.this.commomUtility.showMessageWithTitleOK(FragmentForgotPasswordPin.this.requireContext(), "Forgot Password Pin Error - " + response.code(), FragmentForgotPasswordPin.this.errorResponse, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPasswordPin$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
            } catch (IOException | JSONException e) {
                FragmentForgotPasswordPin.this.commomUtility.displayAlertWithTitleAndMessage(FragmentForgotPasswordPin.this.requireContext(), "Forgot Password Pin Error - ", e.getMessage());
                Logger.d(FragmentForgotPasswordPin.TAG, "EroTokenReceived exception --> " + e.getMessage());
            }
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            FragmentForgotPasswordPin.this.utils.showMessageOK(FragmentForgotPasswordPin.this.requireContext(), "Error", "Error occurred, Try again", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPasswordPin$1$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
    }

    private void pinView() {
        this.binding.pinView.requestFocus();
        this.binding.pinView.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPasswordPin.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(FragmentForgotPasswordPin.TAG, FragmentForgotPasswordPin.this.nothingToDo);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                View currentFocus;
                if (FragmentForgotPasswordPin.this.binding.pinView.length() != 6 || (currentFocus = FragmentForgotPasswordPin.this.requireActivity().getCurrentFocus()) == null) {
                    return;
                }
                ((InputMethodManager) FragmentForgotPasswordPin.this.requireActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Log.d(FragmentForgotPasswordPin.TAG, FragmentForgotPasswordPin.this.nothingToDo);
            }
        });
    }

    private boolean validation() {
        if (this.binding.pinView.length() == 6) {
            return true;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Incorrect PIN");
        builder.setMessage("Please enter correct PIN");
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPasswordPin$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
        return false;
    }

    private void otpSendToUser() {
        Log.d(TAG, "otpSendToUserMobileNumber ---> " + this.userName);
        HashMap map = new HashMap();
        map.put("otp", null);
        map.put("userName", this.userName);
        map.put("userCreation", true);
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).forgetChangePasswordSendOtp("ANDROIDMOB", map).enqueue(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPasswordPin$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<EronetResponse> {
        AnonymousClass3() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                Log.d("Status", "apiSuccessotpSendToUser");
                Bundle bundle = new Bundle();
                bundle.putString("mobileNumber", FragmentForgotPasswordPin.this.userName);
                bundle.putString(FragmentForgotPasswordPin.this.stateCdBundle, FragmentForgotPasswordPin.this.stateCd);
                FragmentForgotPasswordPin fragmentForgotPasswordPin = new FragmentForgotPasswordPin();
                fragmentForgotPasswordPin.setArguments(bundle);
                FragmentForgotPasswordPin.this.openFragment(fragmentForgotPasswordPin);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPasswordPin$3$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                Toast.makeText(FragmentForgotPasswordPin.this.requireContext(), ((EronetResponse) response.body()).getMessage(), 1).show();
                return;
            }
            Log.d("Fail", "apiSuccessotpSendToUser");
            try {
                FragmentForgotPasswordPin.this.errorResponse = new JSONObject(response.errorBody().string()).optString("message");
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPasswordPin$3$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$1();
                    }
                }, 2000L);
                Toast.makeText(FragmentForgotPasswordPin.this.requireContext(), FragmentForgotPasswordPin.this.errorResponse, 1).show();
            } catch (IOException | JSONException e) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPasswordPin$3$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$2();
                    }
                }, 2000L);
                Logger.d(FragmentForgotPasswordPin.TAG, "EroSendOtp exception --> " + e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            FragmentForgotPasswordPin.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            FragmentForgotPasswordPin.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            FragmentForgotPasswordPin.this.alertDialog.dismiss();
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Toast.makeText(FragmentForgotPasswordPin.this.requireContext(), "Error", 1).show();
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [in.gov.eci.bloapp.views.fragments.login.FragmentForgotPasswordPin$4] */
    private void otpTimer() {
        new CountDownTimer(120000L, 1000L) { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPasswordPin.4
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                FragmentForgotPasswordPin.this.binding.otpTimer.setText("Resend OTP in " + String.format("%d:%d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                FragmentForgotPasswordPin.this.binding.otpTimer.setText("Resend OTP!");
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, "Login Fragment");
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4100);
        fragmentTransactionBeginTransaction.commit();
    }
}
