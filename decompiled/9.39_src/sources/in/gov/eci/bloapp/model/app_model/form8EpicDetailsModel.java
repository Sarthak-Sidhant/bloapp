package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class form8EpicDetailsModel {

    @SerializedName("AC_NUMBER")
    public String acNumber;

    @SerializedName("AGE")
    public String age;

    @SerializedName("FIRST_NAME")
    public String applicantFirstname;

    @SerializedName("LAST_NAME")
    public String applicantLastname;

    @SerializedName("APPLICANT_NAME_L1")
    public String applicantNameL1;

    @SerializedName("ASSEMBLY_NAME")
    public String assemblyName;

    @SerializedName("D_VOTER")
    public String dVoterStatusType;

    @SerializedName("DISTRICT_CODE")
    public String districtCode;

    @SerializedName("DISTRICT_NAME")
    public String districtName;

    @SerializedName("DOB")
    public String dob;

    @SerializedName("EMAIL_ID")
    public String emailId;

    @SerializedName("EPIC_NUMBER")
    public String epicNumber;

    @SerializedName("GENDER")
    public String gender;

    @SerializedName("GENDER_L1")
    public String genderL1;

    @SerializedName("HOUSE_NUMBER")
    public String houseNumber;

    @SerializedName("HOUSE_NUMBER_L1")
    public String houseNumberL1;

    @SerializedName("LOCALITY_STREET")
    public String localityStreet;

    @SerializedName("LOCALITY_STREET_L1")
    public String localityStreetL1;

    @SerializedName("MOBILE_NUMBER")
    public String mobileNumber;

    @SerializedName("PART_NUMBER")
    public String partNumber;

    @SerializedName("PART_SERIAL_NUMBER")
    public String partSerialNumber;
    public String penameregionalFirst;
    public String penameregionalLast;

    @SerializedName("RELATION_FIRST_NAME")
    public String relationFirstName;

    @SerializedName("RELATION_NAME_L1")
    public String relationNameL1;

    @SerializedName("RELATION_SURNAME")
    public String relationSurname;

    @SerializedName("RELATION_TYPE")
    public String relationType;

    @SerializedName("SECTION_NUMBER")
    public String sectionNo;

    @SerializedName("SHIFTING_IMAGE")
    public String shiftingImage;

    @SerializedName("STATE_CODE")
    public String stateCode;

    @SerializedName("STATE_NAME")
    public String stateName;

    @SerializedName("TEHSIL")
    public String tehsil;

    @SerializedName("TEHSIL_L1")
    public String tehsilL1;

    @SerializedName("TOWN_VILLAGE")
    public String townVillage;

    @SerializedName("TOWN_VILLAGE_L1")
    public String townVillageL1;

    @SerializedName("underJo")
    public String underJo;

    public form8EpicDetailsModel(String dVoterStatusType, String partNumber, String stateCode, String acNumber, String partSerialNumber, String stateName, String districtName, String assemblyName, String applicantFirstname, String applicantLastname, String epicNumber, String mobileNumber, String emailId, String districtCode, String gender, String relationFirstName, String relationSurname, String relationNameL1, String genderL1, String applicantNameL1, String age, String sectionNo, String shiftingImage, String dob, String houseNumber, String houseNumberL1, String localityStreet, String localityStreetL1, String townVillage, String townVillageL1, String tehsil, String tehsilL1, String relationType, String penameregionalFirst, String penameregionalLast, String underJo) {
        this.dVoterStatusType = dVoterStatusType;
        this.partNumber = partNumber;
        this.stateCode = stateCode;
        this.acNumber = acNumber;
        this.partSerialNumber = partSerialNumber;
        this.stateName = stateName;
        this.districtName = districtName;
        this.assemblyName = assemblyName;
        this.applicantFirstname = applicantFirstname;
        this.applicantLastname = applicantLastname;
        this.epicNumber = epicNumber;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.districtCode = districtCode;
        this.gender = gender;
        this.relationFirstName = relationFirstName;
        this.relationSurname = relationSurname;
        this.relationNameL1 = relationNameL1;
        this.genderL1 = genderL1;
        this.applicantNameL1 = applicantNameL1;
        this.age = age;
        this.sectionNo = sectionNo;
        this.shiftingImage = shiftingImage;
        this.dob = dob;
        this.houseNumber = houseNumber;
        this.houseNumberL1 = houseNumberL1;
        this.localityStreet = localityStreet;
        this.localityStreetL1 = localityStreetL1;
        this.townVillage = townVillage;
        this.townVillageL1 = townVillageL1;
        this.tehsil = tehsil;
        this.tehsilL1 = tehsilL1;
        this.relationType = relationType;
        this.penameregionalFirst = penameregionalFirst;
        this.penameregionalLast = penameregionalLast;
        this.underJo = underJo;
    }

    public String getPenameregionalFirst() {
        return this.penameregionalFirst;
    }

    public void setPenameregionalFirst(String penameregionalFirst) {
        this.penameregionalFirst = penameregionalFirst;
    }

    public String getPenameregionalLast() {
        return this.penameregionalLast;
    }

    public void setPenameregionalLast(String penameregionalLast) {
        this.penameregionalLast = penameregionalLast;
    }

    public String getRelationType() {
        return this.relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getRelationFirstName() {
        return this.relationFirstName;
    }

    public void setRelationFirstName(String relationFirstName) {
        this.relationFirstName = relationFirstName;
    }

    public String getRelationSurname() {
        return this.relationSurname;
    }

    public void setRelationSurname(String relationSurname) {
        this.relationSurname = relationSurname;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseNumberL1() {
        return this.houseNumberL1;
    }

    public void setHouseNumberL1(String houseNumberL1) {
        this.houseNumberL1 = houseNumberL1;
    }

    public String getLocalityStreet() {
        return this.localityStreet;
    }

    public void setLocalityStreet(String localityStreet) {
        this.localityStreet = localityStreet;
    }

    public String getLocalityStreetL1() {
        return this.localityStreetL1;
    }

    public void setLocalityStreetL1(String localityStreetL1) {
        this.localityStreetL1 = localityStreetL1;
    }

    public String getTownVillage() {
        return this.townVillage;
    }

    public void setTownVillage(String townVillage) {
        this.townVillage = townVillage;
    }

    public String getTownVillageL1() {
        return this.townVillageL1;
    }

    public void setTownVillageL1(String townVillageL1) {
        this.townVillageL1 = townVillageL1;
    }

    public String getTehsil() {
        return this.tehsil;
    }

    public void setTehsil(String tehsil) {
        this.tehsil = tehsil;
    }

    public String getTehsilL1() {
        return this.tehsilL1;
    }

    public void setTehsilL1(String tehsilL1) {
        this.tehsilL1 = tehsilL1;
    }

    public String getShiftingImage() {
        return this.shiftingImage;
    }

    public void setShiftingImage(String shiftingImage) {
        this.shiftingImage = shiftingImage;
    }

    public String getdVoterStatusType() {
        return this.dVoterStatusType;
    }

    public void setdVoterStatusType(String dVoterStatusType) {
        this.dVoterStatusType = dVoterStatusType;
    }

    public String getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getStateCode() {
        return this.stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getAcNumber() {
        return this.acNumber;
    }

    public void setAcNumber(String acNumber) {
        this.acNumber = acNumber;
    }

    public String getPartSerialNumber() {
        return this.partSerialNumber;
    }

    public void setPartSerialNumber(String partSerialNumber) {
        this.partSerialNumber = partSerialNumber;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAssemblyName() {
        return this.assemblyName;
    }

    public void setAssemblyName(String assemblyName) {
        this.assemblyName = assemblyName;
    }

    public String getApplicantFirstname() {
        return this.applicantFirstname;
    }

    public void setApplicantFirstname(String applicantFirstname) {
        this.applicantFirstname = applicantFirstname;
    }

    public String getApplicantLastname() {
        return this.applicantLastname;
    }

    public void setApplicantLastname(String applicantLastname) {
        this.applicantLastname = applicantLastname;
    }

    public String getEpicNumber() {
        return this.epicNumber;
    }

    public void setEpicNumber(String epicNumber) {
        this.epicNumber = epicNumber;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDistrictCode() {
        return this.districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelationNameL1() {
        return this.relationNameL1;
    }

    public void setRelationNameL1(String relationNameL1) {
        this.relationNameL1 = relationNameL1;
    }

    public String getGenderL1() {
        return this.genderL1;
    }

    public void setGenderL1(String genderL1) {
        this.genderL1 = genderL1;
    }

    public String getApplicantNameL1() {
        return this.applicantNameL1;
    }

    public void setApplicantNameL1(String applicantNameL1) {
        this.applicantNameL1 = applicantNameL1;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSectionNo() {
        return this.sectionNo;
    }

    public void setSectionNo(String sectionNo) {
        this.sectionNo = sectionNo;
    }

    public String getUnderJo() {
        return this.underJo;
    }

    public void setUnderJo(String underJo) {
        this.underJo = underJo;
    }
}
