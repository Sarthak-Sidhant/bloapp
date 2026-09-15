package in.gov.eci.bloapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SSLFactoryHelper;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.ArraylistReturn1;
import in.gov.eci.bloapp.views.MyResponse;
import in.gov.eci.bloapp.views.activity.callback.FormatCDetailsCallback;
import in.gov.eci.bloapp.views.activity.callback.FormatCListCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.AnomalyListCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.DetailsOfEpicCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.EpicCallBack;
import in.gov.eci.bloapp.views.activity.newsir.callback.ErollDataCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.IAcPartListCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.PSEListCallbackNew;
import in.gov.eci.bloapp.views.activity.newsir.callback.SearchByAcPartCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.UnCollectableCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.UpdateMobileCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidateMapCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.VerifyCitizenListCallbackNew;
import in.gov.eci.bloapp.views.activity.newsir.model.CheckEpicRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.Content;
import in.gov.eci.bloapp.views.activity.newsir.model.DetailsofEpicRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.ErollDataModel;
import in.gov.eci.bloapp.views.activity.newsir.model.FormVerificationRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.FormVerifyRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.FormverificationPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.PSEPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.PSEVerifyRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.Payload;
import in.gov.eci.bloapp.views.activity.newsir.model.PayloadNewMapping;
import in.gov.eci.bloapp.views.activity.newsir.model.SearchByAcPartModel;
import in.gov.eci.bloapp.views.activity.newsir.model.UncollectableDetailsPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.UncollectedDetailsRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.UpdateMobilePayload;
import in.gov.eci.bloapp.views.activity.newsir.model.UpdateMobileRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload;
import in.gov.eci.bloapp.views.activity.newsir.model.formatc.Root;
import in.gov.eci.bloapp.views.fragments.Forms8Respponse;
import in.gov.eci.bloapp.views.fragments.FormsResponse;
import in.gov.eci.bloapp.views.fragments.JsonArrayCallback;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class CommomUtility {
    aadharcallback aadharcallback;
    private ArrayList<String> addproofcode;
    private ArrayList<String> ageroofcode;
    ArraylistReturn arraylistReturn;
    ArraylistReturn1 arraylistReturn1;
    Retrofit.Builder builder;
    String cancelText;
    String codeDescText;
    String codeText;
    public int codeform8;
    public int codeform8O;
    private ArrayList<String> constituencycode;
    private ArrayList<String> countrycode;
    String currentRole;
    public String dashFemale;
    public String dashMale;
    public String dashPwd;
    public String dashThirdGender;
    public String dashTotalElector;
    public byte[] decodedString;
    private ArrayList<String> districtcode;
    private String form6a;
    FormData formData;
    Forms8Respponse forms8Respponse;
    FormsResponse formsResponse;
    private ArrayList<String> gendercode;
    MyCallbackJson json;
    JsonArrayCallback jsonArrayCallback;
    public JsonObject jsonObject;
    MyCallbackjsonTest jsonTest;
    public JsonObject jsonobjectform6a;
    public JsonObject jsonobjectform8;
    public JsonObject jsonobjectform8O;
    String logTag;
    public String message;
    String messageText;
    MultipleString multipleString;
    MultipleStringReturn multipleStringReturn;
    MyCallback myCallback;
    MyCallbackJson myCallbackJson;
    MyResponse myResponse;
    String okText;
    String onFailureText;
    public JSONArray payLoadChekList;
    public JSONArray payLoadVerifiedList;
    String payloadText;
    public String ref_id;
    Retrofit retrofit;
    public String sectionNo;
    public String setPhotoReferenceNumber;
    String somethingWentWrong;
    private ArrayList<String> statecd;
    private ArrayList<String> statecode;
    public JsonArray submitArrayResponse;
    public JsonObject submitResponse;
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();
    public String baseurl = BuildConfig.BASE_URL;
    public String baseurl2 = BuildConfig.BASE_URL_NEW;
    public String appversion = BuildConfig.VERSION_NAME;

    public CommomUtility() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.dashMale = "0";
        this.dashFemale = "0";
        this.dashThirdGender = "0";
        this.dashTotalElector = "0";
        this.dashPwd = "0";
        this.jsonObject = new JsonObject();
        this.jsonobjectform6a = new JsonObject();
        this.jsonobjectform8 = new JsonObject();
        this.jsonobjectform8O = new JsonObject();
        this.okText = "OK";
        this.cancelText = "Cancel";
        this.currentRole = "blo";
        this.logTag = "CommomUtility";
        this.onFailureText = "On Failure";
        this.codeDescText = "codeDesc";
        this.codeText = "code";
        this.payloadText = "payload: ";
        this.messageText = "message";
        this.somethingWentWrong = Constants.somethingWentWrong;
        this.payLoadChekList = null;
        this.payLoadVerifiedList = null;
        this.submitResponse = null;
        this.submitArrayResponse = null;
    }

    public void displayAlertWithTitleAndMessage(Context ctx, String title, String message) {
        new AlertDialog.Builder(ctx).setTitle(title).setMessage(message).setCancelable(false).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.CommomUtility.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        }).setIcon(android.R.drawable.ic_dialog_alert).show();
    }

    public void showMessageOKCancel(Context ctx, String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(ctx).setMessage(message).setPositiveButton(this.okText, okListener).setNegativeButton(this.cancelText, (DialogInterface.OnClickListener) null).setIcon(android.R.drawable.ic_dialog_alert).create().show();
    }

    public void showMessageOKCancelBoth(Context ctx, String title, String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(ctx).setTitle(title).setMessage(message).setNegativeButton(R.string.blo_alert_FormData, okListener).setPositiveButton(this.cancelText, okListener).setIcon(android.R.drawable.ic_dialog_alert).create().show();
    }

    public void showMessageWithTitleOK(Context ctx, String title, String message, DialogInterface.OnClickListener okListener) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(ctx).setTitle(title).setCancelable(false).setMessage(message).setNeutralButton(this.okText, okListener).setIcon(android.R.drawable.ic_dialog_alert).create();
        alertDialogCreate.show();
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.y = 120;
            window.setAttributes(attributes);
        }
    }

    public void showMessageOK(Context ctx, String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(ctx).setMessage(message).setCancelable(false).setNeutralButton(this.okText, okListener).setIcon(android.R.drawable.ic_dialog_alert).create().show();
    }

    public void getGenderJson(String stateCode, String Token, String atkn, String rtkn, final Context context) {
        try {
            ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getGender(Token, atkn, rtkn, "BLOAPP", this.currentRole, stateCode, "ANDROIDMOB").enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.2
                public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                    if (response.code() == 200) {
                        SharedPref.getInstance(context).setGenderData(((JSONArray) response.body()).toString());
                    } else {
                        SharedPref.getInstance(context).setGenderData("");
                    }
                }

                public void onFailure(Call<JSONArray> call, Throwable t) {
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
                    SharedPref.getInstance(context).setGenderData("");
                }
            });
        } catch (Exception e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    public void getGender(String stateCode, String Token, String atkn, String rtkn, Context context, final ArraylistReturn arraylistReturn) {
        Logger.d(this.logTag, "getGender");
        final ArrayList arrayList = new ArrayList();
        this.gendercode = new ArrayList<>();
        arrayList.clear();
        this.gendercode.clear();
        arrayList.add("Select Gender");
        this.gendercode.add("O");
        try {
            this.arraylistReturn = arraylistReturn;
            ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getGender(Token, atkn, rtkn, "BLOAPP", this.currentRole, stateCode, "ANDROIDMOB").enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.3
                public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                    if (response.code() == 200) {
                        JSONArray jSONArray = (JSONArray) response.body();
                        for (int i = 0; i < jSONArray.size(); i++) {
                            JsonObject asJsonObject = CommomUtility.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                            arrayList.add(String.valueOf(asJsonObject.get(CommomUtility.this.codeDescText)).substring(1, String.valueOf(asJsonObject.get(CommomUtility.this.codeDescText)).length() - 1));
                            CommomUtility.this.gendercode.add(String.valueOf(asJsonObject.get(CommomUtility.this.codeText)).substring(1, String.valueOf(asJsonObject.get(CommomUtility.this.codeText)).length() - 1));
                            Logger.d(CommomUtility.this.logTag, (String) CommomUtility.this.gendercode.get(1));
                        }
                        arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.gendercode);
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + ((String) arrayList.get(1)));
                        return;
                    }
                    arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.gendercode);
                }

                public void onFailure(Call<JSONArray> call, Throwable t) {
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
                }
            });
        } catch (Exception e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    public void getAeroRemarks(Context context, int formProcessingDetailsId, String stateCode, String atkBand, String rtkBand, String token, String currentRole, MyResponse myCallback) {
        this.myResponse = myCallback;
        getRetrofitClient(context, token, atkBand, rtkBand).getAeroRemarks(formProcessingDetailsId, currentRole, stateCode, "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.4
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                String strReplace;
                if (response.body() != null) {
                    JsonObject jsonObject = (JsonObject) response.body();
                    try {
                        Log.d("commonutility", "jsonObject==" + String.valueOf(jsonObject));
                        JsonArray asJsonArray = jsonObject.getAsJsonArray("bloFieldVerificationList");
                        if (!asJsonArray.isEmpty()) {
                            int size = asJsonArray.size();
                            Logger.d("bloVerificationList", String.valueOf(size));
                            strReplace = asJsonArray.get(size - 1).getAsJsonObject().get("visitCount").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                            if (TextUtils.isEmpty(strReplace)) {
                                strReplace = "0";
                            }
                            Logger.d(CommomUtility.this.logTag, "s1 if" + strReplace);
                        } else {
                            Logger.d(CommomUtility.this.logTag, "s1 else0");
                            strReplace = "0";
                        }
                        JsonArray asJsonArray2 = jsonObject.getAsJsonArray("aeroAssignBloList");
                        JsonArray asJsonArray3 = jsonObject.getAsJsonArray("eroReInitiateList");
                        JsonArray jsonArray = new JsonArray();
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + asJsonArray2);
                        if (asJsonArray2 == null) {
                            asJsonArray2 = new JsonArray();
                        }
                        if (asJsonArray3 == null) {
                            asJsonArray3 = new JsonArray();
                        }
                        if (asJsonArray == null) {
                            asJsonArray = new JsonArray();
                        }
                        jsonArray.add(asJsonArray2);
                        jsonArray.add(asJsonArray3);
                        jsonArray.add(asJsonArray);
                        if (TextUtils.isEmpty(strReplace)) {
                            CommomUtility.this.myResponse.onCallback(jsonArray, "0");
                        } else {
                            CommomUtility.this.myResponse.onCallback(jsonArray, strReplace);
                        }
                        if (jsonArray.isEmpty()) {
                            CommomUtility.this.myResponse.onCallback(null, response.message());
                            return;
                        }
                        return;
                    } catch (JsonIOException e) {
                        CommomUtility.this.myResponse.onCallback(null, response.message());
                        Logger.d(CommomUtility.this.logTag, e.getMessage());
                        return;
                    }
                }
                try {
                    CommomUtility.this.myResponse.onCallback(null, new JSONObject(response.errorBody().string()).optString(CommomUtility.this.messageText));
                } catch (Exception unused) {
                    if (response.code() == 401) {
                        CommomUtility.this.myResponse.onCallback(null, "unauthorized");
                    } else {
                        CommomUtility.this.myResponse.onCallback(null, Constants.somethingWentWrong);
                    }
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                CommomUtility.this.myResponse.onCallback(null, CommomUtility.this.somethingWentWrong);
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getRelationJSON(String stateCode, String Token, String atkn, String rtkn, final Context context) {
        try {
            this.arraylistReturn = this.arraylistReturn;
            ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getRelation(Token, atkn, rtkn, "BLOAPP", this.currentRole, stateCode, "ANDROIDMOB").enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.5
                public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                    Logger.d(CommomUtility.this.logTag, "Response Code " + response.code());
                    if (response.code() == 200) {
                        SharedPref.getInstance(context).setRelationData(((JSONArray) response.body()).toString());
                    } else {
                        SharedPref.getInstance(context).setRelationData("");
                    }
                }

                public void onFailure(Call<JSONArray> call, Throwable t) {
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
                    SharedPref.getInstance(context).setRelationData("");
                }
            });
        } catch (Exception e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    public void getRelation(String stateCode, String Token, String atkn, String rtkn, Context context, final ArraylistReturn arraylistReturn) {
        Logger.d(this.logTag, "getRelation");
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        arrayList.clear();
        arrayList2.clear();
        arrayList.add("Select Relation Type");
        arrayList2.add("0");
        try {
            this.arraylistReturn = arraylistReturn;
            ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getRelation(Token, atkn, rtkn, "BLOAPP", this.currentRole, stateCode, "ANDROIDMOB").enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.6
                public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                    Logger.d(CommomUtility.this.logTag, "Response Code " + response.code());
                    if (response.code() == 200) {
                        JSONArray jSONArray = (JSONArray) response.body();
                        for (int i = 0; i < jSONArray.size(); i++) {
                            JsonObject asJsonObject = CommomUtility.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                            arrayList.add(String.valueOf(asJsonObject.get(CommomUtility.this.codeDescText)).substring(1, String.valueOf(asJsonObject.get(CommomUtility.this.codeDescText)).length() - 1));
                            arrayList2.add(String.valueOf(asJsonObject.get(CommomUtility.this.codeText)).substring(1, String.valueOf(asJsonObject.get(CommomUtility.this.codeText)).length() - 1));
                        }
                        arraylistReturn.onCallback(response.code(), arrayList, arrayList2);
                        return;
                    }
                    arraylistReturn.onCallback(response.code(), arrayList, arrayList2);
                }

                public void onFailure(Call<JSONArray> call, Throwable t) {
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
                }
            });
        } catch (Exception e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    public void getchecklist(String stateCode, String asmblyNo, String partno, String refno, String formtype, String Token, Context context, final MultipleStringReturn multipleStringReturn) {
        Logger.d(this.logTag, "getchecklist");
        this.multipleStringReturn = multipleStringReturn;
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getchecklist(stateCode, asmblyNo, partno, refno, formtype, Token, this.currentRole, stateCode, "ANDROIDMOB").enqueue(new Callback<in.gov.eci.bloapp.api.model.Response>() { // from class: in.gov.eci.bloapp.CommomUtility.7
            public void onResponse(Call<in.gov.eci.bloapp.api.model.Response> call, Response<in.gov.eci.bloapp.api.model.Response> response) {
                if (response.code() == 200) {
                    JSONArray payload = ((in.gov.eci.bloapp.api.model.Response) response.body()).getPayload();
                    Logger.d(CommomUtility.this.logTag, "payload " + payload);
                    Logger.d(CommomUtility.this.logTag, "" + payload.size());
                    JsonObject asJsonObject = CommomUtility.this.gson.toJsonTree((LinkedTreeMap) payload.get(0)).getAsJsonObject();
                    multipleStringReturn.onCallBack(String.valueOf(asJsonObject.get(Constants.FIRST_NAME)).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("applicantRelativeName")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("email")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("typeOfRelation")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("dob")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("gender")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("ageAtFormSubmission")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("currentHouseNo")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("currentVillageTown")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("currentLocality")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("currentPinCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("epicNoFamilyMember")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("mobileNo")).replace(RegexMatcher.JSON_STRING_REGEX, ""), String.valueOf(asJsonObject.get("currentPostOffice")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    return;
                }
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<in.gov.eci.bloapp.api.model.Response> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void submitform6A(String stateCode, String Token, String atkn, String rtkn, HashMap<String, Object> json, Context context, FormsResponse myCallback) {
        this.formsResponse = myCallback;
        Logger.d(this.logTag, "" + new JSONObject(json));
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).submitform6A(Token, atkn, rtkn, "BLOAPP", this.currentRole, stateCode, "application/json", "ANDROIDMOB", json).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.8
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    Logger.d(CommomUtility.this.logTag, "form 6A..............................");
                    JsonObject jsonObject = (JsonObject) response.body();
                    String strValueOf = String.valueOf(jsonObject.get(CommomUtility.this.messageText));
                    Logger.d(CommomUtility.this.logTag, "Reference Id: " + jsonObject.get("refId"));
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + strValueOf);
                    CommomUtility.this.formsResponse.onCallback(response.code(), strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    Logger.d(CommomUtility.this.logTag, "" + jSONObject);
                    CommomUtility.this.formsResponse.onCallback(response.code(), String.valueOf(jSONObject.get("cause")));
                } catch (Exception e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                    CommomUtility.this.formsResponse.onCallback(response.code(), "");
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getreferencenumber(Context context, String asmblyNo, String stateCode, String formtype, String Token, String atkn, String rtkn, final MyCallback myCallback) {
        this.myCallback = myCallback;
        getRetrofitClient(context, Token, atkn, rtkn).eroRefNum(Integer.parseInt(asmblyNo), stateCode, "G", formtype, this.currentRole, stateCode).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.9
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Logger.d(CommomUtility.this.logTag, "Response Code" + response.code());
                if (response.code() == 200) {
                    String strValueOf = String.valueOf(((JsonObject) response.body()).get("refId"));
                    myCallback.onCallback(response.code(), strValueOf.substring(1, strValueOf.length() - 1));
                    Logger.d(CommomUtility.this.logTag, strValueOf);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    String strOptString = jSONObject.optString("status");
                    String strOptString2 = jSONObject.optString(CommomUtility.this.messageText);
                    if (!Objects.equals(strOptString2, null) && strOptString2.isEmpty()) {
                        String strOptString3 = jSONObject.optString("error");
                        myCallback.onCallback(response.code(), strOptString + " - " + strOptString3);
                        Logger.d(CommomUtility.this.logTag, "In getRefNum() -> RefNum from API -> errorResponse : " + strOptString3);
                    } else {
                        Logger.d(CommomUtility.this.logTag, "In getRefNum() -> RefNum from API -> errorResponse : " + strOptString2);
                        myCallback.onCallback(response.code(), strOptString + " - " + strOptString2);
                    }
                } catch (IOException | JSONException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                    myCallback.onCallback(response.code(), e.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
                myCallback.onCallback(0, t.getMessage());
            }
        });
    }

    public void getreferencenumberform8(final Context context, final String asmblyNo, final String stateCode, final String formtype, final String atkn, final String rtkn, final String Token, final String form8ShiOutWitCorRepMar, final MyCallback myCallback) {
        this.myCallback = myCallback;
        Logger.d(this.logTag, form8ShiOutWitCorRepMar);
        getRetrofitClient(context, Token, atkn, rtkn).eroRefNumform8(Integer.parseInt(asmblyNo), stateCode, "G", formtype, form8ShiOutWitCorRepMar, this.currentRole, stateCode).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.10
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Logger.d(CommomUtility.this.logTag, "Response Code" + response.code());
                if (response.code() == 200) {
                    String strValueOf = String.valueOf(((JsonObject) response.body()).get("refId"));
                    myCallback.onCallback(response.code(), strValueOf.substring(1, strValueOf.length() - 1));
                    Logger.d(CommomUtility.this.logTag, strValueOf);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    String strOptString = jSONObject.optString("status");
                    String strOptString2 = jSONObject.optString(CommomUtility.this.messageText);
                    if (!Objects.equals(strOptString2, null) && strOptString2.isEmpty()) {
                        String strOptString3 = jSONObject.optString("error");
                        myCallback.onCallback(response.code(), strOptString + " - " + strOptString3);
                        Logger.d(CommomUtility.this.logTag, "In getRefNum() -> RefNum from API -> errorResponse : " + strOptString3);
                    } else {
                        Logger.d(CommomUtility.this.logTag, "In getRefNum() -> RefNum from API -> errorResponse : " + strOptString2);
                        myCallback.onCallback(response.code(), strOptString + " - " + strOptString2);
                    }
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
                CommomUtility.this.getreferencenumberform8(context, asmblyNo, stateCode, formtype, atkn, rtkn, Token, form8ShiOutWitCorRepMar, myCallback);
            }
        });
    }

    public void getaddproof(String Token, String atkn, String rtkn, Context context, final ArraylistReturn arraylistReturn) {
        Logger.d(this.logTag, "getaddproof");
        final ArrayList arrayList = new ArrayList();
        this.addproofcode = new ArrayList<>();
        arrayList.clear();
        this.addproofcode.clear();
        arrayList.add("Select Document");
        this.addproofcode.add("0");
        this.arraylistReturn = arraylistReturn;
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getaddproof(Token, atkn, rtkn, "BLOAPP", this.currentRole, "ANDROIDMOB").enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.11
            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                if (response.code() == 200) {
                    JSONArray jSONArray = (JSONArray) response.body();
                    arrayList.add("Any Other Document");
                    CommomUtility.this.addproofcode.add("OTHR");
                    for (int i = 0; i < jSONArray.size(); i++) {
                        JsonObject asJsonObject = CommomUtility.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                        arrayList.add(String.valueOf(asJsonObject.get(CommomUtility.this.codeDescText)).substring(1, String.valueOf(asJsonObject.get(CommomUtility.this.codeDescText)).length() - 1));
                        CommomUtility.this.addproofcode.add(String.valueOf(asJsonObject.get(CommomUtility.this.codeText)).substring(1, String.valueOf(asJsonObject.get(CommomUtility.this.codeText)).length() - 1));
                    }
                    arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.addproofcode);
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + ((String) arrayList.get(0)));
                    return;
                }
                arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.addproofcode);
            }

            public void onFailure(Call<JSONArray> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getageproof(String Token, String atkn, String rtkn, Context context, final ArraylistReturn arraylistReturn) {
        Logger.d(this.logTag, "getageproof");
        final ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.ageroofcode = arrayList2;
        arrayList2.clear();
        arrayList.clear();
        this.arraylistReturn = arraylistReturn;
        arrayList.add("Select Document");
        this.ageroofcode.add("0");
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getageproof(Token, atkn, rtkn, "BLOAPP", this.currentRole, "ANDROIDMOB").enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.12
            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                if (response.code() == 200) {
                    arrayList.add("Any Other Document");
                    CommomUtility.this.ageroofcode.add("OTHR");
                    JSONArray jSONArray = (JSONArray) response.body();
                    for (int i = 0; i < jSONArray.size(); i++) {
                        JsonObject asJsonObject = CommomUtility.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                        arrayList.add(String.valueOf(asJsonObject.get(CommomUtility.this.codeDescText)).substring(1, String.valueOf(asJsonObject.get(CommomUtility.this.codeDescText)).length() - 1));
                        CommomUtility.this.ageroofcode.add(String.valueOf(asJsonObject.get(CommomUtility.this.codeText)).substring(1, String.valueOf(asJsonObject.get(CommomUtility.this.codeText)).length() - 1));
                    }
                    arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.ageroofcode);
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + ((String) arrayList.get(0)));
                    return;
                }
                arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.ageroofcode);
            }

            public void onFailure(Call<JSONArray> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void submitform6(String stateCode, String Token, String atkn, String rtkn, Context context, HashMap<String, Object> json, FormsResponse myCallback) {
        this.formsResponse = myCallback;
        Logger.d(this.logTag, "Form 6 JSON " + new JSONObject(json));
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).submitform6(Token, atkn, rtkn, "BLOAPP", this.currentRole, stateCode, "application/json", "ANDROIDMOB", json).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.13
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    Logger.d(CommomUtility.this.logTag, "form 6A..............................");
                    JsonObject jsonObject = (JsonObject) response.body();
                    String strValueOf = String.valueOf(jsonObject.get(CommomUtility.this.messageText));
                    Logger.d(CommomUtility.this.logTag, "Reference Id: " + jsonObject.get("refId"));
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + strValueOf);
                    CommomUtility.this.formsResponse.onCallback(response.code(), strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    CommomUtility.this.formsResponse.onCallback(response.code(), jSONObject.optString("message"));
                    Logger.d(CommomUtility.this.logTag, "" + jSONObject);
                } catch (Exception e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                    CommomUtility.this.formsResponse.onCallback(response.code(), "");
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void fetchImage(String Token, Context context) {
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).fetchImage(Token, this.currentRole).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.14
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    Logger.d(CommomUtility.this.logTag, "" + ((JsonObject) response.body()).get("status"));
                    return;
                }
                Logger.d(CommomUtility.this.logTag, "");
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [in.gov.eci.bloapp.CommomUtility$15] */
    public void saveChecklistform6(String stateCode, String Token, Context context, JSONObject json) {
        Logger.d(this.logTag, "" + json);
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).saveChecklistform6b(Token, this.currentRole, stateCode, "application/json", "ANDROIDMOB", (Map) new Gson().fromJson(String.valueOf(json), new TypeToken<HashMap<String, String>>() { // from class: in.gov.eci.bloapp.CommomUtility.15
        }.getType())).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.16
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    Logger.d(CommomUtility.this.logTag, "saveChecklistform6");
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + String.valueOf(((JsonObject) response.body()).get(CommomUtility.this.messageText)));
                    return;
                }
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getSection(String stateCode, String platform, String Token, String atkn, String rtkn, String asmblyNo, String partNo, final Context context, final JsonArrayCallback jsonArrayCallback) {
        this.jsonArrayCallback = jsonArrayCallback;
        Logger.d(this.logTag, "getSection");
        try {
            ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getSection("ANDROIDMOB", Token, atkn, rtkn, "BLOAPP", this.currentRole, stateCode, "application/json", asmblyNo, partNo).enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.17
                public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                    jsonArrayCallback.onCallback(response.code(), (JSONArray) response.body());
                }

                public void onFailure(Call<JSONArray> call, Throwable t) {
                    SharedPref.getInstance(context).setSectionData("");
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
                }
            });
        } catch (Exception e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    public void getGenderWiseElectorsCount(String stateCode, String asmblyNO, String partNo, String Token, Context context) {
        Logger.d(this.logTag, "getGenderWiseElectorsCount");
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getGenderWiseElectorsCount(stateCode, asmblyNO, partNo, Token, "", "", "", this.currentRole, stateCode, "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.18
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() != 200) {
                    try {
                        new JSONObject(response.errorBody().string());
                        return;
                    } catch (IOException e) {
                        Logger.d(CommomUtility.this.logTag, e.getMessage());
                        return;
                    } catch (JSONException e2) {
                        Logger.d(CommomUtility.this.logTag, e2.getMessage());
                        return;
                    }
                }
                try {
                    JsonObject jsonObject = (JsonObject) response.body();
                    Logger.d(CommomUtility.this.logTag, "In getGenderDashboard() - > payload - " + jsonObject);
                    JSONObject jSONObject = new JSONObject(String.valueOf(jsonObject)).getJSONObject("payload");
                    CommomUtility.this.dashMale = jSONObject.getString("male");
                    CommomUtility.this.dashFemale = jSONObject.getString("female");
                    CommomUtility.this.dashThirdGender = jSONObject.getString("trans");
                    CommomUtility.this.dashPwd = jSONObject.getString("pwd");
                    CommomUtility.this.dashTotalElector = jSONObject.getString("total");
                    Logger.d(CommomUtility.this.logTag, "male - " + jSONObject.getString("male"));
                    Logger.d(CommomUtility.this.logTag, "female - " + jSONObject.getString("female"));
                    Logger.d(CommomUtility.this.logTag, "total - " + jSONObject.getString("total"));
                    Logger.d(CommomUtility.this.logTag, "trans - " + jSONObject.getString("trans"));
                    Logger.d(CommomUtility.this.logTag, "pwd - " + jSONObject.getString("pwd"));
                } catch (JSONException e3) {
                    Logger.d(CommomUtility.this.logTag, e3.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getDocument(Context context, String stateCode, String Token, ArraylistReturn1 arraylistReturn) {
        Logger.d(this.logTag, "getDocument");
        final ArrayList arrayList = new ArrayList();
        this.arraylistReturn1 = arraylistReturn;
        arrayList.add("Select Document");
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).eroGetDocument(Token, this.currentRole, stateCode, SharedPref.getInstance(context).getAtknBnd(), SharedPref.getInstance(context).getRtknBnd(), "BLOAPP").enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.19
            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                if (response.body() != null) {
                    JSONArray jSONArray = (JSONArray) response.body();
                    for (int i = 0; i < jSONArray.size(); i++) {
                        JsonObject asJsonObject = CommomUtility.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                        arrayList.add(String.valueOf(asJsonObject.get(CommomUtility.this.codeDescText)).substring(1, String.valueOf(asJsonObject.get(CommomUtility.this.codeDescText)).length() - 1));
                    }
                    CommomUtility.this.arraylistReturn1.onCallback(arrayList);
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + ((String) arrayList.get(0)));
                    return;
                }
                CommomUtility.this.arraylistReturn1.onCallback(arrayList);
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JSONArray> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [in.gov.eci.bloapp.CommomUtility$20] */
    public void savechecklistform7(String Token, JSONObject json, String stateCode, Context context) {
        Logger.d(this.logTag, "" + json);
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).savechecklistform7(Token, this.currentRole, stateCode, "application/json", (Map) new Gson().fromJson(String.valueOf(json), new TypeToken<HashMap<String, String>>() { // from class: in.gov.eci.bloapp.CommomUtility.20
        }.getType())).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.21
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    Logger.d(CommomUtility.this.logTag, "form 7 checklist..............................");
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + String.valueOf(((JsonObject) response.body()).get(CommomUtility.this.messageText)));
                    return;
                }
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getStateJson(String Token, String atkn, String rtkn, final Context context) {
        try {
            ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getState(Token, atkn, rtkn, "BLOAPP", this.currentRole).enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.22
                public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                    if (response.code() == 200) {
                        SharedPref.getInstance(context).setStateData(((JSONArray) response.body()).toString());
                    } else {
                        SharedPref.getInstance(context).setStateData("");
                    }
                }

                public void onFailure(Call<JSONArray> call, Throwable t) {
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
                    SharedPref.getInstance(context).setStateData("");
                }
            });
        } catch (Exception e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    public void getState(String Token, String atkn, String rtkn, Context context, final ArraylistReturn arraylistReturn) {
        Logger.d(this.logTag, "in house fetch..............................");
        final ArrayList arrayList = new ArrayList();
        this.statecode = new ArrayList<>();
        arrayList.clear();
        this.statecode.clear();
        arrayList.add("Select State");
        this.statecode.add("0");
        try {
            this.arraylistReturn = arraylistReturn;
            ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getState(Token, atkn, rtkn, "BLOAPP", this.currentRole).enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.23
                public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                    if (response.code() == 200) {
                        JSONArray jSONArray = (JSONArray) response.body();
                        for (int i = 0; i < jSONArray.size(); i++) {
                            JsonObject asJsonObject = CommomUtility.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                            arrayList.add(String.valueOf(asJsonObject.get("stateName")).substring(1, String.valueOf(asJsonObject.get("stateName")).length() - 1));
                            CommomUtility.this.statecode.add(String.valueOf(asJsonObject.get("stateCd")).substring(1, String.valueOf(asJsonObject.get("stateCd")).length() - 1));
                        }
                        arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.statecode);
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + ((String) arrayList.get(0)));
                        return;
                    }
                    arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.statecode);
                }

                public void onFailure(Call<JSONArray> call, Throwable t) {
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
                }
            });
        } catch (Exception e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    public void getDistrict(String state, String Token, String atkn, String rtkn, Context context, final ArraylistReturn arraylistReturn) {
        Logger.d(this.logTag, "in getDistrict..............................");
        final ArrayList arrayList = new ArrayList();
        this.districtcode = new ArrayList<>();
        arrayList.clear();
        this.districtcode.clear();
        arrayList.add("Select District");
        this.districtcode.add("0");
        try {
            this.arraylistReturn = arraylistReturn;
            ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getDistrict(state, Token, atkn, rtkn, "BLOAPP", this.currentRole).enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.24
                public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                    Logger.d(CommomUtility.this.logTag, "Response code district " + response.code());
                    if (response.code() == 200) {
                        JSONArray jSONArray = (JSONArray) response.body();
                        for (int i = 0; i < jSONArray.size(); i++) {
                            JsonObject asJsonObject = CommomUtility.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                            arrayList.add(String.valueOf(asJsonObject.get("districtValue")).substring(1, String.valueOf(asJsonObject.get("districtValue")).length() - 1));
                            CommomUtility.this.districtcode.add(String.valueOf(asJsonObject.get("districtCd")).substring(1, String.valueOf(asJsonObject.get("districtCd")).length() - 1));
                        }
                        arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.districtcode);
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + ((String) arrayList.get(0)));
                        return;
                    }
                    arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.districtcode);
                }

                public void onFailure(Call<JSONArray> call, Throwable t) {
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
                }
            });
        } catch (Exception e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    public void getConstituency(String state, String Token, String atkn, String rtkn, Context context, final ArraylistReturn arraylistReturn) {
        Logger.d(this.logTag, "in house fetch..............................");
        final ArrayList arrayList = new ArrayList();
        this.constituencycode = new ArrayList<>();
        arrayList.clear();
        this.constituencycode.clear();
        arrayList.add("Select Constituency");
        this.constituencycode.add("0");
        try {
            this.arraylistReturn = arraylistReturn;
            ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getConstituency(state, Token, atkn, rtkn, "BLOAPP", this.currentRole).enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.25
                public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                    if (response.code() == 200) {
                        JSONArray jSONArray = (JSONArray) response.body();
                        for (int i = 0; i < jSONArray.size(); i++) {
                            JsonObject asJsonObject = CommomUtility.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                            arrayList.add(String.valueOf(asJsonObject.get("asmblyName")).substring(1, String.valueOf(asJsonObject.get("asmblyName")).length() - 1));
                            CommomUtility.this.constituencycode.add(String.valueOf(asJsonObject.get("asmblyNo")).substring(1, String.valueOf(asJsonObject.get("asmblyNo")).length() - 1));
                        }
                        arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.constituencycode);
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + ((String) arrayList.get(0)));
                        return;
                    }
                    arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.constituencycode);
                }

                public void onFailure(Call<JSONArray> call, Throwable t) {
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
                }
            });
        } catch (Exception e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    public void getCountry(String stateCode, String Token, String atkn, String rtkn, Context context, final ArraylistReturn arraylistReturn) {
        Logger.d(this.logTag, "in house fetch..............................");
        final ArrayList arrayList = new ArrayList();
        this.countrycode = new ArrayList<>();
        arrayList.clear();
        this.countrycode.clear();
        arrayList.add("Select Country");
        this.countrycode.add("0");
        try {
            this.arraylistReturn = arraylistReturn;
            ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getCountry(Token, atkn, rtkn, "BLOAPP", this.currentRole, stateCode).enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.26
                public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                    if (response.code() == 200) {
                        JSONArray jSONArray = (JSONArray) response.body();
                        for (int i = 0; i < jSONArray.size(); i++) {
                            JsonObject asJsonObject = CommomUtility.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                            arrayList.add(String.valueOf(asJsonObject.get("country_VALUE")).substring(1, String.valueOf(asJsonObject.get("country_VALUE")).length() - 1));
                            CommomUtility.this.countrycode.add(String.valueOf(asJsonObject.get("countryCode")).substring(1, String.valueOf(asJsonObject.get("countryCode")).length() - 1));
                        }
                        arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.countrycode);
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + ((String) arrayList.get(0)));
                        return;
                    }
                    arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.countrycode);
                }

                public void onFailure(Call<JSONArray> call, Throwable t) {
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
                }
            });
        } catch (Exception e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    public void getStatebycountryCode(String countrycd, String Token, Context context, final ArraylistReturn arraylistReturn) {
        Logger.d(this.logTag, "in house fetch..............................");
        final ArrayList arrayList = new ArrayList();
        this.statecd = new ArrayList<>();
        arrayList.clear();
        this.statecd.clear();
        this.arraylistReturn = arraylistReturn;
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getStatebyCountryCode(countrycd, Token, this.currentRole).enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.27
            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                if (response.code() == 200) {
                    JSONArray jSONArray = (JSONArray) response.body();
                    arrayList.add("Select State");
                    CommomUtility.this.statecd.add("0");
                    for (int i = 0; i < jSONArray.size(); i++) {
                        JsonObject asJsonObject = CommomUtility.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                        arrayList.add(String.valueOf(asJsonObject.get("stateName")).substring(1, String.valueOf(asJsonObject.get("stateName")).length() - 1));
                        CommomUtility.this.statecd.add(String.valueOf(asJsonObject.get("stateCd")).substring(1, String.valueOf(asJsonObject.get("stateCd")).length() - 1));
                    }
                    arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.statecd);
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + ((String) arrayList.get(0)));
                    return;
                }
                arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.statecd);
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JSONArray> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [in.gov.eci.bloapp.CommomUtility$28] */
    public void savechecklistform6B(String stateCode, String token, Context context, JSONObject json) {
        Logger.d(this.logTag, "" + json);
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).saveChecklistform6b(token, this.currentRole, stateCode, "application/json", "ANDROIDMOB", (Map) new Gson().fromJson(String.valueOf(json), new TypeToken<HashMap<String, String>>() { // from class: in.gov.eci.bloapp.CommomUtility.28
        }.getType())).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.29
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Logger.d(CommomUtility.this.logTag, "Response Body " + response.body());
                Logger.d(CommomUtility.this.logTag, "Response Body " + response.code());
                if (response.body() != null) {
                    Logger.d(CommomUtility.this.logTag, "form 7 checklist..............................");
                    Logger.d(CommomUtility.this.logTag, "PayloadTanvi " + ((JsonObject) response.body()).get(CommomUtility.this.messageText));
                    return;
                }
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void form8Submit(Context context, String token, String atkn, String rtkn, String currentRole, String stateCd, Map<String, Object> map, FormsResponse myCallback) {
        Logger.d(this.logTag, "Form 6B submit..............................");
        this.formsResponse = myCallback;
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).eroMigrationSubmit(token, atkn, rtkn, "BLOAPP", currentRole, stateCd, "ANDROIDMOB", map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.30
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.body() != null) {
                    CommomUtility.this.submitResponse = (JsonObject) response.body();
                    Logger.d(CommomUtility.this.logTag, "Form 8 submitted successfully........" + CommomUtility.this.submitResponse.get(CommomUtility.this.messageText));
                    CommomUtility.this.formsResponse.onCallback(response.code(), String.valueOf(CommomUtility.this.submitResponse.get(CommomUtility.this.messageText)).substring(1, String.valueOf(CommomUtility.this.submitResponse.get(CommomUtility.this.messageText)).length() - 1));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    String strOptString = jSONObject.optString(CommomUtility.this.messageText);
                    String strOptString2 = jSONObject.optString("cause");
                    Logger.d(CommomUtility.this.logTag, "Callback Responses " + strOptString + "   " + strOptString2);
                    if (strOptString2.equals("null") || strOptString2.equals("")) {
                        CommomUtility.this.formsResponse.onCallback(response.code(), strOptString);
                    } else {
                        CommomUtility.this.formsResponse.onCallback(response.code(), strOptString2);
                    }
                    Logger.d(CommomUtility.this.logTag, "Form 8 not submitted." + jSONObject);
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, "coming in onFailure on Submit " + t.getMessage());
            }
        });
    }

    public void form8OSubmit(Context context, String token, String atkn, String rtkn, String currentRole, String stateCd, Map<String, Object> map, FormsResponse myCallback) {
        Logger.d(this.logTag, "Form 8O submit..............................");
        this.formsResponse = myCallback;
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).eroMigrationOverseasSubmit(token, atkn, rtkn, "BLOAPP", currentRole, stateCd, "ANDROIDMOB", map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.31
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.body() != null) {
                    CommomUtility.this.submitResponse = (JsonObject) response.body();
                    Logger.d(CommomUtility.this.logTag, "Form 8O submitted successfully........" + CommomUtility.this.submitResponse.get(CommomUtility.this.messageText));
                    CommomUtility.this.formsResponse.onCallback(response.code(), String.valueOf(CommomUtility.this.submitResponse.get(CommomUtility.this.messageText)).substring(1, String.valueOf(CommomUtility.this.submitResponse.get(CommomUtility.this.messageText)).length() - 1));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    String strOptString = jSONObject.optString(CommomUtility.this.messageText);
                    String strOptString2 = jSONObject.optString("cause");
                    Logger.d(CommomUtility.this.logTag, "Callback Responses " + strOptString + "   " + strOptString2);
                    if (strOptString2.equals("null")) {
                        CommomUtility.this.formsResponse.onCallback(response.code(), strOptString);
                    } else {
                        CommomUtility.this.formsResponse.onCallback(response.code(), strOptString2);
                    }
                    Logger.d(CommomUtility.this.logTag, "Form 8O not submitted." + jSONObject);
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, "coming in onFailure on Submit " + t.getMessage());
            }
        });
    }

    public void getchecklistdetails(Context context, String stateCode, String asmblyNo, String partNo, String refno, String formtype, String Token) {
        Logger.d(this.logTag, "in house fetch..............................");
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getchecklist(stateCode, asmblyNo, partNo, refno, formtype, Token, this.currentRole, stateCode, "ANDROIDMOB").enqueue(new Callback<in.gov.eci.bloapp.api.model.Response>() { // from class: in.gov.eci.bloapp.CommomUtility.32
            public void onResponse(Call<in.gov.eci.bloapp.api.model.Response> call, Response<in.gov.eci.bloapp.api.model.Response> response) {
                if (response.code() == 200) {
                    JSONArray payload = ((in.gov.eci.bloapp.api.model.Response) response.body()).getPayload();
                    Logger.d(CommomUtility.this.logTag, "" + payload);
                    LinkedTreeMap linkedTreeMap = (LinkedTreeMap) payload.get(0);
                    CommomUtility commomUtility = CommomUtility.this;
                    commomUtility.jsonObject = commomUtility.gson.toJsonTree(linkedTreeMap).getAsJsonObject();
                    return;
                }
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<in.gov.eci.bloapp.api.model.Response> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void displayAlertWithTitleAndMessageAndExit(Context ctx, String title, String message) {
        new AlertDialog.Builder(ctx).setTitle(title).setMessage(message).setPositiveButton("Exit", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.CommomUtility$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        }).setIcon(android.R.drawable.ic_dialog_alert).show();
    }

    public void getchecklistdetailsform8(Context context, String stateCode, String atkBand, String rtkBand, String refno, String Token, final Forms8Respponse myforms8Respponse) {
        Logger.d(this.logTag, "in form 8 checklist fetch..............................");
        this.forms8Respponse = myforms8Respponse;
        getRetrofitClient(context, Token, atkBand, rtkBand).getchecklistform8(refno, this.currentRole, stateCode, "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.33
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                CommomUtility.this.codeform8 = response.code();
                if (response.code() == 200) {
                    CommomUtility.this.jsonobjectform8 = (JsonObject) response.body();
                    myforms8Respponse.onCallback(response.code(), CommomUtility.this.jsonobjectform8);
                    return;
                }
                myforms8Respponse.onCallback(response.code(), CommomUtility.this.jsonobjectform8);
                try {
                    System.out.println(new JSONObject(response.errorBody().string()));
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getchecklistdetailsform8O(Context context, String stateCode, String atkBand, String rtkBand, String refno, String Token) {
        Logger.d(this.logTag, "in form 8O checklist fetch..............................");
        getRetrofitClient(context, Token, atkBand, rtkBand).getchecklistform8O(refno, this.currentRole, stateCode, "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.34
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                CommomUtility.this.codeform8O = response.code();
                if (response.code() == 200) {
                    CommomUtility.this.jsonobjectform8O = (JsonObject) response.body();
                    return;
                }
                try {
                    System.out.println(new JSONObject(response.errorBody().string()));
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void uploadToServer(Context context, String captureFileName, String token, String reference) {
        HashMap map = new HashMap();
        RestClient restClient = (RestClient) ApiClient.getClient(context).create(RestClient.class);
        File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + captureFileName);
        Call<JsonObject> callUploadImageWithData = restClient.uploadImageWithData(token, this.currentRole, "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("objectstorage", MediaType.parse("bucketName")), RequestBody.create("application/pdf", MediaType.parse("fileType")), RequestBody.create(reference, MediaType.parse("fileName")), RequestBody.create("BLOAPP", MediaType.parse("appName")));
        Logger.d(this.logTag, "" + map);
        callUploadImageWithData.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.35
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    JsonElement jsonElement = ((JsonObject) response.body()).get("refId");
                    Logger.d(CommomUtility.this.logTag, "fgdfsrdghf" + String.valueOf(((JsonObject) response.body()).get("refId")));
                    CommomUtility.this.setPhotoReferenceNumber = String.valueOf(jsonElement).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                    String str = CommomUtility.this.setPhotoReferenceNumber;
                    Logger.d("referenceNumber ", CommomUtility.this.setPhotoReferenceNumber);
                    return;
                }
                try {
                    new JSONObject(response.errorBody().string());
                    Logger.d(CommomUtility.this.logTag, "image not posted" + response.errorBody());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getuploadedfile(Context context, String token, String atkn, String rtkn, String fileName, final MyCallback myCallback) {
        this.myCallback = myCallback;
        Logger.d(this.logTag, "getting downloaded file");
        Logger.d(this.logTag, "nisthadsrt" + fileName);
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getdownloaded(token, atkn, rtkn, "BLOAPP", this.currentRole, "ANDROIDMOB", "objectstorage", fileName, "BLOAPP").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.36
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    JsonObject jsonObject = (JsonObject) response.body();
                    Logger.d(CommomUtility.this.logTag, "error in image" + jsonObject.get("file"));
                    String strValueOf = String.valueOf(jsonObject.get("file"));
                    Logger.d(CommomUtility.this.logTag, "Filename " + strValueOf);
                    myCallback.onCallback(response.code(), strValueOf);
                    return;
                }
                myCallback.onCallback(response.code(), "");
                try {
                    new JSONObject(response.errorBody().string());
                    Logger.d(CommomUtility.this.logTag, "nisthaerror" + response.errorBody());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getVillage(Context context, String Token, String stateCode, String District, final ArraylistReturn arraylistReturn) {
        Logger.d(this.logTag, "in village fetch..............................");
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("stateCd", stateCode);
            map.put("districtCd", District);
            map.put("acNo", "");
            this.arraylistReturn = arraylistReturn;
            arrayList.clear();
            arrayList2.clear();
            Logger.d(this.logTag, "villageggggggggggg");
            arrayList.add("Select Village");
            arrayList2.add("0");
            ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getVillage(Token, this.currentRole, map).enqueue(new Callback<in.gov.eci.bloapp.api.model.Response>() { // from class: in.gov.eci.bloapp.CommomUtility.37
                public void onResponse(Call<in.gov.eci.bloapp.api.model.Response> call, Response<in.gov.eci.bloapp.api.model.Response> response) {
                    Logger.d(CommomUtility.this.logTag, "Response code " + response.code());
                    if (response.code() == 200) {
                        JSONArray payload = ((in.gov.eci.bloapp.api.model.Response) response.body()).getPayload();
                        for (int i = 0; i < payload.size(); i++) {
                            JsonObject asJsonObject = CommomUtility.this.gson.toJsonTree(payload.get(i)).getAsJsonObject();
                            arrayList.add(String.valueOf(asJsonObject.get("villageName")).substring(1, String.valueOf(asJsonObject.get("villageName")).length() - 1));
                            arrayList2.add(String.valueOf(asJsonObject.get("villageId")).substring(1, String.valueOf(asJsonObject.get("villageId")).length() - 1));
                        }
                        arraylistReturn.onCallback(response.code(), arrayList, arrayList2);
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + ((String) arrayList.get(0)));
                        return;
                    }
                    try {
                        Logger.d(CommomUtility.this.logTag, new JSONObject(response.errorBody().string()).optString(CommomUtility.this.messageText));
                    } catch (IOException e) {
                        Logger.d(CommomUtility.this.logTag, e.getMessage());
                    } catch (JSONException e2) {
                        Logger.d(CommomUtility.this.logTag, e2.getMessage());
                    }
                    arraylistReturn.onCallback(response.code(), arrayList, arrayList2);
                }

                public void onFailure(Call<in.gov.eci.bloapp.api.model.Response> call, Throwable t) {
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
                }
            });
        } catch (Exception e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [in.gov.eci.bloapp.CommomUtility$38] */
    public void savechecklistform6A(Context context, String Token, JSONObject json) {
        Logger.d(this.logTag, "" + json);
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).savechecklistform7(Token, this.currentRole, "S06", "application/json", (Map) new Gson().fromJson(String.valueOf(json), new TypeToken<HashMap<String, String>>() { // from class: in.gov.eci.bloapp.CommomUtility.38
        }.getType())).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.39
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    Logger.d(CommomUtility.this.logTag, "form 6A checklist..............................");
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + String.valueOf(((JsonObject) response.body()).get(CommomUtility.this.messageText)));
                    return;
                }
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void uploadToServer2(Context context, String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String token, String reference, String atkn, String rtkn, final MyCallback myCallback) {
        HashMap map = new HashMap();
        this.myCallback = myCallback;
        RestClient restClient = (RestClient) ApiClient.getClient(context).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
        RequestBody requestBodyCreate = RequestBody.create(reference, MediaType.parse("fileName"));
        Call<JsonObject> callUploadImageWithData1 = restClient.uploadImageWithData1(token, atkn, rtkn, "BLOAPP", this.currentRole, "BLOAPP", partCreateFormData, RequestBody.create("application/pdf", MediaType.parse("fileType")), requestBodyCreate, RequestBody.create(statecode, MediaType.parse("stateCode")), RequestBody.create(asmblyNo, MediaType.parse("acNo")), RequestBody.create(partno, MediaType.parse("partNo")), RequestBody.create("form", MediaType.parse("type")), RequestBody.create("BLOAPP", MediaType.parse("appName")));
        Logger.d(this.logTag, "" + map);
        callUploadImageWithData1.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.40
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    JsonElement jsonElement = ((JsonObject) response.body()).get("refId");
                    Logger.d(CommomUtility.this.logTag, "fgdfsrdghf" + String.valueOf(((JsonObject) response.body()).get("refId")));
                    CommomUtility.this.setPhotoReferenceNumber = String.valueOf(jsonElement).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                    myCallback.onCallback(response.code(), CommomUtility.this.setPhotoReferenceNumber);
                    Logger.d("referenceNumber ", CommomUtility.this.setPhotoReferenceNumber);
                    return;
                }
                myCallback.onCallback(response.code(), "");
                try {
                    new JSONObject(response.errorBody().string());
                    Logger.d(CommomUtility.this.logTag, "image not posted" + response.errorBody());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getchecklistdetailsform6a(Context context, String stateCode, String refno, String Token, String atkn, String rtkn, final MyCallbackJson myCallbackJson) {
        Logger.d(this.logTag, "in house fetch..............................");
        this.myCallbackJson = myCallbackJson;
        getRetrofitClient(context, Token, atkn, rtkn).getchecklistform6a(refno, this.currentRole, stateCode, "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.41
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    CommomUtility.this.jsonobjectform6a = (JsonObject) response.body();
                    myCallbackJson.onCallback(response.code(), CommomUtility.this.jsonobjectform6a);
                    return;
                }
                myCallbackJson.onCallback(response.code(), CommomUtility.this.jsonobjectform6a);
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void updateBloCallback(Context context, String stateCode, String atkBand, String rtkBand, String token, Map<String, Object> bodymap, MyResponse myCallback) {
        Logger.d(this.logTag, "Uppdate callBAck list data..............................");
        this.myResponse = myCallback;
        getRetrofitClient(context, token, atkBand, rtkBand).updateBloCallback(stateCode, bodymap).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.42
            public void onFailure(Call<JsonObject> call, Throwable throwable) {
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.body() != null) {
                    try {
                        JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + asJsonArray);
                        if (asJsonArray != null) {
                            Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + asJsonArray);
                            CommomUtility.this.myResponse.onCallback(asJsonArray, null);
                        } else {
                            CommomUtility.this.myResponse.onCallback(null, response.message());
                        }
                        return;
                    } catch (JsonIOException e) {
                        CommomUtility.this.myResponse.onCallback(null, response.message());
                        Logger.d(CommomUtility.this.logTag, e.getMessage());
                        return;
                    }
                }
                try {
                    CommomUtility.this.myResponse.onCallback(null, new JSONObject(response.errorBody().string()).optString(CommomUtility.this.messageText));
                } catch (Exception e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                    if (response.code() == 401) {
                        CommomUtility.this.myResponse.onCallback(null, "unauthorized");
                    } else {
                        CommomUtility.this.myResponse.onCallback(null, CommomUtility.this.somethingWentWrong);
                    }
                }
            }
        });
    }

    public void getBla1Details(Context context, String atkBand, String rtkBand, String state, String currentRole, String token, Map<String, Object> bodymap, MyResponse myCallback) {
        Logger.d(this.logTag, "getBLA1 list data..............................");
        this.myResponse = myCallback;
        getRetrofitClient(context, token, atkBand, rtkBand).getBLA1Details(state, currentRole, token, bodymap).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.43
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.body() != null) {
                    try {
                        JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + asJsonArray);
                        if (asJsonArray != null) {
                            Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + asJsonArray);
                            CommomUtility.this.myResponse.onCallback(asJsonArray, null);
                        } else {
                            CommomUtility.this.myResponse.onCallback(null, response.message());
                        }
                        return;
                    } catch (JsonIOException e) {
                        CommomUtility.this.myResponse.onCallback(null, response.message());
                        Logger.d(CommomUtility.this.logTag, e.getMessage());
                        return;
                    }
                }
                try {
                    CommomUtility.this.myResponse.onCallback(null, new JSONObject(response.errorBody().string()).optString(CommomUtility.this.messageText));
                } catch (Exception e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                    if (response.code() == 401) {
                        CommomUtility.this.myResponse.onCallback(null, "unauthorized");
                    } else {
                        CommomUtility.this.myResponse.onCallback(null, CommomUtility.this.somethingWentWrong);
                    }
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable throwable) {
                CommomUtility.this.myResponse.onCallback(null, CommomUtility.this.somethingWentWrong);
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + throwable.getMessage());
            }
        });
    }

    public void fetchCallBackDetails(Context context, String stateCode, String atkBand, String rtkBand, String token, Map<String, Object> bodymap, MyResponse myCallback) {
        Logger.d(this.logTag, "Fetch callBAck list data..............................");
        this.myResponse = myCallback;
        getRetrofitClient(context, token, atkBand, rtkBand).fetchCallBackDetails(token, stateCode, bodymap).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.44
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.body() != null) {
                    try {
                        JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("payload");
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + asJsonArray);
                        if (asJsonArray != null) {
                            Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + asJsonArray);
                            CommomUtility.this.myResponse.onCallback(asJsonArray, null);
                        } else {
                            CommomUtility.this.myResponse.onCallback(null, response.message());
                        }
                        return;
                    } catch (JsonIOException e) {
                        CommomUtility.this.myResponse.onCallback(null, response.message());
                        Logger.d(CommomUtility.this.logTag, e.getMessage());
                        return;
                    }
                }
                try {
                    CommomUtility.this.myResponse.onCallback(null, new JSONObject(response.errorBody().string()).optString(CommomUtility.this.messageText));
                } catch (Exception e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                    if (response.code() == 401) {
                        CommomUtility.this.myResponse.onCallback(null, "unauthorized");
                    } else {
                        CommomUtility.this.myResponse.onCallback(null, CommomUtility.this.somethingWentWrong);
                    }
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable throwable) {
                CommomUtility.this.myResponse.onCallback(null, CommomUtility.this.somethingWentWrong);
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + throwable.getMessage());
            }
        });
    }

    public void getVerifiedList(Context context, String stateCode, String atkBand, String rtkBand, String token, String currentRole, MyResponse myCallback) {
        Logger.d(this.logTag, "Fetch chek list data..............................");
        this.myResponse = myCallback;
        HashMap map = new HashMap();
        map.put("pageNumber", 0);
        map.put("pageSize", 2000);
        map.put("isVerified", "Y");
        getRetrofitClient(context, token, atkBand, rtkBand).getCheckList1(stateCode, currentRole, "ANDROIDMOB", map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.45
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.body() != null) {
                    try {
                        JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("content");
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + asJsonArray);
                        if (asJsonArray != null) {
                            Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + asJsonArray);
                            CommomUtility.this.myResponse.onCallback(asJsonArray, null);
                        } else {
                            CommomUtility.this.myResponse.onCallback(null, response.message());
                        }
                        return;
                    } catch (JsonIOException e) {
                        CommomUtility.this.myResponse.onCallback(null, response.message());
                        Logger.d(CommomUtility.this.logTag, e.getMessage());
                        return;
                    }
                }
                try {
                    CommomUtility.this.myResponse.onCallback(null, new JSONObject(response.errorBody().string()).optString(CommomUtility.this.messageText));
                } catch (Exception e2) {
                    if (response.code() == 401) {
                        CommomUtility.this.myResponse.onCallback(null, "unauthorized");
                    } else {
                        CommomUtility.this.myResponse.onCallback(null, CommomUtility.this.somethingWentWrong);
                    }
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                CommomUtility.this.myResponse.onCallback(null, CommomUtility.this.somethingWentWrong);
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void storeaadhar(Context context, String stateCode, String Token, String aadhar, String atkn, String rtkn, String moduleName, final MultipleString myCallback) {
        this.multipleString = myCallback;
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).storeAadhar(Token, atkn, rtkn, "BLOAPP", this.currentRole, stateCode, "ANDROIDMOB", moduleName, aadhar).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.46
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    JsonObject jsonObject = (JsonObject) response.body();
                    String strSubstring = jsonObject.get("status").toString().substring(1, jsonObject.get("status").toString().length() - 1);
                    if (strSubstring.equals("n") || strSubstring.equals("N")) {
                        CommomUtility commomUtility = CommomUtility.this;
                        commomUtility.form6a = String.valueOf(jsonObject.get(commomUtility.messageText));
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + CommomUtility.this.form6a);
                    }
                    if (strSubstring.equals("y") || strSubstring.equals("Y")) {
                        CommomUtility.this.form6a = String.valueOf(jsonObject.get("aadharNo"));
                    }
                    myCallback.onCallBack(strSubstring, CommomUtility.this.form6a.substring(1, CommomUtility.this.form6a.length() - 1));
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + CommomUtility.this.form6a);
                    return;
                }
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getaadharref(Context context, String stateCode, String Token, String aadhar, String atkn, String rtkn, String ModuleName, aadharcallback myCallback) {
        this.aadharcallback = myCallback;
        HashMap map = new HashMap();
        map.put("aadharNo", aadhar);
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getNewAadharRef(Token, atkn, rtkn, "BLOAPP", this.currentRole, stateCode, "ANDROIDMOB", ModuleName, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.47
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    JsonObject jsonObject = (JsonObject) response.body();
                    String strSubstring = jsonObject.get("status").toString().substring(1, jsonObject.get("status").toString().length() - 1);
                    if (strSubstring.equals("n") || strSubstring.equals("N")) {
                        CommomUtility commomUtility = CommomUtility.this;
                        commomUtility.form6a = String.valueOf(jsonObject.get(commomUtility.messageText));
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + CommomUtility.this.form6a);
                    }
                    if (strSubstring.equals("y") || strSubstring.equals("Y")) {
                        CommomUtility.this.form6a = String.valueOf(jsonObject.get("refNumber"));
                    }
                    if (CommomUtility.this.form6a != null) {
                        CommomUtility.this.aadharcallback.onCallBack(response.code(), strSubstring, CommomUtility.this.form6a.substring(1, CommomUtility.this.form6a.length() - 1));
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + CommomUtility.this.form6a);
                        return;
                    }
                    return;
                }
                try {
                    CommomUtility.this.aadharcallback.onCallBack(response.code(), "", new JSONObject(response.errorBody().string()).optString(CommomUtility.this.messageText));
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getaadhar(Context context, String stateCode, String Token, String aadhar, String atkn, String rtkn, String moduleName, MultipleString myCallback) {
        this.multipleString = myCallback;
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getaadhar(Token, atkn, rtkn, "BLOAPP", this.currentRole, stateCode, "ANDROIDMOB", moduleName, aadhar).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.48
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    JsonObject jsonObject = (JsonObject) response.body();
                    String strSubstring = jsonObject.get("status").toString().substring(1, jsonObject.get("status").toString().length() - 1);
                    if (strSubstring.equals("n") || strSubstring.equals("N")) {
                        CommomUtility commomUtility = CommomUtility.this;
                        commomUtility.form6a = String.valueOf(jsonObject.get(commomUtility.messageText));
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + CommomUtility.this.form6a);
                    }
                    if (strSubstring.equals("y") || strSubstring.equals("Y")) {
                        CommomUtility.this.form6a = String.valueOf(jsonObject.get("aadharNo"));
                    }
                    CommomUtility.this.multipleString.onCallBack(strSubstring, CommomUtility.this.form6a.substring(1, CommomUtility.this.form6a.length() - 1));
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + CommomUtility.this.form6a);
                    return;
                }
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getaadhar1(Context context, String stateCode, String Token, String aadhar, String atkn, String rtkn, String moduleName, MultipleString myCallback) {
        this.multipleString = myCallback;
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getaadhar(Token, atkn, rtkn, "BLOAPP", this.currentRole, stateCode, "ANDROIDMOB", moduleName, aadhar).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.49
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    JsonObject jsonObject = (JsonObject) response.body();
                    String strSubstring = jsonObject.get("status").toString().substring(1, jsonObject.get("status").toString().length() - 1);
                    if (strSubstring.equals("n") || strSubstring.equals("N")) {
                        CommomUtility commomUtility = CommomUtility.this;
                        commomUtility.form6a = String.valueOf(jsonObject.get(commomUtility.messageText));
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + CommomUtility.this.form6a);
                    }
                    if (strSubstring.equals("y") || strSubstring.equals("Y")) {
                        CommomUtility.this.form6a = String.valueOf(jsonObject.get("aadharNo"));
                    }
                    try {
                        CommomUtility.this.multipleString.onCallBack(strSubstring, CommomUtility.this.form6a.substring(1, CommomUtility.this.form6a.length() - 1));
                        return;
                    } catch (Exception unused) {
                        CommomUtility.this.multipleString.onCallBack("D", "");
                        return;
                    }
                }
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    CommomUtility.this.multipleString.onCallBack("D", "");
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    CommomUtility.this.multipleString.onCallBack("D", "");
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                CommomUtility.this.multipleString.onCallBack("D", "");
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    /* JADX WARN: Type inference failed for: r13v2, types: [in.gov.eci.bloapp.CommomUtility$50] */
    public void savechecklistform6A(Context context, String Token, JSONObject json, String stateCode, String assemblyNumber, String partNumber) {
        Logger.d("json", json.toString());
        final Map<String, String> map = (Map) new Gson().fromJson(String.valueOf(json), new TypeToken<HashMap<String, String>>() { // from class: in.gov.eci.bloapp.CommomUtility.50
        }.getType());
        Logger.d("map", map.toString());
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).savechecklistform6a(Token, this.currentRole, stateCode, "application/json", "ANDROIDMOB", map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.51
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Logger.d("map", map.toString());
                Logger.d("response code", "" + response.code());
                if (response.code() == 200) {
                    Logger.d(CommomUtility.this.logTag, "form 6A checklist..............................");
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + String.valueOf(((JsonObject) response.body()).get(CommomUtility.this.messageText)));
                    return;
                }
                try {
                    Logger.d(CommomUtility.this.logTag, "errorResponse" + new JSONObject(response.errorBody().string()).optString(CommomUtility.this.messageText));
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public UserClient getRetrofitClient(final Context context, final String token, final String atkBand, final String rtkBand) {
        Logger.d("token", token);
        SSLFactoryHelper.SSLParams sSLParams = SSLFactoryHelper.getSSLParams(context, new int[]{context.getResources().getIdentifier(BuildConfig.CERT_RAW_NAME, "raw", context.getPackageName()), context.getResources().getIdentifier(BuildConfig.CERT_RAW_NAME_NEW, "raw", context.getPackageName())});
        OkHttpClient okHttpClientBuild = new OkHttpClient().newBuilder().connectTimeout(2L, TimeUnit.MINUTES).readTimeout(2L, TimeUnit.MINUTES).sslSocketFactory(sSLParams.sslSocketFactory, sSLParams.trustManager).addInterceptor(new Interceptor() { // from class: in.gov.eci.bloapp.CommomUtility.52
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                return chain.proceed(request.newBuilder().header("Authorization", token).header("atkn_bnd", atkBand).header("rtkn_bnd", rtkBand).header("channelidobo", "BLOAPP").header("PLATFORM-TYPE", "ANDROIDMOB").header("DEVICE-ID", Settings.Secure.getString(context.getContentResolver(), "android_id")).build());
            }
        }).build();
        new GsonBuilder().setLenient().create();
        return (UserClient) new Retrofit.Builder().baseUrl(this.baseurl).addConverterFactory(GsonConverterFactory.create()).client(okHttpClientBuild).build().create(UserClient.class);
    }

    public void getCheckList1(Context context, String stateCode, String atkBand, String rtkBand, int asmblyNo, int partNo, String token, String currentRole, MyResponse myCallback) {
        Logger.d(this.logTag, "Fetch chek list data..............................");
        this.myResponse = myCallback;
        HashMap map = new HashMap();
        map.put("pageNumber", 0);
        map.put("pageSize", 2000);
        map.put("isVerified", "N");
        getRetrofitClient(context, token, atkBand, rtkBand).getCheckList1(stateCode, currentRole, "ANDROIDMOB", map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.53
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.body() != null) {
                    try {
                        JsonArray asJsonArray = ((JsonObject) response.body()).getAsJsonArray("content");
                        Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + asJsonArray);
                        if (asJsonArray != null) {
                            Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + asJsonArray);
                            CommomUtility.this.myResponse.onCallback(asJsonArray, null);
                        } else {
                            CommomUtility.this.myResponse.onCallback(null, response.message());
                        }
                        return;
                    } catch (JsonIOException e) {
                        CommomUtility.this.myResponse.onCallback(null, response.message());
                        Logger.d(CommomUtility.this.logTag, e.getMessage());
                        return;
                    }
                }
                try {
                    CommomUtility.this.myResponse.onCallback(null, new JSONObject(response.errorBody().string()).optString(CommomUtility.this.messageText));
                } catch (Exception e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                    if (response.code() == 401) {
                        CommomUtility.this.myResponse.onCallback(null, "unauthorized");
                    } else {
                        CommomUtility.this.myResponse.onCallback(null, CommomUtility.this.somethingWentWrong);
                    }
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                CommomUtility.this.myResponse.onCallback(null, CommomUtility.this.somethingWentWrong);
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getdetailsofElasticEpic(Context context, String token, Map<String, Object> elasticmap, MyCallbackJson json) {
        this.json = json;
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).eroGetEpic8elastic(token, this.currentRole, "ANDROIDMOB", elasticmap).enqueue(new AnonymousClass54(json));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.CommomUtility$54, reason: invalid class name */
    class AnonymousClass54 implements Callback<JsonObject> {
        final /* synthetic */ MyCallbackJson val$json;

        static /* synthetic */ void lambda$onResponse$0() {
        }

        static /* synthetic */ void lambda$onResponse$1() {
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
        }

        AnonymousClass54(final MyCallbackJson val$json) {
            this.val$json = val$json;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                CommomUtility.this.submitResponse = (JsonObject) response.body();
                Logger.d(CommomUtility.this.logTag, "Elastic search 200 response........" + CommomUtility.this.submitResponse.get("Result"));
                if (!CommomUtility.this.submitResponse.get("Status").getAsString().equals("false")) {
                    JsonObject asJsonObject = CommomUtility.this.submitResponse.get("Result").getAsJsonObject();
                    asJsonObject.addProperty("Status", "True");
                    this.val$json.onCallback(response.code(), asJsonObject);
                    new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.CommomUtility$54$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            CommomUtility.AnonymousClass54.lambda$onResponse$0();
                        }
                    }, 1000L);
                    return;
                }
                this.val$json.onCallback(response.code(), CommomUtility.this.submitResponse.getAsJsonObject());
                new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.CommomUtility$54$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CommomUtility.AnonymousClass54.lambda$onResponse$1();
                    }
                }, 1000L);
                return;
            }
            Logger.d(CommomUtility.this.logTag, "In fetchEPICData() -> else part ----> Response Body is null .............................");
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(CommomUtility.this.messageText, jSONObject.optString(CommomUtility.this.messageText));
                this.val$json.onCallback(response.code(), jsonObject);
            } catch (IOException e) {
                Logger.d(CommomUtility.this.logTag, e.getMessage());
            } catch (JSONException e2) {
                Logger.d(CommomUtility.this.logTag, e2.getMessage());
            }
        }
    }

    public void getWorkflowid(Context context, String stateCode, int processingid, int currentStatusId, String Token, String atknBnd, String rtknBnd, final MyCallback myCallback) {
        this.myCallback = myCallback;
        Logger.d(this.logTag, "in house fetch..............................");
        HashMap map = new HashMap();
        map.put("roleCode", this.currentRole);
        map.put("formTypeMasterId", Integer.valueOf(processingid));
        map.put("currentStatusId", Integer.valueOf(currentStatusId));
        Logger.d(this.logTag, "Processing master id : " + processingid);
        Logger.d(this.logTag, "Current status id : " + currentStatusId);
        getRetrofitClient(context, Token, atknBnd, rtknBnd).getWorkflowid(this.currentRole, stateCode, map).enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.55
            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                Logger.d(CommomUtility.this.logTag, "Response code :" + response.code());
                if (response.code() == 200) {
                    CommomUtility commomUtility = CommomUtility.this;
                    commomUtility.jsonobjectform8 = commomUtility.gson.toJsonTree(((JSONArray) response.body()).get(0)).getAsJsonObject();
                    Logger.d(CommomUtility.this.logTag, "workflow id : " + CommomUtility.this.jsonobjectform8.get("workflowConfigId").getAsInt());
                    myCallback.onCallback(response.code(), String.valueOf(CommomUtility.this.jsonobjectform8.get("workflowConfigId").getAsInt()));
                    return;
                }
                myCallback.onCallback(response.code(), "");
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JSONArray> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getDistrictOnAssembly(Context context, String stateCode, String acNo, String Token, String atkn, String rtkn, final ArraylistReturn arraylistReturn) {
        this.arraylistReturn = arraylistReturn;
        Logger.d(this.logTag, "in house fetch..............................");
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getDistrictOnAssembly(Integer.parseInt(acNo), stateCode, Token, atkn, rtkn, "BLOAPP", this.currentRole, stateCode, "ANDROIDMOB").enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.56
            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                Logger.d(CommomUtility.this.logTag, "Response code :" + response.code());
                Logger.d(CommomUtility.this.logTag, "Response body :" + response.body());
                if (response.code() == 200) {
                    for (int i = 0; i < ((JSONArray) response.body()).size(); i++) {
                        JsonObject asJsonObject = CommomUtility.this.gson.toJsonTree(((JSONArray) response.body()).get(i)).getAsJsonObject();
                        arrayList.add(asJsonObject.get("districtName").toString().replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        arrayList2.add(asJsonObject.get("districtCd").toString().replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    }
                    arraylistReturn.onCallback(response.code(), arrayList, arrayList2);
                    return;
                }
                try {
                    new JSONObject(response.errorBody().string());
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JSONArray> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getReasonForObjection(Context context, String Token, String atknBnd, String rtknBnd, final FormData formData) {
        Logger.d(this.logTag, "in reason fetch..............................");
        final ArrayList arrayList = new ArrayList();
        new ArrayList();
        final HashMap map = new HashMap();
        this.formData = formData;
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getReasonForObjection(Token, atknBnd, rtknBnd, "BLOAPP", this.currentRole, "ANDROIDMOB").enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.57
            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                System.out.println("response code " + response.code());
                if (response.code() == 200) {
                    JSONArray jSONArray = (JSONArray) response.body();
                    arrayList.add("Select Reason");
                    for (int i = 0; i < jSONArray.size(); i++) {
                        JsonObject asJsonObject = CommomUtility.this.gson.toJsonTree(jSONArray.get(i)).getAsJsonObject();
                        arrayList.add(String.valueOf(asJsonObject.get(CommomUtility.this.codeDescText)).substring(1, String.valueOf(asJsonObject.get(CommomUtility.this.codeDescText)).length() - 1));
                        map.put(String.valueOf(asJsonObject.get(CommomUtility.this.codeDescText)).substring(1, String.valueOf(asJsonObject.get(CommomUtility.this.codeDescText)).length() - 1), String.valueOf(asJsonObject.get(CommomUtility.this.codeText)).substring(1, String.valueOf(asJsonObject.get(CommomUtility.this.codeText)).length() - 1));
                    }
                    formData.onCallback(arrayList, map, response.code());
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + ((String) arrayList.get(0)));
                    return;
                }
                System.out.println("response code123 " + response.code());
                formData.onCallback(null, null, response.code());
            }

            public void onFailure(Call<JSONArray> call, Throwable t) {
                formData.onCallback(null, null, 505);
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getdetailsofEpicforForm(Context context, String token, String atkn, String rtkn, String ProceedingEpic, MyCallbackjsonTest jsonTest) {
        HashMap map = new HashMap();
        map.put("epicNumber", ProceedingEpic);
        this.jsonTest = jsonTest;
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getEpicForForm8(token, atkn, rtkn, "BLOAPP", this.currentRole, "ANDROIDMOB", map).enqueue(new AnonymousClass58(jsonTest));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.CommomUtility$58, reason: invalid class name */
    class AnonymousClass58 implements Callback<JsonArray> {
        final /* synthetic */ MyCallbackjsonTest val$jsonTest;

        static /* synthetic */ void lambda$onResponse$0() {
        }

        AnonymousClass58(final MyCallbackjsonTest val$jsonTest) {
            this.val$jsonTest = val$jsonTest;
        }

        public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
            if (response.code() == 200) {
                CommomUtility.this.submitArrayResponse = (JsonArray) response.body();
                if (!CommomUtility.this.submitArrayResponse.isEmpty()) {
                    ((JsonArray) response.body()).get(0).get("content");
                    this.val$jsonTest.onCallbacktest(response.code(), CommomUtility.this.submitArrayResponse);
                    new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.CommomUtility$58$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            CommomUtility.AnonymousClass58.lambda$onResponse$0();
                        }
                    }, 1000L);
                    return;
                }
                JsonObject jsonObject = new JsonObject();
                Logger.d(CommomUtility.this.logTag, "In fetchEPICData() -> else part ----> Response Body is null .............................");
                try {
                    jsonObject.addProperty(CommomUtility.this.messageText, "No Data Found in Epic For Form Api.");
                    this.val$jsonTest.onCallbacktest(response.code(), null);
                    return;
                } catch (Exception e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                    return;
                }
            }
            JsonObject jsonObject2 = new JsonObject();
            Logger.d(CommomUtility.this.logTag, "In fetchEPICData() -> else part ----> Response Body is null .............................");
            try {
                jsonObject2.addProperty(CommomUtility.this.messageText, "No Data Found in Epic For Form Api.");
                this.val$jsonTest.onCallbacktest(response.code(), null);
            } catch (Exception e2) {
                Logger.d(CommomUtility.this.logTag, e2.getMessage());
            }
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
        }
    }

    public void submitstatement3(Context context, String stateCode, String Token, HashMap<String, Object> json, FormsResponse myCallback) {
        this.formsResponse = myCallback;
        Logger.d(this.logTag, "Form  statement 3 JSON " + new JSONObject(json));
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).submitstatement3(Token, this.currentRole, stateCode, "application/json", "ANDROIDMOB", json).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.59
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    Logger.d(CommomUtility.this.logTag, "form 6A..............................");
                    JsonObject jsonObject = (JsonObject) response.body();
                    String strValueOf = String.valueOf(jsonObject.get(CommomUtility.this.messageText));
                    Logger.d(CommomUtility.this.logTag, "Reference Id: " + jsonObject.get("refId"));
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + strValueOf);
                    CommomUtility.this.formsResponse.onCallback(response.code(), strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    CommomUtility.this.formsResponse.onCallback(response.code(), jSONObject.optString("cause"));
                    Logger.d(CommomUtility.this.logTag, "" + jSONObject);
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void logOutApi(Context context, String token, String refreshToken, String atknBnd, String rtknBnd, HashMap<String, Object> json, FormsResponse myCallback) {
        this.formsResponse = myCallback;
        Logger.d(this.logTag, "Form  statement 3 JSON " + new JSONObject(json));
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).logoutApi(token, refreshToken, atknBnd, rtknBnd, "BLOAPP", "GARUDA", "application/json", "ANDROIDMOB", json).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.60
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    JsonObject jsonObject = (JsonObject) response.body();
                    String strValueOf = String.valueOf(jsonObject.get(CommomUtility.this.messageText));
                    Logger.d(CommomUtility.this.logTag, "Reference Id: " + jsonObject.get("refId"));
                    Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + strValueOf);
                    CommomUtility.this.formsResponse.onCallback(response.code(), strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, ""));
                    return;
                }
                if (response.code() == 401) {
                    Logger.d(CommomUtility.this.logTag, "Common logOutItem " + response.code());
                    CommomUtility.this.formsResponse.onCallback(response.code(), "");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    CommomUtility.this.formsResponse.onCallback(response.code(), jSONObject.optString("cause"));
                    Logger.d(CommomUtility.this.logTag, "" + jSONObject);
                } catch (IOException e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                } catch (JSONException e2) {
                    Logger.d(CommomUtility.this.logTag, e2.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getGenderWiseElectorsCountHome(String stateCode, String asmblyNO, String partNo, String Token, final Context context) {
        Logger.d(this.logTag, "In getGenderDashboardHome()");
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getGenderWiseElectorsCount(stateCode, asmblyNO, partNo, Token, SharedPref.getInstance(context).getAtknBnd(), SharedPref.getInstance(context).getRtknBnd(), "BLOAPP", this.currentRole, stateCode, "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.61
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    try {
                        JsonObject jsonObject = (JsonObject) response.body();
                        Logger.d(CommomUtility.this.logTag, "In getGenderDashboardHome() - > payload - " + jsonObject);
                        SharedPref.getInstance(context).setGenderWiseElectorsCountHome(new JSONObject(String.valueOf(jsonObject)).getJSONObject("payload").toString());
                    } catch (JSONException e) {
                        Logger.d(CommomUtility.this.logTag, e.getMessage());
                    }
                } else {
                    try {
                        SharedPref.getInstance(context).setGenderWiseElectorsCountHomeResponseMessage(new JSONObject(response.errorBody().string()).optString(CommomUtility.this.messageText));
                    } catch (IOException | JSONException e2) {
                        Logger.d(CommomUtility.this.logTag, e2.getMessage());
                        SharedPref.getInstance(context).setGenderWiseElectorsCountHomeResponseMessage(e2.getMessage());
                    }
                }
                SharedPref.getInstance(context).setGenderWiseElectorsCountHomeResponseCode(response.code());
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getDashChartData(String statecd, String asmblyNO, String partNo, String token, String stateCode, final Context context) {
        Logger.d("getDashChartData", "In getDashChartData()");
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getDashFormCount(statecd, asmblyNO, partNo, token, SharedPref.getInstance(context).getAtknBnd(), SharedPref.getInstance(context).getRtknBnd(), "BLOAPP", this.currentRole, stateCode, "ANDROIDMOB").enqueue(new Callback<EronetResponse>() { // from class: in.gov.eci.bloapp.CommomUtility.62
            public void onResponse(Call<EronetResponse> call, Response<EronetResponse> response) {
                if (response.code() == 200) {
                    JSONArray payload = ((EronetResponse) response.body()).getPayload();
                    Logger.d("In getDashChartData() ", " payload - " + payload);
                    SharedPref.getInstance(context).setDashChartData(payload.toString());
                } else {
                    try {
                        SharedPref.getInstance(context).setDashChartDataResponseMessage(new JSONObject(response.errorBody().string()).optString(CommomUtility.this.messageText));
                    } catch (IOException | JSONException e) {
                        SharedPref.getInstance(context).setDashChartDataResponseMessage(e.getMessage());
                        SharedPref.getInstance(context).setDashChartDataResponseMessage(e.getMessage());
                    }
                }
                SharedPref.getInstance(context).setDashChartDataResponseCode(response.code());
            }

            public void onFailure(Call<EronetResponse> call, Throwable t) {
                Logger.d(CommomUtility.this.onFailureText, t.getMessage());
            }
        });
    }

    public void getRefreshToken(final Context context, String refreshToken, aadharcallback myCallback) {
        this.aadharcallback = myCallback;
        Logger.d("refresh Token", "In getRefreshToken()");
        HashMap map = new HashMap();
        map.put("atkn_bnd", SharedPref.getInstance(context).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(context).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("applicationName", "GARUDA");
        map2.put("PLATFORM-TYPE", "ANDROIDMOB");
        map2.put("refreshToken", refreshToken);
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getRefreshToken(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.63
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    System.out.println("nxjdvbhfvbhfbjnv");
                    String asString = ((JsonObject) response.body()).get("access_token").getAsString();
                    String asString2 = ((JsonObject) response.body()).get("refresh_token").getAsString();
                    SharedPref.getInstance(context).setAtknBnd(((JsonObject) response.body()).get("atkn_bnd").getAsString());
                    SharedPref.getInstance(context).setRtknBnd(((JsonObject) response.body()).get("rtkn_bnd").getAsString());
                    CommomUtility.this.aadharcallback.onCallBack(response.code(), asString, asString2);
                    return;
                }
                System.out.println("nxjdvbhfvbhfbjnv");
                try {
                    CommomUtility.this.aadharcallback.onCallBack(response.code(), String.valueOf(new JSONObject(response.errorBody().string()).get("cause")), "");
                } catch (IOException | JSONException e) {
                    CommomUtility.this.aadharcallback.onCallBack(response.code(), e.getMessage(), "");
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.onFailureText, t.getMessage());
            }
        });
    }

    public void sentOTP(Context context, String token, String atkn, String rtkn, String ProceedingEpic, final MyCallbackjsonTest jsonTest) {
        HashMap map = new HashMap();
        map.put("mobileNo", ProceedingEpic);
        map.put("userId", ProceedingEpic);
        this.jsonTest = jsonTest;
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).sentOTP(token, atkn, rtkn, "BLOAPP", this.currentRole, "ANDROIDMOB", map).enqueue(new Callback<String>() { // from class: in.gov.eci.bloapp.CommomUtility.64
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.code() == 200) {
                    jsonTest.onCallbacktest(response.code(), null);
                    return;
                }
                Logger.d(CommomUtility.this.logTag, "In fetchEPICData() -> else part ----> Response Body is null .............................");
                try {
                    jsonTest.onCallbacktest(response.code(), null);
                } catch (Exception e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                }
            }

            public void onFailure(Call<String> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void verifyOTP(Context context, String token, String atkn, String rtkn, String ProceedingEpic, String otp, aadharcallback myCallback) {
        HashMap map = new HashMap();
        map.put("mobileNo", ProceedingEpic);
        map.put("userId", ProceedingEpic);
        map.put("otp", otp);
        this.aadharcallback = myCallback;
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).verifyOTP(token, atkn, rtkn, "BLOAPP", this.currentRole, "ANDROIDMOB", map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.65
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.code() == 200) {
                    CommomUtility.this.aadharcallback.onCallBack(response.code(), "", ((JsonObject) response.body()).get("message").getAsString());
                    return;
                }
                Logger.d(CommomUtility.this.logTag, "In fetchEPICData() -> else part ----> Response Body is null .............................");
                try {
                    CommomUtility.this.aadharcallback.onCallBack(response.code(), "", String.valueOf(new JSONObject(response.errorBody().string()).get("message")));
                } catch (Exception e) {
                    Logger.d(CommomUtility.this.logTag, e.getMessage());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.d(CommomUtility.this.logTag, CommomUtility.this.onFailureText + t.getMessage());
            }
        });
    }

    public void getAllAC(String oldstate, Context context, final IAcPartListCallback acpartcallback) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("state", oldstate);
        map.put("currentRole", "BLO");
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getAllAssmbly(map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.66
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        org.json.JSONArray jSONArray = new org.json.JSONArray(CommomUtility.this.gson.toJson(((JsonObject) response.body()).get("payload")));
                        arrayList.clear();
                        arrayList2.clear();
                        arrayList2.add("Select Assembly Constituency");
                        arrayList.add(0);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            arrayList2.add(jSONObject.optString("acNo", "") + " - " + jSONObject.optString("acName", ""));
                            arrayList.add(Integer.valueOf(jSONObject.optInt("acNo", 0)));
                        }
                        acpartcallback.onCallBack(response.code(), arrayList, arrayList2);
                        return;
                    }
                    Logger.e("AC List error", String.valueOf(response.code()));
                    arrayList.clear();
                    arrayList2.clear();
                    arrayList2.add("Select Assembly Constituency");
                    arrayList.add(0);
                    acpartcallback.onCallBack(response.code(), arrayList, arrayList2);
                } catch (Exception unused) {
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                Logger.e("AC List", t.getMessage());
            }
        });
    }

    public void getPartByAc(final Context context, int ac, String state, final IAcPartListCallback acPartListCallback) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("state", state);
        map.put("currentRole", "BLO");
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getPartByAc(ac, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.67
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        org.json.JSONArray jSONArray = new org.json.JSONArray(CommomUtility.this.gson.toJson(((JsonObject) response.body()).get("payload")));
                        arrayList2.clear();
                        arrayList.clear();
                        arrayList.add("Select Part");
                        arrayList2.add(0);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            arrayList.add(jSONObject.optString("partNumber", "") + " - " + jSONObject.optString("partName", ""));
                            arrayList2.add(Integer.valueOf(jSONObject.optInt("partNumber", 0)));
                        }
                        acPartListCallback.onCallBack(response.code(), arrayList2, arrayList);
                        return;
                    }
                    arrayList2.clear();
                    arrayList.clear();
                    arrayList.add("Select Part");
                    arrayList2.add(0);
                    acPartListCallback.onCallBack(response.code(), arrayList2, arrayList);
                    Logger.e("Part List error", String.valueOf(response.code()));
                    Toast.makeText(context, "Failed to get Part List", 1).show();
                } catch (Exception unused) {
                }
            }
        });
    }

    public void getAssmblyByDist(final Context context, int district, String state, final IAcPartListCallback districtListCallback) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("state", state);
        map.put("currentRole", "BLO");
        map.put("channelidobo", "BLOAPP");
        map.put("applicationname", "BLOAPP");
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getAssmblyByDist(district, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.68
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        org.json.JSONArray jSONArray = new org.json.JSONArray(CommomUtility.this.gson.toJson(((JsonObject) response.body()).get("payload")));
                        arrayList.clear();
                        arrayList2.clear();
                        arrayList.add("Select Assembly Constituency");
                        arrayList2.add(0);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            arrayList.add(jSONObject.optString("acNo", "") + " - " + jSONObject.optString("acName", ""));
                            arrayList2.add(Integer.valueOf(jSONObject.optInt("acNo", 0)));
                        }
                        districtListCallback.onCallBack(response.code(), arrayList2, arrayList);
                        return;
                    }
                    arrayList.clear();
                    arrayList2.clear();
                    arrayList.add("Select District");
                    arrayList2.add(0);
                    districtListCallback.onCallBack(response.code(), arrayList2, arrayList);
                    Logger.e("District List error", String.valueOf(response.code()));
                    Toast.makeText(context, "Failed to get District List", 1).show();
                } catch (Exception unused) {
                }
            }
        });
    }

    public void callVerifyRelativeApi(final Context context, String token, String atkband, String rtkband, String oldState, String oldAc, String OldPart, String serialnumber, final SearchByAcPartCallback searchByAcPartCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        Logger.d("TAG", "oldstate " + oldState);
        HashMap map2 = new HashMap();
        map2.put("oldStateCd", oldState);
        map2.put("oldAcNo", oldAc);
        map2.put("oldPartNo", OldPart);
        map2.put("oldPartSerialNo", serialnumber);
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getErollData20031(map, map2).enqueue(new Callback<SearchByAcPartModel>() { // from class: in.gov.eci.bloapp.CommomUtility.69
            public void onResponse(Call<SearchByAcPartModel> call, Response<SearchByAcPartModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<Payload> list = ((SearchByAcPartModel) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            searchByAcPartCallback.onCallBack(response.code(), list, "");
                        } else {
                            searchByAcPartCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        searchByAcPartCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    searchByAcPartCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    searchByAcPartCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<SearchByAcPartModel> call, Throwable t) {
                searchByAcPartCallback.onCallBack(0, null, "");
            }
        });
    }

    public void validateSirMapping(final Context context, String token, String state, String atkband, String rtkband, String oldState, String oldAc, String OldPart, String serialnumber, String current_ac_no, String current_part_no, String current_State_code, int currentAge, int oldAge, final ValidateMapCallback validateMapCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("old_state_code", oldState);
        map2.put("old_ac_no", oldAc);
        map2.put("old_part_no", OldPart);
        map2.put("old_part_serial_no", serialnumber);
        map2.put("current_part_no", current_part_no);
        map2.put("current_ac_no", current_ac_no);
        map2.put("current_State_code", current_State_code);
        map2.put("currentAge", String.valueOf(currentAge));
        map2.put("OldAge", String.valueOf(oldAge));
        map2.put("status", "SEARCH");
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).validateSirMapping(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.70
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(((JsonObject) response.body()).toString());
                        validateMapCallback.onCallBack(jSONObject.optString("statusCode"), jSONObject.optString("msg"), jSONObject.optString("bloNumber"), jSONObject.optString("bloName"));
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        validateMapCallback.onCallBack("0", "Something went wrong", null, null);
                        return;
                    }
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(response.errorBody().string());
                    String strOptString = jSONObject2.optString("statusCode");
                    String strOptString2 = jSONObject2.optString("msg");
                    if (TextUtils.isEmpty(strOptString2)) {
                        strOptString2 = jSONObject2.optString("message");
                    }
                    validateMapCallback.onCallBack(strOptString, strOptString2, jSONObject2.optString("bloNumber"), jSONObject2.optString("bloName"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    validateMapCallback.onCallBack("0", "Something went wrong", null, null);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                validateMapCallback.onCallBack("0", "Something went wrong", null, null);
            }
        });
    }

    public void validateProgneySirMapping(final Context context, String token, String state, String atkband, String rtkband, String oldState, String oldAc, String OldPart, String serialnumber, String current_ac_no, String current_part_no, String current_State_code, String progenyName, final ValidateMapCallback validateMapCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("old_Pgstate_code", oldState);
        map2.put("old_Pgac_no", oldAc);
        map2.put("old_Pgpart_no", OldPart);
        map2.put("old_Pgpart_serial_no", serialnumber);
        map2.put("current_part_no", current_part_no);
        map2.put("current_ac_no", current_ac_no);
        map2.put("current_state_cd", current_State_code);
        map2.put("status", "SEARCH");
        map2.put("progenyName", progenyName);
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).validateProgenySirMapping(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.71
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(((JsonObject) response.body()).toString());
                        validateMapCallback.onCallBack(jSONObject.optString("statusCode"), jSONObject.optString("msg"), jSONObject.optString("bloNumber"), jSONObject.optString("bloName"));
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        validateMapCallback.onCallBack("0", "Something went wrong", null, null);
                        return;
                    }
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(response.errorBody().string());
                    validateMapCallback.onCallBack(jSONObject2.optString("statusCode"), jSONObject2.optString("msg"), jSONObject2.optString("bloNumber"), jSONObject2.optString("bloName"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    validateMapCallback.onCallBack("0", "Something went wrong", null, null);
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                validateMapCallback.onCallBack("0", "Something went wrong", null, null);
            }
        });
    }

    public void getSpecialRevisionFormsPanIndia(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final VerifyCitizenListCallbackNew verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getSpecialRevisionFormsPanIndia(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerifyRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.72
            public void onResponse(Call<FormVerifyRoot> call, Response<FormVerifyRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<VerifyPayload> list = ((FormVerifyRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerifyRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getSpecialRevisionFormsPanIndiaByEpicId(final Context context, String token, Long epicId, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final VerifyCitizenListCallback verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("epicId", epicId);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getSpecialRevisionFormsPanIndiaByEpicId(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerificationRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.73
            public void onResponse(Call<FormVerificationRoot> call, Response<FormVerificationRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<FormverificationPayload> list = ((FormVerificationRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerificationRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getSirDistrict(String state, String Token, String atkn, String rtkn, Context context, final ArraylistReturn arraylistReturn) {
        Logger.d(this.logTag, "in getDistrict..............................");
        final ArrayList arrayList = new ArrayList();
        this.districtcode = new ArrayList<>();
        arrayList.clear();
        this.districtcode.clear();
        arrayList.add("Select District");
        this.districtcode.add("0");
        try {
            this.arraylistReturn = arraylistReturn;
            ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getSirDistrict(Token, atkn, rtkn, "BLOAPP", this.currentRole, state).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.CommomUtility.74
                public void onFailure(Call<JsonObject> call, Throwable t) {
                }

                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    Logger.d(CommomUtility.this.logTag, "Response code district " + response.code());
                    if (response.code() == 200) {
                        try {
                            org.json.JSONArray jSONArray = new org.json.JSONArray(CommomUtility.this.gson.toJson(((JsonObject) response.body()).get("payload")));
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                arrayList.add(jSONObject.optString("distName"));
                                CommomUtility.this.districtcode.add(String.valueOf(jSONObject.optInt("districtNo")));
                            }
                            arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.districtcode);
                            Logger.d(CommomUtility.this.logTag, CommomUtility.this.payloadText + ((String) arrayList.get(0)));
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    arraylistReturn.onCallback(response.code(), arrayList, CommomUtility.this.districtcode);
                }
            });
        } catch (Exception e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    public void checkEpic(Context context, String epic, String token, String atkband, String rtkband, String state, final EpicCallBack epicCallBack) {
        HashMap map = new HashMap();
        map.put("epicNumber", epic);
        map.put("stateCd", state);
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).checkEpicNumber(token, atkband, rtkband, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new Callback<ArrayList<CheckEpicRoot>>() { // from class: in.gov.eci.bloapp.CommomUtility.75
            public void onResponse(Call<ArrayList<CheckEpicRoot>> call, Response<ArrayList<CheckEpicRoot>> response) {
                if (response.code() == 200 && response.body() != null) {
                    ArrayList arrayList = (ArrayList) response.body();
                    if (arrayList != null && arrayList.size() > 0) {
                        Content content = ((CheckEpicRoot) arrayList.get(0)).getContent();
                        if (content != null) {
                            epicCallBack.onCallBack(response.code(), content, "");
                            return;
                        } else {
                            epicCallBack.onCallBack(response.code(), null, "No Record Found");
                            return;
                        }
                    }
                    epicCallBack.onCallBack(response.code(), null, "Please check EPIC number");
                    return;
                }
                if (response.code() == 401) {
                    epicCallBack.onCallBack(401, null, "");
                } else if (response.code() == 400) {
                    epicCallBack.onCallBack(400, null, "Bad Request");
                }
            }

            public void onFailure(Call<ArrayList<CheckEpicRoot>> call, Throwable t) {
                epicCallBack.onCallBack(0, null, "");
            }
        });
    }

    public void getSentBackEroAlreadyEf(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, final VerifyCitizenListCallbackNew verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("stCode", state);
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getSentBackEroAlreadyEf(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerifyRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.76
            public void onResponse(Call<FormVerifyRoot> call, Response<FormVerifyRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<VerifyPayload> list = ((FormVerifyRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerifyRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getSentBackEroEfByEpicId(final Context context, String token, Long epicId, String atkband, String rtkband, String state, String oldAc, String OldPart, final VerifyCitizenListCallback verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("epicId", epicId);
        map2.put("stCode", state);
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getSentBackEroEfByEpicId(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerificationRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.77
            public void onResponse(Call<FormVerificationRoot> call, Response<FormVerificationRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<FormverificationPayload> list = ((FormVerificationRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerificationRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getUncollectableRollBackFormsByEpicId(final Context context, String token, Long epicId, String atkband, String rtkband, String state, String oldAc, String OldPart, final UnCollectableCallback verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("epicId", epicId);
        map2.put("stCode", state);
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getUncollectableRollBackFormsByEpicId(state.toLowerCase(), map, map2).enqueue(new Callback<UncollectedDetailsRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.78
            public void onResponse(Call<UncollectedDetailsRoot> call, Response<UncollectedDetailsRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<UncollectableDetailsPayload> list = ((UncollectedDetailsRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<UncollectedDetailsRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getDeceasedList(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final VerifyCitizenListCallbackNew verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getDeceasedList(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerifyRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.79
            public void onResponse(Call<FormVerifyRoot> call, Response<FormVerifyRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<VerifyPayload> list = ((FormVerifyRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerifyRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getDseVerifiedList(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final VerifyCitizenListCallbackNew verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        state.toLowerCase();
        ((UserClient) ApiClient.getClient1(context).create(UserClient.class)).getBloActionDsePseList(map, map2).enqueue(new Callback<FormVerifyRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.80
            public void onResponse(Call<FormVerifyRoot> call, Response<FormVerifyRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<VerifyPayload> list = ((FormVerifyRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerifyRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getDsepseList(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final VerifyCitizenListCallbackNew verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getDsePseElectorList(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerifyRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.81
            public void onResponse(Call<FormVerifyRoot> call, Response<FormVerifyRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<VerifyPayload> list = ((FormVerifyRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerifyRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getElectorListForPSEData(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final PSEListCallbackNew verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getElectorListForPSEData(state.toLowerCase(), map, map2).enqueue(new Callback<PSEVerifyRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.82
            public void onResponse(Call<PSEVerifyRoot> call, Response<PSEVerifyRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<PSEPayload> list = ((PSEVerifyRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<PSEVerifyRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getAnomalyList(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final AnomalyListCallback verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getAnomalyUserListV2(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerifyRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.83
            public void onResponse(Call<FormVerifyRoot> call, Response<FormVerifyRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<VerifyPayload> list = ((FormVerifyRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerifyRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getElectorEfList(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final VerifyCitizenListCallbackNew verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getListOfMoveToDraftElector(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerifyRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.84
            public void onResponse(Call<FormVerifyRoot> call, Response<FormVerifyRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<VerifyPayload> list = ((FormVerifyRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerifyRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getListOfNaCategory(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final VerifyCitizenListCallbackNew verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getListOfNaCategory(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerifyRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.85
            public void onResponse(Call<FormVerifyRoot> call, Response<FormVerifyRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<VerifyPayload> list = ((FormVerifyRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerifyRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getNomappingData(final Context context, String token, Long epicId, String atkband, String rtkband, String state, String oldAc, String OldPart, final VerifyCitizenListCallback verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("epicId", epicId);
        map2.put("stCode", state);
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getNoMappingData(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerificationRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.86
            public void onResponse(Call<FormVerificationRoot> call, Response<FormVerificationRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<FormverificationPayload> list = ((FormVerificationRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerificationRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getDraftData(final Context context, String token, Long epicId, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final VerifyCitizenListCallback verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("epicId", epicId);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getDraftData(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerificationRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.87
            public void onResponse(Call<FormVerificationRoot> call, Response<FormVerificationRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<FormverificationPayload> list = ((FormVerificationRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerificationRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getSelectPhotoList(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final VerifyCitizenListCallbackNew verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getListOfElectorPhoto(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerifyRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.88
            public void onResponse(Call<FormVerifyRoot> call, Response<FormVerifyRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<VerifyPayload> list = ((FormVerifyRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerifyRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getAnomalyDataByEpic(final Context context, String token, Long epicId, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final VerifyCitizenListCallback verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("epicId", epicId);
        map2.put("stCode", state);
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getAnomalyDataByEpic(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerificationRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.89
            public void onResponse(Call<FormVerificationRoot> call, Response<FormVerificationRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<FormverificationPayload> list = ((FormVerificationRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerificationRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getSelectPhotoList1(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final VerifyCitizenListCallbackNew verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        state.toLowerCase();
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getListOfElectorPhoto1(map, map2).enqueue(new Callback<FormVerifyRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.90
            public void onResponse(Call<FormVerifyRoot> call, Response<FormVerifyRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<VerifyPayload> list = ((FormVerifyRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerifyRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getDocumentsidList(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final VerifyCitizenListCallbackNew verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getListOfHearingScheduleEf(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerifyRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.91
            public void onResponse(Call<FormVerifyRoot> call, Response<FormVerifyRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<VerifyPayload> list = ((FormVerifyRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerifyRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getDetails(final Context context, String token, String atkband, String rtkband, String epicnumber, String state, final DetailsOfEpicCallback searchByAcPartCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        map.put("client_id", "SIR-UNCOLLECTABLE-CI");
        map.put("secret_key", "0958a6ff-20b7-4218-9156-50cc6999cc34");
        HashMap map2 = new HashMap();
        map2.put("epicNumber", epicnumber);
        map2.put("stateCd", state);
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getDetailsfromEpic(map, map2).enqueue(new Callback<List<DetailsofEpicRoot>>() { // from class: in.gov.eci.bloapp.CommomUtility.92
            public void onResponse(Call<List<DetailsofEpicRoot>> call, Response<List<DetailsofEpicRoot>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<DetailsofEpicRoot> list = (List) response.body();
                        if (list != null && list.size() > 0) {
                            searchByAcPartCallback.onCallBack(response.code(), list, "");
                        } else {
                            searchByAcPartCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        searchByAcPartCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    searchByAcPartCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    searchByAcPartCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<List<DetailsofEpicRoot>> call, Throwable t) {
                searchByAcPartCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getUploadAttendenceList(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final VerifyCitizenListCallbackNew verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getListOfuploadAttendence(state.toLowerCase(), map, map2).enqueue(new Callback<FormVerifyRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.93
            public void onResponse(Call<FormVerifyRoot> call, Response<FormVerifyRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<VerifyPayload> list = ((FormVerifyRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<FormVerifyRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void callErollData(final Context context, String token, String atkband, String rtkband, String oldState, String oldAc, String OldPart, String serialnumber, final ErollDataCallback searchByAcPartCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        Logger.d("TAG", "oldstate " + oldState);
        HashMap map2 = new HashMap();
        map2.put("stateCd", oldState);
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("partSerialNo", serialnumber);
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getErollDatafinal(map, map2).enqueue(new Callback<ErollDataModel>() { // from class: in.gov.eci.bloapp.CommomUtility.94
            public void onResponse(Call<ErollDataModel> call, Response<ErollDataModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<PayloadNewMapping> list = ((ErollDataModel) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            searchByAcPartCallback.onCallBack(response.code(), list, "");
                        } else {
                            searchByAcPartCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        searchByAcPartCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    searchByAcPartCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    searchByAcPartCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<ErollDataModel> call, Throwable t) {
                searchByAcPartCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getListforUpdateMobile(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, String key, final UpdateMobileCallback verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("stCode", state);
        if (!TextUtils.isEmpty(key)) {
            map2.put("key", key);
        }
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getListofElectorMobile(state.toLowerCase(), map, map2).enqueue(new Callback<UpdateMobileRoot>() { // from class: in.gov.eci.bloapp.CommomUtility.95
            public void onResponse(Call<UpdateMobileRoot> call, Response<UpdateMobileRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<UpdateMobilePayload> list = ((UpdateMobileRoot) response.body()).payload;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<UpdateMobileRoot> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getAllAC2025(String state, String Token, String atkn, String rtkn, Context context, final IAcPartListCallback acpartcallback) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getConstituency2025(state, Token, atkn, rtkn, "BLOAPP", this.currentRole, "application/vnd.common.api.v2+json").enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.96
            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        org.json.JSONArray jSONArray = new org.json.JSONArray(CommomUtility.this.gson.toJson(response.body()));
                        arrayList.clear();
                        arrayList2.clear();
                        arrayList2.add("Select Assembly Constituency");
                        arrayList.add(0);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            arrayList2.add(jSONObject.optInt("asmblyNo", 0) + " - " + jSONObject.optString("asmblyName", ""));
                            arrayList.add(Integer.valueOf(jSONObject.optInt("asmblyNo", 0)));
                        }
                        ArrayList arrayList3 = arrayList2;
                        ArrayList arrayList4 = new ArrayList(arrayList3.subList(1, arrayList3.size()));
                        Collections.sort(arrayList4, new Comparator<String>() { // from class: in.gov.eci.bloapp.CommomUtility.96.1
                            @Override // java.util.Comparator
                            public int compare(String s1, String s2) {
                                return Integer.compare(Integer.parseInt(s1.split("-")[0].trim()), Integer.parseInt(s2.split("-")[0].trim()));
                            }
                        });
                        arrayList2.clear();
                        arrayList2.add("Select Assembly Constituency");
                        arrayList2.addAll(arrayList4);
                        Collections.sort(arrayList);
                        acpartcallback.onCallBack(response.code(), arrayList, arrayList2);
                        return;
                    }
                    Logger.e("AC List error", String.valueOf(response.code()));
                    arrayList.clear();
                    arrayList2.clear();
                    arrayList2.add("Select Assembly Constituency");
                    arrayList.add(0);
                    acpartcallback.onCallBack(response.code(), arrayList, arrayList2);
                } catch (Exception e) {
                    Log.e("error@acsort", e.getMessage());
                }
            }

            public void onFailure(Call<JSONArray> call, Throwable t) {
                Logger.e("AC List", t.getMessage());
            }
        });
    }

    public void getPartByAc2025(final Context context, int ac, String state, String Token, String atkn, String rtkn, final IAcPartListCallback acPartListCallback) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        ((UserClient) ApiClient.getClient(context).create(UserClient.class)).getPartbyACState(String.valueOf(ac), state, Token, atkn, rtkn, "BLOAPP", this.currentRole, state).enqueue(new Callback<JSONArray>() { // from class: in.gov.eci.bloapp.CommomUtility.97
            public void onFailure(Call<JSONArray> call, Throwable t) {
            }

            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        org.json.JSONArray jSONArray = new org.json.JSONArray(CommomUtility.this.gson.toJson(response.body()));
                        arrayList2.clear();
                        arrayList.clear();
                        arrayList.add("Select Part");
                        arrayList2.add(0);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            arrayList.add(jSONObject.optInt("partNumber", 0) + " - " + jSONObject.optString("partName", ""));
                            arrayList2.add(Integer.valueOf(jSONObject.optInt("partNumber", 0)));
                        }
                        ArrayList arrayList3 = arrayList;
                        ArrayList arrayList4 = new ArrayList(arrayList3.subList(1, arrayList3.size()));
                        Collections.sort(arrayList4, new Comparator<String>() { // from class: in.gov.eci.bloapp.CommomUtility.97.1
                            @Override // java.util.Comparator
                            public int compare(String s1, String s2) {
                                return Integer.compare(Integer.parseInt(s1.split("-")[0].trim()), Integer.parseInt(s2.split("-")[0].trim()));
                            }
                        });
                        arrayList.clear();
                        arrayList.add("Select Part");
                        arrayList.addAll(arrayList4);
                        Collections.sort(arrayList2);
                        acPartListCallback.onCallBack(response.code(), arrayList2, arrayList);
                        return;
                    }
                    arrayList2.clear();
                    arrayList.clear();
                    arrayList.add("Select Part");
                    arrayList2.add(0);
                    acPartListCallback.onCallBack(response.code(), arrayList2, arrayList);
                    Logger.e("Part List error", String.valueOf(response.code()));
                    Toast.makeText(context, "Failed to get Part List", 1).show();
                } catch (Exception unused) {
                }
            }
        });
    }

    public void getFVRPending(final Context context, String token, String atkband, String rtkband, String state, String oldAc, String OldPart, int key, final FormatCListCallback verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("acNo", oldAc);
        map2.put("partNo", OldPart);
        map2.put("pageNumber", 0);
        map2.put("pageSize", 2000);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(key));
        map2.put("statusID", arrayList);
        state.toLowerCase();
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getFVRPending(map, map2).enqueue(new Callback<Root>() { // from class: in.gov.eci.bloapp.CommomUtility.98
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<in.gov.eci.bloapp.views.activity.newsir.model.formatc.Content> list = ((Root) response.body()).content;
                        if (list != null && list.size() > 0) {
                            verifyCitizenListCallback.onCallBack(response.code(), list, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<Root> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void getDetailsByEpicOrRefno(final Context context, String token, String atkband, String rtkband, String state, String formtype, String refno, String key, final FormatCDetailsCallback verifyCitizenListCallback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("currentRole", "blo");
        map.put("state", state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", atkband);
        map.put("rtkn_bnd", rtkband);
        map.put("channelidobo", "BLOAPP");
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).getDetailsByEpicOrRefno(formtype, refno, map).enqueue(new Callback<in.gov.eci.bloapp.views.activity.newsir.model.formatcdetails.Root>() { // from class: in.gov.eci.bloapp.CommomUtility.99
            public void onResponse(Call<in.gov.eci.bloapp.views.activity.newsir.model.formatcdetails.Root> call, Response<in.gov.eci.bloapp.views.activity.newsir.model.formatcdetails.Root> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        in.gov.eci.bloapp.views.activity.newsir.model.formatcdetails.Root root = (in.gov.eci.bloapp.views.activity.newsir.model.formatcdetails.Root) response.body();
                        if (root != null) {
                            verifyCitizenListCallback.onCallBack(response.code(), root, "");
                        } else {
                            verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        }
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        Toast.makeText(context, "Something went wrong", 1).show();
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<in.gov.eci.bloapp.views.activity.newsir.model.formatcdetails.Root> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void formatCSubmit(Context context, HashMap<String, String> header, Map<String, Object> body, final FormatCListCallback verifyCitizenListCallback) {
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).formatCSubmit(header, body).enqueue(new Callback<Void>() { // from class: in.gov.eci.bloapp.CommomUtility.100
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    try {
                        verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<Void> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }

    public void submitForm(Context context, HashMap<String, String> header, Map<String, Object> body, final FormatCListCallback verifyCitizenListCallback) {
        ((UserClient) ApiClient.getClient2(context).create(UserClient.class)).updateRefNoInFormatC(header, body).enqueue(new Callback<Void>() { // from class: in.gov.eci.bloapp.CommomUtility.101
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    try {
                        verifyCitizenListCallback.onCallBack(response.code(), null, "No Record Found");
                        return;
                    } catch (Exception e) {
                        Logger.e(" List", e.getMessage());
                        verifyCitizenListCallback.onCallBack(response.code(), null, "Something went wrong");
                        return;
                    }
                }
                try {
                    verifyCitizenListCallback.onCallBack(response.code(), null, new JSONObject(response.errorBody().string()).getString("message"));
                } catch (Exception e2) {
                    Logger.d("TAG", e2.toString());
                    verifyCitizenListCallback.onCallBack(response.code(), null, "");
                }
            }

            public void onFailure(Call<Void> call, Throwable t) {
                verifyCitizenListCallback.onCallBack(0, null, "");
            }
        });
    }
}
