package in.gov.eci.bloapp.views.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.databinding.BloActivityMapsBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {
    String address;
    String asmblyNO;
    String asmblyName;
    private BloActivityMapsBinding binding;
    Context context = this;
    String districtCode;
    String districtName;
    String langName;
    String lat;
    private double latitude;
    private LocationRequest locationRequest;
    String longi;
    private double longitude;
    private GoogleMap mMap;
    Marker marker;
    Marker marker1;
    String partAddress;
    String partLang;
    String partName;
    String partNo;
    String password;
    String stateCode;
    String stateName;
    String street;
    String tokenValue;
    String totalPartNumber;
    String userName;

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivityMapsBinding bloActivityMapsBindingInflate = BloActivityMapsBinding.inflate(getLayoutInflater());
        this.binding = bloActivityMapsBindingInflate;
        setContentView(bloActivityMapsBindingInflate.getRoot());
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(1000L);
        this.locationRequest.setFastestInterval(1000L);
        this.partAddress = String.valueOf(getIntent().getSerializableExtra("partaddress"));
        this.tokenValue = SharedPref.getInstance(this).getToken();
        this.userName = SharedPref.getInstance(this).getUserName();
        this.password = SharedPref.getInstance(this).getPassword();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        this.districtCode = SharedPref.getInstance(this).getDistrictCode();
        this.asmblyNO = SharedPref.getInstance(this).getAssemblyNumber();
        this.totalPartNumber = SharedPref.getInstance(this).getTotalPartNumber();
        this.stateName = SharedPref.getInstance(this).getStateName();
        this.districtName = SharedPref.getInstance(this).getDistrictName();
        this.asmblyName = SharedPref.getInstance(this).getAssemblyName();
        this.partName = SharedPref.getInstance(this).getPartName();
        this.langName = SharedPref.getInstance(this).getLanguageName();
        this.partLang = SharedPref.getInstance(this).getPartNumberLanguageName();
        this.partNo = SharedPref.getInstance(this).getPartNumber();
        Logger.d("Facility -> Token : ", this.tokenValue);
        getCurrentLocation();
        this.binding.submit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.MapsActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        Intent intent = new Intent((Context) this, (Class<?>) facility.class);
        intent.putExtra("address", this.street);
        eroSaveCoordinates(this.partAddress);
        intent.putExtra("latitude and longitude", this.lat + "  " + this.longi);
        Logger.d("latitude and longitude", this.lat + "  " + this.longi);
        startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [in.gov.eci.bloapp.views.activity.MapsActivity$1] */
    public void eroSaveCoordinates(String partAddress) {
        Logger.d("in house fetch..............................", partAddress);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stateCd", this.stateCode);
            jSONObject.put("acNumber", this.asmblyNO);
            jSONObject.put("partNumber", this.partNo);
            jSONObject.put("partName", "Sarvodaya Kanya Vidyalaya");
            jSONObject.put("partNameL1", "its part nameL1");
            jSONObject.put("partAddress", partAddress);
            jSONObject.put("partAddressL1", "");
            jSONObject.put("latitude", this.lat);
            jSONObject.put("longitude", this.longi);
            jSONObject.put("effective_from", "2022-08-24");
            jSONObject.put("effective_to", "2022-12-31");
            jSONObject.put("is_active", "Y");
            jSONObject.put("created_by", "RAJESH");
            jSONObject.put("created_dttm", "2022-08-24");
            Logger.d("nistha post", String.valueOf(jSONObject));
            ((RestClient) ApiClient.getClient(this).create(RestClient.class)).eroSaveCoordinates(this.tokenValue, SharedPref.getInstance(this.context).getAtknBnd(), SharedPref.getInstance(this.context).getRtknBnd(), "BLOAPP", "blo", this.stateCode, (Map) new Gson().fromJson(String.valueOf(jSONObject), new TypeToken<HashMap<String, String>>() { // from class: in.gov.eci.bloapp.views.activity.MapsActivity.1
            }.getType())).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.MapsActivity.2
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if (response.body() != null) {
                        Logger.d("message1", String.valueOf(((JsonObject) response.body()).get("message")));
                    }
                }

                public void onFailure(Call<JsonObject> call, Throwable t) {
                    Logger.d("coming in onFailure ", t.getMessage());
                }
            });
        } catch (JSONException e) {
            Logger.d("", e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        googleMap.setMapType(1);
        LatLng latLng = new LatLng(this.latitude, this.longitude);
        this.marker = this.mMap.addMarker(new MarkerOptions().position(latLng).title(this.address));
        this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.0f));
        try {
            List<Address> fromLocation = new Geocoder(this, Locale.getDefault()).getFromLocation(this.latitude, this.longitude, 1);
            if (fromLocation.isEmpty()) {
                return;
            }
            this.street = fromLocation.get(0).getAddressLine(0);
        } catch (IOException e) {
            Logger.d("", e.getMessage());
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == -1) {
            getCurrentLocation();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (isGPSEnabled()) {
                LocationServices.getFusedLocationProviderClient(this).requestLocationUpdates(this.locationRequest, new LocationCallback() { // from class: in.gov.eci.bloapp.views.activity.MapsActivity.3
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(MapsActivity.this).removeLocationUpdates(this);
                        if (locationResult == null || locationResult.getLocations().isEmpty()) {
                            return;
                        }
                        int size = locationResult.getLocations().size() - 1;
                        MapsActivity.this.latitude = ((Location) locationResult.getLocations().get(size)).getLatitude();
                        MapsActivity.this.longitude = ((Location) locationResult.getLocations().get(size)).getLongitude();
                        MapsActivity.this.lat = String.valueOf(((Location) locationResult.getLocations().get(size)).getLatitude());
                        MapsActivity.this.longi = String.valueOf(((Location) locationResult.getLocations().get(size)).getLongitude());
                        try {
                            MapsActivity.this.address = new Geocoder(MapsActivity.this, Locale.getDefault()).getFromLocation(MapsActivity.this.latitude, MapsActivity.this.longitude, 1).get(0).getAddressLine(0);
                        } catch (IOException e) {
                            Logger.d("", e.getMessage());
                        }
                        MapsActivity.this.getSupportFragmentManager().findFragmentById(R.id.map).getMapAsync(MapsActivity.this.context);
                    }
                }, Looper.getMainLooper());
                return;
            } else {
                turnOnGPS();
                return;
            }
        }
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    private void turnOnGPS() {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient(getApplicationContext()).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.activity.MapsActivity$$ExternalSyntheticLambda1
            public final void onComplete(Task task) {
                this.f$0.lambda$turnOnGPS$1(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$turnOnGPS$1(Task task) {
        try {
            Toast.makeText((Context) this, (CharSequence) "GPS is already tured on", 0).show();
        } catch (ApiException e) {
            if (e.getStatusCode() != 6) {
                return;
            }
            try {
                e.startResolutionForResult(this, 2);
            } catch (IntentSender.SendIntentException e2) {
                Logger.d("", e2.getMessage());
            }
        }
    }

    private boolean isGPSEnabled() {
        return ((LocationManager) getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMapClick(LatLng latLng) {
        Logger.d("LatLong", latLng.toString());
        this.marker.remove();
        Marker marker = this.marker1;
        if (marker != null) {
            marker.remove();
        }
        try {
            List<Address> fromLocation = new Geocoder(this, Locale.getDefault()).getFromLocation(latLng.latitude, latLng.longitude, 1);
            if (fromLocation.isEmpty()) {
                return;
            }
            this.street = fromLocation.get(0).getAddressLine(0);
            this.lat = String.valueOf(latLng.latitude);
            this.longi = String.valueOf(latLng.longitude);
            this.marker1 = this.mMap.addMarker(new MarkerOptions().position(latLng).title(this.street));
        } catch (IOException e) {
            Logger.d("", e.getMessage());
        }
    }
}
