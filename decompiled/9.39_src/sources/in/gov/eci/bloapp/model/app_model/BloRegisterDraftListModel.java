package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class BloRegisterDraftListModel {

    @SerializedName("AADHAR_NO")
    public String aadharNo;

    @SerializedName("AC_NO")
    public String acNo;

    @SerializedName("ADDRESS")
    public String address;

    @SerializedName("ADDRESS_ATTACHMENT")
    public String addressAttachment;

    @SerializedName("AGE")
    public String age;

    @SerializedName("ALL_DETAILS_VERIFIED")
    public String allDetailsVerified;

    @SerializedName("APPLICANT_NAME")
    public String applicantName;

    @SerializedName("applicantNameRegional")
    public String applicantNameRegional;

    @SerializedName("COORDINATE")
    public String coordinate;

    @SerializedName("DATE_OF_VERIFICATION")
    public String dateOfVerification;

    @SerializedName("DISABILITY_TYPE")
    public String disabilityType;

    @SerializedName("DOB")
    public String dob;

    @SerializedName("DOB_ATTACHMENT")
    public String dobAttachment;

    @SerializedName("EMAIL")
    public String email;

    @SerializedName("EPIC_NO")
    public String epicNo;

    @SerializedName("GENDER")
    public String gender;

    @SerializedName("HOUSE_APPLICANT_FOUND")
    public String houseApplicantFound;

    @SerializedName("HOUSE_NO")
    public String houseNo;

    @SerializedName("IS_AADHAR_VERIFIED")
    public String isAadharVerified;

    @SerializedName("IS_ADDRESS_RECORD_SAME")
    public String isAddressRecordSame;

    @SerializedName("IS_DEAF")
    public String isDeaf;

    @SerializedName("IS_DOB_RECORD_SAME")
    public String isDobRecordSame;

    @SerializedName("IS_ELECTOR_RECORD_SAME")
    public String isElectorRecordSame;

    @SerializedName("IS_LOCOMOTIVE")
    public String isLocomotive;

    @SerializedName("MET_ELECTOR")
    public int isMetElector;

    @SerializedName("IS_PWD")
    public String isPwd;

    @SerializedName("IS_VISUAL")
    public String isVisual;

    @SerializedName("LOCALITY_STREET")
    public String localitySreet;

    @SerializedName("MIS_DOCUMENT")
    public String misDocument;

    @SerializedName("MOBILE_NO")
    public String mobileNo;

    @SerializedName("OTHER_DISABILITY")
    public String otherDisability;

    @SerializedName("PART_NO")
    public String partNo;

    @SerializedName("partSerialNumber")
    public String partSerialNumber;

    @SerializedName("PHONE_NUMBER_VERIFIED")
    public String phoneNumberVerified;

    @SerializedName("photo")
    public String photo;

    @SerializedName("PHOTOGRAPH_ELE_IS_CORRECT")
    public String photographEleIsCorrect;

    @SerializedName("PINCODE")
    public String pinCode;

    @SerializedName("POST_OFFICE")
    public String postOffice;

    @SerializedName("PWD_PERCENTAGE")
    public String pwdPercentage;

    @SerializedName("RELATIVE_NAME")
    public String relativeName;

    @SerializedName("relativeNameRegional")
    public String relativeNameRegional;

    @SerializedName("RELATIVE_TYPE")
    public String relativeType;

    @SerializedName("REMARKS")
    public String remarks;

    @SerializedName("RESIDING_PERIOD")
    public String residingPeriod;

    @SerializedName("sectionName")
    public String sectionName;

    @SerializedName("SECTION_NO")
    public String sectionNo;

    @SerializedName("STATE_CODE")
    public String stateCode;

    @SerializedName("VILLAGE")
    public String village;

    public BloRegisterDraftListModel(String epicNo, String applicantName, String mobileNo, String gender, String email, String aadharNo, String dob, String age, String relativeName, String relativeType, String houseNo, String village, String postOffice, String acNo, String localitySreet, String address, String pinCode, String partNo, String stateCode, String coordinate, String residingPeriod, String houseApplicantFound, String isAadharVerified, String isElectorRecordSame, String allDetailsVerified, String isAddressRecordSame, String isDobRecordSame, String photographEleIsCorrect, String disabilityType, String isVisual, String sectionNo, String isPwd, String isDeaf, String pwdPercentage, String isLocomotive, String otherDisability, int isMetElector, String phoneNumberVerified, String dateOfVerification, String addressAttachment, String dobAttachment, String misDocument, String remarks, String sectionName, String applicantNameRegional, String relativeNameRegional, String photo, String partSerialNumber) {
        this.epicNo = epicNo;
        this.applicantName = applicantName;
        this.mobileNo = mobileNo;
        this.gender = gender;
        this.email = email;
        this.aadharNo = aadharNo;
        this.dob = dob;
        this.age = age;
        this.relativeName = relativeName;
        this.relativeType = relativeType;
        this.houseNo = houseNo;
        this.village = village;
        this.postOffice = postOffice;
        this.acNo = acNo;
        this.localitySreet = localitySreet;
        this.address = address;
        this.pinCode = pinCode;
        this.partNo = partNo;
        this.stateCode = stateCode;
        this.coordinate = coordinate;
        this.residingPeriod = residingPeriod;
        this.houseApplicantFound = houseApplicantFound;
        this.isAadharVerified = isAadharVerified;
        this.isElectorRecordSame = isElectorRecordSame;
        this.allDetailsVerified = allDetailsVerified;
        this.isAddressRecordSame = isAddressRecordSame;
        this.isDobRecordSame = isDobRecordSame;
        this.photographEleIsCorrect = photographEleIsCorrect;
        this.disabilityType = disabilityType;
        this.isVisual = isVisual;
        this.sectionNo = sectionNo;
        this.isPwd = isPwd;
        this.isDeaf = isDeaf;
        this.pwdPercentage = pwdPercentage;
        this.isLocomotive = isLocomotive;
        this.otherDisability = otherDisability;
        this.isMetElector = isMetElector;
        this.phoneNumberVerified = phoneNumberVerified;
        this.dateOfVerification = dateOfVerification;
        this.addressAttachment = addressAttachment;
        this.dobAttachment = dobAttachment;
        this.misDocument = misDocument;
        this.remarks = remarks;
        this.sectionName = sectionName;
        this.applicantNameRegional = applicantNameRegional;
        this.relativeNameRegional = relativeNameRegional;
        this.photo = photo;
        this.partSerialNumber = partSerialNumber;
    }

    public String getEpicNo() {
        return this.epicNo;
    }

    public String getPartSerialNumber() {
        return this.partSerialNumber;
    }

    public String getApplicantName() {
        return this.applicantName;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public String getGender() {
        return this.gender;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAadharNo() {
        return this.aadharNo;
    }

    public String getDob() {
        return this.dob;
    }

    public String getAge() {
        return this.age;
    }

    public String getRelativeName() {
        return this.relativeName;
    }

    public String getRelativeType() {
        return this.relativeType;
    }

    public String getHouseNo() {
        return this.houseNo;
    }

    public String getVillage() {
        return this.village;
    }

    public String getPostOffice() {
        return this.postOffice;
    }

    public String getAcNo() {
        return this.acNo;
    }

    public String getLocalitySreet() {
        return this.localitySreet;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPinCode() {
        return this.pinCode;
    }

    public String getPartNo() {
        return this.partNo;
    }

    public String getStateCode() {
        return this.stateCode;
    }

    public String getCoordinate() {
        return this.coordinate;
    }

    public String getResidingPeriod() {
        return this.residingPeriod;
    }

    public String getHouseApplicantFound() {
        return this.houseApplicantFound;
    }

    public String getIsAadharVerified() {
        return this.isAadharVerified;
    }

    public String getIsElectorRecordSame() {
        return this.isElectorRecordSame;
    }

    public String getAllDetailsVerified() {
        return this.allDetailsVerified;
    }

    public String getIsAddressRecordSame() {
        return this.isAddressRecordSame;
    }

    public String getIsDobRecordSame() {
        return this.isDobRecordSame;
    }

    public String getPhotographEleIsCorrect() {
        return this.photographEleIsCorrect;
    }

    public String getDisabilityType() {
        return this.disabilityType;
    }

    public String getIsVisual() {
        return this.isVisual;
    }

    public String getSectionNo() {
        return this.sectionNo;
    }

    public String getIsPwd() {
        return this.isPwd;
    }

    public String getIsDeaf() {
        return this.isDeaf;
    }

    public String getPwdPercentage() {
        return this.pwdPercentage;
    }

    public String getIsLocomotive() {
        return this.isLocomotive;
    }

    public String getOtherDisability() {
        return this.otherDisability;
    }

    public String getDateOfVerification() {
        return this.dateOfVerification;
    }

    public int getIsMetElector() {
        return this.isMetElector;
    }

    public String getPhoneNumberVerified() {
        return this.phoneNumberVerified;
    }

    public String getAddressAttachment() {
        return this.addressAttachment;
    }

    public String getDobAttachment() {
        return this.dobAttachment;
    }

    public String getMisDocument() {
        return this.misDocument;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public String getSectionName() {
        return this.sectionName;
    }

    public String getApplicantNameRegional() {
        return this.applicantNameRegional;
    }

    public String getRelativeNameRegional() {
        return this.relativeNameRegional;
    }

    public String getPhoto() {
        return this.photo;
    }
}
