package in.gov.eci.bloapp.views.fragments.login;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.drawable.ColorDrawable;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.databinding.BloFragmentDeviceCompatiblityBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.Utils;
import in.gov.eci.bloapp.viewmodel.DeviceCompatibilityViewModel;
import in.gov.eci.bloapp.viewmodel.OverseasDetailViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.JsonArrayCallback;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class FragmentDeviceCompatibility extends Hilt_FragmentDeviceCompatibility {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private static final String TAG = "FragmentDeviceCompatibility";
    AlertDialog alertDialog;
    String asmblyNO;
    String asmblyName;
    String asmblyNameL1;
    BloFragmentDeviceCompatiblityBinding binding;
    Bundle bundle;
    DeviceCompatibilityViewModel deviceCompatibilityViewModel;
    List<DeviceCompatibilityViewModel> deviceCompatibilityViewModelList;
    String districtCode;
    String districtName;
    String districtNameL1;
    String email;
    String familyName;
    FusedLocationProviderClient fusedLocationProviderClient;
    String givenName;
    private LocationRequest locationRequest;
    String name;
    String partName;
    String password;
    String phoneNumber;
    String refreshToken;
    String stateName;
    String totalPartNumber;
    String userName;

    @Inject
    Utils utils;
    OverseasDetailViewModel viewModel;
    CommomUtility commomUtility = new CommomUtility();
    String partLang = "";
    String langName = "";
    String stateCode = "";
    String partNo = "";
    String token = "";
    long count = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity());
        this.binding = BloFragmentDeviceCompatiblityBinding.inflate(getLayoutInflater());
        this.viewModel = (OverseasDetailViewModel) new ViewModelProvider(requireActivity()).get(OverseasDetailViewModel.class);
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility.1
            public void handleOnBackPressed() {
                if (FragmentDeviceCompatibility.this.bundle != null) {
                    FragmentDeviceCompatibility.this.getFragmentManager().popBackStack();
                    return;
                }
                FragmentDeviceCompatibility.this.startActivity(new Intent((Context) FragmentDeviceCompatibility.this.getActivity(), (Class<?>) MainActivity.class));
                FragmentDeviceCompatibility.this.getActivity().finish();
            }
        });
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        ((Window) Objects.requireNonNull(alertDialogCreate.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        this.bundle = getArguments();
        if ((!TextUtils.isEmpty(SharedPref.getInstance(requireContext()).getUserRole()) && SharedPref.getInstance(requireContext()).getUserRole().equalsIgnoreCase("blos")) || this.bundle != null) {
            this.binding.searchBtn.setVisibility(0);
        }
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.userName = SharedPref.getInstance(requireContext()).getUserName();
        this.password = SharedPref.getInstance(requireContext()).getPassword();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.districtCode = SharedPref.getInstance(requireContext()).getDistrictCode();
        this.name = SharedPref.getInstance(requireContext()).getName();
        this.phoneNumber = SharedPref.getInstance(requireContext()).getPhoneNumber();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.givenName = SharedPref.getInstance(requireContext()).getGivenName();
        this.totalPartNumber = SharedPref.getInstance(requireContext()).getTotalPartNumber();
        this.familyName = SharedPref.getInstance(requireContext()).getFamilyName();
        this.email = SharedPref.getInstance(requireContext()).getEmail();
        this.stateName = SharedPref.getInstance(requireContext()).getStateName();
        this.districtName = SharedPref.getInstance(requireContext()).getDistrictName();
        this.districtNameL1 = SharedPref.getInstance(requireContext()).getDistrictNameL1();
        this.asmblyName = SharedPref.getInstance(requireContext()).getAssemblyName();
        this.asmblyNameL1 = SharedPref.getInstance(requireContext()).getAssemblyNameL1();
        this.partName = SharedPref.getInstance(requireContext()).getPartName();
        this.langName = SharedPref.getInstance(requireContext()).getLanguageName();
        this.partLang = SharedPref.getInstance(requireContext()).getPartNumberLanguageName();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        Logger.d(TAG, "Fragment Device Compatibility");
        Logger.d(TAG, "TOKEN -- > " + this.token);
        Logger.d(TAG, "userName -- >" + this.userName);
        Logger.d(TAG, "stateCode -- > " + this.stateCode);
        Logger.d(TAG, "districtCode -- > " + this.districtCode);
        Logger.d(TAG, "name -- > " + this.name);
        Logger.d(TAG, "phoneNumber -- > " + this.phoneNumber);
        Logger.d(TAG, "asmblyNO -- > " + this.asmblyNO);
        Logger.d(TAG, "givenName -- > " + this.givenName);
        Logger.d(TAG, "totalPartNumber -- > " + this.totalPartNumber);
        Logger.d(TAG, "familyName -- > " + this.familyName);
        Logger.d(TAG, "email -- > " + this.email);
        Logger.d(TAG, "stateName -- > " + this.stateName);
        Logger.d(TAG, "districtName -- > " + this.districtName);
        Logger.d(TAG, "districtNameL1 -- > " + this.districtNameL1);
        Logger.d(TAG, "asmblyName -- > " + this.asmblyName);
        Logger.d(TAG, "asmblyNameL1 -- > " + this.asmblyNameL1);
        Logger.d(TAG, "partName -- > " + this.partName);
        Logger.d(TAG, "langName -- > " + this.langName);
        Logger.d(TAG, "partLang -- > " + this.partLang);
        Logger.d(TAG, "partNo -- > " + this.partNo);
        new Bundle().putString("userName", this.userName);
        if (TextUtils.isEmpty(SharedPref.getInstance(requireContext()).getUserRole()) || !SharedPref.getInstance(requireContext()).getUserRole().equalsIgnoreCase("blos")) {
            this.commomUtility.getSection(this.stateCode, "ANDROIDMOB", this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.asmblyNO, this.partNo, requireContext(), new JsonArrayCallback() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility$$ExternalSyntheticLambda10
                @Override // in.gov.eci.bloapp.views.fragments.JsonArrayCallback
                public final void onCallback(int i, JSONArray jSONArray) {
                    this.f$0.lambda$onCreateView$3(i, jSONArray);
                }
            });
        }
        if (ContextCompat.checkSelfPermission((Context) Objects.requireNonNull(requireContext()), "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.CAMERA"}, 50);
        }
        this.binding.searchBtn.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$7(view);
            }
        });
        this.deviceCompatibilityViewModel = (DeviceCompatibilityViewModel) new ViewModelProvider(requireActivity()).get(DeviceCompatibilityViewModel.class);
        this.deviceCompatibilityViewModelList = new ArrayList();
        LocationRequest locationRequestCreate = LocationRequest.create();
        this.locationRequest = locationRequestCreate;
        locationRequestCreate.setPriority(100);
        this.locationRequest.setInterval(5000L);
        this.locationRequest.setFastestInterval(2000L);
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity());
        if (ContextCompat.checkSelfPermission(requireActivity(), "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.CAMERA"}, 50);
        } else if (checkLocationPermission()) {
            if (ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
                Log.d(TAG, "Do nothing");
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 99);
            }
        }
        try {
            deviceComatibility();
        } catch (Exception e) {
            Logger.d(TAG, "Exception ---> " + e.getMessage());
        }
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FragmentDeviceCompatibility.this.getActivity().onBackPressed();
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(int i, JSONArray jSONArray) {
        if (i == 401) {
            this.commomUtility.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility$$ExternalSyntheticLambda0
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str, String str2) {
                    this.f$0.lambda$onCreateView$2(i2, str, str2);
                }
            });
        } else if (jSONArray != null) {
            SharedPref.getInstance(requireContext()).setSectionData(jSONArray.toString());
        } else {
            SharedPref.getInstance(requireContext()).setSectionData("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(int i, String str, String str2) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility$$ExternalSyntheticLambda7
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onCreateView$0(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commomUtility.getSection(this.stateCode, "ANDROIDMOB", this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.asmblyNO, this.partNo, requireContext(), new JsonArrayCallback() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility$$ExternalSyntheticLambda8
            @Override // in.gov.eci.bloapp.views.fragments.JsonArrayCallback
            public final void onCallback(int i2, JSONArray jSONArray) {
                this.f$0.lambda$onCreateView$1(i2, jSONArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(int i, JSONArray jSONArray) {
        if (jSONArray != null) {
            SharedPref.getInstance(requireContext()).setSectionData(jSONArray.toString());
        } else {
            SharedPref.getInstance(requireContext()).setSectionData("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$7(View view) {
        if (ContextCompat.checkSelfPermission(requireActivity(), "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.CAMERA"}, 50);
            return;
        }
        if (checkLocationPermission()) {
            if (ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
                if (isGPSEnabled()) {
                    if (isInternetConnection()) {
                        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
                        return;
                    } else {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility$$ExternalSyntheticLambda4
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onCreateView$4();
                            }
                        }, 2000L);
                        this.commomUtility.displayAlertWithTitleAndMessage(requireContext(), "Internet Error", "Internet is not connected, Try again");
                        return;
                    }
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCreateView$5();
                    }
                }, 2000L);
                turnOnGPS();
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreateView$6();
                }
            }, 2000L);
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 99);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$5() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$6() {
        this.alertDialog.dismiss();
    }

    private void deviceComatibility() throws CameraAccessException {
        this.count = this.deviceCompatibilityViewModel.dataSync();
        String str = Build.MODEL;
        String camerasMegaPixel = getCamerasMegaPixel();
        if (camerasMegaPixel.isEmpty()) {
            this.binding.camIm2.setBackgroundResource(R.drawable.blo_ic_baseline_error_24);
            this.binding.camTx2.setText("Camera Not Available");
        } else {
            this.binding.camTx2.setText(camerasMegaPixel + "MP");
            this.binding.camIm2.setBackgroundResource(R.drawable.blo_ic_baseline_check_circle_24);
        }
        if (str.isEmpty()) {
            this.binding.devicemodelIm2.setBackgroundResource(R.drawable.blo_ic_baseline_error_24);
            this.binding.devicemodelTx2.setText("Model Number Not Present");
        } else {
            this.binding.devicemodelTx2.setText(str);
            this.binding.devicemodelIm2.setBackgroundResource(R.drawable.blo_ic_baseline_check_circle_24);
        }
        String carrierName = getCarrierName();
        if (carrierName.isEmpty()) {
            this.binding.carrierTx2.setText("No Carrier Present");
            this.binding.carrierIm2.setBackgroundResource(R.drawable.blo_ic_baseline_error_24);
        } else {
            this.binding.carrierTx2.setText(carrierName);
            this.binding.carrierIm2.setBackgroundResource(R.drawable.blo_ic_baseline_check_circle_24);
        }
        if (isInternetConnection()) {
            this.binding.internetTx2.setText("Successfully Connected");
            this.binding.internetIm2.setBackgroundResource(R.drawable.blo_ic_baseline_check_circle_24);
        } else {
            this.binding.internetTx2.setText("No Internet");
            this.binding.internetIm2.setBackgroundResource(R.drawable.blo_ic_baseline_error_24);
        }
        String totalInternalMemorySize = getTotalInternalMemorySize();
        if (totalInternalMemorySize.isEmpty()) {
            this.binding.totalStorageTx2.setText("No Space Available");
            this.binding.totalStorageIm2.setBackgroundResource(R.drawable.blo_ic_baseline_error_24);
        } else {
            this.binding.totalStorageTx2.setText(totalInternalMemorySize);
            this.binding.totalStorageIm2.setBackgroundResource(R.drawable.blo_ic_baseline_check_circle_24);
        }
        String availableInternalMemorySize = getAvailableInternalMemorySize();
        if (availableInternalMemorySize.isEmpty()) {
            this.binding.storageTx2.setText("No Space Available");
            this.binding.storageIm2.setBackgroundResource(R.drawable.blo_ic_baseline_error_24);
        } else {
            this.binding.storageTx2.setText(availableInternalMemorySize);
            this.binding.storageIm2.setBackgroundResource(R.drawable.blo_ic_baseline_check_circle_24);
        }
        String ram = getRam();
        if (ram.isEmpty()) {
            this.binding.memoryTx2.setText("No RAM Available");
            this.binding.memoryIm2.setBackgroundResource(R.drawable.blo_ic_baseline_error_24);
        } else {
            this.binding.memoryTx2.setText(ram);
            this.binding.memoryIm2.setBackgroundResource(R.drawable.blo_ic_baseline_check_circle_24);
        }
        String osVersion = getOsVersion();
        if (osVersion.isEmpty()) {
            this.binding.storageTx2.setText("Android OS not available");
            this.binding.softwareIm2.setBackgroundResource(R.drawable.blo_ic_baseline_error_24);
        } else {
            this.binding.softwareTx2.setText("Android " + osVersion);
            this.binding.softwareIm2.setBackgroundResource(R.drawable.blo_ic_baseline_check_circle_24);
        }
        getCurrentLocation();
    }

    String getCarrierName() {
        return ((TelephonyManager) ((Context) Objects.requireNonNull(requireContext())).getSystemService("phone")).getNetworkOperatorName();
    }

    public boolean isInternetConnection() {
        try {
            return ((NetworkInfo) Objects.requireNonNull(((ConnectivityManager) ((Context) Objects.requireNonNull(requireContext())).getSystemService("connectivity")).getActiveNetworkInfo())).isConnectedOrConnecting();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getAvailableInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return formatSize(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
    }

    public static String getTotalInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return formatSize(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
    }

    public static String formatSize(long size) {
        String str;
        if (size >= 1024) {
            size /= 1024;
            if (size < 1024) {
                str = "KB";
            } else {
                size /= 1024;
                if (size < 1024) {
                    str = "MB";
                } else {
                    size = (size / 1024) + 1;
                    str = " GB";
                }
            }
        } else {
            str = null;
        }
        StringBuilder sb = new StringBuilder(Long.toString(size));
        for (int length = sb.length() - 3; length > 0; length -= 3) {
            sb.insert(length, ',');
        }
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    public String getRam() {
        ActivityManager activityManager = (ActivityManager) requireContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return formatSize(memoryInfo.totalMem);
    }

    public String getOsVersion() {
        String str = Build.VERSION.RELEASE;
        Log.d(TAG, "version : " + str);
        return String.valueOf(str);
    }

    public void getCurrentLocation() {
        if (ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (isGPSEnabled()) {
                this.fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility$$ExternalSyntheticLambda9
                    public final void onComplete(Task task) {
                        this.f$0.lambda$getCurrentLocation$8(task);
                    }
                });
                return;
            } else {
                turnOnGPS();
                return;
            }
        }
        this.binding.locationTx2.setText("Location not available");
        this.binding.locationIm2.setBackgroundResource(R.drawable.blo_ic_baseline_error_24);
        requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCurrentLocation$8(Task task) {
        Location location = (Location) task.getResult();
        if (location != null) {
            try {
                List<Address> fromLocation = new Geocoder(requireContext(), Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                SharedPref.getInstance(requireContext()).setCityName(fromLocation.get(0).getLocality());
                this.binding.locationTx2.setText(fromLocation.get(0).getLocality());
                this.binding.locationIm2.setBackgroundResource(R.drawable.blo_ic_baseline_check_circle_24);
            } catch (Exception e) {
                Logger.d("Content : ", e.getMessage());
            }
        }
    }

    public String getCamerasMegaPixel() throws CameraAccessException {
        CameraManager cameraManager = (CameraManager) ((FragmentActivity) Objects.requireNonNull(requireActivity())).getSystemService("camera");
        String[] cameraIdList = cameraManager.getCameraIdList();
        Logger.d("cameraIds ", Arrays.toString(cameraIdList));
        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraIdList[0]);
        return String.valueOf(calculateMegaPixel(((Size) Objects.requireNonNull((Size) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE))).getWidth(), ((Size) Objects.requireNonNull((Size) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE))).getHeight()));
    }

    public int calculateMegaPixel(float width, float height) {
        return Math.round((width * height) / 1024000.0f);
    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.ACCESS_FINE_LOCATION")) {
            new android.app.AlertDialog.Builder(requireActivity()).setTitle("Request Permission").setMessage("Kindly Allow Permission").setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$checkLocationPermission$9(dialogInterface, i);
                }
            }).create().show();
            return false;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", requireActivity().getPackageName(), null));
        startActivity(intent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkLocationPermission$9(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", requireActivity().getPackageName(), null));
        startActivity(intent);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 99 && grantResults.length > 0 && grantResults[0] == 0) {
            ContextCompat.checkSelfPermission(requireActivity(), "android.permission.ACCESS_FINE_LOCATION");
        }
    }

    private void turnOnGPS() {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(this.locationRequest);
        builderAddLocationRequest.setAlwaysShow(true);
        LocationServices.getSettingsClient((Context) Objects.requireNonNull(requireContext())).checkLocationSettings(builderAddLocationRequest.build()).addOnCompleteListener(new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility$$ExternalSyntheticLambda2
            public final void onComplete(Task task) {
                this.f$0.lambda$turnOnGPS$10(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$turnOnGPS$10(Task task) {
        try {
            Log.d(TAG, "LocationSettingsResponse ---> " + ((LocationSettingsResponse) task.getResult(ApiException.class)));
            Toast.makeText((Context) requireActivity(), (CharSequence) "GPS is already tured on", 0).show();
        } catch (ApiException e) {
            int statusCode = e.getStatusCode();
            if (statusCode != 6) {
                if (statusCode == 8502) {
                    Log.d(TAG, "Device does not have location");
                }
            } else {
                try {
                    e.startResolutionForResult(requireActivity(), 2);
                } catch (IntentSender.SendIntentException e2) {
                    Logger.d(TAG, "Exception turnOnGPS ---> " + e2.getMessage());
                }
            }
        }
    }

    private boolean isGPSEnabled() {
        return ((LocationManager) ((FragmentActivity) Objects.requireNonNull(requireActivity())).getSystemService(Constants.LOCATION)).isProviderEnabled("gps");
    }

    public String getDeviceIdd() {
        return Settings.Secure.getString(requireContext().getContentResolver(), "android_id");
    }

    public String getDeviceModel() {
        return Build.MANUFACTURER + "  " + Build.MODEL;
    }

    public String brandName() {
        return Build.BRAND;
    }

    public String currentDate() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).format(new Date());
    }

    public String determineDevice() {
        return isTablet() ? "Tablet" : "Phone";
    }

    public boolean isTablet() {
        int i = getResources().getConfiguration().screenLayout & 15;
        return i == 3 || i == 4;
    }
}
