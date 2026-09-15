package in.gov.eci.bloapp.views.fragments.h2h;

import android.R;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import androidx.activity.OnBackPressedCallback;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.ArraylistReturn;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentStatement3Binding;
import in.gov.eci.bloapp.languagetransliteration.FormsMethod;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.Verhoeff;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.StatementThreePreview;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class Statement3 extends BaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener, View.OnFocusChangeListener, View.OnTouchListener {
    private static final String SESSION = "Session Expired. Please Login again.";
    private int age1;
    String asmblyNO;
    BloFragmentStatement3Binding binding;
    Bundle bundle1;
    String districtCode;
    private ArrayAdapter genderadapter;
    private String houseno;
    String partLang;
    String refreshToken;
    private ArrayAdapter<String> relationadapter;
    String sectionNo;
    private String sectionNumber;
    private String stateCode;
    String token;
    final Calendar dobcalendar = Calendar.getInstance();
    final Calendar resicalendar = Calendar.getInstance();
    private final CommomUtility commonUtilClass = new CommomUtility();
    CommomUtility commomUtility = new CommomUtility();
    String sectionNoandName = "";
    String alert = "Alert";
    String alert1 = "Section Error - ";
    String alert2 = "Error - ";
    String sectionNumberCons = "sectionNo";
    String datePattern = "dd/MM/yyyy";
    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(this.datePattern);
    ArrayList<String> sectionNolist = new ArrayList<>();
    Gson gson = new GsonBuilder().setLenient().create();
    String loco = " ";
    String pwd = "N";
    String resstr = "";
    private boolean result = false;
    private String aadharref = " ";
    private String deaf = " ";
    private String visual = " ";
    private String other = " ";

    static /* synthetic */ void lambda$onCreateView$12(View view) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.bundle1 = new Bundle();
        this.binding = BloFragmentStatement3Binding.inflate(getLayoutInflater());
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.districtCode = SharedPref.getInstance(requireContext()).getDistrictCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        String assemblyName = SharedPref.getInstance(requireContext()).getAssemblyName();
        final String partNumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        getSection(this.stateCode, this.token, this.asmblyNO, partNumber);
        String partNumberLanguageName = SharedPref.getInstance(requireContext()).getPartNumberLanguageName();
        this.partLang = partNumberLanguageName;
        if (partNumberLanguageName == null || partNumberLanguageName.trim().isEmpty()) {
            this.partLang = "en_in";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(2, 9);
        boolean z = true;
        calendar.set(5, 1);
        calendar.set(1, 2007);
        final long time = calendar.getTime().getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.set(2, 9);
        calendar2.set(5, 1);
        calendar2.set(1, 2023);
        final long time2 = calendar2.getTime().getTime();
        Date date = new Date();
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date);
        calendar3.add(1, -calculateage());
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda0
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreateView$0(datePicker, i, i2, i3);
            }
        };
        final DatePickerDialog.OnDateSetListener onDateSetListener2 = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda13
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreateView$1(datePicker, i, i2, i3);
            }
        };
        this.binding.no.setChecked(true);
        this.binding.genderPersonalSpinner.setOnItemSelectedListener(this);
        this.binding.percentageEd.setEnabled(true);
        this.binding.home.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.houseno = arguments.getString("housenomain");
            this.sectionNoandName = arguments.getString(this.sectionNumberCons);
        }
        this.binding.resetTv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        this.binding.loco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda16
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.f$0.lambda$onCreateView$4(compoundButton, z2);
            }
        });
        this.binding.deaf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.f$0.lambda$onCreateView$5(compoundButton, z2);
            }
        });
        this.binding.visual.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.f$0.lambda$onCreateView$6(compoundButton, z2);
            }
        });
        this.binding.other.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.f$0.lambda$onCreateView$7(compoundButton, z2);
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(z) { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3.1
            public void handleOnBackPressed() {
                Statement3.this.openFragment(new H2HFragment(), "");
            }
        });
        this.binding.catRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda4
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$8(radioGroup, i);
            }
        });
        this.binding.stateSpinner.setText(this.asmblyNO + " - " + assemblyName);
        this.binding.assemblyEd.setText(partNumber);
        this.binding.eligiblelector.setText("1");
        this.binding.houseno.setText(this.houseno);
        this.binding.back.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$9(view);
            }
        });
        this.binding.Previewtv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$10(partNumber, view);
            }
        });
        this.binding.firstNameEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = Statement3.this.binding.firstNameEd.getText().toString();
                if (Statement3.this.binding.firstNameEd.getText().toString().matches("^[a-zA-Z\\s]+$")) {
                    return;
                }
                try {
                    Statement3.this.binding.firstNameEd.setText(string.substring(0, string.length() - 1));
                    Statement3.this.binding.firstNameEd.setSelection(Statement3.this.binding.firstNameEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if ((s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') && s != null && s.toString().isEmpty()) {
                    Statement3.this.binding.firstnameOfficial.getText().clear();
                }
            }
        });
        this.binding.firstnameOfficial.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    StringBuilder sb = new StringBuilder(Statement3.this.binding.firstnameOfficial.getText().toString());
                    sb.charAt(Statement3.this.binding.firstnameOfficial.getSelectionStart() - 1);
                    int selectionStart = Statement3.this.binding.firstnameOfficial.getSelectionStart() - 1;
                    if (Statement3.this.binding.firstnameOfficial.getText().toString().matches(RegexMatcher.TEHSIL_OFFICIAL)) {
                        sb.deleteCharAt(Statement3.this.binding.firstnameOfficial.getSelectionStart() - 1);
                        Statement3.this.binding.firstnameOfficial.setText(sb);
                        Statement3.this.binding.firstnameOfficial.setSelection(selectionStart);
                    }
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    return;
                }
                s.charAt(s.length() - 1);
            }
        });
        this.binding.firstnameOfficial.setOnFocusChangeListener(this);
        this.binding.surnameOfficial.setOnFocusChangeListener(this);
        this.binding.relativeNameOfficial.setOnFocusChangeListener(this);
        this.binding.relativeSurnameOfficial.setOnFocusChangeListener(this);
        this.binding.surNameEd.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = Statement3.this.binding.surNameEd.getText().toString();
                if (Statement3.this.binding.surNameEd.getText().toString().matches("^[a-zA-Z\\s]+$")) {
                    return;
                }
                try {
                    Statement3.this.binding.surNameEd.setText(string.substring(0, string.length() - 1));
                    Statement3.this.binding.surNameEd.setSelection(Statement3.this.binding.surNameEd.getText().toString().length());
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if ((s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') && s != null && s.toString().isEmpty()) {
                    Statement3.this.binding.surnameOfficial.getText().clear();
                }
            }
        });
        this.binding.relativeName.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = Statement3.this.binding.relativeName.getText().toString();
                if (Statement3.this.binding.relativeName.getText().toString().matches("^[a-zA-Z\\s]+$")) {
                    return;
                }
                try {
                    Statement3.this.binding.relativeName.setText(string.substring(0, string.length() - 1));
                    Statement3.this.binding.relativeName.setSelection(Statement3.this.binding.relativeName.getText().toString().length());
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if ((s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') && s != null && s.toString().isEmpty()) {
                    Statement3.this.binding.relativeNameOfficial.getText().clear();
                }
            }
        });
        this.binding.relativeSurname.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = Statement3.this.binding.relativeSurname.getText().toString();
                if (Statement3.this.binding.relativeSurname.getText().toString().matches("^[a-zA-Z\\s]+$")) {
                    return;
                }
                try {
                    Statement3.this.binding.relativeSurname.setText(string.substring(0, string.length() - 1));
                    Statement3.this.binding.relativeSurname.setSelection(Statement3.this.binding.relativeSurname.getText().toString().length());
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if ((s == null || s.length() <= 0 || s.charAt(s.length() - 1) != '@') && s != null && s.toString().isEmpty()) {
                    Statement3.this.binding.relativeSurnameOfficial.getText().clear();
                }
            }
        });
        this.binding.dobEd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$11(onDateSetListener, time, view);
            }
        });
        this.binding.residenceEd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$13(onDateSetListener2, time2, view);
            }
        });
        this.commonUtilClass.getRelation(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda11
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$onCreateView$14(i, arrayList, arrayList2);
            }
        });
        this.commonUtilClass.getGender(this.stateCode, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), getContext(), new ArraylistReturn() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda12
            @Override // in.gov.eci.bloapp.ArraylistReturn
            public final void onCallback(int i, ArrayList arrayList, ArrayList arrayList2) {
                this.f$0.lambda$onCreateView$15(i, arrayList, arrayList2);
            }
        });
        this.binding.aadharEd.setOnFocusChangeListener(this);
        this.binding.aadharEd.addTextChangedListener(new AnonymousClass7());
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) requireActivity(), R.layout.simple_spinner_dropdown_item, (List) this.sectionNolist);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.binding.sectionNo.setAdapter((SpinnerAdapter) arrayAdapter);
        this.binding.sectionNo.setSelection(0);
        this.binding.sectionNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3.8
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(DatePicker datePicker, int i, int i2, int i3) {
        this.dobcalendar.clear();
        this.dobcalendar.set(1, i);
        this.dobcalendar.set(2, i2);
        this.dobcalendar.set(5, i3);
        updateIssueDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(DatePicker datePicker, int i, int i2, int i3) {
        this.resicalendar.clear();
        this.resicalendar.set(1, i);
        updateIssueDate2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.loco = "Locomotive";
            this.binding.percentageEd.setEnabled(true);
        } else {
            this.loco = " ";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$5(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.deaf = "deaf";
            this.binding.percentageEd.setEnabled(true);
        } else {
            this.deaf = " ";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$6(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.visual = "visual";
            this.binding.percentageEd.setEnabled(true);
        } else {
            this.visual = " ";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$7(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.binding.otherEdDetails.setVisibility(0);
            this.other = "other";
            this.binding.percentageEd.setEnabled(true);
        } else {
            this.binding.otherEdDetails.setVisibility(8);
            this.other = " ";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$8(RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = this.binding.catRg.getCheckedRadioButtonId();
        if (checkedRadioButtonId != 2131364834) {
            if (checkedRadioButtonId == 2131366733) {
                this.binding.yes.setChecked(true);
                this.pwd = "Y";
                this.binding.categor.setVisibility(0);
                return;
            }
            this.binding.no.setChecked(true);
            return;
        }
        this.binding.no.setChecked(true);
        this.pwd = "N";
        this.binding.categor.setVisibility(8);
        this.binding.percentageEd.setText("");
        this.binding.loco.setChecked(false);
        this.binding.visual.setChecked(false);
        this.binding.deaf.setChecked(false);
        this.binding.other.setChecked(false);
        this.binding.otherEdDetails.setText("");
        this.loco = "";
        this.deaf = "";
        this.visual = "";
        this.other = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$9(View view) {
        requireActivity().getSupportFragmentManager().popBackStackImmediate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$10(String str, View view) {
        if (personal()) {
            Intent intent = new Intent(view.getContext(), (Class<?>) StatementThreePreview.class);
            try {
                intent.putExtra("stateCd", this.stateCode);
                intent.putExtra("districtCd", this.districtCode);
                intent.putExtra("acNo", this.asmblyNO);
                intent.putExtra(this.sectionNumberCons, this.binding.sectionNo.getSelectedItem().toString());
                intent.putExtra("partNo", str);
                intent.putExtra("houseNo", this.houseno);
                intent.putExtra("gender", this.binding.genderPersonalSpinner.getSelectedItem().toString());
                intent.putExtra("serialNo", this.binding.sno.getText().toString());
                intent.putExtra("electors", this.binding.eligiblelector.getText().toString());
                intent.putExtra(Constants.FIRST_NAME, this.binding.firstNameEd.getText().toString());
                intent.putExtra(Constants.LAST_NAME, this.binding.surNameEd.getText().toString());
                intent.putExtra("firstNameL1", this.binding.firstnameOfficial.getText().toString());
                intent.putExtra("lastNameL1", this.binding.surnameOfficial.getText().toString());
                intent.putExtra("relativeType", this.binding.relationSpinner.getSelectedItem().toString());
                intent.putExtra("relativeFirstName", this.binding.relativeName.getText().toString());
                intent.putExtra("relativeLastName", this.binding.relativeSurname.getText().toString());
                intent.putExtra("relativeFirstNameL1", this.binding.relativeNameOfficial.getText().toString());
                intent.putExtra("relativeLastNameL1", this.binding.relativeSurnameOfficial.getText().toString());
                intent.putExtra("dob", this.binding.dobEd.getText().toString());
                intent.putExtra("age", "");
                intent.putExtra("isPwd", this.pwd);
                intent.putExtra("percentagePwd", this.binding.percentageEd.getText().toString());
                intent.putExtra("isLocomotive", this.loco);
                intent.putExtra("isVisual", this.visual);
                intent.putExtra("isDeafDumb", this.deaf);
                intent.putExtra("isOtherDisability", this.other);
                intent.putExtra("otherDisability", this.binding.otherEdDetails.getText().toString());
                intent.putExtra("aadharNo", this.binding.aadharEd.getText().toString());
                intent.putExtra("mobileNo", this.binding.mobileNumEd.getText().toString());
                intent.putExtra("email", this.binding.emailEd.getText().toString());
                intent.putExtra("residingPeriod", this.resstr);
                intent.putExtra("aadharref", this.aadharref);
                intent.putExtra("age1", this.age1);
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$11(DatePickerDialog.OnDateSetListener onDateSetListener, long j, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.dobcalendar.get(1), this.dobcalendar.get(2), this.dobcalendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(j);
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$13(DatePickerDialog.OnDateSetListener onDateSetListener, long j, View view) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(simpleDateFormat.format((Date) Objects.requireNonNull(this.simpleDateFormat1.parse(this.binding.dobEd.getText().toString())))));
        } catch (ParseException e) {
            Logger.d("", e.getMessage());
        }
        long time = calendar.getTime().getTime();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, this.resicalendar.get(1), this.resicalendar.get(2), this.resicalendar.get(5));
        datePickerDialog.getDatePicker().setMinDate(time);
        datePickerDialog.getDatePicker().setMaxDate(j);
        datePickerDialog.getDatePicker().setSpinnersShown(true);
        ((View) datePickerDialog.getDatePicker().getTouchables().get(0)).performClick();
        ((View) datePickerDialog.getDatePicker().getTouchables().get(1)).setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Statement3.lambda$onCreateView$12(view2);
            }
        });
        datePickerDialog.getDatePicker().getYear();
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$14(int i, ArrayList arrayList, ArrayList arrayList2) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.simple_spinner_item, arrayList);
        this.relationadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.binding.relationSpinner.setAdapter((SpinnerAdapter) this.relationadapter);
        this.binding.relationSpinner.setSelection(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$15(int i, ArrayList arrayList, ArrayList arrayList2) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.simple_spinner_item, arrayList);
        this.genderadapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.binding.genderPersonalSpinner.setAdapter((SpinnerAdapter) this.genderadapter);
        this.binding.genderPersonalSpinner.setSelection(0);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.Statement3$7, reason: invalid class name */
    class AnonymousClass7 implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        AnonymousClass7() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (Statement3.this.binding.aadharEd.getText().toString().length() == 12) {
                Statement3.this.showProgressVisible();
                String string = Statement3.this.binding.aadharEd.getText().toString();
                Statement3.this.result = Verhoeff.validateVerhoeff(string);
                if (!Statement3.this.result) {
                    Statement3.this.showProgressInVisible();
                    Statement3.this.showdialog("", "Please Enter Correct Aadhaar Number.");
                } else {
                    Statement3.this.commonUtilClass.getaadharref(Statement3.this.getContext(), Statement3.this.stateCode, Statement3.this.token, Statement3.this.binding.aadharEd.getText().toString(), SharedPref.getInstance(Statement3.this.requireContext()).getAtknBnd(), SharedPref.getInstance(Statement3.this.requireContext()).getRtknBnd(), "H2H", new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$7$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str, String str2) {
                            this.f$0.lambda$onTextChanged$2(i, str, str2);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$2(int i, String str, String str2) {
            if (i != 200) {
                if (i == 401) {
                    Statement3.this.showProgressInVisible();
                    Statement3.this.commomUtility.showMessageWithTitleOK(Statement3.this.requireContext(), Statement3.this.alert, "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$7$$ExternalSyntheticLambda2
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onTextChanged$1(dialogInterface, i2);
                        }
                    });
                } else if (str2 != null) {
                    Statement3.this.showdialog(Statement3.this.alert2 + i, str2);
                    Statement3.this.showProgressInVisible();
                } else {
                    Statement3.this.showdialog(Statement3.this.alert2 + i, null);
                    Statement3.this.showProgressInVisible();
                }
                Statement3.this.showProgressInVisible();
                return;
            }
            if (str.equals("N") || str.equals("n")) {
                Statement3.this.showdialog("Invalid Aadhaar", str2);
                Statement3.this.showProgressInVisible();
            } else {
                Statement3.this.aadharref = str2;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$7$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTextChanged$0();
                    }
                }, 2000L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$0() {
            Statement3.this.showProgressInVisible();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Statement3.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Statement3.this.getContext()).setLocaleBool(false);
            Statement3.this.startActivity(new Intent((Context) Statement3.this.getActivity(), (Class<?>) LoginActivity.class));
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.getId() == 2131363873 && hasFocus) {
            if (this.binding.firstNameEd.getText().toString().isEmpty()) {
                this.binding.firstnameOfficial.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.firstNameEd.getText().toString().trim(), this.binding.firstnameOfficial, this.partLang, "NAME");
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            }
        }
        if (v.getId() == 2131365972 && hasFocus) {
            if (this.binding.surNameEd.getText().toString().isEmpty()) {
                this.binding.surnameOfficial.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.surNameEd.getText().toString().trim(), this.binding.surnameOfficial, this.partLang, "NAME");
                } catch (Exception e2) {
                    Logger.d("", e2.getMessage());
                }
            }
        }
        if (v.getId() == 2131365436 && hasFocus) {
            if (this.binding.relativeName.getText().toString().isEmpty()) {
                this.binding.relativeNameOfficial.setText("");
            } else {
                try {
                    FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeName.getText().toString().trim(), this.binding.relativeNameOfficial, this.partLang, "NAME");
                } catch (Exception e3) {
                    Logger.d("", e3.getMessage());
                }
            }
        }
        if (2131365447 == v.getId() && hasFocus) {
            if (this.binding.relativeSurname.getText().toString().isEmpty()) {
                this.binding.relativeSurnameOfficial.setText("");
                return;
            }
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeSurname.getText().toString().trim(), this.binding.relativeSurnameOfficial, this.partLang, "NAME");
            } catch (Exception e4) {
                Logger.d("", e4.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(in.gov.eci.bloapp.R.id.frame, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent motionEvent) {
        if (v.getId() == 2131363873) {
            this.binding.firstnameOfficial.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.firstNameEd.getText().toString().trim(), this.binding.firstnameOfficial, this.partLang, "NAME");
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
            return true;
        }
        if (v.getId() == 2131365972) {
            this.binding.surnameOfficial.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.surNameEd.getText().toString().trim(), this.binding.surnameOfficial, this.partLang, "NAME");
            } catch (Exception e2) {
                Logger.d("", e2.getMessage());
            }
            return true;
        }
        if (v.getId() == 2131365436) {
            this.binding.relativeNameOfficial.requestFocus();
            try {
                FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeName.getText().toString().trim(), this.binding.relativeNameOfficial, this.partLang, "NAME");
            } catch (Exception e3) {
                Logger.d("", e3.getMessage());
            }
            return true;
        }
        if (v.getId() != 2131365447) {
            return false;
        }
        this.binding.relativeSurnameOfficial.requestFocus();
        try {
            FormsMethod.translitrationAutoCompleteTextView(requireActivity(), this.binding.relativeSurname.getText().toString().trim(), this.binding.relativeSurnameOfficial, this.partLang, "NAME");
        } catch (Exception e4) {
            Logger.d("", e4.getMessage());
        }
        return true;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    public void updateIssueDate() {
        this.binding.dobEd.setText(new SimpleDateFormat(this.datePattern, Locale.US).format(this.dobcalendar.getTime()));
    }

    public void updateIssueDate2() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.datePattern, Locale.US);
        this.resstr = simpleDateFormat.format(this.resicalendar.getTime());
        this.binding.residenceEd.setText(simpleDateFormat.format(this.resicalendar.getTime()).substring(6, 10));
    }

    public void reset() {
        this.binding.sno.setText("");
        this.binding.firstNameEd.setText("");
        this.binding.firstnameOfficial.setText("");
        this.binding.surNameEd.setText("");
        this.binding.surnameOfficial.setText("");
        this.binding.relationSpinner.setSelection(0);
        this.binding.relativeName.setText("");
        this.binding.relativeNameOfficial.setText("");
        this.binding.relativeSurname.setText("");
        this.binding.relativeSurnameOfficial.setText("");
        this.binding.genderPersonalSpinner.setSelection(0);
        this.binding.dobEd.setText("");
        this.binding.residenceEd.setText("");
        this.binding.no.setChecked(true);
        this.binding.no.setChecked(true);
        this.binding.categor.setVisibility(8);
        this.binding.percentageEd.setText("");
        this.binding.loco.setChecked(false);
        this.binding.visual.setChecked(false);
        this.binding.deaf.setChecked(false);
        this.binding.other.setChecked(false);
        this.binding.otherEdDetails.setText("");
        this.loco = "";
        this.deaf = "";
        this.visual = "";
        this.other = "";
        this.age1 = 0;
        this.aadharref = "";
        this.binding.aadharEd.setText("");
        this.aadharref = "";
        this.binding.mobileNumEd.setText("");
        this.binding.emailEd.setText("");
        this.binding.residenceEd.setText("");
        this.binding.sectionNo.setSelection(0);
    }

    public boolean personal() {
        this.age1 = calculateage();
        if (this.binding.sno.getText().toString().isEmpty()) {
            this.binding.sno.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), in.gov.eci.bloapp.R.color.blo_red));
        } else {
            this.binding.sno.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), in.gov.eci.bloapp.R.color.blo_black));
        }
        if (this.binding.firstNameEd.getText().toString().isEmpty()) {
            this.binding.firstNameEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), in.gov.eci.bloapp.R.color.blo_red));
        } else {
            this.binding.firstNameEd.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), in.gov.eci.bloapp.R.color.blo_black));
        }
        if (this.binding.firstnameOfficial.getText().toString().isEmpty()) {
            this.binding.firstNameText.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), in.gov.eci.bloapp.R.color.blo_red));
        } else {
            this.binding.firstNameText.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), in.gov.eci.bloapp.R.color.blo_black));
        }
        if (this.binding.relativeName.getText().toString().isEmpty()) {
            this.binding.relativeName.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), in.gov.eci.bloapp.R.color.blo_red));
        } else {
            this.binding.relativeName.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), in.gov.eci.bloapp.R.color.blo_black));
        }
        if (this.binding.relativeNameOfficial.getText().toString().isEmpty()) {
            this.binding.relativenameText.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), in.gov.eci.bloapp.R.color.blo_red));
        } else {
            this.binding.relativenameText.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), in.gov.eci.bloapp.R.color.blo_black));
        }
        if (this.binding.sno.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter serial no.");
            return false;
        }
        if (this.binding.firstNameEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter applicant first name in english");
            return false;
        }
        if (this.binding.firstnameOfficial.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter applicant first name in official language");
            return false;
        }
        if (!this.binding.surNameEd.getText().toString().isEmpty() && this.binding.surnameOfficial.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter applicant last name in official language");
            return false;
        }
        if (this.binding.relationSpinner.getSelectedItem().toString().equals("Select Relation Type")) {
            showdialog(this.alert, "Please select relation type");
            return false;
        }
        if (this.binding.relativeName.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter relative name in english");
            return false;
        }
        if (this.binding.relativeNameOfficial.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter relative name in official language");
            return false;
        }
        if (!this.binding.aadharEd.getText().toString().isEmpty() && this.binding.aadharEd.getText().toString().length() != 12) {
            showdialog(this.alert, "Please Enter Correct Aadhaar Number");
            return false;
        }
        if (!this.binding.aadharEd.getText().toString().isEmpty() && !this.result) {
            showdialog(this.alert, "Please Enter Correct Aadhaar Number");
            return false;
        }
        if (!this.binding.mobileNumEd.getText().toString().isEmpty() && this.binding.mobileNumEd.getText().toString().length() != 10) {
            showdialog(this.alert, "Please Enter Correct Mobile Number");
            return false;
        }
        if (!this.binding.mobileNumEd.getText().toString().isEmpty() && this.binding.mobileNumEd.getText().toString().length() == 10 && !this.binding.mobileNumEd.getText().toString().matches(RegexMatcher.MOBILE_REGEX)) {
            showdialog(this.alert, "Please Enter a Correct Mobile Number");
            return false;
        }
        if (!this.binding.emailEd.getText().toString().matches(RegexMatcher.EMAIL_REGEX) && !this.binding.emailEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter correct Email ID");
            return false;
        }
        if (this.binding.genderPersonalSpinner.getSelectedItem().toString().equals("Select Gender")) {
            showdialog(this.alert, "Please select gender");
            return false;
        }
        if (this.binding.genderPersonalSpinner.getSelectedItem().toString().equals("MALE") && this.binding.relationSpinner.getSelectedItem().toString().equals("HUSBAND")) {
            this.binding.relationSpinner.setSelection(0);
            showdialog(this.alert, "If gender is male then relation type should not be husband. Please select correct relation type.");
            return false;
        }
        if (this.binding.genderPersonalSpinner.getSelectedItem().toString().equals("FEMALE") && this.binding.relationSpinner.getSelectedItem().toString().equals("WIFE")) {
            this.binding.relationSpinner.setSelection(0);
            showdialog(this.alert, "If gender is female then relation type should not be wife. Please select correct relation type.");
            return false;
        }
        if (this.binding.dobEd.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please select Date of birth");
            return false;
        }
        if (this.binding.yes.isChecked() && this.binding.percentageEd.getText().toString().isEmpty()) {
            if (this.binding.percentageEd.getText().toString().isEmpty()) {
                showdialog(this.alert, "Please enter  acorrect percentage of disability");
                return false;
            }
            if (Integer.parseInt(this.binding.percentageEd.getText().toString()) <= 0) {
                showdialog(this.alert, "Please enter correct percentage of disability");
                return false;
            }
            if (this.binding.percentageEd.getText().length() == 3) {
                showdialog(this.alert, "Please enter correct percentage of a disability");
            }
            return false;
        }
        if (this.binding.yes.isChecked() && Integer.parseInt(this.binding.percentageEd.getText().toString()) <= 0) {
            showdialog(this.alert, "Please enter the correct percentage of disability");
            return false;
        }
        if (this.binding.yes.isChecked() && !this.binding.loco.isChecked() && !this.binding.deaf.isChecked() && !this.binding.visual.isChecked() && !this.binding.other.isChecked()) {
            if (!this.binding.percentageEd.getText().toString().isEmpty()) {
                showdialog(this.alert, "Please select any one of the checkbox");
            }
            return false;
        }
        if (this.binding.other.isChecked() && this.binding.otherEdDetails.getText().toString().isEmpty()) {
            showdialog(this.alert, "Please enter the reason");
            return false;
        }
        if (this.binding.genderPersonalSpinner.getSelectedItem().toString().equals("THIRD GENDER") && !this.binding.relationSpinner.getSelectedItem().toString().equals("FATHER") && !this.binding.relationSpinner.getSelectedItem().toString().equals("MOTHER")) {
            this.binding.relationSpinner.setSelection(0);
            showdialog(this.alert, "If gender is third gender then relation type should be Father or Mother. Please select correct relation type.");
            return false;
        }
        if (!this.binding.sectionNo.getSelectedItem().toString().equals("Select Section No. & Name")) {
            return true;
        }
        showdialog(this.alert, "Please select section number and Name.");
        return false;
    }

    public void getSection(String stateCode, String token, String asmblyNo, String partNo) {
        showProgressVisible();
        try {
            this.sectionNolist.clear();
            this.sectionNolist.add("Select Section No. & Name");
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getSection("ANDROIDMOB", token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode, "application/json", asmblyNo, partNo).enqueue(new AnonymousClass9());
        } catch (Exception e) {
            Logger.d("Content", e.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.h2h.Statement3$9, reason: invalid class name */
    class AnonymousClass9 implements Callback<JSONArray> {
        AnonymousClass9() {
        }

        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            if (response.code() == 200) {
                JSONArray jSONArray = (JSONArray) response.body();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.size(); i++) {
                    JsonObject asJsonObject = Statement3.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                    Statement3.this.sectionNumber = asJsonObject.get(Statement3.this.sectionNumberCons).getAsInt() + " - " + asJsonObject.get("sectionName").getAsString();
                    Statement3 statement3 = Statement3.this;
                    statement3.sectionNo = String.valueOf(asJsonObject.get(statement3.sectionNumberCons).getAsInt());
                    arrayList.add(String.valueOf(Statement3.this.sectionNumber));
                }
                Collections.sort(arrayList, new Comparator() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$9$$ExternalSyntheticLambda0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Statement3.AnonymousClass9.lambda$onResponse$0((String) obj, (String) obj2);
                    }
                });
                Statement3.this.sectionNolist.addAll(arrayList);
                Statement3.this.showProgressInVisible();
                return;
            }
            if (response.code() == 401) {
                Statement3.this.commonUtilClass.getRefreshToken(Statement3.this.requireContext(), Statement3.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$9$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str, String str2) {
                        this.f$0.lambda$onResponse$2(i2, str, str2);
                    }
                });
            }
            try {
                Statement3.this.commomUtility.showMessageWithTitleOK(Statement3.this.requireContext(), Statement3.this.alert1 + response.code(), new JSONObject(response.errorBody().string()).optString("message"), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$9$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
            } catch (IOException | JSONException e) {
                Statement3.this.commomUtility.showMessageWithTitleOK(Statement3.this.requireContext(), Statement3.this.alert1 + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$9$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                Logger.d("", e.getMessage());
            }
            Statement3.this.showProgressInVisible();
        }

        static /* synthetic */ int lambda$onResponse$0(String str, String str2) {
            return Integer.parseInt(str.split("-")[0].trim()) - Integer.parseInt(str2.split("-")[0].trim());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(int i, String str, String str2) {
            Statement3.this.showProgressInVisible();
            System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                Statement3.this.commonUtilClass.showMessageOK(Statement3.this.getContext(), Statement3.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.h2h.Statement3$9$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
                return;
            }
            Statement3.this.refreshToken = str2;
            SharedPref.getInstance(Statement3.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(Statement3.this.requireContext()).setToken("Bearer " + str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Statement3.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Statement3.this.requireContext()).setLocaleBool(false);
            Statement3.this.startActivity(new Intent((Context) Statement3.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JSONArray> call, Throwable t) {
            Statement3.this.showProgressInVisible();
        }
    }

    private int calculateage() {
        String str;
        if (this.binding.dobEd.getText().toString().isEmpty()) {
            return 0;
        }
        try {
            str = new SimpleDateFormat("yyyy-MM-dd").format(this.simpleDateFormat1.parse(this.binding.dobEd.getText().toString()));
        } catch (ParseException e) {
            Logger.d("", e.getMessage());
            str = null;
        }
        LocalDate localDate = LocalDate.parse(str);
        LocalDate localDateNow = LocalDate.now();
        if (localDate == null || localDateNow == null) {
            return 0;
        }
        return Period.between(localDate, localDateNow).getYears();
    }
}
