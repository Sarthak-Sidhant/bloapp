package in.gov.eci.bloapp.views.activity.newsir.model.formatc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class Content implements Parcelable {
    public static final Parcelable.Creator<Content> CREATOR = new Parcelable.Creator<Content>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.formatc.Content.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Content createFromParcel(Parcel in2) {
            return new Content(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Content[] newArray(int size) {
            return new Content[size];
        }
    };
    private int acNo;
    private String age;
    private String applicantName;
    private String applicantSignature;
    private String applicantStatus;
    private String bloComments;
    private String bloSignature;
    private String correctedName;
    private String createdBy;
    private String createdDTTM;
    private String dob;
    private String electorName;
    private String epicID;
    private String epicNo;
    private String eroRemarks;
    private String fieldVerificationAbsent;
    private String fieldVerificationAlreadyEnrolled;
    private String fieldVerificationDead;
    private String fieldVerificationNoSuchPerson;
    private String fieldVerificationNotIndianCitizen;
    private String fieldVerificationPersonPresent;
    private String fieldVerificationShifted;
    private String fieldVerificationUnderAge;
    private String formRefNo;
    private String formType;
    private String fvrRemarks;
    private String gender;
    private String hasDataEntryError;
    private String hasObjected;
    private String houseNo;
    private int id;
    private String isAddressVerified;
    private String isAgeVerified;
    private String isDOBVerified;
    private String isDetailsCorrect;
    private String isGenderVerified;
    private String isMobileVerified;
    private String isNameVerified;
    private String isRelationVerified;
    private String isRelativeVerified;
    private String isphotoAsPerSpec;
    private String mobileNumber;
    private int partNo;
    private int partSerialNo;
    private String pinCode;
    private String place;
    private String postOffice;
    private String relationName;
    private String relationType;
    private int statusID;
    private String streetArea;
    private String tehsilTalukaMandal;
    private String townVillage;
    private String updateRefNoRemarks;
    private String updatedBy;
    private String updatedDTTM;
    private String updatedRefNo;
    private String verificationDate;
    private String verifiedBy;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected Content(Parcel in2) {
        this.id = in2.readInt();
        this.isNameVerified = in2.readString();
        this.isAddressVerified = in2.readString();
        this.isDOBVerified = in2.readString();
        this.isphotoAsPerSpec = in2.readString();
        this.isMobileVerified = in2.readString();
        this.isAgeVerified = in2.readString();
        this.isGenderVerified = in2.readString();
        this.isRelativeVerified = in2.readString();
        this.isRelationVerified = in2.readString();
        this.applicantStatus = in2.readString();
        this.isDetailsCorrect = in2.readString();
        this.hasObjected = in2.readString();
        this.hasDataEntryError = in2.readString();
        this.bloComments = in2.readString();
        this.fvrRemarks = in2.readString();
        this.correctedName = in2.readString();
        this.gender = in2.readString();
        this.relationName = in2.readString();
        this.relationType = in2.readString();
        this.houseNo = in2.readString();
        this.streetArea = in2.readString();
        this.townVillage = in2.readString();
        this.postOffice = in2.readString();
        this.tehsilTalukaMandal = in2.readString();
        this.pinCode = in2.readString();
        this.verificationDate = in2.readString();
        this.place = in2.readString();
        this.epicID = in2.readString();
        this.epicNo = in2.readString();
        this.acNo = in2.readInt();
        this.partNo = in2.readInt();
        this.partSerialNo = in2.readInt();
        this.formRefNo = in2.readString();
        this.verifiedBy = in2.readString();
        this.createdDTTM = in2.readString();
        this.updatedDTTM = in2.readString();
        this.statusID = in2.readInt();
        this.formType = in2.readString();
        this.createdBy = in2.readString();
        this.updatedBy = in2.readString();
        this.applicantSignature = in2.readString();
        this.bloSignature = in2.readString();
        this.electorName = in2.readString();
        this.applicantName = in2.readString();
        this.fieldVerificationAbsent = in2.readString();
        this.fieldVerificationShifted = in2.readString();
        this.fieldVerificationDead = in2.readString();
        this.fieldVerificationNoSuchPerson = in2.readString();
        this.fieldVerificationPersonPresent = in2.readString();
        this.fieldVerificationUnderAge = in2.readString();
        this.fieldVerificationAlreadyEnrolled = in2.readString();
        this.fieldVerificationNotIndianCitizen = in2.readString();
        this.dob = in2.readString();
        this.age = in2.readString();
        this.mobileNumber = in2.readString();
        this.eroRemarks = in2.readString();
        this.updateRefNoRemarks = in2.readString();
        this.updatedRefNo = in2.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.isNameVerified);
        dest.writeString(this.isAddressVerified);
        dest.writeString(this.isDOBVerified);
        dest.writeString(this.isphotoAsPerSpec);
        dest.writeString(this.isMobileVerified);
        dest.writeString(this.isAgeVerified);
        dest.writeString(this.isGenderVerified);
        dest.writeString(this.isRelativeVerified);
        dest.writeString(this.isRelationVerified);
        dest.writeString(this.applicantStatus);
        dest.writeString(this.isDetailsCorrect);
        dest.writeString(this.hasObjected);
        dest.writeString(this.hasDataEntryError);
        dest.writeString(this.bloComments);
        dest.writeString(this.fvrRemarks);
        dest.writeString(this.correctedName);
        dest.writeString(this.gender);
        dest.writeString(this.relationName);
        dest.writeString(this.relationType);
        dest.writeString(this.houseNo);
        dest.writeString(this.streetArea);
        dest.writeString(this.townVillage);
        dest.writeString(this.postOffice);
        dest.writeString(this.tehsilTalukaMandal);
        dest.writeString(this.pinCode);
        dest.writeString(this.verificationDate);
        dest.writeString(this.place);
        dest.writeString(this.epicID);
        dest.writeString(this.epicNo);
        dest.writeInt(this.acNo);
        dest.writeInt(this.partNo);
        dest.writeInt(this.partSerialNo);
        dest.writeString(this.formRefNo);
        dest.writeString(this.verifiedBy);
        dest.writeString(this.createdDTTM);
        dest.writeString(this.updatedDTTM);
        dest.writeInt(this.statusID);
        dest.writeString(this.formType);
        dest.writeString(this.createdBy);
        dest.writeString(this.updatedBy);
        dest.writeString(this.applicantSignature);
        dest.writeString(this.bloSignature);
        dest.writeString(this.electorName);
        dest.writeString(this.applicantName);
        dest.writeString(this.fieldVerificationAbsent);
        dest.writeString(this.fieldVerificationShifted);
        dest.writeString(this.fieldVerificationDead);
        dest.writeString(this.fieldVerificationNoSuchPerson);
        dest.writeString(this.fieldVerificationPersonPresent);
        dest.writeString(this.fieldVerificationUnderAge);
        dest.writeString(this.fieldVerificationAlreadyEnrolled);
        dest.writeString(this.fieldVerificationNotIndianCitizen);
        dest.writeString(this.dob);
        dest.writeString(this.age);
        dest.writeString(this.mobileNumber);
        dest.writeString(this.eroRemarks);
        dest.writeString(this.updateRefNoRemarks);
        dest.writeString(this.updatedRefNo);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsNameVerified() {
        return this.isNameVerified;
    }

    public void setIsNameVerified(String isNameVerified) {
        this.isNameVerified = isNameVerified;
    }

    public String getIsAddressVerified() {
        return this.isAddressVerified;
    }

    public void setIsAddressVerified(String isAddressVerified) {
        this.isAddressVerified = isAddressVerified;
    }

    public String getIsDOBVerified() {
        return this.isDOBVerified;
    }

    public void setIsDOBVerified(String isDOBVerified) {
        this.isDOBVerified = isDOBVerified;
    }

    public String getIsphotoAsPerSpec() {
        return this.isphotoAsPerSpec;
    }

    public void setIsphotoAsPerSpec(String isphotoAsPerSpec) {
        this.isphotoAsPerSpec = isphotoAsPerSpec;
    }

    public String getIsMobileVerified() {
        return this.isMobileVerified;
    }

    public void setIsMobileVerified(String isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
    }

    public String getIsAgeVerified() {
        return this.isAgeVerified;
    }

    public void setIsAgeVerified(String isAgeVerified) {
        this.isAgeVerified = isAgeVerified;
    }

    public String getIsGenderVerified() {
        return this.isGenderVerified;
    }

    public void setIsGenderVerified(String isGenderVerified) {
        this.isGenderVerified = isGenderVerified;
    }

    public String getIsRelativeVerified() {
        return this.isRelativeVerified;
    }

    public void setIsRelativeVerified(String isRelativeVerified) {
        this.isRelativeVerified = isRelativeVerified;
    }

    public String getIsRelationVerified() {
        return this.isRelationVerified;
    }

    public void setIsRelationVerified(String isRelationVerified) {
        this.isRelationVerified = isRelationVerified;
    }

    public String getApplicantStatus() {
        return this.applicantStatus;
    }

    public void setApplicantStatus(String applicantStatus) {
        this.applicantStatus = applicantStatus;
    }

    public String getIsDetailsCorrect() {
        return this.isDetailsCorrect;
    }

    public void setIsDetailsCorrect(String isDetailsCorrect) {
        this.isDetailsCorrect = isDetailsCorrect;
    }

    public String getHasObjected() {
        return this.hasObjected;
    }

    public void setHasObjected(String hasObjected) {
        this.hasObjected = hasObjected;
    }

    public String getHasDataEntryError() {
        return this.hasDataEntryError;
    }

    public void setHasDataEntryError(String hasDataEntryError) {
        this.hasDataEntryError = hasDataEntryError;
    }

    public String getBloComments() {
        return this.bloComments;
    }

    public void setBloComments(String bloComments) {
        this.bloComments = bloComments;
    }

    public String getFvrRemarks() {
        return this.fvrRemarks;
    }

    public void setFvrRemarks(String fvrRemarks) {
        this.fvrRemarks = fvrRemarks;
    }

    public String getCorrectedName() {
        return this.correctedName;
    }

    public void setCorrectedName(String correctedName) {
        this.correctedName = correctedName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelationName() {
        return this.relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    public String getRelationType() {
        return this.relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getHouseNo() {
        return this.houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetArea() {
        return this.streetArea;
    }

    public void setStreetArea(String streetArea) {
        this.streetArea = streetArea;
    }

    public String getTownVillage() {
        return this.townVillage;
    }

    public void setTownVillage(String townVillage) {
        this.townVillage = townVillage;
    }

    public String getPostOffice() {
        return this.postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getTehsilTalukaMandal() {
        return this.tehsilTalukaMandal;
    }

    public void setTehsilTalukaMandal(String tehsilTalukaMandal) {
        this.tehsilTalukaMandal = tehsilTalukaMandal;
    }

    public String getPinCode() {
        return this.pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getVerificationDate() {
        return this.verificationDate;
    }

    public void setVerificationDate(String verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEpicID() {
        return this.epicID;
    }

    public void setEpicID(String epicID) {
        this.epicID = epicID;
    }

    public String getEpicNo() {
        return this.epicNo;
    }

    public void setEpicNo(String epicNo) {
        this.epicNo = epicNo;
    }

    public int getAcNo() {
        return this.acNo;
    }

    public void setAcNo(int acNo) {
        this.acNo = acNo;
    }

    public int getPartNo() {
        return this.partNo;
    }

    public void setPartNo(int partNo) {
        this.partNo = partNo;
    }

    public int getPartSerialNo() {
        return this.partSerialNo;
    }

    public void setPartSerialNo(int partSerialNo) {
        this.partSerialNo = partSerialNo;
    }

    public String getFormRefNo() {
        return this.formRefNo;
    }

    public void setFormRefNo(String formRefNo) {
        this.formRefNo = formRefNo;
    }

    public String getVerifiedBy() {
        return this.verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public String getCreatedDTTM() {
        return this.createdDTTM;
    }

    public void setCreatedDTTM(String createdDTTM) {
        this.createdDTTM = createdDTTM;
    }

    public String getUpdatedDTTM() {
        return this.updatedDTTM;
    }

    public void setUpdatedDTTM(String updatedDTTM) {
        this.updatedDTTM = updatedDTTM;
    }

    public int getStatusID() {
        return this.statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getFormType() {
        return this.formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getApplicantSignature() {
        return this.applicantSignature;
    }

    public void setApplicantSignature(String applicantSignature) {
        this.applicantSignature = applicantSignature;
    }

    public String getBloSignature() {
        return this.bloSignature;
    }

    public void setBloSignature(String bloSignature) {
        this.bloSignature = bloSignature;
    }

    public String getElectorName() {
        return this.electorName;
    }

    public void setElectorName(String electorName) {
        this.electorName = electorName;
    }

    public String getApplicantName() {
        return this.applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getFieldVerificationAbsent() {
        return this.fieldVerificationAbsent;
    }

    public void setFieldVerificationAbsent(String fieldVerificationAbsent) {
        this.fieldVerificationAbsent = fieldVerificationAbsent;
    }

    public String getFieldVerificationShifted() {
        return this.fieldVerificationShifted;
    }

    public void setFieldVerificationShifted(String fieldVerificationShifted) {
        this.fieldVerificationShifted = fieldVerificationShifted;
    }

    public String getFieldVerificationDead() {
        return this.fieldVerificationDead;
    }

    public void setFieldVerificationDead(String fieldVerificationDead) {
        this.fieldVerificationDead = fieldVerificationDead;
    }

    public String getFieldVerificationNoSuchPerson() {
        return this.fieldVerificationNoSuchPerson;
    }

    public void setFieldVerificationNoSuchPerson(String fieldVerificationNoSuchPerson) {
        this.fieldVerificationNoSuchPerson = fieldVerificationNoSuchPerson;
    }

    public String getFieldVerificationPersonPresent() {
        return this.fieldVerificationPersonPresent;
    }

    public void setFieldVerificationPersonPresent(String fieldVerificationPersonPresent) {
        this.fieldVerificationPersonPresent = fieldVerificationPersonPresent;
    }

    public String getFieldVerificationUnderAge() {
        return this.fieldVerificationUnderAge;
    }

    public void setFieldVerificationUnderAge(String fieldVerificationUnderAge) {
        this.fieldVerificationUnderAge = fieldVerificationUnderAge;
    }

    public String getFieldVerificationAlreadyEnrolled() {
        return this.fieldVerificationAlreadyEnrolled;
    }

    public void setFieldVerificationAlreadyEnrolled(String fieldVerificationAlreadyEnrolled) {
        this.fieldVerificationAlreadyEnrolled = fieldVerificationAlreadyEnrolled;
    }

    public String getFieldVerificationNotIndianCitizen() {
        return this.fieldVerificationNotIndianCitizen;
    }

    public void setFieldVerificationNotIndianCitizen(String fieldVerificationNotIndianCitizen) {
        this.fieldVerificationNotIndianCitizen = fieldVerificationNotIndianCitizen;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEroRemarks() {
        return this.eroRemarks;
    }

    public void setEroRemarks(String eroRemarks) {
        this.eroRemarks = eroRemarks;
    }

    public String getUpdateRefNoRemarks() {
        return this.updateRefNoRemarks;
    }

    public void setUpdateRefNoRemarks(String updateRefNoRemarks) {
        this.updateRefNoRemarks = updateRefNoRemarks;
    }

    public String getUpdatedRefNo() {
        return this.updatedRefNo;
    }

    public void setUpdatedRefNo(String updatedRefNo) {
        this.updatedRefNo = updatedRefNo;
    }
}
