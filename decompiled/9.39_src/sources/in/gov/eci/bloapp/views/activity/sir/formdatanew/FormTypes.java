package in.gov.eci.bloapp.views.activity.sir.formdatanew;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.SIRResponseData;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityFormTypesBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.NetworkReceiver;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.AsdListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.DuplicateVerificationListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ElectorEfListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.NoMappingFormsListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.PSEVerificationListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ReverifyFormsListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.SelectPhotoListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateBloBlaMomActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.UpdateMobileListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.VerifyCitizenFormsListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.FormVerification.ViewDoumentsListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.UploadAttendenceListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.anomaly.AnomalyListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.pendingElectorsEpicMatch;
import in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.SentBackEroFormsListActivity;
import in.gov.eci.bloapp.views.activity.newsir.activity.sentbackero.UncollectableDocumentListActivity;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.activity.sir.RollBackFromAERO;
import in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROList;
import in.gov.eci.bloapp.views.activity.sir.efTrackerActivity;
import in.gov.eci.bloapp.views.activity.sir.efTrackerCountActivity;
import in.gov.eci.bloapp.views.activity.sir.enumerationForm.SIROffline;
import in.gov.eci.bloapp.views.activity.sir.enumerationForm.specialRevisionActivity;
import in.gov.eci.bloapp.views.activity.sir.pendingElectors;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FormTypes extends SuperBaseActivity {
    AlertDialog alertDialog;
    String asmblyNO;
    private String atkband;
    ActivityFormTypesBinding binding;
    String electorName;
    private NetworkReceiver networkReceiver;
    String partNo;
    String partNoS;
    private String refreshToken;
    private String rtkband;
    String state;
    private ArrayList<String> statecode1;
    private ArrayList<String> statename;
    private String token;
    Utils utils;
    CommomUtility commomUtility = new CommomUtility();
    ArrayList<String> List8docName = new ArrayList<>();
    ArrayList<String> List8docCode = new ArrayList<>();
    Gson gson = new GsonBuilder().setLenient().create();
    String selectDocumentType = "";
    String selectRelationType = "";
    String SESSION = "";
    ArrayList<String> relationNameSpinnerVal = new ArrayList<>();
    ArrayList<String> relationCodeSpinnerVal = new ArrayList<>();
    ArrayList<String> acListNameSpinnerVal = new ArrayList<>();
    ArrayList<String> acListCodeCodeSpinnerVal = new ArrayList<>();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFormTypesBinding activityFormTypesBindingInflate = ActivityFormTypesBinding.inflate(getLayoutInflater());
        this.binding = activityFormTypesBindingInflate;
        setContentView(activityFormTypesBindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.selectDocumentType = getString(R.string.selectDocumentMsg);
        this.selectRelationType = getString(R.string.selectRelationMsg);
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.utils = new Utils();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        if (SharedPref.getInstance(this).getRelativeListCode(Constants.RELATIVE_LIST_CODE).isEmpty() || SharedPref.getInstance(this).getRelativeListName(Constants.RELATIVE_LIST_NAME).isEmpty()) {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            getRelationTypeDropdown();
        }
        this.binding.textView5.setText("v" + this.commomUtility.appversion);
        this.binding.pendingElector.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.enumerationForm.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.verifyElectors.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.llDeceasedElectors.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.llpseverification.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.llDuplicateVerification.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FormTypes.this.startActivity(new Intent((Context) FormTypes.this, (Class<?>) DuplicateVerificationListActivity.class));
            }
        });
        this.binding.llUpdateBloBla.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FormTypes.this.startActivity(new Intent((Context) FormTypes.this, (Class<?>) UpdateBloBlaMomActivity.class));
            }
        });
        this.binding.llanomaly.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FormTypes.this.startActivity(new Intent((Context) FormTypes.this, (Class<?>) AnomalyListActivity.class));
            }
        });
        this.binding.llnomapping.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FormTypes.this.startActivity(new Intent((Context) FormTypes.this, (Class<?>) NoMappingFormsListActivity.class));
            }
        });
        this.binding.llselectPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FormTypes.this.startActivity(new Intent((Context) FormTypes.this, (Class<?>) SelectPhotoListActivity.class));
            }
        });
        this.binding.llupdatemobile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FormTypes.this.startActivity(new Intent((Context) FormTypes.this, (Class<?>) UpdateMobileListActivity.class));
            }
        });
        this.binding.filledBLO.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.rollBack.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.uncollectableEFLL.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.binding.efDashboard.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$8(view);
            }
        });
        this.binding.pendingElectorepicmatch.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FormTypes.this.startActivity(new Intent((Context) FormTypes.this, (Class<?>) pendingElectorsEpicMatch.class));
            }
        });
        this.binding.viewFormByAero.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$9(view);
            }
        });
        this.binding.offlineLL.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$10(view);
            }
        });
        this.binding.efTracker.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$11(view);
            }
        });
        this.binding.backBtnIv.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$$ExternalSyntheticLambda7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$onCreate$12(view, motionEvent);
            }
        });
        this.binding.noteOpen.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.binding.llDelivery.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$13(view);
            }
        });
        this.binding.lldraftlist.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FormTypes.this.startActivity(new Intent((Context) FormTypes.this, (Class<?>) ElectorEfListActivity.class));
            }
        });
        this.binding.viewDocuments.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FormTypes.this.startActivity(new Intent((Context) FormTypes.this, (Class<?>) ViewDoumentsListActivity.class));
            }
        });
        this.binding.efuploadAttendence.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FormTypes.this.startActivity(new Intent((Context) FormTypes.this, (Class<?>) UploadAttendenceListActivity.class));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        startActivity(new Intent((Context) this, (Class<?>) pendingElectors.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        startActivity(new Intent((Context) this, (Class<?>) specialRevisionActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        startActivity(new Intent((Context) this, (Class<?>) VerifyCitizenFormsListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        startActivity(new Intent((Context) this, (Class<?>) AsdListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        startActivity(new Intent((Context) this, (Class<?>) PSEVerificationListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        startActivity(new Intent((Context) this, (Class<?>) ReverifyFormsListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        if (SharedPref.getInstance(getApplicationContext()).getMarkUncollectableSentBack().equalsIgnoreCase("Y")) {
            startActivity(new Intent((Context) this, (Class<?>) RollBackFromAERO.class));
        } else if (SharedPref.getInstance(getApplicationContext()).getMarkUncollectableSentBack().equalsIgnoreCase("N")) {
            startActivity(new Intent((Context) this, (Class<?>) SentBackEroFormsListActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        startActivity(new Intent((Context) this, (Class<?>) UncollectableDocumentListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$8(View view) {
        startActivity(new Intent((Context) this, (Class<?>) efTrackerCountActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$9(View view) {
        startActivity(new Intent((Context) this, (Class<?>) ViewFormByAEROList.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$10(View view) {
        startActivity(new Intent((Context) this, (Class<?>) SIROffline.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$11(View view) {
        startActivity(new Intent((Context) this, (Class<?>) efTrackerActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$12(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$13(View view) {
        startActivity(new Intent((Context) this, (Class<?>) ScheduldeHearingNoticeListActivity.class));
    }

    protected void onResume() {
        super.onResume();
        getSirStatus(this.state, this.token);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValues() {
        if (SharedPref.getInstance(getApplicationContext()).getSirFlag().equalsIgnoreCase("Pre")) {
            this.binding.preTV.setText(R.string.special_creation_pre);
        } else if (SharedPref.getInstance(getApplicationContext()).getSirFlag().equalsIgnoreCase("Post")) {
            this.binding.preTV.setText(R.string.special_creation_post);
        }
        if (SharedPref.getInstance(getApplicationContext()).getPendingElectors().equalsIgnoreCase("Y")) {
            this.binding.pendingElector.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getPendingElectors().equalsIgnoreCase("N")) {
            this.binding.pendingElector.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getEpicMatchEFFlag().equalsIgnoreCase("Y")) {
            this.binding.pendingElectorepicmatch.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getEpicMatchEFFlag().equalsIgnoreCase("N")) {
            this.binding.pendingElectorepicmatch.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getFillEnumerationForm().equalsIgnoreCase("N")) {
            this.binding.fillEFLayout.setVisibility(8);
        } else {
            SharedPref.getInstance(getApplicationContext()).getFillEnumerationForm().equalsIgnoreCase("Y");
        }
        if (SharedPref.getInstance(getApplicationContext()).getVerifyFormsFilled().equalsIgnoreCase("Y")) {
            this.binding.verifyElectors.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getVerifyFormsFilled().equalsIgnoreCase("N")) {
            this.binding.verifyElectors.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getReverifyUploadDocs().equalsIgnoreCase("Y")) {
            this.binding.filledBLO.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getReverifyUploadDocs().equalsIgnoreCase("N")) {
            this.binding.filledBLO.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getSentBackByEro().equalsIgnoreCase("Y")) {
            this.binding.rollBack.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getSentBackByEro().equalsIgnoreCase("N")) {
            this.binding.rollBack.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getUploadEfForUncollected().equalsIgnoreCase("Y")) {
            this.binding.uncollectableEFLL.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getUploadEfForUncollected().equalsIgnoreCase("N")) {
            this.binding.uncollectableEFLL.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getViewModifiedByAEROERO().equalsIgnoreCase("Y")) {
            this.binding.viewFormByAeroLL.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getViewModifiedByAEROERO().equalsIgnoreCase("N")) {
            this.binding.viewFormByAeroLL.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getOfflineTab().equalsIgnoreCase("Y")) {
            this.binding.offlineLL.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getOfflineTab().equalsIgnoreCase("N")) {
            this.binding.offlineLL.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getEfTrackerTab().equalsIgnoreCase("Y")) {
            this.binding.efTracker.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getEfTrackerTab().equalsIgnoreCase("N")) {
            this.binding.efTracker.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getuploadBLOMOM().equalsIgnoreCase("Y")) {
            this.binding.llUpdateBloBla.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getuploadBLOMOM().equalsIgnoreCase("N")) {
            this.binding.llUpdateBloBla.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getAnomaly().equalsIgnoreCase("Y")) {
            this.binding.llanomaly.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getAnomaly().equalsIgnoreCase("N")) {
            this.binding.llanomaly.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getPseVerification().equalsIgnoreCase("Y")) {
            this.binding.llpseverification.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getPseVerification().equalsIgnoreCase("N")) {
            this.binding.llpseverification.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getDeceasedElectors().equalsIgnoreCase("Y")) {
            this.binding.llDeceasedElectors.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getDeceasedElectors().equalsIgnoreCase("N")) {
            this.binding.llDeceasedElectors.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getDuplicateVersification().equalsIgnoreCase("Y")) {
            this.binding.llDuplicateVerification.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getDuplicateVersification().equalsIgnoreCase("N")) {
            this.binding.llDuplicateVerification.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getNoMapping().equalsIgnoreCase("Y")) {
            this.binding.llnomapping.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getNoMapping().equalsIgnoreCase("N")) {
            this.binding.llnomapping.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getEfDashBoardTab().equalsIgnoreCase("Y")) {
            this.binding.efDashboard.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getEfDashBoardTab().equalsIgnoreCase("N")) {
            this.binding.efDashboard.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getOnlineStatusFlag().equalsIgnoreCase("Y")) {
            this.binding.ofllineDisclaimer.setVisibility(8);
        } else {
            this.binding.ofllineDisclaimer.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getdraftList().equalsIgnoreCase("Y")) {
            this.binding.lldraftlist.setVisibility(0);
        } else {
            this.binding.lldraftlist.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getSelectPhoto().equalsIgnoreCase("Y")) {
            this.binding.llselectPhoto.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getSelectPhoto().equalsIgnoreCase("N")) {
            this.binding.llselectPhoto.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getScheduleHearingTab().equalsIgnoreCase("Y")) {
            this.binding.llDelivery.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getScheduleHearingTab().equalsIgnoreCase("N")) {
            this.binding.llDelivery.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getviewDocCitizen().equalsIgnoreCase("Y")) {
            this.binding.viewDocuments.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getviewDocCitizen().equalsIgnoreCase("N")) {
            this.binding.viewDocuments.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getuploadAttendence().equalsIgnoreCase("Y")) {
            this.binding.efuploadAttendence.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getuploadAttendence().equalsIgnoreCase("N")) {
            this.binding.efuploadAttendence.setVisibility(8);
        }
        if (SharedPref.getInstance(getApplicationContext()).getupdateMobile().equalsIgnoreCase("Y")) {
            this.binding.llupdatemobile.setVisibility(0);
        } else if (SharedPref.getInstance(getApplicationContext()).getupdateMobile().equalsIgnoreCase("N")) {
            this.binding.llupdatemobile.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onPostResume() {
        super.onPostResume();
        this.networkReceiver = new NetworkReceiver(this);
        registerReceiver(this.networkReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.networkReceiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void getRelationTypeDropdown() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", "master");
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).getRelationDropdownSIR(map).enqueue(new AnonymousClass12());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$12, reason: invalid class name */
    class AnonymousClass12 implements Callback<JsonObject> {
        AnonymousClass12() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes] */
        /* JADX WARN: Type inference failed for: r1v6, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes] */
        /* JADX WARN: Type inference failed for: r8v10, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (FormTypes.this.alertDialog != null) {
                    FormTypes.this.alertDialog.dismiss();
                }
                JsonObject jsonObject = (JsonObject) response.body();
                if (jsonObject != null) {
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("payload");
                    FormTypes.this.relationNameSpinnerVal.clear();
                    FormTypes.this.relationCodeSpinnerVal.clear();
                    FormTypes.this.relationNameSpinnerVal.add(FormTypes.this.selectRelationType);
                    FormTypes.this.relationCodeSpinnerVal.add("");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = FormTypes.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        FormTypes.this.relationNameSpinnerVal.add(String.valueOf(asJsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        FormTypes.this.relationCodeSpinnerVal.add(String.valueOf(asJsonObject.get("relationCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    }
                    SharedPref.getInstance(FormTypes.this).saveRelativeListName(FormTypes.this.relationNameSpinnerVal, Constants.RELATIVE_LIST_NAME);
                    SharedPref.getInstance(FormTypes.this).saveRelativeListCode(FormTypes.this.relationCodeSpinnerVal, Constants.RELATIVE_LIST_CODE);
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                if (FormTypes.this.alertDialog != null) {
                    FormTypes.this.alertDialog.dismiss();
                }
                try {
                    CommomUtility commomUtility = FormTypes.this.commomUtility;
                    ?? r8 = FormTypes.this;
                    commomUtility.getRefreshToken(r8, ((FormTypes) r8).refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$12$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str, String str2) {
                            this.f$0.lambda$onResponse$1(i2, str, str2);
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.e("", e.toString());
                    return;
                }
            }
            try {
                if (FormTypes.this.alertDialog != null) {
                    FormTypes.this.alertDialog.dismiss();
                }
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("message");
                Logger.e("", jSONObject.optString("message"));
                Utils utils = FormTypes.this.utils;
                ?? r1 = FormTypes.this;
                utils.infoDialog(r1, r1.getResources().getString(R.string.alertMsg), strOptString);
            } catch (IOException | JSONException e2) {
                if (FormTypes.this.alertDialog != null) {
                    FormTypes.this.alertDialog.dismiss();
                }
                Utils utils2 = FormTypes.this.utils;
                ?? r2 = FormTypes.this;
                utils2.infoDialog(r2, r2.getResources().getString(R.string.alertMsg), FormTypes.this.getResources().getString(R.string.something_went_wrong));
                Logger.e("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            FormTypes.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = FormTypes.this.commomUtility;
                ?? r5 = FormTypes.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes$12$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                FormTypes.this.token = "Bearer " + str;
                SharedPref.getInstance(FormTypes.this.getApplicationContext()).setRefreshToken(str2);
                SharedPref.getInstance(FormTypes.this.getApplicationContext()).setToken("Bearer " + str);
                FormTypes.this.getRelationTypeDropdown();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FormTypes.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FormTypes.this.getApplicationContext()).setLocaleBool(false);
            FormTypes.this.startActivity(new Intent(FormTypes.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (FormTypes.this.alertDialog != null) {
                FormTypes.this.alertDialog.dismiss();
            }
            Utils utils = FormTypes.this.utils;
            ?? r0 = FormTypes.this;
            utils.infoDialog(r0, r0.getResources().getString(R.string.alertMsg), FormTypes.this.getResources().getString(R.string.something_went_wrong));
            Logger.d("", "OnFailure" + t.getMessage());
        }
    }

    public void getAllAC() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("state", this.state);
        map.put("currentRole", "BLO");
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getAllAssmbly(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes.13
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                    FormTypes.this.acListNameSpinnerVal.clear();
                    FormTypes.this.acListCodeCodeSpinnerVal.clear();
                    FormTypes.this.acListNameSpinnerVal.add(FormTypes.this.getString(R.string.select_assembly_constituency));
                    FormTypes.this.acListCodeCodeSpinnerVal.add("");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = FormTypes.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        FormTypes.this.acListNameSpinnerVal.add(String.valueOf(asJsonObject.get("acNo")).replace(RegexMatcher.JSON_STRING_REGEX, "") + " - " + String.valueOf(asJsonObject.get("acName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        FormTypes.this.acListCodeCodeSpinnerVal.add(String.valueOf(asJsonObject.get("acNo")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    }
                    SharedPref.getInstance(FormTypes.this).saveAcListName(FormTypes.this.acListNameSpinnerVal, Constants.AC_LIST_NAME);
                    SharedPref.getInstance(FormTypes.this).saveAcListCode(FormTypes.this.acListCodeCodeSpinnerVal, Constants.AC_LIST_CODE);
                    return;
                }
                Logger.e("AC List error", String.valueOf(response.code()));
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.e("AC List", t.getMessage());
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getSirStatus(String stateCode, String Token) {
        try {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            ((UserClient) ApiClient.getClient2(this).create(UserClient.class)).getSirFeatureStatusSIR(stateCode, Token, SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), "BLOAPP", "blo", stateCode).enqueue(new Callback<SIRResponseData>() { // from class: in.gov.eci.bloapp.views.activity.sir.formdatanew.FormTypes.14
                public void onResponse(Call<SIRResponseData> call, Response<SIRResponseData> response) {
                    if (response.code() == 200) {
                        SIRResponseData.StatusPaylod payload = ((SIRResponseData) response.body()).getPayload();
                        SharedPref.getInstance(FormTypes.this).setSirFlag(payload.getFlag());
                        SharedPref.getInstance(FormTypes.this).setPendingElectors(payload.getPendingElectors());
                        SharedPref.getInstance(FormTypes.this).setFillEnumerationForm(payload.getFillEnumerationForm());
                        SharedPref.getInstance(FormTypes.this).setVerifyFormsFilled(payload.getVerifyFormsFilled());
                        SharedPref.getInstance(FormTypes.this).setReverifyUploadDocs(payload.getReverifyUploadDocs());
                        SharedPref.getInstance(FormTypes.this).setSentBackByEro(payload.getSentBackByEro());
                        SharedPref.getInstance(FormTypes.this).setUploadEfForUncollected(payload.getUploadEfForUncollected());
                        SharedPref.getInstance(FormTypes.this).setMarkUncollectableSentBack(payload.getMarkUncollectableSentBack());
                        SharedPref.getInstance(FormTypes.this).setAlreadyFilledFormSentBack(payload.getAlreadyFilledFormSentBack());
                        SharedPref.getInstance(FormTypes.this).setAlreadyFilledFormSentBackMarkUnButton(payload.getAlreadyFilledFormSentBackMarkUnButton());
                        SharedPref.getInstance(FormTypes.this).setViewModifiedByAEROERO(payload.getViewModifiedByAEROERO());
                        SharedPref.getInstance(FormTypes.this).setOfflineTab(payload.getOfflineTab());
                        SharedPref.getInstance(FormTypes.this).setEfTrackerTab(payload.getEfDistributionTracker());
                        SharedPref.getInstance(FormTypes.this).setScheduleHearingTab(payload.getScheduleHearingNotice());
                        SharedPref.getInstance(FormTypes.this).setFaceRecognitionFlag(payload.getFaceRecognition());
                        SharedPref.getInstance(FormTypes.this).setOnlineStatusFlag(payload.getIsOnlineSirFlag());
                        SharedPref.getInstance(FormTypes.this).setAutoFaceDetection(payload.getAutoFaceDetection());
                        SharedPref.getInstance(FormTypes.this).setElectorUpload(payload.getIsElectorUpload());
                        SharedPref.getInstance(FormTypes.this).setlastSIRYear(payload.getLastSIRYear());
                        SharedPref.getInstance(FormTypes.this).setEpicMatchEFFlag(payload.getEpicMatchFillEF());
                        SharedPref.getInstance(FormTypes.this).setEfDashBoardTab(payload.getEfDashBoard());
                        SharedPref.getInstance(FormTypes.this).setverifyMarkUncollectable(payload.getVerifyMarkUncollectable());
                        SharedPref.getInstance(FormTypes.this).setreverifyMarkUncollectable(payload.getReverifyMarkUncollectable());
                        SharedPref.getInstance(FormTypes.this).setDeceasedElectors(payload.getDeceasedElectors());
                        SharedPref.getInstance(FormTypes.this).setElectorsAnomaly(payload.getElectorsAnomaly());
                        SharedPref.getInstance(FormTypes.this).setefPhotoFlag(payload.getEfPhotoFlag());
                        SharedPref.getInstance(FormTypes.this).setDuplicateVerification(payload.getDuplicateVerification());
                        SharedPref.getInstance(FormTypes.this).setuploadBLOMOM(payload.getUploadBLOMOM());
                        SharedPref.getInstance(FormTypes.this).setAnomaly(payload.getAnomaly());
                        SharedPref.getInstance(FormTypes.this).setFormCounts(payload.getFormsCount());
                        SharedPref.getInstance(FormTypes.this).setPseVerification(payload.getPseVerification());
                        SharedPref.getInstance(FormTypes.this).setdraftList(payload.getDraftList());
                        SharedPref.getInstance(FormTypes.this).setNoMapping(payload.getNoMapping());
                        SharedPref.getInstance(FormTypes.this).setSelectPhoto(payload.getSelectPhoto());
                        SharedPref.getInstance(FormTypes.this).setviewDocCitizen(payload.getViewDocCitizen());
                        SharedPref.getInstance(FormTypes.this).setUploadAttendence(payload.getUploadAttendance());
                        SharedPref.getInstance(FormTypes.this).setupdateMobile(payload.getUpdateMobile());
                        if (FormTypes.this.alertDialog != null) {
                            FormTypes.this.alertDialog.dismiss();
                        }
                        FormTypes.this.setValues();
                        return;
                    }
                    if (FormTypes.this.alertDialog != null) {
                        FormTypes.this.alertDialog.dismiss();
                    }
                    FormTypes.this.setValues();
                    Logger.d("coming in onFailure ", "API error code");
                }

                public void onFailure(Call<SIRResponseData> call, Throwable t) {
                    if (FormTypes.this.alertDialog != null) {
                        FormTypes.this.alertDialog.dismiss();
                    }
                    FormTypes.this.setValues();
                    Logger.d("coming in onFailure ", t.getMessage());
                }
            });
        } catch (Exception e) {
            AlertDialog alertDialog2 = this.alertDialog;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
            }
            setValues();
            Logger.d("Content", e.getMessage());
        }
    }
}
