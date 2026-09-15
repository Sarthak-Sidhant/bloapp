package in.gov.eci.bloapp.views.fragments.voterforms;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallbackjsonTest;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloBottomSheetDeletionLayoutBinding;
import in.gov.eci.bloapp.databinding.BloBottomSheetLayoutBinding;
import in.gov.eci.bloapp.databinding.BloBottomSheetMigrationBinding;
import in.gov.eci.bloapp.databinding.BloBottomsheetaadharBinding;
import in.gov.eci.bloapp.databinding.BloFragmentVoterFormsBinding;
import in.gov.eci.bloapp.databinding.BloOverseasBottomSheetLayoutBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.AadharAuthViewModel;
import in.gov.eci.bloapp.viewmodel.DeletionObjectionViewModel;
import in.gov.eci.bloapp.viewmodel.MainActivityViewModel;
import in.gov.eci.bloapp.viewmodel.MigrationViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.newsir.fragment.OfflineFormsCountFragment;
import in.gov.eci.bloapp.views.activity.newsir.utils.Utils;
import in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment;
import in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionTabLayoutActivity;
import in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.NameRecyclerView;
import in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft;
import in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantFragment;
import in.gov.eci.bloapp.views.fragments.voterforms.migration.SelectApplicantObjecteeFragment;
import in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.NewVoter;
import in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter;
import in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusFragment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class VoterFormsFragment extends Fragment {
    static int spanExclusiveExclusive = 33;
    String SESSION;
    AadharAuthViewModel aadhaarAuthViewModel;
    String acNameForForm6B;
    String acNumberText;
    AlertDialog alertDialog;
    String alertText;
    private String asmblyNO;
    String assemblyNoForForm6B;
    private String atkband;
    String bearerText;
    private BloFragmentVoterFormsBinding binding;
    Retrofit.Builder builder;
    Bundle bundle2;
    String category;
    CommomUtility commomUtility;
    String contentText;
    String currentRole;
    String dataMissmatchText;
    DeletionObjectionViewModel deletionobjectionViewModel;
    String districtNameForForm6B;
    String efPhotoFile;
    String efbase64image;
    String emailIdForForm6B;
    String enterCorrectEpicNumber;
    String enterEpicNumber;
    JsonArray epicDetailsArray;
    String epicId;
    String epicIdForForm6B;
    String epicNumber;
    String epicNumber2;
    String epicNumberId;
    String epicNumberId2;
    String epicNumberStatus;
    String epicNumberStringForm7;
    HashMap<String, Object> epicmap;
    String firstNameForForm6B;
    String firstname;
    String firstnamefromdbStringForm7;
    String flag;
    String formText;
    String getRefreshTokenText;
    String lastNameForForm6B;
    String lastname;
    String lastnamefromdbStringForm7;
    String logTag;
    String messageText;
    MigrationViewModel migrationViewModel;
    String mobileNoForForm6B;
    String noRecordFoundWithEpic;
    String otherStringForm7;
    private String partNo;
    String partNumberStringForm7;
    private JsonObject payloadContent;
    private JsonObject payloadForm7;
    String pleaseTryAgain;
    JsonArray proceedingEpicDetailsArray;
    String refreshToken;
    ArrayList<String> relationCodeSpinnerVal;
    ArrayList<String> relationNameSpinnerVal;
    String requestStringForm7;
    String requestTypeStringForm7;
    Retrofit retrofit;
    private String rtkband;
    String sectionErrorText;
    String sectionNameText;
    String sectionNoText;
    ArrayList<String> sectionNolist;
    private String sectionNumber;
    String selectRelationType;
    private String selectedSection;
    String sessionExpiredTextForRefresh;
    String sessionTokenExpiredPleaseLogin;
    String stateCdForForm6B;
    private String stateCode;
    String stateNameForForm6B;
    Utils utils;
    MainActivityViewModel viewModel;
    String voterFormsText;
    String voterId2StringForm7;
    String voterIdStringForm7;
    String voterIdText;
    String appfor = "";
    String token = "";
    JsonObject payLoad = null;
    String bloPartNumber = "";
    String bloStateCode = "";
    String bloAssemblyCode = "";
    String request = "";
    boolean validateForm6B = false;
    String selectedRequestType = "";
    CommomUtility commonUtilClass = new CommomUtility();
    String error = "start";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();

    public VoterFormsFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commonUtilClass.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.epicmap = new HashMap<>();
        this.sectionNolist = new ArrayList<>();
        this.stateNameForForm6B = "";
        this.districtNameForForm6B = "";
        this.acNameForForm6B = "";
        this.assemblyNoForForm6B = "";
        this.firstNameForForm6B = "";
        this.lastNameForForm6B = "";
        this.epicIdForForm6B = "";
        this.mobileNoForForm6B = "";
        this.emailIdForForm6B = "";
        this.stateCdForForm6B = "";
        this.dataMissmatchText = "Data Mismatched from user token";
        this.epicDetailsArray = null;
        this.proceedingEpicDetailsArray = null;
        this.bundle2 = new Bundle();
        this.sessionTokenExpiredPleaseLogin = "Session token expired please Login";
        this.sessionExpiredTextForRefresh = "Page refreshed due to the token expiry.";
        this.bearerText = "Bearer ";
        this.getRefreshTokenText = "getRefreshToken : ";
        this.voterIdText = "voterId";
        this.formText = "form";
        this.currentRole = "blo";
        this.logTag = "VoterFormsFragment";
        this.contentText = "content";
        this.acNumberText = "acNumber";
        this.messageText = "message";
        this.alertText = "Alert";
        this.enterEpicNumber = "Enter EPIC Number";
        this.enterCorrectEpicNumber = "Enter Correct EPIC Number";
        this.epicNumberStringForm7 = "epicNumber";
        this.partNumberStringForm7 = "partNumber";
        this.requestTypeStringForm7 = "Request Type: ";
        this.requestStringForm7 = "request";
        this.voterIdStringForm7 = "voterId";
        this.voterId2StringForm7 = "voterId2";
        this.efPhotoFile = null;
        this.efbase64image = null;
        this.firstnamefromdbStringForm7 = "firstnamefromdb";
        this.lastnamefromdbStringForm7 = "lastnamefromdb";
        this.noRecordFoundWithEpic = "No Record Found with epic number: ";
        this.otherStringForm7 = "other";
        this.pleaseTryAgain = "Please try again";
        this.sectionNameText = "sectionName";
        this.sectionNoText = "sectionNo";
        this.voterFormsText = "Voter Forms";
        this.sectionErrorText = "Section Error - ";
        this.relationNameSpinnerVal = new ArrayList<>();
        this.relationCodeSpinnerVal = new ArrayList<>();
        this.selectRelationType = "";
        this.SESSION = "";
    }

    static String capitailizeWord(String str) {
        StringBuilder sb = new StringBuilder();
        char cCharAt = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (cCharAt == ' ' && str.charAt(i) != ' ') {
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
            cCharAt = str.charAt(i);
        }
        return sb.toString().trim();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.viewModel = (MainActivityViewModel) new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        this.aadhaarAuthViewModel = (AadharAuthViewModel) new ViewModelProvider(requireActivity()).get(AadharAuthViewModel.class);
        this.migrationViewModel = (MigrationViewModel) new ViewModelProvider(requireActivity()).get(MigrationViewModel.class);
        this.deletionobjectionViewModel = (DeletionObjectionViewModel) new ViewModelProvider(requireActivity()).get(DeletionObjectionViewModel.class);
        this.binding = BloFragmentVoterFormsBinding.inflate(getLayoutInflater());
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.epicNumberId = arguments.getString("epic");
            this.epicId = arguments.getString("epicId");
            this.flag = arguments.getString("flag");
            this.efPhotoFile = arguments.getString("efPhoto");
            this.efbase64image = arguments.getString("efbase64image");
            this.category = arguments.getString("category");
            Logger.d("args data", this.epicNumberId + StringUtils.SPACE + this.flag + StringUtils.SPACE + this.epicId);
        }
        initCLickListener();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.bloPartNumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.bloAssemblyCode = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.bloStateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.atkband = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(requireContext()).getRtknBnd();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        Logger.d(this.logTag, "bloPartNumber bloAssemblyCode bloStateCode " + this.bloPartNumber + StringUtils.SPACE + this.bloAssemblyCode + StringUtils.SPACE + this.bloStateCode);
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        if (SharedPref.getInstance(requireContext()).getFormCounts().equalsIgnoreCase("Y")) {
            this.binding.linearOfflineForms.setVisibility(0);
        } else if (SharedPref.getInstance(requireContext()).getFormCounts().equalsIgnoreCase("N")) {
            this.binding.linearOfflineForms.setVisibility(8);
        }
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment.1
            public void handleOnBackPressed() {
                Intent intent = new Intent((Context) VoterFormsFragment.this.getActivity(), (Class<?>) MainActivity.class);
                intent.setFlags(268468224);
                VoterFormsFragment.this.startActivity(intent);
            }
        });
        this.binding.trackApplicationLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.linearOfflineForms.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.selectRelationType = getString(R.string.selectRelationMsg);
        this.SESSION = getString(R.string.sessionMsg);
        this.commomUtility = new CommomUtility();
        this.utils = new Utils();
        if (SharedPref.getInstance(requireContext()).getRelativeListCode(Constants.RELATIVE_LIST_CODE).isEmpty() || SharedPref.getInstance(requireContext()).getRelativeListName(Constants.RELATIVE_LIST_NAME).isEmpty()) {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            getRelationTypeDropdown();
        }
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        openFragment2(new TrackStatusFragment(), "track status");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) OfflineFormsCountFragment.class));
    }

    private void showAlertDialogButtonClicked() {
        if (!SharedPref.getInstance(requireContext()).getSectionData().equals("")) {
            try {
                this.sectionNolist.add("Select Section No. & Name");
                JSONArray jSONArray = (JSONArray) new JSONParser().parse(SharedPref.getInstance(requireContext()).getSectionData());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.size(); i++) {
                    JsonObject asJsonObject = this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                    if (asJsonObject.get(this.sectionNameText) == null) {
                        this.sectionNumber = asJsonObject.get(this.sectionNoText).getAsInt() + " - ";
                    } else {
                        this.sectionNumber = asJsonObject.get(this.sectionNoText).getAsInt() + " - " + asJsonObject.get(this.sectionNameText).getAsString();
                    }
                    arrayList.add(this.sectionNumber);
                }
                Collections.sort(arrayList, new Comparator() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda27
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return VoterFormsFragment.lambda$showAlertDialogButtonClicked$2((String) obj, (String) obj2);
                    }
                });
                this.sectionNolist.addAll(arrayList);
            } catch (ParseException e) {
                Logger.d(this.logTag, e.getMessage());
            }
        } else {
            getSection(this.stateCode, this.token, this.asmblyNO, this.partNo);
        }
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        final BloBottomSheetLayoutBinding bloBottomSheetLayoutBindingInflate = BloBottomSheetLayoutBinding.inflate(getLayoutInflater());
        dialog.setContentView((View) bloBottomSheetLayoutBindingInflate.getRoot());
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) requireActivity(), android.R.layout.simple_spinner_dropdown_item, (List) this.sectionNolist);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloBottomSheetLayoutBindingInflate.sectionNo.setAdapter((SpinnerAdapter) arrayAdapter);
        bloBottomSheetLayoutBindingInflate.sectionNo.setSelection(0);
        bloBottomSheetLayoutBindingInflate.sectionNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                VoterFormsFragment.this.selectedSection = String.valueOf(parent.getItemAtPosition(position));
            }
        });
        bloBottomSheetLayoutBindingInflate.btnProceed.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showAlertDialogButtonClicked$3(bloBottomSheetLayoutBindingInflate, dialog, view);
            }
        });
        dialog.show();
    }

    static /* synthetic */ int lambda$showAlertDialogButtonClicked$2(String str, String str2) {
        return Integer.parseInt(str.split("-")[0].trim()) - Integer.parseInt(str2.split("-")[0].trim());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAlertDialogButtonClicked$3(BloBottomSheetLayoutBinding bloBottomSheetLayoutBinding, Dialog dialog, View view) {
        if (!bloBottomSheetLayoutBinding.sectionNo.getSelectedItem().toString().equals("Select Section No. & Name")) {
            openFragmentNew(new NewVoter(), this.voterFormsText);
            dialog.dismiss();
        } else {
            showDialog("Please select section number.");
        }
    }

    private void showOverseasAlertDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        BloOverseasBottomSheetLayoutBinding bloOverseasBottomSheetLayoutBindingInflate = BloOverseasBottomSheetLayoutBinding.inflate(getLayoutInflater());
        dialog.setContentView((View) bloOverseasBottomSheetLayoutBindingInflate.getRoot());
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
        bloOverseasBottomSheetLayoutBindingInflate.btnProceed.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showOverseasAlertDialog$4(dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showOverseasAlertDialog$4(Dialog dialog, View view) {
        openFragment(new OverseasVoter(), "overseas Forms");
        dialog.dismiss();
    }

    private void showDeletionDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        dialog.setContentView((View) BloBottomSheetDeletionLayoutBinding.inflate(getLayoutInflater()).getRoot());
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
        TextView textView = (TextView) dialog.findViewById(R.id.btn_Proceed);
        TextView textView2 = (TextView) dialog.findViewById(R.id.required_dcc_tv);
        TextView textView3 = (TextView) dialog.findViewById(R.id.doc1_tv);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.dot_tv);
        TextView textView4 = (TextView) dialog.findViewById(R.id.first_name_tv);
        RadioGroup radioGroup = (RadioGroup) dialog.findViewById(R.id.bottom_sheet_rg);
        final RadioGroup radioGroup2 = (RadioGroup) dialog.findViewById(R.id.bottom_sheet_rg2);
        final RadioButton radioButton = (RadioButton) dialog.findViewById(R.id.bottom_sheet_rg).findViewById(R.id.same_epic_rb);
        final RadioButton radioButton2 = (RadioButton) dialog.findViewById(R.id.bottom_sheet_rg).findViewById(R.id.other_elector_rb);
        final RadioButton radioButton3 = (RadioButton) dialog.findViewById(R.id.bottom_sheet_rg).findViewById(R.id.object_rb);
        final RadioButton radioButton4 = (RadioButton) dialog.findViewById(R.id.bottom_sheet_rg2).findViewById(R.id.prefilled_epic_rb);
        final RadioButton radioButton5 = (RadioButton) dialog.findViewById(R.id.bottom_sheet_rg2).findViewById(R.id.prefilled_name_rb);
        final EditText editText = (EditText) dialog.findViewById(R.id.bottom_sheet_epic_layout).findViewById(R.id.bottom_sheet_epic_ed);
        final EditText editText2 = (EditText) dialog.findViewById(R.id.bottom_sheet_epic_layout2).findViewById(R.id.bottom_sheet_epic_ed2);
        final EditText editText3 = (EditText) dialog.findViewById(R.id.bottom_sheet_name_layout).findViewById(R.id.bottom_sheet_firstname_ed);
        final EditText editText4 = (EditText) dialog.findViewById(R.id.bottom_sheet_name_layout).findViewById(R.id.bottom_sheet_lastname_ed);
        textView.setText("Select Record");
        editText.requestFocus();
        textView4.setText(mandatorymarker(textView4.getText().toString()));
        editText3.setEnabled(false);
        editText4.setEnabled(false);
        if (!TextUtils.isEmpty(this.flag) && this.flag.equalsIgnoreCase("dseVerified")) {
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            imageView.setVisibility(8);
            editText.setText(this.epicNumberId);
            editText.setEnabled(false);
            radioButton.setChecked(true);
            radioButton3.setEnabled(false);
            radioButton2.setEnabled(false);
        }
        if (!TextUtils.isEmpty(this.flag) && this.flag.equalsIgnoreCase("PseVerified")) {
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            imageView.setVisibility(8);
            editText.setText(this.epicNumberId);
            editText.setEnabled(false);
            radioButton.setChecked(true);
            radioButton3.setEnabled(false);
            radioButton2.setEnabled(false);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup3, int i) {
                this.f$0.lambda$showDeletionDialog$6(radioButton, dialog, editText2, editText3, editText4, radioButton2, radioButton4, radioButton5, radioGroup2, radioButton3, radioGroup3, i);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showDeletionDialog$7(editText, editText2, editText3, editText4, radioButton2, radioButton4, radioButton5, radioButton3, radioButton, dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeletionDialog$6(RadioButton radioButton, final Dialog dialog, final EditText editText, final EditText editText2, final EditText editText3, RadioButton radioButton2, final RadioButton radioButton3, RadioButton radioButton4, RadioGroup radioGroup, RadioButton radioButton5, RadioGroup radioGroup2, int i) {
        if (radioButton.isChecked()) {
            dialog.findViewById(R.id.search_by_tv).setVisibility(8);
            dialog.findViewById(R.id.bottom_sheet_rg2).setVisibility(8);
            dialog.findViewById(R.id.bottom_sheet_epic_layout2).setVisibility(8);
            dialog.findViewById(R.id.bottom_sheet_name_layout).setVisibility(8);
            editText.setEnabled(false);
            editText.setText("");
            editText2.setEnabled(false);
            editText2.setText("");
            editText3.setEnabled(false);
            editText3.setText("");
            return;
        }
        if (radioButton2.isChecked()) {
            dialog.findViewById(R.id.search_by_tv).setVisibility(0);
            dialog.findViewById(R.id.bottom_sheet_rg2).setVisibility(0);
            dialog.findViewById(R.id.bottom_sheet_epic_layout2).setVisibility(0);
            dialog.findViewById(R.id.bottom_sheet_name_layout).setVisibility(8);
            radioButton3.setChecked(true);
            radioButton4.setChecked(false);
            editText.setEnabled(true);
            editText2.setEnabled(false);
            editText2.setText("");
            editText3.setEnabled(false);
            editText3.setText("");
            editText.requestFocus();
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda8
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup3, int i2) {
                    this.f$0.lambda$showDeletionDialog$5(radioButton3, dialog, editText, editText2, editText3, radioGroup3, i2);
                }
            });
            return;
        }
        if (radioButton5.isChecked()) {
            editText2.setText("");
            editText3.setText("");
            dialog.findViewById(R.id.search_by_tv).setVisibility(8);
            dialog.findViewById(R.id.bottom_sheet_rg2).setVisibility(8);
            dialog.findViewById(R.id.bottom_sheet_epic_layout2).setVisibility(8);
            dialog.findViewById(R.id.bottom_sheet_name_layout).setVisibility(0);
            editText2.setEnabled(true);
            editText3.setEnabled(true);
            editText2.requestFocus();
            editText.setEnabled(false);
            editText.setText("");
            editText.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeletionDialog$5(RadioButton radioButton, Dialog dialog, EditText editText, EditText editText2, EditText editText3, RadioGroup radioGroup, int i) {
        if (radioButton.isChecked()) {
            dialog.findViewById(R.id.bottom_sheet_epic_layout2).setVisibility(0);
            dialog.findViewById(R.id.bottom_sheet_name_layout).setVisibility(8);
            editText.setEnabled(true);
            editText2.setEnabled(false);
            editText2.setText("");
            editText3.setEnabled(false);
            editText3.setText("");
            editText2.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
            editText3.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
            return;
        }
        dialog.findViewById(R.id.bottom_sheet_epic_layout2).setVisibility(8);
        dialog.findViewById(R.id.bottom_sheet_name_layout).setVisibility(0);
        editText2.setEnabled(true);
        editText3.setEnabled(true);
        editText2.requestFocus();
        editText.setEnabled(false);
        editText.setText("");
        editText.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_grey_line));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeletionDialog$7(EditText editText, EditText editText2, EditText editText3, EditText editText4, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, Dialog dialog, View view) {
        this.epicNumberId = editText.getText().toString().toUpperCase();
        this.epicNumberId2 = editText2.getText().toString().toUpperCase();
        this.firstname = capitailizeWord(editText3.getText().toString().toLowerCase());
        this.lastname = capitailizeWord(editText4.getText().toString().toLowerCase());
        Logger.d("epicNumberId ", this.epicNumberId);
        Logger.d("epicNumberIdOther ", this.epicNumberId2);
        this.epicNumberStatus = "";
        this.epicNumber = "";
        this.epicNumber2 = "";
        this.payloadForm7 = null;
        this.payloadContent = null;
        if (editText.getText().toString().isEmpty()) {
            showDialog("Enter Applicant's EPIC Number ");
            editText.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
            return;
        }
        if (!editText.getText().toString().isEmpty() && !editText.getText().toString().matches(RegexMatcher.FAMILY_EPIC_REGEX)) {
            showDialog("Enter Applicant's correct EPIC Number ");
            editText.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
            return;
        }
        if (radioButton.isChecked() && radioButton2.isChecked() && editText2.getText().toString().isEmpty()) {
            showDialog("Enter Other Elector's EPIC Number ");
            editText2.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
            return;
        }
        if (radioButton.isChecked() && radioButton2.isChecked() && !editText2.getText().toString().isEmpty() && !editText2.getText().toString().matches(RegexMatcher.FAMILY_EPIC_REGEX)) {
            showDialog("Enter Other Elector's correct EPIC Number ");
            editText2.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
            return;
        }
        if (radioButton.isChecked() && radioButton3.isChecked() && editText3.getText().toString().isEmpty()) {
            showDialog("Enter Other Elector's Name ");
            editText3.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
        } else if (radioButton4.isChecked() && editText3.getText().toString().isEmpty()) {
            showDialog("Enter Name ");
            editText3.setBackgroundTintList(getContext().getResources().getColorStateList(R.color.blo_red));
        } else {
            this.alertDialog.show();
            HashMap map = new HashMap();
            map.put(this.epicNumberStringForm7, this.epicNumberId);
            this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getByEpicForForm(this.token, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP", this.currentRole, "ANDROIDMOB", map).enqueue(new AnonymousClass3(radioButton5, editText, dialog, radioButton, radioButton2, editText2, editText3, editText4, radioButton3, radioButton4));
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonArray> {
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ EditText val$epicEd;
        final /* synthetic */ EditText val$epicEd2;
        final /* synthetic */ RadioButton val$epicrb;
        final /* synthetic */ EditText val$firstNameEd;
        final /* synthetic */ EditText val$lastNameEd;
        final /* synthetic */ RadioButton val$namerb;
        final /* synthetic */ RadioButton val$objectionRb;
        final /* synthetic */ RadioButton val$otherElectorRb;
        final /* synthetic */ RadioButton val$sameEpicRb;

        AnonymousClass3(final RadioButton val$sameEpicRb, final EditText val$epicEd, final Dialog val$dialog, final RadioButton val$otherElectorRb, final RadioButton val$epicrb, final EditText val$epicEd2, final EditText val$firstNameEd, final EditText val$lastNameEd, final RadioButton val$namerb, final RadioButton val$objectionRb) {
            this.val$sameEpicRb = val$sameEpicRb;
            this.val$epicEd = val$epicEd;
            this.val$dialog = val$dialog;
            this.val$otherElectorRb = val$otherElectorRb;
            this.val$epicrb = val$epicrb;
            this.val$epicEd2 = val$epicEd2;
            this.val$firstNameEd = val$firstNameEd;
            this.val$lastNameEd = val$lastNameEd;
            this.val$namerb = val$namerb;
            this.val$objectionRb = val$objectionRb;
        }

        public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
            if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                ArrayList arrayList = new ArrayList();
                JsonArray jsonArray = (JsonArray) response.body();
                for (int i = 0; i < jsonArray.size(); i++) {
                    VoterFormsFragment.this.payloadForm7 = jsonArray.get(i).get(VoterFormsFragment.this.contentText);
                    String strTrim = String.valueOf(VoterFormsFragment.this.payloadForm7.get(VoterFormsFragment.this.acNumberText)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                    String strTrim2 = String.valueOf(VoterFormsFragment.this.payloadForm7.get(VoterFormsFragment.this.partNumberStringForm7)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                    if (VoterFormsFragment.this.asmblyNO.equals(strTrim) && ((this.val$sameEpicRb.isChecked() && VoterFormsFragment.this.partNo.equals(strTrim2)) || !this.val$sameEpicRb.isChecked())) {
                        arrayList.add(strTrim2);
                    }
                }
                if (arrayList.size() == 0) {
                    VoterFormsFragment.this.showDialog(VoterFormsFragment.this.noRecordFoundWithEpic + VoterFormsFragment.this.epicNumberId);
                    this.val$epicEd.setText("");
                    VoterFormsFragment.this.alertDialog.dismiss();
                    return;
                }
                if (this.val$sameEpicRb.isChecked()) {
                    VoterFormsFragment.this.request = "same";
                    VoterFormsFragment.this.epicNumber = this.val$epicEd.getText().toString().toUpperCase();
                    Logger.d(VoterFormsFragment.this.requestTypeStringForm7, VoterFormsFragment.this.request);
                    Logger.d("Applicant's EPIC: ", VoterFormsFragment.this.epicNumber);
                    Bundle bundle = new Bundle();
                    bundle.putString(VoterFormsFragment.this.requestStringForm7, VoterFormsFragment.this.request);
                    bundle.putString(VoterFormsFragment.this.voterIdStringForm7, VoterFormsFragment.this.epicNumber);
                    bundle.putString(VoterFormsFragment.this.voterId2StringForm7, VoterFormsFragment.this.epicNumber2);
                    bundle.putString(VoterFormsFragment.this.firstnamefromdbStringForm7, VoterFormsFragment.this.firstname);
                    bundle.putString(VoterFormsFragment.this.lastnamefromdbStringForm7, VoterFormsFragment.this.lastname);
                    bundle.putString("epicId", VoterFormsFragment.this.epicId);
                    bundle.putString("epicNumberId", VoterFormsFragment.this.epicNumberId);
                    bundle.putString("flag", VoterFormsFragment.this.flag);
                    bundle.putString("applicantEpicDetailsArray", jsonArray.toString());
                    NameRecyclerView nameRecyclerView = new NameRecyclerView();
                    nameRecyclerView.setArguments(bundle);
                    VoterFormsFragment.this.openFragment(nameRecyclerView, "Deletion Objection for Self");
                    this.val$dialog.dismiss();
                    VoterFormsFragment.this.alertDialog.dismiss();
                    return;
                }
                if (this.val$otherElectorRb.isChecked() && this.val$epicrb.isChecked()) {
                    if (VoterFormsFragment.this.epicNumberId2.equals(VoterFormsFragment.this.epicNumberId)) {
                        VoterFormsFragment.this.showDialog("Applicant's EPIC Number and other Elector's EPIC Number cannot be same. Please enter different EPIC numbers.");
                        this.val$epicEd2.setBackgroundTintList(VoterFormsFragment.this.getContext().getResources().getColorStateList(R.color.blo_red));
                        this.val$epicEd2.setText("");
                        VoterFormsFragment.this.alertDialog.dismiss();
                        return;
                    }
                    HashMap map = new HashMap();
                    map.put(VoterFormsFragment.this.epicNumberStringForm7, VoterFormsFragment.this.epicNumberId2);
                    VoterFormsFragment.this.commonUtilClass.getRetrofitClient(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.token, VoterFormsFragment.this.atkband, VoterFormsFragment.this.rtkband).getByEpicForForm(VoterFormsFragment.this.token, SharedPref.getInstance(VoterFormsFragment.this.getContext()).getAtknBnd(), SharedPref.getInstance(VoterFormsFragment.this.getContext()).getRtknBnd(), "BLOAPP", VoterFormsFragment.this.currentRole, "ANDROIDMOB", map).enqueue(new AnonymousClass1(jsonArray));
                    return;
                }
                if (this.val$otherElectorRb.isChecked() && this.val$namerb.isChecked()) {
                    HashMap map2 = new HashMap();
                    map2.put(Constants.FIRST_NAME, VoterFormsFragment.this.firstname);
                    map2.put(Constants.LAST_NAME, VoterFormsFragment.this.lastname);
                    map2.put("stateCd", VoterFormsFragment.this.stateCode);
                    map2.put("acNo", VoterFormsFragment.this.asmblyNO);
                    map2.put("isActive", "Y");
                    VoterFormsFragment.this.commonUtilClass.getRetrofitClient(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.token, VoterFormsFragment.this.atkband, VoterFormsFragment.this.rtkband).getByDetailsForForm(VoterFormsFragment.this.token, SharedPref.getInstance(VoterFormsFragment.this.getContext()).getAtknBnd(), SharedPref.getInstance(VoterFormsFragment.this.getContext()).getRtknBnd(), "BLOAPP", VoterFormsFragment.this.currentRole, "ANDROIDMOB", map2).enqueue(new AnonymousClass2(jsonArray));
                    return;
                }
                if (this.val$objectionRb.isChecked()) {
                    VoterFormsFragment.this.commonUtilClass.getRetrofitClient(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.token, VoterFormsFragment.this.atkband, VoterFormsFragment.this.rtkband).getForm7byfirstNameAndlastNameObjection(VoterFormsFragment.this.firstname, VoterFormsFragment.this.lastname, VoterFormsFragment.this.stateCode, VoterFormsFragment.this.asmblyNO, VoterFormsFragment.this.token, SharedPref.getInstance(VoterFormsFragment.this.getContext()).getAtknBnd(), SharedPref.getInstance(VoterFormsFragment.this.getContext()).getRtknBnd(), "BLOAPP", VoterFormsFragment.this.currentRole, VoterFormsFragment.this.stateCode, "ANDROIDMOB").enqueue(new C00543(jsonArray));
                    return;
                }
                return;
            }
            try {
                if (response.code() == 401) {
                    CommomUtility commomUtility = VoterFormsFragment.this.commonUtilClass;
                    Context contextRequireContext = VoterFormsFragment.this.requireContext();
                    String str = VoterFormsFragment.this.refreshToken;
                    final EditText editText = this.val$epicEd;
                    commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str2, String str3) {
                            this.f$0.lambda$onResponse$1(editText, i2, str2, str3);
                        }
                    });
                } else {
                    String strOptString = new JSONObject(response.errorBody().string()).optString(VoterFormsFragment.this.messageText);
                    Logger.d("form 7 self case error: ", strOptString);
                    VoterFormsFragment.this.alertDialog.dismiss();
                    VoterFormsFragment.this.showDialog(strOptString);
                }
            } catch (Exception e) {
                VoterFormsFragment.this.alertDialog.dismiss();
                if (response.code() == 401) {
                    CommomUtility commomUtility2 = VoterFormsFragment.this.commonUtilClass;
                    Context contextRequireContext2 = VoterFormsFragment.this.requireContext();
                    String str2 = VoterFormsFragment.this.refreshToken;
                    final EditText editText2 = this.val$epicEd;
                    commomUtility2.getRefreshToken(contextRequireContext2, str2, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str3, String str4) {
                            this.f$0.lambda$onResponse$3(editText2, i2, str3, str4);
                        }
                    });
                } else if (response != null && response.code() != 200 && response.message() != null) {
                    VoterFormsFragment.this.showDialog(response.message());
                } else {
                    VoterFormsFragment.this.showDialog("No record found with epic number: " + VoterFormsFragment.this.epicNumberId);
                }
                Logger.d("", e.getMessage());
            }
            this.val$epicEd.setText("");
            VoterFormsFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$1, reason: invalid class name */
        class AnonymousClass1 implements Callback<JsonArray> {
            final /* synthetic */ JsonArray val$payloadnamesSelf;

            AnonymousClass1(final JsonArray val$payloadnamesSelf) {
                this.val$payloadnamesSelf = val$payloadnamesSelf;
            }

            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    JsonArray jsonArray = (JsonArray) response.body();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        VoterFormsFragment.this.payloadContent = jsonArray.get(i).get(VoterFormsFragment.this.contentText);
                        String strTrim = String.valueOf(VoterFormsFragment.this.payloadContent.get(VoterFormsFragment.this.acNumberText)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                        String strTrim2 = String.valueOf(VoterFormsFragment.this.payloadContent.get(VoterFormsFragment.this.partNumberStringForm7)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                        if (VoterFormsFragment.this.asmblyNO.equals(strTrim) && VoterFormsFragment.this.partNo.equals(strTrim2)) {
                            arrayList.add(strTrim2);
                        }
                    }
                    if (arrayList.size() == 0) {
                        VoterFormsFragment.this.showDialog(VoterFormsFragment.this.noRecordFoundWithEpic + VoterFormsFragment.this.epicNumberId2);
                        AnonymousClass3.this.val$epicEd2.setText("");
                        VoterFormsFragment.this.alertDialog.dismiss();
                        return;
                    }
                    VoterFormsFragment.this.request = VoterFormsFragment.this.otherStringForm7;
                    VoterFormsFragment.this.epicNumber = AnonymousClass3.this.val$epicEd.getText().toString().toUpperCase();
                    VoterFormsFragment.this.epicNumber2 = AnonymousClass3.this.val$epicEd2.getText().toString().toUpperCase();
                    Logger.d(VoterFormsFragment.this.requestTypeStringForm7, VoterFormsFragment.this.request);
                    Logger.d("Applicant's EPIC: ", VoterFormsFragment.this.epicNumber);
                    Logger.d("Other Elector's EPIC: ", VoterFormsFragment.this.epicNumber2);
                    Intent intent = new Intent((Context) VoterFormsFragment.this.requireActivity(), (Class<?>) DeletionObjectionTabLayoutActivity.class);
                    intent.putExtra(VoterFormsFragment.this.requestStringForm7, VoterFormsFragment.this.request);
                    intent.putExtra("subRequest", "epic");
                    intent.putExtra(VoterFormsFragment.this.voterIdStringForm7, VoterFormsFragment.this.epicNumber);
                    intent.putExtra(VoterFormsFragment.this.voterId2StringForm7, VoterFormsFragment.this.epicNumber2);
                    intent.putExtra(VoterFormsFragment.this.firstnamefromdbStringForm7, VoterFormsFragment.this.firstname);
                    intent.putExtra(VoterFormsFragment.this.lastnamefromdbStringForm7, VoterFormsFragment.this.lastname);
                    intent.putExtra("applicantEpicDetailsArray", this.val$payloadnamesSelf.toString());
                    intent.putExtra("objecteeEpicDetailsArray", jsonArray.toString());
                    intent.putExtra("flag", VoterFormsFragment.this.flag);
                    VoterFormsFragment.this.startActivity(intent);
                    AnonymousClass3.this.val$dialog.dismiss();
                    VoterFormsFragment.this.alertDialog.dismiss();
                    return;
                }
                try {
                    if (response.code() == 401) {
                        CommomUtility commomUtility = VoterFormsFragment.this.commonUtilClass;
                        Context contextRequireContext = VoterFormsFragment.this.requireContext();
                        String str = VoterFormsFragment.this.refreshToken;
                        final EditText editText = AnonymousClass3.this.val$firstNameEd;
                        final EditText editText2 = AnonymousClass3.this.val$lastNameEd;
                        commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$1$$ExternalSyntheticLambda0
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i2, String str2, String str3) {
                                this.f$0.lambda$onResponse$1(editText, editText2, i2, str2, str3);
                            }
                        });
                    } else {
                        String strOptString = new JSONObject(response.errorBody().string()).optString(VoterFormsFragment.this.messageText);
                        Logger.d("Form 7 Other Epic case error: ", strOptString);
                        VoterFormsFragment.this.alertDialog.dismiss();
                        VoterFormsFragment.this.showDialog(strOptString);
                    }
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                    VoterFormsFragment.this.alertDialog.dismiss();
                    if (response.code() == 401) {
                        CommomUtility commomUtility2 = VoterFormsFragment.this.commonUtilClass;
                        Context contextRequireContext2 = VoterFormsFragment.this.requireContext();
                        String str2 = VoterFormsFragment.this.refreshToken;
                        final EditText editText3 = AnonymousClass3.this.val$epicEd2;
                        commomUtility2.getRefreshToken(contextRequireContext2, str2, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$1$$ExternalSyntheticLambda1
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i2, String str3, String str4) {
                                this.f$0.lambda$onResponse$3(editText3, i2, str3, str4);
                            }
                        });
                    } else if (response != null && response.code() != 200 && response.message() != null) {
                        VoterFormsFragment.this.showDialog(response.message());
                    } else {
                        VoterFormsFragment.this.showDialog(VoterFormsFragment.this.noRecordFoundWithEpic + VoterFormsFragment.this.epicNumber2);
                    }
                }
                AnonymousClass3.this.val$epicEd2.setText("");
                VoterFormsFragment.this.alertDialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$1(EditText editText, EditText editText2, int i, String str, String str2) {
                VoterFormsFragment.this.alertDialog.dismiss();
                System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                if (i == 401 || i == 400) {
                    VoterFormsFragment.this.commonUtilClass.showMessageOK(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$1$$ExternalSyntheticLambda3
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                        }
                    });
                    return;
                }
                VoterFormsFragment.this.token = "Bearer " + str;
                Toast.makeText(VoterFormsFragment.this.requireContext(), "Token Refreshed", 1).show();
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setRefreshToken(str2);
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setToken("Bearer " + str);
                VoterFormsFragment.this.showDialog("Page refreshed due to the token expiry, Please try again");
                editText.setText("");
                editText2.setText("");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setLocaleBool(false);
                VoterFormsFragment.this.startActivity(new Intent((Context) VoterFormsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$3(EditText editText, int i, String str, String str2) {
                VoterFormsFragment.this.alertDialog.dismiss();
                System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                if (i == 401 || i == 400) {
                    VoterFormsFragment.this.commonUtilClass.showMessageOK(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$1$$ExternalSyntheticLambda2
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$2(dialogInterface, i2);
                        }
                    });
                    return;
                }
                VoterFormsFragment.this.token = "Bearer " + str;
                Toast.makeText(VoterFormsFragment.this.requireContext(), "Token Refreshed", 1).show();
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setRefreshToken(str2);
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setToken("Bearer " + str);
                VoterFormsFragment.this.showDialog("Page refreshed due to the token expiry, Please try again");
                editText.setText("");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setLocaleBool(false);
                VoterFormsFragment.this.startActivity(new Intent((Context) VoterFormsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
            }

            public void onFailure(Call<JsonArray> call, Throwable t) {
                VoterFormsFragment.this.showDialog("Other Epic: " + VoterFormsFragment.this.pleaseTryAgain);
                AnonymousClass3.this.val$epicEd2.setText("");
                VoterFormsFragment.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$2, reason: invalid class name */
        class AnonymousClass2 implements Callback<JsonArray> {
            final /* synthetic */ JsonArray val$payloadnamesSelf;

            AnonymousClass2(final JsonArray val$payloadnamesSelf) {
                this.val$payloadnamesSelf = val$payloadnamesSelf;
            }

            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.body() != null && ((JsonArray) response.body()).size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    JsonArray jsonArray = new JsonArray();
                    JsonArray jsonArray2 = (JsonArray) response.body();
                    for (int i = 0; i < jsonArray2.size(); i++) {
                        VoterFormsFragment.this.payloadContent = jsonArray2.get(i).get(VoterFormsFragment.this.contentText);
                        String strTrim = String.valueOf(VoterFormsFragment.this.payloadContent.get(VoterFormsFragment.this.partNumberStringForm7)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                        if (VoterFormsFragment.this.partNo.equals(strTrim)) {
                            arrayList.add(strTrim);
                            jsonArray.add(jsonArray2.get(i).get(VoterFormsFragment.this.contentText));
                        }
                    }
                    if (arrayList.size() == 0) {
                        VoterFormsFragment.this.showDialog("No Record found with name: " + VoterFormsFragment.this.firstname + StringUtils.SPACE + VoterFormsFragment.this.lastname);
                        AnonymousClass3.this.val$firstNameEd.setText("");
                        AnonymousClass3.this.val$lastNameEd.setText("");
                        VoterFormsFragment.this.alertDialog.dismiss();
                        return;
                    }
                    VoterFormsFragment.this.request = VoterFormsFragment.this.otherStringForm7;
                    VoterFormsFragment.this.epicNumber = AnonymousClass3.this.val$epicEd.getText().toString().toUpperCase();
                    VoterFormsFragment.this.firstname = VoterFormsFragment.capitailizeWord(AnonymousClass3.this.val$firstNameEd.getText().toString().toLowerCase());
                    VoterFormsFragment.this.lastname = VoterFormsFragment.capitailizeWord(AnonymousClass3.this.val$lastNameEd.getText().toString().toLowerCase());
                    Logger.d(VoterFormsFragment.this.requestTypeStringForm7, VoterFormsFragment.this.request);
                    Logger.d("First Name: ", VoterFormsFragment.this.firstname);
                    Logger.d("Last Name: ", VoterFormsFragment.this.lastname);
                    Intent intent = new Intent((Context) VoterFormsFragment.this.requireActivity(), (Class<?>) DeletionObjectionTabLayoutActivity.class);
                    intent.putExtra(VoterFormsFragment.this.requestStringForm7, VoterFormsFragment.this.request);
                    intent.putExtra("subRequest", "name");
                    intent.putExtra(VoterFormsFragment.this.voterIdStringForm7, VoterFormsFragment.this.epicNumber);
                    intent.putExtra(VoterFormsFragment.this.voterId2StringForm7, VoterFormsFragment.this.epicNumber2);
                    intent.putExtra(VoterFormsFragment.this.firstnamefromdbStringForm7, VoterFormsFragment.this.firstname);
                    intent.putExtra(VoterFormsFragment.this.lastnamefromdbStringForm7, VoterFormsFragment.this.lastname);
                    intent.putExtra("applicantEpicDetailsArray", this.val$payloadnamesSelf.toString());
                    intent.putExtra("objecteeEpicDetailsArray", jsonArray.toString());
                    VoterFormsFragment.this.startActivity(intent);
                    AnonymousClass3.this.val$dialog.dismiss();
                    VoterFormsFragment.this.alertDialog.dismiss();
                    return;
                }
                try {
                    if (response.code() == 401) {
                        CommomUtility commomUtility = VoterFormsFragment.this.commonUtilClass;
                        Context contextRequireContext = VoterFormsFragment.this.requireContext();
                        String str = VoterFormsFragment.this.refreshToken;
                        final EditText editText = AnonymousClass3.this.val$firstNameEd;
                        final EditText editText2 = AnonymousClass3.this.val$lastNameEd;
                        commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$2$$ExternalSyntheticLambda0
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i2, String str2, String str3) {
                                this.f$0.lambda$onResponse$1(editText, editText2, i2, str2, str3);
                            }
                        });
                    } else {
                        String strOptString = new JSONObject(response.errorBody().string()).optString(VoterFormsFragment.this.messageText);
                        Logger.d("Form 7 other name case error: ", strOptString);
                        VoterFormsFragment.this.alertDialog.dismiss();
                        VoterFormsFragment.this.showDialog("Other Name: " + strOptString);
                    }
                } catch (IOException | JSONException e) {
                    Logger.d("", e.getMessage());
                    VoterFormsFragment.this.alertDialog.dismiss();
                    if (response.code() == 401) {
                        CommomUtility commomUtility2 = VoterFormsFragment.this.commonUtilClass;
                        Context contextRequireContext2 = VoterFormsFragment.this.requireContext();
                        String str2 = VoterFormsFragment.this.refreshToken;
                        final EditText editText3 = AnonymousClass3.this.val$firstNameEd;
                        final EditText editText4 = AnonymousClass3.this.val$lastNameEd;
                        commomUtility2.getRefreshToken(contextRequireContext2, str2, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$2$$ExternalSyntheticLambda1
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i2, String str3, String str4) {
                                this.f$0.lambda$onResponse$3(editText3, editText4, i2, str3, str4);
                            }
                        });
                    } else if (response.message() != null) {
                        VoterFormsFragment.this.showDialog(response.message());
                    } else {
                        VoterFormsFragment.this.showDialog("No Record found with name: " + VoterFormsFragment.this.firstname + StringUtils.SPACE + VoterFormsFragment.this.lastname);
                    }
                }
                AnonymousClass3.this.val$firstNameEd.setText("");
                AnonymousClass3.this.val$lastNameEd.setText("");
                VoterFormsFragment.this.alertDialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$1(EditText editText, EditText editText2, int i, String str, String str2) {
                VoterFormsFragment.this.alertDialog.dismiss();
                System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                if (i == 401 || i == 400) {
                    VoterFormsFragment.this.commonUtilClass.showMessageOK(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$2$$ExternalSyntheticLambda2
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                        }
                    });
                    return;
                }
                VoterFormsFragment.this.token = "Bearer " + str;
                Toast.makeText(VoterFormsFragment.this.requireContext(), "Token Refreshed", 1).show();
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setRefreshToken(str2);
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setToken("Bearer " + str);
                VoterFormsFragment.this.showDialog("Page refreshed due to the token expiry, Please try again");
                editText.setText("");
                editText2.setText("");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setLocaleBool(false);
                VoterFormsFragment.this.startActivity(new Intent((Context) VoterFormsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$3(EditText editText, EditText editText2, int i, String str, String str2) {
                VoterFormsFragment.this.alertDialog.dismiss();
                System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                if (i == 401 || i == 400) {
                    VoterFormsFragment.this.commonUtilClass.showMessageOK(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$2$$ExternalSyntheticLambda3
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$2(dialogInterface, i2);
                        }
                    });
                    return;
                }
                VoterFormsFragment.this.token = "Bearer " + str;
                Toast.makeText(VoterFormsFragment.this.requireContext(), "Token Refreshed", 1).show();
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setRefreshToken(str2);
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setToken("Bearer " + str);
                VoterFormsFragment.this.showDialog("Page refreshed due to the token expiry, Please try again");
                editText.setText("");
                editText2.setText("");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setLocaleBool(false);
                VoterFormsFragment.this.startActivity(new Intent((Context) VoterFormsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
            }

            public void onFailure(Call<JsonArray> call, Throwable t) {
                VoterFormsFragment.this.showDialog("Other Name: " + VoterFormsFragment.this.pleaseTryAgain);
                AnonymousClass3.this.val$firstNameEd.setText("");
                AnonymousClass3.this.val$lastNameEd.setText("");
                VoterFormsFragment.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$3, reason: invalid class name and collision with other inner class name */
        class C00543 implements Callback<JSONArray> {
            final /* synthetic */ JsonArray val$payloadnamesSelf;

            C00543(final JsonArray val$payloadnamesSelf) {
                this.val$payloadnamesSelf = val$payloadnamesSelf;
            }

            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                if (response.body() != null) {
                    VoterFormsFragment.this.request = "objection";
                    VoterFormsFragment.this.epicNumber = AnonymousClass3.this.val$epicEd.getText().toString().toUpperCase();
                    VoterFormsFragment.this.firstname = VoterFormsFragment.capitailizeWord(AnonymousClass3.this.val$firstNameEd.getText().toString().toLowerCase());
                    VoterFormsFragment.this.lastname = VoterFormsFragment.capitailizeWord(AnonymousClass3.this.val$lastNameEd.getText().toString().toLowerCase());
                    Logger.d(VoterFormsFragment.this.requestTypeStringForm7, VoterFormsFragment.this.request);
                    Logger.d("First Name: ", VoterFormsFragment.this.firstname);
                    Logger.d("Last Name: ", VoterFormsFragment.this.lastname);
                    Intent intent = new Intent((Context) VoterFormsFragment.this.requireActivity(), (Class<?>) DeletionObjectionTabLayoutActivity.class);
                    intent.putExtra(VoterFormsFragment.this.requestStringForm7, VoterFormsFragment.this.request);
                    intent.putExtra(VoterFormsFragment.this.voterIdStringForm7, VoterFormsFragment.this.epicNumber);
                    intent.putExtra(VoterFormsFragment.this.voterId2StringForm7, VoterFormsFragment.this.epicNumber2);
                    intent.putExtra(VoterFormsFragment.this.firstnamefromdbStringForm7, VoterFormsFragment.this.firstname);
                    intent.putExtra(VoterFormsFragment.this.lastnamefromdbStringForm7, VoterFormsFragment.this.lastname);
                    intent.putExtra("applicantEpicDetailsArray", this.val$payloadnamesSelf.toString());
                    intent.putExtra("objecteeEpicDetailsArray", ((JSONArray) response.body()).toString());
                    VoterFormsFragment.this.startActivity(intent);
                    AnonymousClass3.this.val$dialog.dismiss();
                    VoterFormsFragment.this.alertDialog.dismiss();
                    return;
                }
                try {
                    if (response.code() == 401) {
                        CommomUtility commomUtility = VoterFormsFragment.this.commonUtilClass;
                        Context contextRequireContext = VoterFormsFragment.this.requireContext();
                        String str = VoterFormsFragment.this.refreshToken;
                        final EditText editText = AnonymousClass3.this.val$epicEd;
                        commomUtility.getRefreshToken(contextRequireContext, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$3$$ExternalSyntheticLambda1
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i, String str2, String str3) {
                                this.f$0.lambda$onResponse$1(editText, i, str2, str3);
                            }
                        });
                    } else {
                        String strOptString = new JSONObject(response.errorBody().string()).optString(VoterFormsFragment.this.messageText);
                        Logger.d("", strOptString);
                        VoterFormsFragment.this.alertDialog.dismiss();
                        VoterFormsFragment.this.showDialog("Objection: " + strOptString);
                    }
                } catch (IOException | JSONException e) {
                    Logger.d("form 7 objection case error: ", e.getMessage());
                    VoterFormsFragment.this.alertDialog.dismiss();
                    if (response.code() == 401) {
                        CommomUtility commomUtility2 = VoterFormsFragment.this.commonUtilClass;
                        Context contextRequireContext2 = VoterFormsFragment.this.requireContext();
                        String str2 = VoterFormsFragment.this.refreshToken;
                        final EditText editText2 = AnonymousClass3.this.val$firstNameEd;
                        final EditText editText3 = AnonymousClass3.this.val$lastNameEd;
                        commomUtility2.getRefreshToken(contextRequireContext2, str2, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$3$$ExternalSyntheticLambda2
                            @Override // in.gov.eci.bloapp.aadharcallback
                            public final void onCallBack(int i, String str3, String str4) {
                                this.f$0.lambda$onResponse$3(editText2, editText3, i, str3, str4);
                            }
                        });
                    } else if (response.message() != null) {
                        VoterFormsFragment.this.showDialog(response.message());
                    } else {
                        VoterFormsFragment.this.alertDialog.dismiss();
                        VoterFormsFragment.this.showDialog("No record found with name: " + VoterFormsFragment.this.firstname + StringUtils.SPACE + VoterFormsFragment.this.lastname);
                    }
                }
                AnonymousClass3.this.val$firstNameEd.setText("");
                AnonymousClass3.this.val$lastNameEd.setText("");
                VoterFormsFragment.this.alertDialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$1(EditText editText, int i, String str, String str2) {
                VoterFormsFragment.this.alertDialog.dismiss();
                System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                if (i == 401 || i == 400) {
                    VoterFormsFragment.this.commonUtilClass.showMessageOK(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$3$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                        }
                    });
                    return;
                }
                VoterFormsFragment.this.token = "Bearer " + str;
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setRefreshToken(str2);
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setToken("Bearer " + str);
                VoterFormsFragment.this.showDialog("Page refreshed due to the token expiry, Please try again");
                editText.setText("");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setLocaleBool(false);
                VoterFormsFragment.this.startActivity(new Intent((Context) VoterFormsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$3(EditText editText, EditText editText2, int i, String str, String str2) {
                VoterFormsFragment.this.alertDialog.dismiss();
                System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                if (i == 401 || i == 400) {
                    VoterFormsFragment.this.commonUtilClass.showMessageOK(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$3$$ExternalSyntheticLambda3
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$2(dialogInterface, i2);
                        }
                    });
                    return;
                }
                VoterFormsFragment.this.token = "Bearer " + str;
                Toast.makeText(VoterFormsFragment.this.requireContext(), "Token Refreshed", 1).show();
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setRefreshToken(str2);
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setToken("Bearer " + str);
                VoterFormsFragment.this.showDialog("Page refreshed due to the token expiry, Please try again");
                editText.setText("");
                editText2.setText("");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setLocaleBool(false);
                VoterFormsFragment.this.startActivity(new Intent((Context) VoterFormsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
            }

            public void onFailure(Call<JSONArray> call, Throwable t) {
                VoterFormsFragment.this.showDialog("Objection: " + VoterFormsFragment.this.pleaseTryAgain);
                AnonymousClass3.this.val$firstNameEd.setText("");
                AnonymousClass3.this.val$lastNameEd.setText("");
                VoterFormsFragment.this.alertDialog.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(EditText editText, int i, String str, String str2) {
            VoterFormsFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                VoterFormsFragment.this.commonUtilClass.showMessageOK(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            VoterFormsFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setToken("Bearer " + str);
            VoterFormsFragment.this.showDialog("Page refreshed due to the token expiry, Please try again");
            editText.setText("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setLocaleBool(false);
            VoterFormsFragment.this.startActivity(new Intent((Context) VoterFormsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(EditText editText, int i, String str, String str2) {
            VoterFormsFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                VoterFormsFragment.this.commonUtilClass.showMessageOK(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$3$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$2(dialogInterface, i2);
                    }
                });
                return;
            }
            VoterFormsFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setToken("Bearer " + str);
            VoterFormsFragment.this.showDialog("Page refreshed due to the token expiry, Please try again");
            editText.setText("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setLocaleBool(false);
            VoterFormsFragment.this.startActivity(new Intent((Context) VoterFormsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            VoterFormsFragment.this.showDialog("Applicant Epic: Please try again later");
            this.val$epicEd.setText("");
            VoterFormsFragment.this.alertDialog.dismiss();
        }
    }

    private void showAadhaarDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        final BloBottomsheetaadharBinding bloBottomsheetaadharBindingInflate = BloBottomsheetaadharBinding.inflate(getLayoutInflater());
        bloBottomsheetaadharBindingInflate.epicNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20), new InputFilter.AllCaps()});
        dialog.setContentView((View) bloBottomsheetaadharBindingInflate.getRoot());
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
        bloBottomsheetaadharBindingInflate.btnForm6b.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showAadhaarDialog$8(bloBottomsheetaadharBindingInflate, dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAadhaarDialog$8(BloBottomsheetaadharBinding bloBottomsheetaadharBinding, Dialog dialog, View view) {
        this.epicIdForForm6B = bloBottomsheetaadharBinding.epicNumber.getText().toString();
        if (bloBottomsheetaadharBinding.epicNumber.getText().toString().isEmpty()) {
            showDialog(this.enterEpicNumber);
            return;
        }
        if (!bloBottomsheetaadharBinding.epicNumber.getText().toString().isEmpty() && !bloBottomsheetaadharBinding.epicNumber.getText().toString().matches(RegexMatcher.FAMILY_EPIC_REGEX)) {
            showDialog(this.enterCorrectEpicNumber);
        } else {
            if (AadhaarAuthenticationFormFragment.isNetworkAvailable(requireContext())) {
                this.alertDialog.show();
                getEpic();
                dialog.dismiss();
                return;
            }
            Toast.makeText(requireContext(), "Please check network", 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getEpic() {
        Dialog dialog = new Dialog(getContext());
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getAadhaarLink(this.epicIdForForm6B, this.token, this.currentRole, this.bloStateCode, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP").enqueue(new AnonymousClass4(dialog));
        dialog.show();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        final /* synthetic */ Dialog val$dialog;

        AnonymousClass4(final Dialog val$dialog) {
            this.val$dialog = val$dialog;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                VoterFormsFragment.this.payLoad = (JsonObject) response.body();
                Logger.d(VoterFormsFragment.this.logTag, "Response message" + VoterFormsFragment.this.payLoad.get(VoterFormsFragment.this.messageText));
                String strSubstring = String.valueOf(VoterFormsFragment.this.payLoad.get(VoterFormsFragment.this.messageText)).substring(1, String.valueOf(VoterFormsFragment.this.payLoad.get(VoterFormsFragment.this.messageText)).length() - 1);
                Logger.d(VoterFormsFragment.this.logTag, "Response message2 " + strSubstring);
                if (strSubstring.equals("There is no Adhar provided for the Entered Epic")) {
                    HashMap map = new HashMap();
                    map.put(VoterFormsFragment.this.epicNumberStringForm7, VoterFormsFragment.this.epicIdForForm6B);
                    VoterFormsFragment.this.validateForm6B = false;
                    VoterFormsFragment.this.commonUtilClass.getRetrofitClient(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.token, VoterFormsFragment.this.atkband, VoterFormsFragment.this.rtkband).getByEpicForForm(VoterFormsFragment.this.token, SharedPref.getInstance(VoterFormsFragment.this.getContext()).getAtknBnd(), SharedPref.getInstance(VoterFormsFragment.this.getContext()).getRtknBnd(), "BLOAPP", VoterFormsFragment.this.currentRole, "ANDROIDMOB", map).enqueue(new AnonymousClass1());
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$4$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$0();
                        }
                    }, 1000L);
                    this.val$dialog.dismiss();
                } else if (strSubstring.equals("EPIC Number already Linked. Please try again with differnt EPIC")) {
                    VoterFormsFragment.this.showDialog("EPIC Number already Linked. Please try again with different EPIC");
                } else {
                    VoterFormsFragment.this.showDialog(strSubstring);
                }
            } else if (response.code() == 401 || response.code() == 400) {
                VoterFormsFragment.this.commonUtilClass.getRefreshToken(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$4$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$2(i, str, str2);
                    }
                });
            } else {
                VoterFormsFragment.this.showDialog("No data Found");
                this.val$dialog.dismiss();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$4$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$3();
                }
            }, 1000L);
            this.val$dialog.dismiss();
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$4$1, reason: invalid class name */
        class AnonymousClass1 implements Callback<JsonArray> {
            AnonymousClass1() {
            }

            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.isSuccessful() && ((JsonArray) response.body()).size() > 0) {
                    JsonArray jsonArray = (JsonArray) response.body();
                    Logger.d(VoterFormsFragment.this.logTag, "getEpic : getByEpicForForm : payloadData : " + jsonArray);
                    for (int i = 0; i < jsonArray.size(); i++) {
                        VoterFormsFragment.this.payloadContent = jsonArray.get(i).get(VoterFormsFragment.this.contentText);
                        Logger.d(VoterFormsFragment.this.logTag, "getEpic : getByEpicForForm : payloadContent : " + VoterFormsFragment.this.payloadContent);
                        String strTrim = String.valueOf(VoterFormsFragment.this.payloadContent.get(VoterFormsFragment.this.acNumberText)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                        String strTrim2 = String.valueOf(VoterFormsFragment.this.payloadContent.get(VoterFormsFragment.this.partNumberStringForm7)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                        if (VoterFormsFragment.this.asmblyNO.equals(strTrim) && VoterFormsFragment.this.partNo.equals(strTrim2)) {
                            VoterFormsFragment.this.validateForm6B = true;
                            VoterFormsFragment.this.stateNameForForm6B = VoterFormsFragment.this.payloadContent.get("stateName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                            VoterFormsFragment.this.districtNameForForm6B = VoterFormsFragment.this.payloadContent.get("districtValue").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                            VoterFormsFragment.this.acNameForForm6B = VoterFormsFragment.this.payloadContent.get("asmblyName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                            VoterFormsFragment.this.assemblyNoForForm6B = VoterFormsFragment.this.payloadContent.get(VoterFormsFragment.this.acNumberText).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                            VoterFormsFragment.this.firstNameForForm6B = VoterFormsFragment.this.payloadContent.get("applicantFirstName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                            VoterFormsFragment.this.lastNameForForm6B = VoterFormsFragment.this.payloadContent.get("applicantLastName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                            VoterFormsFragment.this.epicIdForForm6B = VoterFormsFragment.this.payloadContent.get("epicNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                            VoterFormsFragment.this.mobileNoForForm6B = VoterFormsFragment.this.payloadContent.get("mobileNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                            VoterFormsFragment.this.emailIdForForm6B = VoterFormsFragment.this.payloadContent.get(Constants.EMAIL_ID).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                            VoterFormsFragment.this.stateCdForForm6B = VoterFormsFragment.this.payloadContent.get("stateCd").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                            Logger.d(VoterFormsFragment.this.logTag, "getEpic ----> stateNameForForm6B : " + VoterFormsFragment.this.stateNameForForm6B);
                            Logger.d(VoterFormsFragment.this.logTag, "getEpic ----> districtNameForForm6B : " + VoterFormsFragment.this.districtNameForForm6B);
                            Logger.d(VoterFormsFragment.this.logTag, "getEpic ----> acNameForForm6B : " + VoterFormsFragment.this.acNameForForm6B);
                            Logger.d(VoterFormsFragment.this.logTag, "getEpic ----> assemblyNoForForm6B : " + VoterFormsFragment.this.assemblyNoForForm6B);
                            Logger.d(VoterFormsFragment.this.logTag, "getEpic ----> firstNameForForm6B : " + VoterFormsFragment.this.firstNameForForm6B);
                            Logger.d(VoterFormsFragment.this.logTag, "getEpic ----> lastNameForForm6B : " + VoterFormsFragment.this.lastNameForForm6B);
                            Logger.d(VoterFormsFragment.this.logTag, "getEpic ----> epicIdForForm6B : " + VoterFormsFragment.this.epicIdForForm6B);
                            Logger.d(VoterFormsFragment.this.logTag, "getEpic ----> mobileNoForForm6B : " + VoterFormsFragment.this.mobileNoForForm6B);
                            Logger.d(VoterFormsFragment.this.logTag, "getEpic ----> emailIdForForm6B : " + VoterFormsFragment.this.emailIdForForm6B);
                            Logger.d(VoterFormsFragment.this.logTag, "getEpic ----> stateCdForForm6B : " + VoterFormsFragment.this.stateCdForForm6B);
                            Logger.d(VoterFormsFragment.this.logTag, "getEpic ----> acNumberOther : " + strTrim);
                            Logger.d(VoterFormsFragment.this.logTag, "getEpic ----> asmblyNO : " + VoterFormsFragment.this.asmblyNO);
                            Logger.d(VoterFormsFragment.this.logTag, "getEpic ----> partNoOther : " + strTrim2);
                            Logger.d(VoterFormsFragment.this.logTag, "getEpic ----> partNo : " + VoterFormsFragment.this.partNo);
                        }
                    }
                    if (VoterFormsFragment.this.validateForm6B) {
                        VoterFormsFragment.this.openFragment3(new AadhaarAuthenticationFormFragment(), "Aadhaar Authentication");
                        AnonymousClass4.this.val$dialog.dismiss();
                        return;
                    }
                    return;
                }
                if (response.code() == 401 || response.code() == 400) {
                    VoterFormsFragment.this.commonUtilClass.getRefreshToken(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$4$1$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str, String str2) {
                            this.f$0.lambda$onResponse$1(i2, str, str2);
                        }
                    });
                    return;
                }
                try {
                    String strOptString = new JSONObject(response.errorBody().string()).optString(VoterFormsFragment.this.messageText);
                    Logger.d(VoterFormsFragment.this.logTag, strOptString);
                    AnonymousClass4.this.val$dialog.dismiss();
                    VoterFormsFragment.this.showDialog(strOptString);
                } catch (Exception e) {
                    Logger.d(VoterFormsFragment.this.logTag, e.getMessage());
                    AnonymousClass4.this.val$dialog.dismiss();
                    if (response != null && response.code() != 200 && response.message() != null) {
                        VoterFormsFragment.this.showDialog(response.message());
                    } else {
                        VoterFormsFragment.this.showDialog(VoterFormsFragment.this.noRecordFoundWithEpic + VoterFormsFragment.this.epicIdForForm6B);
                    }
                }
                AnonymousClass4.this.val$dialog.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
                Logger.d(VoterFormsFragment.this.logTag, VoterFormsFragment.this.getRefreshTokenText + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
                if (i == 401 || i == 400) {
                    VoterFormsFragment.this.commonUtilClass.showMessageOK(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$4$1$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                        }
                    });
                    return;
                }
                VoterFormsFragment.this.token = VoterFormsFragment.this.bearerText + str;
                VoterFormsFragment.this.refreshToken = str2;
                SharedPref.getInstance(VoterFormsFragment.this.getContext()).setRefreshToken(str2);
                SharedPref.getInstance(VoterFormsFragment.this.getContext()).setToken(VoterFormsFragment.this.bearerText + str);
                VoterFormsFragment.this.getEpic();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(VoterFormsFragment.this.getContext()).setIsLoggedIn(false);
                SharedPref.getInstance(VoterFormsFragment.this.getContext()).setLocaleBool(false);
                VoterFormsFragment.this.startActivity(new Intent(VoterFormsFragment.this.getContext(), (Class<?>) LoginActivity.class));
            }

            public void onFailure(Call<JsonArray> call, Throwable t) {
                if (VoterFormsFragment.this.epicIdForForm6B.isEmpty()) {
                    VoterFormsFragment.this.showDialog(VoterFormsFragment.this.enterEpicNumber);
                } else {
                    VoterFormsFragment.this.showDialog(VoterFormsFragment.this.enterCorrectEpicNumber);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            VoterFormsFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(int i, String str, String str2) {
            Logger.d(VoterFormsFragment.this.logTag, VoterFormsFragment.this.getRefreshTokenText + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                VoterFormsFragment.this.commonUtilClass.showMessageOK(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$4$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
                return;
            }
            VoterFormsFragment.this.token = VoterFormsFragment.this.bearerText + str;
            VoterFormsFragment.this.refreshToken = str2;
            SharedPref.getInstance(VoterFormsFragment.this.getContext()).setRefreshToken(str2);
            SharedPref.getInstance(VoterFormsFragment.this.getContext()).setToken(VoterFormsFragment.this.bearerText + str);
            VoterFormsFragment.this.getEpic();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(VoterFormsFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(VoterFormsFragment.this.getContext()).setLocaleBool(false);
            VoterFormsFragment.this.startActivity(new Intent(VoterFormsFragment.this.getContext(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3() {
            VoterFormsFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (VoterFormsFragment.this.epicIdForForm6B.isEmpty()) {
                VoterFormsFragment voterFormsFragment = VoterFormsFragment.this;
                voterFormsFragment.showDialog(voterFormsFragment.enterEpicNumber);
            } else {
                VoterFormsFragment voterFormsFragment2 = VoterFormsFragment.this;
                voterFormsFragment2.showDialog(voterFormsFragment2.enterCorrectEpicNumber);
            }
            this.val$dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda25
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    private void initCLickListener() {
        if (!TextUtils.isEmpty(this.flag) && this.flag.equalsIgnoreCase("dseVerified")) {
            showDeletionDialog();
        }
        if (!TextUtils.isEmpty(this.flag) && this.flag.equalsIgnoreCase("PseVerified")) {
            showDeletionDialog();
        }
        if (!TextUtils.isEmpty(this.flag) && this.flag.equalsIgnoreCase("selectPhoto")) {
            showMigrationDialog();
        }
        if (!TextUtils.isEmpty(this.flag) && this.flag.equalsIgnoreCase("newvoter")) {
            showMigrationDialog();
        }
        this.binding.constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$10(view);
            }
        });
        this.binding.correction.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$11(view);
            }
        });
        this.binding.deletionLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$12(view);
            }
        });
        this.binding.aadhaarAuthLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$13(view);
            }
        });
        this.binding.newVoterRegistrationLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$15(view);
            }
        });
        this.binding.formOverseasLayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$16(view);
            }
        });
        this.binding.backBtnIv.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$initCLickListener$17(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$10(View view) {
        openFragment(new FormsInDraft(), "Forms in draft");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$11(View view) {
        showMigrationDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$12(View view) {
        this.selectedRequestType = "Deletion Objection";
        showDeletionDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$13(View view) {
        this.selectedRequestType = "Aadhaar Authentication";
        showAadhaarDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$15(View view) {
        this.alertDialog.show();
        this.sectionNolist.clear();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initCLickListener$14();
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$14() {
        showAlertDialogButtonClicked();
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$16(View view) {
        showOverseasAlertDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initCLickListener$17(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        startActivity(new Intent(getContext(), (Class<?>) MainActivity.class));
        return true;
    }

    private void openFragmentNew(Fragment fragment, String selectedFragment) {
        Bundle bundle = new Bundle();
        bundle.putString(this.sectionNoText, this.selectedSection);
        bundle.putString("form", this.voterFormsText);
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public SpannableStringBuilder mandatorymarker(String simple) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (simple.endsWith("*")) {
            simple = simple.substring(0, simple.length() - 1);
        }
        spannableStringBuilder.append((CharSequence) simple);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) " *");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), length, spannableStringBuilder.length(), spanExclusiveExclusive);
        return spannableStringBuilder;
    }

    private void openFragment2(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment3(Fragment fragment, String selectedFragment) {
        Logger.d(this.logTag, "openFragment3 : voterIdNumberOpen" + this.epicIdForForm6B);
        Bundle bundle = new Bundle();
        bundle.putString(this.voterIdText, this.epicIdForForm6B);
        bundle.putString(this.formText, this.voterFormsText);
        bundle.putString("stateNameForForm6B", this.stateNameForForm6B);
        bundle.putString("districtNameForForm6B", this.districtNameForForm6B);
        bundle.putString("acNameForForm6B", this.acNameForForm6B);
        bundle.putString("assemblyNoForForm6B", this.assemblyNoForForm6B);
        bundle.putString("firstNameForForm6B", this.firstNameForForm6B);
        bundle.putString("lastNameForForm6B", this.lastNameForForm6B);
        bundle.putString("mobileNoForForm6B", this.mobileNoForForm6B);
        bundle.putString("emailIdForForm6B", this.emailIdForForm6B);
        bundle.putString("stateCdForForm6B", this.stateCdForForm6B);
        Logger.d(this.logTag, "openFragment3 Bundle : " + bundle);
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    private void showMigrationDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        final BloBottomSheetMigrationBinding bloBottomSheetMigrationBindingInflate = BloBottomSheetMigrationBinding.inflate(getLayoutInflater());
        bloBottomSheetMigrationBindingInflate.epicNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20), new InputFilter.AllCaps()});
        bloBottomSheetMigrationBindingInflate.epicNumber1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20), new InputFilter.AllCaps()});
        dialog.setContentView((View) bloBottomSheetMigrationBindingInflate.getRoot());
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        bloBottomSheetMigrationBindingInflate.sameotherepiclayout.setVisibility(0);
        bloBottomSheetMigrationBindingInflate.SameEpic.setEnabled(false);
        bloBottomSheetMigrationBindingInflate.otherEpic.setEnabled(false);
        bloBottomSheetMigrationBindingInflate.epicNumber1.setEnabled(false);
        bloBottomSheetMigrationBindingInflate.btnProceed.setEnabled(false);
        if (!TextUtils.isEmpty(this.flag) && this.flag.equalsIgnoreCase("selectPhoto")) {
            bloBottomSheetMigrationBindingInflate.epicNumber.setText(this.epicNumberId);
            bloBottomSheetMigrationBindingInflate.epicNumber1.setText(this.epicNumberId);
            bloBottomSheetMigrationBindingInflate.epicNumber.setEnabled(false);
            bloBottomSheetMigrationBindingInflate.epicNumber1.setEnabled(false);
            bloBottomSheetMigrationBindingInflate.SameEpic.setChecked(true);
            bloBottomSheetMigrationBindingInflate.otherEpic.setChecked(false);
            bloBottomSheetMigrationBindingInflate.btnProceed.setEnabled(true);
            this.appfor = "self";
        }
        if (!TextUtils.isEmpty(this.flag) && this.flag.equalsIgnoreCase("newvoter")) {
            bloBottomSheetMigrationBindingInflate.epicNumber.setText(this.epicNumberId);
            bloBottomSheetMigrationBindingInflate.epicNumber1.setText(this.epicNumberId);
            bloBottomSheetMigrationBindingInflate.epicNumber.setEnabled(false);
            bloBottomSheetMigrationBindingInflate.epicNumber1.setEnabled(false);
            bloBottomSheetMigrationBindingInflate.SameEpic.setChecked(true);
            bloBottomSheetMigrationBindingInflate.otherEpic.setChecked(false);
            bloBottomSheetMigrationBindingInflate.btnProceed.setEnabled(true);
            this.appfor = "self";
        }
        dialog.getWindow().setGravity(80);
        bloBottomSheetMigrationBindingInflate.epicNumber.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Logger.d(VoterFormsFragment.this.logTag, "beforeTextChanged");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Logger.d(VoterFormsFragment.this.logTag, "onTextChanged");
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable == bloBottomSheetMigrationBindingInflate.epicNumber.getEditableText()) {
                    if (!bloBottomSheetMigrationBindingInflate.epicNumber.getText().toString().isEmpty()) {
                        bloBottomSheetMigrationBindingInflate.SameEpic.setEnabled(true);
                        bloBottomSheetMigrationBindingInflate.otherEpic.setEnabled(true);
                        return;
                    }
                    bloBottomSheetMigrationBindingInflate.SameEpic.setChecked(false);
                    bloBottomSheetMigrationBindingInflate.otherEpic.setChecked(false);
                    bloBottomSheetMigrationBindingInflate.SameEpic.setEnabled(false);
                    bloBottomSheetMigrationBindingInflate.otherEpic.setEnabled(false);
                    bloBottomSheetMigrationBindingInflate.epicNumber1.setEnabled(false);
                    bloBottomSheetMigrationBindingInflate.btnProceed.setEnabled(false);
                }
            }
        });
        bloBottomSheetMigrationBindingInflate.Epictype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda22
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$showMigrationDialog$18(bloBottomSheetMigrationBindingInflate, radioGroup, i);
            }
        });
        bloBottomSheetMigrationBindingInflate.epicNumber1.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Logger.d(VoterFormsFragment.this.logTag, "beforeTextChanged");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Logger.d(VoterFormsFragment.this.logTag, "onTextChanged");
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable == bloBottomSheetMigrationBindingInflate.epicNumber1.getEditableText()) {
                    bloBottomSheetMigrationBindingInflate.btnProceed.setEnabled(!bloBottomSheetMigrationBindingInflate.epicNumber1.getText().toString().isEmpty());
                }
            }
        });
        bloBottomSheetMigrationBindingInflate.btnProceed.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showMigrationDialog$19(bloBottomSheetMigrationBindingInflate, dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMigrationDialog$18(BloBottomSheetMigrationBinding bloBottomSheetMigrationBinding, RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = bloBottomSheetMigrationBinding.Epictype.getCheckedRadioButtonId();
        if (checkedRadioButtonId == 2131362032) {
            bloBottomSheetMigrationBinding.epicNumber1.setEnabled(true);
            bloBottomSheetMigrationBinding.epicNumber1.setText(bloBottomSheetMigrationBinding.epicNumber.getText().toString());
            bloBottomSheetMigrationBinding.btnProceed.setEnabled(true);
            this.appfor = "self";
            return;
        }
        if (checkedRadioButtonId != 2131365129) {
            return;
        }
        bloBottomSheetMigrationBinding.epicNumber1.setEnabled(true);
        bloBottomSheetMigrationBinding.btnProceed.setEnabled(false);
        bloBottomSheetMigrationBinding.epicNumber1.setText("");
        this.appfor = "other";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMigrationDialog$19(BloBottomSheetMigrationBinding bloBottomSheetMigrationBinding, Dialog dialog, View view) {
        if (bloBottomSheetMigrationBinding.epicNumber.getText().toString().matches(RegexMatcher.FAMILY_EPIC_REGEX) && bloBottomSheetMigrationBinding.epicNumber1.getText().toString().matches(RegexMatcher.FAMILY_EPIC_REGEX)) {
            if (!bloBottomSheetMigrationBinding.epicNumber.getText().toString().equals(bloBottomSheetMigrationBinding.epicNumber1.getText().toString())) {
                this.alertDialog.show();
                getdetailsofInitialEpic(bloBottomSheetMigrationBinding.epicNumber.getText().toString(), bloBottomSheetMigrationBinding.epicNumber1.getText().toString());
                if (this.error.equals("part") || this.error.equals("Assembly") || this.error.equals("state")) {
                    bloBottomSheetMigrationBinding.btnProceed.setEnabled(false);
                    bloBottomSheetMigrationBinding.epicNumber1.setText("");
                }
                dialog.dismiss();
                return;
            }
            if (this.appfor.equals("self")) {
                this.alertDialog.show();
                getdetailsofProceedingEpicSame(bloBottomSheetMigrationBinding.epicNumber1.getText().toString());
                dialog.dismiss();
                return;
            }
            showDialog("Enter Different Proceeding EPIC Number");
            return;
        }
        showDialog("Enter Correct Proceeding EPIC Number");
        bloBottomSheetMigrationBinding.epicNumber.setText("");
        bloBottomSheetMigrationBinding.epicNumber1.setText("");
    }

    private void getdetailsofInitialEpic(final String initialEpic, final String procEpic) {
        this.commonUtilClass.getdetailsofEpicforForm(getContext(), this.token, this.atkband, this.rtkband, initialEpic, new MyCallbackjsonTest() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda24
            @Override // in.gov.eci.bloapp.MyCallbackjsonTest
            public final void onCallbacktest(int i, JsonArray jsonArray) {
                this.f$0.lambda$getdetailsofInitialEpic$22(procEpic, initialEpic, i, jsonArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofInitialEpic$22(final String str, final String str2, int i, JsonArray jsonArray) {
        if (i != 200) {
            if (i == 401) {
                this.commonUtilClass.getRefreshToken(getContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda7
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$getdetailsofInitialEpic$21(str2, str, i2, str3, str4);
                    }
                });
                return;
            } else {
                this.alertDialog.dismiss();
                showDialog(this.noRecordFoundWithEpic + str2);
                return;
            }
        }
        if (jsonArray != null) {
            this.epicDetailsArray = jsonArray;
            this.alertDialog.dismiss();
            this.bundle2.putString("epicDetails", this.epicDetailsArray.toString());
            this.bundle2.putString("appfor", this.appfor);
            getdetailsofProceedingEpic(str);
            return;
        }
        this.alertDialog.dismiss();
        showDialog(this.noRecordFoundWithEpic + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofInitialEpic$21(String str, String str2, int i, String str3, String str4) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str3 + StringUtils.SPACE + str4);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(requireContext(), this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getdetailsofInitialEpic$20(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str3;
        SharedPref.getInstance(requireContext()).setRefreshToken(str4);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str3);
        getdetailsofInitialEpic(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofInitialEpic$20(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    private void getdetailsofProceedingEpic(final String proceedingEpic) {
        this.commonUtilClass.getdetailsofEpicforForm(getContext(), this.token, this.atkband, this.rtkband, proceedingEpic, new MyCallbackjsonTest() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda11
            @Override // in.gov.eci.bloapp.MyCallbackjsonTest
            public final void onCallbacktest(int i, JsonArray jsonArray) {
                this.f$0.lambda$getdetailsofProceedingEpic$25(proceedingEpic, i, jsonArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofProceedingEpic$25(final String str, int i, JsonArray jsonArray) {
        if (i != 200) {
            if (i == 401) {
                this.commonUtilClass.getRefreshToken(getContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda6
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$getdetailsofProceedingEpic$24(str, i2, str2, str3);
                    }
                });
                return;
            } else {
                this.alertDialog.dismiss();
                showDialog(this.noRecordFoundWithEpic + str);
                return;
            }
        }
        if (jsonArray != null) {
            this.proceedingEpicDetailsArray = jsonArray;
            this.alertDialog.dismiss();
            this.bundle2.putString("epicProceedingDetails", this.proceedingEpicDetailsArray.toString());
            this.bundle2.putString("FlagKey", "0");
            openFragment5(new SelectApplicantObjecteeFragment(), "selectApplicantFragment");
            return;
        }
        this.alertDialog.dismiss();
        showDialog(this.noRecordFoundWithEpic + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofProceedingEpic$24(String str, int i, String str2, String str3) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(requireContext(), this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getdetailsofProceedingEpic$23(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str3);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        getdetailsofProceedingEpic(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofProceedingEpic$23(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    private void openFragment5(Fragment fragment, String selectedFragment) {
        fragment.setArguments(this.bundle2);
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    private void getdetailsofProceedingEpicSame(final String proceedingEpic) {
        this.epicmap.put("epic", proceedingEpic);
        this.commonUtilClass.getdetailsofEpicforForm(getContext(), this.token, this.atkband, this.rtkband, proceedingEpic, new MyCallbackjsonTest() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda5
            @Override // in.gov.eci.bloapp.MyCallbackjsonTest
            public final void onCallbacktest(int i, JsonArray jsonArray) {
                this.f$0.lambda$getdetailsofProceedingEpicSame$28(proceedingEpic, i, jsonArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofProceedingEpicSame$28(final String str, int i, JsonArray jsonArray) {
        if (i != 200) {
            if (i == 401) {
                this.commonUtilClass.getRefreshToken(getContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda19
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$getdetailsofProceedingEpicSame$27(str, i2, str2, str3);
                    }
                });
                return;
            } else {
                this.alertDialog.dismiss();
                showDialog(this.noRecordFoundWithEpic + str);
                return;
            }
        }
        if (jsonArray != null) {
            this.epicDetailsArray = jsonArray;
            this.alertDialog.dismiss();
            this.bundle2.putString("epicDetails", this.epicDetailsArray.toString());
            this.bundle2.putString("appfor", this.appfor);
            this.bundle2.putString("FlagKey", "0");
            if (!TextUtils.isEmpty(this.flag) && this.flag.equalsIgnoreCase("selectPhoto")) {
                this.bundle2.putString("epic", this.epicNumberId);
                this.bundle2.putString("epicId", this.epicId);
                this.bundle2.putString("efPhoto", this.efPhotoFile);
                this.bundle2.putString("efbase64image", this.efbase64image);
                this.bundle2.putString("category", this.category);
                this.bundle2.putString("flag", this.flag);
            }
            if (!TextUtils.isEmpty(this.flag) && this.flag.equalsIgnoreCase("newvoter")) {
                this.bundle2.putString("epic", this.epicNumberId);
                this.bundle2.putString("epicId", this.epicId);
                this.bundle2.putString("category", this.category);
                this.bundle2.putString("flag", this.flag);
            }
            openFragment5(new SelectApplicantFragment(), "selectApplicantFragment");
            return;
        }
        this.alertDialog.dismiss();
        showDialog(this.noRecordFoundWithEpic + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofProceedingEpicSame$27(String str, int i, String str2, String str3) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(requireContext(), this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$$ExternalSyntheticLambda21
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getdetailsofProceedingEpicSame$26(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str3);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        System.out.println("kjbsf");
        getdetailsofProceedingEpicSame(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofProceedingEpicSame$26(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    public void getSection(String stateCode, String Token, String asmblyNo, String partNo) {
        try {
            this.sectionNolist.clear();
            ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getSection("ANDROIDMOB", Token, this.atkband, this.rtkband, "BLOAPP", this.currentRole, stateCode, "application/json", asmblyNo, partNo).enqueue(new AnonymousClass7(stateCode, asmblyNo, partNo));
        } catch (Exception e) {
            Logger.d(this.contentText, e.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<JSONArray> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$partNo;
        final /* synthetic */ String val$stateCode;

        AnonymousClass7(final String val$stateCode, final String val$asmblyNo, final String val$partNo) {
            this.val$stateCode = val$stateCode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partNo = val$partNo;
        }

        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            if (response.code() == 200) {
                JSONArray jSONArray = (JSONArray) response.body();
                SharedPref.getInstance(VoterFormsFragment.this.getContext()).setSectionData(jSONArray.toString());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.size(); i++) {
                    JsonObject asJsonObject = VoterFormsFragment.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                    if (asJsonObject.get(VoterFormsFragment.this.sectionNameText) == null) {
                        VoterFormsFragment.this.sectionNumber = asJsonObject.get(VoterFormsFragment.this.sectionNoText).getAsInt() + " - ";
                    } else {
                        VoterFormsFragment.this.sectionNumber = asJsonObject.get(VoterFormsFragment.this.sectionNoText).getAsInt() + " - " + asJsonObject.get(VoterFormsFragment.this.sectionNameText).getAsString();
                    }
                    arrayList.add(VoterFormsFragment.this.sectionNumber);
                }
                Collections.sort(arrayList, new Comparator() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$7$$ExternalSyntheticLambda1
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return VoterFormsFragment.AnonymousClass7.lambda$onResponse$0((String) obj, (String) obj2);
                    }
                });
                VoterFormsFragment.this.sectionNolist.addAll(arrayList);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                SharedPref.getInstance(VoterFormsFragment.this.getContext()).setSectionData("");
                String strOptString = jSONObject.optString(VoterFormsFragment.this.messageText);
                VoterFormsFragment voterFormsFragment = VoterFormsFragment.this;
                voterFormsFragment.refreshToken = SharedPref.getInstance(voterFormsFragment.requireContext()).getRefreshToken();
                Logger.d("", "Form_6_FVR_FORM_SUBMITTION_Error" + strOptString);
                if (response.code() == 401) {
                    VoterFormsFragment.this.commonUtilClass.getRefreshToken(VoterFormsFragment.this.requireContext(), VoterFormsFragment.this.refreshToken, new AnonymousClass1(response));
                } else {
                    VoterFormsFragment.this.commonUtilClass.showMessageWithTitleOK(VoterFormsFragment.this.requireContext(), VoterFormsFragment.this.sectionErrorText + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$7$$ExternalSyntheticLambda2
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.dismiss();
                        }
                    });
                }
            } catch (IOException | JSONException e) {
                SharedPref.getInstance(VoterFormsFragment.this.getContext()).setSectionData("");
                if (response.code() == 401) {
                    VoterFormsFragment.this.commonUtilClass.getRefreshToken(VoterFormsFragment.this.requireContext(), VoterFormsFragment.this.refreshToken, new AnonymousClass2(response));
                } else {
                    VoterFormsFragment.this.commonUtilClass.showMessageWithTitleOK(VoterFormsFragment.this.requireContext(), VoterFormsFragment.this.sectionErrorText + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$7$$ExternalSyntheticLambda3
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.dismiss();
                        }
                    });
                }
                Logger.d("", e.getMessage());
            }
        }

        static /* synthetic */ int lambda$onResponse$0(String str, String str2) {
            return Integer.parseInt(str.split("-")[0].trim()) - Integer.parseInt(str2.split("-")[0].trim());
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$7$1, reason: invalid class name */
        class AnonymousClass1 implements aadharcallback {
            final /* synthetic */ Response val$response;

            AnonymousClass1(final Response val$response) {
                this.val$response = val$response;
            }

            @Override // in.gov.eci.bloapp.aadharcallback
            public void onCallBack(int code, String status, String message) {
                if (code == 401) {
                    VoterFormsFragment.this.commonUtilClass.showMessageOK(VoterFormsFragment.this.getContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$7$1$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onCallBack$0(dialogInterface, i);
                        }
                    });
                    return;
                }
                if (code == 200) {
                    VoterFormsFragment.this.token = "Bearer " + status;
                    VoterFormsFragment.this.refreshToken = message;
                    SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setToken("Bearer " + status);
                    SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setRefreshToken(message);
                    VoterFormsFragment.this.getSection(AnonymousClass7.this.val$stateCode, "Bearer " + status, AnonymousClass7.this.val$asmblyNo, AnonymousClass7.this.val$partNo);
                    return;
                }
                VoterFormsFragment.this.commonUtilClass.showMessageWithTitleOK(VoterFormsFragment.this.requireContext(), VoterFormsFragment.this.sectionErrorText + this.val$response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$7$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onCallBack$0(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setLocaleBool(false);
                VoterFormsFragment.this.startActivity(new Intent((Context) VoterFormsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
            }
        }

        /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$7$2, reason: invalid class name */
        class AnonymousClass2 implements aadharcallback {
            final /* synthetic */ Response val$response;

            AnonymousClass2(final Response val$response) {
                this.val$response = val$response;
            }

            @Override // in.gov.eci.bloapp.aadharcallback
            public void onCallBack(int code, String status, String message) {
                if (code == 401) {
                    VoterFormsFragment.this.commonUtilClass.showMessageOK(VoterFormsFragment.this.getContext(), "Session token expired please Login", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$7$2$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onCallBack$0(dialogInterface, i);
                        }
                    });
                    return;
                }
                if (code == 200) {
                    VoterFormsFragment.this.token = "Bearer " + status;
                    VoterFormsFragment.this.refreshToken = message;
                    SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setToken("Bearer " + status);
                    SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setRefreshToken(message);
                    VoterFormsFragment.this.getSection(AnonymousClass7.this.val$stateCode, "Bearer " + status, AnonymousClass7.this.val$asmblyNo, AnonymousClass7.this.val$partNo);
                    return;
                }
                VoterFormsFragment.this.commonUtilClass.showMessageWithTitleOK(VoterFormsFragment.this.requireContext(), VoterFormsFragment.this.sectionErrorText + this.val$response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$7$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onCallBack$0(DialogInterface dialogInterface, int i) {
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setIsLoggedIn(false);
                SharedPref.getInstance(VoterFormsFragment.this.requireContext()).setLocaleBool(false);
                VoterFormsFragment.this.startActivity(new Intent((Context) VoterFormsFragment.this.getActivity(), (Class<?>) LoginActivity.class));
            }
        }

        public void onFailure(Call<JSONArray> call, Throwable t) {
            SharedPref.getInstance(VoterFormsFragment.this.getContext()).setSectionData("");
            Logger.d("", "coming in onFailure " + t.getMessage());
            VoterFormsFragment.this.commonUtilClass.showMessageWithTitleOK(VoterFormsFragment.this.requireContext(), VoterFormsFragment.this.sectionErrorText, "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$7$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRelationTypeDropdown() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", "master");
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient2(getContext()).create(UserClient.class)).getRelationDropdownSIR(map).enqueue(new AnonymousClass8());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<JsonObject> {
        AnonymousClass8() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (VoterFormsFragment.this.alertDialog != null) {
                    VoterFormsFragment.this.alertDialog.dismiss();
                }
                JsonObject jsonObject = (JsonObject) response.body();
                if (jsonObject != null) {
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("payload");
                    VoterFormsFragment.this.relationNameSpinnerVal.clear();
                    VoterFormsFragment.this.relationCodeSpinnerVal.clear();
                    VoterFormsFragment.this.relationNameSpinnerVal.add(VoterFormsFragment.this.selectRelationType);
                    VoterFormsFragment.this.relationCodeSpinnerVal.add("");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = VoterFormsFragment.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        VoterFormsFragment.this.relationNameSpinnerVal.add(String.valueOf(asJsonObject.get("relationName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        VoterFormsFragment.this.relationCodeSpinnerVal.add(String.valueOf(asJsonObject.get("relationCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    }
                    SharedPref.getInstance(VoterFormsFragment.this.getContext()).saveRelativeListName(VoterFormsFragment.this.relationNameSpinnerVal, Constants.RELATIVE_LIST_NAME);
                    SharedPref.getInstance(VoterFormsFragment.this.getContext()).saveRelativeListCode(VoterFormsFragment.this.relationCodeSpinnerVal, Constants.RELATIVE_LIST_CODE);
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                if (VoterFormsFragment.this.alertDialog != null) {
                    VoterFormsFragment.this.alertDialog.dismiss();
                }
                try {
                    VoterFormsFragment.this.commomUtility.getRefreshToken(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$8$$ExternalSyntheticLambda0
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
                if (VoterFormsFragment.this.alertDialog != null) {
                    VoterFormsFragment.this.alertDialog.dismiss();
                }
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                String strOptString = jSONObject.optString("message");
                Logger.e("", jSONObject.optString("message"));
                VoterFormsFragment.this.utils.infoDialog(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.getResources().getString(R.string.alertMsg), strOptString);
            } catch (IOException | JSONException e2) {
                if (VoterFormsFragment.this.alertDialog != null) {
                    VoterFormsFragment.this.alertDialog.dismiss();
                }
                VoterFormsFragment.this.utils.infoDialog(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.getResources().getString(R.string.alertMsg), VoterFormsFragment.this.getResources().getString(R.string.something_went_wrong));
                Logger.e("", e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            VoterFormsFragment.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                VoterFormsFragment.this.commomUtility.showMessageOK(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment$8$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            VoterFormsFragment.this.token = "Bearer " + str;
            SharedPref.getInstance(VoterFormsFragment.this.getContext()).setRefreshToken(str2);
            SharedPref.getInstance(VoterFormsFragment.this.getContext()).setToken("Bearer " + str);
            VoterFormsFragment.this.getRelationTypeDropdown();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(VoterFormsFragment.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(VoterFormsFragment.this.getContext()).setLocaleBool(false);
            VoterFormsFragment.this.startActivity(new Intent(VoterFormsFragment.this.getContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (VoterFormsFragment.this.alertDialog != null) {
                VoterFormsFragment.this.alertDialog.dismiss();
            }
            VoterFormsFragment.this.utils.infoDialog(VoterFormsFragment.this.getContext(), VoterFormsFragment.this.getResources().getString(R.string.alertMsg), VoterFormsFragment.this.getResources().getString(R.string.something_went_wrong));
            Logger.d("", "OnFailure" + t.getMessage());
        }
    }
}
