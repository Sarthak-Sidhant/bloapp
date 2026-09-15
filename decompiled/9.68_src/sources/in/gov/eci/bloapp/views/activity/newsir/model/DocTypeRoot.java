package in.gov.eci.bloapp.views.activity.newsir.model;

import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DocTypeRoot {
    public String message;
    public List<DocumentPayload> payload;
    public String refId;
    public String status;
    public int statusCode;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
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

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DocumentPayload> getPayload() {
        return this.payload;
    }

    public void setPayload(List<DocumentPayload> payload) {
        this.payload = payload;
    }
}
