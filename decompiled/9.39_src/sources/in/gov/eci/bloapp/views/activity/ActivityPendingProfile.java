package in.gov.eci.bloapp.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivityPendingProfileBinding;
import in.gov.eci.bloapp.model.app_model.BloModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.MyDetailsViewModel;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ActivityPendingProfile extends Hilt_ActivityPendingProfile {
    String asmblyNO;
    String asmblyName;
    BloActivityPendingProfileBinding binding;
    String districtCode;
    String districtName;
    String email;
    String emailId;
    String firstName;
    String langName;
    String mobileNumber;
    String name;
    String officeAddress;
    String partLang;
    String partName;
    String partNumber;
    String password;
    String phoneNumber;
    String stateCode;
    String stateName;
    String token;
    String totalPartNumber;
    String userName;
    MyDetailsViewModel viewModel;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityPendingProfileBinding bloActivityPendingProfileBindingInflate = BloActivityPendingProfileBinding.inflate(getLayoutInflater());
        this.binding = bloActivityPendingProfileBindingInflate;
        setContentView(bloActivityPendingProfileBindingInflate.getRoot());
        this.viewModel = (MyDetailsViewModel) new ViewModelProvider(this).get(MyDetailsViewModel.class);
        this.token = SharedPref.getInstance(this).getToken();
        this.userName = SharedPref.getInstance(this).getUserName();
        this.password = SharedPref.getInstance(this).getPassword();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        this.districtCode = SharedPref.getInstance(this).getDistrictCode();
        this.name = SharedPref.getInstance(this).getName();
        this.phoneNumber = SharedPref.getInstance(this).getPhoneNumber();
        this.asmblyNO = SharedPref.getInstance(this).getAssemblyNumber();
        this.totalPartNumber = SharedPref.getInstance(this).getTotalPartNumber();
        this.email = SharedPref.getInstance(this).getEmail();
        this.stateName = SharedPref.getInstance(this).getStateName();
        this.districtName = SharedPref.getInstance(this).getDistrictName();
        this.asmblyName = SharedPref.getInstance(this).getAssemblyName();
        this.partName = SharedPref.getInstance(this).getPartName();
        this.langName = SharedPref.getInstance(this).getLanguageName();
        this.partLang = SharedPref.getInstance(this).getPartNumberLanguageName();
        this.partNumber = SharedPref.getInstance(this).getPartNumber();
        this.binding.stateValue.setText(this.stateName);
        this.binding.districtValue.setText(this.districtName);
        this.binding.assembly5Value.setText(this.asmblyName);
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ActivityPendingProfile$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        getBlo();
        new ActivityMyAccount().setFlag = true;
        Logger.d("USER_DETAILS", "Name --------> " + this.name);
        Logger.d("USER_DETAILS", "Part Number  --------> " + this.totalPartNumber);
        String[] strArrSplit = this.totalPartNumber.replace(RegexMatcher.JSON_STRING_REGEX, " ").replace("[", "").replace("]", "").replace(" ", "").split(",");
        Logger.d("N value", String.valueOf(strArrSplit.length));
        for (String str : strArrSplit) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 7, 15, 0);
            TextView textView = new TextView(this);
            textView.setLayoutParams(layoutParams);
            textView.setText(str);
            textView.setTextColor(-16777216);
            textView.setGravity(17);
            textView.setBackgroundResource(R.drawable.blo_testsquare1);
            textView.setPadding(20, 20, 20, 20);
            this.binding.test6.addView(textView);
        }
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ActivityPendingProfile$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) MainActivity.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        finish();
    }

    public void getBlo() {
        this.viewModel.getBLO(this.partNumber).observe(this, new Observer() { // from class: in.gov.eci.bloapp.views.activity.ActivityPendingProfile$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.lambda$getBlo$3((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBlo$3(List list) {
        for (int i = 0; i < list.size(); i++) {
            this.firstName = ((BloModel) list.get(i)).getFirstName();
            this.binding.firstName.setText(this.firstName);
            this.mobileNumber = ((BloModel) list.get(i)).getMobNo();
            this.binding.mobileNumber.setText(this.mobileNumber);
            this.emailId = ((BloModel) list.get(i)).getEmail();
            this.binding.emailId.setText(this.emailId);
            this.officeAddress = ((BloModel) list.get(i)).getAddress();
            this.binding.officeAddress.setText(this.officeAddress);
        }
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.ActivityPendingProfile$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$getBlo$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBlo$2(View view) {
        finish();
    }
}
