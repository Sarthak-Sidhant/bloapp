package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class HouseDetailModel {

    @SerializedName("AGE")
    public String age;

    @SerializedName("FIRST_NAME")
    public String applicantname;

    @SerializedName("EPIC_NUMBER")
    public String epicnumber;

    @SerializedName("RELATIVE_FIRST_NAME")
    public String relativename;

    @SerializedName("SECTION_NAME")
    public String sectionName;

    @SerializedName("SECTION_NO")
    public String sectionNo;

    @SerializedName("VERIFIED")
    public String status;

    public String getApplicantname() {
        return this.applicantname;
    }

    public String getEpicnumber() {
        return this.epicnumber;
    }

    public String getAge() {
        return this.age;
    }

    public String getRelativename() {
        return this.relativename;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSectionNo() {
        return this.sectionNo;
    }

    public String getSectionName() {
        return this.sectionName;
    }

    public HouseDetailModel(String applicantname, String epicnumber, String age, String relativename, String status, String sectionNo, String sectionName) {
        this.applicantname = applicantname;
        this.epicnumber = epicnumber;
        this.age = age;
        this.relativename = relativename;
        this.status = status;
        this.sectionNo = sectionNo;
        this.sectionName = sectionName;
    }
}
