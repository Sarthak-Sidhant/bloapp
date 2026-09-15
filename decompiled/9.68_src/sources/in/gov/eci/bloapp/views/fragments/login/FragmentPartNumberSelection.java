package in.gov.eci.bloapp.views.fragments.login;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentPartNumberSelectionBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.VideoLanguage;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.fragments.MandatoryVideoDialogFragment;
import in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class FragmentPartNumberSelection extends Hilt_FragmentPartNumberSelection implements MandatoryVideoDialogFragment.VideoCompletionListener {
    private static final String ARG_STATE_CODE = "STATE_CODE";
    private static final String ENGLISH_VIDEO_ID = "X_ZtfhGG5fk";
    private static final String HINDI_VIDEO_ID = "ebQxP2IccrM";
    private static final String STATE_DIALOG_DISPLAYED = "mandatory_video_dialog_displayed";
    private static final String TAG = "FragmentPartNumberSelection";
    private static final Pattern VIDEO_ID_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]{6,20}$");
    private ArrayList<String> HINDI_STATE_CODES;
    ArrayAdapter<String> adapter;
    AlertDialog alertDialog;
    String asmblyNO;
    String asmblyName;
    String asmblyNameL1;
    String atkband;
    BloFragmentPartNumberSelectionBinding binding;
    String districtName;
    String districtNameL1;
    String fName;
    String lName;
    private boolean mandatoryVideoCompleted;
    String name;
    String partName;
    JSONArray payLoad;
    String rtkband;
    ArrayList<String> singleSelect;
    String stateName;
    String nothingToDo = "Nothing to do";
    String comingTag = "coming in onFailure";
    String alertText = "Alert";
    String messageString = "message";
    String token = "";
    String partLang = "";
    String langName = "";
    String partLang2 = "";
    String langName2 = "";
    String stateCode = "";
    String partNo = "";
    String totalPartNumber = "";
    String districtCode = "";
    String objectStorageString = "objectstorage";
    String sessionTokenExpiredPleaseLogin = "Session token expired please Login";
    String refreshToken = "";
    String base64element1 = "";
    String partNumberDistrictError = "Part Number District Error - ";
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commomUtility = new CommomUtility();

    private void disablePartScreenActions() {
    }

    private void enablePartScreenActions() {
    }

    @Override // in.gov.eci.bloapp.views.fragments.MandatoryVideoDialogFragment.VideoCompletionListener
    public void onMandatoryVideoFinished(String language, String videoId) {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentPartNumberSelectionBinding.inflate(getLayoutInflater());
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection.1
            public void handleOnBackPressed() {
                Log.d(FragmentPartNumberSelection.TAG, FragmentPartNumberSelection.this.nothingToDo);
            }
        });
        initCLickListener();
        this.token = SharedPref.getInstance(requireContext()).getToken();
        String stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.stateCode = stateCode;
        this.stateCode = stateCode.toUpperCase();
        this.totalPartNumber = SharedPref.getInstance(requireContext()).getTotalPartNumber();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.atkband = SharedPref.getInstance(requireContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(requireContext()).getRtknBnd();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        getBlo();
        String str = this.totalPartNumber;
        if (str == null || str.isEmpty()) {
            this.commomUtility.showMessageWithTitleOK(requireContext(), "Server Error", "BLO details are not available.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    System.exit(0);
                }
            });
        } else {
            singleSelect(this.totalPartNumber);
            Logger.d(TAG, "Token -- > " + this.token);
            Logger.d(TAG, "State Code -- > " + this.stateCode);
            Logger.d(TAG, "Total Part Number -- > " + this.totalPartNumber);
            Logger.d(TAG, "Assembly Number -- > " + this.asmblyNO);
        }
        return this.binding.getRoot();
    }

    public void getBlo() {
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getMyProfile(this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "ANDROIDMOB").enqueue(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonObject> {
        AnonymousClass2() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            System.out.println("hii i am response code " + response.code());
            if (response.code() == 200) {
                JsonObject jsonObject = (JsonObject) response.body();
                String strReplaceAll = jsonObject.get("photoUrl").toString().replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                FragmentPartNumberSelection.this.fName = jsonObject.get("userFname").toString().replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                FragmentPartNumberSelection.this.lName = jsonObject.get("userLname").toString().replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                if (FragmentPartNumberSelection.this.lName.isEmpty()) {
                    FragmentPartNumberSelection.this.lName = "";
                }
                FragmentPartNumberSelection.this.name = FragmentPartNumberSelection.this.fName + StringUtils.SPACE + FragmentPartNumberSelection.this.lName;
                FragmentPartNumberSelection.this.binding.textView19.setText("Welcome " + FragmentPartNumberSelection.this.name);
                if (!strReplaceAll.isEmpty()) {
                    FragmentPartNumberSelection.this.getFile1(strReplaceAll);
                    return;
                } else {
                    FragmentPartNumberSelection.this.binding.imageView4.setImageBitmap(BitmapFactory.decodeResource(FragmentPartNumberSelection.this.getResources(), R.drawable.blo_dummy_image));
                    return;
                }
            }
            if (response.code() == 401) {
                System.out.println("Hii i am 401");
                FragmentPartNumberSelection.this.commomUtility.getRefreshToken(FragmentPartNumberSelection.this.getContext(), FragmentPartNumberSelection.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$2$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            System.out.println("Hii i am nothng");
            try {
                FragmentPartNumberSelection.this.commomUtility.showMessageWithTitleOK(FragmentPartNumberSelection.this.requireContext(), "Section Error - " + response.code(), new JSONObject(response.errorBody().string()).optString("message"), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$2$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
            } catch (Exception e) {
                Logger.e("on Failure............", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                FragmentPartNumberSelection.this.commomUtility.showMessageOK(FragmentPartNumberSelection.this.getContext(), FragmentPartNumberSelection.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$2$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            FragmentPartNumberSelection.this.token = "Bearer " + str;
            Toast.makeText(FragmentPartNumberSelection.this.requireContext(), "Token Refreshed", 1).show();
            SharedPref.getInstance(FragmentPartNumberSelection.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(FragmentPartNumberSelection.this.requireContext()).setToken("Bearer " + str);
            FragmentPartNumberSelection.this.getBlo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FragmentPartNumberSelection.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FragmentPartNumberSelection.this.requireContext()).setLocaleBool(false);
            FragmentPartNumberSelection.this.startActivity(new Intent((Context) FragmentPartNumberSelection.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e("on Failure............", t.getMessage());
        }
    }

    public void getFile1(String fileref) {
        Logger.e(TAG, "in getFile1..............................");
        this.commomUtility.getRetrofitClient(getContext(), this.token, this.atkband, this.rtkband).getFile(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass3(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$3, reason: invalid class name */
    class AnonymousClass3 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass3(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (FragmentPartNumberSelection.this.alertDialog != null) {
                    FragmentPartNumberSelection.this.alertDialog.dismiss();
                }
                FragmentPartNumberSelection.this.base64element1 = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(FragmentPartNumberSelection.this.base64element1, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                Logger.d("Bitmap special", bitmapDecodeByteArray.toString());
                FragmentPartNumberSelection.this.binding.imageView4.setImageBitmap(bitmapDecodeByteArray);
                if (FragmentPartNumberSelection.this.base64element1.isEmpty() || FragmentPartNumberSelection.this.base64element1.equals("null")) {
                    FragmentPartNumberSelection.this.binding.imageView4.setImageBitmap(BitmapFactory.decodeResource(FragmentPartNumberSelection.this.getResources(), R.drawable.blo_dummy_image));
                    if (FragmentPartNumberSelection.this.alertDialog != null) {
                        FragmentPartNumberSelection.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = FragmentPartNumberSelection.this.commomUtility;
                    Context context = FragmentPartNumberSelection.this.getContext();
                    String str = FragmentPartNumberSelection.this.refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$3$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                    return;
                } catch (Exception unused) {
                    Logger.e(FragmentPartNumberSelection.TAG, FragmentPartNumberSelection.this.comingTag);
                    return;
                }
            }
            try {
                if (FragmentPartNumberSelection.this.alertDialog != null) {
                    FragmentPartNumberSelection.this.alertDialog.dismiss();
                }
                Logger.e(FragmentPartNumberSelection.TAG, new JSONObject(response.errorBody().string()).optString(FragmentPartNumberSelection.this.messageString));
            } catch (IOException | JSONException e) {
                if (FragmentPartNumberSelection.this.alertDialog != null) {
                    FragmentPartNumberSelection.this.alertDialog.dismiss();
                }
                Logger.e(FragmentPartNumberSelection.TAG, e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            if (FragmentPartNumberSelection.this.alertDialog != null) {
                FragmentPartNumberSelection.this.alertDialog.dismiss();
            }
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                FragmentPartNumberSelection.this.commomUtility.showMessageOK(FragmentPartNumberSelection.this.getContext(), FragmentPartNumberSelection.this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$3$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            FragmentPartNumberSelection.this.token = "Bearer " + str2;
            SharedPref.getInstance(FragmentPartNumberSelection.this.getContext()).setRefreshToken(str3);
            SharedPref.getInstance(FragmentPartNumberSelection.this.getContext()).setToken("Bearer " + str2);
            FragmentPartNumberSelection.this.getFile1(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(FragmentPartNumberSelection.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(FragmentPartNumberSelection.this.getContext()).setLocaleBool(false);
            FragmentPartNumberSelection.this.startActivity(new Intent(FragmentPartNumberSelection.this.getContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(FragmentPartNumberSelection.TAG, FragmentPartNumberSelection.this.comingTag + t.getMessage());
            if (FragmentPartNumberSelection.this.alertDialog != null) {
                FragmentPartNumberSelection.this.alertDialog.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: fetchDistrictApi, reason: merged with bridge method [inline-methods] */
    public void lambda$singleSelect$5() {
        if (isNetworkAvailable(requireContext())) {
            fetchDistrictData();
            return;
        }
        Toast.makeText(getContext(), "Please check network", 1).show();
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    private void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(getContext()).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$1(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$1(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    private void fetchDistrictData() {
        Logger.d(TAG, "State_Code " + this.stateCode);
        Logger.d(TAG, "token ---> " + this.token);
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("CurrentRole", "blo");
        map.put("state", this.stateCode);
        map.put("atkn_bnd", SharedPref.getInstance(requireContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(requireContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getDistrict1(map).enqueue(new AnonymousClass4());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<EronetResponse> {
        AnonymousClass4() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                FragmentPartNumberSelection.this.payLoad = ((EronetResponse) response.body()).getPayload();
                if (FragmentPartNumberSelection.this.payLoad != null) {
                    for (int i = 0; i < FragmentPartNumberSelection.this.payLoad.size(); i++) {
                        JsonObject asJsonObject = FragmentPartNumberSelection.this.gson.toJsonTree((LinkedTreeMap) FragmentPartNumberSelection.this.payLoad.get(i)).getAsJsonObject();
                        String strReplace = String.valueOf(asJsonObject.get("partNo")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                        String strReplace2 = String.valueOf(asJsonObject.get("stateCode")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                        String strReplace3 = String.valueOf(asJsonObject.get("asmblyNO")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                        if (strReplace.equalsIgnoreCase(FragmentPartNumberSelection.this.partNo) && strReplace2.equalsIgnoreCase(FragmentPartNumberSelection.this.stateCode) && strReplace3.equalsIgnoreCase(FragmentPartNumberSelection.this.asmblyNO)) {
                            FragmentPartNumberSelection.this.stateName = String.valueOf(asJsonObject.get("stateName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                            FragmentPartNumberSelection.this.districtName = String.valueOf(asJsonObject.get("districtName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                            FragmentPartNumberSelection.this.districtNameL1 = String.valueOf(asJsonObject.get("districtNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                            FragmentPartNumberSelection.this.asmblyName = String.valueOf(asJsonObject.get("asmblyName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                            FragmentPartNumberSelection.this.asmblyNameL1 = String.valueOf(asJsonObject.get("asmblyNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                            FragmentPartNumberSelection.this.partName = String.valueOf(asJsonObject.get("partName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                            FragmentPartNumberSelection.this.districtCode = String.valueOf(asJsonObject.get("districtCode")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                    }
                    Logger.d(FragmentPartNumberSelection.TAG, "stateName --- > " + FragmentPartNumberSelection.this.stateName);
                    Logger.d(FragmentPartNumberSelection.TAG, "districtName --- > " + FragmentPartNumberSelection.this.districtName);
                    Logger.d(FragmentPartNumberSelection.TAG, "districtNameL1 --- > " + FragmentPartNumberSelection.this.districtNameL1);
                    Logger.d(FragmentPartNumberSelection.TAG, "asmblyName --- > " + FragmentPartNumberSelection.this.asmblyName);
                    Logger.d(FragmentPartNumberSelection.TAG, "asmblyNameL1 --- > " + FragmentPartNumberSelection.this.asmblyNameL1);
                    Logger.d(FragmentPartNumberSelection.TAG, "partName --- > " + FragmentPartNumberSelection.this.partName);
                    FragmentPartNumberSelection.this.binding.textView20.setText("State : " + FragmentPartNumberSelection.this.stateName);
                    FragmentPartNumberSelection.this.binding.textView21.setText("Assembly Constituency : " + FragmentPartNumberSelection.this.asmblyName);
                    FragmentPartNumberSelection.this.binding.textView22.setText("District : " + FragmentPartNumberSelection.this.districtName);
                    FragmentPartNumberSelection.this.fetchDataFromLanguageSelectionApi();
                    return;
                }
                if (FragmentPartNumberSelection.this.alertDialog != null) {
                    FragmentPartNumberSelection.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                if (FragmentPartNumberSelection.this.alertDialog != null) {
                    FragmentPartNumberSelection.this.alertDialog.dismiss();
                }
                FragmentPartNumberSelection.this.refreshTokenApi();
                return;
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                Logger.d(FragmentPartNumberSelection.TAG, "GetDistrict1 errorResponse --> " + strOptString);
                FragmentPartNumberSelection.this.commomUtility.showMessageWithTitleOK(FragmentPartNumberSelection.this.requireContext(), FragmentPartNumberSelection.this.partNumberDistrictError + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$4$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
            } catch (IOException | JSONException e) {
                FragmentPartNumberSelection.this.commomUtility.showMessageWithTitleOK(FragmentPartNumberSelection.this.requireContext(), FragmentPartNumberSelection.this.partNumberDistrictError + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$4$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                Logger.d(FragmentPartNumberSelection.TAG, "getDistrict1 exception --> " + e.getMessage());
            }
            if (FragmentPartNumberSelection.this.alertDialog != null) {
                FragmentPartNumberSelection.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            if (FragmentPartNumberSelection.this.alertDialog != null) {
                FragmentPartNumberSelection.this.alertDialog.dismiss();
            }
            Log.d(FragmentPartNumberSelection.TAG, FragmentPartNumberSelection.this.nothingToDo);
        }
    }

    private boolean shouldPlayHindiVideo(String stateCode) {
        return this.HINDI_STATE_CODES.contains(stateCode);
    }

    private boolean isValidYouTubeVideoId(String videoId) {
        if (videoId == null) {
            return false;
        }
        String strTrim = videoId.trim();
        if (strTrim.isEmpty() || "YOUR_ENGLISH_VIDEO_ID".equals(strTrim) || "YOUR_HINDI_VIDEO_ID".equals(strTrim)) {
            return false;
        }
        return VIDEO_ID_PATTERN.matcher(strTrim).matches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchDataFromLanguageSelectionApi() {
        if (isNetworkAvailable(requireContext())) {
            fetchLanguageSelectionData();
            return;
        }
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        Toast.makeText(getContext(), "Please check network", 1).show();
    }

    private void fetchLanguageSelectionData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("CurrentRole", "blo");
        map.put("state", this.stateCode);
        map.put("atkn_bnd", SharedPref.getInstance(requireContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(requireContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getLanguageDataUrl(map).enqueue(new AnonymousClass5());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<EronetResponse> {
        AnonymousClass5() {
        }

        public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
            if (response.code() == 200) {
                if (FragmentPartNumberSelection.this.alertDialog != null) {
                    FragmentPartNumberSelection.this.alertDialog.dismiss();
                }
                FragmentPartNumberSelection.this.payLoad = ((EronetResponse) response.body()).getPayload();
                Logger.d(FragmentPartNumberSelection.TAG, "fetchLanguageSelectionData Payload ---> " + FragmentPartNumberSelection.this.payLoad);
                for (int i = 0; i < FragmentPartNumberSelection.this.payLoad.size(); i++) {
                    JsonObject asJsonObject = FragmentPartNumberSelection.this.gson.toJsonTree((LinkedTreeMap) FragmentPartNumberSelection.this.payLoad.get(i)).getAsJsonObject();
                    if (String.valueOf(asJsonObject.get("partNo")).replace(RegexMatcher.JSON_STRING_REGEX, "").equals(FragmentPartNumberSelection.this.partNo)) {
                        FragmentPartNumberSelection.this.partLang = String.valueOf(asJsonObject.get("partLang")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                        FragmentPartNumberSelection.this.langName = String.valueOf(asJsonObject.get("langName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                        if (!String.valueOf(asJsonObject.get("partLangL2")).equals("")) {
                            FragmentPartNumberSelection.this.partLang2 = String.valueOf(asJsonObject.get("partLangL2")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                        if (!String.valueOf(asJsonObject.get("langNameL2")).equals("")) {
                            FragmentPartNumberSelection.this.langName2 = String.valueOf(asJsonObject.get("langNameL2")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                        }
                    }
                }
                Logger.d(FragmentPartNumberSelection.TAG, "partLang --- > " + FragmentPartNumberSelection.this.partLang);
                Logger.d(FragmentPartNumberSelection.TAG, "langName --- > " + FragmentPartNumberSelection.this.langName);
                return;
            }
            if (response.code() == 401) {
                FragmentPartNumberSelection.this.refreshTokenApi();
                return;
            }
            try {
                String strOptString = new JSONObject(response.errorBody().string()).optString("message");
                Logger.d(FragmentPartNumberSelection.TAG, "GetLanguageDataUrl errorResponse --> " + strOptString);
                FragmentPartNumberSelection.this.commomUtility.showMessageWithTitleOK(FragmentPartNumberSelection.this.requireContext(), "Part Number Language Error - " + response.code(), strOptString, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$5$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
            } catch (IOException | JSONException e) {
                FragmentPartNumberSelection.this.commomUtility.showMessageWithTitleOK(FragmentPartNumberSelection.this.requireContext(), "Part Number Language Error - " + response.code(), "Internal Server Error, Please Try again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$5$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                Logger.d(FragmentPartNumberSelection.TAG, "getLanguageDataUrl exception --> " + e.getMessage());
            }
            if (FragmentPartNumberSelection.this.alertDialog != null) {
                FragmentPartNumberSelection.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<EronetResponse> call, Throwable t) {
            if (FragmentPartNumberSelection.this.alertDialog != null) {
                FragmentPartNumberSelection.this.alertDialog.dismiss();
            }
            FragmentPartNumberSelection.this.commomUtility.displayAlertWithTitleAndMessageAndExit(FragmentPartNumberSelection.this.requireContext(), "Internal Server Error", t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshTokenApi() {
        this.commomUtility.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$$ExternalSyntheticLambda7
            @Override // in.gov.eci.bloapp.aadharcallback
            public final void onCallBack(int i, String str, String str2) {
                this.f$0.lambda$refreshTokenApi$4(i, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$4(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(getContext(), this.sessionTokenExpiredPleaseLogin, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$refreshTokenApi$2(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commomUtility.showMessageWithTitleOK(requireContext(), "ALERT", "Page refreshed due to the token expiry", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$refreshTokenApi$3(dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$2(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshTokenApi$3(DialogInterface dialogInterface, int i) {
        openFragment(new TotalListFragment());
    }

    private void singleSelect(String totalPartNumber) {
        this.singleSelect = new ArrayList<>(Arrays.asList(totalPartNumber.replace(StringUtils.SPACE, "").split(",")));
        this.adapter = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), android.R.layout.simple_list_item_1, this.singleSelect);
        this.binding.singleSelect.setAdapter(this.adapter);
        if (this.singleSelect.size() == 1) {
            this.binding.singleSelect.setText(this.singleSelect.get(0));
            this.binding.singleSelect.setEnabled(false);
            this.partNo = this.singleSelect.get(0);
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$singleSelect$5();
                }
            }, 500L);
        }
        this.binding.singleSelect.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$$ExternalSyntheticLambda6
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$singleSelect$6(adapterView, view, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$singleSelect$6(AdapterView adapterView, View view, int i, long j) {
        this.partNo = this.adapter.getItem(i);
        Logger.d(TAG, "StateCode --> " + this.stateCode + "  PartNumberSelected --> " + this.partNo + " Assembly Number ----> " + this.asmblyNO);
        this.alertDialog.show();
        lambda$singleSelect$5();
    }

    private void initCLickListener() {
        this.binding.submit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$7(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$7(View view) {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.binding.singleSelect.getText().toString().isEmpty()) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), "Missing", "Select Part Number");
            return;
        }
        String str5 = this.stateName;
        if (str5 == null || str5.isEmpty() || (str = this.asmblyName) == null || str.isEmpty() || (str2 = this.partName) == null || str2.isEmpty() || (str3 = this.langName) == null || str3.isEmpty() || (str4 = this.partLang) == null || str4.isEmpty()) {
            this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), "Error", "Please reselect Part and then click on Submit or Retry Again.");
            return;
        }
        Logger.d(TAG, "API DataFragment Part Number");
        Logger.d(TAG, "token ---->  " + this.token);
        Logger.d(TAG, "partLang ---->  " + this.partLang);
        Logger.d(TAG, "langName ---->  " + this.langName);
        Logger.d(TAG, "stateCode ---->  " + this.stateCode);
        Logger.d(TAG, "districtCode ---->  " + this.districtCode);
        Logger.d(TAG, "asmblyNO ---->  " + this.asmblyNO);
        Logger.d(TAG, "partNo ---->  " + this.partNo);
        Logger.d(TAG, "districtName ---->  " + this.districtName);
        Logger.d(TAG, "districtNameL1 ---->  " + this.districtNameL1);
        Logger.d(TAG, "asmblyName ---->  " + this.asmblyName);
        Logger.d(TAG, "asmblyNameL1 ---->  " + this.asmblyNameL1);
        Logger.d(TAG, "totalPartNumber " + this.totalPartNumber);
        SharedPref.getInstance(requireContext()).setStateName(this.stateName);
        SharedPref.getInstance(requireContext()).setDistrictName(this.districtName);
        SharedPref.getInstance(requireContext()).setDistrictNameL1(this.districtNameL1);
        SharedPref.getInstance(requireContext()).setAssemblyName(this.asmblyName);
        SharedPref.getInstance(requireContext()).setAssemblyNameL1(this.asmblyNameL1);
        SharedPref.getInstance(requireContext()).setPartName(this.partName);
        SharedPref.getInstance(requireContext()).setPartNumber(this.partNo);
        SharedPref.getInstance(requireContext()).setLanguageName(this.langName);
        SharedPref.getInstance(requireContext()).setPartNumberLanguageName(this.partLang);
        SharedPref.getInstance(requireContext()).setLanguageName2(this.langName2);
        SharedPref.getInstance(requireContext()).setPartNumberLanguageName2(this.partLang2);
        SharedPref.getInstance(requireContext()).setDistrictCode(this.districtCode);
        SharedPref.getInstance(requireContext()).setIsOnline("Y");
        this.singleSelect.clear();
        openFragment(new FragmentDeviceCompatibility());
    }

    private void openFragment(Fragment fragment) {
        Bundle bundle = new Bundle();
        bundle.putString("from", "PartSelection");
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame, fragment, "Fragment");
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4100);
        fragmentTransactionBeginTransaction.commit();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        disablePartScreenActions();
        view.post(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.getStateCodeLanguage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMandatoryVideo() {
        String str;
        String str2;
        if (isAdded()) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            if (childFragmentManager.isStateSaved()) {
                return;
            }
            MandatoryVideoDialogFragment mandatoryVideoDialogFragmentFindFragmentByTag = childFragmentManager.findFragmentByTag(MandatoryVideoDialogFragment.TAG);
            if (mandatoryVideoDialogFragmentFindFragmentByTag instanceof MandatoryVideoDialogFragment) {
                mandatoryVideoDialogFragmentFindFragmentByTag.setVideoCompletionListener(this);
                return;
            }
            String validatedStateCode = getValidatedStateCode();
            if (validatedStateCode.isEmpty()) {
                showStateCodeError();
                return;
            }
            boolean zShouldPlayHindiVideo = shouldPlayHindiVideo(validatedStateCode);
            if (zShouldPlayHindiVideo) {
                str = HINDI_VIDEO_ID;
            } else {
                str = ENGLISH_VIDEO_ID;
            }
            if (zShouldPlayHindiVideo) {
                str2 = VideoLanguage.HINDI;
            } else {
                str2 = VideoLanguage.ENGLISH;
            }
            if (!isValidYouTubeVideoId(str)) {
                showVideoConfigurationError(str2);
                return;
            }
            MandatoryVideoDialogFragment mandatoryVideoDialogFragmentNewInstance = MandatoryVideoDialogFragment.newInstance(str, str2);
            mandatoryVideoDialogFragmentNewInstance.setVideoCompletionListener(this);
            mandatoryVideoDialogFragmentNewInstance.show(childFragmentManager, MandatoryVideoDialogFragment.TAG);
        }
    }

    private String getValidatedStateCode() {
        return this.stateCode;
    }

    private void showStateCodeError() {
        if (isAdded()) {
            Toast.makeText(requireContext(), "Valid state code is not available. Unable to select the video.", 1).show();
            disablePartScreenActions();
        }
    }

    private void showVideoConfigurationError(String language) {
        String str;
        if (isAdded()) {
            if (VideoLanguage.HINDI.equalsIgnoreCase(language)) {
                str = "वीडियो कॉन्फ़िगरेशन उपलब्ध नहीं है।";
            } else {
                str = "The video configuration is not available.";
            }
            Toast.makeText(requireContext(), str, 1).show();
            disablePartScreenActions();
        }
    }

    public boolean isMandatoryVideoCompleted() {
        return this.mandatoryVideoCompleted;
    }

    public void onDestroyView() {
        MandatoryVideoDialogFragment mandatoryVideoDialogFragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(MandatoryVideoDialogFragment.TAG);
        if (mandatoryVideoDialogFragmentFindFragmentByTag instanceof MandatoryVideoDialogFragment) {
            mandatoryVideoDialogFragmentFindFragmentByTag.setVideoCompletionListener(null);
        }
        super.onDestroyView();
    }

    @Override // in.gov.eci.bloapp.views.fragments.MandatoryVideoDialogFragment.VideoCompletionListener
    public void onMandatoryVideoClosed(String language, String videoId, boolean videoCompleted, boolean technicalFailure) {
        String str;
        String str2;
        if (isAdded()) {
            if (videoCompleted) {
                this.mandatoryVideoCompleted = true;
                enablePartScreenActions();
                if (VideoLanguage.HINDI.equalsIgnoreCase(language)) {
                    str2 = "वीडियो सफलतापूर्वक पूरा हुआ।";
                } else {
                    str2 = "Video completed successfully.";
                }
                Toast.makeText(requireContext(), str2, 0).show();
                return;
            }
            if (technicalFailure) {
                this.mandatoryVideoCompleted = false;
                enablePartScreenActions();
                if (VideoLanguage.HINDI.equalsIgnoreCase(language)) {
                    str = "तकनीकी समस्या के कारण वीडियो नहीं चल सका। आप आगे जारी रख सकते हैं।";
                } else {
                    str = "The video could not be played due to a technical issue. You may continue.";
                }
                Toast.makeText(requireContext(), str, 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStateCodeLanguage() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", "master");
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient2(getContext()).create(UserClient.class)).getStateVideoLanguage(map).enqueue(new Callback<ArrayList<String>>() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection.6
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                if (response.code() == 200) {
                    if (FragmentPartNumberSelection.this.alertDialog != null) {
                        FragmentPartNumberSelection.this.alertDialog.dismiss();
                    }
                    ArrayList arrayList = (ArrayList) response.body();
                    if (arrayList == null || arrayList.isEmpty()) {
                        return;
                    }
                    FragmentPartNumberSelection.this.HINDI_STATE_CODES = arrayList;
                    FragmentPartNumberSelection.this.showMandatoryVideo();
                    return;
                }
                if (response.code() == 401) {
                    if (FragmentPartNumberSelection.this.alertDialog != null) {
                        FragmentPartNumberSelection.this.alertDialog.dismiss();
                        return;
                    }
                    return;
                }
                try {
                    if (FragmentPartNumberSelection.this.alertDialog != null) {
                        FragmentPartNumberSelection.this.alertDialog.dismiss();
                    }
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    jSONObject.optString("message");
                    Logger.e("", jSONObject.optString("message"));
                } catch (IOException | JSONException e) {
                    if (FragmentPartNumberSelection.this.alertDialog != null) {
                        FragmentPartNumberSelection.this.alertDialog.dismiss();
                    }
                    Logger.e("", e.getMessage());
                }
            }

            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                if (FragmentPartNumberSelection.this.alertDialog != null) {
                    FragmentPartNumberSelection.this.alertDialog.dismiss();
                }
                Logger.d("", "OnFailure" + t.getMessage());
            }
        });
    }
}
