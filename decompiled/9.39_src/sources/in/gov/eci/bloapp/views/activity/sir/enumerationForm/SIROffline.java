package in.gov.eci.bloapp.views.activity.sir.enumerationForm;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.adapter.SIROfflineAdapter;
import in.gov.eci.bloapp.databinding.ActivitySirofflineBinding;
import in.gov.eci.bloapp.model.SIR.SpecialSurveyRevisionModel;
import in.gov.eci.bloapp.room.database.SIRDatabaseHelper;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SIROffline extends SuperBaseActivity {
    SIROfflineAdapter adapter;
    ActivitySirofflineBinding binding;
    SIRDatabaseHelper db;
    String partNO;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySirofflineBinding activitySirofflineBindingInflate = ActivitySirofflineBinding.inflate(getLayoutInflater());
        this.binding = activitySirofflineBindingInflate;
        setContentView(activitySirofflineBindingInflate.getRoot());
        this.partNO = SharedPref.getInstance(this).getPartNumber();
        this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.db = SIRDatabaseHelper.getDB(this);
        loadDataFromDB();
        this.db.SpecialRevisionDao().getAllForms().observe(this, new Observer<List<SpecialSurveyRevisionModel>>() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SIROffline.1
            public void onChanged(List<SpecialSurveyRevisionModel> specialSurveyRevisionModels) {
            }
        });
        this.binding.pendingCount.setText("Count of pending forms yet to sync - " + this.db.SpecialRevisionDao().getPendingCountFromDB());
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SIROffline.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SIROffline.this.onBackPressed();
            }
        });
        this.binding.submissionIcon.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SIROffline$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.noteOpen.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SIROffline.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View viewInflate = LayoutInflater.from(SIROffline.this).inflate(R.layout.ef_custom_modal, (ViewGroup) null);
                TextView textView = (TextView) viewInflate.findViewById(R.id.note3);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.note6);
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.note4);
                TextView textView4 = (TextView) viewInflate.findViewById(R.id.note5);
                TextView textView5 = (TextView) viewInflate.findViewById(R.id.noteTotal);
                textView.setText(SIROffline.this.getString(R.string.form_type_1));
                textView2.setText(SIROffline.this.getString(R.string.form_type_2));
                textView3.setText(SIROffline.this.getString(R.string.form_type_4New));
                textView4.setText(SIROffline.this.getString(R.string.form_type_3));
                textView5.setVisibility(8);
                new AlertDialog.Builder(SIROffline.this).setTitle("Forms").setView(viewInflate).setPositiveButton(SIROffline.this.getString(R.string.closeInfo), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SIROffline.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create().show();
            }
        });
        checkListInDB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        WorkManager.getInstance(this).enqueueUniqueWork("SIR_UPLOAD_WORK", ExistingWorkPolicy.KEEP, new OneTimeWorkRequest.Builder(SirUploadWorker.class).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 10L, TimeUnit.SECONDS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
    }

    private void checkListInDB() {
        if (this.db.SpecialRevisionDao().getSpecialSurveyRevisionDetails(this.partNO).isEmpty()) {
            this.binding.submissionIcon.setEnabled(false);
            this.binding.submissionIcon.setTextColor(-7829368);
        } else {
            this.binding.submissionIcon.setEnabled(true);
            this.binding.submissionIcon.setTextColor(-1);
        }
    }

    private void loadDataFromDB() {
        new Thread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SIROffline$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadDataFromDB$2();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadDataFromDB$2() {
        final List<SpecialSurveyRevisionModel> specialSurveyRevisionDetails = this.db.SpecialRevisionDao().getSpecialSurveyRevisionDetails(this.partNO);
        runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SIROffline$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadDataFromDB$1(specialSurveyRevisionDetails);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$loadDataFromDB$1(List list) {
        this.adapter = new SIROfflineAdapter(this, list);
        this.binding.recyclerView.setAdapter(this.adapter);
        this.adapter.notifyDataSetChanged();
    }
}
