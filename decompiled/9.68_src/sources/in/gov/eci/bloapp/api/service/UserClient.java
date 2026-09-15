package in.gov.eci.bloapp.api.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.api.model.DocumentResponse;
import in.gov.eci.bloapp.api.model.EronetResonse;
import in.gov.eci.bloapp.api.model.EronetResponse;
import in.gov.eci.bloapp.api.model.JsonResponse;
import in.gov.eci.bloapp.api.model.Login;
import in.gov.eci.bloapp.api.model.Response;
import in.gov.eci.bloapp.api.model.SIRResponseData;
import in.gov.eci.bloapp.api.model.User;
import in.gov.eci.bloapp.model.AppProfileRoot;
import in.gov.eci.bloapp.model.ElectroleDeatils.H2HSurveyStatusModel;
import in.gov.eci.bloapp.model.ElectroleDeatils.HouseSurveyModel;
import in.gov.eci.bloapp.model.ElectroleDeatils.PartElectorDetailsModel;
import in.gov.eci.bloapp.model.SIR.unCollectableModel;
import in.gov.eci.bloapp.model.UnCollectableModelBH;
import in.gov.eci.bloapp.model.app_model.NotificationRoot;
import in.gov.eci.bloapp.model.check_list_form_6.SectionNumberModel;
import in.gov.eci.bloapp.model.electors_list.ElectorsListModel;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.views.activity.newsir.model.ATModuleRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.AddNotionalRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.AnomalyDetailsRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.AsdActionrRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.BloBlaMoMRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.CheckDSESDetailsRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.CheckEpicRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.ClusterDetailsRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.DetailsofEpicRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.DocTypeRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.DseVerifiedClusterDetailsRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.EFRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.EpicDeliveryRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.ErollDataModel;
import in.gov.eci.bloapp.views.activity.newsir.model.FormVerificationRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.FormVerifyRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.HearingElectorRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.LocationRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingAnomalyDetailsRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.MarkVipRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.MobileNumberRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.PSEClusterDetailsRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.PSEVerifyRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.PseFormVerifyRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.SearchByAcPartModel;
import in.gov.eci.bloapp.views.activity.newsir.model.SelectPhotoRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.UncollecedDocumentRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.UncollectedDetailsRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.UpdateMobileRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.ViewDocumentRoot;
import in.gov.eci.bloapp.views.activity.newsir.model.formatcdetails.Root;
import in.gov.eci.bloapp.views.model.EpicIssuedRoot;
import in.gov.eci.bloapp.views.model.FormInProcessRoot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.simple.JSONArray;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface UserClient {
    @POST("form6/DseElasticRequestApis")
    Call<EpicIssuedRoot> DseElasticRequestApis(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("epic-printing/action-for-return-epic")
    Call<JsonObject> actionForReturnEpic(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp-h2h/addProgeny")
    Call<JsonObject> addProgency(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp-h2h/addSelfProgeny")
    Call<JsonObject> addSelfProgeny(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("authenticate")
    Call<User> authenticate(@Body Login authenticate);

    @POST("user-management/change/user/password")
    Call<JsonObject> changePassword(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Body Map<String, String> json);

    @POST("elastic/check-dse-in-state")
    Call<CheckDSESDetailsRoot> checkDSEinState(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @POST("elastic/check-dse-in-india-form-processing")
    Call<FormInProcessRoot> checkDseInIndiaFormProcessing(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("elastic-sir/get-by-epic-for-form")
    Call<ArrayList<CheckEpicRoot>> checkEpicNumber(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("bloapp-h2h/CheckMapping")
    Call<JsonObject> checkMapping(@Body HashMap<String, Object> map, @HeaderMap HashMap<String, String> header);

    @POST("{stateCode}/bloapp-sir/checkSelfMappingConflict")
    Call<JsonObject> checkSelfMappingConflict(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @GET("common/states")
    Call<JSONArray> commonState();

    @POST("political-party-user-management/user/createBlaTwo")
    Call<JsonObject> createBla2(@Header("state") String state, @Header("currentrole") String currentRole, @Body Map<String, Object> map);

    @POST("bloapp-h2h/deleteFromProgeny")
    Call<JsonObject> deleteFromProgeny(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp-h2h/deleteSelfProgeny")
    Call<JsonObject> deleteSelfProgeny(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp/getCompleteCluster")
    Call<EronetResponse> dseDone(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("Connection") String conn, @Header("Currentrole") String currentRole, @Header("state") String state, @Body Map<String, Object> map);

    @POST("dse/get-dse-by-ac-and-type")
    Call<EronetResponse> dseIdentified(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("Connection") String conn, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("dse/dse-details")
    Call<JsonArray> dseIdentifiedNew(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("dse/get-blo-checklist")
    Call<EronetResponse> dsePending(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("Connection") String conn, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("dse/save-ero-response")
    Call<JsonObject> dseSaveResponse(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("dse/bloDseRemarkSubmit")
    Call<JsonObject> dseclusterSubmit(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Body Map<String, Object> map);

    @POST("form6b/submitNewForm6b")
    Call<JsonObject> eroAadhaarAuthSubmit(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String stateCd, @Body Map<String, Object> map, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo);

    @POST("bloapp-h2h/getElectroleDeatils")
    Call<EronetResponse> eroElectoralDetails(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @GET("form6b/getListOfDocuments")
    Call<JSONArray> eroGetDocument(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String stateCd, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo);

    @GET("form7/getForm7byEpic/{stateCd}/{partNo}")
    Call<JsonObject> eroGetEpic(@Path("stateCd") String stateCd1, @Path("partNo") String partNo, @Query("epicNumber") String epicNumber, @Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String stateCd, @Header("PLATFORM-TYPE") String platformType);

    @GET("form7/getForm7byEpic/{stateCode}/{acNO}")
    Call<JsonObject> eroGetEpic8(@Path("stateCode") String stateCode, @Path("acNO") String acNO, @Query("epicNumber") String epicNumber, @Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @POST("authn/cdac/get-epic-details-from-cdac")
    Call<JsonObject> eroGetEpic8elastic(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("bloapp-h2h/getHouseDetails")
    Call<EronetResponse> eroHouseDetails(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("bloapp-h2h/getAllHouseSurveyData")
    Call<EronetResponse> eroHouseFetch(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("bloapp-h2h/getAllHouseSurveyDataName")
    Call<EronetResponse> eroHouseFetch1(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("form8O/submitForm8Overseas")
    Call<JsonObject> eroMigrationOverseasSubmit(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String stateCd, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("form8/submitForm8")
    Call<JsonObject> eroMigrationSubmit(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String stateCd, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("authn-sso/password-flow")
    Call<EronetResponse> eroPasswordFlow(@Header("PLATFORM-TYPE") String platformType, @Body Map<String, String> map);

    @GET("form6a/getFormRefNumber")
    Call<JsonObject> eroRefNum(@Query("assemblyNo") int assemblyNo, @Query("stateCd") String stateCd, @Query("sourceOfApplication") String sourceOfApplication, @Query("formType") String formType, @Header("CurrentRole") String currentRole, @Header("state") String stateCd1);

    @GET("form6a/getFormRefNumber")
    Call<JsonObject> eroRefNumform7(@Query("assemblyNo") int assemblyNo, @Query("stateCd") String stateCd, @Query("sourceOfApplication") String sourceOfApplication, @Query("formType") String formType, @Query("form7SelfOtherInclusion") String form7SelfOtherInclusion, @Header("CurrentRole") String currentRole, @Header("state") String stateCd1);

    @GET("form6a/getFormRefNumber")
    Call<JsonObject> eroRefNumform8(@Query("assemblyNo") int assemblyNo, @Query("stateCd") String stateCd, @Query("sourceOfApplication") String sourceOfApplication, @Query("formType") String formType, @Query("form8ShiOutWitCorRepMar") String form8ShiOutWitCorRepMar, @Header("CurrentRole") String currentRole, @Header("state") String stateCd1);

    @POST("authn-sso/otp-flow-send")
    Call<EronetResponse> eroSendOtp(@Header("PLATFORM-TYPE") String platformType, @Body Map<String, String> map);

    @POST("bloapp-h2h/HouseServeySubmit")
    Call<JsonObject> eroSurveySubmit(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("authn-sso/otp-flow-verify")
    Call<EronetResponse> eroTokenReceived(@Header("PLATFORM-TYPE") String platformType, @Body Map<String, String> map);

    @POST("bloapp-h2h/getAllHouseSurveySectionData")
    Call<EronetResponse> erofilterHouseFetch(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @GET("eroll/getDopStatus")
    Call<JsonObject> erotrackDopstatus(@Query("formRefNo") String formRefNo, @Query("stateCd") String stateCd, @Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType);

    @GET("nvsp/trackApplicationDetails/{formRefNo}")
    Call<JsonObject> erotrackstatus(@Path("formRefNo") String formRefNo, @Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String stateCode, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("PLATFORM-TYPE") String platformType);

    @GET("bloapp-facility/getpsemfamf/{state}/{acnumber}/{partnumber}")
    Call<EronetResonse> facilityGetEMFAMFData(@Path("state") String state, @Path("acnumber") String acnumber, @Path("partnumber") String partnumber, @HeaderMap Map<String, String> header);

    @POST("bloapp-facility/savepsemfamf")
    Call<JsonObject> facilityPostEMFAMFData(@HeaderMap Map<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp-h2h/fetchCallBackDetailsByAcPartNo")
    Call<JsonObject> fetchCallBackDetails(@Header("Authorization") String authorization, @Header("state") String state, @Body Map<String, Object> map);

    @GET("bloapp/getpsphotos/S04/167/09")
    Call<JsonObject> fetchImage(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole);

    @POST("user-management/change/user/password")
    Call<EronetResponse> firstTimePasswordChange(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Body Map<String, Object> map);

    @GET("user-management/user/getDetails/")
    Call<EronetResponse> forgetChangePassword(@Header("PLATFORM-TYPE") String platformType, @Query("unique") String mobileNumber, @Header("state") String state);

    @POST("user-management/otp/send")
    Call<EronetResponse> forgetChangePasswordSendOtp(@Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("user-management/otp/verify")
    Call<EronetResponse> forgetChangePasswordVerifyOtp(@Body Map<String, Object> map);

    @POST("user-management/forgot/password/blo")
    Call<EronetResponse> forgetSetPassword(@Header("state") String state, @Header("workflowconfigid") String workflowconfigid, @Body Map<String, Object> map);

    @POST("formProcessingService/fieldVerification")
    Call<Void> formProcessingService(@Header("state") String stateCode, @Header("currentRole") String currentRole, @Header("workflowConfigId") int workflowConfigId, @Header("formProcessingDetailsId") int formProcessingDetailsId, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> json);

    @POST("dse/get-fomat-a-blo-checklist")
    Call<EronetResponse> formatAPending(@Header("Authorization") String authorization, @Header("Connection") String conn, @Header("CurrentRole") String currentRole, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("dse/bloDseRemarkSubmit")
    Call<EronetResponse> formatASubmit(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("Content-Type") String content, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("formProcessingService/formatCSubmit")
    Call<Void> formatCSubmit(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @POST("formProcessingService/fieldVerification")
    Call<JsonObject> fvrSubmission(@Header("currentRole") String currentRole, @Header("state") String stateCode, @Header("formProcessingDetailsId") int formProcessingDetailsId, @Header("workflowConfigId") String workflowConfigId, @Header("PLATFORM-TYPE") String platformType, @Body HashMap<String, Object> json);

    @POST("bloapp-sir/get2003DataByEpic")
    Call<JsonObject> get2003DataByEpic(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> body);

    @POST("ngsp-manageappeal/filterAppealNoticeBlo")
    Call<ATModuleRoot> getATNoticeList(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @GET("form6b/get/checkEpicHasAdhar")
    Call<JsonObject> getAadhaarLink(@Query("epicNo") String epic, @Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String stateCd, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo);

    @GET("formProcessingService/{formProcessingDetailsId}")
    Call<JsonObject> getAeroRemarks(@Path("formProcessingDetailsId") int formProcessingDetailsId, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @GET("external/getAsmbly")
    Call<JsonObject> getAllAssmbly(@HeaderMap HashMap<String, String> header);

    @POST("bloapp-h2h/getSpecialRevisionForms")
    Call<JsonObject> getAllFormData(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp-sir/getSpecialRevisionForms")
    Call<JsonObject> getAllFormDataSIR(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @GET("bloapp-report/getAllId")
    Call<EronetResonse> getAllId(@Query("acNo") String acNo, @Query("districtCd") String districtCd, @HeaderMap Map<String, String> header);

    @GET("notification-alert/getAllIsSeenCount")
    Call<JsonObject> getAllIsSeenCount(@HeaderMap HashMap<String, String> header);

    @POST("bloapp-h2h/getBloMarked2003Eroll")
    Call<JsonObject> getAllMarkedElectorList(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Integer> map);

    @GET("notification-alert/getAllNotification")
    Call<NotificationRoot> getAllNotification(@HeaderMap HashMap<String, String> header);

    @POST("bloapp-v2/getPartElectorByEpic")
    Call<JsonObject> getAllPartElector(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @GET("political-party-user-management/user/getAllPoliticalPartyDetail")
    Call<JsonObject> getAllPoliticalPartyDetail(@Query("partyType") String partyType, @Header("Authorization") String authorization, @Header("appName") String appName, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String CurrentRole, @Header("state") String state);

    @POST("{stateCode}/bloapp-sir/getAnomalyByEpicId")
    Call<AnomalyDetailsRoot> getAnomalyByEpicId(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> map);

    @POST("{stateCode}/bloapp-sir/getAnomalyByEpicIdV2")
    Call<AnomalyDetailsRoot> getAnomalyByEpicIdV2(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> map);

    @POST("{stateCode}/bloapp-sir/getAnomalyByEpicIdV3")
    Call<JsonObject> getAnomalyByEpicIdV2New(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> map);

    @POST("{stateCode}/bloapp-sir/getAnomalyDataByEpic")
    Call<FormVerificationRoot> getAnomalyDataByEpic(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @POST("{stateCode}/bloapp-sir/getAnomalyUserList")
    Call<FormVerifyRoot> getAnomalyList(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @GET("{stateCode}/bloapp-sir/getBloRemark")
    Call<JsonObject> getAnomalyRemark(@Path("stateCode") String stateCode, @Query("epic_id") Long epicId, @HeaderMap HashMap<String, String> header);

    @POST("{stateCode}/bloapp-sir/getAnomalyUserListV4")
    Call<FormVerifyRoot> getAnomalyUserListV2(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @POST("{stateCode}/bloapp-sir/getAnomalyUserListV3")
    Call<FormVerifyRoot> getAnomalyUserListV2New(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @GET("external/getAsmblyByDist")
    Call<JsonObject> getAssmblyByDist(@Query("District") int district, @HeaderMap HashMap<String, String> header);

    @POST("political-party-user-management/user/getBLA1Details")
    Call<JsonObject> getBLA1Details(@Header("state") String state, @Header("currentrole") String currentRole, @Header("Authorization") String authorization, @Body Map<String, Object> map);

    @POST("{stateCode}/bloapp-sir/getBlankUncollectEf")
    Call<UncollecedDocumentRoot> getBlankUncollectEFf(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, String> map);

    @POST("bloapp/getBloActionByClusterId")
    Call<DseVerifiedClusterDetailsRoot> getBloActionByClusterId(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp/getBloActionDsePseList")
    Call<FormVerifyRoot> getBloActionDsePseList(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("{stateCode}/bloapp-sir/getBloActionPseList")
    Call<PseFormVerifyRoot> getBloActionPseList(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @GET("bloapp/getBloAppProfile")
    Call<JsonObject> getBloAppProfile(@Query("stateCd") String stateCd, @Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("currentRole") String currentRole, @Header("state") String stateCode);

    @GET("bloapp/getBloAppProfile")
    Call<AppProfileRoot> getBloAppProfileroot(@Query("stateCd") String stateCd, @Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("currentRole") String currentRole, @Header("state") String stateCode);

    @POST("enumerationFormData/getBloMappingAnomalyDetailsByEpicNo")
    Call<MappingAnomalyDetailsRoot> getBloMappingAnomalyDetailsByEpicNo(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> map);

    @POST("enumerationFormData/getBloMappingAnomalyDetailsByEpicNo")
    Call<JsonObject> getBloMappingAnomalyDetailsByEpicNoValue(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> map);

    @POST("{stateCode}/bloapp-sir/getBloMappingAnomalyDetailsByEpicNo")
    Call<JsonObject> getBloMappingAnomalyNew(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> map);

    @POST("bloapp/getBloSupervisorDetails")
    Call<JsonObject> getBloSupervisorData(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("elastic/get-by-details-for-form")
    Call<JsonArray> getByDetailsForForm(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("elastic/get-by-epic-for-form")
    Call<JsonArray> getByEpicForForm(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @GET("form6/getEpicNumber/uncollectableSir")
    Call<String> getCheckEpicNumber(@Query("epicNumber") String epicNumber, @Query("acNumber") String acNumber, @Header("Authorization") String authorization, @Header("currentrole") String currentRole, @Header("applicationname") String applicationname, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @GET("bloapp/getchecklist/{stateCode}/{asmblyNo}/{partNo}")
    Call<EronetResponse> getCheckList1(@Path("stateCode") String stateCode, @Path("asmblyNo") int asmblyNo, @Path("partNo") int partNo, @Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state);

    @POST("worklistService/action-worklist/garuda")
    Call<JsonObject> getCheckList1(@Header("state") String stateCode, @Header("currentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> json);

    @GET("bloapp/getCohortElectorsCount")
    Call<EronetResponse> getCohortElectorCount(@Query("stateCd") String stateCd, @Query("districtCd") String districtCd, @Query("acNo") String acNO, @Query("partNo") String partNO, @Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType);

    @GET("common/constituencies")
    Call<JSONArray> getConstituency(@Query("stateCode") String stateCode, @Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole);

    @GET("common/constituenciesUnique")
    Call<JSONArray> getConstituency2025(@Query("stateCode") String stateCode, @Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("Accept") String accept);

    @GET("common/countries")
    Call<JSONArray> getCountry(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state);

    @POST("bloapp/getCurrentDateStatusCoFormCollected")
    Call<JsonObject> getCurrentDateStatusFormCollected(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @GET("bloapp-report/getFormCounts/{stateCd}/{acNo}/{partNo}")
    Call<EronetResponse> getDashFormCount(@Path("stateCd") String stateCd, @Path("acNo") String acNo, @Path("partNo") String partNo, @Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @POST("bloapp-report/getFormDataList")
    Call<EronetResponse> getDashFormDetails(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("currentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("{stateCode}/bloapp-sir/getDeceasedList")
    Call<FormVerifyRoot> getDeceasedList(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @GET("{stateCode}/bloapp-sir/getHearingReciept")
    Call<HearingElectorRoot> getDeliveryScheduledHearingNoticeList(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Query("partNo") Integer partNo, @Query("stateCd") String stateCd, @Query("acNo") Integer acNo);

    @POST("{stateCode}/bloapp-sir/getDetailByClusterId")
    Call<ClusterDetailsRoot> getDetailByClusterId(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, String> map);

    @GET("external/getDetailsByEpicNo")
    Call<JsonObject> getDetailsByEpicNo(@Query("epic") String epic, @HeaderMap HashMap<String, String> header);

    @GET("formProcessingService/formatC/getDetailsByEpicOrRefno")
    Call<Root> getDetailsByEpicOrRefno(@Query("formType") String formType, @Query("refNum") String refNum, @HeaderMap HashMap<String, String> header);

    @GET("external/getDetailsByEroll")
    Call<JsonObject> getDetailsByEroll(@Query("acNo") int acNo, @Query("partNo") int partNo, @Query("serialNo") int serialNo, @HeaderMap HashMap<String, String> header);

    @GET("bloapp-h2h/getDetailsByErollNew")
    Call<JsonObject> getDetailsByErollNew(@Query("acNo") int acNo, @Query("partNo") int partNo, @Query("serialNo") int serialNo, @HeaderMap HashMap<String, String> header);

    @GET("bloapp-h2h/getDetailsByErollNew")
    Call<JsonObject> getDetailsByErollNew1(@Query("acNo") int acNo, @Query("partNo") int partNo, @Query("serialNo") int serialNo, @Query("currentAge") int currentAge, @HeaderMap HashMap<String, String> header);

    @POST("elastic-sir/get-sir-activity-uncollectable-data")
    Call<List<DetailsofEpicRoot>> getDetailsfromEpic(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @GET("common/districts/{state}")
    Call<JSONArray> getDistrict(@Path("state") String state, @Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole);

    @GET("bloapp/getBloDistictId")
    Call<EronetResponse> getDistrict1(@HeaderMap HashMap<String, String> header);

    @GET("common/get/districts/forMultipleAC")
    Call<JSONArray> getDistrictOnAssembly(@Query("acNo") int acNo, @Query("stateCd") String stateCd, @Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("currentRole") String currentRole, @Header("state") String stateCode, @Header("PLATFORM-TYPE") String platformType);

    @GET("form6a/checkqualifydate")
    Call<JsonObject> getDobQualifying(@Query("stateCd") String stateCd, @Query("acNo") String acNo, @Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("currentRole") String currentRole, @Header("state") String stateCode, @Header("applicationName") String applicationName);

    @GET("bloapp-lite/getDocType")
    Call<DocTypeRoot> getDocType(@HeaderMap HashMap<String, String> header);

    @GET("bloapp-lite/getDocTypeNew")
    Call<DocTypeRoot> getDocTypeNew(@HeaderMap HashMap<String, String> header);

    @POST("bloapp/getCompletedClusterElectorDetails")
    Call<EronetResponse> getDoneclusterDetails(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("Connection") String conn, @Header("CurrentRole") String currentRole, @Header("state") String state, @Body Map<String, Object> map);

    @POST("{stateCode}/bloapp-sir/getMoveToDraftEfByEpicId")
    Call<FormVerificationRoot> getDraftData(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @POST("{stateCode}/bloapp-sir/getDsePseElectorList")
    Call<FormVerifyRoot> getDsePseElectorList(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @POST("{stateCode}/bloapp-sir/getPendingRevisionFormsNew")
    Call<EFRoot> getEFListSIR(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, Integer> map);

    @POST("{stateCode}/bloapp-sir/getDistributionDashboard")
    Call<JsonObject> getEfCount(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Integer> map);

    @GET("{stateCode}/bloapp-h2h/getEFDistributionFlg")
    Call<JsonObject> getEfFlag(@HeaderMap HashMap<String, String> header, @Query("acNo") Integer acNo, @Query("partNo") Integer partNo);

    @GET("{stateCode}/bloapp-sir/getEFDistributionFlg")
    Call<JsonObject> getEfFlagSIR(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Query("acNo") Integer acNo, @Query("partNo") Integer partNo);

    @POST("{stateCode}/bloapp-sir/getElectorListForPSEData")
    Call<PSEVerifyRoot> getElectorListForPSEData(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @GET("bloapp/getElectoreCohortStatistics")
    Call<JsonObject> getElectoreCohortStatistics(@Query("stateCd") String stateCd, @Query("districtCd") String districtCd, @Query("acNo") String acNo, @Query("partNo") String partNo, @Header("Authorization") String authorization, @Header("currentRole") String currentRole, @Header("state") String stateCode, @Header("PLATFORM-TYPE") String platformType);

    @POST("epic-printing/getDOPReturnData")
    Call<EpicDeliveryRoot> getEpicDeliveryStatus(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp/getEpicDetails")
    Call<ElectorsListModel.getEpicDetails.Root> getEpicDetails(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> json);

    @POST("elastic/get-by-epic-for-form")
    Call<JsonArray> getEpicForForm8(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @GET("eroll-management/aadhaar-ref-id")
    Call<List<ElectorsListModel.getEpicList.Root>> getEpicList(@Query("stateCd") String stateCode, @Query("acNo") String acNumber, @Query("partNo") String partNumber, @HeaderMap HashMap<String, String> header);

    @POST("{stateCode}/bloapp-sir/getPendingEfMatchedElectorNew")
    Call<EFRoot> getEpicMatchList(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, Integer> map);

    @POST("druid-eroll/dashboard/all")
    Call<JSONArray> getErollDashBoardAll(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String CurrentRole, @Header("Content-Type") String Content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("elastic-sir/get-eroll-data-2003")
    Call<SearchByAcPartModel> getErollData20031(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp-h2h/getErollData")
    Call<JsonObject> getErollDataListForSelf(@HeaderMap HashMap<String, String> header, @Body Map<String, Integer> map);

    @POST("elastic-sir/get-eroll-data-final")
    Call<ErollDataModel> getErollDatafinal(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @GET("bloapp-h2h/getEronetAppStatus")
    Call<JsonObject> getEronetAppStatus(@HeaderMap HashMap<String, String> header);

    @POST("formProcessingService/formatC/formatCWorklist")
    Call<in.gov.eci.bloapp.views.activity.newsir.model.formatc.Root> getFVRPending(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @GET("document/getFile")
    Call<JsonObject> getFile(@Query("bucketName") String bucketName, @Query("fileName") String fileName, @Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("appName") String appName, @Header("PLATFORM-TYPE") String platformType);

    @GET("document/getFile")
    Call<JsonObject> getFile(@Query("bucketName") String bucketName, @Query("fileName") String fileName, @Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("appName") String appName, @Header("PLATFORM-TYPE") String platformType);

    @GET("document-adhoc/getFile")
    Call<JsonObject> getFileforSIR(@Query("bucketName") String bucketName, @Query("fileName") String fileName, @Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("appName") String appName, @Header("PLATFORM-TYPE") String platformType);

    @GET("document-adhoc/getPresignedFile")
    Call<JsonObject> getFileforSIRPN(@Query("bucketName") String bucketName, @Query("fileName") String fileName, @Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("appName") String appName, @Header("PLATFORM-TYPE") String platformType);

    @GET("form6/getForm6byFormRefId/{referenceNumber}")
    Call<JsonObject> getForm6Data(@Path("referenceNumber") String referenceNumber, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @GET("form7O/getForm7ObyFormRefId/{referenceNumber}")
    Call<JsonObject> getForm7ObyFormRefId(@Path("referenceNumber") String referenceNumber, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @GET("form7/getForm7byApplicantFirstName")
    Call<JSONArray> getForm7byApplicantFirstNameOthers(@Query("applicantFirstName") String applicantFirstName, @Query("state") String stateQuery, @Query("assemblyConstituencyNumber") String assemblyConstituencyNumber, @Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state);

    @GET("form7/getForm7byEpic/{stateCode}/{acNO}")
    Call<JsonObject> getForm7byEpic(@Path("stateCode") String stateCode, @Path("acNO") String acNO, @Query("epicNumber") String epicNumber, @Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @GET("form7/getForm7byFormRefId/{referenceNumber}")
    Call<JsonObject> getForm7byFormRefId(@Path("referenceNumber") String referenceNumber, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @GET("form7/getForm7byfirstNameAndlastName")
    Call<JSONArray> getForm7byfirstNameAndlastNameObjection(@Query(Constants.FIRST_NAME) String firstName, @Query(Constants.LAST_NAME) String lastName, @Query("stateCd") String stateCd, @Query("asmblyConstituencyNo") String asmblyConstituencyNo, @Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @GET("form6a/getGenderForm6A")
    Call<JSONArray> getGender(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @GET("bloapp-report/getGenderWiseElectorsCount/{stateCd}/{acNo}/{partNo}")
    Call<JsonObject> getGenderWiseElectorsCount(@Path("stateCd") String stateCd, @Path("acNo") String acNo, @Path("partNo") String partNo, @Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @GET("bloapp-lite/relationListRedis")
    Call<JsonObject> getGrandParentList(@HeaderMap HashMap<String, String> header);

    @GET("bloapp-h2h/houseSurveyFormsStatus")
    Call<H2HSurveyStatusModel.Root> getH2HSurveyStatusData(@HeaderMap Map<String, String> header, @QueryMap Map<String, String> param);

    @GET("bloapp/getlanguagelist")
    Call<EronetResponse> getLanguageDataUrl(@HeaderMap HashMap<String, String> header);

    @POST("{stateCode}/bloapp-sir/getListOfElectorPhoto")
    Call<FormVerifyRoot> getListOfElectorPhoto(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @POST("bloapp-sir/getListOfElectorPhoto")
    Call<FormVerifyRoot> getListOfElectorPhoto1(@HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @POST("{stateCode}/bloapp-sir/getListOfHearingScheduleEf")
    Call<FormVerifyRoot> getListOfHearingScheduleEf(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @POST("{stateCode}/bloapp-sir/getListOfMoveToDraftElector")
    Call<FormVerifyRoot> getListOfMoveToDraftElector(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @POST("{stateCode}/bloapp-sir/getListOfNaCategory")
    Call<FormVerifyRoot> getListOfNaCategory(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @POST("{stateCode}/bloapp-sir/getListOfElectorAttendence")
    Call<FormVerifyRoot> getListOfuploadAttendence(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @POST("{stateCode}/bloapp-sir/getListUncollectableRollBackForms")
    Call<FormVerifyRoot> getListUncollectableRollBackForms(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, String> map);

    @POST("{stateCode}/bloapp-sir/getListofElectorMobile")
    Call<UpdateMobileRoot> getListofElectorMobile(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @POST("{stateCode}/sirvotersearch/getmapping")
    Call<MappingRoot> getMappingdetails(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("{stateCode}/bloapp-sir/getMigrationEfToBeVerifyByEpicId")
    Call<FormVerificationRoot> getMigrationEfToBeVerifyByEpicId(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @POST("{stateCode}/bloapp-sir/getPhoneByEpic")
    Call<MobileNumberRoot> getMobileNumber(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @GET("bloapp-mom/getMomDetails")
    Call<BloBlaMoMRoot> getMomDetails(@HeaderMap HashMap<String, String> header);

    @GET("user-management/user/get/userDetails")
    Call<JsonObject> getMyProfile(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("currentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType);

    @POST("aadhar-connector/get-aadhar-RefNumber")
    Call<JsonObject> getNewAadharRef(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType, @Header("moduleName") String moduleName, @Body Map<String, String> map);

    @POST("{stateCode}/bloapp-sir/getNaCategoryEfByEpicId")
    Call<FormVerificationRoot> getNoMappingData(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @GET("eronet-mobile/getBloNotification")
    Call<JsonObject> getNotification(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Query("acNo") String acNo, @Query("sendTo") String sendTo);

    @GET("bloapp/getNotionalHNo")
    Call<AddNotionalRoot> getNotionalHNo(@HeaderMap HashMap<String, String> header);

    @POST("{stateCode}/bloapp-sir/getOfHearingScheduleEfByEpic")
    Call<ViewDocumentRoot> getOfHearingScheduleEfByEpic(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @POST("{stateCode}/bloapp-sir/getPSEDetailByClusterId")
    Call<PSEClusterDetailsRoot> getPSEDetailByClusterId(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, String> map);

    @GET("external/getPartByAc")
    Call<JsonObject> getPartByAc(@Query("Asmbly") int acNo, @HeaderMap HashMap<String, String> header);

    @POST("bloapp-v2/getPartElector")
    Call<PartElectorDetailsModel.Root> getPartElector(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("druid-eroll/eroll/dashboard/new")
    Call<JSONArray> getPartElectorCount(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("Accept") String accept, @Header("Connection") String conn, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @GET("common/part/get/bystatecd/districtcd/acNumberBypartNumber")
    Call<JSONArray> getPartbyACState(@Query("acNumber") String acNumber, @Query("stateCd") String stateCd, @Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state);

    @POST("bloapp-h2h/getPendingRevisionForms")
    Call<JsonObject> getPendingElectorsList(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Integer> map);

    @POST("bloapp-sir/getPendingRevisionForms")
    Call<JsonObject> getPendingElectorsListSIR(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Integer> map);

    @POST("{stateCode}/bloapp-sir/getPendingRevisionFormsMigration")
    Call<EFRoot> getPendingRevisionFormsMigration(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, Integer> map);

    @POST("bloapp-sir/getPendingEfMatchedElector")
    Call<JsonObject> getPendingRevisionFormsV2(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Integer> map);

    @POST("{stateCode}/bloapp-sir/getPhotoByEpic")
    Call<SelectPhotoRoot> getPhotoByEpic(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @POST("bloapp-sir/getPhotoByEpic")
    Call<SelectPhotoRoot> getPhotoByEpic1(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @GET("bloapp/getPopulationGenderCount")
    Call<JsonObject> getPopulationGenderCount(@Query("stateCd") String stateCd, @Query("districtCd") String districtCd, @Query("acNo") String acNo, @Query("partNo") String partNo, @Header("Authorization") String authorization, @Header("currentRole") String currentRole, @Header("state") String stateCode, @Header("PLATFORM-TYPE") String platformType);

    @POST("druid/pc/populationCount")
    Call<JSONArray> getPopulationGenderCount(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String CurrentRole, @Header("Content-Type") String Content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("bloapp-h2h/getProgenyMapping")
    Call<JsonObject> getProgeny(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("{stateCode}/bloapp-sir/getPseBloActionByClusterId ")
    Call<DseVerifiedClusterDetailsRoot> getPseBloActionByClusterId(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @GET("pull")
    Call<ResponseBody> getPull(@HeaderMap Map<String, String> token, @Query("BOId") String BOId);

    @POST("push")
    @Multipart
    Call<String> getPush(@HeaderMap Map<String, String> token, @Part MultipartBody.Part photo, @Part("someData") RequestBody stringValue, @PartMap Map<String, String> params);

    @GET("form7/getByReasonForObjectionOrDeletion")
    Call<JSONArray> getReasonForObjection(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType);

    @GET("form6/getFormRefNum")
    Call<JsonObject> getReferenceno(@Query("assemblyNo") String assemblyNo, @Query("stateCd") String stateCd, @Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @POST("authn-sso/refresh")
    Call<JsonObject> getRefresh(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType, @Body HashMap<String, String> map);

    @POST("authn-sso/refresh")
    Call<JsonObject> getRefreshToken(@HeaderMap Map<String, String> header, @Body Map<String, String> map);

    @GET("form6a/getTypeOfRelation")
    Call<JSONArray> getRelation(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @GET("bloapp-h2h/getRelationType")
    Call<JsonObject> getRelationDropdown(@HeaderMap HashMap<String, String> header);

    @GET("bloapp-lite/getRelationTypeRedis")
    Call<JsonObject> getRelationDropdownSIR(@HeaderMap HashMap<String, String> header);

    @GET("bloapp-lite/getRelationHearing")
    Call<JsonObject> getRelationHearing(@HeaderMap HashMap<String, String> header);

    @GET("bloapp-h2h/relationList")
    Call<JsonObject> getRelationList(@HeaderMap HashMap<String, String> header);

    @POST("bloapp-h2h/getRollBackForms")
    Call<JsonObject> getRollbackForms(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp-sir/getRollBackForms")
    Call<JsonObject> getRollbackFormsSIR(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("{stateCode}/sirvotersearch/searchmapping")
    Call<LocationRoot> getSearchLocationFamily(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @GET("common/section/get/acNo/partNo")
    Call<JSONArray> getSection(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Query("acNo") String acNo, @Query("partNo") String partNo);

    @GET("common/section/get/acNo/partNo")
    Call<JSONArray> getSection(@Header("PLATFORM-TYPE") String platformType, @Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Query("acNo") String acNo, @Query("partNo") String partNo);

    @GET("common/section/get/acNo/partNo")
    Call<JsonArray> getSection1(@Header("PLATFORM-TYPE") String platformType, @Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Query("acNo") String acNo, @Query("partNo") String partNo);

    @GET("common/section/get/acNo/partNo")
    Call<List<SectionNumberModel.Root>> getSectionForm6(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Query("acNo") String acNo, @Query("partNo") String partNo);

    @POST("{stateCode}/bloapp-sir/getSentBackEroAlreadyEf")
    Call<FormVerifyRoot> getSentBackEroAlreadyEf(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @POST("{stateCode}/bloapp-sir/getSentBackEroEfByEpicId")
    Call<FormVerificationRoot> getSentBackEroEfByEpicId(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @GET("external/getDistrict")
    Call<JsonObject> getSirDistrict(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String State);

    @GET("bloapp-h2h/getSirModuleStatus")
    Call<SIRResponseData> getSirFeatureStatus(@Query("stateCd") String stateCd, @Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("currentRole") String currentRole, @Header("state") String stateCode);

    @GET("bloapp-lite/getSirModuleFlagRedis")
    Call<SIRResponseData> getSirFeatureStatusSIR(@Query("stateCd") String stateCd, @Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("currentRole") String currentRole, @Header("state") String stateCode);

    @POST("bloapp-h2h/getDocumentUploadedFlagCount")
    Call<JsonObject> getSirPageTotalCount(@Query("stateCd") String stateCd, @Query("acNo") int acNo, @Query("partNo") int partNo, @HeaderMap HashMap<String, String> header);

    @POST("bloapp-sir/getDocumentUploadedFlagCount")
    Call<JsonObject> getSirPageTotalCountSIR(@Query("stateCd") String stateCd, @Query("acNo") int acNo, @Query("partNo") int partNo, @HeaderMap HashMap<String, String> header);

    @POST("{stateCode}/bloapp-sir/getEfToBeVerify")
    Call<FormVerifyRoot> getSpecialRevisionFormsPanIndia(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, String> body);

    @POST("{stateCode}/bloapp-sir/getEfToBeVerifyByEpicId")
    Call<FormVerificationRoot> getSpecialRevisionFormsPanIndiaByEpicId(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @POST("bloapp-h2h/getSpecialRevisionDocuments")
    Call<JsonObject> getSpecialRevisionList(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp-h2h/getSpecialRevisionDocuments")
    Call<DocumentResponse> getSpecialRevisionListOffline(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp-sir/getSpecialRevisionDocuments")
    Call<DocumentResponse> getSpecialRevisionListOfflineSIR(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp-sir/getSpecialRevisionDocuments")
    Call<JsonObject> getSpecialRevisionListSIR(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp-h2h/specialSurveyEpicCheck")
    Call<ResponseBody> getSpecialSurveyEpicCheck(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp-sir/specialSurveyEpicCheck")
    Call<ResponseBody> getSpecialSurveyEpicCheckSIR(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @GET("common/states")
    Call<JSONArray> getState(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole);

    @GET("bloapp/getBloStateId")
    Call<EronetResponse> getStateCode(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole);

    @GET("bloapp/getBloStateId")
    Call<EronetResponse> getStateCode1(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType);

    @GET("bloapp-lite/getStateVideoLanguage")
    Call<ArrayList<String>> getStateVideoLanguage(@HeaderMap HashMap<String, String> header);

    @GET("common/get/states/byCountry")
    Call<JSONArray> getStatebyCountryCode(@Query("countryCd") String countryCd, @Header("Authorization") String authorization, @Header("CurrentRole") String currentRole);

    @POST("bloapp-h2h/ViewPopulationSubmit")
    Call<JsonObject> getStatement4Data(@HeaderMap Map<String, String> header, @Body Map<String, Object> map);

    @GET("bloapp-report/getCurrentRevision")
    Call<JsonObject> getStatement6CurrentRevisionData(@Query("stateCd") String stateCd, @Query("districtCd") String districtCd, @Query("acNo") String acNo, @Query("partNo") String partNo, @HeaderMap Map<String, String> header);

    @GET("bloapp-report/getLatestRevision")
    Call<JsonObject> getStatement6LastRevisionData(@Query("stateCd") String stateCd, @Query("acNo") String acNo, @Query("partNo") String partNo, @HeaderMap Map<String, String> header);

    @POST("druid/enumFormTracking")
    Call<JSONArray> getTotalFormElector(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> map);

    @GET("bloapp-h2h/GetTrainingStatus")
    Call<JsonObject> getTrainingStatus(@HeaderMap HashMap<String, String> header);

    @POST("bloapp-h2h/getUncollectableRollBackForms")
    Call<JsonObject> getUncollectableRollBackForms(@HeaderMap HashMap<String, String> header, @Body HashMap<String, String> map);

    @POST("{stateCode}/bloapp-sir/getUncollectableRollBackFormsByEpicId")
    Call<UncollectedDetailsRoot> getUncollectableRollBackFormsByEpicId(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @POST("bloapp-sir/getUncollectableRollBackForms")
    Call<JsonObject> getUncollectableRollBackFormsSIR(@HeaderMap HashMap<String, String> header, @Body HashMap<String, String> map);

    @POST("bloapp-h2h/getUncollectableRollBackFormsNoDocs")
    Call<JsonObject> getUncollectedEfList(@HeaderMap HashMap<String, String> header, @Body HashMap<String, String> map);

    @POST("bloapp-sir/getUncollectableRollBackFormsNoDocs")
    Call<JsonObject> getUncollectedEfListSIR(@HeaderMap HashMap<String, String> header, @Body HashMap<String, String> map);

    @POST("bloapp/getVerifiedEpicHouse")
    Call<HouseSurveyModel.Root> getVerifiedEpicHouse(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp/getVerifiedChecklist")
    Call<EronetResponse> getVerifiedList(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("worklistService/track-worklist")
    Call<JsonObject> getVerifiedList(@Header("currentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Integer> map);

    @POST("bloapp/getVillagelist")
    Call<Response> getVillage(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Body HashMap<String, String> map);

    @POST("bloapp/getVipElectors")
    Call<MarkVipRoot> getVipElector(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("workflow/action")
    Call<JSONArray> getWorkflowid(@Header("CurrentRole") String currentRole, @Header("state") String state, @Body Map<String, Object> map);

    @GET("aadhar-connector/get-aadhar/{refNo}")
    Call<JsonObject> getaadhar(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType, @Header("moduleName") String moduleName, @Path("refNo") String refNo);

    @GET("aadhar-connector/get-aadhar-refno/{aadharNo}")
    Call<JsonObject> getaadharref(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType, @Path("aadharNo") String aadharNo);

    @GET("form6/getAddProofList")
    Call<JSONArray> getaddproof(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType);

    @POST("operationalReporting/voters/serialNumberAndPartNumber_Dse")
    Call<EronetResponse> getaddressDetails(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("operationalReporting/voters/serialNumberAndPartNumber_Pse")
    Call<EronetResponse> getaddressDetailsPse(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @GET("form6/getAgeProofList")
    Call<JSONArray> getageproof(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType);

    @GET("common/ac/get/bystatecd/districtcd/asmblyno")
    Call<JSONArray> getassemblyDetails(@Query("acNumber") String acNumber, @Query("districtCd") String districtCd, @Query("stateCd") String stateCd, @Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType);

    @GET("bloapp/getchecklistdtls/{statecode}/{assembly}/{partno}/{referenceno}/{formtype}")
    Call<Response> getchecklist(@Path("statecode") String statecode, @Path("assembly") String assembly, @Path("partno") String partno, @Path("referenceno") String referenceno, @Path("formtype") String formtype, @Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @GET("form6a/getForm6abyFormRefId/{referenceno}")
    Call<JsonObject> getchecklistform6a(@Path("referenceno") String referenceno, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @GET("form8/getForm8byFormRefId/{referenceno}")
    Call<JsonObject> getchecklistform8(@Path("referenceno") String referenceno, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @GET("form8O/getForm8ObyFormRefId/{referenceno}")
    Call<JsonObject> getchecklistform8O(@Path("referenceno") String referenceno, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @POST("pse/get-blo-checklist-by-clusterid")
    Call<EronetResponse> getclusterDetails(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("dse/get-dse-cluster")
    Call<EronetResponse> getclusterDetailsDse(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @GET("document/getFile")
    Call<JsonObject> getdownloaded(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType, @Query("bucketName") String objectName, @Query("fileName") String fileName, @Header("appName") String appName);

    @POST("druid/Dse")
    Call<JSONArray> getelectorListDse(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Body Map<String, Object> map);

    @GET("common/state/get/bystatecode")
    Call<JsonObject> getstatebystatecd(@Query("stateCode") String stateCode, @Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType);

    @POST("authn-sso/logout")
    Call<JsonObject> logoutApi(@Header("Authorization") String authorization, @Header("refreshToken") String refreshToken, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("applicationName") String applicationName, @Header("Content-Type") String Content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("user-management/otp/send")
    Call<JsonObject> otpSend(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, String> json);

    @POST("user-management/otp/verify")
    Call<JsonObject> otpVerify(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, String> json);

    @POST("bloapp-h2h/addEronetAppStatus")
    Call<JsonObject> postEroappStatus(@HeaderMap HashMap<String, String> header, @Body Map<String, Integer> map);

    @POST("bloapp-h2h/addTrainingStatus")
    Call<JsonObject> postTrainingStatus(@HeaderMap HashMap<String, String> header, @Body Map<String, Integer> map);

    @POST("pse/blo/get-checklist")
    Call<EronetResponse> pseDone(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("Currentrole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Body Map<String, Object> map);

    @POST("pse/blo/get-checklist")
    Call<EronetResponse> pseDone(@Header("Authorization") String authorization, @Header("Currentrole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("pse-forms/submitPSEForm7")
    Call<JsonObject> pseForm7Submit(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body ArrayList<HashMap> map);

    @POST("pse/blo/get-form8-list")
    Call<EronetResponse> pseForm8List(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("Connection") String conn, @Header("CurrentRole") String currentRole, @Header("state") String state, @Body Map<String, Object> map);

    @POST("pse-forms/submitPSEForm8")
    Call<JsonObject> pseForm8Submit(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body ArrayList<HashMap> map);

    @POST("pse/get-pse")
    Call<EronetResponse> pseIdentified(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("Connection") String conn, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("pse/get-checklist-by-clusterid")
    Call<EronetResponse> pseIdentifiedCluster(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("Connection") String conn, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("pse/blo/get-checklist")
    Call<EronetResponse> psePending(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("pse/blo/submit-report")
    Call<EronetResponse> pseclusterSubmit(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("formProcessingService/reInitiate")
    Call<JsonObject> reInitiateToAero(@Header("currentRole") String currentRole, @Header("state") String stateCode, @Header("formProcessingDetailsId") int formProcessingDetailsId, @Header("workflowConfigId") int workflowConfigId, @Header("PLATFORM-TYPE") String platformType, @Header("Authorization") String authorization, @Header("atkn_bnd") String atkBnd, @Header("rtkn_bnd") String rtkBnd, @Body HashMap<String, String> map);

    @POST("authn-sso/registerFCMToken")
    Call<EronetResponse> registerFCMToken(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @GET("form6/formsDlt/getFormDetailsByUserId/8baf2e7a-5626-4422-af7a-a649a7a0835c")
    Call<JsonObject> rejectedtrackstatus(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String stateCode, @Header("PLATFORM-TYPE") String platformType, @Query("page") int page);

    @POST("sir_upload/request")
    Call<JsonResponse> requestSirUploadUrl(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("sir_upload/request")
    Call<JsonObject> requestSirUploadUrlphoto(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp-h2h/resetErollData")
    Call<JsonObject> resetErollData(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> map);

    @POST("ngsp-manageappeal/saveAppealNoticeBlo")
    Call<JsonObject> saveAppealNoticeBlo(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp/saveBloLoginDetails")
    Call<JsonObject> saveBloLogin(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String CurrentRole, @Header("Content-Type") String Content, @Header("appName") String appName, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("bloapp/savechecklistform6")
    Call<JsonObject> saveChecklistform6(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Body Map<String, String> json);

    @POST("bloapp/savechecklistform6b")
    Call<JsonObject> saveChecklistform6b(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String stateCd, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, String> json);

    @POST("bloapp/saveEnumerationStatus")
    Call<JsonObject> saveEnumerationStatus(@HeaderMap HashMap<String, String> header, @Body UnCollectableModelBH body);

    @POST("{stateCode}/bloapp-sir/saveEnumerationStatus")
    Call<JsonObject> saveEnumerationStatusSIR(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body unCollectableModel body);

    @POST("eci-sir/pi/saveEnumerationStatus")
    Call<JsonObject> saveEnumerationStatusSIR(@HeaderMap HashMap<String, String> header, @Body unCollectableModel body);

    @POST("{stateCode}/bloapp-sir/saveEfForUncollectableOnly")
    Call<JsonObject> saveEnumerationStatusSIRNew(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body unCollectableModel body);

    @POST("bloapp-mom/saveMomDetails")
    Call<JsonObject> saveMomDetails(@HeaderMap HashMap<String, String> header, @Body HashMap<String, String> body);

    @POST("pse-forms/submitPSEForm7")
    Call<AsdActionrRoot> savePseForm7Details(@HeaderMap HashMap<String, String> header, @Body ArrayList<HashMap<String, Object>> map);

    @POST("bloapp/savechecklistform6a")
    Call<JsonObject> savechecklistform6a(@Header("Authorization") String authorization, @Header("currentRole") String currentRole, @Header("state") String stateCd, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, String> json);

    @POST("bloapp/savechecklistform7")
    Call<JsonObject> savechecklistform7(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String stateCd, @Header("Content-Type") String content, @Body Map<String, String> json);

    @POST("bloapp-sir/sendOtp")
    Call<String> sentOTP(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("{stateCode}/bloapp-sir/setAnomalyDocument")
    Call<AsdActionrRoot> setAnomalyDocument(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("{stateCode}/bloapp-sir/setAnomalyDocumentV2")
    Call<AsdActionrRoot> setAnomalyDocumentV2(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("enumerationFormData/setBloRemark")
    Call<JsonObject> setBloRemark(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> map);

    @POST("notification-alert/updateIsSeen")
    Call<JsonObject> setReadNotification(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @GET("aadhar-connector/store-aadhar/{aadharNo}")
    Call<JsonObject> storeAadhar(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType, @Header("moduleName") String moduleName, @Path("aadharNo") String aadharNo);

    @POST("bloapp/submitBloVipRecommended")
    Call<JsonObject> submitBloVipRecommended(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp/submitCoFormCollected")
    Call<JsonObject> submitCollectedFormCount(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp/savechecklistform6")
    Call<JsonObject> submitForm6(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("Content-Type") String contentType, @Body Map<String, String> map, @Header("PLATFORM-TYPE") String platformType);

    @POST("form7/submitForm7")
    Call<JsonObject> submitForm7(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Body Map<String, Object> map);

    @POST("form7O/submitForm7Overseas")
    Call<JsonObject> submitForm7Overseas(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Body Map<String, Object> map);

    @POST("bloapp-h2h/submitSpecialRevisionSurvey")
    Call<JsonObject> submitSpecialRevision(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp-sir/submitSpecialRevisionSurvey")
    Call<JsonObject> submitSpecialRevisionSIR(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("{stateCode}/bloapp-sir/submitSpecialRevisionSurveyPanIndia")
    Call<JsonObject> submitSpecialRevisionSurveyPanIndia(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp-sir-producer/submitSpecialRevisionSurveyPanIndia")
    Call<JsonObject> submitSpecialRevisionSurveyPanIndia(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp-h2h/AddPopulationSubmit")
    Call<JsonObject> submitStatement4Data(@HeaderMap Map<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp-report/saveCurrentRevision")
    Call<JsonObject> submitStatement6Data(@HeaderMap Map<String, String> header, @Body Map<String, Object> map);

    @POST("form6/submitForm6")
    Call<JsonObject> submitform6(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> json);

    @POST("form6a/submitNewForm6a")
    Call<JsonObject> submitform6A(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> json);

    @POST("bloapp-h2h/addUnderAgeCitizen")
    Call<JsonObject> submitstatement3(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> json);

    @GET("nvsp/trackApplication/formsByUserId?userId=8baf2e7a-5626-4422-af7a-a649a7a0835c")
    Call<JsonObject> submittedtrackstatus(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("state") String stateCode, @Header("PLATFORM-TYPE") String platformType);

    @POST("bloapp/underAgeList")
    Call<JsonObject> surveyFetch(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("state") String state, @Header("Content-Type") String content, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @POST("{stateCode}/bloapp-sir/updateAnomalyNoAction")
    Call<AsdActionrRoot> updateAnomalyNoAction(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("{stateCode}/bloapp-sir/updateBloRemark")
    Call<JsonObject> updateAnomalyRemark(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> map);

    @POST("{stateCode}/bloapp-sir/updateAsdAction")
    Call<AsdActionrRoot> updateAsdAction(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("{stateCode}/bloapp-sir/updateAttendenceByEpicID")
    Call<AsdActionrRoot> updateAttendenceByEpicID(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @POST("bloapp/updateBloAction")
    Call<AsdActionrRoot> updateBloAction(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp-h2h/updateBloCallback")
    Call<JsonObject> updateBloCallback(@Header("state") String state, @Body Map<String, Object> map);

    @POST("{stateCode}/bloapp-sir/updateBloPseAction")
    Call<AsdActionrRoot> updateBloPseAction(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp-h2h/updateEFDistributionFlg")
    Call<JsonObject> updateEfFlag(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> body);

    @POST("bloapp-sir/updateEFDistributionFlg")
    Call<JsonObject> updateEfFlagSIR(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> body);

    @POST("bloapp-h2h/updateErollData")
    Call<JsonObject> updateErollData(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> map);

    @POST("{stateCode}/bloapp-sir/updateMobileByEpicID")
    Call<JsonObject> updateMobileByEpicID(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> body);

    @POST("{stateCode}/bloapp-sir/updateNACategoryByEpicID")
    Call<AsdActionrRoot> updateNACategoryByEpicID(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @POST("bloapp/updateNotionalHNo")
    Call<JsonObject> updateNotionalHNo(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("{stateCode}/bloapp-sir/updatePSENoAction")
    Call<AsdActionrRoot> updatePSENoAction(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("{stateCode}/bloapp-sir/updatePhotoFlagInEnum")
    Call<JsonObject> updatePhotoFlagInEnum(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> body);

    @POST("bloapp-sir/updatePhotoFlagInEnum")
    Call<JsonObject> updatePhotoFlagInEnum1(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> body);

    @POST("{stateCode}/bloapp-sir/updatePhotoFlagInSurvey")
    Call<JsonObject> updatePhotoFlagInSurvey(@Path("stateCode") String stateCode, @HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> body);

    @POST("notification-alert/qr/scan")
    Call<AsdActionrRoot> updateQRSessionId(@HeaderMap HashMap<String, String> header, @Body HashMap<String, Object> map);

    @POST("formProcessingService/formatC/updateRefNoInFormatC")
    Call<Void> updateRefNoInFormatC(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> body);

    @POST("bloapp-h2h/updateSpecialRevisionform")
    Call<JsonObject> updateSpecialRevision(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp-h2h/updateSpecialRevisionformV2")
    Call<JsonObject> updateSpecialRevision2(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp-sir/updateSpecialRevisionformV2")
    Call<JsonObject> updateSpecialRevision2SIR(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp-sir-update/updateSpecialRevisionPanIndia")
    Call<JsonObject> updateSpecialRevisionPanIndia(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("bloapp-sir/updateSpecialRevisionform")
    Call<JsonObject> updateSpecialRevisionSIR(@HeaderMap HashMap<String, String> header, @Body Map<String, Object> map);

    @POST("document/uploadFile")
    @Multipart
    Call<JsonObject> uploadFile1(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("appName") String appName1, @Part MultipartBody.Part file, @Part("bucketName") RequestBody bucketName, @Part("fileType") RequestBody fileType, @Part("fileName") RequestBody fileName, @Part("stateCode") RequestBody stateCode, @Part("acNo") RequestBody acNo, @Part("partNo") RequestBody partNo, @Part("type") RequestBody type, @Part("appName") RequestBody appName, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("PLATFORM-TYPE") String platformType);

    @POST("document/uploadFile")
    @Multipart
    Call<JsonObject> uploadImageWithData1(@Header("Authorization") String authorization, @Header("atkn_bnd") String atknBnd, @Header("rtkn_bnd") String rtknBnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("appName") String appName1, @Header("PLATFORM-TYPE") String platformType, @Part MultipartBody.Part file, @Part("fileType") RequestBody fileType, @Part("fileName") RequestBody fileName, @Part("stateCode") RequestBody stateCode, @Part("acNo") RequestBody acNo, @Part("partNo") RequestBody partNo, @Part("type") RequestBody type, @Part("appName") RequestBody appName);

    @POST("document/uploadFile")
    @Multipart
    Call<JsonObject> uploadImageWithData1(@Header("Authorization") String authorization, @Header("CurrentRole") String currentRole, @Header("appName") String appName1, @Header("PLATFORM-TYPE") String platformType, @Part MultipartBody.Part file, @Part("fileType") RequestBody fileType, @Part("fileName") RequestBody fileName, @Part("stateCode") RequestBody stateCode, @Part("acNo") RequestBody acNo, @Part("partNo") RequestBody partNo, @Part("type") RequestBody type, @Part("appName") RequestBody appName);

    @GET("form8/validateAgeWithSirAgeCutOff")
    Call<JsonObject> validateAgeWithSirAgeCutOff(@Query("age") int epicNumber, @Query("state") String statecode, @Header("Authorization") String authorization, @Header("currentrole") String currentRole, @Header("applicationname") String applicationname, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("state") String state, @Header("PLATFORM-TYPE") String platformType);

    @POST("bloapp-sir/validateSirProgenyMapping")
    Call<JsonObject> validateProgenySirMapping(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp-sir/validateSirMapping")
    Call<JsonObject> validateSirMapping(@HeaderMap HashMap<String, String> header, @Body Map<String, String> map);

    @POST("bloapp-sir/verifyOtp")
    Call<JsonObject> verifyOTP(@Header("Authorization") String authorization, @Header("atkn_bnd") String atkn_bnd, @Header("rtkn_bnd") String rtkn_bnd, @Header("channelidobo") String channelidobo, @Header("CurrentRole") String currentRole, @Header("PLATFORM-TYPE") String platformType, @Body Map<String, Object> map);

    @GET("bloapp-h2h/verifyMapping")
    Call<JsonObject> vewrifyErollData(@HeaderMap HashMap<String, String> header, @Query("id") int map);
}
