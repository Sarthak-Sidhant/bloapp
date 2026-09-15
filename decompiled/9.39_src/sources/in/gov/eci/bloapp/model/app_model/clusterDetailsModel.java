package in.gov.eci.bloapp.model.app_model;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class clusterDetailsModel {

    @SerializedName("AC")
    public String ac;

    @SerializedName("ADDRESS")
    public String address;

    @SerializedName("AGE")
    public String age;

    @SerializedName("FIRST_NAME")
    public String applicantFirstname;

    @SerializedName("LAST_NAME")
    public String applicantLastname;

    @SerializedName("ASSIGNED_BLO_ID")
    public ArrayList<ArrayList<String>> assignedBloId;

    @SerializedName("BLO_FIELD_REMARK")
    public ArrayList<ArrayList<String>> bloFieldRrk;

    @SerializedName("BLO_OUTPUT")
    public ArrayList<ArrayList<String>> bloOutput1;

    @SerializedName("BLO_VERFIED_STATUS")
    public String bloVerifStatus;

    @SerializedName("BLO_VERIFY")
    public ArrayList<ArrayList<String>> bloVerify;

    @SerializedName("DATE_OF_INCLUSION")
    public String dateofinclusion;

    @SerializedName("EPIC_NUMBER")
    public String epicnumber;

    @SerializedName("FORM_7")
    public ArrayList<ArrayList<String>> form7is;

    @SerializedName("FORM_8")
    public ArrayList<ArrayList<String>> form8is;

    @SerializedName("GENDER")
    public String gender;

    @SerializedName("PART_NUMBER")
    public String partnumber;

    @SerializedName("PHOTOGRAPH")
    public String photo;

    @SerializedName("PSEREMARKLIST")
    public JsonArray pseRemarkList;

    @SerializedName("PSE_ID")
    public String pseid;

    @SerializedName("RELATION_FIRST_NAME")
    public String relationfirstname;

    @SerializedName("RELATION_LAST_NAME")
    public String relationlastname;

    @SerializedName("RELATION_TYPE")
    public String relationtype;

    @SerializedName("SERIAL_NO")
    public String serialno;

    public clusterDetailsModel(String applicantFirstname, String applicantLastname, String epicnumber, String ac, String partnumber, String age, String gender, String relationfirstname, String relationlastname, String relationtype, String address, String serialno, String pseid, String dateofinclusion, String bloVerifStatus, String photo, ArrayList<ArrayList<String>> bloVerify, ArrayList<ArrayList<String>> assignedBloId, ArrayList<ArrayList<String>> bloOutput1, ArrayList<ArrayList<String>> bloFieldRrk, ArrayList<ArrayList<String>> form7is, ArrayList<ArrayList<String>> form8is, JsonArray pseRemarkList) {
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
        this.bloVerify = bloVerify;
        this.assignedBloId = assignedBloId;
        this.bloOutput1 = bloOutput1;
        this.bloFieldRrk = bloFieldRrk;
        this.form7is = form7is;
        this.form8is = form8is;
        this.pseRemarkList = pseRemarkList;
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

    public JsonArray getPseRemarkList() {
        return this.pseRemarkList;
    }

    public void setPseRemarkList(JsonArray pseRemarkList) {
        this.pseRemarkList = pseRemarkList;
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

    public String getSerialno() {
        return this.serialno;
    }

    public void setSerialno(String serialno) {
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

    public ArrayList<ArrayList<String>> getBloVerify() {
        return this.bloVerify;
    }

    public void setBloVerify(ArrayList<ArrayList<String>> bloVerify) {
        this.bloVerify = bloVerify;
    }

    public ArrayList<ArrayList<String>> getAssignedBloId() {
        return this.assignedBloId;
    }

    public void setAssignedBloId(ArrayList<ArrayList<String>> assignedBloId) {
        this.assignedBloId = assignedBloId;
    }

    public ArrayList<ArrayList<String>> getBloOutput1() {
        return this.bloOutput1;
    }

    public void setBloOutput1(ArrayList<ArrayList<String>> bloOutput1) {
        this.bloOutput1 = bloOutput1;
    }

    public ArrayList<ArrayList<String>> getBloFieldRrk() {
        return this.bloFieldRrk;
    }

    public void setBloFieldRrk(ArrayList<ArrayList<String>> bloFieldRrk) {
        this.bloFieldRrk = bloFieldRrk;
    }

    public ArrayList<ArrayList<String>> getForm7is() {
        return this.form7is;
    }

    public void setForm7is(ArrayList<ArrayList<String>> form7is) {
        this.form7is = form7is;
    }

    public ArrayList<ArrayList<String>> getForm8is() {
        return this.form8is;
    }

    public void setForm8is(ArrayList<ArrayList<String>> form8is) {
        this.form8is = form8is;
    }
}
