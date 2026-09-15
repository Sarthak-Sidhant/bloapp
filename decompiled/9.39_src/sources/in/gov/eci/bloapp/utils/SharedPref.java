package in.gov.eci.bloapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SharedPref {
    private static final SharedPref sharePref = new SharedPref();
    public static SharedPreferences sharedPreferences;

    public static SharedPref getInstance(Context context) {
        if (sharedPreferences == null) {
            try {
                sharedPreferences = EncryptedSharedPreferences.create(context, context.getPackageName(), getMasterKey(context), EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
            } catch (IOException | GeneralSecurityException e) {
                Logger.d("shared", e.getMessage());
            }
        }
        return sharePref;
    }

    private static MasterKey getMasterKey(Context context) {
        try {
            return new MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
        } catch (IOException e) {
            Logger.d("shared2", e.getMessage());
            return null;
        } catch (GeneralSecurityException e2) {
            Logger.d("shared1", e2.getMessage());
            return null;
        }
    }

    public void setAccessToken(String accessToken) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("accessToken", accessToken);
        editorEdit.apply();
    }

    public String getAssemblyNumber(String key) {
        return sharedPreferences.getString(key, "");
    }

    public String getAccessToken(String key) {
        return sharedPreferences.getString(key, "");
    }

    public String getRefreshToken() {
        return sharedPreferences.getString("refreshToken", "");
    }

    public void setRefreshToken(String accessToken) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("refreshToken", accessToken);
        editorEdit.apply();
    }

    public void setBloFname(String bloFname) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("userFname", bloFname);
        editorEdit.apply();
    }

    public void setBloLname(String blolname) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("userLname", blolname);
        editorEdit.apply();
    }

    public void setBloPhone(String bloPhone) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("mobileNumber", bloPhone);
        editorEdit.apply();
    }

    public String getBloFname() {
        return sharedPreferences.getString("userFname", null);
    }

    public String getBloLname() {
        return sharedPreferences.getString("userLname", null);
    }

    public String getBloPhone() {
        return sharedPreferences.getString("mobileNumber", null);
    }

    public Boolean getLoginStatus() {
        return Boolean.valueOf(sharedPreferences.getBoolean("login", false));
    }

    public void setLoginStatus(Boolean state) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean("login", state.booleanValue());
        editorEdit.apply();
    }

    public void clear() {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    public String getDistrictCode() {
        return sharedPreferences.getString("districtCode", null);
    }

    public void setDistrictCode(String districtCode) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("districtCode", districtCode);
        editorEdit.apply();
    }

    public String getPartNumber() {
        return sharedPreferences.getString("partNo", "");
    }

    public void setPartNumber(String partNumber) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("partNo", partNumber);
        editorEdit.apply();
    }

    public String getPartName() {
        return sharedPreferences.getString("partName", "");
    }

    public void setPartName(String partName) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("partName", partName);
        editorEdit.apply();
    }

    public String getAssemblyName() {
        return sharedPreferences.getString("asmblyName", "");
    }

    public void setAssemblyName(String assemblyName) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("asmblyName", assemblyName);
        editorEdit.apply();
    }

    public String getAssemblyNameL1() {
        return sharedPreferences.getString("asmblyNameL1", "");
    }

    public void setAssemblyNameL1(String assemblyName) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("asmblyNameL1", assemblyName);
        editorEdit.apply();
    }

    public String getStateName() {
        return sharedPreferences.getString("stateName", "");
    }

    public void setStateName(String stateName) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("stateName", stateName);
        editorEdit.apply();
    }

    public String getDistrictName() {
        return sharedPreferences.getString("districtName", "");
    }

    public void setDistrictName(String districtName) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("districtName", districtName);
        editorEdit.apply();
    }

    public String getDistrictNameL1() {
        return sharedPreferences.getString("districtNameL1", "");
    }

    public void setDistrictNameL1(String districtName) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("districtNameL1", districtName);
        editorEdit.apply();
    }

    public String getPartNumberLanguageName() {
        return sharedPreferences.getString("partLang", null);
    }

    public void setPartNumberLanguageName(String token) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("partLang", token);
        editorEdit.apply();
    }

    public boolean getLocaleBool() {
        return sharedPreferences.getBoolean("localeBool", false);
    }

    public void setLocaleBool(boolean token) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean("localeBool", token);
        editorEdit.apply();
    }

    public String getLanguageName() {
        return sharedPreferences.getString("langName", null);
    }

    public void setLanguageName(String token) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("langName", token);
        editorEdit.apply();
    }

    public String getStateCode() {
        return sharedPreferences.getString("stateCode", null);
    }

    public void setStateCode(String state) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("stateCode", state);
        editorEdit.apply();
    }

    public String getToken() {
        return sharedPreferences.getString("token", "");
    }

    public void setToken(String token) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("token", token);
        editorEdit.apply();
    }

    public String getEmail() {
        return sharedPreferences.getString("email", "");
    }

    public void setEmail(String email) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("email", email);
        editorEdit.apply();
    }

    public String getFamilyName() {
        return sharedPreferences.getString("familyName", "");
    }

    public void setFamilyName(String familyName) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("familyName", familyName);
        editorEdit.apply();
    }

    public String getTotalPartNumber() {
        return sharedPreferences.getString("totalPartNumber", "");
    }

    public void setTotalPartNumber(String totalPartNumber) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("totalPartNumber", totalPartNumber);
        editorEdit.apply();
    }

    public String getAssemblyNumber() {
        return sharedPreferences.getString("asmblyNO", "");
    }

    public void setAssemblyNumber(String assemblyNumber) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("asmblyNO", assemblyNumber);
        editorEdit.apply();
    }

    public String getGivenName() {
        return sharedPreferences.getString("givenName", null);
    }

    public void setGivenName(String givenName) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("givenName", givenName);
        editorEdit.apply();
    }

    public String getName() {
        return sharedPreferences.getString("name", null);
    }

    public void setName(String name) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("name", name);
        editorEdit.apply();
    }

    public String getPhoneNumber() {
        return sharedPreferences.getString("phoneNumber", null);
    }

    public void setPhoneNumber(String phoneNumber) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("phoneNumber", phoneNumber);
        editorEdit.apply();
    }

    public String getUserName() {
        return sharedPreferences.getString("userName", null);
    }

    public void setUserName(String userName) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("userName", userName);
        editorEdit.apply();
    }

    public String getPassword() {
        return sharedPreferences.getString("password", null);
    }

    public void setPassword(String password) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("password", password);
        editorEdit.apply();
    }

    public String getLastLogin() {
        return sharedPreferences.getString("lastLogin", null);
    }

    public void setLastLogin(String lastLogin) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("lastLogin", lastLogin);
        editorEdit.apply();
    }

    public Boolean getIsLoggedIn() {
        return Boolean.valueOf(sharedPreferences.getBoolean("isLoggedIn", false));
    }

    public void setIsLoggedIn(Boolean isLoggedIn) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean("isLoggedIn", isLoggedIn.booleanValue());
        editorEdit.apply();
    }

    public String getRegionalDistrictName() {
        return sharedPreferences.getString("regionalDistrictName", null);
    }

    public void setRegionalDistrictName(String password) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("regionalDistrictName", password);
        editorEdit.apply();
    }

    public String getRegionalStateName() {
        return sharedPreferences.getString("regionalStateName", null);
    }

    public void setRegionalStateName(String password) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("regionalStateName", password);
        editorEdit.apply();
    }

    public String getRegionalAssemblyName() {
        return sharedPreferences.getString("regionalAssemblyName", null);
    }

    public void setRegionalAssemblyName(String password) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("regionalAssemblyName", password);
        editorEdit.apply();
    }

    public String getChangeLanguage() {
        return sharedPreferences.getString("changeLanguage", null);
    }

    public void setChangeLanguage(String changeLanguage) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("changeLanguage", changeLanguage);
        editorEdit.apply();
    }

    public String getPreferredUsername() {
        return sharedPreferences.getString("preferredUsername", null);
    }

    public void setPreferredUsername(String preferredUsername) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("preferredUsername", preferredUsername);
        editorEdit.apply();
    }

    public String getSessionState() {
        return sharedPreferences.getString("sessionState", null);
    }

    public void setSessionState(String sessionState) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("sessionState", sessionState);
        editorEdit.apply();
    }

    public String getPartNumberLanguageName2() {
        return sharedPreferences.getString("partLang2", null);
    }

    public void setPartNumberLanguageName2(String token) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("partLang2", token);
        editorEdit.apply();
    }

    public String getLanguageName2() {
        return sharedPreferences.getString("langName2", null);
    }

    public void setLanguageName2(String token) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("langName2", token);
        editorEdit.apply();
    }

    public String getAllHousesData() {
        return sharedPreferences.getString("allhouse", "");
    }

    public void setAllHousesData(String candiDateId) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("allhouse", candiDateId);
        editorEdit.apply();
    }

    public String getSearchedAllHousesData() {
        return sharedPreferences.getString("allhouse1", "");
    }

    public void setSearchedAllHousesData(String candiDateId) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("allhouse1", candiDateId);
        editorEdit.apply();
    }

    public String getGenderData() {
        if (sharedPreferences.contains("gender")) {
            return sharedPreferences.getString("gender", null);
        }
        return "";
    }

    public void setGenderData(String gender) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("gender", gender);
        editorEdit.apply();
    }

    public String getStateData() {
        if (sharedPreferences.contains("stateNames")) {
            return sharedPreferences.getString("stateNames", null);
        }
        return "";
    }

    public void setStateData(String gender) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("stateNames", gender);
        editorEdit.apply();
    }

    public String getSectionData() {
        if (sharedPreferences.contains("section")) {
            return sharedPreferences.getString("section", null);
        }
        return "";
    }

    public void setSectionData(String gender) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("section", gender);
        editorEdit.apply();
    }

    public String getRelationData() {
        if (sharedPreferences.contains("relation")) {
            return sharedPreferences.getString("relation", null);
        }
        return "";
    }

    public void setRelationData(String gender) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("relation", gender);
        editorEdit.apply();
    }

    public String getGenderWiseElectorsCountHome() {
        if (sharedPreferences.contains("electorsCountHome")) {
            return sharedPreferences.getString("electorsCountHome", null);
        }
        return "";
    }

    public void setGenderWiseElectorsCountHome(String electorsCountHome) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("electorsCountHome", electorsCountHome);
        editorEdit.apply();
    }

    public String getDashChartData() {
        if (sharedPreferences.contains("dashChartData")) {
            return sharedPreferences.getString("dashChartData", null);
        }
        return "";
    }

    public void setDashChartData(String dashChartData) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("dashChartData", dashChartData);
        editorEdit.apply();
    }

    public int getDashChartDataResponseCode() {
        if (sharedPreferences.contains("dashChartDataResponseCode")) {
            return sharedPreferences.getInt("dashChartDataResponseCode", 0);
        }
        return 0;
    }

    public void setDashChartDataResponseCode(int dashChartDataResponseCode) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt("dashChartDataResponseCode", dashChartDataResponseCode);
        editorEdit.apply();
    }

    public int getGenderWiseElectorsCountHomeResponseCode() {
        if (sharedPreferences.contains("genderWiseElectorsCountHomeResponseCode")) {
            return sharedPreferences.getInt("genderWiseElectorsCountHomeResponseCode", 0);
        }
        return 0;
    }

    public void setGenderWiseElectorsCountHomeResponseCode(int dashChartDataResponseCode) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt("genderWiseElectorsCountHomeResponseCode", dashChartDataResponseCode);
        editorEdit.apply();
    }

    public String getDashChartDataResponseMessage() {
        if (sharedPreferences.contains("dashChartDataResponseMessage")) {
            return sharedPreferences.getString("dashChartDataResponseMessage", null);
        }
        return "";
    }

    public void setDashChartDataResponseMessage(String dashChartDataResponseMessage) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("dashChartDataResponseMessage", dashChartDataResponseMessage);
        editorEdit.apply();
    }

    public String getGenderWiseElectorsCountHomeResponseMessage() {
        if (sharedPreferences.contains("genderWiseElectorsCountHomeResponseMessage")) {
            return sharedPreferences.getString("genderWiseElectorsCountHomeResponseMessage", null);
        }
        return "";
    }

    public void setGenderWiseElectorsCountHomeResponseMessage(String genderWiseElectorsCountHomeResponseMessage) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("genderWiseElectorsCountHomeResponseMessage", genderWiseElectorsCountHomeResponseMessage);
        editorEdit.apply();
    }

    public String getLastElectorSyncDate() {
        return sharedPreferences.contains("lastElectorSyncDate") ? sharedPreferences.getString("lastElectorSyncDate", "") : "";
    }

    public void setLastElectorSyncDate(String lastElectorSyncDate) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("lastElectorSyncDate", lastElectorSyncDate);
        editorEdit.apply();
    }

    public String getLastVerifiedHouseSyncDate() {
        return sharedPreferences.contains("lastVerifiedHouseSyncDate") ? sharedPreferences.getString("lastVerifiedHouseSyncDate", "") : "";
    }

    public void setLastVerifiedHouseSyncDate(String lastVerifiedHouseSyncDate) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("lastVerifiedHouseSyncDate", lastVerifiedHouseSyncDate);
        editorEdit.apply();
    }

    public String getIsOnline() {
        return sharedPreferences.contains("isOnline") ? sharedPreferences.getString("isOnline", "") : "";
    }

    public void setIsOnline(String isOnline) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("isOnline", isOnline);
        editorEdit.apply();
    }

    public String getProfileData() {
        if (sharedPreferences.contains("profileData")) {
            return sharedPreferences.getString("profileData", null);
        }
        return "";
    }

    public void setProfileData(String gender) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("profileData", gender);
        editorEdit.apply();
    }

    public void setDobQualifyingDate(String dobQualifyingDate) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("dobQualifyingDate", dobQualifyingDate);
        editorEdit.apply();
    }

    public String getCurrentDate() {
        if (sharedPreferences.contains("currentDate")) {
            return sharedPreferences.getString("currentDate", null);
        }
        return "";
    }

    public String getDobQualifyingDate() {
        if (sharedPreferences.contains("dobQualifyingDate")) {
            return sharedPreferences.getString("dobQualifyingDate", null);
        }
        return "";
    }

    public void setCurrentDate(String gender) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("currentDate", gender);
        editorEdit.apply();
    }

    public String getApplicantEpicDeatils() {
        return sharedPreferences.getString("applicantEpicNumberDetails", "");
    }

    public void setApplicantEpicDetails(String epic) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("applicantEpicNumberDetails", epic);
        editorEdit.apply();
    }

    public String getObjecteeEpicDetails() {
        return sharedPreferences.getString("objecteeEpicNumberDetails", "");
    }

    public void setObjecteeEpicDetails(String epic) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("objecteeEpicNumberDetails", epic);
        editorEdit.apply();
    }

    public String getAtknBnd() {
        return sharedPreferences.getString("atkn_bnd", "");
    }

    public void setAtknBnd(String atkn_bnd) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("atkn_bnd", atkn_bnd);
        editorEdit.apply();
    }

    public String getRtknBnd() {
        return sharedPreferences.getString("rtkn_bnd", "");
    }

    public void setRtknBnd(String rtkn_bnd) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("rtkn_bnd", rtkn_bnd);
        editorEdit.apply();
    }

    public void setCityName(String cityName) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("cityName", cityName);
        editorEdit.apply();
    }

    public String getCityName() {
        return sharedPreferences.getString("cityName", null);
    }

    public void saveList8Name(ArrayList<String> list, String key) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(key, new JSONArray((Collection) list).toString());
        editorEdit.apply();
    }

    public void saveList8Code(ArrayList<String> list, String key) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(key, new JSONArray((Collection) list).toString());
        editorEdit.apply();
    }

    public void saveRelativeListName(ArrayList<String> list, String key) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(key, new JSONArray((Collection) list).toString());
        editorEdit.apply();
    }

    public void saveRelativeListCode(ArrayList<String> list, String key) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(key, new JSONArray((Collection) list).toString());
        editorEdit.apply();
    }

    public void saveGrandParentName(ArrayList<String> list, String key) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(key, new JSONArray((Collection) list).toString());
        editorEdit.apply();
    }

    public void savegrandParentCode(ArrayList<String> list, String key) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(key, new JSONArray((Collection) list).toString());
        editorEdit.apply();
    }

    public void saveAcListName(ArrayList<String> list, String key) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(key, new JSONArray((Collection) list).toString());
        editorEdit.apply();
    }

    public void saveAcListCode(ArrayList<String> list, String key) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(key, new JSONArray((Collection) list).toString());
        editorEdit.apply();
    }

    public ArrayList<String> getAcListName(String key) {
        String string = sharedPreferences.getString(key, null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public ArrayList<String> getAcListCode(String key) {
        String string = sharedPreferences.getString(key, null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public ArrayList<String> getList8Name(String key) {
        String string = sharedPreferences.getString(key, null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public ArrayList<String> getList8Code(String key) {
        String string = sharedPreferences.getString(key, null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public ArrayList<String> getRelativeListName(String key) {
        String string = sharedPreferences.getString(key, null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public ArrayList<String> getRelativeListCode(String key) {
        String string = sharedPreferences.getString(key, null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public ArrayList<String> getGrandParentName(String key) {
        String string = sharedPreferences.getString(key, null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public ArrayList<String> getGrandParentCode(String key) {
        String string = sharedPreferences.getString(key, null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public void setSIRLangCode(String langCode) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("langCode", langCode);
        editorEdit.apply();
    }

    public String getSIRLangCode() {
        return sharedPreferences.getString("langCode", Constants.COUNTRYNAME2_LANG);
    }

    public void setSirFlag(String flag) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("sirflag", flag);
        editorEdit.apply();
    }

    public String getSirFlag() {
        return sharedPreferences.getString("sirflag", "");
    }

    public void setlastSIRYear(String lastSIRYear) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("lastSIRYear", lastSIRYear);
        editorEdit.apply();
    }

    public String getlastSIRYear() {
        return sharedPreferences.getString("lastSIRYear", "");
    }

    public void setEpicMatchEFFlag(String epicMatchFillEF) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("epicMatchFillEF", epicMatchFillEF);
        editorEdit.apply();
    }

    public String getEpicMatchEFFlag() {
        return sharedPreferences.getString("epicMatchFillEF", "");
    }

    public void setOnlineStatusFlag(String flag) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("isOnlineSirFlag", flag);
        editorEdit.apply();
    }

    public String getOnlineStatusFlag() {
        return sharedPreferences.getString("isOnlineSirFlag", "");
    }

    public void setAutoFaceDetection(String flag) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("autoFaceDetection", flag);
        editorEdit.apply();
    }

    public String getAutoFaceDetection() {
        return sharedPreferences.getString("autoFaceDetection", "");
    }

    public void setFaceRecognitionFlag(String flag) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("faceRecognition", flag);
        editorEdit.apply();
    }

    public String getisElectorUpload() {
        return sharedPreferences.getString("isElectorUpload", "");
    }

    public void setElectorUpload(String flag) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("isElectorUpload", flag);
        editorEdit.apply();
    }

    public String getFaceRecognitionFlag() {
        return sharedPreferences.getString("faceRecognition", "");
    }

    public void setPendingElectors(String pendingElectors) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("pendingElectors", pendingElectors);
        editorEdit.apply();
    }

    public String getPendingElectors() {
        return sharedPreferences.getString("pendingElectors", "");
    }

    public void setFillEnumerationForm(String fillEnumerationForm) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("fillEnumerationForm", fillEnumerationForm);
        editorEdit.apply();
    }

    public String getFillEnumerationForm() {
        return sharedPreferences.getString("fillEnumerationForm", "");
    }

    public void setVerifyFormsFilled(String verifyFormsFilled) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("verifyFormsFilled", verifyFormsFilled);
        editorEdit.apply();
    }

    public String getVerifyFormsFilled() {
        return sharedPreferences.getString("verifyFormsFilled", "");
    }

    public void setReverifyUploadDocs(String reverifyUploadDocs) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("reverifyUploadDocs", reverifyUploadDocs);
        editorEdit.apply();
    }

    public String getReverifyUploadDocs() {
        return sharedPreferences.getString("reverifyUploadDocs", "");
    }

    public void setSentBackByEro(String sentBackByEro) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("sentBackByEro", sentBackByEro);
        editorEdit.apply();
    }

    public String getSentBackByEro() {
        return sharedPreferences.getString("sentBackByEro", "");
    }

    public void setUploadEfForUncollected(String uploadEfForUncollected) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("uploadEfForUncollected", uploadEfForUncollected);
        editorEdit.apply();
    }

    public String getUploadEfForUncollected() {
        return sharedPreferences.getString("uploadEfForUncollected", "");
    }

    public void setMarkUncollectableSentBack(String markUncollectableSentBack) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("markUncollectableSentBack", markUncollectableSentBack);
        editorEdit.apply();
    }

    public String getMarkUncollectableSentBack() {
        return sharedPreferences.getString("markUncollectableSentBack", "");
    }

    public void setAlreadyFilledFormSentBack(String alreadyFilledFormSentBack) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("alreadyFilledFormSentBack", alreadyFilledFormSentBack);
        editorEdit.apply();
    }

    public String getAlreadyFilledFormSentBack() {
        return sharedPreferences.getString("alreadyFilledFormSentBack", "");
    }

    public void setAlreadyFilledFormSentBackMarkUnButton(String alreadyFilledFormSentBackMarkUnButton) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("alreadyFilledFormSentBackMarkUnButton", alreadyFilledFormSentBackMarkUnButton);
        editorEdit.apply();
    }

    public String getAlreadyFilledFormSentBackMarkUnButton() {
        return sharedPreferences.getString("alreadyFilledFormSentBackMarkUnButton", "");
    }

    public void setViewModifiedByAEROERO(String viewModifiedByAEROERO) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("viewModifiedByAEROERO", viewModifiedByAEROERO);
        editorEdit.apply();
    }

    public String getViewModifiedByAEROERO() {
        return sharedPreferences.getString("viewModifiedByAEROERO", "");
    }

    public void setOfflineTab(String offlineTab) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("offlineTab", offlineTab);
        editorEdit.apply();
    }

    public String getEfTrackerTab() {
        return sharedPreferences.getString("efDistributionTracker", "");
    }

    public void setEfTrackerTab(String efTrackerTab) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("efDistributionTracker", efTrackerTab);
        editorEdit.apply();
    }

    public String getOfflineTab() {
        return sharedPreferences.getString("offlineTab", "");
    }

    public void setScheduleHearingTab(String scheduleHearingNotice) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("scheduleHearingNotice", scheduleHearingNotice);
        editorEdit.apply();
    }

    public String getScheduleHearingTab() {
        return sharedPreferences.getString("scheduleHearingNotice", "");
    }

    public void saveRelationListName(ArrayList<String> list, String key) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(key, new JSONArray((Collection) list).toString());
        editorEdit.apply();
    }

    public ArrayList<String> getRelationListName(String key) {
        String string = sharedPreferences.getString(key, null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public void setTrainingStatus(int sharedTrainingStatus) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt("sharedTrainingStatus", sharedTrainingStatus);
        editorEdit.apply();
    }

    public int getTrainingStatus() {
        return sharedPreferences.getInt("sharedTrainingStatus", 0);
    }

    public void setTrainingMessage(String sharedTrainingMessage) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("sharedTrainingMessage", sharedTrainingMessage);
        editorEdit.apply();
    }

    public String getTrainingMessage() {
        return sharedPreferences.getString("sharedTrainingMessage", "");
    }

    public String getEfDashBoardTab() {
        return sharedPreferences.getString("efDashBoard", "");
    }

    public void setEfDashBoardTab(String efDashBoard) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("efDashBoard", efDashBoard);
        editorEdit.apply();
    }

    public String getverifyMarkUncollectable() {
        return sharedPreferences.getString("verifyMarkUncollectable", "");
    }

    public void setverifyMarkUncollectable(String verifyMarkUncollectable) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("verifyMarkUncollectable", verifyMarkUncollectable);
        editorEdit.apply();
    }

    public String getreverifyMarkUncollectable() {
        return sharedPreferences.getString("reverifyMarkUncollectable", "");
    }

    public void setreverifyMarkUncollectable(String reverifyMarkUncollectable) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("reverifyMarkUncollectable", reverifyMarkUncollectable);
        editorEdit.apply();
    }

    public String getDeceasedElectors() {
        return sharedPreferences.getString("deceasedElectors", "");
    }

    public void setDeceasedElectors(String deceasedElectors) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("deceasedElectors", deceasedElectors);
        editorEdit.apply();
    }

    public String getElectorsAnomaly() {
        return sharedPreferences.getString("electorsAnomaly", "");
    }

    public void setElectorsAnomaly(String deceasedElectors) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("electorsAnomaly", deceasedElectors);
        editorEdit.apply();
    }

    public int getefPhotoFlag() {
        return sharedPreferences.getInt("efPhotoFlag", 0);
    }

    public void setefPhotoFlag(int deceasedElectors) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt("efPhotoFlag", deceasedElectors);
        editorEdit.apply();
    }

    public String getDuplicateVersification() {
        return sharedPreferences.getString("duplicateVerification", "");
    }

    public void setDuplicateVerification(String duplicateverification) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("duplicateVerification", duplicateverification);
        editorEdit.apply();
    }

    public String getuploadBLOMOM() {
        return sharedPreferences.getString("uploadBLOMOM", "");
    }

    public void setuploadBLOMOM(String uploadBLOMOM) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("uploadBLOMOM", uploadBLOMOM);
        editorEdit.apply();
    }

    public String getAnomaly() {
        return sharedPreferences.getString("logicalDiscrepancies", "");
    }

    public void setAnomaly(String logicaldescrip) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("logicalDiscrepancies", logicaldescrip);
        editorEdit.apply();
    }

    public String getFormCounts() {
        return sharedPreferences.getString("formsCount", "");
    }

    public void setFormCounts(String logicaldescrip) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("formsCount", logicaldescrip);
        editorEdit.apply();
    }

    public String getPseVerification() {
        return sharedPreferences.getString("pseVerification", "");
    }

    public void setPseVerification(String pseVerification) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("pseVerification", pseVerification);
        editorEdit.apply();
    }

    public String getNoMapping() {
        return sharedPreferences.getString("noMapping", "");
    }

    public void setNoMapping(String pseVerification) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("noMapping", pseVerification);
        editorEdit.apply();
    }

    public String getSelectPhoto() {
        return sharedPreferences.getString("selectPhoto", "");
    }

    public void setSelectPhoto(String pseVerification) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("selectPhoto", pseVerification);
        editorEdit.apply();
    }

    public String getdraftList() {
        return sharedPreferences.getString("draftList", "");
    }

    public void setdraftList(String draftList) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("draftList", draftList);
        editorEdit.apply();
    }

    public String getviewDocCitizen() {
        return sharedPreferences.getString("viewDocCitizen", "");
    }

    public void setviewDocCitizen(String viewDocCitizen) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("viewDocCitizen", viewDocCitizen);
        editorEdit.apply();
    }

    public int getListItemPostion(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public void setListItemPostion(int postion) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt(Constants.LISTITEM, postion);
        editorEdit.apply();
    }

    public String getepicid(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void setepicid(String postion) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("epic", postion);
        editorEdit.apply();
    }

    public String getuploadAttendence() {
        return sharedPreferences.getString("uploadAttendance", "");
    }

    public void setUploadAttendence(String viewDocCitizen) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("uploadAttendance", viewDocCitizen);
        editorEdit.apply();
    }

    public String getupdateMobile() {
        return sharedPreferences.getString("updateMobile", "");
    }

    public void setupdateMobile(String updateMobile) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("updateMobile", updateMobile);
        editorEdit.apply();
    }
}
