package in.gov.eci.bloapp.views.activity.sir.enumerationForm;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.model.SIR.SpecialSurveyRevisionModel;
import in.gov.eci.bloapp.room.database.SIRDatabaseHelper;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SirUploadWorker extends Worker {
    private static final String SESSION = "Session Expired. Please Login again.";
    String IRFlag;
    String IRref;
    String IRref2;
    String TAG;
    String aadharNo;
    String alertText;
    String annexureCUrl;
    private String asmblyNO;
    private String atkband;
    String bloOverriddenFlag;
    private String bloPhone;
    String citizenCat;
    String citizenshiptype;
    CommomUtility commomUtility;
    String createdBy;
    List<String> dbFiles;
    String district;
    String dobverified;
    String documentFlag;
    String efPage1;
    String efPage2;
    String electorPhoto;
    String epic;
    Long epicId;
    String erollDob;
    String fatherEpic;
    String fatherNationality;
    String fatherOldAc;
    String fatherOldPart;
    String fatherOldPsl;
    List<SpecialSurveyRevisionModel> formList;
    String house;
    String isRelativeFlag;
    String isThisYou;
    String isThisYouRel;
    String list1Code;
    String list1ref;
    String list1ref2;
    String list2code;
    String list2ref;
    String list2ref2;
    String list3code;
    String list3ref;
    String list3ref2;
    String list4code;
    String list4ref;
    String list4ref2;
    String list5code;
    String list5ref;
    String list5ref2;
    String list5ref3;
    String list6code;
    String list6ref;
    String list6ref2;
    String list7code;
    String list7ref;
    String list7ref2;
    String list8code;
    String mobileNo;
    String motherEpic;
    String motherNationality;
    String motherOldAc;
    String motherOldPart;
    String motherOldPsl;
    String oldAc;
    String oldPart;
    String oldpsl;
    private String partNo;
    private String refreshToken;
    String relationDocType;
    String relationDocUrlPg1;
    String relationDocUrlPg2;
    String relationEpicNo;
    String relationOldAcNo;
    String relationOldPartNo;
    String relationOldPslNo;
    String relationProofDocUrlPg1;
    String relationProofDocUrlPg2;
    String relationType;
    private String rtkband;
    String serial;
    SIRDatabaseHelper sirDatabaseHelper;
    String spouseEpic;
    private String state;
    String submitFlag;
    String surveychannel;
    private String token;

    public SirUploadWorker(Context context, WorkerParameters params) {
        super(context, params);
        this.TAG = "SirUploadWorkerTAG";
        this.alertText = "Alert";
        this.commomUtility = new CommomUtility();
        this.dbFiles = new ArrayList();
    }

    public ListenableWorker.Result doWork() {
        String str;
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.district = SharedPref.getInstance(getApplicationContext()).getDistrictCode();
        String userName = SharedPref.getInstance(getApplicationContext()).getUserName();
        this.bloPhone = userName;
        Log.d(this.TAG, userName);
        SIRDatabaseHelper db = SIRDatabaseHelper.getDB(getApplicationContext());
        this.sirDatabaseHelper = db;
        this.formList = db.SpecialRevisionDao().getSpecialSurveyRevisionDetails(this.partNo);
        Boolean bool = false;
        for (int i = 0; i < this.formList.size(); i++) {
            if (this.formList.get(i).getRequestStatusCode() == 200 || this.formList.get(i).getRequestStatusCode() == 510 || this.formList.get(i).getRequestStatusCode() == 401) {
                getAllData(i);
                this.token = SharedPref.getInstance(getApplicationContext()).getToken();
                this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
                boolean z = true;
                ArrayList arrayList = new ArrayList(Arrays.asList(this.efPage1, this.efPage2, this.electorPhoto, this.IRref, this.IRref2, this.list1ref, this.list1ref2, this.list2ref, this.list2ref2, this.list3ref, this.list3ref2, this.list4ref, this.list4ref2, this.list5ref, this.list5ref2, this.list5ref3, this.list6ref, this.list6ref2, this.list7ref, this.list7ref2, this.relationDocUrlPg1, this.relationDocUrlPg2, this.relationProofDocUrlPg1, this.relationProofDocUrlPg2));
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (arrayList.get(i2) != null && !((String) arrayList.get(i2)).isEmpty() && !((String) arrayList.get(i2)).contains("SR_FORM")) {
                        File file = new File(getApplicationContext().getExternalFilesDir(null) + "GARUDA", (String) arrayList.get(i2));
                        this.dbFiles.add(String.valueOf(file));
                        String strSubstring = ((String) arrayList.get(i2)).substring(((String) arrayList.get(i2)).lastIndexOf("."));
                        if (".jpg".equalsIgnoreCase(strSubstring) || ".png".equalsIgnoreCase(strSubstring) || ".jpeg".equalsIgnoreCase(strSubstring)) {
                            str = "image/jpeg";
                        } else if (!".pdf".equalsIgnoreCase(strSubstring)) {
                            str = "";
                        } else {
                            str = "application/pdf";
                        }
                        if (!upload((String) arrayList.get(i2), null, str, file.getAbsolutePath(), this.formList.get(i).getEpic_no(), strSubstring, i2, i)) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SirUploadWorker$$ExternalSyntheticLambda1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$doWork$0();
                                }
                            });
                            bool = true;
                            z = false;
                            break;
                        }
                        if (file.exists()) {
                            if (file.delete()) {
                                Logger.d("Delete", "File deleted successfully");
                            } else {
                                Logger.d("Delete", "File not deleted successfully");
                            }
                        }
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SirUploadWorker$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$doWork$1();
                            }
                        });
                    }
                }
                if (z) {
                    if (this.formList.get(i).getTabName().equalsIgnoreCase("fillTab")) {
                        submit(this.formList.get(i));
                    } else if (this.formList.get(i).getTabName().equalsIgnoreCase("Citizen")) {
                        verifyByCitizen(this.formList.get(i));
                    } else if (this.formList.get(i).getTabName().equalsIgnoreCase("Reverify") || this.formList.get(i).getTabName().equalsIgnoreCase("sentBack")) {
                        Reverify(this.formList.get(i));
                    }
                }
            }
        }
        if (bool.booleanValue()) {
            return ListenableWorker.Result.retry();
        }
        return ListenableWorker.Result.success();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doWork$0() {
        Toast.makeText(getApplicationContext(), "Something went wrong", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doWork$1() {
        Toast.makeText(getApplicationContext(), "Sync in progress", 0).show();
    }

    private boolean isFolderSafeToDelete(File folder, SIRDatabaseHelper db) {
        File[] fileArrListFiles = folder.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file : fileArrListFiles) {
                if (!this.dbFiles.contains(file.getAbsolutePath())) {
                    return false;
                }
            }
        }
        return true;
    }

    private void deleteFolder(File folder) {
        if (folder == null || !folder.exists()) {
            return;
        }
        File[] fileArrListFiles = folder.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isDirectory()) {
                    deleteFolder(file);
                } else {
                    file.delete();
                }
            }
        }
        folder.delete();
    }

    private boolean upload(String filename, String uuid, String mime, String filePath, String epicNo, String extension, int code, int pos) {
        try {
            System.out.println("Inside upload filename : " + filename + " uuid : " + uuid);
            HashMap<String, String> map = new HashMap<>();
            map.put("Authorization", this.token);
            map.put("currentRole", "blo");
            map.put("state", this.state);
            map.put("Content-Type", "application/json");
            map.put("userId", this.bloPhone);
            String mD5Checksum = getMD5Checksum(new File(filePath));
            HashMap map2 = new HashMap();
            map2.put("epicNo", epicNo);
            map2.put("state", this.state);
            map2.put("acNo", this.asmblyNO);
            map2.put("partNo", this.partNo);
            map2.put("checksum", mD5Checksum);
            map2.put("uuid", uuid);
            map2.put("fileName", filename);
            map2.put("ext", extension);
            Logger.d(this.TAG, map2.toString());
            Response responseExecute = ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).requestSirUploadUrl(map, map2).execute();
            if (!responseExecute.isSuccessful()) {
                if (responseExecute.code() == 401) {
                    this.commomUtility.getRefreshToken(getApplicationContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SirUploadWorker$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str, String str2) {
                            this.f$0.lambda$upload$2(i, str, str2);
                        }
                    });
                    upload(filename, uuid, mime, filePath, epicNo, extension, code, pos);
                } else if (responseExecute.code() == 429) {
                    JsonResponse jsonResponse = (JsonResponse) new Gson().fromJson(responseExecute.errorBody().string(), JsonResponse.class);
                    if (jsonResponse.getPayload() != null) {
                        Object payload = jsonResponse.getPayload();
                        String refId = jsonResponse.getRefId();
                        if (payload instanceof Map) {
                            Map map3 = (Map) payload;
                            Double d = (Double) map3.get("retryTime");
                            String str = (String) map3.get("fileName");
                            Long lValueOf = Long.valueOf(Math.round(d.doubleValue() * 1000.0d));
                            System.out.println("Retry time : " + lValueOf);
                            Thread.sleep(lValueOf.longValue());
                            return upload(str, refId, mime, filePath, epicNo, extension, code, pos);
                        }
                    }
                }
                return false;
            }
            if (responseExecute.code() == 200) {
                Object payload2 = ((JsonResponse) responseExecute.body()).getPayload();
                if (payload2 instanceof Map) {
                    Map map4 = (Map) payload2;
                    String strDecryptUrl = decryptUrl((String) map4.get("presignedUrl"));
                    String str2 = (String) map4.get("fileName");
                    switch (code) {
                        case 0:
                            this.formList.get(pos).setSr_form_page_1_url(str2);
                            break;
                        case 1:
                            this.formList.get(pos).setSr_form_page_2_url(str2);
                            break;
                        case 2:
                            this.formList.get(pos).setPhoto_url(str2);
                            break;
                        case 3:
                            this.formList.get(pos).setPre_revision_voter_doc_url(str2);
                            break;
                        case 4:
                            this.formList.get(pos).setPre_revision_voter_doc_url_pg2(str2);
                            break;
                        case 5:
                            this.formList.get(pos).setList_1_doc_url(str2);
                            break;
                        case 6:
                            this.formList.get(pos).setList_1_doc_url_pg2(str2);
                            break;
                        case 7:
                            this.formList.get(pos).setList_2_doc_url(str2);
                            break;
                        case 8:
                            this.formList.get(pos).setList_2_doc_url_pg2(str2);
                            break;
                        case 9:
                            this.formList.get(pos).setList_3_doc_url(str2);
                            break;
                        case 10:
                            this.formList.get(pos).setList_3_doc_url_pg2(str2);
                            break;
                        case 11:
                            this.formList.get(pos).setList_4_doc_url(str2);
                            break;
                        case 12:
                            this.formList.get(pos).setList_4_doc_url_pg2(str2);
                            break;
                        case 13:
                            this.formList.get(pos).setList_5_doc_url(str2);
                            break;
                        case 14:
                            this.formList.get(pos).setList_5_doc_url_pg2(str2);
                            break;
                        case 15:
                            this.formList.get(pos).setList_5_doc_url_pg3(str2);
                            break;
                        case 16:
                            this.formList.get(pos).setList_6_doc_url(str2);
                            break;
                        case 17:
                            this.formList.get(pos).setList_6_doc_url_pg2(str2);
                            break;
                        case 18:
                            this.formList.get(pos).setList_7_doc_url(str2);
                            break;
                        case 19:
                            this.formList.get(pos).setList_7_doc_url_pg2(str2);
                            break;
                        case 20:
                            this.formList.get(pos).setRelationDocUrlPg1(str2);
                            break;
                        case 21:
                            this.formList.get(pos).setRelationDocUrlPg2(str2);
                            break;
                        case 22:
                            this.formList.get(pos).setRelationProofDocUrlPg1(str2);
                            break;
                        case 23:
                            this.formList.get(pos).setRelationProofDocUrlPg2(str2);
                            break;
                    }
                    this.sirDatabaseHelper.SpecialRevisionDao().updateSpecialSurveyRevisionDetails(this.formList.get(pos));
                    return uploadToS3(filePath, mime, strDecryptUrl);
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$upload$2(int i, String str, String str2) {
        if (i == 401 || i == 400) {
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(getApplicationContext()).setRefreshToken(str2);
        SharedPref.getInstance(getApplicationContext()).setToken(this.token);
    }

    private boolean uploadToS3(String filePath, String mime, String preSignedUrl) {
        OkHttpClient okHttpClient = new OkHttpClient();
        File file = new File(filePath);
        try {
            okhttp3.Response responseExecute = okHttpClient.newCall(new Request.Builder().url(preSignedUrl).put(RequestBody.create(file, MediaType.parse(mime))).addHeader("x-amz-checksum-sha256", getMD5Checksum(file)).build()).execute();
            try {
                if (!responseExecute.isSuccessful()) {
                    Logger.e("S3", "S3 error: " + responseExecute.code());
                    if (responseExecute != null) {
                        responseExecute.close();
                    }
                    return false;
                }
                Logger.d("S3", "Upload successful");
                if (responseExecute == null) {
                    return true;
                }
                responseExecute.close();
                return true;
            } catch (Throwable th) {
                if (responseExecute != null) {
                    try {
                        responseExecute.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            Logger.e("S3", "Upload failed: " + e.getMessage());
            return false;
        }
    }

    public static String getMD5Checksum(File file) {
        String strEncodeToString;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                if (Build.VERSION.SDK_INT >= 33) {
                    strEncodeToString = Base64.getEncoder().encodeToString(messageDigest.digest(fileInputStream.readAllBytes()));
                } else {
                    strEncodeToString = Base64.getEncoder().encodeToString(messageDigest.digest(toByteArray(fileInputStream)));
                }
                fileInputStream.close();
                return strEncodeToString;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = input.read(bArr, 0, 1024);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static SecretKey convertStringToSecretKey(String encodedKey) {
        byte[] bArrDecode = Base64.getDecoder().decode(encodedKey);
        return new SecretKeySpec(bArrDecode, 0, bArrDecode.length, "AES");
    }

    private static GCMParameterSpec generateGcm() {
        return new GCMParameterSpec(128, new byte[16]);
    }

    public String decryptUrl(String cipherText) {
        try {
            String strDecrypt = decrypt("AES/GCM/NoPadding", cipherText, convertStringToSecretKey("P79vtNtk/WZaAXsQKCHClA=="), generateGcm());
            if (strDecrypt.length() < 20 || strDecrypt == null) {
                return null;
            }
            return strDecrypt.substring(14, strDecrypt.length() - 6);
        } catch (Exception unused) {
            System.out.println("decryption failed");
            return null;
        }
    }

    private static String decrypt(String algorithm, String cipherText, SecretKey key, GCMParameterSpec gcmParameterSpec) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(2, key, gcmParameterSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
        } catch (Exception unused) {
            return null;
        }
    }

    public void submit(SpecialSurveyRevisionModel specialSurveyRevisionModel) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        HashMap map2 = new HashMap();
        map2.put("epicNo", this.epic);
        map2.put("epicId", this.epicId);
        map2.put("stCode", this.state);
        map2.put("houseNo", this.house);
        map2.put("dobVerified", this.dobverified);
        map2.put("erollDob", this.erollDob);
        map2.put("districtCd", this.district);
        map2.put("acNo", this.asmblyNO);
        map2.put("partNo", this.partNo);
        map2.put("partSerialNo", this.serial);
        map2.put("createdBy", "BLO");
        map2.put("modifiedDttm", null);
        map2.put("modifiedBy", null);
        map2.put("photoUrl", specialSurveyRevisionModel.getPhoto_url());
        map2.put("srFormPage1Url", specialSurveyRevisionModel.getSr_form_page_1_url());
        map2.put("citizenshipType", this.citizenshiptype);
        map2.put("citizenshipTypeCat", this.citizenCat);
        map2.put("surveyChannel", "BLO");
        map2.put("list1Doc", this.list1Code);
        map2.put("list2Doc", this.list2code);
        map2.put("list3Doc", this.list3code);
        map2.put("list4Doc", this.list4code);
        map2.put("list5Doc", this.list5code);
        map2.put("list6Doc", this.list6code);
        map2.put("list7Doc", this.list7code);
        map2.put("list1DocUrl", specialSurveyRevisionModel.getList_1_doc_url());
        map2.put("list2DocUrl", specialSurveyRevisionModel.getList_2_doc_url());
        map2.put("list3DocUrl", specialSurveyRevisionModel.getList_3_doc_url());
        map2.put("list4DocUrl", specialSurveyRevisionModel.getList_4_doc_url());
        map2.put("list5DocUrl", specialSurveyRevisionModel.getList_5_doc_url());
        map2.put("list6DocUrl", specialSurveyRevisionModel.getList_6_doc_url());
        map2.put("list7DocUrl", specialSurveyRevisionModel.getList_7_doc_url());
        map2.put("list1docUrlPg2", specialSurveyRevisionModel.getList_1_doc_url_pg2());
        map2.put("list2docUrlPg2", specialSurveyRevisionModel.getList_2_doc_url_pg2());
        map2.put("list3docUrlPg2", specialSurveyRevisionModel.getList_3_doc_url_pg2());
        map2.put("list4docUrlPg2", specialSurveyRevisionModel.getList_4_doc_url_pg2());
        map2.put("list5docUrlPg2", specialSurveyRevisionModel.getList_5_doc_url_pg2());
        map2.put("list6docUrlPg2", specialSurveyRevisionModel.getList_6_doc_url_pg2());
        map2.put("list7docUrlPg2", specialSurveyRevisionModel.getList_7_doc_url_pg2());
        map2.put("list5docUrlPg3", specialSurveyRevisionModel.getList_5_doc_url_pg3());
        map2.put("aadharNo", this.aadharNo);
        map2.put("mobileNo", this.mobileNo);
        map2.put("fathersOrGuardianName", null);
        map2.put("fathersOrGuardianEpicNo", this.fatherEpic);
        map2.put("mothersName", null);
        map2.put("mothersEpicNo", this.motherEpic);
        map2.put("spouseName", null);
        map2.put("spouseEpicNo", this.spouseEpic);
        map2.put("annexureCUrl", null);
        map2.put("preRevisionVoterFlg", this.IRFlag);
        map2.put("preRevisionVoterDocUrl", specialSurveyRevisionModel.getPre_revision_voter_doc_url());
        map2.put("preRevisionVoterDocUrlPg2", specialSurveyRevisionModel.getPre_revision_voter_doc_url_pg2());
        map2.put("submittedForRecommendation", this.submitFlag);
        map2.put("fathersNationality", this.fatherNationality);
        map2.put("mothersNationality", this.motherNationality);
        map2.put("srFormPage2Url", specialSurveyRevisionModel.getSr_form_page_2_url());
        map2.put("oldAcNo", this.oldAc);
        map2.put("oldPartNo", this.oldPart);
        map2.put("oldPslNo", this.oldpsl);
        map2.put("list8Doc", this.list8code);
        map2.put("moldAcNo", this.motherOldAc);
        map2.put("moldPartNo", this.motherOldPart);
        map2.put("moldPslNo", this.motherOldPsl);
        map2.put("foldAcNo", this.fatherOldAc);
        map2.put("foldPartNo", this.fatherOldPart);
        map2.put("foldPslNo", this.fatherOldPsl);
        map2.put("documentUploadedFlg", this.documentFlag);
        map2.put("relationOldAcNo", this.relationOldAcNo);
        map2.put("relationOldPartNo", this.relationOldPartNo);
        map2.put("relationOldPslNo", this.relationOldPslNo);
        map2.put("relationDocType", this.relationDocType);
        map2.put("relationDocUrlPg1", specialSurveyRevisionModel.getRelationDocUrlPg1());
        map2.put("relationDocUrlPg2", specialSurveyRevisionModel.getRelationDocUrlPg2());
        map2.put("isRelativePreVoterFlg", this.isRelativeFlag);
        map2.put("relationProofDocUrlPg1", specialSurveyRevisionModel.getRelationProofDocUrlPg1());
        map2.put("relationProofDocUrlPg2", specialSurveyRevisionModel.getRelationProofDocUrlPg2());
        map2.put("relationType", this.relationType);
        map2.put("relationEpicNo", this.relationEpicNo);
        map2.put("isThisYouRel", this.isThisYouRel);
        map2.put("isThisYou", this.isThisYou);
        map2.put("oldStateCd", specialSurveyRevisionModel.getOldStateCd());
        map2.put("relationOldStateCd", specialSurveyRevisionModel.getRelationOldStateCd());
        Logger.d(this.TAG, map2.toString());
        ((UserClient) ApiClient.getClient1(getApplicationContext()).create(UserClient.class)).submitSpecialRevisionSIR(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SirUploadWorker.1
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (!response.isSuccessful()) {
                        String string = new JSONObject(response.errorBody().string()).getString("message");
                        Toast.makeText(SirUploadWorker.this.getApplicationContext(), string, 1).show();
                        SirUploadWorker.this.sirDatabaseHelper.SpecialRevisionDao().UpdateErrorMessage(SirUploadWorker.this.epicId, string, response.code());
                    } else if (response.code() == 200) {
                        Toast.makeText(SirUploadWorker.this.getApplicationContext(), "Form submitted successfully", 1).show();
                        SirUploadWorker.this.sirDatabaseHelper.SpecialRevisionDao().deleteSpecialSurveyRevisionDetails(SirUploadWorker.this.epicId);
                        SirUploadWorker.this.deleteLocalFolder();
                    }
                } catch (Exception e) {
                    Logger.d("SIRUploadWorker", e.toString());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (t instanceof IOException) {
                    SirUploadWorker.this.sirDatabaseHelper.SpecialRevisionDao().UpdateErrorMessage(SirUploadWorker.this.epicId, SirUploadWorker.this.getApplicationContext().getResources().getString(R.string.network_error), 510);
                }
            }
        });
    }

    public void deleteLocalFolder() {
        if (this.sirDatabaseHelper.SpecialRevisionDao().getAllFormsFromDB() == 0) {
            File file = new File(getApplicationContext().getExternalFilesDir(null) + "GARUDA");
            if (isFolderSafeToDelete(file, this.sirDatabaseHelper)) {
                deleteFolder(file);
                Logger.d("Delete Files", "File deleted successfully");
            }
        }
    }

    public void verifyByCitizen(SpecialSurveyRevisionModel specialSurveyRevisionModel) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        HashMap map2 = new HashMap();
        map2.put("epicNo", this.epic);
        map2.put("epicId", this.epicId);
        map2.put("stCode", this.state);
        map2.put("houseNo", this.house);
        map2.put("dobVerified", this.dobverified);
        map2.put("erollDob", this.erollDob);
        map2.put("districtCd", this.district);
        map2.put("acNo", this.asmblyNO);
        map2.put("partNo", this.partNo);
        map2.put("partSerialNo", this.serial);
        map2.put("createdBy", this.createdBy);
        map2.put("modifiedDttm", "");
        map2.put("modifiedBy", "BLO");
        map2.put("photoUrl", specialSurveyRevisionModel.getPhoto_url());
        map2.put("srFormPage1Url", specialSurveyRevisionModel.getSr_form_page_1_url());
        map2.put("citizenshipType", this.citizenshiptype);
        map2.put("citizenshipTypeCat", this.citizenCat);
        map2.put("surveyChannel", this.surveychannel);
        map2.put("list1Doc", this.list1Code);
        map2.put("list2Doc", this.list2code);
        map2.put("list3Doc", this.list3code);
        map2.put("list4Doc", this.list4code);
        map2.put("list5Doc", this.list5code);
        map2.put("list6Doc", this.list6code);
        map2.put("list7Doc", this.list7code);
        map2.put("list1DocUrl", specialSurveyRevisionModel.getList_1_doc_url());
        map2.put("list2DocUrl", specialSurveyRevisionModel.getList_2_doc_url());
        map2.put("list3DocUrl", specialSurveyRevisionModel.getList_3_doc_url());
        map2.put("list4DocUrl", specialSurveyRevisionModel.getList_4_doc_url());
        map2.put("list5DocUrl", specialSurveyRevisionModel.getList_5_doc_url());
        map2.put("list6DocUrl", specialSurveyRevisionModel.getList_6_doc_url());
        map2.put("list7DocUrl", specialSurveyRevisionModel.getList_7_doc_url());
        map2.put("list1docUrlPg2", specialSurveyRevisionModel.getList_1_doc_url_pg2());
        map2.put("list2docUrlPg2", specialSurveyRevisionModel.getList_2_doc_url_pg2());
        map2.put("list3docUrlPg2", specialSurveyRevisionModel.getList_3_doc_url_pg2());
        map2.put("list4docUrlPg2", specialSurveyRevisionModel.getList_4_doc_url_pg2());
        map2.put("list5docUrlPg2", specialSurveyRevisionModel.getList_5_doc_url_pg2());
        map2.put("list6docUrlPg2", specialSurveyRevisionModel.getList_6_doc_url_pg2());
        map2.put("list7docUrlPg2", specialSurveyRevisionModel.getList_7_doc_url_pg2());
        map2.put("list5docUrlPg3", specialSurveyRevisionModel.getList_5_doc_url_pg3());
        map2.put("aadharNo", this.aadharNo);
        map2.put("mobileNo", this.mobileNo);
        map2.put("fathersOrGuardianName", null);
        map2.put("fathersOrGuardianEpicNo", this.fatherEpic);
        map2.put("mothersName", null);
        map2.put("mothersEpicNo", this.motherEpic);
        map2.put("spouseName", null);
        map2.put("spouseEpicNo", this.spouseEpic);
        map2.put("annexureCUrl", this.annexureCUrl);
        map2.put("preRevisionVoterFlg", this.IRFlag);
        map2.put("preRevisionVoterDocUrl", specialSurveyRevisionModel.getPre_revision_voter_doc_url());
        map2.put("preRevisionVoterDocUrlPg2", specialSurveyRevisionModel.getPre_revision_voter_doc_url_pg2());
        map2.put("submittedForRecommendation", this.submitFlag);
        map2.put("fathersNationality", this.fatherNationality);
        map2.put("mothersNationality", this.motherNationality);
        map2.put("srFormPage2Url", specialSurveyRevisionModel.getSr_form_page_2_url());
        map2.put("oldAcNo", this.oldAc);
        map2.put("oldPartNo", this.oldPart);
        map2.put("oldPslNo", this.oldpsl);
        map2.put("list8Doc", this.list8code);
        map2.put("moldAcNo", this.motherOldAc);
        map2.put("moldPartNo", this.motherOldPart);
        map2.put("moldPslNo", this.motherOldPsl);
        map2.put("foldAcNo", this.fatherOldAc);
        map2.put("foldPartNo", this.fatherOldPart);
        map2.put("foldPslNo", this.fatherOldPsl);
        map2.put("documentUploadedFlg", this.documentFlag);
        map2.put("relationOldAcNo", this.relationOldAcNo);
        map2.put("relationOldPartNo", this.relationOldPartNo);
        map2.put("relationOldPslNo", this.relationOldPslNo);
        map2.put("relationDocType", this.relationDocType);
        map2.put("relationDocUrlPg1", specialSurveyRevisionModel.getRelationDocUrlPg1());
        map2.put("relationDocUrlPg2", specialSurveyRevisionModel.getRelationDocUrlPg2());
        map2.put("isRelativePreVoterFlg", this.isRelativeFlag);
        map2.put("relationProofDocUrlPg1", specialSurveyRevisionModel.getRelationProofDocUrlPg1());
        map2.put("relationProofDocUrlPg2", specialSurveyRevisionModel.getRelationProofDocUrlPg2());
        map2.put("relationType", this.relationType);
        map2.put("relationEpicNo", this.relationEpicNo);
        map2.put("isThisYouRel", this.isThisYouRel);
        map2.put("isThisYou", this.isThisYou);
        map2.put("bloOverridenFlg", "Y");
        map2.put("oldStateCd", specialSurveyRevisionModel.getOldStateCd());
        map2.put("relationOldStateCd", specialSurveyRevisionModel.getRelationOldStateCd());
        Logger.d(this.TAG, map2.toString());
        ((UserClient) ApiClient.getClient1(getApplicationContext()).create(UserClient.class)).updateSpecialRevisionSIR(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SirUploadWorker.2
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (!response.isSuccessful()) {
                        String string = new JSONObject(response.errorBody().string()).getString("message");
                        Toast.makeText(SirUploadWorker.this.getApplicationContext(), string, 1).show();
                        SirUploadWorker.this.sirDatabaseHelper.SpecialRevisionDao().UpdateErrorMessage(SirUploadWorker.this.epicId, string, response.code());
                    } else if (response.code() == 200) {
                        Toast.makeText(SirUploadWorker.this.getApplicationContext(), "Form submitted successfully", 1).show();
                        SirUploadWorker.this.sirDatabaseHelper.SpecialRevisionDao().deleteSpecialSurveyRevisionDetails(SirUploadWorker.this.epicId);
                        SirUploadWorker.this.deleteLocalFolder();
                    }
                } catch (Exception e) {
                    Logger.d("SIRUploadWorker", e.toString());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (t instanceof IOException) {
                    SirUploadWorker.this.sirDatabaseHelper.SpecialRevisionDao().UpdateErrorMessage(SirUploadWorker.this.epicId, SirUploadWorker.this.getApplicationContext().getResources().getString(R.string.network_error), 510);
                }
            }
        });
    }

    public void Reverify(SpecialSurveyRevisionModel specialSurveyRevisionModel) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        HashMap map2 = new HashMap();
        map2.put("epicNo", this.epic);
        map2.put("epicId", this.epicId);
        map2.put("stCode", this.state);
        map2.put("houseNo", this.house);
        map2.put("dobVerified", this.dobverified);
        map2.put("erollDob", this.erollDob);
        map2.put("districtCd", this.district);
        map2.put("acNo", this.asmblyNO);
        map2.put("partNo", this.partNo);
        map2.put("partSerialNo", this.serial);
        map2.put("createdBy", this.createdBy);
        map2.put("modifiedDttm", "");
        map2.put("modifiedBy", "BLO");
        map2.put("photoUrl", specialSurveyRevisionModel.getPhoto_url());
        map2.put("srFormPage1Url", specialSurveyRevisionModel.getSr_form_page_1_url());
        map2.put("citizenshipType", this.citizenshiptype);
        map2.put("citizenshipTypeCat", this.citizenCat);
        map2.put("surveyChannel", this.surveychannel);
        map2.put("list1Doc", this.list1Code);
        map2.put("list2Doc", this.list2code);
        map2.put("list3Doc", this.list3code);
        map2.put("list4Doc", this.list4code);
        map2.put("list5Doc", this.list5code);
        map2.put("list6Doc", this.list6code);
        map2.put("list7Doc", this.list7code);
        map2.put("list1DocUrl", specialSurveyRevisionModel.getList_1_doc_url());
        map2.put("list2DocUrl", specialSurveyRevisionModel.getList_2_doc_url());
        map2.put("list3DocUrl", specialSurveyRevisionModel.getList_3_doc_url());
        map2.put("list4DocUrl", specialSurveyRevisionModel.getList_4_doc_url());
        map2.put("list5DocUrl", specialSurveyRevisionModel.getList_5_doc_url());
        map2.put("list6DocUrl", specialSurveyRevisionModel.getList_6_doc_url());
        map2.put("list7DocUrl", specialSurveyRevisionModel.getList_7_doc_url());
        map2.put("list1docUrlPg2", specialSurveyRevisionModel.getList_1_doc_url_pg2());
        map2.put("list2docUrlPg2", specialSurveyRevisionModel.getList_2_doc_url_pg2());
        map2.put("list3docUrlPg2", specialSurveyRevisionModel.getList_3_doc_url_pg2());
        map2.put("list4docUrlPg2", specialSurveyRevisionModel.getList_4_doc_url_pg2());
        map2.put("list5docUrlPg2", specialSurveyRevisionModel.getList_5_doc_url_pg2());
        map2.put("list6docUrlPg2", specialSurveyRevisionModel.getList_6_doc_url_pg2());
        map2.put("list7docUrlPg2", specialSurveyRevisionModel.getList_7_doc_url_pg2());
        map2.put("list5docUrlPg3", specialSurveyRevisionModel.getList_5_doc_url_pg3());
        map2.put("aadharNo", this.aadharNo);
        map2.put("mobileNo", this.mobileNo);
        map2.put("fathersOrGuardianName", null);
        map2.put("fathersOrGuardianEpicNo", this.fatherEpic);
        map2.put("mothersName", null);
        map2.put("mothersEpicNo", this.motherEpic);
        map2.put("spouseName", null);
        map2.put("spouseEpicNo", this.spouseEpic);
        map2.put("annexureCUrl", this.annexureCUrl);
        map2.put("preRevisionVoterFlg", this.IRFlag);
        map2.put("preRevisionVoterDocUrl", specialSurveyRevisionModel.getPre_revision_voter_doc_url());
        map2.put("preRevisionVoterDocUrlPg2", specialSurveyRevisionModel.getPre_revision_voter_doc_url_pg2());
        map2.put("submittedForRecommendation", this.submitFlag);
        map2.put("fathersNationality", this.fatherNationality);
        map2.put("mothersNationality", this.motherNationality);
        map2.put("srFormPage2Url", specialSurveyRevisionModel.getSr_form_page_2_url());
        map2.put("oldAcNo", this.oldAc);
        map2.put("oldPartNo", this.oldPart);
        map2.put("oldPslNo", this.oldpsl);
        map2.put("list8Doc", this.list8code);
        map2.put("moldAcNo", this.motherOldAc);
        map2.put("moldPartNo", this.motherOldPart);
        map2.put("moldPslNo", this.motherOldPsl);
        map2.put("foldAcNo", this.fatherOldAc);
        map2.put("foldPartNo", this.fatherOldPart);
        map2.put("foldPslNo", this.fatherOldPsl);
        map2.put("documentUploadedFlg", this.documentFlag);
        map2.put("relationOldAcNo", this.relationOldAcNo);
        map2.put("relationOldPartNo", this.relationOldPartNo);
        map2.put("relationOldPslNo", this.relationOldPslNo);
        map2.put("relationDocType", this.relationDocType);
        map2.put("relationDocUrlPg1", specialSurveyRevisionModel.getRelationDocUrlPg1());
        map2.put("relationDocUrlPg2", specialSurveyRevisionModel.getRelationDocUrlPg2());
        map2.put("isRelativePreVoterFlg", this.isRelativeFlag);
        map2.put("relationProofDocUrlPg1", specialSurveyRevisionModel.getRelationProofDocUrlPg1());
        map2.put("relationProofDocUrlPg2", specialSurveyRevisionModel.getRelationProofDocUrlPg2());
        map2.put("relationType", this.relationType);
        map2.put("relationEpicNo", this.relationEpicNo);
        map2.put("isThisYouRel", this.isThisYouRel);
        map2.put("isThisYou", this.isThisYou);
        map2.put("bloOverridenFlg", this.bloOverriddenFlag);
        map2.put("oldStateCd", specialSurveyRevisionModel.getOldStateCd());
        map2.put("relationOldStateCd", specialSurveyRevisionModel.getRelationOldStateCd());
        Logger.d(this.TAG, map2.toString());
        ((UserClient) ApiClient.getClient1(getApplicationContext()).create(UserClient.class)).updateSpecialRevision2SIR(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.sir.enumerationForm.SirUploadWorker.3
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (!response.isSuccessful()) {
                        String string = new JSONObject(response.errorBody().string()).getString("message");
                        Toast.makeText(SirUploadWorker.this.getApplicationContext(), string, 1).show();
                        SirUploadWorker.this.sirDatabaseHelper.SpecialRevisionDao().UpdateErrorMessage(SirUploadWorker.this.epicId, string, response.code());
                    } else if (response.code() == 200) {
                        Toast.makeText(SirUploadWorker.this.getApplicationContext(), "Form submitted successfully", 1).show();
                        SirUploadWorker.this.sirDatabaseHelper.SpecialRevisionDao().deleteSpecialSurveyRevisionDetails(SirUploadWorker.this.epicId);
                        SirUploadWorker.this.deleteLocalFolder();
                    }
                } catch (Exception e) {
                    Logger.d("SIRUploadWorker", e.toString());
                }
            }

            public void onFailure(Call<JsonObject> call, Throwable t) {
                if (t instanceof IOException) {
                    SirUploadWorker.this.sirDatabaseHelper.SpecialRevisionDao().UpdateErrorMessage(SirUploadWorker.this.epicId, SirUploadWorker.this.getApplicationContext().getResources().getString(R.string.network_error), 510);
                }
            }
        });
    }

    private void getAllData(int i) {
        this.epicId = this.formList.get(i).getEpic_id();
        this.epic = this.formList.get(i).getEpic_no();
        this.house = this.formList.get(i).getHouse_no();
        this.serial = this.formList.get(i).getPart_serial_no();
        this.createdBy = this.formList.get(i).getCreated_by();
        this.dobverified = this.formList.get(i).getDob_verified();
        this.erollDob = this.formList.get(i).getEroll_dob();
        this.electorPhoto = this.formList.get(i).getPhoto_url();
        this.efPage1 = this.formList.get(i).getSr_form_page_1_url();
        this.efPage2 = this.formList.get(i).getSr_form_page_2_url();
        this.citizenshiptype = this.formList.get(i).getCitizenship_type();
        this.citizenCat = this.formList.get(i).getCitizenship_type_cat();
        this.surveychannel = this.formList.get(i).getSurvey_channel();
        this.list1Code = this.formList.get(i).getList_1_doc();
        this.list2code = this.formList.get(i).getList_2_doc();
        this.list3code = this.formList.get(i).getList_3_doc();
        this.list4code = this.formList.get(i).getList_4_doc();
        this.list5code = this.formList.get(i).getList_5_doc();
        this.list6code = this.formList.get(i).getList_6_doc();
        this.list7code = this.formList.get(i).getList_7_doc();
        this.list1ref = this.formList.get(i).getList_1_doc_url();
        this.list2ref = this.formList.get(i).getList_2_doc_url();
        this.list3ref = this.formList.get(i).getList_3_doc_url();
        this.list4ref = this.formList.get(i).getList_4_doc_url();
        this.list5ref = this.formList.get(i).getList_5_doc_url();
        this.list6ref = this.formList.get(i).getList_6_doc_url();
        this.list7ref = this.formList.get(i).getList_7_doc_url();
        this.list1ref2 = this.formList.get(i).getList_1_doc_url_pg2();
        this.list2ref2 = this.formList.get(i).getList_2_doc_url_pg2();
        this.list3ref2 = this.formList.get(i).getList_3_doc_url_pg2();
        this.list4ref2 = this.formList.get(i).getList_4_doc_url_pg2();
        this.list5ref2 = this.formList.get(i).getList_5_doc_url_pg2();
        this.list6ref2 = this.formList.get(i).getList_6_doc_url_pg2();
        this.list7ref2 = this.formList.get(i).getList_7_doc_url_pg2();
        this.list5ref3 = this.formList.get(i).getList_5_doc_url_pg3();
        this.aadharNo = this.formList.get(i).getAadhaar_no();
        this.mobileNo = this.formList.get(i).getMobile_no();
        this.fatherEpic = this.formList.get(i).getFather_or_guardian_epic_no();
        this.motherEpic = this.formList.get(i).getMothers_epic_no();
        this.spouseEpic = this.formList.get(i).getSpouse_epic_no();
        this.IRFlag = this.formList.get(i).getPre_revision_voter_flag();
        this.IRref = this.formList.get(i).getPre_revision_voter_doc_url();
        this.IRref2 = this.formList.get(i).getPre_revision_voter_doc_url_pg2();
        this.submitFlag = this.formList.get(i).getSubmitted_for_recommendation();
        this.fatherNationality = this.formList.get(i).getFather_nationality();
        this.motherNationality = this.formList.get(i).getMother_nationality();
        this.oldAc = this.formList.get(i).getOld_ac_no();
        this.oldPart = this.formList.get(i).getOld_part_no();
        this.oldpsl = this.formList.get(i).getOld_psl_no();
        this.fatherOldAc = this.formList.get(i).getF_old_ac_no();
        this.fatherOldPart = this.formList.get(i).getF_old_part_no();
        this.fatherOldPsl = this.formList.get(i).getF_old_psl_no();
        this.motherOldAc = this.formList.get(i).getM_old_ac_no();
        this.motherOldPart = this.formList.get(i).getM_old_part_no();
        this.motherOldPsl = this.formList.get(i).getM_old_psl_no();
        this.list8code = this.formList.get(i).getList_8_doc();
        this.documentFlag = this.formList.get(i).getDocument_uploaded_flag();
        this.relationOldAcNo = String.valueOf(this.formList.get(i).getRelationOldAcNo());
        this.relationOldPartNo = String.valueOf(this.formList.get(i).getRelationOldPartNo());
        this.relationOldPslNo = String.valueOf(this.formList.get(i).getRelationOldPslNo());
        this.relationDocType = this.formList.get(i).getRelationDocType();
        this.relationDocUrlPg1 = this.formList.get(i).getRelationDocUrlPg1();
        this.relationDocUrlPg2 = this.formList.get(i).getRelationDocUrlPg2();
        this.isRelativeFlag = this.formList.get(i).getIsRelativePreVoterFlg();
        this.relationProofDocUrlPg1 = this.formList.get(i).getRelationProofDocUrlPg1();
        this.relationProofDocUrlPg2 = this.formList.get(i).getRelationProofDocUrlPg2();
        this.relationType = this.formList.get(i).getRelationType();
        this.isThisYouRel = this.formList.get(i).getIsThisYouRel();
        this.isThisYou = this.formList.get(i).getIsThisYou();
        this.annexureCUrl = this.formList.get(i).getAnnexure_c_url();
        this.relationEpicNo = this.formList.get(i).getRelationEpicNo();
        this.bloOverriddenFlag = this.formList.get(i).getBLO_OVER_RIDDEN_FLG();
    }
}
