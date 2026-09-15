package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class PwdIndividualRequestModel {

    @SerializedName("AC")
    public String ac;

    @SerializedName("APPLICANT_NAME")
    public String applicantName;

    @SerializedName("DESCRIPTION")
    public String description;

    @SerializedName("DISTRICT")
    public String district;

    @SerializedName("EPIC_NUMBER")
    public String epicNumber;

    @SerializedName("HOUSE_NUMBER")
    public String houseNumber;

    @SerializedName("MOBILE_NUMBER")
    public String mobileNumber;

    @SerializedName("MOBILE_NUMBER_TYPE")
    public String mobileNumberType;

    @SerializedName("PINCODE")
    public String pincode;

    @SerializedName("POSTOFFICE")
    public String postOffice;

    @SerializedName("REFERENCE_NUMBER")
    public String referenceNumber;

    @SerializedName("RELATIVE_NAME")
    public String relativeName;

    @SerializedName("REQUEST_TYPE")
    public String requestType;

    @SerializedName("STATE")
    public String state;

    @SerializedName("STREET")
    public String street;

    @SerializedName("TOWN")
    public String town;

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public String getApplicantName() {
        return this.applicantName;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public String getState() {
        return this.state;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getAc() {
        return this.ac;
    }

    public String getPincode() {
        return this.pincode;
    }

    public String getRelativeName() {
        return this.relativeName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getHouseNumber() {
        return this.houseNumber;
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

    public String getMobileNumberType() {
        return this.mobileNumberType;
    }

    public PwdIndividualRequestModel(String referenceNumber, String mobileNumber, String state, String district, String ac, String pincode, String relativeName, String description, String applicantName, String requestType, String epicNumber, String houseNumber, String street, String town, String postOffice, String mobileNumberType) {
        this.referenceNumber = referenceNumber;
        this.mobileNumber = mobileNumber;
        this.state = state;
        this.district = district;
        this.ac = ac;
        this.pincode = pincode;
        this.relativeName = relativeName;
        this.description = description;
        this.applicantName = applicantName;
        this.requestType = requestType;
        this.epicNumber = epicNumber;
        this.street = street;
        this.town = town;
        this.postOffice = postOffice;
        this.mobileNumberType = mobileNumberType;
        this.houseNumber = houseNumber;
    }
}
