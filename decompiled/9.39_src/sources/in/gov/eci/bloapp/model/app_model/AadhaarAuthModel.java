package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class AadhaarAuthModel {

    @SerializedName("CONSTITUENCY")
    public String acName;

    @SerializedName("DISTRICT")
    public String districtName;

    @SerializedName("EPIC_NUMBER")
    public String epicId;

    @SerializedName("FATHER_NAME")
    public String fatherName;

    @SerializedName("FIRST_NAME")
    public String firstName;

    @SerializedName("CURRENT_HOUSE_NUMBER")
    public String houseNo;

    @SerializedName("LAST_NAME")
    public String lastName;

    @SerializedName("MOBILE_NUMBER")
    public String mobileNo;

    @SerializedName("PART_NUMBER")
    public String partNo;

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

    public AadhaarAuthModel(String firstName, String lastName, String epicId, String fatherName, String stateName, String districtName, String acName, String houseNo, String street, String town, String postOffice, String pincode, String partNo, String mobileNo, String pwdStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.epicId = epicId;
        this.fatherName = fatherName;
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
        this.partNo = partNo;
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

    public String getFatherName() {
        return this.fatherName;
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

    public String getPartNo() {
        return this.partNo;
    }
}
