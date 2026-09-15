package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class EpicRecylerViewDataModel {

    @SerializedName("ASSEMBLY_NAME")
    public String assembly;

    @SerializedName("ASSEMBLY_NUMBER")
    public String assemblyNumber;

    @SerializedName("DVOTERSTATUSTYPE")
    public String dVoterStatusType;

    @SerializedName("DISTRICT_NAME")
    public String district;

    @SerializedName("DISTRICT_CODE")
    public String districtCd;

    @SerializedName("EPIC")
    public String epic;

    @SerializedName("GENDER")
    public String gender;

    @SerializedName("NAME")
    public String name;

    @SerializedName("PARTNUMBER")
    public String partNumber;

    @SerializedName("PHOTOGRAPH")
    public byte[] photo;

    @SerializedName("PHOTOREFERENCE")
    public String photoRef;

    @SerializedName("PROCESSMASTERID")
    public String processMasterId;

    @SerializedName("RELATIVE_NAME")
    public String relativeName;

    @SerializedName("RELATIVE_SURNAME")
    public String relativeSurname;

    @SerializedName("SERIALNUMBER")
    public String serialNumber;

    @SerializedName("STATE_NAME")
    public String state;

    @SerializedName("STATE_CODE")
    public String stateCd;

    @SerializedName("SURNAME")
    public String surname;

    @SerializedName("underJo")
    public String underJo;

    public EpicRecylerViewDataModel(String state, String district, String stateCd, String districtCd, String assembly, String assemblyNumber, String name, String surname, String epic, String relativeName, String relativeSurname, String gender, String partNumber, String serialNumber, String dVoterStatusType, String processMasterId, String photoRef, byte[] photo, String underJo) {
        this.state = state;
        this.district = district;
        this.stateCd = stateCd;
        this.districtCd = districtCd;
        this.assembly = assembly;
        this.assemblyNumber = assemblyNumber;
        this.name = name;
        this.surname = surname;
        this.epic = epic;
        this.relativeName = relativeName;
        this.relativeSurname = relativeSurname;
        this.gender = gender;
        this.partNumber = partNumber;
        this.serialNumber = serialNumber;
        this.dVoterStatusType = dVoterStatusType;
        this.processMasterId = processMasterId;
        this.photoRef = photoRef;
        this.photo = photo;
        this.underJo = underJo;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStateCd() {
        return this.stateCd;
    }

    public void setStateCd(String stateCd) {
        this.stateCd = stateCd;
    }

    public String getDistrictCd() {
        return this.districtCd;
    }

    public void setDistrictCd(String districtCd) {
        this.districtCd = districtCd;
    }

    public String getAssembly() {
        return this.assembly;
    }

    public void setAssembly(String assembly) {
        this.assembly = assembly;
    }

    public String getAssemblyNumber() {
        return this.assemblyNumber;
    }

    public void setAssemblyNumber(String assemblyNumber) {
        this.assemblyNumber = assemblyNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEpic() {
        return this.epic;
    }

    public void setEpic(String epic) {
        this.epic = epic;
    }

    public String getRelativeName() {
        return this.relativeName;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    public String getRelativeSurname() {
        return this.relativeSurname;
    }

    public void setRelativeSurname(String relativeSurname) {
        this.relativeSurname = relativeSurname;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getdVoterStatusType() {
        return this.dVoterStatusType;
    }

    public void setdVoterStatusType(String dVoterStatusType) {
        this.dVoterStatusType = dVoterStatusType;
    }

    public String getProcessMasterId() {
        return this.processMasterId;
    }

    public void setProcessMasterId(String processMasterId) {
        this.processMasterId = processMasterId;
    }

    public String getPhotoRef() {
        return this.photoRef;
    }

    public void setPhotoRef(String photoRef) {
        this.photoRef = photoRef;
    }

    public byte[] getPhoto() {
        return this.photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getUnderJo() {
        return this.underJo;
    }

    public void setUnderJo(String underJo) {
        this.underJo = underJo;
    }
}
