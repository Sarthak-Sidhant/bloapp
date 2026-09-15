package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AllApplicationsModel {

    @SerializedName("CREATED_ON")
    public String createdOn;

    @SerializedName("EPIC_NUMBER")
    public String epicNum;

    @SerializedName("FIRST_NAME")
    public String firstName;

    @SerializedName("LAST_NAME")
    public String lastName;

    @SerializedName("REFERENCE_ID")
    public String referenceId;

    @SerializedName("REQUEST_TYPE")
    public String requestType;

    @SerializedName("STATUS")
    public String status;

    public AllApplicationsModel(String firstName, String lastName, String epicNum, String status, String createdOn, String requestType, String referenceId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.epicNum = epicNum;
        this.status = status;
        this.createdOn = createdOn;
        this.requestType = requestType;
        this.referenceId = referenceId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEpicNum() {
        return this.epicNum;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public String getReferenceId() {
        return this.referenceId;
    }
}
