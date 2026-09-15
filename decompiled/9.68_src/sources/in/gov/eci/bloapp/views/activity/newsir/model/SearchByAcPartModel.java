package in.gov.eci.bloapp.views.activity.newsir.model;

import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SearchByAcPartModel {
    public Object file;
    public String message;
    public List<Payload> payload;
    public Object refId;
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

    public List<Payload> getPayload() {
        return this.payload;
    }

    public void setPayload(List<Payload> payload) {
        this.payload = payload;
    }

    public Object getFile() {
        return this.file;
    }

    public void setFile(Object file) {
        this.file = file;
    }
}
