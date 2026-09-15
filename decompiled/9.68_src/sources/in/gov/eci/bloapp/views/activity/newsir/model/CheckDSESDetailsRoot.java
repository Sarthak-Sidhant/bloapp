package in.gov.eci.bloapp.views.activity.newsir.model;

import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CheckDSESDetailsRoot {
    public String file;
    public String message;
    public List<CheckDSEDetailsPayload> payload;
    public Object refId;
    public String status;
    public int statusCode;

    public String getFile() {
        return this.file;
    }

    public void setFile(String file) {
        this.file = file;
    }

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

    public Object getRefId() {
        return this.refId;
    }

    public void setRefId(Object refId) {
        this.refId = refId;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CheckDSEDetailsPayload> getPayload() {
        return this.payload;
    }

    public void setPayload(List<CheckDSEDetailsPayload> payload) {
        this.payload = payload;
    }
}
