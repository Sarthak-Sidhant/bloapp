package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class HouseModel {

    @SerializedName("applicantName")
    public String applicantName;

    @SerializedName("houseno")
    public String houseno;

    @SerializedName("noofpeople")
    public String noofpeople;

    @SerializedName("sectionName")
    public String sectionName;

    @SerializedName("sectionNumber")
    public String sectionNumber;

    @SerializedName("status")
    public String status;

    public HouseModel(String houseno, String noofpeople, String status, String applicantName, String sectionNumber, String sectionName) {
        this.houseno = houseno;
        this.noofpeople = noofpeople;
        this.status = status;
        this.applicantName = applicantName;
        this.sectionNumber = sectionNumber;
        this.sectionName = sectionName;
    }

    public String getHouseNo() {
        return this.houseno;
    }

    public String getNoofpeople() {
        return this.noofpeople;
    }

    public String getStatus() {
        return this.status;
    }

    public String getApplicantName() {
        return this.applicantName;
    }

    public String getSectionNumber() {
        return this.sectionNumber;
    }

    public String getSectionName() {
        return this.sectionName;
    }
}
