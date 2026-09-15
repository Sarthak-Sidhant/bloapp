package in.gov.eci.bloapp.views.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.databinding.BloActivityStatementThreePreviewBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.fragments.FormsResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class StatementThreePreview extends AppCompatActivity {
    String asmblyNO;
    BloActivityStatementThreePreviewBinding binding;
    Bundle bundle;
    private String districtCode;
    private String partNo;
    String stateCode;
    String token;
    private final CommomUtility commonUtilClass = new CommomUtility();
    String sessionTokenText = "Session token expired please Login";
    String serialNoString = "serialNo";
    String houseNoStr = "houseNo";
    String electorStr = "electors";
    String firstNameStr = Constants.FIRST_NAME;
    String firstNamelaStr = "firstNameL1";
    String lastName = Constants.LAST_NAME;
    String lastNameL1 = "lastNameL1";
    String relativeType = "relativeType";
    String relativeFirstName = "relativeFirstName";
    String relativeFirstNameL1 = "relativeFirstNameL1";
    String relativeLastName = "relativeLastName";
    String relativeLastNameL1 = "relativeLastNameL1";
    String gender = "gender";
    String residingPeriod = "residingPeriod";
    String sectionNo = "sectionNo";
    String isLocomotive = "isLocomotive";
    String otherDisability = "otherDisability";
    String isOtherDisability = "isOtherDisability";
    String isDeafDumb = "isDeafDumb";
    String isVisual = "isVisual";

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityStatementThreePreviewBinding bloActivityStatementThreePreviewBindingInflate = BloActivityStatementThreePreviewBinding.inflate(getLayoutInflater());
        this.binding = bloActivityStatementThreePreviewBindingInflate;
        setContentView(bloActivityStatementThreePreviewBindingInflate.getRoot());
        this.binding.back.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.StatementThreePreview$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.keepeditingtv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.StatementThreePreview$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.token = SharedPref.getInstance(this).getToken();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        this.districtCode = SharedPref.getInstance(this).getDistrictCode();
        this.asmblyNO = SharedPref.getInstance(this).getAssemblyNumber();
        String assemblyName = SharedPref.getInstance(this).getAssemblyName();
        this.partNo = SharedPref.getInstance(this).getPartNumber();
        this.binding.stateSpinner.setText(this.asmblyNO + " - " + assemblyName);
        this.binding.partNumber.setText(this.partNo);
        Intent intent = getIntent();
        if (intent != null) {
            this.bundle = intent.getExtras();
            this.binding.sno.setText(this.bundle.getString(this.serialNoString));
            this.binding.houseno.setText(this.bundle.getString(this.houseNoStr));
            this.binding.eleigibleElector.setText(this.bundle.getString(this.electorStr));
            this.binding.firstNameEd.setText(this.bundle.getString(this.firstNameStr));
            this.binding.firstNamehEd.setText(this.bundle.getString(this.firstNamelaStr));
            this.binding.surNameEd.setText(this.bundle.getString(this.lastName));
            this.binding.surNametv.setText(this.bundle.getString(this.lastNameL1));
            this.binding.relationSpinner.setText(this.bundle.getString(this.relativeType));
            this.binding.relativeName.setText(this.bundle.getString(this.relativeFirstName));
            this.binding.relativeNameOfficial.setText(this.bundle.getString(this.relativeFirstNameL1));
            this.binding.relativeSurname.setText(this.bundle.getString(this.relativeLastName));
            this.binding.relativeSurnameOfficial.setText(this.bundle.getString(this.relativeLastNameL1));
            this.binding.genderPersonalSpinner.setText(this.bundle.getString(this.gender));
            if (this.bundle.getString("aadharNo").length() == 12) {
                this.binding.aadharEd.setText("********" + this.bundle.getString("aadharNo").substring(8, 12));
            } else {
                this.binding.aadharEd.setText(this.bundle.getString("aadharNo"));
            }
            this.binding.emailEd.setText(this.bundle.getString("email"));
            this.binding.mobileEd.setText(this.bundle.getString("mobileNo"));
            if (!this.bundle.getString(this.residingPeriod).equals("")) {
                this.binding.residenceEd.setText(this.bundle.getString(this.residingPeriod).substring(6, 10));
            } else {
                this.binding.residenceEd.setText("");
            }
            this.binding.sectionEd.setText(this.bundle.getString(this.sectionNo));
            this.binding.dobEd.setText(this.bundle.getString("dob"));
            if (this.bundle.getString("isPwd").equals("N")) {
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
                if (this.bundle.getString(this.isLocomotive).equals("Locomotive")) {
                    this.binding.loco.setChecked(true);
                }
                if (this.bundle.getString(this.isVisual).equals("visual")) {
                    this.binding.visual.setChecked(true);
                }
                if (this.bundle.getString(this.isDeafDumb).equals("deaf")) {
                    this.binding.deaf.setChecked(true);
                }
                if (this.bundle.getString(this.isOtherDisability).equals("other")) {
                    this.binding.other.setChecked(true);
                    this.binding.otherEdDetails.setVisibility(0);
                    this.binding.otherEdDetails.setText("(" + this.bundle.getString(this.otherDisability) + ")");
                }
                this.binding.percent.setText(this.bundle.getString("percentagePwd"));
            }
        }
        this.binding.yes.setClickable(false);
        this.binding.no.setClickable(false);
        this.binding.submittv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.StatementThreePreview$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Have you verified the information?");
        builder.setTitle("Alert");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.StatementThreePreview$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$onCreate$2(dialogInterface, i);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.StatementThreePreview$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(DialogInterface dialogInterface, int i) {
        createcsv();
    }

    public void createcsv() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<String, Object> map = new HashMap<>();
        map.put("stateCd", this.stateCode);
        map.put("districtCd", this.districtCode);
        map.put("acNo", this.asmblyNO);
        String str = this.sectionNo;
        map.put(str, this.bundle.getString(str).substring(0, this.bundle.getString(this.sectionNo).indexOf(32)));
        map.put("partNo", this.partNo);
        String str2 = this.houseNoStr;
        map.put(str2, this.bundle.getString(str2));
        if (this.bundle.getString(this.gender).equals("FEMALE")) {
            map.put(this.gender, "F");
        } else if (this.bundle.getString(this.gender).equals("MALE")) {
            map.put(this.gender, "M");
        } else {
            map.put(this.gender, "T");
        }
        String str3 = this.serialNoString;
        map.put(str3, this.bundle.getString(str3));
        String str4 = this.electorStr;
        map.put(str4, this.bundle.getString(str4));
        String str5 = this.firstNameStr;
        map.put(str5, this.bundle.getString(str5));
        String str6 = this.lastName;
        map.put(str6, this.bundle.getString(str6));
        String str7 = this.firstNamelaStr;
        map.put(str7, this.bundle.getString(str7));
        String str8 = this.lastNameL1;
        map.put(str8, this.bundle.getString(str8));
        String string = this.bundle.getString(this.relativeType);
        string.hashCode();
        switch (string) {
            case "MOTHER":
                map.put(this.relativeType, this.bundle.getString("MTHR"));
                break;
            case "WIFE":
                map.put(this.relativeType, this.bundle.getString("WIFE"));
                break;
            case "HUSBAND":
                map.put(this.relativeType, this.bundle.getString("HSBN"));
                break;
            case "FATHER":
                map.put(this.relativeType, this.bundle.getString("FTHR"));
                break;
            default:
                map.put(this.relativeType, this.bundle.getString("OTHR"));
                break;
        }
        map.put("relativeFirstName", this.bundle.getString("relativeFirstName"));
        String str9 = this.relativeLastName;
        map.put(str9, this.bundle.getString(str9));
        String str10 = this.relativeFirstNameL1;
        map.put(str10, this.bundle.getString(str10));
        String str11 = this.relativeLastNameL1;
        map.put(str11, this.bundle.getString(str11));
        try {
            map.put("dob", simpleDateFormat2.format(simpleDateFormat.parse(this.bundle.getString("dob"))));
        } catch (ParseException e) {
            Logger.d("ttsd", e.getMessage());
        }
        map.put("age", this.bundle.getString("age1"));
        if (this.binding.other.isChecked()) {
            map.put(this.isOtherDisability, "Y");
            String str12 = this.otherDisability;
            map.put(str12, this.bundle.getString(str12));
        } else {
            map.put(this.isOtherDisability, "N");
        }
        if (this.binding.loco.isChecked()) {
            map.put(this.isLocomotive, "Y");
        } else {
            map.put(this.isLocomotive, "N");
        }
        if (this.binding.deaf.isChecked()) {
            map.put(this.isDeafDumb, "Y");
        } else {
            map.put(this.isDeafDumb, "N");
        }
        if (this.binding.visual.isChecked()) {
            map.put(this.isVisual, "Y");
        } else {
            map.put(this.isVisual, "N");
        }
        map.put("isPwd", this.bundle.getString("isPwd"));
        map.put("percentagePwd", this.binding.percent.getText().toString());
        map.put("aadharNo", this.bundle.getString("aadharref"));
        map.put("mobileNo", this.binding.mobileEd.getText().toString());
        map.put("email", this.binding.emailEd.getText().toString());
        try {
            String str13 = this.residingPeriod;
            map.put(str13, simpleDateFormat2.format(simpleDateFormat.parse(this.bundle.getString(str13))).substring(0, 4));
        } catch (ParseException e2) {
            Logger.d("ttsd", e2.getMessage());
        }
        this.commonUtilClass.submitstatement3(getApplicationContext(), this.stateCode, this.token, map, new FormsResponse() { // from class: in.gov.eci.bloapp.views.activity.StatementThreePreview$$ExternalSyntheticLambda9
            @Override // in.gov.eci.bloapp.views.fragments.FormsResponse
            public final void onCallback(int i, String str14) {
                this.f$0.lambda$createcsv$7(i, str14);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$createcsv$7(final int i, final String str) {
        if (i == 200) {
            showdialog1("Success", str);
        } else {
            if (i == 401) {
                showdialog1("Error ", str);
                this.commonUtilClass.getRefreshToken(this, SharedPref.getInstance(getApplicationContext()).getRefreshToken(), new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.StatementThreePreview$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$createcsv$6(i, str, i2, str2, str3);
                    }
                });
                return;
            }
            showdialog2(String.valueOf(i), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$createcsv$6(int i, String str, int i2, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb " + i2 + " " + str2 + " " + str3);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(this, this.sessionTokenText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.StatementThreePreview$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$createcsv$5(dialogInterface, i3);
                }
            });
            return;
        }
        System.out.println("zxnbchdbvfhvb ---> else refresh" + i + " " + str + " ");
        this.token = "Bearer " + str2;
        SharedPref.getInstance(getApplicationContext()).setRefreshToken(str3);
        SharedPref.getInstance(getApplicationContext()).setToken("Bearer " + str2);
        createcsv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createcsv$5(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(getApplicationContext()).setIsLoggedIn(false);
        SharedPref.getInstance(getApplicationContext()).setLocaleBool(false);
        startActivity(new Intent(getApplicationContext(), (Class<?>) LoginActivity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialog1(String success, String msg) {
        new AlertDialog.Builder(this).setTitle(success).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.StatementThreePreview$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog1$8(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showdialog1$8(DialogInterface dialogInterface, int i) {
        startActivity(new Intent((Context) this, (Class<?>) MainActivity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialog2(String success, String msg) {
        new AlertDialog.Builder(this).setTitle(success).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.StatementThreePreview$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog2$9(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showdialog2$9(DialogInterface dialogInterface, int i) {
        startActivity(new Intent((Context) this, (Class<?>) MainActivity.class));
    }
}
