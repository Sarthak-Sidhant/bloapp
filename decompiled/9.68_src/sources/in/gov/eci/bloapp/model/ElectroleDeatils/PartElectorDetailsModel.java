package in.gov.eci.bloapp.model.ElectroleDeatils;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class PartElectorDetailsModel {

    public static class Items {
        String aadharNo;
        String acNo;
        String addressAttachment;
        String age;
        String allDetailsVerified;
        String applicantName;
        String applicantNameL1;
        String bloId;
        String coordinate;
        String dateOfVerification;
        String disabilityLocomotor;
        String disabilityPercentage;
        String disabilitySpeechHearing;
        String disabilityVisually;
        String dob;
        String dobAttachment;
        String email;
        String epicNo;
        String gender;
        String houseApplicantFound;
        String houseNo;
        String houseNoL1;
        int id;
        String isAddressRecordSame;
        String isDobRecordSame;
        String isElectorRecordSame;
        String lastSyncStatus;
        String localitySreet;
        String localitySreetL1;
        String misDocument;
        String mobileNo;
        String modifiedOn;
        String otherDisability;
        String partNo;
        String partSerialNumber;
        String photo;
        String pinCode;
        String postOffice;
        String postOfficeL1;
        String pwd;
        String relativeName;
        String relativeNameL1;
        String relativeType;
        String remarks;
        String sectionName;
        String sectionNo;
        String stateCode;
        String tehsilTalukaMandal;
        String tehsilTalukaMandalL1;
        String village;
        String villageL1;

        public Items(String epicNo, String partNo, String bloId, String modifiedOn, String lastSyncStatus) {
            this.epicNo = epicNo;
            this.partNo = partNo;
            this.bloId = bloId;
            this.modifiedOn = modifiedOn;
            this.lastSyncStatus = lastSyncStatus;
        }

        public Items(int id, String epicNo, String houseNo, String applicantName, String applicantNameL1, String gender, String relativeName, String relativeNameL1, String relativeType, String mobileNo, String email, String isElectorRecordSame, String dob, String dobAttachment, String isDobRecordSame, String addressAttachment, String isAddressRecordSame, String houseApplicantFound, String allDetailsVerified, String remarks, String misDocument, String dateOfVerification, String coordinate, String age, String localitySreet, String village, String postOffice, String pinCode, String stateCode, String acNo, String partNo, String photo, String localitySreetL1, String houseNoL1, String postOfficeL1, String villageL1, String tehsilTalukaMandal, String tehsilTalukaMandalL1, String aadharNo, String sectionNo, String sectionName, String pwd, String disabilityPercentage, String otherDisability, String disabilityLocomotor, String disabilitySpeechHearing, String disabilityVisually, String bloId, String modifiedOn, String lastSyncStatus, String partSerialNumber) {
            this.id = id;
            this.epicNo = epicNo;
            this.houseNo = houseNo;
            this.applicantName = applicantName;
            this.applicantNameL1 = applicantNameL1;
            this.gender = gender;
            this.relativeName = relativeName;
            this.relativeNameL1 = relativeNameL1;
            this.relativeType = relativeType;
            this.mobileNo = mobileNo;
            this.email = email;
            this.isElectorRecordSame = isElectorRecordSame;
            this.dob = dob;
            this.dobAttachment = dobAttachment;
            this.isDobRecordSame = isDobRecordSame;
            this.addressAttachment = addressAttachment;
            this.isAddressRecordSame = isAddressRecordSame;
            this.houseApplicantFound = houseApplicantFound;
            this.allDetailsVerified = allDetailsVerified;
            this.remarks = remarks;
            this.misDocument = misDocument;
            this.dateOfVerification = dateOfVerification;
            this.coordinate = coordinate;
            this.age = age;
            this.localitySreet = localitySreet;
            this.village = village;
            this.postOffice = postOffice;
            this.pinCode = pinCode;
            this.stateCode = stateCode;
            this.acNo = acNo;
            this.partNo = partNo;
            this.photo = photo;
            this.localitySreetL1 = localitySreetL1;
            this.houseNoL1 = houseNoL1;
            this.postOfficeL1 = postOfficeL1;
            this.villageL1 = villageL1;
            this.tehsilTalukaMandal = tehsilTalukaMandal;
            this.tehsilTalukaMandalL1 = tehsilTalukaMandalL1;
            this.aadharNo = aadharNo;
            this.sectionNo = sectionNo;
            this.sectionName = sectionName;
            this.pwd = pwd;
            this.disabilityPercentage = disabilityPercentage;
            this.otherDisability = otherDisability;
            this.disabilityLocomotor = disabilityLocomotor;
            this.disabilitySpeechHearing = disabilitySpeechHearing;
            this.disabilityVisually = disabilityVisually;
            this.bloId = bloId;
            this.modifiedOn = modifiedOn;
            this.lastSyncStatus = lastSyncStatus;
            this.partSerialNumber = partSerialNumber;
        }

        @SerializedName("id")
        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @SerializedName("epicNo")
        public String getEpicNo() {
            return this.epicNo;
        }

        public void setEpicNo(String epicNo) {
            this.epicNo = epicNo;
        }

        @SerializedName("houseNo")
        public String getHouseNo() {
            return this.houseNo;
        }

        public void setHouseNo(String houseNo) {
            this.houseNo = houseNo;
        }

        @SerializedName("applicantName")
        public String getApplicantName() {
            return this.applicantName;
        }

        public void setApplicantName(String applicantName) {
            this.applicantName = applicantName;
        }

        @SerializedName("applicantNameL1")
        public String getApplicantNameL1() {
            return this.applicantNameL1;
        }

        public void setApplicantNameL1(String applicantNameL1) {
            this.applicantNameL1 = applicantNameL1;
        }

        @SerializedName("gender")
        public String getGender() {
            return this.gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @SerializedName("relativeName")
        public String getRelativeName() {
            return this.relativeName;
        }

        public void setRelativeName(String relativeName) {
            this.relativeName = relativeName;
        }

        @SerializedName("relativeNameL1")
        public String getRelativeNameL1() {
            return this.relativeNameL1;
        }

        public void setRelativeNameL1(String relativeNameL1) {
            this.relativeNameL1 = relativeNameL1;
        }

        @SerializedName("relativeType")
        public String getRelativeType() {
            return this.relativeType;
        }

        public void setRelativeType(String relativeType) {
            this.relativeType = relativeType;
        }

        @SerializedName("mobileNo")
        public String getMobileNo() {
            return this.mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        @SerializedName("email")
        public String getEmail() {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @SerializedName("isElectorRecordSame")
        public String getIsElectorRecordSame() {
            return this.isElectorRecordSame;
        }

        public void setIsElectorRecordSame(String isElectorRecordSame) {
            this.isElectorRecordSame = isElectorRecordSame;
        }

        @SerializedName("dob")
        public String getDob() {
            return this.dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        @SerializedName("dobAttachment")
        public String getDobAttachment() {
            return this.dobAttachment;
        }

        public void setDobAttachment(String dobAttachment) {
            this.dobAttachment = dobAttachment;
        }

        @SerializedName("isDobRecordSame")
        public String getIsDobRecordSame() {
            return this.isDobRecordSame;
        }

        public void setIsDobRecordSame(String isDobRecordSame) {
            this.isDobRecordSame = isDobRecordSame;
        }

        @SerializedName("addressAttachment")
        public String getAddressAttachment() {
            return this.addressAttachment;
        }

        public void setAddressAttachment(String addressAttachment) {
            this.addressAttachment = addressAttachment;
        }

        @SerializedName("isAddressRecordSame")
        public String getIsAddressRecordSame() {
            return this.isAddressRecordSame;
        }

        public void setIsAddressRecordSame(String isAddressRecordSame) {
            this.isAddressRecordSame = isAddressRecordSame;
        }

        @SerializedName("houseApplicantFound")
        public String getHouseApplicantFound() {
            return this.houseApplicantFound;
        }

        public void setHouseApplicantFound(String houseApplicantFound) {
            this.houseApplicantFound = houseApplicantFound;
        }

        @SerializedName("allDetailsVerified")
        public String getAllDetailsVerified() {
            return this.allDetailsVerified;
        }

        public void setAllDetailsVerified(String allDetailsVerified) {
            this.allDetailsVerified = allDetailsVerified;
        }

        @SerializedName("remarks")
        public String getRemarks() {
            return this.remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        @SerializedName("misDocument")
        public String getMisDocument() {
            return this.misDocument;
        }

        public void setMisDocument(String misDocument) {
            this.misDocument = misDocument;
        }

        @SerializedName("dateOfVerification")
        public String getDateOfVerification() {
            return this.dateOfVerification;
        }

        public void setDateOfVerification(String dateOfVerification) {
            this.dateOfVerification = dateOfVerification;
        }

        @SerializedName("coordinate")
        public String getCoordinate() {
            return this.coordinate;
        }

        public void setCoordinate(String coordinate) {
            this.coordinate = coordinate;
        }

        @SerializedName("age")
        public String getAge() {
            return this.age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @SerializedName("localitySreet")
        public String getLocalitySreet() {
            return this.localitySreet;
        }

        public void setLocalitySreet(String localitySreet) {
            this.localitySreet = localitySreet;
        }

        @SerializedName("village")
        public String getVillage() {
            return this.village;
        }

        public void setVillage(String village) {
            this.village = village;
        }

        @SerializedName("postOffice")
        public String getPostOffice() {
            return this.postOffice;
        }

        public void setPostOffice(String postOffice) {
            this.postOffice = postOffice;
        }

        @SerializedName("pinCode")
        public String getPinCode() {
            return this.pinCode;
        }

        public void setPinCode(String pinCode) {
            this.pinCode = pinCode;
        }

        @SerializedName("stateCode")
        public String getStateCode() {
            return this.stateCode;
        }

        public void setStateCode(String stateCode) {
            this.stateCode = stateCode;
        }

        @SerializedName("acNo")
        public String getAcNo() {
            return this.acNo;
        }

        public void setAcNo(String acNo) {
            this.acNo = acNo;
        }

        @SerializedName("partNo")
        public String getPartNo() {
            return this.partNo;
        }

        public void setPartNo(String partNo) {
            this.partNo = partNo;
        }

        @SerializedName("photo")
        public String getPhoto() {
            return this.photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        @SerializedName("localitySreetL1")
        public String getLocalitySreetL1() {
            return this.localitySreetL1;
        }

        public void setLocalitySreetL1(String localitySreetL1) {
            this.localitySreetL1 = localitySreetL1;
        }

        @SerializedName("houseNoL1")
        public String getHouseNoL1() {
            return this.houseNoL1;
        }

        public void setHouseNoL1(String houseNoL1) {
            this.houseNoL1 = houseNoL1;
        }

        @SerializedName("postOfficeL1")
        public String getPostOfficeL1() {
            return this.postOfficeL1;
        }

        public void setPostOfficeL1(String postOfficeL1) {
            this.postOfficeL1 = postOfficeL1;
        }

        @SerializedName("villageL1")
        public String getVillageL1() {
            return this.villageL1;
        }

        public void setVillageL1(String villageL1) {
            this.villageL1 = villageL1;
        }

        @SerializedName("tehsilTalukaMandal")
        public String getTehsilTalukaMandal() {
            return this.tehsilTalukaMandal;
        }

        public void setTehsilTalukaMandal(String tehsilTalukaMandal) {
            this.tehsilTalukaMandal = tehsilTalukaMandal;
        }

        @SerializedName("tehsilTalukaMandalL1")
        public String getTehsilTalukaMandalL1() {
            return this.tehsilTalukaMandalL1;
        }

        public void setTehsilTalukaMandalL1(String tehsilTalukaMandalL1) {
            this.tehsilTalukaMandalL1 = tehsilTalukaMandalL1;
        }

        @SerializedName("aadharNo")
        public String getAadharNo() {
            return this.aadharNo;
        }

        public void setAadharNo(String aadharNo) {
            this.aadharNo = aadharNo;
        }

        @SerializedName("sectionNo")
        public String getSectionNo() {
            return this.sectionNo;
        }

        public void setSectionNo(String sectionNo) {
            this.sectionNo = sectionNo;
        }

        @SerializedName("sectionName")
        public String getSectionName() {
            return this.sectionName;
        }

        public void setSectionName(String sectionName) {
            this.sectionName = sectionName;
        }

        @SerializedName("pwd")
        public String getPwd() {
            return this.pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        @SerializedName("disabilityPercentage")
        public String getDisabilityPercentage() {
            return this.disabilityPercentage;
        }

        public void setDisabilityPercentage(String disabilityPercentage) {
            this.disabilityPercentage = disabilityPercentage;
        }

        @SerializedName("otherDisability")
        public String getOtherDisability() {
            return this.otherDisability;
        }

        public void setOtherDisability(String otherDisability) {
            this.otherDisability = otherDisability;
        }

        @SerializedName("disabilityLocomotor")
        public String getDisabilityLocomotor() {
            return this.disabilityLocomotor;
        }

        public void setDisabilityLocomotor(String disabilityLocomotor) {
            this.disabilityLocomotor = disabilityLocomotor;
        }

        @SerializedName("disabilitySpeechHearing")
        public String getDisabilitySpeechHearing() {
            return this.disabilitySpeechHearing;
        }

        public void setDisabilitySpeechHearing(String disabilitySpeechHearing) {
            this.disabilitySpeechHearing = disabilitySpeechHearing;
        }

        @SerializedName("disabilityVisually")
        public String getDisabilityVisually() {
            return this.disabilityVisually;
        }

        public void setDisabilityVisually(String disabilityVisually) {
            this.disabilityVisually = disabilityVisually;
        }

        @SerializedName("partSerialNumber")
        public String getPartSerialNumber() {
            return this.partSerialNumber;
        }

        public void setPartSerialNumber(String partSerialNumber) {
            this.partSerialNumber = partSerialNumber;
        }

        public String getBloId() {
            return this.bloId;
        }

        public void setBloId(String bloId) {
            this.bloId = bloId;
        }

        public String getModifiedOn() {
            return this.modifiedOn;
        }

        public void setModifiedOn(String modifiedOn) {
            this.modifiedOn = modifiedOn;
        }

        public String getLastSyncStatus() {
            return this.lastSyncStatus;
        }

        public void setLastSyncStatus(String lastSyncStatus) {
            this.lastSyncStatus = lastSyncStatus;
        }
    }

    public static class Payload {
        ArrayList<Items> items;
        boolean next;
        int pageLimit;
        int pageNumber;
        int totalCount;

        @SerializedName("next")
        public boolean getNext() {
            return this.next;
        }

        @SerializedName("next")
        public int getPageLimit() {
            return this.pageLimit;
        }

        @SerializedName("pageNumber")
        public int getPageNumber() {
            return this.pageNumber;
        }

        @SerializedName("totalCount")
        public int getTotalCount() {
            return this.totalCount;
        }

        @SerializedName("items")
        public ArrayList<Items> getItems() {
            return this.items;
        }

        public Payload(boolean next, int pageLimit, int pageNumber, int totalCount, ArrayList<Items> items) {
            this.next = next;
            this.pageLimit = pageLimit;
            this.pageNumber = pageNumber;
            this.totalCount = totalCount;
            this.items = items;
        }
    }

    public class Root {
        String message;
        Payload payload;
        String refId;
        String status;
        int statusCode;

        public Root() {
        }

        @SerializedName("status")
        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @SerializedName("statusCode")
        public int getStatusCode() {
            return this.statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        @SerializedName("refId")
        public String getRefId() {
            return this.refId;
        }

        public void setRefId(String refId) {
            this.refId = refId;
        }

        @SerializedName("message")
        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @SerializedName("payload")
        public Payload getPayload() {
            return this.payload;
        }

        public void setPayload(Payload payload) {
            this.payload = payload;
        }
    }
}
