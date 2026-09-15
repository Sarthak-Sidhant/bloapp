package in.gov.eci.bloapp.views.fragments.login;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentForgotPasswdBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.Utils;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class FragmentForgotPassword extends BaseFragment {
    private static final String TAG = "BloFragmentForgotPasswdBinding";
    AlertDialog alertDialog;
    private BloFragmentForgotPasswdBinding binding;
    CommomUtility commomUtility = new CommomUtility();
    String errorResponse = "";
    String lastLogin;
    String mobileNumber;
    String stateCd;

    @Inject
    Utils utils;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentForgotPasswdBinding.inflate(getLayoutInflater());
        initCLickListener();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.lastLogin = SharedPref.getInstance(requireContext()).getLastLogin();
        return this.binding.getRoot();
    }

    private void initCLickListener() {
        this.binding.requestOtpLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPassword$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$0(view);
            }
        });
        this.binding.login.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPassword$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$0(View view) {
        this.mobileNumber = ((Editable) Objects.requireNonNull(this.binding.mobileNumEd.getText())).toString();
        Log.d(TAG, "MobileNumber ---> " + this.mobileNumber);
        Log.d(TAG, "MobileNumberLength ---> " + this.mobileNumber.length());
        if (isNetworkAvailable(requireContext())) {
            if (this.mobileNumber.length() == 10) {
                this.alertDialog.show();
                passwordFlow();
                return;
            } else {
                this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), "Error", "Enter Valid Mobile Number");
                return;
            }
        }
        Toast.makeText(requireContext(), "Please check network", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$1(View view) {
        openFragment(new LoginFragment());
    }

    private void passwordFlow() {
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).forgetChangePassword("ANDROIDMOB", this.mobileNumber, "master").enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPassword$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<EronetResponse> {
        AnonymousClass1() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                Log.d("Status", "apiSuccessStatusForget");
                FragmentForgotPassword.this.stateCd = ((EronetResponse) response.body()).getStateCd();
                Log.d(FragmentForgotPassword.TAG, "ForgetPasswordStateCode ---> " + FragmentForgotPassword.this.stateCd);
                FragmentForgotPassword.this.otpSendToUser();
            } else {
                try {
                    FragmentForgotPassword.this.errorResponse = new JSONObject(response.errorBody().string()).optString("message");
                    Logger.d(FragmentForgotPassword.TAG, "eroPasswordFlowErrorResponse --> " + FragmentForgotPassword.this.errorResponse);
                    if (FragmentForgotPassword.this.errorResponse.length() == 0) {
                        FragmentForgotPassword.this.errorResponse = "Something went wrong please try again";
                    }
                    FragmentForgotPassword.this.commomUtility.showMessageWithTitleOK(FragmentForgotPassword.this.requireContext(), "Forgot Password Error - " + response.code(), FragmentForgotPassword.this.errorResponse, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPassword$1$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                } catch (IOException | JSONException e) {
                    Logger.d(FragmentForgotPassword.TAG, "eroPasswordFlow exception --> " + e.getMessage());
                }
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPassword$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$1();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            FragmentForgotPassword.this.alertDialog.dismiss();
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            FragmentForgotPassword.this.commomUtility.displayAlertWithTitleAndMessage(FragmentForgotPassword.this.requireContext(), "Server Error", "Error occurred, Try again");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPassword$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$2();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$2() {
            FragmentForgotPassword.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void otpSendToUser() {
        Log.d(TAG, "otpSendToUserMobileNumber ---> " + this.mobileNumber);
        HashMap map = new HashMap();
        map.put("otp", null);
        map.put("userName", this.mobileNumber);
        map.put("userCreation", true);
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).forgetChangePasswordSendOtp("ANDROIDMOB", map).enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPassword$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<EronetResponse> {
        AnonymousClass2() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                Log.d("Status", "apiSuccessotpSendToUser");
                Bundle bundle = new Bundle();
                bundle.putString("mobileNumber", FragmentForgotPassword.this.mobileNumber);
                bundle.putString("stateCd", FragmentForgotPassword.this.stateCd);
                FragmentForgotPasswordPin fragmentForgotPasswordPin = new FragmentForgotPasswordPin();
                fragmentForgotPasswordPin.setArguments(bundle);
                FragmentForgotPassword.this.openFragment(fragmentForgotPasswordPin);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPassword$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                Toast.makeText(FragmentForgotPassword.this.requireContext(), ((EronetResponse) response.body()).getMessage(), 1).show();
                return;
            }
            Log.d("Fail", "apiSuccessotpSendToUser");
            try {
                FragmentForgotPassword.this.errorResponse = new JSONObject(response.errorBody().string()).optString("message");
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPassword$2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$1();
                    }
                }, 2000L);
                Toast.makeText(FragmentForgotPassword.this.requireContext(), FragmentForgotPassword.this.errorResponse, 1).show();
            } catch (IOException | JSONException e) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentForgotPassword$2$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$2();
                    }
                }, 2000L);
                Logger.d(FragmentForgotPassword.TAG, "EroSendOtp exception --> " + e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            FragmentForgotPassword.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            FragmentForgotPassword.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            FragmentForgotPassword.this.alertDialog.dismiss();
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            Toast.makeText(FragmentForgotPassword.this.requireContext(), "Error", 1).show();
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
}
