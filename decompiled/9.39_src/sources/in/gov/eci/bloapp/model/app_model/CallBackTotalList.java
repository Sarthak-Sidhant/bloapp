package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class CallBackTotalList {

    @SerializedName("acNo")
    public String acNo;

    @SerializedName("bloCallAcknowledged")
    public String bloCallAcknowledged;

    @SerializedName("callbackStatus")
    public String callbackStatus;

    @SerializedName("createdDttm")
    public String createdDttm;

    @SerializedName("epicNumber")
    public String epic;

    @SerializedName("isContacted")
    public String isContacted;

    @SerializedName("mobileNumber")
    public String mobNo;

    @SerializedName("modified_dttm")
    public String modified_dttm;

    @SerializedName("partNo")
    public String partNo;

    @SerializedName("referenceNumber")
    public String refNo;

    @SerializedName("id")
    public String requestNo;

    @SerializedName("voterAddress")
    public String voterAddress;

    @SerializedName("voterName")
    public String voterName;

    public CallBackTotalList(String requestNo, String epic, String refNo, String voterName, String voterAddress, String mobNo, String acNo, String partNo, String isContacted, String createdDttm, String modified_dttm, String callbackStatus, String bloCallAcknowledged) {
        this.requestNo = requestNo;
        this.epic = epic;
        this.refNo = refNo;
        this.voterName = voterName;
        this.voterAddress = voterAddress;
        this.mobNo = mobNo;
        this.acNo = acNo;
        this.partNo = partNo;
        this.isContacted = isContacted;
        this.createdDttm = createdDttm;
        this.modified_dttm = modified_dttm;
        this.callbackStatus = callbackStatus;
        this.bloCallAcknowledged = bloCallAcknowledged;
    }

    public String getRequestNo() {
        return this.requestNo;
    }

    public String getEpic() {
        return this.epic;
    }

    public String getBloCallAcknowledged() {
        return this.bloCallAcknowledged;
    }

    public String getRefNo() {
        return this.refNo;
    }

    public String getVoterName() {
        return this.voterName;
    }

    public String getVoterAddress() {
        return this.voterAddress;
    }

    public String getMobNo() {
        return this.mobNo;
    }

    public String getAcNo() {
        return this.acNo;
    }

    public String getPartNo() {
        return this.partNo;
    }

    public String getIsContacted() {
        return this.isContacted;
    }

    public String getCreatedDttm() {
        return this.createdDttm;
    }

    public String getModified_dttm() {
        return this.modified_dttm;
    }

    public String getCallbackStatus() {
        return this.callbackStatus;
    }
}
