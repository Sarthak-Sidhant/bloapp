package in.gov.eci.bloapp.views.fragments.my_account;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentMyAccountBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.MyDetailsViewModel;
import in.gov.eci.bloapp.views.activity.ActivityEditMyAccount;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class MyAccount extends Hilt_MyAccount {
    String acNo;
    String address;
    String asmblyName;
    BloFragmentMyAccountBinding binding;
    String bloDesignation;
    String bloEpicNumber;
    String districtCode;
    String districtName;
    String email;
    String fName;
    String lName;
    String name;
    String partNumber;
    String phoneNumber;
    String refreshToken;
    String stateCode;
    String stateName;
    String token;
    String totalPartNumber;
    MyDetailsViewModel viewModel;
    String errorString = "Error";
    String sessionTokenExpiredPleaseLogin = "Session token expired please Login";
    String userDetailsString = "USER_DETAILS";
    String userLnameTag = "userLname";
    CommomUtility commonUtilClass = new CommomUtility();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentMyAccountBinding.inflate(inflater);
        this.viewModel = (MyDetailsViewModel) new ViewModelProvider(requireActivity()).get(MyDetailsViewModel.class);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.totalPartNumber = SharedPref.getInstance(requireContext()).getTotalPartNumber();
        this.stateName = SharedPref.getInstance(requireContext()).getStateName();
        this.districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        this.asmblyName = SharedPref.getInstance(requireContext()).getAssemblyName();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        getBlo();
        Logger.d("API Data", "Fragment_Device_Comapacttability");
        Logger.d(this.userDetailsString, "Token -----> " + this.token);
        Logger.d(this.userDetailsString, "State Code --------> " + this.stateCode);
        Logger.d(this.userDetailsString, "District Code --------> " + this.districtCode);
        Logger.d(this.userDetailsString, "Name --------> " + this.name);
        Logger.d(this.userDetailsString, "Phone Number --------> " + this.phoneNumber);
        Logger.d(this.userDetailsString, "Assembly Number  --------> " + this.acNo);
        Logger.d(this.userDetailsString, "Part Number  --------> " + this.partNumber);
        Logger.d(this.userDetailsString, "Email  --------> " + this.email);
        Logger.d(this.userDetailsString, "Name --------> " + this.name);
        Logger.d(this.userDetailsString, "Part Number  --------> " + this.totalPartNumber);
        String[] strArrSplit = this.totalPartNumber.replace(RegexMatcher.JSON_STRING_REGEX, " ").replace("[", "").replace("]", "").replace(" ", "").split(",");
        int length = strArrSplit.length > 0 ? strArrSplit.length : 0;
        Logger.d("N value", String.valueOf(length));
        for (int i = 0; i < length; i++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 7, 15, 0);
            TextView textView = new TextView(getContext());
            textView.setLayoutParams(layoutParams);
            textView.setText(strArrSplit[i]);
            textView.setTextColor(-16777216);
            textView.setGravity(17);
            textView.setBackgroundResource(R.drawable.blo_testsquare1);
            textView.setPadding(20, 20, 20, 20);
            this.binding.test6.addView(textView);
        }
        this.binding.btnAnimation.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.my_account.MyAccount$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.edit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.my_account.MyAccount$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        Intent intent = new Intent(getContext(), (Class<?>) ActivityEditMyAccount.class);
        intent.putExtra("State", this.stateName);
        intent.putExtra("District", this.districtName);
        intent.putExtra("assmblyCons", this.asmblyName);
        intent.putExtra("fName", this.fName);
        intent.putExtra("lName", this.lName);
        intent.putExtra("MobileNumber", this.phoneNumber);
        intent.putExtra("Email", this.binding.emailId.getText().toString());
        intent.putExtra("officeAddress", this.binding.officeAddress.getText().toString());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        Intent intent = new Intent(getContext(), (Class<?>) ActivityEditMyAccount.class);
        intent.putExtra("State", this.stateName);
        intent.putExtra("District", this.districtName);
        intent.putExtra("assmblyCons", this.asmblyName);
        intent.putExtra("fName", this.fName);
        intent.putExtra("lName", this.lName);
        intent.putExtra("MobileNumber", this.phoneNumber);
        intent.putExtra("Email", this.binding.emailId.getText().toString());
        intent.putExtra("officeAddress", this.binding.officeAddress.getText().toString());
        startActivity(intent);
    }

    public void getBlo() {
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getMyProfile(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "ANDROIDMOB").enqueue(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.my_account.MyAccount$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        AnonymousClass1() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            System.out.println("hii i am response code " + response.code());
            if (response.code() == 200) {
                JsonObject jsonObject = (JsonObject) response.body();
                MyAccount.this.phoneNumber = jsonObject.get("mobileNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                MyAccount.this.fName = jsonObject.get("userFname").toString().replaceAll("^\"|\"$", "").replaceAll(" null | null", " ");
                MyAccount.this.lName = jsonObject.get("userLname").toString().replaceAll("^\"|\"$", "").replaceAll(" null | null", " ");
                MyAccount.this.email = jsonObject.get("email").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                MyAccount.this.bloDesignation = jsonObject.get("designationName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                MyAccount.this.bloEpicNumber = jsonObject.get("epicNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                MyAccount.this.address = jsonObject.get("address").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (MyAccount.this.address.equals("NA")) {
                    MyAccount.this.address = "";
                }
                if (MyAccount.this.lName == null) {
                    MyAccount.this.lName = "";
                }
                if (MyAccount.this.bloDesignation == null || MyAccount.this.bloDesignation.equals("") || MyAccount.this.bloDesignation.equalsIgnoreCase("NULL")) {
                    MyAccount.this.name = MyAccount.this.fName + " " + MyAccount.this.lName;
                } else {
                    MyAccount.this.name = MyAccount.this.fName + " " + MyAccount.this.lName + "(" + MyAccount.this.bloDesignation + ")";
                }
                if (MyAccount.this.name != null) {
                    MyAccount.this.binding.firstName.setText(MyAccount.this.name);
                } else {
                    MyAccount.this.binding.firstName.setText("");
                }
                if (MyAccount.this.bloEpicNumber == null || MyAccount.this.bloEpicNumber.equals("") || MyAccount.this.bloEpicNumber.equalsIgnoreCase("NULL")) {
                    MyAccount.this.binding.epicNumber.setText("");
                } else {
                    MyAccount.this.binding.epicNumber.setText(MyAccount.this.bloEpicNumber);
                }
                if (MyAccount.this.phoneNumber != null) {
                    MyAccount.this.binding.mobileNumber.setText("+91-" + MyAccount.this.phoneNumber);
                } else {
                    MyAccount.this.binding.mobileNumber.setText("");
                }
                if (MyAccount.this.email == null || MyAccount.this.email.equals("") || MyAccount.this.email.equalsIgnoreCase("NULL")) {
                    MyAccount.this.binding.emailId.setText("");
                } else {
                    MyAccount.this.binding.emailId.setText(MyAccount.this.email);
                }
                if (MyAccount.this.address == null || MyAccount.this.address.equalsIgnoreCase("null") || MyAccount.this.address.equals("")) {
                    MyAccount.this.binding.officeAddress.setText("");
                } else {
                    MyAccount.this.binding.officeAddress.setText(MyAccount.this.address);
                }
                if (MyAccount.this.stateName != null) {
                    MyAccount.this.binding.stateValue.setText(MyAccount.this.stateName);
                } else {
                    MyAccount.this.binding.stateValue.setText("");
                }
                if (MyAccount.this.districtName != null) {
                    MyAccount.this.binding.districtValue.setText(MyAccount.this.districtName);
                } else {
                    MyAccount.this.binding.districtValue.setText("");
                }
                if (MyAccount.this.asmblyName != null) {
                    MyAccount.this.binding.assembly5Value.setText(MyAccount.this.asmblyName);
                    return;
                } else {
                    MyAccount.this.binding.assembly5Value.setText("");
                    return;
                }
            }
            if (response.code() == 401) {
                System.out.println("Hii i am 401");
                MyAccount.this.commonUtilClass.getRefreshToken(MyAccount.this.getContext(), MyAccount.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.my_account.MyAccount$1$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            System.out.println("Hii i am nothng");
            try {
                MyAccount.this.commonUtilClass.showMessageWithTitleOK(MyAccount.this.requireContext(), "Section Error - " + response.code(), new JSONObject(response.errorBody().string()).optString("message"), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.my_account.MyAccount$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
            } catch (Exception e) {
                Logger.e("on Failure............", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                MyAccount.this.commonUtilClass.showMessageOK(MyAccount.this.getContext(), MyAccount.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.my_account.MyAccount$1$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            MyAccount.this.token = "Bearer " + str;
            Toast.makeText(MyAccount.this.requireContext(), "Token Refreshed", 1).show();
            SharedPref.getInstance(MyAccount.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(MyAccount.this.requireContext()).setToken("Bearer " + str);
            MyAccount.this.getBlo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(MyAccount.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(MyAccount.this.requireContext()).setLocaleBool(false);
            MyAccount.this.startActivity(new Intent((Context) MyAccount.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("on Failure............", t.getMessage());
        }
    }

    private void showDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle(this.errorString);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.my_account.MyAccount$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    private void showDialog1(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.my_account.MyAccount$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$3(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$3(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(getContext(), (Class<?>) MainActivity.class));
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
