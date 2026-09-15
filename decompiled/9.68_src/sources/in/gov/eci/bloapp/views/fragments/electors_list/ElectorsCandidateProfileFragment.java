package in.gov.eci.bloapp.views.fragments.electors_list;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloBottomsheetaadharBinding;
import in.gov.eci.bloapp.databinding.BloFragmentElectorsCanditateProfileBinding;
import in.gov.eci.bloapp.model.electors_list.ElectorsListModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class ElectorsCandidateProfileFragment extends BaseFragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String ALERT = "Alert";
    private static final String TAG = "ElectorsCandidateProfileFragment";
    String aadhaarStatus;
    String acNameForForm6B;
    String acNo;
    String acNumberText;
    AlertDialog alertDialog;
    String applicantName;
    String assemblyNoForForm6B;
    BloFragmentElectorsCanditateProfileBinding binding;
    Bitmap bitmapPersonImage;
    Retrofit.Builder builder;
    String channelidobo;
    CommomUtility commomUtility;
    String contentText;
    String currentRole;
    String dataMissmatchText;
    String districtNameForForm6B;
    String emailIdForForm6B;
    String enterCorrectEpicNumber;
    String enterEpicNumber;
    String epicIdForForm6B;
    String epicNo;
    String epicNumber;
    String epicNumberStringForm7;
    String father;
    String firstNameForForm6B;
    String formText;
    String genderFemale;
    String genderMale;
    String genderThirdGender;
    String husband;
    String lastNameForForm6B;
    String logTag;
    String messageAlert;
    String messageText;
    String mobileNoForForm6B;
    String mobileNumber;
    String mother;
    String newMmobileNumber;
    String noRecordFound;
    String noRecordFoundWithEpic;
    String other;
    String partNumber;
    String partNumberStringForm7;
    JsonObject payLoad;
    JsonObject payloadContent;
    String photograph;
    String refreshToken;
    Retrofit retrofit;
    String sessionTokenExpiredPleaseLogin;
    String state;
    String stateCdForForm6B;
    String stateNameForForm6B;
    String token;
    boolean validateForm6B;
    String voterIdText;
    String wife;
    CommomUtility commonUtilClass = new CommomUtility();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();

    public ElectorsCandidateProfileFragment() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commonUtilClass.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.payLoad = null;
        this.epicNo = "";
        this.epicNumber = "";
        this.applicantName = "";
        this.token = "";
        this.currentRole = "";
        this.state = "";
        this.acNo = "";
        this.partNumber = "";
        this.genderMale = "Male";
        this.genderFemale = "Female";
        this.genderThirdGender = "ThirdGender";
        this.mobileNumber = "";
        this.channelidobo = "BLOAPP";
        this.validateForm6B = false;
        this.commomUtility = new CommomUtility();
        this.newMmobileNumber = "";
        this.aadhaarStatus = "N";
        this.photograph = "";
        this.sessionTokenExpiredPleaseLogin = "Session token expired please Login";
        this.refreshToken = "";
        this.messageAlert = "message";
        this.noRecordFound = "No Record Found";
        this.father = "Father";
        this.mother = "Mother";
        this.wife = "Wife";
        this.husband = "Husband";
        this.other = "Other";
        this.voterIdText = "voterId";
        this.formText = "form";
        this.logTag = "VoterFormsFragment";
        this.contentText = "content";
        this.acNumberText = "acNumber";
        this.messageText = "message";
        this.enterEpicNumber = "Enter EPIC Number";
        this.enterCorrectEpicNumber = "Enter Correct EPIC Number";
        this.epicNumberStringForm7 = "epicNumber";
        this.partNumberStringForm7 = "partNumber";
        this.noRecordFoundWithEpic = "No Record Found with epic number: ";
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
        this.dataMissmatchText = "Data Missmatched from usertoken";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.aadhaarStatus = "";
        this.binding = BloFragmentElectorsCanditateProfileBinding.inflate(getLayoutInflater());
        Bundle arguments = getArguments();
        this.epicNo = arguments.getString("epicNo");
        this.applicantName = arguments.getString("applicantName");
        this.aadhaarStatus = arguments.getString("aadhaar_Status");
        Log.d(TAG, "aadhaar_Status --> " + this.aadhaarStatus);
        if (this.aadhaarStatus.equalsIgnoreCase("Y")) {
            this.binding.cardView.setVisibility(8);
        } else {
            this.binding.cardView.setVisibility(0);
        }
        this.binding.buttonFillForm6B.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding.candidateName.setText(this.applicantName);
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.currentRole = "blo";
        this.state = SharedPref.getInstance(requireContext()).getStateCode();
        this.acNo = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        Log.d(TAG, "token ---> " + this.token);
        Log.d(TAG, "currentRole ---> " + this.currentRole);
        Log.d(TAG, "state ---> " + this.state);
        Log.d(TAG, "acNo ---> " + this.acNo);
        Log.d(TAG, "partNumber ---> " + this.partNumber);
        Log.d(TAG, "epicNo ---> " + this.epicNo);
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment.1
            public void handleOnBackPressed() {
                Log.d(ElectorsCandidateProfileFragment.TAG, "Back Button Pressed");
            }
        });
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.binding.homeButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        this.alertDialog.show();
        HashMap map = new HashMap();
        map.put("state", this.state);
        map.put("acNo", this.acNo);
        map.put("partNo", this.partNumber);
        map.put("epicNo", this.epicNo);
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("Authorization", this.token);
        map2.put("currentRole", this.currentRole);
        map2.put("state", this.state);
        map2.put("atkn_bnd", SharedPref.getInstance(requireContext()).getAtknBnd());
        map2.put("rtkn_bnd", SharedPref.getInstance(requireContext()).getRtknBnd());
        map2.put("channelidobo", "BLOAPP");
        map2.put("PLATFORM-TYPE", "ANDROIDMOB");
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getEpicDetails(map2, map).enqueue(new AnonymousClass2());
        this.binding.personImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$4(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        showAadhaarDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        openFragment(new ElectorsListFragment());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<ElectorsListModel.getEpicDetails.Root> {
        AnonymousClass2() {
        }

        public void onResponse(Call<ElectorsListModel.getEpicDetails.Root> call, Response<ElectorsListModel.getEpicDetails.Root> response) {
            if (response.code() != 200) {
                if (response.code() == 401) {
                    ElectorsCandidateProfileFragment.this.refreshApiTokenApi();
                    return;
                }
                try {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$2$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$0();
                        }
                    }, 2000L);
                    ElectorsCandidateProfileFragment.this.commomUtility.showMessageWithTitleOK(ElectorsCandidateProfileFragment.this.requireContext(), "Get Candidate EpicList Api Error - " + response.code(), new JSONObject(response.errorBody().string()).optString(ElectorsCandidateProfileFragment.this.messageAlert), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$2$$ExternalSyntheticLambda3
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$1(dialogInterface, i);
                        }
                    });
                    Log.d(ElectorsCandidateProfileFragment.TAG, ElectorsCandidateProfileFragment.this.noRecordFound);
                    return;
                } catch (IOException | JSONException e) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$2$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    }, 2000L);
                    ElectorsCandidateProfileFragment.this.commomUtility.showMessageWithTitleOK(ElectorsCandidateProfileFragment.this.requireContext(), "Get Candidate EpicList Error Cath - " + response.code(), e.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$2$$ExternalSyntheticLambda5
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$3(dialogInterface, i);
                        }
                    });
                    Log.d(ElectorsCandidateProfileFragment.TAG, ElectorsCandidateProfileFragment.this.noRecordFound);
                    return;
                }
            }
            ElectorsCandidateProfileFragment.this.binding.applicantName.setText(((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getApplicantName());
            ElectorsCandidateProfileFragment.this.binding.applicantNameL1.setText(((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getApplicantNameL1());
            ElectorsCandidateProfileFragment.this.binding.epicNumber.setText(ElectorsCandidateProfileFragment.this.epicNo);
            if (((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getGender().trim().equalsIgnoreCase("M")) {
                ElectorsCandidateProfileFragment.this.binding.gender.setText(ElectorsCandidateProfileFragment.this.genderMale);
            } else if (((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getGender().trim().equalsIgnoreCase("F")) {
                ElectorsCandidateProfileFragment.this.binding.gender.setText(ElectorsCandidateProfileFragment.this.genderFemale);
            } else if (((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getGender().trim().equalsIgnoreCase("T")) {
                ElectorsCandidateProfileFragment.this.binding.gender.setText(ElectorsCandidateProfileFragment.this.genderThirdGender);
            }
            ElectorsCandidateProfileFragment.this.binding.age.setText(((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getAge());
            ElectorsCandidateProfileFragment.this.binding.relativeName.setText(((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getRelationName());
            ElectorsCandidateProfileFragment.this.binding.relativeNameL1.setText(((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getRelationNameL1());
            if (((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getRelationType().equalsIgnoreCase("F") || ((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getRelationType().equalsIgnoreCase("FTHR")) {
                ElectorsCandidateProfileFragment.this.binding.relationtype.setText(ElectorsCandidateProfileFragment.this.father);
            } else if (((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getRelationType().equalsIgnoreCase("M") || ((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getRelationType().equalsIgnoreCase("MTHR")) {
                ElectorsCandidateProfileFragment.this.binding.relationtype.setText(ElectorsCandidateProfileFragment.this.mother);
            } else if (((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getRelationType().equalsIgnoreCase("H") || ((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getRelationType().equalsIgnoreCase("HSBN")) {
                ElectorsCandidateProfileFragment.this.binding.relationtype.setText(ElectorsCandidateProfileFragment.this.husband);
            } else if (((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getRelationType().equalsIgnoreCase("W") || ((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getRelationType().equalsIgnoreCase("WIFE")) {
                ElectorsCandidateProfileFragment.this.binding.relationtype.setText(ElectorsCandidateProfileFragment.this.wife);
            } else if (((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getRelationType().equalsIgnoreCase("O") || ((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getRelationType().equalsIgnoreCase("OTHR")) {
                ElectorsCandidateProfileFragment.this.binding.relationtype.setText(ElectorsCandidateProfileFragment.this.other);
            }
            if (((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getMobile().trim().length() >= 10) {
                if (((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getMobile().trim().startsWith("+91-")) {
                    ElectorsCandidateProfileFragment.this.mobileNumber = ((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getMobile().trim().substring(4);
                    ElectorsCandidateProfileFragment.this.newMmobileNumber = ElectorsCandidateProfileFragment.this.mobileNumber.substring(0, 3) + StringUtils.SPACE + ElectorsCandidateProfileFragment.this.mobileNumber.substring(3, 6) + StringUtils.SPACE + ElectorsCandidateProfileFragment.this.mobileNumber.substring(6, 10);
                } else if (((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getMobile().trim().startsWith("+91")) {
                    ElectorsCandidateProfileFragment.this.mobileNumber = ((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getMobile().trim().substring(3);
                    ElectorsCandidateProfileFragment.this.newMmobileNumber = ElectorsCandidateProfileFragment.this.mobileNumber.substring(0, 3) + StringUtils.SPACE + ElectorsCandidateProfileFragment.this.mobileNumber.substring(3, 6) + StringUtils.SPACE + ElectorsCandidateProfileFragment.this.mobileNumber.substring(6, 10);
                } else {
                    ElectorsCandidateProfileFragment.this.newMmobileNumber = ((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getMobile().trim().substring(0, 3) + StringUtils.SPACE + ((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getMobile().trim().substring(3, 6) + StringUtils.SPACE + ((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getMobile().trim().substring(6, 10);
                }
            }
            ElectorsCandidateProfileFragment.this.binding.mobileNumber.setText(ElectorsCandidateProfileFragment.this.newMmobileNumber);
            ElectorsCandidateProfileFragment.this.binding.address.setText(((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getAddress().trim());
            ElectorsCandidateProfileFragment.this.binding.addressL1.setText(((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getAddressL1().trim());
            ElectorsCandidateProfileFragment.this.binding.assemblyConstituency.setText(((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getAssemblyName().trim());
            ElectorsCandidateProfileFragment.this.binding.districtName.setText(((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getDistrictName().trim());
            ElectorsCandidateProfileFragment.this.binding.state.setText(((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getStateName().trim());
            ElectorsCandidateProfileFragment.this.binding.partNumber.setText(((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getPartNo().trim());
            ElectorsCandidateProfileFragment.this.binding.serialNumber.setText(String.valueOf(((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getSerialNo()));
            ElectorsCandidateProfileFragment.this.binding.sectionNo.setText(((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getSectionNo());
            ElectorsCandidateProfileFragment.this.photograph = ((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getPhoto().trim();
            ElectorsCandidateProfileFragment.this.getPersonImageUploadedfilePersonalDetials(((ElectorsListModel.getEpicDetails.Root) response.body()).getPayload().get(0).getPhoto().trim());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            ElectorsCandidateProfileFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            ElectorsCandidateProfileFragment.this.openFragment(new ElectorsListFragment());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            ElectorsCandidateProfileFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(DialogInterface dialogInterface, int i) {
            ElectorsCandidateProfileFragment.this.openFragment(new ElectorsListFragment());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$4(DialogInterface dialogInterface, int i) {
            ElectorsCandidateProfileFragment.this.openFragment(new ElectorsListFragment());
        }

        public void onFailure(Call<ElectorsListModel.getEpicDetails.Root> call, Throwable t) {
            ElectorsCandidateProfileFragment.this.commomUtility.showMessageWithTitleOK(ElectorsCandidateProfileFragment.this.requireContext(), "Get Epic Details On Failure", t.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$2$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onFailure$4(dialogInterface, i);
                }
            });
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$2$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$5();
                }
            }, 2000L);
            Log.d(ElectorsCandidateProfileFragment.TAG, ElectorsCandidateProfileFragment.this.noRecordFound);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$5() {
            ElectorsCandidateProfileFragment.this.alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(View view) {
        this.alertDialog.show();
        if (this.photograph.length() > 0) {
            showPersonImageDialog(this.bitmapPersonImage);
        } else {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), "Status", "No document attached");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreateView$3();
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshApiTokenApi() {
        this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$$ExternalSyntheticLambda9
            @Override // in.gov.eci.bloapp.aadharcallback
            public final void onCallBack(int i, String str, String str2) {
                this.f$0.lambda$refreshApiTokenApi$7(i, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshApiTokenApi$7(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$refreshApiTokenApi$5(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commomUtility.showMessageWithTitleOK(requireContext(), "Alert", "Page refreshed due to the token expiry", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$refreshApiTokenApi$6(dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshApiTokenApi$5(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshApiTokenApi$6(DialogInterface dialogInterface, int i) {
        openFragment(new ElectorsListFragment());
    }

    private void getEpic() {
        Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        HashMap map = new HashMap();
        map.put("Authorization", this.token);
        map.put("CurrentRole", this.currentRole);
        map.put("state", this.state);
        map.put("atkn_bnd", SharedPref.getInstance(requireContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(requireContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getAadhaarLink(this.epicIdForForm6B, this.token, this.currentRole, this.state, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd(), "BLOAPP").enqueue(new AnonymousClass3(dialog));
        dialog.show();
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        final /* synthetic */ Dialog val$dialog;

        AnonymousClass3(final Dialog val$dialog) {
            this.val$dialog = val$dialog;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                ElectorsCandidateProfileFragment.this.payLoad = (JsonObject) response.body();
                Logger.d(ElectorsCandidateProfileFragment.this.logTag, "Response message" + ElectorsCandidateProfileFragment.this.payLoad.get(ElectorsCandidateProfileFragment.this.messageText));
                String strSubstring = String.valueOf(ElectorsCandidateProfileFragment.this.payLoad.get(ElectorsCandidateProfileFragment.this.messageText)).substring(1, String.valueOf(ElectorsCandidateProfileFragment.this.payLoad.get(ElectorsCandidateProfileFragment.this.messageText)).length() - 1);
                Logger.d(ElectorsCandidateProfileFragment.this.logTag, "Response message2 " + strSubstring);
                if (strSubstring.equals("There is no Adhar provided for the Entered Epic")) {
                    HashMap map = new HashMap();
                    map.put(ElectorsCandidateProfileFragment.this.epicNumberStringForm7, ElectorsCandidateProfileFragment.this.epicNumber);
                    ElectorsCandidateProfileFragment.this.validateForm6B = false;
                    ElectorsCandidateProfileFragment.this.commonUtilClass.getRetrofitClient(ElectorsCandidateProfileFragment.this.getContext(), ElectorsCandidateProfileFragment.this.token, SharedPref.getInstance(ElectorsCandidateProfileFragment.this.requireContext()).getAtknBnd(), SharedPref.getInstance(ElectorsCandidateProfileFragment.this.requireContext()).getRtknBnd()).getByEpicForForm(ElectorsCandidateProfileFragment.this.token, SharedPref.getInstance(ElectorsCandidateProfileFragment.this.getContext()).getAtknBnd(), SharedPref.getInstance(ElectorsCandidateProfileFragment.this.getContext()).getRtknBnd(), "BLOAPP", ElectorsCandidateProfileFragment.this.currentRole, "ANDROIDMOB", map).enqueue(new Callback<JsonArray>() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment.3.1
                        public void onResponse(Call<JsonArray> call2, Response<JsonArray> response2) {
                            if (response2.isSuccessful() && ((JsonArray) response2.body()).size() > 0) {
                                JsonArray jsonArray = (JsonArray) response2.body();
                                Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic : getByEpicForForm : payloadData : " + jsonArray);
                                for (int i = 0; i < jsonArray.size(); i++) {
                                    ElectorsCandidateProfileFragment.this.payloadContent = jsonArray.get(i).get(ElectorsCandidateProfileFragment.this.contentText);
                                    Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic : getByEpicForForm : payloadContent : " + ElectorsCandidateProfileFragment.this.payloadContent);
                                    String strTrim = String.valueOf(ElectorsCandidateProfileFragment.this.payloadContent.get(ElectorsCandidateProfileFragment.this.acNumberText)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                                    String strTrim2 = String.valueOf(ElectorsCandidateProfileFragment.this.payloadContent.get(ElectorsCandidateProfileFragment.this.partNumberStringForm7)).replace(RegexMatcher.JSON_STRING_REGEX, "").trim();
                                    if (ElectorsCandidateProfileFragment.this.acNo.equals(strTrim) && ElectorsCandidateProfileFragment.this.partNumber.equals(strTrim2)) {
                                        ElectorsCandidateProfileFragment.this.validateForm6B = true;
                                        ElectorsCandidateProfileFragment.this.stateNameForForm6B = ElectorsCandidateProfileFragment.this.payloadContent.get("stateName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                                        ElectorsCandidateProfileFragment.this.districtNameForForm6B = ElectorsCandidateProfileFragment.this.payloadContent.get("districtValue").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                                        ElectorsCandidateProfileFragment.this.acNameForForm6B = ElectorsCandidateProfileFragment.this.payloadContent.get("asmblyName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                                        ElectorsCandidateProfileFragment.this.assemblyNoForForm6B = ElectorsCandidateProfileFragment.this.payloadContent.get(ElectorsCandidateProfileFragment.this.acNumberText).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                                        ElectorsCandidateProfileFragment.this.firstNameForForm6B = ElectorsCandidateProfileFragment.this.payloadContent.get("applicantFirstName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                                        ElectorsCandidateProfileFragment.this.lastNameForForm6B = ElectorsCandidateProfileFragment.this.payloadContent.get("applicantLastName").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                                        ElectorsCandidateProfileFragment.this.epicIdForForm6B = ElectorsCandidateProfileFragment.this.payloadContent.get("epicNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                                        ElectorsCandidateProfileFragment.this.mobileNoForForm6B = ElectorsCandidateProfileFragment.this.payloadContent.get("mobileNumber").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                                        ElectorsCandidateProfileFragment.this.emailIdForForm6B = ElectorsCandidateProfileFragment.this.payloadContent.get(Constants.EMAIL_ID).toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                                        ElectorsCandidateProfileFragment.this.stateCdForForm6B = ElectorsCandidateProfileFragment.this.payloadContent.get("stateCd").toString().replace(RegexMatcher.JSON_STRING_REGEX, "").trim().replace("[ ]+", StringUtils.SPACE);
                                        Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic ----> stateNameForForm6B : " + ElectorsCandidateProfileFragment.this.stateNameForForm6B);
                                        Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic ----> districtNameForForm6B : " + ElectorsCandidateProfileFragment.this.districtNameForForm6B);
                                        Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic ----> acNameForForm6B : " + ElectorsCandidateProfileFragment.this.acNameForForm6B);
                                        Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic ----> assemblyNoForForm6B : " + ElectorsCandidateProfileFragment.this.assemblyNoForForm6B);
                                        Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic ----> firstNameForForm6B : " + ElectorsCandidateProfileFragment.this.firstNameForForm6B);
                                        Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic ----> lastNameForForm6B : " + ElectorsCandidateProfileFragment.this.lastNameForForm6B);
                                        Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic ----> epicIdForForm6B : " + ElectorsCandidateProfileFragment.this.epicIdForForm6B);
                                        Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic ----> mobileNoForForm6B : " + ElectorsCandidateProfileFragment.this.mobileNoForForm6B);
                                        Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic ----> emailIdForForm6B : " + ElectorsCandidateProfileFragment.this.emailIdForForm6B);
                                        Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic ----> stateCdForForm6B : " + ElectorsCandidateProfileFragment.this.stateCdForForm6B);
                                        Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic ----> acNumberOther : " + strTrim);
                                        Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic ----> asmblyNO : " + ElectorsCandidateProfileFragment.this.acNo);
                                        Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic ----> partNoOther : " + strTrim2);
                                        Logger.d(ElectorsCandidateProfileFragment.this.logTag, "getEpic ----> partNo : " + ElectorsCandidateProfileFragment.this.partNumber);
                                    }
                                }
                                if (ElectorsCandidateProfileFragment.this.validateForm6B) {
                                    ElectorsCandidateProfileFragment.this.openFragment3(new AadhaarAuthenticationFormFragment());
                                    AnonymousClass3.this.val$dialog.dismiss();
                                    return;
                                }
                                return;
                            }
                            try {
                                String strOptString = new JSONObject(response2.errorBody().string()).optString(ElectorsCandidateProfileFragment.this.messageText);
                                Logger.d(ElectorsCandidateProfileFragment.this.logTag, strOptString);
                                AnonymousClass3.this.val$dialog.dismiss();
                                ElectorsCandidateProfileFragment.this.showDialog(strOptString);
                            } catch (Exception e) {
                                Logger.d(ElectorsCandidateProfileFragment.this.logTag, e.getMessage());
                                AnonymousClass3.this.val$dialog.dismiss();
                                if (response2.code() == 401) {
                                    ElectorsCandidateProfileFragment.this.refreshApiTokenApi();
                                } else if (response2.code() != 200 && response2.message() != null) {
                                    ElectorsCandidateProfileFragment.this.showDialog(response2.message());
                                } else {
                                    ElectorsCandidateProfileFragment.this.showDialog(ElectorsCandidateProfileFragment.this.noRecordFoundWithEpic + ElectorsCandidateProfileFragment.this.epicNumber);
                                }
                            }
                            AnonymousClass3.this.val$dialog.dismiss();
                        }

                        public void onFailure(Call<JsonArray> call2, Throwable t) {
                            if (ElectorsCandidateProfileFragment.this.epicNumber.isEmpty()) {
                                ElectorsCandidateProfileFragment.this.showDialog(ElectorsCandidateProfileFragment.this.enterEpicNumber);
                            } else {
                                ElectorsCandidateProfileFragment.this.showDialog(ElectorsCandidateProfileFragment.this.enterCorrectEpicNumber);
                            }
                        }
                    });
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$3$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$0();
                        }
                    }, 1000L);
                    this.val$dialog.dismiss();
                } else if (strSubstring.equals("EPIC Number already Linked. Please try again with differnt EPIC")) {
                    ElectorsCandidateProfileFragment.this.showDialog("EPIC Number already Linked. Please try again with different EPIC");
                } else {
                    ElectorsCandidateProfileFragment.this.showDialog(strSubstring);
                }
            } else if (response.code() == 401) {
                ElectorsCandidateProfileFragment.this.refreshApiTokenApi();
            } else {
                ElectorsCandidateProfileFragment.this.showDialog("No data Found");
                this.val$dialog.dismiss();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$3$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResponse$1();
                }
            }, 1000L);
            this.val$dialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            ElectorsCandidateProfileFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            ElectorsCandidateProfileFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (ElectorsCandidateProfileFragment.this.epicNumber.isEmpty()) {
                ElectorsCandidateProfileFragment electorsCandidateProfileFragment = ElectorsCandidateProfileFragment.this;
                electorsCandidateProfileFragment.showDialog(electorsCandidateProfileFragment.enterEpicNumber);
            } else {
                ElectorsCandidateProfileFragment electorsCandidateProfileFragment2 = ElectorsCandidateProfileFragment.this;
                electorsCandidateProfileFragment2.showDialog(electorsCandidateProfileFragment2.enterCorrectEpicNumber);
            }
            this.val$dialog.dismiss();
        }
    }

    private void showAadhaarDialog() {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.requestWindowFeature(1);
        final BloBottomsheetaadharBinding bloBottomsheetaadharBindingInflate = BloBottomsheetaadharBinding.inflate(getLayoutInflater());
        bloBottomsheetaadharBindingInflate.epicNumber.setText(this.epicNo);
        bloBottomsheetaadharBindingInflate.epicNumber.setEnabled(false);
        dialog.setContentView((View) bloBottomsheetaadharBindingInflate.getRoot());
        ((Window) Objects.requireNonNull(dialog.getWindow())).setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
        bloBottomsheetaadharBindingInflate.btnForm6b.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showAadhaarDialog$10(bloBottomsheetaadharBindingInflate, dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAadhaarDialog$10(BloBottomsheetaadharBinding bloBottomsheetaadharBinding, Dialog dialog, View view) {
        this.epicNumber = this.epicNo;
        if (bloBottomsheetaadharBinding.epicNumber.getText().toString().isEmpty()) {
            showDialog(this.enterEpicNumber);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$showAadhaarDialog$8();
                }
            }, 2000L);
            return;
        }
        if (!bloBottomsheetaadharBinding.epicNumber.getText().toString().isEmpty() && !bloBottomsheetaadharBinding.epicNumber.getText().toString().matches(RegexMatcher.FAMILY_EPIC_REGEX)) {
            showDialog("Enter Correct EPIC Number");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$showAadhaarDialog$9();
                }
            }, 2000L);
        } else {
            if (isNetworkAvailable(requireContext())) {
                this.alertDialog.show();
                getEpic();
                dialog.dismiss();
                return;
            }
            Toast.makeText(requireContext(), "Please check network", 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAadhaarDialog$8() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAadhaarDialog$9() {
        this.alertDialog.dismiss();
    }

    private void showPersonImageDialog(Bitmap bitmapPersonImage) {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(getContext()));
        dialog.setContentView(R.layout.blo_person_image_dialog_layout);
        dialog.show();
        TouchImageView touchImageView = (TouchImageView) dialog.findViewById(R.id.person_image);
        ((TextView) dialog.findViewById(R.id.person_image_name)).setText(this.photograph);
        touchImageView.setImageBitmap(bitmapPersonImage);
        ((ImageView) dialog.findViewById(R.id.person_cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showPersonImageDialog$12();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPersonImageDialog$12() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.electorsListFrame, fragment, "Application Fragment");
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPersonImageUploadedfilePersonalDetials(String fileName) {
        Log.d(TAG, "getting downloaded file");
        UserClient userClient = (UserClient) ApiClient.getClient(getContext()).create(UserClient.class);
        Logger.d("Token_get_uploaded", this.token);
        String str = this.token;
        String atknBnd = SharedPref.getInstance(requireContext()).getAtknBnd();
        String rtknBnd = SharedPref.getInstance(requireContext()).getRtknBnd();
        String str2 = this.channelidobo;
        userClient.getFile("objectstorage", fileName, str, atknBnd, rtknBnd, str2, "blo", str2, "ANDROIDMOB").enqueue(new AnonymousClass4());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        AnonymousClass4() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                JsonObject jsonObject = (JsonObject) response.body();
                jsonObject.get("file");
                Log.d(ElectorsCandidateProfileFragment.TAG, "error in image" + jsonObject.get("file"));
                ElectorsCandidateProfileFragment.this.bitmapPersonImage = BitmapFactory.decodeStream(new ByteArrayInputStream(Base64.decode(String.valueOf(jsonObject.get("file")).replace(RegexMatcher.JSON_STRING_REGEX, ""), 0)));
                ElectorsCandidateProfileFragment.this.binding.personImage.setImageBitmap(ElectorsCandidateProfileFragment.this.bitmapPersonImage);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$4$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                ElectorsCandidateProfileFragment.this.binding.mainLayout.setVisibility(0);
                return;
            }
            if (response.code() == 401) {
                ElectorsCandidateProfileFragment.this.refreshApiTokenApi();
                return;
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString(ElectorsCandidateProfileFragment.this.messageAlert);
                Log.d(ElectorsCandidateProfileFragment.TAG, strOptString);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$4$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$1();
                    }
                }, 2000L);
                ElectorsCandidateProfileFragment.this.commomUtility.showMessageWithTitleOK(ElectorsCandidateProfileFragment.this.requireContext(), "Get Candidate Document Download  Api Error - " + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$4$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$2(dialogInterface, i);
                    }
                });
            } catch (IOException | JSONException e) {
                String message = e.getMessage();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$4$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$3();
                    }
                }, 2000L);
                ElectorsCandidateProfileFragment.this.commomUtility.showMessageWithTitleOK(ElectorsCandidateProfileFragment.this.requireContext(), "Get Candidate Document Download  Api catch error", message, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$4$$ExternalSyntheticLambda6
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onResponse$4(dialogInterface, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            ElectorsCandidateProfileFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1() {
            ElectorsCandidateProfileFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            ElectorsCandidateProfileFragment.this.openFragment(new ElectorsListFragment());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3() {
            ElectorsCandidateProfileFragment.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4(DialogInterface dialogInterface, int i) {
            ElectorsCandidateProfileFragment.this.openFragment(new ElectorsListFragment());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$5() {
            ElectorsCandidateProfileFragment.this.alertDialog.dismiss();
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$5();
                }
            }, 2000L);
            ElectorsCandidateProfileFragment.this.commomUtility.showMessageWithTitleOK(ElectorsCandidateProfileFragment.this.requireContext(), "Get Candidate Document Download  Api On failure ", t.getMessage(), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$4$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onFailure$6(dialogInterface, i);
                }
            });
            Log.d(ElectorsCandidateProfileFragment.TAG, "coming in onFailure " + t.getMessage());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$6(DialogInterface dialogInterface, int i) {
            ElectorsCandidateProfileFragment.this.openFragment(new ElectorsListFragment());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.electors_list.ElectorsCandidateProfileFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment3(Fragment fragment) {
        Logger.d("voterIdNumberOpen", this.epicNumber);
        Bundle bundle = new Bundle();
        bundle.putString(this.voterIdText, this.epicNumber);
        bundle.putString(this.formText, "Voter Forms");
        bundle.putString("stateNameForForm6B", this.stateNameForForm6B);
        bundle.putString("districtNameForForm6B", this.districtNameForForm6B);
        bundle.putString("acNameForForm6B", this.acNameForForm6B);
        bundle.putString("assemblyNoForForm6B", this.assemblyNoForForm6B);
        bundle.putString("firstNameForForm6B", this.firstNameForForm6B);
        bundle.putString("lastNameForForm6B", this.lastNameForForm6B);
        bundle.putString("mobileNoForForm6B", this.mobileNoForForm6B);
        bundle.putString("emailIdForForm6B", this.emailIdForForm6B);
        bundle.putString("stateCdForForm6B", this.stateCdForForm6B);
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.electorsListFrame, fragment, "Aadhaar Authentication");
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
