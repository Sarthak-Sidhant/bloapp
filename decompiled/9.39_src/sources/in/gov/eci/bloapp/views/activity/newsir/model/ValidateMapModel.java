package in.gov.eci.bloapp.views.activity.newsir.model;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ValidateMapModel {
    public String bloName;
    public String bloNumber;
    public String msg;
    public ValidatePayload payload;
    public String refId;
    public boolean status;
    public int statusCode;

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getRefId() {
        return this.refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public ValidatePayload getPayload() {
        return this.payload;
    }

    public void setPayload(ValidatePayload payload) {
        this.payload = payload;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBloNumber() {
        return this.bloNumber;
    }

    public void setBloNumber(String bloNumber) {
        this.bloNumber = bloNumber;
    }

    public String getBloName() {
        return this.bloName;
    }

    public void setBloName(String bloName) {
        this.bloName = bloName;
    }
}
