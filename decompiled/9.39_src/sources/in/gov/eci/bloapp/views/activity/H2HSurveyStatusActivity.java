package in.gov.eci.bloapp.views.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.databinding.BloActivityH2HsurveyStatusBinding;
import in.gov.eci.bloapp.databinding.BloAllStatusRvItemsBinding;
import in.gov.eci.bloapp.model.ElectroleDeatils.H2HSurveyStatusModel;
import in.gov.eci.bloapp.room.database.ElectorDetailsDatabaseHelper;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class H2HSurveyStatusActivity extends AppCompatActivity {
    BloActivityH2HsurveyStatusBinding BloActivityH2HsurveyStatusBinding;
    GenericRecyclerView adapter;
    ElectorDetailsDatabaseHelper electorDetailsDatabaseHelper;
    long minFromDate;
    long minToDate;
    String logTag = "H2HSurveyStatusActivity";
    String formTypeText = "Form Type";
    String formType = "";
    String form7Text = "form7";
    String form8Text = "form8";
    String alertText = "Alert";
    String dateFormat = "dd/MM/yyyy";
    String dateFormat1 = "yyyy-MM-dd";
    Calendar fromdatecalendar = Calendar.getInstance();
    Calendar todatecalendar = Calendar.getInstance();
    String formattedFromDate = "";
    String formattedToDate = "";
    List<H2HSurveyStatusModel.Payload> h2hSurveyStatusDraftList = new ArrayList();
    List<H2HSurveyStatusModel.Payload> h2hSurveyListToExport = new ArrayList();
    String token = "";
    String stateCode = "";
    String asmblyNO = "";
    String bloId = "";
    String partNo = "";

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityH2HsurveyStatusBinding bloActivityH2HsurveyStatusBindingInflate = BloActivityH2HsurveyStatusBinding.inflate(getLayoutInflater());
        this.BloActivityH2HsurveyStatusBinding = bloActivityH2HsurveyStatusBindingInflate;
        setContentView(bloActivityH2HsurveyStatusBindingInflate.getRoot());
        this.token = SharedPref.getInstance(this).getToken();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        this.asmblyNO = SharedPref.getInstance(this).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(this).getPartNumber();
        this.bloId = SharedPref.getInstance(this).getPreferredUsername();
        Logger.d(this.logTag, "token -- > " + this.token);
        Logger.d(this.logTag, "stateCode -- > " + this.stateCode);
        Logger.d(this.logTag, "asmblyNO -- > " + this.asmblyNO);
        Logger.d(this.logTag, "partNo -- > " + this.partNo);
        Logger.d(this.logTag, "bloId -- > " + this.bloId);
        this.electorDetailsDatabaseHelper = ElectorDetailsDatabaseHelper.getDB(this);
        this.BloActivityH2HsurveyStatusBinding.back.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.BloActivityH2HsurveyStatusBinding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            this.formType = intent.getExtras().getString(this.formTypeText);
            Logger.d(this.logTag, "formTypeText -- > " + this.formType);
        }
        if (this.formType.equals(this.form7Text)) {
            this.BloActivityH2HsurveyStatusBinding.title.setText(String.format(getString(R.string.blo_Form_7_Status), new Object[0]));
        } else if (this.formType.equals(this.form8Text)) {
            this.BloActivityH2HsurveyStatusBinding.title.setText(String.format(getString(R.string.blo_Form_8_Status), new Object[0]));
        }
        initRecyclerViewAdapter();
        this.BloActivityH2HsurveyStatusBinding.allStatusRv.setLayoutManager(new GridLayoutManager(this, 1, 1, false));
        this.BloActivityH2HsurveyStatusBinding.allStatusRv.setAdapter(this.adapter);
        this.BloActivityH2HsurveyStatusBinding.download.setEnabled(false);
        this.BloActivityH2HsurveyStatusBinding.download.setBackgroundResource(R.drawable.blo_disabled_btn);
        this.BloActivityH2HsurveyStatusBinding.detailsLayout.setVisibility(8);
        this.BloActivityH2HsurveyStatusBinding.resultHeader.setVisibility(8);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, -125);
        this.minFromDate = calendar.getTime().getTime();
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusActivity$$ExternalSyntheticLambda7
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreate$2(datePicker, i, i2, i3);
            }
        };
        this.BloActivityH2HsurveyStatusBinding.fromDateEd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(onDateSetListener, view);
            }
        });
        this.BloActivityH2HsurveyStatusBinding.toDateEd.setEnabled(false);
        final DatePickerDialog.OnDateSetListener onDateSetListener2 = new DatePickerDialog.OnDateSetListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusActivity$$ExternalSyntheticLambda9
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$onCreate$4(datePicker, i, i2, i3);
            }
        };
        this.BloActivityH2HsurveyStatusBinding.toDateEd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(onDateSetListener2, view);
            }
        });
        this.BloActivityH2HsurveyStatusBinding.serialNumberEd.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.BloActivityH2HsurveyStatusBinding.showResults.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.BloActivityH2HsurveyStatusBinding.download.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$10(view);
            }
        });
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(DatePicker datePicker, int i, int i2, int i3) {
        this.fromdatecalendar.clear();
        this.fromdatecalendar.set(1, i);
        this.fromdatecalendar.set(2, i2);
        this.fromdatecalendar.set(5, i3);
        updateFromDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$3(DatePickerDialog.OnDateSetListener onDateSetListener, View view) {
        this.BloActivityH2HsurveyStatusBinding.toDateEd.setText("");
        this.BloActivityH2HsurveyStatusBinding.toDateEd.setEnabled(false);
        this.BloActivityH2HsurveyStatusBinding.download.setEnabled(false);
        this.BloActivityH2HsurveyStatusBinding.download.setBackgroundResource(R.drawable.blo_disabled_btn);
        this.BloActivityH2HsurveyStatusBinding.detailsLayout.setVisibility(8);
        this.BloActivityH2HsurveyStatusBinding.resultHeader.setVisibility(8);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, onDateSetListener, this.fromdatecalendar.get(1), this.fromdatecalendar.get(2), this.fromdatecalendar.get(5));
        datePickerDialog.getDatePicker().setMinDate(this.minFromDate);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(DatePicker datePicker, int i, int i2, int i3) {
        this.todatecalendar.clear();
        this.todatecalendar.set(1, i);
        this.todatecalendar.set(2, i2);
        this.todatecalendar.set(5, i3);
        updateToDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$5(DatePickerDialog.OnDateSetListener onDateSetListener, View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, onDateSetListener, this.todatecalendar.get(1), this.todatecalendar.get(2), this.todatecalendar.get(5));
        datePickerDialog.getDatePicker().setMinDate(this.minToDate);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        this.BloActivityH2HsurveyStatusBinding.download.setEnabled(false);
        this.BloActivityH2HsurveyStatusBinding.download.setBackgroundResource(R.drawable.blo_disabled_btn);
        this.BloActivityH2HsurveyStatusBinding.detailsLayout.setVisibility(8);
        this.BloActivityH2HsurveyStatusBinding.resultHeader.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.BloActivityH2HsurveyStatusBinding.mainLayout.getWindowToken(), 0);
        if (this.BloActivityH2HsurveyStatusBinding.serialNumberEd.getText().toString().length() == 0 && this.BloActivityH2HsurveyStatusBinding.fromDateEd.getText().toString().length() != 0 && this.BloActivityH2HsurveyStatusBinding.toDateEd.getText().toString().length() == 0) {
            showdialog(this.alertText, "Please Select To Date as well.");
        } else {
            fetchSurveyResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$10(View view) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(this.alertText).setMessage("Do you want to download this data ?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$onCreate$8(dialogInterface, i);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        try {
            exportInCSV();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exportInCSV() throws IOException {
        File externalStorageDirectory;
        File file;
        String str;
        String str2;
        if (Build.VERSION.SDK_INT >= 30) {
            externalStorageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS + "/BLOAPP");
            file = new File(externalStorageDirectory, "H2HSurveyStatus");
        } else {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
            file = new File(externalStorageDirectory, "/BLOAPP/H2HSurveyStatus");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd");
        simpleDateFormat.setLenient(false);
        simpleDateFormat2.setLenient(false);
        String str3 = simpleDateFormat.format(new Date());
        String strSubstring = str3.substring(0, 8);
        String strSubstring2 = str3.substring(8, 14);
        if (!file.exists() && !file.mkdirs()) {
            file.mkdirs();
            return;
        }
        File file2 = new File(file, "H2HSurveyStatus_" + strSubstring + "_" + strSubstring2 + ".csv");
        if (!file2.exists() || file2.delete() || file2.createNewFile() || file.delete() || externalStorageDirectory.delete()) {
            try {
                FileWriter fileWriter = new FileWriter(file2);
                String str4 = "";
                if (this.formType.equals(this.form7Text)) {
                    str = "AC No,Part No,EPIC Number,Serial Number,Applicant Name,Submission Date,H2H Marking,Form 7 Received Status\n";
                } else {
                    str = this.formType.equals(this.form8Text) ? "AC No,Part No,EPIC Number,Serial Number,Applicant Name,Submission Date,H2H Marking,Form 8 Received Status\n" : "";
                }
                fileWriter.append((CharSequence) str);
                for (int i = 0; i < this.h2hSurveyStatusDraftList.size(); i++) {
                    if (this.formType.equals(this.form7Text)) {
                        str2 = this.h2hSurveyStatusDraftList.get(i).getAcNo() + "," + this.h2hSurveyStatusDraftList.get(i).getPartNo() + "," + this.h2hSurveyStatusDraftList.get(i).getEpicNo() + "," + this.h2hSurveyStatusDraftList.get(i).getSerialNo() + "," + this.h2hSurveyStatusDraftList.get(i).getApplicantFirstName() + " " + this.h2hSurveyStatusDraftList.get(i).getApplicantLastName() + "," + this.h2hSurveyStatusDraftList.get(i).getSubmissionDate() + "," + this.h2hSurveyStatusDraftList.get(i).getH2HMarking() + "," + this.h2hSurveyStatusDraftList.get(i).getForm7Status() + "\n";
                    } else {
                        if (this.formType.equals(this.form8Text)) {
                            str2 = this.h2hSurveyStatusDraftList.get(i).getAcNo() + "," + this.h2hSurveyStatusDraftList.get(i).getPartNo() + "," + this.h2hSurveyStatusDraftList.get(i).getEpicNo() + "," + this.h2hSurveyStatusDraftList.get(i).getSerialNo() + "," + this.h2hSurveyStatusDraftList.get(i).getApplicantFirstName() + " " + this.h2hSurveyStatusDraftList.get(i).getApplicantLastName() + "," + this.h2hSurveyStatusDraftList.get(i).getSubmissionDate() + "," + this.h2hSurveyStatusDraftList.get(i).getH2HMarking() + "," + this.h2hSurveyStatusDraftList.get(i).getForm8Status() + "\n";
                        }
                        fileWriter.append((CharSequence) str4);
                    }
                    str4 = str2;
                    fileWriter.append((CharSequence) str4);
                }
                fileWriter.close();
                Logger.d(this.logTag, "exportInCSV : File Generated Successfully.");
                showdialog(this.alertText, "File has been saved at " + file2.getAbsolutePath());
            } catch (IOException e) {
                Logger.d(this.logTag, "exportInCSV : " + e.getMessage());
            }
        }
    }

    public void updateFromDate() {
        this.BloActivityH2HsurveyStatusBinding.fromDateEd.setText(new SimpleDateFormat(this.dateFormat, Locale.US).format(this.fromdatecalendar.getTime()));
        this.formattedFromDate = new SimpleDateFormat(this.dateFormat1, Locale.US).format(this.fromdatecalendar.getTime());
        Logger.d(this.logTag, "From Date -- > " + this.BloActivityH2HsurveyStatusBinding.fromDateEd.getText().toString());
        Logger.d(this.logTag, "formattedFromDate -- > " + this.formattedFromDate);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormat);
        if (this.BloActivityH2HsurveyStatusBinding.fromDateEd.getText().toString() != "") {
            try {
                calendar.setTime(simpleDateFormat.parse(this.BloActivityH2HsurveyStatusBinding.fromDateEd.getText().toString()));
            } catch (Exception e) {
                Logger.d(this.logTag, e.getMessage());
            }
        } else {
            calendar.setTime(date);
            calendar.add(1, -125);
        }
        this.minToDate = calendar.getTime().getTime();
        this.BloActivityH2HsurveyStatusBinding.toDateEd.setEnabled(true);
    }

    public void updateToDate() {
        this.BloActivityH2HsurveyStatusBinding.toDateEd.setText(new SimpleDateFormat(this.dateFormat, Locale.US).format(this.todatecalendar.getTime()));
        this.formattedToDate = new SimpleDateFormat(this.dateFormat1, Locale.US).format(this.todatecalendar.getTime());
        Logger.d(this.logTag, "To Date -- > " + this.BloActivityH2HsurveyStatusBinding.toDateEd.getText().toString());
        Logger.d(this.logTag, "formattedToDate -- > " + this.formattedToDate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void fetchSurveyResult() {
        ArrayList arrayList;
        new ArrayList();
        Logger.d(this.logTag, "fetchSurveyResult ----> serialNumberEd " + this.BloActivityH2HsurveyStatusBinding.serialNumberEd.getText().toString());
        Logger.d(this.logTag, "fetchSurveyResult ----> fromDateEd " + this.BloActivityH2HsurveyStatusBinding.fromDateEd.getText().toString());
        Logger.d(this.logTag, "fetchSurveyResult ----> toDateEd " + this.BloActivityH2HsurveyStatusBinding.toDateEd.getText().toString());
        if (!this.BloActivityH2HsurveyStatusBinding.serialNumberEd.getText().toString().trim().equals("")) {
            arrayList = (ArrayList) this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().getH2HSurveyDetailsAsPerSerialNo(Integer.parseInt(this.partNo), this.bloId, this.BloActivityH2HsurveyStatusBinding.serialNumberEd.getText().toString());
        } else if (this.BloActivityH2HsurveyStatusBinding.fromDateEd.getText().toString().length() != 0 && this.BloActivityH2HsurveyStatusBinding.toDateEd.getText().toString().length() != 0 && this.BloActivityH2HsurveyStatusBinding.serialNumberEd.getText().toString().equals("")) {
            arrayList = (ArrayList) this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().getH2HSurveyDetailsAsPerDate(Integer.parseInt(this.partNo), this.bloId, this.formattedFromDate, this.formattedToDate);
        } else {
            arrayList = (ArrayList) this.electorDetailsDatabaseHelper.h2HSurveyStatusDao().getH2HSurveyDetails(Integer.parseInt(this.partNo), this.bloId);
        }
        if (!arrayList.isEmpty()) {
            this.h2hSurveyStatusDraftList.clear();
            this.h2hSurveyListToExport.clear();
            Logger.d(this.logTag, "------ Data From DB ------" + arrayList.size());
            int i = 0;
            while (i < arrayList.size()) {
                int i2 = i + 1;
                Logger.d(this.logTag, "------ " + i2 + " ------");
                Logger.d(this.logTag, "EpicNo ----> " + ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getEpicNo());
                Logger.d(this.logTag, "PartName ----> " + ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getPartName());
                Logger.d(this.logTag, "AcNo ----> " + ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getAcNo());
                Logger.d(this.logTag, "PartNo ----> " + ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getPartNo());
                Logger.d(this.logTag, "SerialNo ----> " + ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getSerialNo());
                Logger.d(this.logTag, "ApplicantFirstName ----> " + ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getApplicantFirstName());
                Logger.d(this.logTag, "ApplicantLastName ----> " + ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getApplicantLastName());
                Logger.d(this.logTag, "SubmissionDate ----> " + ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getSubmissionDate());
                Logger.d(this.logTag, "H2HMarking ----> " + ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getH2HMarking());
                Logger.d(this.logTag, "Form7Status ----> " + ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getForm7Status());
                Logger.d(this.logTag, "Form8Status ----> " + ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getForm8Status());
                Logger.d(this.logTag, "BloId ----> " + ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getBloId());
                Logger.d(this.logTag, "ModifiedOn ----> " + ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getModifiedOn());
                Logger.d(this.logTag, "LastSyncStatus ----> " + ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getLastSyncStatus());
                if (this.formType.equals(this.form7Text) && !((H2HSurveyStatusModel.Payload) arrayList.get(i)).getForm7Status().equalsIgnoreCase("NA")) {
                    this.h2hSurveyStatusDraftList.add(new H2HSurveyStatusModel.Payload(((H2HSurveyStatusModel.Payload) arrayList.get(i)).getEpicNo(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getPartName(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getAcNo(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getPartNo(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getSerialNo(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getApplicantFirstName(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getApplicantLastName(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getSubmissionDate(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getH2HMarking(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getForm7Status(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getForm8Status(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getBloId(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getModifiedOn(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getLastSyncStatus()));
                } else if (this.formType.equals(this.form8Text) && !((H2HSurveyStatusModel.Payload) arrayList.get(i)).getForm8Status().equalsIgnoreCase("NA")) {
                    this.h2hSurveyStatusDraftList.add(new H2HSurveyStatusModel.Payload(((H2HSurveyStatusModel.Payload) arrayList.get(i)).getEpicNo(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getPartName(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getAcNo(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getPartNo(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getSerialNo(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getApplicantFirstName(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getApplicantLastName(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getSubmissionDate(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getH2HMarking(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getForm7Status(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getForm8Status(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getBloId(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getModifiedOn(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getLastSyncStatus()));
                }
                if (this.formType.equals(this.form7Text)) {
                    this.h2hSurveyListToExport.add(new H2HSurveyStatusModel.Payload(((H2HSurveyStatusModel.Payload) arrayList.get(i)).getEpicNo(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getAcNo(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getSerialNo(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getApplicantFirstName(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getApplicantLastName(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getSubmissionDate(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getH2HMarking(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getForm7Status()));
                } else if (this.formType.equals(this.form8Text)) {
                    this.h2hSurveyListToExport.add(new H2HSurveyStatusModel.Payload(((H2HSurveyStatusModel.Payload) arrayList.get(i)).getEpicNo(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getAcNo(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getSerialNo(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getApplicantFirstName(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getApplicantLastName(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getSubmissionDate(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getH2HMarking(), ((H2HSurveyStatusModel.Payload) arrayList.get(i)).getForm8Status()));
                }
                i = i2;
            }
            if (this.h2hSurveyStatusDraftList.size() != 0) {
                this.BloActivityH2HsurveyStatusBinding.download.setEnabled(true);
                this.BloActivityH2HsurveyStatusBinding.download.setBackgroundResource(R.drawable.blo_save_next);
                this.BloActivityH2HsurveyStatusBinding.detailsLayout.setVisibility(0);
            }
            this.BloActivityH2HsurveyStatusBinding.resultHeader.setVisibility(0);
            this.BloActivityH2HsurveyStatusBinding.resultHeader.setText(String.format(getString(R.string.blo_result_header), new Object[0]) + " (" + this.h2hSurveyStatusDraftList.size() + ") ");
            initRecyclerViewAdapter();
            this.BloActivityH2HsurveyStatusBinding.allStatusRv.setLayoutManager(new GridLayoutManager(this, 1, 1, false));
            this.BloActivityH2HsurveyStatusBinding.allStatusRv.setAdapter(this.adapter);
            return;
        }
        this.BloActivityH2HsurveyStatusBinding.download.setEnabled(false);
        this.BloActivityH2HsurveyStatusBinding.download.setBackgroundResource(R.drawable.blo_disabled_btn);
        this.BloActivityH2HsurveyStatusBinding.detailsLayout.setVisibility(8);
        this.BloActivityH2HsurveyStatusBinding.resultHeader.setVisibility(8);
        Toast.makeText((Context) this, (CharSequence) "Draft entries does not exist.", 0).show();
        finish();
    }

    private void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new GenericRecyclerView.GenericRecyclerViewInterface() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusActivity.1
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(BloAllStatusRvItemsBinding.inflate(H2HSurveyStatusActivity.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                ((BloAllStatusRvItemsBinding) holder.binding).acNoEd.setText(H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.get(position).getAcNo() + " , " + H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.get(position).getPartNo());
                ((BloAllStatusRvItemsBinding) holder.binding).epicNumberEd.setText(H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.get(position).getEpicNo());
                ((BloAllStatusRvItemsBinding) holder.binding).serialNumberEd.setText(String.valueOf(H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.get(position).getSerialNo()));
                ((BloAllStatusRvItemsBinding) holder.binding).applicantNameEd.setText(H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.get(position).getApplicantFirstName() + " " + H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.get(position).getApplicantLastName());
                ((BloAllStatusRvItemsBinding) holder.binding).h2hMarkingEd.setText(H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.get(position).getH2HMarking());
                if (position + 1 == H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.size()) {
                    ((BloAllStatusRvItemsBinding) holder.binding).divider.setVisibility(8);
                }
                if (H2HSurveyStatusActivity.this.formType.equals(H2HSurveyStatusActivity.this.form7Text)) {
                    ((BloAllStatusRvItemsBinding) holder.binding).formStatusHeader.setText(String.format(H2HSurveyStatusActivity.this.getString(R.string.blo_Form_7_Received_Status), new Object[0]));
                    ((BloAllStatusRvItemsBinding) holder.binding).formStatusEd.setText(H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.get(position).getForm7Status());
                    if (H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.get(position).getForm7Status().equalsIgnoreCase("Processed") || H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.get(position).getForm7Status().equalsIgnoreCase("Yes")) {
                        ((BloAllStatusRvItemsBinding) holder.binding).formStatusEd.setTextColor(Color.parseColor("#1ABC00"));
                        return;
                    } else {
                        ((BloAllStatusRvItemsBinding) holder.binding).formStatusEd.setTextColor(Color.parseColor("#FD2B2B"));
                        return;
                    }
                }
                if (H2HSurveyStatusActivity.this.formType.equals(H2HSurveyStatusActivity.this.form8Text)) {
                    ((BloAllStatusRvItemsBinding) holder.binding).formStatusHeader.setText(String.format(H2HSurveyStatusActivity.this.getString(R.string.blo_Form_8_Received_Status), new Object[0]));
                    ((BloAllStatusRvItemsBinding) holder.binding).formStatusEd.setText(H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.get(position).getForm8Status());
                    if (H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.get(position).getForm8Status().equalsIgnoreCase("Processed") || H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.get(position).getForm8Status().equalsIgnoreCase("Yes")) {
                        ((BloAllStatusRvItemsBinding) holder.binding).formStatusEd.setTextColor(Color.parseColor("#1ABC00"));
                    } else {
                        ((BloAllStatusRvItemsBinding) holder.binding).formStatusEd.setTextColor(Color.parseColor("#FD2B2B"));
                    }
                }
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemCount() {
                return H2HSurveyStatusActivity.this.h2hSurveyStatusDraftList.size();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialog(String title, String msg) {
        new androidx.appcompat.app.AlertDialog.Builder(this).setTitle(title).setMessage(msg).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.H2HSurveyStatusActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }
}
