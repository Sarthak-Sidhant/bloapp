package in.gov.eci.bloapp.views.fragments.login;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
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
import in.gov.eci.bloapp.databinding.BloFragmentSetPasswdBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.Utils;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FragmentSetPassword extends BaseFragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "BloFragmentSetPasswdBinding";
    AlertDialog alertDialog;
    private BloFragmentSetPasswdBinding binding;
    String confirmPassword;

    @Inject
    Utils utils;
    String passwordConditionNotMatched = "Password condition doesn't match";
    CommomUtility commomUtility = new CommomUtility();
    String userId = "";
    String mobileNumber = "";
    String state = "";
    String color2EB200 = "#2EB200";
    String color000000 = "#000000";
    String firstSetPasswordError = "First Set Password Error - ";
    String setForgetPasswordError = "Set Forget Password Error - ";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentSetPasswdBinding.inflate(getLayoutInflater());
        Bundle arguments = getArguments();
        this.mobileNumber = arguments.getString("mobileNo");
        this.state = arguments.getString("stateCd");
        Logger.d(TAG, "mobileNumber ---> " + this.mobileNumber);
        Logger.d(TAG, "state ---> " + this.state);
        inputChanged();
        checkConfirmPassword();
        initCLickListener();
        if (SharedPref.getInstance(requireContext()).getLastLogin().equals("N")) {
            this.binding.forgetPasswordLayout.setVisibility(8);
            this.binding.confirmPassLayout.setText("Confirm Password");
        } else if (SharedPref.getInstance(requireContext()).getLastLogin().equals("F")) {
            this.binding.forgetPasswordLayout.setVisibility(0);
        }
        this.binding.passwordEd.setLongClickable(false);
        this.binding.passwordEd.setTextIsSelectable(false);
        this.binding.confirmPasswdEd.setLongClickable(false);
        this.binding.confirmPasswdEd.setTextIsSelectable(false);
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        return this.binding.getRoot();
    }

    private void initCLickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentSetPassword$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$0(view);
            }
        });
        this.binding.confirmPassLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentSetPassword$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$1(view);
            }
        });
        this.binding.login.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentSetPassword$$ExternalSyntheticLambda2
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
        if (validatePassword()) {
            if (SharedPref.getInstance(requireContext()).getLastLogin().equals("N")) {
                this.binding.confirmPassLayout.setEnabled(true);
                firstTimePasswordChange();
            } else {
                forgetPasswordChange();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$2(View view) {
        openFragment(new LoginFragment());
    }

    private void firstTimePasswordChange() {
        if (isNetworkAvailable(requireContext())) {
            this.alertDialog.show();
            fetchFirstTimeLoginData();
        } else {
            Toast.makeText(getContext(), "Please check network", 1).show();
        }
    }

    private void fetchFirstTimeLoginData() {
        Log.d("", "StateCdoe ---> " + SharedPref.getInstance(requireContext()).getStateCode());
        this.userId = SharedPref.getInstance(requireContext()).getUserName();
        Log.d("", "UserId --->  " + this.userId);
        HashMap map = new HashMap();
        map.put("confirmNewPassword", this.confirmPassword);
        map.put("newPassword", this.confirmPassword);
        map.put("userId", this.userId);
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).firstTimePasswordChange(SharedPref.getInstance(requireContext()).getToken(), "blo", SharedPref.getInstance(requireContext()).getStateCode(), map).enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.FragmentSetPassword$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<EronetResponse> {
        AnonymousClass1() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                SharedPref.getInstance(FragmentSetPassword.this.requireContext()).setLastLogin("Y");
                SharedPref.getInstance(FragmentSetPassword.this.requireContext()).setPassword(FragmentSetPassword.this.confirmPassword);
                FragmentSetPassword.this.openFragment(new LoginFragment());
                FragmentSetPassword.this.commomUtility.displayAlertWithTitleAndMessage(FragmentSetPassword.this.requireContext(), "Status", "Password changed successfully");
            } else {
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                    Logger.d(FragmentSetPassword.TAG, "firstTimePasswordChange errorResponse --> " + strOptString);
                    FragmentSetPassword.this.openFragment(new LoginFragment());
                    FragmentSetPassword.this.commomUtility.showMessageWithTitleOK(FragmentSetPassword.this.requireContext(), FragmentSetPassword.this.firstSetPasswordError + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentSetPassword$1$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                } catch (IOException | JSONException e) {
                    FragmentSetPassword.this.openFragment(new LoginFragment());
                    FragmentSetPassword.this.commomUtility.showMessageWithTitleOK(FragmentSetPassword.this.requireContext(), FragmentSetPassword.this.firstSetPasswordError + response.code(), "Some Error occur please try again", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentSetPassword$1$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    Logger.d(FragmentSetPassword.TAG, "firstTimePasswordChange exception --> " + e.getMessage());
                }
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentSetPassword$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$2();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            FragmentSetPassword.this.alertDialog.dismiss();
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            FragmentSetPassword.this.commomUtility.displayAlertWithTitleAndMessage(FragmentSetPassword.this.requireContext(), "Error", "Error occurred, Try again");
        }
    }

    private void forgetPasswordChange() {
        if (isNetworkAvailable(requireContext())) {
            this.alertDialog.show();
            fetchForgetPasswordData();
        } else {
            Toast.makeText(getContext(), "Please check network", 1).show();
        }
    }

    private void fetchForgetPasswordData() {
        Logger.d(TAG, "mobileNumber ---> " + this.mobileNumber);
        Logger.d(TAG, "confirmPassword ---> " + this.confirmPassword);
        this.userId = SharedPref.getInstance(requireContext()).getUserName();
        HashMap map = new HashMap();
        map.put("email", null);
        map.put("loginName", null);
        map.put("loginNameRequest", null);
        map.put("mobileNumber", this.mobileNumber);
        map.put("passwordRequest", this.confirmPassword);
        map.put("processMasterId", 30009);
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).forgetSetPassword(this.state, "30073", map).enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.FragmentSetPassword$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<EronetResponse> {
        AnonymousClass2() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                FragmentSetPassword.this.openFragment(new LoginFragment());
                FragmentSetPassword.this.commomUtility.displayAlertWithTitleAndMessage(FragmentSetPassword.this.requireContext(), "Status", ((EronetResponse) response.body()).getMessage());
            } else {
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                    Logger.d(FragmentSetPassword.TAG, "ForgetPasswordChange errorResponse --> " + strOptString);
                    FragmentSetPassword.this.openFragment(new LoginFragment());
                    FragmentSetPassword.this.commomUtility.showMessageWithTitleOK(FragmentSetPassword.this.requireContext(), FragmentSetPassword.this.setForgetPasswordError + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentSetPassword$2$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                } catch (IOException | JSONException e) {
                    FragmentSetPassword.this.openFragment(new LoginFragment());
                    FragmentSetPassword.this.commomUtility.showMessageWithTitleOK(FragmentSetPassword.this.requireContext(), FragmentSetPassword.this.setForgetPasswordError + response.code(), "Some Error occur please try again", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentSetPassword$2$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    Logger.d(FragmentSetPassword.TAG, "ForgetPasswordChange exception --> " + e.getMessage());
                }
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentSetPassword$2$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$2();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            FragmentSetPassword.this.alertDialog.dismiss();
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            FragmentSetPassword.this.commomUtility.displayAlertWithTitleAndMessage(FragmentSetPassword.this.requireContext(), "Error", "Error occurred, Try again");
        }
    }

    private boolean validatePassword() {
        String string = ((Editable) Objects.requireNonNull(this.binding.passwordEd.getText())).toString();
        String string2 = ((Editable) Objects.requireNonNull(this.binding.confirmPasswdEd.getText())).toString();
        Pattern patternCompile = Pattern.compile(RegexMatcher.UPPERCASE);
        Pattern patternCompile2 = Pattern.compile(RegexMatcher.DIGITS);
        Pattern patternCompile3 = Pattern.compile(RegexMatcher.SPECIAL_CHARACTER);
        if (string.isEmpty() || string2.isEmpty()) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), "Enter Details", "Please enter required details.");
            return false;
        }
        if (string.length() < 8) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.passwordConditionNotMatched, "Password length should be minimum 8 digit");
            return false;
        }
        if (!patternCompile.matcher(string).find()) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.passwordConditionNotMatched, "Use atleast one capital letter (A-Z)");
            return false;
        }
        if (!patternCompile2.matcher(string).find()) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.passwordConditionNotMatched, "Use atleast one number");
            return false;
        }
        if (!patternCompile3.matcher(string).find()) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), this.passwordConditionNotMatched, "Use atleast one special character");
            return false;
        }
        if (!string.equals(string2)) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), "Incorrect Details", "Password and Confrirm Password do not match");
            return false;
        }
        this.confirmPassword = string2;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validation() {
        String string = ((Editable) Objects.requireNonNull(this.binding.passwordEd.getText())).toString();
        Pattern patternCompile = Pattern.compile(RegexMatcher.UPPERCASE);
        Pattern patternCompile2 = Pattern.compile(RegexMatcher.DIGITS);
        Pattern patternCompile3 = Pattern.compile(RegexMatcher.SPECIAL_CHARACTER);
        if (string.length() > 0) {
            this.binding.textsingleSelect.setEndIconMode(1);
            if (!patternCompile.matcher(string).find()) {
                this.binding.AtoZ.setTextColor(-65536);
                this.binding.shapeCorrectSign4.setVisibility(8);
            } else {
                this.binding.AtoZ.setTextColor(Color.parseColor(this.color2EB200));
                this.binding.shapeCorrectSign2.setVisibility(0);
            }
            if (!patternCompile2.matcher(string).find()) {
                this.binding.numtocountTv.setTextColor(-65536);
                this.binding.shapeCorrectSign4.setVisibility(8);
            } else {
                this.binding.numtocountTv.setTextColor(Color.parseColor(this.color2EB200));
                this.binding.shapeCorrectSign3.setVisibility(0);
            }
            if (string.length() < 8) {
                this.binding.charcountTv.setTextColor(-65536);
                this.binding.shapeCorrectSign4.setVisibility(8);
            } else {
                this.binding.charcountTv.setTextColor(Color.parseColor(this.color2EB200));
                this.binding.shapeCorrectSign1.setVisibility(0);
            }
            if (!patternCompile3.matcher(string).find()) {
                this.binding.specialcharsTv.setTextColor(-65536);
                this.binding.shapeCorrectSign4.setVisibility(8);
                return;
            } else {
                this.binding.specialcharsTv.setTextColor(Color.parseColor(this.color2EB200));
                this.binding.shapeCorrectSign4.setVisibility(0);
                return;
            }
        }
        this.binding.textsingleSelect.setEndIconMode(0);
        this.binding.specialcharsTv.setTextColor(Color.parseColor(this.color000000));
        this.binding.charcountTv.setTextColor(Color.parseColor(this.color000000));
        this.binding.numtocountTv.setTextColor(Color.parseColor(this.color000000));
        this.binding.AtoZ.setTextColor(Color.parseColor(this.color000000));
    }

    private void checkConfirmPassword() {
        this.binding.confirmPasswdEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentSetPassword.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (FragmentSetPassword.this.binding.confirmPasswdEd.length() > 0) {
                    FragmentSetPassword.this.binding.textconfirmPassword.setEndIconMode(1);
                } else {
                    FragmentSetPassword.this.binding.textconfirmPassword.setEndIconMode(0);
                }
            }
        });
    }

    private void inputChanged() {
        this.binding.passwordEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentSetPassword.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                FragmentSetPassword.this.validation();
            }
        });
    }

    void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, TAG);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4100);
        fragmentTransactionBeginTransaction.commit();
    }
}
