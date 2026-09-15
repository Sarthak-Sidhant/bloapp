package in.gov.eci.bloapp.views.activity.newsir.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.DialogProgenyListBinding;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.SharedViewModel;
import in.gov.eci.bloapp.views.activity.newsir.adapter.ProgenyListAdapter;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.Payload;
import in.gov.eci.bloapp.views.activity.newsir.model.SelfMappingList;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ProgenyListDialogFragment extends DialogFragment {
    private String acNo;
    AlertDialog alertDialog;
    private String atkband;
    private DialogProgenyListBinding binding;
    private OnDataReceivedListener listener;
    MappingRoot mappingRoot;
    private String partNo;
    List<SelfMappingList> progenyList;
    ProgenyListAdapter progenyListAdapter;
    private String refreshToken;
    private String rtkband;
    SharedViewModel sharedViewModel;
    private String state;
    private String token;
    UserClient userClient;
    Utils utils;
    String SESSION = "";
    Gson gson = new GsonBuilder().setLenient().create();
    List<Payload> payloads = new ArrayList();

    public interface OnDataReceivedListener {
        void onDataReceived(SelfMappingList searchModel, String result2, String result3);
    }

    public void setOnDataReceivedListener(OnDataReceivedListener listener) {
        this.listener = listener;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        window.setLayout((int) (((double) displayMetrics.widthPixels) * 0.95d), -2);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        return dialogOnCreateDialog;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = DialogProgenyListBinding.inflate(getLayoutInflater());
        getSessionValue();
        init();
        handleButtonClicks();
        return this.binding.getRoot();
    }

    private void handleButtonClicks() {
        this.binding.layoutVerifyButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.ProgenyListDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleButtonClicks$0(view);
            }
        });
        this.binding.ivCancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.ProgenyListDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ProgenyListDialogFragment.this.utils.decisionDialog(ProgenyListDialogFragment.this.requireActivity(), ProgenyListDialogFragment.this.requireActivity().getResources().getString(R.string.alertMsg), ProgenyListDialogFragment.this.requireActivity().getResources().getString(R.string.confirm_to_close), ProgenyListDialogFragment.this.requireActivity().getResources().getString(R.string.blo_yes), ProgenyListDialogFragment.this.requireActivity().getResources().getString(R.string.blo_No), new DecisionDialogCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.ProgenyListDialogFragment.2.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onNegativeButtonClicked() {
                    }

                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback
                    public void onPositiveButtonClicked() {
                        ProgenyListDialogFragment.this.sentselfSearchData(null);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleButtonClicks$0(View view) {
        for (final SelfMappingList selfMappingList : this.progenyList) {
            if (selfMappingList.isSelected()) {
                this.utils.validateProgenyDetails(requireActivity(), selfMappingList.getOldStateCd(), String.valueOf(selfMappingList.getOldAcNo()), String.valueOf(selfMappingList.getOldPartNumber()), String.valueOf(selfMappingList.getOldPartSerialNo()), this.sharedViewModel.getElectorname(), new ValidationCallback() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.ProgenyListDialogFragment.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback
                    public void onResult(boolean isValidate) {
                        if (isValidate) {
                            ProgenyListDialogFragment.this.sentselfSearchData(selfMappingList);
                        }
                    }
                });
                return;
            }
        }
    }

    private void init() {
        this.sharedViewModel = (SharedViewModel) new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        this.userClient = (UserClient) ApiClient.getClient2(requireActivity()).create(UserClient.class);
        this.utils = new Utils();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        MappingRoot mappingModel = this.sharedViewModel.getMappingModel();
        this.mappingRoot = mappingModel;
        List<SelfMappingList> progenyMappingList = mappingModel.getPayload().getBloMapping().getProgenyMappingList();
        this.progenyList = progenyMappingList;
        if (progenyMappingList.size() > 0) {
            this.binding.tvRecordCount.setVisibility(0);
            this.binding.tvRecordCount.setText(requireActivity().getResources().getString(R.string.total_record) + " " + this.progenyList.size());
            setAdapter();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAdapter$1() {
        this.binding.layoutVerifyButton.setVisibility(0);
    }

    private void setAdapter() {
        this.progenyListAdapter = new ProgenyListAdapter(getContext(), this.progenyList, new ProgenyListAdapter.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.fragment.ProgenyListDialogFragment$$ExternalSyntheticLambda0
            @Override // in.gov.eci.bloapp.views.activity.newsir.adapter.ProgenyListAdapter.OnItemSelectedListener
            public final void onItemSelected() {
                this.f$0.lambda$setAdapter$1();
            }
        });
        this.binding.rvMapping.setLayoutManager(new LinearLayoutManager(getContext()));
        this.binding.rvMapping.setAdapter(this.progenyListAdapter);
    }

    private void getSessionValue() {
        this.atkband = SharedPref.getInstance(requireActivity()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(requireActivity()).getRtknBnd();
        this.token = SharedPref.getInstance(requireActivity()).getToken();
        this.state = SharedPref.getInstance(requireActivity()).getStateCode();
        this.acNo = SharedPref.getInstance(requireActivity()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireActivity()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireActivity()).getRefreshToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sentselfSearchData(SelfMappingList selfMappingList) {
        if (this.listener != null) {
            dismiss();
            this.listener.onDataReceived(selfMappingList, null, null);
        }
    }
}
