package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class TodayListModel {

    @SerializedName("VILLAGE")
    public String address;

    @SerializedName("CREATED_ON")
    public String date;

    @SerializedName("EMAIL_ID")
    public String email;

    @SerializedName("EPIC_NUMBER")
    public String epicNo;

    @SerializedName("FIRST_NAME")
    public String firstName;

    @SerializedName("REQUEST_TYPE")
    public String formType;

    @SerializedName("MOBILE_NUMBER")
    public String mobNo;

    @SerializedName("REFERENCE_ID")
    public String referenceId;

    public TodayListModel(String firstName, String date, String address, String formType, String referenceId, String epicNo, String mobNo, String email) {
        this.firstName = firstName;
        this.date = date;
        this.address = address;
        this.formType = formType;
        this.referenceId = referenceId;
        this.epicNo = epicNo;
        this.mobNo = mobNo;
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getDate() {
        return this.date;
    }

    public String getAddress() {
        return this.address;
    }

    public String getFormType() {
        return this.formType;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public String getEpicNo() {
        return this.epicNo;
    }

    public String getMobNo() {
        return this.mobNo;
    }

    public String getEmail() {
        return this.email;
    }
}
