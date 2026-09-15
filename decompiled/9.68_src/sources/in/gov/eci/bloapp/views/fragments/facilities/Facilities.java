package in.gov.eci.bloapp.views.fragments.facilities;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.CursorWindow;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.SpinnerAdapter;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.model.EronetResonse;
import in.gov.eci.bloapp.databinding.BloAllFacilitiesRvItemBinding;
import in.gov.eci.bloapp.databinding.BloDeletebottomfileBinding;
import in.gov.eci.bloapp.databinding.BloFragmentFacilitiesBinding;
import in.gov.eci.bloapp.databinding.BloImagesBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.FacilitiesViewModel;
import in.gov.eci.bloapp.views.activity.FacilityUpdateSuccessActivity;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.MapsActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IntCompanionObject;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class Facilities extends Hilt_Facilities implements AdapterView.OnItemSelectedListener {
    BloAllFacilitiesRvItemBinding BloAllFacilitiesRvItemBinding;
    ActivityResultLauncher<Intent> activityResultLauncher;
    GenericRecyclerView adapter;
    GenericRecyclerView adapter1;
    FilterableRecyclerView adapter2;
    String address;
    List<String> addressList;
    AlertDialog alertDialog;
    AlertDialog alertDialog1;
    ArrayAdapter<String> amfEmfStatusAdapter;
    ArrayList<String> amfEmfStatusList;
    String amfEmfValueFromDropDown;
    String asmblyNO;
    String asmblyName;
    BloFragmentFacilitiesBinding binding;
    Retrofit.Builder builder;
    byte[] byteArray;
    ActivityResultLauncher<Intent> cameraLauncher;
    String captureFileName;
    String changelatitude;
    String changelongitude;
    int countimg;
    String districtCode;
    String districtName;
    File file1;
    FusedLocationProviderClient fusedLocationProviderClient;
    String id;
    Uri imageUri;
    String imagetext;
    List<String> imagetextList;
    String langName;
    double latitude;
    ArrayList<String> latitudeList;
    LayoutInflater layoutInflater;
    LocationRequest locationRequest;
    double longitude;
    ArrayList<String> longitudeList;
    String partAdd;
    String partAddress;
    String partLang;
    String partName;
    String partNo;
    String password;
    ArrayList<String> referenceList;
    String refreshToken;
    Retrofit retrofit;
    String setPhotoReferenceNumber;
    String stateCode;
    String stateName;
    String street;
    String totalPartNumber;
    String userName;
    FacilitiesViewModel viewModel;
    CommomUtility commonutils = new CommomUtility();
    boolean openActivity = false;
    ArrayList<Integer> images = new ArrayList<>();
    ArrayList<String> mHeaders = new ArrayList<>();
    ArrayList<String> headers = new ArrayList<>();
    ArrayList<String> finalHeaders = new ArrayList<>();
    String response = "";
    String boothId = "";
    String pollingStationName = "";
    String captureGpsAddress = "";
    String provisionRampToScreen = "";
    String drinkingWaterToScreen = "";
    String amfAdequateFurnitureToScreen = "";
    String lightingToScreen = "";
    String helpDeskToScreen = "";
    String signnageToScreen = "";
    String toiletToScreen = "";
    String permanentRampToScreen = "";
    String emfAdequateFurnitureToScreen = "";
    String shatterToScreen = "";
    String roadConnectivityToScreen = "";
    String crossingToScreen = "";
    String landlineFaxConnectionToScreen = "";
    String mobileConnectivityToScreen = "";
    String electricityArrangementToScreen = "";
    String internetFacilityToScreen = "";
    String signanceToScreen = "";
    String lweAffectedAreaToScreen = "";
    String forestAreaToScreen = "";
    String vulnerableLocationToScreen = "";
    String sensitivePsToScreen = "";
    String buildingQualityToScreen = "";
    String psLessThan20ToScreen = "";
    String buildingStatusToScreen = "";
    String governmentPsToScreen = "";
    String religiousPsToScreen = "";
    String schoolPsToScreen = "";
    String groundFloorPsToScreen = "";
    String seperateEntryExitToScreen = "";
    String politicalPartyOfficeWithin200MetersToScreen = "";
    String drinkingWaterInPremisesToScreen = "";
    String electricitySupplyToScreen = "";
    String properLightingFixturesToScreen = "";
    String toiletMaleFemaleToScreen = "";
    String parkingAvailableToScreen = "";
    String provisionRampRemarksToScreen = "";
    String drinkingWaterRemarksToScreen = "";
    String amfAdequateFurnitureRemarksToScreen = "";
    String lightingRemarksToScreen = "";
    String helpDeskRemarksToScreen = "";
    String signnageRemarksToScreen = "";
    String toiletRemarksToScreen = "";
    String permanentRampRemarksToScreen = "";
    String emfAdequateFurnitureRemarksToScreen = "";
    String shatterRemarksToScreen = "";
    String roadConnectivityRemarksToScreen = "";
    String crossingRemarksToScreen = "";
    String landlineFaxConnectionRemarksToScreen = "";
    String mobileConnectivityRemarksToScreen = "";
    String electricityArrangementsRemarksToScreen = "";
    String internetFacilityRemarksToScreen = "";
    String signanceRemarksToScreen = "";
    String lweAffectedAreaRemarksToScreen = "";
    String forestAreaRemarksToScreen = "";
    String vulnerableLocationRemarksToScreen = "";
    String sensitivePsRemarksToScreen = "";
    String buildingQualityRemarksToScreen = "";
    String psLessThan20RemarksToScreen = "";
    String buildingStatusRemarksToScreen = "";
    String governmentPsRemarksToScreen = "";
    String religiousPsRemarksToScreen = "";
    String schoolPsRemarksToScreen = "";
    String groundFloorPsRemarksToScreen = "";
    String seperateEntryExitRemarksToScreen = "";
    String politicalPartyOfficeWithin200MetersRemarksToScreen = "";
    String drinkingWaterInPremisesRemarksToScreen = "";
    String electricitySupplyRemarksToScreen = "";
    String properLightingFixturesRemarksToScreen = "";
    String toiletMaleFemaleRemarksToScreen = "";
    String parkingAvailableRemarksToScreen = "";
    String provisionRampAmfEmfStatusToScreen = "";
    String drinkingWaterAmfEmfStatusToScreen = "";
    String amfAdequateFurnitureAmfEmfStatusToScreen = "";
    String lightingAmfEmfStatusToScreen = "";
    String helpDeskAmfEmfStatusToScreen = "";
    String signnageAmfEmfStatusToScreen = "";
    String toiletAmfEmfStatusToScreen = "";
    String permanentRampAmfEmfStatusToScreen = "";
    String emfAdequateFurnitureAmfEmfStatusToScreen = "";
    String shatterAmfEmfStatusToScreen = "";
    String roadConnectivityAmfEmfStatusToScreen = "";
    String crossingAmfEmfStatusToScreen = "";
    String landlineFaxConnectionAmfEmfStatusToScreen = "";
    String mobileConnectivityAmfEmfStatusToScreen = "";
    String electricityArrangementsAmfEmfStatusToScreen = "";
    String internetFacilityAmfEmfStatusToScreen = "";
    String signanceAmfEmfStatusToScreen = "";
    String lweAffectedAreaAmfEmfStatusToScreen = "";
    String forestAreaAmfEmfStatusToScreen = "";
    String vulnerableLocationAmfEmfStatusToScreen = "";
    String sensitivePsAmfEmfStatusToScreen = "";
    String buildingQualityAmfEmfStatusToScreen = "";
    String psLessThan20AmfEmfStatusToScreen = "";
    String buildingStatusAmfEmfStatusToScreen = "";
    String governmentPsAmfEmfStatusToScreen = "";
    String religiousPsAmfEmfStatusToScreen = "";
    String schoolPsAmfEmfStatusToScreen = "";
    String groundFloorPsAmfEmfStatusToScreen = "";
    String seperateEntryExitAmfEmfStatusToScreen = "";
    String politicalPartyOfficeWithin200MetersAmfEmfStatusToScreen = "";
    String drinkingWaterInPremisesAmfEmfStatusToScreen = "";
    String electricitySupplyAmfEmfStatusToScreen = "";
    String properLightingFixturesAmfEmfStatusToScreen = "";
    String toiletMaleFemaleAmfEmfStatusToScreen = "";
    String parkingAvailableAmfEmfStatusToScreen = "";
    String provisionRampRatingToScreen = "";
    String drinkingWaterRatingToScreen = "";
    String amfAdequateFurnitureRatingToScreen = "";
    String lightingRatingToScreen = "";
    String helpDeskRatingToScreen = "";
    String signnageRatingToScreen = "";
    String toiletRatingToScreen = "";
    String permanentRampRatingToScreen = "";
    String emfAdequateFurnitureRatingToScreen = "";
    String shatterRatingToScreen = "";
    String roadConnectivityRatingToScreen = "";
    String crossingRatingToScreen = "";
    String landlineFaxConnectionRatingToScreen = "";
    String mobileConnectivityRatingToScreen = "";
    String electricityArrangementsRatingToScreen = "";
    String internetFacilityRatingToScreen = "";
    String signanceRatingToScreen = "";
    String lweAffectedAreaRatingToScreen = "";
    String forestAreaAreaRatingToScreen = "";
    String vulnerableLocationRatingToScreen = "";
    String sensitivePsRatingToScreen = "";
    String buildingQualityRatingToScreen = "";
    String psLessThan20RatingToScreen = "";
    String buildingStatusRatingToScreen = "";
    String governmentPsRatingToScreen = "";
    String religiousPsRatingToScreen = "";
    String schoolPsRatingToScreen = "";
    String groundFloorPsRatingToScreen = "";
    String seperateEntryExitRatingToScreen = "";
    String politicalPartyOfficeWithin200MetersRatingToScreen = "";
    String drinkingWaterInPremisesRatingToScreen = "";
    String electricitySupplyRatingToScreen = "";
    String properLightingFixturesRatingToScreen = "";
    String toiletMaleFemaleRatingToScreen = "";
    String parkingAvailableRatingToScreen = "";
    String stateCd = "S04";
    String acNumber = "167";
    String partNumber = "9";
    String amfRamp = "";
    String amfRampComment = "";
    String amfRampRating = "";
    String amfDrinkingWater = "";
    String amfDrinkingWaterComment = "";
    String amfDrinkingWaterRating = "";
    String amfFurniture = "";
    String amfFurnitureComment = "";
    String amfFurnitureRating = "";
    String amfLighting = "";
    String amfLightingComment = "";
    String amfLightingRating = "";
    String amfHelpDesk = "";
    String amfHelpDeskComment = "";
    String amfHelpDeskRating = "";
    String amfSignage = "";
    String amfSignageComment = "";
    String amfSignageRating = "";
    String amfToilet = "";
    String amfToiletComment = "";
    String amfToiletRating = "";
    String permanentRamp = "";
    String permanentRampComment = "";
    String permanentRampRating = "";
    String furniture = "";
    String furnitureComment = "";
    String furnitureRating = "";
    String shade = "";
    String shadeComment = "";
    String shadeRating = "";
    String road = "";
    String roadComment = "";
    String roadRating = "";
    String toCrossNaturalObstacles = "";
    String toCrossNaturalObstaclesComment = "";
    String toCrossNaturalObstaclesRating = "";
    String teleConnection = "";
    String teleConnectionComment = "";
    String teleConnectionRating = "";
    String mobileConnectivity = "";
    String mobileConnectivityComment = "";
    String mobileConnectivityRating = "";
    String electricitySupply = "";
    String electricitySupplyComment = "";
    String electricitySupplyRating = "";
    String internet = "";
    String internetComment = "";
    String internetRating = "";
    String signage = "";
    String signageComment = "";
    String signageRating = "";
    String inLweInsurgencyAffectedArea = "";
    String inLweInsurgencyAffectedAreaComment = "";
    String inLweInsurgencyAffectedAreaRating = "";
    String forestSemiForestArea = "";
    String forestSemiForestAreaComment = "";
    String forestSemiForestAreaRating = "";
    String vulnerableCriticalLocation = "";
    String vulnerableCriticalLocationComment = "";
    String vulnerableCriticalLocationRating = "";
    String sensitiveHyperSensitivePs = "";
    String sensitiveHyperSensitivePsComment = "";
    String sensitiveHyperSensitivePsRating = "";
    String buildingQuality = "";
    String buildingQualityComment = "";
    String buildingQualityRating = "";
    String lessThan20Sqmts = "";
    String isPollingboothAreaIsLt20SqmtsComment = "";
    String lessThan20SqmtsRating = "";
    String buildingIsDangerous = "";
    String buildingIsDangerousComment = "";
    String buildingIsDangerousRating = "";
    String governmentBuildingPremises = "";
    String governmentBuildingPremisesComment = "";
    String governmentBuildingPremisesRating = "";
    String locatedIsAnInstitutionReligiousPlace = "";
    String locatedIsAnInstitutionReligiousPlaceComment = "";
    String locatedIsAnInstitutionReligiousPlaceRating = "";
    String schoolCollegBuilding = "";
    String schoolCollegBuildingComment = "";
    String schoolCollegBuildingRating = "";
    String groundFloor = "";
    String groundFloorComment = "";
    String groundFloorRating = "";
    String seperatedDoorForEntryAndExit = "";
    String seperatedDoorForEntryAndExitComment = "";
    String seperatedDoorForEntryAndExitRating = "";
    String politicalPartyOfficeWithin200Meters = "";
    String politicalPartyOfficeWithin200MetersComment = "";
    String politicalPartyOfficeWithin200MetersRating = "";
    String drinkingWaterFacilityInPremises = "";
    String drinkingWaterFacilityInPremisesComment = "";
    String drinkingWaterFacilityInPremisesRating = "";
    String emfElectricitySupply = "";
    String emfElectricitySupplyComment = "";
    String emfElectricitySupplyRating = "";
    String properLightingsFixtures = "";
    String properLightingsFixturesComment = "";
    String properLightingsFixturesRating = "";
    String toiletMaleFemale = "";
    String toiletMaleFemaleComment = "";
    String toiletMaleFemaleRating = "";
    String parkingAvailable = "";
    String parkingAvailableComment = "";
    String parkingAvailableRating = "";
    int count11 = 0;
    int count55 = 0;
    int count66 = 0;
    int count77 = 0;
    ArrayList<byte[]> imageList = new ArrayList<>();
    String tokenValue = "";
    Gson gson = new GsonBuilder().setLenient().create();
    CommomUtility commonUtilClass = new CommomUtility();
    String entrancebool = "N";
    String googleMapsViewbool = "N";
    String psFrntViewbool = "N";
    String keyMapbool = "N";
    String homeMaleText = "Home Male - ";
    String homeFemaleText = "Home Female - ";
    String homeTotalText = "Home Total - ";
    String homeTransText = "Home Trans - ";
    String logTag = "Facility";
    String bearerText = "Bearer ";
    String getRefreshTokenText = "getRefreshToken : ";
    String alertText = "Alert";
    String noInternetText = "No Internet";
    String buildingfrontview = "Front Building view";
    String googlemapsview = "Google Maps view";
    String frontpsview = "Front PS view";
    String keymapview = "Key map view";
    String refIdText = "refId";
    String messageText = "message";
    String entranceBoolvariable = "entrancebool";
    String googleBoolvariable = "googleMapsViewbool";
    String psfrontBoolVariable = "psFrntViewbool";
    String keyBoolvariable = "keyMapbool";
    String cominginfailure = "coming in onFailure ";
    String latitudeandlongi = "latitude and longitude";
    String stateCdText = "stateCd";
    String acNumberText = "acNumber";
    String partNumberText = "partNumber";
    String amfRampText = "amfRamp";
    String amfRampCommentText = "amfRampComment";
    String amfRampRatingText = "amfRampRating";
    String amfDrinkingWaterText = "amfDrinkingWater";
    String amfDrinkingWaterCommentText = "amfDrinkingWaterComment";
    String amfDrinkingWaterRatingText = "amfDrinkingWaterRating";
    String amfFurnitureText = "amfFurniture";
    String amfFurnitureCommentText = "amfFurnitureComment";
    String amfFurnitureRatingText = "amfFurnitureRating";
    String amfLightingText = "amfLighting";
    String amfLightingCommentText = "amfLightingComment";
    String amfLightingRatingText = "amfLightingRating";
    String amfHelpDeskText = "amfHelpDesk";
    String amfHelpDeskCommentText = "amfHelpDeskComment";
    String amfHelpDeskRatingText = "amfHelpDeskRating";
    String amfSignageText = "amfSignage";
    String amfSignageCommentText = "amfSignageComment";
    String amfSignageRatingText = "amfSignageRating";
    String amfToiletText = "amfToilet";
    String amfToiletCommentText = "amfToiletComment";
    String amfToiletRatingText = "amfToiletRating";
    String furnitureText = "furniture";
    String furnitureCommentText = "furnitureComment";
    String furnitureRatingText = "furnitureRating";
    String shadeText = "shade";
    String shadeCommentText = "shadeComment";
    String shadeRatingText = "shadeRating";
    String roadText = "road";
    String roadCommentText = "roadComment";
    String roadRatingText = "roadRating";
    String toCrossNaturalObstaclesText = "toCrossNaturalObstacles";
    String toCrossNaturalObstaclesCommentText = "toCrossNaturalObstaclesComment";
    String toCrossNaturalObstaclesRatingText = "toCrossNaturalObstaclesRating";
    String teleConnectionText = "teleConnection";
    String teleConnectionCommentText = "teleConnectionComment";
    String teleConnectionRatingText = "teleConnectionRating";
    String mobileConnectivityText = "mobileConnectivity";
    String mobileConnectivityCommentText = "mobileConnectivityComment";
    String mobileConnectivityRatingText = "mobileConnectivityRating";
    String lightingText = "lighting";
    String lightingCommentText = "lightingComment";
    String lightingRatingText = "lightingRating";
    String internetText = "internet";
    String internetCommentText = "internetComment";
    String internetRatingText = "internetRating";
    String signageText = "signage";
    String signageCommentText = "signageComment";
    String signageRatingtext = "signageRating";
    String inLweInsurgencyAffectedAreaText = "inLweInsurgencyAffectedArea";
    String inLweInsurgencyAffectedAreaCommentText = "inLweInsurgencyAffectedAreaComment";
    String inLweInsurgencyAffectedAreaRatingText = "inLweInsurgencyAffectedAreaRating";
    String forestSemiForestAreaText = "forestSemiForestArea";
    String forestSemiForestAreaCommentText = "forestSemiForestAreaComment";
    String forestSemiForestAreaRatingText = "forestSemiForestAreaRating";
    String vulnerableCriticalLocationText = "vulnerableCriticalLocation";
    String vulnerableCriticalLocationCommentText = "vulnerableCriticalLocationComment";
    String vulnerableCriticalLocationRatingText = "vulnerableCriticalLocationRating";
    String sensitiveHyperSensitivePsText = "sensitiveHyperSensitivePs";
    String sensitiveHyperSensitivePsCommentText = "sensitiveHyperSensitivePsComment";
    String sensitiveHyperSensitivePsRatingText = "sensitiveHyperSensitivePsRating";
    String buildingQualityText = "buildingQuality";
    String buildingQualityCommentText = "buildingQualityComment";
    String buildingQualityRatingText = "buildingQualityRating";
    String lessThan20SqmtsText = "lessThan20Sqmts";
    String isPollingboothAreaIsLt20SqmtsCommentText = "isPollingboothAreaIsLt20SqmtsComment";
    String lessThan20SqmtsRatingText = "lessThan20SqmtsRating";
    String buildingIsDangerousText = "buildingIsDangerous";
    String buildingIsDangerousCommentText = "buildingIsDangerousComment";
    String buildingIsDangerousRatingText = "buildingIsDangerousRating";
    String governmentBuildingPremisesText = "governmentBuildingPremises";
    String governmentBuildingPremisesCommentText = "governmentBuildingPremisesComment";
    String governmentBuildingPremisesRatingText = "governmentBuildingPremisesRating";
    String locatedIsAnInstitutionReligiousPlaceText = "locatedIsAnInstitutionReligiousPlace";
    String locatedIsAnInstitutionReligiousPlaceCommentText = "locatedIsAnInstitutionReligiousPlaceComment";
    String locatedIsAnInstitutionReligiousPlaceRatingText = "locatedIsAnInstitutionReligiousPlaceRating";
    String schoolCollegBuildingText = "schoolCollegBuilding";
    String schoolCollegBuildingCommentText = "schoolCollegBuildingComment";
    String schoolCollegBuildingRatingText = "schoolCollegBuildingRating";
    String groundFloorText = "groundFloor";
    String groundFloorCommentText = "groundFloorComment";
    String groundFloorRatingText = "groundFloorRating";
    String seperatedDoorForEntryAndExitText = "seperatedDoorForEntryAndExit";
    String seperatedDoorForEntryAndExitCommentText = "seperatedDoorForEntryAndExitComment";
    String seperatedDoorForEntryAndExitRatingText = "seperatedDoorForEntryAndExitRating";
    String permanentRampText = "permanentRamp";
    String permanentRampCommentText = "permanentRampComment";
    String permanentRampRatingText = "permanentRampRating";
    String politicalPartyOfficeWithin200MText = "politicalPartyOfficeWithin200M";
    String politicalPartyOfficeWithin200MCommentText = "politicalPartyOfficeWithin200MComment";
    String politicalPartyOfficeWithin200MRatingText = "politicalPartyOfficeWithin200MRating";
    String drinkingWaterText = "drinkingWater";
    String drinkingWaterCommentText = "drinkingWaterComment";
    String drinkingWaterRatingText = "drinkingWaterRating";
    String electricitySupplyText = "electricitySupply";
    String electricitySupplyCommentText = "electricitySupplyComment";
    String electricitySupplyRatingText = "electricitySupplyRating";
    String properLightingsText = "properLightings";
    String properLightingsCommentText = "properLightingsComment";
    String properLightingsRatingText = "properLightingsRating";
    String toiletText = "toilet";
    String toiletCommentText = "toiletComment";
    String toiletRatingText = "toiletRating";
    String parkingAvailabilityText = "parkingAvailability";
    String parkingAvailabilityCommentText = "parkingAvailabilityComment";
    String parkingAvailabilityRatingText = "parkingAvailabilityRating";
    String textForY = "Y";
    String textForN = "N";
    String goodText = "Good";
    String averageText = "Average";
    String poorText = "Poor";
    String availableText = "Available";
    String enableText = "Enable";
    String disableText = "Disable";
    String notAvailableText = "Not Available";
    String refreshText = "Refresh";
    String availableGoodText = "Available_Good";
    String availableAverageText = "Available_Average";
    String availablePoorText = "Available_Poor";
    String editText = "Edit";
    String sessionExpiredText = "Session Expired. Please Login again..";
    String sessionExpiredTextForRefresh = "Page refreshed due to the token expiry.";
    String sessionphotoexpired = "Page refreshed due to the token expiry, Please upload again.";
    String nullText = "null";
    String okText = "Ok";
    String bloappkey = "BLOAPP";
    String keyMapImageText = "keyMapImage";
    String cameraText = "Camera ";
    String insideCameraText = "inside camera";
    String imageText1 = "image";
    String cursorEmptyText = "Can't obtain file name, cursor is empty";
    String moreThan2MbText = "The Selected file exceeds 2MB size limit.Kindly retry!";
    String takePhotoText = "Take Photo";
    String addPhotoText = "Add Photo!";
    String cancelText = "Cancel";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    CommomUtility commomUtility = new CommomUtility();

    static /* synthetic */ void lambda$turnOnGPS$25(Task task) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public Facilities() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.cameraLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda0
            public final void onActivityResult(Object obj) {
                this.f$0.lambda$new$0((ActivityResult) obj);
            }
        });
        this.activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda11
            public final void onActivityResult(Object obj) {
                this.f$0.lambda$new$1((ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            Logger.d(this.logTag, this.cameraText + this.insideCameraText);
            Bitmap bitmap = (Bitmap) activityResult.getData().getExtras().get("data");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            this.byteArray = byteArrayOutputStream.toByteArray();
            new WeakReference(Bitmap.createScaledBitmap(bitmap, bitmap.getHeight(), bitmap.getWidth(), false).copy(Bitmap.Config.RGB_565, true));
            try {
                this.imageUri = getSaveImagePath(Base64.encodeToString(this.byteArray, 0), this.imageText1);
            } catch (IOException e) {
                Logger.d(this.logTag, e.getMessage());
            }
            File file = new File(getActivity().getFilesDir(), this.imageUri.getPath());
            this.file1 = file;
            Logger.d("file1 ", String.valueOf(file));
            String[] strArrSplit = String.valueOf(this.file1).split("/");
            String str = strArrSplit[strArrSplit.length - 1];
            this.captureFileName = str;
            Logger.d("captureFileName ", str);
            Logger.d(this.logTag, "image uri in camera" + this.imageUri);
            Cursor cursorQuery = getContext().getContentResolver().query(this.imageUri, null, null, null, null);
            if (cursorQuery.getCount() <= 0) {
                cursorQuery.close();
                throw new IllegalArgumentException(this.cursorEmptyText);
            }
            cursorQuery.moveToFirst();
            if (this.filesize > 2048) {
                Logger.d(this.logTag, String.valueOf(Math.round(this.filesize * 100.0d) / 100.0d));
                showalertdialog(this.alertText, this.moreThan2MbText);
            } else {
                float f = this.filesize / 1024.0f;
                double dRound = Math.round(((double) f) * 100.0d) / 100.0d;
                Logger.d(this.logTag, String.valueOf(f));
                Logger.d(this.logTag, String.valueOf(dRound));
                this.imageList.add(this.byteArray);
                initRecyclerViewAdapter();
                this.binding.images.setLayoutManager(new GridLayoutManager(getContext(), 1, 0, false));
                this.binding.images.setAdapter(this.adapter);
                this.binding.pollingStationNameLayout.setVisibility(8);
                this.binding.mainScrollView.setVisibility(8);
                this.binding.linearLayoutForBtns.setVisibility(8);
                ImageView imageView = this.binding.image;
                byte[] bArr = this.byteArray;
                imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                this.binding.imglayout.setVisibility(0);
                this.binding.homeBtnIv1.setVisibility(0);
            }
            this.binding.radiohead.clearCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            Uri data = activityResult.getData().getData();
            RequestOptions requestOptionsOverride = new RequestOptions().override(IntCompanionObject.MIN_VALUE, 100);
            Cursor cursorQuery = getContext().getContentResolver().query(data, null, null, null, null);
            if (cursorQuery.getCount() <= 0) {
                cursorQuery.close();
                throw new IllegalArgumentException(this.cursorEmptyText);
            }
            cursorQuery.moveToFirst();
            int columnIndex = cursorQuery.getColumnIndex("_size");
            if (cursorQuery.getFloat(columnIndex) / 1000.0f > 2048.0f) {
                showalertdialog(this.alertText, this.moreThan2MbText);
                return;
            }
            cursorQuery.getFloat(columnIndex);
            this.binding.imglayout.setVisibility(0);
            this.binding.homeBtnIv1.setVisibility(0);
            Glide.with(requireContext()).asBitmap().load(data).apply(requestOptionsOverride).into(new SimpleTarget<Bitmap>() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities.1
                public /* bridge */ /* synthetic */ void onResourceReady(Object resource, Transition transition) {
                    onResourceReady((Bitmap) resource, (Transition<? super Bitmap>) transition);
                }

                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                    Facilities.this.binding.image.setImageBitmap(resource);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    resource.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    Facilities.this.byteArray = byteArrayOutputStream.toByteArray();
                    Facilities.this.imageList.add(Facilities.this.byteArray);
                }
            });
            initRecyclerViewAdapter();
            this.binding.images.setLayoutManager(new GridLayoutManager(getContext(), 1, 0, false));
            this.binding.images.setAdapter(this.adapter);
            this.binding.pollingStationNameLayout.setVisibility(8);
            this.binding.mainScrollView.setVisibility(8);
            this.binding.linearLayoutForBtns.setVisibility(8);
            this.binding.radiohead.clearCheck();
        }
    }

    @Deprecated
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity());
        this.binding = BloFragmentFacilitiesBinding.inflate(getLayoutInflater());
        this.viewModel = (FacilitiesViewModel) new ViewModelProvider(requireActivity()).get(FacilitiesViewModel.class);
        this.binding.imglayout.setVisibility(8);
        this.binding.homeBtnIv1.setVisibility(8);
        this.binding.titleBarprev.setVisibility(8);
        this.binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda27
            public final void onRefresh() {
                this.f$0.lambda$onCreateView$3();
            }
        });
        this.BloAllFacilitiesRvItemBinding = BloAllFacilitiesRvItemBinding.inflate(getLayoutInflater());
        this.tokenValue = SharedPref.getInstance(requireContext()).getToken();
        this.userName = SharedPref.getInstance(requireContext()).getUserName();
        this.password = SharedPref.getInstance(requireContext()).getPassword();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.districtCode = SharedPref.getInstance(requireContext()).getDistrictCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.totalPartNumber = SharedPref.getInstance(requireContext()).getTotalPartNumber();
        this.stateName = SharedPref.getInstance(requireContext()).getStateName();
        this.districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        this.asmblyName = SharedPref.getInstance(requireContext()).getAssemblyName();
        this.partName = SharedPref.getInstance(requireContext()).getPartName();
        this.langName = SharedPref.getInstance(requireContext()).getLanguageName();
        this.partLang = SharedPref.getInstance(requireContext()).getPartNumberLanguageName();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        Logger.d(this.logTag, "tokenValue -- > " + this.tokenValue);
        Logger.d(this.logTag, "stateCode -- > " + this.stateCode);
        Logger.d(this.logTag, "districtCode -- > " + this.districtCode);
        Logger.d(this.logTag, "asmblyNO -- > " + this.asmblyNO);
        Logger.d(this.logTag, "totalPartNumber -- > " + this.totalPartNumber);
        Logger.d(this.logTag, "stateName -- > " + this.stateName);
        Logger.d(this.logTag, "districtName -- > " + this.districtName);
        Logger.d(this.logTag, "asmblyName -- > " + this.asmblyName);
        Logger.d(this.logTag, "partName -- > " + this.partName);
        Logger.d(this.logTag, "langName -- > " + this.langName);
        Logger.d(this.logTag, "partLang -- > " + this.partLang);
        Logger.d(this.logTag, "partNo -- > " + this.partNo);
        Logger.d(this.logTag, "refreshToken -- > " + this.refreshToken);
        fetchaddress();
        this.layoutInflater = LayoutInflater.from(getActivity());
        View viewInflate = inflater.inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.referenceList = new ArrayList<>();
        if (isNetworkAvailable(requireContext())) {
            this.alertDialog.show();
            this.commonUtilClass.getGenderWiseElectorsCount(this.stateCode, this.asmblyNO, this.partNo, this.tokenValue, getContext());
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreateView$4();
                }
            }, 2000L);
            fetchDataFromAMFEMFApi();
        }
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(1000L);
        this.locationRequest.setFastestInterval(1000L);
        this.binding.preview.setVisibility(8);
        this.addressList = new ArrayList();
        this.longitudeList = new ArrayList<>();
        this.latitudeList = new ArrayList<>();
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities.2
            public void handleOnBackPressed() {
                Facilities.this.binding.preview.setVisibility(8);
                Facilities.this.binding.pollingStationNameLayout.setVisibility(0);
                Facilities.this.binding.mainScrollView.setVisibility(0);
                Facilities.this.binding.titleBarprev.setVisibility(8);
                Facilities.this.binding.linearLayoutForBtns.setVisibility(0);
                Facilities.this.binding.titleBar.setVisibility(0);
            }
        });
        this.imagetextList = new ArrayList();
        assigntagValues();
        this.images.add(Integer.valueOf(R.drawable.blo_ramp));
        this.images.add(Integer.valueOf(R.drawable.blo_water));
        this.images.add(Integer.valueOf(R.drawable.blo_furniture));
        this.images.add(Integer.valueOf(R.drawable.blo_lightning));
        this.images.add(Integer.valueOf(R.drawable.blo_help_desk));
        this.images.add(Integer.valueOf(R.drawable.blo_signnage));
        this.images.add(Integer.valueOf(R.drawable.blo_toilet));
        this.images.add(Integer.valueOf(R.drawable.blo_ramp));
        this.images.add(Integer.valueOf(R.drawable.blo_furniture));
        this.images.add(Integer.valueOf(R.drawable.blo_shatter));
        this.images.add(Integer.valueOf(R.drawable.blo_road_connectivity));
        this.images.add(Integer.valueOf(R.drawable.blo_river_cross));
        this.images.add(Integer.valueOf(R.drawable.blo_landline));
        this.images.add(Integer.valueOf(R.drawable.blo_mobile));
        this.images.add(Integer.valueOf(R.drawable.blo_internet));
        this.images.add(Integer.valueOf(R.drawable.blo_signnage));
        this.images.add(Integer.valueOf(R.drawable.blo_insurgency_area));
        this.images.add(Integer.valueOf(R.drawable.blo_forest));
        this.images.add(Integer.valueOf(R.drawable.blo_vulnerable));
        this.images.add(Integer.valueOf(R.drawable.blo_sensitive));
        this.images.add(Integer.valueOf(R.drawable.blo_building_quality));
        this.images.add(Integer.valueOf(R.drawable.blo_ps_dimension));
        this.images.add(Integer.valueOf(R.drawable.blo_danger));
        this.images.add(Integer.valueOf(R.drawable.blo_government_building));
        this.images.add(Integer.valueOf(R.drawable.blo_religious_place));
        this.images.add(Integer.valueOf(R.drawable.blo_school));
        this.images.add(Integer.valueOf(R.drawable.blo_ground_floor));
        this.images.add(Integer.valueOf(R.drawable.blo_entry_exit));
        this.images.add(Integer.valueOf(R.drawable.blo_meeting_room));
        this.images.add(Integer.valueOf(R.drawable.blo_water));
        this.images.add(Integer.valueOf(R.drawable.blo_electricity_icon));
        this.images.add(Integer.valueOf(R.drawable.blo_lightning));
        this.images.add(Integer.valueOf(R.drawable.blo_toilet));
        this.images.add(Integer.valueOf(R.drawable.blo_parking_icon));
        this.images.add(Integer.valueOf(R.drawable.blo_lightning));
        this.headers.add(String.format(getString(R.string.blo_Provision_for_ramp), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Provision_for_drinking_water), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Adequate_furniture_for_AMF), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Proper_lightning), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Help_desk), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Proper_signnage), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Toilet), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Permanent_ramp), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Adequate_Furniture_for_EMF), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Shade_shatter_for_protection_from_sun_rain), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_PS_with_proper_road_connectivity), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Voter_have_to_cross_river_valley_ravine_or_natural_obstacles_to_reach_PS), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Landline_telephone_fax_connection), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Mobile_connectivity), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Internet_Facility), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Proper_signage_of_building_name_and_address), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_LWE_insurgency_affected_area), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Forest_semi_forest_area), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Vulnerable_critical_location), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Sensitive_hyper_sensitive_PS), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Building_quality), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_PS_with_less_than_20_sqmts), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Building_is_dilapidated_or_dangerous), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_PS_is_in_Government_building_premises), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_PS_located_is_an_institution_religious_place), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_PS_in_school_college_building), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_PS_on_ground_floor), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Seperate_door_for_Entry_Exit), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_political_Party_Office_Situated_Within_200_meters_of_PS_premises), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_PS_having_drinking_water_facility_in_the_premises), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_PS_having_Electricity_Supply), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_PS_buildings_having_Proper_lightings_Fixtures_etc), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_PS_buildings_with_Toilet_Male_Female), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_facility_Parking_Available), new Object[0]));
        this.headers.add(String.format(getString(R.string.blo_Lighting_electricity_arrangements), new Object[0]));
        this.finalHeaders = this.headers;
        initRecyclerViewAdapter2();
        this.binding.allFacilitiesRv.setLayoutManager(new GridLayoutManager(getContext(), 1, 1, false));
        this.binding.allFacilitiesRv.setAdapter(this.adapter1);
        try {
            Field declaredField = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            declaredField.setAccessible(true);
            declaredField.set(null, 104857600);
        } catch (Exception e) {
            Logger.d(this.logTag, e.getMessage());
        }
        ArrayList<String> arrayList = new ArrayList<>();
        this.amfEmfStatusList = arrayList;
        arrayList.add(String.format(getString(R.string.blo_facility_All), new Object[0]));
        this.amfEmfStatusList.add(String.format(getString(R.string.blo_amf), new Object[0]));
        this.amfEmfStatusList.add(String.format(getString(R.string.blo_emf), new Object[0]));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.blo_spinner_dropdown, this.amfEmfStatusList);
        this.amfEmfStatusAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.blo_spinner_list);
        this.amfEmfStatusAdapter.notifyDataSetChanged();
        this.binding.facilityAmfEmfDropdown.setAdapter((SpinnerAdapter) this.amfEmfStatusAdapter);
        this.binding.facilityAmfEmfDropdown.setSelection(0);
        this.binding.facilityAmfEmfDropdown.setOnItemSelectedListener(this);
        this.binding.pollingStationFacilitiesSearchLayout.setVisibility(8);
        this.binding.facilitySearchButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$5(view);
            }
        });
        this.binding.searchBackButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$6(view);
            }
        });
        this.binding.editTextFacilitySearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities.3
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                Facilities.this.adapter2.getFilter().filter(newText);
                return false;
            }
        });
        this.binding.rightButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$7(view);
            }
        });
        this.binding.leftButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$8(view);
            }
        });
        this.binding.imageDel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$9(view);
            }
        });
        this.binding.imageButton1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$10(view);
            }
        });
        this.binding.imageButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$11(view);
            }
        });
        this.binding.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$12(view);
            }
        });
        this.binding.homeBtnIv1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$13(view);
            }
        });
        this.binding.linear.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$14(view);
            }
        });
        this.binding.updateButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$15(view);
            }
        });
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getActivity());
        this.layoutInflater = layoutInflaterFrom;
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate2 = new AlertDialog.Builder(getContext()).create();
        this.alertDialog1 = alertDialogCreate2;
        alertDialogCreate2.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog1.setCancelable(false);
        this.alertDialog1.setView(viewInflate2);
        this.binding.addphotolayout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$16(view);
            }
        });
        this.binding.button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$17(view);
            }
        });
        this.binding.radiohead.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda6
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$18(radioGroup, i);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3() {
        if (isNetworkAvailable(requireContext())) {
            this.alertDialog.show();
            this.commonUtilClass.getGenderWiseElectorsCount(this.stateCode, this.asmblyNO, this.partNo, this.tokenValue, getContext());
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreateView$2();
                }
            }, 2000L);
            fetchaddressApi();
        }
        this.binding.swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2() {
        Logger.d(this.homeMaleText, this.commonUtilClass.dashMale);
        Logger.d(this.homeFemaleText, this.commonUtilClass.dashFemale);
        Logger.d(this.homeTotalText, this.commonUtilClass.dashTotalElector);
        Logger.d(this.homeTransText, this.commonUtilClass.dashThirdGender);
        this.binding.textViewMaleCount.setText(this.commonUtilClass.dashMale);
        this.binding.textViewFemaleCount.setText(this.commonUtilClass.dashFemale);
        this.binding.textViewThirdGenderCount.setText(this.commonUtilClass.dashThirdGender);
        this.binding.textViewPwdCount.setText(this.commonUtilClass.dashPwd);
        assigntagValues();
        this.binding.textViewTotalElectorHeader.setText(String.format(getString(R.string.blo_facility_Total_Elector), new Object[0]) + " ( " + this.commonUtilClass.dashTotalElector + " )");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4() {
        Logger.d(this.homeMaleText, this.commonUtilClass.dashMale);
        Logger.d(this.homeFemaleText, this.commonUtilClass.dashFemale);
        Logger.d(this.homeTotalText, this.commonUtilClass.dashTotalElector);
        Logger.d(this.homeTransText, this.commonUtilClass.dashThirdGender);
        this.binding.textViewMaleCount.setText(this.commonUtilClass.dashMale);
        this.binding.textViewFemaleCount.setText(this.commonUtilClass.dashFemale);
        this.binding.textViewThirdGenderCount.setText(this.commonUtilClass.dashThirdGender);
        this.binding.textViewPwdCount.setText(this.commonUtilClass.dashPwd);
        assigntagValues();
        this.binding.textViewTotalElectorHeader.setText(String.format(getString(R.string.blo_facility_Total_Elector), new Object[0]) + " ( " + this.commonUtilClass.dashTotalElector + " )");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$5(View view) {
        this.binding.pollingStationFacilitiesLayout.setVisibility(8);
        this.binding.pollingStationFacilitiesSearchLayout.setVisibility(0);
        this.binding.facilityAmfEmfDropdown.setSelection(0);
        this.binding.editTextFacilitySearch.setQuery("", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$6(View view) {
        this.binding.editTextFacilitySearch.setQuery("", false);
        this.finalHeaders.clear();
        this.finalHeaders.add(String.format(getString(R.string.blo_Provision_for_ramp), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Provision_for_drinking_water), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Adequate_furniture_for_AMF), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Proper_lightning), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Help_desk), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Proper_signnage), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Toilet), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Permanent_ramp), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Adequate_Furniture_for_EMF), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Shade_shatter_for_protection_from_sun_rain), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_PS_with_proper_road_connectivity), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Voter_have_to_cross_river_valley_ravine_or_natural_obstacles_to_reach_PS), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Landline_telephone_fax_connection), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Mobile_connectivity), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Internet_Facility), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Proper_signage_of_building_name_and_address), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_LWE_insurgency_affected_area), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Forest_semi_forest_area), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Vulnerable_critical_location), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Sensitive_hyper_sensitive_PS), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Building_quality), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_PS_with_less_than_20_sqmts), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Building_is_dilapidated_or_dangerous), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_PS_is_in_Government_building_premises), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_PS_located_is_an_institution_religious_place), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_PS_in_school_college_building), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_PS_on_ground_floor), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Seperate_door_for_Entry_Exit), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_political_Party_Office_Situated_Within_200_meters_of_PS_premises), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_PS_having_drinking_water_facility_in_the_premises), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_PS_having_Electricity_Supply), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_PS_buildings_having_Proper_lightings_Fixtures_etc), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_PS_buildings_with_Toilet_Male_Female), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_facility_Parking_Available), new Object[0]));
        this.finalHeaders.add(String.format(getString(R.string.blo_Lighting_electricity_arrangements), new Object[0]));
        initRecyclerViewAdapter2();
        this.binding.allFacilitiesRv.setLayoutManager(new GridLayoutManager(getContext(), 1, 1, false));
        this.binding.allFacilitiesRv.setAdapter(this.adapter2);
        this.binding.pollingStationFacilitiesLayout.setVisibility(0);
        this.binding.pollingStationFacilitiesSearchLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$7(View view) {
        Logger.d("position1", "" + this.countimg);
        Logger.d("imagecount", this.imagetextList.get(this.countimg));
        int i = this.countimg + 1;
        this.countimg = i;
        if (i < this.imagetextList.size()) {
            this.binding.personImage.setImageBitmap(BitmapFactory.decodeByteArray(this.imageList.get(this.countimg), 0, this.imageList.get(this.countimg).length));
            this.binding.imageName.setText(this.imagetextList.get(this.countimg));
            this.binding.leftButton.setVisibility(0);
        }
        if (this.countimg == this.imagetextList.size() - 1) {
            this.binding.rightButton.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$8(View view) {
        Logger.d("position1", "" + this.countimg);
        Logger.d("imagecount", this.imagetextList.get(this.countimg));
        int i = this.countimg - 1;
        this.countimg = i;
        if (i >= 0) {
            this.binding.personImage.setImageBitmap(BitmapFactory.decodeByteArray(this.imageList.get(this.countimg), 0, this.imageList.get(this.countimg).length));
            this.binding.imageName.setText(this.imagetextList.get(this.countimg));
            this.binding.rightButton.setVisibility(0);
        }
        if (this.countimg == 0) {
            this.binding.leftButton.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$9(View view) {
        showDialogbox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$10(View view) {
        this.binding.preview.setVisibility(8);
        this.binding.pollingStationNameLayout.setVisibility(0);
        this.binding.mainScrollView.setVisibility(0);
        this.binding.titleBarprev.setVisibility(8);
        this.binding.linearLayoutForBtns.setVisibility(0);
        this.binding.titleBar.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$11(View view) {
        startActivity(new Intent(getContext(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$12(View view) {
        Intent intent = new Intent(getContext(), (Class<?>) MainActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$13(View view) {
        Intent intent = new Intent(getContext(), (Class<?>) MainActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$14(View view) {
        Intent intent = new Intent((Context) getActivity(), (Class<?>) MapsActivity.class);
        intent.putExtra("partAddress", this.binding.pollingstationadd2.getText().toString());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$15(View view) {
        this.openActivity = false;
        updateFacilityAMFEMFDetailsToAPI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$16(View view) {
        if (this.imageList.size() < 4) {
            if (isInternetConnection()) {
                this.alertDialog1.show();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda24
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.getCurrentLocation();
                    }
                }, 2000L);
                return;
            } else {
                showDialog(this.alertText, this.noInternetText);
                return;
            }
        }
        showDialog(this.alertText, "You can not upload photos more than 4");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$17(View view) {
        this.alertDialog.show();
        if (this.binding.radiohead.getCheckedRadioButtonId() != -1) {
            this.imagetextList.add(this.imagetext);
            Logger.d(this.logTag, this.imagetextList.get(0));
            if (this.imagetext.equals(this.buildingfrontview)) {
                this.count11++;
                Logger.d(this.logTag, "" + this.count11);
                this.binding.checkBox.setEnabled(this.count11 < 1);
            } else if (this.imagetext.equals(this.googlemapsview)) {
                this.count55++;
                this.binding.checkBox5.setEnabled(this.count55 < 1);
            } else if (this.imagetext.equals(this.frontpsview)) {
                this.count66++;
                this.binding.checkBox6.setEnabled(this.count66 < 1);
            } else {
                this.count77++;
                this.binding.checkBox7.setEnabled(this.count77 < 1);
            }
            this.binding.pollingStationNameLayout.setVisibility(0);
            this.binding.mainScrollView.setVisibility(0);
            this.binding.linearLayoutForBtns.setVisibility(0);
            this.binding.imglayout.setVisibility(8);
            this.binding.homeBtnIv1.setVisibility(8);
        } else {
            showDialog(this.alertText, "Please select radio button");
        }
        uploadToServer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$18(RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = this.binding.radiohead.getCheckedRadioButtonId();
        if (checkedRadioButtonId == 2131362764) {
            this.imagetext = this.buildingfrontview;
        }
        switch (checkedRadioButtonId) {
            case R.id.checkBox5 /* 2131362768 */:
                this.imagetext = this.googlemapsview;
                break;
            case R.id.checkBox6 /* 2131362769 */:
                this.imagetext = this.frontpsview;
                break;
            case R.id.checkBox7 /* 2131362770 */:
                this.imagetext = this.keymapview;
                break;
        }
    }

    public void assigntagValues() {
        this.amfEmfValueFromDropDown = getString(R.string.blo_facility_All);
        this.provisionRampAmfEmfStatusToScreen = getString(R.string.blo_amf);
        this.drinkingWaterAmfEmfStatusToScreen = getString(R.string.blo_amf);
        this.amfAdequateFurnitureAmfEmfStatusToScreen = getString(R.string.blo_amf);
        this.lightingAmfEmfStatusToScreen = getString(R.string.blo_amf);
        this.helpDeskAmfEmfStatusToScreen = getString(R.string.blo_amf);
        this.signnageAmfEmfStatusToScreen = getString(R.string.blo_amf);
        this.toiletAmfEmfStatusToScreen = getString(R.string.blo_amf);
        this.permanentRampAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.emfAdequateFurnitureAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.shatterAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.roadConnectivityAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.crossingAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.landlineFaxConnectionAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.mobileConnectivityAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.internetFacilityAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.signanceAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.lweAffectedAreaAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.forestAreaAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.vulnerableLocationAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.sensitivePsAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.buildingQualityAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.psLessThan20AmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.buildingStatusAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.governmentPsAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.religiousPsAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.schoolPsAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.groundFloorPsAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.seperateEntryExitAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.politicalPartyOfficeWithin200MetersAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.drinkingWaterInPremisesAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.electricitySupplyAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.properLightingFixturesAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.toiletMaleFemaleAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.parkingAvailableAmfEmfStatusToScreen = getString(R.string.blo_emf);
        this.electricityArrangementsAmfEmfStatusToScreen = getString(R.string.blo_emf);
    }

    private void showDialogbox() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        BloDeletebottomfileBinding bloDeletebottomfileBindingInflate = BloDeletebottomfileBinding.inflate(getLayoutInflater());
        dialog.setContentView((View) bloDeletebottomfileBindingInflate.getRoot());
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.blo_DialoAnimation;
        dialog.getWindow().setGravity(80);
        bloDeletebottomfileBindingInflate.cancel.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        bloDeletebottomfileBindingInflate.yes.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showDialogbox$20(dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogbox$20(Dialog dialog, View view) {
        String str = this.imagetextList.get(this.countimg);
        Logger.d(this.logTag, str);
        this.referenceList.remove(this.countimg);
        this.imagetextList.remove(this.countimg);
        this.imageList.remove(this.countimg);
        Logger.d(this.logTag, "" + this.referenceList);
        Logger.d(this.logTag, "" + this.imagetextList);
        if (str.contains(this.buildingfrontview)) {
            this.entrancebool = this.textForY;
            this.binding.checkBox.setEnabled(true);
            Logger.d(this.logTag, this.entrancebool);
        } else {
            String str2 = this.textForN;
            this.entrancebool = str2;
            Logger.d(this.logTag, str2);
        }
        if (str.contains(this.googlemapsview)) {
            this.googleMapsViewbool = this.textForY;
            this.binding.checkBox5.setEnabled(true);
            Logger.d(this.logTag, this.googleMapsViewbool);
        } else {
            String str3 = this.textForN;
            this.googleMapsViewbool = str3;
            Logger.d(this.logTag, str3);
        }
        if (str.contains(this.frontpsview)) {
            this.psFrntViewbool = this.textForY;
            this.binding.checkBox6.setEnabled(true);
            Logger.d(this.logTag, this.psFrntViewbool);
        } else {
            String str4 = this.textForN;
            this.psFrntViewbool = str4;
            Logger.d(this.logTag, str4);
        }
        if (str.contains(this.keymapview)) {
            this.keyMapbool = this.textForY;
            this.binding.checkBox7.setEnabled(true);
            Logger.d(this.logTag, this.keyMapbool);
        } else {
            String str5 = this.textForN;
            this.keyMapbool = str5;
            Logger.d(this.logTag, str5);
        }
        saveimageapi("deleted");
        intheshowDialogBox();
        initRecyclerViewAdapter();
        this.binding.images.setLayoutManager(new GridLayoutManager(getContext(), 1, 0, false));
        this.binding.images.setAdapter(this.adapter);
        dialog.dismiss();
    }

    public void intheshowDialogBox() {
        if (this.imageList.isEmpty()) {
            this.binding.preview.setVisibility(8);
            this.binding.pollingStationNameLayout.setVisibility(0);
            this.binding.mainScrollView.setVisibility(0);
            this.binding.titleBarprev.setVisibility(8);
            this.binding.linearLayoutForBtns.setVisibility(0);
            this.binding.titleBar.setVisibility(0);
        } else if (!this.imageList.isEmpty()) {
            this.binding.leftButton.setVisibility(8);
            this.binding.rightButton.setVisibility(0);
            this.binding.personImage.setImageBitmap(BitmapFactory.decodeByteArray(this.imageList.get(0), 0, this.imageList.get(0).length));
            this.binding.imageName.setText(this.imagetextList.get(0));
        }
        if (this.imageList.size() == 1) {
            this.binding.rightButton.setVisibility(8);
        }
        this.countimg = 0;
        if (this.imageList.size() < 4) {
            this.binding.cardView2.setEnabled(true);
            this.binding.addtext.setTextColor(Color.parseColor("#1C77FF"));
            this.binding.addphoto.setColorFilter(Color.parseColor("#1C77FF"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadToServer() {
        HashMap map = new HashMap();
        RestClient restClient = (RestClient) ApiClient.getClient(getContext()).create(RestClient.class);
        File file = new File("/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/" + this.saveImageFileName);
        MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
        RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("fileName"), this.imagetext);
        Call<JsonObject> callUploadImageWithData2 = restClient.uploadImageWithData2(this.tokenValue, "blo", this.bloappkey, partCreateFormData, RequestBody.create(MediaType.parse("bucketName"), "objectstorage"), RequestBody.create(MediaType.parse("fileType"), "application/pdf"), requestBodyCreate, RequestBody.create(this.stateCode, MediaType.parse("stateCode")), RequestBody.create(this.asmblyNO, MediaType.parse("acNo")), RequestBody.create(this.partNo, MediaType.parse("partNo")), RequestBody.create("form", MediaType.parse("type")), RequestBody.create(this.bloappkey, MediaType.parse("appName")));
        Logger.d(this.logTag, "" + map);
        callUploadImageWithData2.enqueue(new AnonymousClass4());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.facilities.Facilities$4, reason: invalid class name */
    class AnonymousClass4 implements Callback<JsonObject> {
        AnonymousClass4() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                JsonObject jsonObject = (JsonObject) response.body();
                Logger.d(Facilities.this.logTag, "imagepost" + response.body());
                Logger.d(Facilities.this.logTag, "imagedone" + ((JsonObject) response.body()).get(Facilities.this.refIdText));
                Logger.d(Facilities.this.logTag, "imageposted" + jsonObject.get(Facilities.this.messageText));
                JsonElement jsonElement = ((JsonObject) response.body()).get(Facilities.this.refIdText);
                String strValueOf = String.valueOf(((JsonObject) response.body()).get(Facilities.this.refIdText));
                Logger.d(Facilities.this.logTag, strValueOf);
                Facilities.this.setPhotoReferenceNumber = String.valueOf(jsonElement).replace(RegexMatcher.JSON_STRING_REGEX, "");
                Logger.d("referenceNumber ", Facilities.this.setPhotoReferenceNumber);
                Facilities.this.referenceList.add(Facilities.this.setPhotoReferenceNumber);
                Logger.d(Facilities.this.logTag, "referenceList" + Facilities.this.referenceList);
                Logger.d(Facilities.this.logTag, "imagetextList" + Facilities.this.imagetextList);
                Facilities.this.inUploadtoServer(strValueOf);
                Facilities.this.alertDialog.dismiss();
                return;
            }
            if (response.code() == 401) {
                Facilities.this.commonUtilClass.getRefreshToken(Facilities.this.getContext(), Facilities.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$4$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            Facilities.this.alertDialog.dismiss();
            try {
                Logger.d(Facilities.this.logTag, "image not posted" + response.errorBody());
            } catch (Exception e) {
                if (response.code() == 401) {
                    Facilities.this.commonutils.showMessageWithTitleOK(Facilities.this.requireContext(), Facilities.this.alertText, Facilities.this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$4$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$2(dialogInterface, i);
                        }
                    });
                }
                Logger.d(Facilities.this.logTag, e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            Facilities.this.alertDialog.dismiss();
            Logger.d(Facilities.this.logTag, Facilities.this.getRefreshTokenText + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                Facilities.this.commonUtilClass.showMessageOK(Facilities.this.getContext(), Facilities.this.sessionphotoexpired, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$4$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Facilities.this.tokenValue = Facilities.this.bearerText + str;
            Facilities.this.refreshToken = str2;
            SharedPref.getInstance(Facilities.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(Facilities.this.requireContext()).setToken(Facilities.this.bearerText + str);
            Facilities.this.uploadToServer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Facilities.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Facilities.this.requireContext()).setLocaleBool(false);
            Facilities.this.startActivity(new Intent((Context) Facilities.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Facilities.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Facilities.this.getContext()).setLocaleBool(false);
            Facilities.this.startActivity(new Intent((Context) Facilities.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Facilities.this.logTag, Facilities.this.cominginfailure + t.getMessage());
            Facilities.this.alertDialog.dismiss();
        }
    }

    public void inUploadtoServer(String refid) {
        if (!refid.contains(this.buildingfrontview.replace(StringUtils.SPACE, ""))) {
            Logger.d(this.logTag, this.entranceBoolvariable + this.entrancebool);
        } else {
            this.entrancebool = this.textForY;
            Logger.d(this.logTag, this.entranceBoolvariable + this.entrancebool);
        }
        if (!refid.contains(this.googlemapsview.replace(StringUtils.SPACE, ""))) {
            Logger.d(this.logTag, this.googleBoolvariable + this.googleMapsViewbool);
        } else {
            this.googleMapsViewbool = this.textForY;
            Logger.d(this.logTag, this.googleBoolvariable + this.googleMapsViewbool);
        }
        if (!refid.contains(this.frontpsview.replace(StringUtils.SPACE, ""))) {
            Logger.d(this.logTag, this.psfrontBoolVariable + this.psFrntViewbool);
        } else {
            this.psFrntViewbool = this.textForY;
            Logger.d(this.logTag, this.psfrontBoolVariable + this.psFrntViewbool);
        }
        if (!refid.contains(this.keymapview.replace(StringUtils.SPACE, ""))) {
            Logger.d(this.logTag, this.keyBoolvariable + this.keyMapbool);
        } else {
            this.keyMapbool = this.textForY;
            Logger.d(this.logTag, this.keyBoolvariable + this.keyMapbool);
        }
    }

    public void fetchDataFromAMFEMFApi() {
        if (isNetworkAvailable(getContext())) {
            fetchAMFEMFData();
        }
    }

    public void fetchAMFEMFData() {
        Logger.d("fetchAMFEMFData() -> stateCode : ", this.stateCode);
        Logger.d("fetchAMFEMFData() -> asmblyNO : ", this.asmblyNO);
        Logger.d("fetchAMFEMFData() -> partNo : ", this.partNo);
        HashMap map = new HashMap();
        map.put("Authorization", this.tokenValue);
        map.put("CurrentRole", "blo");
        map.put("state", this.stateCode);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", SharedPref.getInstance(getContext()).getAtknBnd());
        map.put("rtkn_bnd", SharedPref.getInstance(getContext()).getRtknBnd());
        map.put("channelidobo", "BLOAPP");
        map.put("PLATFORM-TYPE", "ANDROIDMOB");
        Logger.d("fetchAMFEMFData() -> fetchAMFEMFDataHeader : ", map.toString());
        this.commonUtilClass.getRetrofitClient(getContext(), this.tokenValue, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).facilityGetEMFAMFData(this.stateCode, this.asmblyNO, this.partNo, map).enqueue(new AnonymousClass5());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.facilities.Facilities$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<EronetResonse> {
        AnonymousClass5() {
        }

        public void onResponse(Call<EronetResonse> call, Response<EronetResonse> response) {
            Logger.d("Get API -> code : ", "" + response.code());
            if (response.code() == 200) {
                Logger.d("In fetchAMFEMFData() -> AMF EMF Facility Data from API -> status : ", ((EronetResonse) response.body()).getStatus());
                Logger.d("In fetchAMFEMFData() -> AMF EMF Facility Data from API -> statusCode : ", ((EronetResonse) response.body()).getStatusCode());
                JSONArray payload = ((EronetResonse) response.body()).getPayload();
                Logger.d("In fetchAMFEMFData() -> AMF EMF Facility Data from API -> payload : ", "" + payload);
                JsonObject asJsonObject = Facilities.this.gson.toJsonTree((LinkedTreeMap) payload.get(0)).getAsJsonObject();
                Facilities.this.id = String.valueOf(asJsonObject.get("id")).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                Facilities facilities = Facilities.this;
                facilities.stateCd = String.valueOf(asJsonObject.get(facilities.stateCdText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                Facilities facilities2 = Facilities.this;
                facilities2.acNumber = String.valueOf(asJsonObject.get(facilities2.acNumberText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                Facilities facilities3 = Facilities.this;
                facilities3.partNumber = String.valueOf(asJsonObject.get(facilities3.partNumberText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                if (asJsonObject.get(Facilities.this.amfRampText) != null) {
                    Facilities facilities4 = Facilities.this;
                    facilities4.amfRamp = String.valueOf(asJsonObject.get(facilities4.amfRampText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfRampCommentText) != null) {
                    Facilities facilities5 = Facilities.this;
                    facilities5.amfRampComment = String.valueOf(asJsonObject.get(facilities5.amfRampCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfRampRatingText) != null) {
                    Facilities facilities6 = Facilities.this;
                    facilities6.amfRampRating = String.valueOf(asJsonObject.get(facilities6.amfRampRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfDrinkingWaterText) != null) {
                    Facilities facilities7 = Facilities.this;
                    facilities7.amfDrinkingWater = String.valueOf(asJsonObject.get(facilities7.amfDrinkingWaterText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfDrinkingWaterCommentText) != null) {
                    Facilities facilities8 = Facilities.this;
                    facilities8.amfDrinkingWaterComment = String.valueOf(asJsonObject.get(facilities8.amfDrinkingWaterCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfDrinkingWaterRatingText) != null) {
                    Facilities facilities9 = Facilities.this;
                    facilities9.amfDrinkingWaterRating = String.valueOf(asJsonObject.get(facilities9.amfDrinkingWaterRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfFurnitureText) != null) {
                    Facilities facilities10 = Facilities.this;
                    facilities10.amfFurniture = String.valueOf(asJsonObject.get(facilities10.amfFurnitureText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfFurnitureCommentText) != null) {
                    Facilities facilities11 = Facilities.this;
                    facilities11.amfFurnitureComment = String.valueOf(asJsonObject.get(facilities11.amfFurnitureCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfFurnitureRatingText) != null) {
                    Facilities facilities12 = Facilities.this;
                    facilities12.amfFurnitureRating = String.valueOf(asJsonObject.get(facilities12.amfFurnitureRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfLightingText) != null) {
                    Facilities facilities13 = Facilities.this;
                    facilities13.amfLighting = String.valueOf(asJsonObject.get(facilities13.amfLightingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfLightingCommentText) != null) {
                    Facilities facilities14 = Facilities.this;
                    facilities14.amfLightingComment = String.valueOf(asJsonObject.get(facilities14.amfLightingCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfLightingRatingText) != null) {
                    Facilities facilities15 = Facilities.this;
                    facilities15.amfLightingRating = String.valueOf(asJsonObject.get(facilities15.amfLightingRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfHelpDeskText) != null) {
                    Facilities facilities16 = Facilities.this;
                    facilities16.amfHelpDesk = String.valueOf(asJsonObject.get(facilities16.amfHelpDeskText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfHelpDeskCommentText) != null) {
                    Facilities facilities17 = Facilities.this;
                    facilities17.amfHelpDeskComment = String.valueOf(asJsonObject.get(facilities17.amfHelpDeskCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfHelpDeskRatingText) != null) {
                    Facilities facilities18 = Facilities.this;
                    facilities18.amfHelpDeskRating = String.valueOf(asJsonObject.get(facilities18.amfHelpDeskRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfSignageText) != null) {
                    Facilities facilities19 = Facilities.this;
                    facilities19.amfSignage = String.valueOf(asJsonObject.get(facilities19.amfSignageText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfSignageCommentText) != null) {
                    Facilities facilities20 = Facilities.this;
                    facilities20.amfSignageComment = String.valueOf(asJsonObject.get(facilities20.amfSignageCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfSignageRatingText) != null) {
                    Facilities facilities21 = Facilities.this;
                    facilities21.amfSignageRating = String.valueOf(asJsonObject.get(facilities21.amfSignageRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfToiletText) != null) {
                    Facilities facilities22 = Facilities.this;
                    facilities22.amfToilet = String.valueOf(asJsonObject.get(facilities22.amfToiletText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfToiletCommentText) != null) {
                    Facilities facilities23 = Facilities.this;
                    facilities23.amfToiletComment = String.valueOf(asJsonObject.get(facilities23.amfToiletCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.amfToiletRatingText) != null) {
                    Facilities facilities24 = Facilities.this;
                    facilities24.amfToiletRating = String.valueOf(asJsonObject.get(facilities24.amfToiletRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.permanentRampText) != null) {
                    Facilities facilities25 = Facilities.this;
                    facilities25.permanentRamp = String.valueOf(asJsonObject.get(facilities25.permanentRampText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.permanentRampCommentText) != null) {
                    Facilities facilities26 = Facilities.this;
                    facilities26.permanentRampComment = String.valueOf(asJsonObject.get(facilities26.permanentRampCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.permanentRampRatingText) != null) {
                    Facilities facilities27 = Facilities.this;
                    facilities27.permanentRampRating = String.valueOf(asJsonObject.get(facilities27.permanentRampRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.furnitureText) != null) {
                    Facilities facilities28 = Facilities.this;
                    facilities28.furniture = String.valueOf(asJsonObject.get(facilities28.furnitureText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.furnitureCommentText) != null) {
                    Facilities facilities29 = Facilities.this;
                    facilities29.furnitureComment = String.valueOf(asJsonObject.get(facilities29.furnitureCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.furnitureRatingText) != null) {
                    Facilities facilities30 = Facilities.this;
                    facilities30.furnitureRating = String.valueOf(asJsonObject.get(facilities30.furnitureRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.shadeText) != null) {
                    Facilities facilities31 = Facilities.this;
                    facilities31.shade = String.valueOf(asJsonObject.get(facilities31.shadeText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.shadeCommentText) != null) {
                    Facilities facilities32 = Facilities.this;
                    facilities32.shadeComment = String.valueOf(asJsonObject.get(facilities32.shadeCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.shadeRatingText) != null) {
                    Facilities facilities33 = Facilities.this;
                    facilities33.shadeRating = String.valueOf(asJsonObject.get(facilities33.shadeRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.roadText) != null) {
                    Facilities facilities34 = Facilities.this;
                    facilities34.road = String.valueOf(asJsonObject.get(facilities34.roadText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.roadCommentText) != null) {
                    Facilities facilities35 = Facilities.this;
                    facilities35.roadComment = String.valueOf(asJsonObject.get(facilities35.roadCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.roadRatingText) != null) {
                    Facilities facilities36 = Facilities.this;
                    facilities36.roadRating = String.valueOf(asJsonObject.get(facilities36.roadRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.toCrossNaturalObstaclesText) != null) {
                    Facilities facilities37 = Facilities.this;
                    facilities37.toCrossNaturalObstacles = String.valueOf(asJsonObject.get(facilities37.toCrossNaturalObstaclesText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.toCrossNaturalObstaclesCommentText) != null) {
                    Facilities facilities38 = Facilities.this;
                    facilities38.toCrossNaturalObstaclesComment = String.valueOf(asJsonObject.get(facilities38.toCrossNaturalObstaclesCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.toCrossNaturalObstaclesRatingText) != null) {
                    Facilities facilities39 = Facilities.this;
                    facilities39.toCrossNaturalObstaclesRating = String.valueOf(asJsonObject.get(facilities39.toCrossNaturalObstaclesRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.teleConnectionText) != null) {
                    Facilities facilities40 = Facilities.this;
                    facilities40.teleConnection = String.valueOf(asJsonObject.get(facilities40.teleConnectionText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.teleConnectionCommentText) != null) {
                    Facilities facilities41 = Facilities.this;
                    facilities41.teleConnectionComment = String.valueOf(asJsonObject.get(facilities41.teleConnectionCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.teleConnectionRatingText) != null) {
                    Facilities facilities42 = Facilities.this;
                    facilities42.teleConnectionRating = String.valueOf(asJsonObject.get(facilities42.teleConnectionRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.mobileConnectivityText) != null) {
                    Facilities facilities43 = Facilities.this;
                    facilities43.mobileConnectivity = String.valueOf(asJsonObject.get(facilities43.mobileConnectivityText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.mobileConnectivityCommentText) != null) {
                    Facilities facilities44 = Facilities.this;
                    facilities44.mobileConnectivityComment = String.valueOf(asJsonObject.get(facilities44.mobileConnectivityCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.mobileConnectivityRatingText) != null) {
                    Facilities facilities45 = Facilities.this;
                    facilities45.mobileConnectivityRating = String.valueOf(asJsonObject.get(facilities45.mobileConnectivityRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.internetText) != null) {
                    Facilities facilities46 = Facilities.this;
                    facilities46.internet = String.valueOf(asJsonObject.get(facilities46.internetText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.internetCommentText) != null) {
                    Facilities facilities47 = Facilities.this;
                    facilities47.internetComment = String.valueOf(asJsonObject.get(facilities47.internetCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.internetRatingText) != null) {
                    Facilities facilities48 = Facilities.this;
                    facilities48.internetRating = String.valueOf(asJsonObject.get(facilities48.internetRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.signageText) != null) {
                    Facilities facilities49 = Facilities.this;
                    facilities49.signage = String.valueOf(asJsonObject.get(facilities49.signageText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.signageCommentText) != null) {
                    Facilities facilities50 = Facilities.this;
                    facilities50.signageComment = String.valueOf(asJsonObject.get(facilities50.signageCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.signageRatingtext) != null) {
                    Facilities facilities51 = Facilities.this;
                    facilities51.signageRating = String.valueOf(asJsonObject.get(facilities51.signageRatingtext)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.inLweInsurgencyAffectedAreaText) != null) {
                    Facilities facilities52 = Facilities.this;
                    facilities52.inLweInsurgencyAffectedArea = String.valueOf(asJsonObject.get(facilities52.inLweInsurgencyAffectedAreaText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.inLweInsurgencyAffectedAreaCommentText) != null) {
                    Facilities facilities53 = Facilities.this;
                    facilities53.inLweInsurgencyAffectedAreaComment = String.valueOf(asJsonObject.get(facilities53.inLweInsurgencyAffectedAreaCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.inLweInsurgencyAffectedAreaRatingText) != null) {
                    Facilities facilities54 = Facilities.this;
                    facilities54.inLweInsurgencyAffectedAreaRating = String.valueOf(asJsonObject.get(facilities54.inLweInsurgencyAffectedAreaRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.forestSemiForestAreaText) != null) {
                    Facilities facilities55 = Facilities.this;
                    facilities55.forestSemiForestArea = String.valueOf(asJsonObject.get(facilities55.forestSemiForestAreaText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.forestSemiForestAreaCommentText) != null) {
                    Facilities facilities56 = Facilities.this;
                    facilities56.forestSemiForestAreaComment = String.valueOf(asJsonObject.get(facilities56.forestSemiForestAreaCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.forestSemiForestAreaRatingText) != null) {
                    Facilities facilities57 = Facilities.this;
                    facilities57.forestSemiForestAreaRating = String.valueOf(asJsonObject.get(facilities57.forestSemiForestAreaRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.vulnerableCriticalLocationText) != null) {
                    Facilities facilities58 = Facilities.this;
                    facilities58.vulnerableCriticalLocation = String.valueOf(asJsonObject.get(facilities58.vulnerableCriticalLocationText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.vulnerableCriticalLocationCommentText) != null) {
                    Facilities facilities59 = Facilities.this;
                    facilities59.vulnerableCriticalLocationComment = String.valueOf(asJsonObject.get(facilities59.vulnerableCriticalLocationCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.vulnerableCriticalLocationRatingText) != null) {
                    Facilities facilities60 = Facilities.this;
                    facilities60.vulnerableCriticalLocationRating = String.valueOf(asJsonObject.get(facilities60.vulnerableCriticalLocationRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.sensitiveHyperSensitivePsText) != null) {
                    Facilities facilities61 = Facilities.this;
                    facilities61.sensitiveHyperSensitivePs = String.valueOf(asJsonObject.get(facilities61.sensitiveHyperSensitivePsText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.sensitiveHyperSensitivePsCommentText) != null) {
                    Facilities facilities62 = Facilities.this;
                    facilities62.sensitiveHyperSensitivePsComment = String.valueOf(asJsonObject.get(facilities62.sensitiveHyperSensitivePsCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.sensitiveHyperSensitivePsRatingText) != null) {
                    Facilities facilities63 = Facilities.this;
                    facilities63.sensitiveHyperSensitivePsRating = String.valueOf(asJsonObject.get(facilities63.sensitiveHyperSensitivePsRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.buildingQualityText) != null) {
                    Facilities facilities64 = Facilities.this;
                    facilities64.buildingQuality = String.valueOf(asJsonObject.get(facilities64.buildingQualityText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.buildingQualityCommentText) != null) {
                    Facilities facilities65 = Facilities.this;
                    facilities65.buildingQualityComment = String.valueOf(asJsonObject.get(facilities65.buildingQualityCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.buildingQualityRatingText) != null) {
                    Facilities facilities66 = Facilities.this;
                    facilities66.buildingQualityRating = String.valueOf(asJsonObject.get(facilities66.buildingQualityRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.lessThan20SqmtsText) != null) {
                    Facilities facilities67 = Facilities.this;
                    facilities67.lessThan20Sqmts = String.valueOf(asJsonObject.get(facilities67.lessThan20SqmtsText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.isPollingboothAreaIsLt20SqmtsCommentText) != null) {
                    Facilities facilities68 = Facilities.this;
                    facilities68.isPollingboothAreaIsLt20SqmtsComment = String.valueOf(asJsonObject.get(facilities68.isPollingboothAreaIsLt20SqmtsCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.lessThan20SqmtsRatingText) != null) {
                    Facilities facilities69 = Facilities.this;
                    facilities69.lessThan20SqmtsRating = String.valueOf(asJsonObject.get(facilities69.lessThan20SqmtsRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.buildingIsDangerousText) != null) {
                    Facilities facilities70 = Facilities.this;
                    facilities70.buildingIsDangerous = String.valueOf(asJsonObject.get(facilities70.buildingIsDangerousText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.buildingIsDangerousCommentText) != null) {
                    Facilities facilities71 = Facilities.this;
                    facilities71.buildingIsDangerousComment = String.valueOf(asJsonObject.get(facilities71.buildingIsDangerousCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.buildingIsDangerousRatingText) != null) {
                    Facilities facilities72 = Facilities.this;
                    facilities72.buildingIsDangerousRating = String.valueOf(asJsonObject.get(facilities72.buildingIsDangerousRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.governmentBuildingPremisesText) != null) {
                    Facilities facilities73 = Facilities.this;
                    facilities73.governmentBuildingPremises = String.valueOf(asJsonObject.get(facilities73.governmentBuildingPremisesText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.governmentBuildingPremisesCommentText) != null) {
                    Facilities facilities74 = Facilities.this;
                    facilities74.governmentBuildingPremisesComment = String.valueOf(asJsonObject.get(facilities74.governmentBuildingPremisesCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.governmentBuildingPremisesRatingText) != null) {
                    Facilities facilities75 = Facilities.this;
                    facilities75.governmentBuildingPremisesRating = String.valueOf(asJsonObject.get(facilities75.governmentBuildingPremisesRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.locatedIsAnInstitutionReligiousPlaceText) != null) {
                    Facilities facilities76 = Facilities.this;
                    facilities76.locatedIsAnInstitutionReligiousPlace = String.valueOf(asJsonObject.get(facilities76.locatedIsAnInstitutionReligiousPlaceText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.locatedIsAnInstitutionReligiousPlaceCommentText) != null) {
                    Facilities facilities77 = Facilities.this;
                    facilities77.locatedIsAnInstitutionReligiousPlaceComment = String.valueOf(asJsonObject.get(facilities77.locatedIsAnInstitutionReligiousPlaceCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.locatedIsAnInstitutionReligiousPlaceRatingText) != null) {
                    Facilities facilities78 = Facilities.this;
                    facilities78.locatedIsAnInstitutionReligiousPlaceRating = String.valueOf(asJsonObject.get(facilities78.locatedIsAnInstitutionReligiousPlaceRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.schoolCollegBuildingText) != null) {
                    Facilities facilities79 = Facilities.this;
                    facilities79.schoolCollegBuilding = String.valueOf(asJsonObject.get(facilities79.schoolCollegBuildingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.schoolCollegBuildingCommentText) != null) {
                    Facilities facilities80 = Facilities.this;
                    facilities80.schoolCollegBuildingComment = String.valueOf(asJsonObject.get(facilities80.schoolCollegBuildingCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.schoolCollegBuildingRatingText) != null) {
                    Facilities facilities81 = Facilities.this;
                    facilities81.schoolCollegBuildingRating = String.valueOf(asJsonObject.get(facilities81.schoolCollegBuildingRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.groundFloorText) != null) {
                    Facilities facilities82 = Facilities.this;
                    facilities82.groundFloor = String.valueOf(asJsonObject.get(facilities82.groundFloorText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.groundFloorCommentText) != null) {
                    Facilities facilities83 = Facilities.this;
                    facilities83.groundFloorComment = String.valueOf(asJsonObject.get(facilities83.groundFloorCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.groundFloorRatingText) != null) {
                    Facilities facilities84 = Facilities.this;
                    facilities84.groundFloorRating = String.valueOf(asJsonObject.get(facilities84.groundFloorRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.seperatedDoorForEntryAndExitText) != null) {
                    Facilities facilities85 = Facilities.this;
                    facilities85.seperatedDoorForEntryAndExit = String.valueOf(asJsonObject.get(facilities85.seperatedDoorForEntryAndExitText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.seperatedDoorForEntryAndExitCommentText) != null) {
                    Facilities facilities86 = Facilities.this;
                    facilities86.seperatedDoorForEntryAndExitComment = String.valueOf(asJsonObject.get(facilities86.seperatedDoorForEntryAndExitCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.seperatedDoorForEntryAndExitRatingText) != null) {
                    Facilities facilities87 = Facilities.this;
                    facilities87.seperatedDoorForEntryAndExitRating = String.valueOf(asJsonObject.get(facilities87.seperatedDoorForEntryAndExitRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.politicalPartyOfficeWithin200MText) != null) {
                    Facilities facilities88 = Facilities.this;
                    facilities88.politicalPartyOfficeWithin200Meters = String.valueOf(asJsonObject.get(facilities88.politicalPartyOfficeWithin200MText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.politicalPartyOfficeWithin200MCommentText) != null) {
                    Facilities facilities89 = Facilities.this;
                    facilities89.politicalPartyOfficeWithin200MetersComment = String.valueOf(asJsonObject.get(facilities89.politicalPartyOfficeWithin200MCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.politicalPartyOfficeWithin200MRatingText) != null) {
                    Facilities facilities90 = Facilities.this;
                    facilities90.politicalPartyOfficeWithin200MetersRating = String.valueOf(asJsonObject.get(facilities90.politicalPartyOfficeWithin200MRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.drinkingWaterText) != null) {
                    Facilities facilities91 = Facilities.this;
                    facilities91.drinkingWaterFacilityInPremises = String.valueOf(asJsonObject.get(facilities91.drinkingWaterText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.drinkingWaterCommentText) != null) {
                    Facilities facilities92 = Facilities.this;
                    facilities92.drinkingWaterFacilityInPremisesComment = String.valueOf(asJsonObject.get(facilities92.drinkingWaterCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.drinkingWaterRatingText) != null) {
                    Facilities facilities93 = Facilities.this;
                    facilities93.drinkingWaterFacilityInPremisesRating = String.valueOf(asJsonObject.get(facilities93.drinkingWaterRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.electricitySupplyText) != null) {
                    Facilities facilities94 = Facilities.this;
                    facilities94.emfElectricitySupply = String.valueOf(asJsonObject.get(facilities94.electricitySupplyText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.electricitySupplyCommentText) != null) {
                    Facilities facilities95 = Facilities.this;
                    facilities95.emfElectricitySupplyComment = String.valueOf(asJsonObject.get(facilities95.electricitySupplyCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.electricitySupplyRatingText) != null) {
                    Facilities facilities96 = Facilities.this;
                    facilities96.emfElectricitySupplyRating = String.valueOf(asJsonObject.get(facilities96.electricitySupplyRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.properLightingsText) != null) {
                    Facilities facilities97 = Facilities.this;
                    facilities97.properLightingsFixtures = String.valueOf(asJsonObject.get(facilities97.properLightingsText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.properLightingsCommentText) != null) {
                    Facilities facilities98 = Facilities.this;
                    facilities98.properLightingsFixturesComment = String.valueOf(asJsonObject.get(facilities98.properLightingsCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.properLightingsRatingText) != null) {
                    Facilities facilities99 = Facilities.this;
                    facilities99.properLightingsFixturesRating = String.valueOf(asJsonObject.get(facilities99.properLightingsRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.toiletText) != null) {
                    Facilities facilities100 = Facilities.this;
                    facilities100.toiletMaleFemale = String.valueOf(asJsonObject.get(facilities100.toiletText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.toiletCommentText) != null) {
                    Facilities facilities101 = Facilities.this;
                    facilities101.toiletMaleFemaleComment = String.valueOf(asJsonObject.get(facilities101.toiletCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.toiletRatingText) != null) {
                    Facilities facilities102 = Facilities.this;
                    facilities102.toiletMaleFemaleRating = String.valueOf(asJsonObject.get(facilities102.toiletRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.parkingAvailabilityText) != null) {
                    Facilities facilities103 = Facilities.this;
                    facilities103.parkingAvailable = String.valueOf(asJsonObject.get(facilities103.parkingAvailabilityText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.parkingAvailabilityCommentText) != null) {
                    Facilities facilities104 = Facilities.this;
                    facilities104.parkingAvailableComment = String.valueOf(asJsonObject.get(facilities104.parkingAvailabilityCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.parkingAvailabilityRatingText) != null) {
                    Facilities facilities105 = Facilities.this;
                    facilities105.parkingAvailableRating = String.valueOf(asJsonObject.get(facilities105.parkingAvailabilityRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.lightingText) != null) {
                    Facilities facilities106 = Facilities.this;
                    facilities106.electricitySupply = String.valueOf(asJsonObject.get(facilities106.lightingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.lightingCommentText) != null) {
                    Facilities facilities107 = Facilities.this;
                    facilities107.electricitySupplyComment = String.valueOf(asJsonObject.get(facilities107.lightingCommentText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                if (asJsonObject.get(Facilities.this.lightingRatingText) != null) {
                    Facilities facilities108 = Facilities.this;
                    facilities108.electricitySupplyRating = String.valueOf(asJsonObject.get(facilities108.lightingRatingText)).replaceAll(RegexMatcher.JSON_STRING_REGEX, "");
                }
                Logger.d(Facilities.this.logTag, "------ Facility Data From AMF EMF API -- Start ----");
                Logger.d("Payload --> ID : ", Facilities.this.id);
                Logger.d("Payload --> stateCd : ", Facilities.this.stateCd);
                Logger.d("Payload --> acNumber : ", Facilities.this.acNumber);
                Logger.d("Payload --> partNumber : ", Facilities.this.partNumber);
                Logger.d("Payload --> amfRamp : ", Facilities.this.amfRamp);
                Logger.d("Payload --> amfRampComment : ", Facilities.this.amfRampComment);
                Logger.d("Payload --> amfRampRating : ", Facilities.this.amfRampRating);
                Logger.d("Payload --> amfDrinkingWater : ", Facilities.this.amfDrinkingWater);
                Logger.d("Payload --> amfDrinkingWaterComment : ", Facilities.this.amfDrinkingWaterComment);
                Logger.d("Payload --> amfDrinkingWaterRating : ", Facilities.this.amfDrinkingWaterRating);
                Logger.d("Payload --> amfFurniture : ", Facilities.this.amfFurniture);
                Logger.d("Payload --> amfFurnitureComment : ", Facilities.this.amfFurnitureComment);
                Logger.d("Payload --> amfFurnitureRating : ", Facilities.this.amfFurnitureRating);
                Logger.d("Payload --> amfLighting : ", Facilities.this.amfLighting);
                Logger.d("Payload --> amfLightingComment : ", Facilities.this.amfLightingComment);
                Logger.d("Payload --> amfLightingRating : ", Facilities.this.amfLightingRating);
                Logger.d("Payload --> amfHelpDesk : ", Facilities.this.amfHelpDesk);
                Logger.d("Payload --> amfHelpDeskComment : ", Facilities.this.amfHelpDeskComment);
                Logger.d("Payload --> amfHelpDeskRating : ", Facilities.this.amfHelpDeskRating);
                Logger.d("Payload --> amfSignage : ", Facilities.this.amfSignage);
                Logger.d("Payload --> amfSignageComment : ", Facilities.this.amfSignageComment);
                Logger.d("Payload --> amfSignageRating : ", Facilities.this.amfSignageRating);
                Logger.d("Payload --> amfToilet : ", Facilities.this.amfToilet);
                Logger.d("Payload --> amfToiletComment : ", Facilities.this.amfToiletComment);
                Logger.d("Payload --> amfToiletRating : ", Facilities.this.amfToiletRating);
                Logger.d("Payload --> permanentRamp : ", Facilities.this.permanentRamp);
                Logger.d("Payload --> permanentRampComment : ", Facilities.this.permanentRampComment);
                Logger.d("Payload --> permanentRampRating : ", Facilities.this.permanentRampRating);
                Logger.d("Payload --> furniture : ", Facilities.this.furniture);
                Logger.d("Payload --> furnitureComment : ", Facilities.this.furnitureComment);
                Logger.d("Payload --> furnitureRating : ", Facilities.this.furnitureRating);
                Logger.d("Payload --> shade : ", Facilities.this.shade);
                Logger.d("Payload --> shadeComment : ", Facilities.this.shadeComment);
                Logger.d("Payload --> shadeRating : ", Facilities.this.shadeRating);
                Logger.d("Payload --> road : ", Facilities.this.road);
                Logger.d("Payload --> roadComment : ", Facilities.this.roadComment);
                Logger.d("Payload --> roadRating : ", Facilities.this.roadRating);
                Logger.d("Payload --> toCrossNaturalObstacles : ", Facilities.this.toCrossNaturalObstacles);
                Logger.d("Payload --> toCrossNaturalObstaclesComment : ", Facilities.this.toCrossNaturalObstaclesComment);
                Logger.d("Payload --> toCrossNaturalObstaclesRating : ", Facilities.this.toCrossNaturalObstaclesRating);
                Logger.d("Payload --> teleConnection : ", Facilities.this.teleConnection);
                Logger.d("Payload --> teleConnectionComment : ", Facilities.this.teleConnectionComment);
                Logger.d("Payload --> teleConnectionRating : ", Facilities.this.teleConnectionRating);
                Logger.d("Payload --> mobileConnectivity : ", Facilities.this.mobileConnectivity);
                Logger.d("Payload --> mobileConnectivityComment : ", Facilities.this.mobileConnectivityComment);
                Logger.d("Payload --> mobileConnectivityRating : ", Facilities.this.mobileConnectivityRating);
                Logger.d("Payload --> internet : ", Facilities.this.internet);
                Logger.d("Payload --> internetComment : ", Facilities.this.internetComment);
                Logger.d("Payload --> internetRating : ", Facilities.this.internetRating);
                Logger.d("Payload --> signage : ", Facilities.this.signage);
                Logger.d("Payload --> signageComment : ", Facilities.this.signageComment);
                Logger.d("Payload --> signageRating : ", Facilities.this.signageRating);
                Logger.d("Payload --> inLweInsurgencyAffectedArea : ", Facilities.this.inLweInsurgencyAffectedArea);
                Logger.d("Payload --> inLweInsurgencyAffectedAreaComment : ", Facilities.this.inLweInsurgencyAffectedAreaComment);
                Logger.d("Payload --> inLweInsurgencyAffectedAreaRating : ", Facilities.this.inLweInsurgencyAffectedAreaRating);
                Logger.d("Payload --> forestSemiForestArea : ", Facilities.this.forestSemiForestArea);
                Logger.d("Payload --> forestSemiForestAreaComment : ", Facilities.this.forestSemiForestAreaComment);
                Logger.d("Payload --> forestSemiForestAreaRating : ", Facilities.this.forestSemiForestAreaRating);
                Logger.d("Payload --> vulnerableCriticalLocation : ", Facilities.this.vulnerableCriticalLocation);
                Logger.d("Payload --> vulnerableCriticalLocationComment : ", Facilities.this.vulnerableCriticalLocationComment);
                Logger.d("Payload --> vulnerableCriticalLocationRating : ", Facilities.this.vulnerableCriticalLocationRating);
                Logger.d("Payload --> sensitiveHyperSensitivePs : ", Facilities.this.sensitiveHyperSensitivePs);
                Logger.d("Payload --> sensitiveHyperSensitivePsComment : ", Facilities.this.sensitiveHyperSensitivePsComment);
                Logger.d("Payload --> sensitiveHyperSensitivePsRating : ", Facilities.this.sensitiveHyperSensitivePsRating);
                Logger.d("Payload --> buildingQuality : ", Facilities.this.buildingQuality);
                Logger.d("Payload --> buildingQualityComment : ", Facilities.this.buildingQualityComment);
                Logger.d("Payload --> buildingQualityRating : ", Facilities.this.buildingQualityRating);
                Logger.d("Payload --> lessThan20Sqmts : ", Facilities.this.lessThan20Sqmts);
                Logger.d("Payload --> isPollingboothAreaIsLt20SqmtsComment : ", Facilities.this.isPollingboothAreaIsLt20SqmtsComment);
                Logger.d("Payload --> lessThan20SqmtsRating : ", Facilities.this.lessThan20SqmtsRating);
                Logger.d("Payload --> buildingIsDangerous : ", Facilities.this.buildingIsDangerous);
                Logger.d("Payload --> buildingIsDangerousComment : ", Facilities.this.buildingIsDangerousComment);
                Logger.d("Payload --> buildingIsDangerousRating : ", Facilities.this.buildingIsDangerousRating);
                Logger.d("Payload --> governmentBuildingPremises : ", Facilities.this.governmentBuildingPremises);
                Logger.d("Payload --> governmentBuildingPremisesComment : ", Facilities.this.governmentBuildingPremisesComment);
                Logger.d("Payload --> governmentBuildingPremisesRating : ", Facilities.this.governmentBuildingPremisesRating);
                Logger.d("Payload --> locatedIsAnInstitutionReligiousPlace : ", Facilities.this.locatedIsAnInstitutionReligiousPlace);
                Logger.d("Payload --> locatedIsAnInstitutionReligiousPlaceComment : ", Facilities.this.locatedIsAnInstitutionReligiousPlaceComment);
                Logger.d("Payload --> locatedIsAnInstitutionReligiousPlaceRating : ", Facilities.this.locatedIsAnInstitutionReligiousPlaceRating);
                Logger.d("Payload --> schoolCollegBuilding : ", Facilities.this.schoolCollegBuilding);
                Logger.d("Payload --> schoolCollegBuildingComment : ", Facilities.this.schoolCollegBuildingComment);
                Logger.d("Payload --> schoolCollegBuildingRating : ", Facilities.this.schoolCollegBuildingRating);
                Logger.d("Payload --> groundFloor : ", Facilities.this.groundFloor);
                Logger.d("Payload --> groundFloorComment : ", Facilities.this.groundFloorComment);
                Logger.d("Payload --> groundFloorRating : ", Facilities.this.groundFloorRating);
                Logger.d("Payload --> seperatedDoorForEntryAndExit : ", Facilities.this.seperatedDoorForEntryAndExit);
                Logger.d("Payload --> seperatedDoorForEntryAndExitComment : ", Facilities.this.seperatedDoorForEntryAndExitComment);
                Logger.d("Payload --> seperatedDoorForEntryAndExitRating : ", Facilities.this.seperatedDoorForEntryAndExitRating);
                Logger.d("Payload --> politicalPartyOfficeWithin200Meters : ", Facilities.this.politicalPartyOfficeWithin200Meters);
                Logger.d("Payload --> politicalPartyOfficeWithin200MetersComment : ", Facilities.this.politicalPartyOfficeWithin200MetersComment);
                Logger.d("Payload --> politicalPartyOfficeWithin200MetersRating : ", Facilities.this.politicalPartyOfficeWithin200MetersRating);
                Logger.d("Payload --> drinkingWaterFacilityInPremises : ", Facilities.this.drinkingWaterFacilityInPremises);
                Logger.d("Payload --> drinkingWaterFacilityInPremisesComment : ", Facilities.this.drinkingWaterFacilityInPremisesComment);
                Logger.d("Payload --> drinkingWaterFacilityInPremisesRating : ", Facilities.this.drinkingWaterFacilityInPremisesRating);
                Logger.d("Payload --> emfElectricitySupply : ", Facilities.this.emfElectricitySupply);
                Logger.d("Payload --> emfElectricitySupplyComment : ", Facilities.this.emfElectricitySupplyComment);
                Logger.d("Payload --> emfElectricitySupplyRating : ", Facilities.this.emfElectricitySupplyRating);
                Logger.d("Payload --> properLightingsFixtures : ", Facilities.this.properLightingsFixtures);
                Logger.d("Payload --> properLightingsFixturesComment : ", Facilities.this.properLightingsFixturesComment);
                Logger.d("Payload --> properLightingsFixturesRating : ", Facilities.this.properLightingsFixturesRating);
                Logger.d("Payload --> toiletMaleFemale : ", Facilities.this.toiletMaleFemale);
                Logger.d("Payload --> toiletMaleFemaleComment : ", Facilities.this.toiletMaleFemaleComment);
                Logger.d("Payload --> toiletMaleFemaleRating : ", Facilities.this.toiletMaleFemaleRating);
                Logger.d("Payload --> parkingAvailable : ", Facilities.this.parkingAvailable);
                Logger.d("Payload --> parkingAvailableComment : ", Facilities.this.parkingAvailableComment);
                Logger.d("Payload --> parkingAvailableRating : ", Facilities.this.parkingAvailableRating);
                Logger.d("Payload --> electricitySupply : ", Facilities.this.electricitySupply);
                Logger.d("Payload --> electricitySupplyComment : ", Facilities.this.electricitySupplyComment);
                Logger.d("Payload --> electricitySupplyRating : ", Facilities.this.electricitySupplyRating);
                Logger.d(Facilities.this.logTag, "------ Facility Data From AMF EMF API -- End ----");
                Facilities.this.setAMFEMFDataFromAPIToScreen();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$5$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0();
                    }
                }, 2000L);
                return;
            }
            if (response.code() == 401 || response.code() == 400) {
                Facilities.this.commonUtilClass.getRefreshToken(Facilities.this.getContext(), Facilities.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$5$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$2(i, str, str2);
                    }
                });
                return;
            }
            Logger.d(Facilities.this.logTag, "In fetchAMFEMFData() -> else part ----> Response Body is null ");
            try {
                Logger.d(Facilities.this.logTag, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(Facilities.this.logTag, e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0() {
            Facilities.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(int i, String str, String str2) {
            Logger.d(Facilities.this.logTag, Facilities.this.getRefreshTokenText + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                Facilities.this.commonUtilClass.showMessageOK(Facilities.this.getContext(), Facilities.this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$5$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$1(dialogInterface, i2);
                    }
                });
                return;
            }
            Facilities.this.tokenValue = Facilities.this.bearerText + str;
            Facilities.this.refreshToken = str2;
            SharedPref.getInstance(Facilities.this.getContext()).setRefreshToken(str2);
            SharedPref.getInstance(Facilities.this.getContext()).setToken(Facilities.this.bearerText + str);
            Facilities.this.fetchAMFEMFData();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Facilities.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Facilities.this.getContext()).setLocaleBool(false);
            Facilities.this.startActivity(new Intent(Facilities.this.getContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResonse> call, Throwable t) {
            Logger.d(Facilities.this.logTag, "In fetchAMFEMFData() -> ON failure" + t.getMessage());
        }
    }

    public void updateFacilityAMFEMFDetailsToAPI() {
        if (isNetworkAvailable(getContext())) {
            Logger.d(this.logTag, "Inside updateFacilityAMFEMFDetailsToAPI() -> updateAMFEMFData() is Called");
            updateAMFEMFData();
            saveimageapi("");
        }
    }

    public void updateAMFEMFData() {
        HashMap map = new HashMap();
        Logger.d("updateAMFEMFData() -> stateCode : ", this.stateCode);
        Logger.d("updateAMFEMFData() -> asmblyNO : ", this.asmblyNO);
        Logger.d("updateAMFEMFData() -> partNo : ", this.partNo);
        map.put(this.stateCdText, this.stateCode);
        map.put(this.acNumberText, this.asmblyNO);
        map.put(this.partNumberText, this.partNo);
        map.put(this.amfRampText, this.provisionRampToScreen);
        map.put(this.amfRampCommentText, this.provisionRampRemarksToScreen);
        map.put(this.amfRampRatingText, this.provisionRampRatingToScreen);
        map.put(this.amfDrinkingWaterText, this.drinkingWaterToScreen);
        map.put(this.amfDrinkingWaterCommentText, this.drinkingWaterRemarksToScreen);
        map.put(this.amfDrinkingWaterRatingText, this.drinkingWaterRatingToScreen);
        map.put(this.amfFurnitureText, this.amfAdequateFurnitureToScreen);
        map.put(this.amfFurnitureCommentText, this.amfAdequateFurnitureRemarksToScreen);
        map.put(this.amfFurnitureRatingText, this.amfAdequateFurnitureRatingToScreen);
        map.put(this.amfLightingText, this.lightingToScreen);
        map.put(this.amfLightingCommentText, this.lightingRemarksToScreen);
        map.put(this.amfLightingRatingText, this.lightingRatingToScreen);
        map.put(this.amfHelpDeskText, this.helpDeskToScreen);
        map.put(this.amfHelpDeskCommentText, this.helpDeskRemarksToScreen);
        map.put(this.amfHelpDeskRatingText, this.helpDeskRatingToScreen);
        map.put(this.amfSignageText, this.signnageToScreen);
        map.put(this.amfSignageCommentText, this.signnageRemarksToScreen);
        map.put(this.amfSignageRatingText, this.signnageRatingToScreen);
        map.put(this.amfToiletText, this.toiletToScreen);
        map.put(this.amfToiletCommentText, this.toiletRemarksToScreen);
        map.put(this.amfToiletRatingText, this.toiletRatingToScreen);
        map.put(this.furnitureText, this.emfAdequateFurnitureToScreen);
        map.put(this.furnitureCommentText, this.emfAdequateFurnitureRemarksToScreen);
        map.put(this.furnitureRatingText, this.emfAdequateFurnitureRatingToScreen);
        map.put(this.shadeText, this.shatterToScreen);
        map.put(this.shadeCommentText, this.shatterRemarksToScreen);
        map.put(this.shadeRatingText, this.shatterRatingToScreen);
        map.put(this.roadText, this.roadConnectivityToScreen);
        map.put(this.roadCommentText, this.roadConnectivityRemarksToScreen);
        map.put(this.roadRatingText, this.roadConnectivityRatingToScreen);
        map.put(this.toCrossNaturalObstaclesText, this.crossingToScreen);
        map.put(this.toCrossNaturalObstaclesCommentText, this.crossingRemarksToScreen);
        map.put(this.toCrossNaturalObstaclesRatingText, this.crossingRatingToScreen);
        map.put(this.teleConnectionText, this.landlineFaxConnectionToScreen);
        map.put(this.teleConnectionCommentText, this.landlineFaxConnectionRemarksToScreen);
        map.put(this.teleConnectionRatingText, this.landlineFaxConnectionRatingToScreen);
        map.put(this.mobileConnectivityText, this.mobileConnectivityToScreen);
        map.put(this.mobileConnectivityCommentText, this.mobileConnectivityRemarksToScreen);
        map.put(this.mobileConnectivityRatingText, this.mobileConnectivityRatingToScreen);
        map.put(this.lightingText, this.electricityArrangementToScreen);
        map.put(this.lightingCommentText, this.electricityArrangementsRemarksToScreen);
        map.put(this.lightingRatingText, this.electricityArrangementsRatingToScreen);
        map.put(this.internetText, this.internetFacilityToScreen);
        map.put(this.internetCommentText, this.internetFacilityRemarksToScreen);
        map.put(this.internetRatingText, this.internetFacilityRatingToScreen);
        map.put(this.signageText, this.signanceToScreen);
        map.put(this.signageCommentText, this.signanceRemarksToScreen);
        map.put(this.signageRatingtext, this.signanceRatingToScreen);
        map.put(this.inLweInsurgencyAffectedAreaText, this.lweAffectedAreaToScreen);
        map.put(this.inLweInsurgencyAffectedAreaCommentText, this.lweAffectedAreaRemarksToScreen);
        map.put(this.inLweInsurgencyAffectedAreaRatingText, this.lweAffectedAreaRatingToScreen);
        map.put(this.forestSemiForestAreaText, this.forestAreaToScreen);
        map.put(this.forestSemiForestAreaCommentText, this.forestAreaRemarksToScreen);
        map.put(this.forestSemiForestAreaRatingText, this.forestAreaAreaRatingToScreen);
        map.put(this.vulnerableCriticalLocationText, this.vulnerableLocationToScreen);
        map.put(this.vulnerableCriticalLocationCommentText, this.vulnerableLocationRemarksToScreen);
        map.put(this.vulnerableCriticalLocationRatingText, this.vulnerableLocationRatingToScreen);
        map.put(this.sensitiveHyperSensitivePsText, this.sensitivePsToScreen);
        map.put(this.sensitiveHyperSensitivePsCommentText, this.sensitivePsRemarksToScreen);
        map.put(this.sensitiveHyperSensitivePsRatingText, this.sensitivePsRatingToScreen);
        map.put(this.buildingQualityText, this.buildingQualityToScreen);
        map.put(this.buildingQualityCommentText, this.buildingQualityRemarksToScreen);
        map.put(this.buildingQualityRatingText, this.buildingQualityRatingToScreen);
        map.put(this.lessThan20SqmtsText, this.psLessThan20ToScreen);
        map.put(this.isPollingboothAreaIsLt20SqmtsCommentText, this.psLessThan20RemarksToScreen);
        map.put(this.lessThan20SqmtsRatingText, this.psLessThan20RatingToScreen);
        map.put(this.buildingIsDangerousText, this.buildingStatusToScreen);
        map.put(this.buildingIsDangerousCommentText, this.buildingStatusRemarksToScreen);
        map.put(this.buildingIsDangerousRatingText, this.buildingStatusRatingToScreen);
        map.put(this.governmentBuildingPremisesText, this.governmentPsToScreen);
        map.put(this.governmentBuildingPremisesCommentText, this.governmentPsRemarksToScreen);
        map.put(this.governmentBuildingPremisesRatingText, this.governmentPsRatingToScreen);
        map.put(this.locatedIsAnInstitutionReligiousPlaceText, this.religiousPsToScreen);
        map.put(this.locatedIsAnInstitutionReligiousPlaceCommentText, this.religiousPsRemarksToScreen);
        map.put(this.locatedIsAnInstitutionReligiousPlaceRatingText, this.religiousPsRatingToScreen);
        map.put(this.schoolCollegBuildingText, this.schoolPsToScreen);
        map.put(this.schoolCollegBuildingCommentText, this.schoolPsRemarksToScreen);
        map.put(this.schoolCollegBuildingRatingText, this.schoolPsRatingToScreen);
        map.put(this.groundFloorText, this.groundFloorPsToScreen);
        map.put(this.groundFloorCommentText, this.groundFloorPsRemarksToScreen);
        map.put(this.groundFloorRatingText, this.groundFloorPsRatingToScreen);
        map.put(this.seperatedDoorForEntryAndExitText, this.seperateEntryExitToScreen);
        map.put(this.seperatedDoorForEntryAndExitCommentText, this.seperateEntryExitRemarksToScreen);
        map.put(this.seperatedDoorForEntryAndExitRatingText, this.seperateEntryExitRatingToScreen);
        map.put("politicalPartOfficeWithin200M", "");
        map.put("politicalPartOfficeWithin200MComment", "");
        map.put("politicalPartOfficeWithin200MRating", "");
        map.put("psBuildingDistanceFlag", "");
        map.put("psBuildingDistanceFlagComment", "");
        map.put("psBuildingDistanceFlagRating", "");
        map.put("psFloorInfoFlag", "");
        map.put("psFloorInfoFlagComment", "");
        map.put("psFloorInfoFlagRating", "");
        map.put("isPsAcrossRiver", "");
        map.put("isPsAcrossRiverComment", "");
        map.put("isPsAcrossRiverRating", "");
        map.put("isPsEasyAccessible", "");
        map.put("isPsEasyAccessibleComment", "");
        map.put("isPsEasyAccessibleRating", "");
        map.put(this.permanentRampText, this.permanentRampToScreen);
        map.put(this.permanentRampCommentText, this.permanentRampRemarksToScreen);
        map.put(this.permanentRampRatingText, this.permanentRampRatingToScreen);
        map.put(this.politicalPartyOfficeWithin200MText, this.politicalPartyOfficeWithin200MetersToScreen);
        map.put(this.politicalPartyOfficeWithin200MCommentText, this.politicalPartyOfficeWithin200MetersRemarksToScreen);
        map.put(this.politicalPartyOfficeWithin200MRatingText, this.politicalPartyOfficeWithin200MetersRatingToScreen);
        map.put(this.drinkingWaterText, this.drinkingWaterInPremisesToScreen);
        map.put(this.drinkingWaterCommentText, this.drinkingWaterInPremisesRemarksToScreen);
        map.put(this.drinkingWaterRatingText, this.drinkingWaterInPremisesRatingToScreen);
        map.put(this.electricitySupplyText, this.electricitySupplyToScreen);
        map.put(this.electricitySupplyCommentText, this.electricitySupplyRemarksToScreen);
        map.put(this.electricitySupplyRatingText, this.electricitySupplyRatingToScreen);
        map.put(this.properLightingsText, this.properLightingFixturesToScreen);
        map.put(this.properLightingsCommentText, this.properLightingFixturesRemarksToScreen);
        map.put(this.properLightingsRatingText, this.properLightingFixturesRatingToScreen);
        map.put(this.toiletText, this.toiletMaleFemaleToScreen);
        map.put(this.toiletCommentText, this.toiletMaleFemaleRemarksToScreen);
        map.put(this.toiletRatingText, this.toiletMaleFemaleRatingToScreen);
        map.put(this.parkingAvailabilityText, this.parkingAvailableToScreen);
        map.put(this.parkingAvailabilityCommentText, this.parkingAvailableRemarksToScreen);
        map.put(this.parkingAvailabilityRatingText, this.parkingAvailableRatingToScreen);
        Logger.d("updateAMFEMFData() -> ", "updateAMFEMFMap : " + map);
        HashMap map2 = new HashMap();
        map2.put("Authorization", this.tokenValue);
        map2.put("CurrentRole", "blo");
        map2.put("state", this.stateCode);
        map2.put("Content-Type", "application/json");
        map2.put("atkn_bnd", SharedPref.getInstance(getContext()).getAtknBnd());
        map2.put("rtkn_bnd", SharedPref.getInstance(getContext()).getRtknBnd());
        map2.put("channelidobo", "BLOAPP");
        map2.put("PLATFORM-TYPE", "ANDROIDMOB");
        Logger.d("updateAMFEMFData() -> updateAMFEMFDataHeader : ", map2.toString());
        this.commonUtilClass.getRetrofitClient(getContext(), this.tokenValue, SharedPref.getInstance(getContext()).getAtknBnd(), SharedPref.getInstance(getContext()).getRtknBnd()).facilityPostEMFAMFData(map2, map).enqueue(new AnonymousClass6());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.facilities.Facilities$6, reason: invalid class name */
    class AnonymousClass6 implements Callback<JsonObject> {
        AnonymousClass6() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            Logger.d("POST API -> code : ", "" + response.code());
            if (response.code() == 200) {
                Logger.d(Facilities.this.logTag, "In updateAMFEMFData() -> response body");
                Logger.d(Facilities.this.logTag, "In updateAMFEMFData() -> AMF EMF Facility Data from API -> statusCode : " + ((JsonObject) response.body()).get("statusCode"));
                Logger.d(Facilities.this.logTag, "In updateAMFEMFData() -> AMF EMF Facility Data from API -> message : " + ((JsonObject) response.body()).get(Facilities.this.messageText));
                Facilities.this.startActivity(new Intent(Facilities.this.getContext(), (Class<?>) FacilityUpdateSuccessActivity.class));
                return;
            }
            if (response.code() == 401) {
                Facilities.this.commonUtilClass.getRefreshToken(Facilities.this.getContext(), Facilities.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$6$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            Logger.d(Facilities.this.logTag, "In updateAMFEMFData() -> else part ----> Response Body is null");
            try {
                Logger.d(Facilities.this.logTag, String.valueOf(new JSONObject(response.errorBody().string())));
            } catch (IOException | JSONException e) {
                Logger.d(Facilities.this.logTag, e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            Logger.d(Facilities.this.logTag, Facilities.this.getRefreshTokenText + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                Facilities.this.commonUtilClass.showMessageOK(Facilities.this.getContext(), Facilities.this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$6$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Facilities.this.tokenValue = Facilities.this.bearerText + str;
            Facilities.this.refreshToken = str2;
            SharedPref.getInstance(Facilities.this.getContext()).setRefreshToken(str2);
            SharedPref.getInstance(Facilities.this.getContext()).setToken(Facilities.this.bearerText + str);
            Facilities.this.updateAMFEMFData();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Facilities.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Facilities.this.getContext()).setLocaleBool(false);
            Facilities.this.startActivity(new Intent(Facilities.this.getContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d("In updateAMFEMFData() -> ON failure", t.getMessage());
        }
    }

    public void fetchaddressApi() {
        if (isNetworkAvailable(getContext())) {
            fetchaddress();
        }
    }

    public void fetchaddress() {
        RestClient restClient = (RestClient) ApiClient.getClient(getContext()).create(RestClient.class);
        String str = this.tokenValue;
        String atknBnd = SharedPref.getInstance(requireContext()).getAtknBnd();
        String rtknBnd = SharedPref.getInstance(requireContext()).getRtknBnd();
        String str2 = this.stateCode;
        restClient.facilityaddress(str, atknBnd, rtknBnd, "BLOAPP", "blo", str2, str2, this.asmblyNO, this.partNo).enqueue(new AnonymousClass7());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.facilities.Facilities$7, reason: invalid class name */
    class AnonymousClass7 implements Callback<EronetResonse> {
        AnonymousClass7() {
        }

        public void onResponse(Call<EronetResonse> call, Response<EronetResonse> response) {
            Logger.d(Facilities.this.logTag, "in response body fetchaddress" + response.body());
            if (response.code() == 200) {
                Logger.d(Facilities.this.logTag, "in response body fetchaddress");
                Logger.d(Facilities.this.logTag, "fetchaddress -> status : " + ((EronetResonse) response.body()).getStatus());
                Logger.d(Facilities.this.logTag, "Address Data from API -> statusCode : " + ((EronetResonse) response.body()).getStatusCode());
                JSONArray payload = ((EronetResonse) response.body()).getPayload();
                Logger.d(Facilities.this.logTag, "Address Data from API -> payload : " + payload);
                JsonObject asJsonObject = Facilities.this.gson.toJsonTree((LinkedTreeMap) payload.get(0)).getAsJsonObject();
                Facilities.this.partAddress = String.valueOf(asJsonObject.get("partAddress"));
                String strValueOf = String.valueOf(asJsonObject.get("partAddressL1"));
                Facilities.this.partName = String.valueOf(asJsonObject.get("partName"));
                String strValueOf2 = String.valueOf(asJsonObject.get("latitude"));
                String strValueOf3 = String.valueOf(asJsonObject.get("longitude"));
                Facilities facilities = Facilities.this;
                facilities.stateCd = String.valueOf(asJsonObject.get(facilities.stateCdText));
                Logger.d(Facilities.this.logTag, "Payload --> partAddress : " + Facilities.this.partAddress);
                Logger.d(Facilities.this.logTag, "Payload --> partAddressL1 : " + strValueOf);
                Logger.d(Facilities.this.logTag, "Payload --> partName : " + Facilities.this.partName);
                Logger.d(Facilities.this.logTag, "Payload --> latitude : " + strValueOf2);
                Logger.d(Facilities.this.logTag, "Payload --> longitude : " + strValueOf3);
                Logger.d(Facilities.this.logTag, "Payload --> stateCd : " + Facilities.this.stateCd);
                Facilities.this.binding.pollingstationadd1.setText(Facilities.this.partName.substring(1, Facilities.this.partName.length() - 1));
                Facilities.this.infetchAddress(strValueOf2, strValueOf3);
                Bundle arguments = Facilities.this.getArguments();
                if (arguments != null) {
                    Facilities.this.binding.gpsadd.setText(arguments.getString(Facilities.this.latitudeandlongi));
                    String[] strArrSplit = arguments.getString(Facilities.this.latitudeandlongi).split("\\s+");
                    Facilities.this.changelatitude = strArrSplit[0];
                    Facilities.this.changelongitude = strArrSplit[1];
                    Logger.d(Facilities.this.logTag, "changelatitude" + Facilities.this.changelatitude);
                    Logger.d(Facilities.this.logTag, "changelongitude" + Facilities.this.changelongitude);
                    Logger.d(Facilities.this.logTag, "" + arguments.getBundle(Facilities.this.latitudeandlongi));
                }
                Facilities.this.fetchimage();
                return;
            }
            if (response.code() == 401) {
                Facilities.this.commonUtilClass.getRefreshToken(Facilities.this.getContext(), Facilities.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$7$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
            } else {
                Logger.d(Facilities.this.logTag, "fetchaddress else part ----> Response Body is null");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            Facilities.this.alertDialog.dismiss();
            Logger.d(Facilities.this.logTag, Facilities.this.getRefreshTokenText + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                Facilities.this.commonUtilClass.showMessageOK(Facilities.this.getContext(), Facilities.this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$7$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Facilities.this.tokenValue = Facilities.this.bearerText + str;
            Facilities.this.refreshToken = str2;
            SharedPref.getInstance(Facilities.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(Facilities.this.requireContext()).setToken(Facilities.this.bearerText + str);
            Facilities.this.fetchaddress();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Facilities.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Facilities.this.requireContext()).setLocaleBool(false);
            Facilities.this.startActivity(new Intent((Context) Facilities.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<EronetResonse> call, Throwable t) {
            Logger.d(Facilities.this.logTag, "fetchaddress ON failure " + t.getMessage());
        }
    }

    public void infetchAddress(String latitude, String longitude) {
        String str;
        if (this.partAddress.equals(this.nullText) || (str = this.partAddress) == null || str.equals("")) {
            this.partAdd = "NA";
        }
        this.binding.pollingstationadd2.setText(this.partAdd);
        if (latitude.equals(this.nullText)) {
            latitude = latitude.replace(this.nullText, "NA");
        }
        if (longitude.equals(this.nullText)) {
            longitude = longitude.replace(this.nullText, "NA");
        }
        if (latitude.equals("NA") && longitude.equals("NA")) {
            this.binding.gpsadd.setText(latitude + "," + longitude);
        } else {
            this.binding.gpsadd.setText(latitude.substring(1, latitude.length() - 1) + "  " + longitude.substring(1, longitude.length() - 1));
        }
    }

    public void setAMFEMFDataFromAPIToScreen() {
        Logger.d(this.logTag, "---- setAMFEMFDataFromAPIToScreen() called ----");
        this.provisionRampToScreen = this.amfRamp;
        this.drinkingWaterToScreen = this.amfDrinkingWater;
        this.amfAdequateFurnitureToScreen = this.amfFurniture;
        this.lightingToScreen = this.amfLighting;
        this.helpDeskToScreen = this.amfHelpDesk;
        this.signnageToScreen = this.amfSignage;
        this.toiletToScreen = this.amfToilet;
        this.permanentRampToScreen = this.permanentRamp;
        this.emfAdequateFurnitureToScreen = this.furniture;
        this.shatterToScreen = this.shade;
        this.roadConnectivityToScreen = this.road;
        this.crossingToScreen = this.toCrossNaturalObstacles;
        this.landlineFaxConnectionToScreen = this.teleConnection;
        this.mobileConnectivityToScreen = this.mobileConnectivity;
        this.internetFacilityToScreen = this.internet;
        this.signanceToScreen = this.signage;
        this.lweAffectedAreaToScreen = this.inLweInsurgencyAffectedArea;
        this.forestAreaToScreen = this.forestSemiForestArea;
        this.vulnerableLocationToScreen = this.vulnerableCriticalLocation;
        this.sensitivePsToScreen = this.sensitiveHyperSensitivePs;
        this.buildingQualityToScreen = this.buildingQuality;
        this.psLessThan20ToScreen = this.lessThan20Sqmts;
        this.buildingStatusToScreen = this.buildingIsDangerous;
        this.governmentPsToScreen = this.governmentBuildingPremises;
        this.religiousPsToScreen = this.locatedIsAnInstitutionReligiousPlace;
        this.schoolPsToScreen = this.schoolCollegBuilding;
        this.groundFloorPsToScreen = this.groundFloor;
        this.seperateEntryExitToScreen = this.seperatedDoorForEntryAndExit;
        this.politicalPartyOfficeWithin200MetersToScreen = this.politicalPartyOfficeWithin200Meters;
        this.drinkingWaterInPremisesToScreen = this.drinkingWaterFacilityInPremises;
        this.electricitySupplyToScreen = this.emfElectricitySupply;
        this.properLightingFixturesToScreen = this.properLightingsFixtures;
        this.toiletMaleFemaleToScreen = this.toiletMaleFemale;
        this.parkingAvailableToScreen = this.parkingAvailable;
        this.electricityArrangementToScreen = this.electricitySupply;
        this.provisionRampRemarksToScreen = this.amfRampComment;
        this.drinkingWaterRemarksToScreen = this.amfDrinkingWaterComment;
        this.amfAdequateFurnitureRemarksToScreen = this.amfFurnitureComment;
        this.lightingRemarksToScreen = this.amfLightingComment;
        this.helpDeskRemarksToScreen = this.amfHelpDeskComment;
        this.signnageRemarksToScreen = this.amfSignageComment;
        this.toiletRemarksToScreen = this.amfToiletComment;
        this.permanentRampRemarksToScreen = this.permanentRampComment;
        this.emfAdequateFurnitureRemarksToScreen = this.furnitureComment;
        this.shatterRemarksToScreen = this.shadeComment;
        this.roadConnectivityRemarksToScreen = this.roadComment;
        this.crossingRemarksToScreen = this.toCrossNaturalObstaclesComment;
        this.landlineFaxConnectionRemarksToScreen = this.teleConnectionComment;
        this.mobileConnectivityRemarksToScreen = this.mobileConnectivityComment;
        this.internetFacilityRemarksToScreen = this.internetComment;
        this.signanceRemarksToScreen = this.signageComment;
        this.lweAffectedAreaRemarksToScreen = this.inLweInsurgencyAffectedAreaComment;
        this.forestAreaRemarksToScreen = this.forestSemiForestAreaComment;
        this.vulnerableLocationRemarksToScreen = this.vulnerableCriticalLocationComment;
        this.sensitivePsRemarksToScreen = this.sensitiveHyperSensitivePsComment;
        this.buildingQualityRemarksToScreen = this.buildingQualityComment;
        this.psLessThan20RemarksToScreen = this.isPollingboothAreaIsLt20SqmtsComment;
        this.buildingStatusRemarksToScreen = this.buildingIsDangerousComment;
        this.governmentPsRemarksToScreen = this.governmentBuildingPremisesComment;
        this.religiousPsRemarksToScreen = this.locatedIsAnInstitutionReligiousPlaceComment;
        this.schoolPsRemarksToScreen = this.schoolCollegBuildingComment;
        this.groundFloorPsRemarksToScreen = this.groundFloorComment;
        this.seperateEntryExitRemarksToScreen = this.seperatedDoorForEntryAndExitComment;
        this.politicalPartyOfficeWithin200MetersRemarksToScreen = this.politicalPartyOfficeWithin200MetersComment;
        this.drinkingWaterInPremisesRemarksToScreen = this.drinkingWaterFacilityInPremisesComment;
        this.electricitySupplyRemarksToScreen = this.emfElectricitySupplyComment;
        this.properLightingFixturesRemarksToScreen = this.properLightingsFixturesComment;
        this.toiletMaleFemaleRemarksToScreen = this.toiletMaleFemaleComment;
        this.parkingAvailableRemarksToScreen = this.parkingAvailableComment;
        this.electricityArrangementsRemarksToScreen = this.electricitySupplyComment;
        this.provisionRampRatingToScreen = this.amfRampRating;
        this.drinkingWaterRatingToScreen = this.amfDrinkingWaterRating;
        this.amfAdequateFurnitureRatingToScreen = this.amfFurnitureRating;
        this.lightingRatingToScreen = this.amfLightingRating;
        this.helpDeskRatingToScreen = this.amfHelpDeskRating;
        this.signnageRatingToScreen = this.amfSignageRating;
        this.toiletRatingToScreen = this.amfToiletRating;
        this.permanentRampRatingToScreen = this.permanentRampRating;
        this.emfAdequateFurnitureRatingToScreen = this.furnitureRating;
        this.shatterRatingToScreen = this.shadeRating;
        this.roadConnectivityRatingToScreen = this.roadRating;
        this.crossingRatingToScreen = this.toCrossNaturalObstaclesRating;
        this.landlineFaxConnectionRatingToScreen = this.teleConnectionRating;
        this.mobileConnectivityRatingToScreen = this.mobileConnectivityRating;
        this.internetFacilityRatingToScreen = this.internetRating;
        this.signanceRatingToScreen = this.signageRating;
        this.lweAffectedAreaRatingToScreen = this.inLweInsurgencyAffectedAreaRating;
        this.forestAreaAreaRatingToScreen = this.forestSemiForestAreaRating;
        this.vulnerableLocationRatingToScreen = this.vulnerableCriticalLocationRating;
        this.sensitivePsRatingToScreen = this.sensitiveHyperSensitivePsRating;
        this.buildingQualityRatingToScreen = this.buildingQualityRating;
        this.psLessThan20RatingToScreen = this.lessThan20SqmtsRating;
        this.buildingStatusRatingToScreen = this.buildingIsDangerousRating;
        this.governmentPsRatingToScreen = this.governmentBuildingPremisesRating;
        this.religiousPsRatingToScreen = this.locatedIsAnInstitutionReligiousPlaceRating;
        this.schoolPsRatingToScreen = this.schoolCollegBuildingRating;
        this.groundFloorPsRatingToScreen = this.groundFloorRating;
        this.seperateEntryExitRatingToScreen = this.seperatedDoorForEntryAndExitRating;
        this.politicalPartyOfficeWithin200MetersRatingToScreen = this.politicalPartyOfficeWithin200MetersRating;
        this.drinkingWaterInPremisesRatingToScreen = this.drinkingWaterFacilityInPremisesRating;
        this.electricitySupplyRatingToScreen = this.emfElectricitySupplyRating;
        this.properLightingFixturesRatingToScreen = this.properLightingsFixturesRating;
        this.toiletMaleFemaleRatingToScreen = this.toiletMaleFemaleRating;
        this.parkingAvailableRatingToScreen = this.parkingAvailableRating;
        this.electricityArrangementsRatingToScreen = this.electricitySupplyRating;
        initRecyclerViewAdapter2();
        this.binding.allFacilitiesRv.setLayoutManager(new GridLayoutManager(getContext(), 1, 1, false));
        this.binding.allFacilitiesRv.setAdapter(this.adapter2);
    }

    public void syncAMFEMFDataFromAPIToDB() {
        if (this.openActivity) {
            return;
        }
        this.viewModel.updateFacilitiesData(this.stateCd, this.acNumber, this.partNumber, this.pollingStationName, this.captureGpsAddress, this.provisionRampToScreen, this.drinkingWaterToScreen, this.amfAdequateFurnitureToScreen, this.lightingToScreen, this.helpDeskToScreen, this.signnageToScreen, this.toiletToScreen, this.permanentRampToScreen, this.emfAdequateFurnitureToScreen, this.shatterToScreen, this.roadConnectivityToScreen, this.crossingToScreen, this.landlineFaxConnectionToScreen, this.mobileConnectivityToScreen, this.electricityArrangementToScreen, this.internetFacilityToScreen, this.signanceToScreen, this.lweAffectedAreaToScreen, this.forestAreaToScreen, this.vulnerableLocationToScreen, this.sensitivePsToScreen, this.buildingQualityToScreen, this.psLessThan20ToScreen, this.buildingStatusToScreen, this.governmentPsToScreen, this.religiousPsToScreen, this.schoolPsToScreen, this.groundFloorPsToScreen, this.seperateEntryExitToScreen, this.provisionRampRemarksToScreen, this.drinkingWaterRemarksToScreen, this.amfAdequateFurnitureRemarksToScreen, this.lightingRemarksToScreen, this.helpDeskRemarksToScreen, this.signnageRemarksToScreen, this.toiletRemarksToScreen, this.permanentRampRemarksToScreen, this.emfAdequateFurnitureRemarksToScreen, this.shatterRemarksToScreen, this.roadConnectivityRemarksToScreen, this.crossingRemarksToScreen, this.landlineFaxConnectionRemarksToScreen, this.mobileConnectivityRemarksToScreen, this.electricityArrangementsRemarksToScreen, this.internetFacilityRemarksToScreen, this.signanceRemarksToScreen, this.lweAffectedAreaRemarksToScreen, this.forestAreaRemarksToScreen, this.vulnerableLocationRemarksToScreen, this.sensitivePsRemarksToScreen, this.buildingQualityRemarksToScreen, this.psLessThan20RemarksToScreen, this.buildingStatusRemarksToScreen, this.governmentPsRemarksToScreen, this.religiousPsRemarksToScreen, this.schoolPsRemarksToScreen, this.groundFloorPsRemarksToScreen, this.seperateEntryExitRemarksToScreen, this.provisionRampRatingToScreen, this.drinkingWaterRatingToScreen, this.amfAdequateFurnitureRatingToScreen, this.lightingRatingToScreen, this.helpDeskRatingToScreen, this.signnageRatingToScreen, this.toiletRatingToScreen, this.permanentRampRatingToScreen, this.emfAdequateFurnitureRatingToScreen, this.shatterRatingToScreen, this.roadConnectivityRatingToScreen, this.crossingRatingToScreen, this.landlineFaxConnectionRatingToScreen, this.mobileConnectivityRatingToScreen, this.electricityArrangementsRatingToScreen, this.internetFacilityRatingToScreen, this.signanceRatingToScreen, this.lweAffectedAreaRatingToScreen, this.forestAreaAreaRatingToScreen, this.vulnerableLocationRatingToScreen, this.sensitivePsRatingToScreen, this.buildingQualityRatingToScreen, this.psLessThan20RatingToScreen, this.buildingStatusRatingToScreen, this.governmentPsRatingToScreen, this.religiousPsRatingToScreen, this.schoolPsRatingToScreen, this.groundFloorPsRatingToScreen, this.seperateEntryExitRatingToScreen);
        this.openActivity = true;
    }

    public boolean isInternetConnection() {
        try {
            return ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo().isConnectedOrConnecting();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String string = parent.getSelectedItem().toString();
        this.amfEmfValueFromDropDown = string;
        Logger.d("Facility Drop Down Value : ", string);
        if (this.amfEmfValueFromDropDown.equals(String.format(getString(R.string.blo_facility_All), new Object[0]))) {
            this.binding.editTextFacilitySearch.setQuery("", false);
            this.finalHeaders.clear();
            this.finalHeaders.add(String.format(getString(R.string.blo_Provision_for_ramp), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Provision_for_drinking_water), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Adequate_furniture_for_AMF), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Proper_lightning), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Help_desk), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Proper_signnage), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Toilet), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Permanent_ramp), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Adequate_Furniture_for_EMF), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Shade_shatter_for_protection_from_sun_rain), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_PS_with_proper_road_connectivity), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Voter_have_to_cross_river_valley_ravine_or_natural_obstacles_to_reach_PS), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Landline_telephone_fax_connection), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Mobile_connectivity), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Internet_Facility), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Proper_signage_of_building_name_and_address), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_LWE_insurgency_affected_area), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Forest_semi_forest_area), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Vulnerable_critical_location), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Sensitive_hyper_sensitive_PS), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Building_quality), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_PS_with_less_than_20_sqmts), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Building_is_dilapidated_or_dangerous), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_PS_is_in_Government_building_premises), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_PS_located_is_an_institution_religious_place), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_PS_in_school_college_building), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_PS_on_ground_floor), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Seperate_door_for_Entry_Exit), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_political_Party_Office_Situated_Within_200_meters_of_PS_premises), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_PS_having_drinking_water_facility_in_the_premises), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_PS_having_Electricity_Supply), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_PS_buildings_having_Proper_lightings_Fixtures_etc), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_PS_buildings_with_Toilet_Male_Female), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_facility_Parking_Available), new Object[0]));
            this.finalHeaders.add(String.format(getString(R.string.blo_Lighting_electricity_arrangements), new Object[0]));
        } else if (this.amfEmfValueFromDropDown.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
            this.binding.editTextFacilitySearch.setQuery("", false);
            this.finalHeaders.clear();
            if (this.provisionRampAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Provision_for_ramp), new Object[0]));
            }
            if (this.drinkingWaterAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Provision_for_drinking_water), new Object[0]));
            }
            if (this.amfAdequateFurnitureAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Adequate_furniture_for_AMF), new Object[0]));
            }
            if (this.lightingAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Proper_lightning), new Object[0]));
            }
            if (this.helpDeskAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Help_desk), new Object[0]));
            }
            if (this.signnageAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Proper_signnage), new Object[0]));
            }
            if (this.toiletAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Toilet), new Object[0]));
            }
            if (this.permanentRampAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Permanent_ramp), new Object[0]));
            }
            if (this.emfAdequateFurnitureAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Adequate_Furniture_for_EMF), new Object[0]));
            }
            if (this.shatterAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Shade_shatter_for_protection_from_sun_rain), new Object[0]));
            }
            if (this.roadConnectivityAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_with_proper_road_connectivity), new Object[0]));
            }
            if (this.crossingAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Voter_have_to_cross_river_valley_ravine_or_natural_obstacles_to_reach_PS), new Object[0]));
            }
            if (this.landlineFaxConnectionAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Landline_telephone_fax_connection), new Object[0]));
            }
            if (this.mobileConnectivityAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Mobile_connectivity), new Object[0]));
            }
            if (this.internetFacilityAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Internet_Facility), new Object[0]));
            }
            if (this.signanceAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Proper_signage_of_building_name_and_address), new Object[0]));
            }
            if (this.lweAffectedAreaAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_LWE_insurgency_affected_area), new Object[0]));
            }
            if (this.forestAreaAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Forest_semi_forest_area), new Object[0]));
            }
            if (this.vulnerableLocationAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Vulnerable_critical_location), new Object[0]));
            }
            if (this.sensitivePsAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Sensitive_hyper_sensitive_PS), new Object[0]));
            }
            if (this.buildingQualityAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Building_quality), new Object[0]));
            }
            if (this.psLessThan20AmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_with_less_than_20_sqmts), new Object[0]));
            }
            if (this.buildingStatusAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Building_is_dilapidated_or_dangerous), new Object[0]));
            }
            if (this.governmentPsAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_is_in_Government_building_premises), new Object[0]));
            }
            if (this.religiousPsAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_located_is_an_institution_religious_place), new Object[0]));
            }
            if (this.schoolPsAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_in_school_college_building), new Object[0]));
            }
            if (this.groundFloorPsAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_on_ground_floor), new Object[0]));
            }
            if (this.seperateEntryExitAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Seperate_door_for_Entry_Exit), new Object[0]));
            }
            if (this.politicalPartyOfficeWithin200MetersAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_political_Party_Office_Situated_Within_200_meters_of_PS_premises), new Object[0]));
            }
            if (this.drinkingWaterInPremisesAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_having_drinking_water_facility_in_the_premises), new Object[0]));
            }
            if (this.electricitySupplyAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_having_Electricity_Supply), new Object[0]));
            }
            if (this.properLightingFixturesAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_buildings_having_Proper_lightings_Fixtures_etc), new Object[0]));
            }
            if (this.toiletMaleFemaleAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_buildings_with_Toilet_Male_Female), new Object[0]));
            }
            if (this.parkingAvailableAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_facility_Parking_Available), new Object[0]));
            }
            if (this.electricityArrangementsAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_amf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Lighting_electricity_arrangements), new Object[0]));
            }
        } else if (this.amfEmfValueFromDropDown.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
            this.binding.editTextFacilitySearch.setQuery("", false);
            this.finalHeaders.clear();
            if (this.provisionRampAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Provision_for_ramp), new Object[0]));
            }
            if (this.drinkingWaterAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Provision_for_drinking_water), new Object[0]));
            }
            if (this.amfAdequateFurnitureAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Adequate_furniture_for_AMF), new Object[0]));
            }
            if (this.lightingAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Proper_lightning), new Object[0]));
            }
            if (this.helpDeskAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Help_desk), new Object[0]));
            }
            if (this.signnageAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Proper_signnage), new Object[0]));
            }
            if (this.toiletAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Toilet), new Object[0]));
            }
            if (this.permanentRampAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Permanent_ramp), new Object[0]));
            }
            if (this.emfAdequateFurnitureAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Adequate_Furniture_for_EMF), new Object[0]));
            }
            if (this.shatterAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Shade_shatter_for_protection_from_sun_rain), new Object[0]));
            }
            if (this.roadConnectivityAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_with_proper_road_connectivity), new Object[0]));
            }
            if (this.crossingAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Voter_have_to_cross_river_valley_ravine_or_natural_obstacles_to_reach_PS), new Object[0]));
            }
            if (this.landlineFaxConnectionAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Landline_telephone_fax_connection), new Object[0]));
            }
            if (this.mobileConnectivityAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Mobile_connectivity), new Object[0]));
            }
            if (this.internetFacilityAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Internet_Facility), new Object[0]));
            }
            if (this.signanceAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Proper_signage_of_building_name_and_address), new Object[0]));
            }
            if (this.lweAffectedAreaAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_LWE_insurgency_affected_area), new Object[0]));
            }
            if (this.forestAreaAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Forest_semi_forest_area), new Object[0]));
            }
            if (this.vulnerableLocationAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Vulnerable_critical_location), new Object[0]));
            }
            if (this.sensitivePsAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Sensitive_hyper_sensitive_PS), new Object[0]));
            }
            if (this.buildingQualityAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Building_quality), new Object[0]));
            }
            if (this.psLessThan20AmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_with_less_than_20_sqmts), new Object[0]));
            }
            if (this.buildingStatusAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Building_is_dilapidated_or_dangerous), new Object[0]));
            }
            if (this.governmentPsAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_is_in_Government_building_premises), new Object[0]));
            }
            if (this.religiousPsAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_located_is_an_institution_religious_place), new Object[0]));
            }
            if (this.schoolPsAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_in_school_college_building), new Object[0]));
            }
            if (this.groundFloorPsAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_on_ground_floor), new Object[0]));
            }
            if (this.seperateEntryExitAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Seperate_door_for_Entry_Exit), new Object[0]));
            }
            if (this.politicalPartyOfficeWithin200MetersAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_political_Party_Office_Situated_Within_200_meters_of_PS_premises), new Object[0]));
            }
            if (this.drinkingWaterInPremisesAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_having_drinking_water_facility_in_the_premises), new Object[0]));
            }
            if (this.electricitySupplyAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_having_Electricity_Supply), new Object[0]));
            }
            if (this.properLightingFixturesAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_buildings_having_Proper_lightings_Fixtures_etc), new Object[0]));
            }
            if (this.toiletMaleFemaleAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_PS_buildings_with_Toilet_Male_Female), new Object[0]));
            }
            if (this.parkingAvailableAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_facility_Parking_Available), new Object[0]));
            }
            if (this.electricityArrangementsAmfEmfStatusToScreen.equals(String.format(getString(R.string.blo_emf), new Object[0]))) {
                this.finalHeaders.add(String.format(getString(R.string.blo_Lighting_electricity_arrangements), new Object[0]));
            }
        }
        for (int i = 0; i < this.finalHeaders.size(); i++) {
            Logger.d(this.logTag, "finalHeaders List item as per dropdown value at " + i + " index is : " + this.finalHeaders.get(i));
        }
        initRecyclerViewAdapter2();
        this.binding.allFacilitiesRv.setLayoutManager(new GridLayoutManager(getContext(), 1, 1, false));
        this.binding.allFacilitiesRv.setAdapter(this.adapter2);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.facilities.Facilities$8, reason: invalid class name */
    class AnonymousClass8 implements FilterableRecyclerView.FilterGenericRecyclerAdapterInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass8() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloAllFacilitiesRvItemBinding.inflate(Facilities.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
            ((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.setText(Facilities.this.mHeaders.get(position));
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityHeader.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityButtons.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGood.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverage.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoor.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacilityStatusGood.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacilityStatusAverage.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacilityStatusPoor.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setId(position);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
            ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(8);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(false);
            if (position + 1 == Facilities.this.mHeaders.size()) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).divider.setVisibility(8);
            }
            Logger.d(Facilities.this.logTag, "----- Adding Pre Fetched Data from DB to Recycler View -- Start ---------------------");
            Logger.d(Facilities.this.logTag, "Dynamic Header Values for position " + position + " is : " + ((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString());
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Provision_for_ramp), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_ramp);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.provisionRampAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.provisionRampRemarksToScreen.equals("") && !Facilities.this.provisionRampRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.provisionRampRemarksToScreen != null && !Facilities.this.provisionRampRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.provisionRampToScreen.equals(Facilities.this.textForY) && (Facilities.this.provisionRampRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.provisionRampRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.provisionRampRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.provisionRampRemarksToScreen);
                }
                if (Facilities.this.provisionRampToScreen.equals("") || Facilities.this.provisionRampToScreen.equals(StringUtils.SPACE) || Facilities.this.provisionRampToScreen == null || Facilities.this.provisionRampToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.provisionRampToScreen.equals(Facilities.this.textForY) && Facilities.this.provisionRampRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.provisionRampToScreen.equals(Facilities.this.textForY) && Facilities.this.provisionRampRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.provisionRampToScreen.equals(Facilities.this.textForY) && Facilities.this.provisionRampRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.provisionRampToScreen.equals(Facilities.this.textForY) && Facilities.this.provisionRampRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.provisionRampToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Provision_for_drinking_water), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_water);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.drinkingWaterAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.drinkingWaterRemarksToScreen.equals("") && !Facilities.this.drinkingWaterRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.drinkingWaterRemarksToScreen != null && !Facilities.this.drinkingWaterRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.drinkingWaterToScreen.equals(Facilities.this.textForY) && (Facilities.this.drinkingWaterRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.drinkingWaterRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.drinkingWaterRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.drinkingWaterRemarksToScreen);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                }
                if (Facilities.this.drinkingWaterToScreen.equals("") || Facilities.this.drinkingWaterToScreen.equals(StringUtils.SPACE) || Facilities.this.drinkingWaterToScreen == null || Facilities.this.drinkingWaterToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                } else if (Facilities.this.drinkingWaterToScreen.equals(Facilities.this.textForY) && Facilities.this.drinkingWaterRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.drinkingWaterToScreen.equals(Facilities.this.textForY) && Facilities.this.drinkingWaterRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.drinkingWaterToScreen.equals(Facilities.this.textForY) && Facilities.this.drinkingWaterRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.drinkingWaterToScreen.equals(Facilities.this.textForY) && Facilities.this.drinkingWaterRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.drinkingWaterToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Adequate_furniture_for_AMF), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_furniture);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.amfAdequateFurnitureAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.amfAdequateFurnitureRemarksToScreen.equals("") && !Facilities.this.amfAdequateFurnitureRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.amfAdequateFurnitureRemarksToScreen != null && !Facilities.this.amfAdequateFurnitureRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.amfAdequateFurnitureToScreen.equals(Facilities.this.textForY) && (Facilities.this.amfAdequateFurnitureRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.amfAdequateFurnitureRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.amfAdequateFurnitureRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.amfAdequateFurnitureRemarksToScreen);
                }
                if (Facilities.this.amfAdequateFurnitureToScreen.equals("") || Facilities.this.amfAdequateFurnitureToScreen.equals(StringUtils.SPACE) || Facilities.this.amfAdequateFurnitureToScreen == null || Facilities.this.amfAdequateFurnitureToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.amfAdequateFurnitureToScreen.equals(Facilities.this.textForY) && Facilities.this.amfAdequateFurnitureRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.amfAdequateFurnitureToScreen.equals(Facilities.this.textForY) && Facilities.this.amfAdequateFurnitureRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.amfAdequateFurnitureToScreen.equals(Facilities.this.textForY) && Facilities.this.amfAdequateFurnitureRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.amfAdequateFurnitureToScreen.equals(Facilities.this.textForY) && Facilities.this.amfAdequateFurnitureRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.amfAdequateFurnitureToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Proper_lightning), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_lightning);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.lightingAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.lightingRemarksToScreen.equals("") && !Facilities.this.lightingRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.lightingRemarksToScreen != null && !Facilities.this.lightingRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.lightingToScreen.equals(Facilities.this.textForY) && (Facilities.this.lightingRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.lightingRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.lightingRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.lightingRemarksToScreen);
                }
                if (Facilities.this.lightingToScreen.equals("") || Facilities.this.lightingToScreen.equals(StringUtils.SPACE) || Facilities.this.lightingToScreen == null || Facilities.this.lightingToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.lightingToScreen.equals(Facilities.this.textForY) && Facilities.this.lightingRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.lightingToScreen.equals(Facilities.this.textForY) && Facilities.this.lightingRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.lightingToScreen.equals(Facilities.this.textForY) && Facilities.this.lightingRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.lightingToScreen.equals(Facilities.this.textForY) && Facilities.this.lightingRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.lightingToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Help_desk), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_help_desk);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.helpDeskAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.helpDeskRemarksToScreen.equals("") && !Facilities.this.helpDeskRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.helpDeskRemarksToScreen != null && !Facilities.this.helpDeskRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.helpDeskToScreen.equals(Facilities.this.textForY) && (Facilities.this.helpDeskRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.helpDeskRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.helpDeskRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.helpDeskRemarksToScreen);
                }
                if (Facilities.this.helpDeskToScreen.equals("") || Facilities.this.helpDeskToScreen.equals(StringUtils.SPACE) || Facilities.this.helpDeskToScreen == null || Facilities.this.helpDeskToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.helpDeskToScreen.equals(Facilities.this.textForY) && Facilities.this.helpDeskRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.helpDeskToScreen.equals(Facilities.this.textForY) && Facilities.this.helpDeskRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.helpDeskToScreen.equals(Facilities.this.textForY) && Facilities.this.helpDeskRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.helpDeskToScreen.equals(Facilities.this.textForY) && Facilities.this.helpDeskRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.helpDeskToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Proper_signnage), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_signnage);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.signnageAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.signnageRemarksToScreen.equals("") && !Facilities.this.signnageRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.signnageRemarksToScreen != null && !Facilities.this.signnageRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.signnageToScreen.equals(Facilities.this.textForY) && (Facilities.this.signnageRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.signnageRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.signnageRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.signnageRemarksToScreen);
                }
                if (Facilities.this.signnageToScreen.equals("") || Facilities.this.signnageToScreen.equals(StringUtils.SPACE) || Facilities.this.signnageToScreen == null || Facilities.this.signnageToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.signnageToScreen.equals(Facilities.this.textForY) && Facilities.this.signnageRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.signnageToScreen.equals(Facilities.this.textForY) && Facilities.this.signnageRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.signnageToScreen.equals(Facilities.this.textForY) && Facilities.this.signnageRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.signnageToScreen.equals(Facilities.this.textForY) && Facilities.this.signnageRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.signnageToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Toilet), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_toilet);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.toiletAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.toiletRemarksToScreen.equals("") && !Facilities.this.toiletRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.toiletRemarksToScreen != null && !Facilities.this.toiletRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.toiletToScreen.equals(Facilities.this.textForY) && (Facilities.this.toiletRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.toiletRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.toiletRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.toiletRemarksToScreen);
                }
                if (Facilities.this.toiletToScreen.equals("") || Facilities.this.toiletToScreen.equals(StringUtils.SPACE) || Facilities.this.toiletToScreen == null || Facilities.this.toiletToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.toiletToScreen.equals(Facilities.this.textForY) && Facilities.this.toiletRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.toiletToScreen.equals(Facilities.this.textForY) && Facilities.this.toiletRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.toiletToScreen.equals(Facilities.this.textForY) && Facilities.this.toiletRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.toiletToScreen.equals(Facilities.this.textForY) && Facilities.this.toiletRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.toiletToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Permanent_ramp), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_ramp);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.permanentRampAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.permanentRampRemarksToScreen.equals("") && !Facilities.this.permanentRampRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.permanentRampRemarksToScreen != null && !Facilities.this.permanentRampRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.permanentRampToScreen.equals(Facilities.this.textForY) && (Facilities.this.permanentRampRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.permanentRampRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.permanentRampRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.permanentRampRemarksToScreen);
                }
                if (Facilities.this.permanentRampToScreen.equals("") || Facilities.this.permanentRampToScreen.equals(StringUtils.SPACE) || Facilities.this.permanentRampToScreen == null || Facilities.this.permanentRampToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.permanentRampToScreen.equals(Facilities.this.textForY) && Facilities.this.permanentRampRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.permanentRampToScreen.equals(Facilities.this.textForY) && Facilities.this.permanentRampRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.permanentRampToScreen.equals(Facilities.this.textForY) && Facilities.this.permanentRampRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.permanentRampToScreen.equals(Facilities.this.textForY) && Facilities.this.permanentRampRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.permanentRampToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Adequate_Furniture_for_EMF), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_furniture);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.emfAdequateFurnitureAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.emfAdequateFurnitureRemarksToScreen.equals("") && !Facilities.this.emfAdequateFurnitureRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.emfAdequateFurnitureRemarksToScreen != null && !Facilities.this.emfAdequateFurnitureRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.emfAdequateFurnitureToScreen.equals(Facilities.this.textForY) && (Facilities.this.emfAdequateFurnitureRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.emfAdequateFurnitureRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.emfAdequateFurnitureRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.emfAdequateFurnitureRemarksToScreen);
                }
                if (Facilities.this.emfAdequateFurnitureToScreen.equals("") || Facilities.this.emfAdequateFurnitureToScreen.equals(StringUtils.SPACE) || Facilities.this.emfAdequateFurnitureToScreen == null || Facilities.this.emfAdequateFurnitureToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.emfAdequateFurnitureToScreen.equals(Facilities.this.textForY) && Facilities.this.emfAdequateFurnitureRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.emfAdequateFurnitureToScreen.equals(Facilities.this.textForY) && Facilities.this.emfAdequateFurnitureRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.emfAdequateFurnitureToScreen.equals(Facilities.this.textForY) && Facilities.this.emfAdequateFurnitureRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.emfAdequateFurnitureToScreen.equals(Facilities.this.textForY) && Facilities.this.emfAdequateFurnitureRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.emfAdequateFurnitureToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Shade_shatter_for_protection_from_sun_rain), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_shatter);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.shatterAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.shatterRemarksToScreen.equals("") && !Facilities.this.shatterRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.shatterRemarksToScreen != null && !Facilities.this.shatterRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.shatterToScreen.equals(Facilities.this.textForY) && (Facilities.this.shatterRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.shatterRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.shatterRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.shatterRemarksToScreen);
                }
                if (Facilities.this.shatterToScreen.equals("") || Facilities.this.shatterToScreen.equals(StringUtils.SPACE) || Facilities.this.shatterToScreen == null || Facilities.this.shatterToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.shatterToScreen.equals(Facilities.this.textForY) && Facilities.this.shatterRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.shatterToScreen.equals(Facilities.this.textForY) && Facilities.this.shatterRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.shatterToScreen.equals(Facilities.this.textForY) && Facilities.this.shatterRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.shatterToScreen.equals(Facilities.this.textForY) && Facilities.this.shatterRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.shatterToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_PS_with_proper_road_connectivity), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_road_connectivity);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.roadConnectivityAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.roadConnectivityRemarksToScreen.equals("") && !Facilities.this.roadConnectivityRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.roadConnectivityRemarksToScreen != null && !Facilities.this.roadConnectivityRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.roadConnectivityToScreen.equals(Facilities.this.textForY) && (Facilities.this.roadConnectivityRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.roadConnectivityRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.roadConnectivityRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.roadConnectivityRemarksToScreen);
                }
                if (Facilities.this.roadConnectivityToScreen.equals("") || Facilities.this.roadConnectivityToScreen.equals(StringUtils.SPACE) || Facilities.this.roadConnectivityToScreen == null || Facilities.this.roadConnectivityToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.roadConnectivityToScreen.equals(Facilities.this.textForY) && Facilities.this.roadConnectivityRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.roadConnectivityToScreen.equals(Facilities.this.textForY) && Facilities.this.roadConnectivityRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.roadConnectivityToScreen.equals(Facilities.this.textForY) && Facilities.this.roadConnectivityRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.roadConnectivityToScreen.equals(Facilities.this.textForY) && Facilities.this.roadConnectivityRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.roadConnectivityToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Voter_have_to_cross_river_valley_ravine_or_natural_obstacles_to_reach_PS), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_river_cross);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.crossingAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.crossingRemarksToScreen.equals("") && !Facilities.this.crossingRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.crossingRemarksToScreen != null && !Facilities.this.crossingRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.crossingToScreen.equals(Facilities.this.textForY) && (Facilities.this.crossingRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.crossingRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.crossingRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.crossingRemarksToScreen);
                }
                if (Facilities.this.crossingToScreen.equals("") || Facilities.this.crossingToScreen.equals(StringUtils.SPACE) || Facilities.this.crossingToScreen == null || Facilities.this.crossingToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.crossingToScreen.equals(Facilities.this.textForY) && Facilities.this.crossingRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.crossingToScreen.equals(Facilities.this.textForY) && Facilities.this.crossingRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.crossingToScreen.equals(Facilities.this.textForY) && Facilities.this.crossingRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.crossingToScreen.equals(Facilities.this.textForY) && Facilities.this.crossingRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.crossingToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Landline_telephone_fax_connection), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_landline);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.landlineFaxConnectionAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.landlineFaxConnectionRemarksToScreen.equals("") && !Facilities.this.landlineFaxConnectionRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.landlineFaxConnectionRemarksToScreen != null && !Facilities.this.landlineFaxConnectionRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.landlineFaxConnectionToScreen.equals(Facilities.this.textForY) && (Facilities.this.landlineFaxConnectionRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.landlineFaxConnectionRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.landlineFaxConnectionRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.landlineFaxConnectionRemarksToScreen);
                }
                if (Facilities.this.landlineFaxConnectionToScreen.equals("") || Facilities.this.landlineFaxConnectionToScreen.equals(StringUtils.SPACE) || Facilities.this.landlineFaxConnectionToScreen == null || Facilities.this.landlineFaxConnectionToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.landlineFaxConnectionToScreen.equals(Facilities.this.textForY) && Facilities.this.landlineFaxConnectionRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.landlineFaxConnectionToScreen.equals(Facilities.this.textForY) && Facilities.this.landlineFaxConnectionRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.landlineFaxConnectionToScreen.equals(Facilities.this.textForY) && Facilities.this.landlineFaxConnectionRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.landlineFaxConnectionToScreen.equals(Facilities.this.textForY) && Facilities.this.landlineFaxConnectionRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.landlineFaxConnectionToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Mobile_connectivity), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_mobile);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.mobileConnectivityAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.mobileConnectivityRemarksToScreen.equals("") && !Facilities.this.mobileConnectivityRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.mobileConnectivityRemarksToScreen != null && !Facilities.this.mobileConnectivityRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.mobileConnectivityToScreen.equals(Facilities.this.textForY) && (Facilities.this.mobileConnectivityRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.mobileConnectivityRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.mobileConnectivityRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.mobileConnectivityRemarksToScreen);
                }
                if (Facilities.this.mobileConnectivityToScreen.equals("") || Facilities.this.mobileConnectivityToScreen.equals(StringUtils.SPACE) || Facilities.this.mobileConnectivityToScreen == null || Facilities.this.mobileConnectivityToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.mobileConnectivityToScreen.equals(Facilities.this.textForY) && Facilities.this.mobileConnectivityRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.mobileConnectivityToScreen.equals(Facilities.this.textForY) && Facilities.this.mobileConnectivityRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.mobileConnectivityToScreen.equals(Facilities.this.textForY) && Facilities.this.mobileConnectivityRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.mobileConnectivityToScreen.equals(Facilities.this.textForY) && Facilities.this.mobileConnectivityRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.mobileConnectivityToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Internet_Facility), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_internet);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.internetFacilityAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.internetFacilityRemarksToScreen.equals("") && !Facilities.this.internetFacilityRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.internetFacilityRemarksToScreen != null && !Facilities.this.internetFacilityRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.internetFacilityToScreen.equals(Facilities.this.textForY) && (Facilities.this.internetFacilityRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.internetFacilityRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.internetFacilityRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.internetFacilityRemarksToScreen);
                }
                if (Facilities.this.internetFacilityToScreen.equals("") || Facilities.this.internetFacilityToScreen.equals(StringUtils.SPACE) || Facilities.this.internetFacilityToScreen == null || Facilities.this.internetFacilityToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.internetFacilityToScreen.equals(Facilities.this.textForY) && Facilities.this.internetFacilityRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.internetFacilityToScreen.equals(Facilities.this.textForY) && Facilities.this.internetFacilityRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.internetFacilityToScreen.equals(Facilities.this.textForY) && Facilities.this.internetFacilityRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.internetFacilityToScreen.equals(Facilities.this.textForY) && Facilities.this.internetFacilityRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.internetFacilityToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Proper_signage_of_building_name_and_address), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_signnage);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.signanceAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.signanceRemarksToScreen.equals("") && !Facilities.this.signanceRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.signanceRemarksToScreen != null && !Facilities.this.signanceRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.signanceToScreen.equals(Facilities.this.textForY) && (Facilities.this.signanceRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.signanceRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.signanceRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.signanceRemarksToScreen);
                }
                if (Facilities.this.signanceToScreen.equals("") || Facilities.this.signanceToScreen.equals(StringUtils.SPACE) || Facilities.this.signanceToScreen == null || Facilities.this.signanceToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.signanceToScreen.equals(Facilities.this.textForY) && Facilities.this.signanceRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.signanceToScreen.equals(Facilities.this.textForY) && Facilities.this.signanceRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.signanceToScreen.equals(Facilities.this.textForY) && Facilities.this.signanceRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.signanceToScreen.equals(Facilities.this.textForY) && Facilities.this.signanceRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.signanceToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_LWE_insurgency_affected_area), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_insurgency_area);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.lweAffectedAreaAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.lweAffectedAreaRemarksToScreen.equals("") && !Facilities.this.lweAffectedAreaRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.lweAffectedAreaRemarksToScreen != null && !Facilities.this.lweAffectedAreaRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.lweAffectedAreaToScreen.equals(Facilities.this.textForY) && (Facilities.this.lweAffectedAreaRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.lweAffectedAreaRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.lweAffectedAreaRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.lweAffectedAreaRemarksToScreen);
                }
                if (Facilities.this.lweAffectedAreaToScreen.equals("") || Facilities.this.lweAffectedAreaToScreen.equals(StringUtils.SPACE) || Facilities.this.lweAffectedAreaToScreen == null || Facilities.this.lweAffectedAreaToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.lweAffectedAreaToScreen.equals(Facilities.this.textForY) && Facilities.this.lweAffectedAreaRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.lweAffectedAreaToScreen.equals(Facilities.this.textForY) && Facilities.this.lweAffectedAreaRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.lweAffectedAreaToScreen.equals(Facilities.this.textForY) && Facilities.this.lweAffectedAreaRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.lweAffectedAreaToScreen.equals(Facilities.this.textForY) && Facilities.this.lweAffectedAreaRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.lweAffectedAreaToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Forest_semi_forest_area), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_forest);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.forestAreaAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.forestAreaRemarksToScreen.equals("") && !Facilities.this.forestAreaRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.forestAreaRemarksToScreen != null && !Facilities.this.forestAreaRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.forestAreaToScreen.equals(Facilities.this.textForY) && (Facilities.this.forestAreaAreaRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.forestAreaAreaRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.forestAreaAreaRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.forestAreaRemarksToScreen);
                }
                if (Facilities.this.forestAreaToScreen.equals("") || Facilities.this.forestAreaToScreen.equals(StringUtils.SPACE) || Facilities.this.forestAreaToScreen == null || Facilities.this.forestAreaToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.forestAreaToScreen.equals(Facilities.this.textForY) && Facilities.this.forestAreaAreaRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.forestAreaToScreen.equals(Facilities.this.textForY) && Facilities.this.forestAreaAreaRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.forestAreaToScreen.equals(Facilities.this.textForY) && Facilities.this.forestAreaAreaRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.forestAreaToScreen.equals(Facilities.this.textForY) && Facilities.this.forestAreaAreaRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.forestAreaToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Vulnerable_critical_location), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_vulnerable);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.vulnerableLocationAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.vulnerableLocationRemarksToScreen.equals("") && !Facilities.this.vulnerableLocationRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.vulnerableLocationRemarksToScreen != null && !Facilities.this.vulnerableLocationRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.vulnerableLocationToScreen.equals(Facilities.this.textForY) && (Facilities.this.vulnerableLocationRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.vulnerableLocationRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.vulnerableLocationRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.vulnerableLocationRemarksToScreen);
                }
                if (Facilities.this.vulnerableLocationToScreen.equals("") || Facilities.this.vulnerableLocationToScreen.equals(StringUtils.SPACE) || Facilities.this.vulnerableLocationToScreen == null || Facilities.this.vulnerableLocationToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.vulnerableLocationToScreen.equals(Facilities.this.textForY) && Facilities.this.vulnerableLocationRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.vulnerableLocationToScreen.equals(Facilities.this.textForY) && Facilities.this.vulnerableLocationRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.vulnerableLocationToScreen.equals(Facilities.this.textForY) && Facilities.this.vulnerableLocationRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.vulnerableLocationToScreen.equals(Facilities.this.textForY) && Facilities.this.vulnerableLocationRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.vulnerableLocationToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Sensitive_hyper_sensitive_PS), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_sensitive);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.sensitivePsAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.sensitivePsRemarksToScreen.equals("") && !Facilities.this.sensitivePsRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.sensitivePsRemarksToScreen != null && !Facilities.this.sensitivePsRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.sensitivePsToScreen.equals(Facilities.this.textForY) && (Facilities.this.sensitivePsRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.sensitivePsRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.sensitivePsRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.sensitivePsRemarksToScreen);
                }
                if (Facilities.this.sensitivePsToScreen.equals("") || Facilities.this.sensitivePsToScreen.equals(StringUtils.SPACE) || Facilities.this.sensitivePsToScreen == null || Facilities.this.sensitivePsToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.sensitivePsToScreen.equals(Facilities.this.textForY) && Facilities.this.sensitivePsRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.sensitivePsToScreen.equals(Facilities.this.textForY) && Facilities.this.sensitivePsRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.sensitivePsToScreen.equals(Facilities.this.textForY) && Facilities.this.sensitivePsRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.sensitivePsToScreen.equals(Facilities.this.textForY) && Facilities.this.sensitivePsRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.sensitivePsToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Building_quality), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_building_quality);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.buildingQualityAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.buildingQualityRemarksToScreen.equals("") && !Facilities.this.buildingQualityRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.buildingQualityRemarksToScreen != null && !Facilities.this.buildingQualityRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.buildingQualityToScreen.equals(Facilities.this.textForY) && (Facilities.this.buildingQualityRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.buildingQualityRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.buildingQualityRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.buildingQualityRemarksToScreen);
                }
                if (Facilities.this.buildingQualityToScreen.equals("") || Facilities.this.buildingQualityToScreen.equals(StringUtils.SPACE) || Facilities.this.buildingQualityToScreen == null || Facilities.this.buildingQualityToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.buildingQualityToScreen.equals(Facilities.this.textForY) && Facilities.this.buildingQualityRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.buildingQualityToScreen.equals(Facilities.this.textForY) && Facilities.this.buildingQualityRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.buildingQualityToScreen.equals(Facilities.this.textForY) && Facilities.this.buildingQualityRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.buildingQualityToScreen.equals(Facilities.this.textForY) && Facilities.this.buildingQualityRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.buildingQualityToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_PS_with_less_than_20_sqmts), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_ps_dimension);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.psLessThan20AmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.psLessThan20RemarksToScreen.equals("") && !Facilities.this.psLessThan20RemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.psLessThan20RemarksToScreen != null && !Facilities.this.psLessThan20RemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.psLessThan20ToScreen.equals(Facilities.this.textForY) && (Facilities.this.psLessThan20RatingToScreen.equals(Facilities.this.goodText) || Facilities.this.psLessThan20RatingToScreen.equals(Facilities.this.averageText) || Facilities.this.psLessThan20RatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.psLessThan20RemarksToScreen);
                }
                if (Facilities.this.psLessThan20ToScreen.equals("") || Facilities.this.psLessThan20ToScreen.equals(StringUtils.SPACE) || Facilities.this.psLessThan20ToScreen == null || Facilities.this.psLessThan20ToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.psLessThan20ToScreen.equals(Facilities.this.textForY) && Facilities.this.psLessThan20RatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.psLessThan20ToScreen.equals(Facilities.this.textForY) && Facilities.this.psLessThan20RatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.psLessThan20ToScreen.equals(Facilities.this.textForY) && Facilities.this.psLessThan20RatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.psLessThan20ToScreen.equals(Facilities.this.textForY) && Facilities.this.psLessThan20RatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.psLessThan20ToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Building_is_dilapidated_or_dangerous), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_danger);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.buildingStatusAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.buildingStatusRemarksToScreen.equals("") && !Facilities.this.buildingStatusRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.buildingStatusRemarksToScreen != null && !Facilities.this.buildingStatusRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.buildingStatusToScreen.equals(Facilities.this.textForY) && (Facilities.this.buildingStatusRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.buildingStatusRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.buildingStatusRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.buildingStatusRemarksToScreen);
                }
                if (Facilities.this.buildingStatusToScreen.equals("") || Facilities.this.buildingStatusToScreen.equals(StringUtils.SPACE) || Facilities.this.buildingStatusToScreen == null || Facilities.this.buildingStatusToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.buildingStatusToScreen.equals(Facilities.this.textForY) && Facilities.this.buildingStatusRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.buildingStatusToScreen.equals(Facilities.this.textForY) && Facilities.this.buildingStatusRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.buildingStatusToScreen.equals(Facilities.this.textForY) && Facilities.this.buildingStatusRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.buildingStatusToScreen.equals(Facilities.this.textForY) && Facilities.this.buildingStatusRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.buildingStatusToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_PS_is_in_Government_building_premises), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_government_building);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.governmentPsAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.governmentPsRemarksToScreen.equals("") && !Facilities.this.governmentPsRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.governmentPsRemarksToScreen != null && !Facilities.this.governmentPsRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.governmentPsToScreen.equals(Facilities.this.textForY) && (Facilities.this.governmentPsRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.governmentPsRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.governmentPsRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.governmentPsRemarksToScreen);
                }
                if (Facilities.this.governmentPsToScreen.equals("") || Facilities.this.governmentPsToScreen.equals(StringUtils.SPACE) || Facilities.this.governmentPsToScreen == null || Facilities.this.governmentPsToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.governmentPsToScreen.equals(Facilities.this.textForY) && Facilities.this.governmentPsRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.governmentPsToScreen.equals(Facilities.this.textForY) && Facilities.this.governmentPsRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.governmentPsToScreen.equals(Facilities.this.textForY) && Facilities.this.governmentPsRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.governmentPsToScreen.equals(Facilities.this.textForY) && Facilities.this.governmentPsRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.governmentPsToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_PS_located_is_an_institution_religious_place), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_religious_place);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.religiousPsAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.religiousPsRemarksToScreen.equals("") && !Facilities.this.religiousPsRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.religiousPsRemarksToScreen != null && !Facilities.this.religiousPsRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.religiousPsToScreen.equals(Facilities.this.textForY) && (Facilities.this.religiousPsRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.religiousPsRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.religiousPsRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.religiousPsRemarksToScreen);
                }
                if (Facilities.this.religiousPsToScreen.equals("") || Facilities.this.religiousPsToScreen.equals(StringUtils.SPACE) || Facilities.this.religiousPsToScreen == null || Facilities.this.religiousPsToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.religiousPsToScreen.equals(Facilities.this.textForY) && Facilities.this.religiousPsRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.religiousPsToScreen.equals(Facilities.this.textForY) && Facilities.this.religiousPsRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.religiousPsToScreen.equals(Facilities.this.textForY) && Facilities.this.religiousPsRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.religiousPsToScreen.equals(Facilities.this.textForY) && Facilities.this.religiousPsRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.religiousPsToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_PS_in_school_college_building), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_school);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.schoolPsAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.schoolPsRemarksToScreen.equals("") && !Facilities.this.schoolPsRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.schoolPsRemarksToScreen != null && !Facilities.this.schoolPsRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.schoolPsToScreen.equals(Facilities.this.textForY) && (Facilities.this.schoolPsRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.schoolPsRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.schoolPsRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.schoolPsRemarksToScreen);
                }
                if (Facilities.this.schoolPsToScreen.equals("") || Facilities.this.schoolPsToScreen.equals(StringUtils.SPACE) || Facilities.this.schoolPsToScreen == null || Facilities.this.schoolPsToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.schoolPsToScreen.equals(Facilities.this.textForY) && Facilities.this.schoolPsRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.schoolPsToScreen.equals(Facilities.this.textForY) && Facilities.this.schoolPsRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.schoolPsToScreen.equals(Facilities.this.textForY) && Facilities.this.schoolPsRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.schoolPsToScreen.equals(Facilities.this.textForY) && Facilities.this.schoolPsRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.schoolPsToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_PS_on_ground_floor), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_ground_floor);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.groundFloorPsAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.groundFloorPsRemarksToScreen.equals("") && !Facilities.this.groundFloorPsRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.groundFloorPsRemarksToScreen != null && !Facilities.this.groundFloorPsRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.groundFloorPsToScreen.equals(Facilities.this.textForY) && (Facilities.this.groundFloorPsRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.groundFloorPsRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.groundFloorPsRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.groundFloorPsRemarksToScreen);
                }
                if (Facilities.this.groundFloorPsToScreen.equals("") || Facilities.this.groundFloorPsToScreen.equals(StringUtils.SPACE) || Facilities.this.groundFloorPsToScreen == null || Facilities.this.groundFloorPsToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.groundFloorPsToScreen.equals(Facilities.this.textForY) && Facilities.this.groundFloorPsRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.groundFloorPsToScreen.equals(Facilities.this.textForY) && Facilities.this.groundFloorPsRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.groundFloorPsToScreen.equals(Facilities.this.textForY) && Facilities.this.groundFloorPsRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.groundFloorPsToScreen.equals(Facilities.this.textForY) && Facilities.this.groundFloorPsRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.groundFloorPsToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Seperate_door_for_Entry_Exit), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_entry_exit);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.seperateEntryExitAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.seperateEntryExitRemarksToScreen.equals("") && !Facilities.this.seperateEntryExitRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.seperateEntryExitRemarksToScreen != null && !Facilities.this.seperateEntryExitRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.seperateEntryExitToScreen.equals(Facilities.this.textForY) && (Facilities.this.seperateEntryExitRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.seperateEntryExitRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.seperateEntryExitRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.seperateEntryExitRemarksToScreen);
                }
                if (Facilities.this.seperateEntryExitToScreen.equals("") || Facilities.this.seperateEntryExitToScreen.equals(StringUtils.SPACE) || Facilities.this.seperateEntryExitToScreen == null || Facilities.this.seperateEntryExitToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.seperateEntryExitToScreen.equals(Facilities.this.textForY) && Facilities.this.seperateEntryExitRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.seperateEntryExitToScreen.equals(Facilities.this.textForY) && Facilities.this.seperateEntryExitRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.seperateEntryExitToScreen.equals(Facilities.this.textForY) && Facilities.this.seperateEntryExitRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.seperateEntryExitToScreen.equals(Facilities.this.textForY) && Facilities.this.seperateEntryExitRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.seperateEntryExitToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_political_Party_Office_Situated_Within_200_meters_of_PS_premises), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_meeting_room);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.politicalPartyOfficeWithin200MetersAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.politicalPartyOfficeWithin200MetersRemarksToScreen.equals("") && !Facilities.this.politicalPartyOfficeWithin200MetersRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.politicalPartyOfficeWithin200MetersRemarksToScreen != null && !Facilities.this.politicalPartyOfficeWithin200MetersRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.politicalPartyOfficeWithin200MetersToScreen.equals(Facilities.this.textForY) && (Facilities.this.politicalPartyOfficeWithin200MetersRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.politicalPartyOfficeWithin200MetersRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.politicalPartyOfficeWithin200MetersRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.politicalPartyOfficeWithin200MetersRemarksToScreen);
                }
                if (Facilities.this.politicalPartyOfficeWithin200MetersToScreen.equals("") || Facilities.this.politicalPartyOfficeWithin200MetersToScreen.equals(StringUtils.SPACE) || Facilities.this.politicalPartyOfficeWithin200MetersToScreen == null || Facilities.this.politicalPartyOfficeWithin200MetersToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.politicalPartyOfficeWithin200MetersToScreen.equals(Facilities.this.textForY) && Facilities.this.politicalPartyOfficeWithin200MetersRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.politicalPartyOfficeWithin200MetersToScreen.equals(Facilities.this.textForY) && Facilities.this.politicalPartyOfficeWithin200MetersRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.politicalPartyOfficeWithin200MetersToScreen.equals(Facilities.this.textForY) && Facilities.this.politicalPartyOfficeWithin200MetersRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.politicalPartyOfficeWithin200MetersToScreen.equals(Facilities.this.textForY) && Facilities.this.politicalPartyOfficeWithin200MetersRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.politicalPartyOfficeWithin200MetersToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_PS_having_drinking_water_facility_in_the_premises), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_water);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.drinkingWaterInPremisesAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.drinkingWaterInPremisesRemarksToScreen.equals("") && !Facilities.this.drinkingWaterInPremisesRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.drinkingWaterInPremisesRemarksToScreen != null && !Facilities.this.drinkingWaterInPremisesRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.drinkingWaterInPremisesToScreen.equals(Facilities.this.textForY) && (Facilities.this.drinkingWaterInPremisesRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.drinkingWaterInPremisesRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.drinkingWaterInPremisesRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.drinkingWaterInPremisesRemarksToScreen);
                }
                if (Facilities.this.drinkingWaterInPremisesToScreen.equals("") || Facilities.this.drinkingWaterInPremisesToScreen.equals(StringUtils.SPACE) || Facilities.this.drinkingWaterInPremisesToScreen == null || Facilities.this.drinkingWaterInPremisesToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.drinkingWaterInPremisesToScreen.equals(Facilities.this.textForY) && Facilities.this.drinkingWaterInPremisesRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.drinkingWaterInPremisesToScreen.equals(Facilities.this.textForY) && Facilities.this.drinkingWaterInPremisesRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.drinkingWaterInPremisesToScreen.equals(Facilities.this.textForY) && Facilities.this.drinkingWaterInPremisesRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.drinkingWaterInPremisesToScreen.equals(Facilities.this.textForY) && Facilities.this.drinkingWaterInPremisesRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.drinkingWaterInPremisesToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_PS_having_Electricity_Supply), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_electricity_icon);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.electricitySupplyAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.electricitySupplyRemarksToScreen.equals("") && !Facilities.this.electricitySupplyRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.electricitySupplyRemarksToScreen != null && !Facilities.this.electricitySupplyRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.electricitySupplyToScreen.equals(Facilities.this.textForY) && (Facilities.this.electricitySupplyRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.electricitySupplyRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.electricitySupplyRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.electricitySupplyRemarksToScreen);
                }
                if (Facilities.this.electricitySupplyToScreen.equals("") || Facilities.this.electricitySupplyToScreen.equals(StringUtils.SPACE) || Facilities.this.electricitySupplyToScreen == null || Facilities.this.electricitySupplyToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.electricitySupplyToScreen.equals(Facilities.this.textForY) && Facilities.this.electricitySupplyRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.electricitySupplyToScreen.equals(Facilities.this.textForY) && Facilities.this.electricitySupplyRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.electricitySupplyToScreen.equals(Facilities.this.textForY) && Facilities.this.electricitySupplyRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.electricitySupplyToScreen.equals(Facilities.this.textForY) && Facilities.this.electricitySupplyRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.electricitySupplyToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_PS_buildings_having_Proper_lightings_Fixtures_etc), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_lightning);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.properLightingFixturesAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.properLightingFixturesRemarksToScreen.equals("") && !Facilities.this.properLightingFixturesRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.properLightingFixturesRemarksToScreen != null && !Facilities.this.properLightingFixturesRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.properLightingFixturesToScreen.equals(Facilities.this.textForY) && (Facilities.this.properLightingFixturesRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.properLightingFixturesRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.properLightingFixturesRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.properLightingFixturesRemarksToScreen);
                }
                if (Facilities.this.properLightingFixturesToScreen.equals("") || Facilities.this.properLightingFixturesToScreen.equals(StringUtils.SPACE) || Facilities.this.properLightingFixturesToScreen == null || Facilities.this.properLightingFixturesToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.properLightingFixturesToScreen.equals(Facilities.this.textForY) && Facilities.this.properLightingFixturesRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.properLightingFixturesToScreen.equals(Facilities.this.textForY) && Facilities.this.properLightingFixturesRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.properLightingFixturesToScreen.equals(Facilities.this.textForY) && Facilities.this.properLightingFixturesRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.properLightingFixturesToScreen.equals(Facilities.this.textForY) && Facilities.this.properLightingFixturesRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.properLightingFixturesToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_PS_buildings_with_Toilet_Male_Female), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_toilet);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.toiletMaleFemaleAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.toiletMaleFemaleRemarksToScreen.equals("") && !Facilities.this.toiletMaleFemaleRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.toiletMaleFemaleRemarksToScreen != null && !Facilities.this.toiletMaleFemaleRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.toiletMaleFemaleToScreen.equals(Facilities.this.textForY) && (Facilities.this.toiletMaleFemaleRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.toiletMaleFemaleRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.toiletMaleFemaleRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.toiletMaleFemaleRemarksToScreen);
                }
                if (Facilities.this.toiletMaleFemaleToScreen.equals("") || Facilities.this.toiletMaleFemaleToScreen.equals(StringUtils.SPACE) || Facilities.this.toiletMaleFemaleToScreen == null || Facilities.this.toiletMaleFemaleToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.toiletMaleFemaleToScreen.equals(Facilities.this.textForY) && Facilities.this.toiletMaleFemaleRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.toiletMaleFemaleToScreen.equals(Facilities.this.textForY) && Facilities.this.toiletMaleFemaleRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.toiletMaleFemaleToScreen.equals(Facilities.this.textForY) && Facilities.this.toiletMaleFemaleRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.toiletMaleFemaleToScreen.equals(Facilities.this.textForY) && Facilities.this.toiletMaleFemaleRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.toiletMaleFemaleToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_facility_Parking_Available), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_parking_icon);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.parkingAvailableAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.parkingAvailableRemarksToScreen.equals("") && !Facilities.this.parkingAvailableRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.parkingAvailableRemarksToScreen != null && !Facilities.this.parkingAvailableRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.parkingAvailableToScreen.equals(Facilities.this.textForY) && (Facilities.this.parkingAvailableRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.parkingAvailableRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.parkingAvailableRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.parkingAvailableRemarksToScreen);
                }
                if (Facilities.this.parkingAvailableToScreen.equals("") || Facilities.this.parkingAvailableToScreen.equals(StringUtils.SPACE) || Facilities.this.parkingAvailableToScreen == null || Facilities.this.parkingAvailableToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.parkingAvailableToScreen.equals(Facilities.this.textForY) && Facilities.this.parkingAvailableRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.parkingAvailableToScreen.equals(Facilities.this.textForY) && Facilities.this.parkingAvailableRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.parkingAvailableToScreen.equals(Facilities.this.textForY) && Facilities.this.parkingAvailableRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.parkingAvailableToScreen.equals(Facilities.this.textForY) && Facilities.this.parkingAvailableRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.parkingAvailableToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            if (((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString().equals(String.format(Facilities.this.getString(R.string.blo_Lighting_electricity_arrangements), new Object[0]))) {
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityImage.setImageResource(R.drawable.blo_lightning);
                ((BloAllFacilitiesRvItemBinding) holder.binding).textViewAmfEmfFacility.setText(Facilities.this.electricityArrangementsAmfEmfStatusToScreen);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                if (!Facilities.this.electricityArrangementsRemarksToScreen.equals("") && !Facilities.this.electricityArrangementsRemarksToScreen.equals(StringUtils.SPACE) && Facilities.this.electricityArrangementsRemarksToScreen != null && !Facilities.this.electricityArrangementsRemarksToScreen.equals(Facilities.this.nullText) && Facilities.this.electricityArrangementToScreen.equals(Facilities.this.textForY) && (Facilities.this.electricityArrangementsRatingToScreen.equals(Facilities.this.goodText) || Facilities.this.electricityArrangementsRatingToScreen.equals(Facilities.this.averageText) || Facilities.this.electricityArrangementsRatingToScreen.equals(Facilities.this.poorText))) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.setText(Facilities.this.electricityArrangementsRemarksToScreen);
                }
                if (Facilities.this.electricityArrangementToScreen.equals("") || Facilities.this.electricityArrangementToScreen.equals(StringUtils.SPACE) || Facilities.this.electricityArrangementToScreen == null || Facilities.this.electricityArrangementToScreen.equals(Facilities.this.nullText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(8);
                } else if (Facilities.this.electricityArrangementToScreen.equals(Facilities.this.textForY) && Facilities.this.electricityArrangementsRatingToScreen.equals(Facilities.this.goodText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.electricityArrangementToScreen.equals(Facilities.this.textForY) && Facilities.this.electricityArrangementsRatingToScreen.equals(Facilities.this.averageText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(8);
                } else if (Facilities.this.electricityArrangementToScreen.equals(Facilities.this.textForY) && Facilities.this.electricityArrangementsRatingToScreen.equals(Facilities.this.poorText)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoorImage.setVisibility(0);
                } else if (Facilities.this.electricityArrangementToScreen.equals(Facilities.this.textForY) && Facilities.this.electricityArrangementsRatingToScreen.equals("")) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                } else if (Facilities.this.electricityArrangementToScreen.equals(Facilities.this.textForN)) {
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setVisibility(8);
                }
            }
            Logger.d(Facilities.this.logTag, "----- Adding Pre Fetched Data from DB to Recycler View -- End ---------------------");
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityAvailableButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$8$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(holder, view);
                }
            });
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityNotAvailableButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$8$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(holder, view);
                }
            });
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityRefreshButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$8$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$2(holder, view);
                }
            });
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusGood.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$8$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$3(holder, view);
                }
            });
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusAverage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$8$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$4(holder, view);
                }
            });
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityStatusPoor.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$8$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$5(holder, view);
                }
            });
            ((BloAllFacilitiesRvItemBinding) holder.binding).facilityEditButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$8$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$6(holder, view);
                }
            });
            ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities.8.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    Facilities.this.setFacilityData(Facilities.this.editText, Facilities.this.enableText, ((BloAllFacilitiesRvItemBinding) holder.binding).textViewFacility.getText().toString(), ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.getText().toString());
                    ((BloAllFacilitiesRvItemBinding) holder.binding).editTextFacilityRemark.clearFocus();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(RecyclerViewHolder recyclerViewHolder, View view) {
            if (((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableStatus.getId() == ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.getId()) {
                if (((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableStatus.getVisibility() == 8) {
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableStatus.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusPoorImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setText("");
                    Facilities facilities = Facilities.this;
                    facilities.setFacilityData(facilities.availableText, Facilities.this.enableText, ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).textViewFacility.getText().toString(), "");
                    return;
                }
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusPoorImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityNotAvailableButton.setEnabled(true);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setText("");
                Facilities facilities2 = Facilities.this;
                facilities2.setFacilityData(facilities2.availableText, Facilities.this.disableText, ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).textViewFacility.getText().toString(), "");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(RecyclerViewHolder recyclerViewHolder, View view) {
            if (((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableStatus.getId() == ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityNotAvailableButton.getId()) {
                if (((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.isEnabled()) {
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableStatus.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusPoorImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityRefreshButton.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_facilities_button_disabled_style);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityNotAvailableButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setText("");
                    Facilities facilities = Facilities.this;
                    facilities.setFacilityData(facilities.notAvailableText, Facilities.this.enableText, ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).textViewFacility.getText().toString(), "");
                    return;
                }
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableStatus.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusPoorImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityRefreshButton.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.setEnabled(true);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityNotAvailableButton.setEnabled(true);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setText("");
                Facilities facilities2 = Facilities.this;
                facilities2.setFacilityData(facilities2.notAvailableText, Facilities.this.disableText, ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).textViewFacility.getText().toString(), "");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(RecyclerViewHolder recyclerViewHolder, View view) {
            if (((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.isEnabled() && ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityNotAvailableButton.isEnabled()) {
                return;
            }
            ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableStatus.setVisibility(8);
            ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusGoodImage.setVisibility(8);
            ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusAverageImage.setVisibility(8);
            ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusPoorImage.setVisibility(8);
            ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityRefreshButton.setVisibility(8);
            ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityNotAvailableButton.setEnabled(true);
            ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityNotAvailableButton.setBackgroundResource(R.drawable.blo_not_available_button_style);
            ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.setEnabled(true);
            ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.setBackgroundResource(R.drawable.blo_available_button_style);
            ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setVisibility(8);
            ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setText("");
            Facilities facilities = Facilities.this;
            facilities.setFacilityData(facilities.refreshText, Facilities.this.enableText, ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).textViewFacility.getText().toString(), "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$3(RecyclerViewHolder recyclerViewHolder, View view) {
            if (((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusGood.getId() == ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.getId()) {
                if (((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusGoodImage.getVisibility() == 8) {
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusGoodImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusPoorImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setText("");
                    Facilities facilities = Facilities.this;
                    facilities.setFacilityData(facilities.availableGoodText, Facilities.this.enableText, ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).textViewFacility.getText().toString(), "");
                    return;
                }
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusPoorImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityEditButton.setEnabled(false);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setText("");
                Facilities facilities2 = Facilities.this;
                facilities2.setFacilityData(facilities2.availableGoodText, Facilities.this.disableText, ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).textViewFacility.getText().toString(), "");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$4(RecyclerViewHolder recyclerViewHolder, View view) {
            if (((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusAverage.getId() == ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.getId()) {
                if (((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusAverageImage.getVisibility() == 8) {
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusAverageImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusPoorImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setText("");
                    Facilities facilities = Facilities.this;
                    facilities.setFacilityData(facilities.availableAverageText, Facilities.this.enableText, ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).textViewFacility.getText().toString(), "");
                    return;
                }
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusPoorImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityEditButton.setEnabled(false);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setText("");
                Facilities facilities2 = Facilities.this;
                facilities2.setFacilityData(facilities2.availableAverageText, Facilities.this.disableText, ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).textViewFacility.getText().toString(), "");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$5(RecyclerViewHolder recyclerViewHolder, View view) {
            if (((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusPoor.getId() == ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.getId()) {
                if (((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusPoorImage.getVisibility() == 8) {
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusGoodImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusAverageImage.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusPoorImage.setVisibility(0);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setVisibility(8);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityEditButton.setEnabled(true);
                    ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setText("");
                    Facilities facilities = Facilities.this;
                    facilities.setFacilityData(facilities.availablePoorText, Facilities.this.enableText, ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).textViewFacility.getText().toString(), "");
                    return;
                }
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusGoodImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusAverageImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityStatusPoorImage.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setVisibility(8);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityEditButton.setEnabled(false);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setText("");
                Facilities facilities2 = Facilities.this;
                facilities2.setFacilityData(facilities2.availablePoorText, Facilities.this.disableText, ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).textViewFacility.getText().toString(), "");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$6(final RecyclerViewHolder recyclerViewHolder, View view) {
            if (((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityEditButton.getId() == ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).facilityAvailableButton.getId()) {
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.setVisibility(0);
                ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities.8.1
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                        Facilities.this.setFacilityData(Facilities.this.editText, Facilities.this.enableText, ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).textViewFacility.getText().toString(), ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.getText().toString());
                        ((BloAllFacilitiesRvItemBinding) recyclerViewHolder.binding).editTextFacilityRemark.clearFocus();
                    }
                });
            }
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public int getItemCount() {
            return Facilities.this.mHeaders.size();
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.FilterableRecyclerView.FilterGenericRecyclerAdapterInterface
        public Filter getFilter() {
            return new Filter() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities.8.3
                @Override // android.widget.Filter
                protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                    String strValueOf = String.valueOf(charSequence);
                    if (strValueOf.length() == 0) {
                        Facilities.this.mHeaders = Facilities.this.finalHeaders;
                    } else {
                        ArrayList<String> arrayList = new ArrayList<>();
                        for (int i = 0; i < Facilities.this.mHeaders.size(); i++) {
                            if (Facilities.this.mHeaders.get(i).toLowerCase(Locale.ROOT).contains(strValueOf.toLowerCase(Locale.ROOT))) {
                                arrayList.add(Facilities.this.mHeaders.get(i));
                            }
                        }
                        Facilities.this.mHeaders = arrayList;
                    }
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    filterResults.values = Facilities.this.mHeaders;
                    return filterResults;
                }

                @Override // android.widget.Filter
                protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    Facilities.this.adapter2.notifyDataSetChanged();
                }
            };
        }
    }

    private void initRecyclerViewAdapter2() {
        this.mHeaders = this.finalHeaders;
        this.adapter2 = new FilterableRecyclerView(new AnonymousClass8());
    }

    public void setFacilityData(String btnValue, String btnEnableStatus, String headerText, String btnRemark) {
        if (btnValue.equals(this.availableText) && btnEnableStatus.equals(this.enableText) && btnRemark.equals("")) {
            if (headerText.equals(String.format(getString(R.string.blo_Provision_for_ramp), new Object[0]))) {
                this.provisionRampToScreen = this.textForY;
                this.provisionRampRatingToScreen = null;
                this.provisionRampRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Provision_for_drinking_water), new Object[0]))) {
                this.drinkingWaterToScreen = this.textForY;
                this.drinkingWaterRatingToScreen = null;
                this.drinkingWaterRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Adequate_furniture_for_AMF), new Object[0]))) {
                this.amfAdequateFurnitureToScreen = this.textForY;
                this.amfAdequateFurnitureRatingToScreen = null;
                this.amfAdequateFurnitureRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_lightning), new Object[0]))) {
                this.lightingToScreen = this.textForY;
                this.lightingRatingToScreen = null;
                this.lightingRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Help_desk), new Object[0]))) {
                this.helpDeskToScreen = this.textForY;
                this.helpDeskRatingToScreen = null;
                this.helpDeskRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_signnage), new Object[0]))) {
                this.signnageToScreen = this.textForY;
                this.signnageRatingToScreen = null;
                this.signnageRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Toilet), new Object[0]))) {
                this.toiletToScreen = this.textForY;
                this.toiletRatingToScreen = null;
                this.toiletRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Permanent_ramp), new Object[0]))) {
                this.permanentRampToScreen = this.textForY;
                this.permanentRampRatingToScreen = null;
                this.permanentRampRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Adequate_Furniture_for_EMF), new Object[0]))) {
                this.emfAdequateFurnitureToScreen = this.textForY;
                this.emfAdequateFurnitureRatingToScreen = null;
                this.emfAdequateFurnitureRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Shade_shatter_for_protection_from_sun_rain), new Object[0]))) {
                this.shatterToScreen = this.textForY;
                this.shatterRatingToScreen = null;
                this.shatterRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_with_proper_road_connectivity), new Object[0]))) {
                this.roadConnectivityToScreen = this.textForY;
                this.roadConnectivityRatingToScreen = null;
                this.roadConnectivityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Voter_have_to_cross_river_valley_ravine_or_natural_obstacles_to_reach_PS), new Object[0]))) {
                this.crossingToScreen = this.textForY;
                this.crossingRatingToScreen = null;
                this.crossingRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Landline_telephone_fax_connection), new Object[0]))) {
                this.landlineFaxConnectionToScreen = this.textForY;
                this.landlineFaxConnectionRatingToScreen = null;
                this.landlineFaxConnectionRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Mobile_connectivity), new Object[0]))) {
                this.mobileConnectivityToScreen = this.textForY;
                this.mobileConnectivityRatingToScreen = null;
                this.mobileConnectivityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Internet_Facility), new Object[0]))) {
                this.internetFacilityToScreen = this.textForY;
                this.internetFacilityRatingToScreen = null;
                this.internetFacilityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_signage_of_building_name_and_address), new Object[0]))) {
                this.signanceToScreen = this.textForY;
                this.signanceRatingToScreen = null;
                this.signanceRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_LWE_insurgency_affected_area), new Object[0]))) {
                this.lweAffectedAreaToScreen = this.textForY;
                this.lweAffectedAreaRatingToScreen = null;
                this.lweAffectedAreaRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Forest_semi_forest_area), new Object[0]))) {
                this.forestAreaToScreen = this.textForY;
                this.forestAreaAreaRatingToScreen = null;
                this.forestAreaRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Vulnerable_critical_location), new Object[0]))) {
                this.vulnerableLocationToScreen = this.textForY;
                this.vulnerableLocationRatingToScreen = null;
                this.vulnerableLocationRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Sensitive_hyper_sensitive_PS), new Object[0]))) {
                this.sensitivePsToScreen = this.textForY;
                this.sensitivePsRatingToScreen = null;
                this.sensitivePsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Building_quality), new Object[0]))) {
                this.buildingQualityToScreen = this.textForY;
                this.buildingQualityRatingToScreen = null;
                this.buildingQualityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_with_less_than_20_sqmts), new Object[0]))) {
                this.psLessThan20ToScreen = this.textForY;
                this.psLessThan20RatingToScreen = null;
                this.psLessThan20RemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Building_is_dilapidated_or_dangerous), new Object[0]))) {
                this.buildingStatusToScreen = this.textForY;
                this.buildingStatusRatingToScreen = null;
                this.buildingStatusRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_is_in_Government_building_premises), new Object[0]))) {
                this.governmentPsToScreen = this.textForY;
                this.governmentPsRatingToScreen = null;
                this.governmentPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_located_is_an_institution_religious_place), new Object[0]))) {
                this.religiousPsToScreen = this.textForY;
                this.religiousPsRatingToScreen = null;
                this.religiousPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_in_school_college_building), new Object[0]))) {
                this.schoolPsToScreen = this.textForY;
                this.schoolPsRatingToScreen = null;
                this.schoolPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_on_ground_floor), new Object[0]))) {
                this.groundFloorPsToScreen = this.textForY;
                this.groundFloorPsRatingToScreen = null;
                this.groundFloorPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Seperate_door_for_Entry_Exit), new Object[0]))) {
                this.seperateEntryExitToScreen = this.textForY;
                this.seperateEntryExitRatingToScreen = null;
                this.seperateEntryExitRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_political_Party_Office_Situated_Within_200_meters_of_PS_premises), new Object[0]))) {
                this.politicalPartyOfficeWithin200MetersToScreen = this.textForY;
                this.politicalPartyOfficeWithin200MetersRatingToScreen = null;
                this.politicalPartyOfficeWithin200MetersRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_having_drinking_water_facility_in_the_premises), new Object[0]))) {
                this.drinkingWaterInPremisesToScreen = this.textForY;
                this.drinkingWaterInPremisesRatingToScreen = null;
                this.drinkingWaterInPremisesRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_having_Electricity_Supply), new Object[0]))) {
                this.electricitySupplyToScreen = this.textForY;
                this.electricitySupplyRatingToScreen = null;
                this.electricitySupplyRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_buildings_having_Proper_lightings_Fixtures_etc), new Object[0]))) {
                this.properLightingFixturesToScreen = this.textForY;
                this.properLightingFixturesRatingToScreen = null;
                this.properLightingFixturesRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_buildings_with_Toilet_Male_Female), new Object[0]))) {
                this.toiletMaleFemaleToScreen = this.textForY;
                this.toiletMaleFemaleRatingToScreen = null;
                this.toiletMaleFemaleRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_facility_Parking_Available), new Object[0]))) {
                this.parkingAvailableToScreen = this.textForY;
                this.parkingAvailableRatingToScreen = null;
                this.parkingAvailableRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Lighting_electricity_arrangements), new Object[0]))) {
                this.electricityArrangementToScreen = this.textForY;
                this.electricityArrangementsRatingToScreen = null;
                this.electricityArrangementsRemarksToScreen = null;
            }
        }
        if ((btnValue.equals(this.availableText) && btnEnableStatus.equals(this.disableText)) || ((btnValue.equals(this.notAvailableText) && btnEnableStatus.equals(this.disableText)) || ((btnValue.equals(this.refreshText) && btnEnableStatus.equals(this.enableText)) || ((btnValue.equals(this.availableGoodText) && btnEnableStatus.equals(this.disableText)) || ((btnValue.equals(this.availableAverageText) && btnEnableStatus.equals(this.disableText)) || (btnValue.equals(this.availablePoorText) && btnEnableStatus.equals(this.disableText))))))) {
            if (headerText.equals(String.format(getString(R.string.blo_Provision_for_ramp), new Object[0]))) {
                this.provisionRampToScreen = null;
                this.provisionRampRatingToScreen = null;
                this.provisionRampRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Provision_for_drinking_water), new Object[0]))) {
                this.drinkingWaterToScreen = null;
                this.drinkingWaterRatingToScreen = null;
                this.drinkingWaterRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Adequate_furniture_for_AMF), new Object[0]))) {
                this.amfAdequateFurnitureToScreen = null;
                this.amfAdequateFurnitureRatingToScreen = null;
                this.amfAdequateFurnitureRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_lightning), new Object[0]))) {
                this.lightingToScreen = null;
                this.lightingRatingToScreen = null;
                this.lightingRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Help_desk), new Object[0]))) {
                this.helpDeskToScreen = null;
                this.helpDeskRatingToScreen = null;
                this.helpDeskRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_signnage), new Object[0]))) {
                this.signnageToScreen = null;
                this.signnageRatingToScreen = null;
                this.signnageRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Toilet), new Object[0]))) {
                this.toiletToScreen = null;
                this.toiletRatingToScreen = null;
                this.toiletRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Permanent_ramp), new Object[0]))) {
                this.permanentRampToScreen = null;
                this.permanentRampRatingToScreen = null;
                this.permanentRampRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Adequate_Furniture_for_EMF), new Object[0]))) {
                this.emfAdequateFurnitureToScreen = null;
                this.emfAdequateFurnitureRatingToScreen = null;
                this.emfAdequateFurnitureRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Shade_shatter_for_protection_from_sun_rain), new Object[0]))) {
                this.shatterToScreen = null;
                this.shatterRatingToScreen = null;
                this.shatterRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_with_proper_road_connectivity), new Object[0]))) {
                this.roadConnectivityToScreen = null;
                this.roadConnectivityRatingToScreen = null;
                this.roadConnectivityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Voter_have_to_cross_river_valley_ravine_or_natural_obstacles_to_reach_PS), new Object[0]))) {
                this.crossingToScreen = null;
                this.crossingRatingToScreen = null;
                this.crossingRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Landline_telephone_fax_connection), new Object[0]))) {
                this.landlineFaxConnectionToScreen = null;
                this.landlineFaxConnectionRatingToScreen = null;
                this.landlineFaxConnectionRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Mobile_connectivity), new Object[0]))) {
                this.mobileConnectivityToScreen = null;
                this.mobileConnectivityRatingToScreen = null;
                this.mobileConnectivityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Internet_Facility), new Object[0]))) {
                this.internetFacilityToScreen = null;
                this.internetFacilityRatingToScreen = null;
                this.internetFacilityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_signage_of_building_name_and_address), new Object[0]))) {
                this.signanceToScreen = null;
                this.signanceRatingToScreen = null;
                this.signanceRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_LWE_insurgency_affected_area), new Object[0]))) {
                this.lweAffectedAreaToScreen = null;
                this.lweAffectedAreaRatingToScreen = null;
                this.lweAffectedAreaRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Forest_semi_forest_area), new Object[0]))) {
                this.forestAreaToScreen = null;
                this.forestAreaAreaRatingToScreen = null;
                this.forestAreaRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Vulnerable_critical_location), new Object[0]))) {
                this.vulnerableLocationToScreen = null;
                this.vulnerableLocationRatingToScreen = null;
                this.vulnerableLocationRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Sensitive_hyper_sensitive_PS), new Object[0]))) {
                this.sensitivePsToScreen = null;
                this.sensitivePsRatingToScreen = null;
                this.sensitivePsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Building_quality), new Object[0]))) {
                this.buildingQualityToScreen = null;
                this.buildingQualityRatingToScreen = null;
                this.buildingQualityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_with_less_than_20_sqmts), new Object[0]))) {
                this.psLessThan20ToScreen = null;
                this.psLessThan20RatingToScreen = null;
                this.psLessThan20RemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Building_is_dilapidated_or_dangerous), new Object[0]))) {
                this.buildingStatusToScreen = null;
                this.buildingStatusRatingToScreen = null;
                this.buildingStatusRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_is_in_Government_building_premises), new Object[0]))) {
                this.governmentPsToScreen = null;
                this.governmentPsRatingToScreen = null;
                this.governmentPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_located_is_an_institution_religious_place), new Object[0]))) {
                this.religiousPsToScreen = null;
                this.religiousPsRatingToScreen = null;
                this.religiousPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_in_school_college_building), new Object[0]))) {
                this.schoolPsToScreen = null;
                this.schoolPsRatingToScreen = null;
                this.schoolPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_on_ground_floor), new Object[0]))) {
                this.groundFloorPsToScreen = null;
                this.groundFloorPsRatingToScreen = null;
                this.groundFloorPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Seperate_door_for_Entry_Exit), new Object[0]))) {
                this.seperateEntryExitToScreen = null;
                this.seperateEntryExitRatingToScreen = null;
                this.seperateEntryExitRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_political_Party_Office_Situated_Within_200_meters_of_PS_premises), new Object[0]))) {
                this.politicalPartyOfficeWithin200MetersToScreen = null;
                this.politicalPartyOfficeWithin200MetersRatingToScreen = null;
                this.politicalPartyOfficeWithin200MetersRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_having_drinking_water_facility_in_the_premises), new Object[0]))) {
                this.drinkingWaterInPremisesToScreen = null;
                this.drinkingWaterInPremisesRatingToScreen = null;
                this.drinkingWaterInPremisesRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_having_Electricity_Supply), new Object[0]))) {
                this.electricitySupplyToScreen = null;
                this.electricitySupplyRatingToScreen = null;
                this.electricitySupplyRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_buildings_having_Proper_lightings_Fixtures_etc), new Object[0]))) {
                this.properLightingFixturesToScreen = null;
                this.properLightingFixturesRatingToScreen = null;
                this.properLightingFixturesRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_buildings_with_Toilet_Male_Female), new Object[0]))) {
                this.toiletMaleFemaleToScreen = null;
                this.toiletMaleFemaleRatingToScreen = null;
                this.toiletMaleFemaleRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_facility_Parking_Available), new Object[0]))) {
                this.parkingAvailableToScreen = null;
                this.parkingAvailableRatingToScreen = null;
                this.parkingAvailableRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Lighting_electricity_arrangements), new Object[0]))) {
                this.electricityArrangementToScreen = null;
                this.electricityArrangementsRatingToScreen = null;
                this.electricityArrangementsRemarksToScreen = null;
            }
        }
        if (btnValue.equals(this.notAvailableText) && btnEnableStatus.equals(this.enableText) && btnRemark.equals("")) {
            if (headerText.equals(String.format(getString(R.string.blo_Provision_for_ramp), new Object[0]))) {
                this.provisionRampToScreen = this.textForN;
                this.provisionRampRatingToScreen = null;
                this.provisionRampRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Provision_for_drinking_water), new Object[0]))) {
                this.drinkingWaterToScreen = this.textForN;
                this.drinkingWaterRatingToScreen = null;
                this.drinkingWaterRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Adequate_furniture_for_AMF), new Object[0]))) {
                this.amfAdequateFurnitureToScreen = this.textForN;
                this.amfAdequateFurnitureRatingToScreen = null;
                this.amfAdequateFurnitureRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_lightning), new Object[0]))) {
                this.lightingToScreen = this.textForN;
                this.lightingRatingToScreen = null;
                this.lightingRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Help_desk), new Object[0]))) {
                this.helpDeskToScreen = this.textForN;
                this.helpDeskRatingToScreen = null;
                this.helpDeskRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_signnage), new Object[0]))) {
                this.signnageToScreen = this.textForN;
                this.signnageRatingToScreen = null;
                this.signnageRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Toilet), new Object[0]))) {
                this.toiletToScreen = this.textForN;
                this.toiletRatingToScreen = null;
                this.toiletRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Permanent_ramp), new Object[0]))) {
                this.permanentRampToScreen = this.textForN;
                this.permanentRampRatingToScreen = null;
                this.permanentRampRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Adequate_Furniture_for_EMF), new Object[0]))) {
                this.emfAdequateFurnitureToScreen = this.textForN;
                this.emfAdequateFurnitureRatingToScreen = null;
                this.emfAdequateFurnitureRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Shade_shatter_for_protection_from_sun_rain), new Object[0]))) {
                this.shatterToScreen = this.textForN;
                this.shatterRatingToScreen = null;
                this.shatterRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_with_proper_road_connectivity), new Object[0]))) {
                this.roadConnectivityToScreen = this.textForN;
                this.roadConnectivityRatingToScreen = null;
                this.roadConnectivityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Voter_have_to_cross_river_valley_ravine_or_natural_obstacles_to_reach_PS), new Object[0]))) {
                this.crossingToScreen = this.textForN;
                this.crossingRatingToScreen = null;
                this.crossingRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Landline_telephone_fax_connection), new Object[0]))) {
                this.landlineFaxConnectionToScreen = this.textForN;
                this.landlineFaxConnectionRatingToScreen = null;
                this.landlineFaxConnectionRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Mobile_connectivity), new Object[0]))) {
                this.mobileConnectivityToScreen = this.textForN;
                this.mobileConnectivityRatingToScreen = null;
                this.mobileConnectivityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Internet_Facility), new Object[0]))) {
                this.internetFacilityToScreen = this.textForN;
                this.internetFacilityRatingToScreen = null;
                this.internetFacilityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_signage_of_building_name_and_address), new Object[0]))) {
                this.signanceToScreen = this.textForN;
                this.signanceRatingToScreen = null;
                this.signanceRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_LWE_insurgency_affected_area), new Object[0]))) {
                this.lweAffectedAreaToScreen = this.textForN;
                this.lweAffectedAreaRatingToScreen = null;
                this.lweAffectedAreaRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Forest_semi_forest_area), new Object[0]))) {
                this.forestAreaToScreen = this.textForN;
                this.forestAreaAreaRatingToScreen = null;
                this.forestAreaRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Vulnerable_critical_location), new Object[0]))) {
                this.vulnerableLocationToScreen = this.textForN;
                this.vulnerableLocationRatingToScreen = null;
                this.vulnerableLocationRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Sensitive_hyper_sensitive_PS), new Object[0]))) {
                this.sensitivePsToScreen = this.textForN;
                this.sensitivePsRatingToScreen = null;
                this.sensitivePsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Building_quality), new Object[0]))) {
                this.buildingQualityToScreen = this.textForN;
                this.buildingQualityRatingToScreen = null;
                this.buildingQualityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_with_less_than_20_sqmts), new Object[0]))) {
                this.psLessThan20ToScreen = this.textForN;
                this.psLessThan20RatingToScreen = null;
                this.psLessThan20RemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Building_is_dilapidated_or_dangerous), new Object[0]))) {
                this.buildingStatusToScreen = this.textForN;
                this.buildingStatusRatingToScreen = null;
                this.buildingStatusRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_is_in_Government_building_premises), new Object[0]))) {
                this.governmentPsToScreen = this.textForN;
                this.governmentPsRatingToScreen = null;
                this.governmentPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_located_is_an_institution_religious_place), new Object[0]))) {
                this.religiousPsToScreen = this.textForN;
                this.religiousPsRatingToScreen = null;
                this.religiousPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_in_school_college_building), new Object[0]))) {
                this.schoolPsToScreen = this.textForN;
                this.schoolPsRatingToScreen = null;
                this.schoolPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_on_ground_floor), new Object[0]))) {
                this.groundFloorPsToScreen = this.textForN;
                this.groundFloorPsRatingToScreen = null;
                this.groundFloorPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Seperate_door_for_Entry_Exit), new Object[0]))) {
                this.seperateEntryExitToScreen = this.textForN;
                this.seperateEntryExitRatingToScreen = null;
                this.seperateEntryExitRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_political_Party_Office_Situated_Within_200_meters_of_PS_premises), new Object[0]))) {
                this.politicalPartyOfficeWithin200MetersToScreen = this.textForN;
                this.politicalPartyOfficeWithin200MetersRatingToScreen = null;
                this.politicalPartyOfficeWithin200MetersRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_having_drinking_water_facility_in_the_premises), new Object[0]))) {
                this.drinkingWaterInPremisesToScreen = this.textForN;
                this.drinkingWaterInPremisesRatingToScreen = null;
                this.drinkingWaterInPremisesRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_having_Electricity_Supply), new Object[0]))) {
                this.electricitySupplyToScreen = this.textForN;
                this.electricitySupplyRatingToScreen = null;
                this.electricitySupplyRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_buildings_having_Proper_lightings_Fixtures_etc), new Object[0]))) {
                this.properLightingFixturesToScreen = this.textForN;
                this.properLightingFixturesRatingToScreen = null;
                this.properLightingFixturesRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_buildings_with_Toilet_Male_Female), new Object[0]))) {
                this.toiletMaleFemaleToScreen = this.textForN;
                this.toiletMaleFemaleRatingToScreen = null;
                this.toiletMaleFemaleRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_facility_Parking_Available), new Object[0]))) {
                this.parkingAvailableToScreen = this.textForN;
                this.parkingAvailableRatingToScreen = null;
                this.parkingAvailableRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Lighting_electricity_arrangements), new Object[0]))) {
                this.electricityArrangementToScreen = this.textForN;
                this.electricityArrangementsRatingToScreen = null;
                this.electricityArrangementsRemarksToScreen = null;
            }
        }
        if (btnValue.equals(this.availableGoodText) && btnEnableStatus.equals(this.enableText) && btnRemark.equals("")) {
            if (headerText.equals(String.format(getString(R.string.blo_Provision_for_ramp), new Object[0]))) {
                this.provisionRampToScreen = this.textForY;
                this.provisionRampRatingToScreen = this.goodText;
                this.provisionRampRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Provision_for_drinking_water), new Object[0]))) {
                this.drinkingWaterToScreen = this.textForY;
                this.drinkingWaterRatingToScreen = this.goodText;
                this.drinkingWaterRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Adequate_furniture_for_AMF), new Object[0]))) {
                this.amfAdequateFurnitureToScreen = this.textForY;
                this.amfAdequateFurnitureRatingToScreen = this.goodText;
                this.amfAdequateFurnitureRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_lightning), new Object[0]))) {
                this.lightingToScreen = this.textForY;
                this.lightingRatingToScreen = this.goodText;
                this.lightingRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Help_desk), new Object[0]))) {
                this.helpDeskToScreen = this.textForY;
                this.helpDeskRatingToScreen = this.goodText;
                this.helpDeskRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_signnage), new Object[0]))) {
                this.signnageToScreen = this.textForY;
                this.signnageRatingToScreen = this.goodText;
                this.signnageRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Toilet), new Object[0]))) {
                this.toiletToScreen = this.textForY;
                this.toiletRatingToScreen = this.goodText;
                this.toiletRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Permanent_ramp), new Object[0]))) {
                this.permanentRampToScreen = this.textForY;
                this.permanentRampRatingToScreen = this.goodText;
                this.permanentRampRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Adequate_Furniture_for_EMF), new Object[0]))) {
                this.emfAdequateFurnitureToScreen = this.textForY;
                this.emfAdequateFurnitureRatingToScreen = this.goodText;
                this.emfAdequateFurnitureRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Shade_shatter_for_protection_from_sun_rain), new Object[0]))) {
                this.shatterToScreen = this.textForY;
                this.shatterRatingToScreen = this.goodText;
                this.shatterRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_with_proper_road_connectivity), new Object[0]))) {
                this.roadConnectivityToScreen = this.textForY;
                this.roadConnectivityRatingToScreen = this.goodText;
                this.roadConnectivityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Voter_have_to_cross_river_valley_ravine_or_natural_obstacles_to_reach_PS), new Object[0]))) {
                this.crossingToScreen = this.textForY;
                this.crossingRatingToScreen = this.goodText;
                this.crossingRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Landline_telephone_fax_connection), new Object[0]))) {
                this.landlineFaxConnectionToScreen = this.textForY;
                this.landlineFaxConnectionRatingToScreen = this.goodText;
                this.landlineFaxConnectionRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Mobile_connectivity), new Object[0]))) {
                this.mobileConnectivityToScreen = this.textForY;
                this.mobileConnectivityRatingToScreen = this.goodText;
                this.mobileConnectivityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Internet_Facility), new Object[0]))) {
                this.internetFacilityToScreen = this.textForY;
                this.internetFacilityRatingToScreen = this.goodText;
                this.internetFacilityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_signage_of_building_name_and_address), new Object[0]))) {
                this.signanceToScreen = this.textForY;
                this.signanceRatingToScreen = this.goodText;
                this.signanceRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_LWE_insurgency_affected_area), new Object[0]))) {
                this.lweAffectedAreaToScreen = this.textForY;
                this.lweAffectedAreaRatingToScreen = this.goodText;
                this.lweAffectedAreaRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Forest_semi_forest_area), new Object[0]))) {
                this.forestAreaToScreen = this.textForY;
                this.forestAreaAreaRatingToScreen = this.goodText;
                this.forestAreaRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Vulnerable_critical_location), new Object[0]))) {
                this.vulnerableLocationToScreen = this.textForY;
                this.vulnerableLocationRatingToScreen = this.goodText;
                this.vulnerableLocationRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Sensitive_hyper_sensitive_PS), new Object[0]))) {
                this.sensitivePsToScreen = this.textForY;
                this.sensitivePsRatingToScreen = this.goodText;
                this.sensitivePsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Building_quality), new Object[0]))) {
                this.buildingQualityToScreen = this.textForY;
                this.buildingQualityRatingToScreen = this.goodText;
                this.buildingQualityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_with_less_than_20_sqmts), new Object[0]))) {
                this.psLessThan20ToScreen = this.textForY;
                this.psLessThan20RatingToScreen = this.goodText;
                this.psLessThan20RemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Building_is_dilapidated_or_dangerous), new Object[0]))) {
                this.buildingStatusToScreen = this.textForY;
                this.buildingStatusRatingToScreen = this.goodText;
                this.buildingStatusRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_is_in_Government_building_premises), new Object[0]))) {
                this.governmentPsToScreen = this.textForY;
                this.governmentPsRatingToScreen = this.goodText;
                this.governmentPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_located_is_an_institution_religious_place), new Object[0]))) {
                this.religiousPsToScreen = this.textForY;
                this.religiousPsRatingToScreen = this.goodText;
                this.religiousPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_in_school_college_building), new Object[0]))) {
                this.schoolPsToScreen = this.textForY;
                this.schoolPsRatingToScreen = this.goodText;
                this.schoolPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_on_ground_floor), new Object[0]))) {
                this.groundFloorPsToScreen = this.textForY;
                this.groundFloorPsRatingToScreen = this.goodText;
                this.groundFloorPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Seperate_door_for_Entry_Exit), new Object[0]))) {
                this.seperateEntryExitToScreen = this.textForY;
                this.seperateEntryExitRatingToScreen = this.goodText;
                this.seperateEntryExitRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_political_Party_Office_Situated_Within_200_meters_of_PS_premises), new Object[0]))) {
                this.politicalPartyOfficeWithin200MetersToScreen = this.textForY;
                this.politicalPartyOfficeWithin200MetersRatingToScreen = this.goodText;
                this.politicalPartyOfficeWithin200MetersRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_having_drinking_water_facility_in_the_premises), new Object[0]))) {
                this.drinkingWaterInPremisesToScreen = this.textForY;
                this.drinkingWaterInPremisesRatingToScreen = this.goodText;
                this.drinkingWaterInPremisesRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_having_Electricity_Supply), new Object[0]))) {
                this.electricitySupplyToScreen = this.textForY;
                this.electricitySupplyRatingToScreen = this.goodText;
                this.electricitySupplyRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_buildings_having_Proper_lightings_Fixtures_etc), new Object[0]))) {
                this.properLightingFixturesToScreen = this.textForY;
                this.properLightingFixturesRatingToScreen = this.goodText;
                this.properLightingFixturesRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_buildings_with_Toilet_Male_Female), new Object[0]))) {
                this.toiletMaleFemaleToScreen = this.textForY;
                this.toiletMaleFemaleRatingToScreen = this.goodText;
                this.toiletMaleFemaleRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_facility_Parking_Available), new Object[0]))) {
                this.parkingAvailableToScreen = this.textForY;
                this.parkingAvailableRatingToScreen = this.goodText;
                this.parkingAvailableRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Lighting_electricity_arrangements), new Object[0]))) {
                this.electricityArrangementToScreen = this.textForY;
                this.electricityArrangementsRatingToScreen = this.goodText;
                this.electricityArrangementsRemarksToScreen = null;
            }
        }
        if (btnValue.equals(this.availableAverageText) && btnEnableStatus.equals(this.enableText) && btnRemark.equals("")) {
            if (headerText.equals(String.format(getString(R.string.blo_Provision_for_ramp), new Object[0]))) {
                this.provisionRampToScreen = this.textForY;
                this.provisionRampRatingToScreen = this.averageText;
                this.provisionRampRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Provision_for_drinking_water), new Object[0]))) {
                this.drinkingWaterToScreen = this.textForY;
                this.drinkingWaterRatingToScreen = this.averageText;
                this.drinkingWaterRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Adequate_furniture_for_AMF), new Object[0]))) {
                this.amfAdequateFurnitureToScreen = this.textForY;
                this.amfAdequateFurnitureRatingToScreen = this.averageText;
                this.amfAdequateFurnitureRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_lightning), new Object[0]))) {
                this.lightingToScreen = this.textForY;
                this.lightingRatingToScreen = this.averageText;
                this.lightingRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Help_desk), new Object[0]))) {
                this.helpDeskToScreen = this.textForY;
                this.helpDeskRatingToScreen = this.averageText;
                this.helpDeskRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_signnage), new Object[0]))) {
                this.signnageToScreen = this.textForY;
                this.signnageRatingToScreen = this.averageText;
                this.signnageRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Toilet), new Object[0]))) {
                this.toiletToScreen = this.textForY;
                this.toiletRatingToScreen = this.averageText;
                this.toiletRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Permanent_ramp), new Object[0]))) {
                this.permanentRampToScreen = this.textForY;
                this.permanentRampRatingToScreen = this.averageText;
                this.permanentRampRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Adequate_Furniture_for_EMF), new Object[0]))) {
                this.emfAdequateFurnitureToScreen = this.textForY;
                this.emfAdequateFurnitureRatingToScreen = this.averageText;
                this.emfAdequateFurnitureRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Shade_shatter_for_protection_from_sun_rain), new Object[0]))) {
                this.shatterToScreen = this.textForY;
                this.shatterRatingToScreen = this.averageText;
                this.shatterRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_with_proper_road_connectivity), new Object[0]))) {
                this.roadConnectivityToScreen = this.textForY;
                this.roadConnectivityRatingToScreen = this.averageText;
                this.roadConnectivityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Voter_have_to_cross_river_valley_ravine_or_natural_obstacles_to_reach_PS), new Object[0]))) {
                this.crossingToScreen = this.textForY;
                this.crossingRatingToScreen = this.averageText;
                this.crossingRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Landline_telephone_fax_connection), new Object[0]))) {
                this.landlineFaxConnectionToScreen = this.textForY;
                this.landlineFaxConnectionRatingToScreen = this.averageText;
                this.landlineFaxConnectionRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Mobile_connectivity), new Object[0]))) {
                this.mobileConnectivityToScreen = this.textForY;
                this.mobileConnectivityRatingToScreen = this.averageText;
                this.mobileConnectivityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Internet_Facility), new Object[0]))) {
                this.internetFacilityToScreen = this.textForY;
                this.internetFacilityRatingToScreen = this.averageText;
                this.internetFacilityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_signage_of_building_name_and_address), new Object[0]))) {
                this.signanceToScreen = this.textForY;
                this.signanceRatingToScreen = this.averageText;
                this.signanceRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_LWE_insurgency_affected_area), new Object[0]))) {
                this.lweAffectedAreaToScreen = this.textForY;
                this.lweAffectedAreaRatingToScreen = this.averageText;
                this.lweAffectedAreaRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Forest_semi_forest_area), new Object[0]))) {
                this.forestAreaToScreen = this.textForY;
                this.forestAreaAreaRatingToScreen = this.averageText;
                this.forestAreaRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Vulnerable_critical_location), new Object[0]))) {
                this.vulnerableLocationToScreen = this.textForY;
                this.vulnerableLocationRatingToScreen = this.averageText;
                this.vulnerableLocationRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Sensitive_hyper_sensitive_PS), new Object[0]))) {
                this.sensitivePsToScreen = this.textForY;
                this.sensitivePsRatingToScreen = this.averageText;
                this.sensitivePsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Building_quality), new Object[0]))) {
                this.buildingQualityToScreen = this.textForY;
                this.buildingQualityRatingToScreen = this.averageText;
                this.buildingQualityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_with_less_than_20_sqmts), new Object[0]))) {
                this.psLessThan20ToScreen = this.textForY;
                this.psLessThan20RatingToScreen = this.averageText;
                this.psLessThan20RemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Building_is_dilapidated_or_dangerous), new Object[0]))) {
                this.buildingStatusToScreen = this.textForY;
                this.buildingStatusRatingToScreen = this.averageText;
                this.buildingStatusRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_is_in_Government_building_premises), new Object[0]))) {
                this.governmentPsToScreen = this.textForY;
                this.governmentPsRatingToScreen = this.averageText;
                this.governmentPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_located_is_an_institution_religious_place), new Object[0]))) {
                this.religiousPsToScreen = this.textForY;
                this.religiousPsRatingToScreen = this.averageText;
                this.religiousPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_in_school_college_building), new Object[0]))) {
                this.schoolPsToScreen = this.textForY;
                this.schoolPsRatingToScreen = this.averageText;
                this.schoolPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_on_ground_floor), new Object[0]))) {
                this.groundFloorPsToScreen = this.textForY;
                this.groundFloorPsRatingToScreen = this.averageText;
                this.groundFloorPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Seperate_door_for_Entry_Exit), new Object[0]))) {
                this.seperateEntryExitToScreen = this.textForY;
                this.seperateEntryExitRatingToScreen = this.averageText;
                this.seperateEntryExitRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_political_Party_Office_Situated_Within_200_meters_of_PS_premises), new Object[0]))) {
                this.politicalPartyOfficeWithin200MetersToScreen = this.textForY;
                this.politicalPartyOfficeWithin200MetersRatingToScreen = this.averageText;
                this.politicalPartyOfficeWithin200MetersRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_having_drinking_water_facility_in_the_premises), new Object[0]))) {
                this.drinkingWaterInPremisesToScreen = this.textForY;
                this.drinkingWaterInPremisesRatingToScreen = this.averageText;
                this.drinkingWaterInPremisesRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_having_Electricity_Supply), new Object[0]))) {
                this.electricitySupplyToScreen = this.textForY;
                this.electricitySupplyRatingToScreen = this.averageText;
                this.electricitySupplyRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_buildings_having_Proper_lightings_Fixtures_etc), new Object[0]))) {
                this.properLightingFixturesToScreen = this.textForY;
                this.properLightingFixturesRatingToScreen = this.averageText;
                this.properLightingFixturesRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_buildings_with_Toilet_Male_Female), new Object[0]))) {
                this.toiletMaleFemaleToScreen = this.textForY;
                this.toiletMaleFemaleRatingToScreen = this.averageText;
                this.toiletMaleFemaleRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_facility_Parking_Available), new Object[0]))) {
                this.parkingAvailableToScreen = this.textForY;
                this.parkingAvailableRatingToScreen = this.averageText;
                this.parkingAvailableRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Lighting_electricity_arrangements), new Object[0]))) {
                this.electricityArrangementToScreen = this.textForY;
                this.electricityArrangementsRatingToScreen = this.averageText;
                this.electricityArrangementsRemarksToScreen = null;
            }
        }
        if (btnValue.equals(this.availablePoorText) && btnEnableStatus.equals(this.enableText) && btnRemark.equals("")) {
            if (headerText.equals(String.format(getString(R.string.blo_Provision_for_ramp), new Object[0]))) {
                this.provisionRampToScreen = this.textForY;
                this.provisionRampRatingToScreen = this.poorText;
                this.provisionRampRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Provision_for_drinking_water), new Object[0]))) {
                this.drinkingWaterToScreen = this.textForY;
                this.drinkingWaterRatingToScreen = this.poorText;
                this.drinkingWaterRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Adequate_furniture_for_AMF), new Object[0]))) {
                this.amfAdequateFurnitureToScreen = this.textForY;
                this.amfAdequateFurnitureRatingToScreen = this.poorText;
                this.amfAdequateFurnitureRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_lightning), new Object[0]))) {
                this.lightingToScreen = this.textForY;
                this.lightingRatingToScreen = this.poorText;
                this.lightingRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Help_desk), new Object[0]))) {
                this.helpDeskToScreen = this.textForY;
                this.helpDeskRatingToScreen = this.poorText;
                this.helpDeskRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_signnage), new Object[0]))) {
                this.signnageToScreen = this.textForY;
                this.signnageRatingToScreen = this.poorText;
                this.signnageRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Toilet), new Object[0]))) {
                this.toiletToScreen = this.textForY;
                this.toiletRatingToScreen = this.poorText;
                this.toiletRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Permanent_ramp), new Object[0]))) {
                this.permanentRampToScreen = this.textForY;
                this.permanentRampRatingToScreen = this.poorText;
                this.permanentRampRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Adequate_Furniture_for_EMF), new Object[0]))) {
                this.emfAdequateFurnitureToScreen = this.textForY;
                this.emfAdequateFurnitureRatingToScreen = this.poorText;
                this.emfAdequateFurnitureRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Shade_shatter_for_protection_from_sun_rain), new Object[0]))) {
                this.shatterToScreen = this.textForY;
                this.shatterRatingToScreen = this.poorText;
                this.shatterRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_with_proper_road_connectivity), new Object[0]))) {
                this.roadConnectivityToScreen = this.textForY;
                this.roadConnectivityRatingToScreen = this.poorText;
                this.roadConnectivityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Voter_have_to_cross_river_valley_ravine_or_natural_obstacles_to_reach_PS), new Object[0]))) {
                this.crossingToScreen = this.textForY;
                this.crossingRatingToScreen = this.poorText;
                this.crossingRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Landline_telephone_fax_connection), new Object[0]))) {
                this.landlineFaxConnectionToScreen = this.textForY;
                this.landlineFaxConnectionRatingToScreen = this.poorText;
                this.landlineFaxConnectionRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Mobile_connectivity), new Object[0]))) {
                this.mobileConnectivityToScreen = this.textForY;
                this.mobileConnectivityRatingToScreen = this.poorText;
                this.mobileConnectivityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Internet_Facility), new Object[0]))) {
                this.internetFacilityToScreen = this.textForY;
                this.internetFacilityRatingToScreen = this.poorText;
                this.internetFacilityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_signage_of_building_name_and_address), new Object[0]))) {
                this.signanceToScreen = this.textForY;
                this.signanceRatingToScreen = this.poorText;
                this.signanceRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_LWE_insurgency_affected_area), new Object[0]))) {
                this.lweAffectedAreaToScreen = this.textForY;
                this.lweAffectedAreaRatingToScreen = this.poorText;
                this.lweAffectedAreaRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Forest_semi_forest_area), new Object[0]))) {
                this.forestAreaToScreen = this.textForY;
                this.forestAreaAreaRatingToScreen = this.poorText;
                this.forestAreaRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Vulnerable_critical_location), new Object[0]))) {
                this.vulnerableLocationToScreen = this.textForY;
                this.vulnerableLocationRatingToScreen = this.poorText;
                this.vulnerableLocationRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Sensitive_hyper_sensitive_PS), new Object[0]))) {
                this.sensitivePsToScreen = this.textForY;
                this.sensitivePsRatingToScreen = this.poorText;
                this.sensitivePsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Building_quality), new Object[0]))) {
                this.buildingQualityToScreen = this.textForY;
                this.buildingQualityRatingToScreen = this.poorText;
                this.buildingQualityRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_with_less_than_20_sqmts), new Object[0]))) {
                this.psLessThan20ToScreen = this.textForY;
                this.psLessThan20RatingToScreen = this.poorText;
                this.psLessThan20RemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Building_is_dilapidated_or_dangerous), new Object[0]))) {
                this.buildingStatusToScreen = this.textForY;
                this.buildingStatusRatingToScreen = this.poorText;
                this.buildingStatusRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_is_in_Government_building_premises), new Object[0]))) {
                this.governmentPsToScreen = this.textForY;
                this.governmentPsRatingToScreen = this.poorText;
                this.governmentPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_located_is_an_institution_religious_place), new Object[0]))) {
                this.religiousPsToScreen = this.textForY;
                this.religiousPsRatingToScreen = this.poorText;
                this.religiousPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_in_school_college_building), new Object[0]))) {
                this.schoolPsToScreen = this.textForY;
                this.schoolPsRatingToScreen = this.poorText;
                this.schoolPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_on_ground_floor), new Object[0]))) {
                this.groundFloorPsToScreen = this.textForY;
                this.groundFloorPsRatingToScreen = this.poorText;
                this.groundFloorPsRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Seperate_door_for_Entry_Exit), new Object[0]))) {
                this.seperateEntryExitToScreen = this.textForY;
                this.seperateEntryExitRatingToScreen = this.poorText;
                this.seperateEntryExitRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_political_Party_Office_Situated_Within_200_meters_of_PS_premises), new Object[0]))) {
                this.politicalPartyOfficeWithin200MetersToScreen = this.textForY;
                this.politicalPartyOfficeWithin200MetersRatingToScreen = this.poorText;
                this.politicalPartyOfficeWithin200MetersRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_having_drinking_water_facility_in_the_premises), new Object[0]))) {
                this.drinkingWaterInPremisesToScreen = this.textForY;
                this.drinkingWaterInPremisesRatingToScreen = this.poorText;
                this.drinkingWaterInPremisesRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_having_Electricity_Supply), new Object[0]))) {
                this.electricitySupplyToScreen = this.textForY;
                this.electricitySupplyRatingToScreen = this.poorText;
                this.electricitySupplyRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_buildings_having_Proper_lightings_Fixtures_etc), new Object[0]))) {
                this.properLightingFixturesToScreen = this.textForY;
                this.properLightingFixturesRatingToScreen = this.poorText;
                this.properLightingFixturesRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_buildings_with_Toilet_Male_Female), new Object[0]))) {
                this.toiletMaleFemaleToScreen = this.textForY;
                this.toiletMaleFemaleRatingToScreen = this.poorText;
                this.toiletMaleFemaleRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_facility_Parking_Available), new Object[0]))) {
                this.parkingAvailableToScreen = this.textForY;
                this.parkingAvailableRatingToScreen = this.poorText;
                this.parkingAvailableRemarksToScreen = null;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Lighting_electricity_arrangements), new Object[0]))) {
                this.electricityArrangementToScreen = this.textForY;
                this.electricityArrangementsRatingToScreen = this.poorText;
                this.electricityArrangementsRemarksToScreen = null;
            }
        }
        if (btnValue.equals(this.editText) && btnEnableStatus.equals(this.enableText)) {
            if (headerText.equals(String.format(getString(R.string.blo_Provision_for_ramp), new Object[0]))) {
                this.provisionRampRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Provision_for_drinking_water), new Object[0]))) {
                this.drinkingWaterRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Adequate_furniture_for_AMF), new Object[0]))) {
                this.amfAdequateFurnitureRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_lightning), new Object[0]))) {
                this.lightingRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Help_desk), new Object[0]))) {
                this.helpDeskRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_signnage), new Object[0]))) {
                this.signnageRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Toilet), new Object[0]))) {
                this.toiletRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Permanent_ramp), new Object[0]))) {
                this.permanentRampRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Adequate_Furniture_for_EMF), new Object[0]))) {
                this.emfAdequateFurnitureRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Shade_shatter_for_protection_from_sun_rain), new Object[0]))) {
                this.shatterRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_with_proper_road_connectivity), new Object[0]))) {
                this.roadConnectivityRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Voter_have_to_cross_river_valley_ravine_or_natural_obstacles_to_reach_PS), new Object[0]))) {
                this.crossingRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Landline_telephone_fax_connection), new Object[0]))) {
                this.landlineFaxConnectionRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Mobile_connectivity), new Object[0]))) {
                this.mobileConnectivityRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Internet_Facility), new Object[0]))) {
                this.internetFacilityRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Proper_signage_of_building_name_and_address), new Object[0]))) {
                this.signanceRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_LWE_insurgency_affected_area), new Object[0]))) {
                this.lweAffectedAreaRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Forest_semi_forest_area), new Object[0]))) {
                this.forestAreaRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Vulnerable_critical_location), new Object[0]))) {
                this.vulnerableLocationRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Sensitive_hyper_sensitive_PS), new Object[0]))) {
                this.sensitivePsRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Building_quality), new Object[0]))) {
                this.buildingQualityRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_with_less_than_20_sqmts), new Object[0]))) {
                this.psLessThan20RemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Building_is_dilapidated_or_dangerous), new Object[0]))) {
                this.buildingStatusRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_is_in_Government_building_premises), new Object[0]))) {
                this.governmentPsRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_located_is_an_institution_religious_place), new Object[0]))) {
                this.religiousPsRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_in_school_college_building), new Object[0]))) {
                this.schoolPsRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_on_ground_floor), new Object[0]))) {
                this.groundFloorPsRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Seperate_door_for_Entry_Exit), new Object[0]))) {
                this.seperateEntryExitRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_political_Party_Office_Situated_Within_200_meters_of_PS_premises), new Object[0]))) {
                this.politicalPartyOfficeWithin200MetersRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_having_drinking_water_facility_in_the_premises), new Object[0]))) {
                this.drinkingWaterInPremisesRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_having_Electricity_Supply), new Object[0]))) {
                this.electricitySupplyRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_buildings_having_Proper_lightings_Fixtures_etc), new Object[0]))) {
                this.properLightingFixturesRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_PS_buildings_with_Toilet_Male_Female), new Object[0]))) {
                this.toiletMaleFemaleRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_facility_Parking_Available), new Object[0]))) {
                this.parkingAvailableRemarksToScreen = btnRemark;
            }
            if (headerText.equals(String.format(getString(R.string.blo_Lighting_electricity_arrangements), new Object[0]))) {
                this.electricityArrangementsRemarksToScreen = btnRemark;
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults[0] == 0) {
            if (isGPSEnabled()) {
                getCurrentLocation();
            } else {
                turnOnGPS();
            }
        }
    }

    private void selectImage() {
        final CharSequence[] charSequenceArr = {this.takePhotoText, this.cancelText};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(this.addPhotoText);
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda20
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$selectImage$21(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectImage$21(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.takePhotoText)) {
            this.cameraLauncher.launch(new Intent("android.media.action.IMAGE_CAPTURE"));
        } else if (charSequenceArr[i].equals(this.cancelText)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showdialog2(String title) {
        android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(getContext()).setMessage(title).setPositiveButton(this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda26
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog2$22(dialogInterface, i);
            }
        }).create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialog2$22(DialogInterface dialogInterface, int i) {
        selectImage();
        this.longitudeList.add("0.00");
        this.latitudeList.add("0.00");
        this.addressList.add(this.nullText);
    }

    private void showalertdialog(String title, String msg) {
        android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton(this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
    }

    private void showalertdialoglocal(String title, String msg) {
        android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton(this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda19
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
    }

    public void openfile() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.setType("image/*");
        this.activityResultLauncher.launch(Intent.createChooser(intent, "Choose File"));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.facilities.Facilities$9, reason: invalid class name */
    class AnonymousClass9 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass9() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloImagesBinding.inflate(Facilities.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
            ((BloImagesBinding) holder.binding).imageButton2.setImageBitmap(BitmapFactory.decodeByteArray(Facilities.this.imageList.get(position), 0, Facilities.this.imageList.get(position).length));
            ((BloImagesBinding) holder.binding).imageButton2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$9$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i, View view) {
            Facilities.this.countimg = i;
            Logger.d(Facilities.this.logTag, Facilities.this.imagetextList.get(i));
            Facilities.this.binding.titleBarprev.setVisibility(0);
            Facilities.this.binding.titleBar.setVisibility(8);
            Facilities.this.binding.personImage.setImageBitmap(BitmapFactory.decodeByteArray(Facilities.this.imageList.get(i), 0, Facilities.this.imageList.get(i).length));
            Facilities.this.binding.imageName.setText(Facilities.this.imagetextList.get(i));
            Facilities.this.binding.preview.setVisibility(0);
            Facilities.this.binding.pollingStationNameLayout.setVisibility(8);
            Facilities.this.binding.mainScrollView.setVisibility(8);
            Facilities.this.binding.leftButton.setVisibility(0);
            Facilities.this.binding.rightButton.setVisibility(0);
            Facilities.this.binding.linearLayoutForBtns.setVisibility(8);
            if (Facilities.this.countimg == 0) {
                Facilities.this.binding.leftButton.setVisibility(8);
            }
            if (Facilities.this.countimg == Facilities.this.imageList.size() - 1) {
                Facilities.this.binding.rightButton.setVisibility(8);
            }
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            if (Facilities.this.imageList.size() >= 4) {
                Facilities.this.binding.cardView2.setEnabled(false);
                Facilities.this.binding.addtext.setTextColor(Color.parseColor("#dcdcdc"));
                Facilities.this.binding.addphoto.setColorFilter(Color.parseColor("#dcdcdc"));
            }
            return Math.min(Facilities.this.imageList.size(), 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRecyclerViewAdapter() {
        this.adapter = new GenericRecyclerView(new AnonymousClass9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (isGPSEnabled()) {
                LocationServices.getFusedLocationProviderClient(getActivity()).requestLocationUpdates(this.locationRequest, new AnonymousClass10(), Looper.getMainLooper());
                return;
            } else {
                this.alertDialog1.dismiss();
                turnOnGPS();
                return;
            }
        }
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.facilities.Facilities$10, reason: invalid class name */
    class AnonymousClass10 extends LocationCallback {
        AnonymousClass10() {
        }

        public void onLocationResult(LocationResult locationResult) {
            List<Address> fromLocation;
            super.onLocationResult(locationResult);
            LocationServices.getFusedLocationProviderClient(Facilities.this.getActivity()).removeLocationUpdates(this);
            if (locationResult == null || locationResult.getLocations().size() <= 0) {
                return;
            }
            int size = locationResult.getLocations().size() - 1;
            Facilities.this.latitude = ((Location) locationResult.getLocations().get(size)).getLatitude();
            Facilities.this.longitude = ((Location) locationResult.getLocations().get(size)).getLongitude();
            try {
                fromLocation = new Geocoder(Facilities.this.getActivity(), Locale.getDefault()).getFromLocation(Facilities.this.latitude, Facilities.this.longitude, 1);
            } catch (IOException e) {
                Logger.d(Facilities.this.logTag, e.getMessage());
                fromLocation = null;
            }
            if (fromLocation == null || fromLocation.size() <= 0) {
                Facilities.this.showdialog2("Your GPS Coordinates can not be captured please confirm.");
            } else {
                Facilities.this.address = fromLocation.get(0).getAddressLine(0);
                Facilities.this.longitude = fromLocation.get(0).getLongitude();
                Facilities.this.latitude = fromLocation.get(0).getLatitude();
                Facilities.this.street = fromLocation.get(0).getLocality();
                if (Facilities.this.address == null) {
                    Facilities.this.showdialog2("Your GPS Coordinates can not be captured please confirm.");
                } else {
                    Facilities.this.longitudeList.add(String.valueOf(Facilities.this.longitude));
                    Facilities.this.latitudeList.add(String.valueOf(Facilities.this.latitude));
                    Facilities.this.addressList.add(Facilities.this.address);
                    AlertDialog alertDialogCreate = new AlertDialog.Builder(Facilities.this.getContext()).setTitle("Are you at Polling Station?").setMessage("Your current location is " + Facilities.this.address).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities.10.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$10$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onLocationResult$0(dialogInterface, i);
                        }
                    }).create();
                    alertDialogCreate.setCancelable(false);
                    alertDialogCreate.setCanceledOnTouchOutside(false);
                    alertDialogCreate.show();
                }
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$10$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onLocationResult$1();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLocationResult$0(DialogInterface dialogInterface, int i) {
            Facilities.this.alertDialog.show();
            ImagePicker.with(Facilities.this).crop().compress(512).cameraOnly().start(101);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLocationResult$1() {
            Facilities.this.alertDialog1.dismiss();
        }
    }

    public void turnOnGPS() {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient(getContext()).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda25
            public final void onComplete(Task task) {
                Facilities.lambda$turnOnGPS$25(task);
            }
        });
    }

    private boolean isGPSEnabled() {
        return ((LocationManager) ((FragmentActivity) Objects.requireNonNull(requireActivity())).getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }

    public void updateFacilityDetails() {
        if (this.openActivity) {
            return;
        }
        this.pollingStationName = this.binding.pollingstationadd1.getText().toString();
        this.captureGpsAddress = this.binding.gpsadd.getText().toString();
        Logger.d(this.logTag, "---------- Facilities Details to Update at DB ----------");
        Logger.d(this.logTag, "captureGpsAddress : " + this.captureGpsAddress);
        Logger.d(this.logTag, "provisionRampToScreen : " + this.provisionRampToScreen);
        Logger.d(this.logTag, "drinkingWaterToScreen : " + this.drinkingWaterToScreen);
        Logger.d(this.logTag, "amfAdequateFurnitureToScreen : " + this.amfAdequateFurnitureToScreen);
        Logger.d(this.logTag, "lightingToScreen : " + this.lightingToScreen);
        Logger.d(this.logTag, "helpDeskToScreen : " + this.helpDeskToScreen);
        Logger.d(this.logTag, "signnageToScreen : " + this.signnageToScreen);
        Logger.d(this.logTag, "toiletToScreen : " + this.toiletToScreen);
        Logger.d(this.logTag, "permanentRampToScreen : " + this.permanentRampToScreen);
        Logger.d(this.logTag, "emfAdequateFurnitureToScreen : " + this.emfAdequateFurnitureToScreen);
        Logger.d(this.logTag, "shatterToScreen : " + this.shatterToScreen);
        Logger.d(this.logTag, "roadConnectivityToScreen : " + this.roadConnectivityToScreen);
        Logger.d(this.logTag, "crossingToScreen : " + this.crossingToScreen);
        Logger.d(this.logTag, "landlineFaxConnectionToScreen : " + this.landlineFaxConnectionToScreen);
        Logger.d(this.logTag, "mobileConnectivityToScreen : " + this.mobileConnectivityToScreen);
        Logger.d(this.logTag, "electricityArrangementToScreen : " + this.electricityArrangementToScreen);
        Logger.d(this.logTag, "internetFacilityToScreen : " + this.internetFacilityToScreen);
        Logger.d(this.logTag, "signanceToScreen : " + this.signanceToScreen);
        Logger.d(this.logTag, "lweAffectedAreaToScreen : " + this.lweAffectedAreaToScreen);
        Logger.d(this.logTag, "forestAreaToScreen : " + this.forestAreaToScreen);
        Logger.d(this.logTag, "vulnerableLocationToScreen : " + this.vulnerableLocationToScreen);
        Logger.d(this.logTag, "sensitivePsToScreen : " + this.sensitivePsToScreen);
        Logger.d(this.logTag, "buildingQualityToScreen : " + this.buildingQualityToScreen);
        Logger.d(this.logTag, "psLessThan20ToScreen : " + this.psLessThan20ToScreen);
        Logger.d(this.logTag, "buildingStatusToScreen : " + this.buildingStatusToScreen);
        Logger.d(this.logTag, "governmentPsToScreen : " + this.governmentPsToScreen);
        Logger.d(this.logTag, "religiousPsToScreen : " + this.religiousPsToScreen);
        Logger.d(this.logTag, "schoolPsToScreen : " + this.schoolPsToScreen);
        Logger.d(this.logTag, "groundFloorPsToScreen : " + this.groundFloorPsToScreen);
        Logger.d(this.logTag, "seperateEntryExitToScreen : " + this.seperateEntryExitToScreen);
        Logger.d(this.logTag, "---------- Facilities Remarks ----------");
        Logger.d(this.logTag, "provisionRampRemarksToScreen : " + this.provisionRampRemarksToScreen);
        Logger.d(this.logTag, "drinkingWaterRemarksToScreen : " + this.drinkingWaterRemarksToScreen);
        Logger.d(this.logTag, "amfAdequateFurnitureRemarksToScreen : " + this.amfAdequateFurnitureRemarksToScreen);
        Logger.d(this.logTag, "lightingRemarksToScreen : " + this.lightingRemarksToScreen);
        Logger.d(this.logTag, "helpDeskRemarksToScreen : " + this.helpDeskRemarksToScreen);
        Logger.d(this.logTag, "signnageRemarksToScreen : " + this.signnageRemarksToScreen);
        Logger.d(this.logTag, "toiletRemarksToScreen : " + this.toiletRemarksToScreen);
        Logger.d(this.logTag, "permanentRampRemarksToScreen : " + this.permanentRampRemarksToScreen);
        Logger.d(this.logTag, "emfAdequateFurnitureRemarksToScreen : " + this.emfAdequateFurnitureRemarksToScreen);
        Logger.d(this.logTag, "shatterRemarksToScreen : " + this.shatterRemarksToScreen);
        Logger.d(this.logTag, "roadConnectivityRemarksToScreen : " + this.roadConnectivityRemarksToScreen);
        Logger.d(this.logTag, "crossingRemarksToScreen : " + this.crossingRemarksToScreen);
        Logger.d(this.logTag, "landlineFaxConnectionRemarksToScreen : " + this.landlineFaxConnectionRemarksToScreen);
        Logger.d(this.logTag, "mobileConnectivityRemarksToScreen : " + this.mobileConnectivityRemarksToScreen);
        Logger.d(this.logTag, "electricityArrangementsRemarksToScreen : " + this.electricityArrangementsRemarksToScreen);
        Logger.d(this.logTag, "internetFacilityRemarksToScreen : " + this.internetFacilityRemarksToScreen);
        Logger.d(this.logTag, "signanceRemarksToScreen : " + this.signanceRemarksToScreen);
        Logger.d(this.logTag, "lweAffectedAreaRemarksToScreen : " + this.lweAffectedAreaRemarksToScreen);
        Logger.d(this.logTag, "forestAreaRemarksToScreen : " + this.forestAreaRemarksToScreen);
        Logger.d(this.logTag, "vulnerableLocationRemarksToScreen : " + this.vulnerableLocationRemarksToScreen);
        Logger.d(this.logTag, "sensitivePsRemarksToScreen : " + this.sensitivePsRemarksToScreen);
        Logger.d(this.logTag, "buildingQualityRemarksToScreen : " + this.buildingQualityRemarksToScreen);
        Logger.d(this.logTag, "psLessThan20RemarksToScreen : " + this.psLessThan20RemarksToScreen);
        Logger.d(this.logTag, "buildingStatusRemarksToScreen : " + this.buildingStatusRemarksToScreen);
        Logger.d(this.logTag, "governmentPsRemarksToScreen : " + this.governmentPsRemarksToScreen);
        Logger.d(this.logTag, "religiousPsRemarksToScreen : " + this.religiousPsRemarksToScreen);
        Logger.d(this.logTag, "schoolPsRemarksToScreen : " + this.schoolPsRemarksToScreen);
        Logger.d(this.logTag, "groundFloorPsRemarksToScreen : " + this.groundFloorPsRemarksToScreen);
        Logger.d(this.logTag, "seperateEntryExitRemarksToScreen : " + this.seperateEntryExitRemarksToScreen);
        Logger.d(this.logTag, "---------- Facilities AMF or EMF Status ----------");
        Logger.d(this.logTag, "provisionRampAmfEmfStatusToScreen : " + this.provisionRampAmfEmfStatusToScreen);
        Logger.d(this.logTag, "drinkingWaterAmfEmfStatusToScreen : " + this.drinkingWaterAmfEmfStatusToScreen);
        Logger.d(this.logTag, "amfAdequateFurnitureAmfEmfStatusToScreen : " + this.amfAdequateFurnitureAmfEmfStatusToScreen);
        Logger.d(this.logTag, "lightingAmfEmfStatusToScreen : " + this.lightingAmfEmfStatusToScreen);
        Logger.d(this.logTag, "helpDeskAmfEmfStatusToScreen : " + this.helpDeskAmfEmfStatusToScreen);
        Logger.d(this.logTag, "signnageAmfEmfStatusToScreen : " + this.signnageAmfEmfStatusToScreen);
        Logger.d(this.logTag, "toiletAmfEmfStatusToScreen : " + this.toiletAmfEmfStatusToScreen);
        Logger.d(this.logTag, "permanentRampAmfEmfStatusToScreen : " + this.permanentRampAmfEmfStatusToScreen);
        Logger.d(this.logTag, "emfAdequateFurnitureAmfEmfStatusToScreen : " + this.emfAdequateFurnitureAmfEmfStatusToScreen);
        Logger.d(this.logTag, "shatterAmfEmfStatusToScreen : " + this.shatterAmfEmfStatusToScreen);
        Logger.d(this.logTag, "roadConnectivityAmfEmfStatusToScreen : " + this.roadConnectivityAmfEmfStatusToScreen);
        Logger.d(this.logTag, "crossingAmfEmfStatusToScreen : " + this.crossingAmfEmfStatusToScreen);
        Logger.d(this.logTag, "landlineFaxConnectionAmfEmfStatusToScreen : " + this.landlineFaxConnectionAmfEmfStatusToScreen);
        Logger.d(this.logTag, "mobileConnectivityAmfEmfStatusToScreen : " + this.mobileConnectivityAmfEmfStatusToScreen);
        Logger.d(this.logTag, "electricityArrangementsAmfEmfStatusToScreen : " + this.electricityArrangementsAmfEmfStatusToScreen);
        Logger.d(this.logTag, "internetFacilityAmfEmfStatusToScreen : " + this.internetFacilityAmfEmfStatusToScreen);
        Logger.d(this.logTag, "signanceAmfEmfStatusToScreen : " + this.signanceAmfEmfStatusToScreen);
        Logger.d(this.logTag, "lweAffectedAreaAmfEmfStatusToScreen : " + this.lweAffectedAreaAmfEmfStatusToScreen);
        Logger.d(this.logTag, "forestAreaAmfEmfStatusToScreen : " + this.forestAreaAmfEmfStatusToScreen);
        Logger.d(this.logTag, "vulnerableLocationAmfEmfStatusToScreen : " + this.vulnerableLocationAmfEmfStatusToScreen);
        Logger.d(this.logTag, "sensitivePsAmfEmfStatusToScreen : " + this.sensitivePsAmfEmfStatusToScreen);
        Logger.d(this.logTag, "buildingQualityAmfEmfStatusToScreen : " + this.buildingQualityAmfEmfStatusToScreen);
        Logger.d(this.logTag, "psLessThan20AmfEmfStatusToScreen : " + this.psLessThan20AmfEmfStatusToScreen);
        Logger.d(this.logTag, "buildingStatusAmfEmfStatusToScreen : " + this.buildingStatusAmfEmfStatusToScreen);
        Logger.d(this.logTag, "governmentPsAmfEmfStatusToScreen : " + this.governmentPsAmfEmfStatusToScreen);
        Logger.d(this.logTag, "religiousPsAmfEmfStatusToScreen : " + this.religiousPsAmfEmfStatusToScreen);
        Logger.d(this.logTag, "schoolPsAmfEmfStatusToScreen : " + this.schoolPsAmfEmfStatusToScreen);
        Logger.d(this.logTag, "groundFloorPsAmfEmfStatusToScreen : " + this.groundFloorPsAmfEmfStatusToScreen);
        Logger.d(this.logTag, "seperateEntryExitAmfEmfStatusToScreen : " + this.seperateEntryExitAmfEmfStatusToScreen);
        Logger.d(this.logTag, "---------- Facilities Ratings ----------");
        Logger.d(this.logTag, "provisionRampRatingToScreen : " + this.provisionRampRatingToScreen);
        Logger.d(this.logTag, "drinkingWaterRatingToScreen : " + this.drinkingWaterRatingToScreen);
        Logger.d(this.logTag, "amfAdequateFurnitureRatingToScreen : " + this.amfAdequateFurnitureRatingToScreen);
        Logger.d(this.logTag, "lightingRatingToScreen : " + this.lightingRatingToScreen);
        Logger.d(this.logTag, "helpDeskRatingToScreen : " + this.helpDeskRatingToScreen);
        Logger.d(this.logTag, "signnageRatingToScreen : " + this.signnageRatingToScreen);
        Logger.d(this.logTag, "toiletRatingToScreen : " + this.toiletRatingToScreen);
        Logger.d(this.logTag, "permanentRampRatingToScreen : " + this.permanentRampRatingToScreen);
        Logger.d(this.logTag, "emfAdequateFurnitureRatingToScreen : " + this.emfAdequateFurnitureRatingToScreen);
        Logger.d(this.logTag, "shatterRatingToScreen : " + this.shatterRatingToScreen);
        Logger.d(this.logTag, "roadConnectivityRatingToScreen : " + this.roadConnectivityRatingToScreen);
        Logger.d(this.logTag, "crossingRatingToScreen : " + this.crossingRatingToScreen);
        Logger.d(this.logTag, "landlineFaxConnectionRatingToScreen : " + this.landlineFaxConnectionRatingToScreen);
        Logger.d(this.logTag, "mobileConnectivityRatingToScreen : " + this.mobileConnectivityRatingToScreen);
        Logger.d(this.logTag, "electricityArrangementsRatingToScreen : " + this.electricityArrangementsRatingToScreen);
        Logger.d(this.logTag, "internetFacilityRatingToScreen : " + this.internetFacilityRatingToScreen);
        Logger.d(this.logTag, "signanceRatingToScreen : " + this.signanceRatingToScreen);
        Logger.d(this.logTag, "lweAffectedAreaRatingToScreen : " + this.lweAffectedAreaRatingToScreen);
        Logger.d(this.logTag, "forestAreaAreaRatingToScreen : " + this.forestAreaAreaRatingToScreen);
        Logger.d(this.logTag, "vulnerableLocationRatingToScreen : " + this.vulnerableLocationRatingToScreen);
        Logger.d(this.logTag, "sensitivePsRatingToScreen : " + this.sensitivePsRatingToScreen);
        Logger.d(this.logTag, "buildingQualityRatingToScreen : " + this.buildingQualityRatingToScreen);
        Logger.d(this.logTag, "psLessThan20RatingToScreen : " + this.psLessThan20RatingToScreen);
        Logger.d(this.logTag, "buildingStatusRatingToScreen : " + this.buildingStatusRatingToScreen);
        Logger.d(this.logTag, "governmentPsRatingToScreen : " + this.governmentPsRatingToScreen);
        Logger.d(this.logTag, "religiousPsRatingToScreen : " + this.religiousPsRatingToScreen);
        Logger.d(this.logTag, "schoolPsRatingToScreen : " + this.schoolPsRatingToScreen);
        Logger.d(this.logTag, "groundFloorPsRatingToScreen : " + this.groundFloorPsRatingToScreen);
        Logger.d(this.logTag, "seperateEntryExitRatingToScreen : " + this.seperateEntryExitRatingToScreen);
        this.viewModel.updateFacilitiesData(this.stateCd, this.acNumber, this.partNumber, this.pollingStationName, this.captureGpsAddress, this.provisionRampToScreen, this.drinkingWaterToScreen, this.amfAdequateFurnitureToScreen, this.lightingToScreen, this.helpDeskToScreen, this.signnageToScreen, this.toiletToScreen, this.permanentRampToScreen, this.emfAdequateFurnitureToScreen, this.shatterToScreen, this.roadConnectivityToScreen, this.crossingToScreen, this.landlineFaxConnectionToScreen, this.mobileConnectivityToScreen, this.electricityArrangementToScreen, this.internetFacilityToScreen, this.signanceToScreen, this.lweAffectedAreaToScreen, this.forestAreaToScreen, this.vulnerableLocationToScreen, this.sensitivePsToScreen, this.buildingQualityToScreen, this.psLessThan20ToScreen, this.buildingStatusToScreen, this.governmentPsToScreen, this.religiousPsToScreen, this.schoolPsToScreen, this.groundFloorPsToScreen, this.seperateEntryExitToScreen, this.provisionRampRemarksToScreen, this.drinkingWaterRemarksToScreen, this.amfAdequateFurnitureRemarksToScreen, this.lightingRemarksToScreen, this.helpDeskRemarksToScreen, this.signnageRemarksToScreen, this.toiletRemarksToScreen, this.permanentRampRemarksToScreen, this.emfAdequateFurnitureRemarksToScreen, this.shatterRemarksToScreen, this.roadConnectivityRemarksToScreen, this.crossingRemarksToScreen, this.landlineFaxConnectionRemarksToScreen, this.mobileConnectivityRemarksToScreen, this.electricityArrangementsRemarksToScreen, this.internetFacilityRemarksToScreen, this.signanceRemarksToScreen, this.lweAffectedAreaRemarksToScreen, this.forestAreaRemarksToScreen, this.vulnerableLocationRemarksToScreen, this.sensitivePsRemarksToScreen, this.buildingQualityRemarksToScreen, this.psLessThan20RemarksToScreen, this.buildingStatusRemarksToScreen, this.governmentPsRemarksToScreen, this.religiousPsRemarksToScreen, this.schoolPsRemarksToScreen, this.groundFloorPsRemarksToScreen, this.seperateEntryExitRemarksToScreen, this.provisionRampRatingToScreen, this.drinkingWaterRatingToScreen, this.amfAdequateFurnitureRatingToScreen, this.lightingRatingToScreen, this.helpDeskRatingToScreen, this.signnageRatingToScreen, this.toiletRatingToScreen, this.permanentRampRatingToScreen, this.emfAdequateFurnitureRatingToScreen, this.shatterRatingToScreen, this.roadConnectivityRatingToScreen, this.crossingRatingToScreen, this.landlineFaxConnectionRatingToScreen, this.mobileConnectivityRatingToScreen, this.electricityArrangementsRatingToScreen, this.internetFacilityRatingToScreen, this.signanceRatingToScreen, this.lweAffectedAreaRatingToScreen, this.forestAreaAreaRatingToScreen, this.vulnerableLocationRatingToScreen, this.sensitivePsRatingToScreen, this.buildingQualityRatingToScreen, this.psLessThan20RatingToScreen, this.buildingStatusRatingToScreen, this.governmentPsRatingToScreen, this.religiousPsRatingToScreen, this.schoolPsRatingToScreen, this.groundFloorPsRatingToScreen, this.seperateEntryExitRatingToScreen);
        Logger.d(this.logTag, "address " + this.addressList);
        this.viewModel.updateImages(this.boothId, this.imageList, this.imagetextList, this.addressList, this.longitudeList, this.latitudeList);
        this.viewModel.getUpdateResponse().observe(this, new Observer<String>() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities.11
            public void onChanged(String s) {
                if (s.isEmpty()) {
                    return;
                }
                Facilities.this.response = s;
                if (Facilities.this.response.equals("Success")) {
                    Logger.d(Facilities.this.logTag, "---------- Facilities Details Updated Successfully ----------");
                    Facilities.this.openActivity = true;
                    Facilities.this.startActivity(new Intent(Facilities.this.getContext(), (Class<?>) FacilityUpdateSuccessActivity.class));
                    return;
                }
                Facilities.this.showDialog("Error !", "Failure in Updation");
                Facilities.this.openActivity = true;
                Logger.d(Facilities.this.logTag, "---------- Facilities Details : Failure in Updation ----------");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String title, String msg) {
        new AlertDialog.Builder(getContext()).setTitle(title).setMessage(msg).setPositiveButton(this.okText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [in.gov.eci.bloapp.views.fragments.facilities.Facilities$12] */
    public void saveimageapi(String deletedtext) {
        Logger.d(this.logTag, "image fetch");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(this.stateCdText, this.stateCode);
            jSONObject.put(this.acNumberText, this.asmblyNO);
            jSONObject.put(this.partNumberText, this.partNo);
            System.out.println("qewwrytyt" + this.referenceList);
            for (int i = 0; i < this.referenceList.size(); i++) {
                if (this.imagetextList.get(i).equals(this.buildingfrontview)) {
                    jSONObject.put("entranceGateImage", this.referenceList.get(i));
                    this.count11++;
                } else if (this.imagetextList.get(i).equals(this.googlemapsview)) {
                    jSONObject.put("googleMapsViewImage", this.referenceList.get(i));
                    this.count55++;
                } else if (this.imagetextList.get(i).equals(this.frontpsview)) {
                    jSONObject.put("psFrntViewImage", this.referenceList.get(i));
                    this.count66++;
                } else {
                    jSONObject.put(this.keyMapImageText, this.referenceList.get(i));
                    this.count77++;
                }
            }
            if (this.entrancebool.equals(this.textForN)) {
                jSONObject.put(this.entranceBoolvariable, this.textForN);
            } else {
                jSONObject.put(this.entranceBoolvariable, this.textForY);
            }
            if (this.googleMapsViewbool.equals(this.textForN)) {
                jSONObject.put(this.googleBoolvariable, this.textForN);
            } else {
                jSONObject.put(this.googleBoolvariable, this.textForY);
            }
            if (this.psFrntViewbool.equals(this.textForN)) {
                jSONObject.put(this.psfrontBoolVariable, this.textForN);
            } else {
                jSONObject.put(this.psfrontBoolVariable, this.textForY);
            }
            if (this.keyMapbool.equals(this.textForN)) {
                jSONObject.put(this.keyBoolvariable, this.textForN);
            } else {
                jSONObject.put(this.keyBoolvariable, this.textForY);
            }
            ((RestClient) ApiClient.getClient(getContext()).create(RestClient.class)).erofetchimage(this.tokenValue, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", this.stateCode, (Map) new Gson().fromJson(String.valueOf(jSONObject), new TypeToken<HashMap<String, Object>>() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities.12
            }.getType())).enqueue(new AnonymousClass13(deletedtext));
        } catch (JSONException e) {
            Logger.d(this.logTag, e.getMessage());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.facilities.Facilities$13, reason: invalid class name */
    class AnonymousClass13 implements Callback<JsonObject> {
        final /* synthetic */ String val$deletedtext;

        AnonymousClass13(final String val$deletedtext) {
            this.val$deletedtext = val$deletedtext;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                Logger.d(Facilities.this.logTag, "imageposted" + ((JsonObject) response.body()).get(Facilities.this.messageText));
                if (this.val$deletedtext != "deleted") {
                    Facilities.this.updateAMFEMFData();
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                Facilities.this.commonUtilClass.getRefreshToken(Facilities.this.getContext(), Facilities.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$13$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str, String str2) {
                        this.f$0.lambda$onResponse$1(i, str, str2);
                    }
                });
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Logger.d(Facilities.this.logTag, "" + response.errorBody());
                Logger.d(Facilities.this.logTag, jSONObject.optString(Facilities.this.messageText));
            } catch (Exception e) {
                Logger.d("Facility Exception", e.getMessage());
                if (response.code() == 401) {
                    Facilities.this.commonutils.showMessageWithTitleOK(Facilities.this.requireContext(), Facilities.this.alertText, Facilities.this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$13$$ExternalSyntheticLambda2
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$2(dialogInterface, i);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            Facilities.this.alertDialog.dismiss();
            Logger.d(Facilities.this.logTag, Facilities.this.getRefreshTokenText + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                Facilities.this.commonUtilClass.showMessageOK(Facilities.this.getContext(), Facilities.this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$13$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Facilities.this.tokenValue = Facilities.this.bearerText + str;
            Facilities.this.refreshToken = str2;
            SharedPref.getInstance(Facilities.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(Facilities.this.requireContext()).setToken(Facilities.this.bearerText + str);
            Facilities.this.saveimageapi("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Facilities.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Facilities.this.requireContext()).setLocaleBool(false);
            Facilities.this.startActivity(new Intent((Context) Facilities.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Facilities.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Facilities.this.getContext()).setLocaleBool(false);
            Facilities.this.startActivity(new Intent((Context) Facilities.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Facilities.this.logTag, Facilities.this.cominginfailure + t.getMessage());
        }
    }

    public void getuploadedfile(String fileName, String key) {
        Logger.d(this.logTag, "getting downloaded file");
        ((RestClient) ApiClient.getClient(getContext()).create(RestClient.class)).getdownloaded(this.tokenValue, "blo", this.bloappkey, "objectstorage", fileName).enqueue(new AnonymousClass14(key, fileName));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.facilities.Facilities$14, reason: invalid class name */
    class AnonymousClass14 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileName;
        final /* synthetic */ String val$key;

        AnonymousClass14(final String val$key, final String val$fileName) {
            this.val$key = val$key;
            this.val$fileName = val$fileName;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                JsonObject jsonObject = (JsonObject) response.body();
                jsonObject.get("file");
                Logger.d(Facilities.this.logTag, "error in image" + jsonObject.get("file"));
                byte[] bArrDecode = Base64.decode(String.valueOf(jsonObject.get("file")), 0);
                Logger.d(Facilities.this.logTag, this.val$key);
                Facilities.this.imageList.add(bArrDecode);
                if (this.val$key.contains(Facilities.this.buildingfrontview)) {
                    Facilities.this.referenceList.add(this.val$fileName);
                    Facilities.this.imagetextList.add(Facilities.this.buildingfrontview);
                } else if (this.val$key.contains(Facilities.this.googlemapsview)) {
                    Facilities.this.referenceList.add(this.val$fileName);
                    Facilities.this.imagetextList.add(Facilities.this.googlemapsview);
                } else if (this.val$key.contains(Facilities.this.frontpsview)) {
                    Facilities.this.referenceList.add(this.val$fileName);
                    Facilities.this.imagetextList.add(Facilities.this.frontpsview);
                } else {
                    Facilities.this.referenceList.add(this.val$fileName);
                    Facilities.this.imagetextList.add(Facilities.this.keymapview);
                }
                Logger.d(Facilities.this.logTag, "" + Facilities.this.imageList);
                Logger.d(Facilities.this.logTag, "" + Facilities.this.referenceList);
                Facilities.this.initRecyclerViewAdapter();
                Facilities.this.binding.images.setLayoutManager(new GridLayoutManager(Facilities.this.getContext(), 1, 0, false));
                Facilities.this.binding.images.setAdapter(Facilities.this.adapter);
                return;
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = Facilities.this.commonUtilClass;
                Context context = Facilities.this.getContext();
                String str = Facilities.this.refreshToken;
                final String str2 = this.val$fileName;
                final String str3 = this.val$key;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$14$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str4, String str5) {
                        this.f$0.lambda$onResponse$1(str2, str3, i, str4, str5);
                    }
                });
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                Logger.d(Facilities.this.logTag, "" + response.errorBody());
                Logger.d(Facilities.this.logTag, "imageerror" + jSONObject.optString(Facilities.this.messageText));
            } catch (Exception e) {
                Logger.d(Facilities.this.logTag, e.getMessage());
                if (response.code() == 401) {
                    Facilities.this.commonutils.showMessageWithTitleOK(Facilities.this.requireContext(), Facilities.this.alertText, Facilities.this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$14$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onResponse$2(dialogInterface, i);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, String str2, int i, String str3, String str4) {
            Facilities.this.alertDialog.dismiss();
            Logger.d(Facilities.this.logTag, Facilities.this.getRefreshTokenText + i + StringUtils.SPACE + str3 + StringUtils.SPACE + str4);
            if (i == 401 || i == 400) {
                Facilities.this.commonUtilClass.showMessageOK(Facilities.this.getContext(), Facilities.this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$14$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Facilities.this.tokenValue = Facilities.this.bearerText + str3;
            Facilities.this.refreshToken = str4;
            SharedPref.getInstance(Facilities.this.requireContext()).setRefreshToken(str4);
            SharedPref.getInstance(Facilities.this.requireContext()).setToken(Facilities.this.bearerText + str3);
            Facilities.this.getuploadedfile(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Facilities.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Facilities.this.requireContext()).setLocaleBool(false);
            Facilities.this.startActivity(new Intent((Context) Facilities.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Facilities.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Facilities.this.getContext()).setLocaleBool(false);
            Facilities.this.startActivity(new Intent((Context) Facilities.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Facilities.this.logTag, Facilities.this.cominginfailure + t.getMessage());
        }
    }

    public void fetchimage() {
        RestClient restClient = (RestClient) ApiClient.getClient(getContext()).create(RestClient.class);
        String str = this.tokenValue;
        String atknBnd = SharedPref.getInstance(requireContext()).getAtknBnd();
        String rtknBnd = SharedPref.getInstance(requireContext()).getRtknBnd();
        String str2 = this.stateCode;
        restClient.facilityimage(str, atknBnd, rtknBnd, "BLOAPP", "blo", str2, str2, this.asmblyNO, this.partNo).enqueue(new AnonymousClass15());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.facilities.Facilities$15, reason: invalid class name */
    class AnonymousClass15 implements Callback<JsonObject> {
        AnonymousClass15() {
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() != 200) {
                if (response.code() == 401) {
                    Facilities.this.commonUtilClass.getRefreshToken(Facilities.this.getContext(), Facilities.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$15$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str, String str2) {
                            this.f$0.lambda$onResponse$1(i, str, str2);
                        }
                    });
                    return;
                }
                Facilities.this.alertDialog.dismiss();
                try {
                    Logger.d(Facilities.this.logTag, "fetchimage else" + new JSONObject(response.errorBody().string()).optString(Facilities.this.messageText));
                    return;
                } catch (Exception e) {
                    Logger.d(Facilities.this.logTag, e.getMessage());
                    if (response.code() == 401) {
                        Facilities.this.commonutils.showMessageWithTitleOK(Facilities.this.requireContext(), Facilities.this.alertText, Facilities.this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$15$$ExternalSyntheticLambda1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.f$0.lambda$onResponse$2(dialogInterface, i);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            Logger.d(Facilities.this.logTag, "fetchimage1 " + response.code());
            try {
                JSONObject jSONObject = new JSONObject(((JsonObject) response.body()).toString());
                Logger.d(Facilities.this.logTag, "fetchimage2" + jSONObject);
                JSONObject jSONObject2 = new JSONObject(String.valueOf(jSONObject.get("payload")));
                String strValueOf = String.valueOf(jSONObject2.get("entranceGateImage"));
                String strValueOf2 = String.valueOf(jSONObject2.get("googleMapsViewImage"));
                String strValueOf3 = String.valueOf(jSONObject2.get("psFrntViewImage"));
                String strValueOf4 = String.valueOf(jSONObject2.get(Facilities.this.keyMapImageText));
                if (strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "").contains("jpg") || strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "").contains("png")) {
                    if (strValueOf.contains("::")) {
                        String strReplace = strValueOf.split("::")[0].replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("buildingrot view", strReplace);
                        Facilities facilities = Facilities.this;
                        facilities.getuploadedfile(strReplace, facilities.buildingfrontview);
                        Facilities.this.count11++;
                        Facilities.this.binding.checkBox.setEnabled(false);
                    } else {
                        String strReplace2 = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("buildingrot view", strReplace2);
                        Facilities facilities2 = Facilities.this;
                        facilities2.getuploadedfile(strReplace2, facilities2.buildingfrontview);
                        Facilities.this.count11++;
                        Facilities.this.binding.checkBox.setEnabled(false);
                    }
                }
                if (strValueOf2.replace(RegexMatcher.JSON_STRING_REGEX, "").contains("jpg") || strValueOf2.replace(RegexMatcher.JSON_STRING_REGEX, "").contains("png")) {
                    if (strValueOf2.contains("::")) {
                        String strReplace3 = strValueOf2.split("::")[0].replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("googlemapimage", strReplace3);
                        Facilities facilities3 = Facilities.this;
                        facilities3.getuploadedfile(strReplace3, facilities3.googlemapsview);
                        Facilities.this.count55++;
                        Facilities.this.binding.checkBox5.setEnabled(false);
                    } else {
                        String strReplace4 = strValueOf2.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Logger.d("googlemapimage", strReplace4);
                        Facilities facilities4 = Facilities.this;
                        facilities4.getuploadedfile(strReplace4, facilities4.googlemapsview);
                        Facilities.this.count55++;
                        Facilities.this.binding.checkBox5.setEnabled(false);
                    }
                }
                if (strValueOf3.replace(RegexMatcher.JSON_STRING_REGEX, "").contains("jpg") || strValueOf3.replace(RegexMatcher.JSON_STRING_REGEX, "").contains("png")) {
                    if (strValueOf3.contains("::")) {
                        Logger.d("psfrontimage", strValueOf3.split("::")[0].replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        String strReplace5 = strValueOf3.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Facilities facilities5 = Facilities.this;
                        facilities5.getuploadedfile(strReplace5, facilities5.frontpsview);
                        Facilities.this.count66++;
                        Facilities.this.binding.checkBox6.setEnabled(false);
                    } else {
                        Logger.d("psfrontimage", strValueOf3.replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        String strReplace6 = strValueOf3.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Facilities facilities6 = Facilities.this;
                        facilities6.getuploadedfile(strReplace6, facilities6.frontpsview);
                        Facilities.this.count66++;
                        Facilities.this.binding.checkBox6.setEnabled(false);
                    }
                }
                if (strValueOf4.replace(RegexMatcher.JSON_STRING_REGEX, "").contains("jpg") || strValueOf4.replace(RegexMatcher.JSON_STRING_REGEX, "").contains("png")) {
                    if (strValueOf4.contains("::")) {
                        Logger.d(Facilities.this.keyMapImageText, strValueOf4.split("::")[0].replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        String strReplace7 = strValueOf4.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Facilities facilities7 = Facilities.this;
                        facilities7.getuploadedfile(strReplace7, facilities7.keymapview);
                        Facilities.this.count77++;
                        Facilities.this.binding.checkBox7.setEnabled(false);
                    } else {
                        Logger.d(Facilities.this.keyMapImageText, strValueOf4.replace(RegexMatcher.JSON_STRING_REGEX, ""));
                        String strReplace8 = strValueOf4.replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Facilities facilities8 = Facilities.this;
                        facilities8.getuploadedfile(strReplace8, facilities8.keymapview);
                        Facilities.this.count77++;
                        Facilities.this.binding.checkBox7.setEnabled(false);
                    }
                    Facilities.this.fetchDataFromAMFEMFApi();
                }
                Facilities.this.alertDialog.dismiss();
            } catch (JSONException e2) {
                Logger.d(Facilities.this.logTag, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(int i, String str, String str2) {
            Facilities.this.alertDialog.dismiss();
            Logger.d(Facilities.this.logTag, Facilities.this.getRefreshTokenText + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                Facilities.this.commonUtilClass.showMessageOK(Facilities.this.getContext(), Facilities.this.sessionExpiredText, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.Facilities$15$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Facilities.this.tokenValue = Facilities.this.bearerText + str;
            Facilities.this.refreshToken = str2;
            SharedPref.getInstance(Facilities.this.requireContext()).setRefreshToken(str2);
            SharedPref.getInstance(Facilities.this.requireContext()).setToken(Facilities.this.bearerText + str);
            Facilities.this.fetchimage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Facilities.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Facilities.this.requireContext()).setLocaleBool(false);
            Facilities.this.startActivity(new Intent((Context) Facilities.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Facilities.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Facilities.this.getContext()).setLocaleBool(false);
            Facilities.this.startActivity(new Intent((Context) Facilities.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(Facilities.this.logTag, "fetchimage coming in onFailure " + t.getMessage());
            Facilities.this.alertDialog.dismiss();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == -1) {
            Logger.d(this.logTag, this.cameraText + this.insideCameraText);
            try {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    this.byteArray = byteArrayOutputStream.toByteArray();
                } catch (IOException e) {
                    Logger.d(this.logTag, e.getMessage());
                }
                try {
                    Cursor cursorQuery = getContext().getContentResolver().query(getSaveImagePath(Base64.encodeToString(this.byteArray, 0), this.imageText1), null, null, null, null);
                    if (cursorQuery.getCount() <= 0) {
                        cursorQuery.close();
                        throw new IllegalArgumentException(this.cursorEmptyText);
                    }
                    cursorQuery.moveToFirst();
                    cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                    if (this.filesize > 2048) {
                        Logger.d(this.logTag, String.valueOf(Math.round(this.filesize * 100.0d) / 100.0d));
                        showalertdialog(this.alertText, this.moreThan2MbText);
                    } else {
                        Logger.d(this.logTag, String.valueOf(Math.round(((double) (this.filesize / 1024.0f)) * 100.0d) / 100.0d));
                        this.imageList.add(this.byteArray);
                        initRecyclerViewAdapter();
                        this.binding.images.setLayoutManager(new GridLayoutManager(getContext(), 1, 0, false));
                        this.binding.images.setAdapter(this.adapter);
                        this.binding.pollingStationNameLayout.setVisibility(8);
                        this.binding.mainScrollView.setVisibility(8);
                        this.binding.linearLayoutForBtns.setVisibility(8);
                        ImageView imageView = this.binding.image;
                        byte[] bArr = this.byteArray;
                        imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                        this.binding.imglayout.setVisibility(0);
                        this.binding.homeBtnIv1.setVisibility(0);
                    }
                    this.binding.radiohead.clearCheck();
                    this.alertDialog.dismiss();
                } catch (Exception e2) {
                    Logger.d(this.logTag, e2.getMessage());
                }
            } catch (IllegalArgumentException e3) {
                Logger.d(this.logTag, e3.getMessage());
                this.alertDialog.dismiss();
            }
        } else {
            Logger.d(this.logTag, "cancel pressed");
            this.alertDialog.dismiss();
        }
    }
}
