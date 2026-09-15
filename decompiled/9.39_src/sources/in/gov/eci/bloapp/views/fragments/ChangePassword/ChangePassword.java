package in.gov.eci.bloapp.views.fragments.ChangePassword;

import android.R;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.databinding.BloFragmentChangePasswordBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.PasswordChangeSuccessfully;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.OkHttpClient;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ChangePassword extends BaseFragment {
    private static final String PNM = "Password condition not match";
    BloFragmentChangePasswordBinding binding;
    AlertDialog.Builder builder;
    final Retrofit.Builder builder1;
    final CommomUtility commomUtility;
    String confnewpassword;
    int forgotpasswordcode;
    String messege;
    String newpassword;
    final OkHttpClient okHttpClient;
    String otpVerifymessege;
    String otpmessege;
    final Retrofit retrofit;
    private String stateCode;
    private String token;
    private String userName;

    public ChangePassword() {
        CommomUtility commomUtility = new CommomUtility();
        this.commomUtility = commomUtility;
        OkHttpClient okHttpClientBuild = new OkHttpClient().newBuilder().connectTimeout(2L, TimeUnit.MINUTES).readTimeout(2L, TimeUnit.MINUTES).build();
        this.okHttpClient = okHttpClientBuild;
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(okHttpClientBuild);
        this.builder1 = builderClient;
        this.retrofit = builderClient.build();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentChangePasswordBinding.inflate(getLayoutInflater());
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.userName = SharedPref.getInstance(requireContext()).getUserName();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.binding.passwordEd.setLongClickable(false);
        this.binding.passwordEd.setTextIsSelectable(false);
        this.binding.confirmPasswdEd.setLongClickable(false);
        this.binding.confirmPasswdEd.setTextIsSelectable(false);
        this.binding.entotp.setLongClickable(false);
        this.binding.entotp.setTextIsSelectable(false);
        this.binding.mobileNumEd.setText(SharedPref.getInstance(requireContext()).getPhoneNumber());
        this.binding.mobileNumEd.setPadding(6, 12, 8, 12);
        this.binding.verifysendotp.setVisibility(8);
        this.binding.otpresend.setVisibility(8);
        inputChanged();
        checkConfirmPassword();
        initCLickListener();
        this.binding.resendotpButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.sendotpButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.binding.verifyotp.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        Toast.makeText(getContext(), "OTP resent", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v5, types: [in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword$1] */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        Toast.makeText(getContext(), "OTP sent", 0).show();
        String string = this.binding.mobileNumEd.getText().toString();
        showProgressVisible();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("otp", (Object) null);
            jSONObject.put("userName", SharedPref.getInstance(requireContext()).getPhoneNumber());
            jSONObject.put("userCreation", true);
            this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).otpSend(this.token, "blo", "ANDROIDMOB", (Map) new Gson().fromJson(String.valueOf(jSONObject), new TypeToken<HashMap<String, String>>() { // from class: in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword.1
            }.getType())).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword.2
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    ChangePassword.this.showProgressInVisible();
                    if (response.body() != null) {
                        JsonObject jsonObject = (JsonObject) response.body();
                        ChangePassword.this.otpmessege = String.valueOf(jsonObject.get("message"));
                        Toast.makeText(ChangePassword.this.getContext(), ChangePassword.this.otpmessege, 0).show();
                    }
                }

                public void onFailure(Call<JsonObject> call, Throwable t) {
                    ChangePassword.this.showProgressInVisible();
                }
            });
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
        if (string.equals("")) {
            showDialog("Please enter mobile number");
        }
        this.binding.linearLayoutSendBtns.setVisibility(8);
        this.binding.otpresend.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v8, types: [in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword$3] */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        if (this.binding.entotp.getText().toString().equals("")) {
            showDialog("Please enter otp");
            return;
        }
        showProgressVisible();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("otp", this.binding.entotp.getText().toString());
            jSONObject.put("userName", SharedPref.getInstance(requireContext()).getPhoneNumber());
            jSONObject.put("userCreation", true);
            this.commomUtility.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).otpVerify(this.token, "blo", "ANDROIDMOB", (Map) new Gson().fromJson(String.valueOf(jSONObject), new TypeToken<HashMap<String, String>>() { // from class: in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword.3
            }.getType())).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword.4
                /* JADX WARN: Type inference failed for: r0v17, types: [in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword$4$1] */
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    ChangePassword.this.showProgressInVisible();
                    if (response.code() == 200) {
                        JsonObject jsonObject = (JsonObject) response.body();
                        ChangePassword.this.otpVerifymessege = String.valueOf(jsonObject.get("message"));
                        JSONObject jSONObject2 = new JSONObject();
                        ChangePassword changePassword = ChangePassword.this;
                        changePassword.newpassword = changePassword.binding.passwordEd.getText().toString();
                        ChangePassword changePassword2 = ChangePassword.this;
                        changePassword2.confnewpassword = changePassword2.binding.confirmPasswdEd.getText().toString();
                        try {
                            jSONObject2.put("confirmNewPassword", ChangePassword.this.confnewpassword);
                            jSONObject2.put("newPassword", ChangePassword.this.newpassword);
                            jSONObject2.put("userId", ChangePassword.this.userName);
                            Logger.d("Pjson", jSONObject2.toString());
                            ChangePassword.this.commomUtility.getRetrofitClient(ChangePassword.this.getContext(), ChangePassword.this.token, SharedPref.getInstance(ChangePassword.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ChangePassword.this.requireContext()).getRtknBnd()).changePassword(ChangePassword.this.token, "blo", ChangePassword.this.stateCode, (Map) new Gson().fromJson(String.valueOf(jSONObject2), new TypeToken<HashMap<String, String>>() { // from class: in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword.4.1
                            }.getType())).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword.4.2
                                public void onFailure(Call<JsonObject> call2, Throwable t) {
                                }

                                public void onResponse(Call<JsonObject> call2, Response<JsonObject> response2) {
                                    ChangePassword.this.showProgressInVisible();
                                    Logger.d("Change password", "Change password");
                                    if (response2.body() != null) {
                                        JsonObject jsonObject2 = (JsonObject) response2.body();
                                        ChangePassword.this.messege = String.valueOf(jsonObject2.get("message"));
                                        ChangePassword.this.forgotpasswordcode = response2.code();
                                        if (response2.code() == 200) {
                                            ChangePassword.this.startActivity(new Intent(ChangePassword.this.getContext(), (Class<?>) PasswordChangeSuccessfully.class));
                                            return;
                                        }
                                        return;
                                    }
                                    ChangePassword.this.forgotpasswordcode = response2.code();
                                }
                            });
                        } catch (Exception e) {
                            Logger.d("", e.getMessage());
                        }
                    }
                }

                public void onFailure(Call<JsonObject> call, Throwable t) {
                    ChangePassword.this.showProgressInVisible();
                }
            });
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
    }

    private void inputChanged() {
        this.binding.passwordEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ChangePassword.this.validation();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validation() {
        String string = this.binding.passwordEd.getText().toString();
        Pattern patternCompile = Pattern.compile(RegexMatcher.UPPERCASE);
        Pattern patternCompile2 = Pattern.compile("[0-9]");
        Pattern patternCompile3 = Pattern.compile("[\"^(?=.*[_.()$&@]).*$\"]");
        if (string.length() > 0) {
            this.binding.textsingleSelect.setEndIconMode(1);
            if (!patternCompile.matcher(string).find()) {
                this.binding.AtoZ.setTextColor(-65536);
                this.binding.shapeCorrectSign4.setVisibility(8);
            } else {
                this.binding.AtoZ.setTextColor(Color.parseColor("#2EB200"));
                this.binding.shapeCorrectSign2.setVisibility(0);
            }
            if (!patternCompile2.matcher(string).find()) {
                this.binding.numtocountTv.setTextColor(-65536);
                this.binding.shapeCorrectSign4.setVisibility(8);
            } else {
                this.binding.numtocountTv.setTextColor(Color.parseColor("#2EB200"));
                this.binding.shapeCorrectSign3.setVisibility(0);
            }
            if (string.length() < 8) {
                this.binding.charcountTv.setTextColor(-65536);
                this.binding.shapeCorrectSign4.setVisibility(8);
            } else {
                this.binding.charcountTv.setTextColor(Color.parseColor("#2EB200"));
                this.binding.shapeCorrectSign1.setVisibility(0);
            }
            if (!patternCompile3.matcher(string).find()) {
                this.binding.specialcharsTv.setTextColor(-65536);
                this.binding.shapeCorrectSign4.setVisibility(8);
                return;
            } else {
                this.binding.specialcharsTv.setTextColor(Color.parseColor("#2EB200"));
                this.binding.shapeCorrectSign4.setVisibility(0);
                return;
            }
        }
        this.binding.textsingleSelect.setEndIconMode(0);
        this.binding.specialcharsTv.setTextColor(Color.parseColor("#000000"));
        this.binding.charcountTv.setTextColor(Color.parseColor("#000000"));
        this.binding.numtocountTv.setTextColor(Color.parseColor("#000000"));
        this.binding.AtoZ.setTextColor(Color.parseColor("#000000"));
    }

    private void checkConfirmPassword() {
        this.binding.confirmPasswdEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword.6
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ChangePassword.this.binding.confirmPasswdEd.length() > 0) {
                    ChangePassword.this.binding.textconfirmPassword.setEndIconMode(1);
                } else {
                    ChangePassword.this.binding.textconfirmPassword.setEndIconMode(0);
                }
            }
        });
    }

    private void initCLickListener() {
        this.binding.updateButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$3(View view) {
        if (validatePassword()) {
            this.binding.verifysendotp.setVisibility(0);
            this.binding.passwordEd.setEnabled(false);
            this.binding.confirmPasswdEd.setEnabled(false);
            this.binding.updateButton.setClickable(false);
        }
    }

    private boolean validatePassword() {
        Pattern patternCompile = Pattern.compile(RegexMatcher.UPPERCASE);
        Pattern patternCompile2 = Pattern.compile("\\d");
        Pattern patternCompile3 = Pattern.compile("[\"^(?=.*[_.()$&@]).*$\"]");
        String string = this.binding.passwordEd.getText().toString();
        String string2 = this.binding.confirmPasswdEd.getText().toString();
        if (string.isEmpty() || string2.isEmpty()) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), "Enter Details", "Please enter required details.");
            return false;
        }
        if (string.length() < 8) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), PNM, "Password length should be minimum 8 digit");
            return false;
        }
        if (!patternCompile.matcher(string).find()) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), PNM, "Use least one capital letter (A-Z)");
            return false;
        }
        if (!patternCompile2.matcher(string).find()) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), PNM, "Use least one number");
            return false;
        }
        if (!patternCompile3.matcher(string).find()) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), PNM, "Use least one special character");
            return false;
        }
        if (string.equals(string2)) {
            return true;
        }
        this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), "Incorrect Details", "Password and Confirm Password do not match");
        return false;
    }

    private void showDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        this.builder = builder;
        builder.setIcon(R.drawable.ic_dialog_alert);
        this.builder.setTitle("Alert");
        this.builder.setMessage(message);
        this.builder.setCancelable(false);
        this.builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.ChangePassword.ChangePassword$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        this.builder.create().show();
    }
}
