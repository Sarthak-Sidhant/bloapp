package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AllHousesModel {

    @SerializedName("REQUEST_TYPE")
    public String applicantName;

    @SerializedName("FIRST_NAME")
    public String houseno;

    @SerializedName("LAST_NAME")
    public String noofpeople;

    @SerializedName("REFERENCE_ID")
    public String sectionName;

    @SerializedName("CREATED_ON")
    public String sectionNumber;

    @SerializedName("EPIC_NUMBER")
    public String status;

    public AllHousesModel(String houseno, String noofpeople, String status, String applicantName, String sectionNumber, String sectionName) {
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
