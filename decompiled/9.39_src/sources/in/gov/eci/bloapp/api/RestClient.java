package in.gov.eci.bloapp.api;

import com.google.gson.JsonObject;
import in.gov.eci.bloapp.api.model.EronetResonse;
import in.gov.eci.bloapp.model.app_model.HonbleCommissionModel;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface RestClient {
    @POST("form8O/submitForm8Overseas")
    Call<JsonObject> eroMigrationOverseasSubmit(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String stateCd, @Body Map<String, Object> map);

    @POST("form8/submitForm8")
    Call<JsonObject> eroMigrationSubmit(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String stateCd, @Body Map<String, Object> map);

    @POST("authn/password-flow")
    Call<EronetResonse> eroPasswordFlow(@Body Map<String, Object> map);

    @POST("bloapp-facility/savepsaddress")
    Call<JsonObject> eroSaveCoordinates(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Body Map<String, String> map);

    @POST("authn/otp-flow-send")
    Call<EronetResonse> eroSendOtp(@Body Map<String, Object> map);

    @POST("bloapp/HouseServeySubmit")
    Call<EronetResonse> eroSurveySubmit(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Body Map<String, Object> map);

    @POST("authn/otp-flow-verify")
    Call<EronetResonse> eroTokenReceived(@Body Map<String, Object> map);

    @POST("bloapp-facility/savepsphotos")
    Call<JsonObject> erofetchimage(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Body Map<String, Object> map);

    @POST("bloapp/savechecklistform8")
    Call<JsonObject> erogetforms8(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String stateCd, @Header("Content-Type") String content, @Body Map<String, String> map);

    @POST("face-detection/check-face")
    @Multipart
    Call<JsonObject> faceRecognitionApi(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("state") String state, @Header("CurrentRole") String currentRole, @Header("appName") String appName1, @Part MultipartBody.Part file, @Part("fileType") RequestBody fileType);

    @GET("bloapp/getpsemfamf/{state}/{acnumber}/{partnumber}")
    Call<EronetResonse> facilityGetEMFAMFData(@Path("state") String state, @Path("acnumber") String acnumber, @Path("partnumber") String partnumber, @Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state1, @Header("Content-Type") String Content_Type);

    @POST("bloapp/savepsemfamf")
    Call<JsonObject> facilityPostEMFAMFData(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String Content_Type, @Body Map<String, Object> map);

    @GET("bloapp-facility/getpsaddress/{stateCode}/{acNo}/{partNo}")
    Call<EronetResonse> facilityaddress(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Path("stateCode") String stateCode, @Path("acNo") String acnumber, @Path("partNo") String partnumber);

    @GET("bloapp-facility/getpsphotos/{stateCode}/{acnumber}/{partnumber}")
    Call<JsonObject> facilityimage(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Path("stateCode") String stateCode, @Path("acnumber") String acnumber, @Path("partnumber") String partnumber);

    @GET("index.php?/cms/records/3")
    Call<HonbleCommissionModel> getHonbleCommissionData(@Query("key") String key, @Query("page") String page, @Query("featured") String featured, @Query("sortDir") String sortDir);

    @GET("document/getFile")
    Call<JsonObject> getdownloaded(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("appName") String appName, @Query("bucketName") String bucketName, @Query("fileName") String fileName);

    @POST("{stateCode}/bloapp-sir/uploadHearingReceipt")
    Call<JsonObject> updateImageUploadRecept(@Path("stateCode") String stateCode, @Header("Authorization") String authorization, @Header("Content-Type") String content, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String stateCd, @Body HashMap<String, Object> map);

    @POST("user-management/user/profile/update/request")
    Call<JsonObject> updateMyProfile(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String stateCd, @Body HashMap<String, Object> map);

    @POST("document/uploadFile")
    @Multipart
    Call<JsonObject> uploadImageWithData(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("appName") String appName1, @Part MultipartBody.Part file, @Part("bucketName") RequestBody bucketName, @Part("fileType") RequestBody fileType, @Part("fileName") RequestBody fileName, @Part("appName") RequestBody appName);

    @POST("document/uploadFile")
    @Multipart
    Call<JsonObject> uploadImageWithData1(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("appName") String appName1, @Part MultipartBody.Part file, @Part("fileType") RequestBody fileType, @Part("fileName") RequestBody fileName, @Part("stateCode") RequestBody stateCode, @Part("acNo") RequestBody acNo, @Part("partNo") RequestBody partNo, @Part("type") RequestBody type, @Part("appName") RequestBody appName);

    @POST("document/uploadFile")
    @Multipart
    Call<JsonObject> uploadImageWithData2(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("appName") String appName1, @Part MultipartBody.Part file, @Part("bucketName") RequestBody bucketName, @Part("fileType") RequestBody fileType, @Part("fileName") RequestBody fileName, @Part("stateCode") RequestBody stateCode, @Part("acNo") RequestBody acNo, @Part("partNo") RequestBody partNo, @Part("type") RequestBody type, @Part("appName") RequestBody appName);

    @POST("document-adhoc/uploadFile")
    @Multipart
    Call<JsonObject> uploadImageWithSIR(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("appName") String appName1, @Part MultipartBody.Part file, @Part("bucketName") RequestBody bucketName, @Part("fileType") RequestBody fileType, @Part("fileName") RequestBody fileName, @Part("stateCode") RequestBody stateCode, @Part("acNo") RequestBody acNo, @Part("partNo") RequestBody partNo, @Part("type") RequestBody type, @Part("appName") RequestBody appName);
}
