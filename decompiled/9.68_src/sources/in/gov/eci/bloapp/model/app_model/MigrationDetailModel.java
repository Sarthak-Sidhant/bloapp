package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class MigrationDetailModel {

    @SerializedName("AADHAR_NUMBER")
    public String aadharNo;

    @SerializedName("CONSTITUENCY")
    public String acName;

    @SerializedName("DISTRICT")
    public String districtName;

    @SerializedName("EMAIL_ID")
    public String email_id;

    @SerializedName("EPIC_NUMBER")
    public String epicId;

    @SerializedName("FIRST_NAME")
    public String firstName;

    @SerializedName("CURRENT_HOUSE_NUMBER")
    public String houseNo;

    @SerializedName("LAST_NAME")
    public String lastName;

    @SerializedName("MOBILE_NUMBER")
    public String mobileNo;

    @SerializedName("CURRENT_PINCODE")
    public String pincode;

    @SerializedName("CURRENT_POSTOFFICE")
    public String postOffice;

    @SerializedName("MARK_AS_PWD")
    public String pwdStatus;

    @SerializedName("STATE")
    public String stateName;

    @SerializedName("CURRENT_STREET")
    public String street;

    @SerializedName("CURRENT_TOWN")
    public String town;

    public MigrationDetailModel(String firstName, String lastName, String epicId, String emai_id, String stateName, String districtName, String acName, String houseNo, String street, String town, String postOffice, String pincode, String aadharNo, String mobileNo, String pwdStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.epicId = epicId;
        this.email_id = emai_id;
        this.stateName = stateName;
        this.districtName = districtName;
        this.acName = acName;
        this.pwdStatus = pwdStatus;
        this.mobileNo = mobileNo;
        this.houseNo = houseNo;
        this.street = street;
        this.town = town;
        this.postOffice = postOffice;
        this.pincode = pincode;
        this.aadharNo = aadharNo;
    }

    public String getEpicId() {
        return this.epicId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail_id() {
        return this.email_id;
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public String getAcName() {
        return this.acName;
    }

    public String getPwdStatus() {
        return this.pwdStatus;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public String getHouseNo() {
        return this.houseNo;
    }

    public String getStreet() {
        return this.street;
    }

    public String getTown() {
        return this.town;
    }

    public String getPostOffice() {
        return this.postOffice;
    }

    public String getPincode() {
        return this.pincode;
    }

    public String getAadharNo() {
        return this.aadharNo;
    }
}
