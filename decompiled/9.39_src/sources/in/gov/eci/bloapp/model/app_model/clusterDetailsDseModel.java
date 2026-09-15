package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class clusterDetailsDseModel {

    @SerializedName("AC")
    public String ac;

    @SerializedName("ACTION_KEY")
    public String actionKey;

    @SerializedName("ADDRESS")
    public String address;

    @SerializedName("AGE")
    public String age;

    @SerializedName("FIRST_NAME")
    public String applicantFirstname;

    @SerializedName("LAST_NAME")
    public String applicantLastname;

    @SerializedName("bloStatusId")
    public int bloStatusId;

    @SerializedName("BLO_VERFIED_STATUS")
    public String bloVerifStatus;

    @SerializedName("CLUSTER_ID")
    public String clusterId;

    @SerializedName("DATE_OF_INCLUSION")
    public String dateofinclusion;

    @SerializedName("EPIC_NUMBER")
    public String epicnumber;

    @SerializedName("GENDER")
    public String gender;

    @SerializedName("PART_NUMBER")
    public String partnumber;

    @SerializedName("PHOTOGRAPH")
    public String photo;

    @SerializedName("PSE_ID")
    public String pseid;

    @SerializedName("RELATION_FIRST_NAME")
    public String relationfirstname;

    @SerializedName("RELATION_LAST_NAME")
    public String relationlastname;

    @SerializedName("RELATION_TYPE")
    public String relationtype;

    @SerializedName("REMARK")
    public String remark;

    @SerializedName("SERIAL_NO")
    public Integer serialno;

    public clusterDetailsDseModel(String applicantFirstname, String applicantLastname, String epicnumber, String ac, String partnumber, String age, String gender, String relationfirstname, String relationlastname, String relationtype, String address, Integer serialno, String pseid, String dateofinclusion, String bloVerifStatus, String photo, String clusterId, String remark, String actionKey, Integer bloStatusId) {
        this.applicantFirstname = applicantFirstname;
        this.applicantLastname = applicantLastname;
        this.epicnumber = epicnumber;
        this.ac = ac;
        this.partnumber = partnumber;
        this.age = age;
        this.gender = gender;
        this.relationfirstname = relationfirstname;
        this.relationlastname = relationlastname;
        this.relationtype = relationtype;
        this.address = address;
        this.serialno = serialno;
        this.pseid = pseid;
        this.dateofinclusion = dateofinclusion;
        this.bloVerifStatus = bloVerifStatus;
        this.photo = photo;
        this.clusterId = clusterId;
        this.remark = remark;
        this.actionKey = actionKey;
        this.bloStatusId = bloStatusId.intValue();
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getActionKey() {
        return this.actionKey;
    }

    public void setActionKey(String actionKey) {
        this.actionKey = actionKey;
    }

    public String getClusterId() {
        return this.clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
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

    public String getEpicnumber() {
        return this.epicnumber;
    }

    public void setEpicnumber(String epicnumber) {
        this.epicnumber = epicnumber;
    }

    public String getAc() {
        return this.ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getPartnumber() {
        return this.partnumber;
    }

    public void setPartnumber(String partnumber) {
        this.partnumber = partnumber;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelationfirstname() {
        return this.relationfirstname;
    }

    public void setRelationfirstname(String relationfirstname) {
        this.relationfirstname = relationfirstname;
    }

    public String getRelationlastname() {
        return this.relationlastname;
    }

    public void setRelationlastname(String relationlastname) {
        this.relationlastname = relationlastname;
    }

    public String getRelationtype() {
        return this.relationtype;
    }

    public void setRelationtype(String relationtype) {
        this.relationtype = relationtype;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSerialno() {
        return this.serialno;
    }

    public void setSerialno(Integer serialno) {
        this.serialno = serialno;
    }

    public String getPseid() {
        return this.pseid;
    }

    public void setPseid(String pseid) {
        this.pseid = pseid;
    }

    public String getDateofinclusion() {
        return this.dateofinclusion;
    }

    public void setDateofinclusion(String dateofinclusion) {
        this.dateofinclusion = dateofinclusion;
    }

    public String getBloVerifStatus() {
        return this.bloVerifStatus;
    }

    public void setBloVerifStatus(String bloVerifStatus) {
        this.bloVerifStatus = bloVerifStatus;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getBloStatusId() {
        return this.bloStatusId;
    }

    public void setBloStatusId(int bloStatusId) {
        this.bloStatusId = bloStatusId;
    }
}
