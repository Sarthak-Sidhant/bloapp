package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import in.gov.eci.bloapp.databinding.BloActivitySurveyPreviewBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import java.time.LocalDate;
import java.time.Period;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SurveyPreview extends AppCompatActivity {
    BloActivitySurveyPreviewBinding binding;
    Bundle bundle;
    String stateCode;
    String token;

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivitySurveyPreviewBinding bloActivitySurveyPreviewBindingInflate = BloActivitySurveyPreviewBinding.inflate(getLayoutInflater());
        this.binding = bloActivitySurveyPreviewBindingInflate;
        setContentView(bloActivitySurveyPreviewBindingInflate.getRoot());
        this.binding.back.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SurveyPreview$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.token = SharedPref.getInstance(this).getToken();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        String assemblyNumber = SharedPref.getInstance(this).getAssemblyNumber();
        String assemblyName = SharedPref.getInstance(this).getAssemblyName();
        String partNumber = SharedPref.getInstance(this).getPartNumber();
        this.binding.stateSpinner.setText(assemblyNumber + " - " + assemblyName);
        this.binding.home.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SurveyPreview$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            this.bundle = intent.getExtras();
            try {
                JSONObject jSONObject = new JSONObject(this.bundle.getString("json"));
                this.binding.sno.setText(String.valueOf(jSONObject.get("serialNo")));
                this.binding.houseno.setText(String.valueOf(jSONObject.get("houseNo")));
                this.binding.eleigibleElector.setText(String.valueOf(jSONObject.get("houseNo")));
                this.binding.firstNameEd.setText(String.valueOf(jSONObject.get(Constants.FIRST_NAME)));
                this.binding.firstNamehEd.setText(String.valueOf(jSONObject.get("firstNameL1")));
                this.binding.surNameEd.setText(String.valueOf(jSONObject.get(Constants.LAST_NAME)));
                this.binding.surNametv.setText(String.valueOf(jSONObject.get("lastNameL1")));
                this.binding.relationSpinner.setText(String.valueOf(jSONObject.get("relativeType")));
                this.binding.relativeName.setText(String.valueOf(jSONObject.get("relativeFirstName")));
                this.binding.relativeNameOfficial.setText(String.valueOf(jSONObject.get("relativeFirstNameL1")));
                this.binding.relativeSurname.setText(String.valueOf(jSONObject.get("relativeLastName")));
                this.binding.relativeSurnameOfficial.setText(String.valueOf(jSONObject.get("relativeLastNameL1")));
                if (String.valueOf(jSONObject.get("gender")).equals("F")) {
                    this.binding.genderPersonalSpinner.setText("Female");
                }
                if (String.valueOf(jSONObject.get("gender")).equals("M")) {
                    this.binding.genderPersonalSpinner.setText("Male");
                }
                if (String.valueOf(jSONObject.get("gender")).equals("T")) {
                    this.binding.genderPersonalSpinner.setText("Third Gender");
                }
                this.binding.aadharEd.setText(String.valueOf(jSONObject.get("aadharNo")));
                this.binding.emailEd.setText(String.valueOf(jSONObject.get("email")));
                this.binding.mobileEd.setText(String.valueOf(jSONObject.get("mobileNo")));
                if (String.valueOf(jSONObject.get("residingPeriod")).equals("")) {
                    this.binding.residenceEd.setText("");
                } else {
                    this.binding.residenceEd.setText(String.valueOf(jSONObject.get("residingPeriod")));
                }
                this.binding.sectionEd.setText(String.valueOf(jSONObject.get("sectionNo")));
                this.binding.dobEd.setText(calculateage(String.valueOf(jSONObject.get("dob"))) + " /" + jSONObject.get("dob"));
                if (String.valueOf(jSONObject.get("isPwd")).equals("N")) {
                    this.binding.no.setChecked(true);
                    this.binding.categor.setVisibility(8);
                    this.binding.loco.setChecked(false);
                    this.binding.visual.setChecked(false);
                    this.binding.deaf.setChecked(false);
                    this.binding.other.setChecked(false);
                    this.binding.otherEdDetails.setText("");
                } else {
                    this.binding.yes.setChecked(true);
                    this.binding.categor.setVisibility(0);
                    if (String.valueOf(jSONObject.get("isLocomotive")).equals("Locomotive")) {
                        this.binding.loco.setChecked(true);
                    }
                    if (String.valueOf(jSONObject.get("isVisual")).equals("visual")) {
                        this.binding.visual.setChecked(true);
                    }
                    if (String.valueOf(jSONObject.get("isDeafDumb")).equals("deaf")) {
                        this.binding.deaf.setChecked(true);
                    }
                    if (String.valueOf(jSONObject.get("isOtherDisability")).equals("other")) {
                        this.binding.other.setChecked(true);
                        this.binding.otherEdDetails.setVisibility(0);
                        this.binding.otherEdDetails.setText("(" + jSONObject.get("otherDisability") + ")");
                    }
                    this.binding.percent.setText(String.valueOf(jSONObject.get("percentagePwd")));
                }
                this.binding.yes.setClickable(false);
                this.binding.no.setClickable(false);
            } catch (JSONException e) {
                Logger.d("", e.getMessage());
            }
        }
        this.binding.partNumber.setText(partNumber);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        startActivity(new Intent((Context) this, (Class<?>) MainActivity.class));
        finish();
    }

    private int calculateage(String dobdate) {
        if (dobdate.isEmpty()) {
            return 0;
        }
        LocalDate localDate = LocalDate.parse(dobdate);
        LocalDate localDateNow = LocalDate.now();
        if (localDate == null || localDateNow == null) {
            return 0;
        }
        return Period.between(localDate, localDateNow).getYears();
    }
}
